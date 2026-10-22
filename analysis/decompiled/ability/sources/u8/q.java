package u8;

/* loaded from: classes4.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    public final G8.f f6733a;
    public final kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.a b;

    public q(G8.f name, kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.a aVar) {
        kotlin.jvm.internal.k.f(name, "name");
        this.f6733a = name;
        this.b = aVar;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof q) {
            return kotlin.jvm.internal.k.b(this.f6733a, ((q) obj).f6733a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f6733a.hashCode();
    }
}
