package com.android.server.notification;

import java.util.Comparator;

/* JADX INFO: loaded from: classes2.dex */
public class NotificationTimeComparator implements Comparator<NotificationRecord> {
    public NotificationTimeComparator() {
    }

    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(NotificationRecord r1, NotificationRecord r2) {
        return compare2(r1, r2);
    }

    /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
    public int compare2(NotificationRecord left, NotificationRecord right) {
        return Long.compare(left.getRankingTimeMs(), right.getRankingTimeMs()) * (-1);
    }
}
