package com.obric.aiagent.product.platform.impl.windoweffects;

import android.animation.Animator;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.product.ObricProductSdk;
import com.obric.aiagent.product.a.e;
import com.obric.aiagent.product.platform.api.windoweffects.IWindowEffects;
import com.obric.aiagent.product.platform.impl.windoweffects.effects.android_common.AiScreenEdgeEffectView;
import com.obric.aiagent.product.platform.impl.windoweffects.effects_v2.android_common.RippleEffectView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.f;
import d.g;
import d.h.b.h;
import d.h.b.o;
import d.h.b.z;
import d.n;
import d.x;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: WindowEffectsImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a implements IWindowEffects {
    private static final String TAG = "WindowEffectsImpl";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0412a f18892a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f18893b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f18894c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final f f18895d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final f f18896e;
    private final f f;
    private final f g;
    private final Runnable h;
    private final f i;

    /* JADX INFO: renamed from: com.obric.aiagent.product.platform.impl.windoweffects.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: WindowEffectsImpl.kt */
    public static final class C0412a {
        public /* synthetic */ C0412a(h r1) {
            this();
        }

        private C0412a() {
        }
    }

    static {
        f18892a = new C0412a(null);
    }

    private final boolean g() {
        return true;
    }

    public static /* synthetic */ AiScreenEdgeEffectView lambda$86WI2ytsA8dvOJa2QT8RZHvdLAk() {
        return q();
    }

    /* JADX INFO: renamed from: lambda$GN787-rt37WgpQMuqNIh1i2riWY, reason: not valid java name */
    public static /* synthetic */ x m233lambda$GN787rt37WgpQMuqNIh1i2riWY(z.a r0, Animator r1) {
        return b(r0, r1);
    }

    public static /* synthetic */ x lambda$O2dW5cyF45OnpdDmaiQUHUZGBN4(a r0, boolean r1, String r2) {
        return b(r0, r1, r2);
    }

    public static /* synthetic */ x lambda$OwTfUZxMd2jtxSScNb0804uRZ18(a r0, boolean r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ x lambda$PJuz_iXZph3MCnv52VDRGrq5zjs(a r0, boolean r1, String r2) {
        return a(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$Rrcove7jSHTZuI8AuXUuu7ChAVE(a r0) {
        d(r0);
    }

    /* JADX INFO: renamed from: lambda$SWeT-l2paD7bQvDOZZn8301pXaM, reason: not valid java name */
    public static /* synthetic */ boolean m234lambda$SWeTl2paD7bQvDOZZn8301pXaM() {
        return p();
    }

    public static /* synthetic */ WindowManager lambda$WUt_5GopkiTXQLcGtPbBAYi_vqc() {
        return t();
    }

    public static /* synthetic */ void lambda$Xe0PLH59mDNm6Day0xuHKqImBG4() {
        u();
    }

    public static /* synthetic */ x lambda$Y7grqyUz3hAviWM2TBu63BBFYPQ(z.a r0, Animator r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ x lambda$_qWT4e6GA5lbJ2YIZ23nTM5gEUs(a r0) {
        return b(r0);
    }

    /* JADX INFO: renamed from: lambda$hFecMP1yV5-_GDuFHH7Sy2r41gk, reason: not valid java name */
    public static /* synthetic */ void m235lambda$hFecMP1yV5_GDuFHH7Sy2r41gk(a r0) {
        c(r0);
    }

    public static /* synthetic */ com.obric.aiagent.product.platform.impl.windoweffects.effects_v2.a.a lambda$j4DaCEkBv3sSDdOlXCoGMaBQ694() {
        return s();
    }

    /* JADX INFO: renamed from: lambda$kMnfmR-8-WW3TembALyriGv-kaw, reason: not valid java name */
    public static /* synthetic */ x m236lambda$kMnfmR8WW3TembALyriGvkaw(z.a r0, a r1, Animator r2) {
        return a(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$l4uJmSmsjdJ-gjmDHGJhl8mpDtY, reason: not valid java name */
    public static /* synthetic */ void m237lambda$l4uJmSmsjdJgjmDHGJhl8mpDtY() {
        v();
    }

    public static /* synthetic */ x lambda$rIqXB5yOuQmHICgAgtcBFqunW78(z.a r0, a r1, Animator r2) {
        return b(r0, r1, r2);
    }

    public static /* synthetic */ RippleEffectView lambda$rL6qzA563MK6Qwxpkn04XnUHDiU() {
        return r();
    }

    /* JADX INFO: renamed from: lambda$vCPT4BZ9tKTkOZ-LHw2kVfaL-EI, reason: not valid java name */
    public static /* synthetic */ x m238lambda$vCPT4BZ9tKTkOZLHw2kVfaLEI(AiScreenEdgeEffectView r0, a r1, Animator r2) {
        return a(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$xc2l9fQ-0SnW7T11PoxJjC6M_Go, reason: not valid java name */
    public static /* synthetic */ void m239lambda$xc2l9fQ0SnW7T11PoxJjC6M_Go(a r0) {
        a(r0);
    }

    public a() {
        ILogDepend.Companion.i(TAG, "WindowEffectsImpl: new instance");
        this.f18895d = g.a($$Lambda$a$SWeTl2paD7bQvDOZZn8301pXaM.INSTANCE);
        this.f18896e = g.a($$Lambda$a$86WI2ytsA8dvOJa2QT8RZHvdLAk.INSTANCE);
        this.f = g.a($$Lambda$a$rL6qzA563MK6Qwxpkn04XnUHDiU.INSTANCE);
        this.g = g.a($$Lambda$a$j4DaCEkBv3sSDdOlXCoGMaBQ694.INSTANCE);
        this.h = new $$Lambda$a$xc2l9fQ0SnW7T11PoxJjC6M_Go(this);
        this.i = g.a($$Lambda$a$WUt_5GopkiTXQLcGtPbBAYi_vqc.INSTANCE);
    }

    private final boolean a() {
        return ((Boolean) ZeusTransformUtils.preCheckCast(this.f18895d.b(), Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    }

    private static final boolean p() {
        return ObricProductSdk.INSTANCE.featureService().isObricOs();
    }

    private final AiScreenEdgeEffectView b() {
        return (AiScreenEdgeEffectView) ZeusTransformUtils.preCheckCast(this.f18896e.b(), AiScreenEdgeEffectView.class, "com.obric.aiagent.plugin");
    }

    private static final AiScreenEdgeEffectView q() {
        if (Build.VERSION.SDK_INT >= 33) goto L7;
        return null;
    L7:
        return new AiScreenEdgeEffectView((Context) ZeusTransformUtils.preCheckCast((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), null, 0, 360000, 6, null);
    }

    private final RippleEffectView c() {
        return (RippleEffectView) ZeusTransformUtils.preCheckCast(this.f.b(), RippleEffectView.class, "com.obric.aiagent.plugin");
    }

    private static final RippleEffectView r() {
        if (Build.VERSION.SDK_INT >= 33) goto L7;
        return null;
    L7:
        return new RippleEffectView((Context) ZeusTransformUtils.preCheckCast((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), null, 0, 6, null);
    }

    private final com.obric.aiagent.product.platform.impl.windoweffects.effects_v2.a.a d() {
        return (com.obric.aiagent.product.platform.impl.windoweffects.effects_v2.a.a) ZeusTransformUtils.preCheckCast(this.g.b(), com.obric.aiagent.product.platform.impl.windoweffects.effects_v2.a.a.class, "com.obric.aiagent.plugin");
    }

    private static final com.obric.aiagent.product.platform.impl.windoweffects.effects_v2.a.a s() {
        return new com.obric.aiagent.product.platform.impl.windoweffects.effects_v2.a.a((Context) ZeusTransformUtils.preCheckCast((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
    }

    private final WindowManager.LayoutParams e() {
        WindowManager.LayoutParams r6 = new WindowManager.LayoutParams(-1, -1, 2006, 218629400, -3);
        r6.windowAnimations = 0;
        r6.dimAmount = 0.0f;
        r6.gravity = 49;
        int r0 = Build.VERSION.SDK_INT;
        if (Build.VERSION.SDK_INT < 28) goto L5;
        r6.layoutInDisplayCutoutMode = 1;
    L5:
        a(r6);
        return r6;
    }

    private static final void a(a r3) {
        ILogDepend.Companion.i(TAG, "activeEffectShowTimeout");
        r3.stopActivateEffect();
    }

    private final WindowManager f() {
        return (WindowManager) ZeusTransformUtils.preCheckCast(this.i.b(), WindowManager.class, "com.obric.aiagent.plugin");
    }

    private static final WindowManager t() {
        Object r0 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getSystemService("window");
        o.a(r0, "null cannot be cast to non-null type android.view.WindowManager");
        return (WindowManager) ZeusTransformUtils.preCheckCast(r0, WindowManager.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.aiagent.product.platform.api.windoweffects.IWindowEffects
    public void startActivateEffect(final boolean r4) {
        ILogDepend.Companion.i(TAG, "startActivateEffect: withRipple = " + r4 + ", isObricOS = " + a());
        a("startActivateEffect", new $$Lambda$a$OwTfUZxMd2jtxSScNb0804uRZ18(this, r4));
    }

    private static final x a(a r4, boolean r5) {
        e.f18781a.a().removeCallbacks(r4.h);
        e.f18781a.a().postDelayed(r4.h, 300000);
        n.a r0 = n.f38560a;     // Catch: Throwable -> L9
        if (r4.g() == false) goto L6;
        r4.b(r5);     // Catch: Throwable -> L9
    L7:
        Object r6 = n.f(x.f38692a);     // Catch: Throwable -> L9
    L11:
        Throwable r7 = n.c(r6);
        if (r7 == null) goto L15;
        ILogDepend.Companion.e(TAG, "startActivateEffect failed: " + r7.getMessage(), r7);
    L15:
        return x.f38692a;
    L6:
        r4.a(r5);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        n.a r8 = n.f38560a;
        r6 = n.f(d.o.a(th));
        goto L11
    }

    @Override // com.obric.aiagent.product.platform.api.windoweffects.IWindowEffects
    public void stopActivateEffect() {
        ILogDepend.Companion.i(TAG, "stopActivateEffect");
        a("stopActivateEffect", new $$Lambda$a$_qWT4e6GA5lbJ2YIZ23nTM5gEUs(this));
    }

    private static final x b(a r3) {
        e.f18781a.a().removeCallbacks(r3.h);
        n.a r0 = n.f38560a;     // Catch: Throwable -> L5
        r3.h();     // Catch: Throwable -> L5
        r3.k();     // Catch: Throwable -> L5
        Object r4 = n.f(x.f38692a);     // Catch: Throwable -> L5
    L7:
        Throwable r5 = n.c(r4);
        if (r5 == null) goto L11;
        ILogDepend.Companion.e(TAG, "stopActivateEffect failed: " + r5.getMessage(), r5);
    L11:
        return x.f38692a;
    L5:
        th = move-exception;
        n.a r1 = n.f38560a;
        r4 = n.f(d.o.a(th));
        goto L7
    }

    @Override // com.obric.aiagent.product.platform.api.windoweffects.IWindowEffects
    public void showScreenShotEffect(final boolean r4, final String r5) {
        o.e(r5, "windowLayerName");
        ILogDepend.Companion.i(TAG, "showScreenShotEffect: isObricOS = " + a() + ", skipWindowLayer = " + r4 + ", windowLayerName = " + r5);
        a("showScreenShotEffect", new $$Lambda$a$PJuz_iXZph3MCnv52VDRGrq5zjs(this, r4, r5));
    }

    private static final x a(a r1, boolean r2, String r3) {
        n.a r0 = n.f38560a;     // Catch: Throwable -> L8
        if (r1.g() == false) goto L5;
        r1.a(r2, r3);     // Catch: Throwable -> L8
    L6:
        Object r4 = n.f(x.f38692a);     // Catch: Throwable -> L8
    L10:
        Throwable r5 = n.c(r4);
        if (r5 == null) goto L14;
        ILogDepend.Companion.e(TAG, "showScreenShotEffect failed: " + r5.getMessage(), r5);
    L14:
        return x.f38692a;
    L5:
        r1.i();     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        n.a r6 = n.f38560a;
        r4 = n.f(d.o.a(th));
        goto L10
    }

    @Override // com.obric.aiagent.product.platform.api.windoweffects.IWindowEffects
    public void playRippleEffect(final boolean r4, final String r5) {
        o.e(r5, "windowLayerName");
        ILogDepend.Companion.i(TAG, "playRippleEffect: isObricOS = " + a() + ", skipWindowLayer = " + r4 + ", windowLayerName = " + r5);
        a("playRippleEffect", new $$Lambda$a$O2dW5cyF45OnpdDmaiQUHUZGBN4(this, r4, r5));
    }

    private static final x b(a r1, boolean r2, String r3) {
        n.a r0 = n.f38560a;     // Catch: Throwable -> L8
        if (r1.g() == false) goto L5;
        r1.b(r2, r3);     // Catch: Throwable -> L8
    L6:
        Object r4 = n.f(x.f38692a);     // Catch: Throwable -> L8
    L10:
        Throwable r5 = n.c(r4);
        if (r5 == null) goto L14;
        ILogDepend.Companion.e(TAG, "playRippleEffect failed: " + r5.getMessage(), r5);
    L14:
        return x.f38692a;
    L5:
        r1.j();     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        n.a r6 = n.f38560a;
        r4 = n.f(d.o.a(th));
        goto L10
    }

    private final void a(String r3, d.h.a.a<x> r4) {
        d.h.a.a r2 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin");
        if (Build.VERSION.SDK_INT >= 33) goto L6;
        ILogDepend.Companion.w(TAG, r3 + ": isSupportWindowEffects is false");
        return;
    L6:
        e.f18781a.b((Runnable) ZeusTransformUtils.preCheckCast(new e.b(r2), Runnable.class, "com.obric.aiagent.plugin"));
    }

    private final void a(boolean r4) {
        l();
        AiScreenEdgeEffectView r0 = b();
        if (r0 == null) goto L8;
        r0.prepareToShow();
        AiScreenEdgeEffectView.playFadeInAnimation$default(r0, null, null, 3, null);
        if (r4 == false) goto L9;
        AiScreenEdgeEffectView.playShimmerAnimation$default(r0, null, 1, null);
        j();
        return;
    L9:
        return;
    }

    private final void h() {
        AiScreenEdgeEffectView r0 = b();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isPlayingCaptureAnimation() == false) goto L7;
        return;
    L7:
        final z.a r1 = new z.a();
        r0.playFadeOutAnimation(new $$Lambda$a$kMnfmR8WW3TembALyriGvkaw(r1, this), new $$Lambda$a$Y7grqyUz3hAviWM2TBu63BBFYPQ(r1));
    }

    private static final x a(z.a r2, a r3, Animator r4) {
        ILogDepend.Companion.i(TAG, "stopV1ActivateEffect onEnd");
        if (r2.f38499a == true) goto L6;
        r3.m();
    L6:
        return x.f38692a;
    }

    private static final x a(z.a r2, Animator r3) {
        o.e(r3, "it");
        ILogDepend.Companion.i(TAG, "stopV1ActivateEffect onCancel");
        r2.f38499a = true;
        return x.f38692a;
    }

    private final void i() {
        l();
        final AiScreenEdgeEffectView r0 = b();
        if (r0 == null) goto L6;
        r0.prepareToShow();
        AiScreenEdgeEffectView.playFadeInAnimation$default(r0, null, null, 3, null);
        r0.playCaptureAnimation(new $$Lambda$a$vCPT4BZ9tKTkOZLHw2kVfaLEI(r0, this));
        return;
    }

    private static final x a(AiScreenEdgeEffectView r1, final a r2, Animator r3) {
        o.e(r3, "it");
        if (r1.isPlayingShimmerAnimation() == true) goto L6;
        final z.a r4 = new z.a();
        r1.playFadeOutAnimation(new $$Lambda$a$rIqXB5yOuQmHICgAgtcBFqunW78(r4, r2), new $$Lambda$a$GN787rt37WgpQMuqNIh1i2riWY(r4));
    L6:
        return x.f38692a;
    }

    private static final x b(z.a r2, a r3, Animator r4) {
        ILogDepend.Companion.i(TAG, "showV1ScreenShotEffect onEnd");
        if (r2.f38499a == true) goto L6;
        r3.m();
    L6:
        return x.f38692a;
    }

    private static final x b(z.a r2, Animator r3) {
        o.e(r3, "it");
        ILogDepend.Companion.i(TAG, "showV1ScreenShotEffect onCancel");
        r2.f38499a = true;
        return x.f38692a;
    }

    private final void j() {
        ILogDepend.Companion.i(TAG, "playV1RippleEffect start");
        com.obric.aiagent.product.platform.impl.windoweffects.effects.os_specific.a.f18897a.a();
    }

    private final void b(boolean r2) {
        if (r2 == false) goto L4;
        b(true, "obric-assistant-window");
        return;
    L4:
        ILogDepend.Companion.i(TAG, "startV2ActivateEffect: no activate overlay for v2");
    }

    private final void a(boolean r4, String r5) {
        ILogDepend.Companion.i(TAG, "showV2ScreenShotEffect start, skipWindowLayer = " + r4 + ", windowLayerName = " + r5);
        if (a() == true) goto L16;
        n();
        RippleEffectView r6 = c();
        if (r6 == null) goto L19;
        r6.playCaptureEffect(new $$Lambda$a$hFecMP1yV5_GDuFHH7Sy2r41gk(this));
        return;
    L19:
        return;
    L16:
        n.a r0 = n.f38560a;     // Catch: Throwable -> L6
        ((a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin")).d().b(r4, r5, $$Lambda$a$Xe0PLH59mDNm6Day0xuHKqImBG4.INSTANCE);     // Catch: Throwable -> L6
        Object r3 = n.f(x.f38692a);     // Catch: Throwable -> L6
    L8:
        Throwable r7 = n.c(r3);
        if (r7 == null) goto L11;
        ILogDepend.Companion.w(TAG, "playCaptureEffect failed: " + r7.getMessage(), r7);
    L11:
        n.g(r3);
        return;
    L6:
        th = move-exception;
        n.a r8 = n.f38560a;
        r3 = n.f(d.o.a(th));
        goto L8
    }

    private static final void u() {
        ILogDepend.Companion.i(TAG, "playCaptureEffect end");
    }

    private static final void c(a r3) {
        ILogDepend.Companion.i(TAG, "showV2ScreenShotEffect android_common end");
        r3.o();
    }

    private final void b(boolean r4, String r5) {
        ILogDepend.Companion.i(TAG, "playV2RippleEffect start, skipWindowLayer = " + r4 + ", windowLayerName = " + r5);
        if (a() == true) goto L16;
        n();
        RippleEffectView r6 = c();
        if (r6 == null) goto L19;
        r6.playWakeUpEffect(new $$Lambda$a$Rrcove7jSHTZuI8AuXUuu7ChAVE(this));
        return;
    L19:
        return;
    L16:
        n.a r0 = n.f38560a;     // Catch: Throwable -> L6
        ((a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin")).d().a(r4, r5, $$Lambda$a$l4uJmSmsjdJgjmDHGJhl8mpDtY.INSTANCE);     // Catch: Throwable -> L6
        Object r3 = n.f(x.f38692a);     // Catch: Throwable -> L6
    L8:
        Throwable r7 = n.c(r3);
        if (r7 == null) goto L11;
        ILogDepend.Companion.w(TAG, "playWakeUpEffect failed: " + r7.getMessage(), r7);
    L11:
        n.g(r3);
        return;
    L6:
        th = move-exception;
        n.a r8 = n.f38560a;
        r3 = n.f(d.o.a(th));
        goto L8
    }

    private static final void v() {
        ILogDepend.Companion.i(TAG, "playWakeUpEffect end");
    }

    private static final void d(a r3) {
        ILogDepend.Companion.i(TAG, "playV2RippleEffect android_common end");
        r3.o();
    }

    private final void k() {
        if (a() == true) goto L17;
        RippleEffectView r0 = c();
        if (r0 == null) goto L15;
        r0.stop();
    L15:
        o();
        return;
    L17:
        n.a r1 = n.f38560a;     // Catch: Throwable -> L6
        ((a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin")).d().b();     // Catch: Throwable -> L6
        Object r4 = n.f(x.f38692a);     // Catch: Throwable -> L6
    L8:
        Throwable r2 = n.c(r4);
        if (r2 == null) goto L11;
        ILogDepend.Companion.w(TAG, "stopEffect failed: " + r2.getMessage(), r2);
    L11:
        n.g(r4);
        return;
    L6:
        th = move-exception;
        n.a r3 = n.f38560a;
        r4 = n.f(d.o.a(th));
        goto L8
    }

    private final void l() {
        AiScreenEdgeEffectView r0 = b();
        if (r0 != null) goto L7;
        a r5 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
        ILogDepend.Companion.w(TAG, "addV1OverlayView: v1OverlayView is null");
        return;
    L7:
        if (this.f18893b == false) goto L10;
        ILogDepend.Companion.w(TAG, "addV1OverlayView is already added");
        return;
    L10:
        ILogDepend.Companion.i(TAG, "addV1OverlayView");
        this.f18893b = true;
        n.a r3 = n.f38560a;     // Catch: Throwable -> L13
        f().addView((View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.aiagent.plugin"), (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(e(), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L13
        Object r6 = n.f(x.f38692a);     // Catch: Throwable -> L13
    L15:
        Throwable r7 = n.c(r6);
        if (r7 == null) goto L21;
        ILogDepend.Companion.w(TAG, "addV1OverlayView failed: " + r7.getMessage(), r7);
        return;
    L21:
        return;
    L13:
        th = move-exception;
        n.a r1 = n.f38560a;
        r6 = n.f(d.o.a(th));
        goto L15
    }

    private final void m() {
        AiScreenEdgeEffectView r0 = b();
        if (r0 == null) goto L6;
        r0.cancelShow();
    L6:
        if (this.f18893b == true) goto L9;
        ILogDepend.Companion.i(TAG, "removeV1OverlayView is not added");
        return;
    L9:
        ILogDepend.Companion.i(TAG, "removeV1OverlayView");
        this.f18893b = false;
        n.a r1 = n.f38560a;     // Catch: Throwable -> L12
        f().removeView((View) ZeusTransformUtils.preCheckCast(b(), View.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L12
        Object r4 = n.f(x.f38692a);     // Catch: Throwable -> L12
    L14:
        Throwable r5 = n.c(r4);
        if (r5 == null) goto L20;
        ILogDepend.Companion.w(TAG, "removeV1OverlayView failed: " + r5.getMessage());
        return;
    L20:
        return;
    L12:
        th = move-exception;
        n.a r2 = n.f38560a;
        r4 = n.f(d.o.a(th));
        goto L14
    }

    private final void n() {
        RippleEffectView r0 = c();
        if (r0 != null) goto L7;
        a r5 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
        ILogDepend.Companion.w(TAG, "addV2OverlayView: v2RippleEffectView is null");
        return;
    L7:
        if (this.f18894c == false) goto L10;
        ILogDepend.Companion.w(TAG, "addV2OverlayView is already added");
        return;
    L10:
        this.f18894c = true;
        ILogDepend.Companion.i(TAG, "addV2OverlayView");
        n.a r3 = n.f38560a;     // Catch: Throwable -> L13
        f().addView((View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.aiagent.plugin"), (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(e(), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L13
        Object r6 = n.f(x.f38692a);     // Catch: Throwable -> L13
    L15:
        Throwable r7 = n.c(r6);
        if (r7 == null) goto L21;
        ILogDepend.Companion.w(TAG, "addV2OverlayView failed: " + r7.getMessage(), r7);
        return;
    L21:
        return;
    L13:
        th = move-exception;
        n.a r1 = n.f38560a;
        r6 = n.f(d.o.a(th));
        goto L15
    }

    private final void o() {
        if (this.f18894c == true) goto L6;
        ILogDepend.Companion.i(TAG, "removeV2OverlayView is not added");
        return;
    L6:
        ILogDepend.Companion.i(TAG, "removeV2OverlayView");
        this.f18894c = false;
        n.a r0 = n.f38560a;     // Catch: Throwable -> L9
        f().removeView((View) ZeusTransformUtils.preCheckCast(c(), View.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L9
        Object r4 = n.f(x.f38692a);     // Catch: Throwable -> L9
    L11:
        Throwable r5 = n.c(r4);
        if (r5 == null) goto L17;
        ILogDepend.Companion.w(TAG, "removeV2OverlayView failed: " + r5.getMessage(), r5);
        return;
    L17:
        return;
    L9:
        th = move-exception;
        n.a r1 = n.f38560a;
        r4 = n.f(d.o.a(th));
        goto L11
    }

    private final void a(WindowManager.LayoutParams r5) {
        if (Build.VERSION.SDK_INT >= 31) goto L14;
        ILogDepend.Companion.i(TAG, "setTrustedOverlayReflectively failed, sdk version < 31");
        return;
    L14:
        n.a r4 = n.f38560a;     // Catch: Throwable -> L6
        Method r6 = WindowManager.LayoutParams.class.getDeclaredMethod("setTrustedOverlay", new Class[0]);     // Catch: Throwable -> L6
        r6.setAccessible(true);     // Catch: Throwable -> L6
        Object r7 = n.f(r6.invoke(r5, new Object[0]));     // Catch: Throwable -> L6
    L8:
        Throwable r8 = n.c(r7);
        if (r8 == null) goto L11;
        ILogDepend.Companion.w(TAG, "setTrustedOverlayReflectively failed", r8);
    L11:
        n.g(r7);
        return;
    L6:
        th = move-exception;
        n.a r9 = n.f38560a;
        r7 = n.f(d.o.a(th));
        goto L8
    }
}
