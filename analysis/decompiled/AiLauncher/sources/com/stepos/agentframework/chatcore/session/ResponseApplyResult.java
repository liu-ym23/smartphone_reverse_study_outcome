package com.stepos.agentframework.chatcore.session;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import w4.ChatMessage;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0010\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0016\u0010\u000bR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/D0;", "", "Lw4/c;", "message", "", "oldMessageId", "", "isFirstResponse", "<init>", "(Lw4/c;Ljava/lang/String;Z)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Lw4/c;", Const.INTENT_KEY_APIKEY, "()Lw4/c;", "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "Z", "c", "()Z", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.agentframework.chatcore.session.D0, reason: from toString */
/* loaded from: classes2.dex */
public final /* data */ class ResponseApplyResult {
    private final boolean isFirstResponse;
    private final ChatMessage message;
    private final String oldMessageId;

    public ResponseApplyResult(ChatMessage message, String oldMessageId, boolean z10) {
        kotlin.jvm.internal.p.i(message, "message");
        kotlin.jvm.internal.p.i(oldMessageId, "oldMessageId");
        this.message = message;
        this.oldMessageId = oldMessageId;
        this.isFirstResponse = z10;
    }

    /* renamed from: a, reason: from getter */
    public final ChatMessage getMessage() {
        return this.message;
    }

    /* renamed from: b, reason: from getter */
    public final String getOldMessageId() {
        return this.oldMessageId;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getIsFirstResponse() {
        return this.isFirstResponse;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ResponseApplyResult)) {
            return false;
        }
        ResponseApplyResult responseApplyResult = (ResponseApplyResult) other;
        return kotlin.jvm.internal.p.d(this.message, responseApplyResult.message) && kotlin.jvm.internal.p.d(this.oldMessageId, responseApplyResult.oldMessageId) && this.isFirstResponse == responseApplyResult.isFirstResponse;
    }

    public int hashCode() {
        return (((this.message.hashCode() * 31) + this.oldMessageId.hashCode()) * 31) + Boolean.hashCode(this.isFirstResponse);
    }

    public String toString() {
        return "ResponseApplyResult(message=" + this.message + ", oldMessageId=" + this.oldMessageId + ", isFirstResponse=" + this.isFirstResponse + ")";
    }
}
