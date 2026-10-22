package com.bytedance.android.live.profit.vip;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@ProtoMessage("webcast.api.subscribe.SubscribeInfoResponse.UserData")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u000f\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R+\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR+\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\f\u0010\u0006\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\n¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/live/profit/vip/ISubscribeUserDataFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/profit/vip/d;", "", "<set-?>", "expiredTime$delegate", "Ljava/lang/Object;", "getExpiredTime", "()J", "setExpiredTime", "(J)V", "expiredTime", "level$delegate", "getLevel", "setLevel", "level", "<init>", "()V", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ISubscribeUserDataFlexImpl extends FlexModelBase<d> implements d, vh7.h {

    @SerializedName("expired_time")
    protected long _$$expiredTime;

    @SerializedName("level")
    protected long _$$level;

    public ISubscribeUserDataFlexImpl() {
        super(d.class);
    }

    @Override // com.bytedance.android.live.profit.vip.d
    public final long getExpiredTime() {
        return this._$$expiredTime;
    }

    @Override // com.bytedance.android.live.profit.vip.d
    public final long getLevel() {
        return this._$$level;
    }

    public ISubscribeUserDataFlexImpl(am3.g r100) {
        super(d.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this._$$expiredTime = r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this._$$level = r100.j();
        goto L3
    L9:
        am3.h.d(r103, r100);
        goto L3
    L12:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.live.profit.vip.d
    public final void setExpiredTime(long r100) {
        this._$$expiredTime = r100;
    }

    @Override // com.bytedance.android.live.profit.vip.d
    public final void setLevel(long r100) {
        this._$$level = r100;
    }
}
