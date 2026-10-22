package com.stepos.ailauncher.foundation.appui.card.provider.appauther;

import com.stepos.ailauncher.foundation.credential.CredentialBrokerClient;
import com.stepos.ailauncher.foundation.credential.api.CredentialStatusDto;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.C4109a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.foundation.appui.card.provider.appauther.AppAutherBaseCardView$verifyA2aStatus$1", f = "AppAutherBaseCardView.kt", l = {475}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class AppAutherBaseCardView$verifyA2aStatus$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ AppAutherCardModel $model;
    final /* synthetic */ String $path;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppAutherBaseCardView$verifyA2aStatus$1(String str, AppAutherCardModel appAutherCardModel, InterfaceC4014c<? super AppAutherBaseCardView$verifyA2aStatus$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$path = str;
        this.$model = appAutherCardModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new AppAutherBaseCardView$verifyA2aStatus$1(this.$path, this.$model, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((AppAutherBaseCardView$verifyA2aStatus$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            CredentialBrokerClient credentialBrokerClient = CredentialBrokerClient.INSTANCE;
            String str = this.$path;
            this.label = 1;
            obj = credentialBrokerClient.o(str, this);
            if (obj == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        CredentialBrokerClient.a aVar = (CredentialBrokerClient.a) obj;
        if (aVar instanceof CredentialBrokerClient.a.Ok) {
            R5.b bVar = R5.b.INSTANCE;
            Pair pairA = Y8.j.a("taskId", this.$model.getCardId());
            String status = ((CredentialStatusDto) ((CredentialBrokerClient.a.Ok) aVar).a()).getStatus();
            if (status == null) {
                status = "null";
            }
            bVar.c("auther.a2a.status.verify", pairA, Y8.j.a("status", status));
        } else {
            if (!(aVar instanceof CredentialBrokerClient.a.Fail)) {
                throw new NoWhenBranchMatchedException();
            }
            R5.b.INSTANCE.h("auther.a2a.status.verify.fail", Y8.j.a("taskId", this.$model.getCardId()), Y8.j.a("code", C4109a.f(((CredentialBrokerClient.a.Fail) aVar).getCode())));
        }
        return Y8.t.f7040a;
    }
}
