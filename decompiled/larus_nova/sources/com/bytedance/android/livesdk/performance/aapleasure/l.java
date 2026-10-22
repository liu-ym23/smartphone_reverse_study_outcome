package com.bytedance.android.livesdk.performance.aapleasure;

import com.bytedance.android.livesdk.config.f71;
import com.bytedance.android.livesdkapi.service.IPerfBalanceServiceKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f154453a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f71 f154454b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Level f154455c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f154456d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final StrategyScene f154457e;

    public l(StrategyScene r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        this.f154457e = r100;
        this.f154453a = IPerfBalanceServiceKt.PREFIX_RESOURCE + r100.getMask() + "_mode_level";
        this.f154455c = Level.Normal;
        this.f154456d = System.currentTimeMillis();
    }
}
