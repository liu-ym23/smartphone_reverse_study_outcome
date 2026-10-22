package com.bytedance.android.window.shop.home.presenter;

import android.view.Choreographer;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.bytedance.android.ec.window.base.widget.ECWindowOverScrollExpandBehavior;
import com.bytedance.android.ec.window.base.widget.ECWindowOverScrollExpandCoordinatorLayout;
import com.bytedance.android.ec.window.base.widget.WindowControllableAppBarSnapBehavior;
import com.google.android.material.appbar.AppBarLayout;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes14.dex */
public final class ECWindowDialogStyleRootPresenter$doAdjustWithAnim$finallyAction$1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECWindowDialogStyleRootPresenter f188318a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CoordinatorLayout f188319b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f188320c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ CoordinatorLayout.Behavior f188321d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ boolean f188322e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f188323f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ AppBarLayout f188324g;

    /* JADX INFO: renamed from: com.bytedance.android.window.shop.home.presenter.ECWindowDialogStyleRootPresenter$doAdjustWithAnim$finallyAction$1$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnLayoutChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECWindowDialogStyleRootPresenter$doAdjustWithAnim$finallyAction$1 f188325a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Runnable f188326b;

        public AnonymousClass1(ECWindowDialogStyleRootPresenter$doAdjustWithAnim$finallyAction$1 r100, a r101) {
            this.f188325a = r100;
            this.f188326b = r101;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
            if (this.f188325a.f188320c.getHeight() != this.f188325a.f188318a.K()) goto L24;
            this.f188326b.run();
            CoordinatorLayout.Behavior r109 = this.f188325a.f188321d;
            if ((r109 instanceof WindowControllableAppBarSnapBehavior) == true) goto L7;
            CoordinatorLayout.Behavior r110 = null;
        L8:
            final WindowControllableAppBarSnapBehavior r111 = (WindowControllableAppBarSnapBehavior) r110;
            if (r111 != null) goto L11;
        L22:
            ECWindowDialogStyleRootPresenter$doAdjustWithAnim$finallyAction$1 r112 = this.f188325a;
            r112.f188318a.f188314p = false;
            r112.f188320c.removeOnLayoutChangeListener(this);
            ((ECWindowOverScrollExpandCoordinatorLayout) this.f188325a.f188318a.w().b(R.id.ec_shop_coordinator_layout).f()).f49913g = true;
            return;
        L11:
            if ((r109 instanceof ECWindowOverScrollExpandBehavior) == true) goto L13;
            r109 = null;
        L13:
            ECWindowOverScrollExpandBehavior r113 = (ECWindowOverScrollExpandBehavior) r109;
            if (r113 == null) goto L16;
            r113.setExpandEnable(true);
        L16:
            ECWindowDialogStyleRootPresenter$doAdjustWithAnim$finallyAction$1 r114 = this.f188325a;
            if (r114.f188318a.f188314p == true) goto L19;
        L21:
            r111.setOffsetDownEnable(true, Integer.valueOf(this.f188325a.f188323f));
            ECWindowDialogStyleRootPresenter r115 = this.f188325a.f188318a;
            Function0<Unit> r116 = new ECWindowDialogStyleRootPresenter$doAdjustWithAnim$finallyAction$1$1$onLayoutChange$$inlined$let$lambda$1(r111, this);
            r115.getClass();
            Choreographer.getInstance().postFrameCallback(new j0(r116));
            goto L22
        L19:
            if (r114.f188322e == true) goto L21;
            r111.snapTo(r114.f188323f, r114.f188319b, r114.f188324g);
            goto L21
        L7:
            r110 = r109;
            goto L8
        }
    }

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECWindowDialogStyleRootPresenter$doAdjustWithAnim$finallyAction$1 f188327a;

        public a(ECWindowDialogStyleRootPresenter$doAdjustWithAnim$finallyAction$1 r100) {
            this.f188327a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ECWindowDialogStyleRootPresenter$doAdjustWithAnim$finallyAction$1 r100 = this.f188327a;     // Catch: Throwable -> L4
            ECWindowDialogStyleRootPresenter r101 = r100.f188318a;     // Catch: Throwable -> L4
            ECWindowDialogStyleRootPresenter.Z(r101, r100.f188319b, r101.N());     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public ECWindowDialogStyleRootPresenter$doAdjustWithAnim$finallyAction$1(ECWindowDialogStyleRootPresenter r100, CoordinatorLayout r101, View r102, CoordinatorLayout.Behavior r103, boolean r104, int r105, AppBarLayout r106) {
        this.f188318a = r100;
        this.f188319b = r101;
        this.f188320c = r102;
        this.f188321d = r103;
        this.f188322e = r104;
        this.f188323f = r105;
        this.f188324g = r106;
    }

    public final void a() {
        a r100 = new a(this);
        ViewGroup.LayoutParams r101 = this.f188320c.getLayoutParams();
        if (r101 == null) goto L5;
        r101.height = this.f188318a.K();
    L5:
        CoordinatorLayout.Behavior r102 = this.f188321d;
        if ((r102 instanceof ECWindowOverScrollExpandBehavior) == true) goto L8;
        r102 = null;
    L8:
        ECWindowOverScrollExpandBehavior r103 = (ECWindowOverScrollExpandBehavior) r102;
        if (r103 == null) goto L11;
        r103.refreshTargetOriginHeight(Integer.valueOf(this.f188318a.K()));
    L11:
        this.f188320c.addOnLayoutChangeListener(new AnonymousClass1(this, r100));
        this.f188320c.requestLayout();
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
