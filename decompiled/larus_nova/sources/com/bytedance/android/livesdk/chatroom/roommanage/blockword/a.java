package com.bytedance.android.livesdk.chatroom.roommanage.blockword;

import androidx.core.widget.NestedScrollView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes7.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BlockWordFlowController f111333a;

    public a(BlockWordFlowController r100) {
        this.f111333a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ((NestedScrollView) this.f111333a.f111298j).fullScroll(130);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
