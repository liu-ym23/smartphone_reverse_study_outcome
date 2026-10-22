package com.bytedance.android.gamecp.live_impl.card;

import com.bytedance.android.gamecp.host_api.model.introducecard.IntroduceCardType;
import com.bytedance.android.gamecp.host_api.model.introducecard.IntroduceRequestType;
import com.bytedance.android.gamecp.host_api.model.introducecard.IntroduceShowType;
import com.bytedance.android.gamecp.host_api.model.introducecard.v;
import com.ss.android.downloadlib.constants.EventConstants;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class b {
    public static final String a(int r100) {
        if (r100 != 2) goto L5;
        return "im_close_prop";
    L5:
        if (r100 != 3) goto L7;
        return "im_close_reserve";
    L7:
        if (r100 != 4) goto L9;
        return "im_close_mini_game";
    L9:
        if (r100 == 5) goto L11;
        return "im_close_game";
    L11:
        return "im_close_mini_play";
    }

    public static final com.bytedance.android.gamecp.host_api.model.introducecard.g b(a r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$transformGameIntroduceCardItem");
        com.bytedance.android.gamecp.host_api.model.introducecard.g r102 = new com.bytedance.android.gamecp.host_api.model.introducecard.g();
        r102.f57384d = r100.introduceType;
        r102.f57383c = r100.introduceCard;
        r102.f57385e = r100.hasIntroduce;
        String r103 = r100.lynxUrl;
        Intrinsics.checkNotNullParameter(r103, "<set-?>");
        r102.f57392l = r103;
        r102.f57393m = r100.displayInfo;
        if (r101 != IntroduceRequestType.MANUAL.getType()) goto L6;
        IntroduceShowType r104 = IntroduceShowType.MANUAL;
    L15:
        Intrinsics.checkNotNullParameter(r104, "<set-?>");
        r102.f57386f = r104;
        String r105 = r100.introduceCard;
        if (r105 == null) goto L40;
        String r106 = null;
        JSONObject r107 = new JSONObject(r105);     // Catch: JSONException -> L20
    L21:
        if (r107 == null) goto L40;
        JSONObject r108 = r107.optJSONObject("game_info");
        if (r108 == null) goto L26;
        String r109 = r108.optString("game_id");
    L27:
        r102.gameId = r109;
        JSONObject r110 = r107.optJSONObject("game_info");
        if (r110 == null) goto L30;
        r106 = r110.optString(EventConstants.ExtraJson.GAME_NAME);
    L30:
        r102.gameName = r106;
        if (r102.f57384d != IntroduceCardType.PROP.getType()) goto L36;
        JSONObject r111 = r107.optJSONObject("prop");
        if (r111 == null) goto L36;
        com.bytedance.android.gamecp.host_api.model.introducecard.m r112 = new com.bytedance.android.gamecp.host_api.model.introducecard.m();
        r112.propId = r111.optString("prop_id");
        r112.propName = r111.optString("prop_name");
        Unit r113 = Unit.INSTANCE;
        r102.f57388h = r112;
    L36:
        if (r102.f57384d != IntroduceCardType.RESERVE.getType()) goto L40;
        JSONObject r114 = r107.optJSONObject("reserve");
        if (r114 == null) goto L40;
        v r115 = new v();
        r115.b(r114.optInt("reserve_status"));
        Unit r116 = Unit.INSTANCE;
        r102.f57389i = r115;
        goto L40
    L26:
        r109 = null;
    L20:
        r107 = null;
    L40:
        return r102;
    L6:
        if (r101 != IntroduceRequestType.AUTO.getType()) goto L9;
        r104 = IntroduceShowType.AUTO;
        goto L15
    L9:
        if (r101 != IntroduceRequestType.TIMER.getType()) goto L12;
        r104 = IntroduceShowType.TIMER;
        goto L15
    L12:
        if (r101 != IntroduceRequestType.RULE.getType()) goto L14;
        r104 = IntroduceShowType.RULE;
        goto L15
    L14:
        r104 = IntroduceShowType.MANUAL;
        goto L15
    }
}
