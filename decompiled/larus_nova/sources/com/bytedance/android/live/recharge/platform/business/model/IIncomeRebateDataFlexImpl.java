package com.bytedance.android.live.recharge.platform.business.model;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes47.dex */
@ProtoMessage("webcast.api.wallet.QueryIncomeResult.CoinRebateStruct")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u000e\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R\u001b\u0010\b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\u000b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007R\u001b\u0010\u000e\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\u0005\u001a\u0004\b\r\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/live/recharge/platform/business/model/IIncomeRebateDataFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/recharge/platform/business/model/a;", "", "rebateLimit$delegate", "Ljava/lang/Object;", "getRebateLimit", "()J", "rebateLimit", "giftAmount$delegate", "getGiftAmount", "giftAmount", "leftAmount$delegate", "getLeftAmount", "leftAmount", "<init>", "()V", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IIncomeRebateDataFlexImpl extends FlexModelBase<a> implements a, h {

    @SerializedName("gift_amount")
    protected long _$$giftAmount;

    @SerializedName("left_amount")
    protected long _$$leftAmount;

    @SerializedName("rebate_limit")
    protected long _$$rebateLimit;

    public IIncomeRebateDataFlexImpl() {
        super(a.class);
    }

    @Override // com.bytedance.android.live.recharge.platform.business.model.a
    public final long getGiftAmount() {
        return this._$$giftAmount;
    }

    @Override // com.bytedance.android.live.recharge.platform.business.model.a
    public final long getLeftAmount() {
        return this._$$leftAmount;
    }

    @Override // com.bytedance.android.live.recharge.platform.business.model.a
    public final long getRebateLimit() {
        return this._$$rebateLimit;
    }

    public IIncomeRebateDataFlexImpl(g r100) {
        super(a.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this._$$rebateLimit = r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this._$$giftAmount = r100.j();
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this._$$leftAmount = r100.j();
        goto L3
    L11:
        am3.h.d(r103, r100);
        goto L3
    L15:
        r100.d(r101);
        setThreadSafe(true);
    }
}
