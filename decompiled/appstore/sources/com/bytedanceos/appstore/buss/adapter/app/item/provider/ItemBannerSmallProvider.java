package com.bytedanceos.appstore.buss.adapter.app.item.provider;

import android.view.View;
import android.view.ViewGroup;
import com.bytedanceos.appstore.buss.adapter.app.item.adapter.ItemBannerSmallAdapter;
import com.bytedanceos.appstore.buss.entity.CommonAppEntity;
import com.bytedanceos.appstore.buss.entity.item.ItemType;
import com.bytedanceos.appstore.buss.widget.app.item.ItemBannerSmallView;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/bytedanceos/appstore/buss/adapter/app/item/provider/ItemBannerSmallProvider;", "Lcom/chad/library/adapter/base/provider/BaseItemProvider;", "Lcom/bytedanceos/appstore/buss/entity/CommonAppEntity;", "<init>", "()V", "Landroid/view/ViewGroup;", "parent", "", "viewType", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "helper", "item", "", "a", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/bytedanceos/appstore/buss/entity/CommonAppEntity;)V", "getItemViewType", "()I", "itemViewType", "getLayoutId", "layoutId", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ItemBannerSmallProvider extends BaseItemProvider<CommonAppEntity> {
    public ItemBannerSmallProvider() {
    }

    public void a(BaseViewHolder r10, CommonAppEntity r11) {
        q.g(r10, "helper");
        q.g(r11, "item");
        View r12 = r10.itemView;
        q.e(r12, "null cannot be cast to non-null type com.bytedanceos.appstore.buss.widget.app.item.ItemBannerSmallView");
        ItemBannerSmallView r13 = (ItemBannerSmallView) r12;
        BaseProviderMultiAdapter<CommonAppEntity> r14 = getAdapter();
        q.e(r14, "null cannot be cast to non-null type com.bytedanceos.appstore.buss.adapter.app.item.adapter.ItemBannerSmallAdapter");
        r13.setRow(((ItemBannerSmallAdapter) r14).b());
        r13.setPosition(r10.getAdapterPosition() + 1);
        BaseProviderMultiAdapter<CommonAppEntity> r15 = getAdapter();
        q.e(r15, "null cannot be cast to non-null type com.bytedanceos.appstore.buss.adapter.app.item.adapter.ItemBannerSmallAdapter");
        r13.setPageName(((ItemBannerSmallAdapter) r15).a());
        r13.setNewData(r11);
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public /* bridge */ /* synthetic */ void convert(BaseViewHolder r10, CommonAppEntity r11) {
        a(r10, r11);
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int getItemViewType() {
        return ItemType.BANNER_SMALL.ordinal();
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int getLayoutId() {
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public BaseViewHolder onCreateViewHolder(ViewGroup r10, int r11) {
        q.g(r10, "parent");
        return new BaseViewHolder(new ItemBannerSmallView(getContext(), null, 2, 0 == true ? 1 : 0));
    }
}
