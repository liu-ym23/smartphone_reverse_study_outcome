package z;

import android.os.SystemClock;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u000b\b\u0000\u0018\u0000 \f2\u00020\u0001:\u0001\u0007B\u0019\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010\b\u001a\u0004\b\u0007\u0010\n¨\u0006\r"}, d2 = {"Lz/s;", "", "", "realtimeNsToUtcMs", "realtimeNsToMonotonicNs", "<init>", "(JJ)V", Const.INTENT_KEY_APIKEY, "J", "getRealtimeNsToUtcMs", "()J", Const.INTENT_KEY_PKGNAME, "c", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class s {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final long realtimeNsToUtcMs;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final long realtimeNsToMonotonicNs;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0003¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0003¢\u0006\u0004\b\n\u0010\tR\u0014\u0010\u000b\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\fR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lz/s$a;", "", "<init>", "()V", "Lz/s;", Const.INTENT_KEY_APIKEY, "()Lz/s;", "", "c", "()J", Const.INTENT_KEY_PKGNAME, "NS_PER_MS", "J", "NS_PER_MS_X_2", "", "MEASUREMENT_ITERATIONS", "I", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: z.s$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final s a() {
            return new s(c(), b(), null);
        }

        public final long b() {
            long j10 = Long.MAX_VALUE;
            long j11 = 0;
            for (int i10 = 0; i10 < 3; i10++) {
                long jNanoTime = System.nanoTime();
                long jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
                long jNanoTime2 = System.nanoTime();
                long j12 = jNanoTime2 - jNanoTime;
                if (j12 < j10) {
                    j11 = jElapsedRealtimeNanos - ((jNanoTime + jNanoTime2) / 2);
                    j10 = j12;
                }
            }
            return j11;
        }

        public final long c() {
            long j10 = Long.MAX_VALUE;
            long j11 = 0;
            for (int i10 = 0; i10 < 3; i10++) {
                long jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
                long jCurrentTimeMillis = System.currentTimeMillis();
                long jElapsedRealtimeNanos2 = SystemClock.elapsedRealtimeNanos();
                long j12 = jElapsedRealtimeNanos2 - jElapsedRealtimeNanos;
                if (j12 < j10) {
                    j11 = ((jElapsedRealtimeNanos + jElapsedRealtimeNanos2) / 2000000) - jCurrentTimeMillis;
                    j10 = j12;
                }
            }
            return j11;
        }

        public Companion() {
        }
    }

    public /* synthetic */ s(long j10, long j11, kotlin.jvm.internal.i iVar) {
        this(j10, j11);
    }

    /* renamed from: a, reason: from getter */
    public final long getRealtimeNsToMonotonicNs() {
        return this.realtimeNsToMonotonicNs;
    }

    public s(long j10, long j11) {
        this.realtimeNsToUtcMs = j10;
        this.realtimeNsToMonotonicNs = j11;
    }
}
