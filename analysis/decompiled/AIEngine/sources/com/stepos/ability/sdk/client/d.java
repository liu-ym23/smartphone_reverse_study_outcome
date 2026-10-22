package com.stepos.ability.sdk.client;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import com.stepos.ability.IAgentServiceManager;
import com.stepos.ability.ITaskListener;
import com.stepos.ability.bean.TaskConfig;
import com.stepos.core.common.atomic.AtomicSdkClientReal$Companion$taskListener$1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.jvm.internal.g;
import lb.n;
import zb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@SuppressLint({"StaticFieldLeak"})
/* loaded from: classes.dex */
public final class d {

    /* renamed from: b, reason: collision with root package name */
    public static Context f5571b;

    /* renamed from: c, reason: collision with root package name */
    public static volatile IAgentServiceManager f5572c;

    /* renamed from: d, reason: collision with root package name */
    public static volatile b f5573d;

    /* renamed from: e, reason: collision with root package name */
    public static volatile boolean f5574e;

    /* renamed from: f, reason: collision with root package name */
    public static volatile boolean f5575f;

    /* renamed from: g, reason: collision with root package name */
    public static volatile boolean f5576g;

    /* renamed from: k, reason: collision with root package name */
    public static volatile AtomicBoolean f5579k;

    /* renamed from: l, reason: collision with root package name */
    public static volatile c f5580l;

    /* renamed from: m, reason: collision with root package name */
    public static volatile boolean f5581m;

    /* renamed from: a, reason: collision with root package name */
    public static final d f5570a = new d();
    public static final Object h = new Object();

    /* renamed from: i, reason: collision with root package name */
    public static final ArrayList<l<Boolean, n>> f5577i = new ArrayList<>();

    /* renamed from: j, reason: collision with root package name */
    public static final ConcurrentHashMap<String, ITaskListener> f5578j = new ConcurrentHashMap<>();

    /* renamed from: n, reason: collision with root package name */
    public static final CopyOnWriteArrayList<a> f5582n = new CopyOnWriteArrayList<>();

    /* renamed from: o, reason: collision with root package name */
    public static final com.stepos.ability.sdk.client.a f5583o = new com.stepos.ability.sdk.client.a();

    /* renamed from: p, reason: collision with root package name */
    public static final b f5584p = new b();

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface a {
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class b implements ServiceConnection {
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Object objA;
            v5.a aVar = v5.b.f13381a;
            IAgentServiceManager iAgentServiceManagerAsInterface = IAgentServiceManager.Stub.asInterface(iBinder);
            d dVar = d.f5570a;
            d.f5572c = iAgentServiceManagerAsInterface;
            if (iBinder != null) {
                try {
                    iBinder.linkToDeath(d.f5583o, 0);
                    n nVar = n.f10413a;
                } catch (Throwable th) {
                    kotlin.c.a(th);
                }
            }
            AtomicBoolean atomicBoolean = d.f5579k;
            d.f5570a.getClass();
            d.c();
            d.f5579k = null;
            g.c(iAgentServiceManagerAsInterface);
            ConcurrentHashMap<String, ITaskListener> concurrentHashMap = d.f5578j;
            if (!concurrentHashMap.isEmpty()) {
                for (Map.Entry<String, ITaskListener> entry : concurrentHashMap.entrySet()) {
                    String key = entry.getKey();
                    try {
                        iAgentServiceManagerAsInterface.registerTaskListener(entry.getValue(), key);
                        String msg = "reRegisterTaskListener done: key=" + key;
                        g.f(msg, "msg");
                        aVar.a(3, "Ability_".concat("Ability_AgentServiceClient"), msg, null);
                    } catch (Exception e10) {
                        String msg2 = "reRegisterTaskListener failed: key=" + key;
                        g.f(msg2, "msg");
                        aVar.a(5, "Ability_".concat("Ability_AgentServiceClient"), msg2, e10);
                    }
                }
            }
            d.a(d.f5570a, true, atomicBoolean);
            Iterator<a> it = d.f5582n.iterator();
            while (it.hasNext()) {
                try {
                    it.next().getClass();
                    objA = n.f10413a;
                } catch (Throwable th2) {
                    objA = kotlin.c.a(th2);
                }
                Throwable thB = Result.b(objA);
                if (thB != null) {
                    aVar.a(5, "Ability_".concat("Ability_AgentServiceClient"), "onConnected callback threw", thB);
                }
            }
            aVar.a(3, "Ability_".concat("Ability_AgentServiceClient"), "onServiceConnected", null);
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            Object objA;
            v5.a aVar = v5.b.f13381a;
            d dVar = d.f5570a;
            d.f5572c = null;
            d.f5576g = false;
            AtomicBoolean atomicBoolean = d.f5579k;
            d dVar2 = d.f5570a;
            dVar2.getClass();
            d.c();
            d.f5579k = null;
            d.a(dVar2, false, atomicBoolean);
            Iterator<a> it = d.f5582n.iterator();
            while (it.hasNext()) {
                try {
                    it.next().getClass();
                    objA = n.f10413a;
                } catch (Throwable th) {
                    objA = kotlin.c.a(th);
                }
                Throwable thB = Result.b(objA);
                if (thB != null) {
                    aVar.a(5, "Ability_".concat("Ability_AgentServiceClient"), "onDisconnected callback threw", thB);
                }
            }
            aVar.a(3, "Ability_".concat("Ability_AgentServiceClient"), "onServiceDisconnected", null);
        }
    }

