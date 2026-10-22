package com.obric.aiagent.ipc.control;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.f;
import d.c.b.a.l;
import d.c.d;
import d.h.a.m;
import d.h.b.h;
import d.n;
import d.o;
import d.s;
import d.x;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ax;
import kotlinx.coroutines.ca;
import kotlinx.coroutines.i;

/* JADX INFO: compiled from: BinderControl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a extends com.obric.aiagent.ipc.control.c<Intent, IBinder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0390a f18617a = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Intent f18618c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private am f18619d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ca f18620e;
    private volatile IBinder f;
    private volatile com.obric.aiagent.ipc.control.c.a<IBinder> g;
    private boolean h;
    private boolean i;
    private volatile boolean j;
    private volatile IBinder.DeathRecipient k;
    private long l;
    private long m;
    private com.obric.aiagent.ipc.control.b n;
    private final BinderControl$serviceConnection$1 o;

    /* JADX INFO: renamed from: com.obric.aiagent.ipc.control.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: BinderControl.kt */
    public static final class C0390a {
        public /* synthetic */ C0390a(h r1) {
            this();
        }

        private C0390a() {
        }
    }

    /* JADX INFO: compiled from: BinderControl.kt */
    @f(b = "BinderControl.kt", c = {377}, d = "invokeSuspend", e = "com.obric.aiagent.ipc.control.BinderControl$scheduleRebind$1")
    static final class b extends l implements m<am, d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f18621a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f18622b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ a f18623c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f18624d;

        b(long r3, a r5, int r6, d<? super b> r7) {
            d r8 = (d) ZeusTransformUtils.wrapperContextForParams(r7, d.class, "com.obric.aiagent.plugin");
            this.f18622b = r3;
            this.f18623c = r5;
            this.f18624d = r6;
            super(2, r8);
        }

        public final Object a(am r3, d<? super x> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d<x> create(Object r8, d<?> r9) {
            d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r9, d.class, "com.obric.aiagent.plugin");
            return (d) ZeusTransformUtils.preCheckCast(new b(this.f18622b, this.f18623c, this.f18624d, r6), d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f18621a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r7);
        L11:
            a r8 = this.f18623c;
            long r2 = this.f18622b;
            int r6 = this.f18624d;
            monitor-enter(r8);
        L22:
            th = move-exception;
            throw th;
        L14:
            if (a.a(r8) == null) goto L18;
            com.obric.aiagent.ipc.utils.h.f18670a.a("IPCControl", "scheduleRebind: instance is not null, abort");     // Catch: Throwable -> L22
            x r9 = x.f38692a;     // Catch: Throwable -> L22
            monitor-exit(r8);
            return r9;
        L18:
            com.obric.aiagent.ipc.utils.h.f18670a.a("IPCControl", "pendingRebind in " + r2 + "ms (lastDelay=" + r2 + "ms)");     // Catch: Throwable -> L22
            a.a(r8, r6);     // Catch: Throwable -> L22
            a.b(r8);     // Catch: Throwable -> L22
            x r10 = x.f38692a;     // Catch: Throwable -> L22
            monitor-exit(r8);
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r7);
            long r3 = this.f18622b;
            d r11 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");
            this.f18621a = 1;
            if (ax.a(r3, r11) != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: BinderControl.kt */
    @f(b = "BinderControl.kt", c = {404}, d = "invokeSuspend", e = "com.obric.aiagent.ipc.control.BinderControl$waitForService$1")
    static final class c extends l implements m<am, d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f18625a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f18626b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ a f18627c;

        c(long r3, a r5, d<? super c> r6) {
            d r7 = (d) ZeusTransformUtils.wrapperContextForParams(r6, d.class, "com.obric.aiagent.plugin");
            this.f18626b = r3;
            this.f18627c = r5;
            super(2, r7);
        }

        public final Object a(am r3, d<? super x> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d<x> create(Object r4, d<?> r5) {
            d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
            return (d) ZeusTransformUtils.preCheckCast(new c(this.f18626b, this.f18627c, r6), d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r10) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f18625a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r10);
        L11:
            a r9 = this.f18627c;
            monitor-enter(r9);
        L21:
            th = move-exception;
            throw th;
        L14:
            if (a.a(r9) != null) goto L16;
            com.obric.aiagent.ipc.utils.h.a(com.obric.aiagent.ipc.utils.h.f18670a, "IPCControl", "waitForService service is null", null, 4, null);     // Catch: Throwable -> L21
            a.b(r9, 1);     // Catch: Throwable -> L21
        L17:
            x r11 = x.f38692a;     // Catch: Throwable -> L21
            monitor-exit(r9);
            return x.f38692a;
        L16:
            com.obric.aiagent.ipc.utils.h.f18670a.a("IPCControl", "waitForService service not null");     // Catch: Throwable -> L21
            goto L17
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r10);
            long r3 = this.f18626b;
            d r12 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");
            this.f18625a = 1;
            if (ax.a(r3, r12) != r0) goto L11;
            return r0;
        }
    }

    static {
        f18617a = new C0390a(null);
    }

    public static final /* synthetic */ long a(a r0, int r1) {
        return r0.a(r1);
    }

    public static final /* synthetic */ IBinder a(a r0) {
        return r0.f;
    }

    public static final /* synthetic */ void a(a r2, IBinder.DeathRecipient r3) {
        r2.k = (IBinder.DeathRecipient) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.DeathRecipient.class, "com.obric.aiagent.plugin");
    }

    public static final /* synthetic */ void a(a r2, IBinder r3) {
        r2.a((IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ void a(a r2, ca r3) {
        r2.f18620e = (ca) ZeusTransformUtils.wrapperContextForParams(r3, ca.class, "com.obric.aiagent.plugin");
    }

    public static final /* synthetic */ void a(a r0, boolean r1) {
        r0.i = r1;
    }

    public static final /* synthetic */ com.obric.aiagent.ipc.control.c.C0391c b(a r0) {
        return r0.c();
    }

    public static final /* synthetic */ void b(a r0, int r1) {
        r0.b(r1);
    }

    public static final /* synthetic */ void b(a r2, IBinder r3) {
        r2.f = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
    }

    public static final /* synthetic */ void b(a r0, boolean r1) {
        r0.h = r1;
    }

    public static final /* synthetic */ String c(a r0) {
        return r0.d();
    }

    public static final /* synthetic */ com.obric.aiagent.ipc.control.c.a d(a r0) {
        return r0.g;
    }

    public static final /* synthetic */ void e(a r0) {
        r0.a();
    }

    public static final /* synthetic */ boolean f(a r0) {
        return r0.j;
    }

    public static final /* synthetic */ ca g(a r0) {
        return r0.f18620e;
    }

    public static final /* synthetic */ void h(a r0) {
        r0.b();
    }

    private final long a(int r8) {
        if (r8 != 2) goto L5;
        long r0 = Math.min(this.n.b(), this.m * ((long) 3));
        this.m = r0;
    L6:
        com.obric.aiagent.ipc.utils.h.f18670a.a("IPCControl", "increaseRebindDelay: reason = " + r8 + ", nextDelay = " + r0);
        return r0;
    L5:
        r0 = Math.min(this.n.c(), this.l * ((long) 3));
        this.l = r0;
        goto L6
    }

    private final void a() {
        if (this.j == true) goto L6;
        com.obric.aiagent.ipc.utils.h.f18670a.a("IPCControl", "safeUnbind: ignore, not bound");
        return;
    L6:
        com.obric.aiagent.ipc.utils.h.f18670a.a("IPCControl", "safeUnbind: " + d());
        this.j = false;
        b();
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        n.a r3 = n.f38560a;     // Catch: Throwable -> L9
        ZeusTransformUtils.unbindService(r0, (ServiceConnection) ZeusTransformUtils.preCheckCast(this.o, ServiceConnection.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");     // Catch: Throwable -> L9
        Object r4 = n.f(x.f38692a);     // Catch: Throwable -> L9
    L11:
        Throwable r5 = n.c(r4);
        if (r5 == null) goto L17;
        com.obric.aiagent.ipc.utils.h.f18670a.a("IPCControl", "safeUnbind error", r5);
        return;
    L17:
        return;
    L9:
        th = move-exception;
        n.a r1 = n.f38560a;
        r4 = n.f(o.a(th));
        goto L11
    }

    private final void b() {
        IBinder.DeathRecipient r0 = this.k;
        if (r0 == null) goto L15;
        IBinder r1 = this.f;
        if (r1 != null) goto L13;
    L11:
        this.k = null;
        return;
    L13:
        n.a r2 = n.f38560a;     // Catch: Throwable -> L8
        Object r3 = n.f(Boolean.valueOf(r1.unlinkToDeath(r0, 0)));     // Catch: Throwable -> L8
    L10:
        n.g(r3);
    L8:
        th = move-exception;
        n.a r4 = n.f38560a;
        r3 = n.f(o.a(th));
        goto L10
    }

    private final void a(IBinder r5) {
        IBinder r6 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r5, IBinder.class, "com.obric.aiagent.plugin");
        if (this.j == true) goto L6;
        com.obric.aiagent.ipc.utils.h.f18670a.a("IPCControl", "onBinderDied: ignore, not bound");
        return;
    L6:
        com.obric.aiagent.ipc.utils.h.f18670a.a("IPCControl", "onBinderDied: " + d() + ", this=" + this);
        b();
        this.f = null;
        a();
        com.obric.aiagent.ipc.control.c.a<IBinder> r7 = this.g;
        if (r7 == null) goto L10;
        r7.a();
    L10:
        if (this.g != null) goto L12;
    L14:
        com.obric.aiagent.ipc.utils.h.f18670a.a("IPCControl", "onBinderDied: callback replaced, not rebind, this=" + this + ", callback=" + this.g + ",currentCallback=" + r7);
        return;
    L12:
        if (this.g != r7) goto L14;
        b(2);
    }

    private final com.obric.aiagent.ipc.control.c.C0391c c() {
        a();
        com.obric.aiagent.ipc.utils.h.f18670a.a("IPCControl", "executeBind started");
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        n.a r3 = n.f38560a;     // Catch: Throwable -> L5
        Object r1 = n.f(Boolean.valueOf(ZeusTransformUtils.bindService(r0, this.f18618c, (ServiceConnection) ZeusTransformUtils.preCheckCast(this.o, ServiceConnection.class, "com.obric.aiagent.plugin"), 65, "com.obric.aiagent.plugin")));     // Catch: Throwable -> L5
    L7:
        Throwable r4 = n.c(r1);
        if (r4 == null) goto L10;
        com.obric.aiagent.ipc.utils.h.f18670a.a("IPCControl", "executeBind error: " + r4.getMessage(), r4);
    L10:
        Object r5 = false;
        if (n.b(r1) == true) goto L14;
        r5 = r1;
    L14:
        d.m r2 = s.a(r5, n.c(r1));
        boolean r6 = ((Boolean) ZeusTransformUtils.preCheckCast(r2.c(), Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
        Throwable r7 = (Throwable) ZeusTransformUtils.preCheckCast(r2.d(), Throwable.class, "com.obric.aiagent.plugin");
        if (r6 == false) goto L18;
        this.j = true;
        com.obric.aiagent.ipc.utils.h.f18670a.a("IPCControl", "bindService success");
        a(this.n.a());
        return new com.obric.aiagent.ipc.control.c.C0391c(true, null, 2, null);
    L18:
        this.j = false;
        if (this.h == true) goto L29;
        com.obric.aiagent.ipc.utils.h.f18670a.a("IPCControl", "bindService failed");
        if (ZeusTransformUtils.instanceOf(r7, SecurityException.class) == false) goto L24;
        com.obric.aiagent.ipc.utils.h.f18670a.a("IPCControl", "createBinder exception", r7);
        this.i = false;
        return new com.obric.aiagent.ipc.control.c.C0391c(false, ((SecurityException) ZeusTransformUtils.preCheckCast(r7, SecurityException.class, "com.obric.aiagent.plugin")).getMessage());
    L24:
        this.i = false;
        Intent r8 = com.obric.aiagent.ipc.control.c.f18632b.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), this.f18618c);
        if (r8 == null) goto L27;
        this.f18618c.setAction(r8.getAction());
        this.f18618c.setPackage(r8.getPackage());
        this.f18618c.setComponent(r8.getComponent());
        goto L29
    L27:
        return new com.obric.aiagent.ipc.control.c.C0391c(false, "No Service for " + d());
    L29:
        b(3);
        return new com.obric.aiagent.ipc.control.c.C0391c(true, null, 2, null);
    L5:
        th = move-exception;
        n.a r9 = n.f38560a;
        r1 = n.f(o.a(th));
        goto L7
    }

    private final void b(int r12) {
        if (r12 != 2) goto L5;
        long r0 = this.m;
    L6:
        long r3 = r0;
        com.obric.aiagent.ipc.utils.h.f18670a.a("IPCControl", "scheduleRebind: reason = " + r12 + ", delay = " + r3);
        ca r1 = this.f18620e;
        if (r1 == null) goto L9;
        ca.a.a(r1, null, 1, null);
    L9:
        this.f18620e = i.a(this.f18619d, null, null, (m) ZeusTransformUtils.preCheckCast(new b(r3, this, r12, null), m.class, "com.obric.aiagent.plugin"), 3, null);
        return;
    L5:
        r0 = this.l;
        goto L6
    }

    private final void a(long r10) {
        ca r0 = this.f18620e;
        if (r0 == null) goto L5;
        ca.a.a(r0, null, 1, null);
    L5:
        this.f18620e = i.a(this.f18619d, null, null, (m) ZeusTransformUtils.preCheckCast(new c(r10, this, null), m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    private final String d() {
        return this.f18618c.getAction();
    }
}
