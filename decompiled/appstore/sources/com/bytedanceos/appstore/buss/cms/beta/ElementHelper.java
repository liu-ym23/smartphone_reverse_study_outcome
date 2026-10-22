package com.bytedanceos.appstore.buss.cms.beta;

import com.bytedanceos.appstore.buss.cms.beta.entity.BetaElementEntity;
import com.bytedanceos.appstore.buss.cms.beta.entity.element.BetaElementArrayEntity;
import com.bytedanceos.appstore.buss.cms.beta.entity.element.BetaElementJumpEntity;
import com.bytedanceos.appstore.buss.cms.beta.entity.element.BetaElementPictureEntity;
import com.bytedanceos.appstore.buss.cms.beta.entity.element.BetaElementTextEntity;
import com.bytedanceos.appstore.buss.cms.beta.entity.element.ElementArrayInfoEntity;
import com.bytedanceos.appstore.buss.cms.beta.entity.element.ElementPictureInfoEntity;
import com.bytedanceos.appstore.buss.cms.beta.entity.element.ElementTextInfoEntity;
import com.bytedanceos.appstore.buss.cms.beta.item.element.ElementBigBannerItem;
import com.bytedanceos.appstore.buss.cms.beta.item.element.ElementBlockItem;
import com.bytedanceos.appstore.buss.cms.beta.item.element.ElementFirstHorTitleItem;
import com.bytedanceos.appstore.buss.cms.beta.item.element.ElementHorTitleItem;
import com.bytedanceos.appstore.buss.cms.beta.item.element.ElementPrimaryNavigationItem;
import com.bytedanceos.appstore.buss.cms.beta.item.element.ElementSmallBannerItem;
import com.bytedanceos.appstore.buss.cms.beta.item.element.PageConfigItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007J\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00042\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u0007J\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00042\u0006\u0010\u0006\u001a\u00020\u0007J\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u00042\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\u0014"}, d2 = {"Lcom/bytedanceos/appstore/buss/cms/beta/ElementHelper;", "", "()V", "parseToGiantBigBannerItem", "", "Lcom/bytedanceos/appstore/buss/cms/beta/item/element/ElementBigBannerItem;", "elementEntity", "Lcom/bytedanceos/appstore/buss/cms/beta/entity/element/BetaElementArrayEntity;", "parseToGiantElementBlockItem", "Lcom/bytedanceos/appstore/buss/cms/beta/item/element/ElementBlockItem;", "parseToGiantElementFirstHorTitleItem", "Lcom/bytedanceos/appstore/buss/cms/beta/item/element/ElementFirstHorTitleItem;", "parseToGiantElementHorTitleItem", "Lcom/bytedanceos/appstore/buss/cms/beta/item/element/ElementHorTitleItem;", "parseToGiantElementPrimaryNavigationItem", "Lcom/bytedanceos/appstore/buss/cms/beta/item/element/ElementPrimaryNavigationItem;", "parseToGiantElementSmallBannerItem", "Lcom/bytedanceos/appstore/buss/cms/beta/item/element/ElementSmallBannerItem;", "parseToGiantPageConfigItem", "Lcom/bytedanceos/appstore/buss/cms/beta/item/element/PageConfigItem;", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nElementHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ElementHelper.kt\ncom/bytedanceos/appstore/buss/cms/beta/ElementHelper\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,204:1\n1855#2:205\n1855#2,2:206\n1856#2:208\n1855#2,2:209\n1855#2,2:211\n1855#2,2:213\n1855#2:215\n1855#2,2:216\n1856#2:218\n1855#2:219\n1855#2,2:220\n1856#2:222\n1855#2:223\n1855#2,2:224\n1856#2:226\n*S KotlinDebug\n*F\n+ 1 ElementHelper.kt\ncom/bytedanceos/appstore/buss/cms/beta/ElementHelper\n*L\n19#1:205\n22#1:206,2\n19#1:208\n49#1:209,2\n82#1:211,2\n105#1:213,2\n132#1:215\n135#1:216,2\n132#1:218\n156#1:219\n159#1:220,2\n156#1:222\n183#1:223\n186#1:224,2\n183#1:226\n*E\n"})
public final class ElementHelper {

    @NotNull
    public static final ElementHelper INSTANCE = null;

    static {
        INSTANCE = new ElementHelper();
    }

    private ElementHelper() {
    }

