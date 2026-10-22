package org.threeten.bp.chrono;

import androidx.lifecycle.LifecycleKt$$ExternalSyntheticBackportWithForwarding0;
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
import org.threeten.bp.jdk8.DefaultInterfaceEra;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.ValueRange;

/* JADX INFO: loaded from: classes5.dex */
public final class JapaneseEra extends DefaultInterfaceEra implements Serializable {
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

    private static int ordinal(int r0) {
        return r0 + 1;
    }

    static {
        JapaneseEra r0 = new JapaneseEra(-1, LocalDate.of(1868, 9, 8), "Meiji");
        MEIJI = r0;
        JapaneseEra r1 = new JapaneseEra(0, LocalDate.of(1912, 7, 30), "Taisho");
        TAISHO = r1;
        JapaneseEra r2 = new JapaneseEra(1, LocalDate.of(1926, 12, 25), "Showa");
        SHOWA = r2;
        JapaneseEra r4 = new JapaneseEra(2, LocalDate.of(1989, 1, 8), "Heisei");
        HEISEI = r4;
        KNOWN_ERAS = new AtomicReference(new JapaneseEra[]{r0, r1, r2, r4});
    }

    private JapaneseEra(int r1, LocalDate r2, String r3) {
        this.eraValue = r1;
        this.since = r2;
        this.name = r3;
    }

    private Object readResolve() throws ObjectStreamException {
        return of(this.eraValue);
    L4:
        e = move-exception;
        InvalidObjectException r0 = new InvalidObjectException("Invalid era");
        r0.initCause(e);
        throw r0;
    }

    public static JapaneseEra registerEra(LocalDate r6, String r7) {
        AtomicReference<JapaneseEra[]> r0 = KNOWN_ERAS;
        JapaneseEra[] r1 = r0.get();
        if (r1.length > 4) goto L14;
        Jdk8Methods.requireNonNull(r6, "since");
        Jdk8Methods.requireNonNull(r7, "name");
        if (r6.isAfter(HEISEI.since) == false) goto L12;
        JapaneseEra r2 = new JapaneseEra(3, r6, r7);
        JapaneseEra[] r8 = (JapaneseEra[]) Arrays.copyOf(r1, 5);
        r8[4] = r2;
        if (LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(r0, r1, r8) == false) goto L10;
        return r2;
    L10:
        throw new DateTimeException("Only one additional Japanese era can be added");
    L12:
        throw new DateTimeException("Invalid since date for additional Japanese era, must be after Heisei");
    L14:
        throw new DateTimeException("Only one additional Japanese era can be added");
    }

    public static JapaneseEra of(int r2) {
        JapaneseEra[] r0 = KNOWN_ERAS.get();
        if (r2 < MEIJI.eraValue) goto L9;
        if (r2 > r0[r0.length - 1].eraValue) goto L9;
        return r0[ordinal(r2)];
    L9:
        throw new DateTimeException("japaneseEra is invalid");
    }

    public static JapaneseEra valueOf(String r5) {
        Jdk8Methods.requireNonNull(r5, "japaneseEra");
        JapaneseEra[] r0 = KNOWN_ERAS.get();
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L9;
        JapaneseEra r3 = r0[r2];
        if (r5.equals(r3.name) == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return r3;
    L9:
        throw new IllegalArgumentException("Era not found: " + r5);
    }

    public static JapaneseEra[] values() {
        JapaneseEra[] r0 = KNOWN_ERAS.get();
        return (JapaneseEra[]) Arrays.copyOf(r0, r0.length);
    }

    static JapaneseEra from(LocalDate r4) {
        if (r4.isBefore(MEIJI.since) == true) goto L13;
        JapaneseEra[] r0 = KNOWN_ERAS.get();
        int r1 = r0.length - 1;
    L5:
        if (r1 < 0) goto L10;
        JapaneseEra r2 = r0[r1];
        if (r4.compareTo(r2.since) >= 0) goto L8;
        r1 = r1 - 1;
        goto L5
    L8:
        return r2;
    L10:
        return null;
    L13:
        throw new DateTimeException("Date too early: " + r4);
    }

    LocalDate startDate() {
        return this.since;
    }

    LocalDate endDate() {
        int r2 = ordinal(this.eraValue);
        JapaneseEra[] r0 = values();
        if (r2 < (r0.length - 1)) goto L7;
        return LocalDate.MAX;
    L7:
        return r0[r2 + 1].startDate().minusDays(1);
    }

    @Override // org.threeten.bp.chrono.Era
    public int getValue() {
        return this.eraValue;
    }

    @Override // org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor, org.threeten.bp.temporal.TemporalAccessor
    public ValueRange range(TemporalField r2) {
        if (r2 != ChronoField.ERA) goto L7;
        return JapaneseChronology.INSTANCE.range(ChronoField.ERA);
    L7:
        return super.range(r2);
    }

    public String toString() {
        return this.name;
    }

    private Object writeReplace() {
        return new Ser((byte) 2, this);
    }

    void writeExternal(DataOutput r1) throws IOException {
        r1.writeByte(getValue());
    }

    static JapaneseEra readExternal(DataInput r0) throws IOException {
        return of(r0.readByte());
    }
}
