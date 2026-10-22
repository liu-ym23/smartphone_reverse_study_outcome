package com.stepos.ailauncher.foundation.appui.card.provider.appauther;

import android.content.Context;
import com.stepos.ailauncher.foundation.appui.card.provider.appauther.AppAutherBaseCardView;
import com.stepos.ailauncher.foundation.appui.card.provider.appauther.AppAutherReturnContext;
import com.stepos.ailauncher.foundation.credential.AuthSessionPoller;
import com.stepos.ailauncher.foundation.credential.CredentialBrokerClient;
import com.stepos.ailauncher.foundation.credential.api.AuthSessionDto;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.Map;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.foundation.appui.card.provider.appauther.AppAutherBaseCardView$startAuthSession$1", f = "AppAutherBaseCardView.kt", l = {357}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class AppAutherBaseCardView$startAuthSession$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ String $chatSessionId;
    final /* synthetic */ AppAutherCardModel $model;
    int label;
    final /* synthetic */ AppAutherBaseCardView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppAutherBaseCardView$startAuthSession$1(AppAutherCardModel appAutherCardModel, AppAutherBaseCardView appAutherBaseCardView, String str, InterfaceC4014c<? super AppAutherBaseCardView$startAuthSession$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$model = appAutherCardModel;
        this.this$0 = appAutherBaseCardView;
        this.$chatSessionId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new AppAutherBaseCardView$startAuthSession$1(this.$model, this.this$0, this.$chatSessionId, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((AppAutherBaseCardView$startAuthSession$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objH;
        String authorizationUrl;
        Object objG = C4063a.g();
        int i10 = this.label;
        boolean z10 = true;
        if (i10 == 0) {
            C4849c.b(obj);
            CredentialBrokerClient credentialBrokerClient = CredentialBrokerClient.INSTANCE;
            String startPath = this.$model.getStartPath();
            Map<String, Object> mapR = this.$model.r();
            CredentialBrokerClient.AuthContext authContext = CredentialBrokerClient.AuthContext.CHAT;
            boolean zY = this.$model.y();
            this.label = 1;
            objH = credentialBrokerClient.h(startPath, mapR, authContext, zY, "amoo://app-auther/callback", this);
            if (objH == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            objH = obj;
        }
        CredentialBrokerClient.a aVar = (CredentialBrokerClient.a) objH;
        if (aVar instanceof CredentialBrokerClient.a.Ok) {
            AuthSessionDto authSessionDto = (AuthSessionDto) ((CredentialBrokerClient.a.Ok) aVar).a();
            AppAutherReturnContext.ReturnTarget returnTargetM0 = this.this$0.M0();
            AppAutherReturnContext appAutherReturnContext = AppAutherReturnContext.INSTANCE;
            Context context = this.this$0.getContext();
            kotlin.jvm.internal.p.h(context, "getContext(...)");
            appAutherReturnContext.d(context, this.$model, returnTargetM0, this.this$0.K0(returnTargetM0));
            boolean zG = N5.d.G(this.this$0, authSessionDto.getAppRedirectUrl(), authSessionDto.getAuthorizationUrl(), null, false, false, returnTargetM0 == AppAutherReturnContext.ReturnTarget.WAKE_DIALOG, 28, null);
            String appRedirectUrl = authSessionDto.getAppRedirectUrl();
            if ((appRedirectUrl == null || La.H.x0(appRedirectUrl)) && ((authorizationUrl = authSessionDto.getAuthorizationUrl()) == null || La.H.x0(authorizationUrl))) {
                z10 = false;
            }
            M5.b.INSTANCE.g(this.$model, this.$chatSessionId, zG, zG ? null : !z10 ? M5.b.FAIL_MISSING_TARGET : M5.b.FAIL_OPEN_TARGET);
            if (!zG) {
                Context context2 = this.this$0.getContext();
                kotlin.jvm.internal.p.h(context2, "getContext(...)");
                appAutherReturnContext.b(context2);
                this.this$0.s0(AppAutherBaseCardView.ERR_NO_AUTH_URL);
                return Y8.t.f7040a;
            }
            this.this$0.setPhase(0);
            String strE = AuthSessionPoller.INSTANCE.e(authSessionDto, this.$model.getPollPathTemplate());
            this.this$0.pendingSession = new AppAutherBaseCardView.PendingSession(strE, authSessionDto.getPollIntervalMs());
            if (strE == null) {
                R5.b.INSTANCE.h("auther.poll.skip", Y8.j.a("reason", "no_poll_path"), Y8.j.a("taskId", this.$model.getCardId()));
                return Y8.t.f7040a;
            }
            this.this$0.T0(this.$model, strE, authSessionDto.getPollIntervalMs());
        } else {
            if (!(aVar instanceof CredentialBrokerClient.a.Fail)) {
                throw new NoWhenBranchMatchedException();
            }
            M5.b.INSTANCE.g(this.$model, this.$chatSessionId, false, M5.b.FAIL_CREATE_SESSION);
            this.this$0.s0(((CredentialBrokerClient.a.Fail) aVar).getMessage());
        }
        return Y8.t.f7040a;
    }
}
