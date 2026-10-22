package com.bytedance.android.shopping.store.home.view;

import android.view.ViewGroup;
import android.view.ViewParent;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes14.dex */
public final class q implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p f184740a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function0 f184741b;

    public q(p r100, Function0 r101) {
        this.f184740a = r100;
        this.f184741b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        p r100 = this.f184740a;     // Catch: Throwable -> L12
        ViewParent r101 = r100.getParent();     // Catch: Throwable -> L12
        if ((r101 instanceof ViewGroup) == true) goto L5;
        r101 = null;
    L5:
        ViewGroup r102 = (ViewGroup) r101;     // Catch: Throwable -> L12
        if (r102 == null) goto L8;
        r102.removeView(r100);     // Catch: Throwable -> L12
    L8:
        Function0 r103 = this.f184741b;     // Catch: Throwable -> L12
        if (r103 == null) goto L15;
        Unit r104 = (Unit) r103.invoke();     // Catch: Throwable -> L12
        return;
    L15:
        return;
    L12:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L19;
        throw th;
    }
}
