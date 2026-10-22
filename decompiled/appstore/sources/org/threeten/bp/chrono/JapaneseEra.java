package org.threeten.bp.chrono;

import androidx.lifecycle.p;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.LocalDate;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.ValueRange;

/* JADX INFO: loaded from: classes4.dex */
public final class JapaneseEra extends ig.a implements Serializable {
    private static final int ADDITIONAL_VALUE = 3;
    static final int ERA_OFFSET = 2;
    public static final JapaneseEra HEISEI = null;
    private static final AtomicReference<JapaneseEra[]> KNOWN_ERAS = null;
    public static final JapaneseEra MEIJI = null;
    public static final JapaneseEra SHOWA = null;
    public static final JapaneseEra TAISHO = null;
    private static final long serialVersionUID = 1466499369062886794L;
    private final int eraValue;
    private final transient String name;
    private final transient LocalDate since;

    static {
        JapaneseEra r10 = new JapaneseEra(-1, LocalDate.of(1868, 9, 8), "Meiji");
        MEIJI = r10;
        JapaneseEra r11 = new JapaneseEra(0, LocalDate.of(1912, 7, 30), "Taisho");
        TAISHO = r11;
        JapaneseEra r12 = new JapaneseEra(1, LocalDate.of(1926, 12, 25), "Showa");
        SHOWA = r12;
        JapaneseEra r13 = new JapaneseEra(2, LocalDate.of(1989, 1, 8), "Heisei");
        HEISEI = r13;
        KNOWN_ERAS = new AtomicReference(new JapaneseEra[]{r10, r11, r12, r13});
    }

    private JapaneseEra(int r10, LocalDate r11, String r12) {
        this.eraValue = r10;
        this.since = r11;
        this.name = r12;
    }

    public static JapaneseEra from(LocalDate r10) {
        if (r10.isBefore(MEIJI.since) == true) goto L13;
        JapaneseEra[] r11 = KNOWN_ERAS.get();
        int r12 = r11.length - 1;
    L5:
        if (r12 < 0) goto L10;
        JapaneseEra r13 = r11[r12];
        if (r10.compareTo(r13.since) >= 0) goto L8;
        r12 = r12 - 1;
        goto L5
    L8:
        return r13;
    L10:
        return null;
    L13:
        throw new DateTimeException("Date too early: " + r10);
    }

    public static JapaneseEra of(int r10) {
        JapaneseEra[] r11 = KNOWN_ERAS.get();
        if (r10 < MEIJI.eraValue) goto L9;
        if (r10 > r11[r11.length - 1].eraValue) goto L9;
        return r11[ordinal(r10)];
    L9:
        throw new DateTimeException("japaneseEra is invalid");
    }

    private static int ordinal(int r10) {
        return r10 + 1;
    }

    public static JapaneseEra readExternal(DataInput r10) throws IOException {
        return of(r10.readByte());
    }

    private Object readResolve() throws ObjectStreamException {
        return of(this.eraValue);
    L4:
        e = move-exception;
        InvalidObjectException r10 = new InvalidObjectException("Invalid era");
        r10.initCause(e);
        throw r10;
    }

    public static JapaneseEra registerEra(LocalDate r10, String r11) {
        AtomicReference<JapaneseEra[]> r12 = KNOWN_ERAS;
        JapaneseEra[] r13 = r12.get();
        if (r13.length > 4) goto L14;
        ig.d.h(r10, "since");
        ig.d.h(r11, "name");
        if (r10.isAfter(HEISEI.since) == false) goto L12;
        JapaneseEra r14 = new JapaneseEra(3, r10, r11);
        JapaneseEra[] r15 = (JapaneseEra[]) Arrays.copyOf(r13, 5);
        r15[4] = r14;
        if (p.a(r12, r13, r15) == false) goto L10;
        return r14;
    L10:
        throw new DateTimeException("Only one additional Japanese era can be added");
    L12:
        throw new DateTimeException("Invalid since date for additional Japanese era, must be after Heisei");
    L14:
        throw new DateTimeException("Only one additional Japanese era can be added");
    }

    public static JapaneseEra valueOf(String r10) {
        ig.d.h(r10, "japaneseEra");
        JapaneseEra[] r11 = KNOWN_ERAS.get();
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L9;
        JapaneseEra r14 = r11[r13];
        if (r10.equals(r14.name) == true) goto L6;
        r13 = r13 + 1;
        goto L3
    L6:
        return r14;
    L9:
        throw new IllegalArgumentException("Era not found: " + r10);
    }

    public static JapaneseEra[] values() {
        JapaneseEra[] r10 = KNOWN_ERAS.get();
        return (JapaneseEra[]) Arrays.copyOf(r10, r10.length);
    }

    private Object writeReplace() {
        return new Ser((byte) 2, this);
    }

    public LocalDate endDate() {
        int r10 = ordinal(this.eraValue);
        JapaneseEra[] r11 = values();
        if (r10 < (r11.length - 1)) goto L7;
        return LocalDate.MAX;
    L7:
        return r11[r10 + 1].startDate().minusDays(1);
    }

    @Override // org.threeten.bp.chrono.Era
    public int getValue() {
        return this.eraValue;
    }

    @Override // ig.c, org.threeten.bp.temporal.TemporalAccessor
    public ValueRange range(TemporalField r10) {
        ChronoField r11 = ChronoField.ERA;
        if (r10 != r11) goto L7;
        return JapaneseChronology.INSTANCE.range(r11);
    L7:
        return super.range(r10);
    }

    public LocalDate startDate() {
        return this.since;
    }

    public String toString() {
        return this.name;
    }

    public void writeExternal(DataOutput r10) throws IOException {
        r10.writeByte(getValue());
    }
}
