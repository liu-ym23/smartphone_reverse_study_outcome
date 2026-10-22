package com.stepos.agentframework.chatcore.session;

import android.content.Context;
import com.stepos.agentframework.chatcore.file.FileInfo;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import t4.InterfaceC5507a;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.chatcore.session.AgentSession$uploadFile$1", f = "AgentSession.kt", l = {1417}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class AgentSession$uploadFile$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ List<FileInfo> $files;
    final /* synthetic */ InterfaceC5507a $listener;
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    final /* synthetic */ AgentSession this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentSession$uploadFile$1(List<FileInfo> list, AgentSession agentSession, Context context, InterfaceC5507a interfaceC5507a, InterfaceC4014c<? super AgentSession$uploadFile$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$files = list;
        this.this$0 = agentSession;
        this.$context = context;
        this.$listener = interfaceC5507a;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new AgentSession$uploadFile$1(this.$files, this.this$0, this.$context, this.$listener, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((AgentSession$uploadFile$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x009d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0098 -> B:14:0x009b). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r15) throws java.lang.Throwable {
        /*
            r14 = this;
            java.lang.Object r0 = f9.C4063a.g()
            int r1 = r14.label
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L37
            if (r1 != r3) goto L2f
            int r1 = r14.I$0
            java.lang.Object r4 = r14.L$6
            com.stepos.agentframework.chatcore.file.FileInfo r4 = (com.stepos.agentframework.chatcore.file.FileInfo) r4
            java.lang.Object r4 = r14.L$4
            java.util.Iterator r4 = (java.util.Iterator) r4
            java.lang.Object r5 = r14.L$3
            t4.a r5 = (t4.InterfaceC5507a) r5
            java.lang.Object r6 = r14.L$2
            android.content.Context r6 = (android.content.Context) r6
            java.lang.Object r7 = r14.L$1
            com.stepos.agentframework.chatcore.session.AgentSession r7 = (com.stepos.agentframework.chatcore.session.AgentSession) r7
            java.lang.Object r8 = r14.L$0
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            kotlin.C4849c.b(r15)
            r11 = r14
            r10 = r5
            r15 = r7
            r12 = r8
            goto L9b
        L2f:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r15)
            throw r14
        L37:
            kotlin.C4849c.b(r15)
            java.util.List<com.stepos.agentframework.chatcore.file.FileInfo> r15 = r14.$files
            java.lang.Iterable r15 = (java.lang.Iterable) r15
            com.stepos.agentframework.chatcore.session.AgentSession r1 = r14.this$0
            android.content.Context r4 = r14.$context
            t4.a r5 = r14.$listener
            java.util.Iterator r6 = r15.iterator()
            r10 = r6
            r6 = r4
            r4 = r10
            r12 = r15
            r15 = r1
            r1 = r2
            r10 = r5
        L4f:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L9d
            java.lang.Object r5 = r4.next()
            r9 = r5
            com.stepos.agentframework.chatcore.file.FileInfo r9 = (com.stepos.agentframework.chatcore.file.FileInfo) r9
            r7 = r5
            com.stepos.agentframework.chatcore.agents.AgentDispatcher r5 = com.stepos.agentframework.chatcore.session.AgentSession.D(r15)
            com.stepos.agentframework.chatcore.session.SessionConfig r8 = r15.getConfig()
            java.lang.String r8 = r8.getAgentId()
            com.stepos.agentframework.chatcore.session.SessionConfig r11 = r15.getConfig()
            java.lang.String r11 = r11.getSecretKey()
            java.lang.Object r13 = g9.h.a(r12)
            r14.L$0 = r13
            r14.L$1 = r15
            r14.L$2 = r6
            r14.L$3 = r10
            r14.L$4 = r4
            java.lang.Object r7 = g9.h.a(r7)
            r14.L$5 = r7
            java.lang.Object r7 = g9.h.a(r9)
            r14.L$6 = r7
            r14.I$0 = r1
            r14.I$1 = r2
            r14.label = r3
            r7 = r8
            r8 = r11
            r11 = r14
            java.lang.Object r14 = r5.q(r6, r7, r8, r9, r10, r11)
            if (r14 != r0) goto L9b
            return r0
        L9b:
            r14 = r11
            goto L4f
        L9d:
            Y8.t r14 = Y8.t.f7040a
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatcore.session.AgentSession$uploadFile$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
