package x9;

import java.lang.reflect.Field;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final Object f13762a;

    /* renamed from: b, reason: collision with root package name */
    public final Field f13763b;

    /* renamed from: c, reason: collision with root package name */
    public final int f13764c;

    public b(Object obj, Field field, int i10) {
        this.f13762a = obj;
        this.f13763b = field;
        this.f13764c = i10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return kotlin.jvm.internal.g.b(this.f13762a, bVar.f13762a) && kotlin.jvm.internal.g.b(this.f13763b, bVar.f13763b) && this.f13764c == bVar.f13764c;
    }

    public final int hashCode() {
        Object obj = this.f13762a;
        int iHashCode = obj == null ? 0 : obj.hashCode();
        return Integer.hashCode(this.f13764c) + ((this.f13763b.hashCode() + (iHashCode * 31)) * 31);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("FieldInfo(target=");
        sb2.append(this.f13762a);
        sb2.append(", field=");
        sb2.append(this.f13763b);
        sb2.append(", depth=");
        return ai.onnxruntime.a.j(")", this.f13764c, sb2);
    }
}
