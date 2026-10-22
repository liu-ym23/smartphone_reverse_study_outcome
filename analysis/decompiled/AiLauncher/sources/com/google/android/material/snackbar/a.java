package com.google.android.material.snackbar;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* loaded from: classes2.dex */
public class a {

    /* renamed from: e, reason: collision with root package name */
    public static a f21366e;

    /* renamed from: a, reason: collision with root package name */
    public final Object f21367a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public final Handler f21368b = new Handler(Looper.getMainLooper(), new C0237a());

    /* renamed from: c, reason: collision with root package name */
    public c f21369c;

    /* renamed from: d, reason: collision with root package name */
    public c f21370d;

    /* renamed from: com.google.android.material.snackbar.a$a, reason: collision with other inner class name */
    public class C0237a implements Handler.Callback {
        public C0237a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 0) {
                return false;
            }
            a.this.d((c) message.obj);
            return true;
        }
    }

    public interface b {
        void a(int i10);

        void show();
    }

    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public final WeakReference<b> f21372a;

        /* renamed from: b, reason: collision with root package name */
        public int f21373b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f21374c;

        public boolean a(b bVar) {
            return bVar != null && this.f21372a.get() == bVar;
        }
    }

    public static a c() {
        if (f21366e == null) {
            f21366e = new a();
        }
        return f21366e;
    }

    public final boolean a(c cVar, int i10) {
        b bVar = cVar.f21372a.get();
        if (bVar == null) {
            return false;
        }
        this.f21368b.removeCallbacksAndMessages(cVar);
        bVar.a(i10);
        return true;
    }

    public void b(b bVar, int i10) {
        synchronized (this.f21367a) {
            try {
                if (f(bVar)) {
                    a(this.f21369c, i10);
                } else if (g(bVar)) {
                    a(this.f21370d, i10);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void d(c cVar) {
        synchronized (this.f21367a) {
            try {
                if (this.f21369c == cVar || this.f21370d == cVar) {
                    a(cVar, 2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean e(b bVar) {
        boolean z10;
        synchronized (this.f21367a) {
            try {
                z10 = f(bVar) || g(bVar);
            } finally {
            }
        }
        return z10;
    }

    public final boolean f(b bVar) {
        c cVar = this.f21369c;
        return cVar != null && cVar.a(bVar);
    }

    public final boolean g(b bVar) {
        c cVar = this.f21370d;
        return cVar != null && cVar.a(bVar);
    }

    public void h(b bVar) {
        synchronized (this.f21367a) {
            try {
                if (f(bVar)) {
                    this.f21369c = null;
                    if (this.f21370d != null) {
                        m();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void i(b bVar) {
        synchronized (this.f21367a) {
            try {
                if (f(bVar)) {
                    l(this.f21369c);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void j(b bVar) {
        synchronized (this.f21367a) {
            try {
                if (f(bVar)) {
                    c cVar = this.f21369c;
                    if (!cVar.f21374c) {
                        cVar.f21374c = true;
                        this.f21368b.removeCallbacksAndMessages(cVar);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void k(b bVar) {
        synchronized (this.f21367a) {
            try {
                if (f(bVar)) {
                    c cVar = this.f21369c;
                    if (cVar.f21374c) {
                        cVar.f21374c = false;
                        l(cVar);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void l(c cVar) {
        int i10 = cVar.f21373b;
        if (i10 == -2) {
            return;
        }
        if (i10 <= 0) {
            i10 = i10 == -1 ? 1500 : 2750;
        }
        this.f21368b.removeCallbacksAndMessages(cVar);
        Handler handler = this.f21368b;
        handler.sendMessageDelayed(Message.obtain(handler, 0, cVar), i10);
    }

    public final void m() {
        c cVar = this.f21370d;
        if (cVar != null) {
            this.f21369c = cVar;
            this.f21370d = null;
            b bVar = cVar.f21372a.get();
            if (bVar != null) {
                bVar.show();
            } else {
                this.f21369c = null;
            }
        }
    }
}
