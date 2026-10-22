package com.bytedance.android.livesdkapi.depend.model.live.episode;

import am3.g;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.tencent.open.SocialConstants;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0010\u001a\u00020\u0005H\u0016R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR \u0010\r\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\t¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/episode/EpisodeWatchInfo;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IEpisodeWatchInfo;", "()V", "count", "", "getCount", "()Ljava/lang/String;", "setCount", "(Ljava/lang/String;)V", "countWithBackup", "getCountWithBackup", "setCountWithBackup", SocialConstants.PARAM_APP_DESC, "getDesc", "setDesc", "toString", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class EpisodeWatchInfo extends FlexModelBase<IEpisodeWatchInfo> implements IEpisodeWatchInfo, h {

    @SerializedName("count")
    protected String count;

    @SerializedName("count_with_backup")
    protected String countWithBackup;

    @SerializedName(SocialConstants.PARAM_APP_DESC)
    protected String desc;

    public EpisodeWatchInfo() {
        super(IEpisodeWatchInfo.class);
    }

    public EpisodeWatchInfo(g r100) {
        super(IEpisodeWatchInfo.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this.desc = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.count = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.countWithBackup = am3.h.c(r100);
        goto L3
    L11:
        am3.h.d(r103, r100);
        goto L3
    L15:
        r100.d(r101);
        setThreadSafe(true);
    }

    public String toString() {
        return "{\"desc\":\"" + getDesc() + "\", \"count\":\"" + getCount() + "\"}";
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeWatchInfo
    public String getCount() {
        return this.count;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeWatchInfo
    public String getCountWithBackup() {
        return this.countWithBackup;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeWatchInfo
    public String getDesc() {
        return this.desc;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeWatchInfo
    public void setCount(String r100) {
        this.count = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeWatchInfo
    public void setCountWithBackup(String r100) {
        this.countWithBackup = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeWatchInfo
    public void setDesc(String r100) {
        this.desc = r100;
    }
}
