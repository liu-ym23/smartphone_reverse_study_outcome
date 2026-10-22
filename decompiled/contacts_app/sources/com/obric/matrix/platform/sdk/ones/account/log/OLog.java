package com.obric.matrix.platform.sdk.ones.account.log;

import androidx.core.app.NotificationCompat;
import com.android.contacts.common.SimContactsConstants;
import com.obric.matrix.platform.sdk.ones.account.api.ILogger;
import com.obric.oui.calendar.format.DayFormatter;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OLog.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0007J\"\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0007J\"\u0010\u000f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0018\u0010\u0010\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0007J\"\u0010\u0010\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0018\u0010\u0011\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0007J\"\u0010\u0011\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0018\u0010\u0012\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0007J\"\u0010\u0012\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016R\u001a\u0010\u0003\u001a\u00020\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/account/log/OLog;", "Lcom/obric/matrix/platform/sdk/ones/account/api/ILogger;", "()V", "loggerProxy", "getLoggerProxy", "()Lcom/obric/matrix/platform/sdk/ones/account/api/ILogger;", "setLoggerProxy", "(Lcom/obric/matrix/platform/sdk/ones/account/api/ILogger;)V", DayFormatter.DEFAULT_FORMAT, "", SimContactsConstants.STR_TAG, "", NotificationCompat.CATEGORY_MESSAGE, "tr", "", "e", "i", BaseSwitches.V, "w", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OLog implements ILogger {
    public static final OLog INSTANCE = null;
    private static ILogger loggerProxy;

    private OLog() {
    }

    static {
        INSTANCE = new OLog();
        loggerProxy = new OLog$loggerProxy$1();
    }

    public final ILogger getLoggerProxy() {
        return loggerProxy;
    }

    public final void setLoggerProxy(ILogger r1) {
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        loggerProxy = r1;
    }

    @Override // com.obric.matrix.platform.sdk.ones.account.api.ILogger
    public void v(String r1, String r2, Throwable r3) {
        Intrinsics.checkNotNullParameter(r1, SimContactsConstants.STR_TAG);
        Intrinsics.checkNotNullParameter(r2, NotificationCompat.CATEGORY_MESSAGE);
        loggerProxy.v(r1, r2, r3);
    }

    @Override // com.obric.matrix.platform.sdk.ones.account.api.ILogger
    public void d(String r1, String r2, Throwable r3) {
        Intrinsics.checkNotNullParameter(r1, SimContactsConstants.STR_TAG);
        Intrinsics.checkNotNullParameter(r2, NotificationCompat.CATEGORY_MESSAGE);
        loggerProxy.d(r1, r2, r3);
    }

    @Override // com.obric.matrix.platform.sdk.ones.account.api.ILogger
    public void i(String r1, String r2, Throwable r3) {
        Intrinsics.checkNotNullParameter(r1, SimContactsConstants.STR_TAG);
        Intrinsics.checkNotNullParameter(r2, NotificationCompat.CATEGORY_MESSAGE);
        loggerProxy.i(r1, r2, r3);
    }

    @Override // com.obric.matrix.platform.sdk.ones.account.api.ILogger
    public void w(String r1, String r2, Throwable r3) {
        Intrinsics.checkNotNullParameter(r1, SimContactsConstants.STR_TAG);
        Intrinsics.checkNotNullParameter(r2, NotificationCompat.CATEGORY_MESSAGE);
        loggerProxy.w(r1, r2, r3);
    }

    @Override // com.obric.matrix.platform.sdk.ones.account.api.ILogger
    public void e(String r1, String r2, Throwable r3) {
        Intrinsics.checkNotNullParameter(r1, SimContactsConstants.STR_TAG);
        Intrinsics.checkNotNullParameter(r2, NotificationCompat.CATEGORY_MESSAGE);
        loggerProxy.e(r1, r2, r3);
    }

    @JvmStatic
    public static final void v(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, SimContactsConstants.STR_TAG);
        Intrinsics.checkNotNullParameter(r3, NotificationCompat.CATEGORY_MESSAGE);
        INSTANCE.v(r2, r3, null);
    }

    @JvmStatic
    public static final void d(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, SimContactsConstants.STR_TAG);
        Intrinsics.checkNotNullParameter(r3, NotificationCompat.CATEGORY_MESSAGE);
        INSTANCE.d(r2, r3, null);
    }

    @JvmStatic
    public static final void i(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, SimContactsConstants.STR_TAG);
        Intrinsics.checkNotNullParameter(r3, NotificationCompat.CATEGORY_MESSAGE);
        INSTANCE.i(r2, r3, null);
    }

    @JvmStatic
    public static final void w(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, SimContactsConstants.STR_TAG);
        Intrinsics.checkNotNullParameter(r3, NotificationCompat.CATEGORY_MESSAGE);
        INSTANCE.w(r2, r3, null);
    }

    @JvmStatic
    public static final void e(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, SimContactsConstants.STR_TAG);
        Intrinsics.checkNotNullParameter(r3, NotificationCompat.CATEGORY_MESSAGE);
        INSTANCE.e(r2, r3, null);
    }
}
