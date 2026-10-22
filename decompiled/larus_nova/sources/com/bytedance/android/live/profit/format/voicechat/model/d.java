package com.bytedance.android.live.profit.format.voicechat.model;

import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.ss.android.dypay.api.DyPayConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u000e\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001a\u0010\n\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0006\u001a\u0004\b\b\u0010\u0004R\u001a\u0010\r\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0006\u001a\u0004\b\u000b\u0010\u0004R\u001a\u0010\u0012\u001a\u00020\u000e8&X§\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0015\u001a\u00020\u000e8&X§\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0006\u001a\u0004\b\u0013\u0010\u0010R\u001a\u0010\u0018\u001a\u00020\u000e8&X§\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u0006\u001a\u0004\b\u0016\u0010\u0010R\u001a\u0010\u001b\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010\u0006\u001a\u0004\b\u0019\u0010\u0004¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/live/profit/format/voicechat/model/d;", "Lvh7/c;", "", "getRtcAppId", "()Ljava/lang/String;", "getRtcAppId$annotations", "()V", "rtcAppId", "getRtcToken", "getRtcToken$annotations", "rtcToken", "getRtcRoomId", "getRtcRoomId$annotations", "rtcRoomId", "", "getSessionId", "()J", "getSessionId$annotations", "sessionId", "getStartTime", "getStartTime$annotations", DyPayConstant.KEY_START_TIME, "getCountDown", "getCountDown$annotations", "countDown", "getRtcBusinessId", "getRtcBusinessId$annotations", "rtcBusinessId", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface d extends vh7.c<d> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "count_down")
    long getCountDown();

    @FieldName(name = "rtc_app_id")
    String getRtcAppId();

    @FieldName(name = "rtc_business_id")
    String getRtcBusinessId();

    @FieldName(name = "rtc_room_id")
    String getRtcRoomId();

    @FieldName(name = "rtc_token")
    String getRtcToken();

    @FieldName(name = "session_id")
    long getSessionId();

    @FieldName(name = ILoadStallMonitor.START_TIME)
    long getStartTime();
}
