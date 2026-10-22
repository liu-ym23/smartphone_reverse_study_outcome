package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: w, reason: collision with root package name */
    public static final Feature[] f9772w = new Feature[0];

    /* renamed from: a, reason: collision with root package name */
    public volatile String f9773a;

    /* renamed from: b, reason: collision with root package name */
    public com.google.android.gms.common.api.internal.k f9774b;

    /* renamed from: c, reason: collision with root package name */
    public final Context f9775c;

    /* renamed from: d, reason: collision with root package name */
    public final u f9776d;

    /* renamed from: e, reason: collision with root package name */
    public final n f9777e;

    /* renamed from: f, reason: collision with root package name */
    public final Object f9778f;

    /* renamed from: g, reason: collision with root package name */
    public final Object f9779g;

    /* renamed from: h, reason: collision with root package name */
    public IGmsServiceBroker f9780h;

    /* renamed from: i, reason: collision with root package name */
    public a f9781i;

    /* renamed from: j, reason: collision with root package name */
    public IInterface f9782j;

    /* renamed from: k, reason: collision with root package name */
    public final ArrayList f9783k;

    /* renamed from: l, reason: collision with root package name */
    public o f9784l;

    /* renamed from: m, reason: collision with root package name */
    public int f9785m;

    /* renamed from: n, reason: collision with root package name */
    public final b f9786n;

    /* renamed from: o, reason: collision with root package name */
    public final b f9787o;

    /* renamed from: p, reason: collision with root package name */
    public final int f9788p;

    /* renamed from: q, reason: collision with root package name */
    public final String f9789q;

    /* renamed from: r, reason: collision with root package name */
    public volatile String f9790r;

    /* renamed from: s, reason: collision with root package name */
    public ConnectionResult f9791s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f9792t;

    /* renamed from: u, reason: collision with root package name */
    public volatile zzj f9793u;

    /* renamed from: v, reason: collision with root package name */
    public final AtomicInteger f9794v;

    public c(Context context, Looper looper, u uVar, int i4, b bVar, b bVar2, String str) {
        Object obj = com.google.android.gms.common.b.f9700b;
        this.f9773a = null;
        this.f9778f = new Object();
        this.f9779g = new Object();
        this.f9783k = new ArrayList();
        this.f9785m = 1;
        this.f9791s = null;
        this.f9792t = false;
        this.f9793u = null;
        this.f9794v = new AtomicInteger(0);
        com.stepos.statsrpk.c.m(context, "Context must not be null");
        this.f9775c = context;
        com.stepos.statsrpk.c.m(looper, "Looper must not be null");
        com.stepos.statsrpk.c.m(uVar, "Supervisor must not be null");
        this.f9776d = uVar;
        this.f9777e = new n(this, looper);
        this.f9788p = i4;
        this.f9786n = bVar;
        this.f9787o = bVar2;
        this.f9789q = str;
    }

    public static /* bridge */ /* synthetic */ boolean r(c cVar, int i4, int i5, IInterface iInterface) {
        synchronized (cVar.f9778f) {
            try {
                if (cVar.f9785m != i4) {
                    return false;
                }
                cVar.s(i5, iInterface);
                return true;
            } finally {
            }
        }
    }

    public final void b(IAccountAccessor iAccountAccessor, Set set) {
        Bundle bundleK = k();
        int i4 = this.f9788p;
        String str = this.f9790r;
        int i5 = com.google.android.gms.common.c.f9702a;
        Scope[] scopeArr = GetServiceRequest.f9739o;
        Bundle bundle = new Bundle();
        Feature[] featureArr = GetServiceRequest.f9740p;
        GetServiceRequest getServiceRequest = new GetServiceRequest(6, i4, i5, null, null, scopeArr, bundle, null, featureArr, featureArr, true, 0, false, str);
        getServiceRequest.f9744d = this.f9775c.getPackageName();
        getServiceRequest.f9747g = bundleK;
        if (set != null) {
            getServiceRequest.f9746f = (Scope[]) set.toArray(new Scope[0]);
        }
        if (g()) {
            Account account = ((e) this).f9805y;
            if (account == null) {
                account = new Account("<<default account>>", "com.google");
            }
            getServiceRequest.f9748h = account;
            if (iAccountAccessor != null) {
                getServiceRequest.f9745e = iAccountAccessor.asBinder();
            }
        }
        getServiceRequest.f9749i = f9772w;
        getServiceRequest.f9750j = j();
        try {
            try {
                synchronized (this.f9779g) {
                    try {
                        IGmsServiceBroker iGmsServiceBroker = this.f9780h;
                        if (iGmsServiceBroker != null) {
                            iGmsServiceBroker.getService(new zzd(this, this.f9794v.get()), getServiceRequest);
                        } else {
                            Log.w("GmsClient", "mServiceBroker is null, client disconnected");
                        }
                    } finally {
                    }
                }
            } catch (RemoteException | RuntimeException e4) {
                Log.w("GmsClient", "IGmsServiceBroker.getService failed", e4);
                int i6 = this.f9794v.get();
                p pVar = new p(this, 8, null, null);
                n nVar = this.f9777e;
                nVar.sendMessage(nVar.obtainMessage(1, i6, -1, pVar));
            }
        } catch (DeadObjectException e5) {
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e5);
            n nVar2 = this.f9777e;
            nVar2.sendMessage(nVar2.obtainMessage(6, this.f9794v.get(), 3));
        } catch (SecurityException e6) {
            throw e6;
        }
    }

    public final void c(String str) {
        this.f9773a = str;
        f();
    }

    public abstract int e();

    public final void f() {
        this.f9794v.incrementAndGet();
        synchronized (this.f9783k) {
            try {
                int size = this.f9783k.size();
                for (int i4 = 0; i4 < size; i4++) {
                    l lVar = (l) this.f9783k.get(i4);
                    synchronized (lVar) {
                        lVar.f9817a = null;
                    }
                }
                this.f9783k.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
        synchronized (this.f9779g) {
            this.f9780h = null;
        }
        s(1, null);
    }

    public boolean g() {
        return false;
    }

    public abstract IInterface i(IBinder iBinder);

    public Feature[] j() {
        return f9772w;
    }

    public abstract Bundle k();

    public final IInterface l() {
        IInterface iInterface;
        synchronized (this.f9778f) {
            try {
                if (this.f9785m == 5) {
                    throw new DeadObjectException();
                }
                if (!p()) {
                    throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
                }
                iInterface = this.f9782j;
                com.stepos.statsrpk.c.m(iInterface, "Client is connected but service is null");
            } catch (Throwable th) {
                throw th;
            }
        }
        return iInterface;
    }

    public abstract String m();

    public abstract String n();

    public boolean o() {
        return e() >= 211700000;
    }

    public final boolean p() {
        boolean z4;
        synchronized (this.f9778f) {
            z4 = this.f9785m == 4;
        }
        return z4;
    }

    public final boolean q() {
        boolean z4;
        synchronized (this.f9778f) {
            int i4 = this.f9785m;
            z4 = true;
            if (i4 != 2 && i4 != 3) {
                z4 = false;
            }
        }
        return z4;
    }

    public final void s(int i4, IInterface iInterface) {
        com.google.android.gms.common.api.internal.k kVar;
        if ((i4 == 4) != (iInterface != null)) {
            throw new IllegalArgumentException();
        }
        synchronized (this.f9778f) {
            try {
                this.f9785m = i4;
                this.f9782j = iInterface;
                if (i4 == 1) {
                    o oVar = this.f9784l;
                    if (oVar != null) {
                        u uVar = this.f9776d;
                        String str = (String) this.f9774b.f9659e;
                        com.stepos.statsrpk.c.l(str);
                        com.google.android.gms.common.api.internal.k kVar2 = this.f9774b;
                        String str2 = (String) kVar2.f9656b;
                        int i5 = kVar2.f9658d;
                        if (this.f9789q == null) {
                            this.f9775c.getClass();
                        }
                        uVar.a(str, str2, i5, oVar, this.f9774b.f9657c);
                        this.f9784l = null;
                    }
                } else if (i4 == 2 || i4 == 3) {
                    o oVar2 = this.f9784l;
                    if (oVar2 != null && (kVar = this.f9774b) != null) {
                        Log.e("GmsClient", "Calling connect() while still connected, missing disconnect() for " + ((String) kVar.f9659e) + " on " + ((String) kVar.f9656b));
                        u uVar2 = this.f9776d;
                        String str3 = (String) this.f9774b.f9659e;
                        com.stepos.statsrpk.c.l(str3);
                        com.google.android.gms.common.api.internal.k kVar3 = this.f9774b;
                        String str4 = (String) kVar3.f9656b;
                        int i6 = kVar3.f9658d;
                        if (this.f9789q == null) {
                            this.f9775c.getClass();
                        }
                        uVar2.a(str3, str4, i6, oVar2, this.f9774b.f9657c);
                        this.f9794v.incrementAndGet();
                    }
                    o oVar3 = new o(this, this.f9794v.get());
                    this.f9784l = oVar3;
                    String strN = n();
                    Object obj = u.f9848g;
                    com.google.android.gms.common.api.internal.k kVar4 = new com.google.android.gms.common.api.internal.k(strN, o());
                    this.f9774b = kVar4;
                    if (kVar4.f9657c && e() < 17895000) {
                        throw new IllegalStateException("Internal Error, the minimum apk version of this BaseGmsClient is too low to support dynamic lookup. Start service action: ".concat(String.valueOf((String) this.f9774b.f9659e)));
                    }
                    u uVar3 = this.f9776d;
                    String str5 = (String) this.f9774b.f9659e;
                    com.stepos.statsrpk.c.l(str5);
                    com.google.android.gms.common.api.internal.k kVar5 = this.f9774b;
                    String str6 = (String) kVar5.f9656b;
                    int i7 = kVar5.f9658d;
                    String name = this.f9789q;
                    if (name == null) {
                        name = this.f9775c.getClass().getName();
                    }
                    if (!uVar3.b(new r(str5, str6, i7, this.f9774b.f9657c), oVar3, name)) {
                        com.google.android.gms.common.api.internal.k kVar6 = this.f9774b;
                        Log.w("GmsClient", "unable to connect to service: " + ((String) kVar6.f9659e) + " on " + ((String) kVar6.f9656b));
                        int i8 = this.f9794v.get();
                        q qVar = new q(this, 16);
                        n nVar = this.f9777e;
                        nVar.sendMessage(nVar.obtainMessage(7, i8, -1, qVar));
                    }
                } else if (i4 == 4) {
                    com.stepos.statsrpk.c.l(iInterface);
                    System.currentTimeMillis();
                }
            } finally {
            }
        }
    }
}
