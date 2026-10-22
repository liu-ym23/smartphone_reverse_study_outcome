package tc;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.collections.EmptyList;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class v0 implements rc.e {

    /* renamed from: a, reason: collision with root package name */
    public final String f13060a;

    /* renamed from: b, reason: collision with root package name */
    public final rc.d f13061b;

    public v0(String str, rc.d kind) {
        kotlin.jvm.internal.g.f(kind, "kind");
        this.f13060a = str;
        this.f13061b = kind;
    }

    @Override // rc.e
    public final boolean b() {
        return false;
    }

    @Override // rc.e
    public final int c(String name) {
        kotlin.jvm.internal.g.f(name, "name");
        throw new IllegalStateException("Primitive descriptor does not have elements");
    }

    @Override // rc.e
    public final rc.i d() {
        return this.f13061b;
    }

    @Override // rc.e
    public final int e() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof v0)) {
            return false;
        }
        v0 v0Var = (v0) obj;
        return kotlin.jvm.internal.g.b(this.f13060a, v0Var.f13060a) && kotlin.jvm.internal.g.b(this.f13061b, v0Var.f13061b);
    }

    @Override // rc.e
    public final String f(int i10) {
        throw new IllegalStateException("Primitive descriptor does not have elements");
    }

    @Override // rc.e
    public final List<Annotation> g(int i10) {
        throw new IllegalStateException("Primitive descriptor does not have elements");
    }

    @Override // rc.e
    public final List<Annotation> getAnnotations() {
        return EmptyList.f10001a;
    }

    @Override // rc.e
    public final rc.e h(int i10) {
        throw new IllegalStateException("Primitive descriptor does not have elements");
    }

    public final int hashCode() {
        return (this.f13061b.hashCode() * 31) + this.f13060a.hashCode();
    }

    @Override // rc.e
    public final String i() {
        return this.f13060a;
    }

    @Override // rc.e
    public final boolean isInline() {
        return false;
    }

    @Override // rc.e
    public final boolean j(int i10) {
        throw new IllegalStateException("Primitive descriptor does not have elements");
    }

    public final String toString() {
        return ai.onnxruntime.a.n(new StringBuilder("PrimitiveDescriptor("), this.f13060a, ')');
    }
}
