package com.bytedanceos.common.ui;

import android.R;
import android.annotation.TargetApi;
import android.app.Dialog;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.R$id;
import com.bytedanceos.common.R$layout;
import com.bytedanceos.common.R$string;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.toolbox.SizeConverter;
import com.bytedanceos.common.toolbox.e0;
import com.obric.oui.button.OButton;
import com.obric.oui.dialog.v2.action.OActionDialog;
import com.obric.oui.dialog.v2.alert.OAlertDialog;
import com.obric.oui.dialog.v2.alert.OAlertDialogBuilder;
import com.obric.oui.dialog.v2.alert.style.DialogContainer;
import kotlin.Unit;

/* JADX INFO: loaded from: classes2.dex */
@TargetApi(11)
public class ConfirmDialog extends CommonConfirmDialog {
    public ConfirmDialog() {
    }

    public static /* synthetic */ Unit a(ConfirmDialog r10, DialogContainer r11) {
        return r10.lambda$initAccessNetWorkTips$1(r11);
    }

    public static /* synthetic */ void access$000(ConfirmDialog r10, int r11) {
        r10.dealDialogClickEvent(r11);
    }

    public static /* synthetic */ View b(View r10, ViewGroup r11) {
        return lambda$initSwitchUpdateDialog$4(r10, r11);
    }

    public static /* synthetic */ View c(View r10, ViewGroup r11) {
        return lambda$initMobileReminderDialog$3(r10, r11);
    }

    public static /* synthetic */ View d(View r10, ViewGroup r11) {
        return lambda$initForceInstallConfirmDialog$0(r10, r11);
    }

    private void dealDialogClickEvent(int r10) {
        if (this.mOnClickListener == null) goto L15;
        CheckBox r11 = this.mCheckView;
        if (r11 != null) goto L7;
    L9:
        boolean r12 = false;
    L10:
        OActionDialog r13 = this.dialog;
        if (r13 == null) goto L13;
        r13.dismiss();
    L13:
        this.mOnClickListener.onButtonClick(this.mNum, r10, r12, getArguments());
        return;
    L7:
        if (r11.isChecked() == false) goto L9;
        r12 = true;
        goto L10
    }

    public static /* synthetic */ boolean e(ConfirmDialog r10, DialogInterface r11, int r12, KeyEvent r13) {
        return r10.lambda$initAccessNetWorkTips$2(r11, r12, r13);
    }

    private Dialog initAccessNetWorkTips(OAlertDialogBuilder r10) {
        r10.N(R$string.dialog_access_network_title);
        r10.p(new bd.e(new e(this)));
        r10.x(R$string.dialog_access_network_no, this);
        r10.F(R$string.dialog_access_network_yes, this);
        OAlertDialog r11 = r10.q();
        r11.setCanceledOnTouchOutside(false);
        r11.setCancelable(false);
        r11.setOnKeyListener(new f(this));
        return r11;
    }

    private Dialog initDataTransferSuccessDialog(OAlertDialogBuilder r10) {
        r10.N(R$string.backup_data_transfer_title);
        r10.v(R$string.backup_data_transfer_msg);
        r10.x(R$string.backup_data_transfer_mobile, this);
        r10.F(R$string.backup_data_transfer_wifi, this);
        OAlertDialog r11 = r10.q();
        r11.setCanceledOnTouchOutside(false);
        r11.setCancelable(true);
        r11.setOnKeyListener(this);
        return r11;
    }

    private Dialog initForceInstallConfirmDialog(OAlertDialogBuilder r10) {
        final View r11 = LayoutInflater.from(getActivity()).inflate(R$layout.dialog_option_horizontal_layout, null);
        r11.findViewById(R$id.check_record).setVisibility(8);
        ((OButton) r11.findViewById(R$id.positive_btn)).setOnClickListener(new AnonymousClass1(this));
        ((OButton) r11.findViewById(R$id.negative_btn)).setOnClickListener(new AnonymousClass2(this));
        OActionDialog.b r12 = new OActionDialog.b(getString(R$string.alert_force_installApp_title), getString(R$string.alert_force_installApp_message), new d(r11));
        OActionDialog r13 = new OActionDialog(getActivity(), r12);
        this.dialog = r13;
        r13.setCancelable(true);
        this.dialog.setOnKeyListener(this);
        return this.dialog;
    }

