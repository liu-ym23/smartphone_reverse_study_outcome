package com.bytedance.android.livesdk.ktvimpl.concert_stage.biz;

import com.bytedance.android.live.core.log.ALogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class w {
    public static final void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        ALogger.i("vs_concert_dynamic", "concertDynamicLog, " + r100 + ", " + r101);
    }

    public static final void b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        ALogger.i("vs_concert_stage", "concertStageLog, " + r100 + ", " + r101);
    }
}
