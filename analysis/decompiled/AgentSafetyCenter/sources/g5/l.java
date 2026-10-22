package g5;

import android.app.Notification;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public final int f4327a;

    /* renamed from: b, reason: collision with root package name */
    public final int f4328b;

    /* renamed from: c, reason: collision with root package name */
    public final Notification f4329c;

    public l(int i, Notification notification, int i3) {
        this.f4327a = i;
        this.f4329c = notification;
        this.f4328b = i3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || l.class != obj.getClass()) {
            return false;
        }
        l lVar = (l) obj;
        if (this.f4327a == lVar.f4327a && this.f4328b == lVar.f4328b) {
            return this.f4329c.equals(lVar.f4329c);
        }
        return false;
    }

    public final int hashCode() {
        return this.f4329c.hashCode() + (((this.f4327a * 31) + this.f4328b) * 31);
    }

    public final String toString() {
        return "ForegroundInfo{mNotificationId=" + this.f4327a + ", mForegroundServiceType=" + this.f4328b + ", mNotification=" + this.f4329c + '}';
    }
}
