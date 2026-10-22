package com.bytedanceos.appstore.buss.cms.beta.item;

import com.bytedanceos.appstore.buss.cms.beta.entity.BetaElementEntity;
import com.bytedanceos.appstore.buss.cms.beta.entity.BetaTemplateEntity;
import com.bytedanceos.appstore.buss.cms.beta.item.element.ElementFirstHorTitleItem;
import com.bytedanceos.appstore.buss.cms.beta.item.element.ElementHorTitleItem;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0016J\u0014\u0010\u000b\u001a\u00020\f2\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u000eH$J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R!\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/bytedanceos/appstore/buss/cms/beta/item/TemplateItem;", "", "()V", "itemList", "Ljava/util/ArrayList;", "Lcom/bytedanceos/appstore/buss/cms/beta/item/ElementItem;", "Lkotlin/collections/ArrayList;", "getItemList", "()Ljava/util/ArrayList;", "isAvailable", "", "parseElementEntity", "", "betaElementEntity", "Lcom/bytedanceos/appstore/buss/cms/beta/entity/BetaElementEntity;", "setTemplateEntity", "betaTemplateEntity", "Lcom/bytedanceos/appstore/buss/cms/beta/entity/BetaTemplateEntity;", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nTemplateItem.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TemplateItem.kt\ncom/bytedanceos/appstore/buss/cms/beta/item/TemplateItem\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,41:1\n1855#2,2:42\n*S KotlinDebug\n*F\n+ 1 TemplateItem.kt\ncom/bytedanceos/appstore/buss/cms/beta/item/TemplateItem\n*L\n20#1:42,2\n*E\n"})
public abstract class TemplateItem {

    @NotNull
    private final ArrayList<ElementItem> itemList;

    public TemplateItem() {
        this.itemList = new ArrayList();
    }

    @NotNull
    public final ArrayList<ElementItem> getItemList() {
        return this.itemList;
    }

    public boolean isAvailable() {
        if (this.itemList.isEmpty() == false) goto L6;
        return false;
    L6:
        if (this.itemList.size() != 1) goto L13;
        ElementItem r10 = this.itemList.get(0);
        q.f(r10, "get(...)");
        ElementItem r11 = r10;
        if ((r11 instanceof ElementHorTitleItem) == false) goto L11;
        return false;
    L11:
        if ((r11 instanceof ElementFirstHorTitleItem) == false) goto L13;
        return false;
    L13:
        return true;
    }

    public abstract void parseElementEntity(@NotNull BetaElementEntity<?> r10);

    public void setTemplateEntity(@NotNull BetaTemplateEntity r10) {
        q.g(r10, "betaTemplateEntity");
        Iterator<T> r11 = r10.getBetaElementList().iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        parseElementEntity((BetaElementEntity) r11.next());
        goto L4
    }
}
