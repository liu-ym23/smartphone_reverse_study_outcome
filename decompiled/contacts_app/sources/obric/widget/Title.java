package obric.widget;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import android.widget.TextView;

/* JADX INFO: loaded from: classes5.dex */
public class Title extends RelativeLayout {
    public static final String EXTRA_BACK_BTN_RES_ID = "back_text_id";
    public static final String EXTRA_BACK_BTN_RES_NAME = "back_text_res_name";
    public static final String EXTRA_BACK_BTN_TEXT = "back_text";
    public static final String EXTRA_TITLE_TEXT = "title";
    public static final String EXTRA_TITLE_TEXT_ID = "title_id";
    private static final String TAG = "Title";
    private boolean isVisibilityListenerAdded;
    private boolean isVisibilityListenerRemoved;
    private ShadowTextView mBackButton;
    private View mContainer;
    private boolean mDirty;
    private String mInterestedConfigs;
    private ShadowButton mOkButton;
    private View mPlaceHolderView;
    private ShadowComponent mShadowComponent;
    private TextView mTitle;
    final ViewTreeObserver.OnGlobalLayoutListener mVisibilityListener;

    /* JADX INFO: renamed from: obric.widget.Title$4, reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$obric$widget$Title$BackButtonBgStyle = null;
        static final /* synthetic */ int[] $SwitchMap$obric$widget$Title$BackgroundStyle = null;

