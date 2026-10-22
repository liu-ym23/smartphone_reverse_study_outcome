package com.android.server.notification;

import android.util.Slog;
import java.util.Comparator;

/* JADX INFO: loaded from: classes2.dex */
public class GlobalSortKeyComparator implements Comparator<NotificationRecord> {
    private static final String TAG = "GlobalSortComp";

    public GlobalSortKeyComparator() {
    }

    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(NotificationRecord r1, NotificationRecord r2) {
        return compare2(r1, r2);
    }

    /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
    public int compare2(NotificationRecord left, NotificationRecord right) {
        if (left.getGlobalSortKey() != null) goto L7;
        Slog.wtf(TAG, "Missing left global sort key: " + left);
        return 1;
    L7:
        if (right.getGlobalSortKey() != null) goto L11;
        Slog.wtf(TAG, "Missing right global sort key: " + right);
        return -1;
    L11:
        return left.getGlobalSortKey().compareTo(right.getGlobalSortKey());
    }
}
