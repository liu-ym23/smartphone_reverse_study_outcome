package bqa;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.Handler;
import android.view.MotionEvent;
import com.larus.apm.impl.protector.RunnableProtector;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import cqa.d;

/* JADX INFO: loaded from: classes34.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f20097a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f20098b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f20099c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ boolean f20100d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ SmartRefreshLayout f20101e;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f20102a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f20103b;

        /* JADX INFO: renamed from: bqa.b$a$a, reason: collision with other inner class name */
        public class C0341a extends AnimatorListenerAdapter {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f20104a;

            public C0341a(a r100) {
                this.f20104a = r100;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator r100) {
                b r101 = this.f20104a.f20103b;
                SmartRefreshLayout r102 = r101.f20101e;
                r102.F2 = false;
                if (r101.f20099c == false) goto L5;
                r102.D(true);
            L5:
                SmartRefreshLayout r103 = this.f20104a.f20103b.f20101e;
                if (r103.f405863b2 != RefreshState.LoadFinish) goto L9;
                r103.z(RefreshState.None);
                return;
            }
        }

        public final void a() {
            SmartRefreshLayout r100 = this.f20103b.f20101e;
            if (r100.M == true) goto L5;
        L7:
            eqa.a r101 = null;
        L8:
            if (r101 == null) goto L10;
            r101.onAnimationUpdate(ValueAnimator.ofInt(new int[]{0, 0}));
        L10:
            C0341a r102 = new C0341a(this);
            b r103 = this.f20103b;
            SmartRefreshLayout r104 = r103.f20101e;
            int r105 = r104.f405861b;
            if (r105 <= 0) goto L13;
            ValueAnimator r106 = r104.V1.a(0);
        L30:
            if (r106 == null) goto L32;
            r106.addListener(r102);
            return;
        L32:
            r102.onAnimationEnd(null);
            return;
        L13:
            if (r101 != null) goto L25;
            if (r105 == 0) goto L25;
            if (r103.f20099c == true) goto L19;
        L24:
            r106 = r104.V1.a(0);
            goto L30
        L19:
            if (r104.G == false) goto L24;
            int r107 = -r104.f405878k1;
            if (r105 < r107) goto L23;
            r104.z(RefreshState.None);
        L29:
            r106 = null;
            goto L30
        L23:
            r106 = r104.V1.a(r107);
        L25:
            ValueAnimator r108 = r104.J2;
            if (r108 == null) goto L28;
            r108.cancel();
            this.f20103b.f20101e.J2 = null;
        L28:
            this.f20103b.f20101e.V1.b(0, false);
            this.f20103b.f20101e.V1.d(RefreshState.None);
            goto L29
        L5:
            if (this.f20102a >= 0) goto L7;
            r101 = r100.Q1.e(r100.f405861b);
            goto L8
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(b r100, int r101) {
            this.f20103b = r100;
            this.f20102a = r101;
        }
    }

    public final void a() {
        int r100 = this.f20097a;
        boolean r101 = true;
        if (r100 != 0) goto L29;
        SmartRefreshLayout r102 = this.f20101e;
        RefreshState r103 = r102.f405863b2;
        RefreshState r104 = RefreshState.None;
        if (r103 == r104) goto L7;
    L9:
        ValueAnimator r105 = r102.J2;
        if (r105 == null) goto L19;
        if (r103.isDragging == true) goto L16;
        if (r103 != RefreshState.LoadReleased) goto L19;
    L16:
        if (r103.isFooter == false) goto L19;
        r102.J2 = null;
        r105.cancel();
        this.f20101e.V1.d(r104);
    L27:
        if (this.f20099c == false) goto L70;
        this.f20101e.D(true);
        return;
    L70:
        return;
    L19:
        if (r103 != RefreshState.Loading) goto L27;
        if (r102.P1 == null) goto L27;
        if (r102.Q1 == null) goto L27;
        this.f20097a = r100 + 1;
        r102.T1.postDelayed(this, this.f20098b);
        this.f20101e.z(RefreshState.LoadFinish);
        return;
    L7:
        if (r102.f405870g2 != RefreshState.Loading) goto L9;
        r102.f405870g2 = r104;
        goto L27
    L29:
        SmartRefreshLayout r106 = this.f20101e;
        int r107 = r106.P1.j(r106, this.f20100d);
        SmartRefreshLayout r108 = this.f20101e;
        gqa.c r109 = r108.f405884p0;
        if (r109 == null) goto L35;
        if ((r108.P1 instanceof d) == false) goto L35;
        r109.C();
    L35:
        if (r107 < Integer.MAX_VALUE) goto L37;
        return;
    L37:
        if (this.f20099c == false) goto L45;
        SmartRefreshLayout r110 = this.f20101e;
        if (r110.G == false) goto L45;
        if (r110.f405861b >= 0) goto L45;
        if (r110.Q1.a() == false) goto L45;
    L46:
        SmartRefreshLayout r111 = this.f20101e;
        int r112 = r111.f405861b;
        if (r101 == false) goto L49;
        int r113 = Math.max(r112, -r111.f405878k1);
    L50:
        int r114 = r112 - r113;
        SmartRefreshLayout r115 = this.f20101e;
        if (r115.f405881n == false) goto L53;
    L54:
        long r116 = System.currentTimeMillis();
        SmartRefreshLayout r117 = this.f20101e;
        if (r117.f405881n == false) goto L61;
        float r118 = r117.f405876k;
        r117.f405874i = r118;
        r117.f405865d = r117.f405861b - r114;
        r117.f405881n = false;
        if (r117.F == false) goto L59;
        int r119 = r114;
    L60:
        float r120 = r119;
        SmartRefreshLayout.n(r117, MotionEvent.obtain(r116, r116, 0, r117.f405875j, (r118 + r120) + (r117.f405860a * 2), 0));
        SmartRefreshLayout r121 = this.f20101e;
        SmartRefreshLayout.o(r121, MotionEvent.obtain(r116, r116, 2, r121.f405875j, r121.f405876k + r120, 0));
        goto L61
    L59:
        r119 = 0;
    L61:
        SmartRefreshLayout r122 = this.f20101e;
        if (r122.L0 == false) goto L64;
        r122.H0 = 0;
        SmartRefreshLayout.p(r122, MotionEvent.obtain(r116, r116, 1, r122.f405875j, r122.f405876k, 0));
        SmartRefreshLayout r123 = this.f20101e;
        r123.L0 = false;
        r123.f405865d = 0;
    L64:
        SmartRefreshLayout r124 = this.f20101e;
        Handler r125 = r124.T1;
        a r126 = new a(this, r114);
        if (r124.f405861b >= 0) goto L67;
        long r127 = r107;
    L68:
        r125.postDelayed(r126, r127);
        return;
    L67:
        r127 = 0;
        goto L68
    L53:
        if (r115.L0 == false) goto L64;
    L49:
        r113 = 0;
    L45:
        r101 = false;
        goto L46
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public b(SmartRefreshLayout r100, int r101, boolean r102) {
        this.f20101e = r100;
        this.f20098b = r101;
        this.f20099c = r102;
        this.f20100d = true;
        this.f20097a = 0;
    }
}
