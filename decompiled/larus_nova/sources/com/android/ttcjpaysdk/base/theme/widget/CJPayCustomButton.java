package com.android.ttcjpaysdk.base.theme.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.android.ttcjpaysdk.base.ktextension.CJPayColorHelper;
import com.android.ttcjpaysdk.base.settings.abtest.CJPayABExperimentKeys;
import com.android.ttcjpaysdk.base.theme.CJPayColorConstants;
import com.android.ttcjpaysdk.base.theme.CJPayThemeManager;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.android.ttcjpaysdk.base.utils.CJPayBasicUtils;
import com.android.ttcjpaysdk.base.utils.CJPayFakeBoldUtils;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larus.nova.R;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import r27.a;

/* JADX INFO: loaded from: classes28.dex */
public class CJPayCustomButton extends AppCompatTextView {
    private boolean enablePressedState;
    private boolean isHighlightColorEnable;
    private ButtonStyle mButtonStyle;
    private Context mContext;
    private int mCorner;
    private float mDisableAlpha;
    private int mDisableEndBgColor;
    private int mDisableOverrideTextColor;
    private boolean mDisableOverrideTextColorEnable;
    private int mDisableStartBgColor;
    private int mDisableTextColor;
    private int mEndBackgroundColor;
    private String mFixedSide;
    private Drawable mGradientDrawable;
    private int mHighlightEndColor;
    private int mHighlightStartColor;
    private int mStartBackgroundColor;
    private int mTextColor;

    public static final enum ButtonStyle extends Enum<ButtonStyle> {
        private static final /* synthetic */ ButtonStyle[] $VALUES = null;
        public static final ButtonStyle CIRCLE = null;
        public static final ButtonStyle NORMAL = null;

        private static /* synthetic */ ButtonStyle[] $values() {
            return new ButtonStyle[]{NORMAL, CIRCLE};
        }

        static {
            NORMAL = new ButtonStyle(EffectConstants.NORMAL, 0);
            CIRCLE = new ButtonStyle("CIRCLE", 1);
            $VALUES = $values();
        }

        public static ButtonStyle[] values() {
            return (ButtonStyle[]) $VALUES.clone();
        }

        public static ButtonStyle valueOf(String r100) {
            return (ButtonStyle) a.a(ButtonStyle.class, r100);
        }

