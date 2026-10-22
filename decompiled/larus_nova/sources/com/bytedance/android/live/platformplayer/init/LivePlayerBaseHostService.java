package com.bytedance.android.live.platformplayer.init;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes46.dex */
public final class LivePlayerBaseHostService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f85498a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f85499b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f85500c;

    public LivePlayerBaseHostService() {
        this.f85498a = "ttliveplayer_";
        this.f85499b = LazyKt.lazy(LivePlayerBaseHostService$alog$2.INSTANCE);
        this.f85500c = LazyKt.lazy(LivePlayerBaseHostService$network$2.INSTANCE);
    }
}
