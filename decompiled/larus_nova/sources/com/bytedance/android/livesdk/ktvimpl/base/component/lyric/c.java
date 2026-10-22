package com.bytedance.android.livesdk.ktvimpl.base.component.lyric;

import com.bytedance.android.live.core.log.ALogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class c {
    public static final void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        ALogger.i("ttlive_ktv_karaoke_lyric", "lyricLog , " + r100 + ", " + r101);
    }
}
