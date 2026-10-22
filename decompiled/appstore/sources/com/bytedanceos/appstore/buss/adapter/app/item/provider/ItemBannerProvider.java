package com.bytedanceos.appstore.buss.adapter.app.item.provider;

import android.view.View;
import android.view.ViewGroup;
import com.bytedanceos.appstore.buss.entity.CommonAppEntity;
import com.bytedanceos.appstore.buss.entity.item.ItemType;
import com.bytedanceos.appstore.buss.widget.app.item.ItemBannerView;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\"\u0010\u0017\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u001b\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0012\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u0016R\"\u0010!\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b\u001c\u0010 R\"\u0010'\u001a\u00020\"8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010#\u001a\u0004\b$\u0010%\"\u0004\b\u0018\u0010&R\u0014\u0010)\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b(\u0010\u001fR\u0014\u0010+\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b*\u0010\u001f¨\u0006,"}, d2 = {"Lcom/bytedanceos/appstore/buss/adapter/app/item/provider/ItemBannerProvider;", "Lcom/chad/library/adapter/base/provider/BaseItemProvider;", "Lcom/bytedanceos/appstore/buss/entity/CommonAppEntity;", "<init>", "()V", "Landroid/view/ViewGroup;", "parent", "", "viewType", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "helper", "item", "", "a", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/bytedanceos/appstore/buss/entity/CommonAppEntity;)V", "", "Z", "getSetTopMargin", "()Z", "e", "(Z)V", "setTopMargin", "b", "getSetBottomMargin", "d", "setBottomMargin", "c", "I", "getRow", "()I", "(I)V", "row", "", "Ljava/lang/String;", "getPageName", "()Ljava/lang/String;", "(Ljava/lang/String;)V", "pageName", "getItemViewType", "itemViewType", "getLayoutId", "layoutId", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ItemBannerProvider extends BaseItemProvider<CommonAppEntity> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f8352a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f8353b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f8354c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f8355d;

    public ItemBannerProvider() {
        this.f8355d = "";
    }

    public void a(BaseViewHolder r10, CommonAppEntity r11) {
        q.g(r10, "helper");
        q.g(r11, "item");
        View r12 = r10.itemView;
        q.e(r12, "null cannot be cast to non-null type com.bytedanceos.appstore.buss.widget.app.item.ItemBannerView");
        ItemBannerView r13 = (ItemBannerView) r12;
        r13.setRow(this.f8354c);
        r13.setPosition(r10.getAdapterPosition());
        r13.setPageName(this.f8355d);
        r13.setNewData(r11);
    }

    public final void b(String r10) {
        q.g(r10, "<set-?>");
        this.f8355d = r10;
    }

    public final void c(int r10) {
        this.f8354c = r10;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public /* bridge */ /* synthetic */ void convert(BaseViewHolder r10, CommonAppEntity r11) {
        a(r10, r11);
    }

    public final void d(boolean r10) {
        this.f8353b = r10;
    }

    public final void e(boolean r10) {
        this.f8352a = r10;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int getItemViewType() {
        return ItemType.BANNER.ordinal();
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int getLayoutId() {
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public BaseViewHolder onCreateViewHolder(ViewGroup r10, int r11) {
        q.g(r10, "parent");
        ItemBannerView r12 = new ItemBannerView(getContext(), null, 2, 0 == true ? 1 : 0);
        r12.setSetTopMargin(this.f8352a);
        r12.setSetBottomMargin(this.f8353b);
        return new BaseViewHolder(r12);
    }
}
