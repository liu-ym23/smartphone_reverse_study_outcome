package ia;

/* loaded from: classes.dex */
public final /* synthetic */ class l implements p7.o {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f4967f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Object f4968g;

    public /* synthetic */ l(int i2, Object obj) {
        this.f4967f = i2;
        this.f4968g = obj;
    }

    @Override // p7.o
    public final Object j(Object obj, Object obj2, Object obj3) {
        int i2 = this.f4967f;
        Object obj4 = this.f4968g;
        switch (i2) {
            case 0:
                ((b0.b2) obj4).invoke((Throwable) obj);
                break;
            case 1:
                ((ra.i) obj4).b();
                break;
            default:
                v4.k kVar = (v4.k) obj4;
                boolean zBooleanValue = ((Boolean) obj).booleanValue();
                boolean zBooleanValue2 = ((Boolean) obj2).booleanValue();
                String str = (String) obj3;
                q7.k.e(str, "userId");
                k5.g gVar = kVar.f10429e;
                k5.s.warn$default(gVar, "AgentBusContainer", "Account state changed: wasLoggedIn=" + zBooleanValue + " → isNowLoggedIn=" + zBooleanValue2 + ", userId=" + e5.b.e(str), null, 4, null);
                if (!zBooleanValue2 || (zBooleanValue2 && !zBooleanValue)) {
                    String str2 = !zBooleanValue2 ? "account logout" : "account login recovered";
                    k5.s.warn$default(gVar, "AgentBusContainer", "Reconnecting cloud bridge: ".concat(str2), null, 4, null);
                    d0.s(kVar.X, null, null, new v4.g(zBooleanValue2, zBooleanValue, kVar, str2, null), 3);
                }
                return c7.r.f1986a;
        }
        return c7.r.f1986a;
    }
}
