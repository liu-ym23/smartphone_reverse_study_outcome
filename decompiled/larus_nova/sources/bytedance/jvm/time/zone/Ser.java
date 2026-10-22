package bytedance.jvm.time.zone;

import bytedance.jvm.time.ZoneOffset;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.Externalizable;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.StreamCorruptedException;
import kotlin.UByte;

/* JADX INFO: loaded from: classes28.dex */
final class Ser implements Externalizable {
    static final byte TZRULES = 100;
    static final byte ZOT = 2;
    static final byte ZOTRULE = 3;
    static final byte ZRULES = 1;
    private static final long serialVersionUID = -8885321777449118786L;
    private Object object;
    private byte type;

    public Ser() {
    }

    private Object readResolve() {
        return this.object;
    }

    public static Object read(DataInput r100) throws IOException, ClassNotFoundException {
        return a(r100.readByte(), r100);
    }

    public static long readEpochSec(DataInput r100) throws IOException {
        int r101 = r100.readByte() & UByte.MAX_VALUE;
        if (r101 == 255) goto L5;
        int r102 = r100.readByte() & UByte.MAX_VALUE;
        int r103 = (r101 << 16) + (r102 << 8);
        return (((long) (r103 + (r100.readByte() & UByte.MAX_VALUE))) * 900) - 4575744000L;
    L5:
        return r100.readLong();
    }

    public static ZoneOffset readOffset(DataInput r100) throws IOException {
        byte r101 = r100.readByte();
        if (r101 != 127) goto L6;
        return ZoneOffset.ofTotalSeconds(r100.readInt());
    L6:
        return ZoneOffset.ofTotalSeconds(r101 * 900);
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput r100) throws IOException, ClassNotFoundException {
        byte r101 = r100.readByte();
        this.type = r101;
        this.object = a(r101, r100);
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput r100) throws IOException {
        b(this.type, this.object, r100);
    }

    public Ser(byte r100, Object r101) {
        this.type = r100;
        this.object = r101;
    }

    public static Object a(byte r100, DataInput r101) throws IOException, ClassNotFoundException {
        if (r100 == 1) goto L19;
        if (r100 == 2) goto L17;
        if (r100 == 3) goto L15;
        if (r100 != 100) goto L13;
        return ZoneRules.readExternalTimeZone(r101);
    L13:
        throw new StreamCorruptedException("Unknown serialized type");
    L15:
        return ZoneOffsetTransitionRule.readExternal(r101);
    L17:
        return ZoneOffsetTransition.readExternal(r101);
    L19:
        return ZoneRules.readExternal(r101);
    }

    public static void write(Object r100, DataOutput r101) throws IOException {
        b((byte) 1, r100, r101);
    }

    public static void writeEpochSec(long r100, DataOutput r110) throws IOException {
        if (r100 >= (-4575744000L)) goto L5;
    L9:
        r110.writeByte(255);
        r110.writeLong(r100);
        return;
    L5:
        if (r100 >= 10413792000L) goto L9;
        if ((r100 % 900) != 0) goto L9;
        int r101 = (int) ((r100 + 4575744000L) / 900);
        r110.writeByte((r101 >>> 16) & 255);
        r110.writeByte((r101 >>> 8) & 255);
        r110.writeByte(r101 & 255);
    }

    public static void writeOffset(ZoneOffset r100, DataOutput r101) throws IOException {
        int r102 = r100.getTotalSeconds();
        if ((r102 % 900) != 0) goto L5;
        int r103 = r102 / 900;
    L6:
        r101.writeByte(r103);
        if (r103 != 127) goto L10;
        r101.writeInt(r102);
        return;
    L10:
        return;
    L5:
        r103 = 127;
        goto L6
    }

    public static void b(byte r100, Object r101, DataOutput r102) throws IOException {
        r102.writeByte(r100);
        if (r100 != 1) goto L5;
        ((ZoneRules) r101).writeExternal(r102);
        return;
    L5:
        if (r100 != 2) goto L7;
        ((ZoneOffsetTransition) r101).writeExternal(r102);
        return;
    L7:
        if (r100 != 3) goto L9;
        ((ZoneOffsetTransitionRule) r101).writeExternal(r102);
        return;
    L9:
        if (r100 != 100) goto L12;
        ((ZoneRules) r101).writeExternalTimeZone(r102);
        return;
    L12:
        throw new InvalidClassException("Unknown serialized type");
    }
}
