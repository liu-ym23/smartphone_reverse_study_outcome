package com.obric.utils;

import androidx.core.app.NotificationCompat;
import com.GlobalProxyLancet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NewContactsTraceLog.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004J\u000e\u0010\b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/obric/utils/NewContactsTraceLog;", "", "()V", "TAG", "", "onCallLogPageLog", "", NotificationCompat.CATEGORY_MESSAGE, "onNewContactsPageLog", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NewContactsTraceLog {
    public static final NewContactsTraceLog INSTANCE = null;
    public static final String TAG = "NewContactsTraceLog";

    static {
        INSTANCE = new NewContactsTraceLog();
    }

    private NewContactsTraceLog() {
    }

    public final void onCallLogPageLog(String r2) {
        Intrinsics.checkNotNullParameter(r2, NotificationCompat.CATEGORY_MESSAGE);
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "CallLogPage: " + r2);
    }

    public final void onNewContactsPageLog(String r2) {
        Intrinsics.checkNotNullParameter(r2, NotificationCompat.CATEGORY_MESSAGE);
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "NewContactsPage: " + r2);
    }
}
