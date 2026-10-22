package com.stepos.agentframework.adapter.agentbus;

import Ua.C1056g;
import Ua.Y;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.adapter.netcore.InquiryAnswerResult;
import e9.InterfaceC4014c;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001c\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0080@¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001c\u0010\u0007\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0006H\u0080@¢\u0006\u0004\b\u0007\u0010\b\u001a\u001c\u0010\n\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\tH\u0080@¢\u0006\u0004\b\n\u0010\u000b\u001a\u001c\u0010\r\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\fH\u0080@¢\u0006\u0004\b\r\u0010\u000e\u001a<\u0010\u0017\u001a\u00020\u0016*\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u0014H\u0080@¢\u0006\u0004\b\u0017\u0010\u0018\"\u0014\u0010\u0019\u001a\u00020\u00148\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/stepos/agentframework/adapter/agentbus/ClawChannelAgentBusBinding;", "LK6/G;", "request", "", "f", "(Lcom/stepos/agentframework/adapter/agentbus/ClawChannelAgentBusBinding;LK6/G;Le9/c;)Ljava/lang/Object;", "LK6/E;", Const.INTENT_KEY_UMID, "(Lcom/stepos/agentframework/adapter/agentbus/ClawChannelAgentBusBinding;LK6/E;Le9/c;)Ljava/lang/Object;", "LK6/F;", "e", "(Lcom/stepos/agentframework/adapter/agentbus/ClawChannelAgentBusBinding;LK6/F;Le9/c;)Ljava/lang/Object;", "LK6/H;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Lcom/stepos/agentframework/adapter/agentbus/ClawChannelAgentBusBinding;LK6/H;Le9/c;)Ljava/lang/Object;", "", "sessionId", "inquiryId", "", "answers", "", "timeoutMs", "Lcom/stepos/agentframework/adapter/netcore/q;", Const.INTENT_KEY_PKGNAME, "(Lcom/stepos/agentframework/adapter/agentbus/ClawChannelAgentBusBinding;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;JLe9/c;)Ljava/lang/Object;", "TASK_REQ_TIMEOUT_MS", "J", "protocol_agentbus_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AgentBusTaskOpsKt {
    private static final long TASK_REQ_TIMEOUT_MS = 10000;

    public static final Object b(ClawChannelAgentBusBinding clawChannelAgentBusBinding, String str, String str2, List<String> list, long j10, InterfaceC4014c<? super InquiryAnswerResult> interfaceC4014c) {
        return C1056g.j(Y.b(), new AgentBusTaskOpsKt$answerInquiry$2(str, str2, list, clawChannelAgentBusBinding, j10, null), interfaceC4014c);
    }

    public static /* synthetic */ Object c(ClawChannelAgentBusBinding clawChannelAgentBusBinding, String str, String str2, List list, long j10, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            j10 = 10000;
        }
        return b(clawChannelAgentBusBinding, str, str2, list, j10, interfaceC4014c);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object d(com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding r9, kotlin.TaskBatchDeleteRequest r10, e9.InterfaceC4014c<? super java.lang.Boolean> r11) throws java.lang.Throwable {
        /*
            boolean r0 = r11 instanceof com.stepos.agentframework.adapter.agentbus.AgentBusTaskOpsKt$batchDeleteTasks$1
            if (r0 == 0) goto L14
            r0 = r11
            com.stepos.agentframework.adapter.agentbus.AgentBusTaskOpsKt$batchDeleteTasks$1 r0 = (com.stepos.agentframework.adapter.agentbus.AgentBusTaskOpsKt$batchDeleteTasks$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.label = r1
        L12:
            r7 = r0
            goto L1a
        L14:
            com.stepos.agentframework.adapter.agentbus.AgentBusTaskOpsKt$batchDeleteTasks$1 r0 = new com.stepos.agentframework.adapter.agentbus.AgentBusTaskOpsKt$batchDeleteTasks$1
            r0.<init>(r11)
            goto L12
        L1a:
            java.lang.Object r11 = r7.result
            java.lang.Object r0 = f9.C4063a.g()
            int r1 = r7.label
            r8 = 1
            if (r1 == 0) goto L3b
            if (r1 != r8) goto L33
            java.lang.Object r9 = r7.L$1
            K6.E r9 = (kotlin.TaskBatchDeleteRequest) r9
            java.lang.Object r9 = r7.L$0
            com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding r9 = (com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding) r9
            kotlin.C4849c.b(r11)
            goto L65
        L33:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L3b:
            kotlin.C4849c.b(r11)
            com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding$TaskApi r1 = r9.B()
            java.util.List r2 = r10.c()
            java.lang.String r3 = r10.getReason()
            java.lang.String r4 = r10.getIdempotencyKey()
            java.lang.Object r9 = g9.h.a(r9)
            r7.L$0 = r9
            java.lang.Object r9 = g9.h.a(r10)
            r7.L$1 = r9
            r7.label = r8
            r5 = 10000(0x2710, double:4.9407E-320)
            java.lang.Object r11 = r1.c(r2, r3, r4, r5, r7)
            if (r11 != r0) goto L65
            return r0
        L65:
            a4.n r11 = (a4.BatchDeleteResult) r11
            a4.t r9 = r11.getError()
            if (r9 != 0) goto L97
            java.util.List r9 = r11.b()
            java.lang.Iterable r9 = (java.lang.Iterable) r9
            boolean r10 = r9 instanceof java.util.Collection
            if (r10 == 0) goto L81
            r10 = r9
            java.util.Collection r10 = (java.util.Collection) r10
            boolean r10 = r10.isEmpty()
            if (r10 == 0) goto L81
            goto L98
        L81:
            java.util.Iterator r9 = r9.iterator()
        L85:
            boolean r10 = r9.hasNext()
            if (r10 == 0) goto L98
            java.lang.Object r10 = r9.next()
            a4.m r10 = (a4.BatchDeleteItem) r10
            boolean r10 = r10.getOk()
            if (r10 != 0) goto L85
        L97:
            r8 = 0
        L98:
            java.lang.Boolean r9 = g9.C4109a.a(r8)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.agentbus.AgentBusTaskOpsKt.d(com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding, K6.E, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object e(com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding r10, kotlin.TaskCancelRequest r11, e9.InterfaceC4014c<? super java.lang.Boolean> r12) throws java.lang.Throwable {
        /*
            boolean r0 = r12 instanceof com.stepos.agentframework.adapter.agentbus.AgentBusTaskOpsKt$cancelTask$1
            if (r0 == 0) goto L14
            r0 = r12
            com.stepos.agentframework.adapter.agentbus.AgentBusTaskOpsKt$cancelTask$1 r0 = (com.stepos.agentframework.adapter.agentbus.AgentBusTaskOpsKt$cancelTask$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.label = r1
        L12:
            r9 = r0
            goto L1a
        L14:
            com.stepos.agentframework.adapter.agentbus.AgentBusTaskOpsKt$cancelTask$1 r0 = new com.stepos.agentframework.adapter.agentbus.AgentBusTaskOpsKt$cancelTask$1
            r0.<init>(r12)
            goto L12
        L1a:
            java.lang.Object r12 = r9.result
            java.lang.Object r0 = f9.C4063a.g()
            int r1 = r9.label
            r2 = 1
            if (r1 == 0) goto L3b
            if (r1 != r2) goto L33
            java.lang.Object r10 = r9.L$1
            K6.F r10 = (kotlin.TaskCancelRequest) r10
            java.lang.Object r10 = r9.L$0
            com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding r10 = (com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding) r10
            kotlin.C4849c.b(r12)
            goto L6e
        L33:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L3b:
            kotlin.C4849c.b(r12)
            com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding$TaskApi r1 = r10.B()
            r12 = r2
            java.lang.String r2 = r11.getTaskId()
            java.lang.String r3 = r11.getReason()
            java.lang.Integer r4 = r11.getExpectedVersion()
            java.lang.String r5 = r11.getIdempotencyKey()
            java.lang.Boolean r6 = r11.getKillSubagents()
            java.lang.Object r10 = g9.h.a(r10)
            r9.L$0 = r10
            java.lang.Object r10 = g9.h.a(r11)
            r9.L$1 = r10
            r9.label = r12
            r7 = 10000(0x2710, double:4.9407E-320)
            java.lang.Object r12 = r1.e(r2, r3, r4, r5, r6, r7, r9)
            if (r12 != r0) goto L6e
            return r0
        L6e:
            a4.p r12 = (a4.CancelResult) r12
            boolean r10 = r12.getOk()
            java.lang.Boolean r10 = g9.C4109a.a(r10)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.agentbus.AgentBusTaskOpsKt.e(com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding, K6.F, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object f(com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding r8, kotlin.TaskDeleteRequest r9, e9.InterfaceC4014c<? super java.lang.Boolean> r10) throws java.lang.Throwable {
        /*
            boolean r0 = r10 instanceof com.stepos.agentframework.adapter.agentbus.AgentBusTaskOpsKt$deleteTask$1
            if (r0 == 0) goto L14
            r0 = r10
            com.stepos.agentframework.adapter.agentbus.AgentBusTaskOpsKt$deleteTask$1 r0 = (com.stepos.agentframework.adapter.agentbus.AgentBusTaskOpsKt$deleteTask$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.label = r1
        L12:
            r7 = r0
            goto L1a
        L14:
            com.stepos.agentframework.adapter.agentbus.AgentBusTaskOpsKt$deleteTask$1 r0 = new com.stepos.agentframework.adapter.agentbus.AgentBusTaskOpsKt$deleteTask$1
            r0.<init>(r10)
            goto L12
        L1a:
            java.lang.Object r10 = r7.result
            java.lang.Object r0 = f9.C4063a.g()
            int r1 = r7.label
            r2 = 1
            if (r1 == 0) goto L3b
            if (r1 != r2) goto L33
            java.lang.Object r8 = r7.L$1
            K6.G r8 = (kotlin.TaskDeleteRequest) r8
            java.lang.Object r8 = r7.L$0
            com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding r8 = (com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding) r8
            kotlin.C4849c.b(r10)
            goto L66
        L33:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3b:
            kotlin.C4849c.b(r10)
            com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding$TaskApi r1 = r8.B()
            r10 = r2
            java.lang.String r2 = r9.getTaskId()
            java.lang.String r3 = r9.getReason()
            java.lang.String r4 = r9.getIdempotencyKey()
            java.lang.Object r8 = g9.h.a(r8)
            r7.L$0 = r8
            java.lang.Object r8 = g9.h.a(r9)
            r7.L$1 = r8
            r7.label = r10
            r5 = 10000(0x2710, double:4.9407E-320)
            java.lang.Object r10 = r1.f(r2, r3, r4, r5, r7)
            if (r10 != r0) goto L66
            return r0
        L66:
            a4.s r10 = (a4.DeleteResult) r10
            boolean r8 = r10.getOk()
            java.lang.Boolean r8 = g9.C4109a.a(r8)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.agentbus.AgentBusTaskOpsKt.f(com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding, K6.G, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x005a A[PHI: r0
      0x005a: PHI (r0v11 java.lang.String) = (r0v5 java.lang.String), (r0v8 java.lang.String), (r0v12 java.lang.String) binds: [B:29:0x006a, B:34:0x0078, B:21:0x0058] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00ed A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object g(com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding r20, kotlin.TaskInteractRequest r21, e9.InterfaceC4014c<? super java.lang.Boolean> r22) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 249
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.agentbus.AgentBusTaskOpsKt.g(com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding, K6.H, e9.c):java.lang.Object");
    }

    public static final CharSequence h(Map.Entry entry) {
        kotlin.jvm.internal.p.i(entry, "<destruct>");
        return ((String) entry.getKey()) + ": " + entry.getValue();
    }
}
