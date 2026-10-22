package com.ttnet.org.chromium.base;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.provider.DocumentsContract;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import androidx.annotation.Nullable;
import com.bytedance.librarian.LibrarianImpl;
import com.ttnet.org.chromium.base.annotations.CalledByNative;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ContentUriUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static FileProviderUtil f18243a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f18244b = null;

    public interface FileProviderUtil {
        Uri getContentUriFromFile(File r10);
    }

    static {
        f18244b = new Object();
    }

    public static AssetFileDescriptor a(String r10) {
        ContentResolver r11 = e.d().getContentResolver();
        Uri r12 = Uri.parse(r10);
    L17:
        e = move-exception;
        j.h("ContentUriUtils", "Cannot open content uri: %s", new Object[]{r10, e});
    L27:
        return null;
    L4:
        if (e(r12) == false) goto L22;
        String[] r13 = r11.getStreamTypes(r12, "*/*");     // Catch: Exception -> L17
        if (r13 == null) goto L27;
        if (r13.length <= 0) goto L27;
        AssetFileDescriptor r14 = r11.openTypedAssetFileDescriptor(r12, r13[0], null);     // Catch: Exception -> L17
        if (r14 != null) goto L13;
    L21:
        return r14;
    L13:
        if (r14.getStartOffset() == 0) goto L21;
        r14.close();     // Catch: Exception -> L17 IOException -> L28
    L20:
        throw new SecurityException("Cannot open files with non-zero offset type.");     // Catch: Exception -> L17
    L22:
        ParcelFileDescriptor r15 = r11.openFileDescriptor(r12, "r");     // Catch: Exception -> L17
        if (r15 == null) goto L27;
        return new AssetFileDescriptor(r15, 0, -1);
    }

    public static Uri b(File r10) {
        Object r11 = f18244b;
        monitor-enter(r11);
        FileProviderUtil r12 = f18243a;     // Catch: Throwable -> L9
        if (r12 == null) goto L11;
        Uri r13 = r12.getContentUriFromFile(r10);     // Catch: Throwable -> L9
        monitor-exit(r11);     // Catch: Throwable -> L9
        return r13;
    L11:
        monitor-exit(r11);     // Catch: Throwable -> L9
        return null;
    L9:
        th = move-exception;
        throw th;
    }

    public static String c(Uri r10, Context r11, String r12) {
        if (r10 != null) goto L5;
        return "";
    L5:
        ContentResolver r13 = r11.getContentResolver();
        Cursor r14 = r13.query(r10, null, null, null, null);     // Catch: NullPointerException -> L37
        if (r14 != null) goto L38;
    L34:
        if (r14 == null) goto L36;
        r14.close();     // Catch: NullPointerException -> L37
        goto L36
    L38:
    L25:
        th = move-exception;
        r14.close();     // Catch: Throwable -> L31
    L33:
        throw th;     // Catch: NullPointerException -> L37
    L31:
        th = move-exception;
        th.addSuppressed(th);     // Catch: NullPointerException -> L37
        goto L33
    L9:
        if (r14.getCount() < 1) goto L34;
        r14.moveToFirst();     // Catch: Throwable -> L25
        int r15 = r14.getColumnIndex(r12);     // Catch: Throwable -> L25
        if (r15 != (-1)) goto L15;
        r14.close();     // Catch: NullPointerException -> L37
        return "";
    L15:
        String r16 = r14.getString(r15);     // Catch: Throwable -> L25
        if (d(r14) == false) goto L27;
        String[] r17 = r13.getStreamTypes(r10, "*/*");     // Catch: Throwable -> L25
        if (r17 == null) goto L27;
        if (r17.length <= 0) goto L27;
        String r18 = MimeTypeMap.getSingleton().getExtensionFromMimeType(r17[0]);     // Catch: Throwable -> L25
        if (r18 == null) goto L27;
        r16 = r16 + LibrarianImpl.Constants.DOT + r18;     // Catch: Throwable -> L25
    L27:
        r14.close();     // Catch: NullPointerException -> L37
        return r16;
    L36:
        return "";
    }

    @CalledByNative
    public static boolean contentUriExists(String r10) {
        AssetFileDescriptor r11 = a(r10);
        if (r11 == null) goto L5;
        boolean r12 = true;
    L6:
        if (r11 != null) goto L10;
    L8:
        return r12;
    L10:
        r11.close();     // Catch: IOException -> L9
        goto L8
    L5:
        r12 = false;
        goto L6
    }

    public static boolean d(Cursor r10) {
        int r11 = r10.getColumnIndex("flags");
        if (r11 > (-1)) goto L5;
    L7:
        return false;
    L5:
        if ((r10.getLong(r11) & 512) == 0) goto L7;
        return true;
    }

    @CalledByNative
    public static boolean delete(String r10) {
        Uri r11 = Uri.parse(r10);
        if (e.d().getContentResolver().delete(r11, null, null) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean e(Uri r10) {
        if (r10 != null) goto L6;
        return false;
    L6:
        if (DocumentsContract.isDocumentUri(e.d(), r10) == true) goto L30;
        return false;
    L30:
        Cursor r11 = e.d().getContentResolver().query(r10, null, null, null, null);     // Catch: NullPointerException -> L25
        if (r11 != null) goto L26;
    L22:
        if (r11 == null) goto L24;
        r11.close();     // Catch: NullPointerException -> L25
        goto L24
    L26:
    L16:
        th = move-exception;
        r11.close();     // Catch: Throwable -> L19
    L21:
        throw th;     // Catch: NullPointerException -> L25
    L19:
        th = move-exception;
        th.addSuppressed(th);     // Catch: NullPointerException -> L25
        goto L21
    L12:
        if (r11.getCount() < 1) goto L22;
        r11.moveToFirst();     // Catch: Throwable -> L16
        boolean r12 = d(r11);     // Catch: Throwable -> L16
        r11.close();     // Catch: NullPointerException -> L25
        return r12;
    L24:
        return false;
    }

    @CalledByNative
    public static String getContentUriFromFilePath(String r10) {
        Uri r11 = b(new File(r10));     // Catch: IllegalArgumentException -> L6
        if (r11 == null) goto L12;
        return r11.toString();
    L12:
        return null;
    L6:
        e = move-exception;
        j.a("ContentUriUtils", "Cannot retrieve content uri from file: %s", new Object[]{r10, e});
        return null;
    }

    @CalledByNative
    public static String getMimeType(String r10) {
        ContentResolver r11 = e.d().getContentResolver();
        Uri r12 = Uri.parse(r10);
        if (e(r12) == false) goto L12;
        String[] r13 = r11.getStreamTypes(r12, "*/*");
        if (r13 != null) goto L7;
    L9:
        return null;
    L7:
        if (r13.length <= 0) goto L9;
        return r13[0];
    L12:
        return r11.getType(r12);
    }

    @Nullable
    @CalledByNative
    public static String maybeGetDisplayName(String r10) {
        Uri r11 = Uri.parse(r10);
        String r12 = c(r11, e.d(), "_display_name");     // Catch: Exception -> L8
        if (TextUtils.isEmpty(r12) == false) goto L7;
        return null;
    L7:
        return r12;
    L8:
        e = move-exception;
        j.h("ContentUriUtils", "Cannot open content uri: %s", new Object[]{r10, e});
        return null;
    }

    @CalledByNative
    public static int openContentUriForRead(String r10) {
        AssetFileDescriptor r11 = a(r10);
        if (r11 != null) goto L5;
        return -1;
    L5:
        return r11.getParcelFileDescriptor().detachFd();
    }
}
