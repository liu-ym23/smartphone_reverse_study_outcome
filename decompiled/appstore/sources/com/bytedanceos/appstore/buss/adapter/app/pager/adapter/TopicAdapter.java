package com.bytedanceos.appstore.buss.adapter.app.pager.adapter;

import com.bytedanceos.appstore.buss.adapter.app.item.provider.ItemBannerProvider;
import com.bytedanceos.appstore.buss.adapter.app.item.provider.ItemHorizontalProvider;
import com.bytedanceos.appstore.buss.entity.CommonAppEntity;
import com.bytedanceos.appstore.buss.entity.item.ItemType;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlin.text.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0014¨\u0006\t"}, d2 = {"Lcom/bytedanceos/appstore/buss/adapter/app/pager/adapter/TopicAdapter;", "Lcom/chad/library/adapter/base/BaseProviderMultiAdapter;", "Lcom/bytedanceos/appstore/buss/entity/CommonAppEntity;", "()V", "getItemType", "", "data", "", "position", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TopicAdapter extends BaseProviderMultiAdapter<CommonAppEntity> {
    public TopicAdapter() {
        super(null, 1, null);
        ItemBannerProvider r10 = new ItemBannerProvider();
        r10.e(true);
        r10.d(true);
        r10.c(0);
        r10.b("page_topic");
        addItemProvider(r10);
        ItemHorizontalProvider r11 = new ItemHorizontalProvider();
        r11.h("page_topic");
        addItemProvider(r11);
    }

    @Override // com.chad.library.adapter.base.BaseProviderMultiAdapter
    public int getItemType(List<? extends CommonAppEntity> r10, int r11) {
        q.g(r10, "data");
        String r12 = r10.get(r11).getPkg();
        if (r12 == null) goto L9;
        if (o.r(r12) == true) goto L9;
        return ItemType.HORIZONTAL.ordinal();
    L9:
        return ItemType.BANNER.ordinal();
    }
}
