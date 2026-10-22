package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
final class NioByteString extends ByteString.LeafByteString {
    private final ByteBuffer buffer;

    public NioByteString(ByteBuffer r10) {
        if (r10 == null) goto L7;
        this.buffer = r10.slice().order(ByteOrder.nativeOrder());
        return;
    L7:
        throw new NullPointerException("buffer");
    }

    public static /* synthetic */ ByteBuffer access$000(NioByteString r10) {
        return r10.buffer;
    }

    private void readObject(ObjectInputStream r10) throws IOException {
        throw new InvalidObjectException("NioByteString instances are not to be serialized directly");
    }

    private ByteBuffer slice(int r10, int r11) {
        if (r10 < this.buffer.position()) goto L10;
        if (r11 > this.buffer.limit()) goto L10;
        if (r10 > r11) goto L10;
        ByteBuffer r12 = this.buffer.slice();
        r12.position(r10 - this.buffer.position());
        r12.limit(r11 - this.buffer.position());
        return r12;
    L10:
        throw new IllegalArgumentException(String.format("Invalid indices [%d, %d]", new Object[]{Integer.valueOf(r10), Integer.valueOf(r11)}));
    }

    private Object writeReplace() {
        return ByteString.copyFrom(this.buffer.slice());
    }

    @Override // com.google.protobuf.ByteString
    public ByteBuffer asReadOnlyByteBuffer() {
        return this.buffer.asReadOnlyBuffer();
    }

    @Override // com.google.protobuf.ByteString
    public List<ByteBuffer> asReadOnlyByteBufferList() {
        return Collections.singletonList(asReadOnlyByteBuffer());
    }

    @Override // com.google.protobuf.ByteString
    public byte byteAt(int r10) {
        return this.buffer.get(r10);
    L6:
        e = move-exception;
        throw e;
    L4:
        e = move-exception;
        throw new ArrayIndexOutOfBoundsException(e.getMessage());
    }

    @Override // com.google.protobuf.ByteString
    public void copyTo(ByteBuffer r10) {
        r10.put(this.buffer.slice());
    }

    @Override // com.google.protobuf.ByteString
    public void copyToInternal(byte[] r10, int r11, int r12, int r13) {
        ByteBuffer r14 = this.buffer.slice();
        r14.position(r11);
        r14.get(r10, r12, r13);
    }

    @Override // com.google.protobuf.ByteString
    public boolean equals(Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof ByteString) == true) goto L8;
        return false;
    L8:
        ByteString r11 = (ByteString) r10;
        if (size() == r11.size()) goto L12;
        return false;
    L12:
        if (size() != 0) goto L15;
        return true;
    L15:
        if ((r10 instanceof NioByteString) == false) goto L19;
        return this.buffer.equals(((NioByteString) r10).buffer);
    L19:
        if ((r10 instanceof RopeByteString) == false) goto L23;
        return r10.equals(this);
    L23:
        return this.buffer.equals(r11.asReadOnlyByteBuffer());
    }

    @Override // com.google.protobuf.ByteString.LeafByteString
    public boolean equalsRange(ByteString r10, int r11, int r12) {
        return substring(0, r12).equals(r10.substring(r11, r12 + r11));
    }

    @Override // com.google.protobuf.ByteString
    public boolean isValidUtf8() {
        return Utf8.isValidUtf8(this.buffer);
    }

    @Override // com.google.protobuf.ByteString
    public CodedInputStream newCodedInput() {
        return CodedInputStream.newInstance(this.buffer);
    }

    @Override // com.google.protobuf.ByteString
    public InputStream newInput() {
        return new AnonymousClass1(this);
    }

    @Override // com.google.protobuf.ByteString
    public int partialHash(int r10, int r11, int r12) {
        int r13 = r11;
    L4:
        if (r13 >= (r11 + r12)) goto L6;
        r10 = (r10 * 31) + this.buffer.get(r13);
        r13 = r13 + 1;
        goto L4
    L6:
        return r10;
    }

    @Override // com.google.protobuf.ByteString
    public int partialIsValidUtf8(int r10, int r11, int r12) {
        return Utf8.partialIsValidUtf8(r10, this.buffer, r11, r12 + r11);
    }

    @Override // com.google.protobuf.ByteString
    public int size() {
        return this.buffer.remaining();
    }

    @Override // com.google.protobuf.ByteString
    public ByteString substring(int r10, int r11) {
        return new NioByteString(slice(r10, r11));
    L6:
        e = move-exception;
        throw e;
    L4:
        e = move-exception;
        throw new ArrayIndexOutOfBoundsException(e.getMessage());
    }

    @Override // com.google.protobuf.ByteString
    public String toStringInternal(Charset r10) {
        if (this.buffer.hasArray() == false) goto L5;
        byte[] r11 = this.buffer.array();
        int r12 = this.buffer.arrayOffset() + this.buffer.position();
        int r13 = this.buffer.remaining();
    L7:
        return new String(r11, r12, r13, r10);
    L5:
        r11 = toByteArray();
        r13 = r11.length;
        r12 = 0;
        goto L7
    }

    @Override // com.google.protobuf.ByteString
    public void writeTo(OutputStream r10) throws IOException {
        r10.write(toByteArray());
    }

    @Override // com.google.protobuf.ByteString
    public void writeToInternal(OutputStream r10, int r11, int r12) throws IOException {
        if (this.buffer.hasArray() == false) goto L6;
        int r13 = (this.buffer.arrayOffset() + this.buffer.position()) + r11;
        r10.write(this.buffer.array(), r13, r12);
        return;
    L6:
        ByteBufferWriter.write(slice(r11, r12 + r11), r10);
    }

    @Override // com.google.protobuf.ByteString
    public void writeTo(ByteOutput r10) throws IOException {
        r10.writeLazy(this.buffer.slice());
    }
}
