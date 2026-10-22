package io.ktor.client.plugins.sse;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0005\u0002\u0003\u0004\u0005\u0006\u0082\u0001\u0005\u0007\b\t\n\u000b¨\u0006\fÀ\u0006\u0003"}, d2 = {"Lio/ktor/client/plugins/sse/SSEBufferPolicy;", "", "Off", "LastEvents", "LastLines", "LastEvent", "All", "Lio/ktor/client/plugins/sse/SSEBufferPolicy$All;", "Lio/ktor/client/plugins/sse/SSEBufferPolicy$LastEvent;", "Lio/ktor/client/plugins/sse/SSEBufferPolicy$LastEvents;", "Lio/ktor/client/plugins/sse/SSEBufferPolicy$LastLines;", "Lio/ktor/client/plugins/sse/SSEBufferPolicy$Off;", "ktor-client-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface SSEBufferPolicy {

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÖ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lio/ktor/client/plugins/sse/SSEBufferPolicy$All;", "Lio/ktor/client/plugins/sse/SSEBufferPolicy;", "<init>", "()V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "ktor-client-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class All implements SSEBufferPolicy {
        public static final All INSTANCE = new All();

        private All() {
        }

        public boolean equals(Object other) {
            return this == other || (other instanceof All);
        }

        public int hashCode() {
            return 1036633514;
        }

        public String toString() {
            return "All";
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÖ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lio/ktor/client/plugins/sse/SSEBufferPolicy$LastEvent;", "Lio/ktor/client/plugins/sse/SSEBufferPolicy;", "<init>", "()V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "ktor-client-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class LastEvent implements SSEBufferPolicy {
        public static final LastEvent INSTANCE = new LastEvent();

        private LastEvent() {
        }

        public boolean equals(Object other) {
            return this == other || (other instanceof LastEvent);
        }

        public int hashCode() {
            return 1946844909;
        }

        public String toString() {
            return "LastEvent";
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nHÖ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0007J\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u0007¨\u0006\u0015"}, d2 = {"Lio/ktor/client/plugins/sse/SSEBufferPolicy$LastEvents;", "Lio/ktor/client/plugins/sse/SSEBufferPolicy;", "", "count", "<init>", "(I)V", "component1", "()I", ChatTracker.CLICK_COPY, "(I)Lio/ktor/client/plugins/sse/SSEBufferPolicy$LastEvents;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "I", "getCount", "ktor-client-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class LastEvents implements SSEBufferPolicy {
        private final int count;

        public LastEvents(int i10) {
            this.count = i10;
            if (i10 <= 0) {
                throw new IllegalArgumentException("Count must be > 0");
            }
        }

        public static /* synthetic */ LastEvents copy$default(LastEvents lastEvents, int i10, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                i10 = lastEvents.count;
            }
            return lastEvents.copy(i10);
        }

        /* renamed from: component1, reason: from getter */
        public final int getCount() {
            return this.count;
        }

        public final LastEvents copy(int count) {
            return new LastEvents(count);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof LastEvents) && this.count == ((LastEvents) other).count;
        }

        public final int getCount() {
            return this.count;
        }

        public int hashCode() {
            return Integer.hashCode(this.count);
        }

        public String toString() {
            return "LastEvents(count=" + this.count + ')';
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nHÖ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0007J\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u0007¨\u0006\u0015"}, d2 = {"Lio/ktor/client/plugins/sse/SSEBufferPolicy$LastLines;", "Lio/ktor/client/plugins/sse/SSEBufferPolicy;", "", "count", "<init>", "(I)V", "component1", "()I", ChatTracker.CLICK_COPY, "(I)Lio/ktor/client/plugins/sse/SSEBufferPolicy$LastLines;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "I", "getCount", "ktor-client-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class LastLines implements SSEBufferPolicy {
        private final int count;

        public LastLines(int i10) {
            this.count = i10;
            if (i10 <= 0) {
                throw new IllegalArgumentException("Count must be > 0");
            }
        }

        public static /* synthetic */ LastLines copy$default(LastLines lastLines, int i10, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                i10 = lastLines.count;
            }
            return lastLines.copy(i10);
        }

        /* renamed from: component1, reason: from getter */
        public final int getCount() {
            return this.count;
        }

        public final LastLines copy(int count) {
            return new LastLines(count);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof LastLines) && this.count == ((LastLines) other).count;
        }

        public final int getCount() {
            return this.count;
        }

        public int hashCode() {
            return Integer.hashCode(this.count);
        }

        public String toString() {
            return "LastLines(count=" + this.count + ')';
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÖ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lio/ktor/client/plugins/sse/SSEBufferPolicy$Off;", "Lio/ktor/client/plugins/sse/SSEBufferPolicy;", "<init>", "()V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "ktor-client-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Off implements SSEBufferPolicy {
        public static final Off INSTANCE = new Off();

        private Off() {
        }

        public boolean equals(Object other) {
            return this == other || (other instanceof Off);
        }

        public int hashCode() {
            return 1036646776;
        }

        public String toString() {
            return "Off";
        }
    }
}
