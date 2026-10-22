package com.bytedance.android.livesdk.gift.platform.core.giftlist;

import com.bytedance.android.livesdk.gift.configmodel.n0;
import com.bytedance.android.livesdk.gift.model.c1;
import com.bytedance.android.livesdk.gift.model.j1;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes9.dex */
public final class b implements g, com.bytedance.android.scope.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Long, c1> f130585a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f130586b;

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    public b() {
        this.f130585a = new LinkedHashMap();
        if (((n0) nz1.a.f521327b0.getValue(null, nz1.a.f521324a[52])).a() == false) goto L5;
        long r100 = 1;
    L6:
        this.f130586b = r100;
        return;
    L5:
        r100 = 0;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.giftlist.g
    public final Map<Long, c1> D2() {
        return this.f130585a;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.giftlist.g
    public final long J1() {
        return this.f130586b;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.giftlist.g
    public final void L5(j1 r100) {
        this.f130586b = r100.getVersion();
        Map<Long, c1> r101 = this.f130585a;
        List<c1> r102 = r100.getBaseGiftList();
        LinkedHashMap r103 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r102, 10)), 16));
        Iterator<T> r104 = r102.iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        Object r105 = r104.next();
        r103.put(Long.valueOf(((c1) r105).getId()), r105);
        goto L4
    L6:
        r101.putAll(r103);
    }
}
