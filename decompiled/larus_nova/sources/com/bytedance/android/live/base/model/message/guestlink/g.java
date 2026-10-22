package com.bytedance.android.live.base.model.message.guestlink;

import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\"\u0010\t\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R$\u0010\u0010\u001a\u0004\u0018\u00010\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u000f\u0010\b\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0014\u001a\u0004\u0018\u00010\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0013\u0010\b\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\"\u0010\u0018\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0017\u0010\b\u001a\u0004\b\u0015\u0010\u0004\"\u0004\b\u0016\u0010\u0006R\"\u0010\u001c\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001b\u0010\b\u001a\u0004\b\u0019\u0010\u0004\"\u0004\b\u001a\u0010\u0006R\"\u0010 \u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001f\u0010\b\u001a\u0004\b\u001d\u0010\u0004\"\u0004\b\u001e\u0010\u0006R$\u0010'\u001a\u0004\u0018\u00010!8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b&\u0010\b\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u0006("}, d2 = {"Lcom/bytedance/android/live/base/model/message/guestlink/g;", "Lvh7/c;", "", "getChannelId", "()J", "setChannelId", "(J)V", "getChannelId$annotations", "()V", RemoteMessageConst.Notification.CHANNEL_ID, "", "getRtcExtInfo", "()Ljava/lang/String;", "setRtcExtInfo", "(Ljava/lang/String;)V", "getRtcExtInfo$annotations", "rtcExtInfo", "getLiveCoreInfo", "setLiveCoreInfo", "getLiveCoreInfo$annotations", "liveCoreInfo", "getScore", "setScore", "getScore$annotations", com.bytedance.android.ec.core.event.a.KEY_SCORE, "getCallDuration", "setCallDuration", "getCallDuration$annotations", "callDuration", "getLinkThreshold", "setLinkThreshold", "getLinkThreshold$annotations", "linkThreshold", "Lcom/bytedance/android/livesdkapi/depend/model/live/audio/IVoiceLiveTheme;", "getChannelBackground", "()Lcom/bytedance/android/livesdkapi/depend/model/live/audio/IVoiceLiveTheme;", "setChannelBackground", "(Lcom/bytedance/android/livesdkapi/depend/model/live/audio/IVoiceLiveTheme;)V", "getChannelBackground$annotations", "channelBackground", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
@ForMain
public interface g extends vh7.c<g> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "call_duration")
    long getCallDuration();

    @FieldName(name = "channel_background")
    IVoiceLiveTheme getChannelBackground();

    @FieldName(name = "channel_id")
    long getChannelId();

    @FieldName(name = "link_threshold")
    long getLinkThreshold();

    @FieldName(name = "live_core_info")
    String getLiveCoreInfo();

    @FieldName(name = "rtc_ext_info")
    String getRtcExtInfo();

    @FieldName(name = com.bytedance.android.ec.core.event.a.KEY_SCORE)
    long getScore();

    @FieldName(name = "call_duration#setter")
    void setCallDuration(long r100);

    @FieldName(name = "channel_background#setter")
    void setChannelBackground(IVoiceLiveTheme r100);

    @FieldName(name = "channel_id#setter")
    void setChannelId(long r100);

    @FieldName(name = "link_threshold#setter")
    void setLinkThreshold(long r100);

    @FieldName(name = "live_core_info#setter")
    void setLiveCoreInfo(String r100);

    @FieldName(name = "rtc_ext_info#setter")
    void setRtcExtInfo(String r100);

    @FieldName(name = "score#setter")
    void setScore(long r100);
}
