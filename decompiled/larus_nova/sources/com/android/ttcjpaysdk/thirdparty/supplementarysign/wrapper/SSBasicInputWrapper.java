package com.android.ttcjpaysdk.thirdparty.supplementarysign.wrapper;

import android.text.TextUtils;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.ttcjpaysdk.base.framework.BaseWrapper;
import com.android.ttcjpaysdk.base.theme.CJPayThemeUtils;
import com.android.ttcjpaysdk.base.ui.CJPayInputKeyboardHelper;
import com.android.ttcjpaysdk.thirdparty.view.CJPayPasteAwareEditText;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes39.dex */
public class SSBasicInputWrapper extends BaseWrapper {
    private InputData mData;
    private View mDivider;
    private CJPayPasteAwareEditText mEtInput;
    private boolean mHasError;
    private boolean mInfoButtonEnabled;
    private InputErrorDetector mInputErrorDetector;
    private ImageView mIvClear;
    private ImageView mIvInfo;
    private ImageView mIvInfoNotFocus;
    private ImageView mIvLabelIcon;
    private CJPayInputKeyboardHelper mKeyboardHelper;
    private LinearLayout mLayoutLabel;
    private OnClearListener mOnClearListener;
    private View.OnFocusChangeListener mOnFocusChangeListener;
    private OnInputErrorStatusChangedListener mOnInputErrorStatusChangedListener;
    private OnRightLabelClickListener mOnRightLabelClickListener;
    private TextView mTvInputHint;
    private TextView mTvLabel;
    private TextView mTvRightLabel;

    public static class InputData {
        private String hint;
        private String label;
        private String rightLabel;

        public static /* synthetic */ String access$400(InputData r100) {
            return r100.label;
        }

        public static /* synthetic */ String access$500(InputData r100) {
            return r100.hint;
        }

        public static /* synthetic */ String access$600(InputData r100) {
            return r100.rightLabel;
        }

        public InputData(String r100, String r101) {
            this.hint = r100;
            this.label = r101;
        }

        public InputData(String r100, String r101, String r102) {
            this(r100, r101);
            this.rightLabel = r102;
        }
    }

    public interface InputErrorDetector {
        boolean checkError(String r100);
    }

    public interface OnClearListener {
        void onClear();
    }

    public interface OnInputErrorStatusChangedListener {
        void onErrorStatusChanged(boolean r100);
    }

    public interface OnRightLabelClickListener {
        void onRightLabelClick();
    }

    private void initEditText() {
        this.mEtInput.setOnFocusChangeListener(new AnonymousClass4(this));
        this.mEtInput.setOnTouchListener(new AnonymousClass5(this));
        this.mEtInput.addTextChangedListener(new AnonymousClass6(this));
    }

    private void showLabelBottomUp() {
        this.mLayoutLabel.setVisibility(0);
        TranslateAnimation r100 = new TranslateAnimation(0, 0.0f, 0, 0.0f, 0, this.mLayoutLabel.getHeight(), 0, 0.0f);
        AlphaAnimation r101 = new AlphaAnimation(0.0f, 1.0f);
        AnimationSet r102 = new AnimationSet(true);
        r102.addAnimation(r100);
        r102.addAnimation(r101);
        r102.setDuration(250);
        this.mLayoutLabel.startAnimation(r102);
    }

    private void updateCloseIconStatus() {
        if (this.mEtInput.getText().length() != 0) goto L6;
        this.mIvClear.setVisibility(8);
        return;
    L6:
        if (this.mEtInput.hasFocus() == false) goto L8;
        this.mIvClear.setVisibility(0);
        return;
    L8:
        this.mIvClear.setVisibility(8);
    }

    private void updateInfoButtonVisibility() {
        if (this.mInfoButtonEnabled == true) goto L6;
        return;
    L6:
        if (this.mEtInput.hasFocus() == false) goto L8;
        this.mIvInfo.setVisibility(0);
        this.mIvInfoNotFocus.setVisibility(8);
        return;
    L8:
        this.mIvInfo.setVisibility(8);
        this.mIvInfoNotFocus.setVisibility(0);
    }

    private void updateLabelAnimatedAppear() {
        AlphaAnimation r100 = new AlphaAnimation(0.0f, 1.0f);
        r100.setDuration(400);
        this.mLayoutLabel.setVisibility(0);
        this.mTvLabel.startAnimation(r100);
        this.mIvLabelIcon.startAnimation(r100);
    }

    public void clearErrorMsg() {
        if (this.mHasError == false) goto L7;
        updateLabelAnimatedAppear();
        OnInputErrorStatusChangedListener r100 = this.mOnInputErrorStatusChangedListener;
        if (r100 == null) goto L7;
        r100.onErrorStatusChanged(false);
    L7:
        this.mHasError = false;
        this.mTvLabel.setText(InputData.access$400(this.mData));
        this.mTvLabel.setTextColor(getContext().getResources().getColor(R.color.cj_pay_color_gray_153));
        if (getEditText().hasFocus() == false) goto L10;
        this.mDivider.setBackgroundColor(getContext().getResources().getColor(R.color.cj_pay_color_black_34));
    L11:
        this.mIvLabelIcon.setVisibility(8);
        this.mIvLabelIcon.setImageBitmap(null);
        return;
    L10:
        this.mDivider.setBackgroundColor(getContext().getResources().getColor(R.color.cj_pay_color_gray_232));
        goto L11
    }

