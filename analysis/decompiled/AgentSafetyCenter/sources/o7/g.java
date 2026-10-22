package o7;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Objects;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class g implements WildcardType, Serializable {

    /* renamed from: c, reason: collision with root package name */
    public final Type f9254c;

    /* renamed from: f, reason: collision with root package name */
    public final Type f9255f;

    public g(Type[] typeArr, Type[] typeArr2) {
        if (typeArr2.length > 1) {
            g5.f.s("At most one lower bound is supported");
            throw null;
        }
        if (typeArr.length != 1) {
            g5.f.s("Exactly one upper bound must be specified");
            throw null;
        }
        if (typeArr2.length != 1) {
            Objects.requireNonNull(typeArr[0]);
            h.b(typeArr[0]);
            this.f9255f = null;
            this.f9254c = h.a(typeArr[0]);
            return;
        }
        Objects.requireNonNull(typeArr2[0]);
        h.b(typeArr2[0]);
        if (typeArr[0] != Object.class) {
            g5.f.s("When lower bound is specified, upper bound must be Object");
            throw null;
        }
        this.f9255f = h.a(typeArr2[0]);
        this.f9254c = Object.class;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof WildcardType) && h.d(this, (WildcardType) obj);
    }

    @Override // java.lang.reflect.WildcardType
    public final Type[] getLowerBounds() {
        Type type = this.f9255f;
        return type != null ? new Type[]{type} : h.f9256a;
    }

    @Override // java.lang.reflect.WildcardType
    public final Type[] getUpperBounds() {
        return new Type[]{this.f9254c};
    }

    public final int hashCode() {
        Type type = this.f9255f;
        return (this.f9254c.hashCode() + 31) ^ (type != null ? type.hashCode() + 31 : 1);
    }

    public final String toString() {
        Type type = this.f9255f;
        if (type != null) {
            return "? super " + h.l(type);
        }
        Type type2 = this.f9254c;
        if (type2 == Object.class) {
            return "?";
        }
        return "? extends " + h.l(type2);
    }
}
