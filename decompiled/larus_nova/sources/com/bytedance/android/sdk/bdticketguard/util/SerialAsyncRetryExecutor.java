package com.bytedance.android.sdk.bdticketguard.util;

import com.bytedance.android.sdk.bdticketguard.r0;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes12.dex */
public final class SerialAsyncRetryExecutor {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f164036f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f164037a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f164038b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicInteger f164039c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicBoolean f164040d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ConcurrentLinkedQueue<a> f164041e;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b f164042a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f164043b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f164044c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L5;
        L20:
            return true;
        L5:
            if ((r100 instanceof a) == false) goto L19;
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f164042a, r101.f164042a) == false) goto L19;
            if (this.f164043b != r101.f164043b) goto L11;
            boolean r102 = true;
        L12:
            if (r102 == false) goto L19;
            if (this.f164044c != r101.f164044c) goto L16;
            boolean r103 = true;
        L17:
            if (r103 == false) goto L19;
        L16:
            r103 = false;
            goto L17
        L11:
            r102 = false;
        L19:
            return false;
        }

        public final int hashCode() {
            b r100 = this.f164042a;
            if (r100 == null) goto L5;
            int r101 = r100.hashCode();
        L7:
            return (((r101 * 31) + this.f164043b) * 31) + this.f164044c;
        L5:
            r101 = 0;
            goto L7
        }

        public final String toString() {
            return "TaskWrapper(task=" + this.f164042a + ", retryCount=" + this.f164043b + ", taskGen=" + this.f164044c + ")";
        }

        public a(b r100, int r101, int r102) {
            this.f164042a = r100;
            this.f164043b = r101;
            this.f164044c = r102;
        }
    }

    static {
        f164036f = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(SerialAsyncRetryExecutor.class), "scheduler", "getScheduler()Ljava/util/concurrent/ScheduledExecutorService;"))};
    }

    public final ScheduledExecutorService b() {
        Lazy r100 = this.f164038b;
        KProperty r101 = f164036f[0];
        return (ScheduledExecutorService) r100.getValue();
    }

    public SerialAsyncRetryExecutor() {
        this.f164037a = "SerialAsyncRetryExecutor";
        this.f164038b = LazyKt.lazy(SerialAsyncRetryExecutor$scheduler$2.INSTANCE);
        this.f164039c = new AtomicInteger(0);
        this.f164040d = new AtomicBoolean(false);
        this.f164041e = new ConcurrentLinkedQueue();
    }

    public static final void a(SerialAsyncRetryExecutor r100) {
        if (r100.f164040d.compareAndSet(false, true) == false) goto L20;
        a r101 = r100.f164041e.poll();
        if (r101 != null) goto L8;
        r100.f164040d.set(false);
        int r102 = r0.f163979a;
        r0.a(r100.f164037a, "tryStartNext: no task");
        return;
    L8:
        b r103 = r101.f164042a;
        int r104 = r101.f164043b;
        int r105 = r101.f164044c;
        if (r105 == r100.f164039c.get()) goto L16;
        r100.f164040d.set(false);
        int r106 = r0.f163979a;
        r0.a(r100.f164037a, "tryStartNext: task gen " + r105 + " is expired, current gen " + r100.f164039c.get());
        r100.b().execute(new h(r100));
        return;
    L16:
        r103.a(r104, new i(r100, r105, r103, r104));     // Catch: Exception -> L13
        return;
    L13:
        e = move-exception;
        int r107 = r0.f163979a;
        r0.d(6, r100.f164037a, "tryStartNext: task " + r103 + " execute failed", e);
        r100.b().execute(new f(r100, r103.b(r104 + 1), r105, r103, r104));
        return;
    }
}
