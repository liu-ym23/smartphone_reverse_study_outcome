package ie;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Objects;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final class u0 implements ParameterizedType {

    /* renamed from: c, reason: collision with root package name */
    public final Type f6083c;

    /* renamed from: f, reason: collision with root package name */
    public final Type f6084f;

    /* renamed from: g, reason: collision with root package name */
    public final Type[] f6085g;

    public u0(Type type, Type type2, Type... typeArr) {
        if (type2 instanceof Class) {
            if ((type == null) != (((Class) type2).getEnclosingClass() == null)) {
                od.f.b();
                throw null;
            }
        }
        for (Type type3 : typeArr) {
            Objects.requireNonNull(type3, "typeArgument == null");
            w0.d(type3);
        }
        this.f6083c = type;
        this.f6084f = type2;
        this.f6085g = (Type[]) typeArr.clone();
    }

    public final boolean equals(Object obj) {
        return (obj instanceof ParameterizedType) && w0.e(this, (ParameterizedType) obj);
    }

    @Override // java.lang.reflect.ParameterizedType
    public final Type[] getActualTypeArguments() {
        return (Type[]) this.f6085g.clone();
    }

    @Override // java.lang.reflect.ParameterizedType
    public final Type getOwnerType() {
        return this.f6083c;
    }

    @Override // java.lang.reflect.ParameterizedType
    public final Type getRawType() {
        return this.f6084f;
    }

    public final int hashCode() {
        int iHashCode = Arrays.hashCode(this.f6085g) ^ this.f6084f.hashCode();
        Type type = this.f6083c;
        return (type != null ? type.hashCode() : 0) ^ iHashCode;
    }

    public final String toString() {
        Type[] typeArr = this.f6085g;
        int length = typeArr.length;
        Type type = this.f6084f;
        if (length == 0) {
            return w0.s(type);
        }
        StringBuilder sb2 = new StringBuilder((typeArr.length + 1) * 30);
        sb2.append(w0.s(type));
        sb2.append("<");
        sb2.append(w0.s(typeArr[0]));
        for (int i = 1; i < typeArr.length; i++) {
            sb2.append(", ");
            sb2.append(w0.s(typeArr[i]));
        }
        sb2.append(">");
        return sb2.toString();
    }
}
