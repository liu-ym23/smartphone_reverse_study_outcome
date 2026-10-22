package com.bytedance.android.live.profit.format.voicechat.model;

import am3.g;
import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.ss.android.dypay.api.DyPayConstant;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes47.dex */
@ProtoMessage("webcast.ugm.api.webcast_profit_ai_biz.StartVoiceChatResp.ResponseData")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0010\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001d\u0010\u001eR\u001b\u0010\b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\u000b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007R\u001b\u0010\u000e\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\u0005\u001a\u0004\b\r\u0010\u0007R\u001b\u0010\u0013\u001a\u00020\u000f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0005\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0016\u001a\u00020\u000f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0005\u001a\u0004\b\u0015\u0010\u0012R\u001b\u0010\u0019\u001a\u00020\u000f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0005\u001a\u0004\b\u0018\u0010\u0012R\u001b\u0010\u001c\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0005\u001a\u0004\b\u001b\u0010\u0007¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/live/profit/format/voicechat/model/IVoiceChatStartInfoFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/profit/format/voicechat/model/d;", "", "rtcAppId$delegate", "Ljava/lang/Object;", "getRtcAppId", "()Ljava/lang/String;", "rtcAppId", "rtcToken$delegate", "getRtcToken", "rtcToken", "rtcRoomId$delegate", "getRtcRoomId", "rtcRoomId", "", "sessionId$delegate", "getSessionId", "()J", "sessionId", "startTime$delegate", "getStartTime", DyPayConstant.KEY_START_TIME, "countDown$delegate", "getCountDown", "countDown", "rtcBusinessId$delegate", "getRtcBusinessId", "rtcBusinessId", "<init>", "()V", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class IVoiceChatStartInfoFlexImpl extends FlexModelBase<d> implements d, h {

    @SerializedName("count_down")
    protected long _$$countDown;

    @SerializedName("rtc_app_id")
    protected String _$$rtcAppId;

    @SerializedName("rtc_business_id")
    protected String _$$rtcBusinessId;

    @SerializedName("rtc_room_id")
    protected String _$$rtcRoomId;

    @SerializedName("rtc_token")
    protected String _$$rtcToken;

    @SerializedName("session_id")
    protected long _$$sessionId;

    @SerializedName(ILoadStallMonitor.START_TIME)
    protected long _$$startTime;

    public IVoiceChatStartInfoFlexImpl() {
        super(d.class);
        this._$$rtcAppId = "";
        this._$$rtcToken = "";
        this._$$rtcRoomId = "";
        this._$$rtcBusinessId = "";
    }

    @Override // com.bytedance.android.live.profit.format.voicechat.model.d
    public final long getCountDown() {
        return this._$$countDown;
    }

    @Override // com.bytedance.android.live.profit.format.voicechat.model.d
    public final String getRtcAppId() {
        return this._$$rtcAppId;
    }

    @Override // com.bytedance.android.live.profit.format.voicechat.model.d
    public final String getRtcBusinessId() {
        return this._$$rtcBusinessId;
    }

    @Override // com.bytedance.android.live.profit.format.voicechat.model.d
    public final String getRtcRoomId() {
        return this._$$rtcRoomId;
    }

    @Override // com.bytedance.android.live.profit.format.voicechat.model.d
    public final String getRtcToken() {
        return this._$$rtcToken;
    }

    @Override // com.bytedance.android.live.profit.format.voicechat.model.d
    public final long getSessionId() {
        return this._$$sessionId;
    }

    @Override // com.bytedance.android.live.profit.format.voicechat.model.d
    public final long getStartTime() {
        return this._$$startTime;
    }

    public IVoiceChatStartInfoFlexImpl(g r100) {
        super(d.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        g.a r103 = decodeExtensionFields(r102, r100);
        switch(r102) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L12;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L9;
            case 7: goto L8;
            default: goto L7;
        };
    L8:
        this._$$rtcBusinessId = am3.h.c(r100);
        goto L3
    L9:
        this._$$countDown = r100.j();
        goto L3
    L10:
        this._$$startTime = r100.j();
        goto L3
    L11:
        this._$$sessionId = r100.j();
        goto L3
    L12:
        this._$$rtcRoomId = am3.h.c(r100);
        goto L3
    L13:
        this._$$rtcToken = am3.h.c(r100);
        goto L3
    L14:
        this._$$rtcAppId = am3.h.c(r100);
        goto L3
    L7:
        am3.h.d(r103, r100);
        goto L3
    L15:
        r100.d(r101);
        setThreadSafe(true);
        if (this._$$rtcAppId != null) goto L19;
        this._$$rtcAppId = "";
    L19:
        if (this._$$rtcToken != null) goto L22;
        this._$$rtcToken = "";
    L22:
        if (this._$$rtcRoomId != null) goto L25;
        this._$$rtcRoomId = "";
    L25:
        if (this._$$rtcBusinessId != null) goto L46;
        this._$$rtcBusinessId = "";
        return;
    }
}
