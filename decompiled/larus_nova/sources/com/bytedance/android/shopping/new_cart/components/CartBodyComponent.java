package com.bytedance.android.shopping.new_cart.components;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.shopping.new_cart.container.CartObjectContainer;
import com.bytedance.android.shopping.new_cart.container.NewCartActivity;
import com.bytedance.android.shopping.new_cart.eventcenter.event.ScrollMode;
import com.bytedance.android.shopping.new_cart.widgets.CartGULView;
import com.bytedance.android.shopping.new_cart.widgets.CartRefreshHeadView;
import com.bytedance.android.shopping.new_cart.widgets.LoadMoreFooterView;
import com.bytedance.android.shopping.new_cart.widgets.nest.CartLinkedScrollViewV2;
import com.bytedance.android.shopping.new_cart.widgets.nest.CartSwipeNestRefreshLayoutV2;
import com.bytedance.android.shopping.utils.t;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class CartBodyComponent extends com.bytedance.android.shopping.new_cart.components.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CartLinkedScrollViewV2 f178693b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<t> f178694c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CartSwipeNestRefreshLayoutV2 f178695d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CartObjectContainer f178696e;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CartBodyComponent f178697a;

        public a(CartBodyComponent r100) {
            this.f178697a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            CartLinkedScrollViewV2 r100 = this.f178697a.f178693b;     // Catch: Throwable -> L8
            if (r100 == null) goto L11;
            CartGULView r101 = r100.getGul();     // Catch: Throwable -> L8
            if (r101 == null) goto L15;
            r101.h(false);     // Catch: Throwable -> L8
            return;
        L15:
            return;
        L11:
            return;
        L8:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L16;
            throw th;
        }
    }

    @Override // com.bytedance.android.shopping.new_cart.components.a
    public final void h() {
        CartLinkedScrollViewV2 r100 = this.f178693b;
        if (r100 == null) goto L6;
        r100.setCartObjectContainer(this.f178696e);
        return;
    }

    @Override // com.bytedance.android.shopping.new_cart.components.a
    public final void i() {
        CartLinkedScrollViewV2 r100 = this.f178693b;
        if (r100 == null) goto L10;
        CartGULView r101 = r100.getGul();
        if (r101 == null) goto L11;
        ti.l r102 = r101.f179430g;
        if (r102 == null) goto L12;
        r102.release();
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // com.bytedance.android.shopping.new_cart.components.a
    public final void j() {
        bg3.a r100 = com.bytedance.android.shopping.new_cart.utils.a.f179357a;
        com.bytedance.android.shopping.new_cart.utils.a.c(this.f178820a.f178934d, "onPause", new a(this), null);
    }

    @Override // com.bytedance.android.shopping.new_cart.components.a
    public final void k() {
        CartLinkedScrollViewV2 r100 = this.f178693b;
        if (r100 == null) goto L8;
        CartGULView r101 = r100.getGul();
        if (r101 == null) goto L9;
        r101.h(true);
        return;
    L9:
        return;
    }

    public final void n() {
        CartSwipeNestRefreshLayoutV2 r100 = this.f178695d;
        if (r100 == null) goto L11;
        r100.f179532h = false;
        CartLinkedScrollViewV2 r101 = r100.f179529e;
        if (r101 == null) goto L7;
        int r102 = (int) r101.getTranslationY();
    L8:
        if (r102 <= 0) goto L12;
        r100.f(false);
        return;
    L12:
        return;
    L7:
        r102 = 0;
        goto L8
    }

    public final LoadMoreFooterView o() {
        CartLinkedScrollViewV2 r100 = this.f178693b;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getLoadingFooter();
    }

    public final CartLinkedScrollViewV2 p() {
        CartLinkedScrollViewV2 r100 = this.f178693b;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.new_cart.widgets.ICartLinkedScrollViewBase");
    }

    public final RecyclerView q() {
        CartLinkedScrollViewV2 r100 = this.f178693b;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getYataBody();
    }

    public final void s() {
        CartLinkedScrollViewV2 r100 = this.f178693b;
        if (r100 == null) goto L12;
        r100.f179502p.stopScroll();
        RecyclerView r101 = r100.f179503q.getGULRecyclerView();
        if (r101 == null) goto L7;
        r101.stopScroll();
    L7:
        r100.scrollTo(0, 0);
        RecyclerView r102 = r100.f179503q.getGULRecyclerView();
        if (r102 == null) goto L10;
        r102.scrollToPosition(0);
    L10:
        r100.f179502p.scrollToPosition(0);
        r100.f179502p.post(new com.bytedance.android.shopping.new_cart.widgets.nest.d(r100));
        return;
    }

    public CartBodyComponent(CartObjectContainer r100) {
        Intrinsics.checkNotNullParameter(r100, "objectContainer");
        super(r100);
        this.f178696e = r100;
        NewCartActivity r101 = c();
        CartSwipeNestRefreshLayoutV2 r102 = null;
        if (r101 == null) goto L6;
        CartLinkedScrollViewV2 r103 = (CartLinkedScrollViewV2) r101.findViewById(R.id.linked_scroll_view_v2);
        if (r103 == null) goto L6;
    L12:
        this.f178693b = r103;
        this.f178694c = new ArrayList();
        NewCartActivity r104 = c();
        if (r104 == null) goto L16;
        CartSwipeNestRefreshLayoutV2 r105 = (CartSwipeNestRefreshLayoutV2) r104.findViewById(R.id.cart_refresh_layout);
        if (r105 == null) goto L16;
    L22:
        if (r105 == null) goto L24;
        r105.setHeaderView((CartRefreshHeadView) r105.findViewById(R.id.pull_refresh_header));
        r105.setBodyView(r103);
        r105.setOnRefreshListener(new CartBodyComponent$$special$$inlined$apply$lambda$1(this));
        Unit r106 = Unit.INSTANCE;
        r102 = r105;
    L24:
        this.f178695d = r102;
        return;
    L16:
        Fragment r107 = this.f178820a.f178936f;
        if (r107 == null) goto L21;
        View r108 = r107.getView();
        if (r108 == null) goto L21;
        r105 = (CartSwipeNestRefreshLayoutV2) r108.findViewById(R.id.cart_refresh_layout);
    L21:
        r105 = null;
    L6:
        Fragment r109 = this.f178820a.f178936f;
        if (r109 == null) goto L11;
        View r110 = r109.getView();
        if (r110 == null) goto L11;
        r103 = (CartLinkedScrollViewV2) r110.findViewById(R.id.linked_scroll_view_v2);
    L11:
        r103 = null;
        goto L12
    }

    public final void r(int r100, ScrollMode r101) {
        Intrinsics.checkNotNullParameter(r101, "scrollMode");
        CartLinkedScrollViewV2 r102 = this.f178693b;
        if (r102 == null) goto L27;
        Intrinsics.checkNotNullParameter(r101, "scrollMode");
        r102.c();
        int r103 = com.bytedance.android.shopping.new_cart.widgets.nest.b.f179562a[r101.ordinal()];
        RecyclerView.LayoutManager r104 = null;
        if (r103 != 1) goto L7;
        RecyclerView.LayoutManager r105 = r102.f179502p.getLayoutManager();
        if ((r105 instanceof LinearLayoutManager) == false) goto L23;
        r104 = r105;
    L23:
        LinearLayoutManager r106 = (LinearLayoutManager) r104;
        if (r106 == null) goto L31;
        r106.scrollToPositionWithOffset(r100, 10);
        return;
    L31:
        return;
    L7:
        if (r103 != 2) goto L9;
        RecyclerView.LayoutManager r107 = r102.f179502p.getLayoutManager();
        if ((r107 instanceof LinearLayoutManager) == false) goto L16;
        r104 = r107;
    L16:
        LinearLayoutManager r108 = (LinearLayoutManager) r104;
        if (r108 == null) goto L29;
        r108.scrollToPositionWithOffset(r100, 300);
        return;
    L29:
        return;
    L9:
        if (r103 != 3) goto L32;
        r102.f179502p.scrollToPosition(r100);
        return;
    L32:
        return;
    }
}
