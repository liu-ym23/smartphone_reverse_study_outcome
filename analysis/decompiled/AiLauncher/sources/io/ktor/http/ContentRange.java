package io.ktor.http;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lio/ktor/http/ContentRange;", "", "<init>", "()V", "Bounded", "TailFrom", "Suffix", "Lio/ktor/http/ContentRange$Bounded;", "Lio/ktor/http/ContentRange$Suffix;", "Lio/ktor/http/ContentRange$TailFrom;", "ktor-http"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class ContentRange {

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u000bJ$\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0017\u001a\u0004\b\u0018\u0010\u000bR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0017\u001a\u0004\b\u0019\u0010\u000b¨\u0006\u001a"}, d2 = {"Lio/ktor/http/ContentRange$Bounded;", "Lio/ktor/http/ContentRange;", "", "from", "to", "<init>", "(JJ)V", "", "toString", "()Ljava/lang/String;", "component1", "()J", "component2", ChatTracker.CLICK_COPY, "(JJ)Lio/ktor/http/ContentRange$Bounded;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "J", "getFrom", "getTo", "ktor-http"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Bounded extends ContentRange {
        private final long from;
        private final long to;

        public Bounded(long j10, long j11) {
            super(null);
            this.from = j10;
            this.to = j11;
        }

        public static /* synthetic */ Bounded copy$default(Bounded bounded, long j10, long j11, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                j10 = bounded.from;
            }
            if ((i10 & 2) != 0) {
                j11 = bounded.to;
            }
            return bounded.copy(j10, j11);
        }

        /* renamed from: component1, reason: from getter */
        public final long getFrom() {
            return this.from;
        }

        /* renamed from: component2, reason: from getter */
        public final long getTo() {
            return this.to;
        }

        public final Bounded copy(long from, long to) {
            return new Bounded(from, to);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Bounded)) {
                return false;
            }
            Bounded bounded = (Bounded) other;
            return this.from == bounded.from && this.to == bounded.to;
        }

        public final long getFrom() {
            return this.from;
        }

        public final long getTo() {
            return this.to;
        }

        public int hashCode() {
            return (Long.hashCode(this.from) * 31) + Long.hashCode(this.to);
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.from);
            sb2.append('-');
            sb2.append(this.to);
            return sb2.toString();
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\n¨\u0006\u0017"}, d2 = {"Lio/ktor/http/ContentRange$Suffix;", "Lio/ktor/http/ContentRange;", "", "lastCount", "<init>", "(J)V", "", "toString", "()Ljava/lang/String;", "component1", "()J", ChatTracker.CLICK_COPY, "(J)Lio/ktor/http/ContentRange$Suffix;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "J", "getLastCount", "ktor-http"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Suffix extends ContentRange {
        private final long lastCount;

        public Suffix(long j10) {
            super(null);
            this.lastCount = j10;
        }

        public static /* synthetic */ Suffix copy$default(Suffix suffix, long j10, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                j10 = suffix.lastCount;
            }
            return suffix.copy(j10);
        }

        /* renamed from: component1, reason: from getter */
        public final long getLastCount() {
            return this.lastCount;
        }

        public final Suffix copy(long lastCount) {
            return new Suffix(lastCount);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Suffix) && this.lastCount == ((Suffix) other).lastCount;
        }

        public final long getLastCount() {
            return this.lastCount;
        }

        public int hashCode() {
            return Long.hashCode(this.lastCount);
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append('-');
            sb2.append(this.lastCount);
            return sb2.toString();
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\n¨\u0006\u0017"}, d2 = {"Lio/ktor/http/ContentRange$TailFrom;", "Lio/ktor/http/ContentRange;", "", "from", "<init>", "(J)V", "", "toString", "()Ljava/lang/String;", "component1", "()J", ChatTracker.CLICK_COPY, "(J)Lio/ktor/http/ContentRange$TailFrom;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "J", "getFrom", "ktor-http"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class TailFrom extends ContentRange {
        private final long from;

        public TailFrom(long j10) {
            super(null);
            this.from = j10;
        }

        public static /* synthetic */ TailFrom copy$default(TailFrom tailFrom, long j10, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                j10 = tailFrom.from;
            }
            return tailFrom.copy(j10);
        }

        /* renamed from: component1, reason: from getter */
        public final long getFrom() {
            return this.from;
        }

        public final TailFrom copy(long from) {
            return new TailFrom(from);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof TailFrom) && this.from == ((TailFrom) other).from;
        }

        public final long getFrom() {
            return this.from;
        }

        public int hashCode() {
            return Long.hashCode(this.from);
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.from);
            sb2.append('-');
            return sb2.toString();
        }
    }

    public /* synthetic */ ContentRange(kotlin.jvm.internal.i iVar) {
        this();
    }

    private ContentRange() {
    }
}
