package com.android.server.credentials;

import android.R;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.credentials.ClearCredentialStateRequest;
import android.credentials.CreateCredentialRequest;
import android.credentials.CredentialOption;
import android.credentials.CredentialProviderInfo;
import android.credentials.GetCredentialRequest;
import android.credentials.IClearCredentialStateCallback;
import android.credentials.ICreateCredentialCallback;
import android.credentials.ICredentialManager;
import android.credentials.IGetCandidateCredentialsCallback;
import android.credentials.IGetCredentialCallback;
import android.credentials.IPrepareGetCredentialCallback;
import android.credentials.ISetEnabledProvidersCallback;
import android.credentials.PrepareGetCredentialResponseInternal;
import android.credentials.RegisterCredentialDescriptionRequest;
import android.credentials.UnregisterCredentialDescriptionRequest;
import android.os.Binder;
import android.os.CancellationSignal;
import android.os.IBinder;
import android.os.ICancellationSignal;
import android.os.RemoteException;
import android.os.UserHandle;
import android.provider.DeviceConfig;
import android.provider.Settings;
import android.service.credentials.CallingAppInfo;
import android.service.credentials.CredentialProviderInfoFactory;
import android.service.credentials.PermissionUtils;
import android.text.TextUtils;
import android.util.Pair;
import android.util.Slog;
import android.util.SparseArray;
import com.android.server.SystemService;
import com.android.server.credentials.metrics.ApiName;
import com.android.server.credentials.metrics.ApiStatus;
import com.android.server.credentials.metrics.InitialPhaseMetric;
import com.android.server.infra.AbstractMasterSystemService;
import com.android.server.infra.AbstractPerUserSystemService;
import com.android.server.infra.SecureSettingsServiceNameResolver;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/* JADX INFO: loaded from: classes.dex */
public final class CredentialManagerService extends AbstractMasterSystemService<CredentialManagerService, CredentialManagerServiceImpl> {
    public static final String AUTOFILL_PLACEHOLDER_VALUE = "credential-provider";
    private static final String DEVICE_CONFIG_ENABLE_CREDENTIAL_DESC_API = "enable_credential_description_api";
    private static final String DEVICE_CONFIG_ENABLE_CREDENTIAL_MANAGER = "enable_credential_manager";
    private static final String PERMISSION_DENIED_ERROR = "permission_denied";
    private static final String PERMISSION_DENIED_WRITE_SECURE_SETTINGS_ERROR = "Caller is missing WRITE_SECURE_SETTINGS permission";
    private static final String TAG = "CredentialManager";
    private final Context mContext;
    private final SparseArray<Map<IBinder, RequestSession>> mRequestSessions;
    private final SessionManager mSessionManager;
    private final SparseArray<List<CredentialManagerServiceImpl>> mSystemServicesCacheList;

    final class CredentialManagerServiceStub extends ICredentialManager.Stub {
        final /* synthetic */ CredentialManagerService this$0;

        public static /* synthetic */ boolean $r8$lambda$J7eNdDNWWdYDakEEwXN49Wz2huk(CredentialOption r0) {
            return lambda$prepareProviderSessions$0(r0);
        }

        /* JADX INFO: renamed from: $r8$lambda$rzrr4GW8zwImXK8NA4m010oXF-E, reason: not valid java name */
        public static /* synthetic */ boolean m3289$r8$lambda$rzrr4GW8zwImXK8NA4m010oXFE(CredentialOption r0) {
            return lambda$prepareProviderSessions$1(r0);
        }

        CredentialManagerServiceStub(CredentialManagerService this$0) {
            this.this$0 = this$0;
        }

        /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
        public ICancellationSignal getCandidateCredentials(GetCredentialRequest request, IGetCandidateCredentialsCallback callback, IBinder clientBinder, String callingPackage) {
            Slog.i(CredentialManagerService.TAG, "starting getCandidateCredentials with callingPackage: " + callingPackage);
            ICancellationSignal cancelTransport = CancellationSignal.createTransport();
            int userId = UserHandle.getCallingUserId();
            int callingUid = Binder.getCallingUid();
            String credentialManagerAutofillCompName = CredentialManagerService.m3276$$Nest$fgetmContext(this.this$0).getResources().getString(R.string.config_dozeLongPressSensorType);     // Catch: Resources.NotFoundException -> L28
            ComponentName componentName = ComponentName.unflattenFromString(credentialManagerAutofillCompName);     // Catch: Resources.NotFoundException -> L28
            if (componentName == null) goto L33;
            PackageManager pm = CredentialManagerService.m3276$$Nest$fgetmContext(this.this$0).createContextAsUser(UserHandle.getUserHandleForUid(callingUid), 0).getPackageManager();     // Catch: Resources.NotFoundException -> L28
            String callingProcessPackage = pm.getNameForUid(callingUid);     // Catch: Resources.NotFoundException -> L28
            if (callingProcessPackage == null) goto L31;
            if (Objects.equals(componentName.getPackageName(), callingProcessPackage) == false) goto L25;
            GetCandidateRequestSession session = new GetCandidateRequestSession(this.this$0.getContext(), CredentialManagerService.m3278$$Nest$fgetmSessionManager(this.this$0), CredentialManagerService.access$000(this.this$0), userId, callingUid, callback, request, CredentialManagerService.m3280$$Nest$mconstructCallingAppInfo(this.this$0, callingPackage, userId, request.getOrigin()), getEnabledProvidersForUser(userId), CancellationSignal.fromTransport(cancelTransport), clientBinder);
            CredentialManagerService.m3279$$Nest$maddSessionLocked(this.this$0, userId, session);
            List<ProviderSession> providerSessions = CredentialManagerService.m3285$$Nest$minitiateProviderSessions(this.this$0, session, (List) request.getCredentialOptions().stream().map(new CredentialManagerService$CredentialManagerServiceStub$$ExternalSyntheticLambda3()).collect(Collectors.toList()));
            finalizeAndEmitInitialPhaseMetric(session);
            if (providerSessions.isEmpty() == false) goto L21;
            callback.onError("android.credentials.GetCandidateCredentialsException.TYPE_NO_CREDENTIAL", "No credentials available on this device.");     // Catch: RemoteException -> L15
        L15:
            e = move-exception;
            Slog.i(CredentialManagerService.TAG, "Issue invoking onError on IGetCredentialCallback callback: " + e.getMessage());
        L21:
            invokeProviderSessions(providerSessions);
            return cancelTransport;
        L25:
            throw new SecurityException(callingProcessPackage + " is not the device's credential autofill package.");     // Catch: Resources.NotFoundException -> L26
        L31:
            throw new SecurityException("Couldn't determine the identity of the caller.");     // Catch: Resources.NotFoundException -> L26
        L33:
            throw new SecurityException("Credential Autofill service does not exist on this device.");     // Catch: Resources.NotFoundException -> L26
        L35:
            throw new SecurityException("Credential Autofill service does not exist on this device.");
        }

