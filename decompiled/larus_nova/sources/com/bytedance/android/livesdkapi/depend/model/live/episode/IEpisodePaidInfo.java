package com.bytedance.android.livesdkapi.depend.model.live.episode;

import com.bytedance.android.ec.core.event.a;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\"\u0010\t\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\"\u0010\r\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\f\u0010\b\u001a\u0004\b\n\u0010\u0004\"\u0004\b\u000b\u0010\u0006R\"\u0010\u0014\u001a\u00020\u000e8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0013\u0010\b\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0018\u001a\u00020\u000e8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0017\u0010\b\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R$\u0010\u001f\u001a\u0004\u0018\u00010\u00198&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001e\u0010\b\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010!\u001a\u00020 8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b%\u0010\b\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R:\u0010.\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010'\u0018\u00010&j\f\u0012\u0006\u0012\u0004\u0018\u00010'\u0018\u0001`(8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b-\u0010\b\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R:\u00103\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010/\u0018\u00010&j\f\u0012\u0006\u0012\u0004\u0018\u00010/\u0018\u0001`(8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b2\u0010\b\u001a\u0004\b0\u0010*\"\u0004\b1\u0010,¨\u00064"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IEpisodePaidInfo;", "Lvh7/c;", "", "getPaidType", "()I", "setPaidType", "(I)V", "getPaidType$annotations", "()V", "paidType", "getViewRight", "setViewRight", "getViewRight$annotations", "viewRight", "", "getFreeDuration", "()J", "setFreeDuration", "(J)V", "getFreeDuration$annotations", "freeDuration", "getFeedFreeDuration", "setFeedFreeDuration", "getFeedFreeDuration$annotations", "feedFreeDuration", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IEpisodeVideo;", "getVideoInfo", "()Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IEpisodeVideo;", "setVideoInfo", "(Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IEpisodeVideo;)V", "getVideoInfo$annotations", "videoInfo", "", "isDelivery", "()Z", "setDelivery", "(Z)V", "isDelivery$annotations", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IItemDetail;", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getItemsDetail", "()Ljava/util/List;", "setItemsDetail", "(Ljava/util/List;)V", "getItemsDetail$annotations", "itemsDetail", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IVSFreeViewRange;", "getFreeViewRanges", "setFreeViewRanges", "getFreeViewRanges$annotations", "freeViewRanges", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IEpisodePaidInfo extends c<IEpisodePaidInfo> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "feed_duration")
        public static /* synthetic */ void getFeedFreeDuration$annotations() {
        }

        @FieldName(name = "duration")
        public static /* synthetic */ void getFreeDuration$annotations() {
        }

        @FieldName(name = "free_view_ranges")
        public static /* synthetic */ void getFreeViewRanges$annotations() {
        }

        @FieldName(name = "goods_infos_v2")
        public static /* synthetic */ void getItemsDetail$annotations() {
        }

        @FieldName(name = "paid_type")
        public static /* synthetic */ void getPaidType$annotations() {
        }

        @FieldName(name = a.KEY_VIDEO_INFO)
        public static /* synthetic */ void getVideoInfo$annotations() {
        }

        @FieldName(name = "view_right")
        public static /* synthetic */ void getViewRight$annotations() {
        }

        @FieldName(name = "IsDelivery")
        public static /* synthetic */ void isDelivery$annotations() {
        }
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "feed_duration")
    long getFeedFreeDuration();

    @FieldName(name = "duration")
    long getFreeDuration();

    @FieldName(name = "free_view_ranges")
    List<IVSFreeViewRange> getFreeViewRanges();

    @FieldName(name = "goods_infos_v2")
    List<IItemDetail> getItemsDetail();

    @FieldName(name = "paid_type")
    int getPaidType();

    @FieldName(name = a.KEY_VIDEO_INFO)
    IEpisodeVideo getVideoInfo();

    @FieldName(name = "view_right")
    int getViewRight();

    @FieldName(name = "IsDelivery")
    boolean isDelivery();

    @FieldName(name = "IsDelivery#setter")
    void setDelivery(boolean r100);

    @FieldName(name = "feed_duration#setter")
    void setFeedFreeDuration(long r100);

    @FieldName(name = "duration#setter")
    void setFreeDuration(long r100);

    @FieldName(name = "free_view_ranges#setter")
    void setFreeViewRanges(List<? extends IVSFreeViewRange> r100);

    @FieldName(name = "goods_infos_v2#setter")
    void setItemsDetail(List<? extends IItemDetail> r100);

    @FieldName(name = "paid_type#setter")
    void setPaidType(int r100);

    @FieldName(name = "video_info#setter")
    void setVideoInfo(IEpisodeVideo r100);

    @FieldName(name = "view_right#setter")
    void setViewRight(int r100);
}
