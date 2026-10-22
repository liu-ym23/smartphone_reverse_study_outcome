package com.android.ttcjpaysdk.base.ui.dialog;

import android.content.Context;
import com.android.ttcjpaysdk.base.ui.widget.CJPayTextLoadingView;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: classes28.dex */
public class CJPayLoadingDialog extends CJPayFadeAnimationDialog {
    CJPayTextLoadingView cjPayTextLoadingView;

    public static /* synthetic */ void access$000(CJPayFadeAnimationDialog r100) {
        super.show();
    }

    @Override // android.app.Dialog
    public void hide() {
        super.hide();
        this.cjPayTextLoadingView.hide();
    }

    @Override // com.android.ttcjpaysdk.base.ui.dialog.CJPayFadeAnimationDialog, android.app.Dialog
    public void show() {
        INVOKESPECIAL_com_android_ttcjpaysdk_base_ui_dialog_CJPayLoadingDialog_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(this);
        this.cjPayTextLoadingView.show();
    }

    public CJPayLoadingDialog(Context r100) {
        super(r100, R.style.CJ_Pay_Dialog_With_Layer, false);
        initView(r100);
    }

    public static void INVOKESPECIAL_com_android_ttcjpaysdk_base_ui_dialog_CJPayLoadingDialog_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(CJPayFadeAnimationDialog r100) {
        if (DialogLancet.shouldBlockDialogShow(r100) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(r100);
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L7:
        DialogLancet.beforeDialogShow(r100);
        access$000(r100);
        DialogLancet.afterDialogShow(r100);
    }

    private void initView(Context r100) {
        setContentView(R.layout.cj_pay_loading_dialog);
        this.cjPayTextLoadingView = (CJPayTextLoadingView) findViewById(R.id.cj_pay_loading_view);
        getWindow().setDimAmount(0.0f);
        setCanceledOnTouchOutside(false);
        setCancelable(false);
    }
}
