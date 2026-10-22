package com.android.server.sensorprivacy;

import android.R;
import android.app.ActivityManager;
import android.app.ActivityManagerInternal;
import android.app.ActivityOptions;
import android.app.ActivityTaskManager;
import android.app.AppOpsManager;
import android.app.AppOpsManagerInternal;
import android.app.KeyguardManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.PackageManagerInternal;
import android.graphics.drawable.Icon;
import android.hardware.ISensorPrivacyListener;
import android.hardware.ISensorPrivacyManager;
import android.hardware.SensorPrivacyManager;
import android.hardware.SensorPrivacyManagerInternal;
import android.hardware.audio.common.V2_0.AudioFormat;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.ShellCallback;
import android.os.SystemClock;
import android.os.UserHandle;
import android.os.UserManager;
import android.provider.Settings;
import android.safetycenter.SafetyCenterManager;
import android.service.voice.VoiceInteractionManagerInternal;
import android.telephony.TelephonyCallback;
import android.telephony.TelephonyManager;
import android.telephony.emergency.EmergencyNumber;
import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.IndentingPrintWriter;
import android.util.Log;
import android.util.Pair;
import android.util.proto.ProtoOutputStream;
import com.android.internal.os.BackgroundThread;
import com.android.internal.util.DumpUtils;
import com.android.internal.util.FrameworkStatsLog;
import com.android.internal.util.FunctionalUtils;
import com.android.internal.util.dump.DualDumpOutputStream;
import com.android.internal.util.function.pooled.PooledLambda;
import com.android.server.FgThread;
import com.android.server.LocalServices;
import com.android.server.SystemConfig;
import com.android.server.SystemService;
import com.android.server.am.ProcessList;
import com.android.server.pm.PackageManagerService;
import com.android.server.pm.UserManagerInternal;
import com.android.server.slice.SliceClientPermissions;
import com.android.server.storage.DeviceStorageMonitorServiceSmtEx;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class SensorPrivacyService extends SystemService {
    private static final String ACTION_DISABLE_TOGGLE_SENSOR_PRIVACY = null;
    private static final int ACTION__ACTION_UNKNOWN = 0;
    private static final int ACTION__TOGGLE_OFF = 2;
    private static final int ACTION__TOGGLE_ON = 1;
    private static final int ACTION__TOGGLE_ON_EXCEPT_ALLOWLISTED_APPS = 3;
    private static final boolean DEBUG = false;
    private static final boolean DEBUG_LOGGING = false;
    public static final int REMINDER_DIALOG_DELAY_MILLIS = 500;
    private static final String SENSOR_PRIVACY_CHANNEL_ID = "sensor_privacy";
    private static final String TAG = null;
    private final ActivityManager mActivityManager;
    private final ActivityManagerInternal mActivityManagerInternal;
    private final ActivityTaskManager mActivityTaskManager;
    private final AppOpsManager mAppOpsManager;
    private final AppOpsManagerInternal mAppOpsManagerInternal;
    private final IBinder mAppOpsRestrictionToken;
    private CallStateHelper mCallStateHelper;
    List<String> mCameraPrivacyAllowlist;
    private CameraPrivacyLightController mCameraPrivacyLightController;
    private final Context mContext;
    private int mCurrentUser;
    private KeyguardManager mKeyguardManager;
    private final NotificationManager mNotificationManager;
    private final PackageManagerInternal mPackageManagerInternal;
    private SensorPrivacyManagerInternalImpl mSensorPrivacyManagerInternal;
    private final SensorPrivacyServiceImpl mSensorPrivacyServiceImpl;
    private final TelephonyManager mTelephonyManager;
    private final UserManager mUserManager;
    private final UserManagerInternal mUserManagerInternal;

    private class CallStateHelper {
        private final CallStateCallback mCallStateCallback;
        private Object mCallStateLock;
        private final OutgoingEmergencyStateCallback mEmergencyStateCallback;
        private boolean mIsInEmergencyCall;
        private boolean mMicUnmutedForEmergencyCall;
        final /* synthetic */ SensorPrivacyService this$0;

        private class CallStateCallback extends TelephonyCallback implements TelephonyCallback.CallStateListener {
            final /* synthetic */ CallStateHelper this$1;

            /* synthetic */ CallStateCallback(CallStateHelper r1, SensorPrivacyServiceIA r2) {
                this(r1);
            }

            private CallStateCallback(CallStateHelper r1) {
                this.this$1 = r1;
            }

            @Override // android.telephony.TelephonyCallback.CallStateListener
            public void onCallStateChanged(int state) {
                if (state != 0) goto L4;
                CallStateHelper.m8108$$Nest$monCallOver(this.this$1);
                return;
            L4:
                CallStateHelper.m8107$$Nest$monCall(this.this$1);
            }
        }

        private class OutgoingEmergencyStateCallback extends TelephonyCallback implements TelephonyCallback.OutgoingEmergencyCallListener {
            final /* synthetic */ CallStateHelper this$1;

            /* synthetic */ OutgoingEmergencyStateCallback(CallStateHelper r1, SensorPrivacyServiceIA r2) {
                this(r1);
            }

            private OutgoingEmergencyStateCallback(CallStateHelper r1) {
                this.this$1 = r1;
            }

            public void onOutgoingEmergencyCall(EmergencyNumber placedEmergencyNumber, int subscriptionId) {
                CallStateHelper.m8109$$Nest$monEmergencyCall(this.this$1);
            }
        }

        /* JADX INFO: renamed from: -$$Nest$monCall, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m8107$$Nest$monCall(CallStateHelper r0) {
            r0.onCall();
        }

        /* JADX INFO: renamed from: -$$Nest$monCallOver, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m8108$$Nest$monCallOver(CallStateHelper r0) {
            r0.onCallOver();
        }

        /* JADX INFO: renamed from: -$$Nest$monEmergencyCall, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m8109$$Nest$monEmergencyCall(CallStateHelper r0) {
            r0.onEmergencyCall();
        }

        CallStateHelper(SensorPrivacyService r4) {
            this.this$0 = r4;
            this.mCallStateLock = new Object();
            SensorPrivacyServiceIA r1 = null;
            this.mEmergencyStateCallback = new OutgoingEmergencyStateCallback(this, r1);
            this.mCallStateCallback = new CallStateCallback(this, r1);
            SensorPrivacyService.m8101$$Nest$fgetmTelephonyManager(r4).registerTelephonyCallback(FgThread.getExecutor(), this.mEmergencyStateCallback);
            SensorPrivacyService.m8101$$Nest$fgetmTelephonyManager(r4).registerTelephonyCallback(FgThread.getExecutor(), this.mCallStateCallback);
        }

        boolean isInEmergencyCall() {
            Object r0 = this.mCallStateLock;
            monitor-enter(r0);
            boolean r1 = this.mIsInEmergencyCall;     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        private void onEmergencyCall() {
            Object r1 = this.mCallStateLock;
            monitor-enter(r1);
        L9:
            th = move-exception;
            throw th;
        L5:
            if (this.mIsInEmergencyCall == true) goto L12;
            this.mIsInEmergencyCall = true;     // Catch: Throwable -> L9
            if (SensorPrivacyService.m8100$$Nest$fgetmSensorPrivacyServiceImpl(this.this$0).isToggleSensorPrivacyEnabled(1, 1) == false) goto L11;
            SensorPrivacyServiceImpl.m8127$$Nest$msetToggleSensorPrivacyUnchecked(SensorPrivacyService.m8100$$Nest$fgetmSensorPrivacyServiceImpl(this.this$0), 1, SensorPrivacyService.m8095$$Nest$fgetmCurrentUser(this.this$0), 5, 1, false);     // Catch: Throwable -> L9
            this.mMicUnmutedForEmergencyCall = true;     // Catch: Throwable -> L9
            goto L12
        L11:
            this.mMicUnmutedForEmergencyCall = false;     // Catch: Throwable -> L9
        L12:
            monitor-exit(r1);     // Catch: Throwable -> L9
        }

        private void onCall() {
            long token = Binder.clearCallingIdentity();
            Object r2 = this.mCallStateLock;     // Catch: Throwable -> L12
            monitor-enter(r2);     // Catch: Throwable -> L12
            SensorPrivacyService.m8100$$Nest$fgetmSensorPrivacyServiceImpl(this.this$0).showSensorUseDialog(1);     // Catch: Throwable -> L9
            monitor-exit(r2);     // Catch: Throwable -> L9
            Binder.restoreCallingIdentity(token);
            return;
        L9:
            th = move-exception;
            throw th;     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        }

        private void onCallOver() {
            Object r1 = this.mCallStateLock;
            monitor-enter(r1);
        L9:
            th = move-exception;
            throw th;
        L5:
            if (this.mIsInEmergencyCall == false) goto L11;
            this.mIsInEmergencyCall = false;     // Catch: Throwable -> L9
            if (this.mMicUnmutedForEmergencyCall == false) goto L11;
            SensorPrivacyServiceImpl.m8127$$Nest$msetToggleSensorPrivacyUnchecked(SensorPrivacyService.m8100$$Nest$fgetmSensorPrivacyServiceImpl(this.this$0), 1, SensorPrivacyService.m8095$$Nest$fgetmCurrentUser(this.this$0), 5, 1, true);     // Catch: Throwable -> L9
            this.mMicUnmutedForEmergencyCall = false;     // Catch: Throwable -> L9
        L11:
            monitor-exit(r1);     // Catch: Throwable -> L9
        }
    }

    private final class DeathRecipient implements IBinder.DeathRecipient {
        private ISensorPrivacyListener mListener;
        final /* synthetic */ SensorPrivacyService this$0;

        DeathRecipient(SensorPrivacyService r2, ISensorPrivacyListener listener) {
            this.this$0 = r2;
            this.mListener = listener;
            this.mListener.asBinder().linkToDeath(this, 0);     // Catch: RemoteException -> L5
            return;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            SensorPrivacyService.m8100$$Nest$fgetmSensorPrivacyServiceImpl(this.this$0).removeSensorPrivacyListener(this.mListener);
            SensorPrivacyService.m8100$$Nest$fgetmSensorPrivacyServiceImpl(this.this$0).removeToggleSensorPrivacyListener(this.mListener);
        }

        public void destroy() {
            this.mListener.asBinder().unlinkToDeath(this, 0);     // Catch: NoSuchElementException -> L4
            return;
        }
    }

    private final class SensorPrivacyHandler extends Handler {
        private static final int MESSAGE_SENSOR_PRIVACY_CHANGED = 1;
        private final Context mContext;
        private final ArrayMap<ISensorPrivacyListener, Pair<DeathRecipient, Integer>> mDeathRecipients;
        private final Object mListenerLock;
        private final RemoteCallbackList<ISensorPrivacyListener> mListeners;
        private final RemoteCallbackList<ISensorPrivacyListener> mToggleSensorListeners;
        final /* synthetic */ SensorPrivacyService this$0;

        public static /* synthetic */ void $r8$lambda$OKZvWBt8WC0Nj8p34zZxdNBKwOg(SensorPrivacyServiceImpl r0, Pair r1, IBinder r2) {
            SensorPrivacyServiceImpl.m8124$$Nest$mremoveSuppressPackageReminderToken(r0, r1, r2);
        }

        SensorPrivacyHandler(SensorPrivacyService r1, Looper looper, Context context) {
            this.this$0 = r1;
            super(looper);
            this.mListenerLock = new Object();
            this.mListeners = new RemoteCallbackList();
            this.mToggleSensorListeners = new RemoteCallbackList();
            this.mDeathRecipients = new ArrayMap();
            this.mContext = context;
        }

        public void addListener(ISensorPrivacyListener listener) {
            Object r0 = this.mListenerLock;
            monitor-enter(r0);
        L7:
            th = move-exception;
            throw th;
        L5:
            if (this.mListeners.register(listener) == false) goto L9;
            addDeathRecipient(listener);     // Catch: Throwable -> L7
        L9:
            monitor-exit(r0);     // Catch: Throwable -> L7
        }

        public void addToggleListener(ISensorPrivacyListener listener) {
            Object r0 = this.mListenerLock;
            monitor-enter(r0);
        L7:
            th = move-exception;
            throw th;
        L5:
            if (this.mToggleSensorListeners.register(listener) == false) goto L9;
            addDeathRecipient(listener);     // Catch: Throwable -> L7
        L9:
            monitor-exit(r0);     // Catch: Throwable -> L7
        }

        public void removeListener(ISensorPrivacyListener listener) {
            Object r0 = this.mListenerLock;
            monitor-enter(r0);
        L7:
            th = move-exception;
            throw th;
        L5:
            if (this.mListeners.unregister(listener) == false) goto L9;
            removeDeathRecipient(listener);     // Catch: Throwable -> L7
        L9:
            monitor-exit(r0);     // Catch: Throwable -> L7
        }

        public void removeToggleListener(ISensorPrivacyListener listener) {
            Object r0 = this.mListenerLock;
            monitor-enter(r0);
        L7:
            th = move-exception;
            throw th;
        L5:
            if (this.mToggleSensorListeners.unregister(listener) == false) goto L9;
            removeDeathRecipient(listener);     // Catch: Throwable -> L7
        L9:
            monitor-exit(r0);     // Catch: Throwable -> L7
        }

        public void handleSensorPrivacyChanged(boolean enabled) {
            int count = this.mListeners.beginBroadcast();
            int i = 0;
        L3:
            if (i >= count) goto L10;
            ISensorPrivacyListener listener = this.mListeners.getBroadcastItem(i);
            listener.onSensorPrivacyChanged(-1, -1, enabled);     // Catch: RemoteException -> L7
        L9:
            i = i + 1;
        L7:
            e = move-exception;
            Log.e(SensorPrivacyService.m8106$$Nest$sfgetTAG(), "Caught an exception notifying listener " + listener + ": ", e);
            goto L9
        L10:
            this.mListeners.finishBroadcast();
        }

        public void handleSensorPrivacyChanged(int userId, int toggleType, int sensor, boolean enabled) {
            SensorPrivacyManagerInternalImpl.m8110$$Nest$mdispatch(SensorPrivacyService.m8099$$Nest$fgetmSensorPrivacyManagerInternal(this.this$0), userId, sensor, enabled);
            if (userId != SensorPrivacyService.m8095$$Nest$fgetmCurrentUser(this.this$0)) goto L6;
            SensorPrivacyServiceImpl.m8126$$Nest$msetGlobalRestriction(SensorPrivacyService.m8100$$Nest$fgetmSensorPrivacyServiceImpl(this.this$0), sensor, SensorPrivacyService.m8100$$Nest$fgetmSensorPrivacyServiceImpl(this.this$0).isCombinedToggleSensorPrivacyEnabled(sensor));
        L6:
            if (userId == SensorPrivacyService.m8095$$Nest$fgetmCurrentUser(this.this$0)) goto L8;
            return;
        L8:
            Object r0 = this.mListenerLock;
            monitor-enter(r0);
            int count = this.mToggleSensorListeners.beginBroadcast();     // Catch: Throwable -> L15
            int i = 0;
        L11:
            if (i >= count) goto L21;
            ISensorPrivacyListener listener = this.mToggleSensorListeners.getBroadcastItem(i);     // Catch: Throwable -> L15
        L33:
            listener.onSensorPrivacyChanged(toggleType, sensor, enabled);     // Catch: Throwable -> L15 RemoteException -> L17
        L19:
            i = i + 1;
        L17:
            e = move-exception;
            Log.e(SensorPrivacyService.m8106$$Nest$sfgetTAG(), "Caught an exception notifying listener " + listener + ": ", e);     // Catch: Throwable -> L15
            goto L19
        L21:
            this.mToggleSensorListeners.finishBroadcast();     // Catch: Throwable -> L25
            monitor-exit(r0);     // Catch: Throwable -> L25
            SensorPrivacyServiceImpl.m8128$$Nest$mshowSensorStateChangedActivity(SensorPrivacyService.m8100$$Nest$fgetmSensorPrivacyServiceImpl(this.this$0), sensor, toggleType);
            return;
        L15:
            th = move-exception;
            this.mToggleSensorListeners.finishBroadcast();     // Catch: Throwable -> L25
            throw th;     // Catch: Throwable -> L25
        L25:
            th = move-exception;
            throw th;
        }

        public void handleSensorPrivacyChanged(int userId, int toggleType, int sensor, int state) {
            if (userId != SensorPrivacyService.m8095$$Nest$fgetmCurrentUser(this.this$0)) goto L6;
            SensorPrivacyServiceImpl.m8126$$Nest$msetGlobalRestriction(SensorPrivacyService.m8100$$Nest$fgetmSensorPrivacyServiceImpl(this.this$0), sensor, SensorPrivacyService.m8100$$Nest$fgetmSensorPrivacyServiceImpl(this.this$0).isCombinedToggleSensorPrivacyEnabled(sensor));
        L6:
            if (userId == SensorPrivacyService.m8095$$Nest$fgetmCurrentUser(this.this$0)) goto L8;
            return;
        L8:
            Object r0 = this.mListenerLock;
            monitor-enter(r0);
            int count = this.mToggleSensorListeners.beginBroadcast();     // Catch: Throwable -> L15
            int i = 0;
        L11:
            if (i >= count) goto L21;
            ISensorPrivacyListener listener = this.mToggleSensorListeners.getBroadcastItem(i);     // Catch: Throwable -> L15
            listener.onSensorPrivacyStateChanged(toggleType, sensor, state);     // Catch: Throwable -> L15 RemoteException -> L17
        L19:
            i = i + 1;
        L17:
            e = move-exception;
            Log.e(SensorPrivacyService.m8106$$Nest$sfgetTAG(), "Caught an exception notifying listener " + listener + ": ", e);     // Catch: Throwable -> L15
            goto L19
        L21:
            this.mToggleSensorListeners.finishBroadcast();     // Catch: Throwable -> L25
            monitor-exit(r0);     // Catch: Throwable -> L25
            SensorPrivacyServiceImpl.m8128$$Nest$mshowSensorStateChangedActivity(SensorPrivacyService.m8100$$Nest$fgetmSensorPrivacyServiceImpl(this.this$0), sensor, toggleType);
            return;
        L25:
            th = move-exception;
            throw th;
        L15:
            th = move-exception;
            this.mToggleSensorListeners.finishBroadcast();     // Catch: Throwable -> L25
            throw th;     // Catch: Throwable -> L25
        }

        public void removeSuppressPackageReminderToken(Pair<Integer, UserHandle> key, IBinder token) {
            sendMessage(PooledLambda.obtainMessage(new SensorPrivacyService$SensorPrivacyHandler$$ExternalSyntheticLambda0(), SensorPrivacyService.m8100$$Nest$fgetmSensorPrivacyServiceImpl(this.this$0), key, token));
        }

        private void addDeathRecipient(ISensorPrivacyListener listener) {
            Pair<DeathRecipient, Integer> deathRecipient = this.mDeathRecipients.get(listener);
            if (deathRecipient != null) goto L5;
            Pair<DeathRecipient, Integer> deathRecipient2 = new Pair(new DeathRecipient(this.this$0, listener), 1);
        L6:
            this.mDeathRecipients.put(listener, deathRecipient2);
            return;
        L5:
            int newRefCount = ((Integer) deathRecipient.second).intValue() + 1;
            deathRecipient2 = new Pair((DeathRecipient) deathRecipient.first, Integer.valueOf(newRefCount));
            goto L6
        }

        private void removeDeathRecipient(ISensorPrivacyListener listener) {
            Pair<DeathRecipient, Integer> deathRecipient = this.mDeathRecipients.get(listener);
            if (deathRecipient != null) goto L5;
            return;
        L5:
            int newRefCount = ((Integer) deathRecipient.second).intValue() - 1;
            if (newRefCount != 0) goto L9;
            this.mDeathRecipients.remove(listener);
            ((DeathRecipient) deathRecipient.first).destroy();
            return;
        L9:
            this.mDeathRecipients.put(listener, new Pair((DeathRecipient) deathRecipient.first, Integer.valueOf(newRefCount)));
        }
    }

    private class SensorPrivacyManagerInternalImpl extends SensorPrivacyManagerInternal {
        private ArrayMap<Integer, ArraySet<SensorPrivacyManagerInternal.OnUserSensorPrivacyChangedListener>> mAllUserListeners;
        private ArrayMap<Integer, ArrayMap<Integer, ArraySet<SensorPrivacyManagerInternal.OnSensorPrivacyChangedListener>>> mListeners;
        private final Object mLock;
        final /* synthetic */ SensorPrivacyService this$0;

        public static /* synthetic */ void $r8$lambda$6c5oG3NqTqZpXs8uPF7TL16NWZ0(SensorPrivacyManagerInternal.OnUserSensorPrivacyChangedListener r0, int r1, boolean r2) {
            lambda$dispatch$0(r0, r1, r2);
        }

        public static /* synthetic */ void $r8$lambda$7htxO0TQE822gNYNCZBrofa0MdU(SensorPrivacyManagerInternal.OnSensorPrivacyChangedListener r0, boolean r1) {
            lambda$dispatch$1(r0, r1);
        }

        /* JADX INFO: renamed from: -$$Nest$mdispatch, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m8110$$Nest$mdispatch(SensorPrivacyManagerInternalImpl r0, int r1, int r2, boolean r3) {
            r0.dispatch(r1, r2, r3);
        }

        /* synthetic */ SensorPrivacyManagerInternalImpl(SensorPrivacyService r1, SensorPrivacyServiceIA r2) {
            this(r1);
        }

        private SensorPrivacyManagerInternalImpl(SensorPrivacyService r1) {
            this.this$0 = r1;
            this.mListeners = new ArrayMap();
            this.mAllUserListeners = new ArrayMap();
            this.mLock = new Object();
        }

        private void dispatch(final int userId, int sensor, final boolean enabled) {
            Object r0 = this.mLock;
            monitor-enter(r0);
            ArraySet<SensorPrivacyManagerInternal.OnUserSensorPrivacyChangedListener> allUserSensorListeners = this.mAllUserListeners.get(Integer.valueOf(sensor));     // Catch: Throwable -> L10
            if (allUserSensorListeners == null) goto L12;
            int i = 0;
        L8:
            if (i >= allUserSensorListeners.size()) goto L12;
            final SensorPrivacyManagerInternal.OnUserSensorPrivacyChangedListener listener = allUserSensorListeners.valueAt(i);     // Catch: Throwable -> L10
            BackgroundThread.getHandler().post(new SensorPrivacyService$SensorPrivacyManagerInternalImpl$$ExternalSyntheticLambda0(listener, userId, enabled));     // Catch: Throwable -> L10
            i = i + 1;     // Catch: Throwable -> L10
        L12:
            ArrayMap<Integer, ArraySet<SensorPrivacyManagerInternal.OnSensorPrivacyChangedListener>> userSensorListeners = this.mListeners.get(Integer.valueOf(userId));     // Catch: Throwable -> L10
            if (userSensorListeners == null) goto L20;
            ArraySet<SensorPrivacyManagerInternal.OnSensorPrivacyChangedListener> sensorListeners = userSensorListeners.get(Integer.valueOf(sensor));     // Catch: Throwable -> L10
            if (sensorListeners == null) goto L20;
            int i2 = 0;
        L18:
            if (i2 >= sensorListeners.size()) goto L20;
            final SensorPrivacyManagerInternal.OnSensorPrivacyChangedListener listener2 = sensorListeners.valueAt(i2);     // Catch: Throwable -> L10
            BackgroundThread.getHandler().post(new SensorPrivacyService$SensorPrivacyManagerInternalImpl$$ExternalSyntheticLambda1(listener2, enabled));     // Catch: Throwable -> L10
            i2 = i2 + 1;     // Catch: Throwable -> L10
        L20:
            monitor-exit(r0);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            throw th;
        }

        private static /* synthetic */ void lambda$dispatch$0(SensorPrivacyManagerInternal.OnUserSensorPrivacyChangedListener listener, int userId, boolean enabled) {
            listener.onSensorPrivacyChanged(userId, enabled);
        }

        private static /* synthetic */ void lambda$dispatch$1(SensorPrivacyManagerInternal.OnSensorPrivacyChangedListener listener, boolean enabled) {
            listener.onSensorPrivacyChanged(enabled);
        }

        public boolean isSensorPrivacyEnabled(int userId, int sensor) {
            return SensorPrivacyServiceImpl.m8121$$Nest$misToggleSensorPrivacyEnabledInternal(SensorPrivacyService.m8100$$Nest$fgetmSensorPrivacyServiceImpl(this.this$0), userId, 1, sensor);
        }

        public void addSensorPrivacyListener(int userId, int sensor, SensorPrivacyManagerInternal.OnSensorPrivacyChangedListener listener) {
            Object r0 = this.mLock;
            monitor-enter(r0);
            ArrayMap<Integer, ArraySet<SensorPrivacyManagerInternal.OnSensorPrivacyChangedListener>> userSensorListeners = this.mListeners.get(Integer.valueOf(userId));     // Catch: Throwable -> L7
            if (userSensorListeners != null) goto L9;
            userSensorListeners = new ArrayMap();     // Catch: Throwable -> L7
            this.mListeners.put(Integer.valueOf(userId), userSensorListeners);     // Catch: Throwable -> L7
        L9:
            ArraySet<SensorPrivacyManagerInternal.OnSensorPrivacyChangedListener> sensorListeners = userSensorListeners.get(Integer.valueOf(sensor));     // Catch: Throwable -> L7
            if (sensorListeners != null) goto L12;
            sensorListeners = new ArraySet();     // Catch: Throwable -> L7
            userSensorListeners.put(Integer.valueOf(sensor), sensorListeners);     // Catch: Throwable -> L7
        L12:
            sensorListeners.add(listener);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public void addSensorPrivacyListenerForAllUsers(int sensor, SensorPrivacyManagerInternal.OnUserSensorPrivacyChangedListener listener) {
            Object r0 = this.mLock;
            monitor-enter(r0);
            ArraySet<SensorPrivacyManagerInternal.OnUserSensorPrivacyChangedListener> sensorListeners = this.mAllUserListeners.get(Integer.valueOf(sensor));     // Catch: Throwable -> L7
            if (sensorListeners != null) goto L9;
            sensorListeners = new ArraySet();     // Catch: Throwable -> L7
            this.mAllUserListeners.put(Integer.valueOf(sensor), sensorListeners);     // Catch: Throwable -> L7
        L9:
            sensorListeners.add(listener);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public void setPhysicalToggleSensorPrivacy(int userId, int sensor, boolean enable) {
            SensorPrivacyServiceImpl sps = SensorPrivacyService.m8100$$Nest$fgetmSensorPrivacyServiceImpl(this.this$0);
            if (userId != (-2)) goto L5;
            int userId2 = SensorPrivacyService.m8095$$Nest$fgetmCurrentUser(this.this$0);
        L7:
            if (userId2 != (-10000)) goto L9;
            int realUserId = SensorPrivacyService.m8094$$Nest$fgetmContext(this.this$0).getUserId();
        L10:
            SensorPrivacyServiceImpl.m8127$$Nest$msetToggleSensorPrivacyUnchecked(sps, 2, realUserId, 5, sensor, enable);
            if (enable == true) goto L14;
            SensorPrivacyServiceImpl.m8127$$Nest$msetToggleSensorPrivacyUnchecked(sps, 1, realUserId, 5, sensor, enable);
            return;
        L14:
            return;
        L9:
            realUserId = userId2;
            goto L10
        L5:
            userId2 = userId;
            goto L7
        }
    }

    class SensorPrivacyServiceImpl extends ISensorPrivacyManager.Stub implements AppOpsManager.OnOpNotedInternalListener, AppOpsManager.OnOpStartedListener, IBinder.DeathRecipient, UserManagerInternal.UserRestrictionsListener {
        private final SensorPrivacyHandler mHandler;
        private final Object mLock;
        private final ArrayMap<SensorUseReminderDialogInfo, ArraySet<Integer>> mQueuedSensorUseReminderDialogs;
        private SensorPrivacyStateController mSensorPrivacyStateController;
        private ArrayMap<Pair<Integer, UserHandle>, ArrayList<IBinder>> mSuppressReminders;
        final /* synthetic */ SensorPrivacyService this$0;

        /* JADX INFO: renamed from: com.android.server.sensorprivacy.SensorPrivacyService$SensorPrivacyServiceImpl$2, reason: invalid class name */
        class AnonymousClass2 extends BroadcastReceiver {
            final /* synthetic */ SensorPrivacyServiceImpl this$1;
            final /* synthetic */ SensorPrivacyService val$this$0;

            /* JADX INFO: renamed from: $r8$lambda$3Uh8y7-PzAno7EQ7ArdLVeAFmqw, reason: not valid java name */
            public static /* synthetic */ void m8130$r8$lambda$3Uh8y7PzAno7EQ7ArdLVeAFmqw(AnonymousClass2 r0, int r1, int r2, int r3, SensorState r4) {
                r0.lambda$onReceive$0(r1, r2, r3, r4);
            }

            AnonymousClass2(SensorPrivacyServiceImpl this$1, SensorPrivacyService r2) {
                this.this$1 = this$1;
                this.val$this$0 = r2;
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                SensorPrivacyServiceImpl.m8119$$Nest$fgetmSensorPrivacyStateController(this.this$1).forEachState(new SensorPrivacyService$SensorPrivacyServiceImpl$2$$ExternalSyntheticLambda0(this));
            }

            private /* synthetic */ void lambda$onReceive$0(int toggleType, int userId, int sensor, SensorState state) {
                SensorPrivacyServiceImpl.m8122$$Nest$mlogSensorPrivacyToggle(this.this$1, 5, sensor, state.isEnabled(), state.getLastChange(), true);
            }
        }

        private class SensorUseReminderDialogInfo {
            private String mPackageName;
            private int mTaskId;
            private UserHandle mUser;

            /* JADX INFO: renamed from: -$$Nest$fgetmPackageName, reason: not valid java name */
            static /* bridge */ /* synthetic */ String m8131$$Nest$fgetmPackageName(SensorUseReminderDialogInfo r0) {
                return r0.mPackageName;
            }

            /* JADX INFO: renamed from: -$$Nest$fgetmTaskId, reason: not valid java name */
            static /* bridge */ /* synthetic */ int m8132$$Nest$fgetmTaskId(SensorUseReminderDialogInfo r0) {
                return r0.mTaskId;
            }

            SensorUseReminderDialogInfo(SensorPrivacyServiceImpl r1, int taskId, UserHandle user, String packageName) {
                this.mTaskId = taskId;
                this.mUser = user;
                this.mPackageName = packageName;
            }

            public boolean equals(Object o) {
                if (this != o) goto L6;
                return true;
            L6:
                if (o != null) goto L8;
            L19:
                return false;
            L8:
                if ((o instanceof SensorUseReminderDialogInfo) == false) goto L19;
                SensorUseReminderDialogInfo that = (SensorUseReminderDialogInfo) o;
                if (this.mTaskId != that.mTaskId) goto L18;
                if (Objects.equals(this.mUser, that.mUser) == false) goto L18;
                if (Objects.equals(this.mPackageName, that.mPackageName) == false) goto L18;
                return true;
            L18:
                return false;
            }

            public int hashCode() {
                return Objects.hash(new Object[]{Integer.valueOf(this.mTaskId), this.mUser, this.mPackageName});
            }
        }

        /* JADX INFO: renamed from: $r8$lambda$1Hb4a2aX7-Cg8zP4a5K2P10E1uY, reason: not valid java name */
        public static /* synthetic */ void m8111$r8$lambda$1Hb4a2aX7Cg8zP4a5K2P10E1uY(SensorPrivacyServiceImpl r0, boolean[] r1, int r2, boolean[] r3, boolean[] r4, int r5, boolean[] r6) {
            r0.lambda$userSwitching$8(r1, r2, r3, r4, r5, r6);
        }

        public static /* synthetic */ void $r8$lambda$4ASAP2NtxClBlWT0L_Mp4qb9t60(SensorPrivacyServiceImpl r0, int r1, int r2, int r3, boolean r4, Integer r5) {
            r0.lambda$setToggleSensorPrivacyForProfileGroup$7(r1, r2, r3, r4, r5);
        }

        public static /* synthetic */ void $r8$lambda$8YvnU_XQ8KZnw0qRQcJ8elN8zr8(SensorPrivacyServiceImpl r0, int r1, int r2, boolean r3, long r4, boolean r6) {
            r0.logSensorPrivacyToggle(r1, r2, r3, r4, r6);
        }

        /* JADX INFO: renamed from: $r8$lambda$BNNrOzh72CB48YCYTefj-5Ur_i8, reason: not valid java name */
        public static /* synthetic */ void m8112$r8$lambda$BNNrOzh72CB48YCYTefj5Ur_i8(SensorPrivacyServiceImpl r0, SensorUseReminderDialogInfo r1) {
            r0.showSensorUserReminderDialog(r1);
        }

        public static /* synthetic */ void $r8$lambda$C5UJAff4UqfWh7ynVZTZYqCQLWo(SensorPrivacyServiceImpl r0, int r1, int r2, int r3, boolean r4, long[] r5, boolean r6) {
            r0.lambda$setToggleSensorPrivacyUnchecked$5(r1, r2, r3, r4, r5, r6);
        }

        public static /* synthetic */ void $r8$lambda$Hkd26DN4nuSefr9gIihdZGLrYG0(SensorPrivacyServiceImpl r0, int r1, int r2, int r3, long r4, boolean r6) {
            r0.logSensorPrivacyStateToggle(r1, r2, r3, r4, r6);
        }

        /* JADX INFO: renamed from: $r8$lambda$LWErkewuSQjm1-ZNatckHx4ENbk, reason: not valid java name */
        public static /* synthetic */ void m8113$r8$lambda$LWErkewuSQjm1ZNatckHx4ENbk(SensorPrivacyServiceImpl r0, int r1, int r2, int r3, int r4, Integer r5) {
            r0.lambda$setToggleSensorPrivacyStateForProfileGroup$4(r1, r2, r3, r4, r5);
        }

        /* JADX INFO: renamed from: $r8$lambda$MgWM2tYuFxXDGXygMm-xP8eWSNA, reason: not valid java name */
        public static /* synthetic */ void m8114$r8$lambda$MgWM2tYuFxXDGXygMmxP8eWSNA(SensorPrivacyServiceImpl r0, boolean[] r1, int r2, boolean[] r3, boolean[] r4, int r5, boolean[] r6) {
            r0.lambda$userSwitching$9(r1, r2, r3, r4, r5, r6);
        }

        public static /* synthetic */ void $r8$lambda$Ub_q5m6N3HI6HgtdCycPZ7WY5_w(SensorPrivacyServiceImpl r0, int r1, UserHandle r2, String r3, int r4) {
            r0.enqueueSensorUseReminderDialog(r1, r2, r3, r4);
        }

        /* JADX INFO: renamed from: $r8$lambda$XuReIy-L0A4ALWOhrtfFXpmomtA, reason: not valid java name */
        public static /* synthetic */ void m8115$r8$lambda$XuReIyL0A4ALWOhrtfFXpmomtA(SensorPrivacyServiceImpl r0, int r1, int r2, int r3, long[] r4, boolean r5, int r6) {
            r0.lambda$setToggleSensorPrivacyUnchecked$6(r1, r2, r3, r4, r5, r6);
        }

        public static /* synthetic */ void $r8$lambda$hHW_75kPIFgOeizyyjsWYeCp1U4(SensorPrivacyServiceImpl r0, int r1, int r2, int r3, SensorState r4) {
            r0.lambda$correctStateIfNeeded$1(r1, r2, r3, r4);
        }

        /* JADX INFO: renamed from: $r8$lambda$iiIiQJuf0b86Y0-N_U7kq4uM2ds, reason: not valid java name */
        public static /* synthetic */ void m8116$r8$lambda$iiIiQJuf0b86Y0N_U7kq4uM2ds(SensorPrivacyServiceImpl r0, int r1, int r2, int r3, long[] r4, int r5, int r6) {
            r0.lambda$setToggleSensorPrivacyStateUnchecked$3(r1, r2, r3, r4, r5, r6);
        }

        /* JADX INFO: renamed from: $r8$lambda$kOiKzW_1NwRYam4a5FklNHaZ-S0, reason: not valid java name */
        public static /* synthetic */ void m8117$r8$lambda$kOiKzW_1NwRYam4a5FklNHaZS0(SensorPrivacyServiceImpl r0, int r1, int r2, int r3, SensorState r4) {
            r0.lambda$new$0(r1, r2, r3, r4);
        }

        /* JADX INFO: renamed from: $r8$lambda$mfjJZlfTpOtZ0b9Z-_epju6_u7M, reason: not valid java name */
        public static /* synthetic */ void m8118$r8$lambda$mfjJZlfTpOtZ0b9Z_epju6_u7M(SensorPrivacyServiceImpl r0, int r1, int r2, int r3, int r4, long[] r5, boolean r6) {
            r0.lambda$setToggleSensorPrivacyStateUnchecked$2(r1, r2, r3, r4, r5, r6);
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmSensorPrivacyStateController, reason: not valid java name */
        static /* bridge */ /* synthetic */ SensorPrivacyStateController m8119$$Nest$fgetmSensorPrivacyStateController(SensorPrivacyServiceImpl r0) {
            return r0.mSensorPrivacyStateController;
        }

        /* JADX INFO: renamed from: -$$Nest$misAutomotive, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m8120$$Nest$misAutomotive(SensorPrivacyServiceImpl r0, Context r1) {
            return r0.isAutomotive(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$misToggleSensorPrivacyEnabledInternal, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m8121$$Nest$misToggleSensorPrivacyEnabledInternal(SensorPrivacyServiceImpl r0, int r1, int r2, int r3) {
            return r0.isToggleSensorPrivacyEnabledInternal(r1, r2, r3);
        }

        /* JADX INFO: renamed from: -$$Nest$mlogSensorPrivacyToggle, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m8122$$Nest$mlogSensorPrivacyToggle(SensorPrivacyServiceImpl r0, int r1, int r2, boolean r3, long r4, boolean r6) {
            r0.logSensorPrivacyToggle(r1, r2, r3, r4, r6);
        }

        /* JADX INFO: renamed from: -$$Nest$mregisterSettingsObserver, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m8123$$Nest$mregisterSettingsObserver(SensorPrivacyServiceImpl r0) {
            r0.registerSettingsObserver();
        }

        /* JADX INFO: renamed from: -$$Nest$mremoveSuppressPackageReminderToken, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m8124$$Nest$mremoveSuppressPackageReminderToken(SensorPrivacyServiceImpl r0, Pair r1, IBinder r2) {
            r0.removeSuppressPackageReminderToken(r1, r2);
        }

        /* JADX INFO: renamed from: -$$Nest$msensorStrToId, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m8125$$Nest$msensorStrToId(SensorPrivacyServiceImpl r0, String r1) {
            return r0.sensorStrToId(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$msetGlobalRestriction, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m8126$$Nest$msetGlobalRestriction(SensorPrivacyServiceImpl r0, int r1, boolean r2) {
            r0.setGlobalRestriction(r1, r2);
        }

        /* JADX INFO: renamed from: -$$Nest$msetToggleSensorPrivacyUnchecked, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m8127$$Nest$msetToggleSensorPrivacyUnchecked(SensorPrivacyServiceImpl r0, int r1, int r2, int r3, int r4, boolean r5) {
            r0.setToggleSensorPrivacyUnchecked(r1, r2, r3, r4, r5);
        }

        /* JADX INFO: renamed from: -$$Nest$mshowSensorStateChangedActivity, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m8128$$Nest$mshowSensorStateChangedActivity(SensorPrivacyServiceImpl r0, int r1, int r2) {
            r0.showSensorStateChangedActivity(r1, r2);
        }

        /* JADX INFO: renamed from: -$$Nest$muserSwitching, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m8129$$Nest$muserSwitching(SensorPrivacyServiceImpl r0, int r1, int r2) {
            r0.userSwitching(r1, r2);
        }

        SensorPrivacyServiceImpl(final SensorPrivacyService this$0) {
            this.this$0 = this$0;
            this.mLock = new Object();
            this.mSuppressReminders = new ArrayMap();
            this.mQueuedSensorUseReminderDialogs = new ArrayMap();
            this.mHandler = new SensorPrivacyHandler(this$0, FgThread.get().getLooper(), SensorPrivacyService.m8094$$Nest$fgetmContext(this$0));
            this.mSensorPrivacyStateController = SensorPrivacyStateController.getInstance();
            correctStateIfNeeded();
            int[] micAndCameraOps = {27, 100, 26, 101, 121};
            SensorPrivacyService.m8090$$Nest$fgetmAppOpsManager(this$0).startWatchingNoted(micAndCameraOps, this);
            SensorPrivacyService.m8090$$Nest$fgetmAppOpsManager(this$0).startWatchingStarted(micAndCameraOps, this);
            SensorPrivacyService.m8094$$Nest$fgetmContext(this$0).registerReceiver(new AnonymousClass1(this, this$0), new IntentFilter(SensorPrivacyService.m8105$$Nest$sfgetACTION_DISABLE_TOGGLE_SENSOR_PRIVACY()), "android.permission.MANAGE_SENSOR_PRIVACY", null, 2);
            SensorPrivacyService.m8094$$Nest$fgetmContext(this$0).registerReceiver(new AnonymousClass2(this, this$0), new IntentFilter("android.intent.action.ACTION_SHUTDOWN"));
            SensorPrivacyService.m8103$$Nest$fgetmUserManagerInternal(this$0).addUserRestrictionsListener(this);
            SensorPrivacyStateController r1 = this.mSensorPrivacyStateController;
            SensorPrivacyHandler r2 = this.mHandler;
            final SensorPrivacyHandler r3 = this.mHandler;
            r3.getClass();
            r1.setAllSensorPrivacyListener(r2, new SensorPrivacyService$SensorPrivacyServiceImpl$$ExternalSyntheticLambda6(r3));
            this.mSensorPrivacyStateController.setSensorPrivacyListener(this.mHandler, new SensorPrivacyService$SensorPrivacyServiceImpl$$ExternalSyntheticLambda7(this));
        }

        private /* synthetic */ void lambda$new$0(int toggleType, int userId, int sensor, SensorState state) {
            this.mHandler.handleSensorPrivacyChanged(userId, toggleType, sensor, state.isEnabled());
            this.mHandler.handleSensorPrivacyChanged(userId, toggleType, sensor, state.getState());
        }

        private void correctStateIfNeeded() {
            this.mSensorPrivacyStateController.forEachState(new SensorPrivacyService$SensorPrivacyServiceImpl$$ExternalSyntheticLambda14(this));
        }

        private /* synthetic */ void lambda$correctStateIfNeeded$1(int type, int user, int sensor, SensorState state) {
            if (type == 1) goto L6;
            return;
        L6:
            if (supportsSensorToggle(1, sensor) == true) goto L11;
            if (state.isEnabled() == false) goto L11;
            setToggleSensorPrivacyUnchecked(1, user, 5, sensor, false);
            return;
        }

        @Override // com.android.server.pm.UserManagerInternal.UserRestrictionsListener
        public void onUserRestrictionsChanged(int userId, Bundle newRestrictions, Bundle prevRestrictions) {
            if (prevRestrictions.getBoolean("disallow_camera_toggle") == true) goto L10;
            if (newRestrictions.getBoolean("disallow_camera_toggle") == false) goto L10;
            if (isValidCallingUser(userId) == false) goto L10;
            setToggleSensorPrivacyUnchecked(1, userId, 5, 2, false);
        L10:
            if (prevRestrictions.getBoolean("disallow_microphone_toggle") == false) goto L12;
            return;
        L12:
            if (newRestrictions.getBoolean("disallow_microphone_toggle") == true) goto L14;
            return;
        L14:
            if (isValidCallingUser(userId) == false) goto L19;
            setToggleSensorPrivacyUnchecked(1, userId, 5, 1, false);
            return;
        }

        public void onOpStarted(int code, int uid, String packageName, String attributionTag, int flags, int result) {
            onOpNoted(code, uid, packageName, attributionTag, flags, result);
        }

        public void onOpNoted(int code, int uid, String packageName, String attributionTag, int flags, int result) {
            if ((flags & 13) != 0) goto L6;
            return;
        L6:
            if (result == 1) goto L8;
            return;
        L8:
            if (code != 27) goto L10;
        L21:
            int sensor = 1;
        L22:
            long token = Binder.clearCallingIdentity();
            onSensorUseStarted(uid, packageName, sensor);     // Catch: Throwable -> L26
            Binder.restoreCallingIdentity(token);
            return;
        L26:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        L10:
            if (code == 100) goto L21;
            if (code == 121) goto L21;
            if (code != 26) goto L17;
        L20:
            sensor = 2;
            goto L22
        L17:
            if (code == 101) goto L20;
        }

        private void onSensorUseStarted(int uid, String packageName, int sensor) {
            UserHandle user = UserHandle.of(SensorPrivacyService.m8095$$Nest$fgetmCurrentUser(this.this$0));
            if (sensor != 2) goto L10;
            if (isAutomotive(SensorPrivacyService.m8094$$Nest$fgetmContext(this.this$0)) == false) goto L10;
            if (isCameraPrivacyEnabled(packageName) == true) goto L13;
            return;
        L13:
            if (uid != 1000) goto L15;
            return;
        L15:
            Object r6 = this.mLock;
            monitor-enter(r6);
        L22:
            th = move-exception;
            throw th;
        L18:
            if (this.mSuppressReminders.containsKey(new Pair(Integer.valueOf(sensor), user)) == false) goto L24;
            Log.d(SensorPrivacyService.m8106$$Nest$sfgetTAG(), "Suppressed sensor privacy reminder for " + packageName + SliceClientPermissions.SliceAuthority.DELIMITER + user);     // Catch: Throwable -> L22
            monitor-exit(r6);     // Catch: Throwable -> L22
            return;
        L24:
            monitor-exit(r6);     // Catch: Throwable -> L22
            List<ActivityManager.RunningTaskInfo> tasksOfPackageUsingSensor = new ArrayList();
            List<ActivityManager.RunningTaskInfo> tasks = SensorPrivacyService.m8089$$Nest$fgetmActivityTaskManager(this.this$0).getTasks(Integer.MAX_VALUE);
            int numTasks = tasks.size();
            int taskNum = 0;
        L26:
            if (taskNum >= numTasks) goto L42;
            ActivityManager.RunningTaskInfo task = tasks.get(taskNum);
            if (task.isVisible == false) goto L41;
            if (task.topActivity.getPackageName().equals(packageName) == false) goto L37;
            if (task.isFocused == true) goto L33;
            tasksOfPackageUsingSensor.add(task);
            goto L41
        L33:
            enqueueSensorUseReminderDialogAsync(task.taskId, user, packageName, sensor);
            return;
        L37:
            if (task.topActivity.flattenToString().equals(getSensorUseActivityName(new ArraySet(Arrays.asList(new Integer[]{Integer.valueOf(sensor)})))) == false) goto L41;
            if (task.isFocused == false) goto L41;
            enqueueSensorUseReminderDialogAsync(task.taskId, user, packageName, sensor);
        L41:
            taskNum = taskNum + 1;
            goto L26
        L42:
            int taskNum2 = tasksOfPackageUsingSensor.size();
            if (taskNum2 != 1) goto L47;
            enqueueSensorUseReminderDialogAsync(tasksOfPackageUsingSensor.get(0).taskId, user, packageName, sensor);
            return;
        L47:
            if (tasksOfPackageUsingSensor.size() <= 1) goto L50;
            showSensorUseReminderNotification(user, packageName, sensor);
            return;
        L50:
            List<ActivityManager.RunningServiceInfo> services = SensorPrivacyService.m8087$$Nest$fgetmActivityManager(this.this$0).getRunningServices(Integer.MAX_VALUE);
            int numServices = services.size();
            int serviceNum = 0;
        L51:
            if (serviceNum >= numServices) goto L59;
            ActivityManager.RunningServiceInfo service = services.get(serviceNum);
            if (service.foreground == false) goto L58;
            if (service.service.getPackageName().equals(packageName) == false) goto L58;
            showSensorUseReminderNotification(user, packageName, sensor);
            return;
        L58:
            serviceNum = serviceNum + 1;
            goto L51
        L59:
            String inputMethodComponent = Settings.Secure.getStringForUser(SensorPrivacyService.m8094$$Nest$fgetmContext(this.this$0).getContentResolver(), "default_input_method", user.getIdentifier());
            String inputMethodPackageName = null;
            if (inputMethodComponent == null) goto L95;
            ComponentName component = ComponentName.unflattenFromString(inputMethodComponent);
            if (component == null) goto L64;
            inputMethodPackageName = component.getPackageName();
            goto L95
        L64:
            Log.w(SensorPrivacyService.m8106$$Nest$sfgetTAG(), "Failed to parse inputMethodComponent: " + inputMethodComponent);
        L95:
            int capability = SensorPrivacyService.m8088$$Nest$fgetmActivityManagerInternal(this.this$0).getUidCapability(uid);     // Catch: IllegalArgumentException -> L90
            if (sensor != 1) goto L81;
            VoiceInteractionManagerInternal voiceInteractionManagerInternal = (VoiceInteractionManagerInternal) LocalServices.getService(VoiceInteractionManagerInternal.class);
            if (voiceInteractionManagerInternal == null) goto L75;
            if (voiceInteractionManagerInternal.hasActiveSession(packageName) == false) goto L75;
            enqueueSensorUseReminderDialogAsync(-1, user, packageName, sensor);
            return;
        L75:
            if (TextUtils.equals(packageName, inputMethodPackageName) == false) goto L81;
            if ((capability & 4) == 0) goto L81;
            enqueueSensorUseReminderDialogAsync(-1, user, packageName, sensor);
            return;
        L81:
            if (sensor == 2) goto L83;
        L88:
            Log.i(SensorPrivacyService.m8106$$Nest$sfgetTAG(), packageName + SliceClientPermissions.SliceAuthority.DELIMITER + uid + " started using sensor " + sensor + " but no activity or foreground service was running. The user will not be informed. System components should check if sensor privacy is enabled for the sensor before accessing it.");
            return;
        L83:
            if (TextUtils.equals(packageName, inputMethodPackageName) == false) goto L88;
            if ((capability & 2) == 0) goto L88;
            enqueueSensorUseReminderDialogAsync(-1, user, packageName, sensor);
            return;
        L90:
            e = move-exception;
            Log.w(SensorPrivacyService.m8106$$Nest$sfgetTAG(), e);
            return;
        L10:
            if (isCombinedToggleSensorPrivacyEnabled(sensor) == true) goto L13;
        }

        private void enqueueSensorUseReminderDialogAsync(int taskId, UserHandle user, String packageName, int sensor) {
            this.mHandler.sendMessage(PooledLambda.obtainMessage(new SensorPrivacyService$SensorPrivacyServiceImpl$$ExternalSyntheticLambda11(), this, Integer.valueOf(taskId), user, packageName, Integer.valueOf(sensor)));
        }

        private void enqueueSensorUseReminderDialog(int taskId, UserHandle user, String packageName, int sensor) {
            SensorUseReminderDialogInfo info = new SensorUseReminderDialogInfo(this, taskId, user, packageName);
            if (this.mQueuedSensorUseReminderDialogs.containsKey(info) == true) goto L16;
            ArraySet<Integer> sensors = new ArraySet();
            if (sensor == 1) goto L7;
        L9:
            if (sensor == 2) goto L11;
        L13:
            sensors.add(Integer.valueOf(sensor));
        L14:
            this.mQueuedSensorUseReminderDialogs.put(info, sensors);
            this.mHandler.sendMessageDelayed(PooledLambda.obtainMessage(new SensorPrivacyService$SensorPrivacyServiceImpl$$ExternalSyntheticLambda1(), this, info), 500);
            return;
        L11:
            if (this.mSuppressReminders.containsKey(new Pair(1, user)) == false) goto L13;
        L12:
            sensors.add(1);
            sensors.add(2);
            goto L14
        L7:
            if (this.mSuppressReminders.containsKey(new Pair(2, user)) == true) goto L12;
        L16:
            this.mQueuedSensorUseReminderDialogs.get(info).add(Integer.valueOf(sensor));
        }

        private void showSensorUserReminderDialog(SensorUseReminderDialogInfo info) {
            ArraySet<Integer> sensors = this.mQueuedSensorUseReminderDialogs.get(info);
            this.mQueuedSensorUseReminderDialogs.remove(info);
            if (sensors != null) goto L6;
            Log.e(SensorPrivacyService.m8106$$Nest$sfgetTAG(), "Unable to show sensor use dialog because sensor set is null. Was the dialog queue modified from outside the handler thread?");
            return;
        L6:
            Intent dialogIntent = new Intent();
            dialogIntent.setComponent(ComponentName.unflattenFromString(getSensorUseActivityName(sensors)));
            ActivityOptions options = ActivityOptions.makeBasic();
            options.setLaunchTaskId(SensorUseReminderDialogInfo.m8132$$Nest$fgetmTaskId(info));
            options.setTaskOverlay(true, true);
            dialogIntent.addFlags(8650752);
            dialogIntent.putExtra("android.intent.extra.PACKAGE_NAME", SensorUseReminderDialogInfo.m8131$$Nest$fgetmPackageName(info));
            if (sensors.size() != 1) goto L10;
            dialogIntent.putExtra(SensorPrivacyManager.EXTRA_SENSOR, sensors.valueAt(0));
        L12:
            SensorPrivacyService.m8094$$Nest$fgetmContext(this.this$0).startActivityAsUser(dialogIntent, options.toBundle(), UserHandle.SYSTEM);
            return;
        L10:
            if (sensors.size() != 2) goto L14;
            dialogIntent.putExtra(SensorPrivacyManager.EXTRA_ALL_SENSORS, true);
            goto L12
        L14:
            Log.e(SensorPrivacyService.m8106$$Nest$sfgetTAG(), "Attempted to show sensor use dialog for " + sensors.size() + " sensors");
        }

        private String getSensorUseActivityName(ArraySet<Integer> sensors) {
            Iterator<Integer> r0 = sensors.iterator();
        L4:
            if (r0.hasNext() == false) goto L11;
            Integer sensor = r0.next();
            if (isToggleSensorPrivacyEnabled(2, sensor.intValue()) == false) goto L4;
            return SensorPrivacyService.m8094$$Nest$fgetmContext(this.this$0).getResources().getString(R.string.content_description_expanded);
        L11:
            return SensorPrivacyService.m8094$$Nest$fgetmContext(this.this$0).getResources().getString(R.string.content_description_collapsed);
        }

        private void showSensorUseReminderNotification(UserHandle user, String packageName, int sensor) {
            CharSequence packageLabel = this.this$0.getUiContext().getPackageManager().getApplicationInfoAsUser(packageName, 0, user).loadLabel(SensorPrivacyService.m8094$$Nest$fgetmContext(this.this$0).getPackageManager());     // Catch: PackageManager.NameNotFoundException -> L18
            if (sensor != 1) goto L7;
            int iconRes = R.drawable.pointer_top_left_diagonal_double_arrow_large;
            int messageRes = R.string.view_and_control_notification_content;
            int notificationId = 65;
        L8:
            NotificationChannel channel = new NotificationChannel(SensorPrivacyService.SENSOR_PRIVACY_CHANNEL_ID, this.this$0.getUiContext().getString(R.string.vdm_pip_blocked), 4);
            channel.setSound(null, null);
            channel.setBypassDnd(true);
            channel.enableVibration(false);
            channel.setBlockable(false);
            SensorPrivacyService.m8097$$Nest$fgetmNotificationManager(this.this$0).createNotificationChannel(channel);
            Icon icon = Icon.createWithResource(this.this$0.getUiContext().getResources(), iconRes);
            String contentTitle = this.this$0.getUiContext().getString(messageRes);
            Spanned contentText = Html.fromHtml(this.this$0.getUiContext().getString(R.string.view_and_control_notification_title, new Object[]{packageLabel}), 0);
            SafetyCenterManager safetyCenterManager = (SafetyCenterManager) SensorPrivacyService.m8094$$Nest$fgetmContext(this.this$0).getSystemService(SafetyCenterManager.class);
            if (safetyCenterManager.isSafetyCenterEnabled() == false) goto L11;
            String action = "android.settings.PRIVACY_CONTROLS";
        L12:
            PendingIntent contentIntent = PendingIntent.getActivity(SensorPrivacyService.m8094$$Nest$fgetmContext(this.this$0), sensor, new Intent(action), AudioFormat.DTS_HD);
            String actionTitle = this.this$0.getUiContext().getString(R.string.vendor_required_attestation_revocation_list_url);
            PendingIntent actionIntent = PendingIntent.getBroadcast(SensorPrivacyService.m8094$$Nest$fgetmContext(this.this$0), sensor, new Intent(SensorPrivacyService.m8105$$Nest$sfgetACTION_DISABLE_TOGGLE_SENSOR_PRIVACY()).setPackage(SensorPrivacyService.m8094$$Nest$fgetmContext(this.this$0).getPackageName()).putExtra(SensorPrivacyManager.EXTRA_SENSOR, sensor).putExtra(SensorPrivacyManager.EXTRA_NOTIFICATION_ID, notificationId).putExtra("android.intent.extra.USER", user), AudioFormat.DTS_HD);
            NotificationManager r10 = SensorPrivacyService.m8097$$Nest$fgetmNotificationManager(this.this$0);
            Notification.Builder r2 = new Notification.Builder(SensorPrivacyService.m8094$$Nest$fgetmContext(this.this$0), SensorPrivacyService.SENSOR_PRIVACY_CHANNEL_ID).setContentTitle(contentTitle).setContentText(contentText).setSmallIcon(icon).addAction(new Notification.Action.Builder(icon, actionTitle, actionIntent).build()).setContentIntent(contentIntent).extend(new Notification.TvExtender());
            if (isTelevision(SensorPrivacyService.m8094$$Nest$fgetmContext(this.this$0)) == false) goto L15;
            long r0 = 1;
        L16:
            r10.notify(notificationId, r2.setTimeoutAfter(r0).build());
            return;
        L15:
            r0 = 0;
            goto L16
        L11:
            action = "android.settings.PRIVACY_SETTINGS";
            goto L12
        L7:
            iconRes = R.drawable.ic_star_black_16dp;
            messageRes = R.string.vdm_secure_window;
            notificationId = 66;
        L19:
            Log.e(SensorPrivacyService.m8106$$Nest$sfgetTAG(), "Cannot show sensor use notification for " + packageName);
        }

        private void showSensorStateChangedActivity(int sensor, int toggleType) {
            String activityName = SensorPrivacyService.m8094$$Nest$fgetmContext(this.this$0).getResources().getString(R.string.contentServiceTooManyDeletesNotificationDesc);
            if (TextUtils.isEmpty(activityName) == false) goto L5;
            return;
        L5:
            Intent dialogIntent = new Intent();
            dialogIntent.setComponent(ComponentName.unflattenFromString(activityName));
            ActivityOptions options = ActivityOptions.makeBasic();
            options.setTaskOverlay(true, true);
            dialogIntent.addFlags(8650752);
            dialogIntent.putExtra(SensorPrivacyManager.EXTRA_SENSOR, sensor);
            dialogIntent.putExtra(SensorPrivacyManager.EXTRA_TOGGLE_TYPE, toggleType);
            SensorPrivacyService.m8094$$Nest$fgetmContext(this.this$0).startActivityAsUser(dialogIntent, options.toBundle(), UserHandle.SYSTEM);
        }

        private boolean isTelevision(Context context) {
            int uiMode = context.getResources().getConfiguration().uiMode;
            if ((uiMode & 15) != 4) goto L5;
            return true;
        L5:
            return false;
        }

        private boolean isAutomotive(Context context) {
            int uiMode = context.getResources().getConfiguration().uiMode;
            if ((uiMode & 15) != 3) goto L5;
            return true;
        L5:
            return false;
        }

        public void setSensorPrivacy(boolean enable) {
            enforceManageSensorPrivacyPermission();
            enforceValidCallingUser(UserHandle.getCallingUserId());
            this.mSensorPrivacyStateController.setAllSensorState(enable);
        }

        public void setToggleSensorPrivacy(int userId, int source, int sensor, boolean enable) {
            enforceManageSensorPrivacyPermission();
            if (userId != (-2)) goto L5;
            int userId2 = SensorPrivacyService.m8095$$Nest$fgetmCurrentUser(this.this$0);
        L6:
            enforceValidCallingUser(userId2);
            if (canChangeToggleSensorPrivacy(userId2, sensor) == true) goto L9;
            return;
        L9:
            if (enable == true) goto L11;
        L13:
            setToggleSensorPrivacyUnchecked(1, userId2, source, sensor, enable);
            return;
        L11:
            if (supportsSensorToggle(1, sensor) == true) goto L13;
            return;
        L5:
            userId2 = userId;
            goto L6
        }

        public void setToggleSensorPrivacyState(int userId, int source, int sensor, int state) {
            enforceManageSensorPrivacyPermission();
            if (userId != (-2)) goto L5;
            int userId2 = SensorPrivacyService.m8095$$Nest$fgetmCurrentUser(this.this$0);
        L6:
            enforceValidCallingUser(userId2);
            if (canChangeToggleSensorPrivacy(userId2, sensor) == true) goto L10;
            return;
        L10:
            if (supportsSensorToggle(1, sensor) == true) goto L12;
            return;
        L12:
            setToggleSensorPrivacyStateUnchecked(1, userId2, source, sensor, state);
            return;
        L5:
            userId2 = userId;
            goto L6
        }

        private void setToggleSensorPrivacyStateUnchecked(final int toggleType, final int userId, final int source, final int sensor, final int state) {
            final long[] lastChange = new long[1];
            this.mSensorPrivacyStateController.atomic(new SensorPrivacyService$SensorPrivacyServiceImpl$$ExternalSyntheticLambda4(this, toggleType, userId, sensor, lastChange, state, source));
        }

        private /* synthetic */ void lambda$setToggleSensorPrivacyStateUnchecked$3(int toggleType, final int userId, final int sensor, final long[] lastChange, final int state, final int source) {
            SensorState sensorState = this.mSensorPrivacyStateController.getState(toggleType, userId, sensor);
            lastChange[0] = sensorState.getLastChange();
            this.mSensorPrivacyStateController.setState(toggleType, userId, sensor, state, this.mHandler, new SensorPrivacyService$SensorPrivacyServiceImpl$$ExternalSyntheticLambda9(this, userId, source, sensor, state, lastChange));
        }

        private /* synthetic */ void lambda$setToggleSensorPrivacyStateUnchecked$2(int userId, int source, int sensor, int state, long[] lastChange, boolean changeSuccessful) {
            if (changeSuccessful == true) goto L4;
            return;
        L4:
            if (userId != SensorPrivacyService.m8103$$Nest$fgetmUserManagerInternal(this.this$0).getProfileParentId(userId)) goto L8;
            this.mHandler.sendMessage(PooledLambda.obtainMessage(new SensorPrivacyService$SensorPrivacyServiceImpl$$ExternalSyntheticLambda8(), this, Integer.valueOf(source), Integer.valueOf(sensor), Integer.valueOf(state), Long.valueOf(lastChange[0]), false));
            return;
        }

        private void logSensorPrivacyStateToggle(int source, int sensor, int state, long lastChange, boolean onShutDown) {
            long logMins = Math.max(0, (SensorPrivacyService.getCurrentTimeMillis() - lastChange) / 60000);
            if (onShutDown == true) goto L9;
            switch(state) {
                case 1: goto L8;
                case 2: goto L7;
                case 3: goto L6;
                default: goto L5;
            };
        L5:
            int logAction = 0;
        L11:
            switch(sensor) {
                case 1: goto L14;
                case 2: goto L13;
                default: goto L12;
            };
        L12:
            int logSensor = 0;
        L16:
            switch(source) {
                case 1: goto L20;
                case 2: goto L19;
                case 3: goto L18;
                default: goto L17;
            };
        L17:
            int logSource = 0;
        L21:
            FrameworkStatsLog.write(FrameworkStatsLog.PRIVACY_SENSOR_TOGGLE_INTERACTION, logSensor, logAction, logSource, logMins);
            return;
        L18:
            logSource = 1;
            goto L21
        L19:
            logSource = 2;
            goto L21
        L20:
            logSource = 3;
            goto L21
        L13:
            logSensor = 2;
            goto L16
        L14:
            logSensor = 1;
            goto L16
        L6:
            logAction = 3;
            goto L11
        L7:
            logAction = 1;
            goto L11
        L8:
            logAction = 2;
            goto L11
        L9:
            logAction = 0;
            goto L11
        }

        public void setToggleSensorPrivacyStateForProfileGroup(int userId, final int source, final int sensor, final int state) {
            enforceManageSensorPrivacyPermission();
            if (userId != (-2)) goto L5;
            userId = SensorPrivacyService.m8095$$Nest$fgetmCurrentUser(this.this$0);
        L5:
            final int parentId = SensorPrivacyService.m8103$$Nest$fgetmUserManagerInternal(this.this$0).getProfileParentId(userId);
            SensorPrivacyService.m8104$$Nest$mforAllUsers(this.this$0, new SensorPrivacyService$SensorPrivacyServiceImpl$$ExternalSyntheticLambda13(this, parentId, source, sensor, state));
        }

        private /* synthetic */ void lambda$setToggleSensorPrivacyStateForProfileGroup$4(int parentId, int source, int sensor, int state, Integer userId2) throws Exception {
            if (parentId != SensorPrivacyService.m8103$$Nest$fgetmUserManagerInternal(this.this$0).getProfileParentId(userId2.intValue())) goto L6;
            setToggleSensorPrivacyState(userId2.intValue(), source, sensor, state);
            return;
        }

        public List<String> getCameraPrivacyAllowlist() {
            enforceObserveSensorPrivacyPermission();
            return this.this$0.mCameraPrivacyAllowlist;
        }

        public void setCameraPrivacyAllowlist(List<String> allowlist) {
            enforceManageSensorPrivacyPermission();
            SensorPrivacyService r0 = this.this$0;
            r0.mCameraPrivacyAllowlist = new ArrayList(allowlist);
        }

        public boolean isCameraPrivacyEnabled(String packageName) {
            enforceObserveSensorPrivacyPermission();
            int state = this.mSensorPrivacyStateController.getState(1, SensorPrivacyService.m8095$$Nest$fgetmCurrentUser(this.this$0), 2).getState();
            if (state != 1) goto L6;
            return true;
        L6:
            if (state != 2) goto L9;
            return false;
        L9:
            if (state != 3) goto L18;
            Iterator<String> r3 = this.this$0.mCameraPrivacyAllowlist.iterator();
        L12:
            if (r3.hasNext() == false) goto L17;
            String entry = r3.next();
            if (packageName.equals(entry) == false) goto L12;
            return false;
        L17:
            return true;
        L18:
            return false;
        }

        public int getToggleSensorPrivacyState(int toggleType, int sensor) {
            enforceObserveSensorPrivacyPermission();
            return this.mSensorPrivacyStateController.getState(toggleType, SensorPrivacyService.m8095$$Nest$fgetmCurrentUser(this.this$0), sensor).getState();
        }

        private void setToggleSensorPrivacyUnchecked(final int toggleType, final int userId, final int source, final int sensor, final boolean enable) {
            final long[] lastChange = new long[1];
            this.mSensorPrivacyStateController.atomic(new SensorPrivacyService$SensorPrivacyServiceImpl$$ExternalSyntheticLambda5(this, toggleType, userId, sensor, lastChange, enable, source));
        }

        private /* synthetic */ void lambda$setToggleSensorPrivacyUnchecked$6(int toggleType, final int userId, final int sensor, final long[] lastChange, final boolean enable, final int source) {
            SensorState sensorState = this.mSensorPrivacyStateController.getState(toggleType, userId, sensor);
            lastChange[0] = sensorState.getLastChange();
            this.mSensorPrivacyStateController.setState(toggleType, userId, sensor, enable, this.mHandler, new SensorPrivacyService$SensorPrivacyServiceImpl$$ExternalSyntheticLambda0(this, userId, source, sensor, enable, lastChange));
        }

        private /* synthetic */ void lambda$setToggleSensorPrivacyUnchecked$5(int userId, int source, int sensor, boolean enable, long[] lastChange, boolean changeSuccessful) {
            if (changeSuccessful == true) goto L4;
            return;
        L4:
            if (userId != SensorPrivacyService.m8103$$Nest$fgetmUserManagerInternal(this.this$0).getProfileParentId(userId)) goto L8;
            this.mHandler.sendMessage(PooledLambda.obtainMessage(new SensorPrivacyService$SensorPrivacyServiceImpl$$ExternalSyntheticLambda12(), this, Integer.valueOf(source), Integer.valueOf(sensor), Boolean.valueOf(enable), Long.valueOf(lastChange[0]), false));
            return;
        }

        private boolean canChangeToggleSensorPrivacy(int userId, int sensor) {
            if (sensor != 1) goto L9;
            if (SensorPrivacyService.m8093$$Nest$fgetmCallStateHelper(this.this$0).isInEmergencyCall() == false) goto L9;
            Log.i(SensorPrivacyService.m8106$$Nest$sfgetTAG(), "Can't change mic toggle during an emergency call");
            return false;
        L9:
            if (requiresAuthentication() == true) goto L11;
        L16:
            if (sensor != 1) goto L22;
            if (SensorPrivacyService.m8103$$Nest$fgetmUserManagerInternal(this.this$0).getUserRestriction(userId, "disallow_microphone_toggle") == false) goto L22;
            Log.i(SensorPrivacyService.m8106$$Nest$sfgetTAG(), "Can't change mic toggle due to admin restriction");
            return false;
        L22:
            if (sensor == 2) goto L24;
        L27:
            return true;
        L24:
            if (SensorPrivacyService.m8103$$Nest$fgetmUserManagerInternal(this.this$0).getUserRestriction(userId, "disallow_camera_toggle") == false) goto L27;
            Log.i(SensorPrivacyService.m8106$$Nest$sfgetTAG(), "Can't change camera toggle due to admin restriction");
            return false;
        L11:
            if (SensorPrivacyService.m8096$$Nest$fgetmKeyguardManager(this.this$0) == null) goto L16;
            if (SensorPrivacyService.m8096$$Nest$fgetmKeyguardManager(this.this$0).isDeviceLocked(userId) == false) goto L16;
            Log.i(SensorPrivacyService.m8106$$Nest$sfgetTAG(), "Can't change mic/cam toggle while device is locked");
            return false;
        }

        private void logSensorPrivacyToggle(int source, int sensor, boolean enabled, long lastChange, boolean onShutDown) {
            long logMins = Math.max(0, (SensorPrivacyService.getCurrentTimeMillis() - lastChange) / 60000);
            if (onShutDown == false) goto L7;
            if (enabled == false) goto L6;
            int logAction = 0;
        L11:
            switch(sensor) {
                case 1: goto L14;
                case 2: goto L13;
                default: goto L12;
            };
        L12:
            int logSensor = 0;
        L16:
            switch(source) {
                case 1: goto L20;
                case 2: goto L19;
                case 3: goto L18;
                default: goto L17;
            };
        L17:
            int logSource = 0;
        L21:
            FrameworkStatsLog.write(FrameworkStatsLog.PRIVACY_SENSOR_TOGGLE_INTERACTION, logSensor, logAction, logSource, logMins);
            return;
        L18:
            logSource = 1;
            goto L21
        L19:
            logSource = 2;
            goto L21
        L20:
            logSource = 3;
            goto L21
        L13:
            logSensor = 2;
            goto L16
        L14:
            logSensor = 1;
            goto L16
        L6:
            logAction = 0;
            goto L11
        L7:
            if (enabled == false) goto L9;
            logAction = 2;
            goto L11
        L9:
            logAction = 1;
            goto L11
        }

        public void setToggleSensorPrivacyForProfileGroup(int userId, final int source, final int sensor, final boolean enable) {
            enforceManageSensorPrivacyPermission();
            if (userId != (-2)) goto L5;
            userId = SensorPrivacyService.m8095$$Nest$fgetmCurrentUser(this.this$0);
        L5:
            final int parentId = SensorPrivacyService.m8103$$Nest$fgetmUserManagerInternal(this.this$0).getProfileParentId(userId);
            SensorPrivacyService.m8104$$Nest$mforAllUsers(this.this$0, new SensorPrivacyService$SensorPrivacyServiceImpl$$ExternalSyntheticLambda10(this, parentId, source, sensor, enable));
        }

        private /* synthetic */ void lambda$setToggleSensorPrivacyForProfileGroup$7(int parentId, int source, int sensor, boolean enable, Integer userId2) throws Exception {
            if (parentId != SensorPrivacyService.m8103$$Nest$fgetmUserManagerInternal(this.this$0).getProfileParentId(userId2.intValue())) goto L6;
            setToggleSensorPrivacy(userId2.intValue(), source, sensor, enable);
            return;
        }

        private void enforceValidCallingUser(int userId) {
            if (isValidCallingUser(userId) == false) goto L6;
            return;
        L6:
            throw new SecurityException("User " + userId + " is not permitted to toggle sensor privacy");
        }

        private boolean isValidCallingUser(int userId) {
            if (UserManager.isVisibleBackgroundUsersEnabled() == true) goto L5;
            return true;
        L5:
            if (userId != 0) goto L7;
        L19:
            return true;
        L7:
            if (userId == SensorPrivacyService.m8095$$Nest$fgetmCurrentUser(this.this$0)) goto L19;
            long ident = Binder.clearCallingIdentity();
            if (SensorPrivacyService.m8102$$Nest$fgetmUserManager(this.this$0).isSameProfileGroup(userId, SensorPrivacyService.m8095$$Nest$fgetmCurrentUser(this.this$0)) == false) goto L14;
            Binder.restoreCallingIdentity(ident);
            return true;
        L14:
            Binder.restoreCallingIdentity(ident);
            return false;
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        }

        private void enforceManageSensorPrivacyPermission() {
            if (SensorPrivacyService.m8094$$Nest$fgetmContext(this.this$0).checkCallingOrSelfPermission("android.permission.MANAGE_SENSOR_PRIVACY") != 0) goto L6;
            return;
        L6:
            throw new SecurityException("Changing sensor privacy requires the following permission: android.permission.MANAGE_SENSOR_PRIVACY");
        }

        private void enforceObserveSensorPrivacyPermission() {
            String systemUIPackage = SensorPrivacyService.m8094$$Nest$fgetmContext(this.this$0).getString(R.string.config_systemUi);
            int systemUIAppId = UserHandle.getAppId(SensorPrivacyService.m8098$$Nest$fgetmPackageManagerInternal(this.this$0).getPackageUid(systemUIPackage, DeviceStorageMonitorServiceSmtEx.TrafficStats.MB_IN_BYTES, 0));
            if (UserHandle.getCallingAppId() != systemUIAppId) goto L6;
            return;
        L6:
            if (SensorPrivacyService.m8094$$Nest$fgetmContext(this.this$0).checkCallingOrSelfPermission("android.permission.OBSERVE_SENSOR_PRIVACY") != 0) goto L9;
            return;
        L9:
            throw new SecurityException("Observing sensor privacy changes requires the following permission: android.permission.OBSERVE_SENSOR_PRIVACY");
        }

        public boolean isSensorPrivacyEnabled() {
            enforceObserveSensorPrivacyPermission();
            return this.mSensorPrivacyStateController.getAllSensorState();
        }

        public boolean isToggleSensorPrivacyEnabled(int toggleType, int sensor) {
            enforceObserveSensorPrivacyPermission();
            return this.mSensorPrivacyStateController.getState(toggleType, SensorPrivacyService.m8095$$Nest$fgetmCurrentUser(this.this$0), sensor).isEnabled();
        }

        public boolean isCombinedToggleSensorPrivacyEnabled(int sensor) {
            if (isToggleSensorPrivacyEnabled(1, sensor) == false) goto L5;
            return true;
        L5:
            if (isToggleSensorPrivacyEnabled(2, sensor) == true) goto L11;
            return false;
        L11:
            return true;
        }

        private boolean isToggleSensorPrivacyEnabledInternal(int userId, int toggleType, int sensor) {
            return this.mSensorPrivacyStateController.getState(toggleType, userId, sensor).isEnabled();
        }

        public boolean supportsSensorToggle(int toggleType, int sensor) {
            if (toggleType != 1) goto L10;
            if (sensor == 1) goto L6;
            if (sensor != 2) goto L18;
            return SensorPrivacyService.m8094$$Nest$fgetmContext(this.this$0).getResources().getBoolean(R.bool.config_supportsSystemDecorsOnSecondaryDisplays);
        L18:
            throw new IllegalArgumentException("Invalid arguments. toggleType=" + toggleType + " sensor=" + sensor);
        L6:
            return SensorPrivacyService.m8094$$Nest$fgetmContext(this.this$0).getResources().getBoolean(R.bool.config_switch_phone_on_voice_reg_state_change);
        L10:
            if (toggleType != 2) goto L18;
            if (sensor == 1) goto L13;
            if (sensor != 2) goto L18;
            return SensorPrivacyService.m8094$$Nest$fgetmContext(this.this$0).getResources().getBoolean(R.bool.config_sustainedPerformanceModeSupported);
        L13:
            return SensorPrivacyService.m8094$$Nest$fgetmContext(this.this$0).getResources().getBoolean(R.bool.config_swipeDisambiguation);
        }

        public void addSensorPrivacyListener(ISensorPrivacyListener listener) {
            enforceObserveSensorPrivacyPermission();
            if (listener == null) goto L7;
            this.mHandler.addListener(listener);
            return;
        L7:
            throw new NullPointerException("listener cannot be null");
        }

        public void addToggleSensorPrivacyListener(ISensorPrivacyListener listener) {
            enforceObserveSensorPrivacyPermission();
            if (listener == null) goto L7;
            this.mHandler.addToggleListener(listener);
            return;
        L7:
            throw new IllegalArgumentException("listener cannot be null");
        }

        public void removeSensorPrivacyListener(ISensorPrivacyListener listener) {
            enforceObserveSensorPrivacyPermission();
            if (listener == null) goto L7;
            this.mHandler.removeListener(listener);
            return;
        L7:
            throw new NullPointerException("listener cannot be null");
        }

        public void removeToggleSensorPrivacyListener(ISensorPrivacyListener listener) {
            enforceObserveSensorPrivacyPermission();
            if (listener == null) goto L7;
            this.mHandler.removeToggleListener(listener);
            return;
        L7:
            throw new IllegalArgumentException("listener cannot be null");
        }

        public void suppressToggleSensorPrivacyReminders(int userId, int sensor, IBinder token, boolean suppress) {
            enforceManageSensorPrivacyPermission();
            if (userId != (-2)) goto L5;
            userId = SensorPrivacyService.m8095$$Nest$fgetmCurrentUser(this.this$0);
        L5:
            token.getClass();
            Pair<Integer, UserHandle> key = new Pair(Integer.valueOf(sensor), UserHandle.of(userId));
            Object r1 = this.mLock;
            monitor-enter(r1);
            if (suppress == true) goto L25;
            this.mHandler.removeSuppressPackageReminderToken(key, token);     // Catch: Throwable -> L13
        L21:
            monitor-exit(r1);     // Catch: Throwable -> L13
            return;
        L25:
            token.linkToDeath(this, 0);     // Catch: Throwable -> L13 RemoteException -> L16
            ArrayList<IBinder> suppressPackageReminderTokens = this.mSuppressReminders.get(key);     // Catch: Throwable -> L13
            if (suppressPackageReminderTokens != null) goto L15;
            suppressPackageReminderTokens = new ArrayList(1);     // Catch: Throwable -> L13
            this.mSuppressReminders.put(key, suppressPackageReminderTokens);     // Catch: Throwable -> L13
        L15:
            suppressPackageReminderTokens.add(token);     // Catch: Throwable -> L13
            goto L21
        L16:
            e = move-exception;
            Log.e(SensorPrivacyService.m8106$$Nest$sfgetTAG(), "Could not suppress sensor use reminder", e);     // Catch: Throwable -> L13
            return;
        L13:
            th = move-exception;
            throw th;
        }

        public boolean requiresAuthentication() {
            enforceObserveSensorPrivacyPermission();
            return SensorPrivacyService.m8094$$Nest$fgetmContext(this.this$0).getResources().getBoolean(R.bool.config_showGesturalNavigationHints);
        }

        public void showSensorUseDialog(int sensor) {
            if (Binder.getCallingUid() != 1000) goto L10;
            if (isCombinedToggleSensorPrivacyEnabled(sensor) == true) goto L7;
            return;
        L7:
            enqueueSensorUseReminderDialogAsync(-1, UserHandle.of(SensorPrivacyService.m8095$$Nest$fgetmCurrentUser(this.this$0)), PackageManagerService.PLATFORM_PACKAGE_NAME, sensor);
            return;
        L10:
            throw new SecurityException("Can only be called by the system uid");
        }

        private void userSwitching(final int from, final int to) {
            final boolean[] micState = new boolean[2];
            final boolean[] camState = new boolean[2];
            final boolean[] prevMicState = new boolean[2];
            final boolean[] prevCamState = new boolean[2];
            this.mSensorPrivacyStateController.atomic(new SensorPrivacyService$SensorPrivacyServiceImpl$$ExternalSyntheticLambda2(this, prevMicState, from, prevCamState, micState, to, camState));
            this.mSensorPrivacyStateController.atomic(new SensorPrivacyService$SensorPrivacyServiceImpl$$ExternalSyntheticLambda3(this, prevMicState, from, prevCamState, micState, to, camState));
            boolean r14 = false;
            if (from != (-10000)) goto L5;
        L8:
            this.mHandler.handleSensorPrivacyChanged(to, 1, 1, micState[0]);
            this.mHandler.handleSensorPrivacyChanged(to, 2, 1, micState[1]);
            if (micState[0] == false) goto L11;
        L14:
            boolean r11 = true;
        L15:
            setGlobalRestriction(1, r11);
        L16:
            if (from != (-10000)) goto L18;
        L21:
            this.mHandler.handleSensorPrivacyChanged(to, 1, 2, camState[0]);
            this.mHandler.handleSensorPrivacyChanged(to, 2, 2, camState[1]);
            if (camState[0] == false) goto L24;
        L25:
            r14 = true;
        L26:
            setGlobalRestriction(2, r14);
            return;
        L24:
            if (camState[1] == false) goto L26;
        L18:
            if (prevCamState[0] != camState[0]) goto L21;
            if (prevCamState[1] != camState[1]) goto L21;
            return;
        L11:
            if (micState[1] == true) goto L14;
            r11 = false;
            goto L15
        L5:
            if (prevMicState[0] != micState[0]) goto L8;
            if (prevMicState[1] == micState[1]) goto L16;
            goto L8
        }

        private /* synthetic */ void lambda$userSwitching$8(boolean[] prevMicState, int from, boolean[] prevCamState, boolean[] micState, int to, boolean[] camState) {
            prevMicState[0] = isToggleSensorPrivacyEnabledInternal(from, 1, 1);
            prevCamState[0] = isToggleSensorPrivacyEnabledInternal(from, 1, 2);
            micState[0] = isToggleSensorPrivacyEnabledInternal(to, 1, 1);
            camState[0] = isToggleSensorPrivacyEnabledInternal(to, 1, 2);
        }

        private /* synthetic */ void lambda$userSwitching$9(boolean[] prevMicState, int from, boolean[] prevCamState, boolean[] micState, int to, boolean[] camState) {
            prevMicState[1] = isToggleSensorPrivacyEnabledInternal(from, 2, 1);
            prevCamState[1] = isToggleSensorPrivacyEnabledInternal(from, 2, 2);
            micState[1] = isToggleSensorPrivacyEnabledInternal(to, 2, 1);
            camState[1] = isToggleSensorPrivacyEnabledInternal(to, 2, 2);
        }

        private void setGlobalRestriction(int sensor, boolean enabled) {
            switch(sensor) {
                case 1: goto L5;
                case 2: goto L4;
                default: goto L17;
            };
        L4:
            SensorPrivacyService.m8091$$Nest$fgetmAppOpsManagerInternal(this.this$0).setGlobalRestriction(26, enabled, SensorPrivacyService.m8092$$Nest$fgetmAppOpsRestrictionToken(this.this$0));
            SensorPrivacyService.m8091$$Nest$fgetmAppOpsManagerInternal(this.this$0).setGlobalRestriction(101, enabled, SensorPrivacyService.m8092$$Nest$fgetmAppOpsRestrictionToken(this.this$0));
            return;
        L5:
            SensorPrivacyService.m8091$$Nest$fgetmAppOpsManagerInternal(this.this$0).setGlobalRestriction(27, enabled, SensorPrivacyService.m8092$$Nest$fgetmAppOpsRestrictionToken(this.this$0));
            SensorPrivacyService.m8091$$Nest$fgetmAppOpsManagerInternal(this.this$0).setGlobalRestriction(136, enabled, SensorPrivacyService.m8092$$Nest$fgetmAppOpsRestrictionToken(this.this$0));
            SensorPrivacyService.m8091$$Nest$fgetmAppOpsManagerInternal(this.this$0).setGlobalRestriction(100, enabled, SensorPrivacyService.m8092$$Nest$fgetmAppOpsRestrictionToken(this.this$0));
            SensorPrivacyService.m8091$$Nest$fgetmAppOpsManagerInternal(this.this$0).setGlobalRestriction(120, enabled, SensorPrivacyService.m8092$$Nest$fgetmAppOpsRestrictionToken(this.this$0));
            boolean r2 = true;
            if (Settings.Global.getInt(SensorPrivacyService.m8094$$Nest$fgetmContext(this.this$0).getContentResolver(), "receive_explicit_user_interaction_audio_enabled", 1) != 1) goto L8;
            boolean allowed = true;
        L9:
            AppOpsManagerInternal r3 = SensorPrivacyService.m8091$$Nest$fgetmAppOpsManagerInternal(this.this$0);
            if (enabled == false) goto L13;
            if (allowed == true) goto L13;
        L14:
            r3.setGlobalRestriction(121, r2, SensorPrivacyService.m8092$$Nest$fgetmAppOpsRestrictionToken(this.this$0));
            return;
        L13:
            r2 = false;
            goto L14
        L8:
            allowed = false;
            goto L9
        }

        private void removeSuppressPackageReminderToken(Pair<Integer, UserHandle> key, IBinder token) {
            Object r0 = this.mLock;
            monitor-enter(r0);
            ArrayList<IBinder> suppressPackageReminderTokens = this.mSuppressReminders.get(key);     // Catch: Throwable -> L9
            if (suppressPackageReminderTokens != null) goto L11;
            Log.e(SensorPrivacyService.m8106$$Nest$sfgetTAG(), "No tokens for " + key);     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L11:
            boolean wasRemoved = suppressPackageReminderTokens.remove(token);     // Catch: Throwable -> L9
            if (wasRemoved == false) goto L16;
            token.unlinkToDeath(this, 0);     // Catch: Throwable -> L9
            if (suppressPackageReminderTokens.isEmpty() == false) goto L17;
            this.mSuppressReminders.remove(key);     // Catch: Throwable -> L9
        L17:
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L16:
            Log.w(SensorPrivacyService.m8106$$Nest$sfgetTAG(), "Could not remove sensor use reminder suppression token " + token + " from " + key);     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            throw th;
        }

        private void registerSettingsObserver() {
            ContentResolver r0 = SensorPrivacyService.m8094$$Nest$fgetmContext(this.this$0).getContentResolver();
            Uri r1 = Settings.Global.getUriFor("receive_explicit_user_interaction_audio_enabled");
            final SensorPrivacyHandler r3 = this.mHandler;
            r0.registerContentObserver(r1, false, new AnonymousClass3(this, r3));
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied(IBinder token) {
            Object r0 = this.mLock;
            monitor-enter(r0);
            Iterator<Pair<Integer, UserHandle>> r1 = this.mSuppressReminders.keySet().iterator();     // Catch: Throwable -> L8
        L6:
            if (r1.hasNext() == false) goto L10;
            Pair<Integer, UserHandle> key = r1.next();     // Catch: Throwable -> L8
            removeSuppressPackageReminderToken(key, token);     // Catch: Throwable -> L8
            goto L6
        L10:
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            throw th;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
        }

        public void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
            fd.getClass();
            if (DumpUtils.checkDumpPermission(SensorPrivacyService.m8094$$Nest$fgetmContext(this.this$0), SensorPrivacyService.m8106$$Nest$sfgetTAG(), pw) == true) goto L5;
            return;
        L5:
            int opti = 0;
            boolean dumpAsProto = false;
        L7:
            if (opti >= args.length) goto L20;
            String opt = args[opti];
            if (opt == null) goto L20;
            if (opt.length() <= 0) goto L20;
            if (opt.charAt(0) != '-') goto L20;
            opti = opti + 1;
            if ("--proto".equals(opt) == true) goto L17;
            pw.println("Unknown argument: " + opt + "; use -h for help");
            goto L7
        L17:
            dumpAsProto = true;
        L20:
            long identity = Binder.clearCallingIdentity();
            if (dumpAsProto == false) goto L25;
            this.mSensorPrivacyStateController.dump(new DualDumpOutputStream(new ProtoOutputStream(fd)));     // Catch: Throwable -> L23
        L26:
            Binder.restoreCallingIdentity(identity);
            return;
        L25:
            pw.println("SENSOR PRIVACY MANAGER STATE (dumpsys sensor_privacy)");     // Catch: Throwable -> L23
            this.mSensorPrivacyStateController.dump(new DualDumpOutputStream(new IndentingPrintWriter(pw, "  ")));     // Catch: Throwable -> L23
        L23:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        private int sensorStrToId(String sensor) {
            if (sensor != null) goto L6;
            return 0;
        L6:
            switch(sensor.hashCode()) {
                case -1367751899: goto L12;
                case 1370921258: goto L9;
                default: goto L14;
            };
        L14:
            byte r1 = -1;
        L15:
            switch(r1) {
                case 0: goto L19;
                case 1: goto L17;
                default: goto L16;
            };
        L16:
            return 0;
        L17:
            return 2;
        L19:
            return 1;
        L9:
            if (sensor.equals("microphone") == false) goto L14;
            r1 = 0;
            goto L15
        L12:
            if (sensor.equals("camera") == false) goto L14;
            r1 = 1;
            goto L15
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void onShellCommand(FileDescriptor in, FileDescriptor out, FileDescriptor err, String[] args, ShellCallback callback, ResultReceiver resultReceiver) {
            new AnonymousClass4(this).exec(this, in, out, err, args, callback, resultReceiver);
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmActivityManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ ActivityManager m8087$$Nest$fgetmActivityManager(SensorPrivacyService r0) {
        return r0.mActivityManager;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmActivityManagerInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ ActivityManagerInternal m8088$$Nest$fgetmActivityManagerInternal(SensorPrivacyService r0) {
        return r0.mActivityManagerInternal;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmActivityTaskManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ ActivityTaskManager m8089$$Nest$fgetmActivityTaskManager(SensorPrivacyService r0) {
        return r0.mActivityTaskManager;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAppOpsManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ AppOpsManager m8090$$Nest$fgetmAppOpsManager(SensorPrivacyService r0) {
        return r0.mAppOpsManager;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAppOpsManagerInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ AppOpsManagerInternal m8091$$Nest$fgetmAppOpsManagerInternal(SensorPrivacyService r0) {
        return r0.mAppOpsManagerInternal;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAppOpsRestrictionToken, reason: not valid java name */
    static /* bridge */ /* synthetic */ IBinder m8092$$Nest$fgetmAppOpsRestrictionToken(SensorPrivacyService r0) {
        return r0.mAppOpsRestrictionToken;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCallStateHelper, reason: not valid java name */
    static /* bridge */ /* synthetic */ CallStateHelper m8093$$Nest$fgetmCallStateHelper(SensorPrivacyService r0) {
        return r0.mCallStateHelper;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m8094$$Nest$fgetmContext(SensorPrivacyService r0) {
        return r0.mContext;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCurrentUser, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m8095$$Nest$fgetmCurrentUser(SensorPrivacyService r0) {
        return r0.mCurrentUser;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmKeyguardManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ KeyguardManager m8096$$Nest$fgetmKeyguardManager(SensorPrivacyService r0) {
        return r0.mKeyguardManager;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmNotificationManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ NotificationManager m8097$$Nest$fgetmNotificationManager(SensorPrivacyService r0) {
        return r0.mNotificationManager;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPackageManagerInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ PackageManagerInternal m8098$$Nest$fgetmPackageManagerInternal(SensorPrivacyService r0) {
        return r0.mPackageManagerInternal;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSensorPrivacyManagerInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ SensorPrivacyManagerInternalImpl m8099$$Nest$fgetmSensorPrivacyManagerInternal(SensorPrivacyService r0) {
        return r0.mSensorPrivacyManagerInternal;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSensorPrivacyServiceImpl, reason: not valid java name */
    static /* bridge */ /* synthetic */ SensorPrivacyServiceImpl m8100$$Nest$fgetmSensorPrivacyServiceImpl(SensorPrivacyService r0) {
        return r0.mSensorPrivacyServiceImpl;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmTelephonyManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ TelephonyManager m8101$$Nest$fgetmTelephonyManager(SensorPrivacyService r0) {
        return r0.mTelephonyManager;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmUserManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ UserManager m8102$$Nest$fgetmUserManager(SensorPrivacyService r0) {
        return r0.mUserManager;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmUserManagerInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ UserManagerInternal m8103$$Nest$fgetmUserManagerInternal(SensorPrivacyService r0) {
        return r0.mUserManagerInternal;
    }

    /* JADX INFO: renamed from: -$$Nest$mforAllUsers, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8104$$Nest$mforAllUsers(SensorPrivacyService r0, FunctionalUtils.ThrowingConsumer r1) {
        r0.forAllUsers(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetACTION_DISABLE_TOGGLE_SENSOR_PRIVACY, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m8105$$Nest$sfgetACTION_DISABLE_TOGGLE_SENSOR_PRIVACY() {
        return ACTION_DISABLE_TOGGLE_SENSOR_PRIVACY;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetTAG, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m8106$$Nest$sfgetTAG() {
        return TAG;
    }

    static {
        TAG = SensorPrivacyService.class.getSimpleName();
        ACTION_DISABLE_TOGGLE_SENSOR_PRIVACY = SensorPrivacyService.class.getName() + ".action.disable_sensor_privacy";
    }

    public SensorPrivacyService(Context context) {
        super(context);
        this.mAppOpsRestrictionToken = new Binder();
        this.mCameraPrivacyAllowlist = new ArrayList();
        this.mCurrentUser = ProcessList.INVALID_ADJ;
        this.mContext = context;
        this.mAppOpsManager = (AppOpsManager) context.getSystemService(AppOpsManager.class);
        this.mAppOpsManagerInternal = (AppOpsManagerInternal) getLocalService(AppOpsManagerInternal.class);
        this.mUserManagerInternal = (UserManagerInternal) getLocalService(UserManagerInternal.class);
        this.mActivityManager = (ActivityManager) context.getSystemService(ActivityManager.class);
        this.mActivityManagerInternal = (ActivityManagerInternal) getLocalService(ActivityManagerInternal.class);
        this.mActivityTaskManager = (ActivityTaskManager) context.getSystemService(ActivityTaskManager.class);
        this.mTelephonyManager = (TelephonyManager) context.getSystemService(TelephonyManager.class);
        this.mPackageManagerInternal = (PackageManagerInternal) getLocalService(PackageManagerInternal.class);
        this.mNotificationManager = (NotificationManager) this.mContext.getSystemService(NotificationManager.class);
        this.mUserManager = (UserManager) context.getSystemService(UserManager.class);
        this.mSensorPrivacyServiceImpl = new SensorPrivacyServiceImpl(this);
        Iterator<String> r0 = SystemConfig.getInstance().getCameraPrivacyAllowlist().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        String entry = r0.next();
        this.mCameraPrivacyAllowlist.add(entry);
        goto L4
    }

    @Override // com.android.server.SystemService
    public void onStart() {
        publishBinderService(SENSOR_PRIVACY_CHANNEL_ID, this.mSensorPrivacyServiceImpl);
        this.mSensorPrivacyManagerInternal = new SensorPrivacyManagerInternalImpl(this, null);
        publishLocalService(SensorPrivacyManagerInternal.class, this.mSensorPrivacyManagerInternal);
    }

    @Override // com.android.server.SystemService
    public void onBootPhase(int phase) {
        if (phase != 500) goto L6;
        this.mKeyguardManager = (KeyguardManager) this.mContext.getSystemService(KeyguardManager.class);
        this.mCallStateHelper = new CallStateHelper(this);
        SensorPrivacyServiceImpl.m8123$$Nest$mregisterSettingsObserver(this.mSensorPrivacyServiceImpl);
        return;
    L6:
        if (phase != 550) goto L10;
        this.mCameraPrivacyLightController = new CameraPrivacyLightController(this.mContext);
        return;
    }

    @Override // com.android.server.SystemService
    public void onUserStarting(SystemService.TargetUser user) {
        if (this.mCurrentUser != (-10000)) goto L6;
        this.mCurrentUser = user.getUserIdentifier();
        SensorPrivacyServiceImpl.m8129$$Nest$muserSwitching(this.mSensorPrivacyServiceImpl, ProcessList.INVALID_ADJ, user.getUserIdentifier());
        return;
    }

    @Override // com.android.server.SystemService
    public void onUserSwitching(SystemService.TargetUser from, SystemService.TargetUser to) {
        this.mCurrentUser = to.getUserIdentifier();
        SensorPrivacyServiceImpl.m8129$$Nest$muserSwitching(this.mSensorPrivacyServiceImpl, from.getUserIdentifier(), to.getUserIdentifier());
    }

    private void forAllUsers(FunctionalUtils.ThrowingConsumer<Integer> c) {
        int[] userIds = this.mUserManagerInternal.getUserIds();
        int i = 0;
    L4:
        if (i >= userIds.length) goto L7;
        c.accept(Integer.valueOf(userIds[i]));
        i = i + 1;
        goto L4
    }

    static long getCurrentTimeMillis() {
        return SystemClock.elapsedRealtime();
    }
}
