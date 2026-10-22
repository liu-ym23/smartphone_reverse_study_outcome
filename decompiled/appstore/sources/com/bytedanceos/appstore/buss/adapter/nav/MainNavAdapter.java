package com.bytedanceos.appstore.buss.adapter.nav;

import com.bytedanceos.appstore.buss.constant.NavItemType;
import com.bytedanceos.appstore.buss.entity.NavEntityWrap;
import com.bytedanceos.appstore.buss.entity.NavTitleEntity;
import com.chad.library.adapter.base.BaseNodeAdapter;
import com.chad.library.adapter.base.entity.node.BaseNode;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001J%\u0010\u0007\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedanceos/appstore/buss/adapter/nav/MainNavAdapter;", "Lcom/chad/library/adapter/base/BaseNodeAdapter;", "", "Lcom/chad/library/adapter/base/entity/node/BaseNode;", "data", "", "position", "getItemType", "(Ljava/util/List;I)I", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class MainNavAdapter extends BaseNodeAdapter {
    @Override // com.chad.library.adapter.base.BaseProviderMultiAdapter
    public int getItemType(List<? extends BaseNode> r10, int r11) {
        q.g(r10, "data");
        BaseNode r12 = r10.get(r11);
        if ((r12 instanceof NavEntityWrap) == false) goto L6;
        return NavItemType.NAV_HEAD_TYPE.ordinal();
    L6:
        if ((r12 instanceof NavTitleEntity) == false) goto L10;
        return NavItemType.NAV_TITLE_TYPE.ordinal();
    L10:
        throw null;
    }
}
