package com.bytedanceos.appstore.buss.adapter.app.pager.adapter;

import com.bytedanceos.appstore.buss.adapter.app.base.BasePagerAdapter;
import com.bytedanceos.appstore.buss.entity.AppEntityWrap;
import com.bytedanceos.appstore.buss.entity.item.ItemType;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001d\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J%\u0010\r\u001a\u00020\u000b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\f\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedanceos/appstore/buss/adapter/app/pager/adapter/PagerTypeAdapter;", "Lcom/bytedanceos/appstore/buss/adapter/app/base/BasePagerAdapter;", "Lcom/bytedanceos/appstore/buss/entity/item/ItemType;", "itemType", "", "pageSource", "<init>", "(Lcom/bytedanceos/appstore/buss/entity/item/ItemType;Ljava/lang/String;)V", "", "Lcom/bytedanceos/appstore/buss/entity/AppEntityWrap;", "data", "", "position", "getItemType", "(Ljava/util/List;I)I", "h", "Lcom/bytedanceos/appstore/buss/entity/item/ItemType;", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PagerTypeAdapter extends BasePagerAdapter {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ItemType f8374h;

    /* JADX WARN: Multi-variable type inference failed */
    public PagerTypeAdapter() {
        Object[] r10 = 0 == true ? 1 : 0;
        this(null, r10, 3, 0 == true ? 1 : 0);
    }

    @Override // com.chad.library.adapter.base.BaseProviderMultiAdapter
    public int getItemType(List<? extends AppEntityWrap> r10, int r11) {
        q.g(r10, "data");
        return this.f8374h.ordinal();
    }

    public /* synthetic */ PagerTypeAdapter(ItemType r10, String r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 1) == 0) goto L6;
        r10 = ItemType.PAGER_HORIZONTAL;
    L6:
        if ((r12 & 2) == 0) goto L8;
        r11 = "";
    L8:
        this(r10, r11);
    }

    public PagerTypeAdapter(ItemType r10, String r11) {
        q.g(r10, "itemType");
        super(r11);
        this.f8374h = r10;
    }
}
