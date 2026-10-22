package com.stepos.ailauncher.homegesture;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/stepos/ailauncher/homegesture/a;", "", "<init>", "()V", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, "Lcom/stepos/ailauncher/homegesture/a$a;", "Lcom/stepos/ailauncher/homegesture/a$b;", "homegesture_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.homegesture.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC3334a {

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/stepos/ailauncher/homegesture/a$a;", "Lcom/stepos/ailauncher/homegesture/a;", "", "claimedGeneration", "", "usedPeekEpoch", "<init>", "(JZ)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "J", Const.INTENT_KEY_APIKEY, "()J", "Z", Const.INTENT_KEY_PKGNAME, "()Z", "homegesture_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.homegesture.a$a, reason: collision with other inner class name and from toString */
    public static final /* data */ class Accepted extends AbstractC3334a {
        private final long claimedGeneration;
        private final boolean usedPeekEpoch;

        public Accepted(long j10, boolean z10) {
            super(null);
            this.claimedGeneration = j10;
            this.usedPeekEpoch = z10;
        }

        /* renamed from: a, reason: from getter */
        public final long getClaimedGeneration() {
            return this.claimedGeneration;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getUsedPeekEpoch() {
            return this.usedPeekEpoch;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Accepted)) {
                return false;
            }
            Accepted accepted = (Accepted) other;
            return this.claimedGeneration == accepted.claimedGeneration && this.usedPeekEpoch == accepted.usedPeekEpoch;
        }

        public int hashCode() {
            return (Long.hashCode(this.claimedGeneration) * 31) + Boolean.hashCode(this.usedPeekEpoch);
        }

        public String toString() {
            return "Accepted(claimedGeneration=" + this.claimedGeneration + ", usedPeekEpoch=" + this.usedPeekEpoch + ")";
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/stepos/ailauncher/homegesture/a$b;", "Lcom/stepos/ailauncher/homegesture/a;", "", "reason", "<init>", "(Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "homegesture_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.homegesture.a$b, reason: from toString */
    public static final /* data */ class Rejected extends AbstractC3334a {
        private final String reason;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Rejected(String reason) {
            super(null);
            kotlin.jvm.internal.p.i(reason, "reason");
            this.reason = reason;
        }

        /* renamed from: a, reason: from getter */
        public final String getReason() {
            return this.reason;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Rejected) && kotlin.jvm.internal.p.d(this.reason, ((Rejected) other).reason);
        }

        public int hashCode() {
            return this.reason.hashCode();
        }

        public String toString() {
            return "Rejected(reason=" + this.reason + ")";
        }
    }

    public /* synthetic */ AbstractC3334a(kotlin.jvm.internal.i iVar) {
        this();
    }

    public AbstractC3334a() {
    }
}
