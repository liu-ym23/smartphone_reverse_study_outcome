package com.bytedance.android.gamecp.business.gamedetail;

import android.os.Bundle;
import com.bytedance.android.gamecp.common.utils.GameCPSafeConvertUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f55299a = 0;

    static {
    }

    public static String b(Bundle r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$getStringSafe");
        Intrinsics.checkNotNullParameter(r101, "key");
        int r102 = GameCPSafeConvertUtils.f57158a;
        return GameCPSafeConvertUtils.e(r100.get(r101));
    }

    public static Integer a(Bundle r100, String r101, Integer r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$getIntSafe");
        Intrinsics.checkNotNullParameter(r101, "key");
        int r103 = GameCPSafeConvertUtils.f57158a;
        Integer r104 = GameCPSafeConvertUtils.d(r100.get(r101));
        if (r104 != null) goto L6;
        return r102;
    L6:
        return r104;
    }
}
