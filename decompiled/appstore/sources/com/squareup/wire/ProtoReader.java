package com.squareup.wire;

import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import okio.BufferedSource;
import okio.ByteString;

/* JADX INFO: loaded from: classes4.dex */
public final class ProtoReader {
    private static final int FIELD_ENCODING_MASK = 7;
    private static final int RECURSION_LIMIT = 65;
    private static final int STATE_END_GROUP = 4;
    private static final int STATE_FIXED32 = 5;
    private static final int STATE_FIXED64 = 1;
    private static final int STATE_LENGTH_DELIMITED = 2;
    private static final int STATE_PACKED_TAG = 7;
    private static final int STATE_START_GROUP = 3;
    private static final int STATE_TAG = 6;
    private static final int STATE_VARINT = 0;
    static final int TAG_FIELD_ENCODING_BITS = 3;
    private long limit;
    private FieldEncoding nextFieldEncoding;
    private long pos;
    private long pushedLimit;
    private int recursionDepth;
    private final BufferedSource source;
    private int state;
    private int tag;

    public ProtoReader(BufferedSource r10) {
        this.pos = 0;
        this.limit = Long.MAX_VALUE;
        this.state = 2;
        this.tag = -1;
        this.pushedLimit = -1;
        this.source = r10;
    }

    private void afterPackableScalar(int r10) throws IOException {
        if (this.state != r10) goto L5;
        this.state = 6;
        return;
    L5:
        long r11 = this.pos;
        long r12 = this.limit;
        if (r11 > r12) goto L13;
        if (r11 != r12) goto L10;
        this.limit = this.pushedLimit;
        this.pushedLimit = -1;
        this.state = 6;
        return;
    L10:
        this.state = 7;
        return;
    L13:
        throw new IOException("Expected to end at " + this.limit + " but was " + this.pos);
    }

    private long beforeLengthDelimitedScalar() throws IOException {
        if (this.state != 2) goto L7;
        long r10 = this.limit - this.pos;
        this.source.require(r10);
        this.state = 6;
        this.pos = this.limit;
        this.limit = this.pushedLimit;
        this.pushedLimit = -1;
        return r10;
    L7:
        throw new ProtocolException("Expected LENGTH_DELIMITED but was " + this.state);
    }

    private int internalReadVarint32() throws IOException {
        this.source.require(1);
        this.pos++;
        byte r10 = this.source.readByte();
        if (r10 < 0) goto L5;
        return r10;
    L5:
        int r11 = r10 & Ascii.DEL;
        this.source.require(1);
        this.pos++;
        byte r12 = this.source.readByte();
        if (r12 < 0) goto L9;
        int r13 = r12 << 7;
    L30:
        return r13 | r11;
    L9:
        r11 = r11 | ((r12 & Ascii.DEL) << 7);
        this.source.require(1);
        this.pos++;
        byte r14 = this.source.readByte();
        if (r14 < 0) goto L12;
        r13 = r14 << Ascii.SO;
        goto L30
    L12:
        r11 = r11 | ((r14 & Ascii.DEL) << 14);
        this.source.require(1);
        this.pos++;
        byte r15 = this.source.readByte();
        if (r15 < 0) goto L15;
        r13 = r15 << Ascii.NAK;
        goto L30
    L15:
        int r16 = r11 | ((r15 & Ascii.DEL) << 21);
        this.source.require(1);
        this.pos++;
        byte r17 = this.source.readByte();
        int r18 = r16 | (r17 << Ascii.FS);
        if (r17 >= 0) goto L27;
        int r19 = 0;
    L19:
        if (r19 >= 5) goto L25;
        this.source.require(1);
        this.pos++;
        if (this.source.readByte() >= 0) goto L22;
        r19 = r19 + 1;
        goto L19
    L22:
        return r18;
    L25:
        throw new ProtocolException("Malformed VARINT");
    L27:
        return r18;
    }

    private void skipGroup(int r10) throws IOException {
    L3:
        if (this.pos >= this.limit) goto L34;
        if (this.source.exhausted() == true) goto L34;
        int r11 = internalReadVarint32();
        if (r11 == 0) goto L32;
        int r12 = r11 >> 3;
        int r13 = r11 & 7;
        if (r13 != 0) goto L11;
        this.state = 0;
        readVarint64();
        goto L3
    L11:
        if (r13 != 1) goto L13;
        this.state = 1;
        readFixed64();
        goto L3
    L13:
        if (r13 != 2) goto L15;
        long r14 = internalReadVarint32();
        this.pos += r14;
        this.source.skip(r14);
        goto L3
    L15:
        if (r13 != 3) goto L17;
        skipGroup(r12);
        goto L3
    L17:
        if (r13 == 4) goto L23;
        if (r13 != 5) goto L22;
        this.state = 5;
        readFixed32();
        goto L3
    L22:
        throw new ProtocolException("Unexpected field encoding: " + r13);
    L23:
        if (r12 != r10) goto L26;
        return;
    L26:
        throw new ProtocolException("Unexpected end group");
    L32:
        throw new ProtocolException("Unexpected tag 0");
    L34:
        throw new EOFException();
    }

    public long beginMessage() throws IOException {
        if (this.state != 2) goto L11;
        int r10 = this.recursionDepth + 1;
        this.recursionDepth = r10;
        if (r10 > 65) goto L9;
        long r11 = this.pushedLimit;
        this.pushedLimit = -1;
        this.state = 6;
        return r11;
    L9:
        throw new IOException("Wire recursion limit exceeded");
    L11:
        throw new IllegalStateException("Unexpected call to beginMessage()");
    }

