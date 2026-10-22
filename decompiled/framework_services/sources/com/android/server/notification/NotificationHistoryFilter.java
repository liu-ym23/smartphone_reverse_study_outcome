package com.android.server.notification;

import android.app.NotificationHistory;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class NotificationHistoryFilter {
    private String mChannel;
    private int mNotificationCount;
    private String mPackage;

    public static final class Builder {
        private String mChannel;
        private int mNotificationCount;
        private String mPackage;

        public Builder() {
            this.mPackage = null;
            this.mChannel = null;
            this.mNotificationCount = Integer.MAX_VALUE;
        }

        public Builder setPackage(String aPackage) {
            this.mPackage = aPackage;
            return this;
        }

        public Builder setChannel(String pkg, String channel) {
            setPackage(pkg);
            this.mChannel = channel;
            return this;
        }

        public Builder setMaxNotifications(int notificationCount) {
            this.mNotificationCount = notificationCount;
            return this;
        }

        public NotificationHistoryFilter build() {
            NotificationHistoryFilter filter = new NotificationHistoryFilter(null);
            NotificationHistoryFilter.m6119$$Nest$fputmPackage(filter, this.mPackage);
            NotificationHistoryFilter.m6117$$Nest$fputmChannel(filter, this.mChannel);
            NotificationHistoryFilter.m6118$$Nest$fputmNotificationCount(filter, this.mNotificationCount);
            return filter;
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fputmChannel, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6117$$Nest$fputmChannel(NotificationHistoryFilter r0, String r1) {
        r0.mChannel = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmNotificationCount, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6118$$Nest$fputmNotificationCount(NotificationHistoryFilter r0, int r1) {
        r0.mNotificationCount = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmPackage, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6119$$Nest$fputmPackage(NotificationHistoryFilter r0, String r1) {
        r0.mPackage = r1;
    }

    /* synthetic */ NotificationHistoryFilter(NotificationHistoryFilterIA r1) {
        this();
    }

    private NotificationHistoryFilter() {
    }

    public String getPackage() {
        return this.mPackage;
    }

    public String getChannel() {
        return this.mChannel;
    }

    public int getMaxNotifications() {
        return this.mNotificationCount;
    }

    public boolean isFiltering() {
        if (getPackage() == null) goto L5;
    L10:
        return true;
    L5:
        if (getChannel() != null) goto L10;
        if (this.mNotificationCount < Integer.MAX_VALUE) goto L10;
        return false;
    }

    public boolean matchesPackageAndChannelFilter(NotificationHistory.HistoricalNotification notification) {
        if (TextUtils.isEmpty(getPackage()) == false) goto L5;
        return true;
    L5:
        if (getPackage().equals(notification.getPackage()) == true) goto L8;
        return false;
    L8:
        if (TextUtils.isEmpty(getChannel()) == false) goto L10;
        return true;
    L10:
        if (getChannel().equals(notification.getChannelId()) == true) goto L15;
        return false;
    L15:
        return true;
    }

    public boolean matchesCountFilter(NotificationHistory notifications) {
        if (notifications.getHistoryCount() >= this.mNotificationCount) goto L5;
        return true;
    L5:
        return false;
    }
}
