package o2;

import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class f implements Comparable {

    /* renamed from: c, reason: collision with root package name */
    public float f9114c;

    public static final /* synthetic */ f a(float f5) {
        f fVar = new f();
        fVar.f9114c = f5;
        VarHandle.storeStoreFence();
        return fVar;
    }

    public static final boolean b(float f5, float f10) {
        return Float.compare(f5, f10) == 0;
    }

    public static String c(float f5) {
        if (Float.isNaN(f5)) {
            return "Dp.Unspecified";
        }
        return f5 + ".dp";
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return Float.compare(this.f9114c, ((f) obj).f9114c);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof f) && Float.compare(this.f9114c, ((f) obj).f9114c) == 0;
    }

    public final int hashCode() {
        return Float.hashCode(this.f9114c);
    }

    public final String toString() {
        return c(this.f9114c);
    }
}
