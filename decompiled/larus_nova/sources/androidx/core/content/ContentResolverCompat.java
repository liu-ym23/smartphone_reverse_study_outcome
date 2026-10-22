package androidx.core.content;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.OperationCanceledException;

/* JADX INFO: loaded from: classes17.dex */
public final class ContentResolverCompat {
    private ContentResolverCompat() {
    }

    private static Cursor androidx_core_content_ContentResolverCompat_android_content_ContentResolver_query(ContentResolver r110, Uri r111, String[] r112, String r113, String[] r114, String r115, CancellationSignal r116) {
        f06.c r100 = new f06.c();
        Object[] r101 = {r111, r112, r113, r114, r115, r116};
        f06.b r117 = new f06.b();
        f06.d r118 = r100.b(240004, "android/content/ContentResolver", "query", r110, r101, "android.database.Cursor", r117);
        if (r118.f474982a == false) goto L6;
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, null, r117, false);
        return (Cursor) r118.f474983b;
    L6:
        Cursor r119 = r110.query(r111, r112, r113, r114, r115, r116);
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, r119, r117, true);
        return r119;
    }

    public static Cursor query(ContentResolver r100, Uri r101, String[] r102, String r110, String[] r111, String r112, androidx.core.os.CancellationSignal r113) {
        if (r113 == null) goto L4;
        CancellationSignal r114 = (CancellationSignal) r113.getCancellationSignalObject();
    L6:
        return query(r100, r101, r102, r110, r111, r112, r114);
    L4:
        r114 = null;
        goto L6
    }

    public static Cursor query(ContentResolver r100, Uri r101, String[] r102, String r103, String[] r104, String r105, CancellationSignal r106) {
        return androidx_core_content_ContentResolverCompat_android_content_ContentResolver_query(r100, r101, r102, r103, r104, r105, r106);
    L4:
        e = move-exception;
        if ((e instanceof OperationCanceledException) == true) goto L8;
        throw e;
    L8:
        throw new androidx.core.os.OperationCanceledException();
    }
}
