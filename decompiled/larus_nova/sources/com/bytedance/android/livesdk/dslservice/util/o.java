package com.bytedance.android.livesdk.dslservice.util;

import com.bytedance.android.livesdk.dsl.api.DSLType;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class o extends DSLMonitor {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f123006d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f123007e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final o f123008f = null;

    static {
        f123008f = new o();
        f123006d = "Live_Slice";
        f123007e = true;
    }

    public o() {
    }

    @Override // com.bytedance.android.livesdk.dslservice.util.DSLMonitor
    public final String c() {
        return f123006d;
    }

    public final void i(long r100, String r110, String r111) {
        Intrinsics.checkNotNullParameter(r110, "id");
        Intrinsics.checkNotNullParameter(r111, "loadType");
        HashMap r101 = DSLMonitor.b(r100, r110, DSLType.Slice, f123007e, r111);
        f123007e = false;
        h(this.f122951a, r101);
    }
}
