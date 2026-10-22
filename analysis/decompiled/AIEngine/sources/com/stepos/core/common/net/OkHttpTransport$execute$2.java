package com.stepos.core.common.net;

import ad.n;
import ad.t;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.CoroutineScope;
import lb.n;
import okhttp3.Response;
import okhttp3.h;
import qb.b;
import rb.c;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@c(c = "com.stepos.core.common.net.OkHttpTransport$execute$2", f = "OkHttpTransport.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class OkHttpTransport$execute$2 extends SuspendLambda implements p<CoroutineScope, b<? super Result<? extends HttpResponse>>, Object> {
    final /* synthetic */ HttpRequest $request;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ OkHttpTransport this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OkHttpTransport$execute$2(OkHttpTransport okHttpTransport, HttpRequest httpRequest, b<? super OkHttpTransport$execute$2> bVar) {
        super(2, bVar);
        this.this$0 = okHttpTransport;
        this.$request = httpRequest;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final b<n> create(Object obj, b<?> bVar) {
        OkHttpTransport$execute$2 okHttpTransport$execute$2 = new OkHttpTransport$execute$2(this.this$0, this.$request, bVar);
        okHttpTransport$execute$2.L$0 = obj;
        return okHttpTransport$execute$2;
    }

    @Override // zb.p
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, b<? super Result<? extends HttpResponse>> bVar) {
        return invoke2(coroutineScope, (b<? super Result<HttpResponse>>) bVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object objA;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        kotlin.c.b(obj);
        OkHttpTransport okHttpTransport = this.this$0;
        HttpRequest httpRequest = this.$request;
        try {
            n.a aVarB = okHttpTransport.base.b();
            long connectTimeoutMs = httpRequest.getConnectTimeoutMs();
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            aVarB.b(connectTimeoutMs, timeUnit);
            aVarB.c(httpRequest.getReadTimeoutMs(), timeUnit);
            ad.n nVar = new ad.n(aVarB);
            h.a aVar = new h.a();
            aVar.e(httpRequest.getUrl());
            for (Map.Entry<String, String> entry : httpRequest.getHeaders().entrySet()) {
                aVar.b(entry.getKey(), entry.getValue());
            }
            String strName = httpRequest.getMethod().name();
            HttpBody body = httpRequest.getBody();
            aVar.c(strName, body != null ? okHttpTransport.toOkHttp(body) : null);
            Response responseD = nVar.a(new h(aVar)).d();
            try {
                int i10 = responseD.f10891d;
                t tVar = responseD.f10893j;
                String strC = tVar != null ? tVar.C() : null;
                if (strC == null) {
                    strC = "";
                }
                objA = new HttpResponse(i10, strC, okHttpTransport.toMap(responseD.h));
                responseD.close();
            } finally {
            }
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        return new Result(objA);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, b<? super Result<HttpResponse>> bVar) {
        return ((OkHttpTransport$execute$2) create(coroutineScope, bVar)).invokeSuspend(lb.n.f10413a);
    }
}
