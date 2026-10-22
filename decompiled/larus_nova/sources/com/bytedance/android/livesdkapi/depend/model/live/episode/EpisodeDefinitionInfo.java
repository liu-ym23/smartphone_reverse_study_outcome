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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u000b8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/episode/EpisodeDefinitionInfo;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IEpisodeDefinitionInfo;", "()V", "definition", "", "getDefinition", "()Ljava/lang/String;", "setDefinition", "(Ljava/lang/String;)V", "disable", "", "getDisable", "()I", "setDisable", "(I)V", "fps", "getFps", "setFps", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class EpisodeDefinitionInfo extends FlexModelBase<IEpisodeDefinitionInfo> implements IEpisodeDefinitionInfo, h {

    @SerializedName("definition")
    protected String definition;

    @SerializedName("disable")
    protected int disable;

    @SerializedName("fps")
    protected int fps;

    public EpisodeDefinitionInfo() {
        super(IEpisodeDefinitionInfo.class);
        this.definition = "";
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeDefinitionInfo
    public String getDefinition() {
        return this.definition;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeDefinitionInfo
    public int getDisable() {
        return this.disable;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeDefinitionInfo
    public int getFps() {
        return this.fps;
    }

    public EpisodeDefinitionInfo(g r100) {
        super(IEpisodeDefinitionInfo.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this.definition = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.fps = r100.i();
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.disable = r100.i();
        goto L3
    L11:
        am3.h.d(r103, r100);
        goto L3
    L15:
        r100.d(r101);
        setThreadSafe(true);
        if (this.definition != null) goto L31;
        this.definition = "";
        return;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeDefinitionInfo
    public void setDefinition(String r100) {
        this.definition = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeDefinitionInfo
    public void setDisable(int r100) {
        this.disable = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeDefinitionInfo
    public void setFps(int r100) {
        this.fps = r100;
    }
}
