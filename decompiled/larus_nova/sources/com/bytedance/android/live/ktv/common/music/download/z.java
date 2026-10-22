package com.bytedance.android.live.ktv.common.music.download;

import com.bytedance.android.live.ktv.common.util.KtvCommonConfigParams;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes45.dex */
public final class z extends v {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f70120b = 0;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.live.ktv.common.music.download.v
    public String getType() {
        return "vocal";
    }

    public z() {
    }

    @Override // com.bytedance.android.live.ktv.common.music.download.v
    public final String a(KtvMusic r110) {
        Intrinsics.checkNotNullParameter(r110, "music");
        String r111 = r110.getVocalUrl();     // Catch: Exception -> L15
        if (r111 != null) goto L6;
        r111 = "";
    L6:
        int r100 = StringsKt.lastIndexOf$default(r111, '/', 0, false, 6, null);     // Catch: Exception -> L15
        if (r100 != (-1)) goto L9;
        return "";
    L9:
        int r101 = StringsKt.lastIndexOf$default(r111, '/', r100 - 1, false, 4, null);     // Catch: Exception -> L15
        if (r101 == (-1)) goto L18;
        if (r101 >= r100) goto L19;
        return r111.substring(r101 + 1, r100);
    L19:
        return "";
    L18:
        return "";
    L20:
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
        r101.append("vocal");
        r101.append(r102);
        return r101.toString();
    }

    @Override // com.bytedance.android.live.ktv.common.music.download.v
    public final String c(KtvMusic r100) {
        Intrinsics.checkNotNullParameter(r100, "music");
        String r101 = r100.getVocalUrl();
        if (r101 != null) goto L6;
        return "";
    L6:
        return r101;
    }
}
