package com.bytedance.android.live.revenuelink.connect;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class h {
    public static final int a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$toLeaveSource");
        switch(r100.hashCode()) {
            case -1440118544: goto L42;
            case -1250551599: goto L38;
            case -1250551592: goto L35;
            case -1221226623: goto L32;
            case -413114405: goto L28;
            case -265223428: goto L25;
            case -73227430: goto L21;
            case 406337293: goto L18;
            case 842434370: goto L15;
            case 850524161: goto L12;
            case 896262826: goto L9;
            case 1668666719: goto L6;
            default: goto L66;
        };
    L66:
        return 0;
    L6:
        if (r100.equals("ceiling_view_leave") == true) goto L47;
        return 0;
    L47:
        return 3;
    L9:
        if (r100.equals("rtc_error") == false) goto L55;
        return 4;
    L55:
        return 0;
    L12:
        if (r100.equals("unusual_leave") == false) goto L56;
        return 5;
    L56:
        return 0;
    L15:
        if (r100.equals("unusual_close") == false) goto L57;
        return 5;
    L57:
        return 0;
    L18:
        if (r100.equals("rtc_start_error") == false) goto L58;
        return 4;
    L58:
        return 0;
    L21:
        if (r100.equals("close_icon_room") == false) goto L59;
        return 6;
    L59:
        return 0;
    L25:
        if (r100.equals("random_link_finish") == false) goto L60;
        return 4;
    L60:
        return 0;
    L28:
        if (r100.equals("close_icon_disconnect") == false) goto L61;
        return 3;
    L61:
        return 0;
    L32:
        if (r100.equals("leave_for_random") == false) goto L62;
        return 4;
    L62:
        return 0;
    L35:
        if (r100.equals("receive_link_message_9") == false) goto L63;
        return 4;
    L63:
        return 0;
    L38:
        if (r100.equals("receive_link_message_2") == false) goto L64;
        return 5;
    L64:
        return 0;
    L42:
        if (r100.equals("leave_for_apply") == false) goto L65;
        return 4;
    L65:
        return 0;
    }
}
