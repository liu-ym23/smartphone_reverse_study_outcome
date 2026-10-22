package com.bytedance.android.shopping.mall.feed;

import android.content.Context;
import com.bytedance.android.ec.hybrid.card.service.KitViewCacheService;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECHybridListDTO;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECHybridListItemDTO;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECHybridListSectionDTO;
import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import com.bytedance.android.shopping.api.mall.MallPageName;
import com.bytedance.android.shopping.api.mall.common.tools.MallBehaviorUtil;
import com.bytedance.android.shopping.api.mall.model.HomePageBffDTO;
import com.bytedance.android.shopping.api.mall.model.HomePageDTO;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.services.apm.api.EnsureManager;
import com.google.gson.Gson;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;

/* JADX INFO: loaded from: classes13.dex */
public final class ECMallFeedPreloadTask4LynxCard implements Runnable {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f176840e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f176841a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f176842b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f176843c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f176844d;

    public static final class a {
    }

    static {
        f176840e = LazyKt.lazy(ECMallFeedPreloadTask4LynxCard$Companion$pageNameToConfigKeys$2.INSTANCE);
    }

    public final void a() {
        Object r100 = ((HashMap) f176840e.getValue()).get(this.f176844d);
        String r101 = (String) r100;
        int r102 = 0;
        if (r101 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        String r104 = null;
        if ((!r103) == true) goto L13;
        r100 = null;
    L13:
        String r105 = (String) r100;
        if (r105 != null) goto L16;
        return;
    L16:
        int r106 = s93.c.f541066a;
        Object r107 = new com.bytedance.android.shopping.mall.homepage.preload.j(null);
        IHybridHostService r108 = com.bytedance.android.ec.hybrid.a.h();
        if (r108 == null) goto L24;
        yj.g r109 = r108.getHostAB();
        if (r109 == null) goto L24;
        Object r110 = r109.a(r105, r107);
        if (r110 == null) goto L24;
        r107 = r110;
    L24:
        Lazy r111 = ECMallLogUtil.f47441a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.c.a.f47463b, "Key : " + r105 + ", Value: " + r107);
        com.bytedance.android.shopping.mall.homepage.preload.j r112 = (com.bytedance.android.shopping.mall.homepage.preload.j) r107;
        List<com.bytedance.android.shopping.mall.homepage.preload.i> r113 = r112.a();
        if (r113 != null) goto L27;
    L30:
        boolean r114 = true;
    L31:
        if (r114 == false) goto L34;
        boolean r115 = com.bytedance.android.ec.hybrid.monitor.f.f47559a;
        com.bytedance.android.ec.hybrid.monitor.f.c("create", 0, "", 1, this.f176844d);
        return;
    L34:
        LinkedHashMap r116 = new LinkedHashMap();
        if (Intrinsics.areEqual(this.f176844d, MallPageName.X_TAB_MALL) == false) goto L37;
        String r117 = null;
    L38:
        String r118 = com.bytedance.android.shopping.mall.homepage.tools.q.a(this.f176843c, r117);
        if (r118.length() <= 0) goto L41;
        boolean r119 = true;
    L42:
        if (r119 == true) goto L107;
    L51:
        HomePageDTO r120 = null;
    L52:
        if (r120 == null) goto L72;
        HomePageBffDTO r121 = r120.getBff();
        if (r121 == null) goto L72;
        ECHybridListDTO r122 = r121.getFeed();
        if (r122 == null) goto L72;
        List<ECHybridListSectionDTO> r123 = r122.getSections();
        if (r123 == null) goto L72;
        Iterator<T> r124 = r123.iterator();
    L62:
        if (r124.hasNext() == false) goto L72;
        ArrayList<ECHybridListItemDTO> r125 = ((ECHybridListSectionDTO) r124.next()).getItems();
        if (r125 == null) goto L62;
        Iterator<T> r126 = r125.iterator();
    L67:
        if (r126.hasNext() == false) goto L62;
        ECHybridListItemDTO r127 = (ECHybridListItemDTO) r126.next();
        Integer r128 = r127.getItemType();
        String r129 = r127.getItemData();
        if (r128 == null) goto L67;
        if (r129 == null) goto L67;
        com.bytedance.android.shopping.api.mall.common.tools.b0.a(r116, Integer.valueOf(r128.intValue()), r129);
    L72:
        List<com.bytedance.android.shopping.mall.homepage.preload.i> r130 = r112.a();
        if (r130 == null) goto L104;
        Iterator<T> r131 = r130.iterator();
    L76:
        if (r131.hasNext() == false) goto L126;
        com.bytedance.android.shopping.mall.homepage.preload.i r132 = (com.bytedance.android.shopping.mall.homepage.preload.i) r131.next();
        Integer r133 = r132.a();
        if (r133 == null) goto L127;
        int r134 = r133.intValue();
        String r135 = r132.c();
        if (r135 == null) goto L128;
        Integer r136 = r132.b();
        if (r136 == null) goto L85;
        int r137 = r136.intValue();
    L86:
        int r138 = 0;
    L87:
        if (r138 >= r137) goto L76;
        Integer r139 = r132.a();
        if (r139 == null) goto L91;
        int r140 = r139.intValue();
    L92:
        List r141 = (List) r116.get(Integer.valueOf(r134));
        if (r141 == null) goto L99;
        Intrinsics.checkNotNullParameter(r141, "$this$firstAndRemove");
        if (r141.isEmpty() == false) goto L97;
        Object r142 = r104;
    L98:
        String r143 = (String) r142;
    L100:
        com.bytedance.android.ec.hybrid.card.cache.view.b r144 = (com.bytedance.android.ec.hybrid.card.cache.view.b) this.f176841a.getValue();
        Context r145 = this.f176843c;
        Lazy r146 = MallBehaviorUtil.f170407a;
        int r147 = r138;
        int r148 = r140;
        int r149 = r137;
        com.bytedance.android.ec.hybrid.card.api.a r150 = r144.a(new com.bytedance.android.ec.hybrid.card.cache.view.a(r145, r135, r143, MallBehaviorUtil.a(new MallBehaviorUtil.a(this.f176844d, r135)), r148, this.f176844d));
        if (r150 == null) goto L103;
        ((KitViewCacheService) this.f176842b.getValue()).f(this.f176843c, this.f176844d, r150.f46373k, r150);
    L103:
        r138 = r147 + 1;
        r137 = r149;
        r102 = 0;
        r104 = null;
        goto L87
    L97:
        r142 = ListProtector.remove(r141, r102);
        goto L98
    L99:
        r143 = r104;
        goto L100
    L91:
        r140 = 0;
        goto L92
    L85:
        r137 = 1;
        goto L86
    L128:
        return;
    L127:
        return;
    L126:
        return;
    L104:
        return;
    L107:
        Result.Companion r151 = Result.Companion;     // Catch: Throwable -> L49
        r120 = (HomePageDTO) new Gson().fromJson(r118, HomePageDTO.class);     // Catch: JSONException -> L46 Throwable -> L49
    L46:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e);     // Catch: Throwable -> L49
    L49:
        th = move-exception;
        Result.Companion r152 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L51
    L41:
        r119 = false;
        goto L42
    L37:
        r117 = this.f176844d;
        goto L38
    L27:
        if (r113.isEmpty() == true) goto L30;
        r114 = false;
        goto L31
    L5:
        if (StringsKt.isBlank(r101) == true) goto L8;
        r103 = false;
        goto L9
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public ECMallFeedPreloadTask4LynxCard(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "pageName");
        this.f176843c = r100;
        this.f176844d = r101;
        this.f176841a = LazyKt.lazy(ECMallFeedPreloadTask4LynxCard$kitViewCreator$2.INSTANCE);
        this.f176842b = LazyKt.lazy(ECMallFeedPreloadTask4LynxCard$cacheService$2.INSTANCE);
    }
}
