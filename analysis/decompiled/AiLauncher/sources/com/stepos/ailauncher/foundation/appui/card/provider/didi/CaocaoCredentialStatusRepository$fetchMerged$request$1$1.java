package com.stepos.ailauncher.foundation.appui.card.provider.didi;

import com.stepos.ailauncher.foundation.appui.card.provider.didi.api.CaocaoCredentialStatusApi;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.api.CaocaoCredentialStatusData;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/api/CaocaoCredentialStatusData;", "<anonymous>", "(LUa/M;)Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/api/CaocaoCredentialStatusData;"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.foundation.appui.card.provider.didi.CaocaoCredentialStatusRepository$fetchMerged$request$1$1", f = "CaocaoCredentialStatusRepository.kt", l = {114}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class CaocaoCredentialStatusRepository$fetchMerged$request$1$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super CaocaoCredentialStatusData>, Object> {
    final /* synthetic */ String $integrationId;
    final /* synthetic */ CaocaoCredentialStatusApi $service;
    final /* synthetic */ String $vendorId;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CaocaoCredentialStatusRepository$fetchMerged$request$1$1(CaocaoCredentialStatusApi caocaoCredentialStatusApi, String str, String str2, InterfaceC4014c<? super CaocaoCredentialStatusRepository$fetchMerged$request$1$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$service = caocaoCredentialStatusApi;
        this.$vendorId = str;
        this.$integrationId = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new CaocaoCredentialStatusRepository$fetchMerged$request$1$1(this.$service, this.$vendorId, this.$integrationId, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super CaocaoCredentialStatusData> interfaceC4014c) {
        return ((CaocaoCredentialStatusRepository$fetchMerged$request$1$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 != 0) {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            return obj;
        }
        C4849c.b(obj);
        CaocaoCredentialStatusRepository caocaoCredentialStatusRepository = CaocaoCredentialStatusRepository.INSTANCE;
        CaocaoCredentialStatusApi caocaoCredentialStatusApi = this.$service;
        String str = this.$vendorId;
        String str2 = this.$integrationId;
        this.label = 1;
        Object objF = caocaoCredentialStatusRepository.f(caocaoCredentialStatusApi, str, str2, this);
        return objF == objG ? objG : objF;
    }
}
