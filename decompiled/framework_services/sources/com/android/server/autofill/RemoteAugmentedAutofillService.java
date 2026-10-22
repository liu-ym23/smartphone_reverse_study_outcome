package com.android.server.autofill;

import android.app.AppGlobals;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.ICancellationSignal;
import android.os.IInterface;
import android.os.RemoteException;
import android.os.SystemClock;
import android.service.autofill.Dataset;
import android.service.autofill.augmented.IAugmentedAutofillService;
import android.util.Pair;
import android.util.Slog;
import android.view.autofill.AutofillId;
import android.view.autofill.AutofillValue;
import android.view.autofill.IAutoFillManagerClient;
import android.view.inputmethod.InlineSuggestionsRequest;
import com.android.internal.infra.AbstractRemoteService;
import com.android.internal.infra.AndroidFuture;
import com.android.internal.infra.ServiceConnector;
import com.android.server.autofill.ui.InlineFillUi;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
final class RemoteAugmentedAutofillService extends ServiceConnector.Impl<IAugmentedAutofillService> {
    private static final String TAG = null;
    private final RemoteAugmentedAutofillServiceCallbacks mCallbacks;
    private final ComponentName mComponentName;
    private final int mIdleUnbindTimeoutMs;
    private final int mRequestTimeoutMs;
    private final AutofillUriGrantsManager mUriGrantsManager;

    public interface RemoteAugmentedAutofillServiceCallbacks extends AbstractRemoteService.VultureCallback<RemoteAugmentedAutofillService> {
        void logAugmentedAutofillAuthenticationSelected(int r1, String r2, Bundle r3);

        void logAugmentedAutofillSelected(int r1, String r2, Bundle r3);

        void logAugmentedAutofillShown(int r1, Bundle r2);

        void resetLastResponse();

        void setLastResponse(int r1);
    }