    private Dialog initGetGiftSuccessDialog(OAlertDialogBuilder r10) {
        r10.N(R$string.gift_get_success_title);
        int r11 = R$string.install;
        String r12 = getString(R$string.gift_get_success_msg);
        if (this.mAppInfo != null) goto L5;
    L7:
        r10.w(r12);
        r10.F(r11, this);
        r10.x(R$string.cancel, this);
        OAlertDialog r13 = r10.q();
        r13.setCanceledOnTouchOutside(false);
        r13.setCancelable(true);
        return r13;
    L5:
        if (BaseApplication.c().b().b0(this.mAppInfo.appPackageName) == false) goto L7;
        r12 = getString(R$string.gift_msg_content, new Object[]{this.mAppInfo.mGiftPackCode});
        r11 = R$string.gift_open_app;
        goto L7
    }

    private Dialog initInstallConfirmDialog(OAlertDialogBuilder r10) {
        r10.N(R$string.alert_installApp_title);
        r10.v(R$string.alert_installApp_message);
        r10.x(R$string.cancel, this);
        r10.F(R$string.install, this);
        OAlertDialog r11 = r10.q();
        r11.setCanceledOnTouchOutside(false);
        r11.setCancelable(true);
        r11.setOnKeyListener(this);
        return r11;
    }

    private Dialog initMobileReminderDialog(OAlertDialogBuilder r10) {
        long r11 = getArguments().getLong("data_size");
        boolean r12 = getArguments().getBoolean(CommonConfirmDialog.ARGS_CHECKED, false);
        final View r13 = LayoutInflater.from(getActivity()).inflate(R$layout.dialog_mobile_tip_layout, null);
        CheckBox r14 = (CheckBox) r13.findViewById(R$id.check_record);
        this.mCheckView = r14;
        r14.setChecked(r12);
        ((OButton) r13.findViewById(R$id.positive_btn)).setOnClickListener(new AnonymousClass3(this));
        ((OButton) r13.findViewById(R$id.negative_btn)).setOnClickListener(new AnonymousClass4(this));
        OActionDialog r15 = new OActionDialog(getActivity(), new OActionDialog.b(getString(R$string.alert_dataflow_title), getString(R$string.alert_dataflow_message, new Object[]{SizeConverter.BTrim.convert(r11)}), new b(r13)));
        this.dialog = r15;
        r15.setCanceledOnTouchOutside(true);
        this.dialog.setCancelable(true);
        this.dialog.setOnKeyListener(this);
        return this.dialog;
    }

    private Dialog initNoLoginAlertDialog(OAlertDialogBuilder r10) {
        r10.N(R$string.appstore_no_user);
        r10.w(this.mDialogMessage);
        r10.x(R.string.cancel, this);
        r10.F(R$string.settings_login, this);
        OAlertDialog r11 = r10.q();
        r11.setCanceledOnTouchOutside(false);
        r11.setCancelable(false);
        return r11;
    }

    private Dialog initSwitchUpdateDialog(OAlertDialogBuilder r10) {
        boolean r11 = getArguments().getBoolean(CommonConfirmDialog.ARGS_CHECKED, false);
        final View r12 = LayoutInflater.from(getActivity()).inflate(R$layout.dialog_option_horizontal_layout, null);
        CheckBox r13 = (CheckBox) r12.findViewById(R$id.check_record);
        this.mCheckView = r13;
        r13.setChecked(r11);
        ((OButton) r12.findViewById(R$id.positive_btn)).setOnClickListener(new AnonymousClass5(this));
        ((OButton) r12.findViewById(R$id.negative_btn)).setOnClickListener(new AnonymousClass6(this));
        OActionDialog.b r14 = new OActionDialog.b(getString(R$string.auto_update_dialog_title), getString(R$string.dialog_switch_update_msg), new c(r12));
        OActionDialog r15 = new OActionDialog(getActivity(), r14);
        this.dialog = r15;
        r15.C0().setGravity(3);
        return this.dialog;
    }

    private Dialog initUseGiftNoAppDialog(OAlertDialogBuilder r10) {
        r10.N(R$string.use_gift_dialog_title_no_app);
        r10.w(getString(R$string.gift_get_success_msg));
        r10.x(R$string.cancel, this);
        r10.F(R$string.install, this);
        OAlertDialog r11 = r10.q();
        r11.setCanceledOnTouchOutside(false);
        r11.setCancelable(true);
        return r11;
    }

    private /* synthetic */ Unit lambda$initAccessNetWorkTips$1(DialogContainer r10) {
        r10.getBodySlot().addView(getPrivacyPolicyContentView());
        return null;
    }

    private /* synthetic */ boolean lambda$initAccessNetWorkTips$2(DialogInterface r10, int r11, KeyEvent r12) {
        CommonConfirmDialog.DialogOnClickListener r13 = this.mOnClickListener;
        if (r13 != null) goto L5;
    L7:
        return false;
    L5:
        if (r11 != 4) goto L7;
        r13.onButtonClick(25, 4, false, getArguments());
        goto L7
    }

