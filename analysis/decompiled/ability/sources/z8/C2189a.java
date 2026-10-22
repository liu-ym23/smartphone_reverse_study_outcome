package z8;

/* renamed from: z8.a, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2189a implements S7.n {
    public static final C2189a b = new C2189a(0);
    public static final C2189a c = new C2189a(1);

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6981a;

    public /* synthetic */ C2189a(int i) {
        this.f6981a = i;
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        C2192d loadConstantFromProperty = (C2192d) obj;
        r it = (r) obj2;
        switch (this.f6981a) {
            case 0:
                kotlin.jvm.internal.k.f(loadConstantFromProperty, "$this$loadConstantFromProperty");
                kotlin.jvm.internal.k.f(it, "it");
                return loadConstantFromProperty.c.get(it);
            default:
                kotlin.jvm.internal.k.f(loadConstantFromProperty, "$this$loadConstantFromProperty");
                kotlin.jvm.internal.k.f(it, "it");
                return loadConstantFromProperty.b.get(it);
        }
    }
}
