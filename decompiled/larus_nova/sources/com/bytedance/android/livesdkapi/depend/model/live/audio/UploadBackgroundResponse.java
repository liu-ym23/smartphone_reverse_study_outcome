package com.bytedance.android.livesdkapi.depend.model.live.audio;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public class UploadBackgroundResponse {

    @SerializedName("bg")
    public IVoiceLiveTheme voiceLiveTheme;

    public UploadBackgroundResponse() {
    }
}
