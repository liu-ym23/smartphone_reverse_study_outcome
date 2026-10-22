package com.bytedance.android.live.liveinteract.service;

import android.content.Context;
import com.bytedance.android.livesdk.schema.interfaces.ILiveActionHandler;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes46.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f78603a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f78604b;

    public a(Context r100, String r101) {
        this.f78603a = r100;
        this.f78604b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ILiveActionHandler r100 = (ILiveActionHandler) jc1.k.f(ILiveActionHandler.class);     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        r100.handle(this.f78603a, this.f78604b);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
