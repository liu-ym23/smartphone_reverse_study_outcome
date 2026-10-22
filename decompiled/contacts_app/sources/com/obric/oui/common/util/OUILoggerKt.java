package com.obric.oui.common.util;

import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OUILogger.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u001a\u000e\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u0005"}, d2 = {"debugLog", "", NotificationCompat.CATEGORY_MESSAGE, "", "raiseIllegalArgumentException", "OUI_standardRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class OUILoggerKt {
    public static final void debugLog(String r2) {
        OUILogger r0 = OUILogger.INSTANCE;
        if (r2 != null) goto L5;
        r2 = "null";
    L5:
        r0.d("debugging", r2);
    }

    public static final void raiseIllegalArgumentException(String r7) {
        Intrinsics.checkNotNullParameter(r7, NotificationCompat.CATEGORY_MESSAGE);
        OUILogger.e$default(OUILogger.INSTANCE, "debugging", r7, null, 4, null);
        throw new IllegalArgumentException(r7);
    }
}
