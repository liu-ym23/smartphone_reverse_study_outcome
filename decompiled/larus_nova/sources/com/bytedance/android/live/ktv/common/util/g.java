package com.bytedance.android.live.ktv.common.util;

import com.bytedance.android.live.core.log.ALogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class g {
    public static final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "str");
        ALogger.i("ttlive_ktv", String.valueOf(r100));
    }

    public static final void b(String r100) {
        Intrinsics.checkNotNullParameter("openDialog", "tag");
        Intrinsics.checkNotNullParameter(r100, "str");
        ALogger.d("ttlive_ktv_openDialog", r100);
    }

    public static final void c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "str");
        ALogger.e(bb0.b.b(), "logTemp: " + r100);
    }

    public static final void d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "str");
        ALogger.i(bb0.b.b(), "ktv-mv: " + r100);
    }

    public static final void e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "str");
        ALogger.e(bb0.b.b(), "ktv-mv: " + r100);
    }

    public static final void f(String r100) {
        Intrinsics.checkNotNullParameter(r100, "str");
        ALogger.i("ktv-opus", r100);
    }

    public static final void g(String r100) {
        Intrinsics.checkNotNullParameter(r100, "str");
        ALogger.i(bb0.b.b(), "logTemp: " + r100);
    }
}
