package com.bytedance.android.live.ktv.common.music.download;

import com.bytedance.android.live.ktv.common.util.KtvCommonConfigParams;
import com.bytedance.android.livesdk.message.model.AudioInfo;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class a extends v {
    @Override // com.bytedance.android.live.ktv.common.music.download.v
    public String getType() {
        return "accompaniment_track";
    }

    public a() {
    }

    @Override // com.bytedance.android.live.ktv.common.music.download.v
    public final String a(KtvMusic r100) {
        Intrinsics.checkNotNullParameter(r100, "music");
        AudioInfo r101 = r100.getMAccompanimentTrack();
        if (r101 == null) goto L5;
        long r102 = r101.getMAudioId();
    L7:
        if (r102 > 0) goto L11;
        return "";
    L11:
        return "accompaniment_" + r102;
    L5:
        r102 = -1;
        goto L7
    }

    @Override // com.bytedance.android.live.ktv.common.music.download.v
    public final String b(KtvMusic r100) {
        Intrinsics.checkNotNullParameter(r100, "music");
        AudioInfo r101 = r100.getMAccompanimentTrack();
        if (r101 == null) goto L6;
        String r102 = r101.getFileHash();
        if (r102 == null) goto L6;
    L7:
        StringBuilder r103 = new StringBuilder(KtvCommonConfigParams.a());
        String r104 = File.separator;
        r103.append(r104);
        r103.append("musicPack");
        r103.append(r104);
        r103.append(r100.getMId());
        r103.append(r104);
        r103.append("accompaniment");
        r103.append(r104);
        if (r102.length() <= 0) goto L10;
        boolean r105 = true;
    L11:
        if (r105 == false) goto L14;
        r103.append(r102);
        r103.append(r104);
    L14:
        return r103.toString();
    L10:
        r105 = false;
    L6:
        r102 = "";
        goto L7
    }

    @Override // com.bytedance.android.live.ktv.common.music.download.v
    public final String c(KtvMusic r100) {
        Intrinsics.checkNotNullParameter(r100, "music");
        AudioInfo r101 = r100.getMAccompanimentTrack();
        if (r101 == null) goto L6;
        String r102 = r101.getMUrl();
        if (r102 == null) goto L6;
        return r102;
    L6:
        return "";
    }
}
