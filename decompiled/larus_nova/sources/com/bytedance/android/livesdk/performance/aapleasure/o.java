package com.bytedance.android.livesdk.performance.aapleasure;

import com.bytedance.android.livesdkapi.service.IPerfBalanceServiceKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f154462a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final StrategyScene f154463b;

    public o(StrategyScene r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        this.f154463b = r100;
        this.f154462a = IPerfBalanceServiceKt.PREFIX_RESOURCE + r100.getMask() + "_mode_level";
    }
}
