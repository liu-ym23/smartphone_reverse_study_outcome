package androidx.appsearch.app;

import android.annotation.SuppressLint;
import androidx.appsearch.exceptions.AppSearchException;
import androidx.appsearch.flags.FlaggedApi;
import androidx.appsearch.flags.Flags;
import androidx.appsearch.observer.ObserverCallback;
import androidx.appsearch.observer.ObserverSpec;
import java.io.Closeable;
import java.util.Set;
import java.util.concurrent.Executor;
import n3.InterfaceFutureC1739a;

/* loaded from: classes.dex */
public interface GlobalSearchSession extends Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    InterfaceFutureC1739a getByDocumentIdAsync(String str, String str2, GetByDocumentIdRequest getByDocumentIdRequest);

    Features getFeatures();

    @SuppressLint({"KotlinPropertyAccess"})
    InterfaceFutureC1739a getSchemaAsync(String str, String str2);

    @ExperimentalAppSearchApi
    @FlaggedApi(Flags.FLAG_ENABLE_BLOB_STORE)
    default InterfaceFutureC1739a openBlobForReadAsync(Set<AppSearchBlobHandle> set) {
        throw new UnsupportedOperationException("BLOB_STORAGE is not available on this AppSearch implementation.");
    }

    void registerObserverCallback(String str, ObserverSpec observerSpec, Executor executor, ObserverCallback observerCallback) throws AppSearchException;

    InterfaceFutureC1739a reportSystemUsageAsync(ReportSystemUsageRequest reportSystemUsageRequest);

    SearchResults search(String str, SearchSpec searchSpec);

    void unregisterObserverCallback(String str, ObserverCallback observerCallback) throws AppSearchException;
}