    @NotNull
    public final List<ElementBigBannerItem> parseToGiantBigBannerItem(@NotNull BetaElementArrayEntity r10) {
        q.g(r10, "elementEntity");
        ArrayList r11 = new ArrayList();
        ElementArrayInfoEntity r12 = r10.getElementInfo();
        if (r12 == null) goto L25;
        List<List<BetaElementEntity<?>>> r13 = r12.getValue();
        if (r13 == null) goto L25;
        Iterator<T> r14 = r13.iterator();
    L8:
        if (r14.hasNext() == false) goto L25;
        List r15 = (List) r14.next();
        ElementBigBannerItem r16 = new ElementBigBannerItem(null, 1, null);
        Iterator r17 = r15.iterator();
    L11:
        if (r17.hasNext() == false) goto L23;
        BetaElementEntity r18 = (BetaElementEntity) r17.next();
        if ((r18 instanceof BetaElementPictureEntity) == true) goto L14;
        if ((r18 instanceof BetaElementJumpEntity) == false) goto L11;
        r16.setJumpInfo(((BetaElementJumpEntity) r18).getElementInfo());
        goto L11
    L14:
        ElementPictureInfoEntity r19 = ((BetaElementPictureEntity) r18).getElementInfo();
        if (r19 == null) goto L17;
        String r20 = r19.getValue();
    L18:
        r16.setPicture(r20);
        goto L11
    L17:
        r20 = null;
        goto L18
    L23:
        if (r16.isAvailable() == false) goto L8;
        r11.add(r16);
    L25:
        return r11;
    }

    @NotNull
    public final List<ElementBlockItem> parseToGiantElementBlockItem(@NotNull BetaElementArrayEntity r10) {
        q.g(r10, "elementEntity");
        ArrayList r11 = new ArrayList();
        ElementArrayInfoEntity r12 = r10.getElementInfo();
        if (r12 == null) goto L32;
        List<List<BetaElementEntity<?>>> r13 = r12.getValue();
        if (r13 == null) goto L32;
        Iterator<T> r14 = r13.iterator();
    L8:
        if (r14.hasNext() == false) goto L32;
        List r15 = (List) r14.next();
        ElementBlockItem r16 = new ElementBlockItem(null, null, 3, null);
        Iterator r17 = r15.iterator();
    L11:
        if (r17.hasNext() == false) goto L30;
        BetaElementEntity r18 = (BetaElementEntity) r17.next();
        if ((r18 instanceof BetaElementTextEntity) == true) goto L14;
        if ((r18 instanceof BetaElementPictureEntity) == true) goto L21;
        if ((r18 instanceof BetaElementJumpEntity) == false) goto L11;
        r16.setJumpInfo(((BetaElementJumpEntity) r18).getElementInfo());
        goto L11
    L21:
        ElementPictureInfoEntity r19 = ((BetaElementPictureEntity) r18).getElementInfo();
        if (r19 == null) goto L24;
        String r20 = r19.getValue();
    L25:
        r16.setPicture(r20);
        goto L11
    L24:
        r20 = null;
        goto L25
    L14:
        ElementTextInfoEntity r21 = ((BetaElementTextEntity) r18).getElementInfo();
        if (r21 == null) goto L17;
        String r22 = r21.getValue();
    L18:
        r16.setTitle(r22);
        goto L11
    L17:
        r22 = null;
        goto L18
    L30:
        if (r16.isAvailable() == false) goto L8;
        r11.add(r16);
    L32:
        return r11;
    }

    @NotNull
    public final ElementFirstHorTitleItem parseToGiantElementFirstHorTitleItem(@NotNull BetaElementArrayEntity r10) {
        q.g(r10, "elementEntity");
        ElementFirstHorTitleItem r11 = new ElementFirstHorTitleItem(null, 1, null);
        ElementArrayInfoEntity r12 = r10.getElementInfo();
        if (r12 == null) goto L20;
        List<List<BetaElementEntity<?>>> r13 = r12.getValue();
        if (r13 == null) goto L20;
        List<BetaElementEntity<?>> r14 = r13.get(0);
        if (r14 == null) goto L20;
        Iterator<T> r15 = r14.iterator();
    L10:
        if (r15.hasNext() == false) goto L20;
        BetaElementEntity r16 = (BetaElementEntity) r15.next();
        if ((r16 instanceof BetaElementTextEntity) == false) goto L10;
        if (q.b(r16.getElementKey(), "title") == false) goto L10;
        ElementTextInfoEntity r17 = ((BetaElementTextEntity) r16).getElementInfo();
        if (r17 == null) goto L18;
        String r18 = r17.getValue();
    L19:
        r11.setTitle(r18);
        goto L10
    L18:
        r18 = null;
    L20:
        return r11;
    }

