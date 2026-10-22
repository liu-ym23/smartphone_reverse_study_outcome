package com.bytedance.android.livesdk.performance.scene.sleep;

import com.bytedance.android.livesdk.config.i81;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes11.dex */
public final class SleepModeTimePeriodManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f154784a = null;

    public static i81 a() {
        return (i81) f154784a.getValue();
    }

    static {
        f154784a = LazyKt.lazy(SleepModeTimePeriodManager$config$2.INSTANCE);
    }
}
