package com.fasterxml.jackson.core.util;

import com.fasterxml.jackson.core.util.JsonRecyclerPools;
import e8.c;
import java.util.LinkedHashMap;
import java.util.function.Supplier;
import reactor.core.scheduler.Schedulers;
import reactor.util.concurrent.Queues;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements Supplier {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f2303c;

    public /* synthetic */ a(int i) {
        this.f2303c = i;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f2303c) {
            case 0:
                return JsonRecyclerPools.ConcurrentDequePool.construct();
            case 1:
                return JsonRecyclerPools.LockFreePool.construct();
            case 2:
                ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
                return contextClassLoader == null ? c.class.getClassLoader() : contextClassLoader;
            case 3:
                return new LinkedHashMap();
            case 4:
                return Queues.lambda$static$3();
            case 5:
                return Queues.lambda$static$4();
            case 6:
                return Queues.lambda$static$5();
            case 7:
                return Queues.lambda$static$6();
            case 8:
                return Queues.lambda$static$7();
            case 9:
                return Queues.lambda$static$8();
            case 10:
                return Queues.lambda$unboundedMultiproducer$2();
            default:
                return Schedulers.parallel();
        }
    }
}
