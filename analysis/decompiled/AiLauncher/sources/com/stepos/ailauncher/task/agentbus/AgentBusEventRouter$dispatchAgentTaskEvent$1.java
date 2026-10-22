package com.stepos.ailauncher.task.agentbus;

import Ua.M;
import Y8.t;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import u4.AgentTaskEvent;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.task.agentbus.AgentBusEventRouter$dispatchAgentTaskEvent$1", f = "AgentBusEventRouter.kt", l = {1730, 388, 398, 416}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class AgentBusEventRouter$dispatchAgentTaskEvent$1 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super t>, Object> {
    final /* synthetic */ AgentTaskEvent $event;
    int I$0;
    int I$1;
    int I$2;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentBusEventRouter$dispatchAgentTaskEvent$1(AgentTaskEvent agentTaskEvent, InterfaceC4014c<? super AgentBusEventRouter$dispatchAgentTaskEvent$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$event = agentTaskEvent;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        AgentBusEventRouter$dispatchAgentTaskEvent$1 agentBusEventRouter$dispatchAgentTaskEvent$1 = new AgentBusEventRouter$dispatchAgentTaskEvent$1(this.$event, interfaceC4014c);
        agentBusEventRouter$dispatchAgentTaskEvent$1.L$0 = obj;
        return agentBusEventRouter$dispatchAgentTaskEvent$1;
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((AgentBusEventRouter$dispatchAgentTaskEvent$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:0|2|(1:(1:(1:(1:(4:8|84|85|86)(2:9|10))(14:11|96|12|13|56|57|62|(1:64)|65|(1:67)|68|(1:70)(1:50)|71|(2:73|74)(4:75|(3:77|(1:81)|84)|85|86)))(12:16|98|17|18|34|35|39|(1:41)|44|(1:46)|47|(4:49|50|71|(0)(0))(5:51|91|52|(11:55|56|57|62|(0)|65|(0)|68|(0)(0)|71|(0)(0))|83)))(1:21))(2:22|(2:24|25)(3:26|(1:29)|83))|93|30|(9:33|34|35|39|(0)|44|(0)|47|(0)(0))|83|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0114, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0115, code lost:
    
        r5 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x027d, code lost:
    
        if (r4.S(r5, r21) == r3) goto L83;
     */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0127 A[Catch: all -> 0x0144, TryCatch #2 {all -> 0x0144, blocks: (B:62:0x01c0, B:64:0x01c6, B:65:0x01e2, B:68:0x01e9, B:70:0x01ed, B:39:0x0121, B:41:0x0127, B:44:0x0147, B:47:0x014e, B:49:0x0158, B:51:0x0175, B:38:0x0116), top: B:95:0x0116 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0158 A[Catch: all -> 0x0144, TryCatch #2 {all -> 0x0144, blocks: (B:62:0x01c0, B:64:0x01c6, B:65:0x01e2, B:68:0x01e9, B:70:0x01ed, B:39:0x0121, B:41:0x0127, B:44:0x0147, B:47:0x014e, B:49:0x0158, B:51:0x0175, B:38:0x0116), top: B:95:0x0116 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0172 A[PHI: r12 r13
      0x0172: PHI (r12v11 eb.a) = (r12v5 eb.a), (r12v12 eb.a) binds: [B:49:0x0158, B:69:0x01eb] A[DONT_GENERATE, DONT_INLINE]
      0x0172: PHI (r13v7 java.lang.String) = (r13v4 java.lang.String), (r13v8 java.lang.String) binds: [B:49:0x0158, B:69:0x01eb] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0175 A[Catch: all -> 0x0144, TRY_LEAVE, TryCatch #2 {all -> 0x0144, blocks: (B:62:0x01c0, B:64:0x01c6, B:65:0x01e2, B:68:0x01e9, B:70:0x01ed, B:39:0x0121, B:41:0x0127, B:44:0x0147, B:47:0x014e, B:49:0x0158, B:51:0x0175, B:38:0x0116), top: B:95:0x0116 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01c6 A[Catch: all -> 0x0144, TryCatch #2 {all -> 0x0144, blocks: (B:62:0x01c0, B:64:0x01c6, B:65:0x01e2, B:68:0x01e9, B:70:0x01ed, B:39:0x0121, B:41:0x0127, B:44:0x0147, B:47:0x014e, B:49:0x0158, B:51:0x0175, B:38:0x0116), top: B:95:0x0116 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01ed A[Catch: all -> 0x0144, TRY_LEAVE, TryCatch #2 {all -> 0x0144, blocks: (B:62:0x01c0, B:64:0x01c6, B:65:0x01e2, B:68:0x01e9, B:70:0x01ed, B:39:0x0121, B:41:0x0127, B:44:0x0147, B:47:0x014e, B:49:0x0158, B:51:0x0175, B:38:0x0116), top: B:95:0x0116 }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x022a  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x022d  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r22) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 658
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.task.agentbus.AgentBusEventRouter$dispatchAgentTaskEvent$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
