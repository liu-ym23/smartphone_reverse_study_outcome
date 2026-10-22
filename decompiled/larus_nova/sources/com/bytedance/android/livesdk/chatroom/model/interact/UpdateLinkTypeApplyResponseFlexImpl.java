package com.bytedance.android.livesdk.chatroom.model.interact;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@ProtoMessage("webcast.api.linkmic_audience.UpdateLinkTypeApplyResponse.ResponseData")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R\u001d\u0010\b\u001a\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\u000b\u001a\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007R\u001d\u0010\u000e\u001a\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\u0005\u001a\u0004\b\r\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/interact/UpdateLinkTypeApplyResponseFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/chatroom/model/interact/UpdateLinkTypeApplyResponse;", "", "ackMessageRaw$delegate", "Ljava/lang/Object;", "getAckMessageRaw", "()Ljava/lang/String;", "ackMessageRaw", "rtcExtInfoRaw$delegate", "getRtcExtInfoRaw", "rtcExtInfoRaw", "liveCoreExtInfoRaw$delegate", "getLiveCoreExtInfoRaw", "liveCoreExtInfoRaw", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class UpdateLinkTypeApplyResponseFlexImpl extends FlexModelBase<UpdateLinkTypeApplyResponse> implements UpdateLinkTypeApplyResponse, vh7.h {

    @SerializedName("ack_message")
    protected String _$$ackMessageRaw;

    @SerializedName("live_core_ext_info")
    protected String _$$liveCoreExtInfoRaw;

    @SerializedName("rtc_ext_info")
    protected String _$$rtcExtInfoRaw;

    public UpdateLinkTypeApplyResponseFlexImpl() {
        super(UpdateLinkTypeApplyResponse.class);
    }

    public UpdateLinkTypeApplyResponseFlexImpl(am3.g r100) {
        super(UpdateLinkTypeApplyResponse.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this._$$rtcExtInfoRaw = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this._$$liveCoreExtInfoRaw = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 4) goto L11;
        this._$$ackMessageRaw = am3.h.c(r100);
        goto L3
    L11:
        am3.h.d(r103, r100);
        goto L3
    L15:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.UpdateLinkTypeApplyResponse
    public final String getAckMessageRaw() {
        return this._$$ackMessageRaw;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.UpdateLinkTypeApplyResponse, com.bytedance.android.livesdk.chatroom.model.interact.d2
    public final String getLiveCoreExtInfoRaw() {
        return this._$$liveCoreExtInfoRaw;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.UpdateLinkTypeApplyResponse, com.bytedance.android.livesdk.chatroom.model.interact.d2
    public final String getRtcExtInfoRaw() {
        return this._$$rtcExtInfoRaw;
    }
}
