package com.bytedance.android.ec.core.imagex;

import com.bytedance.android.ec.core.utils.a2;
import com.optimize.statistics.FrescoMonitorConst;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public class r implements com.bytedance.android.shopping.api.image.l, com.bytedance.android.ec.core.imagex.opt.x {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f44937h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f44938a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f44939b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map<String, Object> f44940c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<String, Object> f44941d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final WeakReference<Function0<Map<String, Object>>> f44942e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f44943f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f44944g;

    public static final class a {
        @JvmStatic
        public static r a(String r100) {
            String r101 = a2.d(r100);
            if (r101 != null) goto L6;
            r101 = "unknown";
        L6:
            return new r("ec_detail", r101);
        }

        @JvmStatic
        public static r b(String r100) {
            String r101 = a2.d(r100);
            if (r101 != null) goto L6;
            r101 = "unknown";
        L6:
            return new r("ec_live", r101);
        }

        @JvmStatic
        public static r c(String r100) {
            String r101 = a2.d(r100);
            if (r101 != null) goto L6;
            r101 = "unknown";
        L6:
            return new r("ec_shop", r101);
        }

        @JvmStatic
        public static r d(String r100) {
            String r101 = a2.d(r100);
            if (r101 != null) goto L6;
            r101 = "unknown";
        L6:
            return new r("ec_window", r101);
        }
    }

    static {
    }

    public final String toString() {
        Pair[] r100 = new Pair[3];
        r100[0] = TuplesKt.to("biz_tag", this.f44943f);
        r100[1] = TuplesKt.to(FrescoMonitorConst.SCENE_TAG, this.f44944g);
        String r101 = this.f44938a;
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        r100[2] = TuplesKt.to("page_name", r101);
        Map r102 = MapsKt.mutableMapOf(r100);
        r102.putAll(this.f44941d);
        return "ImageCallerContext " + r102;
    }

    @Override // com.bytedance.android.ec.core.imagex.opt.x
    public final String getCacheKey() {
        StringBuilder r100 = new StringBuilder("ImageCallerContextbiz_tag:");
        r100.append(this.f44943f);
        r100.append(",scene_tag:");
        r100.append(this.f44944g);
        r100.append(",page_name:");
        String r101 = this.f44938a;
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        r100.append(r101);
        r100.append(",");
        return r100.toString();
    }

    @Override // com.bytedance.android.shopping.api.image.l
    public final String a() {
        return this.f44944g;
    }

    public final Map<String, Object> c() {
        return this.f44940c;
    }

    public final String d() {
        return this.f44938a;
    }

    public final String e() {
        return this.f44939b;
    }

    @Override // com.bytedance.android.shopping.api.image.l
    public final String getBizTag() {
        return this.f44943f;
    }

    public final Object b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return this.f44941d.get(r100);
    }

    public final void i(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        this.f44941d.remove(r100);
    }

    public r(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "bizTag");
        Intrinsics.checkNotNullParameter(r101, "sceneTag");
        this.f44943f = r100;
        this.f44944g = r101;
        this.f44939b = "native";
        this.f44940c = new LinkedHashMap();
        this.f44941d = new LinkedHashMap();
    }

    public final void f(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        this.f44941d.put(r100, r101);
    }

    public final void g(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        this.f44940c.put("biz_extra_" + r100, r101);
    }

    public final void h(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        this.f44940c.put(r100, r101);
    }

    public r(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "bizTag");
        Intrinsics.checkNotNullParameter(r101, "sceneTag");
        Intrinsics.checkNotNullParameter(r102, "pageName");
        this(r100, r101);
        this.f44938a = r102;
    }

    public r(String r100, String r101, Function0<? extends Map<String, ? extends Object>> r102) {
        Intrinsics.checkNotNullParameter(r100, "mBizTag");
        Intrinsics.checkNotNullParameter(r101, "mSceneTag");
        this(r100, r101);
        this.f44942e = new WeakReference(r102);
    }
}
