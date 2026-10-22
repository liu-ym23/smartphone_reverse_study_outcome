package com.bytedance.android.livesdk.room.placeholder.behavior;

import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes11.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AnchorLiveAdWrapper f157714a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f157715b;

    public c(AnchorLiveAdWrapper r100, View r101) {
        this.f157714a = r100;
        this.f157715b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f157714a.f157692e.onViewAttached(l.a(this.f157715b));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
