package androidx.camera.video.internal.utils;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import androidx.camera.core.Logger;
import f06.b;
import f06.c;
import f06.d;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public final class OutputUtil {
    private static final String TAG = "OutputUtil";

    private OutputUtil() {
    }

    public static boolean createParentFolder(File r100) {
        File r101 = r100.getParentFile();
        if (r101 != null) goto L7;
        return false;
    L7:
        if (r101.exists() == false) goto L10;
        return r101.isDirectory();
    L10:
        return r101.mkdirs();
    }

    public static String getAbsolutePathFromUri(ContentResolver r100, Uri r110, String r111) {
        Cursor r101 = null;
        Cursor r102 = androidx_camera_video_internal_utils_OutputUtil_android_content_ContentResolver_query(r100, r110, new String[]{r111}, null, null, null);     // Catch: Throwable -> L13 RuntimeException -> L15
        if (r102 != null) goto L26;
        if (r102 == null) goto L7;
        r102.close();
    L7:
        return null;
    L26:
        int r112 = r102.getColumnIndexOrThrow(r111);     // Catch: RuntimeException -> L11 Throwable -> L21
        r102.moveToFirst();     // Catch: RuntimeException -> L11 Throwable -> L21
        String r113 = r102.getString(r112);     // Catch: RuntimeException -> L11 Throwable -> L21
        r102.close();
        return r113;
    L11:
        e = e;
    L17:
        Logger.e(TAG, String.format("Failed in getting absolute path for Uri %s with Exception %s", new Object[]{r110.toString(), e.toString()}));     // Catch: Throwable -> L21
        if (r102 == null) goto L20;
        r102.close();
    L20:
        return null;
    L21:
        th = th;
        r101 = r102;
    L23:
        if (r101 == null) goto L25;
        r101.close();
    L25:
        throw th;
    L15:
        e = e;
        r102 = null;
    L13:
        th = th;
        goto L23
    }

    private static Cursor androidx_camera_video_internal_utils_OutputUtil_android_content_ContentResolver_query(ContentResolver r110, Uri r111, String[] r112, String r113, String[] r114, String r115) {
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
