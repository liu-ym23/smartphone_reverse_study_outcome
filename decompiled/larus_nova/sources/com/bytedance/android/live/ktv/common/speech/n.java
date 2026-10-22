package com.bytedance.android.live.ktv.common.speech;

import android.content.Context;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.component.lyric.model.LyricsDisplayConfig;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes45.dex */
public final class n {
    public static final String b() {
        Context r100 = s1.getContext();
        File r101 = r100.getExternalCacheDir();
        if (r101 == null) goto L6;
        String r102 = r101.getPath();
        if (r102 == null) goto L6;
    L7:
        if (r102 == null) goto L10;
        return r102;
    L10:
        throw new IllegalArgumentException("Required value was null.".toString());
    L6:
        r102 = r100.getCacheDir().getPath();
        goto L7
    }

    public static final String c(String r110, String r111) {
        Intrinsics.checkNotNullParameter(r111, "musicId");
        Intrinsics.checkNotNullParameter(r111, "musicId");
        StringBuilder r100 = new StringBuilder(b());
        String r101 = File.separator;
        r100.append(r101);
        r100.append("lyrics");
        r100.append(r101);
        r100.append(r111);
        r100.append(r101);
        String r102 = r100.toString();
        PolarisFileWrapper r103 = new PolarisFileWrapper(r102);
        if (r103.exists() == false) goto L5;
    L8:
        StringBuilder r104 = new StringBuilder();
        r104.append(r102);
        Intrinsics.checkNotNullParameter(r111, "musicId");
        if (r110 == null) goto L36;
        boolean r105 = false;
        if (r110.length() <= 0) goto L13;
        boolean r106 = true;
    L14:
        String r107 = null;
        if (r106 == true) goto L18;
        r110 = null;
    L18:
        if (r110 == null) goto L36;
        int r108 = StringsKt.lastIndexOf$default(r110, HTTP.URL_DEFAULT, 0, false, 6, null);
        if (r108 >= 0) goto L22;
    L24:
        if (r108 >= 0) goto L26;
    L28:
        if (r105 == true) goto L31;
        r110 = null;
    L31:
        if (r110 == null) goto L33;
        r107 = r110.substring(r108 + 1);
    L33:
        if (r107 == null) goto L36;
        r111 = r107;
        goto L36
    L26:
        if (r108 >= r110.length()) goto L28;
        r105 = true;
        goto L28
    L22:
        if (r108 != (r110.length() - 1)) goto L24;
        r110 = r110.substring(0, r110.length() - 1);
        r108 = StringsKt.lastIndexOf$default(r110, HTTP.URL_DEFAULT, 0, false, 6, null);
        goto L24
    L13:
        r106 = false;
    L36:
        r104.append(r111);
        return r104.toString();
    L5:
        if (r103.mkdirs() == false) goto L7;
        Single.create(new l(b() + r101 + "lyrics")).subscribeOn(Schedulers.io()).subscribe(new com.bytedance.android.livesdk.user.h());
        goto L8
    L7:
        ALogger.e("SpeechFileUtils", "mkdirs return false, dir=" + r103);
        goto L8
    }

    public static final jg4.j a(String r110, String r111, LyricsDisplayConfig r112) {
        Intrinsics.checkNotNullParameter(r110, "songUrl");
        Intrinsics.checkNotNullParameter(r111, "path");
        Intrinsics.checkNotNullParameter(r112, "config");
        float r100 = kg4.a.f503371a;
        Intrinsics.checkNotNullParameter(r111, "filePath");
        String r101 = File.separator;
        int r102 = StringsKt.lastIndexOf$default(r111, r101, 0, false, 6, null);
        String r103 = null;
        if (r102 == (-1)) goto L5;
        String r104 = r111.substring(0, r102);
    L6:
        String r113 = "";
        if (r104 != null) goto L9;
        String r114 = "";
    L10:
        Intrinsics.checkNotNullParameter(r111, "filePath");
        int r105 = StringsKt.lastIndexOf$default(r111, r101, 0, false, 6, null);
        if (r105 == (-1)) goto L13;
        r103 = r111.substring(r105);
    L13:
        if (r103 == null) goto L17;
        r113 = r103;
    L17:
        return new jg4.j(r110, r114, r113, r112);
    L9:
        r114 = r104;
        goto L10
    L5:
        r104 = null;
        goto L6
    }
}
