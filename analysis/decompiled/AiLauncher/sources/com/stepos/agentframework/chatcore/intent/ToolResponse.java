package com.stepos.agentframework.chatcore.intent;

import com.stepos.ame.sdk.SkillStoreKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0012\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\rR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0019\u0010\rR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u001a\u0010\rR\u0019\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u001b\u0010\rR\u0019\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u001c\u0010\r¨\u0006\u001d"}, d2 = {"Lcom/stepos/agentframework/chatcore/intent/z;", "", "", "toolCallId", "", "success", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "extra", "errorCode", "errorMessage", "<init>", "(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getToolCallId", "Z", "getSuccess", "()Z", "getContent", "getExtra", "getErrorCode", "getErrorMessage", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.agentframework.chatcore.intent.z, reason: from toString */
/* loaded from: classes2.dex */
public final /* data */ class ToolResponse {
    private final String content;
    private final String errorCode;
    private final String errorMessage;
    private final String extra;
    private final boolean success;
    private final String toolCallId;

    public ToolResponse(String toolCallId, boolean z10, String str, String str2, String str3, String str4) {
        kotlin.jvm.internal.p.i(toolCallId, "toolCallId");
        this.toolCallId = toolCallId;
        this.success = z10;
        this.content = str;
        this.extra = str2;
        this.errorCode = str3;
        this.errorMessage = str4;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ToolResponse)) {
            return false;
        }
        ToolResponse toolResponse = (ToolResponse) other;
        return kotlin.jvm.internal.p.d(this.toolCallId, toolResponse.toolCallId) && this.success == toolResponse.success && kotlin.jvm.internal.p.d(this.content, toolResponse.content) && kotlin.jvm.internal.p.d(this.extra, toolResponse.extra) && kotlin.jvm.internal.p.d(this.errorCode, toolResponse.errorCode) && kotlin.jvm.internal.p.d(this.errorMessage, toolResponse.errorMessage);
    }

    public int hashCode() {
        int iHashCode = ((this.toolCallId.hashCode() * 31) + Boolean.hashCode(this.success)) * 31;
        String str = this.content;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.extra;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.errorCode;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.errorMessage;
        return iHashCode4 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        return "ToolResponse(toolCallId=" + this.toolCallId + ", success=" + this.success + ", content=" + this.content + ", extra=" + this.extra + ", errorCode=" + this.errorCode + ", errorMessage=" + this.errorMessage + ")";
    }
}
