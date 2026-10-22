package com.obric.oui.segmentedtab;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.oui.blur.BlurToken;
import com.obric.oui.layout.OUIFrameLayout;
import com.obric.oui.material.c;
import com.obric.oui.material.g;
import com.obric.oui.material.k;
import com.obric.oui.material.l;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.h.b.p;
import d.l.n;
import d.x;

/* JADX INFO: compiled from: OBottomNavigationBar.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class OBottomNavigationBar extends OUIFrameLayout implements com.obric.oui.material.b, g {
    public static final b Companion = null;
    public static final String TAG = "OBottomNavigationBar";
    private final OBottomNavActionBar bottomNavBar;
    private final com.obric.oui.window.floating.a floatingWindowHelper;
    private boolean isBackdropView;
    private final c maskMaterialConfig;
    private final View maskView;
    private int materialSrcType;
    private final ViewGroup rootView;

    /* JADX INFO: compiled from: OBottomNavigationBar.kt */
    static final class a extends p implements d.h.a.b<com.obric.oui.view.b, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OBottomNavigationBar f36146a;

        a(OBottomNavigationBar r1) {
            this.f36146a = r1;
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ x invoke(com.obric.oui.view.b r3) {
            a((com.obric.oui.view.b) ZeusTransformUtils.preCheckCast(r3, com.obric.oui.view.b.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        }

        public final void a(com.obric.oui.view.b r2) {
            o.e(r2, "rect");
            this.f36146a.updateLayoutForInsetBottom(r2.f36824e);
        }
    }

    /* JADX INFO: compiled from: OBottomNavigationBar.kt */
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

    public OBottomNavigationBar(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public OBottomNavigationBar(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public final void setDefaultMaskBackground() {
    }

    public final void setMaskBackground(Drawable r1) {
    }

    public /* synthetic */ OBottomNavigationBar(Context r2, AttributeSet r3, int r4, int r5, h r6) {
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

    public OBottomNavigationBar(Context r25, AttributeSet r26, int r27) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r25, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r10 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r26, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r9, "context");
        super(r9, r10, r27, null, 8, null);
        this.isBackdropView = true;
        this.materialSrcType = -1;
        com.obric.oui.window.floating.a r2 = new com.obric.oui.window.floating.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"));
        this.floatingWindowHelper = r2;
        c r3 = new c(null, null, l.a(ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.array.oui_bottom_navbar_blend_colors, "array", "oui_bottom_navbar_blend_colors")), null, null, null, new com.obric.oui.blur.a(BlurToken.Blur_Progress_Thin, 2, 0.0f, 6, 0.0f, 20, null), null, null, null, 955, null);
        this.maskMaterialConfig = r3;
        boolean r4 = false;
        setClipToPadding(false);
        setClipChildren(false);
        setOutlineProvider((ViewOutlineProvider) ZeusTransformUtils.preCheckCast(new AnonymousClass1(), ViewOutlineProvider.class, "com.obric.aiagent.plugin"));
        setChangeAlphaWhenPress(false);
        setChangeAlphaWhenDisable(false);
        setChangeAlphaWhenSelected(false);
        ZeusTransformUtils.inflate(LayoutInflater.from(r9), ZeusTransformUtils.mapRes(R.layout.layout_custom_bottom_navigation, "layout", "layout_custom_bottom_navigation"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.aiagent.plugin"), true, "com.obric.aiagent.plugin");
        View r5 = findViewById(ZeusTransformUtils.mapRes(R.id.bottom_nav_bar_container, DbHelper.COL_ID, "bottom_nav_bar_container"));
        o.c(r5, "findViewById(R.id.bottom_nav_bar_container)");
        ViewGroup r6 = (ViewGroup) ZeusTransformUtils.preCheckCast(r5, ViewGroup.class, "com.obric.aiagent.plugin");
        this.rootView = r6;
        ((OUIFrameLayout) ZeusTransformUtils.preCheckCast(r6, OUIFrameLayout.class, "com.obric.aiagent.plugin")).setChangeAlphaWhenPress(false);
        ((OUIFrameLayout) ZeusTransformUtils.preCheckCast(r6, OUIFrameLayout.class, "com.obric.aiagent.plugin")).setChangeAlphaWhenDisable(false);
        ((OUIFrameLayout) ZeusTransformUtils.preCheckCast(r6, OUIFrameLayout.class, "com.obric.aiagent.plugin")).setChangeAlphaWhenSelected(false);
        View r7 = findViewById(ZeusTransformUtils.mapRes(R.id.bottom_nav_bar, DbHelper.COL_ID, "bottom_nav_bar"));
        o.c(r7, "findViewById(R.id.bottom_nav_bar)");
        OBottomNavActionBar r8 = (OBottomNavActionBar) ZeusTransformUtils.preCheckCast(r7, OBottomNavActionBar.class, "com.obric.aiagent.plugin");
        this.bottomNavBar = r8;
        r8.obtainAttributes(r9, r10);
        ((OUIFrameLayout) ZeusTransformUtils.preCheckCast(r8, OUIFrameLayout.class, "com.obric.aiagent.plugin")).setChangeAlphaWhenPress(false);
        r8.setChangeAlphaWhenDisable(false);
        r8.setChangeAlphaWhenSelected(false);
        View r11 = findViewById(ZeusTransformUtils.mapRes(R.id.mask_view, DbHelper.COL_ID, "mask_view"));
        o.c(r11, "findViewById(R.id.mask_view)");
        this.maskView = r11;
        int[] r12 = R.styleable.OTabLayout;
        o.c(r12, "OTabLayout");
        TypedArray r13 = r9.obtainStyledAttributes(r10, r12, 0, 0);
        o.c(r13, "obtainStyledAttributes(s…efStyleAttr, defStyleRes)");
        this.materialSrcType = r13.getInt(ZeusTransformUtils.mapRes(R.styleable.OTabLayout_oui_widgetMaterialSrcType, "styleable", "OTabLayout_oui_widgetMaterialSrcType"), -1);
        if (r13.hasValue(ZeusTransformUtils.mapRes(R.styleable.OTabLayout_oui_widgetBlurColors, "styleable", "OTabLayout_oui_widgetBlurColors")) == true) goto L5;
    L9:
        float r1 = r13.getFloat(ZeusTransformUtils.mapRes(R.styleable.OTabLayout_oui_widgetBlurRadius, "styleable", "OTabLayout_oui_widgetBlurRadius"), 0.0f);
        com.obric.oui.blur.a r14 = r3.g();
        if (r14 == null) goto L14;
        r14.a(r1);
    L14:
        if (r13.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OTabLayout_enableDefaultMaskBackground, "styleable", "OTabLayout_enableDefaultMaskBackground"), false) == false) goto L16;
        setDefaultMaskBackground();
    L18:
        if (r13.getInt(ZeusTransformUtils.mapRes(R.styleable.OTabLayout_oui_bottomActionBarType, "styleable", "OTabLayout_oui_bottomActionBarType"), 0) != 1) goto L20;
        r4 = true;
    L20:
        r2.a(r4);
        r2.a(r13.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OTabLayout_oui_widgetFitInsetBottom, "styleable", "OTabLayout_oui_widgetFitInsetBottom"), true), (d.h.a.b) ZeusTransformUtils.preCheckCast(new a(this), d.h.a.b.class, "com.obric.aiagent.plugin"));
        setMaskBlurRadius(r1);
        r13.recycle();
        setDefaultBackdropTargetForChild();
        r2.a(81);
        return;
    L16:
        setMaskBackground(r13.getDrawable(ZeusTransformUtils.mapRes(R.styleable.OTabLayout_maskBackground, "styleable", "OTabLayout_maskBackground")));
        goto L18
    L5:
        if (r13.hasValue(ZeusTransformUtils.mapRes(R.styleable.OTabLayout_oui_widgetBlurBlendModes, "styleable", "OTabLayout_oui_widgetBlurBlendModes")) == false) goto L9;
        r3.a(l.a(ZeusTransformUtils.getResources(r13, "com.obric.aiagent.plugin"), r13.getResourceId(ZeusTransformUtils.mapRes(R.styleable.OTabLayout_oui_widgetBlurColors, "styleable", "OTabLayout_oui_widgetBlurColors"), ZeusTransformUtils.mapRes(R.array.oui_bottom_navbar_blur_colors, "array", "oui_bottom_navbar_blur_colors")), r13.getResourceId(ZeusTransformUtils.mapRes(R.styleable.OTabLayout_oui_widgetBlurBlendModes, "styleable", "OTabLayout_oui_widgetBlurBlendModes"), ZeusTransformUtils.mapRes(R.array.oui_bottom_navbar_blur_blend_modes, "array", "oui_bottom_navbar_blur_blend_modes"))));
        if (r3.c() != null) goto L9;
        com.obric.oui.d.a.b.e(TAG, "init get widget blur colors or modes error");
        goto L9
    }

    public final void updateLayoutForInsetBottom(int r7) {
        int r0 = getPaddingLeft();
        int r1 = getPaddingTop();
        int r2 = getPaddingRight();
        ViewGroup.LayoutParams r3 = ((View) ZeusTransformUtils.preCheckCast(this.bottomNavBar, View.class, "com.obric.aiagent.plugin")).getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r3, ViewGroup.MarginLayoutParams.class) == true) goto L5;
        r3 = null;
    L5:
        ViewGroup.MarginLayoutParams r4 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r3, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L8;
        int r5 = r4.bottomMargin;
    L9:
        setPaddingRelative(r0, r1, r2, n.c(0, r7 - r5));
        return;
    L8:
        r5 = 0;
        goto L9
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.floatingWindowHelper.b();
    }

    public final OBottomNavActionBar getNavigationBar() {
        return this.bottomNavBar;
    }

    public final View getMaskView() {
        return this.maskView;
    }

    public final void showMask(boolean r1) {
        View r0 = this.maskView;
        if (r1 == false) goto L5;
        int r2 = 0;
    L6:
        r0.setVisibility(r2);
        return;
    L5:
        r2 = 4;
        goto L6
    }

    public final void setMaskBlurRadius(float r5) {
        int r0 = this.materialSrcType;
        if (r0 != (-1)) goto L6;
        r0 = 2;
    L6:
        com.obric.oui.blur.a r1 = this.maskMaterialConfig.g();
        if (r1 == null) goto L10;
        r1.a(r5);
    L10:
        this.floatingWindowHelper.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), this.maskMaterialConfig, r0);
        if (r5 != 0.0f) goto L13;
        boolean r6 = true;
    L14:
        showMask(!r6);
        return;
    L13:
        r6 = false;
        goto L14
    }

    public final void setTitle(int r2, String r3) {
        o.e(r3, DBDefinition.TITLE);
        this.bottomNavBar.setTabTitle(r2, r3);
    }

    public final void setDrawable(int r2, Drawable r3) {
        o.e(r3, "drawable");
        this.bottomNavBar.setTabDrawable(r2, r3);
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        int r0 = this.materialSrcType;
        if (r0 == (-1)) goto L6;
        l.b(this, r0);
        this.bottomNavBar.updateBackdropSrcType(r0);
        return;
    }

    @Override // com.obric.oui.material.b
    public void applyMaskMaterial(boolean r3) {
        com.obric.oui.material.h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), r3, this.isBackdropView);
    }

    @Override // com.obric.oui.material.g
    public void applyContentMaterial(boolean r1) {
        this.bottomNavBar.applyContentMaterial(r1);
    }

    @Override // com.obric.oui.material.g
    public void setBackdropTarget(View r3) {
        if (r3 != null) goto L6;
        k.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"));
        setDefaultBackdropTargetForChild();
        return;
    L6:
        k.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), r3);
        this.bottomNavBar.setBackdropTarget(r3);
    }

    @Override // com.obric.oui.material.g
    public void updateBackdropTargetType(boolean r3) {
        if (this.isBackdropView == r3) goto L9;
        this.isBackdropView = r3;
        if (this.materialSrcType == (-1)) goto L7;
        return;
    L7:
        k.c((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), r3);
        this.bottomNavBar.updateBackdropTargetType(r3);
        return;
    }

    @Override // com.obric.oui.material.g
    public void updateBackdropSrcType(int r1) {
        this.materialSrcType = r1;
        l.b(this, r1);
        this.bottomNavBar.updateBackdropSrcType(r1);
    }

    private final View getDefaultTargetView() {
        if (l.c() <= 1) goto L7;
        return (View) ZeusTransformUtils.preCheckCast(this.rootView, View.class, "com.obric.aiagent.plugin");
    L7:
        return (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin");
    }

    private final void setDefaultBackdropTargetForChild() {
        View r0 = getDefaultTargetView();
        this.bottomNavBar.setBackdropTarget(r0);
    }
}
