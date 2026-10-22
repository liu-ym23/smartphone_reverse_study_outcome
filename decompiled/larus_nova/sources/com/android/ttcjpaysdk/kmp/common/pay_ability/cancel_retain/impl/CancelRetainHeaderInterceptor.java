package com.android.ttcjpaysdk.kmp.common.pay_ability.cancel_retain.impl;

import com.android.ttcjpaysdk.kmp.base.env.CJEnv;
import com.android.ttcjpaysdk.kmp.base.http.CJInterceptor;
import com.android.ttcjpaysdk.kmp.base.http.CJRequest;
import com.android.ttcjpaysdk.kmp.base.http.CJResponse;
import com.android.ttcjpaysdk.kmp.common.utils.CJDeviceInfoUtils;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/common/pay_ability/cancel_retain/impl/CancelRetainHeaderInterceptor;", "Lcom/android/ttcjpaysdk/kmp/base/http/CJInterceptor;", "<init>", "()V", "intercept", "Lcom/android/ttcjpaysdk/kmp/base/http/CJResponse;", "chain", "Lcom/android/ttcjpaysdk/kmp/base/http/CJInterceptor$Chain;", "(Lcom/android/ttcjpaysdk/kmp/base/http/CJInterceptor$Chain;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cj_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CancelRetainHeaderInterceptor implements CJInterceptor {
    public static final int $stable = 0;

    public CancelRetainHeaderInterceptor() {
    }

    @Override // com.android.ttcjpaysdk.kmp.base.http.CJInterceptor
    public Object intercept(CJInterceptor.Chain r100, Continuation<? super CJResponse> r101) {
        CJRequest r102 = r100.request();
        Map<String, String> r103 = r102.getHeaders();
        CJDeviceInfoUtils r104 = CJDeviceInfoUtils.INSTANCE;
        r103.put("devinfo", r104.getDeviceInfoMapStr());
        r102.getHeaders().put("x-native-devinfo", r104.getFullDeviceInfoMapStr());
        r102.getHeaders().put("X-Cjpay-Sdk-Info", r104.getSDKInfoStr());
        String r105 = CJEnv.INSTANCE.getCustomCookie();
        if (r105.length() <= 0) goto L5;
        boolean r106 = true;
    L6:
        if (r106 == false) goto L9;
        r102.getHeaders().put("Cookie", r105);
    L9:
        return r100.proceed(r102, r101);
    L5:
        r106 = false;
        goto L6
    }
}
