package com.google.android.gms.common.api.internal;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.SparseIntArray;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzj;
import com.stepos.alphame.bluetooth.VehicleBluetoothManager;
import g1.HandlerC0575c;
import h.RunnableC0583a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.WeakHashMap;
import l1.C0758c;

/* loaded from: classes.dex */
public final class q implements Z0.g, Z0.h {

    /* renamed from: b, reason: collision with root package name */
    public final com.google.android.gms.common.internal.e f9666b;

    /* renamed from: c, reason: collision with root package name */
    public final C0403a f9667c;

    /* renamed from: d, reason: collision with root package name */
    public final m3.i f9668d;

    /* renamed from: g, reason: collision with root package name */
    public final int f9671g;

    /* renamed from: h, reason: collision with root package name */
    public final zact f9672h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f9673i;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ C0407e f9676l;

    /* renamed from: a, reason: collision with root package name */
    public final LinkedList f9665a = new LinkedList();

    /* renamed from: e, reason: collision with root package name */
    public final HashSet f9669e = new HashSet();

    /* renamed from: f, reason: collision with root package name */
    public final HashMap f9670f = new HashMap();

    /* renamed from: j, reason: collision with root package name */
    public final ArrayList f9674j = new ArrayList();

    /* renamed from: k, reason: collision with root package name */
    public ConnectionResult f9675k = null;

    public q(C0407e c0407e, Z0.f fVar) {
        this.f9676l = c0407e;
        Looper looper = c0407e.f9653m.getLooper();
        com.google.android.gms.common.internal.d dVarB = fVar.a().b();
        Z0.a aVar = (Z0.a) fVar.f2152c.f2365c;
        com.stepos.statsrpk.c.l(aVar);
        com.google.android.gms.common.internal.e eVarA = aVar.a(fVar.f2150a, looper, dVarB, fVar.f2153d, this, this);
        String str = fVar.f2151b;
        if (str != null) {
            eVarA.f9790r = str;
        }
        this.f9666b = eVarA;
        this.f9667c = fVar.f2154e;
        m3.i iVar = new m3.i();
        iVar.f13620a = Collections.synchronizedMap(new WeakHashMap());
        iVar.f13621b = Collections.synchronizedMap(new WeakHashMap());
        this.f9668d = iVar;
        this.f9671g = fVar.f2155f;
        if (eVarA.g()) {
            this.f9672h = new zact(c0407e.f9645e, c0407e.f9653m, fVar.a().b());
        } else {
            this.f9672h = null;
        }
    }

    public final void a(ConnectionResult connectionResult) {
        HashSet hashSet = this.f9669e;
        Iterator it = hashSet.iterator();
        if (!it.hasNext()) {
            hashSet.clear();
            return;
        }
        B0.g.y(it.next());
        if (com.airbnb.lottie.h.m(connectionResult, ConnectionResult.f9596e)) {
            com.google.android.gms.common.internal.e eVar = this.f9666b;
            if (!eVar.p() || eVar.f9774b == null) {
                throw new RuntimeException("Failed to connect when checking package");
            }
        }
        throw null;
    }

    public final void b(Status status) {
        com.stepos.statsrpk.c.k(this.f9676l.f9653m);
        c(status, null, false);
    }

    public final void c(Status status, RuntimeException runtimeException, boolean z4) {
        com.stepos.statsrpk.c.k(this.f9676l.f9653m);
        if ((status == null) == (runtimeException == null)) {
            throw new IllegalArgumentException("Status XOR exception should be null");
        }
        Iterator it = this.f9665a.iterator();
        while (it.hasNext()) {
            v vVar = (v) it.next();
            if (!z4 || vVar.f9687a == 2) {
                if (status != null) {
                    vVar.c(status);
                } else {
                    vVar.d(runtimeException);
                }
                it.remove();
            }
        }
    }

