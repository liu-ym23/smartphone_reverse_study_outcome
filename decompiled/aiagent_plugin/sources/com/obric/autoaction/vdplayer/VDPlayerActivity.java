package com.obric.autoaction.vdplayer;

import android.app.ActivityManager;
import android.app.ActivityOptions;
import android.app.TaskInfo;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.core.view.ai;
import androidx.lifecycle.p;
import androidx.lifecycle.q;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.a.b;
import com.obric.autoaction.a.c;
import com.obric.autoaction.a.f;
import com.obric.autoaction.a.g;
import com.obric.autoaction.a.i;
import com.obric.autoaction.a.l;
import com.obric.autoaction.common.base.BaseActivity;
import com.obric.autoaction.vdplayer.components.CommonLogicComponent;
import com.obric.autoaction.vdplayer.components.CommonSideEffectComponent;
import com.obric.autoaction.vdplayer.components.CursorEffectComponent;
import com.obric.autoaction.vdplayer.components.ExecHistoryListPopupComponent;
import com.obric.autoaction.vdplayer.components.ExposureTrackerComponent;
import com.obric.autoaction.vdplayer.components.MirrorViewComponent;
import com.obric.autoaction.vdplayer.components.PlayerCoverComponent;
import com.obric.autoaction.vdplayer.components.PlayerScreenEffectComponent;
import com.obric.autoaction.vdplayer.components.SecureComponent;
import com.obric.autoaction.vdplayer.components.SpaceTypeDebugBadgeComponent;
import com.obric.autoaction.vdplayer.components.StatusBarComponent;
import com.obric.autoaction.vdplayer.components.TakeOverConfirmDialogComponent;
import com.obric.autoaction.vdplayer.components.TakeoverStatusBadgeComponent;
import com.obric.autoaction.vdplayer.components.VirtualDisplayComponent;
import com.obric.autoaction.vdplayer.components.panel.PanelContainerComponent;
import com.obric.autogui.common.a.d;
import com.obric.autogui.common.api.AOSystemTools;
import com.obric.autogui.common.api.app.foundation.AutoActionFoundation;
import com.obric.autogui.common.api.app.foundation.FoundationStatus;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.AOPlatformTools;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.aa;
import d.h.b.h;
import d.h.b.o;
import d.n;
import d.x;
import java.util.Collection;
import java.util.Iterator;
import kotlinx.coroutines.am;

