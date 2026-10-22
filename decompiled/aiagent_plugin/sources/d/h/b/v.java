package d.h.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: PropertyReference0.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class v extends u implements d.m.i {
    public v(Object r1, Class r2, String r3, String r4, int r5) {
        super(r1, r2, r3, r4, r5);
    }

    @Override // d.h.b.d
    public d.m.b computeReflected() {
        return aa.a(this);
    }

    @Override // d.h.a.a
    public Object invoke() {
        return c();
    }

    @Override // d.m.i
    public d.m.i.a a() {
        return ((d.m.i) ZeusTransformUtils.preCheckCast(b(), d.m.i.class, "com.obric.aiagent.plugin")).a();
    }
}
