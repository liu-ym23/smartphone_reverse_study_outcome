package obric.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/* JADX INFO: loaded from: classes5.dex */
public class ActionButtonGroup extends LinearLayout {
    private static final int ACTION_MODE_BOTH = 1;
    private static final int ACTION_MODE_LEFT = 0;
    private static final float MAX_FONT_SCALE_WITH_TEXT = 0.93f;
    private int mActionMode;
    private ShadowButton[] mBtns;
    private LinearLayout mContainer;
    private ImageButton mLeftActionButton;
    private float mMaxFontSize;
    private ImageButton mRightActionButton;
    private ShadowComponent mShadowComponent;
    private ImageView mShadowView;
    private boolean mSupportLayout;
    private boolean mUseMaxFontSize;

    public ActionButtonGroup(Context context) {
        this(context, null);
    }

    public ActionButtonGroup(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ActionButtonGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setOrientation(1);
        LayoutInflater.from(context).inflate(R.layout.obric_button_group_layout, this);
        this.mContainer = (LinearLayout) findViewById(R.id.ll_group_button_container);
        this.mShadowView = (ImageView) findViewById(R.id.obric_iv_btn_group_shadow);
        TypedArray r4 = context.obtainStyledAttributes(attrs, R.styleable.ActionButtonGroup, defStyleAttr, 0);
        this.mActionMode = r4.getInt(R.styleable.ActionButtonGroup_action_type, 0);
        this.mSupportLayout = r4.getBoolean(R.styleable.ActionButtonGroup_support_layout, true);
        r4.recycle();
        setupButtons();
        initShadowView(attrs, defStyleAttr);
    }

    public void setActionButtonGroupBackground(int resId) {
        this.mContainer.setBackgroundResource(resId);
    }

    public void setActionButtonGroupBackground(Drawable drawable) {
        this.mContainer.setBackground(drawable);
    }

    public void setActionButtonGroupBackgroundColor(int color) {
        this.mContainer.setBackgroundColor(color);
    }

    public void setActionButtonGroupShadowVisibility(boolean visible) {
        if (this.mSupportLayout == false) goto L5;
        this.mShadowComponent.setShadowVisible(visible);
        return;
    L5:
        ImageView r1 = this.mShadowView;
        if (visible == false) goto L8;
        int r2 = 0;
    L9:
        r1.setVisibility(r2);
        return;
    L8:
        r2 = 8;
        goto L9
    }

    public void setShadowDrawable(int resId) {
        if (this.mSupportLayout == false) goto L5;
        this.mShadowComponent.setShadowDrawable(resId);
        return;
    L5:
        this.mShadowView.setBackgroundResource(resId);
    }

    private void initShadowView(final AttributeSet attrs, final int defStyle) {
        if (this.mSupportLayout == true) goto L6;
        this.mShadowView.setVisibility(0);
        return;
    L6:
        this.mShadowComponent = new AnonymousClass1(this, this, attrs, defStyle);
    }

    private void setupButtons() {
        ImageButton r0 = createActionButton();
        LinearLayout.LayoutParams r1 = (LinearLayout.LayoutParams) r0.getLayoutParams();
        r1.rightMargin = getResources().getDimensionPixelSize(R.dimen.action_button_left_margin);
        r0.setLayoutParams(r1);
        this.mContainer.addView(r0);
        this.mLeftActionButton = r0;
        int r2 = getButtonCount();
        if (this.mActionMode != 0) goto L7;
        this.mContainer.setPadding(getPaddingLeft(), getPaddingTop(), getResources().getDimensionPixelSize(R.dimen.button_group_left_right_padding), getPaddingBottom());
        this.mBtns = new ShadowButton[r2];
        int r3 = 0;
    L5:
        if (r3 >= r2) goto L11;
        this.mBtns[r3] = new ShadowButton(getContext());
        LinearLayout.LayoutParams r5 = new LinearLayout.LayoutParams(0, -2);
        r5.weight = 1.0f;
        this.mBtns[r3].setLayoutParams(r5);
        this.mContainer.addView(this.mBtns[r3]);
        r3 = r3 + 1;
    L11:
        setButtonsAppearance();
        return;
    L7:
        this.mBtns = new ShadowButton[r2];
        int r4 = 0;
    L8:
        if (r4 >= r2) goto L10;
        this.mBtns[r4] = new ShadowButton(getContext());
        LinearLayout.LayoutParams r6 = new LinearLayout.LayoutParams(0, -2);
        r6.weight = 1.0f;
        this.mBtns[r4].setLayoutParams(r6);
        this.mBtns[r4].setGravity(19);
        this.mContainer.addView(this.mBtns[r4]);
        r4 = r4 + 1;
        goto L8
    L10:
        ImageButton r7 = createActionButton();
        LinearLayout.LayoutParams r8 = (LinearLayout.LayoutParams) r7.getLayoutParams();
        r8.leftMargin = getResources().getDimensionPixelSize(R.dimen.action_button_left_margin);
        r7.setLayoutParams(r8);
        this.mContainer.addView(r7);
        this.mRightActionButton = r7;
        goto L11
    }

