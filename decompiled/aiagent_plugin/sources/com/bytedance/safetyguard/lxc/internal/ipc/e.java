package com.bytedance.safetyguard.lxc.internal.ipc;

import d.h.b.o;

/* JADX INFO: compiled from: ProxyIpcValidator.kt */
/* JADX INFO: loaded from: classes.dex */
public final class e extends IllegalArgumentException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f10919a;

    public e(int r2, String r3) {
        o.e(r3, "message");
        super(r3);
        this.f10919a = r2;
    }
}
