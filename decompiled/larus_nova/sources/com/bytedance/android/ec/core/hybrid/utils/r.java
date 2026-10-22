package com.bytedance.android.ec.core.hybrid.utils;

import android.app.Activity;
import com.bytedance.android.ec.core.utils.p0;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import kotlin.Lazy;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class r {
    static {
    }

    @JvmStatic
    public static final void a(String r100, Activity r101) {
        Intrinsics.checkNotNullParameter(r101, "activity");
        if (r100 == null) goto L13;
        Lazy r102 = ECAppInfoService.f48110a;
        if (ECAppInfoService.l() == false) goto L7;
        String r103 = r100;
    L8:
        if (r103 == null) goto L13;
        int r104 = p0.f45664a;
        String r105 = p0.b(r100, MapsKt.mapOf(TuplesKt.to("is_will_finish", "1")));
        if (r105 == null) goto L13;
        r100 = r105;
        goto L13
    L7:
        r103 = null;
    L13:
        com.bytedance.android.ec.sdk.helper.p.f48130a.d(r100, r101);
    }
}
