package s0;

import android.app.Notification;

/* renamed from: s0.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0852j {

    /* renamed from: a, reason: collision with root package name */
    public final int f14204a;

    /* renamed from: b, reason: collision with root package name */
    public final int f14205b;

    /* renamed from: c, reason: collision with root package name */
    public final Notification f14206c;

    public C0852j(int i4, int i5, Notification notification) {
        this.f14204a = i4;
        this.f14206c = notification;
        this.f14205b = i5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C0852j.class != obj.getClass()) {
            return false;
        }
        C0852j c0852j = (C0852j) obj;
        if (this.f14204a == c0852j.f14204a && this.f14205b == c0852j.f14205b) {
            return this.f14206c.equals(c0852j.f14206c);
        }
        return false;
    }

    public final int hashCode() {
        return this.f14206c.hashCode() + (((this.f14204a * 31) + this.f14205b) * 31);
    }

    public final String toString() {
        return "ForegroundInfo{mNotificationId=" + this.f14204a + ", mForegroundServiceType=" + this.f14205b + ", mNotification=" + this.f14206c + '}';
    }
}
