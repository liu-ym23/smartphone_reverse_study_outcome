package com.baidu.lbsapi.auth;

import android.os.Handler;
import android.os.Looper;

/* loaded from: classes.dex */
class p extends Thread {

    /* renamed from: a, reason: collision with root package name */
    Handler f4961a;

    /* renamed from: b, reason: collision with root package name */
    private Object f4962b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f4963c;

    public p() {
        this.f4961a = null;
        this.f4962b = new Object();
        this.f4963c = false;
    }

    public void a() {
        if (b.f4919a) {
            b.a("Looper thread quit()");
        }
        Handler handler = this.f4961a;
        if (handler == null || handler.getLooper() == null) {
            return;
        }
        this.f4961a.getLooper().quit();
    }

    public void b() {
        synchronized (this.f4962b) {
            try {
            } catch (InterruptedException e4) {
                e4.printStackTrace();
            }
            if (!this.f4963c) {
                this.f4962b.wait();
            }
        }
    }

    public void c() {
        synchronized (this.f4962b) {
            this.f4963c = true;
            this.f4962b.notifyAll();
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Looper.prepare();
        this.f4961a = new Handler();
        if (b.f4919a) {
            b.a("new Handler() finish!!");
        }
        Looper.loop();
        if (b.f4919a) {
            b.a("LooperThread run() thread id:" + String.valueOf(Thread.currentThread().getId()));
        }
    }

    public p(String str) {
        super(str);
        this.f4961a = null;
        this.f4962b = new Object();
        this.f4963c = false;
    }
}
