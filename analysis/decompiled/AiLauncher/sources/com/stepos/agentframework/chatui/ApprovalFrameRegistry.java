package com.stepos.agentframework.chatui;

import com.autonavi.aps.amapapi.config.Const;
import h8.C4148a;
import kotlin.AskUserConversation;
import kotlin.Metadata;

@Metadata(d1 = {"\u00009\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\b\u0004*\u0001\u001b\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\u000eB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0015\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\u00188\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/stepos/agentframework/chatui/ApprovalFrameRegistry;", "", "<init>", "()V", "", "messageId", "requestId", "LK6/d;", "conversation", "LY8/t;", "e", "(Ljava/lang/String;Ljava/lang/String;LK6/d;)V", "f", "(Ljava/lang/String;)Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)LK6/d;", "", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;)Z", Const.INTENT_KEY_UMID, "(Ljava/lang/String;)V", "c", "TAG", "Ljava/lang/String;", "", "MAX_ENTRIES", "I", "com/stepos/agentframework/chatui/ApprovalFrameRegistry$entries$1", "entries", "Lcom/stepos/agentframework/chatui/ApprovalFrameRegistry$entries$1;", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ApprovalFrameRegistry {
    private static final int MAX_ENTRIES = 32;
    private static final String TAG = "[ApprovalFrameRegistry]";
    public static final ApprovalFrameRegistry INSTANCE = new ApprovalFrameRegistry();
    private static final ApprovalFrameRegistry$entries$1 entries = new ApprovalFrameRegistry$entries$1();

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\n\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0003R$\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR$\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0015\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u001b\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0016\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001a¨\u0006\u001e"}, d2 = {"Lcom/stepos/agentframework/chatui/ApprovalFrameRegistry$a;", "", "<init>", "()V", "LY8/t;", "e", "", "requestId", "Ljava/lang/String;", "c", "()Ljava/lang/String;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/lang/String;)V", "LK6/d;", "conversation", "LK6/d;", Const.INTENT_KEY_PKGNAME, "()LK6/d;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(LK6/d;)V", "", "askUserFrame", "Z", Const.INTENT_KEY_APIKEY, "()Z", "f", "(Z)V", "resolved", Const.INTENT_KEY_UMID, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a {
        private boolean askUserFrame;
        private AskUserConversation conversation;
        private String requestId;
        private boolean resolved;

        /* renamed from: a, reason: from getter */
        public final boolean getAskUserFrame() {
            return this.askUserFrame;
        }

        /* renamed from: b, reason: from getter */
        public final AskUserConversation getConversation() {
            return this.conversation;
        }

        /* renamed from: c, reason: from getter */
        public final String getRequestId() {
            return this.requestId;
        }

        /* renamed from: d, reason: from getter */
        public final boolean getResolved() {
            return this.resolved;
        }

        public final void e() {
            this.conversation = null;
            this.askUserFrame = false;
            this.resolved = false;
        }

        public final void f(boolean z10) {
            this.askUserFrame = z10;
        }

        public final void g(AskUserConversation askUserConversation) {
            this.conversation = askUserConversation;
        }

        public final void h(String str) {
            this.requestId = str;
        }

        public final void i(boolean z10) {
            this.resolved = z10;
        }
    }

    public final synchronized AskUserConversation a(String messageId) {
        AskUserConversation conversation;
        kotlin.jvm.internal.p.i(messageId, "messageId");
        a aVar = (a) entries.get(messageId);
        conversation = null;
        if (aVar != null) {
            if (aVar.getResolved()) {
                aVar = null;
            }
            if (aVar != null) {
                conversation = aVar.getConversation();
            }
        }
        return conversation;
    }

    public final synchronized boolean b(String messageId) {
        boolean z10;
        kotlin.jvm.internal.p.i(messageId, "messageId");
        a aVar = (a) entries.get(messageId);
        z10 = false;
        if (aVar != null) {
            if (aVar.getAskUserFrame()) {
                z10 = true;
            }
        }
        return z10;
    }

    public final synchronized boolean c(String messageId) {
        boolean z10;
        kotlin.jvm.internal.p.i(messageId, "messageId");
        a aVar = (a) entries.get(messageId);
        z10 = false;
        if (aVar != null) {
            if (aVar.getResolved()) {
                z10 = true;
            }
        }
        return z10;
    }

    public final synchronized void d(String messageId) {
        try {
            kotlin.jvm.internal.p.i(messageId, "messageId");
            if (messageId.length() == 0) {
                return;
            }
            ApprovalFrameRegistry$entries$1 approvalFrameRegistry$entries$1 = entries;
            a aVar = approvalFrameRegistry$entries$1.get(messageId);
            if (aVar == null) {
                aVar = new a();
                approvalFrameRegistry$entries$1.put(messageId, aVar);
            }
            a aVar2 = aVar;
            if (aVar2.getResolved()) {
                return;
            }
            aVar2.i(true);
            aVar2.g(null);
            C4148a.k(TAG, "markResolved messageId=" + messageId, false, 4, null);
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void e(String messageId, String requestId, AskUserConversation conversation) {
        kotlin.jvm.internal.p.i(messageId, "messageId");
        if (messageId.length() == 0) {
            return;
        }
        if ((requestId == null || La.H.x0(requestId)) && conversation == null) {
            return;
        }
        ApprovalFrameRegistry$entries$1 approvalFrameRegistry$entries$1 = entries;
        a aVar = approvalFrameRegistry$entries$1.get(messageId);
        if (aVar == null) {
            aVar = new a();
            approvalFrameRegistry$entries$1.put(messageId, aVar);
        }
        a aVar2 = aVar;
        String requestId2 = aVar2.getRequestId();
        if (requestId != null && !La.H.x0(requestId) && requestId2 != null && !La.H.x0(requestId2) && !kotlin.jvm.internal.p.d(requestId, requestId2)) {
            C4148a.k(TAG, "new approval request on same messageId=" + messageId + ", reset sticky state", false, 4, null);
            aVar2.e();
        }
        if (requestId != null && !La.H.x0(requestId) && !kotlin.jvm.internal.p.d(aVar2.getRequestId(), requestId)) {
            aVar2.h(requestId);
            C4148a.k(TAG, "remember requestId messageId=" + messageId, false, 4, null);
        }
        if (conversation != null) {
            aVar2.g(conversation);
            if (!aVar2.getAskUserFrame()) {
                aVar2.f(true);
                C4148a.k(TAG, "remember askUserFrame messageId=" + messageId, false, 4, null);
            }
        }
    }

    public final synchronized String f(String messageId) {
        a aVar;
        kotlin.jvm.internal.p.i(messageId, "messageId");
        aVar = (a) entries.get(messageId);
        return aVar != null ? aVar.getRequestId() : null;
    }
}
