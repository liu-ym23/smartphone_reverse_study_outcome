package b0;

import k0.c1;
import r.i0;
import s.e0;
import v1.z0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class s extends yb.l implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f1783c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Object f1784f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ s(int i, int i3, Object obj) {
        super(2);
        this.f1783c = i3;
        this.f1784f = obj;
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f1783c) {
            case 0:
                ((Number) obj2).intValue();
                ((x) this.f1784f).a(k0.z.D(1), (k0.s) obj);
                return jb.v.f6774a;
            case 1:
                r.w wVar = (r.w) obj;
                r.w wVar2 = (r.w) obj2;
                r.w wVar3 = r.w.f10350g;
                return Boolean.valueOf(wVar == wVar3 && wVar2 == wVar3 && !((i0) this.f1784f).f10306a.f10339c);
            case 2:
                ((Number) obj2).intValue();
                ((e0) this.f1784f).a(k0.z.D(1), (k0.s) obj);
                return jb.v.f6774a;
            case 3:
                k0.s sVar = (k0.s) obj;
                int iIntValue = ((Number) obj2).intValue();
                if (sVar.P(iIntValue & 1, (iIntValue & 3) != 2)) {
                    Object objM = sVar.M();
                    if (objM == k0.m.f6974a) {
                        objM = s2.b.f11338c;
                        sVar.i0(objM);
                    }
                    id.c.c(a2.l.a(w0.j.f15113c, false, (xb.l) objM), (xb.p) ((c1) this.f1784f).getValue(), sVar, 0);
                } else {
                    sVar.S();
                }
                return jb.v.f6774a;
            case 4:
                ((Number) obj2).intValue();
                ((s2.j) this.f1784f).a(k0.z.D(1), (k0.s) obj);
                return jb.v.f6774a;
            case 5:
                k0.s sVar2 = (k0.s) obj;
                int iIntValue2 = ((Number) obj2).intValue();
                if (sVar2.P(iIntValue2 & 1, (iIntValue2 & 3) != 2)) {
                    ((v1.a) this.f1784f).a(0, sVar2);
                } else {
                    sVar2.S();
                }
                return jb.v.f6774a;
            case 6:
                ((Number) obj2).intValue();
                ((z0) this.f1784f).a(k0.z.D(1), (k0.s) obj);
                return jb.v.f6774a;
            case 7:
                return o2.i.a(((w0.e) this.f1784f).a(0L, ((o2.k) obj).f9122a, (o2.l) obj2));
            case 8:
                w0.m mVar = (w0.m) obj;
                w0.m mVarL = (w0.k) obj2;
                k0.s sVar3 = (k0.s) this.f1784f;
                if (mVarL instanceof w0.h) {
                    xb.q qVar = ((w0.h) mVarL).f15111f;
                    yb.x.c(3, qVar);
                    mVarL = t.o.l(sVar3, (w0.m) qVar.invoke(w0.j.f15113c, sVar3, 0));
                }
                return mVar.d(mVarL);
            default:
                ((y0.d) this.f1784f).l(((Number) obj).intValue(), (a2.p) obj2);
                return jb.v.f6774a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ s(Object obj, int i) {
        super(2);
        this.f1783c = i;
        this.f1784f = obj;
    }
}
