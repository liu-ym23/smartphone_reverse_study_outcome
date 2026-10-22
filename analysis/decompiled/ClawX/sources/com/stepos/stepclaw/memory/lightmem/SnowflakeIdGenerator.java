package com.stepos.stepclaw.memory.lightmem;

import com.stepos.stepclaw.SecurePrefs;
import kotlin.Metadata;
import kotlin.jvm.internal.i;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\n\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\t\u001a\u00020\u0003J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0003H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/stepos/stepclaw/memory/lightmem/SnowflakeIdGenerator;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "datacenterId", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "workerId", "<init>", "(JJ)V", "sequence", "lastTimestamp", "nextId", "tilNextMillis", "last", "Companion", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SnowflakeIdGenerator {
    private static final long DATACENTER_ID_BITS = 5;
    private static final long DATACENTER_ID_SHIFT = 17;
    private static final long EPOCH_MS = 1704067200000L;
    private static final long MAX_DATACENTER_ID = 31;
    private static final long MAX_WORKER_ID = 31;
    private static final long SEQUENCE_BITS = 12;
    private static final long SEQUENCE_MASK = 4095;
    private static final long TIMESTAMP_SHIFT = 22;
    private static final long WORKER_ID_BITS = 5;
    private static final long WORKER_ID_SHIFT = 12;
    private final long datacenterId;
    private long lastTimestamp;
    private long sequence;
    private final long workerId;

    public SnowflakeIdGenerator() {
        this(0L, 0L, 3, null);
    }

    private final long tilNextMillis(long last) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        while (jCurrentTimeMillis <= last) {
            jCurrentTimeMillis = System.currentTimeMillis();
        }
        return jCurrentTimeMillis;
    }

    public final synchronized long nextId() {
        long jCurrentTimeMillis;
        try {
            jCurrentTimeMillis = System.currentTimeMillis();
            long j4 = this.lastTimestamp;
            if (jCurrentTimeMillis < j4) {
                throw new IllegalStateException("Clock moved backwards; refusing to generate id");
            }
            if (jCurrentTimeMillis == j4) {
                long j8 = (this.sequence + 1) & SEQUENCE_MASK;
                this.sequence = j8;
                if (j8 == 0) {
                    jCurrentTimeMillis = tilNextMillis(j4);
                }
            } else {
                this.sequence = 0L;
            }
            this.lastTimestamp = jCurrentTimeMillis;
        } catch (Throwable th) {
            throw th;
        }
        return ((jCurrentTimeMillis - EPOCH_MS) << TIMESTAMP_SHIFT) | (this.datacenterId << DATACENTER_ID_SHIFT) | (this.workerId << 12) | this.sequence;
    }

    public SnowflakeIdGenerator(long j4, long j8) {
        this.datacenterId = j4;
        this.workerId = j8;
        if (0 > j4 || j4 >= 32) {
            throw new IllegalArgumentException("datacenterId out of range 0..31");
        }
        if (0 > j8 || j8 >= 32) {
            throw new IllegalArgumentException("workerId out of range 0..31");
        }
        this.lastTimestamp = -1L;
    }

    public /* synthetic */ SnowflakeIdGenerator(long j4, long j8, int i8, i iVar) {
        this((i8 & 1) != 0 ? 1L : j4, (i8 & 2) != 0 ? 1L : j8);
    }
}
