package com.stepos.agentframework.chatcore.intent;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ame.sdk.SkillStoreKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0011\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\fR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0013\u001a\u0004\b\u0015\u0010\fR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0016\u0010\fR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0017\u0010\fR\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/stepos/agentframework/chatcore/intent/A;", "", "", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "extra", "errorCode", "errorMessage", "", "success", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_UMID, Const.INTENT_KEY_PKGNAME, "c", "Ljava/lang/Boolean;", "e", "()Ljava/lang/Boolean;", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.agentframework.chatcore.intent.A, reason: from toString */
/* loaded from: classes2.dex */
public final /* data */ class ToolTaskResult {
    private final String content;
    private final String errorCode;
    private final String errorMessage;
    private final String extra;
    private final Boolean success;

    public ToolTaskResult() {
        this(null, null, null, null, null, 31, null);
    }

    /* renamed from: a, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* renamed from: b, reason: from getter */
    public final String getErrorCode() {
        return this.errorCode;
    }

    /* renamed from: c, reason: from getter */
    public final String getErrorMessage() {
        return this.errorMessage;
    }

    /* renamed from: d, reason: from getter */
    public final String getExtra() {
        return this.extra;
    }

    /* renamed from: e, reason: from getter */
    public final Boolean getSuccess() {
        return this.success;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ToolTaskResult)) {
            return false;
        }
        ToolTaskResult toolTaskResult = (ToolTaskResult) other;
        return kotlin.jvm.internal.p.d(this.content, toolTaskResult.content) && kotlin.jvm.internal.p.d(this.extra, toolTaskResult.extra) && kotlin.jvm.internal.p.d(this.errorCode, toolTaskResult.errorCode) && kotlin.jvm.internal.p.d(this.errorMessage, toolTaskResult.errorMessage) && kotlin.jvm.internal.p.d(this.success, toolTaskResult.success);
    }

    public int hashCode() {
        String str = this.content;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.extra;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.errorCode;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.errorMessage;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Boolean bool = this.success;
        return iHashCode4 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        return "ToolTaskResult(content=" + this.content + ", extra=" + this.extra + ", errorCode=" + this.errorCode + ", errorMessage=" + this.errorMessage + ", success=" + this.success + ")";
    }

    public ToolTaskResult(String str, String str2, String str3, String str4, Boolean bool) {
        this.content = str;
        this.extra = str2;
        this.errorCode = str3;
        this.errorMessage = str4;
        this.success = bool;
    }

    public /* synthetic */ ToolTaskResult(String str, String str2, String str3, String str4, Boolean bool, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : str3, (i10 & 8) != 0 ? null : str4, (i10 & 16) != 0 ? null : bool);
    }
}
