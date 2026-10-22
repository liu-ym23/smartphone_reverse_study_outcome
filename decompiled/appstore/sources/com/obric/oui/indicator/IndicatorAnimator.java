package com.obric.oui.indicator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.oui.utils.log.L;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class IndicatorAnimator {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final b f14949i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final boolean f14950j = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f14951a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TimeInterpolator f14952b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Host f14953c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f14954d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.obric.oui.indicator.d f14955e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public a f14956f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f14957g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f14958h;

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0006\b`\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0007H&¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u000eH&¢\u0006\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\u001a8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001f\u001a\u00020\u001a8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001c¨\u0006 "}, d2 = {"Lcom/obric/oui/indicator/IndicatorAnimator$Host;", "", "Lbg/c;", "targetRange", "", "shouldRebindVisibleSlots", "(Lbg/c;)Z", "", "resolveViewportStepDistance", "()F", "Lcom/obric/oui/indicator/d;", WsConstants.KEY_CONNECTION_STATE, "Lcom/obric/oui/indicator/IndicatorAnimator$RenderReason;", "reason", "", "rebindVisibleSlots", "(Lcom/obric/oui/indicator/d;Lcom/obric/oui/indicator/IndicatorAnimator$RenderReason;)V", "applyViewportState", "(Lcom/obric/oui/indicator/d;)V", "sourceState", "targetState", "progress", "applyViewportTransitionProgress", "(Lcom/obric/oui/indicator/d;Lcom/obric/oui/indicator/d;F)V", "cancelVisibleDotAnimations", "()V", "", "getPagerCount", "()I", "pagerCount", "getMaxVisibleDots", "maxVisibleDots", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Host {
        void applyViewportState(@NotNull com.obric.oui.indicator.d r10);

        void applyViewportTransitionProgress(@NotNull com.obric.oui.indicator.d r10, @NotNull com.obric.oui.indicator.d r11, float r12);

        void cancelVisibleDotAnimations();

        int getMaxVisibleDots();

        int getPagerCount();

        void rebindVisibleSlots(@NotNull com.obric.oui.indicator.d r10, @NotNull RenderReason r11);

        float resolveViewportStepDistance();

        boolean shouldRebindVisibleSlots(@NotNull bg.c r10);
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/obric/oui/indicator/IndicatorAnimator$RenderReason;", "", "logValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getLogValue", "()Ljava/lang/String;", "SCROLL", "REFRESH_DOTS", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum RenderReason extends Enum<RenderReason> {
        private static final /* synthetic */ RenderReason[] $VALUES = null;
        public static final RenderReason REFRESH_DOTS = null;
        public static final RenderReason SCROLL = null;

        @NotNull
        private final String logValue;

        private static final /* synthetic */ RenderReason[] $values() {
            return new RenderReason[]{SCROLL, REFRESH_DOTS};
        }

        static {
            SCROLL = new RenderReason("SCROLL", 0, "scroll");
            REFRESH_DOTS = new RenderReason("REFRESH_DOTS", 1, "refreshDots");
            $VALUES = $values();
        }

        private RenderReason(String r10, int r11, String r12) {
            super(r10, r11);
            this.logValue = r12;
        }

        public static RenderReason valueOf(String r10) {
            return (RenderReason) Enum.valueOf(RenderReason.class, r10);
        }

        public static RenderReason[] values() {
            return (RenderReason[]) $VALUES.clone();
        }

        @NotNull
        public final String getLogValue() {
            return this.logValue;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/indicator/IndicatorAnimator$ScrollDirection;", "", "(Ljava/lang/String;I)V", "FORWARD", "BACKWARD", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum ScrollDirection extends Enum<ScrollDirection> {
        private static final /* synthetic */ ScrollDirection[] $VALUES = null;
        public static final ScrollDirection BACKWARD = null;
        public static final ScrollDirection FORWARD = null;

        private static final /* synthetic */ ScrollDirection[] $values() {
            return new ScrollDirection[]{FORWARD, BACKWARD};
        }

        static {
            FORWARD = new ScrollDirection("FORWARD", 0);
            BACKWARD = new ScrollDirection("BACKWARD", 1);
            $VALUES = $values();
        }

        private ScrollDirection(String r10, int r11) {
            super(r10, r11);
        }

        public static ScrollDirection valueOf(String r10) {
            return (ScrollDirection) Enum.valueOf(ScrollDirection.class, r10);
        }

        public static ScrollDirection[] values() {
            return (ScrollDirection[]) $VALUES.clone();
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f14959a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final com.obric.oui.indicator.d f14960b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public com.obric.oui.indicator.d f14961c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final IndicatorViewportShiftDirection f14962d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final RenderReason f14963e;

        public a(int r10, com.obric.oui.indicator.d r11, com.obric.oui.indicator.d r12, IndicatorViewportShiftDirection r13, RenderReason r14) {
            q.g(r11, "sourceState");
            q.g(r12, "targetState");
            q.g(r13, "direction");
            q.g(r14, "reason");
            this.f14959a = r10;
            this.f14960b = r11;
            this.f14961c = r12;
            this.f14962d = r13;
            this.f14963e = r14;
        }

        public final RenderReason a() {
            return this.f14963e;
        }

        public final com.obric.oui.indicator.d b() {
            return this.f14960b;
        }

        public final com.obric.oui.indicator.d c() {
            return this.f14961c;
        }

        public final int d() {
            return this.f14959a;
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof a) == true) goto L8;
            return false;
        L8:
            a r11 = (a) r10;
            if (this.f14959a == r11.f14959a) goto L12;
            return false;
        L12:
            if (q.b(this.f14960b, r11.f14960b) == true) goto L15;
            return false;
        L15:
            if (q.b(this.f14961c, r11.f14961c) == true) goto L18;
            return false;
        L18:
            if (this.f14962d == r11.f14962d) goto L21;
            return false;
        L21:
            if (this.f14963e == r11.f14963e) goto L23;
            return false;
        L23:
            return true;
        }

        public int hashCode() {
            return (((((((Integer.hashCode(this.f14959a) * 31) + this.f14960b.hashCode()) * 31) + this.f14961c.hashCode()) * 31) + this.f14962d.hashCode()) * 31) + this.f14963e.hashCode();
        }

        public String toString() {
            return "ActiveViewportTransition(transitionToken=" + this.f14959a + ", sourceState=" + this.f14960b + ", targetState=" + this.f14961c + ", direction=" + this.f14962d + ", reason=" + this.f14963e + ')';
        }
    }

    public static final class b {
        public /* synthetic */ b(DefaultConstructorMarker r10) {
            this();
        }

        public b() {
        }
    }

    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14964a = null;

        static {
            int[] r10 = new int[ScrollDirection.values().length];
            r10[ScrollDirection.BACKWARD.ordinal()] = 1;
            r10[ScrollDirection.FORWARD.ordinal()] = 2;
            f14964a = r10;
        }
    }

    public static final class d extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f14965a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ IndicatorAnimator f14966b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ a f14967c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Function0 f14968d;

        public d(IndicatorAnimator r10, a r11, Function0 r12) {
            this.f14966b = r10;
            this.f14967c = r11;
            this.f14968d = r12;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator r10) {
            q.g(r10, "animation");
            this.f14965a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r10) {
            q.g(r10, "animation");
            IndicatorAnimator.d(this.f14966b).animate().setUpdateListener(null).setListener(null);
            if (this.f14965a == false) goto L5;
            return;
        L5:
            a r11 = IndicatorAnimator.c(this.f14966b);
            if (r11 != null) goto L9;
            return;
        L9:
            if (r11.d() != this.f14967c.d()) goto L12;
            this.f14968d.invoke();
            return;
        }
    }

    static {
        f14949i = new b(null);
    }

    public IndicatorAnimator(View r10, TimeInterpolator r11, Host r12) {
        q.g(r10, "trackView");
        q.g(r11, "interpolator");
        q.g(r12, "host");
        this.f14951a = r10;
        this.f14952b = r11;
        this.f14953c = r12;
        this.f14954d = "OCarouselIndicator";
    }

    public static /* synthetic */ void a(IndicatorAnimator r10, a r11, float r12, ValueAnimator r13) {
        n(r10, r11, r12, r13);
    }

    public static final /* synthetic */ void b(IndicatorAnimator r10, a r11) {
        r10.f(r11);
    }

    public static final /* synthetic */ a c(IndicatorAnimator r10) {
        return r10.f14956f;
    }

    public static final /* synthetic */ View d(IndicatorAnimator r10) {
        return r10.f14951a;
    }

    public static final void n(IndicatorAnimator r10, a r11, float r12, ValueAnimator r13) {
        q.g(r10, "this$0");
        q.g(r11, "$transition");
        q.g(r13, "it");
        a r14 = r10.f14956f;
        if (r14 != null) goto L6;
        return;
    L6:
        if (r14.d() != r11.d()) goto L9;
        float r15 = Math.abs(r10.f14951a.getTranslationX()) / r12;
        r10.f14953c.applyViewportTransitionProgress(r11.b(), r11.c(), r15);
        return;
    }

    public final void e() {
        this.f14951a.animate().setUpdateListener(null).setListener(null).cancel();
    }

    public final void f(a r10) {
        a r11 = this.f14956f;
        if (r11 != null) goto L6;
        return;
    L6:
        if (r11.d() != r10.d()) goto L14;
        com.obric.oui.indicator.d r12 = r11.c();
        this.f14953c.rebindVisibleSlots(r12, r11.a());
        this.f14955e = r12;
        this.f14953c.applyViewportState(r12);
        boolean r13 = f14950j;
        if (r13 == false) goto L10;
        L.a(this.f14954d, "Commit viewport transition, token=" + r10.d() + " range=" + r12.c());
    L10:
        j();
        this.f14956f = null;
        if (r13 == false) goto L15;
        L.a(this.f14954d, "Finish viewport transition after commit, token=" + r10.d() + " range=" + r12.c());
        return;
    L15:
        return;
    }

    public final com.obric.oui.indicator.d g() {
        return this.f14955e;
    }

    public final String h() {
        return this.f14954d;
    }

    public final void i(RenderReason r10, com.obric.oui.indicator.d r11) {
        q.g(r10, "reason");
        q.g(r11, "nextViewportState");
        if (this.f14956f == null) goto L5;
        return;
    L5:
        com.obric.oui.indicator.d r12 = this.f14955e;
        if (r12 != null) goto L8;
        bg.c r13 = null;
    L9:
        boolean r14 = q.b(r13, r11.c());
        boolean r15 = !r14;
        if (r14 == true) goto L12;
    L15:
        boolean r16 = true;
    L17:
        if (l(r10, r12, r11, r15) == false) goto L22;
        if (r12 != null) goto L20;
        r12 = r11;
    L20:
        o(r12, r11, r10);
        return;
    L22:
        if (r16 == false) goto L24;
        this.f14953c.rebindVisibleSlots(r11, r10);
    L24:
        this.f14955e = r11;
        this.f14953c.applyViewportState(r11);
        return;
    L12:
        if (this.f14953c.shouldRebindVisibleSlots(r11.c()) == true) goto L15;
        r16 = false;
        goto L17
    L8:
        r13 = r12.c();
        goto L9
    }

    public final void j() {
        this.f14951a.setTranslationX(0.0f);
        com.obric.oui.indicator.d r10 = this.f14955e;
        if (r10 == null) goto L7;
        this.f14953c.applyViewportState(r10);
        return;
    }

    public final int k(int r10, int r11, float r12) {
        float r13 = this.f14958h;
        if (r12 <= r13) goto L6;
        ScrollDirection r14 = ScrollDirection.FORWARD;
    L10:
        if (r14 != null) goto L12;
        int r15 = -1;
    L14:
        if (r15 == (-1)) goto L26;
        if (r15 == 1) goto L23;
        if (r15 == 2) goto L26;
        throw new NoWhenBranchMatchedException();
    L23:
        if (r12 <= 0.5f) goto L29;
    L27:
        r10 = r11;
    L29:
        if (r12 == 0.0f) goto L32;
        this.f14958h = r12;
    L32:
        return r10;
    L26:
        if (r12 < 0.5f) goto L29;
    L12:
        r15 = c.f14964a[r14.ordinal()];
        goto L14
    L6:
        if (r12 >= r13) goto L8;
        r14 = ScrollDirection.BACKWARD;
        goto L10
    L8:
        r14 = null;
        goto L10
    }

    public final boolean l(RenderReason r10, com.obric.oui.indicator.d r11, com.obric.oui.indicator.d r12, boolean r13) {
        if (r10 != RenderReason.SCROLL) goto L16;
        if (r13 == false) goto L16;
        if (r11 != null) goto L12;
        if (f14950j == false) goto L10;
        L.a(this.f14954d, "Skip viewport transition, reason=" + r10.getLogValue() + " current=null next=" + r12.c());
    L10:
        return false;
    L12:
        if (this.f14953c.getPagerCount() > this.f14953c.getMaxVisibleDots()) goto L14;
        return false;
    L14:
        return true;
    L16:
        return false;
    }

    public final void m(final a r10, float r11, Function0 r12) {
        e();
        final float r13 = Math.abs(r11);
        this.f14951a.animate().translationX(r11).setDuration(300).setInterpolator(this.f14952b).setUpdateListener(new com.obric.oui.indicator.b(this, r10, r13)).setListener(new d(this, r10, r12)).start();
    }

    public final void o(com.obric.oui.indicator.d r11, com.obric.oui.indicator.d r12, RenderReason r13) {
        IndicatorViewportShiftDirection r10 = e.c(r11.c(), r12.c());
        if (r10 != null) goto L6;
        L.j(h(), "Abort viewport transition because range shift is not adjacent, source=" + r11.c() + " target=" + r12.c());
        this.f14953c.rebindVisibleSlots(r12, r13);
        this.f14955e = r12;
        this.f14953c.applyViewportState(r12);
        return;
    L6:
        float r14 = this.f14953c.resolveViewportStepDistance();
        if (r14 > 0.0f) goto L10;
        L.j(this.f14954d, q.p("Abort viewport transition because step distance is invalid, distance=", Float.valueOf(r14)));
        this.f14953c.rebindVisibleSlots(r12, r13);
        this.f14955e = r12;
        this.f14953c.applyViewportState(r12);
        return;
    L10:
        j();
        int r15 = this.f14957g + 1;
        this.f14957g = r15;
        final a r16 = new a(r15, r11, r12, r10, r13);
        this.f14956f = r16;
        if (f14950j == false) goto L13;
        L.a(this.f14954d, "Start viewport transition, reason=" + r13.getLogValue() + " from=" + r11.c() + " to=" + r12.c() + " direction=" + r10 + " distance=" + r14);
    L13:
        this.f14953c.applyViewportTransitionProgress(r11, r12, 0.0f);
        m(r16, r10.resolveExitTranslation(r14), new IndicatorAnimator$startViewportTransition$1(this, r16));
    }
}
