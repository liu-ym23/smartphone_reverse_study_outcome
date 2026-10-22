package com.google.protobuf;

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

    public LazyFieldLite(ExtensionRegistryLite r10, ByteString r11) {
        checkArguments(r10, r11);
        this.extensionRegistry = r10;
        this.delayedBytes = r11;
    }

    private static void checkArguments(ExtensionRegistryLite r10, ByteString r11) {
        if (r10 == null) goto L8;
        if (r11 == null) goto L6;
        return;
    L6:
        throw new NullPointerException("found null ByteString");
    L8:
        throw new NullPointerException("found null ExtensionRegistry");
    }

    public static LazyFieldLite fromValue(MessageLite r10) {
        LazyFieldLite r11 = new LazyFieldLite();
        r11.setValue(r10);
        return r11;
    }

    private static MessageLite mergeValueAndBytes(MessageLite r10, ByteString r11, ExtensionRegistryLite r12) {
        return r10.toBuilder().mergeFrom(r11, r12).build();
    L7:
        return r10;
    }

    public void clear() {
        this.delayedBytes = null;
        this.value = null;
        this.memoizedBytes = null;
    }

    public boolean containsDefaultInstance() {
        ByteString r10 = this.memoizedBytes;
        ByteString r11 = ByteString.EMPTY;
        if (r10 != r11) goto L5;
    L11:
        return true;
    L5:
        if (this.value != null) goto L10;
        ByteString r12 = this.delayedBytes;
        if (r12 == null) goto L11;
        if (r12 == r11) goto L11;
    L10:
        return false;
    }

    public void ensureInitialized(MessageLite r10) {
        if (this.value == null) goto L5;
        return;
    L5:
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L7:
        if (this.value == null) goto L23;
        monitor-exit(this);     // Catch: Throwable -> L10
        return;
    L23:
    L17:
        this.value = r10;     // Catch: Throwable -> L10
        this.memoizedBytes = ByteString.EMPTY;     // Catch: Throwable -> L10
    L18:
        monitor-exit(this);     // Catch: Throwable -> L10
        return;
    L13:
        if (this.delayedBytes == null) goto L15;
        this.value = r10.getParserForType().parseFrom(this.delayedBytes, this.extensionRegistry);     // Catch: Throwable -> L10 InvalidProtocolBufferException -> L17
        this.memoizedBytes = this.delayedBytes;     // Catch: Throwable -> L10 InvalidProtocolBufferException -> L17
    L22:
    L15:
        this.value = r10;     // Catch: Throwable -> L10 InvalidProtocolBufferException -> L17
        this.memoizedBytes = ByteString.EMPTY;     // Catch: Throwable -> L10 InvalidProtocolBufferException -> L17
        goto L22
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof LazyFieldLite) == true) goto L9;
        return false;
    L9:
        LazyFieldLite r11 = (LazyFieldLite) r10;
        MessageLite r12 = this.value;
        MessageLite r13 = r11.value;
        if (r12 != null) goto L14;
        if (r13 != null) goto L14;
        return toByteString().equals(r11.toByteString());
    L14:
        if (r12 == null) goto L18;
        if (r13 == null) goto L18;
        return r12.equals(r13);
    L18:
        if (r12 == null) goto L22;
        return r12.equals(r11.getValue(r12.getDefaultInstanceForType()));
    L22:
        return getValue(r13.getDefaultInstanceForType()).equals(r13);
    }

    public int getSerializedSize() {
        if (this.memoizedBytes != null) goto L5;
        ByteString r10 = this.delayedBytes;
        if (r10 == null) goto L11;
        return r10.size();
    L11:
        if (this.value != null) goto L13;
        return 0;
    L13:
        return this.value.getSerializedSize();
    L5:
        return this.memoizedBytes.size();
    }

    public MessageLite getValue(MessageLite r10) {
        ensureInitialized(r10);
        return this.value;
    }

    public int hashCode() {
        return 1;
    }

    public void merge(LazyFieldLite r10) {
        if (r10.containsDefaultInstance() == false) goto L6;
        return;
    L6:
        if (containsDefaultInstance() == false) goto L10;
        set(r10);
        return;
    L10:
        if (this.extensionRegistry != null) goto L12;
        this.extensionRegistry = r10.extensionRegistry;
    L12:
        ByteString r11 = this.delayedBytes;
        if (r11 == null) goto L19;
        ByteString r12 = r10.delayedBytes;
        if (r12 == null) goto L19;
        this.delayedBytes = r11.concat(r12);
        return;
    L19:
        if (this.value != null) goto L25;
        if (r10.value == null) goto L25;
        setValue(mergeValueAndBytes(r10.value, this.delayedBytes, this.extensionRegistry));
        return;
    L25:
        if (this.value == null) goto L31;
        if (r10.value != null) goto L31;
        setValue(mergeValueAndBytes(this.value, r10.delayedBytes, r10.extensionRegistry));
        return;
    L31:
        if (r10.extensionRegistry == null) goto L35;
        setValue(mergeValueAndBytes(this.value, r10.toByteString(), r10.extensionRegistry));
        return;
    L35:
        if (this.extensionRegistry == null) goto L38;
        setValue(mergeValueAndBytes(r10.value, toByteString(), this.extensionRegistry));
        return;
    L38:
        setValue(mergeValueAndBytes(this.value, r10.toByteString(), EMPTY_REGISTRY));
    }

    public void mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) throws IOException {
        if (containsDefaultInstance() == false) goto L7;
        setByteString(r10.readBytes(), r11);
        return;
    L7:
        if (this.extensionRegistry != null) goto L9;
        this.extensionRegistry = r11;
    L9:
        ByteString r12 = this.delayedBytes;
        if (r12 == null) goto L16;
        setByteString(r12.concat(r10.readBytes()), this.extensionRegistry);
        return;
    L16:
        setValue(this.value.toBuilder().mergeFrom(r10, r11).build());     // Catch: InvalidProtocolBufferException -> L15
        return;
    }

    public void set(LazyFieldLite r10) {
        this.delayedBytes = r10.delayedBytes;
        this.value = r10.value;
        this.memoizedBytes = r10.memoizedBytes;
        ExtensionRegistryLite r11 = r10.extensionRegistry;
        if (r11 == null) goto L6;
        this.extensionRegistry = r11;
        return;
    }

    public void setByteString(ByteString r10, ExtensionRegistryLite r11) {
        checkArguments(r11, r10);
        this.delayedBytes = r10;
        this.extensionRegistry = r11;
        this.value = null;
        this.memoizedBytes = null;
    }

    public MessageLite setValue(MessageLite r10) {
        MessageLite r11 = this.value;
        this.delayedBytes = null;
        this.memoizedBytes = null;
        this.value = r10;
        return r11;
    }

    public ByteString toByteString() {
        if (this.memoizedBytes != null) goto L5;
        ByteString r10 = this.delayedBytes;
        if (r10 == null) goto L9;
        return r10;
    L9:
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L11:
        if (this.memoizedBytes == null) goto L18;
        ByteString r11 = this.memoizedBytes;     // Catch: Throwable -> L15
        monitor-exit(this);     // Catch: Throwable -> L15
        return r11;
    L18:
        if (this.value != null) goto L20;
        this.memoizedBytes = ByteString.EMPTY;     // Catch: Throwable -> L15
    L21:
        ByteString r12 = this.memoizedBytes;     // Catch: Throwable -> L15
        monitor-exit(this);     // Catch: Throwable -> L15
        return r12;
    L20:
        this.memoizedBytes = this.value.toByteString();     // Catch: Throwable -> L15
        goto L21
    L5:
        return this.memoizedBytes;
    }

    public LazyFieldLite() {
    }
}
