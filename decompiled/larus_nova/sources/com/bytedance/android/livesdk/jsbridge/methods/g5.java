package com.bytedance.android.livesdk.jsbridge.methods;

import com.bytedance.android.live.core.utils.JsonUtil;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdkapi.depend.model.follow.FollowPair;
import com.bytedance.android.livesdkapi.depend.model.live.follow.IFollowPair;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public final class g5 implements n56.c {
    public g5() {
    }

    @Override // n56.c
    public void call(n56.f r100, JSONObject r101) throws Exception {
        int r102 = 0;
        if ("follow".equals(JSONObjectProtectorUtils.getString(r100.f518032d, "type")) == false) goto L17;
        JSONObject r103 = JSONObjectProtectorUtils.getJSONObject(r100.f518032d, "args");
        if (r103 == null) goto L17;
        FollowPair r104 = (FollowPair) JsonUtil.parse(r103.toString(), FollowPair.class);     // Catch: Exception -> L13
        if (r104 == null) goto L10;
        r104.setType(IFollowPair.Type.FromWeb);     // Catch: Exception -> L13
        ((IUserService) jc1.k.f(IUserService.class)).user().z(r104);     // Catch: Exception -> L13
    L10:
        r102 = 1;
    L17:
        r101.put("code", r102);     // Catch: JSONException -> L14
        return;
    }
}
