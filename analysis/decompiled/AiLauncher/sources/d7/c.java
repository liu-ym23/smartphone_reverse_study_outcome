package d7;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\r\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\fR\u0016\u0010\t\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\f¨\u0006\u000f"}, d2 = {"Ld7/c;", "", "<init>", "()V", "", "workerId", "datacenterId", Const.INTENT_KEY_APIKEY, "(JJ)J", "lastTimestamp", Const.INTENT_KEY_PKGNAME, "(J)J", "J", "sequence", "c", "database_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class c {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static long sequence;

    /* renamed from: a, reason: collision with root package name */
    public static final c f32138a = new c();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public static long lastTimestamp = -1;

    public final long a(long workerId, long datacenterId) {
        if (workerId > 31) {
            throw new IllegalArgumentException("workerId must be <= 31");
        }
        if (datacenterId > 31) {
            throw new IllegalArgumentException("datacenterId must be <= 31");
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j10 = lastTimestamp;
        if (jCurrentTimeMillis < j10) {
            throw new RuntimeException("Clock moved backwards");
        }
        if (j10 == jCurrentTimeMillis) {
            long j11 = (sequence + 1) & 4095;
            sequence = j11;
            if (j11 == 0) {
                jCurrentTimeMillis = b(j10);
            }
        } else {
            sequence = 0L;
        }
        lastTimestamp = jCurrentTimeMillis;
        return (workerId << 12) | (datacenterId << 17) | ((jCurrentTimeMillis - 1609459200000L) << 22) | sequence;
    }

    public final long b(long lastTimestamp2) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        while (jCurrentTimeMillis <= lastTimestamp2) {
            jCurrentTimeMillis = System.currentTimeMillis();
        }
        return jCurrentTimeMillis;
    }
}
