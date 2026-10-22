package com.obric.appstore.ui.adapter;

import com.bytedanceos.common.model.AppInfo;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.module.LoadMoreModule;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001e\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\f2\u0006\u0010\r\u001a\u00020\nH\u0014¨\u0006\u000e"}, d2 = {"Lcom/obric/appstore/ui/adapter/ItemHorizontalAppAdapter;", "Lcom/chad/library/adapter/base/BaseProviderMultiAdapter;", "Lcom/bytedanceos/common/model/AppInfo;", "Lcom/chad/library/adapter/base/module/LoadMoreModule;", "pageSource", "", "pager", "", "(Ljava/lang/String;Z)V", "getItemType", "", "data", "", "position", "obriccommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ItemHorizontalAppAdapter extends BaseProviderMultiAdapter<AppInfo> implements LoadMoreModule {
    public ItemHorizontalAppAdapter(String r14, boolean r15) {
        q.g(r14, "pageSource");
        super(null, 1, null);
        addItemProvider(new ItemAppProvider(r14, r15, false, null, null, false, true, 0.0f, 188, null));
    }

    @Override // com.chad.library.adapter.base.BaseProviderMultiAdapter
    public int getItemType(List<? extends AppInfo> r10, int r11) {
        q.g(r10, "data");
        return ItemType.APP.ordinal();
    }
}
