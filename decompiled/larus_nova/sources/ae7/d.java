package ae7;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes22.dex */
public final class d {
    public static ParcelFileDescriptor a(ContentResolver r210, Uri r211) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r211, "r"};
        f06.b r110 = new f06.b();
        g06.a r102 = ApiHookConfig.f245611b.get(240020);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r111 = r103;
        int r104 = r111.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r111[r105];
        int r112 = r105;
        int r113 = r104;
        f06.a[] r114 = r111;
        f06.d r107 = r106.preInvoke(240020, "android/content/ContentResolver", "openFileDescriptor", r210, r101, "android.os.ParcelFileDescriptor", r110);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return (ParcelFileDescriptor) r107.f474983b;
    L21:
        return ContentResolverWrapper.openFileDescriptor(r210, r211, "r");
    L14:
        r105 = r112 + 1;
        r104 = r113;
        r111 = r114;
        goto L8
    L15:
        r107 = new f06.d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    public static String c(Context r100, Uri r101, String r102, String[] r103) {
        Cursor r104 = null;
        Cursor r105 = b(r100.getContentResolver(), r101, new String[]{"_data"}, r102, r103);     // Catch: Throwable -> L15 IllegalArgumentException -> L20
        if (r105 != null) goto L26;
    L13:
        if (r105 != null) goto L22;
    L23:
        return null;
    L22:
        r105.close();
        goto L23
    L26:
    L10:
        Throwable th10 = th;
        r104 = r105;
    L17:
        if (r104 == null) goto L28;
        r104.close();
        throw th10;
    L28:
        throw th10;
    L6:
        if (r105.moveToFirst() == false) goto L13;
        String r106 = r105.getString(r105.getColumnIndexOrThrow("_data"));     // Catch: Throwable -> L10 IllegalArgumentException -> L12
        r105.close();
        return r106;
    L21:
        if (r105 == null) goto L23;
    L20:
        r105 = null;
    L15:
        th = move-exception;
        th10 = th;
        goto L17
    }

    public static Cursor b(ContentResolver r110, Uri r111, String[] r112, String r113, String[] r114) {
        f06.c r100 = new f06.c();
        Object[] r101 = {r111, r112, r113, r114, null};
        f06.b r115 = new f06.b();
        f06.d r116 = r100.b(240004, "android/content/ContentResolver", "query", r110, r101, "android.database.Cursor", r115);
        if (r116.f474982a == false) goto L6;
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, null, r115, false);
        return (Cursor) r116.f474983b;
    L6:
        Cursor r117 = r110.query(r111, r112, r113, r114, null);
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, r117, r115, true);
        return r117;
    }
}
