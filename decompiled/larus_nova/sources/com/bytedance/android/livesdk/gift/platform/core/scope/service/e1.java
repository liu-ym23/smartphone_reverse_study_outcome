package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import androidx.collection.LongSparseArray;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.GiftListSortDataStore;
import io.reactivex.Observable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class e1 implements com.bytedance.android.scope.o, dy0.c, mc6.b, sc6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f131518a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Observable<Unit> f131519b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<Integer, Integer> f131520c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<Integer, String> f131521d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final cy0.e f131522e;

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    public static LongSparseArray a() {
        i12.d r100 = i12.m.f487958e2.a();
        if (r100 == null) goto L5;
        Object r101 = com.bytedance.android.scope.m.f163449e.d(r100, GiftListSortDataStore.class);
    L6:
        GiftListSortDataStore r102 = (GiftListSortDataStore) r101;
        if (r102 == null) goto L12;
        LongSparseArray<Integer> r103 = r102.f127181f;
        if (r103 == null) goto L12;
        return r103;
    L12:
        i12.e r104 = i12.o.b();
        if (r104 == null) goto L15;
        Object r105 = com.bytedance.android.scope.m.f163449e.d(r104, f1.class);
    L16:
        f1 r106 = (f1) r105;
        if (r106 != null) goto L19;
        return null;
    L19:
        return r106.f131541d;
    L15:
        r105 = null;
        goto L16
    L5:
        r101 = null;
        goto L6
    }

    public static void f() {
        i12.d r100 = i12.m.f487958e2.a();
        Object r101 = null;
        if (r100 == null) goto L5;
        Object r102 = com.bytedance.android.scope.m.f163449e.d(r100, GiftListSortDataStore.class);
    L7:
        if (((GiftListSortDataStore) r102) == null) goto L9;
        return;
    L9:
        i12.e r103 = i12.o.b();
        if (r103 == null) goto L12;
        r101 = com.bytedance.android.scope.m.f163449e.d(r103, f1.class);
    L12:
        f1 r104 = (f1) r101;
        return;
    L5:
        r102 = null;
        goto L7
    }

    public final com.bytedance.android.livesdk.gift.platform.core.model.j N3() {
        return ((com.bytedance.android.livesdk.gift.platform.core.giftlist.i) com.bytedance.android.live.revenue.core.util.f.a(com.bytedance.android.livesdk.gift.platform.core.giftlist.i.class)).N3();
    }

    public final Map<Integer, Integer> g() {
        return this.f131520c;
    }

    public e1(cy0.e r100) {
        Intrinsics.checkNotNullParameter(r100, "scope");
        this.f131522e = r100;
        this.f131518a = -1;
        new LongSparseArray();
        this.f131520c = new LinkedHashMap();
        this.f131521d = new LinkedHashMap();
    }

    public final String F5(int r100) {
        return ((com.bytedance.android.livesdk.gift.platform.core.giftlist.i) com.bytedance.android.live.revenue.core.util.f.a(com.bytedance.android.livesdk.gift.platform.core.giftlist.i.class)).F5(r100);
    }

    @Override // mc6.b
    public final kc6.d checkGiftResourceReadyById(long r100) {
        com.bytedance.android.livesdk.gift.model.h1 r101 = findGiftById(r100);
        kc6.d r102 = new kc6.d();
        AssetsService r103 = (AssetsService) com.bytedance.android.live.revenue.core.util.f.a(AssetsService.class);
        if (r101 == null) goto L5;
        long r104 = r101.getPrimaryEffectId();
    L6:
        r102.setResult(r103.g1(r104));
        return r102;
    L5:
        r104 = 0;
        goto L6
    }

    @Override // sc6.a
    public final com.bytedance.android.livesdk.gift.model.h1 findGiftById(long r100) {
        return ((com.bytedance.android.livesdk.gift.platform.core.giftlist.i) com.bytedance.android.live.revenue.core.util.f.a(com.bytedance.android.livesdk.gift.platform.core.giftlist.i.class)).o4(r100, null);
    }

    @Override // mc6.b
    public final kc6.j getGiftById(long r100) {
        com.bytedance.android.livesdk.gift.model.h1 r101 = ((com.bytedance.android.livesdk.gift.platform.core.giftlist.i) com.bytedance.android.live.revenue.core.util.f.a(com.bytedance.android.livesdk.gift.platform.core.giftlist.i.class)).o4(r100, null);
        kc6.j r102 = new kc6.j();
        r102.a(r101);
        return r102;
    }

    public final void h(List<? extends com.bytedance.android.livesdk.gift.model.w1> r100) {
        Intrinsics.checkNotNullParameter(r100, "pages");
        Iterator<? extends com.bytedance.android.livesdk.gift.model.w1> r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        com.bytedance.android.livesdk.gift.model.w1 r102 = r101.next();
        this.f131521d.put(Integer.valueOf(r102.getPageType()), r102.getPageName());
        goto L4
    }
}
