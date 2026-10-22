package com.bytedanceos.appstore.buss.adapter.app.pager.adapter;

import com.bytedanceos.appstore.buss.adapter.app.base.BasePagerAdapter;
import com.bytedanceos.appstore.buss.entity.AppEntityWrap;
import com.bytedanceos.appstore.buss.entity.item.ItemType;
import com.bytedanceos.common.networkv2.params.NetValue;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u0006H\u0014¨\u0006\u000b"}, d2 = {"Lcom/bytedanceos/appstore/buss/adapter/app/pager/adapter/AllRecommendAdapter;", "Lcom/bytedanceos/appstore/buss/adapter/app/base/BasePagerAdapter;", "pageName", "", "(Ljava/lang/String;)V", "getItemType", "", "data", "", "Lcom/bytedanceos/appstore/buss/entity/AppEntityWrap;", "position", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AllRecommendAdapter extends BasePagerAdapter {
    public AllRecommendAdapter(String r10) {
        super(r10);
    }

    @Override // com.chad.library.adapter.base.BaseProviderMultiAdapter
    public int getItemType(List<? extends AppEntityWrap> r10, int r11) {
        q.g(r10, "data");
        AppEntityWrap r12 = r10.get(r11);
        String r13 = r12.getTemplate();
        if (r13 == null) goto L23;
        int r14 = r13.hashCode();
        if (r14 == 1567) goto L20;
        switch(r14) {
            case 46730163: goto L16;
            case 46730164: goto L9;
            default: goto L23;
        };
    L9:
        if (r13.equals("10003") == false) goto L23;
        if (r12.getShow_count() < 9) goto L25;
        return ItemType.PAGER_HORIZONTAL.ordinal();
    L25:
        return ItemType.PAGER_VERTICAL.ordinal();
    L16:
        if (r13.equals("10002") == false) goto L23;
        return ItemType.PAGER_BANNER_SMALL.ordinal();
    L20:
        if (r13.equals(NetValue.AppStatusType.INSTALL_SUCCESS) == false) goto L23;
        return ItemType.PAGER_BANNER.ordinal();
    L23:
        return ItemType.EMPTY.ordinal();
    }
}
