package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.CleanDataSource;
import com.bytedance.android.livesdk.revenue.service.feature.IRevFeatureService;
import com.bytedance.kmp.livesdk.gift.platform.resourcemanager.cache.AssetsFileCacheFactory;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import io.reactivex.disposables.CompositeDisposable;
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.PriorityQueue;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes9.dex */
public final class AssetsDeleteGlobalService implements com.bytedance.android.scope.o, dy0.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.livesdk.gift.configmodel.i f131143a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.livesdk.gift.configmodel.c f131144b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f131145c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CompositeDisposable f131146d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AssetsService f131147e;

    public static final class a {
    }

    public static final class b<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f131148a = null;

        static {
            f131148a = new b();
        }

        public b() {
        }

        @Override // java.util.Comparator
        public final int compare(Object r100, Object r101) {
            long r102 = ((l) r101).f131626f - ((l) r100).f131626f;
            if (r102 <= 0) goto L5;
            return 1;
        L5:
            if (r102 != 0) goto L7;
            return 0;
        L7:
            return -1;
        }
    }

    static {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        this.f131146d.clear();
    }

    public AssetsDeleteGlobalService(AssetsService r100) {
        Intrinsics.checkNotNullParameter(r100, "globalAssetsService");
        this.f131147e = r100;
        this.f131143a = (com.bytedance.android.livesdk.gift.configmodel.i) com.bytedance.android.livesdk.gift.platform.business.b.f126557t.getValue(null, com.bytedance.android.livesdk.gift.platform.business.b.f126533a[18]);
        this.f131144b = (com.bytedance.android.livesdk.gift.configmodel.c) com.bytedance.android.livesdk.gift.platform.business.i.f129659m.getValue(null, com.bytedance.android.livesdk.gift.platform.business.i.f129647a[11]);
        this.f131145c = LazyKt.lazy(AssetsDeleteGlobalService$portraitCleanEnable$2.INSTANCE);
        this.f131146d = new CompositeDisposable();
    }

    public final void a(Map<Long, com.bytedance.android.livesdk.gift.platform.business.effect.assets.a> r210, CleanDataSource r211) {
        PolarisFileWrapper r100 = new PolarisFileWrapper(new AssetsFileCacheFactory().c());
        if (r100.exists() == true) goto L5;
        return;
    L5:
        File[] r101 = r100.listFiles();
        if (r101 != null) goto L8;
        return;
    L8:
        ArrayList r102 = new ArrayList();
        if (((Boolean) this.f131145c.getValue()).booleanValue() == false) goto L13;
        String r103 = ((IRevFeatureService) vh6.c.b(IRevFeatureService.class)).getPortrait("live_not_clean_assets");
        if (r103 == null) goto L13;
        r102.addAll(GsonHelper.fromJsonArray(r103, Long.TYPE));
    L13:
        PriorityQueue r104 = new PriorityQueue(20, b.f131148a);
        long r105 = System.currentTimeMillis() / ((long) 1000);
        Iterator r106 = ((LinkedHashMap) r210).entrySet().iterator();
    L15:
        if (r106.hasNext() == false) goto L43;
        Map.Entry r107 = (Map.Entry) r106.next();
        long r110 = ((Number) r107.getKey()).longValue();
        com.bytedance.android.livesdk.gift.platform.business.effect.assets.a r111 = (com.bytedance.android.livesdk.gift.platform.business.effect.assets.a) r107.getValue();
        if (r102.contains(Long.valueOf(r110)) == true) goto L40;
        Intrinsics.checkNotNullParameter(r111, "$this$getLastUseTime");
        String r108 = r111.f129077a;
        if (r108 == null) goto L21;
        long r112 = com.bytedance.android.livesdk.gift.platform.core.keva_store.a.c(r108);
    L22:
        String r109 = r111.f129078b;
        if (r109 == null) goto L25;
        long r113 = com.bytedance.android.livesdk.gift.platform.core.keva_store.a.c(r109);
    L26:
        String r114 = r111.f129079c;
        if (r114 == null) goto L29;
        long r115 = com.bytedance.android.livesdk.gift.platform.core.keva_store.a.c(r114);
    L30:
        long r116 = RangesKt.coerceAtLeast(RangesKt.coerceAtLeast(r112, r113), r115);
        long r117 = r105 - r116;
        if (r116 != 0) goto L33;
        long r118 = Long.MAX_VALUE;
    L35:
        if (r118 < this.f131143a.a()) goto L41;
        String r119 = r111.f129077a;
        if (r119 != null) goto L39;
        r119 = "";
    L39:
        r104.add(new l(r110, r119, r111, null, r118, 17));
    L41:
        r106 = r106;
        goto L15
    L33:
        r118 = r117;
        goto L35
    L29:
        r115 = 0;
        goto L30
    L25:
        r113 = 0;
        goto L26
    L21:
        r112 = 0;
        goto L22
    L40:
        r106 = r106;
        goto L41
    L43:
        if (r104.isEmpty() == false) goto L45;
        return;
    L45:
        Iterator r120 = r104.iterator();
        int r121 = 0;
    L47:
        if (r120.hasNext() == false) goto L111;
        l r122 = (l) r120.next();
        if (r121 >= this.f131143a.b()) goto L111;
        int r123 = r101.length;
        int r124 = 0;
        boolean r125 = false;
    L52:
        if (r124 >= r123) goto L109;
        File r126 = r101[r124];
        String r127 = r126.getName();
        com.bytedance.android.livesdk.gift.platform.business.effect.assets.a r128 = r122.f131624d;
        if (r128 == null) goto L108;
        Intrinsics.checkNotNullParameter(r128, "$this$isMd5Matched");
        Intrinsics.checkNotNullParameter(r127, "targetMd5");
        if (r127.length() != 0) goto L58;
        boolean r129 = true;
    L59:
        if (r129 == true) goto L91;
        String r130 = r128.f129077a;
        if (r130 != null) goto L64;
    L71:
        String r131 = r128.f129078b;
        if (r131 != null) goto L74;
    L81:
        String r132 = r128.f129079c;
        if (r132 == null) goto L91;
        if (r132.length() <= 0) goto L86;
        boolean r133 = true;
    L87:
        if (r133 == false) goto L91;
        if (r132.equals(r127) == false) goto L91;
    L90:
        boolean r134 = true;
    L92:
        if (r134 != true) goto L108;
        int r135 = com.bytedance.android.livesdk.gift.platform.core.b.f130470a;
        String r136 = r126.getName();
        Intrinsics.checkNotNullParameter(r136, "assetMd5");
        GiftResourceFileCacheService r137 = (GiftResourceFileCacheService) com.bytedance.android.live.revenue.core.util.f.a(GiftResourceFileCacheService.class);
        if (r136 != null) goto L96;
    L99:
        boolean r138 = true;
    L100:
        if (r138 == true) goto L104;
        r137.f131396c.remove(r136);
    L104:
        if (com.bytedance.android.live.revenue.common.c0.b(r126) == false) goto L107;
        iz0.a r139 = com.bytedance.android.livesdk.gift.platform.core.keva_store.a.f130726a;
        Intrinsics.checkNotNullParameter(r127, "md5");
        com.bytedance.android.livesdk.gift.platform.core.keva_store.a.f130726a.i("last_use_time_".concat(r127));
        int r140 = com.bytedance.android.livesdk.gift.platform.business.effect.assets.c.f129081a;
        com.bytedance.android.livesdk.gift.platform.business.effect.assets.c.a(r122.f131622b, r122.f131626f, r127, "strategy_clean", r211, null, null, 96);
    L107:
        r125 = true;
        goto L108
    L96:
        if (r136.length() == 0) goto L99;
        r138 = false;
        goto L100
    L86:
        r133 = false;
        goto L87
    L74:
        if (r131.length() <= 0) goto L76;
        boolean r141 = true;
    L77:
        if (r141 == false) goto L81;
        if (r131.equals(r127) == false) goto L81;
    L76:
        r141 = false;
        goto L77
    L64:
        if (r130.length() <= 0) goto L66;
        boolean r142 = true;
    L67:
        if (r142 == false) goto L71;
        if (r130.equals(r127) == false) goto L71;
    L66:
        r142 = false;
    L91:
        r134 = false;
        goto L92
    L58:
        r129 = false;
    L108:
        r124 = r124 + 1;
        goto L52
    L109:
        if (r125 == false) goto L47;
        r121 = r121 + 1;
    L111:
        if (r121 <= 0) goto L128;
        com.bytedance.android.livesdk.gift.platform.core.d0.i(r121, 4);
        return;
    }
}
