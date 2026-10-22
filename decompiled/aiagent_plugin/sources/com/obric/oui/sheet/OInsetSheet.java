package com.obric.oui.sheet;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.aiagent.plugin.R;
import com.obric.oui.common.util.k;
import com.obric.oui.dialog.alert.view.RadiusLayout;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.h.b.p;
import d.l.n;
import d.x;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: OInsetSheet.kt */
/* JADX INFO: loaded from: classes4.dex */
public class OInsetSheet extends Dialog {
    public static final a Companion = null;
    private static final int HORIZONTAL_MAX_CONTENT_HEIGHT = 244;
    private static final int HORIZONTAL_MAX_HEIGHT = 296;
    private static final int HORIZONTAL_MAX_WIDTH = 440;
    public static final String TAG = "OInsetSheet";
    public FrameLayout contentContainer;
    public FrameLayout footerContainer;
    public FrameLayout headerContainer;
    private boolean hideFirstFrame;
    private boolean mClearDimFlag;
    public RadiusLayout rootContainer;
    private b widthMode;

    /* JADX INFO: compiled from: OInsetSheet.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }

        public static final /* synthetic */ int a(a r2, Context r3, int r4) {
            return r2.a((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), r4);
        }

        private final int a(Context r2, int r3) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
            if (com.obric.oui.common.util.h.f34570a.a(r1) == true) goto L5;
            return r3;
        L5:
            return n.d(r3, com.obric.oui.common.util.g.a(r1, 440));
        }
    }

    /* JADX INFO: compiled from: OInsetSheet.kt */
    public static final enum b extends Enum<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f36196a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f36197b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final /* synthetic */ b[] f36198c = null;

        private static final /* synthetic */ b[] a() {
            return new b[]{f36196a, f36197b};
        }

        public static b valueOf(String r2) {
            return (b) ZeusTransformUtils.preCheckCast(Enum.valueOf(b.class, r2), b.class, "com.obric.aiagent.plugin");
        }

        public static b[] values() {
            return (b[]) ZeusTransformUtils.preCheckCast(f36198c.clone(), b[].class, "com.obric.aiagent.plugin");
        }

        private b(String r1, int r2) {
            super(r1, r2);
        }

        static {
            f36196a = new b("NARROW_WIDTH", 0);
            f36197b = new b("BOARD_WIDTH", 1);
            f36198c = a();
        }
    }

    /* JADX INFO: compiled from: OInsetSheet.kt */
    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f36199a = null;

        static {
            int[] r0 = new int[b.values().length];
            r0[b.f36196a.ordinal()] = 1;
            r0[b.f36197b.ordinal()] = 2;
            f36199a = r0;
        }
    }

    /* JADX INFO: compiled from: OInsetSheet.kt */
    static final class d extends p implements d.h.a.b<com.obric.oui.animation.a.b<View>, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OInsetSheet f36200a;

        d(OInsetSheet r1) {
            this.f36200a = r1;
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ x invoke(com.obric.oui.animation.a.b<View> r3) {
            a((com.obric.oui.animation.a.b) ZeusTransformUtils.preCheckCast(r3, com.obric.oui.animation.a.b.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        }

        public final void a(com.obric.oui.animation.a.b<View> r2) {
            o.e(r2, "it");
            if (this.f36200a.getRootContainer().getAlpha() != 0.0f) goto L5;
            boolean r3 = true;
        L6:
            if (r3 == false) goto L9;
            this.f36200a.getRootContainer().setAlpha(1.0f);
            return;
        L9:
            return;
        L5:
            r3 = false;
            goto L6
        }
    }

    /* JADX INFO: compiled from: OInsetSheet.kt */
    static final class e extends p implements d.h.a.b<com.obric.oui.animation.a.b<View>, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f36201a = null;

        static {
            f36201a = new e();
        }

        e() {
            super(1);
        }

        public final void a(com.obric.oui.animation.a.b<View> r1) {
            o.e(r1, "it");
        }

        @Override // d.h.a.b
        public /* synthetic */ x invoke(com.obric.oui.animation.a.b<View> r3) {
            a((com.obric.oui.animation.a.b) ZeusTransformUtils.preCheckCast(r3, com.obric.oui.animation.a.b.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        }
    }

    /* JADX INFO: compiled from: OInsetSheet.kt */
    static final class f extends p implements d.h.a.b<com.obric.oui.animation.a.b<View>, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OInsetSheet f36202a;

        f(OInsetSheet r1) {
            this.f36202a = r1;
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ x invoke(com.obric.oui.animation.a.b<View> r3) {
            a((com.obric.oui.animation.a.b) ZeusTransformUtils.preCheckCast(r3, com.obric.oui.animation.a.b.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        }

        public final void a(com.obric.oui.animation.a.b<View> r2) {
            o.e(r2, "it");
            this.f36202a.originDismiss();
        }
    }

    /* JADX INFO: compiled from: OInsetSheet.kt */
    static final class g extends p implements d.h.a.b<com.obric.oui.animation.a.b<View>, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OInsetSheet f36203a;

        g(OInsetSheet r1) {
            this.f36203a = r1;
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ x invoke(com.obric.oui.animation.a.b<View> r3) {
            a((com.obric.oui.animation.a.b) ZeusTransformUtils.preCheckCast(r3, com.obric.oui.animation.a.b.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        }

        public final void a(com.obric.oui.animation.a.b<View> r2) {
            o.e(r2, "it");
            this.f36203a.originDismiss();
        }
    }

    static {
        Companion = new a(null);
    }

    public static /* synthetic */ int access$000(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$5P-qY61Wjgo9OSb-OwQzVbc0A34, reason: not valid java name */
    public static /* synthetic */ WindowInsets m1172lambda$5PqY61Wjgo9OSbOwQzVbc0A34(OInsetSheet r0, View r1, WindowInsets r2) {
        return m1175setOnApplyWindowInsetsListener$lambda0(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$H7bMZ_50jZcuGihzTSM-iPNbp44, reason: not valid java name */
    public static /* synthetic */ void m1173lambda$H7bMZ_50jZcuGihzTSMiPNbp44(OInsetSheet r0) {
        m1174performEnterAnimation$lambda4(r0);
    }

    public OInsetSheet(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r4, "context");
        super(r4);
        this.widthMode = b.f36197b;
        Window r5 = getWindow();
        if (r5 == null) goto L6;
        r5.requestFeature(1);
    L6:
        setContentView(ZeusTransformUtils.mapRes(R.layout.o_inset_sheet_container, "layout", "o_inset_sheet_container"));
        setupView();
        setOnApplyWindowInsetsListener();
    }

    public final FrameLayout getHeaderContainer() {
        FrameLayout r0 = this.headerContainer;
        if (r0 == null) goto L5;
        return r0;
    L5:
        o.c("headerContainer");
        return null;
    }

    public final void setHeaderContainer(FrameLayout r2) {
        o.e(r2, "<set-?>");
        this.headerContainer = r2;
    }

    public final FrameLayout getFooterContainer() {
        FrameLayout r0 = this.footerContainer;
        if (r0 == null) goto L5;
        return r0;
    L5:
        o.c("footerContainer");
        return null;
    }

    public final void setFooterContainer(FrameLayout r2) {
        o.e(r2, "<set-?>");
        this.footerContainer = r2;
    }

    public final FrameLayout getContentContainer() {
        FrameLayout r0 = this.contentContainer;
        if (r0 == null) goto L5;
        return r0;
    L5:
        o.c("contentContainer");
        return null;
    }

    public final void setContentContainer(FrameLayout r2) {
        o.e(r2, "<set-?>");
        this.contentContainer = r2;
    }

    public final RadiusLayout getRootContainer() {
        RadiusLayout r0 = this.rootContainer;
        if (r0 == null) goto L5;
        return r0;
    L5:
        o.c("rootContainer");
        return null;
    }

    public final void setRootContainer(RadiusLayout r2) {
        o.e(r2, "<set-?>");
        this.rootContainer = r2;
    }

    public final boolean getMClearDimFlag() {
        return this.mClearDimFlag;
    }

    public final void setMClearDimFlag(boolean r1) {
        this.mClearDimFlag = r1;
    }

    public final b getWidthMode() {
        return this.widthMode;
    }

    public final void setWidthMode(b r2) {
        o.e(r2, "<set-?>");
        this.widthMode = r2;
    }

    public final void setRootWidth(b r8) {
        o.e(r8, "width");
        this.widthMode = r8;
        int r9 = c.f36199a[r8.ordinal()];
        if (r9 == 1) goto L7;
        if (r9 != 2) goto L10;
        int r10 = ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getDisplayMetrics().widthPixels;
        a r0 = Companion;
        Context r2 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r2, "context");
        int r11 = a.a(r0, r2, r10);
        com.obric.oui.indicator.d.a((View) ZeusTransformUtils.preCheckCast(getRootContainer(), View.class, "com.obric.aiagent.plugin"), r11);
        float r12 = ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getDimension(ZeusTransformUtils.mapRes(R.dimen.oui_r_l3, "dimen", "oui_r_l3"));
        getRootContainer().setRadius(r12, r12, 0.0f, 0.0f);
        return;
    L10:
        return;
    L7:
        int r13 = ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getDisplayMetrics().widthPixels - (ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.oui_dialog_narrow_layout_margin, "dimen", "oui_dialog_narrow_layout_margin")) * 2);
        a r1 = Companion;
        Context r3 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r3, "context");
        int r14 = a.a(r1, r3, r13);
        com.obric.oui.indicator.d.a((View) ZeusTransformUtils.preCheckCast(getRootContainer(), View.class, "com.obric.aiagent.plugin"), r14);
        getRootContainer().setRadius(ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getDimension(ZeusTransformUtils.mapRes(R.dimen.oui_r_l2, "dimen", "oui_r_l2")));
    }

    private final void hideAndTransparentNavigationBar(Window r3) {
        if (Build.VERSION.SDK_INT < 29) goto L7;
        if (r3 == null) goto L7;
        r3.setNavigationBarContrastEnforced(false);
    L7:
        if (r3 == null) goto L10;
        r3.setDecorFitsSystemWindows(false);
    L10:
        if (r3 == null) goto L13;
        r3.clearFlags(134217728);
    L13:
        if (r3 == null) goto L16;
        r3.addFlags(Integer.MIN_VALUE);
    L16:
        if (r3 == null) goto L19;
        r3.setNavigationBarColor(0);
    L19:
        if (r3 == null) goto L23;
        r3.setNavigationBarDividerColor(0);
        return;
    }

    public final void setHeaderView(View r4) {
        setChildToParent((ViewGroup) ZeusTransformUtils.preCheckCast(getHeaderContainer(), ViewGroup.class, "com.obric.aiagent.plugin"), r4);
    }

    public final void setSheetBgColor(int r1) {
        getRootContainer().setBackgroundColor(r1);
    }

    public final void setContainerView(View r4) {
        setChildToParent((ViewGroup) ZeusTransformUtils.preCheckCast(getContentContainer(), ViewGroup.class, "com.obric.aiagent.plugin"), r4);
    }

    public final void setFooterView(View r4) {
        setChildToParent((ViewGroup) ZeusTransformUtils.preCheckCast(getFooterContainer(), ViewGroup.class, "com.obric.aiagent.plugin"), r4);
    }

    public final void setClearDimFlag(boolean r1) {
        this.mClearDimFlag = r1;
    }

    private final void setupView() {
        View r0 = findViewById(ZeusTransformUtils.mapRes(R.id.root_constraint, DbHelper.COL_ID, "root_constraint"));
        o.c(r0, "findViewById(R.id.root_constraint)");
        setRootContainer((RadiusLayout) ZeusTransformUtils.preCheckCast(r0, RadiusLayout.class, "com.obric.aiagent.plugin"));
        getRootContainer().setMeasureHeightUnspecified(true);
        View r1 = findViewById(ZeusTransformUtils.mapRes(R.id.header_container, DbHelper.COL_ID, "header_container"));
        o.c(r1, "findViewById(R.id.header_container)");
        setHeaderContainer((FrameLayout) ZeusTransformUtils.preCheckCast(r1, FrameLayout.class, "com.obric.aiagent.plugin"));
        View r2 = findViewById(ZeusTransformUtils.mapRes(R.id.content_container, DbHelper.COL_ID, "content_container"));
        o.c(r2, "findViewById(R.id.content_container)");
        setContentContainer((FrameLayout) ZeusTransformUtils.preCheckCast(r2, FrameLayout.class, "com.obric.aiagent.plugin"));
        View r3 = findViewById(ZeusTransformUtils.mapRes(R.id.foot_container, DbHelper.COL_ID, "foot_container"));
        o.c(r3, "findViewById(R.id.foot_container)");
        setFooterContainer((FrameLayout) ZeusTransformUtils.preCheckCast(r3, FrameLayout.class, "com.obric.aiagent.plugin"));
        com.obric.oui.dialog.a.a.f35019a.a((View) ZeusTransformUtils.preCheckCast(getRootContainer(), View.class, "com.obric.aiagent.plugin"));
    }

    private final void setOnApplyWindowInsetsListener() {
        getRootContainer().setOnApplyWindowInsetsListener(new $$Lambda$OInsetSheet$5PqY61Wjgo9OSbOwQzVbc0A34(this));
    }

    /* JADX INFO: renamed from: setOnApplyWindowInsetsListener$lambda-0, reason: not valid java name */
    private static final WindowInsets m1175setOnApplyWindowInsetsListener$lambda0(OInsetSheet r7, View r8, WindowInsets r9) {
        o.e(r7, "this$0");
        o.e(r8, "v");
        o.e(r9, "insets");
        int r0 = com.obric.oui.window.a.f36851a.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r7.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        int r1 = com.obric.oui.window.a.f36851a.a((View) ZeusTransformUtils.preCheckCast(r7.getRootContainer(), View.class, "com.obric.aiagent.plugin"));
        if (r1 <= 0) goto L10;
        b r2 = r7.widthMode;
        int r3 = c.f36199a[r2.ordinal()];
        if (r3 == 1) goto L9;
        if (r3 != 2) goto L17;
        r8.setPadding(0, 0, 0, r1);
    L17:
        return r9.consumeSystemWindowInsets();
    L9:
        com.obric.oui.indicator.d.b((View) ZeusTransformUtils.preCheckCast(r7.getRootContainer(), View.class, "com.obric.aiagent.plugin"), r1 + com.obric.oui.common.util.g.a(r8, 16));
        goto L17
    L10:
        b r10 = r7.widthMode;
        int r11 = c.f36199a[r10.ordinal()];
        if (r11 == 1) goto L15;
        if (r11 != 2) goto L17;
        com.obric.oui.indicator.d.b((View) ZeusTransformUtils.preCheckCast(r7.getRootContainer(), View.class, "com.obric.aiagent.plugin"), 0);
        r7.getRootContainer().setPadding(0, 0, 0, r0);
        goto L17
    L15:
        com.obric.oui.indicator.d.b((View) ZeusTransformUtils.preCheckCast(r7.getRootContainer(), View.class, "com.obric.aiagent.plugin"), r0);
        r7.getRootContainer().setPadding(0, 0, 0, 0);
        goto L17
    }

    @Override // android.app.Dialog
    public void show() {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r0, "context");
        adjustContentHeight(r0);
        super.show();
        Window r1 = getWindow();
        if (r1 == null) goto L21;
        r1.setBackgroundDrawableResource(android.R.color.transparent);
        hideAndTransparentNavigationBar(r1);
        if (getMClearDimFlag() == false) goto L8;
        r1.clearFlags(2);
    L10:
        if ((ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r1.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getConfiguration().uiMode & 48) != 32) goto L12;
        boolean r2 = true;
    L13:
        if (r2 == false) goto L15;
        float r3 = 0.5f;
    L16:
        WindowManager.LayoutParams r4 = r1.getAttributes();
        if (needDimAnim() == true) goto L19;
        r4.dimAmount = r3;
    L19:
        r4.setFitInsetsSides(WindowInsets.Side.all() ^ 8);
        r4.gravity = 80;
        r1.setAttributes(r4);
        return;
    L15:
        r3 = 0.16f;
        goto L16
    L12:
        r2 = false;
        goto L13
    L8:
        r1.addFlags(2);
        goto L10
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle r1) {
        super.onCreate(r1);
        if (this.hideFirstFrame == false) goto L6;
        getRootContainer().setAlpha(0.0f);
        return;
    }

    @Override // android.app.Dialog
    public void onStart() {
        super.onStart();
        performEnterAnimation();
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        performExitAnimation();
    }

    public final void originDismiss() {
        super.dismiss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        INVOKESTATIC_com_obric_oui_sheet_OInsetSheet_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("OAlertDialog", "origin Dismiss exception!", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    }

    public void performExitAnimation() {
        com.obric.oui.animation.a.b r0 = com.obric.oui.dialog.a.a.a(com.obric.oui.dialog.a.a.f35019a, (View) ZeusTransformUtils.preCheckCast(getRootContainer(), View.class, "com.obric.aiagent.plugin"), getWindow(), needDimAnim(), false, 4, null);
        com.obric.oui.animation.a.b.a(r0, null, (d.h.a.b) ZeusTransformUtils.preCheckCast(new f(this), d.h.a.b.class, "com.obric.aiagent.plugin"), (d.h.a.b) ZeusTransformUtils.preCheckCast(new g(this), d.h.a.b.class, "com.obric.aiagent.plugin"), 1, null);
        r0.b();
    }

    public final void performEnterAnimation() {
        getRootContainer().post(new $$Lambda$OInsetSheet$H7bMZ_50jZcuGihzTSMiPNbp44(this));
    }

    /* JADX INFO: renamed from: performEnterAnimation$lambda-4, reason: not valid java name */
    private static final void m1174performEnterAnimation$lambda4(OInsetSheet r17) {
        o.e(r17, "this$0");
        com.obric.oui.dialog.a.a r2 = com.obric.oui.dialog.a.a.f35019a;
        View r3 = (View) ZeusTransformUtils.preCheckCast(r17.getRootContainer(), View.class, "com.obric.aiagent.plugin");
        Window r4 = r17.getWindow();
        boolean r5 = r17.needDimAnim();
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r17.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r1, "context");
        com.obric.oui.animation.a.b r6 = com.obric.oui.animation.a.b.a(com.obric.oui.dialog.a.a.a(r2, r3, r4, r5, r17.getTargetWindowDimAmount(r1), false, 8, null), null, null, (d.h.a.b) ZeusTransformUtils.preCheckCast(e.f36201a, d.h.a.b.class, "com.obric.aiagent.plugin"), 3, null);
        if (r17.hideFirstFrame == false) goto L5;
        com.obric.oui.animation.a.b.a(r6, (d.h.a.b) ZeusTransformUtils.preCheckCast(new d(r17), d.h.a.b.class, "com.obric.aiagent.plugin"), null, null, 6, null);
    L5:
        r6.b();
    }

    public final void setChildToParent(ViewGroup r2, View r3) {
        if (r3 == null) goto L13;
        if (r2 == null) goto L7;
        k.a((View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.aiagent.plugin"));
    L7:
        if (r2 == null) goto L10;
        r2.removeAllViews();
    L10:
        if (r2 == null) goto L18;
        r2.addView(r3);
        return;
    L18:
        return;
    L13:
        if (r2 == null) goto L19;
        k.b((View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.aiagent.plugin"));
        return;
    }

    public final void addChildToParent(ViewGroup r2, View r3) {
        if (r3 == null) goto L10;
        if (r2 == null) goto L7;
        k.a((View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.aiagent.plugin"));
    L7:
        if (r2 == null) goto L15;
        r2.addView(r3);
        return;
    L15:
        return;
    L10:
        if (r2 == null) goto L16;
        k.b((View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.aiagent.plugin"));
        return;
    }

    private final boolean needDimAnim() {
        return !this.mClearDimFlag;
    }

    private final float getTargetWindowDimAmount(Context r2) {
        if ((ZeusTransformUtils.getResources((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getConfiguration().uiMode & 48) != 32) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L8;
        return 0.5f;
    L8:
        return 0.16f;
    L5:
        r1 = false;
        goto L6
    }

    private final void adjustContentHeight(Context r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        if (com.obric.oui.common.util.h.f34570a.a(r8) == false) goto L13;
        getRootContainer().measure(0, 0);     // Catch: Exception -> L8
        int r4 = ((com.obric.oui.common.util.g.a(r8, HORIZONTAL_MAX_HEIGHT) - com.obric.oui.window.a.f36851a.b(r8)) - getHeaderContainer().getMeasuredHeight()) - getFooterContainer().getMeasuredHeight();     // Catch: Exception -> L8
        getContentContainer().measure(View.MeasureSpec.makeMeasureSpec(com.obric.oui.common.util.g.a(r8, 440), Integer.MIN_VALUE), 0);     // Catch: Exception -> L8
        int r1 = getContentContainer().getMeasuredHeight();     // Catch: Exception -> L8
        int r9 = n.a(r4, 0, com.obric.oui.common.util.g.a(r8, HORIZONTAL_MAX_CONTENT_HEIGHT));     // Catch: Exception -> L8
        if (r1 <= r9) goto L14;
        com.obric.oui.d.a.b.c("OInsetSheet", "adjustContentHeight, measured contentHeight: " + r1 + ", final contentHeight: " + r9);     // Catch: Exception -> L8
        FrameLayout r2 = getContentContainer();     // Catch: Exception -> L8
        ViewGroup.LayoutParams r6 = getContentContainer().getLayoutParams();     // Catch: Exception -> L8
        r6.height = r9;     // Catch: Exception -> L8
        r2.setLayoutParams(r6);     // Catch: Exception -> L8
        return;
    L14:
        return;
    L8:
        e = move-exception;
        com.obric.oui.d.a.b.b("OInsetSheet", "adjustContentHeight error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return;
    }

    public final void forceHideFirstFrame() {
        this.hideFirstFrame = true;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_oui_sheet_OInsetSheet_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }
}
