package com.bytedance.android.livesdk.interactivity.publicscreen.repository.first;

import com.bytedance.android.livesdk.interactivity.api.monitor.PublicScreenTraceMonitor;
import com.bytedance.android.livesdk.interactivity.api.settings.config.s0;
import io.reactivex.functions.Consumer;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes9.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f139407a;

    public e(d r100) {
        this.f139407a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        s0 r102 = PublicScreenTraceMonitor.f133304a;
        PublicScreenTraceMonitor.k(-10026, "计时器超时，返回空列表", null);
        this.f139407a.c("计时器超时");
        d.a(this.f139407a, CollectionsKt.emptyList());
    }
}
