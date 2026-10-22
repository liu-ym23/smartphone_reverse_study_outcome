package com.bytedance.android.livesdk.chatroom.model.interact;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\f\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0007\u001a\u0004\b\t\u0010\u0005R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\r\u0010\u0007\u001a\u0004\b\f\u0010\u0005¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/interact/UpdateLinkTypeApplyResponse;", "Lvh7/c;", "Lcom/bytedance/android/livesdk/chatroom/model/interact/d2;", "", "getAckMessageRaw", "()Ljava/lang/String;", "getAckMessageRaw$annotations", "()V", "ackMessageRaw", "getRtcExtInfoRaw", "getRtcExtInfoRaw$annotations", "rtcExtInfoRaw", "getLiveCoreExtInfoRaw", "getLiveCoreExtInfoRaw$annotations", "liveCoreExtInfoRaw", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface UpdateLinkTypeApplyResponse extends vh7.c<UpdateLinkTypeApplyResponse>, d2 {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "ack_message")
    String getAckMessageRaw();

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.d2
    @FieldName(name = "live_core_ext_info")
    String getLiveCoreExtInfoRaw();

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.d2
    @FieldName(name = "rtc_ext_info")
    String getRtcExtInfoRaw();
}
