package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.WindowManager;
import androidx.appcompat.app.AlertDialog;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.annotations.SerializedName;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.Locale;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "showModal")
public final class AlertMethod extends com.bytedance.ies.web.jsbridge2.f<a, b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AlertDialog f63228a;

    public static final enum ActionType extends Enum<ActionType> {
        public static final ActionType CANCEL = null;
        public static final ActionType CONFIRM = null;
        public static final ActionType MASK = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ActionType[] f63229a = null;

        static {
            ActionType r100 = new ActionType("CONFIRM", 0);
            CONFIRM = r100;
            ActionType r101 = new ActionType("CANCEL", 1);
            CANCEL = r101;
            ActionType r102 = new ActionType("MASK", 2);
            MASK = r102;
            f63229a = new ActionType[]{r100, r101, r102};
        }

        public static ActionType[] values() {
            return (ActionType[]) f63229a.clone();
        }

        public static ActionType valueOf(String r100) {
            return (ActionType) r27.a.a(ActionType.class, r100);
        }

        public ActionType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {

        @SerializedName("cancelText")
        String cancelText;

        @SerializedName("confirmText")
        String confirmText;

        @SerializedName("content")
        String content;

        @SerializedName("showCancel")
        boolean showCancel;

        @SerializedName("tapMaskToDismiss")
        boolean tapMaskToDismiss;

        @SerializedName("title")
        String title;

        public a() {
            this.tapMaskToDismiss = true;
        }
    }

    public static final class b {

        @SerializedName("data")
        a data;

        @SerializedName("msg")
        String msg;

        public static final class a {

            @SerializedName("action")
            String action;

            @SerializedName("cancel")
            boolean cancel;

            @SerializedName("confirm")
            boolean confirm;

            public a(boolean r100, ActionType r101) {
                this.confirm = r100;
                this.cancel = !r100;
                this.action = r101.name().toLowerCase(Locale.getDefault());
            }
        }

        public b(boolean r100, ActionType r101) {
            this.data = new a(r100, r101);
            this.msg = "SUCCESS";
        }
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
        AlertDialog r100 = this.f63228a;
        if (r100 == null) goto L21;
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L7;
    L9:
        DialogLancet.beforeDialogDismiss(r100);
        r100.dismiss();     // Catch: Throwable -> L12 Exception -> L14
    L18:
        DialogLancet.afterDialogDismiss(r100);
        goto L21
    L12:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L14:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
        if (r102 == null) goto L18;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
        goto L18
    L7:
        if (Looper.myLooper() == r101.getLooper()) goto L9;
        r101.post(DialogLancet.createDismissRunnable(r100));
    L21:
        this.f63228a = null;
    }

    public AlertMethod() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(a r100, CallContext r101) throws Exception {
        a r102 = r100;
        AlertDialog.Builder r103 = new AlertDialog.Builder(r101.getContext());
        r103.setMessage(r102.content);
        if (TextUtils.isEmpty(r102.title) == true) goto L6;
        r103.setTitle(r102.title);
    L6:
        if (TextUtils.isEmpty(r102.confirmText) == false) goto L8;
        String r104 = com.bytedance.android.live.core.utils.s1.B(R.string.ttlive_ok);
    L9:
        r103.setPositiveButton(r104, new n0(this));
        if (r102.showCancel == true) goto L12;
    L16:
        AlertDialog r105 = r103.create();
        this.f63228a = r105;
        r105.setCanceledOnTouchOutside(r102.tapMaskToDismiss);
        this.f63228a.setOnCancelListener(new p0(this));
        AlertDialog r106 = this.f63228a;
        if (DialogLancet.shouldBlockDialogShow(r106) == false) goto L32;
        DialogLancet.handleBlockedDialogShow(r106);
    L34:
        AlertDialog r107 = this.f63228a;     // Catch: Exception -> L29
        if (r107 != null) goto L24;
        return;
    L24:
        if (r107.getWindow() == null) goto L37;
        WindowManager.LayoutParams r108 = this.f63228a.getWindow().getAttributes();     // Catch: Exception -> L29
        if (r108 == null) goto L38;
        r108.width = (com.bytedance.android.live.core.utils.s1.y() / 10) * 9;     // Catch: Exception -> L29
        r108.gravity = 17;     // Catch: Exception -> L29
        this.f63228a.getWindow().setAttributes(r108);     // Catch: Exception -> L29
        return;
    L38:
        return;
    L37:
        return;
    L29:
        ALogger.e("alert_jsb_method_error", "alert jsb method resize dialog error");
        return;
    L32:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L31
    L20:
        DialogLancet.beforeDialogShow(r106);
        r106.show();
        DialogLancet.afterDialogShow(r106);
        goto L34
    L12:
        if (TextUtils.isEmpty(r102.cancelText) == false) goto L14;
        String r109 = com.bytedance.android.live.core.utils.s1.B(R.string.ttlive_cancel);
    L15:
        r103.setNegativeButton(r109, new o0(this));
        goto L16
    L14:
        r109 = r102.cancelText;
        goto L15
    L8:
        r104 = r102.confirmText;
        goto L9
    }
}
