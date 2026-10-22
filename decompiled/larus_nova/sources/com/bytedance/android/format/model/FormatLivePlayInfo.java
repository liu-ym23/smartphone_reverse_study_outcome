package com.bytedance.android.format.model;

import com.bytedance.android.gamecp.business.instantplay.InstantPlayContext;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.google.gson.annotations.SerializedName;
import com.larus.avlink.aiproactive.AiProactiveTaskViewModel;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import com.ss.ttvideoengine.ITTVideoEngineEventSource;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000Ò\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0007\u0018\u00002\u00020\u0001: ¹\u0001º\u0001»\u0001¼\u0001½\u0001¾\u0001¿\u0001À\u0001Á\u0001Â\u0001Ã\u0001Ä\u0001Å\u0001Æ\u0001Ç\u0001È\u0001B\t¢\u0006\u0006\b·\u0001\u0010¸\u0001J\u0006\u0010\u0003\u001a\u00020\u0002R$\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\f\u001a\u00020\u000b8\u0006X\u0087D¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000b8\u0006X\u0087D¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000fR\u001a\u0010\u0013\u001a\u00020\u00128\u0006X\u0087D¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001c\u0010\"\u001a\u0004\u0018\u00010!8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R0\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010&8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R*\u0010/\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010-8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R$\u00106\u001a\u0004\u0018\u0001058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R$\u0010=\u001a\u0004\u0018\u00010<8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR$\u0010C\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bC\u0010\u0006\u001a\u0004\bD\u0010\b\"\u0004\bE\u0010\nR$\u0010G\u001a\u0004\u0018\u00010F8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\"\u0010N\u001a\u00020M8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bN\u0010O\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR$\u0010T\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bT\u0010U\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR\"\u0010Z\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bZ\u0010\r\u001a\u0004\b[\u0010\u000f\"\u0004\b\\\u0010]R$\u0010_\u001a\u0004\u0018\u00010^8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b_\u0010`\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dR*\u0010f\u001a\n\u0012\u0004\u0012\u00020e\u0018\u00010-8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bf\u00100\u001a\u0004\bg\u00102\"\u0004\bh\u00104R$\u0010j\u001a\u0004\u0018\u00010i8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bj\u0010k\u001a\u0004\bl\u0010m\"\u0004\bn\u0010oR*\u0010q\u001a\n\u0012\u0004\u0012\u00020p\u0018\u00010-8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bq\u00100\u001a\u0004\br\u00102\"\u0004\bs\u00104R$\u0010t\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bt\u0010u\u001a\u0004\bv\u0010w\"\u0004\bx\u0010yR\"\u0010z\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bz\u0010\r\u001a\u0004\b{\u0010\u000f\"\u0004\b|\u0010]R&\u0010~\u001a\u00020}8\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0004\b~\u0010\u007f\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001\"\u0006\b\u0082\u0001\u0010\u0083\u0001R/\u0010\u0085\u0001\u001a\u000b\u0012\u0005\u0012\u00030\u0084\u0001\u0018\u00010-8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u0085\u0001\u00100\u001a\u0005\b\u0086\u0001\u00102\"\u0005\b\u0087\u0001\u00104R+\u0010\u0088\u0001\u001a\u0004\u0018\u00010}8\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b\u0088\u0001\u0010\u0089\u0001\u001a\u0006\b\u008a\u0001\u0010\u008b\u0001\"\u0006\b\u008c\u0001\u0010\u008d\u0001R,\u0010\u008f\u0001\u001a\u0005\u0018\u00010\u008e\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b\u008f\u0001\u0010\u0090\u0001\u001a\u0006\b\u0091\u0001\u0010\u0092\u0001\"\u0006\b\u0093\u0001\u0010\u0094\u0001R,\u0010\u0096\u0001\u001a\u0005\u0018\u00010\u0095\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b\u0096\u0001\u0010\u0097\u0001\u001a\u0006\b\u0098\u0001\u0010\u0099\u0001\"\u0006\b\u009a\u0001\u0010\u009b\u0001R,\u0010\u009d\u0001\u001a\u0005\u0018\u00010\u009c\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b\u009d\u0001\u0010\u009e\u0001\u001a\u0006\b\u009f\u0001\u0010 \u0001\"\u0006\b¡\u0001\u0010¢\u0001R/\u0010¤\u0001\u001a\u000b\u0012\u0005\u0012\u00030£\u0001\u0018\u00010-8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b¤\u0001\u00100\u001a\u0005\b¥\u0001\u00102\"\u0005\b¦\u0001\u00104R(\u0010§\u0001\u001a\u00020}8\u0006@\u0006X\u0087\u000e¢\u0006\u0017\n\u0005\b§\u0001\u0010\u007f\u001a\u0006\b§\u0001\u0010\u0081\u0001\"\u0006\b¨\u0001\u0010\u0083\u0001R(\u0010©\u0001\u001a\u00020}8\u0006@\u0006X\u0087\u000e¢\u0006\u0017\n\u0005\b©\u0001\u0010\u007f\u001a\u0006\bª\u0001\u0010\u0081\u0001\"\u0006\b«\u0001\u0010\u0083\u0001R,\u0010\u00ad\u0001\u001a\u0005\u0018\u00010¬\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b\u00ad\u0001\u0010®\u0001\u001a\u0006\b¯\u0001\u0010°\u0001\"\u0006\b±\u0001\u0010²\u0001R/\u0010´\u0001\u001a\u000b\u0012\u0005\u0012\u00030³\u0001\u0018\u00010-8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b´\u0001\u00100\u001a\u0005\bµ\u0001\u00102\"\u0005\b¶\u0001\u00104¨\u0006É\u0001"}, d2 = {"Lcom/bytedance/android/format/model/FormatLivePlayInfo;", "Ljava/io/Serializable;", "", "getProductionName", "Lcom/bytedance/android/format/model/FormatLivePlayInfo$VideoItem;", "videoItem", "Lcom/bytedance/android/format/model/FormatLivePlayInfo$VideoItem;", "getVideoItem", "()Lcom/bytedance/android/format/model/FormatLivePlayInfo$VideoItem;", "setVideoItem", "(Lcom/bytedance/android/format/model/FormatLivePlayInfo$VideoItem;)V", "", "taskType", "I", "getTaskType", "()I", "playType", "getPlayType", "", "avatarUid", "J", "getAvatarUid", "()J", "Lcom/bytedance/android/format/model/FormatLivePlayInfo$Product;", "product", "Lcom/bytedance/android/format/model/FormatLivePlayInfo$Product;", "getProduct", "()Lcom/bytedance/android/format/model/FormatLivePlayInfo$Product;", "Lcom/bytedance/android/format/model/FormatLivePlayInfo$TextData;", "openingChat", "Lcom/bytedance/android/format/model/FormatLivePlayInfo$TextData;", "getOpeningChat", "()Lcom/bytedance/android/format/model/FormatLivePlayInfo$TextData;", "Lcom/bytedance/android/format/model/FormatLivePlayInfo$FollowRelation;", "followRelation", "Lcom/bytedance/android/format/model/FormatLivePlayInfo$FollowRelation;", "getFollowRelation", "()Lcom/bytedance/android/format/model/FormatLivePlayInfo$FollowRelation;", "", "extra", "Ljava/util/Map;", "getExtra", "()Ljava/util/Map;", "setExtra", "(Ljava/util/Map;)V", "", "Lcom/bytedance/android/format/model/FormatLiveRoom$TimelineEvent;", "playTimeLine", "Ljava/util/List;", "getPlayTimeLine", "()Ljava/util/List;", "setPlayTimeLine", "(Ljava/util/List;)V", "Lcom/bytedance/android/format/model/h;", "interactPlayData", "Lcom/bytedance/android/format/model/h;", "getInteractPlayData", "()Lcom/bytedance/android/format/model/h;", "setInteractPlayData", "(Lcom/bytedance/android/format/model/h;)V", "Lcom/bytedance/android/format/model/FormatUser;", "author", "Lcom/bytedance/android/format/model/FormatUser;", "getAuthor", "()Lcom/bytedance/android/format/model/FormatUser;", "setAuthor", "(Lcom/bytedance/android/format/model/FormatUser;)V", "loadVideo", "getLoadVideo", "setLoadVideo", "Lcom/bytedance/android/format/model/FormatLivePlayInfo$MediaModel;", "loadVideoCoverModel", "Lcom/bytedance/android/format/model/FormatLivePlayInfo$MediaModel;", "getLoadVideoCoverModel", "()Lcom/bytedance/android/format/model/FormatLivePlayInfo$MediaModel;", "setLoadVideoCoverModel", "(Lcom/bytedance/android/format/model/FormatLivePlayInfo$MediaModel;)V", "", "backgroundVolumeAvoidance", FaceService.girlLabel, "getBackgroundVolumeAvoidance", "()F", "setBackgroundVolumeAvoidance", "(F)V", "playName", "Ljava/lang/String;", "getPlayName", "()Ljava/lang/String;", "setPlayName", "(Ljava/lang/String;)V", "playStatus", "getPlayStatus", "setPlayStatus", "(I)V", "Lcom/bytedance/android/format/model/FormatLivePlayInfo$GameCardConfig;", "gameCardConfig", "Lcom/bytedance/android/format/model/FormatLivePlayInfo$GameCardConfig;", "getGameCardConfig", "()Lcom/bytedance/android/format/model/FormatLivePlayInfo$GameCardConfig;", "setGameCardConfig", "(Lcom/bytedance/android/format/model/FormatLivePlayInfo$GameCardConfig;)V", "Lcom/bytedance/android/format/model/FormatLivePlayInfo$VfxResource;", "vfxResources", "getVfxResources", "setVfxResources", "Lcom/bytedance/android/format/model/m;", "carouselComponents", "Lcom/bytedance/android/format/model/m;", "getCarouselComponents", "()Lcom/bytedance/android/format/model/m;", "setCarouselComponents", "(Lcom/bytedance/android/format/model/m;)V", "Lcom/bytedance/android/format/model/FormatLivePlayInfo$RelatedPlayInfo;", "relatedPlayInfoList", "getRelatedPlayInfoList", "setRelatedPlayInfoList", "expireInterval", "Ljava/lang/Long;", "getExpireInterval", "()Ljava/lang/Long;", "setExpireInterval", "(Ljava/lang/Long;)V", "productType", "getProductType", "setProductType", "", "showXplayChargeButton", "Z", "getShowXplayChargeButton", "()Z", "setShowXplayChargeButton", "(Z)V", "Lcom/bytedance/android/format/model/SingleSong;", "bgmList", "getBgmList", "setBgmList", "disableDiary", "Ljava/lang/Boolean;", "getDisableDiary", "()Ljava/lang/Boolean;", "setDisableDiary", "(Ljava/lang/Boolean;)V", "Lcom/bytedance/android/format/model/FormatLivePlayInfo$AiGroupPhoto;", "aiGroupPhoto", "Lcom/bytedance/android/format/model/FormatLivePlayInfo$AiGroupPhoto;", "getAiGroupPhoto", "()Lcom/bytedance/android/format/model/FormatLivePlayInfo$AiGroupPhoto;", "setAiGroupPhoto", "(Lcom/bytedance/android/format/model/FormatLivePlayInfo$AiGroupPhoto;)V", "Lcom/bytedance/android/format/model/FormatLivePlayInfo$BusinessAdDressInfo;", "businessAdDressInfo", "Lcom/bytedance/android/format/model/FormatLivePlayInfo$BusinessAdDressInfo;", "getBusinessAdDressInfo", "()Lcom/bytedance/android/format/model/FormatLivePlayInfo$BusinessAdDressInfo;", "setBusinessAdDressInfo", "(Lcom/bytedance/android/format/model/FormatLivePlayInfo$BusinessAdDressInfo;)V", "Lcom/bytedance/android/format/model/FormatLivePlayInfo$CsrInfo;", "csrInfo", "Lcom/bytedance/android/format/model/FormatLivePlayInfo$CsrInfo;", "getCsrInfo", "()Lcom/bytedance/android/format/model/FormatLivePlayInfo$CsrInfo;", "setCsrInfo", "(Lcom/bytedance/android/format/model/FormatLivePlayInfo$CsrInfo;)V", "Lcom/bytedance/android/format/model/i;", "csrResources", "getCsrResources", "setCsrResources", "isUgc", "setUgc", "enableShare", "getEnableShare", "setEnableShare", "Lcom/bytedance/android/format/model/FormatLivePlayInfo$PreviewDefaultSeletionData;", "previewDefaultSelectionData", "Lcom/bytedance/android/format/model/FormatLivePlayInfo$PreviewDefaultSeletionData;", "getPreviewDefaultSelectionData", "()Lcom/bytedance/android/format/model/FormatLivePlayInfo$PreviewDefaultSeletionData;", "setPreviewDefaultSelectionData", "(Lcom/bytedance/android/format/model/FormatLivePlayInfo$PreviewDefaultSeletionData;)V", "Lcom/bytedance/android/format/model/FormatLivePlayInfo$ActivityPageConfig;", "activityPageConfigDatas", "getActivityPageConfigDatas", "setActivityPageConfigDatas", "<init>", "()V", "ActivityPageConfig", "AiGroupPhoto", "BusinessAdDressInfo", "CsrInfo", "FollowRelation", "GameCardConfig", "MediaModel", "PlayStatus", "PreviewDefaultSeletionData", "Product", "RelatedPlayInfo", "TaskType", "TextData", "VfxResource", "VideoItem", "WordTimestamp", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FormatLivePlayInfo implements Serializable {

    @SerializedName("activity_page_config_datas")
    private List<ActivityPageConfig> activityPageConfigDatas;

    @SerializedName("ai_group_photo")
    private AiGroupPhoto aiGroupPhoto;

    @SerializedName("author")
    private FormatUser author;

    @SerializedName("avatar_uid")
    private final long avatarUid;

    @SerializedName("background_volume_avoidance")
    private float backgroundVolumeAvoidance;

    @SerializedName("bgm_list")
    private List<SingleSong> bgmList;

    @SerializedName("business_ad_dress_info")
    private BusinessAdDressInfo businessAdDressInfo;

    @SerializedName("carousel_component_info")
    private m carouselComponents;

    @SerializedName("csr_info")
    private CsrInfo csrInfo;

    @SerializedName("csr_resources")
    private List<i> csrResources;

    @SerializedName("disable_diary")
    private Boolean disableDiary;

    @SerializedName(AppConstants.BUNDLE_ENABLE_SHARE)
    private boolean enableShare;

    @SerializedName("expire_interval")
    private Long expireInterval;

    @SerializedName("extra")
    private Map<String, String> extra;

    @SerializedName("follow_relation")
    private final FollowRelation followRelation;

    @SerializedName("game_card_config")
    private GameCardConfig gameCardConfig;

    @SerializedName("play_data")
    private h interactPlayData;

    @SerializedName("is_ugc")
    private boolean isUgc;

    @SerializedName("resource_loading_video")
    private VideoItem loadVideo;

    @SerializedName("resource_loading_image")
    private MediaModel loadVideoCoverModel;

    @SerializedName("opening_chat")
    private final TextData openingChat;

    @SerializedName("play_name")
    private String playName;

    @SerializedName("play_status")
    private int playStatus;

    @SerializedName("play_timeline")
    private List<FormatLiveRoom.TimelineEvent> playTimeLine;

    @SerializedName("play_type")
    private final int playType;

    @SerializedName("preview_default_seletion_data")
    private PreviewDefaultSeletionData previewDefaultSelectionData;

    @SerializedName("product")
    private final Product product;

    @SerializedName("product_type")
    private int productType;

    @SerializedName("related_play_info_list")
    private List<RelatedPlayInfo> relatedPlayInfoList;
    private boolean showXplayChargeButton;

    @SerializedName(AiProactiveTaskViewModel.PARAM_TASK_TYPE)
    private final int taskType;

    @SerializedName("vfx_resources")
    private List<VfxResource> vfxResources;

    @SerializedName("video_item")
    private VideoItem videoItem;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010$\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0018\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR \u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR,\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R \u0010\u0018\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR \u0010\u001b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR \u0010\u001e\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR\"\u0010!\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010'\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R \u0010(\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0006\"\u0004\b*\u0010\bR\"\u0010+\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010'\u001a\u0004\b,\u0010$\"\u0004\b-\u0010&R \u0010.\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0006\"\u0004\b0\u0010\bR \u00101\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0006\"\u0004\b3\u0010\bR \u00104\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0006\"\u0004\b6\u0010\bR\"\u00107\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010'\u001a\u0004\b8\u0010$\"\u0004\b9\u0010&¨\u0006:"}, d2 = {"Lcom/bytedance/android/format/model/FormatLivePlayInfo$ActivityPageConfig;", "Ljava/io/Serializable;", "()V", "bgImg", "", "getBgImg", "()Ljava/lang/String;", "setBgImg", "(Ljava/lang/String;)V", "color1", "getColor1", "setColor1", "color2", "getColor2", "setColor2", "endTime", "getEndTime", "setEndTime", "extra", "", "getExtra", "()Ljava/util/Map;", "setExtra", "(Ljava/util/Map;)V", "icon", "getIcon", "setIcon", "id", "getId", "setId", "openSchema", "getOpenSchema", "setOpenSchema", "priority", "", "getPriority", "()Ljava/lang/Integer;", "setPriority", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "roomType", "getRoomType", "setRoomType", "showChance", "getShowChance", "setShowChance", DyPayConstant.KEY_START_TIME, "getStartTime", "setStartTime", "title", "getTitle", com.alipay.sdk.m.x.d.f25925o, "version", "getVersion", "setVersion", "width", "getWidth", "setWidth", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ActivityPageConfig implements Serializable {

        @SerializedName("bg_img")
        private String bgImg;

        @SerializedName("color_1")
        private String color1;

        @SerializedName("color_2")
        private String color2;

        @SerializedName("end_time")
        private String endTime;

        @SerializedName("extra")
        private Map<String, String> extra;

        @SerializedName("icon")
        private String icon;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        @SerializedName("id")
        private String f51330id;

        @SerializedName("open_schema")
        private String openSchema;

        @SerializedName("priority")
        private Integer priority;

        @SerializedName(IPerformanceManager.Params.room_type)
        private String roomType;

        @SerializedName("show_chance")
        private Integer showChance;

        @SerializedName(ILoadStallMonitor.START_TIME)
        private String startTime;

        @SerializedName("title")
        private String title;

        @SerializedName("version")
        private String version;

        @SerializedName("width")
        private Integer width;

        public ActivityPageConfig() {
        }

        public final String getBgImg() {
            return this.bgImg;
        }

        public final String getColor1() {
            return this.color1;
        }

        public final String getColor2() {
            return this.color2;
        }

        public final String getEndTime() {
            return this.endTime;
        }

        public final Map<String, String> getExtra() {
            return this.extra;
        }

        public final String getIcon() {
            return this.icon;
        }

        public final String getId() {
            return this.f51330id;
        }

        public final String getOpenSchema() {
            return this.openSchema;
        }

        public final Integer getPriority() {
            return this.priority;
        }

        public final String getRoomType() {
            return this.roomType;
        }

        public final Integer getShowChance() {
            return this.showChance;
        }

        public final String getStartTime() {
            return this.startTime;
        }

        public final String getTitle() {
            return this.title;
        }

        public final String getVersion() {
            return this.version;
        }

        public final Integer getWidth() {
            return this.width;
        }

        public final void setBgImg(String r100) {
            this.bgImg = r100;
        }

        public final void setColor1(String r100) {
            this.color1 = r100;
        }

        public final void setColor2(String r100) {
            this.color2 = r100;
        }

        public final void setEndTime(String r100) {
            this.endTime = r100;
        }

        public final void setExtra(Map<String, String> r100) {
            this.extra = r100;
        }

        public final void setIcon(String r100) {
            this.icon = r100;
        }

        public final void setId(String r100) {
            this.f51330id = r100;
        }

        public final void setOpenSchema(String r100) {
            this.openSchema = r100;
        }

        public final void setPriority(Integer r100) {
            this.priority = r100;
        }

        public final void setRoomType(String r100) {
            this.roomType = r100;
        }

        public final void setShowChance(Integer r100) {
            this.showChance = r100;
        }

        public final void setStartTime(String r100) {
            this.startTime = r100;
        }

        public final void setTitle(String r100) {
            this.title = r100;
        }

        public final void setVersion(String r100) {
            this.version = r100;
        }

        public final void setWidth(Integer r100) {
            this.width = r100;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/format/model/FormatLivePlayInfo$AiGroupPhoto;", "Ljava/io/Serializable;", "()V", "canShowGuideRedDot", "", "getCanShowGuideRedDot", "()Z", "effectIds", "", "", "getEffectIds", "()Ljava/util/List;", "enabledModes", "", "getEnabledModes", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class AiGroupPhoto implements Serializable {

        @SerializedName("can_show_guide_red_dot")
        private final boolean canShowGuideRedDot;

        @SerializedName(EffectConfiguration.KEY_EFFECT_IDS)
        private final List<String> effectIds;

        @SerializedName("enabled_modes")
        private final List<Integer> enabledModes;

        public AiGroupPhoto() {
        }

        public final boolean getCanShowGuideRedDot() {
            return this.canShowGuideRedDot;
        }

        public final List<String> getEffectIds() {
            return this.effectIds;
        }

        public final List<Integer> getEnabledModes() {
            return this.enabledModes;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/format/model/FormatLivePlayInfo$BusinessAdDressInfo;", "Ljava/io/Serializable;", "()V", "schema", "", "getSchema", "()Ljava/lang/String;", "setSchema", "(Ljava/lang/String;)V", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class BusinessAdDressInfo implements Serializable {

        @SerializedName("schema")
        private String schema;

        public BusinessAdDressInfo() {
        }

        public final String getSchema() {
            return this.schema;
        }

        public final void setSchema(String r100) {
            this.schema = r100;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010 \n\u0002\b\r\u0018\u00002\u00020\u0001:\u0001%B\u0007¢\u0006\u0004\b#\u0010$R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR$\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR(\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR(\u0010 \u001a\b\u0012\u0004\u0012\u00020\f0\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u001b\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001f¨\u0006&"}, d2 = {"Lcom/bytedance/android/format/model/FormatLivePlayInfo$CsrInfo;", "Ljava/io/Serializable;", "", "roleAssetId", "Ljava/lang/String;", "getRoleAssetId", "()Ljava/lang/String;", "setRoleAssetId", "(Ljava/lang/String;)V", "sceneAssetId", "getSceneAssetId", "setSceneAssetId", "Lcom/bytedance/android/format/model/FormatLivePlayInfo$CsrInfo$a;", "avatarResource", "Lcom/bytedance/android/format/model/FormatLivePlayInfo$CsrInfo$a;", "getAvatarResource", "()Lcom/bytedance/android/format/model/FormatLivePlayInfo$CsrInfo$a;", "setAvatarResource", "(Lcom/bytedance/android/format/model/FormatLivePlayInfo$CsrInfo$a;)V", "avatarResourceUrl", "getAvatarResourceUrl", "setAvatarResourceUrl", "sceneResourceUrl", "getSceneResourceUrl", "setSceneResourceUrl", "", "otherResourceUrls", "Ljava/util/List;", "getOtherResourceUrls", "()Ljava/util/List;", "setOtherResourceUrls", "(Ljava/util/List;)V", "otherResources", "getOtherResources", "setOtherResources", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class CsrInfo implements Serializable {

        @SerializedName("avatar_resource")
        private a avatarResource;

        @SerializedName("avatar_resource_url")
        private String avatarResourceUrl;

        @SerializedName("other_resource_urls")
        private List<String> otherResourceUrls;

        @SerializedName("other_resources")
        private List<a> otherResources;

        @SerializedName("role_asset_id")
        private String roleAssetId;

        @SerializedName("scene_asset_id")
        private String sceneAssetId;

        @SerializedName("scene_resource_url")
        private String sceneResourceUrl;

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/format/model/FormatLivePlayInfo$CsrInfo$a;", "", "", "url", "Ljava/lang/String;", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "checksum", "getChecksum", "setChecksum", "<init>", "()V", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class a {

            @SerializedName("unique_resource_id")
            private String checksum;

            @SerializedName("url")
            private String url;

            public a() {
            }
        }

        public CsrInfo() {
            this.otherResourceUrls = CollectionsKt.emptyList();
            this.otherResources = CollectionsKt.emptyList();
        }

        public final a getAvatarResource() {
            return this.avatarResource;
        }

        public final String getAvatarResourceUrl() {
            return this.avatarResourceUrl;
        }

        public final List<String> getOtherResourceUrls() {
            return this.otherResourceUrls;
        }

        public final List<a> getOtherResources() {
            return this.otherResources;
        }

        public final String getRoleAssetId() {
            return this.roleAssetId;
        }

        public final String getSceneAssetId() {
            return this.sceneAssetId;
        }

        public final String getSceneResourceUrl() {
            return this.sceneResourceUrl;
        }

        public final void setAvatarResource(a r100) {
            this.avatarResource = r100;
        }

        public final void setAvatarResourceUrl(String r100) {
            this.avatarResourceUrl = r100;
        }

        public final void setOtherResourceUrls(List<String> r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.otherResourceUrls = r100;
        }

        public final void setOtherResources(List<a> r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.otherResources = r100;
        }

        public final void setRoleAssetId(String r100) {
            this.roleAssetId = r100;
        }

        public final void setSceneAssetId(String r100) {
            this.sceneAssetId = r100;
        }

        public final void setSceneResourceUrl(String r100) {
            this.sceneResourceUrl = r100;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\b\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\"\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\b\u001a\u0004\b\t\u0010\u0005\"\u0004\b\n\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/format/model/FormatLivePlayInfo$FollowRelation;", "Ljava/io/Serializable;", "()V", "isFollowed", "", "()Ljava/lang/Boolean;", "setFollowed", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "isFollowing", "setFollowing", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class FollowRelation implements Serializable {

        @SerializedName("is_followed")
        private Boolean isFollowed;

        @SerializedName("is_following")
        private Boolean isFollowing;

        public FollowRelation() {
        }

        public final Boolean isFollowed() {
            return this.isFollowed;
        }

        public final Boolean isFollowing() {
            return this.isFollowing;
        }

        public final void setFollowed(Boolean r100) {
            this.isFollowed = r100;
        }

        public final void setFollowing(Boolean r100) {
            this.isFollowing = r100;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\bR\"\u0010\r\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u000e\u0010\u0006\"\u0004\b\u000f\u0010\bR \u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R \u0010\u0016\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/format/model/FormatLivePlayInfo$GameCardConfig;", "Ljava/io/Serializable;", "()V", "closeReopenInterval", "", "getCloseReopenInterval", "()Ljava/lang/Long;", "setCloseReopenInterval", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "displayDuration", "getDisplayDuration", "setDisplayDuration", "enterRoomDisplayInterval", "getEnterRoomDisplayInterval", "setEnterRoomDisplayInterval", "gameId", "", "getGameId", "()Ljava/lang/String;", "setGameId", "(Ljava/lang/String;)V", "roomId", "getRoomId", "setRoomId", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class GameCardConfig implements Serializable {

        @SerializedName("close_reopen_interval")
        private Long closeReopenInterval;

        @SerializedName("display_duration")
        private Long displayDuration;

        @SerializedName("enter_room_display_interval")
        private Long enterRoomDisplayInterval;

        @SerializedName("game_id")
        private String gameId;

        @SerializedName("room_id")
        private String roomId;

        public GameCardConfig() {
            this.gameId = "";
            this.roomId = "";
            this.enterRoomDisplayInterval = 0L;
            this.displayDuration = 0L;
            this.closeReopenInterval = 0L;
        }

        public final Long getCloseReopenInterval() {
            return this.closeReopenInterval;
        }

        public final Long getDisplayDuration() {
            return this.displayDuration;
        }

        public final Long getEnterRoomDisplayInterval() {
            return this.enterRoomDisplayInterval;
        }

        public final String getGameId() {
            return this.gameId;
        }

        public final String getRoomId() {
            return this.roomId;
        }

        public final void setCloseReopenInterval(Long r100) {
            this.closeReopenInterval = r100;
        }

        public final void setDisplayDuration(Long r100) {
            this.displayDuration = r100;
        }

        public final void setEnterRoomDisplayInterval(Long r100) {
            this.enterRoomDisplayInterval = r100;
        }

        public final void setGameId(String r100) {
            this.gameId = r100;
        }

        public final void setRoomId(String r100) {
            this.roomId = r100;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0014\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\bR \u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R \u0010\u0013\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\"\u0010\u0016\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR \u0010\u0019\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0010\"\u0004\b\u001b\u0010\u0012R\"\u0010\u001c\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u001d\u0010\u0006\"\u0004\b\u001e\u0010\bR\"\u0010\u001f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b \u0010\u0006\"\u0004\b!\u0010\b¨\u0006\""}, d2 = {"Lcom/bytedance/android/format/model/FormatLivePlayInfo$MediaModel;", "Ljava/io/Serializable;", "()V", "height", "", "getHeight", "()Ljava/lang/Integer;", "setHeight", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "mediaType", "getMediaType", "setMediaType", "mediaUrl", "", "getMediaUrl", "()Ljava/lang/String;", "setMediaUrl", "(Ljava/lang/String;)V", "resourceId", "getResourceId", "setResourceId", "songId", "getSongId", "setSongId", "title", "getTitle", com.alipay.sdk.m.x.d.f25925o, ITTVideoEngineEventSource.KEY_VOLUME, "getVolume", "setVolume", "width", "getWidth", "setWidth", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class MediaModel implements Serializable {

        @SerializedName("height")
        private Integer height;

        @SerializedName(com.bytedance.android.ec.core.event.a.KEY_MEDIA_TYPE)
        private Integer mediaType;

        @SerializedName("media_url")
        private String mediaUrl;

        @SerializedName("resource_id")
        private String resourceId;

        @SerializedName("song_id")
        private Integer songId;

        @SerializedName("title")
        private String title;

        @SerializedName(ITTVideoEngineEventSource.KEY_VOLUME)
        private Integer volume;

        @SerializedName("width")
        private Integer width;

        public MediaModel() {
            this.mediaType = 0;
            this.mediaUrl = "";
            this.resourceId = "";
            this.songId = 0;
            this.title = "";
            this.volume = 0;
        }

        public final Integer getHeight() {
            return this.height;
        }

        public final Integer getMediaType() {
            return this.mediaType;
        }

        public final String getMediaUrl() {
            return this.mediaUrl;
        }

        public final String getResourceId() {
            return this.resourceId;
        }

        public final Integer getSongId() {
            return this.songId;
        }

        public final String getTitle() {
            return this.title;
        }

        public final Integer getVolume() {
            return this.volume;
        }

        public final Integer getWidth() {
            return this.width;
        }

        public final void setHeight(Integer r100) {
            this.height = r100;
        }

        public final void setMediaType(Integer r100) {
            this.mediaType = r100;
        }

        public final void setMediaUrl(String r100) {
            this.mediaUrl = r100;
        }

        public final void setResourceId(String r100) {
            this.resourceId = r100;
        }

        public final void setSongId(Integer r100) {
            this.songId = r100;
        }

        public final void setTitle(String r100) {
            this.title = r100;
        }

        public final void setVolume(Integer r100) {
            this.volume = r100;
        }

        public final void setWidth(Integer r100) {
            this.width = r100;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/format/model/FormatLivePlayInfo$PlayStatus;", "", "", "status", "I", "getStatus", "()I", "Unknown", "Creating", "Created", "CreateFailed", "Published", "Unpublished", "Reviewing", "ReviewRejected", "ReviewApproved", "Deleted", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum PlayStatus extends Enum<PlayStatus> {
        public static final PlayStatus CreateFailed = null;
        public static final PlayStatus Created = null;
        public static final PlayStatus Creating = null;
        public static final PlayStatus Deleted = null;
        public static final PlayStatus Published = null;
        public static final PlayStatus ReviewApproved = null;
        public static final PlayStatus ReviewRejected = null;
        public static final PlayStatus Reviewing = null;
        public static final PlayStatus Unknown = null;
        public static final PlayStatus Unpublished = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ PlayStatus[] f51331a = null;
        private final int status;

        public static PlayStatus valueOf(String r100) {
            return (PlayStatus) r27.a.a(PlayStatus.class, r100);
        }

        public static PlayStatus[] values() {
            return (PlayStatus[]) f51331a.clone();
        }

        static {
            PlayStatus r100 = new PlayStatus("Unknown", 0, 0);
            Unknown = r100;
            PlayStatus r101 = new PlayStatus("Creating", 1, 1);
            Creating = r101;
            PlayStatus r102 = new PlayStatus("Created", 2, 2);
            Created = r102;
            PlayStatus r103 = new PlayStatus("CreateFailed", 3, 3);
            CreateFailed = r103;
            PlayStatus r104 = new PlayStatus("Published", 4, 4);
            Published = r104;
            PlayStatus r105 = new PlayStatus("Unpublished", 5, 5);
            Unpublished = r105;
            PlayStatus r106 = new PlayStatus("Reviewing", 6, 6);
            Reviewing = r106;
            PlayStatus r107 = new PlayStatus("ReviewRejected", 7, 7);
            ReviewRejected = r107;
            PlayStatus r108 = new PlayStatus("ReviewApproved", 8, 8);
            ReviewApproved = r108;
            PlayStatus r109 = new PlayStatus("Deleted", 9, 9);
            Deleted = r109;
            f51331a = new PlayStatus[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109};
        }

        public final int getStatus() {
            return this.status;
        }

        public PlayStatus(String r100, int r101, int r102) {
            super(r100, r101);
            this.status = r102;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\u0018R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/format/model/FormatLivePlayInfo$PreviewDefaultSeletionData;", "Ljava/io/Serializable;", "Lcom/bytedance/android/format/model/s0;", "motionStyleInfo", "Lcom/bytedance/android/format/model/s0;", "getMotionStyleInfo", "()Lcom/bytedance/android/format/model/s0;", "setMotionStyleInfo", "(Lcom/bytedance/android/format/model/s0;)V", "Lcom/bytedance/android/format/model/SingleSong;", "songInfo", "Lcom/bytedance/android/format/model/SingleSong;", "getSongInfo", "()Lcom/bytedance/android/format/model/SingleSong;", "setSongInfo", "(Lcom/bytedance/android/format/model/SingleSong;)V", "Lcom/bytedance/android/format/model/d1;", "virtualSceneInfo", "Lcom/bytedance/android/format/model/d1;", "getVirtualSceneInfo", "()Lcom/bytedance/android/format/model/d1;", "setVirtualSceneInfo", "(Lcom/bytedance/android/format/model/d1;)V", "<init>", "()V", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class PreviewDefaultSeletionData implements Serializable {

        @SerializedName("motion_style_info")
        private s0 motionStyleInfo;

        @SerializedName("song_info")
        private SingleSong songInfo;

        @SerializedName("virtual_scene_info")
        private d1 virtualSceneInfo;

        public PreviewDefaultSeletionData() {
        }

        public final s0 getMotionStyleInfo() {
            return this.motionStyleInfo;
        }

        public final SingleSong getSongInfo() {
            return this.songInfo;
        }

        public final d1 getVirtualSceneInfo() {
            return this.virtualSceneInfo;
        }

        public final void setMotionStyleInfo(s0 r100) {
            this.motionStyleInfo = r100;
        }

        public final void setSongInfo(SingleSong r100) {
            this.songInfo = r100;
        }

        public final void setVirtualSceneInfo(d1 r100) {
            this.virtualSceneInfo = r100;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/format/model/FormatLivePlayInfo$Product;", "Ljava/io/Serializable;", "()V", "name", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "productId", "", "getProductId", "()J", "setProductId", "(J)V", "schema", "getSchema", "setSchema", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Product implements Serializable {

        @SerializedName("name")
        private String name;

        @SerializedName("product_id")
        private long productId;

        @SerializedName("schema")
        private String schema;

        public Product() {
        }

        public final String getName() {
            return this.name;
        }

        public final long getProductId() {
            return this.productId;
        }

        public final String getSchema() {
            return this.schema;
        }

        public final void setName(String r100) {
            this.name = r100;
        }

        public final void setProductId(long r100) {
            this.productId = r100;
        }

        public final void setSchema(String r100) {
            this.schema = r100;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/format/model/FormatLivePlayInfo$RelatedPlayInfo;", "Ljava/io/Serializable;", "()V", "avatarUid", "", "getAvatarUid", "()Ljava/lang/Long;", "setAvatarUid", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "playId", "", "getPlayId", "()Ljava/lang/String;", "setPlayId", "(Ljava/lang/String;)V", "roomType", "", "getRoomType", "()Ljava/lang/Integer;", "setRoomType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class RelatedPlayInfo implements Serializable {

        @SerializedName("avatar_uid")
        private Long avatarUid;

        @SerializedName(InstantPlayContext.PLAY_ID)
        private String playId;

        @SerializedName(IPerformanceManager.Params.room_type)
        private Integer roomType;

        public RelatedPlayInfo() {
        }

        public final Long getAvatarUid() {
            return this.avatarUid;
        }

        public final String getPlayId() {
            return this.playId;
        }

        public final Integer getRoomType() {
            return this.roomType;
        }

        public final void setAvatarUid(Long r100) {
            this.avatarUid = r100;
        }

        public final void setPlayId(String r100) {
            this.playId = r100;
        }

        public final void setRoomType(Integer r100) {
            this.roomType = r100;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0086\u0001\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/format/model/FormatLivePlayInfo$TaskType;", "", "", "type", "I", "getType", "()I", "", "semanticName", "Ljava/lang/String;", "getSemanticName", "()Ljava/lang/String;", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Default", "E_Commerce", "Accompany", "Local_Service", "TopicInteract", "ScriptInteract", "Virtual", "HomepageRecommend", "LivePlayScript", "VideoInteract", "BizAD", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum TaskType extends Enum<TaskType> {
        public static final TaskType Accompany = null;
        public static final TaskType BizAD = null;
        public static final a Companion = null;
        public static final TaskType Default = null;
        public static final TaskType E_Commerce = null;
        public static final TaskType HomepageRecommend = null;
        public static final TaskType LivePlayScript = null;
        public static final TaskType Local_Service = null;
        public static final TaskType ScriptInteract = null;
        public static final TaskType TopicInteract = null;
        public static final TaskType VideoInteract = null;
        public static final TaskType Virtual = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ TaskType[] f51332a = null;
        private final String semanticName;
        private final int type;

        public static final class a {
            public a() {
            }
        }

        public static TaskType valueOf(String r100) {
            return (TaskType) r27.a.a(TaskType.class, r100);
        }

        public static TaskType[] values() {
            return (TaskType[]) f51332a.clone();
        }

        static {
            TaskType r100 = new TaskType("Default", 0, 0, "unknown");
            Default = r100;
            TaskType r101 = new TaskType("E_Commerce", 1, 1, "e_commerce");
            E_Commerce = r101;
            TaskType r102 = new TaskType("Accompany", 2, 2, "accompany");
            Accompany = r102;
            TaskType r103 = new TaskType("Local_Service", 3, 3, "local_service");
            Local_Service = r103;
            TaskType r104 = new TaskType("TopicInteract", 4, 4, "topic");
            TopicInteract = r104;
            TaskType r105 = new TaskType("ScriptInteract", 5, 5, "play_script");
            ScriptInteract = r105;
            TaskType r106 = new TaskType("Virtual", 6, 6, "virtual");
            Virtual = r106;
            TaskType r107 = new TaskType("HomepageRecommend", 7, 7, "homepage_recommend");
            HomepageRecommend = r107;
            TaskType r108 = new TaskType("LivePlayScript", 8, 8, "interactive_script");
            LivePlayScript = r108;
            TaskType r109 = new TaskType("VideoInteract", 9, 9, "interact_video");
            VideoInteract = r109;
            TaskType r110 = new TaskType("BizAD", 10, 11, "biz_ad");
            BizAD = r110;
            f51332a = new TaskType[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110};
            Companion = new a();
        }

        public final String getSemanticName() {
            return this.semanticName;
        }

        public final int getType() {
            return this.type;
        }

        public TaskType(String r100, int r101, int r102, String r103) {
            super(r100, r101);
            this.type = r102;
            this.semanticName = r103;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR&\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/format/model/FormatLivePlayInfo$TextData;", "Ljava/io/Serializable;", "()V", "audioUrl", "", "getAudioUrl", "()Ljava/lang/String;", "setAudioUrl", "(Ljava/lang/String;)V", EffectConfiguration.KEY_SEARCH_WORD, "getWord", "setWord", "wordAlignment", "", "Lcom/bytedance/android/format/model/FormatLivePlayInfo$WordTimestamp;", "getWordAlignment", "()Ljava/util/List;", "setWordAlignment", "(Ljava/util/List;)V", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class TextData implements Serializable {

        @SerializedName("audio_url")
        private String audioUrl;

        @SerializedName("text")
        private String word;

        @SerializedName("word_alignment")
        private List<WordTimestamp> wordAlignment;

        public TextData() {
        }

        public final String getAudioUrl() {
            return this.audioUrl;
        }

        public final String getWord() {
            return this.word;
        }

        public final List<WordTimestamp> getWordAlignment() {
            return this.wordAlignment;
        }

        public final void setAudioUrl(String r100) {
            this.audioUrl = r100;
        }

        public final void setWord(String r100) {
            this.word = r100;
        }

        public final void setWordAlignment(List<WordTimestamp> r100) {
            this.wordAlignment = r100;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001\u0013B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u0010\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/format/model/FormatLivePlayInfo$VfxResource;", "Ljava/io/Serializable;", "()V", "vfxId", "", "getVfxId", "()Ljava/lang/String;", "setVfxId", "(Ljava/lang/String;)V", "vfxType", "", "getVfxType", "()Ljava/lang/Integer;", "setVfxType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "vfxUrl", "getVfxUrl", "setVfxUrl", "VfxResourceType", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class VfxResource implements Serializable {

        @SerializedName("vfx_id")
        private String vfxId;

        @SerializedName("vfx_type")
        private Integer vfxType;

        @SerializedName("vfx_url")
        private String vfxUrl;

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/format/model/FormatLivePlayInfo$VfxResource$VfxResourceType;", "", "", "type", "I", "getType", "()I", "Unknown", "Like", "GuideLike", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final enum VfxResourceType extends Enum<VfxResourceType> {
            public static final VfxResourceType GuideLike = null;
            public static final VfxResourceType Like = null;
            public static final VfxResourceType Unknown = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ VfxResourceType[] f51333a = null;
            private final int type;

            static {
                VfxResourceType r100 = new VfxResourceType("Unknown", 0, 0);
                Unknown = r100;
                VfxResourceType r101 = new VfxResourceType("Like", 1, 1);
                Like = r101;
                VfxResourceType r102 = new VfxResourceType("GuideLike", 2, 2);
                GuideLike = r102;
                f51333a = new VfxResourceType[]{r100, r101, r102};
            }

            public static VfxResourceType valueOf(String r100) {
                return (VfxResourceType) r27.a.a(VfxResourceType.class, r100);
            }

            public static VfxResourceType[] values() {
                return (VfxResourceType[]) f51333a.clone();
            }

            public final int getType() {
                return this.type;
            }

            public VfxResourceType(String r100, int r101, int r102) {
                super(r100, r101);
                this.type = r102;
            }
        }

        public VfxResource() {
        }

        public final String getVfxId() {
            return this.vfxId;
        }

        public final Integer getVfxType() {
            return this.vfxType;
        }

        public final String getVfxUrl() {
            return this.vfxUrl;
        }

        public final void setVfxId(String r100) {
            this.vfxId = r100;
        }

        public final void setVfxType(Integer r100) {
            this.vfxType = r100;
        }

        public final void setVfxUrl(String r100) {
            this.vfxUrl = r100;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R \u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001e\u0010\u0015\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/format/model/FormatLivePlayInfo$VideoItem;", "Ljava/io/Serializable;", "()V", "itemId", "", "getItemId", "()Ljava/lang/String;", "setItemId", "(Ljava/lang/String;)V", "itemTitle", "getItemTitle", "setItemTitle", "videoHeight", "", "getVideoHeight", "()I", "setVideoHeight", "(I)V", "videoUrl", "getVideoUrl", "setVideoUrl", "videoWidth", "getVideoWidth", "setVideoWidth", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class VideoItem implements Serializable {

        @SerializedName("item_id")
        private String itemId;

        @SerializedName("item_title")
        private String itemTitle;

        @SerializedName("height")
        private int videoHeight;

        @SerializedName("video_url")
        private String videoUrl;

        @SerializedName("width")
        private int videoWidth;

        public VideoItem() {
        }

        public final String getItemId() {
            return this.itemId;
        }

        public final String getItemTitle() {
            return this.itemTitle;
        }

        public final int getVideoHeight() {
            return this.videoHeight;
        }

        public final String getVideoUrl() {
            return this.videoUrl;
        }

        public final int getVideoWidth() {
            return this.videoWidth;
        }

        public final void setItemId(String r100) {
            this.itemId = r100;
        }

        public final void setItemTitle(String r100) {
            this.itemTitle = r100;
        }

        public final void setVideoHeight(int r100) {
            this.videoHeight = r100;
        }

        public final void setVideoUrl(String r100) {
            this.videoUrl = r100;
        }

        public final void setVideoWidth(int r100) {
            this.videoWidth = r100;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/format/model/FormatLivePlayInfo$WordTimestamp;", "Ljava/io/Serializable;", "()V", "end", "", "getEnd", "()D", "setEnd", "(D)V", "start", "getStart", "setStart", EffectConfiguration.KEY_SEARCH_WORD, "", "getWord", "()Ljava/lang/String;", "setWord", "(Ljava/lang/String;)V", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class WordTimestamp implements Serializable {

        @SerializedName("end_time")
        private double end;

        @SerializedName(ILoadStallMonitor.START_TIME)
        private double start;

        @SerializedName(EffectConfiguration.KEY_SEARCH_WORD)
        private String word;

        public WordTimestamp() {
        }

        public final double getEnd() {
            return this.end;
        }

        public final double getStart() {
            return this.start;
        }

        public final String getWord() {
            return this.word;
        }

        public final void setEnd(double r100) {
            this.end = r100;
        }

        public final void setStart(double r100) {
            this.start = r100;
        }

        public final void setWord(String r100) {
            this.word = r100;
        }
    }

    public final String getProductionName() {
        int r100 = this.taskType;
        if (r100 != TaskType.TopicInteract.getType()) goto L13;
        h r101 = this.interactPlayData;
        if (r101 == null) goto L36;
        z0 r102 = r101.b();
        if (r102 == null) goto L37;
        TextData r103 = r102.a();
        if (r103 == null) goto L38;
        String r104 = r103.getWord();
        if (r104 != null) goto L35;
        return "";
    L35:
        return r104;
    L38:
        return "";
    L37:
        return "";
    L36:
        return "";
    L13:
        String r105 = null;
        Object r106 = null;
        r106 = null;
        r106 = null;
        if (r100 != TaskType.ScriptInteract.getType()) goto L24;
        h r107 = this.interactPlayData;
        if (r107 == null) goto L39;
        y0 r108 = r107.a();
        if (r108 == null) goto L39;
        Map<String, Object> r109 = r108.a();
        if (r109 == null) goto L39;
        r106 = r109.get("title");
    L39:
        return String.valueOf(r106);
    L24:
        if (r100 != TaskType.VideoInteract.getType()) goto L29;
        StringBuilder r110 = new StringBuilder();
        FormatUser r111 = this.author;
        if (r111 == null) goto L28;
        r105 = r111.getNickName();
    L28:
        r110.append(r105);
        r110.append("的AI互动空间");
        return r110.toString();
    L29:
        VideoItem r112 = this.videoItem;
        if (r112 == null) goto L41;
        r104 = r112.getItemTitle();
        if (r104 != null) goto L35;
        return "";
    L41:
        return "";
    }

    public FormatLivePlayInfo() {
        this.backgroundVolumeAvoidance = 0.3f;
        this.playName = "";
        this.enableShare = true;
    }

    public final List<ActivityPageConfig> getActivityPageConfigDatas() {
        return this.activityPageConfigDatas;
    }

    public final AiGroupPhoto getAiGroupPhoto() {
        return this.aiGroupPhoto;
    }

    public final FormatUser getAuthor() {
        return this.author;
    }

    public final long getAvatarUid() {
        return this.avatarUid;
    }

    public final float getBackgroundVolumeAvoidance() {
        return this.backgroundVolumeAvoidance;
    }

    public final List<SingleSong> getBgmList() {
        return this.bgmList;
    }

    public final BusinessAdDressInfo getBusinessAdDressInfo() {
        return this.businessAdDressInfo;
    }

    public final m getCarouselComponents() {
        return this.carouselComponents;
    }

    public final CsrInfo getCsrInfo() {
        return this.csrInfo;
    }

    public final List<i> getCsrResources() {
        return this.csrResources;
    }

    public final Boolean getDisableDiary() {
        return this.disableDiary;
    }

    public final boolean getEnableShare() {
        return this.enableShare;
    }

    public final Long getExpireInterval() {
        return this.expireInterval;
    }

    public final Map<String, String> getExtra() {
        return this.extra;
    }

    public final FollowRelation getFollowRelation() {
        return this.followRelation;
    }

    public final GameCardConfig getGameCardConfig() {
        return this.gameCardConfig;
    }

    public final h getInteractPlayData() {
        return this.interactPlayData;
    }

    public final VideoItem getLoadVideo() {
        return this.loadVideo;
    }

    public final MediaModel getLoadVideoCoverModel() {
        return this.loadVideoCoverModel;
    }

    public final TextData getOpeningChat() {
        return this.openingChat;
    }

    public final String getPlayName() {
        return this.playName;
    }

    public final int getPlayStatus() {
        return this.playStatus;
    }

    public final List<FormatLiveRoom.TimelineEvent> getPlayTimeLine() {
        return this.playTimeLine;
    }

    public final int getPlayType() {
        return this.playType;
    }

    public final PreviewDefaultSeletionData getPreviewDefaultSelectionData() {
        return this.previewDefaultSelectionData;
    }

    public final Product getProduct() {
        return this.product;
    }

    public final int getProductType() {
        return this.productType;
    }

    public final List<RelatedPlayInfo> getRelatedPlayInfoList() {
        return this.relatedPlayInfoList;
    }

    public final boolean getShowXplayChargeButton() {
        return this.showXplayChargeButton;
    }

    public final int getTaskType() {
        return this.taskType;
    }

    public final List<VfxResource> getVfxResources() {
        return this.vfxResources;
    }

    public final VideoItem getVideoItem() {
        return this.videoItem;
    }

    public final boolean isUgc() {
        return this.isUgc;
    }

    public final void setActivityPageConfigDatas(List<ActivityPageConfig> r100) {
        this.activityPageConfigDatas = r100;
    }

    public final void setAiGroupPhoto(AiGroupPhoto r100) {
        this.aiGroupPhoto = r100;
    }

    public final void setAuthor(FormatUser r100) {
        this.author = r100;
    }

    public final void setBackgroundVolumeAvoidance(float r100) {
        this.backgroundVolumeAvoidance = r100;
    }

    public final void setBgmList(List<SingleSong> r100) {
        this.bgmList = r100;
    }

    public final void setBusinessAdDressInfo(BusinessAdDressInfo r100) {
        this.businessAdDressInfo = r100;
    }

    public final void setCarouselComponents(m r100) {
        this.carouselComponents = r100;
    }

    public final void setCsrInfo(CsrInfo r100) {
        this.csrInfo = r100;
    }

    public final void setCsrResources(List<i> r100) {
        this.csrResources = r100;
    }

    public final void setDisableDiary(Boolean r100) {
        this.disableDiary = r100;
    }

    public final void setEnableShare(boolean r100) {
        this.enableShare = r100;
    }

    public final void setExpireInterval(Long r100) {
        this.expireInterval = r100;
    }

    public final void setExtra(Map<String, String> r100) {
        this.extra = r100;
    }

    public final void setGameCardConfig(GameCardConfig r100) {
        this.gameCardConfig = r100;
    }

    public final void setInteractPlayData(h r100) {
        this.interactPlayData = r100;
    }

    public final void setLoadVideo(VideoItem r100) {
        this.loadVideo = r100;
    }

    public final void setLoadVideoCoverModel(MediaModel r100) {
        this.loadVideoCoverModel = r100;
    }

    public final void setPlayName(String r100) {
        this.playName = r100;
    }

    public final void setPlayStatus(int r100) {
        this.playStatus = r100;
    }

    public final void setPlayTimeLine(List<FormatLiveRoom.TimelineEvent> r100) {
        this.playTimeLine = r100;
    }

    public final void setPreviewDefaultSelectionData(PreviewDefaultSeletionData r100) {
        this.previewDefaultSelectionData = r100;
    }

    public final void setProductType(int r100) {
        this.productType = r100;
    }

    public final void setRelatedPlayInfoList(List<RelatedPlayInfo> r100) {
        this.relatedPlayInfoList = r100;
    }

    public final void setShowXplayChargeButton(boolean r100) {
        this.showXplayChargeButton = r100;
    }

    public final void setUgc(boolean r100) {
        this.isUgc = r100;
    }

    public final void setVfxResources(List<VfxResource> r100) {
        this.vfxResources = r100;
    }

    public final void setVideoItem(VideoItem r100) {
        this.videoItem = r100;
    }
}
