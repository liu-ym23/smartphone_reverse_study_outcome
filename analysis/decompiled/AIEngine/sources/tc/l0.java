package tc;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.collections.EmptyList;
import rc.j;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class l0 implements rc.e {

    /* renamed from: a, reason: collision with root package name */
    public static final l0 f13007a = new l0();

    /* renamed from: b, reason: collision with root package name */
    public static final j.d f13008b = j.d.f11804a;

    /* renamed from: c, reason: collision with root package name */
    public static final String f13009c = "kotlin.Nothing";

    @Override // rc.e
    public final boolean b() {
        return false;
    }

    @Override // rc.e
    public final int c(String name) {
        kotlin.jvm.internal.g.f(name, "name");
        throw new IllegalStateException("Descriptor for type `kotlin.Nothing` does not have elements");
    }

    @Override // rc.e
    public final rc.i d() {
        return f13008b;
    }

    @Override // rc.e
    public final int e() {
        return 0;
    }

    public final boolean equals(Object obj) {
        return this == obj;
    }

    @Override // rc.e
    public final String f(int i10) {
        throw new IllegalStateException("Descriptor for type `kotlin.Nothing` does not have elements");
    }

    @Override // rc.e
    public final List<Annotation> g(int i10) {
        throw new IllegalStateException("Descriptor for type `kotlin.Nothing` does not have elements");
    }

    @Override // rc.e
    public final List<Annotation> getAnnotations() {
        return EmptyList.f10001a;
    }

    @Override // rc.e
    public final rc.e h(int i10) {
        throw new IllegalStateException("Descriptor for type `kotlin.Nothing` does not have elements");
    }

    public final int hashCode() {
        return (f13008b.hashCode() * 31) + f13009c.hashCode();
    }

    @Override // rc.e
    public final String i() {
        return f13009c;
    }

    @Override // rc.e
    public final boolean isInline() {
        return false;
    }

    @Override // rc.e
    public final boolean j(int i10) {
        throw new IllegalStateException("Descriptor for type `kotlin.Nothing` does not have elements");
    }

    public final String toString() {
        return "NothingSerialDescriptor";
    }
}
