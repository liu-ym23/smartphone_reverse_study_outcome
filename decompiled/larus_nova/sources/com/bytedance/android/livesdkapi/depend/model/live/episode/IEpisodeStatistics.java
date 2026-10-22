package com.bytedance.android.livesdkapi.depend.model.live.episode;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u001a\n\u0002\u0010\b\n\u0002\b\u000b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R$\u0010\t\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\"\u0010\u0010\u001a\u00020\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u000f\u0010\b\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0014\u001a\u00020\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0013\u0010\b\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\"\u0010\u0018\u001a\u00020\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0017\u0010\b\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u000eR\"\u0010\u001c\u001a\u00020\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001b\u0010\b\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000eR\"\u0010 \u001a\u00020\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001f\u0010\b\u001a\u0004\b\u001d\u0010\f\"\u0004\b\u001e\u0010\u000eR\"\u0010$\u001a\u00020\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b#\u0010\b\u001a\u0004\b!\u0010\f\"\u0004\b\"\u0010\u000eR\"\u0010+\u001a\u00020%8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b*\u0010\b\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u0010/\u001a\u00020%8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b.\u0010\b\u001a\u0004\b,\u0010'\"\u0004\b-\u0010)¨\u00060"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IEpisodeStatistics;", "Lvh7/c;", "", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "getId$annotations", "()V", "id", "", "getCommentCount", "()J", "setCommentCount", "(J)V", "getCommentCount$annotations", "commentCount", "getDiggCount", "setDiggCount", "getDiggCount$annotations", "diggCount", "getDownloadCount", "setDownloadCount", "getDownloadCount$annotations", "downloadCount", "getPlayCount", "setPlayCount", "getPlayCount$annotations", "playCount", "getShareCount", "setShareCount", "getShareCount$annotations", "shareCount", "getForwardCount", "setForwardCount", "getForwardCount$annotations", "forwardCount", "", "getLoseCount", "()I", "setLoseCount", "(I)V", "getLoseCount$annotations", "loseCount", "getLoseCommentCount", "setLoseCommentCount", "getLoseCommentCount$annotations", "loseCommentCount", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IEpisodeStatistics extends c<IEpisodeStatistics> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "comment_count")
        public static /* synthetic */ void getCommentCount$annotations() {
        }

        @FieldName(name = "digg_count")
        public static /* synthetic */ void getDiggCount$annotations() {
        }

        @FieldName(name = "download_count")
        public static /* synthetic */ void getDownloadCount$annotations() {
        }

        @FieldName(name = "forward_count")
        public static /* synthetic */ void getForwardCount$annotations() {
        }

        @FieldName(name = "id")
        public static /* synthetic */ void getId$annotations() {
        }

        @FieldName(name = "lose_comment_count")
        public static /* synthetic */ void getLoseCommentCount$annotations() {
        }

        @FieldName(name = "lose_count")
        public static /* synthetic */ void getLoseCount$annotations() {
        }

        @FieldName(name = "play_count")
        public static /* synthetic */ void getPlayCount$annotations() {
        }

        @FieldName(name = "share_count")
        public static /* synthetic */ void getShareCount$annotations() {
        }
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "comment_count")
    long getCommentCount();

    @FieldName(name = "digg_count")
    long getDiggCount();

    @FieldName(name = "download_count")
    long getDownloadCount();

    @FieldName(name = "forward_count")
    long getForwardCount();

    @FieldName(name = "id")
    String getId();

    @FieldName(name = "lose_comment_count")
    int getLoseCommentCount();

    @FieldName(name = "lose_count")
    int getLoseCount();

    @FieldName(name = "play_count")
    long getPlayCount();

    @FieldName(name = "share_count")
    long getShareCount();

    @FieldName(name = "comment_count#setter")
    void setCommentCount(long r100);

    @FieldName(name = "digg_count#setter")
    void setDiggCount(long r100);

    @FieldName(name = "download_count#setter")
    void setDownloadCount(long r100);

    @FieldName(name = "forward_count#setter")
    void setForwardCount(long r100);

    @FieldName(name = "id#setter")
    void setId(String r100);

    @FieldName(name = "lose_comment_count#setter")
    void setLoseCommentCount(int r100);

    @FieldName(name = "lose_count#setter")
    void setLoseCount(int r100);

    @FieldName(name = "play_count#setter")
    void setPlayCount(long r100);

    @FieldName(name = "share_count#setter")
    void setShareCount(long r100);
}
