package com.bytedance.android.live.core.utils;

import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes45.dex */
public final class k2 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f66204a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f66205b;

    public k2(View r100) {
        this.f66204a = r100;
        this.f66205b = false;
    }

    @Override // java.lang.Runnable
    public final void run() {
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L15;
        throw th;
    L15:
        return;
    L3:
        if (this.f66205b == false) goto L5;
        UtilityKotlinExtentionsKt.t(this.f66204a);     // Catch: Throwable -> L7
    L12:
        return;
    L5:
        UtilityKotlinExtentionsKt.u(this.f66204a);     // Catch: Throwable -> L7
        goto L12
    }
}
