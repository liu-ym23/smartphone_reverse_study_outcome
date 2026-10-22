package com.bytedance.android.livesdk.gift.platform.business.jsbridge.methods;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.livesdk.gift.model.g0;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.google.gson.JsonObject;
import java.util.concurrent.Callable;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public final class n<V> implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ JSONObject f129721a;

    public n(JSONObject r100) {
        this.f129721a = r100;
    }

    @Override // java.util.concurrent.Callable
    public final Pair<g0, JsonObject> call() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L4
        Object r101 = Result.m9449constructorimpl(JSONObjectProtectorUtils.getString(this.f129721a, "gift_extra"));     // Catch: Throwable -> L4
    L7:
        if (Result.m9455isFailureimpl(r101) == false) goto L9;
        r101 = null;
    L9:
        String r102 = (String) r101;
        Object r103 = Result.m9449constructorimpl((JsonObject) GsonHelper.get().fromJson(r102, JsonObject.class));     // Catch: Throwable -> L12
    L14:
        ResultKt.throwOnFailure(r103);
        JsonObject r104 = (JsonObject) r103;
        Object r105 = Result.m9449constructorimpl((g0) GsonHelper.get().fromJson(r102, g0.class));     // Catch: Throwable -> L17
    L19:
        ResultKt.throwOnFailure(r105);
        return new Pair((g0) r105, r104);
    L17:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L12:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L4:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r101 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        return call();
    }
}
