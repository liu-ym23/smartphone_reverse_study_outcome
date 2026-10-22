package com.stepos.agentframework.chatcore.send;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\nR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\fR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0011\u001a\u0004\b\u0015\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/stepos/agentframework/chatcore/send/b;", "", "", "replyText", "", "slaScene", "replyMessageId", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "I", "c", Const.INTENT_KEY_APIKEY, "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.agentframework.chatcore.send.b, reason: from toString */
/* loaded from: classes2.dex */
public final /* data */ class LocalExecResult {
    private final String replyMessageId;
    private final String replyText;
    private final int slaScene;

    public LocalExecResult(String replyText, int i10, String str) {
        p.i(replyText, "replyText");
        this.replyText = replyText;
        this.slaScene = i10;
        this.replyMessageId = str;
    }

    /* renamed from: a, reason: from getter */
    public final String getReplyMessageId() {
        return this.replyMessageId;
    }

    /* renamed from: b, reason: from getter */
    public final String getReplyText() {
        return this.replyText;
    }

    /* renamed from: c, reason: from getter */
    public final int getSlaScene() {
        return this.slaScene;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LocalExecResult)) {
            return false;
        }
        LocalExecResult localExecResult = (LocalExecResult) other;
        return p.d(this.replyText, localExecResult.replyText) && this.slaScene == localExecResult.slaScene && p.d(this.replyMessageId, localExecResult.replyMessageId);
    }

    public int hashCode() {
        int iHashCode = ((this.replyText.hashCode() * 31) + Integer.hashCode(this.slaScene)) * 31;
        String str = this.replyMessageId;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "LocalExecResult(replyText=" + this.replyText + ", slaScene=" + this.slaScene + ", replyMessageId=" + this.replyMessageId + ")";
    }

    public /* synthetic */ LocalExecResult(String str, int i10, String str2, int i11, kotlin.jvm.internal.i iVar) {
        this(str, (i11 & 2) != 0 ? -1 : i10, (i11 & 4) != 0 ? null : str2);
    }
}
