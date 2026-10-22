package org.threeten.bp.zone;

import ig.d;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.threeten.bp.Duration;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.ZoneOffset;

/* JADX INFO: loaded from: classes4.dex */
final class StandardZoneRules extends ZoneRules implements Serializable {
    private static final int LAST_CACHED_YEAR = 2100;
    private static final long serialVersionUID = 3044319355680032515L;
    private final ZoneOffsetTransitionRule[] lastRules;
    private final ConcurrentMap<Integer, ZoneOffsetTransition[]> lastRulesCache;
    private final long[] savingsInstantTransitions;
    private final LocalDateTime[] savingsLocalTransitions;
    private final ZoneOffset[] standardOffsets;
    private final long[] standardTransitions;
    private final ZoneOffset[] wallOffsets;

    public StandardZoneRules(ZoneOffset r10, ZoneOffset r11, List<ZoneOffsetTransition> r12, List<ZoneOffsetTransition> r13, List<ZoneOffsetTransitionRule> r14) {
        this.lastRulesCache = new ConcurrentHashMap();
        this.standardTransitions = new long[r12.size()];
        ZoneOffset[] r15 = new ZoneOffset[r12.size() + 1];
        this.standardOffsets = r15;
        int r16 = 0;
        r15[0] = r10;
        int r17 = 0;
    L4:
        if (r17 >= r12.size()) goto L6;
        this.standardTransitions[r17] = r12.get(r17).toEpochSecond();
        int r18 = r17 + 1;
        this.standardOffsets[r18] = r12.get(r17).getOffsetAfter();
        r17 = r18;
        goto L4
    L6:
        ArrayList r19 = new ArrayList();
        ArrayList r20 = new ArrayList();
        r20.add(r11);
        Iterator<ZoneOffsetTransition> r21 = r13.iterator();
    L8:
        if (r21.hasNext() == false) goto L14;
        ZoneOffsetTransition r22 = r21.next();
        if (r22.isGap() == false) goto L12;
        r19.add(r22.getDateTimeBefore());
        r19.add(r22.getDateTimeAfter());
    L13:
        r20.add(r22.getOffsetAfter());
        goto L8
    L12:
        r19.add(r22.getDateTimeAfter());
        r19.add(r22.getDateTimeBefore());
        goto L13
    L14:
        this.savingsLocalTransitions = (LocalDateTime[]) r19.toArray(new LocalDateTime[r19.size()]);
        this.wallOffsets = (ZoneOffset[]) r20.toArray(new ZoneOffset[r20.size()]);
        this.savingsInstantTransitions = new long[r13.size()];
    L16:
        if (r16 >= r13.size()) goto L19;
        this.savingsInstantTransitions[r16] = r13.get(r16).getInstant().getEpochSecond();
        r16 = r16 + 1;
        goto L16
    L19:
        if (r14.size() > 15) goto L23;
        this.lastRules = (ZoneOffsetTransitionRule[]) r14.toArray(new ZoneOffsetTransitionRule[r14.size()]);
        return;
    L23:
        throw new IllegalArgumentException("Too many transition rules");
    }

    private Object findOffsetInfo(LocalDateTime r10, ZoneOffsetTransition r11) {
        LocalDateTime r12 = r11.getDateTimeBefore();
        if (r11.isGap() == false) goto L14;
        if (r10.isBefore(r12) == false) goto L9;
        return r11.getOffsetBefore();
    L9:
        if (r10.isBefore(r11.getDateTimeAfter()) == false) goto L12;
        return r11;
    L12:
        return r11.getOffsetAfter();
    L14:
        if (r10.isBefore(r12) == true) goto L18;
        return r11.getOffsetAfter();
    L18:
        if (r10.isBefore(r11.getDateTimeAfter()) == true) goto L20;
        return r11;
    L20:
        return r11.getOffsetBefore();
    }

