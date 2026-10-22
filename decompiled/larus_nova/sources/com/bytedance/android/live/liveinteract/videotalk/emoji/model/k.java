package com.bytedance.android.live.liveinteract.videotalk.emoji.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;

/* JADX INFO: loaded from: classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public interface k extends vh7.c<k> {
    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "emoji")
    List<j> getEmojiList();

    @FieldName(name = "time_control_text")
    String getSendLimitDesc();

    @FieldName(name = "millisecond_level_time_control")
    long getSendLimitTime();
}
