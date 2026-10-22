package com.google.android.gms.common.api.internal;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.C1643i;
import com.google.android.gms.common.internal.AbstractC1665f;
import com.google.android.gms.common.internal.C1670k;
import com.google.android.gms.common.internal.C1671l;
import com.google.android.gms.common.internal.C1684z;
import com.google.android.gms.common.internal.InterfaceC1672m;
import com.google.android.gms.common.internal.MethodInvocation;
import com.google.android.gms.common.internal.RootTelemetryConfiguration;
import com.google.android.gms.common.internal.TelemetryData;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

/* renamed from: com.google.android.gms.common.api.internal.f, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C1640f implements Handler.Callback {

    /* renamed from: p, reason: collision with root package name */
    public static final Status f19601p = new Status(4, "Sign-out occurred while this API call was in progress.");

    /* renamed from: q, reason: collision with root package name */
    public static final Status f19602q = new Status(4, "The user must be signed in to make this API call.");

    /* renamed from: r, reason: collision with root package name */
    public static final Object f19603r = new Object();

    /* renamed from: s, reason: collision with root package name */
    public static C1640f f19604s;

    /* renamed from: c, reason: collision with root package name */
    public TelemetryData f19607c;

    /* renamed from: d, reason: collision with root package name */
    public InterfaceC1672m f19608d;

    /* renamed from: e, reason: collision with root package name */
    public final Context f19609e;

    /* renamed from: f, reason: collision with root package name */
    public final com.google.android.gms.common.b f19610f;

    /* renamed from: g, reason: collision with root package name */
    public final C1684z f19611g;

    /* renamed from: n, reason: collision with root package name */
    @NotOnlyInitialized
    public final Handler f19618n;

    /* renamed from: o, reason: collision with root package name */
    public volatile boolean f19619o;

    /* renamed from: a, reason: collision with root package name */
    public long f19605a = 10000;

    /* renamed from: b, reason: collision with root package name */
    public boolean f19606b = false;

    /* renamed from: h, reason: collision with root package name */
    public final AtomicInteger f19612h = new AtomicInteger(1);

    /* renamed from: i, reason: collision with root package name */
    public final AtomicInteger f19613i = new AtomicInteger(0);

    /* renamed from: j, reason: collision with root package name */
    public final Map f19614j = new ConcurrentHashMap(5, 0.75f, 1);

    /* renamed from: k, reason: collision with root package name */
    public C1655v f19615k = null;

    /* renamed from: l, reason: collision with root package name */
    public final Set f19616l = new androidx.collection.b();

    /* renamed from: m, reason: collision with root package name */
    public final Set f19617m = new androidx.collection.b();

    public C1640f(Context context, Looper looper, com.google.android.gms.common.b bVar) {
        this.f19619o = true;
        this.f19609e = context;
        w2.i iVar = new w2.i(looper, this);
        this.f19618n = iVar;
        this.f19610f = bVar;
        this.f19611g = new C1684z(bVar);
        if (s2.f.a(context)) {
            this.f19619o = false;
        }
        iVar.sendMessage(iVar.obtainMessage(6));
    }

    public static Status f(C1635b c1635b, ConnectionResult connectionResult) {
        return new Status(connectionResult, "API: " + c1635b.b() + " is not available on this device. Connection failed with: " + String.valueOf(connectionResult));
    }

    @ResultIgnorabilityUnspecified
    public static C1640f t(Context context) {
        C1640f c1640f;
        synchronized (f19603r) {
            try {
                if (f19604s == null) {
                    f19604s = new C1640f(context.getApplicationContext(), AbstractC1665f.c().getLooper(), com.google.android.gms.common.b.m());
                }
                c1640f = f19604s;
            } catch (Throwable th) {
                throw th;
            }
        }
        return c1640f;
    }

    public final void B(com.google.android.gms.common.api.c cVar, int i10, AbstractC1651q abstractC1651q, D2.j jVar, InterfaceC1650p interfaceC1650p) {
        j(jVar, abstractC1651q.d(), cVar);
        this.f19618n.sendMessage(this.f19618n.obtainMessage(4, new Y(new n0(i10, abstractC1651q, jVar, interfaceC1650p), this.f19613i.get(), cVar)));
    }

    public final void C(MethodInvocation methodInvocation, int i10, long j10, int i11) {
        this.f19618n.sendMessage(this.f19618n.obtainMessage(18, new V(methodInvocation, i10, j10, i11)));
    }

    public final void D(ConnectionResult connectionResult, int i10) throws Resources.NotFoundException {
        if (e(connectionResult, i10)) {
            return;
        }
        Handler handler = this.f19618n;
        handler.sendMessage(handler.obtainMessage(5, i10, 0, connectionResult));
    }

    public final void E() {
        Handler handler = this.f19618n;
        handler.sendMessage(handler.obtainMessage(3));
    }

    public final void F(com.google.android.gms.common.api.c cVar) {
        Handler handler = this.f19618n;
        handler.sendMessage(handler.obtainMessage(7, cVar));
    }

    public final void a(C1655v c1655v) {
        synchronized (f19603r) {
            try {
                if (this.f19615k != c1655v) {
                    this.f19615k = c1655v;
                    this.f19616l.clear();
                }
                this.f19616l.addAll(c1655v.t());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b(C1655v c1655v) {
        synchronized (f19603r) {
            try {
                if (this.f19615k == c1655v) {
                    this.f19615k = null;
                    this.f19616l.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean d() {
        if (this.f19606b) {
            return false;
        }
        RootTelemetryConfiguration rootTelemetryConfigurationA = C1670k.b().a();
        if (rootTelemetryConfigurationA != null && !rootTelemetryConfigurationA.getMethodInvocationTelemetryEnabled()) {
            return false;
        }
        int iA = this.f19611g.a(this.f19609e, 203400000);
        return iA == -1 || iA == 0;
    }

    @ResultIgnorabilityUnspecified
    public final boolean e(ConnectionResult connectionResult, int i10) throws Resources.NotFoundException {
        return this.f19610f.w(this.f19609e, connectionResult, i10);
    }

    @ResultIgnorabilityUnspecified
    public final J g(com.google.android.gms.common.api.c cVar) throws PackageManager.NameNotFoundException {
        Map map = this.f19614j;
        C1635b c1635bI = cVar.i();
        J j10 = (J) map.get(c1635bI);
        if (j10 == null) {
            j10 = new J(this, cVar);
            this.f19614j.put(c1635bI, j10);
        }
        if (j10.a()) {
            this.f19617m.add(c1635bI);
        }
        j10.C();
        return j10;
    }

    public final InterfaceC1672m h() {
        if (this.f19608d == null) {
            this.f19608d = C1671l.a(this.f19609e);
        }
        return this.f19608d;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) throws PackageManager.NameNotFoundException {
        int i10 = message.what;
        J j10 = null;
        switch (i10) {
            case 1:
                this.f19605a = true == ((Boolean) message.obj).booleanValue() ? 10000L : 300000L;
                this.f19618n.removeMessages(12);
                for (C1635b c1635b : this.f19614j.keySet()) {
                    Handler handler = this.f19618n;
                    handler.sendMessageDelayed(handler.obtainMessage(12, c1635b), this.f19605a);
                }
                return true;
            case 2:
                q0 q0Var = (q0) message.obj;
                Iterator it = q0Var.a().iterator();
                while (true) {
                    if (it.hasNext()) {
                        C1635b c1635b2 = (C1635b) it.next();
                        J j11 = (J) this.f19614j.get(c1635b2);
                        if (j11 == null) {
                            q0Var.b(c1635b2, new ConnectionResult(13), null);
                        } else if (j11.N()) {
                            q0Var.b(c1635b2, ConnectionResult.RESULT_SUCCESS, j11.t().c());
                        } else {
                            ConnectionResult connectionResultR = j11.r();
                            if (connectionResultR != null) {
                                q0Var.b(c1635b2, connectionResultR, null);
                            } else {
                                j11.H(q0Var);
                                j11.C();
                            }
                        }
                    }
                }
                return true;
            case 3:
                for (J j12 : this.f19614j.values()) {
                    j12.B();
                    j12.C();
                }
                return true;
            case 4:
            case 8:
            case 13:
                Y y10 = (Y) message.obj;
                J jG = (J) this.f19614j.get(y10.f19585c.i());
                if (jG == null) {
                    jG = g(y10.f19585c);
                }
                if (!jG.a() || this.f19613i.get() == y10.f19584b) {
                    jG.D(y10.f19583a);
                } else {
                    y10.f19583a.a(f19601p);
                    jG.J();
                }
                return true;
            case 5:
                int i11 = message.arg1;
                ConnectionResult connectionResult = (ConnectionResult) message.obj;
                Iterator it2 = this.f19614j.values().iterator();
                while (true) {
                    if (it2.hasNext()) {
                        J j13 = (J) it2.next();
                        if (j13.p() == i11) {
                            j10 = j13;
                        }
                    }
                }
                if (j10 == null) {
                    Log.wtf("GoogleApiManager", "Could not find API instance " + i11 + " while trying to fail enqueued calls.", new Exception());
                } else if (connectionResult.getErrorCode() == 13) {
                    j10.e(new Status(17, "Error resolution was canceled by the user, original error message: " + this.f19610f.e(connectionResult.getErrorCode()) + ": " + connectionResult.getErrorMessage()));
                } else {
                    j10.e(f(j10.f19544c, connectionResult));
                }
                return true;
            case 6:
                if (this.f19609e.getApplicationContext() instanceof Application) {
                    ComponentCallbacks2C1637c.c((Application) this.f19609e.getApplicationContext());
                    ComponentCallbacks2C1637c.b().a(new E(this));
                    if (!ComponentCallbacks2C1637c.b().e(true)) {
                        this.f19605a = 300000L;
                    }
                }
                return true;
            case 7:
                g((com.google.android.gms.common.api.c) message.obj);
                return true;
            case 9:
                if (this.f19614j.containsKey(message.obj)) {
                    ((J) this.f19614j.get(message.obj)).I();
                }
                return true;
            case 10:
                Iterator it3 = this.f19617m.iterator();
                while (it3.hasNext()) {
                    J j14 = (J) this.f19614j.remove((C1635b) it3.next());
                    if (j14 != null) {
                        j14.J();
                    }
                }
                this.f19617m.clear();
                return true;
            case 11:
                if (this.f19614j.containsKey(message.obj)) {
                    ((J) this.f19614j.get(message.obj)).K();
                }
                return true;
            case 12:
                if (this.f19614j.containsKey(message.obj)) {
                    ((J) this.f19614j.get(message.obj)).b();
                }
                return true;
            case 14:
                C1656w c1656w = (C1656w) message.obj;
                C1635b c1635bA = c1656w.a();
                if (this.f19614j.containsKey(c1635bA)) {
                    c1656w.b().c(Boolean.valueOf(((J) this.f19614j.get(c1635bA)).o(false)));
                } else {
                    c1656w.b().c(Boolean.FALSE);
                }
                return true;
            case 15:
                L l10 = (L) message.obj;
                if (this.f19614j.containsKey(l10.f19555a)) {
                    J.z((J) this.f19614j.get(l10.f19555a), l10);
                }
                return true;
            case 16:
                L l11 = (L) message.obj;
                if (this.f19614j.containsKey(l11.f19555a)) {
                    J.A((J) this.f19614j.get(l11.f19555a), l11);
                }
                return true;
            case 17:
                i();
                return true;
            case 18:
                V v10 = (V) message.obj;
                if (v10.f19578c == 0) {
                    h().a(new TelemetryData(v10.f19577b, Arrays.asList(v10.f19576a)));
                } else {
                    TelemetryData telemetryData = this.f19607c;
                    if (telemetryData != null) {
                        List listZab = telemetryData.zab();
                        if (telemetryData.zaa() != v10.f19577b || (listZab != null && listZab.size() >= v10.f19579d)) {
                            this.f19618n.removeMessages(17);
                            i();
                        } else {
                            this.f19607c.zac(v10.f19576a);
                        }
                    }
                    if (this.f19607c == null) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(v10.f19576a);
                        this.f19607c = new TelemetryData(v10.f19577b, arrayList);
                        Handler handler2 = this.f19618n;
                        handler2.sendMessageDelayed(handler2.obtainMessage(17), v10.f19578c);
                    }
                }
                return true;
            case 19:
                this.f19606b = false;
                return true;
            default:
                Log.w("GoogleApiManager", "Unknown message id: " + i10);
                return false;
        }
    }

    public final void i() {
        TelemetryData telemetryData = this.f19607c;
        if (telemetryData != null) {
            if (telemetryData.zaa() > 0 || d()) {
                h().a(telemetryData);
            }
            this.f19607c = null;
        }
    }

    public final void j(D2.j jVar, int i10, com.google.android.gms.common.api.c cVar) {
        U uB;
        if (i10 == 0 || (uB = U.b(this, i10, cVar.i())) == null) {
            return;
        }
        D2.i iVarA = jVar.a();
        final Handler handler = this.f19618n;
        handler.getClass();
        iVarA.c(new Executor() { // from class: com.google.android.gms.common.api.internal.D
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                handler.post(runnable);
            }
        }, uB);
    }

    public final int k() {
        return this.f19612h.getAndIncrement();
    }

    public final J s(C1635b c1635b) {
        return (J) this.f19614j.get(c1635b);
    }

    public final D2.i v(com.google.android.gms.common.api.c cVar, AbstractC1647m abstractC1647m, AbstractC1652s abstractC1652s, Runnable runnable) {
        D2.j jVar = new D2.j();
        j(jVar, abstractC1647m.e(), cVar);
        this.f19618n.sendMessage(this.f19618n.obtainMessage(8, new Y(new m0(new Z(abstractC1647m, abstractC1652s, runnable), jVar), this.f19613i.get(), cVar)));
        return jVar.a();
    }

    public final D2.i w(com.google.android.gms.common.api.c cVar, C1643i.a aVar, int i10) {
        D2.j jVar = new D2.j();
        j(jVar, i10, cVar);
        this.f19618n.sendMessage(this.f19618n.obtainMessage(13, new Y(new o0(aVar, jVar), this.f19613i.get(), cVar)));
        return jVar.a();
    }
}
