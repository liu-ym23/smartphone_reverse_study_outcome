package com.bytedance.android.live.liveinteract.jsbridge.method;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.web.jsbridge2.CallContext;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
public final class x extends com.bytedance.ies.web.jsbridge2.g<JSONObject, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DataCenter f74262a;

    public x(DataCenter r100) {
        this.f74262a = r100;
    }

    @Override // com.bytedance.ies.web.jsbridge2.g
    public final Object invoke(JSONObject r100, CallContext r101) throws Exception {
        JSONObject r102 = r100;
        String r103 = r102.optString("sec_target_uid");
        String r104 = r102.optString("target_uid");
        IBaseUser r105 = (IBaseUser) vh7.f.c(IBaseUser.class);
        r105.setIdString(r104);
        r105.setCastSecUid(r103);
        DataCenter r106 = this.f74262a;
        if (r106 == null) goto L7;
        r106.put("cmd_video_talk_invite", r105);
        return null;
    L7:
        return null;
    }
}
