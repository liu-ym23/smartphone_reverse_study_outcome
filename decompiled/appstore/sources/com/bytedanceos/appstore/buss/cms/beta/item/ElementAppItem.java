package com.bytedanceos.appstore.buss.cms.beta.item;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/bytedanceos/appstore/buss/cms/beta/item/ElementAppItem;", "Lcom/bytedanceos/appstore/buss/cms/beta/item/ElementItem;", "()V", "isAvailable", "", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class ElementAppItem extends ElementItem {
    public ElementAppItem() {
    }

    @Override // com.bytedanceos.appstore.buss.cms.beta.item.ElementItem
    public boolean isAvailable() {
        return true;
    }
}
