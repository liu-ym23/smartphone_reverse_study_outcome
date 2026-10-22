package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.ss.android.lark.inv.export.router.InvRouter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002R$\u0010\n\u001a\u0004\u0018\u00010\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\b\u0010\t\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/ua;", "Lvh7/e;", "Lcom/bytedance/android/livesdk/message/model/o9;", "Lcom/bytedance/android/livesdk/chatroom/model/interact/q2;", "getLinkmicSubtitleSettingStatus", "()Lcom/bytedance/android/livesdk/chatroom/model/interact/q2;", "setLinkmicSubtitleSettingStatus", "(Lcom/bytedance/android/livesdk/chatroom/model/interact/q2;)V", "getLinkmicSubtitleSettingStatus$annotations", "()V", "linkmicSubtitleSettingStatus", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
@ForMain
public interface ua extends vh7.e<o9>, o9 {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // com.bytedance.android.livesdk.message.model.o9, vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // com.bytedance.android.livesdk.message.model.o9, vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @Override // vh7.e
    /* synthetic */ Object getFlexInstance();

    @FieldName(name = "linkmic_subtitle_status")
    com.bytedance.android.livesdk.chatroom.model.interact.q2 getLinkmicSubtitleSettingStatus();

    @FieldName(name = InvRouter.VERSION_ID)
    /* synthetic */ long getVersionId();

    @FieldName(name = "linkmic_subtitle_status#setter")
    void setLinkmicSubtitleSettingStatus(com.bytedance.android.livesdk.chatroom.model.interact.q2 r100);
}
