package com.bytedance.android.livesdkapi.message;

import com.bytedance.android.live.base.model.message.f5;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public class TextPieceHeart extends FlexModelBase<f5> implements f5 {

    @SerializedName("color")
    String color;

    public TextPieceHeart() {
        super(f5.class);
    }

    @Override // com.bytedance.android.live.base.model.message.f5
    public String getColor() {
        return this.color;
    }

    public void setColor(String r100) {
        this.color = r100;
    }
}
