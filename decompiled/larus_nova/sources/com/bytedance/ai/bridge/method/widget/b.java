package com.bytedance.ai.bridge.method.widget;

import com.bytedance.ai.utils.g;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.ttnet.utils.RetrofitUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final WidgetRemoteApi f36042a = null;

    static {
        f36042a = (WidgetRemoteApi) RetrofitUtils.getSsRetrofit("https://api-normal.doubao.com").create(WidgetRemoteApi.class);
    }

    public static void a(String r110, String r111, String r112, String r113, String r114) {
        Intrinsics.checkNotNullParameter(r110, com.heytap.mcssdk.constant.b.f276376z);
        Intrinsics.checkNotNullParameter(r111, "cardInstanceId");
        Intrinsics.checkNotNullParameter(r114, "widgetData");
        SsResponse<p4.a> r115 = f36042a.updateCardInstance(new a(r110, r111, r112, r113, r114, System.currentTimeMillis())).execute();     // Catch: Exception -> L15
        if (r115.isSuccessful() == false) goto L13;
        p4.a r116 = r115.body();     // Catch: Exception -> L15
        if (r116 == null) goto L10;
        boolean r117 = true;
        if (r116.d() != true) goto L10;
    L11:
        if (r117 == false) goto L13;
        g.f37637a.i("WidgetRemoteService", "updateCardInstance success");     // Catch: Exception -> L15
        return;
    L10:
        r117 = false;
    L13:
        g.f37637a.e("WidgetRemoteService", "updateCardInstance failed, httpCode=" + r115.code() + ", response=" + r115.body());     // Catch: Exception -> L15
        return;
    L15:
        e = move-exception;
        g.f37637a.e("WidgetRemoteService", "updateCardInstance ERROR: " + e.getMessage(), e);
    }
}
