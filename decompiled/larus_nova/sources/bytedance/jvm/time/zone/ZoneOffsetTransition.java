package bytedance.jvm.time.zone;

import bytedance.jvm.time.Duration;
import bytedance.jvm.time.Instant;
import bytedance.jvm.time.LocalDateTime;
import bytedance.jvm.time.ZoneOffset;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes28.dex */
public final class ZoneOffsetTransition implements Comparable<ZoneOffsetTransition>, Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final long serialVersionUID = -6946044323557704546L;
    private final long epochSecond;
    private final ZoneOffset offsetAfter;
    private final ZoneOffset offsetBefore;
    private final LocalDateTime transition;

    private Object writeReplace() {
        return new Ser((byte) 2, this);
    }

    public LocalDateTime getDateTimeAfter() {
        return this.transition.plusSeconds(getOffsetAfter().getTotalSeconds() - getOffsetBefore().getTotalSeconds());
    }

    public Instant getInstant() {
        return Instant.ofEpochSecond(this.epochSecond);
    }

    public int hashCode() {
        return (this.transition.hashCode() ^ this.offsetBefore.hashCode()) ^ Integer.rotateLeft(this.offsetAfter.hashCode(), 16);
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("Transition[");
        if (isGap() == false) goto L5;
        String r101 = "Gap";
    L6:
        r100.append(r101);
        r100.append(" at ");
        r100.append(this.transition);
        r100.append(this.offsetBefore);
        r100.append(" to ");
        r100.append(this.offsetAfter);
        r100.append(']');
        return r100.toString();
    L5:
        r101 = "Overlap";
        goto L6
    }

    public Duration getDuration() {
        return Duration.ofSeconds(getOffsetAfter().getTotalSeconds() - getOffsetBefore().getTotalSeconds());
    }

    public List<ZoneOffset> getValidOffsets() {
        if (isGap() == true) goto L5;
        int r100 = 0;
        Object[] r101 = {getOffsetBefore(), getOffsetAfter()};
        ArrayList r102 = new ArrayList(2);
    L7:
        if (r100 >= 2) goto L10;
        Object r103 = r101[r100];
        Objects.requireNonNull(r103);
        r102.add(r103);
        r100 = r100 + 1;
        goto L7
    L10:
        return Collections.unmodifiableList(r102);
    L5:
        return Collections.emptyList();
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

    static {
    }

    public LocalDateTime getDateTimeBefore() {
        return this.transition;
    }

    public ZoneOffset getOffsetAfter() {
        return this.offsetAfter;
    }

    public ZoneOffset getOffsetBefore() {
        return this.offsetBefore;
    }

    public long toEpochSecond() {
        return this.epochSecond;
    }

    public static ZoneOffsetTransition readExternal(DataInput r100) throws IOException {
        long r101 = Ser.readEpochSec(r100);
        ZoneOffset r102 = Ser.readOffset(r100);
        ZoneOffset r103 = Ser.readOffset(r100);
        if (r102.equals(r103) == true) goto L7;
        return new ZoneOffsetTransition(r101, r102, r103);
    L7:
        throw new IllegalArgumentException("Offsets must not be equal");
    }

    private void readObject(ObjectInputStream r100) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(ZoneOffsetTransition r100) {
        return Long.compare(this.epochSecond, r100.epochSecond);
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof ZoneOffsetTransition) == false) goto L16;
        ZoneOffsetTransition r101 = (ZoneOffsetTransition) r100;
        if (this.epochSecond == r101.epochSecond) goto L10;
    L14:
        return false;
    L10:
        if (this.offsetBefore.equals(r101.offsetBefore) == false) goto L14;
        if (this.offsetAfter.equals(r101.offsetAfter) == false) goto L14;
        return true;
    L16:
        return false;
    }

    public boolean isValidOffset(ZoneOffset r100) {
        if (isGap() == false) goto L6;
        return false;
    L6:
        if (getOffsetBefore().equals(r100) == false) goto L8;
    L9:
        return true;
    L8:
        if (getOffsetAfter().equals(r100) == true) goto L9;
        return false;
    }

    public void writeExternal(DataOutput r100) throws IOException {
        Ser.writeEpochSec(this.epochSecond, r100);
        Ser.writeOffset(this.offsetBefore, r100);
        Ser.writeOffset(this.offsetAfter, r100);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(ZoneOffsetTransition r100) {
        return compareTo2(r100);
    }

    public ZoneOffsetTransition(long r100, ZoneOffset r101, ZoneOffset r102) {
        this.epochSecond = r100;
        this.transition = LocalDateTime.ofEpochSecond(r100, 0, r101);
        this.offsetBefore = r101;
        this.offsetAfter = r102;
    }

    public static ZoneOffsetTransition of(LocalDateTime r100, ZoneOffset r101, ZoneOffset r102) {
        Objects.requireNonNull(r100, "transition");
        Objects.requireNonNull(r101, "offsetBefore");
        Objects.requireNonNull(r102, "offsetAfter");
        if (r101.equals(r102) == true) goto L11;
        if (r100.getNano() != 0) goto L9;
        return new ZoneOffsetTransition(r100, r101, r102);
    L9:
        throw new IllegalArgumentException("Nano-of-second must be zero");
    L11:
        throw new IllegalArgumentException("Offsets must not be equal");
    }

    public ZoneOffsetTransition(LocalDateTime r100, ZoneOffset r101, ZoneOffset r102) {
        this.epochSecond = r100.toEpochSecond(r101);
        this.transition = r100;
        this.offsetBefore = r101;
        this.offsetAfter = r102;
    }
}
