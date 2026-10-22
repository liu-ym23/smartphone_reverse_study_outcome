package j1;

/* loaded from: classes.dex */
public final class d1 extends q7.m implements p7.n {

    /* renamed from: g, reason: collision with root package name */
    public static final d1 f5124g = new d1(2);

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        b0.p pVar = (b0.p) obj;
        int iIntValue = ((Number) obj2).intValue();
        if (!pVar.L(iIntValue & 1, (iIntValue & 3) != 2)) {
            pVar.O();
        }
        return c7.r.f1986a;
    }
}
