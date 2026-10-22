package org.threeten.bp.zone;

import com.google.common.primitives.UnsignedBytes;
import com.ttnet.org.chromium.net.PrivateKeyType;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.Externalizable;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.StreamCorruptedException;
import org.threeten.bp.ZoneOffset;

/* JADX INFO: loaded from: classes4.dex */
final class Ser implements Externalizable {
    static final byte SZR = 1;
    static final byte ZOT = 2;
    static final byte ZOTRULE = 3;
    private static final long serialVersionUID = -8885321777449118786L;
    private Object object;
    private byte type;

    public Ser() {
    }

    public static Object read(DataInput r10) throws IOException, ClassNotFoundException {
        return readInternal(r10.readByte(), r10);
    }

    public static long readEpochSec(DataInput r10) throws IOException {
        int r11 = r10.readByte() & UnsignedBytes.MAX_VALUE;
        if (r11 == 255) goto L5;
        int r12 = r10.readByte() & UnsignedBytes.MAX_VALUE;
        int r13 = (r11 << 16) + (r12 << 8);
        return (((long) (r13 + (r10.readByte() & UnsignedBytes.MAX_VALUE))) * 900) - 4575744000L;
    L5:
        return r10.readLong();
    }

    private static Object readInternal(byte r10, DataInput r11) throws IOException, ClassNotFoundException {
        if (r10 == 1) goto L15;
        if (r10 == 2) goto L13;
        if (r10 != 3) goto L11;
        return ZoneOffsetTransitionRule.readExternal(r11);
    L11:
        throw new StreamCorruptedException("Unknown serialized type");
    L13:
        return ZoneOffsetTransition.readExternal(r11);
    L15:
        return StandardZoneRules.readExternal(r11);
    }

    public static ZoneOffset readOffset(DataInput r10) throws IOException {
        byte r11 = r10.readByte();
        if (r11 != 127) goto L6;
        return ZoneOffset.ofTotalSeconds(r10.readInt());
    L6:
        return ZoneOffset.ofTotalSeconds(r11 * 900);
    }

    private Object readResolve() {
        return this.object;
    }

    public static void write(Object r10, DataOutput r11) throws IOException {
        writeInternal((byte) 1, r10, r11);
    }

    public static void writeEpochSec(long r10, DataOutput r11) throws IOException {
        if (r10 >= (-4575744000L)) goto L5;
    L9:
        r11.writeByte(PrivateKeyType.INVALID);
        r11.writeLong(r10);
        return;
    L5:
        if (r10 >= 10413792000L) goto L9;
        if ((r10 % 900) != 0) goto L9;
        int r12 = (int) ((r10 + 4575744000L) / 900);
        r11.writeByte((r12 >>> 16) & PrivateKeyType.INVALID);
        r11.writeByte((r12 >>> 8) & PrivateKeyType.INVALID);
        r11.writeByte(r12 & PrivateKeyType.INVALID);
    }

    private static void writeInternal(byte r10, Object r11, DataOutput r12) throws IOException {
        r12.writeByte(r10);
        if (r10 != 1) goto L5;
        ((StandardZoneRules) r11).writeExternal(r12);
        return;
    L5:
        if (r10 != 2) goto L7;
        ((ZoneOffsetTransition) r11).writeExternal(r12);
        return;
    L7:
        if (r10 != 3) goto L10;
        ((ZoneOffsetTransitionRule) r11).writeExternal(r12);
        return;
    L10:
        throw new InvalidClassException("Unknown serialized type");
    }

    public static void writeOffset(ZoneOffset r10, DataOutput r11) throws IOException {
        int r12 = r10.getTotalSeconds();
        if ((r12 % 900) != 0) goto L5;
        int r13 = r12 / 900;
    L6:
        r11.writeByte(r13);
        if (r13 != 127) goto L10;
        r11.writeInt(r12);
        return;
    L10:
        return;
    L5:
        r13 = 127;
        goto L6
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput r10) throws IOException, ClassNotFoundException {
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
