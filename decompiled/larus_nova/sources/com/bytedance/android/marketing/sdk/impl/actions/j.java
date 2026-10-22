package com.bytedance.android.marketing.sdk.impl.actions;

import android.content.Context;
import com.bytedance.android.marketing.sdk.impl.data.ECMarketingDataCenter;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class j extends a {
    @Override // com.bytedance.android.marketing.sdk.impl.actions.a
    public final String a() {
        return "ecom.marketing.setMemoryData";
    }

    public j() {
    }

    @Override // com.bytedance.android.marketing.sdk.impl.actions.a
    public final void c(Map<String, ? extends Object> r100, Context r101, p r102) {
        Intrinsics.checkNotNullParameter(r102, "callback");
        super.c(r100, r101, r102);
        String r103 = this.f162693c;
        if (r103 == null) goto L34;
        Object r104 = null;
        if (ex2.d.a(r103) == true) goto L8;
        r103 = null;
    L8:
        if (r103 == null) goto L34;
        Map<String, com.bytedance.android.marketing.sdk.impl.data.h> r105 = ECMarketingDataCenter.f162719a;
        if (ECMarketingDataCenter.d(r103) == false) goto L32;
        String r106 = this.f162694d;
        if (r106 == null) goto L30;
        Object r107 = this.f162695e;
        if ((r107 instanceof String) == false) goto L17;
        r104 = r107;
    L17:
        String r108 = (String) r104;
        if (r108 == null) goto L28;
        int r109 = ex2.b.f474624a;
        Intrinsics.checkNotNullParameter(r108, "$this$toJSONObject");
        JSONObject r110 = new JSONObject(r108);     // Catch: Exception -> L22
    L23:
        ECMarketingDataCenter.f162724f.put(r106, r110);
        Map<String, Set<String>> r111 = ECMarketingDataCenter.f162725g;
        Set<String> r112 = (Set) ((LinkedHashMap) r111).get(r106);
        if (r112 != null) goto L26;
        r112 = new LinkedHashSet();
    L26:
        r112.add(r103);
        r111.put(r106, r112);
        r102.onSuccess();
        return;
    L22:
        r110 = new JSONObject();
        goto L23
    L28:
        int r113 = com.bytedance.android.marketing.sdk.impl.utils.i.f162819a;
        com.bytedance.android.marketing.sdk.impl.utils.i.a(new String[]{"data 为空或解析错误"});
        r102.onFailed("data 为空或解析错误");
        return;
    L30:
        int r114 = com.bytedance.android.marketing.sdk.impl.utils.i.f162819a;
        com.bytedance.android.marketing.sdk.impl.utils.i.a(new String[]{"无 bizId 错误"});
        r102.onFailed("没有bizId");
        return;
    L32:
        int r115 = com.bytedance.android.marketing.sdk.impl.utils.i.f162819a;
        com.bytedance.android.marketing.sdk.impl.utils.i.a(new String[]{"pageId对应实例已销毁"});
        r102.onFailed("pageId对应实例已销毁");
        return;
    L34:
        int r116 = com.bytedance.android.marketing.sdk.impl.utils.i.f162819a;
        com.bytedance.android.marketing.sdk.impl.utils.i.a(new String[]{"无 pageId 错误"});
        r102.onFailed("没有pageId");
    }
}