        static {
            int[] r0 = new int[BackButtonBgStyle.values().length];
            $SwitchMap$obric$widget$Title$BackButtonBgStyle = r0;
            r0[BackButtonBgStyle.ARROW.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L18:
            $SwitchMap$obric$widget$Title$BackButtonBgStyle[BackButtonBgStyle.NORMAL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L6:
            int[] r2 = new int[BackgroundStyle.values().length];
            $SwitchMap$obric$widget$Title$BackgroundStyle = r2;
            r2[BackgroundStyle.BLUE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L24:
            $SwitchMap$obric$widget$Title$BackgroundStyle[BackgroundStyle.BLUE_CORNER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L28:
            $SwitchMap$obric$widget$Title$BackgroundStyle[BackgroundStyle.NORMAL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L20:
            $SwitchMap$obric$widget$Title$BackgroundStyle[BackgroundStyle.BLUE_OPAQUE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L17
            return;
        }
    }

    public static final enum BackButtonBgStyle extends Enum<BackButtonBgStyle> {
        private static final /* synthetic */ BackButtonBgStyle[] $VALUES = null;
        public static final BackButtonBgStyle ARROW = null;
        public static final BackButtonBgStyle NORMAL = null;

        private BackButtonBgStyle(String $enum$name, int $enum$ordinal) {
            super($enum$name, $enum$ordinal);
        }

        public static BackButtonBgStyle valueOf(String name) {
            return (BackButtonBgStyle) Enum.valueOf(BackButtonBgStyle.class, name);
        }

        public static BackButtonBgStyle[] values() {
            return (BackButtonBgStyle[]) $VALUES.clone();
        }

        static {
            BackButtonBgStyle r0 = new BackButtonBgStyle("ARROW", 0);
            ARROW = r0;
            BackButtonBgStyle r1 = new BackButtonBgStyle("NORMAL", 1);
            NORMAL = r1;
            $VALUES = new BackButtonBgStyle[]{r0, r1};
        }
    }

    public static final enum BackgroundStyle extends Enum<BackgroundStyle> {
        private static final /* synthetic */ BackgroundStyle[] $VALUES = null;
        public static final BackgroundStyle BLUE = null;
        public static final BackgroundStyle BLUE_CORNER = null;
        public static final BackgroundStyle BLUE_OPAQUE = null;
        public static final BackgroundStyle NORMAL = null;

        private BackgroundStyle(String $enum$name, int $enum$ordinal) {
            super($enum$name, $enum$ordinal);
        }

        public static BackgroundStyle valueOf(String name) {
            return (BackgroundStyle) Enum.valueOf(BackgroundStyle.class, name);
        }

        public static BackgroundStyle[] values() {
            return (BackgroundStyle[]) $VALUES.clone();
        }

        static {
            BackgroundStyle r0 = new BackgroundStyle("BLUE", 0);
            BLUE = r0;
            BackgroundStyle r1 = new BackgroundStyle("BLUE_CORNER", 1);
            BLUE_CORNER = r1;
            BackgroundStyle r3 = new BackgroundStyle("BLUE_OPAQUE", 2);
            BLUE_OPAQUE = r3;
            BackgroundStyle r5 = new BackgroundStyle("NORMAL", 3);
            NORMAL = r5;
            $VALUES = new BackgroundStyle[]{r0, r1, r3, r5};
        }
    }

    @Deprecated
    public void setOkButtonShadow() {
    }

    static /* synthetic */ void access$000(Title r0) {
        r0.setOnVisibilityChangeListenerIfNeeded();
    }

    static /* synthetic */ TextView access$100(Title r0) {
        return r0.mTitle;
    }

    static /* synthetic */ ShadowTextView access$200(Title r0) {
        return r0.mBackButton;
    }

    static /* synthetic */ ShadowButton access$300(Title r0) {
        return r0.mOkButton;
    }

    static /* synthetic */ boolean access$400(Title r0) {
        return r0.titleViewGone();
    }

    static /* synthetic */ void access$500(Title r0) {
        r0.setTitleAlign();
    }

    static /* synthetic */ boolean access$602(Title r0, boolean r1) {
        r0.isVisibilityListenerRemoved = r1;
        return r1;
    }

    public Title(Context context) {
        super(context);
        this.mDirty = false;
        this.mVisibilityListener = new AnonymousClass3(this);
    }

    public Title(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Title(Context context, final AttributeSet attrs, final int defStyle) {
        super(context, attrs, defStyle);
        this.mDirty = false;
        this.mVisibilityListener = new AnonymousClass3(this);
        View r1 = LayoutInflater.from(context).inflate(R.layout.title_layout, this, true);
        this.mContainer = r1;
        this.mTitle = (TextView) r1.findViewById(R.id.tv_title);
        ShadowTextView r2 = (ShadowTextView) this.mContainer.findViewById(R.id.btn_back);
        this.mBackButton = r2;
        r2.setShadowEnable(false);
        this.mOkButton = (ShadowButton) this.mContainer.findViewById(R.id.btn_ok);
        this.mPlaceHolderView = this.mContainer.findViewById(R.id.place_holder);
        TypedArray r7 = context.obtainStyledAttributes(attrs, R.styleable.Title, defStyle, 0);
        CharSequence r3 = r7.getText(R.styleable.Title_backText);
        if (r3 == null) goto L5;
        setBackButtonText(r3);
    L5:
        ColorStateList r4 = r7.getColorStateList(R.styleable.Title_backTextColor);
        int r5 = r7.getDimensionPixelSize(R.styleable.Title_backTextSize, -1);
        if (r4 == null) goto L8;
        this.mBackButton.setTextColor(r4);
    L8:
        if (r5 <= 0) goto L10;
        this.mBackButton.setTextSize(0, r5);
    L10:
        boolean r6 = r7.getBoolean(R.styleable.Title_backTextVisible, true);
        ShadowTextView r8 = this.mBackButton;
        if (r6 == false) goto L13;
        int r9 = 0;
    L14:
        r8.setVisibility(r9);
        CharSequence r10 = r7.getText(R.styleable.Title_okText);
        if (r10 == null) goto L17;
        this.mOkButton.setVisibility(0);
        this.mOkButton.setText(r10);
    L17:
        ColorStateList r11 = r7.getColorStateList(R.styleable.Title_okTextColor);
        int r12 = r7.getDimensionPixelSize(R.styleable.Title_okTextSize, -1);
        if (r11 == null) goto L20;
        this.mOkButton.setTextColor(r11);
    L20:
        if (r12 <= 0) goto L22;
        this.mOkButton.setTextSize(0, r12);
    L22:
        CharSequence r13 = r7.getText(R.styleable.Title_smtTitle);
        if (r13 == null) goto L25;
        this.mTitle.setText(r13);
    L25:
        ColorStateList r14 = r7.getColorStateList(R.styleable.Title_titleColor);
        int r15 = r7.getDimensionPixelSize(R.styleable.Title_titleSize, -1);
        if (r14 == null) goto L28;
        this.mTitle.setTextColor(r14);
    L28:
        if (r15 <= 0) goto L30;
        this.mTitle.setTextSize(0, r15);
    L30:
        r7.recycle();
        this.mShadowComponent = new AnonymousClass1(this, this, attrs, defStyle);
        setTitleBackgroundResource(BackgroundStyle.NORMAL);
        setAccessibilityFocusOrder();
        this.mInterestedConfigs = generateInterestedConfig(getConfigutation());
        return;
    L13:
        r9 = 8;
        goto L14
    }

    private int getScreenWidth() {
        return getResources().getDisplayMetrics().widthPixels;
    }

    private void setAccessibilityFocusOrder() {
        View.AccessibilityDelegate r0 = new AnonymousClass2(this);
        this.mTitle.setAccessibilityDelegate(r0);
        this.mOkButton.setAccessibilityDelegate(r0);
    }

    private void setOnVisibilityChangeListenerIfNeeded() {
        if (titleViewGone() == false) goto L6;
        getViewTreeObserver().addOnGlobalLayoutListener(this.mVisibilityListener);
        this.isVisibilityListenerAdded = true;
        return;
    }

    private boolean titleViewGone() {
        View r0 = (View) getParent();
        if (getVisibility() == 8) goto L9;
        if (r0 != null) goto L6;
    L8:
        return false;
    L6:
        if (r0.getVisibility() != 8) goto L8;
    L9:
        return true;
    }

    private boolean titleViewVisible() {
        View r0 = (View) getParent();
        if (getVisibility() != 0) goto L8;
        if (r0 != null) goto L6;
    L7:
        return true;
    L6:
        if (r0.getVisibility() == 0) goto L7;
    L8:
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.isVisibilityListenerAdded == true) goto L5;
        return;
    L5:
        if (this.isVisibilityListenerRemoved == true) goto L9;
        getViewTreeObserver().removeOnGlobalLayoutListener(this.mVisibilityListener);
        return;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        String r2 = generateInterestedConfig(newConfig);
        if (r2.equals(this.mInterestedConfigs) == true) goto L6;
        this.mInterestedConfigs = r2;
        setTitleAlign();
        return;
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        if (changed == false) goto L5;
    L6:
        setTitleAlign();
        this.mDirty = false;
        return;
    L5:
        if (this.mDirty == true) goto L6;
    }

    private String generateInterestedConfig(Configuration configuration) {
        if (configuration != null) goto L6;
        return "";
    L6:
        return new StringBuffer().append(configuration.fontScale).append("|").append(configuration.orientation).toString();
    }

    private Configuration getConfigutation() {
        return getResources().getConfiguration();
    }

    private void setTitleAlign() {
        RelativeLayout.LayoutParams r0 = (RelativeLayout.LayoutParams) this.mTitle.getLayoutParams();
        float r1 = this.mBackButton.getWidth();
        if (this.mOkButton.getVisibility() != 8) goto L5;
    L7:
        float r2 = 0.0f;
    L9:
        if (r1 == 0.0f) goto L11;
    L14:
        float r5 = this.mContainer.getWidth() - (Math.max(r1, r2) * 2.0f);
        int r8 = this.mTitle.getCompoundPaddingLeft() - this.mTitle.getPaddingLeft();
        if (r5 <= (((calculateTextWidth(this.mTitle) + r8) + (this.mTitle.getCompoundPaddingRight() - this.mTitle.getPaddingRight())) + 5.0f)) goto L18;
        setPlaceHolderWidth((int) r1);
        r0.removeRule(9);
        this.mTitle.setGravity(17);
        this.mTitle.setPadding(0, 0, 0, 0);
        return;
    L18:
        if (r2 != 0.0f) goto L20;
    L23:
        int r3 = getResources().getDimensionPixelSize(R.dimen.title_place_holder_min_width);
        setPlaceHolderWidth(r3);
    L24:
        r0.addRule(9);
        this.mTitle.setGravity(3);
        this.mTitle.setPadding(((int) r1) + 1, 0, r3, 0);
        return;
    L20:
        if (this.mOkButton.getVisibility() == 8) goto L23;
        r3 = (int) r2;
        setPlaceHolderWidth(r3);
        goto L24
    L11:
        if (r2 != 0.0f) goto L14;
        setPlaceHolderWidth(0);
        this.mTitle.setGravity(17);
        this.mTitle.setPadding(0, 0, 0, 0);
        return;
    L5:
        if (TextUtils.isEmpty(this.mOkButton.getText()) == true) goto L7;
        r2 = this.mOkButton.getWidth();
        goto L9
    }

    private void setPlaceHolderWidth(int width) {
        ViewGroup.LayoutParams r0 = this.mPlaceHolderView.getLayoutParams();
        if (r0 != null) goto L6;
        r0 = new ViewGroup.LayoutParams(width, 1);
    L9:
        this.mPlaceHolderView.setLayoutParams(r0);
        return;
    L6:
        if (r0.width != width) goto L8;
        return;
    L8:
        r0.width = width;
        goto L9
    }

    private float calculateTextWidth(TextView tv) {
        Paint r1 = new Paint();
        r1.setTextSize(tv.getTextSize());
        if (tv.getText() != null) goto L7;
        return 0.0f;
    L7:
        return r1.measureText(tv.getText().toString());
    }

    public void setTitle(CharSequence title) {
        this.mTitle.setText(title);
        this.mDirty = true;
    }

    public void setTitle(int titleId) {
        setTitle(getResources().getString(titleId));
    }

    public void setTitleColor(int colorValue) {
        this.mTitle.setTextColor(colorValue);
    }

    public void setTitleBackgroundResource(BackgroundStyle style) {
        if (style != null) goto L4;
        return;
    L4:
        int r2 = AnonymousClass4.$SwitchMap$obric$widget$Title$BackgroundStyle[style.ordinal()];
        if (r2 != 1) goto L7;
        int r3 = R.drawable.title_bar_bg_blue_securitycenter;
        setShadowDrawable(R.drawable.title_bar_bg_shadow_blue_securitycenter);
    L14:
        if (r3 <= 0) goto L17;
        setBackgroundResource(r3);
        return;
    L17:
        return;
    L7:
        if (r2 != 2) goto L9;
        r3 = R.drawable.title_bar_bg_blue_securitycenter_corner;
        setShadowDrawable(R.drawable.title_bar_bg_shadow_blue_securitycenter);
        goto L14
    L9:
        if (r2 == 3) goto L11;
        r3 = -1;
        goto L14
    L11:
        r3 = R.drawable.title_bar_bg;
        setShadowDrawable(R.drawable.obric_title_bar_shadow);
        goto L14
    }

    public int getButtonTextColor(boolean normal) {
        if (normal == false) goto L5;
        return R.color.title_bar_button_text_colorlist;
    L5:
        return R.color.title_bar_highlight_button_text_colorlist;
    }

    public TextView getTitle() {
        return this.mTitle;
    }

    public View getOkButton() {
        return this.mOkButton;
    }

    public ShadowButton getOkButtonView() {
        return this.mOkButton;
    }

    public View getBackButton() {
        return this.mBackButton;
    }

    public CharSequence getOkButtonText() {
        return this.mOkButton.getText();
    }

    public CharSequence getBackButtonText() {
        return this.mBackButton.getText();
    }

    public boolean setBackButtonTextByIntent(Intent intent) {
        if (intent != null) goto L6;
        return false;
    L6:
        return setBackButtonTextByBundle(intent.getExtras());
    }

    public boolean setBackButtonTextByBundle(Bundle bundle) {
        if (bundle != null) goto L6;
        return false;
    L6:
        if (bundle.containsKey("back_text_res_name") == false) goto L12;
        String r1 = bundle.getString("back_text_res_name");
        int r2 = getResources().getIdentifier(r1, "string", getContext().getPackageName());
        if (r2 <= 0) goto L12;
        setBackButtonText(r2);
        return true;
    L12:
        if (bundle.containsKey("back_text") == false) goto L16;
        setBackButtonText(bundle.getString("back_text"));
        return true;
    L16:
        if (bundle.containsKey("back_text_id") == false) goto L22;
        int r7 = bundle.getInt("back_text_id");
        setBackButtonText(getResources().getText(r7));     // Catch: Resources.NotFoundException -> L20
        return true;
    L20:
        e = move-exception;
        e.printStackTrace();
    L22:
        setBackButtonText(R.string.title_button_text_back);
        return false;
    }

    @Deprecated
    public void setBackButtonTextByRes(int resId) {
        setBackButtonText(resId);
    }

    public void setBackButtonText(CharSequence s) {
        ShadowTextView r0 = this.mBackButton;
        if (r0 == null) goto L6;
        r0.setText(s);
        setBackBtnContentDescIfNeeded();
        this.mDirty = true;
        return;
    }

    public void setBackButtonText(int resId) {
        setBackButtonText(getResources().getText(resId));
    }

    private void setBackBtnContentDescIfNeeded() {
        CharSequence r0 = getResources().getText(R.string.title_button_text_back);
        CharSequence r1 = getResources().getText(android.R.string.cancel);
        CharSequence r2 = this.mBackButton.getText();
        if (TextUtils.equals(r0, r2) == false) goto L5;
        return;
    L5:
        if (TextUtils.equals(r1, r2) == true) goto L9;
        this.mBackButton.setContentDescription(getResources().getString(R.string.back_to_settings, new Object[]{r2}));
        return;
    }

    public void setBackButtonBackground(Drawable drawable) {
        this.mBackButton.setBackground(drawable);
        this.mDirty = true;
    }

    public void setBackButtonBackground(Drawable drawable, boolean enableShadowColors) {
        setBackButtonBackground(drawable);
        setBackButtonShadowColorsEnable(enableShadowColors);
    }

    public void setBackButtonBackgroundResource(int resId) {
        this.mBackButton.setBackgroundResource(resId);
        this.mDirty = true;
    }

    public void setBackButtonBackgroundResource(BackButtonBgStyle style) {
        if (style != null) goto L4;
        return;
    L4:
        int r2 = AnonymousClass4.$SwitchMap$obric$widget$Title$BackButtonBgStyle[style.ordinal()];
        if (r2 != 1) goto L7;
        int r3 = R.drawable.selector_small_btn_back;
    L11:
        if (r3 <= 0) goto L14;
        setBackButtonBackgroundResource(r3);
        return;
    L14:
        return;
    L7:
        if (r2 == 2) goto L9;
        r3 = -1;
        goto L11
    L9:
        r3 = R.drawable.selector_title_button_normal;
        goto L11
    }

    public void setBackButtonBackgroundResource(int resId, boolean enableShadowColors) {
        setBackButtonBackgroundResource(resId);
        setBackButtonShadowColorsEnable(enableShadowColors);
    }

    public void setBackButtonShadowColorsEnable(boolean enableShadowColors) {
        this.mBackButton.setShadowEnable(enableShadowColors);
    }

    public void setBackButtonTextGravity(int gravity) {
        this.mBackButton.setGravity(gravity);
    }

    public void resetBackButtonTextGravityAsDefault() {
        this.mBackButton.setGravity(19);
    }

    public void setBackButtonTextColor(int colorValue) {
        this.mBackButton.setTextColor(colorValue);
    }

    public void setBackButtonTextColor(ColorStateList colors) {
        this.mBackButton.setTextColor(colors);
    }

    public void resetBackButtonTextColorAsDefault() {
        setBackButtonTextColor(getResources().getColorStateList(R.color.title_bar_button_text_colorlist));
    }

    public void setOkButtonText(CharSequence s) {
        ShadowButton r0 = this.mOkButton;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getVisibility() == 0) goto L7;
        this.mOkButton.setVisibility(0);
    L7:
        this.mOkButton.setText(s);
        this.mDirty = true;
    }

    public void setOkButtonText(int resId) {
        setOkButtonText(getResources().getString(resId));
    }

    public void setOkButtonBackground(Drawable drawable) {
        this.mOkButton.setBackground(drawable);
        this.mDirty = true;
    }

    public void setOkButtonBackground(Drawable drawable, boolean enableShadowColors) {
        setOkButtonBackground(drawable);
        setOkButtonShadowColorsEnable(enableShadowColors);
    }

    public void setOkButtonBackgroundResource(int resId) {
        this.mOkButton.setBackgroundResource(resId);
        this.mDirty = true;
    }

    public void setOkButtonBackgroundResource(BackgroundStyle style) {
        if (style != null) goto L4;
        return;
    L4:
        int r3 = AnonymousClass4.$SwitchMap$obric$widget$Title$BackgroundStyle[style.ordinal()];
        if (r3 != 1) goto L7;
        int r4 = R.drawable.title_btn_blue_frame;
        resetOkButtonTextColorAsDefault();
    L14:
        if (r4 <= 0) goto L17;
        setOkButtonBackgroundResource(r4);
        return;
    L17:
        return;
    L7:
        if (r3 != 3) goto L9;
        r4 = R.drawable.selector_title_button_normal;
        setOkButtonTextColor(getResources().getColorStateList(R.color.title_bar_button_text_colorlist));
        goto L14
    L9:
        if (r3 == 4) goto L11;
        r4 = -1;
        goto L14
    L11:
        r4 = R.drawable.selector_small_btn_highlight;
        resetOkButtonTextColorAsDefault();
        goto L14
    }

    public void setOkButtonBackgroundResource(int resId, boolean enableShadowColors) {
        setOkButtonBackgroundResource(resId);
        setOkButtonShadowColorsEnable(enableShadowColors);
    }

    public void setOkButtonShadowColorsEnable(boolean enableShadowColors) {
        this.mOkButton.setShadowEnable(enableShadowColors);
    }

    public void setOkButtonTextColor(int colorValue) {
        this.mOkButton.setTextColor(colorValue);
    }

    public void setOkButtonTextColor(ColorStateList colors) {
        this.mOkButton.setTextColor(colors);
    }

    public void resetOkButtonTextColorAsDefault() {
        setOkButtonTextColor(getResources().getColorStateList(R.color.title_bar_highlight_button_text_colorlist));
    }

    public void setBackButtonListener(View.OnClickListener listener) {
        this.mBackButton.setOnClickListener(listener);
    }

    public void setOkButtonListener(View.OnClickListener listener) {
        this.mOkButton.setOnClickListener(listener);
    }

    public void updateBackButtonEnableState(boolean enable) {
        this.mBackButton.setEnabled(enable);
    }

    public void updateOkButtonEnableState(boolean enable) {
        this.mOkButton.setEnabled(enable);
    }

    public void setBackBtnArrowVisible(boolean visible) {
        if (visible == false) goto L4;
        this.mBackButton.setBackgroundResource(R.drawable.selector_title_button_back);
        this.mBackButton.setGravity(19);
        return;
    L4:
        this.mBackButton.setBackgroundResource(R.drawable.selector_title_button_normal);
        this.mBackButton.setGravity(17);
    }

    public void setShadowDrawable(int resId) {
        this.mShadowComponent.setShadowDrawable(resId);
    }

    public void setShadowVisible(boolean visible) {
        this.mShadowComponent.setShadowVisible(visible);
    }

    public View getShadowView() {
        return this.mShadowComponent.getShadowView();
    }
}
