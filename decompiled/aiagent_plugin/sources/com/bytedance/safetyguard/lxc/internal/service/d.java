package com.bytedance.safetyguard.lxc.internal.service;

import android.os.ParcelFileDescriptor;
import com.bytedance.safetyguard.lxc.api.ProxySessionErrorCode;
import com.bytedance.safetyguard.lxc.internal.ipc.ProxySessionResultParcel;

/* JADX INFO: compiled from: AppGatewayServiceProxySession.kt */
/* JADX INFO: loaded from: classes.dex */
public final class d {
    private static final String TAG = "AppGatewayServiceProxySession";

    public static final /* synthetic */ ProxySessionResultParcel a(com.bytedance.safetyguard.lxc.internal.d.f r0) {
        return b(r0);
    }

    public static final /* synthetic */ void a(ParcelFileDescriptor r0) {
        b(r0);
    }

    private static final ProxySessionResultParcel b(com.bytedance.safetyguard.lxc.internal.d.f r19) {
        return new ProxySessionResultParcel(0, "internal", r19.a().ordinal(), a(r19.b()), r19.c(), r19.d().a(), r19.d().b(), r19.d().c(), r19.d().d(), null, null, 1537, null);
    }

    private static final int a(ProxySessionErrorCode r0) {
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.ordinal() + 1;
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
