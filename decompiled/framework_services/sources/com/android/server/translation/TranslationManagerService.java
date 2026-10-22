package com.android.server.translation;

import android.R;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.IBinder;
import android.os.IRemoteCallback;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.ShellCallback;
import android.os.UserHandle;
import android.util.Slog;
import android.view.autofill.AutofillId;
import android.view.translation.ITranslationManager;
import android.view.translation.TranslationContext;
import android.view.translation.TranslationSpec;
import android.view.translation.UiTranslationSpec;
import com.android.internal.os.IResultReceiver;
import com.android.internal.util.DumpUtils;
import com.android.internal.util.SyncResultReceiver;
import com.android.server.infra.AbstractMasterSystemService;
import com.android.server.infra.AbstractPerUserSystemService;
import com.android.server.infra.FrameworkResourcesServiceNameResolver;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class TranslationManagerService extends AbstractMasterSystemService<TranslationManagerService, TranslationManagerServiceImpl> {
    private static final int MAX_TEMP_SERVICE_SUBSTITUTION_DURATION_MS = 120000;
    private static final String TAG = "TranslationManagerService";

    final class TranslationManagerServiceStub extends ITranslationManager.Stub {
        final /* synthetic */ TranslationManagerService this$0;

        TranslationManagerServiceStub(TranslationManagerService this$0) {
            this.this$0 = this$0;
        }

        public void onTranslationCapabilitiesRequest(int sourceFormat, int targetFormat, ResultReceiver receiver, int userId) throws RemoteException {
            Object r0 = TranslationManagerService.access$000(this.this$0);
            monitor-enter(r0);
            TranslationManagerServiceImpl service = (TranslationManagerServiceImpl) TranslationManagerService.access$100(this.this$0, userId);     // Catch: Throwable -> L11
            if (service != null) goto L7;
        L14:
            Slog.v(TranslationManagerService.TAG, "onGetTranslationCapabilitiesLocked(): no service for " + userId);     // Catch: Throwable -> L11
            receiver.send(2, null);     // Catch: Throwable -> L11
        L15:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L7:
            if (TranslationManagerService.m8636$$Nest$misDefaultServiceLocked(this.this$0, userId) == false) goto L9;
        L13:
            service.onTranslationCapabilitiesRequestLocked(sourceFormat, targetFormat, receiver);     // Catch: Throwable -> L11
            goto L15
        L9:
            if (TranslationManagerService.m8635$$Nest$misCalledByServiceAppLocked(this.this$0, userId, "getTranslationCapabilities") == false) goto L14;
        L11:
            th = move-exception;
            throw th;
        }

        public void registerTranslationCapabilityCallback(IRemoteCallback callback, int userId) {
            Object r0 = TranslationManagerService.access$200(this.this$0);
            monitor-enter(r0);
            TranslationManagerServiceImpl service = (TranslationManagerServiceImpl) TranslationManagerService.access$300(this.this$0, userId);     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            if (service == null) goto L14;
            service.registerTranslationCapabilityCallback(callback, Binder.getCallingUid());
            return;
        L14:
            return;
        L9:
            th = move-exception;
            throw th;
        }

        public void unregisterTranslationCapabilityCallback(IRemoteCallback callback, int userId) {
            Object r0 = TranslationManagerService.access$400(this.this$0);
            monitor-enter(r0);
            TranslationManagerServiceImpl service = (TranslationManagerServiceImpl) TranslationManagerService.access$500(this.this$0, userId);     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            if (service == null) goto L14;
            service.unregisterTranslationCapabilityCallback(callback);
            return;
        L14:
            return;
        L9:
            th = move-exception;
            throw th;
        }

        public void onSessionCreated(TranslationContext translationContext, int sessionId, IResultReceiver receiver, int userId) throws RemoteException {
            Object r0 = TranslationManagerService.access$600(this.this$0);
            monitor-enter(r0);
            TranslationManagerServiceImpl service = (TranslationManagerServiceImpl) TranslationManagerService.access$700(this.this$0, userId);     // Catch: Throwable -> L11
            if (service != null) goto L7;
        L14:
            Slog.v(TranslationManagerService.TAG, "onSessionCreated(): no service for " + userId);     // Catch: Throwable -> L11
            receiver.send(2, null);     // Catch: Throwable -> L11
        L15:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L7:
            if (TranslationManagerService.m8636$$Nest$misDefaultServiceLocked(this.this$0, userId) == false) goto L9;
        L13:
            service.onSessionCreatedLocked(translationContext, sessionId, receiver);     // Catch: Throwable -> L11
            goto L15
        L9:
            if (TranslationManagerService.m8635$$Nest$misCalledByServiceAppLocked(this.this$0, userId, "onSessionCreated") == false) goto L14;
        L11:
            th = move-exception;
            throw th;
        }

        public void updateUiTranslationState(int state, TranslationSpec sourceSpec, TranslationSpec targetSpec, List<AutofillId> viewIds, IBinder token, int taskId, UiTranslationSpec uiTranslationSpec, int userId) {
            TranslationManagerService.m8634$$Nest$menforceCallerHasPermission(this.this$0, "android.permission.MANAGE_UI_TRANSLATION");
            Object r2 = TranslationManagerService.access$800(this.this$0);
            monitor-enter(r2);
            TranslationManagerServiceImpl service = (TranslationManagerServiceImpl) TranslationManagerService.access$900(this.this$0, userId);     // Catch: Throwable -> L11
            if (service != null) goto L7;
        L14:
            monitor-exit(r2);     // Catch: Throwable -> L11
            return;
        L7:
            if (TranslationManagerService.m8636$$Nest$misDefaultServiceLocked(this.this$0, userId) == false) goto L9;
        L13:
            service.updateUiTranslationStateLocked(state, sourceSpec, targetSpec, viewIds, token, taskId, uiTranslationSpec);     // Catch: Throwable -> L11
            goto L14
        L9:
            if (TranslationManagerService.m8635$$Nest$misCalledByServiceAppLocked(this.this$0, userId, "updateUiTranslationState") == false) goto L14;
        L11:
            th = move-exception;
            throw th;
        }

        public void registerUiTranslationStateCallback(IRemoteCallback callback, int userId) {
            Object r0 = TranslationManagerService.access$1000(this.this$0);
            monitor-enter(r0);
            TranslationManagerServiceImpl service = (TranslationManagerServiceImpl) TranslationManagerService.access$1100(this.this$0, userId);     // Catch: Throwable -> L7
            if (service == null) goto L9;
            service.registerUiTranslationStateCallbackLocked(callback, Binder.getCallingUid());     // Catch: Throwable -> L7
        L9:
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public void unregisterUiTranslationStateCallback(IRemoteCallback callback, int userId) {
            Object r0 = TranslationManagerService.access$1200(this.this$0);
            monitor-enter(r0);
            TranslationManagerServiceImpl service = (TranslationManagerServiceImpl) TranslationManagerService.access$1300(this.this$0, userId);     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            if (service == null) goto L14;
            service.unregisterUiTranslationStateCallback(callback);
            return;
        L14:
            return;
        L9:
            th = move-exception;
            throw th;
        }

        public void onTranslationFinished(boolean activityDestroyed, IBinder token, ComponentName componentName, int userId) {
            Object r0 = TranslationManagerService.access$1400(this.this$0);
            monitor-enter(r0);
            TranslationManagerServiceImpl service = (TranslationManagerServiceImpl) TranslationManagerService.access$1500(this.this$0, userId);     // Catch: Throwable -> L7
            service.onTranslationFinishedLocked(activityDestroyed, token, componentName);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public void getServiceSettingsActivity(IResultReceiver result, int userId) {
            Object r1 = TranslationManagerService.access$1600(this.this$0);
            monitor-enter(r1);
            TranslationManagerServiceImpl service = (TranslationManagerServiceImpl) TranslationManagerService.access$1700(this.this$0, userId);     // Catch: Throwable -> L32
            monitor-exit(r1);     // Catch: Throwable -> L32
            if (service == null) goto L39;
            ComponentName componentName = service.getServiceSettingsActivityLocked();
            if (componentName == null) goto L37;
        L14:
            Intent intent = new Intent();
            intent.setComponent(componentName);
            long identity = Binder.clearCallingIdentity();
            PendingIntent pendingIntent = PendingIntent.getActivityAsUser(this.this$0.getContext(), 0, intent, 67108864, null, new UserHandle(userId));     // Catch: Throwable -> L19
            result.send(1, SyncResultReceiver.bundleFor(pendingIntent));     // Catch: Throwable -> L19 RemoteException -> L21
        L23:
            Binder.restoreCallingIdentity(identity);
            return;
        L21:
            e = move-exception;
            Slog.w(TranslationManagerService.TAG, "Unable to send getServiceSettingsActivity(): " + e);     // Catch: Throwable -> L19
        L19:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        L37:
            result.send(1, null);     // Catch: RemoteException -> L12
        L12:
            e = move-exception;
            Slog.w(TranslationManagerService.TAG, "Unable to send getServiceSettingsActivity(): " + e);
            goto L14
        L39:
            result.send(2, null);     // Catch: RemoteException -> L29
            return;
        L29:
            e = move-exception;
            Slog.w(TranslationManagerService.TAG, "Unable to send getServiceSettingsActivity(): " + e);
            return;
        L32:
            th = move-exception;
            throw th;
        }

        public void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
            if (DumpUtils.checkDumpPermission(this.this$0.getContext(), TranslationManagerService.TAG, pw) == true) goto L5;
            return;
        L5:
            Object r0 = TranslationManagerService.access$1800(this.this$0);
            monitor-enter(r0);
            this.this$0.dumpLocked("", pw);     // Catch: Throwable -> L10
            int userId = UserHandle.getCallingUserId();     // Catch: Throwable -> L10
            TranslationManagerServiceImpl service = (TranslationManagerServiceImpl) TranslationManagerService.access$1900(this.this$0, userId);     // Catch: Throwable -> L10
            if (service == null) goto L12;
            service.dumpLocked("  ", fd, pw);     // Catch: Throwable -> L10
        L12:
            monitor-exit(r0);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            throw th;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void onShellCommand(FileDescriptor in, FileDescriptor out, FileDescriptor err, String[] args, ShellCallback callback, ResultReceiver resultReceiver) throws RemoteException {
            new TranslationManagerServiceShellCommand(this.this$0).exec(this, in, out, err, args, callback, resultReceiver);
        }
    }

    /* JADX INFO: renamed from: -$$Nest$menforceCallerHasPermission, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8634$$Nest$menforceCallerHasPermission(TranslationManagerService r0, String r1) {
        r0.enforceCallerHasPermission(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$misCalledByServiceAppLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m8635$$Nest$misCalledByServiceAppLocked(TranslationManagerService r0, int r1, String r2) {
        return r0.isCalledByServiceAppLocked(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$misDefaultServiceLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m8636$$Nest$misDefaultServiceLocked(TranslationManagerService r0, int r1) {
        return r0.isDefaultServiceLocked(r1);
    }

    static /* synthetic */ Object access$000(TranslationManagerService x0) {
        return x0.mLock;
    }

    static /* synthetic */ AbstractPerUserSystemService access$100(TranslationManagerService x0, int x1) {
        return x0.getServiceForUserLocked(x1);
    }

    static /* synthetic */ Object access$1000(TranslationManagerService x0) {
        return x0.mLock;
    }

    static /* synthetic */ AbstractPerUserSystemService access$1100(TranslationManagerService x0, int x1) {
        return x0.getServiceForUserLocked(x1);
    }

    static /* synthetic */ Object access$1200(TranslationManagerService x0) {
        return x0.mLock;
    }

    static /* synthetic */ AbstractPerUserSystemService access$1300(TranslationManagerService x0, int x1) {
        return x0.getServiceForUserLocked(x1);
    }

    static /* synthetic */ Object access$1400(TranslationManagerService x0) {
        return x0.mLock;
    }

    static /* synthetic */ AbstractPerUserSystemService access$1500(TranslationManagerService x0, int x1) {
        return x0.getServiceForUserLocked(x1);
    }

    static /* synthetic */ Object access$1600(TranslationManagerService x0) {
        return x0.mLock;
    }

    static /* synthetic */ AbstractPerUserSystemService access$1700(TranslationManagerService x0, int x1) {
        return x0.getServiceForUserLocked(x1);
    }

    static /* synthetic */ Object access$1800(TranslationManagerService x0) {
        return x0.mLock;
    }

    static /* synthetic */ AbstractPerUserSystemService access$1900(TranslationManagerService x0, int x1) {
        return x0.getServiceForUserLocked(x1);
    }

    static /* synthetic */ Object access$200(TranslationManagerService x0) {
        return x0.mLock;
    }

    static /* synthetic */ AbstractPerUserSystemService access$300(TranslationManagerService x0, int x1) {
        return x0.getServiceForUserLocked(x1);
    }

    static /* synthetic */ Object access$400(TranslationManagerService x0) {
        return x0.mLock;
    }

    static /* synthetic */ AbstractPerUserSystemService access$500(TranslationManagerService x0, int x1) {
        return x0.getServiceForUserLocked(x1);
    }

    static /* synthetic */ Object access$600(TranslationManagerService x0) {
        return x0.mLock;
    }

    static /* synthetic */ AbstractPerUserSystemService access$700(TranslationManagerService x0, int x1) {
        return x0.getServiceForUserLocked(x1);
    }

    static /* synthetic */ Object access$800(TranslationManagerService x0) {
        return x0.mLock;
    }

    static /* synthetic */ AbstractPerUserSystemService access$900(TranslationManagerService x0, int x1) {
        return x0.getServiceForUserLocked(x1);
    }

    @Override // com.android.server.infra.AbstractMasterSystemService
    protected /* bridge */ /* synthetic */ AbstractPerUserSystemService newServiceLocked(int r1, boolean r2) {
        return newServiceLocked(r1, r2);
    }

    public TranslationManagerService(Context context) {
        super(context, new FrameworkResourcesServiceNameResolver(context, R.string.config_icon_mask), null, 4);
    }

    @Override // com.android.server.infra.AbstractMasterSystemService
    protected TranslationManagerServiceImpl newServiceLocked(int resolvedUserId, boolean disabled) {
        return new TranslationManagerServiceImpl(this, this.mLock, resolvedUserId, disabled);
    }

    @Override // com.android.server.infra.AbstractMasterSystemService
    protected void enforceCallingPermissionForManagement() {
        getContext().enforceCallingPermission("android.permission.MANAGE_UI_TRANSLATION", TAG);
    }

    @Override // com.android.server.infra.AbstractMasterSystemService
    protected int getMaximumTemporaryServiceDurationMs() {
        return MAX_TEMP_SERVICE_SUBSTITUTION_DURATION_MS;
    }

    @Override // com.android.server.infra.AbstractMasterSystemService
    protected void dumpLocked(String prefix, PrintWriter pw) {
        super.dumpLocked(prefix, pw);
    }

    private void enforceCallerHasPermission(String permission) {
        String msg = "Permission Denial from pid =" + Binder.getCallingPid() + ", uid=" + Binder.getCallingUid() + " doesn't hold " + permission;
        getContext().enforceCallingPermission(permission, msg);
    }

    private boolean isDefaultServiceLocked(int userId) {
        String defaultServiceName = this.mServiceNameResolver.getDefaultServiceName(userId);
        if (defaultServiceName != null) goto L6;
        return false;
    L6:
        String currentServiceName = this.mServiceNameResolver.getServiceName(userId);
        return defaultServiceName.equals(currentServiceName);
    }

    private boolean isCalledByServiceAppLocked(int userId, String methodName) {
        int callingUid = Binder.getCallingUid();
        String serviceName = this.mServiceNameResolver.getServiceName(userId);
        if (serviceName != null) goto L6;
        Slog.e(TAG, methodName + ": called by UID " + callingUid + ", but there's no service set for user " + userId);
        return false;
    L6:
        ComponentName serviceComponent = ComponentName.unflattenFromString(serviceName);
        if (serviceComponent != null) goto L10;
        Slog.w(TAG, methodName + ": invalid service name: " + serviceName);
        return false;
    L10:
        String servicePackageName = serviceComponent.getPackageName();
        PackageManager pm = getContext().getPackageManager();
        int serviceUid = pm.getPackageUidAsUser(servicePackageName, userId);     // Catch: PackageManager.NameNotFoundException -> L17
        if (callingUid == serviceUid) goto L15;
        Slog.e(TAG, methodName + ": called by UID " + callingUid + ", but service UID is " + serviceUid);
        return false;
    L15:
        return true;
    L18:
        Slog.w(TAG, methodName + ": could not verify UID for " + serviceName);
        return false;
    }

    @Override // com.android.server.SystemService
    public void onStart() {
        publishBinderService("translation", new TranslationManagerServiceStub(this));
    }
}
