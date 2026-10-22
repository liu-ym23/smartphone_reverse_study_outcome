package com.bytedance.applet.aibridge.datepicker;

import android.os.Handler;
import android.os.Looper;
import androidx.appcompat.app.AppCompatDialog;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import e3.d;
import f3.h;
import k3.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J&\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016¨\u0006\u000f"}, d2 = {"Lcom/bytedance/applet/aibridge/datepicker/CloseCustomPickerMethod;", "Lcom/bytedance/applet/aibridge/datepicker/AbsCloseCustomPickerMethodIDL;", "<init>", "()V", "mustRunInMain", "", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/datepicker/AbsCloseCustomPickerMethodIDL$CloseCustomPickerParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/datepicker/AbsCloseCustomPickerMethodIDL$CloseCustomPickerResultModel;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CloseCustomPickerMethod extends AbsCloseCustomPickerMethodIDL {
    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod, com.bytedance.ai.bridge.core.AIBridgeMethod
    public final boolean mustRunInMain() {
        return true;
    }

    public CloseCustomPickerMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r100, ParamModel r101, h r102) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter((AbsCloseCustomPickerMethodIDL.a) r101, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        a.c r103 = a.b();
        if (r103 == null) goto L23;
        AppCompatDialog r104 = r103.f191033s.get();
        if (r104 == null) goto L23;
        Handler r105 = DialogLancet.resolveDialogHandler(r104);
        if (r105 != null) goto L9;
    L11:
        DialogLancet.beforeDialogDismiss(r104);
        r104.dismiss();     // Catch: Throwable -> L14 Exception -> L16
    L20:
        DialogLancet.afterDialogDismiss(r104);
        goto L23
    L14:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r104);
        throw th;
    L16:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L14
        Throwable r106 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L14
        if (r106 == null) goto L20;
        com.bytedance.crash.d.d(r106, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L14
        goto L20
    L9:
        if (Looper.myLooper() == r105.getLooper()) goto L11;
        r105.post(DialogLancet.createDismissRunnable(r104));
    L23:
        Intrinsics.checkNotNullParameter(AbsCloseCustomPickerMethodIDL.b.class, "<this>");
        r102.b((ResultModel) c.a(AbsCloseCustomPickerMethodIDL.b.class), "");
    }
}