    private ZoneOffsetTransition[] findTransitionArray(int r10) {
        Integer r11 = Integer.valueOf(r10);
        ZoneOffsetTransition[] r12 = this.lastRulesCache.get(r11);
        if (r12 == null) goto L5;
        return r12;
    L5:
        ZoneOffsetTransitionRule[] r13 = this.lastRules;
        ZoneOffsetTransition[] r14 = new ZoneOffsetTransition[r13.length];
        int r15 = 0;
    L7:
        if (r15 >= r13.length) goto L10;
        r14[r15] = r13[r15].createTransition(r10);
        r15 = r15 + 1;
        goto L7
    L10:
        if (r10 >= LAST_CACHED_YEAR) goto L12;
        this.lastRulesCache.putIfAbsent(r11, r14);
    L12:
        return r14;
    }

    private int findYear(long r10, ZoneOffset r11) {
        return LocalDate.ofEpochDay(d.d(r10 + ((long) r11.getTotalSeconds()), 86400)).getYear();
    }

    private Object getOffsetInfo(LocalDateTime r10) {
        int r11 = 0;
        if (this.lastRules.length <= 0) goto L16;
        LocalDateTime[] r12 = this.savingsLocalTransitions;
        if (r10.isAfter(r12[r12.length - 1]) == false) goto L16;
        ZoneOffsetTransition[] r13 = findTransitionArray(r10.getYear());
        int r14 = r13.length;
        Object r15 = null;
    L7:
        if (r11 >= r14) goto L15;
        ZoneOffsetTransition r16 = r13[r11];
        Object r17 = findOffsetInfo(r10, r16);
        if ((r17 instanceof ZoneOffsetTransition) == true) goto L14;
        if (r17.equals(r16.getOffsetBefore()) == true) goto L14;
        r11 = r11 + 1;
        r15 = r17;
    L14:
        return r17;
    L15:
        return r15;
    L16:
        int r18 = Arrays.binarySearch(this.savingsLocalTransitions, r10);
        if (r18 == (-1)) goto L19;
        if (r18 >= 0) goto L22;
        r18 = (-r18) - 2;
    L28:
        if ((r18 & 1) != 0) goto L36;
        LocalDateTime[] r19 = this.savingsLocalTransitions;
        LocalDateTime r20 = r19[r18];
        LocalDateTime r21 = r19[r18 + 1];
        ZoneOffset[] r22 = this.wallOffsets;
        int r23 = r18 / 2;
        ZoneOffset r24 = r22[r23];
        ZoneOffset r25 = r22[r23 + 1];
        if (r25.getTotalSeconds() <= r24.getTotalSeconds()) goto L34;
        return new ZoneOffsetTransition(r20, r24, r25);
    L34:
        return new ZoneOffsetTransition(r21, r24, r25);
    L36:
        return this.wallOffsets[(r18 / 2) + 1];
    L22:
        Object[] r26 = this.savingsLocalTransitions;
        if (r18 >= (r26.length - 1)) goto L28;
        int r27 = r18 + 1;
        if (r26[r18].equals(r26[r27]) == false) goto L28;
        r18 = r27;
        goto L28
    L19:
        return this.wallOffsets[0];
    }

    public static StandardZoneRules readExternal(DataInput r10) throws IOException, ClassNotFoundException {
        int r11 = r10.readInt();
        long[] r12 = new long[r11];
        int r13 = 0;
        int r14 = 0;
    L3:
        if (r14 >= r11) goto L5;
        r12[r14] = Ser.readEpochSec(r10);
        r14 = r14 + 1;
        goto L3
    L5:
        int r15 = r11 + 1;
        ZoneOffset[] r16 = new ZoneOffset[r15];
        int r17 = 0;
    L6:
        if (r17 >= r15) goto L8;
        r16[r17] = Ser.readOffset(r10);
        r17 = r17 + 1;
        goto L6
    L8:
        int r18 = r10.readInt();
        long[] r19 = new long[r18];
        int r20 = 0;
    L9:
        if (r20 >= r18) goto L11;
        r19[r20] = Ser.readEpochSec(r10);
        r20 = r20 + 1;
        goto L9
    L11:
        int r21 = r18 + 1;
        ZoneOffset[] r22 = new ZoneOffset[r21];
        int r23 = 0;
    L12:
        if (r23 >= r21) goto L14;
        r22[r23] = Ser.readOffset(r10);
        r23 = r23 + 1;
        goto L12
    L14:
        int r24 = r10.readByte();
        ZoneOffsetTransitionRule[] r25 = new ZoneOffsetTransitionRule[r24];
    L15:
        if (r13 >= r24) goto L18;
        r25[r13] = ZoneOffsetTransitionRule.readExternal(r10);
        r13 = r13 + 1;
        goto L15
    L18:
        return new StandardZoneRules(r12, r16, r19, r22, r25);
    }

