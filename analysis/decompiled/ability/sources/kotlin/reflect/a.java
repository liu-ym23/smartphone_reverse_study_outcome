package kotlin.reflect;

import D7.q;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.jvm.internal.k;

/* loaded from: classes3.dex */
public final class a implements ParameterizedType, Type {

    /* renamed from: a, reason: collision with root package name */
    public final Class f4935a;
    public final Type b;
    public final Type[] c;

    public a(Class cls, Type type, ArrayList arrayList) {
        this.f4935a = cls;
        this.b = type;
        this.c = (Type[]) arrayList.toArray(new Type[0]);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ParameterizedType)) {
            return false;
        }
        ParameterizedType parameterizedType = (ParameterizedType) obj;
        return k.b(this.f4935a, parameterizedType.getRawType()) && k.b(this.b, parameterizedType.getOwnerType()) && Arrays.equals(this.c, parameterizedType.getActualTypeArguments());
    }

    @Override // java.lang.reflect.ParameterizedType
    public final Type[] getActualTypeArguments() {
        return this.c;
    }

    @Override // java.lang.reflect.ParameterizedType
    public final Type getOwnerType() {
        return this.b;
    }

    @Override // java.lang.reflect.ParameterizedType
    public final Type getRawType() {
        return this.f4935a;
    }

    @Override // java.lang.reflect.Type
    public final String getTypeName() {
        StringBuilder sb = new StringBuilder();
        Class cls = this.f4935a;
        Type type = this.b;
        if (type != null) {
            sb.append(b.a(type));
            sb.append("$");
            sb.append(cls.getSimpleName());
        } else {
            sb.append(b.a(cls));
        }
        Type[] typeArr = this.c;
        if (typeArr.length != 0) {
            q.v0(typeArr, sb, ", ", "<", ">", "...", ParameterizedTypeImpl$getTypeName$1$1.f4933a);
        }
        return sb.toString();
    }

    public final int hashCode() {
        int iHashCode = this.f4935a.hashCode();
        Type type = this.b;
        return Arrays.hashCode(this.c) ^ (iHashCode ^ (type != null ? type.hashCode() : 0));
    }

    public final String toString() {
        return getTypeName();
    }
}
