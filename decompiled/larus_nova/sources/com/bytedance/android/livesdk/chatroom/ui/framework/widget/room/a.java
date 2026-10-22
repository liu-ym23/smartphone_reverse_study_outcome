package com.bytedance.android.livesdk.chatroom.ui.framework.widget.room;

import com.bytedance.android.live.link.ILinkServiceExternal;
import com.larus.apm.impl.protector.RunnableProtector;
import zg1.h1;

/* JADX INFO: loaded from: classes8.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zg1.m f113499a;

    public a(zg1.m r100) {
        this.f113499a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ILinkServiceExternal r100 = (ILinkServiceExternal) jc1.k.f(ILinkServiceExternal.class);     // Catch: Throwable -> L7
        if (r100 == null) goto L5;
        r100.notifyPauseStatus(this.f113499a.f571877a);     // Catch: Throwable -> L7
    L5:
        xs2.b.a().post(new h1(31));     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }
}
