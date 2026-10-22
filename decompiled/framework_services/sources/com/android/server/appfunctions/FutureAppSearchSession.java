package com.android.server.appfunctions;

import android.app.appsearch.AppSearchBatchResult;
import android.app.appsearch.GenericDocument;
import android.app.appsearch.GetByDocumentIdRequest;
import android.app.appsearch.GetSchemaResponse;
import android.app.appsearch.PutDocumentsRequest;
import android.app.appsearch.RemoveByDocumentIdRequest;
import android.app.appsearch.SearchSpec;
import android.app.appsearch.SetSchemaRequest;
import android.app.appsearch.SetSchemaResponse;
import com.android.internal.infra.AndroidFuture;
import java.io.Closeable;

/* JADX INFO: loaded from: classes.dex */
public interface FutureAppSearchSession extends Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    AndroidFuture<AppSearchBatchResult<String, GenericDocument>> getByDocumentId(GetByDocumentIdRequest r1);

    AndroidFuture<GetSchemaResponse> getSchema();

    AndroidFuture<AppSearchBatchResult<String, Void>> put(PutDocumentsRequest r1);

    AndroidFuture<AppSearchBatchResult<String, Void>> remove(RemoveByDocumentIdRequest r1);

    AndroidFuture<FutureSearchResults> search(String r1, SearchSpec r2);

    AndroidFuture<SetSchemaResponse> setSchema(SetSchemaRequest r1);
}
