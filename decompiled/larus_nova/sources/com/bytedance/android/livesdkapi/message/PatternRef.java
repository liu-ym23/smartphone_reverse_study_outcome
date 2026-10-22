package com.bytedance.android.livesdkapi.message;

import com.bytedance.android.live.base.model.message.p3;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public class PatternRef extends FlexModelBase<p3> implements p3 {

    @SerializedName("default_pattern")
    String defaultPattern;

    @SerializedName("key")
    String key;

    public PatternRef() {
        super(p3.class);
    }

    @Override // com.bytedance.android.live.base.model.message.p3
    public String getDefaultPattern() {
        return this.defaultPattern;
    }

    @Override // com.bytedance.android.live.base.model.message.p3
    public String getKey() {
        return this.key;
    }

    public void setDefaultPattern(String r100) {
        this.defaultPattern = r100;
    }

    public void setKey(String r100) {
        this.key = r100;
    }
}
