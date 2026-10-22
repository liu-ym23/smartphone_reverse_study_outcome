package com.stepos.agentbus.generated;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0005\b\tB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0007\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0003\n\u000b\f¨\u0006\r"}, d2 = {"Lcom/stepos/agentbus/generated/c;", "", "<init>", "()V", "", Const.INTENT_KEY_APIKEY, "()Z", "isAvailable", "c", Const.INTENT_KEY_PKGNAME, "Lcom/stepos/agentbus/generated/c$a;", "Lcom/stepos/agentbus/generated/c$b;", "Lcom/stepos/agentbus/generated/c$c;", "protocol_agentbus_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class c {

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/stepos/agentbus/generated/c$a;", "Lcom/stepos/agentbus/generated/c;", "", "reason", "<init>", "(Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "Ljava/lang/String;", "getReason", "protocol_agentbus_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentbus.generated.c$a, reason: from toString */
    public static final /* data */ class Available extends c {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final String reason;

        /* JADX WARN: Multi-variable type inference failed */
        public Available() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Available) && p.d(this.reason, ((Available) other).reason);
        }

        public int hashCode() {
            String str = this.reason;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public String toString() {
            return "Available(reason=" + this.reason + ")";
        }

        public Available(String str) {
            super(null);
            this.reason = str;
        }

        public /* synthetic */ Available(String str, int i10, i iVar) {
            this((i10 & 1) != 0 ? null : str);
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\tR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/stepos/agentbus/generated/c$b;", "Lcom/stepos/agentbus/generated/c;", "", "reason", "", "sinceMs", "<init>", "(Ljava/lang/String;J)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "Ljava/lang/String;", "getReason", Const.INTENT_KEY_PKGNAME, "J", "getSinceMs", "()J", "protocol_agentbus_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentbus.generated.c$b, reason: from toString */
    public static final /* data */ class Degraded extends c {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final String reason;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        public final long sinceMs;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Degraded(String reason, long j10) {
            super(null);
            p.i(reason, "reason");
            this.reason = reason;
            this.sinceMs = j10;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Degraded)) {
                return false;
            }
            Degraded degraded = (Degraded) other;
            return p.d(this.reason, degraded.reason) && this.sinceMs == degraded.sinceMs;
        }

        public int hashCode() {
            return (this.reason.hashCode() * 31) + Long.hashCode(this.sinceMs);
        }

        public String toString() {
            return "Degraded(reason=" + this.reason + ", sinceMs=" + this.sinceMs + ")";
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u000bR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/stepos/agentbus/generated/c$c;", "Lcom/stepos/agentbus/generated/c;", "", "reason", "", "sinceMs", "Lcom/stepos/agentbus/generated/RetryHint;", "retryHint", "<init>", "(Ljava/lang/String;JLcom/stepos/agentbus/generated/RetryHint;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "J", "getSinceMs", "()J", "c", "Lcom/stepos/agentbus/generated/RetryHint;", "getRetryHint", "()Lcom/stepos/agentbus/generated/RetryHint;", "protocol_agentbus_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentbus.generated.c$c, reason: collision with other inner class name and from toString */
    public static final /* data */ class Unavailable extends c {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final String reason;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        public final long sinceMs;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        public final RetryHint retryHint;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Unavailable(String reason, long j10, RetryHint retryHint) {
            super(null);
            p.i(reason, "reason");
            p.i(retryHint, "retryHint");
            this.reason = reason;
            this.sinceMs = j10;
            this.retryHint = retryHint;
        }

        /* renamed from: b, reason: from getter */
        public final String getReason() {
            return this.reason;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Unavailable)) {
                return false;
            }
            Unavailable unavailable = (Unavailable) other;
            return p.d(this.reason, unavailable.reason) && this.sinceMs == unavailable.sinceMs && this.retryHint == unavailable.retryHint;
        }

        public int hashCode() {
            return (((this.reason.hashCode() * 31) + Long.hashCode(this.sinceMs)) * 31) + this.retryHint.hashCode();
        }

        public String toString() {
            return "Unavailable(reason=" + this.reason + ", sinceMs=" + this.sinceMs + ", retryHint=" + this.retryHint + ")";
        }
    }

    public /* synthetic */ c(i iVar) {
        this();
    }

    public final boolean a() {
        return this instanceof Available;
    }

    public c() {
    }
}
