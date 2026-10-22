package com.bytedance.android.anya.internal;

import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.u0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes43.dex */
public final class s<STATE extends MVIState<?>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<? extends com.bytedance.android.anya.v<?, ?>, Object> f41706a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<? extends u0<?, ?>, s<?>> f41707b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final STATE f41708c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f41709d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f41710e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final MVIState<?> f41711f;

    public final <T> T a(com.bytedance.android.anya.v<?, T> r100) {
        if (this.f41710e == false) goto L23;
        Object r101 = this.f41706a.get(r100);
        if (r101 != null) goto L19;
        Iterator<T> r102 = this.f41706a.entrySet().iterator();
    L9:
        if (r102.hasNext() == false) goto L13;
        T r103 = r102.next();
        if (Intrinsics.areEqual(((com.bytedance.android.anya.v) ((Map.Entry) r103).getKey()).getName(), r100.getName()) == false) goto L9;
    L14:
        Map.Entry r104 = (Map.Entry) r103;
        if (r104 == null) goto L17;
        r101 = r104.getValue();
        goto L19
    L17:
        r101 = null;
        goto L19
    L13:
        r103 = null;
    L19:
        if ((r101 instanceof Object) == true) goto L32;
        return null;
    L32:
        return (T) r101;
    L23:
        if (this.f41709d == false) goto L25;
        boolean r105 = true;
    L26:
        if (r105 == true) goto L28;
        return null;
    L28:
        return (T) ((c) r100).c();
    L25:
        r105 = CollectionsKt.contains(this.f41708c.modifiedProperties, r100);
        goto L26
    }

    /* JADX WARN: Multi-variable type inference failed */
    public s(STATE r100, boolean r101, boolean r102, MVIState<?> r103) {
        this.f41708c = r100;
        this.f41709d = r101;
        this.f41710e = r102;
        this.f41711f = r103;
        if (r102 == false) goto L99;
        Class<?> r104 = r100.getClass();
        if (r103 == null) goto L7;
        Class<?> r105 = r103.getClass();
    L9:
        if (Intrinsics.areEqual(r104, r105) == false) goto L98;
        if (r103 == null) goto L36;
        LinkedHashMap<String, c<?, ?>> r106 = r103.properties;
        if (r106 == null) goto L36;
        LinkedHashMap r107 = new LinkedHashMap();
        Iterator<Map.Entry<String, c<?, ?>>> r108 = r106.entrySet().iterator();
    L16:
        if (r108.hasNext() == false) goto L20;
        Map.Entry<String, c<?, ?>> r109 = r108.next();
        if ((r109 instanceof u0) == true) goto L16;
        r107.put(r109.getKey(), r109.getValue());
        goto L16
    L20:
        LinkedHashMap r110 = new LinkedHashMap();
        Iterator r111 = r107.entrySet().iterator();
    L22:
        if (r111.hasNext() == false) goto L30;
        Map.Entry r112 = (Map.Entry) r111.next();
        Object r113 = ((c) r112.getValue()).c();
        c<?, ?> r114 = this.f41708c.properties.get(r112.getKey());
        if (r114 == null) goto L26;
        Object r115 = r114.c();
    L28:
        if ((!Intrinsics.areEqual(r113, r115)) == false) goto L22;
        r110.put(r112.getKey(), r112.getValue());
        goto L22
    L26:
        r115 = null;
        goto L28
    L30:
        Collection r116 = r110.values();
        if (r116 == null) goto L36;
        Collection r117 = r116;
        Map r118 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r117, 10)), 16));
        Iterator r119 = r117.iterator();
    L34:
        if (r119.hasNext() == false) goto L38;
        Object r120 = r119.next();
        r118.put(r120, ((c) r120).c());
    L38:
        if (this.f41709d == false) goto L45;
        MVIState<?> r121 = this.f41711f;
        if (r121 == null) goto L44;
        LinkedHashMap<String, c<?, ?>> r122 = r121.properties;
        if (r122 == null) goto L44;
        Set<c<?, ?>> r123 = r122.values();
    L50:
        if (r123 == null) goto L54;
        Sequence r124 = CollectionsKt.asSequence(r123);
        if (r124 == null) goto L54;
    L55:
        LinkedHashMap r125 = new LinkedHashMap();
        Iterator r126 = r124.iterator();
    L57:
        if (r126.hasNext() == false) goto L63;
        Object r127 = r126.next();
        com.bytedance.android.anya.v r128 = (com.bytedance.android.anya.v) r127;
        if (r128 == null) goto L62;
        r125.put(r127, ((c) r128).c());
        goto L57
    L62:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.android.anya.internal.BasePropertyImpl<*, *>");
    L63:
        this.f41706a = MapsKt.plus(r118, r125);
        MVIState<?> r129 = this.f41711f;
        if (r129 == null) goto L95;
        LinkedHashMap<String, c<?, ?>> r130 = r129.properties;
        if (r130 == null) goto L95;
        Collection<c<?, ?>> r131 = r130.values();
        if (r131 == null) goto L95;
        ArrayList r132 = new ArrayList();
        Iterator<T> r133 = r131.iterator();
    L71:
        if (r133.hasNext() == false) goto L75;
        Object r134 = r133.next();
        if ((r134 instanceof SubStatePropertyImpl) == false) goto L71;
        r132.add(r134);
        goto L71
    L75:
        LinkedHashMap r135 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r132, 10)), 16));
        Iterator r136 = r132.iterator();
    L77:
        if (r136.hasNext() == false) goto L89;
        Object r137 = r136.next();
        SubStatePropertyImpl r138 = (SubStatePropertyImpl) r137;
        c<?, ?> r139 = this.f41708c.properties.get(r138.f41672a);
        if (r139 == null) goto L81;
        Object r140 = r139.c();
    L82:
        if (r140 != null) goto L84;
        Intrinsics.throwNpe();
    L84:
        MVIState r141 = (MVIState) r138.c();
        boolean r142 = this.f41709d;
        boolean r143 = this.f41710e;
        if (r140 == null) goto L88;
        r135.put(r137, new s(r141, r142, r143, (MVIState) r140));
        goto L77
    L88:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.android.anya.MVIState<*>");
    L81:
        r140 = null;
        goto L82
    L89:
        Map r144 = new LinkedHashMap();
        Iterator r145 = r135.entrySet().iterator();
    L91:
        if (r145.hasNext() == false) goto L96;
        Map.Entry r146 = (Map.Entry) r145.next();
        if ((!((s) r146.getValue()).f41706a.isEmpty()) == false) goto L91;
        r144.put(r146.getKey(), r146.getValue());
    L96:
        this.f41707b = r144;
        return;
    L95:
        r144 = MapsKt.emptyMap();
    L54:
        r124 = SequencesKt.emptySequence();
    L44:
        r123 = null;
        goto L50
    L45:
        MVIState<?> r147 = this.f41711f;
        if (r147 == null) goto L48;
        Set<c<?, ?>> r148 = r147.modifiedProperties;
    L49:
        r123 = r148;
        goto L50
    L48:
        r148 = null;
    L36:
        r118 = MapsKt.emptyMap();
        goto L38
    L98:
        throw new IllegalStateException("stateInstance is not equal to newListState".toString());
    L7:
        r105 = null;
        goto L9
    L99:
        this.f41706a = MapsKt.emptyMap();
        this.f41707b = MapsKt.emptyMap();
    }
}
