package com.bytedance.android.shopping.mall.homepage.tools;

import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Map<String, Object> f178514a;

    static {
    }

    public static String a(Map r100, boolean r101, int r102, Function0 r103) {
        Intrinsics.checkNotNullParameter(r100, "schemaMap");
        Intrinsics.checkNotNullParameter(r103, "onFailure");
        String r104 = "";
        if (r101 == true) goto L5;
    L13:
        if (r101 == true) goto L25;
        if (r100.containsKey("video_click") == false) goto L25;
        if (com.bytedance.forest.utils.h.a("video_click") == false) goto L25;
        String r105 = (String) r100.get("video_click");
        if (r105 == null) goto L23;
        r104 = r105;
    L23:
        return new b0(r104, new z(r102, f178514a)).a();
    L25:
        return (String) r103.invoke();
    L5:
        if (r100.containsKey("product_click") == false) goto L13;
        int r106 = com.bytedance.forest.utils.h.f244547a;
        if (com.bytedance.forest.utils.h.a((String) r100.get("product_click")) == false) goto L13;
        String r107 = (String) r100.get("product_click");
        if (r107 == null) goto L26;
        r104 = r107;
    L26:
        return new b0(r104, new z(r102, f178514a)).a();
    }
}
