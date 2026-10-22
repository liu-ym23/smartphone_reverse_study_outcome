package com.bytedance.android.livesdkapi.depend.model;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u0002*\u00020\u0003¨\u0006\u0004"}, d2 = {"getRenderData", "Lorg/json/JSONObject;", "Lcom/bytedance/revenue/platform/api/core/JSONObject;", "Lcom/bytedance/android/livesdkapi/depend/model/IRenderDataInfoBase;", "revenue-base_saasRelease"}, k = 2, mv = {1, 5, 1})
public final class IRenderDataInfoKt {
    public static final JSONObject getRenderData(IRenderDataInfoBase r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$getRenderData");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L8
        String r102 = r100.getRenderData();     // Catch: Throwable -> L8
        if (r102 != null) goto L6;
        r102 = "";
    L6:
        Object r103 = Result.m9449constructorimpl(new JSONObject(r102));     // Catch: Throwable -> L8
    L11:
        if (Result.m9455isFailureimpl(r103) == false) goto L14;
        r103 = null;
    L14:
        return (JSONObject) r103;
    L8:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
    }
}
