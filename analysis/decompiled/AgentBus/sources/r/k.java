package r;

import java.util.List;

/* loaded from: classes.dex */
public final class k implements g1.p {

    /* renamed from: b, reason: collision with root package name */
    public static final k f8877b = new k(0);

    /* renamed from: c, reason: collision with root package name */
    public static final k f8878c = new k(1);

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8879a;

    public /* synthetic */ k(int i2) {
        this.f8879a = i2;
    }

    @Override // g1.p
    public final i1.l0 b(i1.m0 m0Var, List list, long j2) {
        switch (this.f8879a) {
            case 0:
                return m0Var.l0(d2.a.j(j2), d2.a.i(j2), d7.a0.f2944f, j.f8872h);
            default:
                return m0Var.l0(d2.a.f(j2) ? d2.a.h(j2) : 0, d2.a.e(j2) ? d2.a.g(j2) : 0, d7.a0.f2944f, j.f8874j);
        }
    }
}
