package com.bytedance.android.shopping.orderlist.list.slice.elements.tab;

import android.animation.ValueAnimator;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes13.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f180307a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Integer f180308b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Integer f180309c;

    public d(b r100, Integer r101, Integer r102) {
        this.f180307a = r100;
        this.f180308b = r101;
        this.f180309c = r102;
    }

    public final void a() {
        final b r100 = this.f180307a;
        int r101 = this.f180308b.intValue();
        final int r102 = this.f180309c.intValue();
        float r103 = r100.a(r101);
        float r104 = r100.a(r102);
        r100.f180303e.setTranslationX(r103);
        OrderListTabLayout.a r105 = r100.f180300b.e(r102);
        if (r105 == null) goto L15;
        OrderListTabItemView r106 = r105.f180294b;
        if (r106 == null) goto L15;
        int r107 = r106.getIndicatorBottomOffset();
        ViewGroup.LayoutParams r108 = r100.f180303e.getLayoutParams();
        if ((r108 instanceof FrameLayout.LayoutParams) == true) goto L9;
        r108 = null;
    L9:
        FrameLayout.LayoutParams r109 = (FrameLayout.LayoutParams) r108;
        if (r109 == null) goto L15;
        if (r109.bottomMargin == r107) goto L15;
        r109.bottomMargin = r107;
        r100.f180303e.setLayoutParams(r109);
    L15:
        r100.f180303e.setVisibility(0);
        OrderListTabLayout.a r110 = r100.f180300b.e(r101);
        if (r110 == null) goto L20;
        OrderListTabItemView r111 = r110.f180294b;
        if (r111 == null) goto L20;
        r111.f180278d.setVisibility(4);
    L20:
        ViewPropertyAnimator r112 = r100.f180303e.animate().setDuration(r100.f180299a).translationX(r104);
        com.bytedance.android.ec.core.utils.f.b(r112, new OrderListTabAnimHelper$doAnim$1(r100, r102));
        r112.start();
        OrderListTabLayout.a r113 = r100.f180300b.e(r102);
        if (r113 == null) goto L25;
        ValueAnimator r114 = ValueAnimator.ofInt(new int[]{r100.f180302d.getScrollX(), (r113.f180294b.getLeft() + (r113.f180294b.getWidth() / 2)) - (r100.f180302d.getWidth() / 2)});
        r114.addUpdateListener(new c(r100));
        r114.setDuration(r100.f180299a).start();
        return;
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
