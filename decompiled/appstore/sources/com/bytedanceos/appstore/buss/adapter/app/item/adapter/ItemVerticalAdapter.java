package com.bytedanceos.appstore.buss.adapter.app.item.adapter;

import com.bytedanceos.appstore.buss.adapter.app.item.provider.ItemVerticalProvider;
import com.bytedanceos.appstore.buss.entity.CommonAppEntity;
import com.bytedanceos.appstore.buss.entity.item.ItemType;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.module.LoadMoreModule;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0011\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u001e\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\n2\u0006\u0010\u000b\u001a\u00020\bH\u0014¨\u0006\f"}, d2 = {"Lcom/bytedanceos/appstore/buss/adapter/app/item/adapter/ItemVerticalAdapter;", "Lcom/chad/library/adapter/base/BaseProviderMultiAdapter;", "Lcom/bytedanceos/appstore/buss/entity/CommonAppEntity;", "Lcom/chad/library/adapter/base/module/LoadMoreModule;", "pageSource", "", "(Ljava/lang/String;)V", "getItemType", "", "data", "", "position", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ItemVerticalAdapter extends BaseProviderMultiAdapter<CommonAppEntity> implements LoadMoreModule {
    /* JADX WARN: Multi-variable type inference failed */
    public ItemVerticalAdapter() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // com.chad.library.adapter.base.BaseProviderMultiAdapter
    public int getItemType(List<? extends CommonAppEntity> r10, int r11) {
        q.g(r10, "data");
        return ItemType.VERTICAL.ordinal();
    }

    public ItemVerticalAdapter(String r10) {
        super(null, 1, null);
        ItemVerticalProvider r11 = new ItemVerticalProvider();
        r11.b(r10);
        addItemProvider(r11);
    }

    public /* synthetic */ ItemVerticalAdapter(String r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 1) == 0) goto L5;
        r10 = "";
    L5:
        this(r10);
    }
}
