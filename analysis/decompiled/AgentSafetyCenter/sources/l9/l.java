package l9;

import jb.v;
import s1.q;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class l implements xb.l {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f7806c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ xb.l f7807f;

    public /* synthetic */ l(int i) {
        this.f7806c = i;
    }

    @Override // xb.l
    public final Object invoke(Object obj) {
        int i = this.f7806c;
        xb.l lVar = this.f7807f;
        switch (i) {
            case 0:
                lVar.invoke(Integer.valueOf((int) (((o2.k) obj).f9122a & 4294967295L)));
                return v.f6774a;
            case 1:
                q qVar = (q) obj;
                qVar.getClass();
                q qVarW = qVar.w();
                if (qVarW != null) {
                    long jB = qVarW.B(qVar, 0L);
                    int i3 = (int) (jB >> 32);
                    int i10 = (int) (jB & 4294967295L);
                    lVar.invoke(new c1.c(Float.intBitsToFloat(i3), Float.intBitsToFloat(i10), Float.intBitsToFloat(i3) + ((int) (qVar.l() >> 32)), Float.intBitsToFloat(i10) + ((int) (4294967295L & qVar.l()))));
                }
                return v.f6774a;
            default:
                u0.f fVar = (u0.f) lVar.invoke((u0.k) obj);
                synchronized (u0.m.f13676c) {
                    u0.m.f13677d = u0.m.f13677d.e(fVar.g());
                }
                return fVar;
        }
    }
}
