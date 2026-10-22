package com.bytedance.android.livesdk.chatroom.model.interact;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@ProtoMessage("webcast.api.linkmic_audience.UpdateLinkTypeReplyResponse.ResponseData")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\f\u0010\rR\u001d\u0010\b\u001a\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\u000b\u001a\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/interact/UpdateLinkTypeReplyResponseFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/chatroom/model/interact/UpdateLinkTypeReplyResponse;", "", "rtcExtInfoRaw$delegate", "Ljava/lang/Object;", "getRtcExtInfoRaw", "()Ljava/lang/String;", "rtcExtInfoRaw", "liveCoreExtInfoRaw$delegate", "getLiveCoreExtInfoRaw", "liveCoreExtInfoRaw", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class UpdateLinkTypeReplyResponseFlexImpl extends FlexModelBase<UpdateLinkTypeReplyResponse> implements UpdateLinkTypeReplyResponse, vh7.h {

    @SerializedName("live_core_ext_info")
    protected String _$$liveCoreExtInfoRaw;

    @SerializedName("rtc_ext_info")
    protected String _$$rtcExtInfoRaw;

    public UpdateLinkTypeReplyResponseFlexImpl() {
        super(UpdateLinkTypeReplyResponse.class);
    }

    public UpdateLinkTypeReplyResponseFlexImpl(am3.g r100) {
        super(UpdateLinkTypeReplyResponse.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this._$$rtcExtInfoRaw = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this._$$liveCoreExtInfoRaw = am3.h.c(r100);
        goto L3
    L9:
        am3.h.d(r103, r100);
        goto L3
    L12:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.UpdateLinkTypeReplyResponse, com.bytedance.android.livesdk.chatroom.model.interact.d2
    public final String getLiveCoreExtInfoRaw() {
        return this._$$liveCoreExtInfoRaw;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.UpdateLinkTypeReplyResponse, com.bytedance.android.livesdk.chatroom.model.interact.d2
    public final String getRtcExtInfoRaw() {
        return this._$$rtcExtInfoRaw;
    }
}
