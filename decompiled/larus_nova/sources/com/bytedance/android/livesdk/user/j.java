package com.bytedance.android.livesdk.user;

import java.util.HashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class j {
    static {
    }

    @JvmStatic
    public static final HashMap<String, String> a(int r100) {
        LiveFollowScene[] r101 = LiveFollowScene.values();
        int r102 = r101.length;
        int r103 = 0;
    L4:
        if (r103 >= r102) goto L12;
        LiveFollowScene r104 = r101[r103];
        if (r104.getIdentity() != r100) goto L8;
        boolean r105 = true;
    L9:
        if (r105 == true) goto L13;
        r103 = r103 + 1;
    L13:
        if (r104 != null) goto L16;
        return null;
    L16:
        return b(r104);
    L8:
        r105 = false;
        goto L9
    L12:
        r104 = null;
        goto L13
    }

    @JvmStatic
    public static final HashMap<String, String> b(LiveFollowScene r110) {
        Intrinsics.checkNotNullParameter(r110, "followScene");
        Pair[] r100 = new Pair[3];
        switch(i.f158671a[r110.ordinal()]) {
            case 1: goto L5;
            case 2: goto L5;
            case 3: goto L5;
            case 4: goto L5;
            case 5: goto L5;
            case 6: goto L5;
            case 7: goto L5;
            case 8: goto L5;
            case 9: goto L5;
            default: goto L6;
        };
    L5:
        String r101 = r110.getReportFromPre();
    L31:
        r100[0] = TuplesKt.to("report_from_pre", r101);
        r100[1] = TuplesKt.to("report_from_label", r110.getReportFromLabel());
        r100[2] = TuplesKt.to("report_from_action", r110.getReportFromAction());
        return MapsKt.hashMapOf(r100);
    L6:
        ReportFromPreEnum.Companion.getClass();
        Intrinsics.checkNotNullParameter(r110, "followScene");
        com.bytedance.android.livesdk.log.filter.o r102 = com.bytedance.android.livesdk.log.j0.l().c(am2.x.class);
        if (r102 == null) goto L9;
        Map<String, String> r103 = r102.getMap();
    L10:
        String r104 = "";
        if (r103 == null) goto L14;
        String r105 = r103.get("enter_from_merge");
        if (r105 == null) goto L14;
    L15:
        if (r103 == null) goto L18;
        String r106 = r103.get("enter_method");
        if (r106 == null) goto L18;
    L19:
        if (r103 == null) goto L24;
        String r107 = r103.get("action_type");
        if (r107 == null) goto L24;
        r104 = r107;
    L24:
        ReportFromPreEnum[] r108 = ReportFromPreEnum.values();
        int r109 = r108.length;
        int r111 = 0;
    L25:
        if (r111 >= r109) goto L30;
        ReportFromPreEnum r112 = r108[r111];
        if (r112.match(r110, r105, r106, r104) == true) goto L28;
        r111 = r111 + 1;
        goto L25
    L28:
        r101 = r112.getReportFromPre(r110);
        goto L31
    L30:
        r101 = r110.getReportFromPre();
    L18:
        r106 = "";
    L14:
        r105 = "";
        goto L15
    L9:
        r103 = null;
        goto L10
    }
}
