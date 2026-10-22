package com.bytedance.android.live.base.model.message;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;

/* JADX INFO: loaded from: classes45.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public interface c1 extends vh7.c<c1> {
    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "crown_upgrade")
    boolean crownUpgrade();

    @FieldName(name = "battle_info")
    com.bytedance.android.livesdk.chatroom.model.interact.a0 getBattleInfo();

    @FieldName(name = "crown_upgrade")
    boolean isCrownUpgrade();
}
