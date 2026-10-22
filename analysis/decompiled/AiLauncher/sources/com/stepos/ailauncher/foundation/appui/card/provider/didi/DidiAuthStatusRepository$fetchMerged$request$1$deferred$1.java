package com.stepos.ailauncher.foundation.appui.card.provider.didi;

import com.stepos.ailauncher.foundation.appui.card.provider.didi.api.DidiAuthStatusApi;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.api.DidiAuthStatusDto;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/api/DidiAuthStatusDto;", "<anonymous>", "(LUa/M;)Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/api/DidiAuthStatusDto;"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiAuthStatusRepository$fetchMerged$request$1$deferred$1", f = "DidiAuthStatusRepository.kt", l = {355}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class DidiAuthStatusRepository$fetchMerged$request$1$deferred$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super DidiAuthStatusDto>, Object> {
    final /* synthetic */ String $deviceId;
    final /* synthetic */ DidiAuthStatusApi $service;
    final /* synthetic */ String $thirdUid;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DidiAuthStatusRepository$fetchMerged$request$1$deferred$1(DidiAuthStatusApi didiAuthStatusApi, String str, String str2, InterfaceC4014c<? super DidiAuthStatusRepository$fetchMerged$request$1$deferred$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$service = didiAuthStatusApi;
        this.$thirdUid = str;
        this.$deviceId = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new DidiAuthStatusRepository$fetchMerged$request$1$deferred$1(this.$service, this.$thirdUid, this.$deviceId, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super DidiAuthStatusDto> interfaceC4014c) {
        return ((DidiAuthStatusRepository$fetchMerged$request$1$deferred$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
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
        DidiAuthStatusRepository didiAuthStatusRepository = DidiAuthStatusRepository.INSTANCE;
        DidiAuthStatusApi didiAuthStatusApi = this.$service;
        String str = this.$thirdUid;
        String str2 = this.$deviceId;
        this.label = 1;
        Object objP = didiAuthStatusRepository.p(didiAuthStatusApi, str, str2, this);
        return objP == objG ? objG : objP;
    }
}
