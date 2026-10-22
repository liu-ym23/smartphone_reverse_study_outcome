package com.android.server.companion.utils;

import android.os.Environment;
import android.util.AtomicFile;
import android.util.Slog;
import com.android.internal.util.FunctionalUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public final class DataStoreUtils {
    private static final String TAG = "CDM_DataStoreUtils";

    public static boolean isStartOfTag(XmlPullParser parser, String tag) throws XmlPullParserException {
        if (parser.getEventType() == 2) goto L5;
    L7:
        return false;
    L5:
        if (tag.equals(parser.getName()) == false) goto L7;
        return true;
    }

    public static boolean isEndOfTag(XmlPullParser parser, String tag) throws XmlPullParserException {
        if (parser.getEventType() == 3) goto L5;
    L7:
        return false;
    L5:
        if (tag.equals(parser.getName()) == false) goto L7;
        return true;
    }

    public static AtomicFile createStorageFileForUser(int userId, String fileName) {
        return new AtomicFile(getBaseStorageFileForUser(userId, fileName));
    }

    private static File getBaseStorageFileForUser(int userId, String fileName) {
        return new File(Environment.getDataSystemDeDirectory(userId), fileName);
    }

    public static void writeToFileSafely(AtomicFile file, FunctionalUtils.ThrowingConsumer<FileOutputStream> consumer) {
        file.write(consumer);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        Slog.e(TAG, "Error while writing to file " + file, e);
    }

    public static byte[] fileToByteArray(AtomicFile file) {
        if (file.getBaseFile().exists() == true) goto L29;
        Slog.d(TAG, "File does not exist");
        return new byte[0];
    L29:
        FileInputStream in = file.openRead();     // Catch: IOException -> L16
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();     // Catch: Throwable -> L11
        byte[] buffer = new byte[1024];     // Catch: Throwable -> L11
    L8:
        int read = in.read(buffer);     // Catch: Throwable -> L11
        if (read == (-1)) goto L13;
        bytes.write(buffer, 0, read);     // Catch: Throwable -> L11
        goto L8
    L13:
        byte[] r5 = bytes.toByteArray();     // Catch: Throwable -> L11
        in.close();     // Catch: IOException -> L16
        return r5;
    L11:
        th = move-exception;
        if (in != null) goto L27;
    L24:
        throw th;     // Catch: IOException -> L16
    L27:
        in.close();     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L16
    L16:
        e = move-exception;
        Slog.e(TAG, "Error while reading requests file", e);
        return new byte[0];
    }

    private DataStoreUtils() {
    }
}
