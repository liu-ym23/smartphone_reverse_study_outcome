package com.bytedance.android.live.base.model;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes45.dex */
public final class t implements am3.c<Appointment.LiveFragments> {
    public t() {
    }

    public static Appointment.LiveFragments a(am3.g r100) throws Exception {
        Appointment.LiveFragments r101 = new Appointment.LiveFragments();
        r101.extractItemIds = new ArrayList();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L9;
        if (r103 != 1) goto L7;
        r101.extractItemIds.add(Long.valueOf(r100.j()));
        goto L3
    L7:
        am3.h.e(r100);
        goto L3
    L9:
        r100.d(r102);
        return r101;
    }

    @Override // am3.c
    public final Appointment.LiveFragments decode(am3.g r100) throws Exception {
        return a(r100);
    }
}
