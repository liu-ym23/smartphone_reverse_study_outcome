package com.bytedance.android.annie.util;

import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.view.View;
import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f40054a = 0;

    static {
    }

    public static void a(String r100, View r101) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        Intrinsics.checkNotNullParameter(r101, "grayView");
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L9
        if (Intrinsics.areEqual(UriProtector.getQueryParameter(UriProtector.parse(r100), "gray_enable"), "1") == false) goto L7;
        if (r101 == null) goto L7;
        Paint r103 = new Paint();     // Catch: Throwable -> L9
        ColorMatrix r104 = new ColorMatrix();     // Catch: Throwable -> L9
        r104.setSaturation(0.0f);     // Catch: Throwable -> L9
        r103.setColorFilter(new ColorMatrixColorFilter(r104));     // Catch: Throwable -> L9
        r101.setLayerType(2, r103);     // Catch: Throwable -> L9
    L7:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }
}
