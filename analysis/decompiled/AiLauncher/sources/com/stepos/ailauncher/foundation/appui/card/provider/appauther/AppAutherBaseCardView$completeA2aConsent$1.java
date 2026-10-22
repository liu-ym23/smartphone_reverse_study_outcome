package com.stepos.ailauncher.foundation.appui.card.provider.appauther;

import com.stepos.ailauncher.foundation.credential.CredentialBrokerClient;
import com.stepos.ailauncher.foundation.credential.api.CredentialStatusDto;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.Map;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.foundation.appui.card.provider.appauther.AppAutherBaseCardView$completeA2aConsent$1", f = "AppAutherBaseCardView.kt", l = {449}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class AppAutherBaseCardView$completeA2aConsent$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ AppAutherCardModel $model;
    final /* synthetic */ String $path;
    int label;
    final /* synthetic */ AppAutherBaseCardView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppAutherBaseCardView$completeA2aConsent$1(String str, AppAutherCardModel appAutherCardModel, AppAutherBaseCardView appAutherBaseCardView, InterfaceC4014c<? super AppAutherBaseCardView$completeA2aConsent$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$path = str;
        this.$model = appAutherCardModel;
        this.this$0 = appAutherBaseCardView;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new AppAutherBaseCardView$completeA2aConsent$1(this.$path, this.$model, this.this$0, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((AppAutherBaseCardView$completeA2aConsent$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            CredentialBrokerClient credentialBrokerClient = CredentialBrokerClient.INSTANCE;
            String str = this.$path;
            Map<String, Object> mapC = this.$model.c();
            this.label = 1;
            obj = credentialBrokerClient.g(str, mapC, this);
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
            CredentialBrokerClient.a.Ok ok = (CredentialBrokerClient.a.Ok) aVar;
            if (((CredentialStatusDto) ok.a()).isAuthorized()) {
                this.this$0.B0(this.$model);
                this.this$0.Z0(this.$model);
            } else {
                this.this$0.Y0(((CredentialStatusDto) ok.a()).getStatus());
                this.this$0.setPhase(0);
                this.this$0.O0(this.$model);
            }
        } else {
            if (!(aVar instanceof CredentialBrokerClient.a.Fail)) {
                throw new NoWhenBranchMatchedException();
            }
            this.this$0.s0(((CredentialBrokerClient.a.Fail) aVar).getMessage());
            if (this.this$0.isShowingInConversation) {
                this.this$0.O0(this.$model);
            }
        }
        return Y8.t.f7040a;
    }
}
