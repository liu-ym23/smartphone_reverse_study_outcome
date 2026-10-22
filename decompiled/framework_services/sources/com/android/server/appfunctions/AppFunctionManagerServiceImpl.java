package com.android.server.appfunctions;

import android.app.appfunctions.AppFunctionException;
import android.app.appfunctions.AppFunctionManagerHelper;
import android.app.appfunctions.AppFunctionRuntimeMetadata;
import android.app.appfunctions.ExecuteAppFunctionAidlRequest;
import android.app.appfunctions.IAppFunctionEnabledCallback;
import android.app.appfunctions.IAppFunctionManager;
import android.app.appfunctions.IAppFunctionService;
import android.app.appfunctions.ICancellationCallback;
import android.app.appfunctions.IExecuteAppFunctionCallback;
import android.app.appfunctions.SafeOneTimeExecuteAppFunctionCallback;
import android.app.appsearch.AppSearchBatchResult;
import android.app.appsearch.AppSearchManager;
import android.app.appsearch.GenericDocument;
import android.app.appsearch.GetByDocumentIdRequest;
import android.app.appsearch.PutDocumentsRequest;
import android.app.appsearch.observer.DocumentChangeInfo;
import android.app.appsearch.observer.ObserverCallback;
import android.app.appsearch.observer.ObserverSpec;
import android.app.appsearch.observer.SchemaChangeInfo;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManagerInternal;
import android.content.pm.SigningInfo;
import android.os.Binder;
import android.os.CancellationSignal;
import android.os.IBinder;
import android.os.ICancellationSignal;
import android.os.ParcelableException;
import android.os.RemoteException;
import android.os.UserHandle;
import android.text.TextUtils;
import android.util.Slog;
import com.android.internal.infra.AndroidFuture;
import com.android.internal.util.DumpUtils;
import com.android.server.SystemService;
import com.android.server.pm.PackageManagerService;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.CompletionException;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class AppFunctionManagerServiceImpl extends IAppFunctionManager.Stub {
    private static final String TAG = null;
    private final CallerValidator mCallerValidator;
    private final Context mContext;
    private final ServiceHelper mInternalServiceHelper;
    private final Map<String, Object> mLocks;
    private final AppFunctionsLoggerWrapper mLoggerWrapper;
    private final PackageManagerInternal mPackageManagerInternal;
    private final RemoteServiceCaller<IAppFunctionService> mRemoteServiceCaller;
    private final ServiceConfig mServiceConfig;

    private static class AppFunctionMetadataObserver implements ObserverCallback {
        private final MetadataSyncAdapter mPerUserMetadataSyncAdapter;

        AppFunctionMetadataObserver(UserHandle userHandle, Context userContext) {
            this.mPerUserMetadataSyncAdapter = MetadataSyncPerUser.getPerUserMetadataSyncAdapter(userHandle, userContext);
        }

        @Override // android.app.appsearch.observer.ObserverCallback
        public void onDocumentChanged(DocumentChangeInfo documentChangeInfo) {
            if (this.mPerUserMetadataSyncAdapter != null) goto L6;
            return;
        L6:
            if (documentChangeInfo.getDatabaseName().equals("apps-db") == true) goto L8;
            return;
        L8:
            if (documentChangeInfo.getNamespace().equals("app_functions") == false) goto L12;
            this.mPerUserMetadataSyncAdapter.submitSyncRequest();
            return;
        }

        @Override // android.app.appsearch.observer.ObserverCallback
        public void onSchemaChanged(SchemaChangeInfo schemaChangeInfo) {
            if (this.mPerUserMetadataSyncAdapter != null) goto L6;
            return;
        L6:
            if (schemaChangeInfo.getDatabaseName().equals("apps-db") == false) goto L20;
            boolean shouldInitiateSync = false;
            Iterator<String> r1 = schemaChangeInfo.getChangedSchemaNames().iterator();
        L9:
            if (r1.hasNext() == false) goto L14;
            String schemaName = r1.next();
            if (schemaName.startsWith("AppFunctionStaticMetadata") == false) goto L9;
            shouldInitiateSync = true;
        L14:
            if (shouldInitiateSync == false) goto L21;
            this.mPerUserMetadataSyncAdapter.submitSyncRequest();
            return;
        L21:
            return;
        }
    }

    private static class DisabledAppFunctionException extends RuntimeException {
        /* synthetic */ DisabledAppFunctionException(String r1, AppFunctionManagerServiceImplIA r2) {
            this(r1);
        }

        private DisabledAppFunctionException(String errorMessage) {
            super(errorMessage);
        }
    }

    public static /* synthetic */ Object $r8$lambda$83VSvtUgiCvOfCoY2fr5GTdlHik(String r0) {
        return lambda$getLockForPackage$8(r0);
    }

    public static /* synthetic */ void $r8$lambda$KEoWxzH9uq6uNoEYYtTp5qRF6aQ(FutureGlobalSearchSession r0, Void r1, Throwable r2) {
        lambda$registerAppSearchObserver$6(r0, r1, r2);
    }

    public static /* synthetic */ Integer $r8$lambda$NcP1s5Km9gVoMSZwK8xweONTcYM(Integer r0, Boolean r1) {
        return lambda$executeAppFunctionInternal$1(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$NtV0Vpf9alWQDF3VN-_R1DwAYog, reason: not valid java name */
    public static /* synthetic */ Void m1683$r8$lambda$NtV0Vpf9alWQDF3VN_R1DwAYog(AppFunctionManagerServiceImpl r0, SafeOneTimeExecuteAppFunctionCallback r1, Throwable r2) {
        return r0.lambda$executeAppFunctionInternal$4(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$Vo7P-n_xA2kyqnOUjQevDM5n1K8, reason: not valid java name */
    public static /* synthetic */ void m1684$r8$lambda$Vo7Pn_xA2kyqnOUjQevDM5n1K8(AppFunctionManagerServiceImpl r0, String r1, UserHandle r2, SafeOneTimeExecuteAppFunctionCallback r3, ExecuteAppFunctionAidlRequest r4, int r5, ICancellationSignal r6, IBinder r7, Integer r8) {
        r0.lambda$executeAppFunctionInternal$3(r1, r2, r3, r4, r5, r6, r7, r8);
    }

    public static /* synthetic */ void $r8$lambda$giixtBhts1WbYY_qneUXlyEjzSU(Boolean r0, Throwable r1) {
        lambda$trySyncRuntimeMetadata$7(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$ijLVbAaSQj-Gar67nBj7J2jT2ps, reason: not valid java name */
    public static /* synthetic */ CompletionStage m1685$r8$lambda$ijLVbAaSQjGar67nBj7J2jT2ps(AppFunctionManagerServiceImpl r0, ExecuteAppFunctionAidlRequest r1, Integer r2) {
        return r0.lambda$executeAppFunctionInternal$2(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$nRYDTFk56Qrw6oZWnAzd50WVJqk(AppFunctionManagerServiceImpl r0, String r1, String r2, UserHandle r3, int r4, IAppFunctionEnabledCallback r5) {
        r0.lambda$setAppFunctionEnabled$5(r1, r2, r3, r4, r5);
    }

    /* JADX INFO: renamed from: $r8$lambda$tAQGcGMOD8rGPZM-0NgY6tTxlmE, reason: not valid java name */
    public static /* synthetic */ void m1686$r8$lambda$tAQGcGMOD8rGPZM0NgY6tTxlmE(AppFunctionManagerServiceImpl r0, ExecuteAppFunctionAidlRequest r1, int r2, int r3, ICancellationSignal r4, SafeOneTimeExecuteAppFunctionCallback r5, IExecuteAppFunctionCallback r6) {
        r0.lambda$executeAppFunction$0(r1, r2, r3, r4, r5, r6);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLoggerWrapper, reason: not valid java name */
    static /* bridge */ /* synthetic */ AppFunctionsLoggerWrapper m1687$$Nest$fgetmLoggerWrapper(AppFunctionManagerServiceImpl r0) {
        return r0.mLoggerWrapper;
    }

    static {
        TAG = AppFunctionManagerServiceImpl.class.getSimpleName();
    }

    public AppFunctionManagerServiceImpl(Context context, PackageManagerInternal packageManagerInternal) {
        this(context, new RemoteServiceCallerImpl(context, new AppFunctionManagerServiceImpl$$ExternalSyntheticLambda9(), AppFunctionExecutors.THREAD_POOL_EXECUTOR), new CallerValidatorImpl(context), new ServiceHelperImpl(context), new ServiceConfigImpl(), new AppFunctionsLoggerWrapper(context), packageManagerInternal);
    }

    AppFunctionManagerServiceImpl(Context context, RemoteServiceCaller<IAppFunctionService> remoteServiceCaller, CallerValidator callerValidator, ServiceHelper appFunctionInternalServiceHelper, ServiceConfig serviceConfig, AppFunctionsLoggerWrapper loggerWrapper, PackageManagerInternal packageManagerInternal) {
        this.mLocks = new WeakHashMap();
        context.getClass();
        this.mContext = context;
        remoteServiceCaller.getClass();
        this.mRemoteServiceCaller = remoteServiceCaller;
        callerValidator.getClass();
        this.mCallerValidator = callerValidator;
        appFunctionInternalServiceHelper.getClass();
        this.mInternalServiceHelper = appFunctionInternalServiceHelper;
        this.mServiceConfig = serviceConfig;
        this.mLoggerWrapper = loggerWrapper;
        packageManagerInternal.getClass();
        this.mPackageManagerInternal = packageManagerInternal;
    }

    public void onUserUnlocked(SystemService.TargetUser user) {
        user.getClass();
        registerAppSearchObserver(user);
        trySyncRuntimeMetadata(user);
    }

    public void onUserStopping(SystemService.TargetUser user) {
        user.getClass();
        MetadataSyncPerUser.removeUserSyncAdapter(user.getUserHandle());
    }

    public void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
        if (DumpUtils.checkDumpPermission(this.mContext, TAG, pw) == true) goto L5;
        return;
    L5:
        long token = Binder.clearCallingIdentity();
        AppFunctionDumpHelper.dumpAppFunctionsState(this.mContext, pw);     // Catch: Throwable -> L9
        Binder.restoreCallingIdentity(token);
        return;
    L9:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    public ICancellationSignal executeAppFunction(final ExecuteAppFunctionAidlRequest requestInternal, final IExecuteAppFunctionCallback executeAppFunctionCallback) {
        requestInternal.getClass();
        executeAppFunctionCallback.getClass();
        final int callingUid = Binder.getCallingUid();
        final int callingPid = Binder.getCallingPid();
        final SafeOneTimeExecuteAppFunctionCallback safeExecuteAppFunctionCallback = initializeSafeExecuteAppFunctionCallback(requestInternal, executeAppFunctionCallback, callingUid);
        String validatedCallingPackage = this.mCallerValidator.validateCallingPackage(requestInternal.getCallingPackage());     // Catch: SecurityException -> L6
        this.mCallerValidator.verifyTargetUserHandle(requestInternal.getUserHandle(), validatedCallingPackage);     // Catch: SecurityException -> L6
        final ICancellationSignal localCancelTransport = CancellationSignal.createTransport();
        AppFunctionExecutors.THREAD_POOL_EXECUTOR.execute(new AppFunctionManagerServiceImpl$$ExternalSyntheticLambda7(this, requestInternal, callingUid, callingPid, localCancelTransport, safeExecuteAppFunctionCallback, executeAppFunctionCallback));
        return localCancelTransport;
    L6:
        exception = move-exception;
        safeExecuteAppFunctionCallback.onError(new AppFunctionException(1000, exception.getMessage()));
        return null;
    }

    private /* synthetic */ void lambda$executeAppFunction$0(ExecuteAppFunctionAidlRequest requestInternal, int callingUid, int callingPid, ICancellationSignal localCancelTransport, SafeOneTimeExecuteAppFunctionCallback safeExecuteAppFunctionCallback, IExecuteAppFunctionCallback executeAppFunctionCallback) {
        SafeOneTimeExecuteAppFunctionCallback safeExecuteAppFunctionCallback2 = safeExecuteAppFunctionCallback;
        executeAppFunctionInternal(requestInternal, callingUid, callingPid, localCancelTransport, safeExecuteAppFunctionCallback2, executeAppFunctionCallback.asBinder());     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        Exception e = e;
    L10:
        safeExecuteAppFunctionCallback2.onError(mapExceptionToExecuteAppFunctionResponse(e));
        return;
    L8:
        e = move-exception;
        safeExecuteAppFunctionCallback2 = safeExecuteAppFunctionCallback;
        e = e;
        goto L10
    }

    private void executeAppFunctionInternal(final ExecuteAppFunctionAidlRequest requestInternal, final int callingUid, int callingPid, final ICancellationSignal localCancelTransport, final SafeOneTimeExecuteAppFunctionCallback safeExecuteAppFunctionCallback, final IBinder callerBinder) {
        final UserHandle targetUser = requestInternal.getUserHandle();
        UserHandle callingUser = UserHandle.getUserHandleForUid(callingUid);
        if (this.mCallerValidator.verifyEnterprisePolicyIsAllowed(callingUser, targetUser) == true) goto L6;
        safeExecuteAppFunctionCallback.onError(new AppFunctionException(2002, "Cannot run on a user with a restricted enterprise policy"));
        return;
    L6:
        final String targetPackageName = requestInternal.getClientRequest().getTargetPackageName();
        if (TextUtils.isEmpty(targetPackageName) == false) goto L10;
        safeExecuteAppFunctionCallback.onError(new AppFunctionException(1001, "Target package name cannot be empty."));
        return;
    L10:
        this.mCallerValidator.verifyCallerCanExecuteAppFunction(callingUid, callingPid, targetUser, requestInternal.getCallingPackage(), targetPackageName, requestInternal.getClientRequest().getFunctionIdentifier()).thenCompose(new AppFunctionManagerServiceImpl$$ExternalSyntheticLambda0(this, requestInternal)).thenAccept(new AppFunctionManagerServiceImpl$$ExternalSyntheticLambda1(this, targetPackageName, targetUser, safeExecuteAppFunctionCallback, requestInternal, callingUid, localCancelTransport, callerBinder)).exceptionally(new AppFunctionManagerServiceImpl$$ExternalSyntheticLambda2(this, safeExecuteAppFunctionCallback));
    }

    private /* synthetic */ CompletionStage lambda$executeAppFunctionInternal$2(ExecuteAppFunctionAidlRequest requestInternal, final Integer canExecuteResult) {
        if (canExecuteResult.intValue() != 0) goto L7;
        return AndroidFuture.failedFuture(new SecurityException("Caller does not have permission to execute the appfunction"));
    L7:
        return isAppFunctionEnabled(requestInternal.getClientRequest().getFunctionIdentifier(), requestInternal.getClientRequest().getTargetPackageName(), getAppSearchManagerAsUser(requestInternal.getUserHandle()), AppFunctionExecutors.THREAD_POOL_EXECUTOR).thenApply(new AppFunctionManagerServiceImpl$$ExternalSyntheticLambda8(canExecuteResult));
    }

    private static /* synthetic */ Integer lambda$executeAppFunctionInternal$1(Integer canExecuteResult, Boolean isEnabled) {
        if (isEnabled.booleanValue() == false) goto L6;
        return canExecuteResult;
    L6:
        throw new DisabledAppFunctionException("The app function is disabled", null);
    }

    private /* synthetic */ void lambda$executeAppFunctionInternal$3(String targetPackageName, UserHandle targetUser, SafeOneTimeExecuteAppFunctionCallback safeExecuteAppFunctionCallback, ExecuteAppFunctionAidlRequest requestInternal, int callingUid, ICancellationSignal localCancelTransport, IBinder callerBinder, Integer canExecuteResult) {
        if (canExecuteResult.intValue() != 2) goto L5;
        int bindFlags = 1 | 67108864;
        int bindFlags2 = bindFlags;
    L6:
        Intent serviceIntent = this.mInternalServiceHelper.resolveAppFunctionService(targetPackageName, targetUser);
        if (serviceIntent != null) goto L10;
        safeExecuteAppFunctionCallback.onError(new AppFunctionException(2000, "Cannot find the target service."));
        return;
    L10:
        int grantRecipientUserId = targetUser.getIdentifier();
        int grantRecipientAppId = UserHandle.getAppId(this.mPackageManagerInternal.getPackageUid(requestInternal.getClientRequest().getTargetPackageName(), 0, grantRecipientUserId));
        if (grantRecipientAppId <= 0) goto L13;
        this.mPackageManagerInternal.grantImplicitAccess(grantRecipientUserId, serviceIntent, grantRecipientAppId, callingUid, true);
    L13:
        bindAppFunctionServiceUnchecked(requestInternal, serviceIntent, targetUser, localCancelTransport, safeExecuteAppFunctionCallback, bindFlags2, callerBinder, callingUid);
        return;
    L5:
        bindFlags2 = 1;
        goto L6
    }

    private /* synthetic */ Void lambda$executeAppFunctionInternal$4(SafeOneTimeExecuteAppFunctionCallback safeExecuteAppFunctionCallback, Throwable ex) {
        safeExecuteAppFunctionCallback.onError(mapExceptionToExecuteAppFunctionResponse(ex));
        return null;
    }

    private static AndroidFuture<Boolean> isAppFunctionEnabled(String functionIdentifier, String targetPackage, AppSearchManager appSearchManager, Executor executor) {
        final AndroidFuture<Boolean> future = new AndroidFuture();
        AppFunctionManagerHelper.isAppFunctionEnabled(functionIdentifier, targetPackage, appSearchManager, executor, new AnonymousClass1(future));
        return future;
    }

    public void setAppFunctionEnabled(final String callingPackage, final String functionIdentifier, final UserHandle userHandle, final int enabledState, final IAppFunctionEnabledCallback callback) {
        this.mCallerValidator.validateCallingPackage(callingPackage);     // Catch: SecurityException -> L5
        AppFunctionExecutors.THREAD_POOL_EXECUTOR.execute(new AppFunctionManagerServiceImpl$$ExternalSyntheticLambda6(this, callingPackage, functionIdentifier, userHandle, enabledState, callback));
        return;
    L5:
        e = move-exception;
        reportException(callback, e);
    }

    private /* synthetic */ void lambda$setAppFunctionEnabled$5(String callingPackage, String functionIdentifier, UserHandle userHandle, int enabledState, IAppFunctionEnabledCallback callback) {
        Object r0 = getLockForPackage(callingPackage);     // Catch: Exception -> L8
        monitor-enter(r0);     // Catch: Exception -> L8
        setAppFunctionEnabledInternalLocked(callingPackage, functionIdentifier, userHandle, enabledState);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        callback.onSuccess();     // Catch: Exception -> L8
        return;
    L10:
        th = move-exception;
        throw th;     // Catch: Exception -> L8
    L8:
        e = move-exception;
        Slog.e(TAG, "Error in setAppFunctionEnabled: ", e);
        reportException(callback, e);
    }

    private static void reportException(IAppFunctionEnabledCallback callback, Exception exception) {
        callback.onError(new ParcelableException(exception));     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        Slog.w(TAG, "Failed to report the exception", e);
    }

    private void setAppFunctionEnabledInternalLocked(String callingPackage, String functionIdentifier, UserHandle userHandle, int enabledState) throws Exception {
        AppSearchManager perUserAppSearchManager = getAppSearchManagerAsUser(userHandle);
        if (perUserAppSearchManager == null) goto L18;
        AppSearchManager.SearchContext runtimeMetadataSearchContext = new AppSearchManager.SearchContext.Builder("appfunctions-db").build();
        FutureAppSearchSession runtimeMetadataSearchSession = new FutureAppSearchSessionImpl(perUserAppSearchManager, AppFunctionExecutors.THREAD_POOL_EXECUTOR, runtimeMetadataSearchContext);
        AppFunctionRuntimeMetadata existingMetadata = new AppFunctionRuntimeMetadata(getRuntimeMetadataGenericDocument(callingPackage, functionIdentifier, runtimeMetadataSearchSession));     // Catch: Throwable -> L11
        AppSearchBatchResult<String, Void> putDocumentBatchResult = (AppSearchBatchResult) runtimeMetadataSearchSession.put(new PutDocumentsRequest.Builder().addGenericDocuments(new GenericDocument[]{new AppFunctionRuntimeMetadata.Builder(existingMetadata).setEnabled(enabledState).build()}).build()).get();     // Catch: Throwable -> L11
        if (putDocumentBatchResult.isSuccess() == false) goto L10;
        runtimeMetadataSearchSession.close();
        return;
    L10:
        throw new IllegalStateException("Failed writing updated doc to AppSearch due to " + putDocumentBatchResult);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        runtimeMetadataSearchSession.close();     // Catch: Throwable -> L14
    L16:
        throw th;
    L14:
        th = move-exception;
        th.addSuppressed(th);
        goto L16
    L18:
        throw new IllegalStateException("AppSearchManager not found for user:" + userHandle.getIdentifier());
    }

    private AppFunctionRuntimeMetadata getRuntimeMetadataGenericDocument(String packageName, String functionId, FutureAppSearchSession runtimeMetadataSearchSession) throws Exception {
        String documentId = AppFunctionRuntimeMetadata.getDocumentIdForAppFunction(packageName, functionId);
        GetByDocumentIdRequest request = new GetByDocumentIdRequest.Builder("app_functions_runtime").addIds(new String[]{documentId}).build();
        AppSearchBatchResult<String, GenericDocument> result = (AppSearchBatchResult) runtimeMetadataSearchSession.getByDocumentId(request).get();
        if (result.isSuccess() == false) goto L7;
        return new AppFunctionRuntimeMetadata(result.getSuccesses().get(documentId));
    L7:
        throw new IllegalArgumentException("Function " + functionId + " does not exist");
    }

    private void bindAppFunctionServiceUnchecked(ExecuteAppFunctionAidlRequest requestInternal, Intent serviceIntent, UserHandle targetUser, ICancellationSignal cancellationSignalTransport, SafeOneTimeExecuteAppFunctionCallback safeExecuteAppFunctionCallback, int bindFlags, IBinder callerBinder, int callingUid) {
        final CancellationSignal cancellationSignal = CancellationSignal.fromTransport(cancellationSignalTransport);
        ICancellationCallback.Stub r1 = new AnonymousClass2(this, cancellationSignal);
        boolean bindServiceResult = this.mRemoteServiceCaller.runServiceCall(serviceIntent, bindFlags, targetUser, this.mServiceConfig.getExecuteAppFunctionCancellationTimeoutMillis(), cancellationSignal, new RunAppFunctionServiceCallback(requestInternal, r1, safeExecuteAppFunctionCallback, getPackageSigningInfo(targetUser, requestInternal.getCallingPackage(), callingUid)), callerBinder);
        if (bindServiceResult == true) goto L6;
        Slog.e(TAG, "Failed to bind to the AppFunctionService");
        safeExecuteAppFunctionCallback.onError(new AppFunctionException(2000, "Failed to bind the AppFunctionService."));
        return;
    }

    private SigningInfo getPackageSigningInfo(UserHandle targetUser, String packageName, int uid) {
        packageName.getClass();
        targetUser.getClass();
        PackageInfo packageInfo = this.mPackageManagerInternal.getPackageInfo(packageName, 134217728, uid, targetUser.getIdentifier());
        packageInfo.getClass();
        SigningInfo r9 = packageInfo.signingInfo;
        r9.getClass();
        return r9;
    }

    private AppSearchManager getAppSearchManagerAsUser(UserHandle userHandle) {
        return (AppSearchManager) this.mContext.createContextAsUser(userHandle, 0).getSystemService(AppSearchManager.class);
    }

    private AppFunctionException mapExceptionToExecuteAppFunctionResponse(Throwable e) {
        if ((e instanceof CompletionException) == false) goto L5;
        e = e.getCause();
    L5:
        int resultCode = 2000;
        if ((e instanceof AppFunctionManagerHelper.AppFunctionNotFoundException) == false) goto L9;
        resultCode = 1003;
    L18:
        return new AppFunctionException(resultCode, e.getMessage());
    L9:
        if ((e instanceof AppSearchException) == false) goto L12;
        AppSearchException appSearchException = (AppSearchException) e;
        resultCode = mapAppSearchResultFailureCodeToExecuteAppFunctionResponse(appSearchException.getResultCode());
        goto L18
    L12:
        if ((e instanceof SecurityException) == false) goto L15;
        resultCode = 1000;
        goto L18
    L15:
        if ((e instanceof DisabledAppFunctionException) == false) goto L18;
        resultCode = 1002;
        goto L18
    }

    private int mapAppSearchResultFailureCodeToExecuteAppFunctionResponse(int resultCode) {
        if (resultCode == 0) goto L9;
        switch(resultCode) {
            case 6: goto L6;
            default: goto L4;
        };
    L4:
        return 2000;
    L6:
        return 1003;
    L9:
        throw new IllegalArgumentException("This method can only be used to convert failure result codes.");
    }

    private void registerAppSearchObserver(SystemService.TargetUser user) {
        AppSearchManager perUserAppSearchManager = (AppSearchManager) this.mContext.createContextAsUser(user.getUserHandle(), 0).getSystemService(AppSearchManager.class);
        if (perUserAppSearchManager != null) goto L6;
        Slog.d(TAG, "AppSearch Manager not found for user: " + user.getUserIdentifier());
        return;
    L6:
        final FutureGlobalSearchSession futureGlobalSearchSession = new FutureGlobalSearchSession(perUserAppSearchManager, AppFunctionExecutors.THREAD_POOL_EXECUTOR);
        AppFunctionMetadataObserver appFunctionMetadataObserver = new AppFunctionMetadataObserver(user.getUserHandle(), this.mContext.createContextAsUser(user.getUserHandle(), 0));
        futureGlobalSearchSession.registerObserverCallbackAsync(PackageManagerService.PLATFORM_PACKAGE_NAME, new ObserverSpec.Builder().build(), AppFunctionExecutors.THREAD_POOL_EXECUTOR, appFunctionMetadataObserver).whenComplete(new AppFunctionManagerServiceImpl$$ExternalSyntheticLambda4(futureGlobalSearchSession));
    }

    private static /* synthetic */ void lambda$registerAppSearchObserver$6(FutureGlobalSearchSession futureGlobalSearchSession, Void voidResult, Throwable ex) {
        if (ex == null) goto L4;
        Slog.e(TAG, "Failed to register observer: ", ex);
    L4:
        futureGlobalSearchSession.close();
    }

    private void trySyncRuntimeMetadata(SystemService.TargetUser user) {
        MetadataSyncAdapter metadataSyncAdapter = MetadataSyncPerUser.getPerUserMetadataSyncAdapter(user.getUserHandle(), this.mContext.createContextAsUser(user.getUserHandle(), 0));
        if (metadataSyncAdapter == null) goto L6;
        metadataSyncAdapter.submitSyncRequest().whenComplete(new AppFunctionManagerServiceImpl$$ExternalSyntheticLambda5());
        return;
    }

    private static /* synthetic */ void lambda$trySyncRuntimeMetadata$7(Boolean isSuccess, Throwable ex) {
        if (ex == null) goto L4;
    L5:
        Slog.e(TAG, "Sync was not successful");
        return;
    L4:
        if (isSuccess.booleanValue() == false) goto L5;
    }

    Object getLockForPackage(String callingPackage) {
        Map<String, Object> r0 = this.mLocks;
        monitor-enter(r0);
        this.mLocks.values().removeAll(Collections.singleton(null));     // Catch: Throwable -> L7
        Object r1 = this.mLocks.computeIfAbsent(callingPackage, new AppFunctionManagerServiceImpl$$ExternalSyntheticLambda3());     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ Object lambda$getLockForPackage$8(String k) {
        return new Object();
    }

    SafeOneTimeExecuteAppFunctionCallback initializeSafeExecuteAppFunctionCallback(final ExecuteAppFunctionAidlRequest requestInternal, IExecuteAppFunctionCallback executeAppFunctionCallback, final int callingUid) {
        return new SafeOneTimeExecuteAppFunctionCallback(executeAppFunctionCallback, new AnonymousClass3(this, requestInternal, callingUid));
    }
}
