package com.bytedance.android.gamecp.hybrid_impl.lynx;

import com.bytedance.android.gamecp.live_api.ProviderSource;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class s1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, HybridCardRecyclePool> f57649a = null;

    static {
        f57649a = new LinkedHashMap();
    }

    public static HybridCardRecyclePool a(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, "source");
        if (Intrinsics.areEqual(r102, ProviderSource.PREVIEW.name()) == false) goto L5;
        r102 = r100 + '-' + r101 + '-' + r102;
    L5:
        LinkedHashMap r103 = (LinkedHashMap) f57649a;
        Object r104 = r103.get(r102);
        if (r104 != null) goto L9;
        r104 = new HybridCardRecyclePool();
        r103.put(r102, r104);
    L9:
        return (HybridCardRecyclePool) r104;
    }
}
