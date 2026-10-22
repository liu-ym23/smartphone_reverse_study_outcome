package com.stepos.ailauncher.chat.view;

import com.autonavi.aps.amapapi.config.Const;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\fR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0014\u001a\u0004\b\u0016\u0010\fR\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u001a\u0010\f¨\u0006\u001b"}, d2 = {"Lcom/stepos/ailauncher/chat/view/X;", "", "", "sessionId", "inquiryId", "", "Lcom/stepos/ailauncher/chat/view/S;", "inquiries", "askUserMessageId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_UMID, "c", "Ljava/util/List;", Const.INTENT_KEY_PKGNAME, "()Ljava/util/List;", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.chat.view.X, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class AskUserRequest {
    private final String askUserMessageId;
    private final List<AskUserInquiry> inquiries;
    private final String inquiryId;
    private final String sessionId;

    public AskUserRequest(String sessionId, String inquiryId, List<AskUserInquiry> inquiries, String askUserMessageId) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        kotlin.jvm.internal.p.i(inquiryId, "inquiryId");
        kotlin.jvm.internal.p.i(inquiries, "inquiries");
        kotlin.jvm.internal.p.i(askUserMessageId, "askUserMessageId");
        this.sessionId = sessionId;
        this.inquiryId = inquiryId;
        this.inquiries = inquiries;
        this.askUserMessageId = askUserMessageId;
    }

    /* renamed from: a, reason: from getter */
    public final String getAskUserMessageId() {
        return this.askUserMessageId;
    }

    public final List<AskUserInquiry> b() {
        return this.inquiries;
    }

    /* renamed from: c, reason: from getter */
    public final String getInquiryId() {
        return this.inquiryId;
    }

    /* renamed from: d, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AskUserRequest)) {
            return false;
        }
        AskUserRequest askUserRequest = (AskUserRequest) other;
        return kotlin.jvm.internal.p.d(this.sessionId, askUserRequest.sessionId) && kotlin.jvm.internal.p.d(this.inquiryId, askUserRequest.inquiryId) && kotlin.jvm.internal.p.d(this.inquiries, askUserRequest.inquiries) && kotlin.jvm.internal.p.d(this.askUserMessageId, askUserRequest.askUserMessageId);
    }

    public int hashCode() {
        return (((((this.sessionId.hashCode() * 31) + this.inquiryId.hashCode()) * 31) + this.inquiries.hashCode()) * 31) + this.askUserMessageId.hashCode();
    }

    public String toString() {
        return "AskUserRequest(sessionId=" + this.sessionId + ", inquiryId=" + this.inquiryId + ", inquiries=" + this.inquiries + ", askUserMessageId=" + this.askUserMessageId + ")";
    }
}
