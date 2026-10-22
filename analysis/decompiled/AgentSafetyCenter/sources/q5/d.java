package q5;

import android.net.NetworkRequest;
import g5.u;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: b, reason: collision with root package name */
    public static final String f10083b = u.f("NetworkRequestCompat");

    /* renamed from: a, reason: collision with root package name */
    public final Object f10084a;

    public d(NetworkRequest networkRequest) {
        this.f10084a = networkRequest;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof d) && yb.k.a(this.f10084a, ((d) obj).f10084a);
    }

    public final int hashCode() {
        Object obj = this.f10084a;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public final String toString() {
        return "NetworkRequestCompat(wrapped=" + this.f10084a + ')';
    }
}
