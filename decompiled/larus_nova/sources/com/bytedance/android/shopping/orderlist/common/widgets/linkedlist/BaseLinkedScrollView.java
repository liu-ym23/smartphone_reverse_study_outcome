package com.bytedance.android.shopping.orderlist.common.widgets.linkedlist;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.shopping.orderlist.common.monitor.error.OrderCommonErrorMonitorKt;
import com.bytedance.android.shopping.orderlist.common.utils.OrderCommonLog;
import com.bytedance.android.shopping.orderlist.common.widgets.state.OrderCommonRefreshSloganView;
import com.bytedance.android.shopping.orderlist.common.widgets.touch.TouchHelper;
import com.bytedance.android.shopping.orderlist.common.widgets.yata.OrderCommonYataView;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0014\u0010\u0007\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\u0006\u0010\t\u001a\u00020\bR\u001b\u0010\u000f\u001a\u00020\n8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0014\u001a\u00020\u00108FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/shopping/orderlist/common/widgets/linkedlist/BaseLinkedScrollView;", "Landroid/widget/FrameLayout;", "Landroidx/recyclerview/widget/RecyclerView;", "getYataRecyclerView", "Lkotlin/Function0;", "", "action", "setErrorRetryListener", "Lcom/bytedance/android/shopping/orderlist/common/widgets/linkedlist/b;", "getVerticalOffset", "Ljg3/b;", "b", "Lkotlin/Lazy;", "getGulContainer", "()Ljg3/b;", "gulContainer", "Lcom/bytedance/android/shopping/orderlist/common/widgets/linkedlist/a;", "e", "getFootRefreshHelper", "()Lcom/bytedance/android/shopping/orderlist/common/widgets/linkedlist/a;", "footRefreshHelper", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attributeSet", "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class BaseLinkedScrollView extends FrameLayout {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f180028l = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OrderCommonYataView f180029a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f180030b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f180031c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final OrderCommonRefreshSloganView f180032d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f180033e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TouchHelper f180034f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final LinkedScrollFlingHelper f180035g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f180036h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f180037i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ConcurrentHashMap<String, c> f180038j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final a f180039k;

    public static final class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseLinkedScrollView f180040a;

        @Override // com.bytedance.android.shopping.orderlist.common.widgets.linkedlist.c
        public final void a() {
            Iterator<Map.Entry<String, c>> r100 = this.f180040a.f180038j.entrySet().iterator();
        L4:
            if (r100.hasNext() == false) goto L6;
            r100.next().getValue().a();
            goto L4
        }

        public a(BaseLinkedScrollView r100) {
            this.f180040a = r100;
        }

        @Override // com.bytedance.android.shopping.orderlist.common.widgets.linkedlist.c
        public final void c(float r100) {
            Iterator<Map.Entry<String, c>> r101 = this.f180040a.f180038j.entrySet().iterator();
        L4:
            if (r101.hasNext() == false) goto L6;
            r101.next().getValue().c(r100);
            goto L4
        }

        @Override // com.bytedance.android.shopping.orderlist.common.widgets.linkedlist.c
        public final void onScrollStateChanged(int r100) {
            BaseLinkedScrollView r101 = this.f180040a;
            if (r101.f180037i != r100) goto L5;
            return;
        L5:
            r101.f180037i = r100;
            Iterator<Map.Entry<String, c>> r102 = r101.f180038j.entrySet().iterator();
        L7:
            if (r102.hasNext() == false) goto L9;
            r102.next().getValue().onScrollStateChanged(r100);
            goto L7
        }

        @Override // com.bytedance.android.shopping.orderlist.common.widgets.linkedlist.c
        public final void b(int r100, b r101) {
            Intrinsics.checkNotNullParameter(r101, "verticalOffsetInfo");
            Iterator<Map.Entry<String, c>> r102 = this.f180040a.f180038j.entrySet().iterator();
        L4:
            if (r102.hasNext() == false) goto L6;
            r102.next().getValue().b(r100, r101);
            goto L4
        }
    }

    public BaseLinkedScrollView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public BaseLinkedScrollView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public abstract com.bytedance.android.shopping.orderlist.common.widgets.linkedlist.a c(jg3.b r100, OrderCommonYataView r101, OrderCommonRefreshSloganView r102);

    public abstract jg3.b d();

    public final com.bytedance.android.shopping.orderlist.common.widgets.linkedlist.a getFootRefreshHelper() {
        return (com.bytedance.android.shopping.orderlist.common.widgets.linkedlist.a) this.f180033e.getValue();
    }

    public final jg3.b getGulContainer() {
        return (jg3.b) this.f180030b.getValue();
    }

    public abstract boolean l();

    public final boolean b() {
        if (this.f180029a.f180091c == false) goto L6;
        return false;
    L6:
        return l();
    }

    @Override // android.view.View
    public final void computeScroll() {
        LinkedScrollFlingHelper r100 = this.f180035g;
        r100.getClass();
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L9
        if (r100.f180041a.computeScrollOffset() == false) goto L6;
        int r102 = r100.f180041a.getCurrY();     // Catch: Throwable -> L9
        int r103 = r102 - r100.f180043c;     // Catch: Throwable -> L9
        r100.f180045e.invoke(Integer.valueOf(r103));     // Catch: Throwable -> L9
        r100.f180043c = r102;     // Catch: Throwable -> L9
        r100.f180044d.invalidate();     // Catch: Throwable -> L9
    L7:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L9
        return;
    L6:
        r100.f180046f.invoke();     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    public final b getVerticalOffset() {
        return new b(this.f180029a.getYataRecyclerView().computeVerticalScrollOffset(), getGulContainer().getGULVerticalOffset(), getScrollY());
    }

    public final RecyclerView getYataRecyclerView() {
        return this.f180029a.getYataRecyclerView();
    }

    public final void n() {
        this.f180035g.a();
        setScrollY(0);
        this.f180029a.d();
        getGulContainer().t0();
        this.f180039k.a();
    }

    public static void j(final String r100) {
        Lazy r101 = OrderCommonLog.f179948a;
        OrderCommonLog.a("BaseLinkedScrollView", new BaseLinkedScrollView$logDispatchScrollY$1(r100));
    }

    @Override // android.view.View
    public final boolean canScrollVertically(int r100) {
        if (r100 <= 0) goto L8;
        if (getScrollY() < this.f180036h) goto L12;
    L10:
        return false;
    L12:
        return true;
    L8:
        if (getScrollY() <= 0) goto L10;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(final MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Lazy r101 = OrderCommonLog.f179948a;
        OrderCommonLog.a("BaseLinkedScrollView", new AnonymousClass1(r100));
        this.f180034f.a(r100, null);
        LinkedScrollFlingHelper r102 = this.f180035g;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "event");
        OrderCommonLog.a("LinkedScrollFlingHelper", new LinkedScrollFlingHelper$dispatchTouchEvent$1(r100));
        if (r100.getAction() != 0) goto L5;
    L6:
        r102.a();
        r102.f180042b.clear();
    L7:
        TouchHelper.TouchIntent r103 = this.f180034f.f180076c;
        if (r103 != TouchHelper.TouchIntent.V_MOVING_UP) goto L10;
        boolean r104 = true;
    L11:
        if (r104 == false) goto L13;
    L17:
        OrderCommonLog.a("BaseLinkedScrollView", AnonymousClass2.INSTANCE);
        if (canScrollVertically(-1) == false) goto L20;
    L25:
        boolean r105 = true;
    L26:
        if (r105 == false) goto L28;
        getParent().requestDisallowInterceptTouchEvent(true);
    L29:
        final boolean r106 = super.dispatchTouchEvent(r100);
        OrderCommonLog.a("BaseLinkedScrollView", new AnonymousClass3(r100, r106));
        return r106;
    L28:
        getParent().requestDisallowInterceptTouchEvent(false);
        goto L29
    L20:
        if (this.f180029a.a() == true) goto L25;
        if (getGulContainer().a() == true) goto L25;
        r105 = false;
        goto L26
    L13:
        if (r103 != TouchHelper.TouchIntent.V_MOVING_DOWN) goto L15;
        boolean r107 = true;
    L16:
        if (r107 == false) goto L29;
    L15:
        r107 = false;
        goto L16
    L10:
        r104 = false;
        goto L11
    L5:
        if (r100.getAction() != 3) goto L7;
        goto L6
    }

    public final void e(int r110) {
        if (r110 != 0) goto L4;
        return;
    L4:
        this.f180039k.b(r110, getVerticalOffset());
        if (r110 <= 0) goto L52;
        boolean r100 = i(this.f180029a);
        boolean r101 = i(getGulContainer());
        boolean r102 = i(this.f180032d);
        boolean r103 = h(this.f180032d);
        if (r100 == true) goto L9;
    L11:
        if (r100 == true) goto L13;
    L17:
        if (r100 == true) goto L19;
    L25:
        if (r100 == true) goto L27;
    L33:
        if (r102 == true) goto L35;
        if (r103 == false) goto L42;
        if (r102 == true) goto L42;
        j("[Foot部分展示]->[容器消费滑动]  " + r110);
        scrollBy(0, r110);
        this.f180039k.onScrollStateChanged(3);
        return;
    L42:
        if (r101 == false) goto L47;
        if (getGulContainer().c() == false) goto L47;
        j("[GUL完全展示 && GUL可以上滑]->[GUL消费滑动]  " + r110);
        getGulContainer().scrollBy(0, r110);
        this.f180039k.onScrollStateChanged(2);
        return;
    L47:
        if (canScrollVertically(r110) == false) goto L50;
        j("[兜底逻辑，容器可以滑动]->[容器消费滑动]  " + r110);
        scrollBy(0, r110);
        this.f180039k.onScrollStateChanged(3);
        return;
    L50:
        if (canScrollVertically(r110) == true) goto L76;
        j("[兜底逻辑，容器不能滑动]->[无消费]  " + r110);
        this.f180035g.a();
        this.f180039k.onScrollStateChanged(0);
        return;
    L76:
        return;
    L35:
        if (b() == false) goto L37;
        j("[Foot完全展示到底 && Yata需要加载更多]->[启动yataFootRefresh，Foot到底部无消费]  " + r110);
        getFootRefreshHelper().e();
        this.f180035g.a();
    L38:
        this.f180039k.onScrollStateChanged(0);
        return;
    L37:
        j("[Foot完全展示到底 && Yata不需要加载更多]->[兜底启动gulFootRefresh，Foot到底部无消费]  " + r110);
        getFootRefreshHelper().b();
        this.f180035g.a();
        goto L38
    L27:
        if (this.f180029a.b() == true) goto L33;
        if (b() == true) goto L33;
        if (getGulContainer().b() == false) goto L33;
        j("[Yata完全展示 && Yata不可以上滑 && Yata不需要加载更多 && GUL加载完成]->[隐藏Foot，展示GUL，容器消费滑动]  " + r110);
        getFootRefreshHelper().a();
        getGulContainer().show();
        scrollBy(0, r110);
        this.f180039k.onScrollStateChanged(3);
        return;
    L19:
        if (this.f180029a.b() == true) goto L25;
        if (b() == true) goto L25;
        if (getGulContainer().isLoading() == false) goto L25;
        j("[Yata完全展示 && Yata不可以上滑 && Yata不需要加载更多 && GUL正在加载]->[显示Foot,容器消费滑动]  " + r110);
        getFootRefreshHelper().d();
        scrollBy(0, r110);
        getGulContainer().f(new BaseLinkedScrollView$dispatchMovingUp$1(this));
        this.f180039k.onScrollStateChanged(3);
        return;
    L13:
        if (this.f180029a.b() == true) goto L17;
        if (b() == false) goto L17;
        j("[Yata完全展示 && Yata不可以上滑  && Yata需要加载更多]->[启动YataFootRefresh, 容器消费滑动]  " + r110);
        getFootRefreshHelper().e();
        scrollBy(0, r110);
        this.f180039k.onScrollStateChanged(3);
        return;
    L9:
        if (this.f180029a.b() == false) goto L11;
        j("[Yata完全展示 && Yata可以上滑]->Yata消费上滑 " + r110);
        this.f180029a.scrollBy(0, r110);
        this.f180039k.onScrollStateChanged(1);
        return;
    L52:
        boolean r104 = i(this.f180029a);
        if (i(getGulContainer()) == true) goto L55;
    L57:
        if (r104 == false) goto L62;
        if (this.f180029a.a() == false) goto L62;
        j("[Yata完全展示 && Yata可以下滑]->[Yata消费滑动]  " + r110);
        this.f180029a.scrollBy(0, r110);
        this.f180039k.onScrollStateChanged(1);
        return;
    L62:
        if (canScrollVertically(r110) == false) goto L65;
        j("[兜底逻辑，容器可以下滑]->[容器消费滑动]  " + r110);
        scrollBy(0, r110);
        this.f180039k.onScrollStateChanged(3);
        return;
    L65:
        if (canScrollVertically(r110) == true) goto L81;
        j("[兜底逻辑，容器不能滑动]->[无消费]  " + r110);
        this.f180035g.a();
        this.f180039k.onScrollStateChanged(0);
        return;
    L81:
        return;
    L55:
        if (getGulContainer().a() == false) goto L57;
        j("[GUL完全展示 && GUL可以下滑]->[GUL消费滑动]  " + r110);
        getGulContainer().scrollBy(0, r110);
        this.f180039k.onScrollStateChanged(2);
    }

    public final void f(final boolean r100) {
        OrderCommonErrorMonitorKt.c(null, "BaseLinkedScrollView-handleYataExpandErrorCase", new BaseLinkedScrollView$handleYataExpandErrorCase$1(this, r100));
    }

    public final void g(String r100) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Lazy r101 = OrderCommonLog.f179948a;
        OrderCommonLog.c(r100, BaseLinkedScrollView$hideGUL$1.INSTANCE);
        getGulContainer().e(r100);
    }

    public final boolean h(OrderCommonRefreshSloganView r100) {
        if (r100.getMeasuredHeight() != 0) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(r100, this.f180032d) == false) goto L12;
        if (getScrollY() <= 0) goto L13;
        return true;
    L13:
        return false;
    L12:
        throw new Exception("view must in (footContainer)");
    }

    public final boolean i(Object r100) {
        if ((r100 instanceof View) == true) goto L5;
        return false;
    L5:
        View r101 = (View) r100;
        if (r101.getMeasuredHeight() != 0) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(r100, this.f180029a) == true) goto L26;
        if (Intrinsics.areEqual(r100, getGulContainer()) == true) goto L26;
        if (Intrinsics.areEqual(r100, this.f180032d) == false) goto L24;
        if (getScrollY() < this.f180032d.getMeasuredHeight()) goto L18;
    L21:
        return true;
    L18:
        if (r101.getTop() >= getTop()) goto L20;
        return false;
    L20:
        if (r101.getBottom() <= getBottom()) goto L21;
        return false;
    L24:
        throw new Exception("view must in (yataContainer or footContainer or gulContainer)");
    L26:
        if (r101.getTop() != getScrollY()) goto L31;
        return true;
    L31:
        return false;
    }

    public final void m(float r100) {
        this.f180035g.a();
        setScrollY(0);
        this.f180029a.c();
        e((int) (getHeight() * r100));
        this.f180039k.c(r100);
    }

    public final void o(String r100) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Lazy r101 = OrderCommonLog.f179948a;
        OrderCommonLog.c(r100, BaseLinkedScrollView$showGUL$1.INSTANCE);
        getGulContainer().show();
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
        TouchHelper.TouchIntent r101 = this.f180034f.f180076c;
        final boolean r102 = true;
        final boolean r103 = false;
        if (r101 != TouchHelper.TouchIntent.DOWN_STATE) goto L5;
        boolean r104 = true;
    L7:
        if (r104 == false) goto L14;
        Lazy r105 = OrderCommonLog.f179948a;
        final String r106 = "手指按下";
        OrderCommonLog.a("BaseLinkedScrollView", new BaseLinkedScrollView$logOnInterceptTouchEvent$1(r103, r106));
        if (this.f180037i != 0) goto L31;
        return false;
    L31:
        return true;
    L14:
        if (r101 != TouchHelper.TouchIntent.V_MOVING_DOWN) goto L16;
        boolean r107 = true;
    L17:
        if (r107 == false) goto L19;
    L29:
        Lazy r108 = OrderCommonLog.f179948a;
        final String r109 = "上下滑动中";
        OrderCommonLog.a("BaseLinkedScrollView", new BaseLinkedScrollView$logOnInterceptTouchEvent$1(r102, r109));
        return true;
    L19:
        if (r101 != TouchHelper.TouchIntent.V_MOVING_UP) goto L21;
        r103 = true;
    L21:
        if (r103 == true) goto L29;
        final boolean r110 = super.onInterceptTouchEvent(r100);
        if (r100.getAction() != 1) goto L26;
        final String r111 = "手指抬起";
    L27:
        Lazy r112 = OrderCommonLog.f179948a;
        OrderCommonLog.a("BaseLinkedScrollView", new BaseLinkedScrollView$logOnInterceptTouchEvent$1(r110, r111));
        return r110;
    L26:
        r111 = "其他事件";
        goto L27
    L16:
        r107 = false;
        goto L17
    L5:
        r104 = false;
        goto L7
    }

    @Override // android.view.View
    public final boolean onTouchEvent(final MotionEvent r110) {
        Intrinsics.checkNotNullParameter(r110, "e");
        LinkedScrollFlingHelper r100 = this.f180035g;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r110, "e");
        Lazy r101 = OrderCommonLog.f179948a;
        OrderCommonLog.a("LinkedScrollFlingHelper", new LinkedScrollFlingHelper$handleOnTouchEventActionUpToFling$1(r110));
        int r102 = r110.getAction();
        boolean r103 = false;
        if (r102 == 0) goto L9;
        if (r102 == 1) goto L8;
        if (r102 != 2) goto L11;
        r100.f180042b.addMovement(r110);
    L11:
        if (r110.getAction() != 0) goto L15;
        k(true, "手指按下");
        return true;
    L15:
        if (r110.getAction() != 2) goto L31;
        TouchHelper r104 = this.f180034f;
        TouchHelper.TouchIntent r105 = r104.f180076c;
        if (r105 != TouchHelper.TouchIntent.V_MOVING_UP) goto L19;
        boolean r106 = true;
    L20:
        if (r106 == false) goto L23;
        com.bytedance.android.shopping.orderlist.common.widgets.touch.c r107 = r104.f180075b;
        float r108 = Math.abs(r107.f180085b - r107.f180087d);
    L28:
        e((int) r108);
        k(true, "移动分发");
        return true;
    L23:
        if (r105 != TouchHelper.TouchIntent.V_MOVING_DOWN) goto L25;
        r103 = true;
    L25:
        if (r103 == false) goto L27;
        com.bytedance.android.shopping.orderlist.common.widgets.touch.c r109 = r104.f180075b;
        r108 = -Math.abs(r109.f180085b - r109.f180087d);
        goto L28
    L27:
        r108 = 0.0f;
        goto L28
    L19:
        r106 = false;
        goto L20
    L31:
        if (r110.getAction() != 1) goto L34;
        k(true, "手指抬起");
        return true;
    L34:
        boolean r111 = super.onTouchEvent(r110);
        k(r111, "其他 " + r110.getAction());
        return r111;
    L8:
        r100.f180042b.addMovement(r110);
        r100.f180042b.computeCurrentVelocity(1000);
        int r112 = -((int) r100.f180042b.getYVelocity());
        OrderCommonLog.a("LinkedScrollFlingHelper", LinkedScrollFlingHelper$startFling$1.INSTANCE);
        r100.f180043c = 0;
        r100.f180041a.fling(0, 0, 0, r112, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        r100.f180044d.invalidate();
        OrderCommonLog.a("LinkedScrollFlingHelper", LinkedScrollFlingHelper$handleOnTouchEventActionUpToFling$2.INSTANCE);
        goto L11
    L9:
        r100.a();
        r100.f180042b.clear();
        r100.f180042b.addMovement(r110);
        goto L11
    }

    public final void p(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "disposableCallback");
        getGulContainer().d(r100);
    }

    public final void setErrorRetryListener(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        this.f180029a.setErrorRetryListener(r100);
    }

    public static void k(final boolean r100, final String r101) {
        Lazy r102 = OrderCommonLog.f179948a;
        OrderCommonLog.a("BaseLinkedScrollView", new BaseLinkedScrollView$logOnTouchEvent$1(r100, r101));
    }

    public final void a(String r100, c r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "scrollListener");
        this.f180038j.put(r100, r101);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(final int r100, final int r101) {
        super.onMeasure(r100, r101);
        measureChildren(r100, r101);
        getGulContainer().setGULHeight(getMeasuredHeight());
        Lazy r102 = OrderCommonLog.f179948a;
        OrderCommonLog.a("BaseLinkedScrollView", new C103571(r100, r101));
    }

    @Override // android.view.View
    public final void scrollTo(int r100, int r101) {
        if (r101 >= 0) goto L4;
        r101 = 0;
    L7:
        super.scrollTo(r100, r101);
        return;
    L4:
        int r102 = this.f180036h;
        if (r101 <= r102) goto L7;
        r101 = r102;
        goto L7
    }

    public BaseLinkedScrollView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        OrderCommonYataView r103 = new OrderCommonYataView(r100, null, 0);
        this.f180029a = r103;
        this.f180030b = LazyKt.lazy(new BaseLinkedScrollView$gulContainer$2(this));
        int r104 = 6;
        OrderCommonRefreshSloganView r105 = new OrderCommonRefreshSloganView(r100, null, r104, 0);
        this.f180032d = r105;
        this.f180033e = LazyKt.lazy(new BaseLinkedScrollView$footRefreshHelper$2(this));
        this.f180034f = new TouchHelper(r100);
        this.f180035g = new LinkedScrollFlingHelper(r100, this, new BaseLinkedScrollView$flingHelper$1(this), new BaseLinkedScrollView$flingHelper$2(this));
        this.f180038j = new ConcurrentHashMap();
        this.f180039k = new a(this);
        addView(r103, new FrameLayout.LayoutParams(-1, -2));
        addView(r105, new FrameLayout.LayoutParams(-1, 0));
        Object r106 = getGulContainer();
        if (r106 == null) goto L7;
        addView((View) r106, new FrameLayout.LayoutParams(-1, -2));
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.view.View");
    }

    public /* synthetic */ BaseLinkedScrollView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        OrderCommonYataView r105 = this.f180029a;
        if (r105 == null) goto L7;
        final int r106 = r105.getMeasuredHeight();
        final int r107 = this.f180032d.getMeasuredHeight();
        final int r108 = getGulContainer().getView().getMeasuredHeight();
        this.f180029a.layout(r101, 0, r103, r106);
        int r109 = r106 + r107;
        this.f180032d.layout(r101, r106, r103, r109);
        getGulContainer().getView().layout(r101, r109, r103, r109 + r108);
        this.f180036h = Math.max(0, ((r106 + r108) + r107) - getHeight());
        Lazy r110 = OrderCommonLog.f179948a;
        OrderCommonLog.a("BaseLinkedScrollView", new C103561(this, r106, r107, r108));
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.view.View");
    }
}
