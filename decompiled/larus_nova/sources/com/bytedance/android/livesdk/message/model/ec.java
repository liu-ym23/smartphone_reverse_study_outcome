package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.gamecp.business.instantplay.InstantPlayContext;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;

/* JADX INFO: loaded from: classes11.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public interface ec extends vh7.c<ec> {
    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "avatar_thumb")
    py.k getAvatarThumb();

    @FieldName(name = InstantPlayContext.NICKNAME)
    String getNickname();

    @FieldName(name = "rank")
    long getRank();

    @FieldName(name = com.bytedance.android.ec.core.event.a.KEY_SCORE)
    long getScore();

    @FieldName(name = "user_id")
    long getUserId();

    @FieldName(name = "user_id_str")
    String getUserIdStr();
}
