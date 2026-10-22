package com.android.server.credentials;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.credentials.CreateCredentialException;
import android.credentials.GetCredentialException;
import android.os.Binder;
import android.os.Handler;
import android.os.ICancellationSignal;
import android.os.RemoteException;
import android.service.credentials.BeginCreateCredentialRequest;
import android.service.credentials.BeginCreateCredentialResponse;
import android.service.credentials.BeginGetCredentialRequest;
import android.service.credentials.BeginGetCredentialResponse;
import android.service.credentials.ClearCredentialStateRequest;
import android.service.credentials.ICredentialProviderService;
import android.util.Slog;
import com.android.internal.infra.AndroidFuture;
import com.android.internal.infra.ServiceConnector;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public class RemoteCredentialService extends ServiceConnector.Impl<ICredentialProviderService> {
    private static final String TAG = "CredentialManager";
    private static final long TIMEOUT_IDLE_SERVICE_CONNECTION_MILLIS = 5000;
    private static final long TIMEOUT_REQUEST_MILLIS = 3000;
    private ProviderCallbacks mCallback;
    private final ComponentName mComponentName;
    private AtomicBoolean mOngoingRequest;

    public interface ProviderCallbacks<T> {
        void onProviderCancellable(ICancellationSignal r1);

        void onProviderResponseFailure(int r1, Exception r2);

        void onProviderResponseSuccess(T r1);

        void onProviderServiceDied(RemoteCredentialService r1);
    }

    public static /* synthetic */ void $r8$lambda$81bMjDd_PzSM1na10Fn9cojluxY(RemoteCredentialService r0, AtomicReference r1, BeginGetCredentialResponse r2, Throwable r3) {
        r0.lambda$onBeginGetCredential$2(r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$D7OQoA3J37uDhI61JYMXPSPaeJk(RemoteCredentialService r0, BeginGetCredentialResponse r1, Throwable r2, AtomicReference r3) {
        r0.lambda$onBeginGetCredential$1(r1, r2, r3);
    }

    public static /* synthetic */ CompletableFuture $r8$lambda$DohCPT_22ZgbBQNbI2H8BbzgUmw(RemoteCredentialService r0, ClearCredentialStateRequest r1, AtomicReference r2, AtomicReference r3, ICredentialProviderService r4) {
        return r0.lambda$onClearCredentialState$6(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: $r8$lambda$JupwSQ-PoB0jrCawITnHi0DdUCE, reason: not valid java name */
    public static /* synthetic */ void m3310$r8$lambda$JupwSQPoB0jrCawITnHi0DdUCE(RemoteCredentialService r0, AtomicReference r1, BeginCreateCredentialResponse r2, Throwable r3) {
        r0.lambda$onBeginCreateCredential$5(r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$QugiT1pJjmY_IUP4-GNowUFRpsM, reason: not valid java name */
    public static /* synthetic */ void m3311$r8$lambda$QugiT1pJjmY_IUP4GNowUFRpsM(RemoteCredentialService r0, BeginCreateCredentialResponse r1, Throwable r2, AtomicReference r3) {
        r0.lambda$onBeginCreateCredential$4(r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$SU8-f4sNmP3sQJ0B0PP006J0Jyk, reason: not valid java name */
    public static /* synthetic */ void m3312$r8$lambda$SU8f4sNmP3sQJ0B0PP006J0Jyk(RemoteCredentialService r0, Void r1, Throwable r2, AtomicReference r3) {
        r0.lambda$onClearCredentialState$7(r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$Ugprs2iUYdNzuHo7H6aRHCwrwxs(RemoteCredentialService r0, AtomicReference r1, Void r2, Throwable r3) {
        r0.lambda$onClearCredentialState$8(r1, r2, r3);
    }

    public static /* synthetic */ CompletableFuture $r8$lambda$_i46SAREyLN0okDAVD3KC7ijs9c(RemoteCredentialService r0, BeginCreateCredentialRequest r1, AtomicReference r2, AtomicReference r3, ICredentialProviderService r4) {
        return r0.lambda$onBeginCreateCredential$3(r1, r2, r3, r4);
    }

    public static /* synthetic */ CompletableFuture $r8$lambda$bRAzATQc8Tz0Jyxag0nERhfRlR8(RemoteCredentialService r0, BeginGetCredentialRequest r1, AtomicReference r2, AtomicReference r3, ICredentialProviderService r4) {
        return r0.lambda$onBeginGetCredential$0(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCallback, reason: not valid java name */
    static /* bridge */ /* synthetic */ ProviderCallbacks m3313$$Nest$fgetmCallback(RemoteCredentialService r0) {
        return r0.mCallback;
    }

    /* JADX INFO: renamed from: -$$Nest$mdispatchCancellationSignal, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3314$$Nest$mdispatchCancellationSignal(RemoteCredentialService r0, ICancellationSignal r1) {
        r0.dispatchCancellationSignal(r1);
    }

    public RemoteCredentialService(Context context, ComponentName componentName, int userId) {
        super(context, new Intent("android.service.credentials.CredentialProviderService").setComponent(componentName), 0, userId, new RemoteCredentialService$$ExternalSyntheticLambda9());
        this.mOngoingRequest = new AtomicBoolean(false);
        this.mComponentName = componentName;
    }

    public void setCallback(ProviderCallbacks callback) {
        this.mCallback = callback;
    }

    protected long getAutoDisconnectTimeoutMs() {
        return TIMEOUT_IDLE_SERVICE_CONNECTION_MILLIS;
    }

    public void onBindingDied(ComponentName name) {
        super.onBindingDied(name);
        Slog.w(TAG, "binding died for: " + name);
    }

    public void binderDied() {
        super.binderDied();
        Slog.w(TAG, "binderDied");
        if (this.mCallback == null) goto L6;
        this.mOngoingRequest.set(false);
        this.mCallback.onProviderServiceDied(this);
        return;
    }

    public ComponentName getComponentName() {
        return this.mComponentName;
    }

    public void destroy() {
        unbind();
    }

    public void onBeginGetCredential(final BeginGetCredentialRequest request) {
        if (this.mCallback != null) goto L6;
        Slog.w(TAG, "Callback is not set");
        return;
    L6:
        this.mOngoingRequest.set(true);
        final AtomicReference<ICancellationSignal> cancellationSink = new AtomicReference();
        final AtomicReference<CompletableFuture<BeginGetCredentialResponse>> futureRef = new AtomicReference();
        AndroidFuture r2 = postAsync(new RemoteCredentialService$$ExternalSyntheticLambda3(this, request, futureRef, cancellationSink)).orTimeout(3000, TimeUnit.MILLISECONDS);
        futureRef.set(r2);
        r2.whenComplete(new RemoteCredentialService$$ExternalSyntheticLambda4(this, cancellationSink));
    }

    private /* synthetic */ CompletableFuture lambda$onBeginGetCredential$0(BeginGetCredentialRequest request, final AtomicReference futureRef, final AtomicReference cancellationSink, ICredentialProviderService service) throws Exception {
        final CompletableFuture<BeginGetCredentialResponse> getCredentials = new CompletableFuture();
        long originalCallingUidToken = Binder.clearCallingIdentity();
        service.onBeginGetCredential(request, new AnonymousClass1(this, getCredentials, futureRef, cancellationSink));     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(originalCallingUidToken);
        return getCredentials;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(originalCallingUidToken);
        throw th;
    }

    private /* synthetic */ void lambda$onBeginGetCredential$2(final AtomicReference cancellationSink, final BeginGetCredentialResponse result, final Throwable error) {
        Handler.getMain().post(new RemoteCredentialService$$ExternalSyntheticLambda2(this, result, error, cancellationSink));
    }

    private /* synthetic */ void lambda$onBeginGetCredential$1(BeginGetCredentialResponse result, Throwable error, AtomicReference cancellationSink) {
        handleExecutionResponse(result, error, cancellationSink);
    }

    public void onBeginCreateCredential(final BeginCreateCredentialRequest request) {
        if (this.mCallback != null) goto L6;
        Slog.w(TAG, "Callback is not set");
        return;
    L6:
        this.mOngoingRequest.set(true);
        final AtomicReference<ICancellationSignal> cancellationSink = new AtomicReference();
        final AtomicReference<CompletableFuture<BeginCreateCredentialResponse>> futureRef = new AtomicReference();
        AndroidFuture r2 = postAsync(new RemoteCredentialService$$ExternalSyntheticLambda0(this, request, futureRef, cancellationSink)).orTimeout(3000, TimeUnit.MILLISECONDS);
        futureRef.set(r2);
        r2.whenComplete(new RemoteCredentialService$$ExternalSyntheticLambda1(this, cancellationSink));
    }

    private /* synthetic */ CompletableFuture lambda$onBeginCreateCredential$3(BeginCreateCredentialRequest request, final AtomicReference futureRef, final AtomicReference cancellationSink, ICredentialProviderService service) throws Exception {
        final CompletableFuture<BeginCreateCredentialResponse> createCredentialFuture = new CompletableFuture();
        long originalCallingUidToken = Binder.clearCallingIdentity();
        service.onBeginCreateCredential(request, new AnonymousClass2(this, createCredentialFuture, futureRef, cancellationSink));     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(originalCallingUidToken);
        return createCredentialFuture;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(originalCallingUidToken);
        throw th;
    }

    private /* synthetic */ void lambda$onBeginCreateCredential$5(final AtomicReference cancellationSink, final BeginCreateCredentialResponse result, final Throwable error) {
        Handler.getMain().post(new RemoteCredentialService$$ExternalSyntheticLambda5(this, result, error, cancellationSink));
    }

    private /* synthetic */ void lambda$onBeginCreateCredential$4(BeginCreateCredentialResponse result, Throwable error, AtomicReference cancellationSink) {
        handleExecutionResponse(result, error, cancellationSink);
    }

    public void onClearCredentialState(final ClearCredentialStateRequest request) {
        if (this.mCallback != null) goto L6;
        Slog.w(TAG, "Callback is not set");
        return;
    L6:
        this.mOngoingRequest.set(true);
        final AtomicReference<ICancellationSignal> cancellationSink = new AtomicReference();
        final AtomicReference<CompletableFuture<Void>> futureRef = new AtomicReference();
        AndroidFuture r2 = postAsync(new RemoteCredentialService$$ExternalSyntheticLambda6(this, request, futureRef, cancellationSink)).orTimeout(3000, TimeUnit.MILLISECONDS);
        futureRef.set(r2);
        r2.whenComplete(new RemoteCredentialService$$ExternalSyntheticLambda7(this, cancellationSink));
    }

    private /* synthetic */ CompletableFuture lambda$onClearCredentialState$6(ClearCredentialStateRequest request, final AtomicReference futureRef, final AtomicReference cancellationSink, ICredentialProviderService service) throws Exception {
        final CompletableFuture<Void> clearCredentialFuture = new CompletableFuture();
        long originalCallingUidToken = Binder.clearCallingIdentity();
        service.onClearCredentialState(request, new AnonymousClass3(this, clearCredentialFuture, futureRef, cancellationSink));     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(originalCallingUidToken);
        return clearCredentialFuture;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(originalCallingUidToken);
        throw th;
    }

    private /* synthetic */ void lambda$onClearCredentialState$8(final AtomicReference cancellationSink, final Void result, final Throwable error) {
        Handler.getMain().post(new RemoteCredentialService$$ExternalSyntheticLambda8(this, result, error, cancellationSink));
    }

    private /* synthetic */ void lambda$onClearCredentialState$7(Void result, Throwable error, AtomicReference cancellationSink) {
        handleExecutionResponse(result, error, cancellationSink);
    }

    private <T> void handleExecutionResponse(T result, Throwable error, AtomicReference<ICancellationSignal> cancellationSink) {
        if (error != null) goto L7;
        if (this.mCallback == null) goto L36;
        this.mCallback.onProviderResponseSuccess(result);
        return;
    L36:
        return;
    L7:
        if ((error instanceof TimeoutException) == false) goto L15;
        Slog.i(TAG, "Remote provider response timed tuo for: " + this.mComponentName);
        if (this.mOngoingRequest.get() == true) goto L11;
        return;
    L11:
        dispatchCancellationSignal(cancellationSink.get());
        if (this.mCallback == null) goto L38;
        this.mOngoingRequest.set(false);
        this.mCallback.onProviderResponseFailure(1, null);
        return;
    L38:
        return;
    L15:
        if ((error instanceof CancellationException) == false) goto L23;
        Slog.i(TAG, "Cancellation exception for remote provider: " + this.mComponentName);
        if (this.mOngoingRequest.get() == true) goto L19;
        return;
    L19:
        dispatchCancellationSignal(cancellationSink.get());
        if (this.mCallback == null) goto L40;
        this.mOngoingRequest.set(false);
        this.mCallback.onProviderResponseFailure(2, null);
        return;
    L40:
        return;
    L23:
        if ((error instanceof GetCredentialException) == false) goto L28;
        if (this.mCallback == null) goto L42;
        this.mCallback.onProviderResponseFailure(3, (GetCredentialException) error);
        return;
    L42:
        return;
    L28:
        if ((error instanceof CreateCredentialException) == false) goto L33;
        if (this.mCallback == null) goto L44;
        this.mCallback.onProviderResponseFailure(3, (CreateCredentialException) error);
        return;
    L44:
        return;
    L33:
        if (this.mCallback == null) goto L46;
        this.mCallback.onProviderResponseFailure(0, (Exception) error);
        return;
    }

    private void dispatchCancellationSignal(ICancellationSignal signal) {
        if (signal != null) goto L11;
        Slog.e(TAG, "Error dispatching a cancellation - Signal is null");
        return;
    L11:
        signal.cancel();     // Catch: RemoteException -> L8
        return;
    L8:
        e = move-exception;
        Slog.e(TAG, "Error dispatching a cancellation", e);
    }
}
