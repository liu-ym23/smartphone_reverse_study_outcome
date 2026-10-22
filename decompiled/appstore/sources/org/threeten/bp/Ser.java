package org.threeten.bp;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.Externalizable;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.StreamCorruptedException;

/* JADX INFO: loaded from: classes4.dex */
final class Ser implements Externalizable {
    static final byte DURATION_TYPE = 1;
    static final byte INSTANT_TYPE = 2;
    static final byte LOCAL_DATE_TIME_TYPE = 4;
    static final byte LOCAL_DATE_TYPE = 3;
    static final byte LOCAL_TIME_TYPE = 5;
    static final byte MONTH_DAY_TYPE = 64;
    static final byte OFFSET_DATE_TIME_TYPE = 69;
    static final byte OFFSET_TIME_TYPE = 66;
    static final byte YEAR_MONTH_TYPE = 68;
    static final byte YEAR_TYPE = 67;
    static final byte ZONED_DATE_TIME_TYPE = 6;
    static final byte ZONE_OFFSET_TYPE = 8;
    static final byte ZONE_REGION_TYPE = 7;
    private static final long serialVersionUID = -7683839454370182990L;
    private Object object;
    private byte type;

    public Ser() {
    }

    public static Object read(DataInput r10) throws IOException {
        return readInternal(r10.readByte(), r10);
    }

    private static Object readInternal(byte r10, DataInput r11) throws IOException {
        if (r10 == 64) goto L33;
        switch(r10) {
            case 1: goto L31;
            case 2: goto L29;
            case 3: goto L27;
            case 4: goto L25;
            case 5: goto L23;
            case 6: goto L21;
            case 7: goto L19;
            case 8: goto L17;
            default: goto L5;
        };
    L5:
        switch(r10) {
            case 66: goto L15;
            case 67: goto L13;
            case 68: goto L11;
            case 69: goto L9;
            default: goto L7;
        };
    L7:
        throw new StreamCorruptedException("Unknown serialized type");
    L9:
        return OffsetDateTime.readExternal(r11);
    L11:
        return YearMonth.readExternal(r11);
    L13:
        return Year.readExternal(r11);
    L15:
        return OffsetTime.readExternal(r11);
    L17:
        return ZoneOffset.readExternal(r11);
    L19:
        return ZoneRegion.readExternal(r11);
    L21:
        return ZonedDateTime.readExternal(r11);
    L23:
        return LocalTime.readExternal(r11);
    L25:
        return LocalDateTime.readExternal(r11);
    L27:
        return LocalDate.readExternal(r11);
    L29:
        return Instant.readExternal(r11);
    L31:
        return Duration.readExternal(r11);
    L33:
        return MonthDay.readExternal(r11);
    }

    private Object readResolve() {
        return this.object;
    }

    public static void writeInternal(byte r10, Object r11, DataOutput r12) throws IOException {
        r12.writeByte(r10);
        if (r10 == 64) goto L20;
        switch(r10) {
            case 1: goto L19;
            case 2: goto L18;
            case 3: goto L17;
            case 4: goto L16;
            case 5: goto L15;
            case 6: goto L14;
            case 7: goto L13;
            case 8: goto L12;
            default: goto L5;
        };
    L5:
        switch(r10) {
            case 66: goto L11;
            case 67: goto L10;
            case 68: goto L9;
            case 69: goto L8;
            default: goto L7;
        };
    L8:
        ((OffsetDateTime) r11).writeExternal(r12);
        return;
    L9:
        ((YearMonth) r11).writeExternal(r12);
        return;
    L10:
        ((Year) r11).writeExternal(r12);
        return;
    L11:
        ((OffsetTime) r11).writeExternal(r12);
        return;
    L7:
        throw new InvalidClassException("Unknown serialized type");
    L12:
        ((ZoneOffset) r11).writeExternal(r12);
        return;
    L13:
        ((ZoneRegion) r11).writeExternal(r12);
        return;
    L14:
        ((ZonedDateTime) r11).writeExternal(r12);
        return;
    L15:
        ((LocalTime) r11).writeExternal(r12);
        return;
    L16:
        ((LocalDateTime) r11).writeExternal(r12);
        return;
    L17:
        ((LocalDate) r11).writeExternal(r12);
        return;
    L18:
        ((Instant) r11).writeExternal(r12);
        return;
    L19:
        ((Duration) r11).writeExternal(r12);
        return;
    L20:
        ((MonthDay) r11).writeExternal(r12);
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput r10) throws IOException {
        byte r11 = r10.readByte();
        this.type = r11;
        this.object = readInternal(r11, r10);
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput r10) throws IOException {
        writeInternal(this.type, this.object, r10);
    }

    public Ser(byte r10, Object r11) {
        this.type = r10;
        this.object = r11;
    }
}
