package o;

/* loaded from: classes.dex */
public final class i0 extends q7.m implements p7.a {

    /* renamed from: h, reason: collision with root package name */
    public static final i0 f7063h;

    /* renamed from: i, reason: collision with root package name */
    public static final i0 f7064i;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f7065g;

    static {
        int i2 = 0;
        f7063h = new i0(i2, 0);
        f7064i = new i0(i2, 1);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ i0(int i2, int i10) {
        super(i2);
        this.f7065g = i10;
    }

    @Override // p7.a
    public final Object c() {
        switch (this.f7065g) {
            case 0:
                return w.f7139a;
            case 1:
                return new r0();
            default:
                return new y0(0);
        }
    }
}
