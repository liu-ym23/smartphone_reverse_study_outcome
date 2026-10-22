package d.h.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: PropertyReference1.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class x extends u implements d.m.j {
    public x(Object r1, Class r2, String r3, String r4, int r5) {
        super(r1, r2, r3, r4, r5);
    }

    @Override // d.h.b.d
    public d.m.b computeReflected() {
        return aa.a(this);
    }

    @Override // d.h.a.b
    public Object invoke(Object r1) {
        return a(r1);
    }

    @Override // d.m.j
    public d.m.j.a a() {
        return ((d.m.j) ZeusTransformUtils.preCheckCast(b(), d.m.j.class, "com.obric.aiagent.plugin")).a();
    }
}
