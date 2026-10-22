package com.bytedance.android.gamecp.business.gamedetail.component.teamplayentrance;

import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import io.reactivex.functions.Function;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class c<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f55106a = null;

    static {
        f55106a = new c();
    }

    public c() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        com.bytedance.android.gamecp.base.network.response.h r101 = (com.bytedance.android.gamecp.base.network.response.h) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        String r102 = "";
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L13
        JSONObject r104 = new JSONObject(JSONObjectProtectorUtils.getString(tv5.a.b(r101.data), "data")).optJSONObject("structure");     // Catch: Throwable -> L13
        if (r104 == null) goto L11;
        JSONObject r105 = r104.optJSONObject("data");     // Catch: Throwable -> L13
        if (r105 == null) goto L11;
        String r106 = r105.toString();     // Catch: Throwable -> L13
        if (r106 == null) goto L11;
        r102 = r106;
    L11:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L13
    L15:
        return r102;
    L13:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L15
    }
}
