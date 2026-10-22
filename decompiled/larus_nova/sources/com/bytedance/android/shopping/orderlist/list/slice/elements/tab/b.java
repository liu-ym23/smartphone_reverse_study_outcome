package com.bytedance.android.shopping.orderlist.list.slice.elements.tab;

import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.ui.base.widget.round.RoundView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f180299a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final OrderListTabLayout f180300b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FrameLayout f180301c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CustomHorizontalScrollView f180302d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RoundView f180303e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final View f180304f;

    public static final class a implements CustomHorizontalScrollView.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f180305a;

        @Override // com.bytedance.android.shopping.orderlist.list.slice.elements.tab.CustomHorizontalScrollView.a
        public final void a() {
            if (this.f180305a.f180302d.getScrollX() <= 0) goto L5;
            this.f180305a.f180304f.setVisibility(0);
            return;
        L5:
            this.f180305a.f180304f.setVisibility(8);
        }

        public a(b r100) {
            this.f180305a = r100;
        }
    }

    public final float a(int r100) {
        OrderListTabLayout.a r101 = this.f180300b.e(r100);
        if (r101 != null) goto L6;
        return 0.0f;
    L6:
        if (r101.f180293a.f180331i == false) goto L19;
        float r102 = (r101.f180294b.getLeft() + (r101.f180294b.getWidth() / 2.0f)) - (this.f180303e.getWidth() / 2);
        if (r101.f180293a.f180329g == true) goto L43;
        OrderListTabLayout.a r103 = this.f180300b.getFirstViewInfo();
        if (r103 == null) goto L13;
        OrderListTabItemView r104 = r103.f180294b;
    L14:
        if (r104 == null) goto L16;
        int r105 = r104.getWidth();
    L18:
        return r102 + r105;
    L16:
        r105 = 0;
        goto L18
    L13:
        r104 = null;
        goto L14
    L43:
        return r102;
    L19:
        OrderListTabLayout.a r106 = this.f180300b.getFirstViewInfo();
        if (r106 == null) goto L42;
        OrderListTabItemView r107 = r106.f180294b;
        if (r107 == null) goto L42;
        OrderListTabLayout.a r108 = this.f180300b.getLastViewInfo();
        if (r108 == null) goto L42;
        OrderListTabItemView r109 = r108.f180294b;
        if (r109 == null) goto L42;
        int r110 = r101.f180294b.getLeft() + (r101.f180294b.getWidth() / 2);
        int r111 = this.f180302d.getWidth() / 2;
        if (r110 < 0) goto L34;
        if (r111 < r110) goto L34;
    L41:
        return (r110 + r107.getWidth()) - (this.f180303e.getWidth() / 2);
    L34:
        int r112 = r109.getRight() - r111;
        int r113 = r109.getRight();
        if (r112 > r110) goto L39;
        if (r113 < r110) goto L39;
        r110 = this.f180302d.getWidth() - (r109.getRight() - r110);
    L39:
        r110 = r111;
    L42:
        return 0.0f;
    }

    public b(OrderListTabLayout r100, FrameLayout r101, CustomHorizontalScrollView r102, RoundView r103, View r104) {
        Intrinsics.checkNotNullParameter(r100, "tabLayout");
        Intrinsics.checkNotNullParameter(r101, "firstTabContainer");
        Intrinsics.checkNotNullParameter(r102, "tabScrollContainer");
        Intrinsics.checkNotNullParameter(r103, "indicator");
        Intrinsics.checkNotNullParameter(r104, "shadowView");
        this.f180300b = r100;
        this.f180301c = r101;
        this.f180302d = r102;
        this.f180303e = r103;
        this.f180304f = r104;
        this.f180299a = 200;
        r103.setVisibility(4);
        r104.setVisibility(8);
        r102.setScrollListener(new a(this));
    }
}
