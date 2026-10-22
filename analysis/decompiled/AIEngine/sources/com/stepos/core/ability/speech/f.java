package com.stepos.core.ability.speech;

import java.util.concurrent.ThreadFactory;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class f implements ThreadFactory {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7270a;

    public /* synthetic */ f(int i10) {
        this.f7270a = i10;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        switch (this.f7270a) {
            case 0:
                return AsrFeedDispatch.threadFactory$lambda$1(runnable);
            case 1:
                return AsrNativeDispatch.executor$lambda$1(runnable);
            case 2:
                return AsrPcmDumpSink.executor_delegate$lambda$3$lambda$1(runnable);
            default:
                return VadNativeDispatch.executor$lambda$1(runnable);
        }
    }
}
