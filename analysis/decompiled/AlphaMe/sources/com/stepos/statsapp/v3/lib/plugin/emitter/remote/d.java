package com.stepos.statsapp.v3.lib.plugin.emitter.remote;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public final class d implements ThreadFactory {

    /* renamed from: a, reason: collision with root package name */
    public AtomicInteger f12325a;

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        AtomicInteger atomicInteger = this.f12325a;
        if (atomicInteger.get() == Integer.MAX_VALUE) {
            atomicInteger.set(0);
        }
        return new Thread(runnable, "V3OfflineEmitterTask#" + atomicInteger.getAndIncrement());
    }
}
