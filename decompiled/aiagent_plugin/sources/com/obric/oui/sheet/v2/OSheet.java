package com.obric.oui.sheet.v2;

import android.R;
import android.app.Dialog;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.oui.dialog.alert.view.RadiusLayout;
import com.obric.oui.material.k;
import com.obric.oui.material.l;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.Objects;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: OSheet.kt */
/* JADX INFO: loaded from: classes4.dex */
public class OSheet extends Dialog implements com.obric.oui.sheet.v2.a {
    public static final a Companion = null;
    public static final String TAG = "OInsetSheet";
    private boolean autoAddBodyPaddingTopWhenOverlay;
    private int bgColor;
    public FrameLayout bodyContainer;
    private int bodyContentPaddingBottom;
    private int bodyContentPaddingTop;
    private ComponentCallbacks configurationCallback;
    private boolean configurationCallbackRegistered;
    private com.obric.oui.dialog.a.InterfaceC0947a configurationListener;
    private boolean decorForceFullScreen;
    private boolean decorFullScreen;
    public View dimView;
    private com.obric.oui.dialog.a.b dismissAnimListener;
    private boolean doShowAnimation;
    private boolean enableDimAnim;
    private boolean enableEnterAnim;
    private boolean enableMaterial;
    public FrameLayout footerContainer;
    private Size fullWindowSize;
    public FrameLayout headerContainer;
    private c heightStyle;
    private boolean hideFirstFrame;
    private boolean ignoreInsetBottom;
    private boolean isContentOverlayMode;
    private boolean mCancelable;
    private boolean mClearDimFlag;
    public RadiusLayout rootContainer;
    private float rootTransMoveStartX;
    private float rootTransMoveStartY;
    private com.obric.common.oea.foundation.animation.manager.d runningAnim;
    public ViewGroup scaffoldContainer;
    public com.obric.oui.sheet.v2.c scaffoldController;
    private com.obric.oui.dialog.a.c showAnimListener;
    private boolean showing;
    private Boolean systemInsetsAppearanceLightValue;
    private int userWindowHeight;
    private int userWindowWidth;

    /* JADX INFO: compiled from: OSheet.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: OSheet.kt */
    public static final enum b extends Enum<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f36210a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f36211b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f36212c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final b f36213d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final b f36214e = null;
        public static final b f = null;
        private static final /* synthetic */ b[] g = null;

        private static final /* synthetic */ b[] a() {
            return new b[]{f36210a, f36211b, f36212c, f36213d, f36214e, f};
        }

        public static b valueOf(String r2) {
            return (b) ZeusTransformUtils.preCheckCast(Enum.valueOf(b.class, r2), b.class, "com.obric.aiagent.plugin");
        }

        public static b[] values() {
            return (b[]) ZeusTransformUtils.preCheckCast(g.clone(), b[].class, "com.obric.aiagent.plugin");
        }

        private b(String r1, int r2) {
            super(r1, r2);
        }

