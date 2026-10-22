package org.threeten.bp.zone;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.DataInput;
import java.io.DataOutput;
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
import org.threeten.bp.jdk8.Jdk8Methods;

/* JADX INFO: loaded from: classes5.dex */
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

    StandardZoneRules(ZoneOffset r6, ZoneOffset r7, List<ZoneOffsetTransition> r8, List<ZoneOffsetTransition> r9, List<ZoneOffsetTransitionRule> r10) {
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.aiagent.plugin");
        List r12 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
        List r13 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.aiagent.plugin");
        this.lastRulesCache = new ConcurrentHashMap();
        this.standardTransitions = new long[r11.size()];
        ZoneOffset[] r0 = new ZoneOffset[r11.size() + 1];
        this.standardOffsets = r0;
        int r2 = 0;
        r0[0] = r6;
        int r14 = 0;
    L4:
        if (r14 >= r11.size()) goto L6;
        this.standardTransitions[r14] = ((ZoneOffsetTransition) ZeusTransformUtils.preCheckCast(r11.get(r14), ZoneOffsetTransition.class, "com.obric.aiagent.plugin")).toEpochSecond();
        int r3 = r14 + 1;
        this.standardOffsets[r3] = ((ZoneOffsetTransition) ZeusTransformUtils.preCheckCast(r11.get(r14), ZoneOffsetTransition.class, "com.obric.aiagent.plugin")).getOffsetAfter();
        r14 = r3;
        goto L4
    L6:
        ArrayList r15 = new ArrayList();
        ArrayList r16 = new ArrayList();
        r16.add(r7);
        Iterator r17 = r12.iterator();
    L8:
        if (r17.hasNext() == false) goto L14;
        ZoneOffsetTransition r1 = (ZoneOffsetTransition) ZeusTransformUtils.preCheckCast(r17.next(), ZoneOffsetTransition.class, "com.obric.aiagent.plugin");
        if (r1.isGap() == false) goto L12;
        r15.add(r1.getDateTimeBefore());
        r15.add(r1.getDateTimeAfter());
    L13:
        r16.add(r1.getOffsetAfter());
        goto L8
    L12:
        r15.add(r1.getDateTimeAfter());
        r15.add(r1.getDateTimeBefore());
        goto L13
    L14:
        this.savingsLocalTransitions = (LocalDateTime[]) ZeusTransformUtils.preCheckCast(r15.toArray(new LocalDateTime[r15.size()]), LocalDateTime[].class, "com.obric.aiagent.plugin");
        this.wallOffsets = (ZoneOffset[]) ZeusTransformUtils.preCheckCast(r16.toArray(new ZoneOffset[r16.size()]), ZoneOffset[].class, "com.obric.aiagent.plugin");
        this.savingsInstantTransitions = new long[r12.size()];
    L16:
        if (r2 >= r12.size()) goto L19;
        this.savingsInstantTransitions[r2] = ((ZoneOffsetTransition) ZeusTransformUtils.preCheckCast(r12.get(r2), ZoneOffsetTransition.class, "com.obric.aiagent.plugin")).getInstant().getEpochSecond();
        r2 = r2 + 1;
        goto L16
    L19:
        if (r13.size() > 15) goto L23;
        this.lastRules = (ZoneOffsetTransitionRule[]) ZeusTransformUtils.preCheckCast(r13.toArray(new ZoneOffsetTransitionRule[r13.size()]), ZoneOffsetTransitionRule[].class, "com.obric.aiagent.plugin");
        return;
    L23:
        throw new IllegalArgumentException("Too many transition rules");
    }

    private StandardZoneRules(long[] r6, ZoneOffset[] r7, long[] r8, ZoneOffset[] r9, ZoneOffsetTransitionRule[] r10) {
        this.lastRulesCache = new ConcurrentHashMap();
        this.standardTransitions = r6;
        this.standardOffsets = r7;
        this.savingsInstantTransitions = r8;
        this.wallOffsets = r9;
        this.lastRules = r10;
        ArrayList r11 = new ArrayList();
        int r12 = 0;
    L4:
        if (r12 >= r8.length) goto L10;
        ZoneOffset r13 = r9[r12];
        int r0 = r12 + 1;
        ZoneOffset r1 = r9[r0];
        ZoneOffsetTransition r2 = new ZoneOffsetTransition(r8[r12], r13, r1);
        if (r2.isGap() == false) goto L8;
        r11.add(r2.getDateTimeBefore());
        r11.add(r2.getDateTimeAfter());
    L9:
        r12 = r0;
        goto L4
    L8:
        r11.add(r2.getDateTimeAfter());
        r11.add(r2.getDateTimeBefore());
        goto L9
    L10:
        this.savingsLocalTransitions = (LocalDateTime[]) ZeusTransformUtils.preCheckCast(r11.toArray(new LocalDateTime[r11.size()]), LocalDateTime[].class, "com.obric.aiagent.plugin");
    }

    private Object writeReplace() {
        return new Ser((byte) 1, this);
    }

    void writeExternal(DataOutput r7) {
        DataOutput r8 = (DataOutput) ZeusTransformUtils.wrapperContextForParams(r7, DataOutput.class, "com.obric.aiagent.plugin");
        r8.writeInt(this.standardTransitions.length);
        long[] r0 = this.standardTransitions;
        int r1 = r0.length;
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L5;
        Ser.writeEpochSec(r0[r3], r8);
        r3 = r3 + 1;
        goto L3
    L5:
        ZoneOffset[] r4 = this.standardOffsets;
        int r5 = r4.length;
        int r6 = 0;
    L6:
        if (r6 >= r5) goto L8;
        Ser.writeOffset(r4[r6], r8);
        r6 = r6 + 1;
        goto L6
    L8:
        r8.writeInt(this.savingsInstantTransitions.length);
        long[] r9 = this.savingsInstantTransitions;
        int r10 = r9.length;
        int r11 = 0;
    L9:
        if (r11 >= r10) goto L11;
        Ser.writeEpochSec(r9[r11], r8);
        r11 = r11 + 1;
        goto L9
    L11:
        ZoneOffset[] r12 = this.wallOffsets;
        int r13 = r12.length;
        int r14 = 0;
    L12:
        if (r14 >= r13) goto L14;
        Ser.writeOffset(r12[r14], r8);
        r14 = r14 + 1;
        goto L12
    L14:
        r8.writeByte(this.lastRules.length);
        ZoneOffsetTransitionRule[] r15 = this.lastRules;
        int r16 = r15.length;
    L15:
        if (r2 >= r16) goto L17;
        r15[r2].writeExternal(r8);
        r2 = r2 + 1;
        goto L15
    }

    static StandardZoneRules readExternal(DataInput r8) {
        DataInput r9 = (DataInput) ZeusTransformUtils.wrapperContextForParams(r8, DataInput.class, "com.obric.aiagent.plugin");
        int r0 = r9.readInt();
        long[] r2 = new long[r0];
        int r1 = 0;
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L5;
        r2[r3] = Ser.readEpochSec(r9);
        r3 = r3 + 1;
        goto L3
    L5:
        int r4 = r0 + 1;
        ZoneOffset[] r5 = new ZoneOffset[r4];
        int r6 = 0;
    L6:
        if (r6 >= r4) goto L8;
        r5[r6] = Ser.readOffset(r9);
        r6 = r6 + 1;
        goto L6
    L8:
        int r7 = r9.readInt();
        long[] r10 = new long[r7];
        int r11 = 0;
    L9:
        if (r11 >= r7) goto L11;
        r10[r11] = Ser.readEpochSec(r9);
        r11 = r11 + 1;
        goto L9
    L11:
        int r12 = r7 + 1;
        ZoneOffset[] r13 = new ZoneOffset[r12];
        int r14 = 0;
    L12:
        if (r14 >= r12) goto L14;
        r13[r14] = Ser.readOffset(r9);
        r14 = r14 + 1;
        goto L12
    L14:
        int r15 = r9.readByte();
        ZoneOffsetTransitionRule[] r16 = new ZoneOffsetTransitionRule[r15];
    L15:
        if (r1 >= r15) goto L18;
        r16[r1] = ZoneOffsetTransitionRule.readExternal(r9);
        r1 = r1 + 1;
        goto L15
    L18:
        return new StandardZoneRules(r2, r5, r10, r13, r16);
    }

    @Override // org.threeten.bp.zone.ZoneRules
    public boolean isFixedOffset() {
        if (this.savingsInstantTransitions.length != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.threeten.bp.zone.ZoneRules
    public ZoneOffset getOffset(Instant r6) {
        long r0 = r6.getEpochSecond();
        if (this.lastRules.length <= 0) goto L16;
        long[] r7 = this.savingsInstantTransitions;
        if (r0 <= r7[r7.length - 1]) goto L16;
        ZoneOffset[] r8 = this.wallOffsets;
        ZoneOffsetTransition[] r5 = findTransitionArray(findYear(r0, r8[r8.length - 1]));
        ZoneOffsetTransition r9 = null;
        int r2 = 0;
    L8:
        if (r2 >= r5.length) goto L15;
        r9 = r5[r2];
        if (r0 < r9.toEpochSecond()) goto L12;
        r2 = r2 + 1;
        goto L8
    L12:
        return r9.getOffsetBefore();
    L15:
        return r9.getOffsetAfter();
    L16:
        int r10 = Arrays.binarySearch(this.savingsInstantTransitions, r0);
        if (r10 >= 0) goto L20;
        r10 = (-r10) - 2;
    L20:
        return this.wallOffsets[r10 + 1];
    }

    @Override // org.threeten.bp.zone.ZoneRules
    public ZoneOffset getOffset(LocalDateTime r2) {
        Object r1 = getOffsetInfo(r2);
        if (ZeusTransformUtils.instanceOf(r1, ZoneOffsetTransition.class) == false) goto L7;
        return ((ZoneOffsetTransition) ZeusTransformUtils.preCheckCast(r1, ZoneOffsetTransition.class, "com.obric.aiagent.plugin")).getOffsetBefore();
    L7:
        return (ZoneOffset) ZeusTransformUtils.preCheckCast(r1, ZoneOffset.class, "com.obric.aiagent.plugin");
    }

    @Override // org.threeten.bp.zone.ZoneRules
    public List<ZoneOffset> getValidOffsets(LocalDateTime r2) {
        Object r1 = getOffsetInfo(r2);
        if (ZeusTransformUtils.instanceOf(r1, ZoneOffsetTransition.class) == false) goto L7;
        return ((ZoneOffsetTransition) ZeusTransformUtils.preCheckCast(r1, ZoneOffsetTransition.class, "com.obric.aiagent.plugin")).getValidOffsets();
    L7:
        return Collections.singletonList((ZoneOffset) ZeusTransformUtils.preCheckCast(r1, ZoneOffset.class, "com.obric.aiagent.plugin"));
    }

    @Override // org.threeten.bp.zone.ZoneRules
    public ZoneOffsetTransition getTransition(LocalDateTime r2) {
        Object r1 = getOffsetInfo(r2);
        if (ZeusTransformUtils.instanceOf(r1, ZoneOffsetTransition.class) == true) goto L7;
        return null;
    L7:
        return (ZoneOffsetTransition) ZeusTransformUtils.preCheckCast(r1, ZoneOffsetTransition.class, "com.obric.aiagent.plugin");
    }

    private Object getOffsetInfo(LocalDateTime r7) {
        int r1 = 0;
        if (this.lastRules.length <= 0) goto L16;
        LocalDateTime[] r0 = this.savingsLocalTransitions;
        if (r7.isAfter(r0[r0.length - 1]) == false) goto L16;
        ZoneOffsetTransition[] r2 = findTransitionArray(r7.getYear());
        Object r3 = null;
        int r4 = r2.length;
    L7:
        if (r1 >= r4) goto L15;
        ZoneOffsetTransition r5 = r2[r1];
        Object r6 = findOffsetInfo(r7, r5);
        if (ZeusTransformUtils.instanceOf(r6, ZoneOffsetTransition.class) == true) goto L14;
        if (r6.equals(r5.getOffsetBefore()) == true) goto L14;
        r1 = r1 + 1;
        r3 = r6;
    L14:
        return r6;
    L15:
        return r3;
    L16:
        int r8 = Arrays.binarySearch(this.savingsLocalTransitions, r7);
        if (r8 == (-1)) goto L19;
        if (r8 >= 0) goto L22;
        r8 = (-r8) - 2;
    L28:
        if ((r8 & 1) != 0) goto L36;
        LocalDateTime[] r9 = this.savingsLocalTransitions;
        LocalDateTime r10 = r9[r8];
        LocalDateTime r11 = r9[r8 + 1];
        ZoneOffset[] r12 = this.wallOffsets;
        int r13 = r8 / 2;
        ZoneOffset r14 = r12[r13];
        ZoneOffset r15 = r12[r13 + 1];
        if (r15.getTotalSeconds() <= r14.getTotalSeconds()) goto L34;
        return new ZoneOffsetTransition(r10, r14, r15);
    L34:
        return new ZoneOffsetTransition(r11, r14, r15);
    L36:
        return this.wallOffsets[(r8 / 2) + 1];
    L22:
        Object[] r16 = this.savingsLocalTransitions;
        if (r8 >= (r16.length - 1)) goto L28;
        int r17 = r8 + 1;
        if (r16[r8].equals(r16[r17]) == false) goto L28;
        r8 = r17;
        goto L28
    L19:
        return this.wallOffsets[0];
    }

    private Object findOffsetInfo(LocalDateTime r2, ZoneOffsetTransition r3) {
        LocalDateTime r1 = r3.getDateTimeBefore();
        if (r3.isGap() == false) goto L14;
        if (r2.isBefore(r1) == false) goto L9;
        return r3.getOffsetBefore();
    L9:
        if (r2.isBefore(r3.getDateTimeAfter()) == false) goto L12;
        return r3;
    L12:
        return r3.getOffsetAfter();
    L14:
        if (r2.isBefore(r1) == true) goto L18;
        return r3.getOffsetAfter();
    L18:
        if (r2.isBefore(r3.getDateTimeAfter()) == true) goto L20;
        return r3;
    L20:
        return r3.getOffsetBefore();
    }

    @Override // org.threeten.bp.zone.ZoneRules
    public boolean isValidOffset(LocalDateTime r1, ZoneOffset r2) {
        return getValidOffsets(r1).contains(r2);
    }

    private ZoneOffsetTransition[] findTransitionArray(int r6) {
        Integer r0 = Integer.valueOf(r6);
        ZoneOffsetTransition[] r1 = (ZoneOffsetTransition[]) ZeusTransformUtils.preCheckCast(this.lastRulesCache.get(r0), ZoneOffsetTransition[].class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L5;
        return r1;
    L5:
        ZoneOffsetTransitionRule[] r2 = this.lastRules;
        ZoneOffsetTransition[] r3 = new ZoneOffsetTransition[r2.length];
        int r4 = 0;
    L7:
        if (r4 >= r2.length) goto L10;
        r3[r4] = r2[r4].createTransition(r6);
        r4 = r4 + 1;
        goto L7
    L10:
        if (r6 >= 2100) goto L12;
        this.lastRulesCache.putIfAbsent(r0, r3);
    L12:
        return r3;
    }

    @Override // org.threeten.bp.zone.ZoneRules
    public ZoneOffset getStandardOffset(Instant r3) {
        int r4 = Arrays.binarySearch(this.standardTransitions, r3.getEpochSecond());
        if (r4 >= 0) goto L6;
        r4 = (-r4) - 2;
    L6:
        return this.standardOffsets[r4 + 1];
    }

    @Override // org.threeten.bp.zone.ZoneRules
    public Duration getDaylightSavings(Instant r2) {
        return Duration.ofSeconds(getOffset(r2).getTotalSeconds() - getStandardOffset(r2).getTotalSeconds());
    }

    @Override // org.threeten.bp.zone.ZoneRules
    public boolean isDaylightSavings(Instant r2) {
        return !getStandardOffset(r2).equals(getOffset(r2));
    }

    @Override // org.threeten.bp.zone.ZoneRules
    public ZoneOffsetTransition nextTransition(Instant r11) {
        if (this.savingsInstantTransitions.length != 0) goto L5;
        return null;
    L5:
        long r2 = r11.getEpochSecond();
        long[] r12 = this.savingsInstantTransitions;
        if (r2 >= r12[r12.length - 1]) goto L8;
        int r13 = Arrays.binarySearch(r12, r2);
        if (r13 >= 0) goto L24;
        int r14 = (-r13) - 1;
    L25:
        long r1 = this.savingsInstantTransitions[r14];
        ZoneOffset[] r10 = this.wallOffsets;
        return new ZoneOffsetTransition(r1, r10[r14], r10[r14 + 1]);
    L24:
        r14 = r13 + 1;
        goto L25
    L8:
        if (this.lastRules.length != 0) goto L10;
        return null;
    L10:
        ZoneOffset[] r15 = this.wallOffsets;
        int r16 = findYear(r2, r15[r15.length - 1]);
        ZoneOffsetTransition[] r0 = findTransitionArray(r16);
        int r4 = r0.length;
        int r6 = 0;
    L11:
        if (r6 >= r4) goto L17;
        ZoneOffsetTransition r7 = r0[r6];
        if (r2 < r7.toEpochSecond()) goto L14;
        r6 = r6 + 1;
        goto L11
    L14:
        return r7;
    L17:
        if (r16 < 999999999) goto L19;
        return null;
    L19:
        return findTransitionArray(r16 + 1)[0];
    }

    @Override // org.threeten.bp.zone.ZoneRules
    public ZoneOffsetTransition previousTransition(Instant r11) {
        if (this.savingsInstantTransitions.length != 0) goto L5;
        return null;
    L5:
        long r2 = r11.getEpochSecond();
        if (r11.getNano() > 0) goto L8;
    L10:
        long[] r12 = this.savingsInstantTransitions;
        long r4 = r12[r12.length - 1];
        if (this.lastRules.length > 0) goto L13;
    L25:
        int r13 = Arrays.binarySearch(this.savingsInstantTransitions, r2);
        if (r13 >= 0) goto L28;
        r13 = (-r13) - 1;
    L28:
        if (r13 > 0) goto L30;
        return null;
    L30:
        int r3 = r13 - 1;
        long r5 = this.savingsInstantTransitions[r3];
        ZoneOffset[] r10 = this.wallOffsets;
        return new ZoneOffsetTransition(r5, r10[r3], r10[r13]);
    L13:
        if (r2 <= r4) goto L25;
        ZoneOffset[] r14 = this.wallOffsets;
        ZoneOffset r15 = r14[r14.length - 1];
        int r0 = findYear(r2, r15);
        ZoneOffsetTransition[] r6 = findTransitionArray(r0);
        int r7 = r6.length - 1;
    L15:
        if (r7 < 0) goto L21;
        if (r2 > r6[r7].toEpochSecond()) goto L19;
        r7 = r7 - 1;
        goto L15
    L19:
        return r6[r7];
    L21:
        int r1 = r0 - 1;
        if (r1 <= findYear(r4, r15)) goto L25;
        ZoneOffsetTransition[] r16 = findTransitionArray(r1);
        return r16[r16.length - 1];
    L8:
        if (r2 >= Long.MAX_VALUE) goto L10;
        r2 = r2 + 1;
        goto L10
    }

    private int findYear(long r3, ZoneOffset r5) {
        return LocalDate.ofEpochDay(Jdk8Methods.floorDiv(r3 + ((long) r5.getTotalSeconds()), 86400)).getYear();
    }

    @Override // org.threeten.bp.zone.ZoneRules
    public List<ZoneOffsetTransition> getTransitions() {
        ArrayList r0 = new ArrayList();
        int r1 = 0;
    L4:
        if (r1 >= this.savingsInstantTransitions.length) goto L7;
        long r3 = this.savingsInstantTransitions[r1];
        ZoneOffset[] r5 = this.wallOffsets;
        ZoneOffset r6 = r5[r1];
        r1 = r1 + 1;
        r0.add(new ZoneOffsetTransition(r3, r6, r5[r1]));
        goto L4
    L7:
        return Collections.unmodifiableList(r0);
    }

    @Override // org.threeten.bp.zone.ZoneRules
    public List<ZoneOffsetTransitionRule> getTransitionRules() {
        return Collections.unmodifiableList(Arrays.asList(this.lastRules));
    }

    @Override // org.threeten.bp.zone.ZoneRules
    public boolean equals(Object r6) {
        if (this != r6) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r6, StandardZoneRules.class) == false) goto L21;
        StandardZoneRules r7 = (StandardZoneRules) ZeusTransformUtils.preCheckCast(r6, StandardZoneRules.class, "com.obric.aiagent.plugin");
        if (Arrays.equals(this.standardTransitions, r7.standardTransitions) == false) goto L19;
        if (Arrays.equals(this.standardOffsets, r7.standardOffsets) == false) goto L19;
        if (Arrays.equals(this.savingsInstantTransitions, r7.savingsInstantTransitions) == false) goto L19;
        if (Arrays.equals(this.wallOffsets, r7.wallOffsets) == false) goto L19;
        if (Arrays.equals(this.lastRules, r7.lastRules) == false) goto L19;
        return true;
    L19:
        return false;
    L21:
        if (ZeusTransformUtils.instanceOf(r6, ZoneRules.Fixed.class) == true) goto L23;
        return false;
    L23:
        if (isFixedOffset() == false) goto L28;
        if (getOffset(Instant.EPOCH).equals(((ZoneRules.Fixed) ZeusTransformUtils.preCheckCast(r6, ZoneRules.Fixed.class, "com.obric.aiagent.plugin")).getOffset(Instant.EPOCH)) == false) goto L28;
        return true;
    L28:
        return false;
    }

    @Override // org.threeten.bp.zone.ZoneRules
    public int hashCode() {
        int r0 = ((Arrays.hashCode(this.standardTransitions) ^ Arrays.hashCode(this.standardOffsets)) ^ Arrays.hashCode(this.savingsInstantTransitions)) ^ Arrays.hashCode(this.wallOffsets);
        return Arrays.hashCode(this.lastRules) ^ r0;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder().append("StandardZoneRules[currentStandardOffset=");
        ZoneOffset[] r2 = this.standardOffsets;
        return r0.append(r2[r2.length - 1]).append("]").toString();
    }
}
