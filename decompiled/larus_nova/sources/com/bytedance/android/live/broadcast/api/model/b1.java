package com.bytedance.android.live.broadcast.api.model;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class b1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f59028a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, String> f59029b;

    public b1() {
        this.f59028a = "PreviewSourcePayLoadContent[" + hashCode() + ']';
        this.f59029b = new LinkedHashMap();
    }

    public final Object a(Class r100) {
        Intrinsics.checkNotNullParameter("star_order_id", "key");
        Intrinsics.checkNotNullParameter(r100, "clazz");
        String r101 = (String) ((LinkedHashMap) this.f59029b).get("star_order_id");
        if (r101 != null) goto L6;
        ALogger.d(this.f59028a, "return default value for key:star_order_id, value:,caz null content");
        return "";
    L6:
        Object r102 = GsonProtectorUtils.fromJson(GsonHelper.get(), r101, r100);
        if (r102 != null) goto L10;
        ALogger.d(this.f59028a, "return default value for key:star_order_id, value:,caz null value");
        return "";
    L10:
        return r102;
    }
}
