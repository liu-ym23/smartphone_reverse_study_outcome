package com.bytedance.android.live.liveinteract.videotalk.avatarmix.bitmap;

import android.graphics.Canvas;
import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class MicseatBitmapMakerKt {
    public static final void a(final View r100, Canvas r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$drawToCanvas");
        Intrinsics.checkNotNullParameter(r101, "canvas");
        float r102 = -r100.getScrollX();
        float r103 = -r100.getScrollY();
        Function1<Canvas, Unit> r104 = new MicseatBitmapMakerKt$drawToCanvas$1(r100);
        Intrinsics.checkNotNullParameter(r101, "$this$withTranslation");
        Intrinsics.checkNotNullParameter(r104, "block");
        int r105 = r101.save();
        r101.translate(r102, r103);
        r104.invoke(r101);     // Catch: Throwable -> L6
        r101.restoreToCount(r105);
        return;
    L6:
        th = move-exception;
        r101.restoreToCount(r105);
        throw th;
    }
}
