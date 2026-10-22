package ms.bd.c;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public final class y0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final y0 f39682a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.bytedance.mobsec.metasec.ml.b.a.InterfaceC0201b f39683b;

    static {
        f39682a = new y0();
    }

    public y0() {
    }

    public static y0 a() {
        return f39682a;
    }

    public final void a(com.bytedance.mobsec.metasec.ml.b.a.InterfaceC0201b r3) {
        this.f39683b = (com.bytedance.mobsec.metasec.ml.b.a.InterfaceC0201b) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.mobsec.metasec.ml.b.a.InterfaceC0201b.class, "com.obric.aiagent.plugin");
    }

    public final boolean a(String r1) {
        com.bytedance.mobsec.metasec.ml.b.a.InterfaceC0201b r0 = this.f39683b;
        if (r0 != null) goto L9;
        return true;
    L9:
        return r0.isComplianceScene(r1);
    L11:
        return true;
    }
}
