package com.bytedance.android.ec.store.utils.taskmanager;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import java.util.HashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f48696c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<String, ThreadPoolExecutor> f48697a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f48698b;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f48699a = null;

        static {
            f48699a = new c();
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.ec.store.utils.taskmanager.c$c, reason: collision with other inner class name */
    public final class RunnableC0842c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f48700a;

        public RunnableC0842c(Function0 r100) {
            this.f48700a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f48700a.invoke();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public c() {
        this.f48697a = new HashMap();
        this.f48698b = Runtime.getRuntime().availableProcessors();
    }

    public final void a(ExecutorType r110, Function0<Unit> r111) {
        Intrinsics.checkNotNullParameter(r110, "type");
        Intrinsics.checkNotNullParameter(r111, "runnable");
        ThreadPoolExecutor r100 = this.f48697a.get(r110.getValue());
        if (r100 != null) goto L16;
        String r101 = r110.getValue();
        if (Intrinsics.areEqual(r101, ExecutorType.COMPUTE_HIGH_LEVEL.getValue()) == false) goto L8;
        int r102 = this.f48698b + 1;
        PThreadPoolExecutor r103 = new PThreadPoolExecutor(r102, r102, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.bytedance.android.ec.store.utils.taskmanager.a(r101, 10));
    L13:
        r100 = r103;
    L15:
        r100.allowCoreThreadTimeOut(true);
        this.f48697a.put(r110.getValue(), r100);
        goto L16
    L8:
        if (Intrinsics.areEqual(r101, ExecutorType.COMPUTE.getValue()) == false) goto L11;
        int r104 = this.f48698b + 1;
        r103 = new PThreadPoolExecutor(r104, r104, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.bytedance.android.ec.store.utils.taskmanager.a(r101, 5));
        goto L13
    L11:
        if (Intrinsics.areEqual(r101, ExecutorType.IO.getValue()) == false) goto L14;
        int r105 = this.f48698b * 2;
        r103 = new PThreadPoolExecutor(r105, r105, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.bytedance.android.ec.store.utils.taskmanager.a(r101, 5));
        goto L13
    L14:
        r100 = new PThreadPoolExecutor(2, 2, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.bytedance.android.ec.store.utils.taskmanager.a(ExecutorType.DEFAULT.getValue(), 5));
    L16:
        r100.execute(new RunnableC0842c(r111));
    }
}
