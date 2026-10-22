package com.bytedance.android.livesdk.revenue.network;

import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.AbstractMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class ProxyRetrofitQueryMap extends AbstractMap<String, String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f157202a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, List<String>> f157203b;

    @Override // kotlin.collections.AbstractMap, androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableMap
    public final Set<Map.Entry<String, String>> getEntries() {
        return (Set) this.f157202a.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ProxyRetrofitQueryMap(Map<String, ? extends List<String>> r100) {
        Intrinsics.checkNotNullParameter(r100, "original");
        this.f157203b = r100;
        this.f157202a = LazyKt.lazy(new ProxyRetrofitQueryMap$entries$2(this));
    }

    @Override // kotlin.collections.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsKey(Object r100) {
        if ((r100 instanceof String) == true) goto L7;
        return false;
    L7:
        return super.containsKey((String) r100);
    }

    @Override // kotlin.collections.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsValue(Object r100) {
        if ((r100 instanceof String) == true) goto L7;
        return false;
    L7:
        return super.containsValue((String) r100);
    }

    @Override // kotlin.collections.AbstractMap, java.util.Map
    public final /* bridge */ Object get(Object r100) {
        if ((r100 instanceof String) == true) goto L7;
        return null;
    L7:
        return (String) super.get((String) r100);
    }

    @Override // java.util.Map
    public final /* bridge */ Object getOrDefault(Object r100, Object r101) {
        if ((r100 instanceof String) == true) goto L6;
        return r101;
    L6:
        return (String) super.getOrDefault((String) r100, (String) r101);
    }
}
