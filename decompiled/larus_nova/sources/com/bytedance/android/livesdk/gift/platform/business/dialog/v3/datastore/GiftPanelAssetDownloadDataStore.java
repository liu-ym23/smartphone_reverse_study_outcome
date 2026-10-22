package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore;

import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.gift.model.g0;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.l1;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.GiftExtraRepo;
import com.bytedance.android.livesdk.gift.platform.core.manager.GiftManagerKt;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.AssetsService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class GiftPanelAssetDownloadDataStore implements com.bytedance.android.scope.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Long> f127199a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<Integer, Integer> f127200b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f127201c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f127202d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f127203e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final GiftExtraRepo f127204f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AssetsService f127205g;

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    public final List<Long> a(long r100) {
        g0 r101 = this.f127204f.q(r100);
        if (r101 == null) goto L5;
        List<l1> r102 = r101.getGiftBuffInfos();
    L6:
        ArrayList r103 = new ArrayList();
        if (r102 == null) goto L15;
        Iterator<T> r104 = r102.iterator();
    L10:
        if (r104.hasNext() == false) goto L15;
        h1 r105 = GiftManagerKt.j(((l1) r104.next()).getBuffGiftId(), null);
        if (r105 == null) goto L10;
        r103.add(Long.valueOf(r105.getPrimaryEffectId()));
        r103.addAll(r105.getAssetIds());
    L15:
        return r103;
    L5:
        r102 = null;
        goto L6
    }

    public GiftPanelAssetDownloadDataStore(GiftExtraRepo r100, AssetsService r101) {
        Intrinsics.checkNotNullParameter(r100, "giftExtraRepo");
        Intrinsics.checkNotNullParameter(r101, "assetService");
        this.f127204f = r100;
        this.f127205g = r101;
        this.f127199a = new ArrayList();
        this.f127200b = com.bytedance.android.livesdk.gift.platform.business.i.f().g8();
        this.f127201c = com.bytedance.android.livesdk.gift.platform.business.i.f().s4();
        this.f127202d = com.bytedance.android.livesdk.gift.platform.business.i.f().K5();
    }

    public final void c(LinkedHashMap<Integer, List<vz1.e>> r110, List<Long> r210) {
        Intrinsics.checkNotNullParameter(r110, "giftMap");
        Intrinsics.checkNotNullParameter(r210, "notSupportShowNowList");
        long r100 = System.currentTimeMillis();
        if ((r100 - this.f127203e) >= this.f127202d) goto L5;
        return;
    L5:
        this.f127203e = r100;
        if (com.bytedance.android.livesdk.gift.platform.business.i.f().Q1() == false) goto L42;
        ArrayList r101 = new ArrayList();
        r101.addAll(r210);
        Iterator<Map.Entry<Integer, List<vz1.e>>> r102 = r110.entrySet().iterator();
    L9:
        if (r102.hasNext() == false) goto L31;
        Map.Entry<Integer, List<vz1.e>> r103 = r102.next();
        int r111 = r103.getKey().intValue();
        List<vz1.e> r104 = r103.getValue();
        Map<Integer, Integer> r112 = this.f127200b;
        if (r112 == null) goto L15;
        Integer r113 = r112.get(Integer.valueOf(r111));
        if (r113 == null) goto L15;
        int r114 = r113.intValue();
    L16:
        Iterator<vz1.e> r105 = r104.iterator();
        int r115 = 0;
    L18:
        if (r105.hasNext() == false) goto L9;
        vz1.e r116 = r105.next();
        r115 = r115 + 1;
        if (r115 >= r114) goto L18;
        List r117 = CollectionsKt.plus(CollectionsKt.plus(CollectionsKt.listOf(Long.valueOf(r116.f557650a.getPrimaryEffectId())), r116.f557650a.getAssetIds()), a(r116.f557651b));
        ArrayList r118 = new ArrayList();
        Iterator r119 = r117.iterator();
    L23:
        if (r119.hasNext() == false) goto L30;
        Object r120 = r119.next();
        if (((Number) r120).longValue() <= 0) goto L27;
        boolean r121 = true;
    L28:
        if (r121 == false) goto L23;
        r118.add(r120);
        goto L23
    L27:
        r121 = false;
        goto L28
    L30:
        r101.addAll(r118);
    L15:
        r114 = this.f127201c;
        goto L16
    L31:
        ArrayList r106 = new ArrayList();
        Iterator r107 = r101.iterator();
    L33:
        if (r107.hasNext() == false) goto L40;
        Object r108 = r107.next();
        if (((Number) r108).longValue() <= 0) goto L37;
        boolean r122 = true;
    L38:
        if (r122 == false) goto L33;
        r106.add(r108);
        goto L33
    L37:
        r122 = false;
        goto L38
    L40:
        final List r109 = CollectionsKt.distinct(r106);
        UtilityKotlinExtentionsKt.s(0, false, false, new GiftPanelAssetDownloadDataStore$updateShowSort$1(this, r109), 7);
    L42:
        if (com.bytedance.android.livesdk.gift.platform.business.i.f().S2() == false) goto L85;
        List<Long> r123 = r210;
        Collection<List<vz1.e>> r124 = r110.values();
        ArrayList r125 = new ArrayList();
        Iterator<T> r126 = r124.iterator();
    L45:
        if (r126.hasNext() == false) goto L51;
        List r127 = (List) r126.next();
        ArrayList r128 = new ArrayList();
        Iterator r129 = r127.iterator();
    L48:
        if (r129.hasNext() == false) goto L50;
        vz1.e r130 = (vz1.e) r129.next();
        CollectionsKt.addAll(r128, CollectionsKt.plus(CollectionsKt.plus(CollectionsKt.listOf(Long.valueOf(r130.f557650a.getPrimaryEffectId())), r130.f557650a.getAssetIds()), a(r130.f557651b)));
        goto L48
    L50:
        CollectionsKt.addAll(r125, r128);
        goto L45
    L51:
        List r131 = CollectionsKt.plus(r123, r125);
        ArrayList r132 = new ArrayList();
        Iterator r133 = r131.iterator();
    L53:
        if (r133.hasNext() == false) goto L60;
        Object r134 = r133.next();
        if (((Number) r134).longValue() <= 0) goto L57;
        boolean r135 = true;
    L58:
        if (r135 == false) goto L53;
        r132.add(r134);
        goto L53
    L57:
        r135 = false;
        goto L58
    L60:
        final List r136 = CollectionsKt.distinct(r132);
        UtilityKotlinExtentionsKt.s(0, false, false, new GiftPanelAssetDownloadDataStore$updateShowSort$2(this, r136), 7);
        return;
    }
}
