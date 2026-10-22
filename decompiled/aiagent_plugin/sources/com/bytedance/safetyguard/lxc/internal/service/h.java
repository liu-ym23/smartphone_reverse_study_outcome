package com.bytedance.safetyguard.lxc.internal.service;

import android.os.ParcelFileDescriptor;

/* JADX INFO: compiled from: ClientRegistry.kt */
/* JADX INFO: loaded from: classes.dex */
public final class h {
    private static final String TAG = "ClientRegistry";

    public static final /* synthetic */ void a(ParcelFileDescriptor r0) {
        b(r0);
    }

    private static final void b(ParcelFileDescriptor r1) {
        d.n.a r0 = d.n.f38560a;     // Catch: Throwable -> L4
        r1.close();     // Catch: Throwable -> L4
        d.n.f(d.x.f38692a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        d.n.a r2 = d.n.f38560a;
        d.n.f(d.o.a(th));
    }
}
