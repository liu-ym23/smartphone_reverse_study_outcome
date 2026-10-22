package com.bytedance.android.live.ktv.common.music.download;

import com.bytedance.android.live.core.log.ALogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class r {
    public static final void a(String r100) {
        Intrinsics.checkNotNullParameter("KtvMusicManager", "tag");
        Intrinsics.checkNotNullParameter(r100, "msg");
        ALogger.e("KtvMusicManager", " start ---- " + r100);
    }
}
