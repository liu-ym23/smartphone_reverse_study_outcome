package com.bytedanceos.appstore.buss.adapter.app.pager.provider;

import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.bytedanceos.appstore.buss.adapter.app.base.BasePagerProvider;
import com.bytedanceos.appstore.buss.entity.AppEntityWrap;
import com.bytedanceos.appstore.buss.entity.item.ItemType;
import com.bytedanceos.appstore.buss.widget.app.pager.PagerBannerView;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\r\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0006R\u0014\u0010\u001a\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/bytedanceos/appstore/buss/adapter/app/pager/provider/PagerBannerProvider;", "Lcom/bytedanceos/appstore/buss/adapter/app/base/BasePagerProvider;", "Lcom/bytedanceos/appstore/buss/entity/AppEntityWrap;", "", "pageName", "<init>", "(Ljava/lang/String;)V", "Landroid/view/ViewGroup;", "parent", "", "viewType", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "holder", "item", "", "b", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/bytedanceos/appstore/buss/entity/AppEntityWrap;)V", "a", "Ljava/lang/String;", "getPageName", "()Ljava/lang/String;", "setPageName", "getItemViewType", "()I", "itemViewType", "getLayoutId", "layoutId", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PagerBannerProvider extends BasePagerProvider<AppEntityWrap> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f8375a;

    /* JADX WARN: Multi-variable type inference failed */
    public PagerBannerProvider() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public void b(BaseViewHolder r10, AppEntityWrap r11) {
        q.g(r10, "holder");
        q.g(r11, "item");
        View r12 = r10.itemView;
        q.e(r12, "null cannot be cast to non-null type com.bytedanceos.appstore.buss.widget.app.pager.PagerBannerView");
        PagerBannerView r13 = (PagerBannerView) r12;
        r13.setRow(r10.getAdapterPosition() + 1);
        r13.setNewData2(r11);
    }

    @Override // com.bytedanceos.appstore.buss.adapter.app.base.BasePagerProvider, com.chad.library.adapter.base.provider.BaseItemProvider
    public /* bridge */ /* synthetic */ void convert(BaseViewHolder r10, Object r11) {
        b(r10, (AppEntityWrap) r11);
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int getItemViewType() {
        return ItemType.PAGER_BANNER.ordinal();
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int getLayoutId() {
        return 0;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public BaseViewHolder onCreateViewHolder(ViewGroup r10, int r11) {
        q.g(r10, "parent");
        AttributeSet r12 = null;
        int r13 = 0;
        PagerBannerView r14 = new PagerBannerView(getContext(), r12, this.f8375a, r13, 10, null);
        r14.getRecyclerView().setRecycledViewPool(a().a());
        return new BaseViewHolder(r14);
    }

    public PagerBannerProvider(String r10) {
        this.f8375a = r10;
    }

    public /* synthetic */ PagerBannerProvider(String r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 1) == 0) goto L5;
        r10 = "";
    L5:
        this(r10);
    }
}
