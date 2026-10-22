package com.bytedanceos.appstore.buss.cms.beta.item.template;

import com.bytedanceos.appstore.buss.cms.beta.ElementHelper;
import com.bytedanceos.appstore.buss.cms.beta.entity.BetaElementEntity;
import com.bytedanceos.appstore.buss.cms.beta.entity.element.BetaElementAppListEntity;
import com.bytedanceos.appstore.buss.cms.beta.entity.element.BetaElementArrayEntity;
import com.bytedanceos.appstore.buss.cms.beta.item.TemplateAppItem;
import com.bytedanceos.appstore.buss.cms.beta.item.element.ElementFirstHorTitleItem;
import com.bytedanceos.appstore.buss.cms.beta.item.element.ElementFirstVerAppSquareItem;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0007H\u0014¨\u0006\b"}, d2 = {"Lcom/bytedanceos/appstore/buss/cms/beta/item/template/TemplateFirstVerAppSquareItem;", "Lcom/bytedanceos/appstore/buss/cms/beta/item/TemplateAppItem;", "Lcom/bytedanceos/appstore/buss/cms/beta/item/element/ElementFirstVerAppSquareItem;", "()V", "parseElementEntity", "", "betaElementEntity", "Lcom/bytedanceos/appstore/buss/cms/beta/entity/BetaElementEntity;", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TemplateFirstVerAppSquareItem extends TemplateAppItem<ElementFirstVerAppSquareItem> {
    public TemplateFirstVerAppSquareItem() {
    }

    @Override // com.bytedanceos.appstore.buss.cms.beta.item.TemplateAppItem, com.bytedanceos.appstore.buss.cms.beta.item.TemplateItem
    public void parseElementEntity(@NotNull BetaElementEntity<?> r10) {
        q.g(r10, "betaElementEntity");
        if ((r10 instanceof BetaElementArrayEntity) == false) goto L8;
        ElementFirstHorTitleItem r11 = ElementHelper.INSTANCE.parseToGiantElementFirstHorTitleItem((BetaElementArrayEntity) r10);
        if (r11.isAvailable() == false) goto L11;
        getItemList().add(r11);
        return;
    L11:
        return;
    L8:
        if ((r10 instanceof BetaElementAppListEntity) == false) goto L13;
        parseToAppItemList((BetaElementAppListEntity) r10);
        return;
    }
}
