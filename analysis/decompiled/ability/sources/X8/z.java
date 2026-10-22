package X8;

/* loaded from: classes4.dex */
public final class z extends AbstractC0283n {
    public final /* synthetic */ int c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ z(A a3, int i) {
        super(a3);
        this.c = i;
    }

    @Override // X8.AbstractC0282m
    public final AbstractC0282m D0(A a3) {
        switch (this.c) {
            case 0:
                return new z(a3, 0);
            default:
                return new z(a3, 1);
        }
    }

    @Override // X8.AbstractC0282m, X8.w
    public final boolean W() {
        switch (this.c) {
            case 0:
                return false;
            default:
                return true;
        }
    }
}
