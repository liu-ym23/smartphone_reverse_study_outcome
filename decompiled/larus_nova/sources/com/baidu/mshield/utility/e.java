package com.baidu.mshield.utility;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;

/* JADX INFO: loaded from: classes39.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f32454a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public HandlerThread f32455b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Handler f32456c;

    static {
        f32454a = new e();
    }

    public static Looper a() {
        return f32454a.f32456c.getLooper();
    }

    public final void b() {
        ThreadMethodProxy.start(this.f32455b);
    }

    public e() {
        this.f32455b = new PthreadHandlerThreadV2("rp_th", 10);
        b();
        this.f32456c = new Handler(this.f32455b.getLooper());
    }
}
