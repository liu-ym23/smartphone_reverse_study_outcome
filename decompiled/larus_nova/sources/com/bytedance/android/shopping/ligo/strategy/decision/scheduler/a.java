package com.bytedance.android.shopping.ligo.strategy.decision.scheduler;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes13.dex */
public interface a {
    void cancel();

    boolean isCompleted();

    void schedule(Function0<Unit> r100);
}