    @NotNull
    public final ElementHorTitleItem parseToGiantElementHorTitleItem(@NotNull BetaElementArrayEntity r10) {
        q.g(r10, "elementEntity");
        String r11 = null;
        String r12 = null;
        boolean r13 = false;
        String r14 = null;
        ElementHorTitleItem r15 = new ElementHorTitleItem(r11, r12, r13, r14, 15, null);
        ElementArrayInfoEntity r16 = r10.getElementInfo();
        if (r16 == null) goto L46;
        List<List<BetaElementEntity<?>>> r17 = r16.getValue();
        if (r17 == null) goto L46;
        List<BetaElementEntity<?>> r18 = r17.get(0);
        if (r18 == null) goto L46;
        Iterator<T> r19 = r18.iterator();
    L10:
        if (r19.hasNext() == false) goto L46;
        BetaElementEntity r20 = (BetaElementEntity) r19.next();
        if ((r20 instanceof BetaElementTextEntity) == true) goto L13;
        if ((r20 instanceof BetaElementJumpEntity) == false) goto L10;
        r15.setJumpInfo(((BetaElementJumpEntity) r20).getElementInfo());
        goto L10
    L13:
        String r21 = r20.getElementKey();
        String r22 = null;
        switch(r21.hashCode()) {
            case -1759410662: goto L37;
            case -42298471: goto L30;
            case 54289076: goto L23;
            case 110371416: goto L17;
            default: goto L10;
        };
    L17:
        if (r21.equals("title") == false) goto L10;
        ElementTextInfoEntity r23 = ((BetaElementTextEntity) r20).getElementInfo();
        if (r23 == null) goto L21;
        r22 = r23.getValue();
    L21:
        r15.setTitle(r22);
        goto L10
    L23:
        if (r21.equals(BetaElementTextEntity.Key.SHOW_BUTTON) == false) goto L10;
        ElementTextInfoEntity r24 = ((BetaElementTextEntity) r20).getElementInfo();
        if (r24 == null) goto L28;
        r22 = r24.getValue();
    L28:
        r15.setShowButton(q.b("true", r22));
        goto L10
    L30:
        if (r21.equals(BetaElementTextEntity.Key.SUB_TITLE) == false) goto L10;
        ElementTextInfoEntity r25 = ((BetaElementTextEntity) r20).getElementInfo();
        if (r25 == null) goto L35;
        r22 = r25.getValue();
    L35:
        r15.setSubTitle(r22);
        goto L10
    L37:
        if (r21.equals(BetaElementTextEntity.Key.BUTTON_TEXT) == false) goto L10;
        ElementTextInfoEntity r26 = ((BetaElementTextEntity) r20).getElementInfo();
        if (r26 == null) goto L42;
        r22 = r26.getValue();
    L42:
        r15.setButtonText(r22);
    L46:
        return r15;
    }

    @NotNull
    public final List<ElementPrimaryNavigationItem> parseToGiantElementPrimaryNavigationItem(@NotNull BetaElementArrayEntity r10) {
        q.g(r10, "elementEntity");
        ArrayList r11 = new ArrayList();
        ElementArrayInfoEntity r12 = r10.getElementInfo();
        if (r12 == null) goto L35;
        List<List<BetaElementEntity<?>>> r13 = r12.getValue();
        if (r13 == null) goto L35;
        Iterator<T> r14 = r13.iterator();
    L8:
        if (r14.hasNext() == false) goto L35;
        List r15 = (List) r14.next();
        ElementPrimaryNavigationItem r16 = new ElementPrimaryNavigationItem(null, null, 3, null);
        Iterator r17 = r15.iterator();
    L11:
        if (r17.hasNext() == false) goto L33;
        BetaElementEntity r18 = (BetaElementEntity) r17.next();
        if ((r18 instanceof BetaElementTextEntity) == false) goto L11;
        String r19 = r18.getElementKey();
        String r20 = "";
        if (q.b(r19, BetaElementTextEntity.Key.NAVIGATION_TITLE) == true) goto L16;
        if (q.b(r19, BetaElementTextEntity.Key.NAVIGATION_PAGE_ID) == false) goto L11;
        ElementTextInfoEntity r21 = ((BetaElementTextEntity) r18).getElementInfo();
        if (r21 == null) goto L31;
        String r22 = r21.getValue();
        if (r22 == null) goto L31;
        r20 = r22;
    L31:
        r16.setNavPageId(r20);
        goto L11
    L16:
        ElementTextInfoEntity r23 = ((BetaElementTextEntity) r18).getElementInfo();
        if (r23 == null) goto L22;
        String r24 = r23.getValue();
        if (r24 == null) goto L22;
        r20 = r24;
    L22:
        r16.setNavTitle(r20);
        goto L11
    L33:
        if (r16.isAvailable() == false) goto L8;
        r11.add(r16);
    L35:
        return r11;
    }

