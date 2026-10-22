package com.bytedance.android.annie.service.prefetch;

import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes43.dex */
public final class k<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AnniePrefetchProcessor f39969a;

    public k(AnniePrefetchProcessor r100) {
        this.f39969a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        List r101 = (List) r100;
        AnniePrefetchProcessor r102 = this.f39969a;
        r102.getClass();
        if (r101.isEmpty() == true) goto L17;
        List r103 = r101;
        LinkedHashMap r104 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r103, 10)), 16));
        Iterator<T> r105 = r103.iterator();
    L7:
        if (r105.hasNext() == false) goto L9;
        o.a r106 = (o.a) r105.next();
        Pair r107 = new Pair(r106.f39972a, AnniePrefetchProcessor.c(r102, CollectionsKt.listOf(r106.f39973b)));
        r104.put(r107.getFirst(), r107.getSecond());
        goto L7
    L9:
        ArrayList r108 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator<T> r109 = r103.iterator();
    L11:
        if (r109.hasNext() == false) goto L13;
        r108.add(((o.a) r109.next()).f39973b);
        goto L11
    L13:
        r102.f39930a = MapsKt.plus(r104, new Pair(null, AnniePrefetchProcessor.c(r102, r108)));
        return;
    }
}