        /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
        public ICancellationSignal executeGetCredential(GetCredentialRequest request, IGetCredentialCallback callback, String callingPackage) {
            long timestampBegan = System.nanoTime();
            Slog.i(CredentialManagerService.TAG, "starting executeGetCredential with callingPackage: " + callingPackage);
            ICancellationSignal cancelTransport = CancellationSignal.createTransport();
            int userId = UserHandle.getCallingUserId();
            int callingUid = Binder.getCallingUid();
            CredentialManagerService.m3281$$Nest$menforceCallingPackage(this.this$0, callingPackage, callingUid);
            CredentialManagerService.m3287$$Nest$mvalidateGetCredentialRequest(this.this$0, request);
            GetRequestSession session = new GetRequestSession(this.this$0.getContext(), CredentialManagerService.m3278$$Nest$fgetmSessionManager(this.this$0), CredentialManagerService.access$100(this.this$0), userId, callingUid, callback, request, CredentialManagerService.m3280$$Nest$mconstructCallingAppInfo(this.this$0, callingPackage, userId, request.getOrigin()), getEnabledProvidersForUser(userId), CancellationSignal.fromTransport(cancelTransport), timestampBegan);
            CredentialManagerService.m3279$$Nest$maddSessionLocked(this.this$0, userId, session);
            List<ProviderSession> providerSessions = prepareProviderSessions(request, session);
            if (providerSessions.isEmpty() == false) goto L14;
            callback.onError("android.credentials.GetCredentialException.TYPE_NO_CREDENTIAL", "No credentials available on this device.");     // Catch: RemoteException -> L8
        L8:
            e = move-exception;
            Slog.e(CredentialManagerService.TAG, "Issue invoking onError on IGetCredentialCallback callback: " + e.getMessage());
        L14:
            invokeProviderSessions(providerSessions);
            return cancelTransport;
        }

        public ICancellationSignal executePrepareGetCredential(GetCredentialRequest request, IPrepareGetCredentialCallback prepareGetCredentialCallback, IGetCredentialCallback getCredentialCallback, String callingPackage) {
            long timestampBegan = System.nanoTime();
            ICancellationSignal cancelTransport = CancellationSignal.createTransport();
            if (request.getOrigin() == null) goto L5;
            CredentialManagerService.m3276$$Nest$fgetmContext(this.this$0).enforceCallingPermission("android.permission.CREDENTIAL_MANAGER_SET_ORIGIN", null);
        L5:
            CredentialManagerService.m3282$$Nest$menforcePermissionForAllowedProviders(this.this$0, request);
            int userId = UserHandle.getCallingUserId();
            int callingUid = Binder.getCallingUid();
            CredentialManagerService.m3281$$Nest$menforceCallingPackage(this.this$0, callingPackage, callingUid);
            PrepareGetRequestSession session = new PrepareGetRequestSession(this.this$0.getContext(), CredentialManagerService.m3278$$Nest$fgetmSessionManager(this.this$0), CredentialManagerService.access$200(this.this$0), userId, callingUid, getCredentialCallback, request, CredentialManagerService.m3280$$Nest$mconstructCallingAppInfo(this.this$0, callingPackage, userId, request.getOrigin()), getEnabledProvidersForUser(userId), CancellationSignal.fromTransport(cancelTransport), timestampBegan, prepareGetCredentialCallback);
            List<ProviderSession> providerSessions = prepareProviderSessions(request, session);
            if (providerSessions.isEmpty() == false) goto L21;
            prepareGetCredentialCallback.onResponse(new PrepareGetCredentialResponseInternal(PermissionUtils.hasPermission(CredentialManagerService.m3276$$Nest$fgetmContext(this.this$0), callingPackage, "android.permission.CREDENTIAL_MANAGER_QUERY_CANDIDATE_CREDENTIALS"), null, false, false, null));     // Catch: RemoteException -> L13
        L13:
            e = e;
        L19:
            Slog.e(CredentialManagerService.TAG, "Issue invoking onError on IGetCredentialCallback callback: " + e.getMessage());
        L15:
            e = e;
        L17:
            e = e;
        L21:
            invokeProviderSessions(providerSessions);
            return cancelTransport;
        }

        private List<ProviderSession> prepareProviderSessions(GetCredentialRequest request, GetRequestSession session) {
            if (CredentialManagerService.isCredentialDescriptionApiEnabled() == false) goto L5;
            List<CredentialOption> optionsThatRequireActiveCredentials = request.getCredentialOptions().stream().filter(new CredentialManagerService$CredentialManagerServiceStub$$ExternalSyntheticLambda1()).toList();
            List<CredentialOption> optionsThatDoNotRequireActiveCredentials = request.getCredentialOptions().stream().filter(new CredentialManagerService$CredentialManagerServiceStub$$ExternalSyntheticLambda2()).toList();
            Collection<? extends ProviderSession> sessionsWithoutRemoteService = CredentialManagerService.m3286$$Nest$minitiateProviderSessionsWithActiveContainers(this.this$0, session, CredentialManagerService.m3283$$Nest$mgetFilteredResultFromRegistry(this.this$0, optionsThatRequireActiveCredentials));
            Collection<? extends ProviderSession> sessionsWithRemoteService = CredentialManagerService.m3285$$Nest$minitiateProviderSessions(this.this$0, session, (List) optionsThatDoNotRequireActiveCredentials.stream().map(new CredentialManagerService$CredentialManagerServiceStub$$ExternalSyntheticLambda3()).collect(Collectors.toList()));
            Set<ProviderSession> all = new LinkedHashSet();
            all.addAll(sessionsWithRemoteService);
            all.addAll(sessionsWithoutRemoteService);
            List<ProviderSession> providerSessions = new ArrayList(all);
        L6:
            finalizeAndEmitInitialPhaseMetric(session);
            return providerSessions;
        L5:
            providerSessions = CredentialManagerService.m3285$$Nest$minitiateProviderSessions(this.this$0, session, (List) request.getCredentialOptions().stream().map(new CredentialManagerService$CredentialManagerServiceStub$$ExternalSyntheticLambda3()).collect(Collectors.toList()));
            goto L6
        }

        private static /* synthetic */ boolean lambda$prepareProviderSessions$0(CredentialOption credentialOption) {
            if (credentialOption.getCredentialRetrievalData().getStringArrayList("android.credentials.GetCredentialOption.SUPPORTED_ELEMENT_KEYS") == null) goto L5;
            return true;
        L5:
            return false;
        }

        private static /* synthetic */ boolean lambda$prepareProviderSessions$1(CredentialOption credentialOption) {
            if (credentialOption.getCredentialRetrievalData().getStringArrayList("android.credentials.GetCredentialOption.SUPPORTED_ELEMENT_KEYS") != null) goto L5;
            return true;
        L5:
            return false;
        }

        private void invokeProviderSessions(List<ProviderSession> providerSessions) {
            providerSessions.forEach(new CredentialManagerService$CredentialManagerServiceStub$$ExternalSyntheticLambda0());
        }

        public ICancellationSignal executeCreateCredential(CreateCredentialRequest request, ICreateCredentialCallback callback, String callingPackage) {
            long timestampBegan = System.nanoTime();
            Slog.i(CredentialManagerService.TAG, "starting executeCreateCredential with callingPackage: " + callingPackage);
            ICancellationSignal cancelTransport = CancellationSignal.createTransport();
            if (request.getOrigin() == null) goto L5;
            CredentialManagerService.m3276$$Nest$fgetmContext(this.this$0).enforceCallingPermission("android.permission.CREDENTIAL_MANAGER_SET_ORIGIN", null);
        L5:
            int userId = UserHandle.getCallingUserId();
            int callingUid = Binder.getCallingUid();
            CredentialManagerService.m3281$$Nest$menforceCallingPackage(this.this$0, callingPackage, callingUid);
            CreateRequestSession session = new CreateRequestSession(this.this$0.getContext(), CredentialManagerService.m3278$$Nest$fgetmSessionManager(this.this$0), CredentialManagerService.access$300(this.this$0), userId, callingUid, request, callback, CredentialManagerService.m3280$$Nest$mconstructCallingAppInfo(this.this$0, callingPackage, userId, request.getOrigin()), getEnabledProvidersForUser(userId), CredentialManagerService.getPrimaryProvidersForUserId(this.this$0.getContext(), userId), CancellationSignal.fromTransport(cancelTransport), timestampBegan);
            CredentialManagerService.m3279$$Nest$maddSessionLocked(this.this$0, userId, session);
            processCreateCredential(request, callback, session);
            return cancelTransport;
        }

