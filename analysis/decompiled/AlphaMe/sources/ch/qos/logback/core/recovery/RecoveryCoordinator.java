package ch.qos.logback.core.recovery;

/* loaded from: classes.dex */
public class RecoveryCoordinator {
    static long BACKOFF_COEFFICIENT_MAX = 327680;
    public static final long BACKOFF_COEFFICIENT_MIN = 20;
    private static long UNSET = -1;
    private long backOffCoefficient = 20;
    private long currentTime = UNSET;
    long next = System.currentTimeMillis() + getBackoffCoefficient();

    private long getBackoffCoefficient() {
        long j4 = this.backOffCoefficient;
        if (j4 < BACKOFF_COEFFICIENT_MAX) {
            this.backOffCoefficient = 4 * j4;
        }
        return j4;
    }

    private long getCurrentTime() {
        long j4 = this.currentTime;
        return j4 != UNSET ? j4 : System.currentTimeMillis();
    }

    public boolean isTooSoon() {
        long currentTime = getCurrentTime();
        if (currentTime <= this.next) {
            return true;
        }
        this.next = currentTime + getBackoffCoefficient();
        return false;
    }

    public void setCurrentTime(long j4) {
        this.currentTime = j4;
    }
}
