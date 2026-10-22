package b5;

import java.io.Serializable;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class i implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final Object f895a;

    public static final Throwable a(Object obj) {
        if (obj instanceof h) {
            return ((h) obj).f894a;
        }
        return null;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof i) {
            return kotlin.jvm.internal.p.a(this.f895a, ((i) obj).f895a);
        }
        return false;
    }

    public final int hashCode() {
        Object obj = this.f895a;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public final String toString() {
        Object obj = this.f895a;
        if (obj instanceof h) {
            return ((h) obj).toString();
        }
        return "Success(" + obj + ')';
    }
}
