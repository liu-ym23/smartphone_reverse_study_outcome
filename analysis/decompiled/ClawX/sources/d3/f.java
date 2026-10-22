package d3;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.util.Log;
import java.util.ArrayList;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    public IInterface f1801a = null;

    /* renamed from: b, reason: collision with root package name */
    public final Object f1802b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public volatile CompletableFuture f1803c = new CompletableFuture();
    public final ArrayList d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    public final c f1804e = new c(this);

    /* renamed from: f, reason: collision with root package name */
    public final d f1805f = new d(this);

    public abstract IInterface a(IBinder iBinder);

    public e b(Context context, ServiceConnection serviceConnection) {
        if (f()) {
            return null;
        }
        Intent intentD = d();
        int i8 = Build.VERSION.SDK_INT >= 34 ? 513 : 1;
        Log.d(e(), "bindService: " + intentD);
        e eVar = new e(this, serviceConnection);
        if (context.bindService(intentD, eVar, i8)) {
            return eVar;
        }
        return null;
    }

    public final synchronized IInterface c(Context context, int i8) {
        CompletableFuture completableFuture;
        try {
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                throw new IllegalStateException("fetchRemote can not be called in main thread");
            }
            synchronized (this.f1802b) {
                if (f()) {
                    return this.f1801a;
                }
                if (this.f1801a != null) {
                    this.f1801a = null;
                }
                if (this.f1803c.isDone()) {
                    this.f1803c = new CompletableFuture();
                    Log.d(e(), "reset future");
                }
                long jCurrentTimeMillis = System.currentTimeMillis();
                Log.d(e(), "bindService start");
                Context applicationContext = context.getApplicationContext();
                try {
                    if (b(applicationContext, this.f1805f) == null) {
                        Log.w(e(), "bindService failed");
                        return this.f1801a;
                    }
                    try {
                        try {
                            IInterface iInterface = (IInterface) this.f1803c.get(i8, TimeUnit.SECONDS);
                            g(context, iInterface);
                            return iInterface;
                        } catch (TimeoutException unused) {
                            Log.e(e(), "Timeout waiting for service binding: " + this);
                            if (!f()) {
                                try {
                                    applicationContext.unbindService(this.f1805f);
                                } catch (Exception unused2) {
                                }
                            }
                            completableFuture = new CompletableFuture();
                            this.f1803c = completableFuture;
                            long jCurrentTimeMillis2 = System.currentTimeMillis();
                            Log.d(e(), "bindService time: " + (jCurrentTimeMillis2 - jCurrentTimeMillis));
                            return this.f1801a;
                        }
                    } catch (CancellationException e9) {
                        Log.e(e(), "canceled: " + e9.getMessage());
                        completableFuture = new CompletableFuture();
                        this.f1803c = completableFuture;
                        long jCurrentTimeMillis22 = System.currentTimeMillis();
                        Log.d(e(), "bindService time: " + (jCurrentTimeMillis22 - jCurrentTimeMillis));
                        return this.f1801a;
                    } catch (Exception e10) {
                        Log.e(e(), "error: " + e10.getMessage());
                        completableFuture = new CompletableFuture();
                        this.f1803c = completableFuture;
                        long jCurrentTimeMillis222 = System.currentTimeMillis();
                        Log.d(e(), "bindService time: " + (jCurrentTimeMillis222 - jCurrentTimeMillis));
                        return this.f1801a;
                    }
                } finally {
                    this.f1803c = new CompletableFuture();
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public abstract Intent d();

    public abstract String e();

    public final boolean f() {
        synchronized (this.f1802b) {
            try {
                IInterface iInterface = this.f1801a;
                if (iInterface == null) {
                    return false;
                }
                if (!iInterface.asBinder().isBinderAlive()) {
                    return false;
                }
                return this.f1801a.asBinder().pingBinder();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void h(Context context) {
        IInterface iInterface = this.f1801a;
        if (iInterface == null) {
            return;
        }
        try {
            iInterface.asBinder().unlinkToDeath(this.f1804e, 0);
        } catch (Exception unused) {
        }
        synchronized (this.f1802b) {
            this.f1801a = null;
        }
        if (context != null) {
            try {
                context.unbindService(this.f1805f);
            } catch (Exception unused2) {
            }
        }
    }

    public void g(Context context, IInterface iInterface) {
    }
}
