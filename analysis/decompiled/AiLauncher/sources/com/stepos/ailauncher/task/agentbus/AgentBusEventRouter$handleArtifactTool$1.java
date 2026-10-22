package com.stepos.ailauncher.task.agentbus;

import Ua.M;
import Y8.t;
import com.stepos.agentframework.chatcore.intent.AgentTool;
import com.stepos.ailauncher.taskstore.artifact.TaskArtifactPartMerger;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.task.agentbus.AgentBusEventRouter$handleArtifactTool$1", f = "AgentBusEventRouter.kt", l = {623, 1732, 674, 691}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class AgentBusEventRouter$handleArtifactTool$1 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super t>, Object> {
    final /* synthetic */ TaskArtifactPartMerger.Parsed $parsed;
    final /* synthetic */ String $sessionId;
    final /* synthetic */ String $taskId;
    final /* synthetic */ AgentTool $tool;
    final /* synthetic */ String $toolName;
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentBusEventRouter$handleArtifactTool$1(String str, String str2, AgentTool agentTool, TaskArtifactPartMerger.Parsed parsed, String str3, InterfaceC4014c<? super AgentBusEventRouter$handleArtifactTool$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$toolName = str;
        this.$taskId = str2;
        this.$tool = agentTool;
        this.$parsed = parsed;
        this.$sessionId = str3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new AgentBusEventRouter$handleArtifactTool$1(this.$toolName, this.$taskId, this.$tool, this.$parsed, this.$sessionId, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((AgentBusEventRouter$handleArtifactTool$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0087, code lost:
    
        if (r2 == r1) goto L60;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:39:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x017e A[Catch: all -> 0x0040, PHI: r2 r3 r13
      0x017e: PHI (r2v20 ??) = (r2v48 ??), (r2v49 ??) binds: [B:45:0x017b, B:13:0x003b] A[DONT_GENERATE, DONT_INLINE]
      0x017e: PHI (r3v8 java.lang.Object) = (r3v7 java.lang.Object), (r3v14 java.lang.Object) binds: [B:45:0x017b, B:13:0x003b] A[DONT_GENERATE, DONT_INLINE]
      0x017e: PHI (r13v6 com.stepos.ailauncher.taskstore.entity.TaskInfoCard) = 
      (r13v5 com.stepos.ailauncher.taskstore.entity.TaskInfoCard)
      (r13v10 com.stepos.ailauncher.taskstore.entity.TaskInfoCard)
     binds: [B:45:0x017b, B:13:0x003b] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #0 {all -> 0x0040, blocks: (B:12:0x0038, B:47:0x017e, B:44:0x015a), top: B:86:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01cb  */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [eb.a] */
    /* JADX WARN: Type inference failed for: r2v20, types: [eb.a] */
    /* JADX WARN: Type inference failed for: r2v48 */
    /* JADX WARN: Type inference failed for: r2v49 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r23) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 590
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.task.agentbus.AgentBusEventRouter$handleArtifactTool$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
