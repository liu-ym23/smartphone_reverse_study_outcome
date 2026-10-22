package com.bytedance.android.livesdkapi.depend.model.live;

import com.bytedance.android.livesdkapi.roomplayer.VrBgLogData;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u00022\u00020\u0003R\u001a\u0010\t\u001a\u00020\u00048&X§\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u000e\u001a\u00020\n8&X§\u0004¢\u0006\f\u0012\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u000f8&X§\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\b\u001a\u0004\b\u0010\u0010\u0011R\"\u0010\u0018\u001a\u00020\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0017\u0010\b\u001a\u0004\b\u0014\u0010\f\"\u0004\b\u0015\u0010\u0016R$\u0010\u001d\u001a\u0004\u0018\u00010\u000f8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001c\u0010\b\u001a\u0004\b\u0019\u0010\u0011\"\u0004\b\u001a\u0010\u001bR6\u0010%\u001a\u0016\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u001ej\n\u0012\u0004\u0012\u00020\u000f\u0018\u0001`\u001f8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b$\u0010\b\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#RB\u0010-\u001a\"\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010&j\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u0001`'8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b,\u0010\b\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+RB\u00101\u001a\"\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010&j\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u0001`'8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b0\u0010\b\u001a\u0004\b.\u0010)\"\u0004\b/\u0010+R$\u00105\u001a\u0004\u0018\u00010\u000f8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b4\u0010\b\u001a\u0004\b2\u0010\u0011\"\u0004\b3\u0010\u001bR$\u00109\u001a\u0004\u0018\u00010\u000f8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b8\u0010\b\u001a\u0004\b6\u0010\u0011\"\u0004\b7\u0010\u001bR$\u0010=\u001a\u0004\u0018\u00010\u000f8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b<\u0010\b\u001a\u0004\b:\u0010\u0011\"\u0004\b;\u0010\u001bR\u001c\u0010B\u001a\u0004\u0018\u00010>8&X§\u0004¢\u0006\f\u0012\u0004\bA\u0010\b\u001a\u0004\b?\u0010@R$\u0010F\u001a\u0004\u0018\u00010\u000f8&@&X§\u000e¢\u0006\u0012\u0012\u0004\bE\u0010\b\u001a\u0004\bC\u0010\u0011\"\u0004\bD\u0010\u001bR\"\u0010M\u001a\u00020G8&@&X§\u000e¢\u0006\u0012\u0012\u0004\bL\u0010\b\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR$\u0010T\u001a\u0004\u0018\u00010N8&@&X§\u000e¢\u0006\u0012\u0012\u0004\bS\u0010\b\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RRJ\u0010Y\u001a*\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0006\u0012\u0004\u0018\u00010U\u0018\u00010&j\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0006\u0012\u0004\u0018\u00010U\u0018\u0001`'8&@&X§\u000e¢\u0006\u0012\u0012\u0004\bX\u0010\b\u001a\u0004\bV\u0010)\"\u0004\bW\u0010+R\"\u0010]\u001a\u00020\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\\\u0010\b\u001a\u0004\bZ\u0010\f\"\u0004\b[\u0010\u0016R6\u0010a\u001a\u0016\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u001ej\n\u0012\u0004\u0012\u00020\u000f\u0018\u0001`\u001f8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b`\u0010\b\u001a\u0004\b^\u0010!\"\u0004\b_\u0010#RB\u0010e\u001a\"\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010&j\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u0001`'8&@&X§\u000e¢\u0006\u0012\u0012\u0004\bd\u0010\b\u001a\u0004\bb\u0010)\"\u0004\bc\u0010+¨\u0006f"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/IBaseStreamUrl;", "Lvh7/c;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IBaseStreamUrlKtDef;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IBaseStreamUrlEx;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IStreamUrlExtra;", "getExtra", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IStreamUrlExtra;", "getExtra$annotations", "()V", "extra", "", "getVrType", "()I", "getVrType$annotations", "vrType", "", "getRtmpPushUrl", "()Ljava/lang/String;", "getRtmpPushUrl$annotations", "rtmpPushUrl", "getStreamOrientation", "setStreamOrientation", "(I)V", "getStreamOrientation$annotations", "streamOrientation", "getDefaultPullSdkParams", "setDefaultPullSdkParams", "(Ljava/lang/String;)V", "getDefaultPullSdkParams$annotations", "defaultPullSdkParams", "", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getPushUrlList", "()Ljava/util/List;", "setPushUrlList", "(Ljava/util/List;)V", "getPushUrlList$annotations", "pushUrlList", "", "Lcom/bytedance/revenue/platform/api/core/KmpMap;", "getFlvPullUrl", "()Ljava/util/Map;", "setFlvPullUrl", "(Ljava/util/Map;)V", "getFlvPullUrl$annotations", "flvPullUrl", "getResolutionName", "setResolutionName", "getResolutionName$annotations", "resolutionName", "getRtmpPullUrl", "setRtmpPullUrl", "getRtmpPullUrl$annotations", "rtmpPullUrl", "getIdStr", "setIdStr", "getIdStr$annotations", "idStr", "getPushSdkParams", "setPushSdkParams", "getPushSdkParams$annotations", "pushSdkParams", "Lcom/bytedance/android/livesdkapi/depend/model/live/ILiveCoreSDKData;", "getLiveCoreSDKData", "()Lcom/bytedance/android/livesdkapi/depend/model/live/ILiveCoreSDKData;", "getLiveCoreSDKData$annotations", "liveCoreSDKData", "getDefaultResolution", "setDefaultResolution", "getDefaultResolution$annotations", "defaultResolution", "", "getId", "()J", "setId", "(J)V", "getId$annotations", "id", "Lcom/bytedance/android/livesdkapi/depend/model/live/IPlaySetting;", "getPlay", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IPlaySetting;", "setPlay", "(Lcom/bytedance/android/livesdkapi/depend/model/live/IPlaySetting;)V", "getPlay$annotations", "play", "Lcom/bytedance/android/livesdkapi/depend/model/live/IPullData;", "getPullDatas", "setPullDatas", "getPullDatas$annotations", "pullDatas", "getProvider", "setProvider", "getProvider$annotations", ShortVideoSegments.KEY_PROP_PROVIDER, "getCandidateResolution", "setCandidateResolution", "getCandidateResolution$annotations", "candidateResolution", "getPullSdkParams", "setPullSdkParams", "getPullSdkParams$annotations", "pullSdkParams", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IBaseStreamUrl extends c<IBaseStreamUrl>, IBaseStreamUrlKtDef, IBaseStreamUrlEx {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "candidate_resolution")
        public static /* synthetic */ void getCandidateResolution$annotations() {
        }

        @FieldName(name = "rtmp_pull_url_params")
        public static /* synthetic */ void getDefaultPullSdkParams$annotations() {
        }

        @FieldName(name = "default_resolution")
        public static /* synthetic */ void getDefaultResolution$annotations() {
        }

        @FieldName(name = "extra")
        public static /* synthetic */ void getExtra$annotations() {
        }

        @FieldName(name = "flv_pull_url")
        public static /* synthetic */ void getFlvPullUrl$annotations() {
        }

        @FieldName(name = "id")
        public static /* synthetic */ void getId$annotations() {
        }

        @FieldName(name = "id_str")
        public static /* synthetic */ void getIdStr$annotations() {
        }

        @FieldName(name = "live_core_sdk_data")
        public static /* synthetic */ void getLiveCoreSDKData$annotations() {
        }

        @FieldName(name = "play")
        public static /* synthetic */ void getPlay$annotations() {
        }

        @FieldName(name = ShortVideoSegments.KEY_PROP_PROVIDER)
        public static /* synthetic */ void getProvider$annotations() {
        }

        @FieldName(name = "pull_datas")
        public static /* synthetic */ void getPullDatas$annotations() {
        }

        @FieldName(name = "flv_pull_url_params")
        public static /* synthetic */ void getPullSdkParams$annotations() {
        }

        @FieldName(name = "rtmp_push_url_params")
        public static /* synthetic */ void getPushSdkParams$annotations() {
        }

        @FieldName(name = "push_urls")
        public static /* synthetic */ void getPushUrlList$annotations() {
        }

        @FieldName(name = "resolution_name")
        public static /* synthetic */ void getResolutionName$annotations() {
        }

        @FieldName(name = "rtmp_pull_url")
        public static /* synthetic */ void getRtmpPullUrl$annotations() {
        }

        @FieldName(name = "rtmp_push_url")
        public static /* synthetic */ void getRtmpPushUrl$annotations() {
        }

        @FieldName(name = "stream_orientation")
        public static /* synthetic */ void getStreamOrientation$annotations() {
        }

        @FieldName(name = VrBgLogData.KEY_VR_TYPE)
        public static /* synthetic */ void getVrType$annotations() {
        }
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "candidate_resolution")
    List<String> getCandidateResolution();

    @FieldName(name = "rtmp_pull_url_params")
    String getDefaultPullSdkParams();

    @FieldName(name = "default_resolution")
    String getDefaultResolution();

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrlKtDef
    @FieldName(name = "extra")
    IStreamUrlExtra getExtra();

    @FieldName(name = "flv_pull_url")
    Map<String, String> getFlvPullUrl();

    @FieldName(name = "id")
    long getId();

    @FieldName(name = "id_str")
    String getIdStr();

    @FieldName(name = "live_core_sdk_data")
    ILiveCoreSDKData getLiveCoreSDKData();

    @FieldName(name = "play")
    IPlaySetting getPlay();

    @FieldName(name = ShortVideoSegments.KEY_PROP_PROVIDER)
    int getProvider();

    @FieldName(name = "pull_datas")
    Map<String, IPullData> getPullDatas();

    @FieldName(name = "flv_pull_url_params")
    Map<String, String> getPullSdkParams();

    @FieldName(name = "rtmp_push_url_params")
    String getPushSdkParams();

    @FieldName(name = "push_urls")
    List<String> getPushUrlList();

    @FieldName(name = "resolution_name")
    Map<String, String> getResolutionName();

    @FieldName(name = "rtmp_pull_url")
    String getRtmpPullUrl();

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrlKtDef
    @FieldName(name = "rtmp_push_url")
    String getRtmpPushUrl();

    @FieldName(name = "stream_orientation")
    int getStreamOrientation();

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrlKtDef
    @FieldName(name = VrBgLogData.KEY_VR_TYPE)
    int getVrType();

    @FieldName(name = "candidate_resolution#setter")
    void setCandidateResolution(List<String> r100);

    @FieldName(name = "rtmp_pull_url_params#setter")
    void setDefaultPullSdkParams(String r100);

    @FieldName(name = "default_resolution#setter")
    void setDefaultResolution(String r100);

    @FieldName(name = "flv_pull_url#setter")
    void setFlvPullUrl(Map<String, String> r100);

    @FieldName(name = "id#setter")
    void setId(long r100);

    @FieldName(name = "id_str#setter")
    void setIdStr(String r100);

    @FieldName(name = "play#setter")
    void setPlay(IPlaySetting r100);

    @FieldName(name = "provider#setter")
    void setProvider(int r100);

    @FieldName(name = "pull_datas#setter")
    void setPullDatas(Map<String, ? extends IPullData> r100);

    @FieldName(name = "flv_pull_url_params#setter")
    void setPullSdkParams(Map<String, String> r100);

    @FieldName(name = "rtmp_push_url_params#setter")
    void setPushSdkParams(String r100);

    @FieldName(name = "push_urls#setter")
    void setPushUrlList(List<String> r100);

    @FieldName(name = "resolution_name#setter")
    void setResolutionName(Map<String, String> r100);

    @FieldName(name = "rtmp_pull_url#setter")
    void setRtmpPullUrl(String r100);

    @FieldName(name = "stream_orientation#setter")
    void setStreamOrientation(int r100);
}
