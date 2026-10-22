package a2;

import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: b, reason: collision with root package name */
    public static final f f43b;

    /* renamed from: a, reason: collision with root package name */
    public ec.c f44a;

    static {
        ec.c cVar = new ec.c();
        VarHandle.storeStoreFence();
        f fVar = new f();
        fVar.f44a = cVar;
        if (Float.isNaN(0.0f)) {
            g5.f.s("current must not be NaN");
        } else {
            VarHandle.storeStoreFence();
            f43b = fVar;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof f) && this.f44a.equals(((f) obj).f44a);
    }

    public final int hashCode() {
        return (this.f44a.hashCode() + (Float.hashCode(0.0f) * 31)) * 31;
    }

    public final String toString() {
        return "ProgressBarRangeInfo(current=0.0, range=" + this.f44a + ", steps=0)";
    }
}
