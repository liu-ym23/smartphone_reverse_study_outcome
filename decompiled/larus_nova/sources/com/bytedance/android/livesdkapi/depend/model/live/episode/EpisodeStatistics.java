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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000e\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001e\u0010\r\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001e\u0010\u0010\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR \u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0019\u001a\u00020\u001a8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001e\u0010\u001f\u001a\u00020\u001a8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001c\"\u0004\b!\u0010\u001eR\u001e\u0010\"\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0007\"\u0004\b$\u0010\tR\u001e\u0010%\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0007\"\u0004\b'\u0010\t¨\u0006("}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/episode/EpisodeStatistics;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IEpisodeStatistics;", "()V", "commentCount", "", "getCommentCount", "()J", "setCommentCount", "(J)V", "diggCount", "getDiggCount", "setDiggCount", "downloadCount", "getDownloadCount", "setDownloadCount", "forwardCount", "getForwardCount", "setForwardCount", "id", "", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "loseCommentCount", "", "getLoseCommentCount", "()I", "setLoseCommentCount", "(I)V", "loseCount", "getLoseCount", "setLoseCount", "playCount", "getPlayCount", "setPlayCount", "shareCount", "getShareCount", "setShareCount", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class EpisodeStatistics extends FlexModelBase<IEpisodeStatistics> implements IEpisodeStatistics, h {

    @SerializedName("comment_count")
    protected long commentCount;

    @SerializedName("digg_count")
    protected long diggCount;

    @SerializedName("download_count")
    protected long downloadCount;

    @SerializedName("forward_count")
    protected long forwardCount;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    protected String f162618id;

    @SerializedName("lose_comment_count")
    protected int loseCommentCount;

    @SerializedName("lose_count")
    protected int loseCount;

    @SerializedName("play_count")
    protected long playCount;

    @SerializedName("share_count")
    protected long shareCount;

    public EpisodeStatistics() {
        super(IEpisodeStatistics.class);
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeStatistics
    public long getCommentCount() {
        return this.commentCount;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeStatistics
    public long getDiggCount() {
        return this.diggCount;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeStatistics
    public long getDownloadCount() {
        return this.downloadCount;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeStatistics
    public long getForwardCount() {
        return this.forwardCount;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeStatistics
    public String getId() {
        return this.f162618id;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeStatistics
    public int getLoseCommentCount() {
        return this.loseCommentCount;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeStatistics
    public int getLoseCount() {
        return this.loseCount;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeStatistics
    public long getPlayCount() {
        return this.playCount;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeStatistics
    public long getShareCount() {
        return this.shareCount;
    }

    public EpisodeStatistics(g r100) {
        super(IEpisodeStatistics.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L17;
        g.a r103 = decodeExtensionFields(r102, r100);
        switch(r102) {
            case 1: goto L16;
            case 2: goto L15;
            case 3: goto L14;
            case 4: goto L13;
            case 5: goto L12;
            case 6: goto L11;
            case 7: goto L10;
            case 8: goto L9;
            case 9: goto L8;
            default: goto L7;
        };
    L8:
        this.loseCommentCount = r100.i();
        goto L3
    L9:
        this.loseCount = r100.i();
        goto L3
    L10:
        this.forwardCount = r100.j();
        goto L3
    L11:
        this.shareCount = r100.j();
        goto L3
    L12:
        this.playCount = r100.j();
        goto L3
    L13:
        this.downloadCount = r100.j();
        goto L3
    L14:
        this.diggCount = r100.j();
        goto L3
    L15:
        this.commentCount = r100.j();
        goto L3
    L16:
        this.f162618id = am3.h.c(r100);
        goto L3
    L7:
        am3.h.d(r103, r100);
        goto L3
    L17:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeStatistics
    public void setCommentCount(long r100) {
        this.commentCount = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeStatistics
    public void setDiggCount(long r100) {
        this.diggCount = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeStatistics
    public void setDownloadCount(long r100) {
        this.downloadCount = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeStatistics
    public void setForwardCount(long r100) {
        this.forwardCount = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeStatistics
    public void setId(String r100) {
        this.f162618id = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeStatistics
    public void setLoseCommentCount(int r100) {
        this.loseCommentCount = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeStatistics
    public void setLoseCount(int r100) {
        this.loseCount = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeStatistics
    public void setPlayCount(long r100) {
        this.playCount = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeStatistics
    public void setShareCount(long r100) {
        this.shareCount = r100;
    }
}
