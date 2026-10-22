package com.obric.agent.im;

import com.obric.aiagent.assistant.idl.IFlowMessageCallbackIDL;
import com.obric.aiagent.assistant.idl.IFlowMessageIDL;
import com.obric.aiagent.assistant.idl.ai;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.n;
import d.x;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: FlowMessageCallbackHub.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a {
    private static final String TAG = "FlowMessageCallbackHub";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f14573a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final CopyOnWriteArrayList<C0291a> f14574b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final CopyOnWriteArrayList<d> f14575c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final AtomicInteger f14576d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final ExecutorService f14577e = null;
    private static final FlowMessageCallbackHub$ipcCallback$1 f = null;

    /* JADX INFO: renamed from: com.obric.agent.im.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: FlowMessageCallbackHub.kt */
    private static final class C0291a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final d f14578a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final AtomicBoolean f14579b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final b f14580c;

        public static /* synthetic */ void lambda$_aiIC8qnymZVwatc4KpF9vX9SHA(C0291a r0, d.h.a.b r1) {
            a(r0, r1);
        }

        public C0291a(d r3, Executor r4) {
            d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
            Executor r6 = (Executor) ZeusTransformUtils.wrapperContextForParams(r4, Executor.class, "com.obric.aiagent.plugin");
            o.e(r5, "observer");
            o.e(r6, "executor");
            this.f14578a = r5;
            this.f14579b = new AtomicBoolean(true);
            this.f14580c = new b(r6);
        }

        public final d a() {
            return this.f14578a;
        }

        public final void a(d.h.a.b<? super d, x> r3) {
            final d.h.a.b r4 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
            o.e(r4, "action");
            if (this.f14579b.get() == true) goto L5;
            return;
        L5:
            this.f14580c.execute(new $$Lambda$a$a$_aiIC8qnymZVwatc4KpF9vX9SHA(this, r4));
        }

        private static final void a(C0291a r2, d.h.a.b r3) {
            d.h.a.b r4 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
            if (r2.f14579b.get() == false) goto L6;
            a.a(a.f14573a, r2.f14578a, r4);
            return;
        }

        public final void b() {
            if (this.f14579b.compareAndSet(true, false) == false) goto L6;
            this.f14580c.a();
            return;
        }
    }

    /* JADX INFO: compiled from: FlowMessageCallbackHub.kt */
    private static final class b implements Executor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Executor f14581a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ArrayDeque<Runnable> f14582b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Runnable f14583c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f14584d;

        public static /* synthetic */ void lambda$hdQEDHvdC4uARdWVHtCaXllUwOE(Runnable r0, b r1) {
            a(r0, r1);
        }

        public b(Executor r3) {
            Executor r4 = (Executor) ZeusTransformUtils.wrapperContextForParams(r3, Executor.class, "com.obric.aiagent.plugin");
            o.e(r4, "executor");
            this.f14581a = r4;
            this.f14582b = new ArrayDeque();
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable r4) {
            final Runnable r5 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.aiagent.plugin");
            o.e(r5, "command");
            ArrayDeque<Runnable> r0 = this.f14582b;
            monitor-enter(r0);
        L14:
            th = move-exception;
            throw th;
        L5:
            if (this.f14584d == false) goto L8;
            monitor-exit(r0);
            return;
        L8:
            this.f14582b.offer(new $$Lambda$a$b$hdQEDHvdC4uARdWVHtCaXllUwOE(r5, this));     // Catch: Throwable -> L14
            if (this.f14583c != null) goto L11;
            c();     // Catch: Throwable -> L14
        L11:
            x r3 = x.f38692a;     // Catch: Throwable -> L14
            monitor-exit(r0);
        }

        private static final void a(Runnable r2, b r3) {
            ((Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.aiagent.plugin")).run();     // Catch: Throwable -> L6
            r3.b();
            return;
        L6:
            th = move-exception;
            r3.b();
            throw th;
        }

        public final void a() {
            ArrayDeque<Runnable> r0 = this.f14582b;
            monitor-enter(r0);
            this.f14584d = true;     // Catch: Throwable -> L8
            this.f14582b.clear();     // Catch: Throwable -> L8
            x r2 = x.f38692a;     // Catch: Throwable -> L8
            monitor-exit(r0);
            return;
        L8:
            th = move-exception;
            throw th;
        }

        private final void b() {
            ArrayDeque<Runnable> r0 = this.f14582b;
            monitor-enter(r0);
            c();     // Catch: Throwable -> L7
            x r1 = x.f38692a;     // Catch: Throwable -> L7
            monitor-exit(r0);
            return;
        L7:
            th = move-exception;
            throw th;
        }

        private final void c() {
            if (this.f14584d == false) goto L6;
            this.f14582b.clear();
            this.f14583c = null;
            return;
        L6:
            Runnable r0 = (Runnable) ZeusTransformUtils.preCheckCast(this.f14582b.poll(), Runnable.class, "com.obric.aiagent.plugin");
            this.f14583c = r0;
            if (r0 == null) goto L10;
            this.f14581a.execute(r0);
            return;
        }
    }

    /* JADX INFO: renamed from: lambda$ba3RK_0wUr2-N60475KDXmGc6zU, reason: not valid java name */
    public static /* synthetic */ Thread m79lambda$ba3RK_0wUr2N60475KDXmGc6zU(Runnable r0) {
        return a(r0);
    }

    private a() {
    }

    public static final /* synthetic */ void a(a r2, d r3, d.h.a.b r4) {
        r2.a((d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin"), (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.b.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ void a(a r2, d.h.a.b r3) {
        r2.a((d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin"));
    }

    static {
        f14573a = new a();
        f14574b = new CopyOnWriteArrayList();
        f14575c = new CopyOnWriteArrayList();
        f14576d = new AtomicInteger(0);
        f14577e = Executors.newCachedThreadPool($$Lambda$a$ba3RK_0wUr2N60475KDXmGc6zU.INSTANCE);
        f = new FlowMessageCallbackHub$ipcCallback$1();
    }

    private static final Thread a(Runnable r3) {
        return new Thread((Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin"), "flow_message_dispatch_" + f14576d.incrementAndGet());
    }

    private final void a(d.h.a.b<? super d, x> r4) {
        d.h.a.b<? super d, x> r3 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.b.class, "com.obric.aiagent.plugin");
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(f14575c, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        d r1 = (d) ZeusTransformUtils.preCheckCast(r5.next(), d.class, "com.obric.aiagent.plugin");
        a r2 = f14573a;
        o.a(r1);
        r2.a(r1, r3);
        goto L4
    L6:
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(f14574b, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L8:
        if (r6.hasNext() == false) goto L10;
        ((C0291a) ZeusTransformUtils.preCheckCast(r6.next(), C0291a.class, "com.obric.aiagent.plugin")).a(r3);
        goto L8
    }

    public final synchronized void a(d r7) {
        monitor-enter(this);
        d r8 = (d) ZeusTransformUtils.wrapperContextForParams(r7, d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L22
        o.e(r8, "observer");     // Catch: Throwable -> L22
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(f14574b, Iterable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L22
        boolean r2 = false;
        if (ZeusTransformUtils.instanceOf(r0, Collection.class) == true) goto L6;
    L8:
        Iterator r1 = r0.iterator();     // Catch: Throwable -> L22
    L10:
        if (r1.hasNext() == false) goto L17;
        if (((C0291a) ZeusTransformUtils.preCheckCast(r1.next(), C0291a.class, "com.obric.aiagent.plugin")).a() != r8) goto L14;
        boolean r3 = true;
    L15:
        if (r3 == false) goto L10;
    L18:
        if (r2 == false) goto L20;
        CopyOnWriteArrayList<C0291a> r4 = f14574b;     // Catch: Throwable -> L22
        ExecutorService r5 = f14577e;     // Catch: Throwable -> L22
        o.c(r5, "businessExecutor");     // Catch: Throwable -> L22
        r4.add(new C0291a(r8, (Executor) ZeusTransformUtils.preCheckCast(r5, Executor.class, "com.obric.aiagent.plugin")));     // Catch: Throwable -> L22
    L20:
        monitor-exit(this);
        return;
    L14:
        r3 = false;
    L17:
        r2 = true;
        goto L18
    L6:
        if (((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L8;
    L22:
        th = move-exception;
        throw th;
    }

    public final synchronized void b(d r5) {
        monitor-enter(this);
        d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L18
        o.e(r6, "observer");     // Catch: Throwable -> L18
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(f14574b, Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Throwable -> L18
    L5:
        if (r0.hasNext() == false) goto L12;
        Object r1 = r0.next();     // Catch: Throwable -> L18
        if (((C0291a) ZeusTransformUtils.preCheckCast(r1, C0291a.class, "com.obric.aiagent.plugin")).a() != r6) goto L9;
        boolean r2 = true;
    L10:
        if (r2 == false) goto L5;
    L13:
        C0291a r7 = (C0291a) ZeusTransformUtils.preCheckCast(r1, C0291a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L18
        if (r7 == null) goto L16;
        r7.b();     // Catch: Throwable -> L18
        f14574b.remove(r7);     // Catch: Throwable -> L18
    L16:
        monitor-exit(this);
        return;
    L9:
        r2 = false;
        goto L10
    L12:
        r1 = null;
    L18:
        th = move-exception;
        throw th;
    }

    public final void c(d r2) {
        d r1 = (d) ZeusTransformUtils.wrapperContextForParams(r2, d.class, "com.obric.aiagent.plugin");
        o.e(r1, "observer");
        CopyOnWriteArrayList<d> r3 = f14575c;
        if (r3.contains(r1) == true) goto L6;
        r3.add(r1);
        return;
    }

    private final void a(d r3, d.h.a.b<? super d, x> r4) {
        d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
        d.h.a.b r6 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.b.class, "com.obric.aiagent.plugin");
        n.a r0 = n.f38560a;     // Catch: Throwable -> L5
        a r2 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
        r6.invoke(r5);     // Catch: Throwable -> L5
        Object r7 = n.f(x.f38692a);     // Catch: Throwable -> L5
    L7:
        Throwable r8 = n.c(r7);
        if (r8 == null) goto L13;
        ILogDepend.Companion.e(TAG, "dispatch message to observer failed", r8);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        n.a r9 = n.f38560a;
        r7 = n.f(d.o.a(th));
        goto L7
    }

    public final void a(IFlowMessageIDL r3, int r4) {
        IFlowMessageIDL r5 = (IFlowMessageIDL) ZeusTransformUtils.wrapperContextForParams(r3, IFlowMessageIDL.class, "com.obric.aiagent.plugin");
        o.e(r5, "ipc");
        n.a r0 = n.f38560a;     // Catch: Throwable -> L5
        a r2 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
        ai.a(r5, (IFlowMessageCallbackIDL) ZeusTransformUtils.preCheckCast(f, IFlowMessageCallbackIDL.class, "com.obric.aiagent.plugin"), r4);     // Catch: Throwable -> L5
        Object r6 = n.f(x.f38692a);     // Catch: Throwable -> L5
    L7:
        Throwable r7 = n.c(r6);
        if (r7 == null) goto L13;
        ILogDepend.Companion.e(TAG, "attach flow message callback failed", r7);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        n.a r8 = n.f38560a;
        r6 = n.f(d.o.a(th));
        goto L7
    }

    public final void a(IFlowMessageIDL r3) {
        IFlowMessageIDL r4 = (IFlowMessageIDL) ZeusTransformUtils.wrapperContextForParams(r3, IFlowMessageIDL.class, "com.obric.aiagent.plugin");
        o.e(r4, "ipc");
        n.a r0 = n.f38560a;     // Catch: Throwable -> L5
        a r2 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
        r4.unregisterCallback((IFlowMessageCallbackIDL) ZeusTransformUtils.preCheckCast(f, IFlowMessageCallbackIDL.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L5
        Object r5 = n.f(x.f38692a);     // Catch: Throwable -> L5
    L7:
        Throwable r6 = n.c(r5);
        if (r6 == null) goto L13;
        ILogDepend.Companion.e(TAG, "detach flow message callback failed", r6);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        n.a r7 = n.f38560a;
        r5 = n.f(d.o.a(th));
        goto L7
    }
}
