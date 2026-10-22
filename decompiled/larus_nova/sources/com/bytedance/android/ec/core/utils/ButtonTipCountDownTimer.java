package com.bytedance.android.ec.core.utils;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;

/* JADX INFO: loaded from: classes43.dex */
public final class ButtonTipCountDownTimer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f45504a = null;

    public static final class a {
    }

    static {
        f45504a = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, ButtonTipCountDownTimer$Companion$INSTANCE$2.INSTANCE);
    }

    public ButtonTipCountDownTimer() {
    }
}
