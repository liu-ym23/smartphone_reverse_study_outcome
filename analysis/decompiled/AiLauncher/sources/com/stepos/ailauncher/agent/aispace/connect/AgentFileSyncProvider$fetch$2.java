package com.stepos.ailauncher.agent.aispace.connect;

import com.stepos.agentframework.chatui.AgentFileSyncBridge;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "Lcom/stepos/agentframework/chatui/AgentFileSyncBridge$a;", "<anonymous>", "(LUa/M;)Lcom/stepos/agentframework/chatui/AgentFileSyncBridge$a;"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.agent.aispace.connect.AgentFileSyncProvider$fetch$2", f = "AgentFileSyncProvider.kt", l = {103, 112, 130}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class AgentFileSyncProvider$fetch$2 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super AgentFileSyncBridge.Result>, Object> {
    final /* synthetic */ String $fileId;
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentFileSyncProvider$fetch$2(String str, InterfaceC4014c<? super AgentFileSyncProvider$fetch$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$fileId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new AgentFileSyncProvider$fetch$2(this.$fileId, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super AgentFileSyncBridge.Result> interfaceC4014c) {
        return ((AgentFileSyncProvider$fetch$2) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0149, code lost:
    
        if (r5.equals("3") == false) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0153, code lost:
    
        if (r5.equals("2") == false) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0176, code lost:
    
        return new com.stepos.agentframework.chatui.AgentFileSyncBridge.Result(com.stepos.agentframework.chatui.AgentFileSyncBridge.Status.FAILED, (java.lang.String) r3.f34820a, null, null, null, null, null, null, null, 508, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x01ee, code lost:
    
        if (Ua.U.a(1500, r28) == r7) goto L83;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0215  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:82:0x01ee -> B:8:0x0029). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r29) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 566
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.aispace.connect.AgentFileSyncProvider$fetch$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
