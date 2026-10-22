package com.bytedance.android.shopping.ligo.monitor;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class LigoMonitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f176459a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f176460b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f176461c;

    public final c a() {
        return (c) this.f176459a.getValue();
    }

    public LigoMonitor(a r100) {
        Intrinsics.checkNotNullParameter(r100, "eventTracker");
        this.f176461c = r100;
        this.f176459a = LazyKt.lazy(new LigoMonitor$perfMonitor$2(this));
        this.f176460b = new d(r100.a());
    }

    public final void c(ll.a r100) {
        Intrinsics.checkNotNullParameter(r100, "dynamicRegion");
        this.f176461c.b("livesdk_ligo_load_success", b.a(r100));
        d r101 = this.f176460b;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "dynamicRegion");
        String r102 = r101.f176464a;
        String r103 = "load_success_" + r100.b();
        Map r104 = d.a(r100, new Pair[0]);
        xh.b r105 = new xh.b();
        r105.c(r102);
        r105.b(r103);
        r105.a(r104);
        xh.c.a("Ligo").f(4, r105);
    }

    public final void b(ll.a r100, String r101, String r110) {
        Intrinsics.checkNotNullParameter(r100, "dynamicRegion");
        Intrinsics.checkNotNullParameter(r101, "errorCode");
        a r102 = this.f176461c;
        LinkedHashMap r103 = new LinkedHashMap();
        r103.putAll(b.a(r100));
        r103.put("error_code", r101);
        r103.put("error_msg", r110);
        Unit r104 = Unit.INSTANCE;
        r102.b("livesdk_ligo_load_failed", r103);
        d r105 = this.f176460b;
        r105.getClass();
        Intrinsics.checkNotNullParameter(r100, "dynamicRegion");
        Intrinsics.checkNotNullParameter(r101, "errorCode");
        String r106 = r105.f176464a;
        String r107 = "load_fail_" + r100.b();
        Map r108 = d.a(r100, new Pair[]{new Pair("error_code", r101), new Pair("error_msg", r110)});
        xh.b r109 = new xh.b();
        r109.c(r106);
        r109.b(r107);
        r109.a(r108);
        xh.c.a("Ligo").f(6, r109);
    }

    public final void d(ll.a r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "dynamicRegion");
        Intrinsics.checkNotNullParameter(r101, "errorCode");
        d r103 = this.f176460b;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r100, "dynamicRegion");
        Intrinsics.checkNotNullParameter(r101, "errorCode");
        String r104 = r103.f176464a;
        String r105 = "load_lynx_fail_" + r100.b();
        Map r106 = d.a(r100, new Pair[]{new Pair("error_code", r101), new Pair("error_msg", r102)});
        xh.b r107 = new xh.b();
        r107.c(r104);
        r107.b(r105);
        r107.a(r106);
        xh.c.a("Ligo").f(6, r107);
    }
}
