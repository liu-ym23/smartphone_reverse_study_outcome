package b8;

import java.lang.reflect.Type;
import java.util.Arrays;

/* loaded from: classes4.dex */
public final class Q implements Type {

    /* renamed from: a, reason: collision with root package name */
    public final Type[] f2027a;
    public final int b;

    public Q(Type[] types) {
        kotlin.jvm.internal.k.f(types, "types");
        this.f2027a = types;
        this.b = Arrays.hashCode(types);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Q) {
            return Arrays.equals(this.f2027a, ((Q) obj).f2027a);
        }
        return false;
    }

    @Override // java.lang.reflect.Type
    public final String getTypeName() {
        return D7.q.x0(this.f2027a, ", ", "[", "]", null, 56);
    }

    public final int hashCode() {
        return this.b;
    }

    public final String toString() {
        return getTypeName();
    }
}