    public void endMessage(long r10) throws IOException {
        if (this.state != 6) goto L19;
        int r11 = this.recursionDepth - 1;
        this.recursionDepth = r11;
        if (r11 < 0) goto L17;
        if (this.pushedLimit != (-1)) goto L17;
        if (this.pos == this.limit) goto L14;
        if (r11 == 0) goto L14;
        throw new IOException("Expected to end at " + this.limit + " but was " + this.pos);
    L14:
        this.limit = r10;
        return;
    L17:
        throw new IllegalStateException("No corresponding call to beginMessage()");
    L19:
        throw new IllegalStateException("Unexpected call to endMessage()");
    }

    public int nextTag() throws IOException {
        int r10 = this.state;
        if (r10 != 7) goto L7;
        this.state = 2;
        return this.tag;
    L7:
        if (r10 != 6) goto L55;
    L9:
        if (this.pos >= this.limit) goto L52;
        if (this.source.exhausted() == true) goto L63;
        int r11 = internalReadVarint32();
        if (r11 == 0) goto L51;
        int r12 = r11 >> 3;
        this.tag = r12;
        int r13 = r11 & 7;
        if (r13 == 0) goto L48;
        if (r13 == 1) goto L46;
        if (r13 == 2) goto L32;
        if (r13 != 3) goto L22;
        skipGroup(r12);
        goto L9
    L22:
        if (r13 == 4) goto L30;
        if (r13 != 5) goto L28;
        this.nextFieldEncoding = FieldEncoding.FIXED32;
        this.state = 5;
        return r12;
    L28:
        throw new ProtocolException("Unexpected field encoding: " + r13);
    L30:
        throw new ProtocolException("Unexpected end group");
    L32:
        this.nextFieldEncoding = FieldEncoding.LENGTH_DELIMITED;
        this.state = 2;
        int r14 = internalReadVarint32();
        if (r14 < 0) goto L45;
        if (this.pushedLimit != (-1)) goto L43;
        long r15 = this.limit;
        this.pushedLimit = r15;
        long r16 = this.pos + ((long) r14);
        this.limit = r16;
        if (r16 > r15) goto L41;
        return this.tag;
    L41:
        throw new EOFException();
    L43:
        throw new IllegalStateException();
    L45:
        throw new ProtocolException("Negative length: " + r14);
    L46:
        this.nextFieldEncoding = FieldEncoding.FIXED64;
        this.state = 1;
        return r12;
    L48:
        this.nextFieldEncoding = FieldEncoding.VARINT;
        this.state = 0;
        return r12;
    L51:
        throw new ProtocolException("Unexpected tag 0");
    L63:
        return -1;
    L52:
        return -1;
    L55:
        throw new IllegalStateException("Unexpected call to nextTag()");
    }

    public FieldEncoding peekFieldEncoding() {
        return this.nextFieldEncoding;
    }

    public ByteString readBytes() throws IOException {
        long r10 = beforeLengthDelimitedScalar();
        this.source.require(r10);
        return this.source.readByteString(r10);
    }

    public int readFixed32() throws IOException {
        int r10 = this.state;
        if (r10 != 5) goto L5;
    L9:
        this.source.require(4);
        this.pos += 4;
        int r11 = this.source.readIntLe();
        afterPackableScalar(5);
        return r11;
    L5:
        if (r10 == 2) goto L9;
        throw new ProtocolException("Expected FIXED32 or LENGTH_DELIMITED but was " + this.state);
    }

    public long readFixed64() throws IOException {
        int r10 = this.state;
        if (r10 != 1) goto L5;
    L9:
        this.source.require(8);
        this.pos += 8;
        long r11 = this.source.readLongLe();
        afterPackableScalar(1);
        return r11;
    L5:
        if (r10 == 2) goto L9;
        throw new ProtocolException("Expected FIXED64 or LENGTH_DELIMITED but was " + this.state);
    }

    public String readString() throws IOException {
        long r10 = beforeLengthDelimitedScalar();
        this.source.require(r10);
        return this.source.readUtf8(r10);
    }

    public int readVarint32() throws IOException {
        int r10 = this.state;
        if (r10 != 0) goto L5;
    L9:
        int r11 = internalReadVarint32();
        afterPackableScalar(0);
        return r11;
    L5:
        if (r10 == 2) goto L9;
        throw new ProtocolException("Expected VARINT or LENGTH_DELIMITED but was " + this.state);
    }

    public long readVarint64() throws IOException {
        int r10 = this.state;
        if (r10 != 0) goto L5;
    L9:
        long r11 = 0;
        int r12 = 0;
    L11:
        if (r12 >= 64) goto L18;
        this.source.require(1);
        this.pos++;
        byte r13 = this.source.readByte();
        r11 = r11 | (((long) (r13 & Ascii.DEL)) << r12);
        if ((r13 & UnsignedBytes.MAX_POWER_OF_TWO) == 0) goto L14;
        r12 = r12 + 7;
        goto L11
    L14:
        afterPackableScalar(0);
        return r11;
    L18:
        throw new ProtocolException("WireInput encountered a malformed varint");
    L5:
        if (r10 == 2) goto L9;
        throw new ProtocolException("Expected VARINT or LENGTH_DELIMITED but was " + this.state);
    }

    public void skip() throws IOException {
        int r10 = this.state;
        if (r10 != 0) goto L5;
        readVarint64();
        return;
    L5:
        if (r10 != 1) goto L7;
        readFixed64();
        return;
    L7:
        if (r10 != 2) goto L9;
        long r11 = beforeLengthDelimitedScalar();
        this.source.skip(r11);
        return;
    L9:
        if (r10 != 5) goto L12;
        readFixed32();
        return;
    L12:
        throw new IllegalStateException("Unexpected call to skip()");
    }
}