    public final void d() {
        LinkedList linkedList = this.f9665a;
        ArrayList arrayList = new ArrayList(linkedList);
        int size = arrayList.size();
        for (int i4 = 0; i4 < size; i4++) {
            v vVar = (v) arrayList.get(i4);
            if (!this.f9666b.p()) {
                return;
            }
            if (h(vVar)) {
                linkedList.remove(vVar);
            }
        }
    }

    public final void e() {
        C0407e c0407e = this.f9676l;
        com.stepos.statsrpk.c.k(c0407e.f9653m);
        this.f9675k = null;
        a(ConnectionResult.f9596e);
        if (this.f9673i) {
            HandlerC0575c handlerC0575c = c0407e.f9653m;
            C0403a c0403a = this.f9667c;
            handlerC0575c.removeMessages(11, c0403a);
            c0407e.f9653m.removeMessages(9, c0403a);
            this.f9673i = false;
        }
        Iterator it = this.f9670f.values().iterator();
        if (it.hasNext()) {
            B0.g.y(it.next());
            throw null;
        }
        d();
        g();
    }

    public final void f(int i4) {
        com.stepos.statsrpk.c.k(this.f9676l.f9653m);
        this.f9675k = null;
        this.f9673i = true;
        m3.i iVar = this.f9668d;
        String str = this.f9666b.f9773a;
        iVar.getClass();
        StringBuilder sb = new StringBuilder("The connection to Google Play services was lost");
        if (i4 == 1) {
            sb.append(" due to service disconnection.");
        } else if (i4 == 3) {
            sb.append(" due to dead object exception.");
        }
        if (str != null) {
            sb.append(" Last reason for disconnect: ");
            sb.append(str);
        }
        iVar.e(true, new Status(20, sb.toString()));
        HandlerC0575c handlerC0575c = this.f9676l.f9653m;
        Message messageObtain = Message.obtain(handlerC0575c, 9, this.f9667c);
        this.f9676l.getClass();
        handlerC0575c.sendMessageDelayed(messageObtain, 5000L);
        HandlerC0575c handlerC0575c2 = this.f9676l.f9653m;
        Message messageObtain2 = Message.obtain(handlerC0575c2, 11, this.f9667c);
        this.f9676l.getClass();
        handlerC0575c2.sendMessageDelayed(messageObtain2, 120000L);
        ((SparseIntArray) this.f9676l.f9647g.f155b).clear();
        Iterator it = this.f9670f.values().iterator();
        if (it.hasNext()) {
            B0.g.y(it.next());
            throw null;
        }
    }

    public final void g() {
        C0407e c0407e = this.f9676l;
        HandlerC0575c handlerC0575c = c0407e.f9653m;
        C0403a c0403a = this.f9667c;
        handlerC0575c.removeMessages(12, c0403a);
        HandlerC0575c handlerC0575c2 = c0407e.f9653m;
        handlerC0575c2.sendMessageDelayed(handlerC0575c2.obtainMessage(12, c0403a), c0407e.f9641a);
    }

