package com.obric.network.request.intelligentvoice;

import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.intercept.Interceptor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: IntelligentVoiceHeaderInterceptor.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/obric/network/request/intelligentvoice/IntelligentVoiceHeaderInterceptor;", "Lcom/bytedance/retrofit2/intercept/Interceptor;", "()V", "intercept", "Lcom/bytedance/retrofit2/SsResponse;", "chain", "Lcom/bytedance/retrofit2/intercept/Interceptor$Chain;", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class IntelligentVoiceHeaderInterceptor implements Interceptor {
    public IntelligentVoiceHeaderInterceptor() {
    }

    @Override // com.bytedance.retrofit2.intercept.Interceptor
    public SsResponse<?> intercept(Interceptor.Chain r7) {
        Intrinsics.checkNotNullParameter(r7, "chain");
        Request r6 = r7.request();
        List<Header> r0 = r6.getHeaders();
        Intrinsics.checkNotNullExpressionValue(r0, "originalRequest.headers");
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        Object r3 = r2.next();
        if (StringsKt.equals(((Header) r3).getName(), "x-language", true) == true) goto L4;
        r1.add(r3);
        goto L4
    L8:
        List<Header> r4 = CollectionsKt.toMutableList(r1);
        r4.add(new Header("Content-Type", "application/json"));
        r4.add(new Header("x-language", Locale.getDefault().toLanguageTag()));
        SsResponse<?> r8 = r7.proceed(r6.newBuilder().headers(r4).build());
        Intrinsics.checkNotNullExpressionValue(r8, "chain.proceed(newReq)");
        return r8;
    }
}
