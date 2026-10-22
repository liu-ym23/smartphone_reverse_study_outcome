package com.squareup.wire;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import e.g;
import e.h;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;

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
    private final g source;
    private int state;
    private int tag;

    public ProtoReader(g r3) {
        g r4 = (g) ZeusTransformUtils.wrapperContextForParams(r3, g.class, "com.obric.aiagent.plugin");
        this.pos = 0;
        this.limit = Long.MAX_VALUE;
        this.state = 2;
        this.tag = -1;
        this.pushedLimit = -1;
        this.source = r4;
    }

    public long beginMessage() {
        if (this.state != 2) goto L11;
        int r0 = this.recursionDepth + 1;
        this.recursionDepth = r0;
        if (r0 > 65) goto L9;
        long r1 = this.pushedLimit;
        this.pushedLimit = -1;
        this.state = 6;
        return r1;
    L9:
        throw new IOException("Wire recursion limit exceeded");
    L11:
        throw new IllegalStateException("Unexpected call to beginMessage()");
    }

    public void endMessage(long r6) {
        if (this.state != 6) goto L19;
        int r0 = this.recursionDepth - 1;
        this.recursionDepth = r0;
        if (r0 < 0) goto L17;
        if (this.pushedLimit != (-1)) goto L17;
        if (this.pos == this.limit) goto L14;
        if (r0 == 0) goto L14;
        throw new IOException("Expected to end at " + this.limit + " but was " + this.pos);
    L14:
        this.limit = r6;
        return;
    L17:
        throw new IllegalStateException("No corresponding call to beginMessage()");
    L19:
        throw new IllegalStateException("Unexpected call to endMessage()");
    }

    public int nextTag() {
        int r0 = this.state;
        if (r0 != 7) goto L7;
        this.state = 2;
        return this.tag;
    L7:
        if (r0 != 6) goto L55;
    L9:
        if (this.pos >= this.limit) goto L52;
        if (this.source.h() == true) goto L63;
        int r1 = internalReadVarint32();
        if (r1 == 0) goto L51;
        int r2 = r1 >> 3;
        this.tag = r2;
        int r3 = r1 & 7;
        if (r3 == 0) goto L48;
        if (r3 == 1) goto L46;
        if (r3 == 2) goto L32;
        if (r3 != 3) goto L22;
        skipGroup(r2);
        goto L9
    L22:
        if (r3 == 4) goto L30;
        if (r3 != 5) goto L28;
        this.nextFieldEncoding = FieldEncoding.FIXED32;
        this.state = 5;
        return this.tag;
    L28:
        throw new ProtocolException("Unexpected field encoding: " + r3);
    L30:
        throw new ProtocolException("Unexpected end group");
    L32:
        this.nextFieldEncoding = FieldEncoding.LENGTH_DELIMITED;
        this.state = 2;
        int r4 = internalReadVarint32();
        if (r4 < 0) goto L45;
        if (this.pushedLimit != (-1)) goto L43;
        long r5 = this.limit;
        this.pushedLimit = r5;
        long r6 = this.pos + ((long) r4);
        this.limit = r6;
        if (r6 > r5) goto L41;
        return this.tag;
    L41:
        throw new EOFException();
    L43:
        throw new IllegalStateException();
    L45:
        throw new ProtocolException("Negative length: " + r4);
    L46:
        this.nextFieldEncoding = FieldEncoding.FIXED64;
        this.state = 1;
        return this.tag;
    L48:
        this.nextFieldEncoding = FieldEncoding.VARINT;
        this.state = 0;
        return this.tag;
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

    public void skip() {
        int r0 = this.state;
        if (r0 != 0) goto L5;
        readVarint64();
        return;
    L5:
        if (r0 != 1) goto L7;
        readFixed64();
        return;
    L7:
        if (r0 != 2) goto L9;
        long r1 = beforeLengthDelimitedScalar();
        this.source.h(r1);
        return;
    L9:
        if (r0 != 5) goto L12;
        readFixed32();
        return;
    L12:
        throw new IllegalStateException("Unexpected call to skip()");
    }

    private void skipGroup(int r6) {
    L3:
        if (this.pos >= this.limit) goto L34;
        if (this.source.h() == true) goto L34;
        int r0 = internalReadVarint32();
        if (r0 == 0) goto L32;
        int r1 = r0 >> 3;
        int r2 = r0 & 7;
        if (r2 != 0) goto L11;
        this.state = 0;
        readVarint64();
        goto L3
    L11:
        if (r2 != 1) goto L13;
        this.state = 1;
        readFixed64();
        goto L3
    L13:
        if (r2 != 2) goto L15;
        long r3 = internalReadVarint32();
        this.pos += r3;
        this.source.h(r3);
        goto L3
    L15:
        if (r2 != 3) goto L17;
        skipGroup(r1);
        goto L3
    L17:
        if (r2 == 4) goto L23;
        if (r2 != 5) goto L22;
        this.state = 5;
        readFixed32();
        goto L3
    L22:
        throw new ProtocolException("Unexpected field encoding: " + r2);
    L23:
        if (r1 != r6) goto L26;
        return;
    L26:
        throw new ProtocolException("Unexpected end group");
    L32:
        throw new ProtocolException("Unexpected tag 0");
    L34:
        throw new EOFException();
    }

    public h readBytes() {
        long r0 = beforeLengthDelimitedScalar();
        this.source.b(r0);
        return this.source.d(r0);
    }

    public String readString() {
        long r0 = beforeLengthDelimitedScalar();
        this.source.b(r0);
        return this.source.e(r0);
    }

    public int readVarint32() {
        int r0 = this.state;
        if (r0 != 0) goto L5;
    L9:
        int r1 = internalReadVarint32();
        afterPackableScalar(0);
        return r1;
    L5:
        if (r0 == 2) goto L9;
        throw new ProtocolException("Expected VARINT or LENGTH_DELIMITED but was " + this.state);
    }

    private int internalReadVarint32() {
        this.source.b(1);
        this.pos++;
        byte r0 = this.source.k();
        if (r0 < 0) goto L5;
        return r0;
    L5:
        int r1 = r0 & 127;
        this.source.b(1);
        this.pos++;
        byte r3 = this.source.k();
        if (r3 < 0) goto L9;
        int r6 = r3 << 7;
    L30:
        return r6 | r1;
    L9:
        r1 = r1 | ((r3 & 127) << 7);
        this.source.b(1);
        this.pos++;
        byte r4 = this.source.k();
        if (r4 < 0) goto L12;
        r6 = r4 << 14;
        goto L30
    L12:
        r1 = r1 | ((r4 & 127) << 14);
        this.source.b(1);
        this.pos++;
        byte r5 = this.source.k();
        if (r5 < 0) goto L15;
        r6 = r5 << 21;
        goto L30
    L15:
        int r2 = r1 | ((r5 & 127) << 21);
        this.source.b(1);
        this.pos++;
        byte r7 = this.source.k();
        int r8 = r2 | (r7 << 28);
        if (r7 >= 0) goto L27;
        int r9 = 0;
    L19:
        if (r9 >= 5) goto L25;
        this.source.b(1);
        this.pos++;
        if (this.source.k() >= 0) goto L22;
        r9 = r9 + 1;
        goto L19
    L22:
        return r8;
    L25:
        throw new ProtocolException("Malformed VARINT");
    L27:
        return r8;
    }

    public long readVarint64() {
        int r0 = this.state;
        if (r0 != 0) goto L5;
    L9:
        long r1 = 0;
        int r3 = 0;
    L11:
        if (r3 >= 64) goto L18;
        this.source.b(1);
        this.pos++;
        byte r4 = this.source.k();
        r1 = r1 | (((long) (r4 & 127)) << r3);
        if ((r4 & 128) == 0) goto L14;
        r3 = r3 + 7;
        goto L11
    L14:
        afterPackableScalar(0);
        return r1;
    L18:
        throw new ProtocolException("WireInput encountered a malformed varint");
    L5:
        if (r0 == 2) goto L9;
        throw new ProtocolException("Expected VARINT or LENGTH_DELIMITED but was " + this.state);
    }

    public int readFixed32() {
        int r0 = this.state;
        if (r0 != 5) goto L5;
    L9:
        this.source.b(4);
        this.pos += 4;
        int r1 = this.source.p();
        afterPackableScalar(5);
        return r1;
    L5:
        if (r0 == 2) goto L9;
        throw new ProtocolException("Expected FIXED32 or LENGTH_DELIMITED but was " + this.state);
    }

    public long readFixed64() {
        int r0 = this.state;
        if (r0 != 1) goto L5;
    L9:
        this.source.b(8);
        this.pos += 8;
        long r2 = this.source.q();
        afterPackableScalar(1);
        return r2;
    L5:
        if (r0 == 2) goto L9;
        throw new ProtocolException("Expected FIXED64 or LENGTH_DELIMITED but was " + this.state);
    }

    private void afterPackableScalar(int r7) {
        if (this.state != r7) goto L5;
        this.state = 6;
        return;
    L5:
        long r2 = this.pos;
        long r4 = this.limit;
        if (r2 > r4) goto L13;
        if (r2 != r4) goto L10;
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

    private long beforeLengthDelimitedScalar() {
        if (this.state != 2) goto L7;
        long r0 = this.limit - this.pos;
        this.source.b(r0);
        this.state = 6;
        this.pos = this.limit;
        this.limit = this.pushedLimit;
        this.pushedLimit = -1;
        return r0;
    L7:
        throw new ProtocolException("Expected LENGTH_DELIMITED but was " + this.state);
    }
}