        private void processCreateCredential(CreateCredentialRequest request, ICreateCredentialCallback callback, CreateRequestSession session) {
            List<ProviderSession> providerSessions = CredentialManagerService.m3285$$Nest$minitiateProviderSessions(this.this$0, session, List.of(request.getType()));
            if (providerSessions.isEmpty() == true) goto L10;
        L8:
            finalizeAndEmitInitialPhaseMetric(session);
            providerSessions.forEach(new CredentialManagerService$CredentialManagerServiceStub$$ExternalSyntheticLambda0());
            return;
        L10:
            callback.onError("android.credentials.CreateCredentialException.TYPE_NO_CREATE_OPTIONS", "No create options available.");     // Catch: RemoteException -> L6
        L6:
            e = move-exception;
            Slog.e(CredentialManagerService.TAG, "Issue invoking onError on ICreateCredentialCallback callback: ", e);
            goto L8
        }

        private void finalizeAndEmitInitialPhaseMetric(GetCandidateRequestSession session) {
            InitialPhaseMetric initMetric = session.mRequestSessionMetric.getInitialPhaseMetric();
            initMetric.setAutofillSessionId(session.getAutofillSessionId());
            initMetric.setAutofillRequestId(session.getAutofillRequestId());
            finalizeAndEmitInitialPhaseMetric(session);
        }

        private void finalizeAndEmitInitialPhaseMetric(RequestSession session) {
            InitialPhaseMetric initMetric = session.mRequestSessionMetric.getInitialPhaseMetric();     // Catch: Exception -> L4
            initMetric.setCredentialServiceBeginQueryTimeNanoseconds(System.nanoTime());     // Catch: Exception -> L4
            MetricUtilities.logApiCalledInitialPhase(initMetric, session.mRequestSessionMetric.returnIncrementSequence());     // Catch: Exception -> L4
            return;
        L4:
            e = move-exception;
            Slog.i(CredentialManagerService.TAG, "Unexpected error during metric logging: ", e);
        }

        public void setEnabledProviders(List<String> primaryProviders, List<String> providers, int userId, ISetEnabledProvidersCallback callback) {
            int callingUid = Binder.getCallingUid();
            if (CredentialManagerService.m3284$$Nest$mhasWriteSecureSettingsPermission(this.this$0) == false) goto L26;
            int userId2 = ActivityManager.handleIncomingUser(Binder.getCallingPid(), Binder.getCallingUid(), userId, false, false, "setEnabledProviders", null);
            Set<String> enableProvider = new HashSet(providers);
            enableProvider.addAll(primaryProviders);
            boolean writeEnabledStatus = Settings.Secure.putStringForUser(this.this$0.getContext().getContentResolver(), "credential_service", String.join(":", enableProvider), userId2);
            boolean writePrimaryStatus = Settings.Secure.putStringForUser(this.this$0.getContext().getContentResolver(), "credential_service_primary", String.join(":", primaryProviders), userId2);
            if (writeEnabledStatus == false) goto L12;
            if (writePrimaryStatus == false) goto L12;
        L22:
            MetricUtilities.logApiCalledSimpleV2(ApiName.SET_ENABLED_PROVIDERS, ApiStatus.SUCCESS, callingUid);     // Catch: RemoteException -> L16
            callback.onResponse();     // Catch: RemoteException -> L16
            return;
        L16:
            e = move-exception;
            MetricUtilities.logApiCalledSimpleV2(ApiName.SET_ENABLED_PROVIDERS, ApiStatus.FAILURE, callingUid);
            Slog.e(CredentialManagerService.TAG, "Issue with invoking response: ", e);
            return;
        L12:
            Slog.e(CredentialManagerService.TAG, "Failed to store setting containing enabled or primary providers");
            MetricUtilities.logApiCalledSimpleV2(ApiName.SET_ENABLED_PROVIDERS, ApiStatus.FAILURE, callingUid);     // Catch: RemoteException -> L19
            callback.onError("failed_setting_store", "Failed to store setting containing enabled or primary providers");     // Catch: RemoteException -> L19
        L19:
            e = move-exception;
            MetricUtilities.logApiCalledSimpleV2(ApiName.SET_ENABLED_PROVIDERS, ApiStatus.FAILURE, callingUid);
            Slog.e(CredentialManagerService.TAG, "Issue with invoking error response: ", e);
            return;
        L26:
            MetricUtilities.logApiCalledSimpleV2(ApiName.SET_ENABLED_PROVIDERS, ApiStatus.FAILURE, callingUid);     // Catch: RemoteException -> L6
            callback.onError(CredentialManagerService.PERMISSION_DENIED_ERROR, CredentialManagerService.PERMISSION_DENIED_WRITE_SECURE_SETTINGS_ERROR);     // Catch: RemoteException -> L6
            return;
        L6:
            e = move-exception;
            MetricUtilities.logApiCalledSimpleV2(ApiName.SET_ENABLED_PROVIDERS, ApiStatus.FAILURE, callingUid);
            Slog.e(CredentialManagerService.TAG, "Issue with invoking response: ", e);
        }

        public boolean isEnabledCredentialProviderService(ComponentName componentName, String callingPackage) {
            Slog.i(CredentialManagerService.TAG, "isEnabledCredentialProviderService with componentName: " + componentName.flattenToString());
            int userId = UserHandle.getCallingUserId();
            int callingUid = Binder.getCallingUid();
            CredentialManagerService.m3281$$Nest$menforceCallingPackage(this.this$0, callingPackage, callingUid);
            if (componentName.getPackageName().equals(callingPackage) == false) goto L10;
            Set<ComponentName> enabledProviders = getEnabledProvidersForUser(userId);
            MetricUtilities.logApiCalledSimpleV2(ApiName.IS_ENABLED_CREDENTIAL_PROVIDER_SERVICE, ApiStatus.SUCCESS, callingUid);
            if (enabledProviders != null) goto L9;
            return false;
        L9:
            return enabledProviders.contains(componentName);
        L10:
            Slog.w(CredentialManagerService.TAG, "isEnabledCredentialProviderService component name does not match requested component");
            MetricUtilities.logApiCalledSimpleV2(ApiName.IS_ENABLED_CREDENTIAL_PROVIDER_SERVICE, ApiStatus.FAILURE, callingUid);
            throw new IllegalArgumentException("provided component name does not match does not match requesting component");
        }

        public List<CredentialProviderInfo> getCredentialProviderServices(int userId, int providerFilter) {
            CredentialManagerService.m3288$$Nest$mverifyGetProvidersPermission(this.this$0);
            int callingUid = Binder.getCallingUid();
            MetricUtilities.logApiCalledSimpleV2(ApiName.GET_CREDENTIAL_PROVIDER_SERVICES, ApiStatus.SUCCESS, callingUid);
            return CredentialProviderInfoFactory.getCredentialProviderServices(CredentialManagerService.m3276$$Nest$fgetmContext(this.this$0), userId, providerFilter, getEnabledProvidersForUser(userId), CredentialManagerService.getPrimaryProvidersForUserId(CredentialManagerService.m3276$$Nest$fgetmContext(this.this$0), userId));
        }

