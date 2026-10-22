package com.android.ttcjpaysdk.thirdparty.supplementarysign.wrapper;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.ttcjpaysdk.base.framework.BaseWrapper;
import com.android.ttcjpaysdk.base.theme.widget.CJPayCustomButton;
import com.android.ttcjpaysdk.base.ui.data.CJPayButtonInfo;
import com.android.ttcjpaysdk.base.ui.dialog.CJPayCommonDialog;
import com.android.ttcjpaysdk.base.ui.widget.CJPayKeyboardView;
import com.android.ttcjpaysdk.thirdparty.view.CJPayObservableStateScrollView;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: classes39.dex */
public class SSUpdateCardInfoWrapper extends BaseWrapper {
    public LinearLayout mAgreementContainer;
    public ImageView mBackView;
    public boolean mCanGoNext;
    public CJPayCommonDialog mErrorDialog;
    public FrameLayout mFlLayout;
    public View mKeyboardPlaceholder;
    public CJPayKeyboardView mKeyboardView;
    public ProgressBar mProgressLoading;
    public RelativeLayout mReservedMobileContainer;
    public RelativeLayout mRootView;
    public CJPayObservableStateScrollView mScrollView;
    public TextView mTvCardType;
    public CJPayCustomButton mTvNextStep;
    public TextView mTvSubTitle;
    public TextView mTvTitle;

    private void initViews() {
        this.mBackView.setImageResource(R.drawable.cj_pay_icon_titlebar_left_arrow);
    }

    public boolean isLoading() {
        if (this.mProgressLoading.getVisibility() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public SSUpdateCardInfoWrapper(View r100) {
        super(r100);
        this.mCanGoNext = false;
        this.mScrollView = (CJPayObservableStateScrollView) r100.findViewById(R.id.cj_pay_ss_scroll_view);
        this.mRootView = (RelativeLayout) r100.findViewById(R.id.cj_pay_ss_content_layout);
        this.mFlLayout = (FrameLayout) r100.findViewById(R.id.cj_pay_ss_update_card_info_root_view);
        this.mBackView = (ImageView) r100.findViewById(R.id.cj_pay_back_view);
        this.mTvCardType = (TextView) r100.findViewById(R.id.cj_pay_ss_card_info);
        this.mTvNextStep = (CJPayCustomButton) r100.findViewById(R.id.cj_pay_ss_next_btn);
        this.mReservedMobileContainer = (RelativeLayout) r100.findViewById(R.id.cj_pay_ss_reserved_mobile_container);
        this.mAgreementContainer = (LinearLayout) r100.findViewById(R.id.cj_pay_ss_agreement_container);
        this.mKeyboardView = (CJPayKeyboardView) r100.findViewById(R.id.cj_pay_ss_keyboard_view);
        this.mKeyboardPlaceholder = r100.findViewById(R.id.cj_pay_ss_fake_keyboard_placeholder);
        this.mProgressLoading = (ProgressBar) r100.findViewById(R.id.cj_pay_ss_next_btn_loading);
        this.mTvTitle = (TextView) r100.findViewById(R.id.cj_pay_ss_update_card_info_tip);
        this.mTvSubTitle = (TextView) r100.findViewById(R.id.cj_pay_ss_safety_hint);
        initViews();
    }

    public static void INVOKEVIRTUAL_com_android_ttcjpaysdk_thirdparty_supplementarysign_wrapper_SSUpdateCardInfoWrapper_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(CJPayCommonDialog r100) {
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

    public void setNextBtnEnabled(boolean r100) {
        this.mCanGoNext = r100;
        this.mTvNextStep.setEnabled(r100);
        this.mTvNextStep.setVisibility(0);
    }

    public void showErrorDialog(final Activity r100, final SSMobileInputWrapper r101, CJPayButtonInfo r110, final View.OnClickListener r111) {
        if (r110 != null) goto L4;
        return;
    L4:
        if (r100 != null) goto L6;
        return;
    L6:
        String r102 = r110.left_button_desc;
        String r103 = r110.right_button_desc;
        String r104 = r110.button_desc;
        if (TextUtils.isEmpty(r110.error_code) == true) goto L9;
        String r105 = r100.getString(R.string.cj_pay_ss_ul_error_code_tip, new Object[]{r110.error_code});
    L11:
        if ("2".equals(r110.button_type) == false) goto L13;
        r104 = "";
    L14:
        CJPayCommonDialog r106 = new CJPayCommonDialog.DialogBuilder(r100, R.style.CJ_Pay_Dialog_With_Layer).setTitle(r110.page_desc).setSubTitle(r105).setSubTitleColor(r100.getResources().getColor(R.color.cj_pay_color_gray_202)).setLeftText(r102).setRightText(r103).setSingleText(r104).setLeftListener(new AnonymousClass3(this)).setRightListener(new AnonymousClass2(this, r101, r100)).setSingleListener(new AnonymousClass1(this, r111)).build();
        this.mErrorDialog = r106;
        INVOKEVIRTUAL_com_android_ttcjpaysdk_thirdparty_supplementarysign_wrapper_SSUpdateCardInfoWrapper_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(r106);
        return;
    L13:
        r102 = "";
        r103 = r102;
        goto L14
    L9:
        r105 = "";
        goto L11
    }
}
