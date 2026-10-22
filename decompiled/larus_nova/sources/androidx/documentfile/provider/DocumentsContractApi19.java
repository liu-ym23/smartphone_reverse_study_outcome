package androidx.documentfile.provider;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.text.TextUtils;
import f06.b;
import f06.c;
import f06.d;

/* JADX INFO: loaded from: classes17.dex */
class DocumentsContractApi19 {
    private static final int FLAG_VIRTUAL_DOCUMENT = 512;
    private static final String TAG = "DocumentFile";

    private DocumentsContractApi19() {
    }

    private static void closeQuietly(AutoCloseable r100) {
        if (r100 != null) goto L9;
        return;
    L9:
        r100.close();     // Catch: RuntimeException -> L5 Exception -> L8
        goto L12
    L11:
        return;
    L5:
        e = move-exception;
        throw e;
    }

    public static boolean canRead(Context r100, Uri r101) {
        if (r100.checkCallingOrSelfUriPermission(r101, 1) == 0) goto L6;
        return false;
    L6:
        if (TextUtils.isEmpty(getRawType(r100, r101)) == false) goto L8;
        return false;
    L8:
        return true;
    }

    public static boolean canWrite(Context r100, Uri r101) {
        if (r100.checkCallingOrSelfUriPermission(r101, 2) == 0) goto L5;
        return false;
    L5:
        String r102 = getRawType(r100, r101);
        int r103 = queryForInt(r100, r101, "flags", 0);
        if (TextUtils.isEmpty(r102) == false) goto L9;
        return false;
    L9:
        if ((r103 & 4) == 0) goto L12;
        return true;
    L12:
        if ("vnd.android.document/directory".equals(r102) == false) goto L17;
        if ((r103 & 8) == 0) goto L17;
        return true;
    L17:
        if (TextUtils.isEmpty(r102) == false) goto L19;
    L21:
        return false;
    L19:
        if ((r103 & 2) == 0) goto L21;
        return true;
    }

    public static boolean exists(Context r100, Uri r101) {
        ContentResolver r102 = r100.getContentResolver();
        boolean r103 = false;
        Cursor r104 = null;
        r104 = androidx_documentfile_provider_DocumentsContractApi19_android_content_ContentResolver_query(r102, r101, new String[]{"document_id"}, null, null, null);     // Catch: Throwable -> L8 Exception -> L10
        if (r104.getCount() <= 0) goto L6;
        r103 = true;
    L6:
        closeQuietly(r104);
        return r103;
    L10:
        e = move-exception;
        e.toString();     // Catch: Throwable -> L8
        closeQuietly(r104);
        return false;
    L8:
        th = move-exception;
        closeQuietly(r104);
        throw th;
    }

    public static long getFlags(Context r100, Uri r101) {
        return queryForLong(r100, r101, "flags", 0);
    }

    public static String getName(Context r100, Uri r101) {
        return queryForString(r100, r101, "_display_name", null);
    }

    private static String getRawType(Context r100, Uri r101) {
        return queryForString(r100, r101, "mime_type", null);
    }

    public static String getType(Context r100, Uri r101) {
        String r102 = getRawType(r100, r101);
        if ("vnd.android.document/directory".equals(r102) == false) goto L6;
        return null;
    L6:
        return r102;
    }

    public static boolean isDirectory(Context r100, Uri r101) {
        return "vnd.android.document/directory".equals(getRawType(r100, r101));
    }

    public static boolean isFile(Context r100, Uri r101) {
        String r102 = getRawType(r100, r101);
        if ("vnd.android.document/directory".equals(r102) == false) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r102) == true) goto L11;
        return true;
    L11:
        return false;
    }

    public static boolean isVirtual(Context r100, Uri r101) {
        if (DocumentsContract.isDocumentUri(r100, r101) == true) goto L6;
        return false;
    L6:
        if ((getFlags(r100, r101) & 512) == 0) goto L9;
        return true;
    L9:
        return false;
    }

    public static long lastModified(Context r100, Uri r101) {
        return queryForLong(r100, r101, "last_modified", 0);
    }

    public static long length(Context r100, Uri r101) {
        return queryForLong(r100, r101, "_size", 0);
    }

    private static int queryForInt(Context r100, Uri r101, String r102, int r103) {
        return (int) queryForLong(r100, r101, r102, r103);
    }

    private static long queryForLong(Context r100, Uri r101, String r102, long r110) {
        Cursor r103 = null;
        r103 = androidx_documentfile_provider_DocumentsContractApi19_android_content_ContentResolver_query(r100.getContentResolver(), r101, new String[]{r102}, null, null, null);     // Catch: Throwable -> L12 Exception -> L14
        if (r103.moveToFirst() == true) goto L6;
    L10:
        closeQuietly(r103);
        return r110;
    L6:
        if (r103.isNull(0) == true) goto L10;
        long r104 = r103.getLong(0);     // Catch: Throwable -> L12 Exception -> L14
        closeQuietly(r103);
        return r104;
    L14:
        e = move-exception;
        e.toString();     // Catch: Throwable -> L12
        closeQuietly(r103);
        return r110;
    L12:
        th = move-exception;
        closeQuietly(r103);
        throw th;
    }

    private static String queryForString(Context r100, Uri r101, String r102, String r110) {
        Cursor r103 = null;
        r103 = androidx_documentfile_provider_DocumentsContractApi19_android_content_ContentResolver_query(r100.getContentResolver(), r101, new String[]{r102}, null, null, null);     // Catch: Throwable -> L12 Exception -> L14
        if (r103.moveToFirst() == true) goto L6;
    L10:
        closeQuietly(r103);
        return r110;
    L6:
        if (r103.isNull(0) == true) goto L10;
        String r104 = r103.getString(0);     // Catch: Throwable -> L12 Exception -> L14
        closeQuietly(r103);
        return r104;
    L14:
        e = move-exception;
        e.toString();     // Catch: Throwable -> L12
        closeQuietly(r103);
        return r110;
    L12:
        th = move-exception;
        closeQuietly(r103);
        throw th;
    }

    private static Cursor androidx_documentfile_provider_DocumentsContractApi19_android_content_ContentResolver_query(ContentResolver r110, Uri r111, String[] r112, String r113, String[] r114, String r115) {
        c r100 = new c();
        Object[] r101 = {r111, r112, r113, r114, r115};
        b r116 = new b();
        d r117 = r100.b(240004, "android/content/ContentResolver", "query", r110, r101, "android.database.Cursor", r116);
        if (r117.f474982a == false) goto L6;
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, null, r116, false);
        return (Cursor) r117.f474983b;
    L6:
        Cursor r118 = r110.query(r111, r112, r113, r114, r115);
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, r118, r116, true);
        return r118;
    }
}
