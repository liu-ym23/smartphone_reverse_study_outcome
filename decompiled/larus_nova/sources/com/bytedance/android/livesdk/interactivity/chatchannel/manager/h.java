package com.bytedance.android.livesdk.interactivity.chatchannel.manager;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.PriorityQueue;

/* JADX INFO: loaded from: classes9.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ChatChannelAnimManager f134304a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ChatChannelAnimManager.a f134305b;

    public h(ChatChannelAnimManager r100, ChatChannelAnimManager.a r101) {
        this.f134304a = r100;
        this.f134305b = r101;
    }

    public final void a() {
        ChatChannelAnimManager r100 = this.f134304a;
        ChatChannelAnimManager.a r101 = this.f134305b;
        if (r100.f134166d == true) goto L6;
        return;
    L6:
        if (r100.f134164b != null) goto L8;
        ChatChannelAnimManager.e("submit. exec task " + r101.f134169c);
        r100.f134164b = r101;
        r101.a(new ChatChannelAnimManager$timeoutAction$1(r100));
        return;
    L8:
        ChatChannelAnimManager.e("submit. queue task " + r101.f134169c);
        ((PriorityQueue) r100.f134163a).add(r101);
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
