package com.android.server.appfunctions;

import android.app.appfunctions.AppFunctionRuntimeMetadata;
import android.app.appsearch.AppSearchBatchResult;
import android.app.appsearch.AppSearchManager;
import android.app.appsearch.AppSearchResult;
import android.app.appsearch.AppSearchSchema;
import android.app.appsearch.GenericDocument;
import android.app.appsearch.PackageIdentifier;
import android.app.appsearch.PropertyPath;
import android.app.appsearch.PutDocumentsRequest;
import android.app.appsearch.RemoveByDocumentIdRequest;
import android.app.appsearch.SearchResult;
import android.app.appsearch.SearchSpec;
import android.app.appsearch.SetSchemaRequest;
import android.app.appsearch.SetSchemaResponse;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.Slog;
import com.android.internal.infra.AndroidFuture;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes.dex */
public class MetadataSyncAdapter {
    public static final int EXECUTE_APP_FUNCTIONS = 9;
    private static final String TAG = null;
    private final AppSearchManager mAppSearchManager;
    private Future<?> mCurrentSyncTask;
    private final ExecutorService mExecutor;
    private final Object mLock;
    private final PackageManager mPackageManager;

    public static /* synthetic */ ArraySet $r8$lambda$CBjQBlCD4YksJi7K1SzBIv7SPQI(String r0) {
        return lambda$getPackageToFunctionIdMap$1(r0);
    }

    public static /* synthetic */ void $r8$lambda$DYPEgw1PQUL9Ehs5opJEeqwWcVk(MetadataSyncAdapter r0, AppSearchManager.SearchContext r1, AppSearchManager.SearchContext r2, AndroidFuture r3) {
        r0.lambda$submitSyncRequest$0(r1, r2, r3);
    }

    static {
        TAG = MetadataSyncAdapter.class.getSimpleName();
    }

    public MetadataSyncAdapter(PackageManager packageManager, AppSearchManager appSearchManager) {
        this.mLock = new Object();
        packageManager.getClass();
        this.mPackageManager = packageManager;
        appSearchManager.getClass();
        this.mAppSearchManager = appSearchManager;
        this.mExecutor = Executors.newSingleThreadExecutor(new NamedThreadFactory("AppFunctionSyncExecutors"));
    }

