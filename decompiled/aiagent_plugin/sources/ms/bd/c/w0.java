package ms.bd.c;

import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public final class w0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f39672a;

    public w0(Context r3) {
        this.f39672a = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
    }

    private static String a(Cursor r9) {
        Cursor r10 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r9, Cursor.class, "com.obric.aiagent.plugin");
        String r0 = null;
        if (r10 != null) goto L6;
        return null;
    L6:
        if (r10.isClosed() == false) goto L8;
        return null;
    L8:
        r10.moveToFirst();
        int r2 = r10.getColumnIndex((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "ec5ad6", new byte[]{98, 96, 74, 0, 94}), String.class, "com.obric.aiagent.plugin"));
        if (r2 <= 0) goto L11;
        r0 = r10.getString(r2);
    L11:
        int r3 = r10.getColumnIndex((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "bea170", new byte[]{112, 104, 22, 64}), String.class, "com.obric.aiagent.plugin"));
        if (r3 <= 0) goto L14;
        r10.getInt(r3);
    L14:
        int r1 = r10.getColumnIndex((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "fad190", new byte[]{114, 123, 7, 76, 20, 34, 97}), String.class, "com.obric.aiagent.plugin"));
        if (r1 <= 0) goto L17;
        r10.getLong(r1);
    L17:
        return r0;
    }

    public final void a(p.a r22) {
        p.a r1 = (p.a) ZeusTransformUtils.wrapperContextForParams(r22, p.a.class, "com.obric.aiagent.plugin");
        PackageManager r9 = this.f39672a.getPackageManager();     // Catch: Exception -> L20
        if (r9 == null) goto L8;
        if (r9.resolveContentProvider((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "fc3b35", new byte[]{116, 110, 77, 88, 1, 39, 108, 88, 119, 124, 113, 109, 89, 27, 9, 108, 106, 82, 103, 60, 126, 101, 83, 18, 7}), String.class, "com.obric.aiagent.plugin"), 0) == null) goto L8;
        boolean r10 = true;
    L9:
        if (r10 == true) goto L11;
        return;
    L11:
        Uri r11 = Uri.parse((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "7d031e", new byte[]{37, 105, 77, 83, 11, 124, 32, 31, 46, 44, 37, 105, 78, 9, 3, 119, 61, 95, 116, 45, 32, 106, 90, 74, 11, 60, 59, 85, 100, 109, 47, 98, 80, 67, 5, 61}), String.class, "com.obric.aiagent.plugin"));
        Cursor r12 = null;
        r12 = ZeusProviderTransform.query(this.f39672a.getContentResolver(), r11, null, null, new String[]{(String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "e0fadb", new byte[]{123, 51, 28, 17}), String.class, "com.obric.aiagent.plugin")}, null, "com.obric.aiagent.plugin");     // Catch: Throwable -> L17
        String r0 = a(r12);     // Catch: Throwable -> L17
        if (r1 == null) goto L15;
        r1.a(r0);     // Catch: Throwable -> L17
    L15:
        if (r12 == null) goto L25;
    L18:
        r12.close();
        return;
    L25:
        return;
    L17:
        if (r12 != null) goto L18;
        return;
    L8:
        r10 = false;
        goto L9
    }
}
