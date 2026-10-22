package com.bytedance.android.live.ktv.common.ordersong.theme;

import android.view.View;
import android.widget.TextView;
import com.ss.ttm.player.MediaPlayer;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class KtvOrderSongThemeManager {
    public static final int A = 0;
    public static final int B = 0;
    public static final int C = 0;
    public static final int D = 0;
    public static final int E = 0;
    public static final int F = 0;
    public static final int G = 0;
    public static final int H = 0;
    public static final int I = 0;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static final int f70191J = 0;
    public static final Lazy K = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f70192a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f70193b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f70194c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f70195d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f70196e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f70197f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f70198g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f70199h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f70200i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f70201j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f70202k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f70203l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f70204m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f70205n = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f70206o = 0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f70207p = 0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f70208q = 0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f70209r = 0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f70210s = 0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f70211t = 0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f70212u = 0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f70213v = 0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f70214w = 0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f70215x = 0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f70216y = 0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f70217z = 0;

    static {
        f70192a = 11;
        f70193b = 12;
        f70194c = 13;
        f70195d = 14;
        f70196e = 15;
        f70197f = 201;
        f70198g = 202;
        f70199h = 203;
        f70200i = 204;
        f70201j = 205;
        f70202k = 206;
        f70203l = 207;
        f70204m = 208;
        f70205n = 301;
        f70206o = 302;
        f70207p = 303;
        f70208q = 304;
        f70209r = 251;
        f70210s = 252;
        f70211t = 253;
        f70212u = 254;
        f70213v = 255;
        f70214w = 256;
        f70215x = 257;
        f70216y = 258;
        f70217z = MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RANGE_TIME;
        A = 401;
        B = 402;
        C = 403;
        D = 404;
        E = 501;
        F = 502;
        G = 503;
        H = 504;
        I = 505;
        f70191J = 506;
        K = LazyKt.lazy(KtvOrderSongThemeManager$LIGHT$2.INSTANCE);
    }

    public static int a(int r100) {
        Object r101 = ((HashMap) K.getValue()).get(Integer.valueOf(r100));
        if ((r101 instanceof Integer) == true) goto L5;
        r101 = null;
    L5:
        Integer r102 = (Integer) r101;
        if (r102 != null) goto L10;
        return 0;
    L10:
        return r102.intValue();
    }

    public static void b(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$setThemeBackGroundColor");
        r100.setBackgroundColor(a(r101));
    }

    public static void c(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$setThemeBackGroundRes");
        r100.setBackgroundResource(a(r101));
    }

    public static void d(TextView r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$setThemeTextColor");
        r100.setTextColor(a(r101));
    }
}
