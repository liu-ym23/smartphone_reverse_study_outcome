package com.android.ttcjpaysdk.thirdparty.view.wrapper;

import android.content.Context;
import android.graphics.PorterDuff;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.ttcjpaysdk.base.CJPayHostInfo;
import com.android.ttcjpaysdk.base.framework.BaseWrapper;
import com.android.ttcjpaysdk.base.theme.CJPayThemeUtils;
import com.android.ttcjpaysdk.base.ui.CJPayInputKeyboardHelper;
import com.android.ttcjpaysdk.base.utils.CJPayDebouncingOnClickListener;
import com.android.ttcjpaysdk.thirdparty.utils.CJPayImageLoadUtils;
import com.android.ttcjpaysdk.thirdparty.view.CJPayPasteAwareEditText;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes39.dex */
public class BasicInputWrapper extends BaseWrapper {
    private int mBackGroundDrawableError;
    private int mBackGroundDrawableNormal;
    private InputData mData;
    private View mDivider;
    private CJPayPasteAwareEditText mEtInput;
    private boolean mHasError;
    private boolean mHasShowLabelAnimation;
    private boolean mInfoButtonEnabled;
    private RelativeLayout mInputBoxLayout;
    private InputErrorDetector mInputErrorDetector;
    private boolean mIsAuthLayoutInited;
    private ImageView mIvAuthIcon;
    private ImageView mIvClear;
    private ImageView mIvInfo;
    private ImageView mIvInfoNotFocus;
    private ImageView mIvLabelIcon;
    private CJPayInputKeyboardHelper mKeyboardHelper;
    private LinearLayout mLayoutAuth;
    private LinearLayout mLayoutLabel;
    private View mMaskView;
    private OnClearListener mOnClearListener;
    private View.OnFocusChangeListener mOnFocusChangeListener;
    private OnInputErrorStatusChangedListener mOnInputErrorStatusChangedListener;
    private OnRightLabelClickListener mOnRightLabelClickListener;
    private TextView mTvAuthText;
    private TextView mTvInputHint;
    private TextView mTvLabel;
    private TextView mTvRightLabel;
    private boolean needAnimation;
    private TextChangeListener textChangeListener;

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

    public interface TextChangeListener {
        void afterTextChanged(Editable r100);

        void beforeTextChanged(CharSequence r100, int r101, int r102, int r103);

        void onTextChanged(CharSequence r100, int r101, int r102, int r103);
    }

    public void disableInfoButton() {
        this.mInfoButtonEnabled = false;
        this.mIvInfo.setVisibility(8);
        this.mIvInfoNotFocus.setVisibility(8);
    }

