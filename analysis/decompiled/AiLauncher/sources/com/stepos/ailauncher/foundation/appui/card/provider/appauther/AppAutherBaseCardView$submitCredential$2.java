package com.stepos.ailauncher.foundation.appui.card.provider.appauther;

import com.stepos.ailauncher.foundation.credential.CredentialBrokerClient;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.Map;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.foundation.appui.card.provider.appauther.AppAutherBaseCardView$submitCredential$2", f = "AppAutherBaseCardView.kt", l = {651}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class AppAutherBaseCardView$submitCredential$2 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ AppAutherCardModel $model;
    final /* synthetic */ Map<String, String> $secrets;
    final /* synthetic */ String $vendorId;
    int label;
    final /* synthetic */ AppAutherBaseCardView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppAutherBaseCardView$submitCredential$2(String str, AppAutherCardModel appAutherCardModel, Map<String, String> map, AppAutherBaseCardView appAutherBaseCardView, InterfaceC4014c<? super AppAutherBaseCardView$submitCredential$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$vendorId = str;
        this.$model = appAutherCardModel;
        this.$secrets = map;
        this.this$0 = appAutherBaseCardView;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new AppAutherBaseCardView$submitCredential$2(this.$vendorId, this.$model, this.$secrets, this.this$0, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((AppAutherBaseCardView$submitCredential$2) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            CredentialBrokerClient credentialBrokerClient = CredentialBrokerClient.INSTANCE;
            String str = this.$vendorId;
            String integrationId = this.$model.getIntegrationId();
            Map<String, String> map = this.$secrets;
            this.label = 1;
            obj = credentialBrokerClient.q(str, integrationId, map, this);
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
            this.this$0.q0();
            this.this$0.B0(this.$model);
        } else {
            if (!(aVar instanceof CredentialBrokerClient.a.Fail)) {
                throw new NoWhenBranchMatchedException();
            }
            z zVar = z.INSTANCE;
            CredentialBrokerClient.a.Fail fail = (CredentialBrokerClient.a.Fail) aVar;
            if (zVar.i(fail.getCode())) {
                this.this$0.analyticsAuthStatus = M5.b.AUTH_STATUS_INVALID;
                this.this$0.q0();
            }
            this.this$0.s0(zVar.f(fail.getCode(), fail.getMessage()));
        }
        return Y8.t.f7040a;
    }
}
