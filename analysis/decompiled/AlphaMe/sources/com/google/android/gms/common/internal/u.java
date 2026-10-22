package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.HandlerThread;
import android.os.Looper;
import com.stepos.alphame.bluetooth.VehicleBluetoothManager;
import d1.C0535a;
import g1.HandlerC0575c;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public final class u {

    /* renamed from: g, reason: collision with root package name */
    public static final Object f9848g = new Object();

    /* renamed from: h, reason: collision with root package name */
    public static u f9849h;

    /* renamed from: i, reason: collision with root package name */
    public static HandlerThread f9850i;

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f9851a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final Context f9852b;

    /* renamed from: c, reason: collision with root package name */
    public volatile HandlerC0575c f9853c;

    /* renamed from: d, reason: collision with root package name */
    public final C0535a f9854d;

    /* renamed from: e, reason: collision with root package name */
    public final long f9855e;

    /* renamed from: f, reason: collision with root package name */
    public final long f9856f;

    public u(Context context, Looper looper) {
        t tVar = new t(this);
        this.f9852b = context.getApplicationContext();
        this.f9853c = new HandlerC0575c(looper, tVar, 1);
        if (C0535a.f12414c == null) {
            synchronized (C0535a.f12413b) {
                try {
                    if (C0535a.f12414c == null) {
                        C0535a c0535a = new C0535a();
                        c0535a.f12415a = new ConcurrentHashMap();
                        C0535a.f12414c = c0535a;
                    }
                } finally {
                }
            }
        }
        C0535a c0535a2 = C0535a.f12414c;
        com.stepos.statsrpk.c.l(c0535a2);
        this.f9854d = c0535a2;
        this.f9855e = 5000L;
        this.f9856f = VehicleBluetoothManager.FAIL_RETRY_TIMEOUT;
    }

    public final void a(String str, String str2, int i4, o oVar, boolean z4) {
        r rVar = new r(str, str2, i4, z4);
        synchronized (this.f9851a) {
            try {
                s sVar = (s) this.f9851a.get(rVar);
                if (sVar == null) {
                    throw new IllegalStateException("Nonexistent connection status for service config: ".concat(rVar.toString()));
                }
                if (!sVar.f9837a.containsKey(oVar)) {
                    throw new IllegalStateException("Trying to unbind a GmsServiceConnection  that was not bound before.  config=".concat(rVar.toString()));
                }
                sVar.f9837a.remove(oVar);
                if (sVar.f9837a.isEmpty()) {
                    this.f9853c.sendMessageDelayed(this.f9853c.obtainMessage(0, rVar), this.f9855e);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean b(r rVar, o oVar, String str) {
        boolean z4;
        synchronized (this.f9851a) {
            try {
                s sVar = (s) this.f9851a.get(rVar);
                if (sVar == null) {
                    sVar = new s(this, rVar);
                    sVar.f9837a.put(oVar, oVar);
                    sVar.a(str);
                    this.f9851a.put(rVar, sVar);
                } else {
                    this.f9853c.removeMessages(0, rVar);
                    if (sVar.f9837a.containsKey(oVar)) {
                        throw new IllegalStateException("Trying to bind a GmsServiceConnection that was already connected before.  config=".concat(rVar.toString()));
                    }
                    sVar.f9837a.put(oVar, oVar);
                    int i4 = sVar.f9838b;
                    if (i4 == 1) {
                        oVar.onServiceConnected(sVar.f9842f, sVar.f9840d);
                    } else if (i4 == 2) {
                        sVar.a(str);
                    }
                }
                z4 = sVar.f9839c;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z4;
    }
}