    public void updateRightLabel(String r100) {
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

    public void clearErrorMsgWithBackground() {
        if (this.mHasError == false) goto L7;
        OnInputErrorStatusChangedListener r100 = this.mOnInputErrorStatusChangedListener;
        if (r100 == null) goto L7;
        r100.onErrorStatusChanged(false);
    L7:
        this.mHasError = false;
        this.mTvLabel.setText(InputData.access$400(this.mData));
        this.mTvLabel.setTextColor(getContext().getResources().getColor(R.color.cj_pay_color_gray_153));
        this.mInputBoxLayout.setBackgroundResource(this.mBackGroundDrawableNormal);
        this.mIvLabelIcon.setVisibility(8);
        this.mIvLabelIcon.setImageBitmap(null);
    }

    public String getInputText() {
        return this.mEtInput.getText().toString();
    }

    public void hideHint() {
        if (this.mEtInput.getText().length() != 0) goto L9;
        this.mTvInputHint.setVisibility(4);
        if (this.needAnimation == false) goto L7;
        showLabelBottomUp();
        return;
    L7:
        this.mLayoutLabel.setVisibility(0);
        return;
    }

    public void hideHintWithoutAnimation() {
        if (this.mEtInput.getText().length() != 0) goto L6;
        this.mTvInputHint.setVisibility(4);
        this.mLayoutLabel.setVisibility(0);
        return;
    }

    private void initViews() {
        getRootView().setOnClickListener(new AnonymousClass1(this));
        initEditText();
        this.mIvClear.setOnClickListener(new AnonymousClass2(this));
        TextView r100 = this.mTvRightLabel;
        if (r100 == null) goto L5;
        r100.setOnClickListener(new AnonymousClass3(this));
    L5:
        this.mEtInput.changeCursorColor();
    }

    public void clearText() {
        getEditText().clearFocus();
        getEditText().getText().clear();
        setInputEnable(true);
    }

    public CJPayPasteAwareEditText getEditText() {
        return this.mEtInput;
    }

    public View getMaskView() {
        return this.mMaskView;
    }

    public boolean hasError() {
        return this.mHasError;
    }

    public BasicInputWrapper(View r100) {
        this(r100, new CJPayInputKeyboardHelper(false, null));
    }

    public static /* synthetic */ CJPayPasteAwareEditText access$000(BasicInputWrapper r100) {
        return r100.mEtInput;
    }

    public static /* synthetic */ CJPayInputKeyboardHelper access$100(BasicInputWrapper r100) {
        return r100.mKeyboardHelper;
    }

    public static /* synthetic */ LinearLayout access$1000(BasicInputWrapper r100) {
        return r100.mLayoutLabel;
    }

    public static /* synthetic */ View access$1100(BasicInputWrapper r100) {
        return r100.mDivider;
    }

    public static /* synthetic */ View.OnFocusChangeListener access$1200(BasicInputWrapper r100) {
        return r100.mOnFocusChangeListener;
    }

    public static /* synthetic */ TextChangeListener access$1300(BasicInputWrapper r100) {
        return r100.textChangeListener;
    }

    public static /* synthetic */ OnClearListener access$200(BasicInputWrapper r100) {
        return r100.mOnClearListener;
    }

    public static /* synthetic */ OnRightLabelClickListener access$300(BasicInputWrapper r100) {
        return r100.mOnRightLabelClickListener;
    }

    public static /* synthetic */ void access$700(BasicInputWrapper r100) {
        r100.updateCloseIconStatus();
    }

    public static /* synthetic */ void access$800(BasicInputWrapper r100) {
        r100.updateInfoButtonVisibility();
    }

    public static /* synthetic */ TextView access$900(BasicInputWrapper r100) {
        return r100.mTvInputHint;
    }

    public void bindData(InputData r100) {
        this.mData = r100;
        this.mTvLabel.setText(InputData.access$400(r100));
        this.mTvInputHint.setText(InputData.access$500(r100));
        if (this.mTvRightLabel != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(InputData.access$600(this.mData)) == true) goto L7;
        this.mTvRightLabel.setVisibility(0);
        this.mTvRightLabel.setText(InputData.access$600(r100));
        return;
    L7:
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

    public void enableInfoButton(CJPayDebouncingOnClickListener r100) {
        this.mInfoButtonEnabled = true;
        updateInfoButtonVisibility();
        if (r100 == null) goto L6;
        this.mIvInfo.setOnClickListener(r100);
        this.mIvInfoNotFocus.setOnClickListener(r100);
        return;
    }

    public void setFocusable(boolean r100) {
        this.mEtInput.setFocusable(r100);
        this.mEtInput.setFocusableInTouchMode(r100);
        this.mEtInput.setCursorVisible(r100);
    }

    public void setHasShowLabelAnimation(boolean r100) {
        this.mHasShowLabelAnimation = r100;
    }

    public void setInputEnable(boolean r100) {
        setFocusable(r100);
        Context r101 = CJPayHostInfo.applicationContext;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.getResources() == null) goto L11;
        if (r100 == false) goto L8;
        this.mEtInput.setTextColor(CJPayHostInfo.applicationContext.getResources().getColor(R.color.cj_pay_color_black_34));
        return;
    L8:
        this.mEtInput.setTextColor(CJPayHostInfo.applicationContext.getResources().getColor(R.color.cj_pay_color_gray_161823_opacity_50));
        return;
    }

    public void setInputErrorDetector(InputErrorDetector r100) {
        this.mInputErrorDetector = r100;
    }

    public void setNeedAnimation(boolean r100) {
        this.needAnimation = r100;
    }

    public void setOnClearListener(OnClearListener r100) {
        this.mOnClearListener = r100;
    }

    public void setOnFocusChangeListener(View.OnFocusChangeListener r100) {
        this.mOnFocusChangeListener = r100;
    }

    public void setOnInputErrorStatusChangedListener(OnInputErrorStatusChangedListener r100) {
        this.mOnInputErrorStatusChangedListener = r100;
    }

    public void setOnRightLabelClickListener(OnRightLabelClickListener r100) {
        this.mOnRightLabelClickListener = r100;
    }

    public void setTextChangeListener(TextChangeListener r100) {
        this.textChangeListener = r100;
    }

    public void showMaskView(boolean r100) {
        if (r100 == false) goto L4;
        this.mMaskView.setVisibility(0);
        return;
    L4:
        this.mMaskView.setVisibility(8);
    }

    public void switchKeyboard(CJPayInputKeyboardHelper r100) {
        this.mKeyboardHelper = r100;
        if (this.mEtInput.hasFocus() == false) goto L6;
        this.mKeyboardHelper.showKeyboard(getContext(), this.mEtInput);
        return;
    }

    public void tryEnableAuthLayout(boolean r100) {
        if (this.mIsAuthLayoutInited == true) goto L5;
        return;
    L5:
        if (r100 == false) goto L7;
        this.mIvAuthIcon.setColorFilter(16777215, PorterDuff.Mode.LIGHTEN);
        this.mTvAuthText.setTextColor(getContext().getResources().getColor(R.color.cj_pay_color_black_161823));
        this.mLayoutAuth.setClickable(true);
        return;
    L7:
        this.mIvAuthIcon.setColorFilter(-1711276033, PorterDuff.Mode.LIGHTEN);
        this.mTvAuthText.setTextColor(getContext().getResources().getColor(R.color.cj_pay_color_gray_8a8b91));
        this.mLayoutAuth.setClickable(false);
    }

    public void tryShowAuthLayout(boolean r100) {
        if (this.mIsAuthLayoutInited == true) goto L5;
        return;
    L5:
        if (r100 == false) goto L7;
        this.mLayoutAuth.setVisibility(0);
        return;
    L7:
        this.mLayoutAuth.setVisibility(8);
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

    public void updateErrorMsgWithBackground(String r100) {
        if (this.mHasError == true) goto L7;
        OnInputErrorStatusChangedListener r101 = this.mOnInputErrorStatusChangedListener;
        if (r101 == null) goto L7;
        r101.onErrorStatusChanged(true);
    L7:
        this.mHasError = true;
        this.mTvLabel.setText(r100);
        this.mTvLabel.setTextColor(CJPayThemeUtils.getLinkLightColor());
        if (TextUtils.isEmpty(r100) == true) goto L10;
        this.mInputBoxLayout.setBackgroundResource(this.mBackGroundDrawableError);
    L11:
        this.mIvLabelIcon.setVisibility(8);
        this.mIvLabelIcon.setImageBitmap(null);
        return;
    L10:
        this.mInputBoxLayout.setBackgroundResource(this.mBackGroundDrawableNormal);
        goto L11
    }

    public BasicInputWrapper(View r100, CJPayInputKeyboardHelper r101) {
        super(r100);
        this.needAnimation = true;
        this.mEtInput = (CJPayPasteAwareEditText) r100.findViewById(R.id.et_input);
        this.mTvInputHint = (TextView) r100.findViewById(R.id.tv_input_hint);
        this.mTvLabel = (TextView) r100.findViewById(R.id.tv_label);
        this.mTvRightLabel = (TextView) r100.findViewById(R.id.tv_right_label);
        this.mIvLabelIcon = (ImageView) r100.findViewById(R.id.iv_icon);
        this.mIvClear = (ImageView) r100.findViewById(R.id.iv_close);
        this.mIvInfo = (ImageView) r100.findViewById(R.id.iv_info);
        this.mIvInfoNotFocus = (ImageView) r100.findViewById(R.id.iv_info_not_focus);
        this.mLayoutAuth = (LinearLayout) r100.findViewById(R.id.layout_auth);
        this.mIvAuthIcon = (ImageView) r100.findViewById(R.id.iv_auth_icon);
        this.mTvAuthText = (TextView) r100.findViewById(R.id.tv_auth_text);
        this.mDivider = r100.findViewById(R.id.divider_input);
        this.mMaskView = r100.findViewById(R.id.mask_view);
        this.mLayoutLabel = (LinearLayout) r100.findViewById(R.id.layout_label);
        this.mKeyboardHelper = r101;
        initViews();
    }

    public void initInputBackground(int r100, int r101) {
        this.mBackGroundDrawableError = r101;
        this.mBackGroundDrawableNormal = r100;
        this.mInputBoxLayout = (RelativeLayout) getRootView().findViewById(R.id.cj_pay_input_box_relative_layout);
        View r102 = this.mDivider;
        if (r102 == null) goto L5;
        r102.setVisibility(8);
    L5:
        RelativeLayout r103 = this.mInputBoxLayout;
        if (r103 == null) goto L9;
        r103.setBackgroundResource(this.mBackGroundDrawableNormal);
        return;
    }

    public void updateLabelMsg(String r100, String r101) {
        if (this.mHasShowLabelAnimation == true) goto L5;
        updateLabelAnimatedAppear();
        this.mHasShowLabelAnimation = true;
    L5:
        clearErrorMsg();
        this.mTvLabel.setText(r100);
        if (TextUtils.isEmpty(r101) == true) goto L9;
        CJPayImageLoadUtils.loadImage(r101, this.mIvLabelIcon);
        this.mIvLabelIcon.setVisibility(0);
        return;
    }

    public void initAuthLayout(String r100, String r101, CJPayDebouncingOnClickListener r102) {
        CJPayImageLoadUtils.loadImage(r100, this.mIvAuthIcon);
        this.mTvAuthText.setText(r101);
        this.mLayoutAuth.setOnClickListener(r102);
        this.mIsAuthLayoutInited = true;
    }
}
