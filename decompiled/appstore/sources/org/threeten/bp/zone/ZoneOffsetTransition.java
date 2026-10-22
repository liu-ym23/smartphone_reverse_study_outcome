package org.threeten.bp.zone;

import ig.d;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.threeten.bp.Duration;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.ZoneOffset;

/* JADX INFO: loaded from: classes4.dex */
public final class ZoneOffsetTransition implements Comparable<ZoneOffsetTransition>, Serializable {
    private static final long serialVersionUID = -6946044323557704546L;
    private final ZoneOffset offsetAfter;
    private final ZoneOffset offsetBefore;
    private final LocalDateTime transition;

    public ZoneOffsetTransition(LocalDateTime r10, ZoneOffset r11, ZoneOffset r12) {
        this.transition = r10;
        this.offsetBefore = r11;
        this.offsetAfter = r12;
    }

    private int getDurationSeconds() {
        return getOffsetAfter().getTotalSeconds() - getOffsetBefore().getTotalSeconds();
    }

    public static ZoneOffsetTransition of(LocalDateTime r10, ZoneOffset r11, ZoneOffset r12) {
        d.h(r10, "transition");
        d.h(r11, "offsetBefore");
        d.h(r12, "offsetAfter");
        if (r11.equals(r12) == true) goto L11;
        if (r10.getNano() != 0) goto L9;
        return new ZoneOffsetTransition(r10, r11, r12);
    L9:
        throw new IllegalArgumentException("Nano-of-second must be zero");
    L11:
        throw new IllegalArgumentException("Offsets must not be equal");
    }

    public static ZoneOffsetTransition readExternal(DataInput r10) throws IOException {
        long r11 = Ser.readEpochSec(r10);
        ZoneOffset r12 = Ser.readOffset(r10);
        ZoneOffset r13 = Ser.readOffset(r10);
        if (r12.equals(r13) == true) goto L7;
        return new ZoneOffsetTransition(r11, r12, r13);
    L7:
        throw new IllegalArgumentException("Offsets must not be equal");
    }

    private Object writeReplace() {
        return new Ser((byte) 2, this);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(ZoneOffsetTransition r10) {
        return compareTo2(r10);
    }

    public boolean equals(Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof ZoneOffsetTransition) == false) goto L16;
        ZoneOffsetTransition r11 = (ZoneOffsetTransition) r10;
        if (this.transition.equals(r11.transition) == false) goto L15;
        if (this.offsetBefore.equals(r11.offsetBefore) == false) goto L15;
        if (this.offsetAfter.equals(r11.offsetAfter) == false) goto L15;
        return true;
    L15:
        return false;
    L16:
        return false;
    }

    public LocalDateTime getDateTimeAfter() {
        return this.transition.plusSeconds(getDurationSeconds());
    }

    public LocalDateTime getDateTimeBefore() {
        return this.transition;
    }

    public Duration getDuration() {
        return Duration.ofSeconds(getDurationSeconds());
    }

    public Instant getInstant() {
        return this.transition.toInstant(this.offsetBefore);
    }

    public ZoneOffset getOffsetAfter() {
        return this.offsetAfter;
    }

    public ZoneOffset getOffsetBefore() {
        return this.offsetBefore;
    }

    public List<ZoneOffset> getValidOffsets() {
        if (isGap() == false) goto L7;
        return Collections.emptyList();
    L7:
        return Arrays.asList(new ZoneOffset[]{getOffsetBefore(), getOffsetAfter()});
    }

    public int hashCode() {
        int r10 = this.transition.hashCode() ^ this.offsetBefore.hashCode();
        return Integer.rotateLeft(this.offsetAfter.hashCode(), 16) ^ r10;
    }

    public boolean isGap() {
        if (getOffsetAfter().getTotalSeconds() <= getOffsetBefore().getTotalSeconds()) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isOverlap() {
        if (getOffsetAfter().getTotalSeconds() >= getOffsetBefore().getTotalSeconds()) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isValidOffset(ZoneOffset r10) {
        if (isGap() == false) goto L6;
        return false;
    L6:
        if (getOffsetBefore().equals(r10) == false) goto L8;
    L9:
        return true;
    L8:
        if (getOffsetAfter().equals(r10) == true) goto L9;
        return false;
    }

    public long toEpochSecond() {
        return this.transition.toEpochSecond(this.offsetBefore);
    }

    public String toString() {
        StringBuilder r10 = new StringBuilder();
        r10.append("Transition[");
        if (isGap() == false) goto L5;
        String r11 = "Gap";
    L6:
        r10.append(r11);
        r10.append(" at ");
        r10.append(this.transition);
        r10.append(this.offsetBefore);
        r10.append(" to ");
        r10.append(this.offsetAfter);
        r10.append(']');
        return r10.toString();
    L5:
        r11 = "Overlap";
        goto L6
    }

    public void writeExternal(DataOutput r10) throws IOException {
        Ser.writeEpochSec(toEpochSecond(), r10);
        Ser.writeOffset(this.offsetBefore, r10);
        Ser.writeOffset(this.offsetAfter, r10);
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(ZoneOffsetTransition r10) {
        return getInstant().compareTo2(r10.getInstant());
    }

    public ZoneOffsetTransition(long r10, ZoneOffset r11, ZoneOffset r12) {
        this.transition = LocalDateTime.ofEpochSecond(r10, 0, r11);
        this.offsetBefore = r11;
        this.offsetAfter = r12;
    }
}
