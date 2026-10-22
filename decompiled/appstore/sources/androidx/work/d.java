package androidx.work;

import android.app.Notification;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5409a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f5410b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Notification f5411c;

    public d(int r10, Notification r11, int r12) {
        this.f5409a = r10;
        this.f5411c = r11;
        this.f5410b = r12;
    }

    public int a() {
        return this.f5410b;
    }

    public Notification b() {
        return this.f5411c;
    }

    public int c() {
        return this.f5409a;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if (r10 != null) goto L8;
    L18:
        return false;
    L8:
        if (d.class != r10.getClass()) goto L18;
        d r11 = (d) r10;
        if (this.f5409a == r11.f5409a) goto L14;
        return false;
    L14:
        if (this.f5410b == r11.f5410b) goto L17;
        return false;
    L17:
        return this.f5411c.equals(r11.f5411c);
    }

    public int hashCode() {
        return (((this.f5409a * 31) + this.f5410b) * 31) + this.f5411c.hashCode();
    }

    public String toString() {
        return "ForegroundInfo{mNotificationId=" + this.f5409a + ", mForegroundServiceType=" + this.f5410b + ", mNotification=" + this.f5411c + '}';
    }
}
