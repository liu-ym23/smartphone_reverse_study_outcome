package tc;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.collections.EmptyList;
import rc.j;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class j0 implements rc.e {

    /* renamed from: a, reason: collision with root package name */
    public final rc.e f12998a;

    /* renamed from: b, reason: collision with root package name */
    public final rc.e f12999b;

    public j0(rc.e eVar, rc.e eVar2) {
        this.f12998a = eVar;
        this.f12999b = eVar2;
    }

    @Override // rc.e
    public final boolean b() {
        return false;
    }

    @Override // rc.e
    public final int c(String name) {
        kotlin.jvm.internal.g.f(name, "name");
        Integer numC0 = gc.n.c0(name);
        if (numC0 != null) {
            return numC0.intValue();
        }
        throw new IllegalArgumentException(name.concat(" is not a valid map index"));
    }

    @Override // rc.e
    public final rc.i d() {
        return j.c.f11803a;
    }

    @Override // rc.e
    public final int e() {
        return 2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j0)) {
            return false;
        }
        j0 j0Var = (j0) obj;
        return this.f12998a.equals(j0Var.f12998a) && this.f12999b.equals(j0Var.f12999b);
    }

    @Override // rc.e
    public final String f(int i10) {
        return String.valueOf(i10);
    }

    @Override // rc.e
    public final List<Annotation> g(int i10) {
        if (i10 >= 0) {
            return EmptyList.f10001a;
        }
        throw new IllegalArgumentException(ai.onnxruntime.a.g(i10, "Illegal index ", ", kotlin.collections.LinkedHashMap expects only non-negative indices").toString());
    }

    @Override // rc.e
    public final List<Annotation> getAnnotations() {
        return EmptyList.f10001a;
    }

    @Override // rc.e
    public final rc.e h(int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException(ai.onnxruntime.a.g(i10, "Illegal index ", ", kotlin.collections.LinkedHashMap expects only non-negative indices").toString());
        }
        int i11 = i10 % 2;
        if (i11 == 0) {
            return this.f12998a;
        }
        if (i11 == 1) {
            return this.f12999b;
        }
        throw new IllegalStateException("Unreached");
    }

    public final int hashCode() {
        return this.f12999b.hashCode() + ((this.f12998a.hashCode() + 710441009) * 31);
    }

    @Override // rc.e
    public final String i() {
        return "kotlin.collections.LinkedHashMap";
    }

    @Override // rc.e
    public final boolean isInline() {
        return false;
    }

    @Override // rc.e
    public final boolean j(int i10) {
        if (i10 >= 0) {
            return false;
        }
        throw new IllegalArgumentException(ai.onnxruntime.a.g(i10, "Illegal index ", ", kotlin.collections.LinkedHashMap expects only non-negative indices").toString());
    }

    public final String toString() {
        return "kotlin.collections.LinkedHashMap(" + this.f12998a + ", " + this.f12999b + ')';
    }
}
