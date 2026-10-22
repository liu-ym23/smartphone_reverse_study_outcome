package com.obric.common.oea.foundation.util;

import androidx.core.app.NotificationCompat;
import com.GlobalProxyLancet;
import com.android.contacts.common.SimContactsConstants;
import com.obric.oui.calendar.format.DayFormatter;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OEALogger.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\"\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\r"}, d2 = {"com/obric/common/oea/foundation/util/OEALogger$defaultLogger$1", "Lcom/obric/common/oea/foundation/util/OEALog;", DayFormatter.DEFAULT_FORMAT, "", SimContactsConstants.STR_TAG, "", NotificationCompat.CATEGORY_MESSAGE, "e", "throwable", "", "i", BaseSwitches.V, "w", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class OEALogger$defaultLogger$1 implements OEALog {
    OEALogger$defaultLogger$1() {
    }

    @Override // com.obric.common.oea.foundation.util.OEALog
    public void v(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, SimContactsConstants.STR_TAG);
        Intrinsics.checkNotNullParameter(r2, NotificationCompat.CATEGORY_MESSAGE);
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_v("OEA_SDK", r1 + "->" + r2);
    }

    @Override // com.obric.common.oea.foundation.util.OEALog
    public void d(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, SimContactsConstants.STR_TAG);
        Intrinsics.checkNotNullParameter(r2, NotificationCompat.CATEGORY_MESSAGE);
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d("OEA_SDK", r1 + "->" + r2);
    }

    @Override // com.obric.common.oea.foundation.util.OEALog
    public void i(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, SimContactsConstants.STR_TAG);
        Intrinsics.checkNotNullParameter(r2, NotificationCompat.CATEGORY_MESSAGE);
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i("OEA_SDK", r1 + "->" + r2);
    }

    @Override // com.obric.common.oea.foundation.util.OEALog
    public void w(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, SimContactsConstants.STR_TAG);
        Intrinsics.checkNotNullParameter(r2, NotificationCompat.CATEGORY_MESSAGE);
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w("OEA_SDK", r1 + "->" + r2);
    }

    @Override // com.obric.common.oea.foundation.util.OEALog
    public void e(String r1, String r2, Throwable r3) {
        Intrinsics.checkNotNullParameter(r1, SimContactsConstants.STR_TAG);
        Intrinsics.checkNotNullParameter(r2, NotificationCompat.CATEGORY_MESSAGE);
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e("OEA_SDK", r1 + "->" + r2, r3);
    }
}
