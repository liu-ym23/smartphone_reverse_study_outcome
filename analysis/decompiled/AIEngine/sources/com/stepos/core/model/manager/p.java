package com.stepos.core.model.manager;

import java.util.concurrent.ThreadFactory;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class p implements ThreadFactory {
    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        return ModelLoaderImpl.loadExecutor$lambda$1(runnable);
    }
}
