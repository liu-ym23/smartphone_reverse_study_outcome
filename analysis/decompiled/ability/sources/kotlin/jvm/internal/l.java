package kotlin.jvm.internal;

/* loaded from: classes3.dex */
public final class l implements c {

    /* renamed from: a, reason: collision with root package name */
    public final Class f4927a;

    public l(Class jClass, String str) {
        k.f(jClass, "jClass");
        this.f4927a = jClass;
    }

    @Override // kotlin.jvm.internal.c
    public final Class b() {
        return this.f4927a;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof l) {
            return k.b(this.f4927a, ((l) obj).f4927a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f4927a.hashCode();
    }

    public final String toString() {
        return this.f4927a.toString() + " (Kotlin reflection is not available)";
    }
}