        public List<CredentialProviderInfo> getCredentialProviderServicesForTesting(int providerFilter) {
            CredentialManagerService.m3288$$Nest$mverifyGetProvidersPermission(this.this$0);
            int userId = UserHandle.getCallingUserId();
            return CredentialProviderInfoFactory.getCredentialProviderServicesForTesting(CredentialManagerService.m3276$$Nest$fgetmContext(this.this$0), userId, providerFilter, getEnabledProvidersForUser(userId), CredentialManagerService.getPrimaryProvidersForUserId(CredentialManagerService.m3276$$Nest$fgetmContext(this.this$0), userId));
        }

        public boolean isServiceEnabled() {
            long origId = Binder.clearCallingIdentity();
            boolean r2 = DeviceConfig.getBoolean("credential_manager", CredentialManagerService.DEVICE_CONFIG_ENABLE_CREDENTIAL_MANAGER, true);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(origId);
            return r2;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(origId);
            throw th;
        }

        private Set<ComponentName> getEnabledProvidersForUser(int userId) {
            int resolvedUserId = ActivityManager.handleIncomingUser(Binder.getCallingPid(), Binder.getCallingUid(), userId, false, false, "getEnabledProvidersForUser", null);
            Set<ComponentName> enabledProviders = new HashSet();
            String directValue = Settings.Secure.getStringForUser(CredentialManagerService.m3276$$Nest$fgetmContext(this.this$0).getContentResolver(), "credential_service", resolvedUserId);
            if (TextUtils.isEmpty(directValue) == true) goto L11;
            String[] components = directValue.split(":");
            int r4 = components.length;
            int r5 = 0;
        L6:
            if (r5 >= r4) goto L11;
            String componentString = components[r5];
            ComponentName component = ComponentName.unflattenFromString(componentString);
            if (component == null) goto L10;
            enabledProviders.add(component);
        L10:
            r5 = r5 + 1;
        L11:
            return enabledProviders;
        }

        /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
        public ICancellationSignal clearCredentialState(ClearCredentialStateRequest request, IClearCredentialStateCallback callback, String callingPackage) {
            long timestampBegan = System.nanoTime();
            Slog.i(CredentialManagerService.TAG, "starting clearCredentialState with callingPackage: " + callingPackage);
            int userId = UserHandle.getCallingUserId();
            int callingUid = Binder.getCallingUid();
            CredentialManagerService.m3281$$Nest$menforceCallingPackage(this.this$0, callingPackage, callingUid);
            ICancellationSignal cancelTransport = CancellationSignal.createTransport();
            ClearRequestSession session = new ClearRequestSession(this.this$0.getContext(), CredentialManagerService.m3278$$Nest$fgetmSessionManager(this.this$0), CredentialManagerService.access$400(this.this$0), userId, callingUid, callback, request, CredentialManagerService.m3280$$Nest$mconstructCallingAppInfo(this.this$0, callingPackage, userId, null), getEnabledProvidersForUser(userId), CancellationSignal.fromTransport(cancelTransport), timestampBegan);
            CredentialManagerService.m3279$$Nest$maddSessionLocked(this.this$0, userId, session);
            List<ProviderSession> providerSessions = CredentialManagerService.m3285$$Nest$minitiateProviderSessions(this.this$0, session, List.of());
            if (providerSessions.isEmpty() == false) goto L14;
            callback.onError("UNKNOWN", "No credentials available on this device");     // Catch: RemoteException -> L8
        L8:
            e = move-exception;
            Slog.e(CredentialManagerService.TAG, "Issue invoking onError on IClearCredentialStateCallback callback: ", e);
        L14:
            finalizeAndEmitInitialPhaseMetric(session);
            providerSessions.forEach(new CredentialManagerService$CredentialManagerServiceStub$$ExternalSyntheticLambda0());
            return cancelTransport;
        }

        public void registerCredentialDescription(RegisterCredentialDescriptionRequest request, String callingPackage) throws IllegalArgumentException, NonCredentialProviderCallerException {
            Slog.i(CredentialManagerService.TAG, "registerCredentialDescription with callingPackage: " + callingPackage);
            if (CredentialManagerService.isCredentialDescriptionApiEnabled() == false) goto L7;
            CredentialManagerService.m3281$$Nest$menforceCallingPackage(this.this$0, callingPackage, Binder.getCallingUid());
            CredentialDescriptionRegistry session = CredentialDescriptionRegistry.forUser(UserHandle.getCallingUserId());
            session.executeRegisterRequest(request, callingPackage);
            return;
        L7:
            throw new UnsupportedOperationException("Feature not supported");
        }

        public void unregisterCredentialDescription(UnregisterCredentialDescriptionRequest request, String callingPackage) throws IllegalArgumentException {
            Slog.i(CredentialManagerService.TAG, "unregisterCredentialDescription with callingPackage: " + callingPackage);
            if (CredentialManagerService.isCredentialDescriptionApiEnabled() == false) goto L7;
            CredentialManagerService.m3281$$Nest$menforceCallingPackage(this.this$0, callingPackage, Binder.getCallingUid());
            CredentialDescriptionRegistry session = CredentialDescriptionRegistry.forUser(UserHandle.getCallingUserId());
            session.executeUnregisterRequest(request, callingPackage);
            return;
        L7:
            throw new UnsupportedOperationException("Feature not supported");
        }
    }

    private class SessionManager implements RequestSession.SessionLifetime {
        final /* synthetic */ CredentialManagerService this$0;

        /* synthetic */ SessionManager(CredentialManagerService r1, CredentialManagerServiceIA r2) {
            this(r1);
        }

        private SessionManager(CredentialManagerService r1) {
            this.this$0 = r1;
        }

        @Override // com.android.server.credentials.RequestSession.SessionLifetime
        public void onFinishRequestSession(int userId, IBinder token) {
            if (CredentialManagerService.m3277$$Nest$fgetmRequestSessions(this.this$0).get(userId) == null) goto L6;
            ((Map) CredentialManagerService.m3277$$Nest$fgetmRequestSessions(this.this$0).get(userId)).remove(token);
            return;
        }

        public void addSession(int userId, IBinder token, RequestSession requestSession) {
            if (CredentialManagerService.m3277$$Nest$fgetmRequestSessions(this.this$0).get(userId) != null) goto L5;
            CredentialManagerService.m3277$$Nest$fgetmRequestSessions(this.this$0).put(userId, new HashMap());
        L5:
            ((Map) CredentialManagerService.m3277$$Nest$fgetmRequestSessions(this.this$0).get(userId)).put(token, requestSession);
        }
    }

    public static class SettingsWrapper {
        private final Context mContext;

        /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
        static /* bridge */ /* synthetic */ Context m3290$$Nest$fgetmContext(SettingsWrapper r0) {
            return r0.mContext;
        }

        public SettingsWrapper(Context context) {
            this.mContext = context;
        }

        ContentResolver getContentResolver() {
            return this.mContext.getContentResolver();
        }

        public String getStringForUser(String name, int userHandle) {
            return Settings.Secure.getStringForUser(getContentResolver(), name, userHandle);
        }

