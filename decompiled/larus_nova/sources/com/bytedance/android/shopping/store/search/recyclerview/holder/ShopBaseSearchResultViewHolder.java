package com.bytedance.android.shopping.store.search.recyclerview.holder;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.store.search.recyclerview.vo.SearchResultItemType;
import com.ss.android.ugc.aweme.kiwi.ui.QUIManager;
import en.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/android/shopping/store/search/recyclerview/holder/ShopBaseSearchResultViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/bytedance/android/ec/store/search/recyclerview/vo/SearchResultItemType;", "c", "Lcom/bytedance/android/ec/store/search/recyclerview/vo/SearchResultItemType;", "getType", "()Lcom/bytedance/android/ec/store/search/recyclerview/vo/SearchResultItemType;", "type", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class ShopBaseSearchResultViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final QUIManager f186125a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f186126b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SearchResultItemType f186127c;

    public abstract void T3(b r100);

    public final SearchResultItemType getType() {
        return this.f186127c;
    }

    public ShopBaseSearchResultViewHolder(QUIManager r100, View r101, SearchResultItemType r102) {
        Intrinsics.checkNotNullParameter(r101, "holderView");
        Intrinsics.checkNotNullParameter(r102, "type");
        super(r101);
        this.f186125a = r100;
        this.f186126b = r101;
        this.f186127c = r102;
    }
}
