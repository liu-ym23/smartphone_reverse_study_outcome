package com.obric.oui.panel;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.oui.common.util.g;
import com.obric.oui.common.util.k;
import com.obric.oui.dialog.alert.view.RadiusLayout;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: OBasePanelDialog.kt */
/* JADX INFO: loaded from: classes4.dex */
public class OBasePanelDialog extends BottomSheetDialog {
    private boolean adaptNavBarColor;
    private boolean adaptRLSlide;
    private boolean autoSwitchDayNight;
    private boolean backgroundDimEnable;
    private boolean clipTopCorner;
    private Integer collapsedHeight;
    private RadiusLayout contentContainer;
    private boolean disableAutoAdaptHeight;
    private d.h.a.b<? super MotionEvent, Boolean> dispatchTouchEvent;
    private Integer expandedHeight;
    private boolean fitsSystemWindows;
    private boolean fixedHeight;
    private boolean floatHeader;
    private RadiusLayout headerContainer;
    private boolean isExpandable;
    private int maxPanelHeight;
    private Integer navBarColor;
    private d.h.a.a<Boolean> onDialogBackPressCallback;
    private View.OnClickListener outsideClickListener;
    private OBasicPanel.c padCompatConfig;
    private ConstraintLayout panelContainer;
    private com.obric.oui.panel.header.c panelHeader;
    private boolean removeMinHeight;
    private boolean useToneBg;

    private final void compatibleWithPad() {
    }

