package com.bytedance.android.marketing.sdk.impl.data;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, com.bytedance.android.marketing.sdk.api.a> f162793a = null;

    static {
        f162793a = new LinkedHashMap();
    }

    public static com.bytedance.android.marketing.sdk.api.a a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "pageId");
        Map<String, com.bytedance.android.marketing.sdk.api.a> r101 = f162793a;
        if (r101.containsKey(r100) == true) goto L7;
        return null;
    L7:
        return (com.bytedance.android.marketing.sdk.api.a) ((LinkedHashMap) r101).get(r100);
    }
}
