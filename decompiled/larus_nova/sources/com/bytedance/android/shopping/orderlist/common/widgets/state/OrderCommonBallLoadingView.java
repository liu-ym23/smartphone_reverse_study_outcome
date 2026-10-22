package com.bytedance.android.shopping.orderlist.common.widgets.state;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.shopping.orderlist.common.utils.m;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0007\u001a\u00020\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/shopping/orderlist/common/widgets/state/OrderCommonBallLoadingView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/bytedance/android/shopping/orderlist/common/widgets/state/OrderCommonDoubleColorBallAnimationView;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lkotlin/Lazy;", "getBallView", "()Lcom/bytedance/android/shopping/orderlist/common/widgets/state/OrderCommonDoubleColorBallAnimationView;", "ballView", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attributeSet", "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OrderCommonBallLoadingView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f180051a;

    public OrderCommonBallLoadingView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public OrderCommonBallLoadingView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final OrderCommonDoubleColorBallAnimationView getBallView() {
        return (OrderCommonDoubleColorBallAnimationView) this.f180051a.getValue();
    }

    public final void S5() {
        m.a r100 = m.f179977a;
        m.c(new OrderCommonBallLoadingView$startLoading$1(this));
    }

    public final void T5() {
        m.a r100 = m.f179977a;
        m.c(new OrderCommonBallLoadingView$stopLoading$1(this));
    }

    public static final /* synthetic */ OrderCommonDoubleColorBallAnimationView R5(OrderCommonBallLoadingView r100) {
        return r100.getBallView();
    }

    public OrderCommonBallLoadingView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f180051a = LazyKt.lazy(new OrderCommonBallLoadingView$ballView$2(this));
        LayoutInflater.from(r100).inflate(R.layout.order_list_view_ball_loading, this, true);
    }

    public /* synthetic */ OrderCommonBallLoadingView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
