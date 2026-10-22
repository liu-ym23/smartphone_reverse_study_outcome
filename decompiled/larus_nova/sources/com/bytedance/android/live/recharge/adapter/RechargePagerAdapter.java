package com.bytedance.android.live.recharge.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.live.recharge.RechargeDialogContext;
import com.bytedance.android.live.recharge.RechargeDialogFragmentV2;
import com.bytedance.android.live.recharge.deal.f;
import com.bytedance.android.live.recharge.panel.d;
import com.bytedance.android.live.recharge.platform.business.viewholder.AbsRechargeViewHolder;
import com.bytedance.android.live.recharge.platform.business.viewholder.RechargeItem;
import com.bytedance.android.live.recharge.utils.j;
import com.bytedance.android.live.recharge.viewholder.CustomDealViewHolder;
import com.bytedance.android.live.recharge.viewholder.DealViewHolder;
import com.bytedance.android.live.revenue.common.i;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/recharge/adapter/RechargePagerAdapter;", "Landroidx/viewpager/widget/PagerAdapter;", "b", "RechargeItemAdapter", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RechargePagerAdapter extends PagerAdapter {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f89625h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<? extends List<? extends RechargeItem>> f89626a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RechargeItem.CustomItem f89627b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f89628c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public AbsRechargeViewHolder<?> f89629d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RechargeDialogContext f89630e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ViewPager f89631f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ax0.a f89632g;

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/recharge/adapter/RechargePagerAdapter$RechargeItemAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/live/recharge/platform/business/viewholder/AbsRechargeViewHolder;", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public final class RechargeItemAdapter extends RecyclerView.Adapter<AbsRechargeViewHolder<?>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f89633a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ RechargePagerAdapter f89634b;

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final int getItemCount() {
            return ((List) ListProtector.get(this.f89634b.f89626a, this.f89633a)).size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final int getItemViewType(int r100) {
            RechargeItem r101 = (RechargeItem) ListProtector.get((List) ListProtector.get(this.f89634b.f89626a, this.f89633a), r100);
            if ((r101 instanceof RechargeItem.CustomItem) == false) goto L6;
            return 1;
        L6:
            if ((r101 instanceof RechargeItem.a) == false) goto L10;
            return 0;
        L10:
            throw new NoWhenBranchMatchedException();
        }

        public RechargeItemAdapter(RechargePagerAdapter r100, int r101) {
            this.f89634b = r100;
            this.f89633a = r101;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r110) {
            AbsRechargeViewHolder r101 = (AbsRechargeViewHolder) r100;
            Intrinsics.checkNotNullParameter(r101, "viewHolder");
            Object r102 = ListProtector.get((List) ListProtector.get(this.f89634b.f89626a, this.f89633a), r110);
            if (r102 == null) goto L17;
            RechargeItem r103 = (RechargeItem) r102;
            r101.T3(r103);
            if ((r103 instanceof RechargeItem.a) == false) goto L10;
            long r104 = ((RechargeItem.a) r103).f90228a.b();
            RechargePagerAdapter r105 = this.f89634b;
            if (r104 != r105.f89628c) goto L10;
            RechargePagerAdapter.f(r105, r101, true, r110);
        L14:
            r101.itemView.setOnClickListener(new com.bytedance.android.live.recharge.adapter.a(this, r103, r101, r110));
            return;
        L10:
            if ((r103 instanceof RechargeItem.CustomItem) == false) goto L14;
            if (((RechargeItem.CustomItem) r103).f90226d != RechargeItem.CustomItem.Mode.DIAMOND) goto L14;
            RechargePagerAdapter.f(this.f89634b, r101, true, r110);
            goto L14
        L17:
            throw new NullPointerException("null cannot be cast to non-null type T");
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "parent");
            if (r101 == 1) goto L6;
            return new DealViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.ttlive_item_recharge_dialog_deal, r100, false));
        L6:
            return new CustomDealViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.ttlive_item_recharge_dialog_deal_custom, r100, false));
        }
    }

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RechargePagerAdapter f89635a;

        public a(RechargePagerAdapter r100) {
            this.f89635a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Unit r101 = (Unit) r100;
            if (d.f90184c == false) goto L26;
            RechargePagerAdapter r102 = this.f89635a;
            long r103 = r102.f89630e.getCustomPrice().f64752a.longValue();
            RechargeItem.CustomItem r104 = r102.f89627b;
            if (r104 != null) goto L8;
            return;
        L8:
            if (r103 == 0) goto L10;
            r104.f90223a = r103;
            r104.f90225c = "自定义";
            r104.f90226d = RechargeItem.CustomItem.Mode.DIAMOND;
        L11:
            AbsRechargeViewHolder<?> r105 = r102.f89629d;
            if (r105 == null) goto L14;
            Object r106 = r105.f90222a;
        L16:
            if ((r106 instanceof RechargeItem.a) == true) goto L18;
            r106 = null;
        L18:
            RechargeItem.a r107 = (RechargeItem.a) r106;
            if (r107 == null) goto L23;
            f r108 = r107.f90228a;
            if (r108 == null) goto L23;
            long r109 = r108.b();
        L24:
            r102.f89628c = r109;
            r102.f89629d = null;
            r102.notifyDataSetChanged();
            return;
        L23:
            r109 = r102.f89628c;
            goto L24
        L14:
            r106 = null;
            goto L16
        L10:
            r104.f90223a = 0;
            r104.f90225c = "";
            r104.f90226d = RechargeItem.CustomItem.Mode.INPUT;
            goto L11
        }
    }

    public static final class b {
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final int getItemPosition(Object r100) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.MapObjKey.OBJ_SL_OBJ);
        return -2;
    }

    static {
        f89625h = i.b(12);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final int getCount() {
        return this.f89626a.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final Object instantiateItem(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        RecyclerView r102 = new RecyclerView(r100.getContext());
        r102.setLayoutManager(new GridLayoutManager(r100.getContext(), 3));
        int r103 = f89625h;
        r102.setPadding(r103, 0, r103, 0);
        r102.setAdapter(new RechargeItemAdapter(this, r101));
        r102.setOverScrollMode(2);
        r102.setTag(Integer.valueOf(r101));
        r100.addView(r102, new ViewGroup.LayoutParams(-1, -1));
        return r102;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final boolean isViewFromObject(View r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "o");
        return Intrinsics.areEqual(r100, r101);
    }

    public RechargePagerAdapter(RechargeDialogContext r100, ViewPager r101, ax0.a r102) {
        Intrinsics.checkNotNullParameter(r100, "dialogContext");
        Intrinsics.checkNotNullParameter(r102, "listener");
        this.f89630e = r100;
        this.f89631f = r101;
        this.f89632g = r102;
        this.f89626a = CollectionsKt.emptyList();
        if (r101 == null) goto L5;
        ViewGroup.LayoutParams r103 = r101.getLayoutParams();
    L7:
        if (j.d().getPanelHeightAdjust() == false) goto L10;
        if (r103 == null) goto L10;
        r103.height = RechargeDialogFragmentV2.f89564n * 2;
    L10:
        RxUtilKt.c(RxUtilKt.h(r100.getCustomRechargePageHideEvent()).subscribe(new a(this)), r100.getCd());
        return;
    L5:
        r103 = null;
        goto L7
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final void destroyItem(ViewGroup r100, int r101, Object r102) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r102, MapBundleKey.MapObjKey.OBJ_SL_OBJ);
        r100.removeView((View) r102);
    }

    public static final void f(RechargePagerAdapter r100, AbsRechargeViewHolder r101, boolean r102, int r103) {
        AbsRechargeViewHolder<?> r104 = r100.f89629d;
        if (r104 == null) goto L5;
        r104.V3();
    L5:
        AbsRechargeViewHolder<?> r105 = r100.f89629d;
        if (r105 == null) goto L8;
        Object r106 = r105.f90222a;
    L10:
        if ((r106 instanceof RechargeItem.CustomItem) == false) goto L12;
        r100.f89630e.getCustomPrice().a(0L);
    L12:
        r101.U3();
        r100.f89629d = r101;
        RechargeItem r107 = r101.f90222a;
        if (r107 == null) goto L16;
        r100.f89632g.bc(r107, r102, r103);
        return;
    L16:
        return;
    L8:
        r106 = null;
        goto L10
    }
}
