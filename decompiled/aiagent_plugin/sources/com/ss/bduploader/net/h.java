package com.ss.bduploader.net;

import android.os.Handler;
import android.os.Message;

/* JADX INFO: compiled from: BaseDNS.java */
/* JADX INFO: loaded from: classes4.dex */
public class h {
    private static final String TAG = "BaseDNS";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Handler f37532a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected boolean f37533b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f37534c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected g f37535d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f37536e;

    public void a() {
    }

    public void b() {
    }

    public void c() {
    }

    public h(String r3, Handler r4) {
        this.f37533b = false;
        this.f37535d = null;
        this.f37534c = r3;
        this.f37532a = r4;
        this.f37536e = Long.toString(System.nanoTime()) + Integer.toString(System.identityHashCode(this));
    }

    public h(String r2, g r3, Handler r4) {
        this.f37533b = false;
        this.f37535d = null;
        this.f37534c = r2;
        this.f37532a = r4;
        if (r3 != null) goto L5;
        r3 = new a();
    L5:
        this.f37535d = r3;
        this.f37536e = Long.toString(System.nanoTime()) + Integer.toString(System.identityHashCode(this));
    }

    public void a(b r3) {
        Message r4 = this.f37532a.obtainMessage(2, r3);
        this.f37532a.sendMessage(r4);
    }

    public void b(b r3) {
        Message r4 = this.f37532a.obtainMessage(3, r3);
        this.f37532a.sendMessage(r4);
    }
}
