package com.bytedanceos.common.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.R$color;
import com.bytedanceos.common.R$id;
import com.bytedanceos.common.R$layout;
import com.bytedanceos.common.R$string;
import com.bytedanceos.common.model.AppInfo;
import com.obric.oui.dialog.v2.action.OActionDialog;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
@TargetApi(11)
public abstract class CommonConfirmDialog extends DialogFragment implements DialogInterface.OnClickListener, DialogInterface.OnKeyListener {
    public static final String ARGS_CHECKED = "checked";
    public static final String ARGS_DIALOG_ALERT = "isAlertDialog";
    public static final String ARGS_DIALOG_APP = "appinfo";
    public static final String ARGS_DIALOG_MESSAGE = "dialog_msg";
    public static final String ARGS_DIALOG_NUM = "num";
    public static final String ARGS_DIALOG_USE_OAUTH = "isUseOauth";
    public static final int DIALOG_ACCESS_NET_TIPS = 25;
    public static final int DIALOG_DATA_TRANSFER_SUCCESS = 17;
    public static final int DIALOG_GET_GIFT_NETWORK_ERROR = 22;
    public static final int DIALOG_GET_GIFT_SUCCESS = 21;
    public static final int DIALOG_INSTALL_CONFIRM = 20;
    public static final int DIALOG_MOBILE_DATA_REMINDER = 19;
    public static final int DIALOG_MOBILE_DATA_TIPS = 18;
    public static final int DIALOG_NO_LOGIN = 26;
    public static final int DIALOG_SIGN_NOT_MATCH = 27;
    public static final int DIALOG_SWITCH_UPDATE = 16;
    public static final int DIALOG_USE_GIFT = 23;
    public static final int DIALOG_USE_GIFT_NO_APP = 24;
    protected OActionDialog dialog;
    public AppInfo mAppInfo;
    public final AtomicBoolean mCancelled;
    public CheckBox mCheckView;
    public String mDialogMessage;
    public boolean mIsAlertDialog;
    public boolean mIsUseOauth;
    public int mNum;
    protected DialogOnClickListener mOnClickListener;

    public interface DialogOnClickListener {
        void onButtonClick(int r10, int r11, boolean r12, Bundle r13);
    }

    public static class PrivacyPolicyURLSpan extends URLSpan {
        private Activity mActivity;

        public PrivacyPolicyURLSpan(Activity r10, String r11) {
            super(r11);
            this.mActivity = r10;
        }

        @Override // android.text.style.URLSpan, android.text.style.ClickableSpan
        public void onClick(View r10) {
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NonNull TextPaint r10) {
            super.updateDrawState(r10);
            r10.setColor(this.mActivity.getResources().getColor(R$color.oui_fill_highlighted));
            r10.setUnderlineText(false);
        }
    }

    public CommonConfirmDialog() {
        this.mCancelled = new AtomicBoolean();
    }

    public abstract Dialog createDialog(Bundle r10);

    @Override // android.app.DialogFragment
    public void dismiss() {
        super.dismiss();
    }

    public CharSequence getPolicyContentText() {
        if (getActivity() != null) goto L7;
        return "";
    L7:
        if (BaseApplication.c().o() == false) goto L9;
        String r10 = getString(R$string.dialog_Access_network_message_privacy_policy_appstore);
        String r11 = getString(R$string.dialog_access_network_message_appstore, new Object[]{r10});
    L10:
        SpannableString r12 = new SpannableString(r11);
        int r13 = r11.lastIndexOf(r10);
        int r14 = r10.length() + r13;
        r12.setSpan(new PrivacyPolicyURLSpan(getActivity(), "store:policy"), r13, r14, 33);
        return r12;
    L9:
        r10 = getString(R$string.dialog_Access_network_message_privacy_policy_gamestore);
        r11 = getString(R$string.dialog_access_network_message_gamestore, new Object[]{r10});
        goto L10
    }

    public View getPrivacyPolicyContentView() {
        View r10 = LayoutInflater.from(getActivity()).inflate(R$layout.dialog_privacy_policy, null);
        TextView r11 = (TextView) r10.findViewById(R$id.tv_privacy_policy);
        r11.setText(getPolicyContentText());
        r11.setMovementMethod(LinkMovementMethod.getInstance());
        return r10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.app.Fragment
    public void onAttach(Activity r10) {
        super.onAttach(r10);
        if (this.mOnClickListener == null) goto L10;
        return;
    L10:
        this.mOnClickListener = (DialogOnClickListener) r10;     // Catch: ClassCastException -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface r10, int r11) {
        if (this.mOnClickListener == null) goto L10;
        CheckBox r12 = this.mCheckView;
        if (r12 == null) goto L7;
        boolean r13 = r12.isChecked();
    L8:
        r10.dismiss();
        this.mOnClickListener.onButtonClick(this.mNum, r11, r13, getArguments());
        return;
    L7:
        r13 = false;
        goto L8
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onCreate(Bundle r10) {
        super.onCreate(r10);
        this.mNum = getArguments().getInt("num");
        this.mIsAlertDialog = getArguments().getBoolean(ARGS_DIALOG_ALERT, true);
        this.mAppInfo = (AppInfo) getArguments().getSerializable(ARGS_DIALOG_APP);
        this.mIsUseOauth = getArguments().getBoolean(ARGS_DIALOG_USE_OAUTH);
        this.mDialogMessage = getArguments().getString(ARGS_DIALOG_MESSAGE);
        d9.a.e().n("0022");
    }

    @Override // android.app.DialogFragment
    public Dialog onCreateDialog(Bundle r10) {
        if (this.mIsAlertDialog == true) goto L7;
        return super.onCreateDialog(r10);
    L7:
        return createDialog(r10);
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface r10, int r11, KeyEvent r12) {
        return false;
    }

    public void setOnClickListener(DialogOnClickListener r10) {
        this.mOnClickListener = r10;
    }
}
