package com.bytedance.android.livesdk.chatroom.model.interact;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;

/* JADX INFO: loaded from: classes7.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public interface d0 extends vh7.c<d0> {
    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "hot_battle_open_animation")
    py.k getHotBattleAnimation();

    @FieldName(name = "open_animation")
    py.k getOpenAnimation();

    @FieldName(name = "score_icon")
    py.k getScoreIcon();

    @FieldName(name = "sprint_open_animation")
    py.k getSprintAnimation();
}
