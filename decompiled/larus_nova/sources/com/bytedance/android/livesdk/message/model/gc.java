package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;

/* JADX INFO: loaded from: classes11.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public interface gc extends vh7.c<gc> {
    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "bg_type")
    int getBgType();

    @FieldName(name = "ReviewPass")
    int getReviewPassed();

    @FieldName(name = "show_text")
    String getToastText();

    @FieldName(name = "bg_list")
    IVoiceLiveTheme getVoiceLiveTheme();

    boolean isReviewPassed();

    void setBgType(int r100);
}
