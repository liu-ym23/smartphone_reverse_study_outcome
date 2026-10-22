package com.bytedance.android.livesdk.chatroom.model.interact;

import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\f\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\r\u0010\u000eR\"\u0010\u0004\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\n\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/interact/NormalPaidLinkmicSettingContent;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/chatroom/model/interact/d1;", "", "paidCount", "J", "getPaidCount", "()J", "setPaidCount", "(J)V", "limitedTime", "getLimitedTime", "setLimitedTime", "<init>", "()V", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class NormalPaidLinkmicSettingContent extends FlexModelBase<d1> implements d1, vh7.h {

    @SerializedName("limited_time")
    protected long limitedTime;

    @SerializedName("paid_count")
    protected long paidCount;

    public NormalPaidLinkmicSettingContent() {
        super(d1.class);
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.d1
    public long getLimitedTime() {
        return this.limitedTime;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.d1
    public long getPaidCount() {
        return this.paidCount;
    }

    public NormalPaidLinkmicSettingContent(am3.g r100) {
        super(d1.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this.paidCount = r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.limitedTime = r100.j();
        goto L3
    L9:
        am3.h.d(r103, r100);
        goto L3
    L12:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.d1
    public void setLimitedTime(long r100) {
        this.limitedTime = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.d1
    public void setPaidCount(long r100) {
        this.paidCount = r100;
    }
}
