package com.bytedance.android.livesdk.castscreen.utils;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes7.dex */
public final class PaidCastManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f104727a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f104728b;

    public PaidCastManager() {
        this.f104727a = LazyKt.lazy(PaidCastManager$castProxy$2.INSTANCE);
        this.f104728b = LazyKt.lazy(new PaidCastManager$proxyConfig$2(this));
    }
}
