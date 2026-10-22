package com.bytedance.android.livesdk.config;

import com.bytedance.android.gamecp.business.instantplay.InstantPlayContext;
import com.google.gson.JsonObject;
import com.ss.android.ugc.aweme.discover.model.ScoreTags;
import kotlin.Unit;

/* JADX INFO: loaded from: classes8.dex */
public final class s2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final JsonObject f121177a = null;

    static {
        JsonObject r100 = new JsonObject();
        JsonObject r101 = new JsonObject();
        r101.addProperty("rank", 0);
        r101.addProperty("gap_description", 0);
        r101.addProperty("fixed_footer_description", 0);
        JsonObject r102 = new JsonObject();
        r102.addProperty("id", 0);
        r102.addProperty("sec_uid", 0);
        r102.addProperty(InstantPlayContext.NICKNAME, 0);
        JsonObject r103 = new JsonObject();
        JsonObject r104 = new JsonObject();
        r104.addProperty("_length", 1);
        Unit r105 = Unit.INSTANCE;
        r103.add(ScoreTags.STAR_URL_LIST, r104);
        r102.add("avatar_thumb", r103);
        JsonObject r106 = new JsonObject();
        r106.addProperty("follow_status", 0);
        r102.add("follow_info", r106);
        JsonObject r107 = new JsonObject();
        JsonObject r108 = new JsonObject();
        r108.addProperty("_length", -1);
        r107.add("room_ids", r108);
        r102.add("own_room", r107);
        r101.add("user", r102);
        r100.addProperty("delta_time", 0);
        r100.addProperty("subtitle", 0);
        r100.addProperty("region_name", 0);
        r100.addProperty("rules_url_v2", 0);
        r100.addProperty("charts_description", 0);
        r100.add("anchor_info", r101);
        JsonObject r109 = new JsonObject();
        r109.addProperty("_length", -1);
        r109.add("_filter_keys", r101);
        r100.add("ranks", r109);
        f121177a = r100;
    }

    public static final JsonObject a() {
        return f121177a;
    }
}
