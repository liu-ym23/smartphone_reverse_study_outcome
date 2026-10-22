package com.bytedance.android.livesdk.interactivity.api.asr.utils;

import com.bytedance.android.live.core.log.ALogger;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class c {
    static {
    }

    @JvmStatic
    public static final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "info");
        ALogger.e("AnchorAsr", r100);
    }

    @JvmStatic
    public static final void c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "info");
        ALogger.i("AnchorAsr", r100);
    }

    @JvmStatic
    public static final void b(String r100, Throwable r101) {
        Intrinsics.checkNotNullParameter(r100, "info");
        Intrinsics.checkNotNullParameter(r101, "t");
        ALogger.e("AnchorAsr", r100, r101);
    }
}
