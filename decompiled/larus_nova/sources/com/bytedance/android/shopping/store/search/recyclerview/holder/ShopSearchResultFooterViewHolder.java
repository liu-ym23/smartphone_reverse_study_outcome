package com.bytedance.android.shopping.store.search.recyclerview.holder;

import android.widget.TextView;
import com.bytedance.android.ec.store.search.recyclerview.vo.SearchResultFooterNoticeVO;
import com.bytedance.android.ec.store.search.recyclerview.vo.SearchResultItemType;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import en.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/shopping/store/search/recyclerview/holder/ShopSearchResultFooterViewHolder;", "Lcom/bytedance/android/shopping/store/search/recyclerview/holder/ShopBaseSearchResultViewHolder;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShopSearchResultFooterViewHolder extends ShopBaseSearchResultViewHolder {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f186132e = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f186133d;

    public static final class a {
    }

    static {
    }

    public ShopSearchResultFooterViewHolder(TextView r100) {
        Intrinsics.checkNotNullParameter(r100, "footerView");
        super(null, r100, SearchResultItemType.FOOTER_VIEW);
        this.f186133d = r100;
    }

    @Override // com.bytedance.android.shopping.store.search.recyclerview.holder.ShopBaseSearchResultViewHolder
    public final void T3(b r100) {
        Intrinsics.checkNotNullParameter(r100, "vo");
        this.f186133d.setText(((SearchResultFooterNoticeVO) r100).f48569b.getDescription());
    }
}
