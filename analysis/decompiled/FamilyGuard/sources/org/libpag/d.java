package org.libpag;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

/* loaded from: classes.dex */
class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Runnable f19227a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ HandlerThread f19228b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ HardwareDecoder f19229c;

    d(HardwareDecoder hardwareDecoder, Runnable runnable, HandlerThread handlerThread) {
        this.f19229c = hardwareDecoder;
        this.f19227a = runnable;
        this.f19228b = handlerThread;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f19227a.run();
        HardwareDecoder.f19124a.getAndDecrement();
        new Handler(Looper.getMainLooper()).post(new c(this));
    }
}
