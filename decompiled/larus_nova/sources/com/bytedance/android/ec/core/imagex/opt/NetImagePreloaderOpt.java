package com.bytedance.android.ec.core.imagex.opt;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;

/* JADX INFO: loaded from: classes43.dex */
public final class NetImagePreloaderOpt implements pi.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f44838a;

    public NetImagePreloaderOpt() {
        this.f44838a = LazyKt.lazy(LazyThreadSafetyMode.NONE, NetImagePreloaderOpt$proxy$2.INSTANCE);
    }
}
