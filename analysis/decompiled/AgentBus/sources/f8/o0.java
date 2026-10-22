package f8;

/* loaded from: classes.dex */
public final class o0 implements p9.d, n0 {

    /* renamed from: g, reason: collision with root package name */
    public static final o0 f3503g = new o0(0);

    /* renamed from: h, reason: collision with root package name */
    public static final o0 f3504h = new o0(1);

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f3505f;

    public /* synthetic */ o0(int i2) {
        this.f3505f = i2;
    }

    @Override // p9.d
    public v9.v getType() {
        switch (this.f3505f) {
            case 2:
                throw new IllegalStateException("This method should not be called");
            case 3:
                throw new IllegalStateException("This method should not be called");
            default:
                throw new IllegalStateException("This method should not be called");
        }
    }

    public String toString() {
        switch (this.f3505f) {
            case 6:
                return "NO_SOURCE";
            default:
                return super.toString();
        }
    }
}
