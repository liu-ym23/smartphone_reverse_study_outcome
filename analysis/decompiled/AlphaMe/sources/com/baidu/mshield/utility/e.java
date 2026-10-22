package com.baidu.mshield.utility;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public static final e f8355a = new e();

    /* renamed from: b, reason: collision with root package name */
    public HandlerThread f8356b = new HandlerThread("rp_th", 10);

    /* renamed from: c, reason: collision with root package name */
    public Handler f8357c;

    public e() {
        b();
        this.f8357c = new Handler(this.f8356b.getLooper());
    }

    public static Looper a() {
        return f8355a.f8357c.getLooper();
    }

    public final void b() {
        this.f8356b.start();
    }
}