    public AndroidFuture<Boolean> submitSyncRequest() {
        final AppSearchManager.SearchContext staticMetadataSearchContext = new AppSearchManager.SearchContext.Builder("apps-db").build();
        final AppSearchManager.SearchContext runtimeMetadataSearchContext = new AppSearchManager.SearchContext.Builder("appfunctions-db").build();
        final AndroidFuture<Boolean> settableSyncStatus = new AndroidFuture();
        Runnable runnable = new MetadataSyncAdapter$$ExternalSyntheticLambda0(this, staticMetadataSearchContext, runtimeMetadataSearchContext, settableSyncStatus);
        Object r4 = this.mLock;
        monitor-enter(r4);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mCurrentSyncTask != null) goto L7;
    L11:
        this.mCurrentSyncTask = this.mExecutor.submit(runnable);     // Catch: Throwable -> L9
        monitor-exit(r4);     // Catch: Throwable -> L9
        return settableSyncStatus;
    L7:
        if (this.mCurrentSyncTask.isDone() == true) goto L11;
        this.mCurrentSyncTask.cancel(false);     // Catch: Throwable -> L9
        goto L11
    }

    private /* synthetic */ void lambda$submitSyncRequest$0(AppSearchManager.SearchContext staticMetadataSearchContext, AppSearchManager.SearchContext runtimeMetadataSearchContext, AndroidFuture settableSyncStatus) {
        FutureAppSearchSession staticMetadataSearchSession = new FutureAppSearchSessionImpl(this.mAppSearchManager, AppFunctionExecutors.THREAD_POOL_EXECUTOR, staticMetadataSearchContext);     // Catch: Exception -> L8
        FutureAppSearchSession runtimeMetadataSearchSession = new FutureAppSearchSessionImpl(this.mAppSearchManager, AppFunctionExecutors.THREAD_POOL_EXECUTOR, runtimeMetadataSearchContext);     // Catch: Throwable -> L10
        trySyncAppFunctionMetadataBlocking(staticMetadataSearchSession, runtimeMetadataSearchSession);     // Catch: Throwable -> L12
        settableSyncStatus.complete(true);     // Catch: Throwable -> L12
        runtimeMetadataSearchSession.close();     // Catch: Throwable -> L10
        staticMetadataSearchSession.close();     // Catch: Exception -> L8
        return;
    L12:
        th = move-exception;
        runtimeMetadataSearchSession.close();     // Catch: Throwable -> L15
    L17:
        throw th;     // Catch: Throwable -> L10
    L15:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        staticMetadataSearchSession.close();     // Catch: Throwable -> L20
    L22:
        throw th;     // Catch: Exception -> L8
    L20:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L8
    L8:
        ex = move-exception;
        settableSyncStatus.completeExceptionally(ex);
    }

    public void shutDown() {
        this.mExecutor.shutdown();
    }

    void trySyncAppFunctionMetadataBlocking(FutureAppSearchSession staticMetadataSearchSession, FutureAppSearchSession runtimeMetadataSearchSession) throws ExecutionException, InterruptedException {
        ArrayMap<String, ArraySet<String>> staticPackageToFunctionMap = getPackageToFunctionIdMap(staticMetadataSearchSession, "AppFunctionStaticMetadata", "functionId", "packageName");
        ArrayMap<String, ArraySet<String>> runtimePackageToFunctionMap = getPackageToFunctionIdMap(runtimeMetadataSearchSession, "AppFunctionRuntimeMetadata", "functionId", "packageName");
        ArrayMap<String, ArraySet<String>> addedFunctionsDiffMap = getAddedFunctionsDiffMap(staticPackageToFunctionMap, runtimePackageToFunctionMap);
        ArrayMap<String, ArraySet<String>> removedFunctionsDiffMap = getRemovedFunctionsDiffMap(staticPackageToFunctionMap, runtimePackageToFunctionMap);
        if (staticPackageToFunctionMap.keySet().equals(runtimePackageToFunctionMap.keySet()) == true) goto L10;
        ArraySet<String> removedPackages = getRemovedPackages(staticPackageToFunctionMap.keySet(), removedFunctionsDiffMap.keySet());
        Iterator<String> r5 = removedPackages.iterator();
    L6:
        if (r5.hasNext() == false) goto L8;
        String packageName = r5.next();
        removedFunctionsDiffMap.remove(packageName);
        goto L6
    L8:
        Set<AppSearchSchema> appRuntimeMetadataSchemas = getAllRuntimeMetadataSchemas(staticPackageToFunctionMap.keySet());
        appRuntimeMetadataSchemas.add(AppFunctionRuntimeMetadata.createParentAppFunctionRuntimeSchema());
        SetSchemaRequest addSetSchemaRequest = buildSetSchemaRequestForRuntimeMetadataSchemas(this.mPackageManager, appRuntimeMetadataSchemas);
        ((SetSchemaResponse) runtimeMetadataSearchSession.setSchema(addSetSchemaRequest).get()).getClass();
    L10:
        if (removedFunctionsDiffMap.isEmpty() == true) goto L17;
        RemoveByDocumentIdRequest removeByDocumentIdRequest = buildRemoveRuntimeMetadataRequest(removedFunctionsDiffMap);
        AppSearchBatchResult<String, Void> removeDocumentBatchResult = (AppSearchBatchResult) runtimeMetadataSearchSession.remove(removeByDocumentIdRequest).get();
        if (removeDocumentBatchResult.isSuccess() == true) goto L17;
        throw convertFailedAppSearchResultToException(removeDocumentBatchResult.getFailures().values());
    L17:
        if (addedFunctionsDiffMap.isEmpty() == true) goto L23;
        PutDocumentsRequest putDocumentsRequest = buildPutRuntimeMetadataRequest(addedFunctionsDiffMap);
        AppSearchBatchResult<String, Void> putDocumentBatchResult = (AppSearchBatchResult) runtimeMetadataSearchSession.put(putDocumentsRequest).get();
        if (putDocumentBatchResult.isSuccess() == false) goto L22;
        return;
    L22:
        throw convertFailedAppSearchResultToException(putDocumentBatchResult.getFailures().values());
    }

    private static IllegalStateException convertFailedAppSearchResultToException(Collection<AppSearchResult<Void>> appSearchResult) {
        appSearchResult.getClass();
        StringBuilder errorMessages = new StringBuilder();
        Iterator<AppSearchResult<Void>> r1 = appSearchResult.iterator();
    L4:
        if (r1.hasNext() == false) goto L7;
        AppSearchResult<Void> result = r1.next();
        errorMessages.append(result.getErrorMessage());
        goto L4
    L7:
        return new IllegalStateException(errorMessages.toString());
    }

    private PutDocumentsRequest buildPutRuntimeMetadataRequest(ArrayMap<String, ArraySet<String>> addedFunctionsDiffMap) {
        addedFunctionsDiffMap.getClass();
        PutDocumentsRequest.Builder putDocumentRequestBuilder = new PutDocumentsRequest.Builder();
        int i = 0;
    L4:
        if (i >= addedFunctionsDiffMap.size()) goto L11;
        String packageName = addedFunctionsDiffMap.keyAt(i);
        ArraySet<String> addedFunctionIds = addedFunctionsDiffMap.valueAt(i);
        Iterator<String> r4 = addedFunctionIds.iterator();
    L7:
        if (r4.hasNext() == false) goto L9;
        String addedFunctionId = r4.next();
        putDocumentRequestBuilder.addGenericDocuments(new GenericDocument[]{new AppFunctionRuntimeMetadata.Builder(packageName, addedFunctionId).build()});
        goto L7
    L9:
        i = i + 1;
        goto L4
    L11:
        return putDocumentRequestBuilder.build();
    }

    private RemoveByDocumentIdRequest buildRemoveRuntimeMetadataRequest(ArrayMap<String, ArraySet<String>> removedFunctionsDiffMap) {
        removedFunctionsDiffMap.getClass();
        RemoveByDocumentIdRequest.Builder removeDocumentRequestBuilder = new RemoveByDocumentIdRequest.Builder("app_functions_runtime");
        int i = 0;
    L4:
        if (i >= removedFunctionsDiffMap.size()) goto L11;
        String packageName = removedFunctionsDiffMap.keyAt(i);
        ArraySet<String> removedFunctionIds = removedFunctionsDiffMap.valueAt(i);
        Iterator<String> r4 = removedFunctionIds.iterator();
    L7:
        if (r4.hasNext() == false) goto L9;
        String functionId = r4.next();
        String documentId = AppFunctionRuntimeMetadata.getDocumentIdForAppFunction(packageName, functionId);
        removeDocumentRequestBuilder.addIds(new String[]{documentId});
        goto L7
    L9:
        i = i + 1;
        goto L4
    L11:
        return removeDocumentRequestBuilder.build();
    }

    private SetSchemaRequest buildSetSchemaRequestForRuntimeMetadataSchemas(PackageManager packageManager, Set<AppSearchSchema> metadataSchemaSet) {
        metadataSchemaSet.getClass();
        SetSchemaRequest.Builder setSchemaRequestBuilder = new SetSchemaRequest.Builder().setForceOverride(true).addSchemas(metadataSchemaSet);
        Iterator<AppSearchSchema> r2 = metadataSchemaSet.iterator();
    L4:
        if (r2.hasNext() == false) goto L10;
        AppSearchSchema runtimeMetadataSchema = r2.next();
        String packageName = AppFunctionRuntimeMetadata.getPackageNameFromSchema(runtimeMetadataSchema.getSchemaType());
        byte[] packageCert = getCertificate(packageManager, packageName);
        if (packageCert == null) goto L4;
        setSchemaRequestBuilder.setSchemaTypeVisibilityForPackage(runtimeMetadataSchema.getSchemaType(), true, new PackageIdentifier(packageName, packageCert));
        setSchemaRequestBuilder.addRequiredPermissionsForSchemaTypeVisibility(runtimeMetadataSchema.getSchemaType(), Set.of(9));
        goto L4
    L10:
        return setSchemaRequestBuilder.build();
    }

    private Set<AppSearchSchema> getAllRuntimeMetadataSchemas(Set<String> staticMetadataPackages) {
        staticMetadataPackages.getClass();
        Set<AppSearchSchema> appRuntimeMetadataSchemas = new ArraySet();
        Iterator<String> r1 = staticMetadataPackages.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        String packageName = r1.next();
        appRuntimeMetadataSchemas.add(AppFunctionRuntimeMetadata.createAppFunctionRuntimeSchema(packageName));
        goto L4
    L6:
        return appRuntimeMetadataSchemas;
    }

    private static ArraySet<String> getRemovedPackages(Set<String> allExistingStaticPackages, Set<String> removedFunctionPackages) {
        ArraySet<String> removedPackages = new ArraySet();
        Iterator<String> r1 = removedFunctionPackages.iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        String packageName = r1.next();
        if (allExistingStaticPackages.contains(packageName) == true) goto L4;
        removedPackages.add(packageName);
        goto L4
    L9:
        return removedPackages;
    }

    static ArrayMap<String, ArraySet<String>> getAddedFunctionsDiffMap(ArrayMap<String, ArraySet<String>> staticPackageToFunctionMap, ArrayMap<String, ArraySet<String>> runtimePackageToFunctionMap) {
        staticPackageToFunctionMap.getClass();
        runtimePackageToFunctionMap.getClass();
        return getFunctionsDiffMap(staticPackageToFunctionMap, runtimePackageToFunctionMap);
    }

    static ArrayMap<String, ArraySet<String>> getRemovedFunctionsDiffMap(ArrayMap<String, ArraySet<String>> staticPackageToFunctionMap, ArrayMap<String, ArraySet<String>> runtimePackageToFunctionMap) {
        staticPackageToFunctionMap.getClass();
        runtimePackageToFunctionMap.getClass();
        return getFunctionsDiffMap(runtimePackageToFunctionMap, staticPackageToFunctionMap);
    }

    private static ArrayMap<String, ArraySet<String>> getFunctionsDiffMap(ArrayMap<String, ArraySet<String>> packageToFunctionMapA, ArrayMap<String, ArraySet<String>> packageToFunctionMapB) {
        packageToFunctionMapA.getClass();
        packageToFunctionMapB.getClass();
        ArrayMap<String, ArraySet<String>> diffMap = new ArrayMap();
        Iterator<String> r1 = packageToFunctionMapA.keySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L19;
        String packageName = r1.next();
        if (packageToFunctionMapB.containsKey(packageName) == false) goto L7;
        ArraySet<String> diffFunctions = new ArraySet();
        ArraySet<String> r4 = packageToFunctionMapA.get(packageName);
        r4.getClass();
        Iterator<String> r5 = r4.iterator();
    L10:
        if (r5.hasNext() == false) goto L16;
        String functionId = r5.next();
        ArraySet<String> r6 = packageToFunctionMapB.get(packageName);
        r6.getClass();
        if (r6.contains(functionId) == true) goto L10;
        diffFunctions.add(functionId);
        goto L10
    L16:
        if (diffFunctions.isEmpty() == true) goto L4;
        diffMap.put(packageName, diffFunctions);
        goto L4
    L7:
        diffMap.put(packageName, packageToFunctionMapA.get(packageName));
        goto L4
    L19:
        return diffMap;
    }

    static ArrayMap<String, ArraySet<String>> getPackageToFunctionIdMap(FutureAppSearchSession searchSession, String schemaType, String propertyFunctionId, String propertyPackageName) throws ExecutionException, InterruptedException {
        schemaType.getClass();
        propertyFunctionId.getClass();
        propertyPackageName.getClass();
        ArrayMap<String, ArraySet<String>> packageToFunctionIds = new ArrayMap();
        FutureSearchResults futureSearchResults = (FutureSearchResults) searchSession.search("", buildMetadataSearchSpec(schemaType, propertyFunctionId, propertyPackageName)).get();
        List<SearchResult> searchResultsList = (List) futureSearchResults.getNextPage().get();     // Catch: Throwable -> L10
    L4:
        if (searchResultsList.isEmpty() == true) goto L14;
        Iterator<SearchResult> r3 = searchResultsList.iterator();     // Catch: Throwable -> L10
    L8:
        if (r3.hasNext() == false) goto L13;
        SearchResult searchResult = r3.next();     // Catch: Throwable -> L10
        String packageName = searchResult.getGenericDocument().getPropertyString(propertyPackageName);     // Catch: Throwable -> L10
        String functionId = searchResult.getGenericDocument().getPropertyString(propertyFunctionId);     // Catch: Throwable -> L10
        packageToFunctionIds.computeIfAbsent(packageName, new MetadataSyncAdapter$$ExternalSyntheticLambda1()).add(functionId);     // Catch: Throwable -> L10
        goto L8
    L13:
        searchResultsList = (List) futureSearchResults.getNextPage().get();     // Catch: Throwable -> L10
        goto L4
    L14:
        futureSearchResults.close();
        return packageToFunctionIds;
    L10:
        th = move-exception;
        if (futureSearchResults != null) goto L24;
    L21:
        throw th;
    L24:
        futureSearchResults.close();     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        th.addSuppressed(th);
        goto L21
    }

    private static /* synthetic */ ArraySet lambda$getPackageToFunctionIdMap$1(String k) {
        return new ArraySet();
    }

    private static SearchSpec buildMetadataSearchSpec(String schemaType, String propertyFunctionId, String propertyPackageName) {
        schemaType.getClass();
        propertyFunctionId.getClass();
        propertyPackageName.getClass();
        return new SearchSpec.Builder().addFilterSchemas(new String[]{schemaType}).addProjectionPaths(schemaType, List.of(new PropertyPath(propertyFunctionId), new PropertyPath(propertyPackageName))).build();
    }

    private byte[] getCertificate(PackageManager packageManager, String packageName) {
        packageManager.getClass();
        packageName.getClass();
        PackageInfo packageInfo = packageManager.getPackageInfo(packageName, 134217856);     // Catch: Exception -> L19
        packageInfo.getClass();     // Catch: Exception -> L19
        if (packageInfo.signingInfo != null) goto L22;
        Slog.d(TAG, "Signing info not found for package: " + packageInfo.packageName);
        return null;
    L22:
        MessageDigest md = MessageDigest.getInstance("SHA256");     // Catch: NoSuchAlgorithmException -> L17
        Signature[] signatures = packageInfo.signingInfo.getSigningCertificateHistory();
        if (signatures != null) goto L12;
    L16:
        return null;
    L12:
        if (signatures.length == 0) goto L16;
        md.update(signatures[0].toByteArray());
        return md.digest();
    L18:
        return null;
    L20:
        Slog.d(TAG, "Package name info not found for package: " + packageName);
        return null;
    }
}
