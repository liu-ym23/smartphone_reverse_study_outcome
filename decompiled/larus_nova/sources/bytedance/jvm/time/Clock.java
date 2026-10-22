package bytedance.jvm.time;

import android.os.Build;
import com.ss.ttm.player.C;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public abstract class Clock {

    /* JADX INFO: loaded from: classes28.dex */
    public static final class FixedClock extends Clock implements Serializable {
        private static final long serialVersionUID = 7430389292664866958L;
        private final Instant instant;
        private final ZoneId zone;

        @Override // bytedance.jvm.time.Clock
        public int hashCode() {
            return this.instant.hashCode() ^ this.zone.hashCode();
        }

        @Override // bytedance.jvm.time.Clock
        public long millis() {
            return this.instant.toEpochMilli();
        }

        public String toString() {
            return "FixedClock[" + this.instant + "," + this.zone + "]";
        }

        @Override // bytedance.jvm.time.Clock
        public ZoneId getZone() {
            return this.zone;
        }

        @Override // bytedance.jvm.time.Clock
        public Instant instant() {
            return this.instant;
        }

        @Override // bytedance.jvm.time.Clock
        public boolean equals(Object r100) {
            if ((r100 instanceof FixedClock) == false) goto L10;
            FixedClock r101 = (FixedClock) r100;
            if (this.instant.equals(r101.instant) == true) goto L7;
            return false;
        L7:
            if (this.zone.equals(r101.zone) == false) goto L12;
            return true;
        L12:
            return false;
        L10:
            return false;
        }

        @Override // bytedance.jvm.time.Clock
        public Clock withZone(ZoneId r100) {
            if (r100.equals(this.zone) == false) goto L6;
            return this;
        L6:
            return new FixedClock(this.instant, r100);
        }

        public FixedClock(Instant r100, ZoneId r101) {
            this.instant = r100;
            this.zone = r101;
        }
    }

    /* JADX INFO: loaded from: classes28.dex */
    public static final class OffsetClock extends Clock implements Serializable {
        private static final long serialVersionUID = 2007484719125426256L;
        private final Clock baseClock;
        private final Duration offset;

        @Override // bytedance.jvm.time.Clock
        public ZoneId getZone() {
            return this.baseClock.getZone();
        }

        @Override // bytedance.jvm.time.Clock
        public int hashCode() {
            return this.baseClock.hashCode() ^ this.offset.hashCode();
        }

        @Override // bytedance.jvm.time.Clock
        public Instant instant() {
            return this.baseClock.instant().plus(this.offset);
        }

        @Override // bytedance.jvm.time.Clock
        public long millis() {
            long r100 = this.baseClock.millis();
            long r101 = this.offset.toMillis();
            long r102 = r100 + r101;
            boolean r103 = false;
            if ((r101 ^ r100) >= 0) goto L5;
            boolean r104 = true;
        L7:
            if ((r100 ^ r102) < 0) goto L10;
            r103 = true;
        L10:
            if ((r104 | r103) == false) goto L13;
            return r102;
        L13:
            throw new ArithmeticException();
        L5:
            r104 = false;
            goto L7
        }

        public String toString() {
            return "OffsetClock[" + this.baseClock + "," + this.offset + "]";
        }

        @Override // bytedance.jvm.time.Clock
        public boolean equals(Object r100) {
            if ((r100 instanceof OffsetClock) == false) goto L10;
            OffsetClock r101 = (OffsetClock) r100;
            if (this.baseClock.equals(r101.baseClock) == true) goto L7;
            return false;
        L7:
            if (this.offset.equals(r101.offset) == false) goto L12;
            return true;
        L12:
            return false;
        L10:
            return false;
        }

        @Override // bytedance.jvm.time.Clock
        public Clock withZone(ZoneId r100) {
            if (r100.equals(this.baseClock.getZone()) == false) goto L6;
            return this;
        L6:
            return new OffsetClock(this.baseClock.withZone(r100), this.offset);
        }

        public OffsetClock(Clock r100, Duration r101) {
            this.baseClock = r100;
            this.offset = r101;
        }
    }

    public static final class SystemClock extends Clock implements Serializable {
        static final SystemClock UTC = null;
        private static final long serialVersionUID = 6740630888130243051L;
        private final ZoneId zone;

        @Override // bytedance.jvm.time.Clock
        public int hashCode() {
            return this.zone.hashCode() + 1;
        }

        @Override // bytedance.jvm.time.Clock
        public Instant instant() {
            if (Build.VERSION.SDK_INT < 26) goto L6;
            java.time.Instant r100 = java.time.Clock.systemUTC().instant();
            return Instant.ofEpochSecond(r100.getEpochSecond(), r100.getNano());
        L6:
            long r101 = System.currentTimeMillis();
            long r102 = android.os.SystemClock.elapsedRealtimeNanos() - (android.os.SystemClock.elapsedRealtime() * 1000000);
            long r103 = 1000;
            long r104 = r101 / r103;
            long r110 = 0;
            if ((r101 - (r103 * r104)) != 0) goto L10;
        L12:
            long r105 = r101 % r103;
            if (r105 != 0) goto L16;
            r105 = 0;
        L19:
            long r106 = ((long) (((int) r105) * 1000000)) + r102;
            if (r106 < C.NANOS_PER_SECOND) goto L22;
            long r107 = 1000000000;
            long r108 = r106 / r107;
            if ((r106 - (r107 * r108)) != 0) goto L27;
        L29:
            long r109 = r106 % r107;
            if (r109 == 0) goto L38;
            if ((((r106 ^ r107) >> 63) | 1) > 0) goto L36;
            r109 = r109 + r107;
        L36:
            r110 = r109;
        L38:
            return Instant.ofEpochSecond(r104 + r108, (int) r110);
        L27:
            if ((((r106 ^ r107) >> 63) | 1) >= 0) goto L29;
            r108 = r108 - 1;
            goto L29
        L22:
            return Instant.ofEpochSecond(r104, r106);
        L16:
            if ((((r101 ^ r103) >> 63) | 1) > 0) goto L19;
            r105 = r105 + r103;
            goto L19
        L10:
            if ((((r101 ^ r103) >> 63) | 1) >= 0) goto L12;
            r104 = r104 - 1;
            goto L12
        }

        public String toString() {
            return "SystemClock[" + this.zone + "]";
        }

        static {
            long r100 = System.currentTimeMillis() / 1000;
            UTC = new SystemClock(ZoneOffset.UTC);
        }

        @Override // bytedance.jvm.time.Clock
        public long millis() {
            return System.currentTimeMillis();
        }

        @Override // bytedance.jvm.time.Clock
        public ZoneId getZone() {
            return this.zone;
        }

        public SystemClock(ZoneId r100) {
            this.zone = r100;
        }

        private void readObject(ObjectInputStream r100) throws IOException, ClassNotFoundException {
            r100.defaultReadObject();
        }

        @Override // bytedance.jvm.time.Clock
        public boolean equals(Object r100) {
            if ((r100 instanceof SystemClock) == true) goto L5;
            return false;
        L5:
            return this.zone.equals(((SystemClock) r100).zone);
        }

        @Override // bytedance.jvm.time.Clock
        public Clock withZone(ZoneId r100) {
            if (r100.equals(this.zone) == false) goto L6;
            return this;
        L6:
            return new SystemClock(r100);
        }
    }

    /* JADX INFO: loaded from: classes28.dex */
    public static final class TickClock extends Clock implements Serializable {
        private static final long serialVersionUID = 6504659149906368850L;
        private final Clock baseClock;
        private final long tickNanos;

        @Override // bytedance.jvm.time.Clock
        public ZoneId getZone() {
            return this.baseClock.getZone();
        }

        @Override // bytedance.jvm.time.Clock
        public int hashCode() {
            int r100 = this.baseClock.hashCode();
            long r101 = this.tickNanos;
            return r100 ^ ((int) (r101 ^ (r101 >>> 32)));
        }

        @Override // bytedance.jvm.time.Clock
        public Instant instant() {
            long r100 = 0;
            if ((this.tickNanos % 1000000) != 0) goto L14;
            long r101 = this.baseClock.millis();
            long r102 = this.tickNanos / 1000000;
            long r103 = r101 % r102;
            if (r103 == 0) goto L13;
            if ((1 | ((r101 ^ r102) >> 63)) > 0) goto L11;
            r103 = r103 + r102;
        L11:
            r100 = r103;
        L13:
            return Instant.ofEpochMilli(r101 - r100);
        L14:
            Instant r104 = this.baseClock.instant();
            long r105 = r104.getNano();
            long r106 = this.tickNanos;
            long r110 = r105 % r106;
            if (r110 == 0) goto L23;
            if ((((r105 ^ r106) >> 63) | 1) > 0) goto L21;
            r110 = r110 + r106;
        L21:
            r100 = r110;
        L23:
            return r104.minusNanos(r100);
        }

        @Override // bytedance.jvm.time.Clock
        public long millis() {
            long r100 = this.baseClock.millis();
            long r101 = this.tickNanos / 1000000;
            long r102 = r100 % r101;
            long r103 = 0;
            if (r102 == 0) goto L11;
            if ((((r100 ^ r101) >> 63) | 1) > 0) goto L9;
            r102 = r102 + r101;
        L9:
            r103 = r102;
        L11:
            return r100 - r103;
        }

        public String toString() {
            return "TickClock[" + this.baseClock + "," + Duration.ofNanos(this.tickNanos) + "]";
        }

        @Override // bytedance.jvm.time.Clock
        public boolean equals(Object r100) {
            if ((r100 instanceof TickClock) == false) goto L10;
            TickClock r101 = (TickClock) r100;
            if (this.baseClock.equals(r101.baseClock) == true) goto L7;
            return false;
        L7:
            if (this.tickNanos != r101.tickNanos) goto L12;
            return true;
        L12:
            return false;
        L10:
            return false;
        }

        @Override // bytedance.jvm.time.Clock
        public Clock withZone(ZoneId r100) {
            if (r100.equals(this.baseClock.getZone()) == false) goto L6;
            return this;
        L6:
            return new TickClock(this.baseClock.withZone(r100), this.tickNanos);
        }

        public TickClock(Clock r100, long r101) {
            this.baseClock = r100;
            this.tickNanos = r101;
        }
    }

    public abstract ZoneId getZone();

    public abstract Instant instant();

    public abstract Clock withZone(ZoneId r100);

    public static Clock systemDefaultZone() {
        return new SystemClock(ZoneId.systemDefault());
    }

    public int hashCode() {
        return super.hashCode();
    }

    public long millis() {
        return instant().toEpochMilli();
    }

    public Clock() {
    }

    public static Clock systemUTC() {
        return SystemClock.UTC;
    }

    public static Clock system(ZoneId r100) {
        Objects.requireNonNull(r100, "zone");
        if (r100 != ZoneOffset.UTC) goto L7;
        return SystemClock.UTC;
    L7:
        return new SystemClock(r100);
    }

    public static Clock tickMillis(ZoneId r100) {
        return new TickClock(system(r100), 1000000);
    }

    public static Clock tickMinutes(ZoneId r100) {
        return new TickClock(system(r100), 60000000000L);
    }

    public static Clock tickSeconds(ZoneId r100) {
        return new TickClock(system(r100), C.NANOS_PER_SECOND);
    }

    public boolean equals(Object r100) {
        return super.equals(r100);
    }

    public static Clock fixed(Instant r100, ZoneId r101) {
        Objects.requireNonNull(r100, "fixedInstant");
        Objects.requireNonNull(r101, "zone");
        return new FixedClock(r100, r101);
    }

    public static Clock offset(Clock r100, Duration r101) {
        Objects.requireNonNull(r100, "baseClock");
        Objects.requireNonNull(r101, "offsetDuration");
        if (r101.equals(Duration.ZERO) == false) goto L6;
        return r100;
    L6:
        return new OffsetClock(r100, r101);
    }

    public static Clock tick(Clock r100, Duration r101) {
        Objects.requireNonNull(r100, "baseClock");
        Objects.requireNonNull(r101, "tickDuration");
        if (r101.isNegative() == true) goto L17;
        long r102 = r101.toNanos();
        if ((r102 % 1000000) == 0) goto L10;
        if ((C.NANOS_PER_SECOND % r102) == 0) goto L10;
        throw new IllegalArgumentException("Invalid tick duration");
    L10:
        if (r102 > 1) goto L13;
        return r100;
    L13:
        return new TickClock(r100, r102);
    L17:
        throw new IllegalArgumentException("Tick duration must not be negative");
    }
}
