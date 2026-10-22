package com.bytedance.android.latch.prefetch.internal;

import com.baidu.platform.comapi.map.MapBundleKey;
import java.util.Locale;
import java.util.Map;
import java.util.SortedMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f58473a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f58474b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SortedMap<String, String> f58475c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SortedMap<String, f0<?>> f58476d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SortedMap<String, f0<?>> f58477e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, String> f58478f;

    public d0() {
        throw null;
    }

    public final String toString() {
        return "hashCode: " + hashCode() + ", url: " + this.f58473a + ", method: " + this.f58474b;
    }

    public d0(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.MapObjKey.OBJ_SL_OBJ);
        String r101 = r100.optString("url");
        String r102 = r100.optString(com.alipay.sdk.m.p.e.f25671s, "GET").toLowerCase(Locale.ROOT);
        JSONObject r103 = r100.optJSONObject("headers");
        SortedMap<String, String> r104 = null;
        if (r103 == null) goto L5;
        SortedMap<String, String> r105 = g0.e(r103);
    L6:
        JSONObject r106 = r100.optJSONObject("params");
        if (r106 == null) goto L9;
        SortedMap<String, f0<?>> r107 = g0.f(r106);
    L10:
        JSONObject r108 = r100.optJSONObject("data");
        if (r108 == null) goto L13;
        SortedMap<String, f0<?>> r109 = g0.f(r108);
    L14:
        JSONObject r110 = r100.optJSONObject("extras");
        if (r110 == null) goto L17;
        r104 = g0.e(r110);
    L17:
        Intrinsics.checkNotNullParameter(r101, "apiUrl");
        Intrinsics.checkNotNullParameter(r102, com.alipay.sdk.m.p.e.f25671s);
        this.f58473a = r101;
        this.f58474b = r102;
        this.f58475c = r105;
        this.f58476d = r107;
        this.f58477e = r109;
        this.f58478f = r104;
        return;
    L13:
        r109 = null;
        goto L14
    L9:
        r107 = null;
        goto L10
    L5:
        r105 = null;
        goto L6
    }
}
