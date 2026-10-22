package com.google.android.gms.common.api.internal;

import android.app.ActivityManager;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.util.SparseIntArray;
import ch.qos.logback.core.spi.AbstractComponentTracker;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.MethodInvocation;
import com.google.android.gms.common.internal.TelemetryData;
import com.stepos.alphame.bluetooth.VehicleBluetoothManager;
import f1.AbstractC0557a;
import g1.HandlerC0575c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import l1.C0758c;
import l1.C0760e;
import q.C0818b;

/* renamed from: com.google.android.gms.common.api.internal.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0407e implements Handler.Callback {

    /* renamed from: o, reason: collision with root package name */
    public static final Status f9637o = new Status(4, "Sign-out occurred while this API call was in progress.");

    /* renamed from: p, reason: collision with root package name */
    public static final Status f9638p = new Status(4, "The user must be signed in to make this API call.");

    /* renamed from: q, reason: collision with root package name */
    public static final Object f9639q = new Object();

    /* renamed from: r, reason: collision with root package name */
    public static C0407e f9640r;

    /* renamed from: a, reason: collision with root package name */
    public long f9641a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f9642b;

    /* renamed from: c, reason: collision with root package name */
    public TelemetryData f9643c;

    /* renamed from: d, reason: collision with root package name */
    public com.google.android.gms.common.internal.service.b f9644d;

    /* renamed from: e, reason: collision with root package name */
    public final Context f9645e;

    /* renamed from: f, reason: collision with root package name */
    public final com.google.android.gms.common.b f9646f;

    /* renamed from: g, reason: collision with root package name */
    public final B0.m f9647g;

    /* renamed from: h, reason: collision with root package name */
    public final AtomicInteger f9648h;

    /* renamed from: i, reason: collision with root package name */
    public final AtomicInteger f9649i;

    /* renamed from: j, reason: collision with root package name */
    public final ConcurrentHashMap f9650j;

    /* renamed from: k, reason: collision with root package name */
    public final q.g f9651k;

    /* renamed from: l, reason: collision with root package name */
    public final q.g f9652l;

    /* renamed from: m, reason: collision with root package name */
    public final HandlerC0575c f9653m;

    /* renamed from: n, reason: collision with root package name */
    public volatile boolean f9654n;

    public C0407e(Context context, Looper looper) {
        com.google.android.gms.common.b bVar = com.google.android.gms.common.b.f9701c;
        this.f9641a = AbstractComponentTracker.LINGERING_TIMEOUT;
        this.f9642b = false;
        this.f9648h = new AtomicInteger(1);
        this.f9649i = new AtomicInteger(0);
        this.f9650j = new ConcurrentHashMap(5, 0.75f, 1);
        this.f9651k = new q.g(0);
        this.f9652l = new q.g(0);
        this.f9654n = true;
        this.f9645e = context;
        HandlerC0575c handlerC0575c = new HandlerC0575c(looper, this, 0);
        this.f9653m = handlerC0575c;
        this.f9646f = bVar;
        this.f9647g = new B0.m(0);
        PackageManager packageManager = context.getPackageManager();
        if (AbstractC0557a.f12522f == null) {
            AbstractC0557a.f12522f = Boolean.valueOf(packageManager.hasSystemFeature("android.hardware.type.automotive"));
        }
        if (AbstractC0557a.f12522f.booleanValue()) {
            this.f9654n = false;
        }
        handlerC0575c.sendMessage(handlerC0575c.obtainMessage(6));
    }

    public static Status c(C0403a c0403a, ConnectionResult connectionResult) {
        return new Status(1, 17, "API: " + ((String) c0403a.f9629b.f2364b) + " is not available on this device. Connection failed with: " + String.valueOf(connectionResult), connectionResult.f9599c, connectionResult);
    }

    public static C0407e f(Context context) {
        C0407e c0407e;
        HandlerThread handlerThread;
        synchronized (f9639q) {
            if (f9640r == null) {
                synchronized (com.google.android.gms.common.internal.u.f9848g) {
                    try {
                        handlerThread = com.google.android.gms.common.internal.u.f9850i;
                        if (handlerThread == null) {
                            HandlerThread handlerThread2 = new HandlerThread("GoogleApiHandler", 9);
                            com.google.android.gms.common.internal.u.f9850i = handlerThread2;
                            handlerThread2.start();
                            handlerThread = com.google.android.gms.common.internal.u.f9850i;
                        }
                    } finally {
                    }
                }
                Looper looper = handlerThread.getLooper();
                Context applicationContext = context.getApplicationContext();
                Object obj = com.google.android.gms.common.b.f9700b;
                f9640r = new C0407e(applicationContext, looper);
            }
            c0407e = f9640r;
        }
        return c0407e;
    }

    public final boolean a() {
        if (this.f9642b) {
            return false;
        }
        com.google.android.gms.common.internal.f.b().getClass();
        int i4 = ((SparseIntArray) this.f9647g.f155b).get(203400000, -1);
        return i4 == -1 || i4 == 0;
    }

    public final boolean b(ConnectionResult connectionResult, int i4) throws Resources.NotFoundException {
        boolean zBooleanValue;
        PendingIntent activity;
        Boolean bool;
        com.google.android.gms.common.b bVar = this.f9646f;
        Context context = this.f9645e;
        bVar.getClass();
        synchronized (AbstractC0557a.class) {
            Context applicationContext = context.getApplicationContext();
            Context context2 = AbstractC0557a.f12517a;
            if (context2 == null || (bool = AbstractC0557a.f12518b) == null || context2 != applicationContext) {
                AbstractC0557a.f12518b = null;
                boolean zIsInstantApp = applicationContext.getPackageManager().isInstantApp();
                AbstractC0557a.f12518b = Boolean.valueOf(zIsInstantApp);
                AbstractC0557a.f12517a = applicationContext;
                zBooleanValue = zIsInstantApp;
            } else {
                zBooleanValue = bool.booleanValue();
            }
        }
        if (zBooleanValue) {
            return false;
        }
        int i5 = connectionResult.f9598b;
        if (i5 == 0 || (activity = connectionResult.f9599c) == null) {
            Intent intentA = bVar.a(context, null, i5);
            activity = intentA != null ? PendingIntent.getActivity(context, 0, intentA, 201326592) : null;
        }
        if (activity == null) {
            return false;
        }
        int i6 = connectionResult.f9598b;
        int i7 = GoogleApiActivity.f9607b;
        Intent intent = new Intent(context, (Class<?>) GoogleApiActivity.class);
        intent.putExtra("pending_intent", activity);
        intent.putExtra("failing_client_id", i4);
        intent.putExtra("notify_manager", true);
        bVar.f(context, i6, PendingIntent.getActivity(context, 0, intent, 167772160));
        return true;
    }

    public final q d(Z0.f fVar) {
        C0403a c0403a = fVar.f2154e;
        ConcurrentHashMap concurrentHashMap = this.f9650j;
        q qVar = (q) concurrentHashMap.get(c0403a);
        if (qVar == null) {
            qVar = new q(this, fVar);
            concurrentHashMap.put(c0403a, qVar);
        }
        if (qVar.f9666b.g()) {
            this.f9652l.add(c0403a);
        }
        qVar.j();
        return qVar;
    }

    public final void e(C0758c c0758c, int i4, Z0.f fVar) {
        w wVar;
        if (i4 != 0) {
            C0403a c0403a = fVar.f2154e;
            if (a()) {
                com.google.android.gms.common.internal.f.b().getClass();
                wVar = new w(this, i4, c0403a, System.currentTimeMillis(), SystemClock.elapsedRealtime());
            } else {
                wVar = null;
            }
            if (wVar != null) {
                l1.h hVar = c0758c.f13454a;
                HandlerC0575c handlerC0575c = this.f9653m;
                handlerC0575c.getClass();
                n nVar = new n(handlerC0575c);
                hVar.getClass();
                hVar.f13464b.f(new C0760e(nVar, wVar));
                synchronized (hVar.f13463a) {
                    try {
                        if (hVar.f13465c) {
                            hVar.f13464b.g(hVar);
                        }
                    } finally {
                    }
                }
            }
        }
    }

    public final void g(ConnectionResult connectionResult, int i4) {
        if (b(connectionResult, i4)) {
            return;
        }
        HandlerC0575c handlerC0575c = this.f9653m;
        handlerC0575c.sendMessage(handlerC0575c.obtainMessage(5, i4, 0, connectionResult));
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        Feature[] featureArrB;
        int i4 = message.what;
        long j4 = VehicleBluetoothManager.FAIL_RETRY_TIMEOUT;
        q qVar = null;
        switch (i4) {
            case 1:
                if (true == ((Boolean) message.obj).booleanValue()) {
                    j4 = AbstractComponentTracker.LINGERING_TIMEOUT;
                }
                this.f9641a = j4;
                this.f9653m.removeMessages(12);
                for (C0403a c0403a : this.f9650j.keySet()) {
                    HandlerC0575c handlerC0575c = this.f9653m;
                    handlerC0575c.sendMessageDelayed(handlerC0575c.obtainMessage(12, c0403a), this.f9641a);
                }
                return true;
            case 2:
                B0.g.y(message.obj);
                throw null;
            case 3:
                for (q qVar2 : this.f9650j.values()) {
                    com.stepos.statsrpk.c.k(qVar2.f9676l.f9653m);
                    qVar2.f9675k = null;
                    qVar2.j();
                }
                return true;
            case 4:
            case 8:
            case 13:
                y yVar = (y) message.obj;
                q qVarD = (q) this.f9650j.get(yVar.f9699c.f2154e);
                if (qVarD == null) {
                    qVarD = d(yVar.f9699c);
                }
                if (!qVarD.f9666b.g() || this.f9649i.get() == yVar.f9698b) {
                    qVarD.k(yVar.f9697a);
                } else {
                    yVar.f9697a.c(f9637o);
                    qVarD.m();
                }
                return true;
            case 5:
                int i5 = message.arg1;
                ConnectionResult connectionResult = (ConnectionResult) message.obj;
                Iterator it = this.f9650j.values().iterator();
                while (true) {
                    if (it.hasNext()) {
                        q qVar3 = (q) it.next();
                        if (qVar3.f9671g == i5) {
                            qVar = qVar3;
                        }
                    }
                }
                if (qVar != null) {
                    int i6 = connectionResult.f9598b;
                    if (i6 == 13) {
                        this.f9646f.getClass();
                        AtomicBoolean atomicBoolean = com.google.android.gms.common.e.f9716a;
                        qVar.b(new Status(17, "Error resolution was canceled by the user, original error message: " + ConnectionResult.N(i6) + ": " + connectionResult.f9600d));
                    } else {
                        qVar.b(c(qVar.f9667c, connectionResult));
                    }
                } else {
                    Log.wtf("GoogleApiManager", B0.g.t("Could not find API instance ", i5, " while trying to fail enqueued calls.").toString(), new Exception());
                }
                return true;
            case 6:
                if (this.f9645e.getApplicationContext() instanceof Application) {
                    Application application = (Application) this.f9645e.getApplicationContext();
                    ComponentCallbacks2C0404b componentCallbacks2C0404b = ComponentCallbacks2C0404b.f9632e;
                    synchronized (componentCallbacks2C0404b) {
                        try {
                            if (!componentCallbacks2C0404b.f9636d) {
                                application.registerActivityLifecycleCallbacks(componentCallbacks2C0404b);
                                application.registerComponentCallbacks(componentCallbacks2C0404b);
                                componentCallbacks2C0404b.f9636d = true;
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    o oVar = new o(this);
                    synchronized (componentCallbacks2C0404b) {
                        componentCallbacks2C0404b.f9635c.add(oVar);
                    }
                    AtomicBoolean atomicBoolean2 = componentCallbacks2C0404b.f9634b;
                    boolean z4 = atomicBoolean2.get();
                    AtomicBoolean atomicBoolean3 = componentCallbacks2C0404b.f9633a;
                    if (!z4) {
                        ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
                        ActivityManager.getMyMemoryState(runningAppProcessInfo);
                        if (!atomicBoolean2.getAndSet(true) && runningAppProcessInfo.importance > 100) {
                            atomicBoolean3.set(true);
                        }
                    }
                    if (!atomicBoolean3.get()) {
                        this.f9641a = VehicleBluetoothManager.FAIL_RETRY_TIMEOUT;
                    }
                }
                return true;
            case 7:
                d((Z0.f) message.obj);
                return true;
            case 9:
                if (this.f9650j.containsKey(message.obj)) {
                    q qVar4 = (q) this.f9650j.get(message.obj);
                    com.stepos.statsrpk.c.k(qVar4.f9676l.f9653m);
                    if (qVar4.f9673i) {
                        qVar4.j();
                    }
                }
                return true;
            case 10:
                q.g gVar = this.f9652l;
                gVar.getClass();
                C0818b c0818b = new C0818b(gVar);
                while (c0818b.hasNext()) {
                    q qVar5 = (q) this.f9650j.remove((C0403a) c0818b.next());
                    if (qVar5 != null) {
                        qVar5.m();
                    }
                }
                this.f9652l.clear();
                return true;
            case 11:
                if (this.f9650j.containsKey(message.obj)) {
                    q qVar6 = (q) this.f9650j.get(message.obj);
                    C0407e c0407e = qVar6.f9676l;
                    com.stepos.statsrpk.c.k(c0407e.f9653m);
                    boolean z5 = qVar6.f9673i;
                    if (z5) {
                        if (z5) {
                            C0407e c0407e2 = qVar6.f9676l;
                            HandlerC0575c handlerC0575c2 = c0407e2.f9653m;
                            C0403a c0403a2 = qVar6.f9667c;
                            handlerC0575c2.removeMessages(11, c0403a2);
                            c0407e2.f9653m.removeMessages(9, c0403a2);
                            qVar6.f9673i = false;
                        }
                        qVar6.b(c0407e.f9646f.b(com.google.android.gms.common.c.f9702a, c0407e.f9645e) == 18 ? new Status(21, "Connection timed out waiting for Google Play services update to complete.") : new Status(22, "API failed to connect while resuming due to an unknown error."));
                        qVar6.f9666b.c("Timing out connection while resuming.");
                    }
                }
                return true;
            case 12:
                if (this.f9650j.containsKey(message.obj)) {
                    q qVar7 = (q) this.f9650j.get(message.obj);
                    com.stepos.statsrpk.c.k(qVar7.f9676l.f9653m);
                    com.google.android.gms.common.internal.e eVar = qVar7.f9666b;
                    if (eVar.p() && qVar7.f9670f.size() == 0) {
                        m3.i iVar = qVar7.f9668d;
                        if (((Map) iVar.f13620a).isEmpty() && ((Map) iVar.f13621b).isEmpty()) {
                            eVar.c("Timing out service connection.");
                        } else {
                            qVar7.g();
                        }
                    }
                }
                return true;
            case 14:
                B0.g.y(message.obj);
                throw null;
            case 15:
                r rVar = (r) message.obj;
                if (this.f9650j.containsKey(rVar.f9677a)) {
                    q qVar8 = (q) this.f9650j.get(rVar.f9677a);
                    if (qVar8.f9674j.contains(rVar) && !qVar8.f9673i) {
                        if (qVar8.f9666b.p()) {
                            qVar8.d();
                        } else {
                            qVar8.j();
                        }
                    }
                }
                return true;
            case 16:
                r rVar2 = (r) message.obj;
                if (this.f9650j.containsKey(rVar2.f9677a)) {
                    q qVar9 = (q) this.f9650j.get(rVar2.f9677a);
                    if (qVar9.f9674j.remove(rVar2)) {
                        C0407e c0407e3 = qVar9.f9676l;
                        c0407e3.f9653m.removeMessages(15, rVar2);
                        c0407e3.f9653m.removeMessages(16, rVar2);
                        Feature feature = rVar2.f9678b;
                        LinkedList<v> linkedList = qVar9.f9665a;
                        ArrayList arrayList = new ArrayList(linkedList.size());
                        for (v vVar : linkedList) {
                            if ((vVar instanceof v) && (featureArrB = vVar.b(qVar9)) != null) {
                                int length = featureArrB.length;
                                int i7 = 0;
                                while (true) {
                                    if (i7 >= length) {
                                        break;
                                    }
                                    if (!com.airbnb.lottie.h.m(featureArrB[i7], feature)) {
                                        i7++;
                                    } else if (i7 >= 0) {
                                        arrayList.add(vVar);
                                    }
                                }
                            }
                        }
                        int size = arrayList.size();
                        for (int i8 = 0; i8 < size; i8++) {
                            v vVar2 = (v) arrayList.get(i8);
                            linkedList.remove(vVar2);
                            vVar2.d(new Z0.k(feature));
                        }
                    }
                }
                return true;
            case 17:
                TelemetryData telemetryData = this.f9643c;
                if (telemetryData != null) {
                    if (telemetryData.f9769a > 0 || a()) {
                        if (this.f9644d == null) {
                            this.f9644d = new com.google.android.gms.common.internal.service.b(this.f9645e, com.google.android.gms.common.internal.service.b.f9845i, Z0.e.f2148b);
                        }
                        this.f9644d.b(telemetryData);
                    }
                    this.f9643c = null;
                }
                return true;
            case 18:
                x xVar = (x) message.obj;
                if (xVar.f9695c == 0) {
                    TelemetryData telemetryData2 = new TelemetryData(xVar.f9694b, Arrays.asList(xVar.f9693a));
                    if (this.f9644d == null) {
                        this.f9644d = new com.google.android.gms.common.internal.service.b(this.f9645e, com.google.android.gms.common.internal.service.b.f9845i, Z0.e.f2148b);
                    }
                    this.f9644d.b(telemetryData2);
                } else {
                    TelemetryData telemetryData3 = this.f9643c;
                    if (telemetryData3 != null) {
                        List list = telemetryData3.f9770b;
                        if (telemetryData3.f9769a != xVar.f9694b || (list != null && list.size() >= xVar.f9696d)) {
                            this.f9653m.removeMessages(17);
                            TelemetryData telemetryData4 = this.f9643c;
                            if (telemetryData4 != null) {
                                if (telemetryData4.f9769a > 0 || a()) {
                                    if (this.f9644d == null) {
                                        this.f9644d = new com.google.android.gms.common.internal.service.b(this.f9645e, com.google.android.gms.common.internal.service.b.f9845i, Z0.e.f2148b);
                                    }
                                    this.f9644d.b(telemetryData4);
                                }
                                this.f9643c = null;
                            }
                        } else {
                            TelemetryData telemetryData5 = this.f9643c;
                            MethodInvocation methodInvocation = xVar.f9693a;
                            if (telemetryData5.f9770b == null) {
                                telemetryData5.f9770b = new ArrayList();
                            }
                            telemetryData5.f9770b.add(methodInvocation);
                        }
                    }
                    if (this.f9643c == null) {
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.add(xVar.f9693a);
                        this.f9643c = new TelemetryData(xVar.f9694b, arrayList2);
                        HandlerC0575c handlerC0575c3 = this.f9653m;
                        handlerC0575c3.sendMessageDelayed(handlerC0575c3.obtainMessage(17), xVar.f9695c);
                    }
                }
                return true;
            case 19:
                this.f9642b = false;
                return true;
            default:
                Log.w("GoogleApiManager", "Unknown message id: " + i4);
                return false;
        }
    }
}
