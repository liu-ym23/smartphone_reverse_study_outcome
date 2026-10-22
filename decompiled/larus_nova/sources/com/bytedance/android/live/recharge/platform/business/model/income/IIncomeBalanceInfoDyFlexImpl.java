package com.bytedance.android.live.recharge.platform.business.model.income;

import am3.g;
import com.bytedance.android.live.recharge.platform.business.model.IIncomeRebateDataFlexImpl;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes47.dex */
@ProtoMessage("webcast.api.wallet.QueryIncomeResult.QueryIncomeBalance")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0013\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001a\u0010\u001bR\u001d\u0010\b\u001a\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\r\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0010\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\fR\u001b\u0010\u0013\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0005\u001a\u0004\b\u0012\u0010\fR\u001b\u0010\u0016\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0005\u001a\u0004\b\u0015\u0010\fR\u001b\u0010\u0019\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0005\u001a\u0004\b\u0018\u0010\f¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/live/recharge/platform/business/model/income/IIncomeBalanceInfoDyFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/recharge/platform/business/model/income/b;", "Lcom/bytedance/android/live/recharge/platform/business/model/IIncomeRebateDataFlexImpl;", "rebateData$delegate", "Ljava/lang/Object;", "getRebateData", "()Lcom/bytedance/android/live/recharge/platform/business/model/IIncomeRebateDataFlexImpl;", "rebateData", "", "maxGoldCount$delegate", "getMaxGoldCount", "()J", "maxGoldCount", "goldBalance$delegate", "getGoldBalance", "goldBalance", "equivalentCashValue$delegate", "getEquivalentCashValue", "equivalentCashValue", "cashBalance$delegate", "getCashBalance", "cashBalance", "maxCash$delegate", "getMaxCash", "maxCash", "<init>", "()V", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IIncomeBalanceInfoDyFlexImpl extends FlexModelBase<b> implements b, h {

    @SerializedName("cash_balance")
    protected long _$$cashBalance;

    @SerializedName("equivalent_cash_value")
    protected long _$$equivalentCashValue;

    @SerializedName("gold_balance")
    protected long _$$goldBalance;

    @SerializedName("max_cash")
    protected long _$$maxCash;

    @SerializedName("max_gold_count")
    protected long _$$maxGoldCount;

    @SerializedName("rebate_data")
    protected IIncomeRebateDataFlexImpl _$$rebateData;

    public IIncomeBalanceInfoDyFlexImpl() {
        super(b.class);
        this._$$maxGoldCount = $defaultValue_maxGoldCount$();
        this._$$goldBalance = $defaultValue_goldBalance$();
        this._$$equivalentCashValue = $defaultValue_equivalentCashValue$();
        this._$$cashBalance = $defaultValue_cashBalance$();
        this._$$maxCash = $defaultValue_maxCash$();
    }

    public final long $defaultValue_cashBalance$() {
        return -1;
    }

    public final long $defaultValue_equivalentCashValue$() {
        return -1;
    }

    public final long $defaultValue_goldBalance$() {
        return -1;
    }

    public final long $defaultValue_maxCash$() {
        return -1;
    }

    public final long $defaultValue_maxGoldCount$() {
        return -1;
    }

    @Override // com.bytedance.android.live.recharge.platform.business.model.income.b
    public /* bridge */ /* synthetic */ com.bytedance.android.live.recharge.platform.business.model.a getRebateData() {
        return getRebateData();
    }

    @Override // com.bytedance.android.live.recharge.platform.business.model.income.b
    public final long getCashBalance() {
        return this._$$cashBalance;
    }

    @Override // com.bytedance.android.live.recharge.platform.business.model.income.b
    public final long getEquivalentCashValue() {
        return this._$$equivalentCashValue;
    }

    @Override // com.bytedance.android.live.recharge.platform.business.model.income.b
    public final long getGoldBalance() {
        return this._$$goldBalance;
    }

    @Override // com.bytedance.android.live.recharge.platform.business.model.income.b
    public final long getMaxCash() {
        return this._$$maxCash;
    }

    @Override // com.bytedance.android.live.recharge.platform.business.model.income.b
    public final long getMaxGoldCount() {
        return this._$$maxGoldCount;
    }

    @Override // com.bytedance.android.live.recharge.platform.business.model.income.b
    public final IIncomeRebateDataFlexImpl getRebateData() {
        return this._$$rebateData;
    }

    public IIncomeBalanceInfoDyFlexImpl(g r100) {
        super(b.class);
        int r101 = 0;
        setThreadSafe(false);
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L24;
        g.a r104 = decodeExtensionFields(r103, r100);
        if (r103 != 1) goto L8;
        this._$$cashBalance = r100.j();
        r101 = r101 | 8;
        goto L3
    L8:
        if (r103 != 2) goto L10;
        this._$$maxCash = r100.j();
        r101 = r101 | 16;
        goto L3
    L10:
        if (r103 != 4) goto L12;
        this._$$rebateData = new IIncomeRebateDataFlexImpl(r100);
        goto L3
    L12:
        if (r103 != 5) goto L14;
        this._$$goldBalance = r100.j();
        r101 = r101 | 2;
        goto L3
    L14:
        if (r103 != 6) goto L16;
        this._$$maxGoldCount = r100.j();
        r101 = r101 | 1;
        goto L3
    L16:
        if (r103 != 7) goto L17;
        this._$$equivalentCashValue = r100.j();
        r101 = r101 | 4;
        goto L3
    L17:
        am3.h.d(r104, r100);
        goto L3
    L24:
        r100.d(r102);
        setThreadSafe(true);
        if ((r101 & 1) != 0) goto L28;
        this._$$maxGoldCount = $defaultValue_maxGoldCount$();
    L28:
        if ((r101 & 2) != 0) goto L31;
        this._$$goldBalance = $defaultValue_goldBalance$();
    L31:
        if ((r101 & 4) != 0) goto L34;
        this._$$equivalentCashValue = $defaultValue_equivalentCashValue$();
    L34:
        if ((r101 & 8) != 0) goto L37;
        this._$$cashBalance = $defaultValue_cashBalance$();
    L37:
        if ((r101 & 16) != 0) goto L61;
        this._$$maxCash = $defaultValue_maxCash$();
        return;
    }
}
