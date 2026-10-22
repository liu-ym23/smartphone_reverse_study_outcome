package com.bytedance.lego.init;

import d.h.a.a;
import d.h.b.p;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: compiled from: InitTaskDispatcher.kt */
/* JADX INFO: loaded from: classes.dex */
final class InitTaskDispatcher$executor$2 extends p implements a<ThreadPoolExecutor> {
    public static final InitTaskDispatcher$executor$2 INSTANCE = null;

    static {
        INSTANCE = new InitTaskDispatcher$executor$2();
    }

    InitTaskDispatcher$executor$2() {
        super(0);
    }

    @Override // d.h.a.a
    public /* bridge */ /* synthetic */ ThreadPoolExecutor invoke() {
        return invoke2();
    }

    @Override // d.h.a.a
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final ThreadPoolExecutor invoke2() {
        return InitScheduler.INSTANCE.getExecutorService$initscheduler_release();
    }
}
