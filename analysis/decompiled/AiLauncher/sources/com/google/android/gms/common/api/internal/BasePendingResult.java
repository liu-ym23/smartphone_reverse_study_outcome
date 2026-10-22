package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.api.h;
import com.google.android.gms.common.internal.C1669j;
import com.google.android.gms.common.internal.ICancelToken;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

@KeepName
/* loaded from: classes2.dex */
public abstract class BasePendingResult<R extends com.google.android.gms.common.api.h> extends com.google.android.gms.common.api.f<R> {

    /* renamed from: o, reason: collision with root package name */
    public static final ThreadLocal f19520o = new v0();

    /* renamed from: f, reason: collision with root package name */
    public com.google.android.gms.common.api.i f19526f;

    /* renamed from: h, reason: collision with root package name */
    public com.google.android.gms.common.api.h f19528h;

    /* renamed from: i, reason: collision with root package name */
    public Status f19529i;

    /* renamed from: j, reason: collision with root package name */
    public volatile boolean f19530j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f19531k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f19532l;

    /* renamed from: m, reason: collision with root package name */
    public ICancelToken f19533m;

    @KeepName
    private x0 resultGuardian;

    /* renamed from: a, reason: collision with root package name */
    public final Object f19521a = new Object();

    /* renamed from: d, reason: collision with root package name */
    public final CountDownLatch f19524d = new CountDownLatch(1);

    /* renamed from: e, reason: collision with root package name */
    public final ArrayList f19525e = new ArrayList();

    /* renamed from: g, reason: collision with root package name */
    public final AtomicReference f19527g = new AtomicReference();

    /* renamed from: n, reason: collision with root package name */
    public boolean f19534n = false;

    /* renamed from: b, reason: collision with root package name */
    public final a f19522b = new a(Looper.getMainLooper());

    /* renamed from: c, reason: collision with root package name */
    public final WeakReference f19523c = new WeakReference(null);

    public static class a<R extends com.google.android.gms.common.api.h> extends w2.i {
        public a(Looper looper) {
            super(looper);
        }

        public final void a(com.google.android.gms.common.api.i iVar, com.google.android.gms.common.api.h hVar) {
            ThreadLocal threadLocal = BasePendingResult.f19520o;
            sendMessage(obtainMessage(1, new Pair((com.google.android.gms.common.api.i) C1669j.k(iVar), hVar)));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            int i10 = message.what;
            if (i10 != 1) {
                if (i10 == 2) {
                    ((BasePendingResult) message.obj).b(Status.RESULT_TIMEOUT);
                    return;
                }
                Log.wtf("BasePendingResult", "Don't know how to handle message: " + i10, new Exception());
                return;
            }
            Pair pair = (Pair) message.obj;
            com.google.android.gms.common.api.i iVar = (com.google.android.gms.common.api.i) pair.first;
            com.google.android.gms.common.api.h hVar = (com.google.android.gms.common.api.h) pair.second;
            try {
                iVar.a(hVar);
            } catch (RuntimeException e10) {
                BasePendingResult.h(hVar);
                throw e10;
            }
        }
    }

    @Deprecated
    public BasePendingResult() {
    }

    public static void h(com.google.android.gms.common.api.h hVar) {
        if (hVar instanceof com.google.android.gms.common.api.g) {
            try {
                ((com.google.android.gms.common.api.g) hVar).release();
            } catch (RuntimeException e10) {
                Log.w("BasePendingResult", "Unable to release ".concat(String.valueOf(hVar)), e10);
            }
        }
    }

    public abstract R a(Status status);

    @Deprecated
    public final void b(Status status) {
        synchronized (this.f19521a) {
            try {
                if (!c()) {
                    d(a(status));
                    this.f19532l = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean c() {
        return this.f19524d.getCount() == 0;
    }

    public final void d(R r10) {
        synchronized (this.f19521a) {
            try {
                if (this.f19532l || this.f19531k) {
                    h(r10);
                    return;
                }
                c();
                C1669j.o(!c(), "Results have already been set");
                C1669j.o(!this.f19530j, "Result has already been consumed");
                f(r10);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final com.google.android.gms.common.api.h e() {
        com.google.android.gms.common.api.h hVar;
        synchronized (this.f19521a) {
            C1669j.o(!this.f19530j, "Result has already been consumed.");
            C1669j.o(c(), "Result is not ready.");
            hVar = this.f19528h;
            this.f19528h = null;
            this.f19526f = null;
            this.f19530j = true;
        }
        if (((l0) this.f19527g.getAndSet(null)) == null) {
            return (com.google.android.gms.common.api.h) C1669j.k(hVar);
        }
        throw null;
    }

    public final void f(com.google.android.gms.common.api.h hVar) {
        this.f19528h = hVar;
        this.f19529i = hVar.getStatus();
        w0 w0Var = null;
        this.f19533m = null;
        this.f19524d.countDown();
        if (this.f19531k) {
            this.f19526f = null;
        } else {
            com.google.android.gms.common.api.i iVar = this.f19526f;
            if (iVar != null) {
                this.f19522b.removeMessages(2);
                this.f19522b.a(iVar, e());
            } else if (this.f19528h instanceof com.google.android.gms.common.api.g) {
                this.resultGuardian = new x0(this, w0Var);
            }
        }
        ArrayList arrayList = this.f19525e;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((f.a) arrayList.get(i10)).a(this.f19529i);
        }
        this.f19525e.clear();
    }
}
