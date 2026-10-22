package com.obric.audiocodecsdk.log;

import androidx.core.app.NotificationCompat;
import com.GlobalProxyLancet;
import com.android.contacts.common.SimContactsConstants;
import com.obric.oui.calendar.format.DayFormatter;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Logger.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0011B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bJ \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0016\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bJ \u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0016\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bJ \u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0012\u0010\u000e\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0007J\u0016\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bJ \u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0016\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bJ \u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/obric/audiocodecsdk/log/Logger;", "", "()V", "logger", "Lcom/obric/audiocodecsdk/log/Logger$LoggerIntf;", DayFormatter.DEFAULT_FORMAT, "", SimContactsConstants.STR_TAG, "", NotificationCompat.CATEGORY_MESSAGE, "tr", "", "e", "i", "setLogger", BaseSwitches.V, "w", "LoggerIntf", "sdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Logger {
    public static final Logger INSTANCE = null;
    private static LoggerIntf logger;

    /* JADX INFO: compiled from: Logger.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\"\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\tH&J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\"\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\tH&¨\u0006\r"}, d2 = {"Lcom/obric/audiocodecsdk/log/Logger$LoggerIntf;", "", DayFormatter.DEFAULT_FORMAT, "", SimContactsConstants.STR_TAG, "", NotificationCompat.CATEGORY_MESSAGE, "e", "tr", "", "i", BaseSwitches.V, "w", "sdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface LoggerIntf {
        void d(String r1, String r2);

        void e(String r1, String r2);

        void e(String r1, String r2, Throwable r3);

        void i(String r1, String r2);

        void v(String r1, String r2);

        void w(String r1, String r2);

        void w(String r1, String r2, Throwable r3);
    }

    static {
        INSTANCE = new Logger();
    }

    private Logger() {
    }

    @JvmStatic
    public static final void setLogger(LoggerIntf r0) {
        logger = r0;
    }

    public final void i(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, SimContactsConstants.STR_TAG);
        Intrinsics.checkNotNullParameter(r2, NotificationCompat.CATEGORY_MESSAGE);
        LoggerIntf r0 = logger;
        if (r0 == null) goto L5;
        r0.i(r1, r2);
        return;
    L5:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(r1, r2);
    }

    public final void i(String r2, String r3, Throwable r4) {
        Intrinsics.checkNotNullParameter(r2, SimContactsConstants.STR_TAG);
        Intrinsics.checkNotNullParameter(r3, NotificationCompat.CATEGORY_MESSAGE);
        LoggerIntf r1 = logger;
        if (r1 == null) goto L9;
        StringBuilder r5 = new StringBuilder().append(r3).append('\n');
        if (r4 == null) goto L7;
        String r6 = ExceptionsKt.stackTraceToString(r4);
    L8:
        r1.i(r2, r5.append(r6).toString());
        return;
    L7:
        r6 = null;
        goto L8
    L9:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(r2, r3, r4);
    }

    public final void v(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, SimContactsConstants.STR_TAG);
        Intrinsics.checkNotNullParameter(r2, NotificationCompat.CATEGORY_MESSAGE);
        LoggerIntf r0 = logger;
        if (r0 == null) goto L5;
        r0.v(r1, r2);
        return;
    L5:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_v(r1, r2);
    }

    public final void v(String r2, String r3, Throwable r4) {
        Intrinsics.checkNotNullParameter(r2, SimContactsConstants.STR_TAG);
        Intrinsics.checkNotNullParameter(r3, NotificationCompat.CATEGORY_MESSAGE);
        LoggerIntf r1 = logger;
        if (r1 == null) goto L9;
        StringBuilder r5 = new StringBuilder().append(r3).append('\n');
        if (r4 == null) goto L7;
        String r6 = ExceptionsKt.stackTraceToString(r4);
    L8:
        r1.v(r2, r5.append(r6).toString());
        return;
    L7:
        r6 = null;
        goto L8
    L9:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_v(r2, r3, r4);
    }

    public final void d(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, SimContactsConstants.STR_TAG);
        Intrinsics.checkNotNullParameter(r2, NotificationCompat.CATEGORY_MESSAGE);
        LoggerIntf r0 = logger;
        if (r0 == null) goto L5;
        r0.d(r1, r2);
        return;
    L5:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(r1, r2);
    }

    public final void d(String r2, String r3, Throwable r4) {
        Intrinsics.checkNotNullParameter(r2, SimContactsConstants.STR_TAG);
        Intrinsics.checkNotNullParameter(r3, NotificationCompat.CATEGORY_MESSAGE);
        LoggerIntf r1 = logger;
        if (r1 == null) goto L9;
        StringBuilder r5 = new StringBuilder().append(r3).append('\n');
        if (r4 == null) goto L7;
        String r6 = ExceptionsKt.stackTraceToString(r4);
    L8:
        r1.d(r2, r5.append(r6).toString());
        return;
    L7:
        r6 = null;
        goto L8
    L9:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(r2, r3, r4);
    }

    public final void w(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, SimContactsConstants.STR_TAG);
        Intrinsics.checkNotNullParameter(r2, NotificationCompat.CATEGORY_MESSAGE);
        LoggerIntf r0 = logger;
        if (r0 == null) goto L5;
        r0.w(r1, r2);
        return;
    L5:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(r1, r2);
    }

    public final void w(String r1, String r2, Throwable r3) {
        Intrinsics.checkNotNullParameter(r1, SimContactsConstants.STR_TAG);
        Intrinsics.checkNotNullParameter(r2, NotificationCompat.CATEGORY_MESSAGE);
        LoggerIntf r0 = logger;
        if (r0 == null) goto L5;
        r0.w(r1, r2, r3);
        return;
    L5:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(r1, r2, r3);
    }

    public final void e(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, SimContactsConstants.STR_TAG);
        Intrinsics.checkNotNullParameter(r2, NotificationCompat.CATEGORY_MESSAGE);
        LoggerIntf r0 = logger;
        if (r0 == null) goto L5;
        r0.e(r1, r2);
        return;
    L5:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(r1, r2);
    }

    public final void e(String r1, String r2, Throwable r3) {
        Intrinsics.checkNotNullParameter(r1, SimContactsConstants.STR_TAG);
        Intrinsics.checkNotNullParameter(r2, NotificationCompat.CATEGORY_MESSAGE);
        LoggerIntf r0 = logger;
        if (r0 == null) goto L5;
        r0.e(r1, r2, r3);
        return;
    L5:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(r1, r2, r3);
    }
}
