package com.bytedance.android.live.broadcast;

import com.bytedance.android.live.broadcast.effect.EffectHostLiveService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class BroadcastEffectService implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public EffectHostLiveService f58954a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f58955b;

    @Override // com.bytedance.android.live.broadcast.h
    public final EffectHostLiveService a() {
        if (this.f58954a != null) goto L5;
        this.f58954a = new EffectHostLiveService();
    L5:
        EffectHostLiveService r100 = this.f58954a;
        Intrinsics.checkNotNull(r100);
        return r100;
    }

    public BroadcastEffectService() {
        this.f58955b = LazyKt.lazy(BroadcastEffectService$commonService$2.INSTANCE);
    }
}
