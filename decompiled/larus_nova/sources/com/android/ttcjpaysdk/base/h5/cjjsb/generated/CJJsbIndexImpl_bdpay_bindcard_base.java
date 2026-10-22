package com.android.ttcjpaysdk.base.h5.cjjsb.generated;

import com.android.ttcjpaysdk.base.h5.cjjsb.annotation.ICJJsbIndex;
import com.android.ttcjpaysdk.bindcard.base.jsb.JSBBindCard;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0004H\u0016¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/cjjsb/generated/CJJsbIndexImpl_bdpay_bindcard_base;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/annotation/ICJJsbIndex;", "()V", "getJsbMap", "", "", "Ljava/lang/Class;", "bdpay-bindcard-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJJsbIndexImpl_bdpay_bindcard_base implements ICJJsbIndex {
    public CJJsbIndexImpl_bdpay_bindcard_base() {
    }

    @Override // com.android.ttcjpaysdk.base.h5.cjjsb.annotation.ICJJsbIndex
    public Map<String, Class<?>> getJsbMap() {
        return MapsKt.mapOf(TuplesKt.to("ttcjpay.bindCard", JSBBindCard.class));
    }
}
