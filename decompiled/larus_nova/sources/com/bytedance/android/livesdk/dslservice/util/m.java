package com.bytedance.android.livesdk.dslservice.util;

import com.bytedance.android.livesdk.dsl.api.DSLType;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class m extends DSLMonitor {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f122999d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f123000e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f123001f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f123002g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final m f123003h = null;

    static {
        f123003h = new m();
        f122999d = "Live_LynxAir";
        f123000e = true;
        f123001f = true;
        f123002g = "ttlive_dsl_load_component_lynx_air_cost";
    }

    public m() {
    }

    @Override // com.bytedance.android.livesdk.dslservice.util.DSLMonitor
    public final String c() {
        return f122999d;
    }

    public final void i(long r100, String r110, String r111) {
        Intrinsics.checkNotNullParameter(r110, "id");
        Intrinsics.checkNotNullParameter(r111, "loadType");
        HashMap r101 = DSLMonitor.b(r100, r110, DSLType.LynxAir, f123000e, r111);
        f123000e = false;
        h(this.f122951a, r101);
    }
}
