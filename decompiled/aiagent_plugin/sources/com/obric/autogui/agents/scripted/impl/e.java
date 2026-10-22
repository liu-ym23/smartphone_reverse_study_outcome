package com.obric.autogui.agents.scripted.impl;

import android.content.Context;
import com.bytedance.vmsdk.jsbridge.JSModuleManager;
import com.bytedance.vmsdk.worker.JsWorker;
import com.obric.autogui.common.api.AOSystemTools;
import com.obric.autogui.common.api.logging.Loog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.x;
import java.io.File;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: JsWorkerPoolManager.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e implements com.obric.autogui.agents.scripted.api.b {
    private static final String TAG = "Script-JsWorkerPoolManager";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f26983a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ConcurrentLinkedQueue<b> f26984b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AtomicInteger f26985c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AtomicInteger f26986d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final AtomicBoolean f26987e;
    private final ScheduledExecutorService f;

    /* JADX INFO: compiled from: JsWorkerPoolManager.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: JsWorkerPoolManager.kt */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final JsWorker f26988a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f26989b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f26988a, r6.f26988a) == true) goto L12;
            return false;
        L12:
            if (this.f26989b == r6.f26989b) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f26988a.hashCode() * 31) + Integer.hashCode(this.f26989b);
        }

        public String toString() {
            return "WorkerWrapper(worker=" + this.f26988a + ", generation=" + this.f26989b + ')';
        }

        public b(JsWorker r2, int r3) {
            d.h.b.o.e(r2, "worker");
            this.f26988a = r2;
            this.f26989b = r3;
        }

        public final JsWorker a() {
            return this.f26988a;
        }

        public final int b() {
            return this.f26989b;
        }
    }

    static {
        f26983a = new a(null);
    }

    public static /* synthetic */ void lambda$D4wLC_wWu_Xbi1XNVH7UZDzinvE(e r0) {
        a(r0);
    }

    public e() {
        this.f26984b = new ConcurrentLinkedQueue();
        this.f26985c = new AtomicInteger(0);
        this.f26986d = new AtomicInteger(0);
        this.f26987e = new AtomicBoolean(false);
        this.f = Executors.newSingleThreadScheduledExecutor();
    }

    @Override // com.obric.autogui.agents.scripted.api.b
    public Object onFoundationReady(Context r3, d.c.d<? super x> r4) {
        return com.obric.autogui.agents.scripted.api.b.a.a(this, (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public void a() {
        if (this.f26987e.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        this.f.scheduleAtFixedRate(new $$Lambda$e$D4wLC_wWu_Xbi1XNVH7UZDzinvE(this), 5, 5, TimeUnit.MINUTES);
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L9;
        Loog.INSTANCE.d(TAG, "Periodic worker pool clear task scheduled every 5 minutes");
        return;
    }

    public final d.m<b, Boolean> a(Context r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r8, "context");
        b r0 = (b) ZeusTransformUtils.preCheckCast(this.f26984b.poll(), b.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L19;
        this.f26985c.decrementAndGet();
        if (r0.b() != this.f26986d.get()) goto L12;
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L10;
        Loog.INSTANCE.d(TAG, "Reusing cached PreCheck JSWorker, generation=" + r0.b());
    L10:
        return new d.m(r0, false);
    L12:
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L23;
        Loog.INSTANCE.d(TAG, "Discarding old generation cached PreCheck JSWorker, pool generation=" + r0.b() + ", current=" + this.f26986d.get());
    L23:
        r0.a().terminate();     // Catch: Exception -> L16
    L16:
        e = move-exception;
        com.obric.autogui.agents.scripted.c.c.a(TAG, "Error terminating old cached JSWorker", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    L19:
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L22;
        Loog.INSTANCE.d(TAG, "No valid cached PreCheck JSWorker available, creating new one for generation=" + this.f26986d.get());
    L22:
        return new d.m(new b(a(this, r8, null, 2, null), this.f26986d.get()), true);
    }

    public final void a(b r7, boolean r8) {
        d.h.b.o.e(r7, "wrapper");
        JsWorker r0 = r7.a();
        r0.setOnMessageCallback(null);
        r0.setOnErrorCallback(null);
        boolean r1 = true;
        if (r8 == false) goto L12;
        if (r7.b() != this.f26986d.get()) goto L12;
        if (this.f26985c.get() >= 1) goto L12;
        this.f26984b.offer(r7);
        this.f26985c.incrementAndGet();
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L20;
        Loog.INSTANCE.d(TAG, "Returned PreCheck JSWorker to pool, current size: " + this.f26985c.get());
        return;
    L20:
        return;
    L12:
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L18;
        Loog r3 = Loog.INSTANCE;
        StringBuilder r9 = new StringBuilder().append("Terminating PreCheck JSWorker. success=").append(r8).append(", generationMatch=");
        if (r7.b() == this.f26986d.get()) goto L17;
        r1 = false;
    L17:
        r3.d(TAG, r9.append(r1).append(", poolSize=").append(this.f26985c.get()).toString());
    L18:
        r0.terminate();
    }

    public final JsWorker b(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "context");
        return b(this, r4, null, 2, null);
    }

    static /* synthetic */ JsWorker a(e r1, Context r2, JsWorker.EngineType r3, int r4, Object r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L6;
        r3 = JsWorker.EngineType.QUICKJS;
    L6:
        return r1.a(r6, r3);
    }

    private final JsWorker a(Context r5, JsWorker.EngineType r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        JSModuleManager r0 = new JSModuleManager(r7);
        r0.a(AOScriptJSModule.NAME, AOScriptJSModule.class, null);
        return a(r7, r0, r6);
    }

    static /* synthetic */ JsWorker b(e r1, Context r2, JsWorker.EngineType r3, int r4, Object r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L6;
        r3 = JsWorker.EngineType.QUICKJS;
    L6:
        return r1.b(r6, r3);
    }

    private final JsWorker b(Context r5, JsWorker.EngineType r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        JSModuleManager r0 = new JSModuleManager(r7);
        r0.a(AOScriptJSModule.NAME, AOScriptJSModule.class, null);
        r0.a(ImageProcessJSModule.NAME, ImageProcessJSModule.class, null);
        return a(r7, r0, r6);
    }

    private final JsWorker a(Context r2, JSModuleManager r3, JsWorker.EngineType r4) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        com.obric.autogui.agents.scripted.impl.a.f26972a.a();
        if (r4 != JsWorker.EngineType.V8) goto L9;
        File r5 = new File(r1.getCacheDir(), "v8_code_cache");
        if (r5.exists() == true) goto L7;
        r5.mkdirs();
    L7:
        String r6 = r5.getAbsolutePath();
    L16:
        return new JsWorker(new com.bytedance.vmsdk.worker.c.a().a("js_script_precheck_engine").a(r3).a(r4).b(r6).a(AOSystemTools.INSTANCE.isDebugVersion()).b(true).a());
    L9:
        if (r4 != JsWorker.EngineType.QUICKJS) goto L14;
        File r7 = new File(r1.getCacheDir(), "quickjs_code_cache");
        if (r7.exists() == true) goto L13;
        r7.mkdirs();
    L13:
        r6 = r7.getAbsolutePath();
        goto L16
    L14:
        r6 = null;
        goto L16
    }

    public final void b() {
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L5;
        Loog.INSTANCE.d(TAG, "Clearing preCheck JSWorker pool, bumping generation");
    L5:
        this.f26986d.incrementAndGet();
        b r0 = (b) ZeusTransformUtils.preCheckCast(this.f26984b.poll(), b.class, "com.obric.aiagent.plugin");
    L6:
        if (r0 == null) goto L12;
        r0.a().terminate();     // Catch: Exception -> L9
    L11:
        this.f26985c.decrementAndGet();
        r0 = (b) ZeusTransformUtils.preCheckCast(this.f26984b.poll(), b.class, "com.obric.aiagent.plugin");
    L9:
        e = move-exception;
        com.obric.autogui.agents.scripted.c.c.a(TAG, "Error terminating cached JSWorker", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        goto L11
    L12:
        this.f26985c.set(0);
    }

    public final void a(b r3) {
        d.h.b.o.e(r3, "wrapper");
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L5;
        Loog.INSTANCE.d(TAG, "Abandoning slow/timed-out JSWorker. IT WILL NOT BE TERMINATED to prevent Native Crash.");
    L5:
        r3.a().setOnMessageCallback(null);
        r3.a().setOnErrorCallback(null);
    }

    private static final void a(e r3) {
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L5;
        Loog.INSTANCE.d(TAG, "Periodic worker pool clear task executed");
    L5:
        r3.b();
    }
}
