package com.bytedance.android.livesdkapi.model;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0016\u0010\r\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/ILinkmicDynamicLinkServiceConfigSerializableObjectImpl;", "Lcom/bytedance/android/livesdkapi/model/ILinkmicDynamicLinkServiceConfig;", "()V", "emojiPanelDebounceInterval", "", "getEmojiPanelDebounceInterval", "()I", "eventLinkRtcInfoEnable", "", "getEventLinkRtcInfoEnable", "()Z", "eventLiveStreamInfoEnable", "getEventLiveStreamInfoEnable", "linkServiceEnable", "getLinkServiceEnable", "Adapter", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ILinkmicDynamicLinkServiceConfigSerializableObjectImpl implements ILinkmicDynamicLinkServiceConfig {

    @SerializedName("emoji_panel_debounce_interval")
    private final int emojiPanelDebounceInterval;

    @SerializedName("event_link_rtc_info_enable")
    private final boolean eventLinkRtcInfoEnable;

    @SerializedName("event_live_stream_info_enable")
    private final boolean eventLiveStreamInfoEnable;

    @SerializedName("link_service_enable")
    private final boolean linkServiceEnable;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/ILinkmicDynamicLinkServiceConfigSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(ILinkmicDynamicLinkServiceConfigSerializableObjectImpl.class);
        }
    }

    public ILinkmicDynamicLinkServiceConfigSerializableObjectImpl() {
        this.linkServiceEnable = ILinkmicDynamicLinkServiceConfig.DefaultImpls.getLinkServiceEnable(this);
        this.eventLinkRtcInfoEnable = ILinkmicDynamicLinkServiceConfig.DefaultImpls.getEventLinkRtcInfoEnable(this);
        this.eventLiveStreamInfoEnable = ILinkmicDynamicLinkServiceConfig.DefaultImpls.getEventLiveStreamInfoEnable(this);
        this.emojiPanelDebounceInterval = ILinkmicDynamicLinkServiceConfig.DefaultImpls.getEmojiPanelDebounceInterval(this);
    }

    @Override // com.bytedance.android.livesdkapi.model.ILinkmicDynamicLinkServiceConfig
    public final int getEmojiPanelDebounceInterval() {
        return this.emojiPanelDebounceInterval;
    }

    @Override // com.bytedance.android.livesdkapi.model.ILinkmicDynamicLinkServiceConfig
    public final boolean getEventLinkRtcInfoEnable() {
        return this.eventLinkRtcInfoEnable;
    }

    @Override // com.bytedance.android.livesdkapi.model.ILinkmicDynamicLinkServiceConfig
    public final boolean getEventLiveStreamInfoEnable() {
        return this.eventLiveStreamInfoEnable;
    }

    @Override // com.bytedance.android.livesdkapi.model.ILinkmicDynamicLinkServiceConfig
    public final boolean getLinkServiceEnable() {
        return this.linkServiceEnable;
    }
}
