package com.bytedance.android.livesdk.gift.platform.business.giftwall;

import com.bytedance.android.livesdk.gift.platform.core.giftlist.RevenueImageUrlService;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.ss.android.ugc.aweme.discover.model.ScoreTags;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f129646a = null;

    public f() {
    }

    static {
        f129646a = new f();
    }

    public static void b(Function0 r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        r100.invoke();     // Catch: Throwable -> L5
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Result.Companion r102 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    public static final void a(f r100, JSONObject r101, String r110) {
        r100.getClass();
        JSONArray r102 = JSONObjectProtectorUtils.getJSONArray(r101, ScoreTags.STAR_URL_LIST);
        JSONArray r103 = new JSONArray();
        int r104 = r102.length();
        int r105 = 0;
    L3:
        if (r105 >= r104) goto L18;
        String r106 = JSONArrayProtectorUtils.getString(r102, r105);
        String r107 = null;
        if (StringsKt.endsWith$default(r106, r110, false, 2, null) == false) goto L16;
        int r108 = RevenueImageUrlService.f130574c;
        String r109 = RevenueImageUrlService.a.c(r106, r110, 4);
        if (r109 == null) goto L16;
        if (r109.length() <= 0) goto L11;
        boolean r111 = true;
    L12:
        if (r111 == false) goto L14;
        r107 = r109;
    L14:
        if (r107 == null) goto L16;
        r103.put(r107);
        goto L16
    L11:
        r111 = false;
    L16:
        r105 = r105 + 1;
        goto L3
    L18:
        if (r103.length() <= 0) goto L26;
        r101.put(ScoreTags.STAR_URL_LIST, r103);
        return;
    }
}
