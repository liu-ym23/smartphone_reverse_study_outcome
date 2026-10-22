package com.stepos.ailauncher.chat.view.sla;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001:\u0003\u0006\u0003\u0007R\u0014\u0010\u0005\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u0082\u0001\u0003\b\t\n¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lcom/stepos/ailauncher/chat/view/sla/a;", "", "", Const.INTENT_KEY_APIKEY, "()Ljava/lang/String;", DidiCardProvider.KEY_TRACE_ID, Const.INTENT_KEY_PKGNAME, "c", "Lcom/stepos/ailauncher/chat/view/sla/a$a;", "Lcom/stepos/ailauncher/chat/view/sla/a$b;", "Lcom/stepos/ailauncher/chat/view/sla/a$c;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface a {

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/stepos/ailauncher/chat/view/sla/a$a;", "Lcom/stepos/ailauncher/chat/view/sla/a;", "", DidiCardProvider.KEY_TRACE_ID, "<init>", "(Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.view.sla.a$a, reason: collision with other inner class name and from toString */
    public static final /* data */ class Close implements a {
        private final String traceId;

        public Close(String traceId) {
            kotlin.jvm.internal.p.i(traceId, "traceId");
            this.traceId = traceId;
        }

        @Override // com.stepos.ailauncher.chat.view.sla.a
        /* renamed from: a, reason: from getter */
        public String getTraceId() {
            return this.traceId;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Close) && kotlin.jvm.internal.p.d(this.traceId, ((Close) other).traceId);
        }

        public int hashCode() {
            return this.traceId.hashCode();
        }

        public String toString() {
            return "Close(traceId=" + this.traceId + ")";
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\bR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0011\u001a\u0004\b\u0013\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/stepos/ailauncher/chat/view/sla/a$c;", "Lcom/stepos/ailauncher/chat/view/sla/a;", "", DidiCardProvider.KEY_TRACE_ID, "reason", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.view.sla.a$c, reason: from toString */
    public static final /* data */ class RestoreInput implements a {
        private final String reason;
        private final String traceId;

        public RestoreInput(String traceId, String reason) {
            kotlin.jvm.internal.p.i(traceId, "traceId");
            kotlin.jvm.internal.p.i(reason, "reason");
            this.traceId = traceId;
            this.reason = reason;
        }

        @Override // com.stepos.ailauncher.chat.view.sla.a
        /* renamed from: a, reason: from getter */
        public String getTraceId() {
            return this.traceId;
        }

        /* renamed from: b, reason: from getter */
        public final String getReason() {
            return this.reason;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RestoreInput)) {
                return false;
            }
            RestoreInput restoreInput = (RestoreInput) other;
            return kotlin.jvm.internal.p.d(this.traceId, restoreInput.traceId) && kotlin.jvm.internal.p.d(this.reason, restoreInput.reason);
        }

        public int hashCode() {
            return (this.traceId.hashCode() * 31) + this.reason.hashCode();
        }

        public String toString() {
            return "RestoreInput(traceId=" + this.traceId + ", reason=" + this.reason + ")";
        }
    }

    /* renamed from: a */
    String getTraceId();

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\nR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0012\u001a\u0004\b\u0014\u0010\nR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/stepos/ailauncher/chat/view/sla/a$b;", "Lcom/stepos/ailauncher/chat/view/sla/a;", "", DidiCardProvider.KEY_TRACE_ID, "reason", "", "waitForUserMessage", "<init>", "(Ljava/lang/String;Ljava/lang/String;Z)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, "Z", "c", "()Z", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.view.sla.a$b, reason: from toString */
    public static final /* data */ class Expand implements a {
        private final String reason;
        private final String traceId;
        private final boolean waitForUserMessage;

        public Expand(String traceId, String reason, boolean z10) {
            kotlin.jvm.internal.p.i(traceId, "traceId");
            kotlin.jvm.internal.p.i(reason, "reason");
            this.traceId = traceId;
            this.reason = reason;
            this.waitForUserMessage = z10;
        }

        @Override // com.stepos.ailauncher.chat.view.sla.a
        /* renamed from: a, reason: from getter */
        public String getTraceId() {
            return this.traceId;
        }

        /* renamed from: b, reason: from getter */
        public final String getReason() {
            return this.reason;
        }

        /* renamed from: c, reason: from getter */
        public final boolean getWaitForUserMessage() {
            return this.waitForUserMessage;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Expand)) {
                return false;
            }
            Expand expand = (Expand) other;
            return kotlin.jvm.internal.p.d(this.traceId, expand.traceId) && kotlin.jvm.internal.p.d(this.reason, expand.reason) && this.waitForUserMessage == expand.waitForUserMessage;
        }

        public int hashCode() {
            return (((this.traceId.hashCode() * 31) + this.reason.hashCode()) * 31) + Boolean.hashCode(this.waitForUserMessage);
        }

        public String toString() {
            return "Expand(traceId=" + this.traceId + ", reason=" + this.reason + ", waitForUserMessage=" + this.waitForUserMessage + ")";
        }

        public /* synthetic */ Expand(String str, String str2, boolean z10, int i10, kotlin.jvm.internal.i iVar) {
            this(str, str2, (i10 & 4) != 0 ? false : z10);
        }
    }
}
