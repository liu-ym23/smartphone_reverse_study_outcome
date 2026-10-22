package com.bytedance.android.shopping.store.tabkit.container;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class i {
    public static final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        dm.a.a("TabKitDialogFragment").i(r100);
    }

    public static final void b(String r100, Type r101, Action r102) {
        Intrinsics.checkNotNullParameter(r101, "type");
        Intrinsics.checkNotNullParameter(r102, "action");
        com.bytedance.android.ec.sdk.helper.g r103 = com.bytedance.android.ec.sdk.helper.g.f48122a;
        JSONObject r104 = new JSONObject();
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L8
        if (r100 != null) goto L6;
        r100 = "";
    L6:
        r104.putOpt("session_id", r100);     // Catch: Throwable -> L8
        r104.putOpt("type", r101.name());     // Catch: Throwable -> L8
        Result.m9449constructorimpl(r104.putOpt("action", r102.name()));     // Catch: Throwable -> L8
    L10:
        Unit r106 = Unit.INSTANCE;
        r103.logV3("ec_tabkit_lite_page_state", r104);
        return;
    L8:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    }
}
