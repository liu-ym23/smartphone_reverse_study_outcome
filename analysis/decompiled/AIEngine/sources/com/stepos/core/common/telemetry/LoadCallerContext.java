package com.stepos.core.common.telemetry;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class LoadCallerContext {
    public static final LoadCallerContext INSTANCE = new LoadCallerContext();
    private static final ThreadLocal<Integer> current = new ThreadLocal<>();

    private LoadCallerContext() {
    }

    public final Integer currentCallerUid() {
        return current.get();
    }

    public final <T> T runWith(int i10, zb.a<? extends T> block) {
        kotlin.jvm.internal.g.f(block, "block");
        ThreadLocal<Integer> threadLocal = current;
        Integer num = threadLocal.get();
        threadLocal.set(Integer.valueOf(i10));
        try {
            T tInvoke = block.invoke();
            threadLocal.set(num);
            return tInvoke;
        } catch (Throwable th) {
            current.set(num);
            throw th;
        }
    }
}
