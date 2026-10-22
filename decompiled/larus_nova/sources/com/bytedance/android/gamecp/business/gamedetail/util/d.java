package com.bytedance.android.gamecp.business.gamedetail.util;

import com.bytedance.android.gamecp.business.gamedetail.legacy.viewmodel.AudienceGamePromoteDetailViewModel;
import com.bytedance.live.datacontext.DataContext;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class d {
    static {
    }

    public static JSONObject a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L12
        DataContext r102 = com.bytedance.live.datacontext.d.d(AudienceGamePromoteDetailViewModel.class);     // Catch: Throwable -> L12
        if ((r102 instanceof AudienceGamePromoteDetailViewModel) == true) goto L6;
        r102 = null;
    L6:
        AudienceGamePromoteDetailViewModel r103 = (AudienceGamePromoteDetailViewModel) r102;     // Catch: Throwable -> L12
        if (r103 == null) goto L9;
        JSONObject r104 = r103.getStructure();     // Catch: Throwable -> L12
    L10:
        return b(r104, new Regex(r100));
    L9:
        r104 = null;
    L12:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return null;
    }

    public static JSONObject b(JSONObject r100, Regex r101) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (r100.length() != 0) goto L7;
        return null;
    L7:
        if (r101.matches(r100.optString("id")) == false) goto L9;
        return r100;
    L9:
        JSONArray r102 = r100.optJSONArray("children");
        if (r102 != null) goto L12;
        return null;
    L12:
        if (r102.length() == 0) goto L30;
        int r103 = r102.length();
        int r104 = 0;
    L15:
        if (r104 >= r103) goto L31;
        if ((r102.get(r104) instanceof JSONObject) == false) goto L21;
        JSONObject r105 = b((JSONObject) r102.get(r104), r101);
        if (r105 == null) goto L21;
        return r105;
    L21:
        r104 = r104 + 1;
        goto L15
    L31:
        return null;
    L30:
        return null;
    }
}