        public boolean putStringForUser(String name, String value, int userHandle, boolean overrideableByRestore) {
            return Settings.Secure.putStringForUser(getContentResolver(), name, value, null, false, userHandle, overrideableByRestore);
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$BiC7ap8XzY-FGZ5MVvp72o3GMlU, reason: not valid java name */
    public static /* synthetic */ void m3274$r8$lambda$BiC7ap8XzYFGZ5MVvp72o3GMlU(CredentialManagerService r0, RequestSession r1, List r2, List r3, CredentialManagerServiceImpl r4) {
        r0.lambda$initiateProviderSessions$2(r1, r2, r3, r4);
    }

    public static /* synthetic */ HashSet $r8$lambda$LuPJXLsEy6odrKDM4_N9DyQ2xIs(CredentialOption r0) {
        return lambda$getFilteredResultFromRegistry$1(r0);
    }

    public static /* synthetic */ void $r8$lambda$dR0R1pqgx2zR0iStNh7rmXlMP1g(CredentialManagerService r0, List r1, int r2, CredentialProviderInfo r3) {
        r0.lambda$constructSystemServiceListLocked$0(r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$mvYqYC1ADkjQ-w9QEXTJKgA-4ys, reason: not valid java name */
    public static /* synthetic */ boolean m3275$r8$lambda$mvYqYC1ADkjQw9QEXTJKgA4ys(CredentialOption r0) {
        return lambda$enforcePermissionForAllowedProviders$3(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m3276$$Nest$fgetmContext(CredentialManagerService r0) {
        return r0.mContext;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmRequestSessions, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseArray m3277$$Nest$fgetmRequestSessions(CredentialManagerService r0) {
        return r0.mRequestSessions;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSessionManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ SessionManager m3278$$Nest$fgetmSessionManager(CredentialManagerService r0) {
        return r0.mSessionManager;
    }

    /* JADX INFO: renamed from: -$$Nest$maddSessionLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3279$$Nest$maddSessionLocked(CredentialManagerService r0, int r1, RequestSession r2) {
        r0.addSessionLocked(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mconstructCallingAppInfo, reason: not valid java name */
    static /* bridge */ /* synthetic */ CallingAppInfo m3280$$Nest$mconstructCallingAppInfo(CredentialManagerService r0, String r1, int r2, String r3) {
        return r0.constructCallingAppInfo(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$menforceCallingPackage, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3281$$Nest$menforceCallingPackage(CredentialManagerService r0, String r1, int r2) {
        r0.enforceCallingPackage(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$menforcePermissionForAllowedProviders, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3282$$Nest$menforcePermissionForAllowedProviders(CredentialManagerService r0, GetCredentialRequest r1) {
        r0.enforcePermissionForAllowedProviders(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetFilteredResultFromRegistry, reason: not valid java name */
    static /* bridge */ /* synthetic */ Set m3283$$Nest$mgetFilteredResultFromRegistry(CredentialManagerService r0, List r1) {
        return r0.getFilteredResultFromRegistry(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mhasWriteSecureSettingsPermission, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m3284$$Nest$mhasWriteSecureSettingsPermission(CredentialManagerService r0) {
        return r0.hasWriteSecureSettingsPermission();
    }

    /* JADX INFO: renamed from: -$$Nest$minitiateProviderSessions, reason: not valid java name */
    static /* bridge */ /* synthetic */ List m3285$$Nest$minitiateProviderSessions(CredentialManagerService r0, RequestSession r1, List r2) {
        return r0.initiateProviderSessions(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$minitiateProviderSessionsWithActiveContainers, reason: not valid java name */
    static /* bridge */ /* synthetic */ List m3286$$Nest$minitiateProviderSessionsWithActiveContainers(CredentialManagerService r0, GetRequestSession r1, Set r2) {
        return r0.initiateProviderSessionsWithActiveContainers(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mvalidateGetCredentialRequest, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3287$$Nest$mvalidateGetCredentialRequest(CredentialManagerService r0, GetCredentialRequest r1) {
        r0.validateGetCredentialRequest(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mverifyGetProvidersPermission, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3288$$Nest$mverifyGetProvidersPermission(CredentialManagerService r0) {
        r0.verifyGetProvidersPermission();
    }

    static /* synthetic */ Object access$000(CredentialManagerService x0) {
        return x0.mLock;
    }

    static /* synthetic */ Object access$100(CredentialManagerService x0) {
        return x0.mLock;
    }

    static /* synthetic */ Object access$200(CredentialManagerService x0) {
        return x0.mLock;
    }

    static /* synthetic */ Object access$300(CredentialManagerService x0) {
        return x0.mLock;
    }

    static /* synthetic */ Object access$400(CredentialManagerService x0) {
        return x0.mLock;
    }

    @Override // com.android.server.infra.AbstractMasterSystemService
    protected /* bridge */ /* synthetic */ AbstractPerUserSystemService newServiceLocked(int r1, boolean r2) {
        return newServiceLocked(r1, r2);
    }

    public CredentialManagerService(Context context) {
        super(context, new SecureSettingsServiceNameResolver(context, "credential_service", true), null, 4);
        this.mSystemServicesCacheList = new SparseArray();
        this.mRequestSessions = new SparseArray();
        this.mSessionManager = new SessionManager(this, null);
        this.mContext = context;
    }

    private List<CredentialManagerServiceImpl> constructSystemServiceListLocked(final int resolvedUserId) {
        final List<CredentialManagerServiceImpl> services = new ArrayList();
        List<CredentialProviderInfo> serviceInfos = CredentialProviderInfoFactory.getAvailableSystemServices(this.mContext, resolvedUserId, false, new HashSet());
        serviceInfos.forEach(new CredentialManagerService$$ExternalSyntheticLambda0(this, services, resolvedUserId));
        return services;
    }

    private /* synthetic */ void lambda$constructSystemServiceListLocked$0(List services, int resolvedUserId, CredentialProviderInfo info) {
        services.add(new CredentialManagerServiceImpl(this, this.mLock, resolvedUserId, info));
    }

    @Override // com.android.server.infra.AbstractMasterSystemService
    protected String getServiceSettingsProperty() {
        return "credential_service";
    }

    @Override // com.android.server.infra.AbstractMasterSystemService
    protected CredentialManagerServiceImpl newServiceLocked(int resolvedUserId, boolean disabled) {
        Slog.w(TAG, "Should not be here - CredentialManagerService is configured to use multiple services");
        return null;
    }

    @Override // com.android.server.SystemService
    public void onStart() {
        publishBinderService("credential", new CredentialManagerServiceStub(this));
    }

    @Override // com.android.server.infra.AbstractMasterSystemService
    protected List<CredentialManagerServiceImpl> newServiceListLocked(int resolvedUserId, boolean disabled, String[] serviceNames) {
        getOrConstructSystemServiceListLock(resolvedUserId);
        if (serviceNames == null) goto L19;
        if (serviceNames.length == 0) goto L19;
        List<CredentialManagerServiceImpl> serviceList = new ArrayList(serviceNames.length);
        int r1 = serviceNames.length;
        int r2 = 0;
    L8:
        if (r2 >= r1) goto L17;
        String serviceName = serviceNames[r2];
        if (TextUtils.isEmpty(serviceName) == true) goto L16;
        serviceList.add(new CredentialManagerServiceImpl(this, this.mLock, resolvedUserId, serviceName));     // Catch: Throwable -> L14
    L14:
        e = move-exception;
        Slog.e(TAG, "Unable to add serviceInfo : ", e);
    L16:
        r2 = r2 + 1;
        goto L8
    L17:
        return serviceList;
    L19:
        return new ArrayList();
    }

    @Override // com.android.server.infra.AbstractMasterSystemService
    protected void handlePackageRemovedMultiModeLocked(String packageName, int userId) {
        updateProvidersWhenPackageRemoved(new SettingsWrapper(this.mContext), packageName, userId);
        List<CredentialManagerServiceImpl> services = peekServiceListForUserLocked(userId);
        if (services != null) goto L5;
        return;
    L5:
        List<CredentialManagerServiceImpl> servicesToBeRemoved = new ArrayList();
        Iterator<CredentialManagerServiceImpl> r2 = services.iterator();
    L7:
        if (r2.hasNext() == false) goto L14;
        CredentialManagerServiceImpl service = r2.next();
        if (service == null) goto L7;
        CredentialProviderInfo credentialProviderInfo = service.getCredentialProviderInfo();
        ComponentName componentName = credentialProviderInfo.getServiceInfo().getComponentName();
        if (packageName.equals(componentName.getPackageName()) == false) goto L7;
        servicesToBeRemoved.add(service);
        goto L7
    L14:
        Iterator<CredentialManagerServiceImpl> r3 = servicesToBeRemoved.iterator();
    L16:
        if (r3.hasNext() == false) goto L18;
        CredentialManagerServiceImpl serviceToBeRemoved = r3.next();
        removeServiceFromCache(serviceToBeRemoved, userId);
        removeServiceFromSystemServicesCache(serviceToBeRemoved, userId);
        CredentialDescriptionRegistry.forUser(userId).evictProviderWithPackageName(serviceToBeRemoved.getServicePackageName());
        goto L16
    }

    @Override // com.android.server.infra.AbstractMasterSystemService
    protected void handleServiceRemovedMultiModeLocked(ComponentName componentName, int userId) {
        updateProvidersWhenServiceRemoved(new SettingsWrapper(this.mContext), componentName, userId);
        List<CredentialManagerServiceImpl> services = peekServiceListForUserLocked(userId);
        if (services != null) goto L5;
        return;
    L5:
        List<CredentialManagerServiceImpl> servicesToBeRemoved = new ArrayList();
        Iterator<CredentialManagerServiceImpl> r2 = services.iterator();
    L7:
        if (r2.hasNext() == false) goto L16;
        CredentialManagerServiceImpl service = r2.next();
        if (service == null) goto L7;
        CredentialProviderInfo credentialProviderInfo = service.getCredentialProviderInfo();
        ComponentName serviceComponentName = credentialProviderInfo.getServiceInfo().getComponentName();
        if (serviceComponentName == null) goto L7;
        if (serviceComponentName.equals(componentName) == false) goto L7;
        servicesToBeRemoved.add(service);
        goto L7
    L16:
        removeServicesLocked(servicesToBeRemoved, userId);
    }

    private void removeServicesLocked(List<CredentialManagerServiceImpl> servicesToBeRemoved, int userId) {
        Iterator<CredentialManagerServiceImpl> r0 = servicesToBeRemoved.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        CredentialManagerServiceImpl serviceToBeRemoved = r0.next();
        removeServiceFromCache(serviceToBeRemoved, userId);
        removeServiceFromSystemServicesCache(serviceToBeRemoved, userId);
        CredentialDescriptionRegistry.forUser(userId).evictProviderWithPackageName(serviceToBeRemoved.getServicePackageName());
        goto L4
    }

    private void removeServiceFromSystemServicesCache(CredentialManagerServiceImpl serviceToBeRemoved, int userId) {
        if (this.mSystemServicesCacheList.get(userId) == null) goto L6;
        this.mSystemServicesCacheList.get(userId).remove(serviceToBeRemoved);
        return;
    }

    private List<CredentialManagerServiceImpl> getOrConstructSystemServiceListLock(int resolvedUserId) {
        List<CredentialManagerServiceImpl> services = this.mSystemServicesCacheList.get(resolvedUserId);
        if (services != null) goto L5;
    L6:
        List<CredentialManagerServiceImpl> services2 = constructSystemServiceListLocked(resolvedUserId);
        this.mSystemServicesCacheList.put(resolvedUserId, services2);
        return services2;
    L5:
        if (services.size() == 0) goto L6;
        return services;
    }

    private boolean hasWriteSecureSettingsPermission() {
        return hasPermission("android.permission.WRITE_SECURE_SETTINGS");
    }

    private void verifyGetProvidersPermission() throws SecurityException {
        if (hasPermission("android.permission.QUERY_ALL_PACKAGES") == false) goto L6;
        return;
    L6:
        if (hasPermission("android.permission.LIST_ENABLED_CREDENTIAL_PROVIDERS") == false) goto L9;
        return;
    L9:
        throw new SecurityException("Caller is missing permission: QUERY_ALL_PACKAGES or LIST_ENABLED_CREDENTIAL_PROVIDERS");
    }

    private boolean hasPermission(String permission) {
        if (this.mContext.checkCallingOrSelfPermission(permission) != 0) goto L5;
        boolean result = true;
    L6:
        if (result == true) goto L8;
        Slog.e(TAG, "Caller does not have permission: " + permission);
    L8:
        return result;
    L5:
        result = false;
        goto L6
    }

    private void runForUser(Consumer<CredentialManagerServiceImpl> c) {
        int userId = UserHandle.getCallingUserId();
        long origId = Binder.clearCallingIdentity();
        Object r3 = this.mLock;     // Catch: Throwable -> L16
        monitor-enter(r3);     // Catch: Throwable -> L16
        List<CredentialManagerServiceImpl> services = getCredentialProviderServicesLocked(userId);     // Catch: Throwable -> L9
        Iterator<CredentialManagerServiceImpl> r5 = services.iterator();     // Catch: Throwable -> L9
    L7:
        if (r5.hasNext() == false) goto L11;
        CredentialManagerServiceImpl s = r5.next();     // Catch: Throwable -> L9
        c.accept(s);     // Catch: Throwable -> L9
        goto L7
    L11:
        monitor-exit(r3);     // Catch: Throwable -> L9
        Binder.restoreCallingIdentity(origId);
        return;
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        Binder.restoreCallingIdentity(origId);
        throw th;
    }

    static Set<ComponentName> getPrimaryProvidersForUserId(Context context, int userId) {
        int resolvedUserId = ActivityManager.handleIncomingUser(Binder.getCallingPid(), Binder.getCallingUid(), userId, false, false, "getPrimaryProvidersForUserId", null);
        SecureSettingsServiceNameResolver resolver = new SecureSettingsServiceNameResolver(context, "credential_service_primary", true);
        String[] serviceNames = resolver.readServiceNameList(resolvedUserId);
        if (serviceNames == null) goto L5;
        Set<ComponentName> services = new HashSet();
        int r4 = serviceNames.length;
        int r5 = 0;
    L7:
        if (r5 >= r4) goto L13;
        String serviceName = serviceNames[r5];
        ComponentName compName = ComponentName.unflattenFromString(serviceName);
        if (compName != null) goto L11;
        Slog.w(TAG, "Primary provider component name unflatten from string error: " + serviceName);
    L12:
        r5 = r5 + 1;
        goto L7
    L11:
        services.add(compName);
        goto L12
    L13:
        return services;
    L5:
        return new HashSet();
    }

    private List<CredentialManagerServiceImpl> getCredentialProviderServicesLocked(int userId) {
        List<CredentialManagerServiceImpl> concatenatedServices = new ArrayList();
        List<CredentialManagerServiceImpl> userConfigurableServices = getServiceListForUserLocked(userId);
        if (userConfigurableServices != null) goto L5;
    L7:
        concatenatedServices.addAll(getOrConstructSystemServiceListLock(userId));
        return concatenatedServices;
    L5:
        if (userConfigurableServices.isEmpty() == true) goto L7;
        concatenatedServices.addAll(userConfigurableServices);
        goto L7
    }

    public static boolean isCredentialDescriptionApiEnabled() {
        long origId = Binder.clearCallingIdentity();
        boolean r2 = DeviceConfig.getBoolean("credential_manager", DEVICE_CONFIG_ENABLE_CREDENTIAL_DESC_API, false);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(origId);
        return r2;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(origId);
        throw th;
    }

    private List<ProviderSession> initiateProviderSessionsWithActiveContainers(GetRequestSession session, Set<Pair<CredentialOption, CredentialDescriptionRegistry.FilterResult>> activeCredentialContainers) {
        List<ProviderSession> providerSessions = new ArrayList();
        Iterator<Pair<CredentialOption, CredentialDescriptionRegistry.FilterResult>> r1 = activeCredentialContainers.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        Pair<CredentialOption, CredentialDescriptionRegistry.FilterResult> result = r1.next();
        Context r3 = this.mContext;
        int r4 = UserHandle.getCallingUserId();
        CallingAppInfo r6 = session.mClientAppInfo;
        String r7 = ((CredentialDescriptionRegistry.FilterResult) result.second).mPackageName;
        CredentialOption r8 = (CredentialOption) result.first;
        GetRequestSession session2 = session;
        ProviderSession providerSession = ProviderRegistryGetSession.createNewSession(r3, r4, session2, r6, r7, r8);
        providerSessions.add(providerSession);
        session2.addProviderSession(providerSession.getComponentName(), providerSession);
        session = session2;
        goto L4
    L6:
        return providerSessions;
    }

    private List<ProviderSession> initiateProviderSessionsWithActiveContainers(PrepareGetRequestSession session, Set<Pair<CredentialOption, CredentialDescriptionRegistry.FilterResult>> activeCredentialContainers) {
        List<ProviderSession> providerSessions = new ArrayList();
        Iterator<Pair<CredentialOption, CredentialDescriptionRegistry.FilterResult>> r1 = activeCredentialContainers.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        Pair<CredentialOption, CredentialDescriptionRegistry.FilterResult> result = r1.next();
        Context r3 = this.mContext;
        int r4 = UserHandle.getCallingUserId();
        CallingAppInfo r6 = session.mClientAppInfo;
        String r7 = ((CredentialDescriptionRegistry.FilterResult) result.second).mPackageName;
        CredentialOption r8 = (CredentialOption) result.first;
        PrepareGetRequestSession session2 = session;
        ProviderSession providerSession = ProviderRegistryGetSession.createNewSession(r3, r4, session2, r6, r7, r8);
        providerSessions.add(providerSession);
        session2.addProviderSession(providerSession.getComponentName(), providerSession);
        session = session2;
        goto L4
    L6:
        return providerSessions;
    }

    private Set<Pair<CredentialOption, CredentialDescriptionRegistry.FilterResult>> getFilteredResultFromRegistry(List<CredentialOption> options) {
        CredentialDescriptionRegistry registry = CredentialDescriptionRegistry.forUser(UserHandle.getCallingUserId());
        Set<Set<String>> requestedCredentialDescriptions = (Set) options.stream().map(new CredentialManagerService$$ExternalSyntheticLambda2()).collect(Collectors.toSet());
        Set<CredentialDescriptionRegistry.FilterResult> filterResults = registry.getMatchingProviders(requestedCredentialDescriptions);
        Set<Pair<CredentialOption, CredentialDescriptionRegistry.FilterResult>> result = new HashSet();
        Iterator<CredentialDescriptionRegistry.FilterResult> r4 = filterResults.iterator();
    L4:
        if (r4.hasNext() == false) goto L13;
        CredentialDescriptionRegistry.FilterResult filterResult = r4.next();
        Iterator<CredentialOption> r6 = options.iterator();
    L7:
        if (r6.hasNext() == false) goto L4;
        CredentialOption credentialOption = r6.next();
        Set<String> requestedElementKeys = new HashSet(credentialOption.getCredentialRetrievalData().getStringArrayList("android.credentials.GetCredentialOption.SUPPORTED_ELEMENT_KEYS"));
        if (CredentialDescriptionRegistry.checkForMatch(filterResult.mElementKeys, requestedElementKeys) == false) goto L7;
        result.add(new Pair(credentialOption, filterResult));
        goto L7
    L13:
        return result;
    }

    private static /* synthetic */ HashSet lambda$getFilteredResultFromRegistry$1(CredentialOption getCredentialOption) {
        return new HashSet(getCredentialOption.getCredentialRetrievalData().getStringArrayList("android.credentials.GetCredentialOption.SUPPORTED_ELEMENT_KEYS"));
    }

    private List<ProviderSession> initiateProviderSessions(final RequestSession session, final List<String> requestOptions) {
        final List<ProviderSession> providerSessions = new ArrayList();
        runForUser(new CredentialManagerService$$ExternalSyntheticLambda1(this, session, requestOptions, providerSessions));
        return providerSessions;
    }

    private /* synthetic */ void lambda$initiateProviderSessions$2(RequestSession session, List requestOptions, List providerSessions, CredentialManagerServiceImpl service) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        ProviderSession providerSession = service.initiateProviderSessionForRequestLocked(session, requestOptions);     // Catch: Throwable -> L7
        if (providerSession == null) goto L9;
        providerSessions.add(providerSession);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.infra.AbstractMasterSystemService, com.android.server.SystemService
    public void onUserStopped(SystemService.TargetUser user) {
        super.onUserStopped(user);
        CredentialDescriptionRegistry.clearUserSession(user.getUserIdentifier());
    }

    private CallingAppInfo constructCallingAppInfo(String realPackageName, int userId, String origin) {
        PackageInfo packageInfo = getContext().getPackageManager().getPackageInfoAsUser(realPackageName, PackageManager.PackageInfoFlags.of(134217728), userId);     // Catch: PackageManager.NameNotFoundException -> L4
        CallingAppInfo callingAppInfo = new CallingAppInfo(realPackageName, packageInfo.signingInfo, origin);     // Catch: PackageManager.NameNotFoundException -> L4
        return callingAppInfo;
    L4:
        e = move-exception;
        Slog.e(TAG, "Issue while retrieving signatureInfo : ", e);
        CallingAppInfo callingAppInfo2 = new CallingAppInfo(realPackageName, null, origin);
        return callingAppInfo2;
    }

    private void validateGetCredentialRequest(GetCredentialRequest request) {
        if (request.getOrigin() == null) goto L5;
        this.mContext.enforceCallingPermission("android.permission.CREDENTIAL_MANAGER_SET_ORIGIN", null);
    L5:
        enforcePermissionForAllowedProviders(request);
    }

    private void enforcePermissionForAllowedProviders(GetCredentialRequest request) {
        boolean containsAllowedProviders = request.getCredentialOptions().stream().anyMatch(new CredentialManagerService$$ExternalSyntheticLambda3());
        if (containsAllowedProviders == false) goto L6;
        this.mContext.enforceCallingPermission("android.permission.CREDENTIAL_MANAGER_SET_ALLOWED_PROVIDERS", null);
        return;
    }

    private static /* synthetic */ boolean lambda$enforcePermissionForAllowedProviders$3(CredentialOption option) {
        if (option.getAllowedProviders() != null) goto L5;
    L7:
        return false;
    L5:
        if (option.getAllowedProviders().isEmpty() == true) goto L7;
        return true;
    }

    private void addSessionLocked(int userId, RequestSession requestSession) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mSessionManager.addSession(userId, requestSession.mRequestId, requestSession);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void enforceCallingPackage(String callingPackage, int callingUid) {
        PackageManager pm = this.mContext.createContextAsUser(UserHandle.getUserHandleForUid(callingUid), 0).getPackageManager();
        int packageUid = pm.getPackageUid(callingPackage, PackageManager.PackageInfoFlags.of(0));     // Catch: PackageManager.NameNotFoundException -> L8
        if (packageUid != callingUid) goto L7;
        return;
    L7:
        throw new SecurityException(callingPackage + " does not belong to uid " + callingUid);
    L10:
        throw new SecurityException(callingPackage + " not found");
    }

    public static void updateProvidersWhenServiceRemoved(SettingsWrapper settingsWrapper, ComponentName componentName, int userId) {
        Slog.i(TAG, "updateProvidersWhenServiceRemoved for: " + componentName.flattenToString());
        String rawPrimaryProviders = settingsWrapper.getStringForUser("credential_service_primary", userId);
        if (TextUtils.isEmpty(rawPrimaryProviders) == false) goto L5;
        Slog.w(TAG, "primary settings key is null");
    L17:
        String rawCredentialProviders = settingsWrapper.getStringForUser("credential_service", userId);
        Set<String> filteredCredentialProviders = getStoredProvidersExceptService(rawCredentialProviders, componentName);
        if (settingsWrapper.putStringForUser("credential_service", String.join(":", filteredCredentialProviders), userId, true) == true) goto L21;
        Slog.e(TAG, "Failed to remove secondary service: " + componentName);
        return;
    L21:
        return;
    L5:
        Set<String> filteredPrimaryProviders = getStoredProvidersExceptService(rawPrimaryProviders, componentName);
        if (filteredPrimaryProviders.isEmpty() == false) goto L14;
        if (isAutofillProviderPresent(settingsWrapper, userId) == true) goto L14;
        Slog.d(TAG, "Clearing all credential providers");
        if (clearAllCredentialProviders(settingsWrapper, userId) == false) goto L12;
        return;
    L12:
        Slog.e(TAG, "Failed to clear all credential providers");
    L14:
        if (settingsWrapper.putStringForUser("credential_service_primary", String.join(":", filteredPrimaryProviders), userId, true) == true) goto L17;
        Slog.e(TAG, "Failed to remove primary service: " + componentName);
    }

    private static boolean isAutofillProviderPresent(SettingsWrapper settingsWrapper, int userId) {
        String autofillProvider = settingsWrapper.getStringForUser("autofill_service", userId);
        if (autofillProvider != null) goto L5;
    L9:
        return false;
    L5:
        if (autofillProvider.isEmpty() == true) goto L9;
        if (isPlaceholderAutofillProvider(autofillProvider, settingsWrapper) == true) goto L9;
        return true;
    }

    private static boolean isPlaceholderAutofillProvider(String autofillProvider, SettingsWrapper settingsWrapper) {
        String credentialAutofillService = SettingsWrapper.m3290$$Nest$fgetmContext(settingsWrapper).getResources().getString(R.string.config_dozeLongPressSensorType);
        if (autofillProvider != null) goto L5;
    L7:
        return false;
    L5:
        if (TextUtils.equals(autofillProvider, credentialAutofillService) == false) goto L7;
        return true;
    }

    private static boolean clearAllCredentialProviders(SettingsWrapper settingsWrapper, int userId) {
        if (settingsWrapper.putStringForUser("credential_service_primary", null, userId, true) == true) goto L7;
        return false;
    L7:
        return settingsWrapper.putStringForUser("credential_service", null, userId, true);
    }

    public static void updateProvidersWhenPackageRemoved(SettingsWrapper settingsWrapper, String packageName, int userId) {
        Slog.i(TAG, "updateProvidersWhenPackageRemoved");
        String rawProviders = settingsWrapper.getStringForUser("credential_service_primary", userId);
        if (rawProviders != null) goto L5;
        Slog.w(TAG, "settings key is null");
    L30:
        String rawCredentialProviders = settingsWrapper.getStringForUser("credential_service", userId);
        Set<String> credentialProviders = getStoredProvidersExceptPackage(rawCredentialProviders, packageName);
        if (settingsWrapper.putStringForUser("credential_service", String.join(":", credentialProviders), userId, true) == true) goto L34;
        Slog.e(TAG, "Failed to remove secondary package: " + packageName);
        return;
    L34:
        return;
    L5:
        Set<String> primaryProviders = getStoredProvidersExceptPackage(rawProviders, packageName);
        if (settingsWrapper.putStringForUser("credential_service_primary", String.join(":", primaryProviders), userId, true) == true) goto L9;
        Slog.e(TAG, "Failed to remove primary package: " + packageName);
        return;
    L9:
        String autofillProvider = settingsWrapper.getStringForUser("autofill_service", userId);
        String credentialAutofillService = SettingsWrapper.m3290$$Nest$fgetmContext(settingsWrapper).getResources().getString(R.string.config_dozeLongPressSensorType);
        if (autofillProvider == null) goto L23;
        if (primaryProviders.isEmpty() == false) goto L23;
        if (TextUtils.equals(autofillProvider, credentialAutofillService) == true) goto L23;
        ComponentName cn = ComponentName.unflattenFromString(autofillProvider);
        if (cn == null) goto L23;
        if (cn.getPackageName().equals(packageName) == false) goto L23;
        if (settingsWrapper.putStringForUser("autofill_service", "", userId, true) == true) goto L23;
        Slog.e(TAG, "Failed to remove autofill package: " + packageName);
    L23:
        if (primaryProviders.isEmpty() == false) goto L30;
        if (isAutofillProviderPresent(settingsWrapper, userId) == true) goto L30;
        Slog.d(TAG, "Clearing all credential providers");
        if (clearAllCredentialProviders(settingsWrapper, userId) == false) goto L29;
        return;
    L29:
        Slog.e(TAG, "Failed to clear all credential providers");
        goto L30
    }

    public static Set<String> getStoredProvidersExceptService(String rawProviders, ComponentName componentName) {
        Set<String> providers = new HashSet();
        if (rawProviders == null) goto L21;
        if (componentName == null) goto L21;
        String[] r1 = rawProviders.split(":");
        int r2 = r1.length;
        int r3 = 0;
    L7:
        if (r3 >= r2) goto L20;
        String rawComponentName = r1[r3];
        if (TextUtils.isEmpty(rawComponentName) == false) goto L11;
    L18:
        Slog.d(TAG, "provider component name is empty or null");
    L19:
        r3 = r3 + 1;
        goto L7
    L11:
        if (rawComponentName.equals("null") == true) goto L18;
        ComponentName cn = ComponentName.unflattenFromString(rawComponentName);
        if (cn == null) goto L19;
        if (cn.equals(componentName) == true) goto L19;
        providers.add(cn.flattenToString());
        goto L19
    L20:
        return providers;
    L21:
        return providers;
    }

    public static Set<String> getStoredProvidersExceptPackage(String rawProviders, String packageName) {
        Set<String> providers = new HashSet();
        if (rawProviders == null) goto L21;
        if (packageName == null) goto L21;
        String[] r1 = rawProviders.split(":");
        int r2 = r1.length;
        int r3 = 0;
    L7:
        if (r3 >= r2) goto L20;
        String rawComponentName = r1[r3];
        if (TextUtils.isEmpty(rawComponentName) == false) goto L11;
    L18:
        Slog.d(TAG, "provider component name is empty or null");
    L19:
        r3 = r3 + 1;
        goto L7
    L11:
        if (rawComponentName.equals("null") == true) goto L18;
        ComponentName cn = ComponentName.unflattenFromString(rawComponentName);
        if (cn == null) goto L19;
        if (cn.getPackageName().equals(packageName) == true) goto L19;
        providers.add(cn.flattenToString());
        goto L19
    L20:
        return providers;
    L21:
        return providers;
    }
}
