package com.bytedance.android.livesdk.link.model;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public final class d8 {
    public static final c8.c a(c8 r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$extra");
        c8.c r101 = new c8.c();
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L5
        JSONObject r103 = new JSONObject(r100.getExtraJson());     // Catch: Throwable -> L5
        r101.f147093a = r103.optString("change_status_anchor_name");     // Catch: Throwable -> L5
        r101.f147094b = r103.optString("change_status_anchor_id");     // Catch: Throwable -> L5
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        return r101;
    L5:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }
}
