package L1;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;

/* loaded from: classes.dex */
public class c implements ParameterizedType {

    /* renamed from: a, reason: collision with root package name */
    public final Type[] f4283a;

    /* renamed from: b, reason: collision with root package name */
    public final Type f4284b;

    /* renamed from: c, reason: collision with root package name */
    public final Type f4285c;

    public c(Type[] typeArr, Type type, Type type2) {
        this.f4283a = typeArr;
        this.f4284b = type;
        this.f4285c = type2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            c cVar = (c) obj;
            if (!Arrays.equals(this.f4283a, cVar.f4283a)) {
                return false;
            }
            Type type = this.f4284b;
            if (type == null ? cVar.f4284b != null : !type.equals(cVar.f4284b)) {
                return false;
            }
            Type type2 = this.f4285c;
            if (type2 != null) {
                return type2.equals(cVar.f4285c);
            }
            if (cVar.f4285c == null) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type[] getActualTypeArguments() {
        return this.f4283a;
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type getOwnerType() {
        return this.f4284b;
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type getRawType() {
        return this.f4285c;
    }

    public int hashCode() {
        Type[] typeArr = this.f4283a;
        int iHashCode = (typeArr != null ? Arrays.hashCode(typeArr) : 0) * 31;
        Type type = this.f4284b;
        int iHashCode2 = (iHashCode + (type != null ? type.hashCode() : 0)) * 31;
        Type type2 = this.f4285c;
        return iHashCode2 + (type2 != null ? type2.hashCode() : 0);
    }
}
