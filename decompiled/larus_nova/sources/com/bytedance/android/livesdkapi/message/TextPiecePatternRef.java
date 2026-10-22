package com.bytedance.android.livesdkapi.message;

import com.bytedance.android.live.base.model.message.g5;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public class TextPiecePatternRef extends FlexModelBase<g5> implements g5 {

    @SerializedName("default_pattern")
    String defaultPattern;

    @SerializedName("key")
    String key;

    public TextPiecePatternRef() {
        super(g5.class);
    }

    @Override // com.bytedance.android.live.base.model.message.g5
    public String getDefaultPattern() {
        return this.defaultPattern;
    }

    @Override // com.bytedance.android.live.base.model.message.g5
    public String getKey() {
        return this.key;
    }

    @Override // com.bytedance.android.live.base.model.message.g5
    public void setDefaultPattern(String r100) {
        this.defaultPattern = r100;
    }

    @Override // com.bytedance.android.live.base.model.message.g5
    public void setKey(String r100) {
        this.key = r100;
    }
}
