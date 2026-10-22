package com.bytedance.android.livesdkapi.depend.model.live.episode;

import am3.g;
import com.alibaba.gaiax.model.GXAnimation;
import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.ss.android.dypay.api.DyPayConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import vh7.f;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\n\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002:\u0001!B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0016R&\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR \u0010\u000b\u001a\u0004\u0018\u00010\f8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u00020\u00128\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0017\u001a\u00020\u00188\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001e\u0010\u001d\u001a\u00020\u00188\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001c¨\u0006\""}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/episode/EpisodePremierePlay;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IEpisodePremierePlay;", "()V", "_highlights", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IEpisodeHighLight;", "get_highlights", "()Ljava/util/List;", "set_highlights", "(Ljava/util/List;)V", "playText", "", "getPlayText", "()Ljava/lang/String;", "setPlayText", "(Ljava/lang/String;)V", "playType", "", "getPlayType", "()I", "setPlayType", "(I)V", DyPayConstant.KEY_START_TIME, "", "getStartTime", "()J", "setStartTime", "(J)V", "textDuration", "getTextDuration", "setTextDuration", "getHighlights", "EpisodePremierePlayType", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class EpisodePremierePlay extends FlexModelBase<IEpisodePremierePlay> implements IEpisodePremierePlay, h {

    @IgnoreProtoFieldCheck
    @SerializedName("highlights")
    protected List<? extends IEpisodeHighLight> _highlights;

    @SerializedName("play_text")
    protected String playText;

    @SerializedName("play_type")
    protected int playType;

    @SerializedName(ILoadStallMonitor.START_TIME)
    protected long startTime;

    @SerializedName("text_duration")
    protected long textDuration;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/episode/EpisodePremierePlay$EpisodePremierePlayType;", "", "()V", "HIGHLIGHT", "", "RANDOM", "REALTIME", GXAnimation.STATE_START, "UNKNOWN", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class EpisodePremierePlayType {
        public static final int HIGHLIGHT = 3;
        public static final EpisodePremierePlayType INSTANCE = null;
        public static final int RANDOM = 4;
        public static final int REALTIME = 1;
        public static final int START = 2;
        public static final int UNKNOWN = 0;

        private EpisodePremierePlayType() {
        }

        static {
            INSTANCE = new EpisodePremierePlayType();
        }
    }

    public EpisodePremierePlay() {
        super(IEpisodePremierePlay.class);
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodePremierePlayEx
    public List<IEpisodeHighLight> getHighlights() {
        return this._highlights;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodePremierePlay
    public String getPlayText() {
        return this.playText;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodePremierePlay
    public int getPlayType() {
        return this.playType;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodePremierePlay
    public long getStartTime() {
        return this.startTime;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodePremierePlay
    public long getTextDuration() {
        return this.textDuration;
    }

    public final List<IEpisodeHighLight> get_highlights() {
        return this._highlights;
    }

    public EpisodePremierePlay(g r100) {
        super(IEpisodePremierePlay.class);
        this._highlights = new ArrayList();
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L21;
        g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this._highlights.add(f.a(r100, IEpisodeHighLight.class));
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.playType = r100.i();
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.startTime = r100.j();
        goto L3
    L12:
        if (r102 != 4) goto L14;
        this.playText = am3.h.c(r100);
        goto L3
    L14:
        if (r102 != 5) goto L15;
        this.textDuration = r100.j();
        goto L3
    L15:
        am3.h.d(r103, r100);
        goto L3
    L21:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodePremierePlay
    public void setPlayText(String r100) {
        this.playText = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodePremierePlay
    public void setPlayType(int r100) {
        this.playType = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodePremierePlay
    public void setStartTime(long r100) {
        this.startTime = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodePremierePlay
    public void setTextDuration(long r100) {
        this.textDuration = r100;
    }

    public final void set_highlights(List<? extends IEpisodeHighLight> r100) {
        this._highlights = r100;
    }
}
