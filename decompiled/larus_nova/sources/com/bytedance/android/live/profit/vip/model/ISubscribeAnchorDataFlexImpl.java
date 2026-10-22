package com.bytedance.android.live.profit.vip.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@ProtoMessage("webcast.api.subscribe.SubscribeInfoResponse.AnchorData")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u000b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\f\u0010\rR+\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/profit/vip/model/ISubscribeAnchorDataFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/profit/vip/model/h;", "", "<set-?>", "status$delegate", "Ljava/lang/Object;", "getStatus", "()J", "setStatus", "(J)V", "status", "<init>", "()V", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ISubscribeAnchorDataFlexImpl extends FlexModelBase<h> implements h, vh7.h {

    @SerializedName("status")
    protected long _$$status;

    public ISubscribeAnchorDataFlexImpl() {
        super(h.class);
    }

    @Override // com.bytedance.android.live.profit.vip.model.h
    public final long getStatus() {
        return this._$$status;
    }

    public ISubscribeAnchorDataFlexImpl(am3.g r100) {
        super(h.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L9;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L7;
        this._$$status = r100.j();
        goto L3
    L7:
        am3.h.d(r103, r100);
        goto L3
    L9:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.live.profit.vip.model.h
    public final void setStatus(long r100) {
        this._$$status = r100;
    }
}
