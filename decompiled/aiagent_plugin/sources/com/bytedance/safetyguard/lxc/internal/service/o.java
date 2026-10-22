package com.bytedance.safetyguard.lxc.internal.service;

import android.os.IBinder;
import com.bytedance.safetyguard.lxc.internal.ipc.IPolicyResultCallback;
import com.bytedance.safetyguard.lxc.internal.ipc.OutboundTargetParcel;

/* JADX INFO: compiled from: ServiceProxySession.kt */
/* JADX INFO: loaded from: classes.dex */
public interface o {
    void a(long r1, OutboundTargetParcel r3, IPolicyResultCallback r4);

    void a(IBinder.DeathRecipient r1);

    boolean a();

    void b(IBinder.DeathRecipient r1);
}
