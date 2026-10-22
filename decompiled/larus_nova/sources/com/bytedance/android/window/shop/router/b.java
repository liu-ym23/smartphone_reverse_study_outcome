package com.bytedance.android.window.shop.router;

import com.bytedance.android.shopping.extensions.k;
import com.larus.nova.R;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, String> f189652a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, String> f189653b = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int[] f189654a = null;

        static {
            f189654a = new int[]{R.attr.colorPrimary};
        }
    }

    static {
        f189652a = MapsKt.mapOf(new Pair[]{TuplesKt.to("enter_from", "open_url"), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_LOCATION, "open_url"), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_STORE_SOURCE_PAGE, "open_url"), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_STORE_SOURCE_METHOD, "open_url"), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_STORE_GROUP_TYPE, "open_url"), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_PRE_PRODUCT_ID, null), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_PRE_ROOM_ID, null), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_PRE_GROUP_ID, null)});
        f189653b = MapsKt.mapOf(new Pair[]{TuplesKt.to("request_id", ""), TuplesKt.to("cid", "")});
    }

    public static String a(com.bytedance.android.window.shop.router.a r100) {
        String r101 = r100.a("search_jump");
        String r102 = "";
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        String r103 = r100.a("search_params");
        JSONObject r104 = null;
        if (r103 != null) goto L9;
        return null;
    L9:
        if ((!Intrinsics.areEqual(r101, "1")) == false) goto L11;
        return r103;
    L11:
        JSONObject r105 = k.w(r103);
        if (r105 == null) goto L19;
        String r106 = r100.a("previous_page");
        if (r106 == null) goto L17;
        r102 = r106;
    L17:
        r105.put("search_jump", r101);
        r105.put("previous_page", r102);
        r104 = r105;
    L19:
        return String.valueOf(r104);
    }
}
