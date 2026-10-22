package com.bytedance.location.protobuf;

import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
@CheckReturnValue
interface Schema<T> {
    boolean equals(T r1, T r2);

    int getSerializedSize(T r1);

    int hashCode(T r1);

    boolean isInitialized(T r1);

    void makeImmutable(T r1);

    void mergeFrom(T r1, Reader r2, ExtensionRegistryLite r3) throws IOException;

    void mergeFrom(T r1, T r2);

    void mergeFrom(T r1, byte[] r2, int r3, int r4, ArrayDecoders.Registers r5) throws IOException;

    T newInstance();

    void writeTo(T r1, Writer r2) throws IOException;
}