        static {
            f36210a = new b("CUSTOM", 0);
            f36211b = new b("PAGE", 1);
            f36212c = new b("ACTION", 2);
            f36213d = new b("MODAL", 3);
            f36214e = new b("ONLY_TITLE", 4);
            f = new b("PAGE_WITH_CLOSE", 5);
            g = a();
        }
    }

    /* JADX INFO: compiled from: OSheet.kt */
    public static final enum c extends Enum<c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f36215a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final c f36216b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final /* synthetic */ c[] f36217c = null;

        private static final /* synthetic */ c[] a() {
            return new c[]{f36215a, f36216b};
        }

        public static c valueOf(String r2) {
            return (c) ZeusTransformUtils.preCheckCast(Enum.valueOf(c.class, r2), c.class, "com.obric.aiagent.plugin");
        }

        public static c[] values() {
            return (c[]) ZeusTransformUtils.preCheckCast(f36217c.clone(), c[].class, "com.obric.aiagent.plugin");
        }

        private c(String r1, int r2) {
            super(r1, r2);
        }

        static {
            f36215a = new c("FULL_HEIGHT", 0);
            f36216b = new c("WRAP_HEIGHT", 1);
            f36217c = a();
        }
    }

    static {
        Companion = new a(null);
    }

    public OSheet(Context r9) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        this(r1, 0, 0, false, false, 30, null);
    }

    public OSheet(Context r9, int r10) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        this(r1, r10, 0, false, false, 28, null);
    }

    public OSheet(Context r9, int r10, int r11) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        this(r1, r10, r11, false, false, 24, null);
    }

    public OSheet(Context r9, int r10, int r11, boolean r12) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        this(r1, r10, r11, r12, false, 16, null);
    }

    public static /* synthetic */ int access$000(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$dcpCL1sVjB328hijd3vWqjEcBbk(OSheet r0, View r1) {
        m1177show$lambda1(r0, r1);
    }

    public static /* synthetic */ void lambda$y2QNsFDOZCi77fSVAJcdekGQoFY(OSheet r0) {
        m1176onStart$lambda4(r0);
    }

    public /* synthetic */ OSheet(Context r4, int r5, int r6, boolean r7, boolean r8, int r9, h r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        boolean r0 = false;
        if ((r9 & 2) == 0) goto L5;
        int r12 = 0;
    L7:
        if ((r9 & 4) == 0) goto L9;
        int r1 = 0;
    L11:
        if ((r9 & 8) != 0) goto L15;
        r0 = r7;
    L15:
        if ((r9 & 16) == 0) goto L17;
        r8 = true;
    L17:
        this(r11, r12, r1, r0, r8);
        return;
    L9:
        r1 = r6;
        goto L11
    L5:
        r12 = r5;
        goto L7
    }

    public static final /* synthetic */ com.obric.oui.dialog.a.InterfaceC0947a access$getConfigurationListener$p(OSheet r0) {
        return r0.configurationListener;
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
    public void setHeader(b r18, Integer r19, Integer r20, String r21, String r22, boolean r23, View.OnClickListener r24, View.OnClickListener r25, Integer r26, Integer r27, String r28, String r29, Integer r30, Integer r31) {
        View.OnClickListener r9 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r24, View.OnClickListener.class, "com.obric.aiagent.plugin");
        View.OnClickListener r10 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r25, View.OnClickListener.class, "com.obric.aiagent.plugin");
        com.obric.oui.sheet.v2.a.C0991a.a((com.obric.oui.sheet.v2.a) ZeusTransformUtils.preCheckCast(this, com.obric.oui.sheet.v2.a.class, "com.obric.aiagent.plugin"), r18, r19, r20, r21, r22, r23, r9, r10, r26, r27, r28, r29, r30, r31);
    }

    public void setHeaderView(View r3) {
        com.obric.oui.sheet.v2.a.C0991a.a((com.obric.oui.sheet.v2.a) ZeusTransformUtils.preCheckCast(this, com.obric.oui.sheet.v2.a.class, "com.obric.aiagent.plugin"), r3);
    }

    public void setHeightMode(c r3) {
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

    public OSheet(Context r3, int r4, int r5, boolean r6, boolean r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r8, "context");
        super(r8);
        this.enableDimAnim = true;
        this.enableEnterAnim = true;
        this.heightStyle = c.f36216b;
        this.isContentOverlayMode = r6;
        this.decorForceFullScreen = true;
        this.mCancelable = true;
        this.userWindowHeight = r4;
        boolean r9 = false;
        this.fullWindowSize = new Size(0, 0);
        this.autoAddBodyPaddingTopWhenOverlay = true;
        this.configurationCallback = (ComponentCallbacks) ZeusTransformUtils.preCheckCast(new OSheet$configurationCallback$1(this), ComponentCallbacks.class, "com.obric.aiagent.plugin");
        this.bgColor = -1;
        if (r7 == true) goto L5;
    L10:
        Window r10 = getWindow();
        if (r10 == null) goto L14;
        r10.requestFeature(1);
    L14:
        setContentView(getContentLayoutResId());
        setupView(r8);
        return;
    L5:
        if (k.a(r8) == true) goto L7;
    L9:
        setEnableMaterial(r9);
        goto L10
    L7:
        if (l.d() == false) goto L9;
        r9 = true;
        goto L9
    }

    @Override // com.obric.oui.sheet.v2.a
    public Context getSheetContext() {
        Context r2 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r2, "context");
        return r2;
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
    public c getHeightStyle() {
        return this.heightStyle;
    }

    @Override // com.obric.oui.sheet.v2.a
    public void setHeightStyle(c r2) {
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

    public Boolean getSystemInsetsAppearanceLightValue() {
        return this.systemInsetsAppearanceLightValue;
    }

    public void setSystemInsetsAppearanceLightValue(Boolean r1) {
        this.systemInsetsAppearanceLightValue = r1;
    }

    public boolean getIgnoreInsetBottom() {
        return this.ignoreInsetBottom;
    }

    public void setIgnoreInsetBottom(boolean r1) {
        this.ignoreInsetBottom = r1;
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
    public boolean getEnableMaterial() {
        return this.enableMaterial;
    }

    public void setEnableMaterial(boolean r1) {
        this.enableMaterial = r1;
    }

    @Override // com.obric.oui.sheet.v2.a
    public boolean getShowing() {
        return this.showing;
    }

    public void setShowing(boolean r1) {
        this.showing = r1;
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

    public final boolean getDoShowAnimation() {
        return this.doShowAnimation;
    }

    public final void setDoShowAnimation(boolean r1) {
        this.doShowAnimation = r1;
    }

    public final int getMaxRootHeight() {
        return getScaffoldController().c();
    }

    public final void setMaxRootHeight(int r2) {
        getScaffoldController().a(r2);
        updateRootHeight();
    }

    public final void setFullScreen(boolean r2) {
        if (this.decorForceFullScreen == r2) goto L6;
        this.decorForceFullScreen = r2;
        updateRootSize();
        return;
    }

    public final void setOnShowAnimListener(com.obric.oui.dialog.a.c r3) {
        this.showAnimListener = (com.obric.oui.dialog.a.c) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.oui.dialog.a.c.class, "com.obric.aiagent.plugin");
    }

    public final void setOnDismissAnimListener(com.obric.oui.dialog.a.b r3) {
        this.dismissAnimListener = (com.obric.oui.dialog.a.b) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.oui.dialog.a.b.class, "com.obric.aiagent.plugin");
    }

    public void setOverlayModeAutoBodyPaddingTopEnabled(boolean r3) {
        com.obric.oui.sheet.v2.a.C0991a.b((com.obric.oui.sheet.v2.a) ZeusTransformUtils.preCheckCast(this, com.obric.oui.sheet.v2.a.class, "com.obric.aiagent.plugin"), r3);
    }

    public final void setOnConfigurationListener(com.obric.oui.dialog.a.InterfaceC0947a r3) {
        this.configurationListener = (com.obric.oui.dialog.a.InterfaceC0947a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.oui.dialog.a.InterfaceC0947a.class, "com.obric.aiagent.plugin");
    }

    public final void setSystemInsetsAppearanceLight(Boolean r1) {
        setSystemInsetsAppearanceLightValue(r1);
    }

    private final void updateRootSize() {
        updateRootWidth();
        updateRootHeight();
    }

    private final void updateRootWidth() {
        getScaffoldController().f();
    }

    private final void updateRootHeight() {
        getScaffoldController().g();
    }

    private final void setupSystemInsets(Window r3) {
        if (Build.VERSION.SDK_INT < 29) goto L7;
        if (r3 == null) goto L7;
        r3.setNavigationBarContrastEnforced(false);
    L7:
        if (r3 == null) goto L10;
        r3.clearFlags(134217728);
    L10:
        if (r3 == null) goto L13;
        r3.addFlags(Integer.MIN_VALUE);
    L13:
        if (r3 == null) goto L17;
        r3.setNavigationBarColor(0);
    L17:
        if (Build.VERSION.SDK_INT < 30) goto L25;
        if (r3 == null) goto L21;
        r3.setDecorFitsSystemWindows(false);
    L21:
        if (r3 == null) goto L26;
        r3.setNavigationBarDividerColor(0);
        return;
    L26:
        return;
    }

    private final void setupSystemInsetsAppearance(Window r5) {
        Boolean r0 = getSystemInsetsAppearanceLightValue();
        int r1 = 0;
        if (r0 == null) goto L5;
        boolean r4 = r0.booleanValue();
    L10:
        if (Build.VERSION.SDK_INT < 30) goto L31;
        if (r5 == null) goto L21;
        WindowInsetsController r2 = r5.getInsetsController();
        if (r2 == null) goto L21;
        if (r4 == false) goto L19;
        int r3 = 8;
    L20:
        r2.setSystemBarsAppearance(r3, 8);
        goto L21
    L19:
        r3 = 0;
    L21:
        if (r5 == null) goto L41;
        WindowInsetsController r6 = r5.getInsetsController();
        if (r6 != null) goto L27;
        return;
    L27:
        if (r4 == false) goto L29;
        r1 = 16;
    L29:
        r6.setSystemBarsAppearance(r1, 16);
        return;
    L41:
        return;
    L31:
        if (Build.VERSION.SDK_INT < 23) goto L39;
        if (r5 == null) goto L43;
        if (r4 == false) goto L36;
        r5.getDecorView().setSystemUiVisibility(r5.getDecorView().getSystemUiVisibility() | 8192);
        return;
    L36:
        r5.getDecorView().setSystemUiVisibility(r5.getDecorView().getSystemUiVisibility() & (-8193));
        return;
    L43:
        return;
    L39:
        return;
    L5:
        if ((ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getConfiguration().uiMode & 48) == 32) goto L7;
        r4 = true;
        goto L10
    L7:
        r4 = false;
        goto L10
    }

    public final void setClearDimFlag(boolean r1) {
        setMClearDimFlag(r1);
    }

    @Override // com.obric.oui.sheet.v2.a
    public <T extends View> T getViewById(int r1) {
        T r0 = (T) findViewById(r1);
        o.c(r0, "findViewById(id)");
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
        applyMaterial(true);
        k.a((View) ZeusTransformUtils.preCheckCast(getRootContainer(), View.class, "com.obric.aiagent.plugin"), getDimView());
    }

    @Override // com.obric.oui.sheet.v2.a
    public void setupDimView(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        o.e(r5, "context");
        setDimView(new View(r5));
        if (ZeusTransformUtils.instanceOf(getRootContainer().getParent(), ViewGroup.class) == false) goto L6;
        ViewParent r6 = getRootContainer().getParent();
        Objects.requireNonNull(r6, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) ZeusTransformUtils.preCheckCast(r6, ViewGroup.class, "com.obric.aiagent.plugin")).addView(getDimView(), 0, new ViewGroup.LayoutParams(-1, -1));
        return;
    }

    private final boolean useWindowDimInternal() {
        return !this.decorForceFullScreen;
    }

    @Override // android.app.Dialog
    public void show() {
        if (getShowing() == false) goto L5;
        updateFullWindowSize();
        getScaffoldController().c(getFullWindowSize());
    L9:
        super.show();
        setOnApplyWindowInsetsListener();
        Window r0 = getWindow();
        if (r0 == null) goto L49;
        r0.setSoftInputMode(48);
        r0.setBackgroundDrawableResource(R.color.transparent);
        setupSystemInsets(r0);
        setupSystemInsetsAppearance(r0);
        if (getMClearDimFlag() == false) goto L15;
        r0.clearFlags(2);
    L16:
        Context r2 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r2, "context");
        float r3 = com.obric.oui.sheet.v2.b.a(r2);
        WindowManager.LayoutParams r4 = r0.getAttributes();
        if (getHeightStyle() != c.f36215a) goto L19;
    L22:
        boolean r5 = true;
    L23:
        this.decorFullScreen = r5;
        boolean r6 = useWindowDimInternal();
        if (r6 == false) goto L26;
    L29:
        com.obric.oui.common.util.k.b(getDimView());
    L31:
        if (getShowing() == true) goto L34;
        r4.dimAmount = 0.0f;
        getDimView().setAlpha(0.0f);
    L34:
        if (needDimAnim() == true) goto L36;
    L37:
        if (r6 == false) goto L39;
        r4.dimAmount = r3;
    L41:
        if (this.decorFullScreen == false) goto L43;
        int r7 = -1;
    L44:
        r0.setLayout(-1, r7);
        if (this.decorFullScreen == false) goto L47;
        r4.setFitInsetsSides(0);
    L48:
        r4.layoutInDisplayCutoutMode = 3;
        r4.gravity = 80;
        r4.windowAnimations = 0;
        r0.setAttributes(r4);
        goto L49
    L47:
        r4.setFitInsetsSides(WindowInsets.Side.all() ^ 8);
        goto L48
    L43:
        r7 = -2;
        goto L44
    L39:
        r4.dimAmount = 0.0f;
        getDimView().setAlpha(r3);
        goto L41
    L36:
        if (getEnableEnterAnim() == true) goto L41;
    L26:
        if (getMClearDimFlag() == true) goto L29;
        com.obric.oui.common.util.k.a(getDimView());
        goto L31
    L19:
        if (this.decorForceFullScreen == true) goto L22;
        r5 = false;
        goto L23
    L15:
        r0.addFlags(2);
    L49:
        setShowing(true);
        return;
    L5:
        if (getMCancelable() == false) goto L7;
        getDimView().setOnClickListener(new $$Lambda$OSheet$dcpCL1sVjB328hijd3vWqjEcBbk(this));
        goto L9
    L7:
        getDimView().setOnClickListener(null);
        goto L9
    }

    /* JADX INFO: renamed from: show$lambda-1, reason: not valid java name */
    private static final void m1177show$lambda1(OSheet r0, View r1) {
        o.e(r0, "this$0");
        r0.dismiss();
    }

    @Override // android.app.Dialog
    public void setCanceledOnTouchOutside(boolean r1) {
        super.setCanceledOnTouchOutside(r1);
        setMCancelable(r1);
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle r1) {
        super.onCreate(r1);
        if (r1 == null) goto L5;
        return;
    L5:
        if (getEnableEnterAnim() == false) goto L9;
        getRootContainer().setAlpha(0.0f);
        return;
    }

    @Override // android.app.Dialog
    public void onStart() {
        super.onStart();
        registerConfigurationCallbackIfNeeded();
        calculateBodyMaxHeight();
        getRootContainer().post(new $$Lambda$OSheet$y2QNsFDOZCi77fSVAJcdekGQoFY(this));
    }

    /* JADX INFO: renamed from: onStart$lambda-4, reason: not valid java name */
    private static final void m1176onStart$lambda4(OSheet r2) {
        o.e(r2, "this$0");
        r2.onPostShow();
        if (r2.doShowAnimation == true) goto L6;
        r2.getRootContainer().setAlpha(0.0f);
        r2.doShowAnimation = true;
        r2.performEnterAnimation();
        return;
    }

    @Override // android.app.Dialog
    public void onStop() {
        unregisterConfigurationCallbackIfNeeded();
        super.onStop();
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        removeOnApplyWindowInsetsListener();
        com.obric.oui.sheet.v2.a.C0991a.a((com.obric.oui.sheet.v2.a) ZeusTransformUtils.preCheckCast(this, com.obric.oui.sheet.v2.a.class, "com.obric.aiagent.plugin"), 0.0f, 1, null);
        this.doShowAnimation = false;
    }

    private final void originDismiss() {
    L6:
        e = move-exception;
        INVOKESTATIC_com_obric_oui_sheet_v2_OSheet_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("OSheet", "origin Dismiss exception!", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return;
    L3:
        if (isShowing() == false) goto L11;
        super.dismiss();     // Catch: Exception -> L6
        return;
    }

    public final void dismissImmediately() {
        setRunningAnim(null);     // Catch: Exception -> L7
        setOnDismissListener(null);     // Catch: Exception -> L7
        if (isShowing() == false) goto L12;
        super.dismiss();     // Catch: Exception -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        INVOKESTATIC_com_obric_oui_sheet_v2_OSheet_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("OSheet", "dismissImmediately exception!", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    }

    public final void setChildToParent(ViewGroup r1, View r2) {
        getScaffoldController().a(r1, r2);
    }

    public final void addChildToParent(ViewGroup r1, View r2) {
        getScaffoldController().b(r1, r2);
    }

    public final void forceHideFirstFrame() {
        this.hideFirstFrame = true;
    }

    @Override // com.obric.oui.sheet.v2.a
    public Window windowForAnim() {
        return getWindow();
    }

    @Override // com.obric.oui.sheet.v2.a
    public boolean useWindowDim() {
        return useWindowDimInternal();
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
        com.obric.oui.dialog.a.c r0 = this.showAnimListener;
        if (r0 == null) goto L7;
        r0.a((Dialog) ZeusTransformUtils.preCheckCast(this, Dialog.class, "com.obric.aiagent.plugin"));
        return;
    }

    @Override // com.obric.oui.sheet.v2.a
    public void onShowAnimEnd() {
        com.obric.oui.dialog.a.c r0 = this.showAnimListener;
        if (r0 == null) goto L7;
        r0.b((Dialog) ZeusTransformUtils.preCheckCast(this, Dialog.class, "com.obric.aiagent.plugin"));
        return;
    }

    @Override // com.obric.oui.sheet.v2.a
    public void onDismissAnimStart() {
        com.obric.oui.dialog.a.b r0 = this.dismissAnimListener;
        if (r0 == null) goto L7;
        r0.a((Dialog) ZeusTransformUtils.preCheckCast(this, Dialog.class, "com.obric.aiagent.plugin"));
        return;
    }

    @Override // com.obric.oui.sheet.v2.a
    public void onDismissAnimEnd() {
        com.obric.oui.dialog.a.b r0 = this.dismissAnimListener;
        if (r0 == null) goto L7;
        r0.b((Dialog) ZeusTransformUtils.preCheckCast(this, Dialog.class, "com.obric.aiagent.plugin"));
        return;
    }

    @Override // com.obric.oui.sheet.v2.a
    public void onDismissComplete() {
        originDismiss();
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_oui_sheet_v2_OSheet_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }
}
