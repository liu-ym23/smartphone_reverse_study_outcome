package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.google.android.gms.common.internal.c, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC1662c<T extends IInterface> {

    /* renamed from: a, reason: collision with root package name */
    public int f19778a;

    /* renamed from: b, reason: collision with root package name */
    public long f19779b;

    /* renamed from: c, reason: collision with root package name */
    public long f19780c;

    /* renamed from: d, reason: collision with root package name */
    public int f19781d;

    /* renamed from: e, reason: collision with root package name */
    public long f19782e;

    /* renamed from: g, reason: collision with root package name */
    public a0 f19784g;

    /* renamed from: h, reason: collision with root package name */
    public final Context f19785h;

    /* renamed from: i, reason: collision with root package name */
    public final Looper f19786i;

    /* renamed from: j, reason: collision with root package name */
    public final AbstractC1665f f19787j;

    /* renamed from: k, reason: collision with root package name */
    public final com.google.android.gms.common.c f19788k;

    /* renamed from: l, reason: collision with root package name */
    public final Handler f19789l;

    /* renamed from: o, reason: collision with root package name */
    public IGmsServiceBroker f19792o;

    /* renamed from: p, reason: collision with root package name */
    public InterfaceC0227c f19793p;

    /* renamed from: q, reason: collision with root package name */
    public IInterface f19794q;

    /* renamed from: s, reason: collision with root package name */
    public L f19796s;

    /* renamed from: u, reason: collision with root package name */
    public final a f19798u;

    /* renamed from: v, reason: collision with root package name */
    public final b f19799v;

    /* renamed from: w, reason: collision with root package name */
    public final int f19800w;

    /* renamed from: x, reason: collision with root package name */
    public final String f19801x;

    /* renamed from: y, reason: collision with root package name */
    public volatile String f19802y;

    /* renamed from: E, reason: collision with root package name */
    public static final Feature[] f19774E = new Feature[0];

    /* renamed from: D, reason: collision with root package name */
    public static final String[] f19773D = {"service_esmobile", "service_googleme"};

    /* renamed from: f, reason: collision with root package name */
    public volatile String f19783f = null;

    /* renamed from: m, reason: collision with root package name */
    public final Object f19790m = new Object();

    /* renamed from: n, reason: collision with root package name */
    public final Object f19791n = new Object();

    /* renamed from: r, reason: collision with root package name */
    public final ArrayList f19795r = new ArrayList();

    /* renamed from: t, reason: collision with root package name */
    public int f19797t = 1;

    /* renamed from: z, reason: collision with root package name */
    public ConnectionResult f19803z = null;

    /* renamed from: A, reason: collision with root package name */
    public boolean f19775A = false;

    /* renamed from: B, reason: collision with root package name */
    public volatile zzk f19776B = null;

    /* renamed from: C, reason: collision with root package name */
    public AtomicInteger f19777C = new AtomicInteger(0);

    /* renamed from: com.google.android.gms.common.internal.c$a */
    public interface a {
        void onConnected(Bundle bundle);

        void onConnectionSuspended(int i10);
    }

    /* renamed from: com.google.android.gms.common.internal.c$b */
    public interface b {
        void onConnectionFailed(ConnectionResult connectionResult);
    }

    /* renamed from: com.google.android.gms.common.internal.c$c, reason: collision with other inner class name */
    public interface InterfaceC0227c {
        void a(ConnectionResult connectionResult);
    }

    /* renamed from: com.google.android.gms.common.internal.c$d */
    public class d implements InterfaceC0227c {
        public d() {
        }

        @Override // com.google.android.gms.common.internal.AbstractC1662c.InterfaceC0227c
        public final void a(ConnectionResult connectionResult) {
            if (connectionResult.isSuccess()) {
                AbstractC1662c abstractC1662c = AbstractC1662c.this;
                abstractC1662c.h(null, abstractC1662c.z());
            } else if (AbstractC1662c.this.f19799v != null) {
                AbstractC1662c.this.f19799v.onConnectionFailed(connectionResult);
            }
        }
    }

    /* renamed from: com.google.android.gms.common.internal.c$e */
    public interface e {
        void a();
    }

    public AbstractC1662c(Context context, Looper looper, AbstractC1665f abstractC1665f, com.google.android.gms.common.c cVar, int i10, a aVar, b bVar, String str) {
        C1669j.l(context, "Context must not be null");
        this.f19785h = context;
        C1669j.l(looper, "Looper must not be null");
        this.f19786i = looper;
        C1669j.l(abstractC1665f, "Supervisor must not be null");
        this.f19787j = abstractC1665f;
        C1669j.l(cVar, "API availability must not be null");
        this.f19788k = cVar;
        this.f19789l = new J(this, looper);
        this.f19800w = i10;
        this.f19798u = aVar;
        this.f19799v = bVar;
        this.f19801x = str;
    }

    public static /* bridge */ /* synthetic */ void Y(AbstractC1662c abstractC1662c, zzk zzkVar) {
        abstractC1662c.f19776B = zzkVar;
        if (abstractC1662c.O()) {
            ConnectionTelemetryConfiguration connectionTelemetryConfiguration = zzkVar.zzd;
            C1670k.b().c(connectionTelemetryConfiguration == null ? null : connectionTelemetryConfiguration.zza());
        }
    }

    public static /* bridge */ /* synthetic */ void Z(AbstractC1662c abstractC1662c, int i10) {
        int i11;
        int i12;
        synchronized (abstractC1662c.f19790m) {
            i11 = abstractC1662c.f19797t;
        }
        if (i11 == 3) {
            abstractC1662c.f19775A = true;
            i12 = 5;
        } else {
            i12 = 4;
        }
        Handler handler = abstractC1662c.f19789l;
        handler.sendMessage(handler.obtainMessage(i12, abstractC1662c.f19777C.get(), 16));
    }

    public static /* bridge */ /* synthetic */ boolean c0(AbstractC1662c abstractC1662c, int i10, int i11, IInterface iInterface) {
        synchronized (abstractC1662c.f19790m) {
            try {
                if (abstractC1662c.f19797t != i10) {
                    return false;
                }
                abstractC1662c.e0(i11, iInterface);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static /* bridge */ /* synthetic */ boolean d0(AbstractC1662c abstractC1662c) throws ClassNotFoundException {
        if (abstractC1662c.f19775A || TextUtils.isEmpty(abstractC1662c.B()) || TextUtils.isEmpty(abstractC1662c.y())) {
            return false;
        }
        try {
            Class.forName(abstractC1662c.B());
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public final T A() throws DeadObjectException {
        T t10;
        synchronized (this.f19790m) {
            try {
                if (this.f19797t == 5) {
                    throw new DeadObjectException();
                }
                o();
                t10 = (T) this.f19794q;
                C1669j.l(t10, "Client is connected but service is null");
            } catch (Throwable th) {
                throw th;
            }
        }
        return t10;
    }

    public abstract String B();

    public abstract String C();

    public String D() {
        return "com.google.android.gms";
    }

    public ConnectionTelemetryConfiguration E() {
        zzk zzkVar = this.f19776B;
        if (zzkVar == null) {
            return null;
        }
        return zzkVar.zzd;
    }

    public boolean F() {
        return l() >= 211700000;
    }

    public boolean G() {
        return this.f19776B != null;
    }

    public void H(T t10) {
        this.f19780c = System.currentTimeMillis();
    }

    public void I(ConnectionResult connectionResult) {
        this.f19781d = connectionResult.getErrorCode();
        this.f19782e = System.currentTimeMillis();
    }

    public void J(int i10) {
        this.f19778a = i10;
        this.f19779b = System.currentTimeMillis();
    }

    public void K(int i10, IBinder iBinder, Bundle bundle, int i11) {
        this.f19789l.sendMessage(this.f19789l.obtainMessage(1, i11, -1, new M(this, i10, iBinder, bundle)));
    }

    public boolean L() {
        return false;
    }

    public void M(String str) {
        this.f19802y = str;
    }

    public void N(int i10) {
        this.f19789l.sendMessage(this.f19789l.obtainMessage(6, this.f19777C.get(), i10));
    }

    public boolean O() {
        return false;
    }

    public final String T() {
        String str = this.f19801x;
        return str == null ? this.f19785h.getClass().getName() : str;
    }

    public void a(String str) {
        this.f19783f = str;
        disconnect();
    }

    public final void a0(int i10, Bundle bundle, int i11) {
        this.f19789l.sendMessage(this.f19789l.obtainMessage(7, i11, -1, new N(this, i10, null)));
    }

    public boolean b() {
        boolean z10;
        synchronized (this.f19790m) {
            int i10 = this.f19797t;
            z10 = true;
            if (i10 != 2 && i10 != 3) {
                z10 = false;
            }
        }
        return z10;
    }

    public String c() {
        a0 a0Var;
        if (!j() || (a0Var = this.f19784g) == null) {
            throw new RuntimeException("Failed to connect when checking package");
        }
        return a0Var.a();
    }

    public void d(InterfaceC0227c interfaceC0227c) {
        C1669j.l(interfaceC0227c, "Connection progress callbacks cannot be null.");
        this.f19793p = interfaceC0227c;
        e0(2, null);
    }

    public void disconnect() {
        this.f19777C.incrementAndGet();
        synchronized (this.f19795r) {
            try {
                int size = this.f19795r.size();
                for (int i10 = 0; i10 < size; i10++) {
                    ((K) this.f19795r.get(i10)).d();
                }
                this.f19795r.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
        synchronized (this.f19791n) {
            this.f19792o = null;
        }
        e0(1, null);
    }

    public boolean e() {
        return true;
    }

    public final void e0(int i10, IInterface iInterface) {
        a0 a0Var;
        C1669j.a((i10 == 4) == (iInterface != null));
        synchronized (this.f19790m) {
            try {
                this.f19797t = i10;
                this.f19794q = iInterface;
                if (i10 == 1) {
                    L l10 = this.f19796s;
                    if (l10 != null) {
                        AbstractC1665f abstractC1665f = this.f19787j;
                        String strB = this.f19784g.b();
                        C1669j.k(strB);
                        abstractC1665f.e(strB, this.f19784g.a(), 4225, l10, T(), this.f19784g.c());
                        this.f19796s = null;
                    }
                } else if (i10 == 2 || i10 == 3) {
                    L l11 = this.f19796s;
                    if (l11 != null && (a0Var = this.f19784g) != null) {
                        Log.e("GmsClient", "Calling connect() while still connected, missing disconnect() for " + a0Var.b() + " on " + a0Var.a());
                        AbstractC1665f abstractC1665f2 = this.f19787j;
                        String strB2 = this.f19784g.b();
                        C1669j.k(strB2);
                        abstractC1665f2.e(strB2, this.f19784g.a(), 4225, l11, T(), this.f19784g.c());
                        this.f19777C.incrementAndGet();
                    }
                    L l12 = new L(this, this.f19777C.get());
                    this.f19796s = l12;
                    a0 a0Var2 = (this.f19797t != 3 || y() == null) ? new a0(D(), C(), false, 4225, F()) : new a0(v().getPackageName(), y(), true, 4225, false);
                    this.f19784g = a0Var2;
                    if (a0Var2.c() && l() < 17895000) {
                        throw new IllegalStateException("Internal Error, the minimum apk version of this BaseGmsClient is too low to support dynamic lookup. Start service action: ".concat(String.valueOf(this.f19784g.b())));
                    }
                    AbstractC1665f abstractC1665f3 = this.f19787j;
                    String strB3 = this.f19784g.b();
                    C1669j.k(strB3);
                    if (!abstractC1665f3.f(new U(strB3, this.f19784g.a(), 4225, this.f19784g.c()), l12, T(), t())) {
                        Log.w("GmsClient", "unable to connect to service: " + this.f19784g.b() + " on " + this.f19784g.a());
                        a0(16, null, this.f19777C.get());
                    }
                } else if (i10 == 4) {
                    C1669j.k(iInterface);
                    H(iInterface);
                }
            } finally {
            }
        }
    }

    public boolean f() {
        return false;
    }

    public void h(IAccountAccessor iAccountAccessor, Set<Scope> set) {
        Bundle bundleX = x();
        String str = this.f19802y;
        int i10 = com.google.android.gms.common.c.f19708a;
        Scope[] scopeArr = GetServiceRequest.zza;
        Bundle bundle = new Bundle();
        int i11 = this.f19800w;
        Feature[] featureArr = GetServiceRequest.zzb;
        GetServiceRequest getServiceRequest = new GetServiceRequest(6, i11, i10, null, null, scopeArr, bundle, null, featureArr, featureArr, true, 0, false, str);
        getServiceRequest.zzf = this.f19785h.getPackageName();
        getServiceRequest.zzi = bundleX;
        if (set != null) {
            getServiceRequest.zzh = (Scope[]) set.toArray(new Scope[0]);
        }
        if (f()) {
            Account accountR = r();
            if (accountR == null) {
                accountR = new Account("<<default account>>", "com.google");
            }
            getServiceRequest.zzj = accountR;
            if (iAccountAccessor != null) {
                getServiceRequest.zzg = iAccountAccessor.asBinder();
            }
        } else if (L()) {
            getServiceRequest.zzj = r();
        }
        getServiceRequest.zzk = f19774E;
        getServiceRequest.zzl = s();
        if (O()) {
            getServiceRequest.zzo = true;
        }
        try {
            try {
                synchronized (this.f19791n) {
                    try {
                        IGmsServiceBroker iGmsServiceBroker = this.f19792o;
                        if (iGmsServiceBroker != null) {
                            iGmsServiceBroker.getService(new zzd(this, this.f19777C.get()), getServiceRequest);
                        } else {
                            Log.w("GmsClient", "mServiceBroker is null, client disconnected");
                        }
                    } finally {
                    }
                }
            } catch (RemoteException | RuntimeException e10) {
                Log.w("GmsClient", "IGmsServiceBroker.getService failed", e10);
                K(8, null, null, this.f19777C.get());
            }
        } catch (DeadObjectException e11) {
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e11);
            N(3);
        } catch (SecurityException e12) {
            throw e12;
        }
    }

    public void i(e eVar) {
        eVar.a();
    }

    public boolean j() {
        boolean z10;
        synchronized (this.f19790m) {
            z10 = this.f19797t == 4;
        }
        return z10;
    }

    public int l() {
        return com.google.android.gms.common.c.f19708a;
    }

    public final Feature[] m() {
        zzk zzkVar = this.f19776B;
        if (zzkVar == null) {
            return null;
        }
        return zzkVar.zzb;
    }

    public String n() {
        return this.f19783f;
    }

    public final void o() {
        if (!j()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    public abstract T p(IBinder iBinder);

    public boolean q() {
        return false;
    }

    public Account r() {
        return null;
    }

    public Feature[] s() {
        return f19774E;
    }

    public Executor t() {
        return null;
    }

    public Bundle u() {
        return null;
    }

    public final Context v() {
        return this.f19785h;
    }

    public int w() {
        return this.f19800w;
    }

    public Bundle x() {
        return new Bundle();
    }

    public String y() {
        return null;
    }

    public Set<Scope> z() {
        return Collections.EMPTY_SET;
    }
}
