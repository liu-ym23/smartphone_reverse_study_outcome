package com.bytedance.android.livesdk.performance.aapleasure;

import com.bytedance.android.livesdkapi.service.IPerfBalanceServiceKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f154451a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final StrategyScene f154452b;

    public k(StrategyScene r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        this.f154452b = r100;
        this.f154451a = IPerfBalanceServiceKt.PREFIX_RESOURCE + r100.getMask() + "_mode_level";
    }
}
