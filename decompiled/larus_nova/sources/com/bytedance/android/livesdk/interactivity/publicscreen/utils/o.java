package com.bytedance.android.livesdk.interactivity.publicscreen.utils;

import com.bytedance.android.livesdk.interactivity.publicscreen.adapter.MessageListAdapter;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes9.dex */
public final class o implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MessageListAdapter f140335a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f140336b;

    public o(MessageListAdapter r100, int r101) {
        this.f140335a = r100;
        this.f140336b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f140335a.notifyItemChanged(this.f140336b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
