package com.stepos.ailauncher.chat.view;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u000bR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0013\u001a\u0004\b\u0015\u0010\u000bR\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0016\u0010\u000bR\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0017\u0010\u000bR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0013\u001a\u0004\b\u0018\u0010\u000b¨\u0006\u0019"}, d2 = {"Lcom/stepos/ailauncher/chat/view/g9;", "", "", "sessionId", "requestId", "messageId", "title", "body", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_UMID, "c", Const.INTENT_KEY_PKGNAME, "e", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.chat.view.g9, reason: case insensitive filesystem and from toString */
/* loaded from: classes3.dex */
public final /* data */ class ToolApprovalRequest {
    private final String body;
    private final String messageId;
    private final String requestId;
    private final String sessionId;
    private final String title;

    public ToolApprovalRequest(String sessionId, String requestId, String messageId, String title, String str) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        kotlin.jvm.internal.p.i(requestId, "requestId");
        kotlin.jvm.internal.p.i(messageId, "messageId");
        kotlin.jvm.internal.p.i(title, "title");
        this.sessionId = sessionId;
        this.requestId = requestId;
        this.messageId = messageId;
        this.title = title;
        this.body = str;
    }

    /* renamed from: a, reason: from getter */
    public final String getBody() {
        return this.body;
    }

    /* renamed from: b, reason: from getter */
    public final String getMessageId() {
        return this.messageId;
    }

    /* renamed from: c, reason: from getter */
    public final String getRequestId() {
        return this.requestId;
    }

    /* renamed from: d, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    /* renamed from: e, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ToolApprovalRequest)) {
            return false;
        }
        ToolApprovalRequest toolApprovalRequest = (ToolApprovalRequest) other;
        return kotlin.jvm.internal.p.d(this.sessionId, toolApprovalRequest.sessionId) && kotlin.jvm.internal.p.d(this.requestId, toolApprovalRequest.requestId) && kotlin.jvm.internal.p.d(this.messageId, toolApprovalRequest.messageId) && kotlin.jvm.internal.p.d(this.title, toolApprovalRequest.title) && kotlin.jvm.internal.p.d(this.body, toolApprovalRequest.body);
    }

    public int hashCode() {
        int iHashCode = ((((((this.sessionId.hashCode() * 31) + this.requestId.hashCode()) * 31) + this.messageId.hashCode()) * 31) + this.title.hashCode()) * 31;
        String str = this.body;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "ToolApprovalRequest(sessionId=" + this.sessionId + ", requestId=" + this.requestId + ", messageId=" + this.messageId + ", title=" + this.title + ", body=" + this.body + ")";
    }
}
