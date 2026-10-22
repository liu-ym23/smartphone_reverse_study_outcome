package com.bytedance.android.live.recharge.viewmodel;

import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.recharge.deal.d;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0015\u0010\u0016R!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R'\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\u0005\u001a\u0004\b\f\u0010\u0007R!\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\u0007R'\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00110\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0005\u001a\u0004\b\u0013\u0010\u0007¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/live/recharge/viewmodel/CustomRechargeViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/bytedance/ies/sdk/widgets/NextLiveData;", "", "inputMoney$delegate", "Lkotlin/Lazy;", "getInputMoney", "()Lcom/bytedance/ies/sdk/widgets/NextLiveData;", "inputMoney", "", "Lcom/bytedance/android/live/recharge/deal/d;", "customChargeDeals$delegate", "getCustomChargeDeals", "customChargeDeals", "selectedCustomDeal$delegate", "getSelectedCustomDeal", "selectedCustomDeal", "", "customDealTips$delegate", "getCustomDealTips", "customDealTips", "<init>", "()V", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class CustomRechargeViewModel extends ViewModel {
    private final Lazy customChargeDeals$delegate;
    private final Lazy customDealTips$delegate;
    private final Lazy inputMoney$delegate;
    private final Lazy selectedCustomDeal$delegate;

    public final NextLiveData<List<d>> getCustomChargeDeals() {
        return (NextLiveData) this.customChargeDeals$delegate.getValue();
    }

    public final NextLiveData<List<Long>> getCustomDealTips() {
        return (NextLiveData) this.customDealTips$delegate.getValue();
    }

    public final NextLiveData<Long> getInputMoney() {
        return (NextLiveData) this.inputMoney$delegate.getValue();
    }

    public final NextLiveData<d> getSelectedCustomDeal() {
        return (NextLiveData) this.selectedCustomDeal$delegate.getValue();
    }

    public CustomRechargeViewModel() {
        this.inputMoney$delegate = LazyKt.lazy(CustomRechargeViewModel$inputMoney$2.INSTANCE);
        this.customChargeDeals$delegate = LazyKt.lazy(CustomRechargeViewModel$customChargeDeals$2.INSTANCE);
        this.selectedCustomDeal$delegate = LazyKt.lazy(CustomRechargeViewModel$selectedCustomDeal$2.INSTANCE);
        this.customDealTips$delegate = LazyKt.lazy(CustomRechargeViewModel$customDealTips$2.INSTANCE);
    }
}
