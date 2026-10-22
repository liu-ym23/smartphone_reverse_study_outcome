package com.bytedance.android.live.ktv.common.music.download;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.android.live.ktv.common.util.KtvCommonConfigParams;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes45.dex */
public final class u extends v {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f70111b = 0;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.live.ktv.common.music.download.v
    public String getType() {
        return KtvSubElement.MIDI;
    }

    public u() {
    }

    @Override // com.bytedance.android.live.ktv.common.music.download.v
    public final String a(KtvMusic r100) {
        Intrinsics.checkNotNullParameter(r100, "music");
        String r101 = r100.getMidiUrl();
        if (r101 == null) goto L17;
        Integer r102 = Integer.valueOf(StringsKt.lastIndexOf$default(r101, HTTP.URL_DEFAULT, 0, false, 6, null));
        int r103 = r102.intValue();
        if (r103 > (-1)) goto L7;
    L9:
        boolean r104 = false;
    L10:
        String r105 = null;
        if (r104 == true) goto L14;
        r102 = null;
    L14:
        if (r102 == null) goto L16;
        r105 = r101.substring(r102.intValue() + 1);
    L16:
        if (r105 == null) goto L17;
        return r105;
    L7:
        if (r103 >= r101.length()) goto L9;
        r104 = true;
    L17:
        return "";
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
        r101.append(KtvSubElement.MIDI);
        r101.append(r102);
        return r101.toString();
    }

    @Override // com.bytedance.android.live.ktv.common.music.download.v
    public final String c(KtvMusic r100) {
        Intrinsics.checkNotNullParameter(r100, "music");
        String r101 = r100.getMidiUrl();
        if (r101 != null) goto L6;
        return "";
    L6:
        return r101;
    }
}
