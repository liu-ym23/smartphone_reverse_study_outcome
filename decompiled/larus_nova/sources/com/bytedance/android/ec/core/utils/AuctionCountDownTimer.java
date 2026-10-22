package com.bytedance.android.ec.core.utils;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;

/* JADX INFO: loaded from: classes43.dex */
public final class AuctionCountDownTimer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f45502a = null;

    public static final class a {
    }

    static {
        f45502a = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, AuctionCountDownTimer$Companion$INSTANCE$2.INSTANCE);
    }

    public AuctionCountDownTimer() {
    }
}
