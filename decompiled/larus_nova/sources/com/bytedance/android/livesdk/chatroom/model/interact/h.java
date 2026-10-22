package com.bytedance.android.livesdk.chatroom.model.interact;

import com.bytedance.android.gamecp.business.instantplay.InstantPlayContext;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public interface h extends vh7.c<h> {
    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "finish_animation")
    py.k getFinishAnimation();

    List<k> getLinkedUserList();

    @FieldName(name = InstantPlayContext.PLAY_ID)
    long getPlayId();

    @FieldName(name = "play_id_str")
    String getPlayIdStr();

    @FieldName(name = "play_mode_status")
    int getPlayModeStatus();

    i getSettingContent();

    @FieldName(name = "start_animation")
    py.k getStartAnimation();
}
