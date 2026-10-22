package com.bytedance.android.live.ktv.common.music.download;

import com.bytedance.android.live.ktv.common.util.KtvCommonConfigParams;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes45.dex */
public final class x extends v {
    @Override // com.bytedance.android.live.ktv.common.music.download.v
    public String getType() {
        return Keys.API_EVENT_KEY_SONG;
    }

    @Override // com.bytedance.android.live.ktv.common.music.download.v
    public final String a(KtvMusic r100) {
        Intrinsics.checkNotNullParameter(r100, "music");
        String r101 = r100.getMSongUrl();
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        int r102 = StringsKt.lastIndexOf$default(r101, ".", 0, false, 6, null);
        if (r102 != (-1)) goto L8;
        return "";
    L8:
        return "" + r100.getMId() + r101.substring(r102);
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
        r101.append(Keys.API_EVENT_KEY_SONG);
        r101.append(r102);
        return r101.toString();
    }

    @Override // com.bytedance.android.live.ktv.common.music.download.v
    public final String c(KtvMusic r100) {
        Intrinsics.checkNotNullParameter(r100, "music");
        String r101 = r100.getMSongUrl();
        if (r101 != null) goto L6;
        return "";
    L6:
        return r101;
    }
}
