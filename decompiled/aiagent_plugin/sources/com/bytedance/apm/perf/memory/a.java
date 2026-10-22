package com.bytedance.apm.perf.memory;

import android.app.Activity;
import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.apm.c;
import com.bytedance.apm.h.e;
import com.bytedance.monitor.a.b.d;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.ReferenceQueue;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: compiled from: DetectActivityLeakTask.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    private static final String TAG = "DetectActivityLeakTask";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static a f4844d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static boolean f4845e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Handler f4846a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ReferenceQueue<Object> f4847b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Set<String> f4848c;
    private com.bytedance.apm.config.a f;
    private long g;
    private volatile d h;

    public a() {
    }

    static /* synthetic */ String a(a r2, Activity r3) {
        return r2.b((Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.aiagent.plugin"));
    }

    static /* synthetic */ Set a(a r0) {
        return r0.f4848c;
    }

    static /* synthetic */ void a(a r0, com.bytedance.apm.perf.memory.utils.b r1, String r2) {
        r0.a(r1, r2);
    }

    static /* synthetic */ boolean a(a r0, com.bytedance.apm.perf.memory.utils.b r1) {
        return r0.c(r1);
    }

    static /* synthetic */ ReferenceQueue b(a r0) {
        return r0.f4847b;
    }

    static /* synthetic */ void b(a r0, com.bytedance.apm.perf.memory.utils.b r1) {
        r0.b(r1);
    }

    static /* synthetic */ void b(a r0, com.bytedance.apm.perf.memory.utils.b r1, String r2) {
        r0.b(r1, r2);
    }

    static /* synthetic */ void c(a r0) {
        r0.d();
    }

    static /* synthetic */ com.bytedance.apm.config.a d(a r0) {
        return r0.f;
    }

    static /* synthetic */ void e(a r0) {
        r0.c();
    }

    static {
        f4844d = new a();
        f4845e = false;
    }

    public static void a(Application r2, com.bytedance.apm.config.a r3) {
        Application r4 = (Application) ZeusTransformUtils.wrapperContextForParams(r2, Application.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L10;
        if (r3 != null) goto L7;
        return;
    L7:
        if (f4845e == true) goto L11;
        f4845e = true;
        f4844d.b(r4, r3);
        return;
    L11:
        return;
    }

    public void b(Application r5, com.bytedance.apm.config.a r6) {
        Application r7 = (Application) ZeusTransformUtils.wrapperContextForParams(r5, Application.class, "com.obric.aiagent.plugin");
        this.f = r6;
        this.g = r6.b();
        long r0 = System.currentTimeMillis();
        a(r7);
        if (c.i() == false) goto L6;
        e.c(TAG, new String[]{"initActivityLeakCheck done, cost: " + (System.currentTimeMillis() - r0) + " ms."});
        return;
    }

    private void a(Application r3) {
        Application r4 = (Application) ZeusTransformUtils.wrapperContextForParams(r3, Application.class, "com.obric.aiagent.plugin");
        this.f4846a = new Handler(Looper.getMainLooper());
        this.f4847b = new ReferenceQueue();
        this.f4848c = new CopyOnWriteArraySet();
        r4.registerActivityLifecycleCallbacks(new DetectActivityLeakTask$1(this));
    }

    private void a(final com.bytedance.apm.perf.memory.utils.b r4, final String r5) {
        if (this.h != null) goto L5;
        this.h = com.bytedance.monitor.a.b.c.a();
    L5:
        this.h.a(com.bytedance.monitor.a.b.c.a("LeakCheck-Thread", new AnonymousClass1(this, r4, r5)), a());
    }

    private long a() {
        if (this.g > 0) goto L6;
        this.g = 60000;
    L6:
        return this.g;
    }

    private void b(com.bytedance.apm.perf.memory.utils.b r5, String r6) {
        if (c.i() == false) goto L5;
        e.a(TAG, new String[]{"Leak:" + r6});
    L5:
        Activity r7 = (Activity) ZeusTransformUtils.preCheckCast(r5.get(), Activity.class, "com.obric.aiagent.plugin");
        if (r7 != null) goto L9;
        return;
    L9:
        if (this.f.d() == false) goto L12;
        a(r5);
    L12:
        if (this.f.c() == false) goto L14;
        a(r7);
    L14:
        this.f4848c.remove(r5.f4854a);
        b r4 = this.f.e();
        if (r4 == null) goto L18;
        r4.onActivityLeaked(r7);
        return;
    }

    private void a(final com.bytedance.apm.perf.memory.utils.b r3) {
        this.f4846a.post(new AnonymousClass2(this, r3));
    }

    private void b() {
        Thread.sleep(100);     // Catch: InterruptedException -> L5
        return;
    L6:
        throw new AssertionError();
    }

    private void c() {
        long r0 = System.currentTimeMillis();
        Runtime.getRuntime().gc();
        b();
        System.runFinalization();
        if (c.i() == false) goto L6;
        e.c(TAG, new String[]{"GC time done, cost: " + (System.currentTimeMillis() - r0) + " ms."});
        return;
    }

    private void a(Activity r4) {
        Activity r3 = (Activity) ZeusTransformUtils.wrapperContextForParams(r4, Activity.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L5;
        return;
    L5:
        com.bytedance.apm.perf.memory.utils.a.a(r3.getClass().getName());
        if (c.i() == false) goto L9;
        e.c(TAG, new String[]{"upload leak activity:" + r3.getLocalClassName()});
        return;
    }

    private void b(final com.bytedance.apm.perf.memory.utils.b r3) {
        Looper.myQueue().addIdleHandler(new DetectActivityLeakTask$4(this, r3));
    }

    private String b(Activity r2) {
        return ((Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin")).getLocalClassName();
    }

    private void d() {
    L2:
        com.bytedance.apm.perf.memory.utils.b r0 = (com.bytedance.apm.perf.memory.utils.b) ZeusTransformUtils.preCheckCast(this.f4847b.poll(), com.bytedance.apm.perf.memory.utils.b.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L5;
        this.f4848c.remove(r0.f4854a);
        goto L2
    }

    private boolean c(com.bytedance.apm.perf.memory.utils.b r1) {
        return !this.f4848c.contains(r1.f4854a);
    }
}
