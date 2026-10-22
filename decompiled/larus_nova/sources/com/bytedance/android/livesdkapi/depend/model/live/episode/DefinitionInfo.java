package com.bytedance.android.livesdkapi.depend.model.live.episode;

import am3.g;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0004R \u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR \u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/episode/DefinitionInfo;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IDefinitionInfo;", "Ljava/io/Serializable;", "()V", "key", "", "getKey", "()Ljava/lang/String;", "setKey", "(Ljava/lang/String;)V", "text", "getText", "setText", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DefinitionInfo extends FlexModelBase<IDefinitionInfo> implements IDefinitionInfo, h {

    @SerializedName("key")
    protected String key;

    @SerializedName("text")
    protected String text;

    public DefinitionInfo() {
        super(IDefinitionInfo.class);
    }

    public DefinitionInfo(g r100) {
        super(IDefinitionInfo.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this.key = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.text = am3.h.c(r100);
        goto L3
    L9:
        am3.h.d(r103, r100);
        goto L3
    L12:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IDefinitionInfo
    public String getKey() {
        return this.key;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IDefinitionInfo
    public String getText() {
        return this.text;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IDefinitionInfo
    public void setKey(String r100) {
        this.key = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IDefinitionInfo
    public void setText(String r100) {
        this.text = r100;
    }
}
