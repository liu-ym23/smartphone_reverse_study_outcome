package com.google.android.material.snackbar;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
class b {

    /* renamed from: e, reason: collision with root package name */
    private static b f13201e;

    /* renamed from: a, reason: collision with root package name */
    private final Object f13202a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private final Handler f13203b = new Handler(Looper.getMainLooper(), new a());

    /* renamed from: c, reason: collision with root package name */
    private c f13204c;

    /* renamed from: d, reason: collision with root package name */
    private c f13205d;

    class a implements Handler.Callback {
        a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 0) {
                return false;
            }
            b.this.d((c) message.obj);
            return true;
        }
    }

    /* renamed from: com.google.android.material.snackbar.b$b, reason: collision with other inner class name */
    interface InterfaceC0171b {
        void a();

        void b(int i5);
    }

    private static class c {

        /* renamed from: a, reason: collision with root package name */
        final WeakReference<InterfaceC0171b> f13207a;

        /* renamed from: b, reason: collision with root package name */
        int f13208b;

        /* renamed from: c, reason: collision with root package name */
        boolean f13209c;

        boolean a(InterfaceC0171b interfaceC0171b) {
            return interfaceC0171b != null && this.f13207a.get() == interfaceC0171b;
        }
    }

    private b() {
    }

    private boolean a(c cVar, int i5) {
        InterfaceC0171b interfaceC0171b = cVar.f13207a.get();
        if (interfaceC0171b == null) {
            return false;
        }
        this.f13203b.removeCallbacksAndMessages(cVar);
        interfaceC0171b.b(i5);
        return true;
    }

    static b c() {
        if (f13201e == null) {
            f13201e = new b();
        }
        return f13201e;
    }

    private boolean f(InterfaceC0171b interfaceC0171b) {
        c cVar = this.f13204c;
        return cVar != null && cVar.a(interfaceC0171b);
    }

    private boolean g(InterfaceC0171b interfaceC0171b) {
        c cVar = this.f13205d;
        return cVar != null && cVar.a(interfaceC0171b);
    }

    private void l(c cVar) {
        int i5 = cVar.f13208b;
        if (i5 == -2) {
            return;
        }
        if (i5 <= 0) {
            i5 = i5 == -1 ? 1500 : 2750;
        }
        this.f13203b.removeCallbacksAndMessages(cVar);
        Handler handler = this.f13203b;
        handler.sendMessageDelayed(Message.obtain(handler, 0, cVar), i5);
    }

    private void m() {
        c cVar = this.f13205d;
        if (cVar != null) {
            this.f13204c = cVar;
            this.f13205d = null;
            InterfaceC0171b interfaceC0171b = cVar.f13207a.get();
            if (interfaceC0171b != null) {
                interfaceC0171b.a();
            } else {
                this.f13204c = null;
            }
        }
    }

    public void b(InterfaceC0171b interfaceC0171b, int i5) {
        synchronized (this.f13202a) {
            try {
                if (f(interfaceC0171b)) {
                    a(this.f13204c, i5);
                } else if (g(interfaceC0171b)) {
                    a(this.f13205d, i5);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    void d(c cVar) {
        synchronized (this.f13202a) {
            try {
                if (this.f13204c == cVar || this.f13205d == cVar) {
                    a(cVar, 2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean e(InterfaceC0171b interfaceC0171b) {
        boolean z5;
        synchronized (this.f13202a) {
            try {
                z5 = f(interfaceC0171b) || g(interfaceC0171b);
            } finally {
            }
        }
        return z5;
    }

    public void h(InterfaceC0171b interfaceC0171b) {
        synchronized (this.f13202a) {
            try {
                if (f(interfaceC0171b)) {
                    this.f13204c = null;
                    if (this.f13205d != null) {
                        m();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void i(InterfaceC0171b interfaceC0171b) {
        synchronized (this.f13202a) {
            try {
                if (f(interfaceC0171b)) {
                    l(this.f13204c);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void j(InterfaceC0171b interfaceC0171b) {
        synchronized (this.f13202a) {
            try {
                if (f(interfaceC0171b)) {
                    c cVar = this.f13204c;
                    if (!cVar.f13209c) {
                        cVar.f13209c = true;
                        this.f13203b.removeCallbacksAndMessages(cVar);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void k(InterfaceC0171b interfaceC0171b) {
        synchronized (this.f13202a) {
            try {
                if (f(interfaceC0171b)) {
                    c cVar = this.f13204c;
                    if (cVar.f13209c) {
                        cVar.f13209c = false;
                        l(cVar);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
