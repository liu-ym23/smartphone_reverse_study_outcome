package com.bytedance.android.shopping.card_list.monitor;

import com.bytedance.android.shopping.card_list.container.init.LauncherBizType;
import com.larus.bmhome.share.panel.ShareChannel;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f171679a;

    static {
        f171679a = "";
    }

    public static void b(LauncherBizType r100) {
        Intrinsics.checkNotNullParameter(r100, "bizType");
        if (r100 != LauncherBizType.CART) goto L6;
        f171679a = "cart";
    L9:
        ConcurrentHashMap<String, String> r101 = com.bytedance.android.shopping.base.event.a.f170704a;
        com.bytedance.android.shopping.base.event.a.f170704a.clear();
        com.bytedance.android.shopping.base.event.a.d(f171679a, "schema_parse", "start", null, false, null, 56);
        return;
    L6:
        if (r100 != LauncherBizType.COLLECT) goto L8;
        f171679a = ShareChannel.COLLECT;
        goto L9
    L8:
        f171679a = "none";
        goto L9
    }

    public static void a(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "errorMessage");
        ConcurrentHashMap<String, String> r102 = com.bytedance.android.shopping.base.event.a.f170704a;
        String r103 = f171679a;
        JSONObject r104 = new JSONObject();
        r104.put("statusCode", r100);
        Unit r105 = Unit.INSTANCE;
        com.bytedance.android.shopping.base.event.a.c(r103, "request", "failed", r101, true, r104);
    }
}
