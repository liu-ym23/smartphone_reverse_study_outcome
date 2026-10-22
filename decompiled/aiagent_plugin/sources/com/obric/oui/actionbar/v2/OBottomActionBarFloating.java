package com.obric.oui.actionbar.v2;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.oui.blur.BlurToken;
import com.obric.oui.material.c;
import com.obric.oui.material.g;
import com.obric.oui.material.k;
import com.obric.oui.material.l;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.h.b.p;
import d.x;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: OBottomActionBarFloating.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class OBottomActionBarFloating extends FrameLayout implements com.obric.oui.material.b, g {
    public static final b Companion = null;
    public static final String TAG = "OBottomActionBarFloating";
    private final int BOTTOM_ACTION_PADDING_BOTTOM;
    private final int BOTTOM_ACTION_PADDING_BOTTOM_WITH_THREE_BTN_MODE;
    private ViewGroup actionGroup;
    private WeakReference<View> backdropTarget;
    private float backgroundBlurRadius;
    private LinearLayout centerContainer;
    private int defaultPaddingBottom;
    private final boolean enableBackDropTarget;
    private final com.obric.oui.window.floating.a floatingWindowHelper;
    private boolean isBackdropView;
    private LinearLayout leftContainer;
    private final c maskMaterialConfig;
    private int materialSrcType;
    private LinearLayout rightContainer;
    private ViewGroup rootView;

    /* JADX INFO: compiled from: OBottomActionBarFloating.kt */
    static final class a extends p implements d.h.a.b<com.obric.oui.view.b, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OBottomActionBarFloating f33936a;

        a(OBottomActionBarFloating r1) {
            this.f33936a = r1;
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ x invoke(com.obric.oui.view.b r3) {
            a((com.obric.oui.view.b) ZeusTransformUtils.preCheckCast(r3, com.obric.oui.view.b.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        }

        public final void a(com.obric.oui.view.b r2) {
            o.e(r2, "rect");
            this.f33936a.updateLayoutForInsetBottom(r2.f36824e);
        }
    }

    /* JADX INFO: compiled from: OBottomActionBarFloating.kt */
    public static final class b {
        public /* synthetic */ b(h r1) {
            this();
        }

        private b() {
        }
    }

    static {
        Companion = new b(null);
    }

    public OBottomActionBarFloating(Context r9) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        this(r1, null, 0, 0, false, 30, null);
    }

    public OBottomActionBarFloating(Context r11, AttributeSet r12) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r12, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, 0, 0, false, 28, null);
    }

    public OBottomActionBarFloating(Context r11, AttributeSet r12, int r13) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r12, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, r13, 0, false, 24, null);
    }

    public OBottomActionBarFloating(Context r11, AttributeSet r12, int r13, int r14) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r12, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, r13, r14, false, 16, null);
    }

    public /* synthetic */ OBottomActionBarFloating(Context r4, AttributeSet r5, int r6, int r7, boolean r8, int r9, h r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r12 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r9 & 2) == 0) goto L5;
        r12 = null;
    L5:
        AttributeSet r13 = r12;
        int r0 = 0;
        if ((r9 & 4) == 0) goto L8;
        int r1 = 0;
    L10:
        if ((r9 & 8) != 0) goto L14;
        r0 = r7;
    L14:
        if ((r9 & 16) == 0) goto L16;
        r8 = true;
    L16:
        this(r11, r13, r1, r0, r8);
        return;
    L8:
        r1 = r6;
        goto L10
    }

    public OBottomActionBarFloating(Context r28, AttributeSet r29, int r30, int r31, boolean r32) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r28, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r3 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r29, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        super(r1, r3, r30, r31);
        this.BOTTOM_ACTION_PADDING_BOTTOM = 24;
        this.BOTTOM_ACTION_PADDING_BOTTOM_WITH_THREE_BTN_MODE = 40;
        this.isBackdropView = true;
        this.materialSrcType = 2;
        this.enableBackDropTarget = r32;
        com.obric.oui.window.floating.a r6 = new com.obric.oui.window.floating.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"));
        this.floatingWindowHelper = r6;
        c r7 = new c(null, null, l.a(ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.array.oui_bottom_actionbar_blur_colors, "array", "oui_bottom_actionbar_blur_colors"), ZeusTransformUtils.mapRes(R.array.oui_bottom_actionbar_blur_blend_modes, "array", "oui_bottom_actionbar_blur_blend_modes")), null, null, null, new com.obric.oui.blur.a(BlurToken.Blur_Progress_Thin, 2, 0.0f, 6, 0.0f, 20, null), null, null, null, 955, null);
        this.maskMaterialConfig = r7;
        this.backgroundBlurRadius = BlurToken.Blur_Progress_Thin;
        boolean r8 = false;
        setClipChildren(false);
        setClipToPadding(false);
        this.defaultPaddingBottom = getPaddingBottom();
        FrameLayout.inflate(r1, ZeusTransformUtils.mapRes(R.layout.o_widget_bottom_action_bar_v2_floating, "layout", "o_widget_bottom_action_bar_v2_floating"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.aiagent.plugin"));
        View r9 = findViewById(ZeusTransformUtils.mapRes(R.id.bottom_action_bar_root, DbHelper.COL_ID, "bottom_action_bar_root"));
        o.c(r9, "findViewById(R.id.bottom_action_bar_root)");
        this.rootView = (ViewGroup) ZeusTransformUtils.preCheckCast(r9, ViewGroup.class, "com.obric.aiagent.plugin");
        View r10 = findViewById(ZeusTransformUtils.mapRes(R.id.action_bar_left_container, DbHelper.COL_ID, "action_bar_left_container"));
        o.c(r10, "findViewById(R.id.action_bar_left_container)");
        this.leftContainer = (LinearLayout) ZeusTransformUtils.preCheckCast(r10, LinearLayout.class, "com.obric.aiagent.plugin");
        View r11 = findViewById(ZeusTransformUtils.mapRes(R.id.action_bar_center_container, DbHelper.COL_ID, "action_bar_center_container"));
        o.c(r11, "findViewById(R.id.action_bar_center_container)");
        this.centerContainer = (LinearLayout) ZeusTransformUtils.preCheckCast(r11, LinearLayout.class, "com.obric.aiagent.plugin");
        View r12 = findViewById(ZeusTransformUtils.mapRes(R.id.action_bar_right_container, DbHelper.COL_ID, "action_bar_right_container"));
        o.c(r12, "findViewById(R.id.action_bar_right_container)");
        this.rightContainer = (LinearLayout) ZeusTransformUtils.preCheckCast(r12, LinearLayout.class, "com.obric.aiagent.plugin");
        int[] r13 = R.styleable.OBottomActionBar;
        o.c(r13, "OBottomActionBar");
        TypedArray r2 = r1.obtainStyledAttributes(r3, r13, 0, 0);
        o.c(r2, "obtainStyledAttributes(s…efStyleAttr, defStyleRes)");
        this.materialSrcType = r2.getInt(ZeusTransformUtils.mapRes(R.styleable.OBottomActionBar_oui_widgetMaterialSrcType, "styleable", "OBottomActionBar_oui_widgetMaterialSrcType"), 2);
        if (r2.hasValue(ZeusTransformUtils.mapRes(R.styleable.OBottomActionBar_oui_widgetBlurColors, "styleable", "OBottomActionBar_oui_widgetBlurColors")) == false) goto L10;
        if (r2.hasValue(ZeusTransformUtils.mapRes(R.styleable.OBottomActionBar_oui_widgetBlurBlendModes, "styleable", "OBottomActionBar_oui_widgetBlurBlendModes")) == false) goto L10;
        r7.a(l.a(ZeusTransformUtils.getResources(r2, "com.obric.aiagent.plugin"), r2.getResourceId(ZeusTransformUtils.mapRes(R.styleable.OBottomActionBar_oui_widgetBlurColors, "styleable", "OBottomActionBar_oui_widgetBlurColors"), ZeusTransformUtils.mapRes(R.array.oui_bottom_actionbar_blur_colors, "array", "oui_bottom_actionbar_blur_colors")), r2.getResourceId(ZeusTransformUtils.mapRes(R.styleable.OBottomActionBar_oui_widgetBlurBlendModes, "styleable", "OBottomActionBar_oui_widgetBlurBlendModes"), ZeusTransformUtils.mapRes(R.array.oui_bottom_actionbar_blur_blend_modes, "array", "oui_bottom_actionbar_blur_blend_modes"))));
        if (r7.c() != null) goto L10;
        com.obric.oui.d.a.b.e(TAG, "init get widget blur colors or modes error");
    L10:
        if (r2.hasValue(ZeusTransformUtils.mapRes(R.styleable.OBottomActionBar_oui_widgetBlurRadius, "styleable", "OBottomActionBar_oui_widgetBlurRadius")) == false) goto L13;
        this.backgroundBlurRadius = r2.getFloat(ZeusTransformUtils.mapRes(R.styleable.OBottomActionBar_oui_widgetBlurRadius, "styleable", "OBottomActionBar_oui_widgetBlurRadius"), BlurToken.Blur_Progress_Thin);
    L13:
        if (r2.hasValue(ZeusTransformUtils.mapRes(R.styleable.OBottomActionBar_oui_bottomActionBarType, "styleable", "OBottomActionBar_oui_bottomActionBarType")) == false) goto L18;
        boolean r4 = true;
        if (r2.getInt(ZeusTransformUtils.mapRes(R.styleable.OBottomActionBar_oui_bottomActionBarType, "styleable", "OBottomActionBar_oui_bottomActionBarType"), 0) != 1) goto L17;
        r8 = true;
    L17:
        r6.a(r8);
    L19:
        r6.a(r2.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OBottomActionBar_oui_widgetFitInsetBottom, "styleable", "OBottomActionBar_oui_widgetFitInsetBottom"), r4), (d.h.a.b) ZeusTransformUtils.preCheckCast(new a(this), d.h.a.b.class, "com.obric.aiagent.plugin"));
        r2.recycle();
        setBackgroundBlurRadius(this.backgroundBlurRadius);
        setDefaultBackdropTargetForChild();
        r6.a(81);
        return;
    L18:
        r4 = true;
        goto L19
    }

    public final int getBOTTOM_ACTION_PADDING_BOTTOM() {
        return this.BOTTOM_ACTION_PADDING_BOTTOM;
    }

    public final int getBOTTOM_ACTION_PADDING_BOTTOM_WITH_THREE_BTN_MODE() {
        return this.BOTTOM_ACTION_PADDING_BOTTOM_WITH_THREE_BTN_MODE;
    }

    public final void updateLayoutForInsetBottom(int r7) {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r0, "context");
        if (com.obric.oui.window.a.f(r0) == true) goto L7;
        if (r7 <= 0) goto L7;
        int r1 = this.BOTTOM_ACTION_PADDING_BOTTOM_WITH_THREE_BTN_MODE;
    L8:
        setPaddingRelative(getPaddingLeft(), getPaddingTop(), getPaddingRight(), Math.max(r7, com.obric.oui.common.util.g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), r1)));
        return;
    L7:
        r1 = this.BOTTOM_ACTION_PADDING_BOTTOM;
        goto L8
    }

    public final ViewGroup getActionGroup() {
        return this.actionGroup;
    }

    public final void setSingleGroup(ViewGroup r4, int r5) {
        o.e(r4, "group");
        resetContainers();
        if (r5 != 1) goto L5;
    L17:
        this.centerContainer.addView((View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.aiagent.plugin"));
        this.centerContainer.setVisibility(0);
    L18:
        this.actionGroup = r4;
        setDefaultBackdropTargetForChild();
        if (this.materialSrcType != (-1)) goto L21;
        return;
    L21:
        if (ZeusTransformUtils.instanceOf(this.actionGroup, g.class) == false) goto L25;
        ViewGroup r6 = this.actionGroup;
        Objects.requireNonNull(r6, "null cannot be cast to non-null type com.obric.oui.material.MaterialOwner");
        ((g) ZeusTransformUtils.preCheckCast(r6, g.class, "com.obric.aiagent.plugin")).updateBackdropSrcType(this.materialSrcType);
        return;
    L25:
        return;
    L5:
        if (r5 != 3) goto L7;
    L16:
        this.leftContainer.addView((View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.aiagent.plugin"));
        this.leftContainer.setVisibility(0);
        goto L18
    L7:
        if (r5 != 5) goto L9;
    L15:
        this.rightContainer.addView((View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.aiagent.plugin"));
        this.rightContainer.setVisibility(0);
        goto L18
    L9:
        if (r5 == 17) goto L17;
        if (r5 == 8388611) goto L16;
        if (r5 == 8388613) goto L15;
        goto L15
    }

    public final void setButtons(List<? extends View> r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
        o.e(r8, "buttons");
        resetContainers();
        if (r8.isEmpty() == false) goto L6;
        return;
    L6:
        if (r8.size() != 1) goto L9;
        this.centerContainer.addView((View) ZeusTransformUtils.preCheckCast(r8.get(0), View.class, "com.obric.aiagent.plugin"));
        this.centerContainer.setVisibility(0);
    L11:
        Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L13:
        if (r9.hasNext() == false) goto L22;
        View r0 = (View) ZeusTransformUtils.preCheckCast(r9.next(), View.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r0, g.class) == false) goto L13;
        if (this.enableBackDropTarget == false) goto L20;
        ((g) ZeusTransformUtils.preCheckCast(r0, g.class, "com.obric.aiagent.plugin")).setBackdropTarget(getDefaultTargetView());
    L20:
        if (this.materialSrcType == (-1)) goto L13;
        ((g) ZeusTransformUtils.preCheckCast(r0, g.class, "com.obric.aiagent.plugin")).updateBackdropSrcType(this.materialSrcType);
        goto L13
    L22:
        return;
    L9:
        if (r8.size() < 2) goto L11;
        this.leftContainer.addView((View) ZeusTransformUtils.preCheckCast(r8.get(0), View.class, "com.obric.aiagent.plugin"));
        this.leftContainer.setVisibility(0);
        this.rightContainer.addView((View) ZeusTransformUtils.preCheckCast(r8.get(1), View.class, "com.obric.aiagent.plugin"));
        this.rightContainer.setVisibility(0);
        goto L11
    }

    public final void setMixed(View r4, ViewGroup r5, boolean r6) {
        o.e(r4, "button");
        o.e(r5, "group");
        resetContainers();
        if (r6 == false) goto L5;
        this.leftContainer.addView(r4);
        this.leftContainer.setVisibility(0);
        this.rightContainer.addView((View) ZeusTransformUtils.preCheckCast(r5, View.class, "com.obric.aiagent.plugin"));
        this.rightContainer.setVisibility(0);
    L6:
        this.actionGroup = r5;
        return;
    L5:
        this.leftContainer.addView((View) ZeusTransformUtils.preCheckCast(r5, View.class, "com.obric.aiagent.plugin"));
        this.leftContainer.setVisibility(0);
        this.rightContainer.addView(r4);
        this.rightContainer.setVisibility(0);
        goto L6
    }

    private final void resetContainers() {
        this.leftContainer.removeAllViews();
        this.centerContainer.removeAllViews();
        this.rightContainer.removeAllViews();
        this.leftContainer.setVisibility(8);
        this.centerContainer.setVisibility(8);
        this.rightContainer.setVisibility(8);
        this.actionGroup = null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.floatingWindowHelper.b();
    }

    private final void setBackgroundBlurRadius(float r4) {
        setOutlineProvider((ViewOutlineProvider) ZeusTransformUtils.preCheckCast(new AnonymousClass1(), ViewOutlineProvider.class, "com.obric.aiagent.plugin"));
        int r0 = this.materialSrcType;
        if (r0 != (-1)) goto L6;
        r0 = 2;
    L6:
        com.obric.oui.blur.a r1 = this.maskMaterialConfig.g();
        if (r1 == null) goto L11;
        r1.a(r4);
        this.floatingWindowHelper.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), this.maskMaterialConfig, r0);
        return;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        if (this.materialSrcType == (-1)) goto L6;
        k.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), this.materialSrcType);
        com.obric.oui.material.h.a((ViewGroup[]) ZeusTransformUtils.preCheckCast(new LinearLayout[]{this.leftContainer, this.centerContainer, this.rightContainer}, ViewGroup[].class, "com.obric.aiagent.plugin"), this.materialSrcType);
        return;
    }

    @Override // com.obric.oui.material.b
    public void applyMaskMaterial(boolean r4) {
        if (this.materialSrcType == (-1)) goto L6;
        com.obric.oui.material.h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), r4, this.materialSrcType);
        return;
    L6:
        com.obric.oui.material.h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), r4, this.isBackdropView);
    }

    @Override // com.obric.oui.material.g
    public void applyContentMaterial(boolean r4) {
        com.obric.oui.material.h.a((ViewGroup[]) ZeusTransformUtils.preCheckCast(new LinearLayout[]{this.leftContainer, this.centerContainer, this.rightContainer}, ViewGroup[].class, "com.obric.aiagent.plugin"), r4);
    }

    private final View getDefaultTargetView() {
        WeakReference<View> r0 = this.backdropTarget;
        if (r0 == null) goto L7;
        o.a(r0);
        return (View) ZeusTransformUtils.preCheckCast(r0.get(), View.class, "com.obric.aiagent.plugin");
    L7:
        if (l.c() <= 1) goto L11;
        return (View) ZeusTransformUtils.preCheckCast(this.rootView, View.class, "com.obric.aiagent.plugin");
    L11:
        return (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin");
    }

    private final void setDefaultBackdropTargetForChild() {
        if (this.enableBackDropTarget == true) goto L5;
        return;
    L5:
        View r0 = getDefaultTargetView();
        com.obric.oui.material.h.a((ViewGroup[]) ZeusTransformUtils.preCheckCast(new LinearLayout[]{this.leftContainer, this.centerContainer, this.rightContainer}, ViewGroup[].class, "com.obric.aiagent.plugin"), r0);
        if (ZeusTransformUtils.instanceOf(this.actionGroup, g.class) == false) goto L9;
        ViewGroup r4 = this.actionGroup;
        Objects.requireNonNull(r4, "null cannot be cast to non-null type com.obric.oui.material.MaterialOwner");
        ((g) ZeusTransformUtils.preCheckCast(r4, g.class, "com.obric.aiagent.plugin")).setBackdropTarget(r0);
        return;
    }

    @Override // com.obric.oui.material.g
    public void setBackdropTarget(View r4) {
        if (this.enableBackDropTarget == true) goto L5;
        return;
    L5:
        this.backdropTarget = new WeakReference(r4);
        com.obric.oui.material.h.a((ViewGroup[]) ZeusTransformUtils.preCheckCast(new LinearLayout[]{this.leftContainer, this.centerContainer, this.rightContainer}, ViewGroup[].class, "com.obric.aiagent.plugin"), r4);
        if (ZeusTransformUtils.instanceOf(this.actionGroup, g.class) == false) goto L9;
        ViewGroup r3 = this.actionGroup;
        Objects.requireNonNull(r3, "null cannot be cast to non-null type com.obric.oui.material.MaterialOwner");
        ((g) ZeusTransformUtils.preCheckCast(r3, g.class, "com.obric.aiagent.plugin")).setBackdropTarget(r4);
        return;
    }

    @Override // com.obric.oui.material.g
    public void updateBackdropTargetType(boolean r5) {
        if (this.isBackdropView == r5) goto L14;
        this.isBackdropView = r5;
        if (this.materialSrcType == (-1)) goto L8;
        return;
    L8:
        if (this.floatingWindowHelper.a() == true) goto L10;
        k.c((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), this.isBackdropView);
    L10:
        com.obric.oui.material.h.b((ViewGroup[]) ZeusTransformUtils.preCheckCast(new LinearLayout[]{this.leftContainer, this.centerContainer, this.rightContainer}, ViewGroup[].class, "com.obric.aiagent.plugin"), r5);
        if (ZeusTransformUtils.instanceOf(this.actionGroup, g.class) == false) goto L15;
        ViewGroup r6 = this.actionGroup;
        Objects.requireNonNull(r6, "null cannot be cast to non-null type com.obric.oui.material.MaterialOwner");
        ((g) ZeusTransformUtils.preCheckCast(r6, g.class, "com.obric.aiagent.plugin")).updateBackdropTargetType(this.isBackdropView);
        return;
    L15:
        return;
    }

    @Override // com.obric.oui.material.g
    public void updateBackdropSrcType(int r5) {
        this.materialSrcType = r5;
        k.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), r5);
        com.obric.oui.material.h.a((ViewGroup[]) ZeusTransformUtils.preCheckCast(new LinearLayout[]{this.leftContainer, this.centerContainer, this.rightContainer}, ViewGroup[].class, "com.obric.aiagent.plugin"), this.materialSrcType);
        if (ZeusTransformUtils.instanceOf(this.actionGroup, g.class) == false) goto L6;
        ViewGroup r4 = this.actionGroup;
        Objects.requireNonNull(r4, "null cannot be cast to non-null type com.obric.oui.material.MaterialOwner");
        ((g) ZeusTransformUtils.preCheckCast(r4, g.class, "com.obric.aiagent.plugin")).updateBackdropSrcType(r5);
        return;
    }

    private final boolean isDarkTheme() {
        if ((ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getConfiguration().uiMode & 48) != 32) goto L5;
        return true;
    L5:
        return false;
    }
}
