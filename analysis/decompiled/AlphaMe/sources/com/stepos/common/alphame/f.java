package com.stepos.common.alphame;

import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import android.util.LongSparseArray;
import com.stepos.alphame.Tags;
import t0.J;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final LongSparseArray f11227a = new LongSparseArray();

    /* renamed from: b, reason: collision with root package name */
    public final LongSparseArray f11228b = new LongSparseArray();

    /* renamed from: c, reason: collision with root package name */
    public final LongSparseArray f11229c = new LongSparseArray();

    /* renamed from: d, reason: collision with root package name */
    public IAlphaMe f11230d;

    /* renamed from: e, reason: collision with root package name */
    public AlphaMe$AlphaMeClient f11231e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f11232f;

    /* renamed from: g, reason: collision with root package name */
    public final a f11233g;

    public f() {
        d();
        if (Looper.getMainLooper() != null) {
            this.f11233g = new a(this, Looper.getMainLooper());
        }
    }

    public static f c() {
        return c.f11224a;
    }

    public final void a(Object... objArr) {
        d();
        if (this.f11232f) {
            try {
                this.f11230d.collect(Tags.APP_EVENT, new Args(objArr));
            } catch (RemoteException e4) {
                Log.e("AlphaMe", "collect fail : " + e4.getMessage());
            }
        }
    }

    public final b b(int i4) {
        b bVar;
        synchronized (this) {
            bVar = (b) this.f11228b.get(i4);
        }
        return bVar;
    }

    public final void d() {
        synchronized (this) {
            try {
                if (!this.f11232f) {
                    if (this.f11230d == null) {
                        this.f11230d = AlphaMeNative.asInterface(J.k());
                    }
                    IAlphaMe iAlphaMe = this.f11230d;
                    if (iAlphaMe == null) {
                        Log.e("AlphaMe", "Can't find alphame_server");
                        return;
                    }
                    try {
                        iAlphaMe.asBinder().linkToDeath(new e(this), 0);
                        AlphaMe$AlphaMeClient alphaMe$AlphaMeClient = new AlphaMe$AlphaMeClient(this, null);
                        this.f11231e = alphaMe$AlphaMeClient;
                        this.f11230d.addClient(alphaMe$AlphaMeClient.asBinder());
                        this.f11232f = true;
                    } catch (RemoteException e4) {
                        Log.e("AlphaMe", "" + e4.getMessage());
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final Object e(String str, Object... objArr) {
        d dVar = new d();
        d();
        if (this.f11232f) {
            try {
                synchronized (this) {
                    if (this.f11227a.size() <= 32) {
                        this.f11227a.put(dVar.getId(), dVar);
                        this.f11230d.exec(this.f11231e.asBinder(), str, new Args(objArr), 1, dVar.getId());
                    } else {
                        Log.e("AlphaMe", "Invoke too much");
                    }
                }
            } catch (Exception e4) {
                Log.e("AlphaMe", "Execute exception " + e4.getMessage());
                int id = dVar.getId();
                synchronized (this) {
                    this.f11227a.remove(id);
                }
            }
        }
        return dVar.f11225a;
    }

    public final void f(b bVar) {
        if (bVar == null || bVar.mActions.isEmpty()) {
            return;
        }
        d();
        if (this.f11230d == null) {
            synchronized (this.f11229c) {
                try {
                    if (this.f11229c.get(bVar.getId()) == null) {
                        this.f11229c.put(bVar.getId(), bVar);
                        this.f11233g.removeMessages(0);
                        this.f11233g.sendEmptyMessageDelayed(0, 1000L);
                    }
                } finally {
                }
            }
            return;
        }
        if (this.f11232f) {
            try {
                if (b(bVar.getId()) != null) {
                    Log.e("AlphaMe", "Receiver is registered before");
                    return;
                }
                synchronized (this) {
                    if (this.f11228b.size() <= 24) {
                        this.f11228b.put(bVar.getId(), bVar);
                        this.f11230d.registerActionReceiver(this.f11231e.asBinder(), bVar.mActions, bVar.getId());
                    } else {
                        Log.e("AlphaMe", "Register too many receivers");
                    }
                }
            } catch (Exception e4) {
                Log.e("AlphaMe", "registerReceiver exception " + e4.getMessage());
                int id = bVar.getId();
                synchronized (this) {
                    long j4 = id;
                    this.f11228b.remove(j4);
                    this.f11229c.remove(j4);
                }
            }
        }
    }

    public final void g(b bVar) {
        if (bVar == null || bVar.mActions.isEmpty()) {
            return;
        }
        d();
        if (this.f11232f) {
            try {
                if (b(bVar.getId()) == null) {
                    Log.e("AlphaMe", "Try to remove a receiver that is not registered");
                    return;
                }
                int id = bVar.getId();
                synchronized (this) {
                    long j4 = id;
                    this.f11228b.remove(j4);
                    this.f11229c.remove(j4);
                }
                this.f11230d.unregisterActionReceiver(this.f11231e.asBinder(), bVar.getId());
            } catch (Exception e4) {
                Log.e("AlphaMe", "unregisterReceiver exception " + e4.getMessage());
            }
        }
    }
}
