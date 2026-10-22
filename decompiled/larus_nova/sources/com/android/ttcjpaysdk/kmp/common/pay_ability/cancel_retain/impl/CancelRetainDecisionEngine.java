package com.android.ttcjpaysdk.kmp.common.pay_ability.cancel_retain.impl;

import com.android.ttcjpaysdk.kmp.common.pay_ability.cancel_retain.api.CJPayGrowthModel;
import com.android.ttcjpaysdk.kmp.common.pay_ability.cancel_retain.api.CJPayRetainBizEnterParams;
import com.android.ttcjpaysdk.kmp.common.pay_ability.cancel_retain.api.CJPayRetainContactInfo;
import kotlin.Metadata;
import ouc.d0;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/common/pay_ability/cancel_retain/impl/CancelRetainDecisionEngine;", "", "decideRetainInfo", "Lkotlinx/serialization/json/JsonObject;", "growthModel", "Lcom/android/ttcjpaysdk/kmp/common/pay_ability/cancel_retain/api/CJPayGrowthModel;", "contactInfo", "Lcom/android/ttcjpaysdk/kmp/common/pay_ability/cancel_retain/api/CJPayRetainContactInfo;", "enterParams", "Lcom/android/ttcjpaysdk/kmp/common/pay_ability/cancel_retain/api/CJPayRetainBizEnterParams;", "cj_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface CancelRetainDecisionEngine {
    d0 decideRetainInfo(CJPayGrowthModel r100, CJPayRetainContactInfo r101, CJPayRetainBizEnterParams r102);
}
