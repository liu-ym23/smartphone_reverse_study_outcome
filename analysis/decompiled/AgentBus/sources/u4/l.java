package u4;

/* loaded from: classes.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public final Object f10090a;

    /* renamed from: b, reason: collision with root package name */
    public volatile Object f10091b;

    /* renamed from: c, reason: collision with root package name */
    public volatile Object f10092c;

    public l(d5.l lVar) {
        q7.k.e(lVar, "pool");
        this.f10090a = lVar;
        this.f10092c = "";
    }

    public d5.e a() {
        d5.e eVarC;
        String str = (String) this.f10091b;
        if (str == null || (eVarC = ((d5.l) this.f10090a).c(str)) == null || eVarC.f() != d5.m.CHANNEL) {
            return null;
        }
        return eVarC;
    }

    public l(x2.g gVar) {
        this.f10090a = gVar;
    }
}
