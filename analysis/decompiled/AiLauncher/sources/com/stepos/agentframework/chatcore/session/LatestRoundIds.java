package com.stepos.agentframework.chatcore.session;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\bR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0010\u001a\u0004\b\u0012\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/h0;", "", "", "chatId", "messageId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.agentframework.chatcore.session.h0, reason: case insensitive filesystem and from toString */
/* loaded from: classes2.dex */
public final /* data */ class LatestRoundIds {
    private final String chatId;
    private final String messageId;

    public LatestRoundIds(String chatId, String messageId) {
        kotlin.jvm.internal.p.i(chatId, "chatId");
        kotlin.jvm.internal.p.i(messageId, "messageId");
        this.chatId = chatId;
        this.messageId = messageId;
    }

    /* renamed from: a, reason: from getter */
    public final String getChatId() {
        return this.chatId;
    }

    /* renamed from: b, reason: from getter */
    public final String getMessageId() {
        return this.messageId;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LatestRoundIds)) {
            return false;
        }
        LatestRoundIds latestRoundIds = (LatestRoundIds) other;
        return kotlin.jvm.internal.p.d(this.chatId, latestRoundIds.chatId) && kotlin.jvm.internal.p.d(this.messageId, latestRoundIds.messageId);
    }

    public int hashCode() {
        return (this.chatId.hashCode() * 31) + this.messageId.hashCode();
    }

    public String toString() {
        return "LatestRoundIds(chatId=" + this.chatId + ", messageId=" + this.messageId + ")";
    }
}
