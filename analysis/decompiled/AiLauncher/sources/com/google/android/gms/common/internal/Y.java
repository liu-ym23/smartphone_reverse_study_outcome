package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Looper;
import java.util.HashMap;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class Y extends AbstractC1665f {

    /* renamed from: f, reason: collision with root package name */
    public final HashMap f19762f = new HashMap();

    /* renamed from: g, reason: collision with root package name */
    public final Context f19763g;

    /* renamed from: h, reason: collision with root package name */
    public volatile Handler f19764h;

    /* renamed from: i, reason: collision with root package name */
    public final X f19765i;

    /* renamed from: j, reason: collision with root package name */
    public final com.google.android.gms.common.stats.a f19766j;

    /* renamed from: k, reason: collision with root package name */
    public final long f19767k;

    /* renamed from: l, reason: collision with root package name */
    public final long f19768l;

    /* renamed from: m, reason: collision with root package name */
    public volatile Executor f19769m;

    public Y(Context context, Looper looper, Executor executor) {
        X x10 = new X(this, null);
        this.f19765i = x10;
        this.f19763g = context.getApplicationContext();
        this.f19764h = new x2.c(looper, x10);
        this.f19766j = com.google.android.gms.common.stats.a.a();
        this.f19767k = 5000L;
        this.f19768l = 300000L;
        this.f19769m = executor;
    }

    @Override // com.google.android.gms.common.internal.AbstractC1665f
    public final void d(U u10, ServiceConnection serviceConnection, String str) {
        C1669j.l(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.f19762f) {
            try {
                V v10 = (V) this.f19762f.get(u10);
                if (v10 == null) {
                    throw new IllegalStateException("Nonexistent connection status for service config: " + u10.toString());
                }
                if (!v10.h(serviceConnection)) {
                    throw new IllegalStateException("Trying to unbind a GmsServiceConnection  that was not bound before.  config=" + u10.toString());
                }
                v10.f(serviceConnection, str);
                if (v10.i()) {
                    this.f19764h.sendMessageDelayed(this.f19764h.obtainMessage(0, u10), this.f19767k);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.common.internal.AbstractC1665f
    public final boolean f(U u10, ServiceConnection serviceConnection, String str, Executor executor) {
        boolean zJ;
        C1669j.l(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.f19762f) {
            try {
                V v10 = (V) this.f19762f.get(u10);
                if (executor == null) {
                    executor = this.f19769m;
                }
                if (v10 == null) {
                    v10 = new V(this, u10);
                    v10.d(serviceConnection, serviceConnection, str);
                    v10.e(str, executor);
                    this.f19762f.put(u10, v10);
                } else {
                    this.f19764h.removeMessages(0, u10);
                    if (v10.h(serviceConnection)) {
                        throw new IllegalStateException("Trying to bind a GmsServiceConnection that was already connected before.  config=" + u10.toString());
                    }
                    v10.d(serviceConnection, serviceConnection, str);
                    int iA = v10.a();
                    if (iA == 1) {
                        serviceConnection.onServiceConnected(v10.b(), v10.c());
                    } else if (iA == 2) {
                        v10.e(str, executor);
                    }
                }
                zJ = v10.j();
            } catch (Throwable th) {
                throw th;
            }
        }
        return zJ;
    }
}
