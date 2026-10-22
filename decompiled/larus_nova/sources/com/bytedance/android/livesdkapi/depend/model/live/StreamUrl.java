package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import android.text.TextUtils;
import com.bytedance.android.livehostapi.business.depend.livead.MiniAppConstants;
import com.bytedance.android.livesdkapi.roomplayer.AESDecryptLiveUrlUtils;
import com.bytedance.android.livesdkapi.roomplayer.VrBgLogData;
import com.bytedance.android.service.manager.pull.PullConfiguration;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.common.utility.Lists;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tb1.c;
import vh7.f;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.data.StreamUrl")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0010\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010#\n\u0002\b\u000e\b\u0007\u0018\u0000 £\u00012\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00022\u00020\u0003:\u0006£\u0001¤\u0001¥\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u000e\u0010|\u001a\u00020.2\u0006\u0010}\u001a\u00020\fJ?\u0010~\u001a\u00020\u007f2\t\u0010\u0080\u0001\u001a\u0004\u0018\u00010\f2\b\u0010\u0081\u0001\u001a\u00030\u0082\u00012\u0010\u0010\u0083\u0001\u001a\u000b\u0012\u0005\u0012\u00030\u0084\u0001\u0018\u00010\u000e2\u0010\u0010\u0085\u0001\u001a\u000b\u0012\u0005\u0012\u00030\u0084\u0001\u0018\u00010\u000eJ\u000b\u0010\u0086\u0001\u001a\u0004\u0018\u00010\fH\u0016J\t\u0010\u0087\u0001\u001a\u00020OH\u0016J\u000b\u0010\u0088\u0001\u001a\u0004\u0018\u00010\fH\u0016J\u000b\u0010\u0089\u0001\u001a\u0004\u0018\u00010\fH\u0016J\u000b\u0010\u008a\u0001\u001a\u0004\u0018\u00010\fH\u0016J\u000b\u0010\u008b\u0001\u001a\u0004\u0018\u00010\fH\u0016J\u000b\u0010\u008c\u0001\u001a\u0004\u0018\u00010\fH\u0016J\f\u0010\u008d\u0001\u001a\u0005\u0018\u00010\u008e\u0001H\u0016J\u000b\u0010\u008f\u0001\u001a\u0004\u0018\u00010\fH\u0016J\u000b\u0010\u0090\u0001\u001a\u0004\u0018\u00010\fH\u0016J\u000b\u0010\u0091\u0001\u001a\u0004\u0018\u00010\fH\u0016J\u0014\u0010\u0091\u0001\u001a\u0004\u0018\u00010\f2\u0007\u0010\u0092\u0001\u001a\u00020\fH\u0016J\u000b\u0010\u0093\u0001\u001a\u0004\u0018\u00010\fH\u0016J\u000b\u0010\u0094\u0001\u001a\u0004\u0018\u00010\fH\u0016J\u000b\u0010\u0095\u0001\u001a\u0004\u0018\u00010\fH\u0016J\u000b\u0010\u0096\u0001\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\u0097\u0001\u001a\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0098\u0001H\u0016J\u0011\u0010\u0099\u0001\u001a\n\u0012\u0004\u0012\u00020;\u0018\u00010bH\u0016J\t\u0010\u009a\u0001\u001a\u00020.H\u0016J\t\u0010\u009b\u0001\u001a\u00020.H\u0016J\t\u0010\u009c\u0001\u001a\u00020.H\u0016J\t\u0010\u009d\u0001\u001a\u00020.H\u0016J\t\u0010\u009e\u0001\u001a\u00020.H\u0016J\u0011\u0010\u009f\u0001\u001a\u00020\u007f2\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u0011\u0010 \u0001\u001a\u00020\u007f2\b\u0010A\u001a\u0004\u0018\u00010\fJ\t\u0010¡\u0001\u001a\u00020\u007fH\u0016J\t\u0010¢\u0001\u001a\u00020\u007fH\u0016R \u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000e8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R \u0010\u0013\u001a\u0004\u0018\u00010\f8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R \u0010\u0019\u001a\u0004\u0018\u00010\f8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\bR,\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010\u001f8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001e\u0010$\u001a\u00020%8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R \u0010*\u001a\u0004\u0018\u00010\f8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0015\"\u0004\b,\u0010\u0017R\u0011\u0010-\u001a\u00020.8F¢\u0006\u0006\u001a\u0004\b-\u0010/R \u00100\u001a\u0004\u0018\u0001018\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u0010\u00106\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R \u00107\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0015\"\u0004\b9\u0010\u0017R\u001c\u0010:\u001a\u0004\u0018\u00010;X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u0010\u0010@\u001a\u0004\u0018\u00010;X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010A\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R \u0010B\u001a\u0004\u0018\u00010C8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR \u0010H\u001a\u0004\u0018\u00010I8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\u001e\u0010N\u001a\u00020O8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR0\u0010T\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0006\u0012\u0004\u0018\u00010U\u0018\u00010\u001f8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010!\"\u0004\bW\u0010#R,\u0010X\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010\u001f8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010!\"\u0004\bZ\u0010#R \u0010[\u001a\u0004\u0018\u00010\f8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010\u0015\"\u0004\b]\u0010\u0017R&\u0010^\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000e8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010\u0010\"\u0004\b`\u0010\u0012R\u0016\u0010a\u001a\b\u0012\u0004\u0012\u00020;0b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R0\u0010c\u001a\"\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\f0dj\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\f`e8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010f\u001a\u0004\u0018\u00010U8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bg\u0010hR,\u0010i\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010\u001f8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bj\u0010!\"\u0004\bk\u0010#R\u0012\u0010l\u001a\u00020O8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R \u0010m\u001a\u0004\u0018\u00010\f8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bn\u0010\u0015\"\u0004\bo\u0010\u0017R(\u0010q\u001a\u0004\u0018\u00010\f2\b\u0010p\u001a\u0004\u0018\u00010\f8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\br\u0010\u0015\"\u0004\bs\u0010\u0017R4\u0010t\u001a&\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0006\u0012\u0004\u0018\u00010\f0dj\u0012\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0006\u0012\u0004\u0018\u00010\f`e8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010u\u001a\u00020O8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001e\u0010v\u001a\u00020O8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bw\u0010Q\"\u0004\bx\u0010SR\u001e\u0010y\u001a\u00020O8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bz\u0010Q\"\u0004\b{\u0010S¨\u0006¦\u0001"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/StreamUrl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IBaseStreamUrl;", "Ljava/io/Serializable;", "()V", "_extra", "Lcom/bytedance/android/livesdkapi/depend/model/live/IStreamUrlExtra;", "get_extra", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IStreamUrlExtra;", "set_extra", "(Lcom/bytedance/android/livesdkapi/depend/model/live/IStreamUrlExtra;)V", "bindNodeRtmpUrl", "", "candidateResolution", "", "getCandidateResolution", "()Ljava/util/List;", "setCandidateResolution", "(Ljava/util/List;)V", "defaultPullSdkParams", "getDefaultPullSdkParams", "()Ljava/lang/String;", "setDefaultPullSdkParams", "(Ljava/lang/String;)V", "defaultQualityName", "defaultResolution", "getDefaultResolution", "setDefaultResolution", "extra", "getExtra", "flvPullUrl", "", "getFlvPullUrl", "()Ljava/util/Map;", "setFlvPullUrl", "(Ljava/util/Map;)V", "id", "", "getId", "()J", "setId", "(J)V", "idStr", "getIdStr", "setIdStr", "isEncryptStreamUrl", "", "()Z", "liveCoreSDKData", "Lcom/bytedance/android/livesdkapi/depend/model/live/LiveCoreSDKData;", "getLiveCoreSDKData", "()Lcom/bytedance/android/livesdkapi/depend/model/live/LiveCoreSDKData;", "setLiveCoreSDKData", "(Lcom/bytedance/android/livesdkapi/depend/model/live/LiveCoreSDKData;)V", "lowestQualityName", "mRtmpPushUrl", "getMRtmpPushUrl", "setMRtmpPushUrl", "multiDefaultQuality", "Lcom/bytedance/android/livesdkapi/depend/model/live/IQuality;", "getMultiDefaultQuality", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IQuality;", "setMultiDefaultQuality", "(Lcom/bytedance/android/livesdkapi/depend/model/live/IQuality;)V", "multiLowestQuality", "ngbRTMPUrl", "openStreamUrlEncrypt", "Lcom/bytedance/android/livesdkapi/depend/model/live/StreamUrl$OpenStreamUrlEncrypt;", "getOpenStreamUrlEncrypt", "()Lcom/bytedance/android/livesdkapi/depend/model/live/StreamUrl$OpenStreamUrlEncrypt;", "setOpenStreamUrlEncrypt", "(Lcom/bytedance/android/livesdkapi/depend/model/live/StreamUrl$OpenStreamUrlEncrypt;)V", "play", "Lcom/bytedance/android/livesdkapi/depend/model/live/IPlaySetting;", "getPlay", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IPlaySetting;", "setPlay", "(Lcom/bytedance/android/livesdkapi/depend/model/live/IPlaySetting;)V", ShortVideoSegments.KEY_PROP_PROVIDER, "", "getProvider", "()I", "setProvider", "(I)V", "pullDatas", "Lcom/bytedance/android/livesdkapi/depend/model/live/IPullData;", "getPullDatas", "setPullDatas", "pullSdkParams", "getPullSdkParams", "setPullSdkParams", "pushSdkParams", "getPushSdkParams", "setPushSdkParams", "pushUrlList", "getPushUrlList", "setPushUrlList", "qualityList", "", "qualityMap", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "realPullData", "getRealPullData", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IPullData;", "resolutionName", "getResolutionName", "setResolutionName", "resolutionSelectPanelResident", "rtmpPullUrl", "getRtmpPullUrl", "setRtmpPullUrl", "value", "rtmpPushUrl", "getRtmpPushUrl", "setRtmpPushUrl", "sdkParamsMap", "streamControlType", "streamOrientation", "getStreamOrientation", "setStreamOrientation", "vrType", "getVrType", "setVrType", "decryptLiveUrl", "encryptKeyStr", "decryptPlayInfo", "", "encryptKey", "pullData", "Lcom/bytedance/android/livesdkapi/depend/model/live/LiveCoreSDKData$PullData;", "encryptHls", "Lcom/bytedance/android/livesdkapi/depend/model/live/LiveCoreSDKData$PlayInfo;", "encryptFlv", "getBindNodeRtmpUrl", "getCompoundSceneType", "getCompoundStreamData", "getCompoundStreamDefaultQualitySdkKey", "getDefaultDefinition", "getDefaultQuality", "getDefaultQualityStrategy", "getExtension", "Lcom/bytedance/android/livesdkapi/depend/model/live/IExtension;", "getLowestQuality", "getMultiStreamData", "getMultiStreamDataFromPullDatas", "key", "getMultiStreamDefaultQualityName", "getMultiStreamDefaultQualitySdkKey", "getMultiStreamLowestQualityName", "getPullSdkParamsStr", "getQualities", "", "getQualityList", "getVPassDefault", "hasLiveCoreSDKData", "isCompoundScene", "isMultiPullDataValid", "isPullUrlValid", "setBindNodeRtmpUrl", "setNgbRTMPUrl", "validateMultiPullData", "validatePullUrl", "Companion", "OpenStreamUrlEncrypt", "PlaySetting", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class StreamUrl extends FlexModelBase<IBaseStreamUrl> implements IBaseStreamUrl, h {
    public static final Companion Companion = null;
    public static final int PROVIDER_CHINANETCENTER = 2;
    public static final int PROVIDER_KINGSOFT = 1;

    @SerializedName("extra")
    protected IStreamUrlExtra _extra;
    private String bindNodeRtmpUrl;

    @SerializedName("candidate_resolution")
    protected List<String> candidateResolution;

    @SerializedName("rtmp_pull_url_params")
    protected String defaultPullSdkParams;
    public String defaultQualityName;

    @SerializedName("default_resolution")
    protected String defaultResolution;

    @SerializedName("flv_pull_url")
    protected Map<String, String> flvPullUrl;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    protected long f162609id;

    @SerializedName("id_str")
    protected String idStr;

    @SerializedName("live_core_sdk_data")
    protected LiveCoreSDKData liveCoreSDKData;
    private String lowestQualityName;

    @SerializedName("rtmp_push_url")
    protected String mRtmpPushUrl;
    private IQuality multiDefaultQuality;
    private IQuality multiLowestQuality;
    private String ngbRTMPUrl;

    @SerializedName("open_stream_url_encrypt")
    protected OpenStreamUrlEncrypt openStreamUrlEncrypt;

    @SerializedName("play")
    protected IPlaySetting play;

    @SerializedName(ShortVideoSegments.KEY_PROP_PROVIDER)
    protected int provider;

    @SerializedName("pull_datas")
    protected Map<String, ? extends IPullData> pullDatas;

    @SerializedName("flv_pull_url_params")
    protected Map<String, String> pullSdkParams;

    @SerializedName("rtmp_push_url_params")
    protected String pushSdkParams;

    @SerializedName("push_urls")
    protected List<String> pushUrlList;
    public final List<IQuality> qualityList;
    public final LinkedHashMap<String, String> qualityMap;

    @SerializedName("resolution_name")
    protected Map<String, String> resolutionName;

    @SerializedName("resolution_select_panel_resident")
    public int resolutionSelectPanelResident;

    @SerializedName("rtmp_pull_url")
    protected String rtmpPullUrl;
    public final LinkedHashMap<String, String> sdkParamsMap;

    @SerializedName("stream_control_type")
    public int streamControlType;

    @SerializedName("stream_orientation")
    protected int streamOrientation;

    @SerializedName(VrBgLogData.KEY_VR_TYPE)
    protected int vrType;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/StreamUrl$Companion;", "", "()V", "PROVIDER_CHINANETCENTER", "", "PROVIDER_KINGSOFT", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    @ProtoMessage("webcast.data.OpenStreamUrlEncrypt")
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R \u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R$\u0010\n\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/StreamUrl$OpenStreamUrlEncrypt;", "Ljava/io/Serializable;", "()V", "flv", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/LiveCoreSDKData$PlayInfo;", "flvPullUrl", "", "", TTVideoEngineInterface.FORMAT_TYPE_HLS, "pullDatas", "Lcom/bytedance/android/livesdkapi/depend/model/live/LiveCoreSDKData$PullData;", "rtmpPullUrl", "streamData", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class OpenStreamUrlEncrypt implements Serializable, h {

        @SerializedName("Flv")
        public List<LiveCoreSDKData.PlayInfo> flv;

        @SerializedName("flv_pull_url")
        public Map<String, String> flvPullUrl;

        @SerializedName("Hls")
        public List<LiveCoreSDKData.PlayInfo> hls;

        @SerializedName("pull_datas")
        public Map<String, LiveCoreSDKData.PullData> pullDatas;

        @SerializedName("rtmp_pull_url")
        public String rtmpPullUrl;

        @SerializedName(MiniAppConstants.KEY_MINI_APP_STREAM_DATA)
        public String streamData;

        public OpenStreamUrlEncrypt() {
        }

        public OpenStreamUrlEncrypt(g r110) {
            this.flvPullUrl = new HashMap();
            this.pullDatas = new HashMap();
            this.hls = new ArrayList();
            this.flv = new ArrayList();
            long r100 = r110.c();
        L3:
            int r101 = r110.f();
            if (r101 == (-1)) goto L55;
            if (r101 != 1) goto L7;
            this.rtmpPullUrl = am3.h.c(r110);
            goto L3
        L7:
            String r102 = null;
            if (r101 == 8) goto L38;
            if (r101 != 3) goto L12;
            long r111 = r110.c();
            Object r103 = null;
        L23:
            int r104 = r110.f();
            if (r104 == (-1)) goto L30;
            if (r104 != 1) goto L26;
            r102 = am3.h.c(r110);
            goto L23
        L26:
            if (r104 != 2) goto L27;
            r103 = am3.h.c(r110);
            goto L23
        L27:
            am3.h.e(r110);
            goto L23
        L30:
            r110.d(r111);
            Map r105 = this.flvPullUrl;
            if (r102 == null) goto L37;
            if (r103 == null) goto L35;
        L33:
            r105.put(r102, r103);
            goto L3
        L35:
            throw new IllegalStateException("Value must not be null");
        L37:
            throw new IllegalStateException("Key must not be null");
        L12:
            if (r101 != 4) goto L14;
            this.streamData = am3.h.c(r110);
            goto L3
        L14:
            if (r101 == 5) goto L19;
            if (r101 != 6) goto L17;
            List<LiveCoreSDKData.PlayInfo> r106 = this.flv;
            LiveCoreSDKData.PlayInfo r107 = new LiveCoreSDKData.PlayInfo(r110);
        L20:
            r106.add(r107);
            goto L3
        L17:
            am3.h.e(r110);
            goto L3
        L19:
            r106 = this.hls;
            r107 = new LiveCoreSDKData.PlayInfo(r110);
            goto L20
        L38:
            long r112 = r110.c();
            r103 = null;
        L39:
            int r108 = r110.f();
            if (r108 == (-1)) goto L46;
            if (r108 != 1) goto L42;
            r102 = am3.h.c(r110);
            goto L39
        L42:
            if (r108 != 2) goto L43;
            r103 = new LiveCoreSDKData.PullData(r110);
            goto L39
        L43:
            am3.h.e(r110);
            goto L39
        L46:
            r110.d(r112);
            r105 = this.pullDatas;
            if (r102 == null) goto L53;
            if (r103 != null) goto L33;
            throw new IllegalStateException("Value must not be null");
        L53:
            throw new IllegalStateException("Key must not be null");
        L55:
            r110.d(r100);
        }
    }

    @ProtoMessage("webcast.data.StreamUrl.PlaySetting")
    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0004R \u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR \u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/StreamUrl$PlaySetting;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IPlaySetting;", "Ljava/io/Serializable;", "()V", "horizontal", "", "getHorizontal", "()Ljava/lang/String;", "setHorizontal", "(Ljava/lang/String;)V", "vertical", "getVertical", "setVertical", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class PlaySetting extends FlexModelBase<IPlaySetting> implements IPlaySetting, h {

        @SerializedName("horizontal")
        protected String horizontal;

        @SerializedName("vertical")
        protected String vertical;

        public PlaySetting() {
            super(IPlaySetting.class);
        }

        public PlaySetting(g r100) {
            super(IPlaySetting.class);
            setThreadSafe(false);
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L12;
            g.a r103 = decodeExtensionFields(r102, r100);
            if (r102 != 1) goto L8;
            this.horizontal = am3.h.c(r100);
            goto L3
        L8:
            if (r102 != 2) goto L9;
            this.vertical = am3.h.c(r100);
            goto L3
        L9:
            am3.h.d(r103, r100);
            goto L3
        L12:
            r100.d(r101);
            setThreadSafe(true);
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IPlaySetting
        public String getHorizontal() {
            return this.horizontal;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IPlaySetting
        public String getVertical() {
            return this.vertical;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IPlaySetting
        public void setHorizontal(String r100) {
            this.horizontal = r100;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.IPlaySetting
        public void setVertical(String r100) {
            this.vertical = r100;
        }
    }

    static {
        Companion = new Companion(null);
    }

    private final IPullData getRealPullData() {
    L20:
        e = move-exception;
        Logger.e("streamUrl getRealPullData", "error", e);
        return null;
    L4:
        if (getPlay() != null) goto L6;
        return null;
    L6:
        IPlaySetting r100 = getPlay();     // Catch: Exception -> L20
        if (r100 == null) goto L9;
        String r101 = r100.getVertical();     // Catch: Exception -> L20
    L11:
        if (Intrinsics.areEqual(PullConfiguration.PROCESS_NAME_MAIN, r101) == false) goto L13;
    L16:
        LiveCoreSDKData r102 = getLiveCoreSDKData();     // Catch: Exception -> L20
        if (r102 != null) goto L26;
        return null;
    L26:
        return r102.pullData;
    L13:
        if (getPullDatas() == null) goto L16;
        Map<String, IPullData> r103 = getPullDatas();     // Catch: Exception -> L20
        Intrinsics.checkNotNull(r103);     // Catch: Exception -> L20
        return r103.get(r101);
    L9:
        r101 = null;
        goto L11
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrlEx
    public IExtension getExtension() {
        if (getPullDatas() != null) goto L6;
        return null;
    L6:
        if (getPlay() == null) goto L17;
        IPlaySetting r100 = getPlay();     // Catch: Throwable -> L13
        Intrinsics.checkNotNull(r100);     // Catch: Throwable -> L13
        if (r100.getVertical() == null) goto L18;
        Map<String, IPullData> r101 = getPullDatas();     // Catch: Throwable -> L13
        Intrinsics.checkNotNull(r101);     // Catch: Throwable -> L13
        IPlaySetting r102 = getPlay();     // Catch: Throwable -> L13
        Intrinsics.checkNotNull(r102);     // Catch: Throwable -> L13
        IPullData r103 = r101.get(r102.getVertical());     // Catch: Throwable -> L13
        if (r103 == null) goto L19;
        return r103.getExtension();
    L19:
        return null;
    L18:
        return null;
    L17:
        return null;
    L20:
        return null;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrlEx
    public void validateMultiPullData() {
        List<IQuality> r100 = null;
        this.multiDefaultQuality = null;
        this.multiLowestQuality = null;
        this.qualityList.clear();
        if (getLiveCoreSDKData() == null) goto L43;
        LiveCoreSDKData r101 = getLiveCoreSDKData();
        Intrinsics.checkNotNull(r101);
        if (r101.pullData == null) goto L45;
        IPullData r102 = getRealPullData();
        LiveCoreSDKData r103 = getLiveCoreSDKData();
        Intrinsics.checkNotNull(r103);
        LiveCoreSDKData.PullData r104 = r103.pullData;
        Intrinsics.checkNotNull(r104);
        IOptions r105 = r104.getOptions();
        if (isCompoundScene() == false) goto L18;
        if (r102 == null) goto L18;
        if (r102.getOptions() == null) goto L18;
        IOptions r106 = r102.getOptions();
        if (r106 == null) goto L16;
        r100 = r106.getQualityList();
    L16:
        if (Lists.isEmpty(r100) == true) goto L18;
        r105 = r102.getOptions();
    L18:
        if (r105 != null) goto L20;
        return;
    L20:
        List<IQuality> r107 = r105.getQualityList();
        if (r107 != null) goto L23;
    L26:
        boolean r108 = true;
    L27:
        if (r108 == true) goto L34;
        List<IQuality> r109 = r105.getQualityList();
        Intrinsics.checkNotNull(r109);
        Iterator<IQuality> r110 = r109.iterator();
    L30:
        if (r110.hasNext() == false) goto L34;
        IQuality r111 = r110.next();
        this.qualityList.add(r111);
        if (this.multiLowestQuality != null) goto L30;
        this.multiLowestQuality = r111;
    L34:
        this.multiDefaultQuality = r105.getDefaultQuality();
        if (this.qualityList.isEmpty() == false) goto L44;
        IQuality r112 = this.multiDefaultQuality;
        this.multiLowestQuality = r112;
        List<IQuality> r113 = this.qualityList;
        Intrinsics.checkNotNull(r112);
        r113.add(r112);
        return;
    L44:
        return;
    L23:
        if (r107.isEmpty() == true) goto L26;
        r108 = false;
        goto L27
    L45:
        return;
    }

    public StreamUrl() {
        super(IBaseStreamUrl.class);
        this.qualityMap = new LinkedHashMap();
        this.sdkParamsMap = new LinkedHashMap();
        this.qualityList = new ArrayList();
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrlEx
    public String getMultiStreamDataFromPullDatas() {
        OpenStreamUrlEncrypt r100 = this.openStreamUrlEncrypt;
        if (r100 == null) goto L17;
        Map<String, LiveCoreSDKData.PullData> r101 = r100.pullDatas;
        if (r101 != null) goto L7;
        return null;
    L7:
        if (getPlay() == null) goto L30;
        IPlaySetting r102 = getPlay();
        Intrinsics.checkNotNull(r102);
        if (r102.getVertical() == null) goto L29;
        IPlaySetting r103 = getPlay();
        Intrinsics.checkNotNull(r103);
        if (r101.get(r103.getVertical()) == null) goto L31;
        IPlaySetting r104 = getPlay();
        Intrinsics.checkNotNull(r104);
        LiveCoreSDKData.PullData r105 = r101.get(r104.getVertical());
        Intrinsics.checkNotNull(r105);
        return r105.getStreamData();
    L31:
        return null;
    L29:
        return null;
    L30:
        return null;
    L17:
        if (getPullDatas() != null) goto L20;
        return null;
    L20:
        if (getPlay() == null) goto L32;
        IPlaySetting r106 = getPlay();
        Intrinsics.checkNotNull(r106);
        if (r106.getVertical() == null) goto L33;
        Map<String, IPullData> r107 = getPullDatas();
        Intrinsics.checkNotNull(r107);
        IPlaySetting r108 = getPlay();
        Intrinsics.checkNotNull(r108);
        if (r107.get(r108.getVertical()) == null) goto L34;
        Map<String, IPullData> r109 = getPullDatas();
        Intrinsics.checkNotNull(r109);
        IPlaySetting r110 = getPlay();
        Intrinsics.checkNotNull(r110);
        IPullData r111 = r109.get(r110.getVertical());
        Intrinsics.checkNotNull(r111);
        return r111.getStreamData();
    L34:
        return null;
    L33:
        return null;
    L32:
        return null;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrlEx
    public String getMultiStreamDefaultQualityName() {
        IQuality r100 = this.multiDefaultQuality;
        if (r100 != null) goto L5;
        return "";
    L5:
        Intrinsics.checkNotNull(r100);
        return r100.getName();
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrlEx
    public String getMultiStreamLowestQualityName() {
        IQuality r100 = this.multiLowestQuality;
        if (r100 != null) goto L5;
        return "";
    L5:
        Intrinsics.checkNotNull(r100);
        return r100.getName();
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrlEx
    public Set<String> getQualities() {
        return this.qualityMap.keySet();
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrl, com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrlKtDef
    public String getRtmpPushUrl() {
        if (StringUtils.isEmpty(this.ngbRTMPUrl) == false) goto L6;
        return this.mRtmpPushUrl;
    L6:
        return this.ngbRTMPUrl;
    }

    public final boolean isEncryptStreamUrl() {
        if (this.openStreamUrlEncrypt == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrlEx
    public void validatePullUrl() {
        this.qualityMap.clear();
        this.sdkParamsMap.clear();
        this.defaultQualityName = null;
        this.lowestQualityName = null;
        if (getCandidateResolution() == null) goto L31;
        if (getResolutionName() == null) goto L31;
        if (getFlvPullUrl() == null) goto L31;
        List<String> r100 = getCandidateResolution();
        Intrinsics.checkNotNull(r100);
        Iterator<String> r101 = r100.iterator();
    L10:
        if (r101.hasNext() == false) goto L31;
        String r102 = r101.next();
        Map<String, String> r103 = getResolutionName();
        Intrinsics.checkNotNull(r103);
        String r104 = r103.get(r102);
        if (r104 == null) goto L10;
        Map<String, String> r105 = getFlvPullUrl();
        Intrinsics.checkNotNull(r105);
        String r106 = r105.get(r102);
        if (r106 == null) goto L10;
        if (getPullSdkParams() != null) goto L20;
        String r107 = null;
    L21:
        this.qualityMap.put(r104, r106);
        this.sdkParamsMap.put(r104, r107);
        if (Intrinsics.areEqual(r102, getDefaultResolution()) == false) goto L25;
        this.defaultQualityName = r104;
    L28:
        if (this.lowestQualityName != null) goto L10;
        this.lowestQualityName = r104;
        goto L10
    L25:
        if (this.defaultQualityName != null) goto L28;
        this.defaultQualityName = r104;
        goto L28
    L20:
        Map<String, String> r108 = getPullSdkParams();
        Intrinsics.checkNotNull(r108);
        r107 = r108.get(r102);
    L31:
        if (c.f545229a == false) goto L47;
        if (getResolutionName() == null) goto L47;
        Map<String, String> r109 = getResolutionName();
        Intrinsics.checkNotNull(r109);
        if (r109.size() <= 0) goto L47;
        if (TextUtils.isEmpty(getDefaultResolution()) == true) goto L47;
        Map<String, String> r110 = getResolutionName();
        Intrinsics.checkNotNull(r110);
        String r111 = r110.get(getDefaultResolution());
        this.defaultQualityName = r111;
        if (TextUtils.isEmpty(r111) == true) goto L47;
        if (TextUtils.isEmpty(getRtmpPullUrl()) == true) goto L47;
        if (this.qualityMap.isEmpty() == false) goto L45;
        this.lowestQualityName = this.defaultQualityName;
    L45:
        LinkedHashMap<String, String> r112 = this.qualityMap;
        String r113 = this.defaultQualityName;
        Intrinsics.checkNotNull(r113);
        r112.put(r113, getRtmpPullUrl());
        this.sdkParamsMap.put(this.defaultQualityName, getDefaultPullSdkParams());
    L47:
        if (this.qualityMap.isEmpty() == true) goto L49;
    L51:
        OpenStreamUrlEncrypt r114 = this.openStreamUrlEncrypt;
        if (r114 == null) goto L118;
        Map<String, String> r115 = r114.flvPullUrl;
        if (getCandidateResolution() != null) goto L56;
    L80:
        String r116 = r114.rtmpPullUrl;
        if (getResolutionName() == null) goto L95;
        Map<String, String> r117 = getResolutionName();
        Intrinsics.checkNotNull(r117);
        if (r117.size() <= 0) goto L95;
        if (TextUtils.isEmpty(getDefaultResolution()) == true) goto L95;
        Map<String, String> r118 = getResolutionName();
        Intrinsics.checkNotNull(r118);
        String r119 = r118.get(getDefaultResolution());
        this.defaultQualityName = r119;
        if (TextUtils.isEmpty(r119) == true) goto L95;
        if (TextUtils.isEmpty(r116) == true) goto L95;
        if (this.qualityMap.isEmpty() == false) goto L93;
        this.lowestQualityName = this.defaultQualityName;
    L93:
        LinkedHashMap<String, String> r120 = this.qualityMap;
        String r121 = this.defaultQualityName;
        Intrinsics.checkNotNull(r121);
        r120.put(r121, r116);
        this.sdkParamsMap.put(this.defaultQualityName, getDefaultPullSdkParams());
    L95:
        if (this.qualityMap.isEmpty() == true) goto L97;
        return;
    L97:
        if (TextUtils.isEmpty(r116) == true) goto L120;
        this.defaultQualityName = "default";
        this.lowestQualityName = "default";
        LinkedHashMap<String, String> r122 = this.qualityMap;
        Intrinsics.checkNotNull("default");
        r122.put("default", r116);
        this.sdkParamsMap.put(this.defaultQualityName, getDefaultPullSdkParams());
        return;
    L120:
        return;
    L56:
        if (getResolutionName() == null) goto L80;
        if (r115 == null) goto L80;
        List<String> r123 = getCandidateResolution();
        Intrinsics.checkNotNull(r123);
        Iterator<String> r124 = r123.iterator();
    L60:
        if (r124.hasNext() == false) goto L80;
        String r125 = r124.next();
        Map<String, String> r126 = getResolutionName();
        Intrinsics.checkNotNull(r126);
        String r127 = r126.get(r125);
        if (r127 == null) goto L60;
        String r128 = r115.get(r125);
        if (r128 == null) goto L60;
        if (getPullSdkParams() != null) goto L70;
        String r129 = null;
    L71:
        this.qualityMap.put(r127, r128);
        this.sdkParamsMap.put(r127, r129);
        if (Intrinsics.areEqual(r125, getDefaultResolution()) == false) goto L75;
        this.defaultQualityName = r127;
    L78:
        if (this.lowestQualityName != null) goto L60;
        this.lowestQualityName = r127;
        goto L60
    L75:
        if (this.defaultQualityName != null) goto L78;
        this.defaultQualityName = r127;
        goto L78
    L70:
        Map<String, String> r130 = getPullSdkParams();
        Intrinsics.checkNotNull(r130);
        r129 = r130.get(r125);
        goto L71
    L118:
        return;
    L49:
        if (TextUtils.isEmpty(getRtmpPullUrl()) == true) goto L51;
        this.defaultQualityName = "default";
        this.lowestQualityName = "default";
        LinkedHashMap<String, String> r131 = this.qualityMap;
        Intrinsics.checkNotNull("default");
        r131.put("default", getRtmpPullUrl());
        this.sdkParamsMap.put(this.defaultQualityName, getDefaultPullSdkParams());
        goto L51
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrlEx
    public int getCompoundSceneType() {
        IExtension r100 = getExtension();
        if (r100 != null) goto L5;
        return 0;
    L5:
        if (r100.getLayout() != 0) goto L8;
        return 1;
    L8:
        if (r100.getLayout() != 1) goto L12;
        return 2;
    L12:
        if (r100.getLayout() != 10) goto L17;
        return 3;
    L17:
        return 0;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrlEx
    public String getCompoundStreamData() {
        IPullData r100 = getRealPullData();
        if (r100 != null) goto L6;
        return getMultiStreamData();
    L6:
        return r100.getStreamData();
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrlEx
    public String getCompoundStreamDefaultQualitySdkKey() {
        IPullData r100 = getRealPullData();
        if (r100 == null) goto L14;
        if (r100.getOptions() == null) goto L14;
        IOptions r101 = r100.getOptions();
        if (r101 == null) goto L9;
        IQuality r102 = r101.getDefaultQuality();
    L10:
        if (r102 == null) goto L14;
        return r102.getSdkKey();
    L9:
        r102 = null;
    L14:
        return getMultiStreamDefaultQualitySdkKey();
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrlEx
    public String getDefaultDefinition() {
        if (getLiveCoreSDKData() == null) goto L11;
        LiveCoreSDKData r100 = getLiveCoreSDKData();
        Intrinsics.checkNotNull(r100);
        if (r100.getDefaultQuality() == null) goto L13;
        LiveCoreSDKData r101 = getLiveCoreSDKData();
        Intrinsics.checkNotNull(r101);
        LiveCoreSDKData.Quality r102 = r101.getDefaultQuality();
        if (r102 != null) goto L10;
        return null;
    L10:
        return r102.getName();
    L13:
        return null;
    L11:
        return null;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrlEx
    public String getDefaultQualityStrategy() {
        if (getLiveCoreSDKData() == null) goto L8;
        LiveCoreSDKData r100 = getLiveCoreSDKData();
        Intrinsics.checkNotNull(r100);
        if (r100.getQualityStrategy() == null) goto L8;
        LiveCoreSDKData r101 = getLiveCoreSDKData();
        Intrinsics.checkNotNull(r101);
        return r101.getQualityStrategy();
    L8:
        return null;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrl
    public /* bridge */ /* synthetic */ ILiveCoreSDKData getLiveCoreSDKData() {
        return getLiveCoreSDKData();
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrlEx
    public String getMultiStreamData() {
        if (getLiveCoreSDKData() == null) goto L14;
        LiveCoreSDKData r100 = getLiveCoreSDKData();
        Intrinsics.checkNotNull(r100);
        if (r100.pullData != null) goto L8;
        return null;
    L8:
        if (isEncryptStreamUrl() == false) goto L10;
        OpenStreamUrlEncrypt r101 = this.openStreamUrlEncrypt;
        Intrinsics.checkNotNull(r101);
        return r101.streamData;
    L10:
        LiveCoreSDKData r102 = getLiveCoreSDKData();
        Intrinsics.checkNotNull(r102);
        LiveCoreSDKData.PullData r103 = r102.pullData;
        if (r103 != null) goto L13;
        return null;
    L13:
        return r103.getStreamData();
    L14:
        return null;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrlEx
    public String getMultiStreamDefaultQualitySdkKey() {
        if (getLiveCoreSDKData() == null) goto L11;
        LiveCoreSDKData r100 = getLiveCoreSDKData();
        Intrinsics.checkNotNull(r100);
        if (r100.getDefaultQuality() == null) goto L13;
        LiveCoreSDKData r101 = getLiveCoreSDKData();
        Intrinsics.checkNotNull(r101);
        LiveCoreSDKData.Quality r102 = r101.getDefaultQuality();
        if (r102 != null) goto L10;
        return null;
    L10:
        return r102.getSdkKey();
    L13:
        return null;
    L11:
        return null;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrlEx
    public String getPullSdkParamsStr() {
        if (getPullSdkParams() == null) goto L5;
        Map<String, String> r100 = getPullSdkParams();
        Intrinsics.checkNotNull(r100);
        return r100.get("ORIGIN");
    L5:
        return null;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrlEx
    public boolean getVPassDefault() {
        LiveCoreSDKData r100 = getLiveCoreSDKData();
        if (r100 == null) goto L9;
        LiveCoreSDKData.PullData r101 = r100.pullData;
        if (r101 == null) goto L9;
        IOptions r102 = r101.getOptions();
        if (r102 == null) goto L9;
        return r102.getVPassDefault();
    L9:
        return false;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrlEx
    public boolean hasLiveCoreSDKData() {
        if (getLiveCoreSDKData() == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrlEx
    public boolean isCompoundScene() {
        IPullData r100 = getRealPullData();
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.getKind() != 2) goto L7;
        return true;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrlEx
    public boolean isMultiPullDataValid() {
        if (getLiveCoreSDKData() != null) goto L6;
        return false;
    L6:
        validateMultiPullData();
        return !this.qualityList.isEmpty();
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrlEx
    public boolean isPullUrlValid() {
        validatePullUrl();
        return !this.qualityMap.isEmpty();
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrlEx
    public String getBindNodeRtmpUrl() {
        return this.bindNodeRtmpUrl;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrl
    public List<String> getCandidateResolution() {
        return this.candidateResolution;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrl
    public String getDefaultPullSdkParams() {
        return this.defaultPullSdkParams;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrlEx
    public String getDefaultQuality() {
        return this.defaultQualityName;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrl
    public String getDefaultResolution() {
        return this.defaultResolution;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrl, com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrlKtDef
    public IStreamUrlExtra getExtra() {
        return this._extra;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrl
    public Map<String, String> getFlvPullUrl() {
        return this.flvPullUrl;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrl
    public long getId() {
        return this.f162609id;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrl
    public String getIdStr() {
        return this.idStr;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrlEx
    public String getLowestQuality() {
        return this.lowestQualityName;
    }

    public final String getMRtmpPushUrl() {
        return this.mRtmpPushUrl;
    }

    public final IQuality getMultiDefaultQuality() {
        return this.multiDefaultQuality;
    }

    public final OpenStreamUrlEncrypt getOpenStreamUrlEncrypt() {
        return this.openStreamUrlEncrypt;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrl
    public IPlaySetting getPlay() {
        return this.play;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrl
    public int getProvider() {
        return this.provider;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrl
    public Map<String, IPullData> getPullDatas() {
        return this.pullDatas;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrl
    public Map<String, String> getPullSdkParams() {
        return this.pullSdkParams;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrl
    public String getPushSdkParams() {
        return this.pushSdkParams;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrl
    public List<String> getPushUrlList() {
        return this.pushUrlList;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrlEx
    public List<IQuality> getQualityList() {
        return this.qualityList;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrl
    public Map<String, String> getResolutionName() {
        return this.resolutionName;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrl
    public String getRtmpPullUrl() {
        return this.rtmpPullUrl;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrl
    public int getStreamOrientation() {
        return this.streamOrientation;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrl, com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrlKtDef
    public int getVrType() {
        return this.vrType;
    }

    public final IStreamUrlExtra get_extra() {
        return this._extra;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrl
    public LiveCoreSDKData getLiveCoreSDKData() {
        return this.liveCoreSDKData;
    }

    /* JADX WARN: Type inference failed for: r2v24, types: [com.bytedance.android.livesdkapi.depend.model.live.IStreamUrlExtra, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v37, types: [com.bytedance.android.livesdkapi.depend.model.live.IPlaySetting, java.lang.Object] */
    public StreamUrl(g r110) {
        super(IBaseStreamUrl.class);
        this.pushUrlList = new ArrayList();
        this.flvPullUrl = new HashMap();
        this.resolutionName = new HashMap();
        this.pullSdkParams = new HashMap();
        this.candidateResolution = new ArrayList();
        this.pullDatas = new HashMap();
        this.qualityMap = new LinkedHashMap();
        this.sdkParamsMap = new LinkedHashMap();
        this.qualityList = new ArrayList();
        setThreadSafe(false);
        long r100 = r110.c();
    L3:
        int r101 = r110.f();
        if (r101 == (-1)) goto L105;
        g.a r102 = decodeExtensionFields(r101, r110);
        if (r101 != 20) goto L8;
        this.streamControlType = r110.i();
        goto L3
    L8:
        if (r101 != 21) goto L9;
        this.streamOrientation = r110.i();
        goto L3
    L9:
        String r111 = null;
        if (r101 == 23) goto L87;
        if (r101 != 24) goto L14;
        this.play = f.a(r110, IPlaySetting.class);
        goto L3
    L14:
        if (r101 != 26) goto L16;
        this.vrType = r110.i();
        goto L3
    L16:
        if (r101 != 28) goto L18;
        this.resolutionSelectPanelResident = r110.i();
        goto L3
    L18:
        if (r101 != 5000) goto L19;
        this.openStreamUrlEncrypt = new OpenStreamUrlEncrypt(r110);
        goto L3
    L19:
        switch(r101) {
            case 1: goto L82;
            case 2: goto L81;
            case 3: goto L80;
            case 4: goto L64;
            case 5: goto L63;
            case 6: goto L62;
            case 7: goto L61;
            case 8: goto L60;
            case 9: goto L44;
            case 10: goto L42;
            default: goto L20;
        };
    L42:
        List<String> r103 = this.candidateResolution;
    L43:
        r103.add(am3.h.c(r110));
        goto L3
    L44:
        long r104 = r110.c();
        Object r105 = null;
    L45:
        int r112 = r110.f();
        if (r112 == (-1)) goto L52;
        if (r112 != 1) goto L48;
        r111 = am3.h.c(r110);
        goto L45
    L48:
        if (r112 != 2) goto L49;
        r105 = am3.h.c(r110);
        goto L45
    L49:
        am3.h.e(r110);
        goto L45
    L52:
        r110.d(r104);
        Map r106 = this.flvPullUrl;
        if (r111 == null) goto L59;
        if (r105 == null) goto L57;
    L75:
        r106.put(r111, r105);
        goto L3
    L57:
        throw new IllegalStateException("Value must not be null");
    L59:
        throw new IllegalStateException("Key must not be null");
    L60:
        this.rtmpPullUrl = am3.h.c(r110);
        goto L3
    L61:
        this.mRtmpPushUrl = am3.h.c(r110);
        goto L3
    L62:
        this._extra = f.a(r110, IStreamUrlExtra.class);
        goto L3
    L63:
        this.defaultResolution = am3.h.c(r110);
        goto L3
    L64:
        long r107 = r110.c();
        r105 = null;
    L65:
        int r113 = r110.f();
        if (r113 == (-1)) goto L72;
        if (r113 != 1) goto L68;
        r111 = am3.h.c(r110);
        goto L65
    L68:
        if (r113 != 2) goto L69;
        r105 = am3.h.c(r110);
        goto L65
    L69:
        am3.h.e(r110);
        goto L65
    L72:
        r110.d(r107);
        r106 = this.resolutionName;
        if (r111 == null) goto L79;
        if (r105 != null) goto L75;
        throw new IllegalStateException("Value must not be null");
    L79:
        throw new IllegalStateException("Key must not be null");
    L80:
        this.idStr = am3.h.c(r110);
        goto L3
    L81:
        this.f162609id = r110.j();
        goto L3
    L82:
        this.provider = (int) r110.j();
        goto L3
    L20:
        switch(r101) {
            case 13: goto L41;
            case 14: goto L25;
            case 15: goto L24;
            case 16: goto L23;
            case 17: goto L22;
            default: goto L21;
        };
    L22:
        this.liveCoreSDKData = new LiveCoreSDKData(r110);
        goto L3
    L23:
        r103 = this.pushUrlList;
        goto L43
    L24:
        this.pushSdkParams = am3.h.c(r110);
        goto L3
    L25:
        long r108 = r110.c();
        r105 = null;
    L26:
        int r114 = r110.f();
        if (r114 == (-1)) goto L33;
        if (r114 != 1) goto L29;
        r111 = am3.h.c(r110);
        goto L26
    L29:
        if (r114 != 2) goto L30;
        r105 = am3.h.c(r110);
        goto L26
    L30:
        am3.h.e(r110);
        goto L26
    L33:
        r110.d(r108);
        r106 = this.pullSdkParams;
        if (r111 == null) goto L40;
        if (r105 != null) goto L75;
        throw new IllegalStateException("Value must not be null");
    L40:
        throw new IllegalStateException("Key must not be null");
    L41:
        this.defaultPullSdkParams = am3.h.c(r110);
        goto L3
    L21:
        am3.h.d(r102, r110);
        goto L3
    L87:
        long r109 = r110.c();
        r105 = null;
    L88:
        int r115 = r110.f();
        if (r115 == (-1)) goto L95;
        if (r115 != 1) goto L91;
        r111 = am3.h.c(r110);
        goto L88
    L91:
        if (r115 != 2) goto L92;
        r105 = f.a(r110, IPullData.class);
        goto L88
    L92:
        am3.h.e(r110);
        goto L88
    L95:
        r110.d(r109);
        r106 = this.pullDatas;
        if (r111 == null) goto L102;
        if (r105 != null) goto L75;
        throw new IllegalStateException("Value must not be null");
    L102:
        throw new IllegalStateException("Key must not be null");
    L105:
        r110.d(r100);
        setThreadSafe(true);
    }

    public final boolean decryptLiveUrl(String r110) {
        Intrinsics.checkNotNullParameter(r110, "encryptKeyStr");
        OpenStreamUrlEncrypt r100 = this.openStreamUrlEncrypt;     // Catch: Throwable -> L79
        if (r100 != null) goto L6;
    L78:
        return false;
    L6:
        if (r110.length() <= 0) goto L8;
        boolean r101 = true;
    L9:
        if (r101 == false) goto L78;
        LiveCoreSDKData r102 = getLiveCoreSDKData();     // Catch: Throwable -> L79
        if (r102 == null) goto L15;
        LiveCoreSDKData.PullData r103 = r102.pullData;     // Catch: Throwable -> L79
        if (r103 == null) goto L15;
        r103.setStreamData(AESDecryptLiveUrlUtils.INSTANCE.getDecryptPullUrl(r100.streamData, r110));     // Catch: Throwable -> L79
        decryptPlayInfo(r110, r103, r100.hls, r100.flv);     // Catch: Throwable -> L79
    L15:
        setRtmpPullUrl(AESDecryptLiveUrlUtils.INSTANCE.getDecryptPullUrl(r100.rtmpPullUrl, r110));     // Catch: Throwable -> L79
        Map<String, String> r104 = r100.flvPullUrl;     // Catch: Throwable -> L79
        if (r104 != null) goto L18;
    L36:
        Map<String, LiveCoreSDKData.PullData> r105 = r100.pullDatas;     // Catch: Throwable -> L79
        if (r105 == null) goto L78;
        if ((!r105.isEmpty()) == true) goto L42;
        r105 = null;
    L42:
        if (r105 == null) goto L78;
        LinkedHashMap r106 = new LinkedHashMap(MapsKt.mapCapacity(r105.size()));     // Catch: Throwable -> L79
        Iterator<T> r107 = r105.entrySet().iterator();     // Catch: Throwable -> L79
    L45:
        if (r107.hasNext() == false) goto L59;
        Object r108 = r107.next();     // Catch: Throwable -> L79
        Object r109 = ((Map.Entry) r108).getKey();     // Catch: Throwable -> L79
        Map.Entry r111 = (Map.Entry) r108;     // Catch: Throwable -> L79
        String r112 = (String) r111.getKey();     // Catch: Throwable -> L79
        LiveCoreSDKData.PullData r113 = (LiveCoreSDKData.PullData) r111.getValue();     // Catch: Throwable -> L79
        if (r113 == null) goto L57;
        r113.setStreamData(AESDecryptLiveUrlUtils.INSTANCE.getDecryptPullUrl(r113.getStreamData(), r110));     // Catch: Throwable -> L79
        List<LiveCoreSDKData.PlayInfo> r114 = r113.getHls();     // Catch: Throwable -> L79
        if (r114 != null) goto L52;
        r114 = null;
    L52:
        List<LiveCoreSDKData.PlayInfo> r115 = r113.getFlv();     // Catch: Throwable -> L79
        if (r115 != null) goto L56;
        r115 = null;
    L56:
        decryptPlayInfo(r110, r113, r114, r115);     // Catch: Throwable -> L79
    L58:
        r106.put(r109, r113);     // Catch: Throwable -> L79
        goto L45
    L57:
        r113 = null;
        goto L58
    L59:
        LinkedHashMap r116 = new LinkedHashMap();     // Catch: Throwable -> L79
        Iterator r117 = r106.entrySet().iterator();     // Catch: Throwable -> L79
    L61:
        if (r117.hasNext() == false) goto L68;
        Map.Entry r118 = (Map.Entry) r117.next();     // Catch: Throwable -> L79
        if (((String) r118.getKey()) == null) goto L65;
        boolean r119 = true;
    L66:
        if (r119 == false) goto L61;
        r116.put(r118.getKey(), r118.getValue());     // Catch: Throwable -> L79
        goto L61
    L65:
        r119 = false;
        goto L66
    L68:
        LinkedHashMap r120 = new LinkedHashMap();     // Catch: Throwable -> L79
        Iterator r121 = r116.entrySet().iterator();     // Catch: Throwable -> L79
    L70:
        if (r121.hasNext() == false) goto L77;
        Map.Entry r122 = (Map.Entry) r121.next();     // Catch: Throwable -> L79
        if (((LiveCoreSDKData.PullData) r122.getValue()) == null) goto L74;
        boolean r123 = true;
    L75:
        if (r123 == false) goto L70;
        r120.put(r122.getKey(), r122.getValue());     // Catch: Throwable -> L79
        goto L70
    L74:
        r123 = false;
        goto L75
    L77:
        setPullDatas(MapsKt.toMutableMap(r120));     // Catch: Throwable -> L79
        goto L78
    L18:
        if ((!r104.isEmpty()) == true) goto L21;
        r104 = null;
    L21:
        if (r104 == null) goto L36;
        LinkedHashMap r124 = new LinkedHashMap(MapsKt.mapCapacity(r104.size()));     // Catch: Throwable -> L79
        Iterator<T> r125 = r104.entrySet().iterator();     // Catch: Throwable -> L79
    L24:
        if (r125.hasNext() == false) goto L26;
        Object r126 = r125.next();     // Catch: Throwable -> L79
        r124.put(((Map.Entry) r126).getKey(), AESDecryptLiveUrlUtils.INSTANCE.getDecryptPullUrl((String) ((Map.Entry) r126).getValue(), r110));     // Catch: Throwable -> L79
        goto L24
    L26:
        LinkedHashMap r127 = new LinkedHashMap();     // Catch: Throwable -> L79
        Iterator r128 = r124.entrySet().iterator();     // Catch: Throwable -> L79
    L28:
        if (r128.hasNext() == false) goto L35;
        Map.Entry r129 = (Map.Entry) r128.next();     // Catch: Throwable -> L79
        if (((String) r129.getValue()) == null) goto L32;
        boolean r130 = true;
    L33:
        if (r130 == false) goto L28;
        r127.put(r129.getKey(), r129.getValue());     // Catch: Throwable -> L79
        goto L28
    L32:
        r130 = false;
        goto L33
    L35:
        setFlvPullUrl(MapsKt.toMutableMap(r127));     // Catch: Throwable -> L79
        goto L36
    L8:
        r101 = false;
    L79:
        th = move-exception;
        Logger.e("StreamUrl", "decrypt pull url failed", th);
        return true;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrlEx
    public String getMultiStreamDataFromPullDatas(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        if (getPullDatas() != null) goto L6;
        return null;
    L6:
        if (TextUtils.isEmpty(r100) == true) goto L12;
        Map<String, IPullData> r101 = getPullDatas();
        Intrinsics.checkNotNull(r101);
        if (r101.get(r100) == null) goto L13;
        Map<String, IPullData> r102 = getPullDatas();
        Intrinsics.checkNotNull(r102);
        IPullData r103 = r102.get(r100);
        Intrinsics.checkNotNull(r103);
        return r103.getStreamData();
    L13:
        return null;
    L12:
        return null;
    }

    public final void setBindNodeRtmpUrl(String r100) {
        this.bindNodeRtmpUrl = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrl
    public void setCandidateResolution(List<String> r100) {
        this.candidateResolution = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrl
    public void setDefaultPullSdkParams(String r100) {
        this.defaultPullSdkParams = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrl
    public void setDefaultResolution(String r100) {
        this.defaultResolution = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrl
    public void setFlvPullUrl(Map<String, String> r100) {
        this.flvPullUrl = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrl
    public void setId(long r100) {
        this.f162609id = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrl
    public void setIdStr(String r100) {
        this.idStr = r100;
    }

    public void setLiveCoreSDKData(LiveCoreSDKData r100) {
        this.liveCoreSDKData = r100;
    }

    public final void setMRtmpPushUrl(String r100) {
        this.mRtmpPushUrl = r100;
    }

    public final void setMultiDefaultQuality(IQuality r100) {
        this.multiDefaultQuality = r100;
    }

    public final void setNgbRTMPUrl(String r100) {
        this.ngbRTMPUrl = r100;
    }

    public final void setOpenStreamUrlEncrypt(OpenStreamUrlEncrypt r100) {
        this.openStreamUrlEncrypt = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrl
    public void setPlay(IPlaySetting r100) {
        this.play = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrl
    public void setProvider(int r100) {
        this.provider = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrl
    public void setPullDatas(Map<String, ? extends IPullData> r100) {
        this.pullDatas = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrl
    public void setPullSdkParams(Map<String, String> r100) {
        this.pullSdkParams = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrl
    public void setPushSdkParams(String r100) {
        this.pushSdkParams = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrl
    public void setPushUrlList(List<String> r100) {
        this.pushUrlList = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrl
    public void setResolutionName(Map<String, String> r100) {
        this.resolutionName = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrl
    public void setRtmpPullUrl(String r100) {
        this.rtmpPullUrl = r100;
    }

    public void setRtmpPushUrl(String r100) {
        this.mRtmpPushUrl = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrl
    public void setStreamOrientation(int r100) {
        this.streamOrientation = r100;
    }

    public void setVrType(int r100) {
        this.vrType = r100;
    }

    public final void set_extra(IStreamUrlExtra r100) {
        this._extra = r100;
    }

    public final void decryptPlayInfo(String r100, LiveCoreSDKData.PullData r101, List<LiveCoreSDKData.PlayInfo> r110, List<LiveCoreSDKData.PlayInfo> r111) {
        Intrinsics.checkNotNullParameter(r101, "pullData");
        int r102 = 0;
        if (r110 == null) goto L11;
        List<LiveCoreSDKData.PlayInfo> r103 = r110;
        int r104 = r103.size();
        int r105 = 0;
    L5:
        if (r105 >= r104) goto L10;
        LiveCoreSDKData.PlayInfo r106 = (LiveCoreSDKData.PlayInfo) ListProtector.get(r110, r105);
        if (r106 == null) goto L9;
        r106.setUrl(AESDecryptLiveUrlUtils.INSTANCE.getDecryptPullUrl(r106.getUrl(), r100));
    L9:
        r105 = r105 + 1;
        goto L5
    L10:
        r101.setHls(CollectionsKt.toMutableList(r103));
    L11:
        if (r111 == null) goto L26;
        List<LiveCoreSDKData.PlayInfo> r112 = r111;
        int r107 = r112.size();
    L13:
        if (r102 >= r107) goto L18;
        LiveCoreSDKData.PlayInfo r108 = (LiveCoreSDKData.PlayInfo) ListProtector.get(r111, r102);
        if (r108 == null) goto L17;
        r108.setUrl(AESDecryptLiveUrlUtils.INSTANCE.getDecryptPullUrl(r108.getUrl(), r100));
    L17:
        r102 = r102 + 1;
        goto L13
    L18:
        r101.setFlv(CollectionsKt.toMutableList(r112));
        return;
    }
}
