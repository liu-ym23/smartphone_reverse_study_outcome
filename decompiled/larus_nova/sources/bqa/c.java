package bqa;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import com.larus.apm.impl.protector.RunnableProtector;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;

/* JADX INFO: loaded from: classes34.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ float f20105a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f20106b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f20107c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ SmartRefreshLayout f20108d;

    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f20109a;

        public a(c r100) {
            this.f20109a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            SmartRefreshLayout r101 = this.f20109a.f20108d;
            if (r101.J2 == null) goto L6;
            r101.V1.b(((Integer) r100.getAnimatedValue()).intValue(), true);
            return;
        }
    }

    public class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f20110a;

        public b(c r100) {
            this.f20110a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            SmartRefreshLayout r101 = this.f20110a.f20108d;
            if (r101.J2 == null) goto L9;
            r101.J2 = null;
            RefreshState r102 = r101.f405863b2;
            RefreshState r103 = RefreshState.ReleaseToLoad;
            if (r102 == r103) goto L7;
            r101.V1.d(r103);
        L7:
            c r104 = this.f20110a;
            r104.f20108d.setStateLoading(!r104.f20107c);
            return;
        }
    }

    public final void a() {
        SmartRefreshLayout r100 = this.f20108d;
        if (r100.f405870g2 == RefreshState.Loading) goto L5;
        return;
    L5:
        ValueAnimator r101 = r100.J2;
        if (r101 == null) goto L8;
        r101.cancel();
    L8:
        SmartRefreshLayout r102 = this.f20108d;
        r102.f405875j = r102.getMeasuredWidth() / 2.0f;
        this.f20108d.V1.d(RefreshState.PullUpToLoad);
        SmartRefreshLayout r103 = this.f20108d;
        r103.J2 = ValueAnimator.ofInt(new int[]{r103.f405861b, -((int) (r103.f405878k1 * this.f20105a))});
        this.f20108d.J2.setDuration(this.f20106b);
        this.f20108d.J2.setInterpolator(new hqa.b(0));
        this.f20108d.J2.addUpdateListener(new a(this));
        this.f20108d.J2.addListener(new b(this));
        this.f20108d.J2.start();
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

    public c(SmartRefreshLayout r100) {
        this.f20108d = r100;
        this.f20105a = 1.0f;
        this.f20106b = 0;
        this.f20107c = false;
    }
}
