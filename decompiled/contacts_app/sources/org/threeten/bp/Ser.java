package org.threeten.bp;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.Externalizable;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.StreamCorruptedException;

/* JADX INFO: loaded from: classes5.dex */
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

    Ser(byte r1, Object r2) {
        this.type = r1;
        this.object = r2;
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput r2) throws IOException {
        writeInternal(this.type, this.object, r2);
    }

    static void writeInternal(byte r1, Object r2, DataOutput r3) throws IOException {
        r3.writeByte(r1);
        if (r1 == 64) goto L20;
        switch(r1) {
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
        switch(r1) {
            case 66: goto L11;
            case 67: goto L10;
            case 68: goto L9;
            case 69: goto L8;
            default: goto L7;
        };
    L8:
        ((OffsetDateTime) r2).writeExternal(r3);
        return;
    L9:
        ((YearMonth) r2).writeExternal(r3);
        return;
    L10:
        ((Year) r2).writeExternal(r3);
        return;
    L11:
        ((OffsetTime) r2).writeExternal(r3);
        return;
    L7:
        throw new InvalidClassException("Unknown serialized type");
    L12:
        ((ZoneOffset) r2).writeExternal(r3);
        return;
    L13:
        ((ZoneRegion) r2).writeExternal(r3);
        return;
    L14:
        ((ZonedDateTime) r2).writeExternal(r3);
        return;
    L15:
        ((LocalTime) r2).writeExternal(r3);
        return;
    L16:
        ((LocalDateTime) r2).writeExternal(r3);
        return;
    L17:
        ((LocalDate) r2).writeExternal(r3);
        return;
    L18:
        ((Instant) r2).writeExternal(r3);
        return;
    L19:
        ((Duration) r2).writeExternal(r3);
        return;
    L20:
        ((MonthDay) r2).writeExternal(r3);
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput r2) throws IOException {
        byte r0 = r2.readByte();
        this.type = r0;
        this.object = readInternal(r0, r2);
    }

    static Object read(DataInput r1) throws IOException {
        return readInternal(r1.readByte(), r1);
    }

    private static Object readInternal(byte r1, DataInput r2) throws IOException {
        if (r1 == 64) goto L33;
        switch(r1) {
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
        switch(r1) {
            case 66: goto L15;
            case 67: goto L13;
            case 68: goto L11;
            case 69: goto L9;
            default: goto L7;
        };
    L7:
        throw new StreamCorruptedException("Unknown serialized type");
    L9:
        return OffsetDateTime.readExternal(r2);
    L11:
        return YearMonth.readExternal(r2);
    L13:
        return Year.readExternal(r2);
    L15:
        return OffsetTime.readExternal(r2);
    L17:
        return ZoneOffset.readExternal(r2);
    L19:
        return ZoneRegion.readExternal(r2);
    L21:
        return ZonedDateTime.readExternal(r2);
    L23:
        return LocalTime.readExternal(r2);
    L25:
        return LocalDateTime.readExternal(r2);
    L27:
        return LocalDate.readExternal(r2);
    L29:
        return Instant.readExternal(r2);
    L31:
        return Duration.readExternal(r2);
    L33:
        return MonthDay.readExternal(r2);
    }

    private Object readResolve() {
        return this.object;
    }
}
