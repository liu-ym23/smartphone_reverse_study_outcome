package com.stepos.agentframework.adapter.bff.utils;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/stepos/agentframework/adapter/bff/utils/SafeCounterUtils;", "", AppAgent.CONSTRUCT, "()V", "counter", "Ljava/util/concurrent/atomic/AtomicInteger;", "incrementAndGet", "", "bff_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SafeCounterUtils {
    public static final SafeCounterUtils INSTANCE = new SafeCounterUtils();
    private static final AtomicInteger counter = new AtomicInteger(0);

    private SafeCounterUtils() {
    }

    public final int incrementAndGet() {
        return counter.incrementAndGet();
    }
}
