package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.Window;
import com.bytedance.android.live.browser.jsbridge.base.ShowLoadingResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.sva.sdk.data.ISmModel;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import w20.we;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = DyPayConstant.KEY_SHOW_LOADING)
public final class zc extends w20.o6<we, ShowLoadingResultModel> {
    public zc() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        we r102 = (we) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        com.bytedance.android.livesdk.widget.e1 r103 = l30.f.f507221a;
        Context r104 = r101.getContext();
        String r105 = r102.a();
        if (r105 != null) goto L5;
        r105 = "";
    L5:
        Intrinsics.checkNotNullParameter(r104, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r105, "text");
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L36
        com.bytedance.android.livesdk.widget.e1 r107 = l30.f.f507221a;     // Catch: Throwable -> L36
        if (r107 == null) goto L9;
        l30.f.a(r107);     // Catch: Throwable -> L36
    L9:
        com.bytedance.android.livesdk.widget.e1 r108 = new com.bytedance.android.livesdk.widget.e1((Activity) r104);     // Catch: Throwable -> L36
        r108.f161694c = r105;     // Catch: Throwable -> L36
        l30.f.f507221a = r108;     // Catch: Throwable -> L36
        r108.setCancelable(false);     // Catch: Throwable -> L36
        com.bytedance.android.livesdk.widget.e1 r109 = l30.f.f507221a;     // Catch: Throwable -> L36
        if (r109 == null) goto L19;
        Window r110 = r109.getWindow();     // Catch: Throwable -> L36
        if (r110 == null) goto L19;
        View r111 = r110.getDecorView();     // Catch: Throwable -> L36
        if (com.larus.home.impl.utils.c.f346345e == false) goto L18;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");     // Catch: Throwable -> L36
        Thread r112 = ThreadMethodProxy.currentThread();     // Catch: Throwable -> L36
        if (r112 == com.larus.home.impl.utils.c.f346341a) goto L18;
        com.larus.home.impl.utils.c.a(r112, "getDecorView");     // Catch: Throwable -> L36
    L18:
        com.bytedance.android.live.core.utils.statusbar.a.C1098a r113 = com.bytedance.android.live.core.utils.statusbar.a.f66401b;     // Catch: Throwable -> L36
        r113.a();     // Catch: Throwable -> L36
        r113.a();     // Catch: Throwable -> L36
        r111.setSystemUiVisibility(ISmModel.VERSION_0700);     // Catch: Throwable -> L36
        r113.a();     // Catch: Throwable -> L36
        r110.addFlags(Integer.MIN_VALUE);     // Catch: Throwable -> L36
        r110.setStatusBarColor(0);     // Catch: Throwable -> L36
        r110.setNavigationBarColor(0);     // Catch: Throwable -> L36
    L19:
        com.bytedance.android.livesdk.widget.e1 r114 = l30.f.f507221a;     // Catch: Throwable -> L36
        if (r114 == null) goto L24;
        Window r115 = r114.getWindow();     // Catch: Throwable -> L36
        if (r115 == null) goto L24;
        r115.setDimAmount(0.0f);     // Catch: Throwable -> L36
    L24:
        com.bytedance.android.livesdk.widget.e1 r116 = l30.f.f507221a;     // Catch: Throwable -> L36
        if (r116 != null) goto L27;
        Unit r117 = null;
    L34:
        Result.m9449constructorimpl(r117);     // Catch: Throwable -> L36
    L38:
        ShowLoadingResultModel r118 = new ShowLoadingResultModel();
        r118.a(ShowLoadingResultModel.Code.Success);
        r118.b("SUCCESS");
        Unit r119 = Unit.INSTANCE;
        finishWithResult(r118);
        return;
    L27:
        if (DialogLancet.shouldBlockDialogShow(r116) == false) goto L41;
        DialogLancet.handleBlockedDialogShow(r116);     // Catch: Throwable -> L36
    L32:
        r117 = Unit.INSTANCE;     // Catch: Throwable -> L36
        goto L34
    L41:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L40 Throwable -> L36
    L31:
        DialogLancet.beforeDialogShow(r116);     // Catch: Throwable -> L36
        r116.show();     // Catch: Throwable -> L36
        DialogLancet.afterDialogShow(r116);     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        Result.Companion r120 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L38
    }
}
