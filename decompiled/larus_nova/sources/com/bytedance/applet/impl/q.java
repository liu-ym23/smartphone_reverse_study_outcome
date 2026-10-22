package com.bytedance.applet.impl;

import android.content.Context;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.larus.platform.model.CoordinateType;
import com.larus.platform.model.LocationResult;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Locale;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class q implements r4.e {

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f191995a = null;

        static {
            int[] r100 = new int[LocationResult.values().length];
            r100[LocationResult.NO_PERMISSION.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L35:
            r100[LocationResult.TIME_OUT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L51:
            r100[LocationResult.NO_GPS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
        L39:
            r100[LocationResult.REACH_LIMITATION.ordinal()] = 4;     // Catch: NoSuchFieldError -> L20
        L43:
            r100[LocationResult.INTERVAL_NOT_REACH.ordinal()] = 5;     // Catch: NoSuchFieldError -> L21
        L29:
            r100[LocationResult.NO_DATA.ordinal()] = 6;     // Catch: NoSuchFieldError -> L22
        L45:
            r100[LocationResult.STOP_POLL_IN_BACKGROUND.ordinal()] = 7;     // Catch: NoSuchFieldError -> L23
        L47:
            r100[LocationResult.NOT_INITIALIZED.ordinal()] = 8;     // Catch: NoSuchFieldError -> L24
        L37:
            r100[LocationResult.NOT_SUPPORT_CONTINUOUS.ordinal()] = 9;     // Catch: NoSuchFieldError -> L25
        L41:
            r100[LocationResult.NO_IMPL_MODULE.ordinal()] = 10;     // Catch: NoSuchFieldError -> L26
        L31:
            r100[LocationResult.SDK_INTERNAL_ERROR.ordinal()] = 11;     // Catch: NoSuchFieldError -> L27
        L33:
            r100[LocationResult.SUCCESS.ordinal()] = 12;     // Catch: NoSuchFieldError -> L28
        L15:
            f191995a = r100;
        }
    }

    static {
    }

    public q() {
    }

    @Override // r4.e
    public final r4.l c(e3.d r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r101, "bridgeName");
        Intrinsics.checkNotNullParameter(r102, LocationMonitorConst.IDENTIFIER);
        com.larus.platform.service.m r103 = com.larus.platform.service.m.f365762a;     // Catch: Exception -> L9
        com.larus.platform.api.p1 r104 = com.larus.platform.service.m.i();     // Catch: Exception -> L9
        if (r104 != null) goto L7;
        r4.l r105 = r4.l.f535999c;     // Catch: Exception -> L9
        return r4.l.a.a("location_service_not_available", f3.a.f475266g);
    L7:
        r104.d(r102);     // Catch: Exception -> L9
        return r4.l.f535999c;
    L9:
        e = move-exception;
        r4.l r106 = r4.l.f535999c;
        return r4.l.a.a("internal_error: " + e.getMessage(), f3.a.f475265f);
    }

    @Override // r4.e
    public final void d(Context r100, e3.d r101, String r102, com.bytedance.ai.bridge.method.system.location.b r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "bridgeContext");
        Intrinsics.checkNotNullParameter(r102, "bridgeName");
        Intrinsics.checkNotNullParameter(r103, "callback");
        r103.a();
    }

    @Override // r4.e
    public final void b(Context r100, e3.d r101, String r102, r4.o r103, com.bytedance.ai.bridge.method.system.location.i r104) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "bridgeContext");
        Intrinsics.checkNotNullParameter(r102, "bridgeName");
        Intrinsics.checkNotNullParameter(r103, "request");
        Intrinsics.checkNotNullParameter(r104, "callback");
        r104.a();
    }

    @Override // r4.e
    public final r4.l a(Context r100, e3.d r101, String r102, String r103, String r104, com.bytedance.ai.bridge.method.system.location.g r105) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "bridgeContext");
        Intrinsics.checkNotNullParameter(r102, "bridgeName");
        Intrinsics.checkNotNullParameter(r103, "type");
        Intrinsics.checkNotNullParameter(r104, LocationMonitorConst.IDENTIFIER);
        Intrinsics.checkNotNullParameter(r105, "callback");
        com.larus.platform.service.m r106 = com.larus.platform.service.m.f365762a;     // Catch: Exception -> L27
        com.larus.platform.api.p1 r107 = com.larus.platform.service.m.i();     // Catch: Exception -> L27
        if (r107 != null) goto L8;
        r4.l r108 = r4.l.f535999c;     // Catch: Exception -> L27
        return r4.l.a.a("location_service_not_available", f3.a.f475266g);
    L8:
        if (Intrinsics.areEqual(r103.toLowerCase(Locale.US), "wgs84") == false) goto L10;
        CoordinateType r109 = CoordinateType.WGS_84;     // Catch: Exception -> L27
    L11:
        LocationResult r110 = r107.a(r109, new r(r105, this), r104);     // Catch: Exception -> L27
        if (r110 != LocationResult.SUCCESS) goto L17;
        return r4.l.f535999c;
    L17:
        switch(b.f191995a[r110.ordinal()]) {
            case 1: goto L24;
            case 2: goto L23;
            case 3: goto L22;
            case 4: goto L22;
            case 5: goto L22;
            case 6: goto L22;
            case 7: goto L22;
            case 8: goto L21;
            case 9: goto L21;
            case 10: goto L21;
            case 11: goto L20;
            case 12: goto L31;
            default: goto L26;
        };
    L20:
        r4.l r111 = r4.l.f535999c;     // Catch: Exception -> L27
        return r4.l.a.a("location_start_failed: " + r110.getMessage(), f3.a.f475265f);
    L21:
        r4.l r112 = r4.l.f535999c;     // Catch: Exception -> L27
        return r4.l.a.a("location_sdk_not_initialized", f3.a.f475266g);
    L22:
        r4.l r113 = r4.l.f535999c;     // Catch: Exception -> L27
        String r114 = "location_start_failed: " + r110.getMessage();     // Catch: Exception -> L27
        f3.a.C5852a r115 = f3.a.f475262c;     // Catch: Exception -> L27
        f3.a r116 = f3.b.f475287a;     // Catch: Exception -> L27
        Intrinsics.checkNotNullParameter(r115, "<this>");     // Catch: Exception -> L27
        return r4.l.a.a(r114, f3.b.f475296j);
    L23:
        r4.l r117 = r4.l.f535999c;     // Catch: Exception -> L27
        String r118 = "location_start_failed: " + r110.getMessage();     // Catch: Exception -> L27
        f3.a.C5852a r119 = f3.a.f475262c;     // Catch: Exception -> L27
        f3.a r120 = f3.b.f475287a;     // Catch: Exception -> L27
        Intrinsics.checkNotNullParameter(r119, "<this>");     // Catch: Exception -> L27
        return r4.l.a.a(r118, f3.b.f475297k);
    L24:
        r4.l r121 = r4.l.f535999c;     // Catch: Exception -> L27
        f3.a.C5852a r122 = f3.a.f475262c;     // Catch: Exception -> L27
        f3.a r123 = f3.b.f475287a;     // Catch: Exception -> L27
        Intrinsics.checkNotNullParameter(r122, "<this>");     // Catch: Exception -> L27
        return r4.l.a.a("no_location_permission", f3.b.f475295i);
    L26:
        throw new NoWhenBranchMatchedException();     // Catch: Exception -> L27
    L31:
        return r4.l.f535999c;
    L10:
        r109 = CoordinateType.GCJ_O2;     // Catch: Exception -> L27
    L27:
        e = move-exception;
        r4.l r124 = r4.l.f535999c;
        return r4.l.a.a("internal_error: " + e.getMessage(), f3.a.f475265f);
    }
}
