package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.ArrayDecoders;
import java.io.IOException;

/* loaded from: classes2.dex */
interface Schema<T> {
    boolean equals(T t9, T t10);

    int getSerializedSize(T t9);

    int hashCode(T t9);

    boolean isInitialized(T t9);

    void makeImmutable(T t9);

    void mergeFrom(T t9, Reader reader, ExtensionRegistryLite extensionRegistryLite) throws IOException;

    void mergeFrom(T t9, T t10);

    void mergeFrom(T t9, byte[] bArr, int i, int i6, ArrayDecoders.Registers registers) throws IOException;

    T newInstance();

    void writeTo(T t9, Writer writer) throws IOException;
}
