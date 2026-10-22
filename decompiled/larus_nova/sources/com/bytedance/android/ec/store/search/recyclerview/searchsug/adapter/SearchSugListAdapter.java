package com.bytedance.android.ec.store.search.recyclerview.searchsug.adapter;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.opt.asyncInflate.c;
import com.bytedance.android.ec.store.search.recyclerview.searchsug.holder.SearchSugHolder;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.store.search.viewmodel.ShopSearchViewModel;
import com.bytedance.android.ui.ec.widget.photodraweeview.ExtensionsKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.kiwi.presenter.QContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sj3.l;
import uj3.f;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/ec/store/search/recyclerview/searchsug/adapter/SearchSugListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/ec/store/search/recyclerview/searchsug/holder/SearchSugHolder;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SearchSugListAdapter extends RecyclerView.Adapter<SearchSugHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<f> f48557a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ShopSearchViewModel f48558b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final QContext f48559c;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return ((ArrayList) this.f48557a).size();
    }

    public SearchSugListAdapter(ShopSearchViewModel r100, QContext r101) {
        Intrinsics.checkNotNullParameter(r100, "viewModel");
        Intrinsics.checkNotNullParameter(r101, "qContext");
        this.f48558b = r100;
        this.f48559c = r101;
        this.f48557a = new ArrayList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r110, int r111) {
        SearchSugHolder r112 = (SearchSugHolder) r110;
        Intrinsics.checkNotNullParameter(r112, "holder");
        f r100 = (f) ListProtector.get(this.f48557a, r111);
        int r101 = 0;
        if (((ArrayList) this.f48557a).size() != (r111 + 1)) goto L5;
        boolean r113 = true;
    L6:
        r100.f550284g = r113;
        r112.getClass();
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        r112.f48561a = r100;
        r112.f48562b = (TextView) r112.f48566f.findViewById(R.id.store_search_sug_tv);
        r112.f48563c = (SimpleDraweeView) r112.f48566f.findViewById(R.id.store_search_sug_icon);
        r112.f48564d = (ImageView) r112.f48566f.findViewById(R.id.store_search_sug_completion);
        r112.f48565e = r112.f48566f.findViewById(R.id.bottom_divider);
        f r102 = r112.f48561a;
        if (r102 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("sugItem");
    L9:
        SpannableString r114 = new SpannableString(r102.f550279b);
        f r103 = r112.f48561a;
        if (r103 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("sugItem");
    L12:
        List<l> r104 = r103.f550278a;
        if (r104 == null) goto L18;
        Iterator<l> r105 = r104.iterator();
    L16:
        if (r105.hasNext() == false) goto L18;
        l r106 = r105.next();
        r114.setSpan(new ForegroundColorSpan(-50350), r106.a(), r106.b() + 1, 33);
    L18:
        TextView r107 = r112.f48562b;
        if (r107 == null) goto L21;
        r107.setText(r114);
    L21:
        f r115 = r112.f48561a;
        if (r115 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("sugItem");
    L25:
        if (k.c(r115.f550280c) == false) goto L32;
        SimpleDraweeView r116 = r112.f48563c;
        if (r116 == null) goto L35;
        f r108 = r112.f48561a;
        if (r108 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("sugItem");
    L31:
        h0.e(r116, r108.f550280c, r112.f48567g.getImageCallerContext(), null, null, 120);
        ExtensionsKt.visible(r116);
    L35:
        View r117 = r112.f48565e;
        if (r117 == null) goto L44;
        f r109 = r112.f48561a;
        if (r109 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("sugItem");
    L41:
        if (r109.f550284g == false) goto L43;
        r101 = 8;
    L43:
        r117.setVisibility(r101);
    L44:
        r112.f48566f.setOnClickListener(r112);
        ImageView r118 = r112.f48564d;
        if (r118 == null) goto L47;
        r118.setOnClickListener(r112);
    L47:
        r112.T3("trending_words_show");
        return;
    L32:
        SimpleDraweeView r119 = r112.f48563c;
        if (r119 == null) goto L35;
        ExtensionsKt.gone(r119);
        goto L35
    L5:
        r113 = false;
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        int r102 = SearchSugHolder.f48560i;
        ShopSearchViewModel r103 = this.f48558b;
        QContext r104 = this.f48559c;
        Intrinsics.checkNotNullParameter(r100, "parent");
        Intrinsics.checkNotNullParameter(r103, "viewModel");
        Intrinsics.checkNotNullParameter(r104, "qContext");
        ShoppingAsyncInflater.a r105 = ShoppingAsyncInflater.f45268e;
        Context r106 = r100.getContext();
        r105.getClass();
        return new SearchSugHolder(c.a(ShoppingAsyncInflater.a.a(r106), R.layout.ec_store_search_sug_item, r100, 4), r103, r104);
    }
}
