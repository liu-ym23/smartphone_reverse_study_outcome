package jb;

import java.io.Serializable;
import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class i implements Serializable {

    /* renamed from: c, reason: collision with root package name */
    public Object f6762c;

    public static final /* synthetic */ i a(Object obj) {
        i iVar = new i();
        iVar.f6762c = obj;
        VarHandle.storeStoreFence();
        return iVar;
    }

    public static final Throwable b(Object obj) {
        if (obj instanceof h) {
            return ((h) obj).f6761c;
        }
        return null;
    }

    public static String c(Object obj) {
        if (obj instanceof h) {
            return ((h) obj).toString();
        }
        return "Success(" + obj + ')';
    }

    public final boolean equals(Object obj) {
        return (obj instanceof i) && yb.k.a(this.f6762c, ((i) obj).f6762c);
    }

    public final int hashCode() {
        Object obj = this.f6762c;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public final String toString() {
        return c(this.f6762c);
    }
}
