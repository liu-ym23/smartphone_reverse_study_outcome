package com.obric.common.oea.foundation.util;

import androidx.core.app.NotificationCompat;
import com.android.contacts.common.SimContactsConstants;
import com.obric.oui.calendar.format.DayFormatter;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OEALogger.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J$\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\r"}, d2 = {"Lcom/obric/common/oea/foundation/util/OEALog;", "", DayFormatter.DEFAULT_FORMAT, "", SimContactsConstants.STR_TAG, "", NotificationCompat.CATEGORY_MESSAGE, "e", "throwable", "", "i", BaseSwitches.V, "w", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
public interface OEALog {

    /* JADX INFO: compiled from: OEALogger.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static void d(OEALog r0, String r1, String r2) {
            Intrinsics.checkNotNullParameter(r1, SimContactsConstants.STR_TAG);
            Intrinsics.checkNotNullParameter(r2, NotificationCompat.CATEGORY_MESSAGE);
        }

        public static void e(OEALog r0, String r1, String r2, Throwable r3) {
            Intrinsics.checkNotNullParameter(r1, SimContactsConstants.STR_TAG);
            Intrinsics.checkNotNullParameter(r2, NotificationCompat.CATEGORY_MESSAGE);
        }

        public static void i(OEALog r0, String r1, String r2) {
            Intrinsics.checkNotNullParameter(r1, SimContactsConstants.STR_TAG);
            Intrinsics.checkNotNullParameter(r2, NotificationCompat.CATEGORY_MESSAGE);
        }

        public static void v(OEALog r0, String r1, String r2) {
            Intrinsics.checkNotNullParameter(r1, SimContactsConstants.STR_TAG);
            Intrinsics.checkNotNullParameter(r2, NotificationCompat.CATEGORY_MESSAGE);
        }

        public static void w(OEALog r0, String r1, String r2) {
            Intrinsics.checkNotNullParameter(r1, SimContactsConstants.STR_TAG);
            Intrinsics.checkNotNullParameter(r2, NotificationCompat.CATEGORY_MESSAGE);
        }

        public static /* synthetic */ void e$default(OEALog r0, String r1, String r2, Throwable r3, int r4, Object r5) {
            if (r5 != null) goto L9;
            if ((r4 & 4) == 0) goto L6;
            r3 = null;
            Throwable r6 = (Throwable) null;
        L6:
            r0.e(r1, r2, r3);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: e");
        }
    }

    void d(String r1, String r2);

    void e(String r1, String r2, Throwable r3);

    void i(String r1, String r2);

    void v(String r1, String r2);

    void w(String r1, String r2);
}
