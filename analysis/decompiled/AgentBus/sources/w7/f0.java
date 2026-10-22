package w7;

import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class f0 implements WildcardType, Type {

    /* renamed from: h, reason: collision with root package name */
    public static final f0 f10867h = new f0(null, null);

    /* renamed from: f, reason: collision with root package name */
    public final Type f10868f;

    /* renamed from: g, reason: collision with root package name */
    public final Type f10869g;

    public f0(Type type, Type type2) {
        this.f10868f = type;
        this.f10869g = type2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof WildcardType)) {
            return false;
        }
        WildcardType wildcardType = (WildcardType) obj;
        return Arrays.equals(getUpperBounds(), wildcardType.getUpperBounds()) && Arrays.equals(getLowerBounds(), wildcardType.getLowerBounds());
    }

    @Override // java.lang.reflect.WildcardType
    public final Type[] getLowerBounds() {
        Type type = this.f10869g;
        return type == null ? new Type[0] : new Type[]{type};
    }

    @Override // java.lang.reflect.Type
    public final String getTypeName() {
        Type type = this.f10869g;
        if (type != null) {
            return "? super " + e0.d(type);
        }
        Type type2 = this.f10868f;
        if (type2 == null || q7.k.a(type2, Object.class)) {
            return "?";
        }
        return "? extends " + e0.d(type2);
    }

    @Override // java.lang.reflect.WildcardType
    public final Type[] getUpperBounds() {
        Type type = this.f10868f;
        if (type == null) {
            type = Object.class;
        }
        return new Type[]{type};
    }

    public final int hashCode() {
        return Arrays.hashCode(getLowerBounds()) ^ Arrays.hashCode(getUpperBounds());
    }

    public final String toString() {
        return getTypeName();
    }
}
