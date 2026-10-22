package com.bytedance.android.livesdk.gift.platform.core;

import com.bytedance.android.livesdk.gift.platform.core.scope.service.GiftResourceFileCacheService;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes9.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f130470a = 0;

    static {
    }

    public static float a(String r100) {
        if (r100 != null) goto L9;
        return 0.0f;
    L9:
        return (float) (((double) MathKt.roundToInt((((uy0.b) com.bytedance.android.live.revenue.core.util.f.a(uy0.b.class)).l4(r100) / 1048576.0f) * 10)) / 10.0d);
    L11:
        return 0.0f;
    }

    public static void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "assetMd5");
        GiftResourceFileCacheService r101 = (GiftResourceFileCacheService) com.bytedance.android.live.revenue.core.util.f.a(GiftResourceFileCacheService.class);
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == true) goto L13;
        r101.f131396c.put(r100, r100);
        return;
    L13:
        return;
    L5:
        if (r100.length() == 0) goto L8;
        r102 = false;
        goto L9
    }

    public static void c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "assetPath");
        uy0.b r101 = (uy0.b) com.bytedance.android.live.revenue.core.util.f.a(uy0.b.class);
        String r102 = r101.o(r100);
        r101.J(r100);
        GiftResourceFileCacheService r103 = (GiftResourceFileCacheService) com.bytedance.android.live.revenue.core.util.f.a(GiftResourceFileCacheService.class);
        if (r102 != null) goto L5;
    L8:
        boolean r104 = true;
    L9:
        if (r104 == true) goto L13;
        r103.f131396c.remove(r102);
        return;
    L13:
        return;
    L5:
        if (r102.length() == 0) goto L8;
        r104 = false;
        goto L9
    }
}
