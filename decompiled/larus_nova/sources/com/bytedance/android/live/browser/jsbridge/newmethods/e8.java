package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.app.Activity;
import android.app.AlertDialog;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "handleNotificationSettings")
public final class e8 extends com.bytedance.ies.web.jsbridge2.f<Object, Object> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public e8() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Activity r102 = ContextUtil.contextToActivity(r101.getContext());
        if (r102 != null) goto L5;
        finishWithFailure();
    L5:
        if (r102 == null) goto L27;
        int r103 = c30.c.f22265a;
        if (c30.c.b(r102) == false) goto L9;
        finishWithSuccess();
        return;
    L9:
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        c30.b r104 = new c30.b(r102);     // Catch: Exception -> L17
        c30.a r105 = c30.a.f22263a;     // Catch: Exception -> L17
        AlertDialog r106 = new AlertDialog.Builder(r102).setTitle(R.string.ttlive_settings_push_notifications_popup).setMessage(R.string.ttlive_settings_push_notifications_popup_tips).setPositiveButton(R.string.ttlive_settings_push_notifications_popup_confirm, r104).setNegativeButton(R.string.ttlive_settings_push_notifications_popup_cancel, r105).create();     // Catch: Exception -> L17
        if (DialogLancet.shouldBlockDialogShow(r106) == false) goto L25;
        DialogLancet.handleBlockedDialogShow(r106);     // Catch: Exception -> L17
    L22:
    L19:
        finishWithFailure();
        return;
    L25:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L21
    L15:
        DialogLancet.beforeDialogShow(r106);     // Catch: Exception -> L17
        r106.show();     // Catch: Exception -> L17
        DialogLancet.afterDialogShow(r106);     // Catch: Exception -> L17
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    }
}