/* JADX INFO: compiled from: VDPlayerActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class VDPlayerActivity extends BaseActivity {
    public static final a Companion = null;
    private static final String DEBUG_BRIDGE_COMPONENT_CLASS = "com.obric.autoaction.vdplayer.debug.VDPlayerDebugBridgeComponent";
    private static final String TAG = "VDPlayerActivity";
    private static volatile boolean isStarted;
    private final c host;

    /* JADX INFO: compiled from: VDPlayerActivity.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }

        public final void a(boolean r1) {
            VDPlayerActivity.access$setStarted$cp(r1);
        }

        public final boolean a() {
            return VDPlayerActivity.access$isStarted$cp();
        }
    }

    static {
        Companion = new a(null);
    }

    public static /* synthetic */ x lambda$1PTygK02jb_xte3wFs96ZZDTgvQ(i r0) {
        return buildNewComponents$lambda$14$lambda$8(r0);
    }

    public static /* synthetic */ x lambda$1dVar6XNDmd3FQixaQJ_CzdL9cE(l r0) {
        return buildLegacyComponents$lambda$28$lambda$21(r0);
    }

    public static /* synthetic */ x lambda$4Boy4sST2cp_EEEm6RxFhEqaHgw(i r0) {
        return buildNewComponents$lambda$14$lambda$9(r0);
    }

    public static /* synthetic */ x lambda$5TcpRFC72UIEkQM52CtF9LByu44(l r0) {
        return buildNewComponents$lambda$14$lambda$1(r0);
    }

    /* JADX INFO: renamed from: lambda$7XjIM51cNIUcmvwqcZu6-IxpM-A, reason: not valid java name */
    public static /* synthetic */ x m647lambda$7XjIM51cNIUcmvwqcZu6IxpMA(VDPlayerActivity r0, com.obric.autoaction.a.a r1) {
        return buildNewComponents$lambda$14(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$8ZmXibWm-lJJDxPoQLyoT91Yg3Y, reason: not valid java name */
    public static /* synthetic */ x m648lambda$8ZmXibWmlJJDxPoQLyoT91Yg3Y(l r0) {
        return buildLegacyComponents$lambda$28$lambda$20(r0);
    }

    public static /* synthetic */ x lambda$ACZYK9DrmqzbUlPq57UV5xOvmZk(l r0) {
        return buildLegacyComponents$lambda$28$lambda$18(r0);
    }

    public static /* synthetic */ x lambda$BUqsnJWafsqosU9thLCDLT07SXs(d.m.c r0, i r1) {
        return buildNewComponents$lambda$14$lambda$13(r0, r1);
    }

    public static /* synthetic */ x lambda$E7D1_RDIdjVh8MyN1fQlTSAHUbU(VDPlayerActivity r0, l r1) {
        return buildNewComponents$lambda$14$lambda$0(r0, r1);
    }

    public static /* synthetic */ x lambda$G3EhrXB1nxlJTNsyZUHxR0gLOxU(i r0) {
        return buildLegacyComponents$lambda$28$lambda$27(r0);
    }

    public static /* synthetic */ x lambda$HnDUGflHDlDAJcasxlgpmvZ51kU(i r0) {
        return buildNewComponents$lambda$14$lambda$12(r0);
    }

    public static /* synthetic */ x lambda$Lu1rzJ3UeEEklLg304lsKkjjmZg(i r0) {
        return buildLegacyComponents$lambda$28$lambda$24(r0);
    }

    /* JADX INFO: renamed from: lambda$MfRClvwiMYhUOmLoJVuMaCnq-Go, reason: not valid java name */
    public static /* synthetic */ x m649lambda$MfRClvwiMYhUOmLoJVuMaCnqGo(l r0) {
        return buildNewComponents$lambda$14$lambda$2(r0);
    }

    public static /* synthetic */ x lambda$NlE4Y_ap4yC5H6nzJAykML3g9HA(l r0) {
        return buildNewComponents$lambda$14$lambda$6(r0);
    }

    /* JADX INFO: renamed from: lambda$NpC5sSGFvUyzupGUBk_c-eIT2q8, reason: not valid java name */
    public static /* synthetic */ x m650lambda$NpC5sSGFvUyzupGUBk_ceIT2q8(l r0) {
        return buildLegacyComponents$lambda$28$lambda$19(r0);
    }

    public static /* synthetic */ x lambda$QRRVDu6SQiGwrLbFte70Kz4O6bI(VDPlayerActivity r0, com.obric.autoaction.a.a r1) {
        return buildLegacyComponents$lambda$28(r0, r1);
    }

    public static /* synthetic */ x lambda$VZt8hse_2vo57ftKMOtjAih2fzI(i r0) {
        return buildLegacyComponents$lambda$28$lambda$25(r0);
    }

    public static /* synthetic */ x lambda$Wxocl7jyevYRDwi6mEJ_U5oJcCg(l r0) {
        return buildLegacyComponents$lambda$28$lambda$23(r0);
    }

    /* JADX INFO: renamed from: lambda$ZB-nJgjcXJBP_79bZ-QVBzs3Iys, reason: not valid java name */
    public static /* synthetic */ x m651lambda$ZBnJgjcXJBP_79bZQVBzs3Iys(i r0) {
        return buildNewComponents$lambda$14$lambda$10(r0);
    }

    public static /* synthetic */ x lambda$ZD82whbehy3rHOp4TZb5lvO2mbI(l r0) {
        return buildNewComponents$lambda$14$lambda$7(r0);
    }

    public static /* synthetic */ x lambda$ai5fEovOUg4lLohbKBcgiaKr7IA(i r0) {
        return buildNewComponents$lambda$14$lambda$11(r0);
    }

    public static /* synthetic */ x lambda$c434HUVyFam5SJBJjPseF9jWE0k(l r0) {
        return buildNewComponents$lambda$14$lambda$4(r0);
    }

    public static /* synthetic */ x lambda$gS9ImUT55Ih4aSFS0_1yB8EJax4(l r0) {
        return buildNewComponents$lambda$14$lambda$3(r0);
    }

    public static /* synthetic */ x lambda$iPC_kazYMExg3ZK65Xdw6c0sjGA(l r0) {
        return attachSpaceTypeDebugBadgeIfEnabled$lambda$31(r0);
    }

    public static /* synthetic */ x lambda$iyk1vFzZUiOYJH3MVaZIG4vmqvM(i r0) {
        return buildLegacyComponents$lambda$28$lambda$26(r0);
    }

    /* JADX INFO: renamed from: lambda$p081ItcLV-rQ83-K9IgFWxc-2_I, reason: not valid java name */
    public static /* synthetic */ x m652lambda$p081ItcLVrQ83K9IgFWxc2_I(l r0) {
        return buildLegacyComponents$lambda$28$lambda$17(r0);
    }

    public static /* synthetic */ x lambda$poNBdjiDz3LVL5ce3WDvXvIgWpw(l r0) {
        return buildLegacyComponents$lambda$28$lambda$22(r0);
    }

    /* JADX INFO: renamed from: lambda$x3LGp53lEhWg-EM9tqGmcglq5G0, reason: not valid java name */
    public static /* synthetic */ x m653lambda$x3LGp53lEhWgEM9tqGmcglq5G0(l r0) {
        return buildNewComponents$lambda$14$lambda$5(r0);
    }

    public VDPlayerActivity() {
        this.host = new c((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.aiagent.plugin"), (am) ZeusTransformUtils.preCheckCast(q.a((p) ZeusTransformUtils.preCheckCast(this, p.class, "com.obric.aiagent.plugin")), am.class, "com.obric.aiagent.plugin"), (p) ZeusTransformUtils.preCheckCast(this, p.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ boolean access$isStarted$cp() {
        return isStarted;
    }

    public static final /* synthetic */ void access$setStarted$cp(boolean r0) {
        isStarted = r0;
    }

    @Override // com.obric.autoaction.common.base.BaseActivity
    public boolean skipPrivacyAndLoginCheck() {
        return com.obric.autoaction.vdplayer.a.a.f25176a.a(getIntent()).a();
    }

    @Override // com.obric.autoaction.common.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity
    public void onCreate(Bundle r3) {
        super.onCreate(r3);
        if (AutoActionFoundation.INSTANCE.getStatus() != FoundationStatus.NotInitialised) goto L6;
        Loog.INSTANCE.e(TAG, "AutoActionFoundation isn't initialized, finish VDPlayerActivity.");
        finish();
        return;
    L6:
        setImmersiveMode();
        setContentView((View) ZeusTransformUtils.preCheckCast(buildComponents(), View.class, "com.obric.aiagent.plugin"));
        Window r4 = getWindow();
        o.c(r4, "getWindow(...)");
        exDisableUserInterfaceSaving(r4);
    }

    private final ViewGroup buildComponents() {
        if (d.f28974a.h() == false) goto L6;
        return buildNewComponents();
    L6:
        return buildLegacyComponents();
    }

    private final d.m.c<? extends g> resolveDisplayComponentType() {
        if (com.obric.autogui.common.a.c.f28972a.a().e() == false) goto L5;
        Loog.INSTANCE.i(TAG, "Use MirrorViewComponent for VDPlayer display host.");
        Class r2 = MirrorViewComponent.class;
    L7:
        return aa.b(r2);
    L5:
        r2 = VirtualDisplayComponent.class;
        goto L7
    }

    private final ViewGroup buildNewComponents() {
        return b.a(this.host, ZeusTransformUtils.mapRes(R.layout.vd_activity, "layout", "vd_activity"), new $$Lambda$VDPlayerActivity$7XjIM51cNIUcmvwqcZu6IxpMA(this));
    }

    private static final x buildNewComponents$lambda$14(VDPlayerActivity r2, com.obric.autoaction.a.a r3) {
        final VDPlayerActivity r4 = (VDPlayerActivity) ZeusTransformUtils.wrapperContextForParams(r2, VDPlayerActivity.class, "com.obric.aiagent.plugin");
        o.e(r3, "$this$assemble");
        r3.b(new $$Lambda$VDPlayerActivity$E7D1_RDIdjVh8MyN1fQlTSAHUbU(r4));
        r3.b($$Lambda$VDPlayerActivity$5TcpRFC72UIEkQM52CtF9LByu44.INSTANCE);
        r3.b($$Lambda$VDPlayerActivity$MfRClvwiMYhUOmLoJVuMaCnqGo.INSTANCE);
        r3.b($$Lambda$VDPlayerActivity$gS9ImUT55Ih4aSFS0_1yB8EJax4.INSTANCE);
        r3.b($$Lambda$VDPlayerActivity$c434HUVyFam5SJBJjPseF9jWE0k.INSTANCE);
        r3.b($$Lambda$VDPlayerActivity$x3LGp53lEhWgEM9tqGmcglq5G0.INSTANCE);
        r3.b($$Lambda$VDPlayerActivity$NlE4Y_ap4yC5H6nzJAykML3g9HA.INSTANCE);
        r3.b($$Lambda$VDPlayerActivity$ZD82whbehy3rHOp4TZb5lvO2mbI.INSTANCE);
        r3.a($$Lambda$VDPlayerActivity$1PTygK02jb_xte3wFs96ZZDTgvQ.INSTANCE);
        r3.a($$Lambda$VDPlayerActivity$4Boy4sST2cp_EEEm6RxFhEqaHgw.INSTANCE);
        r3.a($$Lambda$VDPlayerActivity$ZBnJgjcXJBP_79bZQVBzs3Iys.INSTANCE);
        r3.a($$Lambda$VDPlayerActivity$ai5fEovOUg4lLohbKBcgiaKr7IA.INSTANCE);
        r3.a($$Lambda$VDPlayerActivity$HnDUGflHDlDAJcasxlgpmvZ51kU.INSTANCE);
        r4.attachSpaceTypeDebugBadgeIfEnabled(r3);
        final d.m.c<? extends f> r5 = r4.resolveDebugBridgeComponentType();
        if (r5 == null) goto L6;
        r3.a(new $$Lambda$VDPlayerActivity$BUqsnJWafsqosU9thLCDLT07SXs(r5));
    L6:
        return x.f38692a;
    }

    private static final x buildNewComponents$lambda$14$lambda$0(VDPlayerActivity r2, l r3) {
        VDPlayerActivity r4 = (VDPlayerActivity) ZeusTransformUtils.wrapperContextForParams(r2, VDPlayerActivity.class, "com.obric.aiagent.plugin");
        o.e(r3, "$this$uiSlotComponent");
        r3.a(r4.resolveDisplayComponentType());
        return x.f38692a;
    }

    private static final x buildNewComponents$lambda$14$lambda$1(l r1) {
        o.e(r1, "$this$uiSlotComponent");
        r1.a(aa.b(PlayerCoverComponent.class));
        return x.f38692a;
    }

    private static final x buildNewComponents$lambda$14$lambda$2(l r1) {
        o.e(r1, "$this$uiSlotComponent");
        r1.a(aa.b(SecureComponent.class));
        return x.f38692a;
    }

    private static final x buildNewComponents$lambda$14$lambda$3(l r1) {
        o.e(r1, "$this$uiSlotComponent");
        r1.a(aa.b(TakeoverStatusBadgeComponent.class));
        return x.f38692a;
    }

    private static final x buildNewComponents$lambda$14$lambda$4(l r1) {
        o.e(r1, "$this$uiSlotComponent");
        r1.a(aa.b(PlayerScreenEffectComponent.class));
        return x.f38692a;
    }

    private static final x buildNewComponents$lambda$14$lambda$5(l r1) {
        o.e(r1, "$this$uiSlotComponent");
        r1.a(aa.b(CursorEffectComponent.class));
        return x.f38692a;
    }

    private static final x buildNewComponents$lambda$14$lambda$6(l r1) {
        o.e(r1, "$this$uiSlotComponent");
        r1.a(aa.b(PanelContainerComponent.class));
        return x.f38692a;
    }

    private static final x buildNewComponents$lambda$14$lambda$7(l r1) {
        o.e(r1, "$this$uiSlotComponent");
        r1.a(aa.b(ExecHistoryListPopupComponent.class));
        return x.f38692a;
    }

    private static final x buildNewComponents$lambda$14$lambda$8(i r1) {
        o.e(r1, "$this$component");
        r1.a(aa.b(TakeOverConfirmDialogComponent.class));
        return x.f38692a;
    }

    private static final x buildNewComponents$lambda$14$lambda$9(i r1) {
        o.e(r1, "$this$component");
        r1.a(aa.b(ExposureTrackerComponent.class));
        return x.f38692a;
    }

    private static final x buildNewComponents$lambda$14$lambda$10(i r1) {
        o.e(r1, "$this$component");
        r1.a(aa.b(StatusBarComponent.class));
        return x.f38692a;
    }

    private static final x buildNewComponents$lambda$14$lambda$11(i r1) {
        o.e(r1, "$this$component");
        r1.a(aa.b(CommonSideEffectComponent.class));
        return x.f38692a;
    }

    private static final x buildNewComponents$lambda$14$lambda$12(i r1) {
        o.e(r1, "$this$component");
        r1.a(aa.b(CommonLogicComponent.class));
        return x.f38692a;
    }

    private static final x buildNewComponents$lambda$14$lambda$13(d.m.c r2, i r3) {
        d.m.c<? extends f> r4 = (d.m.c) ZeusTransformUtils.wrapperContextForParams(r2, d.m.c.class, "com.obric.aiagent.plugin");
        o.e(r3, "$this$component");
        r3.a(r4);
        return x.f38692a;
    }

    private final d.m.c<? extends f> resolveDebugBridgeComponentType() {
        n.a r1 = n.f38560a;     // Catch: Throwable -> L5
        VDPlayerActivity r4 = (VDPlayerActivity) ZeusTransformUtils.preCheckCast(this, VDPlayerActivity.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
        Class r5 = ZeusTransformUtils.forName(DEBUG_BRIDGE_COMPONENT_CLASS, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
        o.c(r5, "forName(...)");     // Catch: Throwable -> L5
        d.m.c r6 = d.h.a.a(r5);     // Catch: Throwable -> L5
        o.a(r6, "null cannot be cast to non-null type kotlin.reflect.KClass<out com.obric.autoaction.component.IComponent>");     // Catch: Throwable -> L5
        Object r7 = n.f(r6);     // Catch: Throwable -> L5
    L7:
        Throwable r2 = n.c(r7);
        if (r2 == null) goto L12;
        Loog.INSTANCE.d(TAG, "debug bridge component not present, skip: " + r2.getMessage());
        r7 = null;
    L12:
        return (d.m.c) ZeusTransformUtils.preCheckCast(r7, d.m.c.class, "com.obric.aiagent.plugin");
    L5:
        th = move-exception;
        n.a r3 = n.f38560a;
        r7 = n.f(d.o.a(th));
        goto L7
    }

    private final ViewGroup buildLegacyComponents() {
        return b.a(this.host, ZeusTransformUtils.mapRes(R.layout.vd_activity, "layout", "vd_activity"), new $$Lambda$VDPlayerActivity$QRRVDu6SQiGwrLbFte70Kz4O6bI(this));
    }

    private static final x buildLegacyComponents$lambda$28(VDPlayerActivity r2, com.obric.autoaction.a.a r3) {
        VDPlayerActivity r4 = (VDPlayerActivity) ZeusTransformUtils.wrapperContextForParams(r2, VDPlayerActivity.class, "com.obric.aiagent.plugin");
        o.e(r3, "$this$assemble");
        r3.b($$Lambda$VDPlayerActivity$p081ItcLVrQ83K9IgFWxc2_I.INSTANCE);
        r3.b($$Lambda$VDPlayerActivity$ACZYK9DrmqzbUlPq57UV5xOvmZk.INSTANCE);
        r3.b($$Lambda$VDPlayerActivity$NpC5sSGFvUyzupGUBk_ceIT2q8.INSTANCE);
        r3.b($$Lambda$VDPlayerActivity$8ZmXibWmlJJDxPoQLyoT91Yg3Y.INSTANCE);
        r3.b($$Lambda$VDPlayerActivity$1dVar6XNDmd3FQixaQJ_CzdL9cE.INSTANCE);
        r3.b($$Lambda$VDPlayerActivity$poNBdjiDz3LVL5ce3WDvXvIgWpw.INSTANCE);
        r3.b($$Lambda$VDPlayerActivity$Wxocl7jyevYRDwi6mEJ_U5oJcCg.INSTANCE);
        r3.a($$Lambda$VDPlayerActivity$Lu1rzJ3UeEEklLg304lsKkjjmZg.INSTANCE);
        r3.a($$Lambda$VDPlayerActivity$VZt8hse_2vo57ftKMOtjAih2fzI.INSTANCE);
        r3.a($$Lambda$VDPlayerActivity$iyk1vFzZUiOYJH3MVaZIG4vmqvM.INSTANCE);
        r3.a($$Lambda$VDPlayerActivity$G3EhrXB1nxlJTNsyZUHxR0gLOxU.INSTANCE);
        r4.attachSpaceTypeDebugBadgeIfEnabled(r3);
        return x.f38692a;
    }

    private static final x buildLegacyComponents$lambda$28$lambda$17(l r1) {
        o.e(r1, "$this$uiSlotComponent");
        r1.a(aa.b(com.obric.autoaction.vdplayer.legacy.components.VirtualDisplayComponent.class));
        return x.f38692a;
    }

    private static final x buildLegacyComponents$lambda$28$lambda$18(l r1) {
        o.e(r1, "$this$uiSlotComponent");
        r1.a(aa.b(com.obric.autoaction.vdplayer.legacy.components.PlayerCoverComponent.class));
        return x.f38692a;
    }

    private static final x buildLegacyComponents$lambda$28$lambda$19(l r1) {
        o.e(r1, "$this$uiSlotComponent");
        r1.a(aa.b(com.obric.autoaction.vdplayer.legacy.components.SecureComponent.class));
        return x.f38692a;
    }

    private static final x buildLegacyComponents$lambda$28$lambda$20(l r1) {
        o.e(r1, "$this$uiSlotComponent");
        r1.a(aa.b(com.obric.autoaction.vdplayer.legacy.components.PlayerScreenEffectComponent.class));
        return x.f38692a;
    }

    private static final x buildLegacyComponents$lambda$28$lambda$21(l r1) {
        o.e(r1, "$this$uiSlotComponent");
        r1.a(aa.b(com.obric.autoaction.vdplayer.legacy.components.CursorEffectComponent.class));
        return x.f38692a;
    }

    private static final x buildLegacyComponents$lambda$28$lambda$22(l r1) {
        o.e(r1, "$this$uiSlotComponent");
        r1.a(aa.b(com.obric.autoaction.vdplayer.legacy.components.panel.PanelContainerComponent.class));
        return x.f38692a;
    }

    private static final x buildLegacyComponents$lambda$28$lambda$23(l r1) {
        o.e(r1, "$this$uiSlotComponent");
        r1.a(aa.b(com.obric.autoaction.vdplayer.legacy.components.ExecHistoryListPopupComponent.class));
        return x.f38692a;
    }

    private static final x buildLegacyComponents$lambda$28$lambda$24(i r1) {
        o.e(r1, "$this$component");
        r1.a(aa.b(com.obric.autoaction.vdplayer.legacy.components.ExposureTrackerComponent.class));
        return x.f38692a;
    }

    private static final x buildLegacyComponents$lambda$28$lambda$25(i r1) {
        o.e(r1, "$this$component");
        r1.a(aa.b(com.obric.autoaction.vdplayer.legacy.components.StatusBarComponent.class));
        return x.f38692a;
    }

    private static final x buildLegacyComponents$lambda$28$lambda$26(i r1) {
        o.e(r1, "$this$component");
        r1.a(aa.b(com.obric.autoaction.vdplayer.legacy.components.CommonSideEffectComponent.class));
        return x.f38692a;
    }

    private static final x buildLegacyComponents$lambda$28$lambda$27(i r1) {
        o.e(r1, "$this$component");
        r1.a(aa.b(com.obric.autoaction.vdplayer.legacy.components.CommonLogicComponent.class));
        return x.f38692a;
    }

    private final void attachSpaceTypeDebugBadgeIfEnabled(com.obric.autoaction.a.a r5) {
        n.a r4 = n.f38560a;     // Catch: Throwable -> L4
        Object r6 = n.f(Boolean.valueOf(AOSystemTools.INSTANCE.isDebugVersion()));     // Catch: Throwable -> L4
    L7:
        if (n.b(r6) == false) goto L9;
        r6 = false;
    L9:
        boolean r7 = ((Boolean) ZeusTransformUtils.preCheckCast(r6, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
        n.a r1 = n.f38560a;     // Catch: Throwable -> L12
        Object r2 = n.f(Boolean.valueOf(com.obric.autoaction.vdplayer.a.b.f25180a.a()));     // Catch: Throwable -> L12
    L15:
        if (n.b(r2) == false) goto L17;
        r2 = false;
    L17:
        boolean r0 = ((Boolean) ZeusTransformUtils.preCheckCast(r2, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
        if (r7 == false) goto L26;
        if (r0 == false) goto L27;
        r5.b($$Lambda$VDPlayerActivity$iPC_kazYMExg3ZK65Xdw6c0sjGA.INSTANCE);
        return;
    L27:
        return;
    L26:
        return;
    L12:
        th = move-exception;
        n.a r3 = n.f38560a;
        r2 = n.f(d.o.a(th));
    L4:
        th = move-exception;
        n.a r8 = n.f38560a;
        r6 = n.f(d.o.a(th));
        goto L7
    }

    private static final x attachSpaceTypeDebugBadgeIfEnabled$lambda$31(l r1) {
        o.e(r1, "$this$uiSlotComponent");
        r1.a(aa.b(SpaceTypeDebugBadgeComponent.class));
        return x.f38692a;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onDestroy() {
        super.onDestroy();
        this.host.d();
    }

    @Override // com.obric.autoaction.common.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity
    public void onNewIntent(Intent r4) {
        super.onNewIntent(r4);
        Loog.INSTANCE.d(TAG, "onNewIntent");
        if (r4 == null) goto L5;
        setIntent(r4);
    L5:
        this.host.a(r4);
    }

    private final void setImmersiveMode() {
        boolean r1 = false;
        ai.a(getWindow(), false);
        getWindow().setStatusBarColor(0);
        getWindow().setNavigationBarColor(0);
        getWindow().setNavigationBarDividerColor(0);
        getWindow().setNavigationBarContrastEnforced(false);
        androidx.core.view.am r0 = ai.a(getWindow(), getWindow().getDecorView());
        o.c(r0, "getInsetsController(...)");
        r0.a(true);
        if ((ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getConfiguration().uiMode & 48) == 32) goto L5;
        r1 = true;
    L5:
        r0.b(r1);
    }

    private final void exDisableUserInterfaceSaving(Window r12) {
        WindowManager.LayoutParams r13 = r12.getAttributes();     // Catch: Throwable -> L5
        ZeusTransformUtils.forName("android.view.WindowManagerExt", "com.obric.aiagent.plugin").getMethod("disableStartingWindow", new Class[]{WindowManager.LayoutParams.class, Boolean.TYPE}).invoke(null, new Object[]{r13, true});     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Loog r0 = Loog.INSTANCE;
        StringBuilder r1 = new StringBuilder().append("exDisableUserInterfaceSaving fail: ");
        StackTraceElement[] r14 = th.getStackTrace();
        o.c(r14, "getStackTrace(...)");
        r0.d(TAG, r1.append(d.a.i.a((Object[]) ZeusTransformUtils.preCheckCast(r14, Object[].class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("\n", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, null, 62, null)).toString());
    }

    public final boolean finishToTaskWithoutAnimation(int r7) {
        if (r7 > 0) goto L37;
    L23:
        boolean r3 = false;
    L24:
        if (r3 == true) goto L26;
        return false;
    L26:
        ActivityManager r4 = (ActivityManager) ZeusTransformUtils.preCheckCast(getSystemService(ActivityManager.class), ActivityManager.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L35;
        return false;
    L35:
        Bundle r5 = ActivityOptions.makeCustomAnimation((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.aiagent.plugin"), 0, 0).toBundle();     // Catch: Exception -> L31
        r5.putBoolean("android:activity.overrideTaskTransition", true);     // Catch: Exception -> L31
        r4.moveTaskToFront(r7, 0, r5);     // Catch: Exception -> L31
        super.finish();     // Catch: Exception -> L31
        return true;
    L31:
        e = move-exception;
        Loog.INSTANCE.w(TAG, "Failed to restore task " + r7 + " without animation", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return false;
    L37:
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(AOPlatformTools.INSTANCE.special().getTasks(100, false, false, 0), Iterable.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L34
        if (ZeusTransformUtils.instanceOf(r6, Collection.class) == true) goto L7;
    L9:
        Iterator r8 = r6.iterator();     // Catch: Exception -> L34
    L10:
        if (r8.hasNext() == false) goto L20;
        TaskInfo r9 = (TaskInfo) ZeusTransformUtils.preCheckCast(r8.next(), TaskInfo.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L34
        if (r9.taskId == r7) goto L15;
    L17:
        boolean r10 = false;
    L18:
        if (r10 == false) goto L10;
        boolean r11 = true;
    L21:
        if (r11 == false) goto L23;
        r3 = true;
        goto L24
    L15:
        if (r9.isRunning == false) goto L17;
        r10 = true;
    L20:
        r11 = false;
        goto L21
    L7:
        if (((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L9;
        goto L9
    }

    @Override // com.obric.autoaction.common.base.BaseActivity
    public void finish() {
        super.finish();
        overridePendingTransition(0, ZeusTransformUtils.mapRes(R.anim.activitiy_anim_fade_out_vd_player, "anim", "activitiy_anim_fade_out_vd_player"));
    }
}
