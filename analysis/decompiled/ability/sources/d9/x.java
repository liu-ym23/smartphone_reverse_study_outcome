package d9;

/* loaded from: classes4.dex */
public final class x extends AbstractC1393n {
    public final /* synthetic */ int c = 1;
    public final int d;

    /* JADX WARN: Illegal instructions before constructor call */
    public x(int i) {
        StringBuilder sbU = B7.a.u(i, "must have at least ", " value parameter");
        sbU.append(i > 1 ? "s" : "");
        super(sbU.toString(), 1);
        this.d = i;
    }

    @Override // d9.InterfaceC1384e
    public final boolean a(kotlin.reflect.jvm.internal.impl.load.java.descriptors.a aVar) {
        switch (this.c) {
            case 0:
                if (aVar.x().size() >= this.d) {
                }
                break;
            default:
                if (aVar.x().size() == this.d) {
                }
                break;
        }
        return false;
    }

    public x() {
        super("must have exactly 2 value parameters", 1);
        this.d = 2;
    }
}