    public static /* synthetic */ void $r8$lambda$IXYPMbjPeMt7KfClcttRpU_yFvU(RemoteAugmentedAutofillService r0, AtomicReference r1, ComponentName r2, int r3, Void r4, Throwable r5) {
        r0.lambda$onRequestAutofillLocked$1(r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ void $r8$lambda$Oi_ZVEWM5rDlcUG4LKATvAkw2Sk(IAugmentedAutofillService r0) {
        lambda$onDestroyAutofillWindowsRequest$3(r0);
    }

    public static /* synthetic */ CompletableFuture $r8$lambda$VqhKdxMMAcUlTejDcRQC9U9LBYg(RemoteAugmentedAutofillService r0, IAutoFillManagerClient r1, int r2, int r3, ComponentName r4, AutofillId r5, AutofillValue r6, long r7, InlineSuggestionsRequest r9, Function r10, Runnable r11, RemoteInlineSuggestionRenderService r12, int r13, IBinder r14, AtomicReference r15, IAugmentedAutofillService r16) {
        return r0.lambda$onRequestAutofillLocked$0(r1, r2, r3, r4, r5, r6, r7, r9, r10, r11, r12, r13, r14, r15, r16);
    }

    public static /* synthetic */ void $r8$lambda$WqtKfl_vHhcuvSCPBSMUqrYUIuY(ICancellationSignal r0) {
        lambda$dispatchCancellation$2(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCallbacks, reason: not valid java name */
    static /* bridge */ /* synthetic */ RemoteAugmentedAutofillServiceCallbacks m2319$$Nest$fgetmCallbacks(RemoteAugmentedAutofillService r0) {
        return r0.mCallbacks;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmUriGrantsManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ AutofillUriGrantsManager m2320$$Nest$fgetmUriGrantsManager(RemoteAugmentedAutofillService r0) {
        return r0.mUriGrantsManager;
    }

    /* JADX INFO: renamed from: -$$Nest$mmaybeRequestShowInlineSuggestions, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2321$$Nest$mmaybeRequestShowInlineSuggestions(RemoteAugmentedAutofillService r0, int r1, InlineSuggestionsRequest r2, List r3, Bundle r4, AutofillId r5, AutofillValue r6, Function r7, IAutoFillManagerClient r8, Runnable r9, RemoteInlineSuggestionRenderService r10, int r11, ComponentName r12, IBinder r13) {
        r0.maybeRequestShowInlineSuggestions(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13);
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetTAG, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m2322$$Nest$sfgetTAG() {
        return TAG;
    }

    protected /* bridge */ /* synthetic */ void onServiceConnectionStatusChanged(IInterface r1, boolean r2) {
        onServiceConnectionStatusChanged((IAugmentedAutofillService) r1, r2);
    }

    static {
        TAG = RemoteAugmentedAutofillService.class.getSimpleName();
    }

    RemoteAugmentedAutofillService(Context context, int serviceUid, ComponentName serviceName, int userId, RemoteAugmentedAutofillServiceCallbacks callbacks, boolean bindInstantServiceAllowed, boolean verbose, int idleUnbindTimeoutMs, int requestTimeoutMs) {
        Intent r2 = new Intent("android.service.autofill.augmented.AugmentedAutofillService").setComponent(serviceName);
        if (bindInstantServiceAllowed == false) goto L6;
        int r0 = 4194304;
    L5:
        int r3 = r0;
        super(context, r2, r3, userId, new RemoteAugmentedAutofillService$$ExternalSyntheticLambda1());
        this.mIdleUnbindTimeoutMs = idleUnbindTimeoutMs;
        this.mRequestTimeoutMs = requestTimeoutMs;
        this.mComponentName = serviceName;
        this.mCallbacks = callbacks;
        this.mUriGrantsManager = new AutofillUriGrantsManager(serviceUid);
        connect();
        return;
    L6:
        r0 = 0;
        goto L5
    }

    static Pair<ServiceInfo, ComponentName> getComponentName(String componentName, int userId, boolean isTemporary) {
        int flags = 128;
        if (isTemporary == true) goto L16;
        flags = 128 | 1048576;
    L16:
        ComponentName serviceComponent = ComponentName.unflattenFromString(componentName);     // Catch: Exception -> L10
        ServiceInfo serviceInfo = AppGlobals.getPackageManager().getServiceInfo(serviceComponent, flags, userId);     // Catch: Exception -> L10
        if (serviceInfo != null) goto L13;
        Slog.e(TAG, "Bad service name for flags " + flags + ": " + componentName);     // Catch: Exception -> L10
        return null;
    L13:
        return new Pair(serviceInfo, serviceComponent);
    L10:
        e = move-exception;
        Slog.e(TAG, "Error getting service info for '" + componentName + "': " + e);
        return null;
    }

    public ComponentName getComponentName() {
        return this.mComponentName;
    }

    public AutofillUriGrantsManager getAutofillUriGrantsManager() {
        return this.mUriGrantsManager;
    }

    protected void onServiceConnectionStatusChanged(IAugmentedAutofillService service, boolean connected) {
        if (connected == false) goto L6;
        service.onConnected(Helper.sDebug, Helper.sVerbose);     // Catch: Exception -> L4
    L10:
        return;
    L6:
        service.onDisconnected();     // Catch: Exception -> L4
    L4:
        e = move-exception;
        Slog.w(TAG, "Exception calling onServiceConnectionStatusChanged(" + connected + "): ", e);
    }

    protected long getAutoDisconnectTimeoutMs() {
        return this.mIdleUnbindTimeoutMs;
    }

    public void onRequestAutofillLocked(final int sessionId, final IAutoFillManagerClient client, final int taskId, final ComponentName activityComponent, final IBinder activityToken, final AutofillId focusedId, final AutofillValue focusedValue, final InlineSuggestionsRequest inlineSuggestionsRequest, final Function<InlineFillUi, Boolean> inlineSuggestionsCallback, final Runnable onErrorCallback, final RemoteInlineSuggestionRenderService remoteRenderService, final int userId) {
        final long requestTime = SystemClock.elapsedRealtime();
        final AtomicReference<ICancellationSignal> cancellationRef = new AtomicReference();
        postAsync(new RemoteAugmentedAutofillService$$ExternalSyntheticLambda3(this, client, sessionId, taskId, activityComponent, focusedId, focusedValue, requestTime, inlineSuggestionsRequest, inlineSuggestionsCallback, onErrorCallback, remoteRenderService, userId, activityToken, cancellationRef)).orTimeout(this.mRequestTimeoutMs, TimeUnit.MILLISECONDS).whenComplete(new RemoteAugmentedAutofillService$$ExternalSyntheticLambda4(this, cancellationRef, activityComponent, sessionId));
    }

    private /* synthetic */ CompletableFuture lambda$onRequestAutofillLocked$0(final IAutoFillManagerClient client, final int sessionId, final int taskId, final ComponentName activityComponent, final AutofillId focusedId, final AutofillValue focusedValue, final long requestTime, final InlineSuggestionsRequest inlineSuggestionsRequest, final Function inlineSuggestionsCallback, final Runnable onErrorCallback, final RemoteInlineSuggestionRenderService remoteRenderService, final int userId, final IBinder activityToken, final AtomicReference cancellationRef, final IAugmentedAutofillService service) throws Exception {
        final AndroidFuture<Void> requestAutofill = new AndroidFuture();
        client.getAugmentedAutofillClient(new AnonymousClass1(this, service, sessionId, taskId, activityComponent, focusedId, focusedValue, requestTime, inlineSuggestionsRequest, inlineSuggestionsCallback, client, onErrorCallback, remoteRenderService, userId, activityToken, requestAutofill, cancellationRef));
        return requestAutofill;
    }

    private /* synthetic */ void lambda$onRequestAutofillLocked$1(AtomicReference cancellationRef, ComponentName activityComponent, int sessionId, Void res, Throwable err) {
        if ((err instanceof CancellationException) == false) goto L6;
        dispatchCancellation((ICancellationSignal) cancellationRef.get());
        return;
    L6:
        if ((err instanceof TimeoutException) == false) goto L12;
        Slog.w(TAG, "PendingAutofillRequest timed out (" + this.mRequestTimeoutMs + "ms) for " + this);
        dispatchCancellation((ICancellationSignal) cancellationRef.get());
        if (this.mComponentName == null) goto L17;
        android.service.autofill.augmented.Helper.logResponse(15, this.mComponentName.getPackageName(), activityComponent, sessionId, this.mRequestTimeoutMs);
        return;
    L17:
        return;
    L12:
        if (err == null) goto L18;
        Slog.e(TAG, "exception handling getAugmentedAutofillClient() for " + sessionId + ": ", err);
        return;
    }

    void dispatchCancellation(final ICancellationSignal cancellation) {
        if (cancellation != null) goto L4;
        return;
    L4:
        Handler.getMain().post(new RemoteAugmentedAutofillService$$ExternalSyntheticLambda0(cancellation));
    }

    private static /* synthetic */ void lambda$dispatchCancellation$2(ICancellationSignal cancellation) {
        cancellation.cancel();     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        Slog.e(TAG, "Error requesting a cancellation", e);
    }

    private void maybeRequestShowInlineSuggestions(final int sessionId, InlineSuggestionsRequest request, List<Dataset> inlineSuggestionsData, final Bundle clientState, final AutofillId focusedId, AutofillValue focusedValue, final Function<InlineFillUi, Boolean> inlineSuggestionsCallback, final IAutoFillManagerClient client, final Runnable onErrorCallback, RemoteInlineSuggestionRenderService remoteRenderService, final int userId, final ComponentName targetActivity, final IBinder targetActivityToken) {
        if (inlineSuggestionsData == null) goto L22;
        if (inlineSuggestionsData.isEmpty() == true) goto L22;
        if (inlineSuggestionsCallback == null) goto L22;
        if (request == null) goto L22;
        if (remoteRenderService == null) goto L22;
        this.mCallbacks.setLastResponse(sessionId);
        if (focusedValue != null) goto L13;
    L15:
        String r1 = null;
    L16:
        String filterText = r1;
        InlineFillUi.InlineFillUiInfo inlineFillUiInfo = new InlineFillUi.InlineFillUiInfo(request, focusedId, filterText, remoteRenderService, userId, sessionId);
        InlineFillUi inlineFillUi = InlineFillUi.forAugmentedAutofill(inlineFillUiInfo, inlineSuggestionsData, new AnonymousClass2(this, sessionId, clientState, client, inlineSuggestionsCallback, focusedId, targetActivity, targetActivityToken, userId, onErrorCallback));
        if (inlineSuggestionsCallback.apply(inlineFillUi).booleanValue() == false) goto L20;
        this.mCallbacks.logAugmentedAutofillShown(sessionId, clientState);
        return;
    L20:
        return;
    L13:
        if (focusedValue.isText() == false) goto L15;
        r1 = focusedValue.getTextValue().toString();
    L22:
        if (inlineSuggestionsCallback == 0) goto L27;
        if (request == null) goto L28;
        inlineSuggestionsCallback.apply(InlineFillUi.emptyUi(focusedId));
        return;
    L28:
        return;
    }

    public String toString() {
        return "RemoteAugmentedAutofillService[" + ComponentName.flattenToShortString(this.mComponentName) + "]";
    }

    private static /* synthetic */ void lambda$onDestroyAutofillWindowsRequest$3(IAugmentedAutofillService s) throws Exception {
        s.onDestroyAllFillWindowsRequest();
    }

    public void onDestroyAutofillWindowsRequest() {
        run(new RemoteAugmentedAutofillService$$ExternalSyntheticLambda2());
    }
}
