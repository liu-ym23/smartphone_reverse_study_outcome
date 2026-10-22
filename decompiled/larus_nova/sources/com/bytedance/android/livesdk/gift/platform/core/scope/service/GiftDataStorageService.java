package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import com.bytedance.android.livesdk.revenue.log.LogCommon;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes9.dex */
public final class GiftDataStorageService implements com.bytedance.android.scope.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f131261a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f131262b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f131263c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f131264d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f131265e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f131266f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<Integer, Integer> f131267g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map<Integer, Integer> f131268h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f131269i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final LinkedHashSet<String> f131270j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f131271k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final LinkedHashSet<Long> f131272l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f131273m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f131274n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f131275o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f131276p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f131277q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final SendGiftRelationService f131278r;

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
        final SendGiftRelationService r100 = this.f131278r;
        if (r100.f131445b == true) goto L7;
        Single.create(new q3(new SendGiftRelationService$loadCacheData$1(r100))).subscribeOn(Schedulers.io()).subscribe(new com.bytedance.android.livesdk.user.h());
        return;
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        String r100 = com.bytedance.android.livesdk.gift.platform.core.utils.h.f132038a;
        Pair[] r101 = {TuplesKt.to("predict_value", String.valueOf(this.f131275o)), TuplesKt.to("open_panel_count", String.valueOf(this.f131276p))};
        LinkedHashMap r102 = new LinkedHashMap();
        MapsKt.putAll(r102, r101);
        mz0.n r103 = new mz0.n();
        Map<String, String> r104 = r103.f516447a;
        Intrinsics.checkNotNullParameter(r104, "map");
        Intrinsics.checkNotNullParameter(r102, "map");
        r104.putAll(r102);
        mz0.m r105 = new mz0.m();
        LogCommon r106 = LogCommon.ROOM;
        r105.b(r106);
        com.bytedance.android.livesdk.revenue.log.i r107 = ((kr2.a) vh6.c.b(kr2.a.class)).ud();
        Intrinsics.checkNotNullParameter(r107, "pageSourceLog");
        ((ArrayList) r105.f516446a).add(r107.f157176a);
        ((ArrayList) r103.f516448b).addAll(r105.f516446a);
        cy0.e.f465759a.getClass();
        cy0.j r108 = cy0.e.a.f465760a;
        com.bytedance.android.scope.m.f163449e.getClass();
        Object r109 = com.bytedance.android.scope.m.b(r108).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r109);
        ((mz0.i) ((f80.a) r109)).w3("livesdk_revenue_open_gift_panel_predict_tracking", r103.f516447a, r103.f516448b);
        long r110 = this.f131265e;
        long r111 = this.f131266f;
        if (r110 == 0) goto L11;
        Pair[] r112 = {TuplesKt.to("send_big_gift_count", String.valueOf(r110)), TuplesKt.to("my_effect_show_count", String.valueOf(r111))};
        LinkedHashMap r113 = new LinkedHashMap();
        MapsKt.putAll(r113, r112);
        if (r110 != r111) goto L8;
        TuplesKt.to("success", "1");
    L9:
        mz0.n r114 = new mz0.n();
        Map<String, String> r115 = r114.f516447a;
        Intrinsics.checkNotNullParameter(r115, "map");
        Intrinsics.checkNotNullParameter(r113, "map");
        r115.putAll(r113);
        mz0.m r116 = new mz0.m();
        r116.b(r106);
        com.bytedance.android.livesdk.revenue.log.i r117 = ((kr2.a) vh6.c.b(kr2.a.class)).ud();
        Intrinsics.checkNotNullParameter(r117, "pageSourceLog");
        ((ArrayList) r116.f516446a).add(r117.f157176a);
        ((ArrayList) r114.f516448b).addAll(r116.f516446a);
        Object r118 = com.bytedance.android.scope.m.b(r108).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r118);
        ((mz0.i) ((f80.a) r118)).w3("livesdk_effect_show_local_data", r114.f516447a, r114.f516448b);
        return;
    L8:
        TuplesKt.to("success", "0");
        goto L9
    }

    public GiftDataStorageService(SendGiftRelationService r100) {
        Intrinsics.checkNotNullParameter(r100, "sendGiftRelationService");
        this.f131278r = r100;
        this.f131267g = new LinkedHashMap();
        this.f131268h = new LinkedHashMap();
        this.f131270j = new LinkedHashSet();
        this.f131272l = new LinkedHashSet();
        this.f131274n = LazyKt.lazy(GiftDataStorageService$giftContext$2.INSTANCE);
        this.f131275o = -1;
        rq2.b r101 = (rq2.b) vh6.c.b(rq2.b.class);
        if (r101 == null) goto L5;
        Integer r102 = Integer.valueOf(r101.mostUsedHand(false));
    L6:
        this.f131277q = r102.intValue();
        return;
    L5:
        r102 = null;
        goto L6
    }
}
