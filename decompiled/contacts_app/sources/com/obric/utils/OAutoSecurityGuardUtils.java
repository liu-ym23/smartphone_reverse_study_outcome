package com.obric.utils;

import android.content.Context;
import android.os.Bundle;
import android.security.bytedance.guard.BDSecurityGuardStub;
import com.GlobalProxyLancet;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;

/* JADX INFO: compiled from: OAutoSecurityGuardUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/utils/OAutoSecurityGuardUtils;", "", "()V", "TAG", "", "sendSecurityGuardEvent", "", "context", "Landroid/content/Context;", "type", "", "isStart", "", "isConFirm", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class OAutoSecurityGuardUtils {
    public static final OAutoSecurityGuardUtils INSTANCE = null;
    private static final String TAG = "OAutoSecurityGuardUtils";

    static {
        INSTANCE = new OAutoSecurityGuardUtils();
    }

    private OAutoSecurityGuardUtils() {
    }

    @JvmStatic
    public static final void sendSecurityGuardEvent(Context r3, int r4, boolean r5, boolean r6) {
        if (r3 != null) goto L22;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "sendSecurityGuardEvent context is null");
        return;
    L22:
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L16
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "sendSecurityGuardEvent type:" + r4 + " isStart:" + r5 + " isConFirm:" + r6);     // Catch: Throwable -> L16
        if (r5 == false) goto L9;
        BDSecurityGuardStub.getInstance().bdSettingsEventStart(r3, r4, new Bundle());     // Catch: Throwable -> L16
    L14:
        Object r7 = Result.m803constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L16
    L18:
        Throwable r8 = Result.m806exceptionOrNullimpl(r7);
        if (r8 == null) goto L24;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "sendSecurityGuardEvent error", r8);
        return;
    L24:
        return;
    L9:
        BDSecurityGuardStub r9 = BDSecurityGuardStub.getInstance();     // Catch: Throwable -> L16
        Bundle r0 = new Bundle();     // Catch: Throwable -> L16
        if (r6 == false) goto L12;
        String r10 = "confirm";
    L13:
        r0.putString("event_result", r10);     // Catch: Throwable -> L16
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L16
        r9.bdSettingsEventEnd(r3, r4, r0);     // Catch: Throwable -> L16
        goto L14
    L12:
        r10 = "cancel";
    L16:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r7 = Result.m803constructorimpl(ResultKt.createFailure(th));
        goto L18
    }
}
