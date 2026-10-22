package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.ArrayDecoders;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
@CheckReturnValue
/* loaded from: classes.dex */
interface Schema<T> {
    boolean equals(T t10, T t11);

    int getSerializedSize(T t10);

    int hashCode(T t10);

    boolean isInitialized(T t10);

    void makeImmutable(T t10);

    void mergeFrom(T t10, Reader reader, ExtensionRegistryLite extensionRegistryLite);

    void mergeFrom(T t10, T t11);

    void mergeFrom(T t10, byte[] bArr, int i, int i3, ArrayDecoders.Registers registers);

    T newInstance();

    void writeTo(T t10, Writer writer);
}
