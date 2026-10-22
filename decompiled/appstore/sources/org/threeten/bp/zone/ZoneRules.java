package org.threeten.bp.zone;

import ig.d;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import org.threeten.bp.Duration;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.ZoneOffset;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ZoneRules {

    public static final class Fixed extends ZoneRules implements Serializable {
        private static final long serialVersionUID = -8733721350312276297L;
        private final ZoneOffset offset;

        public Fixed(ZoneOffset r10) {
            this.offset = r10;
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof Fixed) == false) goto L10;
            return this.offset.equals(((Fixed) r10).offset);
        L10:
            if ((r10 instanceof StandardZoneRules) == false) goto L18;
            StandardZoneRules r11 = (StandardZoneRules) r10;
            if (r11.isFixedOffset() == false) goto L17;
            if (this.offset.equals(r11.getOffset(Instant.EPOCH)) == false) goto L17;
            return true;
        L17:
            return false;
        L18:
            return false;
        }

        public Duration getDaylightSavings(Instant r10) {
            return Duration.ZERO;
        }

        @Override // org.threeten.bp.zone.ZoneRules
        public ZoneOffset getOffset(Instant r10) {
            return this.offset;
        }

        public ZoneOffset getStandardOffset(Instant r10) {
            return this.offset;
        }

        @Override // org.threeten.bp.zone.ZoneRules
        public ZoneOffsetTransition getTransition(LocalDateTime r10) {
            return null;
        }

        public List<ZoneOffsetTransitionRule> getTransitionRules() {
            return Collections.emptyList();
        }

        public List<ZoneOffsetTransition> getTransitions() {
            return Collections.emptyList();
        }

        @Override // org.threeten.bp.zone.ZoneRules
        public List<ZoneOffset> getValidOffsets(LocalDateTime r10) {
            return Collections.singletonList(this.offset);
        }

        public int hashCode() {
            int r10 = this.offset.hashCode() + 31;
            return ((this.offset.hashCode() + 31) ^ r10) ^ 1;
        }

        @Override // org.threeten.bp.zone.ZoneRules
        public boolean isDaylightSavings(Instant r10) {
            return false;
        }

        @Override // org.threeten.bp.zone.ZoneRules
        public boolean isFixedOffset() {
            return true;
        }

        @Override // org.threeten.bp.zone.ZoneRules
        public boolean isValidOffset(LocalDateTime r10, ZoneOffset r11) {
            return this.offset.equals(r11);
        }

        public ZoneOffsetTransition nextTransition(Instant r10) {
            return null;
        }

        public ZoneOffsetTransition previousTransition(Instant r10) {
            return null;
        }

        public String toString() {
            return "FixedRules:" + this.offset;
        }

        public ZoneOffset getOffset(LocalDateTime r10) {
            return this.offset;
        }
    }

    public ZoneRules() {
    }

    public static ZoneRules of(ZoneOffset r10, ZoneOffset r11, List<ZoneOffsetTransition> r12, List<ZoneOffsetTransition> r13, List<ZoneOffsetTransitionRule> r14) {
        d.h(r10, "baseStandardOffset");
        d.h(r11, "baseWallOffset");
        d.h(r12, "standardOffsetTransitionList");
        d.h(r13, "transitionList");
        d.h(r14, "lastRules");
        return new StandardZoneRules(r10, r11, r12, r13, r14);
    }

    public abstract ZoneOffset getOffset(Instant r10);

    public abstract ZoneOffsetTransition getTransition(LocalDateTime r10);

    public abstract List getValidOffsets(LocalDateTime r10);

    public abstract boolean isDaylightSavings(Instant r10);

    public abstract boolean isFixedOffset();

    public abstract boolean isValidOffset(LocalDateTime r10, ZoneOffset r11);

    public static ZoneRules of(ZoneOffset r10) {
        d.h(r10, "offset");
        return new Fixed(r10);
    }
}
