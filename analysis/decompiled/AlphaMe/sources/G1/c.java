package G1;

import ch.qos.logback.classic.spi.CallerData;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Objects;
import t0.J;

/* loaded from: classes.dex */
public final class c implements WildcardType, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final Type f588a;

    /* renamed from: b, reason: collision with root package name */
    public final Type f589b;

    public c(Type[] typeArr, Type[] typeArr2) {
        J.j(typeArr2.length <= 1);
        J.j(typeArr.length == 1);
        if (typeArr2.length != 1) {
            Objects.requireNonNull(typeArr[0]);
            d.b(typeArr[0]);
            this.f589b = null;
            this.f588a = d.a(typeArr[0]);
            return;
        }
        Objects.requireNonNull(typeArr2[0]);
        d.b(typeArr2[0]);
        J.j(typeArr[0] == Object.class);
        this.f589b = d.a(typeArr2[0]);
        this.f588a = Object.class;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof WildcardType) && d.c(this, (WildcardType) obj);
    }

    @Override // java.lang.reflect.WildcardType
    public final Type[] getLowerBounds() {
        Type type = this.f589b;
        return type != null ? new Type[]{type} : d.f590a;
    }

    @Override // java.lang.reflect.WildcardType
    public final Type[] getUpperBounds() {
        return new Type[]{this.f588a};
    }

    public final int hashCode() {
        Type type = this.f589b;
        return (this.f588a.hashCode() + 31) ^ (type != null ? type.hashCode() + 31 : 1);
    }

    public final String toString() {
        Type type = this.f589b;
        if (type != null) {
            return "? super " + d.g(type);
        }
        Type type2 = this.f588a;
        if (type2 == Object.class) {
            return CallerData.NA;
        }
        return "? extends " + d.g(type2);
    }
}
