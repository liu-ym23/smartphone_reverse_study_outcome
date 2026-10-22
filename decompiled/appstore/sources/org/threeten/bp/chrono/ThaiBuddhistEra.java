package org.threeten.bp.chrono;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Locale;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.format.DateTimeFormatterBuilder;
import org.threeten.bp.format.TextStyle;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQuery;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;

/* JADX INFO: loaded from: classes4.dex */
public final enum ThaiBuddhistEra extends Enum<ThaiBuddhistEra> implements Era {
    private static final /* synthetic */ ThaiBuddhistEra[] $VALUES = null;
    public static final ThaiBuddhistEra BE = null;
    public static final ThaiBuddhistEra BEFORE_BE = null;

    static {
        ThaiBuddhistEra r10 = new ThaiBuddhistEra("BEFORE_BE", 0);
        BEFORE_BE = r10;
        ThaiBuddhistEra r11 = new ThaiBuddhistEra("BE", 1);
        BE = r11;
        $VALUES = new ThaiBuddhistEra[]{r10, r11};
    }

    private ThaiBuddhistEra(String r10, int r11) {
        super(r10, r11);
    }

    public static ThaiBuddhistEra of(int r10) {
        if (r10 == 0) goto L10;
        if (r10 != 1) goto L8;
        return BE;
    L8:
        throw new DateTimeException("Era is not valid for ThaiBuddhistEra");
    L10:
        return BEFORE_BE;
    }

    public static ThaiBuddhistEra readExternal(DataInput r10) throws IOException {
        return of(r10.readByte());
    }

    public static ThaiBuddhistEra valueOf(String r10) {
        return (ThaiBuddhistEra) Enum.valueOf(ThaiBuddhistEra.class, r10);
    }

    public static ThaiBuddhistEra[] values() {
        return (ThaiBuddhistEra[]) $VALUES.clone();
    }

    private Object writeReplace() {
        return new Ser((byte) 8, this);
    }

    @Override // org.threeten.bp.temporal.TemporalAdjuster
    public Temporal adjustInto(Temporal r10) {
        return r10.with(ChronoField.ERA, getValue());
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public int get(TemporalField r10) {
        if (r10 != ChronoField.ERA) goto L7;
        return getValue();
    L7:
        return range(r10).checkValidIntValue(getLong(r10), r10);
    }

    @Override // org.threeten.bp.chrono.Era
    public String getDisplayName(TextStyle r10, Locale r11) {
        return new DateTimeFormatterBuilder().m(ChronoField.ERA, r10).F(r11).d(this);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public long getLong(TemporalField r10) {
        if (r10 != ChronoField.ERA) goto L7;
        return getValue();
    L7:
        if ((r10 instanceof ChronoField) == true) goto L11;
        return r10.getFrom(this);
    L11:
        throw new UnsupportedTemporalTypeException("Unsupported field: " + r10);
    }

    @Override // org.threeten.bp.chrono.Era
    public int getValue() {
        return ordinal();
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public boolean isSupported(TemporalField r10) {
        if ((r10 instanceof ChronoField) == true) goto L5;
        if (r10 != null) goto L10;
        return false;
    L10:
        if (r10.isSupportedBy(this) == true) goto L12;
        return false;
    L12:
        return true;
    L5:
        if (r10 == ChronoField.ERA) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public <R> R query(TemporalQuery<R> r10) {
        if (r10 != org.threeten.bp.temporal.b.e()) goto L7;
        return (R) ChronoUnit.ERAS;
    L7:
        if (r10 != org.threeten.bp.temporal.b.a()) goto L9;
        return null;
    L9:
        if (r10 != org.threeten.bp.temporal.b.f()) goto L11;
        return null;
    L11:
        if (r10 != org.threeten.bp.temporal.b.g()) goto L13;
        return null;
    L13:
        if (r10 != org.threeten.bp.temporal.b.d()) goto L15;
        return null;
    L15:
        if (r10 != org.threeten.bp.temporal.b.b()) goto L17;
        return null;
    L17:
        if (r10 != org.threeten.bp.temporal.b.c()) goto L20;
        return null;
    L20:
        return r10.queryFrom(this);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public ValueRange range(TemporalField r10) {
        if (r10 != ChronoField.ERA) goto L7;
        return r10.range();
    L7:
        if ((r10 instanceof ChronoField) == true) goto L11;
        return r10.rangeRefinedBy(this);
    L11:
        throw new UnsupportedTemporalTypeException("Unsupported field: " + r10);
    }

    public void writeExternal(DataOutput r10) throws IOException {
        r10.writeByte(getValue());
    }
}
