package com.bytedance.android.livesdkapi.depend.model.live.episode;

import com.alipay.sdk.m.x.d;
import com.bytedance.android.livesdkapi.depend.model.live.IEpisodePreviewImage;
import com.bytedance.android.livesdkapi.depend.model.live.matchroom.IMatchRoomInfo;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;
import py.k;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\n\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u00022\u00020\u0003R$\u0010\u000b\u001a\u0004\u0018\u00010\u00048&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\u0012\u001a\u0004\u0018\u00010\f8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0011\u0010\n\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0016\u001a\u0004\u0018\u00010\f8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0015\u0010\n\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010R$\u0010\u001d\u001a\u0004\u0018\u00010\u00178&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001c\u0010\n\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010$\u001a\u00020\u001e8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b#\u0010\n\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010(\u001a\u00020\u001e8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b'\u0010\n\u001a\u0004\b%\u0010 \"\u0004\b&\u0010\"R$\u0010,\u001a\u0004\u0018\u00010\f8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b+\u0010\n\u001a\u0004\b)\u0010\u000e\"\u0004\b*\u0010\u0010R$\u00103\u001a\u0004\u0018\u00010-8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b2\u0010\n\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R$\u0010:\u001a\u0004\u0018\u0001048&@&X§\u000e¢\u0006\u0012\u0012\u0004\b9\u0010\n\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\"\u0010>\u001a\u00020\u001e8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b=\u0010\n\u001a\u0004\b;\u0010 \"\u0004\b<\u0010\"R$\u0010B\u001a\u0004\u0018\u00010\f8&@&X§\u000e¢\u0006\u0012\u0012\u0004\bA\u0010\n\u001a\u0004\b?\u0010\u000e\"\u0004\b@\u0010\u0010R$\u0010H\u001a\u0004\u0018\u00010\u001e8&@&X§\u000e¢\u0006\u0012\u0012\u0004\bG\u0010\n\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR$\u0010O\u001a\u0004\u0018\u00010I8&@&X§\u000e¢\u0006\u0012\u0012\u0004\bN\u0010\n\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR$\u0010S\u001a\u0004\u0018\u00010\f8&@&X§\u000e¢\u0006\u0012\u0012\u0004\bR\u0010\n\u001a\u0004\bP\u0010\u000e\"\u0004\bQ\u0010\u0010R6\u0010[\u001a\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010Tj\n\u0012\u0004\u0012\u00020\f\u0018\u0001`U8&@&X§\u000e¢\u0006\u0012\u0012\u0004\bZ\u0010\n\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR$\u0010_\u001a\u0004\u0018\u00010\f8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b^\u0010\n\u001a\u0004\b\\\u0010\u000e\"\u0004\b]\u0010\u0010R$\u0010c\u001a\u0004\u0018\u00010\u00178&@&X§\u000e¢\u0006\u0012\u0012\u0004\bb\u0010\n\u001a\u0004\b`\u0010\u0019\"\u0004\ba\u0010\u001bR\"\u0010j\u001a\u00020d8&@&X§\u000e¢\u0006\u0012\u0012\u0004\bi\u0010\n\u001a\u0004\be\u0010f\"\u0004\bg\u0010hR$\u0010n\u001a\u0004\u0018\u00010\u00178&@&X§\u000e¢\u0006\u0012\u0012\u0004\bm\u0010\n\u001a\u0004\bk\u0010\u0019\"\u0004\bl\u0010\u001bR$\u0010r\u001a\u0004\u0018\u00010\f8&@&X§\u000e¢\u0006\u0012\u0012\u0004\bq\u0010\n\u001a\u0004\bo\u0010\u000e\"\u0004\bp\u0010\u0010R$\u0010v\u001a\u0004\u0018\u00010\f8&@&X§\u000e¢\u0006\u0012\u0012\u0004\bu\u0010\n\u001a\u0004\bs\u0010\u000e\"\u0004\bt\u0010\u0010R6\u0010{\u001a\u0016\u0012\u0004\u0012\u00020w\u0018\u00010Tj\n\u0012\u0004\u0012\u00020w\u0018\u0001`U8&@&X§\u000e¢\u0006\u0012\u0012\u0004\bz\u0010\n\u001a\u0004\bx\u0010W\"\u0004\by\u0010YR\"\u0010\u007f\u001a\u00020\u001e8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b~\u0010\n\u001a\u0004\b|\u0010 \"\u0004\b}\u0010\"R*\u0010\u0085\u0001\u001a\u0004\u0018\u00010w8&@&X§\u000e¢\u0006\u0017\u0012\u0005\b\u0084\u0001\u0010\n\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001\"\u0006\b\u0082\u0001\u0010\u0083\u0001R(\u0010\u0089\u0001\u001a\u0004\u0018\u00010\u00048&@&X§\u000e¢\u0006\u0015\u0012\u0005\b\u0088\u0001\u0010\n\u001a\u0005\b\u0086\u0001\u0010\u0006\"\u0005\b\u0087\u0001\u0010\bR(\u0010\u008d\u0001\u001a\u0004\u0018\u00010-8&@&X§\u000e¢\u0006\u0015\u0012\u0005\b\u008c\u0001\u0010\n\u001a\u0005\b\u008a\u0001\u0010/\"\u0005\b\u008b\u0001\u00101R+\u0010\u0094\u0001\u001a\u0005\u0018\u00010\u008e\u00018&@&X§\u000e¢\u0006\u0017\u0012\u0005\b\u0093\u0001\u0010\n\u001a\u0006\b\u008f\u0001\u0010\u0090\u0001\"\u0006\b\u0091\u0001\u0010\u0092\u0001R!\u0010\u0099\u0001\u001a\u0005\u0018\u00010\u0095\u00018&X§\u0004¢\u0006\u000f\u0012\u0005\b\u0098\u0001\u0010\n\u001a\u0006\b\u0096\u0001\u0010\u0097\u0001R!\u0010\u009e\u0001\u001a\u0005\u0018\u00010\u009a\u00018&X§\u0004¢\u0006\u000f\u0012\u0005\b\u009d\u0001\u0010\n\u001a\u0006\b\u009b\u0001\u0010\u009c\u0001R+\u0010¥\u0001\u001a\u0005\u0018\u00010\u009f\u00018&@&X§\u000e¢\u0006\u0017\u0012\u0005\b¤\u0001\u0010\n\u001a\u0006\b \u0001\u0010¡\u0001\"\u0006\b¢\u0001\u0010£\u0001R(\u0010©\u0001\u001a\u0004\u0018\u00010\u00178&@&X§\u000e¢\u0006\u0015\u0012\u0005\b¨\u0001\u0010\n\u001a\u0005\b¦\u0001\u0010\u0019\"\u0005\b§\u0001\u0010\u001bR+\u0010°\u0001\u001a\u0005\u0018\u00010ª\u00018&@&X§\u000e¢\u0006\u0017\u0012\u0005\b¯\u0001\u0010\n\u001a\u0006\b«\u0001\u0010¬\u0001\"\u0006\b\u00ad\u0001\u0010®\u0001R(\u0010´\u0001\u001a\u0004\u0018\u00010\f8&@&X§\u000e¢\u0006\u0015\u0012\u0005\b³\u0001\u0010\n\u001a\u0005\b±\u0001\u0010\u000e\"\u0005\b²\u0001\u0010\u0010R(\u0010¸\u0001\u001a\u0004\u0018\u00010\f8&@&X§\u000e¢\u0006\u0015\u0012\u0005\b·\u0001\u0010\n\u001a\u0005\bµ\u0001\u0010\u000e\"\u0005\b¶\u0001\u0010\u0010R)\u0010º\u0001\u001a\u00030¹\u00018&@&X§\u000e¢\u0006\u0017\u0012\u0005\b¾\u0001\u0010\n\u001a\u0006\bº\u0001\u0010»\u0001\"\u0006\b¼\u0001\u0010½\u0001R&\u0010Â\u0001\u001a\u00020d8&@&X§\u000e¢\u0006\u0015\u0012\u0005\bÁ\u0001\u0010\n\u001a\u0005\b¿\u0001\u0010f\"\u0005\bÀ\u0001\u0010h¨\u0006Ã\u0001"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IEpisodeExtraInfo;", "Lvh7/c;", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IEpisodeExtraInfoBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IEpisodeExtraInfoEx;", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IBaseEpisodeMod;", "getEpisodeMod", "()Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IBaseEpisodeMod;", "setEpisodeMod", "(Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IBaseEpisodeMod;)V", "getEpisodeMod$annotations", "()V", "episodeMod", "", "getCurrentPeriod", "()Ljava/lang/String;", "setCurrentPeriod", "(Ljava/lang/String;)V", "getCurrentPeriod$annotations", "currentPeriod", "getEpisodeIdStr", "setEpisodeIdStr", "getEpisodeIdStr$annotations", "episodeIdStr", "Lpy/k;", "getCover", "()Lpy/k;", "setCover", "(Lpy/k;)V", "getCover$annotations", "cover", "", "getWatchPeriod", "()J", "setWatchPeriod", "(J)V", "getWatchPeriod$annotations", "watchPeriod", "getLatestPeriod", "setLatestPeriod", "getLatestPeriod$annotations", "latestPeriod", "getTitle", d.f25925o, "getTitle$annotations", "title", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IEpisodeWatchInfo;", "getEpisodeWatchInfo", "()Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IEpisodeWatchInfo;", "setEpisodeWatchInfo", "(Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IEpisodeWatchInfo;)V", "getEpisodeWatchInfo$annotations", "episodeWatchInfo", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IEpisodePremierePlay;", "getFirstShowPlayControl", "()Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IEpisodePremierePlay;", "setFirstShowPlayControl", "(Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IEpisodePremierePlay;)V", "getFirstShowPlayControl$annotations", "firstShowPlayControl", "getId", "setId", "getId$annotations", "id", "getItemId", "setItemId", "getItemId$annotations", "itemId", "getSeasonId", "()Ljava/lang/Long;", "setSeasonId", "(Ljava/lang/Long;)V", "getSeasonId$annotations", "seasonId", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IVSTitleIcon;", "getTitleIcon", "()Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IVSTitleIcon;", "setTitleIcon", "(Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IVSTitleIcon;)V", "getTitleIcon$annotations", "titleIcon", "getRelationPlaceText", "setRelationPlaceText", "getRelationPlaceText$annotations", "relationPlaceText", "", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getOperationPlaceTextList", "()Ljava/util/List;", "setOperationPlaceTextList", "(Ljava/util/List;)V", "getOperationPlaceTextList$annotations", "operationPlaceTextList", "getReleaseTime", "setReleaseTime", "getReleaseTime$annotations", "releaseTime", "getBackground", "setBackground", "getBackground$annotations", "background", "", "getStyle", "()I", "setStyle", "(I)V", "getStyle$annotations", "style", "getSeasonCoverVertical", "setSeasonCoverVertical", "getSeasonCoverVertical$annotations", "seasonCoverVertical", "getShowName", "setShowName", "getShowName$annotations", "showName", "getMultiSeasonTag", "setMultiSeasonTag", "getMultiSeasonTag$annotations", "multiSeasonTag", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IVSCameraInfo;", "getCameraInfos", "setCameraInfos", "getCameraInfos$annotations", "cameraInfos", "getDefaultCameraId", "setDefaultCameraId", "getDefaultCameraId$annotations", "defaultCameraId", "getPriorityCameraInfo", "()Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IVSCameraInfo;", "setPriorityCameraInfo", "(Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IVSCameraInfo;)V", "getPriorityCameraInfo$annotations", "priorityCameraInfo", "getMod", "setMod", "getMod$annotations", "mod", "getSeasonWatchInfo", "setSeasonWatchInfo", "getSeasonWatchInfo$annotations", "seasonWatchInfo", "Lcom/bytedance/android/livesdkapi/depend/model/live/matchroom/IMatchRoomInfo;", "getMatchRoomInfo", "()Lcom/bytedance/android/livesdkapi/depend/model/live/matchroom/IMatchRoomInfo;", "setMatchRoomInfo", "(Lcom/bytedance/android/livesdkapi/depend/model/live/matchroom/IMatchRoomInfo;)V", "getMatchRoomInfo$annotations", "matchRoomInfo", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IMultiTab;", "getMultiTab", "()Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IMultiTab;", "getMultiTab$annotations", "multiTab", "Lcom/bytedance/android/livesdkapi/depend/model/live/IEpisodePreviewImage;", "getPreviewImage", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IEpisodePreviewImage;", "getPreviewImage$annotations", "previewImage", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IEpisodePreviewBottom;", "getPreviewBottom", "()Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IEpisodePreviewBottom;", "setPreviewBottom", "(Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IEpisodePreviewBottom;)V", "getPreviewBottom$annotations", "previewBottom", "getPreviewBackground", "setPreviewBackground", "getPreviewBackground$annotations", "previewBackground", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IVSWatermark;", "getVsWatermark", "()Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IVSWatermark;", "setVsWatermark", "(Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IVSWatermark;)V", "getVsWatermark$annotations", "vsWatermark", "getPublicScreenColor", "setPublicScreenColor", "getPublicScreenColor$annotations", "publicScreenColor", "getPreviewBottomText", "setPreviewBottomText", "getPreviewBottomText$annotations", "previewBottomText", "", "isInteractConfigExist", "()Z", "setInteractConfigExist", "(Z)V", "isInteractConfigExist$annotations", "getShareType", "setShareType", "getShareType$annotations", "shareType", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IEpisodeExtraInfo extends c<IEpisodeExtraInfo>, IEpisodeExtraInfoBase, IEpisodeExtraInfoEx {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "background")
        public static /* synthetic */ void getBackground$annotations() {
        }

        @FieldName(name = "camera_infos")
        public static /* synthetic */ void getCameraInfos$annotations() {
        }

        @FieldName(name = "cover")
        public static /* synthetic */ void getCover$annotations() {
        }

        @FieldName(name = "current_period")
        public static /* synthetic */ void getCurrentPeriod$annotations() {
        }

        @FieldName(name = "default_camera_id")
        public static /* synthetic */ void getDefaultCameraId$annotations() {
        }

        @FieldName(name = "episode_id_str")
        public static /* synthetic */ void getEpisodeIdStr$annotations() {
        }

        @FieldName(name = "episode_mod")
        public static /* synthetic */ void getEpisodeMod$annotations() {
        }

        @FieldName(name = "watch_info")
        public static /* synthetic */ void getEpisodeWatchInfo$annotations() {
        }

        @FieldName(name = "play_control")
        public static /* synthetic */ void getFirstShowPlayControl$annotations() {
        }

        @FieldName(name = "episode_id")
        public static /* synthetic */ void getId$annotations() {
        }

        @FieldName(name = "item_id")
        public static /* synthetic */ void getItemId$annotations() {
        }

        @FieldName(name = "latest_period")
        public static /* synthetic */ void getLatestPeriod$annotations() {
        }

        @FieldName(name = "match_room_info")
        public static /* synthetic */ void getMatchRoomInfo$annotations() {
        }

        @FieldName(name = "mod")
        public static /* synthetic */ void getMod$annotations() {
        }

        @FieldName(name = "multi_season_tag")
        public static /* synthetic */ void getMultiSeasonTag$annotations() {
        }

        @FieldName(name = "multi_tab")
        public static /* synthetic */ void getMultiTab$annotations() {
        }

        @FieldName(name = "operation_place_text_list")
        public static /* synthetic */ void getOperationPlaceTextList$annotations() {
        }

        @FieldName(name = "preview_background")
        public static /* synthetic */ void getPreviewBackground$annotations() {
        }

        @FieldName(name = "preview_bottom")
        public static /* synthetic */ void getPreviewBottom$annotations() {
        }

        @FieldName(name = "preview_bottom_text")
        public static /* synthetic */ void getPreviewBottomText$annotations() {
        }

        @FieldName(name = "preview_image")
        public static /* synthetic */ void getPreviewImage$annotations() {
        }

        @FieldName(name = "priority_camera")
        public static /* synthetic */ void getPriorityCameraInfo$annotations() {
        }

        @FieldName(name = "public_screen_color")
        public static /* synthetic */ void getPublicScreenColor$annotations() {
        }

        @FieldName(name = "relation_place_text")
        public static /* synthetic */ void getRelationPlaceText$annotations() {
        }

        @FieldName(name = "release_time")
        public static /* synthetic */ void getReleaseTime$annotations() {
        }

        @FieldName(name = "season_cover_vertical")
        public static /* synthetic */ void getSeasonCoverVertical$annotations() {
        }

        @FieldName(name = "season_id")
        public static /* synthetic */ void getSeasonId$annotations() {
        }

        @FieldName(name = "season_watch_info")
        public static /* synthetic */ void getSeasonWatchInfo$annotations() {
        }

        @FieldName(name = "share_type")
        public static /* synthetic */ void getShareType$annotations() {
        }

        @FieldName(name = "show_name")
        public static /* synthetic */ void getShowName$annotations() {
        }

        @FieldName(name = "style")
        public static /* synthetic */ void getStyle$annotations() {
        }

        @FieldName(name = "title")
        public static /* synthetic */ void getTitle$annotations() {
        }

        @FieldName(name = "title_icon")
        public static /* synthetic */ void getTitleIcon$annotations() {
        }

        @FieldName(name = "vs_watermark")
        public static /* synthetic */ void getVsWatermark$annotations() {
        }

        @FieldName(name = "watch_period")
        public static /* synthetic */ void getWatchPeriod$annotations() {
        }

        @FieldName(name = "is_interact_config_exist")
        public static /* synthetic */ void isInteractConfigExist$annotations() {
        }
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "background")
    k getBackground();

    @FieldName(name = "camera_infos")
    List<IVSCameraInfo> getCameraInfos();

    @FieldName(name = "cover")
    k getCover();

    @FieldName(name = "current_period")
    String getCurrentPeriod();

    @FieldName(name = "default_camera_id")
    long getDefaultCameraId();

    @FieldName(name = "episode_id_str")
    String getEpisodeIdStr();

    @FieldName(name = "episode_mod")
    IBaseEpisodeMod getEpisodeMod();

    @FieldName(name = "watch_info")
    IEpisodeWatchInfo getEpisodeWatchInfo();

    @FieldName(name = "play_control")
    IEpisodePremierePlay getFirstShowPlayControl();

    @FieldName(name = "episode_id")
    long getId();

    @FieldName(name = "item_id")
    String getItemId();

    @FieldName(name = "latest_period")
    long getLatestPeriod();

    @FieldName(name = "match_room_info")
    IMatchRoomInfo getMatchRoomInfo();

    @FieldName(name = "mod")
    IBaseEpisodeMod getMod();

    @FieldName(name = "multi_season_tag")
    String getMultiSeasonTag();

    @FieldName(name = "multi_tab")
    IMultiTab getMultiTab();

    @FieldName(name = "operation_place_text_list")
    List<String> getOperationPlaceTextList();

    @FieldName(name = "preview_background")
    k getPreviewBackground();

    @FieldName(name = "preview_bottom")
    IEpisodePreviewBottom getPreviewBottom();

    @FieldName(name = "preview_bottom_text")
    String getPreviewBottomText();

    @FieldName(name = "preview_image")
    IEpisodePreviewImage getPreviewImage();

    @FieldName(name = "priority_camera")
    IVSCameraInfo getPriorityCameraInfo();

    @FieldName(name = "public_screen_color")
    String getPublicScreenColor();

    @FieldName(name = "relation_place_text")
    String getRelationPlaceText();

    @FieldName(name = "release_time")
    String getReleaseTime();

    @FieldName(name = "season_cover_vertical")
    k getSeasonCoverVertical();

    @FieldName(name = "season_id")
    Long getSeasonId();

    @FieldName(name = "season_watch_info")
    IEpisodeWatchInfo getSeasonWatchInfo();

    @FieldName(name = "share_type")
    int getShareType();

    @FieldName(name = "show_name")
    String getShowName();

    @FieldName(name = "style")
    int getStyle();

    @FieldName(name = "title")
    String getTitle();

    @FieldName(name = "title_icon")
    IVSTitleIcon getTitleIcon();

    @FieldName(name = "vs_watermark")
    IVSWatermark getVsWatermark();

    @FieldName(name = "watch_period")
    long getWatchPeriod();

    @FieldName(name = "is_interact_config_exist")
    boolean isInteractConfigExist();

    @FieldName(name = "background#setter")
    void setBackground(k r100);

    @FieldName(name = "camera_infos#setter")
    void setCameraInfos(List<? extends IVSCameraInfo> r100);

    @FieldName(name = "cover#setter")
    void setCover(k r100);

    @FieldName(name = "current_period#setter")
    void setCurrentPeriod(String r100);

    @FieldName(name = "default_camera_id#setter")
    void setDefaultCameraId(long r100);

    @FieldName(name = "episode_id_str#setter")
    void setEpisodeIdStr(String r100);

    @FieldName(name = "episode_mod#setter")
    void setEpisodeMod(IBaseEpisodeMod r100);

    @FieldName(name = "watch_info#setter")
    void setEpisodeWatchInfo(IEpisodeWatchInfo r100);

    @FieldName(name = "play_control#setter")
    void setFirstShowPlayControl(IEpisodePremierePlay r100);

    @FieldName(name = "episode_id#setter")
    void setId(long r100);

    @FieldName(name = "is_interact_config_exist#setter")
    void setInteractConfigExist(boolean r100);

    @FieldName(name = "item_id#setter")
    void setItemId(String r100);

    @FieldName(name = "latest_period#setter")
    void setLatestPeriod(long r100);

    @FieldName(name = "match_room_info#setter")
    void setMatchRoomInfo(IMatchRoomInfo r100);

    @FieldName(name = "mod#setter")
    void setMod(IBaseEpisodeMod r100);

    @FieldName(name = "multi_season_tag#setter")
    void setMultiSeasonTag(String r100);

    @FieldName(name = "operation_place_text_list#setter")
    void setOperationPlaceTextList(List<String> r100);

    @FieldName(name = "preview_background#setter")
    void setPreviewBackground(k r100);

    @FieldName(name = "preview_bottom#setter")
    void setPreviewBottom(IEpisodePreviewBottom r100);

    @FieldName(name = "preview_bottom_text#setter")
    void setPreviewBottomText(String r100);

    @FieldName(name = "priority_camera#setter")
    void setPriorityCameraInfo(IVSCameraInfo r100);

    @FieldName(name = "public_screen_color#setter")
    void setPublicScreenColor(String r100);

    @FieldName(name = "relation_place_text#setter")
    void setRelationPlaceText(String r100);

    @FieldName(name = "release_time#setter")
    void setReleaseTime(String r100);

    @FieldName(name = "season_cover_vertical#setter")
    void setSeasonCoverVertical(k r100);

    @FieldName(name = "season_id#setter")
    void setSeasonId(Long r100);

    @FieldName(name = "season_watch_info#setter")
    void setSeasonWatchInfo(IEpisodeWatchInfo r100);

    @FieldName(name = "share_type#setter")
    void setShareType(int r100);

    @FieldName(name = "show_name#setter")
    void setShowName(String r100);

    @FieldName(name = "style#setter")
    void setStyle(int r100);

    @FieldName(name = "title#setter")
    void setTitle(String r100);

    @FieldName(name = "title_icon#setter")
    void setTitleIcon(IVSTitleIcon r100);

    @FieldName(name = "vs_watermark#setter")
    void setVsWatermark(IVSWatermark r100);

    @FieldName(name = "watch_period#setter")
    void setWatchPeriod(long r100);
}
