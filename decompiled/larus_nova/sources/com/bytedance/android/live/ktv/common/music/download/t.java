package com.bytedance.android.live.ktv.common.music.download;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.android.live.ktv.common.util.KtvCommonConfigParams;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import java.io.File;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes45.dex */
public final class t extends v {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f70110b = 0;

    public static final class a {
        public static String a(long r100) {
            StringBuilder r101 = new StringBuilder(KtvCommonConfigParams.a());
            String r102 = File.separator;
            r101.append(r102);
            r101.append("musicPack");
            r101.append(r102);
            r101.append(r100);
            r101.append(r102);
            r101.append("lyrics");
            r101.append(r102);
            return r101.toString();
        }

        public static String b(String r110, long r111) {
            if (r110 == null) goto L28;
            boolean r100 = false;
            if (r110.length() <= 0) goto L6;
            boolean r101 = true;
        L7:
            String r102 = null;
            if (r101 == true) goto L11;
            r110 = null;
        L11:
            if (r110 == null) goto L28;
            int r103 = StringsKt.lastIndexOf$default(r110, HTTP.URL_DEFAULT, 0, false, 6, null);
            if (r103 >= 0) goto L15;
        L17:
            if (r103 >= 0) goto L19;
        L21:
            if (r100 == true) goto L24;
            r110 = null;
        L24:
            if (r110 == null) goto L26;
            r102 = r110.substring(r103 + 1);
        L26:
            if (r102 == null) goto L28;
            return r102;
        L19:
            if (r103 >= r110.length()) goto L21;
            r100 = true;
            goto L21
        L15:
            if (r103 != (r110.length() - 1)) goto L17;
            r110 = r110.substring(0, r110.length() - 1);
            r103 = StringsKt.lastIndexOf$default(r110, HTTP.URL_DEFAULT, 0, false, 6, null);
            goto L17
        L6:
            r101 = false;
        L28:
            return String.valueOf(r111);
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.ktv.common.music.download.v
    public String getType() {
        return KtvSubElement.LYRIC;
    }

    public t() {
    }

    @Override // com.bytedance.android.live.ktv.common.music.download.v
    public final String a(KtvMusic r100) {
        Intrinsics.checkNotNullParameter(r100, "music");
        List<String> r101 = r100.getMLyricUrlList();
        if (r101 == null) goto L5;
        String r102 = (String) CollectionsKt.firstOrNull(r101);
    L7:
        return a.b(r102, r100.getMId());
    L5:
        r102 = null;
        goto L7
    }

    @Override // com.bytedance.android.live.ktv.common.music.download.v
    public final String b(KtvMusic r100) {
        Intrinsics.checkNotNullParameter(r100, "music");
        return a.a(r100.getMId());
    }

    @Override // com.bytedance.android.live.ktv.common.music.download.v
    public final String c(KtvMusic r100) {
        Intrinsics.checkNotNullParameter(r100, "music");
        List<String> r101 = r100.getMLyricUrlList();
        if (r101 == null) goto L6;
        String r102 = (String) CollectionsKt.getOrNull(r101, 0);
        if (r102 == null) goto L6;
        return r102;
    L6:
        return "";
    }
}
