package org.threeten.bp.chrono;

import java.io.Externalizable;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.StreamCorruptedException;

/* JADX INFO: loaded from: classes5.dex */
final class Ser implements Externalizable {
    static final byte CHRONO_LOCALDATETIME_TYPE = 12;
    static final byte CHRONO_TYPE = 11;
    static final byte CHRONO_ZONEDDATETIME_TYPE = 13;
    static final byte HIJRAH_DATE_TYPE = 3;
    static final byte HIJRAH_ERA_TYPE = 4;
    static final byte JAPANESE_DATE_TYPE = 1;
    static final byte JAPANESE_ERA_TYPE = 2;
    static final byte MINGUO_DATE_TYPE = 5;
    static final byte MINGUO_ERA_TYPE = 6;
    static final byte THAIBUDDHIST_DATE_TYPE = 7;
    static final byte THAIBUDDHIST_ERA_TYPE = 8;
    private static final long serialVersionUID = 7857518227608961174L;
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

    private static void writeInternal(byte r0, Object r1, ObjectOutput r2) throws IOException {
        r2.writeByte(r0);
        switch(r0) {
            case 1: goto L16;
            case 2: goto L15;
            case 3: goto L14;
            case 4: goto L13;
            case 5: goto L12;
            case 6: goto L11;
            case 7: goto L10;
            case 8: goto L9;
            case 9: goto L5;
            case 10: goto L5;
            case 11: goto L8;
            case 12: goto L7;
            case 13: goto L6;
            default: goto L5;
        };
    L6:
        ((ChronoZonedDateTimeImpl) r1).writeExternal(r2);
        return;
    L7:
        ((ChronoLocalDateTimeImpl) r1).writeExternal(r2);
        return;
    L8:
        ((Chronology) r1).writeExternal(r2);
        return;
    L9:
        ((ThaiBuddhistEra) r1).writeExternal(r2);
        return;
    L10:
        ((ThaiBuddhistDate) r1).writeExternal(r2);
        return;
    L11:
        ((MinguoEra) r1).writeExternal(r2);
        return;
    L12:
        ((MinguoDate) r1).writeExternal(r2);
        return;
    L13:
        ((HijrahEra) r1).writeExternal(r2);
        return;
    L14:
        ((HijrahDate) r1).writeExternal(r2);
        return;
    L15:
        ((JapaneseEra) r1).writeExternal(r2);
        return;
    L16:
        ((JapaneseDate) r1).writeExternal(r2);
        return;
    L5:
        throw new InvalidClassException("Unknown serialized type");
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput r2) throws IOException, ClassNotFoundException {
        byte r0 = r2.readByte();
        this.type = r0;
        this.object = readInternal(r0, r2);
    }

    static Object read(ObjectInput r1) throws IOException, ClassNotFoundException {
        return readInternal(r1.readByte(), r1);
    }

    private static Object readInternal(byte r0, ObjectInput r1) throws IOException, ClassNotFoundException {
        switch(r0) {
            case 1: goto L26;
            case 2: goto L24;
            case 3: goto L22;
            case 4: goto L20;
            case 5: goto L18;
            case 6: goto L16;
            case 7: goto L14;
            case 8: goto L12;
            case 9: goto L4;
            case 10: goto L4;
            case 11: goto L10;
            case 12: goto L8;
            case 13: goto L6;
            default: goto L4;
        };
    L4:
        throw new StreamCorruptedException("Unknown serialized type");
    L6:
        return ChronoZonedDateTimeImpl.readExternal(r1);
    L8:
        return ChronoLocalDateTimeImpl.readExternal(r1);
    L10:
        return Chronology.readExternal(r1);
    L12:
        return ThaiBuddhistEra.readExternal(r1);
    L14:
        return ThaiBuddhistDate.readExternal(r1);
    L16:
        return MinguoEra.readExternal(r1);
    L18:
        return MinguoDate.readExternal(r1);
    L20:
        return HijrahEra.readExternal(r1);
    L22:
        return HijrahDate.readExternal(r1);
    L24:
        return JapaneseEra.readExternal(r1);
    L26:
        return JapaneseDate.readExternal(r1);
    }

    private Object readResolve() {
        return this.object;
    }
}
