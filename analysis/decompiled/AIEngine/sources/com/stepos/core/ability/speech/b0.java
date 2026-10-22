package com.stepos.core.ability.speech;

import java.util.concurrent.ThreadFactory;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class b0 implements ThreadFactory {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7246a;

    public /* synthetic */ b0(int i10) {
        this.f7246a = i10;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        switch (this.f7246a) {
            case 0:
                return TtsPcmDumpSink.executor_delegate$lambda$3$lambda$1(runnable);
            default:
                return TtsStreamCallbackExecutor.executor$lambda$1(runnable);
        }
    }
}
