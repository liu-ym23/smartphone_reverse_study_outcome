package com.bytedance.android.live.revenue.common.player.utils;

import android.graphics.Matrix;
import android.graphics.RectF;
import com.bytedance.android.livesdk.model.n0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class b {
    public static final RectF a(RectF r100, n0 r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$transformByCrop");
        RectF r102 = new RectF(r100);
        if (r101 != null) goto L5;
        return r102;
    L5:
        float r103 = r101.c() / r101.f();
        float r104 = r101.d() / r101.e();
        float r105 = r101.b() / r101.f();
        float r106 = r101.a() / r101.e();
        Matrix r107 = new Matrix();
        r107.postScale(r105, r106);
        r107.postTranslate(r103, r104);
        r107.mapRect(r102);
        return r102;
    }
}
