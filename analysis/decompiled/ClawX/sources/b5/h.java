package b5;

import java.io.Serializable;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class h implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final Throwable f894a;

    public h(Throwable exception) {
        kotlin.jvm.internal.p.e(exception, "exception");
        this.f894a = exception;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof h) {
            return kotlin.jvm.internal.p.a(this.f894a, ((h) obj).f894a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f894a.hashCode();
    }

    public final String toString() {
        return "Failure(" + this.f894a + ')';
    }
}
