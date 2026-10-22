package com.bytedance.android.livesdk.link.model;

import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002R\"\u0010\n\u001a\u00020\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\b\u0010\t\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\"\u0010\u0011\u001a\u00020\u000b8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0010\u0010\t\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0018\u001a\u00020\u00128&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0017\u0010\t\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u001f\u001a\u00020\u00198&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001e\u0010\t\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010#\u001a\u00020\u000b8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\"\u0010\t\u001a\u0004\b \u0010\r\"\u0004\b!\u0010\u000fR$\u0010*\u001a\u0004\u0018\u00010$8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b)\u0010\t\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R$\u00101\u001a\u0004\u0018\u00010+8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b0\u0010\t\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R$\u00108\u001a\u0004\u0018\u0001028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b7\u0010\t\u001a\u0004\b3\u00104\"\u0004\b5\u00106R$\u0010?\u001a\u0004\u0018\u0001098&@&X§\u000e¢\u0006\u0012\u0012\u0004\b>\u0010\t\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u001c\u0010B\u001a\u0004\u0018\u00010\u000b8&X§\u0004¢\u0006\f\u0012\u0004\bA\u0010\t\u001a\u0004\b@\u0010\rR\u001c\u0010E\u001a\u0004\u0018\u00010\u000b8&X§\u0004¢\u0006\f\u0012\u0004\bD\u0010\t\u001a\u0004\bC\u0010\r¨\u0006F"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/f;", "Lvh7/e;", "Lcom/bytedance/android/livesdk/link/model/bridge/e;", "", "getVendor", "()I", "setVendor", "(I)V", "getVendor$annotations", "()V", Constants.OperatorKey.KEY_VENDOR, "", "getSignExtra", "()Ljava/lang/String;", "setSignExtra", "(Ljava/lang/String;)V", "getSignExtra$annotations", "signExtra", "", "getWaitSec", "()J", "setWaitSec", "(J)V", "getWaitSec$annotations", "waitSec", "Lcom/bytedance/android/livesdk/link/model/bridge/k2;", "getVersionInfo", "()Lcom/bytedance/android/livesdk/link/model/bridge/k2;", "setVersionInfo", "(Lcom/bytedance/android/livesdk/link/model/bridge/k2;)V", "getVersionInfo$annotations", "versionInfo", "getLinkmicId", "setLinkmicId", "getLinkmicId$annotations", "linkmicId", "Lcom/bytedance/android/livesdk/link/model/bridge/v1;", "getMultiRtcInfo", "()Lcom/bytedance/android/livesdk/link/model/bridge/v1;", "setMultiRtcInfo", "(Lcom/bytedance/android/livesdk/link/model/bridge/v1;)V", "getMultiRtcInfo$annotations", "multiRtcInfo", "Lcom/bytedance/android/livesdk/link/model/d7;", "getMultiLiveCoreInfo", "()Lcom/bytedance/android/livesdk/link/model/d7;", "setMultiLiveCoreInfo", "(Lcom/bytedance/android/livesdk/link/model/d7;)V", "getMultiLiveCoreInfo$annotations", "multiLiveCoreInfo", "Lcom/bytedance/android/livesdk/link/model/b7;", "getMultiChannelInfo", "()Lcom/bytedance/android/livesdk/link/model/b7;", "setMultiChannelInfo", "(Lcom/bytedance/android/livesdk/link/model/b7;)V", "getMultiChannelInfo$annotations", "multiChannelInfo", "Lcom/bytedance/android/livesdk/link/model/bridge/b2;", "getPreRtcInfo", "()Lcom/bytedance/android/livesdk/link/model/bridge/b2;", "setPreRtcInfo", "(Lcom/bytedance/android/livesdk/link/model/bridge/b2;)V", "getPreRtcInfo$annotations", "preRtcInfo", "getLynxData", "getLynxData$annotations", "lynxData", "getEventTrackingInfo", "getEventTrackingInfo$annotations", "eventTrackingInfo", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface f extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.e>, com.bytedance.android.livesdk.link.model.bridge.e {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.e, vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // com.bytedance.android.livesdk.link.model.bridge.e, vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "event_tracking_info")
    String getEventTrackingInfo();

    @Override // vh7.e
    /* synthetic */ Object getFlexInstance();

    @FieldName(name = "linkmic_id_str")
    String getLinkmicId();

    @FieldName(name = "linkmic_lynx_data")
    String getLynxData();

    @FieldName(name = "multi_channel_info")
    b7 getMultiChannelInfo();

    @FieldName(name = "multi_live_core_info")
    d7 getMultiLiveCoreInfo();

    @FieldName(name = "multi_rtc_info")
    com.bytedance.android.livesdk.link.model.bridge.v1 getMultiRtcInfo();

    @FieldName(name = "pre_rtc_info")
    com.bytedance.android.livesdk.link.model.bridge.b2 getPreRtcInfo();

    @FieldName(name = "sign_extra")
    String getSignExtra();

    @FieldName(name = Constants.OperatorKey.KEY_VENDOR)
    int getVendor();

    @FieldName(name = "apply_version_info")
    com.bytedance.android.livesdk.link.model.bridge.k2 getVersionInfo();

    @FieldName(name = "wait_sec")
    long getWaitSec();

    @FieldName(name = "linkmic_id_str#setter")
    void setLinkmicId(String r100);

    @FieldName(name = "multi_channel_info#setter")
    void setMultiChannelInfo(b7 r100);

    @FieldName(name = "multi_live_core_info#setter")
    void setMultiLiveCoreInfo(d7 r100);

    @FieldName(name = "multi_rtc_info#setter")
    void setMultiRtcInfo(com.bytedance.android.livesdk.link.model.bridge.v1 r100);

    @FieldName(name = "pre_rtc_info#setter")
    void setPreRtcInfo(com.bytedance.android.livesdk.link.model.bridge.b2 r100);

    @FieldName(name = "sign_extra#setter")
    void setSignExtra(String r100);

    @FieldName(name = "vendor#setter")
    void setVendor(int r100);

    @FieldName(name = "apply_version_info#setter")
    void setVersionInfo(com.bytedance.android.livesdk.link.model.bridge.k2 r100);

    @FieldName(name = "wait_sec#setter")
    void setWaitSec(long r100);
}
