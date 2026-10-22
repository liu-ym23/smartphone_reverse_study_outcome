package com.obric.oui.blur;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.oui.material.g;
import com.obric.oui.material.k;
import com.obric.oui.material.l;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: OBlurMaskView.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class OBlurMaskView extends FrameLayout implements com.obric.oui.material.b, g {
    public static final a Companion = null;
    private static final String TAG = "OBlurMaskView";
    private int defaultPaddingBottom;
    private int defaultPaddingTop;
    private boolean fitInsetBottom;
    private boolean fitInsetTop;
    private boolean isBackdropView;
    private boolean isInflated;
    private final com.obric.oui.material.c maskMaterialConfig;
    private final ViewGroup materialMask;
    private int materialSrcType;

    /* JADX INFO: compiled from: OBlurMaskView.kt */
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

    public OBlurMaskView(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public OBlurMaskView(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    /* JADX INFO: renamed from: lambda$6OEdmTm0C9N_W-BV0WdW23Sx5ok, reason: not valid java name */
    public static /* synthetic */ WindowInsets m975lambda$6OEdmTm0C9N_WBV0WdW23Sx5ok(OBlurMaskView r0, View r1, WindowInsets r2) {
        return m974initAttrs$lambda3$lambda2(r0, r1, r2);
    }

    public final void setMaskHeight(int r1) {
    }

    public /* synthetic */ OBlurMaskView(Context r2, AttributeSet r3, int r4, int r5, h r6) {
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

    public OBlurMaskView(Context r21, AttributeSet r22, int r23) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r21, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r3 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r22, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        super(r1, r3, r23);
        this.defaultPaddingTop = com.obric.oui.common.util.g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 24);
        this.defaultPaddingBottom = com.obric.oui.common.util.g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 24);
        this.isBackdropView = true;
        this.materialSrcType = 2;
        this.maskMaterialConfig = new com.obric.oui.material.c(null, null, l.a(ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.array.oui_titlebar_blur_colors, "array", "oui_titlebar_blur_colors"), ZeusTransformUtils.mapRes(R.array.oui_titlebar_blur_blend_modes, "array", "oui_titlebar_blur_blend_modes")), null, null, null, new com.obric.oui.blur.a(BlurToken.Blur_Progress_Thin, 1, 0.0f, 6, 0.0f, 20, null), null, null, null, 955, null);
        ZeusTransformUtils.inflate(LayoutInflater.from(r1), ZeusTransformUtils.mapRes(R.layout.o_blur_mask_view, "layout", "o_blur_mask_view"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.aiagent.plugin"), true, "com.obric.aiagent.plugin");
        View r2 = findViewById(ZeusTransformUtils.mapRes(R.id.material_mask, DbHelper.COL_ID, "material_mask"));
        o.c(r2, "findViewById(R.id.material_mask)");
        this.materialMask = (ViewGroup) ZeusTransformUtils.preCheckCast(r2, ViewGroup.class, "com.obric.aiagent.plugin");
        setClipChildren(false);
        setClipToPadding(false);
        this.isInflated = true;
        if (r3 == null) goto L6;
        initAttrs(r3);
        return;
    }

    private final void initAttrs(AttributeSet r10) {
        AttributeSet r11 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r0, "context");
        int[] r2 = R.styleable.OBlurMaskView;
        o.c(r2, TAG);
        TypedArray r12 = r0.obtainStyledAttributes(r11, r2, 0, 0);
        o.c(r12, "obtainStyledAttributes(s…efStyleAttr, defStyleRes)");
        if (r12.hasValue(ZeusTransformUtils.mapRes(R.styleable.OBlurMaskView_oui_widgetMaterialSrcType, "styleable", "OBlurMaskView_oui_widgetMaterialSrcType")) == false) goto L6;
        this.materialSrcType = r12.getInt(ZeusTransformUtils.mapRes(R.styleable.OBlurMaskView_oui_widgetMaterialSrcType, "styleable", "OBlurMaskView_oui_widgetMaterialSrcType"), 2);
    L6:
        if (r12.hasValue(ZeusTransformUtils.mapRes(R.styleable.OBlurMaskView_oui_widgetBlurType, "styleable", "OBlurMaskView_oui_widgetBlurType")) == false) goto L12;
        int r1 = r12.getInt(ZeusTransformUtils.mapRes(R.styleable.OBlurMaskView_oui_widgetBlurType, "styleable", "OBlurMaskView_oui_widgetBlurType"), 0);
        com.obric.oui.blur.a r5 = this.maskMaterialConfig.g();
        if (r5 == null) goto L12;
        r5.a(r1);
    L12:
        if (r12.hasValue(ZeusTransformUtils.mapRes(R.styleable.OBlurMaskView_oui_widgetBlurColors, "styleable", "OBlurMaskView_oui_widgetBlurColors")) == false) goto L19;
        if (r12.hasValue(ZeusTransformUtils.mapRes(R.styleable.OBlurMaskView_oui_widgetBlurBlendModes, "styleable", "OBlurMaskView_oui_widgetBlurBlendModes")) == false) goto L19;
        int r3 = r12.getResourceId(ZeusTransformUtils.mapRes(R.styleable.OBlurMaskView_oui_widgetBlurColors, "styleable", "OBlurMaskView_oui_widgetBlurColors"), ZeusTransformUtils.mapRes(R.array.oui_titlebar_blur_colors, "array", "oui_titlebar_blur_colors"));
        int r6 = r12.getResourceId(ZeusTransformUtils.mapRes(R.styleable.OBlurMaskView_oui_widgetBlurBlendModes, "styleable", "OBlurMaskView_oui_widgetBlurBlendModes"), ZeusTransformUtils.mapRes(R.array.oui_titlebar_blur_blend_modes, "array", "oui_titlebar_blur_blend_modes"));
        this.maskMaterialConfig.a(l.a(ZeusTransformUtils.getResources(r12, "com.obric.aiagent.plugin"), r3, r6));
        if (this.maskMaterialConfig.c() != null) goto L19;
        com.obric.oui.d.a.b.e(TAG, "init get widget blur colors or modes error");
    L19:
        if (r12.hasValue(ZeusTransformUtils.mapRes(R.styleable.OBlurMaskView_oBlurMask_blurRadius, "styleable", "OBlurMaskView_oBlurMask_blurRadius")) == false) goto L26;
        float r4 = r12.getFloat(ZeusTransformUtils.mapRes(R.styleable.OBlurMaskView_oBlurMask_blurRadius, "styleable", "OBlurMaskView_oBlurMask_blurRadius"), BlurToken.Blur_Progress_Thin);
        com.obric.oui.blur.a r7 = this.maskMaterialConfig.g();
        if (r7 == null) goto L24;
        r7.a(r4);
    L24:
        setMaskBlurRadius(r4);
    L26:
        if (r12.hasValue(ZeusTransformUtils.mapRes(R.styleable.OBlurMaskView_oBlurMask_maskHeight, "styleable", "OBlurMaskView_oBlurMask_maskHeight")) == false) goto L30;
        int r8 = r12.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.OBlurMaskView_oBlurMask_maskHeight, "styleable", "OBlurMaskView_oBlurMask_maskHeight"), 0);
        if (r8 <= 0) goto L30;
        setMaskHeight(r8);
    L30:
        boolean r9 = r12.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OBlurMaskView_oBlurMask_statusBarImmersion, "styleable", "OBlurMaskView_oBlurMask_statusBarImmersion"), false);
        this.fitInsetTop = r12.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OBlurMaskView_oui_widgetFitInsetTop, "styleable", "OBlurMaskView_oui_widgetFitInsetTop"), r9);
        boolean r13 = r12.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OBlurMaskView_oui_widgetFitInsetBottom, "styleable", "OBlurMaskView_oui_widgetFitInsetBottom"), false);
        this.fitInsetBottom = r13;
        if (this.fitInsetTop == true) goto L33;
        if (r13 == true) goto L33;
    L42:
        r12.recycle();
        return;
    L33:
        com.obric.oui.window.a r14 = com.obric.oui.window.a.f36851a;
        com.obric.oui.view.b r15 = com.obric.oui.window.a.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), null, true);
        if (this.fitInsetTop == false) goto L36;
        int r16 = r15.f36822c;
    L37:
        updateLayoutForInsetTop(r16);
        if (this.fitInsetBottom == false) goto L40;
        int r17 = r15.f36824e;
    L41:
        updateLayoutForInsetBottom(r17);
        setOnApplyWindowInsetsListener(new $$Lambda$OBlurMaskView$6OEdmTm0C9N_WBV0WdW23Sx5ok(this));
        goto L42
    L40:
        r17 = this.defaultPaddingBottom;
        goto L41
    L36:
        r16 = this.defaultPaddingTop;
        goto L37
    }

    /* JADX INFO: renamed from: initAttrs$lambda-3$lambda-2, reason: not valid java name */
    private static final WindowInsets m974initAttrs$lambda3$lambda2(OBlurMaskView r1, View r2, WindowInsets r3) {
        o.e(r1, "this$0");
        o.e(r2, "$noName_0");
        o.e(r3, "insets");
        com.obric.oui.window.a r4 = com.obric.oui.window.a.f36851a;
        com.obric.oui.view.b r5 = com.obric.oui.window.a.a((View) ZeusTransformUtils.preCheckCast(r1, View.class, "com.obric.aiagent.plugin"), r3, true);
        if (r1.fitInsetTop == false) goto L5;
        int r0 = r5.f36822c;
    L6:
        r1.updateLayoutForInsetTop(r0);
        if (r1.fitInsetBottom == false) goto L9;
        int r6 = r5.f36824e;
    L10:
        r1.updateLayoutForInsetBottom(r6);
        return r3;
    L9:
        r6 = r1.defaultPaddingBottom;
        goto L10
    L5:
        r0 = r1.defaultPaddingTop;
        goto L6
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        updateBackdropConfigOfChildren();
    }

    private final void updateBackdropConfigOfChildren() {
        int r0 = getChildCount();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L16;
        int r3 = r2 + 1;
        View r4 = getChildAt(r2);
        if (ZeusTransformUtils.instanceOf(r4, g.class) == false) goto L8;
        updateMaterialOwnerChildBackdropSrcType((g) ZeusTransformUtils.preCheckCast(r4, g.class, "com.obric.aiagent.plugin"));
        updateMaterialOwnerChildBackdropTarget((g) ZeusTransformUtils.preCheckCast(r4, g.class, "com.obric.aiagent.plugin"));
    L15:
        r2 = r3;
        goto L3
    L8:
        if (ZeusTransformUtils.instanceOf(r4, ViewGroup.class) == false) goto L15;
        int r5 = ((ViewGroup) ZeusTransformUtils.preCheckCast(r4, ViewGroup.class, "com.obric.aiagent.plugin")).getChildCount();
        int r6 = 0;
    L10:
        if (r6 >= r5) goto L15;
        int r7 = r6 + 1;
        View r8 = ((ViewGroup) ZeusTransformUtils.preCheckCast(r4, ViewGroup.class, "com.obric.aiagent.plugin")).getChildAt(r6);
        if (ZeusTransformUtils.instanceOf(r8, g.class) == false) goto L14;
        updateMaterialOwnerChildBackdropSrcType((g) ZeusTransformUtils.preCheckCast(r8, g.class, "com.obric.aiagent.plugin"));
        updateMaterialOwnerChildBackdropTarget((g) ZeusTransformUtils.preCheckCast(r8, g.class, "com.obric.aiagent.plugin"));
    L14:
        r6 = r7;
        goto L10
    }

    private final void updateBackdropEnableOfChildren(boolean r10) {
        int r0 = getChildCount();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L16;
        int r3 = r2 + 1;
        View r4 = getChildAt(r2);
        if (ZeusTransformUtils.instanceOf(r4, g.class) == false) goto L8;
        ((g) ZeusTransformUtils.preCheckCast(r4, g.class, "com.obric.aiagent.plugin")).applyContentMaterial(r10);
    L15:
        r2 = r3;
        goto L3
    L8:
        if (ZeusTransformUtils.instanceOf(r4, ViewGroup.class) == false) goto L15;
        int r5 = ((ViewGroup) ZeusTransformUtils.preCheckCast(r4, ViewGroup.class, "com.obric.aiagent.plugin")).getChildCount();
        int r6 = 0;
    L10:
        if (r6 >= r5) goto L15;
        int r7 = r6 + 1;
        View r8 = ((ViewGroup) ZeusTransformUtils.preCheckCast(r4, ViewGroup.class, "com.obric.aiagent.plugin")).getChildAt(r6);
        if (ZeusTransformUtils.instanceOf(r8, g.class) == false) goto L14;
        ((g) ZeusTransformUtils.preCheckCast(r8, g.class, "com.obric.aiagent.plugin")).applyContentMaterial(r10);
    L14:
        r6 = r7;
        goto L10
    }

    private final View getDefaultTargetView() {
        if (l.c() <= 1) goto L7;
        return (View) ZeusTransformUtils.preCheckCast(this.materialMask, View.class, "com.obric.aiagent.plugin");
    L7:
        return (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin");
    }

    private final void updateMaterialOwnerChildBackdropTarget(g r3) {
        g r4 = (g) ZeusTransformUtils.wrapperContextForParams(r3, g.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r4, com.obric.oui.material.b.class) == false) goto L5;
        ((com.obric.oui.material.b) ZeusTransformUtils.preCheckCast(r4, com.obric.oui.material.b.class, "com.obric.aiagent.plugin")).applyMaskMaterial(false);
    L5:
        r4.setBackdropTarget(getDefaultTargetView());
    }

    private final void updateMaterialOwnerChildBackdropSrcType(g r3) {
        ((g) ZeusTransformUtils.wrapperContextForParams(r3, g.class, "com.obric.aiagent.plugin")).updateBackdropSrcType(this.materialSrcType);
    }

    public final void setMaskBlurRadius(float r3) {
        com.obric.oui.blur.a r0 = this.maskMaterialConfig.g();
        if (r0 == null) goto L6;
        r0.a(r3);
    L6:
        l.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), this.maskMaterialConfig);
        k.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"));
    }

    public final void setMaskBackground(Drawable r2) {
        o.e(r2, "drawable");
        setBackground(r2);
    }

    public final void setDefaultMaskBackground() {
        Drawable r0 = ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getDrawable(ZeusTransformUtils.mapRes(R.drawable.o_floating_title_bar_default_mask_bg, "drawable", "o_floating_title_bar_default_mask_bg"));
        o.c(r0, "resources.getDrawable(R.…itle_bar_default_mask_bg)");
        setMaskBackground(r0);
    }

    public final void showMask(boolean r1) {
        if (r1 == false) goto L4;
        int r2 = 0;
    L5:
        setVisibility(r2);
        return;
    L4:
        r2 = 8;
        goto L5
    }

    @Override // com.obric.oui.material.g
    public void applyContentMaterial(boolean r1) {
        updateBackdropEnableOfChildren(r1);
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
    public void setBackdropTarget(View r3) {
        if (r3 != null) goto L6;
        k.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"));
        return;
    L6:
        k.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), r3);
    }

    @Override // com.obric.oui.material.g
    public void updateBackdropTargetType(boolean r3) {
        this.isBackdropView = r3;
        k.c((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), r3);
    }

    @Override // com.obric.oui.material.g
    public void updateBackdropSrcType(int r3) {
        this.materialSrcType = r3;
        k.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), r3);
        updateBackdropConfigOfChildren();
    }

    public final void updateLayoutForInsetTop(int r4) {
        View r3 = (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin");
        r3.setPadding(r3.getPaddingLeft(), r4, r3.getPaddingRight(), r3.getPaddingBottom());
    }

    public final void updateLayoutForInsetBottom(int r4) {
        View r3 = (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin");
        r3.setPadding(r3.getPaddingLeft(), r3.getPaddingTop(), r3.getPaddingRight(), r4);
    }
}
