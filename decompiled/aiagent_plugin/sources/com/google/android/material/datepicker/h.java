package com.google.android.material.datepicker;

import java.util.Calendar;
import java.util.TimeZone;

/* JADX INFO: compiled from: TimeSource.java */
/* JADX INFO: loaded from: classes2.dex */
class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final h f13368a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Long f13369b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final TimeZone f13370c;

    static {
        f13368a = new h(null, null);
    }

    private h(Long r1, TimeZone r2) {
        this.f13369b = r1;
        this.f13370c = r2;
    }

    static h a() {
        return f13368a;
    }

    Calendar b() {
        return a(this.f13370c);
    }

    Calendar a(TimeZone r3) {
        if (r3 != null) goto L4;
        Calendar r4 = Calendar.getInstance();
    L5:
        Long r2 = this.f13369b;
        if (r2 == null) goto L8;
        r4.setTimeInMillis(r2.longValue());
    L8:
        return r4;
    L4:
        r4 = Calendar.getInstance(r3);
        goto L5
    }
}
