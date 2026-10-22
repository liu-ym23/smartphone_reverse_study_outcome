package com.google.android.gms.common.internal;

import android.util.Log;

/* loaded from: classes2.dex */
public abstract class K {

    /* renamed from: a, reason: collision with root package name */
    public Object f19740a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f19741b = false;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AbstractC1662c f19742c;

    public K(AbstractC1662c abstractC1662c, Object obj) {
        this.f19742c = abstractC1662c;
        this.f19740a = obj;
    }

    public abstract void a(Object obj);

    public abstract void b();

    public final void c() {
        Object obj;
        synchronized (this) {
            try {
                obj = this.f19740a;
                if (this.f19741b) {
                    Log.w("GmsClient", "Callback proxy " + toString() + " being reused. This is not safe.");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (obj != null) {
            a(obj);
        }
        synchronized (this) {
            this.f19741b = true;
        }
        e();
    }

    public final void d() {
        synchronized (this) {
            this.f19740a = null;
        }
    }

    public final void e() {
        d();
        synchronized (this.f19742c.f19795r) {
            this.f19742c.f19795r.remove(this);
        }
    }
}
