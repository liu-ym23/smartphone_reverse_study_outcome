package com.stepos.statsapp.v3.lib.plugin.emitter.remote;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e implements ThreadFactory {

    /* renamed from: c, reason: collision with root package name */
    public AtomicInteger f2829c;

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        AtomicInteger atomicInteger = this.f2829c;
        if (atomicInteger.get() == Integer.MAX_VALUE) {
            atomicInteger.set(0);
        }
        return new Thread(runnable, "V3OfflineEmitterTask#" + atomicInteger.getAndIncrement());
    }
}
