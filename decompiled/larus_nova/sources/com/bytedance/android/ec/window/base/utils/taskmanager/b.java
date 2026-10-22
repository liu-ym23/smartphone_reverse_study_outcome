package com.bytedance.android.ec.window.base.utils.taskmanager;

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
public final class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f49775c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<String, ThreadPoolExecutor> f49776a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f49777b;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.android.ec.window.base.utils.taskmanager.b$b, reason: collision with other inner class name */
    public static final class C0853b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f49778a = null;

        static {
            f49778a = new b();
        }
    }

    public final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f49779a;

        public c(Function0 r100) {
            this.f49779a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f49779a.invoke();     // Catch: Throwable -> L4
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

    public b() {
        this.f49776a = new HashMap();
        this.f49777b = Runtime.getRuntime().availableProcessors();
    }

    public final void a(WindowExecutorType r110, Function0<Unit> r111) {
        Intrinsics.checkNotNullParameter(r110, "type");
        Intrinsics.checkNotNullParameter(r111, "runnable");
        ThreadPoolExecutor r100 = this.f49776a.get(r110.getValue());
        if (r100 != null) goto L16;
        String r101 = r110.getValue();
        if (Intrinsics.areEqual(r101, WindowExecutorType.COMPUTE_HIGH_LEVEL.getValue()) == false) goto L8;
        int r102 = this.f49777b + 1;
        PThreadPoolExecutor r103 = new PThreadPoolExecutor(r102, r102, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.bytedance.android.ec.window.base.utils.taskmanager.a(r101, 10));
    L13:
        r100 = r103;
    L15:
        r100.allowCoreThreadTimeOut(true);
        this.f49776a.put(r110.getValue(), r100);
        goto L16
    L8:
        if (Intrinsics.areEqual(r101, WindowExecutorType.COMPUTE.getValue()) == false) goto L11;
        int r104 = this.f49777b + 1;
        r103 = new PThreadPoolExecutor(r104, r104, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.bytedance.android.ec.window.base.utils.taskmanager.a(r101, 5));
        goto L13
    L11:
        if (Intrinsics.areEqual(r101, WindowExecutorType.IO.getValue()) == false) goto L14;
        int r105 = this.f49777b * 2;
        r103 = new PThreadPoolExecutor(r105, r105, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.bytedance.android.ec.window.base.utils.taskmanager.a(r101, 5));
        goto L13
    L14:
        r100 = new PThreadPoolExecutor(2, 2, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.bytedance.android.ec.window.base.utils.taskmanager.a(WindowExecutorType.DEFAULT.getValue(), 5));
    L16:
        r100.execute(new c(r111));
    }
}
