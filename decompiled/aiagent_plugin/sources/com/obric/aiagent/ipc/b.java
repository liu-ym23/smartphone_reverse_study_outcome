package com.obric.aiagent.ipc;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Process;
import android.util.Log;
import com.obric.aiagent.assistant.idl.IFlowSettingsIDL;
import com.obric.aiagent.assistant.idl.at;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.product.ObricProductSdk;
import com.obric.aiagent.product.feature.api.IFeatureServiceKt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.l;
import d.c.d;
import d.f;
import d.g;
import d.h.a.m;
import d.h.b.aa;
import d.n;
import d.o;
import d.x;
import java.util.Collection;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.ca;
import kotlinx.coroutines.cx;
import kotlinx.coroutines.i;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: FlowProcessControl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class b {
    private static final String TAG = "FlowProcessControl";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f18607a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile boolean f18608b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile boolean f18609c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Context f18610d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static IBinder f18611e;
    private static Messenger f;
    private static IBinder.DeathRecipient g;
    private static boolean h;
    private static final ArrayBlockingQueue<Message> i = null;
    private static final HandlerThread j = null;
    private static final f k = null;
    private static ca l;
    private static final FlowProcessControl$serviceConnection$1 m = null;

    /* JADX INFO: compiled from: FlowProcessControl.kt */
    @d.c.b.a.f(b = "FlowProcessControl.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.ipc.FlowProcessControl$handleEventQueue$1")
    static final class a extends l implements m<am, d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f18612a;

        a(d<? super a> r3) {
            super(2, (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin"));
        }

        public final Object a(am r3, d<? super x> r4) {
            return ((a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d<x> create(Object r1, d<?> r2) {
            return (d) ZeusTransformUtils.preCheckCast(new a((d) ZeusTransformUtils.wrapperContextForParams(r2, d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            d.c.a.b.a();
            if (this.f18612a != 0) goto L36;
            o.a(r5);
            b r4 = b.f18607a;
            monitor-enter(r4);
        L37:
            boolean r0 = true;
            if ((!((Collection) ZeusTransformUtils.preCheckCast(b.c(), Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L28;
            Message r6 = (Message) ZeusTransformUtils.preCheckCast(b.c().poll(500, TimeUnit.MILLISECONDS), Message.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L32
            a(b.TAG, "handleEventQueue, the binder is connected, so need send the cached event " + r6);     // Catch: Throwable -> L32
            n.a r1 = n.f38560a;     // Catch: Throwable -> L21
            Messenger r2 = b.b();     // Catch: Throwable -> L21
            x r3 = null;
            if (r2 == null) goto L19;
            if (r6 != null) goto L14;
            r0 = false;
        L14:
            if (r0 == true) goto L17;
            r2 = null;
        L17:
            if (r2 == null) goto L19;
            r2.send(r6);     // Catch: Throwable -> L21
            r3 = x.f38692a;     // Catch: Throwable -> L21
        L19:
            Object r7 = n.f(r3);     // Catch: Throwable -> L21
        L23:
            Throwable r8 = n.c(r7);     // Catch: Throwable -> L32
            if (r8 == null) goto L37;
            b(b.TAG, "handleMessengerEvent failed " + r8.getMessage());     // Catch: Throwable -> L32
            if (ZeusTransformUtils.instanceOf(r8, DeadObjectException.class) == false) goto L37;
            b.c().offer(r6);     // Catch: Throwable -> L32
            b.b(b.f18607a);     // Catch: Throwable -> L32
            goto L37
        L21:
            th = move-exception;
            n.a r9 = n.f38560a;     // Catch: Throwable -> L32
            r7 = n.f(o.a(th));     // Catch: Throwable -> L32
            goto L23
        L28:
            x r10 = x.f38692a;     // Catch: Throwable -> L32
            monitor-exit(r4);
            return x.f38692a;
        L32:
            th = move-exception;
            throw th;
        L36:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int a(String r1, String r2) {
            if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
            return 0;
        L5:
            return Log.i(r1, r2);
        }

        @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int b(String r0, String r1) {
            return Log.e(r0, r1);
        }
    }

    /* JADX INFO: renamed from: com.obric.aiagent.ipc.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: FlowProcessControl.kt */
    @d.c.b.a.f(b = "FlowProcessControl.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.ipc.FlowProcessControl$killSelf$1")
    static final class C0389b extends l implements m<am, d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f18613a;

        C0389b(d<? super C0389b> r3) {
            super(2, (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin"));
        }

        public final Object a(am r3, d<? super x> r4) {
            return ((C0389b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), C0389b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d<x> create(Object r1, d<?> r2) {
            return (d) ZeusTransformUtils.preCheckCast(new C0389b((d) ZeusTransformUtils.wrapperContextForParams(r2, d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r2) {
            d.c.a.b.a();
            if (this.f18613a != 0) goto L7;
            o.a(r2);
            ILogDepend.Companion.i(b.TAG, "killSelf: pid=" + Process.myPid());
            Process.killProcess(Process.myPid());
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: FlowProcessControl.kt */
    @d.c.b.a.f(b = "FlowProcessControl.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.ipc.FlowProcessControl$sendServerMessenger$3")
    static final class c extends l implements m<am, d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f18614a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f18615b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private /* synthetic */ Object f18616c;

        c(int r3, d<? super c> r4) {
            d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            this.f18615b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d<? super x> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d<x> create(Object r3, d<?> r4) {
            d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            c r0 = new c(this.f18615b, r5);
            r0.f18616c = r3;
            return (d) ZeusTransformUtils.preCheckCast(r0, d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r4) {
            d.c.a.b.a();
            if (this.f18614a != 0) goto L28;
            o.a(r4);
            am r5 = (am) ZeusTransformUtils.preCheckCast(this.f18616c, am.class, "com.obric.aiagent.plugin");
            int r3 = this.f18615b;
            monitor-enter(r5);
            n.a r0 = n.f38560a;     // Catch: Throwable -> L12
            Message r1 = Message.obtain();     // Catch: Throwable -> L12
            r1.what = r3;     // Catch: Throwable -> L12
            r1.replyTo = b.a(b.f18607a);     // Catch: Throwable -> L12
            Messenger r6 = b.b();     // Catch: Throwable -> L12
            if (r6 == null) goto L9;
            r6.send(r1);     // Catch: Throwable -> L12
            x r7 = x.f38692a;     // Catch: Throwable -> L12
        L10:
            Object r8 = n.f(r7);     // Catch: Throwable -> L12
        L15:
            if (n.a(r8) == false) goto L18;
            x r2 = (x) ZeusTransformUtils.preCheckCast(r8, x.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L24
            ILogDepend.Companion.i(b.TAG, "sendServerMessenger send success");     // Catch: Throwable -> L24
        L18:
            if (n.c(r8) == null) goto L20;
            ILogDepend.Companion.w(b.TAG, "sendServerMessenger send failed");     // Catch: Throwable -> L24
        L20:
            x r9 = x.f38692a;     // Catch: Throwable -> L24
            monitor-exit(r5);
            return x.f38692a;
        L9:
            r7 = null;
        L24:
            th = move-exception;
            throw th;
        L12:
            th = move-exception;
            n.a r10 = n.f38560a;     // Catch: Throwable -> L24
            r8 = n.f(o.a(th));     // Catch: Throwable -> L24
            goto L15
        L28:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public static /* synthetic */ Messenger lambda$EhqPquxeCXpieLdhC9z0w8snRqU() {
        return j();
    }

    public static /* synthetic */ boolean lambda$I_mo_zG_uU3RL294WAwRxyTS7ws(Message r0) {
        return a(r0);
    }

    /* JADX INFO: renamed from: lambda$XhvsN83o0-FalgfNm0fOcnVTwaQ, reason: not valid java name */
    public static /* synthetic */ void m198lambda$XhvsN83o0FalgfNm0fOcnVTwaQ() {
        k();
    }

    public static /* synthetic */ void lambda$cMsfTtq_aU6rslXJdT72IfvqxqQ(IFlowSettingsIDL r0) {
        a(r0);
    }

    private b() {
    }

    public static final /* synthetic */ Messenger a(b r0) {
        return r0.d();
    }

    public static final /* synthetic */ void a(IBinder r2) {
        f18611e = (IBinder) ZeusTransformUtils.wrapperContextForParams(r2, IBinder.class, "com.obric.aiagent.plugin");
    }

    public static final /* synthetic */ void a(Messenger r0) {
        f = r0;
    }

    public static final /* synthetic */ void a(b r2, IBinder r3) {
        r2.b((IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ void a(boolean r0) {
        f18608b = r0;
    }

    public static final /* synthetic */ Messenger b() {
        return f;
    }

    public static final /* synthetic */ void b(b r0) {
        r0.f();
    }

    public static final /* synthetic */ void b(boolean r0) {
        f18609c = r0;
    }

    public static final /* synthetic */ ArrayBlockingQueue c() {
        return i;
    }

    public static final /* synthetic */ void c(b r0) {
        r0.e();
    }

    public static final /* synthetic */ void d(b r0) {
        r0.h();
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [com.obric.aiagent.ipc.FlowProcessControl$serviceConnection$1] */
    static {
        f18607a = new b();
        h = true;
        i = new ArrayBlockingQueue(10);
        HandlerThread r0 = new HandlerThread("FlowProcessControlClient");
        j = r0;
        r0.start();
        k = g.a($$Lambda$b$EhqPquxeCXpieLdhC9z0w8snRqU.INSTANCE);
        m = new FlowProcessControl$serviceConnection$1();
    }

    private final Messenger d() {
        return (Messenger) ZeusTransformUtils.preCheckCast(k.b(), Messenger.class, "com.obric.aiagent.plugin");
    }

    private static final Messenger j() {
        return new Messenger(new Handler(j.getLooper(), $$Lambda$b$I_mo_zG_uU3RL294WAwRxyTS7ws.INSTANCE));
    }

    private static final boolean a(Message r3) {
        d.h.b.o.e(r3, "msg");
        ILogDepend.Companion.i(TAG, "handleClientMessage: msg.what = " + r3.what);
        return true;
    }

    public final void a() {
        a(1000);
    }

    public final void a(int r12) {
        ILogDepend.Companion r0 = ILogDepend.Companion;
        StringBuilder r2 = new StringBuilder().append("sendServerMessenger : ").append(f).append("  binder : ");
        Messenger r3 = f;
        if (r3 == null) goto L5;
        IBinder r4 = r3.getBinder();
    L6:
        r0.i(TAG, r2.append(r4).toString());
        Messenger r1 = f;
        if (r1 == null) goto L17;
        if (r1 == null) goto L10;
        IBinder r5 = r1.getBinder();
    L11:
        if (r5 == null) goto L17;
        Messenger r6 = f;
        d.h.b.o.a(r6);
        if (r6.getBinder().isBinderAlive() == false) goto L17;
        i.a(an.a(bd.c().plus((d.c.g) ZeusTransformUtils.preCheckCast(cx.a(null, 1, null), d.c.g.class, "com.obric.aiagent.plugin"))), null, null, (m) ZeusTransformUtils.preCheckCast(new c(r12, null), m.class, "com.obric.aiagent.plugin"), 3, null);
        return;
    L10:
        r5 = null;
    L17:
        ILogDepend.Companion.i(TAG, "sendServerMessenger:  messenger is null or binder is not alive," + f + ',');
        ArrayBlockingQueue<Message> r7 = i;
        Message r8 = Message.obtain();
        r8.what = r12;
        b r13 = f18607a;
        r8.replyTo = r13.d();
        r7.offer(r8);
        monitor-enter(this);
    L30:
        th = move-exception;
        throw th;
    L20:
        if (f18608b == false) goto L22;
    L27:
        ILogDepend.Companion.i(TAG, "already bound or binding, skip");     // Catch: Throwable -> L30
        monitor-exit(this);
        return;
    L22:
        if (f18609c == true) goto L27;
        r13.f();     // Catch: Throwable -> L30
        x r14 = x.f38692a;     // Catch: Throwable -> L30
        monitor-exit(this);
        return;
    L5:
        r4 = null;
        goto L6
    }

    private final void e() {
        ca r10 = l;
        if (r10 == null) goto L5;
        ca.a.a(r10, null, 1, null);
    L5:
        l = i.a(an.a(bd.c().plus((d.c.g) ZeusTransformUtils.preCheckCast(cx.a(null, 1, null), d.c.g.class, "com.obric.aiagent.plugin"))), null, null, (m) ZeusTransformUtils.preCheckCast(new a(null), m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    public final void a(Context r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r9, "context");
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (f18608b == false) goto L7;
    L12:
        ILogDepend.Companion.i(TAG, "already bound or binding, skip");     // Catch: Throwable -> L15
        monitor-exit(this);
        return;
    L7:
        if (f18609c == true) goto L12;
        b r0 = f18607a;     // Catch: Throwable -> L15
        f18610d = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r9.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L15
        at.a(aa.b(IFlowSettingsIDL.class), false, false, $$Lambda$b$cMsfTtq_aU6rslXJdT72IfvqxqQ.INSTANCE, 3, null);     // Catch: Throwable -> L15
        r0.f();     // Catch: Throwable -> L15
        x r10 = x.f38692a;     // Catch: Throwable -> L15
        monitor-exit(this);
    }

    private static final void a(IFlowSettingsIDL r2) {
        d.h.b.o.e((IFlowSettingsIDL) ZeusTransformUtils.wrapperContextForParams(r2, IFlowSettingsIDL.class, "com.obric.aiagent.plugin"), "it");
        h = ObricProductSdk.INSTANCE.featureService().isFeatureEnable(IFeatureServiceKt.FEATURE_KEY_EXIT_AIAGENT_WHEN_NOVA_DIED);
        ILogDepend.Companion.i(TAG, "bind, exitWhenNovaDied: " + h);
    }

    private final void f() {
        if (f18608b == false) goto L5;
        return;
    L5:
        if (f18609c == true) goto L30;
        Context r1 = f18610d;
        if (r1 != null) goto L11;
        b r6 = (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.aiagent.plugin");
        ILogDepend.Companion.e(TAG, "context is null, skip bind");
        return;
    L11:
        Intent r4 = new Intent("com.obric.assistant.action.START_NOVA_SERVICE");
        r4.setPackage("com.larus.nova");
        n.a r5 = n.f38560a;     // Catch: Throwable -> L14
        b r7 = (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
        Object r8 = n.f(Boolean.valueOf(ZeusTransformUtils.bindService(r1, r4, (ServiceConnection) ZeusTransformUtils.preCheckCast(m, ServiceConnection.class, "com.obric.aiagent.plugin"), 65, "com.obric.aiagent.plugin")));     // Catch: Throwable -> L14
    L16:
        Throwable r0 = n.c(r8);
        if (r0 == null) goto L20;
        ILogDepend.Companion.e(TAG, "bindService error: " + r0.getMessage(), r0);
    L20:
        if (n.b(r8) == false) goto L22;
        r8 = false;
    L22:
        boolean r9 = ((Boolean) ZeusTransformUtils.preCheckCast(r8, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
        if (r9 == false) goto L25;
        f18609c = true;
    L25:
        ILogDepend.Companion.i(TAG, "executeBind result: " + r9);
        return;
    L14:
        th = move-exception;
        n.a r2 = n.f38560a;
        r8 = n.f(o.a(th));
        goto L16
    }

    private final void b(IBinder r5) {
        IBinder r6 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r5, IBinder.class, "com.obric.aiagent.plugin");
        g();
        $$Lambda$b$XhvsN83o0FalgfNm0fOcnVTwaQ r1 = $$Lambda$b$XhvsN83o0FalgfNm0fOcnVTwaQ.INSTANCE;
        n.a r3 = n.f38560a;     // Catch: Throwable -> L5
        b r4 = (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
        r6.linkToDeath(r1, 0);     // Catch: Throwable -> L5
        g = r1;     // Catch: Throwable -> L5
        ILogDepend.Companion.i(TAG, "linkToDeath success");     // Catch: Throwable -> L5
        Object r7 = n.f(x.f38692a);     // Catch: Throwable -> L5
    L7:
        Throwable r8 = n.c(r7);
        if (r8 == null) goto L15;
        ILogDepend.Companion.e(TAG, "linkToDeath failed, killing self", r8);
        b r9 = f18607a;
        r9.h();
        if (h == false) goto L16;
        r9.i();
        return;
    L16:
        return;
    L15:
        return;
    L5:
        th = move-exception;
        n.a r10 = n.f38560a;
        r7 = n.f(o.a(th));
        goto L7
    }

    private static final void k() {
        ILogDepend.Companion.i(TAG, "binderDied: host process died, killing self");
        b r0 = f18607a;
        monitor-enter(r0);
        r0.h();     // Catch: Throwable -> L10
        x r1 = x.f38692a;     // Catch: Throwable -> L10
        monitor-exit(r0);
        if (h == false) goto L15;
        r0.i();
        return;
    L15:
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private final void g() {
        IBinder.DeathRecipient r2 = g;
        if (r2 == null) goto L15;
        IBinder r0 = f18611e;
        if (r0 != null) goto L13;
    L11:
        g = null;
        return;
    L13:
        n.a r1 = n.f38560a;     // Catch: Throwable -> L8
        Object r3 = n.f(Boolean.valueOf(r0.unlinkToDeath(r2, 0)));     // Catch: Throwable -> L8
    L10:
        n.g(r3);
    L8:
        th = move-exception;
        n.a r4 = n.f38560a;
        r3 = n.f(o.a(th));
        goto L10
    }

    private final void h() {
        g();
        f18611e = null;
        f18608b = false;
        f18609c = false;
        Context r4 = f18610d;
        if (r4 == null) goto L15;
        n.a r1 = n.f38560a;     // Catch: Throwable -> L6
        ZeusTransformUtils.unbindService(r4, (ServiceConnection) ZeusTransformUtils.preCheckCast(m, ServiceConnection.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");     // Catch: Throwable -> L6
        Object r5 = n.f(x.f38692a);     // Catch: Throwable -> L6
    L8:
        Throwable r0 = n.c(r5);
        if (r0 == null) goto L11;
        ILogDepend.Companion.e(TAG, "unbindService error", r0);
    L11:
        n.g(r5);
        return;
    L6:
        th = move-exception;
        n.a r2 = n.f38560a;
        r5 = n.f(o.a(th));
        goto L8
    }

    private final void i() {
        i.a(an.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin")), null, null, (m) ZeusTransformUtils.preCheckCast(new C0389b(null), m.class, "com.obric.aiagent.plugin"), 3, null);
    }
}
