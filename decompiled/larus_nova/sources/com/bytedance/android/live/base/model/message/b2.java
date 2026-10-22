package com.bytedance.android.live.base.model.message;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00068gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\r\u001a\u0004\u0018\u00010\n8gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u00028gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0004¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/live/base/model/message/b2;", "Lvh7/c;", "", "getFromUserIdString", "()Ljava/lang/String;", "fromUserIdString", "", "getReplayStatus", "()I", "replayStatus", "Lcom/bytedance/android/livesdk/chatroom/model/interact/g;", "getPairInfo", "()Lcom/bytedance/android/livesdk/chatroom/model/interact/g;", "pairInfo", "getInviteSource", "inviteSource", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface b2 extends vh7.c<b2> {
    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    String getFromUserIdString();

    @FieldName(name = "invite_source")
    String getInviteSource();

    @FieldName(name = "pair_info")
    com.bytedance.android.livesdk.chatroom.model.interact.g getPairInfo();

    @FieldName(name = "status")
    int getReplayStatus();
}
