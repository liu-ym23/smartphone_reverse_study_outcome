package com.obric.aivoice.core.log;

import androidx.core.app.NotificationCompat;
import com.GlobalProxyLancet;
import com.android.contacts.common.SimContactsConstants;
import com.obric.oui.calendar.format.DayFormatter;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AIVoiceLog.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0016J\u0018\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0016J \u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0016J\b\u0010\u0010\u001a\u00020\u0004H\u0016J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0002J\u000e\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0001J\u0018\u0010\u0014\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0016J\u0018\u0010\u0015\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0016J \u0010\u0015\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/obric/aivoice/core/log/AIVoiceLog;", "Lcom/obric/aivoice/core/log/ILog;", "()V", "NEED_PREFIX", "", "TAG_PREFIX", "", "logInst", DayFormatter.DEFAULT_FORMAT, "", SimContactsConstants.STR_TAG, NotificationCompat.CATEGORY_MESSAGE, "e", "t", "", "i", "isDebug", "logTag", "registerLog", "inst", BaseSwitches.V, "w", "voicesdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AIVoiceLog implements ILog {
    public static final AIVoiceLog INSTANCE = null;
    private static final boolean NEED_PREFIX = true;
    private static final String TAG_PREFIX = "[AIVoiceClient] ";
    private static ILog logInst;

    static {
        INSTANCE = new AIVoiceLog();
    }

    @Override // com.obric.aivoice.core.log.ILog
    public boolean isDebug() {
        return true;
    }

    private AIVoiceLog() {
    }

    public final void registerLog(ILog r1) {
        Intrinsics.checkNotNullParameter(r1, "inst");
        logInst = r1;
    }

    @Override // com.obric.aivoice.core.log.ILog
    public void d(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, SimContactsConstants.STR_TAG);
        Intrinsics.checkNotNullParameter(r3, NotificationCompat.CATEGORY_MESSAGE);
        ILog r0 = logInst;
        String r1 = logTag(r2);
        if (r0 == null) goto L5;
        r0.d(r1, r3);
        return;
    L5:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(r1, r3);
    }

    @Override // com.obric.aivoice.core.log.ILog
    public void v(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, SimContactsConstants.STR_TAG);
        Intrinsics.checkNotNullParameter(r3, NotificationCompat.CATEGORY_MESSAGE);
        ILog r0 = logInst;
        String r1 = logTag(r2);
        if (r0 == null) goto L5;
        r0.v(r1, r3);
        return;
    L5:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_v(r1, r3);
    }

    @Override // com.obric.aivoice.core.log.ILog
    public void i(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, SimContactsConstants.STR_TAG);
        Intrinsics.checkNotNullParameter(r3, NotificationCompat.CATEGORY_MESSAGE);
        ILog r0 = logInst;
        String r1 = logTag(r2);
        if (r0 == null) goto L5;
        r0.i(r1, r3);
        return;
    L5:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(r1, r3);
    }

    @Override // com.obric.aivoice.core.log.ILog
    public void w(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, SimContactsConstants.STR_TAG);
        Intrinsics.checkNotNullParameter(r3, NotificationCompat.CATEGORY_MESSAGE);
        ILog r0 = logInst;
        String r1 = logTag(r2);
        if (r0 == null) goto L5;
        r0.w(r1, r3);
        return;
    L5:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(r1, r3);
    }

    @Override // com.obric.aivoice.core.log.ILog
    public void w(String r2, String r3, Throwable r4) {
        Intrinsics.checkNotNullParameter(r2, SimContactsConstants.STR_TAG);
        Intrinsics.checkNotNullParameter(r3, NotificationCompat.CATEGORY_MESSAGE);
        Intrinsics.checkNotNullParameter(r4, "t");
        ILog r0 = logInst;
        String r1 = logTag(r2);
        if (r0 == null) goto L5;
        r0.w(r1, r3, r4);
        return;
    L5:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(r1, r3, r4);
    }

    @Override // com.obric.aivoice.core.log.ILog
    public void e(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, SimContactsConstants.STR_TAG);
        Intrinsics.checkNotNullParameter(r3, NotificationCompat.CATEGORY_MESSAGE);
        ILog r0 = logInst;
        String r1 = logTag(r2);
        if (r0 == null) goto L5;
        r0.e(r1, r3);
        return;
    L5:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(r1, r3);
    }

    @Override // com.obric.aivoice.core.log.ILog
    public void e(String r2, String r3, Throwable r4) {
        Intrinsics.checkNotNullParameter(r2, SimContactsConstants.STR_TAG);
        Intrinsics.checkNotNullParameter(r3, NotificationCompat.CATEGORY_MESSAGE);
        Intrinsics.checkNotNullParameter(r4, "t");
        ILog r0 = logInst;
        String r1 = logTag(r2);
        if (r0 == null) goto L5;
        r0.e(r1, r3, r4);
        return;
    L5:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(r1, r3, r4);
    }

    private final String logTag(String r2) {
        return TAG_PREFIX + r2;
    }
}
