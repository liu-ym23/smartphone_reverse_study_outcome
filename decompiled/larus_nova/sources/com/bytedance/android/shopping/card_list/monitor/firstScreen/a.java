package com.bytedance.android.shopping.card_list.monitor.firstScreen;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, Map<String, Long>> f171697a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, Map<String, String>> f171698b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<String, Long> f171699c = null;

    static {
        f171697a = new LinkedHashMap();
        f171698b = new LinkedHashMap();
        f171699c = new LinkedHashMap();
    }

    public static void b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        Intrinsics.checkNotNullParameter(r101, "checkPoint");
        LinkedHashMap r102 = (LinkedHashMap) f171697a;
        if (((Map) r102.get(r100)) != null) goto L5;
        return;
    L5:
        LinkedHashMap r103 = (LinkedHashMap) f171699c;
        Long r104 = (Long) r103.get(r100);
        if (r104 == null) goto L16;
        r104.longValue();
        if (((Map) ((LinkedHashMap) f171698b).get(r100)) != null) goto L10;
        return;
    L10:
        Long r105 = (Long) r103.get(r100);
        if (r105 == null) goto L17;
        long r106 = r105.longValue();
        Map r107 = (Map) r102.get(r100);
        if (r107 == null) goto L18;
        Long r108 = (Long) r107.put(r101, Long.valueOf(System.currentTimeMillis() - r106));
        return;
    L18:
        return;
    L17:
        return;
    }

    public static void a(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        f171697a.put(r100, new LinkedHashMap());
        f171699c.put(r100, Long.valueOf(System.currentTimeMillis()));
        f171698b.put(r100, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_NEW_SOURCE_TYPE, r101), TuplesKt.to("page_name", r102)}));
    }
}
