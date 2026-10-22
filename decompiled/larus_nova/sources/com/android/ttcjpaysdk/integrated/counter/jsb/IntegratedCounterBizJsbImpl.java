package com.android.ttcjpaysdk.integrated.counter.jsb;

import com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.IJSBParams;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.JSBBaseOutput;
import com.android.ttcjpaysdk.base.h5.cjjsb.biz.IIntegratedCounterBizJsb;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J,\u0010\u0005\u001a&\u0012\u0004\u0012\u00020\u0004\u0012\u001c\u0012\u001a\u0012\u0016\b\u0001\u0012\u0012\u0012\u0006\b\u0001\u0012\u00020\t\u0012\u0006\b\u0001\u0012\u00020\n0\b0\u00070\u0006H\u0016¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/counter/jsb/IntegratedCounterBizJsbImpl;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/biz/IIntegratedCounterBizJsb;", "()V", "getBizName", "", "getJsbMap", "", "Ljava/lang/Class;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/AbsJSBMethod;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/IJSBParams;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/JSBBaseOutput;", "integrated-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class IntegratedCounterBizJsbImpl implements IIntegratedCounterBizJsb {
    @Override // com.android.ttcjpaysdk.base.h5.cjjsb.base.biz.IBizJsb
    public String getBizName() {
        return "integrated_counter";
    }

    @Override // com.android.ttcjpaysdk.base.h5.cjjsb.base.biz.IBizJsb
    public Map<String, Class<? extends AbsJSBMethod<? extends IJSBParams, ? extends JSBBaseOutput>>> getJsbMap() {
        return MapsKt.mapOf(TuplesKt.to("ttcjpay.payInfo", JSBPayInfo.class));
    }

    public IntegratedCounterBizJsbImpl() {
    }
}
