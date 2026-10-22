package com.bytedance.android.livedress.impl;

import com.bytedance.android.live.profit.util.AssetUtilsKt;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class DressUtils_androidKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f102883a = null;

    static {
        f102883a = LazyKt.lazy(DressUtils_androidKt$assetManager$2.INSTANCE);
    }

    public static void a(long r100, int r101, Function2 r102) {
        Intrinsics.checkNotNullParameter(r102, "callback");
        AssetUtilsKt.a((IAssetsManager) f102883a.getValue(), r100, r101, 1001, r102);
    }
}
