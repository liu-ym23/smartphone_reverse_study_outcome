package com.bytedance.android.ec.store.utils;

import com.bytedance.android.ec.host.api.split.ECFoldScene;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f48671a = 0;

    static {
    }

    public static String a(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, ECFoldScene r110) {
        Intrinsics.checkNotNullParameter(r100, "passThroughApi");
        Intrinsics.checkNotNullParameter(r101, "entranceLocation");
        Intrinsics.checkNotNullParameter(r104, "preGroupId");
        Intrinsics.checkNotNullParameter(r105, "preProductId");
        Intrinsics.checkNotNullParameter(r106, "preRoomId");
        Intrinsics.checkNotNullParameter(r107, "liveUserActParams");
        if (r100.length() != 0) goto L5;
        boolean r108 = true;
    L6:
        if (r108 == false) goto L8;
        JSONObject r109 = new JSONObject();
    L9:
        if (r109 == null) goto L27;
        r109.put(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_LOCATION, r101);
        if (r102 != null) goto L13;
        r102 = "";
    L13:
        r109.put("pre_store_source_page", r102);
        if (r103 != null) goto L16;
        r103 = "";
    L16:
        r109.put("pre_store_group_type", r103);
        r109.put(com.bytedance.android.ec.core.event.a.KEY_PRE_GROUP_ID, r104);
        r109.put(com.bytedance.android.ec.core.event.a.KEY_PRE_PRODUCT_ID, r105);
        r109.put("pre_live_id", r106);
        r109.put(com.bytedance.android.ec.core.event.a.KEY_STORE_TYPE, "shop");
        r109.put("live_user_act_params", r107);
        if (r110 != ECFoldScene.LIVE) goto L20;
        r109.put("split_parent", "1");
    L22:
        String r111 = r109.toString();
        if (r111 != null) goto L26;
        return r100;
    L26:
        return r111;
    L20:
        if (r110 != ECFoldScene.VIDEO) goto L22;
        r109.put("split_parent", "2");
        goto L22
    L27:
        return r100;
    L8:
        r109 = com.bytedance.android.shopping.extensions.k.w(r100);
        goto L9
    L5:
        r108 = false;
        goto L6
    }
}
