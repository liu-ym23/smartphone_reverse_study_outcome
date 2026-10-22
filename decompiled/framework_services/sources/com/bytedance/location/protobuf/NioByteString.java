package com.bytedance.location.protobuf;

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

    static /* synthetic */ ByteBuffer access$000(NioByteString x0) {
        return x0.buffer;
    }

    NioByteString(ByteBuffer buffer) {
        Internal.checkNotNull(buffer, "buffer");
        this.buffer = buffer.slice().order(ByteOrder.nativeOrder());
    }

    private Object writeReplace() {
        return ByteString.copyFrom(this.buffer.slice());
    }

    private void readObject(ObjectInputStream in) throws IOException {
        throw new InvalidObjectException("NioByteString instances are not to be serialized directly");
    }

    @Override // com.bytedance.location.protobuf.ByteString
    public byte byteAt(int index) {
        return this.buffer.get(index);
    L6:
        e = move-exception;
        throw e;
    L4:
        e = move-exception;
        throw new ArrayIndexOutOfBoundsException(e.getMessage());
    }

    @Override // com.bytedance.location.protobuf.ByteString
    public byte internalByteAt(int index) {
        return byteAt(index);
    }

    @Override // com.bytedance.location.protobuf.ByteString
    public int size() {
        return this.buffer.remaining();
    }

    @Override // com.bytedance.location.protobuf.ByteString
    public ByteString substring(int beginIndex, int endIndex) {
        ByteBuffer slice = slice(beginIndex, endIndex);     // Catch: IndexOutOfBoundsException -> L4 ArrayIndexOutOfBoundsException -> L6
        return new NioByteString(slice);
    L6:
        e = move-exception;
        throw e;
    L4:
        e = move-exception;
        throw new ArrayIndexOutOfBoundsException(e.getMessage());
    }

    @Override // com.bytedance.location.protobuf.ByteString
    protected void copyToInternal(byte[] target, int sourceOffset, int targetOffset, int numberToCopy) {
        ByteBuffer slice = this.buffer.slice();
        slice.position(sourceOffset);
        slice.get(target, targetOffset, numberToCopy);
    }

    @Override // com.bytedance.location.protobuf.ByteString
    public void copyTo(ByteBuffer target) {
        target.put(this.buffer.slice());
    }

    @Override // com.bytedance.location.protobuf.ByteString
    public void writeTo(OutputStream out) throws IOException {
        out.write(toByteArray());
    }

    @Override // com.bytedance.location.protobuf.ByteString.LeafByteString
    boolean equalsRange(ByteString other, int offset, int length) {
        return substring(0, length).equals(other.substring(offset, offset + length));
    }

    @Override // com.bytedance.location.protobuf.ByteString
    void writeToInternal(OutputStream out, int sourceOffset, int numberToWrite) throws IOException {
        if (this.buffer.hasArray() == false) goto L6;
        int bufferOffset = (this.buffer.arrayOffset() + this.buffer.position()) + sourceOffset;
        out.write(this.buffer.array(), bufferOffset, numberToWrite);
        return;
    L6:
        int bufferOffset2 = sourceOffset + numberToWrite;
        ByteBufferWriter.write(slice(sourceOffset, bufferOffset2), out);
    }

    @Override // com.bytedance.location.protobuf.ByteString
    void writeTo(ByteOutput output) throws IOException {
        output.writeLazy(this.buffer.slice());
    }

    @Override // com.bytedance.location.protobuf.ByteString
    public ByteBuffer asReadOnlyByteBuffer() {
        return this.buffer.asReadOnlyBuffer();
    }

    @Override // com.bytedance.location.protobuf.ByteString
    public List<ByteBuffer> asReadOnlyByteBufferList() {
        return Collections.singletonList(asReadOnlyByteBuffer());
    }

    @Override // com.bytedance.location.protobuf.ByteString
    protected String toStringInternal(Charset charset) {
        if (this.buffer.hasArray() == false) goto L5;
        byte[] bytes = this.buffer.array();
        int offset = this.buffer.arrayOffset() + this.buffer.position();
        int length = this.buffer.remaining();
    L7:
        return new String(bytes, offset, length, charset);
    L5:
        bytes = toByteArray();
        offset = 0;
        length = bytes.length;
        goto L7
    }

    @Override // com.bytedance.location.protobuf.ByteString
    public boolean isValidUtf8() {
        return Utf8.isValidUtf8(this.buffer);
    }

    @Override // com.bytedance.location.protobuf.ByteString
    protected int partialIsValidUtf8(int state, int offset, int length) {
        return Utf8.partialIsValidUtf8(state, this.buffer, offset, offset + length);
    }

    @Override // com.bytedance.location.protobuf.ByteString
    public boolean equals(Object other) {
        if (other != this) goto L6;
        return true;
    L6:
        if ((other instanceof ByteString) == true) goto L8;
        return false;
    L8:
        ByteString otherString = (ByteString) other;
        if (size() == otherString.size()) goto L12;
        return false;
    L12:
        if (size() != 0) goto L15;
        return true;
    L15:
        if ((other instanceof NioByteString) == false) goto L19;
        return this.buffer.equals(((NioByteString) other).buffer);
    L19:
        if ((other instanceof RopeByteString) == false) goto L23;
        return other.equals(this);
    L23:
        return this.buffer.equals(otherString.asReadOnlyByteBuffer());
    }

    @Override // com.bytedance.location.protobuf.ByteString
    protected int partialHash(int h, int offset, int length) {
        int i = offset;
    L4:
        if (i >= (offset + length)) goto L7;
        h = (h * 31) + this.buffer.get(i);
        i = i + 1;
        goto L4
    L7:
        return h;
    }

    @Override // com.bytedance.location.protobuf.ByteString
    public InputStream newInput() {
        return new AnonymousClass1(this);
    }

    @Override // com.bytedance.location.protobuf.ByteString
    public CodedInputStream newCodedInput() {
        return CodedInputStream.newInstance(this.buffer, true);
    }

    private ByteBuffer slice(int beginIndex, int endIndex) {
        if (beginIndex < this.buffer.position()) goto L10;
        if (endIndex > this.buffer.limit()) goto L10;
        if (beginIndex > endIndex) goto L10;
        ByteBuffer slice = this.buffer.slice();
        slice.position(beginIndex - this.buffer.position());
        slice.limit(endIndex - this.buffer.position());
        return slice;
    L10:
        throw new IllegalArgumentException(String.format("Invalid indices [%d, %d]", new Object[]{Integer.valueOf(beginIndex), Integer.valueOf(endIndex)}));
    }
}
