package com.obric.capabilitykit;

import android.app.Application;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.IBinder;
import com.obric.capabilitykit.apphost.AppHost;
import com.obric.capabilitykit.common.ICapabilityManager;
import com.obric.capabilitykit.logger.Logger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.ae;
import d.h.b.z;
import d.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.br;
import kotlinx.coroutines.ca;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f32017a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f32018b = "AgentServiceConnection";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f32019c = "com.obric.aiagent.executionengine.CAPABILITY_REGISTER_SERVICE";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static com.obric.capabilitykit.a f32020d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Object f32021e = null;
    private static final am f = null;
    private static final LinkedHashMap<String, Set<d.m<String, ca>>> g = null;
    private static a h;

    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f32022a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f32023b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f32024c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ a[] f32025d = null;

        static {
            f32022a = new a("NotStart", 0);
            f32023b = new a("Started", 1);
            f32024c = new a("Connected", 2);
            f32025d = a();
        }

        private a(String r1, int r2) {
            super(r1, r2);
        }

        private static final /* synthetic */ a[] a() {
            return new a[]{f32022a, f32023b, f32024c};
        }

        public static a valueOf(String r2) {
            return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
        }

        public static a[] values() {
            return (a[]) ZeusTransformUtils.preCheckCast(f32025d.clone(), a[].class, "com.obric.aiagent.plugin");
        }
    }

    public static final class b extends LinkedHashMap<String, Set<d.m<? extends String, ? extends ca>>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f32026a;

        public b() {
            this.f32026a = 10;
        }

        public Set<Map.Entry<String, Set<d.m<String, ca>>>> a() {
            return super.entrySet();
        }

        public Set<d.m<String, ca>> a(String r2) {
            return (Set) ZeusTransformUtils.preCheckCast(super.remove(r2), Set.class, "com.obric.aiagent.plugin");
        }

        public boolean a(String r3, Set<d.m<String, ca>> r4) {
            return super.remove(r3, (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.aiagent.plugin"));
        }

        public boolean a(Set<d.m<String, ca>> r3) {
            return super.containsValue((Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.aiagent.plugin"));
        }

        public Set<String> b() {
            return super.keySet();
        }

        public Set<d.m<String, ca>> b(String r3, Set<d.m<String, ca>> r4) {
            return (Set) ZeusTransformUtils.preCheckCast(super.getOrDefault(r3, (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.aiagent.plugin")), Set.class, "com.obric.aiagent.plugin");
        }

        public boolean b(String r1) {
            return super.containsKey(r1);
        }

        public Collection<Set<d.m<String, ca>>> c() {
            return super.values();
        }

        public Set<d.m<String, ca>> c(String r2) {
            return (Set) ZeusTransformUtils.preCheckCast(super.get(r2), Set.class, "com.obric.aiagent.plugin");
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final boolean containsKey(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, String.class) == true) goto L7;
            return false;
        L7:
            return b((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"));
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final boolean containsValue(Object r3) {
            if (ae.h(r3) == true) goto L7;
            return false;
        L7:
            return a((Set) ZeusTransformUtils.preCheckCast(r3, Set.class, "com.obric.aiagent.plugin"));
        }

        public int d() {
            return super.size();
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final Set<Map.Entry<String, Set<d.m<String, ca>>>> entrySet() {
            return a();
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* synthetic */ Object get(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, String.class) == true) goto L7;
            return null;
        L7:
            return c((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"));
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.Map
        public final /* synthetic */ Object getOrDefault(Object r3, Object r4) {
            if (ZeusTransformUtils.instanceOf(r3, String.class) == true) goto L6;
            return r4;
        L6:
            return b((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), (Set) ZeusTransformUtils.preCheckCast(r4, Set.class, "com.obric.aiagent.plugin"));
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final Set<String> keySet() {
            return b();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* synthetic */ Object remove(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, String.class) == true) goto L7;
            return null;
        L7:
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"));
        }

        @Override // java.util.HashMap, java.util.Map
        public final boolean remove(Object r3, Object r4) {
            if (ZeusTransformUtils.instanceOf(r3, String.class) == true) goto L6;
            return false;
        L6:
            if (ae.h(r4) == true) goto L9;
            return false;
        L9:
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), (Set) ZeusTransformUtils.preCheckCast(r4, Set.class, "com.obric.aiagent.plugin"));
        }

        @Override // java.util.LinkedHashMap
        public boolean removeEldestEntry(Map.Entry<String, Set<d.m<? extends String, ? extends ca>>> r3) {
            d.h.b.o.e((Map.Entry) ZeusTransformUtils.wrapperContextForParams(r3, Map.Entry.class, "com.obric.aiagent.plugin"), "eldest");
            if (size() <= this.f32026a) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final int size() {
            return d();
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final Collection<Set<d.m<String, ca>>> values() {
            return c();
        }
    }

    /* JADX INFO: renamed from: com.obric.capabilitykit.c$c, reason: collision with other inner class name */
    @d.c.b.a.f(b = "AgentServiceConnection.kt", c = {}, d = "invokeSuspend", e = "com.obric.capabilitykit.AgentServiceConnection$onServiceConnected$1$1$2")
    public static final class C0875c extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f32027a;

        public C0875c(d.c.d<? super C0875c> r3) {
            super(2, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((C0875c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), C0875c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r1, d.c.d<?> r2) {
            return new C0875c((d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r1) {
            d.c.a.b.a();
            if (this.f32027a != 0) goto L7;
            d.o.a(r1);
            AtomicCapabilitySdk.INSTANCE.onApiInitComplete$capabilitykit_release();
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public static final class d implements IBinder.DeathRecipient {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IBinder f32028a;

        public d(IBinder r3) {
            this.f32028a = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            Logger r0 = Logger.INSTANCE;
            StringBuilder r1 = new StringBuilder().append("binderDied: before, mBindState=");
            c r2 = c.f32017a;
            r0.i(c.f32018b, r1.append(r2.d()).append(", thread=").append(Thread.currentThread().getName()).toString());
            this.f32028a.unlinkToDeath(this, 0);
            Object r4 = c.a();
            monitor-enter(r4);
            r2.a(a.f32022a);     // Catch: Throwable -> L8
            r2.a(null);     // Catch: Throwable -> L8
            monitor-exit(r4);
            r0.i(c.f32018b, "binderDied: done, set mBindState=NotStart, api=null");
            AtomicCapabilitySdk.INSTANCE.onConnectionClosed$capabilitykit_release();
            return;
        L8:
            th = move-exception;
            throw th;
        }
    }

    static {
        f32017a = new c();
        f32021e = new Object();
        ExecutorService r0 = Executors.newSingleThreadExecutor($$Lambda$c$Cf2rZxHqwtd0XduQ0cCxclH8E.INSTANCE);
        d.h.b.o.c(r0, "newSingleThreadExecutor …entSvcConn-thread\")\n    }");
        f = an.a(br.a(r0));
        g = new b();
        h = a.f32022a;
    }

    private c() {
    }

    public static final /* synthetic */ Object a() {
        return f32021e;
    }

    private static final Thread a(Runnable r2) {
        return new Thread((Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.aiagent.plugin"), "AgentSvcConn-thread");
    }

    /* JADX INFO: renamed from: lambda$Cf2rZxHqwtd-0XduQ0-cCxclH8E, reason: not valid java name */
    public static /* synthetic */ Thread m928lambda$Cf2rZxHqwtd0XduQ0cCxclH8E(Runnable r0) {
        return a(r0);
    }

    public final com.obric.capabilitykit.a a(int r13) {
        Object r0 = f32021e;
        monitor-enter(r0);
        Logger r1 = Logger.INSTANCE;     // Catch: Throwable -> L91
        StringBuilder r3 = new StringBuilder().append("getApi: enter, mBindState=").append(h).append(", api=");     // Catch: Throwable -> L91
        if (f32020d != null) goto L9;
        String r4 = "null";
    L10:
        r1.i(f32018b, r3.append(r4).toString());     // Catch: Throwable -> L91
        com.obric.capabilitykit.a r2 = f32020d;     // Catch: Throwable -> L91
        if (r2 == null) goto L94;
        monitor-exit(r0);
        return r2;
    L94:
    L67:
        th = move-exception;
        Object r14 = d.n.f(d.o.a(th));     // Catch: Throwable -> L91
    L69:
        Throwable r15 = d.n.c(r14);     // Catch: Throwable -> L91
        if (r15 != null) goto L73;
    L83:
        monitor-exit(r0);
        com.obric.capabilitykit.a r12 = f32020d;
        if (r12 != null) goto L88;
        r12 = e.f32077a;
    L88:
        if (d.h.b.o.a(r12, e.f32077a) == false) goto L90;
        Logger.INSTANCE.i(f32018b, "getApi: return EmptyCapabilityManager, mBindState=" + h);
    L90:
        return r12;
    L73:
        Logger.INSTANCE.e(f32018b, "bindService throw exception: " + d.a.a(r15));     // Catch: Throwable -> L91
        h = a.f32022a;     // Catch: Throwable -> L91
        ZeusTransformUtils.unbindService((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppHost.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), this, "com.obric.aiagent.plugin");     // Catch: Throwable -> L76
        Object r16 = d.n.f(x.f38692a);     // Catch: Throwable -> L76
    L78:
        Throwable r17 = d.n.c(r16);     // Catch: Throwable -> L91
        if (r17 == null) goto L83;
        Logger.INSTANCE.e(f32018b, "unbindService throw exception: " + d.a.a(r17));     // Catch: Throwable -> L91
        goto L83
    L76:
        th = move-exception;
        r16 = d.n.f(d.o.a(th));     // Catch: Throwable -> L91
        goto L78
    L15:
        if (h != a.f32023b) goto L17;
        r1.i(f32018b, "getApi: api is null but mBindState=Started (connecting), wait onServiceConnected");     // Catch: Throwable -> L67
    L65:
        r14 = d.n.f(x.f38692a);     // Catch: Throwable -> L67
        goto L69
    L17:
        r1.i(f32018b, "getApi: api is null, try rebind, current mBindState=" + h);     // Catch: Throwable -> L67
        Intent r5 = new Intent(f32019c);     // Catch: Throwable -> L67
        List<ResolveInfo> r6 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppHost.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getPackageManager().queryIntentServices(r5, 0);     // Catch: Throwable -> L67
        d.h.b.o.c(r6, "packageManager.queryIntentServices(intent, 0)");     // Catch: Throwable -> L67
        ServiceInfo r7 = null;
        Object r8 = null;
        if (r6 == null) goto L32;
        ArrayList r9 = new ArrayList();     // Catch: Throwable -> L67
        Iterator<T> r10 = r6.iterator();     // Catch: Throwable -> L67
    L21:
        if (r10.hasNext() == false) goto L25;
        ServiceInfo r11 = ((ResolveInfo) ZeusTransformUtils.preCheckCast(r10.next(), ResolveInfo.class, "com.obric.aiagent.plugin")).serviceInfo;     // Catch: Throwable -> L67
        if (r11 == null) goto L21;
        r9.add(r11);     // Catch: Throwable -> L67
        goto L21
    L25:
        Iterator r18 = r9.iterator();     // Catch: Throwable -> L67
    L27:
        if (r18.hasNext() == false) goto L31;
        Object r19 = r18.next();     // Catch: Throwable -> L67
        if (PackageUtils.INSTANCE.checkSignature(((ServiceInfo) ZeusTransformUtils.preCheckCast(r19, ServiceInfo.class, "com.obric.aiagent.plugin")).packageName) == false) goto L27;
        r8 = r19;
    L31:
        r7 = (ServiceInfo) ZeusTransformUtils.preCheckCast(r8, ServiceInfo.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L67
    L32:
        if (r7 == null) goto L34;
        r5.setComponent(new ComponentName(r7.packageName, r7.name));     // Catch: Throwable -> L67
        r5.setPackage(r7.packageName);     // Catch: Throwable -> L67
    L34:
        AtomicCapabilitySdk.INSTANCE.setPendingCallsExecuted$capabilitykit_release(false);     // Catch: Throwable -> L67
        z.a r20 = new z.a();     // Catch: Throwable -> L67
        int r21 = 0;
    L35:
        if (r21 >= 3) goto L57;
        if (r20.f38499a == true) goto L55;
    L44:
        th = move-exception;
        Object r22 = d.n.f(d.o.a(th));     // Catch: Throwable -> L67
    L46:
        Throwable r23 = d.n.c(r22);     // Catch: Throwable -> L67
        if (r23 != null) goto L50;
    L51:
        Boolean r24 = Boolean.FALSE;     // Catch: Throwable -> L67
        if (d.n.b(r22) == false) goto L54;
        r22 = r24;
    L54:
        r20.f38499a = ((Boolean) ZeusTransformUtils.preCheckCast(r22, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();     // Catch: Throwable -> L67
        goto L55
    L50:
        Logger.INSTANCE.e(f32018b, "startService attempt " + (r21 + 1) + " failed: " + d.a.a(r23));     // Catch: Throwable -> L67
        goto L51
    L39:
        if (ZeusTransformUtils.startService((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppHost.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), r5, "com.obric.aiagent.plugin") == null) goto L41;
        boolean r25 = true;
    L42:
        r22 = d.n.f(Boolean.valueOf(r25));     // Catch: Throwable -> L44
    L41:
        r25 = false;
    L55:
        r21 = r21 + 1;     // Catch: Throwable -> L67
        goto L35
    L57:
        if (r20.f38499a == false) goto L63;
        AppHost.Companion r26 = AppHost.Companion;     // Catch: Throwable -> L67
        if (ZeusTransformUtils.bindService((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r26.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), r5, this, r13, "com.obric.aiagent.plugin") == false) goto L61;
        h = a.f32023b;     // Catch: Throwable -> L67
        goto L65
    L61:
        Logger.INSTANCE.i(f32018b, "bindService fail");     // Catch: Throwable -> L67
        h = a.f32022a;     // Catch: Throwable -> L67
        ZeusTransformUtils.unbindService((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r26.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), this, "com.obric.aiagent.plugin");     // Catch: Throwable -> L67
        goto L65
    L63:
        throw new IllegalStateException("startService failed after 3 attempts");     // Catch: Throwable -> L67
    L9:
        r4 = "non-null";
    L91:
        th = move-exception;
        throw th;
    }

    public final void a(com.obric.capabilitykit.a r2) {
        f32020d = (com.obric.capabilitykit.a) ZeusTransformUtils.wrapperContextForParams(r2, com.obric.capabilitykit.a.class, "com.obric.aiagent.plugin");
    }

    public final void a(a r1) {
        d.h.b.o.e(r1, "<set-?>");
        h = r1;
    }

    public final com.obric.capabilitykit.a b() {
        return f32020d;
    }

    public final LinkedHashMap<String, Set<d.m<String, ca>>> c() {
        return g;
    }

    public final a d() {
        return h;
    }

    public final am e() {
        return f;
    }

    @Override // android.content.ServiceConnection
    public void onNullBinding(ComponentName r3) {
        Logger.INSTANCE.i(f32018b, "onNullBinding: " + Thread.currentThread().getName());
        Object r4 = f32021e;
        monitor-enter(r4);
        h = a.f32022a;     // Catch: Throwable -> L12
        f32020d = null;     // Catch: Throwable -> L12
        monitor-exit(r4);
        ZeusTransformUtils.unbindService((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppHost.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), this, "com.obric.aiagent.plugin");     // Catch: Throwable -> L8
        d.n.f(x.f38692a);     // Catch: Throwable -> L8
    L10:
        AtomicCapabilitySdk.INSTANCE.onConnectionClosed$capabilitykit_release();
        return;
    L8:
        th = move-exception;
        d.n.f(d.o.a(th));
    L12:
        th = move-exception;
        throw th;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName r8, IBinder r9) {
        IBinder r7 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r9, IBinder.class, "com.obric.aiagent.plugin");
        Logger r10 = Logger.INSTANCE;
        r10.i(f32018b, "onServiceConnected: " + Thread.currentThread().getName() + ", before mBindState=" + h);
        Object r11 = f32021e;
        monitor-enter(r11);
        if (r7 != null) goto L23;
        r7 = null;
    L10:
        ICapabilityManager r12 = ICapabilityManager.Stub.asInterface(r7);     // Catch: Throwable -> L7
        d.h.b.o.c(r12, "asInterface(binder)");     // Catch: Throwable -> L7
        com.obric.capabilitykit.d r1 = new com.obric.capabilitykit.d(r12);     // Catch: Throwable -> L7
        r10.i(f32018b, "init binder api done");     // Catch: Throwable -> L7
        f32020d = r1;     // Catch: Throwable -> L7
        h = a.f32024c;     // Catch: Throwable -> L7
        Object r13 = d.n.f(kotlinx.coroutines.i.a(f, null, null, new C0875c(null), 3, null));     // Catch: Throwable -> L7
    L13:
        Throwable r14 = d.n.c(r13);     // Catch: Throwable -> L20
        if (r14 == null) goto L18;
        h = a.f32022a;     // Catch: Throwable -> L20
        f32020d = null;     // Catch: Throwable -> L20
        Logger.INSTANCE.e(f32018b, "onServiceConnected throw exception, reset to NotStart: " + d.a.a(r14));     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw th;
    L18:
        monitor-exit(r11);
        return;
    L7:
        th = move-exception;
        r13 = d.n.f(d.o.a(th));     // Catch: Throwable -> L20
        goto L13
    L23:
        r7.linkToDeath(new d(r7), 0);     // Catch: Throwable -> L7
        goto L10
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName r3) {
        Logger r2 = Logger.INSTANCE;
        StringBuilder r0 = new StringBuilder().append("onServiceDisconnected: before, mBindState=").append(h).append(", api=");
        if (f32020d != null) goto L5;
        String r1 = "null";
    L6:
        r2.i(f32018b, r0.append(r1).append(", thread=").append(Thread.currentThread().getName()).toString());
        Object r4 = f32021e;
        monitor-enter(r4);
        h = a.f32022a;     // Catch: Throwable -> L12
        f32020d = null;     // Catch: Throwable -> L12
        monitor-exit(r4);
        AtomicCapabilitySdk.INSTANCE.onConnectionClosed$capabilitykit_release();
        return;
    L12:
        th = move-exception;
        throw th;
    L5:
        r1 = "non-null";
        goto L6
    }
}
