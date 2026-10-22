package com.google.android.gms.common.api.internal;

import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.UnsupportedApiCallException;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.api.internal.C1643i;
import com.google.android.gms.common.internal.C1668i;
import com.google.android.gms.common.internal.C1669j;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;
import s2.C5438a;

/* loaded from: classes2.dex */
public final class J implements d.a, d.b {

    /* renamed from: b, reason: collision with root package name */
    @NotOnlyInitialized
    public final a.f f19543b;

    /* renamed from: c, reason: collision with root package name */
    public final C1635b f19544c;

    /* renamed from: d, reason: collision with root package name */
    public final C1654u f19545d;

    /* renamed from: g, reason: collision with root package name */
    public final int f19548g;

    /* renamed from: h, reason: collision with root package name */
    public final zact f19549h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f19550i;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ C1640f f19554m;

    /* renamed from: a, reason: collision with root package name */
    public final Queue f19542a = new LinkedList();

    /* renamed from: e, reason: collision with root package name */
    public final Set f19546e = new HashSet();

    /* renamed from: f, reason: collision with root package name */
    public final Map f19547f = new HashMap();

    /* renamed from: j, reason: collision with root package name */
    public final List f19551j = new ArrayList();

    /* renamed from: k, reason: collision with root package name */
    public ConnectionResult f19552k = null;

    /* renamed from: l, reason: collision with root package name */
    public int f19553l = 0;

    public J(C1640f c1640f, com.google.android.gms.common.api.c cVar) {
        this.f19554m = c1640f;
        a.f fVarM = cVar.m(c1640f.f19618n.getLooper(), this);
        this.f19543b = fVarM;
        this.f19544c = cVar.i();
        this.f19545d = new C1654u();
        this.f19548g = cVar.l();
        if (fVarM.f()) {
            this.f19549h = cVar.n(c1640f.f19609e, c1640f.f19618n);
        } else {
            this.f19549h = null;
        }
    }

