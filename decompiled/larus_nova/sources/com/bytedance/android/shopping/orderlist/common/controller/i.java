package com.bytedance.android.shopping.orderlist.common.controller;

import android.os.MessageQueue;
import java.util.List;

/* JADX INFO: loaded from: classes13.dex */
public final class i implements MessageQueue.IdleHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f179730a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List f179731b;

    public i(h r100, List r101) {
        this.f179730a = r100;
        this.f179731b = r101;
    }

    @Override // android.os.MessageQueue.IdleHandler
    public final boolean queueIdle() {
        this.f179730a.a(this.f179731b);
        return false;
    }
}
