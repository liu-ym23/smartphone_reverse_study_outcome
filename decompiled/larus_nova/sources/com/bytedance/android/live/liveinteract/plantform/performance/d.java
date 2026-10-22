package com.bytedance.android.live.liveinteract.plantform.performance;

import io.reactivex.functions.Function;
import java.util.LinkedHashMap;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes46.dex */
public final class d<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f77315a = null;

    static {
        f77315a = new d();
    }

    public d() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        Object[] r101 = (Object[]) r100;
        Intrinsics.checkNotNullParameter(r101, "results");
        LinkedHashMap r102 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(r101.length), 16));
        int r103 = r101.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L9;
        Object r105 = r101[r104];
        if (r105 == null) goto L8;
        Pair r106 = (Pair) r105;
        r102.put(r106.getFirst(), r106.getSecond());
        r104 = r104 + 1;
        goto L3
    L8:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Pair<kotlin.String, com.bytedance.android.live.liveinteract.plantform.performance.PerfAbilitySource>");
    L9:
        return r102;
    }
}