    public OBasePanelDialog(Context r3, int r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r5, "context");
        super(r5, r4);
        this.maxPanelHeight = -1;
        this.backgroundDimEnable = true;
        this.fitsSystemWindows = true;
        this.clipTopCorner = true;
    }

    public /* synthetic */ OBasePanelDialog(Context r2, int r3, int r4, h r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L5;
        r3 = ZeusTransformUtils.mapRes(R.style.OBasicPanel, "style", "OBasicPanel");
    L5:
        this(r6, r3);
    }

    public final int getMaxPanelHeight() {
        return this.maxPanelHeight;
    }

    public final void setMaxPanelHeight(int r1) {
        this.maxPanelHeight = r1;
    }

    public final boolean getUseToneBg() {
        return this.useToneBg;
    }

    public final void setUseToneBg(boolean r1) {
        this.useToneBg = r1;
    }

    public final boolean isExpandable() {
        return this.isExpandable;
    }

    public final void setExpandable(boolean r1) {
        this.isExpandable = r1;
    }

    public final boolean getFloatHeader() {
        return this.floatHeader;
    }

    public final void setFloatHeader(boolean r1) {
        this.floatHeader = r1;
    }

    public final boolean getBackgroundDimEnable() {
        return this.backgroundDimEnable;
    }

    public final void setBackgroundDimEnable(boolean r1) {
        this.backgroundDimEnable = r1;
    }

    public final boolean getAdaptNavBarColor() {
        return this.adaptNavBarColor;
    }

    public final void setAdaptNavBarColor(boolean r1) {
        this.adaptNavBarColor = r1;
    }

    public final com.obric.oui.panel.header.c getPanelHeader() {
        return this.panelHeader;
    }

    public final void setPanelHeader(com.obric.oui.panel.header.c r1) {
        this.panelHeader = r1;
    }

    public final boolean getAutoSwitchDayNight() {
        return this.autoSwitchDayNight;
    }

    public final void setAutoSwitchDayNight(boolean r1) {
        this.autoSwitchDayNight = r1;
    }

    public final d.h.a.b<MotionEvent, Boolean> getDispatchTouchEvent() {
        return this.dispatchTouchEvent;
    }

    public final void setDispatchTouchEvent(d.h.a.b<? super MotionEvent, Boolean> r3) {
        this.dispatchTouchEvent = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
    }

    public final boolean getRemoveMinHeight() {
        return this.removeMinHeight;
    }

    public final void setRemoveMinHeight(boolean r1) {
        this.removeMinHeight = r1;
    }

    public final boolean getFixedHeight() {
        return this.fixedHeight;
    }

    public final void setFixedHeight(boolean r1) {
        this.fixedHeight = r1;
    }

    public final View.OnClickListener getOutsideClickListener() {
        return this.outsideClickListener;
    }

    public final void setOutsideClickListener(View.OnClickListener r3) {
        this.outsideClickListener = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r3, View.OnClickListener.class, "com.obric.aiagent.plugin");
    }

    public final OBasicPanel.c getPadCompatConfig() {
        return this.padCompatConfig;
    }

    public final void setPadCompatConfig(OBasicPanel.c r1) {
        this.padCompatConfig = r1;
    }

    public final boolean getAdaptRLSlide() {
        return this.adaptRLSlide;
    }

    public final void setAdaptRLSlide(boolean r1) {
        this.adaptRLSlide = r1;
    }

    public final boolean getDisableAutoAdaptHeight() {
        return this.disableAutoAdaptHeight;
    }

    public final void setDisableAutoAdaptHeight(boolean r1) {
        this.disableAutoAdaptHeight = r1;
    }

    public final Integer getCollapsedHeight() {
        return this.collapsedHeight;
    }

    public final void setCollapsedHeight(Integer r1) {
        this.collapsedHeight = r1;
    }

    /* JADX INFO: renamed from: getExpandedHeight, reason: collision with other method in class */
    public final Integer m1111getExpandedHeight() {
        return this.expandedHeight;
    }

    public final void setExpandedHeight(Integer r1) {
        this.expandedHeight = r1;
    }

    public final boolean getFitsSystemWindows() {
        return this.fitsSystemWindows;
    }

    public final void setFitsSystemWindows(boolean r1) {
        this.fitsSystemWindows = r1;
    }

    public final Integer getNavBarColor() {
        return this.navBarColor;
    }

    public final void setNavBarColor(Integer r1) {
        this.navBarColor = r1;
    }

    public final d.h.a.a<Boolean> getOnDialogBackPressCallback() {
        return this.onDialogBackPressCallback;
    }

    public final void setOnDialogBackPressCallback(d.h.a.a<Boolean> r3) {
        this.onDialogBackPressCallback = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
    }

    public final boolean getClipTopCorner() {
        return this.clipTopCorner;
    }

    public final void setClipTopCorner(boolean r1) {
        this.clipTopCorner = r1;
    }

    @Override // com.obric.oui.panel.BottomSheetDialog, androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public void setContentView(View r3) {
        o.e(r3, "view");
        super.setContentView(wrapWithHeader(0, r3, null));
    }

    @Override // com.obric.oui.panel.BottomSheetDialog, androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public void setContentView(int r2) {
        super.setContentView(wrapWithHeader(r2, null, null));
    }

    @Override // com.obric.oui.panel.BottomSheetDialog, androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public void setContentView(View r2, ViewGroup.LayoutParams r3) {
        o.e(r2, "view");
        super.setContentView(wrapWithHeader(0, r2, r3));
    }

    private final void ensureHeaderAndContainer() {
        if (this.panelContainer != null) goto L5;
    L8:
        RadiusLayout r3 = null;
        ConstraintLayout r0 = (ConstraintLayout) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.inflate((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.layout.o_basic_panel, "layout", "o_basic_panel"), null, "com.obric.aiagent.plugin"), ConstraintLayout.class, "com.obric.aiagent.plugin");
        this.panelContainer = r0;
        if (r0 != null) goto L11;
        RadiusLayout r1 = null;
    L12:
        this.headerContainer = r1;
        ConstraintLayout r2 = this.panelContainer;
        if (r2 == null) goto L16;
        r3 = (RadiusLayout) ZeusTransformUtils.preCheckCast(r2.findViewById(ZeusTransformUtils.mapRes(R.id.content_container, DbHelper.COL_ID, "content_container")), RadiusLayout.class, "com.obric.aiagent.plugin");
    L16:
        this.contentContainer = r3;
        return;
    L11:
        r1 = (RadiusLayout) ZeusTransformUtils.preCheckCast(r0.findViewById(ZeusTransformUtils.mapRes(R.id.header_container, DbHelper.COL_ID, "header_container")), RadiusLayout.class, "com.obric.aiagent.plugin");
        goto L12
    L5:
        if (this.headerContainer == null) goto L8;
        if (this.contentContainer == null) goto L8;
    }

    private final View wrapWithHeader(int r4, View r5, ViewGroup.LayoutParams r6) {
        ensureHeaderAndContainer();
        if (r4 == 0) goto L6;
        if (r5 != null) goto L6;
        r5 = ZeusTransformUtils.inflate(getLayoutInflater(), r4, (ViewGroup) ZeusTransformUtils.preCheckCast(this.contentContainer, ViewGroup.class, "com.obric.aiagent.plugin"), false, "com.obric.aiagent.plugin");
    L6:
        RadiusLayout r7 = this.contentContainer;
        if (r7 == null) goto L10;
        r7.removeAllViews();
    L10:
        if (r6 != null) goto L15;
        RadiusLayout r8 = this.contentContainer;
        if (r8 == null) goto L19;
        r8.addView(r5);
    L19:
        initView();
        ConstraintLayout r3 = this.panelContainer;
        o.a(r3);
        return (View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.aiagent.plugin");
    L15:
        RadiusLayout r9 = this.contentContainer;
        if (r9 == null) goto L19;
        r9.addView(r5, r6);
        goto L19
    }

    @Override // com.obric.oui.panel.BottomSheetDialog, androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public void onCreate(Bundle r4) {
        super.onCreate(r4);
        boolean r0 = true;
        getBehavior().b(true);
        getBehavior().p = this.fitsSystemWindows;
        getBehavior().g(!this.disableAutoAdaptHeight);
        if (this.isExpandable == false) goto L5;
        setIs69Expandable(true);
        getBehavior().a(getPeekHeight());
        return;
    L5:
        BottomSheetBehavior<FrameLayout> r5 = getBehavior();
        if (ZeusTransformUtils.instanceOf(this.panelHeader, com.obric.oui.panel.header.b.class) == true) goto L16;
        com.obric.oui.panel.header.c r1 = this.panelHeader;
        if (r1 != null) goto L11;
    L9:
        boolean r2 = false;
    L13:
        if (r2 == true) goto L16;
        r0 = false;
        goto L16
    L11:
        if (r1.b() != true) goto L9;
        r2 = true;
    L16:
        r5.e(r0);
        if (this.maxPanelHeight <= 0) goto L23;
        getBehavior().e(this.maxPanelHeight);
        if (this.fixedHeight == false) goto L24;
        setExpandedHeight(this.maxPanelHeight);
        return;
    L24:
        return;
    }

    private final void initView() {
        if (this.panelHeader != null) goto L5;
        Context r3 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r3, "context");
        this.panelHeader = (com.obric.oui.panel.header.c) ZeusTransformUtils.preCheckCast(new com.obric.oui.panel.header.a(r3, null, null, 6, null), com.obric.oui.panel.header.c.class, "com.obric.aiagent.plugin");
    L5:
        compatibleWithPad();
        if (this.clipTopCorner == false) goto L8;
        FrameLayout r0 = getBottomSheet();
        o.c(r0, "bottomSheet");
        float r1 = g.b((View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.aiagent.plugin"), 20);
    L9:
        RadiusLayout r4 = this.headerContainer;
        if (r4 == null) goto L14;
        r4.setRadius(r1, r1, 0.0f, 0.0f);
    L14:
        if (this.floatHeader == false) goto L19;
        RadiusLayout r5 = this.contentContainer;
        if (r5 == null) goto L19;
        r5.setRadius(r1, r1, 0.0f, 0.0f);
    L19:
        com.obric.oui.panel.header.c r2 = this.panelHeader;
        if (r2 != null) goto L22;
    L21:
        ViewParent r6 = null;
    L27:
        if (ZeusTransformUtils.instanceOf(r6, ViewGroup.class) == false) goto L46;
        com.obric.oui.panel.header.c r7 = this.panelHeader;
        if (r7 != null) goto L31;
    L30:
        ViewParent r8 = null;
    L36:
        if (ZeusTransformUtils.instanceOf(r8, ViewGroup.class) == false) goto L38;
        ViewGroup r9 = (ViewGroup) ZeusTransformUtils.preCheckCast(r8, ViewGroup.class, "com.obric.aiagent.plugin");
    L39:
        if (r9 == null) goto L46;
        com.obric.oui.panel.header.c r10 = this.panelHeader;
        if (r10 != null) goto L44;
        View r11 = null;
    L45:
        r9.removeView(r11);
        goto L46
    L44:
        r11 = r10.a();
        goto L45
    L38:
        r9 = null;
        goto L39
    L31:
        View r12 = r7.a();
        if (r12 == null) goto L30;
        r8 = r12.getParent();
    L46:
        RadiusLayout r13 = this.headerContainer;
        if (r13 == null) goto L55;
        ViewGroup r14 = (ViewGroup) ZeusTransformUtils.preCheckCast(r13, ViewGroup.class, "com.obric.aiagent.plugin");
        com.obric.oui.panel.header.c r15 = this.panelHeader;
        if (r15 != null) goto L52;
        View r16 = null;
    L53:
        k.a(r14, r16);
        goto L55
    L52:
        r16 = r15.a();
    L55:
        if (this.floatHeader == false) goto L67;
        if (this.contentContainer == null) goto L67;
        androidx.constraintlayout.widget.c r17 = new androidx.constraintlayout.widget.c();
        r17.b(this.panelContainer);
        RadiusLayout r18 = this.contentContainer;
        o.a(r18);
        r17.a(r18.getId(), 3);
        RadiusLayout r19 = this.contentContainer;
        o.a(r19);
        r17.a(r19.getId(), 3, 0, 3);
        r17.c(this.panelContainer);
        RadiusLayout r20 = this.headerContainer;
        if (r20 == null) goto L62;
        r20.setBackground(null);
    L62:
        RadiusLayout r21 = this.headerContainer;
        if (r21 == null) goto L67;
        r21.bringToFront();
    L67:
        if (this.backgroundDimEnable == true) goto L73;
        Window r22 = getWindow();
        if (r22 == null) goto L73;
        r22.setDimAmount(0.0f);
    L73:
        if (this.adaptNavBarColor == false) goto L97;
        Integer r23 = this.navBarColor;
        if (r23 == null) goto L77;
        int r24 = ((Number) ZeusTransformUtils.preCheckCast(r23, Number.class, "com.obric.aiagent.plugin")).intValue();
        Window r25 = getWindow();
        if (r25 == null) goto L100;
        r25.setNavigationBarColor(r24);
        return;
    L100:
        return;
    L77:
        if (this.autoSwitchDayNight == false) goto L84;
        if (this.useToneBg == false) goto L81;
        int r26 = R.color.BGPanelTone;
        String r27 = "BGPanelTone";
    L82:
        int r28 = ZeusTransformUtils.mapRes(r26, "color", r27);
    L88:
        Window r29 = getWindow();
        if (r29 == null) goto L99;
        r29.setNavigationBarColor(androidx.core.content.a.c((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r28));
        return;
    L99:
        return;
    L81:
        r26 = R.color.BGPanelTint;
        r27 = "BGPanelTint";
        goto L82
    L84:
        if (this.useToneBg == false) goto L86;
        int r30 = R.color.ConstBGPanelReverse;
        String r31 = "ConstBGPanelReverse";
    L87:
        r28 = ZeusTransformUtils.mapRes(r30, "color", r31);
        goto L88
    L86:
        r30 = R.color.ConstTextInverse;
        r31 = "ConstTextInverse";
        goto L87
    L97:
        return;
    L22:
        View r32 = r2.a();
        if (r32 == null) goto L21;
        r6 = r32.getParent();
        goto L27
    L8:
        r1 = 0.0f;
        goto L9
    }

    @Override // com.obric.oui.panel.BottomSheetDialog, androidx.activity.ComponentDialog, android.app.Dialog
    public void onStart() {
        super.onStart();
        if (this.removeMinHeight == false) goto L6;
        removeMinHeight();
    L6:
        if (this.clipTopCorner == false) goto L8;
        FrameLayout r0 = getBottomSheet();
        o.c(r0, "bottomSheet");
        float r1 = g.b((View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.aiagent.plugin"), 20);
    L9:
        GradientDrawable r3 = new GradientDrawable();
        r3.setShape(0);
        r3.setCornerRadii(new float[]{r1, r1, r1, r1, 0.0f, 0.0f, 0.0f, 0.0f});
        r3.setColor(getBgColor());
        FrameLayout r2 = getBottomSheet();
        if (r2 == null) goto L14;
        r2.setBackground((Drawable) ZeusTransformUtils.preCheckCast(r3, Drawable.class, "com.obric.aiagent.plugin"));
    L14:
        if (this.isExpandable == false) goto L16;
        setExpandedHeight(getExpandedHeight());
    L16:
        setFitsSystemWindow(this.fitsSystemWindows);
        getBehavior().d(this.isExpandable);
        if (this.outsideClickListener == null) goto L22;
        View r4 = findViewById(ZeusTransformUtils.mapRes(R.id.touch_outside, DbHelper.COL_ID, "touch_outside"));
        if (r4 == null) goto L22;
        r4.setOnClickListener(this.outsideClickListener);
    L22:
        adaptPortraitRLSlide(this.adaptRLSlide);
        return;
    L8:
        r1 = 0.0f;
        goto L9
    }

    public final int getBgColor() {
        if (this.autoSwitchDayNight == false) goto L10;
        if (this.useToneBg == false) goto L7;
        int r0 = R.color.BGPanelTone;
        String r2 = "BGPanelTone";
    L8:
        int r1 = ZeusTransformUtils.mapRes(r0, "color", r2);
    L15:
        return androidx.core.content.a.c((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r1);
    L7:
        r0 = R.color.BGPanelTint;
        r2 = "BGPanelTint";
        goto L8
    L10:
        if (this.useToneBg == false) goto L12;
        int r3 = R.color.ConstBGPanelReverse;
        String r4 = "ConstBGPanelReverse";
    L13:
        r1 = ZeusTransformUtils.mapRes(r3, "color", r4);
        goto L15
    L12:
        r3 = R.color.ConstTextInverse;
        r4 = "ConstTextInverse";
        goto L13
    }

    public final void setExpandedHeight(int r4) {
        FrameLayout r3 = (FrameLayout) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.design_bottom_sheet, DbHelper.COL_ID, "design_bottom_sheet")), FrameLayout.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L6;
        r3.getLayoutParams().height = r4;
        return;
    }

    public final void removeMinHeight() {
        FrameLayout r3 = (FrameLayout) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.design_bottom_sheet, DbHelper.COL_ID, "design_bottom_sheet")), FrameLayout.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L6;
        r3.setMinimumHeight(0);
        return;
    }

    public final void hideHeader() {
        RadiusLayout r2 = this.headerContainer;
        if (r2 == null) goto L7;
        k.b((View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.aiagent.plugin"));
        return;
    }

    private final int getPeekHeight() {
        Integer r0 = this.collapsedHeight;
        if (r0 == null) goto L6;
        o.a(r0);
        return r0.intValue();
    L6:
        Resources r1 = ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
        if (r1 != null) goto L9;
        Integer r2 = null;
    L10:
        boolean r3 = false;
        if (r2 == null) goto L21;
        if (r2.intValue() <= 0) goto L21;
        Resources r4 = ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
        if (r4 != null) goto L17;
        boolean r5 = false;
    L18:
        if (r5 == false) goto L21;
        r3 = true;
        goto L21
    L17:
        r5 = r4.getBoolean(r2.intValue());
    L21:
        if (r3 == false) goto L24;
        Context r6 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r6, "context");
        return (int) (((double) g.b(r6)) * 0.65d);
    L24:
        Context r7 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r7, "context");
        return (int) (((double) g.b(r7)) * 0.6d);
    L9:
        r2 = Integer.valueOf(ZeusTransformUtils.getIdentifier(r1, "config_showNavigationBar", "bool", "android", "com.obric.aiagent.plugin"));
        goto L10
    }

    private final int getExpandedHeight() {
        Integer r0 = this.expandedHeight;
        if (r0 == null) goto L6;
        o.a(r0);
        return r0.intValue();
    L6:
        Context r4 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r4, "context");
        return (int) (((double) g.b(r4)) * 0.9d);
    }

    @Override // androidx.activity.ComponentDialog, android.app.Dialog
    public void onBackPressed() {
        d.h.a.a<Boolean> r0 = this.onDialogBackPressCallback;
        boolean r1 = false;
        if (r0 != null) goto L6;
    L8:
        if (r1 == false) goto L10;
        return;
    L10:
        super.onBackPressed();
        return;
    L6:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r0.invoke(), Boolean.class, "com.obric.aiagent.plugin")).booleanValue() != true) goto L8;
        r1 = true;
        goto L8
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent r4) {
        o.e(r4, "ev");
        d.h.a.b<? super MotionEvent, Boolean> r0 = this.dispatchTouchEvent;
        if (r0 == null) goto L10;
        if (((Boolean) ZeusTransformUtils.preCheckCast(r0.invoke(r4), Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == false) goto L10;
        return true;
    L10:
        return super.dispatchTouchEvent(r4);
    }

    public final ConstraintLayout getPanelContainer() {
        return this.panelContainer;
    }

    public final RadiusLayout getContentContainer() {
        return this.contentContainer;
    }

    public final RadiusLayout getHeaderContainer() {
        return this.headerContainer;
    }

    public final void setRadius(float r17, float r18, float r19, float r20) {
        RadiusLayout r5 = this.headerContainer;
        if (r5 == null) goto L7;
        r5.setRadius(r17, r18, r19, r20);
    L7:
        if (this.floatHeader == false) goto L12;
        RadiusLayout r6 = this.contentContainer;
        if (r6 == null) goto L12;
        r6.setRadius(r17, r18, r19, r20);
    L12:
        FrameLayout r7 = getBottomSheet();
        if (r7 != null) goto L15;
        Drawable r8 = null;
    L17:
        if (ZeusTransformUtils.instanceOf(r8, GradientDrawable.class) == false) goto L19;
        ((GradientDrawable) ZeusTransformUtils.preCheckCast(r8, GradientDrawable.class, "com.obric.aiagent.plugin")).setCornerRadii(new float[]{r17, r17, r18, r18, r19, r19, r20, r20});
        return;
    L19:
        if (r8 != null) goto L26;
        FrameLayout r0 = getBottomSheet();
        if (r0 == null) goto L27;
        GradientDrawable r9 = new GradientDrawable();
        r9.setCornerRadii(new float[]{r17, r17, r18, r18, r19, r19, r20, r20});
        r0.setBackground((Drawable) ZeusTransformUtils.preCheckCast(r9, Drawable.class, "com.obric.aiagent.plugin"));
        return;
    L27:
        return;
    L26:
        return;
    L15:
        r8 = r7.getBackground();
        goto L17
    }

    public final void setBgColor(int r4) {
        FrameLayout r0 = getBottomSheet();
        if (r0 != null) goto L5;
        Drawable r1 = null;
    L7:
        if (ZeusTransformUtils.instanceOf(r1, GradientDrawable.class) == false) goto L9;
        ((GradientDrawable) ZeusTransformUtils.preCheckCast(r1, GradientDrawable.class, "com.obric.aiagent.plugin")).setColor(r4);
    L10:
        FrameLayout r2 = getBottomSheet();
        if (r2 == null) goto L15;
        r2.setBackground(r1);
    L15:
        if (this.adaptNavBarColor == true) goto L17;
        return;
    L17:
        if (this.navBarColor != null) goto L24;
        Window r3 = getWindow();
        if (r3 == null) goto L25;
        r3.setNavigationBarColor(r4);
        return;
    L25:
        return;
    L24:
        return;
    L9:
        GradientDrawable r5 = new GradientDrawable();
        r5.setColor(r4);
        r1 = (Drawable) ZeusTransformUtils.preCheckCast(r5, Drawable.class, "com.obric.aiagent.plugin");
        goto L10
    L5:
        r1 = r0.getBackground();
        goto L7
    }

    public final void setFitsSystemWindow(boolean r4) {
        FrameLayout r3 = (FrameLayout) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.container, DbHelper.COL_ID, "container")), FrameLayout.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L7;
        r3.setFitsSystemWindows(r4);
        return;
    }
}
