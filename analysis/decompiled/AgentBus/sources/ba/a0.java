package ba;

/* loaded from: classes.dex */
public final class a0 extends o {

    /* renamed from: d, reason: collision with root package name */
    public static final a0 f1587d = new a0("must have no value parameters", 0);

    /* renamed from: e, reason: collision with root package name */
    public static final a0 f1588e = new a0("must have a single value parameter", 1);

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f1589c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a0(String str, int i2) {
        super(str, 1);
        this.f1589c = i2;
    }

    @Override // ba.f
    public final boolean b(f8.t tVar) {
        switch (this.f1589c) {
            case 0:
                return tVar.x0().isEmpty();
            default:
                return tVar.x0().size() == 1;
        }
    }
}