    public final boolean h(v vVar) throws Resources.NotFoundException {
        Feature feature;
        if (!(vVar instanceof v)) {
            com.google.android.gms.common.internal.e eVar = this.f9666b;
            vVar.f(this.f9668d, eVar.g());
            try {
                vVar.e(this);
            } catch (DeadObjectException unused) {
                onConnectionSuspended(1);
                eVar.c("DeadObjectException thrown while running ApiCallRunner.");
            }
            return true;
        }
        Feature[] featureArrB = vVar.b(this);
        if (featureArrB == null || featureArrB.length == 0) {
            feature = null;
        } else {
            zzj zzjVar = this.f9666b.f9793u;
            Feature[] featureArr = zzjVar == null ? null : zzjVar.f9873b;
            if (featureArr == null) {
                featureArr = new Feature[0];
            }
            q.f fVar = new q.f(featureArr.length);
            for (Feature feature2 : featureArr) {
                fVar.put(feature2.f9601a, Long.valueOf(feature2.N()));
            }
            int length = featureArrB.length;
            for (int i4 = 0; i4 < length; i4++) {
                feature = featureArrB[i4];
                Long l4 = (Long) fVar.get(feature.f9601a);
                if (l4 == null || l4.longValue() < feature.N()) {
                    break;
                }
            }
            feature = null;
        }
        if (feature == null) {
            com.google.android.gms.common.internal.e eVar2 = this.f9666b;
            vVar.f(this.f9668d, eVar2.g());
            try {
                vVar.e(this);
            } catch (DeadObjectException unused2) {
                onConnectionSuspended(1);
                eVar2.c("DeadObjectException thrown while running ApiCallRunner.");
            }
            return true;
        }
        Log.w("GoogleApiManager", this.f9666b.getClass().getName() + " could not execute call because it requires feature (" + feature.f9601a + ", " + feature.N() + ").");
        if (!this.f9676l.f9654n || !vVar.a(this)) {
            vVar.d(new Z0.k(feature));
            return true;
        }
        r rVar = new r(this.f9667c, feature);
        int iIndexOf = this.f9674j.indexOf(rVar);
        if (iIndexOf >= 0) {
            r rVar2 = (r) this.f9674j.get(iIndexOf);
            this.f9676l.f9653m.removeMessages(15, rVar2);
            HandlerC0575c handlerC0575c = this.f9676l.f9653m;
            Message messageObtain = Message.obtain(handlerC0575c, 15, rVar2);
            this.f9676l.getClass();
            handlerC0575c.sendMessageDelayed(messageObtain, 5000L);
        } else {
            this.f9674j.add(rVar);
            HandlerC0575c handlerC0575c2 = this.f9676l.f9653m;
            Message messageObtain2 = Message.obtain(handlerC0575c2, 15, rVar);
            this.f9676l.getClass();
            handlerC0575c2.sendMessageDelayed(messageObtain2, 5000L);
            HandlerC0575c handlerC0575c3 = this.f9676l.f9653m;
            Message messageObtain3 = Message.obtain(handlerC0575c3, 16, rVar);
            this.f9676l.getClass();
            handlerC0575c3.sendMessageDelayed(messageObtain3, 120000L);
            ConnectionResult connectionResult = new ConnectionResult(2, null);
            if (!i(connectionResult)) {
                this.f9676l.b(connectionResult, this.f9671g);
            }
        }
        return false;
    }

    public final boolean i(ConnectionResult connectionResult) {
        synchronized (C0407e.f9639q) {
            this.f9676l.getClass();
        }
        return false;
    }

    public final void j() {
        C0407e c0407e = this.f9676l;
        com.stepos.statsrpk.c.k(c0407e.f9653m);
        com.google.android.gms.common.internal.e eVar = this.f9666b;
        if (eVar.p() || eVar.q()) {
            return;
        }
        try {
            int iC = c0407e.f9647g.c(c0407e.f9645e, eVar);
            if (iC != 0) {
                ConnectionResult connectionResult = new ConnectionResult(iC, null);
                Log.w("GoogleApiManager", "The service for " + eVar.getClass().getName() + " is not available: " + connectionResult.toString());
                l(connectionResult, null);
                return;
            }
            s sVar = new s();
            sVar.f9684f = c0407e;
            sVar.f9682d = null;
            sVar.f9683e = null;
            sVar.f9679a = false;
            sVar.f9680b = eVar;
            sVar.f9681c = this.f9667c;
            if (eVar.g()) {
                zact zactVar = this.f9672h;
                com.stepos.statsrpk.c.l(zactVar);
                zactVar.zae(sVar);
            }
            try {
                eVar.f9781i = sVar;
                eVar.s(2, null);
            } catch (SecurityException e4) {
                l(new ConnectionResult(10), e4);
            }
        } catch (IllegalStateException e5) {
            l(new ConnectionResult(10), e5);
        }
    }

    public final void k(v vVar) {
        com.stepos.statsrpk.c.k(this.f9676l.f9653m);
        boolean zP = this.f9666b.p();
        LinkedList linkedList = this.f9665a;
        if (zP) {
            if (h(vVar)) {
                g();
                return;
            } else {
                linkedList.add(vVar);
                return;
            }
        }
        linkedList.add(vVar);
        ConnectionResult connectionResult = this.f9675k;
        if (connectionResult == null || connectionResult.f9598b == 0 || connectionResult.f9599c == null) {
            j();
        } else {
            l(connectionResult, null);
        }
    }

