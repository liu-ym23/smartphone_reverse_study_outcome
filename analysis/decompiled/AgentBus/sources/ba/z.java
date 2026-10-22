package ba;

/* loaded from: classes.dex */
public final class z extends o {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f1655c = 1;

    /* renamed from: d, reason: collision with root package name */
    public final int f1656d;

    /* JADX WARN: Illegal instructions before constructor call */
    public z(int i2) {
        StringBuilder sbN = a1.a.n(i2, "must have at least ", " value parameter");
        sbN.append(i2 > 1 ? "s" : "");
        super(sbN.toString(), 1);
        this.f1656d = i2;
    }

    @Override // ba.f
    public final boolean b(f8.t tVar) {
        switch (this.f1655c) {
            case 0:
                if (tVar.x0().size() >= this.f1656d) {
                }
                break;
            default:
                if (tVar.x0().size() == this.f1656d) {
                }
                break;
        }
        return false;
    }

    public z() {
        super("must have exactly 2 value parameters", 1);
        this.f1656d = 2;
    }
}
