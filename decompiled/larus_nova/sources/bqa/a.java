package bqa;

import android.animation.ValueAnimator;
import android.view.MotionEvent;
import com.larus.apm.impl.protector.RunnableProtector;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import cqa.e;

/* JADX INFO: loaded from: classes34.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f20092a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f20093b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Boolean f20094c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ boolean f20095d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ SmartRefreshLayout f20096e;

    public final void a() {
        int r100 = this.f20092a;
        eqa.a r101 = null;
        if (r100 != 0) goto L30;
        SmartRefreshLayout r102 = this.f20096e;
        RefreshState r103 = r102.f405863b2;
        RefreshState r104 = RefreshState.None;
        if (r103 == r104) goto L7;
    L9:
        ValueAnimator r105 = r102.J2;
        if (r105 == null) goto L19;
        if (r103.isHeader == false) goto L19;
        if (r103.isDragging == false) goto L16;
    L17:
        r102.J2 = null;
        r105.cancel();
        this.f20096e.V1.d(r104);
    L28:
        if (this.f20094c != Boolean.TRUE) goto L59;
        this.f20096e.D(true);
        return;
    L59:
        return;
    L16:
        if (r103 == RefreshState.RefreshReleased) goto L17;
    L19:
        if (r103 != RefreshState.Refreshing) goto L28;
        if (r102.M1 == null) goto L28;
        if (r102.Q1 == null) goto L28;
        this.f20092a = r100 + 1;
        r102.T1.postDelayed(this, this.f20093b);
        this.f20096e.z(RefreshState.RefreshFinish);
        if (this.f20094c != Boolean.FALSE) goto L28;
        this.f20096e.D(false);
        goto L28
    L7:
        if (r102.f405870g2 != RefreshState.Refreshing) goto L9;
        r102.f405870g2 = r104;
        goto L28
    L30:
        SmartRefreshLayout r106 = this.f20096e;
        int r107 = r106.M1.j(r106, this.f20095d);
        SmartRefreshLayout r108 = this.f20096e;
        gqa.c r109 = r108.f405884p0;
        if (r109 == null) goto L36;
        if ((r108.M1 instanceof e) == false) goto L36;
        r109.h();
    L36:
        if (r107 >= Integer.MAX_VALUE) goto L61;
        SmartRefreshLayout r110 = this.f20096e;
        if (r110.f405881n == false) goto L40;
    L41:
        long r111 = System.currentTimeMillis();
        SmartRefreshLayout r112 = this.f20096e;
        if (r112.f405881n == false) goto L44;
        float r113 = r112.f405876k;
        r112.f405874i = r113;
        r112.f405865d = 0;
        r112.f405881n = false;
        SmartRefreshLayout.k(r112, MotionEvent.obtain(r111, r111, 0, r112.f405875j, (r113 + r112.f405861b) - (r112.f405860a * 2), 0));
        SmartRefreshLayout r114 = this.f20096e;
        SmartRefreshLayout.l(r114, MotionEvent.obtain(r111, r111, 2, r114.f405875j, r114.f405876k + r114.f405861b, 0));
    L44:
        SmartRefreshLayout r115 = this.f20096e;
        if (r115.L0 == false) goto L47;
        r115.H0 = 0;
        SmartRefreshLayout.m(r115, MotionEvent.obtain(r111, r111, 1, r115.f405875j, r115.f405876k, 0));
        SmartRefreshLayout r116 = this.f20096e;
        r116.L0 = false;
        r116.f405865d = 0;
    L47:
        SmartRefreshLayout r117 = this.f20096e;
        int r118 = r117.f405861b;
        if (r118 <= 0) goto L55;
        ValueAnimator r119 = r117.q(0, r107, r117.f405899y, r117.f405867f);
        SmartRefreshLayout r120 = this.f20096e;
        if (r120.N == false) goto L52;
        r101 = r120.Q1.e(r120.f405861b);
    L52:
        if (r119 == null) goto L62;
        if (r101 == null) goto L63;
        r119.addUpdateListener(r101);
        return;
    L63:
        return;
    L62:
        return;
    L55:
        if (r118 >= 0) goto L57;
        r117.q(0, r107, r117.f405899y, r117.f405867f);
        return;
    L57:
        r117.V1.b(0, false);
        this.f20096e.V1.d(RefreshState.None);
        return;
    L40:
        if (r110.L0 == false) goto L47;
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

    public a(SmartRefreshLayout r100, int r101, Boolean r102, boolean r103) {
        this.f20096e = r100;
        this.f20093b = r101;
        this.f20094c = r102;
        this.f20095d = r103;
        this.f20092a = 0;
    }
}
