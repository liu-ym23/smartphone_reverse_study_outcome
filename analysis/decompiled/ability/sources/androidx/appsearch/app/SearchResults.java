package androidx.appsearch.app;

import java.io.Closeable;
import n3.InterfaceFutureC1739a;

/* loaded from: classes.dex */
public interface SearchResults extends Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    InterfaceFutureC1739a getNextPageAsync();
}
