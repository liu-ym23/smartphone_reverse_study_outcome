package com.android.ttcjpaysdk.kmp.base.http.interceptor;

import com.android.ttcjpaysdk.kmp.base.alog.CJLogger;
import com.android.ttcjpaysdk.kmp.base.http.CJHeader;
import com.android.ttcjpaysdk.kmp.base.http.CJInterceptor;
import com.android.ttcjpaysdk.kmp.base.http.CJRequest;
import com.android.ttcjpaysdk.kmp.base.http.CJResponse;
import com.android.ttcjpaysdk.kmp.base.http.Contants;
import com.ss.ugc.effectplatform.bridge.network.NetResponse;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0005H\u0002¨\u0006\u000f"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/base/http/interceptor/CJLogInterceptor;", "Lcom/android/ttcjpaysdk/kmp/base/http/CJInterceptor;", "<init>", "()V", "intercept", "Lcom/android/ttcjpaysdk/kmp/base/http/CJResponse;", "chain", "Lcom/android/ttcjpaysdk/kmp/base/http/CJInterceptor$Chain;", "(Lcom/android/ttcjpaysdk/kmp/base/http/CJInterceptor$Chain;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "logRequest", "", "request", "Lcom/android/ttcjpaysdk/kmp/base/http/CJRequest;", "logResponse", "response", "cj_base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CJLogInterceptor implements CJInterceptor {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: com.android.ttcjpaysdk.kmp.base.http.interceptor.CJLogInterceptor$intercept$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.android.ttcjpaysdk.kmp.base.http.interceptor.CJLogInterceptor", f = "CJLogInterceptor.kt", i = {}, l = {20}, m = "intercept", n = {}, s = {})
    public static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ CJLogInterceptor this$0;

        public AnonymousClass1(CJLogInterceptor r100, Continuation<? super AnonymousClass1> r101) {
            this.this$0 = r100;
            super(r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            this.result = r100;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.intercept(null, this);
        }
    }

    public CJLogInterceptor() {
    }

    private final void logRequest(CJRequest r100) {
        CJLogger.INSTANCE.i(Contants.TAG, "request url: " + r100.getUrl() + ", request method: " + r100.getMethod() + ", request queries: " + r100.getQueries() + ", request body: " + r100.getBody());
    }

    private final void logResponse(CJResponse r100) {
        CJLogger r101 = CJLogger.INSTANCE;
        StringBuilder r102 = new StringBuilder("response code: ");
        r102.append(r100.getCode());
        r102.append(", response msg: ");
        r102.append(r100.getMsg());
        r102.append(", response logId: ");
        Iterator<T> r103 = r100.getHeaders().iterator();
    L3:
        String r104 = null;
        if (r103.hasNext() == false) goto L8;
        Object r105 = r103.next();
        if (Intrinsics.areEqual(((CJHeader) r105).getName(), NetResponse.HEADER_KEY_LOG_ID) == false) goto L3;
    L9:
        CJHeader r106 = (CJHeader) r105;
        if (r106 == null) goto L12;
        r104 = r106.getValue();
    L12:
        r102.append(r104);
        r102.append(",  response body: ");
        r102.append(r100.getBody());
        r101.i(Contants.TAG, r102.toString());
        return;
    L8:
        r105 = null;
        goto L9
    }

    @Override // com.android.ttcjpaysdk.kmp.base.http.CJInterceptor
    public Object intercept(CJInterceptor.Chain r100, Continuation<? super CJResponse> r101) {
        if ((r101 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r102 = (AnonymousClass1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        ResultKt.throwOnFailure(r104);
    L17:
        CJResponse r107 = (CJResponse) r104;
        logResponse(r107);
        return r107;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        CJRequest r108 = r100.request();
        logRequest(r108);
        r102.label = 1;
        r104 = r100.proceed(r108, r102);
        if (r104 != r105) goto L17;
        return r105;
    L7:
        r102 = new AnonymousClass1(this, r101);
        goto L8
    }
}
