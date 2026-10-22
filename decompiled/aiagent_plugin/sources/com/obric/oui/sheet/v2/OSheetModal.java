package com.obric.oui.sheet.v2;

import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Configuration;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Size;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowInsetsController;
import android.widget.FrameLayout;
import androidx.lifecycle.i;
import androidx.lifecycle.p;
import com.obric.oui.dialog.alert.view.RadiusLayout;
import com.obric.oui.material.k;
import com.obric.oui.material.l;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.x;
import java.util.Objects;

/* JADX INFO: compiled from: OSheetModal.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class OSheetModal extends FrameLayout implements com.obric.oui.sheet.v2.a {
    private boolean autoAddBodyPaddingTopWhenOverlay;
    private int bgColor;
    public FrameLayout bodyContainer;
    private int bodyContentPaddingBottom;
    private int bodyContentPaddingTop;
    private a cancelListener;
    private ComponentCallbacks configurationCallback;
    private boolean configurationCallbackRegistered;
    private b configurationListener;
    public View contentView;
    public View dimView;
    private c dismissAnimListener;
    private boolean enableDimAnim;
    private boolean enableEnterAnim;
    private boolean enableMaterial;
    public FrameLayout footerContainer;
    private Size fullWindowSize;
    public FrameLayout headerContainer;
    private OSheet.c heightStyle;
    private boolean ignoreInsetBottom;
    private boolean isContentOverlayMode;
    private boolean mCancelable;
    private boolean mClearDimFlag;
    private Window.Callback myWindowCallback;
    private Integer originalNavigationBarAppearance;
    private Integer originalStatusBarAppearance;
    private Integer originalSystemUiVisibility;
    private Window.Callback originalWindowCallback;
    private boolean passThroughTouchOutside;
    private boolean removeOnDismiss;
    public RadiusLayout rootContainer;
    private float rootTransMoveStartX;
    private float rootTransMoveStartY;
    private com.obric.common.oea.foundation.animation.manager.d runningAnim;
    public ViewGroup scaffoldContainer;
    public com.obric.oui.sheet.v2.c scaffoldController;
    private d showAnimListener;
    private boolean showing;
    private Boolean systemInsetsAppearanceLightValue;
    private int userWindowHeight;
    private int userWindowWidth;

    /* JADX INFO: compiled from: OSheetModal.kt */
    public interface a {
        void a(OSheetModal r1);
    }

    /* JADX INFO: compiled from: OSheetModal.kt */
    public interface b {
        void a(OSheetModal r1, Configuration r2);
    }

    /* JADX INFO: compiled from: OSheetModal.kt */
    public interface c {
        void a(OSheetModal r1);

        void b(OSheetModal r1);
    }

    /* JADX INFO: compiled from: OSheetModal.kt */
    public interface d {
        void a(OSheetModal r1);

        void b(OSheetModal r1);
    }

    public OSheetModal(Context r9) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        this(r1, null, 0, false, false, 30, null);
    }

    public OSheetModal(Context r11, AttributeSet r12) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r12, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, 0, false, false, 28, null);
    }

    public OSheetModal(Context r11, AttributeSet r12, int r13) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r12, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, r13, false, false, 24, null);
    }

    public OSheetModal(Context r11, AttributeSet r12, int r13, boolean r14) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r12, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, r13, r14, false, 16, null);
    }

    public static /* synthetic */ void lambda$K0aaz_pMmkAcUSSHFT9bZXgsKrE(OSheetModal r0) {
        m1179show$lambda2(r0);
    }

    public static /* synthetic */ void lambda$mg_jy21wVoJ9ExL6GtPywsJnqv4(OSheetModal r0, View r1) {
        m1178show$lambda1(r0, r1);
    }

    @Override // com.obric.oui.sheet.v2.a
    public boolean useWindowDim() {
        return false;
    }

    @Override // com.obric.oui.sheet.v2.a
    public Window windowForAnim() {
        return null;
    }

    public /* synthetic */ OSheetModal(Context r4, AttributeSet r5, int r6, boolean r7, boolean r8, int r9, h r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r12 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r9 & 2) == 0) goto L5;
        r12 = null;
    L5:
        AttributeSet r13 = r12;
        boolean r0 = false;
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

    public static final /* synthetic */ b access$getConfigurationListener$p(OSheetModal r0) {
        return r0.configurationListener;
    }

    public static final /* synthetic */ Window.Callback access$getOriginalWindowCallback$p(OSheetModal r0) {
        return r0.originalWindowCallback;
    }

    public static final /* synthetic */ void access$restoreWindowCallback(OSheetModal r0) {
        r0.restoreWindowCallback();
    }

    public void applyMaterial(boolean r3) {
        com.obric.oui.sheet.v2.a.C0991a.d((com.obric.oui.sheet.v2.a) ZeusTransformUtils.preCheckCast(this, com.obric.oui.sheet.v2.a.class, "com.obric.aiagent.plugin"), r3);
    }

    @Override // com.obric.oui.sheet.v2.a
    public void calculateBodyMaxHeight() {
        com.obric.oui.sheet.v2.a.C0991a.j((com.obric.oui.sheet.v2.a) ZeusTransformUtils.preCheckCast(this, com.obric.oui.sheet.v2.a.class, "com.obric.aiagent.plugin"));
    }

    public void enableIgnoreInsetBottom(boolean r3) {
        com.obric.oui.sheet.v2.a.C0991a.a((com.obric.oui.sheet.v2.a) ZeusTransformUtils.preCheckCast(this, com.obric.oui.sheet.v2.a.class, "com.obric.aiagent.plugin"), r3);
    }

    @Override // com.obric.oui.sheet.v2.e
    public void fling(float r3, float r4) {
        com.obric.oui.sheet.v2.a.C0991a.a((com.obric.oui.sheet.v2.a) ZeusTransformUtils.preCheckCast(this, com.obric.oui.sheet.v2.a.class, "com.obric.aiagent.plugin"), r3, r4);
    }

    public int getContentLayoutResId() {
        return com.obric.oui.sheet.v2.a.C0991a.a((com.obric.oui.sheet.v2.a) ZeusTransformUtils.preCheckCast(this, com.obric.oui.sheet.v2.a.class, "com.obric.aiagent.plugin"));
    }

    public View getEndActionButton() {
        return com.obric.oui.sheet.v2.a.C0991a.g((com.obric.oui.sheet.v2.a) ZeusTransformUtils.preCheckCast(this, com.obric.oui.sheet.v2.a.class, "com.obric.aiagent.plugin"));
    }

    public OSheetTitleBar getHeaderTitleBar() {
        return com.obric.oui.sheet.v2.a.C0991a.c((com.obric.oui.sheet.v2.a) ZeusTransformUtils.preCheckCast(this, com.obric.oui.sheet.v2.a.class, "com.obric.aiagent.plugin"));
    }

    public int getMaxBodyHeight() {
        return com.obric.oui.sheet.v2.a.C0991a.d((com.obric.oui.sheet.v2.a) ZeusTransformUtils.preCheckCast(this, com.obric.oui.sheet.v2.a.class, "com.obric.aiagent.plugin"));
    }

    public View getNegativeButton() {
        return com.obric.oui.sheet.v2.a.C0991a.h((com.obric.oui.sheet.v2.a) ZeusTransformUtils.preCheckCast(this, com.obric.oui.sheet.v2.a.class, "com.obric.aiagent.plugin"));
    }

    public View getPositiveButton() {
        return com.obric.oui.sheet.v2.a.C0991a.i((com.obric.oui.sheet.v2.a) ZeusTransformUtils.preCheckCast(this, com.obric.oui.sheet.v2.a.class, "com.obric.aiagent.plugin"));
    }

    public View getStartActionButton() {
        return com.obric.oui.sheet.v2.a.C0991a.f((com.obric.oui.sheet.v2.a) ZeusTransformUtils.preCheckCast(this, com.obric.oui.sheet.v2.a.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.oui.sheet.v2.a
    public void initBgColor() {
        com.obric.oui.sheet.v2.a.C0991a.q((com.obric.oui.sheet.v2.a) ZeusTransformUtils.preCheckCast(this, com.obric.oui.sheet.v2.a.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.oui.sheet.v2.a
    public boolean isDarkTheme() {
        return com.obric.oui.sheet.v2.a.C0991a.r((com.obric.oui.sheet.v2.a) ZeusTransformUtils.preCheckCast(this, com.obric.oui.sheet.v2.a.class, "com.obric.aiagent.plugin"));
    }

    public boolean isRootContainerMaxHeight() {
        return com.obric.oui.sheet.v2.a.C0991a.e((com.obric.oui.sheet.v2.a) ZeusTransformUtils.preCheckCast(this, com.obric.oui.sheet.v2.a.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.oui.sheet.v2.e
    public void move(float r3, float r4, boolean r5) {
        com.obric.oui.sheet.v2.a.C0991a.a((com.obric.oui.sheet.v2.a) ZeusTransformUtils.preCheckCast(this, com.obric.oui.sheet.v2.a.class, "com.obric.aiagent.plugin"), r3, r4, r5);
    }

    @Override // com.obric.oui.sheet.v2.a
    public void onPostShow() {
        com.obric.oui.sheet.v2.a.C0991a.m((com.obric.oui.sheet.v2.a) ZeusTransformUtils.preCheckCast(this, com.obric.oui.sheet.v2.a.class, "com.obric.aiagent.plugin"));
    }

    public void performEnterAnimation() {
        com.obric.oui.sheet.v2.a.C0991a.p((com.obric.oui.sheet.v2.a) ZeusTransformUtils.preCheckCast(this, com.obric.oui.sheet.v2.a.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.oui.sheet.v2.a
    public void performExitAnimation(float r3) {
        com.obric.oui.sheet.v2.a.C0991a.a((com.obric.oui.sheet.v2.a) ZeusTransformUtils.preCheckCast(this, com.obric.oui.sheet.v2.a.class, "com.obric.aiagent.plugin"), r3);
    }

    public void registerConfigurationCallbackIfNeeded() {
        com.obric.oui.sheet.v2.a.C0991a.n((com.obric.oui.sheet.v2.a) ZeusTransformUtils.preCheckCast(this, com.obric.oui.sheet.v2.a.class, "com.obric.aiagent.plugin"));
    }

    public void removeOnApplyWindowInsetsListener() {
        com.obric.oui.sheet.v2.a.C0991a.l((com.obric.oui.sheet.v2.a) ZeusTransformUtils.preCheckCast(this, com.obric.oui.sheet.v2.a.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.oui.sheet.v2.a
    public void setBodyView(View r3) {
        com.obric.oui.sheet.v2.a.C0991a.b((com.obric.oui.sheet.v2.a) ZeusTransformUtils.preCheckCast(this, com.obric.oui.sheet.v2.a.class, "com.obric.aiagent.plugin"), r3);
    }

    public void setCanceledOnTouchOutside(boolean r3) {
        com.obric.oui.sheet.v2.a.C0991a.c((com.obric.oui.sheet.v2.a) ZeusTransformUtils.preCheckCast(this, com.obric.oui.sheet.v2.a.class, "com.obric.aiagent.plugin"), r3);
    }

    public void setFooterButton(Integer r10, boolean r11, View.OnClickListener r12, Integer r13, boolean r14, View.OnClickListener r15) {
        View.OnClickListener r5 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r12, View.OnClickListener.class, "com.obric.aiagent.plugin");
        View.OnClickListener r8 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r15, View.OnClickListener.class, "com.obric.aiagent.plugin");
        com.obric.oui.sheet.v2.a.C0991a.a((com.obric.oui.sheet.v2.a) ZeusTransformUtils.preCheckCast(this, com.obric.oui.sheet.v2.a.class, "com.obric.aiagent.plugin"), r10, r11, r5, r13, r14, r8);
    }

    public void setFooterButton(String r10, boolean r11, View.OnClickListener r12, String r13, boolean r14, View.OnClickListener r15) {
        View.OnClickListener r5 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r12, View.OnClickListener.class, "com.obric.aiagent.plugin");
        View.OnClickListener r8 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r15, View.OnClickListener.class, "com.obric.aiagent.plugin");
        com.obric.oui.sheet.v2.a.C0991a.a((com.obric.oui.sheet.v2.a) ZeusTransformUtils.preCheckCast(this, com.obric.oui.sheet.v2.a.class, "com.obric.aiagent.plugin"), r10, r11, r5, r13, r14, r8);
    }

    public void setFooterView(View r3) {
        com.obric.oui.sheet.v2.a.C0991a.c((com.obric.oui.sheet.v2.a) ZeusTransformUtils.preCheckCast(this, com.obric.oui.sheet.v2.a.class, "com.obric.aiagent.plugin"), r3);
    }

    @Override // com.obric.oui.sheet.v2.a
    public void setHeader(OSheet.b r18, Integer r19, Integer r20, String r21, String r22, boolean r23, View.OnClickListener r24, View.OnClickListener r25, Integer r26, Integer r27, String r28, String r29, Integer r30, Integer r31) {
        View.OnClickListener r9 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r24, View.OnClickListener.class, "com.obric.aiagent.plugin");
        View.OnClickListener r10 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r25, View.OnClickListener.class, "com.obric.aiagent.plugin");
        com.obric.oui.sheet.v2.a.C0991a.a((com.obric.oui.sheet.v2.a) ZeusTransformUtils.preCheckCast(this, com.obric.oui.sheet.v2.a.class, "com.obric.aiagent.plugin"), r18, r19, r20, r21, r22, r23, r9, r10, r26, r27, r28, r29, r30, r31);
    }

    public void setHeaderView(View r3) {
        com.obric.oui.sheet.v2.a.C0991a.a((com.obric.oui.sheet.v2.a) ZeusTransformUtils.preCheckCast(this, com.obric.oui.sheet.v2.a.class, "com.obric.aiagent.plugin"), r3);
    }

    public void setHeightMode(OSheet.c r3) {
        com.obric.oui.sheet.v2.a.C0991a.a((com.obric.oui.sheet.v2.a) ZeusTransformUtils.preCheckCast(this, com.obric.oui.sheet.v2.a.class, "com.obric.aiagent.plugin"), r3);
    }

    public void setOnApplyWindowInsetsListener() {
        com.obric.oui.sheet.v2.a.C0991a.k((com.obric.oui.sheet.v2.a) ZeusTransformUtils.preCheckCast(this, com.obric.oui.sheet.v2.a.class, "com.obric.aiagent.plugin"));
    }

    public void setSheetBgColor(int r3) {
        com.obric.oui.sheet.v2.a.C0991a.a((com.obric.oui.sheet.v2.a) ZeusTransformUtils.preCheckCast(this, com.obric.oui.sheet.v2.a.class, "com.obric.aiagent.plugin"), r3);
    }

    public void unregisterConfigurationCallbackIfNeeded() {
        com.obric.oui.sheet.v2.a.C0991a.o((com.obric.oui.sheet.v2.a) ZeusTransformUtils.preCheckCast(this, com.obric.oui.sheet.v2.a.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.oui.sheet.v2.a
    public void updateFullWindowSize() {
        com.obric.oui.sheet.v2.a.C0991a.b((com.obric.oui.sheet.v2.a) ZeusTransformUtils.preCheckCast(this, com.obric.oui.sheet.v2.a.class, "com.obric.aiagent.plugin"));
    }

    public OSheetModal(Context r3, AttributeSet r4, int r5, boolean r6, boolean r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r9 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r8, "context");
        super(r8, r9, r5);
        boolean r10 = true;
        this.enableDimAnim = true;
        this.enableEnterAnim = true;
        this.heightStyle = OSheet.c.f36216b;
        this.isContentOverlayMode = r6;
        this.mCancelable = true;
        this.fullWindowSize = new Size(0, 0);
        this.removeOnDismiss = true;
        this.configurationCallback = (ComponentCallbacks) ZeusTransformUtils.preCheckCast(new OSheetModal$configurationCallback$1(this), ComponentCallbacks.class, "com.obric.aiagent.plugin");
        this.autoAddBodyPaddingTopWhenOverlay = true;
        this.bgColor = -1;
        if (r7 == true) goto L5;
    L11:
        setVisibility(8);
        View r11 = ZeusTransformUtils.inflate(LayoutInflater.from(r8), getContentLayoutResId(), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.aiagent.plugin"), false, "com.obric.aiagent.plugin");
        o.c(r11, "from(context)\n          …youtResId(), this, false)");
        setContentView(r11);
        View r12 = getContentView();
        FrameLayout.LayoutParams r13 = new FrameLayout.LayoutParams(-1, -2);
        r13.gravity = 80;
        x r14 = x.f38692a;
        addView(r12, (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r13, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        setupView(r8);
        if (ZeusTransformUtils.instanceOf(r8, p.class) == false) goto L14;
        p r15 = (p) ZeusTransformUtils.preCheckCast(r8, p.class, "com.obric.aiagent.plugin");
    L15:
        if (r15 == null) goto L22;
        i r16 = r15.getLifecycle();
        if (r16 == null) goto L23;
        r16.a((androidx.lifecycle.o) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this), androidx.lifecycle.o.class, "com.obric.aiagent.plugin"));
        return;
    L23:
        return;
    L22:
        return;
    L14:
        r15 = null;
        goto L15
    L5:
        if (k.a(r8) == true) goto L7;
    L9:
        r10 = false;
    L10:
        setEnableMaterial(r10);
        goto L11
    L7:
        if (l.d() == false) goto L9;
        goto L9
    }

    @Override // com.obric.oui.sheet.v2.a
    public Context getSheetContext() {
        Context r2 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r2, "context");
        return r2;
    }

    public final View getContentView() {
        View r0 = this.contentView;
        if (r0 == null) goto L5;
        return r0;
    L5:
        o.c("contentView");
        return null;
    }

    public final void setContentView(View r2) {
        o.e(r2, "<set-?>");
        this.contentView = r2;
    }

    @Override // com.obric.oui.sheet.v2.a
    public ViewGroup getScaffoldContainer() {
        ViewGroup r0 = this.scaffoldContainer;
        if (r0 == null) goto L5;
        return r0;
    L5:
        o.c("scaffoldContainer");
        return null;
    }

    @Override // com.obric.oui.sheet.v2.a
    public void setScaffoldContainer(ViewGroup r2) {
        o.e(r2, "<set-?>");
        this.scaffoldContainer = r2;
    }

    @Override // com.obric.oui.sheet.v2.a
    public View getDimView() {
        View r0 = this.dimView;
        if (r0 == null) goto L5;
        return r0;
    L5:
        o.c("dimView");
        return null;
    }

    public void setDimView(View r2) {
        o.e(r2, "<set-?>");
        this.dimView = r2;
    }

    @Override // com.obric.oui.sheet.v2.a
    public RadiusLayout getRootContainer() {
        RadiusLayout r0 = this.rootContainer;
        if (r0 == null) goto L5;
        return r0;
    L5:
        o.c("rootContainer");
        return null;
    }

    @Override // com.obric.oui.sheet.v2.a
    public void setRootContainer(RadiusLayout r2) {
        o.e(r2, "<set-?>");
        this.rootContainer = r2;
    }

    @Override // com.obric.oui.sheet.v2.a
    public FrameLayout getHeaderContainer() {
        FrameLayout r0 = this.headerContainer;
        if (r0 == null) goto L5;
        return r0;
    L5:
        o.c("headerContainer");
        return null;
    }

    @Override // com.obric.oui.sheet.v2.a
    public void setHeaderContainer(FrameLayout r2) {
        o.e(r2, "<set-?>");
        this.headerContainer = r2;
    }

    @Override // com.obric.oui.sheet.v2.a
    public FrameLayout getFooterContainer() {
        FrameLayout r0 = this.footerContainer;
        if (r0 == null) goto L5;
        return r0;
    L5:
        o.c("footerContainer");
        return null;
    }

    @Override // com.obric.oui.sheet.v2.a
    public void setFooterContainer(FrameLayout r2) {
        o.e(r2, "<set-?>");
        this.footerContainer = r2;
    }

    @Override // com.obric.oui.sheet.v2.a
    public FrameLayout getBodyContainer() {
        FrameLayout r0 = this.bodyContainer;
        if (r0 == null) goto L5;
        return r0;
    L5:
        o.c("bodyContainer");
        return null;
    }

    @Override // com.obric.oui.sheet.v2.a
    public void setBodyContainer(FrameLayout r2) {
        o.e(r2, "<set-?>");
        this.bodyContainer = r2;
    }

    public boolean getMClearDimFlag() {
        return this.mClearDimFlag;
    }

    public void setMClearDimFlag(boolean r1) {
        this.mClearDimFlag = r1;
    }

    public boolean getEnableDimAnim() {
        return this.enableDimAnim;
    }

    public void setEnableDimAnim(boolean r1) {
        this.enableDimAnim = r1;
    }

    @Override // com.obric.oui.sheet.v2.a
    public boolean getEnableEnterAnim() {
        return this.enableEnterAnim;
    }

    public void setEnableEnterAnim(boolean r1) {
        this.enableEnterAnim = r1;
    }

    @Override // com.obric.oui.sheet.v2.a
    public com.obric.oui.sheet.v2.c getScaffoldController() {
        com.obric.oui.sheet.v2.c r0 = this.scaffoldController;
        if (r0 == null) goto L5;
        return r0;
    L5:
        o.c("scaffoldController");
        return null;
    }

    @Override // com.obric.oui.sheet.v2.a
    public void setScaffoldController(com.obric.oui.sheet.v2.c r2) {
        o.e(r2, "<set-?>");
        this.scaffoldController = r2;
    }

    @Override // com.obric.oui.sheet.v2.a
    public OSheet.c getHeightStyle() {
        return this.heightStyle;
    }

    @Override // com.obric.oui.sheet.v2.a
    public void setHeightStyle(OSheet.c r2) {
        o.e(r2, "<set-?>");
        this.heightStyle = r2;
    }

    @Override // com.obric.oui.sheet.v2.a
    public boolean isContentOverlayMode() {
        return this.isContentOverlayMode;
    }

    public void setContentOverlayMode(boolean r1) {
        this.isContentOverlayMode = r1;
    }

    @Override // com.obric.oui.sheet.v2.a
    public boolean getIgnoreInsetBottom() {
        return this.ignoreInsetBottom;
    }

    @Override // com.obric.oui.sheet.v2.a
    public void setIgnoreInsetBottom(boolean r1) {
        this.ignoreInsetBottom = r1;
    }

    public boolean getMCancelable() {
        return this.mCancelable;
    }

    @Override // com.obric.oui.sheet.v2.a
    public void setMCancelable(boolean r1) {
        this.mCancelable = r1;
    }

    @Override // com.obric.oui.sheet.v2.a
    public int getUserWindowWidth() {
        return this.userWindowWidth;
    }

    public void setUserWindowWidth(int r1) {
        this.userWindowWidth = r1;
    }

    @Override // com.obric.oui.sheet.v2.a
    public int getUserWindowHeight() {
        return this.userWindowHeight;
    }

    public void setUserWindowHeight(int r1) {
        this.userWindowHeight = r1;
    }

    @Override // com.obric.oui.sheet.v2.a
    public Size getFullWindowSize() {
        return this.fullWindowSize;
    }

    @Override // com.obric.oui.sheet.v2.a
    public void setFullWindowSize(Size r2) {
        o.e(r2, "<set-?>");
        this.fullWindowSize = r2;
    }

    @Override // com.obric.oui.sheet.v2.a
    public com.obric.common.oea.foundation.animation.manager.d getRunningAnim() {
        return this.runningAnim;
    }

    @Override // com.obric.oui.sheet.v2.a
    public void setRunningAnim(com.obric.common.oea.foundation.animation.manager.d r1) {
        this.runningAnim = r1;
    }

    @Override // com.obric.oui.sheet.v2.a
    public boolean getShowing() {
        return this.showing;
    }

    public void setShowing(boolean r1) {
        this.showing = r1;
    }

    @Override // com.obric.oui.sheet.v2.a
    public boolean getEnableMaterial() {
        return this.enableMaterial;
    }

    public void setEnableMaterial(boolean r1) {
        this.enableMaterial = r1;
    }

    public Boolean getSystemInsetsAppearanceLightValue() {
        return this.systemInsetsAppearanceLightValue;
    }

    public void setSystemInsetsAppearanceLightValue(Boolean r1) {
        this.systemInsetsAppearanceLightValue = r1;
    }

    @Override // com.obric.oui.sheet.v2.a
    public boolean getConfigurationCallbackRegistered() {
        return this.configurationCallbackRegistered;
    }

    @Override // com.obric.oui.sheet.v2.a
    public void setConfigurationCallbackRegistered(boolean r1) {
        this.configurationCallbackRegistered = r1;
    }

    @Override // com.obric.oui.sheet.v2.a
    public ComponentCallbacks getConfigurationCallback() {
        return this.configurationCallback;
    }

    public void setConfigurationCallback(ComponentCallbacks r3) {
        ComponentCallbacks r4 = (ComponentCallbacks) ZeusTransformUtils.wrapperContextForParams(r3, ComponentCallbacks.class, "com.obric.aiagent.plugin");
        o.e(r4, "<set-?>");
        this.configurationCallback = r4;
    }

    @Override // com.obric.oui.sheet.v2.a
    public int getBodyContentPaddingTop() {
        return this.bodyContentPaddingTop;
    }

    @Override // com.obric.oui.sheet.v2.a
    public void setBodyContentPaddingTop(int r1) {
        this.bodyContentPaddingTop = r1;
    }

    @Override // com.obric.oui.sheet.v2.a
    public int getBodyContentPaddingBottom() {
        return this.bodyContentPaddingBottom;
    }

    @Override // com.obric.oui.sheet.v2.a
    public void setBodyContentPaddingBottom(int r1) {
        this.bodyContentPaddingBottom = r1;
    }

    @Override // com.obric.oui.sheet.v2.a
    public boolean getAutoAddBodyPaddingTopWhenOverlay() {
        return this.autoAddBodyPaddingTopWhenOverlay;
    }

    @Override // com.obric.oui.sheet.v2.a
    public void setAutoAddBodyPaddingTopWhenOverlay(boolean r1) {
        this.autoAddBodyPaddingTopWhenOverlay = r1;
    }

    @Override // com.obric.oui.sheet.v2.a
    public float getRootTransMoveStartX() {
        return this.rootTransMoveStartX;
    }

    @Override // com.obric.oui.sheet.v2.a
    public void setRootTransMoveStartX(float r1) {
        this.rootTransMoveStartX = r1;
    }

    @Override // com.obric.oui.sheet.v2.a
    public float getRootTransMoveStartY() {
        return this.rootTransMoveStartY;
    }

    @Override // com.obric.oui.sheet.v2.a
    public void setRootTransMoveStartY(float r1) {
        this.rootTransMoveStartY = r1;
    }

    @Override // com.obric.oui.sheet.v2.a
    public int getBgColor() {
        return this.bgColor;
    }

    @Override // com.obric.oui.sheet.v2.a
    public void setBgColor(int r1) {
        this.bgColor = r1;
    }

    @Override // com.obric.oui.sheet.v2.a
    public <T extends View> T getViewById(int r1) {
        T r0 = (T) getContentView().findViewById(r1);
        o.c(r0, "contentView.findViewById(id)");
        return r0;
    }

    public void setupView(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r4, "context");
        com.obric.oui.sheet.v2.a.C0991a.a((com.obric.oui.sheet.v2.a) ZeusTransformUtils.preCheckCast(this, com.obric.oui.sheet.v2.a.class, "com.obric.aiagent.plugin"), r4);
        updateMaterial();
    }

    @Override // com.obric.oui.sheet.v2.a
    public void updateMaterial() {
        applyMaterial(false);
        k.a((View) ZeusTransformUtils.preCheckCast(getRootContainer(), View.class, "com.obric.aiagent.plugin"), (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.oui.sheet.v2.a
    public void setupDimView(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        o.e(r5, "context");
        setDimView(new View(r5));
        addView(getDimView(), 0, (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new FrameLayout.LayoutParams(-1, -1), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
    }

    public final void setOnShowAnimListener(d r3) {
        this.showAnimListener = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
    }

    public final void setOnDismissAnimListener(c r3) {
        this.dismissAnimListener = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.aiagent.plugin");
    }

    public void setOverlayModeAutoBodyPaddingTopEnabled(boolean r3) {
        com.obric.oui.sheet.v2.a.C0991a.b((com.obric.oui.sheet.v2.a) ZeusTransformUtils.preCheckCast(this, com.obric.oui.sheet.v2.a.class, "com.obric.aiagent.plugin"), r3);
    }

    public final void setOnConfigurationListener(b r3) {
        this.configurationListener = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
    }

    public final void setOnCancelListener(a r3) {
        this.cancelListener = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.aiagent.plugin");
    }

    public final void setSystemInsetsAppearanceLight(Boolean r1) {
        setSystemInsetsAppearanceLightValue(r1);
    }

    public final void setRemoveOnDismiss(boolean r1) {
        this.removeOnDismiss = r1;
    }

    public final void setCancelable(boolean r1) {
        setMCancelable(r1);
    }

    public final void setPassThroughTouchOutside(boolean r1) {
        this.passThroughTouchOutside = r1;
    }

    public final void setClearDimFlag(boolean r1) {
        setMClearDimFlag(r1);
    }

    public final void show() {
        show(null);
    }

    public final void show(ViewGroup r5) {
        if (this.passThroughTouchOutside == false) goto L6;
        getDimView().setOnClickListener(null);
    L10:
        if (getShowing() == true) goto L18;
        ensureAttachedToParent(r5);
        setOnApplyWindowInsetsListener();
        getDimView().setAlpha(0.0f);
        if (getMClearDimFlag() == false) goto L14;
    L17:
        com.obric.oui.common.util.k.b(getDimView());
    L20:
        if (getEnableDimAnim() == false) goto L24;
        if (getEnableEnterAnim() == false) goto L24;
    L27:
        if (ZeusTransformUtils.instanceOf(getParent(), ViewGroup.class) == false) goto L29;
        ViewParent r6 = getParent();
        Objects.requireNonNull(r6, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) ZeusTransformUtils.preCheckCast(r6, ViewGroup.class, "com.obric.aiagent.plugin")).requestApplyInsets();
    L29:
        applySystemInsetsAppearance();
        if (getShowing() == true) goto L33;
        setShowing(true);
        setVisibility(0);
        setAlpha(0.0f);
        post(new $$Lambda$OSheetModal$K0aaz_pMmkAcUSSHFT9bZXgsKrE(this));
        interceptBackPressed();
        return;
    L33:
        return;
    L24:
        if (getMClearDimFlag() == true) goto L27;
        View r7 = getDimView();
        Context r2 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r2, "context");
        r7.setAlpha(com.obric.oui.sheet.v2.b.a(r2));
        goto L27
    L14:
        if (this.passThroughTouchOutside == true) goto L17;
        com.obric.oui.common.util.k.a(getDimView());
        goto L20
    L18:
        updateFullWindowSize();
        getScaffoldController().c(getFullWindowSize());
        goto L20
    L6:
        if (getMCancelable() == false) goto L8;
        getDimView().setOnClickListener(new $$Lambda$OSheetModal$mg_jy21wVoJ9ExL6GtPywsJnqv4(this));
        goto L10
    L8:
        getDimView().setOnClickListener(null);
        goto L10
    }

    /* JADX INFO: renamed from: show$lambda-1, reason: not valid java name */
    private static final void m1178show$lambda1(OSheetModal r0, View r1) {
        o.e(r0, "this$0");
        r0.cancel();
    }

    /* JADX INFO: renamed from: show$lambda-2, reason: not valid java name */
    private static final void m1179show$lambda2(OSheetModal r1) {
        o.e(r1, "this$0");
        r1.setAlpha(1.0f);
        r1.onPostShow();
        r1.performEnterAnimation();
    }

    private final void interceptBackPressed() {
        com.obric.oui.window.a r0 = com.obric.oui.window.a.f36851a;
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r1, "context");
        Activity r2 = (Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.getActivity(r1), "com.obric.aiagent.plugin"), Activity.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L10;
        final Window.Callback r3 = ZeusTransformUtils.getWindow(r2, "com.obric.aiagent.plugin").getCallback();
        if (r3 != null) goto L8;
        return;
    L8:
        this.originalWindowCallback = r3;
        this.myWindowCallback = (Window.Callback) ZeusTransformUtils.preCheckCast(new OSheetModal$interceptBackPressed$1$1(r3, this), Window.Callback.class, "com.obric.aiagent.plugin");
        ZeusTransformUtils.getWindow(r2, "com.obric.aiagent.plugin").setCallback(this.myWindowCallback);
        return;
    }

    private final void restoreWindowCallback() {
        com.obric.oui.window.a r0 = com.obric.oui.window.a.f36851a;
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r1, "context");
        Activity r2 = (Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.getActivity(r1), "com.obric.aiagent.plugin"), Activity.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L6;
        return;
    L6:
        if (ZeusTransformUtils.getWindow(r2, "com.obric.aiagent.plugin").getCallback() == this.myWindowCallback) goto L8;
    L10:
        this.originalWindowCallback = null;
        this.myWindowCallback = null;
        return;
    L8:
        if (this.originalWindowCallback == null) goto L10;
        ZeusTransformUtils.getWindow(r2, "com.obric.aiagent.plugin").setCallback(this.originalWindowCallback);
        goto L10
    }

    public final void dismiss() {
        if (getShowing() == true) goto L5;
        return;
    L5:
        removeOnApplyWindowInsetsListener();
        com.obric.oui.sheet.v2.a.C0991a.a((com.obric.oui.sheet.v2.a) ZeusTransformUtils.preCheckCast(this, com.obric.oui.sheet.v2.a.class, "com.obric.aiagent.plugin"), 0.0f, 1, null);
    }

    public final boolean cancel() {
        if (getShowing() == true) goto L5;
        return false;
    L5:
        if (getMCancelable() == false) goto L15;
        a r0 = this.cancelListener;
        if (r0 == null) goto L11;
        r0.a(this);
    L11:
        dismiss();
        return true;
    L15:
        return false;
    }

    public final boolean onBackPressed() {
        if (getShowing() == true) goto L5;
        return false;
    L5:
        if (getMCancelable() == false) goto L10;
        cancel();
        return true;
    L10:
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        registerConfigurationCallbackIfNeeded();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        unregisterConfigurationCallbackIfNeeded();
        super.onDetachedFromWindow();
        restoreWindowCallback();
    }

    private final void applySystemInsetsAppearance() {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        Integer r3 = null;
        if (ZeusTransformUtils.instanceOf(r0, Activity.class) == false) goto L5;
        Activity r1 = (Activity) ZeusTransformUtils.preCheckCast(r0, Activity.class, "com.obric.aiagent.plugin");
    L6:
        if (r1 != null) goto L8;
        Window r2 = null;
    L9:
        if (r2 != null) goto L11;
        return;
    L11:
        Boolean r4 = getSystemInsetsAppearanceLightValue();
        int r5 = 0;
        if (r4 == null) goto L14;
        boolean r6 = r4.booleanValue();
    L19:
        if (Build.VERSION.SDK_INT < 30) goto L48;
        if (this.originalStatusBarAppearance != null) goto L28;
        WindowInsetsController r7 = r2.getInsetsController();
        if (r7 != null) goto L25;
        Integer r8 = null;
    L26:
        this.originalStatusBarAppearance = r8;
        goto L28
    L25:
        r8 = Integer.valueOf(r7.getSystemBarsAppearance() & 8);
    L28:
        if (this.originalNavigationBarAppearance != null) goto L34;
        WindowInsetsController r9 = r2.getInsetsController();
        if (r9 == null) goto L33;
        r3 = Integer.valueOf(r9.getSystemBarsAppearance() & 16);
    L33:
        this.originalNavigationBarAppearance = r3;
    L34:
        WindowInsetsController r10 = r2.getInsetsController();
        if (r10 == null) goto L41;
        if (r6 == false) goto L39;
        int r11 = 8;
    L40:
        r10.setSystemBarsAppearance(r11, 8);
        goto L41
    L39:
        r11 = 0;
    L41:
        WindowInsetsController r12 = r2.getInsetsController();
        if (r12 == null) goto L59;
        if (r6 == false) goto L46;
        r5 = 16;
    L46:
        r12.setSystemBarsAppearance(r5, 16);
        return;
    L59:
        return;
    L48:
        if (Build.VERSION.SDK_INT >= 23) goto L50;
        return;
    L50:
        if (this.originalSystemUiVisibility != null) goto L52;
        this.originalSystemUiVisibility = Integer.valueOf(r2.getDecorView().getSystemUiVisibility());
    L52:
        if (r6 == false) goto L54;
        r2.getDecorView().setSystemUiVisibility(r2.getDecorView().getSystemUiVisibility() | 8192);
        return;
    L54:
        r2.getDecorView().setSystemUiVisibility(r2.getDecorView().getSystemUiVisibility() & (-8193));
        return;
    L14:
        if ((ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getConfiguration().uiMode & 48) == 32) goto L16;
        r6 = true;
        goto L19
    L16:
        r6 = false;
        goto L19
    L8:
        r2 = ZeusTransformUtils.getWindow(r1, "com.obric.aiagent.plugin");
        goto L9
    L5:
        r1 = null;
        goto L6
    }

    static /* synthetic */ void ensureAttachedToParent$default(OSheetModal r0, ViewGroup r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        r0.ensureAttachedToParent(r1);
    }

    private final void ensureAttachedToParent(ViewGroup r3) {
        if (getParent() == null) goto L5;
        return;
    L5:
        if (r3 != null) goto L7;
        r3 = findDecorViewParent();
    L7:
        if (r3 != null) goto L9;
        return;
    L9:
        r3.addView((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), new ViewGroup.LayoutParams(-1, -1));
    }

    private final ViewGroup findDecorViewParent() {
        Object r0 = ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
    L3:
        Context r1 = (Context) r0;
        if (ZeusTransformUtils.instanceOf(r1, ContextWrapper.class) == false) goto L16;
        if (ZeusTransformUtils.instanceOf(r1, Activity.class) == true) goto L7;
        r0 = ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((ContextWrapper) ZeusTransformUtils.preCheckCast(r1, ContextWrapper.class, "com.obric.aiagent.plugin")).getBaseContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        goto L3
    L7:
        Window r4 = ZeusTransformUtils.getWindow((Activity) ZeusTransformUtils.preCheckCast(r1, Activity.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
        if (r4 != null) goto L10;
        View r5 = null;
    L12:
        if (ZeusTransformUtils.instanceOf(r5, ViewGroup.class) == true) goto L14;
        return null;
    L14:
        return (ViewGroup) ZeusTransformUtils.preCheckCast(r5, ViewGroup.class, "com.obric.aiagent.plugin");
    L10:
        r5 = r4.getDecorView();
        goto L12
    L16:
        Context r6 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r6, Activity.class) == false) goto L19;
        Activity r7 = (Activity) ZeusTransformUtils.preCheckCast(r6, Activity.class, "com.obric.aiagent.plugin");
    L20:
        if (r7 != null) goto L22;
    L21:
        View r8 = null;
    L27:
        if (ZeusTransformUtils.instanceOf(r8, ViewGroup.class) == true) goto L29;
        return null;
    L29:
        return (ViewGroup) ZeusTransformUtils.preCheckCast(r8, ViewGroup.class, "com.obric.aiagent.plugin");
    L22:
        Window r9 = ZeusTransformUtils.getWindow(r7, "com.obric.aiagent.plugin");
        if (r9 == null) goto L21;
        r8 = r9.getDecorView();
        goto L27
    L19:
        r7 = null;
        goto L20
    }

    @Override // com.obric.oui.sheet.v2.a
    public boolean needDimAnim() {
        if (getEnableDimAnim() == true) goto L5;
    L7:
        return false;
    L5:
        if (getMClearDimFlag() == true) goto L7;
        return true;
    }

    @Override // com.obric.oui.sheet.v2.a
    public void onShowAnimStart() {
        d r0 = this.showAnimListener;
        if (r0 == null) goto L7;
        r0.a(this);
        return;
    }

    @Override // com.obric.oui.sheet.v2.a
    public void onShowAnimEnd() {
        d r0 = this.showAnimListener;
        if (r0 == null) goto L7;
        r0.b(this);
        return;
    }

    @Override // com.obric.oui.sheet.v2.a
    public void onDismissAnimStart() {
        c r0 = this.dismissAnimListener;
        if (r0 == null) goto L7;
        r0.a(this);
        return;
    }

    @Override // com.obric.oui.sheet.v2.a
    public void onDismissAnimEnd() {
        c r0 = this.dismissAnimListener;
        if (r0 == null) goto L7;
        r0.b(this);
        return;
    }

    @Override // com.obric.oui.sheet.v2.a
    public void onDismissComplete() {
        setShowing(false);
        setVisibility(8);
        restoreSystemInsetsAppearance();
        restoreWindowCallback();
        if (this.removeOnDismiss == false) goto L12;
        ViewParent r0 = getParent();
        if (ZeusTransformUtils.instanceOf(r0, ViewGroup.class) == false) goto L7;
        ViewGroup r1 = (ViewGroup) ZeusTransformUtils.preCheckCast(r0, ViewGroup.class, "com.obric.aiagent.plugin");
    L8:
        if (r1 == null) goto L13;
        r1.removeView((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"));
        return;
    L13:
        return;
    L7:
        r1 = null;
        goto L8
    }

    private final void restoreSystemInsetsAppearance() {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r0, Activity.class) == false) goto L5;
        Activity r1 = (Activity) ZeusTransformUtils.preCheckCast(r0, Activity.class, "com.obric.aiagent.plugin");
    L6:
        if (r1 != null) goto L8;
        Window r2 = null;
    L9:
        if (r2 != null) goto L12;
        return;
    L12:
        if (Build.VERSION.SDK_INT < 30) goto L29;
        Integer r3 = this.originalStatusBarAppearance;
        if (r3 == null) goto L20;
        int r4 = ((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.aiagent.plugin")).intValue();
        WindowInsetsController r5 = r2.getInsetsController();
        if (r5 == null) goto L20;
        r5.setSystemBarsAppearance(r4, 8);
    L20:
        Integer r6 = this.originalNavigationBarAppearance;
        if (r6 == null) goto L27;
        int r7 = ((Number) ZeusTransformUtils.preCheckCast(r6, Number.class, "com.obric.aiagent.plugin")).intValue();
        WindowInsetsController r8 = r2.getInsetsController();
        if (r8 == null) goto L27;
        r8.setSystemBarsAppearance(r7, 16);
    L27:
        this.originalStatusBarAppearance = null;
        this.originalNavigationBarAppearance = null;
        return;
    L29:
        if (Build.VERSION.SDK_INT < 23) goto L37;
        Integer r9 = this.originalSystemUiVisibility;
        if (r9 == null) goto L34;
        r2.getDecorView().setSystemUiVisibility(((Number) ZeusTransformUtils.preCheckCast(r9, Number.class, "com.obric.aiagent.plugin")).intValue());
    L34:
        this.originalSystemUiVisibility = null;
        return;
    L37:
        return;
    L8:
        r2 = ZeusTransformUtils.getWindow(r1, "com.obric.aiagent.plugin");
        goto L9
    L5:
        r1 = null;
        goto L6
    }
}
