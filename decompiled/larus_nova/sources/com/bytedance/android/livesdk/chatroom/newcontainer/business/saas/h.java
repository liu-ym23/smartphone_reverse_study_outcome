package com.bytedance.android.livesdk.chatroom.newcontainer.business.saas;

import android.widget.FrameLayout;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes7.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ls2.d f107557a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ik1.h f107558b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ FrameLayout f107559c;

    public h(ls2.d r100, ik1.h r101, FrameLayout r102) {
        this.f107557a = r100;
        this.f107558b = r101;
        this.f107559c = r102;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean r100 = e.f107551a;     // Catch: Throwable -> L4
        e.a(this.f107557a, this.f107558b, this.f107559c);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
