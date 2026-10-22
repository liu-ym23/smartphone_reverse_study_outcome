package com.bytedance.android.livesdk.interactivity.publicscreen.utils;

import com.bytedance.android.livesdk.interactivity.publicscreen.adapter.MessageListAdapter;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes9.dex */
public final class r implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MessageListAdapter f140343a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f140344b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f140345c;

    public r(MessageListAdapter r100, int r101) {
        this.f140343a = r100;
        this.f140344b = 0;
        this.f140345c = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f140343a.notifyItemRangeRemoved(this.f140344b, this.f140345c);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
