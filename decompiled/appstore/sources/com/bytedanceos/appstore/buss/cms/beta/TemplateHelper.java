package com.bytedanceos.appstore.buss.cms.beta;

import com.bytedanceos.appstore.buss.cms.beta.entity.BetaTemplateEntity;
import com.bytedanceos.appstore.buss.cms.beta.item.TemplateItem;
import com.bytedanceos.appstore.buss.cms.beta.item.template.TemplateBlockItem;
import com.bytedanceos.appstore.buss.cms.beta.item.template.TemplateCarouselBannerItem;
import com.bytedanceos.appstore.buss.cms.beta.item.template.TemplateFirstVerAppSquareItem;
import com.bytedanceos.appstore.buss.cms.beta.item.template.TemplateHorAppRectItem;
import com.bytedanceos.appstore.buss.cms.beta.item.template.TemplateHorAppSquareItem;
import com.bytedanceos.appstore.buss.cms.beta.item.template.TemplatePageConfigItem;
import com.bytedanceos.appstore.buss.cms.beta.item.template.TemplatePrimaryNavigationItem;
import com.bytedanceos.appstore.buss.cms.beta.item.template.TemplateSmallBannerItem;
import com.bytedanceos.appstore.buss.cms.beta.item.template.TemplateVerAppSquareItem;
import com.bytedanceos.appstore.buss.cms.beta.item.template.TemplateVideoAppGridItem;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.k0;
import kotlin.d;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\bR\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/bytedanceos/appstore/buss/cms/beta/TemplateHelper;", "", "()V", "templateItemMap", "", "", "Ljava/lang/Class;", "buildTemplateItemList", "", "Lcom/bytedanceos/appstore/buss/cms/beta/item/TemplateItem;", "betaTemplateEntityList", "Lcom/bytedanceos/appstore/buss/cms/beta/entity/BetaTemplateEntity;", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nTemplateHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TemplateHelper.kt\ncom/bytedanceos/appstore/buss/cms/beta/TemplateHelper\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,58:1\n1855#2,2:59\n*S KotlinDebug\n*F\n+ 1 TemplateHelper.kt\ncom/bytedanceos/appstore/buss/cms/beta/TemplateHelper\n*L\n44#1:59,2\n*E\n"})
public final class TemplateHelper {

    @NotNull
    public static final TemplateHelper INSTANCE = null;

    @NotNull
    private static final Map<String, Class<?>> templateItemMap = null;

    static {
        INSTANCE = new TemplateHelper();
        templateItemMap = k0.j(new Pair[]{d.a("giant_navigation", TemplatePrimaryNavigationItem.class), d.a("giant_page_config", TemplatePageConfigItem.class), d.a("giant_block_grid", TemplateBlockItem.class), d.a("giant_carousel_banner_list", TemplateCarouselBannerItem.class), d.a("giant_small_banner_grid", TemplateSmallBannerItem.class), d.a("giant_hor_rect_app_grid", TemplateHorAppRectItem.class), d.a("giant_hor_square_app_grid", TemplateHorAppSquareItem.class), d.a("giant_ver_square_app_grid", TemplateVerAppSquareItem.class), d.a("giant_video_app_grid", TemplateVideoAppGridItem.class), d.a("lkp_first_ver_square_app_grid", TemplateFirstVerAppSquareItem.class)});
    }

    private TemplateHelper() {
    }

    @NotNull
    public final List<TemplateItem> buildTemplateItemList(@Nullable List<BetaTemplateEntity> r10) {
        ArrayList r11 = new ArrayList();
        if (r10 == null) goto L18;
        Iterator<T> r12 = r10.iterator();
    L6:
        if (r12.hasNext() == false) goto L18;
        BetaTemplateEntity r13 = (BetaTemplateEntity) r12.next();
        Class<?> r14 = templateItemMap.get(r13.getTemplateName());
        TemplateItem r15 = null;
        if (r14 == null) goto L12;
        Constructor<?> r16 = r14.getConstructor(null);
        if (r16 == null) goto L12;
        Object r17 = r16.newInstance(null);
    L14:
        if ((r17 instanceof TemplateItem) == false) goto L16;
        r15 = (TemplateItem) r17;
    L16:
        if (r15 == null) goto L6;
        r15.setTemplateEntity(r13);
        r11.add(r15);
    L12:
        r17 = null;
    L18:
        return r11;
    }
}
