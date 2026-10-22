package com.bytedanceos.appstore;

import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.d0;
import kotlinx.coroutines.h;

/* JADX INFO: loaded from: classes2.dex */
public final class SystemBroadcastReceiverKtx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineScope f8275a;

    public SystemBroadcastReceiverKtx() {
        this.f8275a = d0.b();
    }

    public final void a(String r10) {
        q.g(r10, "packageName");
        h.d(this.f8275a, null, null, new SystemBroadcastReceiverKtx$removeUpdateCache$1(r10, null), 3, null);
    }
}
