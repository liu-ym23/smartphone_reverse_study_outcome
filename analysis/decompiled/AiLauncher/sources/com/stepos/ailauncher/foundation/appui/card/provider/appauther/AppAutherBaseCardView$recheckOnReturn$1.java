package com.stepos.ailauncher.foundation.appui.card.provider.appauther;

import com.stepos.ailauncher.foundation.appui.card.provider.appauther.AppAutherBaseCardView;
import com.stepos.ailauncher.foundation.credential.CredentialBrokerClient;
import com.stepos.ailauncher.foundation.credential.api.CredentialStatusDto;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.foundation.appui.card.provider.appauther.AppAutherBaseCardView$recheckOnReturn$1", f = "AppAutherBaseCardView.kt", l = {840}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class AppAutherBaseCardView$recheckOnReturn$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ AppAutherCardModel $model;
    final /* synthetic */ String $vendorId;
    int label;
    final /* synthetic */ AppAutherBaseCardView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppAutherBaseCardView$recheckOnReturn$1(String str, AppAutherCardModel appAutherCardModel, AppAutherBaseCardView appAutherBaseCardView, InterfaceC4014c<? super AppAutherBaseCardView$recheckOnReturn$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$vendorId = str;
        this.$model = appAutherCardModel;
        this.this$0 = appAutherBaseCardView;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new AppAutherBaseCardView$recheckOnReturn$1(this.$vendorId, this.$model, this.this$0, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((AppAutherBaseCardView$recheckOnReturn$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        String pollPath;
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            CredentialBrokerClient credentialBrokerClient = CredentialBrokerClient.INSTANCE;
            String str = this.$vendorId;
            String integrationId = this.$model.getIntegrationId();
            this.label = 1;
            obj = credentialBrokerClient.n(str, integrationId, this);
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
                return Y8.t.f7040a;
            }
            this.this$0.Y0(((CredentialStatusDto) ok.a()).getStatus());
        }
        AppAutherBaseCardView.PendingSession pendingSession = this.this$0.pendingSession;
        if (pendingSession != null && (pollPath = pendingSession.getPollPath()) != null) {
            if (this.this$0.getPhase() != 2) {
                this.this$0.T0(this.$model, pollPath, pendingSession.getIntervalMs());
            }
            return Y8.t.f7040a;
        }
        return Y8.t.f7040a;
    }
}
