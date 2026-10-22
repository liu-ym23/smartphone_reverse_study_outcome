package com.bytedance.android.shopping.mall.homepage.pagecard;

import com.bytedance.android.ec.hybrid.monitor.HybridAppInfoService;
import com.bytedance.android.shopping.api.mall.common.tools.NativeMallGeckoHelper;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f178307c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f178308a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f178309b;

    public static final class a {
        public static String a() {
            Lazy r100 = HybridAppInfoService.f47530a;
            if (HybridAppInfoService.j() == false) goto L6;
            return "hybrid://lynxview?surl=https%3A%2F%2Flf-webcast-sourcecdn-tos.bytegecko.com%2Fobj%2Fbyte-gurd-source%2F10181%2Fgecko%2Fresource%2Fecom_mall_cards_dylite%2Fcards%2Fpage_card%2Ftemplate.js&enable_js_runtime=true&enable_code_cache=1";
        L6:
            if (HybridAppInfoService.i() == true) goto L11;
            return null;
        L11:
            return "hybrid://lynxview?surl=https%3A%2F%2Flf-ecom-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fwebcast%2Fecom%2Flynx%2F" + NativeMallGeckoHelper.b() + "%2Fcards%2Fpage_card%2Ftemplate.js&enable_js_runtime=true&enable_code_cache=1";
        }
    }

    static {
    }

    public final synchronized c a() {
        monitor-enter(this);
        c r100 = this.f178308a;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public d() {
    }

    public final void b(String r100, Long r101) {
        if (this.f178308a == null) goto L5;
        return;
    L5:
        if (r100 != null) goto L7;
        r100 = a.a();
    L7:
        this.f178309b = r100;
        if (r101 == null) goto L10;
        r101.longValue();
    L10:
        String r102 = this.f178309b;
        if (r102 == null) goto L14;
        Intrinsics.checkNotNull(r102);
        this.f178308a = new c(r102);
        return;
    }
}
