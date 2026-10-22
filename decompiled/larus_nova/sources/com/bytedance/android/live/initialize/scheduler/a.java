package com.bytedance.android.live.initialize.scheduler;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class a extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WTOTaskScheduler f69441a;

    @Override // android.os.Handler
    public final void handleMessage(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        super.handleMessage(r100);
        if (r100.what != 10000001) goto L6;
        this.f69441a.f69431k.invoke();
        return;
    }

    public a(WTOTaskScheduler r100, Looper r101) {
        this.f69441a = r100;
        super(r101);
    }
}
