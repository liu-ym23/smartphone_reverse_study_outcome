package com.bytedance.android.livesdk.livecommerce.room.widgets.floatwindow.pannel.persenter;

import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.model.response.CarouselDetailInfo;
import com.bytedance.android.ec.model.response.ECFloatWindowColumnInfo;
import com.bytedance.android.ec.model.response.ECFloatWindowDetailInfo;
import com.bytedance.android.ec.sdk.helper.q;
import com.bytedance.android.livesdk.livecommerce.room.widgets.floatwindow.pannel.adapter.ECFloatWindowPanelAdapter;
import com.bytedance.android.livesdk.livecommerce.room.widgets.floatwindow.pannel.adapter.ScrollingLinearLayoutManager;
import com.bytedance.android.livesdk.livecommerce.room.widgets.floatwindow.pannel.utils.ECFloatPanelExpandedUtils;
import com.bytedance.android.livesdk.livecommerce.room.widgets.floatwindow.pannel.utils.PagerSnapScrollListener;
import com.bytedance.android.livesdk.livecommerce.room.widgets.floatwindow.pannel.view.ECCarouselIndicatorView;
import com.bytedance.android.livesdk.livecommerce.room.widgets.floatwindow.pannel.view.ECCarouselIndicatorView$getAdapterDataObserver$1;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QPresenter;
import com.ss.android.ugc.aweme.kiwi.util.Query;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class ECFloatWindowCarouselPresenter extends QPresenter {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final il.a f152133e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f152134f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f152135g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public PagerSnapScrollListener f152136h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public PagerSnapScrollListener f152137i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ECFloatWindowCarouselPresenter$init$5 f152138j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ECCarouselIndicatorView$getAdapterDataObserver$1 f152139k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public a f152140l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f152141m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Handler f152142n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f152143o;

    public final ECFloatWindowPanelAdapter E() {
        return (ECFloatWindowPanelAdapter) this.f152134f.getValue();
    }

    public ECFloatWindowCarouselPresenter() {
        this.f152133e = new il.a();
        this.f152134f = LazyKt.lazy(new ECFloatWindowCarouselPresenter$adapter$2(this));
        this.f152135g = LazyKt.lazy(ECFloatWindowCarouselPresenter$pagerSnapHelper$2.INSTANCE);
        this.f152141m = 15000;
        this.f152142n = UtilityKotlinExtentionsKt.f153057b;
        this.f152143o = true;
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QPresenter
    public final void C() {
        RecyclerView r100 = (RecyclerView) w().b(R.id.rv_pager).f();
        PagerSnapScrollListener r101 = this.f152136h;
        if (r101 == null) goto L5;
        r100.removeOnScrollListener(r101);
    L5:
        this.f152136h = null;
        ECCarouselIndicatorView$getAdapterDataObserver$1 r102 = this.f152139k;
        if (r102 == null) goto L8;
        E().unregisterAdapterDataObserver(r102);
    L8:
        this.f152139k = null;
        ECFloatWindowCarouselPresenter$init$5 r103 = this.f152138j;
        if (r103 == null) goto L11;
        E().unregisterAdapterDataObserver(r103);
    L11:
        this.f152138j = null;
        PagerSnapScrollListener r104 = this.f152137i;
        if (r104 == null) goto L14;
        r100.removeOnScrollListener(r104);
    L14:
        F(false);
        this.f152137i = null;
        il.a.a(this.f152133e);
        a r105 = this.f152140l;
        if (r105 == null) goto L18;
        this.f152142n.removeCallbacks(r105);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v11, types: [androidx.recyclerview.widget.RecyclerView$AdapterDataObserver, com.bytedance.android.livesdk.livecommerce.room.widgets.floatwindow.pannel.persenter.ECFloatWindowCarouselPresenter$init$5] */
    /* JADX WARN: Type inference failed for: r7v7, types: [androidx.recyclerview.widget.RecyclerView$AdapterDataObserver, com.bytedance.android.livesdk.livecommerce.room.widgets.floatwindow.pannel.view.ECCarouselIndicatorView$getAdapterDataObserver$1] */
    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QPresenter
    public final void A(QModel r110) {
        if ((r110 instanceof lk2.a) == true) goto L5;
        r110 = null;
    L5:
        lk2.a r111 = (lk2.a) r110;
        if (r111 != null) goto L8;
        return;
    L8:
        boolean r100 = true;
        int r101 = 0;
        if (this.f450904d == true) goto L26;
        final RecyclerView r102 = (RecyclerView) w().b(R.id.rv_pager).f();
        final ScrollingLinearLayoutManager r103 = new ScrollingLinearLayoutManager(u().c());
        r102.setLayoutManager(r103);
        r102.setAdapter(E());
        if (r102.getOnFlingListener() == null) goto L13;
        r102.setOnFlingListener(null);
    L13:
        r102.setHasFixedSize(false);
        ((PagerSnapHelper) this.f152135g.getValue()).attachToRecyclerView(r102);     // Catch: Exception -> L16
    L18:
        final ECCarouselIndicatorView r104 = (ECCarouselIndicatorView) w().b(R.id.carousel_indicator).f();
        PagerSnapHelper r105 = (PagerSnapHelper) this.f152135g.getValue();
        Intrinsics.checkNotNullParameter(r105, "pagerSnapHelper");
        PagerSnapScrollListener r106 = new PagerSnapScrollListener(r105, r104);
        r102.addOnScrollListener(r106);
        Unit r107 = Unit.INSTANCE;
        this.f152136h = r106;
        PagerSnapScrollListener r108 = new PagerSnapScrollListener((PagerSnapHelper) this.f152135g.getValue(), new b(this, r103, r102));
        r102.addOnScrollListener(r108);
        this.f152137i = r108;
        final ECFloatWindowPanelAdapter r109 = E();
        Intrinsics.checkNotNullParameter(r109, "adapter");
        Intrinsics.checkNotNullParameter(r102, "recyclerView");
        ?? r112 = new ECCarouselIndicatorView$getAdapterDataObserver$1(r104, r102, r109);
        E().registerAdapterDataObserver(r112);
        this.f152139k = r112;
        ?? r113 = new ECFloatWindowCarouselPresenter$init$5(this, r103, r102);
        E().registerAdapterDataObserver(r113);
        this.f152138j = r113;
        Integer r114 = r111.f509548a;
        if (r114 == null) goto L21;
        int r115 = r114.intValue();
    L22:
        if (r115 != 1) goto L24;
        boolean r116 = true;
    L25:
        MutableLiveData<Boolean> r117 = ECFloatPanelExpandedUtils.f152158a;
        r117.setValue(Boolean.valueOf(q.f48131a.getBoolean("ecom_live_float_window_panel_open", r116)));
        r117.observe(u().e(), new d(this, r103, r104, r102));
        this.f152140l = new a(this, r103, r102);
        goto L26
    L24:
        r116 = false;
        goto L25
    L21:
        r115 = 1;
    L16:
        e = move-exception;
        ECExceptionMonitor.e(e);
    L26:
        List<CarouselDetailInfo> r118 = r111.f509549b;
        ECFloatWindowPanelAdapter r119 = E();
        r119.getClass();
        Intrinsics.checkNotNullParameter(r118, "dataList");
        Intrinsics.checkNotNullParameter(r111, "data");
        r119.f152123b = r118;
        r119.f152124c = r111;
        r119.f152125d = -1;
        r119.safeNotifyDataSetChanged();
        if (ECFloatPanelExpandedUtils.a() == true) goto L29;
    L31:
        r100 = false;
    L32:
        Query r120 = w().b(R.id.carousel_indicator);
        if (r100 == true) goto L36;
        r101 = 8;
    L36:
        r120.g(r101);
        Long r121 = r111.f509550c;
        if (r121 == null) goto L39;
        long r122 = r121.longValue();
    L40:
        this.f152141m = r122;
        a r123 = this.f152140l;
        if (r123 == null) goto L43;
        this.f152142n.removeCallbacks(r123);
    L43:
        F(r100);
        return;
    L39:
        r122 = 15000;
        goto L40
    L29:
        if (E().getItemCount() <= 1) goto L31;
        goto L31
    }

    public final void F(boolean r100) {
        this.f152143o = r100;
        a r101 = this.f152140l;
        if (r101 == null) goto L5;
        this.f152142n.removeCallbacks(r101);
    L5:
        a r102 = this.f152140l;
        if (r100 == false) goto L10;
        if (r102 == null) goto L11;
        this.f152142n.postDelayed(r102, this.f152141m);
        return;
    L11:
        return;
    }

    public static final void D(ECFloatWindowCarouselPresenter r100, ScrollingLinearLayoutManager r101, RecyclerView r102, ECFloatWindowPanelAdapter r103) {
        r100.getClass();
        int r104 = -1;
        if (ECFloatPanelExpandedUtils.a() == true) goto L10;
        int r105 = r101.findFirstVisibleItemPosition();
        if (r105 == (-1)) goto L65;
        View r106 = r101.findViewByPosition(r105);
        if (r106 == null) goto L66;
    L51:
        r106.measure(View.MeasureSpec.makeMeasureSpec(r102.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        if (r106.getMeasuredHeight() <= 0) goto L62;
        ViewGroup.LayoutParams r107 = r102.getLayoutParams();
        if (r107 != null) goto L56;
        return;
    L56:
        if (r107.height == r106.getMeasuredHeight()) goto L64;
        r107.height = r106.getMeasuredHeight();
        r102.requestLayout();
        return;
    L64:
        return;
    L62:
        return;
    L66:
        return;
    L65:
        return;
    L10:
        List<CarouselDetailInfo> r108 = r103.f152123b;
        if (r108 != null) goto L13;
    L48:
        r106 = null;
    L49:
        if (r106 != null) goto L51;
        return;
    L13:
        if (r108.isEmpty() == true) goto L48;
        RecyclerView r109 = r103.f152122a;
        if (r109 == null) goto L48;
        Iterator<T> r110 = r108.iterator();
        int r111 = 0;
        int r112 = 0;
    L20:
        if (r110.hasNext() == false) goto L38;
        Object r113 = r110.next();
        int r114 = r111 + 1;
        if (r111 >= 0) goto L24;
        CollectionsKt.throwIndexOverflow();
    L24:
        ECFloatWindowDetailInfo r115 = ((CarouselDetailInfo) r113).getDetailInfo();
        if (r115 == null) goto L33;
        List<ECFloatWindowColumnInfo> r116 = r115.getColumnInfos();
        if (r116 == null) goto L33;
        ECFloatWindowColumnInfo r117 = (ECFloatWindowColumnInfo) CollectionsKt.getOrNull(r116, 0);
        if (r117 == null) goto L33;
        List<String> r118 = r117.getElements();
        if (r118 == null) goto L33;
        int r119 = r118.size();
    L34:
        if (r112 >= r119) goto L36;
        r104 = r111;
        r112 = r119;
    L36:
        r111 = r114;
    L33:
        r119 = 0;
        goto L34
    L38:
        if (r103.f152125d != r104) goto L40;
    L45:
        ECFloatWindowPanelAdapter.ViewHolder r120 = r103.f152126e;
        if (r120 == null) goto L48;
        r106 = r120.itemView;
        goto L49
    L40:
        if (r103.f152126e != null) goto L42;
        r103.f152126e = r103.createViewHolder(r109, r103.getItemViewType(r104));
    L42:
        r103.f152125d = r104;
        ECFloatWindowPanelAdapter.ViewHolder r121 = r103.f152126e;
        if (r121 == null) goto L45;
        lk2.b r122 = r103.y2(r104);
        r121.f152129a.b(r122);
        goto L45
    }
}
