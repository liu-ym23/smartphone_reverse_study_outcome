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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0004R \u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR \u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/episode/EpisodePreviewBottom;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IEpisodePreviewBottom;", "Ljava/io/Serializable;", "()V", "latestPeriodStr", "", "getLatestPeriodStr", "()Ljava/lang/String;", "setLatestPeriodStr", "(Ljava/lang/String;)V", "watchPeriodStr", "getWatchPeriodStr", "setWatchPeriodStr", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class EpisodePreviewBottom extends FlexModelBase<IEpisodePreviewBottom> implements IEpisodePreviewBottom, h {

    @SerializedName("latest_period_str")
    protected String latestPeriodStr;

    @SerializedName("watch_period_str")
    protected String watchPeriodStr;

    public EpisodePreviewBottom() {
        super(IEpisodePreviewBottom.class);
    }

    public EpisodePreviewBottom(g r100) {
        super(IEpisodePreviewBottom.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this.watchPeriodStr = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.latestPeriodStr = am3.h.c(r100);
        goto L3
    L9:
        am3.h.d(r103, r100);
        goto L3
    L12:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodePreviewBottom
    public String getLatestPeriodStr() {
        return this.latestPeriodStr;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodePreviewBottom
    public String getWatchPeriodStr() {
        return this.watchPeriodStr;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodePreviewBottom
    public void setLatestPeriodStr(String r100) {
        this.latestPeriodStr = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodePreviewBottom
    public void setWatchPeriodStr(String r100) {
        this.watchPeriodStr = r100;
    }
}
