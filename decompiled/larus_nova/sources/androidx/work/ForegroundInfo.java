package androidx.work;

import android.app.Notification;

/* JADX INFO: loaded from: classes17.dex */
public final class ForegroundInfo {
    private final int mForegroundServiceType;
    private final Notification mNotification;
    private final int mNotificationId;

    public int hashCode() {
        return (((this.mNotificationId * 31) + this.mForegroundServiceType) * 31) + this.mNotification.hashCode();
    }

    public String toString() {
        return "ForegroundInfo{mNotificationId=" + this.mNotificationId + ", mForegroundServiceType=" + this.mForegroundServiceType + ", mNotification=" + this.mNotification + '}';
    }

    public int getForegroundServiceType() {
        return this.mForegroundServiceType;
    }

    public Notification getNotification() {
        return this.mNotification;
    }

    public int getNotificationId() {
        return this.mNotificationId;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L18:
        return false;
    L8:
        if (ForegroundInfo.class != r100.getClass()) goto L18;
        ForegroundInfo r101 = (ForegroundInfo) r100;
        if (this.mNotificationId == r101.mNotificationId) goto L14;
        return false;
    L14:
        if (this.mForegroundServiceType == r101.mForegroundServiceType) goto L17;
        return false;
    L17:
        return this.mNotification.equals(r101.mNotification);
    }

    public ForegroundInfo(int r100, Notification r101) {
        this(r100, r101, 0);
    }

    public ForegroundInfo(int r100, Notification r101, int r102) {
        this.mNotificationId = r100;
        this.mNotification = r101;
        this.mForegroundServiceType = r102;
    }
}
