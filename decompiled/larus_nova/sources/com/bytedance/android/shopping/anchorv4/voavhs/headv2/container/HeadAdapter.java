package com.bytedance.android.shopping.anchorv4.voavhs.headv2.container;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ecom.arch.slice.g;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.ecom.arch.slice.render.r;
import com.bytedance.android.ecom.arch.slice.slices.template.SlcTemplateView;
import com.bytedance.android.shopping.anchorv4.helper.SlcTemplateViewHelper;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.HeaderContentModel;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.HeaderSliceModel;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.ScrollContainerFooter;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.c0;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.d0;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.s;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.container.helper.b;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.w;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/container/HeadAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HeadAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<HeaderContentModel> f169144a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ScrollContainerFooter f169145b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f169146c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final s f169147d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RecyclerView f169148e;

    public static final class a {
    }

    static {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        int r100 = ((ArrayList) this.f169144a).size();
        if (this.f169145b == null) goto L5;
        int r101 = 1;
    L7:
        return r100 + r101;
    L5:
        r101 = 0;
        goto L7
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        if (r100 >= ((ArrayList) this.f169144a).size()) goto L5;
        return 0;
    L5:
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewAttachedToWindow(RecyclerView.ViewHolder r100) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        super.onViewAttachedToWindow(r100);
        if ((r100 instanceof ItemViewHolder) == false) goto L6;
        y2(r100, (HeaderContentModel) CollectionsKt.getOrNull(this.f169144a, ((ItemViewHolder) r100).getAdapterPosition()));
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        if ((r100 instanceof ItemViewHolder) == false) goto L10;
        HeaderContentModel r102 = (HeaderContentModel) ListProtector.get(this.f169144a, r101);
        View r103 = r100.itemView;
        if (r103 == null) goto L8;
        w r104 = (w) r103;
        r104.setTag(Integer.valueOf(r101));
        r104.l(r102, r101, null);
        y2(r100, r102);
    L46:
        this.f169147d.Nw();
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.ItemView");
    L10:
        if ((r100 instanceof FooterViewHolder) == false) goto L46;
        View r105 = r100.itemView;
        if ((r105 instanceof com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.a) == true) goto L14;
        r105 = null;
    L14:
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.a r106 = (com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.a) r105;
        if (r106 == null) goto L46;
        ScrollContainerFooter r107 = this.f169145b;
        if (r107 == null) goto L19;
        HeaderSliceModel r108 = r107.getSlice();
    L20:
        if (r108 == null) goto L22;
        g r109 = r108.getGeckoSlice();
    L24:
        if (r109 == null) goto L33;
        c0 r110 = r106.f169594b.yd().b("head-footer", r108.getGeckoSlice());
        if (r110 == null) goto L46;
        if (r110.f169065b == false) goto L30;
        SlcTemplateViewHelper.c(r110.f169064a, r108.getGeckoSlice(), null, 6);
    L30:
        r106.removeAllViews();
        SlcTemplateView r111 = r110.f169064a.f166928b;
        if (r111 == null) goto L46;
        wg.a.a(r111);
        r106.addView(r111, -2, -1);
        goto L46
    L33:
        d0 r112 = r106.f169594b.yd();
        if (r108 == null) goto L36;
        SlcElement r113 = r108.getSliceTemplate();
    L37:
        r r114 = r112.c("head-footer", r113);
        if (r114 == null) goto L45;
        r106.removeAllViews();
        View r115 = r114.f50701c;
        wg.a.a(r115);
        r115.setLayoutParams(new ViewGroup.LayoutParams(-2, -1));
        Unit r116 = Unit.INSTANCE;
        r106.addView(r115);
        if (r108 == null) goto L44;
        Map<String, Object> r117 = r108.getSliceTemplateData();
        if (r117 == null) goto L44;
        r114.a(MapsKt.mapOf(TuplesKt.to("data", r117)), null);
    L44:
        r106.setVisibility(0);
        goto L46
    L45:
        r106.setVisibility(8);
        goto L46
    L36:
        r113 = null;
        goto L37
    L22:
        r109 = null;
        goto L24
    L19:
        r108 = null;
        goto L20
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        if (r101 != 0) goto L6;
        return new ItemViewHolder(new w(r100.getContext(), this.f169147d, this.f169146c));
    L6:
        return new FooterViewHolder(new com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.a(r100.getContext(), this.f169147d, this.f169146c));
    }

    public final void y2(RecyclerView.ViewHolder r100, HeaderContentModel r101) {
        if ((r100.itemView instanceof com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.a) == true) goto L27;
        if (r101 == null) goto L29;
        boolean r102 = !this.f169147d.isExpanded();
        Object r103 = r100.itemView.getTag();
        View r104 = null;
        if ((r103 instanceof Integer) == true) goto L9;
        r103 = null;
    L9:
        Integer r105 = (Integer) r103;
        if (r105 == null) goto L12;
        int r106 = r105.intValue();
    L13:
        View r107 = r100.itemView;
        ViewGroup.LayoutParams r108 = r107.getLayoutParams();
        if ((r108 instanceof ViewGroup.MarginLayoutParams) == true) goto L16;
        r108 = null;
    L16:
        ViewGroup.MarginLayoutParams r109 = (ViewGroup.MarginLayoutParams) r108;
        if (r109 == null) goto L19;
        r109.width = this.f169146c.l(r102, r106);
        r109.height = this.f169146c.e(r102, r106);
        r109.leftMargin = this.f169146c.g(r102, r106);
        r109.rightMargin = this.f169146c.h(r102, r106);
        r109.topMargin = this.f169146c.j(r102, r106, null);
        r109.bottomMargin = this.f169146c.d(r102, r106, null);
        r107.setLayoutParams(r109);
    L19:
        View r110 = r100.itemView;
        if ((r110 instanceof w) == false) goto L23;
        r104 = r110;
    L23:
        w r111 = (w) r104;
        if (r111 == null) goto L28;
        r111.setRadius(this.f169146c.i(r102, r106));
        return;
    L28:
        return;
    L12:
        r106 = -1;
        goto L13
    L29:
        return;
    }

    public HeadAdapter(b r100, s r101, HeadRecyclerView r102) {
        Intrinsics.checkNotNullParameter(r100, "sizeHelper");
        Intrinsics.checkNotNullParameter(r101, "headAbility");
        Intrinsics.checkNotNullParameter(r102, "recyclerView");
        this.f169146c = r100;
        this.f169147d = r101;
        this.f169148e = r102;
        this.f169144a = new ArrayList();
    }
}
