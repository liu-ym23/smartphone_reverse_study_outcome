package com.alibaba.gaiax.model;

import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\r\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/alibaba/gaiax/model/GXTextData;", "Lcom/alibaba/gaiax/model/GXData;", "()V", "extendData", "Lorg/json/JSONObject;", "getExtendData", "()Lorg/json/JSONObject;", "setExtendData", "(Lorg/json/JSONObject;)V", "nodeData", "getNodeData", "setNodeData", "text", "", "getText", "()Ljava/lang/CharSequence;", "setText", "(Ljava/lang/CharSequence;)V", "GaiaXAndroidApi_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class GXTextData extends GXData {
    private JSONObject extendData;
    private JSONObject nodeData;
    private CharSequence text;

    public GXTextData() {
    }

    public final JSONObject getExtendData() {
        return this.extendData;
    }

    public final JSONObject getNodeData() {
        return this.nodeData;
    }

    public final CharSequence getText() {
        return this.text;
    }

    public final void setExtendData(JSONObject r100) {
        this.extendData = r100;
    }

    public final void setNodeData(JSONObject r100) {
        this.nodeData = r100;
    }

    public final void setText(CharSequence r100) {
        this.text = r100;
    }
}
