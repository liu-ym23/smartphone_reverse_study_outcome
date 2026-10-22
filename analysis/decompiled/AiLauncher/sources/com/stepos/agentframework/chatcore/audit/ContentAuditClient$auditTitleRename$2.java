package com.stepos.agentframework.chatcore.audit;

import Ua.M;
import Y8.t;
import com.zyql.ai.selector.config.PictureConfig;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "Lcom/stepos/agentframework/chatcore/audit/g;", "<anonymous>", "(LUa/M;)Lcom/stepos/agentframework/chatcore/audit/g;"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.chatcore.audit.ContentAuditClient$auditTitleRename$2", f = "ContentAuditClient.kt", l = {PictureConfig.PREVIEW_VIDEO_CODE}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class ContentAuditClient$auditTitleRename$2 extends SuspendLambda implements p<M, InterfaceC4014c<? super g>, Object> {
    final /* synthetic */ String $title;
    final /* synthetic */ String $userId;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContentAuditClient$auditTitleRename$2(String str, String str2, InterfaceC4014c<? super ContentAuditClient$auditTitleRename$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$title = str;
        this.$userId = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new ContentAuditClient$auditTitleRename$2(this.$title, this.$userId, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super g> interfaceC4014c) {
        return ((ContentAuditClient$auditTitleRename$2) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0123 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0129 A[Catch: Exception -> 0x002c, TryCatch #0 {Exception -> 0x002c, blocks: (B:6:0x0024, B:36:0x0125, B:38:0x0129, B:40:0x0153, B:44:0x018d, B:46:0x0194), top: B:50:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0153 A[Catch: Exception -> 0x002c, TryCatch #0 {Exception -> 0x002c, blocks: (B:6:0x0024, B:36:0x0125, B:38:0x0129, B:40:0x0153, B:44:0x018d, B:46:0x0194), top: B:50:0x0024 }] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r23) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 492
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatcore.audit.ContentAuditClient$auditTitleRename$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
