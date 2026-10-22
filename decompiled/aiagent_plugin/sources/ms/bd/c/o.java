package ms.bd.c;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
final class o implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f39572a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ p f39573b;

    o(p r3, Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        this.f39573b = r3;
        this.f39572a = ZeusTransformUtils.wrapperContext(r5, "com.obric.aiagent.plugin");
    }

    @Override // java.lang.Runnable
    public final void run() {
    L69:
        if (((Boolean) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(67108868, 0, 0, null, null), Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == true) goto L7;
        Thread.sleep(500);     // Catch: Throwable -> L68
        goto L69
    L7:
        if (((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "cfbd5d", new byte[]{83, 87, 36, 35}), String.class, "com.obric.aiagent.plugin")).equals(p.a(this.f39573b).toUpperCase()) == false) goto L9;
        new a(this.f39572a).a(p.b(this.f39573b));     // Catch: Throwable -> L68
    L60:
        String r2 = null;
    L61:
        if (r2 != null) goto L63;
        return;
    L63:
        if (p.b(this.f39573b) == null) goto L72;
        p.b(this.f39573b).a(r2);     // Catch: Throwable -> L68
        return;
    L72:
        return;
    L9:
        this.f39573b.getClass();     // Catch: Throwable -> L68
        if (p.a() == false) goto L12;
    L59:
        new y(this.f39572a).a(p.b(this.f39573b));     // Catch: Throwable -> L68
        goto L60
    L12:
        if (((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "f55e2f", new byte[]{95, 2, 103, 38, 40, 88}), String.class, "com.obric.aiagent.plugin")).equals(p.a(this.f39573b).toUpperCase()) == true) goto L59;
        if (((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "f542f2", new byte[]{95, 30, 105, 105, 111, 4}), String.class, "com.obric.aiagent.plugin")).equals(p.a(this.f39573b).toUpperCase()) == true) goto L59;
        if (((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "956199", new byte[]{0, 24, 107, 106, 52}), String.class, "com.obric.aiagent.plugin")).equals(p.a(this.f39573b).toUpperCase()) == false) goto L20;
        new b0(this.f39572a).a(p.b(this.f39573b));     // Catch: Throwable -> L68
        goto L60
    L20:
        if (((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "577a77", new byte[]{11, 5, 116, 58}), String.class, "com.obric.aiagent.plugin")).equals(p.a(this.f39573b).toUpperCase()) == false) goto L22;
    L58:
        new d1(this.f39572a).a(p.b(this.f39573b));     // Catch: Throwable -> L68
        goto L60
    L22:
        if (((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "536fcf", new byte[]{22, 20, 100, 62, 113, 84}), String.class, "com.obric.aiagent.plugin")).equals(p.a(this.f39573b).toUpperCase()) == true) goto L58;
        if (((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "5c96a9", new byte[]{11, 79, 111, 114, 114, 27, 5}), String.class, "com.obric.aiagent.plugin")).equals(p.a(this.f39573b).toUpperCase()) == true) goto L58;
        if (((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "be04b3", new byte[]{64, 70, 110, 115, 104, 10, 70}), String.class, "com.obric.aiagent.plugin")).equals(p.a(this.f39573b).toUpperCase()) == false) goto L30;
        new o1(this.f39572a).a(p.b(this.f39573b));     // Catch: Throwable -> L68
        goto L60
    L30:
        if (((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "2c86a7", new byte[]{15, 68, 101, 109, 104, 15}), String.class, "com.obric.aiagent.plugin")).equals(p.a(this.f39573b).toUpperCase()) == false) goto L34;
        f0 r1 = new f0(this.f39572a);     // Catch: Throwable -> L68
    L36:
        r1.a(p.b(this.f39573b));     // Catch: Throwable -> L68
        goto L60
    L34:
        if (((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "f94729", new byte[]{90, 20, 115, 108, 33, 1, 87, 57}), String.class, "com.obric.aiagent.plugin")).equals(p.a(this.f39573b).toUpperCase()) == false) goto L38;
        r1 = new f0(this.f39572a);     // Catch: Throwable -> L68
        goto L36
    L38:
        if (((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "2e4787", new byte[]{13, 82, 101, 106, 38}), String.class, "com.obric.aiagent.plugin")).equals(p.a(this.f39573b).toUpperCase()) == false) goto L42;
        String r3 = new b1(this.f39572a).a();     // Catch: Throwable -> L68
    L40:
        r2 = r3;
        goto L61
    L42:
        if (((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "b3e74e", new byte[]{69, 24, 32, 108}), String.class, "com.obric.aiagent.plugin")).equals(p.a(this.f39573b).toUpperCase()) == false) goto L45;
        r3 = new d2(this.f39572a).a();     // Catch: Throwable -> L68
        goto L40
    L45:
        if (((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "48f724", new byte[]{8, 31, 60, 121, 56}), String.class, "com.obric.aiagent.plugin")).equals(p.a(this.f39573b).toUpperCase()) == false) goto L47;
        new w0(this.f39572a).a(p.b(this.f39573b));     // Catch: Throwable -> L68
        goto L60
    L47:
        this.f39573b.getClass();     // Catch: Throwable -> L68
        if (p.b() == false) goto L50;
    L57:
        r3 = new e2(this.f39572a).a();     // Catch: Throwable -> L68
        goto L40
    L50:
        if (((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "fefccb", new byte[]{79, 78, 52, 56, 113, 92}), String.class, "com.obric.aiagent.plugin")).equals(p.a(this.f39573b).toUpperCase()) == true) goto L57;
        if (((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "f4324c", new byte[]{69, 19, 100, 107, 34}), String.class, "com.obric.aiagent.plugin")).equals(p.a(this.f39573b).toUpperCase()) == true) goto L57;
        if (((String) ZeusTransformUtils.preCheckCast(com.bytedance.mobsec.matrix.a.a(16777217, 0, 0, "5c8fde", new byte[]{6, 77, 106, 49, 112, 65, 30, 99, 91, 29}), String.class, "com.obric.aiagent.plugin")).equals(p.a(this.f39573b).toUpperCase()) == true) goto L57;
        new l(this.f39572a).a(p.b(this.f39573b));     // Catch: Throwable -> L68
    }
}