    public String getInputText() {
        return this.mEtInput.getText().toString();
    }

    public void hideHint() {
        if (this.mEtInput.getText().length() != 0) goto L6;
        this.mTvInputHint.setVisibility(4);
        showLabelBottomUp();
        return;
    }

    private void initViews() {
        getRootView().setOnClickListener(new AnonymousClass1(this));
        initEditText();
        this.mIvClear.setOnClickListener(new AnonymousClass2(this));
        this.mTvRightLabel.setOnClickListener(new AnonymousClass3(this));
        this.mEtInput.changeCursorColor();
    }

    public CJPayPasteAwareEditText getEditText() {
        return this.mEtInput;
    }

    public boolean hasError() {
        return this.mHasError;
    }

    public SSBasicInputWrapper(View r100) {
        this(r100, new CJPayInputKeyboardHelper(false, null));
    }

    public static /* synthetic */ CJPayPasteAwareEditText access$000(SSBasicInputWrapper r100) {
        return r100.mEtInput;
    }

    public static /* synthetic */ CJPayInputKeyboardHelper access$100(SSBasicInputWrapper r100) {
        return r100.mKeyboardHelper;
    }

    public static /* synthetic */ LinearLayout access$1000(SSBasicInputWrapper r100) {
        return r100.mLayoutLabel;
    }

    public static /* synthetic */ View access$1100(SSBasicInputWrapper r100) {
        return r100.mDivider;
    }

    public static /* synthetic */ View.OnFocusChangeListener access$1200(SSBasicInputWrapper r100) {
        return r100.mOnFocusChangeListener;
    }

    public static /* synthetic */ OnClearListener access$200(SSBasicInputWrapper r100) {
        return r100.mOnClearListener;
    }

    public static /* synthetic */ OnRightLabelClickListener access$300(SSBasicInputWrapper r100) {
        return r100.mOnRightLabelClickListener;
    }

    public static /* synthetic */ void access$700(SSBasicInputWrapper r100) {
        r100.updateCloseIconStatus();
    }

    public static /* synthetic */ void access$800(SSBasicInputWrapper r100) {
        r100.updateInfoButtonVisibility();
    }

    public static /* synthetic */ TextView access$900(SSBasicInputWrapper r100) {
        return r100.mTvInputHint;
    }

    public void bindData(InputData r100) {
        this.mData = r100;
        this.mTvLabel.setText(InputData.access$400(r100));
        this.mTvInputHint.setText(InputData.access$500(r100));
        if (TextUtils.isEmpty(InputData.access$600(this.mData)) == true) goto L5;
        this.mTvRightLabel.setVisibility(0);
        this.mTvRightLabel.setText(InputData.access$600(r100));
        return;
    L5:
        this.mTvRightLabel.setVisibility(8);
        this.mTvRightLabel.setText("");
    }

    public boolean checkError(String r100) {
        InputErrorDetector r101 = this.mInputErrorDetector;
        if (r101 != null) goto L5;
        return false;
    L5:
        return r101.checkError(r100);
    }

    public void setInputErrorDetector(InputErrorDetector r100) {
        this.mInputErrorDetector = r100;
    }

    public void setOnClearListener(OnClearListener r100) {
        this.mOnClearListener = r100;
    }

    public void setOnFocusChangeListener(View.OnFocusChangeListener r100) {
        this.mOnFocusChangeListener = r100;
    }

    public void updateErrorMsg(String r100) {
        if (this.mHasError == true) goto L7;
        updateLabelAnimatedAppear();
        OnInputErrorStatusChangedListener r101 = this.mOnInputErrorStatusChangedListener;
        if (r101 == null) goto L7;
        r101.onErrorStatusChanged(true);
    L7:
        this.mHasError = true;
        this.mTvLabel.setText(r100);
        this.mTvLabel.setTextColor(CJPayThemeUtils.getLinkLightColor());
        this.mDivider.setBackgroundColor(CJPayThemeUtils.getLinkLightColor());
        this.mIvLabelIcon.setVisibility(8);
        this.mIvLabelIcon.setImageBitmap(null);
    }

    public SSBasicInputWrapper(View r100, CJPayInputKeyboardHelper r101) {
        super(r100);
        this.mEtInput = (CJPayPasteAwareEditText) r100.findViewById(R.id.et_input);
        this.mTvInputHint = (TextView) r100.findViewById(R.id.tv_input_hint);
        this.mTvLabel = (TextView) r100.findViewById(R.id.tv_label);
        this.mTvRightLabel = (TextView) r100.findViewById(R.id.tv_right_label);
        this.mIvLabelIcon = (ImageView) r100.findViewById(R.id.iv_icon);
        this.mIvClear = (ImageView) r100.findViewById(R.id.iv_close);
        this.mIvInfo = (ImageView) r100.findViewById(R.id.iv_info);
        this.mIvInfoNotFocus = (ImageView) r100.findViewById(R.id.iv_info_not_focus);
        this.mDivider = r100.findViewById(R.id.divider_input);
        this.mLayoutLabel = (LinearLayout) r100.findViewById(R.id.layout_label);
        this.mKeyboardHelper = r101;
        initViews();
    }
}
