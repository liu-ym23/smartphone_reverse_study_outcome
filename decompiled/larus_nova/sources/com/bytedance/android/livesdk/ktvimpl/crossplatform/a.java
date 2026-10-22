package com.bytedance.android.livesdk.ktvimpl.crossplatform;

import com.bytedance.android.live.core.log.ALogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class a {
    public static final void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        ALogger.i("ttlive_ktv_karaoke_dynamic_log", "tag , " + r100 + " ; msg, " + r101);
    }
}
