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
public final enum HijrahEra extends Enum<HijrahEra> implements Era {
    private static final /* synthetic */ HijrahEra[] $VALUES = null;
    public static final HijrahEra AH = null;
    public static final HijrahEra BEFORE_AH = null;

    static {
        HijrahEra r10 = new HijrahEra("BEFORE_AH", 0);
        BEFORE_AH = r10;
        HijrahEra r11 = new HijrahEra("AH", 1);
        AH = r11;
        $VALUES = new HijrahEra[]{r10, r11};
    }

    private HijrahEra(String r10, int r11) {
        super(r10, r11);
    }

    public static HijrahEra of(int r10) {
        if (r10 == 0) goto L10;
        if (r10 != 1) goto L8;
        return AH;
    L8:
        throw new DateTimeException("HijrahEra not valid");
    L10:
        return BEFORE_AH;
    }

    public static HijrahEra readExternal(DataInput r10) throws IOException {
        return of(r10.readByte());
    }

    public static HijrahEra valueOf(String r10) {
        return (HijrahEra) Enum.valueOf(HijrahEra.class, r10);
    }

    public static HijrahEra[] values() {
        return (HijrahEra[]) $VALUES.clone();
    }

    private Object writeReplace() {
        return new Ser((byte) 4, this);
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

    public int prolepticYear(int r10) {
        if (this != AH) goto L6;
        return r10;
    L6:
        return 1 - r10;
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
        return ValueRange.of(1, 1);
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
