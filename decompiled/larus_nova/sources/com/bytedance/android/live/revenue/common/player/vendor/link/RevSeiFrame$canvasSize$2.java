package com.bytedance.android.live.revenue.common.player.vendor.link;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
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
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class RevSeiFrame$canvasSize$2 extends FunctionReferenceImpl implements Function0<Pair<? extends Integer, ? extends Integer>> {
    public RevSeiFrame$canvasSize$2(RevSeiFrame r100) {
        super(0, r100, RevSeiFrame.class, "parseCanvasSize", "parseCanvasSize()Lkotlin/Pair;", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Pair<? extends Integer, ? extends Integer> invoke2() {
        RevSeiFrame r100 = (RevSeiFrame) this.receiver;
        Lazy r101 = RevSeiFrame.D;
        r100.getClass();
        Object r102 = null;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L9
        JSONObject r104 = r100.d();     // Catch: Throwable -> L9
        if (r104 == null) goto L18;
        String r105 = r104.optString("canvas");     // Catch: Throwable -> L9
        if (r105 == null) goto L19;
        JSONObject r106 = new JSONObject(r105);     // Catch: Throwable -> L9
        return TuplesKt.to(Integer.valueOf(r106.optInt("width")), Integer.valueOf(r106.optInt("height")));
    L19:
        return null;
    L18:
        return null;
    L9:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        Object r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r108) == true) goto L15;
        r102 = r108;
    L15:
        return (Pair) r102;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Pair<? extends Integer, ? extends Integer> invoke() {
        return invoke2();
    }
}
