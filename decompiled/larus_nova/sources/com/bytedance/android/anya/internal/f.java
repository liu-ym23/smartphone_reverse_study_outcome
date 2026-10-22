package com.bytedance.android.anya.internal;

import com.bytedance.android.anya.BaseMVIDataStore;
import com.bytedance.android.anya.g0;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes43.dex */
public final class f<DATA_STORE extends BaseMVIDataStore<?>> implements com.bytedance.android.anya.n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<n<?, ?>, Object> f41689a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f41690b;

    public f() {
        this.f41689a = new LinkedHashMap();
    }

    @Override // com.bytedance.android.anya.n
    public final <T> T b(com.bytedance.android.anya.t<DATA_STORE, T> r100) {
        n r101 = (n) r100;
        if ((!this.f41690b) == false) goto L7;
        return (T) r101.a();
    L7:
        throw new IllegalStateException("Changes are already published. Consider using mutate{...} or mutateExternal{...} in async callbacks.".toString());
    }

    @Override // com.bytedance.android.anya.n
    public final <T> void a(com.bytedance.android.anya.t<DATA_STORE, T> r100, T r101) {
        n<?, ?> r102 = (n) r100;
        if ((!this.f41690b) == false) goto L13;
        Object r103 = r102.a();
        Map<Object, Object> r104 = r102.f41698b.f41531d;
        if (r101 != null) goto L8;
        r101 = (T) g0.f41616a;
    L8:
        ((ConcurrentHashMap) r104).put(r102, r101);
        if (this.f41689a.containsKey(r102) == true) goto L14;
        this.f41689a.put(r102, r103);
        return;
    L14:
        return;
    L13:
        throw new IllegalStateException("Changes are already published. Consider using mutate{...} or mutateExternal{...} in async callbacks.".toString());
    }
}
