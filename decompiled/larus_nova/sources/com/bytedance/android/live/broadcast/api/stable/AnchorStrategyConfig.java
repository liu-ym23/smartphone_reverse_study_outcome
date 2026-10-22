package com.bytedance.android.live.broadcast.api.stable;

import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class AnchorStrategyConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<AbsAnchorFactor<? extends Object>> f59075a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AnchorStrategy f59076b;

    public AnchorStrategyConfig(AnchorStrategy r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        this.f59076b = r100;
        AnchorStrategyConfig$isOpen$1 r101 = AnchorStrategyConfig$isOpen$1.INSTANCE;
        AnchorStrategyConfig$onInit$1 r102 = AnchorStrategyConfig$onInit$1.INSTANCE;
        this.f59075a = new ArrayList();
    }
}
