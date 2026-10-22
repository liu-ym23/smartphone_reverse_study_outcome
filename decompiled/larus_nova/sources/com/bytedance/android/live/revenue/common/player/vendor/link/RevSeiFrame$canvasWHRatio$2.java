package com.bytedance.android.live.revenue.common.player.vendor.link;

import com.bytedance.android.livesdk.model.n0;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0007\n\u0000\u0010\u0000\u001a\u00020\u0001¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class RevSeiFrame$canvasWHRatio$2 extends FunctionReferenceImpl implements Function0<Float> {
    public RevSeiFrame$canvasWHRatio$2(RevSeiFrame r100) {
        super(0, r100, RevSeiFrame.class, "parseCanvasWHRatio", "parseCanvasWHRatio()F", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final float invoke2() {
        RevSeiFrame r100 = (RevSeiFrame) this.receiver;
        Lazy r101 = RevSeiFrame.D;
        r100.getClass();
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L11
        n0 r103 = r100.g();     // Catch: Throwable -> L11
        if (r103 != null) goto L8;
        Pair r104 = (Pair) r100.f90934q.getValue();     // Catch: Throwable -> L11
        if (r104 != null) goto L9;
        r104 = TuplesKt.to(1, 1);     // Catch: Throwable -> L11
    L9:
        return (((Number) r104.component1()).intValue() * 1.0f) / ((Number) r104.component2()).intValue();
    L8:
        r104 = TuplesKt.to(Integer.valueOf(r103.f()), Integer.valueOf(r103.e()));     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Object r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Float r107 = Float.valueOf(1.0f);
        if (Result.m9455isFailureimpl(r106) == false) goto L16;
        r106 = r107;
    L16:
        return ((Number) r106).floatValue();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Float invoke() {
        return Float.valueOf(invoke2());
    }
}
