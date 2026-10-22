package w7;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class a0 implements ParameterizedType, Type {

    /* renamed from: f, reason: collision with root package name */
    public final Class f10860f;

    /* renamed from: g, reason: collision with root package name */
    public final Type f10861g;

    /* renamed from: h, reason: collision with root package name */
    public final Type[] f10862h;

    public a0(Class cls, Type type, ArrayList arrayList) {
        this.f10860f = cls;
        this.f10861g = type;
        this.f10862h = (Type[]) arrayList.toArray(new Type[0]);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ParameterizedType)) {
            return false;
        }
        ParameterizedType parameterizedType = (ParameterizedType) obj;
        return q7.k.a(this.f10860f, parameterizedType.getRawType()) && q7.k.a(this.f10861g, parameterizedType.getOwnerType()) && Arrays.equals(this.f10862h, parameterizedType.getActualTypeArguments());
    }

    @Override // java.lang.reflect.ParameterizedType
    public final Type[] getActualTypeArguments() {
        return this.f10862h;
    }

    @Override // java.lang.reflect.ParameterizedType
    public final Type getOwnerType() {
        return this.f10861g;
    }

    @Override // java.lang.reflect.ParameterizedType
    public final Type getRawType() {
        return this.f10860f;
    }

    @Override // java.lang.reflect.Type
    public final String getTypeName() {
        StringBuilder sb2 = new StringBuilder();
        Class cls = this.f10860f;
        Type type = this.f10861g;
        if (type != null) {
            sb2.append(e0.d(type));
            sb2.append("$");
            sb2.append(cls.getSimpleName());
        } else {
            sb2.append(e0.d(cls));
        }
        Type[] typeArr = this.f10862h;
        if (typeArr.length != 0) {
            d7.n.m0(typeArr, sb2, ", ", "<", ">", "...", z.f10881n);
        }
        return sb2.toString();
    }

    public final int hashCode() {
        int iHashCode = this.f10860f.hashCode();
        Type type = this.f10861g;
        return Arrays.hashCode(this.f10862h) ^ (iHashCode ^ (type != null ? type.hashCode() : 0));
    }

    public final String toString() {
        return getTypeName();
    }
}
