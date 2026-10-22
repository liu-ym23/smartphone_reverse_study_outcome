package o9;

/* loaded from: classes.dex */
public final class r extends q7.m implements p7.a {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f7935g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ s f7936h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ r(s sVar, int i2) {
        super(0);
        this.f7935g = i2;
        this.f7936h = sVar;
    }

    @Override // p7.a
    public final Object c() {
        switch (this.f7935g) {
            case 0:
                t9.i iVar = this.f7936h.f7938b;
                return d7.s.u0(h9.m.i(iVar), h9.m.j(iVar));
            default:
                return d7.s.w0(h9.m.h(this.f7936h.f7938b));
        }
    }
}
