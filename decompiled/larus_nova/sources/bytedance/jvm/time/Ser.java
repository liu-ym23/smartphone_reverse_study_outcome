package bytedance.jvm.time;

import java.io.Externalizable;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.StreamCorruptedException;

/* JADX INFO: loaded from: classes28.dex */
final class Ser implements Externalizable {
    static final byte DURATION_TYPE = 1;
    static final byte INSTANT_TYPE = 2;
    static final byte LOCAL_DATE_TIME_TYPE = 5;
    static final byte LOCAL_DATE_TYPE = 3;
    static final byte LOCAL_TIME_TYPE = 4;
    static final byte MONTH_DAY_TYPE = 13;
    static final byte OFFSET_DATE_TIME_TYPE = 10;
    static final byte OFFSET_TIME_TYPE = 9;
    static final byte PERIOD_TYPE = 14;
    static final byte YEAR_MONTH_TYPE = 12;
    static final byte YEAR_TYPE = 11;
    static final byte ZONE_DATE_TIME_TYPE = 6;
    static final byte ZONE_OFFSET_TYPE = 8;
    static final byte ZONE_REGION_TYPE = 7;
    private static final long serialVersionUID = -7683839454370182990L;
    private Object object;
    private byte type;

    public Ser() {
    }

    private Object readResolve() {
        return this.object;
    }

    public static Object read(ObjectInput r100) throws IOException, ClassNotFoundException {
        return a(r100.readByte(), r100);
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput r100) throws IOException, ClassNotFoundException {
        byte r101 = r100.readByte();
        this.type = r101;
        this.object = a(r101, r100);
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput r100) throws IOException {
        writeInternal(this.type, this.object, r100);
    }

    public Ser(byte r100, Object r101) {
        this.type = r100;
        this.object = r101;
    }

    public static Object a(byte r100, ObjectInput r101) throws IOException, ClassNotFoundException {
        switch(r100) {
            case 1: goto L32;
            case 2: goto L30;
            case 3: goto L28;
            case 4: goto L26;
            case 5: goto L24;
            case 6: goto L22;
            case 7: goto L20;
            case 8: goto L18;
            case 9: goto L16;
            case 10: goto L14;
            case 11: goto L12;
            case 12: goto L10;
            case 13: goto L8;
            case 14: goto L6;
            default: goto L4;
        };
    L4:
        throw new StreamCorruptedException("Unknown serialized type");
    L6:
        return Period.readExternal(r101);
    L8:
        return MonthDay.readExternal(r101);
    L10:
        return YearMonth.readExternal(r101);
    L12:
        return Year.readExternal(r101);
    L14:
        return OffsetDateTime.readExternal(r101);
    L16:
        return OffsetTime.readExternal(r101);
    L18:
        return ZoneOffset.readExternal(r101);
    L20:
        return ZoneRegion.readExternal(r101);
    L22:
        return ZonedDateTime.readExternal(r101);
    L24:
        return LocalDateTime.readExternal(r101);
    L26:
        return LocalTime.readExternal(r101);
    L28:
        return LocalDate.readExternal(r101);
    L30:
        return Instant.readExternal(r101);
    L32:
        return Duration.readExternal(r101);
    }

    public static void writeInternal(byte r100, Object r101, ObjectOutput r102) throws IOException {
        r102.writeByte(r100);
        switch(r100) {
            case 1: goto L19;
            case 2: goto L18;
            case 3: goto L17;
            case 4: goto L16;
            case 5: goto L15;
            case 6: goto L14;
            case 7: goto L13;
            case 8: goto L12;
            case 9: goto L11;
            case 10: goto L10;
            case 11: goto L9;
            case 12: goto L8;
            case 13: goto L7;
            case 14: goto L6;
            default: goto L5;
        };
    L6:
        ((Period) r101).writeExternal(r102);
        return;
    L7:
        ((MonthDay) r101).writeExternal(r102);
        return;
    L8:
        ((YearMonth) r101).writeExternal(r102);
        return;
    L9:
        ((Year) r101).writeExternal(r102);
        return;
    L10:
        ((OffsetDateTime) r101).writeExternal(r102);
        return;
    L11:
        ((OffsetTime) r101).writeExternal(r102);
        return;
    L12:
        ((ZoneOffset) r101).writeExternal(r102);
        return;
    L13:
        ((ZoneRegion) r101).writeExternal(r102);
        return;
    L14:
        ((ZonedDateTime) r101).writeExternal(r102);
        return;
    L15:
        ((LocalDateTime) r101).writeExternal(r102);
        return;
    L16:
        ((LocalTime) r101).writeExternal(r102);
        return;
    L17:
        ((LocalDate) r101).writeExternal(r102);
        return;
    L18:
        ((Instant) r101).writeExternal(r102);
        return;
    L19:
        ((Duration) r101).writeExternal(r102);
        return;
    L5:
        throw new InvalidClassException("Unknown serialized type");
    }
}