    public static /* bridge */ /* synthetic */ void A(J j10, L l10) {
        Feature[] featureArrG;
        if (j10.f19551j.remove(l10)) {
            j10.f19554m.f19618n.removeMessages(15, l10);
            j10.f19554m.f19618n.removeMessages(16, l10);
            Feature feature = l10.f19556b;
            ArrayList arrayList = new ArrayList(j10.f19542a.size());
            for (p0 p0Var : j10.f19542a) {
                if ((p0Var instanceof S) && (featureArrG = ((S) p0Var).g(j10)) != null && C5438a.b(featureArrG, feature)) {
                    arrayList.add(p0Var);
                }
            }
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                p0 p0Var2 = (p0) arrayList.get(i10);
                j10.f19542a.remove(p0Var2);
                p0Var2.b(new UnsupportedApiCallException(feature));
            }
        }
    }

    public static /* bridge */ /* synthetic */ void z(J j10, L l10) throws PackageManager.NameNotFoundException {
        if (j10.f19551j.contains(l10) && !j10.f19550i) {
            if (j10.f19543b.j()) {
                j10.g();
            } else {
                j10.C();
            }
        }
    }

    public final void B() {
        C1669j.d(this.f19554m.f19618n);
        this.f19552k = null;
    }

    public final void C() throws PackageManager.NameNotFoundException {
        C1669j.d(this.f19554m.f19618n);
        if (this.f19543b.j() || this.f19543b.b()) {
            return;
        }
        try {
            C1640f c1640f = this.f19554m;
            int iB = c1640f.f19611g.b(c1640f.f19609e, this.f19543b);
            if (iB == 0) {
                C1640f c1640f2 = this.f19554m;
                a.f fVar = this.f19543b;
                N n10 = new N(c1640f2, fVar, this.f19544c);
                if (fVar.f()) {
                    ((zact) C1669j.k(this.f19549h)).zae(n10);
                }
                try {
                    this.f19543b.d(n10);
                    return;
                } catch (SecurityException e10) {
                    F(new ConnectionResult(10), e10);
                    return;
                }
            }
            ConnectionResult connectionResult = new ConnectionResult(iB, null);
            Log.w("GoogleApiManager", "The service for " + this.f19543b.getClass().getName() + " is not available: " + connectionResult.toString());
            F(connectionResult, null);
        } catch (IllegalStateException e11) {
            F(new ConnectionResult(10), e11);
        }
    }

    public final void D(p0 p0Var) throws PackageManager.NameNotFoundException {
        C1669j.d(this.f19554m.f19618n);
        if (this.f19543b.j()) {
            if (m(p0Var)) {
                j();
                return;
            } else {
                this.f19542a.add(p0Var);
                return;
            }
        }
        this.f19542a.add(p0Var);
        ConnectionResult connectionResult = this.f19552k;
        if (connectionResult == null || !connectionResult.hasResolution()) {
            C();
        } else {
            F(this.f19552k, null);
        }
    }

    public final void E() {
        this.f19553l++;
    }

    public final void F(ConnectionResult connectionResult, Exception exc) {
        C1669j.d(this.f19554m.f19618n);
        zact zactVar = this.f19549h;
        if (zactVar != null) {
            zactVar.zaf();
        }
        B();
        this.f19554m.f19611g.c();
        d(connectionResult);
        if ((this.f19543b instanceof com.google.android.gms.common.internal.service.d) && connectionResult.getErrorCode() != 24) {
            this.f19554m.f19606b = true;
            C1640f c1640f = this.f19554m;
            c1640f.f19618n.sendMessageDelayed(c1640f.f19618n.obtainMessage(19), 300000L);
        }
        if (connectionResult.getErrorCode() == 4) {
            e(C1640f.f19602q);
            return;
        }
        if (this.f19542a.isEmpty()) {
            this.f19552k = connectionResult;
            return;
        }
        if (exc != null) {
            C1669j.d(this.f19554m.f19618n);
            f(null, exc, false);
            return;
        }
        if (!this.f19554m.f19619o) {
            e(C1640f.f(this.f19544c, connectionResult));
            return;
        }
        f(C1640f.f(this.f19544c, connectionResult), null, true);
        if (this.f19542a.isEmpty() || n(connectionResult) || this.f19554m.e(connectionResult, this.f19548g)) {
            return;
        }
        if (connectionResult.getErrorCode() == 18) {
            this.f19550i = true;
        }
        if (!this.f19550i) {
            e(C1640f.f(this.f19544c, connectionResult));
            return;
        }
        C1640f c1640f2 = this.f19554m;
        c1640f2.f19618n.sendMessageDelayed(Message.obtain(c1640f2.f19618n, 9, this.f19544c), 5000L);
    }

    public final void G(ConnectionResult connectionResult) {
        C1669j.d(this.f19554m.f19618n);
        a.f fVar = this.f19543b;
        fVar.a("onSignInFailed for " + fVar.getClass().getName() + " with " + String.valueOf(connectionResult));
        F(connectionResult, null);
    }

    public final void H(q0 q0Var) {
        C1669j.d(this.f19554m.f19618n);
        this.f19546e.add(q0Var);
    }

    public final void I() throws PackageManager.NameNotFoundException {
        C1669j.d(this.f19554m.f19618n);
        if (this.f19550i) {
            C();
        }
    }

    public final void J() throws PackageManager.NameNotFoundException {
        C1669j.d(this.f19554m.f19618n);
        e(C1640f.f19601p);
        this.f19545d.d();
        for (C1643i.a aVar : (C1643i.a[]) this.f19547f.keySet().toArray(new C1643i.a[0])) {
            D(new o0(aVar, new D2.j()));
        }
        d(new ConnectionResult(4));
        if (this.f19543b.j()) {
            this.f19543b.i(new I(this));
        }
    }

    public final void K() {
        C1669j.d(this.f19554m.f19618n);
        if (this.f19550i) {
            l();
            C1640f c1640f = this.f19554m;
            e(c1640f.f19610f.g(c1640f.f19609e) == 18 ? new Status(21, "Connection timed out waiting for Google Play services update to complete.") : new Status(22, "API failed to connect while resuming due to an unknown error."));
            this.f19543b.a("Timing out connection while resuming.");
        }
    }

    public final boolean N() {
        return this.f19543b.j();
    }

    public final boolean a() {
        return this.f19543b.f();
    }

    @ResultIgnorabilityUnspecified
    public final boolean b() {
        return o(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Feature c(Feature[] featureArr) {
        if (featureArr != null && featureArr.length != 0) {
            Feature[] featureArrM = this.f19543b.m();
            if (featureArrM == null) {
                featureArrM = new Feature[0];
            }
            androidx.collection.a aVar = new androidx.collection.a(featureArrM.length);
            for (Feature feature : featureArrM) {
                aVar.put(feature.getName(), Long.valueOf(feature.getVersion()));
            }
            for (Feature feature2 : featureArr) {
                Long l10 = (Long) aVar.get(feature2.getName());
                if (l10 == null || l10.longValue() < feature2.getVersion()) {
                    return feature2;
                }
            }
        }
        return null;
    }

    public final void d(ConnectionResult connectionResult) {
        Iterator it = this.f19546e.iterator();
        while (it.hasNext()) {
            ((q0) it.next()).b(this.f19544c, connectionResult, C1668i.a(connectionResult, ConnectionResult.RESULT_SUCCESS) ? this.f19543b.c() : null);
        }
        this.f19546e.clear();
    }

    public final void e(Status status) {
        C1669j.d(this.f19554m.f19618n);
        f(status, null, false);
    }

    public final void f(Status status, Exception exc, boolean z10) {
        C1669j.d(this.f19554m.f19618n);
        if ((status == null) == (exc == null)) {
            throw new IllegalArgumentException("Status XOR exception should be null");
        }
        Iterator it = this.f19542a.iterator();
        while (it.hasNext()) {
            p0 p0Var = (p0) it.next();
            if (!z10 || p0Var.f19661a == 2) {
                if (status != null) {
                    p0Var.a(status);
                } else {
                    p0Var.b(exc);
                }
                it.remove();
            }
        }
    }

    public final void g() {
        ArrayList arrayList = new ArrayList(this.f19542a);
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            p0 p0Var = (p0) arrayList.get(i10);
            if (!this.f19543b.j()) {
                return;
            }
            if (m(p0Var)) {
                this.f19542a.remove(p0Var);
            }
        }
    }

    public final void h() {
        B();
        d(ConnectionResult.RESULT_SUCCESS);
        l();
        Iterator it = this.f19547f.values().iterator();
        while (it.hasNext()) {
            Z z10 = (Z) it.next();
            if (c(z10.f19586a.c()) != null) {
                it.remove();
            } else {
                try {
                    z10.f19586a.d(this.f19543b, new D2.j<>());
                } catch (DeadObjectException unused) {
                    onConnectionSuspended(3);
                    this.f19543b.a("DeadObjectException thrown while calling register listener method.");
                } catch (RemoteException unused2) {
                    it.remove();
                }
            }
        }
        g();
        j();
    }

    public final void i(int i10) {
        B();
        this.f19550i = true;
        this.f19545d.c(i10, this.f19543b.n());
        C1635b c1635b = this.f19544c;
        C1640f c1640f = this.f19554m;
        c1640f.f19618n.sendMessageDelayed(Message.obtain(c1640f.f19618n, 9, c1635b), 5000L);
        C1635b c1635b2 = this.f19544c;
        C1640f c1640f2 = this.f19554m;
        c1640f2.f19618n.sendMessageDelayed(Message.obtain(c1640f2.f19618n, 11, c1635b2), 120000L);
        this.f19554m.f19611g.c();
        Iterator it = this.f19547f.values().iterator();
        while (it.hasNext()) {
            ((Z) it.next()).f19588c.run();
        }
    }

    public final void j() {
        this.f19554m.f19618n.removeMessages(12, this.f19544c);
        C1635b c1635b = this.f19544c;
        C1640f c1640f = this.f19554m;
        c1640f.f19618n.sendMessageDelayed(c1640f.f19618n.obtainMessage(12, c1635b), this.f19554m.f19605a);
    }

    public final void k(p0 p0Var) {
        p0Var.d(this.f19545d, a());
        try {
            p0Var.c(this);
        } catch (DeadObjectException unused) {
            onConnectionSuspended(1);
            this.f19543b.a("DeadObjectException thrown while running ApiCallRunner.");
        }
    }

    public final void l() {
        if (this.f19550i) {
            C1640f c1640f = this.f19554m;
            c1640f.f19618n.removeMessages(11, this.f19544c);
            C1640f c1640f2 = this.f19554m;
            c1640f2.f19618n.removeMessages(9, this.f19544c);
            this.f19550i = false;
        }
    }

    public final boolean m(p0 p0Var) throws Resources.NotFoundException {
        if (!(p0Var instanceof S)) {
            k(p0Var);
            return true;
        }
        S s10 = (S) p0Var;
        Feature featureC = c(s10.g(this));
        if (featureC == null) {
            k(p0Var);
            return true;
        }
        Log.w("GoogleApiManager", this.f19543b.getClass().getName() + " could not execute call because it requires feature (" + featureC.getName() + ", " + featureC.getVersion() + ").");
        if (!this.f19554m.f19619o || !s10.f(this)) {
            s10.b(new UnsupportedApiCallException(featureC));
            return true;
        }
        L l10 = new L(this.f19544c, featureC, null);
        int iIndexOf = this.f19551j.indexOf(l10);
        if (iIndexOf >= 0) {
            L l11 = (L) this.f19551j.get(iIndexOf);
            this.f19554m.f19618n.removeMessages(15, l11);
            C1640f c1640f = this.f19554m;
            c1640f.f19618n.sendMessageDelayed(Message.obtain(c1640f.f19618n, 15, l11), 5000L);
            return false;
        }
        this.f19551j.add(l10);
        C1640f c1640f2 = this.f19554m;
        c1640f2.f19618n.sendMessageDelayed(Message.obtain(c1640f2.f19618n, 15, l10), 5000L);
        C1640f c1640f3 = this.f19554m;
        c1640f3.f19618n.sendMessageDelayed(Message.obtain(c1640f3.f19618n, 16, l10), 120000L);
        ConnectionResult connectionResult = new ConnectionResult(2, null);
        if (n(connectionResult)) {
            return false;
        }
        this.f19554m.e(connectionResult, this.f19548g);
        return false;
    }

    public final boolean n(ConnectionResult connectionResult) {
        synchronized (C1640f.f19603r) {
            try {
                C1640f c1640f = this.f19554m;
                if (c1640f.f19615k == null || !c1640f.f19616l.contains(this.f19544c)) {
                    return false;
                }
                this.f19554m.f19615k.s(connectionResult, this.f19548g);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean o(boolean z10) {
        C1669j.d(this.f19554m.f19618n);
        if (!this.f19543b.j() || !this.f19547f.isEmpty()) {
            return false;
        }
        if (!this.f19545d.e()) {
            this.f19543b.a("Timing out service connection.");
            return true;
        }
        if (!z10) {
            return false;
        }
        j();
        return false;
    }

    @Override // com.google.android.gms.common.api.internal.InterfaceC1639e
    public final void onConnected(Bundle bundle) {
        if (Looper.myLooper() == this.f19554m.f19618n.getLooper()) {
            h();
        } else {
            this.f19554m.f19618n.post(new F(this));
        }
    }

    @Override // com.google.android.gms.common.api.internal.InterfaceC1646l
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        F(connectionResult, null);
    }

    @Override // com.google.android.gms.common.api.internal.InterfaceC1639e
    public final void onConnectionSuspended(int i10) {
        if (Looper.myLooper() == this.f19554m.f19618n.getLooper()) {
            i(i10);
        } else {
            this.f19554m.f19618n.post(new G(this, i10));
        }
    }

    public final int p() {
        return this.f19548g;
    }

    public final int q() {
        return this.f19553l;
    }

    public final ConnectionResult r() {
        C1669j.d(this.f19554m.f19618n);
        return this.f19552k;
    }

    public final a.f t() {
        return this.f19543b;
    }

    public final Map v() {
        return this.f19547f;
    }
}
