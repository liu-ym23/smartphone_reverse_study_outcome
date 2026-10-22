package com.bytedanceos.appstore.buss.adapter.app.item.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.bytedanceos.appstore.buss.entity.CommonAppEntity;
import com.bytedanceos.appstore.buss.widget.app.item.ItemBannerView;
import com.bytedanceos.appstore.buss.widget.recyclerbanner.BannerPagerRecyclerView;
import com.bytedanceos.appstore.buss.widget.recyclerbanner.BaseRecyclerBannerAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017R\"\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0018\u0010$\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010#¨\u0006%"}, d2 = {"Lcom/bytedanceos/appstore/buss/adapter/app/item/adapter/ItemBannerAdapter;", "Lcom/bytedanceos/appstore/buss/widget/recyclerbanner/BaseRecyclerBannerAdapter;", "Lcom/bytedanceos/appstore/buss/entity/CommonAppEntity;", "", "pageName", "", "row", "<init>", "(Ljava/lang/String;I)V", "Landroid/view/ViewGroup;", "parent", "viewType", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "d", "(Landroid/view/ViewGroup;I)Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "holder", "position", "", "c", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;I)V", "Lcom/bytedanceos/appstore/buss/widget/recyclerbanner/BannerPagerRecyclerView$BannerExposeListener;", "listener", "f", "(Lcom/bytedanceos/appstore/buss/widget/recyclerbanner/BannerPagerRecyclerView$BannerExposeListener;)V", "b", "I", "getRow", "()I", "g", "(I)V", "Ljava/lang/String;", "getPageName", "()Ljava/lang/String;", "setPageName", "(Ljava/lang/String;)V", "Lcom/bytedanceos/appstore/buss/widget/recyclerbanner/BannerPagerRecyclerView$BannerExposeListener;", "bannerExposeListener", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ItemBannerAdapter extends BaseRecyclerBannerAdapter<CommonAppEntity> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f8336b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f8337c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public BannerPagerRecyclerView.BannerExposeListener f8338d;

    /* JADX WARN: Multi-variable type inference failed */
    public ItemBannerAdapter() {
        String r10 = null;
        this(r10, 0, 3, 0 == true ? 1 : 0);
    }

    @Override // com.bytedanceos.appstore.buss.widget.recyclerbanner.BaseRecyclerBannerAdapter
    public void c(BaseViewHolder r10, int r11) {
        q.g(r10, "holder");
        View r12 = r10.itemView;
        q.e(r12, "null cannot be cast to non-null type com.bytedanceos.appstore.buss.widget.app.item.ItemBannerView");
        ItemBannerView r13 = (ItemBannerView) r12;
        r13.setRow(this.f8336b);
        r13.setPosition((r11 % a()) + 1);
        r13.setPageName(this.f8337c);
        r13.setNewData(getData().get(r11));
        if (r11 >= a()) goto L8;
        BannerPagerRecyclerView.BannerExposeListener r14 = this.f8338d;
        if (r14 == null) goto L9;
        r14.onBannerExpose();
        return;
    L9:
        return;
    }

    @Override // com.bytedanceos.appstore.buss.widget.recyclerbanner.BaseRecyclerBannerAdapter
    public BaseViewHolder d(ViewGroup r10, int r11) {
        q.g(r10, "parent");
        return new BaseViewHolder(new ItemBannerView(getContext(), null, 2, null));
    }

    public final void f(BannerPagerRecyclerView.BannerExposeListener r10) {
        q.g(r10, "listener");
        this.f8338d = r10;
    }

    public final void g(int r10) {
        this.f8336b = r10;
    }

    public ItemBannerAdapter(String r10, int r11) {
        this.f8336b = r11;
        this.f8337c = r10;
    }

    public /* synthetic */ ItemBannerAdapter(String r10, int r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 1) == 0) goto L6;
        r10 = "";
    L6:
        if ((r12 & 2) == 0) goto L8;
        r11 = 0;
    L8:
        this(r10, r11);
    }
}
