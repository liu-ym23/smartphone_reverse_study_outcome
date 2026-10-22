package y;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class h0 extends yb.l implements xb.l {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f15748c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ i0 f15749f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ h0(i0 i0Var, int i) {
        super(1);
        this.f15748c = i;
        this.f15749f = i0Var;
    }

    @Override // xb.l
    public final Object invoke(Object obj) {
        switch (this.f15748c) {
            case 0:
                x.h hVar = (x.h) this.f15749f.f15752s.invoke();
                int iC = hVar.c();
                int i = 0;
                while (true) {
                    if (i >= iC) {
                        i = -1;
                    } else if (!hVar.d(i).equals(obj)) {
                        i++;
                    }
                }
                return Integer.valueOf(i);
            default:
                int iIntValue = ((Number) obj).intValue();
                i0 i0Var = this.f15749f;
                x.h hVar2 = (x.h) i0Var.f15752s.invoke();
                if (iIntValue >= 0 && iIntValue < hVar2.c()) {
                    kc.w.u(i0Var.p0(), null, null, new j9.h(i0Var, iIntValue, null, 1), 3);
                    return Boolean.TRUE;
                }
                StringBuilder sbT = k0.a.t(iIntValue, "Can't scroll to index ", ", it is out of bounds [0, ");
                sbT.append(hVar2.c());
                sbT.append(')');
                throw new IllegalArgumentException(sbT.toString().toString());
        }
    }
}
