package com.stepos.ailauncher.foundation.appui.card.provider.appauther;

import com.stepos.ailauncher.foundation.appui.card.provider.appauther.AppAutherBaseCardView;
import com.stepos.ailauncher.foundation.credential.CredentialBrokerClient;
import com.stepos.ailauncher.foundation.credential.api.AuthSessionDto;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.C4109a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.foundation.appui.card.provider.appauther.AppAutherBaseCardView$startImmediateSessionRecheck$job$1", f = "AppAutherBaseCardView.kt", l = {786}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class AppAutherBaseCardView$startImmediateSessionRecheck$job$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ AppAutherCardModel $model;
    final /* synthetic */ AppAutherBaseCardView.PendingSession $pending;
    final /* synthetic */ String $pollPath;
    int label;
    final /* synthetic */ AppAutherBaseCardView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppAutherBaseCardView$startImmediateSessionRecheck$job$1(String str, AppAutherBaseCardView appAutherBaseCardView, AppAutherCardModel appAutherCardModel, AppAutherBaseCardView.PendingSession pendingSession, InterfaceC4014c<? super AppAutherBaseCardView$startImmediateSessionRecheck$job$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$pollPath = str;
        this.this$0 = appAutherBaseCardView;
        this.$model = appAutherCardModel;
        this.$pending = pendingSession;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new AppAutherBaseCardView$startImmediateSessionRecheck$job$1(this.$pollPath, this.this$0, this.$model, this.$pending, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((AppAutherBaseCardView$startImmediateSessionRecheck$job$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            CredentialBrokerClient credentialBrokerClient = CredentialBrokerClient.INSTANCE;
            String str = this.$pollPath;
            this.label = 1;
            obj = credentialBrokerClient.l(str, this);
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
            if (!this.this$0.isShowingInConversation) {
                return Y8.t.f7040a;
            }
            AuthSessionDto authSessionDto = (AuthSessionDto) ((CredentialBrokerClient.a.Ok) aVar).a();
            if (authSessionDto.isCompleted()) {
                this.this$0.B0(this.$model);
                return Y8.t.f7040a;
            }
            if (authSessionDto.isFailed()) {
                this.this$0.pendingSession = null;
                this.this$0.attemptedAuth = true;
                this.this$0.analyticsAuthStatus = M5.b.AUTH_STATUS_INVALID;
                this.this$0.s0(CredentialBrokerClient.ERR_AUTH_FAILED);
                return Y8.t.f7040a;
            }
            if (authSessionDto.isExpired()) {
                this.this$0.pendingSession = null;
                this.this$0.attemptedAuth = true;
                this.this$0.analyticsAuthStatus = "expired";
                this.this$0.s0(CredentialBrokerClient.ERR_TIMEOUT);
                return Y8.t.f7040a;
            }
        } else {
            if (!(aVar instanceof CredentialBrokerClient.a.Fail)) {
                throw new NoWhenBranchMatchedException();
            }
            R5.b.INSTANCE.c("auther.poll.recheck.session.fail", Y8.j.a("taskId", this.$model.getCardId()), Y8.j.a("code", C4109a.f(((CredentialBrokerClient.a.Fail) aVar).getCode())));
        }
        if (this.this$0.isShowingInConversation && this.this$0.getPhase() != 2) {
            this.this$0.T0(this.$model, this.$pollPath, this.$pending.getIntervalMs());
        }
        return Y8.t.f7040a;
    }
}
