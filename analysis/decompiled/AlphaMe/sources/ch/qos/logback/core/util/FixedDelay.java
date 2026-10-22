package ch.qos.logback.core.util;

/* loaded from: classes.dex */
public class FixedDelay implements DelayStrategy {
    private long nextDelay;
    private final long subsequentDelay;

    public FixedDelay(long j4, long j5) {
        new String();
        this.nextDelay = j4;
        this.subsequentDelay = j5;
    }

    @Override // ch.qos.logback.core.util.DelayStrategy
    public long nextDelay() {
        long j4 = this.nextDelay;
        this.nextDelay = this.subsequentDelay;
        return j4;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public FixedDelay(int i4) {
        long j4 = i4;
        this(j4, j4);
    }
}
