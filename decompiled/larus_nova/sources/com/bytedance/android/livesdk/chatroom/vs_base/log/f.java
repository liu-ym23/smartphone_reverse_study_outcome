package com.bytedance.android.livesdk.chatroom.vs_base.log;

import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes8.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f118012a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static long f118013b;

    static {
        f118012a = "";
    }

    public static void a(DataCenter r110, int r111, Integer r112, int r113) {
        if (r110 != null) goto L4;
        return;
    L4:
        d r114 = d.a(r110);
        String r100 = "click";
        if (r111 == 0) goto L11;
        if (r111 == 1) goto L10;
        if (r111 == 2) goto L9;
        String r101 = "";
    L12:
        f118012a = r101;
        Pair[] r102 = new Pair[4];
        if (r111 == 2) goto L16;
        if (r111 == 3) goto L16;
    L17:
        r102[0] = TuplesKt.to("change_way", r100);
        long r103 = 0;
        if (f118013b == 0) goto L21;
        long r104 = System.currentTimeMillis();
        long r105 = r104 - f118013b;
        f118013b = r104;
        r103 = r105 / ((long) 1000);
    L21:
        r102[1] = TuplesKt.to("duration", String.valueOf(r103));
        if (r112 == null) goto L24;
        int r115 = r112.intValue();
    L25:
        String r116 = "4";
        if (r115 == 0) goto L34;
        if (r115 == 1) goto L33;
        if (r115 == 6) goto L32;
        if (r115 == 8) goto L31;
        Object r117 = "4";
    L35:
        r102[2] = TuplesKt.to("room_orientation_before", r117);
        if (r113 == 0) goto L44;
        if (r113 == 1) goto L43;
        if (r113 == 6) goto L42;
        if (r113 != 8) goto L45;
        r116 = "2";
    L45:
        r102[3] = TuplesKt.to("room_orientation_after", r116);
        r114.d("screen_rotate", MapsKt.hashMapOf(r102), new Object[0]);
        return;
    L42:
        r116 = "3";
        goto L45
    L43:
        r116 = "0";
        goto L45
    L44:
        r116 = "1";
        goto L45
    L31:
        r117 = "2";
        goto L35
    L32:
        r117 = "3";
        goto L35
    L33:
        r117 = "0";
        goto L35
    L34:
        r117 = "1";
        goto L35
    L24:
        r115 = 1;
    L16:
        r100 = "auto";
        goto L17
    L9:
        r101 = "counterclockwise_slide";
        goto L12
    L10:
        r101 = "clockwise_slide";
        goto L12
    L11:
        r101 = "click";
        goto L12
    }
}
