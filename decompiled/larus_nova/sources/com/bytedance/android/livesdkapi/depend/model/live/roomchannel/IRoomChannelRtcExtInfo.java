package com.bytedance.android.livesdkapi.depend.model.live.roomchannel;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public interface IRoomChannelRtcExtInfo extends c<IRoomChannelRtcExtInfo> {
    public static final String RTC_STRATEGY_NORAML = "normal";
    public static final String RTC_STRATEGY_PUBLIC = "public";

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "link_mic_id_str")
    String getLinkMicIdStr();

    @FieldName(name = "live_core_exr_info")
    String getLiveCoreExrInfo();

    @FieldName(name = "public_stream_id")
    String getPublicStreamId();

    @FieldName(name = "rtc_ext_info")
    String getRtcExtInfo();

    @FieldName(name = "rtc_strategy")
    String getRtcStrategy();
}