    public final void l(ConnectionResult connectionResult, RuntimeException runtimeException) {
        com.stepos.statsrpk.c.k(this.f9676l.f9653m);
        zact zactVar = this.f9672h;
        if (zactVar != null) {
            zactVar.zaf();
        }
        com.stepos.statsrpk.c.k(this.f9676l.f9653m);
        this.f9675k = null;
        ((SparseIntArray) this.f9676l.f9647g.f155b).clear();
        a(connectionResult);
        if ((this.f9666b instanceof com.google.android.gms.common.internal.service.c) && connectionResult.f9598b != 24) {
            C0407e c0407e = this.f9676l;
            c0407e.f9642b = true;
            HandlerC0575c handlerC0575c = c0407e.f9653m;
            handlerC0575c.sendMessageDelayed(handlerC0575c.obtainMessage(19), VehicleBluetoothManager.FAIL_RETRY_TIMEOUT);
        }
        if (connectionResult.f9598b == 4) {
            b(C0407e.f9638p);
            return;
        }
        if (this.f9665a.isEmpty()) {
            this.f9675k = connectionResult;
            return;
        }
        if (runtimeException != null) {
            com.stepos.statsrpk.c.k(this.f9676l.f9653m);
            c(null, runtimeException, false);
            return;
        }
        if (!this.f9676l.f9654n) {
            b(C0407e.c(this.f9667c, connectionResult));
            return;
        }
        c(C0407e.c(this.f9667c, connectionResult), null, true);
        if (this.f9665a.isEmpty() || i(connectionResult) || this.f9676l.b(connectionResult, this.f9671g)) {
            return;
        }
        if (connectionResult.f9598b == 18) {
            this.f9673i = true;
        }
        if (!this.f9673i) {
            b(C0407e.c(this.f9667c, connectionResult));
            return;
        }
        HandlerC0575c handlerC0575c2 = this.f9676l.f9653m;
        Message messageObtain = Message.obtain(handlerC0575c2, 9, this.f9667c);
        this.f9676l.getClass();
        handlerC0575c2.sendMessageDelayed(messageObtain, 5000L);
    }

    public final void m() {
        com.stepos.statsrpk.c.k(this.f9676l.f9653m);
        Status status = C0407e.f9637o;
        b(status);
        m3.i iVar = this.f9668d;
        iVar.getClass();
        int i4 = 0;
        iVar.e(false, status);
        for (h hVar : (h[]) this.f9670f.keySet().toArray(new h[0])) {
            k(new B(hVar, new C0758c()));
        }
        a(new ConnectionResult(4));
        com.google.android.gms.common.internal.e eVar = this.f9666b;
        if (eVar.p()) {
            p pVar = new p(i4, this);
            eVar.getClass();
            ((q) pVar.f9664b).f9676l.f9653m.post(new RunnableC0583a(11, pVar));
        }
    }

    @Override // com.google.android.gms.common.api.internal.InterfaceC0406d
    public final void onConnected(Bundle bundle) {
        Looper looperMyLooper = Looper.myLooper();
        C0407e c0407e = this.f9676l;
        if (looperMyLooper == c0407e.f9653m.getLooper()) {
            e();
        } else {
            c0407e.f9653m.post(new RunnableC0583a(10, this));
        }
    }

    @Override // com.google.android.gms.common.api.internal.j
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        l(connectionResult, null);
    }

    @Override // com.google.android.gms.common.api.internal.InterfaceC0406d
    public final void onConnectionSuspended(int i4) {
        Looper looperMyLooper = Looper.myLooper();
        C0407e c0407e = this.f9676l;
        if (looperMyLooper == c0407e.f9653m.getLooper()) {
            f(i4);
        } else {
            c0407e.f9653m.post(new A0.e(i4, 1, this));
        }
    }
}