    private Object writeReplace() {
        return new Ser((byte) 1, this);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof StandardZoneRules) == false) goto L21;
        StandardZoneRules r11 = (StandardZoneRules) r10;
        if (Arrays.equals(this.standardTransitions, r11.standardTransitions) == false) goto L19;
        if (Arrays.equals(this.standardOffsets, r11.standardOffsets) == false) goto L19;
        if (Arrays.equals(this.savingsInstantTransitions, r11.savingsInstantTransitions) == false) goto L19;
        if (Arrays.equals(this.wallOffsets, r11.wallOffsets) == false) goto L19;
        if (Arrays.equals(this.lastRules, r11.lastRules) == false) goto L19;
        return true;
    L19:
        return false;
    L21:
        if ((r10 instanceof ZoneRules.Fixed) == true) goto L23;
        return false;
    L23:
        if (isFixedOffset() == false) goto L28;
        Instant r12 = Instant.EPOCH;
        if (getOffset(r12).equals(((ZoneRules.Fixed) r10).getOffset(r12)) == false) goto L28;
        return true;
    L28:
        return false;
    }

    public Duration getDaylightSavings(Instant r10) {
        return Duration.ofSeconds(getOffset(r10).getTotalSeconds() - getStandardOffset(r10).getTotalSeconds());
    }

    @Override // org.threeten.bp.zone.ZoneRules
    public ZoneOffset getOffset(Instant r10) {
        long r11 = r10.getEpochSecond();
        if (this.lastRules.length <= 0) goto L16;
        long[] r12 = this.savingsInstantTransitions;
        if (r11 <= r12[r12.length - 1]) goto L16;
        ZoneOffset[] r13 = this.wallOffsets;
        ZoneOffsetTransition[] r14 = findTransitionArray(findYear(r11, r13[r13.length - 1]));
        ZoneOffsetTransition r15 = null;
        int r16 = 0;
    L8:
        if (r16 >= r14.length) goto L15;
        r15 = r14[r16];
        if (r11 < r15.toEpochSecond()) goto L12;
        r16 = r16 + 1;
        goto L8
    L12:
        return r15.getOffsetBefore();
    L15:
        return r15.getOffsetAfter();
    L16:
        int r17 = Arrays.binarySearch(this.savingsInstantTransitions, r11);
        if (r17 >= 0) goto L20;
        r17 = (-r17) - 2;
    L20:
        return this.wallOffsets[r17 + 1];
    }

    public ZoneOffset getStandardOffset(Instant r10) {
        int r11 = Arrays.binarySearch(this.standardTransitions, r10.getEpochSecond());
        if (r11 >= 0) goto L6;
        r11 = (-r11) - 2;
    L6:
        return this.standardOffsets[r11 + 1];
    }

    @Override // org.threeten.bp.zone.ZoneRules
    public ZoneOffsetTransition getTransition(LocalDateTime r10) {
        Object r11 = getOffsetInfo(r10);
        if ((r11 instanceof ZoneOffsetTransition) == true) goto L7;
        return null;
    L7:
        return (ZoneOffsetTransition) r11;
    }

    public List<ZoneOffsetTransitionRule> getTransitionRules() {
        return Collections.unmodifiableList(Arrays.asList(this.lastRules));
    }

    public List<ZoneOffsetTransition> getTransitions() {
        ArrayList r10 = new ArrayList();
        int r11 = 0;
    L3:
        long[] r12 = this.savingsInstantTransitions;
        if (r11 >= r12.length) goto L7;
        long r13 = r12[r11];
        ZoneOffset[] r14 = this.wallOffsets;
        ZoneOffset r15 = r14[r11];
        r11 = r11 + 1;
        r10.add(new ZoneOffsetTransition(r13, r15, r14[r11]));
        goto L3
    L7:
        return Collections.unmodifiableList(r10);
    }

    @Override // org.threeten.bp.zone.ZoneRules
    public List<ZoneOffset> getValidOffsets(LocalDateTime r10) {
        Object r11 = getOffsetInfo(r10);
        if ((r11 instanceof ZoneOffsetTransition) == false) goto L7;
        return ((ZoneOffsetTransition) r11).getValidOffsets();
    L7:
        return Collections.singletonList((ZoneOffset) r11);
    }

    public int hashCode() {
        int r10 = ((Arrays.hashCode(this.standardTransitions) ^ Arrays.hashCode(this.standardOffsets)) ^ Arrays.hashCode(this.savingsInstantTransitions)) ^ Arrays.hashCode(this.wallOffsets);
        return Arrays.hashCode(this.lastRules) ^ r10;
    }

    @Override // org.threeten.bp.zone.ZoneRules
    public boolean isDaylightSavings(Instant r10) {
        return !getStandardOffset(r10).equals(getOffset(r10));
    }

    @Override // org.threeten.bp.zone.ZoneRules
    public boolean isFixedOffset() {
        if (this.savingsInstantTransitions.length != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.threeten.bp.zone.ZoneRules
    public boolean isValidOffset(LocalDateTime r10, ZoneOffset r11) {
        return getValidOffsets(r10).contains(r11);
    }

    public ZoneOffsetTransition nextTransition(Instant r11) {
        if (this.savingsInstantTransitions.length != 0) goto L5;
        return null;
    L5:
        long r10 = r11.getEpochSecond();
        long[] r12 = this.savingsInstantTransitions;
        if (r10 >= r12[r12.length - 1]) goto L8;
        int r13 = Arrays.binarySearch(r12, r10);
        if (r13 >= 0) goto L24;
        int r14 = (-r13) - 1;
    L25:
        long r15 = this.savingsInstantTransitions[r14];
        ZoneOffset[] r16 = this.wallOffsets;
        return new ZoneOffsetTransition(r15, r16[r14], r16[r14 + 1]);
    L24:
        r14 = r13 + 1;
        goto L25
    L8:
        if (this.lastRules.length != 0) goto L10;
        return null;
    L10:
        ZoneOffset[] r17 = this.wallOffsets;
        int r18 = findYear(r10, r17[r17.length - 1]);
        ZoneOffsetTransition[] r19 = findTransitionArray(r18);
        int r20 = r19.length;
        int r21 = 0;
    L11:
        if (r21 >= r20) goto L17;
        ZoneOffsetTransition r22 = r19[r21];
        if (r10 < r22.toEpochSecond()) goto L14;
        r21 = r21 + 1;
        goto L11
    L14:
        return r22;
    L17:
        if (r18 < 999999999) goto L19;
        return null;
    L19:
        return findTransitionArray(r18 + 1)[0];
    }

    public ZoneOffsetTransition previousTransition(Instant r11) {
        if (this.savingsInstantTransitions.length != 0) goto L5;
        return null;
    L5:
        long r10 = r11.getEpochSecond();
        if (r11.getNano() > 0) goto L8;
    L10:
        long[] r12 = this.savingsInstantTransitions;
        long r13 = r12[r12.length - 1];
        if (this.lastRules.length > 0) goto L13;
    L25:
        int r14 = Arrays.binarySearch(this.savingsInstantTransitions, r10);
        if (r14 >= 0) goto L28;
        r14 = (-r14) - 1;
    L28:
        if (r14 > 0) goto L30;
        return null;
    L30:
        int r15 = r14 - 1;
        long r16 = this.savingsInstantTransitions[r15];
        ZoneOffset[] r17 = this.wallOffsets;
        return new ZoneOffsetTransition(r16, r17[r15], r17[r14]);
    L13:
        if (r10 <= r13) goto L25;
        ZoneOffset[] r18 = this.wallOffsets;
        ZoneOffset r19 = r18[r18.length - 1];
        int r20 = findYear(r10, r19);
        ZoneOffsetTransition[] r21 = findTransitionArray(r20);
        int r22 = r21.length - 1;
    L15:
        if (r22 < 0) goto L21;
        if (r10 > r21[r22].toEpochSecond()) goto L19;
        r22 = r22 - 1;
        goto L15
    L19:
        return r21[r22];
    L21:
        int r23 = r20 - 1;
        if (r23 <= findYear(r13, r19)) goto L25;
        ZoneOffsetTransition[] r110 = findTransitionArray(r23);
        return r110[r110.length - 1];
    L8:
        if (r10 >= Long.MAX_VALUE) goto L10;
        r10 = r10 + 1;
        goto L10
    }

    public String toString() {
        StringBuilder r10 = new StringBuilder();
        r10.append("StandardZoneRules[currentStandardOffset=");
        ZoneOffset[] r11 = this.standardOffsets;
        r10.append(r11[r11.length - 1]);
        r10.append("]");
        return r10.toString();
    }

    public void writeExternal(DataOutput r10) throws IOException {
        r10.writeInt(this.standardTransitions.length);
        long[] r11 = this.standardTransitions;
        int r12 = r11.length;
        int r13 = 0;
        int r14 = 0;
    L3:
        if (r14 >= r12) goto L5;
        Ser.writeEpochSec(r11[r14], r10);
        r14 = r14 + 1;
        goto L3
    L5:
        ZoneOffset[] r15 = this.standardOffsets;
        int r16 = r15.length;
        int r17 = 0;
    L6:
        if (r17 >= r16) goto L8;
        Ser.writeOffset(r15[r17], r10);
        r17 = r17 + 1;
        goto L6
    L8:
        r10.writeInt(this.savingsInstantTransitions.length);
        long[] r18 = this.savingsInstantTransitions;
        int r19 = r18.length;
        int r20 = 0;
    L9:
        if (r20 >= r19) goto L11;
        Ser.writeEpochSec(r18[r20], r10);
        r20 = r20 + 1;
        goto L9
    L11:
        ZoneOffset[] r21 = this.wallOffsets;
        int r22 = r21.length;
        int r23 = 0;
    L12:
        if (r23 >= r22) goto L14;
        Ser.writeOffset(r21[r23], r10);
        r23 = r23 + 1;
        goto L12
    L14:
        r10.writeByte(this.lastRules.length);
        ZoneOffsetTransitionRule[] r24 = this.lastRules;
        int r25 = r24.length;
    L15:
        if (r13 >= r25) goto L17;
        r24[r13].writeExternal(r10);
        r13 = r13 + 1;
        goto L15
    }

    public ZoneOffset getOffset(LocalDateTime r10) {
        Object r11 = getOffsetInfo(r10);
        if ((r11 instanceof ZoneOffsetTransition) == false) goto L7;
        return ((ZoneOffsetTransition) r11).getOffsetBefore();
    L7:
        return (ZoneOffset) r11;
    }

    private StandardZoneRules(long[] r10, ZoneOffset[] r11, long[] r12, ZoneOffset[] r13, ZoneOffsetTransitionRule[] r14) {
        this.lastRulesCache = new ConcurrentHashMap();
        this.standardTransitions = r10;
        this.standardOffsets = r11;
        this.savingsInstantTransitions = r12;
        this.wallOffsets = r13;
        this.lastRules = r14;
        ArrayList r15 = new ArrayList();
        int r16 = 0;
    L4:
        if (r16 >= r12.length) goto L10;
        ZoneOffset r17 = r13[r16];
        int r18 = r16 + 1;
        ZoneOffset r19 = r13[r18];
        ZoneOffsetTransition r20 = new ZoneOffsetTransition(r12[r16], r17, r19);
        if (r20.isGap() == false) goto L8;
        r15.add(r20.getDateTimeBefore());
        r15.add(r20.getDateTimeAfter());
    L9:
        r16 = r18;
        goto L4
    L8:
        r15.add(r20.getDateTimeAfter());
        r15.add(r20.getDateTimeBefore());
        goto L9
    L10:
        this.savingsLocalTransitions = (LocalDateTime[]) r15.toArray(new LocalDateTime[r15.size()]);
    }
}
