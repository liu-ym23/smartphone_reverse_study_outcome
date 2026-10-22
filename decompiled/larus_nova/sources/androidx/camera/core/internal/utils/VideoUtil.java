package androidx.camera.core.internal.utils;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import androidx.camera.core.Logger;
import androidx.core.util.Preconditions;
import f06.b;
import f06.c;
import f06.d;

/* JADX INFO: loaded from: classes2.dex */
public final class VideoUtil {
    private static final String TAG = "VideoUtil";

    private VideoUtil() {
    }

    public static String getAbsolutePathFromUri(ContentResolver r100, Uri r101) {
        Cursor r102 = null;
        r102 = androidx_camera_core_internal_utils_VideoUtil_android_content_ContentResolver_query(r100, r101, new String[]{"_data"}, null, null, null);     // Catch: RuntimeException -> L11 Throwable -> L16
        Cursor r103 = (Cursor) Preconditions.checkNotNull(r102);     // Catch: RuntimeException -> L11 Throwable -> L16
        int r104 = r103.getColumnIndexOrThrow("_data");     // Catch: Throwable -> L7 RuntimeException -> L9
        r103.moveToFirst();     // Catch: Throwable -> L7 RuntimeException -> L9
        String r105 = r103.getString(r104);     // Catch: Throwable -> L7 RuntimeException -> L9
        r103.close();
        return r105;
    L9:
        e = e;
        r102 = r103;
    L12:
        Logger.e(TAG, String.format("Failed in getting absolute path for Uri %s with Exception %s", new Object[]{r101.toString(), e.toString()}));     // Catch: Throwable -> L16
        if (r102 == null) goto L15;
        r102.close();
    L15:
        return "";
    L7:
        th = th;
        r102 = r103;
    L17:
        if (r102 == null) goto L19;
        r102.close();
    L19:
        throw th;
    L16:
        th = th;
    L11:
        e = e;
        goto L12
    }

    private static Cursor androidx_camera_core_internal_utils_VideoUtil_android_content_ContentResolver_query(ContentResolver r110, Uri r111, String[] r112, String r113, String[] r114, String r115) {
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
