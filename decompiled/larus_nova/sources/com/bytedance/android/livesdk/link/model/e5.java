package com.bytedance.android.livesdk.link.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.android.cert.manager.constants.EventConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002R\u001e\u0010\t\u001a\u00060\u0003j\u0002`\u00048&X§\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u000e\u001a\u00020\n8&X§\u0004¢\u0006\f\u0012\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\fR\u001e\u0010\u0012\u001a\u00060\u0003j\u0002`\u000f8&X§\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\b\u001a\u0004\b\u0010\u0010\u0006R\u001a\u0010\u0017\u001a\u00020\u00138&X§\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\b\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/e5;", "Lvh7/e;", "Lcom/bytedance/android/livesdk/link/model/bridge/t0;", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/typedef/ChannelId;", "getChannelId", "()J", "getChannelId$annotations", "()V", RemoteMessageConst.Notification.CHANNEL_ID, "", "getPrompt", "()Ljava/lang/String;", "getPrompt$annotations", EventConstant.Key.RETAIN_PROMPT, "Lcom/bytedance/android/livesdkapi/depend/model/live/typedef/BattleId;", "getBattleId", "getBattleId$annotations", "battleId", "", "getInviteType", "()I", "getInviteType$annotations", "inviteType", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface e5 extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.t0>, com.bytedance.android.livesdk.link.model.bridge.t0 {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.t0, vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // com.bytedance.android.livesdk.link.model.bridge.t0, vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "battle_id")
    long getBattleId();

    @FieldName(name = "channel_id")
    long getChannelId();

    /* synthetic */ com.bytedance.android.live.base.model.message.m0 getCommonData();

    @Override // vh7.e
    /* synthetic */ Object getFlexInstance();

    @FieldName(name = "invite_type")
    int getInviteType();

    @FieldName(name = "multiple_again_prompts")
    String getPrompt();

    /* synthetic */ void setCommonData(com.bytedance.android.live.base.model.message.m0 r100);
}
