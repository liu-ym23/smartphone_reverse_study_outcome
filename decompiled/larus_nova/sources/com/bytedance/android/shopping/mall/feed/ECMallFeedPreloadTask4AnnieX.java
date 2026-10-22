package com.bytedance.android.shopping.mall.feed;

import android.content.Context;
import com.bytedance.android.ec.hybrid.card.service.ECLynxAnnieXService;
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
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;

/* JADX INFO: loaded from: classes13.dex */
public final class ECMallFeedPreloadTask4AnnieX implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f176837c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f176838a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f176839b;

    public static final class a {
    }

    static {
        f176837c = LazyKt.lazy(ECMallFeedPreloadTask4AnnieX$Companion$pageNameToConfigKeys$2.INSTANCE);
    }

    public final void a() {
        Object r100 = ((HashMap) f176837c.getValue()).get(this.f176839b);
        String r101 = (String) r100;
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L10:
        if ((!r102) == true) goto L13;
        r100 = null;
    L13:
        String r103 = (String) r100;
        if (r103 != null) goto L16;
        return;
    L16:
        int r104 = s93.c.f541066a;
        Object r105 = new com.bytedance.android.shopping.mall.homepage.preload.j(null);
        IHybridHostService r106 = com.bytedance.android.ec.hybrid.a.h();
        if (r106 == null) goto L24;
        yj.g r107 = r106.getHostAB();
        if (r107 == null) goto L24;
        Object r108 = r107.a(r103, r105);
        if (r108 == null) goto L24;
        r105 = r108;
    L24:
        Lazy r109 = ECMallLogUtil.f47441a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.c.a.f47463b, "Key : " + r103 + ", Value: " + r105);
        com.bytedance.android.shopping.mall.homepage.preload.j r110 = (com.bytedance.android.shopping.mall.homepage.preload.j) r105;
        List<com.bytedance.android.shopping.mall.homepage.preload.i> r111 = r110.a();
        if (r111 != null) goto L27;
    L30:
        boolean r112 = true;
    L31:
        if (r112 == false) goto L34;
        boolean r113 = com.bytedance.android.ec.hybrid.monitor.f.f47559a;
        com.bytedance.android.ec.hybrid.monitor.f.c("create", 0, "", 1, this.f176839b);
        return;
    L34:
        LinkedHashMap r114 = new LinkedHashMap();
        if (Intrinsics.areEqual(this.f176839b, MallPageName.X_TAB_MALL) == false) goto L37;
        String r115 = null;
    L38:
        String r116 = com.bytedance.android.shopping.mall.homepage.tools.q.a(this.f176838a, r115);
        if (r116.length() <= 0) goto L41;
        boolean r117 = true;
    L42:
        if (r117 == true) goto L107;
    L51:
        HomePageDTO r118 = null;
    L52:
        if (r118 == null) goto L72;
        HomePageBffDTO r119 = r118.getBff();
        if (r119 == null) goto L72;
        ECHybridListDTO r120 = r119.getFeed();
        if (r120 == null) goto L72;
        List<ECHybridListSectionDTO> r121 = r120.getSections();
        if (r121 == null) goto L72;
        Iterator<T> r122 = r121.iterator();
    L62:
        if (r122.hasNext() == false) goto L72;
        ArrayList<ECHybridListItemDTO> r123 = ((ECHybridListSectionDTO) r122.next()).getItems();
        if (r123 == null) goto L62;
        Iterator<T> r124 = r123.iterator();
    L67:
        if (r124.hasNext() == false) goto L62;
        ECHybridListItemDTO r125 = (ECHybridListItemDTO) r124.next();
        Integer r126 = r125.getItemType();
        String r127 = r125.getItemData();
        if (r126 == null) goto L67;
        if (r127 == null) goto L67;
        com.bytedance.android.shopping.api.mall.common.tools.b0.a(r114, Integer.valueOf(r126.intValue()), r127);
    L72:
        List<com.bytedance.android.shopping.mall.homepage.preload.i> r128 = r110.a();
        if (r128 == null) goto L104;
        Iterator<T> r129 = r128.iterator();
    L76:
        if (r129.hasNext() == false) goto L126;
        com.bytedance.android.shopping.mall.homepage.preload.i r130 = (com.bytedance.android.shopping.mall.homepage.preload.i) r129.next();
        Integer r131 = r130.a();
        if (r131 == null) goto L127;
        int r132 = r131.intValue();
        String r133 = r130.c();
        if (r133 == null) goto L128;
        Integer r134 = r130.a();
        if (r134 == null) goto L85;
        int r135 = r134.intValue();
    L86:
        Integer r136 = r130.b();
        if (r136 == null) goto L89;
        int r137 = r136.intValue();
    L90:
        int r138 = 0;
    L91:
        if (r138 >= r137) goto L76;
        Lazy r139 = ECLynxAnnieXService.f46553a;
        Context r140 = this.f176838a;
        List r141 = (List) r114.get(Integer.valueOf(r132));
        if (r141 == null) goto L99;
        Intrinsics.checkNotNullParameter(r141, "$this$firstAndRemove");
        if (r141.isEmpty() == false) goto L97;
        Object r142 = null;
    L98:
        String r143 = (String) r142;
    L100:
        Lazy r144 = MallBehaviorUtil.f170407a;
        int r145 = r138;
        Pair r146 = ECLynxAnnieXService.e(new com.bytedance.android.ec.hybrid.card.cache.view.a(r140, r133, r143, MallBehaviorUtil.a(new MallBehaviorUtil.a(this.f176839b, r133)), r135, this.f176839b));
        if (r146 == null) goto L103;
        ECLynxAnnieXService.f(this.f176838a, this.f176839b, r146);
    L103:
        r138 = r145 + 1;
        goto L91
    L97:
        r142 = ListProtector.remove(r141, 0);
        goto L98
    L99:
        r143 = null;
        goto L100
    L89:
        r137 = 1;
        goto L90
    L85:
        r135 = 0;
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
        Result.Companion r147 = Result.Companion;     // Catch: Throwable -> L49
        r118 = (HomePageDTO) new Gson().fromJson(r116, HomePageDTO.class);     // Catch: JSONException -> L46 Throwable -> L49
    L46:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e);     // Catch: Throwable -> L49
    L49:
        th = move-exception;
        Result.Companion r148 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L51
    L41:
        r117 = false;
        goto L42
    L37:
        r115 = this.f176839b;
        goto L38
    L27:
        if (r111.isEmpty() == true) goto L30;
        r112 = false;
        goto L31
    L5:
        if (StringsKt.isBlank(r101) == true) goto L8;
        r102 = false;
        goto L10
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

    public ECMallFeedPreloadTask4AnnieX(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "pageName");
        this.f176838a = r100;
        this.f176839b = r101;
    }
}
