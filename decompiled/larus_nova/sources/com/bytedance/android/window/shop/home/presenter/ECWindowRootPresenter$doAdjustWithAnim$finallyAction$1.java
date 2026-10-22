package com.bytedance.android.window.shop.home.presenter;

import android.view.Choreographer;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.bytedance.android.ec.window.base.widget.ECWindowOverScrollExpandBehavior;
import com.bytedance.android.ec.window.base.widget.WindowControllableAppBarSnapBehavior;
import com.google.android.material.appbar.AppBarLayout;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes14.dex */
public final class ECWindowRootPresenter$doAdjustWithAnim$finallyAction$1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECWindowRootPresenter f188437a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CoordinatorLayout f188438b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f188439c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f188440d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ CoordinatorLayout.Behavior f188441e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ AppBarLayout f188442f;

    /* JADX INFO: renamed from: com.bytedance.android.window.shop.home.presenter.ECWindowRootPresenter$doAdjustWithAnim$finallyAction$1$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnLayoutChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECWindowRootPresenter$doAdjustWithAnim$finallyAction$1 f188443a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Runnable f188444b;

        public AnonymousClass1(ECWindowRootPresenter$doAdjustWithAnim$finallyAction$1 r100, a r101) {
            this.f188443a = r100;
            this.f188444b = r101;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
            if (this.f188443a.f188439c.getHeight() != this.f188443a.f188440d) goto L19;
            this.f188444b.run();
            CoordinatorLayout.Behavior r109 = this.f188443a.f188441e;
            if ((r109 instanceof WindowControllableAppBarSnapBehavior) == true) goto L7;
            CoordinatorLayout.Behavior r110 = null;
        L8:
            final WindowControllableAppBarSnapBehavior r111 = (WindowControllableAppBarSnapBehavior) r110;
            if (r111 != null) goto L11;
        L17:
            ECWindowRootPresenter$doAdjustWithAnim$finallyAction$1 r112 = this.f188443a;
            r112.f188437a.f188431o = false;
            r112.f188439c.removeOnLayoutChangeListener(this);
            return;
        L11:
            if ((r109 instanceof ECWindowOverScrollExpandBehavior) == true) goto L13;
            r109 = null;
        L13:
            ECWindowOverScrollExpandBehavior r113 = (ECWindowOverScrollExpandBehavior) r109;
            if (r113 == null) goto L16;
            r113.setExpandEnable(true);
        L16:
            ECWindowRootPresenter r114 = this.f188443a.f188437a;
            Function0<Unit> r115 = new ECWindowRootPresenter$doAdjustWithAnim$finallyAction$1$1$onLayoutChange$$inlined$let$lambda$1(r111, this);
            int r116 = ECWindowRootPresenter.f188428q;
            r114.getClass();
            Choreographer.getInstance().postFrameCallback(new x1(r115));
            goto L17
        L7:
            r110 = r109;
            goto L8
        }
    }

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECWindowRootPresenter$doAdjustWithAnim$finallyAction$1 f188445a;

        public a(ECWindowRootPresenter$doAdjustWithAnim$finallyAction$1 r100) {
            this.f188445a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ECWindowRootPresenter$doAdjustWithAnim$finallyAction$1 r100 = this.f188445a;     // Catch: Throwable -> L4
            ECWindowRootPresenter r101 = r100.f188437a;     // Catch: Throwable -> L4
            ECWindowRootPresenter.b0(r101, r100.f188438b, r101.N());     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public ECWindowRootPresenter$doAdjustWithAnim$finallyAction$1(ECWindowRootPresenter r100, CoordinatorLayout r101, View r102, int r103, CoordinatorLayout.Behavior r104, AppBarLayout r105) {
        this.f188437a = r100;
        this.f188438b = r101;
        this.f188439c = r102;
        this.f188440d = r103;
        this.f188441e = r104;
        this.f188442f = r105;
    }

    public final void a() {
        a r100 = new a(this);
        ViewGroup.LayoutParams r101 = this.f188439c.getLayoutParams();
        if (r101 == null) goto L5;
        r101.height = this.f188440d;
    L5:
        CoordinatorLayout.Behavior r102 = this.f188441e;
        if ((r102 instanceof ECWindowOverScrollExpandBehavior) == true) goto L8;
        r102 = null;
    L8:
        ECWindowOverScrollExpandBehavior r103 = (ECWindowOverScrollExpandBehavior) r102;
        if (r103 == null) goto L11;
        r103.refreshTargetOriginHeight(Integer.valueOf(this.f188440d));
    L11:
        this.f188439c.addOnLayoutChangeListener(new AnonymousClass1(this, r100));
        this.f188439c.requestLayout();
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
}
