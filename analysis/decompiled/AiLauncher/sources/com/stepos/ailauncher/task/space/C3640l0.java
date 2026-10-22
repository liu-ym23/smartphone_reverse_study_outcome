package com.stepos.ailauncher.task.space;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0019\u0010\u0002\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lorg/json/JSONObject;", UxipConstants.f30685x, Const.INTENT_KEY_APIKEY, "(Lorg/json/JSONObject;)Lorg/json/JSONObject;", "task_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.task.space.l0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3640l0 {
    public static final JSONObject a(JSONObject response) {
        kotlin.jvm.internal.p.i(response, "response");
        if (!kotlin.jvm.internal.p.d(response.optString("status"), "success")) {
            return null;
        }
        Object objOpt = response.opt("found");
        if (kotlin.jvm.internal.p.d(objOpt, Boolean.FALSE)) {
            return new JSONObject();
        }
        if (kotlin.jvm.internal.p.d(objOpt, Boolean.TRUE)) {
            return response.optJSONObject("card");
        }
        return null;
    }
}
