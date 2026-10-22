package com.bytedance.android.live.recharge;

import com.android.ttcjpaysdk.verify.constants.DyVerifyReqConstants;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@ProtoMessage("webcast.api.wallet.InfoResult.InfoData")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u000f\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R+\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR+\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\f\u0010\u0006\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\n¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/live/recharge/IWalletInfoFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/recharge/l;", "", "<set-?>", "diamond$delegate", "Ljava/lang/Object;", "getDiamond", "()J", "setDiamond", "(J)V", DyVerifyReqConstants.Value.DIAMOND, "money$delegate", "getMoney", "setMoney", "money", "<init>", "()V", "liverecharge-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IWalletInfoFlexImpl extends FlexModelBase<l> implements l, vh7.h {

    @SerializedName(DyVerifyReqConstants.Value.DIAMOND)
    protected long _$$diamond;

    @SerializedName("money")
    protected long _$$money;

    public IWalletInfoFlexImpl() {
        super(l.class);
    }

    @Override // com.bytedance.android.live.recharge.l
    public final long getDiamond() {
        return this._$$diamond;
    }

    @Override // com.bytedance.android.live.recharge.l
    public final long getMoney() {
        return this._$$money;
    }

    public IWalletInfoFlexImpl(am3.g r100) {
        super(l.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this._$$money = r100.j();
        goto L3
    L8:
        if (r102 != 3) goto L9;
        this._$$diamond = r100.j();
        goto L3
    L9:
        am3.h.d(r103, r100);
        goto L3
    L12:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.live.recharge.l
    public final void setDiamond(long r100) {
        this._$$diamond = r100;
    }

    @Override // com.bytedance.android.live.recharge.l
    public final void setMoney(long r100) {
        this._$$money = r100;
    }
}
