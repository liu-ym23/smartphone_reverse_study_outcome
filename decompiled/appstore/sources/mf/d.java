package mf;

import io.reactivex.internal.util.NotificationLite;

/* JADX INFO: loaded from: classes4.dex */
public final class d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d f22299b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f22300a;

    static {
        f22299b = new d(null);
    }

    public d(Object r10) {
        this.f22300a = r10;
    }

    public static d a() {
        return f22299b;
    }

    public static d b(Throwable r10) {
        io.reactivex.internal.functions.a.b(r10, "error is null");
        return new d(NotificationLite.error(r10));
    }

    public static d c(Object r10) {
        io.reactivex.internal.functions.a.b(r10, "value is null");
        return new d(r10);
    }

    public Throwable d() {
        Object r10 = this.f22300a;
        if (NotificationLite.isError(r10) == true) goto L5;
        return null;
    L5:
        return NotificationLite.getError(r10);
    }

    public boolean e() {
        return NotificationLite.isError(this.f22300a);
    }

    public boolean equals(Object r10) {
        if ((r10 instanceof d) == true) goto L5;
        return false;
    L5:
        return io.reactivex.internal.functions.a.a(this.f22300a, ((d) r10).f22300a);
    }

    public int hashCode() {
        Object r10 = this.f22300a;
        if (r10 != null) goto L7;
        return 0;
    L7:
        return r10.hashCode();
    }

    public String toString() {
        Object r10 = this.f22300a;
        if (r10 != null) goto L7;
        return "OnCompleteNotification";
    L7:
        if (NotificationLite.isError(r10) == false) goto L11;
        return "OnErrorNotification[" + NotificationLite.getError(r10) + "]";
    L11:
        return "OnNextNotification[" + this.f22300a + "]";
    }
}
