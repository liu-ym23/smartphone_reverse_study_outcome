package com.bytedance.applet.aibridge.navi;

import android.app.AlertDialog;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.crash.d;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import f3.h;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rv3.f0;
import rv3.y;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J&\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002JJ\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0010H\u0002J\u0012\u0010\u0013\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0010H\u0002J\b\u0010\u0015\u001a\u00020\u0010H\u0002J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u0010H\u0002¨\u0006\u0019"}, d2 = {"Lcom/bytedance/applet/aibridge/navi/StartThirdNaviOrPlanMethod;", "Lcom/bytedance/applet/aibridge/navi/AbsStartThirdNaviOrPlanMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/navi/AbsStartThirdNaviOrPlanMethodIDL$StartThirdNaviOrPlanMethodParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/navi/AbsStartThirdNaviOrPlanMethodIDL$StartThirdNaviOrPlanMethodResultModel;", "handleDialog", "startThirdNaviOrPlan", "availableApps", "", "targetAppName", "selectedApp", "goToAppMarket", "appName", "getDefaultAvailableApps", "isInstalled", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StartThirdNaviOrPlanMethod extends AbsStartThirdNaviOrPlanMethodIDL {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f191246b = 0;

    public static final class a {
    }

    static {
    }

    public StartThirdNaviOrPlanMethod() {
    }

    public static void b(AlertDialog r100) {
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
        d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r102 == null) goto L17;
        d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L8;
        r101.post(DialogLancet.createDismissRunnable(r100));
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(final e3.d r100, ParamModel r101, final h r110) {
        final AbsStartThirdNaviOrPlanMethodIDL.a r102 = (AbsStartThirdNaviOrPlanMethodIDL.a) r101;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r110, "callback");
        if (Intrinsics.areEqual(r102.getShowDialog(), Boolean.TRUE) == false) goto L5;
        new Handler(Looper.getMainLooper()).post(new y(this, r100, r102, r110));
        return;
    L5:
        String r103 = null;
        new Handler(Looper.getMainLooper()).post(new f0(r103, r102, r110, null, this, null));
    }
}
