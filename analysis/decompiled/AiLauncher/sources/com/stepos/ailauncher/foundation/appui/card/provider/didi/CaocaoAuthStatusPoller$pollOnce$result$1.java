package com.stepos.ailauncher.foundation.appui.card.provider.didi;

import com.stepos.ailauncher.foundation.appui.card.provider.didi.CaocaoAuthStatusPoller;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/b;", "<anonymous>", "(LUa/M;)Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/b;"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.foundation.appui.card.provider.didi.CaocaoAuthStatusPoller$pollOnce$result$1", f = "CaocaoAuthStatusPoller.kt", l = {132}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class CaocaoAuthStatusPoller$pollOnce$result$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super InterfaceC3305b>, Object> {
    final /* synthetic */ CaocaoAuthStatusPoller.a $entry;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CaocaoAuthStatusPoller$pollOnce$result$1(CaocaoAuthStatusPoller.a aVar, InterfaceC4014c<? super CaocaoAuthStatusPoller$pollOnce$result$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$entry = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new CaocaoAuthStatusPoller$pollOnce$result$1(this.$entry, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super InterfaceC3305b> interfaceC4014c) {
        return ((CaocaoAuthStatusPoller$pollOnce$result$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
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
        String strA = this.$entry.getAccountKey();
        String strF = this.$entry.getVendorId();
        String strB = this.$entry.getIntegrationId();
        this.label = 1;
        Object objL = caocaoCredentialStatusRepository.l(strA, strF, strB, this);
        return objL == objG ? objG : objL;
    }
}
