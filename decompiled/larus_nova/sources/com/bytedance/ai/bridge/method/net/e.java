package com.bytedance.ai.bridge.method.net;

import android.content.Context;
import com.bytedance.common.utility.NetworkUtils;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class e {
    static {
    }

    public static f a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r101 = s4.b.f540524a;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r102 = s4.b.a(NetworkUtils.getNetworkTypeFast(r100));
        if (Intrinsics.areEqual(r102, "mobile") == false) goto L6;
        r102 = "unknown";
    L6:
        return new f(r102, NetworkUtils.isNetworkAvailable(r100));
    }
}
