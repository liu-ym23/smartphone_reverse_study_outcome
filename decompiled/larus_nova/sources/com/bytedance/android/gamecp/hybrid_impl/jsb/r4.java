package com.bytedance.android.gamecp.hybrid_impl.jsb;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@XBridgeMethod(biz = "webcast", name = "gamecpLoadingDialog")
public final class r4 extends w<JsonObject, GamecpLoadingDialogResultModel> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.android.gamecp.common.ui.k f57534a;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
        com.bytedance.android.gamecp.common.ui.k r100 = this.f57534a;
        if (r100 == null) goto L5;
        j(r100);
    L5:
        this.f57534a = null;
    }

    public r4() {
    }

    public static void j(com.bytedance.android.gamecp.common.ui.k r100) {
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r100);
        r100.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L17:
        DialogLancet.afterDialogDismiss(r100);
        return;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r102 == null) goto L17;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L8;
        r101.post(DialogLancet.createDismissRunnable(r100));
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        JsonObject r102 = (JsonObject) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        n1.a("gamecpLoadingDialog", GsonProtectorUtils.toJson(new Gson(), r102));
        JsonElement r103 = r102.get("type");
        if (r103 == null) goto L5;
        String r104 = r103.getAsString();
    L7:
        if (r104 == null) goto L29;
        int r105 = r104.hashCode();
        if (r105 == 3529469) goto L20;
        if (r105 != 1671672458) goto L29;
        if (r104.equals("dismiss") == false) goto L29;
        com.bytedance.android.gamecp.common.ui.k r106 = this.f57534a;
        if (r106 == null) goto L34;
        j(r106);
        return;
    L34:
        return;
    L20:
        if (r104.equals("show") == false) goto L29;
        Activity r107 = com.bytedance.android.gamecp.common.utils.g.a(r101.getContext());
        if (r107 == null) goto L28;
        com.bytedance.android.gamecp.common.ui.k r108 = new com.bytedance.android.gamecp.common.ui.k(r107);
        this.f57534a = r108;
        if (DialogLancet.shouldBlockDialogShow(r108) == false) goto L32;
        DialogLancet.handleBlockedDialogShow(r108);
        return;
    L32:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L31
    L27:
        DialogLancet.beforeDialogShow(r108);
        r108.show();
        DialogLancet.afterDialogShow(r108);
        return;
    L28:
        yr.c.g("LoadingDialogMethod", "dialog attach activity is empty");
        return;
    L29:
        yr.c.g("LoadingDialogMethod", "unknown type: " + r104);
        return;
    L5:
        r104 = null;
        goto L7
    }
}
