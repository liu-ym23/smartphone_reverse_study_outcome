package org.threeten.bp;

import com.bytedance.apm.battery.config.BatteryFactorConfig;
import ig.d;
import java.io.Serializable;

/* JADX INFO: loaded from: classes4.dex */
public abstract class Clock {

    public static final class FixedClock extends Clock implements Serializable {
        private static final long serialVersionUID = 7430389292664866958L;
        private final Instant instant;
        private final ZoneId zone;

        public FixedClock(Instant r10, ZoneId r11) {
            this.instant = r10;
            this.zone = r11;
        }

        @Override // org.threeten.bp.Clock
        public boolean equals(Object r10) {
            if ((r10 instanceof FixedClock) == false) goto L10;
            FixedClock r11 = (FixedClock) r10;
            if (this.instant.equals(r11.instant) == true) goto L7;
            return false;
        L7:
            if (this.zone.equals(r11.zone) == false) goto L12;
            return true;
        L12:
            return false;
        L10:
            return false;
        }

        @Override // org.threeten.bp.Clock
        public ZoneId getZone() {
            return this.zone;
        }

        @Override // org.threeten.bp.Clock
        public int hashCode() {
            int r10 = this.instant.hashCode();
            return this.zone.hashCode() ^ r10;
        }

        @Override // org.threeten.bp.Clock
        public Instant instant() {
            return this.instant;
        }

        @Override // org.threeten.bp.Clock
        public long millis() {
            return this.instant.toEpochMilli();
        }

        public String toString() {
            return "FixedClock[" + this.instant + "," + this.zone + "]";
        }

        @Override // org.threeten.bp.Clock
        public Clock withZone(ZoneId r10) {
            if (r10.equals(this.zone) == false) goto L6;
            return this;
        L6:
            return new FixedClock(this.instant, r10);
        }
    }

    public static final class OffsetClock extends Clock implements Serializable {
        private static final long serialVersionUID = 2007484719125426256L;
        private final Clock baseClock;
        private final Duration offset;

        public OffsetClock(Clock r10, Duration r11) {
            this.baseClock = r10;
            this.offset = r11;
        }

        @Override // org.threeten.bp.Clock
        public boolean equals(Object r10) {
            if ((r10 instanceof OffsetClock) == false) goto L10;
            OffsetClock r11 = (OffsetClock) r10;
            if (this.baseClock.equals(r11.baseClock) == true) goto L7;
            return false;
        L7:
            if (this.offset.equals(r11.offset) == false) goto L12;
            return true;
        L12:
            return false;
        L10:
            return false;
        }

        @Override // org.threeten.bp.Clock
        public ZoneId getZone() {
            return this.baseClock.getZone();
        }

        @Override // org.threeten.bp.Clock
        public int hashCode() {
            int r10 = this.baseClock.hashCode();
            return this.offset.hashCode() ^ r10;
        }

        @Override // org.threeten.bp.Clock
        public Instant instant() {
            return this.baseClock.instant().plus(this.offset);
        }

        @Override // org.threeten.bp.Clock
        public long millis() {
            return d.j(this.baseClock.millis(), this.offset.toMillis());
        }

        public String toString() {
            return "OffsetClock[" + this.baseClock + "," + this.offset + "]";
        }

        @Override // org.threeten.bp.Clock
        public Clock withZone(ZoneId r10) {
            if (r10.equals(this.baseClock.getZone()) == false) goto L6;
            return this;
        L6:
            return new OffsetClock(this.baseClock.withZone(r10), this.offset);
        }
    }

    public static final class SystemClock extends Clock implements Serializable {
        private static final long serialVersionUID = 6740630888130243051L;
        private final ZoneId zone;

        public SystemClock(ZoneId r10) {
            this.zone = r10;
        }

        @Override // org.threeten.bp.Clock
        public boolean equals(Object r10) {
            if ((r10 instanceof SystemClock) == true) goto L5;
            return false;
        L5:
            return this.zone.equals(((SystemClock) r10).zone);
        }

        @Override // org.threeten.bp.Clock
        public ZoneId getZone() {
            return this.zone;
        }

        @Override // org.threeten.bp.Clock
        public int hashCode() {
            return this.zone.hashCode() + 1;
        }

        @Override // org.threeten.bp.Clock
        public Instant instant() {
            return Instant.ofEpochMilli(millis());
        }

        @Override // org.threeten.bp.Clock
        public long millis() {
            return System.currentTimeMillis();
        }

