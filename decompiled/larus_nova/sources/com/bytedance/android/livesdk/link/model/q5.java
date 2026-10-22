package com.bytedance.android.livesdk.link.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0014\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002R\u001a\u0010\b\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005R\u001a\u0010\r\u001a\u00020\t8&X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0007\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0012\u001a\u00020\u000e8&X§\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0007\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0017\u001a\u00020\u00138&X§\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0007\u001a\u0004\b\u0014\u0010\u0015R6\u0010 \u001a\u0016\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018j\n\u0012\u0004\u0012\u00020\u0019\u0018\u0001`\u001a8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001f\u0010\u0007\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010%\u001a\u00020!8&X§\u0004¢\u0006\f\u0012\u0004\b$\u0010\u0007\u001a\u0004\b\"\u0010#R\u001c\u0010*\u001a\u0004\u0018\u00010&8&X§\u0004¢\u0006\f\u0012\u0004\b)\u0010\u0007\u001a\u0004\b'\u0010(R\u001c\u0010/\u001a\u0004\u0018\u00010+8&X§\u0004¢\u0006\f\u0012\u0004\b.\u0010\u0007\u001a\u0004\b,\u0010-R$\u00106\u001a\u0004\u0018\u0001008&@&X§\u000e¢\u0006\u0012\u0012\u0004\b5\u0010\u0007\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001a\u0010;\u001a\u0002078&X§\u0004¢\u0006\f\u0012\u0004\b:\u0010\u0007\u001a\u0004\b8\u00109R\u001a\u0010>\u001a\u00020\u000e8&X§\u0004¢\u0006\f\u0012\u0004\b=\u0010\u0007\u001a\u0004\b<\u0010\u0010R\u001a\u0010A\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b@\u0010\u0007\u001a\u0004\b?\u0010\u0005R\u001a\u0010D\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\bC\u0010\u0007\u001a\u0004\bB\u0010\u0005R\u001c\u0010G\u001a\u0004\u0018\u00010\t8&X§\u0004¢\u0006\f\u0012\u0004\bF\u0010\u0007\u001a\u0004\bE\u0010\u000bR\u001c\u0010J\u001a\u0004\u0018\u00010\t8&X§\u0004¢\u0006\f\u0012\u0004\bI\u0010\u0007\u001a\u0004\bH\u0010\u000b¨\u0006K"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/q5;", "Lvh7/e;", "Lcom/bytedance/android/livesdk/link/model/bridge/d1;", "", "getSwitchToScene", "()I", "getSwitchToScene$annotations", "()V", "switchToScene", "", "getAccessKey", "()Ljava/lang/String;", "getAccessKey$annotations", "accessKey", "", "getCurMaxInviteNum", "()J", "getCurMaxInviteNum$annotations", "curMaxInviteNum", "", "getBizJoinChannel", "()Z", "getBizJoinChannel$annotations", "bizJoinChannel", "", "Lcom/bytedance/android/livesdk/link/model/p;", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getLinkUsers", "()Ljava/util/List;", "setLinkUsers", "(Ljava/util/List;)V", "getLinkUsers$annotations", "linkUsers", "Lcom/bytedance/android/livesdk/link/model/m;", "getLayoutInfo", "()Lcom/bytedance/android/livesdk/link/model/m;", "getLayoutInfo$annotations", "layoutInfo", "Lcom/bytedance/android/livesdk/link/model/bridge/v1;", "getMultiRtcInfo", "()Lcom/bytedance/android/livesdk/link/model/bridge/v1;", "getMultiRtcInfo$annotations", "multiRtcInfo", "Lcom/bytedance/android/livesdk/link/model/d7;", "getMultiLiveCoreInfo", "()Lcom/bytedance/android/livesdk/link/model/d7;", "getMultiLiveCoreInfo$annotations", "multiLiveCoreInfo", "Lcom/bytedance/android/livesdk/link/model/bridge/b2;", "getPreRtcInfo", "()Lcom/bytedance/android/livesdk/link/model/bridge/b2;", "setPreRtcInfo", "(Lcom/bytedance/android/livesdk/link/model/bridge/b2;)V", "getPreRtcInfo$annotations", "preRtcInfo", "Lcom/bytedance/android/livesdk/link/model/bridge/k2;", "getInviterVersionInfo", "()Lcom/bytedance/android/livesdk/link/model/bridge/k2;", "getInviterVersionInfo$annotations", "inviterVersionInfo", "getVersion", "getVersion$annotations", "version", "getToBizType", "getToBizType$annotations", "toBizType", "getBizType", "getBizType$annotations", "bizType", "getLynxData", "getLynxData$annotations", "lynxData", "getEventTrackingInfo", "getEventTrackingInfo$annotations", "eventTrackingInfo", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface q5 extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.d1>, com.bytedance.android.livesdk.link.model.bridge.d1 {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.d1, vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // com.bytedance.android.livesdk.link.model.bridge.d1, vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "access_key")
    String getAccessKey();

    @FieldName(name = "biz_join_channel")
    boolean getBizJoinChannel();

    @FieldName(name = "biz_type")
    int getBizType();

    @FieldName(name = "cur_invite_num")
    long getCurMaxInviteNum();

    @FieldName(name = "event_tracking_info")
    String getEventTrackingInfo();

    @Override // vh7.e
    /* synthetic */ Object getFlexInstance();

    @FieldName(name = "invite_version_info")
    com.bytedance.android.livesdk.link.model.bridge.k2 getInviterVersionInfo();

    @FieldName(name = "layout_info")
    m getLayoutInfo();

    @FieldName(name = "link_mic_id")
    /* synthetic */ Long getLinkMicId();

    @FieldName(name = "linkmic_id_str")
    /* synthetic */ String getLinkMicIdStr();

    @FieldName(name = "linked_users")
    List<p> getLinkUsers();

    @FieldName(name = "linker_content_map")
    /* synthetic */ Map<Long, com.bytedance.android.livesdk.link.model.bridge.g2> getLinkerContentMap();

    @FieldName(name = "linkmic_lynx_data")
    String getLynxData();

    @FieldName(name = "multi_channel_info")
    /* synthetic */ com.bytedance.android.livesdk.link.model.bridge.s1 getMultiChannelInfo();

    @FieldName(name = "multi_live_core_info")
    d7 getMultiLiveCoreInfo();

    @FieldName(name = "multi_rtc_info")
    com.bytedance.android.livesdk.link.model.bridge.v1 getMultiRtcInfo();

    @FieldName(name = "pre_rtc_info")
    com.bytedance.android.livesdk.link.model.bridge.b2 getPreRtcInfo();

    @FieldName(name = "rtc_ext_info")
    /* synthetic */ String getRtcExtInfo();

    @FieldName(name = "switch_to_scene")
    int getSwitchToScene();

    @FieldName(name = "to_biz_type")
    int getToBizType();

    @FieldName(name = "version")
    long getVersion();

    @FieldName(name = "linked_users#setter")
    void setLinkUsers(List<? extends p> r100);

    @FieldName(name = "pre_rtc_info#setter")
    void setPreRtcInfo(com.bytedance.android.livesdk.link.model.bridge.b2 r100);
}
