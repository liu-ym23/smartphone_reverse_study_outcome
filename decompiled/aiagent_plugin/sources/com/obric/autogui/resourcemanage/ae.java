package com.obric.autogui.resourcemanage;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: WifiEligibility.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ae {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicBoolean f30598a;

    public ae() {
        this(false, 1, null);
    }

    public ae(boolean r2) {
        this.f30598a = new AtomicBoolean(r2);
    }

    public /* synthetic */ ae(boolean r1, int r2, d.h.b.h r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = false;
    L5:
        this(r1);
    }

    public final void a(boolean r1) {
        this.f30598a.set(r1);
    }

    public final af update(boolean r1) {
        if (this.f30598a.getAndSet(r1) == r1) goto L9;
        if (r1 == false) goto L8;
        return af.f30600b;
    L8:
        return af.f30601c;
    L9:
        return af.f30599a;
    }
}