    private static /* synthetic */ View lambda$initForceInstallConfirmDialog$0(View r10, ViewGroup r11) {
        return r10;
    }

    private static /* synthetic */ View lambda$initMobileReminderDialog$3(View r10, ViewGroup r11) {
        return r10;
    }

    private static /* synthetic */ View lambda$initSwitchUpdateDialog$4(View r10, ViewGroup r11) {
        return r10;
    }

    public static ConfirmDialog newInstance(int r10, long r11) {
        return newInstance(r10, r11, false);
    }

    @Override // com.bytedanceos.common.ui.CommonConfirmDialog
    public Dialog createDialog(Bundle r10) {
        OAlertDialogBuilder r11 = new OAlertDialogBuilder(getActivity()).o(false);
        switch(this.mNum) {
            case 16: goto L23;
            case 17: goto L21;
            case 18: goto L4;
            case 19: goto L19;
            case 20: goto L17;
            case 21: goto L15;
            case 22: goto L4;
            case 23: goto L4;
            case 24: goto L13;
            case 25: goto L11;
            case 26: goto L9;
            case 27: goto L7;
            default: goto L4;
        };
    L4:
        com.bytedanceos.common.toolbox.j.a("unkown dialog: " + this.mNum);
        return r11.q();
    L7:
        return initForceInstallConfirmDialog(r11);
    L9:
        return initNoLoginAlertDialog(r11);
    L11:
        return initAccessNetWorkTips(r11);
    L13:
        return initUseGiftNoAppDialog(r11);
    L15:
        return initGetGiftSuccessDialog(r11);
    L17:
        return initInstallConfirmDialog(r11);
    L19:
        return initMobileReminderDialog(r11);
    L21:
        return initDataTransferSuccessDialog(r11);
    L23:
        return initSwitchUpdateDialog(r11);
    }

    @Override // com.bytedanceos.common.ui.CommonConfirmDialog, android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface r10, int r11, KeyEvent r12) {
        if (r11 == 4) goto L5;
    L21:
        return false;
    L5:
        if (r12.getRepeatCount() != 0) goto L21;
        int r13 = this.mNum;
        if (r13 == 17) goto L11;
        if (r13 == 18) goto L11;
    L17:
        if (r12.getAction() != 1) goto L21;
        if (this.mCancelled.get() == false) goto L21;
        r10.dismiss();
        this.mOnClickListener.onButtonClick(this.mNum, 4, false, getArguments());
    L11:
        if (r12.getAction() != 1) goto L17;
        if (this.mCancelled.get() == true) goto L17;
        this.mCancelled.set(true);
        e0.e(R$string.backup_exit);
        return true;
    }

    @Override // android.app.DialogFragment
    public int show(FragmentTransaction r10, String r11) {
        return super.show(r10, r11);
    L4:
        e = move-exception;
        e.printStackTrace();
        return -1;
    }

    public static ConfirmDialog newInstance(int r10, long r11, boolean r12) {
        ConfirmDialog r13 = new ConfirmDialog();
        Bundle r14 = new Bundle();
        r14.putInt("num", r10);
        r14.putBoolean(CommonConfirmDialog.ARGS_CHECKED, r12);
        r14.putLong("data_size", r11);
        r13.setArguments(r14);
        return r13;
    }

    @Override // android.app.DialogFragment
    public void show(FragmentManager r10, String r11) {
        super.show(r10, r11);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public static ConfirmDialog newInstance(int r10, boolean r11, AppInfo r12) {
        return newInstance(r10, r11, r12, false, null);
    }

    public static ConfirmDialog newInstance(int r10, boolean r11, AppInfo r12, boolean r13, String r14) {
        Bundle r15 = new Bundle();
        ConfirmDialog r16 = new ConfirmDialog();
        r15.putInt("num", r10);
        r15.putBoolean(CommonConfirmDialog.ARGS_DIALOG_ALERT, r11);
        if (r12 == null) goto L5;
        r15.putSerializable(CommonConfirmDialog.ARGS_DIALOG_APP, r12);
    L5:
        r15.putBoolean(CommonConfirmDialog.ARGS_DIALOG_USE_OAUTH, r13);
        if (TextUtils.isEmpty(r14) == true) goto L8;
        r15.putString(CommonConfirmDialog.ARGS_DIALOG_MESSAGE, r14);
    L8:
        r16.setArguments(r15);
        return r16;
    }
}
