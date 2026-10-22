package com.obric.audiocodecsdk.log;

import androidx.core.app.NotificationCompat;
import com.android.contacts.common.SimContactsConstants;
import com.obric.oui.calendar.format.DayFormatter;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: XLog.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004J \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u0016\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004J \u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u0016\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004J \u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u0016\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004J \u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u0016\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004J \u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/audiocodecsdk/log/XLog;", "", "()V", "prefix", "", DayFormatter.DEFAULT_FORMAT, "", SimContactsConstants.STR_TAG, NotificationCompat.CATEGORY_MESSAGE, "tr", "", "e", "i", BaseSwitches.V, "w", "sdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class XLog {
    public static final XLog INSTANCE = null;
    public static final String prefix = "audiocodecsdk_";

    static {
        INSTANCE = new XLog();
    }

    private XLog() {
    }

    public final void i(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, SimContactsConstants.STR_TAG);
        Intrinsics.checkNotNullParameter(r4, NotificationCompat.CATEGORY_MESSAGE);
        Logger.INSTANCE.i(prefix + r3, r4);
    }

    public final void i(String r3, String r4, Throwable r5) {
        Intrinsics.checkNotNullParameter(r3, SimContactsConstants.STR_TAG);
        Intrinsics.checkNotNullParameter(r4, NotificationCompat.CATEGORY_MESSAGE);
        Logger.INSTANCE.i(prefix + r3, r4, r5);
    }

    public final void v(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, SimContactsConstants.STR_TAG);
        Intrinsics.checkNotNullParameter(r4, NotificationCompat.CATEGORY_MESSAGE);
        Logger.INSTANCE.v(prefix + r3, r4);
    }

    public final void v(String r3, String r4, Throwable r5) {
        Intrinsics.checkNotNullParameter(r3, SimContactsConstants.STR_TAG);
        Intrinsics.checkNotNullParameter(r4, NotificationCompat.CATEGORY_MESSAGE);
        Logger.INSTANCE.v(prefix + r3, r4, r5);
    }

    public final void d(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, SimContactsConstants.STR_TAG);
        Intrinsics.checkNotNullParameter(r4, NotificationCompat.CATEGORY_MESSAGE);
        Logger.INSTANCE.d(prefix + r3, r4);
    }

    public final void d(String r3, String r4, Throwable r5) {
        Intrinsics.checkNotNullParameter(r3, SimContactsConstants.STR_TAG);
        Intrinsics.checkNotNullParameter(r4, NotificationCompat.CATEGORY_MESSAGE);
        Logger.INSTANCE.d(prefix + r3, r4, r5);
    }

    public final void w(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, SimContactsConstants.STR_TAG);
        Intrinsics.checkNotNullParameter(r4, NotificationCompat.CATEGORY_MESSAGE);
        Logger.INSTANCE.w(prefix + r3, r4);
    }

    public final void w(String r3, String r4, Throwable r5) {
        Intrinsics.checkNotNullParameter(r3, SimContactsConstants.STR_TAG);
        Intrinsics.checkNotNullParameter(r4, NotificationCompat.CATEGORY_MESSAGE);
        Logger.INSTANCE.w(prefix + r3, r4, r5);
    }

    public final void e(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, SimContactsConstants.STR_TAG);
        Intrinsics.checkNotNullParameter(r4, NotificationCompat.CATEGORY_MESSAGE);
        Logger.INSTANCE.e(prefix + r3, r4);
    }

    public final void e(String r3, String r4, Throwable r5) {
        Intrinsics.checkNotNullParameter(r3, SimContactsConstants.STR_TAG);
        Intrinsics.checkNotNullParameter(r4, NotificationCompat.CATEGORY_MESSAGE);
        Logger.INSTANCE.e(prefix + r3, r4, r5);
    }
}
