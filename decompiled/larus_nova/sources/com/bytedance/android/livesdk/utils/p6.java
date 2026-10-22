package com.bytedance.android.livesdk.utils;

import android.content.Context;
import com.bytedance.android.livesdk.announcement.AnnouncementViewModel;
import com.bytedance.locallife.pdp.album.model.CustomAlbumViewModel;
import com.larus.nova.R;
import java.text.SimpleDateFormat;

/* JADX INFO: loaded from: classes11.dex */
public final class p6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SimpleDateFormat f159120a = null;

    static {
        f159120a = new SimpleDateFormat("yyyy-MM-dd");
        new SimpleDateFormat("HH:mm");
    }

    public static long b() {
        long r100 = System.currentTimeMillis();
        int r101 = com.bytedance.android.livesdk.utils.ntp.a.f159088b;
        return r100 + com.bytedance.android.livesdk.utils.ntp.a.f159087a;
    }

    public p6() {
    }

    public static String a(long r100) {
        long r101 = r100 / 60;
        long r102 = r100 % 60;
        if (r101 >= 10) goto L5;
        String r103 = "0" + r101;
    L7:
        if (r102 >= 10) goto L9;
        String r104 = "0" + r102;
    L11:
        return r103 + ":" + r104;
    L9:
        r104 = String.valueOf(r102);
        goto L11
    L5:
        r103 = String.valueOf(r101);
        goto L7
    }

    public static String c(long r110) {
        StringBuilder r100 = new StringBuilder();
        long r101 = r110 / 3600000;
        long r102 = (r110 / 60000) % 60;
        long r111 = ((r110 % 3600000) % 60000) / 1000;
        if (r101 <= 0) goto L10;
        if (r101 < 10) goto L7;
        r100.append(r101);
    L8:
        r100.append(":");
        goto L10
    L7:
        r100.append(0);
        r100.append(r101);
    L10:
        if (r102 < 10) goto L13;
        r100.append(r102);
    L16:
        r100.append(":");
        if (r111 < 10) goto L20;
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
        if (r102 <= 0) goto L15;
        r100.append(0);
        r100.append(r102);
        goto L16
    L15:
        r100.append(CustomAlbumViewModel.DEFAULT_TAB_ID);
        goto L16
    }

    public static String d(long r100) {
        StringBuilder r101 = new StringBuilder();
        long r102 = r100 / 60;
        long r103 = r100 - (60 * r102);
        if (r102 >= 10) goto L5;
        r101.append("0");
    L5:
        r101.append(r102);
        r101.append(":");
        if (r103 >= 10) goto L8;
        r101.append("0");
    L8:
        r101.append(r103);
        return r101.toString();
    }

    public static String e(int r100) {
        StringBuilder r101 = new StringBuilder();
        Context r102 = com.bytedance.android.live.core.utils.s1.getContext();
        if (r100 > 0) goto L6;
        return "";
    L6:
        int r103 = r100 / AnnouncementViewModel.HOUR_DURATION;
        int r104 = r100 - (r103 * AnnouncementViewModel.HOUR_DURATION);
        int r105 = r104 / 60;
        int r106 = r104 - (r105 * 60);
        if (r103 == 0) goto L9;
        r101.append(r103);
        r101.append(r102.getResources().getQuantityString(R.plurals.ttlive_core_time_hour, r103));
    L9:
        if (r105 == 0) goto L11;
        r101.append(r105);
        r101.append(r102.getResources().getQuantityString(R.plurals.ttlive_core_time_minute, r105));
    L11:
        if (r106 == 0) goto L14;
        r101.append(r106);
        r101.append(r102.getResources().getQuantityString(R.plurals.ttlive_core_time_second, r106));
    L14:
        return r101.toString();
    }
}
