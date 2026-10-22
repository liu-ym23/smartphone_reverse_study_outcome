package com.bytedance.android.live.room.api.messagewindow.monitor;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f99024a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final double f99025b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f99026c;

    public interface a {
        h a();
    }

    public j(fm0.a.C5927a r100) {
        Intrinsics.checkNotNullParameter(r100, "cb");
        this.f99026c = r100;
        int r101 = v71.a.f553415a;
        m71.c r102 = m71.c.f512325a;
        n71.b r103 = r102.getValue();
        boolean r104 = false;
        if (r103 == null) goto L7;
        Boolean r105 = r103.h();
        if (r105 == null) goto L7;
        boolean r106 = r105.booleanValue();
    L8:
        this.f99024a = r106;
        n71.b r107 = r102.getValue();
        if (r107 == null) goto L18;
        Double r108 = Double.valueOf(r107.i());
        if (r108.doubleValue() <= 0.0f) goto L13;
        r104 = true;
    L13:
        if (r104 == true) goto L16;
        r108 = null;
    L16:
        if (r108 == null) goto L18;
        double r109 = r108.doubleValue();
    L19:
        this.f99025b = r109;
        return;
    L18:
        r109 = 1.0E-5d;
    L7:
        r106 = false;
        goto L8
    }
}
