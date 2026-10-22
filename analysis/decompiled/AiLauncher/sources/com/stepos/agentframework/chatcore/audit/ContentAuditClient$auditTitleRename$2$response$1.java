package com.stepos.agentframework.chatcore.audit;

import Ua.M;
import Y8.t;
import com.zyql.ai.selector.config.PictureConfig;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;
import yc.v;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LUa/M;", "Lyc/v;", "Lcom/stepos/agentframework/chatcore/audit/f;", "<anonymous>", "(LUa/M;)Lyc/v;"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.chatcore.audit.ContentAuditClient$auditTitleRename$2$response$1", f = "ContentAuditClient.kt", l = {PictureConfig.PREVIEW_VIDEO_CODE}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class ContentAuditClient$auditTitleRename$2$response$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super v<AuditResponse>>, Object> {
    final /* synthetic */ AuditRequest $request;
    final /* synthetic */ h $service;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContentAuditClient$auditTitleRename$2$response$1(h hVar, AuditRequest auditRequest, InterfaceC4014c<? super ContentAuditClient$auditTitleRename$2$response$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$service = hVar;
        this.$request = auditRequest;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new ContentAuditClient$auditTitleRename$2$response$1(this.$service, this.$request, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super v<AuditResponse>> interfaceC4014c) {
        return ((ContentAuditClient$auditTitleRename$2$response$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 != 0) {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            return obj;
        }
        C4849c.b(obj);
        h hVar = this.$service;
        AuditRequest auditRequest = this.$request;
        this.label = 1;
        Object objA = hVar.a(auditRequest, this);
        return objA == objG ? objG : objA;
    }
}
