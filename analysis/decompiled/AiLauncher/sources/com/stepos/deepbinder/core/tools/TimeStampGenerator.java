package com.stepos.deepbinder.core.tools;

import android.os.Process;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\r\u001a\u00020\u0005J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005H\u0002J\b\u0010\u0010\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/stepos/deepbinder/core/tools/TimeStampGenerator;", "", "<init>", "()V", "lastTimestamp", "", "pid", "", "PID_BITS", "sequence", "SEQUENCE_BITS", "SEQUENCE_MASK", "START_TIME", "getTimeStamp", "blockTillNextMillis", "lastTime", "currentTimeMillis", "deepbinder-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TimeStampGenerator {
    private static final long PID_BITS = 40;
    private static final long SEQUENCE_BITS = 2;
    private static final long SEQUENCE_MASK = 3;
    private static final long START_TIME = 1498608000000L;
    private static long sequence;
    public static final TimeStampGenerator INSTANCE = new TimeStampGenerator();
    private static long lastTimestamp = -1;
    private static final int pid = Process.myPid();

    private TimeStampGenerator() {
    }

    private final long blockTillNextMillis(long lastTime) {
        long jCurrentTimeMillis = currentTimeMillis();
        while (jCurrentTimeMillis <= lastTime) {
            jCurrentTimeMillis = currentTimeMillis();
        }
        return jCurrentTimeMillis;
    }

    private final long currentTimeMillis() {
        return System.currentTimeMillis();
    }

    public final synchronized long getTimeStamp() {
        long jCurrentTimeMillis;
        try {
            jCurrentTimeMillis = currentTimeMillis();
            if (jCurrentTimeMillis < lastTimestamp) {
                lastTimestamp = jCurrentTimeMillis;
            }
            if (lastTimestamp == jCurrentTimeMillis) {
                long j10 = (sequence + 1) & 3;
                sequence = j10;
                if (j10 == 0) {
                    jCurrentTimeMillis = blockTillNextMillis(jCurrentTimeMillis);
                }
            } else {
                sequence = 0L;
            }
            lastTimestamp = jCurrentTimeMillis;
        } catch (Throwable th) {
            throw th;
        }
        return ((jCurrentTimeMillis - START_TIME) << 2) | (pid << PID_BITS) | sequence;
    }
}
