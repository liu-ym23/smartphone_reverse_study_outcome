package com.android.server.devicestate;

import android.R;
import android.app.ActivityManager;
import android.app.ActivityManagerInternal;
import android.app.IProcessObserver;
import android.content.Context;
import android.frameworks.devicestate.DeviceStateConfiguration;
import android.frameworks.devicestate.IDeviceStateListener;
import android.frameworks.devicestate.IDeviceStateService;
import android.hardware.devicestate.DeviceState;
import android.hardware.devicestate.DeviceStateInfo;
import android.hardware.devicestate.DeviceStateManagerInternal;
import android.hardware.devicestate.IDeviceStateManager;
import android.hardware.devicestate.IDeviceStateManagerCallback;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.ServiceManager;
import android.os.ServiceSpecificException;
import android.os.ShellCallback;
import android.os.SystemProperties;
import android.os.Trace;
import android.util.LongSparseLongArray;
import android.util.Slog;
import android.util.SparseArray;
import com.android.internal.util.DumpUtils;
import com.android.internal.util.FrameworkStatsLog;
import com.android.server.DisplayThread;
import com.android.server.LocalServices;
import com.android.server.SystemService;
import com.android.server.pm.PackageManagerService;
import com.android.server.statusbar.StatusBarManagerInternal;
import com.android.server.wm.ActivityTaskManagerInternal;
import com.android.server.wm.WindowProcessController;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class DeviceStateManagerService extends SystemService {
    private static final boolean DEBUG = false;
    private static final DeviceState INVALID_DEVICE_STATE = null;
    private static final String TAG = "DeviceStateManagerService";
    private Optional<OverrideRequest> mActiveBaseStateOverride;
    private Optional<OverrideRequest> mActiveOverride;
    public ActivityTaskManagerInternal mActivityTaskManagerInternal;
    private Optional<DeviceState> mBaseState;
    private final BinderService mBinderService;
    private Optional<DeviceState> mCommittedState;
    private final DeviceStateNotificationController mDeviceStateNotificationController;
    private final DeviceStatePolicy mDeviceStatePolicy;
    private final DeviceStateProviderListener mDeviceStateProviderListener;
    private final SparseArray<DeviceState> mDeviceStates;
    private final Set<Integer> mDeviceStatesAvailableForAppRequests;
    private Set<Integer> mFoldedDeviceStates;
    private final HalService mHalService;
    private final Handler mHandler;
    private boolean mIsPolicyWaitingForState;
    private final Object mLock;
    private final OverrideRequestController mOverrideRequestController;
    ActivityTaskManagerInternal.ScreenObserver mOverrideRequestScreenObserver;
    private Optional<DeviceState> mPendingState;
    final IProcessObserver mProcessObserver;
    private final SparseArray<ProcessRecord> mProcessRecords;
    private OverrideRequest mRearDisplayPendingOverrideRequest;
    private DeviceState mRearDisplayState;
    private final SystemPropertySetter mSystemPropertySetter;

    private final class BinderService extends IDeviceStateManager.Stub {
        final /* synthetic */ DeviceStateManagerService this$0;

        /* synthetic */ BinderService(DeviceStateManagerService r1, DeviceStateManagerServiceIA r2) {
            this(r1);
        }

        private BinderService(DeviceStateManagerService r1) {
            this.this$0 = r1;
        }

        public DeviceStateInfo getDeviceStateInfo() {
            Object r0 = DeviceStateManagerService.m3532$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            DeviceStateInfo r1 = DeviceStateManagerService.m3540$$Nest$mgetDeviceStateInfoLocked(this.this$0);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        public DeviceStateInfo registerCallback(IDeviceStateManagerCallback callback) {
            if (callback == null) goto L11;
            int callingPid = Binder.getCallingPid();
            long token = Binder.clearCallingIdentity();
            DeviceStateInfo r3 = DeviceStateManagerService.m3543$$Nest$mregisterProcess(this.this$0, callingPid, callback);     // Catch: Throwable -> L7
            Binder.restoreCallingIdentity(token);
            return r3;
        L7:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        L11:
            throw new IllegalArgumentException("Device state callback must not be null.");
        }

        public void requestState(IBinder token, int state, int flags) {
            int callingPid = Binder.getCallingPid();
            int callingUid = Binder.getCallingUid();
            DeviceStateManagerService.m3539$$Nest$menforceRequestDeviceStatePermitted(this.this$0, callingPid, callingUid, state);
            if (token == null) goto L22;
            if (this.this$0.getContext().checkCallingOrSelfPermission("android.permission.CONTROL_DEVICE_STATE") != 0) goto L8;
            boolean r0 = true;
        L7:
            boolean hasControlStatePermission = r0;
            long callingIdentity = Binder.clearCallingIdentity();
            DeviceStateManagerService.m3545$$Nest$mrequestStateInternal(this.this$0, state, flags, callingPid, callingUid, token, hasControlStatePermission);     // Catch: Throwable -> L15
            Binder.restoreCallingIdentity(callingIdentity);
            return;
        L15:
            th = move-exception;
            Throwable r10 = th;
        L19:
            Binder.restoreCallingIdentity(callingIdentity);
            throw r10;
        L17:
            th = move-exception;
            r10 = th;
            goto L19
        L8:
            r0 = false;
            goto L7
        L22:
            throw new IllegalArgumentException("Request token must not be null.");
        }

        public void cancelStateRequest() {
            int callingPid = Binder.getCallingPid();
            int callingUid = Binder.getCallingUid();
            DeviceStateManagerService.m3538$$Nest$menforceCancelDeviceStatePermitted(this.this$0, callingPid, callingUid);
            long callingIdentity = Binder.clearCallingIdentity();
            DeviceStateManagerService.m3536$$Nest$mcancelStateRequestInternal(this.this$0, callingPid);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(callingIdentity);
            return;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(callingIdentity);
            throw th;
        }

        public void requestBaseStateOverride(IBinder token, int state, int flags) {
            int callingPid = Binder.getCallingPid();
            int callingUid = Binder.getCallingUid();
            this.this$0.getContext().enforceCallingOrSelfPermission("android.permission.CONTROL_DEVICE_STATE", "Permission required to control base state of device.");
            if (token == null) goto L17;
            long callingIdentity = Binder.clearCallingIdentity();
            DeviceStateManagerService.m3544$$Nest$mrequestBaseStateOverrideInternal(this.this$0, state, flags, callingPid, callingUid, token);     // Catch: Throwable -> L10
            Binder.restoreCallingIdentity(callingIdentity);
            return;
        L10:
            th = move-exception;
            Throwable r9 = th;
        L14:
            Binder.restoreCallingIdentity(callingIdentity);
            throw r9;
        L12:
            th = move-exception;
            r9 = th;
            goto L14
        L17:
            throw new IllegalArgumentException("Request token must not be null.");
        }

        public void cancelBaseStateOverride() {
            int callingPid = Binder.getCallingPid();
            this.this$0.getContext().enforceCallingOrSelfPermission("android.permission.CONTROL_DEVICE_STATE", "Permission required to control base state of device.");
            long callingIdentity = Binder.clearCallingIdentity();
            DeviceStateManagerService.m3535$$Nest$mcancelBaseStateOverrideInternal(this.this$0, callingPid);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(callingIdentity);
            return;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(callingIdentity);
            throw th;
        }

        public void onStateRequestOverlayDismissed(boolean shouldCancelRequest) {
            onStateRequestOverlayDismissed_enforcePermission();
            long callingIdentity = Binder.clearCallingIdentity();
            DeviceStateManagerService.m3542$$Nest$monStateRequestOverlayDismissedInternal(this.this$0, shouldCancelRequest);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(callingIdentity);
            return;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(callingIdentity);
            throw th;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void onShellCommand(FileDescriptor in, FileDescriptor out, FileDescriptor err, String[] args, ShellCallback callback, ResultReceiver result) {
            new DeviceStateManagerShellCommand(this.this$0).exec(this, in, out, err, args, callback, result);
        }

        public void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
            if (DumpUtils.checkDumpPermission(this.this$0.getContext(), DeviceStateManagerService.TAG, pw) == true) goto L5;
            return;
        L5:
            long token = Binder.clearCallingIdentity();
            DeviceStateManagerService.m3537$$Nest$mdumpInternal(this.this$0, pw);     // Catch: Throwable -> L9
            Binder.restoreCallingIdentity(token);
            return;
        L9:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        }
    }

    private final class DeviceStateProviderListener implements DeviceStateProvider.Listener {
        int mCurrentBaseState;
        final /* synthetic */ DeviceStateManagerService this$0;

        /* synthetic */ DeviceStateProviderListener(DeviceStateManagerService r1, DeviceStateManagerServiceIA r2) {
            this(r1);
        }

        private DeviceStateProviderListener(DeviceStateManagerService r1) {
            this.this$0 = r1;
        }

        @Override // com.android.server.devicestate.DeviceStateProvider.Listener
        public void onSupportedDeviceStatesChanged(DeviceState[] newDeviceStates, int reason) {
            if (newDeviceStates.length == 0) goto L7;
            DeviceStateManagerService.m3548$$Nest$mupdateSupportedStates(this.this$0, newDeviceStates, reason);
            return;
        L7:
            throw new IllegalArgumentException("Supported device states must not be empty");
        }

        @Override // com.android.server.devicestate.DeviceStateProvider.Listener
        public void onStateChanged(int identifier) {
            if (identifier < 0) goto L8;
            if (identifier > 10000) goto L8;
            this.mCurrentBaseState = identifier;
            DeviceStateManagerService.m3546$$Nest$msetBaseState(this.this$0, identifier);
            return;
        L8:
            throw new IllegalArgumentException("Invalid identifier: " + identifier);
        }
    }

    private final class HalService extends IDeviceStateService.Stub {
        private final LongSparseLongArray mPublicProperties;
        final /* synthetic */ DeviceStateManagerService this$0;

        private final class HalBinderCallback implements IDeviceStateManagerCallback {
            private final IDeviceStateListener mListener;
            final /* synthetic */ HalService this$1;

            /* synthetic */ HalBinderCallback(HalService r1, IDeviceStateListener r2, DeviceStateManagerServiceIA r3) {
                this(r1, r2);
            }

            private HalBinderCallback(HalService r1, IDeviceStateListener listener) {
                this.this$1 = r1;
                this.mListener = listener;
            }

            public void onDeviceStateInfoChanged(DeviceStateInfo info) throws RemoteException {
                DeviceStateConfiguration config = new DeviceStateConfiguration();
                Set<Integer> systemProperties = new HashSet(info.currentState.getConfiguration().getSystemProperties());
                Set<Integer> physicalProperties = new HashSet(info.currentState.getConfiguration().getPhysicalProperties());
                config.deviceProperties = 0;
                Iterator<Integer> r3 = systemProperties.iterator();
            L4:
                if (r3.hasNext() == false) goto L6;
                Integer prop = r3.next();
                Long publicProperty = Long.valueOf(HalService.m3549$$Nest$fgetmPublicProperties(this.this$1).get(prop.intValue()));
                config.deviceProperties |= publicProperty.longValue();
                goto L4
            L6:
                Iterator<Integer> r4 = physicalProperties.iterator();
            L8:
                if (r4.hasNext() == false) goto L10;
                Integer prop2 = r4.next();
                Long publicProperty2 = Long.valueOf(HalService.m3549$$Nest$fgetmPublicProperties(this.this$1).get(prop2.intValue()));
                config.deviceProperties |= publicProperty2.longValue();
                goto L8
            L10:
                this.mListener.onDeviceStateChanged(config);
            }

            public void onRequestActive(IBinder token) {
            }

            public void onRequestCanceled(IBinder token) {
            }

            public IBinder asBinder() {
                return this.mListener.asBinder();
            }
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmPublicProperties, reason: not valid java name */
        static /* bridge */ /* synthetic */ LongSparseLongArray m3549$$Nest$fgetmPublicProperties(HalService r0) {
            return r0.mPublicProperties;
        }

        public HalService(DeviceStateManagerService r5) {
            this.this$0 = r5;
            this.mPublicProperties = new LongSparseLongArray();
            this.mPublicProperties.put(1, 1);
            this.mPublicProperties.put(2, 2);
            this.mPublicProperties.put(3, 4);
            this.mPublicProperties.put(11, 8);
            this.mPublicProperties.put(12, 16);
            this.mPublicProperties.put(16, 32);
            this.mPublicProperties.put(17, 64);
        }

        @Override // android.frameworks.devicestate.IDeviceStateService
        public void registerListener(IDeviceStateListener listener) throws RemoteException {
            if (listener == null) goto L20;
            int callingPid = Binder.getCallingPid();
            long token = Binder.clearCallingIdentity();
            HalBinderCallback callback = new HalBinderCallback(this, listener, null);     // Catch: Throwable -> L8 SecurityException -> L10
            DeviceStateInfo info = DeviceStateManagerService.m3543$$Nest$mregisterProcess(this.this$0, callingPid, callback);     // Catch: Throwable -> L8 SecurityException -> L10
            if (info == null) goto L12;
            callback.onDeviceStateInfoChanged(info);     // Catch: Throwable -> L8 SecurityException -> L10
        L12:
            Binder.restoreCallingIdentity(token);
            return;
        L8:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        L16:
            throw new ServiceSpecificException(2);     // Catch: Throwable -> L8
        L20:
            throw new ServiceSpecificException(1);
        }

        @Override // android.frameworks.devicestate.IDeviceStateService
        public void unregisterListener(IDeviceStateListener listener) throws RemoteException {
            int callingPid = Binder.getCallingPid();
            Object r1 = DeviceStateManagerService.m3532$$Nest$fgetmLock(this.this$0);
            monitor-enter(r1);
        L9:
            th = move-exception;
            throw th;
        L5:
            if (DeviceStateManagerService.m3534$$Nest$fgetmProcessRecords(this.this$0).contains(callingPid) == false) goto L11;
            DeviceStateManagerService.m3534$$Nest$fgetmProcessRecords(this.this$0).remove(callingPid);     // Catch: Throwable -> L9
            monitor-exit(r1);     // Catch: Throwable -> L9
            return;
        L11:
            monitor-exit(r1);     // Catch: Throwable -> L9
            throw new ServiceSpecificException(1);
        }

        @Override // android.frameworks.devicestate.IDeviceStateService
        public int getInterfaceVersion() throws RemoteException {
            return 1;
        }

        @Override // android.frameworks.devicestate.IDeviceStateService
        public String getInterfaceHash() throws RemoteException {
            return "be9013fedb7fc3886980eca0e588bce998d315d2";
        }
    }

    private final class LocalService extends DeviceStateManagerInternal {
        final /* synthetic */ DeviceStateManagerService this$0;

        /* synthetic */ LocalService(DeviceStateManagerService r1, DeviceStateManagerServiceIA r2) {
            this(r1);
        }

        private LocalService(DeviceStateManagerService r1) {
            this.this$0 = r1;
        }

        public int[] getSupportedStateIdentifiers() {
            Object r0 = DeviceStateManagerService.m3532$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            int[] r1 = DeviceStateManagerService.m3541$$Nest$mgetSupportedStateIdentifiersLocked(this.this$0);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }
    }

    private class OverrideRequestScreenObserver implements ActivityTaskManagerInternal.ScreenObserver {
        final /* synthetic */ DeviceStateManagerService this$0;

        /* synthetic */ OverrideRequestScreenObserver(DeviceStateManagerService r1, DeviceStateManagerServiceIA r2) {
            this(r1);
        }

        private OverrideRequestScreenObserver(DeviceStateManagerService r1) {
            this.this$0 = r1;
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal.ScreenObserver
        public void onAwakeStateChanged(boolean isAwake) {
            Object r0 = DeviceStateManagerService.m3532$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            if (isAwake == false) goto L14;
        L10:
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            throw th;
        L14:
            if (DeviceStateManagerService.m3547$$Nest$mshouldCancelOverrideRequestWhenRequesterNotOnTop(this.this$0) == false) goto L10;
            DeviceStateManagerService.m3533$$Nest$fgetmOverrideRequestController(this.this$0).cancelRequest((OverrideRequest) DeviceStateManagerService.m3531$$Nest$fgetmActiveOverride(this.this$0).get());     // Catch: Throwable -> L8
            goto L10
        }

        @Override // com.android.server.wm.ActivityTaskManagerInternal.ScreenObserver
        public void onKeyguardStateChanged(boolean isShowing) {
            Object r0 = DeviceStateManagerService.m3532$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            if (isShowing == true) goto L14;
        L10:
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            throw th;
        L14:
            if (DeviceStateManagerService.m3547$$Nest$mshouldCancelOverrideRequestWhenRequesterNotOnTop(this.this$0) == false) goto L10;
            DeviceStateManagerService.m3533$$Nest$fgetmOverrideRequestController(this.this$0).cancelRequest((OverrideRequest) DeviceStateManagerService.m3531$$Nest$fgetmActiveOverride(this.this$0).get());     // Catch: Throwable -> L8
            goto L10
        }
    }

    private static final class ProcessRecord implements IBinder.DeathRecipient {
        private static final int STATUS_ACTIVE = 0;
        private static final int STATUS_CANCELED = 2;
        private static final int STATUS_SUSPENDED = 1;
        private final IDeviceStateManagerCallback mCallback;
        private final DeathListener mDeathListener;
        private final Handler mHandler;
        private final WeakHashMap<IBinder, Integer> mLastNotifiedStatus;
        private final int mPid;

        public interface DeathListener {
            void onProcessDied(ProcessRecord r1);
        }

        @Retention(RetentionPolicy.SOURCE)
        private @interface RequestStatus {
        }

        public static /* synthetic */ void $r8$lambda$DK7ffgb1AhuFZssIzsfEkoebd4U(ProcessRecord r0, IBinder r1) {
            r0.lambda$notifyRequestCanceledAsync$2(r1);
        }

        public static /* synthetic */ void $r8$lambda$isNL1YpEmNPaWOig9lDTv6reexw(ProcessRecord r0, IBinder r1) {
            r0.lambda$notifyRequestActiveAsync$1(r1);
        }

        public static /* synthetic */ void $r8$lambda$nIhPLI20eH9RacaP39kxGqE_dy4(ProcessRecord r0, DeviceStateInfo r1) {
            r0.lambda$notifyDeviceStateInfoAsync$0(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmPid, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m3550$$Nest$fgetmPid(ProcessRecord r0) {
            return r0.mPid;
        }

        ProcessRecord(IDeviceStateManagerCallback callback, int pid, DeathListener deathListener, Handler handler) {
            this.mLastNotifiedStatus = new WeakHashMap();
            this.mCallback = callback;
            this.mPid = pid;
            this.mDeathListener = deathListener;
            this.mHandler = handler;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            this.mDeathListener.onProcessDied(this);
        }

        public void notifyDeviceStateInfoAsync(final DeviceStateInfo info) {
            this.mHandler.post(new DeviceStateManagerService$ProcessRecord$$ExternalSyntheticLambda1(this, info));
        }

        private /* synthetic */ void lambda$notifyDeviceStateInfoAsync$0(DeviceStateInfo info) {
            boolean tracingEnabled = Trace.isTagEnabled(524288);
            if (tracingEnabled == false) goto L18;
            Trace.traceBegin(524288, "notifyDeviceStateInfoAsync(pid=" + this.mPid + ")");
        L18:
            this.mCallback.onDeviceStateInfoChanged(info);     // Catch: Throwable -> L8 RemoteException -> L10
            if (tracingEnabled == false) goto L14;
        L7:
            Trace.traceEnd(524288);
            return;
        L14:
            return;
        L8:
            th = move-exception;
            if (tracingEnabled == false) goto L17;
            Trace.traceEnd(524288);
        L17:
            throw th;
        L10:
            ex = move-exception;
            Slog.w(DeviceStateManagerService.TAG, "Failed to notify process " + this.mPid + " that device state changed.", ex);     // Catch: Throwable -> L8
            if (tracingEnabled == true) goto L7;
        }

        public void notifyRequestActiveAsync(final IBinder token) {
            Integer lastStatus = this.mLastNotifiedStatus.get(token);
            if (lastStatus != null) goto L5;
        L9:
            this.mLastNotifiedStatus.put(token, 0);
            this.mHandler.post(new DeviceStateManagerService$ProcessRecord$$ExternalSyntheticLambda0(this, token));
            return;
        L5:
            if (lastStatus.intValue() != 0) goto L7;
            return;
        L7:
            if (lastStatus.intValue() != 2) goto L9;
        }

        private /* synthetic */ void lambda$notifyRequestActiveAsync$1(IBinder token) {
            this.mCallback.onRequestActive(token);     // Catch: RemoteException -> L4
            return;
        L4:
            ex = move-exception;
            Slog.w(DeviceStateManagerService.TAG, "Failed to notify process " + this.mPid + " that request state changed.", ex);
        }

        public void notifyRequestCanceledAsync(final IBinder token) {
            Integer lastStatus = this.mLastNotifiedStatus.get(token);
            if (lastStatus != null) goto L5;
        L7:
            this.mLastNotifiedStatus.put(token, 2);
            this.mHandler.post(new DeviceStateManagerService$ProcessRecord$$ExternalSyntheticLambda2(this, token));
            return;
        L5:
            if (lastStatus.intValue() != 2) goto L7;
        }

        private /* synthetic */ void lambda$notifyRequestCanceledAsync$2(IBinder token) {
            this.mCallback.onRequestCanceled(token);     // Catch: RemoteException -> L4
            return;
        L4:
            ex = move-exception;
            Slog.w(DeviceStateManagerService.TAG, "Failed to notify process " + this.mPid + " that request state changed.", ex);
        }
    }

    interface SystemPropertySetter {
        void setDebugTracingDeviceStateProperty(String r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$1m79Of9qEVw--8G77adY9v4xgMI, reason: not valid java name */
    public static /* synthetic */ void m3529$r8$lambda$1m79Of9qEVw8G77adY9v4xgMI(DeviceStateManagerService r0, OverrideRequest r1, int r2, int r3) {
        r0.onOverrideRequestStatusChangedLocked(r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$6S_FM3Urv4lHJLVX2jHkYwHw8e8(DeviceStateManagerService r0) {
        r0.commitPendingState();
    }

    /* JADX INFO: renamed from: $r8$lambda$77DysMvX-MjvuW05plFI2snaWgo, reason: not valid java name */
    public static /* synthetic */ void m3530$r8$lambda$77DysMvXMjvuW05plFI2snaWgo(String r0) {
        lambda$new$0(r0);
    }

    public static /* synthetic */ void $r8$lambda$Pt9nYBQnPB5YrI3sLG37X4OCyMY(DeviceStateManagerService r0) {
        r0.notifyPolicyIfNeeded();
    }

    public static /* synthetic */ void $r8$lambda$s4SpdtJgMEy0ZXs46NwY86Y5deo(DeviceStateManagerService r0) {
        r0.lambda$new$1();
    }

    public static /* synthetic */ void $r8$lambda$y4cVYJncqF_C2SiLBG3CP5nmqj4(DeviceStateManagerService r0, ProcessRecord r1) {
        r0.handleProcessDied(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmActiveOverride, reason: not valid java name */
    static /* bridge */ /* synthetic */ Optional m3531$$Nest$fgetmActiveOverride(DeviceStateManagerService r0) {
        return r0.mActiveOverride;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m3532$$Nest$fgetmLock(DeviceStateManagerService r0) {
        return r0.mLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmOverrideRequestController, reason: not valid java name */
    static /* bridge */ /* synthetic */ OverrideRequestController m3533$$Nest$fgetmOverrideRequestController(DeviceStateManagerService r0) {
        return r0.mOverrideRequestController;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmProcessRecords, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseArray m3534$$Nest$fgetmProcessRecords(DeviceStateManagerService r0) {
        return r0.mProcessRecords;
    }

    /* JADX INFO: renamed from: -$$Nest$mcancelBaseStateOverrideInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3535$$Nest$mcancelBaseStateOverrideInternal(DeviceStateManagerService r0, int r1) {
        r0.cancelBaseStateOverrideInternal(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mcancelStateRequestInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3536$$Nest$mcancelStateRequestInternal(DeviceStateManagerService r0, int r1) {
        r0.cancelStateRequestInternal(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mdumpInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3537$$Nest$mdumpInternal(DeviceStateManagerService r0, PrintWriter r1) {
        r0.dumpInternal(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$menforceCancelDeviceStatePermitted, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3538$$Nest$menforceCancelDeviceStatePermitted(DeviceStateManagerService r0, int r1, int r2) {
        r0.enforceCancelDeviceStatePermitted(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$menforceRequestDeviceStatePermitted, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3539$$Nest$menforceRequestDeviceStatePermitted(DeviceStateManagerService r0, int r1, int r2, int r3) {
        r0.enforceRequestDeviceStatePermitted(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetDeviceStateInfoLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ DeviceStateInfo m3540$$Nest$mgetDeviceStateInfoLocked(DeviceStateManagerService r0) {
        return r0.getDeviceStateInfoLocked();
    }

    /* JADX INFO: renamed from: -$$Nest$mgetSupportedStateIdentifiersLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ int[] m3541$$Nest$mgetSupportedStateIdentifiersLocked(DeviceStateManagerService r0) {
        return r0.getSupportedStateIdentifiersLocked();
    }

    /* JADX INFO: renamed from: -$$Nest$monStateRequestOverlayDismissedInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3542$$Nest$monStateRequestOverlayDismissedInternal(DeviceStateManagerService r0, boolean r1) {
        r0.onStateRequestOverlayDismissedInternal(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mregisterProcess, reason: not valid java name */
    static /* bridge */ /* synthetic */ DeviceStateInfo m3543$$Nest$mregisterProcess(DeviceStateManagerService r0, int r1, IDeviceStateManagerCallback r2) {
        return r0.registerProcess(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mrequestBaseStateOverrideInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3544$$Nest$mrequestBaseStateOverrideInternal(DeviceStateManagerService r0, int r1, int r2, int r3, int r4, IBinder r5) {
        r0.requestBaseStateOverrideInternal(r1, r2, r3, r4, r5);
    }

    /* JADX INFO: renamed from: -$$Nest$mrequestStateInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3545$$Nest$mrequestStateInternal(DeviceStateManagerService r0, int r1, int r2, int r3, int r4, IBinder r5, boolean r6) {
        r0.requestStateInternal(r1, r2, r3, r4, r5, r6);
    }

    /* JADX INFO: renamed from: -$$Nest$msetBaseState, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3546$$Nest$msetBaseState(DeviceStateManagerService r0, int r1) {
        r0.setBaseState(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mshouldCancelOverrideRequestWhenRequesterNotOnTop, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m3547$$Nest$mshouldCancelOverrideRequestWhenRequesterNotOnTop(DeviceStateManagerService r0) {
        return r0.shouldCancelOverrideRequestWhenRequesterNotOnTop();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateSupportedStates, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3548$$Nest$mupdateSupportedStates(DeviceStateManagerService r0, DeviceState[] r1, int r2) {
        r0.updateSupportedStates(r1, r2);
    }

    static {
        INVALID_DEVICE_STATE = new DeviceState(new DeviceState.Configuration.Builder(-1, "INVALID").build());
    }

    public DeviceStateManagerService(Context context) {
        this(context, DeviceStatePolicy.Provider.fromResources(context.getResources()).instantiate(context));
    }

    private DeviceStateManagerService(Context context, DeviceStatePolicy policy) {
        this(context, policy, new DeviceStateManagerService$$ExternalSyntheticLambda3());
    }

    private static /* synthetic */ void lambda$new$0(String value) {
        SystemProperties.set("debug.tracing.device_state", value);
    }

    DeviceStateManagerService(Context context, DeviceStatePolicy policy, SystemPropertySetter systemPropertySetter) {
        super(context);
        this.mLock = new Object();
        this.mDeviceStates = new SparseArray();
        this.mCommittedState = Optional.empty();
        this.mPendingState = Optional.empty();
        this.mIsPolicyWaitingForState = false;
        this.mBaseState = Optional.empty();
        this.mActiveOverride = Optional.empty();
        this.mActiveBaseStateOverride = Optional.empty();
        this.mProcessRecords = new SparseArray();
        this.mDeviceStatesAvailableForAppRequests = new HashSet();
        this.mFoldedDeviceStates = new HashSet();
        this.mProcessObserver = new AnonymousClass1(this);
        DeviceStateManagerServiceIA r1 = null;
        this.mOverrideRequestScreenObserver = new OverrideRequestScreenObserver(this, r1);
        this.mSystemPropertySetter = systemPropertySetter;
        DisplayThread displayThread = DisplayThread.get();
        this.mHandler = new Handler(displayThread.getLooper());
        this.mOverrideRequestController = new OverrideRequestController(new DeviceStateManagerService$$ExternalSyntheticLambda5(this));
        this.mDeviceStatePolicy = policy;
        this.mDeviceStateProviderListener = new DeviceStateProviderListener(this, r1);
        this.mDeviceStatePolicy.getDeviceStateProvider().setListener(this.mDeviceStateProviderListener);
        this.mBinderService = new BinderService(this, r1);
        this.mHalService = new HalService(this);
        this.mActivityTaskManagerInternal = (ActivityTaskManagerInternal) LocalServices.getService(ActivityTaskManagerInternal.class);
        this.mDeviceStateNotificationController = new DeviceStateNotificationController(context, this.mHandler, new DeviceStateManagerService$$ExternalSyntheticLambda6(this));
    }

    private /* synthetic */ void lambda$new$1() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        Optional<OverrideRequest> r1 = this.mActiveOverride;     // Catch: Throwable -> L7
        OverrideRequestController r2 = this.mOverrideRequestController;     // Catch: Throwable -> L7
        r2.getClass();     // Catch: Throwable -> L7
        r1.ifPresent(new DeviceStateManagerService$$ExternalSyntheticLambda4(r2));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.SystemService
    public void onStart() {
        publishBinderService("device_state", this.mBinderService);
        String halServiceName = IDeviceStateService.DESCRIPTOR + "/default";
        if (ServiceManager.isDeclared(halServiceName) == false) goto L5;
        publishBinderService(halServiceName, this.mHalService);
    L5:
        publishLocalService(DeviceStateManagerInternal.class, new LocalService(this, null));
        this.mActivityTaskManagerInternal.registerScreenObserver(this.mOverrideRequestScreenObserver);
        ((ActivityManagerInternal) LocalServices.getService(ActivityManagerInternal.class)).registerProcessObserver(this.mProcessObserver);
    }

    @Override // com.android.server.SystemService
    public void onBootPhase(int phase) {
        if (phase != 500) goto L6;
        this.mDeviceStatePolicy.getDeviceStateProvider().onSystemReady();
        return;
    }

    Handler getHandler() {
        return this.mHandler;
    }

    Optional<DeviceState> getCommittedState() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        Optional<DeviceState> r1 = this.mCommittedState;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    Optional<DeviceState> getPendingState() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        Optional<DeviceState> r1 = this.mPendingState;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    Optional<DeviceState> getBaseState() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        Optional<DeviceState> r1 = this.mBaseState;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    Optional<DeviceState> getOverrideState() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mActiveOverride.isPresent() == false) goto L11;
        Optional<DeviceState> r1 = getStateLocked(this.mActiveOverride.get().getRequestedStateIdentifier());     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    L11:
        Optional<DeviceState> r2 = Optional.empty();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    }

    Optional<DeviceState> getOverrideBaseState() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mActiveBaseStateOverride.isPresent() == false) goto L11;
        Optional<DeviceState> r1 = getStateLocked(this.mActiveBaseStateOverride.get().getRequestedStateIdentifier());     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    L11:
        Optional<DeviceState> r2 = Optional.empty();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    }

    List<DeviceState> getSupportedStates() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        List<DeviceState> r1 = getSupportedStatesLocked();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private List<DeviceState> getSupportedStatesLocked() {
        List<DeviceState> supportedStates = new ArrayList(this.mDeviceStates.size());
        int i = 0;
    L4:
        if (i >= this.mDeviceStates.size()) goto L7;
        supportedStates.add(i, this.mDeviceStates.valueAt(i));
        i = i + 1;
        goto L4
    L7:
        return supportedStates;
    }

    private int[] getSupportedStateIdentifiersLocked() {
        int[] supportedStates = new int[this.mDeviceStates.size()];
        int i = 0;
    L4:
        if (i >= supportedStates.length) goto L7;
        supportedStates[i] = this.mDeviceStates.valueAt(i).getIdentifier();
        i = i + 1;
        goto L4
    L7:
        return supportedStates;
    }

    private DeviceStateInfo getDeviceStateInfoLocked() {
        List<DeviceState> supportedStates = getSupportedStatesLocked();
        DeviceState baseState = this.mBaseState.orElse(INVALID_DEVICE_STATE);
        DeviceState currentState = this.mCommittedState.orElse(INVALID_DEVICE_STATE);
        return new DeviceStateInfo(new ArrayList(supportedStates), baseState, createMergedDeviceState(currentState, baseState));
    }

    private DeviceState createMergedDeviceState(DeviceState committedState, DeviceState baseState) {
        if (committedState.equals(INVALID_DEVICE_STATE) == true) goto L5;
        Set<Integer> systemProperties = committedState.getConfiguration().getSystemProperties();
        Set<Integer> physicalProperties = baseState.getConfiguration().getPhysicalProperties();
        DeviceState.Configuration deviceStateConfiguration = new DeviceState.Configuration.Builder(committedState.getIdentifier(), committedState.getName()).setSystemProperties(systemProperties).setPhysicalProperties(physicalProperties).build();
        return new DeviceState(deviceStateConfiguration);
    L5:
        return INVALID_DEVICE_STATE;
    }

    IDeviceStateManager getBinderService() {
        return this.mBinderService;
    }

    IDeviceStateService getHalBinderService() {
        return this.mHalService;
    }

    private void updateSupportedStates(DeviceState[] supportedDeviceStates, int reason) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int[] oldStateIdentifiers = getSupportedStateIdentifiersLocked();     // Catch: Throwable -> L11
        boolean hasTerminalDeviceState = false;
        this.mDeviceStates.clear();     // Catch: Throwable -> L11
        int i = 0;
    L6:
        if (i >= supportedDeviceStates.length) goto L13;
        DeviceState state = supportedDeviceStates[i];     // Catch: Throwable -> L11
        if (state.hasProperty(4) == false) goto L10;
        hasTerminalDeviceState = true;
    L10:
        this.mDeviceStates.put(state.getIdentifier(), state);     // Catch: Throwable -> L11
        i = i + 1;     // Catch: Throwable -> L11
        goto L6
    L13:
        this.mOverrideRequestController.setStickyRequestsAllowed(hasTerminalDeviceState);     // Catch: Throwable -> L11
        int[] newStateIdentifiers = getSupportedStateIdentifiersLocked();     // Catch: Throwable -> L11
        if (Arrays.equals(oldStateIdentifiers, newStateIdentifiers) == false) goto L17;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L17:
        this.mOverrideRequestController.handleNewSupportedStates(newStateIdentifiers, reason);     // Catch: Throwable -> L11
        updatePendingStateLocked();     // Catch: Throwable -> L11
        notifyDeviceStateInfoChangedAsync();     // Catch: Throwable -> L11
        this.mHandler.post(new DeviceStateManagerService$$ExternalSyntheticLambda0(this));     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    private void setRearDisplayStateLocked() {
        int rearDisplayIdentifier = getContext().getResources().getInteger(R.integer.config_displayWhiteBalanceTransitionTime);
        if (rearDisplayIdentifier == (-1)) goto L6;
        this.mRearDisplayState = this.mDeviceStates.get(rearDisplayIdentifier);
        return;
    }

    private boolean isSupportedStateLocked(int identifier) {
        return this.mDeviceStates.contains(identifier);
    }

    private Optional<DeviceState> getStateLocked(int identifier) {
        return Optional.ofNullable(this.mDeviceStates.get(identifier));
    }

    private void setBaseState(int identifier) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        Optional<DeviceState> baseStateOptional = getStateLocked(identifier);     // Catch: Throwable -> L12
        if (baseStateOptional.isEmpty() == true) goto L24;
        DeviceState baseState = baseStateOptional.get();     // Catch: Throwable -> L12
        if (this.mBaseState.isPresent() == false) goto L15;
        if (this.mBaseState.get().equals(baseState) == false) goto L15;
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L15:
        if (this.mRearDisplayPendingOverrideRequest == null) goto L17;
        handleRearDisplayBaseStateChangedLocked(identifier);     // Catch: Throwable -> L12
    L17:
        this.mBaseState = Optional.of(baseState);     // Catch: Throwable -> L12
        if (baseState.hasProperty(4) == false) goto L20;
        this.mOverrideRequestController.cancelOverrideRequest();     // Catch: Throwable -> L12
    L20:
        this.mOverrideRequestController.handleBaseStateChanged(identifier);     // Catch: Throwable -> L12
        updatePendingStateLocked();     // Catch: Throwable -> L12
        notifyDeviceStateInfoChangedAsync();     // Catch: Throwable -> L12
        this.mHandler.post(new DeviceStateManagerService$$ExternalSyntheticLambda0(this));     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L24:
        throw new IllegalArgumentException("Base state is not supported");     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    private boolean updatePendingStateLocked() {
        if (this.mPendingState.isPresent() == false) goto L6;
        return false;
    L6:
        if (this.mActiveOverride.isPresent() == false) goto L9;
        DeviceState stateToConfigure = getStateLocked(this.mActiveOverride.get().getRequestedStateIdentifier()).get();
    L14:
        if (stateToConfigure != null) goto L17;
        return false;
    L17:
        if (this.mCommittedState.isPresent() == true) goto L19;
    L21:
        this.mPendingState = Optional.of(stateToConfigure);
        this.mIsPolicyWaitingForState = true;
        return true;
    L19:
        if (stateToConfigure.equals(this.mCommittedState.get()) == false) goto L21;
        return false;
    L9:
        if (this.mBaseState.isPresent() == true) goto L11;
    L13:
        stateToConfigure = null;
        goto L14
    L11:
        if (isSupportedStateLocked(this.mBaseState.get().getIdentifier()) == false) goto L13;
        stateToConfigure = this.mBaseState.get();
        goto L14
    }

    private void notifyPolicyIfNeeded() {
        if (Thread.holdsLock(this.mLock) == false) goto L5;
        Throwable error = new Throwable("Attempting to notify DeviceStatePolicy with service lock held");
        error.fillInStackTrace();
        Slog.w(TAG, error);
    L5:
        Object r0 = this.mLock;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L8:
        if (this.mIsPolicyWaitingForState == true) goto L13;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L13:
        this.mIsPolicyWaitingForState = false;     // Catch: Throwable -> L11
        int state = this.mPendingState.get().getIdentifier();     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        this.mDeviceStatePolicy.configureDeviceForState(state, new DeviceStateManagerService$$ExternalSyntheticLambda1(this));
    }

    private void commitPendingState() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        DeviceState newState = this.mPendingState.get();     // Catch: Throwable -> L15
        int r2 = newState.getIdentifier();     // Catch: Throwable -> L15
        if (this.mCommittedState.isPresent() == true) goto L7;
        boolean r3 = true;
    L8:
        FrameworkStatsLog.write(350, r2, r3);     // Catch: Throwable -> L15
        String traceString = newState.getIdentifier() + ":" + newState.getName();     // Catch: Throwable -> L15
        Trace.instantForTrack(524288, "DeviceStateChanged", traceString);     // Catch: Throwable -> L15
        this.mSystemPropertySetter.setDebugTracingDeviceStateProperty(traceString);     // Catch: Throwable -> L15
        this.mCommittedState = Optional.of(newState);     // Catch: Throwable -> L15
        this.mPendingState = Optional.empty();     // Catch: Throwable -> L15
        updatePendingStateLocked();     // Catch: Throwable -> L15
        notifyDeviceStateInfoChangedAsync();     // Catch: Throwable -> L15
        OverrideRequest activeRequest = this.mActiveOverride.orElse(null);     // Catch: Throwable -> L15
        if (activeRequest != null) goto L11;
    L17:
        this.mHandler.post(new DeviceStateManagerService$$ExternalSyntheticLambda0(this));     // Catch: Throwable -> L15
        monitor-exit(r0);     // Catch: Throwable -> L15
        return;
    L11:
        if (activeRequest.getRequestedStateIdentifier() != newState.getIdentifier()) goto L17;
        ProcessRecord processRecord = this.mProcessRecords.get(activeRequest.getPid());     // Catch: Throwable -> L15
        if (processRecord == null) goto L17;
        processRecord.notifyRequestActiveAsync(activeRequest.getToken());     // Catch: Throwable -> L15
        goto L17
    L7:
        r3 = false;
    L15:
        th = move-exception;
        throw th;
    }

    private void notifyDeviceStateInfoChangedAsync() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mPendingState.isPresent() == false) goto L12;
        Slog.i(TAG, "Cannot notify device state info change when pending state is present.");     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L12:
        if (this.mBaseState.isPresent() == false) goto L31;
        if (this.mCommittedState.isPresent() == false) goto L31;
        if (this.mProcessRecords.size() != 0) goto L20;
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L20:
        ArrayList<ProcessRecord> registeredProcesses = new ArrayList();     // Catch: Throwable -> L9
        int i = 0;
    L22:
        if (i >= this.mProcessRecords.size()) goto L24;
        registeredProcesses.add(this.mProcessRecords.valueAt(i));     // Catch: Throwable -> L9
        i = i + 1;     // Catch: Throwable -> L9
        goto L22
    L24:
        DeviceStateInfo info = getDeviceStateInfoLocked();     // Catch: Throwable -> L9
        int i2 = 0;
    L26:
        if (i2 >= registeredProcesses.size()) goto L29;
        registeredProcesses.get(i2).notifyDeviceStateInfoAsync(info);     // Catch: Throwable -> L9
        i2 = i2 + 1;     // Catch: Throwable -> L9
        goto L26
    L29:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L31:
        Slog.e(TAG, "Cannot notify device state info change before the initial state has been committed.");     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
    }

    private void onOverrideRequestStatusChangedLocked(OverrideRequest request, int status, int flags) {
        if (request.getRequestType() != 1) goto L15;
        switch(status) {
            case 1: goto L12;
            case 2: goto L8;
            default: goto L6;
        };
    L12:
        enableBaseStateRequestLocked(request);
        return;
    L6:
        throw new IllegalArgumentException("Unknown request status: " + status);
    L8:
        if (this.mActiveBaseStateOverride.isPresent() == true) goto L10;
    L30:
        boolean updatedPendingState = updatePendingStateLocked();
        ProcessRecord processRecord = this.mProcessRecords.get(request.getPid());
        if (processRecord != null) goto L34;
        this.mHandler.post(new DeviceStateManagerService$$ExternalSyntheticLambda0(this));
        return;
    L34:
        if (status != 1) goto L39;
        if (updatedPendingState == false) goto L37;
    L40:
        this.mHandler.post(new DeviceStateManagerService$$ExternalSyntheticLambda0(this));
        return;
    L37:
        if (this.mPendingState.isPresent() == true) goto L40;
        processRecord.notifyRequestActiveAsync(request.getToken());
        goto L40
    L39:
        processRecord.notifyRequestCanceledAsync(request.getToken());
        goto L40
    L10:
        if (this.mActiveBaseStateOverride.get() != request) goto L30;
        this.mActiveBaseStateOverride = Optional.empty();
        goto L30
    L15:
        if (request.getRequestType() != 0) goto L43;
        switch(status) {
            case 1: goto L29;
            case 2: goto L20;
            default: goto L18;
        };
    L29:
        this.mActiveOverride = Optional.of(request);
        this.mDeviceStateNotificationController.showStateActiveNotificationIfNeeded(request.getRequestedStateIdentifier(), request.getUid());
        goto L30
    L18:
        throw new IllegalArgumentException("Unknown request status: " + status);
    L20:
        if (this.mActiveOverride.isPresent() == false) goto L30;
        if (this.mActiveOverride.get() != request) goto L30;
        this.mActiveOverride = Optional.empty();
        this.mDeviceStateNotificationController.cancelNotification(request.getRequestedStateIdentifier());
        if ((flags & 1) != 1) goto L27;
        this.mDeviceStateNotificationController.showThermalCriticalNotificationIfNeeded(request.getRequestedStateIdentifier());
        goto L30
    L27:
        if ((flags & 2) != 2) goto L30;
        this.mDeviceStateNotificationController.showPowerSaveNotificationIfNeeded(request.getRequestedStateIdentifier());
        goto L30
    L43:
        throw new IllegalArgumentException("Unknown OverrideRest type: " + request.getRequestType());
    }

    private void enableBaseStateRequestLocked(OverrideRequest request) {
        setBaseState(request.getRequestedStateIdentifier());
        this.mActiveBaseStateOverride = Optional.of(request);
        ProcessRecord processRecord = this.mProcessRecords.get(request.getPid());
        processRecord.notifyRequestActiveAsync(request.getToken());
    }

    private DeviceStateInfo registerProcess(int pid, IDeviceStateManagerCallback callback) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mProcessRecords.contains(pid) == true) goto L21;
        ProcessRecord record = new ProcessRecord(callback, pid, new DeviceStateManagerService$$ExternalSyntheticLambda2(this), this.mHandler);     // Catch: Throwable -> L11
        callback.asBinder().linkToDeath(record, 0);     // Catch: Throwable -> L11 RemoteException -> L17
        this.mProcessRecords.put(pid, record);     // Catch: Throwable -> L11
        if (this.mCommittedState.isPresent() == false) goto L13;
        DeviceStateInfo currentInfo = getDeviceStateInfoLocked();     // Catch: Throwable -> L11
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return currentInfo;
    L13:
        currentInfo = null;
        goto L15
    L17:
        ex = move-exception;
        throw new RuntimeException(ex);     // Catch: Throwable -> L11
    L21:
        throw new SecurityException("The calling process has already registered an IDeviceStateManagerCallback.");     // Catch: Throwable -> L11
    }

    private void handleProcessDied(ProcessRecord processRecord) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mProcessRecords.remove(ProcessRecord.m3550$$Nest$fgetmPid(processRecord));     // Catch: Throwable -> L7
        this.mOverrideRequestController.handleProcessDied(ProcessRecord.m3550$$Nest$fgetmPid(processRecord));     // Catch: Throwable -> L7
        if (shouldCancelOverrideRequestWhenRequesterNotOnTop() == false) goto L9;
        OverrideRequest request = this.mActiveOverride.get();     // Catch: Throwable -> L7
        this.mOverrideRequestController.cancelRequest(request);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void requestStateInternal(int requestedState, int flags, int callingPid, int callingUid, IBinder token, boolean hasControlDeviceStatePermission) {
        Object r7 = this.mLock;
        monitor-enter(r7);
        ProcessRecord processRecord = this.mProcessRecords.get(callingPid);     // Catch: Throwable -> L30
        if (processRecord == null) goto L37;
        boolean shouldShowRdmEduDialog = false;
        if (this.mOverrideRequestController.hasRequest(token, 0) == true) goto L35;
        Optional<DeviceState> requestedDeviceState = getStateLocked(requestedState);     // Catch: Throwable -> L30
        if (requestedDeviceState.isEmpty() == true) goto L33;
        OverrideRequest request = new OverrideRequest(token, callingPid, callingUid, requestedDeviceState.get(), flags, 0);     // Catch: Throwable -> L30
        boolean isRequestingRdm = requestedDeviceState.get().hasProperty(16);     // Catch: Throwable -> L30
        boolean isRequestingRdmOuterDefault = requestedDeviceState.get().hasProperty(1001);     // Catch: Throwable -> L30
        if (this.mCommittedState.isEmpty() == false) goto L13;
        boolean isDeviceClosed = false;
    L15:
        if (isRequestingRdm == false) goto L24;
        if (shouldShowRdmEduDialog(hasControlDeviceStatePermission, isRequestingRdmOuterDefault, isDeviceClosed) == false) goto L24;
        shouldShowRdmEduDialog = true;
    L24:
        if (shouldShowRdmEduDialog == false) goto L26;
        showRearDisplayEducationalOverlayLocked(request);     // Catch: Throwable -> L20
    L28:
        monitor-exit(r7);     // Catch: Throwable -> L20
        return;
    L26:
        this.mOverrideRequestController.addRequest(request);     // Catch: Throwable -> L20
        goto L28
    L13:
        isDeviceClosed = this.mCommittedState.get().hasProperty(1);     // Catch: Throwable -> L30
        goto L15
    L33:
        throw new IllegalArgumentException("Requested state: " + requestedState + " is not supported.");     // Catch: Throwable -> L20
    L35:
        throw new IllegalStateException("Request has already been made for the supplied token: " + token);     // Catch: Throwable -> L20
    L37:
        throw new IllegalStateException("Process " + callingPid + " has no registered callback.");     // Catch: Throwable -> L20
    L20:
        th = th;
    L38:
        monitor-exit(r7);     // Catch: Throwable -> L20
        throw th;
    L30:
        th = th;
        goto L38
    }

    static boolean shouldShowRdmEduDialog(boolean hasControlDeviceStatePermission, boolean requestingRdmOuterDefault, boolean isDeviceClosed) {
        if (hasControlDeviceStatePermission == false) goto L5;
        return false;
    L5:
        if (requestingRdmOuterDefault == false) goto L7;
        return isDeviceClosed;
    L7:
        return true;
    }

    private void showRearDisplayEducationalOverlayLocked(OverrideRequest request) {
        this.mRearDisplayPendingOverrideRequest = request;
        StatusBarManagerInternal statusBar = (StatusBarManagerInternal) LocalServices.getService(StatusBarManagerInternal.class);
        if (statusBar == null) goto L6;
        statusBar.showRearDisplayDialog(this.mBaseState.get().getIdentifier());
        return;
    }

    private void cancelStateRequestInternal(int callingPid) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        ProcessRecord processRecord = this.mProcessRecords.get(callingPid);     // Catch: Throwable -> L9
        if (processRecord == null) goto L12;
        Optional<OverrideRequest> r2 = this.mActiveOverride;     // Catch: Throwable -> L9
        OverrideRequestController r3 = this.mOverrideRequestController;     // Catch: Throwable -> L9
        r3.getClass();     // Catch: Throwable -> L9
        r2.ifPresent(new DeviceStateManagerService$$ExternalSyntheticLambda4(r3));     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L12:
        throw new IllegalStateException("Process " + callingPid + " has no registered callback.");     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    private void requestBaseStateOverrideInternal(int state, int flags, int callingPid, int callingUid, IBinder token) {
        Object r8 = this.mLock;
        monitor-enter(r8);
        Optional<DeviceState> deviceState = getStateLocked(state);     // Catch: Throwable -> L13
        if (deviceState.isPresent() == false) goto L20;
        ProcessRecord processRecord = this.mProcessRecords.get(callingPid);     // Catch: Throwable -> L13
        if (processRecord == null) goto L18;
        if (this.mOverrideRequestController.hasRequest(token, 1) == true) goto L16;
        OverrideRequest request = new OverrideRequest(token, callingPid, callingUid, deviceState.get(), flags, 1);     // Catch: Throwable -> L13
        this.mOverrideRequestController.addBaseStateRequest(request);     // Catch: Throwable -> L13
        monitor-exit(r8);     // Catch: Throwable -> L13
        return;
    L16:
        throw new IllegalStateException("Request has already been made for the supplied token: " + token);     // Catch: Throwable -> L13
    L18:
        throw new IllegalStateException("Process " + callingPid + " has no registered callback.");     // Catch: Throwable -> L13
    L20:
        throw new IllegalArgumentException("Requested state: " + state + " is not supported.");     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    private void cancelBaseStateOverrideInternal(int callingPid) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        ProcessRecord processRecord = this.mProcessRecords.get(callingPid);     // Catch: Throwable -> L9
        if (processRecord == null) goto L12;
        setBaseState(this.mDeviceStateProviderListener.mCurrentBaseState);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L12:
        throw new IllegalStateException("Process " + callingPid + " has no registered callback.");     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    private void onStateRequestOverlayDismissedInternal(boolean shouldCancelRequest) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mRearDisplayPendingOverrideRequest == null) goto L12;
        if (shouldCancelRequest == false) goto L10;
        ProcessRecord processRecord = this.mProcessRecords.get(this.mRearDisplayPendingOverrideRequest.getPid());     // Catch: Throwable -> L8
        processRecord.notifyRequestCanceledAsync(this.mRearDisplayPendingOverrideRequest.getToken());     // Catch: Throwable -> L8
    L11:
        this.mRearDisplayPendingOverrideRequest = null;     // Catch: Throwable -> L8
        goto L12
    L10:
        this.mOverrideRequestController.addRequest(this.mRearDisplayPendingOverrideRequest);     // Catch: Throwable -> L8
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L8
    }

    private void dumpInternal(PrintWriter pw) {
        pw.println("DEVICE STATE MANAGER (dumpsys device_state)");
        Object r0 = this.mLock;
        monitor-enter(r0);
        pw.println("  mCommittedState=" + this.mCommittedState);     // Catch: Throwable -> L7
        pw.println("  mPendingState=" + this.mPendingState);     // Catch: Throwable -> L7
        pw.println("  mBaseState=" + this.mBaseState);     // Catch: Throwable -> L7
        pw.println("  mOverrideState=" + getOverrideState());     // Catch: Throwable -> L7
        int processCount = this.mProcessRecords.size();     // Catch: Throwable -> L7
        pw.println();     // Catch: Throwable -> L7
        pw.println("Registered processes: size=" + processCount);     // Catch: Throwable -> L7
        int i = 0;
    L5:
        if (i >= processCount) goto L9;
        ProcessRecord processRecord = this.mProcessRecords.valueAt(i);     // Catch: Throwable -> L7
        pw.println("  " + i + ": mPid=" + ProcessRecord.m3550$$Nest$fgetmPid(processRecord));     // Catch: Throwable -> L7
        i = i + 1;     // Catch: Throwable -> L7
        goto L5
    L9:
        this.mOverrideRequestController.dumpInternal(pw);     // Catch: Throwable -> L7
        pw.println();     // Catch: Throwable -> L7
        this.mDeviceStatePolicy.dump(pw, null);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void enforceRequestDeviceStatePermitted(int callingPid, int callingUid, int state) {
        boolean isTopApp = isTopApp(callingPid);
        boolean isForegroundApp = isForegroundApp(callingPid, callingUid);
        boolean isStateAvailableForAppRequests = isStateAvailableForAppRequests(state);
        if (isTopApp == false) goto L7;
        if (isForegroundApp == false) goto L7;
        if (isStateAvailableForAppRequests == false) goto L7;
        boolean isAllowedToRequestState = true;
    L8:
        if (isAllowedToRequestState == true) goto L11;
        getContext().enforceCallingOrSelfPermission("android.permission.CONTROL_DEVICE_STATE", "Permission required to request device state, or the call must come from the top app and be a device state that is available for apps to request.");
        return;
    L11:
        return;
    L7:
        isAllowedToRequestState = false;
        goto L8
    }

    private void enforceCancelDeviceStatePermitted(int callingPid, int callingUid) {
        boolean isTopApp = isTopApp(callingPid);
        boolean isForegroundApp = isForegroundApp(callingPid, callingUid);
        boolean r2 = false;
        if (isTopApp == false) goto L7;
        if (isForegroundApp == true) goto L7;
    L7:
        Object r5 = this.mLock;
        monitor-enter(r5);
        if (isTopApp == true) goto L17;
        if (isForegroundApp == false) goto L18;
    L14:
        th = move-exception;
        throw th;
    L12:
        if (doCallingIdsMatchOverrideRequestIdsLocked(callingPid, callingUid) == true) goto L17;
    L18:
        boolean isAllowedToControlState = r2;
        monitor-exit(r5);     // Catch: Throwable -> L14
        if (isAllowedToControlState == true) goto L27;
        getContext().enforceCallingOrSelfPermission("android.permission.CONTROL_DEVICE_STATE", "Permission required to request device state, or the call must come from the top app.");
        return;
    L27:
        return;
    L17:
        r2 = true;
        goto L18
    }

    private boolean isForegroundApp(int callingPid, int callingUid) {
        List<ActivityManager.RunningAppProcessInfo> procs = ActivityManager.getService().getRunningAppProcesses();     // Catch: RemoteException -> L14
        int i = 0;
    L4:
        if (i >= procs.size()) goto L28;
        ActivityManager.RunningAppProcessInfo proc = procs.get(i);     // Catch: RemoteException -> L14
        if (proc.pid != callingPid) goto L16;
        if (proc.uid != callingUid) goto L16;
        if (proc.importance > 100) goto L16;
        return true;
    L16:
        i = i + 1;
        goto L4
    L28:
        return false;
    L14:
        e = move-exception;
        Slog.w(TAG, "am.getRunningAppProcesses() failed", e);
        return false;
    }

    private boolean isTopApp(int callingPid) {
        WindowProcessController topApp = this.mActivityTaskManagerInternal.getTopApp();
        if (topApp != null) goto L5;
    L7:
        return false;
    L5:
        if (topApp.getPid() != callingPid) goto L7;
        return true;
    }

    private boolean doCallingIdsMatchOverrideRequestIdsLocked(int callingPid, int callingUid) {
        OverrideRequest request = this.mActiveOverride.orElse(null);
        if (request != null) goto L5;
    L9:
        return false;
    L5:
        if (request.getPid() != callingPid) goto L9;
        if (request.getUid() != callingUid) goto L9;
        return true;
    }

    private boolean isStateAvailableForAppRequests(int state) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        Optional<DeviceState> deviceState = getStateLocked(state);     // Catch: Throwable -> L9
        if (deviceState.isPresent() == true) goto L7;
    L11:
        boolean r2 = false;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L7:
        if (deviceState.get().hasProperty(8) == false) goto L11;
        r2 = true;
    L9:
        th = move-exception;
        throw th;
    }

    private void readStatesAvailableForRequestFromApps() {
        String[] availableAppStatesConfigIdentifiers = getContext().getResources().getStringArray(R.array.config_displayWhiteBalanceDisplayColorTemperatures);
        int i = 0;
    L4:
        if (i >= availableAppStatesConfigIdentifiers.length) goto L11;
        String identifierToFetch = availableAppStatesConfigIdentifiers[i];
        int configValueIdentifier = getContext().getResources().getIdentifier(identifierToFetch, "integer", PackageManagerService.PLATFORM_PACKAGE_NAME);
        int state = getContext().getResources().getInteger(configValueIdentifier);
        if (isValidState(state) == false) goto L8;
        this.mDeviceStatesAvailableForAppRequests.add(Integer.valueOf(state));
    L9:
        i = i + 1;
        goto L4
    L8:
        Slog.e(TAG, "Invalid device state was found in the configuration file. State id: " + state);
        goto L9
    }

    private Set<Integer> readFoldedStates() {
        Set<Integer> foldedStates = new HashSet();
        int[] mFoldedStatesArray = getContext().getResources().getIntArray(R.array.config_locationExtraPackageNames);
        int i = 0;
    L4:
        if (i >= mFoldedStatesArray.length) goto L7;
        foldedStates.add(Integer.valueOf(mFoldedStatesArray[i]));
        i = i + 1;
        goto L4
    L7:
        return foldedStates;
    }

    private boolean isValidState(int state) {
        int i = 0;
    L4:
        if (i >= this.mDeviceStates.size()) goto L10;
        if (state == this.mDeviceStates.valueAt(i).getIdentifier()) goto L7;
        i = i + 1;
        goto L4
    L7:
        return true;
    L10:
        return false;
    }

    private void handleRearDisplayBaseStateChangedLocked(int newBaseState) {
        if (isDeviceOpeningLocked(newBaseState) == false) goto L6;
        onStateRequestOverlayDismissedInternal(false);
        return;
    }

    private boolean isDeviceOpeningLocked(int newBaseState) {
        DeviceState currentBaseState = this.mBaseState.orElse(INVALID_DEVICE_STATE);
        DeviceState newDeviceBaseState = getStateLocked(newBaseState).orElse(INVALID_DEVICE_STATE);
        if (currentBaseState.hasProperty(11) == true) goto L5;
    L7:
        return false;
    L5:
        if (newDeviceBaseState.hasProperty(11) == true) goto L7;
        return true;
    }

    private /* synthetic */ boolean lambda$isDeviceOpeningLocked$2(int newBaseState, DeviceState deviceState) {
        if (this.mFoldedDeviceStates.contains(Integer.valueOf(deviceState.getIdentifier())) == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mFoldedDeviceStates.contains(Integer.valueOf(newBaseState)) == true) goto L7;
        return true;
    }

    private boolean shouldCancelOverrideRequestWhenRequesterNotOnTop() {
        if (this.mActiveOverride.isEmpty() == false) goto L6;
        return false;
    L6:
        int identifier = this.mActiveOverride.get().getRequestedStateIdentifier();
        DeviceState deviceState = this.mDeviceStates.get(identifier);
        return deviceState.hasProperty(5);
    }
}
