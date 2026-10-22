package com.stepos.agentframework.chatcore.audit;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.api.SafetyDecision;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0006\u0004\u0007\bB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0004\u001a\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0001\u0004\t\n\u000b\f¨\u0006\r"}, d2 = {"Lcom/stepos/agentframework/chatcore/audit/g;", "", "<init>", "()V", Const.INTENT_KEY_APIKEY, "()Lcom/stepos/agentframework/chatcore/audit/g;", "c", Const.INTENT_KEY_UMID, Const.INTENT_KEY_PKGNAME, "Lcom/stepos/agentframework/chatcore/audit/g$a;", "Lcom/stepos/agentframework/chatcore/audit/g$b;", "Lcom/stepos/agentframework/chatcore/audit/g$c;", "Lcom/stepos/agentframework/chatcore/audit/g$d;", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class g {

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/agentframework/chatcore/audit/g$a;", "Lcom/stepos/agentframework/chatcore/audit/g;", "<init>", "()V", "", "toString", "()Ljava/lang/String;", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a extends g {
        public static final a INSTANCE = new a();

        public a() {
            super(null);
        }

        public String toString() {
            return "BLOCK";
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\u000bR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/stepos/agentframework/chatcore/audit/g$b;", "Lcom/stepos/agentframework/chatcore/audit/g;", "", "code", "", "message", "<init>", "(ILjava/lang/String;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getCode", "Ljava/lang/String;", "getMessage", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatcore.audit.g$b, reason: from toString */
    public static final /* data */ class Error extends g {
        private final int code;
        private final String message;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Error(int i10, String message) {
            super(null);
            p.i(message, "message");
            this.code = i10;
            this.message = message;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Error)) {
                return false;
            }
            Error error = (Error) other;
            return this.code == error.code && p.d(this.message, error.message);
        }

        public int hashCode() {
            return (Integer.hashCode(this.code) * 31) + this.message.hashCode();
        }

        public String toString() {
            return "Error(code=" + this.code + ", message=" + this.message + ")";
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/agentframework/chatcore/audit/g$c;", "Lcom/stepos/agentframework/chatcore/audit/g;", "<init>", "()V", "", "toString", "()Ljava/lang/String;", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class c extends g {
        public static final c INSTANCE = new c();

        public c() {
            super(null);
        }

        public String toString() {
            return "PASS";
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/agentframework/chatcore/audit/g$d;", "Lcom/stepos/agentframework/chatcore/audit/g;", "<init>", "()V", "", "toString", "()Ljava/lang/String;", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class d extends g {
        public static final d INSTANCE = new d();

        public d() {
            super(null);
        }

        public String toString() {
            return SafetyDecision.REVERT;
        }
    }

    public /* synthetic */ g(kotlin.jvm.internal.i iVar) {
        this();
    }

    public final g a() {
        return this instanceof Error ? a.INSTANCE : this;
    }

    public g() {
    }
}
