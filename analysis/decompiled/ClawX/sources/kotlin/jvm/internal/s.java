package kotlin.jvm.internal;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class s implements g {

    /* renamed from: a, reason: collision with root package name */
    public final Class f3681a;

    public s(Class jClass) {
        p.e(jClass, "jClass");
        this.f3681a = jClass;
    }

    @Override // kotlin.jvm.internal.g
    public final Class a() {
        return this.f3681a;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof s) {
            return p.a(this.f3681a, ((s) obj).f3681a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f3681a.hashCode();
    }

    public final String toString() {
        return this.f3681a.toString() + " (Kotlin reflection is not available)";
    }
}
