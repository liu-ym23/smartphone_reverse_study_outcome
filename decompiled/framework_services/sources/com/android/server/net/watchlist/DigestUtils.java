package com.android.server.net.watchlist;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: classes2.dex */
public class DigestUtils {
    private static final int FILE_READ_BUFFER_SIZE = 16384;

    private DigestUtils() {
    }

    public static byte[] getSha256Hash(File apkFile) throws IOException, NoSuchAlgorithmException {
        InputStream stream = new FileInputStream(apkFile);
        byte[] r1 = getSha256Hash(stream);     // Catch: Throwable -> L6
        stream.close();
        return r1;
    L6:
        th = move-exception;
        stream.close();     // Catch: Throwable -> L9
    L11:
        throw th;
    L9:
        th = move-exception;
        th.addSuppressed(th);
        goto L11
    }

    public static byte[] getSha256Hash(InputStream stream) throws IOException, NoSuchAlgorithmException {
        MessageDigest digester = MessageDigest.getInstance("SHA256");
        byte[] buf = new byte[16384];
    L3:
        int bytesRead = stream.read(buf);
        if (bytesRead < 0) goto L7;
        digester.update(buf, 0, bytesRead);
        goto L3
    L7:
        return digester.digest();
    }
}
