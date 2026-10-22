package com.bytedance.android.livesdk.chatroom.model.interact;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@ProtoMessage("webcast.api.linkmic.LeaveResponse.ResponseData")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\r\u0010\u000eR\"\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0018\u0010\f\u001a\u00060\u0003j\u0002`\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/interact/LinkLeaveResult;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/bridge/n0;", "", "mDiamondCount", "J", "getMDiamondCount", "()J", "setMDiamondCount", "(J)V", "Lcom/bytedance/revenue/platform/api/core/UnsafeLong;", "getDiamondCount", "diamondCount", "<init>", "()V", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LinkLeaveResult extends FlexModelBase<com.bytedance.android.livesdk.link.model.bridge.n0> implements com.bytedance.android.livesdk.link.model.bridge.n0, vh7.h {

    @SerializedName("diamond_count")
    protected long mDiamondCount;

    public LinkLeaveResult() {
        super(com.bytedance.android.livesdk.link.model.bridge.n0.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.n0
    public long getDiamondCount() {
        return this.mDiamondCount;
    }

    public final long getMDiamondCount() {
        return this.mDiamondCount;
    }

    public LinkLeaveResult(am3.g r100) {
        super(com.bytedance.android.livesdk.link.model.bridge.n0.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L9;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L7;
        this.mDiamondCount = r100.j();
        goto L3
    L7:
        am3.h.d(r103, r100);
        goto L3
    L9:
        r100.d(r101);
        setThreadSafe(true);
    }

    public final void setMDiamondCount(long r100) {
        this.mDiamondCount = r100;
    }
}
