package com.bytedance.android.livesdk.utils;

import com.bytedance.locallife.pdp.album.model.CustomAlbumViewModel;
import com.ss.android.download.api.constant.BaseConstants;
import java.text.SimpleDateFormat;
import java.util.Date;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class q6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SimpleDateFormat f159142a = null;

    static {
        f159142a = new SimpleDateFormat("yyyy-MM-dd");
    }

    public static boolean a(long r100) {
        SimpleDateFormat r101 = f159142a;
        return Intrinsics.areEqual(r101.format(new Date(r100)), r101.format(new Date()));
    }

    public static String b(long r110) {
        StringBuilder r100 = new StringBuilder();
        long r101 = 60000;
        long r102 = r110 / r101;
        long r111 = ((r110 % ((long) BaseConstants.Time.HOUR)) % r101) / ((long) 1000);
        long r103 = 10;
        if (r102 < r103) goto L6;
        r100.append(r102);
    L9:
        r100.append(":");
        if (r111 < r103) goto L13;
        r100.append(r111);
    L17:
        return r100.toString();
    L13:
        if (r111 <= 0) goto L15;
        r100.append(0);
        r100.append(r111);
        goto L17
    L15:
        r100.append(CustomAlbumViewModel.DEFAULT_TAB_ID);
        goto L17
    L6:
        if (r102 <= 0) goto L8;
        r100.append(0);
        r100.append(r102);
        goto L9
    L8:
        r100.append(CustomAlbumViewModel.DEFAULT_TAB_ID);
        goto L9
    }

    public static String c(long r110) {
        StringBuilder r100 = new StringBuilder();
        long r101 = BaseConstants.Time.HOUR;
        long r102 = r110 / r101;
        long r103 = 60000;
        long r104 = (r110 / r103) % ((long) 60);
        long r111 = ((r110 % r101) % r103) / ((long) 1000);
        if (r102 > 0) goto L5;
    L9:
        long r105 = 10;
        if (r104 < r105) goto L13;
        r100.append(r104);
    L16:
        r100.append(":");
        if (r111 < r105) goto L20;
        r100.append(r111);
    L24:
        return r100.toString();
    L20:
        if (r111 <= 0) goto L22;
        r100.append(0);
        r100.append(r111);
        goto L24
    L22:
        r100.append(CustomAlbumViewModel.DEFAULT_TAB_ID);
        goto L24
    L13:
        if (r104 <= 0) goto L15;
        r100.append(0);
        r100.append(r104);
        goto L16
    L15:
        r100.append(CustomAlbumViewModel.DEFAULT_TAB_ID);
        goto L16
    L5:
        if (r102 < 10) goto L7;
        r100.append(r102);
    L8:
        r100.append(":");
        goto L9
    L7:
        r100.append(0);
        r100.append(r102);
        goto L8
    }
}
