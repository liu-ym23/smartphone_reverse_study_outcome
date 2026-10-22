package com.android.server.autofill;

import android.content.ComponentName;
import android.content.Context;
import android.content.IntentSender;
import android.os.IBinder;
import android.service.autofill.ConvertCredentialResponse;
import android.service.autofill.FillRequest;
import android.service.autofill.FillResponse;
import android.util.Slog;

/* JADX INFO: loaded from: classes.dex */
final class SecondaryProviderHandler implements RemoteFillService.FillServiceCallbacks {
    private static final String TAG = "SecondaryProviderHandler";
    private final SecondaryProviderCallback mCallback;
    private int mLastFlag;
    private final RemoteFillService mRemoteFillService;

    interface SecondaryProviderCallback {
        void onSecondaryFillResponse(FillResponse r1, int r2);
    }

    public /* bridge */ /* synthetic */ void onServiceDied(Object r1) {
        onServiceDied((RemoteFillService) r1);
    }

    SecondaryProviderHandler(Context context, int userId, boolean bindInstantServiceAllowed, SecondaryProviderCallback callback, ComponentName componentName, ComponentName credentialAutofillService) {
        this.mRemoteFillService = new RemoteFillService(context, componentName, userId, this, bindInstantServiceAllowed, credentialAutofillService);
        this.mCallback = callback;
        Slog.v(TAG, "Creating a secondary provider handler with component name, " + componentName);
    }

    public void onServiceDied(RemoteFillService service) {
        this.mRemoteFillService.destroy();
    }

    @Override // com.android.server.autofill.RemoteFillService.FillServiceCallbacks
    public void onFillRequestSuccess(int requestId, FillResponse response, String servicePackageName, int requestFlags) {
        Slog.v(TAG, "Received a fill response: " + response);
        this.mCallback.onSecondaryFillResponse(response, this.mLastFlag);
    }

    @Override // com.android.server.autofill.RemoteFillService.FillServiceCallbacks
    public void onFillRequestFailure(int requestId, Throwable t) {
    }

    @Override // com.android.server.autofill.RemoteFillService.FillServiceCallbacks
    public void onSaveRequestSuccess(String servicePackageName, IntentSender intentSender) {
    }

    @Override // com.android.server.autofill.RemoteFillService.FillServiceCallbacks
    public void onSaveRequestFailure(CharSequence message, String servicePackageName) {
    }

    @Override // com.android.server.autofill.RemoteFillService.FillServiceCallbacks
    public void onConvertCredentialRequestSuccess(ConvertCredentialResponse convertCredentialResponse) {
    }

    public void onFillRequest(FillRequest pendingFillRequest, int flag, IBinder client) {
        Slog.v(TAG, "Requesting fill response to secondary provider.");
        this.mLastFlag = flag;
        if (this.mRemoteFillService != null) goto L5;
    L7:
        this.mRemoteFillService.onFillRequest(pendingFillRequest);
        return;
    L5:
        if (this.mRemoteFillService.isCredentialAutofillService() == false) goto L7;
        Slog.v(TAG, "About to call CredAutofill service as secondary provider");
        this.mRemoteFillService.onFillCredentialRequest(pendingFillRequest, client);
    }

    public void destroy() {
        this.mRemoteFillService.destroy();
    }
}
