package com.airbnb.lottie;

import java.util.concurrent.ExecutionException;

/* loaded from: classes.dex */
public final class B extends Thread {

    /* renamed from: a, reason: collision with root package name */
    public boolean f4521a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C f4522b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public B(C c4) {
        super("LottieTaskObserver");
        this.f4522b = c4;
        this.f4521a = false;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        while (!isInterrupted() && !this.f4521a) {
            C c4 = this.f4522b;
            if (c4.f4528e.isDone()) {
                try {
                    c4.c((A) c4.f4528e.get());
                } catch (InterruptedException | ExecutionException e4) {
                    c4.c(new A(e4));
                }
                this.f4521a = true;
                c4.e();
            }
        }
    }
}