    public static final void a(d dVar, boolean z, AtomicBoolean atomicBoolean) {
        dVar.getClass();
        if (atomicBoolean != null && atomicBoolean.compareAndSet(false, true)) {
            e(z);
            return;
        }
        synchronized (h) {
            try {
                if (f5574e) {
                    f5574e = false;
                    ArrayList<l<Boolean, n>> arrayList = f5577i;
                    List<l> listO0 = kotlin.collections.a.O0(arrayList);
                    arrayList.clear();
                    for (l lVar : listO0) {
                        if (lVar != null) {
                            lVar.invoke(Boolean.valueOf(z));
                        }
                    }
                    n nVar = n.f10413a;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void b(l lVar) {
        Context context;
        if (f5572c != null) {
            lVar.invoke(Boolean.TRUE);
            v5.b.f13381a.a(3, "Ability_".concat("Ability_AgentServiceClient"), "bind: reuse existing", null);
            return;
        }
        synchronized (h) {
            ArrayList<l<Boolean, n>> arrayList = f5577i;
            arrayList.add(lVar);
            if (f5574e) {
                String msg = "bind: in progress, callback queued (queueSize=" + arrayList.size() + ")";
                g.f(msg, "msg");
                v5.b.f13381a.a(3, "Ability_".concat("Ability_AgentServiceClient"), msg, null);
                return;
            }
            f5574e = true;
            n nVar = n.f10413a;
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            c();
            f5579k = null;
            c cVar = new c(atomicBoolean, 0);
            f5580l = cVar;
            f5579k = atomicBoolean;
            ((Handler) v5.c.f13382a.getValue()).postDelayed(cVar, 4000L);
            if (f5576g) {
                v5.b.f13381a.a(3, "Ability_".concat("Ability_AgentServiceClient"), "bind: waiting for BIND_AUTO_CREATE reconnect", null);
                return;
            }
            String msg2 = "bind: start+bind (serviceStarted=" + f5575f + ")";
            g.f(msg2, "msg");
            v5.b.f13381a.a(3, "Ability_".concat("Ability_AgentServiceClient"), msg2, null);
            Intent component = new Intent("com.stepos.ability.BIND_AGENT_SERVICE").setComponent(new ComponentName("com.stepos.ability", "com.stepos.ability.service.AgentService"));
            g.e(component, "setComponent(...)");
            if (!f5575f) {
                try {
                    Context context2 = f5571b;
                    if (context2 == null) {
                        g.l("context");
                        throw null;
                    }
                    context2.startService(component);
                    f5575f = true;
                } catch (Exception e10) {
                    String msg3 = "startService failed: " + e10.getMessage();
                    g.f(msg3, "msg");
                    v5.b.f13381a.a(5, "Ability_".concat("Ability_AgentServiceClient"), msg3, null);
                }
            }
            try {
                Context context3 = f5571b;
                if (context3 == null) {
                    g.l("context");
                    throw null;
                }
                b bVar = f5584p;
                if (context3.bindService(component, bVar, 1)) {
                    f5573d = bVar;
                    f5576g = true;
                    return;
                }
                v5.b.f13381a.a(5, "Ability_".concat("Ability_AgentServiceClient"), "bindService returned false — releasing", null);
                try {
                    context = f5571b;
                } catch (Throwable th) {
                    kotlin.c.a(th);
                }
                if (context == null) {
                    g.l("context");
                    throw null;
                }
                context.unbindService(bVar);
                n nVar2 = n.f10413a;
                c();
                f5579k = null;
                if (atomicBoolean.compareAndSet(false, true)) {
                    e(false);
                }
            } catch (Exception e11) {
                String msg4 = "bindService failed: " + e11.getMessage();
                g.f(msg4, "msg");
                v5.b.f13381a.a(5, "Ability_".concat("Ability_AgentServiceClient"), msg4, null);
                c();
                f5579k = null;
                if (atomicBoolean.compareAndSet(false, true)) {
                    e(false);
                }
            }
        }
    }

    public static void c() {
        c cVar = f5580l;
        if (cVar != null) {
            ((Handler) v5.c.f13382a.getValue()).removeCallbacks(cVar);
        }
        f5580l = null;
    }

    public static void d() {
        if (f5581m) {
            return;
        }
        v5.b.f13381a.a(6, "Ability_".concat("Ability_AgentServiceClient"), "AgentServiceClient not initialized. Call AgentServiceClient.init(context) first !", null);
        throw new IllegalStateException("AgentServiceClient not initialized. Call AgentServiceClient.init(context) first !");
    }

    public static void e(boolean z) {
        List<l> listO0;
        synchronized (h) {
            f5574e = false;
            ArrayList<l<Boolean, n>> arrayList = f5577i;
            listO0 = kotlin.collections.a.O0(arrayList);
            arrayList.clear();
            n nVar = n.f10413a;
        }
        for (l lVar : listO0) {
            if (lVar != null) {
                lVar.invoke(Boolean.valueOf(z));
            }
        }
    }

    public static void f(TaskConfig taskConfig) {
        String msg = "internalSubmitTask taskConfig" + taskConfig;
        g.f(msg, "msg");
        v5.b.f13381a.a(3, "Ability_".concat("Ability_AgentServiceClient"), msg, null);
        IAgentServiceManager iAgentServiceManager = f5572c;
        if (iAgentServiceManager != null) {
            iAgentServiceManager.submitTask(taskConfig);
        }
    }

    public static void g(AtomicSdkClientReal$Companion$taskListener$1 listener) {
        g.f(listener, "listener");
        d();
        Context context = f5571b;
        if (context == null) {
            g.l("context");
            throw null;
        }
        String str = context.getPackageName() + "#" + System.identityHashCode(listener);
        f5578j.put(str, listener);
        Context context2 = f5571b;
        if (context2 == null) {
            g.l("context");
            throw null;
        }
        String str2 = "registerTaskListener " + context2.getPackageName() + " listener:" + listener;
        com.stepos.ability.sdk.client.b bVar = new com.stepos.ability.sdk.client.b(0, listener, str);
        d();
        b(new com.stepos.ability.sdk.client.b(1, str2, (Object) bVar));
    }

    public static void h() {
        b bVar;
        List<l> listO0;
        Object objA;
        if (!f5581m) {
            v5.b.b("release ignore: not initialized");
            return;
        }
        v5.b.b("release start");
        c();
        f5579k = null;
        synchronized (h) {
            bVar = f5573d;
            ArrayList<l<Boolean, n>> arrayList = f5577i;
            listO0 = kotlin.collections.a.O0(arrayList);
            arrayList.clear();
            f5574e = false;
            f5572c = null;
            f5573d = null;
            f5575f = false;
            f5576g = false;
            f5581m = false;
            f5578j.clear();
            n nVar = n.f10413a;
        }
        if (bVar != null) {
            try {
                Context context = f5571b;
                if (context == null) {
                    g.l("context");
                    throw null;
                }
                context.unbindService(bVar);
            } catch (Exception e10) {
                String msg = "release unbindService: " + e10.getMessage();
                g.f(msg, "msg");
                v5.b.f13381a.a(5, "Ability_".concat("Ability_AgentServiceClient"), msg, null);
            }
        }
        for (l lVar : listO0) {
            if (lVar != null) {
                lVar.invoke(Boolean.FALSE);
            }
        }
        Iterator<a> it = f5582n.iterator();
        while (it.hasNext()) {
            try {
                it.next().getClass();
                objA = n.f10413a;
            } catch (Throwable th) {
                objA = kotlin.c.a(th);
            }
            Throwable thB = Result.b(objA);
            if (thB != null) {
                v5.b.f13381a.a(5, "Ability_".concat("Ability_AgentServiceClient"), "release: onDisconnected callback threw", thB);
            }
        }
        f5582n.clear();
        v5.b.f13381a.a(3, "Ability_".concat("Ability_AgentServiceClient"), "release done", null);
    }
}
