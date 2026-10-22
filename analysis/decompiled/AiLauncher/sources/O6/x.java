package O6;

import La.D;
import com.autonavi.aps.amapapi.config.Const;
import java.security.SecureRandom;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u000f¨\u0006\u0012"}, d2 = {"LO6/x;", "", "<init>", "()V", "", Const.INTENT_KEY_APIKEY, "()Ljava/lang/String;", "Ljava/util/UUID;", Const.INTENT_KEY_PKGNAME, "()Ljava/util/UUID;", "Ljava/security/SecureRandom;", "RANDOM", "Ljava/security/SecureRandom;", "Ljava/util/concurrent/atomic/AtomicLong;", "lastTimestamp", "Ljava/util/concurrent/atomic/AtomicLong;", "lastRandA", "lastRandB", "common_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class x {
    public static final x INSTANCE = new x();
    private static final SecureRandom RANDOM = new SecureRandom();
    private static final AtomicLong lastTimestamp = new AtomicLong(0);
    private static final AtomicLong lastRandA = new AtomicLong(0);
    private static final AtomicLong lastRandB = new AtomicLong(0);

    public final String a() {
        String string = b().toString();
        kotlin.jvm.internal.p.h(string, "toString(...)");
        return D.T(string, l.DATE_SEPARATOR, "", false, 4, null);
    }

    public final UUID b() {
        long j10;
        long j11;
        while (true) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            AtomicLong atomicLong = lastTimestamp;
            long j12 = atomicLong.get();
            if (jCurrentTimeMillis <= j12) {
                AtomicLong atomicLong2 = lastRandA;
                long j13 = atomicLong2.get();
                if (j13 < 4095) {
                    long j14 = j13 + 1;
                    if (atomicLong2.compareAndSet(j13, j14)) {
                        AtomicLong atomicLong3 = lastRandB;
                        long j15 = atomicLong3.get();
                        long j16 = 1 + j15;
                        if (atomicLong3.compareAndSet(j15, j16 & 1152921504606846975L)) {
                            j10 = (j12 << 16) | 28672 | j14;
                            j11 = (j16 & 1152921504606846975L) | Long.MIN_VALUE;
                            break;
                        }
                    } else {
                        continue;
                    }
                } else if (atomicLong.compareAndSet(j12, 1 + j12)) {
                    atomicLong2.set(0L);
                }
            } else if (atomicLong.compareAndSet(j12, jCurrentTimeMillis)) {
                SecureRandom secureRandom = RANDOM;
                long jNextLong = secureRandom.nextLong() & 4095;
                long jNextLong2 = secureRandom.nextLong();
                lastRandA.set(jNextLong);
                lastRandB.set(jNextLong2);
                j10 = (jCurrentTimeMillis << 16) | 28672 | jNextLong;
                j11 = (4611686018427387903L & jNextLong2) | Long.MIN_VALUE;
                break;
            }
        }
        return new UUID(j10, j11);
    }
}
