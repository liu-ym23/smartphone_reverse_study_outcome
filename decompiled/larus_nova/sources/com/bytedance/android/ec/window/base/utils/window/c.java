package com.bytedance.android.ec.window.base.utils.window;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes44.dex */
public class c<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedBlockingQueue<T> f49792a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<T> f49793b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f49794c;

    public c() {
        this(1);
    }

    public c(int r100) {
        this.f49794c = r100;
        this.f49792a = new LinkedBlockingQueue();
        this.f49793b = new LinkedHashSet();
    }

    public final synchronized T a(Function0<? extends T> r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "resourceGenerator");     // Catch: Throwable -> L11
        int r101 = RangesKt.coerceAtLeast(this.f49794c, 1);     // Catch: Throwable -> L11
        if (this.f49792a.size() < r101) goto L8;
        T r102 = this.f49792a.poll();     // Catch: Throwable -> L11
        this.f49793b.add(r102);     // Catch: Throwable -> L11
        monitor-exit(this);
        return r102;
    L8:
        T r103 = r100.invoke();     // Catch: Throwable -> L11
        this.f49793b.add(r103);     // Catch: Throwable -> L11
        monitor-exit(this);
        return r103;
    L11:
        th = move-exception;
        throw th;
    }

    public final synchronized void b(T r100) {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.f49793b.remove(r100) == false) goto L6;
        this.f49792a.offer(r100);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
    }
}
