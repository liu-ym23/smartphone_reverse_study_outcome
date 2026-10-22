package com.bytedance.android.live.service.prerequest;

import com.bytedance.android.live.base.model.user.UserProfileDataResp;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import kotlin.Pair;

/* JADX INFO: loaded from: classes47.dex */
public interface a {
    boolean a(String r100);

    void b(String r100);

    boolean c(IRoom r100, UserProfileEvent r101);

    Pair<BaseResponse<UserProfileDataResp, UserProfileDataResp.UserProfileExtra>, Integer> d(String r100);

    void e(String r100, BaseResponse<UserProfileDataResp, UserProfileDataResp.UserProfileExtra> r101);
}
