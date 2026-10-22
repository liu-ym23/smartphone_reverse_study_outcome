package com.stepos.agentframework.chatui.longtext;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/stepos/agentframework/chatui/longtext/c;", "", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, "Lcom/stepos/agentframework/chatui/longtext/c$a;", "Lcom/stepos/agentframework/chatui/longtext/c$b;", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface c {

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0017\u0010\nR\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0016\u001a\u0004\b\u0018\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/stepos/agentframework/chatui/longtext/c$a;", "Lcom/stepos/agentframework/chatui/longtext/c;", "Lcom/stepos/agentframework/chatui/longtext/LongTextFallbackReason;", "reason", "", "nodeType", "htmlTag", "<init>", "(Lcom/stepos/agentframework/chatui/longtext/LongTextFallbackReason;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/stepos/agentframework/chatui/longtext/LongTextFallbackReason;", "c", "()Lcom/stepos/agentframework/chatui/longtext/LongTextFallbackReason;", "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatui.longtext.c$a, reason: from toString */
    public static final /* data */ class Fallback implements c {
        private final String htmlTag;
        private final String nodeType;
        private final LongTextFallbackReason reason;

        public Fallback(LongTextFallbackReason reason, String nodeType, String htmlTag) {
            p.i(reason, "reason");
            p.i(nodeType, "nodeType");
            p.i(htmlTag, "htmlTag");
            this.reason = reason;
            this.nodeType = nodeType;
            this.htmlTag = htmlTag;
        }

        /* renamed from: a, reason: from getter */
        public final String getHtmlTag() {
            return this.htmlTag;
        }

        /* renamed from: b, reason: from getter */
        public final String getNodeType() {
            return this.nodeType;
        }

        /* renamed from: c, reason: from getter */
        public final LongTextFallbackReason getReason() {
            return this.reason;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Fallback)) {
                return false;
            }
            Fallback fallback = (Fallback) other;
            return this.reason == fallback.reason && p.d(this.nodeType, fallback.nodeType) && p.d(this.htmlTag, fallback.htmlTag);
        }

        public int hashCode() {
            return (((this.reason.hashCode() * 31) + this.nodeType.hashCode()) * 31) + this.htmlTag.hashCode();
        }

        public String toString() {
            return "Fallback(reason=" + this.reason + ", nodeType=" + this.nodeType + ", htmlTag=" + this.htmlTag + ")";
        }

        public /* synthetic */ Fallback(LongTextFallbackReason longTextFallbackReason, String str, String str2, int i10, i iVar) {
            this(longTextFallbackReason, (i10 & 2) != 0 ? "" : str, (i10 & 4) != 0 ? "" : str2);
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/stepos/agentframework/chatui/longtext/c$b;", "Lcom/stepos/agentframework/chatui/longtext/c;", "Lcom/stepos/agentframework/chatui/longtext/LongTextDocument;", "document", "<init>", "(Lcom/stepos/agentframework/chatui/longtext/LongTextDocument;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/stepos/agentframework/chatui/longtext/LongTextDocument;", Const.INTENT_KEY_APIKEY, "()Lcom/stepos/agentframework/chatui/longtext/LongTextDocument;", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatui.longtext.c$b, reason: from toString */
    public static final /* data */ class Ready implements c {
        private final LongTextDocument document;

        public Ready(LongTextDocument document) {
            p.i(document, "document");
            this.document = document;
        }

        /* renamed from: a, reason: from getter */
        public final LongTextDocument getDocument() {
            return this.document;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Ready) && p.d(this.document, ((Ready) other).document);
        }

        public int hashCode() {
            return this.document.hashCode();
        }

        public String toString() {
            return "Ready(document=" + this.document + ")";
        }
    }
}
