package com.android.server.credentials;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.credentials.Credential;
import android.credentials.CredentialProviderInfo;
import android.credentials.selection.ProviderData;
import android.credentials.selection.ProviderPendingIntentResponse;
import android.os.ICancellationSignal;
import android.os.RemoteException;
import android.util.Slog;
import com.android.server.credentials.metrics.ProviderSessionMetric;
import com.android.server.storage.DeviceStorageMonitorServiceSmtEx;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public abstract class ProviderSession<T, R> implements RemoteCredentialService.ProviderCallbacks<R> {
    private static final String TAG = "CredentialManager";
    protected final ProviderInternalCallback mCallbacks;
    protected final ComponentName mComponentName;
    protected final Context mContext;
    protected Credential mFinalCredentialResponse;
    protected ICancellationSignal mProviderCancellationSignal;
    protected final CredentialProviderInfo mProviderInfo;
    protected final T mProviderRequest;
    protected R mProviderResponse;
    protected Boolean mProviderResponseSet;
    protected final ProviderSessionMetric mProviderSessionMetric;
    private int mProviderSessionUid;
    protected final RemoteCredentialService mRemoteCredentialService;
    protected Status mStatus;
    protected final int mUserId;

    static final enum CredentialsSource extends Enum<CredentialsSource> {
        private static final /* synthetic */ CredentialsSource[] $VALUES = null;
        public static final CredentialsSource AUTH_ENTRY = null;
        public static final CredentialsSource REGISTRY = null;
        public static final CredentialsSource REMOTE_PROVIDER = null;

        private static /* synthetic */ CredentialsSource[] $values() {
            return new CredentialsSource[]{REMOTE_PROVIDER, REGISTRY, AUTH_ENTRY};
        }

        private CredentialsSource(String r1, int r2) {
            super(r1, r2);
        }

        public static CredentialsSource valueOf(String name) {
            return (CredentialsSource) Enum.valueOf(CredentialsSource.class, name);
        }

        public static CredentialsSource[] values() {
            return (CredentialsSource[]) $VALUES.clone();
        }

        static {
            REMOTE_PROVIDER = new CredentialsSource("REMOTE_PROVIDER", 0);
            REGISTRY = new CredentialsSource("REGISTRY", 1);
            AUTH_ENTRY = new CredentialsSource("AUTH_ENTRY", 2);
            $VALUES = $values();
        }
    }

    public interface ProviderInternalCallback<V> {
        void onFinalErrorReceived(ComponentName r1, String r2, String r3);

        void onFinalResponseReceived(ComponentName r1, V r2);

        void onProviderStatusChanged(Status r1, ComponentName r2, CredentialsSource r3);
    }

    static final enum Status extends Enum<Status> {
        private static final /* synthetic */ Status[] $VALUES = null;
        public static final Status CANCELED = null;
        public static final Status COMPLETE = null;
        public static final Status CREDENTIALS_RECEIVED = null;
        public static final Status EMPTY_RESPONSE = null;
        public static final Status NOT_STARTED = null;
        public static final Status NO_CREDENTIALS_FROM_AUTH_ENTRY = null;
        public static final Status PENDING = null;
        public static final Status SAVE_ENTRIES_RECEIVED = null;
        public static final Status SERVICE_DEAD = null;

        private static /* synthetic */ Status[] $values() {
            return new Status[]{NOT_STARTED, PENDING, CREDENTIALS_RECEIVED, SERVICE_DEAD, SAVE_ENTRIES_RECEIVED, CANCELED, EMPTY_RESPONSE, NO_CREDENTIALS_FROM_AUTH_ENTRY, COMPLETE};
        }

        private Status(String r1, int r2) {
            super(r1, r2);
        }

        public static Status valueOf(String name) {
            return (Status) Enum.valueOf(Status.class, name);
        }

        public static Status[] values() {
            return (Status[]) $VALUES.clone();
        }

        static {
            NOT_STARTED = new Status("NOT_STARTED", 0);
            PENDING = new Status("PENDING", 1);
            CREDENTIALS_RECEIVED = new Status("CREDENTIALS_RECEIVED", 2);
            SERVICE_DEAD = new Status("SERVICE_DEAD", 3);
            SAVE_ENTRIES_RECEIVED = new Status("SAVE_ENTRIES_RECEIVED", 4);
            CANCELED = new Status("CANCELED", 5);
            EMPTY_RESPONSE = new Status("EMPTY_RESPONSE", 6);
            NO_CREDENTIALS_FROM_AUTH_ENTRY = new Status("NO_CREDENTIALS_FROM_AUTH_ENTRY", 7);
            COMPLETE = new Status("COMPLETE", 8);
            $VALUES = $values();
        }
    }

    protected abstract void invokeSession();

    protected abstract void onUiEntrySelected(String r1, String r2, ProviderPendingIntentResponse r3);

    /* JADX INFO: renamed from: prepareUiData */
    protected abstract ProviderData mo3297prepareUiData();

    public static boolean isUiInvokingStatus(Status status) {
        if (status != Status.CREDENTIALS_RECEIVED) goto L5;
    L10:
        return true;
    L5:
        if (status == Status.SAVE_ENTRIES_RECEIVED) goto L10;
        if (status == Status.NO_CREDENTIALS_FROM_AUTH_ENTRY) goto L10;
        return false;
    }

    public static boolean isStatusWaitingForRemoteResponse(Status status) {
        if (status != Status.PENDING) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isTerminatingStatus(Status status) {
        if (status != Status.CANCELED) goto L5;
    L8:
        return true;
    L5:
        if (status == Status.SERVICE_DEAD) goto L8;
        return false;
    }

    public static boolean isCompletionStatus(Status status) {
        if (status != Status.COMPLETE) goto L5;
    L8:
        return true;
    L5:
        if (status == Status.EMPTY_RESPONSE) goto L8;
        return false;
    }

    public ProviderSessionMetric getProviderSessionMetric() {
        return this.mProviderSessionMetric;
    }

    protected ProviderSession(Context context, T providerRequest, ProviderInternalCallback callbacks, ComponentName componentName, int userId, RemoteCredentialService remoteCredentialService) {
        this.mStatus = Status.NOT_STARTED;
        this.mProviderResponseSet = false;
        this.mContext = context;
        this.mProviderInfo = null;
        this.mProviderRequest = providerRequest;
        this.mCallbacks = callbacks;
        this.mUserId = userId;
        this.mComponentName = componentName;
        this.mRemoteCredentialService = remoteCredentialService;
        this.mProviderSessionUid = MetricUtilities.getPackageUid(this.mContext, this.mComponentName, userId);
        this.mProviderSessionMetric = new ProviderSessionMetric(((RequestSession) this.mCallbacks).mRequestSessionMetric.getSessionIdTrackTwo());
    }

    protected static String generateUniqueId() {
        return UUID.randomUUID().toString();
    }

    public Credential getFinalCredentialResponse() {
        return this.mFinalCredentialResponse;
    }

    public void cancelProviderRemoteSession() {
    L5:
        e = move-exception;
        Slog.e(TAG, "Issue while cancelling provider session: ", e);
        return;
    L3:
        if (this.mProviderCancellationSignal == null) goto L7;
        this.mProviderCancellationSignal.cancel();     // Catch: RemoteException -> L5
    L7:
        setStatus(Status.CANCELED);     // Catch: RemoteException -> L5
    }

    protected void setStatus(Status status) {
        this.mStatus = status;
    }

    protected Status getStatus() {
        return this.mStatus;
    }

    protected ComponentName getComponentName() {
        return this.mComponentName;
    }

    protected RemoteCredentialService getRemoteCredentialService() {
        return this.mRemoteCredentialService;
    }

    protected void updateStatusAndInvokeCallback(Status status, CredentialsSource source) {
        setStatus(status);
        if (this.mProviderInfo != null) goto L5;
    L7:
        boolean r0 = false;
    L8:
        boolean isPrimary = r0;
        ProviderSessionMetric r3 = this.mProviderSessionMetric;
        if (isTerminatingStatus(status) == false) goto L11;
    L14:
        boolean r4 = true;
    L16:
        if (isCompletionStatus(status) == false) goto L18;
    L21:
        boolean r5 = true;
    L22:
        int r6 = this.mProviderSessionUid;
        if (source != CredentialsSource.AUTH_ENTRY) goto L25;
        boolean r7 = true;
    L26:
        r3.collectCandidateMetricUpdate(r4, r5, r6, r7, isPrimary);
        this.mCallbacks.onProviderStatusChanged(status, this.mComponentName, source);
        return;
    L25:
        r7 = false;
        goto L26
    L18:
        if (isUiInvokingStatus(status) == true) goto L21;
        r5 = false;
        goto L22
    L11:
        if (isStatusWaitingForRemoteResponse(status) == true) goto L14;
        r4 = false;
        goto L16
    L5:
        if (this.mProviderInfo.isPrimary() == false) goto L7;
        r0 = true;
        goto L8
    }

    protected void startCandidateMetrics() {
        this.mProviderSessionMetric.collectCandidateMetricSetupViaInitialMetric(((RequestSession) this.mCallbacks).mRequestSessionMetric.getInitialPhaseMetric());
    }

    protected T getProviderRequest() {
        return this.mProviderRequest;
    }

    protected Boolean isProviderResponseSet() {
        if (this.mProviderResponse == null) goto L5;
    L8:
        boolean r0 = true;
    L10:
        return Boolean.valueOf(r0);
    L5:
        if (this.mProviderResponseSet.booleanValue() == true) goto L8;
        r0 = false;
        goto L10
    }

    protected void invokeCallbackWithError(String errorType, String errorMessage) {
        this.mCallbacks.onFinalErrorReceived(this.mComponentName, errorType, errorMessage);
    }

    protected R getProviderResponse() {
        return this.mProviderResponse;
    }

    protected boolean enforceRemoteEntryRestrictions(ComponentName expectedRemoteEntryProviderService) {
        if (this.mComponentName.equals(expectedRemoteEntryProviderService) == true) goto L18;
        Slog.w(TAG, "Remote entry being dropped as it is not from the service configured by the OEM.");
        return false;
    L18:
        ApplicationInfo appInfo = this.mContext.getPackageManager().getApplicationInfo(this.mComponentName.getPackageName(), PackageManager.ApplicationInfoFlags.of(DeviceStorageMonitorServiceSmtEx.TrafficStats.MB_IN_BYTES));     // Catch: Throwable -> L12
        if (appInfo == null) goto L15;
        if (this.mContext.checkPermission("android.permission.PROVIDE_REMOTE_CREDENTIALS", -1, appInfo.uid) != 0) goto L15;
        return true;
    L15:
        return false;
    L12:
        e = move-exception;
        Slog.e(TAG, "Error getting info for " + this.mComponentName.flattenToString(), e);
        return false;
    }
}
