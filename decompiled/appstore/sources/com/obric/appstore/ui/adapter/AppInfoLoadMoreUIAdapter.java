package com.obric.appstore.ui.adapter;

import com.bytedanceos.common.model.AppInfo;
import com.obric.appstore.base.BaseLoadMoreListAdapter;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0014¨\u0006\t"}, d2 = {"Lcom/obric/appstore/ui/adapter/AppInfoLoadMoreUIAdapter;", "Lcom/obric/appstore/base/BaseLoadMoreListAdapter;", "Lcom/bytedanceos/common/model/AppInfo;", "()V", "getItemType", "", "data", "", "position", "obriccommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AppInfoLoadMoreUIAdapter extends BaseLoadMoreListAdapter<AppInfo> {
    public AppInfoLoadMoreUIAdapter() {
    }

    @Override // com.obric.appstore.base.BaseListAdapter, com.chad.library.adapter.base.BaseProviderMultiAdapter
    public int getItemType(List r10, int r11) {
        q.g(r10, "data");
        return ItemType.APP.ordinal();
    }
}
