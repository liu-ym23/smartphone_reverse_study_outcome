package androidx.datastore.preferences.protobuf;

import java.io.IOException;

/* loaded from: classes.dex */
public interface Z<T> {
    void a(T t10, Y y10, C1351n c1351n) throws IOException;

    void b(T t10, Writer writer) throws IOException;

    boolean equals(T t10, T t11);

    int getSerializedSize(T t10);

    int hashCode(T t10);

    boolean isInitialized(T t10);

    void makeImmutable(T t10);

    void mergeFrom(T t10, T t11);

    T newInstance();
}
