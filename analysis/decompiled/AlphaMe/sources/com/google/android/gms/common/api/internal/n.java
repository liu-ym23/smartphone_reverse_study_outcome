package com.google.android.gms.common.api.internal;

import android.os.Handler;
import android.os.Looper;
import g1.HandlerC0575c;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final /* synthetic */ class n implements Executor {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9660a;

    /* renamed from: b, reason: collision with root package name */
    public final Handler f9661b;

    public /* synthetic */ n(HandlerC0575c handlerC0575c) {
        this.f9660a = 0;
        this.f9661b = handlerC0575c;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        int i4 = this.f9660a;
        Handler handler = this.f9661b;
        switch (i4) {
            case 0:
                handler.post(runnable);
                break;
            default:
                handler.post(runnable);
                break;
        }
    }

    public n() {
        this.f9660a = 1;
        this.f9661b = new HandlerC0575c(Looper.getMainLooper(), 2);
    }
}
