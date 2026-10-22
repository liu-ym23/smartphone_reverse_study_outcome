package com.baidu.mshield.utility;

import android.content.Context;
import android.os.Message;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes39.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Lock f32450a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static b f32451b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.baidu.mshield.rp.f.a f32452c;

    static {
        f32450a = new ReentrantLock();
        f32451b = null;
    }

    public void a() {
        Message r100 = new Message();
        r100.what = 9;
        this.f32452c.a(r100);
    }

    public void b() {
        this.f32452c.e();
    }

    public void c() {
        Message r100 = new Message();
        r100.what = 6;
        this.f32452c.a(r100);
    }

    public void d() {
        Message r100 = new Message();
        r100.what = 2;
        this.f32452c.a(r100);
    }

    public void e() {
        Message r100 = new Message();
        r100.what = 8;
        this.f32452c.a(r100);
    }

    public b(Context r100) {
        this.f32452c = new com.baidu.mshield.rp.f.a(r100);
    }

    public static b a(Context r100) {
        b r101 = f32451b;
        if (r101 == null) goto L14;
        return r101;
    L14:
        f32450a.lock();     // Catch: Throwable -> L11
        if (f32451b != null) goto L8;
        f32451b = new b(r100);     // Catch: Throwable -> L11
    L8:
        b r102 = f32451b;     // Catch: Throwable -> L11
        f32450a.unlock();
        return r102;
    L11:
        th = move-exception;
        f32450a.unlock();
        throw th;
    }

    public void a(String r100) {
        Message r101 = new Message();
        r101.what = 11;
        r101.obj = r100;
        this.f32452c.a(r101);
    }

    public void a(com.baidu.mshield.rp.b.a r100) {
        Message r101 = new Message();
        r101.what = 3;
        r101.obj = r100;
        this.f32452c.a(r101);
    }

    public void a(com.baidu.mshield.rp.d.a r100) {
        Message r101 = new Message();
        r101.what = 1;
        r101.obj = r100;
        this.f32452c.a(r101);
    }

    public void a(boolean r100) {
        this.f32452c.a(r100);
    }
}
