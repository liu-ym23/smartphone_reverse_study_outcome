package com.bytedance.android.live.revenue.common.player.vendor.link;

import com.bytedance.android.livesdk.model.n0;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0007\n\u0000\u0010\u0000\u001a\u00020\u0001¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class RevSeiFrame$canvasWHRadioForScreenRecord$2 extends FunctionReferenceImpl implements Function0<Float> {
    public RevSeiFrame$canvasWHRadioForScreenRecord$2(RevSeiFrame r100) {
        super(0, r100, RevSeiFrame.class, "parseCanvasWHRatioForScreenRecord", "parseCanvasWHRatioForScreenRecord()F", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final float invoke2() {
        RevSeiFrame r100 = (RevSeiFrame) this.receiver;
        Lazy r101 = RevSeiFrame.D;
        r100.getClass();
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L39
        n0 r103 = r100.g();     // Catch: Throwable -> L39
        if (r103 != null) goto L8;
        Pair r104 = (Pair) r100.f90934q.getValue();     // Catch: Throwable -> L39
        if (r104 != null) goto L9;
        r104 = TuplesKt.to(1, 1);     // Catch: Throwable -> L39
    L9:
        int r105 = ((Number) r104.component1()).intValue();     // Catch: Throwable -> L39
        int r106 = ((Number) r104.component2()).intValue();     // Catch: Throwable -> L39
        JSONObject r107 = r100.d();     // Catch: Throwable -> L39
        String r108 = "";
        if (r107 == null) goto L16;
        Object r109 = r107.get("game_clip");     // Catch: Throwable -> L39
        if (r109 == null) goto L16;
        String r110 = r109.toString();     // Catch: Throwable -> L39
        if (r110 == null) goto L16;
    L17:
        Object r111 = new JSONObject(r110).get("w");     // Catch: Throwable -> L39
        if (r111 == null) goto L22;
        String r112 = r111.toString();     // Catch: Throwable -> L39
        if (r112 == null) goto L22;
        float r113 = CastFloatProtector.parseFloat(r112);     // Catch: Throwable -> L39
    L23:
        JSONObject r114 = r100.d();     // Catch: Throwable -> L39
        if (r114 == null) goto L31;
        Object r115 = r114.get("game_clip");     // Catch: Throwable -> L39
        if (r115 == null) goto L31;
        String r116 = r115.toString();     // Catch: Throwable -> L39
        if (r116 == null) goto L31;
        r108 = r116;
    L31:
        Object r117 = new JSONObject(r108).get("h");     // Catch: Throwable -> L39
        if (r117 == null) goto L37;
        String r118 = r117.toString();     // Catch: Throwable -> L39
        if (r118 == null) goto L37;
        float r119 = CastFloatProtector.parseFloat(r118);     // Catch: Throwable -> L39
    L47:
        return ((r105 * r113) * 1.0f) / (r106 * r119);
    L37:
        r119 = 1.0f;
    L22:
        r113 = 1.0f;
    L16:
        r110 = "";
        goto L17
    L8:
        r104 = TuplesKt.to(Integer.valueOf(r103.f()), Integer.valueOf(r103.e()));     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        Result.Companion r120 = Result.Companion;
        Object r121 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Float r122 = Float.valueOf(1.0f);
        if (Result.m9455isFailureimpl(r121) == false) goto L44;
        r121 = r122;
    L44:
        return ((Number) r121).floatValue();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Float invoke() {
        return Float.valueOf(invoke2());
    }
}
