package com.stepos.agentframework.chatcore.send;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\tR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0011\u001a\u0004\b\u0013\u0010\tR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0014\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/stepos/agentframework/chatcore/send/d;", "", "", "messageId", "imageMessageId", "fileMessageId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "c", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.agentframework.chatcore.send.d, reason: from toString */
/* loaded from: classes2.dex */
public final /* data */ class PendingBubbleIds {
    private final String fileMessageId;
    private final String imageMessageId;
    private final String messageId;

    public PendingBubbleIds(String messageId, String str, String str2) {
        p.i(messageId, "messageId");
        this.messageId = messageId;
        this.imageMessageId = str;
        this.fileMessageId = str2;
    }

    /* renamed from: a, reason: from getter */
    public final String getFileMessageId() {
        return this.fileMessageId;
    }

    /* renamed from: b, reason: from getter */
    public final String getImageMessageId() {
        return this.imageMessageId;
    }

    /* renamed from: c, reason: from getter */
    public final String getMessageId() {
        return this.messageId;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PendingBubbleIds)) {
            return false;
        }
        PendingBubbleIds pendingBubbleIds = (PendingBubbleIds) other;
        return p.d(this.messageId, pendingBubbleIds.messageId) && p.d(this.imageMessageId, pendingBubbleIds.imageMessageId) && p.d(this.fileMessageId, pendingBubbleIds.fileMessageId);
    }

    public int hashCode() {
        int iHashCode = this.messageId.hashCode() * 31;
        String str = this.imageMessageId;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.fileMessageId;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "PendingBubbleIds(messageId=" + this.messageId + ", imageMessageId=" + this.imageMessageId + ", fileMessageId=" + this.fileMessageId + ")";
    }
}
