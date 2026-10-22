package u0;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;

/* loaded from: classes.dex */
public class k implements ParameterizedType {

    /* renamed from: a, reason: collision with root package name */
    private final Type[] f22795a;

    /* renamed from: b, reason: collision with root package name */
    private final Type f22796b;

    /* renamed from: c, reason: collision with root package name */
    private final Type f22797c;

    public k(Type[] typeArr, Type type, Type type2) {
        this.f22795a = typeArr;
        this.f22796b = type;
        this.f22797c = type2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            k kVar = (k) obj;
            if (!Arrays.equals(this.f22795a, kVar.f22795a)) {
                return false;
            }
            Type type = this.f22796b;
            if (type == null ? kVar.f22796b != null : !type.equals(kVar.f22796b)) {
                return false;
            }
            Type type2 = this.f22797c;
            if (type2 != null) {
                return type2.equals(kVar.f22797c);
            }
            if (kVar.f22797c == null) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type[] getActualTypeArguments() {
        return this.f22795a;
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type getOwnerType() {
        return this.f22796b;
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type getRawType() {
        return this.f22797c;
    }

    public int hashCode() {
        Type[] typeArr = this.f22795a;
        int iHashCode = (typeArr != null ? Arrays.hashCode(typeArr) : 0) * 31;
        Type type = this.f22796b;
        int iHashCode2 = (iHashCode + (type != null ? type.hashCode() : 0)) * 31;
        Type type2 = this.f22797c;
        return iHashCode2 + (type2 != null ? type2.hashCode() : 0);
    }
}
