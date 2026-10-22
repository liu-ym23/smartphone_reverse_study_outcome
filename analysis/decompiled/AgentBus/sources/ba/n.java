package ba;

/* loaded from: classes.dex */
public final class n extends o {

    /* renamed from: d, reason: collision with root package name */
    public static final n f1617d = new n("must be a member function", 0);

    /* renamed from: e, reason: collision with root package name */
    public static final n f1618e = new n("must be a member or an extension function", 1);

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f1619c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ n(String str, int i2) {
        super(str, 0);
        this.f1619c = i2;
    }

    @Override // ba.f
    public final boolean b(f8.t tVar) {
        switch (this.f1619c) {
            case 0:
                return tVar.y() != null;
            default:
                return (tVar.y() == null && tVar.I() == null) ? false : true;
        }
    }
}
