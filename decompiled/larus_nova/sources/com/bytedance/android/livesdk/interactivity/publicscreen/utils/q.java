package com.bytedance.android.livesdk.interactivity.publicscreen.utils;

import com.bytedance.android.livesdk.interactivity.publicscreen.adapter.MessageListAdapter;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes9.dex */
public final class q implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MessageListAdapter f140340a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f140341b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f140342c;

    public q(MessageListAdapter r100, int r101, int r102) {
        this.f140340a = r100;
        this.f140341b = r101;
        this.f140342c = r102;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f140340a.notifyItemRangeInserted(this.f140341b, this.f140342c);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
