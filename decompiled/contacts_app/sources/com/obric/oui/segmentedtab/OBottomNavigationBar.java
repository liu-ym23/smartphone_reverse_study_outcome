package com.obric.oui.segmentedtab;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.obric.common.oui.R;
import com.obric.oui.blur.BlurConfig;
import com.obric.oui.blur.BlurToken;
import com.obric.oui.layout.OUIFrameLayout;
import com.obric.oui.material.MaskMaterialOwner;
import com.obric.oui.material.MaterialConfig;
import com.obric.oui.material.MaterialOwner;
import com.obric.oui.material.MaterialOwnerKt;
import com.obric.oui.material.OMaterialExtBaseKt;
import com.obric.oui.material.OMaterialHelper;
import com.obric.oui.utils.log.L;
import com.obric.oui.window.floating.OFloatingWindowHelper;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: OBottomNavigationBar.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 82\u00020\u00012\u00020\u00022\u00020\u0003:\u00018B%\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0010H\u0016J\u0010\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u0010H\u0016J\b\u0010\u001d\u001a\u00020\u0014H\u0002J\u0006\u0010\u001e\u001a\u00020\u0014J\u0006\u0010\u001f\u001a\u00020\fJ\b\u0010 \u001a\u00020\u0019H\u0014J\b\u0010!\u001a\u00020\u0019H\u0014J\u0012\u0010\"\u001a\u00020\u00192\b\u0010#\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010$\u001a\u00020\u0019H\u0002J\b\u0010%\u001a\u00020\u0019H\u0007J\u0016\u0010&\u001a\u00020\u00192\u0006\u0010'\u001a\u00020\t2\u0006\u0010(\u001a\u00020)J\u0012\u0010*\u001a\u00020\u00192\b\u0010(\u001a\u0004\u0018\u00010)H\u0007J\u000e\u0010+\u001a\u00020\u00192\u0006\u0010,\u001a\u00020-J\u0016\u0010.\u001a\u00020\u00192\u0006\u0010'\u001a\u00020\t2\u0006\u0010/\u001a\u000200J\u000e\u00101\u001a\u00020\u00192\u0006\u00102\u001a\u00020\u0010J\u0010\u00103\u001a\u00020\u00192\u0006\u00104\u001a\u00020\tH\u0016J\u0010\u00105\u001a\u00020\u00192\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u000e\u00106\u001a\u00020\u00192\u0006\u00107\u001a\u00020\tR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/obric/oui/segmentedtab/OBottomNavigationBar;", "Lcom/obric/oui/layout/OUIFrameLayout;", "Lcom/obric/oui/material/MaterialOwner;", "Lcom/obric/oui/material/MaskMaterialOwner;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bottomNavBar", "Lcom/obric/oui/segmentedtab/OBottomNavActionBar;", "floatingWindowHelper", "Lcom/obric/oui/window/floating/OFloatingWindowHelper;", "isBackdropView", "", "maskMaterialConfig", "Lcom/obric/oui/material/MaterialConfig;", "maskView", "Landroid/view/View;", "materialSrcType", "rootView", "Landroid/view/ViewGroup;", "applyContentMaterial", "", "apply", "applyMaskMaterial", "enable", "getDefaultTargetView", "getMaskView", "getNavigationBar", "onAttachedToWindow", "onFinishInflate", "setBackdropTarget", "view", "setDefaultBackdropTargetForChild", "setDefaultMaskBackground", "setDrawable", "index", "drawable", "Landroid/graphics/drawable/Drawable;", "setMaskBackground", "setMaskBlurRadius", "radius", "", "setTitle", "title", "", "showMask", "show", "updateBackdropSrcType", "srcType", "updateBackdropTargetType", "updateLayoutForInsetBottom", "insetBottom", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OBottomNavigationBar extends OUIFrameLayout implements MaterialOwner, MaskMaterialOwner {
    public static final Companion Companion = null;
    public static final String TAG = "OBottomNavigationBar";
    private final OBottomNavActionBar bottomNavBar;
    private final OFloatingWindowHelper floatingWindowHelper;
    private boolean isBackdropView;
    private final MaterialConfig maskMaterialConfig;
    private final View maskView;
    private int materialSrcType;
    private final ViewGroup rootView;

    /* JADX INFO: compiled from: OBottomNavigationBar.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/segmentedtab/OBottomNavigationBar$Companion;", "", "()V", "TAG", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public OBottomNavigationBar(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, null, 0, 6, null);
    }

    public OBottomNavigationBar(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, r9, 0, 4, null);
    }

    @Deprecated(message = "no use")
    public final void setDefaultMaskBackground() {
    }

    @Deprecated(message = "no use")
    public final void setMaskBackground(Drawable r1) {
    }

    public /* synthetic */ OBottomNavigationBar(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    public OBottomNavigationBar(Context r26, AttributeSet r27, int r28) {
        Intrinsics.checkNotNullParameter(r26, "context");
        super(r26, r27, r28, null, 8, null);
        this.isBackdropView = true;
        this.materialSrcType = -1;
        OFloatingWindowHelper r2 = new OFloatingWindowHelper(this);
        this.floatingWindowHelper = r2;
        MaterialConfig r3 = new MaterialConfig(null, null, OMaterialHelper.getBlendConfigArray(getResources(), R.array.oui_bottom_navbar_blend_colors), null, null, null, new BlurConfig(BlurToken.Blur_Progress_Thin, 2, 0.0f, 6, 0.0f, 20, null), null, null, null, 955, null);
        this.maskMaterialConfig = r3;
        boolean r4 = false;
        setClipToPadding(false);
        setClipChildren(false);
        setOutlineProvider(new AnonymousClass1());
        setChangeAlphaWhenPress(false);
        setChangeAlphaWhenDisable(false);
        setChangeAlphaWhenSelected(false);
        LayoutInflater.from(r26).inflate(R.layout.layout_custom_bottom_navigation, this, true);
        View r5 = findViewById(R.id.bottom_nav_bar_container);
        Intrinsics.checkNotNullExpressionValue(r5, "findViewById(R.id.bottom_nav_bar_container)");
        ViewGroup r6 = (ViewGroup) r5;
        this.rootView = r6;
        ((OUIFrameLayout) r6).setChangeAlphaWhenPress(false);
        ((OUIFrameLayout) r6).setChangeAlphaWhenDisable(false);
        ((OUIFrameLayout) r6).setChangeAlphaWhenSelected(false);
        View r7 = findViewById(R.id.bottom_nav_bar);
        Intrinsics.checkNotNullExpressionValue(r7, "findViewById(R.id.bottom_nav_bar)");
        OBottomNavActionBar r8 = (OBottomNavActionBar) r7;
        this.bottomNavBar = r8;
        r8.obtainAttributes(r26, r27);
        r8.setChangeAlphaWhenPress(false);
        r8.setChangeAlphaWhenDisable(false);
        r8.setChangeAlphaWhenSelected(false);
        View r9 = findViewById(R.id.mask_view);
        Intrinsics.checkNotNullExpressionValue(r9, "findViewById(R.id.mask_view)");
        this.maskView = r9;
        int[] r10 = R.styleable.OTabLayout;
        Intrinsics.checkNotNullExpressionValue(r10, "OTabLayout");
        TypedArray r11 = r26.obtainStyledAttributes(r27, r10, 0, 0);
        Intrinsics.checkNotNullExpressionValue(r11, "obtainStyledAttributes(s…efStyleAttr, defStyleRes)");
        this.materialSrcType = r11.getInt(R.styleable.OTabLayout_oui_widgetMaterialSrcType, -1);
        if (r11.hasValue(R.styleable.OTabLayout_oui_widgetBlurColors) == true) goto L5;
    L9:
        float r1 = r11.getFloat(R.styleable.OTabLayout_oui_widgetBlurRadius, 0.0f);
        BlurConfig r12 = r3.getBlurConfig();
        if (r12 == null) goto L14;
        r12.setBlurRadius(r1);
    L14:
        if (r11.getBoolean(R.styleable.OTabLayout_enableDefaultMaskBackground, false) == false) goto L16;
        setDefaultMaskBackground();
    L18:
        if (r11.getInt(R.styleable.OTabLayout_oui_bottomActionBarType, 0) != 1) goto L20;
        r4 = true;
    L20:
        r2.setFloatingType(r4);
        r2.setupInsets(r11.getBoolean(R.styleable.OTabLayout_oui_widgetFitInsetBottom, true), new OBottomNavigationBar$2$1(this));
        setMaskBlurRadius(r1);
        r11.recycle();
        setDefaultBackdropTargetForChild();
        r2.setGravity(81);
        return;
    L16:
        setMaskBackground(r11.getDrawable(R.styleable.OTabLayout_maskBackground));
        goto L18
    L5:
        if (r11.hasValue(R.styleable.OTabLayout_oui_widgetBlurBlendModes) == false) goto L9;
        r3.setBlendConfig(OMaterialHelper.getBlendConfigArray(r11.getResources(), r11.getResourceId(R.styleable.OTabLayout_oui_widgetBlurColors, R.array.oui_bottom_navbar_blur_colors), r11.getResourceId(R.styleable.OTabLayout_oui_widgetBlurBlendModes, R.array.oui_bottom_navbar_blur_blend_modes)));
        if (r3.getBlendConfig() != null) goto L9;
        L.e(TAG, "init get widget blur colors or modes error");
        goto L9
    }

    public final void updateLayoutForInsetBottom(int r6) {
        int r0 = getPaddingLeft();
        int r1 = getPaddingTop();
        int r2 = getPaddingRight();
        ViewGroup.LayoutParams r3 = this.bottomNavBar.getLayoutParams();
        if ((r3 instanceof ViewGroup.MarginLayoutParams) == true) goto L5;
        r3 = null;
    L5:
        ViewGroup.MarginLayoutParams r4 = (ViewGroup.MarginLayoutParams) r3;
        if (r4 == null) goto L8;
        int r5 = r4.bottomMargin;
    L9:
        setPaddingRelative(r0, r1, r2, RangesKt.coerceAtLeast(0, r6 - r5));
        return;
    L8:
        r5 = 0;
        goto L9
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.floatingWindowHelper.onAttachedToWindow();
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
        BlurConfig r1 = this.maskMaterialConfig.getBlurConfig();
        if (r1 == null) goto L10;
        r1.setBlurRadius(r5);
    L10:
        this.floatingWindowHelper.applyBlur(this, this.maskMaterialConfig, r0);
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
        Intrinsics.checkNotNullParameter(r3, "title");
        this.bottomNavBar.setTabTitle(r2, r3);
    }

    public final void setDrawable(int r2, Drawable r3) {
        Intrinsics.checkNotNullParameter(r3, "drawable");
        this.bottomNavBar.setTabDrawable(r2, r3);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        int r0 = this.materialSrcType;
        if (r0 == (-1)) goto L6;
        OMaterialHelper.setEffectSrc(this, r0);
        this.bottomNavBar.updateBackdropSrcType(r0);
        return;
    }

    @Override // com.obric.oui.material.MaskMaterialOwner
    public void applyMaskMaterial(boolean r2) {
        MaterialOwnerKt.applyBackdropMaterial(this, r2, this.isBackdropView);
    }

    @Override // com.obric.oui.material.MaterialOwner
    public void applyContentMaterial(boolean r1) {
        this.bottomNavBar.applyContentMaterial(r1);
    }

    @Override // com.obric.oui.material.MaterialOwner, com.obric.oui.material.MaskMaterialOwner
    public void setBackdropTarget(View r2) {
        if (r2 != null) goto L5;
        OBottomNavigationBar r3 = this;
        OMaterialExtBaseKt.setMaterialBackdropTarget(r3, r3);
        setDefaultBackdropTargetForChild();
        return;
    L5:
        OMaterialExtBaseKt.setMaterialBackdropTarget(this, r2);
        this.bottomNavBar.setBackdropTarget(r2);
    }

    @Override // com.obric.oui.material.MaterialOwner, com.obric.oui.material.MaskMaterialOwner
    public void updateBackdropTargetType(boolean r3) {
        if (this.isBackdropView == r3) goto L9;
        this.isBackdropView = r3;
        if (this.materialSrcType == (-1)) goto L7;
        return;
    L7:
        OMaterialExtBaseKt.updateMaterialBackdropTargetType(this, r3);
        this.bottomNavBar.updateBackdropTargetType(r3);
        return;
    }

    @Override // com.obric.oui.material.MaterialOwner, com.obric.oui.material.MaskMaterialOwner
    public void updateBackdropSrcType(int r1) {
        this.materialSrcType = r1;
        OMaterialHelper.setEffectSrc(this, r1);
        this.bottomNavBar.updateBackdropSrcType(r1);
    }

    private final View getDefaultTargetView() {
        if (OMaterialHelper.getEffectOverlayLevel() <= 1) goto L7;
        return this.rootView;
    L7:
        return this;
    }

    private final void setDefaultBackdropTargetForChild() {
        View r0 = getDefaultTargetView();
        this.bottomNavBar.setBackdropTarget(r0);
    }
}
