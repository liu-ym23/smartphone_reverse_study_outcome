package com.bytedance.android.gamecp.common.utils;

import com.bytedance.android.gamecp.host_api.model.introducecard.IntroduceCardType;
import com.ss.android.downloadlib.constants.EventConstants;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class s {
    public static final String a(com.bytedance.android.gamecp.host_api.model.introducecard.g r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$getGameId");
        String r101 = r100.f57383c;
        if (r101 == null) goto L17;
        JSONObject r102 = new JSONObject(r101);     // Catch: JSONException -> L6
    L7:
        if (r102 == null) goto L18;
        JSONObject r103 = r102.optJSONObject("game_info");
        if (r103 == null) goto L19;
        String r104 = r103.optString("game_id");
        if (r104 != null) goto L14;
        return "";
    L14:
        return r104;
    L19:
        return "";
    L18:
        return "";
    L6:
        r102 = null;
        goto L7
    L17:
        return "";
    }

    public static final String b(com.bytedance.android.gamecp.host_api.model.introducecard.g r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$getGameName");
        String r101 = r100.f57383c;
        if (r101 == null) goto L17;
        JSONObject r102 = new JSONObject(r101);     // Catch: JSONException -> L6
    L7:
        if (r102 == null) goto L18;
        JSONObject r103 = r102.optJSONObject("game_info");
        if (r103 == null) goto L19;
        String r104 = r103.optString(EventConstants.ExtraJson.GAME_NAME);
        if (r104 != null) goto L14;
        return "";
    L14:
        return r104;
    L19:
        return "";
    L18:
        return "";
    L6:
        r102 = null;
        goto L7
    L17:
        return "";
    }

    public static final boolean c(com.bytedance.android.gamecp.host_api.model.introducecard.g r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isReserved");
        if (r100.f57384d != IntroduceCardType.RESERVE.getType()) goto L9;
        com.bytedance.android.gamecp.host_api.model.introducecard.v r101 = r100.f57389i;
        if (r101 == null) goto L9;
        if (r101.a() != 1) goto L9;
        return true;
    L9:
        return false;
    }
}
