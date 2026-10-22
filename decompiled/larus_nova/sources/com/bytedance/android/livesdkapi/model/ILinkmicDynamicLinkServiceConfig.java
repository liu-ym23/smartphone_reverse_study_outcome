package com.bytedance.android.livesdkapi.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import vh7.j;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(ILinkmicDynamicLinkServiceConfigSerializableObjectImpl.Adapter.class)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0005\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001a\u0010\u0007\u001a\u00020\u00028VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001a\u0010\n\u001a\u00020\u00028VX\u0097\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0006\u001a\u0004\b\b\u0010\u0004R\u001a\u0010\r\u001a\u00020\u00028VX\u0097\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0006\u001a\u0004\b\u000b\u0010\u0004R\u001a\u0010\u0012\u001a\u00020\u000e8VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/ILinkmicDynamicLinkServiceConfig;", "Lvh7/j;", "", "getLinkServiceEnable", "()Z", "getLinkServiceEnable$annotations", "()V", "linkServiceEnable", "getEventLinkRtcInfoEnable", "getEventLinkRtcInfoEnable$annotations", "eventLinkRtcInfoEnable", "getEventLiveStreamInfoEnable", "getEventLiveStreamInfoEnable$annotations", "eventLiveStreamInfoEnable", "", "getEmojiPanelDebounceInterval", "()I", "getEmojiPanelDebounceInterval$annotations", "emojiPanelDebounceInterval", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface ILinkmicDynamicLinkServiceConfig extends j<ILinkmicDynamicLinkServiceConfig> {

    @JsonAdapter(ILinkmicDynamicLinkServiceConfigSerializableObjectImpl.Adapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "emoji_panel_debounce_interval")
        public static int getEmojiPanelDebounceInterval(ILinkmicDynamicLinkServiceConfig r100) {
            return 1000;
        }

        @FieldName(name = "emoji_panel_debounce_interval")
        public static /* synthetic */ void getEmojiPanelDebounceInterval$annotations() {
        }

        @FieldName(name = "event_link_rtc_info_enable")
        public static boolean getEventLinkRtcInfoEnable(ILinkmicDynamicLinkServiceConfig r100) {
            return false;
        }

        @FieldName(name = "event_link_rtc_info_enable")
        public static /* synthetic */ void getEventLinkRtcInfoEnable$annotations() {
        }

        @FieldName(name = "event_live_stream_info_enable")
        public static boolean getEventLiveStreamInfoEnable(ILinkmicDynamicLinkServiceConfig r100) {
            return false;
        }

        @FieldName(name = "event_live_stream_info_enable")
        public static /* synthetic */ void getEventLiveStreamInfoEnable$annotations() {
        }

        @FieldName(name = "link_service_enable")
        public static boolean getLinkServiceEnable(ILinkmicDynamicLinkServiceConfig r100) {
            return true;
        }

        @FieldName(name = "link_service_enable")
        public static /* synthetic */ void getLinkServiceEnable$annotations() {
        }
    }

    @FieldName(name = "emoji_panel_debounce_interval")
    int getEmojiPanelDebounceInterval();

    @FieldName(name = "event_link_rtc_info_enable")
    boolean getEventLinkRtcInfoEnable();

    @FieldName(name = "event_live_stream_info_enable")
    boolean getEventLiveStreamInfoEnable();

    @FieldName(name = "link_service_enable")
    boolean getLinkServiceEnable();
}
