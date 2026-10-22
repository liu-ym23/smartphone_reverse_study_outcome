package v9;

/* loaded from: classes.dex */
public final class y extends n {

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ int f10608h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ y(z zVar, int i2) {
        super(zVar);
        this.f10608h = i2;
    }

    @Override // v9.m, v9.v
    public final boolean F0() {
        switch (this.f10608h) {
            case 0:
                return false;
            default:
                return true;
        }
    }

    @Override // v9.m
    public final m P0(z zVar) {
        switch (this.f10608h) {
            case 0:
                return new y(zVar, 0);
            default:
                return new y(zVar, 1);
        }
    }
}
