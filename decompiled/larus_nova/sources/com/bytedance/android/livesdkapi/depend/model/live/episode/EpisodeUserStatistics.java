package com.bytedance.android.livesdkapi.depend.model.live.episode;

import am3.g;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.ss.ttvideoengine.portrait.PortraitEngine;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/episode/EpisodeUserStatistics;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IEpisodeUserStatistics;", "()V", "watchDuration", "", "getWatchDuration", "()J", "setWatchDuration", "(J)V", "watchRatio", "", "getWatchRatio", "()F", "setWatchRatio", "(F)V", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class EpisodeUserStatistics extends FlexModelBase<IEpisodeUserStatistics> implements IEpisodeUserStatistics, h {

    @SerializedName(PortraitEngine.LABEL_WATCH_DURATION)
    protected long watchDuration;

    @SerializedName("watch_ratio")
    protected float watchRatio;

    public EpisodeUserStatistics() {
        super(IEpisodeUserStatistics.class);
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeUserStatistics
    public long getWatchDuration() {
        return this.watchDuration;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeUserStatistics
    public float getWatchRatio() {
        return this.watchRatio;
    }

    public EpisodeUserStatistics(g r100) {
        super(IEpisodeUserStatistics.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this.watchDuration = r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.watchRatio = Float.intBitsToFloat(r100.g());
        goto L3
    L9:
        am3.h.d(r103, r100);
        goto L3
    L12:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeUserStatistics
    public void setWatchDuration(long r100) {
        this.watchDuration = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeUserStatistics
    public void setWatchRatio(float r100) {
        this.watchRatio = r100;
    }
}
