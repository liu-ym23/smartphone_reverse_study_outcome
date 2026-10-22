package com.stepos.ailauncher.foundation.appui.card.provider.appauther;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.foundation.appui.card.provider.appauther.AppAutherBaseCardView$startA2aStatusRefresh$job$1", f = "AppAutherBaseCardView.kt", l = {513, 530}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class AppAutherBaseCardView$startA2aStatusRefresh$job$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ AppAutherCardModel $model;
    long J$0;
    int label;
    final /* synthetic */ AppAutherBaseCardView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppAutherBaseCardView$startA2aStatusRefresh$job$1(AppAutherBaseCardView appAutherBaseCardView, AppAutherCardModel appAutherCardModel, InterfaceC4014c<? super AppAutherBaseCardView$startA2aStatusRefresh$job$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = appAutherBaseCardView;
        this.$model = appAutherCardModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new AppAutherBaseCardView$startA2aStatusRefresh$job$1(this.this$0, this.$model, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((AppAutherBaseCardView$startA2aStatusRefresh$job$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0086  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x00bc -> B:11:0x002d). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) throws java.lang.Throwable {
        /*
            r8 = this;
            java.lang.Object r0 = f9.C4063a.g()
            int r1 = r8.label
            r2 = 1
            r3 = 2
            if (r1 == 0) goto L22
            if (r1 == r2) goto L1c
            if (r1 != r3) goto L14
            long r4 = r8.J$0
            kotlin.C4849c.b(r9)
            goto L2d
        L14:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L1c:
            long r4 = r8.J$0
            kotlin.C4849c.b(r9)
            goto L58
        L22:
            kotlin.C4849c.b(r9)
            long r4 = java.lang.System.currentTimeMillis()
            r6 = 900000(0xdbba0, double:4.44659E-318)
            long r4 = r4 + r6
        L2d:
            com.stepos.ailauncher.foundation.appui.card.provider.appauther.AppAutherBaseCardView r9 = r8.this$0
            boolean r9 = com.stepos.ailauncher.foundation.appui.card.provider.appauther.AppAutherBaseCardView.Z(r9)
            if (r9 == 0) goto Lc5
            com.stepos.ailauncher.foundation.appui.card.provider.appauther.AppAutherBaseCardView r9 = r8.this$0
            int r9 = r9.getPhase()
            if (r9 == r3) goto Lc5
            long r6 = java.lang.System.currentTimeMillis()
            int r9 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r9 >= 0) goto Lc5
            com.stepos.ailauncher.foundation.credential.CredentialBrokerClient r9 = com.stepos.ailauncher.foundation.credential.CredentialBrokerClient.INSTANCE
            com.stepos.ailauncher.foundation.appui.card.provider.appauther.k r1 = r8.$model
            java.lang.String r1 = r1.getStatusPath()
            r8.J$0 = r4
            r8.label = r2
            java.lang.Object r9 = r9.o(r1, r8)
            if (r9 != r0) goto L58
            goto Lbe
        L58:
            com.stepos.ailauncher.foundation.credential.CredentialBrokerClient$a r9 = (com.stepos.ailauncher.foundation.credential.CredentialBrokerClient.a) r9
            boolean r1 = r9 instanceof com.stepos.ailauncher.foundation.credential.CredentialBrokerClient.a.Ok
            if (r1 == 0) goto L86
            com.stepos.ailauncher.foundation.credential.CredentialBrokerClient$a$b r9 = (com.stepos.ailauncher.foundation.credential.CredentialBrokerClient.a.Ok) r9
            java.lang.Object r1 = r9.a()
            com.stepos.ailauncher.foundation.credential.api.CredentialStatusDto r1 = (com.stepos.ailauncher.foundation.credential.api.CredentialStatusDto) r1
            boolean r1 = r1.isAuthorized()
            if (r1 == 0) goto L76
            com.stepos.ailauncher.foundation.appui.card.provider.appauther.AppAutherBaseCardView r9 = r8.this$0
            com.stepos.ailauncher.foundation.appui.card.provider.appauther.k r8 = r8.$model
            com.stepos.ailauncher.foundation.appui.card.provider.appauther.AppAutherBaseCardView.a0(r9, r8)
            Y8.t r8 = Y8.t.f7040a
            return r8
        L76:
            com.stepos.ailauncher.foundation.appui.card.provider.appauther.AppAutherBaseCardView r1 = r8.this$0
            java.lang.Object r9 = r9.a()
            com.stepos.ailauncher.foundation.credential.api.CredentialStatusDto r9 = (com.stepos.ailauncher.foundation.credential.api.CredentialStatusDto) r9
            java.lang.String r9 = r9.getStatus()
            com.stepos.ailauncher.foundation.appui.card.provider.appauther.AppAutherBaseCardView.j0(r1, r9)
            goto Lb2
        L86:
            boolean r1 = r9 instanceof com.stepos.ailauncher.foundation.credential.CredentialBrokerClient.a.Fail
            if (r1 == 0) goto Lbf
            R5.b r1 = R5.b.INSTANCE
            com.stepos.ailauncher.foundation.appui.card.provider.appauther.k r6 = r8.$model
            java.lang.String r6 = r6.getCardId()
            java.lang.String r7 = "taskId"
            kotlin.Pair r6 = Y8.j.a(r7, r6)
            com.stepos.ailauncher.foundation.credential.CredentialBrokerClient$a$a r9 = (com.stepos.ailauncher.foundation.credential.CredentialBrokerClient.a.Fail) r9
            int r9 = r9.getCode()
            java.lang.Integer r9 = g9.C4109a.f(r9)
            java.lang.String r7 = "code"
            kotlin.Pair r9 = Y8.j.a(r7, r9)
            kotlin.Pair[] r9 = new kotlin.Pair[]{r6, r9}
            java.lang.String r6 = "auther.a2a.status.refresh.fail"
            r1.c(r6, r9)
        Lb2:
            r8.J$0 = r4
            r8.label = r3
            r6 = 2000(0x7d0, double:9.88E-321)
            java.lang.Object r9 = Ua.U.a(r6, r8)
            if (r9 != r0) goto L2d
        Lbe:
            return r0
        Lbf:
            kotlin.NoWhenBranchMatchedException r8 = new kotlin.NoWhenBranchMatchedException
            r8.<init>()
            throw r8
        Lc5:
            Y8.t r8 = Y8.t.f7040a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.foundation.appui.card.provider.appauther.AppAutherBaseCardView$startA2aStatusRefresh$job$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
