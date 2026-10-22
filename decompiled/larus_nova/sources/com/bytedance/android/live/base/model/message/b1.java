package com.bytedance.android.live.base.model.message;

import com.bytedance.android.livesdkapi.minigame.SeiMessageConst;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;

/* JADX INFO: loaded from: classes45.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public interface b1 extends vh7.c<b1> {
    public static final int GUEST_BATTLE_CREATE = 1;
    public static final int GUEST_BATTLE_FINISH = 4;
    public static final int GUEST_BATTLE_NONE = 0;
    public static final int GUEST_BATTLE_PAUSE = 5;
    public static final int GUEST_BATTLE_RESUME = 6;
    public static final int GUEST_BATTLE_SHOW_RESULT = 3;
    public static final int GUEST_BATTLE_UPDATE = 2;

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "battle_info")
    com.bytedance.android.livesdk.chatroom.model.interact.a0 getBattleInfo();

    @FieldName(name = "finish_content")
    a1 getFinishContent();

    @FieldName(name = "finish_toast")
    String getFinishToast();

    @FieldName(name = SeiMessageConst.MSG_TYPE)
    int getMsgType();

    @FieldName(name = "update_content")
    d1 getUpdateContent();
}
