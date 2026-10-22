package com.bytedance.android.livesdk.utils;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class z5 extends PthreadHandlerThreadV2 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f159235c;

    public interface a {
        void a(z5 r100);

        void onQuit();
    }

    @Override // android.os.HandlerThread
    public final void onLooperPrepared() {
        this.f159235c.a(this);
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2, android.os.HandlerThread, java.lang.Thread, java.lang.Runnable
    public final void run() {
        super.run();     // Catch: Throwable -> L4
        this.f159235c.onQuit();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public z5(String r100, int r101, a r102) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r102, "callback");
        super(r100, r101);
        this.f159235c = r102;
    }
}
