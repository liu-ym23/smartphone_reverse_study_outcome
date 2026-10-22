package ie;

import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final class v0 implements WildcardType {

    /* renamed from: c, reason: collision with root package name */
    public final Type f6093c;

    /* renamed from: f, reason: collision with root package name */
    public final Type f6094f;

    public v0(Type[] typeArr, Type[] typeArr2) {
        if (typeArr2.length > 1) {
            od.f.b();
            throw null;
        }
        if (typeArr.length != 1) {
            od.f.b();
            throw null;
        }
        if (typeArr2.length != 1) {
            typeArr[0].getClass();
            w0.d(typeArr[0]);
            this.f6094f = null;
            this.f6093c = typeArr[0];
            return;
        }
        typeArr2[0].getClass();
        w0.d(typeArr2[0]);
        if (typeArr[0] != Object.class) {
            od.f.b();
            throw null;
        }
        this.f6094f = typeArr2[0];
        this.f6093c = Object.class;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof WildcardType) && w0.e(this, (WildcardType) obj);
    }

    @Override // java.lang.reflect.WildcardType
    public final Type[] getLowerBounds() {
        Type type = this.f6094f;
        return type != null ? new Type[]{type} : w0.f6096a;
    }

    @Override // java.lang.reflect.WildcardType
    public final Type[] getUpperBounds() {
        return new Type[]{this.f6093c};
    }

    public final int hashCode() {
        Type type = this.f6094f;
        return (this.f6093c.hashCode() + 31) ^ (type != null ? type.hashCode() + 31 : 1);
    }

    public final String toString() {
        Type type = this.f6094f;
        if (type != null) {
            return "? super " + w0.s(type);
        }
        Type type2 = this.f6093c;
        if (type2 == Object.class) {
            return "?";
        }
        return "? extends " + w0.s(type2);
    }
}
