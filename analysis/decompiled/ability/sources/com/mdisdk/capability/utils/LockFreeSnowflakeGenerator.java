package com.mdisdk.capability.utils;

import androidx.appfunctions.metadata.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.time.Instant;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00122\u00020\u0001:\u0002\u0012\u0013B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\n\u001a\u00020\u0003J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0003H\u0002J\b\u0010\u000e\u001a\u00020\u0003H\u0002J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0003R\u000e\u0010\u0007\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/mdisdk/capability/utils/LockFreeSnowflakeGenerator;", "", "datacenterId", "", "workerId", AppAgent.CONSTRUCT, "(JJ)V", "nodePart", "state", "Ljava/util/concurrent/atomic/AtomicLong;", "nextId", "makeId", "timestamp", "sequence", "getCurrentTimestamp", "parseId", "Lcom/mdisdk/capability/utils/LockFreeSnowflakeGenerator$SnowflakeId;", "id", "Companion", "SnowflakeId", "mdisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class LockFreeSnowflakeGenerator {
    private static final int DATACENTER_BITS = 5;
    private static final int DATACENTER_SHIFT = 17;
    private static final long MAX_CLOCK_BACKWARD_WAIT_MS = 5;
    private static final long MAX_DATACENTER_ID = 31;
    private static final long MAX_SEQUENCE = 4095;
    private static final long MAX_WORKER_ID = 31;
    private static final int SEQUENCE_BITS = 12;
    private static final long START_TIMESTAMP = 1704067200000L;
    private static final int TIMESTAMP_SHIFT = 22;
    private static final int WORKER_BITS = 5;
    private static final int WORKER_SHIFT = 12;
    private final long nodePart;
    private final AtomicLong state;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0014\u001a\u00020\u0015H\u0016J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J;\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\u0010\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006!"}, d2 = {"Lcom/mdisdk/capability/utils/LockFreeSnowflakeGenerator$SnowflakeId;", "", "id", "", "timestamp", "datacenterId", "workerId", "sequence", AppAgent.CONSTRUCT, "(JJJJJ)V", "getId", "()J", "getTimestamp", "getDatacenterId", "getWorkerId", "getSequence", "dateTime", "Ljava/time/Instant;", "getDateTime", "()Ljava/time/Instant;", "toString", "", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "mdisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class SnowflakeId {
        private final long datacenterId;
        private final long id;
        private final long sequence;
        private final long timestamp;
        private final long workerId;

        public SnowflakeId(long j5, long j6, long j10, long j11, long j12) {
            this.id = j5;
            this.timestamp = j6;
            this.datacenterId = j10;
            this.workerId = j11;
            this.sequence = j12;
        }

        public static /* synthetic */ SnowflakeId copy$default(SnowflakeId snowflakeId, long j5, long j6, long j10, long j11, long j12, int i, Object obj) {
            if ((i & 1) != 0) {
                j5 = snowflakeId.id;
            }
            long j13 = j5;
            if ((i & 2) != 0) {
                j6 = snowflakeId.timestamp;
            }
            return snowflakeId.copy(j13, j6, (i & 4) != 0 ? snowflakeId.datacenterId : j10, (i & 8) != 0 ? snowflakeId.workerId : j11, (i & 16) != 0 ? snowflakeId.sequence : j12);
        }

        /* renamed from: component1, reason: from getter */
        public final long getId() {
            return this.id;
        }

        /* renamed from: component2, reason: from getter */
        public final long getTimestamp() {
            return this.timestamp;
        }

        /* renamed from: component3, reason: from getter */
        public final long getDatacenterId() {
            return this.datacenterId;
        }

        /* renamed from: component4, reason: from getter */
        public final long getWorkerId() {
            return this.workerId;
        }

        /* renamed from: component5, reason: from getter */
        public final long getSequence() {
            return this.sequence;
        }

        public final SnowflakeId copy(long id, long timestamp, long datacenterId, long workerId, long sequence) {
            return new SnowflakeId(id, timestamp, datacenterId, workerId, sequence);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SnowflakeId)) {
                return false;
            }
            SnowflakeId snowflakeId = (SnowflakeId) other;
            return this.id == snowflakeId.id && this.timestamp == snowflakeId.timestamp && this.datacenterId == snowflakeId.datacenterId && this.workerId == snowflakeId.workerId && this.sequence == snowflakeId.sequence;
        }

        public final long getDatacenterId() {
            return this.datacenterId;
        }

        public final Instant getDateTime() {
            Instant instantOfEpochMilli = Instant.ofEpochMilli(this.timestamp);
            k.e(instantOfEpochMilli, "ofEpochMilli(...)");
            return instantOfEpochMilli;
        }

        public final long getId() {
            return this.id;
        }

        public final long getSequence() {
            return this.sequence;
        }

        public final long getTimestamp() {
            return this.timestamp;
        }

        public final long getWorkerId() {
            return this.workerId;
        }

        public int hashCode() {
            return Long.hashCode(this.sequence) + a.c(a.c(a.c(Long.hashCode(this.id) * 31, 31, this.timestamp), 31, this.datacenterId), 31, this.workerId);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("SnowflakeId(id=");
            sb.append(this.id);
            sb.append(", dateTime=");
            sb.append(getDateTime());
            sb.append(", dc=");
            sb.append(this.datacenterId);
            sb.append(", worker=");
            sb.append(this.workerId);
            sb.append(", seq=");
            return B7.a.p(sb, this.sequence, ')');
        }
    }

    public LockFreeSnowflakeGenerator() {
        this(0L, 0L, 3, null);
    }

    private final long getCurrentTimestamp() {
        return System.currentTimeMillis();
    }

    private final long makeId(long timestamp, long sequence) {
        return ((timestamp - START_TIMESTAMP) << 22) | this.nodePart | sequence;
    }

    public final long nextId() {
        long j5 = this.state.get();
        while (true) {
            long currentTimestamp = getCurrentTimestamp();
            long j6 = j5 >>> 22;
            long j10 = j5 & MAX_SEQUENCE;
            if (currentTimestamp < j6) {
                long j11 = j6 - currentTimestamp;
                if (j11 <= MAX_CLOCK_BACKWARD_WAIT_MS) {
                    Thread.sleep(j11);
                    j5 = this.state.get();
                } else {
                    long j12 = j6 + 1;
                    long j13 = (j10 + 1) & MAX_SEQUENCE;
                    if (j13 == 0) {
                        long j14 = j6 + 2;
                        if (this.state.compareAndSet(j5, j14 << 22)) {
                            return makeId(j14, 0L);
                        }
                    } else {
                        if (this.state.compareAndSet(j5, (j12 << 22) | j13)) {
                            return makeId(j12, j13);
                        }
                    }
                    j5 = this.state.get();
                }
            } else {
                if (currentTimestamp == j6) {
                    long j15 = (j10 + 1) & MAX_SEQUENCE;
                    if (j15 == 0) {
                        Thread.yield();
                        j5 = this.state.get();
                    } else {
                        if (this.state.compareAndSet(j5, (currentTimestamp << 22) | j15)) {
                            return makeId(currentTimestamp, j15);
                        }
                    }
                } else {
                    if (this.state.compareAndSet(j5, currentTimestamp << 22)) {
                        return makeId(currentTimestamp, 0L);
                    }
                }
                j5 = this.state.get();
            }
        }
    }

    public final SnowflakeId parseId(long id) {
        return new SnowflakeId(id, (id >> 22) + START_TIMESTAMP, (id >> 17) & 31, (id >> 12) & 31, id & MAX_SEQUENCE);
    }

    public LockFreeSnowflakeGenerator(long j5, long j6) {
        this.state = new AtomicLong(0L);
        if (0 > j5 || j5 >= 32) {
            throw new IllegalArgumentException("Datacenter ID out of range");
        }
        if (0 > j6 || j6 >= 32) {
            throw new IllegalArgumentException("Worker ID out of range");
        }
        this.nodePart = (j5 << 17) | (j6 << 12);
    }

    public /* synthetic */ LockFreeSnowflakeGenerator(long j5, long j6, int i, e eVar) {
        this((i & 1) != 0 ? 1L : j5, (i & 2) != 0 ? 1L : j6);
    }
}
