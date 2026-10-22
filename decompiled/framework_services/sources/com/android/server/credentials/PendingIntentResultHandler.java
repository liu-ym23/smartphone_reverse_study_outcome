package com.android.server.credentials;

import android.content.Intent;
import android.credentials.CreateCredentialException;
import android.credentials.CreateCredentialResponse;
import android.credentials.GetCredentialException;
import android.credentials.GetCredentialResponse;
import android.credentials.selection.ProviderPendingIntentResponse;
import android.service.credentials.BeginGetCredentialResponse;

/* JADX INFO: loaded from: classes.dex */
public class PendingIntentResultHandler {
    public PendingIntentResultHandler() {
    }

    public static boolean isValidResponse(ProviderPendingIntentResponse pendingIntentResponse) {
        if (pendingIntentResponse.getResultCode() != (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isCancelledResponse(ProviderPendingIntentResponse pendingIntentResponse) {
        if (pendingIntentResponse.getResultCode() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static BeginGetCredentialResponse extractResponseContent(Intent resultData) {
        if (resultData != null) goto L6;
        return null;
    L6:
        return (BeginGetCredentialResponse) resultData.getParcelableExtra("android.service.credentials.extra.BEGIN_GET_CREDENTIAL_RESPONSE", BeginGetCredentialResponse.class);
    }

    public static CreateCredentialResponse extractCreateCredentialResponse(Intent resultData) {
        if (resultData != null) goto L6;
        return null;
    L6:
        return (CreateCredentialResponse) resultData.getParcelableExtra("android.service.credentials.extra.CREATE_CREDENTIAL_RESPONSE", CreateCredentialResponse.class);
    }

    public static GetCredentialResponse extractGetCredentialResponse(Intent resultData) {
        if (resultData != null) goto L6;
        return null;
    L6:
        return (GetCredentialResponse) resultData.getParcelableExtra("android.service.credentials.extra.GET_CREDENTIAL_RESPONSE", GetCredentialResponse.class);
    }

    public static CreateCredentialException extractCreateCredentialException(Intent resultData) {
        if (resultData != null) goto L6;
        return null;
    L6:
        return (CreateCredentialException) resultData.getSerializableExtra("android.service.credentials.extra.CREATE_CREDENTIAL_EXCEPTION", CreateCredentialException.class);
    }

    public static GetCredentialException extractGetCredentialException(Intent resultData) {
        if (resultData != null) goto L6;
        return null;
    L6:
        return (GetCredentialException) resultData.getSerializableExtra("android.service.credentials.extra.GET_CREDENTIAL_EXCEPTION", GetCredentialException.class);
    }
}
