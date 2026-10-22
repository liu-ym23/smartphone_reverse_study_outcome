package com.bytedance.android.live.effect.gift;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;

/* JADX INFO: loaded from: classes45.dex */
public final class GiftEffectResourceServiceHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f68022a = null;

    public static final class a {
        public static e a() {
            return (e) GiftEffectResourceServiceHolder.f68022a.getValue();
        }
    }

    static {
        f68022a = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, GiftEffectResourceServiceHolder$Companion$instance$2.INSTANCE);
    }
}
