package com.android.ttcjpaysdk.kmp.base.http.interceptor;

import com.android.ttcjpaysdk.kmp.base.env.CJEnv;
import com.android.ttcjpaysdk.kmp.base.http.CJInterceptor;
import com.android.ttcjpaysdk.kmp.base.http.CJRequest;
import com.android.ttcjpaysdk.kmp.base.http.CJResponse;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/base/http/interceptor/CJSaasInterceptor;", "Lcom/android/ttcjpaysdk/kmp/base/http/CJInterceptor;", "<init>", "()V", "intercept", "Lcom/android/ttcjpaysdk/kmp/base/http/CJResponse;", "chain", "Lcom/android/ttcjpaysdk/kmp/base/http/CJInterceptor$Chain;", "(Lcom/android/ttcjpaysdk/kmp/base/http/CJInterceptor$Chain;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cj_base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CJSaasInterceptor implements CJInterceptor {
    public static final int $stable = 0;

    public CJSaasInterceptor() {
    }

    @Override // com.android.ttcjpaysdk.kmp.base.http.CJInterceptor
    public Object intercept(CJInterceptor.Chain r110, Continuation<? super CJResponse> r111) {
        CJRequest r100 = r110.request();
        CJEnv r101 = CJEnv.INSTANCE;
        if (r101.isSaasEnv() == false) goto L5;
        String r102 = r101.getCurrentSaasScene();
        String r103 = r101.getAccessToken();
        boolean r104 = false;
        if (StringsKt.contains$default(r100.getUrl(), "/gateway-bytepay/", false, 2, null) == false) goto L9;
    L14:
        r104 = true;
    L15:
        if (r104 == false) goto L17;
        String r105 = StringsKt.replace$default(StringsKt.replace$default(r100.getUrl(), "/gateway-bytepay/", "/gateway-bytepay-saas/", false, 4, null), "/gateway-cashier2/", "/gateway-cashier2-saas/", false, 4, null);
        Map r106 = MapsKt.toMutableMap(r100.getHeaders());
        r106.put("saasscene", r102);
        r106.put("bd-ticket-guard-target", r103);
        r106.put("authorization", "Bearer " + r103);
        return r110.proceed(CJRequest.copy$default(r100, r105, null, r106, null, null, 26, null), r111);
    L17:
        return r110.proceed(r100, r111);
    L9:
        if (StringsKt.contains$default(r100.getUrl(), "/gateway-bytepay-saas/", false, 2, null) == true) goto L14;
        if (StringsKt.contains$default(r100.getUrl(), "/gateway-cashier2/", false, 2, null) == true) goto L14;
        if (StringsKt.contains$default(r100.getUrl(), "/gateway-cashier2-saas/", false, 2, null) == false) goto L15;
    L5:
        return r110.proceed(r100, r111);
    }
}
