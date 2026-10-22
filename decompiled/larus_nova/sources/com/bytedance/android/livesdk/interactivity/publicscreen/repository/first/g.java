package com.bytedance.android.livesdk.interactivity.publicscreen.repository.first;

import com.bytedance.android.livesdk.interactivity.api.monitor.PublicScreenTraceMonitor;
import com.bytedance.android.livesdk.interactivity.api.settings.config.s0;
import java.util.List;
import java.util.concurrent.TimeoutException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import vlc.m;

/* JADX INFO: loaded from: classes9.dex */
public final class g implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f139409a;

    public g(d r100) {
        this.f139409a = r100;
    }

    @Override // vlc.m
    public final void a(List<? extends tlc.d> r100) {
        Intrinsics.checkNotNullParameter(r100, "messages");
        this.f139409a.c("兜底接口请求成功");
        d.a(this.f139409a, r100);
    }

    @Override // vlc.m
    public final void b(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, "error");
        if ((r100 instanceof TimeoutException) == false) goto L5;
        s0 r101 = PublicScreenTraceMonitor.f133304a;
        PublicScreenTraceMonitor.k(-10024, "兜底接口请求超时", r100);
    L6:
        this.f139409a.c("兜底接口请求失败");
        d.a(this.f139409a, CollectionsKt.emptyList());
        return;
    L5:
        s0 r102 = PublicScreenTraceMonitor.f133304a;
        PublicScreenTraceMonitor.k(-10024, "兜底接口请求失败", r100);
        goto L6
    }
}
