package com.bytedance.android.shopping.new_cart.components;

import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes13.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f178821a;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f178822a;

        public a(b r100) {
            this.f178822a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f178822a.f178821a.invalidate();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public b(View r100) {
        this.f178821a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f178821a.postOnAnimation(new a(this));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
