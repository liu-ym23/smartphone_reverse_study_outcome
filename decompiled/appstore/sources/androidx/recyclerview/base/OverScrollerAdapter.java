package androidx.recyclerview.base;

import android.content.Context;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import kotlin.Lazy;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes.dex */
public final class OverScrollerAdapter {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a f3996i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static boolean f3997j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f3998a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Interpolator f3999b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f4000c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f4001d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f4002e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f4003f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f4004g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f4005h;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    static {
        f3996i = new a(null);
        f3997j = true;
    }

    public OverScrollerAdapter(Context r10, Interpolator r11) {
        q.g(r10, "context");
        q.g(r11, "interpolator");
        this.f3998a = r10;
        this.f3999b = r11;
        this.f4000c = kotlin.b.b(new OverScrollerAdapter$systemOverScroller$2(this));
        this.f4001d = kotlin.b.b(OverScrollerAdapter$fluidScrollerX$2.INSTANCE);
        this.f4002e = kotlin.b.b(OverScrollerAdapter$fluidScrollerY$2.INSTANCE);
        this.f4003f = f3997j;
        this.f4004g = -1;
        this.f4005h = -1;
    }

    public static final /* synthetic */ Context b(OverScrollerAdapter r10) {
        return r10.f3998a;
    }

    public static final /* synthetic */ Interpolator c(OverScrollerAdapter r10) {
        return r10.f3999b;
    }

    public final void a() {
        if (this.f4003f == false) goto L5;
        m().abortAnimation();
        return;
    L5:
        this.f4004g = -1;
    }

    public final boolean d() {
        if (this.f4003f == false) goto L7;
        return m().computeScrollOffset();
    L7:
        if (this.f4004g != (-1)) goto L10;
        return false;
    L10:
        this.f4005h = AnimationUtils.currentAnimationTimeMillis() - this.f4004g;
        return !n();
    }

    public final void e(int r12, int r13, int r14, int r15, int r16, int r17, int r18, int r19) {
        if (f3997j == false) goto L6;
        m().fling(r12, r13, r14, r15, r16, r17, r18, r19);
        return;
    L6:
        this.f4003f = false;
        float r10 = 1000;
        k().b(r12, r14 / r10);
        l().b(r13, r15 / r10);
        this.f4004g = AnimationUtils.currentAnimationTimeMillis();
    }

    public final float f() {
        if (this.f4003f == false) goto L7;
        return m().getCurrVelocity();
    L7:
        return ((float) Math.hypot(k().d(this.f4005h).b(), l().d(this.f4005h).b())) * 1000;
    }

    public final int g() {
        if (this.f4003f == false) goto L7;
        return m().getCurrX();
    L7:
        return (int) k().d(this.f4005h).a();
    }

    public final int h() {
        if (this.f4003f == false) goto L7;
        return m().getCurrY();
    L7:
        return (int) l().d(this.f4005h).a();
    }

    public final int i() {
        if (this.f4003f == false) goto L7;
        return m().getFinalX();
    L7:
        return (int) k().a();
    }

    public final int j() {
        if (this.f4003f == false) goto L7;
        return m().getFinalY();
    L7:
        return (int) l().a();
    }

    public final b k() {
        return (b) this.f4001d.getValue();
    }

    public final b l() {
        return (b) this.f4002e.getValue();
    }

    public final OverScroller m() {
        return (OverScroller) this.f4000c.getValue();
    }

    public final boolean n() {
        if (this.f4003f == true) goto L5;
        b.C0041b r10 = k().d(this.f4005h);
        b.C0041b r11 = l().d(this.f4005h);
        if (r10.c() == true) goto L9;
    L11:
        return false;
    L9:
        if (r11.c() == false) goto L11;
        return true;
    L5:
        return m().isFinished();
    }

    public final void o(int r10, int r11, int r12, int r13, int r14) {
        this.f4003f = true;
        m().startScroll(r10, r11, r12, r13, r14);
    }
}
