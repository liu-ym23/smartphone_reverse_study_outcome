package com.bytedance.android.live.liveinteract.voicechat.util;

import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes46.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f80858a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f80859b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f80860c;

    public h(int r100, int r101, boolean r102) {
        this.f80858a = r100;
        this.f80859b = r101;
        this.f80860c = r102;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r100 = j.f80863a;     // Catch: Throwable -> L8
        j.b(this.f80858a, this.f80859b);     // Catch: Throwable -> L8
        if (this.f80860c == false) goto L11;
        com.bytedance.live.datacontext.m<Boolean> r101 = o3.d().o();     // Catch: Throwable -> L8
        if (r101 == null) goto L15;
        r101.setValue(Boolean.TRUE);     // Catch: Throwable -> L8
        return;
    L15:
        return;
    L11:
        return;
    L8:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L16;
        throw th;
    }
}
