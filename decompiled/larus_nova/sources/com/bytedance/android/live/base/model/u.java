package com.bytedance.android.live.base.model;

import java.util.HashMap;

/* JADX INFO: loaded from: classes45.dex */
public final class u implements am3.c<Appointment> {
    public u() {
    }

    public static Appointment a(am3.g r110) throws Exception {
        Appointment r100 = new Appointment();
        r100.liveExtractsMap = new HashMap();
        long r101 = r110.c();
    L3:
        int r102 = r110.f();
        if (r102 == (-1)) goto L55;
        if (r102 != 5000) goto L8;
        r100.anchorOpenId = am3.h.c(r110);
        goto L3
    L8:
        if (r102 != 5001) goto L9;
        r100.anchorOpenIdStr = am3.h.c(r110);
        goto L3
    L9:
        switch(r102) {
            case 1: goto L52;
            case 2: goto L51;
            case 3: goto L50;
            case 4: goto L49;
            case 5: goto L48;
            case 6: goto L47;
            case 7: goto L46;
            case 8: goto L45;
            default: goto L10;
        };
    L45:
        r100.insidePushTitle = am3.h.c(r110);
        goto L3
    L46:
        r100.insidePushText = am3.h.c(r110);
        goto L3
    L47:
        r100.endTime = r110.j();
        goto L3
    L48:
        r100.startTime = r110.j();
        goto L3
    L49:
        r100.roomId = r110.j();
        goto L3
    L50:
        r100.anchorId = r110.j();
        goto L3
    L51:
        r100.appointmentType = (int) r110.j();
        goto L3
    L52:
        r100.appointmentId = r110.j();
        goto L3
    L10:
        switch(r102) {
            case 10: goto L44;
            case 11: goto L43;
            case 12: goto L42;
            case 13: goto L41;
            case 14: goto L40;
            case 15: goto L39;
            case 16: goto L38;
            case 17: goto L37;
            case 18: goto L36;
            case 19: goto L35;
            case 20: goto L34;
            case 21: goto L33;
            case 22: goto L15;
            case 23: goto L14;
            case 24: goto L13;
            case 25: goto L12;
            default: goto L11;
        };
    L12:
        r100.showStatus = (int) r110.j();
        goto L3
    L13:
        r100.isReserved = Boolean.valueOf(am3.h.a(r110));
        goto L3
    L14:
        r100.isLiving = Boolean.valueOf(am3.h.a(r110));
        goto L3
    L15:
        long r103 = r110.c();
        Long r104 = null;
        Appointment.LiveFragments r105 = null;
    L16:
        int r106 = r110.f();
        if (r106 == (-1)) goto L25;
        if (r106 != 1) goto L21;
        r104 = Long.valueOf(r110.j());
        goto L16
    L21:
        if (r106 != 2) goto L16;
        r105 = t.a(r110);
        goto L16
    L25:
        r110.d(r103);
        if (r104 == null) goto L32;
        if (r105 == null) goto L30;
        r100.liveExtractsMap.put(r104, r105);
        goto L3
    L30:
        throw new IllegalStateException("Map value must not be null!");
    L32:
        throw new IllegalStateException("Map key must not be null!");
    L33:
        r100.secAnchorId = am3.h.c(r110);
        goto L3
    L34:
        r100.programJumpUrl = am3.h.c(r110);
        goto L3
    L35:
        r100.coverImgUrl = am3.h.c(r110);
        goto L3
    L36:
        r100.subTitle = am3.h.c(r110);
        goto L3
    L37:
        r100.title = am3.h.c(r110);
        goto L3
    L38:
        r100.groupId = String.valueOf(r110.j());
        goto L3
    L39:
        r100.roomIdStr = am3.h.c(r110);
        goto L3
    L40:
        r100.anchorIdStr = am3.h.c(r110);
        goto L3
    L41:
        r100.appointmentIdStr = am3.h.c(r110);
        goto L3
    L42:
        r100.dueStartTime = String.valueOf(r110.j());
        goto L3
    L43:
        r100.operator = am3.h.c(r110);
        goto L3
    L44:
        r100.subscriberCount = (int) r110.j();
        goto L3
    L11:
        am3.h.e(r110);
        goto L3
    L55:
        r110.d(r101);
        return r100;
    }

    @Override // am3.c
    public final Appointment decode(am3.g r100) throws Exception {
        return a(r100);
    }
}
