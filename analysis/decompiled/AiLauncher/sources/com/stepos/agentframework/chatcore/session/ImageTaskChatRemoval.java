package com.stepos.agentframework.chatcore.session;

import com.autonavi.aps.amapapi.config.Const;
import java.util.List;
import kotlin.Metadata;
import w4.ChatMessage;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\fR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0014\u001a\u0004\b\u0016\u0010\fR\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00058\u0006¢\u0006\f\n\u0004\b\b\u0010\u0017\u001a\u0004\b\u001a\u0010\u0019R\u0011\u0010\u001d\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001e"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/c0;", "", "", "sessionId", "taskId", "", "removedMessageIds", "Lw4/c;", "updatedMessages", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "c", Const.INTENT_KEY_UMID, "Ljava/util/List;", Const.INTENT_KEY_PKGNAME, "()Ljava/util/List;", "e", Const.INTENT_KEY_APIKEY, "()Z", "hasChanges", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.agentframework.chatcore.session.c0, reason: case insensitive filesystem and from toString */
/* loaded from: classes2.dex */
public final /* data */ class ImageTaskChatRemoval {
    private final List<String> removedMessageIds;
    private final String sessionId;
    private final String taskId;
    private final List<ChatMessage> updatedMessages;

    public ImageTaskChatRemoval(String sessionId, String taskId, List<String> removedMessageIds, List<ChatMessage> updatedMessages) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        kotlin.jvm.internal.p.i(taskId, "taskId");
        kotlin.jvm.internal.p.i(removedMessageIds, "removedMessageIds");
        kotlin.jvm.internal.p.i(updatedMessages, "updatedMessages");
        this.sessionId = sessionId;
        this.taskId = taskId;
        this.removedMessageIds = removedMessageIds;
        this.updatedMessages = updatedMessages;
    }

    public final boolean a() {
        return (this.removedMessageIds.isEmpty() && this.updatedMessages.isEmpty()) ? false : true;
    }

    public final List<String> b() {
        return this.removedMessageIds;
    }

    /* renamed from: c, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    /* renamed from: d, reason: from getter */
    public final String getTaskId() {
        return this.taskId;
    }

    public final List<ChatMessage> e() {
        return this.updatedMessages;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ImageTaskChatRemoval)) {
            return false;
        }
        ImageTaskChatRemoval imageTaskChatRemoval = (ImageTaskChatRemoval) other;
        return kotlin.jvm.internal.p.d(this.sessionId, imageTaskChatRemoval.sessionId) && kotlin.jvm.internal.p.d(this.taskId, imageTaskChatRemoval.taskId) && kotlin.jvm.internal.p.d(this.removedMessageIds, imageTaskChatRemoval.removedMessageIds) && kotlin.jvm.internal.p.d(this.updatedMessages, imageTaskChatRemoval.updatedMessages);
    }

    public int hashCode() {
        return (((((this.sessionId.hashCode() * 31) + this.taskId.hashCode()) * 31) + this.removedMessageIds.hashCode()) * 31) + this.updatedMessages.hashCode();
    }

    public String toString() {
        return "ImageTaskChatRemoval(sessionId=" + this.sessionId + ", taskId=" + this.taskId + ", removedMessageIds=" + this.removedMessageIds + ", updatedMessages=" + this.updatedMessages + ")";
    }
}
