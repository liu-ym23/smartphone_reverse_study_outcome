package com.android.ttcjpaysdk.kmp.common.pay_ability.cancel_retain.api;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import ouc.i;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH¦@¢\u0006\u0002\u0010\tJ\u0083\u0001\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2!\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u000b0\u000e2F\u0010\u0012\u001aB\u0012\u0017\u0012\u00150\u0014j\u0002`\u0016¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0015\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00180\u0017¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u000b0\u0013H&¨\u0006\u001a"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/common/pay_ability/cancel_retain/api/CJPayCancelRetainManager;", "", "fetchRetainData", "", "contactInfos", "", "Lcom/android/ttcjpaysdk/kmp/common/pay_ability/cancel_retain/api/CJPayRetainContactInfo;", "enterParams", "Lcom/android/ttcjpaysdk/kmp/common/pay_ability/cancel_retain/api/CJPayRetainBizEnterParams;", "(Ljava/util/List;Lcom/android/ttcjpaysdk/kmp/common/pay_ability/cancel_retain/api/CJPayRetainBizEnterParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "showRetainPage", "", "contactInfo", "showCallBack", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "isShow", "retainEventCallBack", "Lkotlin/Function2;", "", "eventType", "Lcom/android/ttcjpaysdk/kmp/common/pay_ability/cancel_retain/api/CJPayRetainEventType;", "", "Lkotlinx/serialization/json/JsonElement;", "data", "cj_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface CJPayCancelRetainManager {
    Object fetchRetainData(List<CJPayRetainContactInfo> r100, CJPayRetainBizEnterParams r101, Continuation<? super Boolean> r102);

    void showRetainPage(CJPayRetainContactInfo r100, CJPayRetainBizEnterParams r101, Function1<? super Boolean, Unit> r102, Function2<? super String, ? super Map<String, ? extends i>, Unit> r103);
}
