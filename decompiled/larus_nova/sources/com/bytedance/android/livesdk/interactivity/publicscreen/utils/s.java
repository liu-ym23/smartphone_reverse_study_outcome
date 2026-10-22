package com.bytedance.android.livesdk.interactivity.publicscreen.utils;

import com.bytedance.android.livesdk.interactivity.publicscreen.adapter.MessageListAdapter;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes9.dex */
public final class s implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MessageListAdapter f140346a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f140347b;

    public s(MessageListAdapter r100, int r101) {
        this.f140346a = r100;
        this.f140347b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f140346a.notifyItemRemoved(this.f140347b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
