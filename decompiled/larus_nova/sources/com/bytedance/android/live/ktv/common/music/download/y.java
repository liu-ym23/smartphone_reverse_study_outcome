package com.bytedance.android.live.ktv.common.music.download;

import com.bytedance.android.live.ktv.common.util.KtvCommonConfigParams;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class y extends v {
    @Override // com.bytedance.android.live.ktv.common.music.download.v
    public final String a(KtvMusic r100) {
        Intrinsics.checkNotNullParameter(r100, "music");
        return "";
    }

    @Override // com.bytedance.android.live.ktv.common.music.download.v
    public final String c(KtvMusic r100) {
        Intrinsics.checkNotNullParameter(r100, "music");
        return "";
    }

    @Override // com.bytedance.android.live.ktv.common.music.download.v
    public String getType() {
        return KtvSubElement.MV;
    }

    public y() {
    }

    @Override // com.bytedance.android.live.ktv.common.music.download.v
    public final String b(KtvMusic r100) {
        Intrinsics.checkNotNullParameter(r100, "music");
        StringBuilder r101 = new StringBuilder(KtvCommonConfigParams.a());
        String r102 = File.separator;
        r101.append(r102);
        r101.append("musicPack");
        r101.append(r102);
        r101.append(r100.getMId());
        r101.append(r102);
        r101.append("video");
        r101.append(r102);
        return r101.toString();
    }
}