        public String toString() {
            return "SystemClock[" + this.zone + "]";
        }

        @Override // org.threeten.bp.Clock
        public Clock withZone(ZoneId r10) {
            if (r10.equals(this.zone) == false) goto L6;
            return this;
        L6:
            return new SystemClock(r10);
        }
    }

    public static final class TickClock extends Clock implements Serializable {
        private static final long serialVersionUID = 6504659149906368850L;
        private final Clock baseClock;
        private final long tickNanos;

        public TickClock(Clock r10, long r11) {
            this.baseClock = r10;
            this.tickNanos = r11;
        }

        @Override // org.threeten.bp.Clock
        public boolean equals(Object r10) {
            if ((r10 instanceof TickClock) == false) goto L10;
            TickClock r11 = (TickClock) r10;
            if (this.baseClock.equals(r11.baseClock) == true) goto L7;
            return false;
        L7:
            if (this.tickNanos != r11.tickNanos) goto L12;
            return true;
        L12:
            return false;
        L10:
            return false;
        }

        @Override // org.threeten.bp.Clock
        public ZoneId getZone() {
            return this.baseClock.getZone();
        }

        @Override // org.threeten.bp.Clock
        public int hashCode() {
            int r10 = this.baseClock.hashCode();
            long r11 = this.tickNanos;
            return ((int) (r11 ^ (r11 >>> 32))) ^ r10;
        }

        @Override // org.threeten.bp.Clock
        public Instant instant() {
            if ((this.tickNanos % BatteryFactorConfig.WIFI_BPS) != 0) goto L6;
            long r10 = this.baseClock.millis();
            return Instant.ofEpochMilli(r10 - d.g(r10, this.tickNanos / BatteryFactorConfig.WIFI_BPS));
        L6:
            Instant r11 = this.baseClock.instant();
            return r11.minusNanos(d.g(r11.getNano(), this.tickNanos));
        }

        @Override // org.threeten.bp.Clock
        public long millis() {
            long r10 = this.baseClock.millis();
            return r10 - d.g(r10, this.tickNanos / BatteryFactorConfig.WIFI_BPS);
        }

        public String toString() {
            return "TickClock[" + this.baseClock + "," + Duration.ofNanos(this.tickNanos) + "]";
        }

        @Override // org.threeten.bp.Clock
        public Clock withZone(ZoneId r10) {
            if (r10.equals(this.baseClock.getZone()) == false) goto L6;
            return this;
        L6:
            return new TickClock(this.baseClock.withZone(r10), this.tickNanos);
        }
    }

    public Clock() {
    }

    public static Clock fixed(Instant r10, ZoneId r11) {
        d.h(r10, "fixedInstant");
        d.h(r11, "zone");
        return new FixedClock(r10, r11);
    }

    public static Clock offset(Clock r10, Duration r11) {
        d.h(r10, "baseClock");
        d.h(r11, "offsetDuration");
        if (r11.equals(Duration.ZERO) == false) goto L6;
        return r10;
    L6:
        return new OffsetClock(r10, r11);
    }

    public static Clock system(ZoneId r10) {
        d.h(r10, "zone");
        return new SystemClock(r10);
    }

    public static Clock systemDefaultZone() {
        return new SystemClock(ZoneId.systemDefault());
    }

    public static Clock systemUTC() {
        return new SystemClock(ZoneOffset.UTC);
    }

    public static Clock tick(Clock r10, Duration r11) {
        d.h(r10, "baseClock");
        d.h(r11, "tickDuration");
        if (r11.isNegative() == true) goto L17;
        long r12 = r11.toNanos();
        if ((r12 % BatteryFactorConfig.WIFI_BPS) == 0) goto L10;
        if ((1000000000 % r12) == 0) goto L10;
        throw new IllegalArgumentException("Invalid tick duration");
    L10:
        if (r12 > 1) goto L13;
        return r10;
    L13:
        return new TickClock(r10, r12);
    L17:
        throw new IllegalArgumentException("Tick duration must not be negative");
    }

    public static Clock tickMinutes(ZoneId r10) {
        return new TickClock(system(r10), 60000000000L);
    }

    public static Clock tickSeconds(ZoneId r10) {
        return new TickClock(system(r10), 1000000000);
    }

    public abstract boolean equals(Object r10);

    public abstract ZoneId getZone();

    public abstract int hashCode();

    public abstract Instant instant();

    public abstract long millis();

    public abstract Clock withZone(ZoneId r10);
}
