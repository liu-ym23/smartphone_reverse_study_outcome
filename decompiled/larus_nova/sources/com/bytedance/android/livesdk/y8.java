package com.bytedance.android.livesdk;

import com.bytedance.android.livesdk.config.c20;
import com.bytedance.android.livesdk.config.si0;
import com.bytedance.android.livesdk.config.ti0;

/* JADX INFO: loaded from: classes7.dex */
public final class y8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Boolean f162552a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Long f162553b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final boolean f162554c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final boolean f162555d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final long f162556e = 0;

    static {
        f162552a = si0.f121231a.getValue();
        f162553b = ti0.f121302a.getValue();
        c20 r100 = c20.f119917a;
        f162554c = r100.getValue().getEnableSeparatePageLimit();
        f162555d = r100.getValue().getEnableReleaseLowItem();
        f162556e = r100.getValue().getReleaseLowItemDelayTime();
    }
}
