package com.stepos.agentframework.chatcore.audit;

import Ua.C1056g;
import Ua.Y;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.audit.g;
import e9.InterfaceC4014c;
import h8.C4148a;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\t\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0086@¢\u0006\u0004\b\t\u0010\nJ\"\u0010\f\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0086@¢\u0006\u0004\b\f\u0010\rJ+\u0010\u0013\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00042\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\u001b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/stepos/agentframework/chatcore/audit/ContentAuditClient;", "", "<init>", "()V", "", "userId", "text", "messageId", "Lcom/stepos/agentframework/chatcore/audit/g;", "f", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "title", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/String;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "", "code", "message", "", "e", Const.INTENT_KEY_UMID, "(ILjava/lang/String;Ljava/lang/Throwable;)Lcom/stepos/agentframework/chatcore/audit/g;", "Lcom/stepos/agentframework/chatcore/audit/f;", "resp", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Lcom/stepos/agentframework/chatcore/audit/f;)Lcom/stepos/agentframework/chatcore/audit/g;", "TAG", "Ljava/lang/String;", "", "AUDIT_TIMEOUT_MS", "J", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ContentAuditClient {
    private static final long AUDIT_TIMEOUT_MS = 20000;
    public static final ContentAuditClient INSTANCE = new ContentAuditClient();
    public static final String TAG = "audit-service";

    public static /* synthetic */ g e(ContentAuditClient contentAuditClient, int i10, String str, Throwable th, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            th = null;
        }
        return contentAuditClient.d(i10, str, th);
    }

    public static final CharSequence i(AuditReason it) {
        p.i(it, "it");
        return "[" + it.getCategory() + "] code=" + it.getCode();
    }

    public final g d(int code, String message, Throwable e10) {
        if (e10 != null) {
            C4148a.g(TAG, "audit error code=" + code + ": " + message, e10, false, 8, null);
        } else {
            C4148a.u(TAG, "audit error code=" + code + ": " + message, false, 4, null);
        }
        return new g.Error(code, message);
    }

    public final Object f(String str, String str2, String str3, InterfaceC4014c<? super g> interfaceC4014c) {
        return C1056g.j(Y.b(), new ContentAuditClient$auditPromptText$2(str2, str3, str, null), interfaceC4014c);
    }

    public final Object g(String str, String str2, InterfaceC4014c<? super g> interfaceC4014c) {
        return C1056g.j(Y.b(), new ContentAuditClient$auditTitleRename$2(str2, str, null), interfaceC4014c);
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00bd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.stepos.agentframework.chatcore.audit.g h(com.stepos.agentframework.chatcore.audit.AuditResponse r17) {
        /*
            Method dump skipped, instructions count: 260
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatcore.audit.ContentAuditClient.h(com.stepos.agentframework.chatcore.audit.f):com.stepos.agentframework.chatcore.audit.g");
    }
}
