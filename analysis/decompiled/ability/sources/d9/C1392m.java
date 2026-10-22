package d9;

/* renamed from: d9.m, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1392m extends AbstractC1393n {
    public static final C1392m d = new C1392m("must be a member function", 0);
    public static final C1392m e = new C1392m("must be a member or an extension function", 1);
    public final /* synthetic */ int c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C1392m(String str, int i) {
        super(str, 0);
        this.c = i;
    }

    @Override // d9.InterfaceC1384e
    public final boolean a(kotlin.reflect.jvm.internal.impl.load.java.descriptors.a aVar) {
        switch (this.c) {
            case 0:
                return aVar.f4864j != null;
            default:
                return (aVar.f4864j == null && aVar.i == null) ? false : true;
        }
    }
}
