package com.bytedance.android.shopping.mall.homepage.tools;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Object> f178511a;

    public a0(Map<String, ? extends Object> r100) {
        this.f178511a = r100;
    }

    public final String a(Map<String, String> r100, boolean r101, int r102, Map<String, ? extends Object> r103, Function0<String> r104) {
        Intrinsics.checkNotNullParameter(r100, "schemaMap");
        Intrinsics.checkNotNullParameter(r104, "onFailure");
        if (r103 != null) goto L5;
    L8:
        boolean r105 = true;
    L9:
        if (r105 == false) goto L11;
        Map<String, Object> r106 = this.f178511a;
    L15:
        String r107 = "";
        if (r101 == true) goto L18;
    L26:
        if (r101 == true) goto L38;
        if (r100.containsKey("video_click") == false) goto L38;
        int r108 = com.bytedance.forest.utils.h.f244547a;
        if (com.bytedance.forest.utils.h.a(r100.get("video_click")) == false) goto L38;
        String r109 = r100.get("video_click");
        if (r109 == null) goto L36;
        r107 = r109;
    L36:
        return new b0(r107, new z(r102, r106)).a();
    L38:
        return r104.invoke();
    L18:
        if (r100.containsKey("product_click") == false) goto L26;
        int r110 = com.bytedance.forest.utils.h.f244547a;
        if (com.bytedance.forest.utils.h.a(r100.get("product_click")) == false) goto L26;
        String r111 = r100.get("product_click");
        if (r111 == null) goto L39;
        r107 = r111;
    L39:
        return new b0(r107, new z(r102, r106)).a();
    L11:
        LinkedHashMap r112 = new LinkedHashMap();
        Map<String, Object> r113 = this.f178511a;
        if (r113 == null) goto L14;
        r112.putAll(r113);
    L14:
        r112.putAll(r103);
        r106 = r112;
        goto L15
    L5:
        if (r103.isEmpty() == true) goto L8;
        r105 = false;
        goto L9
    }
}
