package com.android.server.credentials;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.credentials.CredentialProviderInfo;
import android.credentials.selection.DisabledProviderData;
import android.credentials.selection.IntentCreationResult;
import android.credentials.selection.IntentFactory;
import android.credentials.selection.ProviderData;
import android.credentials.selection.RequestInfo;
import android.credentials.selection.UserSelectionDialogResult;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.ResultReceiver;
import android.os.UserHandle;
import android.service.credentials.CredentialProviderInfoFactory;
import com.android.server.credentials.metrics.RequestSessionMetric;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public class CredentialManagerUi {
    private static final String SESSION_ID_TRACK_ONE = "com.android.server.credentials.CredentialManagerUi.SESSION_ID_TRACK_ONE";
    private static final String SESSION_ID_TRACK_TWO = "com.android.server.credentials.CredentialManagerUi.SESSION_ID_TRACK_TWO";
    private final CredentialManagerUiCallback mCallbacks;
    private final Context mContext;
    private final Set<ComponentName> mEnabledProviders;
    private final ResultReceiver mResultReceiver;
    private UiStatus mStatus;
    private final int mUserId;

    public interface CredentialManagerUiCallback {
        void onUiCancellation(boolean r1);

        void onUiSelection(UserSelectionDialogResult r1);

        void onUiSelectorInvocationFailure();
    }

    static final enum UiStatus extends Enum<UiStatus> {
        private static final /* synthetic */ UiStatus[] $VALUES = null;
        public static final UiStatus IN_PROGRESS = null;
        public static final UiStatus NOT_STARTED = null;
        public static final UiStatus TERMINATED = null;
        public static final UiStatus USER_INTERACTION = null;

        private static /* synthetic */ UiStatus[] $values() {
            return new UiStatus[]{IN_PROGRESS, USER_INTERACTION, NOT_STARTED, TERMINATED};
        }

        private UiStatus(String r1, int r2) {
            super(r1, r2);
        }

        public static UiStatus valueOf(String name) {
            return (UiStatus) Enum.valueOf(UiStatus.class, name);
        }

        public static UiStatus[] values() {
            return (UiStatus[]) $VALUES.clone();
        }

        static {
            IN_PROGRESS = new UiStatus("IN_PROGRESS", 0);
            USER_INTERACTION = new UiStatus("USER_INTERACTION", 1);
            NOT_STARTED = new UiStatus("NOT_STARTED", 2);
            TERMINATED = new UiStatus("TERMINATED", 3);
            $VALUES = $values();
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$NpZC9t6beIPxE86X7-ZSuMuqTFk, reason: not valid java name */
    public static /* synthetic */ DisabledProviderData m3291$r8$lambda$NpZC9t6beIPxE86X7ZSuMuqTFk(CredentialProviderInfo r0) {
        return lambda$createPendingIntent$1(r0);
    }

    public static /* synthetic */ boolean $r8$lambda$PaMmBJKd6vaxt_cqvRJOfj4tLH0(CredentialProviderInfo r0) {
        return lambda$createPendingIntent$0(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleUiResult, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3292$$Nest$mhandleUiResult(CredentialManagerUi r0, int r1, Bundle r2) {
        r0.handleUiResult(r1, r2);
    }

    private void handleUiResult(int resultCode, Bundle resultData) {
        switch(resultCode) {
            case 0: goto L9;
            case 1: goto L8;
            case 2: goto L5;
            case 3: goto L4;
            default: goto L3;
        };
    L3:
        this.mStatus = UiStatus.IN_PROGRESS;
        this.mCallbacks.onUiSelectorInvocationFailure();
        return;
    L4:
        this.mStatus = UiStatus.TERMINATED;
        this.mCallbacks.onUiSelectorInvocationFailure();
        return;
    L5:
        this.mStatus = UiStatus.IN_PROGRESS;
        UserSelectionDialogResult selection = UserSelectionDialogResult.fromResultData(resultData);
        if (selection == null) goto L13;
        this.mCallbacks.onUiSelection(selection);
        return;
    L13:
        return;
    L8:
        this.mStatus = UiStatus.TERMINATED;
        this.mCallbacks.onUiCancellation(false);
        return;
    L9:
        this.mStatus = UiStatus.TERMINATED;
        this.mCallbacks.onUiCancellation(true);
    }

    public Intent createCancelIntent(IBinder requestId, String packageName) {
        return IntentFactory.createCancelUiIntent(this.mContext, requestId, true, packageName, this.mUserId);
    }

    public CredentialManagerUi(Context context, int userId, CredentialManagerUiCallback callbacks, Set<ComponentName> enabledProviders) {
        final Handler r1 = new Handler(Looper.getMainLooper());
        this.mResultReceiver = new AnonymousClass1(this, r1);
        this.mContext = context;
        this.mUserId = userId;
        this.mCallbacks = callbacks;
        this.mEnabledProviders = enabledProviders;
        this.mStatus = UiStatus.IN_PROGRESS;
    }

    public void setStatus(UiStatus status) {
        this.mStatus = status;
    }

    public UiStatus getStatus() {
        return this.mStatus;
    }

    public PendingIntent createPendingIntent(RequestInfo requestInfo, ArrayList<ProviderData> providerDataList, RequestSessionMetric requestSessionMetric) {
        List<CredentialProviderInfo> allProviders = CredentialProviderInfoFactory.getCredentialProviderServices(this.mContext, this.mUserId, 2, this.mEnabledProviders, new HashSet());
        List<DisabledProviderData> disabledProviderDataList = allProviders.stream().filter(new CredentialManagerUi$$ExternalSyntheticLambda0()).map(new CredentialManagerUi$$ExternalSyntheticLambda1()).toList();
        IntentCreationResult intentCreationResult = IntentFactory.createCredentialSelectorIntentForCredMan(this.mContext, requestInfo, providerDataList, new ArrayList(disabledProviderDataList), this.mResultReceiver, this.mUserId);
        requestSessionMetric.collectUiConfigurationResults(this.mContext, intentCreationResult, this.mUserId);
        Intent intent = intentCreationResult.getIntent();
        intent.setAction(UUID.randomUUID().toString());
        intent.putExtra(SESSION_ID_TRACK_ONE, requestSessionMetric.getInitialPhaseMetric().getSessionIdCaller());
        intent.putExtra(SESSION_ID_TRACK_TWO, requestSessionMetric.getSessionIdTrackTwo());
        return PendingIntent.getActivityAsUser(this.mContext, 0, intent, 33554432, null, UserHandle.of(this.mUserId));
    }

    private static /* synthetic */ boolean lambda$createPendingIntent$0(CredentialProviderInfo provider) {
        return !provider.isEnabled();
    }

    private static /* synthetic */ DisabledProviderData lambda$createPendingIntent$1(CredentialProviderInfo disabledProvider) {
        return new DisabledProviderData(disabledProvider.getComponentName().flattenToString());
    }

    public Intent createIntentForAutofill(RequestInfo requestInfo, RequestSessionMetric requestSessionMetric) {
        IntentCreationResult intentCreationResult = IntentFactory.createCredentialSelectorIntentForAutofill(this.mContext, requestInfo, new ArrayList(), this.mResultReceiver, this.mUserId);
        requestSessionMetric.collectUiConfigurationResults(this.mContext, intentCreationResult, this.mUserId);
        return intentCreationResult.getIntent();
    }
}