        private ButtonStyle(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum Side extends Enum<Side> {
        private static final /* synthetic */ Side[] $VALUES = null;
        public static final Side Both = null;
        public static final Side Left = null;
        public static final Side None = null;
        public static final Side Right = null;
        public String value;

        private static /* synthetic */ Side[] $values() {
            return new Side[]{Left, Right, Both, None};
        }

        static {
            Left = new Side("Left", 0, "left");
            Right = new Side("Right", 1, "right");
            Both = new Side("Both", 2, "both");
            None = new Side("None", 3, "none");
            $VALUES = $values();
        }

        public static Side[] values() {
            return (Side[]) $VALUES.clone();
        }

        public static Side valueOf(String r100) {
            return (Side) a.a(Side.class, r100);
        }

        private Side(String r100, int r101, String r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    private void initColor() {
        CJPayThemeManager.ButtonInfo r100 = CJPayThemeManager.getInstance().getThemeInfo().buttonInfo;     // Catch: Exception -> L5
        this.mStartBackgroundColor = Color.parseColor(r100.startBgColor);     // Catch: Exception -> L5
        this.mEndBackgroundColor = Color.parseColor(r100.endBgColor);     // Catch: Exception -> L5
    L51:
        CJPayThemeManager.ButtonInfo r101 = CJPayThemeManager.getInstance().getThemeInfo().buttonInfo;     // Catch: Exception -> L10
        this.mHighlightStartColor = Color.parseColor(r101.highlightStartColor);     // Catch: Exception -> L10
        this.mHighlightEndColor = Color.parseColor(r101.highlightEndColor);     // Catch: Exception -> L10
        this.isHighlightColorEnable = true;     // Catch: Exception -> L10
    L41:
        this.mTextColor = Color.parseColor(CJPayThemeManager.getInstance().getThemeInfo().buttonInfo.textColor);     // Catch: Exception -> L14
    L45:
        this.mCorner = CastIntegerProtector.parseInt(CJPayThemeManager.getInstance().getThemeInfo().buttonInfo.corner);     // Catch: Exception -> L18
    L43:
        CJPayThemeManager.ButtonInfo r102 = CJPayThemeManager.getInstance().getThemeInfo().buttonInfo;     // Catch: Exception -> L22
        this.mDisableStartBgColor = Color.parseColor(r102.disableStartBgColor);     // Catch: Exception -> L22
        this.mDisableEndBgColor = Color.parseColor(r102.disableEndBgColor);     // Catch: Exception -> L22
    L53:
        this.mDisableAlpha = (float) CJPayThemeManager.getInstance().getThemeInfo().buttonInfo.disableAlpha;     // Catch: Exception -> L26
    L49:
        CJPayThemeManager.ButtonInfo r103 = CJPayThemeManager.getInstance().getThemeInfo().buttonInfo;     // Catch: Exception -> L32
        if (TextUtils.isEmpty(r103.disableTextColor) == true) goto L47;
        this.mDisableOverrideTextColor = Color.parseColor(r103.disableTextColor);     // Catch: Exception -> L32
        this.mDisableOverrideTextColorEnable = true;     // Catch: Exception -> L32
    L47:
        this.mDisableTextColor = getColorWithAlpha(this.mDisableAlpha, this.mTextColor);     // Catch: Exception -> L36
        return;
    L36:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayCustomButton#initColor", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayCustomButton#initColor", e);
        return;
    L32:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayCustomButton#initColor", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayCustomButton#initColor", e);
    L26:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayCustomButton#initColor", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayCustomButton#initColor", e);
    L22:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayCustomButton#initColor", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayCustomButton#initColor", e);
    L18:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayCustomButton#initColor", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayCustomButton#initColor", e);
    L14:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayCustomButton#initColor", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayCustomButton#initColor", e);
    L10:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayCustomButton#initColor", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayCustomButton#initColor", e);
    L5:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayCustomButton#initColor", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayCustomButton#initColor", e);
        goto L51
    }

    public void setButtonGradientBackground() {
        this.mStartBackgroundColor = CJPayColorHelper.safeParseColor(CJPayColorConstants.CJ_PAY_RED_FF6986);
        this.mEndBackgroundColor = CJPayColorHelper.safeParseColor(CJPayColorConstants.CJ_PAY_RED);
        this.mHighlightStartColor = CJPayColorHelper.safeParseColor(CJPayColorConstants.CJ_PAY_RED_E35E79);
        this.mHighlightEndColor = CJPayColorHelper.safeParseColor(CJPayColorConstants.CJ_PAY_RED_E32B50);
        this.mCorner = 8;
        this.mGradientDrawable = createDrawable(this.mStartBackgroundColor, this.mEndBackgroundColor, 8);
        enablePressedState(true);
    }

    public CJPayCustomButton(Context r100) {
        super(r100);
        this.mStartBackgroundColor = CJPayColorHelper.safeParseColor(CJPayColorConstants.CJ_PAY_RED);
        this.mEndBackgroundColor = CJPayColorHelper.safeParseColor(CJPayColorConstants.CJ_PAY_RED);
        this.mHighlightStartColor = CJPayColorHelper.safeParseColor(CJPayColorConstants.CJ_PAY_RED);
        this.mHighlightEndColor = CJPayColorHelper.safeParseColor(CJPayColorConstants.CJ_PAY_RED);
        this.mTextColor = ColorProtector.parseColor("#ffffff");
        this.mDisableTextColor = ColorProtector.parseColor("#ffffff");
        this.mCorner = 5;
        this.mDisableAlpha = 0.5f;
        this.mDisableStartBgColor = -1;
        this.mDisableEndBgColor = -1;
        this.mDisableOverrideTextColor = 0;
        this.mDisableOverrideTextColorEnable = false;
        this.mButtonStyle = ButtonStyle.NORMAL;
        this.enablePressedState = false;
        this.isHighlightColorEnable = false;
        initView(r100, null);
    }

    private int getButtonStyleRadius(int r100) {
        if (this.mButtonStyle != ButtonStyle.CIRCLE) goto L10;
        int r101 = getWidth();
        int r102 = getHeight();
        if (r101 <= 0) goto L10;
        if (r102 <= 0) goto L10;
        return Math.min(r101, r102) / 2;
    L10:
        return CJPayBasicUtils.dipToPX(this.mContext, r100);
    }

    public void enablePressedState(boolean r100) {
        this.enablePressedState = r100;
        handleBackground(isEnabled(), this.mGradientDrawable);
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas r100) {
        CJPayFakeBoldUtils.fakeBold(this, 0.75f);
        super.onDraw(r100);
    }

    public void setButtonStyle(ButtonStyle r100) {
        if (r100 != null) goto L5;
        r100 = ButtonStyle.NORMAL;
    L5:
        if (this.mButtonStyle != r100) goto L7;
        return;
    L7:
        this.mButtonStyle = r100;
        setEnabled(isEnabled());
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean r100) {
        super.setEnabled(r100);
        if (r100 == false) goto L6;
        this.mGradientDrawable = createDrawable(this.mStartBackgroundColor, this.mEndBackgroundColor, this.mCorner);
        setTextColor(this.mTextColor);
    L15:
        handleBackground(r100, this.mGradientDrawable);
        return;
    L6:
        if (this.mDisableOverrideTextColorEnable == false) goto L8;
        setTextColor(this.mDisableOverrideTextColor);
    L9:
        int r101 = this.mDisableStartBgColor;
        if (r101 == (-1)) goto L12;
    L14:
        this.mGradientDrawable = createDrawable(r101, this.mDisableEndBgColor, this.mCorner);
        goto L15
    L12:
        if (this.mDisableEndBgColor != (-1)) goto L14;
        this.mGradientDrawable = createDrawable(getColorWithAlpha(this.mDisableAlpha, this.mStartBackgroundColor), getColorWithAlpha(this.mDisableAlpha, this.mEndBackgroundColor), this.mCorner);
        goto L15
    L8:
        setTextColor(this.mDisableTextColor);
        goto L9
    }

    public void setFixedSide(Side r100) {
        this.mFixedSide = r100.value;
        setEnabled(isEnabled());
    }

    public CJPayCustomButton(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.mStartBackgroundColor = CJPayColorHelper.safeParseColor(CJPayColorConstants.CJ_PAY_RED);
        this.mEndBackgroundColor = CJPayColorHelper.safeParseColor(CJPayColorConstants.CJ_PAY_RED);
        this.mHighlightStartColor = CJPayColorHelper.safeParseColor(CJPayColorConstants.CJ_PAY_RED);
        this.mHighlightEndColor = CJPayColorHelper.safeParseColor(CJPayColorConstants.CJ_PAY_RED);
        this.mTextColor = ColorProtector.parseColor("#ffffff");
        this.mDisableTextColor = ColorProtector.parseColor("#ffffff");
        this.mCorner = 5;
        this.mDisableAlpha = 0.5f;
        this.mDisableStartBgColor = -1;
        this.mDisableEndBgColor = -1;
        this.mDisableOverrideTextColor = 0;
        this.mDisableOverrideTextColorEnable = false;
        this.mButtonStyle = ButtonStyle.NORMAL;
        this.enablePressedState = false;
        this.isHighlightColorEnable = false;
        initView(r100, r101);
    }

    private int getColorWithAlpha(float r100, int r101) {
        return (Math.min(255, Math.max(0, (int) (r100 * 255.0f))) << 24) + (r101 & 16777215);
    }

    private void initView(Context r100, AttributeSet r101) {
        this.mContext = r100;
        if (r101 == null) goto L7;
        TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{R.attr.CJPayFixSide});
        if (r102 == null) goto L7;
        this.mFixedSide = r102.getString(0);
        r102.recycle();
    L7:
        initColor();
        setTextColor(this.mTextColor);
        GradientDrawable r103 = createDrawable(this.mStartBackgroundColor, this.mEndBackgroundColor, this.mCorner);
        this.mGradientDrawable = r103;
        handleBackground(true, r103);
    }

    public void handleBackground(boolean r100, Drawable r101) {
        if (r100 == true) goto L4;
    L8:
        setBackground(r101);
        return;
    L4:
        if (this.enablePressedState == false) goto L8;
        if (this.isHighlightColorEnable == false) goto L8;
        StateListDrawable r102 = new StateListDrawable();
        r102.addState(new int[]{-16842919}, r101);
        r102.addState(new int[]{android.R.attr.state_pressed}, createDrawable(this.mHighlightStartColor, this.mHighlightEndColor, this.mCorner));
        setTextColor(new ColorStateList(new int[][]{new int[]{android.R.attr.state_pressed}, new int[]{-16842919}}, new int[]{getColorWithAlpha(0.75f, this.mTextColor), this.mTextColor}));
        r101 = r102;
        goto L8
    }

    public CJPayCustomButton(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.mStartBackgroundColor = CJPayColorHelper.safeParseColor(CJPayColorConstants.CJ_PAY_RED);
        this.mEndBackgroundColor = CJPayColorHelper.safeParseColor(CJPayColorConstants.CJ_PAY_RED);
        this.mHighlightStartColor = CJPayColorHelper.safeParseColor(CJPayColorConstants.CJ_PAY_RED);
        this.mHighlightEndColor = CJPayColorHelper.safeParseColor(CJPayColorConstants.CJ_PAY_RED);
        this.mTextColor = ColorProtector.parseColor("#ffffff");
        this.mDisableTextColor = ColorProtector.parseColor("#ffffff");
        this.mCorner = 5;
        this.mDisableAlpha = 0.5f;
        this.mDisableStartBgColor = -1;
        this.mDisableEndBgColor = -1;
        this.mDisableOverrideTextColor = 0;
        this.mDisableOverrideTextColorEnable = false;
        this.mButtonStyle = ButtonStyle.NORMAL;
        this.enablePressedState = false;
        this.isHighlightColorEnable = false;
        initView(r100, r101);
    }

    private GradientDrawable createDrawable(int r110, int r111, int r112) {
        float[] r100 = new float[8];
        int r113 = getButtonStyleRadius(r112);
        if ("left".equals(this.mFixedSide) == false) goto L6;
        r100[0] = 0.0f;
        r100[1] = 0.0f;
        float r114 = r113;
        r100[2] = r114;
        r100[3] = r114;
        r100[4] = r114;
        r100[5] = r114;
        r100[6] = 0.0f;
        r100[7] = 0.0f;
    L12:
        int[] r115 = {r110, r111};
        GradientDrawable r101 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, r115);
        r101.setCornerRadii(r100);
        if (r110 != r111) goto L15;
    L19:
        return r101;
    L15:
        if (CJPayABExperimentKeys.getCjPayButtonStyleOpt().value(true).equals("1") == false) goto L19;
        float[] r116 = {0.0f, 0.45f};
        if (Build.VERSION.SDK_INT < 29) goto L19;
        r101.setColors(r115, r116);
        goto L19
    L6:
        if ("right".equals(this.mFixedSide) == false) goto L9;
        float r117 = r113;
        r100[0] = r117;
        r100[1] = r117;
        r100[2] = 0.0f;
        r100[3] = 0.0f;
        r100[4] = 0.0f;
        r100[5] = 0.0f;
        r100[6] = r117;
        r100[7] = r117;
        goto L12
    L9:
        if ("both".equals(this.mFixedSide) == false) goto L11;
        r100[0] = 0.0f;
        r100[1] = 0.0f;
        r100[2] = 0.0f;
        r100[3] = 0.0f;
        r100[4] = 0.0f;
        r100[5] = 0.0f;
        r100[6] = 0.0f;
        r100[7] = 0.0f;
        goto L12
    L11:
        float r118 = r113;
        r100[0] = r118;
        r100[1] = r118;
        r100[2] = r118;
        r100[3] = r118;
        r100[4] = r118;
        r100[5] = r118;
        r100[6] = r118;
        r100[7] = r118;
        goto L12
    }

    @Override // android.view.View
    public void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        if (this.mButtonStyle != ButtonStyle.CIRCLE) goto L8;
        if (r100 != r102) goto L6;
        if (r101 != r103) goto L6;
        return;
    L6:
        setEnabled(isEnabled());
        return;
    }
}
