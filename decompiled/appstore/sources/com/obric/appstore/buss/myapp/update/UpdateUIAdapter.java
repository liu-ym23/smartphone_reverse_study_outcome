package com.obric.appstore.buss.myapp.update;

import com.obric.appstore.base.BaseListAdapter;
import com.obric.appstore.ui.adapter.ItemType;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J%\u0010\t\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/obric/appstore/buss/myapp/update/UpdateUIAdapter;", "Lcom/obric/appstore/base/BaseListAdapter;", "Lcom/obric/appstore/buss/myapp/update/e;", "<init>", "()V", "", "data", "", "position", "getItemType", "(Ljava/util/List;I)I", "obriccommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class UpdateUIAdapter extends BaseListAdapter<e> {
    public UpdateUIAdapter() {
    }

    @Override // com.obric.appstore.base.BaseListAdapter, com.chad.library.adapter.base.BaseProviderMultiAdapter
    public int getItemType(List r10, int r11) {
        q.g(r10, "data");
        e r12 = (e) r10.get(r11);
        if ((r12 instanceof e.a) == false) goto L6;
        return ItemType.APP.ordinal();
    L6:
        if ((r12 instanceof e.b) == false) goto L9;
        return ItemType.IGNORE_UPDATE_TITLE.ordinal();
    L9:
        if ((r12 instanceof e.c) == false) goto L13;
        return ItemType.SIGN_NOT_MATCH.ordinal();
    L13:
        throw new NoWhenBranchMatchedException();
    }
}
