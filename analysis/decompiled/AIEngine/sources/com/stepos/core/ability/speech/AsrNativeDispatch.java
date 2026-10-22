package com.stepos.core.ability.speech;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AsrNativeDispatch {
    public static final AsrNativeDispatch INSTANCE = new AsrNativeDispatch();
    private static final ExecutorCoroutineDispatcher dispatcher;
    private static final ExecutorService executor;

    static {
        ExecutorService executor2 = Executors.newSingleThreadExecutor(new f(1));
        executor = executor2;
        kotlin.jvm.internal.g.e(executor2, "executor");
        dispatcher = ExecutorsKt.from(executor2);
    }

    private AsrNativeDispatch() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Thread executor$lambda$1(Runnable runnable) {
        return com.stepos.core.ota.d.n(runnable, "AsrNative-native", true);
    }

    public final ExecutorCoroutineDispatcher getDispatcher() {
        return dispatcher;
    }
}
