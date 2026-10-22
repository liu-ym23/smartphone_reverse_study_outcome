package com.stepos.ailauncher.agent.aispace.connect;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.agent.aispace.connect.ConnectExternalAgentFragment$launchScan$1", f = "ConnectExternalAgentFragment.kt", l = {59}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class ConnectExternalAgentFragment$launchScan$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ String $token;
    int label;
    final /* synthetic */ ConnectExternalAgentFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConnectExternalAgentFragment$launchScan$1(ConnectExternalAgentFragment connectExternalAgentFragment, String str, InterfaceC4014c<? super ConnectExternalAgentFragment$launchScan$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = connectExternalAgentFragment;
        this.$token = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new ConnectExternalAgentFragment$launchScan$1(this.this$0, this.$token, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((ConnectExternalAgentFragment$launchScan$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x00bc A[PHI: r8
      0x00bc: PHI (r8v11 java.lang.String) = (r8v10 java.lang.String), (r8v13 java.lang.String) binds: [B:54:0x00c4, B:51:0x00ba] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00be  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 238
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.aispace.connect.ConnectExternalAgentFragment$launchScan$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
