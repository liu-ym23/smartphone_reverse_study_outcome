package com.bytedanceos.appstore.buss.adapter.app.item.adapter;

import com.bytedanceos.appstore.buss.adapter.app.item.provider.ItemVideoProvider;
import com.bytedanceos.appstore.buss.entity.CommonAppEntity;
import com.bytedanceos.appstore.buss.entity.item.ItemType;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.module.LoadMoreModule;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J%\u0010\n\u001a\u00020\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\r\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u0005J\r\u0010\u000e\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u0005J\r\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0005¨\u0006\u0010"}, d2 = {"Lcom/bytedanceos/appstore/buss/adapter/app/item/adapter/ItemVideoAdapter;", "Lcom/chad/library/adapter/base/BaseProviderMultiAdapter;", "Lcom/bytedanceos/appstore/buss/entity/CommonAppEntity;", "Lcom/chad/library/adapter/base/module/LoadMoreModule;", "<init>", "()V", "", "data", "", "position", "getItemType", "(Ljava/util/List;I)I", "", "onResume", "onPause", "a", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ItemVideoAdapter extends BaseProviderMultiAdapter<CommonAppEntity> implements LoadMoreModule {
    public ItemVideoAdapter() {
        super(null, 1, null);
        addItemProvider(new ItemVideoProvider());
    }

    public final void a() {
        BaseItemProvider<CommonAppEntity> r10 = getItemProvider(ItemType.VIDEO.ordinal());
        q.e(r10, "null cannot be cast to non-null type com.bytedanceos.appstore.buss.adapter.app.item.provider.ItemVideoProvider");
        ((ItemVideoProvider) r10).b();
    }

    @Override // com.chad.library.adapter.base.BaseProviderMultiAdapter
    public int getItemType(List<? extends CommonAppEntity> r10, int r11) {
        q.g(r10, "data");
        return ItemType.VIDEO.ordinal();
    }

    public final void onPause() {
        BaseItemProvider<CommonAppEntity> r10 = getItemProvider(ItemType.VIDEO.ordinal());
        q.e(r10, "null cannot be cast to non-null type com.bytedanceos.appstore.buss.adapter.app.item.provider.ItemVideoProvider");
        ((ItemVideoProvider) r10).c();
    }

    public final void onResume() {
        BaseItemProvider<CommonAppEntity> r10 = getItemProvider(ItemType.VIDEO.ordinal());
        q.e(r10, "null cannot be cast to non-null type com.bytedanceos.appstore.buss.adapter.app.item.provider.ItemVideoProvider");
        ((ItemVideoProvider) r10).d();
    }
}
