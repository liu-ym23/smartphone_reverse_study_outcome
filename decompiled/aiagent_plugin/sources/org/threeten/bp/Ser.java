package org.threeten.bp;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.Externalizable;
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
    public void writeExternal(ObjectOutput r3) {
        ObjectOutput r4 = (ObjectOutput) ZeusTransformUtils.wrapperContextForParams(r3, ObjectOutput.class, "com.obric.aiagent.plugin");
        writeInternal(this.type, this.object, r4);
    }

    static void writeInternal(byte r2, Object r3, DataOutput r4) {
        DataOutput r5 = (DataOutput) ZeusTransformUtils.wrapperContextForParams(r4, DataOutput.class, "com.obric.aiagent.plugin");
        r5.writeByte(r2);
        if (r2 == 64) goto L20;
        switch(r2) {
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
        switch(r2) {
            case 66: goto L11;
            case 67: goto L10;
            case 68: goto L9;
            case 69: goto L8;
            default: goto L7;
        };
    L8:
        ((OffsetDateTime) ZeusTransformUtils.preCheckCast(r3, OffsetDateTime.class, "com.obric.aiagent.plugin")).writeExternal(r5);
        return;
    L9:
        ((YearMonth) ZeusTransformUtils.preCheckCast(r3, YearMonth.class, "com.obric.aiagent.plugin")).writeExternal(r5);
        return;
    L10:
        ((Year) ZeusTransformUtils.preCheckCast(r3, Year.class, "com.obric.aiagent.plugin")).writeExternal(r5);
        return;
    L11:
        ((OffsetTime) ZeusTransformUtils.preCheckCast(r3, OffsetTime.class, "com.obric.aiagent.plugin")).writeExternal(r5);
        return;
    L7:
        throw new InvalidClassException("Unknown serialized type");
    L12:
        ((ZoneOffset) ZeusTransformUtils.preCheckCast(r3, ZoneOffset.class, "com.obric.aiagent.plugin")).writeExternal(r5);
        return;
    L13:
        ((ZoneRegion) ZeusTransformUtils.preCheckCast(r3, ZoneRegion.class, "com.obric.aiagent.plugin")).writeExternal(r5);
        return;
    L14:
        ((ZonedDateTime) ZeusTransformUtils.preCheckCast(r3, ZonedDateTime.class, "com.obric.aiagent.plugin")).writeExternal(r5);
        return;
    L15:
        ((LocalTime) ZeusTransformUtils.preCheckCast(r3, LocalTime.class, "com.obric.aiagent.plugin")).writeExternal(r5);
        return;
    L16:
        ((LocalDateTime) ZeusTransformUtils.preCheckCast(r3, LocalDateTime.class, "com.obric.aiagent.plugin")).writeExternal(r5);
        return;
    L17:
        ((LocalDate) ZeusTransformUtils.preCheckCast(r3, LocalDate.class, "com.obric.aiagent.plugin")).writeExternal(r5);
        return;
    L18:
        ((Instant) ZeusTransformUtils.preCheckCast(r3, Instant.class, "com.obric.aiagent.plugin")).writeExternal(r5);
        return;
    L19:
        ((Duration) ZeusTransformUtils.preCheckCast(r3, Duration.class, "com.obric.aiagent.plugin")).writeExternal(r5);
        return;
    L20:
        ((MonthDay) ZeusTransformUtils.preCheckCast(r3, MonthDay.class, "com.obric.aiagent.plugin")).writeExternal(r5);
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput r3) {
        ObjectInput r4 = (ObjectInput) ZeusTransformUtils.wrapperContextForParams(r3, ObjectInput.class, "com.obric.aiagent.plugin");
        byte r0 = r4.readByte();
        this.type = r0;
        this.object = readInternal(r0, r4);
    }

    static Object read(DataInput r2) {
        DataInput r3 = (DataInput) ZeusTransformUtils.wrapperContextForParams(r2, DataInput.class, "com.obric.aiagent.plugin");
        return readInternal(r3.readByte(), r3);
    }

    private static Object readInternal(byte r2, DataInput r3) {
        DataInput r4 = (DataInput) ZeusTransformUtils.wrapperContextForParams(r3, DataInput.class, "com.obric.aiagent.plugin");
        if (r2 == 64) goto L33;
        switch(r2) {
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
        switch(r2) {
            case 66: goto L15;
            case 67: goto L13;
            case 68: goto L11;
            case 69: goto L9;
            default: goto L7;
        };
    L7:
        throw new StreamCorruptedException("Unknown serialized type");
    L9:
        return OffsetDateTime.readExternal(r4);
    L11:
        return YearMonth.readExternal(r4);
    L13:
        return Year.readExternal(r4);
    L15:
        return OffsetTime.readExternal(r4);
    L17:
        return ZoneOffset.readExternal(r4);
    L19:
        return ZoneRegion.readExternal(r4);
    L21:
        return ZonedDateTime.readExternal(r4);
    L23:
        return LocalTime.readExternal(r4);
    L25:
        return LocalDateTime.readExternal(r4);
    L27:
        return LocalDate.readExternal(r4);
    L29:
        return Instant.readExternal(r4);
    L31:
        return Duration.readExternal(r4);
    L33:
        return MonthDay.readExternal(r4);
    }

    private Object readResolve() {
        return this.object;
    }
}
