package qa;

import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;

/* loaded from: classes4.dex */
public final class T implements WildcardType {

    /* renamed from: a, reason: collision with root package name */
    public final Type f5650a;
    public final Type b;

    public T(Type[] typeArr, Type[] typeArr2) {
        if (typeArr2.length > 1) {
            throw new IllegalArgumentException();
        }
        if (typeArr.length != 1) {
            throw new IllegalArgumentException();
        }
        if (typeArr2.length != 1) {
            typeArr[0].getClass();
            U.b(typeArr[0]);
            this.b = null;
            this.f5650a = typeArr[0];
            return;
        }
        typeArr2[0].getClass();
        U.b(typeArr2[0]);
        if (typeArr[0] != Object.class) {
            throw new IllegalArgumentException();
        }
        this.b = typeArr2[0];
        this.f5650a = Object.class;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof WildcardType) && U.c(this, (WildcardType) obj);
    }

    @Override // java.lang.reflect.WildcardType
    public final Type[] getLowerBounds() {
        Type type = this.b;
        return type != null ? new Type[]{type} : U.f5651a;
    }

    @Override // java.lang.reflect.WildcardType
    public final Type[] getUpperBounds() {
        return new Type[]{this.f5650a};
    }

    public final int hashCode() {
        Type type = this.b;
        return (this.f5650a.hashCode() + 31) ^ (type != null ? type.hashCode() + 31 : 1);
    }

    public final String toString() {
        Type type = this.b;
        if (type != null) {
            return "? super " + U.p(type);
        }
        Type type2 = this.f5650a;
        if (type2 == Object.class) {
            return "?";
        }
        return "? extends " + U.p(type2);
    }
}
