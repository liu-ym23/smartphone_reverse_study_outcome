package com.stepos.ailauncher.foundation.appui.card.provider.appauther;

import com.stepos.ailauncher.foundation.credential.AuthSessionPoller;
import com.stepos.ailauncher.foundation.credential.CredentialBrokerClient;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.foundation.appui.card.provider.appauther.AppAutherBaseCardView$startPolling$job$1", f = "AppAutherBaseCardView.kt", l = {690}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class AppAutherBaseCardView$startPolling$job$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ Long $intervalMs;
    final /* synthetic */ AppAutherCardModel $model;
    final /* synthetic */ String $pollPath;
    int label;
    final /* synthetic */ AppAutherBaseCardView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppAutherBaseCardView$startPolling$job$1(String str, Long l10, AppAutherBaseCardView appAutherBaseCardView, AppAutherCardModel appAutherCardModel, InterfaceC4014c<? super AppAutherBaseCardView$startPolling$job$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$pollPath = str;
        this.$intervalMs = l10;
        this.this$0 = appAutherBaseCardView;
        this.$model = appAutherCardModel;
    }

    public static final boolean h(AppAutherBaseCardView appAutherBaseCardView) {
        return appAutherBaseCardView.isShowingInConversation;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new AppAutherBaseCardView$startPolling$job$1(this.$pollPath, this.$intervalMs, this.this$0, this.$model, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((AppAutherBaseCardView$startPolling$job$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        AppAutherBaseCardView$startPolling$job$1 appAutherBaseCardView$startPolling$job$1;
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            AuthSessionPoller authSessionPoller = AuthSessionPoller.INSTANCE;
            String str = this.$pollPath;
            Long l10 = this.$intervalMs;
            final AppAutherBaseCardView appAutherBaseCardView = this.this$0;
            InterfaceC5063a interfaceC5063a = new InterfaceC5063a() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.appauther.i
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return Boolean.valueOf(AppAutherBaseCardView$startPolling$job$1.h(appAutherBaseCardView));
                }
            };
            this.label = 1;
            appAutherBaseCardView$startPolling$job$1 = this;
            obj = AuthSessionPoller.c(authSessionPoller, str, l10, 0L, interfaceC5063a, null, appAutherBaseCardView$startPolling$job$1, 20, null);
            if (obj == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            appAutherBaseCardView$startPolling$job$1 = this;
        }
        AuthSessionPoller.a aVar = (AuthSessionPoller.a) obj;
        if (kotlin.jvm.internal.p.d(aVar, AuthSessionPoller.a.b.INSTANCE)) {
            appAutherBaseCardView$startPolling$job$1.this$0.B0(appAutherBaseCardView$startPolling$job$1.$model);
        } else if (aVar instanceof AuthSessionPoller.a.Failed) {
            appAutherBaseCardView$startPolling$job$1.this$0.pendingSession = null;
            appAutherBaseCardView$startPolling$job$1.this$0.attemptedAuth = true;
            AuthSessionPoller.a.Failed failed = (AuthSessionPoller.a.Failed) aVar;
            appAutherBaseCardView$startPolling$job$1.this$0.analyticsAuthStatus = kotlin.jvm.internal.p.d(failed.getMessage(), CredentialBrokerClient.ERR_TIMEOUT) ? "expired" : M5.b.AUTH_STATUS_INVALID;
            appAutherBaseCardView$startPolling$job$1.this$0.s0(failed.getMessage());
        } else if (kotlin.jvm.internal.p.d(aVar, AuthSessionPoller.a.d.INSTANCE)) {
            R5.b.INSTANCE.c("auther.poll.timeout", Y8.j.a("taskId", appAutherBaseCardView$startPolling$job$1.$model.getCardId()));
        } else if (!kotlin.jvm.internal.p.d(aVar, AuthSessionPoller.a.C0316a.INSTANCE)) {
            throw new NoWhenBranchMatchedException();
        }
        return Y8.t.f7040a;
    }
}
