package com.bytedance.android.shopping.orderlist.common.widgets.linkedlist;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.shopping.orderlist.common.utils.OrderCommonLog;
import com.bytedance.android.shopping.orderlist.common.widgets.state.OrderCommonRefreshSloganView;
import com.bytedance.android.shopping.orderlist.common.widgets.yata.OrderCommonYataView;
import com.bytedance.kmp.ec.yata.common.protocol.data.e;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public abstract class BaseLinkedFootHelper implements com.bytedance.android.shopping.orderlist.common.widgets.linkedlist.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f180020a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f180021b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f180022c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final BaseLinkedScrollView f180023d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final jg3.b f180024e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.bytedance.android.shopping.orderlist.common.widgets.yata.a f180025f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final OrderCommonRefreshSloganView f180026g;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseLinkedFootHelper f180027a;

        public b(BaseLinkedFootHelper r100) {
            this.f180027a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            if (this.f180027a.f180023d.b() == false) goto L5;
            this.f180027a.e();
            return;
        L5:
            this.f180027a.b();
        }
    }

    static {
    }

    @Override // com.bytedance.android.shopping.orderlist.common.widgets.linkedlist.a
    public final void b() {
        final String r100 = "BaseLinkedFootHelper-startGULFootRefresh";
        com.bytedance.android.shopping.orderlist.common.widgets.task.c.b(CollectionsKt.listOf(new com.bytedance.android.shopping.orderlist.common.widgets.task.a[]{com.bytedance.android.shopping.orderlist.common.widgets.task.c.a("展示Foot", new BaseLinkedFootHelper$startGULFootRefresh$1(this, r100)), com.bytedance.android.shopping.orderlist.common.widgets.task.c.a("等待GUL加载完成展示GUL", new BaseLinkedFootHelper$startGULFootRefresh$2(this, r100))}));
    }

    public abstract void g(Function0<Unit> r100);

    public abstract void h(e r100);

    public abstract boolean i(Function1<? super e, Unit> r100, Function0<Unit> r101);

    @Override // com.bytedance.android.shopping.orderlist.common.widgets.linkedlist.a
    public final void a() {
        if (this.f180020a == false) goto L9;
        Lazy r100 = OrderCommonLog.f179948a;
        OrderCommonLog.a("BaseLinkedFootHelper", BaseLinkedFootHelper$hideFoot$1.INSTANCE);
        this.f180020a = false;
        ViewGroup.LayoutParams r101 = this.f180026g.getLayoutParams();
        if (r101 == null) goto L7;
        r101.height = 0;
    L7:
        this.f180026g.requestLayout();
        this.f180026g.invalidate();
        return;
    }

    @Override // com.bytedance.android.shopping.orderlist.common.widgets.linkedlist.a
    public final void d() {
        if (this.f180020a == true) goto L9;
        Lazy r100 = OrderCommonLog.f179948a;
        OrderCommonLog.a("BaseLinkedFootHelper", BaseLinkedFootHelper$showFoot$1.INSTANCE);
        this.f180020a = true;
        ViewGroup.LayoutParams r101 = this.f180026g.getLayoutParams();
        if (r101 == null) goto L7;
        r101.height = this.f180022c;
    L7:
        this.f180026g.requestLayout();
        this.f180026g.invalidate();
        return;
    }

    @Override // com.bytedance.android.shopping.orderlist.common.widgets.linkedlist.a
    public final void e() {
        Lazy r100 = OrderCommonLog.f179948a;
        final String r101 = "BaseLinkedFootHelper-startYataFootRefresh";
        OrderCommonLog.a("BaseLinkedFootHelper-startYataFootRefresh", BaseLinkedFootHelper$startYataFootRefresh$1.INSTANCE);
        com.bytedance.android.shopping.orderlist.common.widgets.task.c.b(CollectionsKt.listOf(new com.bytedance.android.shopping.orderlist.common.widgets.task.a[]{com.bytedance.android.shopping.orderlist.common.widgets.task.c.a("展示Foot", new BaseLinkedFootHelper$startYataFootRefresh$2(this, r101)), com.bytedance.android.shopping.orderlist.common.widgets.task.c.a("Yata接口请求", new BaseLinkedFootHelper$startYataFootRefresh$3(this, "BaseLinkedFootHelper-startYataFootRefresh"))}));
    }

    @Override // com.bytedance.android.shopping.orderlist.common.widgets.linkedlist.a
    public final void f() {
        if (this.f180021b != 2) goto L6;
        Lazy r100 = OrderCommonLog.f179948a;
        OrderCommonLog.a("BaseLinkedFootHelper-cancelYataFootRefreshWhenFail", BaseLinkedFootHelper$cancelYataFootRefreshWhenFail$1.INSTANCE);
        return;
    L6:
        Lazy r101 = OrderCommonLog.f179948a;
        OrderCommonLog.a("BaseLinkedFootHelper-cancelYataFootRefreshWhenFail", BaseLinkedFootHelper$cancelYataFootRefreshWhenFail$2.INSTANCE);
        this.f180026g.b("刷新失败，请重试");
        this.f180026g.setOnClickListener(new b(this));
        this.f180021b = 2;
    }

    @Override // com.bytedance.android.shopping.orderlist.common.widgets.linkedlist.a
    public final void c(e r100) {
        Intrinsics.checkNotNullParameter(r100, "downLinkDataResponse");
        if (this.f180021b == 1) goto L6;
        Lazy r101 = OrderCommonLog.f179948a;
        OrderCommonLog.a("BaseLinkedFootHelper-cancelYataFootRefreshWhenSuccess", BaseLinkedFootHelper$cancelYataFootRefreshWhenSuccess$1.INSTANCE);
        return;
    L6:
        Lazy r102 = OrderCommonLog.f179948a;
        OrderCommonLog.a("BaseLinkedFootHelper-cancelYataFootRefreshWhenSuccess", BaseLinkedFootHelper$cancelYataFootRefreshWhenSuccess$2.INSTANCE);
        g(new BaseLinkedFootHelper$cancelYataFootRefreshWhenSuccess$3(this));
        h(r100);
    }

    public BaseLinkedFootHelper(Context r100, BaseLinkedScrollView r101, jg3.b r102, OrderCommonYataView r103, OrderCommonRefreshSloganView r104) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r102, "gulContainer");
        Intrinsics.checkNotNullParameter(r103, "yataContainer");
        Intrinsics.checkNotNullParameter(r104, "footContainer");
        this.f180023d = r101;
        this.f180024e = r102;
        this.f180025f = r103;
        this.f180026g = r104;
        this.f180022c = com.bytedance.android.shopping.extensions.b.b(60);
    }
}
