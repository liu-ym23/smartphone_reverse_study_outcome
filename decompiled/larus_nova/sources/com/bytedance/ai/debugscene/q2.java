package com.bytedance.ai.debugscene;

import com.bytedance.ai.debug.IAISDKDebugService;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes43.dex */
public final class q2 implements IAISDKDebugService.d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicLong f36483b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f36484a;

    public static final class a {
    }

    public q2() {
        this(0);
    }

    static {
        f36483b = new AtomicLong();
    }

    public q2(int r100) {
        this.f36484a = f36483b.incrementAndGet();
    }
}
