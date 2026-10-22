package com.android.contacts.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.GlobalProxyLancet;
import com.android.contacts.R;

/* JADX INFO: loaded from: classes.dex */
public class PopInfoDialogController {
    private static final String TAG = "PopInfoDialogController";
    private Activity mActivity;
    private View.OnClickListener mDismissListener;
    private Dialog mInfoDialog;

    static /* synthetic */ Dialog access$000(PopInfoDialogController r0) {
        return r0.mInfoDialog;
    }

    public PopInfoDialogController(Activity r2) {
        this.mDismissListener = new AnonymousClass1(this);
        this.mActivity = r2;
    }

    private void initDialog() {
        Dialog r0 = new Dialog(this.mActivity, R.style.pop_info_dialog_style);
        this.mInfoDialog = r0;
        r0.setCancelable(true);
        this.mInfoDialog.setCanceledOnTouchOutside(true);
    }

    public void setupDialog(CharSequence r4) {
        if (this.mInfoDialog != null) goto L9;
        initDialog();
        View r0 = LayoutInflater.from(this.mActivity).inflate(R.layout.setting_item_popup_info_view, null);
        ((TextView) r0.findViewById(R.id.popup_info_text)).setText(r4);
        Dialog r5 = this.mInfoDialog;
        if (r5 == null) goto L7;
        r5.setContentView(r0);
    L7:
        r0.setOnClickListener(this.mDismissListener);
        return;
    }

    public void showDialog() {
        Dialog r0 = this.mInfoDialog;
        if (r0 != null) goto L7;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "please init the dialog first!");
        return;
    L7:
        if (r0.isShowing() == false) goto L9;
        return;
    L9:
        if (this.mActivity.isFinishing() == true) goto L13;
        this.mInfoDialog.show();
        return;
    }

    public boolean isShowing() {
        Dialog r0 = this.mInfoDialog;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isShowing() == false) goto L7;
        return true;
    }

    public void dismissDialog() {
        if (isShowing() == false) goto L6;
        this.mInfoDialog.dismiss();
        return;
    }
}
