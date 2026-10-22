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
import com.bytedance.librarian.LibrarianImpl;
import com.obric.aikernel.sdk.ext.Params;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ContentUriUtils {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String TAG = "ContentUriUtils";
    private static FileProviderUtil sFileProviderUtil;
    private static final Object sLock = null;

    public interface FileProviderUtil {
        Uri getContentUriFromFile(File r1);
    }

    static {
        sLock = new Object();
    }

    private ContentUriUtils() {
    }

    public static void setFileProviderUtil(FileProviderUtil r1) {
        Object r0 = sLock;
        monitor-enter(r0);
        sFileProviderUtil = r1;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static Uri getContentUriFromFile(File r2) {
        Object r0 = sLock;
        monitor-enter(r0);
        FileProviderUtil r1 = sFileProviderUtil;     // Catch: Throwable -> L12
        if (r1 == null) goto L9;
        Uri r3 = r1.getContentUriFromFile(r2);     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r3;
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return null;
    L12:
        th = move-exception;
        throw th;
    }

    public static int openContentUriForRead(String r0) {
        AssetFileDescriptor r1 = getAssetFileDescriptor(r0);
        if (r1 != null) goto L5;
        return -1;
    L5:
        return r1.getParcelFileDescriptor().detachFd();
    }

    public static boolean contentUriExists(String r1) {
        AssetFileDescriptor r2 = getAssetFileDescriptor(r1);     // Catch: Throwable -> L9
        if (r2 == null) goto L5;
        boolean r0 = true;
    L6:
        if (r2 != null) goto L12;
    L8:
        return r0;
    L12:
        r2.close();     // Catch: IOException -> L11
        goto L8
    L5:
        r0 = false;
    L9:
        th = move-exception;
        throw th;
    }

    public static String getMimeType(String r2) {
        ContentResolver r0 = ContextUtils.getApplicationContext().getContentResolver();
        Uri r3 = Uri.parse(r2);
        if (isVirtualDocument(r3) == false) goto L12;
        String[] r4 = r0.getStreamTypes(r3, "*/*");
        if (r4 != null) goto L7;
    L9:
        return null;
    L7:
        if (r4.length <= 0) goto L9;
        return r4[0];
    L12:
        return r0.getType(r3);
    }

    private static AssetFileDescriptor getAssetFileDescriptor(String r11) {
        ContentResolver r0 = ContextUtils.getApplicationContext().getContentResolver();
        Uri r1 = Uri.parse(r11);
    L23:
        e = move-exception;
        Log.w(TAG, "Cannot open content uri: %s", new Object[]{r11, e});
    L25:
        return null;
    L4:
        if (isVirtualDocument(r1) == false) goto L19;
        String[] r4 = r0.getStreamTypes(r1, "*/*");     // Catch: Exception -> L23
        if (r4 == null) goto L25;
        if (r4.length <= 0) goto L25;
        AssetFileDescriptor r2 = r0.openTypedAssetFileDescriptor(r1, r4[0], null);     // Catch: Exception -> L23
        if (r2 != null) goto L13;
    L18:
        return r2;
    L13:
        if (r2.getStartOffset() == 0) goto L18;
        r2.close();     // Catch: IOException -> L26 Exception -> L23
    L17:
        throw new SecurityException("Cannot open files with non-zero offset type.");     // Catch: Exception -> L23
    L19:
        ParcelFileDescriptor r6 = r0.openFileDescriptor(r1, "r");     // Catch: Exception -> L23
        if (r6 == null) goto L25;
        return new AssetFileDescriptor(r6, 0, -1);
    }

    public static String getDisplayName(Uri r7, Context r8, String r9) {
        if (r7 != null) goto L5;
        return "";
    L5:
        ContentResolver r10 = r8.getContentResolver();
        Cursor r1 = r10.query(r7, null, null, null, null);     // Catch: NullPointerException -> L38
        if (r1 != null) goto L42;
    L35:
        if (r1 == null) goto L37;
        r1.close();     // Catch: NullPointerException -> L38
        goto L37
    L42:
    L28:
        th = move-exception;
        if (r1 != null) goto L39;
    L34:
        throw th;     // Catch: NullPointerException -> L38
    L39:
        r1.close();     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        th.addSuppressed(th);     // Catch: NullPointerException -> L38
        goto L34
    L9:
        if (r1.getCount() < 1) goto L35;
        r1.moveToFirst();     // Catch: Throwable -> L28
        int r11 = r1.getColumnIndex(r9);     // Catch: Throwable -> L28
        if (r11 != (-1)) goto L16;
        if (r1 == null) goto L15;
        r1.close();     // Catch: NullPointerException -> L38
    L15:
        return "";
    L16:
        String r12 = r1.getString(r11);     // Catch: Throwable -> L28
        if (hasVirtualFlag(r1) == false) goto L25;
        String[] r13 = r10.getStreamTypes(r7, "*/*");     // Catch: Throwable -> L28
        if (r13 == null) goto L25;
        if (r13.length <= 0) goto L25;
        String r14 = MimeTypeMap.getSingleton().getExtensionFromMimeType(r13[0]);     // Catch: Throwable -> L28
        if (r14 == null) goto L25;
        r12 = r12 + LibrarianImpl.Constants.DOT + r14;     // Catch: Throwable -> L28
    L25:
        if (r1 == null) goto L27;
        r1.close();     // Catch: NullPointerException -> L38
    L27:
        return r12;
    L37:
        return "";
    }

    public static String maybeGetDisplayName(String r4) {
        String r0 = getDisplayName(Uri.parse(r4), ContextUtils.getApplicationContext(), "_display_name");     // Catch: Exception -> L8
        if (TextUtils.isEmpty(r0) == false) goto L7;
        return null;
    L7:
        return r0;
    L8:
        e = move-exception;
        Log.w(TAG, "Cannot open content uri: %s", new Object[]{r4, e});
        return null;
    }

    private static boolean isVirtualDocument(Uri r8) {
        if (r8 != null) goto L6;
        return false;
    L6:
        if (DocumentsContract.isDocumentUri(ContextUtils.getApplicationContext(), r8) == true) goto L32;
        return false;
    L32:
        Cursor r9 = ContextUtils.getApplicationContext().getContentResolver().query(r8, null, null, null, null);     // Catch: NullPointerException -> L27
        if (r9 != null) goto L28;
    L24:
        if (r9 == null) goto L26;
        r9.close();     // Catch: NullPointerException -> L27
        goto L26
    L28:
    L17:
        th = move-exception;
        if (r9 != null) goto L30;
    L23:
        throw th;     // Catch: NullPointerException -> L27
    L30:
        r9.close();     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        th.addSuppressed(th);     // Catch: NullPointerException -> L27
        goto L23
    L12:
        if (r9.getCount() < 1) goto L24;
        r9.moveToFirst();     // Catch: Throwable -> L17
        boolean r1 = hasVirtualFlag(r9);     // Catch: Throwable -> L17
        if (r9 == null) goto L16;
        r9.close();     // Catch: NullPointerException -> L27
    L16:
        return r1;
    L26:
        return false;
    }

    private static boolean hasVirtualFlag(Cursor r4) {
        int r0 = r4.getColumnIndex("flags");
        if (r0 > (-1)) goto L5;
    L7:
        return false;
    L5:
        if ((r4.getLong(r0) & 512) == 0) goto L7;
        return true;
    }

    public static boolean isContentUri(String r2) {
        if (r2 != null) goto L5;
        return false;
    L5:
        Uri r3 = Uri.parse(r2);
        if (r3 != null) goto L8;
        return false;
    L8:
        if (Params.CONTENT.equals(r3.getScheme()) == false) goto L12;
        return true;
    L12:
        return false;
    }

    public static boolean delete(String r2) {
        Uri r3 = Uri.parse(r2);
        if (ContextUtils.getApplicationContext().getContentResolver().delete(r3, null, null) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static String getContentUriFromFilePath(String r3) {
        Uri r0 = getContentUriFromFile(new File(r3));     // Catch: IllegalArgumentException -> L6
        if (r0 == null) goto L12;
        return r0.toString();
    L12:
        return null;
    L6:
        e = move-exception;
        Log.e(TAG, "Cannot retrieve content uri from file: %s", new Object[]{r3, e});
        return null;
    }
}
