package com.bytedance.android.livesdk.interactivity.service.richcontent.config;

import java.util.concurrent.ExecutorService;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes9.dex */
public final class LiveRichContentConfig$executorServiceProvider$1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f140957a;

    public final ExecutorService a() {
        return (ExecutorService) this.f140957a.getValue();
    }

    public LiveRichContentConfig$executorServiceProvider$1() {
        this.f140957a = LazyKt.lazy(LiveRichContentConfig$executorServiceProvider$1$executor$2.INSTANCE);
    }
}