    private void setButtonTextSize(TextView tv) {
        if (tv != null) goto L5;
        return;
    L5:
        if (this.mMaxFontSize != 0.0f) goto L10;
        Configuration r0 = getResources().getConfiguration();
        this.mMaxFontSize = (tv.getTextSize() / r0.fontScale) * MAX_FONT_SCALE_WITH_TEXT;
        if (tv.getTextSize() <= this.mMaxFontSize) goto L10;
        this.mUseMaxFontSize = true;
    L10:
        if (this.mUseMaxFontSize == false) goto L13;
        tv.setTextSize(0, this.mMaxFontSize);
        return;
    }

    private void setButtonsAppearance() {
        int r0 = 0;
    L3:
        ShadowButton[] r1 = this.mBtns;
        if (r0 >= r1.length) goto L17;
        if (r1.length <= 1) goto L15;
        r1[r0].setTextAppearance(getContext(), R.style.SmallButton_Filter);
        if (r0 != 0) goto L10;
        this.mBtns[r0].setBackgroundResource(R.drawable.selector_small_btn_filter_left);
    L14:
        int r2 = R.color.filter_button_text_shadow_colors;
        ColorStateList r3 = getResources().getColorStateList(r2);
        this.mBtns[r0].setShadowColors(r3, 0.1f, 0.0f, -2.0f);
        setButtonTextSize(this.mBtns[r0]);
    L16:
        this.mBtns[r0].setEllipsize(TextUtils.TruncateAt.END);
        this.mBtns[r0].setMaxLines(1);
        r0 = r0 + 1;
        goto L3
    L10:
        ShadowButton[] r4 = this.mBtns;
        if (r0 != (r4.length - 1)) goto L13;
        r4[r0].setBackgroundResource(R.drawable.selector_small_btn_filter_right);
        goto L14
    L13:
        r4[r0].setBackgroundResource(R.drawable.selector_small_btn_filter_middle);
        goto L14
    L15:
        r1[r0].setTextAppearance(getContext(), R.style.SmallButton_Standard);
        this.mBtns[r0].setBackgroundResource(R.drawable.selector_small_btn_standard);
        goto L16
    }

    private ImageButton createActionButton() {
        ImageButton r0 = new ImageButton(getContext());
        r0.setLayoutParams(new LinearLayout.LayoutParams((int) getResources().getDimension(R.dimen.obric_button_fixed_width), (int) getResources().getDimension(R.dimen.samrtisan_button_fixed_height)));
        r0.setMaxWidth((int) getContext().getResources().getDimension(R.dimen.obric_button_limit_min_width));
        r0.setBackgroundResource(R.drawable.selector_small_btn_standard);
        return r0;
    }

    public int getButtonCount() {
        if (this.mActionMode != 0) goto L6;
        return 4;
    L6:
        return 2;
    }

    public void setButtonText(int index, CharSequence s) {
        this.mBtns[index].setText(s);
    }

    public void setButtonText(int index, int resId) {
        setButtonText(index, getResources().getString(resId));
    }

    public void setButtonDrawable(int index, Drawable drawable) {
        InsetDrawable r0 = new InsetDrawable(drawable, getResources().getDimensionPixelSize(R.dimen.action_button_icon_inset_left), 0, getResources().getDimensionPixelSize(R.dimen.action_button_icon_inset_right), 0);
        this.mBtns[index].setCompoundDrawablesWithIntrinsicBounds(r0, null, null, null);
    }

    public void setButtonDrawable(int index, int resId) {
        setButtonDrawable(index, getResources().getDrawable(resId));
    }

    public ShadowButton getButton(int index) {
        return this.mBtns[index];
    }

    public void setButtonActivated(int index) {
        int r1 = 0;
    L3:
        ShadowButton[] r2 = this.mBtns;
        if (r1 >= r2.length) goto L10;
        ShadowButton r3 = r2[r1];
        if (r1 != index) goto L8;
        boolean r4 = true;
    L9:
        r3.setActivated(r4);
        r1 = r1 + 1;
        goto L3
    L8:
        r4 = false;
        goto L9
    }

    public ImageButton getLeftActionButton() {
        return this.mLeftActionButton;
    }

    public ImageButton getRightActionButton() {
        return this.mRightActionButton;
    }
}
