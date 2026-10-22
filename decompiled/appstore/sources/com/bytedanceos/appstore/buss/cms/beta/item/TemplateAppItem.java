package com.bytedanceos.appstore.buss.cms.beta.item;

import com.bytedanceos.appstore.buss.cms.beta.ElementHelper;
import com.bytedanceos.appstore.buss.cms.beta.entity.BetaElementEntity;
import com.bytedanceos.appstore.buss.cms.beta.entity.element.BetaElementAppListEntity;
import com.bytedanceos.appstore.buss.cms.beta.entity.element.BetaElementArrayEntity;
import com.bytedanceos.appstore.buss.cms.beta.entity.element.ElementAppListInfoEntity;
import com.bytedanceos.appstore.buss.cms.beta.item.ElementAppItem;
import com.bytedanceos.appstore.buss.cms.beta.item.element.ElementHorTitleItem;
import com.bytedanceos.appstore.buss.entity.CommonAppEntity;
import com.bytedanceos.appstore.buss.entity.item.CommonAppItem;
import com.bytedanceos.appstore.buss.utilities.CommonUtil;
import com.bytedanceos.common.model.AppInfo;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.q;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0014\u0010\u0005\u001a\u00020\u00062\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\bH\u0014J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/bytedanceos/appstore/buss/cms/beta/item/TemplateAppItem;", "E", "Lcom/bytedanceos/appstore/buss/cms/beta/item/ElementAppItem;", "Lcom/bytedanceos/appstore/buss/cms/beta/item/TemplateItem;", "()V", "parseElementEntity", "", "betaElementEntity", "Lcom/bytedanceos/appstore/buss/cms/beta/entity/BetaElementEntity;", "parseToAppItemList", "elementEntity", "Lcom/bytedanceos/appstore/buss/cms/beta/entity/element/BetaElementAppListEntity;", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nTemplateAppItem.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TemplateAppItem.kt\ncom/bytedanceos/appstore/buss/cms/beta/item/TemplateAppItem\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,72:1\n1855#2,2:73\n*S KotlinDebug\n*F\n+ 1 TemplateAppItem.kt\ncom/bytedanceos/appstore/buss/cms/beta/item/TemplateAppItem\n*L\n57#1:73,2\n*E\n"})
public abstract class TemplateAppItem<E extends ElementAppItem> extends TemplateItem {
    public TemplateAppItem() {
    }

    @Override // com.bytedanceos.appstore.buss.cms.beta.item.TemplateItem
    public void parseElementEntity(@NotNull BetaElementEntity<?> r10) {
        q.g(r10, "betaElementEntity");
        if ((r10 instanceof BetaElementArrayEntity) == false) goto L8;
        ElementHorTitleItem r11 = ElementHelper.INSTANCE.parseToGiantElementHorTitleItem((BetaElementArrayEntity) r10);
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

    public void parseToAppItemList(@NotNull BetaElementAppListEntity r10) {
        q.g(r10, "elementEntity");
        if (getItemList().size() <= 0) goto L16;
        ElementItem r11 = getItemList().get(0);
        q.f(r11, "get(...)");
        ElementItem r12 = r11;
        if ((r12 instanceof ElementHorTitleItem) == false) goto L16;
        if (r12.isAvailable() == false) goto L16;
        ElementHorTitleItem r13 = (ElementHorTitleItem) r12;
        String r14 = r13.getButtonText();
        if (r14 == null) goto L16;
        if (o.r(r14) == true) goto L16;
        if (r13.getShowButton() == false) goto L16;
        ArrayList r15 = new ArrayList();
        r13.setAppList(r15);
    L17:
        ElementAppListInfoEntity r16 = r10.getElementInfo();
        if (r16 == null) goto L38;
        List<CommonAppEntity> r17 = r16.getValue();
        if (r17 == null) goto L50;
        Iterator<T> r18 = r17.iterator();
    L23:
        if (r18.hasNext() == false) goto L51;
        CommonAppEntity r19 = (CommonAppEntity) r18.next();
        Class r20 = CommonUtil.f8830a.e(this);
        if (r20 == null) goto L29;
        Constructor r21 = r20.getConstructor(new Class[]{CommonAppEntity.class});
        if (r21 == null) goto L29;
        ElementAppItem r22 = (ElementAppItem) r21.newInstance(new Object[]{r19});
    L30:
        if (r22 == null) goto L23;
        getItemList().add(r22);
        CommonAppItem r23 = r19.getItem();
        if (r23 == null) goto L23;
        AppInfo r24 = r23.getAppInfo();
        if (r24 == null) goto L23;
        q.d(r24);
        if (r15 == null) goto L23;
        r15.add(r24);
    L29:
        r22 = null;
        goto L30
    L51:
        return;
    L50:
        return;
    L38:
        return;
    L16:
        r15 = null;
        goto L17
    }
}
