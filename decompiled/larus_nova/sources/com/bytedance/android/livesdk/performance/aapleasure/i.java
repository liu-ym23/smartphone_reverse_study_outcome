package com.bytedance.android.livesdk.performance.aapleasure;

import com.bytedance.android.livesdkapi.service.IPerfBalanceServiceKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f154448a;

    public i(StrategyScene r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        this.f154448a = IPerfBalanceServiceKt.PREFIX_RESOURCE + r100.getMask() + "_mode_level";
    }
}
