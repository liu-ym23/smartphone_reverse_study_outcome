package com.android.server.autofill;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Handler;
import android.os.IBinder;
import android.os.ICancellationSignal;
import android.os.IInterface;
import android.os.RemoteException;
import android.service.autofill.ConvertCredentialRequest;
import android.service.autofill.ConvertCredentialResponse;
import android.service.autofill.FillEventHistory;
import android.service.autofill.FillRequest;
import android.service.autofill.FillResponse;
import android.service.autofill.IAutoFillService;
import android.service.autofill.IConvertCredentialCallback;
import android.service.autofill.IFillCallback;
import android.service.autofill.ISaveCallback;
import android.service.autofill.SaveRequest;
import android.util.Slog;
import com.android.internal.infra.AbstractRemoteService;
import com.android.internal.infra.AndroidFuture;
import com.android.internal.infra.ServiceConnector;
import com.android.internal.os.IResultReceiver;
import java.lang.ref.WeakReference;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
final class RemoteFillService extends ServiceConnector.Impl<IAutoFillService> {
    private static final String TAG = "RemoteFillService";
    private static final long TIMEOUT_IDLE_BIND_MILLIS = 5000;
    private static final long TIMEOUT_REMOTE_REQUEST_MILLIS = 5000;
    private volatile FillServiceCallbacks mCallbacks;
    private final ComponentName mComponentName;
    private AtomicReference<IConvertCredentialCallback> mConvertCredentialCallback;
    private AtomicReference<IFillCallback> mFillCallback;
    private final boolean mIsCredentialAutofillService;
    private final Object mLock;
    private CompletableFuture<FillResponse> mPendingFillRequest;
    private int mPendingFillRequestId;
    private AtomicReference<ISaveCallback> mSaveCallback;

    public interface FillServiceCallbacks extends AbstractRemoteService.VultureCallback<RemoteFillService> {
        void onConvertCredentialRequestSuccess(ConvertCredentialResponse r1);

        void onFillRequestFailure(int r1, Throwable r2);

        void onFillRequestSuccess(int r1, FillResponse r2, String r3, int r4);

        void onSaveRequestFailure(CharSequence r1, String r2);

        void onSaveRequestSuccess(String r1, IntentSender r2);
    }

    static class IConvertCredentialCallbackDelegate extends IConvertCredentialCallback.Stub {
        private WeakReference<IConvertCredentialCallback> mCallbackWeakRef;

        IConvertCredentialCallbackDelegate(IConvertCredentialCallback callback) {
            this.mCallbackWeakRef = new WeakReference(callback);
        }

        public void onSuccess(ConvertCredentialResponse convertCredentialResponse) throws RemoteException {
            IConvertCredentialCallback callback = this.mCallbackWeakRef.get();
            if (callback == null) goto L6;
            callback.onSuccess(convertCredentialResponse);
            return;
        }

        public void onFailure(CharSequence message) throws RemoteException {
            IConvertCredentialCallback callback = this.mCallbackWeakRef.get();
            if (callback == null) goto L6;
            callback.onFailure(message);
            return;
        }
    }

    static class IFillCallbackDelegate extends IFillCallback.Stub {
        private WeakReference<IFillCallback> mCallbackWeakRef;

        IFillCallbackDelegate(IFillCallback callback) {
            this.mCallbackWeakRef = new WeakReference(callback);
        }

        public void onCancellable(ICancellationSignal cancellation) throws RemoteException {
            IFillCallback callback = this.mCallbackWeakRef.get();
            if (callback == null) goto L6;
            callback.onCancellable(cancellation);
            return;
        }

        public void onSuccess(FillResponse response) throws RemoteException {
            IFillCallback callback = this.mCallbackWeakRef.get();
            if (callback == null) goto L6;
            callback.onSuccess(response);
            return;
        }

        public void onFailure(int requestId, CharSequence message) throws RemoteException {
            IFillCallback callback = this.mCallbackWeakRef.get();
            if (callback == null) goto L6;
            callback.onFailure(requestId, message);
            return;
        }
    }

    static class ISaveCallbackDelegate extends ISaveCallback.Stub {
        private WeakReference<ISaveCallback> mCallbackWeakRef;

        ISaveCallbackDelegate(ISaveCallback callback) {
            this.mCallbackWeakRef = new WeakReference(callback);
        }

