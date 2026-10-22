package com.bytedance.android.shopping.prepurchase.arch.container.ability;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class g {
    public static final void a(f r100, String r101, ti.j r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$registerLynxHandler");
        Intrinsics.checkNotNullParameter(r101, "eventName");
        Intrinsics.checkNotNullParameter(r102, "subscriber");
        r100.D0().l0(r101, false, r102);
    }

    public static final void c(f r100, String r101, ti.j r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$unregisterLynxHandler");
        Intrinsics.checkNotNullParameter(r101, "eventName");
        Intrinsics.checkNotNullParameter(r102, "subscriber");
        r100.D0().F0(r101, r102);
    }

    public static final void b(f r100, String r101, boolean r102, Function1<? super JSONObject, Unit> r103) {
        Intrinsics.checkNotNullParameter(r100, "$this$registerLynxHandler");
        Intrinsics.checkNotNullParameter(r101, "eventName");
        Intrinsics.checkNotNullParameter(r103, "subscriber");
        r100.D0().h0(r101, r102, r103);
    }
}
