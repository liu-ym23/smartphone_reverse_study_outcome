package com.stepos.agentframework.chatcore.audit;

import Ua.M;
import Y8.t;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "Lcom/stepos/agentframework/chatcore/audit/g;", "<anonymous>", "(LUa/M;)Lcom/stepos/agentframework/chatcore/audit/g;"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.chatcore.audit.ContentAuditClient$auditPromptText$2", f = "ContentAuditClient.kt", l = {66}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class ContentAuditClient$auditPromptText$2 extends SuspendLambda implements p<M, InterfaceC4014c<? super g>, Object> {
    final /* synthetic */ String $messageId;
    final /* synthetic */ String $text;
    final /* synthetic */ String $userId;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContentAuditClient$auditPromptText$2(String str, String str2, String str3, InterfaceC4014c<? super ContentAuditClient$auditPromptText$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$text = str;
        this.$messageId = str2;
        this.$userId = str3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new ContentAuditClient$auditPromptText$2(this.$text, this.$messageId, this.$userId, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super g> interfaceC4014c) {
        return ((ContentAuditClient$auditPromptText$2) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0127 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x012c A[Catch: Exception -> 0x008d, TryCatch #0 {Exception -> 0x008d, blocks: (B:35:0x0128, B:37:0x012c, B:39:0x0153, B:43:0x0190, B:45:0x01ab, B:21:0x0052, B:23:0x0082, B:32:0x00a6, B:31:0x0091), top: B:49:0x0052 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0153 A[Catch: Exception -> 0x008d, TryCatch #0 {Exception -> 0x008d, blocks: (B:35:0x0128, B:37:0x012c, B:39:0x0153, B:43:0x0190, B:45:0x01ab, B:21:0x0052, B:23:0x0082, B:32:0x00a6, B:31:0x0091), top: B:49:0x0052 }] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r22) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 516
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatcore.audit.ContentAuditClient$auditPromptText$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
