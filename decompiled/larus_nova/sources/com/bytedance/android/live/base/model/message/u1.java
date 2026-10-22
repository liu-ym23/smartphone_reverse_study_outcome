package com.bytedance.android.live.base.model.message;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Deprecated;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0014\u0010\u0005\u001a\u00020\u00028gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0016\u0010\t\u001a\u0004\u0018\u00010\u00068gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\r\u001a\u00020\n8gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u000e8gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u00028gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0004R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00068gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\bR\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u00068gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\b¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/live/base/model/message/u1;", "Lvh7/c;", "", "getToUserId", "()J", "toUserId", "", "getToUserIdStr", "()Ljava/lang/String;", "toUserIdStr", "", "getCallReplayStatus", "()I", "callReplayStatus", "Lcom/bytedance/android/livesdk/chatroom/model/interact/g;", "getPairInfo", "()Lcom/bytedance/android/livesdk/chatroom/model/interact/g;", "pairInfo", "getNextCallTime", "nextCallTime", "getInviterRtcExtInfo", "inviterRtcExtInfo", "getInviterLiveCoreInfo", "inviterLiveCoreInfo", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface u1 extends vh7.c<u1> {
    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "status")
    int getCallReplayStatus();

    @FieldName(name = "inviter_live_core_info")
    String getInviterLiveCoreInfo();

    @FieldName(name = "inviter_rtc_ext_info")
    String getInviterRtcExtInfo();

    @FieldName(name = "next_call_time")
    long getNextCallTime();

    @FieldName(name = "pair_info")
    com.bytedance.android.livesdk.chatroom.model.interact.g getPairInfo();

    @FieldName(name = com.bytedance.android.ec.core.event.a.KEY_TO_USER_ID)
    @Deprecated(message = "这个方法仅作为兼容生成给前端json数据使用，不要在native代码使用此方法\n      使用 getToUserIdStr 进行替代！！")
    long getToUserId();

    @FieldName(name = "to_user_id_str")
    String getToUserIdStr();
}
