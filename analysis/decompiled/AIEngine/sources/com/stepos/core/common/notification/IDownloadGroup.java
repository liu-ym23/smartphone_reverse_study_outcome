package com.stepos.core.common.notification;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public interface IDownloadGroup {
    String formatFileSizeSplit();

    int getCheckId();

    String getModelType();

    DownloadNotificationState getNotification();

    String getNotifyTitle();

    float getProgressIn1();

    long getRestartTime();

    long getTotalSize();

    boolean hasFlag(int i10);

    void setRestartTime(long j10);
}
