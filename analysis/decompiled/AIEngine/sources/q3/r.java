package q3;

import com.fasterxml.jackson.databind.JavaType;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    public final int f11609a;

    /* renamed from: b, reason: collision with root package name */
    public final Class<?> f11610b;

    /* renamed from: c, reason: collision with root package name */
    public final JavaType f11611c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f11612d;

    public r() {
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != r.class) {
            return false;
        }
        r rVar = (r) obj;
        if (rVar.f11612d != this.f11612d) {
            return false;
        }
        Class<?> cls = this.f11610b;
        return cls != null ? rVar.f11610b == cls : this.f11611c.equals(rVar.f11611c);
    }

    public final int hashCode() {
        return this.f11609a;
    }

    public final String toString() {
        boolean z = this.f11612d;
        Class<?> cls = this.f11610b;
        if (cls != null) {
            return "{class: " + cls.getName() + ", typed? " + z + "}";
        }
        return "{type: " + this.f11611c + ", typed? " + z + "}";
    }

    public r(Class<?> cls, boolean z) {
        this.f11610b = cls;
        this.f11611c = null;
        this.f11612d = z;
        this.f11609a = z ? cls.getName().hashCode() + 1 : cls.getName().hashCode();
    }

    public r(JavaType javaType, boolean z) {
        int i10;
        this.f11611c = javaType;
        this.f11610b = null;
        this.f11612d = z;
        if (z) {
            i10 = javaType.f3691b - 2;
        } else {
            i10 = javaType.f3691b - 1;
        }
        this.f11609a = i10;
    }
}
