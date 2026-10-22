package com.obric.oui.popover.v2;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.FrameLayout;
import com.obric.aiagent.plugin.R;
import com.obric.oui.material.k;
import com.obric.oui.popover.FakeAnchorView;
import com.obric.oui.popover.SingleChildFrameLayout;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.h.b.p;
import d.m;
import d.x;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: OPopoverModal.kt */
/* JADX INFO: loaded from: classes4.dex */
public class OPopoverModal extends FrameLayout implements b<OPopoverModal> {
    public static final a Companion = null;
    private static final Map<Activity, a.C0975a> backPressManagerByActivity = null;
    private final Runnable autoDismissRunnable;
    private OPopover.c bubbleDismissListener;
    private OPopover.d bubbleShowListener;
    private OPopover.e bubbleStartDismissListener;
    private WeakReference<View> currentAnchorRef;
    private ViewGroup currentHostParent;
    private final Runnable detachedCleanupRunnable;
    private d.h.a.a<x> dismissListener;
    private boolean isShowing;
    private final long mAutoDismissDelayMillis;
    private final boolean mEnableBackPressDismiss;
    private final boolean mOutsideTouchable;
    private final boolean mShadowEnabled;
    private final int mShadowStyle;
    private final boolean mSpacingForShadow;
    private final View mView;
    private final Handler mainHandler;
    private float popoverAnchorCenterX;
    private float popoverAnchorCenterY;
    private final long popoverAnimationDurationMillis;
    private final boolean popoverAnimationIsWindowMode;
    private AnimatorSet popoverAnimator;
    private final int popoverBgColor;
    private final int popoverBorderColor;
    private final int popoverBorderWidth;
    public OPopoverLayout popoverBubbleLayout;
    private ViewGroup popoverContentView;
    private final boolean popoverCoverPreviousWhenStacked;
    private final int popoverDisplayOrientation;
    private final boolean popoverEnableBubbleMaterial;
    private int popoverGravity;
    private final int popoverHeight;
    private final d.h.a.b<Boolean, com.obric.oui.material.c[]> popoverMaterials;
    private int popoverPopupOriginX;
    private int popoverPopupOriginY;
    private boolean popoverPushedToStack;
    private boolean popoverRemovedFromStack;
    private final boolean popoverShowWithAnimation;
    private final float popoverStackAlphaPrevious;
    private final int popoverStackCoverColor;
    private final float popoverStackScalePrevious;
    private final boolean popoverTransparentBg;
    private final int popoverWidth;
    public ViewGroup popoverWindowFrame;
    private int popoverXOffset;
    private int popoverYOffset;
    private boolean removeOnDismiss;
    private d.h.a.a<x> showListener;

    /* JADX INFO: compiled from: OPopoverModal.kt */
    public static final class a {

        /* JADX INFO: renamed from: com.obric.oui.popover.v2.OPopoverModal$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: OPopoverModal.kt */
        private static final class C0975a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final Window.Callback f36037a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final Window.Callback f36038b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private final List<WeakReference<OPopoverModal>> f36039c;

            public C0975a(Window.Callback r3, Window.Callback r4, List<WeakReference<OPopoverModal>> r5) {
                Window.Callback r6 = (Window.Callback) ZeusTransformUtils.wrapperContextForParams(r3, Window.Callback.class, "com.obric.aiagent.plugin");
                Window.Callback r7 = (Window.Callback) ZeusTransformUtils.wrapperContextForParams(r4, Window.Callback.class, "com.obric.aiagent.plugin");
                List<WeakReference<OPopoverModal>> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
                o.e(r6, "originalCallback");
                o.e(r7, "proxyCallback");
                o.e(r8, "showingPopovers");
                this.f36037a = r6;
                this.f36038b = r7;
                this.f36039c = r8;
            }

            public final Window.Callback a() {
                return this.f36037a;
            }

            public final Window.Callback b() {
                return this.f36038b;
            }

            public /* synthetic */ C0975a(Window.Callback r2, Window.Callback r3, List r4, int r5, h r6) {
                Window.Callback r7 = (Window.Callback) ZeusTransformUtils.wrapperContextForParams(r2, Window.Callback.class, "com.obric.aiagent.plugin");
                Window.Callback r8 = (Window.Callback) ZeusTransformUtils.wrapperContextForParams(r3, Window.Callback.class, "com.obric.aiagent.plugin");
                List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
                if ((r5 & 4) == 0) goto L5;
                r9 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
            L5:
                this(r7, r8, r9);
            }

            public final List<WeakReference<OPopoverModal>> c() {
                return this.f36039c;
            }
        }

        /* JADX INFO: compiled from: OPopoverModal.kt */
        static final class b extends p implements d.h.a.b<WeakReference<OPopoverModal>, Boolean> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b f36040a = null;

            static {
                f36040a = new b();
            }

            b() {
                super(1);
            }

            @Override // d.h.a.b
            public /* synthetic */ Boolean invoke(WeakReference<OPopoverModal> r3) {
                return a((WeakReference) ZeusTransformUtils.preCheckCast(r3, WeakReference.class, "com.obric.aiagent.plugin"));
            }

