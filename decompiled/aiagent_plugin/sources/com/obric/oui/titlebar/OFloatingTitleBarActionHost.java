package com.obric.oui.titlebar;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.h.b.p;
import d.h.b.z;
import d.x;
import java.util.Iterator;

/* JADX INFO: compiled from: OFloatingTitleBarActionHost.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class OFloatingTitleBarActionHost extends FrameLayout {
    public static final a Companion = null;
    private static final long HOST_MOVE_DURATION = 500;
    private final OFloatingTitleBar actionTitleBar;
    private OFloatingTitleBar boundTitleBar;
    private final PathInterpolator easeInOut;
    private int floatingApplyGeneration;
    private boolean floatingTransitionActionsHidden;
    private b floatingTransitionEndListener;
    private int hostTransitionGeneration;
    private c pendingBind;
    private OFloatingTitleBar pendingTakeOverOnPreDrawTitleBar;
    private OFloatingTitleBar pendingTakeOverTitleBar;
    private boolean pendingUnbindPosted;
    private OFloatingTitleBar pendingUnbindTitleBar;
    private OFloatingTitleBar preHiddenTitleBar;
    private c waitingReadyBind;
    private OFloatingTitleBar waitingReadyTitleBar;

    /* JADX INFO: compiled from: OFloatingTitleBarActionHost.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: OFloatingTitleBarActionHost.kt */
    public interface b {
        void a(OFloatingTitleBar r1);
    }

    /* JADX INFO: compiled from: OFloatingTitleBarActionHost.kt */
    private static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final OFloatingTitleBar f36603a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f36604b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f36605c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private com.obric.oui.titlebar.a f36606d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f36607e;
        private boolean f;
        private boolean g;
        private boolean h;
        private int i;
        private boolean j;
        private boolean k;
        private boolean l;

        public c(OFloatingTitleBar r2, boolean r3, boolean r4) {
            o.e(r2, "titleBar");
            this.f36603a = r2;
            this.f36604b = r3;
            this.f36605c = r4;
        }

        public final OFloatingTitleBar a() {
            return this.f36603a;
        }

        public final boolean b() {
            return this.f36604b;
        }

        public final boolean c() {
            return this.f36605c;
        }

        public final void a(com.obric.oui.titlebar.a r1) {
            this.f36606d = r1;
        }

        public final com.obric.oui.titlebar.a d() {
            return this.f36606d;
        }

        public final void a(boolean r1) {
            this.f36607e = r1;
        }

        public final boolean e() {
            return this.f36607e;
        }

        public final void b(boolean r1) {
            this.f = r1;
        }

        public final boolean f() {
            return this.f;
        }

        public final void c(boolean r1) {
            this.g = r1;
        }

        public final boolean g() {
            return this.g;
        }

        public final void d(boolean r1) {
            this.h = r1;
        }

        public final boolean h() {
            return this.h;
        }

        public final void a(int r1) {
            this.i = r1;
        }

        public final int i() {
            return this.i;
        }

        public final void e(boolean r1) {
            this.j = r1;
        }

        public final boolean j() {
            return this.j;
        }

        public final void f(boolean r1) {
            this.k = r1;
        }

        public final boolean k() {
            return this.k;
        }

        public final void g(boolean r1) {
            this.l = r1;
        }

        public final boolean l() {
            return this.l;
        }
    }

    /* JADX INFO: compiled from: OFloatingTitleBarActionHost.kt */
    static final class d extends p implements d.h.a.a<x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OFloatingTitleBarActionHost f36608a;

        d(OFloatingTitleBarActionHost r1) {
            this.f36608a = r1;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ x invoke() {
            a();
            return x.f38692a;
        }

        public final void a() {
            OFloatingTitleBarActionHost.access$interruptFloatingTransitionForActionChange(this.f36608a);
        }
    }

    /* JADX INFO: compiled from: OFloatingTitleBarActionHost.kt */
    static final class e extends p implements d.h.a.a<x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d.h.a.a<x> f36609a;

        e(d.h.a.a<x> r3) {
            this.f36609a = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ x invoke() {
            a();
            return x.f38692a;
        }

        public final void a() {
            this.f36609a.invoke();
        }
    }

    /* JADX INFO: compiled from: OFloatingTitleBarActionHost.kt */
    static final class f extends p implements d.h.a.a<x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ z.a f36610a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f36611b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ OFloatingTitleBarActionHost f36612c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ z.d f36613d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ z.a f36614e;
        final /* synthetic */ d.h.a.a<x> f;

        f(z.a r3, int r4, OFloatingTitleBarActionHost r5, z.d r6, z.a r7, d.h.a.a<x> r8) {
            d.h.a.a<x> r9 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r8, d.h.a.a.class, "com.obric.aiagent.plugin");
            this.f36610a = r3;
            this.f36611b = r4;
            this.f36612c = r5;
            this.f36613d = r6;
            this.f36614e = r7;
            this.f = r9;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ x invoke() {
            a();
            return x.f38692a;
        }

        public final void a() {
            if (this.f36610a.f38499a == true) goto L16;
            this.f36610a.f38499a = true;
            if (this.f36611b == OFloatingTitleBarActionHost.access$getFloatingApplyGeneration$p(this.f36612c)) goto L7;
            return;
        L7:
            this.f36613d.f38502a--;
            if (this.f36613d.f38502a == 0) goto L10;
            return;
        L10:
            if (this.f36614e.f38499a == true) goto L18;
            this.f36614e.f38499a = true;
            d.h.a.a<x> r3 = this.f;
            if (r3 == null) goto L19;
            r3.invoke();
            return;
        L19:
            return;
        L18:
            return;
        }
    }

    /* JADX INFO: compiled from: OFloatingTitleBarActionHost.kt */
    static final class g extends p implements d.h.a.a<x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f36615a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ OFloatingTitleBarActionHost f36616b;

        g(c r1, OFloatingTitleBarActionHost r2) {
            this.f36615a = r1;
            this.f36616b = r2;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ x invoke() {
            a();
            return x.f38692a;
        }

        public final void a() {
            this.f36615a.e(true);
            OFloatingTitleBarActionHost.access$dispatchHostTransitionEndIfReady(this.f36616b, this.f36615a);
        }
    }

    /* JADX INFO: compiled from: OFloatingTitleBarActionHost.kt */
    static final class h extends p implements d.h.a.a<x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f36617a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ OFloatingTitleBarActionHost f36618b;

        h(c r1, OFloatingTitleBarActionHost r2) {
            this.f36617a = r1;
            this.f36618b = r2;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ x invoke() {
            a();
            return x.f38692a;
        }

        public final void a() {
            this.f36617a.f(true);
            OFloatingTitleBarActionHost.access$dispatchHostTransitionEndIfReady(this.f36618b, this.f36617a);
        }
    }

    static {
        Companion = new a(null);
    }

    public OFloatingTitleBarActionHost(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public OFloatingTitleBarActionHost(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    /* JADX INFO: renamed from: lambda$9RuFAWXXdulftXr3ZvfF-rCOoRo, reason: not valid java name */
    public static /* synthetic */ void m1222lambda$9RuFAWXXdulftXr3ZvfFrCOoRo(OFloatingTitleBarActionHost r0, c r1) {
        m1225schedulePrepareOnFrame$lambda3(r0, r1);
    }

    public static /* synthetic */ void lambda$EggWLjanIE3aSMXL8eb1W6Y0_lU(OFloatingTitleBarActionHost r0, OFloatingTitleBar r1, c r2) {
        m1221bindWhenReady$lambda4(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$UrYTT8MKLIoAtFPGhrF0taLZ5F4(OFloatingTitleBarActionHost r0, OFloatingTitleBar r1) {
        m1227unbind$lambda8(r0, r1);
    }

    public static /* synthetic */ void lambda$VrsN_ATLg5kasmH7B3Z4GnuHajE(ViewGroup.MarginLayoutParams r0, int r1, int r2, OFloatingTitleBarActionHost r3, d.h.a.a r4) {
        m1224moveTo$lambda14(r0, r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: lambda$ma5ay1uA9GbLsUGRfk0aknNNk-c, reason: not valid java name */
    public static /* synthetic */ void m1223lambda$ma5ay1uA9GbLsUGRfk0aknNNkc(OFloatingTitleBarActionHost r0, OFloatingTitleBar r1) {
        m1226takeOverActionsOnNextPreDraw$lambda7(r0, r1);
    }

    public static /* synthetic */ void lambda$phpFwB8HvAAVn0Vu8TkPRkfu2f0(OFloatingTitleBarActionHost r0, ValueAnimator r1) {
        m1219applyState$lambda15(r0, r1);
    }

    public static /* synthetic */ void lambda$qRkEjhU1iw3v649PloguUcFL00U(OFloatingTitleBarActionHost r0, d.h.a.a r1) {
        m1220applyState$lambda16(r0, r1);
    }

    public final void applyState$OUI_standardRelease(com.obric.oui.titlebar.a r10) {
        o.e(r10, "state");
        applyState$OUI_standardRelease$default(this, r10, false, false, null, null, 30, null);
    }

    public final void applyState$OUI_standardRelease(com.obric.oui.titlebar.a r10, boolean r11) {
        o.e(r10, "state");
        applyState$OUI_standardRelease$default(this, r10, r11, false, null, null, 28, null);
    }

    public final void applyState$OUI_standardRelease(com.obric.oui.titlebar.a r10, boolean r11, boolean r12) {
        o.e(r10, "state");
        applyState$OUI_standardRelease$default(this, r10, r11, r12, null, null, 24, null);
    }

    public final void applyState$OUI_standardRelease(com.obric.oui.titlebar.a r10, boolean r11, boolean r12, Float r13) {
        o.e(r10, "state");
        applyState$OUI_standardRelease$default(this, r10, r11, r12, r13, null, 16, null);
    }

    public final void bind(OFloatingTitleBar r4) {
        o.e(r4, "titleBar");
        bind$default(this, r4, false, 2, null);
    }

    public final void unbind() {
        unbind$default(this, null, 1, null);
    }

    public /* synthetic */ OFloatingTitleBarActionHost(Context r2, AttributeSet r3, int r4, int r5, d.h.b.h r6) {
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

    public static final /* synthetic */ void access$dispatchHostTransitionEndIfReady(OFloatingTitleBarActionHost r0, c r1) {
        r0.dispatchHostTransitionEndIfReady(r1);
    }

    public static final /* synthetic */ OFloatingTitleBar access$getBoundTitleBar$p(OFloatingTitleBarActionHost r0) {
        return r0.boundTitleBar;
    }

    public static final /* synthetic */ int access$getFloatingApplyGeneration$p(OFloatingTitleBarActionHost r0) {
        return r0.floatingApplyGeneration;
    }

    public static final /* synthetic */ c access$getPendingBind$p(OFloatingTitleBarActionHost r0) {
        return r0.pendingBind;
    }

    public static final /* synthetic */ OFloatingTitleBar access$getPendingTakeOverOnPreDrawTitleBar$p(OFloatingTitleBarActionHost r0) {
        return r0.pendingTakeOverOnPreDrawTitleBar;
    }

    public static final /* synthetic */ c access$getWaitingReadyBind$p(OFloatingTitleBarActionHost r0) {
        return r0.waitingReadyBind;
    }

    public static final /* synthetic */ OFloatingTitleBar access$getWaitingReadyTitleBar$p(OFloatingTitleBarActionHost r0) {
        return r0.waitingReadyTitleBar;
    }

    public static final /* synthetic */ void access$interruptFloatingTransitionForActionChange(OFloatingTitleBarActionHost r0) {
        r0.interruptFloatingTransitionForActionChange();
    }

    public static final /* synthetic */ void access$schedulePrepareOnFrame(OFloatingTitleBarActionHost r0, c r1) {
        r0.schedulePrepareOnFrame(r1);
    }

    public static final /* synthetic */ void access$setPendingTakeOverOnPreDrawTitleBar$p(OFloatingTitleBarActionHost r0, OFloatingTitleBar r1) {
        r0.pendingTakeOverOnPreDrawTitleBar = r1;
    }

    public static final /* synthetic */ void access$setWaitingReadyBind$p(OFloatingTitleBarActionHost r0, c r1) {
        r0.waitingReadyBind = r1;
    }

    public static final /* synthetic */ void access$setWaitingReadyTitleBar$p(OFloatingTitleBarActionHost r0, OFloatingTitleBar r1) {
        r0.waitingReadyTitleBar = r1;
    }

    public static final /* synthetic */ void access$takeOverActions(OFloatingTitleBarActionHost r0, OFloatingTitleBar r1) {
        r0.takeOverActions(r1);
    }

    public OFloatingTitleBarActionHost(Context r9, AttributeSet r10, int r11) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r12 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        super(r3, r12, r11);
        this.easeInOut = new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
        OFloatingTitleBar r13 = new OFloatingTitleBar(r3, null, 0, 6, null);
        r13.setClipChildren(false);
        r13.setClipToPadding(false);
        r13.setImportantForAccessibility(4);
        r13.setKeepActionInteractiveWhenHidden$OUI_standardRelease(true);
        r13.setActionChangeInterruptCallback$OUI_standardRelease((d.h.a.a) ZeusTransformUtils.preCheckCast(new d(this), d.h.a.a.class, "com.obric.aiagent.plugin"));
        r13.setFloatingTransitionOwnerActive$OUI_standardRelease(false);
        OFloatingTitleBar.setActionContentVisible$OUI_standardRelease$default(r13, true, false, 2, null);
        r13.setNonActionContentVisible$OUI_standardRelease(false);
        r13.setTitleBarContainerClickable$OUI_standardRelease(false);
        this.actionTitleBar = r13;
        setClipChildren(false);
        setClipToPadding(false);
        setWillNotDraw(false);
        setVisibility(8);
        addView((View) ZeusTransformUtils.preCheckCast(r13, View.class, "com.obric.aiagent.plugin"), (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new FrameLayout.LayoutParams(-1, -2), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        disableClipRecursively((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"));
    }

    private final void disableClipRecursively(View r5) {
        if (ZeusTransformUtils.instanceOf(r5, ViewGroup.class) == false) goto L5;
        ViewGroup r6 = (ViewGroup) ZeusTransformUtils.preCheckCast(r5, ViewGroup.class, "com.obric.aiagent.plugin");
    L6:
        if (r6 == null) goto L11;
        int r0 = 0;
        r6.setClipChildren(false);
        r6.setClipToPadding(false);
        int r1 = r6.getChildCount();
    L9:
        if (r0 >= r1) goto L13;
        int r2 = r0 + 1;
        View r3 = r6.getChildAt(r0);
        o.c(r3, "group.getChildAt(i)");
        disableClipRecursively(r3);
        r0 = r2;
        goto L9
    L13:
        return;
    L11:
        return;
    L5:
        r6 = null;
        goto L6
    }

    public final void useSurfaceBackdropMaterial$OUI_standardRelease() {
        this.actionTitleBar.updateBackdropSrcType(4);
    }

    public final void setFloatingTransitionDrawUpdateListener$OUI_standardRelease(d.h.a.a<x> r3) {
        d.h.a.a<x> r4 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
        this.actionTitleBar.setFloatingTransitionDrawUpdateListener$OUI_standardRelease(r4);
    }

    public final void setFloatingTransitionEndListener(b r3) {
        this.floatingTransitionEndListener = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
    }

    public final void hideFloatingTransitionActions$OUI_standardRelease(boolean r3) {
        if (com.obric.oui.titlebar.floating.a.a() == true) goto L6;
        return;
    L6:
        if (this.floatingTransitionActionsHidden != r3) goto L8;
        return;
    L8:
        this.floatingTransitionActionsHidden = r3;
        applyFloatingTransitionActionVisibility();
        if (r3 == false) goto L11;
        return;
    L11:
        if (getVisibility() != 0) goto L18;
        OFloatingTitleBar r2 = this.boundTitleBar;
        if (r2 == null) goto L19;
        OFloatingTitleBar.setActionContentVisible$OUI_standardRelease$default(r2, false, false, 2, null);
        return;
    L19:
        return;
    }

    public static /* synthetic */ void bind$default(OFloatingTitleBarActionHost r0, OFloatingTitleBar r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = true;
    L5:
        r0.bind(r1, r2);
    }

    public final void bind(OFloatingTitleBar r12, boolean r13) {
        o.e(r12, "titleBar");
        if (com.obric.oui.titlebar.floating.a.a() == true) goto L5;
        return;
    L5:
        OFloatingTitleBar r0 = this.boundTitleBar;
        boolean r1 = false;
        c r2 = null;
        if (r0 == r12) goto L26;
        if (r0 == null) goto L10;
        r0.setFloatingTransitionOwnerActive$OUI_standardRelease(false);
    L10:
        c r3 = this.pendingBind;
        if (r3 != null) goto L13;
        OFloatingTitleBar r4 = null;
    L14:
        if (r4 == r12) goto L22;
        c r5 = this.pendingBind;
        if (r5 == null) goto L22;
        OFloatingTitleBar r6 = r5.a();
        if (r6 == null) goto L22;
        r6.setFloatingTransitionOwnerActive$OUI_standardRelease(false);
    L22:
        OFloatingTitleBar r7 = this.boundTitleBar;
        if (r7 == null) goto L26;
        r7.interruptFloatingTransitionForHostTargetChange$OUI_standardRelease();
        goto L26
    L13:
        r4 = r3.a();
    L26:
        r12.onActionHostBound$OUI_standardRelease(this);
        r12.setFloatingTransitionOwnerActive$OUI_standardRelease(true);
        if (this.pendingUnbindTitleBar == null) goto L30;
        this.pendingUnbindTitleBar = null;
        this.pendingUnbindPosted = false;
    L30:
        if (hasTakenOverActions() == true) goto L35;
        if (this.boundTitleBar == r12) goto L35;
        clearDeferredTakeOver();
    L35:
        if (hasTakenOverActions() == true) goto L37;
    L43:
        c r8 = this.pendingBind;
        if (r8 != null) goto L47;
    L51:
        c r9 = new c(r12, r13, shouldDeferTakeOverActions());
        if (r2 == null) goto L54;
        r9.b(r2.f());
        r9.c(r2.g());
    L54:
        this.pendingBind = r9;
        beginPrepareBind(r9);
        return;
    L47:
        if (r8.a() != r12) goto L49;
        r1 = true;
    L49:
        if (r1 == false) goto L51;
        r2 = r8;
        goto L51
    L37:
        if (this.boundTitleBar != r12) goto L43;
        this.pendingBind = null;
        if (this.waitingReadyTitleBar != r12) goto L41;
        this.waitingReadyTitleBar = null;
        this.waitingReadyBind = null;
    L41:
        applyState$OUI_standardRelease$default(this, r12.captureHostSyncState$OUI_standardRelease(), r13, false, null, null, 28, null);
        takeOverActions(r12);
    }

    private final void beginPrepareBind(c r7) {
        OFloatingTitleBar r0 = r7.a();
        if (r7.c() == false) goto L6;
        setVisibility(4);
    L6:
        if (shouldPreHideTarget(r0) == false) goto L13;
        OFloatingTitleBar r1 = this.preHiddenTitleBar;
        if (r1 == null) goto L11;
        OFloatingTitleBar.setActionContentVisible$OUI_standardRelease$default(r1, true, false, 2, null);
    L11:
        OFloatingTitleBar.setActionContentVisible$OUI_standardRelease$default(r0, false, false, 2, null);
        this.preHiddenTitleBar = r0;
    L13:
        if (r0.isLaidOut() == true) goto L15;
    L21:
        bindWhenReady(r7);
        return;
    L15:
        if (r0.isLayoutRequested() == true) goto L21;
        if (getParent() == null) goto L21;
        schedulePrepareOnFrame(r7);
    }

    private final void schedulePrepareOnFrame(final c r2) {
        postOnAnimation(new $$Lambda$OFloatingTitleBarActionHost$9RuFAWXXdulftXr3ZvfFrCOoRo(this, r2));
    }

    /* JADX INFO: renamed from: schedulePrepareOnFrame$lambda-3, reason: not valid java name */
    private static final void m1225schedulePrepareOnFrame$lambda3(OFloatingTitleBarActionHost r2, c r3) {
        o.e(r2, "this$0");
        o.e(r3, "$bind");
        if (r2.isActiveBind(r3) == true) goto L5;
        return;
    L5:
        OFloatingTitleBar r0 = r3.a();
        if (r0.isLaidOut() == true) goto L8;
    L14:
        r2.bindWhenReady(r3);
        return;
    L8:
        if (r0.isLayoutRequested() == true) goto L14;
        if (r2.getParent() == null) goto L14;
        r2.prepareReady(r3);
    }

    private final void prepareReady(c r2) {
        if (isActiveBind(r2) == true) goto L5;
        return;
    L5:
        r2.a(r2.a().captureState());
        r2.a(true);
        if (r2.f() == false) goto L8;
    L11:
        startPendingHostTransition(r2);
        return;
    L8:
        if (r2.g() == true) goto L11;
        if (shouldSyncTakenOverTitleBar(r2) == true) goto L11;
    }

    private final boolean shouldSyncTakenOverTitleBar(c r2) {
        if (hasTakenOverActions() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.boundTitleBar != r2.a()) goto L7;
        return true;
    }

    private final void startPendingHostTransition(c r13) {
        if (isActiveBind(r13) == true) goto L5;
        return;
    L5:
        if (r13.h() == false) goto L8;
        return;
    L8:
        if (r13.e() == true) goto L11;
        r13.b(true);
        return;
    L11:
        OFloatingTitleBar r0 = r13.a();
        if (r13.b() == true) goto L14;
    L16:
        boolean r2 = false;
    L17:
        com.obric.oui.titlebar.a r3 = r13.d();
        if (r3 != null) goto L20;
        r3 = r0.captureState();
    L20:
        com.obric.oui.titlebar.a r4 = r3;
        this.boundTitleBar = r0;
        r13.d(true);
        int r5 = this.hostTransitionGeneration + 1;
        this.hostTransitionGeneration = r5;
        r13.a(r5);
        if (r13.c() == false) goto L23;
        this.pendingTakeOverTitleBar = r0;
    L23:
        applyState$OUI_standardRelease$default(this, r4, r2, false, null, (d.h.a.a) ZeusTransformUtils.preCheckCast(new g(r13, this), d.h.a.a.class, "com.obric.aiagent.plugin"), 12, null);
        moveTo((View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.aiagent.plugin"), r2, (d.h.a.a) ZeusTransformUtils.preCheckCast(new h(r13, this), d.h.a.a.class, "com.obric.aiagent.plugin"));
        if (r13.c() == true) goto L26;
        takeOverActions(r0);
    L30:
        if (this.preHiddenTitleBar != r0) goto L32;
        this.preHiddenTitleBar = null;
    L32:
        dispatchHostTransitionEndIfReady(r13);
        return;
    L26:
        if (r13.g() == false) goto L30;
        completePendingTakeOverActions(r0);
        goto L30
    L14:
        if (hasTakenOverActions() == false) goto L16;
        r2 = true;
        goto L17
    }

    public final OFloatingTitleBar getBoundTitleBar() {
        if (com.obric.oui.titlebar.floating.a.a() == true) goto L7;
        return null;
    L7:
        return this.boundTitleBar;
    }

    public final boolean shouldProvideLaunchAnimationState$OUI_standardRelease(OFloatingTitleBar r5) {
        o.e(r5, "titleBar");
        if (com.obric.oui.titlebar.floating.a.a() == true) goto L5;
        return false;
    L5:
        c r0 = this.pendingBind;
        if (this.boundTitleBar == r5) goto L8;
        return false;
    L8:
        if (isShown() == false) goto L32;
        if (r0 != null) goto L11;
        OFloatingTitleBar r2 = null;
    L12:
        if (r2 != r5) goto L16;
        if (r0.h() == false) goto L16;
    L30:
        return true;
    L16:
        if (this.pendingTakeOverTitleBar == r5) goto L30;
        if (this.pendingTakeOverOnPreDrawTitleBar == r5) goto L30;
        if (getTranslationX() != 0.0f) goto L22;
        boolean r6 = true;
    L23:
        if (r6 == false) goto L30;
        if (getTranslationY() != 0.0f) goto L27;
        boolean r4 = true;
    L28:
        if (r4 == false) goto L30;
        return false;
    L27:
        r4 = false;
        goto L28
    L22:
        r6 = false;
        goto L23
    L11:
        r2 = r0.a();
        goto L12
    L32:
        return false;
    }

    private final void bindWhenReady(final c r4) {
        final OFloatingTitleBar r0 = r4.a();
        if (this.waitingReadyTitleBar != r0) goto L6;
        this.waitingReadyBind = r4;
        return;
    L6:
        this.waitingReadyTitleBar = r0;
        this.waitingReadyBind = r4;
        ViewTreeObserver r1 = r0.getViewTreeObserver();
        if (r1.isAlive() == true) goto L10;
        post(new $$Lambda$OFloatingTitleBarActionHost$EggWLjanIE3aSMXL8eb1W6Y0_lU(this, r0, r4));
        return;
    L10:
        r1.addOnPreDrawListener((ViewTreeObserver.OnPreDrawListener) ZeusTransformUtils.preCheckCast(new AnonymousClass2(r0, this, r4), ViewTreeObserver.OnPreDrawListener.class, "com.obric.aiagent.plugin"));
    }

    /* JADX INFO: renamed from: bindWhenReady$lambda-4, reason: not valid java name */
    private static final void m1221bindWhenReady$lambda4(OFloatingTitleBarActionHost r1, OFloatingTitleBar r2, c r3) {
        o.e(r1, "this$0");
        o.e(r2, "$titleBar");
        o.e(r3, "$bind");
        if (r1.waitingReadyTitleBar == r2) goto L5;
        return;
    L5:
        c r4 = r1.waitingReadyBind;
        if (r4 == null) goto L9;
        r3 = r4;
    L9:
        r1.waitingReadyTitleBar = null;
        r1.waitingReadyBind = null;
        r1.beginPrepareBind(r3);
    }

    public final void onTransitionStart() {
        if (com.obric.oui.titlebar.floating.a.a() == true) goto L5;
        return;
    L5:
        c r0 = this.pendingBind;
        if (r0 != null) goto L8;
        return;
    L8:
        r0.b(true);
        startPendingHostTransition(r0);
    }

    public final void onTransitionEnd() {
        if (com.obric.oui.titlebar.floating.a.a() == true) goto L5;
        return;
    L5:
        c r0 = this.pendingBind;
        if (r0 != null) goto L8;
        return;
    L8:
        r0.c(true);
        if (r0.f() == true) goto L11;
        r0.b(true);
    L11:
        startPendingHostTransition(r0);
        if (r0.h() == false) goto L15;
        completePendingTakeOverActions(r0.a());
    L15:
        if (r0.h() == false) goto L18;
        dispatchHostTransitionEndIfReady(r0);
        return;
    }

    static /* synthetic */ void completePendingTakeOverActions$default(OFloatingTitleBarActionHost r0, OFloatingTitleBar r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        r0.completePendingTakeOverActions(r1);
    }

    private final void completePendingTakeOverActions(OFloatingTitleBar r3) {
        OFloatingTitleBar r0 = this.pendingTakeOverTitleBar;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r3 == null) goto L8;
        if (r0 == r3) goto L8;
        return;
    L8:
        this.pendingTakeOverTitleBar = null;
        takeOverActionsOnNextPreDraw(r0);
        c r4 = this.pendingBind;
        if (r4 != null) goto L12;
        return;
    L12:
        if (r4.a() == r0) goto L14;
        return;
    L14:
        if (r4.g() == false) goto L18;
        dispatchHostTransitionEndIfReady(r4);
        return;
    }

    private final void takeOverActionsOnNextPreDraw(final OFloatingTitleBar r3) {
        this.pendingTakeOverOnPreDrawTitleBar = r3;
        ViewTreeObserver r0 = getViewTreeObserver();
        if (r0.isAlive() == true) goto L6;
        postOnAnimation(new $$Lambda$OFloatingTitleBarActionHost$ma5ay1uA9GbLsUGRfk0aknNNkc(this, r3));
        return;
    L6:
        r0.addOnPreDrawListener((ViewTreeObserver.OnPreDrawListener) ZeusTransformUtils.preCheckCast(new ViewTreeObserverOnPreDrawListenerC12002(this, r3), ViewTreeObserver.OnPreDrawListener.class, "com.obric.aiagent.plugin"));
    }

    /* JADX INFO: renamed from: takeOverActionsOnNextPreDraw$lambda-7, reason: not valid java name */
    private static final void m1226takeOverActionsOnNextPreDraw$lambda7(OFloatingTitleBarActionHost r2, OFloatingTitleBar r3) {
        o.e(r2, "this$0");
        o.e(r3, "$titleBar");
        if (r2.pendingTakeOverOnPreDrawTitleBar == r3) goto L5;
        return;
    L5:
        if (r2.boundTitleBar != r3) goto L16;
        r2.pendingTakeOverOnPreDrawTitleBar = null;
        r2.takeOverActions(r3);
        c r0 = r2.pendingBind;
        if (r0 != null) goto L11;
        return;
    L11:
        if (r0.a() != r3) goto L15;
        r2.dispatchHostTransitionEndIfReady(r0);
        return;
    L15:
        return;
    }

    private final void takeOverActions(OFloatingTitleBar r4) {
        applyFloatingTransitionActionVisibility();
        OFloatingTitleBar.setActionContentVisible$OUI_standardRelease$default(r4, false, false, 2, null);
        setVisibility(0);
    }

    private final void dispatchHostTransitionEndIfReady(c r3) {
        if (r3.l() == false) goto L5;
        return;
    L5:
        if (r3.i() == this.hostTransitionGeneration) goto L7;
        return;
    L7:
        if (this.boundTitleBar == r3.a()) goto L9;
        return;
    L9:
        if (r3.g() == true) goto L11;
        return;
    L11:
        if (r3.h() == true) goto L13;
        return;
    L13:
        if (r3.j() == true) goto L15;
        return;
    L15:
        if (r3.k() == true) goto L17;
        return;
    L17:
        if (this.pendingTakeOverTitleBar != r3.a()) goto L19;
        return;
    L19:
        if (this.pendingTakeOverOnPreDrawTitleBar == r3.a()) goto L37;
        r3.g(true);
        if (this.pendingBind != r3) goto L24;
        this.pendingBind = null;
    L24:
        b r2 = this.floatingTransitionEndListener;
        if (r2 == null) goto L38;
        r2.a(r3.a());
        return;
    L38:
        return;
    }

    private final boolean shouldDeferTakeOverActions() {
        return !hasTakenOverActions();
    }

    private final boolean shouldPreHideTarget(OFloatingTitleBar r2) {
        if (getVisibility() != 0) goto L10;
        OFloatingTitleBar r1 = this.boundTitleBar;
        if (r1 == null) goto L10;
        if (r1 == r2) goto L10;
        if (r2.isActionContentVisible() == false) goto L10;
        return true;
    L10:
        return false;
    }

    private final boolean hasTakenOverActions() {
        if (getVisibility() == 0) goto L5;
    L7:
        return false;
    L5:
        if (this.boundTitleBar == null) goto L7;
        return true;
    }

    private final void interruptFloatingTransitionForActionChange() {
        OFloatingTitleBar r0 = this.boundTitleBar;
        if (r0 != null) goto L10;
        c r1 = this.pendingBind;
        if (r1 != null) goto L7;
        r0 = null;
    L8:
        if (r0 != null) goto L10;
        r0 = this.waitingReadyTitleBar;
        goto L10
    L7:
        r0 = r1.a();
    L10:
        if (r0 == null) goto L14;
        r0.interruptFloatingTransitionForHostTargetChange$OUI_standardRelease();
        return;
    }

    private final void clearDeferredTakeOver() {
        this.pendingTakeOverTitleBar = null;
        this.pendingTakeOverOnPreDrawTitleBar = null;
        this.boundTitleBar = null;
    }

    public static /* synthetic */ void unbind$default(OFloatingTitleBarActionHost r0, OFloatingTitleBar r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        r0.unbind(r1);
    }

    public final void unbind(final OFloatingTitleBar r4) {
        if (com.obric.oui.titlebar.floating.a.a() == true) goto L5;
        return;
    L5:
        OFloatingTitleBar r0 = null;
        if (r4 != null) goto L8;
        OFloatingTitleBar r5 = this.boundTitleBar;
        if (r5 != null) goto L32;
        c r6 = this.pendingBind;
        if (r6 == null) goto L33;
        r0 = r6.a();
    L33:
        if (r0 == null) goto L36;
        r0.interruptFloatingTransitionForHostTargetChange$OUI_standardRelease();
    L36:
        clearBindState();
        return;
    L32:
        r0 = r5;
        goto L33
    L8:
        if (isTitleBarOwnedByHost(r4) == true) goto L11;
        OFloatingTitleBar.setActionContentVisible$OUI_standardRelease$default(r4, true, false, 2, null);
        return;
    L11:
        c r1 = this.pendingBind;
        if (r1 != null) goto L14;
        OFloatingTitleBar r2 = null;
    L15:
        if (r2 == null) goto L21;
        c r3 = this.pendingBind;
        if (r3 == null) goto L20;
        r0 = r3.a();
    L20:
        if (r0 == r4) goto L21;
    L22:
        this.pendingUnbindTitleBar = r4;
        if (this.pendingUnbindPosted == true) goto L38;
        this.pendingUnbindPosted = true;
        postOnAnimation(new $$Lambda$OFloatingTitleBarActionHost$UrYTT8MKLIoAtFPGhrF0taLZ5F4(this, r4));
        return;
    L38:
        return;
    L21:
        r4.interruptFloatingTransitionForHostTargetChange$OUI_standardRelease();
        goto L22
    L14:
        r2 = r1.a();
        goto L15
    }

    /* JADX INFO: renamed from: unbind$lambda-8, reason: not valid java name */
    private static final void m1227unbind$lambda8(OFloatingTitleBarActionHost r3, OFloatingTitleBar r4) {
        o.e(r3, "this$0");
        r3.pendingUnbindPosted = false;
        if (r3.pendingUnbindTitleBar == r4) goto L6;
        return;
    L6:
        if (r3.isTitleBarOwnedByHost(r4) == true) goto L13;
        r3.pendingUnbindTitleBar = null;
        if (r3.boundTitleBar == null) goto L10;
        return;
    L10:
        if (r3.pendingBind != null) goto L24;
        r4.setFloatingTransitionOwnerActive$OUI_standardRelease(false);
        OFloatingTitleBar.setActionContentVisible$OUI_standardRelease$default(r4, true, false, 2, null);
        return;
    L24:
        return;
    L13:
        c r1 = r3.pendingBind;
        if (r1 == null) goto L21;
        if (r1 != null) goto L17;
        OFloatingTitleBar r2 = null;
    L18:
        if (r2 == r4) goto L21;
        r3.pendingUnbindTitleBar = null;
        r4.setFloatingTransitionOwnerActive$OUI_standardRelease(false);
        return;
    L17:
        r2 = r1.a();
    L21:
        r3.pendingUnbindTitleBar = null;
        r3.clearBindState();
    }

    private final boolean isTitleBarOwnedByHost(OFloatingTitleBar r2) {
        if (this.boundTitleBar != r2) goto L5;
    L19:
        return true;
    L5:
        if (this.preHiddenTitleBar == r2) goto L19;
        if (this.waitingReadyTitleBar == r2) goto L19;
        c r0 = this.pendingBind;
        if (r0 != null) goto L11;
        OFloatingTitleBar r1 = null;
    L12:
        if (r1 == r2) goto L19;
        if (this.pendingTakeOverTitleBar == r2) goto L19;
        if (this.pendingTakeOverOnPreDrawTitleBar == r2) goto L19;
        return false;
    L11:
        r1 = r0.a();
        goto L12
    }

    private final void clearBindState() {
        deactivateOwnedTitleBars();
        this.waitingReadyTitleBar = null;
        this.waitingReadyBind = null;
        this.pendingBind = null;
        this.pendingTakeOverTitleBar = null;
        this.pendingTakeOverOnPreDrawTitleBar = null;
        this.pendingUnbindTitleBar = null;
        this.pendingUnbindPosted = false;
        this.floatingTransitionActionsHidden = false;
        animate().cancel();
        OFloatingTitleBar r2 = this.preHiddenTitleBar;
        if (r2 == null) goto L6;
        OFloatingTitleBar.setActionContentVisible$OUI_standardRelease$default(r2, true, false, 2, null);
    L6:
        this.preHiddenTitleBar = null;
        OFloatingTitleBar r3 = this.boundTitleBar;
        if (r3 == null) goto L10;
        OFloatingTitleBar.setActionContentVisible$OUI_standardRelease$default(r3, true, false, 2, null);
    L10:
        this.boundTitleBar = null;
        OFloatingTitleBar.setActionContentVisible$OUI_standardRelease$default(this.actionTitleBar, false, false, 2, null);
        setVisibility(8);
        this.hostTransitionGeneration++;
    }

    private final void deactivateOwnedTitleBars() {
        OFloatingTitleBar[] r0 = new OFloatingTitleBar[6];
        r0[0] = this.preHiddenTitleBar;
        r0[1] = this.boundTitleBar;
        r0[2] = this.waitingReadyTitleBar;
        c r1 = this.pendingBind;
        if (r1 != null) goto L5;
        OFloatingTitleBar r2 = null;
    L6:
        r0[3] = r2;
        r0[4] = this.pendingTakeOverTitleBar;
        r0[5] = this.pendingTakeOverOnPreDrawTitleBar;
        Iterator r4 = ((Iterable) ZeusTransformUtils.preCheckCast(d.a.p.s((Iterable) ZeusTransformUtils.preCheckCast(d.a.p.k((Iterable) ZeusTransformUtils.preCheckCast(d.a.p.b(r0), Iterable.class, "com.obric.aiagent.plugin")), Iterable.class, "com.obric.aiagent.plugin")), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L8:
        if (r4.hasNext() == false) goto L10;
        ((OFloatingTitleBar) ZeusTransformUtils.preCheckCast(r4.next(), OFloatingTitleBar.class, "com.obric.aiagent.plugin")).setFloatingTransitionOwnerActive$OUI_standardRelease(false);
        goto L8
    L10:
        return;
    L5:
        r2 = r1.a();
        goto L6
    }

    private final void applyFloatingTransitionActionVisibility() {
        OFloatingTitleBar.setActionContentVisible$OUI_standardRelease$default(this.actionTitleBar, !this.floatingTransitionActionsHidden, false, 2, null);
    }

    private final boolean isActiveBind(c r1) {
        if (this.pendingBind != r1) goto L5;
        return true;
    L5:
        return false;
    }

    static /* synthetic */ void moveTo$default(OFloatingTitleBarActionHost r1, View r2, boolean r3, d.h.a.a r4, int r5, Object r6) {
        d.h.a.a<x> r7 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin");
        if ((r5 & 4) == 0) goto L5;
        r7 = null;
    L5:
        r1.moveTo(r2, r3, r7);
    }

    private final void moveTo(View r10, boolean r11, d.h.a.a<x> r12) {
        final d.h.a.a r8 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r12, d.h.a.a.class, "com.obric.aiagent.plugin");
        ViewParent r13 = getParent();
        Integer r3 = null;
        if (ZeusTransformUtils.instanceOf(r13, View.class) == false) goto L5;
        View r14 = (View) ZeusTransformUtils.preCheckCast(r13, View.class, "com.obric.aiagent.plugin");
    L6:
        if (r14 != null) goto L12;
        OFloatingTitleBarActionHost r9 = (OFloatingTitleBarActionHost) ZeusTransformUtils.preCheckCast(this, OFloatingTitleBarActionHost.class, "com.obric.aiagent.plugin");
        if (r8 == null) goto L48;
        r8.invoke();
        return;
    L48:
        return;
    L12:
        ViewGroup.LayoutParams r1 = getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r1, ViewGroup.MarginLayoutParams.class) == false) goto L15;
        final ViewGroup.MarginLayoutParams r4 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r1, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin");
    L16:
        if (r4 != null) goto L22;
        OFloatingTitleBarActionHost r15 = (OFloatingTitleBarActionHost) ZeusTransformUtils.preCheckCast(this, OFloatingTitleBarActionHost.class, "com.obric.aiagent.plugin");
        if (r8 == null) goto L49;
        r8.invoke();
        return;
    L49:
        return;
    L22:
        int[] r2 = new int[2];
        int[] r0 = new int[2];
        r10.getLocationOnScreen(r2);
        r14.getLocationOnScreen(r0);
        boolean r16 = false;
        final int r5 = r2[0] - r0[0];
        final int r6 = r2[1] - r0[1];
        Integer r7 = Integer.valueOf(r10.getWidth());
        if (((Number) ZeusTransformUtils.preCheckCast(r7, Number.class, "com.obric.aiagent.plugin")).intValue() <= 0) goto L25;
        boolean r17 = true;
    L26:
        if (r17 == true) goto L29;
        r7 = null;
    L29:
        if (r7 != null) goto L31;
        int r18 = r4.width;
    L32:
        Integer r19 = Integer.valueOf(r10.getHeight());
        if (((Number) ZeusTransformUtils.preCheckCast(r19, Number.class, "com.obric.aiagent.plugin")).intValue() <= 0) goto L35;
        r16 = true;
    L35:
        if (r16 == false) goto L37;
        r3 = r19;
    L37:
        if (r3 != null) goto L39;
        int r110 = r4.height;
    L40:
        if (r11 == true) goto L46;
        animate().cancel();
        r4.width = r18;
        r4.height = r110;
        r4.leftMargin = r5;
        r4.topMargin = r6;
        setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r4, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        setTranslationX(0.0f);
        setTranslationY(0.0f);
        if (r8 == null) goto L50;
        r8.invoke();
        return;
    L50:
        return;
    L46:
        float r111 = r4.leftMargin + getTranslationX();
        float r112 = r4.topMargin + getTranslationY();
        setTranslationX(r111 - r4.leftMargin);
        setTranslationY(r112 - r4.topMargin);
        r4.width = r18;
        r4.height = r110;
        setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r4, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        animate().translationX(r5 - r4.leftMargin).translationY(r6 - r4.topMargin).setDuration(500).setInterpolator((TimeInterpolator) ZeusTransformUtils.preCheckCast(this.easeInOut, TimeInterpolator.class, "com.obric.aiagent.plugin")).withEndAction(new $$Lambda$OFloatingTitleBarActionHost$VrsN_ATLg5kasmH7B3Z4GnuHajE(r4, r5, r6, this, r8)).start();
        return;
    L39:
        r110 = r3.intValue();
        goto L40
    L31:
        r18 = r7.intValue();
        goto L32
    L25:
        r17 = false;
        goto L26
    L15:
        r4 = null;
        goto L16
    L5:
        r14 = null;
        goto L6
    }

    /* JADX INFO: renamed from: moveTo$lambda-14, reason: not valid java name */
    private static final void m1224moveTo$lambda14(ViewGroup.MarginLayoutParams r2, int r3, int r4, OFloatingTitleBarActionHost r5, d.h.a.a r6) {
        d.h.a.a r7 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r6, d.h.a.a.class, "com.obric.aiagent.plugin");
        o.e(r2, "$params");
        o.e(r5, "this$0");
        r2.leftMargin = r3;
        r2.topMargin = r4;
        r5.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r2, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        r5.setTranslationX(0.0f);
        r5.setTranslationY(0.0f);
        if (r7 == null) goto L7;
        r7.invoke();
        return;
    }

    public static /* synthetic */ void applyState$OUI_standardRelease$default(OFloatingTitleBarActionHost r7, com.obric.oui.titlebar.a r8, boolean r9, boolean r10, Float r11, d.h.a.a r12, int r13, Object r14) {
        d.h.a.a<x> r15 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r12, d.h.a.a.class, "com.obric.aiagent.plugin");
        if ((r13 & 2) == 0) goto L5;
        boolean r3 = true;
    L7:
        if ((r13 & 4) == 0) goto L9;
        boolean r4 = true;
    L11:
        if ((r13 & 8) == 0) goto L13;
        Float r5 = null;
    L15:
        if ((r13 & 16) == 0) goto L17;
        d.h.a.a<x> r6 = null;
    L18:
        r7.applyState$OUI_standardRelease(r8, r3, r4, r5, r6);
        return;
    L17:
        r6 = r15;
        goto L18
    L13:
        r5 = r11;
        goto L15
    L9:
        r4 = r10;
        goto L11
    L5:
        r3 = r9;
        goto L7
    }

    public final void applyState$OUI_standardRelease(com.obric.oui.titlebar.a r11, boolean r12, boolean r13, Float r14, d.h.a.a<x> r15) {
        d.h.a.a r16 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r15, d.h.a.a.class, "com.obric.aiagent.plugin");
        o.e(r11, "state");
        int r0 = this.floatingApplyGeneration + 1;
        this.floatingApplyGeneration = r0;
        this.actionTitleBar.captureState().b().e();
        if (r14 != null) goto L5;
        float r17 = currentFloatingTransitionContentTopOffset$OUI_standardRelease();
    L6:
        int r3 = r11.b().e();
        z.d r4 = new z.d();
        r4.f38502a = 1;
        z.a r5 = new z.a();
        this.actionTitleBar.animate().cancel();
        applyFloatingTransitionActionVisibility();
        this.actionTitleBar.setNonActionContentVisible$OUI_standardRelease(false);
        this.actionTitleBar.updateLayoutForInsetTop(r3);
        if (r12 == false) goto L12;
        if (r13 == false) goto L12;
        float r18 = r17 - r3;
        if (Math.abs(r18) <= 0.5f) goto L12;
        final d.h.a.a<x> r19 = applyState$await(r4, r0, this, r5, r16);
        this.actionTitleBar.setTranslationY(r18);
        this.actionTitleBar.animate().translationY(0.0f).setDuration(500).setInterpolator((TimeInterpolator) ZeusTransformUtils.preCheckCast(this.easeInOut, TimeInterpolator.class, "com.obric.aiagent.plugin")).setUpdateListener(new $$Lambda$OFloatingTitleBarActionHost$phpFwB8HvAAVn0Vu8TkPRkfu2f0(this)).withEndAction(new $$Lambda$OFloatingTitleBarActionHost$qRkEjhU1iw3v649PloguUcFL00U(this, r19)).start();
    L13:
        this.actionTitleBar.applyStateForFloatingTransition$OUI_standardRelease(r11, r12, (d.h.a.a) ZeusTransformUtils.preCheckCast(new e(applyState$await(r4, r0, this, r5, r16)), d.h.a.a.class, "com.obric.aiagent.plugin"));
        applyFloatingTransitionActionVisibility();
        this.actionTitleBar.setNonActionContentVisible$OUI_standardRelease(false);
        if (r0 == this.floatingApplyGeneration) goto L16;
        return;
    L16:
        r4.f38502a--;
        if (r4.f38502a == 0) goto L19;
        return;
    L19:
        if (r5.f38499a == true) goto L26;
        r5.f38499a = true;
        if (r16 == null) goto L27;
        r16.invoke();
        return;
    L27:
        return;
    L26:
        return;
    L12:
        this.actionTitleBar.animate().setUpdateListener(null);
        this.actionTitleBar.setTranslationY(0.0f);
        goto L13
    L5:
        r17 = r14.floatValue();
        goto L6
    }

    private static final d.h.a.a<x> applyState$await(z.d r9, int r10, OFloatingTitleBarActionHost r11, z.a r12, d.h.a.a<x> r13) {
        d.h.a.a r8 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r13, d.h.a.a.class, "com.obric.aiagent.plugin");
        r9.f38502a++;
        return (d.h.a.a) ZeusTransformUtils.preCheckCast(new f(new z.a(), r10, r11, r9, r12, r8), d.h.a.a.class, "com.obric.aiagent.plugin");
    }

    /* JADX INFO: renamed from: applyState$lambda-15, reason: not valid java name */
    private static final void m1219applyState$lambda15(OFloatingTitleBarActionHost r1, ValueAnimator r2) {
        o.e(r1, "this$0");
        o.e(r2, "it");
        r1.actionTitleBar.notifyFloatingTransitionDrawUpdate$OUI_standardRelease();
    }

    /* JADX INFO: renamed from: applyState$lambda-16, reason: not valid java name */
    private static final void m1220applyState$lambda16(OFloatingTitleBarActionHost r2, d.h.a.a r3) {
        d.h.a.a r4 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
        o.e(r2, "this$0");
        o.e(r4, "$insetDone");
        r2.actionTitleBar.animate().setUpdateListener(null);
        r4.invoke();
    }

    public final void cancelFloatingTransitionState$OUI_standardRelease() {
        this.floatingApplyGeneration++;
        animate().cancel();
        this.actionTitleBar.animate().cancel();
        this.actionTitleBar.animate().setUpdateListener(null);
        this.actionTitleBar.setFloatingTransitionDrawUpdateListener$OUI_standardRelease(null);
        this.actionTitleBar.pauseActionAnimations();
    }

    public final com.obric.oui.titlebar.a captureAnimationState$OUI_standardRelease() {
        return this.actionTitleBar.captureAnimationState$OUI_standardRelease();
    }

    public final float currentFloatingTransitionContentTopOffset$OUI_standardRelease() {
        return this.actionTitleBar.captureState().b().e() + this.actionTitleBar.getTranslationY();
    }
}
