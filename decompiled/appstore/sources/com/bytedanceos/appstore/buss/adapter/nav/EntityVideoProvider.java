package com.bytedanceos.appstore.buss.adapter.nav;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedanceos.appstore.buss.entity.AppEntityWrap;
import com.bytedanceos.appstore.buss.entity.item.ItemType;
import com.bytedanceos.appstore.buss.widget.app.item.ItemEntityVideoView;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0010R`\u0010\u001d\u001a@\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0011j\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0014\u0010 \u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010\"\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u001f¨\u0006#"}, d2 = {"Lcom/bytedanceos/appstore/buss/adapter/nav/EntityVideoProvider;", "Lcom/chad/library/adapter/base/provider/BaseItemProvider;", "Lcom/bytedanceos/appstore/buss/entity/AppEntityWrap;", "<init>", "()V", "Landroid/view/ViewGroup;", "parent", "", "viewType", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "helper", "item", "", "a", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/bytedanceos/appstore/buss/entity/AppEntityWrap;)V", "Lkotlin/Function2;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "view", "entity", "Lcom/bytedanceos/appstore/buss/utilities/AppOnClickListener;", "Lkotlin/jvm/functions/Function2;", "getVideoItemOnClickListener", "()Lkotlin/jvm/functions/Function2;", "b", "(Lkotlin/jvm/functions/Function2;)V", "videoItemOnClickListener", "getItemViewType", "()I", "itemViewType", "getLayoutId", "layoutId", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class EntityVideoProvider extends BaseItemProvider<AppEntityWrap> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function2 f8393a;

    public EntityVideoProvider() {
    }

    public void a(BaseViewHolder r10, AppEntityWrap r11) {
        q.g(r10, "helper");
        q.g(r11, "item");
        View r12 = r10.itemView;
        q.e(r12, "null cannot be cast to non-null type com.bytedanceos.appstore.buss.widget.app.item.ItemEntityVideoView");
        ItemEntityVideoView r13 = (ItemEntityVideoView) r12;
        r13.setVideoItemOnClickListener(this.f8393a);
        r13.setNewData(r11);
    }

    public final void b(Function2 r10) {
        this.f8393a = r10;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public /* bridge */ /* synthetic */ void convert(BaseViewHolder r10, AppEntityWrap r11) {
        a(r10, r11);
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int getItemViewType() {
        return ItemType.ENTITY_VIDEO.ordinal();
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int getLayoutId() {
        return 0;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public BaseViewHolder onCreateViewHolder(ViewGroup r10, int r11) {
        q.g(r10, "parent");
        Context r12 = r10.getContext();
        q.f(r12, "getContext(...)");
        return new BaseViewHolder(new ItemEntityVideoView(r12));
    }
}