    @NotNull
    public final List<ElementSmallBannerItem> parseToGiantElementSmallBannerItem(@NotNull BetaElementArrayEntity r10) {
        q.g(r10, "elementEntity");
        ArrayList r11 = new ArrayList();
        ElementArrayInfoEntity r12 = r10.getElementInfo();
        if (r12 == null) goto L25;
        List<List<BetaElementEntity<?>>> r13 = r12.getValue();
        if (r13 == null) goto L25;
        Iterator<T> r14 = r13.iterator();
    L8:
        if (r14.hasNext() == false) goto L25;
        List r15 = (List) r14.next();
        ElementSmallBannerItem r16 = new ElementSmallBannerItem(null, 1, null);
        Iterator r17 = r15.iterator();
    L11:
        if (r17.hasNext() == false) goto L23;
        BetaElementEntity r18 = (BetaElementEntity) r17.next();
        if ((r18 instanceof BetaElementPictureEntity) == true) goto L14;
        if ((r18 instanceof BetaElementJumpEntity) == false) goto L11;
        r16.setJumpInfo(((BetaElementJumpEntity) r18).getElementInfo());
        goto L11
    L14:
        ElementPictureInfoEntity r19 = ((BetaElementPictureEntity) r18).getElementInfo();
        if (r19 == null) goto L17;
        String r20 = r19.getValue();
    L18:
        r16.setPicture(r20);
        goto L11
    L17:
        r20 = null;
        goto L18
    L23:
        if (r16.isAvailable() == false) goto L8;
        r11.add(r16);
    L25:
        return r11;
    }

    @NotNull
    public final PageConfigItem parseToGiantPageConfigItem(@NotNull BetaElementArrayEntity r10) {
        q.g(r10, "elementEntity");
        PageConfigItem r11 = new PageConfigItem(null, false, null, 7, null);
        ElementArrayInfoEntity r12 = r10.getElementInfo();
        if (r12 == null) goto L31;
        List<List<BetaElementEntity<?>>> r13 = r12.getValue();
        if (r13 == null) goto L31;
        List<BetaElementEntity<?>> r14 = r13.get(0);
        if (r14 == null) goto L31;
        Iterator<T> r15 = r14.iterator();
    L10:
        if (r15.hasNext() == false) goto L31;
        BetaElementEntity r16 = (BetaElementEntity) r15.next();
        String r17 = null;
        if ((r16 instanceof BetaElementTextEntity) == true) goto L13;
        if ((r16 instanceof BetaElementPictureEntity) == false) goto L10;
        ElementPictureInfoEntity r18 = ((BetaElementPictureEntity) r16).getElementInfo();
        if (r18 == null) goto L30;
        r17 = r18.getValue();
    L30:
        r11.setPageBackground(r17);
        goto L10
    L13:
        String r19 = r16.getElementKey();
        if (q.b(r19, "page_title") == true) goto L15;
        if (q.b(r19, BetaElementTextEntity.Key.SHOW_SEARCH) == false) goto L10;
        ElementTextInfoEntity r20 = ((BetaElementTextEntity) r16).getElementInfo();
        if (r20 == null) goto L24;
        r17 = r20.getValue();
    L24:
        r11.setShowSearch(q.b("true", r17));
        goto L10
    L15:
        ElementTextInfoEntity r21 = ((BetaElementTextEntity) r16).getElementInfo();
        if (r21 == null) goto L18;
        r17 = r21.getValue();
    L18:
        r11.setPageTitle(r17);
    L31:
        return r11;
    }
}