        public void onSuccess(IntentSender intentSender) throws RemoteException {
            ISaveCallback callback = this.mCallbackWeakRef.get();
            if (callback == null) goto L6;
            callback.onSuccess(intentSender);
            return;
        }

        public void onFailure(CharSequence message) throws RemoteException {
            ISaveCallback callback = this.mCallbackWeakRef.get();
            if (callback == null) goto L6;
            callback.onFailure(message);
            return;
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$--183EjANpw91HKo2va0GC5un2w, reason: not valid java name */
    public static /* synthetic */ void m2325$r8$lambda$183EjANpw91HKo2va0GC5un2w(RemoteFillService r0, FillRequest r1, AtomicReference r2, FillResponse r3, Throwable r4) {
        r0.lambda$onFillCredentialRequest$2(r1, r2, r3, r4);
    }

    public static /* synthetic */ void $r8$lambda$0XlyAiQT5OzqKESto0rFkNEAk2U(FillEventHistory r0, IAutoFillService r1) {
        lambda$onSessionDestroyed$12(r0, r1);
    }

    public static /* synthetic */ CompletableFuture $r8$lambda$0drfjd02UtjtR1pzZwZfvLOqncQ(RemoteFillService r0, SaveRequest r1, IAutoFillService r2) {
        return r0.lambda$onSaveRequest$9(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$1hw0FNOarmG_sgD3O92JoX9WtBE(RemoteFillService r0, Throwable r1, IntentSender r2) {
        r0.lambda$onSaveRequest$10(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$67DihH340agaYreQTyoHaFRUIso(RemoteFillService r0, Throwable r1, ConvertCredentialResponse r2) {
        r0.lambda$onConvertCredentialRequest$7(r1, r2);
    }

    public static /* synthetic */ CompletableFuture $r8$lambda$8OOHlUBvdqS1fg3RbRizHkpGBn8(RemoteFillService r0, ConvertCredentialRequest r1, IAutoFillService r2) {
        return r0.lambda$onConvertCredentialRequest$6(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$Kj5auWD1cOcSHM_ESYtjvwk7vTI(IResultReceiver r0, IAutoFillService r1) {
        lambda$onSavedPasswordCountRequest$13(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$MLHzbWmDSF_Y3aMTat2OGRlZT3w(RemoteFillService r0, ConvertCredentialResponse r1, Throwable r2) {
        r0.lambda$onConvertCredentialRequest$8(r1, r2);
    }

    public static /* synthetic */ CompletableFuture $r8$lambda$SuRrSdn3wN_ru1_Fcwna6IC87ME(RemoteFillService r0, FillRequest r1, AtomicReference r2, AtomicReference r3, IBinder r4, IAutoFillService r5) {
        return r0.lambda$onFillCredentialRequest$0(r1, r2, r3, r4, r5);
    }

    /* JADX INFO: renamed from: $r8$lambda$XW5uEEOSVnKg9BSOPrNI6rc-r-0, reason: not valid java name */
    public static /* synthetic */ void m2326$r8$lambda$XW5uEEOSVnKg9BSOPrNI6rcr0(RemoteFillService r0, FillRequest r1, Throwable r2, FillResponse r3, AtomicReference r4) {
        r0.lambda$onFillRequest$4(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: $r8$lambda$la-uaiQBhj70AfnUay3paV6FJv0, reason: not valid java name */
    public static /* synthetic */ void m2327$r8$lambda$lauaiQBhj70AfnUay3paV6FJv0(RemoteFillService r0, FillRequest r1, AtomicReference r2, FillResponse r3, Throwable r4) {
        r0.lambda$onFillRequest$5(r1, r2, r3, r4);
    }

    public static /* synthetic */ CompletableFuture $r8$lambda$tcRwao6_rV9k5G25qQkEhJDmAOM(RemoteFillService r0, FillRequest r1, AtomicReference r2, AtomicReference r3, IAutoFillService r4) {
        return r0.lambda$onFillRequest$3(r1, r2, r3, r4);
    }

    public static /* synthetic */ void $r8$lambda$wSzwamvgNotE12sdMim5JjyvLFY(RemoteFillService r0, IntentSender r1, Throwable r2) {
        r0.lambda$onSaveRequest$11(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$zdjf0K0hKmIRA24ezzowdxS69F4(RemoteFillService r0, FillRequest r1, Throwable r2, FillResponse r3, AtomicReference r4) {
        r0.lambda$onFillCredentialRequest$1(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$mdispatchCancellationSignal, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2328$$Nest$mdispatchCancellationSignal(RemoteFillService r0, ICancellationSignal r1) {
        r0.dispatchCancellationSignal(r1);
    }

    public /* bridge */ /* synthetic */ void addLast(Object r1) {
        addLast((ServiceConnector.Job) r1);
    }

    protected /* bridge */ /* synthetic */ void onServiceConnectionStatusChanged(IInterface r1, boolean r2) {
        onServiceConnectionStatusChanged((IAutoFillService) r1, r2);
    }

    public boolean isCredentialAutofillService() {
        return this.mIsCredentialAutofillService;
    }

    RemoteFillService(Context context, ComponentName componentName, int userId, FillServiceCallbacks callbacks, boolean bindInstantServiceAllowed, ComponentName credentialAutofillService) {
        Intent r4 = new Intent("android.service.autofill.AutofillService").setComponent(componentName);
        if (bindInstantServiceAllowed == false) goto L5;
        int r0 = 4194304;
    L6:
        super(context, r4, r0 | 1048576, userId, new RemoteFillService$$ExternalSyntheticLambda7());
        this.mLock = new Object();
        this.mPendingFillRequestId = Integer.MIN_VALUE;
        this.mCallbacks = callbacks;
        this.mComponentName = componentName;
        this.mIsCredentialAutofillService = this.mComponentName.equals(credentialAutofillService);
        return;
    L5:
        r0 = 0;
        goto L6
    }

    protected void onServiceConnectionStatusChanged(IAutoFillService service, boolean connected) {
        if (connected == true) goto L10;
        Slog.i(TAG, "service disconnected: component=" + this.mComponentName + ", pendingRequestId=" + getPendingFillRequestIdLocked());
    L10:
        service.onConnectedStateChanged(connected);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        Slog.w(TAG, "Exception calling onConnectedStateChanged(" + connected + "): " + e);
    }

    public void onNullBinding(ComponentName name) {
        dispatchPendingFillRequestFailure("null binding", name);
    }

    public void onBindingDied(ComponentName name) {
        super.onBindingDied(name);
        dispatchPendingFillRequestFailure("binding died", name);
    }

    private void dispatchCancellationSignal(ICancellationSignal signal) {
        if (signal != null) goto L9;
        return;
    L9:
        signal.cancel();     // Catch: RemoteException -> L6
        return;
    L6:
        e = move-exception;
        Slog.e(TAG, "Error requesting a cancellation", e);
    }

    protected long getAutoDisconnectTimeoutMs() {
        return 5000;
    }

    public void addLast(ServiceConnector.Job<IAutoFillService, ?> iAutoFillServiceJob) {
        cancelPendingJobs();
        super.addLast(iAutoFillServiceJob);
    }

    public ComponentName getComponentName() {
        return this.mComponentName;
    }

    private int getPendingFillRequestIdLocked() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int r1 = this.mPendingFillRequestId;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private void unbindWithLog(String reason) {
        Slog.i(TAG, "unbind(): reason=" + reason + ", component=" + this.mComponentName + ", pendingRequestId=" + getPendingFillRequestIdLocked());
        unbind();
    }

    private void dispatchPendingFillRequestFailure(String reason, ComponentName name) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        CompletableFuture<FillResponse> pendingFillRequest = this.mPendingFillRequest;     // Catch: Throwable -> L15
        int pendingRequestId = this.mPendingFillRequestId;     // Catch: Throwable -> L15
        monitor-exit(r0);     // Catch: Throwable -> L15
        Slog.w(TAG, reason + ": component=" + name + ", pendingRequestId=" + pendingRequestId);
        if (pendingFillRequest != null) goto L9;
    L13:
        unbindWithLog(reason);
        return;
    L9:
        if (pendingRequestId == Integer.MIN_VALUE) goto L13;
        if (pendingFillRequest.completeExceptionally(new IllegalStateException(reason + " for " + name)) == true) goto L13;
        Slog.w(TAG, "pending fill request already finished while handling " + reason + ", requestId=" + pendingRequestId);
    L15:
        th = move-exception;
        throw th;
    }

    private void logFillRequestTerminalState(int requestId, Throwable err) {
        if (err != null) goto L9;
        if (Helper.sVerbose == false) goto L16;
        Slog.v(TAG, "fill request finished, requestId=" + requestId);
        return;
    L16:
        return;
    L9:
        if ((err instanceof CancellationException) == true) goto L11;
        Slog.w(TAG, "fill request finished with error, requestId=" + requestId + "; Session cleanup callback should follow", err);
        return;
    L11:
        if (Helper.sVerbose == false) goto L17;
        Slog.v(TAG, "fill request cancelled, requestId=" + requestId);
        return;
    }

    private FillServiceCallbacks getCallbacksOrLog(String operation) {
        FillServiceCallbacks callbacks = this.mCallbacks;
        if (callbacks != null) goto L5;
        Slog.w(TAG, "Ignore " + operation + " callback after service destroyed");
    L5:
        return callbacks;
    }

    public int cancelCurrentRequest() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mPendingFillRequest != null) goto L7;
    L11:
        int r1 = Integer.MIN_VALUE;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    L7:
        if (this.mPendingFillRequest.cancel(false) == false) goto L11;
        r1 = this.mPendingFillRequestId;     // Catch: Throwable -> L9
        goto L12
    }

    private IFillCallback maybeWrapWithWeakReference(IFillCallback callback) {
        this.mFillCallback = new AtomicReference(callback);
        return new IFillCallbackDelegate(callback);
    }

    private ISaveCallback maybeWrapWithWeakReference(ISaveCallback callback) {
        this.mSaveCallback = new AtomicReference(callback);
        return new ISaveCallbackDelegate(callback);
    }

    private IConvertCredentialCallback maybeWrapWithWeakReference(IConvertCredentialCallback callback) {
        this.mConvertCredentialCallback = new AtomicReference(callback);
        return new IConvertCredentialCallbackDelegate(callback);
    }

    public void onFillCredentialRequest(final FillRequest request, final IBinder autofillCallback) {
        if (Helper.sVerbose == false) goto L5;
        Slog.v(TAG, "onFillRequest:" + request);
    L5:
        final AtomicReference<ICancellationSignal> cancellationSink = new AtomicReference();
        final AtomicReference<CompletableFuture<FillResponse>> futureRef = new AtomicReference();
        AndroidFuture r8 = postAsync(new RemoteFillService$$ExternalSyntheticLambda10(this, request, futureRef, cancellationSink, autofillCallback)).orTimeout(5000, TimeUnit.MILLISECONDS);
        futureRef.set(r8);
        Object r9 = this.mLock;
        monitor-enter(r9);
        this.mPendingFillRequest = r8;     // Catch: Throwable -> L11
        this.mPendingFillRequestId = request.getId();     // Catch: Throwable -> L11
        monitor-exit(r9);     // Catch: Throwable -> L11
        r8.whenComplete(new RemoteFillService$$ExternalSyntheticLambda11(this, request, cancellationSink));
        return;
    L11:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ CompletableFuture lambda$onFillCredentialRequest$0(FillRequest request, final AtomicReference futureRef, final AtomicReference cancellationSink, IBinder autofillCallback, IAutoFillService remoteService) throws Exception {
        if (Helper.sVerbose == false) goto L5;
        Slog.v(TAG, "calling onFillRequest() for id=" + request.getId());
    L5:
        final CompletableFuture<FillResponse> fillRequest = new CompletableFuture();
        remoteService.onFillCredentialRequest(request, maybeWrapWithWeakReference(new AnonymousClass1(this, futureRef, cancellationSink, fillRequest)), autofillCallback);
        return fillRequest;
    }

    private /* synthetic */ void lambda$onFillCredentialRequest$2(final FillRequest request, final AtomicReference cancellationSink, final FillResponse res, final Throwable err) {
        Handler.getMain().post(new RemoteFillService$$ExternalSyntheticLambda2(this, request, err, res, cancellationSink));
    }

    private /* synthetic */ void lambda$onFillCredentialRequest$1(FillRequest request, Throwable err, FillResponse res, AtomicReference cancellationSink) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mPendingFillRequest = null;     // Catch: Throwable -> L20
        this.mPendingFillRequestId = Integer.MIN_VALUE;     // Catch: Throwable -> L20
        monitor-exit(r0);     // Catch: Throwable -> L20
        logFillRequestTerminalState(request.getId(), err);
        FillServiceCallbacks callbacks = getCallbacksOrLog("fill credential request");
        if (callbacks != null) goto L10;
        return;
    L10:
        if (err != null) goto L12;
        callbacks.onFillRequestSuccess(request.getId(), res, this.mComponentName.getPackageName(), request.getFlags());
        return;
    L12:
        Slog.e(TAG, "Error calling on fill request", err);
        if ((err instanceof TimeoutException) == false) goto L16;
        dispatchCancellationSignal((ICancellationSignal) cancellationSink.get());
        callbacks.onFillRequestFailure(request.getId(), err);
        return;
    L16:
        if ((err instanceof CancellationException) == false) goto L18;
        dispatchCancellationSignal((ICancellationSignal) cancellationSink.get());
        return;
    L18:
        callbacks.onFillRequestFailure(request.getId(), err);
        return;
    L20:
        th = move-exception;
        throw th;
    }

    public void onFillRequest(final FillRequest request) {
        if (Helper.sVerbose == false) goto L5;
        Slog.v(TAG, "onFillRequest:" + request);
    L5:
        final AtomicReference<ICancellationSignal> cancellationSink = new AtomicReference();
        final AtomicReference<CompletableFuture<FillResponse>> futureRef = new AtomicReference();
        AndroidFuture r2 = postAsync(new RemoteFillService$$ExternalSyntheticLambda0(this, request, futureRef, cancellationSink)).orTimeout(5000, TimeUnit.MILLISECONDS);
        futureRef.set(r2);
        Object r3 = this.mLock;
        monitor-enter(r3);
        this.mPendingFillRequest = r2;     // Catch: Throwable -> L11
        this.mPendingFillRequestId = request.getId();     // Catch: Throwable -> L11
        monitor-exit(r3);     // Catch: Throwable -> L11
        r2.whenComplete(new RemoteFillService$$ExternalSyntheticLambda1(this, request, cancellationSink));
        return;
    L11:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ CompletableFuture lambda$onFillRequest$3(FillRequest request, final AtomicReference futureRef, final AtomicReference cancellationSink, IAutoFillService remoteService) throws Exception {
        if (Helper.sVerbose == false) goto L5;
        Slog.v(TAG, "calling onFillRequest() for id=" + request.getId());
    L5:
        final CompletableFuture<FillResponse> fillRequest = new CompletableFuture();
        remoteService.onFillRequest(request, maybeWrapWithWeakReference(new AnonymousClass2(this, futureRef, cancellationSink, fillRequest)));
        return fillRequest;
    }

    private /* synthetic */ void lambda$onFillRequest$5(final FillRequest request, final AtomicReference cancellationSink, final FillResponse res, final Throwable err) {
        Handler.getMain().post(new RemoteFillService$$ExternalSyntheticLambda9(this, request, err, res, cancellationSink));
    }

    private /* synthetic */ void lambda$onFillRequest$4(FillRequest request, Throwable err, FillResponse res, AtomicReference cancellationSink) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mPendingFillRequest = null;     // Catch: Throwable -> L20
        this.mPendingFillRequestId = Integer.MIN_VALUE;     // Catch: Throwable -> L20
        monitor-exit(r0);     // Catch: Throwable -> L20
        logFillRequestTerminalState(request.getId(), err);
        FillServiceCallbacks callbacks = getCallbacksOrLog("fill request");
        if (callbacks != null) goto L10;
        return;
    L10:
        if (err != null) goto L12;
        callbacks.onFillRequestSuccess(request.getId(), res, this.mComponentName.getPackageName(), request.getFlags());
        return;
    L12:
        Slog.e(TAG, "Error calling on fill request", err);
        if ((err instanceof TimeoutException) == false) goto L16;
        dispatchCancellationSignal((ICancellationSignal) cancellationSink.get());
        callbacks.onFillRequestFailure(request.getId(), err);
        return;
    L16:
        if ((err instanceof CancellationException) == false) goto L18;
        dispatchCancellationSignal((ICancellationSignal) cancellationSink.get());
        return;
    L18:
        callbacks.onFillRequestFailure(request.getId(), err);
        return;
    L20:
        th = move-exception;
        throw th;
    }

    public void onConvertCredentialRequest(final ConvertCredentialRequest convertCredentialRequest) {
        if (Helper.sVerbose == false) goto L5;
        Slog.v(TAG, "calling onConvertCredentialRequest()");
    L5:
        postAsync(new RemoteFillService$$ExternalSyntheticLambda12(this, convertCredentialRequest)).orTimeout(5000, TimeUnit.MILLISECONDS).whenComplete(new RemoteFillService$$ExternalSyntheticLambda13(this));
    }

    private /* synthetic */ CompletableFuture lambda$onConvertCredentialRequest$6(ConvertCredentialRequest convertCredentialRequest, IAutoFillService remoteService) throws Exception {
        if (Helper.sVerbose == false) goto L5;
        Slog.v(TAG, "calling onConvertCredentialRequest()");
    L5:
        final CompletableFuture<ConvertCredentialResponse> convertCredentialCompletableFuture = new CompletableFuture();
        remoteService.onConvertCredentialRequest(convertCredentialRequest, maybeWrapWithWeakReference(new AnonymousClass3(this, convertCredentialCompletableFuture)));
        return convertCredentialCompletableFuture;
    }

    private /* synthetic */ void lambda$onConvertCredentialRequest$8(final ConvertCredentialResponse res, final Throwable err) {
        Handler.getMain().post(new RemoteFillService$$ExternalSyntheticLambda5(this, err, res));
    }

    private /* synthetic */ void lambda$onConvertCredentialRequest$7(Throwable err, ConvertCredentialResponse res) {
        FillServiceCallbacks callbacks = getCallbacksOrLog("convert credential request");
        if (callbacks != null) goto L5;
        return;
    L5:
        if (err != null) goto L7;
        callbacks.onConvertCredentialRequestSuccess(res);
        return;
    L7:
        Slog.e(TAG, "Error calling on convert credential request", err);
    }

    public void onSaveRequest(final SaveRequest request) {
        postAsync(new RemoteFillService$$ExternalSyntheticLambda3(this, request)).orTimeout(5000, TimeUnit.MILLISECONDS).whenComplete(new RemoteFillService$$ExternalSyntheticLambda4(this));
    }

    private /* synthetic */ CompletableFuture lambda$onSaveRequest$9(SaveRequest request, IAutoFillService service) throws Exception {
        if (Helper.sVerbose == false) goto L5;
        Slog.v(TAG, "calling onSaveRequest()");
    L5:
        final CompletableFuture<IntentSender> save = new CompletableFuture();
        service.onSaveRequest(request, maybeWrapWithWeakReference(new AnonymousClass4(this, save)));
        return save;
    }

    private /* synthetic */ void lambda$onSaveRequest$11(final IntentSender res, final Throwable err) {
        Handler.getMain().post(new RemoteFillService$$ExternalSyntheticLambda8(this, err, res));
    }

    private /* synthetic */ void lambda$onSaveRequest$10(Throwable err, IntentSender res) {
        FillServiceCallbacks callbacks = getCallbacksOrLog("save request");
        if (callbacks != null) goto L5;
        return;
    L5:
        if (err != null) goto L7;
        callbacks.onSaveRequestSuccess(this.mComponentName.getPackageName(), res);
        return;
    L7:
        callbacks.onSaveRequestFailure(this.mComponentName.getPackageName(), err.getMessage());
    }

    public void onSessionDestroyed(final FillEventHistory history) {
        boolean success = run(new RemoteFillService$$ExternalSyntheticLambda14(history));
        if (Helper.sVerbose == false) goto L6;
        Slog.v(TAG, "called onSessionDestroyed(): " + success);
        return;
    }

    private static /* synthetic */ void lambda$onSessionDestroyed$12(FillEventHistory history, IAutoFillService service) throws Exception {
        service.onSessionDestroyed(history);
    }

    private static /* synthetic */ void lambda$onSavedPasswordCountRequest$13(IResultReceiver receiver, IAutoFillService service) throws Exception {
        service.onSavedPasswordCountRequest(receiver);
    }

    void onSavedPasswordCountRequest(final IResultReceiver receiver) {
        run(new RemoteFillService$$ExternalSyntheticLambda6(receiver));
    }

    public void destroy() {
        int canceledRequest = cancelCurrentRequest();
        if (canceledRequest == Integer.MIN_VALUE) goto L5;
        Slog.i(TAG, "destroy(): canceled pending fill requestId=" + canceledRequest);
    L5:
        this.mCallbacks = null;
        unbindWithLog("destroy");
    }
}
