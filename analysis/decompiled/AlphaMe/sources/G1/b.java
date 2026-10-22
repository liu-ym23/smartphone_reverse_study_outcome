package G1;

import java.io.Serializable;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Objects;
import t0.J;

/* loaded from: classes.dex */
public final class b implements ParameterizedType, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final Type f585a;

    /* renamed from: b, reason: collision with root package name */
    public final Type f586b;

    /* renamed from: c, reason: collision with root package name */
    public final Type[] f587c;

    public b(Type type, Type type2, Type... typeArr) {
        Objects.requireNonNull(type2);
        if (type2 instanceof Class) {
            Class cls = (Class) type2;
            boolean z4 = true;
            boolean z5 = Modifier.isStatic(cls.getModifiers()) || cls.getEnclosingClass() == null;
            if (type == null && !z5) {
                z4 = false;
            }
            J.j(z4);
        }
        this.f585a = type == null ? null : d.a(type);
        this.f586b = d.a(type2);
        Type[] typeArr2 = (Type[]) typeArr.clone();
        this.f587c = typeArr2;
        int length = typeArr2.length;
        for (int i4 = 0; i4 < length; i4++) {
            Objects.requireNonNull(this.f587c[i4]);
            d.b(this.f587c[i4]);
            Type[] typeArr3 = this.f587c;
            typeArr3[i4] = d.a(typeArr3[i4]);
        }
    }

    public final boolean equals(Object obj) {
        return (obj instanceof ParameterizedType) && d.c(this, (ParameterizedType) obj);
    }

    @Override // java.lang.reflect.ParameterizedType
    public final Type[] getActualTypeArguments() {
        return (Type[]) this.f587c.clone();
    }

    @Override // java.lang.reflect.ParameterizedType
    public final Type getOwnerType() {
        return this.f585a;
    }

    @Override // java.lang.reflect.ParameterizedType
    public final Type getRawType() {
        return this.f586b;
    }

    public final int hashCode() {
        int iHashCode = Arrays.hashCode(this.f587c) ^ this.f586b.hashCode();
        Type type = this.f585a;
        return (type != null ? type.hashCode() : 0) ^ iHashCode;
    }

    public final String toString() {
        Type[] typeArr = this.f587c;
        int length = typeArr.length;
        Type type = this.f586b;
        if (length == 0) {
            return d.g(type);
        }
        StringBuilder sb = new StringBuilder((length + 1) * 30);
        sb.append(d.g(type));
        sb.append("<");
        sb.append(d.g(typeArr[0]));
        for (int i4 = 1; i4 < length; i4++) {
            sb.append(", ");
            sb.append(d.g(typeArr[i4]));
        }
        sb.append(">");
        return sb.toString();
    }
}
