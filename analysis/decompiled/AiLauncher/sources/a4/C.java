package a4;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.agent.receiver.SystemDeleteBroadcastReceiver;
import com.stepos.ailauncher.taskstore.provider.c;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"La4/C;", "", "<init>", "()V", Const.INTENT_KEY_PKGNAME, "c", Const.INTENT_KEY_APIKEY, "La4/C$a;", "La4/C$b;", "La4/C$c;", "protocol_agentbus_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class C {

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0015\u0010\u001bR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u001a\u001a\u0004\b\u001c\u0010\u001bR\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u0019\u0010\f¨\u0006\u001e"}, d2 = {"La4/C$a;", "La4/C;", "La4/A;", "task", "", c.a.COL_SEQ, "ts", "", SystemDeleteBroadcastReceiver.EXTRA_SESSION_KEY, "<init>", "(La4/A;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "La4/A;", "c", "()La4/A;", Const.INTENT_KEY_PKGNAME, "Ljava/lang/Long;", "()Ljava/lang/Long;", Const.INTENT_KEY_UMID, "Ljava/lang/String;", "protocol_agentbus_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: a4.C$a, reason: from toString */
    public static final /* data */ class Completed extends C {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final Task task;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        public final Long seq;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        public final Long ts;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        public final String sessionKey;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Completed(Task task, Long l10, Long l11, String str) {
            super(null);
            kotlin.jvm.internal.p.i(task, "task");
            this.task = task;
            this.seq = l10;
            this.ts = l11;
            this.sessionKey = str;
        }

        /* renamed from: a, reason: from getter */
        public Long getSeq() {
            return this.seq;
        }

        /* renamed from: b, reason: from getter */
        public String getSessionKey() {
            return this.sessionKey;
        }

        /* renamed from: c, reason: from getter */
        public final Task getTask() {
            return this.task;
        }

        /* renamed from: d, reason: from getter */
        public Long getTs() {
            return this.ts;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Completed)) {
                return false;
            }
            Completed completed = (Completed) other;
            return kotlin.jvm.internal.p.d(this.task, completed.task) && kotlin.jvm.internal.p.d(this.seq, completed.seq) && kotlin.jvm.internal.p.d(this.ts, completed.ts) && kotlin.jvm.internal.p.d(this.sessionKey, completed.sessionKey);
        }

        public int hashCode() {
            int iHashCode = this.task.hashCode() * 31;
            Long l10 = this.seq;
            int iHashCode2 = (iHashCode + (l10 == null ? 0 : l10.hashCode())) * 31;
            Long l11 = this.ts;
            int iHashCode3 = (iHashCode2 + (l11 == null ? 0 : l11.hashCode())) * 31;
            String str = this.sessionKey;
            return iHashCode3 + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            return "Completed(task=" + this.task + ", seq=" + this.seq + ", ts=" + this.ts + ", sessionKey=" + this.sessionKey + ")";
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0015\u0010\u001bR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u001a\u001a\u0004\b\u001c\u0010\u001bR\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u0019\u0010\f¨\u0006\u001e"}, d2 = {"La4/C$b;", "La4/C;", "La4/A;", "task", "", c.a.COL_SEQ, "ts", "", SystemDeleteBroadcastReceiver.EXTRA_SESSION_KEY, "<init>", "(La4/A;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "La4/A;", "c", "()La4/A;", Const.INTENT_KEY_PKGNAME, "Ljava/lang/Long;", "()Ljava/lang/Long;", Const.INTENT_KEY_UMID, "Ljava/lang/String;", "protocol_agentbus_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: a4.C$b, reason: from toString */
    public static final /* data */ class Created extends C {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final Task task;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        public final Long seq;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        public final Long ts;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        public final String sessionKey;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Created(Task task, Long l10, Long l11, String str) {
            super(null);
            kotlin.jvm.internal.p.i(task, "task");
            this.task = task;
            this.seq = l10;
            this.ts = l11;
            this.sessionKey = str;
        }

        /* renamed from: a, reason: from getter */
        public Long getSeq() {
            return this.seq;
        }

        /* renamed from: b, reason: from getter */
        public String getSessionKey() {
            return this.sessionKey;
        }

        /* renamed from: c, reason: from getter */
        public final Task getTask() {
            return this.task;
        }

        /* renamed from: d, reason: from getter */
        public Long getTs() {
            return this.ts;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Created)) {
                return false;
            }
            Created created = (Created) other;
            return kotlin.jvm.internal.p.d(this.task, created.task) && kotlin.jvm.internal.p.d(this.seq, created.seq) && kotlin.jvm.internal.p.d(this.ts, created.ts) && kotlin.jvm.internal.p.d(this.sessionKey, created.sessionKey);
        }

        public int hashCode() {
            int iHashCode = this.task.hashCode() * 31;
            Long l10 = this.seq;
            int iHashCode2 = (iHashCode + (l10 == null ? 0 : l10.hashCode())) * 31;
            Long l11 = this.ts;
            int iHashCode3 = (iHashCode2 + (l11 == null ? 0 : l11.hashCode())) * 31;
            String str = this.sessionKey;
            return iHashCode3 + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            return "Created(task=" + this.task + ", seq=" + this.seq + ", ts=" + this.ts + ", sessionKey=" + this.sessionKey + ")";
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0015\u0010\u001bR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u001a\u001a\u0004\b\u001c\u0010\u001bR\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u0019\u0010\f¨\u0006\u001e"}, d2 = {"La4/C$c;", "La4/C;", "La4/A;", "task", "", c.a.COL_SEQ, "ts", "", SystemDeleteBroadcastReceiver.EXTRA_SESSION_KEY, "<init>", "(La4/A;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "La4/A;", "c", "()La4/A;", Const.INTENT_KEY_PKGNAME, "Ljava/lang/Long;", "()Ljava/lang/Long;", Const.INTENT_KEY_UMID, "Ljava/lang/String;", "protocol_agentbus_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: a4.C$c, reason: from toString */
    public static final /* data */ class Updated extends C {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final Task task;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        public final Long seq;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        public final Long ts;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        public final String sessionKey;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Updated(Task task, Long l10, Long l11, String str) {
            super(null);
            kotlin.jvm.internal.p.i(task, "task");
            this.task = task;
            this.seq = l10;
            this.ts = l11;
            this.sessionKey = str;
        }

        /* renamed from: a, reason: from getter */
        public Long getSeq() {
            return this.seq;
        }

        /* renamed from: b, reason: from getter */
        public String getSessionKey() {
            return this.sessionKey;
        }

        /* renamed from: c, reason: from getter */
        public final Task getTask() {
            return this.task;
        }

        /* renamed from: d, reason: from getter */
        public Long getTs() {
            return this.ts;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Updated)) {
                return false;
            }
            Updated updated = (Updated) other;
            return kotlin.jvm.internal.p.d(this.task, updated.task) && kotlin.jvm.internal.p.d(this.seq, updated.seq) && kotlin.jvm.internal.p.d(this.ts, updated.ts) && kotlin.jvm.internal.p.d(this.sessionKey, updated.sessionKey);
        }

        public int hashCode() {
            int iHashCode = this.task.hashCode() * 31;
            Long l10 = this.seq;
            int iHashCode2 = (iHashCode + (l10 == null ? 0 : l10.hashCode())) * 31;
            Long l11 = this.ts;
            int iHashCode3 = (iHashCode2 + (l11 == null ? 0 : l11.hashCode())) * 31;
            String str = this.sessionKey;
            return iHashCode3 + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            return "Updated(task=" + this.task + ", seq=" + this.seq + ", ts=" + this.ts + ", sessionKey=" + this.sessionKey + ")";
        }
    }

    public /* synthetic */ C(kotlin.jvm.internal.i iVar) {
        this();
    }

    public C() {
    }
}
