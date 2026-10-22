package org.apache.commons.compress.compressors.lz4;

import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.compress.compressors.lz77support.AbstractLZ77CompressorInputStream;
import org.apache.commons.compress.utils.ByteUtils;

/* JADX INFO: loaded from: classes3.dex */
public class BlockLZ4CompressorInputStream extends AbstractLZ77CompressorInputStream {
    static final int BACK_REFERENCE_SIZE_MASK = 15;
    static final int LITERAL_SIZE_MASK = 240;
    static final int SIZE_BITS = 4;
    static final int WINDOW_SIZE = 65536;
    private int nextBackReferenceSize;
    private State state;

    private static final enum State extends Enum<State> {
        private static final /* synthetic */ State[] $VALUES = null;
        public static final State EOF = null;
        public static final State IN_BACK_REFERENCE = null;
        public static final State IN_LITERAL = null;
        public static final State LOOKING_FOR_BACK_REFERENCE = null;
        public static final State NO_BLOCK = null;

        private static /* synthetic */ State[] $values() {
            return new State[]{NO_BLOCK, IN_LITERAL, LOOKING_FOR_BACK_REFERENCE, IN_BACK_REFERENCE, EOF};
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
            LOOKING_FOR_BACK_REFERENCE = new State("LOOKING_FOR_BACK_REFERENCE", 2);
            IN_BACK_REFERENCE = new State("IN_BACK_REFERENCE", 3);
            EOF = new State("EOF", 4);
            $VALUES = $values();
        }
    }

    public BlockLZ4CompressorInputStream(InputStream is) throws IOException {
        super(is, 65536);
        this.state = State.NO_BLOCK;
    }

    @Override // java.io.InputStream
    public int read(byte[] b, int off, int len) throws IOException {
        switch(this.state.ordinal()) {
            case 0: goto L18;
            case 1: goto L19;
            case 2: goto L8;
            case 3: goto L11;
            case 4: goto L6;
            default: goto L5;
        };
    L6:
        return -1;
    L11:
        int backReferenceLen = readBackReference(b, off, len);
        if (hasMoreDataInBlock() == true) goto L14;
        this.state = State.NO_BLOCK;
    L14:
        if (backReferenceLen <= 0) goto L17;
        return backReferenceLen;
    L17:
        return read(b, off, len);
    L18:
        readSizes();
    L19:
        int litLen = readLiteral(b, off, len);
        if (hasMoreDataInBlock() == true) goto L22;
        this.state = State.LOOKING_FOR_BACK_REFERENCE;
    L22:
        if (litLen <= 0) goto L25;
        return litLen;
    L25:
        return read(b, off, len);
    L5:
        throw new IOException("Unknown stream state " + this.state);
    L8:
        if (initializeBackReference() == true) goto L11;
        this.state = State.EOF;
        return -1;
    }

    private void readSizes() throws IOException {
        int nextBlock = readOneByte();
        if (nextBlock == (-1)) goto L10;
        this.nextBackReferenceSize = nextBlock & 15;
        long literalSizePart = (nextBlock & 240) >> 4;
        if (literalSizePart != 15) goto L7;
        literalSizePart = literalSizePart + readSizeBytes();
    L7:
        startLiteral(literalSizePart);
        this.state = State.IN_LITERAL;
        return;
    L10:
        throw new IOException("Premature end of stream while looking for next block");
    }

    private long readSizeBytes() throws IOException {
        long accum = 0;
    L3:
        int nextByte = readOneByte();
        if (nextByte == (-1)) goto L9;
        accum = accum + ((long) nextByte);
        if (nextByte == 255) goto L3;
        return accum;
    L9:
        throw new IOException("Premature end of stream while parsing length");
    }

    private boolean initializeBackReference() throws IOException {
        int backReferenceOffset = (int) ByteUtils.fromLittleEndian(this.supplier, 2);
        long backReferenceSize = this.nextBackReferenceSize;
        if (this.nextBackReferenceSize != 15) goto L7;
        backReferenceSize = backReferenceSize + readSizeBytes();
    L7:
        startBackReference(backReferenceOffset, 4 + backReferenceSize);
        this.state = State.IN_BACK_REFERENCE;
        return true;
    L9:
        ex = move-exception;
        if (this.nextBackReferenceSize != 0) goto L14;
        return false;
    L14:
        throw ex;
    }
}
