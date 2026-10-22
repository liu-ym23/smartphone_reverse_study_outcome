package com.bytedance.android.live.base.model.preview;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.google.gson.annotations.SerializedName;
import com.lynx.jsbridge.LynxResourceModule;

/* JADX INFO: loaded from: classes45.dex */
public class PreviewEndModel {

    @SerializedName(LynxResourceModule.FONT_TYPE)
    public float font;

    @SerializedName(GXTemplateKey.FLEXBOX_MARGIN)
    public float margin;

    public PreviewEndModel() {
    }
}
