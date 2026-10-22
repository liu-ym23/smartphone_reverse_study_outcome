package u8;

/* loaded from: classes4.dex */
public final class n implements S7.k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6730a;
    public final kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.a b;

    public /* synthetic */ n(kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.a aVar, int i) {
        this.f6730a = i;
        this.b = aVar;
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        G8.f it = (G8.f) obj;
        switch (this.f6730a) {
            case 0:
                kotlin.jvm.internal.k.f(it, "it");
                return this.b.M(it);
            default:
                kotlin.jvm.internal.k.f(it, "it");
                return this.b.N(it);
        }
    }
}
