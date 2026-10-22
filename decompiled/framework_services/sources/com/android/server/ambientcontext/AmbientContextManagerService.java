package com.android.server.ambientcontext;

import android.R;
import android.app.PendingIntent;
import android.app.ambientcontext.AmbientContextEventRequest;
import android.app.ambientcontext.IAmbientContextManager;
import android.app.ambientcontext.IAmbientContextObserver;
import android.content.ComponentName;
import android.content.Context;
import android.os.RemoteCallback;
import android.os.ResultReceiver;
import android.os.ShellCallback;
import android.os.UserHandle;
import android.provider.DeviceConfig;
import android.util.ArraySet;
import android.util.Slog;
import com.android.internal.util.DumpUtils;
import com.android.server.infra.AbstractMasterSystemService;
import com.android.server.infra.AbstractPerUserSystemService;
import com.android.server.infra.FrameworkResourcesServiceNameResolver;
import com.google.android.collect.Sets;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class AmbientContextManagerService extends AbstractMasterSystemService<AmbientContextManagerService, AmbientContextManagerPerUserService> {
    private static final Set<Integer> DEFAULT_EVENT_SET = null;
    private static final boolean DEFAULT_SERVICE_ENABLED = true;
    private static final String KEY_SERVICE_ENABLED = "service_enabled";
    public static final int MAX_TEMPORARY_SERVICE_DURATION_MS = 30000;
    private static final String TAG = null;
    private final Context mContext;
    private Set<ClientRequest> mExistingClientRequests;
    boolean mIsServiceEnabled;
    boolean mIsWearableServiceEnabled;

    private final class AmbientContextManagerInternal extends IAmbientContextManager.Stub {
        final /* synthetic */ AmbientContextManagerService this$0;

        /* synthetic */ AmbientContextManagerInternal(AmbientContextManagerService r1, AmbientContextManagerServiceIA r2) {
            this(r1);
        }

        private AmbientContextManagerInternal(AmbientContextManagerService r1) {
            this.this$0 = r1;
        }

        public void registerObserver(AmbientContextEventRequest request, final PendingIntent resultPendingIntent, final RemoteCallback statusCallback) {
            request.getClass();
            resultPendingIntent.getClass();
            statusCallback.getClass();
            final AmbientContextManagerPerUserService service = AmbientContextManagerService.m1607$$Nest$mgetAmbientContextManagerPerUserServiceForEventTypes(this.this$0, UserHandle.getCallingUserId(), request.getEventTypes());
            IAmbientContextObserver.Stub r1 = new AnonymousClass1(this, service, resultPendingIntent, statusCallback);
            registerObserverWithCallback(request, resultPendingIntent.getCreatorPackage(), r1);
        }

        public void registerObserverWithCallback(AmbientContextEventRequest request, String packageName, IAmbientContextObserver observer) {
            Slog.i(AmbientContextManagerService.m1609$$Nest$sfgetTAG(), "AmbientContextManagerService registerObserverWithCallback.");
            request.getClass();
            packageName.getClass();
            observer.getClass();
            AmbientContextManagerService.m1604$$Nest$fgetmContext(this.this$0).enforceCallingOrSelfPermission("android.permission.ACCESS_AMBIENT_CONTEXT_EVENT", AmbientContextManagerService.m1609$$Nest$sfgetTAG());
            AmbientContextManagerService.access$000(this.this$0, packageName);
            AmbientContextManagerPerUserService service = AmbientContextManagerService.m1607$$Nest$mgetAmbientContextManagerPerUserServiceForEventTypes(this.this$0, UserHandle.getCallingUserId(), request.getEventTypes());
            if (service != null) goto L6;
            Slog.w(AmbientContextManagerService.m1609$$Nest$sfgetTAG(), "onRegisterObserver unavailable user_id: " + UserHandle.getCallingUserId());
            return;
        L6:
            int statusCode = checkStatusCode(service, AmbientContextManagerService.m1610$$Nest$smintegerSetToIntArray(request.getEventTypes()));
            if (statusCode != 1) goto L9;
            service.onRegisterObserver(request, packageName, observer);
            return;
        L9:
            service.completeRegistration(observer, statusCode);
        }

        public void unregisterObserver(String callingPackage) {
            unregisterObserver_enforcePermission();
            AmbientContextManagerService.access$100(this.this$0, callingPackage);
            Object r0 = AmbientContextManagerService.access$200(this.this$0);
            monitor-enter(r0);
            Iterator r1 = AmbientContextManagerService.m1605$$Nest$fgetmExistingClientRequests(this.this$0).iterator();     // Catch: Throwable -> L14
        L6:
            if (r1.hasNext() == false) goto L18;
            ClientRequest cr = (ClientRequest) r1.next();     // Catch: Throwable -> L14
            if (cr == null) goto L6;
            if (cr.getPackageName().equals(callingPackage) == false) goto L6;
            AmbientContextManagerPerUserService service = AmbientContextManagerService.m1607$$Nest$mgetAmbientContextManagerPerUserServiceForEventTypes(this.this$0, UserHandle.getCallingUserId(), cr.getRequest().getEventTypes());     // Catch: Throwable -> L14
            if (service == null) goto L16;
            service.onUnregisterObserver(callingPackage);     // Catch: Throwable -> L14
            goto L6
        L16:
            Slog.w(AmbientContextManagerService.m1609$$Nest$sfgetTAG(), "onUnregisterObserver unavailable user_id: " + UserHandle.getCallingUserId());     // Catch: Throwable -> L14
            goto L6
        L18:
            monitor-exit(r0);     // Catch: Throwable -> L14
            return;
        L14:
            th = move-exception;
            throw th;
        }

        public void queryServiceStatus(int[] eventTypes, String callingPackage, RemoteCallback statusCallback) {
            eventTypes.getClass();
            callingPackage.getClass();
            statusCallback.getClass();
            AmbientContextManagerService.m1604$$Nest$fgetmContext(this.this$0).enforceCallingOrSelfPermission("android.permission.ACCESS_AMBIENT_CONTEXT_EVENT", AmbientContextManagerService.m1609$$Nest$sfgetTAG());
            AmbientContextManagerService.access$300(this.this$0, callingPackage);
            Object r0 = AmbientContextManagerService.access$400(this.this$0);
            monitor-enter(r0);
            AmbientContextManagerPerUserService service = AmbientContextManagerService.m1607$$Nest$mgetAmbientContextManagerPerUserServiceForEventTypes(this.this$0, UserHandle.getCallingUserId(), AmbientContextManagerService.m1608$$Nest$mintArrayToIntegerSet(this.this$0, eventTypes));     // Catch: Throwable -> L9
            if (service != null) goto L11;
            Slog.w(AmbientContextManagerService.m1609$$Nest$sfgetTAG(), "queryServiceStatus unavailable user_id: " + UserHandle.getCallingUserId());     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L11:
            int statusCode = checkStatusCode(service, eventTypes);     // Catch: Throwable -> L9
            if (statusCode != 1) goto L14;
            service.onQueryServiceStatus(eventTypes, callingPackage, statusCallback);     // Catch: Throwable -> L9
        L15:
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L14:
            service.sendStatusCallback(statusCallback, statusCode);     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            throw th;
        }

        public void startConsentActivity(int[] eventTypes, String callingPackage) {
            eventTypes.getClass();
            callingPackage.getClass();
            AmbientContextManagerService.access$500(this.this$0, callingPackage);
            AmbientContextManagerService.m1604$$Nest$fgetmContext(this.this$0).enforceCallingOrSelfPermission("android.permission.ACCESS_AMBIENT_CONTEXT_EVENT", AmbientContextManagerService.m1609$$Nest$sfgetTAG());
            if (AmbientContextManagerService.m1606$$Nest$mcontainsMixedEvents(this.this$0, eventTypes) == false) goto L6;
            Slog.d(AmbientContextManagerService.m1609$$Nest$sfgetTAG(), "AmbientContextEventRequest contains mixed events, this is not supported.");
            return;
        L6:
            AmbientContextManagerPerUserService service = AmbientContextManagerService.m1607$$Nest$mgetAmbientContextManagerPerUserServiceForEventTypes(this.this$0, UserHandle.getCallingUserId(), AmbientContextManagerService.m1608$$Nest$mintArrayToIntegerSet(this.this$0, eventTypes));
            if (service == null) goto L9;
            service.onStartConsentActivity(eventTypes, callingPackage);
            return;
        L9:
            Slog.w(AmbientContextManagerService.m1609$$Nest$sfgetTAG(), "startConsentActivity unavailable user_id: " + UserHandle.getCallingUserId());
        }

        protected void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
            if (DumpUtils.checkDumpPermission(AmbientContextManagerService.m1604$$Nest$fgetmContext(this.this$0), AmbientContextManagerService.m1609$$Nest$sfgetTAG(), pw) == true) goto L5;
            return;
        L5:
            Object r0 = AmbientContextManagerService.access$600(this.this$0);
            monitor-enter(r0);
            AmbientContextManagerService.access$700(this.this$0, "", pw);     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            throw th;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void onShellCommand(FileDescriptor in, FileDescriptor out, FileDescriptor err, String[] args, ShellCallback callback, ResultReceiver resultReceiver) {
            new AmbientContextShellCommand(this.this$0).exec(this, in, out, err, args, callback, resultReceiver);
        }

        private int checkStatusCode(AmbientContextManagerPerUserService service, int[] eventTypes) {
            if (service.getServiceType() != AmbientContextManagerPerUserService.ServiceType.DEFAULT) goto L9;
            if (this.this$0.mIsServiceEnabled == true) goto L9;
            Slog.d(AmbientContextManagerService.m1609$$Nest$sfgetTAG(), "Service not enabled.");
            return 3;
        L9:
            if (service.getServiceType() != AmbientContextManagerPerUserService.ServiceType.WEARABLE) goto L15;
            if (this.this$0.mIsWearableServiceEnabled == true) goto L15;
            Slog.d(AmbientContextManagerService.m1609$$Nest$sfgetTAG(), "Wearable Service not available.");
            return 3;
        L15:
            if (AmbientContextManagerService.m1606$$Nest$mcontainsMixedEvents(this.this$0, eventTypes) == false) goto L18;
            Slog.d(AmbientContextManagerService.m1609$$Nest$sfgetTAG(), "AmbientContextEventRequest contains mixed events, this is not supported.");
            return 2;
        L18:
            return 1;
        }
    }

    static class ClientRequest {
        private final IAmbientContextObserver mObserver;
        private final String mPackageName;
        private final AmbientContextEventRequest mRequest;
        private final int mUserId;

        ClientRequest(int userId, AmbientContextEventRequest request, String packageName, IAmbientContextObserver observer) {
            this.mUserId = userId;
            this.mRequest = request;
            this.mPackageName = packageName;
            this.mObserver = observer;
        }

        String getPackageName() {
            return this.mPackageName;
        }

        AmbientContextEventRequest getRequest() {
            return this.mRequest;
        }

        IAmbientContextObserver getObserver() {
            return this.mObserver;
        }

        boolean hasUserId(int userId) {
            if (this.mUserId != userId) goto L5;
            return true;
        L5:
            return false;
        }

        boolean hasUserIdAndPackageName(int userId, String packageName) {
            if (userId == this.mUserId) goto L5;
        L7:
            return false;
        L5:
            if (packageName.equals(getPackageName()) == false) goto L7;
            return true;
        }
    }

    public static /* synthetic */ void $r8$lambda$YfeCYxhsNwahWPuBOqBX8XeHzX0(AmbientContextManagerService r0, DeviceConfig.Properties r1) {
        r0.lambda$onBootPhase$0(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m1604$$Nest$fgetmContext(AmbientContextManagerService r0) {
        return r0.mContext;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmExistingClientRequests, reason: not valid java name */
    static /* bridge */ /* synthetic */ Set m1605$$Nest$fgetmExistingClientRequests(AmbientContextManagerService r0) {
        return r0.mExistingClientRequests;
    }

    /* JADX INFO: renamed from: -$$Nest$mcontainsMixedEvents, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m1606$$Nest$mcontainsMixedEvents(AmbientContextManagerService r0, int[] r1) {
        return r0.containsMixedEvents(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetAmbientContextManagerPerUserServiceForEventTypes, reason: not valid java name */
    static /* bridge */ /* synthetic */ AmbientContextManagerPerUserService m1607$$Nest$mgetAmbientContextManagerPerUserServiceForEventTypes(AmbientContextManagerService r0, int r1, Set r2) {
        return r0.getAmbientContextManagerPerUserServiceForEventTypes(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mintArrayToIntegerSet, reason: not valid java name */
    static /* bridge */ /* synthetic */ Set m1608$$Nest$mintArrayToIntegerSet(AmbientContextManagerService r0, int[] r1) {
        return r0.intArrayToIntegerSet(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetTAG, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m1609$$Nest$sfgetTAG() {
        return TAG;
    }

    /* JADX INFO: renamed from: -$$Nest$smintegerSetToIntArray, reason: not valid java name */
    static /* bridge */ /* synthetic */ int[] m1610$$Nest$smintegerSetToIntArray(Set r0) {
        return integerSetToIntArray(r0);
    }

    static /* synthetic */ void access$000(AmbientContextManagerService x0, String x1) {
        x0.assertCalledByPackageOwner(x1);
    }

    static /* synthetic */ void access$100(AmbientContextManagerService x0, String x1) {
        x0.assertCalledByPackageOwner(x1);
    }

    static /* synthetic */ Object access$200(AmbientContextManagerService x0) {
        return x0.mLock;
    }

    static /* synthetic */ void access$300(AmbientContextManagerService x0, String x1) {
        x0.assertCalledByPackageOwner(x1);
    }

    static /* synthetic */ Object access$400(AmbientContextManagerService x0) {
        return x0.mLock;
    }

    static /* synthetic */ void access$500(AmbientContextManagerService x0, String x1) {
        x0.assertCalledByPackageOwner(x1);
    }

    static /* synthetic */ Object access$600(AmbientContextManagerService x0) {
        return x0.mLock;
    }

    static /* synthetic */ void access$700(AmbientContextManagerService x0, String x1, PrintWriter x2) {
        x0.dumpLocked(x1, x2);
    }

    @Override // com.android.server.infra.AbstractMasterSystemService
    protected /* bridge */ /* synthetic */ AbstractPerUserSystemService newServiceLocked(int r1, boolean r2) {
        return newServiceLocked(r1, r2);
    }

    @Override // com.android.server.infra.AbstractMasterSystemService
    protected /* bridge */ /* synthetic */ void onServiceRemoved(AbstractPerUserSystemService r1, int r2) {
        onServiceRemoved((AmbientContextManagerPerUserService) r1, r2);
    }

    static {
        TAG = AmbientContextManagerService.class.getSimpleName();
        DEFAULT_EVENT_SET = Sets.newHashSet(new Integer[]{1, 2, 3});
    }

    public AmbientContextManagerService(Context context) {
        super(context, new FrameworkResourcesServiceNameResolver(context, R.array.config_displayCompositionColorModes, true), null, 68);
        this.mContext = context;
        this.mExistingClientRequests = ConcurrentHashMap.newKeySet();
    }

    @Override // com.android.server.SystemService
    public void onStart() {
        publishBinderService("ambient_context", new AmbientContextManagerInternal(this, null));
    }

    @Override // com.android.server.infra.AbstractMasterSystemService, com.android.server.SystemService
    public void onBootPhase(int phase) {
        if (phase != 500) goto L6;
        DeviceConfig.addOnPropertiesChangedListener("ambient_context_manager_service", getContext().getMainExecutor(), new AmbientContextManagerService$$ExternalSyntheticLambda0(this));
        this.mIsServiceEnabled = DeviceConfig.getBoolean("ambient_context_manager_service", KEY_SERVICE_ENABLED, true);
        this.mIsWearableServiceEnabled = DeviceConfig.getBoolean("wearable_sensing", KEY_SERVICE_ENABLED, true);
        return;
    }

    private /* synthetic */ void lambda$onBootPhase$0(DeviceConfig.Properties properties) {
        onDeviceConfigChange(properties.getKeyset());
    }

    void newClientAdded(int userId, AmbientContextEventRequest request, String callingPackage, IAmbientContextObserver observer) {
        Slog.d(TAG, "New client added: " + callingPackage);
        Set<ClientRequest> r0 = this.mExistingClientRequests;
        monitor-enter(r0);
        this.mExistingClientRequests.removeAll(findExistingRequests(userId, callingPackage));     // Catch: Throwable -> L7
        this.mExistingClientRequests.add(new ClientRequest(userId, request, callingPackage, observer));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void clientRemoved(int userId, String packageName) {
        Slog.d(TAG, "Remove client: " + packageName);
        Set<ClientRequest> r0 = this.mExistingClientRequests;
        monitor-enter(r0);
        this.mExistingClientRequests.removeAll(findExistingRequests(userId, packageName));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private Set<ClientRequest> findExistingRequests(int userId, String packageName) {
        Set<ClientRequest> existingRequests = new ArraySet();
        Iterator<ClientRequest> r1 = this.mExistingClientRequests.iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        ClientRequest clientRequest = r1.next();
        if (clientRequest.hasUserIdAndPackageName(userId, packageName) == false) goto L4;
        existingRequests.add(clientRequest);
        goto L4
    L9:
        return existingRequests;
    }

    IAmbientContextObserver getClientRequestObserver(int userId, String packageName) {
        Set<ClientRequest> r0 = this.mExistingClientRequests;
        monitor-enter(r0);
        Iterator<ClientRequest> r1 = this.mExistingClientRequests.iterator();     // Catch: Throwable -> L12
    L6:
        if (r1.hasNext() == false) goto L15;
        ClientRequest clientRequest = r1.next();     // Catch: Throwable -> L12
        if (clientRequest.hasUserIdAndPackageName(userId, packageName) == false) goto L6;
        IAmbientContextObserver r2 = clientRequest.getObserver();     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r2;
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return null;
    L12:
        th = move-exception;
        throw th;
    }

    private void onDeviceConfigChange(Set<String> keys) {
        if (keys.contains(KEY_SERVICE_ENABLED) == false) goto L6;
        this.mIsServiceEnabled = DeviceConfig.getBoolean("ambient_context_manager_service", KEY_SERVICE_ENABLED, true);
        this.mIsWearableServiceEnabled = DeviceConfig.getBoolean("wearable_sensing", KEY_SERVICE_ENABLED, true);
        return;
    }

    @Override // com.android.server.infra.AbstractMasterSystemService
    protected AmbientContextManagerPerUserService newServiceLocked(int resolvedUserId, boolean disabled) {
        return null;
    }

    @Override // com.android.server.infra.AbstractMasterSystemService
    protected List<AmbientContextManagerPerUserService> newServiceListLocked(int resolvedUserId, boolean disabled, String[] serviceNames) {
        if (serviceNames != null) goto L4;
    L25:
        Slog.i(TAG, "serviceNames sent in newServiceListLocked is null, or empty");
        return new ArrayList();
    L4:
        if (serviceNames.length == 0) goto L25;
        List<AmbientContextManagerPerUserService> serviceList = new ArrayList(serviceNames.length);
        if (serviceNames.length != 2) goto L15;
        if (isDefaultService(serviceNames[0]) == true) goto L15;
        if (isDefaultWearableService(serviceNames[1]) == true) goto L15;
        Slog.i(TAG, "Not using default services, services provided for testing should be exactly two services.");
        serviceList.add(new DefaultAmbientContextManagerPerUserService(this, this.mLock, resolvedUserId, AmbientContextManagerPerUserService.ServiceType.DEFAULT, serviceNames[0]));
        serviceList.add(new WearableAmbientContextManagerPerUserService(this, this.mLock, resolvedUserId, AmbientContextManagerPerUserService.ServiceType.WEARABLE, serviceNames[1]));
        return serviceList;
    L15:
        if (serviceNames.length <= 2) goto L17;
        Slog.i(TAG, "Incorrect number of services provided for testing.");
    L17:
        int r7 = serviceNames.length;
        int r8 = 0;
    L18:
        if (r8 >= r7) goto L24;
        String serviceName = serviceNames[r8];
        Slog.d(TAG, "newServicesListLocked with service name: " + serviceName);
        if (getServiceType(serviceName) != AmbientContextManagerPerUserService.ServiceType.WEARABLE) goto L22;
        serviceList.add(new WearableAmbientContextManagerPerUserService(this, this.mLock, resolvedUserId, AmbientContextManagerPerUserService.ServiceType.WEARABLE, serviceName));
    L23:
        r8 = r8 + 1;
        goto L18
    L22:
        serviceList.add(new DefaultAmbientContextManagerPerUserService(this, this.mLock, resolvedUserId, AmbientContextManagerPerUserService.ServiceType.DEFAULT, serviceName));
        goto L23
    L24:
        return serviceList;
    }

    protected void onServiceRemoved(AmbientContextManagerPerUserService service, int userId) {
        Slog.d(TAG, "onServiceRemoved");
        service.destroyLocked();
    }

    @Override // com.android.server.infra.AbstractMasterSystemService
    protected void onServicePackageRestartedLocked(int userId) {
        Slog.d(TAG, "Restoring remote request. Reason: Service package restarted.");
        restorePreviouslyEnabledClients(userId);
    }

    @Override // com.android.server.infra.AbstractMasterSystemService
    protected void onServicePackageUpdatedLocked(int userId) {
        Slog.d(TAG, "Restoring remote request. Reason: Service package updated.");
        restorePreviouslyEnabledClients(userId);
    }

    @Override // com.android.server.infra.AbstractMasterSystemService
    protected void enforceCallingPermissionForManagement() {
        getContext().enforceCallingPermission("android.permission.ACCESS_AMBIENT_CONTEXT_EVENT", TAG);
    }

    @Override // com.android.server.infra.AbstractMasterSystemService
    protected int getMaximumTemporaryServiceDurationMs() {
        return 30000;
    }

    void startDetection(int userId, AmbientContextEventRequest request, String packageName, IAmbientContextObserver observer) {
        this.mContext.enforceCallingOrSelfPermission("android.permission.ACCESS_AMBIENT_CONTEXT_EVENT", TAG);
        Object r0 = this.mLock;
        monitor-enter(r0);
        AmbientContextManagerPerUserService service = getAmbientContextManagerPerUserServiceForEventTypes(userId, request.getEventTypes());     // Catch: Throwable -> L7
        if (service == null) goto L9;
        service.startDetection(request, packageName, observer);     // Catch: Throwable -> L7
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L9:
        Slog.i(TAG, "service not available for user_id: " + userId);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }

    void stopAmbientContextEvent(int userId, String packageName) {
        this.mContext.enforceCallingOrSelfPermission("android.permission.ACCESS_AMBIENT_CONTEXT_EVENT", TAG);
        Object r0 = this.mLock;
        monitor-enter(r0);
        Iterator<ClientRequest> r1 = this.mExistingClientRequests.iterator();     // Catch: Throwable -> L12
    L6:
        if (r1.hasNext() == false) goto L16;
        ClientRequest cr = r1.next();     // Catch: Throwable -> L12
        Slog.i(TAG, "Looping through clients");     // Catch: Throwable -> L12
        if (cr.hasUserIdAndPackageName(userId, packageName) == false) goto L6;
        Slog.i(TAG, "we have an existing client");     // Catch: Throwable -> L12
        AmbientContextManagerPerUserService service = getAmbientContextManagerPerUserServiceForEventTypes(userId, cr.getRequest().getEventTypes());     // Catch: Throwable -> L12
        if (service == null) goto L14;
        service.stopDetection(packageName);     // Catch: Throwable -> L12
        goto L6
    L14:
        Slog.i(TAG, "service not available for user_id: " + userId);     // Catch: Throwable -> L12
        goto L6
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    void queryServiceStatus(int userId, String packageName, int[] eventTypes, RemoteCallback callback) {
        this.mContext.enforceCallingOrSelfPermission("android.permission.ACCESS_AMBIENT_CONTEXT_EVENT", TAG);
        Object r0 = this.mLock;
        monitor-enter(r0);
        AmbientContextManagerPerUserService service = getAmbientContextManagerPerUserServiceForEventTypes(userId, intArrayToIntegerSet(eventTypes));     // Catch: Throwable -> L7
        if (service == null) goto L9;
        service.onQueryServiceStatus(eventTypes, packageName, callback);     // Catch: Throwable -> L7
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L9:
        Slog.i(TAG, "query service not available for user_id: " + userId);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }

    private void restorePreviouslyEnabledClients(int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        List<AmbientContextManagerPerUserService> services = getServiceListForUserLocked(userId);     // Catch: Throwable -> L13
        Iterator<AmbientContextManagerPerUserService> r2 = services.iterator();     // Catch: Throwable -> L13
    L6:
        if (r2.hasNext() == false) goto L17;
        AmbientContextManagerPerUserService service = r2.next();     // Catch: Throwable -> L13
        Iterator<ClientRequest> r4 = this.mExistingClientRequests.iterator();     // Catch: Throwable -> L13
    L9:
        if (r4.hasNext() == false) goto L6;
        ClientRequest clientRequest = r4.next();     // Catch: Throwable -> L13
        if (clientRequest.hasUserId(userId) == false) goto L9;
        Slog.d(TAG, "Restoring detection for " + clientRequest.getPackageName());     // Catch: Throwable -> L13
        service.startDetection(clientRequest.getRequest(), clientRequest.getPackageName(), clientRequest.getObserver());     // Catch: Throwable -> L13
        goto L9
    L17:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public ComponentName getComponentName(int userId, AmbientContextManagerPerUserService.ServiceType serviceType) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        AmbientContextManagerPerUserService service = getServiceForType(userId, serviceType);     // Catch: Throwable -> L9
        if (service == null) goto L12;
        ComponentName r2 = service.getComponentName();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return null;
    L9:
        th = move-exception;
        throw th;
    }

    private AmbientContextManagerPerUserService getAmbientContextManagerPerUserServiceForEventTypes(int userId, Set<Integer> eventTypes) {
        if (isWearableEventTypesOnly(eventTypes) == false) goto L7;
        return getServiceForType(userId, AmbientContextManagerPerUserService.ServiceType.WEARABLE);
    L7:
        return getServiceForType(userId, AmbientContextManagerPerUserService.ServiceType.DEFAULT);
    }

    private AmbientContextManagerPerUserService.ServiceType getServiceType(String serviceName) {
        String wearableService = this.mContext.getResources().getString(R.string.config_intrusionDetectionEventTransport);
        if (wearableService == null) goto L9;
        if (wearableService.equals(serviceName) == false) goto L9;
        return AmbientContextManagerPerUserService.ServiceType.WEARABLE;
    L9:
        return AmbientContextManagerPerUserService.ServiceType.DEFAULT;
    }

    private boolean isDefaultService(String serviceName) {
        String defaultService = this.mContext.getResources().getString(R.string.config_deviceConfiguratorPackageName);
        if (defaultService != null) goto L5;
        return false;
    L5:
        if (defaultService.equals(serviceName) == false) goto L10;
        return true;
    L10:
        return false;
    }

    private boolean isDefaultWearableService(String serviceName) {
        String wearableService = this.mContext.getResources().getString(R.string.config_intrusionDetectionEventTransport);
        if (wearableService != null) goto L5;
        return false;
    L5:
        if (wearableService.equals(serviceName) == false) goto L10;
        return true;
    L10:
        return false;
    }

    private AmbientContextManagerPerUserService getServiceForType(int userId, AmbientContextManagerPerUserService.ServiceType serviceType) {
        Slog.d(TAG, "getServiceForType with userid: " + userId + " service type: " + serviceType.name());
        Object r0 = this.mLock;
        monitor-enter(r0);
        List<AmbientContextManagerPerUserService> services = getServiceListForUserLocked(userId);     // Catch: Throwable -> L7
        String r2 = TAG;     // Catch: Throwable -> L7
        StringBuilder r3 = new StringBuilder();     // Catch: Throwable -> L7
        r3.append("Services that are available: ");     // Catch: Throwable -> L7
        if (services != null) goto L9;
        String r4 = "null services";
    L10:
        r3.append(r4);     // Catch: Throwable -> L7
        Slog.d(r2, r3.toString());     // Catch: Throwable -> L7
        if (services != null) goto L14;
        monitor-exit(r0);     // Catch: Throwable -> L7
        return null;
    L14:
        Iterator<AmbientContextManagerPerUserService> r5 = services.iterator();     // Catch: Throwable -> L7
    L16:
        if (r5.hasNext() == false) goto L22;
        AmbientContextManagerPerUserService service = r5.next();     // Catch: Throwable -> L7
        if (service.getServiceType() != serviceType) goto L16;
        monitor-exit(r0);     // Catch: Throwable -> L7
        return service;
    L22:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return null;
    L9:
        r4 = services.size() + " number of services";     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }

    private boolean isWearableEventTypesOnly(Set<Integer> eventTypes) {
        if (eventTypes.isEmpty() == false) goto L6;
        Slog.d(TAG, "empty event types.");
        return false;
    L6:
        Iterator<Integer> r0 = eventTypes.iterator();
    L8:
        if (r0.hasNext() == false) goto L14;
        Integer eventType = r0.next();
        if (eventType.intValue() >= 100000) goto L8;
        Slog.d(TAG, "Not all events types are wearable events.");
        return false;
    L14:
        Slog.d(TAG, "only wearable events.");
        return true;
    }

    private boolean isWearableEventTypesOnly(int[] eventTypes) {
        Integer[] events = intArrayToIntegerArray(eventTypes);
        return isWearableEventTypesOnly(new HashSet(Arrays.asList(events)));
    }

    private boolean containsMixedEvents(int[] eventTypes) {
        if (isWearableEventTypesOnly(eventTypes) == false) goto L5;
        return false;
    L5:
        int r0 = eventTypes.length;
        int r2 = 0;
    L6:
        if (r2 >= r0) goto L12;
        Integer event = Integer.valueOf(eventTypes[r2]);
        if (DEFAULT_EVENT_SET.contains(event) == false) goto L9;
        r2 = r2 + 1;
        goto L6
    L9:
        Slog.w(TAG, "Received mixed event types, this is not supported.");
        return true;
    L12:
        return false;
    }

    private static int[] integerSetToIntArray(Set<Integer> integerSet) {
        int[] intArray = new int[integerSet.size()];
        int i = 0;
        Iterator<Integer> r2 = integerSet.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        Integer type = r2.next();
        intArray[i] = type.intValue();
        i = i + 1;
        goto L4
    L6:
        return intArray;
    }

    private Set<Integer> intArrayToIntegerSet(int[] eventTypes) {
        Set<Integer> types = new HashSet();
        int r1 = eventTypes.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        Integer i = Integer.valueOf(eventTypes[r2]);
        types.add(i);
        r2 = r2 + 1;
        goto L3
    L5:
        return types;
    }

    private static Integer[] intArrayToIntegerArray(int[] integerSet) {
        Integer[] intArray = new Integer[integerSet.length];
        int i = 0;
        int r2 = integerSet.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L5;
        Integer type = Integer.valueOf(integerSet[r3]);
        intArray[i] = type;
        r3 = r3 + 1;
        i = i + 1;
        goto L3
    L5:
        return intArray;
    }
}
