package com.bytedance.android.livesdk.chatroom.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@ProtoMessage("webcast.api.linkmic_profit.ThemedCompetitionUpdatePerformerResponse.ResponseData")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\n\u0010\u000bR$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/UpdatePerformerResponse;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/chatroom/model/t1;", "", "performStartTime", "Ljava/lang/Long;", "getPerformStartTime", "()Ljava/lang/Long;", "setPerformStartTime", "(Ljava/lang/Long;)V", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class UpdatePerformerResponse extends FlexModelBase<t1> implements t1, vh7.h {

    @SerializedName("perform_start_timestamp_ms")
    protected Long performStartTime;

    public UpdatePerformerResponse() {
        super(t1.class);
        this.performStartTime = 0L;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.t1
    public Long getPerformStartTime() {
        return this.performStartTime;
    }

    public UpdatePerformerResponse(am3.g r100) {
        super(t1.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L9;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L7;
        this.performStartTime = Long.valueOf(r100.j());
        goto L3
    L7:
        am3.h.d(r103, r100);
        goto L3
    L9:
        r100.d(r101);
        setThreadSafe(true);
        if (this.performStartTime != null) goto L19;
        this.performStartTime = 0L;
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.t1
    public void setPerformStartTime(Long r100) {
        this.performStartTime = r100;
    }
}
