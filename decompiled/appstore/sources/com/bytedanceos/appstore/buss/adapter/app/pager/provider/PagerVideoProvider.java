package com.bytedanceos.appstore.buss.adapter.app.pager.provider;

import android.view.View;
import android.view.ViewGroup;
import com.bytedanceos.appstore.buss.adapter.app.base.BasePagerProvider;
import com.bytedanceos.appstore.buss.entity.AppEntityWrap;
import com.bytedanceos.appstore.buss.entity.item.ItemType;
import com.bytedanceos.appstore.buss.widget.app.pager.PagerVideoView;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\u000e¢\u0006\u0004\b\u0011\u0010\u0004J\r\u0010\u0012\u001a\u00020\u000e¢\u0006\u0004\b\u0012\u0010\u0004J\r\u0010\u0013\u001a\u00020\u000e¢\u0006\u0004\b\u0013\u0010\u0004R$\u0010\u001b\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001e\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010 \u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001d¨\u0006!"}, d2 = {"Lcom/bytedanceos/appstore/buss/adapter/app/pager/provider/PagerVideoProvider;", "Lcom/bytedanceos/appstore/buss/adapter/app/base/BasePagerProvider;", "Lcom/bytedanceos/appstore/buss/entity/AppEntityWrap;", "<init>", "()V", "Landroid/view/ViewGroup;", "parent", "", "viewType", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "holder", "item", "", "b", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/bytedanceos/appstore/buss/entity/AppEntityWrap;)V", "e", "d", "c", "Lcom/bytedanceos/appstore/buss/widget/app/pager/PagerVideoView;", "a", "Lcom/bytedanceos/appstore/buss/widget/app/pager/PagerVideoView;", "getItemView", "()Lcom/bytedanceos/appstore/buss/widget/app/pager/PagerVideoView;", "setItemView", "(Lcom/bytedanceos/appstore/buss/widget/app/pager/PagerVideoView;)V", "itemView", "getItemViewType", "()I", "itemViewType", "getLayoutId", "layoutId", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PagerVideoProvider extends BasePagerProvider<AppEntityWrap> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PagerVideoView f8392a;

    public PagerVideoProvider() {
    }

    public void b(BaseViewHolder r10, AppEntityWrap r11) {
        q.g(r10, "holder");
        q.g(r11, "item");
        View r12 = r10.itemView;
        q.e(r12, "null cannot be cast to non-null type com.bytedanceos.appstore.buss.widget.app.pager.PagerVideoView");
        PagerVideoView r13 = (PagerVideoView) r12;
        this.f8392a = r13;
        if (r13 == null) goto L6;
        r13.setNewData2(r11);
        return;
    }

    public final void c() {
        PagerVideoView r10 = this.f8392a;
        if (r10 == null) goto L6;
        r10.m();
        return;
    }

    @Override // com.bytedanceos.appstore.buss.adapter.app.base.BasePagerProvider, com.chad.library.adapter.base.provider.BaseItemProvider
    public /* bridge */ /* synthetic */ void convert(BaseViewHolder r10, Object r11) {
        b(r10, (AppEntityWrap) r11);
    }

    public final void d() {
        PagerVideoView r10 = this.f8392a;
        if (r10 == null) goto L6;
        r10.n();
        return;
    }

    public final void e() {
        PagerVideoView r10 = this.f8392a;
        if (r10 == null) goto L6;
        r10.o();
        return;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int getItemViewType() {
        return ItemType.PAGER_VIDEO.ordinal();
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int getLayoutId() {
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public BaseViewHolder onCreateViewHolder(ViewGroup r10, int r11) {
        q.g(r10, "parent");
        PagerVideoView r12 = new PagerVideoView(getContext(), null, 2, 0 == true ? 1 : 0);
        r12.getRecyclerView().setRecycledViewPool(a().a());
        return new BaseViewHolder(r12);
    }
}
