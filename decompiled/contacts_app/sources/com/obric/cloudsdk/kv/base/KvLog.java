package com.obric.cloudsdk.kv.base;

import androidx.core.app.NotificationCompat;
import com.android.contacts.common.SimContactsConstants;
import com.obric.oui.calendar.format.DayFormatter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: KvLog.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bJ\"\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u0016\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bJ\u0010\u0010\u000e\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004J\u0016\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/cloudsdk/kv/base/KvLog;", "", "()V", "logger", "Lcom/obric/cloudsdk/kv/base/ILogger;", DayFormatter.DEFAULT_FORMAT, "", SimContactsConstants.STR_TAG, "", NotificationCompat.CATEGORY_MESSAGE, "e", "throwable", "", "i", "setLogger", "w", "cloudsdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class KvLog {
    public static final KvLog INSTANCE = null;
    private static ILogger logger;

    static {
        INSTANCE = new KvLog();
    }

    private KvLog() {
    }

    public final void setLogger(ILogger r1) {
        logger = r1;
    }

    public final void d(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, SimContactsConstants.STR_TAG);
        Intrinsics.checkNotNullParameter(r2, NotificationCompat.CATEGORY_MESSAGE);
        ILogger r0 = logger;
        if (r0 == null) goto L6;
        r0.d(r1, r2);
        return;
    }

    public final void i(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, SimContactsConstants.STR_TAG);
        Intrinsics.checkNotNullParameter(r2, NotificationCompat.CATEGORY_MESSAGE);
        ILogger r0 = logger;
        if (r0 == null) goto L6;
        r0.i(r1, r2);
        return;
    }

    public final void w(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, SimContactsConstants.STR_TAG);
        Intrinsics.checkNotNullParameter(r2, NotificationCompat.CATEGORY_MESSAGE);
        ILogger r0 = logger;
        if (r0 == null) goto L6;
        r0.w(r1, r2);
        return;
    }

    public static /* synthetic */ void e$default(KvLog r0, String r1, String r2, Throwable r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = null;
    L5:
        r0.e(r1, r2, r3);
    }

    public final void e(String r1, String r2, Throwable r3) {
        Intrinsics.checkNotNullParameter(r1, SimContactsConstants.STR_TAG);
        Intrinsics.checkNotNullParameter(r2, NotificationCompat.CATEGORY_MESSAGE);
        ILogger r0 = logger;
        if (r0 == null) goto L6;
        r0.e(r1, r2, r3);
        return;
    }
}
