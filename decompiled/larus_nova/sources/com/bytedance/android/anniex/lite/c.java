package com.bytedance.android.anniex.lite;

import android.net.Uri;
import android.util.LruCache;
import com.bytedance.android.anniex.monitor.MonitorManager;
import com.bytedance.android.anniex.web.model.AnnieXWebModel;
import com.bytedance.ies.bullet.service.sdk.SchemaService;
import com.bytedance.mt.protector.impl.UriProtector;
import i36.d;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import t36.j;

/* JADX INFO: loaded from: classes43.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LruCache<String, AnnieXWebModel> f40797a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final LruCache<String, j> f40798b = null;

    static {
        f40797a = new LruCache(10);
        f40798b = new LruCache(10);
    }

    public static j a(String r100, Uri r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "bid");
        Intrinsics.checkNotNullParameter(r101, "schema");
        Intrinsics.checkNotNullParameter(r102, "sessionId");
        LruCache<String, j> r103 = f40798b;
        j r104 = r103.get(r102);
        if (r104 == null) goto L5;
        return r104;
    L5:
        Lazy<SchemaService> r105 = SchemaService.f248116f;
        SchemaService r106 = SchemaService.a.a();
        com.bytedance.ies.bullet.service.sdk.c r107 = new com.bytedance.ies.bullet.service.sdk.c();
        r107.a(new ib.b(r100));
        r107.a(new ib.a(r100));
        Unit r108 = Unit.INSTANCE;
        r106.a(r101, r107);
        j r109 = new j(SchemaService.a.a().c(r100, r101, true));
        r103.put(r102, r109);
        Map<String, d> r110 = MonitorManager.f40977a;
        String r111 = r109.f544443a.c().get("url");
        if (r111 != null) goto L8;
        r111 = r101.toString();
    L8:
        MonitorManager.e0(r102, UriProtector.parse(r111));
        return r109;
    }

    public static AnnieXWebModel b(String r110, Uri r111, String r112) {
        Intrinsics.checkNotNullParameter(r110, "bid");
        Intrinsics.checkNotNullParameter(r111, "schema");
        Intrinsics.checkNotNullParameter(r112, "sessionId");
        LruCache<String, AnnieXWebModel> r100 = f40797a;
        AnnieXWebModel r101 = r100.get(r112);
        if (r101 == null) goto L7;
        Map<String, Object> r102 = r101.f41472g;
        if (r102 == null) goto L7;
        r102.put("isFromModel", Boolean.TRUE);
    L7:
        if (r101 != null) goto L11;
        Map<String, d> r103 = MonitorManager.f40977a;
        MonitorManager.P(r110, r112, null);
        r101 = new ib.d(r110).a(r112, r111, a(r110, r111, r112), null, true, true, "AnnieXCard");
        r100.put(r112, r101);
        Map<String, Object> r113 = r101.f41472g;
        if (r113 == null) goto L11;
        r113.put("isFromModel", Boolean.FALSE);
    L11:
        return r101;
    }
}
