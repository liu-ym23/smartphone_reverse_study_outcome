package com.android.server.notification;

import android.content.Context;
import com.android.internal.compat.IPlatformCompat;

/* JADX INFO: loaded from: classes2.dex */
public interface NotificationSignalExtractor {
    void initialize(Context r1, NotificationUsageStats r2);

    RankingReconsideration process(NotificationRecord r1);

    void setConfig(RankingConfig r1);

    void setZenHelper(ZenModeHelper r1);

    default void setCompatChangeLogger(IPlatformCompat platformCompat) {
    }

    default void setGroupHelper(GroupHelper groupHelper) {
    }
}
