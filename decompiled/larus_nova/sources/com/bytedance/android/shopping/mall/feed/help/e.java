package com.bytedance.android.shopping.mall.feed.help;

import com.ss.android.common.lib.AppLogNewUtils;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f176995a = 0;

    static {
    }

    public static void a(boolean r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r102, "action");
        Intrinsics.checkNotNullParameter(r103, "pageName");
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L9
        JSONObject r105 = new JSONObject();     // Catch: Throwable -> L9
        if (r100 == false) goto L6;
        int r106 = 1;
    L7:
        r105.putOpt("is_success", Integer.valueOf(r106));     // Catch: Throwable -> L9
        r105.putOpt("error_type", r101);     // Catch: Throwable -> L9
        r105.putOpt("action", r102);     // Catch: Throwable -> L9
        r105.putOpt("page_name", r103);     // Catch: Throwable -> L9
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L9
        AppLogNewUtils.onEventV3("mall_gyl_fetch_by_action", r105);     // Catch: Throwable -> L9
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L9
        return;
    L6:
        r106 = 0;
    L9:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }
}
