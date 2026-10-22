package com.bytedance.android.livesdk.vscore_impl.component.tabs.popup;

import com.bytedance.android.livesdkapi.depend.model.live.vs.MultiTab;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes11.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MultiTabBubbleWidget f159995a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MultiTab.Bubble f159996b;

    public d(MultiTabBubbleWidget r100, MultiTab.Bubble r101) {
        this.f159995a = r100;
        this.f159996b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f159995a.wq("timeout");     // Catch: Throwable -> L4
        LinkedList<MultiTab.Bubble> r100 = MultiTabBubbleManager.f159974a;     // Catch: Throwable -> L4
        MultiTabBubbleManager.b(this.f159996b.getBubbleId() + " realPopBubble DONE ");     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
