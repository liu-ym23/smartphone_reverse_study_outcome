package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.livesdkapi.config.FastStartLiveConfig;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.Map;

/* JADX INFO: loaded from: classes11.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public interface eb extends vh7.c<eb> {
    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "anchor_show_position")
    int getAnchorShowPosition();

    @FieldName(name = "play_mode_enhance_type")
    int getEnhanceType();

    @FieldName(name = "extra")
    Map<String, String> getExtra();

    @FieldName(name = FastStartLiveConfig.PLAY_MODE)
    int getPlayMode();

    @FieldName(name = "text")
    com.bytedance.android.live.base.model.message.a5 getRichText();

    @FieldName(name = "schema")
    String getSchema();

    @FieldName(name = "toast")
    String getToast();
}
