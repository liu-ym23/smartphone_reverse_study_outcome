package ms.bd.c;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public final class d2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f39481a;

    public d2(Context r3) {
        this.f39481a = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
    }

    private boolean b() {
        String r0 = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "1319d0", new byte[]{48, 52, 80, 94, 82, 52, 38, 92, 115, 112, 51, 127, 75, 73, 94, 41, 38, 27, 102, 96, 37, 35, 75, 73, 21, 52, 39, 2, 112, 102, 50, 37, 71, 73}), String.class, "com.obric.aiagent.plugin");
        String r3 = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "021455", new byte[]{113}), String.class, "com.obric.aiagent.plugin");
        Class r10 = ZeusTransformUtils.forName((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "620c25", new byte[]{38, 62, 71, 5, 2, 43, 49, 93, 110, 32, 105, 3, 90, 4, 25, 39, 56, 35, 115, 60, 55, 53, 81, 3, 4, 39, 38}), String.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");     // Catch: Exception -> L7
        r3 = (String) ZeusTransformUtils.preCheckCast(r10.getMethod((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "bdfef2", new byte[]{116, 99, 1}), String.class, "com.obric.aiagent.plugin"), new Class[]{String.class, String.class}).invoke(r10, new Object[]{r0, (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "e6782e", new byte[]{97, 58, 79, 66, 2, 101, 104}), String.class, "com.obric.aiagent.plugin")}), String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L7
    L6:
        return r3.equals((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "84c2cd", new byte[]{120}), String.class, "com.obric.aiagent.plugin"));
    }

    public final String a() {
        String r1 = null;
        if (b() == true) goto L5;
        return null;
    L5:
        Cursor r13 = ZeusProviderTransform.query(this.f39481a.getContentResolver(), Uri.parse((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "51c05d", new byte[]{39, 60, 30, 80, 15, 125, 34, 74, 125, 47, 39, 60, 29, 10, 28, 122, 32, 31, 124, 118, 41, 32, 94, 109, 14, 67, 36, 31, 36, 105, 32, 54, 2, 11, 35, 119, 51, 30, 38, 105, 34, 58, 21, 86, 35, 119, 121, 63, 19, 73, 0}), String.class, "com.obric.aiagent.plugin")), null, null, null, null, "com.obric.aiagent.plugin");
        if (r13 != null) goto L30;
    L19:
        if (r13 != null) goto L28;
    L21:
        return r1;
    L28:
        r13.close();     // Catch: Throwable -> L22
        goto L21
    L30:
        if (r13.moveToNext() == false) goto L19;
        r1 = r13.getString(r13.getColumnIndex((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "a8da16", new byte[]{102, 59, 27, 0, 11}), String.class, "com.obric.aiagent.plugin")));     // Catch: Throwable -> L12
    L24:
        String r0 = (String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "58543f", new byte[]{50, 53}), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        r13.close();     // Catch: Throwable -> L23
    L18:
        throw th;
    }
}
