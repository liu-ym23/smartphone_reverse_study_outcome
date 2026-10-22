package com.bytedance.android.shopping.orderlist.list.widget.headrefresh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import c53.d;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.orderlist.common.utils.OrderCommonLog;
import com.bytedance.android.shopping.orderlist.common.widgets.state.OrderCommonRefreshSloganView;
import com.bytedance.android.shopping.orderlist.common.widgets.touch.TouchHelper;
import com.bytedance.android.shopping.orderlist.common.widgets.touch.c;
import com.bytedance.android.shopping.orderlist.list.widget.linkedlist.OrderListLinkedScrollView;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.Disposable;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0013B'\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012R$\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/shopping/orderlist/list/widget/headrefresh/OrderListHeadRefreshLayout;", "Landroid/view/ViewGroup;", "Lc53/d;", "Lcom/bytedance/android/shopping/orderlist/list/widget/headrefresh/a;", "d", "Lcom/bytedance/android/shopping/orderlist/list/widget/headrefresh/a;", "getHeadRefreshHelper", "()Lcom/bytedance/android/shopping/orderlist/list/widget/headrefresh/a;", "setHeadRefreshHelper", "(Lcom/bytedance/android/shopping/orderlist/list/widget/headrefresh/a;)V", "headRefreshHelper", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attributeSet", "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "MoveState", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OrderListHeadRefreshLayout extends ViewGroup implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public OrderCommonRefreshSloganView f180461a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public OrderListLinkedScrollView f180462b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TouchHelper f180463c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.bytedance.android.shopping.orderlist.list.widget.headrefresh.a f180464d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f180465e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public MoveState f180466f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ c53.b f180467g;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/shopping/orderlist/list/widget/headrefresh/OrderListHeadRefreshLayout$MoveState;", "", "IDLE", "DOWN", "V_MOVING_HEAD", "V_MOVING_CONTENT", "V_MOVING_HEAD_UP_OR_CANCEL", "V_MOVING_CONTENT_UP_OR_CANCEL", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum MoveState extends Enum<MoveState> {
        public static final MoveState DOWN = null;
        public static final MoveState IDLE = null;
        public static final MoveState V_MOVING_CONTENT = null;
        public static final MoveState V_MOVING_CONTENT_UP_OR_CANCEL = null;
        public static final MoveState V_MOVING_HEAD = null;
        public static final MoveState V_MOVING_HEAD_UP_OR_CANCEL = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ MoveState[] f180468a = null;

        static {
            MoveState r100 = new MoveState("IDLE", 0);
            IDLE = r100;
            MoveState r101 = new MoveState("DOWN", 1);
            DOWN = r101;
            MoveState r102 = new MoveState("V_MOVING_HEAD", 2);
            V_MOVING_HEAD = r102;
            MoveState r103 = new MoveState("V_MOVING_CONTENT", 3);
            V_MOVING_CONTENT = r103;
            MoveState r104 = new MoveState("V_MOVING_HEAD_UP_OR_CANCEL", 4);
            V_MOVING_HEAD_UP_OR_CANCEL = r104;
            MoveState r105 = new MoveState("V_MOVING_CONTENT_UP_OR_CANCEL", 5);
            V_MOVING_CONTENT_UP_OR_CANCEL = r105;
            f180468a = new MoveState[]{r100, r101, r102, r103, r104, r105};
        }

        public static MoveState valueOf(String r100) {
            return (MoveState) r27.a.a(MoveState.class, r100);
        }

        public static MoveState[] values() {
            return (MoveState[]) f180468a.clone();
        }

        public MoveState(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a implements com.bytedance.android.shopping.orderlist.common.widgets.touch.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OrderListHeadRefreshLayout f180469a;

        @Override // com.bytedance.android.shopping.orderlist.common.widgets.touch.b
        public final void onCancel() {
        }

        @Override // com.bytedance.android.shopping.orderlist.common.widgets.touch.b
        public final void onClick() {
        }

        @Override // com.bytedance.android.shopping.orderlist.common.widgets.touch.b
        public final void c() {
            OrderListHeadRefreshLayout r100 = this.f180469a;
            r100.f180466f = MoveState.DOWN;
            OrderListHeadRefreshLayout.a(r100, "[onDownState]->[下发事件]->[手指处于按下状态]");
        }

        public a(OrderListHeadRefreshLayout r100) {
            this.f180469a = r100;
        }

        @Override // com.bytedance.android.shopping.orderlist.common.widgets.touch.b
        public final void a(com.bytedance.android.shopping.orderlist.common.widgets.touch.a r100, c r101) {
            Intrinsics.checkNotNullParameter(r100, "downToMoveInfo");
            Intrinsics.checkNotNullParameter(r101, "moveToMoveInfo");
            com.bytedance.android.shopping.orderlist.list.widget.headrefresh.a r102 = this.f180469a.getHeadRefreshHelper();
            if (r102 != null) goto L5;
        L7:
            OrderListLinkedScrollView r103 = this.f180469a.f180462b;
            if (r103 != null) goto L10;
        L16:
            OrderListHeadRefreshLayout r104 = this.f180469a;
            r104.f180466f = MoveState.V_MOVING_CONTENT;
            OrderListHeadRefreshLayout.a(r104, "[下滑]->[下发事件]->[其他情况]->[内容下滑]");
            return;
        L10:
            if (r103.i(r103.f180029a) != true) goto L16;
            OrderListLinkedScrollView r105 = this.f180469a.f180462b;
            if (r105 == null) goto L16;
            if (r105.f180029a.a() == true) goto L16;
            OrderListHeadRefreshLayout r106 = this.f180469a;
            r106.f180466f = MoveState.V_MOVING_HEAD;
            OrderListHeadRefreshLayout.a(r106, "[下滑]->[不下发事件]->[当前Yata完全展示 && Yata无法下滑]->[响应Head下拉]");
            return;
        L5:
            if (r102.g() != true) goto L7;
            OrderListHeadRefreshLayout r107 = this.f180469a;
            r107.f180466f = MoveState.V_MOVING_HEAD;
            OrderListHeadRefreshLayout.a(r107, "[下滑]->[不下发事件]->[Head正在展示]->[当前处于Head下拉状态，需要持续响应Move事件，同时需要计算Head的动画效果]");
        }

        @Override // com.bytedance.android.shopping.orderlist.common.widgets.touch.b
        public final void b(com.bytedance.android.shopping.orderlist.common.widgets.touch.a r100, c r101) {
            Intrinsics.checkNotNullParameter(r100, "downToMoveInfo");
            Intrinsics.checkNotNullParameter(r101, "moveToMoveInfo");
            com.bytedance.android.shopping.orderlist.list.widget.headrefresh.a r102 = this.f180469a.getHeadRefreshHelper();
            if (r102 != null) goto L5;
        L7:
            OrderListHeadRefreshLayout r103 = this.f180469a;
            r103.f180466f = MoveState.V_MOVING_CONTENT;
            OrderListHeadRefreshLayout.a(r103, "[上滑]->[下发事件]->[其他情况]->[内容上滑]");
            return;
        L5:
            if (r102.g() != true) goto L7;
            OrderListHeadRefreshLayout r104 = this.f180469a;
            r104.f180466f = MoveState.V_MOVING_HEAD;
            OrderListHeadRefreshLayout.a(r104, "[上滑]->[不下发事件]->[Head正在展示]->[当前处于Head上拉状态，需要持续响应Move事件，同时需要计算Head的动画效果]");
        }

        @Override // com.bytedance.android.shopping.orderlist.common.widgets.touch.b
        public final void d(com.bytedance.android.shopping.orderlist.common.widgets.touch.a r100, c r101) {
            Intrinsics.checkNotNullParameter(r100, "downToMoveInfo");
            Intrinsics.checkNotNullParameter(r101, "moveToMoveInfo");
            com.bytedance.android.shopping.orderlist.list.widget.headrefresh.a r102 = this.f180469a.getHeadRefreshHelper();
            if (r102 != null) goto L5;
        L7:
            OrderListHeadRefreshLayout r103 = this.f180469a;
            r103.f180466f = MoveState.V_MOVING_CONTENT_UP_OR_CANCEL;
            OrderListHeadRefreshLayout.a(r103, "[竖向滑动抬起]->[下发事件]->[Head不可见]");
            return;
        L5:
            if (r102.g() != true) goto L7;
            OrderListHeadRefreshLayout r104 = this.f180469a;
            r104.f180466f = MoveState.V_MOVING_HEAD_UP_OR_CANCEL;
            OrderListHeadRefreshLayout.a(r104, "[竖向滑动抬起]->[不下发事件]->[Head可见]");
        }

        @Override // com.bytedance.android.shopping.orderlist.common.widgets.touch.b
        public final void e(com.bytedance.android.shopping.orderlist.common.widgets.touch.a r100, c r101) {
            Intrinsics.checkNotNullParameter(r100, "downToMoveInfo");
            Intrinsics.checkNotNullParameter(r101, "moveToMoveInfo");
            Intrinsics.checkNotNullParameter(r100, "downToMoveInfo");
            Intrinsics.checkNotNullParameter(r101, "moveToMoveInfo");
        }

        @Override // com.bytedance.android.shopping.orderlist.common.widgets.touch.b
        public final void f(com.bytedance.android.shopping.orderlist.common.widgets.touch.a r100, c r101) {
            Intrinsics.checkNotNullParameter(r100, "downToMoveInfo");
            Intrinsics.checkNotNullParameter(r101, "moveToMoveInfo");
            Intrinsics.checkNotNullParameter(r100, "downToMoveInfo");
            Intrinsics.checkNotNullParameter(r101, "moveToMoveInfo");
        }

        @Override // com.bytedance.android.shopping.orderlist.common.widgets.touch.b
        public final void g(com.bytedance.android.shopping.orderlist.common.widgets.touch.a r100, c r101) {
            Intrinsics.checkNotNullParameter(r100, "downToMoveInfo");
            Intrinsics.checkNotNullParameter(r101, "moveToMoveInfo");
            Intrinsics.checkNotNullParameter(r100, "downToMoveInfo");
            Intrinsics.checkNotNullParameter(r101, "moveToMoveInfo");
        }
    }

    public OrderListHeadRefreshLayout(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public OrderListHeadRefreshLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // c53.d
    public final Disposable add(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "disposable");
        this.f180467g.add(r100);
        return r100;
    }

    @Override // c53.d
    public final void doClear() {
        this.f180467g.doClear();
    }

    @Override // c53.d
    public final void remove(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "disposable");
        this.f180467g.remove(r100);
    }

    @Override // android.view.View
    public final void computeScroll() {
        com.bytedance.android.shopping.orderlist.list.widget.headrefresh.a r100 = this.f180464d;
        if (r100 == null) goto L6;
        r100.computeScroll();
        return;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        View r100 = qc3.a.c(this, 0);
        View r101 = null;
        if ((r100 instanceof OrderCommonRefreshSloganView) == true) goto L5;
        r100 = null;
    L5:
        this.f180461a = (OrderCommonRefreshSloganView) r100;
        View r102 = qc3.a.c(this, 1);
        if ((r102 instanceof OrderListLinkedScrollView) == false) goto L9;
        r101 = r102;
    L9:
        this.f180462b = (OrderListLinkedScrollView) r101;
    }

    public final com.bytedance.android.shopping.orderlist.list.widget.headrefresh.a getHeadRefreshHelper() {
        return this.f180464d;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if (this.f180465e == false) goto L5;
        com.bytedance.android.shopping.orderlist.list.widget.headrefresh.a r101 = this.f180464d;
        if (r101 != null) goto L9;
    L11:
        this.f180463c.a(r100, new a(this));
        MoveState r102 = this.f180466f;
        int r103 = b.f180470a[r102.ordinal()];
        if (r103 == 1) goto L18;
        if (r103 != 2) goto L23;
        com.bytedance.android.shopping.orderlist.list.widget.headrefresh.a r104 = this.f180464d;
        if (r104 == null) goto L23;
        r104.c();
    L23:
        MoveState r105 = this.f180466f;
        int r106 = b.f180471b[r105.ordinal()];
        if (r106 == 1) goto L28;
        if (r106 != 2) goto L27;
        return true;
    L27:
        return super.dispatchTouchEvent(r100);
    L28:
        return true;
    L18:
        com.bytedance.android.shopping.orderlist.list.widget.headrefresh.a r107 = this.f180464d;
        if (r107 == null) goto L21;
        Integer r108 = Integer.valueOf(r107.a(this.f180463c.f180075b));
    L22:
        scrollBy(0, k.f(r108));
        goto L23
    L21:
        r108 = null;
        goto L22
    L9:
        if (r101.b() != true) goto L11;
        return true;
    L5:
        return super.dispatchTouchEvent(r100);
    }

    @Override // c53.d
    public final Disposable ignore(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "disposable");
        this.f180467g.getClass();
        Intrinsics.checkNotNullParameter(r100, "disposable");
        return r100;
    }

    public final void setHeadRefreshHelper(com.bytedance.android.shopping.orderlist.list.widget.headrefresh.a r100) {
        this.f180464d = r100;
    }

    public static final void a(final OrderListHeadRefreshLayout r100, final String r101) {
        r100.getClass();
        Lazy r102 = OrderCommonLog.f179948a;
        OrderCommonLog.a("OrderListHeadRefreshLayout", new OrderListHeadRefreshLayout$logDispatchTouchEvent$1(r100, r101));
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        measureChildren(r100, r101);
    }

    @Override // android.view.View
    public final void scrollTo(int r100, int r101) {
        com.bytedance.android.shopping.orderlist.list.widget.headrefresh.a r102 = this.f180464d;
        if (r102 == null) goto L5;
        r102.f(r101);
    L5:
        if (r101 == 0) goto L7;
    L9:
        if (r101 <= 0) goto L11;
        r101 = 0;
    L11:
        super.scrollTo(r100, r101);
        return;
    L7:
        if (this.f180466f != MoveState.V_MOVING_HEAD_UP_OR_CANCEL) goto L9;
        this.f180466f = MoveState.IDLE;
        goto L9
    }

    public OrderListHeadRefreshLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f180467g = new c53.b();
        this.f180463c = new TouchHelper(r100);
        this.f180465e = true;
        this.f180466f = MoveState.IDLE;
    }

    public /* synthetic */ OrderListHeadRefreshLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        OrderCommonRefreshSloganView r105 = this.f180461a;
        if (r105 == null) goto L5;
        int r106 = r105.getMeasuredHeight();
    L6:
        OrderListLinkedScrollView r107 = this.f180462b;
        if (r107 == null) goto L9;
        int r108 = r107.getMeasuredHeight();
    L10:
        OrderCommonRefreshSloganView r109 = this.f180461a;
        if (r109 == null) goto L13;
        r109.layout(r101, 0 - r106, r103, 0);
    L13:
        OrderListLinkedScrollView r110 = this.f180462b;
        if (r110 == null) goto L17;
        r110.layout(r101, 0, r103, r108);
        return;
    L17:
        return;
    L9:
        r108 = 0;
        goto L10
    L5:
        r106 = 0;
        goto L6
    }
}
