package com.bytedance.android.livesdk.performance.aapleasure;

import com.bytedance.android.livesdkapi.service.IPerfBalanceServiceKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f154449a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final StrategyScene f154450b;

    public j(StrategyScene r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        this.f154450b = r100;
        this.f154449a = IPerfBalanceServiceKt.PREFIX_RESOURCE + r100.getMask() + "_mode_level";
    }
}
