package com.obric.oui.chip.v2;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.oui.common.style.f;
import com.obric.oui.common.style.j;
import com.obric.oui.common.util.g;
import com.obric.oui.d.a.b;
import com.obric.oui.layout.OUIFrameLayout;
import com.obric.oui.layout.OUILinearLayout;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.a.m;
import d.h.b.h;
import d.h.b.o;
import d.x;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: OChip.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class OChip extends OUIFrameLayout {
    public static final a Companion = null;
    private static final String TAG = "OChip";
    private final ImageView arrowIcon;
    private int arrowIconTintColor;
    private int chipArrowSpaceL;
    private int chipArrowSpaceR;
    private final OUILinearLayout chipContainer;
    private final ImageView chipIcon;
    private int chipIconSpaceL;
    private int chipIconSpaceR;
    private int chipIconTintColor;
    private final ImageView closeIcon;
    private int closeIconTintColor;
    private boolean haveShadow;
    private boolean isOn;
    private m<? super OChip, ? super Boolean, x> onCheckedListener;
    private View.OnClickListener onCloseListener;
    private final View parent;
    private int pressColor;
    private List<j> shadowsNormal;
    private int textColor;
    private int textColorDisabled;
    private final TextView textView;
    private boolean toggleable;
    private int widgetBgColor;
    private int widgetBgColorDisabled;
    private int widgetPaddingLeft;
    private int widgetPaddingRight;

    /* JADX INFO: compiled from: OChip.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        Companion = new a(null);
    }

    public OChip(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public OChip(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public static /* synthetic */ void lambda$IuiIXCwgeIVPgm2x1A0k5GxyJnU(OChip r0, View r1) {
        m992initCloseIcon$lambda5(r0, r1);
    }

    public /* synthetic */ OChip(Context r2, AttributeSet r3, int r4, int r5, h r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        this(r7, r8, r4);
    }

    public OChip(Context r18, AttributeSet r19, int r20) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r18, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r10 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r19, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r9, "context");
        super(r9, r10, r20, null, 8, null);
        View r0 = FrameLayout.inflate(r9, ZeusTransformUtils.mapRes(R.layout.o_chip_v2, "layout", "o_chip_v2"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.aiagent.plugin"));
        this.parent = r0;
        View r1 = r0.findViewById(ZeusTransformUtils.mapRes(R.id.chip_container, DbHelper.COL_ID, "chip_container"));
        o.c(r1, "parent.findViewById(R.id.chip_container)");
        OUILinearLayout r2 = (OUILinearLayout) ZeusTransformUtils.preCheckCast(r1, OUILinearLayout.class, "com.obric.aiagent.plugin");
        this.chipContainer = r2;
        View r3 = r0.findViewById(ZeusTransformUtils.mapRes(R.id.chip_icon, DbHelper.COL_ID, "chip_icon"));
        o.c(r3, "parent.findViewById(R.id.chip_icon)");
        ImageView r4 = (ImageView) ZeusTransformUtils.preCheckCast(r3, ImageView.class, "com.obric.aiagent.plugin");
        this.chipIcon = r4;
        View r5 = r0.findViewById(ZeusTransformUtils.mapRes(R.id.chip_text, DbHelper.COL_ID, "chip_text"));
        o.c(r5, "parent.findViewById(R.id.chip_text)");
        this.textView = (TextView) ZeusTransformUtils.preCheckCast(r5, TextView.class, "com.obric.aiagent.plugin");
        View r6 = r0.findViewById(ZeusTransformUtils.mapRes(R.id.close_icon, DbHelper.COL_ID, "close_icon"));
        o.c(r6, "parent.findViewById(R.id.close_icon)");
        ImageView r7 = (ImageView) ZeusTransformUtils.preCheckCast(r6, ImageView.class, "com.obric.aiagent.plugin");
        this.closeIcon = r7;
        View r8 = r0.findViewById(ZeusTransformUtils.mapRes(R.id.arrow_icon, DbHelper.COL_ID, "arrow_icon"));
        o.c(r8, "parent.findViewById(R.id.arrow_icon)");
        ImageView r11 = (ImageView) ZeusTransformUtils.preCheckCast(r8, ImageView.class, "com.obric.aiagent.plugin");
        this.arrowIcon = r11;
        this.isOn = true;
        TypedArray r12 = r9.obtainStyledAttributes(r10, R.styleable.OChip);
        getChipIcon().setImageDrawable(r12.getDrawable(ZeusTransformUtils.mapRes(R.styleable.OChip_oui_chip_icon, "styleable", "OChip_oui_chip_icon")));
        getTextView().setText(r12.getText(ZeusTransformUtils.mapRes(R.styleable.OChip_oui_text, "styleable", "OChip_oui_text")));
        getCloseIcon().setImageDrawable(r12.getDrawable(ZeusTransformUtils.mapRes(R.styleable.OChip_oui_close_icon, "styleable", "OChip_oui_close_icon")));
        getArrowIcon().setImageDrawable(r12.getDrawable(ZeusTransformUtils.mapRes(R.styleable.OChip_oui_chipArrowIcon, "styleable", "OChip_oui_chipArrowIcon")));
        this.chipIconTintColor = r12.getColor(ZeusTransformUtils.mapRes(R.styleable.OChip_oui_chip_icon_tint_color, "styleable", "OChip_oui_chip_icon_tint_color"), 0);
        this.closeIconTintColor = r12.getColor(ZeusTransformUtils.mapRes(R.styleable.OChip_oui_close_icon_tint_color, "styleable", "OChip_oui_close_icon_tint_color"), 0);
        this.arrowIconTintColor = r12.getColor(ZeusTransformUtils.mapRes(R.styleable.OChip_oui_arrow_icon_tint_color, "styleable", "OChip_oui_arrow_icon_tint_color"), 0);
        this.textColor = r12.getColor(ZeusTransformUtils.mapRes(R.styleable.OChip_oui_text_color, "styleable", "OChip_oui_text_color"), 0);
        this.textColorDisabled = r12.getColor(ZeusTransformUtils.mapRes(R.styleable.OChip_oui_text_color_disabled, "styleable", "OChip_oui_text_color_disabled"), 0);
        this.widgetBgColor = r12.getColor(ZeusTransformUtils.mapRes(R.styleable.OChip_oui_widgetBgColor, "styleable", "OChip_oui_widgetBgColor"), 0);
        this.widgetBgColorDisabled = r12.getColor(ZeusTransformUtils.mapRes(R.styleable.OChip_oui_widgetBgColorDisabled, "styleable", "OChip_oui_widgetBgColorDisabled"), 0);
        this.toggleable = r12.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OChip_oui_chip_toggleable, "styleable", "OChip_oui_chip_toggleable"), false);
        this.widgetPaddingLeft = r12.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.OChip_oui_widgetPaddingL, "styleable", "OChip_oui_widgetPaddingL"), 0);
        this.widgetPaddingRight = r12.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.OChip_oui_widgetPaddingR, "styleable", "OChip_oui_widgetPaddingR"), 0);
        this.chipIconSpaceL = r12.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.OChip_oui_chipIconSpaceL, "styleable", "OChip_oui_chipIconSpaceL"), 0);
        this.chipIconSpaceR = r12.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.OChip_oui_chipIconSpaceR, "styleable", "OChip_oui_chipIconSpaceR"), 0);
        this.chipArrowSpaceL = r12.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.OChip_oui_chipArrowSpaceL, "styleable", "OChip_oui_chipArrowSpaceL"), 0);
        this.chipArrowSpaceR = r12.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.OChip_oui_chipArrowSpaceR, "styleable", "OChip_oui_chipArrowSpaceR"), 0);
        getChipContainer().setPadding(this.widgetPaddingLeft, getChipContainer().getPaddingTop(), this.widgetPaddingRight, getChipContainer().getPaddingBottom());
        int r13 = r12.getColor(ZeusTransformUtils.mapRes(R.styleable.OChip_oui_widgetPressColor, "styleable", "OChip_oui_widgetPressColor"), 0);
        this.pressColor = r13;
        if (r13 == 0) goto L5;
        getChipContainer().setOverridePressColor(this.pressColor);
        getChipContainer().refreshColors(TAG);
    L5:
        o.c(r12, "this");
        this.haveShadow = initShadows(r9, r12);
        r12.recycle();
        TypedArray r14 = r9.obtainStyledAttributes(r10, new int[]{android.R.attr.minWidth, android.R.attr.minHeight});
        int r15 = r14.getDimensionPixelSize(0, 0);
        int r16 = r14.getDimensionPixelSize(1, 0);
        if (r15 <= 0) goto L8;
        getChipContainer().setMinimumWidth(r15);
    L8:
        if (r16 <= 0) goto L10;
        getChipContainer().setMinimumHeight(r16);
    L10:
        r14.recycle();
        setChangeAlphaWhenPress(false);
        if (r4.getDrawable() == null) goto L13;
        boolean r17 = true;
    L14:
        initChipIcon(r17);
        if (r7.getDrawable() == null) goto L17;
        boolean r21 = true;
    L18:
        initCloseIcon(r21);
        if (r11.getDrawable() == null) goto L21;
        boolean r22 = true;
    L22:
        initArrowIcon(r22);
        updateColors(true);
        int r23 = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 99);
        if (this.haveShadow == false) goto L25;
        b.b(TAG, "initShadows, have shadow");
        setShadowCornerRadius(r23);
        r2.setRadius(r23);
    L26:
        setClipChildren(false);
        return;
    L25:
        setRadius(r23);
        goto L26
    L21:
        r22 = false;
        goto L22
    L17:
        r21 = false;
        goto L18
    L13:
        r17 = false;
        goto L14
    }

    public final OUILinearLayout getChipContainer() {
        return this.chipContainer;
    }

    public final ImageView getChipIcon() {
        return this.chipIcon;
    }

    public final TextView getTextView() {
        return this.textView;
    }

    public final ImageView getCloseIcon() {
        return this.closeIcon;
    }

    public final ImageView getArrowIcon() {
        return this.arrowIcon;
    }

    public final boolean isOn() {
        return this.isOn;
    }

    public final void setOn(boolean r2) {
        if (this.isOn == r2) goto L9;
        this.isOn = r2;
        updateColors(r2);
        m<? super OChip, ? super Boolean, x> r3 = this.onCheckedListener;
        if (r3 == null) goto L10;
        r3.invoke(this, Boolean.valueOf(this.isOn));
        return;
    L10:
        return;
    }

    public final CharSequence getText() {
        CharSequence r1 = this.textView.getText();
        o.c(r1, "textView.text");
        return r1;
    }

    public final void setText(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        o.e(r4, "value");
        this.textView.setText(r4);
    }

    private final boolean initShadows(Context r6, TypedArray r7) {
        List<j> r8 = f.a((Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin"), r7, ZeusTransformUtils.mapRes(R.styleable.OChip_oui_widgetShadowNormal, "styleable", "OChip_oui_widgetShadowNormal"));
        if (r8 == null) goto L5;
        this.shadowsNormal = r8;
        o.a(r8);
        j r2 = (j) ZeusTransformUtils.preCheckCast(p.d(r8, 0), j.class, "com.obric.aiagent.plugin");
        List<j> r3 = this.shadowsNormal;
        o.a(r3);
        a(r2, (j) ZeusTransformUtils.preCheckCast(p.d(r3, 1), j.class, "com.obric.aiagent.plugin"));
    L5:
        if (r8 == null) goto L8;
        return true;
    L8:
        return false;
    }

    public final void setWidgetBgColor(int r2) {
        if (r2 == 0) goto L7;
        this.widgetBgColor = r2;
        if (isOn() == false) goto L8;
        this.chipContainer.setBackgroundColor(r2);
        return;
    L8:
        return;
    }

    public final void setChipTextColor(int r2) {
        if (r2 == 0) goto L7;
        this.textColor = r2;
        if (isOn() == false) goto L8;
        this.textView.setTextColor(r2);
        return;
    L8:
        return;
    }

    public final void setChipIconTintColor(int r2) {
        if (r2 == 0) goto L10;
        this.chipIconTintColor = r2;
        if (isOn() == false) goto L11;
        Drawable r1 = this.chipIcon.getDrawable();
        if (r1 == null) goto L12;
        r1.setTint(r2);
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void setCloseIconTintColor(int r2) {
        if (r2 == 0) goto L10;
        this.closeIconTintColor = r2;
        if (isOn() == false) goto L11;
        Drawable r1 = this.closeIcon.getDrawable();
        if (r1 == null) goto L12;
        r1.setTint(r2);
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void setArrowIconTintColor(int r2) {
        if (r2 == 0) goto L10;
        this.arrowIconTintColor = r2;
        if (isOn() == false) goto L11;
        Drawable r1 = this.arrowIcon.getDrawable();
        if (r1 == null) goto L12;
        r1.setTint(r2);
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void setWidgetBgColorDisabled(int r2) {
        if (r2 == 0) goto L7;
        this.widgetBgColorDisabled = r2;
        if (isOn() == true) goto L8;
        this.chipContainer.setBackgroundColor(r2);
        return;
    L8:
        return;
    }

    public final void setChipTextColorDisabled(int r2) {
        if (r2 == 0) goto L11;
        this.textColorDisabled = r2;
        if (isOn() == true) goto L12;
        Drawable r0 = this.chipIcon.getDrawable();
        if (r0 == null) goto L9;
        r0.setTint(r2);
    L9:
        this.textView.setTextColor(r2);
        return;
    L12:
        return;
    }

    private final void updateColors(boolean r2) {
        if (r2 == false) goto L27;
        int r3 = this.widgetBgColor;
        if (r3 == 0) goto L7;
        this.chipContainer.setBackgroundColor(r3);
    L7:
        if (this.chipIconTintColor == 0) goto L13;
        Drawable r4 = this.chipIcon.getDrawable();
        if (r4 == null) goto L13;
        r4.setTint(this.chipIconTintColor);
    L13:
        if (this.closeIconTintColor == 0) goto L19;
        Drawable r5 = this.closeIcon.getDrawable();
        if (r5 == null) goto L19;
        r5.setTint(this.closeIconTintColor);
    L19:
        if (this.arrowIconTintColor == 0) goto L24;
        Drawable r6 = this.arrowIcon.getDrawable();
        if (r6 == null) goto L24;
        r6.setTint(this.arrowIconTintColor);
    L24:
        int r7 = this.textColor;
        if (r7 == 0) goto L38;
        this.textView.setTextColor(r7);
        return;
    L38:
        return;
    L27:
        int r8 = this.widgetBgColorDisabled;
        if (r8 == 0) goto L31;
        this.chipContainer.setBackgroundColor(r8);
    L31:
        if (this.textColorDisabled == 0) goto L40;
        Drawable r9 = this.chipIcon.getDrawable();
        if (r9 == null) goto L36;
        r9.setTint(this.textColorDisabled);
    L36:
        this.textView.setTextColor(this.textColorDisabled);
        return;
    }

    private final void initChipIcon(boolean r5) {
        if (r5 == false) goto L5;
        View r6 = (View) ZeusTransformUtils.preCheckCast(this.textView, View.class, "com.obric.aiagent.plugin");
        ViewGroup.LayoutParams r3 = r6.getLayoutParams();
        Objects.requireNonNull(r3, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.LayoutParams r1 = (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r3, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin"), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin");
        ((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r1, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin")).setMarginStart(this.chipIconSpaceL);
        r6.setLayoutParams(r1);
        this.chipIcon.setVisibility(0);
        return;
    L5:
        View r7 = (View) ZeusTransformUtils.preCheckCast(this.textView, View.class, "com.obric.aiagent.plugin");
        ViewGroup.LayoutParams r4 = r7.getLayoutParams();
        Objects.requireNonNull(r4, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.LayoutParams r2 = (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r4, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin"), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin");
        ((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r2, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin")).setMarginStart(0);
        r7.setLayoutParams(r2);
        this.chipIcon.setVisibility(8);
    }

    private final void initCloseIcon(boolean r5) {
        if (r5 == false) goto L5;
        View r6 = (View) ZeusTransformUtils.preCheckCast(this.closeIcon, View.class, "com.obric.aiagent.plugin");
        ViewGroup.LayoutParams r3 = r6.getLayoutParams();
        Objects.requireNonNull(r3, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.LayoutParams r1 = (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r3, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin"), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin");
        ((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r1, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin")).setMarginStart(this.chipIconSpaceR);
        r6.setLayoutParams(r1);
        this.closeIcon.setVisibility(0);
        this.closeIcon.setOnClickListener(new $$Lambda$OChip$IuiIXCwgeIVPgm2x1A0k5GxyJnU(this));
        return;
    L5:
        View r7 = (View) ZeusTransformUtils.preCheckCast(this.closeIcon, View.class, "com.obric.aiagent.plugin");
        ViewGroup.LayoutParams r4 = r7.getLayoutParams();
        Objects.requireNonNull(r4, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.LayoutParams r2 = (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r4, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin"), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin");
        ((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r2, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin")).setMarginStart(0);
        r7.setLayoutParams(r2);
        this.closeIcon.setVisibility(8);
    }

    /* JADX INFO: renamed from: initCloseIcon$lambda-5, reason: not valid java name */
    private static final void m992initCloseIcon$lambda5(OChip r2, View r3) {
        o.e(r2, "this$0");
        if (r2.isEnabled() == false) goto L9;
        View.OnClickListener r4 = r2.onCloseListener;
        if (r4 == null) goto L10;
        r4.onClick((View) ZeusTransformUtils.preCheckCast(r2.closeIcon, View.class, "com.obric.aiagent.plugin"));
        return;
    L10:
        return;
    }

    private final void initArrowIcon(boolean r5) {
        if (r5 == false) goto L5;
        View r6 = (View) ZeusTransformUtils.preCheckCast(this.arrowIcon, View.class, "com.obric.aiagent.plugin");
        ViewGroup.LayoutParams r3 = r6.getLayoutParams();
        Objects.requireNonNull(r3, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.LayoutParams r1 = (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r3, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin"), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin");
        ((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r1, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin")).setMarginStart(this.chipArrowSpaceL);
        r6.setLayoutParams(r1);
        this.arrowIcon.setVisibility(0);
        return;
    L5:
        View r7 = (View) ZeusTransformUtils.preCheckCast(this.arrowIcon, View.class, "com.obric.aiagent.plugin");
        ViewGroup.LayoutParams r4 = r7.getLayoutParams();
        Objects.requireNonNull(r4, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.LayoutParams r2 = (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r4, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin"), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin");
        ((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r2, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin")).setMarginStart(0);
        r7.setLayoutParams(r2);
        this.arrowIcon.setVisibility(8);
    }

    public final void updateCloseIcon(boolean r5) {
        if (r5 == false) goto L5;
        View r6 = (View) ZeusTransformUtils.preCheckCast(this.closeIcon, View.class, "com.obric.aiagent.plugin");
        ViewGroup.LayoutParams r3 = r6.getLayoutParams();
        Objects.requireNonNull(r3, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.LayoutParams r1 = (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r3, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin"), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin");
        ((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r1, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin")).setMarginStart(this.chipIconSpaceR);
        r6.setLayoutParams(r1);
        this.closeIcon.setVisibility(0);
        OUILinearLayout r7 = this.chipContainer;
        r7.setPadding(this.widgetPaddingLeft, r7.getPaddingTop(), this.widgetPaddingRight, this.chipContainer.getPaddingBottom());
        return;
    L5:
        View r8 = (View) ZeusTransformUtils.preCheckCast(this.closeIcon, View.class, "com.obric.aiagent.plugin");
        ViewGroup.LayoutParams r4 = r8.getLayoutParams();
        Objects.requireNonNull(r4, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.LayoutParams r2 = (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r4, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin"), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin");
        ((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r2, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin")).setMarginStart(0);
        r8.setLayoutParams(r2);
        this.closeIcon.setVisibility(8);
        if (this.widgetPaddingLeft != this.widgetPaddingRight) goto L8;
        return;
    L8:
        if (this.chipIcon.getVisibility() != 8) goto L13;
        OUILinearLayout r9 = this.chipContainer;
        r9.setPadding(this.widgetPaddingLeft, r9.getPaddingTop(), this.widgetPaddingLeft, this.chipContainer.getPaddingBottom());
        return;
    }

    public final void setOnCloseListener(View.OnClickListener r3) {
        this.onCloseListener = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r3, View.OnClickListener.class, "com.obric.aiagent.plugin");
    }

    public final void setOnCheckedListener(m<? super OChip, ? super Boolean, x> r3) {
        m<? super OChip, ? super Boolean, x> r4 = (m) ZeusTransformUtils.wrapperContextForParams(r3, m.class, "com.obric.aiagent.plugin");
        o.e(r4, "l");
        this.onCheckedListener = r4;
    }

    public final void setToggleable(boolean r1) {
        this.toggleable = r1;
    }

    @Override // android.view.View
    public boolean performClick() {
        if (this.toggleable == false) goto L6;
        setOn(!isOn());
    L6:
        return super.performClick();
    }

    @Override // android.view.View
    public void setMinimumWidth(int r1) {
        super.setMinimumWidth(r1);
        this.chipContainer.setMinimumWidth(r1);
    }

    @Override // android.view.View
    public void setMinimumHeight(int r1) {
        super.setMinimumHeight(r1);
        this.chipContainer.setMinimumHeight(r1);
    }
}
