package com.bytedance.android.live.revenue.platform.container.impl;

import com.bytedance.tools.kcp.aio.runtime.BindsService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes47.dex */
public final class v0 implements t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class<? extends com.bytedance.android.scope.j> f91357a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e33.l f91358b;

    @Override // com.bytedance.android.live.revenue.platform.container.impl.t
    public final Class<?> a() {
        e33.l r100 = this.f91358b;
        Intrinsics.checkNotNullParameter(r100, "$this$serviceCls");
        KClass r101 = (KClass) CollectionsKt.firstOrNull(r100.f470910b);
        Intrinsics.checkNotNull(r101);
        return JvmClassMappingKt.getJavaClass(r101);
    }

    @Override // com.bytedance.android.live.revenue.platform.container.impl.t
    public final x0 b() {
        ArrayList r100 = new ArrayList();
        List<KClass<?>> r101 = this.f91358b.f470910b;
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator<T> r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r102.add(JvmClassMappingKt.getJavaClass((KClass) r103.next()));
        goto L4
    L6:
        Iterator r104 = r102.iterator();
    L8:
        if (r104.hasNext() == false) goto L14;
        Class r105 = (Class) r104.next();
        BindsService r106 = (BindsService) r105.getAnnotation(BindsService.class);
        if (r106 == null) goto L8;
        String r107 = r106.serviceFullName();
        if (r107 == null) goto L8;
        r100.add(new u(r107, r105));
        goto L8
    L14:
        LinkedHashMap r108 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r100, 10)), 16));
        Iterator r109 = r100.iterator();
    L16:
        if (r109.hasNext() == false) goto L19;
        Object r110 = r109.next();
        r108.put(((u) r110).f91348a, r110);
        goto L16
    L19:
        return new x0(r108, a(), this.f91357a);
    }

    public v0(Class<? extends com.bytedance.android.scope.j> r100, e33.l r101) {
        Intrinsics.checkNotNullParameter(r100, "scopeCls");
        Intrinsics.checkNotNullParameter(r101, "serviceDesc");
        this.f91357a = r100;
        this.f91358b = r101;
    }
}
