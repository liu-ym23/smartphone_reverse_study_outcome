package d9;

/* loaded from: classes4.dex */
public final class y extends AbstractC1393n {
    public static final y d = new y("must have no value parameters", 0);
    public static final y e = new y("must have a single value parameter", 1);
    public final /* synthetic */ int c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ y(String str, int i) {
        super(str, 1);
        this.c = i;
    }

    @Override // d9.InterfaceC1384e
    public final boolean a(kotlin.reflect.jvm.internal.impl.load.java.descriptors.a aVar) {
        switch (this.c) {
            case 0:
                return aVar.x().isEmpty();
            default:
                return aVar.x().size() == 1;
        }
    }
}
