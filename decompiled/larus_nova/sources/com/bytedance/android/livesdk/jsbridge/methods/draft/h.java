package com.bytedance.android.livesdk.jsbridge.methods.draft;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.android.live.core.utils.s1;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes9.dex */
public final class h {
    public h() {
    }

    public static final int a(h r110, String r111, String r112, Function1 r113) {
        r110.getClass();
        e r100 = new e(0);
        r113.invoke(r100);
        DownloadTask r101 = Downloader.with(s1.getContext()).url(r111);
        Intrinsics.checkNotNullParameter(r112, "$this$fileName");
        int r102 = StringsKt.lastIndexOf$default(r112, HTTP.URL_DEFAULT, 0, false, 6, null);
        String r103 = null;
        if (r102 == (-1)) goto L5;
        String r104 = r112.substring(r102);
    L6:
        DownloadTask r105 = r101.name(r104);
        Intrinsics.checkNotNullParameter(r112, "$this$filePath");
        int r106 = StringsKt.lastIndexOf$default(r112, HTTP.URL_DEFAULT, 0, false, 6, null);
        if (r106 == (-1)) goto L10;
        r103 = r112.substring(0, r106);
    L10:
        return r105.savePath(r103).monitorScene("live_draft").mainThreadListener(new g(r100)).download();
    L5:
        r104 = null;
        goto L6
    }
}
