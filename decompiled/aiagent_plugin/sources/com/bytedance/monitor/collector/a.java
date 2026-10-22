package com.bytedance.monitor.collector;

import android.os.Message;

/* JADX INFO: compiled from: AbsLooperDispatchListener.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static long f8947b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static long f8948c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile boolean f8949d;

    static {
    }

    public boolean a() {
        return false;
    }

    public void b(String r1) {
    }

    public a() {
        this.f8949d = false;
    }

    public void a(String r1) {
        this.f8949d = true;
    }

    public void a(String r1, Message r2) {
        this.f8949d = false;
        b(r1);
    }
}
