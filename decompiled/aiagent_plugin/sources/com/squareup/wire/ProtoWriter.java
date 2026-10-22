package com.squareup.wire;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import e.f;
import e.h;

/* JADX INFO: loaded from: classes4.dex */
public final class ProtoWriter {
    private final f sink;

    static int decodeZigZag32(int r1) {
        int r0 = r1 >>> 1;
        return (-(r1 & 1)) ^ r0;
    }

    static long decodeZigZag64(long r4) {
        long r0 = r4 >>> 1;
        return (-(r4 & 1)) ^ r0;
    }

    static int encodeZigZag32(int r1) {
        int r0 = r1 << 1;
        return (r1 >> 31) ^ r0;
    }

    static long encodeZigZag64(long r3) {
        long r0 = r3 << 1;
        return (r3 >> 63) ^ r0;
    }

    static int varint32Size(int r1) {
        if ((r1 & (-128)) != 0) goto L7;
        return 1;
    L7:
        if ((r1 & (-16384)) != 0) goto L11;
        return 2;
    L11:
        if (((-2097152) & r1) != 0) goto L15;
        return 3;
    L15:
        if ((r1 & (-268435456)) != 0) goto L18;
        return 4;
    L18:
        return 5;
    }

    static int varint64Size(long r4) {
        if (((-128) & r4) != 0) goto L7;
        return 1;
    L7:
        if (((-16384) & r4) != 0) goto L11;
        return 2;
    L11:
        if (((-2097152) & r4) != 0) goto L15;
        return 3;
    L15:
        if (((-268435456) & r4) != 0) goto L19;
        return 4;
    L19:
        if (((-34359738368L) & r4) != 0) goto L23;
        return 5;
    L23:
        if (((-4398046511104L) & r4) != 0) goto L27;
        return 6;
    L27:
        if (((-562949953421312L) & r4) != 0) goto L31;
        return 7;
    L31:
        if (((-72057594037927936L) & r4) != 0) goto L35;
        return 8;
    L35:
        if ((r4 & Long.MIN_VALUE) != 0) goto L38;
        return 9;
    L38:
        return 10;
    }

    private static int makeTag(int r0, FieldEncoding r1) {
        return (r0 << 3) | r1.value;
    }

    static int tagSize(int r1) {
        return varint32Size(makeTag(r1, FieldEncoding.VARINT));
    }

    static int utf8Length(String r7) {
        int r0 = r7.length();
        int r1 = 0;
        int r2 = 0;
    L3:
        if (r1 >= r0) goto L26;
        char r3 = r7.charAt(r1);
        if (r3 >= 128) goto L8;
    L6:
        r2 = r2 + 1;
    L25:
        r1 = r1 + 1;
        goto L3
    L8:
        if (r3 >= 2048) goto L11;
        r2 = r2 + 2;
        goto L25
    L11:
        if (r3 >= 55296) goto L13;
    L24:
        r2 = r2 + 3;
        goto L25
    L13:
        if (r3 > 57343) goto L24;
        if (r3 > 56319) goto L6;
        int r4 = r1 + 1;
        if (r4 >= r0) goto L6;
        if (r7.charAt(r4) < 56320) goto L6;
        if (r7.charAt(r4) > 57343) goto L6;
        r2 = r2 + 4;
        r1 = r4;
        goto L25
    L26:
        return r2;
    }

    static int int32Size(int r0) {
        if (r0 >= 0) goto L4;
        return 10;
    L4:
        return varint32Size(r0);
    }

    public ProtoWriter(f r3) {
        this.sink = (f) ZeusTransformUtils.wrapperContextForParams(r3, f.class, "com.obric.aiagent.plugin");
    }

    public void writeBytes(h r1) {
        this.sink.c(r1);
    }

    public void writeString(String r1) {
        this.sink.b(r1);
    }

    public void writeTag(int r1, FieldEncoding r2) {
        writeVarint32(makeTag(r1, r2));
    }

    void writeSignedVarint32(int r3) {
        if (r3 < 0) goto L4;
        writeVarint32(r3);
        return;
    L4:
        writeVarint64(r3);
    }

    public void writeVarint32(int r3) {
    L3:
        if ((r3 & (-128)) == 0) goto L5;
        this.sink.h((r3 & 127) | 128);
        r3 = r3 >>> 7;
        goto L3
    L5:
        this.sink.h(r3);
    }

    public void writeVarint64(long r5) {
    L3:
        if (((-128) & r5) == 0) goto L5;
        this.sink.h((((int) r5) & 127) | 128);
        r5 = r5 >>> 7;
        goto L3
    L5:
        this.sink.h((int) r5);
    }

    public void writeFixed32(int r1) {
        this.sink.k(r1);
    }

    public void writeFixed64(long r1) {
        this.sink.m(r1);
    }
}