            public final Boolean a(WeakReference<OPopoverModal> r2) {
                o.e(r2, "ref");
                OPopoverModal r1 = (OPopoverModal) ZeusTransformUtils.preCheckCast(r2.get(), OPopoverModal.class, "com.obric.aiagent.plugin");
                if (r1 != null) goto L5;
            L8:
                boolean r3 = true;
            L10:
                return Boolean.valueOf(r3);
            L5:
                if (r1.isShowing() == false) goto L8;
                r3 = false;
                goto L10
            }
        }

        /* JADX INFO: compiled from: OPopoverModal.kt */
        static final class c extends p implements d.h.a.b<WeakReference<OPopoverModal>, Boolean> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ OPopoverModal f36041a;

            c(OPopoverModal r1) {
                this.f36041a = r1;
                super(1);
            }

            public final Boolean a(WeakReference<OPopoverModal> r2) {
                o.e(r2, "it");
                if (r2.get() != this.f36041a) goto L5;
                boolean r1 = true;
            L7:
                return Boolean.valueOf(r1);
            L5:
                r1 = false;
                goto L7
            }

            @Override // d.h.a.b
            public /* synthetic */ Boolean invoke(WeakReference<OPopoverModal> r3) {
                return a((WeakReference) ZeusTransformUtils.preCheckCast(r3, WeakReference.class, "com.obric.aiagent.plugin"));
            }
        }

        /* JADX INFO: compiled from: OPopoverModal.kt */
        static final class d extends p implements d.h.a.b<WeakReference<OPopoverModal>, Boolean> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ OPopoverModal f36042a;

            d(OPopoverModal r1) {
                this.f36042a = r1;
                super(1);
            }

            public final Boolean a(WeakReference<OPopoverModal> r2) {
                o.e(r2, "it");
                if (r2.get() != this.f36042a) goto L5;
                boolean r1 = true;
            L7:
                return Boolean.valueOf(r1);
            L5:
                r1 = false;
                goto L7
            }

            @Override // d.h.a.b
            public /* synthetic */ Boolean invoke(WeakReference<OPopoverModal> r3) {
                return a((WeakReference) ZeusTransformUtils.preCheckCast(r3, WeakReference.class, "com.obric.aiagent.plugin"));
            }
        }

        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }

        public static final /* synthetic */ void a(a r2, Activity r3) {
            r2.c((Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.aiagent.plugin"));
        }

        public static final /* synthetic */ void a(a r2, Activity r3, OPopoverModal r4) {
            r2.a((Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.aiagent.plugin"), r4);
        }

        public static final /* synthetic */ OPopoverModal b(a r2, Activity r3) {
            return r2.b((Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.aiagent.plugin"));
        }

        public static final /* synthetic */ void b(a r2, Activity r3, OPopoverModal r4) {
            r2.b((Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.aiagent.plugin"), r4);
        }

        private final synchronized void a(Activity r6) {
            monitor-enter(this);
            Activity r7 = (Activity) ZeusTransformUtils.wrapperContextForParams(r6, Activity.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L15
            C0975a r0 = (C0975a) ZeusTransformUtils.preCheckCast(OPopoverModal.access$getBackPressManagerByActivity$cp().get(r7), C0975a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L15
            if (r0 != null) goto L7;
            monitor-exit(this);
            return;
        L7:
            d.a.p.a(r0.c(), (d.h.a.b) ZeusTransformUtils.preCheckCast(b.f36040a, d.h.a.b.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L15
            if (r0.c().isEmpty() == true) goto L10;
        L13:
            monitor-exit(this);
            return;
        L10:
            if (ZeusTransformUtils.getWindow(r7, "com.obric.aiagent.plugin").getCallback() != r0.b()) goto L12;
            ZeusTransformUtils.getWindow(r7, "com.obric.aiagent.plugin").setCallback(r0.a());     // Catch: Throwable -> L15
        L12:
            OPopoverModal.access$getBackPressManagerByActivity$cp().remove(r7);     // Catch: Throwable -> L15
        L15:
            th = move-exception;
            throw th;
        }

        private final synchronized OPopoverModal b(Activity r6) {
            monitor-enter(this);
            Activity r7 = (Activity) ZeusTransformUtils.wrapperContextForParams(r6, Activity.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L22
            a(r7);     // Catch: Throwable -> L22
            C0975a r8 = (C0975a) ZeusTransformUtils.preCheckCast(OPopoverModal.access$getBackPressManagerByActivity$cp().get(r7), C0975a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L22
            if (r8 != null) goto L8;
            monitor-exit(this);
            return null;
        L8:
            int r1 = r8.c().size() - 1;     // Catch: Throwable -> L22
            if (r1 < 0) goto L20;
        L10:
            int r2 = r1 - 1;     // Catch: Throwable -> L22
            OPopoverModal r3 = (OPopoverModal) ZeusTransformUtils.preCheckCast(((WeakReference) ZeusTransformUtils.preCheckCast(r8.c().get(r1), WeakReference.class, "com.obric.aiagent.plugin")).get(), OPopoverModal.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L22
            if (r3 == null) goto L17;
            if (r3.isShowing() == false) goto L17;
            monitor-exit(this);
            return r3;
        L17:
            if (r2 < 0) goto L20;
            r1 = r2;
        L20:
            monitor-exit(this);
            return null;
        L22:
            th = move-exception;
            throw th;
        }

        private final synchronized void c(Activity r10) {
            monitor-enter(this);
            final Activity r11 = (Activity) ZeusTransformUtils.wrapperContextForParams(r10, Activity.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
            a(r11);     // Catch: Throwable -> L14
            if (OPopoverModal.access$getBackPressManagerByActivity$cp().containsKey(r11) == false) goto L7;
            monitor-exit(this);
            return;
        L7:
            final Window.Callback r2 = ZeusTransformUtils.getWindow(r11, "com.obric.aiagent.plugin").getCallback();     // Catch: Throwable -> L14
            if (r2 != null) goto L11;
            monitor-exit(this);
            return;
        L11:
            Window.Callback r0 = new OPopoverModal$Companion$installBackPressCallbackIfNeeded$proxyCallback$1(r2, r11);     // Catch: Throwable -> L14
            OPopoverModal.access$getBackPressManagerByActivity$cp().put(r11, new C0975a(r2, (Window.Callback) ZeusTransformUtils.preCheckCast(r0, Window.Callback.class, "com.obric.aiagent.plugin"), null, 4, null));     // Catch: Throwable -> L14
            ZeusTransformUtils.getWindow(r11, "com.obric.aiagent.plugin").setCallback((Window.Callback) ZeusTransformUtils.preCheckCast(r0, Window.Callback.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L14
            monitor-exit(this);
            return;
        L14:
            th = move-exception;
            throw th;
        }

        private final synchronized void a(Activity r5, OPopoverModal r6) {
            monitor-enter(this);
            Activity r7 = (Activity) ZeusTransformUtils.wrapperContextForParams(r5, Activity.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L10
            C0975a r8 = (C0975a) ZeusTransformUtils.preCheckCast(OPopoverModal.access$getBackPressManagerByActivity$cp().get(r7), C0975a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L10
            if (r8 != null) goto L7;
            monitor-exit(this);
            return;
        L7:
            d.a.p.a(r8.c(), (d.h.a.b) ZeusTransformUtils.preCheckCast(new c(r6), d.h.a.b.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L10
            r8.c().add(new WeakReference(r6));     // Catch: Throwable -> L10
            monitor-exit(this);
            return;
        L10:
            th = move-exception;
            throw th;
        }

        private final synchronized void b(Activity r4, OPopoverModal r5) {
            monitor-enter(this);
            Activity r6 = (Activity) ZeusTransformUtils.wrapperContextForParams(r4, Activity.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L10
            C0975a r0 = (C0975a) ZeusTransformUtils.preCheckCast(OPopoverModal.access$getBackPressManagerByActivity$cp().get(r6), C0975a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L10
            if (r0 != null) goto L7;
            monitor-exit(this);
            return;
        L7:
            d.a.p.a(r0.c(), (d.h.a.b) ZeusTransformUtils.preCheckCast(new d(r5), d.h.a.b.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L10
            a(r6);     // Catch: Throwable -> L10
            monitor-exit(this);
            return;
        L10:
            th = move-exception;
            throw th;
        }
    }

    public static /* synthetic */ void lambda$ITU9Ed6CarBy8avOtltjHwx6qMA(OPopoverModal r0) {
        m1140detachedCleanupRunnable$lambda1(r0);
    }

    public static /* synthetic */ void lambda$MCQp3jlraLT3JF5u1jkgjomIbxU(OPopoverModal r0) {
        m1139autoDismissRunnable$lambda0(r0);
    }

    public static /* synthetic */ boolean lambda$OsmWkCSgCCxskat0xeKT9e45K4k(OPopoverModal r0, View r1, MotionEvent r2) {
        return m1141setupOutsideTouchHandler$lambda2(r0, r1, r2);
    }

    public OPopoverModal(OPopover.a r5) {
        o.e(r5, "builder");
        super((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        this.popoverShowWithAnimation = r5.v();
        this.popoverAnimationDurationMillis = r5.h();
        this.popoverGravity = OPopover.Companion.a(r5.b());
        this.popoverXOffset = r5.f();
        this.popoverYOffset = r5.g();
        this.mAutoDismissDelayMillis = r5.i();
        this.mOutsideTouchable = r5.p();
        this.mEnableBackPressDismiss = r5.r();
        this.mShadowEnabled = r5.w();
        this.mShadowStyle = r5.x();
        this.mSpacingForShadow = r5.y();
        View r0 = requirePopoverContentView(r5.j());
        this.mView = r0;
        this.bubbleStartDismissListener = r5.m();
        this.bubbleDismissListener = r5.n();
        this.bubbleShowListener = r5.o();
        this.removeOnDismiss = true;
        this.popoverAnchorCenterX = Float.NaN;
        this.popoverAnchorCenterY = Float.NaN;
        this.mainHandler = new Handler(Looper.getMainLooper());
        this.popoverDisplayOrientation = r5.c();
        this.popoverBgColor = r5.d();
        this.popoverBorderWidth = r5.s();
        this.popoverBorderColor = r5.t();
        this.popoverTransparentBg = r5.u();
        this.popoverWidth = r5.k();
        this.popoverHeight = r5.l();
        this.popoverEnableBubbleMaterial = r5.z();
        this.popoverMaterials = r5.A();
        this.popoverCoverPreviousWhenStacked = r5.B();
        this.popoverStackCoverColor = r5.C();
        this.popoverStackAlphaPrevious = r5.D();
        this.popoverStackScalePrevious = r5.E();
        this.autoDismissRunnable = new $$Lambda$OPopoverModal$MCQp3jlraLT3JF5u1jkgjomIbxU(this);
        this.detachedCleanupRunnable = new $$Lambda$OPopoverModal$ITU9Ed6CarBy8avOtltjHwx6qMA(this);
        setVisibility(8);
        setClipChildren(false);
        setClipToPadding(false);
        setClickable(true);
        setFocusable(true);
        setBackgroundColor(0);
        setBubbleLayout(r0);
        initContentView();
        setupOutsideTouchHandler();
    }

    public static final /* synthetic */ Map access$getBackPressManagerByActivity$cp() {
        return backPressManagerByActivity;
    }

    public void afterShowInStackIfNeeded() {
        b.C0977b.m((b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.aiagent.plugin"));
    }

    public void beforeShowInStackIfNeeded() {
        b.C0977b.l((b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.oui.popover.v2.b
    public void cancelPopoverAnimatorInternal() {
        b.C0977b.h((b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.oui.popover.v2.b
    public OPopoverLayout createPopoverBubbleLayout(View r3, int r4) {
        return b.C0977b.a((b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.aiagent.plugin"), r3, r4);
    }

    @Override // com.obric.oui.popover.v2.b
    public View getContentViewInternal() {
        return b.C0977b.e((b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.aiagent.plugin"));
    }

    public int getDisplayRotationDegreesInternal() {
        return b.C0977b.d((b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.oui.popover.v2.b
    public Animator getPopoverEnterAnimator() {
        return b.C0977b.b((b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.oui.popover.v2.b
    public Animator getPopoverExitAnimator() {
        return b.C0977b.c((b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.oui.popover.v2.b
    public void measurePopoverContent(View r3, int r4, int r5) {
        b.C0977b.a((b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.aiagent.plugin"), r3, r4, r5);
    }

    public void measurePopupInternal(int r3, int r4) {
        b.C0977b.a((b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.aiagent.plugin"), r3, r4);
    }

    public void onDestroyInStackIfNeeded() {
        b.C0977b.n((b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.aiagent.plugin"));
    }

    public void playPopoverEnterAnimationInternal() {
        b.C0977b.j((b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.aiagent.plugin"));
    }

    public void playPopoverExitAnimationInternal() {
        b.C0977b.k((b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.aiagent.plugin"));
    }

    public View requirePopoverContentView(View r3) {
        return b.C0977b.a((b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.aiagent.plugin"), r3);
    }

    @Override // com.obric.oui.popover.v2.b
    public void resetPopoverAnimatedViewState(View r3) {
        b.C0977b.b((b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.aiagent.plugin"), r3);
    }

    @Override // com.obric.oui.popover.v2.b
    public float resolvePopoverPivot(float r3, int r4, float r5) {
        return b.C0977b.a((b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.aiagent.plugin"), r3, r4, r5);
    }

    public b.c resolvePopoverShadowPadding(int r3) {
        return b.C0977b.d((b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.aiagent.plugin"), r3);
    }

    public float resolvePopoverShadowSpace(int r3) {
        return b.C0977b.e((b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.aiagent.plugin"), r3);
    }

    public void setGravityInternal(int r3) {
        b.C0977b.a((b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.aiagent.plugin"), r3);
    }

    @Override // com.obric.oui.popover.v2.b
    public void setMaxContentHeightInternal(int r3, View r4) {
        b.C0977b.a((b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.aiagent.plugin"), r3, r4);
    }

    @Override // com.obric.oui.popover.v2.b
    public void setPopoverMaxContentHeight(int r3, View r4, int r5, int r6) {
        b.C0977b.a((b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.aiagent.plugin"), r3, r4, r5, r6);
    }

    public void setXOffsetInternal(int r3) {
        b.C0977b.b((b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.aiagent.plugin"), r3);
    }

    public void setYOffsetInternal(int r3) {
        b.C0977b.c((b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.aiagent.plugin"), r3);
    }

    public boolean shouldAnimatePopoverVisibilityInternal() {
        return b.C0977b.g((b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.oui.popover.v2.b
    public void showPopoverDirectlyInternal(ViewGroup r3, d.h.a.a<x> r4) {
        d.h.a.a r5 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin");
        b.C0977b.a((b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.aiagent.plugin"), r3, r5);
    }

    public void showPopoverWithoutAnimationInternal() {
        b.C0977b.i((b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.oui.popover.v2.b
    public AnimatorSet startPopoverVisibilityAnimationInternal(boolean r10, int r11, boolean r12, Animator r13, d.h.a.a<x> r14, d.h.a.a<x> r15) {
        d.h.a.a r7 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r14, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.a.a r8 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r15, d.h.a.a.class, "com.obric.aiagent.plugin");
        return b.C0977b.a((b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.aiagent.plugin"), r10, r11, r12, r13, r7, r8);
    }

    @Override // com.obric.oui.popover.v2.b
    public void updatePopoverPivotInternal() {
        b.C0977b.f((b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.oui.popover.v2.b
    public boolean getPopoverShowWithAnimation() {
        return this.popoverShowWithAnimation;
    }

    @Override // com.obric.oui.popover.v2.b
    public long getPopoverAnimationDurationMillis() {
        return this.popoverAnimationDurationMillis;
    }

    @Override // com.obric.oui.popover.v2.b
    public boolean getPopoverAnimationIsWindowMode() {
        return this.popoverAnimationIsWindowMode;
    }

    @Override // com.obric.oui.popover.v2.b
    public int getPopoverGravity() {
        return this.popoverGravity;
    }

    @Override // com.obric.oui.popover.v2.b
    public void setPopoverGravity(int r1) {
        this.popoverGravity = r1;
    }

    public int getPopoverXOffset() {
        return this.popoverXOffset;
    }

    @Override // com.obric.oui.popover.v2.b
    public void setPopoverXOffset(int r1) {
        this.popoverXOffset = r1;
    }

    public int getPopoverYOffset() {
        return this.popoverYOffset;
    }

    @Override // com.obric.oui.popover.v2.b
    public void setPopoverYOffset(int r1) {
        this.popoverYOffset = r1;
    }

    @Override // com.obric.oui.popover.v2.b
    public OPopoverLayout getPopoverBubbleLayout() {
        OPopoverLayout r0 = this.popoverBubbleLayout;
        if (r0 == null) goto L5;
        return r0;
    L5:
        o.c("popoverBubbleLayout");
        return null;
    }

    public void setPopoverBubbleLayout(OPopoverLayout r2) {
        o.e(r2, "<set-?>");
        this.popoverBubbleLayout = r2;
    }

    @Override // com.obric.oui.popover.v2.b
    public ViewGroup getPopoverWindowFrame() {
        ViewGroup r0 = this.popoverWindowFrame;
        if (r0 == null) goto L5;
        return r0;
    L5:
        o.c("popoverWindowFrame");
        return null;
    }

    public void setPopoverWindowFrame(ViewGroup r2) {
        o.e(r2, "<set-?>");
        this.popoverWindowFrame = r2;
    }

    @Override // com.obric.oui.popover.v2.b
    public AnimatorSet getPopoverAnimator() {
        return this.popoverAnimator;
    }

    @Override // com.obric.oui.popover.v2.b
    public void setPopoverAnimator(AnimatorSet r1) {
        this.popoverAnimator = r1;
    }

    @Override // com.obric.oui.popover.v2.b
    public float getPopoverAnchorCenterX() {
        return this.popoverAnchorCenterX;
    }

    public void setPopoverAnchorCenterX(float r1) {
        this.popoverAnchorCenterX = r1;
    }

    @Override // com.obric.oui.popover.v2.b
    public float getPopoverAnchorCenterY() {
        return this.popoverAnchorCenterY;
    }

    public void setPopoverAnchorCenterY(float r1) {
        this.popoverAnchorCenterY = r1;
    }

    @Override // com.obric.oui.popover.v2.b
    public int getPopoverPopupOriginX() {
        return this.popoverPopupOriginX;
    }

    public void setPopoverPopupOriginX(int r1) {
        this.popoverPopupOriginX = r1;
    }

    @Override // com.obric.oui.popover.v2.b
    public int getPopoverPopupOriginY() {
        return this.popoverPopupOriginY;
    }

    public void setPopoverPopupOriginY(int r1) {
        this.popoverPopupOriginY = r1;
    }

    @Override // com.obric.oui.popover.v2.b
    public boolean getPopoverPushedToStack() {
        return this.popoverPushedToStack;
    }

    @Override // com.obric.oui.popover.v2.b
    public void setPopoverPushedToStack(boolean r1) {
        this.popoverPushedToStack = r1;
    }

    @Override // com.obric.oui.popover.v2.b
    public boolean getPopoverRemovedFromStack() {
        return this.popoverRemovedFromStack;
    }

    @Override // com.obric.oui.popover.v2.b
    public void setPopoverRemovedFromStack(boolean r1) {
        this.popoverRemovedFromStack = r1;
    }

    @Override // com.obric.oui.popover.v2.b
    public boolean isPopoverBubbleLayoutInitialized() {
        if (this.popoverBubbleLayout == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.oui.popover.v2.b
    public Context getPopoverContext() {
        Context r2 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r2, "context");
        return r2;
    }

    @Override // com.obric.oui.popover.v2.b
    public int getPopoverDisplayOrientation() {
        return this.popoverDisplayOrientation;
    }

    @Override // com.obric.oui.popover.v2.b
    public int getPopoverBgColor() {
        return this.popoverBgColor;
    }

    @Override // com.obric.oui.popover.v2.b
    public int getPopoverBorderWidth() {
        return this.popoverBorderWidth;
    }

    @Override // com.obric.oui.popover.v2.b
    public int getPopoverBorderColor() {
        return this.popoverBorderColor;
    }

    @Override // com.obric.oui.popover.v2.b
    public boolean getPopoverTransparentBg() {
        return this.popoverTransparentBg;
    }

    @Override // com.obric.oui.popover.v2.b
    public int getPopoverWidth() {
        return this.popoverWidth;
    }

    @Override // com.obric.oui.popover.v2.b
    public int getPopoverHeight() {
        return this.popoverHeight;
    }

    @Override // com.obric.oui.popover.v2.b
    public boolean getPopoverEnableBubbleMaterial() {
        return this.popoverEnableBubbleMaterial;
    }

    @Override // com.obric.oui.popover.v2.b
    public d.h.a.b<Boolean, com.obric.oui.material.c[]> getPopoverMaterials() {
        return this.popoverMaterials;
    }

    @Override // com.obric.oui.popover.v2.b
    public boolean getPopoverCoverPreviousWhenStacked() {
        return this.popoverCoverPreviousWhenStacked;
    }

    @Override // com.obric.oui.popover.v2.b
    public int getPopoverStackCoverColor() {
        return this.popoverStackCoverColor;
    }

    @Override // com.obric.oui.popover.v2.b
    public float getPopoverStackAlphaPrevious() {
        return this.popoverStackAlphaPrevious;
    }

    @Override // com.obric.oui.popover.v2.b
    public float getPopoverStackScalePrevious() {
        return this.popoverStackScalePrevious;
    }

    public final boolean isShowing() {
        return this.isShowing;
    }

    /* JADX INFO: renamed from: autoDismissRunnable$lambda-0, reason: not valid java name */
    private static final void m1139autoDismissRunnable$lambda0(OPopoverModal r1) {
        o.e(r1, "this$0");
        if (r1.isShowing == false) goto L6;
        r1.dismiss();
        return;
    }

    /* JADX INFO: renamed from: detachedCleanupRunnable$lambda-1, reason: not valid java name */
    private static final void m1140detachedCleanupRunnable$lambda1(OPopoverModal r1) {
        o.e(r1, "this$0");
        if (r1.isAttachedToWindow() == false) goto L5;
        return;
    L5:
        if (r1.getParent() != null) goto L9;
        r1.performDetachedCleanup();
        return;
    }

    private final void setBubbleLayout(View r3) {
        setPopoverBubbleLayout(createPopoverBubbleLayout(r3, 2));
        k.a((View) ZeusTransformUtils.preCheckCast(getPopoverBubbleLayout(), View.class, "com.obric.aiagent.plugin"), (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"));
    }

    private final void initContentView() {
        if (getPopoverBgColor() == 0) goto L6;
        getPopoverBubbleLayout().setBgColor(getPopoverBgColor());
    L6:
        if (getPopoverBubbleLayout().isEnableMaterial() == true) goto L8;
        getPopoverBubbleLayout().setBorderColor(getPopoverBgColor());
        getPopoverBubbleLayout().setBorderWidth(getPopoverBorderWidth());
    L8:
        getPopoverBubbleLayout().setTransparentBg(getPopoverTransparentBg());
    }

    private final void setupOutsideTouchHandler() {
        setOnTouchListener(new $$Lambda$OPopoverModal$OsmWkCSgCCxskat0xeKT9e45K4k(this));
    }

    /* JADX INFO: renamed from: setupOutsideTouchHandler$lambda-2, reason: not valid java name */
    private static final boolean m1141setupOutsideTouchHandler$lambda2(OPopoverModal r1, View r2, MotionEvent r3) {
        o.e(r1, "this$0");
        if (r1.isShowing == true) goto L6;
        return false;
    L6:
        if (r3.getAction() == 0) goto L8;
        return false;
    L8:
        if (r1.mOutsideTouchable == false) goto L13;
        r1.dismiss();
        return true;
    L13:
        return true;
    }

    public final void setOnDismissListener(d.h.a.a<x> r3) {
        this.dismissListener = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
    }

    public final void setOnShowListener(d.h.a.a<x> r3) {
        this.showListener = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
    }

    public final void setOnBubbleShowListener(OPopover.d r3) {
        this.bubbleShowListener = (OPopover.d) ZeusTransformUtils.wrapperContextForParams(r3, OPopover.d.class, "com.obric.aiagent.plugin");
    }

    public final void setOnBubbleStartDismissListener(OPopover.e r3) {
        this.bubbleStartDismissListener = (OPopover.e) ZeusTransformUtils.wrapperContextForParams(r3, OPopover.e.class, "com.obric.aiagent.plugin");
    }

    public final void setOnBubbleDismissListener(OPopover.c r3) {
        this.bubbleDismissListener = (OPopover.c) ZeusTransformUtils.wrapperContextForParams(r3, OPopover.c.class, "com.obric.aiagent.plugin");
    }

    public final void setRemoveOnDismiss(boolean r1) {
        this.removeOnDismiss = r1;
    }

    public final void setEnableAutoDismiss(boolean r5) {
        removeCallbacks(this.autoDismissRunnable);
        if (r5 == false) goto L8;
        long r0 = this.mAutoDismissDelayMillis;
        if (r0 <= 0) goto L9;
        postDelayed(this.autoDismissRunnable, r0);
        return;
    L9:
        return;
    }

    public final void setXOffset(int r1) {
        setXOffsetInternal(r1);
    }

    public final void setYOffset(int r1) {
        setYOffsetInternal(r1);
    }

    public final View getContentView() {
        return getContentViewInternal();
    }

    public final void measurePopup(int r1, int r2) {
        measurePopupInternal(r1, r2);
    }

    public final int getDisplayRotationDegrees$OUI_standardRelease() {
        return getDisplayRotationDegreesInternal();
    }

    public static /* synthetic */ ViewGroup resolveHostParent$OUI_standardRelease$default(OPopoverModal r0, ViewGroup r1, int r2, Object r3) {
        if (r3 != null) goto L9;
        if ((r2 & 1) == 0) goto L7;
        r1 = null;
    L7:
        return r0.resolveHostParent$OUI_standardRelease(r1);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resolveHostParent");
    }

    public final ViewGroup resolveHostParent$OUI_standardRelease(ViewGroup r1) {
        if (r1 == null) goto L4;
        return r1;
    L4:
        return findDecorViewParent();
    }

    public final void setGravity$OUI_standardRelease(int r1) {
        setGravityInternal(r1);
    }

    public static /* synthetic */ void showAtLocation$default(OPopoverModal r6, View r7, ViewGroup r8, int r9, int r10, int r11, int r12, Object r13) {
        if (r13 != null) goto L9;
        if ((r12 & 2) == 0) goto L6;
        r8 = null;
    L6:
        r6.showAtLocation(r7, r8, r9, r10, r11);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showAtLocation");
    }

    public final void showAtLocation(View r7, ViewGroup r8, int r9, int r10, int r11) {
        o.e(r7, "anchor");
        ViewGroup r12 = resolveHostParent$OUI_standardRelease(r8);
        if (r12 != null) goto L5;
        return;
    L5:
        ensureAttachedToParent(r12);
        this.currentHostParent = r12;
        this.currentAnchorRef = new WeakReference(r7);
        if (r9 == 0) goto L8;
        setGravity$OUI_standardRelease(r9);
    L8:
        bringToFront();
        setVisibility(0);
        removeCallbacks(this.autoDismissRunnable);
        long r0 = this.mAutoDismissDelayMillis;
        if (r0 <= 0) goto L12;
        postDelayed(this.autoDismissRunnable, r0);
    L12:
        if (this.isShowing == false) goto L15;
        getPopoverWindowFrame().setVisibility(0);
        updatePopoverPivotInternal();
        return;
    L15:
        this.isShowing = true;
        interceptBackPressedIfNeeded();
        beforeShowInStackIfNeeded();
        m<Integer, Integer> r1 = addShadowFrameIfNeeded(r10, r11);
        int[] r3 = new int[2];
        r7.getLocationInWindow(r3);
        setPopoverAnchorCenterX(r3[0] + (r7.getWidth() / 2.0f));
        setPopoverAnchorCenterY(r3[1] + (r7.getHeight() / 2.0f));
        int[] r13 = new int[2];
        r12.getLocationInWindow(r13);
        int r14 = r10 - ((Number) ZeusTransformUtils.preCheckCast(r1.a(), Number.class, "com.obric.aiagent.plugin")).intValue();
        int r15 = r11 - ((Number) ZeusTransformUtils.preCheckCast(r1.b(), Number.class, "com.obric.aiagent.plugin")).intValue();
        setPopoverPopupOriginX(r14 + getPopoverXOffset());
        setPopoverPopupOriginY(r15 + getPopoverYOffset());
        ViewGroup.LayoutParams r16 = getPopoverWindowFrame().getLayoutParams();
        Objects.requireNonNull(r16, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams r17 = (FrameLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r16, FrameLayout.LayoutParams.class, "com.obric.aiagent.plugin");
        r17.gravity = 51;
        r17.topMargin = getPopoverPopupOriginY() - r13[1];
        getPopoverWindowFrame().setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r17, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        afterShowInStackIfNeeded();
        if (shouldAnimatePopoverVisibilityInternal() == true) goto L18;
        showPopoverWithoutAnimationInternal();
        return;
    L18:
        playPopoverEnterAnimationInternal();
    }

    public final void dismiss() {
        if (this.isShowing == true) goto L5;
        return;
    L5:
        removeCallbacks(this.autoDismissRunnable);
        if (shouldAnimatePopoverVisibilityInternal() == true) goto L8;
        finishPopoverDismissInternal();
        return;
    L8:
        playPopoverExitAnimationInternal();
    }

    public final void dismissDirectly() {
        if (this.isShowing == true) goto L5;
        return;
    L5:
        removeCallbacks(this.autoDismissRunnable);
        finishPopoverDismissInternal();
    }

    public final void onDestroy() {
        dismissDirectly();
    }

    @Override // com.obric.oui.popover.v2.b
    public int resolvePopoverAnimationGravityInternal() {
        return getPopoverGravity() & 112;
    }

    @Override // com.obric.oui.popover.v2.b
    public void onPopoverShownInternal() {
        OPopover.d r0 = this.bubbleShowListener;
        if (r0 == null) goto L6;
        r0.a();
    L6:
        d.h.a.a<x> r1 = this.showListener;
        if (r1 == null) goto L11;
        r1.invoke();
        return;
    }

    @Override // com.obric.oui.popover.v2.b
    public void onPopoverStartDismissInternal() {
        OPopover.e r0 = this.bubbleStartDismissListener;
        if (r0 == null) goto L7;
        r0.a();
        return;
    }

    @Override // com.obric.oui.popover.v2.b
    public void finishPopoverDismissInternal() {
        ViewGroup r0 = null;
        setPopoverAnimator(null);
        this.isShowing = false;
        restoreWindowCallback();
        setVisibility(8);
        getPopoverWindowFrame().setVisibility(4);
        b.C0977b.a((b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.aiagent.plugin"), null, 1, null);
        cleanupFakeAnchorIfNeeded();
        onDestroyInStackIfNeeded();
        if (this.removeOnDismiss == false) goto L10;
        ViewParent r1 = getParent();
        if (ZeusTransformUtils.instanceOf(r1, ViewGroup.class) == false) goto L7;
        r0 = (ViewGroup) ZeusTransformUtils.preCheckCast(r1, ViewGroup.class, "com.obric.aiagent.plugin");
    L7:
        if (r0 == null) goto L10;
        r0.removeView((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"));
    L10:
        OPopover.c r2 = this.bubbleDismissListener;
        if (r2 == null) goto L14;
        r2.a();
    L14:
        d.h.a.a<x> r4 = this.dismissListener;
        if (r4 == null) goto L19;
        r4.invoke();
        return;
    }

    private final void interceptBackPressedIfNeeded() {
        if (this.mEnableBackPressDismiss == true) goto L5;
        return;
    L5:
        com.obric.oui.window.a r0 = com.obric.oui.window.a.f36851a;
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r1, "context");
        Activity r2 = (Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.getActivity(r1), "com.obric.aiagent.plugin"), Activity.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L8;
        return;
    L8:
        a r3 = Companion;
        a.a(r3, r2);
        a.a(r3, r2, this);
    }

    private final void restoreWindowCallback() {
        com.obric.oui.window.a r0 = com.obric.oui.window.a.f36851a;
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r1, "context");
        Activity r2 = (Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.getActivity(r1), "com.obric.aiagent.plugin"), Activity.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L5;
        return;
    L5:
        a.b(Companion, r2, this);
    }

    private final void cleanupFakeAnchorIfNeeded() {
        WeakReference<View> r0 = this.currentAnchorRef;
        if (r0 != null) goto L5;
        View r1 = null;
    L7:
        if (ZeusTransformUtils.instanceOf(r1, FakeAnchorView.class) == false) goto L15;
        ViewParent r3 = ((FakeAnchorView) ZeusTransformUtils.preCheckCast(r1, FakeAnchorView.class, "com.obric.aiagent.plugin")).getParent();
        if (ZeusTransformUtils.instanceOf(r3, ViewGroup.class) == false) goto L11;
        ViewGroup r2 = (ViewGroup) ZeusTransformUtils.preCheckCast(r3, ViewGroup.class, "com.obric.aiagent.plugin");
    L12:
        if (r2 == null) goto L15;
        r2.removeView(r1);
        goto L15
    L11:
        r2 = null;
    L15:
        this.currentAnchorRef = null;
        this.currentHostParent = null;
        return;
    L5:
        r1 = (View) ZeusTransformUtils.preCheckCast(r0.get(), View.class, "com.obric.aiagent.plugin");
        goto L7
    }

    private final void performDetachedCleanup() {
        cancelPopoverAnimatorInternal();
        this.isShowing = false;
        setVisibility(8);
        getPopoverWindowFrame().setVisibility(4);
        b.C0977b.a((b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.aiagent.plugin"), null, 1, null);
        cleanupFakeAnchorIfNeeded();
        onDestroyInStackIfNeeded();
    }

    private final void ensureAttachedToParent(ViewGroup r4) {
        if (getParent() != r4) goto L5;
        return;
    L5:
        ViewParent r0 = getParent();
        if (ZeusTransformUtils.instanceOf(r0, ViewGroup.class) == false) goto L8;
        ViewGroup r1 = (ViewGroup) ZeusTransformUtils.preCheckCast(r0, ViewGroup.class, "com.obric.aiagent.plugin");
    L9:
        if (r1 == null) goto L12;
        r1.removeView((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"));
    L12:
        r4.addView((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), new ViewGroup.LayoutParams(-1, -1));
        return;
    L8:
        r1 = null;
        goto L9
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

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        restoreWindowCallback();
        super.onDetachedFromWindow();
        removeCallbacks(this.autoDismissRunnable);
        this.mainHandler.removeCallbacks(this.detachedCleanupRunnable);
        this.mainHandler.post(this.detachedCleanupRunnable);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        this.mainHandler.removeCallbacks(this.detachedCleanupRunnable);
        super.onAttachedToWindow();
    }

    public final void setMaxContentHeight(int r3) {
        b.C0977b.a((b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.aiagent.plugin"), r3, null, 2, null);
    }

    @Override // com.obric.oui.popover.v2.b
    public boolean isPopoverShowing() {
        return this.isShowing;
    }

    private final m<Integer, Integer> addShadowFrameIfNeeded(int r2, int r3) {
        if (this.mShadowEnabled == false) goto L6;
        return addShadowFrame(r2, r3);
    L6:
        return new m(0, 0);
    }

    private final m<Integer, Integer> addShadowFrame(int r13, int r14) {
        View r15 = ZeusTransformUtils.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")), ZeusTransformUtils.mapRes(R.layout.o_layout_popover_shadow_frame, "layout", "o_layout_popover_shadow_frame"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.aiagent.plugin"), false, "com.obric.aiagent.plugin");
        Objects.requireNonNull(r15, "null cannot be cast to non-null type com.obric.oui.popover.SingleChildFrameLayout");
        SingleChildFrameLayout r16 = (SingleChildFrameLayout) ZeusTransformUtils.preCheckCast(r15, SingleChildFrameLayout.class, "com.obric.aiagent.plugin");
        r16.addView((View) ZeusTransformUtils.preCheckCast(getPopoverBubbleLayout(), View.class, "com.obric.aiagent.plugin"), (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new FrameLayout.LayoutParams(-2, -2), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        r16.setShadowCornerRadius(d.i.a.a(getPopoverBubbleLayout().getCornerRadius()));
        r16.setShadowInsets(getPopoverBubbleLayout().getArrowHeight(), getPopoverBubbleLayout().getArrowHeight());
        r16.setClipChildren(false);
        r16.setClipToPadding(false);
        if (this.mSpacingForShadow == false) goto L5;
        b.c r1 = resolvePopoverShadowPadding(this.mShadowStyle);
    L6:
        this.popoverContentView = (ViewGroup) ZeusTransformUtils.preCheckCast(r16, ViewGroup.class, "com.obric.aiagent.plugin");
        Context r5 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r5, "context");
        SingleChildFrameLayout r2 = new SingleChildFrameLayout(r5, null, 2, null);
        r2.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new ViewGroup.MarginLayoutParams(-1, -2), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        r2.addView((View) ZeusTransformUtils.preCheckCast(r16, View.class, "com.obric.aiagent.plugin"), (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new FrameLayout.LayoutParams(-2, -2), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        r2.setClipChildren(false);
        r2.setClipToPadding(false);
        r2.setPadding(0, r1.b(), 0, r1.d());
        r16.setX(r13);
        setPopoverWindowFrame((ViewGroup) ZeusTransformUtils.preCheckCast(r2, ViewGroup.class, "com.obric.aiagent.plugin"));
        getPopoverWindowFrame().setVisibility(4);
        addView((View) ZeusTransformUtils.preCheckCast(getPopoverWindowFrame(), View.class, "com.obric.aiagent.plugin"), (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new FrameLayout.LayoutParams(-1, -2), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        return new m(Integer.valueOf(r13), Integer.valueOf(r1.b()));
    L5:
        r1 = new b.c(0, 0, 0, 0, 15, null);
        goto L6
    }

    static {
        Companion = new a(null);
        backPressManagerByActivity = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
    }
}
