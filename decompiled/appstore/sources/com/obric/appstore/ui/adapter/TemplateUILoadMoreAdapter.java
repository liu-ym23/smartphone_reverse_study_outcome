package com.obric.appstore.ui.adapter;

import com.obric.appstore.base.BaseLoadMoreListAdapter;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J%\u0010\t\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/obric/appstore/ui/adapter/TemplateUILoadMoreAdapter;", "Lcom/obric/appstore/base/BaseLoadMoreListAdapter;", "Lza/f;", "<init>", "()V", "", "data", "", "position", "getItemType", "(Ljava/util/List;I)I", "obriccommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TemplateUILoadMoreAdapter extends BaseLoadMoreListAdapter<za.f> {
    public TemplateUILoadMoreAdapter() {
    }

    @Override // com.obric.appstore.base.BaseListAdapter, com.chad.library.adapter.base.BaseProviderMultiAdapter
    public int getItemType(List r10, int r11) {
        q.g(r10, "data");
        return ((za.f) r10.get(r11)).a().ordinal();
    }
}
