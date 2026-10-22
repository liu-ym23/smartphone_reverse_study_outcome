package com.android.ttcjpaysdk.base.ui.Utils;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.android.ttcjpaysdk.base.ui.dialog.CJPayLoadingDialog;
import com.android.ttcjpaysdk.base.ui.widget.CJPayTextLoadingView;
import com.bytedance.crash.d;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: classes28.dex */
public class CJPayLoadingUtils {
    private static final String LOADING_VIEW_TAG_IN_ACTIVITY = "loading_view_in_activity";
    private static CJPayLoadingDialog cjPayLoadingDialog;
    private static int index;

    public CJPayLoadingUtils() {
    }

    public static synchronized void dismissFullPageHostDialogLoading() {
        monitor-enter(CJPayLoadingUtils.class);
        int r100 = index - 1;     // Catch: Throwable -> L18
        index = r100;     // Catch: Throwable -> L18
        if (r100 <= 0) goto L8;
        monitor-exit(CJPayLoadingUtils.class);
        return;
    L8:
        CJPayLoadingDialog r101 = cjPayLoadingDialog;     // Catch: Throwable -> L18
        if (r101 == null) goto L15;
        Activity r102 = r101.getOwnerActivity();     // Catch: Throwable -> L18
        if (r102 == null) goto L15;
        if (r102.isFinishing() == true) goto L15;
        INVOKEVIRTUAL_com_android_ttcjpaysdk_base_ui_Utils_CJPayLoadingUtils_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(cjPayLoadingDialog);     // Catch: Throwable -> L18
    L15:
        cjPayLoadingDialog = null;     // Catch: Throwable -> L18
        index = 0;     // Catch: Throwable -> L18
        monitor-exit(CJPayLoadingUtils.class);
        return;
    L18:
        th = move-exception;
        throw th;
    }

    public static void INVOKEVIRTUAL_com_android_ttcjpaysdk_base_ui_Utils_CJPayLoadingUtils_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(CJPayLoadingDialog r100) {
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r100);
        r100.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r100);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L13:
        e = move-exception;
        d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r102 == null) goto L10;
        d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L8;
        r101.post(DialogLancet.createDismissRunnable(r100));
    }

    public static void INVOKEVIRTUAL_com_android_ttcjpaysdk_base_ui_Utils_CJPayLoadingUtils_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(CJPayLoadingDialog r100) {
        if (DialogLancet.shouldBlockDialogShow(r100) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(r100);
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L7:
        DialogLancet.beforeDialogShow(r100);
        r100.show();
        DialogLancet.afterDialogShow(r100);
    }

    public static void showFullPageHostDialogLoading(Context r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if ((r100 instanceof Activity) == false) goto L15;
        Activity r101 = (Activity) r100;
        if (r101.isFinishing() == false) goto L9;
        return;
    L9:
        if (cjPayLoadingDialog != null) goto L12;
        cjPayLoadingDialog = new CJPayLoadingDialog(r101);
    L12:
        if (cjPayLoadingDialog.isShowing() == true) goto L17;
        INVOKEVIRTUAL_com_android_ttcjpaysdk_base_ui_Utils_CJPayLoadingUtils_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(cjPayLoadingDialog);
        cjPayLoadingDialog.setOwnerActivity(r101);
        return;
    L17:
        return;
    }

    public static void showFullPageHostLoading(Activity r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        FrameLayout r101 = (FrameLayout) r100.findViewById(R.id.content);
        int r102 = r101.getChildCount();
        if (r102 > 1) goto L7;
    L9:
        RelativeLayout r103 = (RelativeLayout) LayoutInflater.from(r100).inflate(com.larus.nova.R.layout.cj_pay_loading_dialog, r101, false);
        r103.getLayoutParams().height = -1;
        r103.getLayoutParams().width = -1;
        r103.setTag(LOADING_VIEW_TAG_IN_ACTIVITY);
        ((CJPayTextLoadingView) r103.findViewById(com.larus.nova.R.id.cj_pay_loading_view)).show();
        r101.addView(r103);
        r101.invalidate();
        return;
    L7:
        if (LOADING_VIEW_TAG_IN_ACTIVITY.equals(r101.getChildAt(r102 - 1).getTag()) == false) goto L9;
    }
}
