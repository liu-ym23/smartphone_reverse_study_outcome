package com.bytedance.android.livesdk.chatroom.interact.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;

/* JADX INFO: loaded from: classes7.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public interface z extends vh7.c<z> {
    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "anchor_layer")
    int getAnchorLayer();

    @FieldName(name = "linkmic_user_settings")
    s getAnchorLinkmicUserSettings();

    @FieldName(name = "game_info")
    t getGameInfo();

    @FieldName(name = "label")
    String getLabel();

    @FieldName(name = "linker_info")
    x getLinkerInfo();

    @FieldName(name = com.bytedance.android.ec.core.event.a.KEY_RECOMMEND_INFO)
    String getRecommendInfo();

    @FieldName(name = "from_server_invite_type")
    int getServerInviteType();

    @FieldName(name = "text")
    String getText();

    @FieldName(name = com.bytedance.android.ec.core.event.a.KEY_TEXT_TYPE)
    int getText_type();
}
