package org.apache.commons.compress.compressors.snappy;

import com.android.server.usb.descriptors.UsbDescriptor;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.compress.compressors.lz77support.AbstractLZ77CompressorInputStream;
import org.apache.commons.compress.utils.ByteUtils;

/* JADX INFO: loaded from: classes3.dex */
public class SnappyCompressorInputStream extends AbstractLZ77CompressorInputStream {
    public static final int DEFAULT_BLOCK_SIZE = 32768;
    private static final int TAG_MASK = 3;
    private boolean endReached;
    private final int size;
    private State state;
    private int uncompressedBytesRemaining;

    private static final enum State extends Enum<State> {
        private static final /* synthetic */ State[] $VALUES = null;
        public static final State IN_BACK_REFERENCE = null;
        public static final State IN_LITERAL = null;
        public static final State NO_BLOCK = null;

        private static /* synthetic */ State[] $values() {
            return new State[]{NO_BLOCK, IN_LITERAL, IN_BACK_REFERENCE};
        }

        private State(String r1, int r2) {
            super(r1, r2);
        }

        public static State valueOf(String name) {
            return (State) Enum.valueOf(State.class, name);
        }

        public static State[] values() {
            return (State[]) $VALUES.clone();
        }

        static {
            NO_BLOCK = new State("NO_BLOCK", 0);
            IN_LITERAL = new State("IN_LITERAL", 1);
            IN_BACK_REFERENCE = new State("IN_BACK_REFERENCE", 2);
            $VALUES = $values();
        }
    }

    public SnappyCompressorInputStream(InputStream is) throws IOException {
        this(is, 32768);
    }

    public SnappyCompressorInputStream(InputStream is, int blockSize) throws IOException {
        super(is, blockSize);
        this.state = State.NO_BLOCK;
        this.endReached = false;
        int r0 = (int) readSize();
        this.size = r0;
        this.uncompressedBytesRemaining = r0;
    }

    @Override // java.io.InputStream
    public int read(byte[] b, int off, int len) throws IOException {
        if (this.endReached == false) goto L7;
        return -1;
    L7:
        switch(this.state.ordinal()) {
            case 0: goto L24;
            case 1: goto L17;
            case 2: goto L10;
            default: goto L9;
        };
    L10:
        int backReferenceLen = readBackReference(b, off, len);
        if (hasMoreDataInBlock() == true) goto L13;
        this.state = State.NO_BLOCK;
    L13:
        if (backReferenceLen <= 0) goto L16;
        return backReferenceLen;
    L16:
        return read(b, off, len);
    L17:
        int litLen = readLiteral(b, off, len);
        if (hasMoreDataInBlock() == true) goto L20;
        this.state = State.NO_BLOCK;
    L20:
        if (litLen <= 0) goto L23;
        return litLen;
    L23:
        return read(b, off, len);
    L24:
        fill();
        return read(b, off, len);
    L9:
        throw new IOException("Unknown stream state " + this.state);
    }

    private void fill() throws IOException {
        if (this.uncompressedBytesRemaining != 0) goto L6;
        this.endReached = true;
        return;
    L6:
        int b = readOneByte();
        if (b == (-1)) goto L21;
        switch((b & 3)) {
            case 0: goto L18;
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            default: goto L25;
        };
    L11:
        int length = (b >> 2) + 1;
        this.uncompressedBytesRemaining -= length;
        int offset = ((int) ByteUtils.fromLittleEndian(this.supplier, 4)) & Integer.MAX_VALUE;
        startBackReference(offset, length);
        this.state = State.IN_BACK_REFERENCE;
        return;
    L12:
        int length2 = (b >> 2) + 1;
        this.uncompressedBytesRemaining -= length2;
        int offset2 = (int) ByteUtils.fromLittleEndian(this.supplier, 2);
        startBackReference(offset2, length2);
        this.state = State.IN_BACK_REFERENCE;
        return;
    L13:
        int length3 = ((b >> 2) & 7) + 4;
        this.uncompressedBytesRemaining -= length3;
        int offset3 = (b & UsbDescriptor.CLASSID_WIRELESS) << 3;
        int b2 = readOneByte();
        if (b2 == (-1)) goto L17;
        startBackReference(offset3 | b2, length3);
        this.state = State.IN_BACK_REFERENCE;
        return;
    L17:
        throw new IOException("Premature end of stream reading back-reference length");
    L18:
        int length4 = readLiteralLength(b);
        this.uncompressedBytesRemaining -= length4;
        startLiteral(length4);
        this.state = State.IN_LITERAL;
        return;
    L25:
        return;
    L21:
        throw new IOException("Premature end of stream reading block start");
    }

    private int readLiteralLength(int b) throws IOException {
        switch((b >> 2)) {
            case 60: goto L8;
            case 61: goto L7;
            case 62: goto L6;
            case 63: goto L5;
            default: goto L4;
        };
    L4:
        int length = b >> 2;
    L11:
        return length + 1;
    L5:
        length = (int) ByteUtils.fromLittleEndian(this.supplier, 4);
        goto L11
    L6:
        length = (int) ByteUtils.fromLittleEndian(this.supplier, 3);
        goto L11
    L7:
        length = (int) ByteUtils.fromLittleEndian(this.supplier, 2);
        goto L11
    L8:
        length = readOneByte();
        if (length != (-1)) goto L11;
        throw new IOException("Premature end of stream reading literal length");
    }

    private long readSize() throws IOException {
        int index = 0;
        long sz = 0;
    L3:
        int b = readOneByte();
        if (b == (-1)) goto L10;
        int index2 = index + 1;
        sz = sz | ((long) ((b & 127) << (index * 7)));
        if ((b & 128) == 0) goto L7;
        index = index2;
        goto L3
    L7:
        return sz;
    L10:
        throw new IOException("Premature end of stream reading size");
    }

    @Override // org.apache.commons.compress.compressors.lz77support.AbstractLZ77CompressorInputStream
    public int getSize() {
        return this.size;
    }
}
