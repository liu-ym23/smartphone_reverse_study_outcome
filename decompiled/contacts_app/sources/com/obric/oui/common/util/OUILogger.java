package com.obric.oui.common.util;

import androidx.core.app.NotificationCompat;
import com.GlobalProxyLancet;
import com.android.contacts.common.SimContactsConstants;
import com.obric.oui.calendar.format.DayFormatter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OUILogger.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fJ\"\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\u0016\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0004R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/obric/oui/common/util/OUILogger;", "", "()V", "loggerDelegate", "Lcom/obric/oui/common/util/OUILog;", "getLoggerDelegate", "()Lcom/obric/oui/common/util/OUILog;", "setLoggerDelegate", "(Lcom/obric/oui/common/util/OUILog;)V", DayFormatter.DEFAULT_FORMAT, "", SimContactsConstants.STR_TAG, "", NotificationCompat.CATEGORY_MESSAGE, "e", "throwable", "", "i", "setLogDelegate", "delegate", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OUILogger {
    public static final OUILogger INSTANCE = null;
    private static OUILog loggerDelegate;

    static {
        INSTANCE = new OUILogger();
    }

    private OUILogger() {
    }

    public final OUILog getLoggerDelegate() {
        return loggerDelegate;
    }

    public final void setLoggerDelegate(OUILog r1) {
        loggerDelegate = r1;
    }

    public final void setLogDelegate(OUILog r1) {
        Intrinsics.checkNotNullParameter(r1, "delegate");
        loggerDelegate = r1;
    }

    public final void d(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, SimContactsConstants.STR_TAG);
        Intrinsics.checkNotNullParameter(r2, NotificationCompat.CATEGORY_MESSAGE);
        OUILog r0 = loggerDelegate;
        if (r0 != null) goto L5;
        Unit r3 = null;
    L6:
        if (r3 != null) goto L9;
        Integer.valueOf(GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(r1, r2));
        return;
    L9:
        return;
    L5:
        r0.d(r1, r2);
        r3 = Unit.INSTANCE;
        goto L6
    }

    public final void i(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, SimContactsConstants.STR_TAG);
        Intrinsics.checkNotNullParameter(r2, NotificationCompat.CATEGORY_MESSAGE);
        OUILog r0 = loggerDelegate;
        if (r0 != null) goto L5;
        Unit r3 = null;
    L6:
        if (r3 != null) goto L9;
        Integer.valueOf(GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(r1, r2));
        return;
    L9:
        return;
    L5:
        r0.i(r1, r2);
        r3 = Unit.INSTANCE;
        goto L6
    }

    public static /* synthetic */ void e$default(OUILogger r0, String r1, String r2, Throwable r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = null;
    L5:
        r0.e(r1, r2, r3);
    }

    public final void e(String r1, String r2, Throwable r3) {
        Intrinsics.checkNotNullParameter(r1, SimContactsConstants.STR_TAG);
        Intrinsics.checkNotNullParameter(r2, NotificationCompat.CATEGORY_MESSAGE);
        OUILog r0 = loggerDelegate;
        if (r0 != null) goto L5;
        Unit r4 = null;
    L6:
        if (r4 != null) goto L9;
        Integer.valueOf(GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(r1, r2, r3));
        return;
    L9:
        return;
    L5:
        r0.e(r1, r2, r3);
        r4 = Unit.INSTANCE;
        goto L6
    }
}
