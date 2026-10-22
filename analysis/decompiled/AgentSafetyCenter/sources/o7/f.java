package o7;

import java.io.Serializable;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Objects;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class f implements ParameterizedType, Serializable {

    /* renamed from: c, reason: collision with root package name */
    public final Type f9251c;

    /* renamed from: f, reason: collision with root package name */
    public final Type f9252f;

    /* renamed from: g, reason: collision with root package name */
    public final Type[] f9253g;

    public f(Type type, Class cls, Type... typeArr) {
        Objects.requireNonNull(cls);
        if (type == null && !Modifier.isStatic(cls.getModifiers()) && cls.getDeclaringClass() != null) {
            g5.f.p(cls, "Must specify owner type for ");
            throw null;
        }
        this.f9251c = type == null ? null : h.a(type);
        this.f9252f = h.a(cls);
        Type[] typeArr2 = (Type[]) typeArr.clone();
        this.f9253g = typeArr2;
        int length = typeArr2.length;
        for (int i = 0; i < length; i++) {
            Objects.requireNonNull(this.f9253g[i]);
            h.b(this.f9253g[i]);
            Type[] typeArr3 = this.f9253g;
            typeArr3[i] = h.a(typeArr3[i]);
        }
    }

    public final boolean equals(Object obj) {
        return (obj instanceof ParameterizedType) && h.d(this, (ParameterizedType) obj);
    }

    @Override // java.lang.reflect.ParameterizedType
    public final Type[] getActualTypeArguments() {
        return (Type[]) this.f9253g.clone();
    }

    @Override // java.lang.reflect.ParameterizedType
    public final Type getOwnerType() {
        return this.f9251c;
    }

    @Override // java.lang.reflect.ParameterizedType
    public final Type getRawType() {
        return this.f9252f;
    }

    public final int hashCode() {
        int iHashCode = Arrays.hashCode(this.f9253g) ^ this.f9252f.hashCode();
        Type type = this.f9251c;
        return (type != null ? type.hashCode() : 0) ^ iHashCode;
    }

    public final String toString() {
        Type[] typeArr = this.f9253g;
        int length = typeArr.length;
        Type type = this.f9252f;
        if (length == 0) {
            return h.l(type);
        }
        StringBuilder sb2 = new StringBuilder((length + 1) * 30);
        sb2.append(h.l(type));
        sb2.append("<");
        sb2.append(h.l(typeArr[0]));
        for (int i = 1; i < length; i++) {
            sb2.append(", ");
            sb2.append(h.l(typeArr[i]));
        }
        sb2.append(">");
        return sb2.toString();
    }
}
