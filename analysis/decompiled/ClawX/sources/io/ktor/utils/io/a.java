package io.ktor.utils.io;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class a implements g {

    /* renamed from: b, reason: collision with root package name */
    public final Throwable f3173b;

    public a(Throwable th) {
        this.f3173b = th;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof a) && kotlin.jvm.internal.p.a(this.f3173b, ((a) obj).f3173b);
    }

    public final int hashCode() {
        Throwable th = this.f3173b;
        if (th == null) {
            return 0;
        }
        return th.hashCode();
    }

    public final String toString() {
        return "Closed(cause=" + this.f3173b + ')';
    }
}
