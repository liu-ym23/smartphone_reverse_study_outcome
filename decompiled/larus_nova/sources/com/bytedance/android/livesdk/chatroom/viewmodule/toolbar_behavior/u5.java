package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import com.bytedance.android.livesdk.chatroom.viewmodel.IAnimationScheduler;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes8.dex */
public final class u5 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ t5 f117398a;

    public u5(t5 r100) {
        this.f117398a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        IAnimationScheduler.Companion r100 = IAnimationScheduler.M0;     // Catch: Throwable -> L6
        DataCenter r101 = this.f117398a.f117385i;     // Catch: Throwable -> L6
        r100.getClass();     // Catch: Throwable -> L6
        IAnimationScheduler r102 = IAnimationScheduler.Companion.a(r101);     // Catch: Throwable -> L6
        if (r102 == null) goto L9;
        r102.registerListener(this.f117398a.f117384h);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
