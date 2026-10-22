package org.threeten.bp.zone;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import org.threeten.bp.Duration;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.jdk8.Jdk8Methods;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ZoneRules {

    static final class Fixed extends ZoneRules implements Serializable {
        private static final long serialVersionUID = -8733721350312276297L;
        private final ZoneOffset offset;

        @Override // org.threeten.bp.zone.ZoneRules
        public ZoneOffsetTransition getTransition(LocalDateTime r1) {
            return null;
        }

        @Override // org.threeten.bp.zone.ZoneRules
        public boolean isDaylightSavings(Instant r1) {
            return false;
        }

        @Override // org.threeten.bp.zone.ZoneRules
        public boolean isFixedOffset() {
            return true;
        }

        @Override // org.threeten.bp.zone.ZoneRules
        public ZoneOffsetTransition nextTransition(Instant r1) {
            return null;
        }

        @Override // org.threeten.bp.zone.ZoneRules
        public ZoneOffsetTransition previousTransition(Instant r1) {
            return null;
        }

        Fixed(ZoneOffset r1) {
            this.offset = r1;
        }

        @Override // org.threeten.bp.zone.ZoneRules
        public ZoneOffset getOffset(Instant r1) {
            return this.offset;
        }

        @Override // org.threeten.bp.zone.ZoneRules
        public ZoneOffset getOffset(LocalDateTime r1) {
            return this.offset;
        }

        @Override // org.threeten.bp.zone.ZoneRules
        public List<ZoneOffset> getValidOffsets(LocalDateTime r1) {
            return Collections.singletonList(this.offset);
        }

        @Override // org.threeten.bp.zone.ZoneRules
        public boolean isValidOffset(LocalDateTime r1, ZoneOffset r2) {
            return this.offset.equals(r2);
        }

        @Override // org.threeten.bp.zone.ZoneRules
        public ZoneOffset getStandardOffset(Instant r1) {
            return this.offset;
        }

        @Override // org.threeten.bp.zone.ZoneRules
        public Duration getDaylightSavings(Instant r1) {
            return Duration.ZERO;
        }

        @Override // org.threeten.bp.zone.ZoneRules
        public List<ZoneOffsetTransition> getTransitions() {
            return Collections.emptyList();
        }

        @Override // org.threeten.bp.zone.ZoneRules
        public List<ZoneOffsetTransitionRule> getTransitionRules() {
            return Collections.emptyList();
        }

        @Override // org.threeten.bp.zone.ZoneRules
        public boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof Fixed) == false) goto L10;
            return this.offset.equals(((Fixed) r4).offset);
        L10:
            if ((r4 instanceof StandardZoneRules) == false) goto L18;
            StandardZoneRules r5 = (StandardZoneRules) r4;
            if (r5.isFixedOffset() == false) goto L17;
            if (this.offset.equals(r5.getOffset(Instant.EPOCH)) == false) goto L17;
            return true;
        L17:
            return false;
        L18:
            return false;
        }

        @Override // org.threeten.bp.zone.ZoneRules
        public int hashCode() {
            int r0 = ((this.offset.hashCode() + 31) ^ 1) ^ 1;
            return ((this.offset.hashCode() + 31) ^ r0) ^ 1;
        }

        public String toString() {
            return "FixedRules:" + this.offset;
        }
    }

    public abstract boolean equals(Object r1);

    public abstract Duration getDaylightSavings(Instant r1);

    public abstract ZoneOffset getOffset(Instant r1);

    public abstract ZoneOffset getOffset(LocalDateTime r1);

    public abstract ZoneOffset getStandardOffset(Instant r1);

    public abstract ZoneOffsetTransition getTransition(LocalDateTime r1);

    public abstract List<ZoneOffsetTransitionRule> getTransitionRules();

    public abstract List<ZoneOffsetTransition> getTransitions();

    public abstract List<ZoneOffset> getValidOffsets(LocalDateTime r1);

    public abstract int hashCode();

    public abstract boolean isDaylightSavings(Instant r1);

    public abstract boolean isFixedOffset();

    public abstract boolean isValidOffset(LocalDateTime r1, ZoneOffset r2);

    public abstract ZoneOffsetTransition nextTransition(Instant r1);

    public abstract ZoneOffsetTransition previousTransition(Instant r1);

    public static ZoneRules of(ZoneOffset r7, ZoneOffset r8, List<ZoneOffsetTransition> r9, List<ZoneOffsetTransition> r10, List<ZoneOffsetTransitionRule> r11) {
        Jdk8Methods.requireNonNull(r7, "baseStandardOffset");
        Jdk8Methods.requireNonNull(r8, "baseWallOffset");
        Jdk8Methods.requireNonNull(r9, "standardOffsetTransitionList");
        Jdk8Methods.requireNonNull(r10, "transitionList");
        Jdk8Methods.requireNonNull(r11, "lastRules");
        return new StandardZoneRules(r7, r8, r9, r10, r11);
    }

    public static ZoneRules of(ZoneOffset r1) {
        Jdk8Methods.requireNonNull(r1, "offset");
        return new Fixed(r1);
    }

    ZoneRules() {
    }
}
