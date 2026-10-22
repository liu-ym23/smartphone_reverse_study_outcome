package com.bytedance.android.shopping.mall.homepage.tools;

import com.bytedance.mt.protector.impl.UriProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class a {
    public static final String a(String r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "link");
        Intrinsics.checkNotNullParameter(r101, "params");
        return com.bytedance.android.shopping.api.mall.common.tools.v.c(r100, r101);
    L8:
        return r100;
    }

    public static final String b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "ecomSceneId");
        Intrinsics.checkNotNullParameter(r100, "link");
        Map<String, String> r102 = com.bytedance.android.shopping.api.mall.common.tools.v.f(UriProtector.parse(r100));     // Catch: Exception -> L5
    L6:
        String r103 = r102.get(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO);
        if ((r103 instanceof String) == true) goto L9;
        r103 = null;
    L9:
        String r104 = r103;
        Map r105 = MapsKt.mapOf(TuplesKt.to("ecom_scene_id", r101));
        Intrinsics.checkNotNullParameter(r105, "params");
        if (r104 != null) goto L13;
        String r106 = com.bytedance.android.ec.hybrid.list.util.k.d(r105);
    L34:
        return a(r100, MapsKt.mapOf(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO, r106)));
    L13:
        if (r104.length() != 0) goto L15;
        boolean r107 = true;
    L16:
        if (r107 == false) goto L36;
        r104 = com.bytedance.android.ec.hybrid.list.util.k.d(r105);
    L32:
        r106 = r104;
        goto L34
    L36:
        JSONObject r108 = com.bytedance.android.ec.hybrid.list.util.k.c(r104);     // Catch: Exception -> L35
        LinkedHashMap r109 = new LinkedHashMap();     // Catch: Exception -> L35
        if (r108 == null) goto L31;
        Iterator<String> r110 = r108.keys();     // Catch: Exception -> L35
        if (r110 == null) goto L31;
    L23:
        if (r110.hasNext() == false) goto L31;
        String r111 = r110.next();     // Catch: Exception -> L35
        Object r112 = r108.opt(r111);     // Catch: Exception -> L35
        if (r112 == null) goto L27;
        String r113 = r112.toString();     // Catch: Exception -> L35
    L28:
        if (r113 == null) goto L23;
        if (r111 == null) goto L23;
        r109.put(r111, r113);     // Catch: Exception -> L35
        goto L23
    L27:
        r113 = null;
    L31:
        r109.putAll(r105);     // Catch: Exception -> L35
        r104 = com.bytedance.android.ec.hybrid.list.util.k.d(r109);     // Catch: Exception -> L35
        goto L32
    L15:
        r107 = false;
    L5:
        r102 = MapsKt.emptyMap();
        goto L6
    }

    public static final String c(String r100, String r110) {
        Intrinsics.checkNotNullParameter(r100, "ecomSceneId");
        if (r110 == null) goto L24;
        List r101 = StringsKt.split$default(r100, new String[]{","}, false, 0, 6, null);
        ArrayList r102 = new ArrayList();
        Iterator r103 = r101.iterator();
    L6:
        if (r103.hasNext() == false) goto L18;
        Object r104 = r103.next();
        String r105 = (String) r104;
        boolean r106 = false;
        if (r105.length() <= 0) goto L10;
        boolean r107 = true;
    L11:
        if (r107 == true) goto L13;
    L15:
        if (r106 == false) goto L6;
        r102.add(r104);
        goto L6
    L13:
        if ((!Intrinsics.areEqual(r105, r110)) == false) goto L15;
        r106 = true;
        goto L15
    L10:
        r107 = false;
        goto L11
    L18:
        return CollectionsKt.joinToString$default(CollectionsKt.plus(CollectionsKt.toMutableList(r102), r110), ",", null, null, 0, null, null, 62, null);
    L24:
        return r100;
    }
}
