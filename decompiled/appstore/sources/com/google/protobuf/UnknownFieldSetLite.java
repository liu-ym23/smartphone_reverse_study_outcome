package com.google.protobuf;

import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class UnknownFieldSetLite {
    private static final UnknownFieldSetLite DEFAULT_INSTANCE = null;
    private static final int MIN_CAPACITY = 8;
    private int count;
    private boolean isMutable;
    private int memoizedSerializedSize;
    private Object[] objects;
    private int[] tags;

    static {
        DEFAULT_INSTANCE = new UnknownFieldSetLite(0, new int[0], new Object[0], false);
    }

    private UnknownFieldSetLite() {
        this(0, new int[8], new Object[8], true);
    }

    private void ensureCapacity() {
        int r10 = this.count;
        int[] r11 = this.tags;
        if (r10 == r11.length) goto L5;
        return;
    L5:
        if (r10 >= 4) goto L7;
        int r12 = 8;
    L8:
        int r13 = r10 + r12;
        this.tags = Arrays.copyOf(r11, r13);
        this.objects = Arrays.copyOf(this.objects, r13);
        return;
    L7:
        r12 = r10 >> 1;
        goto L8
    }

    public static UnknownFieldSetLite getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private UnknownFieldSetLite mergeFrom(CodedInputStream r10) throws IOException {
    L2:
        int r11 = r10.readTag();
        if (r11 == 0) goto L6;
        if (mergeFieldFrom(r11, r10) == true) goto L2;
    L6:
        return this;
    }

    public static UnknownFieldSetLite mutableCopyOf(UnknownFieldSetLite r10, UnknownFieldSetLite r11) {
        int r12 = r10.count + r11.count;
        int[] r13 = Arrays.copyOf(r10.tags, r12);
        System.arraycopy(r11.tags, 0, r13, r10.count, r11.count);
        Object[] r14 = Arrays.copyOf(r10.objects, r12);
        System.arraycopy(r11.objects, 0, r14, r10.count, r11.count);
        return new UnknownFieldSetLite(r12, r13, r14, true);
    }

    public static UnknownFieldSetLite newInstance() {
        return new UnknownFieldSetLite();
    }

    private void storeField(int r10, Object r11) {
        ensureCapacity();
        int[] r12 = this.tags;
        int r13 = this.count;
        r12[r13] = r10;
        this.objects[r13] = r11;
        this.count = r13 + 1;
    }

    public void checkMutable() {
        if (this.isMutable == false) goto L6;
        return;
    L6:
        throw new UnsupportedOperationException();
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if (r10 != null) goto L9;
        return false;
    L9:
        if ((r10 instanceof UnknownFieldSetLite) == true) goto L11;
        return false;
    L11:
        UnknownFieldSetLite r11 = (UnknownFieldSetLite) r10;
        if (this.count == r11.count) goto L14;
    L19:
        return false;
    L14:
        if (Arrays.equals(this.tags, r11.tags) == false) goto L19;
        if (Arrays.deepEquals(this.objects, r11.objects) == false) goto L19;
        return true;
    }

    public int getSerializedSize() {
        int r10 = this.memoizedSerializedSize;
        if (r10 == (-1)) goto L5;
        return r10;
    L5:
        int r11 = 0;
        int r12 = 0;
    L7:
        if (r11 >= this.count) goto L27;
        int r13 = this.tags[r11];
        int r14 = WireFormat.getTagFieldNumber(r13);
        int r15 = WireFormat.getTagWireType(r13);
        if (r15 != 0) goto L11;
        int r16 = CodedOutputStream.computeUInt64Size(r14, ((Long) this.objects[r11]).longValue());
    L19:
        r12 = r12 + r16;
        r11 = r11 + 1;
        goto L7
    L11:
        if (r15 != 1) goto L13;
        r16 = CodedOutputStream.computeFixed64Size(r14, ((Long) this.objects[r11]).longValue());
        goto L19
    L13:
        if (r15 != 2) goto L15;
        r16 = CodedOutputStream.computeBytesSize(r14, (ByteString) this.objects[r11]);
        goto L19
    L15:
        if (r15 != 3) goto L17;
        r16 = (CodedOutputStream.computeTagSize(r14) * 2) + ((UnknownFieldSetLite) this.objects[r11]).getSerializedSize();
        goto L19
    L17:
        if (r15 != 5) goto L21;
        r16 = CodedOutputStream.computeFixed32Size(r14, ((Integer) this.objects[r11]).intValue());
        goto L19
    L21:
        throw new IllegalStateException(InvalidProtocolBufferException.invalidWireType());
    L27:
        this.memoizedSerializedSize = r12;
        return r12;
    }

    public int hashCode() {
        return ((((527 + this.count) * 31) + Arrays.hashCode(this.tags)) * 31) + Arrays.deepHashCode(this.objects);
    }

    public void makeImmutable() {
        this.isMutable = false;
    }

    public boolean mergeFieldFrom(int r10, CodedInputStream r11) throws IOException {
        checkMutable();
        int r12 = WireFormat.getTagFieldNumber(r10);
        int r13 = WireFormat.getTagWireType(r10);
        if (r13 == 0) goto L24;
        if (r13 != 1) goto L6;
        storeField(r10, Long.valueOf(r11.readFixed64()));
        return true;
    L6:
        if (r13 != 2) goto L8;
        storeField(r10, r11.readBytes());
        return true;
    L8:
        if (r13 == 3) goto L18;
        if (r13 != 4) goto L11;
        return false;
    L11:
        if (r13 != 5) goto L15;
        storeField(r10, Integer.valueOf(r11.readFixed32()));
        return true;
    L15:
        throw InvalidProtocolBufferException.invalidWireType();
    L18:
        UnknownFieldSetLite r14 = new UnknownFieldSetLite();
        r14.mergeFrom(r11);
        r11.checkLastTagWas(WireFormat.makeTag(r12, 4));
        storeField(r10, r14);
        return true;
    L24:
        storeField(r10, Long.valueOf(r11.readInt64()));
        return true;
    }

    public UnknownFieldSetLite mergeLengthDelimitedField(int r10, ByteString r11) {
        checkMutable();
        if (r10 == 0) goto L7;
        storeField(WireFormat.makeTag(r10, 2), r11);
        return this;
    L7:
        throw new IllegalArgumentException("Zero is not a valid field number.");
    }

    public UnknownFieldSetLite mergeVarintField(int r10, int r11) {
        checkMutable();
        if (r10 == 0) goto L7;
        storeField(WireFormat.makeTag(r10, 0), Long.valueOf(r11));
        return this;
    L7:
        throw new IllegalArgumentException("Zero is not a valid field number.");
    }

    public final void printWithIndent(StringBuilder r10, int r11) {
        int r12 = 0;
    L4:
        if (r12 >= this.count) goto L6;
        MessageLiteToString.printField(r10, r11, String.valueOf(WireFormat.getTagFieldNumber(this.tags[r12])), this.objects[r12]);
        r12 = r12 + 1;
        goto L4
    }

    public void writeTo(CodedOutputStream r10) throws IOException {
        int r11 = 0;
    L4:
        if (r11 >= this.count) goto L23;
        int r12 = this.tags[r11];
        int r13 = WireFormat.getTagFieldNumber(r12);
        int r14 = WireFormat.getTagWireType(r12);
        if (r14 != 0) goto L8;
        r10.writeUInt64(r13, ((Long) this.objects[r11]).longValue());
    L22:
        r11 = r11 + 1;
        goto L4
    L8:
        if (r14 != 1) goto L10;
        r10.writeFixed64(r13, ((Long) this.objects[r11]).longValue());
        goto L22
    L10:
        if (r14 != 2) goto L12;
        r10.writeBytes(r13, (ByteString) this.objects[r11]);
        goto L22
    L12:
        if (r14 != 3) goto L14;
        r10.writeTag(r13, 3);
        ((UnknownFieldSetLite) this.objects[r11]).writeTo(r10);
        r10.writeTag(r13, 4);
        goto L22
    L14:
        if (r14 != 5) goto L17;
        r10.writeFixed32(r13, ((Integer) this.objects[r11]).intValue());
        goto L22
    L17:
        throw InvalidProtocolBufferException.invalidWireType();
    }

    private UnknownFieldSetLite(int r10, int[] r11, Object[] r12, boolean r13) {
        this.memoizedSerializedSize = -1;
        this.count = r10;
        this.tags = r11;
        this.objects = r12;
        this.isMutable = r13;
    }
}
