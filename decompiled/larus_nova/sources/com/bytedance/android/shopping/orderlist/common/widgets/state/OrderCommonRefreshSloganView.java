package com.bytedance.android.shopping.orderlist.common.widgets.state;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002R#\u0010\f\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR#\u0010\u0011\u001a\n \u0007*\u0004\u0018\u00010\r0\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/shopping/orderlist/common/widgets/state/OrderCommonRefreshSloganView;", "Landroid/widget/LinearLayout;", "", "text", "", "setHintContent", "Lcom/bytedance/android/shopping/orderlist/common/widgets/state/OrderCommonDoubleColorBallAnimationView;", "kotlin.jvm.PlatformType", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lkotlin/Lazy;", "getBallView", "()Lcom/bytedance/android/shopping/orderlist/common/widgets/state/OrderCommonDoubleColorBallAnimationView;", "ballView", "Landroid/widget/TextView;", "b", "getHintText", "()Landroid/widget/TextView;", "hintText", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attributeSet", "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OrderCommonRefreshSloganView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f180061a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f180062b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f180063c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f180064d;

    public OrderCommonRefreshSloganView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public OrderCommonRefreshSloganView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final OrderCommonDoubleColorBallAnimationView getBallView() {
        return (OrderCommonDoubleColorBallAnimationView) this.f180061a.getValue();
    }

    private final TextView getHintText() {
        return (TextView) this.f180062b.getValue();
    }

    private final void setHintContent(String r100) {
        if (Intrinsics.areEqual(this.f180063c, r100) == false) goto L5;
        return;
    L5:
        getHintText().setText(r100);
    }

    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        if (this.f180064d == true) goto L6;
        this.f180064d = true;
        getBallView().setVisibility(0);
        getBallView().c();
    L6:
        setHintContent(r100);
    }

    public final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        this.f180064d = false;
        getBallView().setVisibility(8);
        getBallView().d();
        setHintContent(r100);
    }

    public OrderCommonRefreshSloganView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f180061a = LazyKt.lazy(new OrderCommonRefreshSloganView$ballView$2(this));
        this.f180062b = LazyKt.lazy(new OrderCommonRefreshSloganView$hintText$2(this));
        setGravity(17);
        setOrientation(0);
        th.a.c(r100, R.layout.order_list_view_refresh_slogan, this, true);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.f180063c = "";
    }

    public /* synthetic */ OrderCommonRefreshSloganView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
