package com.obric.oui.bouncelayout;

import android.content.Context;
import android.graphics.Canvas;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.view.ViewParent;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.EdgeEffect;
import android.widget.HorizontalScrollView;
import androidx.core.widget.NestedScrollView;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.h.b.p;
import d.l.n;
import d.x;
import java.util.Map;
import java.util.WeakHashMap;
import me.ele.lancet.base.annotations.Skip;
import org.lsposed.hiddenapibypass.HiddenApiBypass;

/* JADX INFO: compiled from: BounceEdgeEffect.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class BounceEdgeEffect extends EdgeEffect {
    public static final a Companion = null;
    private static final float MAX_RELEASE_VELOCITY_PX_PER_MS = 20.0f;
    public static final int ORIENTATION_BOTTOM = 1;
    public static final int ORIENTATION_LEFT = 2;
    private static final int ORIENTATION_NONE = -1;
    public static final int ORIENTATION_RIGHT = 3;
    public static final int ORIENTATION_TOP = 0;
    private static final long RELEASE_VELOCITY_VALID_MS = 120;
    public static final String TAG = "BounceEdgeEffect";
    private static final long TOUCH_FINISH_PRESERVE_MS = 120;
    private static final WeakHashMap<View, a.C0927a> targetStates = null;
    private boolean abruptOppositeDeltaGuardArmed;
    private float accumulatedDragDistance;
    private long animationStartTime;
    private final DisplayMetrics displayMetrics;
    private long lastPullTime;
    private float lastPullTranslation;
    private float lastTouchDeltaX;
    private float maxOverscrollPx;
    private d.h.a.b<? super Float, x> onTranslationChanged;
    private final int orientation;
    private long preserveFinishForTouchUntil;
    private float pullMultiplier;
    private boolean pullMultiplierInitialized;
    private float releaseVelocityPxPerMs;
    private long releaseVelocityTime;
    private int sizePx;
    private com.obric.oui.orecyclerview.base.d springBack;
    private final View target;
    private float translation;
    private boolean useHeightForHorizontalSize;

    /* JADX INFO: compiled from: BounceEdgeEffect.kt */
    public static final class a {

        /* JADX INFO: renamed from: com.obric.oui.bouncelayout.BounceEdgeEffect$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: BounceEdgeEffect.kt */
        private static final class C0927a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private int f34071a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private int f34072b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private long f34073c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private int f34074d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            private long f34075e;
            private int f;
            private long g;
            private int h;
            private int i;
            private long j;
            private int k;
            private int l;

            public C0927a() {
                this.f34071a = -1;
                this.f34072b = -1;
                this.f34073c = -1;
                this.f34074d = -1;
                this.f34075e = -1;
                this.f = -1;
                this.g = -1;
                this.h = -1;
                this.j = -1;
                this.k = -1;
            }

            public final int a() {
                return this.f34071a;
            }

            public final void a(int r1) {
                this.f34071a = r1;
            }

            public final int b() {
                return this.f34072b;
            }

            public final void b(int r1) {
                this.f34072b = r1;
            }

            public final void a(long r1) {
                this.f34073c = r1;
            }

            public final long c() {
                return this.f34073c;
            }

            public final void c(int r1) {
                this.f34074d = r1;
            }

            public final int d() {
                return this.f34074d;
            }

            public final void b(long r1) {
                this.f34075e = r1;
            }

            public final long e() {
                return this.f34075e;
            }

            public final void d(int r1) {
                this.f = r1;
            }

            public final int f() {
                return this.f;
            }

            public final void c(long r1) {
                this.g = r1;
            }

            public final long g() {
                return this.g;
            }

            public final void e(int r1) {
                this.h = r1;
            }

            public final int h() {
                return this.h;
            }

            public final void f(int r1) {
                this.i = r1;
            }

            public final int i() {
                return this.i;
            }

            public final void d(long r1) {
                this.j = r1;
            }

            public final long j() {
                return this.j;
            }

            public final void g(int r1) {
                this.k = r1;
            }

            public final int k() {
                return this.k;
            }

            public final void h(int r1) {
                this.l = r1;
            }

            public final int l() {
                return this.l;
            }
        }

        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }

        public final void a(String r2) {
            o.e(r2, "signature");
            HiddenApiBypass.addHiddenApiExemptions(new String[]{r2});     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            a(BounceEdgeEffect.TAG, o.a("Failed to bypass hidden API restrictions for ", r2), th);
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int a(String r1, String r2, Throwable r3) {
            if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
            return 0;
        L5:
            return Log.w(r1, r2, r3);
        }
    }

    /* JADX INFO: compiled from: BounceEdgeEffect.kt */
    public static final class b extends p implements d.h.a.a<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f34076a = null;

        static {
            f34076a = new b();
        }

        public b() {
            super(0);
        }

        public final String a() {
            return "";
        }

        @Override // d.h.a.a
        public /* synthetic */ String invoke() {
            return a();
        }
    }

    private final boolean isVerticalOrientation(int r1) {
        if (r1 == 0) goto L8;
        if (r1 == 1) goto L9;
        return false;
    L9:
        return true;
    L8:
        return true;
    }

    public static final /* synthetic */ int access$getOrientation$p(BounceEdgeEffect r0) {
        return r0.orientation;
    }

    public static final /* synthetic */ View access$getTarget$p(BounceEdgeEffect r0) {
        return r0.target;
    }

    public final float getMaxOverscrollPx() {
        return this.maxOverscrollPx;
    }

    public final void setMaxOverscrollPx(float r1) {
        this.maxOverscrollPx = r1;
    }

    public BounceEdgeEffect(Context r3, View r4, int r5, float r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r7, "context");
        o.e(r4, "target");
        super(r7);
        this.target = r4;
        this.orientation = r5;
        this.maxOverscrollPx = r6;
        this.pullMultiplier = 1.0f;
        this.abruptOppositeDeltaGuardArmed = true;
        this.animationStartTime = -1;
        this.displayMetrics = ZeusTransformUtils.getResources(r7, "com.obric.aiagent.plugin").getDisplayMetrics();
        this.lastPullTime = -1;
        this.releaseVelocityTime = -1;
        this.preserveFinishForTouchUntil = -1;
    }

    static {
        Companion = new a(null);
        targetStates = new WeakHashMap();
    }

    private final a.C0927a targetState() {
        WeakHashMap<View, a.C0927a> r0 = targetStates;
        monitor-enter(r0);
        Map r1 = (Map) ZeusTransformUtils.preCheckCast(r0, Map.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L10
        View r3 = this.target;     // Catch: Throwable -> L10
        Object r2 = r1.get(r3);     // Catch: Throwable -> L10
        if (r2 != null) goto L7;
        r2 = new a.C0927a();     // Catch: Throwable -> L10
        r1.put(r3, r2);     // Catch: Throwable -> L10
    L7:
        a.C0927a r4 = (a.C0927a) ZeusTransformUtils.preCheckCast(r2, a.C0927a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L10
        monitor-exit(r0);
        return r4;
    L10:
        th = move-exception;
        throw th;
    }

    private final boolean isSameAxis(int r3) {
        if (isVerticalOrientation(this.orientation) == false) goto L8;
        if (r3 == 0) goto L12;
        if (r3 == 1) goto L12;
        return false;
    L12:
        return true;
    L8:
        if (r3 == 2) goto L12;
        if (r3 == 3) goto L12;
        return false;
    }

    private final int getActiveOrientation(a.C0927a r2) {
        if (isVerticalOrientation(this.orientation) == false) goto L6;
        return r2.a();
    L6:
        return r2.b();
    }

    private final void setActiveOrientation(a.C0927a r2, int r3) {
        if (isVerticalOrientation(this.orientation) == false) goto L5;
        r2.a(r3);
        return;
    L5:
        r2.b(r3);
    }

    private final void markActiveOrientation(String r5) {
        a.C0927a r0 = targetState();
        int r1 = getActiveOrientation(r0);
        int r2 = this.orientation;
        if (r1 == r2) goto L8;
        setActiveOrientation(r0, r2);
        d r3 = d.f34149a;
        if (d.a() == false) goto L9;
        d.a(this.target, "activeEdgeChanged", "from=" + r1 + " to=" + this.orientation + " reason=" + r5);
        return;
    L9:
        return;
    }

    private final void clearActiveOrientationIfCurrent(String r4) {
        a.C0927a r0 = targetState();
        if (getActiveOrientation(r0) != this.orientation) goto L8;
        setActiveOrientation(r0, -1);
        d r1 = d.f34149a;
        if (d.a() == false) goto L9;
        d.a(this.target, "activeEdgeCleared", "orientation=" + this.orientation + " reason=" + r4);
        return;
    L9:
        return;
    }

    private final void recordReleaseFrame(a.C0927a r2, long r3) {
        if (isVerticalOrientation(this.orientation) == false) goto L5;
        r2.a(r3);
        r2.c(this.orientation);
        return;
    L5:
        r2.b(r3);
        r2.d(this.orientation);
    }

    private final boolean wasOppositeReleasedInSameFrame(a.C0927a r6, long r7) {
        if (isVerticalOrientation(this.orientation) == false) goto L10;
        if (r6.c() != r7) goto L15;
        if (r6.d() == this.orientation) goto L15;
        return true;
    L15:
        return false;
    L10:
        if (r6.e() != r7) goto L15;
        if (r6.f() == this.orientation) goto L15;
        return true;
    }

    private final long lastPullTime(a.C0927a r2) {
        if (isVerticalOrientation(this.orientation) == false) goto L6;
        return r2.g();
    L6:
        return r2.j();
    }

    private final int lastPullOrientation(a.C0927a r2) {
        if (isVerticalOrientation(this.orientation) == false) goto L6;
        return r2.h();
    L6:
        return r2.k();
    }

    private final int lastPullSign(a.C0927a r2) {
        if (isVerticalOrientation(this.orientation) == false) goto L6;
        return r2.i();
    L6:
        return r2.l();
    }

    private final void recordPullFrame(a.C0927a r2, long r3, float r5) {
        int r6 = (int) Math.signum(r5);
        if (r6 != 0) goto L6;
        return;
    L6:
        if (isVerticalOrientation(this.orientation) == false) goto L8;
        r2.c(r3);
        r2.e(this.orientation);
        r2.f(r6);
        return;
    L8:
        r2.d(r3);
        r2.g(this.orientation);
        r2.h(r6);
    }

    private final void resetInactiveReleaseState(String r4) {
        d r0 = d.f34149a;
        if (d.a() == false) goto L5;
        d.a(this.target, "onReleaseSkipped", "orientation=" + this.orientation + " reason=" + r4 + " translation=" + getTranslation());
    L5:
        this.animationStartTime = -1;
        this.accumulatedDragDistance = 0.0f;
        setTranslation(0.0f, false);
        this.pullMultiplier = 1.0f;
        this.pullMultiplierInitialized = false;
        this.abruptOppositeDeltaGuardArmed = true;
        resetReleaseVelocityTracker();
        this.target.invalidate();
    }

    public final float getTranslation() {
        return this.translation;
    }

    private final void setTranslation(float r2) {
        if (this.translation != r2) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L12;
        this.translation = r2;
        d.h.a.b<? super Float, x> r1 = this.onTranslationChanged;
        if (r1 == null) goto L13;
        r1.invoke(Float.valueOf(r2));
        return;
    L13:
        return;
    L12:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final d.h.a.b<Float, x> getOnTranslationChanged() {
        return this.onTranslationChanged;
    }

    public final void setOnTranslationChanged(d.h.a.b<? super Float, x> r3) {
        this.onTranslationChanged = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
    }

    private final void ensurePullMultiplier(float r6) {
        if (this.pullMultiplierInitialized == false) goto L6;
        return;
    L6:
        if (r6 != 0.0f) goto L8;
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        return;
    L11:
        float r2 = -1.0f;
        if (ZeusTransformUtils.instanceOf(this.target, NestedScrollView.class) == false) goto L18;
        if (this.orientation != 0) goto L18;
        if (r6 < 0.0f) goto L27;
    L26:
        r2 = 1.0f;
    L27:
        this.pullMultiplier = r2;
        this.pullMultiplierInitialized = true;
        return;
    L18:
        if (ZeusTransformUtils.instanceOf(this.target, HorizontalScrollView.class) == false) goto L24;
        if (this.orientation != 2) goto L24;
        if (r6 >= 0.0f) goto L26;
    L24:
        if (ZeusTransformUtils.instanceOf(this.target, HorizontalScrollView.class) == false) goto L26;
        int r7 = this.orientation;
        goto L26
    L8:
        r1 = false;
        goto L9
    }

    public final void updateTouchDeltaX(float r1) {
        this.lastTouchDeltaX = r1;
    }

    private final boolean isPulling(float r5) {
        if (r5 != 0.0f) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L9;
        return false;
    L9:
        if (this.accumulatedDragDistance <= 0.0f) goto L11;
        return true;
    L11:
        ensurePullMultiplier(r5);
        if (getDeltaPx(r5) > 0.0f) goto L14;
        return false;
    L14:
        int r6 = this.orientation;
        if (r6 == 0) goto L32;
        if (r6 == 1) goto L29;
        if (r6 == 2) goto L26;
        if (r6 == 3) goto L23;
        return false;
    L23:
        if (this.target.canScrollHorizontally(1) == false) goto L34;
        return false;
    L34:
        return true;
    L26:
        if (this.target.canScrollHorizontally(-1) == false) goto L34;
        return false;
    L29:
        if (this.target.canScrollVertically(1) == false) goto L34;
        return false;
    L32:
        if (this.target.canScrollVertically(-1) == false) goto L34;
        return false;
    L5:
        r1 = false;
        goto L6
    }

    private final float getDeltaPx(float r7) {
        if (ZeusTransformUtils.instanceOf(this.target, HorizontalScrollView.class) == false) goto L22;
        int r0 = this.orientation;
        if (r0 == 2) goto L7;
        if (r0 != 3) goto L22;
    L7:
        float r8 = Math.abs(r7) * this.sizePx;
        int r1 = this.orientation;
        boolean r3 = false;
        if (r1 == 2) goto L15;
        if (r1 == 3) goto L12;
    L10:
        r3 = true;
    L17:
        if (r3 == false) goto L20;
        return r8;
    L20:
        return -r8;
    L12:
        if (this.lastTouchDeltaX <= 0.0f) goto L17;
    L15:
        if (this.lastTouchDeltaX >= 0.0f) goto L17;
    L22:
        return (r7 * this.pullMultiplier) * this.sizePx;
    }

    private final boolean isUnscrollableOnCurrentAxis() {
        int r0 = this.orientation;
        if (r0 == 0) goto L12;
        if (r0 == 1) goto L12;
        if (this.target.canScrollHorizontally(-1) == false) goto L9;
        return false;
    L9:
        if (this.target.canScrollHorizontally(1) == false) goto L16;
        return false;
    L16:
        return true;
    L12:
        if (this.target.canScrollVertically(-1) == false) goto L14;
        return false;
    L14:
        if (this.target.canScrollVertically(1) == false) goto L16;
        return false;
    }

    private final boolean shouldIgnoreAbruptOppositeDelta(float r6, float r7, long r8) {
        if (this.accumulatedDragDistance > 0.0f) goto L5;
    L24:
        return false;
    L5:
        if (r6 >= 0.0f) goto L24;
        if (r7 > 0.0f) goto L24;
        if (this.abruptOppositeDeltaGuardArmed == false) goto L24;
        if (isUnscrollableOnCurrentAxis() == false) goto L24;
        a.C0927a r0 = targetState();
        if (lastPullTime(r0) != r8) goto L24;
        if (lastPullSign(r0) <= 0) goto L24;
        this.abruptOppositeDeltaGuardArmed = false;
        d r9 = d.f34149a;
        if (d.a() == false) goto L25;
        d.a(this.target, "oppositeDeltaSkipped", "orientation=" + this.orientation + " deltaPx=" + r6 + " accumulated=" + this.accumulatedDragDistance + " target=" + r7);
        return true;
    L25:
        return true;
    }

    private final void syncAccumulatedDistanceFromTranslationIfNeeded() {
        if (this.maxOverscrollPx <= 0.0f) goto L19;
        boolean r2 = true;
        if (this.translation != 0.0f) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == true) goto L21;
        float r1 = com.obric.oui.orecyclerview.base.b.f35513a.b(Math.abs(this.translation), this.maxOverscrollPx);
        if (this.animationStartTime == (-1)) goto L13;
    L17:
        this.accumulatedDragDistance = r1;
        return;
    L13:
        if (this.accumulatedDragDistance == 0.0f) goto L16;
        r2 = false;
    L16:
        if (r2 == true) goto L17;
        return;
    L21:
        return;
    L7:
        r0 = false;
        goto L8
    }

    private final float distanceDeltaToPullDistance(float r2) {
        return (r2 / this.sizePx) / this.pullMultiplier;
    }

    private final boolean shouldSkipPullInCurrentFrame(float r11, long r12, String r14) {
        if (r11 != 0.0f) goto L5;
        boolean r3 = true;
    L6:
        if (r3 == false) goto L8;
        return false;
    L8:
        a.C0927a r4 = targetState();
        int r5 = getActiveOrientation(r4);
        if (r5 == (-1)) goto L17;
        if (r5 == this.orientation) goto L17;
        d r13 = d.f34149a;
        if (d.a() == false) goto L15;
        d.a(this.target, "onPullSkipped", "orientation=" + this.orientation + " activeOrientation=" + r5 + " reason=" + r14 + "ActiveEdge deltaPx=" + r11 + " translation=" + getTranslation());
    L15:
        return true;
    L17:
        if (isUnscrollableOnCurrentAxis() == false) goto L27;
        if (r11 >= 0.0f) goto L27;
        if (lastPullTime(r4) != r12) goto L27;
        if (lastPullSign(r4) <= 0) goto L27;
        d r15 = d.f34149a;
        if (d.a() == false) goto L26;
        d.a(this.target, "onPullSkipped", "orientation=" + this.orientation + " lastOrientation=" + lastPullOrientation(r4) + " reason=" + r14 + "OppositeInSameFrame deltaPx=" + r11 + " translation=" + getTranslation());
    L26:
        return true;
    L27:
        return false;
    L5:
        r3 = false;
        goto L6
    }

    public final void stopAnimationForTouch() {
        if (this.animationStartTime == (-1)) goto L5;
    L11:
        this.accumulatedDragDistance = com.obric.oui.orecyclerview.base.b.f35513a.b(Math.abs(this.translation), this.maxOverscrollPx);
        this.animationStartTime = -1;
        this.abruptOppositeDeltaGuardArmed = true;
        resetReleaseVelocityTracker();
        this.preserveFinishForTouchUntil = AnimationUtils.currentAnimationTimeMillis() + 120;
        this.target.invalidate();
        return;
    L5:
        if (this.translation != 0.0f) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == false) goto L11;
        if (this.accumulatedDragDistance > 0.0f) goto L11;
        return;
    L7:
        r0 = false;
        goto L8
    }

    private final void setTranslation(float r5, boolean r6) {
        if (r6 == false) goto L4;
        updateReleaseVelocity(r5);
    L4:
        setTranslation(r5);
        d r7 = d.f34149a;
        if (d.a() == false) goto L20;
        float r1 = 0.0f;
        if (access$getOrientation$p(this) != 2) goto L9;
    L12:
        float r8 = getTranslation();
    L14:
        if (access$getOrientation$p(this) != 0) goto L16;
    L17:
        r1 = getTranslation();
    L18:
        d.a(access$getTarget$p(this), "setTranslation", r8, r1, "trackVelocity=" + r6 + " orientation=" + this.orientation);
        return;
    L16:
        if (access$getOrientation$p(this) != 1) goto L18;
    L9:
        if (access$getOrientation$p(this) == 3) goto L12;
        r8 = 0.0f;
        goto L14
    }

    private final void updateReleaseVelocity(float r7) {
        long r0 = AnimationUtils.currentAnimationTimeMillis();
        long r2 = this.lastPullTime;
        if (r2 != (-1)) goto L5;
    L7:
        this.lastPullTranslation = r7;
        this.lastPullTime = r0;
        d r1 = d.f34149a;
        if (d.a() == false) goto L11;
        d.a(this.target, "velocitySample", "orientation=" + this.orientation + " velocityPxPerMs=" + this.releaseVelocityPxPerMs + " translation=" + r7);
        return;
    L11:
        return;
    L5:
        if (r0 <= r2) goto L7;
        this.releaseVelocityPxPerMs = n.a((r7 - this.lastPullTranslation) / (r0 - r2), -20.0f, 20.0f);
        this.releaseVelocityTime = r0;
        goto L7
    }

    static /* synthetic */ void logFrame$default(BounceEdgeEffect r3, String r4, d.h.a.a r5, int r6, Object r7) {
        d.h.a.a r8 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.a.class, "com.obric.aiagent.plugin");
        if ((r6 & 2) == 0) goto L5;
        r8 = (d.h.a.a) ZeusTransformUtils.preCheckCast(b.f34076a, d.h.a.a.class, "com.obric.aiagent.plugin");
    L5:
        d r9 = d.f34149a;
        if (d.a() == false) goto L21;
        float r1 = 0.0f;
        if (access$getOrientation$p(r3) != 2) goto L10;
    L13:
        float r10 = r3.getTranslation();
    L15:
        if (access$getOrientation$p(r3) != 0) goto L17;
    L18:
        r1 = r3.getTranslation();
    L19:
        d.a(access$getTarget$p(r3), r4, r10, r1, (String) ZeusTransformUtils.preCheckCast(r8.invoke(), String.class, "com.obric.aiagent.plugin"));
        return;
    L17:
        if (access$getOrientation$p(r3) != 1) goto L19;
    L10:
        if (access$getOrientation$p(r3) == 3) goto L13;
        r10 = 0.0f;
        goto L15
    }

    private final void logFrame(String r6, d.h.a.a<String> r7) {
        d.h.a.a r8 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r7, d.h.a.a.class, "com.obric.aiagent.plugin");
        d r0 = d.f34149a;
        if (d.a() == false) goto L18;
        float r3 = 0.0f;
        if (access$getOrientation$p(this) != 2) goto L7;
    L10:
        float r1 = getTranslation();
    L12:
        if (access$getOrientation$p(this) != 0) goto L14;
    L15:
        r3 = getTranslation();
    L16:
        d.a(access$getTarget$p(this), r6, r1, r3, (String) ZeusTransformUtils.preCheckCast(r8.invoke(), String.class, "com.obric.aiagent.plugin"));
        return;
    L14:
        if (access$getOrientation$p(this) != 1) goto L16;
    L7:
        if (access$getOrientation$p(this) == 3) goto L10;
        r1 = 0.0f;
        goto L12
    }

    private final float getCurrentFrameIntervalMs() {
        Display r0 = this.target.getDisplay();
        WindowManager r1 = null;
        if (r0 != null) goto L5;
        Float r2 = null;
    L7:
        if (r2 != null) goto L17;
        Object r4 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.target.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getSystemService("window");
        if (ZeusTransformUtils.instanceOf(r4, WindowManager.class) == false) goto L11;
        r1 = (WindowManager) ZeusTransformUtils.preCheckCast(r4, WindowManager.class, "com.obric.aiagent.plugin");
    L11:
        if (r1 != null) goto L13;
    L12:
        float r5 = 0.0f;
    L19:
        if (r5 > 0.0f) goto L23;
        return 16.67f;
    L23:
        return 1000.0f / r5;
    L13:
        Display r6 = r1.getDefaultDisplay();
        if (r6 == null) goto L12;
        r5 = r6.getRefreshRate();
        goto L19
    L17:
        r5 = r2.floatValue();
        goto L19
    L5:
        r2 = Float.valueOf(r0.getRefreshRate());
        goto L7
    }

    private final float getReleaseVelocityPxPerMs() {
        long r0 = AnimationUtils.currentAnimationTimeMillis();
        long r2 = this.releaseVelocityTime;
        if (r2 != (-1)) goto L5;
    L7:
        return 0.0f;
    L5:
        if ((r0 - r2) > 120) goto L7;
        return this.releaseVelocityPxPerMs;
    }

    private final void resetReleaseVelocityTracker() {
        this.lastPullTranslation = this.translation;
        this.lastPullTime = -1;
        this.releaseVelocityPxPerMs = 0.0f;
        this.releaseVelocityTime = -1;
    }

    private final float px(float r2) {
        return TypedValue.applyDimension(1, r2, this.displayMetrics);
    }

    private final float dp(float r1) {
        return r1 / this.displayMetrics.density;
    }

    public final void setUseHeightForHorizontalSize(boolean r1) {
        this.useHeightForHorizontalSize = r1;
    }

    @Override // android.widget.EdgeEffect
    public void setSize(int r3, int r4) {
        super.setSize(r3, r4);
        int r0 = this.orientation;
        if (r0 == 2) goto L7;
        if (r0 == 3) goto L7;
    L8:
        r3 = r4;
    L9:
        this.sizePx = r3;
        return;
    L7:
        if (this.useHeightForHorizontalSize == false) goto L9;
        goto L8
    }

    @Override // android.widget.EdgeEffect
    public void onPull(float r2) {
        onPull(r2, 0.5f);
    }

    @Override // android.widget.EdgeEffect
    public void onPull(float r9, float r10) {
        if (this.sizePx > 0) goto L5;
        return;
    L5:
        if (this.maxOverscrollPx <= 0.0f) goto L67;
        boolean r1 = false;
        if (r9 != 0.0f) goto L10;
        boolean r11 = true;
    L11:
        if (r11 == false) goto L13;
        return;
    L13:
        this.preserveFinishForTouchUntil = -1;
        d r12 = d.f34149a;
        if (d.a() == false) goto L16;
        d.a(this.target, "onPull", "orientation=" + this.orientation + " deltaDistance=" + r9);
    L16:
        ensurePullMultiplier(r9);
        if (this.animationStartTime == (-1)) goto L19;
        this.accumulatedDragDistance = com.obric.oui.orecyclerview.base.b.f35513a.b(Math.abs(this.translation), this.maxOverscrollPx);
        this.animationStartTime = -1;
        this.abruptOppositeDeltaGuardArmed = true;
        resetReleaseVelocityTracker();
    L19:
        ViewParent r13 = this.target.getParent();
        if (r13 == null) goto L23;
        r13.requestDisallowInterceptTouchEvent(true);
    L23:
        syncAccumulatedDistanceFromTranslationIfNeeded();
        if (this.accumulatedDragDistance != 0.0f) goto L26;
        boolean r14 = true;
    L27:
        if (r14 == true) goto L29;
    L32:
        float r15 = getDeltaPx(r9);
        long r3 = AnimationUtils.currentAnimationTimeMillis();
        if (shouldSkipPullInCurrentFrame(r15, r3, "onPull") == false) goto L36;
        this.target.invalidate();
        return;
    L36:
        float r16 = this.accumulatedDragDistance + r15;
        if (shouldIgnoreAbruptOppositeDelta(r15, r16, r3) == false) goto L40;
        markActiveOrientation("skipAbruptOppositeOnPull");
        this.target.invalidate();
        return;
    L40:
        float r17 = n.a(r16, 0.0f);
        this.accumulatedDragDistance = r17;
        if (r15 > 0.0f) goto L43;
    L45:
        recordPullFrame(targetState(), r3, r15);
        float r18 = com.obric.oui.orecyclerview.base.b.f35513a.a(this.accumulatedDragDistance, this.maxOverscrollPx);
        int r19 = this.orientation;
        if (r19 == 0) goto L54;
        if (r19 != 1) goto L49;
    L53:
        r18 = -Math.abs(r18);
    L55:
        setTranslation(r18, true);
        if (this.accumulatedDragDistance <= 0.0f) goto L58;
    L63:
        markActiveOrientation("onPull");
    L64:
        this.target.invalidate();
        return;
    L58:
        if (r18 != 0.0f) goto L60;
        r1 = true;
    L60:
        if (r1 == false) goto L63;
        clearActiveOrientationIfCurrent("onPullZero");
        goto L64
    L49:
        if (r19 == 2) goto L54;
        if (r19 == 3) goto L53;
    L54:
        r18 = Math.abs(r18);
        goto L55
    L43:
        if (r17 <= 0.0f) goto L45;
        this.abruptOppositeDeltaGuardArmed = true;
        goto L45
    L29:
        if (isPulling(r9) == true) goto L32;
        setTranslation(0.0f, false);
        resetReleaseVelocityTracker();
        return;
    L26:
        r14 = false;
        goto L27
    L10:
        r11 = false;
        goto L11
    }

    @Override // android.widget.EdgeEffect
    public float getDistance() {
        if (this.sizePx > 0) goto L6;
        return 0.0f;
    L6:
        syncAccumulatedDistanceFromTranslationIfNeeded();
        return this.accumulatedDragDistance / this.sizePx;
    }

    @Override // android.widget.EdgeEffect
    public float onPullDistance(float r1, float r2) {
        return onPullDistanceInternal(r1, false);
    }

    public final float onPullDistanceAfterContentScrollExhausted$OUI_standardRelease(float r2) {
        return onPullDistanceInternal(r2, true);
    }

    private final float onPullDistanceInternal(float r10, boolean r11) {
        if (this.sizePx > 0) goto L5;
    L83:
        return 0.0f;
    L5:
        if (this.maxOverscrollPx <= 0.0f) goto L83;
        boolean r2 = false;
        if (r10 != 0.0f) goto L10;
        boolean r0 = true;
    L11:
        if (r0 == false) goto L13;
        return 0.0f;
    L13:
        this.preserveFinishForTouchUntil = -1;
        d r1 = d.f34149a;
        if (d.a() == false) goto L16;
        d.a(this.target, "onPullDistance", "orientation=" + this.orientation + " deltaDistance=" + r10);
    L16:
        ensurePullMultiplier(r10);
        if (this.animationStartTime == (-1)) goto L19;
        this.accumulatedDragDistance = com.obric.oui.orecyclerview.base.b.f35513a.b(Math.abs(this.translation), this.maxOverscrollPx);
        this.animationStartTime = -1;
        this.abruptOppositeDeltaGuardArmed = true;
        resetReleaseVelocityTracker();
    L19:
        ViewParent r3 = this.target.getParent();
        if (r3 == null) goto L23;
        r3.requestDisallowInterceptTouchEvent(true);
    L23:
        syncAccumulatedDistanceFromTranslationIfNeeded();
        float r4 = getDeltaPx(r10);
        if (this.accumulatedDragDistance != 0.0f) goto L26;
        boolean r5 = true;
    L27:
        if (r5 == true) goto L29;
    L35:
        long r6 = AnimationUtils.currentAnimationTimeMillis();
        if (shouldSkipPullInCurrentFrame(r4, r6, "onPullDistance") == false) goto L39;
        this.target.invalidate();
        return r10;
    L39:
        float r12 = this.accumulatedDragDistance + r4;
        if (shouldIgnoreAbruptOppositeDelta(r4, r12, r6) == false) goto L43;
        markActiveOrientation("skipAbruptOppositeOnPullDistance");
        this.target.invalidate();
        return r10;
    L43:
        float r7 = Math.abs(this.translation);
        if (r4 >= 0.0f) goto L52;
        if (r7 <= 0.0f) goto L52;
        float r13 = r7 + r4;
        if (r13 <= 0.0f) goto L50;
        this.accumulatedDragDistance = com.obric.oui.orecyclerview.base.b.f35513a.b(r13, this.maxOverscrollPx);
    L57:
        recordPullFrame(targetState(), r6, r4);
        int r14 = this.orientation;
        float r8 = 1.0f;
        if (r14 == 0) goto L72;
        if (r14 != 1) goto L61;
    L71:
        r8 = -1.0f;
        goto L72
    L61:
        if (r14 == 2) goto L72;
        if (r14 == 3) goto L71;
        float r15 = this.translation;
        if (r15 != 0.0f) goto L67;
        boolean r9 = true;
    L68:
        if (r9 == true) goto L72;
        r8 = Math.signum(r15);
        goto L72
    L67:
        r9 = false;
    L72:
        float r16 = r8 * Math.abs(com.obric.oui.orecyclerview.base.b.f35513a.a(this.accumulatedDragDistance, this.maxOverscrollPx));
        setTranslation(r16, true);
        if (this.accumulatedDragDistance <= 0.0f) goto L75;
    L80:
        markActiveOrientation("onPullDistance");
    L81:
        this.target.invalidate();
        return r10;
    L75:
        if (r16 != 0.0f) goto L77;
        r2 = true;
    L77:
        if (r2 == false) goto L80;
        clearActiveOrientationIfCurrent("onPullDistanceZero");
        goto L81
    L50:
        r10 = distanceDeltaToPullDistance(-r7);
        this.accumulatedDragDistance = 0.0f;
        clearActiveOrientationIfCurrent("onPullDistanceVisibleConsumedToZero");
    L52:
        if (r12 <= 0.0f) goto L56;
        this.accumulatedDragDistance = r12;
        if (r4 <= 0.0f) goto L57;
        this.abruptOppositeDeltaGuardArmed = true;
        goto L57
    L56:
        r10 = ((-this.accumulatedDragDistance) / this.sizePx) * this.pullMultiplier;
        this.accumulatedDragDistance = 0.0f;
        clearActiveOrientationIfCurrent("onPullDistanceConsumedToZero");
        goto L57
    L29:
        if (isPulling(r10) == true) goto L35;
        if (r11 == true) goto L32;
    L33:
        setTranslation(0.0f, false);
        resetReleaseVelocityTracker();
        return 0.0f;
    L32:
        if (r4 > 0.0f) goto L35;
    L26:
        r5 = false;
        goto L27
    L10:
        r0 = false;
        goto L11
    }

    @Override // android.widget.EdgeEffect
    public void onRelease() {
        this.preserveFinishForTouchUntil = -1;
        long r2 = AnimationUtils.currentAnimationTimeMillis();
        a.C0927a r4 = targetState();
        int r5 = getActiveOrientation(r4);
        if (r5 == (-1)) goto L9;
        if (r5 == this.orientation) goto L9;
        resetInactiveReleaseState(o.a("inactiveEdge activeOrientation=", Integer.valueOf(r5)));
        return;
    L9:
        if (wasOppositeReleasedInSameFrame(r4, r2) == false) goto L12;
        resetInactiveReleaseState("oppositeReleasedInSameFrame");
        return;
    L12:
        float r6 = this.translation;
        if (r6 != 0.0f) goto L15;
        boolean r7 = true;
    L16:
        if (r7 == false) goto L19;
        this.accumulatedDragDistance = 0.0f;
        this.animationStartTime = -1;
        this.abruptOppositeDeltaGuardArmed = true;
        resetReleaseVelocityTracker();
        clearActiveOrientationIfCurrent("releaseZeroTranslation");
        return;
    L19:
        float r0 = dp(r6);
        float r1 = dp(getReleaseVelocityPxPerMs());
        d r8 = d.f34149a;
        if (d.a() == false) goto L22;
        d.a(this.target, "onRelease", "orientation=" + this.orientation + " initialValueDp=" + r0 + " initialVelocityDpPerMs=" + r1);
    L22:
        recordReleaseFrame(r4, r2);
        markActiveOrientation("onRelease");
        this.animationStartTime = r2;
        if (this.springBack != null) goto L25;
        this.springBack = new com.obric.oui.orecyclerview.base.d();
    L25:
        com.obric.oui.orecyclerview.base.d r3 = this.springBack;
        if (r3 == null) goto L29;
        r3.a(r1, r0);
    L29:
        resetReleaseVelocityTracker();
        this.target.invalidate();
        return;
    L15:
        r7 = false;
        goto L16
    }

    @Override // android.widget.EdgeEffect
    public void onAbsorb(int r14) {
        this.preserveFinishForTouchUntil = -1;
        if (this.maxOverscrollPx > 0.0f) goto L6;
        return;
    L6:
        if (this.animationStartTime == (-1)) goto L11;
        d r0 = d.f34149a;
        if (d.a() == false) goto L52;
        d.a(this.target, "onAbsorbSkipped", "orientation=" + this.orientation + " velocity=" + r14 + " reason=animationRunning");
        return;
    L52:
        return;
    L11:
        d r2 = d.f34149a;
        if (d.a() == false) goto L14;
        d.a(this.target, "onAbsorb", "orientation=" + this.orientation + " velocity=" + r14);
    L14:
        resetReleaseVelocityTracker();
        markActiveOrientation("onAbsorb");
        int r3 = this.orientation;
        if (r3 == 1) goto L19;
        if (r3 == 3) goto L19;
        int r15 = Math.abs(r14);
    L20:
        float r16 = dp(r15 / 1000.0f);
        long r7 = AnimationUtils.currentAnimationTimeMillis();
        this.animationStartTime = r7;
        if (this.springBack != null) goto L23;
        this.springBack = new com.obric.oui.orecyclerview.base.d();
    L23:
        float r9 = dp(this.translation);
        com.obric.oui.orecyclerview.base.d r10 = this.springBack;
        if (r10 == null) goto L27;
        r10.a(r16, r9);
    L27:
        if (r10 == null) goto L50;
        float r17 = getCurrentFrameIntervalMs();
        if (r17 <= 0.0f) goto L50;
        this.animationStartTime = r7 - d.i.a.b(r17);
        com.obric.oui.orecyclerview.base.d.a r8 = r10.a(r17);
        setTranslation(px(r8.a()), false);
        d r11 = d.f34149a;
        if (d.a() == false) goto L48;
        if (access$getOrientation$p(this) != 2) goto L35;
    L38:
        float r4 = getTranslation();
    L40:
        if (access$getOrientation$p(this) != 0) goto L42;
    L45:
        float r12 = getTranslation();
    L46:
        d.a(access$getTarget$p(this), "onAbsorbImmediateFrame", r4, r12, "orientation=" + this.orientation + " elapsed=" + r17 + " refreshRate=" + (1000.0f / r17) + " finished=" + r8.b());
        goto L48
    L42:
        if (access$getOrientation$p(this) == 1) goto L45;
        r12 = 0.0f;
        goto L46
    L35:
        if (access$getOrientation$p(this) == 3) goto L38;
        r4 = 0.0f;
    L48:
        if (r8.b() == false) goto L50;
        setTranslation(0.0f, false);
        this.animationStartTime = -1;
        this.accumulatedDragDistance = 0.0f;
        this.pullMultiplier = 1.0f;
        this.pullMultiplierInitialized = false;
        this.abruptOppositeDeltaGuardArmed = true;
        clearActiveOrientationIfCurrent("absorbImmediateFinished");
    L50:
        this.target.invalidate();
        return;
    L19:
        r15 = -Math.abs(r14);
        goto L20
    }

    @Override // android.widget.EdgeEffect
    public boolean draw(Canvas r13) {
        o.e(r13, "canvas");
        com.obric.oui.orecyclerview.base.d r14 = this.springBack;
        if (this.animationStartTime == (-1)) goto L27;
        if (r14 == null) goto L27;
        long r4 = AnimationUtils.currentAnimationTimeMillis() - this.animationStartTime;
        com.obric.oui.orecyclerview.base.d.a r15 = r14.a(r4);
        setTranslation(px(r15.a()), false);
        d r0 = d.f34149a;
        if (d.a() == false) goto L23;
        if (access$getOrientation$p(this) != 2) goto L10;
    L13:
        float r1 = getTranslation();
    L15:
        if (access$getOrientation$p(this) != 0) goto L17;
    L20:
        float r8 = getTranslation();
    L21:
        d.a(access$getTarget$p(this), "draw", r1, r8, "orientation=" + this.orientation + " elapsed=" + r4 + " finished=" + r15.b());
        goto L23
    L17:
        if (access$getOrientation$p(this) == 1) goto L20;
        r8 = 0.0f;
        goto L21
    L10:
        if (access$getOrientation$p(this) == 3) goto L13;
        r1 = 0.0f;
    L23:
        if (r15.b() == true) goto L26;
        this.target.invalidate();
        return true;
    L26:
        setTranslation(0.0f, false);
        this.animationStartTime = -1;
        this.accumulatedDragDistance = 0.0f;
        this.pullMultiplier = 1.0f;
        this.pullMultiplierInitialized = false;
        this.abruptOppositeDeltaGuardArmed = true;
        resetReleaseVelocityTracker();
        clearActiveOrientationIfCurrent("drawFinished");
    L27:
        return false;
    }

    @Override // android.widget.EdgeEffect
    public boolean isFinished() {
        if (this.animationStartTime != (-1)) goto L11;
        if (this.translation != 0.0f) goto L7;
        boolean r4 = true;
    L8:
        if (r4 == false) goto L11;
        return true;
    L7:
        r4 = false;
    L11:
        return false;
    }

    @Override // android.widget.EdgeEffect
    public void finish() {
        if (this.preserveFinishForTouchUntil < AnimationUtils.currentAnimationTimeMillis()) goto L23;
        boolean r2 = false;
        if (this.translation != 0.0f) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == true) goto L10;
    L11:
        super.finish();
        this.animationStartTime = -1;
        syncAccumulatedDistanceFromTranslationIfNeeded();
        this.abruptOppositeDeltaGuardArmed = true;
        resetReleaseVelocityTracker();
        this.preserveFinishForTouchUntil = -1;
        if (this.translation != 0.0f) goto L15;
        r2 = true;
    L15:
        if (r2 == true) goto L17;
    L18:
        markActiveOrientation("finishPreservedForTouch");
    L19:
        this.target.invalidate();
        d r1 = d.f34149a;
        if (d.a() == false) goto L25;
        d.a(this.target, "finishPreservedForTouch", "orientation=" + this.orientation + " translation=" + getTranslation());
        return;
    L25:
        return;
    L17:
        if (this.accumulatedDragDistance <= 0.0f) goto L19;
    L10:
        if (this.accumulatedDragDistance <= 0.0f) goto L23;
    L7:
        r0 = false;
    L23:
        forceFinish$OUI_standardRelease();
    }

    public final void forceFinish$OUI_standardRelease() {
        super.finish();
        this.animationStartTime = -1;
        this.accumulatedDragDistance = 0.0f;
        setTranslation(0.0f, false);
        this.pullMultiplier = 1.0f;
        this.pullMultiplierInitialized = false;
        this.abruptOppositeDeltaGuardArmed = true;
        resetReleaseVelocityTracker();
        this.preserveFinishForTouchUntil = -1;
        clearActiveOrientationIfCurrent("finish");
        this.target.invalidate();
    }
}
