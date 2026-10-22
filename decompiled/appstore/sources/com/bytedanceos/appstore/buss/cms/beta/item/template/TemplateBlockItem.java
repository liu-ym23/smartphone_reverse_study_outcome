package com.bytedanceos.appstore.buss.cms.beta.item.template;

import com.bytedanceos.appstore.buss.cms.beta.ElementHelper;
import com.bytedanceos.appstore.buss.cms.beta.entity.BetaElementEntity;
import com.bytedanceos.appstore.buss.cms.beta.entity.element.BetaElementArrayEntity;
import com.bytedanceos.appstore.buss.cms.beta.item.TemplateItem;
import com.bytedanceos.appstore.buss.cms.beta.item.element.ElementBlockItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u00020\u00042\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006H\u0014¨\u0006\u0007"}, d2 = {"Lcom/bytedanceos/appstore/buss/cms/beta/item/template/TemplateBlockItem;", "Lcom/bytedanceos/appstore/buss/cms/beta/item/TemplateItem;", "()V", "parseElementEntity", "", "betaElementEntity", "Lcom/bytedanceos/appstore/buss/cms/beta/entity/BetaElementEntity;", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TemplateBlockItem extends TemplateItem {
    public TemplateBlockItem() {
    }

    @Override // com.bytedanceos.appstore.buss.cms.beta.item.TemplateItem
    public void parseElementEntity(@NotNull BetaElementEntity<?> r10) {
        q.g(r10, "betaElementEntity");
        if ((r10 instanceof BetaElementArrayEntity) == false) goto L6;
        List<ElementBlockItem> r11 = ElementHelper.INSTANCE.parseToGiantElementBlockItem((BetaElementArrayEntity) r10);
        getItemList().addAll(r11);
        return;
    }
}
