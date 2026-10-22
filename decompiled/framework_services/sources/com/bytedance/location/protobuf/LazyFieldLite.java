package com.bytedance.location.protobuf;

import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class LazyFieldLite {
    private static final ExtensionRegistryLite EMPTY_REGISTRY = null;
    private ByteString delayedBytes;
    private ExtensionRegistryLite extensionRegistry;
    private volatile ByteString memoizedBytes;
    protected volatile MessageLite value;

    static {
        EMPTY_REGISTRY = ExtensionRegistryLite.getEmptyRegistry();
    }

    public LazyFieldLite(ExtensionRegistryLite extensionRegistry, ByteString bytes) {
        checkArguments(extensionRegistry, bytes);
        this.extensionRegistry = extensionRegistry;
        this.delayedBytes = bytes;
    }

    public LazyFieldLite() {
    }

    public static LazyFieldLite fromValue(MessageLite value) {
        LazyFieldLite lf = new LazyFieldLite();
        lf.setValue(value);
        return lf;
    }

    public boolean equals(Object o) {
        if (this != o) goto L6;
        return true;
    L6:
        if ((o instanceof LazyFieldLite) == true) goto L9;
        return false;
    L9:
        LazyFieldLite other = (LazyFieldLite) o;
        MessageLite value1 = this.value;
        MessageLite value2 = other.value;
        if (value1 != null) goto L14;
        if (value2 != null) goto L14;
        return toByteString().equals(other.toByteString());
    L14:
        if (value1 == null) goto L18;
        if (value2 == null) goto L18;
        return value1.equals(value2);
    L18:
        if (value1 == null) goto L22;
        return value1.equals(other.getValue(value1.getDefaultInstanceForType()));
    L22:
        return getValue(value2.getDefaultInstanceForType()).equals(value2);
    }

    public int hashCode() {
        return 1;
    }

    public boolean containsDefaultInstance() {
        if (this.memoizedBytes != ByteString.EMPTY) goto L5;
    L12:
        return true;
    L5:
        if (this.value == null) goto L7;
    L11:
        return false;
    L7:
        if (this.delayedBytes == null) goto L12;
        if (this.delayedBytes != ByteString.EMPTY) goto L11;
        goto L11
    }

    public void clear() {
        this.delayedBytes = null;
        this.value = null;
        this.memoizedBytes = null;
    }

    public void set(LazyFieldLite other) {
        this.delayedBytes = other.delayedBytes;
        this.value = other.value;
        this.memoizedBytes = other.memoizedBytes;
        if (other.extensionRegistry == null) goto L6;
        this.extensionRegistry = other.extensionRegistry;
        return;
    }

    public MessageLite getValue(MessageLite defaultInstance) {
        ensureInitialized(defaultInstance);
        return this.value;
    }

    public MessageLite setValue(MessageLite value) {
        MessageLite originalValue = this.value;
        this.delayedBytes = null;
        this.memoizedBytes = null;
        this.value = value;
        return originalValue;
    }

    public void merge(LazyFieldLite other) {
        if (other.containsDefaultInstance() == false) goto L6;
        return;
    L6:
        if (containsDefaultInstance() == false) goto L10;
        set(other);
        return;
    L10:
        if (this.extensionRegistry != null) goto L13;
        this.extensionRegistry = other.extensionRegistry;
    L13:
        if (this.delayedBytes == null) goto L19;
        if (other.delayedBytes == null) goto L19;
        this.delayedBytes = this.delayedBytes.concat(other.delayedBytes);
        return;
    L19:
        if (this.value != null) goto L25;
        if (other.value == null) goto L25;
        setValue(mergeValueAndBytes(other.value, this.delayedBytes, this.extensionRegistry));
        return;
    L25:
        if (this.value != null) goto L27;
    L30:
        setValue(this.value.toBuilder().mergeFrom(other.value).build());
        return;
    L27:
        if (other.value != null) goto L30;
        setValue(mergeValueAndBytes(this.value, other.delayedBytes, other.extensionRegistry));
    }

    public void mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
        if (containsDefaultInstance() == false) goto L7;
        setByteString(input.readBytes(), extensionRegistry);
        return;
    L7:
        if (this.extensionRegistry != null) goto L10;
        this.extensionRegistry = extensionRegistry;
    L10:
        if (this.delayedBytes == null) goto L17;
        setByteString(this.delayedBytes.concat(input.readBytes()), this.extensionRegistry);
        return;
    L17:
        setValue(this.value.toBuilder().mergeFrom(input, extensionRegistry).build());     // Catch: InvalidProtocolBufferException -> L15
        return;
    }

    private static MessageLite mergeValueAndBytes(MessageLite value, ByteString otherBytes, ExtensionRegistryLite extensionRegistry) {
        return value.toBuilder().mergeFrom(otherBytes, extensionRegistry).build();
    L5:
        return value;
    }

    public void setByteString(ByteString bytes, ExtensionRegistryLite extensionRegistry) {
        checkArguments(extensionRegistry, bytes);
        this.delayedBytes = bytes;
        this.extensionRegistry = extensionRegistry;
        this.value = null;
        this.memoizedBytes = null;
    }

    public int getSerializedSize() {
        if (this.memoizedBytes == null) goto L7;
        return this.memoizedBytes.size();
    L7:
        if (this.delayedBytes == null) goto L11;
        return this.delayedBytes.size();
    L11:
        if (this.value != null) goto L13;
        return 0;
    L13:
        return this.value.getSerializedSize();
    }

    public ByteString toByteString() {
        if (this.memoizedBytes == null) goto L7;
        return this.memoizedBytes;
    L7:
        if (this.delayedBytes != null) goto L9;
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L12:
        if (this.memoizedBytes == null) goto L19;
        ByteString r0 = this.memoizedBytes;     // Catch: Throwable -> L16
        monitor-exit(this);     // Catch: Throwable -> L16
        return r0;
    L19:
        if (this.value != null) goto L21;
        this.memoizedBytes = ByteString.EMPTY;     // Catch: Throwable -> L16
    L22:
        ByteString r1 = this.memoizedBytes;     // Catch: Throwable -> L16
        monitor-exit(this);     // Catch: Throwable -> L16
        return r1;
    L21:
        this.memoizedBytes = this.value.toByteString();     // Catch: Throwable -> L16
        goto L22
    L9:
        return this.delayedBytes;
    }

    void writeTo(Writer writer, int fieldNumber) throws IOException {
        if (this.memoizedBytes == null) goto L6;
        writer.writeBytes(fieldNumber, this.memoizedBytes);
        return;
    L6:
        if (this.delayedBytes == null) goto L9;
        writer.writeBytes(fieldNumber, this.delayedBytes);
        return;
    L9:
        if (this.value == null) goto L11;
        writer.writeMessage(fieldNumber, this.value);
        return;
    L11:
        writer.writeBytes(fieldNumber, ByteString.EMPTY);
    }

    protected void ensureInitialized(MessageLite defaultInstance) {
        if (this.value == null) goto L5;
        return;
    L5:
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L7:
        if (this.value == null) goto L26;
        monitor-exit(this);     // Catch: Throwable -> L10
        return;
    L26:
        if (this.delayedBytes == null) goto L17;
        MessageLite parsedValue = defaultInstance.getParserForType().parseFrom(this.delayedBytes, this.extensionRegistry);     // Catch: Throwable -> L10 InvalidProtocolBufferException -> L15
        this.value = parsedValue;     // Catch: Throwable -> L10 InvalidProtocolBufferException -> L15
        this.memoizedBytes = this.delayedBytes;     // Catch: Throwable -> L10 InvalidProtocolBufferException -> L15
    L25:
    L21:
        monitor-exit(this);     // Catch: Throwable -> L10
        return;
        goto L20
    L17:
        this.value = defaultInstance;     // Catch: Throwable -> L10 InvalidProtocolBufferException -> L15
        this.memoizedBytes = ByteString.EMPTY;     // Catch: Throwable -> L10 InvalidProtocolBufferException -> L15
    L20:
        this.value = defaultInstance;     // Catch: Throwable -> L10
        this.memoizedBytes = ByteString.EMPTY;     // Catch: Throwable -> L10
        goto L21
    }

    private static void checkArguments(ExtensionRegistryLite extensionRegistry, ByteString bytes) {
        if (extensionRegistry == null) goto L8;
        if (bytes == null) goto L6;
        return;
    L6:
        throw new NullPointerException("found null ByteString");
    L8:
        throw new NullPointerException("found null ExtensionRegistry");
    }
}
