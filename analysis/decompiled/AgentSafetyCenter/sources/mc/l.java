package mc;

import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class l {

    /* renamed from: b, reason: collision with root package name */
    public static final k f8595b = new k();

    /* renamed from: a, reason: collision with root package name */
    public Object f8596a;

    public static final /* synthetic */ l a(Object obj) {
        l lVar = new l();
        lVar.f8596a = obj;
        VarHandle.storeStoreFence();
        return lVar;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof l) && yb.k.a(this.f8596a, ((l) obj).f8596a);
    }

    public final int hashCode() {
        Object obj = this.f8596a;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public final String toString() {
        Object obj = this.f8596a;
        if (obj instanceof j) {
            return ((j) obj).toString();
        }
        return "Value(" + obj + ')';
    }
}
