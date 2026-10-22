package la;

/* loaded from: classes.dex */
public final class i implements j, o0 {

    /* renamed from: g, reason: collision with root package name */
    public static final i f5927g = new i(0);

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f5928f;

    public /* synthetic */ i(int i2) {
        this.f5928f = i2;
    }

    @Override // la.o0
    public j a(ma.w wVar) {
        switch (this.f5928f) {
            case 2:
                m0 m0Var = m0.f5958f;
                return new i(1);
            default:
                return new a7.d(new a5.b(wVar, null, 11));
        }
    }

    public String toString() {
        switch (this.f5928f) {
            case 2:
                return "SharingStarted.Eagerly";
            case 3:
                return "SharingStarted.Lazily";
            default:
                return super.toString();
        }
    }

    @Override // la.j
    public Object x(k kVar, g7.d dVar) {
        switch (this.f5928f) {
            case 0:
                break;
            default:
                Object objEmit = kVar.emit(m0.f5958f, dVar);
                if (objEmit != h7.a.f4212f) {
                    break;
                }
                break;
        }
        return c7.r.f1986a;
    }
}
