package com.bytedance.android.livesdk.link.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002R\u001a\u0010\b\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005R\u001a\u0010\r\u001a\u00020\t8&X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0007\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0010\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u0007\u001a\u0004\b\u000e\u0010\u0005R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00118&X§\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0007\u001a\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0019\u001a\u00060\tj\u0002`\u00168&X§\u0004¢\u0006\f\u0012\u0004\b\u0018\u0010\u0007\u001a\u0004\b\u0017\u0010\u000bR\u001a\u0010\u001e\u001a\u00020\u001a8&X§\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\u0007\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010#\u001a\u00020\u001f8&X§\u0004¢\u0006\f\u0012\u0004\b\"\u0010\u0007\u001a\u0004\b \u0010!R\u001a\u0010&\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b%\u0010\u0007\u001a\u0004\b$\u0010\u0005R\u001a\u0010)\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b(\u0010\u0007\u001a\u0004\b'\u0010\u0005R\u001c\u0010,\u001a\u0004\u0018\u00010\u00038&X§\u0004¢\u0006\f\u0012\u0004\b+\u0010\u0007\u001a\u0004\b*\u0010\u0005R\u001c\u0010/\u001a\u0004\u0018\u00010\u00038&X§\u0004¢\u0006\f\u0012\u0004\b.\u0010\u0007\u001a\u0004\b-\u0010\u0005¨\u00060"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/v;", "Lvh7/e;", "Lcom/bytedance/android/livesdk/link/model/bridge/m;", "", "getLinkMicIdStr", "()Ljava/lang/String;", "getLinkMicIdStr$annotations", "()V", "linkMicIdStr", "", "getLinkMicId", "()J", "getLinkMicId$annotations", "linkMicId", "getRtcExtInfo", "getRtcExtInfo$annotations", "rtcExtInfo", "Lcom/bytedance/android/livesdk/link/model/b7;", "getMultiChannelInfo", "()Lcom/bytedance/android/livesdk/link/model/b7;", "getMultiChannelInfo$annotations", "multiChannelInfo", "Lcom/bytedance/android/livesdkapi/depend/model/live/typedef/ChannelId;", "getChannelId", "getChannelId$annotations", RemoteMessageConst.Notification.CHANNEL_ID, "Lcom/bytedance/android/livesdk/link/model/m;", "getLayoutInfo", "()Lcom/bytedance/android/livesdk/link/model/m;", "getLayoutInfo$annotations", "layoutInfo", "Lcom/bytedance/android/livesdk/link/model/bridge/k2;", "getApplyVersionInfo", "()Lcom/bytedance/android/livesdk/link/model/bridge/k2;", "getApplyVersionInfo$annotations", "applyVersionInfo", "getFromUid", "getFromUid$annotations", "fromUid", "getToUid", "getToUid$annotations", "toUid", "getLynxData", "getLynxData$annotations", "lynxData", "getEventTrackingInfo", "getEventTrackingInfo$annotations", "eventTrackingInfo", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface v extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.m>, com.bytedance.android.livesdk.link.model.bridge.m {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.m, vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // com.bytedance.android.livesdk.link.model.bridge.m, vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "apply_version_info")
    com.bytedance.android.livesdk.link.model.bridge.k2 getApplyVersionInfo();

    @FieldName(name = "channel_id")
    long getChannelId();

    @FieldName(name = "event_tracking_info")
    String getEventTrackingInfo();

    @Override // vh7.e
    /* synthetic */ Object getFlexInstance();

    @FieldName(name = "from_open_id")
    String getFromUid();

    @FieldName(name = "layout_info")
    m getLayoutInfo();

    @FieldName(name = "link_mic_id")
    long getLinkMicId();

    @FieldName(name = "linkmic_id_str")
    String getLinkMicIdStr();

    @FieldName(name = "linkmic_lynx_data")
    String getLynxData();

    @FieldName(name = "multi_channel_info")
    b7 getMultiChannelInfo();

    @FieldName(name = "rtc_ext_info")
    String getRtcExtInfo();

    @FieldName(name = "to_open_id")
    String getToUid();
}
