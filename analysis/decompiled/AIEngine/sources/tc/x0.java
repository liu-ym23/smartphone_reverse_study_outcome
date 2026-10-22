package tc;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Set;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class x0 implements rc.e, k {

    /* renamed from: a, reason: collision with root package name */
    public final rc.e f13065a;

    /* renamed from: b, reason: collision with root package name */
    public final String f13066b;

    /* renamed from: c, reason: collision with root package name */
    public final Set<String> f13067c;

    public x0(rc.e original) {
        kotlin.jvm.internal.g.f(original, "original");
        this.f13065a = original;
        this.f13066b = original.i() + '?';
        this.f13067c = p0.b(original);
    }

    @Override // tc.k
    public final Set<String> a() {
        return this.f13067c;
    }

    @Override // rc.e
    public final boolean b() {
        return true;
    }

    @Override // rc.e
    public final int c(String name) {
        kotlin.jvm.internal.g.f(name, "name");
        return this.f13065a.c(name);
    }

    @Override // rc.e
    public final rc.i d() {
        return this.f13065a.d();
    }

    @Override // rc.e
    public final int e() {
        return this.f13065a.e();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof x0) {
            return kotlin.jvm.internal.g.b(this.f13065a, ((x0) obj).f13065a);
        }
        return false;
    }

    @Override // rc.e
    public final String f(int i10) {
        return this.f13065a.f(i10);
    }

    @Override // rc.e
    public final List<Annotation> g(int i10) {
        return this.f13065a.g(i10);
    }

    @Override // rc.e
    public final List<Annotation> getAnnotations() {
        return this.f13065a.getAnnotations();
    }

    @Override // rc.e
    public final rc.e h(int i10) {
        return this.f13065a.h(i10);
    }

    public final int hashCode() {
        return this.f13065a.hashCode() * 31;
    }

    @Override // rc.e
    public final String i() {
        return this.f13066b;
    }

    @Override // rc.e
    public final boolean isInline() {
        return this.f13065a.isInline();
    }

    @Override // rc.e
    public final boolean j(int i10) {
        return this.f13065a.j(i10);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f13065a);
        sb2.append('?');
        return sb2.toString();
    }
}
