package r2;

import android.net.NetworkRequest;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: b, reason: collision with root package name */
    public static final String f11692b;

    /* renamed from: a, reason: collision with root package name */
    public final Object f11693a;

    static {
        String strF = h2.j.f("NetworkRequestCompat");
        kotlin.jvm.internal.g.e(strF, "tagWithPrefix(\"NetworkRequestCompat\")");
        f11692b = strF;
    }

    public g(NetworkRequest networkRequest) {
        this.f11693a = networkRequest;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof g) && kotlin.jvm.internal.g.b(this.f11693a, ((g) obj).f11693a);
    }

    public final int hashCode() {
        Object obj = this.f11693a;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public final String toString() {
        return "NetworkRequestCompat(wrapped=" + this.f11693a + ')';
    }
}
