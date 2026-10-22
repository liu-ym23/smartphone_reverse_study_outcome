package com.bytedance.android.live.revlink.impl.utils;

import com.bytedance.android.livesdk.link.model.IRivalRankRecommendResponse;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes47.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f97681a = 0;

    static {
    }

    public static boolean a(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "activityId");
        if ((!StringsKt.isBlank(r100)) == false) goto L7;
        if ((!Intrinsics.areEqual(r100, "0")) == false) goto L7;
        return true;
    L7:
        if (r101 == IRivalRankRecommendResponse.LoadType.OnlyCommonPanel.ordinal()) goto L12;
        return false;
    L12:
        return true;
    }

    public static void b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        com.bytedance.android.livesdk.sharedpref.f.d(new com.bytedance.android.livesdk.sharedpref.e(r100, ""), r101);
    }
}
