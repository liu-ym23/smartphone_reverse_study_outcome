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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0004R \u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u00020\f8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u00020\u00128\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/episode/EpisodeStartHighLight;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IEpisodeStartHighLight;", "Ljava/io/Serializable;", "()V", "description", "", "getDescription", "()Ljava/lang/String;", "setDescription", "(Ljava/lang/String;)V", "location", "", "getLocation", "()J", "setLocation", "(J)V", "standard", "", "getStandard", "()Z", "setStandard", "(Z)V", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class EpisodeStartHighLight extends FlexModelBase<IEpisodeStartHighLight> implements IEpisodeStartHighLight, h {

    @SerializedName("description")
    protected String description;

    @SerializedName("location")
    protected long location;

    @SerializedName("standard")
    protected boolean standard;

    public EpisodeStartHighLight() {
        super(IEpisodeStartHighLight.class);
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeStartHighLight
    public String getDescription() {
        return this.description;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeStartHighLight
    public long getLocation() {
        return this.location;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeStartHighLight
    public boolean getStandard() {
        return this.standard;
    }

    public EpisodeStartHighLight(g r100) {
        super(IEpisodeStartHighLight.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this.standard = am3.h.a(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.description = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.location = r100.j();
        goto L3
    L11:
        am3.h.d(r103, r100);
        goto L3
    L15:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeStartHighLight
    public void setDescription(String r100) {
        this.description = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeStartHighLight
    public void setLocation(long r100) {
        this.location = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeStartHighLight
    public void setStandard(boolean r100) {
        this.standard = r100;
    }
}
