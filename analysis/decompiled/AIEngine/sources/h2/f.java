package h2;

import android.app.Notification;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final int f9268a;

    /* renamed from: b, reason: collision with root package name */
    public final int f9269b;

    /* renamed from: c, reason: collision with root package name */
    public final Notification f9270c;

    public f(int i10, int i11, Notification notification) {
        this.f9268a = i10;
        this.f9270c = notification;
        this.f9269b = i11;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || f.class != obj.getClass()) {
            return false;
        }
        f fVar = (f) obj;
        if (this.f9268a == fVar.f9268a && this.f9269b == fVar.f9269b) {
            return this.f9270c.equals(fVar.f9270c);
        }
        return false;
    }

    public final int hashCode() {
        return this.f9270c.hashCode() + (((this.f9268a * 31) + this.f9269b) * 31);
    }

    public final String toString() {
        return "ForegroundInfo{mNotificationId=" + this.f9268a + ", mForegroundServiceType=" + this.f9269b + ", mNotification=" + this.f9270c + '}';
    }
}
