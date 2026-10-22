package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.utils;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.h0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.m0;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import java.io.File;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes8.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f116801a;

    public interface a {
        void a(String r100, String r101);

        void onFail(String r100, String r101);
    }

    public d() {
    }

    static {
    }

    public static void a(String r110, h0 r111, m0 r112, int r113) {
        if ((r113 & 2) == 0) goto L6;
        r111 = null;
    L6:
        if ((r113 & 4) == 0) goto L8;
        r112 = null;
    L8:
        Intrinsics.checkNotNullParameter(r110, "url");
        String r114 = s1.getContext().getCacheDir().getAbsolutePath();
        if (r110.length() != 0) goto L11;
        boolean r100 = true;
    L13:
        if (r100 == false) goto L15;
        f116801a++;
        StringBuilder r101 = new StringBuilder();
        r101.append(System.currentTimeMillis());
        r101.append('_');
        r101.append(f116801a);
        String r102 = r101.toString();
    L25:
        String r103 = r114 + File.separator + r102;
        Downloader.with(s1.getContext()).url(r110).name(r102).savePath(r114).retryCount(3).subThreadListener(new e(r111, r102, r103)).mainThreadListener(new f(r112, r102, r103)).download();
        return;
    L15:
        List r104 = StringsKt.split$default(r110, new String[]{HTTP.URL_DEFAULT}, false, 0, 6, null);
        int r105 = r104.size() - 1;
    L16:
        if (r105 < 0) goto L24;
        String r106 = (String) ListProtector.get(r104, r105);
        if (r106.length() <= 0) goto L20;
        boolean r107 = true;
    L21:
        if (r107 == true) goto L22;
        r105 = r105 - 1;
        goto L16
    L22:
        r102 = r106;
        goto L25
    L20:
        r107 = false;
        goto L21
    L24:
        f116801a++;
        StringBuilder r108 = new StringBuilder();
        r108.append(System.currentTimeMillis());
        r108.append('_');
        r108.append(f116801a);
        r102 = r108.toString();
        goto L25
    L11:
        r100 = false;
        goto L13
    }
}
