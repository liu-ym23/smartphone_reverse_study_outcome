package androidx.appsearch.app;

import android.annotation.SuppressLint;
import androidx.appsearch.flags.FlaggedApi;
import androidx.appsearch.flags.Flags;
import java.io.Closeable;
import java.util.Set;
import n3.InterfaceFutureC1739a;

/* loaded from: classes.dex */
public interface AppSearchSession extends Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    @ExperimentalAppSearchApi
    @FlaggedApi(Flags.FLAG_ENABLE_BLOB_STORE)
    default InterfaceFutureC1739a commitBlobAsync(Set<AppSearchBlobHandle> set) {
        throw new UnsupportedOperationException("BLOB_STORAGE is not available on this AppSearch implementation.");
    }

    InterfaceFutureC1739a getByDocumentIdAsync(GetByDocumentIdRequest getByDocumentIdRequest);

    Features getFeatures();

    InterfaceFutureC1739a getNamespacesAsync();

    @SuppressLint({"KotlinPropertyAccess"})
    InterfaceFutureC1739a getSchemaAsync();

    InterfaceFutureC1739a getStorageInfoAsync();

    @ExperimentalAppSearchApi
    @FlaggedApi(Flags.FLAG_ENABLE_BLOB_STORE)
    default InterfaceFutureC1739a openBlobForReadAsync(Set<AppSearchBlobHandle> set) {
        throw new UnsupportedOperationException("BLOB_STORAGE is not available on this AppSearch implementation.");
    }

    @ExperimentalAppSearchApi
    @FlaggedApi(Flags.FLAG_ENABLE_BLOB_STORE)
    default InterfaceFutureC1739a openBlobForWriteAsync(Set<AppSearchBlobHandle> set) {
        throw new UnsupportedOperationException("BLOB_STORAGE is not available on this AppSearch implementation.");
    }

    InterfaceFutureC1739a putAsync(PutDocumentsRequest putDocumentsRequest);

    InterfaceFutureC1739a removeAsync(RemoveByDocumentIdRequest removeByDocumentIdRequest);

    InterfaceFutureC1739a removeAsync(String str, SearchSpec searchSpec);

    @ExperimentalAppSearchApi
    @FlaggedApi(Flags.FLAG_ENABLE_BLOB_STORE)
    default InterfaceFutureC1739a removeBlobAsync(Set<AppSearchBlobHandle> set) {
        throw new UnsupportedOperationException("BLOB_STORAGE is not available on this AppSearch implementation.");
    }

    InterfaceFutureC1739a reportUsageAsync(ReportUsageRequest reportUsageRequest);

    InterfaceFutureC1739a requestFlushAsync();

    SearchResults search(String str, SearchSpec searchSpec);

    InterfaceFutureC1739a searchSuggestionAsync(String str, SearchSuggestionSpec searchSuggestionSpec);

    @ExperimentalAppSearchApi
    @FlaggedApi(Flags.FLAG_ENABLE_BLOB_STORE)
    default InterfaceFutureC1739a setBlobVisibilityAsync(SetBlobVisibilityRequest setBlobVisibilityRequest) {
        throw new UnsupportedOperationException("BLOB_STORAGE is not available on this AppSearch implementation.");
    }

    InterfaceFutureC1739a setSchemaAsync(SetSchemaRequest setSchemaRequest);
}
