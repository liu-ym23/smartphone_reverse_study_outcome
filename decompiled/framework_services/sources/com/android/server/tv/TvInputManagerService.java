package com.android.server.tv;

import android.R;
import android.app.ActivityManager;
import android.content.AttributionSource;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.pm.UserInfo;
import android.graphics.Rect;
import android.hardware.hdmi.HdmiControlManager;
import android.hardware.hdmi.HdmiDeviceInfo;
import android.hardware.hdmi.HdmiTvClient;
import android.media.AudioPresentation;
import android.media.PlaybackParams;
import android.media.quality.MediaQualityManager;
import android.media.tv.AdBuffer;
import android.media.tv.AdRequest;
import android.media.tv.AdResponse;
import android.media.tv.AitInfo;
import android.media.tv.BroadcastInfoRequest;
import android.media.tv.BroadcastInfoResponse;
import android.media.tv.DvbDeviceInfo;
import android.media.tv.ITvInputClient;
import android.media.tv.ITvInputHardware;
import android.media.tv.ITvInputHardwareCallback;
import android.media.tv.ITvInputManager;
import android.media.tv.ITvInputManagerCallback;
import android.media.tv.ITvInputService;
import android.media.tv.ITvInputServiceCallback;
import android.media.tv.ITvInputSession;
import android.media.tv.ITvInputSessionCallback;
import android.media.tv.TunedInfo;
import android.media.tv.TvContentRating;
import android.media.tv.TvContentRatingSystemInfo;
import android.media.tv.TvContract;
import android.media.tv.TvInputHardwareInfo;
import android.media.tv.TvInputInfo;
import android.media.tv.TvStreamConfig;
import android.media.tv.TvTrackInfo;
import android.media.tv.tunerresourcemanager.TunerResourceManager;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.ParcelFileDescriptor;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.SharedMemory;
import android.os.UserHandle;
import android.os.UserManager;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Pair;
import android.util.Slog;
import android.util.SparseArray;
import android.view.InputChannel;
import android.view.Surface;
import com.android.internal.content.PackageMonitor;
import com.android.internal.os.SomeArgs;
import com.android.internal.util.CollectionUtils;
import com.android.internal.util.DumpUtils;
import com.android.internal.util.FrameworkStatsLog;
import com.android.internal.util.IndentingPrintWriter;
import com.android.server.IoThread;
import com.android.server.SystemService;
import com.android.server.am.HostingRecord;
import com.android.server.job.controllers.JobStatus;
import com.android.server.pm.PackageManagerService;
import com.android.server.slice.SliceClientPermissions;
import dalvik.annotation.optimization.NeverCompile;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.tukaani.xz.LZMA2Options;

/* JADX INFO: loaded from: classes3.dex */
public final class TvInputManagerService extends SystemService {
    private static final int APP_TAG_SELF = 0;
    private static final boolean DEBUG = false;
    private static final String DVB_DIRECTORY = "/dev/dvb";
    private static final String PERMISSION_ACCESS_WATCHED_PROGRAMS = "com.android.providers.tv.permission.ACCESS_WATCHED_PROGRAMS";
    private static final long SET_TV_AS_ACTIVE_SOURCE_IF_NO_REQUEST_DELAY_IN_MILLIS = 10000;
    private static final String TAG = "TvInputManagerService";
    private static final long UPDATE_HARDWARE_TIS_BINDING_DELAY_IN_MILLIS = 10000;
    private static final Pattern sAdapterDirPattern = null;
    private static final Pattern sFrontEndDevicePattern = null;
    private static final Pattern sFrontEndInAdapterDirPattern = null;
    private final ActivityManager mActivityManager;
    private final Context mContext;
    private int mCurrentUserId;
    private final List<String> mExternalInputLoggingDeviceBrandNames;
    private final HashSet<String> mExternalInputLoggingDeviceOnScreenDisplayNames;
    private boolean mExternalInputLoggingDisplayNameFilterEnabled;
    private HdmiControlManager mHdmiControlManager;
    private HdmiTvClient mHdmiTvClient;
    private final Object mLock;
    private MediaQualityManager mMediaQualityManager;
    private final MessageHandler mMessageHandler;
    private String mOnScreenInputId;
    private SessionState mOnScreenSessionState;
    private final MyPackageMonitor mPackageMonitor;
    private final Set<Integer> mRunningProfiles;
    private final Map<String, SessionState> mSessionIdToSessionStateMap;
    private final TvInputHardwareManager mTvInputHardwareManager;
    private final UserManager mUserManager;
    private final SparseArray<UserState> mUserStates;

    private final class BinderService extends ITvInputManager.Stub {
        final /* synthetic */ TvInputManagerService this$0;

        /* synthetic */ BinderService(TvInputManagerService r1, TvInputManagerServiceIA r2) {
            this(r1);
        }

        private BinderService(TvInputManagerService r1) {
            this.this$0 = r1;
        }

        public List<TvInputInfo> getTvInputList(int userId) {
            int resolvedUserId = TvInputManagerService.m8791$$Nest$mresolveCallingUserId(this.this$0, Binder.getCallingPid(), Binder.getCallingUid(), userId, "getTvInputList");
            long identity = Binder.clearCallingIdentity();
            Object r3 = TvInputManagerService.m8756$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L16
            monitor-enter(r3);     // Catch: Throwable -> L16
            UserState userState = TvInputManagerService.m8775$$Nest$mgetOrCreateUserStateLocked(this.this$0, resolvedUserId);     // Catch: Throwable -> L9
            List<TvInputInfo> inputList = new ArrayList();     // Catch: Throwable -> L9
            Iterator r6 = UserState.m8862$$Nest$fgetinputMap(userState).values().iterator();     // Catch: Throwable -> L9
        L7:
            if (r6.hasNext() == false) goto L11;
            TvInputState state = (TvInputState) r6.next();     // Catch: Throwable -> L9
            inputList.add(TvInputState.m8851$$Nest$fgetinfo(state));     // Catch: Throwable -> L9
            goto L7
        L11:
            monitor-exit(r3);     // Catch: Throwable -> L9
            Binder.restoreCallingIdentity(identity);
            return inputList;
        L9:
            th = move-exception;
            throw th;     // Catch: Throwable -> L16
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public TvInputInfo getTvInputInfo(String inputId, int userId) {
            int resolvedUserId = TvInputManagerService.m8791$$Nest$mresolveCallingUserId(this.this$0, Binder.getCallingPid(), Binder.getCallingUid(), userId, "getTvInputInfo");
            long identity = Binder.clearCallingIdentity();
            Object r3 = TvInputManagerService.m8756$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L15
            monitor-enter(r3);     // Catch: Throwable -> L15
            UserState userState = TvInputManagerService.m8775$$Nest$mgetOrCreateUserStateLocked(this.this$0, resolvedUserId);     // Catch: Throwable -> L12
            TvInputState state = (TvInputState) UserState.m8862$$Nest$fgetinputMap(userState).get(inputId);     // Catch: Throwable -> L12
            if (state != null) goto L8;
            TvInputInfo r6 = null;
        L9:
            monitor-exit(r3);     // Catch: Throwable -> L12
            Binder.restoreCallingIdentity(identity);
            return r6;
        L8:
            r6 = TvInputState.m8851$$Nest$fgetinfo(state);     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            throw th;     // Catch: Throwable -> L15
        L15:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void updateTvInputInfo(TvInputInfo inputInfo, int userId) {
            String inputInfoPackageName = inputInfo.getServiceInfo().packageName;
            String callingPackageName = getCallingPackageName();
            if (TextUtils.equals(inputInfoPackageName, callingPackageName) == false) goto L5;
        L9:
            int resolvedUserId = TvInputManagerService.m8791$$Nest$mresolveCallingUserId(this.this$0, Binder.getCallingPid(), Binder.getCallingUid(), userId, "updateTvInputInfo");
            long identity = Binder.clearCallingIdentity();
            Object r5 = TvInputManagerService.m8756$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L19
            monitor-enter(r5);     // Catch: Throwable -> L19
            UserState userState = TvInputManagerService.m8775$$Nest$mgetOrCreateUserStateLocked(this.this$0, resolvedUserId);     // Catch: Throwable -> L16
            TvInputManagerService.m8801$$Nest$mupdateTvInputInfoLocked(this.this$0, userState, inputInfo);     // Catch: Throwable -> L16
            monitor-exit(r5);     // Catch: Throwable -> L16
            Binder.restoreCallingIdentity(identity);
            return;
        L16:
            th = move-exception;
            throw th;     // Catch: Throwable -> L19
        L19:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        L5:
            if (TvInputManagerService.m8754$$Nest$fgetmContext(this.this$0).checkCallingPermission("android.permission.WRITE_SECURE_SETTINGS") == 0) goto L9;
            throw new IllegalArgumentException("calling package " + callingPackageName + " is not allowed to change TvInputInfo for " + inputInfoPackageName);
        }

        private String getCallingPackageName() {
            String[] packages = TvInputManagerService.m8754$$Nest$fgetmContext(this.this$0).getPackageManager().getPackagesForUid(Binder.getCallingUid());
            if (packages != null) goto L5;
            return "unknown";
        L5:
            if (packages.length > 0) goto L7;
            return "unknown";
        L7:
            return packages[0];
        }

        public int getTvInputState(String inputId, int userId) {
            int resolvedUserId = TvInputManagerService.m8791$$Nest$mresolveCallingUserId(this.this$0, Binder.getCallingPid(), Binder.getCallingUid(), userId, "getTvInputState");
            long identity = Binder.clearCallingIdentity();
            Object r3 = TvInputManagerService.m8756$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L15
            monitor-enter(r3);     // Catch: Throwable -> L15
            UserState userState = TvInputManagerService.m8775$$Nest$mgetOrCreateUserStateLocked(this.this$0, resolvedUserId);     // Catch: Throwable -> L12
            TvInputState state = (TvInputState) UserState.m8862$$Nest$fgetinputMap(userState).get(inputId);     // Catch: Throwable -> L12
            if (state != null) goto L8;
            int r6 = 0;
        L9:
            monitor-exit(r3);     // Catch: Throwable -> L12
            Binder.restoreCallingIdentity(identity);
            return r6;
        L8:
            r6 = TvInputState.m8853$$Nest$fgetstate(state);     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            throw th;     // Catch: Throwable -> L15
        L15:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public List<String> getAvailableExtensionInterfaceNames(String inputId, int userId) {
            ensureTisExtensionInterfacePermission();
            int callingUid = Binder.getCallingUid();
            int callingPid = Binder.getCallingPid();
            int resolvedUserId = TvInputManagerService.m8791$$Nest$mresolveCallingUserId(this.this$0, callingPid, callingUid, userId, "getAvailableExtensionInterfaceNames");
            long identity = Binder.clearCallingIdentity();
            ITvInputService service = null;
            Object r6 = TvInputManagerService.m8756$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L26
            monitor-enter(r6);     // Catch: Throwable -> L26
            UserState userState = TvInputManagerService.m8775$$Nest$mgetOrCreateUserStateLocked(this.this$0, resolvedUserId);     // Catch: Throwable -> L14
            TvInputState inputState = (TvInputState) UserState.m8862$$Nest$fgetinputMap(userState).get(inputId);     // Catch: Throwable -> L14
            if (inputState == null) goto L16;
            ServiceState serviceState = (ServiceState) UserState.m8869$$Nest$fgetserviceStateMap(userState).get(TvInputState.m8851$$Nest$fgetinfo(inputState).getComponent());     // Catch: Throwable -> L14
            if (serviceState == null) goto L16;
            if (ServiceState.m8818$$Nest$fgetisHardware(serviceState) == false) goto L16;
            if (ServiceState.m8821$$Nest$fgetservice(serviceState) == null) goto L16;
            service = ServiceState.m8821$$Nest$fgetservice(serviceState);     // Catch: Throwable -> L14
        L16:
            monitor-exit(r6);     // Catch: Throwable -> L14
            if (service != null) goto L44;
        L37:
            ArrayList r7 = new ArrayList();     // Catch: Throwable -> L26
            Binder.restoreCallingIdentity(identity);
            return r7;
        L44:
            List<String> interfaces = new ArrayList();     // Catch: Throwable -> L26 RemoteException -> L28
            Iterator r8 = CollectionUtils.emptyIfNull(service.getAvailableExtensionInterfaceNames()).iterator();     // Catch: Throwable -> L26 RemoteException -> L28
        L19:
            if (r8.hasNext() == false) goto L32;
            String name = (String) r8.next();     // Catch: Throwable -> L26 RemoteException -> L28
            String permission = service.getExtensionInterfacePermission(name);     // Catch: Throwable -> L26 RemoteException -> L28
            if (permission == null) goto L30;
            if (TvInputManagerService.m8754$$Nest$fgetmContext(this.this$0).checkPermission(permission, callingPid, callingUid) != 0) goto L19;
        L30:
            interfaces.add(name);     // Catch: Throwable -> L26 RemoteException -> L28
            goto L19
        L32:
            Binder.restoreCallingIdentity(identity);
            return interfaces;
        L28:
            e = move-exception;
            Slog.e(TvInputManagerService.TAG, "error in getAvailableExtensionInterfaceNames or getExtensionInterfacePermission", e);     // Catch: Throwable -> L26
            goto L37
        L14:
            th = move-exception;
            throw th;     // Catch: Throwable -> L26
        L26:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public IBinder getExtensionInterface(String inputId, String name, int userId) {
            ensureTisExtensionInterfacePermission();
            int callingUid = Binder.getCallingUid();
            int callingPid = Binder.getCallingPid();
            int resolvedUserId = TvInputManagerService.m8791$$Nest$mresolveCallingUserId(this.this$0, callingPid, callingUid, userId, "getExtensionInterface");
            long identity = Binder.clearCallingIdentity();
            ITvInputService service = null;
            Object r6 = TvInputManagerService.m8756$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L23
            monitor-enter(r6);     // Catch: Throwable -> L23
            UserState userState = TvInputManagerService.m8775$$Nest$mgetOrCreateUserStateLocked(this.this$0, resolvedUserId);     // Catch: Throwable -> L14
            TvInputState inputState = (TvInputState) UserState.m8862$$Nest$fgetinputMap(userState).get(inputId);     // Catch: Throwable -> L14
            if (inputState == null) goto L16;
            ServiceState serviceState = (ServiceState) UserState.m8869$$Nest$fgetserviceStateMap(userState).get(TvInputState.m8851$$Nest$fgetinfo(inputState).getComponent());     // Catch: Throwable -> L14
            if (serviceState == null) goto L16;
            if (ServiceState.m8818$$Nest$fgetisHardware(serviceState) == false) goto L16;
            if (ServiceState.m8821$$Nest$fgetservice(serviceState) == null) goto L16;
            service = ServiceState.m8821$$Nest$fgetservice(serviceState);     // Catch: Throwable -> L14
        L16:
            monitor-exit(r6);     // Catch: Throwable -> L14
            if (service != null) goto L40;
        L34:
            Binder.restoreCallingIdentity(identity);
            return null;
        L40:
            String permission = service.getExtensionInterfacePermission(name);     // Catch: Throwable -> L23 RemoteException -> L25
            if (permission != null) goto L21;
        L27:
            IBinder r7 = service.getExtensionInterface(name);     // Catch: Throwable -> L23 RemoteException -> L25
            Binder.restoreCallingIdentity(identity);
            return r7;
        L21:
            if (TvInputManagerService.m8754$$Nest$fgetmContext(this.this$0).checkPermission(permission, callingPid, callingUid) != 0) goto L34;
        L25:
            e = move-exception;
            Slog.e(TvInputManagerService.TAG, "error in getExtensionInterfacePermission or getExtensionInterface", e);     // Catch: Throwable -> L23
            goto L34
        L14:
            th = move-exception;
            throw th;     // Catch: Throwable -> L23
        L23:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public List<TvContentRatingSystemInfo> getTvContentRatingSystemList(int userId) {
            if (TvInputManagerService.m8754$$Nest$fgetmContext(this.this$0).checkCallingPermission("android.permission.READ_CONTENT_RATING_SYSTEMS") != 0) goto L18;
            int resolvedUserId = TvInputManagerService.m8791$$Nest$mresolveCallingUserId(this.this$0, Binder.getCallingPid(), Binder.getCallingUid(), userId, "getTvContentRatingSystemList");
            long identity = Binder.clearCallingIdentity();
            Object r3 = TvInputManagerService.m8756$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L14
            monitor-enter(r3);     // Catch: Throwable -> L14
            UserState userState = TvInputManagerService.m8775$$Nest$mgetOrCreateUserStateLocked(this.this$0, resolvedUserId);     // Catch: Throwable -> L11
            List<TvContentRatingSystemInfo> r5 = UserState.m8861$$Nest$fgetcontentRatingSystemList(userState);     // Catch: Throwable -> L11
            monitor-exit(r3);     // Catch: Throwable -> L11
            Binder.restoreCallingIdentity(identity);
            return r5;
        L11:
            th = move-exception;
            throw th;     // Catch: Throwable -> L14
        L14:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        L18:
            throw new SecurityException("The caller does not have permission to read content rating systems");
        }

        public void sendTvInputNotifyIntent(Intent intent, int userId) {
            if (TvInputManagerService.m8754$$Nest$fgetmContext(this.this$0).checkCallingPermission("android.permission.NOTIFY_TV_INPUTS") != 0) goto L51;
            if (TextUtils.isEmpty(intent.getPackage()) == true) goto L49;
            String r0 = intent.getAction();
            switch(r0.hashCode()) {
                case -160295064: goto L16;
                case 1568780589: goto L13;
                case 2011523553: goto L10;
                default: goto L18;
            };
        L18:
            byte r1 = -1;
        L20:
            switch(r1) {
                case 0: goto L38;
                case 1: goto L33;
                case 2: goto L24;
                default: goto L22;
            };
        L22:
            throw new IllegalArgumentException("Invalid TV input notifying action: " + intent.getAction());
        L24:
            if (intent.getLongExtra("android.media.tv.extra.PREVIEW_PROGRAM_ID", -1) < 0) goto L31;
            if (intent.getLongExtra("android.media.tv.extra.WATCH_NEXT_PROGRAM_ID", -1) < 0) goto L29;
        L39:
            int resolvedUserId = TvInputManagerService.m8791$$Nest$mresolveCallingUserId(this.this$0, Binder.getCallingPid(), Binder.getCallingUid(), userId, "sendTvInputNotifyIntent");
            long identity = Binder.clearCallingIdentity();
            this.this$0.getContext().sendBroadcastAsUser(intent, new UserHandle(resolvedUserId));     // Catch: Throwable -> L43
            Binder.restoreCallingIdentity(identity);
            return;
        L43:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        L29:
            throw new IllegalArgumentException("Invalid watch next program ID.");
        L31:
            throw new IllegalArgumentException("Invalid preview program ID.");
        L33:
            if (intent.getLongExtra("android.media.tv.extra.WATCH_NEXT_PROGRAM_ID", -1) >= 0) goto L39;
            throw new IllegalArgumentException("Invalid watch next program ID.");
        L38:
            if (intent.getLongExtra("android.media.tv.extra.PREVIEW_PROGRAM_ID", -1) >= 0) goto L39;
            throw new IllegalArgumentException("Invalid preview program ID.");
        L10:
            if (r0.equals("android.media.tv.action.PREVIEW_PROGRAM_ADDED_TO_WATCH_NEXT") == false) goto L18;
            r1 = 2;
            goto L20
        L13:
            if (r0.equals("android.media.tv.action.PREVIEW_PROGRAM_BROWSABLE_DISABLED") == false) goto L18;
            r1 = 0;
            goto L20
        L16:
            if (r0.equals("android.media.tv.action.WATCH_NEXT_PROGRAM_BROWSABLE_DISABLED") == false) goto L18;
            r1 = 1;
            goto L20
        L49:
            throw new IllegalArgumentException("Must specify package name to notify.");
        L51:
            throw new SecurityException("The caller: " + getCallingPackageName() + " doesn't have permission: android.permission.NOTIFY_TV_INPUTS");
        }

        public void registerCallback(ITvInputManagerCallback callback, int userId) {
            int callingPid = Binder.getCallingPid();
            int callingUid = Binder.getCallingUid();
            int resolvedUserId = TvInputManagerService.m8791$$Nest$mresolveCallingUserId(this.this$0, callingPid, callingUid, userId, "registerCallback");
            long identity = Binder.clearCallingIdentity();
            Object r5 = TvInputManagerService.m8756$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L16
            monitor-enter(r5);     // Catch: Throwable -> L16
            UserState userState = TvInputManagerService.m8775$$Nest$mgetOrCreateUserStateLocked(this.this$0, resolvedUserId);     // Catch: Throwable -> L8
            if (UserState.m8864$$Nest$fgetmCallbacks(userState).register(callback) == true) goto L10;
            Slog.e(TvInputManagerService.TAG, "client process has already died");     // Catch: Throwable -> L8
        L11:
            monitor-exit(r5);     // Catch: Throwable -> L8
            Binder.restoreCallingIdentity(identity);
            return;
        L10:
            UserState.m8859$$Nest$fgetcallbackPidUidMap(userState).put(callback, Pair.create(Integer.valueOf(callingPid), Integer.valueOf(callingUid)));     // Catch: Throwable -> L8
        L8:
            th = move-exception;
            throw th;     // Catch: Throwable -> L16
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void unregisterCallback(ITvInputManagerCallback callback, int userId) {
            int resolvedUserId = TvInputManagerService.m8791$$Nest$mresolveCallingUserId(this.this$0, Binder.getCallingPid(), Binder.getCallingUid(), userId, "unregisterCallback");
            long identity = Binder.clearCallingIdentity();
            Object r3 = TvInputManagerService.m8756$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L12
            monitor-enter(r3);     // Catch: Throwable -> L12
            UserState userState = TvInputManagerService.m8775$$Nest$mgetOrCreateUserStateLocked(this.this$0, resolvedUserId);     // Catch: Throwable -> L9
            UserState.m8864$$Nest$fgetmCallbacks(userState).unregister(callback);     // Catch: Throwable -> L9
            UserState.m8859$$Nest$fgetcallbackPidUidMap(userState).remove(callback);     // Catch: Throwable -> L9
            monitor-exit(r3);     // Catch: Throwable -> L9
            Binder.restoreCallingIdentity(identity);
            return;
        L9:
            th = move-exception;
            throw th;     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public boolean isParentalControlsEnabled(int userId) {
            int resolvedUserId = TvInputManagerService.m8791$$Nest$mresolveCallingUserId(this.this$0, Binder.getCallingPid(), Binder.getCallingUid(), userId, "isParentalControlsEnabled");
            long identity = Binder.clearCallingIdentity();
            Object r3 = TvInputManagerService.m8756$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L12
            monitor-enter(r3);     // Catch: Throwable -> L12
            UserState userState = TvInputManagerService.m8775$$Nest$mgetOrCreateUserStateLocked(this.this$0, resolvedUserId);     // Catch: Throwable -> L9
            boolean r5 = UserState.m8868$$Nest$fgetpersistentDataStore(userState).isParentalControlsEnabled();     // Catch: Throwable -> L9
            monitor-exit(r3);     // Catch: Throwable -> L9
            Binder.restoreCallingIdentity(identity);
            return r5;
        L9:
            th = move-exception;
            throw th;     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void setParentalControlsEnabled(boolean enabled, int userId) {
            ensureParentalControlsPermission();
            int resolvedUserId = TvInputManagerService.m8791$$Nest$mresolveCallingUserId(this.this$0, Binder.getCallingPid(), Binder.getCallingUid(), userId, "setParentalControlsEnabled");
            long identity = Binder.clearCallingIdentity();
            Object r3 = TvInputManagerService.m8756$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L12
            monitor-enter(r3);     // Catch: Throwable -> L12
            UserState userState = TvInputManagerService.m8775$$Nest$mgetOrCreateUserStateLocked(this.this$0, resolvedUserId);     // Catch: Throwable -> L9
            UserState.m8868$$Nest$fgetpersistentDataStore(userState).setParentalControlsEnabled(enabled);     // Catch: Throwable -> L9
            monitor-exit(r3);     // Catch: Throwable -> L9
            Binder.restoreCallingIdentity(identity);
            return;
        L9:
            th = move-exception;
            throw th;     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public boolean isRatingBlocked(String rating, int userId) {
            int resolvedUserId = TvInputManagerService.m8791$$Nest$mresolveCallingUserId(this.this$0, Binder.getCallingPid(), Binder.getCallingUid(), userId, "isRatingBlocked");
            long identity = Binder.clearCallingIdentity();
            Object r3 = TvInputManagerService.m8756$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L12
            monitor-enter(r3);     // Catch: Throwable -> L12
            UserState userState = TvInputManagerService.m8775$$Nest$mgetOrCreateUserStateLocked(this.this$0, resolvedUserId);     // Catch: Throwable -> L9
            boolean r5 = UserState.m8868$$Nest$fgetpersistentDataStore(userState).isRatingBlocked(TvContentRating.unflattenFromString(rating));     // Catch: Throwable -> L9
            monitor-exit(r3);     // Catch: Throwable -> L9
            Binder.restoreCallingIdentity(identity);
            return r5;
        L9:
            th = move-exception;
            throw th;     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public List<String> getBlockedRatings(int userId) {
            int resolvedUserId = TvInputManagerService.m8791$$Nest$mresolveCallingUserId(this.this$0, Binder.getCallingPid(), Binder.getCallingUid(), userId, "getBlockedRatings");
            long identity = Binder.clearCallingIdentity();
            Object r3 = TvInputManagerService.m8756$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L15
            monitor-enter(r3);     // Catch: Throwable -> L15
            UserState userState = TvInputManagerService.m8775$$Nest$mgetOrCreateUserStateLocked(this.this$0, resolvedUserId);     // Catch: Throwable -> L8
            List<String> ratings = new ArrayList();     // Catch: Throwable -> L8
            TvContentRating[] r6 = UserState.m8868$$Nest$fgetpersistentDataStore(userState).getBlockedRatings();     // Catch: Throwable -> L8
            int r7 = r6.length;     // Catch: Throwable -> L8
            int r8 = 0;
        L6:
            if (r8 >= r7) goto L10;
            TvContentRating rating = r6[r8];     // Catch: Throwable -> L8
            ratings.add(rating.flattenToString());     // Catch: Throwable -> L8
            r8 = r8 + 1;     // Catch: Throwable -> L8
            goto L6
        L10:
            monitor-exit(r3);     // Catch: Throwable -> L8
            Binder.restoreCallingIdentity(identity);
            return ratings;
        L8:
            th = move-exception;
            throw th;     // Catch: Throwable -> L15
        L15:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void addBlockedRating(String rating, int userId) {
            ensureParentalControlsPermission();
            int resolvedUserId = TvInputManagerService.m8791$$Nest$mresolveCallingUserId(this.this$0, Binder.getCallingPid(), Binder.getCallingUid(), userId, "addBlockedRating");
            long identity = Binder.clearCallingIdentity();
            Object r3 = TvInputManagerService.m8756$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L12
            monitor-enter(r3);     // Catch: Throwable -> L12
            UserState userState = TvInputManagerService.m8775$$Nest$mgetOrCreateUserStateLocked(this.this$0, resolvedUserId);     // Catch: Throwable -> L9
            UserState.m8868$$Nest$fgetpersistentDataStore(userState).addBlockedRating(TvContentRating.unflattenFromString(rating));     // Catch: Throwable -> L9
            monitor-exit(r3);     // Catch: Throwable -> L9
            Binder.restoreCallingIdentity(identity);
            return;
        L9:
            th = move-exception;
            throw th;     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void removeBlockedRating(String rating, int userId) {
            ensureParentalControlsPermission();
            int resolvedUserId = TvInputManagerService.m8791$$Nest$mresolveCallingUserId(this.this$0, Binder.getCallingPid(), Binder.getCallingUid(), userId, "removeBlockedRating");
            long identity = Binder.clearCallingIdentity();
            Object r3 = TvInputManagerService.m8756$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L12
            monitor-enter(r3);     // Catch: Throwable -> L12
            UserState userState = TvInputManagerService.m8775$$Nest$mgetOrCreateUserStateLocked(this.this$0, resolvedUserId);     // Catch: Throwable -> L9
            UserState.m8868$$Nest$fgetpersistentDataStore(userState).removeBlockedRating(TvContentRating.unflattenFromString(rating));     // Catch: Throwable -> L9
            monitor-exit(r3);     // Catch: Throwable -> L9
            Binder.restoreCallingIdentity(identity);
            return;
        L9:
            th = move-exception;
            throw th;     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        private void ensureParentalControlsPermission() {
            if (TvInputManagerService.m8754$$Nest$fgetmContext(this.this$0).checkCallingPermission("android.permission.MODIFY_PARENTAL_CONTROLS") != 0) goto L6;
            return;
        L6:
            throw new SecurityException("The caller does not have parental controls permission");
        }

        public void createSession(ITvInputClient client, String inputId, AttributionSource tvAppAttributionSource, boolean isRecordingSession, int seq, int userId) {
            int callingUid = Binder.getCallingUid();
            int callingPid = Binder.getCallingPid();
            int resolvedUserId = TvInputManagerService.m8791$$Nest$mresolveCallingUserId(this.this$0, callingPid, callingUid, userId, "createSession");
            long identity = Binder.clearCallingIdentity();
            String uniqueSessionId = UUID.randomUUID().toString();
            Object r25 = TvInputManagerService.m8756$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L71
            monitor-enter(r25);     // Catch: Throwable -> L71
        L65:
            th = th;
        L67:
            monitor-exit(r25);     // Catch: Throwable -> L52
            throw th;     // Catch: Throwable -> L69
        L69:
            th = th;
        L73:
            Binder.restoreCallingIdentity(identity);
            throw th;
        L78:
            if (userId == TvInputManagerService.m8755$$Nest$fgetmCurrentUserId(this.this$0)) goto L21;
        L18:
            th = th;
            goto L67
        L8:
            if (TvInputManagerService.m8760$$Nest$fgetmRunningProfiles(this.this$0).contains(Integer.valueOf(userId)) == true) goto L21;
            if (isRecordingSession == true) goto L21;
            TvInputManagerService.m8792$$Nest$msendSessionTokenToClientLocked(this.this$0, client, inputId, null, null, seq);     // Catch: Throwable -> L16
            monitor-exit(r25);     // Catch: Throwable -> L16
            Binder.restoreCallingIdentity(identity);
            return;
        L21:
            UserState userState = TvInputManagerService.m8775$$Nest$mgetOrCreateUserStateLocked(this.this$0, resolvedUserId);     // Catch: Throwable -> L65
            TvInputState inputState = (TvInputState) UserState.m8862$$Nest$fgetinputMap(userState).get(inputId);     // Catch: Throwable -> L65
            if (inputState != null) goto L28;
            Slog.w(TvInputManagerService.TAG, "Failed to find input state for inputId=" + inputId);     // Catch: Throwable -> L16
            TvInputManagerService.m8792$$Nest$msendSessionTokenToClientLocked(this.this$0, client, inputId, null, null, seq);     // Catch: Throwable -> L16
            monitor-exit(r25);     // Catch: Throwable -> L16
            Binder.restoreCallingIdentity(identity);
            return;
        L28:
            TvInputInfo info = TvInputState.m8851$$Nest$fgetinfo(inputState);     // Catch: Throwable -> L65
            ServiceState serviceState = (ServiceState) UserState.m8869$$Nest$fgetserviceStateMap(userState).get(info.getComponent());     // Catch: Throwable -> L65
            if (serviceState != null) goto L32;
            int r3 = PackageManager.getApplicationInfoAsUserCached(info.getComponent().getPackageName(), 0, resolvedUserId).uid;     // Catch: Throwable -> L16
            ServiceState serviceState2 = new ServiceState(this.this$0, info.getComponent(), resolvedUserId, null);     // Catch: Throwable -> L16
            UserState.m8869$$Nest$fgetserviceStateMap(userState).put(info.getComponent(), serviceState2);     // Catch: Throwable -> L16
            ServiceState serviceState3 = serviceState2;
        L34:
            if (ServiceState.m8820$$Nest$fgetreconnecting(serviceState3) == false) goto L39;
            TvInputManagerService.m8792$$Nest$msendSessionTokenToClientLocked(this.this$0, client, inputId, null, null, seq);     // Catch: Throwable -> L16
            monitor-exit(r25);     // Catch: Throwable -> L16
            Binder.restoreCallingIdentity(identity);
            return;
        L39:
            Binder r2 = new Binder();     // Catch: Throwable -> L65
            SessionState sessionState = new SessionState(this.this$0, r2, info.getId(), info.getComponent(), isRecordingSession, client, seq, callingUid, callingPid, resolvedUserId, uniqueSessionId, tvAppAttributionSource, null);     // Catch: Throwable -> L59
            UserState.m8870$$Nest$fgetsessionStateMap(userState).put(r2, sessionState);     // Catch: Throwable -> L52
            TvInputManagerService.m8761$$Nest$fgetmSessionIdToSessionStateMap(this.this$0).put(uniqueSessionId, sessionState);     // Catch: Throwable -> L52
            ServiceState.m8822$$Nest$fgetsessionTokens(serviceState3).add(r2);     // Catch: Throwable -> L52
            if (ServiceState.m8821$$Nest$fgetservice(serviceState3) != null) goto L50;
            TvInputManagerService.m8800$$Nest$mupdateServiceConnectionLocked(this.this$0, info.getComponent(), resolvedUserId);     // Catch: Throwable -> L52
        L55:
            TvInputManagerService.m8784$$Nest$mlogTuneStateChanged(this.this$0, 1, sessionState, inputState);     // Catch: Throwable -> L52
            monitor-exit(r25);     // Catch: Throwable -> L52
            Binder.restoreCallingIdentity(identity);
            return;
        L50:
            if (TvInputManagerService.m8773$$Nest$mcreateSessionInternalLocked(this.this$0, ServiceState.m8821$$Nest$fgetservice(serviceState3), r2, resolvedUserId) == true) goto L55;
            TvInputManagerService.m8789$$Nest$mremoveSessionStateLocked(this.this$0, r2, resolvedUserId);     // Catch: Throwable -> L52
        L59:
            th = th;
        L61:
            th = th;
        L63:
            th = th;
            goto L67
        L32:
            serviceState3 = serviceState;
        L16:
            th = th;
        L52:
            th = th;
        L71:
            th = th;
            goto L73
        }

        public void releaseSession(IBinder sessionToken, int userId) {
            int callingUid = Binder.getCallingUid();
            int resolvedUserId = TvInputManagerService.m8791$$Nest$mresolveCallingUserId(this.this$0, Binder.getCallingPid(), callingUid, userId, "releaseSession");
            long identity = Binder.clearCallingIdentity();
            Object r6 = TvInputManagerService.m8756$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L10
            monitor-enter(r6);     // Catch: Throwable -> L10
            SessionState sessionState = TvInputManagerService.m8787$$Nest$mreleaseSessionLocked(this.this$0, sessionToken, callingUid, resolvedUserId);     // Catch: Throwable -> L14
            UserState userState = TvInputManagerService.m8782$$Nest$mgetUserStateLocked(this.this$0, userId);     // Catch: Throwable -> L14
            monitor-exit(r6);     // Catch: Throwable -> L14
            if (sessionState == null) goto L12;
            TvInputState tvInputState = TvInputManagerService.m8805$$Nest$smgetTvInputState(sessionState, userState);     // Catch: Throwable -> L10
            TvInputManagerService.m8784$$Nest$mlogTuneStateChanged(this.this$0, 4, sessionState, tvInputState);     // Catch: Throwable -> L10
        L12:
            Binder.restoreCallingIdentity(identity);
            return;
        L14:
            th = move-exception;
            throw th;     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void setMainSession(IBinder sessionToken, int userId) {
            if (TvInputManagerService.m8754$$Nest$fgetmContext(this.this$0).checkCallingPermission("android.permission.CHANGE_HDMI_CEC_ACTIVE_SOURCE") != 0) goto L28;
            int callingUid = Binder.getCallingUid();
            int resolvedUserId = TvInputManagerService.m8791$$Nest$mresolveCallingUserId(this.this$0, Binder.getCallingPid(), callingUid, userId, "setMainSession");
            long identity = Binder.clearCallingIdentity();
            Object r4 = TvInputManagerService.m8756$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L24
            monitor-enter(r4);     // Catch: Throwable -> L24
            UserState userState = TvInputManagerService.m8775$$Nest$mgetOrCreateUserStateLocked(this.this$0, resolvedUserId);     // Catch: Throwable -> L12
            if (UserState.m8866$$Nest$fgetmainSessionToken(userState) != sessionToken) goto L14;
            monitor-exit(r4);     // Catch: Throwable -> L12
            Binder.restoreCallingIdentity(identity);
            return;
        L14:
            IBinder oldMainSessionToken = UserState.m8866$$Nest$fgetmainSessionToken(userState);     // Catch: Throwable -> L12
            UserState.m8873$$Nest$fputmainSessionToken(userState, sessionToken);     // Catch: Throwable -> L12
            if (sessionToken == null) goto L17;
            TvInputManagerService.m8793$$Nest$msetMainLocked(this.this$0, sessionToken, true, callingUid, userId);     // Catch: Throwable -> L12
        L17:
            if (oldMainSessionToken == null) goto L19;
            TvInputManagerService.m8793$$Nest$msetMainLocked(this.this$0, oldMainSessionToken, false, 1000, userId);     // Catch: Throwable -> L12
        L19:
            monitor-exit(r4);     // Catch: Throwable -> L12
            Binder.restoreCallingIdentity(identity);
            return;
        L12:
            th = move-exception;
            throw th;     // Catch: Throwable -> L24
        L24:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        L28:
            throw new SecurityException("The caller does not have CHANGE_HDMI_CEC_ACTIVE_SOURCE permission");
        }

        public void setSurface(IBinder sessionToken, Surface surface, int userId) {
            int callingUid = Binder.getCallingUid();
            int resolvedUserId = TvInputManagerService.m8791$$Nest$mresolveCallingUserId(this.this$0, Binder.getCallingPid(), callingUid, userId, "setSurface");
            long identity = Binder.clearCallingIdentity();
            SessionState sessionState = null;
            UserState userState = null;
            int state = 2;
            Object r8 = TvInputManagerService.m8756$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L34
            monitor-enter(r8);     // Catch: Throwable -> L34
            userState = TvInputManagerService.m8782$$Nest$mgetUserStateLocked(this.this$0, userId);     // Catch: Throwable -> L8 Throwable -> L10
            sessionState = TvInputManagerService.m8780$$Nest$mgetSessionStateLocked(this.this$0, sessionToken, callingUid, resolvedUserId);     // Catch: Throwable -> L8 Throwable -> L10
            if (SessionState.m8833$$Nest$fgethardwareSessionToken(sessionState) != null) goto L12;
            TvInputManagerService.m8779$$Nest$mgetSessionLocked(this.this$0, sessionState).setSurface(surface);     // Catch: Throwable -> L8 Throwable -> L10
        L13:
            if (surface != null) goto L15;
            boolean isVisible = true;
        L17:
            if (SessionState.m8838$$Nest$fgetisVisible(sessionState) == isVisible) goto L22;
            SessionState.m8849$$Nest$fputisVisible(sessionState, isVisible);     // Catch: Throwable -> L8 Throwable -> L10
            TvInputManagerService.m8785$$Nest$mnotifyCurrentChannelInfosUpdatedLocked(this.this$0, userState);     // Catch: Throwable -> L8 Throwable -> L10
        L22:
            monitor-exit(r8);     // Catch: Throwable -> L8
            if (surface == null) goto L25;
            surface.release();
        L25:
            if (sessionState == null) goto L30;
            if (surface != null) goto L29;
            state = 3;
        L29:
            TvInputManagerService.m8784$$Nest$mlogTuneStateChanged(this.this$0, state, sessionState, TvInputManagerService.m8805$$Nest$smgetTvInputState(sessionState, userState));
        L30:
            Binder.restoreCallingIdentity(identity);
            return;
        L15:
            isVisible = false;
            goto L17
        L12:
            TvInputManagerService.m8778$$Nest$mgetSessionLocked(this.this$0, SessionState.m8833$$Nest$fgethardwareSessionToken(sessionState), 1000, resolvedUserId).setSurface(surface);     // Catch: Throwable -> L8 Throwable -> L10
        L10:
            e = move-exception;
            Slog.e(TvInputManagerService.TAG, "error in setSurface", e);     // Catch: Throwable -> L8
        L8:
            th = move-exception;
            throw th;     // Catch: Throwable -> L34
        L34:
            th = move-exception;
            if (surface == null) goto L37;
            surface.release();
        L37:
            if (sessionState == null) goto L42;
            if (surface != null) goto L41;
            state = 3;
        L41:
            TvInputManagerService.m8784$$Nest$mlogTuneStateChanged(this.this$0, state, sessionState, TvInputManagerService.m8805$$Nest$smgetTvInputState(sessionState, userState));
        L42:
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void dispatchSurfaceChanged(IBinder sessionToken, int format, int width, int height, int userId) {
            int callingUid = Binder.getCallingUid();
            int resolvedUserId = TvInputManagerService.m8791$$Nest$mresolveCallingUserId(this.this$0, Binder.getCallingPid(), callingUid, userId, "dispatchSurfaceChanged");
            long identity = Binder.clearCallingIdentity();
            Object r4 = TvInputManagerService.m8756$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L21
            monitor-enter(r4);     // Catch: Throwable -> L21
            SessionState sessionState = TvInputManagerService.m8780$$Nest$mgetSessionStateLocked(this.this$0, sessionToken, callingUid, resolvedUserId);     // Catch: Throwable -> L9 Throwable -> L11
            TvInputManagerService.m8779$$Nest$mgetSessionLocked(this.this$0, sessionState).dispatchSurfaceChanged(format, width, height);     // Catch: Throwable -> L9 Throwable -> L11
            if (SessionState.m8833$$Nest$fgethardwareSessionToken(sessionState) == null) goto L16;
            TvInputManagerService.m8778$$Nest$mgetSessionLocked(this.this$0, SessionState.m8833$$Nest$fgethardwareSessionToken(sessionState), 1000, resolvedUserId).dispatchSurfaceChanged(format, width, height);     // Catch: Throwable -> L9 Throwable -> L11
        L16:
            monitor-exit(r4);     // Catch: Throwable -> L9
            Binder.restoreCallingIdentity(identity);
            return;
        L9:
            th = move-exception;
            throw th;     // Catch: Throwable -> L21
        L11:
            e = move-exception;
            Slog.e(TvInputManagerService.TAG, "error in dispatchSurfaceChanged", e);     // Catch: Throwable -> L9
        L21:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void setVolume(IBinder sessionToken, float volume, int userId) {
            int callingUid = Binder.getCallingUid();
            int resolvedUserId = TvInputManagerService.m8791$$Nest$mresolveCallingUserId(this.this$0, Binder.getCallingPid(), callingUid, userId, "setVolume");
            long identity = Binder.clearCallingIdentity();
            Object r6 = TvInputManagerService.m8756$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L25
            monitor-enter(r6);     // Catch: Throwable -> L25
            SessionState sessionState = TvInputManagerService.m8780$$Nest$mgetSessionStateLocked(this.this$0, sessionToken, callingUid, resolvedUserId);     // Catch: Throwable -> L13 Throwable -> L15
            TvInputManagerService.m8779$$Nest$mgetSessionLocked(this.this$0, sessionState).setVolume(volume);     // Catch: Throwable -> L13 Throwable -> L15
            if (SessionState.m8833$$Nest$fgethardwareSessionToken(sessionState) == null) goto L20;
            ITvInputSession r8 = TvInputManagerService.m8778$$Nest$mgetSessionLocked(this.this$0, SessionState.m8833$$Nest$fgethardwareSessionToken(sessionState), 1000, resolvedUserId);     // Catch: Throwable -> L13 Throwable -> L15
            float r9 = 0.0f;
            if (volume <= 0.0f) goto L11;
            r9 = 1.0f;
        L11:
            r8.setVolume(r9);     // Catch: Throwable -> L13 Throwable -> L15
        L20:
            monitor-exit(r6);     // Catch: Throwable -> L13
            Binder.restoreCallingIdentity(identity);
            return;
        L15:
            e = move-exception;
            Slog.e(TvInputManagerService.TAG, "error in setVolume", e);     // Catch: Throwable -> L13
        L13:
            th = move-exception;
            throw th;     // Catch: Throwable -> L25
        L25:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void tune(IBinder sessionToken, Uri channelUri, Bundle params, int userId) {
            int callingUid = Binder.getCallingUid();
            int callingPid = Binder.getCallingPid();
            int resolvedUserId = TvInputManagerService.m8791$$Nest$mresolveCallingUserId(this.this$0, callingPid, callingUid, userId, "tune");
            long identity = Binder.clearCallingIdentity();
            Object r11 = TvInputManagerService.m8756$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L39
            monitor-enter(r11);     // Catch: Throwable -> L39
            TvInputManagerService.m8778$$Nest$mgetSessionLocked(this.this$0, sessionToken, callingUid, resolvedUserId).tune(channelUri, params);     // Catch: Throwable -> L10 Throwable -> L12
            UserState userState = TvInputManagerService.m8775$$Nest$mgetOrCreateUserStateLocked(this.this$0, resolvedUserId);     // Catch: Throwable -> L10 Throwable -> L12
            SessionState sessionState = TvInputManagerService.m8781$$Nest$mgetSessionStateLocked(this.this$0, sessionToken, callingUid, userState);     // Catch: Throwable -> L10 Throwable -> L12
            if (SessionState.m8835$$Nest$fgetisCurrent(sessionState) == true) goto L8;
        L14:
            SessionState.m8847$$Nest$fputisCurrent(sessionState, true);     // Catch: Throwable -> L10 Throwable -> L12
            SessionState.m8845$$Nest$fputcurrentChannel(sessionState, channelUri);     // Catch: Throwable -> L10 Throwable -> L12
            TvInputManagerService.m8785$$Nest$mnotifyCurrentChannelInfosUpdatedLocked(this.this$0, userState);     // Catch: Throwable -> L10 Throwable -> L12
            if (SessionState.m8837$$Nest$fgetisRecordingSession(sessionState) == true) goto L21;
            String sessionActualInputId = TvInputManagerService.m8777$$Nest$mgetSessionActualInputId(this.this$0, sessionState);     // Catch: Throwable -> L10 Throwable -> L12
            if (TextUtils.equals(TvInputManagerService.m8758$$Nest$fgetmOnScreenInputId(this.this$0), sessionActualInputId) == true) goto L19;
            TvInputManagerService.m8783$$Nest$mlogExternalInputEvent(this.this$0, 1, sessionActualInputId, sessionState);     // Catch: Throwable -> L10 Throwable -> L12
        L19:
            TvInputManagerService.m8764$$Nest$fputmOnScreenInputId(this.this$0, sessionActualInputId);     // Catch: Throwable -> L10 Throwable -> L12
            TvInputManagerService.m8765$$Nest$fputmOnScreenSessionState(this.this$0, sessionState);     // Catch: Throwable -> L10 Throwable -> L12
        L21:
            if (TvContract.isChannelUriForPassthroughInput(channelUri) == false) goto L26;
            monitor-exit(r11);     // Catch: Throwable -> L10
            Binder.restoreCallingIdentity(identity);
            return;
        L26:
            if (SessionState.m8837$$Nest$fgetisRecordingSession(sessionState) == false) goto L30;
            monitor-exit(r11);     // Catch: Throwable -> L10
            Binder.restoreCallingIdentity(identity);
            return;
        L30:
            TvInputManagerService.m8784$$Nest$mlogTuneStateChanged(this.this$0, 5, sessionState, TvInputManagerService.m8805$$Nest$smgetTvInputState(sessionState, userState));     // Catch: Throwable -> L10 Throwable -> L12 Throwable -> L12
            SomeArgs args = SomeArgs.obtain();     // Catch: Throwable -> L10 Throwable -> L12 Throwable -> L12
            args.arg1 = SessionState.m8831$$Nest$fgetcomponentName(sessionState).getPackageName();     // Catch: Throwable -> L10 Throwable -> L12 Throwable -> L12
            args.arg2 = Long.valueOf(System.currentTimeMillis());     // Catch: Throwable -> L10 Throwable -> L12 Throwable -> L12
            args.arg3 = Long.valueOf(ContentUris.parseId(channelUri));     // Catch: Throwable -> L10 Throwable -> L12 Throwable -> L12
            args.arg4 = params;     // Catch: Throwable -> L10 Throwable -> L12 Throwable -> L12
            args.arg5 = sessionToken;     // Catch: Throwable -> L10 Throwable -> L12 Throwable -> L12
            TvInputManagerService.m8757$$Nest$fgetmMessageHandler(this.this$0).obtainMessage(1, args).sendToTarget();     // Catch: Throwable -> L10 Throwable -> L12 Throwable -> L12
        L34:
            monitor-exit(r11);     // Catch: Throwable -> L10
            Binder.restoreCallingIdentity(identity);
            return;
        L8:
            if (Objects.equals(SessionState.m8832$$Nest$fgetcurrentChannel(sessionState), channelUri) == true) goto L21;
        L12:
            e = move-exception;
            Slog.e(TvInputManagerService.TAG, "error in tune", e);     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            throw th;     // Catch: Throwable -> L39
        L39:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void unblockContent(IBinder sessionToken, String unblockedRating, int userId) {
            ensureParentalControlsPermission();
            int callingUid = Binder.getCallingUid();
            int resolvedUserId = TvInputManagerService.m8791$$Nest$mresolveCallingUserId(this.this$0, Binder.getCallingPid(), callingUid, userId, "unblockContent");
            long identity = Binder.clearCallingIdentity();
            Object r4 = TvInputManagerService.m8756$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L16
            monitor-enter(r4);     // Catch: Throwable -> L16
            TvInputManagerService.m8778$$Nest$mgetSessionLocked(this.this$0, sessionToken, callingUid, resolvedUserId).unblockContent(unblockedRating);     // Catch: Throwable -> L7 Throwable -> L9
        L11:
            monitor-exit(r4);     // Catch: Throwable -> L7
            Binder.restoreCallingIdentity(identity);
            return;
        L7:
            th = move-exception;
            throw th;     // Catch: Throwable -> L16
        L9:
            e = move-exception;
            Slog.e(TvInputManagerService.TAG, "error in unblockContent", e);     // Catch: Throwable -> L7
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void setCaptionEnabled(IBinder sessionToken, boolean enabled, int userId) {
            int callingUid = Binder.getCallingUid();
            int resolvedUserId = TvInputManagerService.m8791$$Nest$mresolveCallingUserId(this.this$0, Binder.getCallingPid(), callingUid, userId, "setCaptionEnabled");
            long identity = Binder.clearCallingIdentity();
            Object r4 = TvInputManagerService.m8756$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L16
            monitor-enter(r4);     // Catch: Throwable -> L16
            TvInputManagerService.m8778$$Nest$mgetSessionLocked(this.this$0, sessionToken, callingUid, resolvedUserId).setCaptionEnabled(enabled);     // Catch: Throwable -> L7 Throwable -> L9
        L11:
            monitor-exit(r4);     // Catch: Throwable -> L7
            Binder.restoreCallingIdentity(identity);
            return;
        L7:
            th = move-exception;
            throw th;     // Catch: Throwable -> L16
        L9:
            e = move-exception;
            Slog.e(TvInputManagerService.TAG, "error in setCaptionEnabled", e);     // Catch: Throwable -> L7
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void selectAudioPresentation(IBinder sessionToken, int presentationId, int programId, int userId) {
            int callingUid = Binder.getCallingUid();
            int resolvedUserId = TvInputManagerService.m8791$$Nest$mresolveCallingUserId(this.this$0, Binder.getCallingPid(), callingUid, userId, "selectAudioPresentation");
            long identity = Binder.clearCallingIdentity();
            Object r4 = TvInputManagerService.m8756$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L16
            monitor-enter(r4);     // Catch: Throwable -> L16
            TvInputManagerService.m8778$$Nest$mgetSessionLocked(this.this$0, sessionToken, callingUid, resolvedUserId).selectAudioPresentation(presentationId, programId);     // Catch: Throwable -> L7 Throwable -> L9
        L11:
            monitor-exit(r4);     // Catch: Throwable -> L7
            Binder.restoreCallingIdentity(identity);
            return;
        L7:
            th = move-exception;
            throw th;     // Catch: Throwable -> L16
        L9:
            e = move-exception;
            Slog.e(TvInputManagerService.TAG, "error in selectAudioPresentation", e);     // Catch: Throwable -> L7
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void selectTrack(IBinder sessionToken, int type, String trackId, int userId) {
            int callingUid = Binder.getCallingUid();
            int resolvedUserId = TvInputManagerService.m8791$$Nest$mresolveCallingUserId(this.this$0, Binder.getCallingPid(), callingUid, userId, "selectTrack");
            long identity = Binder.clearCallingIdentity();
            Object r4 = TvInputManagerService.m8756$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L16
            monitor-enter(r4);     // Catch: Throwable -> L16
            TvInputManagerService.m8778$$Nest$mgetSessionLocked(this.this$0, sessionToken, callingUid, resolvedUserId).selectTrack(type, trackId);     // Catch: Throwable -> L7 Throwable -> L9
        L11:
            monitor-exit(r4);     // Catch: Throwable -> L7
            Binder.restoreCallingIdentity(identity);
            return;
        L7:
            th = move-exception;
            throw th;     // Catch: Throwable -> L16
        L9:
            e = move-exception;
            Slog.e(TvInputManagerService.TAG, "error in selectTrack", e);     // Catch: Throwable -> L7
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void setInteractiveAppNotificationEnabled(IBinder sessionToken, boolean enabled, int userId) {
            int callingUid = Binder.getCallingUid();
            int resolvedUserId = TvInputManagerService.m8791$$Nest$mresolveCallingUserId(this.this$0, Binder.getCallingPid(), callingUid, userId, "setInteractiveAppNotificationEnabled");
            long identity = Binder.clearCallingIdentity();
            Object r4 = TvInputManagerService.m8756$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L16
            monitor-enter(r4);     // Catch: Throwable -> L16
            TvInputManagerService.m8778$$Nest$mgetSessionLocked(this.this$0, sessionToken, callingUid, resolvedUserId).setInteractiveAppNotificationEnabled(enabled);     // Catch: Throwable -> L7 Throwable -> L9
        L11:
            monitor-exit(r4);     // Catch: Throwable -> L7
            Binder.restoreCallingIdentity(identity);
            return;
        L7:
            th = move-exception;
            throw th;     // Catch: Throwable -> L16
        L9:
            e = move-exception;
            Slog.e(TvInputManagerService.TAG, "error in setInteractiveAppNotificationEnabled", e);     // Catch: Throwable -> L7
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void sendAppPrivateCommand(IBinder sessionToken, String command, Bundle data, int userId) {
            int callingUid = Binder.getCallingUid();
            int resolvedUserId = TvInputManagerService.m8791$$Nest$mresolveCallingUserId(this.this$0, Binder.getCallingPid(), callingUid, userId, "sendAppPrivateCommand");
            long identity = Binder.clearCallingIdentity();
            Object r4 = TvInputManagerService.m8756$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L16
            monitor-enter(r4);     // Catch: Throwable -> L16
            TvInputManagerService.m8778$$Nest$mgetSessionLocked(this.this$0, sessionToken, callingUid, resolvedUserId).appPrivateCommand(command, data);     // Catch: Throwable -> L7 Throwable -> L9
        L11:
            monitor-exit(r4);     // Catch: Throwable -> L7
            Binder.restoreCallingIdentity(identity);
            return;
        L7:
            th = move-exception;
            throw th;     // Catch: Throwable -> L16
        L9:
            e = move-exception;
            Slog.e(TvInputManagerService.TAG, "error in appPrivateCommand", e);     // Catch: Throwable -> L7
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void createOverlayView(IBinder sessionToken, IBinder windowToken, Rect frame, int userId) {
            int callingUid = Binder.getCallingUid();
            int resolvedUserId = TvInputManagerService.m8791$$Nest$mresolveCallingUserId(this.this$0, Binder.getCallingPid(), callingUid, userId, "createOverlayView");
            long identity = Binder.clearCallingIdentity();
            Object r4 = TvInputManagerService.m8756$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L16
            monitor-enter(r4);     // Catch: Throwable -> L16
            TvInputManagerService.m8778$$Nest$mgetSessionLocked(this.this$0, sessionToken, callingUid, resolvedUserId).createOverlayView(windowToken, frame);     // Catch: Throwable -> L7 Throwable -> L9
        L11:
            monitor-exit(r4);     // Catch: Throwable -> L7
            Binder.restoreCallingIdentity(identity);
            return;
        L7:
            th = move-exception;
            throw th;     // Catch: Throwable -> L16
        L9:
            e = move-exception;
            Slog.e(TvInputManagerService.TAG, "error in createOverlayView", e);     // Catch: Throwable -> L7
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void relayoutOverlayView(IBinder sessionToken, Rect frame, int userId) {
            int callingUid = Binder.getCallingUid();
            int resolvedUserId = TvInputManagerService.m8791$$Nest$mresolveCallingUserId(this.this$0, Binder.getCallingPid(), callingUid, userId, "relayoutOverlayView");
            long identity = Binder.clearCallingIdentity();
            Object r4 = TvInputManagerService.m8756$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L16
            monitor-enter(r4);     // Catch: Throwable -> L16
            TvInputManagerService.m8778$$Nest$mgetSessionLocked(this.this$0, sessionToken, callingUid, resolvedUserId).relayoutOverlayView(frame);     // Catch: Throwable -> L7 Throwable -> L9
        L11:
            monitor-exit(r4);     // Catch: Throwable -> L7
            Binder.restoreCallingIdentity(identity);
            return;
        L7:
            th = move-exception;
            throw th;     // Catch: Throwable -> L16
        L9:
            e = move-exception;
            Slog.e(TvInputManagerService.TAG, "error in relayoutOverlayView", e);     // Catch: Throwable -> L7
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void removeOverlayView(IBinder sessionToken, int userId) {
            int callingUid = Binder.getCallingUid();
            int resolvedUserId = TvInputManagerService.m8791$$Nest$mresolveCallingUserId(this.this$0, Binder.getCallingPid(), callingUid, userId, "removeOverlayView");
            long identity = Binder.clearCallingIdentity();
            Object r4 = TvInputManagerService.m8756$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L16
            monitor-enter(r4);     // Catch: Throwable -> L16
            TvInputManagerService.m8778$$Nest$mgetSessionLocked(this.this$0, sessionToken, callingUid, resolvedUserId).removeOverlayView();     // Catch: Throwable -> L7 Throwable -> L9
        L11:
            monitor-exit(r4);     // Catch: Throwable -> L7
            Binder.restoreCallingIdentity(identity);
            return;
        L7:
            th = move-exception;
            throw th;     // Catch: Throwable -> L16
        L9:
            e = move-exception;
            Slog.e(TvInputManagerService.TAG, "error in removeOverlayView", e);     // Catch: Throwable -> L7
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void stopPlayback(IBinder sessionToken, int mode, int userId) {
            int callingUid = Binder.getCallingUid();
            int resolvedUserId = TvInputManagerService.m8791$$Nest$mresolveCallingUserId(this.this$0, Binder.getCallingPid(), callingUid, userId, "stopPlayback");
            long identity = Binder.clearCallingIdentity();
            Object r4 = TvInputManagerService.m8756$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L16
            monitor-enter(r4);     // Catch: Throwable -> L16
            TvInputManagerService.m8778$$Nest$mgetSessionLocked(this.this$0, sessionToken, callingUid, resolvedUserId).stopPlayback(mode);     // Catch: Throwable -> L7 Throwable -> L9
        L11:
            monitor-exit(r4);     // Catch: Throwable -> L7
            Binder.restoreCallingIdentity(identity);
            return;
        L7:
            th = move-exception;
            throw th;     // Catch: Throwable -> L16
        L9:
            e = move-exception;
            Slog.e(TvInputManagerService.TAG, "error in stopPlayback(mode)", e);     // Catch: Throwable -> L7
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void resumePlayback(IBinder sessionToken, int userId) {
            int callingUid = Binder.getCallingUid();
            int resolvedUserId = TvInputManagerService.m8791$$Nest$mresolveCallingUserId(this.this$0, Binder.getCallingPid(), callingUid, userId, "resumePlayback");
            long identity = Binder.clearCallingIdentity();
            Object r4 = TvInputManagerService.m8756$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L16
            monitor-enter(r4);     // Catch: Throwable -> L16
            TvInputManagerService.m8778$$Nest$mgetSessionLocked(this.this$0, sessionToken, callingUid, resolvedUserId).resumePlayback();     // Catch: Throwable -> L7 Throwable -> L9
        L11:
            monitor-exit(r4);     // Catch: Throwable -> L7
            Binder.restoreCallingIdentity(identity);
            return;
        L7:
            th = move-exception;
            throw th;     // Catch: Throwable -> L16
        L9:
            e = move-exception;
            Slog.e(TvInputManagerService.TAG, "error in resumePlayback()", e);     // Catch: Throwable -> L7
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void timeShiftPlay(IBinder sessionToken, Uri recordedProgramUri, int userId) {
            int callingUid = Binder.getCallingUid();
            int resolvedUserId = TvInputManagerService.m8791$$Nest$mresolveCallingUserId(this.this$0, Binder.getCallingPid(), callingUid, userId, "timeShiftPlay");
            long identity = Binder.clearCallingIdentity();
            Object r4 = TvInputManagerService.m8756$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L16
            monitor-enter(r4);     // Catch: Throwable -> L16
            TvInputManagerService.m8778$$Nest$mgetSessionLocked(this.this$0, sessionToken, callingUid, resolvedUserId).timeShiftPlay(recordedProgramUri);     // Catch: Throwable -> L7 Throwable -> L9
        L11:
            monitor-exit(r4);     // Catch: Throwable -> L7
            Binder.restoreCallingIdentity(identity);
            return;
        L7:
            th = move-exception;
            throw th;     // Catch: Throwable -> L16
        L9:
            e = move-exception;
            Slog.e(TvInputManagerService.TAG, "error in timeShiftPlay", e);     // Catch: Throwable -> L7
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void timeShiftPause(IBinder sessionToken, int userId) {
            int callingUid = Binder.getCallingUid();
            int resolvedUserId = TvInputManagerService.m8791$$Nest$mresolveCallingUserId(this.this$0, Binder.getCallingPid(), callingUid, userId, "timeShiftPause");
            long identity = Binder.clearCallingIdentity();
            Object r4 = TvInputManagerService.m8756$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L16
            monitor-enter(r4);     // Catch: Throwable -> L16
            TvInputManagerService.m8778$$Nest$mgetSessionLocked(this.this$0, sessionToken, callingUid, resolvedUserId).timeShiftPause();     // Catch: Throwable -> L7 Throwable -> L9
        L11:
            monitor-exit(r4);     // Catch: Throwable -> L7
            Binder.restoreCallingIdentity(identity);
            return;
        L7:
            th = move-exception;
            throw th;     // Catch: Throwable -> L16
        L9:
            e = move-exception;
            Slog.e(TvInputManagerService.TAG, "error in timeShiftPause", e);     // Catch: Throwable -> L7
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void timeShiftResume(IBinder sessionToken, int userId) {
            int callingUid = Binder.getCallingUid();
            int resolvedUserId = TvInputManagerService.m8791$$Nest$mresolveCallingUserId(this.this$0, Binder.getCallingPid(), callingUid, userId, "timeShiftResume");
            long identity = Binder.clearCallingIdentity();
            Object r4 = TvInputManagerService.m8756$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L16
            monitor-enter(r4);     // Catch: Throwable -> L16
            TvInputManagerService.m8778$$Nest$mgetSessionLocked(this.this$0, sessionToken, callingUid, resolvedUserId).timeShiftResume();     // Catch: Throwable -> L7 Throwable -> L9
        L11:
            monitor-exit(r4);     // Catch: Throwable -> L7
            Binder.restoreCallingIdentity(identity);
            return;
        L7:
            th = move-exception;
            throw th;     // Catch: Throwable -> L16
        L9:
            e = move-exception;
            Slog.e(TvInputManagerService.TAG, "error in timeShiftResume", e);     // Catch: Throwable -> L7
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void timeShiftSeekTo(IBinder sessionToken, long timeMs, int userId) {
            int callingUid = Binder.getCallingUid();
            int resolvedUserId = TvInputManagerService.m8791$$Nest$mresolveCallingUserId(this.this$0, Binder.getCallingPid(), callingUid, userId, "timeShiftSeekTo");
            long identity = Binder.clearCallingIdentity();
            Object r4 = TvInputManagerService.m8756$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L16
            monitor-enter(r4);     // Catch: Throwable -> L16
            TvInputManagerService.m8778$$Nest$mgetSessionLocked(this.this$0, sessionToken, callingUid, resolvedUserId).timeShiftSeekTo(timeMs);     // Catch: Throwable -> L7 Throwable -> L9
        L11:
            monitor-exit(r4);     // Catch: Throwable -> L7
            Binder.restoreCallingIdentity(identity);
            return;
        L7:
            th = move-exception;
            throw th;     // Catch: Throwable -> L16
        L9:
            e = move-exception;
            Slog.e(TvInputManagerService.TAG, "error in timeShiftSeekTo", e);     // Catch: Throwable -> L7
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void timeShiftSetPlaybackParams(IBinder sessionToken, PlaybackParams params, int userId) {
            int callingUid = Binder.getCallingUid();
            int resolvedUserId = TvInputManagerService.m8791$$Nest$mresolveCallingUserId(this.this$0, Binder.getCallingPid(), callingUid, userId, "timeShiftSetPlaybackParams");
            long identity = Binder.clearCallingIdentity();
            Object r4 = TvInputManagerService.m8756$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L16
            monitor-enter(r4);     // Catch: Throwable -> L16
            TvInputManagerService.m8778$$Nest$mgetSessionLocked(this.this$0, sessionToken, callingUid, resolvedUserId).timeShiftSetPlaybackParams(params);     // Catch: Throwable -> L7 Throwable -> L9
        L11:
            monitor-exit(r4);     // Catch: Throwable -> L7
            Binder.restoreCallingIdentity(identity);
            return;
        L7:
            th = move-exception;
            throw th;     // Catch: Throwable -> L16
        L9:
            e = move-exception;
            Slog.e(TvInputManagerService.TAG, "error in timeShiftSetPlaybackParams", e);     // Catch: Throwable -> L7
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void timeShiftSetMode(IBinder sessionToken, int mode, int userId) {
            int callingUid = Binder.getCallingUid();
            int resolvedUserId = TvInputManagerService.m8791$$Nest$mresolveCallingUserId(this.this$0, Binder.getCallingPid(), callingUid, userId, "timeShiftSetMode");
            long identity = Binder.clearCallingIdentity();
            Object r4 = TvInputManagerService.m8756$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L16
            monitor-enter(r4);     // Catch: Throwable -> L16
            TvInputManagerService.m8778$$Nest$mgetSessionLocked(this.this$0, sessionToken, callingUid, resolvedUserId).timeShiftSetMode(mode);     // Catch: Throwable -> L7 Throwable -> L9
        L11:
            monitor-exit(r4);     // Catch: Throwable -> L7
            Binder.restoreCallingIdentity(identity);
            return;
        L7:
            th = move-exception;
            throw th;     // Catch: Throwable -> L16
        L9:
            e = move-exception;
            Slog.e(TvInputManagerService.TAG, "error in timeShiftSetMode", e);     // Catch: Throwable -> L7
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void timeShiftEnablePositionTracking(IBinder sessionToken, boolean enable, int userId) {
            int callingUid = Binder.getCallingUid();
            int resolvedUserId = TvInputManagerService.m8791$$Nest$mresolveCallingUserId(this.this$0, Binder.getCallingPid(), callingUid, userId, "timeShiftEnablePositionTracking");
            long identity = Binder.clearCallingIdentity();
            Object r4 = TvInputManagerService.m8756$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L16
            monitor-enter(r4);     // Catch: Throwable -> L16
            TvInputManagerService.m8778$$Nest$mgetSessionLocked(this.this$0, sessionToken, callingUid, resolvedUserId).timeShiftEnablePositionTracking(enable);     // Catch: Throwable -> L7 Throwable -> L9
        L11:
            monitor-exit(r4);     // Catch: Throwable -> L7
            Binder.restoreCallingIdentity(identity);
            return;
        L7:
            th = move-exception;
            throw th;     // Catch: Throwable -> L16
        L9:
            e = move-exception;
            Slog.e(TvInputManagerService.TAG, "error in timeShiftEnablePositionTracking", e);     // Catch: Throwable -> L7
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void notifyTvMessage(IBinder sessionToken, int type, Bundle data, int userId) {
            int callingUid = Binder.getCallingUid();
            int resolvedUserId = TvInputManagerService.m8791$$Nest$mresolveCallingUserId(this.this$0, Binder.getCallingPid(), callingUid, userId, "notifyTvmessage");
            long identity = Binder.clearCallingIdentity();
            Object r4 = TvInputManagerService.m8756$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L16
            monitor-enter(r4);     // Catch: Throwable -> L16
            TvInputManagerService.m8778$$Nest$mgetSessionLocked(this.this$0, sessionToken, callingUid, resolvedUserId).notifyTvMessage(type, data);     // Catch: Throwable -> L7 Throwable -> L9
        L11:
            monitor-exit(r4);     // Catch: Throwable -> L7
            Binder.restoreCallingIdentity(identity);
            return;
        L7:
            th = move-exception;
            throw th;     // Catch: Throwable -> L16
        L9:
            e = move-exception;
            Slog.e(TvInputManagerService.TAG, "error in notifyTvMessage", e);     // Catch: Throwable -> L7
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void setVideoFrozen(IBinder sessionToken, boolean isFrozen, int userId) {
            int callingUid = Binder.getCallingUid();
            int resolvedUserId = TvInputManagerService.m8791$$Nest$mresolveCallingUserId(this.this$0, Binder.getCallingPid(), callingUid, userId, "setVideoFrozen");
            long identity = Binder.clearCallingIdentity();
            Object r4 = TvInputManagerService.m8756$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L16
            monitor-enter(r4);     // Catch: Throwable -> L16
            TvInputManagerService.m8778$$Nest$mgetSessionLocked(this.this$0, sessionToken, callingUid, resolvedUserId).setVideoFrozen(isFrozen);     // Catch: Throwable -> L7 Throwable -> L9
        L11:
            monitor-exit(r4);     // Catch: Throwable -> L7
            Binder.restoreCallingIdentity(identity);
            return;
        L7:
            th = move-exception;
            throw th;     // Catch: Throwable -> L16
        L9:
            e = move-exception;
            Slog.e(TvInputManagerService.TAG, "error in setVideoFrozen", e);     // Catch: Throwable -> L7
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void setTvMessageEnabled(IBinder sessionToken, int type, boolean enabled, int userId) {
            int callingUid = Binder.getCallingUid();
            int resolvedUserId = TvInputManagerService.m8791$$Nest$mresolveCallingUserId(this.this$0, Binder.getCallingPid(), callingUid, userId, "setTvMessageEnabled");
            long identity = Binder.clearCallingIdentity();
            Object r4 = TvInputManagerService.m8756$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L16
            monitor-enter(r4);     // Catch: Throwable -> L16
            String inputId = SessionState.m8834$$Nest$fgetinputId(TvInputManagerService.m8780$$Nest$mgetSessionStateLocked(this.this$0, sessionToken, callingUid, userId));     // Catch: Throwable -> L7 Throwable -> L9
            TvInputManagerService.m8762$$Nest$fgetmTvInputHardwareManager(this.this$0).setTvMessageEnabled(inputId, type, enabled);     // Catch: Throwable -> L7 Throwable -> L9
            TvInputManagerService.m8778$$Nest$mgetSessionLocked(this.this$0, sessionToken, callingUid, resolvedUserId).setTvMessageEnabled(type, enabled);     // Catch: Throwable -> L7 Throwable -> L9
        L11:
            monitor-exit(r4);     // Catch: Throwable -> L7
            Binder.restoreCallingIdentity(identity);
            return;
        L7:
            th = move-exception;
            throw th;     // Catch: Throwable -> L16
        L9:
            e = move-exception;
            Slog.e(TvInputManagerService.TAG, "error in setTvMessageEnabled", e);     // Catch: Throwable -> L7
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void startRecording(IBinder sessionToken, Uri programUri, Bundle params, int userId) {
            int callingUid = Binder.getCallingUid();
            int resolvedUserId = TvInputManagerService.m8791$$Nest$mresolveCallingUserId(this.this$0, Binder.getCallingPid(), callingUid, userId, "startRecording");
            long identity = Binder.clearCallingIdentity();
            Object r4 = TvInputManagerService.m8756$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L16
            monitor-enter(r4);     // Catch: Throwable -> L16
            TvInputManagerService.m8778$$Nest$mgetSessionLocked(this.this$0, sessionToken, callingUid, resolvedUserId).startRecording(programUri, params);     // Catch: Throwable -> L7 Throwable -> L9
        L11:
            monitor-exit(r4);     // Catch: Throwable -> L7
            Binder.restoreCallingIdentity(identity);
            return;
        L7:
            th = move-exception;
            throw th;     // Catch: Throwable -> L16
        L9:
            e = move-exception;
            Slog.e(TvInputManagerService.TAG, "error in startRecording", e);     // Catch: Throwable -> L7
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void stopRecording(IBinder sessionToken, int userId) {
            int callingUid = Binder.getCallingUid();
            int resolvedUserId = TvInputManagerService.m8791$$Nest$mresolveCallingUserId(this.this$0, Binder.getCallingPid(), callingUid, userId, "stopRecording");
            long identity = Binder.clearCallingIdentity();
            Object r4 = TvInputManagerService.m8756$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L16
            monitor-enter(r4);     // Catch: Throwable -> L16
            TvInputManagerService.m8778$$Nest$mgetSessionLocked(this.this$0, sessionToken, callingUid, resolvedUserId).stopRecording();     // Catch: Throwable -> L7 Throwable -> L9
        L11:
            monitor-exit(r4);     // Catch: Throwable -> L7
            Binder.restoreCallingIdentity(identity);
            return;
        L7:
            th = move-exception;
            throw th;     // Catch: Throwable -> L16
        L9:
            e = move-exception;
            Slog.e(TvInputManagerService.TAG, "error in stopRecording", e);     // Catch: Throwable -> L7
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void pauseRecording(IBinder sessionToken, Bundle params, int userId) {
            int callingUid = Binder.getCallingUid();
            int resolvedUserId = TvInputManagerService.m8791$$Nest$mresolveCallingUserId(this.this$0, Binder.getCallingPid(), callingUid, userId, "pauseRecording");
            long identity = Binder.clearCallingIdentity();
            Object r4 = TvInputManagerService.m8756$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L16
            monitor-enter(r4);     // Catch: Throwable -> L16
            TvInputManagerService.m8778$$Nest$mgetSessionLocked(this.this$0, sessionToken, callingUid, resolvedUserId).pauseRecording(params);     // Catch: Throwable -> L7 Throwable -> L9
        L11:
            monitor-exit(r4);     // Catch: Throwable -> L7
            Binder.restoreCallingIdentity(identity);
            return;
        L7:
            th = move-exception;
            throw th;     // Catch: Throwable -> L16
        L9:
            e = move-exception;
            Slog.e(TvInputManagerService.TAG, "error in pauseRecording", e);     // Catch: Throwable -> L7
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void resumeRecording(IBinder sessionToken, Bundle params, int userId) {
            int callingUid = Binder.getCallingUid();
            int resolvedUserId = TvInputManagerService.m8791$$Nest$mresolveCallingUserId(this.this$0, Binder.getCallingPid(), callingUid, userId, "resumeRecording");
            long identity = Binder.clearCallingIdentity();
            Object r4 = TvInputManagerService.m8756$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L16
            monitor-enter(r4);     // Catch: Throwable -> L16
            TvInputManagerService.m8778$$Nest$mgetSessionLocked(this.this$0, sessionToken, callingUid, resolvedUserId).resumeRecording(params);     // Catch: Throwable -> L7 Throwable -> L9
        L11:
            monitor-exit(r4);     // Catch: Throwable -> L7
            Binder.restoreCallingIdentity(identity);
            return;
        L7:
            th = move-exception;
            throw th;     // Catch: Throwable -> L16
        L9:
            e = move-exception;
            Slog.e(TvInputManagerService.TAG, "error in resumeRecording", e);     // Catch: Throwable -> L7
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public List<TvInputHardwareInfo> getHardwareList() throws RemoteException {
            if (TvInputManagerService.m8754$$Nest$fgetmContext(this.this$0).checkCallingPermission("android.permission.TV_INPUT_HARDWARE") == 0) goto L6;
            return null;
        L6:
            long identity = Binder.clearCallingIdentity();
            List<TvInputHardwareInfo> r2 = TvInputManagerService.m8762$$Nest$fgetmTvInputHardwareManager(this.this$0).getHardwareList();     // Catch: Throwable -> L10
            Binder.restoreCallingIdentity(identity);
            return r2;
        L10:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public ITvInputHardware acquireTvInputHardware(int deviceId, ITvInputHardwareCallback callback, TvInputInfo info, int userId, String tvInputSessionId, int priorityHint) throws RemoteException {
            if (TvInputManagerService.m8754$$Nest$fgetmContext(this.this$0).checkCallingPermission("android.permission.TV_INPUT_HARDWARE") == 0) goto L6;
            return null;
        L6:
            int callingUid = Binder.getCallingUid();
            int resolvedUserId = TvInputManagerService.m8791$$Nest$mresolveCallingUserId(this.this$0, Binder.getCallingPid(), callingUid, userId, "acquireTvInputHardware");
            long identity = Binder.clearCallingIdentity();
            ITvInputHardware r0 = TvInputManagerService.m8762$$Nest$fgetmTvInputHardwareManager(this.this$0).acquireHardware(deviceId, callback, info, callingUid, resolvedUserId, tvInputSessionId, priorityHint);     // Catch: Throwable -> L10
            Binder.restoreCallingIdentity(identity);
            return r0;
        L10:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void releaseTvInputHardware(int deviceId, ITvInputHardware hardware, int userId) throws RemoteException {
            if (TvInputManagerService.m8754$$Nest$fgetmContext(this.this$0).checkCallingPermission("android.permission.TV_INPUT_HARDWARE") == 0) goto L5;
            return;
        L5:
            int callingUid = Binder.getCallingUid();
            int resolvedUserId = TvInputManagerService.m8791$$Nest$mresolveCallingUserId(this.this$0, Binder.getCallingPid(), callingUid, userId, "releaseTvInputHardware");
            long identity = Binder.clearCallingIdentity();
            TvInputManagerService.m8762$$Nest$fgetmTvInputHardwareManager(this.this$0).releaseHardware(deviceId, hardware, callingUid, resolvedUserId);     // Catch: Throwable -> L9
            Binder.restoreCallingIdentity(identity);
            return;
        L9:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public List<DvbDeviceInfo> getDvbDeviceList() throws RemoteException {
            if (TvInputManagerService.m8754$$Nest$fgetmContext(this.this$0).checkCallingPermission("android.permission.DVB_DEVICE") != 0) goto L43;
            long identity = Binder.clearCallingIdentity();
            ArrayList<DvbDeviceInfo> deviceInfosFromPattern1 = new ArrayList();     // Catch: Throwable -> L11
            File devDirectory = new File("/dev");     // Catch: Throwable -> L11
            boolean dvbDirectoryFound = false;
            String[] r6 = devDirectory.list();     // Catch: Throwable -> L11
            int r7 = r6.length;     // Catch: Throwable -> L11
            int r9 = 0;
        L6:
            int r10 = 1;
            if (r9 >= r7) goto L17;
            String fileName = r6[r9];     // Catch: Throwable -> L11
            Matcher matcher = TvInputManagerService.m8803$$Nest$sfgetsFrontEndDevicePattern().matcher(fileName);     // Catch: Throwable -> L11
            if (matcher.find() == false) goto L14;
            int adapterId = Integer.parseInt(matcher.group(1));     // Catch: Throwable -> L11
            int deviceId = Integer.parseInt(matcher.group(2));     // Catch: Throwable -> L11
            deviceInfosFromPattern1.add(new DvbDeviceInfo(adapterId, deviceId));     // Catch: Throwable -> L11
        L14:
            if (TextUtils.equals("dvb", fileName) == false) goto L16;
            dvbDirectoryFound = true;
        L16:
            r9 = r9 + 1;     // Catch: Throwable -> L11
            goto L6
        L17:
            if (dvbDirectoryFound == true) goto L21;
            List<DvbDeviceInfo> r8 = Collections.unmodifiableList(deviceInfosFromPattern1);     // Catch: Throwable -> L11
            Binder.restoreCallingIdentity(identity);
            return r8;
        L21:
            File dvbDirectory = new File(TvInputManagerService.DVB_DIRECTORY);     // Catch: Throwable -> L11
            ArrayList<DvbDeviceInfo> deviceInfosFromPattern2 = new ArrayList();     // Catch: Throwable -> L11
            String[] r11 = dvbDirectory.list();     // Catch: Throwable -> L11
            int r12 = r11.length;     // Catch: Throwable -> L11
            int r13 = 0;
        L22:
            if (r13 >= r12) goto L34;
            String fileNameInDvb = r11[r13];     // Catch: Throwable -> L11
            Matcher adapterMatcher = TvInputManagerService.m8802$$Nest$sfgetsAdapterDirPattern().matcher(fileNameInDvb);     // Catch: Throwable -> L11
            if (adapterMatcher.find() == false) goto L33;
            int adapterId2 = Integer.parseInt(adapterMatcher.group(r10));     // Catch: Throwable -> L11
            File adapterDirectory = new File("/dev/dvb/" + fileNameInDvb);     // Catch: Throwable -> L11
            String[] r0 = adapterDirectory.list();     // Catch: Throwable -> L11
            int r14 = r0.length;     // Catch: Throwable -> L11
            int r1 = 0;
        L26:
            if (r1 >= r14) goto L33;
            String fileNameInAdapter = r0[r1];     // Catch: Throwable -> L11
            int r19 = r1;
            Matcher frontendMatcher = TvInputManagerService.m8804$$Nest$sfgetsFrontEndInAdapterDirPattern().matcher(fileNameInAdapter);     // Catch: Throwable -> L11
            if (frontendMatcher.find() == false) goto L31;
            int deviceId2 = Integer.parseInt(frontendMatcher.group(1));     // Catch: Throwable -> L11
            deviceInfosFromPattern2.add(new DvbDeviceInfo(adapterId2, deviceId2));     // Catch: Throwable -> L11
        L31:
            r1 = r19 + 1;     // Catch: Throwable -> L11
        L33:
            r13 = r13 + 1;     // Catch: Throwable -> L11
            r10 = 1;
            deviceInfosFromPattern1 = deviceInfosFromPattern1;
            goto L22
        L34:
            ArrayList<DvbDeviceInfo> deviceInfosFromPattern3 = deviceInfosFromPattern1;
            if (deviceInfosFromPattern2.isEmpty() == false) goto L37;
            List<DvbDeviceInfo> r2 = Collections.unmodifiableList(deviceInfosFromPattern3);     // Catch: Throwable -> L11
        L38:
            Binder.restoreCallingIdentity(identity);
            return r2;
        L37:
            r2 = Collections.unmodifiableList(deviceInfosFromPattern2);     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        L43:
            throw new SecurityException("Requires DVB_DEVICE permission");
        }

        public ParcelFileDescriptor openDvbDevice(DvbDeviceInfo info, int deviceType) throws RemoteException {
            if (TvInputManagerService.m8754$$Nest$fgetmContext(this.this$0).checkCallingPermission("android.permission.DVB_DEVICE") != 0) goto L62;
            File devDirectory = new File("/dev");
            boolean dvbDeviceFound = false;
            String[] r4 = devDirectory.list();
            int r5 = r4.length;
            int r7 = 0;
        L6:
            if (r7 >= r5) goto L29;
            String fileName = r4[r7];
            if (TextUtils.equals("dvb", fileName) == false) goto L26;
            File dvbDirectory = new File(TvInputManagerService.DVB_DIRECTORY);
            String[] r10 = dvbDirectory.list();
            int r11 = r10.length;
            int r12 = 0;
        L10:
            if (r12 >= r11) goto L26;
            String fileNameInDvb = r10[r12];
            Matcher adapterMatcher = TvInputManagerService.m8802$$Nest$sfgetsAdapterDirPattern().matcher(fileNameInDvb);
            if (adapterMatcher.find() == false) goto L21;
            File adapterDirectory = new File("/dev/dvb/" + fileNameInDvb);
            String[] r0 = adapterDirectory.list();
            int r6 = r0.length;
            int r1 = 0;
        L15:
            if (r1 >= r6) goto L21;
            int r18 = r1;
            String fileNameInAdapter = r0[r18];
            Matcher frontendMatcher = TvInputManagerService.m8804$$Nest$sfgetsFrontEndInAdapterDirPattern().matcher(fileNameInAdapter);
            if (frontendMatcher.find() == true) goto L18;
            r1 = r18 + 1;
            goto L15
        L18:
            dvbDeviceFound = true;
        L22:
            if (dvbDeviceFound == true) goto L26;
            r12 = r12 + 1;
        L21:
            dvbDeviceFound = dvbDeviceFound;
        L26:
            if (dvbDeviceFound == true) goto L27;
            r7 = r7 + 1;
            goto L6
        L27:
            boolean dvbDeviceFound2 = dvbDeviceFound;
        L30:
            long identity = Binder.clearCallingIdentity();
            switch(deviceType) {
                case 0: goto L44;
                case 1: goto L40;
                case 2: goto L36;
                default: goto L33;
            };
        L36:
            if (dvbDeviceFound2 == false) goto L38;
            String r2 = "/dev/dvb/adapter%d/frontend%d";
        L39:
            String deviceFileName = String.format(r2, new Object[]{Integer.valueOf(info.getAdapterId()), Integer.valueOf(info.getDeviceId())});     // Catch: Throwable -> L34
            String deviceFileName2 = deviceFileName;
        L63:
            File r3 = new File(deviceFileName2);     // Catch: Throwable -> L34 FileNotFoundException -> L56
            if (2 != deviceType) goto L52;
            int r8 = LZMA2Options.DICT_SIZE_MAX;
        L53:
            ParcelFileDescriptor r9 = ParcelFileDescriptor.open(r3, r8);     // Catch: Throwable -> L34 FileNotFoundException -> L56
            Binder.restoreCallingIdentity(identity);
            return r9;
        L52:
            r8 = 268435456;
        L57:
            Binder.restoreCallingIdentity(identity);
            return null;
        L38:
            r2 = "/dev/dvb%d.frontend%d";
            goto L39
        L40:
            if (dvbDeviceFound2 == false) goto L42;
            String r13 = "/dev/dvb/adapter%d/dvr%d";
        L43:
            String deviceFileName3 = String.format(r13, new Object[]{Integer.valueOf(info.getAdapterId()), Integer.valueOf(info.getDeviceId())});     // Catch: Throwable -> L34
            deviceFileName2 = deviceFileName3;
            goto L63
        L42:
            r13 = "/dev/dvb%d.dvr%d";
            goto L43
        L44:
            if (dvbDeviceFound2 == false) goto L46;
            String r14 = "/dev/dvb/adapter%d/demux%d";
        L47:
            String deviceFileName4 = String.format(r14, new Object[]{Integer.valueOf(info.getAdapterId()), Integer.valueOf(info.getDeviceId())});     // Catch: Throwable -> L34
            deviceFileName2 = deviceFileName4;
            goto L63
        L46:
            r14 = "/dev/dvb%d.demux%d";
            goto L47
        L33:
            throw new IllegalArgumentException("Invalid DVB device: " + deviceType);     // Catch: Throwable -> L34
        L34:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        L29:
            dvbDeviceFound2 = dvbDeviceFound;
            goto L30
        L62:
            throw new SecurityException("Requires DVB_DEVICE permission");
        }

        public List<TvStreamConfig> getAvailableTvStreamConfigList(String inputId, int userId) throws RemoteException {
            ensureCaptureTvInputPermission();
            int callingUid = Binder.getCallingUid();
            int resolvedUserId = TvInputManagerService.m8791$$Nest$mresolveCallingUserId(this.this$0, Binder.getCallingPid(), callingUid, userId, "getAvailableTvStreamConfigList");
            long identity = Binder.clearCallingIdentity();
            List<TvStreamConfig> r4 = TvInputManagerService.m8762$$Nest$fgetmTvInputHardwareManager(this.this$0).getAvailableTvStreamConfigList(inputId, callingUid, resolvedUserId);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(identity);
            return r4;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public boolean captureFrame(String inputId, Surface surface, TvStreamConfig config, int userId) throws RemoteException {
            ensureCaptureTvInputPermission();
            int callingUid = Binder.getCallingUid();
            int resolvedUserId = TvInputManagerService.m8791$$Nest$mresolveCallingUserId(this.this$0, Binder.getCallingPid(), callingUid, userId, "captureFrame");
            long identity = Binder.clearCallingIdentity();
            Object r2 = TvInputManagerService.m8756$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L35
            monitor-enter(r2);     // Catch: Throwable -> L35
            UserState userState = TvInputManagerService.m8775$$Nest$mgetOrCreateUserStateLocked(this.this$0, resolvedUserId);     // Catch: Throwable -> L39
            if (UserState.m8862$$Nest$fgetinputMap(userState).get(inputId) != null) goto L13;
            Slog.e(TvInputManagerService.TAG, "input not found for " + inputId);     // Catch: Throwable -> L11
            monitor-exit(r2);     // Catch: Throwable -> L11
            Binder.restoreCallingIdentity(identity);
            return false;
        L13:
            Iterator r3 = UserState.m8870$$Nest$fgetsessionStateMap(userState).values().iterator();     // Catch: Throwable -> L39
        L14:
            if (r3.hasNext() == false) goto L23;
            SessionState sessionState = (SessionState) r3.next();     // Catch: Throwable -> L11
            if (SessionState.m8834$$Nest$fgetinputId(sessionState).equals(inputId) == false) goto L14;
            if (SessionState.m8833$$Nest$fgethardwareSessionToken(sessionState) == null) goto L14;
            String hardwareInputId = SessionState.m8834$$Nest$fgetinputId((SessionState) UserState.m8870$$Nest$fgetsessionStateMap(userState).get(SessionState.m8833$$Nest$fgethardwareSessionToken(sessionState)));     // Catch: Throwable -> L11
            String hardwareInputId2 = hardwareInputId;
        L60:
            monitor-exit(r2);     // Catch: Throwable -> L37
            TvInputHardwareManager r0 = TvInputManagerService.m8762$$Nest$fgetmTvInputHardwareManager(this.this$0);     // Catch: Throwable -> L35
            if (hardwareInputId2 == null) goto L28;
            String r1 = hardwareInputId2;
        L51:
            boolean r12 = r0.captureFrame(r1, surface, config, callingUid, resolvedUserId);     // Catch: Throwable -> L33
            Binder.restoreCallingIdentity(identity);
            return r12;
        L33:
            th = move-exception;
            Throwable r13 = th;
        L47:
            Binder.restoreCallingIdentity(identity);
            throw r13;
        L28:
            r1 = inputId;
        L37:
            th = th;
        L58:
            monitor-exit(r2);     // Catch: Throwable -> L45
            throw th;     // Catch: Throwable -> L43
        L43:
            th = move-exception;
            r13 = th;
        L45:
            th = th;
            goto L58
        L23:
            hardwareInputId2 = null;
        L11:
            th = th;
        L39:
            th = th;
        L35:
            th = move-exception;
            r13 = th;
            goto L47
        }

        public boolean isSingleSessionActive(int userId) throws RemoteException {
            ensureCaptureTvInputPermission();
            int callingUid = Binder.getCallingUid();
            int resolvedUserId = TvInputManagerService.m8791$$Nest$mresolveCallingUserId(this.this$0, Binder.getCallingPid(), callingUid, userId, "isSingleSessionActive");
            long identity = Binder.clearCallingIdentity();
            Object r4 = TvInputManagerService.m8756$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L28
            monitor-enter(r4);     // Catch: Throwable -> L28
            UserState userState = TvInputManagerService.m8775$$Nest$mgetOrCreateUserStateLocked(this.this$0, resolvedUserId);     // Catch: Throwable -> L10
            boolean r7 = true;
            if (UserState.m8870$$Nest$fgetsessionStateMap(userState).size() != 1) goto L13;
            monitor-exit(r4);     // Catch: Throwable -> L10
            Binder.restoreCallingIdentity(identity);
            return true;
        L13:
            if (UserState.m8870$$Nest$fgetsessionStateMap(userState).size() != 2) goto L23;
            SessionState[] sessionStates = (SessionState[]) UserState.m8870$$Nest$fgetsessionStateMap(userState).values().toArray(new SessionState[2]);     // Catch: Throwable -> L10
            if (SessionState.m8833$$Nest$fgethardwareSessionToken(sessionStates[0]) != null) goto L20;
            if (SessionState.m8833$$Nest$fgethardwareSessionToken(sessionStates[1]) != null) goto L20;
            r7 = false;
        L20:
            monitor-exit(r4);     // Catch: Throwable -> L10
            Binder.restoreCallingIdentity(identity);
            return r7;
        L23:
            monitor-exit(r4);     // Catch: Throwable -> L10
            Binder.restoreCallingIdentity(identity);
            return false;
        L10:
            th = move-exception;
            throw th;     // Catch: Throwable -> L28
        L28:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        private void ensureCaptureTvInputPermission() {
            if (TvInputManagerService.m8754$$Nest$fgetmContext(this.this$0).checkCallingPermission("android.permission.CAPTURE_TV_INPUT") != 0) goto L6;
            return;
        L6:
            throw new SecurityException("Requires CAPTURE_TV_INPUT permission");
        }

        public void requestChannelBrowsable(Uri channelUri, int userId) throws RemoteException {
            String callingPackageName = getCallingPackageName();
            int resolvedUserId = TvInputManagerService.m8791$$Nest$mresolveCallingUserId(this.this$0, Binder.getCallingPid(), Binder.getCallingUid(), userId, "requestChannelBrowsable");
            long identity = Binder.clearCallingIdentity();
            Intent intent = new Intent("android.media.tv.action.CHANNEL_BROWSABLE_REQUESTED");     // Catch: Throwable -> L10
            List<ResolveInfo> list = this.this$0.getContext().getPackageManager().queryBroadcastReceivers(intent, 0);     // Catch: Throwable -> L10
            if (list == null) goto L12;
            Iterator<ResolveInfo> r6 = list.iterator();     // Catch: Throwable -> L10
        L7:
            if (r6.hasNext() == false) goto L12;
            ResolveInfo info = r6.next();     // Catch: Throwable -> L10
            String receiverPackageName = info.activityInfo.packageName;     // Catch: Throwable -> L10
            intent.putExtra("android.media.tv.extra.CHANNEL_ID", ContentUris.parseId(channelUri));     // Catch: Throwable -> L10
            intent.putExtra("android.media.tv.extra.PACKAGE_NAME", callingPackageName);     // Catch: Throwable -> L10
            intent.setPackage(receiverPackageName);     // Catch: Throwable -> L10
            this.this$0.getContext().sendBroadcastAsUser(intent, new UserHandle(resolvedUserId));     // Catch: Throwable -> L10
        L12:
            Binder.restoreCallingIdentity(identity);
            return;
        L10:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void requestBroadcastInfo(IBinder sessionToken, BroadcastInfoRequest request, int userId) {
            int callingUid = Binder.getCallingUid();
            int callingPid = Binder.getCallingPid();
            int resolvedUserId = TvInputManagerService.m8791$$Nest$mresolveCallingUserId(this.this$0, callingPid, callingUid, userId, "requestBroadcastInfo");
            long identity = Binder.clearCallingIdentity();
            Object r5 = TvInputManagerService.m8756$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L16
            monitor-enter(r5);     // Catch: Throwable -> L16
            SessionState sessionState = TvInputManagerService.m8780$$Nest$mgetSessionStateLocked(this.this$0, sessionToken, callingUid, resolvedUserId);     // Catch: Throwable -> L7 Throwable -> L9
            TvInputManagerService.m8779$$Nest$mgetSessionLocked(this.this$0, sessionState).requestBroadcastInfo(request);     // Catch: Throwable -> L7 Throwable -> L9
        L11:
            monitor-exit(r5);     // Catch: Throwable -> L7
            Binder.restoreCallingIdentity(identity);
            return;
        L9:
            e = move-exception;
            Slog.e(TvInputManagerService.TAG, "error in requestBroadcastInfo", e);     // Catch: Throwable -> L7
        L7:
            th = move-exception;
            throw th;     // Catch: Throwable -> L16
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void removeBroadcastInfo(IBinder sessionToken, int requestId, int userId) {
            int callingUid = Binder.getCallingUid();
            int callingPid = Binder.getCallingPid();
            int resolvedUserId = TvInputManagerService.m8791$$Nest$mresolveCallingUserId(this.this$0, callingPid, callingUid, userId, "removeBroadcastInfo");
            long identity = Binder.clearCallingIdentity();
            Object r5 = TvInputManagerService.m8756$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L16
            monitor-enter(r5);     // Catch: Throwable -> L16
            SessionState sessionState = TvInputManagerService.m8780$$Nest$mgetSessionStateLocked(this.this$0, sessionToken, callingUid, resolvedUserId);     // Catch: Throwable -> L7 Throwable -> L9
            TvInputManagerService.m8779$$Nest$mgetSessionLocked(this.this$0, sessionState).removeBroadcastInfo(requestId);     // Catch: Throwable -> L7 Throwable -> L9
        L11:
            monitor-exit(r5);     // Catch: Throwable -> L7
            Binder.restoreCallingIdentity(identity);
            return;
        L9:
            e = move-exception;
            Slog.e(TvInputManagerService.TAG, "error in removeBroadcastInfo", e);     // Catch: Throwable -> L7
        L7:
            th = move-exception;
            throw th;     // Catch: Throwable -> L16
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void requestAd(IBinder sessionToken, AdRequest request, int userId) {
            int callingUid = Binder.getCallingUid();
            int callingPid = Binder.getCallingPid();
            int resolvedUserId = TvInputManagerService.m8791$$Nest$mresolveCallingUserId(this.this$0, callingPid, callingUid, userId, "requestAd");
            long identity = Binder.clearCallingIdentity();
            Object r5 = TvInputManagerService.m8756$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L16
            monitor-enter(r5);     // Catch: Throwable -> L16
            SessionState sessionState = TvInputManagerService.m8780$$Nest$mgetSessionStateLocked(this.this$0, sessionToken, callingUid, resolvedUserId);     // Catch: Throwable -> L7 Throwable -> L9
            TvInputManagerService.m8779$$Nest$mgetSessionLocked(this.this$0, sessionState).requestAd(request);     // Catch: Throwable -> L7 Throwable -> L9
        L11:
            monitor-exit(r5);     // Catch: Throwable -> L7
            Binder.restoreCallingIdentity(identity);
            return;
        L9:
            e = move-exception;
            Slog.e(TvInputManagerService.TAG, "error in requestAd", e);     // Catch: Throwable -> L7
        L7:
            th = move-exception;
            throw th;     // Catch: Throwable -> L16
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void notifyAdBufferReady(IBinder sessionToken, AdBuffer buffer, int userId) {
            int callingUid = Binder.getCallingUid();
            int callingPid = Binder.getCallingPid();
            int resolvedUserId = TvInputManagerService.m8791$$Nest$mresolveCallingUserId(this.this$0, callingPid, callingUid, userId, "notifyAdBuffer");
            long identity = Binder.clearCallingIdentity();
            Object r5 = TvInputManagerService.m8756$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L27
            monitor-enter(r5);     // Catch: Throwable -> L27
            SessionState sessionState = TvInputManagerService.m8780$$Nest$mgetSessionStateLocked(this.this$0, sessionToken, callingUid, resolvedUserId);     // Catch: Throwable -> L12 Throwable -> L14
            TvInputManagerService.m8779$$Nest$mgetSessionLocked(this.this$0, sessionState).notifyAdBufferReady(buffer);     // Catch: Throwable -> L12 Throwable -> L14
            if (buffer == null) goto L18;
            SharedMemory r6 = buffer.getSharedMemory();     // Catch: Throwable -> L10
        L8:
            r6.close();     // Catch: Throwable -> L10
        L18:
            monitor-exit(r5);     // Catch: Throwable -> L10
            Binder.restoreCallingIdentity(identity);
            return;
        L14:
            e = move-exception;
            Slog.e(TvInputManagerService.TAG, "error in notifyAdBuffer", e);     // Catch: Throwable -> L12
            if (buffer == null) goto L18;
            r6 = buffer.getSharedMemory();     // Catch: Throwable -> L10
        L12:
            th = move-exception;
            if (buffer == null) goto L24;
            buffer.getSharedMemory().close();     // Catch: Throwable -> L10
        L24:
            throw th;     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            throw th;     // Catch: Throwable -> L27
        L27:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void notifyTvAdSessionData(IBinder sessionToken, String type, Bundle data, int userId) {
            int callingUid = Binder.getCallingUid();
            int callingPid = Binder.getCallingPid();
            int resolvedUserId = TvInputManagerService.m8791$$Nest$mresolveCallingUserId(this.this$0, callingPid, callingUid, userId, "notifyTvAdSessionData");
            long identity = Binder.clearCallingIdentity();
            Object r5 = TvInputManagerService.m8756$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L16
            monitor-enter(r5);     // Catch: Throwable -> L16
            SessionState sessionState = TvInputManagerService.m8780$$Nest$mgetSessionStateLocked(this.this$0, sessionToken, callingUid, resolvedUserId);     // Catch: Throwable -> L7 Throwable -> L9
            TvInputManagerService.m8779$$Nest$mgetSessionLocked(this.this$0, sessionState).notifyTvAdSessionData(type, data);     // Catch: Throwable -> L7 Throwable -> L9
        L11:
            monitor-exit(r5);     // Catch: Throwable -> L7
            Binder.restoreCallingIdentity(identity);
            return;
        L9:
            e = move-exception;
            Slog.e(TvInputManagerService.TAG, "error in notifyTvAdSessionData", e);     // Catch: Throwable -> L7
        L7:
            th = move-exception;
            throw th;     // Catch: Throwable -> L16
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public int getClientPid(String sessionId) {
            ensureTunerResourceAccessPermission();
            long identity = Binder.clearCallingIdentity();
            int clientPid = -1;
            Object r3 = TvInputManagerService.m8756$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L16
            monitor-enter(r3);     // Catch: Throwable -> L16
            clientPid = getClientPidLocked(sessionId);     // Catch: Throwable -> L7 ClientPidNotFoundException -> L9
        L11:
            monitor-exit(r3);     // Catch: Throwable -> L7
            Binder.restoreCallingIdentity(identity);
            return clientPid;
        L7:
            th = move-exception;
            throw th;     // Catch: Throwable -> L16
        L9:
            e = move-exception;
            Slog.e(TvInputManagerService.TAG, "error in getClientPid", e);     // Catch: Throwable -> L7
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public int getClientUserId(String sessionId) {
            ensureTunerResourceAccessPermission();
            int clientUserId = -1;
            long identity = Binder.clearCallingIdentity();
            Object r3 = TvInputManagerService.m8756$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L16
            monitor-enter(r3);     // Catch: Throwable -> L16
            clientUserId = getClientUserIdLocked(sessionId);     // Catch: Throwable -> L7 ClientUserIdNotFoundException -> L9
        L11:
            monitor-exit(r3);     // Catch: Throwable -> L7
            Binder.restoreCallingIdentity(identity);
            return clientUserId;
        L7:
            th = move-exception;
            throw th;     // Catch: Throwable -> L16
        L9:
            e = move-exception;
            Slog.e(TvInputManagerService.TAG, "error in getClientUserId", e);     // Catch: Throwable -> L7
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public int getClientPriority(int useCase, String sessionId) {
            ensureTunerResourceAccessPermission();
            int callingPid = Binder.getCallingPid();
            long identity = Binder.clearCallingIdentity();
            int clientPid = -1;
            if (sessionId != null) goto L24;
            clientPid = callingPid;
        L19:
            TunerResourceManager trm = (TunerResourceManager) TvInputManagerService.m8754$$Nest$fgetmContext(this.this$0).getSystemService("tv_tuner_resource_mgr");     // Catch: Throwable -> L16
            int r5 = trm.getClientPriority(useCase, clientPid);     // Catch: Throwable -> L16
            Binder.restoreCallingIdentity(identity);
            return r5;
        L24:
            Object r4 = TvInputManagerService.m8756$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L16
            monitor-enter(r4);     // Catch: Throwable -> L16
            clientPid = getClientPidLocked(sessionId);     // Catch: Throwable -> L8 ClientPidNotFoundException -> L10
        L12:
            monitor-exit(r4);     // Catch: Throwable -> L8
        L8:
            th = move-exception;
            throw th;     // Catch: Throwable -> L16
        L10:
            e = move-exception;
            Slog.e(TvInputManagerService.TAG, "error in getClientPriority", e);     // Catch: Throwable -> L8
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public List<TunedInfo> getCurrentTunedInfos(int userId) {
            if (TvInputManagerService.m8754$$Nest$fgetmContext(this.this$0).checkCallingPermission("android.permission.ACCESS_TUNED_INFO") != 0) goto L13;
            int callingPid = Binder.getCallingPid();
            int callingUid = Binder.getCallingUid();
            int resolvedUserId = TvInputManagerService.m8791$$Nest$mresolveCallingUserId(this.this$0, callingPid, callingUid, userId, "getTvCurrentChannelInfos");
            Object r3 = TvInputManagerService.m8756$$Nest$fgetmLock(this.this$0);
            monitor-enter(r3);
            UserState userState = TvInputManagerService.m8775$$Nest$mgetOrCreateUserStateLocked(this.this$0, resolvedUserId);     // Catch: Throwable -> L9
            List<TunedInfo> r5 = TvInputManagerService.m8774$$Nest$mgetCurrentTunedInfosInternalLocked(this.this$0, userState, callingPid, callingUid);     // Catch: Throwable -> L9
            monitor-exit(r3);     // Catch: Throwable -> L9
            return r5;
        L9:
            th = move-exception;
            throw th;
        L13:
            throw new SecurityException("The caller does not have access tuned info permission");
        }

        public void addHardwareDevice(int deviceId) {
            TvInputHardwareInfo info = new TvInputHardwareInfo.Builder().deviceId(deviceId).type(9).audioType(0).audioAddress("0").hdmiPortId(0).build();
            TvStreamConfig[] configs = {new TvStreamConfig.Builder().streamId(19001).generation(1).maxHeight(600).maxWidth(800).type(1).build()};
            TvInputManagerService.m8762$$Nest$fgetmTvInputHardwareManager(this.this$0).onDeviceAvailable(info, configs);
        }

        public void removeHardwareDevice(int deviceId) {
            TvInputManagerService.m8762$$Nest$fgetmTvInputHardwareManager(this.this$0).onDeviceUnavailable(deviceId);
        }

        private int getClientPidLocked(String sessionId) throws ClientPidNotFoundException {
            if (TvInputManagerService.m8761$$Nest$fgetmSessionIdToSessionStateMap(this.this$0).get(sessionId) == null) goto L7;
            return SessionState.m8828$$Nest$fgetcallingPid((SessionState) TvInputManagerService.m8761$$Nest$fgetmSessionIdToSessionStateMap(this.this$0).get(sessionId));
        L7:
            throw new ClientPidNotFoundException("Client Pid not found with sessionId " + sessionId);
        }

        private int getClientUserIdLocked(String sessionId) throws ClientUserIdNotFoundException {
            SessionState sessionState = (SessionState) TvInputManagerService.m8761$$Nest$fgetmSessionIdToSessionStateMap(this.this$0).get(sessionId);
            if (sessionState == null) goto L7;
            return SessionState.m8844$$Nest$fgetuserId(sessionState);
        L7:
            throw new ClientUserIdNotFoundException("Client UserId not found with sessionId " + sessionId);
        }

        private void ensureTunerResourceAccessPermission() {
            if (TvInputManagerService.m8754$$Nest$fgetmContext(this.this$0).checkCallingPermission("android.permission.TUNER_RESOURCE_ACCESS") != 0) goto L6;
            return;
        L6:
            throw new SecurityException("Requires TUNER_RESOURCE_ACCESS permission");
        }

        private void ensureTisExtensionInterfacePermission() {
            if (TvInputManagerService.m8754$$Nest$fgetmContext(this.this$0).checkCallingPermission("android.permission.TIS_EXTENSION_INTERFACE") != 0) goto L6;
            return;
        L6:
            throw new SecurityException("Requires TIS_EXTENSION_INTERFACE permission");
        }

        @NeverCompile
        protected void dump(FileDescriptor fd, PrintWriter writer, String[] args) {
            IndentingPrintWriter pw = new IndentingPrintWriter(writer, "  ");
            if (DumpUtils.checkDumpPermission(TvInputManagerService.m8754$$Nest$fgetmContext(this.this$0), TvInputManagerService.TAG, pw) == true) goto L5;
            return;
        L5:
            Object r1 = TvInputManagerService.m8756$$Nest$fgetmLock(this.this$0);
            monitor-enter(r1);
            pw.println("User Ids (Current user: " + TvInputManagerService.m8755$$Nest$fgetmCurrentUserId(this.this$0) + "):");     // Catch: Throwable -> L11
            pw.increaseIndent();     // Catch: Throwable -> L11
            int i = 0;
        L9:
            if (i >= TvInputManagerService.m8763$$Nest$fgetmUserStates(this.this$0).size()) goto L13;
            pw.println(Integer.valueOf(TvInputManagerService.m8763$$Nest$fgetmUserStates(this.this$0).keyAt(i)));     // Catch: Throwable -> L11
            i = i + 1;     // Catch: Throwable -> L11
            goto L9
        L13:
            pw.decreaseIndent();     // Catch: Throwable -> L11
            int i2 = 0;
        L15:
            if (i2 >= TvInputManagerService.m8763$$Nest$fgetmUserStates(this.this$0).size()) goto L49;
            int userId = TvInputManagerService.m8763$$Nest$fgetmUserStates(this.this$0).keyAt(i2);     // Catch: Throwable -> L11
            UserState userState = TvInputManagerService.m8775$$Nest$mgetOrCreateUserStateLocked(this.this$0, userId);     // Catch: Throwable -> L11
            pw.println("UserState (" + userId + "):");     // Catch: Throwable -> L11
            pw.increaseIndent();     // Catch: Throwable -> L11
            pw.println("inputMap: inputId -> TvInputState");     // Catch: Throwable -> L11
            pw.increaseIndent();     // Catch: Throwable -> L11
            Iterator r5 = UserState.m8862$$Nest$fgetinputMap(userState).entrySet().iterator();     // Catch: Throwable -> L11
        L18:
            if (r5.hasNext() == false) goto L20;
            Map.Entry<String, TvInputState> entry = (Map.Entry) r5.next();     // Catch: Throwable -> L11
            pw.println(entry.getKey() + ": " + entry.getValue());     // Catch: Throwable -> L11
            goto L18
        L20:
            pw.decreaseIndent();     // Catch: Throwable -> L11
            pw.println("packageSet:");     // Catch: Throwable -> L11
            pw.increaseIndent();     // Catch: Throwable -> L11
            Iterator r6 = UserState.m8867$$Nest$fgetpackageSet(userState).iterator();     // Catch: Throwable -> L11
        L22:
            if (r6.hasNext() == false) goto L24;
            String packageName = (String) r6.next();     // Catch: Throwable -> L11
            pw.println(packageName);     // Catch: Throwable -> L11
            goto L22
        L24:
            pw.decreaseIndent();     // Catch: Throwable -> L11
            pw.println("clientStateMap: ITvInputClient -> ClientState");     // Catch: Throwable -> L11
            pw.increaseIndent();     // Catch: Throwable -> L11
            Iterator r7 = UserState.m8860$$Nest$fgetclientStateMap(userState).entrySet().iterator();     // Catch: Throwable -> L11
        L26:
            if (r7.hasNext() == false) goto L32;
            Map.Entry<IBinder, ClientState> entry2 = (Map.Entry) r7.next();     // Catch: Throwable -> L11
            ClientState client = entry2.getValue();     // Catch: Throwable -> L11
            pw.println(entry2.getKey() + ": " + client);     // Catch: Throwable -> L11
            pw.increaseIndent();     // Catch: Throwable -> L11
            pw.println("sessionTokens:");     // Catch: Throwable -> L11
            pw.increaseIndent();     // Catch: Throwable -> L11
            Iterator r8 = ClientState.m8808$$Nest$fgetsessionTokens(client).iterator();     // Catch: Throwable -> L11
        L29:
            if (r8.hasNext() == false) goto L31;
            IBinder token = (IBinder) r8.next();     // Catch: Throwable -> L11
            pw.println("" + token);     // Catch: Throwable -> L11
            goto L29
        L31:
            pw.decreaseIndent();     // Catch: Throwable -> L11
            pw.println("clientTokens: " + ClientState.m8807$$Nest$fgetclientToken(client));     // Catch: Throwable -> L11
            pw.println("userId: " + ClientState.m8809$$Nest$fgetuserId(client));     // Catch: Throwable -> L11
            pw.decreaseIndent();     // Catch: Throwable -> L11
            goto L26
        L32:
            pw.decreaseIndent();     // Catch: Throwable -> L11
            pw.println("serviceStateMap: ComponentName -> ServiceState");     // Catch: Throwable -> L11
            pw.increaseIndent();     // Catch: Throwable -> L11
            Iterator r9 = UserState.m8869$$Nest$fgetserviceStateMap(userState).entrySet().iterator();     // Catch: Throwable -> L11
        L34:
            if (r9.hasNext() == false) goto L40;
            Map.Entry<ComponentName, ServiceState> entry3 = (Map.Entry) r9.next();     // Catch: Throwable -> L11
            ServiceState service = entry3.getValue();     // Catch: Throwable -> L11
            pw.println(entry3.getKey() + ": " + service);     // Catch: Throwable -> L11
            pw.increaseIndent();     // Catch: Throwable -> L11
            pw.println("sessionTokens:");     // Catch: Throwable -> L11
            pw.increaseIndent();     // Catch: Throwable -> L11
            Iterator r10 = ServiceState.m8822$$Nest$fgetsessionTokens(service).iterator();     // Catch: Throwable -> L11
        L37:
            if (r10.hasNext() == false) goto L39;
            IBinder token2 = (IBinder) r10.next();     // Catch: Throwable -> L11
            pw.println("" + token2);     // Catch: Throwable -> L11
            goto L37
        L39:
            pw.decreaseIndent();     // Catch: Throwable -> L11
            pw.println("service: " + ServiceState.m8821$$Nest$fgetservice(service));     // Catch: Throwable -> L11
            pw.println("callback: " + ServiceState.m8811$$Nest$fgetcallback(service));     // Catch: Throwable -> L11
            pw.println("bound: " + ServiceState.m8810$$Nest$fgetbound(service));     // Catch: Throwable -> L11
            pw.println("reconnecting: " + ServiceState.m8820$$Nest$fgetreconnecting(service));     // Catch: Throwable -> L11
            pw.decreaseIndent();     // Catch: Throwable -> L11
            goto L34
        L40:
            pw.decreaseIndent();     // Catch: Throwable -> L11
            pw.println("sessionStateMap: ITvInputSession -> SessionState");     // Catch: Throwable -> L11
            pw.increaseIndent();     // Catch: Throwable -> L11
            Iterator r11 = UserState.m8870$$Nest$fgetsessionStateMap(userState).entrySet().iterator();     // Catch: Throwable -> L11
        L42:
            if (r11.hasNext() == false) goto L44;
            Map.Entry<IBinder, SessionState> entry4 = (Map.Entry) r11.next();     // Catch: Throwable -> L11
            SessionState session = entry4.getValue();     // Catch: Throwable -> L11
            pw.println(entry4.getKey() + ": " + session);     // Catch: Throwable -> L11
            pw.increaseIndent();     // Catch: Throwable -> L11
            pw.println("inputId: " + SessionState.m8834$$Nest$fgetinputId(session));     // Catch: Throwable -> L11
            pw.println("sessionId: " + SessionState.m8841$$Nest$fgetsessionId(session));     // Catch: Throwable -> L11
            pw.println("client: " + SessionState.m8830$$Nest$fgetclient(session));     // Catch: Throwable -> L11
            pw.println("seq: " + SessionState.m8839$$Nest$fgetseq(session));     // Catch: Throwable -> L11
            pw.println("callingUid: " + SessionState.m8829$$Nest$fgetcallingUid(session));     // Catch: Throwable -> L11
            pw.println("callingPid: " + SessionState.m8828$$Nest$fgetcallingPid(session));     // Catch: Throwable -> L11
            pw.println("userId: " + SessionState.m8844$$Nest$fgetuserId(session));     // Catch: Throwable -> L11
            pw.println("sessionToken: " + SessionState.m8842$$Nest$fgetsessionToken(session));     // Catch: Throwable -> L11
            pw.println("session: " + SessionState.m8840$$Nest$fgetsession(session));     // Catch: Throwable -> L11
            pw.println("hardwareSessionToken: " + SessionState.m8833$$Nest$fgethardwareSessionToken(session));     // Catch: Throwable -> L11
            pw.decreaseIndent();     // Catch: Throwable -> L11
            goto L42
        L44:
            pw.decreaseIndent();     // Catch: Throwable -> L11
            pw.println("mCallbacks:");     // Catch: Throwable -> L11
            pw.increaseIndent();     // Catch: Throwable -> L11
            int n = UserState.m8864$$Nest$fgetmCallbacks(userState).beginBroadcast();     // Catch: Throwable -> L11
            int j = 0;
        L45:
            if (j >= n) goto L47;
            pw.println(UserState.m8864$$Nest$fgetmCallbacks(userState).getRegisteredCallbackItem(j));     // Catch: Throwable -> L11
            j = j + 1;     // Catch: Throwable -> L11
            goto L45
        L47:
            UserState.m8864$$Nest$fgetmCallbacks(userState).finishBroadcast();     // Catch: Throwable -> L11
            pw.decreaseIndent();     // Catch: Throwable -> L11
            pw.println("mainSessionToken: " + UserState.m8866$$Nest$fgetmainSessionToken(userState));     // Catch: Throwable -> L11
            pw.decreaseIndent();     // Catch: Throwable -> L11
            i2 = i2 + 1;     // Catch: Throwable -> L11
            goto L15
        L49:
            monitor-exit(r1);     // Catch: Throwable -> L11
            TvInputManagerService.m8762$$Nest$fgetmTvInputHardwareManager(this.this$0).dump(fd, writer, args);
            return;
        L11:
            th = move-exception;
            throw th;
        }
    }

    private static class ClientPidNotFoundException extends IllegalArgumentException {
        public ClientPidNotFoundException(String name) {
            super(name);
        }
    }

    private final class ClientState implements IBinder.DeathRecipient {
        private IBinder clientToken;
        private final List<IBinder> sessionTokens;
        final /* synthetic */ TvInputManagerService this$0;
        private final int userId;

        /* JADX INFO: renamed from: -$$Nest$fgetclientToken, reason: not valid java name */
        static /* bridge */ /* synthetic */ IBinder m8807$$Nest$fgetclientToken(ClientState r0) {
            return r0.clientToken;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetsessionTokens, reason: not valid java name */
        static /* bridge */ /* synthetic */ List m8808$$Nest$fgetsessionTokens(ClientState r0) {
            return r0.sessionTokens;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetuserId, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m8809$$Nest$fgetuserId(ClientState r0) {
            return r0.userId;
        }

        ClientState(TvInputManagerService r1, IBinder clientToken, int userId) {
            this.this$0 = r1;
            this.sessionTokens = new ArrayList();
            this.clientToken = clientToken;
            this.userId = userId;
        }

        public boolean isEmpty() {
            return this.sessionTokens.isEmpty();
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            Object r0 = TvInputManagerService.m8756$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            UserState userState = TvInputManagerService.m8775$$Nest$mgetOrCreateUserStateLocked(this.this$0, this.userId);     // Catch: Throwable -> L11
            ClientState clientState = (ClientState) UserState.m8860$$Nest$fgetclientStateMap(userState).get(this.clientToken);     // Catch: Throwable -> L11
            if (clientState != null) goto L7;
        L14:
            this.clientToken = null;     // Catch: Throwable -> L11
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L7:
            if (clientState.sessionTokens.size() <= 0) goto L14;
            IBinder sessionToken = clientState.sessionTokens.get(0);     // Catch: Throwable -> L11
            TvInputManagerService.m8787$$Nest$mreleaseSessionLocked(this.this$0, sessionToken, 1000, this.userId);     // Catch: Throwable -> L11
            if (clientState.sessionTokens.contains(sessionToken) == false) goto L7;
            Slog.d(TvInputManagerService.TAG, "remove sessionToken " + sessionToken + " for " + this.clientToken);     // Catch: Throwable -> L11
            clientState.sessionTokens.remove(sessionToken);     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            throw th;
        }
    }

    private static class ClientUserIdNotFoundException extends IllegalArgumentException {
        ClientUserIdNotFoundException(String name) {
            super(name);
        }
    }

    private final class HardwareListener implements TvInputHardwareManager.Listener {
        final /* synthetic */ TvInputManagerService this$0;

        /* synthetic */ HardwareListener(TvInputManagerService r1, TvInputManagerServiceIA r2) {
            this(r1);
        }

        private HardwareListener(TvInputManagerService r1) {
            this.this$0 = r1;
        }

        @Override // com.android.server.tv.TvInputHardwareManager.Listener
        public void onStateChanged(String inputId, int state) {
            Object r0 = TvInputManagerService.m8756$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            TvInputManagerService.m8794$$Nest$msetStateLocked(this.this$0, inputId, state, TvInputManagerService.m8755$$Nest$fgetmCurrentUserId(this.this$0));     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.tv.TvInputHardwareManager.Listener
        public void onHardwareDeviceAdded(TvInputHardwareInfo info) {
            Object r0 = TvInputManagerService.m8756$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            UserState userState = TvInputManagerService.m8775$$Nest$mgetOrCreateUserStateLocked(this.this$0, TvInputManagerService.m8755$$Nest$fgetmCurrentUserId(this.this$0));     // Catch: Throwable -> L14
            Iterator r2 = UserState.m8869$$Nest$fgetserviceStateMap(userState).values().iterator();     // Catch: Throwable -> L14
        L6:
            if (r2.hasNext() == false) goto L22;
            ServiceState serviceState = (ServiceState) r2.next();     // Catch: Throwable -> L14
            if (ServiceState.m8818$$Nest$fgetisHardware(serviceState) == false) goto L6;
            TvInputManagerService.m8769$$Nest$mbindService(this.this$0, serviceState, TvInputManagerService.m8755$$Nest$fgetmCurrentUserId(this.this$0));     // Catch: Throwable -> L14 RemoteException -> L16
            if (ServiceState.m8821$$Nest$fgetservice(serviceState) == null) goto L6;
            ServiceState.m8821$$Nest$fgetservice(serviceState).notifyHardwareAdded(info);     // Catch: Throwable -> L14 RemoteException -> L16
        L16:
            e = move-exception;
            Slog.e(TvInputManagerService.TAG, "error in notifyHardwareAdded", e);     // Catch: Throwable -> L14
            goto L6
        L22:
            TvInputManagerService.m8798$$Nest$mupdateHardwareServiceConnectionDelayed(this.this$0, TvInputManagerService.m8755$$Nest$fgetmCurrentUserId(this.this$0));     // Catch: Throwable -> L14
            monitor-exit(r0);     // Catch: Throwable -> L14
            return;
        L14:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.tv.TvInputHardwareManager.Listener
        public void onHardwareDeviceRemoved(TvInputHardwareInfo info) {
            Object r0 = TvInputManagerService.m8756$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            String relatedInputId = TvInputManagerService.m8762$$Nest$fgetmTvInputHardwareManager(this.this$0).getHardwareInputIdMap().get(info.getDeviceId());     // Catch: Throwable -> L13
            TvInputManagerService.m8788$$Nest$mremoveHardwareInputLocked(this.this$0, relatedInputId, TvInputManagerService.m8755$$Nest$fgetmCurrentUserId(this.this$0));     // Catch: Throwable -> L13
            UserState userState = TvInputManagerService.m8775$$Nest$mgetOrCreateUserStateLocked(this.this$0, TvInputManagerService.m8755$$Nest$fgetmCurrentUserId(this.this$0));     // Catch: Throwable -> L13
            Iterator r3 = UserState.m8869$$Nest$fgetserviceStateMap(userState).values().iterator();     // Catch: Throwable -> L13
        L6:
            if (r3.hasNext() == false) goto L22;
            ServiceState serviceState = (ServiceState) r3.next();     // Catch: Throwable -> L13
            if (ServiceState.m8818$$Nest$fgetisHardware(serviceState) == false) goto L6;
            TvInputManagerService.m8769$$Nest$mbindService(this.this$0, serviceState, TvInputManagerService.m8755$$Nest$fgetmCurrentUserId(this.this$0));     // Catch: Throwable -> L13 RemoteException -> L15
            if (ServiceState.m8821$$Nest$fgetservice(serviceState) == null) goto L17;
            ServiceState.m8821$$Nest$fgetservice(serviceState).notifyHardwareRemoved(info);     // Catch: Throwable -> L13 RemoteException -> L15
            goto L6
        L17:
            ServiceState.m8814$$Nest$fgethardwareDeviceRemovedBuffer(serviceState).add(info);     // Catch: Throwable -> L13 RemoteException -> L15
            goto L6
        L15:
            e = move-exception;
            Slog.e(TvInputManagerService.TAG, "error in notifyHardwareRemoved", e);     // Catch: Throwable -> L13
            goto L6
        L22:
            TvInputManagerService.m8798$$Nest$mupdateHardwareServiceConnectionDelayed(this.this$0, TvInputManagerService.m8755$$Nest$fgetmCurrentUserId(this.this$0));     // Catch: Throwable -> L13
            monitor-exit(r0);     // Catch: Throwable -> L13
            return;
        L13:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.tv.TvInputHardwareManager.Listener
        public void onHdmiDeviceAdded(HdmiDeviceInfo deviceInfo) {
            Object r0 = TvInputManagerService.m8756$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            UserState userState = TvInputManagerService.m8775$$Nest$mgetOrCreateUserStateLocked(this.this$0, TvInputManagerService.m8755$$Nest$fgetmCurrentUserId(this.this$0));     // Catch: Throwable -> L14
            Iterator r2 = UserState.m8869$$Nest$fgetserviceStateMap(userState).values().iterator();     // Catch: Throwable -> L14
        L6:
            if (r2.hasNext() == false) goto L22;
            ServiceState serviceState = (ServiceState) r2.next();     // Catch: Throwable -> L14
            if (ServiceState.m8818$$Nest$fgetisHardware(serviceState) == false) goto L6;
            TvInputManagerService.m8769$$Nest$mbindService(this.this$0, serviceState, TvInputManagerService.m8755$$Nest$fgetmCurrentUserId(this.this$0));     // Catch: Throwable -> L14 RemoteException -> L16
            if (ServiceState.m8821$$Nest$fgetservice(serviceState) == null) goto L6;
            ServiceState.m8821$$Nest$fgetservice(serviceState).notifyHdmiDeviceAdded(deviceInfo);     // Catch: Throwable -> L14 RemoteException -> L16
        L16:
            e = move-exception;
            Slog.e(TvInputManagerService.TAG, "error in notifyHdmiDeviceAdded", e);     // Catch: Throwable -> L14
            goto L6
        L22:
            TvInputManagerService.m8798$$Nest$mupdateHardwareServiceConnectionDelayed(this.this$0, TvInputManagerService.m8755$$Nest$fgetmCurrentUserId(this.this$0));     // Catch: Throwable -> L14
            monitor-exit(r0);     // Catch: Throwable -> L14
            return;
        L14:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.tv.TvInputHardwareManager.Listener
        public void onHdmiDeviceRemoved(HdmiDeviceInfo deviceInfo) {
            Object r0 = TvInputManagerService.m8756$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            String relatedInputId = TvInputManagerService.m8762$$Nest$fgetmTvInputHardwareManager(this.this$0).getHdmiInputIdMap().get(deviceInfo.getId());     // Catch: Throwable -> L13
            TvInputManagerService.m8788$$Nest$mremoveHardwareInputLocked(this.this$0, relatedInputId, TvInputManagerService.m8755$$Nest$fgetmCurrentUserId(this.this$0));     // Catch: Throwable -> L13
            UserState userState = TvInputManagerService.m8775$$Nest$mgetOrCreateUserStateLocked(this.this$0, TvInputManagerService.m8755$$Nest$fgetmCurrentUserId(this.this$0));     // Catch: Throwable -> L13
            Iterator r3 = UserState.m8869$$Nest$fgetserviceStateMap(userState).values().iterator();     // Catch: Throwable -> L13
        L6:
            if (r3.hasNext() == false) goto L22;
            ServiceState serviceState = (ServiceState) r3.next();     // Catch: Throwable -> L13
            if (ServiceState.m8818$$Nest$fgetisHardware(serviceState) == false) goto L6;
            TvInputManagerService.m8769$$Nest$mbindService(this.this$0, serviceState, TvInputManagerService.m8755$$Nest$fgetmCurrentUserId(this.this$0));     // Catch: Throwable -> L13 RemoteException -> L15
            if (ServiceState.m8821$$Nest$fgetservice(serviceState) == null) goto L17;
            ServiceState.m8821$$Nest$fgetservice(serviceState).notifyHdmiDeviceRemoved(deviceInfo);     // Catch: Throwable -> L13 RemoteException -> L15
            goto L6
        L17:
            ServiceState.m8816$$Nest$fgethdmiDeviceRemovedBuffer(serviceState).add(deviceInfo);     // Catch: Throwable -> L13 RemoteException -> L15
            goto L6
        L15:
            e = move-exception;
            Slog.e(TvInputManagerService.TAG, "error in notifyHdmiDeviceRemoved", e);     // Catch: Throwable -> L13
            goto L6
        L22:
            TvInputManagerService.m8798$$Nest$mupdateHardwareServiceConnectionDelayed(this.this$0, TvInputManagerService.m8755$$Nest$fgetmCurrentUserId(this.this$0));     // Catch: Throwable -> L13
            monitor-exit(r0);     // Catch: Throwable -> L13
            return;
        L13:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.tv.TvInputHardwareManager.Listener
        public void onHdmiDeviceUpdated(String inputId, HdmiDeviceInfo deviceInfo) {
            Object r0 = TvInputManagerService.m8756$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L8:
            th = move-exception;
            throw th;
        L5:
            switch(deviceInfo.getDevicePowerStatus()) {
                case 0: goto L10;
                case 1: goto L7;
                case 2: goto L7;
                case 3: goto L7;
                default: goto L6;
            };     // Catch: Throwable -> L8
        L6:
            Integer state = null;
        L11:
            if (state == null) goto L13;
            TvInputManagerService.m8794$$Nest$msetStateLocked(this.this$0, inputId, state.intValue(), TvInputManagerService.m8755$$Nest$fgetmCurrentUserId(this.this$0));     // Catch: Throwable -> L8
        L13:
            UserState userState = TvInputManagerService.m8775$$Nest$mgetOrCreateUserStateLocked(this.this$0, TvInputManagerService.m8755$$Nest$fgetmCurrentUserId(this.this$0));     // Catch: Throwable -> L8
            Iterator r3 = UserState.m8869$$Nest$fgetserviceStateMap(userState).values().iterator();     // Catch: Throwable -> L8
        L15:
            if (r3.hasNext() == false) goto L29;
            ServiceState serviceState = (ServiceState) r3.next();     // Catch: Throwable -> L8
            if (ServiceState.m8818$$Nest$fgetisHardware(serviceState) == false) goto L15;
            TvInputManagerService.m8769$$Nest$mbindService(this.this$0, serviceState, TvInputManagerService.m8755$$Nest$fgetmCurrentUserId(this.this$0));     // Catch: Throwable -> L8 RemoteException -> L22
            if (ServiceState.m8821$$Nest$fgetservice(serviceState) == null) goto L24;
            ServiceState.m8821$$Nest$fgetservice(serviceState).notifyHdmiDeviceUpdated(deviceInfo);     // Catch: Throwable -> L8 RemoteException -> L22
            goto L15
        L24:
            ServiceState.m8817$$Nest$fgethdmiDeviceUpdatedBuffer(serviceState).add(deviceInfo);     // Catch: Throwable -> L8 RemoteException -> L22
            goto L15
        L22:
            e = move-exception;
            Slog.e(TvInputManagerService.TAG, "error in notifyHdmiDeviceUpdated", e);     // Catch: Throwable -> L8
            goto L15
        L29:
            TvInputManagerService.m8798$$Nest$mupdateHardwareServiceConnectionDelayed(this.this$0, TvInputManagerService.m8755$$Nest$fgetmCurrentUserId(this.this$0));     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L7:
            state = 1;     // Catch: Throwable -> L8
            goto L11
        L10:
            state = 0;     // Catch: Throwable -> L8
            goto L11
        }

        @Override // com.android.server.tv.TvInputHardwareManager.Listener
        public void onTvMessage(String inputId, int type, Bundle data) {
            Object r0 = TvInputManagerService.m8756$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            UserState userState = TvInputManagerService.m8775$$Nest$mgetOrCreateUserStateLocked(this.this$0, TvInputManagerService.m8755$$Nest$fgetmCurrentUserId(this.this$0));     // Catch: Throwable -> L9
            TvInputState inputState = (TvInputState) UserState.m8862$$Nest$fgetinputMap(userState).get(inputId);     // Catch: Throwable -> L9
            if (inputState != null) goto L11;
            Slog.e(TvInputManagerService.TAG, "failed to send TV message - unknown input id " + inputId);     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L11:
            ServiceState serviceState = (ServiceState) UserState.m8869$$Nest$fgetserviceStateMap(userState).get(TvInputState.m8851$$Nest$fgetinfo(inputState).getComponent());     // Catch: Throwable -> L9
            Iterator r4 = ServiceState.m8822$$Nest$fgetsessionTokens(serviceState).iterator();     // Catch: Throwable -> L9
        L13:
            if (r4.hasNext() == false) goto L27;
            IBinder token = (IBinder) r4.next();     // Catch: Throwable -> L9
            SessionState sessionState = TvInputManagerService.m8780$$Nest$mgetSessionStateLocked(this.this$0, token, Binder.getCallingUid(), TvInputManagerService.m8755$$Nest$fgetmCurrentUserId(this.this$0));     // Catch: Throwable -> L9 RemoteException -> L21
            if (SessionState.m8837$$Nest$fgetisRecordingSession(sessionState) == true) goto L13;
            if (SessionState.m8833$$Nest$fgethardwareSessionToken(sessionState) == null) goto L13;
            SessionState.m8840$$Nest$fgetsession(sessionState).notifyTvMessage(type, data);     // Catch: Throwable -> L9 RemoteException -> L21
        L21:
            e = move-exception;
            Slog.e(TvInputManagerService.TAG, "error in onTvMessage", e);     // Catch: Throwable -> L9
            goto L13
        L27:
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L9:
            th = move-exception;
            throw th;
        }
    }

    private final class InputServiceConnection implements ServiceConnection {
        private final ComponentName mComponent;
        private final int mUserId;
        final /* synthetic */ TvInputManagerService this$0;

        /* synthetic */ InputServiceConnection(TvInputManagerService r1, ComponentName r2, int r3, TvInputManagerServiceIA r4) {
            this(r1, r2, r3);
        }

        private InputServiceConnection(TvInputManagerService r1, ComponentName component, int userId) {
            this.this$0 = r1;
            this.mComponent = component;
            this.mUserId = userId;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName component, IBinder service) {
            Object r0 = TvInputManagerService.m8756$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            UserState userState = TvInputManagerService.m8782$$Nest$mgetUserStateLocked(this.this$0, this.mUserId);     // Catch: Throwable -> L9
            if (userState != null) goto L11;
            TvInputManagerService.m8754$$Nest$fgetmContext(this.this$0).unbindService(this);     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L11:
            ServiceState serviceState = (ServiceState) UserState.m8869$$Nest$fgetserviceStateMap(userState).get(this.mComponent);     // Catch: Throwable -> L9
            ServiceState.m8827$$Nest$fputservice(serviceState, ITvInputService.Stub.asInterface(service));     // Catch: Throwable -> L9
            ServiceState.m8825$$Nest$fputneedInit(serviceState, false);     // Catch: Throwable -> L9
            if (ServiceState.m8818$$Nest$fgetisHardware(serviceState) == true) goto L14;
        L20:
            Iterator r3 = UserState.m8862$$Nest$fgetinputMap(userState).values().iterator();     // Catch: Throwable -> L9
        L22:
            if (r3.hasNext() == false) goto L30;
            TvInputState inputState = (TvInputState) r3.next();     // Catch: Throwable -> L9
            if (TvInputState.m8851$$Nest$fgetinfo(inputState).getComponent().equals(component) == false) goto L22;
            if (TvInputState.m8853$$Nest$fgetstate(inputState) == 0) goto L22;
            TvInputManagerService.m8786$$Nest$mnotifyInputStateChangedLocked(this.this$0, userState, TvInputState.m8851$$Nest$fgetinfo(inputState).getId(), TvInputState.m8853$$Nest$fgetstate(inputState), null);     // Catch: Throwable -> L9
            goto L22
        L30:
            if (ServiceState.m8818$$Nest$fgetisHardware(serviceState) == false) goto L77;
            Iterator r4 = ServiceState.m8814$$Nest$fgethardwareDeviceRemovedBuffer(serviceState).iterator();     // Catch: Throwable -> L9
        L33:
            if (r4.hasNext() == false) goto L40;
            TvInputHardwareInfo hardwareToBeRemoved = (TvInputHardwareInfo) r4.next();     // Catch: Throwable -> L9
            ServiceState.m8821$$Nest$fgetservice(serviceState).notifyHardwareRemoved(hardwareToBeRemoved);     // Catch: Throwable -> L9 RemoteException -> L37
        L37:
            e = move-exception;
            Slog.e(TvInputManagerService.TAG, "error in hardwareDeviceRemovedBuffer", e);     // Catch: Throwable -> L9
            goto L33
        L40:
            ServiceState.m8814$$Nest$fgethardwareDeviceRemovedBuffer(serviceState).clear();     // Catch: Throwable -> L9
            Iterator r5 = ServiceState.m8816$$Nest$fgethdmiDeviceRemovedBuffer(serviceState).iterator();     // Catch: Throwable -> L9
        L42:
            if (r5.hasNext() == false) goto L49;
            HdmiDeviceInfo hdmiDeviceToBeRemoved = (HdmiDeviceInfo) r5.next();     // Catch: Throwable -> L9
            ServiceState.m8821$$Nest$fgetservice(serviceState).notifyHdmiDeviceRemoved(hdmiDeviceToBeRemoved);     // Catch: Throwable -> L9 RemoteException -> L46
        L46:
            e = move-exception;
            Slog.e(TvInputManagerService.TAG, "error in hdmiDeviceRemovedBuffer", e);     // Catch: Throwable -> L9
            goto L42
        L49:
            ServiceState.m8816$$Nest$fgethdmiDeviceRemovedBuffer(serviceState).clear();     // Catch: Throwable -> L9
            Iterator<TvInputHardwareInfo> r6 = TvInputManagerService.m8762$$Nest$fgetmTvInputHardwareManager(this.this$0).getHardwareList().iterator();     // Catch: Throwable -> L9
        L51:
            if (r6.hasNext() == false) goto L58;
            TvInputHardwareInfo hardware = r6.next();     // Catch: Throwable -> L9
            ServiceState.m8821$$Nest$fgetservice(serviceState).notifyHardwareAdded(hardware);     // Catch: Throwable -> L9 RemoteException -> L55
        L55:
            e = move-exception;
            Slog.e(TvInputManagerService.TAG, "error in notifyHardwareAdded", e);     // Catch: Throwable -> L9
            goto L51
        L58:
            Iterator<HdmiDeviceInfo> r7 = TvInputManagerService.m8762$$Nest$fgetmTvInputHardwareManager(this.this$0).getHdmiDeviceList().iterator();     // Catch: Throwable -> L9
        L60:
            if (r7.hasNext() == false) goto L67;
            HdmiDeviceInfo device = r7.next();     // Catch: Throwable -> L9
            ServiceState.m8821$$Nest$fgetservice(serviceState).notifyHdmiDeviceAdded(device);     // Catch: Throwable -> L9 RemoteException -> L64
        L64:
            e = move-exception;
            Slog.e(TvInputManagerService.TAG, "error in notifyHdmiDeviceAdded", e);     // Catch: Throwable -> L9
            goto L60
        L67:
            Iterator r8 = ServiceState.m8817$$Nest$fgethdmiDeviceUpdatedBuffer(serviceState).iterator();     // Catch: Throwable -> L9
        L69:
            if (r8.hasNext() == false) goto L76;
            HdmiDeviceInfo hdmiDeviceToBeUpdated = (HdmiDeviceInfo) r8.next();     // Catch: Throwable -> L9
            ServiceState.m8821$$Nest$fgetservice(serviceState).notifyHdmiDeviceUpdated(hdmiDeviceToBeUpdated);     // Catch: Throwable -> L9 RemoteException -> L73
        L73:
            e = move-exception;
            Slog.e(TvInputManagerService.TAG, "error in hdmiDeviceUpdatedBuffer", e);     // Catch: Throwable -> L9
            goto L69
        L76:
            ServiceState.m8817$$Nest$fgethdmiDeviceUpdatedBuffer(serviceState).clear();     // Catch: Throwable -> L9
        L77:
            List<IBinder> tokensToBeRemoved = new ArrayList();     // Catch: Throwable -> L9
            Iterator r9 = ServiceState.m8822$$Nest$fgetsessionTokens(serviceState).iterator();     // Catch: Throwable -> L9
        L79:
            if (r9.hasNext() == false) goto L84;
            IBinder sessionToken = (IBinder) r9.next();     // Catch: Throwable -> L9
            if (TvInputManagerService.m8773$$Nest$mcreateSessionInternalLocked(this.this$0, ServiceState.m8821$$Nest$fgetservice(serviceState), sessionToken, this.mUserId) == true) goto L79;
            tokensToBeRemoved.add(sessionToken);     // Catch: Throwable -> L9
            goto L79
        L84:
            Iterator<IBinder> r10 = tokensToBeRemoved.iterator();     // Catch: Throwable -> L9
        L86:
            if (r10.hasNext() == false) goto L89;
            IBinder sessionToken2 = r10.next();     // Catch: Throwable -> L9
            TvInputManagerService.m8789$$Nest$mremoveSessionStateLocked(this.this$0, sessionToken2, this.mUserId);     // Catch: Throwable -> L9
            goto L86
        L89:
            if (ServiceState.m8818$$Nest$fgetisHardware(serviceState) == false) goto L91;
            TvInputManagerService.m8798$$Nest$mupdateHardwareServiceConnectionDelayed(this.this$0, this.mUserId);     // Catch: Throwable -> L9
        L91:
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L14:
            if (ServiceState.m8811$$Nest$fgetcallback(serviceState) != null) goto L20;
            ServiceState.m8824$$Nest$fputcallback(serviceState, new ServiceCallback(this.this$0, this.mComponent, this.mUserId));     // Catch: Throwable -> L9
            ServiceState.m8821$$Nest$fgetservice(serviceState).registerCallback(ServiceState.m8811$$Nest$fgetcallback(serviceState));     // Catch: Throwable -> L9 RemoteException -> L18
        L18:
            e = move-exception;
            Slog.e(TvInputManagerService.TAG, "error in registerCallback", e);     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            throw th;
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName component) {
            if (this.mComponent.equals(component) == false) goto L16;
            Object r0 = TvInputManagerService.m8756$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            UserState userState = TvInputManagerService.m8775$$Nest$mgetOrCreateUserStateLocked(this.this$0, this.mUserId);     // Catch: Throwable -> L9
            ServiceState serviceState = (ServiceState) UserState.m8869$$Nest$fgetserviceStateMap(userState).get(this.mComponent);     // Catch: Throwable -> L9
            if (serviceState == null) goto L11;
            ServiceState.m8826$$Nest$fputreconnecting(serviceState, true);     // Catch: Throwable -> L9
            ServiceState.m8823$$Nest$fputbound(serviceState, false);     // Catch: Throwable -> L9
            ServiceState.m8827$$Nest$fputservice(serviceState, null);     // Catch: Throwable -> L9
            ServiceState.m8824$$Nest$fputcallback(serviceState, null);     // Catch: Throwable -> L9
            TvInputManagerService.m8766$$Nest$mabortPendingCreateSessionRequestsLocked(this.this$0, serviceState, null, this.mUserId);     // Catch: Throwable -> L9
        L11:
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L9:
            th = move-exception;
            throw th;
        L16:
            throw new IllegalArgumentException("Mismatched ComponentName: " + this.mComponent + " (expected), " + component + " (actual).");
        }
    }

    private final class MessageHandler extends Handler {
        static final int MSG_CHECK_TV_AS_ACTIVE_SOURCE = 5;
        static final int MSG_LOG_WATCH_END = 2;
        static final int MSG_LOG_WATCH_START = 1;
        static final int MSG_SWITCH_CONTENT_RESOLVER = 3;
        static final int MSG_UPDATE_HARDWARE_TIS_BINDING = 4;
        private ContentResolver mContentResolver;
        final /* synthetic */ TvInputManagerService this$0;

        MessageHandler(TvInputManagerService r1, ContentResolver contentResolver, Looper looper) {
            this.this$0 = r1;
            super(looper);
            this.mContentResolver = contentResolver;
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            switch(msg.what) {
                case 1: goto L41;
                case 2: goto L35;
                case 3: goto L34;
                case 4: goto L26;
                case 5: goto L5;
                default: goto L4;
            };
        L4:
            Slog.w(TvInputManagerService.TAG, "Unhandled message code: " + msg.what);
            return;
        L5:
            Object r0 = TvInputManagerService.m8756$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L12:
            th = move-exception;
            throw th;
        L8:
            if (TvInputManagerService.m8758$$Nest$fgetmOnScreenInputId(this.this$0) != null) goto L14;
            TvInputManagerService.m8768$$Nest$massertTvAsCecActiveSourceLocked(this.this$0);     // Catch: Throwable -> L12
            monitor-exit(r0);     // Catch: Throwable -> L12
            return;
        L14:
            UserState userState = TvInputManagerService.m8775$$Nest$mgetOrCreateUserStateLocked(this.this$0, TvInputManagerService.m8755$$Nest$fgetmCurrentUserId(this.this$0));     // Catch: Throwable -> L12
            TvInputState inputState = (TvInputState) UserState.m8862$$Nest$fgetinputMap(userState).get(TvInputManagerService.m8758$$Nest$fgetmOnScreenInputId(this.this$0));     // Catch: Throwable -> L12
            if (inputState != null) goto L20;
            Slog.w(TvInputManagerService.TAG, "Unexpected null TvInputState.");     // Catch: Throwable -> L12
            monitor-exit(r0);     // Catch: Throwable -> L12
            return;
        L20:
            if (TvInputState.m8851$$Nest$fgetinfo(inputState).getType() == 1007) goto L22;
            TvInputManagerService.m8768$$Nest$massertTvAsCecActiveSourceLocked(this.this$0);     // Catch: Throwable -> L12
        L22:
            monitor-exit(r0);     // Catch: Throwable -> L12
            return;
        L26:
            SomeArgs args = (SomeArgs) msg.obj;
            int userId = ((Integer) args.arg1).intValue();
            Object r2 = TvInputManagerService.m8756$$Nest$fgetmLock(this.this$0);
            monitor-enter(r2);
            TvInputManagerService.m8799$$Nest$mupdateHardwareTvInputServiceBindingLocked(this.this$0, userId);     // Catch: Throwable -> L31
            monitor-exit(r2);     // Catch: Throwable -> L31
            args.recycle();
            return;
        L31:
            th = move-exception;
            throw th;
        L34:
            this.mContentResolver = (ContentResolver) msg.obj;
            return;
        L35:
            SomeArgs args2 = (SomeArgs) msg.obj;
            IBinder sessionToken = (IBinder) args2.arg1;
            long watchEndTime = ((Long) args2.arg2).longValue();
            ContentValues values = new ContentValues();
            values.put("watch_end_time_utc_millis", Long.valueOf(watchEndTime));
            values.put("session_token", sessionToken.toString());
            this.mContentResolver.insert(TvContract.WatchedPrograms.CONTENT_URI, values);     // Catch: IllegalArgumentException -> L38
        L40:
            args2.recycle();
            return;
        L38:
            ex = move-exception;
            Slog.w(TvInputManagerService.TAG, "error in insert db for MSG_LOG_WATCH_END", ex);
            goto L40
        L41:
            SomeArgs args3 = (SomeArgs) msg.obj;
            String packageName = (String) args3.arg1;
            long watchStartTime = ((Long) args3.arg2).longValue();
            long channelId = ((Long) args3.arg3).longValue();
            Bundle tuneParams = (Bundle) args3.arg4;
            IBinder sessionToken2 = (IBinder) args3.arg5;
            ContentValues values2 = new ContentValues();
            values2.put("package_name", packageName);
            values2.put("watch_start_time_utc_millis", Long.valueOf(watchStartTime));
            values2.put("channel_id", Long.valueOf(channelId));
            if (tuneParams == null) goto L44;
            values2.put("tune_params", encodeTuneParams(tuneParams));
        L44:
            values2.put("session_token", sessionToken2.toString());
            this.mContentResolver.insert(TvContract.WatchedPrograms.CONTENT_URI, values2);     // Catch: IllegalArgumentException -> L47
        L49:
            args3.recycle();
            return;
        L47:
            ex = move-exception;
            Slog.w(TvInputManagerService.TAG, "error in insert db for MSG_LOG_WATCH_START", ex);
            goto L49
        }

        private String encodeTuneParams(Bundle tuneParams) {
            StringBuilder builder = new StringBuilder();
            Set<String> keySet = tuneParams.keySet();
            Iterator<String> it = keySet.iterator();
        L4:
            if (it.hasNext() == false) goto L13;
            String key = it.next();
            Object value = tuneParams.get(key);
            if (value == null) goto L4;
            builder.append(replaceEscapeCharacters(key));
            builder.append("=");
            builder.append(replaceEscapeCharacters(value.toString()));
            if (it.hasNext() == false) goto L4;
            builder.append(", ");
            goto L4
        L13:
            return builder.toString();
        }

        private String replaceEscapeCharacters(String src) {
            StringBuilder builder = new StringBuilder();
            char[] r3 = src.toCharArray();
            int r4 = r3.length;
            int r5 = 0;
        L3:
            if (r5 >= r4) goto L9;
            char ch = r3[r5];
            if ("%=,".indexOf(ch) < 0) goto L7;
            builder.append('%');
        L7:
            builder.append(ch);
            r5 = r5 + 1;
            goto L3
        L9:
            return builder.toString();
        }
    }

    private class MyPackageMonitor extends PackageMonitor {
        final /* synthetic */ TvInputManagerService this$0;

        MyPackageMonitor(TvInputManagerService r1, boolean supportsPackageRestartQuery) {
            this.this$0 = r1;
            super(supportsPackageRestartQuery);
        }

        private void buildTvInputList(String[] packages) {
            int userId = getChangingUserId();
            Object r1 = TvInputManagerService.m8756$$Nest$fgetmLock(this.this$0);
            monitor-enter(r1);
        L9:
            th = move-exception;
            throw th;
        L5:
            if (TvInputManagerService.m8755$$Nest$fgetmCurrentUserId(this.this$0) == userId) goto L11;
            if (TvInputManagerService.m8760$$Nest$fgetmRunningProfiles(this.this$0).contains(Integer.valueOf(userId)) == true) goto L11;
        L12:
            monitor-exit(r1);     // Catch: Throwable -> L9
            return;
        L11:
            TvInputManagerService.m8771$$Nest$mbuildTvInputListLocked(this.this$0, userId, packages);     // Catch: Throwable -> L9
            TvInputManagerService.m8770$$Nest$mbuildTvContentRatingSystemListLocked(this.this$0, userId);     // Catch: Throwable -> L9
            goto L12
        }

        public void onPackageUpdateFinished(String packageName, int uid) {
            buildTvInputList(new String[]{packageName});
        }

        public void onPackagesAvailable(String[] packages) {
            if (isReplacing() == false) goto L6;
            buildTvInputList(packages);
            return;
        }

        public void onPackagesUnavailable(String[] packages) {
            if (isReplacing() == false) goto L6;
            buildTvInputList(packages);
            return;
        }

        public void onSomePackagesChanged() {
            if (isReplacing() == false) goto L5;
            return;
        L5:
            buildTvInputList(null);
        }

        public boolean onPackageChanged(String packageName, int uid, String[] components) {
            return true;
        }
    }

    private final class ServiceCallback extends ITvInputServiceCallback.Stub {
        private final ComponentName mComponent;
        private final int mUserId;
        final /* synthetic */ TvInputManagerService this$0;

        ServiceCallback(TvInputManagerService r1, ComponentName component, int userId) {
            this.this$0 = r1;
            this.mComponent = component;
            this.mUserId = userId;
        }

        private void ensureHardwarePermission() {
            if (TvInputManagerService.m8754$$Nest$fgetmContext(this.this$0).checkCallingPermission("android.permission.TV_INPUT_HARDWARE") != 0) goto L6;
            return;
        L6:
            throw new SecurityException("The caller does not have hardware permission");
        }

        private void ensureValidInput(TvInputInfo inputInfo) {
            if (inputInfo.getId() == null) goto L8;
            if (this.mComponent.equals(inputInfo.getComponent()) == false) goto L8;
            return;
        L8:
            throw new IllegalArgumentException("Invalid TvInputInfo");
        }

        public void addHardwareInput(int deviceId, TvInputInfo inputInfo) {
            ensureHardwarePermission();
            ensureValidInput(inputInfo);
            long identity = Binder.clearCallingIdentity();
            Object r2 = TvInputManagerService.m8756$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L18
            monitor-enter(r2);     // Catch: Throwable -> L18
            ServiceState serviceState = TvInputManagerService.m8776$$Nest$mgetServiceStateLocked(this.this$0, this.mComponent, this.mUserId);     // Catch: Throwable -> L10
            if (ServiceState.m8815$$Nest$fgethardwareInputMap(serviceState).containsKey(inputInfo.getId()) == false) goto L12;
            monitor-exit(r2);     // Catch: Throwable -> L10
            Binder.restoreCallingIdentity(identity);
            return;
        L12:
            Slog.d(TvInputManagerService.TAG, "ServiceCallback: addHardwareInput, deviceId: " + deviceId + ", inputInfo: " + inputInfo.toString() + " by " + this.mComponent + ", userId: " + this.mUserId);     // Catch: Throwable -> L10
            TvInputManagerService.m8762$$Nest$fgetmTvInputHardwareManager(this.this$0).addHardwareInput(deviceId, inputInfo);     // Catch: Throwable -> L10
            TvInputManagerService.m8767$$Nest$maddHardwareInputLocked(this.this$0, inputInfo, this.mComponent, this.mUserId);     // Catch: Throwable -> L10
            monitor-exit(r2);     // Catch: Throwable -> L10
            Binder.restoreCallingIdentity(identity);
            return;
        L10:
            th = move-exception;
            throw th;     // Catch: Throwable -> L18
        L18:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void addHdmiInput(int id, TvInputInfo inputInfo) {
            ensureHardwarePermission();
            ensureValidInput(inputInfo);
            long identity = Binder.clearCallingIdentity();
            Object r2 = TvInputManagerService.m8756$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L27
            monitor-enter(r2);     // Catch: Throwable -> L27
            ServiceState serviceState = TvInputManagerService.m8776$$Nest$mgetServiceStateLocked(this.this$0, this.mComponent, this.mUserId);     // Catch: Throwable -> L10
            if (ServiceState.m8815$$Nest$fgethardwareInputMap(serviceState).containsKey(inputInfo.getId()) == false) goto L12;
            monitor-exit(r2);     // Catch: Throwable -> L10
            Binder.restoreCallingIdentity(identity);
            return;
        L12:
            Slog.d(TvInputManagerService.TAG, "ServiceCallback: addHdmiInput, id: " + id + ", inputInfo: " + inputInfo.toString() + " by " + this.mComponent + ", userId: " + this.mUserId);     // Catch: Throwable -> L10
            TvInputManagerService.m8762$$Nest$fgetmTvInputHardwareManager(this.this$0).addHdmiInput(id, inputInfo);     // Catch: Throwable -> L10
            TvInputManagerService.m8767$$Nest$maddHardwareInputLocked(this.this$0, inputInfo, this.mComponent, this.mUserId);     // Catch: Throwable -> L10
            if (TvInputManagerService.m8758$$Nest$fgetmOnScreenInputId(this.this$0) != null) goto L15;
        L22:
            monitor-exit(r2);     // Catch: Throwable -> L10
            Binder.restoreCallingIdentity(identity);
            return;
        L15:
            if (TvInputManagerService.m8759$$Nest$fgetmOnScreenSessionState(this.this$0) == null) goto L22;
            if (TextUtils.equals(TvInputManagerService.m8758$$Nest$fgetmOnScreenInputId(this.this$0), inputInfo.getParentId()) == false) goto L20;
            TvInputManagerService.m8783$$Nest$mlogExternalInputEvent(this.this$0, 1, inputInfo.getId(), TvInputManagerService.m8759$$Nest$fgetmOnScreenSessionState(this.this$0));     // Catch: Throwable -> L10
            TvInputManagerService.m8764$$Nest$fputmOnScreenInputId(this.this$0, inputInfo.getId());     // Catch: Throwable -> L10
            goto L22
        L20:
            if (TextUtils.equals(TvInputManagerService.m8758$$Nest$fgetmOnScreenInputId(this.this$0), inputInfo.getId()) == false) goto L22;
            TvInputManagerService.m8783$$Nest$mlogExternalInputEvent(this.this$0, 4, TvInputManagerService.m8758$$Nest$fgetmOnScreenInputId(this.this$0), TvInputManagerService.m8759$$Nest$fgetmOnScreenSessionState(this.this$0));     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            throw th;     // Catch: Throwable -> L27
        L27:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        public void removeHardwareInput(String inputId) {
            ensureHardwarePermission();
            long identity = Binder.clearCallingIdentity();
            Object r2 = TvInputManagerService.m8756$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L15
            monitor-enter(r2);     // Catch: Throwable -> L15
        L8:
            th = move-exception;
            throw th;     // Catch: Throwable -> L15
        L6:
            if (this.mUserId != TvInputManagerService.m8755$$Nest$fgetmCurrentUserId(this.this$0)) goto L10;
            Slog.d(TvInputManagerService.TAG, "ServiceCallback: removeHardwareInput, inputId: " + inputId + " by " + this.mComponent + ", userId: " + this.mUserId);     // Catch: Throwable -> L8
            TvInputManagerService.m8788$$Nest$mremoveHardwareInputLocked(this.this$0, inputId, this.mUserId);     // Catch: Throwable -> L8
        L10:
            monitor-exit(r2);     // Catch: Throwable -> L8
            Binder.restoreCallingIdentity(identity);
            return;
        L15:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }
    }

    private final class ServiceState {
        private boolean bound;
        private ServiceCallback callback;
        private final ComponentName component;
        private final ServiceConnection connection;
        private final List<TvInputHardwareInfo> hardwareDeviceRemovedBuffer;
        private final Map<String, TvInputInfo> hardwareInputMap;
        private final List<HdmiDeviceInfo> hdmiDeviceRemovedBuffer;
        private final List<HdmiDeviceInfo> hdmiDeviceUpdatedBuffer;
        private final boolean isHardware;
        private boolean needInit;
        private boolean reconnecting;
        private ITvInputService service;
        private final List<IBinder> sessionTokens;

        /* JADX INFO: renamed from: -$$Nest$fgetbound, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m8810$$Nest$fgetbound(ServiceState r0) {
            return r0.bound;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetcallback, reason: not valid java name */
        static /* bridge */ /* synthetic */ ServiceCallback m8811$$Nest$fgetcallback(ServiceState r0) {
            return r0.callback;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetcomponent, reason: not valid java name */
        static /* bridge */ /* synthetic */ ComponentName m8812$$Nest$fgetcomponent(ServiceState r0) {
            return r0.component;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetconnection, reason: not valid java name */
        static /* bridge */ /* synthetic */ ServiceConnection m8813$$Nest$fgetconnection(ServiceState r0) {
            return r0.connection;
        }

        /* JADX INFO: renamed from: -$$Nest$fgethardwareDeviceRemovedBuffer, reason: not valid java name */
        static /* bridge */ /* synthetic */ List m8814$$Nest$fgethardwareDeviceRemovedBuffer(ServiceState r0) {
            return r0.hardwareDeviceRemovedBuffer;
        }

        /* JADX INFO: renamed from: -$$Nest$fgethardwareInputMap, reason: not valid java name */
        static /* bridge */ /* synthetic */ Map m8815$$Nest$fgethardwareInputMap(ServiceState r0) {
            return r0.hardwareInputMap;
        }

        /* JADX INFO: renamed from: -$$Nest$fgethdmiDeviceRemovedBuffer, reason: not valid java name */
        static /* bridge */ /* synthetic */ List m8816$$Nest$fgethdmiDeviceRemovedBuffer(ServiceState r0) {
            return r0.hdmiDeviceRemovedBuffer;
        }

        /* JADX INFO: renamed from: -$$Nest$fgethdmiDeviceUpdatedBuffer, reason: not valid java name */
        static /* bridge */ /* synthetic */ List m8817$$Nest$fgethdmiDeviceUpdatedBuffer(ServiceState r0) {
            return r0.hdmiDeviceUpdatedBuffer;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetisHardware, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m8818$$Nest$fgetisHardware(ServiceState r0) {
            return r0.isHardware;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetneedInit, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m8819$$Nest$fgetneedInit(ServiceState r0) {
            return r0.needInit;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetreconnecting, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m8820$$Nest$fgetreconnecting(ServiceState r0) {
            return r0.reconnecting;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetservice, reason: not valid java name */
        static /* bridge */ /* synthetic */ ITvInputService m8821$$Nest$fgetservice(ServiceState r0) {
            return r0.service;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetsessionTokens, reason: not valid java name */
        static /* bridge */ /* synthetic */ List m8822$$Nest$fgetsessionTokens(ServiceState r0) {
            return r0.sessionTokens;
        }

        /* JADX INFO: renamed from: -$$Nest$fputbound, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m8823$$Nest$fputbound(ServiceState r0, boolean r1) {
            r0.bound = r1;
        }

        /* JADX INFO: renamed from: -$$Nest$fputcallback, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m8824$$Nest$fputcallback(ServiceState r0, ServiceCallback r1) {
            r0.callback = r1;
        }

        /* JADX INFO: renamed from: -$$Nest$fputneedInit, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m8825$$Nest$fputneedInit(ServiceState r0, boolean r1) {
            r0.needInit = r1;
        }

        /* JADX INFO: renamed from: -$$Nest$fputreconnecting, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m8826$$Nest$fputreconnecting(ServiceState r0, boolean r1) {
            r0.reconnecting = r1;
        }

        /* JADX INFO: renamed from: -$$Nest$fputservice, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m8827$$Nest$fputservice(ServiceState r0, ITvInputService r1) {
            r0.service = r1;
        }

        /* synthetic */ ServiceState(TvInputManagerService r1, ComponentName r2, int r3, TvInputManagerServiceIA r4) {
            this(r1, r2, r3);
        }

        private ServiceState(TvInputManagerService r3, ComponentName component, int userId) {
            this.sessionTokens = new ArrayList();
            this.hardwareInputMap = new HashMap();
            this.hardwareDeviceRemovedBuffer = new ArrayList();
            this.hdmiDeviceRemovedBuffer = new ArrayList();
            this.hdmiDeviceUpdatedBuffer = new ArrayList();
            this.component = component;
            this.connection = new InputServiceConnection(r3, component, userId, null);
            this.isHardware = TvInputManagerService.m8806$$Nest$smhasHardwarePermission(TvInputManagerService.m8754$$Nest$fgetmContext(r3).getPackageManager(), component);
            this.needInit = true;
        }
    }

    private final class SessionCallback extends ITvInputSessionCallback.Stub {
        private final InputChannel[] mChannels;
        private final SessionState mSessionState;
        final /* synthetic */ TvInputManagerService this$0;

        SessionCallback(TvInputManagerService r1, SessionState sessionState, InputChannel[] channels) {
            this.this$0 = r1;
            this.mSessionState = sessionState;
            this.mChannels = channels;
        }

        public void onSessionCreated(ITvInputSession session, IBinder hardwareSessionToken) {
            Object r1 = TvInputManagerService.m8756$$Nest$fgetmLock(this.this$0);
            monitor-enter(r1);
            SessionState.m8850$$Nest$fputsession(this.mSessionState, session);     // Catch: Throwable -> L9
            SessionState.m8846$$Nest$fputhardwareSessionToken(this.mSessionState, hardwareSessionToken);     // Catch: Throwable -> L9
            if (session != null) goto L7;
        L11:
            TvInputManagerService.m8789$$Nest$mremoveSessionStateLocked(this.this$0, SessionState.m8842$$Nest$fgetsessionToken(this.mSessionState), SessionState.m8844$$Nest$fgetuserId(this.mSessionState));     // Catch: Throwable -> L9
            TvInputManagerService.m8792$$Nest$msendSessionTokenToClientLocked(this.this$0, SessionState.m8830$$Nest$fgetclient(this.mSessionState), SessionState.m8834$$Nest$fgetinputId(this.mSessionState), null, null, SessionState.m8839$$Nest$fgetseq(this.mSessionState));     // Catch: Throwable -> L9
        L12:
            this.mChannels[0].dispose();     // Catch: Throwable -> L9
            monitor-exit(r1);     // Catch: Throwable -> L9
            return;
        L7:
            if (addSessionTokenToClientStateLocked(session) == false) goto L11;
            TvInputManagerService.m8792$$Nest$msendSessionTokenToClientLocked(this.this$0, SessionState.m8830$$Nest$fgetclient(this.mSessionState), SessionState.m8834$$Nest$fgetinputId(this.mSessionState), SessionState.m8842$$Nest$fgetsessionToken(this.mSessionState), this.mChannels[0], SessionState.m8839$$Nest$fgetseq(this.mSessionState));     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            throw th;
        }

        private boolean addSessionTokenToClientStateLocked(ITvInputSession session) {
            session.asBinder().linkToDeath(this.mSessionState, 0);     // Catch: RemoteException -> L14
            IBinder clientToken = SessionState.m8830$$Nest$fgetclient(this.mSessionState).asBinder();
            UserState userState = TvInputManagerService.m8775$$Nest$mgetOrCreateUserStateLocked(this.this$0, SessionState.m8844$$Nest$fgetuserId(this.mSessionState));
            ClientState clientState = (ClientState) UserState.m8860$$Nest$fgetclientStateMap(userState).get(clientToken);
            if (clientState != null) goto L12;
            clientState = new ClientState(this.this$0, clientToken, SessionState.m8844$$Nest$fgetuserId(this.mSessionState));
            clientToken.linkToDeath(clientState, 0);     // Catch: RemoteException -> L9
            UserState.m8860$$Nest$fgetclientStateMap(userState).put(clientToken, clientState);
        L9:
            e = move-exception;
            Slog.e(TvInputManagerService.TAG, "client process has already died", e);
            return false;
        L12:
            ClientState.m8808$$Nest$fgetsessionTokens(clientState).add(SessionState.m8842$$Nest$fgetsessionToken(this.mSessionState));
            return true;
        L14:
            e = move-exception;
            Slog.e(TvInputManagerService.TAG, "session process has already died", e);
            return false;
        }

        public void onChannelRetuned(Uri channelUri) {
            Object r0 = TvInputManagerService.m8756$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L14:
            th = move-exception;
            throw th;
        L5:
            if (SessionState.m8840$$Nest$fgetsession(this.mSessionState) != null) goto L7;
        L29:
            monitor-exit(r0);     // Catch: Throwable -> L14
            return;
        L7:
            if (SessionState.m8830$$Nest$fgetclient(this.mSessionState) == null) goto L29;
            SessionState.m8830$$Nest$fgetclient(this.mSessionState).onChannelRetuned(channelUri, SessionState.m8839$$Nest$fgetseq(this.mSessionState));     // Catch: Throwable -> L14 RemoteException -> L16
            if (SessionState.m8835$$Nest$fgetisCurrent(this.mSessionState) == true) goto L12;
        L18:
            UserState userState = TvInputManagerService.m8775$$Nest$mgetOrCreateUserStateLocked(this.this$0, SessionState.m8844$$Nest$fgetuserId(this.mSessionState));     // Catch: Throwable -> L14 RemoteException -> L16
            SessionState.m8847$$Nest$fputisCurrent(this.mSessionState, true);     // Catch: Throwable -> L14 RemoteException -> L16
            SessionState.m8845$$Nest$fputcurrentChannel(this.mSessionState, channelUri);     // Catch: Throwable -> L14 RemoteException -> L16
            TvInputManagerService.m8785$$Nest$mnotifyCurrentChannelInfosUpdatedLocked(this.this$0, userState);     // Catch: Throwable -> L14 RemoteException -> L16
            if (SessionState.m8837$$Nest$fgetisRecordingSession(this.mSessionState) == true) goto L27;
            String sessionActualInputId = TvInputManagerService.m8777$$Nest$mgetSessionActualInputId(this.this$0, this.mSessionState);     // Catch: Throwable -> L14 RemoteException -> L16
            if (TextUtils.equals(TvInputManagerService.m8758$$Nest$fgetmOnScreenInputId(this.this$0), sessionActualInputId) == true) goto L23;
            TvInputManagerService.m8783$$Nest$mlogExternalInputEvent(this.this$0, 1, sessionActualInputId, this.mSessionState);     // Catch: Throwable -> L14 RemoteException -> L16
        L23:
            TvInputManagerService.m8764$$Nest$fputmOnScreenInputId(this.this$0, sessionActualInputId);     // Catch: Throwable -> L14 RemoteException -> L16
            TvInputManagerService.m8765$$Nest$fputmOnScreenSessionState(this.this$0, this.mSessionState);     // Catch: Throwable -> L14 RemoteException -> L16
        L27:
            monitor-exit(r0);     // Catch: Throwable -> L14
            return;
        L12:
            if (Objects.equals(SessionState.m8832$$Nest$fgetcurrentChannel(this.mSessionState), channelUri) == true) goto L27;
        L16:
            e = move-exception;
            Slog.e(TvInputManagerService.TAG, "error in onChannelRetuned", e);     // Catch: Throwable -> L14
            goto L27
        }

        public void onAudioPresentationsChanged(List<AudioPresentation> audioPresentations) {
            Object r0 = TvInputManagerService.m8756$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L11:
            th = move-exception;
            throw th;
        L5:
            if (SessionState.m8840$$Nest$fgetsession(this.mSessionState) != null) goto L7;
        L17:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L7:
            if (SessionState.m8830$$Nest$fgetclient(this.mSessionState) == null) goto L17;
            SessionState.m8830$$Nest$fgetclient(this.mSessionState).onAudioPresentationsChanged(audioPresentations, SessionState.m8839$$Nest$fgetseq(this.mSessionState));     // Catch: Throwable -> L11 RemoteException -> L13
        L15:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L13:
            e = move-exception;
            Slog.e(TvInputManagerService.TAG, "error in onAudioPresentationsChanged", e);     // Catch: Throwable -> L11
            goto L15
        }

        public void onAudioPresentationSelected(int presentationId, int programId) {
            Object r0 = TvInputManagerService.m8756$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L11:
            th = move-exception;
            throw th;
        L5:
            if (SessionState.m8840$$Nest$fgetsession(this.mSessionState) != null) goto L7;
        L17:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L7:
            if (SessionState.m8830$$Nest$fgetclient(this.mSessionState) == null) goto L17;
            SessionState.m8830$$Nest$fgetclient(this.mSessionState).onAudioPresentationSelected(presentationId, programId, SessionState.m8839$$Nest$fgetseq(this.mSessionState));     // Catch: Throwable -> L11 RemoteException -> L13
        L15:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L13:
            e = move-exception;
            Slog.e(TvInputManagerService.TAG, "error in onAudioPresentationSelected", e);     // Catch: Throwable -> L11
            goto L15
        }

        public void onTracksChanged(List<TvTrackInfo> tracks) {
            Object r0 = TvInputManagerService.m8756$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L11:
            th = move-exception;
            throw th;
        L5:
            if (SessionState.m8840$$Nest$fgetsession(this.mSessionState) != null) goto L7;
        L17:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L7:
            if (SessionState.m8830$$Nest$fgetclient(this.mSessionState) == null) goto L17;
            SessionState.m8830$$Nest$fgetclient(this.mSessionState).onTracksChanged(tracks, SessionState.m8839$$Nest$fgetseq(this.mSessionState));     // Catch: Throwable -> L11 RemoteException -> L13
        L15:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L13:
            e = move-exception;
            Slog.e(TvInputManagerService.TAG, "error in onTracksChanged", e);     // Catch: Throwable -> L11
            goto L15
        }

        public void onTrackSelected(int type, String trackId) {
            Object r0 = TvInputManagerService.m8756$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L11:
            th = move-exception;
            throw th;
        L5:
            if (SessionState.m8840$$Nest$fgetsession(this.mSessionState) != null) goto L7;
        L17:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L7:
            if (SessionState.m8830$$Nest$fgetclient(this.mSessionState) == null) goto L17;
            SessionState.m8830$$Nest$fgetclient(this.mSessionState).onTrackSelected(type, trackId, SessionState.m8839$$Nest$fgetseq(this.mSessionState));     // Catch: Throwable -> L11 RemoteException -> L13
        L15:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L13:
            e = move-exception;
            Slog.e(TvInputManagerService.TAG, "error in onTrackSelected", e);     // Catch: Throwable -> L11
            goto L15
        }

        public void onVideoAvailable() {
            Object r0 = TvInputManagerService.m8756$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L12:
            th = move-exception;
            throw th;
        L5:
            if (SessionState.m8840$$Nest$fgetsession(this.mSessionState) == null) goto L18;
            if (SessionState.m8830$$Nest$fgetclient(this.mSessionState) == null) goto L18;
            TvInputState tvInputState = TvInputManagerService.m8805$$Nest$smgetTvInputState(this.mSessionState, TvInputManagerService.m8782$$Nest$mgetUserStateLocked(this.this$0, TvInputManagerService.m8755$$Nest$fgetmCurrentUserId(this.this$0)));     // Catch: Throwable -> L12
            SessionState.m8830$$Nest$fgetclient(this.mSessionState).onVideoAvailable(SessionState.m8839$$Nest$fgetseq(this.mSessionState));     // Catch: Throwable -> L12 RemoteException -> L14
            TvInputManagerService.m8784$$Nest$mlogTuneStateChanged(this.this$0, 6, this.mSessionState, tvInputState);     // Catch: Throwable -> L12 RemoteException -> L14
        L16:
            monitor-exit(r0);     // Catch: Throwable -> L12
            return;
        L14:
            e = move-exception;
            Slog.e(TvInputManagerService.TAG, "error in onVideoAvailable", e);     // Catch: Throwable -> L12
        L18:
            monitor-exit(r0);     // Catch: Throwable -> L12
        }

        public void onVideoUnavailable(int reason) {
            Object r0 = TvInputManagerService.m8756$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L12:
            th = move-exception;
            throw th;
        L5:
            if (SessionState.m8840$$Nest$fgetsession(this.mSessionState) == null) goto L18;
            if (SessionState.m8830$$Nest$fgetclient(this.mSessionState) == null) goto L18;
            TvInputState tvInputState = TvInputManagerService.m8805$$Nest$smgetTvInputState(this.mSessionState, TvInputManagerService.m8782$$Nest$mgetUserStateLocked(this.this$0, TvInputManagerService.m8755$$Nest$fgetmCurrentUserId(this.this$0)));     // Catch: Throwable -> L12
            SessionState.m8830$$Nest$fgetclient(this.mSessionState).onVideoUnavailable(reason, SessionState.m8839$$Nest$fgetseq(this.mSessionState));     // Catch: Throwable -> L12 RemoteException -> L14
            int loggedReason = TvInputManagerService.getVideoUnavailableReasonForStatsd(reason);     // Catch: Throwable -> L12 RemoteException -> L14
            TvInputManagerService.m8784$$Nest$mlogTuneStateChanged(this.this$0, loggedReason, this.mSessionState, tvInputState);     // Catch: Throwable -> L12 RemoteException -> L14
        L16:
            monitor-exit(r0);     // Catch: Throwable -> L12
            return;
        L14:
            e = move-exception;
            Slog.e(TvInputManagerService.TAG, "error in onVideoUnavailable", e);     // Catch: Throwable -> L12
        L18:
            monitor-exit(r0);     // Catch: Throwable -> L12
        }

        public void onVideoFreezeUpdated(boolean isFrozen) {
            Object r0 = TvInputManagerService.m8756$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L11:
            th = move-exception;
            throw th;
        L5:
            if (SessionState.m8840$$Nest$fgetsession(this.mSessionState) != null) goto L7;
        L17:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L7:
            if (SessionState.m8830$$Nest$fgetclient(this.mSessionState) == null) goto L17;
            SessionState.m8830$$Nest$fgetclient(this.mSessionState).onVideoFreezeUpdated(isFrozen, SessionState.m8839$$Nest$fgetseq(this.mSessionState));     // Catch: Throwable -> L11 RemoteException -> L13
        L15:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L13:
            e = move-exception;
            Slog.e(TvInputManagerService.TAG, "error in onVideoFreezeUpdated", e);     // Catch: Throwable -> L11
            goto L15
        }

        public void onContentAllowed() {
            Object r0 = TvInputManagerService.m8756$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L11:
            th = move-exception;
            throw th;
        L5:
            if (SessionState.m8840$$Nest$fgetsession(this.mSessionState) != null) goto L7;
        L17:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L7:
            if (SessionState.m8830$$Nest$fgetclient(this.mSessionState) == null) goto L17;
            SessionState.m8830$$Nest$fgetclient(this.mSessionState).onContentAllowed(SessionState.m8839$$Nest$fgetseq(this.mSessionState));     // Catch: Throwable -> L11 RemoteException -> L13
        L15:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L13:
            e = move-exception;
            Slog.e(TvInputManagerService.TAG, "error in onContentAllowed", e);     // Catch: Throwable -> L11
            goto L15
        }

        public void onContentBlocked(String rating) {
            Object r0 = TvInputManagerService.m8756$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L11:
            th = move-exception;
            throw th;
        L5:
            if (SessionState.m8840$$Nest$fgetsession(this.mSessionState) != null) goto L7;
        L17:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L7:
            if (SessionState.m8830$$Nest$fgetclient(this.mSessionState) == null) goto L17;
            SessionState.m8830$$Nest$fgetclient(this.mSessionState).onContentBlocked(rating, SessionState.m8839$$Nest$fgetseq(this.mSessionState));     // Catch: Throwable -> L11 RemoteException -> L13
        L15:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L13:
            e = move-exception;
            Slog.e(TvInputManagerService.TAG, "error in onContentBlocked", e);     // Catch: Throwable -> L11
            goto L15
        }

        public void onLayoutSurface(int left, int top, int right, int bottom) {
            Object r1 = TvInputManagerService.m8756$$Nest$fgetmLock(this.this$0);
            monitor-enter(r1);
        L13:
            th = move-exception;
            Throwable r9 = th;
        L28:
            monitor-exit(r1);     // Catch: Throwable -> L13
            throw r9;
        L17:
            th = move-exception;
            r9 = th;
            goto L28
        L5:
            if (SessionState.m8840$$Nest$fgetsession(this.mSessionState) == null) goto L26;
            if (SessionState.m8830$$Nest$fgetclient(this.mSessionState) == null) goto L26;
        L31:
            SessionState.m8830$$Nest$fgetclient(this.mSessionState).onLayoutSurface(left, top, right, bottom, SessionState.m8839$$Nest$fgetseq(this.mSessionState));     // Catch: Throwable -> L13 RemoteException -> L15
        L23:
            monitor-exit(r1);     // Catch: Throwable -> L13
            return;
        L15:
            e = move-exception;
            RemoteException e = e;
        L22:
            Slog.e(TvInputManagerService.TAG, "error in onLayoutSurface", e);     // Catch: Throwable -> L13
        L19:
            e = move-exception;
            e = e;
        L26:
            monitor-exit(r1);     // Catch: Throwable -> L13
        }

        public void onSessionEvent(String eventType, Bundle eventArgs) {
            Object r0 = TvInputManagerService.m8756$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L11:
            th = move-exception;
            throw th;
        L5:
            if (SessionState.m8840$$Nest$fgetsession(this.mSessionState) != null) goto L7;
        L17:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L7:
            if (SessionState.m8830$$Nest$fgetclient(this.mSessionState) == null) goto L17;
            SessionState.m8830$$Nest$fgetclient(this.mSessionState).onSessionEvent(eventType, eventArgs, SessionState.m8839$$Nest$fgetseq(this.mSessionState));     // Catch: Throwable -> L11 RemoteException -> L13
        L15:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L13:
            e = move-exception;
            Slog.e(TvInputManagerService.TAG, "error in onSessionEvent", e);     // Catch: Throwable -> L11
            goto L15
        }

        public void onTimeShiftStatusChanged(int status) {
            Object r0 = TvInputManagerService.m8756$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L11:
            th = move-exception;
            throw th;
        L5:
            if (SessionState.m8840$$Nest$fgetsession(this.mSessionState) != null) goto L7;
        L17:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L7:
            if (SessionState.m8830$$Nest$fgetclient(this.mSessionState) == null) goto L17;
            SessionState.m8830$$Nest$fgetclient(this.mSessionState).onTimeShiftStatusChanged(status, SessionState.m8839$$Nest$fgetseq(this.mSessionState));     // Catch: Throwable -> L11 RemoteException -> L13
        L15:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L13:
            e = move-exception;
            Slog.e(TvInputManagerService.TAG, "error in onTimeShiftStatusChanged", e);     // Catch: Throwable -> L11
            goto L15
        }

        public void onTimeShiftStartPositionChanged(long timeMs) {
            Object r0 = TvInputManagerService.m8756$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L11:
            th = move-exception;
            throw th;
        L5:
            if (SessionState.m8840$$Nest$fgetsession(this.mSessionState) != null) goto L7;
        L17:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L7:
            if (SessionState.m8830$$Nest$fgetclient(this.mSessionState) == null) goto L17;
            SessionState.m8830$$Nest$fgetclient(this.mSessionState).onTimeShiftStartPositionChanged(timeMs, SessionState.m8839$$Nest$fgetseq(this.mSessionState));     // Catch: Throwable -> L11 RemoteException -> L13
        L15:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L13:
            e = move-exception;
            Slog.e(TvInputManagerService.TAG, "error in onTimeShiftStartPositionChanged", e);     // Catch: Throwable -> L11
            goto L15
        }

        public void onTimeShiftCurrentPositionChanged(long timeMs) {
            Object r0 = TvInputManagerService.m8756$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L11:
            th = move-exception;
            throw th;
        L5:
            if (SessionState.m8840$$Nest$fgetsession(this.mSessionState) != null) goto L7;
        L17:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L7:
            if (SessionState.m8830$$Nest$fgetclient(this.mSessionState) == null) goto L17;
            SessionState.m8830$$Nest$fgetclient(this.mSessionState).onTimeShiftCurrentPositionChanged(timeMs, SessionState.m8839$$Nest$fgetseq(this.mSessionState));     // Catch: Throwable -> L11 RemoteException -> L13
        L15:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L13:
            e = move-exception;
            Slog.e(TvInputManagerService.TAG, "error in onTimeShiftCurrentPositionChanged", e);     // Catch: Throwable -> L11
            goto L15
        }

        public void onAitInfoUpdated(AitInfo aitInfo) {
            Object r0 = TvInputManagerService.m8756$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L11:
            th = move-exception;
            throw th;
        L5:
            if (SessionState.m8840$$Nest$fgetsession(this.mSessionState) != null) goto L7;
        L17:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L7:
            if (SessionState.m8830$$Nest$fgetclient(this.mSessionState) == null) goto L17;
            SessionState.m8830$$Nest$fgetclient(this.mSessionState).onAitInfoUpdated(aitInfo, SessionState.m8839$$Nest$fgetseq(this.mSessionState));     // Catch: Throwable -> L11 RemoteException -> L13
        L15:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L13:
            e = move-exception;
            Slog.e(TvInputManagerService.TAG, "error in onAitInfoUpdated", e);     // Catch: Throwable -> L11
            goto L15
        }

        public void onSignalStrength(int strength) {
            Object r0 = TvInputManagerService.m8756$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L11:
            th = move-exception;
            throw th;
        L5:
            if (SessionState.m8840$$Nest$fgetsession(this.mSessionState) != null) goto L7;
        L17:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L7:
            if (SessionState.m8830$$Nest$fgetclient(this.mSessionState) == null) goto L17;
            SessionState.m8830$$Nest$fgetclient(this.mSessionState).onSignalStrength(strength, SessionState.m8839$$Nest$fgetseq(this.mSessionState));     // Catch: Throwable -> L11 RemoteException -> L13
        L15:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L13:
            e = move-exception;
            Slog.e(TvInputManagerService.TAG, "error in onSignalStrength", e);     // Catch: Throwable -> L11
            goto L15
        }

        public void onCueingMessageAvailability(boolean available) {
            Object r0 = TvInputManagerService.m8756$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L11:
            th = move-exception;
            throw th;
        L5:
            if (SessionState.m8840$$Nest$fgetsession(this.mSessionState) != null) goto L7;
        L17:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L7:
            if (SessionState.m8830$$Nest$fgetclient(this.mSessionState) == null) goto L17;
            SessionState.m8830$$Nest$fgetclient(this.mSessionState).onCueingMessageAvailability(available, SessionState.m8839$$Nest$fgetseq(this.mSessionState));     // Catch: Throwable -> L11 RemoteException -> L13
        L15:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L13:
            e = move-exception;
            Slog.e(TvInputManagerService.TAG, "error in onCueingMessageAvailability", e);     // Catch: Throwable -> L11
            goto L15
        }

        public void onTimeShiftMode(int mode) {
            Object r0 = TvInputManagerService.m8756$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L11:
            th = move-exception;
            throw th;
        L5:
            if (SessionState.m8840$$Nest$fgetsession(this.mSessionState) != null) goto L7;
        L17:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L7:
            if (SessionState.m8830$$Nest$fgetclient(this.mSessionState) == null) goto L17;
            SessionState.m8830$$Nest$fgetclient(this.mSessionState).onTimeShiftMode(mode, SessionState.m8839$$Nest$fgetseq(this.mSessionState));     // Catch: Throwable -> L11 RemoteException -> L13
        L15:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L13:
            e = move-exception;
            Slog.e(TvInputManagerService.TAG, "error in onTimeShiftMode", e);     // Catch: Throwable -> L11
            goto L15
        }

        public void onAvailableSpeeds(float[] speeds) {
            Object r0 = TvInputManagerService.m8756$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L11:
            th = move-exception;
            throw th;
        L5:
            if (SessionState.m8840$$Nest$fgetsession(this.mSessionState) != null) goto L7;
        L17:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L7:
            if (SessionState.m8830$$Nest$fgetclient(this.mSessionState) == null) goto L17;
            SessionState.m8830$$Nest$fgetclient(this.mSessionState).onAvailableSpeeds(speeds, SessionState.m8839$$Nest$fgetseq(this.mSessionState));     // Catch: Throwable -> L11 RemoteException -> L13
        L15:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L13:
            e = move-exception;
            Slog.e(TvInputManagerService.TAG, "error in onAvailableSpeeds", e);     // Catch: Throwable -> L11
            goto L15
        }

        public void onTuned(Uri channelUri) {
            Object r0 = TvInputManagerService.m8756$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L11:
            th = move-exception;
            throw th;
        L5:
            if (SessionState.m8840$$Nest$fgetsession(this.mSessionState) != null) goto L7;
        L17:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L7:
            if (SessionState.m8830$$Nest$fgetclient(this.mSessionState) == null) goto L17;
            SessionState.m8830$$Nest$fgetclient(this.mSessionState).onTuned(channelUri, SessionState.m8839$$Nest$fgetseq(this.mSessionState));     // Catch: Throwable -> L11 RemoteException -> L13
        L15:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L13:
            e = move-exception;
            Slog.e(TvInputManagerService.TAG, "error in onTuned", e);     // Catch: Throwable -> L11
            goto L15
        }

        public void onTvMessage(int type, Bundle data) {
            Object r0 = TvInputManagerService.m8756$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L11:
            th = move-exception;
            throw th;
        L5:
            if (SessionState.m8840$$Nest$fgetsession(this.mSessionState) != null) goto L7;
        L17:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L7:
            if (SessionState.m8830$$Nest$fgetclient(this.mSessionState) == null) goto L17;
            SessionState.m8830$$Nest$fgetclient(this.mSessionState).onTvMessage(type, data, SessionState.m8839$$Nest$fgetseq(this.mSessionState));     // Catch: Throwable -> L11 RemoteException -> L13
        L15:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L13:
            e = move-exception;
            Slog.e(TvInputManagerService.TAG, "error in onTvMessage", e);     // Catch: Throwable -> L11
            goto L15
        }

        public void onRecordingStopped(Uri recordedProgramUri) {
            Object r0 = TvInputManagerService.m8756$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L11:
            th = move-exception;
            throw th;
        L5:
            if (SessionState.m8840$$Nest$fgetsession(this.mSessionState) != null) goto L7;
        L17:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L7:
            if (SessionState.m8830$$Nest$fgetclient(this.mSessionState) == null) goto L17;
            SessionState.m8830$$Nest$fgetclient(this.mSessionState).onRecordingStopped(recordedProgramUri, SessionState.m8839$$Nest$fgetseq(this.mSessionState));     // Catch: Throwable -> L11 RemoteException -> L13
        L15:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L13:
            e = move-exception;
            Slog.e(TvInputManagerService.TAG, "error in onRecordingStopped", e);     // Catch: Throwable -> L11
            goto L15
        }

        public void onError(int error) {
            Object r0 = TvInputManagerService.m8756$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L11:
            th = move-exception;
            throw th;
        L5:
            if (SessionState.m8840$$Nest$fgetsession(this.mSessionState) != null) goto L7;
        L17:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L7:
            if (SessionState.m8830$$Nest$fgetclient(this.mSessionState) == null) goto L17;
            SessionState.m8830$$Nest$fgetclient(this.mSessionState).onError(error, SessionState.m8839$$Nest$fgetseq(this.mSessionState));     // Catch: Throwable -> L11 RemoteException -> L13
        L15:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L13:
            e = move-exception;
            Slog.e(TvInputManagerService.TAG, "error in onError", e);     // Catch: Throwable -> L11
            goto L15
        }

        public void onBroadcastInfoResponse(BroadcastInfoResponse response) {
            Object r0 = TvInputManagerService.m8756$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L11:
            th = move-exception;
            throw th;
        L5:
            if (SessionState.m8840$$Nest$fgetsession(this.mSessionState) != null) goto L7;
        L17:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L7:
            if (SessionState.m8830$$Nest$fgetclient(this.mSessionState) == null) goto L17;
            SessionState.m8830$$Nest$fgetclient(this.mSessionState).onBroadcastInfoResponse(response, SessionState.m8839$$Nest$fgetseq(this.mSessionState));     // Catch: Throwable -> L11 RemoteException -> L13
        L15:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L13:
            e = move-exception;
            Slog.e(TvInputManagerService.TAG, "error in onBroadcastInfoResponse", e);     // Catch: Throwable -> L11
            goto L15
        }

        public void onAdResponse(AdResponse response) {
            Object r0 = TvInputManagerService.m8756$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L11:
            th = move-exception;
            throw th;
        L5:
            if (SessionState.m8840$$Nest$fgetsession(this.mSessionState) != null) goto L7;
        L17:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L7:
            if (SessionState.m8830$$Nest$fgetclient(this.mSessionState) == null) goto L17;
            SessionState.m8830$$Nest$fgetclient(this.mSessionState).onAdResponse(response, SessionState.m8839$$Nest$fgetseq(this.mSessionState));     // Catch: Throwable -> L11 RemoteException -> L13
        L15:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L13:
            e = move-exception;
            Slog.e(TvInputManagerService.TAG, "error in onAdResponse", e);     // Catch: Throwable -> L11
            goto L15
        }

        public void onAdBufferConsumed(AdBuffer buffer) {
            Object r0 = TvInputManagerService.m8756$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L14:
            th = move-exception;
            throw th;
        L5:
            if (SessionState.m8840$$Nest$fgetsession(this.mSessionState) != null) goto L33;
        L28:
            monitor-exit(r0);     // Catch: Throwable -> L14
            return;
        L33:
            if (SessionState.m8830$$Nest$fgetclient(this.mSessionState) == null) goto L28;
            SessionState.m8830$$Nest$fgetclient(this.mSessionState).onAdBufferConsumed(buffer, SessionState.m8839$$Nest$fgetseq(this.mSessionState));     // Catch: Throwable -> L16 RemoteException -> L18
            if (buffer == null) goto L22;
            SharedMemory r1 = buffer.getSharedMemory();     // Catch: Throwable -> L14
        L12:
            r1.close();     // Catch: Throwable -> L14
        L22:
            monitor-exit(r0);     // Catch: Throwable -> L14
            return;
        L18:
            e = move-exception;
            Slog.e(TvInputManagerService.TAG, "error in onAdBufferConsumed", e);     // Catch: Throwable -> L16
            if (buffer == null) goto L22;
            r1 = buffer.getSharedMemory();     // Catch: Throwable -> L14
        L16:
            th = move-exception;
            if (buffer == null) goto L27;
            buffer.getSharedMemory().close();     // Catch: Throwable -> L14
        L27:
            throw th;     // Catch: Throwable -> L14
        }

        public void onTvInputSessionData(String type, Bundle data) {
            Object r0 = TvInputManagerService.m8756$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L11:
            th = move-exception;
            throw th;
        L5:
            if (SessionState.m8840$$Nest$fgetsession(this.mSessionState) != null) goto L7;
        L17:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L7:
            if (SessionState.m8830$$Nest$fgetclient(this.mSessionState) == null) goto L17;
            SessionState.m8830$$Nest$fgetclient(this.mSessionState).onTvInputSessionData(type, data, SessionState.m8839$$Nest$fgetseq(this.mSessionState));     // Catch: Throwable -> L11 RemoteException -> L13
        L15:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L13:
            e = move-exception;
            Slog.e(TvInputManagerService.TAG, "error in onTvInputSessionData", e);     // Catch: Throwable -> L11
            goto L15
        }
    }

    private static class SessionNotFoundException extends IllegalArgumentException {
        public SessionNotFoundException(String name) {
            super(name);
        }
    }

    private final class SessionState implements IBinder.DeathRecipient {
        private final int callingPid;
        private final int callingUid;
        private final ITvInputClient client;
        private final ComponentName componentName;
        private Uri currentChannel;
        private IBinder hardwareSessionToken;
        private final String inputId;
        private boolean isCurrent;
        private boolean isMainSession;
        private final boolean isRecordingSession;
        private boolean isVisible;
        private final int seq;
        private ITvInputSession session;
        private final String sessionId;
        private final IBinder sessionToken;
        final /* synthetic */ TvInputManagerService this$0;
        private final AttributionSource tvAppAttributionSource;
        private final int userId;

        /* JADX INFO: renamed from: -$$Nest$fgetcallingPid, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m8828$$Nest$fgetcallingPid(SessionState r0) {
            return r0.callingPid;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetcallingUid, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m8829$$Nest$fgetcallingUid(SessionState r0) {
            return r0.callingUid;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetclient, reason: not valid java name */
        static /* bridge */ /* synthetic */ ITvInputClient m8830$$Nest$fgetclient(SessionState r0) {
            return r0.client;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetcomponentName, reason: not valid java name */
        static /* bridge */ /* synthetic */ ComponentName m8831$$Nest$fgetcomponentName(SessionState r0) {
            return r0.componentName;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetcurrentChannel, reason: not valid java name */
        static /* bridge */ /* synthetic */ Uri m8832$$Nest$fgetcurrentChannel(SessionState r0) {
            return r0.currentChannel;
        }

        /* JADX INFO: renamed from: -$$Nest$fgethardwareSessionToken, reason: not valid java name */
        static /* bridge */ /* synthetic */ IBinder m8833$$Nest$fgethardwareSessionToken(SessionState r0) {
            return r0.hardwareSessionToken;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetinputId, reason: not valid java name */
        static /* bridge */ /* synthetic */ String m8834$$Nest$fgetinputId(SessionState r0) {
            return r0.inputId;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetisCurrent, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m8835$$Nest$fgetisCurrent(SessionState r0) {
            return r0.isCurrent;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetisMainSession, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m8836$$Nest$fgetisMainSession(SessionState r0) {
            return r0.isMainSession;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetisRecordingSession, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m8837$$Nest$fgetisRecordingSession(SessionState r0) {
            return r0.isRecordingSession;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetisVisible, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m8838$$Nest$fgetisVisible(SessionState r0) {
            return r0.isVisible;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetseq, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m8839$$Nest$fgetseq(SessionState r0) {
            return r0.seq;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetsession, reason: not valid java name */
        static /* bridge */ /* synthetic */ ITvInputSession m8840$$Nest$fgetsession(SessionState r0) {
            return r0.session;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetsessionId, reason: not valid java name */
        static /* bridge */ /* synthetic */ String m8841$$Nest$fgetsessionId(SessionState r0) {
            return r0.sessionId;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetsessionToken, reason: not valid java name */
        static /* bridge */ /* synthetic */ IBinder m8842$$Nest$fgetsessionToken(SessionState r0) {
            return r0.sessionToken;
        }

        /* JADX INFO: renamed from: -$$Nest$fgettvAppAttributionSource, reason: not valid java name */
        static /* bridge */ /* synthetic */ AttributionSource m8843$$Nest$fgettvAppAttributionSource(SessionState r0) {
            return r0.tvAppAttributionSource;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetuserId, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m8844$$Nest$fgetuserId(SessionState r0) {
            return r0.userId;
        }

        /* JADX INFO: renamed from: -$$Nest$fputcurrentChannel, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m8845$$Nest$fputcurrentChannel(SessionState r0, Uri r1) {
            r0.currentChannel = r1;
        }

        /* JADX INFO: renamed from: -$$Nest$fputhardwareSessionToken, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m8846$$Nest$fputhardwareSessionToken(SessionState r0, IBinder r1) {
            r0.hardwareSessionToken = r1;
        }

        /* JADX INFO: renamed from: -$$Nest$fputisCurrent, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m8847$$Nest$fputisCurrent(SessionState r0, boolean r1) {
            r0.isCurrent = r1;
        }

        /* JADX INFO: renamed from: -$$Nest$fputisMainSession, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m8848$$Nest$fputisMainSession(SessionState r0, boolean r1) {
            r0.isMainSession = r1;
        }

        /* JADX INFO: renamed from: -$$Nest$fputisVisible, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m8849$$Nest$fputisVisible(SessionState r0, boolean r1) {
            r0.isVisible = r1;
        }

        /* JADX INFO: renamed from: -$$Nest$fputsession, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m8850$$Nest$fputsession(SessionState r0, ITvInputSession r1) {
            r0.session = r1;
        }

        /* synthetic */ SessionState(TvInputManagerService r1, IBinder r2, String r3, ComponentName r4, boolean r5, ITvInputClient r6, int r7, int r8, int r9, int r10, String r11, AttributionSource r12, TvInputManagerServiceIA r13) {
            this(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12);
        }

        private SessionState(TvInputManagerService r2, IBinder sessionToken, String inputId, ComponentName componentName, boolean isRecordingSession, ITvInputClient client, int seq, int callingUid, int callingPid, int userId, String sessionId, AttributionSource tvAppAttributionSource) {
            this.this$0 = r2;
            this.isCurrent = false;
            this.currentChannel = null;
            this.isVisible = false;
            this.isMainSession = false;
            this.sessionToken = sessionToken;
            this.inputId = inputId;
            this.componentName = componentName;
            this.isRecordingSession = isRecordingSession;
            this.client = client;
            this.seq = seq;
            this.callingUid = callingUid;
            this.callingPid = callingPid;
            this.userId = userId;
            this.sessionId = sessionId;
            this.tvAppAttributionSource = tvAppAttributionSource;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            Object r0 = TvInputManagerService.m8756$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            this.session = null;     // Catch: Throwable -> L8
            TvInputManagerService.m8772$$Nest$mclearSessionAndNotifyClientLocked(this.this$0, this);     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            throw th;
        }
    }

    private class TvInputManagerCallbackList extends RemoteCallbackList<ITvInputManagerCallback> {
        final /* synthetic */ TvInputManagerService this$0;

        /* synthetic */ TvInputManagerCallbackList(TvInputManagerService r1, TvInputManagerServiceIA r2) {
            this(r1);
        }

        private TvInputManagerCallbackList(TvInputManagerService r1) {
            this.this$0 = r1;
        }

        @Override // android.os.RemoteCallbackList
        public /* bridge */ /* synthetic */ void onCallbackDied(IInterface r1) {
            onCallbackDied((ITvInputManagerCallback) r1);
        }

        public void onCallbackDied(ITvInputManagerCallback callback) {
            Object r0 = TvInputManagerService.m8756$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            int i = 0;
        L15:
        L8:
            th = move-exception;
            throw th;
        L6:
            if (i >= TvInputManagerService.m8763$$Nest$fgetmUserStates(this.this$0).size()) goto L11;
            int userId = TvInputManagerService.m8763$$Nest$fgetmUserStates(this.this$0).keyAt(i);     // Catch: Throwable -> L8
            UserState userState = TvInputManagerService.m8775$$Nest$mgetOrCreateUserStateLocked(this.this$0, userId);     // Catch: Throwable -> L8
            UserState.m8859$$Nest$fgetcallbackPidUidMap(userState).remove(callback);     // Catch: Throwable -> L8
            i = i + 1;     // Catch: Throwable -> L8
            goto L15
        L11:
            monitor-exit(r0);     // Catch: Throwable -> L8
        }
    }

    private static final class TvInputState {
        private TvInputInfo info;
        private int inputNumber;
        private int state;
        private int uid;

        /* JADX INFO: renamed from: -$$Nest$fgetinfo, reason: not valid java name */
        static /* bridge */ /* synthetic */ TvInputInfo m8851$$Nest$fgetinfo(TvInputState r0) {
            return r0.info;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetinputNumber, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m8852$$Nest$fgetinputNumber(TvInputState r0) {
            return r0.inputNumber;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetstate, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m8853$$Nest$fgetstate(TvInputState r0) {
            return r0.state;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetuid, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m8854$$Nest$fgetuid(TvInputState r0) {
            return r0.uid;
        }

        /* JADX INFO: renamed from: -$$Nest$fputinfo, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m8855$$Nest$fputinfo(TvInputState r0, TvInputInfo r1) {
            r0.info = r1;
        }

        /* JADX INFO: renamed from: -$$Nest$fputinputNumber, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m8856$$Nest$fputinputNumber(TvInputState r0, int r1) {
            r0.inputNumber = r1;
        }

        /* JADX INFO: renamed from: -$$Nest$fputstate, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m8857$$Nest$fputstate(TvInputState r0, int r1) {
            r0.state = r1;
        }

        /* JADX INFO: renamed from: -$$Nest$fputuid, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m8858$$Nest$fputuid(TvInputState r0, int r1) {
            r0.uid = r1;
        }

        /* synthetic */ TvInputState(TvInputManagerServiceIA r1) {
            this();
        }

        private TvInputState() {
            this.state = 0;
        }

        public String toString() {
            return "info: " + this.info + "; state: " + this.state;
        }
    }

    private final class UserState {
        private final Map<ITvInputManagerCallback, Pair<Integer, Integer>> callbackPidUidMap;
        private final Map<IBinder, ClientState> clientStateMap;
        private final List<TvContentRatingSystemInfo> contentRatingSystemList;
        private Map<String, TvInputState> inputMap;
        private final Map<Integer, Integer> mAppTagMap;
        private final TvInputManagerCallbackList mCallbacks;
        private int mNextAppTag;
        private IBinder mainSessionToken;
        private final Set<String> packageSet;
        private final PersistentDataStore persistentDataStore;
        private final Map<ComponentName, ServiceState> serviceStateMap;
        private final Map<IBinder, SessionState> sessionStateMap;
        final /* synthetic */ TvInputManagerService this$0;

        /* JADX INFO: renamed from: -$$Nest$fgetcallbackPidUidMap, reason: not valid java name */
        static /* bridge */ /* synthetic */ Map m8859$$Nest$fgetcallbackPidUidMap(UserState r0) {
            return r0.callbackPidUidMap;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetclientStateMap, reason: not valid java name */
        static /* bridge */ /* synthetic */ Map m8860$$Nest$fgetclientStateMap(UserState r0) {
            return r0.clientStateMap;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetcontentRatingSystemList, reason: not valid java name */
        static /* bridge */ /* synthetic */ List m8861$$Nest$fgetcontentRatingSystemList(UserState r0) {
            return r0.contentRatingSystemList;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetinputMap, reason: not valid java name */
        static /* bridge */ /* synthetic */ Map m8862$$Nest$fgetinputMap(UserState r0) {
            return r0.inputMap;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmAppTagMap, reason: not valid java name */
        static /* bridge */ /* synthetic */ Map m8863$$Nest$fgetmAppTagMap(UserState r0) {
            return r0.mAppTagMap;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmCallbacks, reason: not valid java name */
        static /* bridge */ /* synthetic */ TvInputManagerCallbackList m8864$$Nest$fgetmCallbacks(UserState r0) {
            return r0.mCallbacks;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmNextAppTag, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m8865$$Nest$fgetmNextAppTag(UserState r0) {
            return r0.mNextAppTag;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmainSessionToken, reason: not valid java name */
        static /* bridge */ /* synthetic */ IBinder m8866$$Nest$fgetmainSessionToken(UserState r0) {
            return r0.mainSessionToken;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetpackageSet, reason: not valid java name */
        static /* bridge */ /* synthetic */ Set m8867$$Nest$fgetpackageSet(UserState r0) {
            return r0.packageSet;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetpersistentDataStore, reason: not valid java name */
        static /* bridge */ /* synthetic */ PersistentDataStore m8868$$Nest$fgetpersistentDataStore(UserState r0) {
            return r0.persistentDataStore;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetserviceStateMap, reason: not valid java name */
        static /* bridge */ /* synthetic */ Map m8869$$Nest$fgetserviceStateMap(UserState r0) {
            return r0.serviceStateMap;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetsessionStateMap, reason: not valid java name */
        static /* bridge */ /* synthetic */ Map m8870$$Nest$fgetsessionStateMap(UserState r0) {
            return r0.sessionStateMap;
        }

        /* JADX INFO: renamed from: -$$Nest$fputinputMap, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m8871$$Nest$fputinputMap(UserState r0, Map r1) {
            r0.inputMap = r1;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmNextAppTag, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m8872$$Nest$fputmNextAppTag(UserState r0, int r1) {
            r0.mNextAppTag = r1;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmainSessionToken, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m8873$$Nest$fputmainSessionToken(UserState r0, IBinder r1) {
            r0.mainSessionToken = r1;
        }

        /* synthetic */ UserState(TvInputManagerService r1, Context r2, int r3, TvInputManagerServiceIA r4) {
            this(r1, r2, r3);
        }

        private UserState(TvInputManagerService r3, Context context, int userId) {
            this.this$0 = r3;
            this.inputMap = new HashMap();
            this.packageSet = new HashSet();
            this.contentRatingSystemList = new ArrayList();
            this.clientStateMap = new HashMap();
            this.serviceStateMap = new HashMap();
            this.sessionStateMap = new HashMap();
            this.mCallbacks = new TvInputManagerCallbackList(this.this$0, null);
            this.callbackPidUidMap = new HashMap();
            this.mainSessionToken = null;
            this.mAppTagMap = new HashMap();
            this.mNextAppTag = 1;
            this.persistentDataStore = new PersistentDataStore(context, userId);
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m8754$$Nest$fgetmContext(TvInputManagerService r0) {
        return r0.mContext;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCurrentUserId, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m8755$$Nest$fgetmCurrentUserId(TvInputManagerService r0) {
        return r0.mCurrentUserId;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m8756$$Nest$fgetmLock(TvInputManagerService r0) {
        return r0.mLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmMessageHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ MessageHandler m8757$$Nest$fgetmMessageHandler(TvInputManagerService r0) {
        return r0.mMessageHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmOnScreenInputId, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m8758$$Nest$fgetmOnScreenInputId(TvInputManagerService r0) {
        return r0.mOnScreenInputId;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmOnScreenSessionState, reason: not valid java name */
    static /* bridge */ /* synthetic */ SessionState m8759$$Nest$fgetmOnScreenSessionState(TvInputManagerService r0) {
        return r0.mOnScreenSessionState;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmRunningProfiles, reason: not valid java name */
    static /* bridge */ /* synthetic */ Set m8760$$Nest$fgetmRunningProfiles(TvInputManagerService r0) {
        return r0.mRunningProfiles;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSessionIdToSessionStateMap, reason: not valid java name */
    static /* bridge */ /* synthetic */ Map m8761$$Nest$fgetmSessionIdToSessionStateMap(TvInputManagerService r0) {
        return r0.mSessionIdToSessionStateMap;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmTvInputHardwareManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ TvInputHardwareManager m8762$$Nest$fgetmTvInputHardwareManager(TvInputManagerService r0) {
        return r0.mTvInputHardwareManager;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmUserStates, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseArray m8763$$Nest$fgetmUserStates(TvInputManagerService r0) {
        return r0.mUserStates;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmOnScreenInputId, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8764$$Nest$fputmOnScreenInputId(TvInputManagerService r0, String r1) {
        r0.mOnScreenInputId = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmOnScreenSessionState, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8765$$Nest$fputmOnScreenSessionState(TvInputManagerService r0, SessionState r1) {
        r0.mOnScreenSessionState = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mabortPendingCreateSessionRequestsLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8766$$Nest$mabortPendingCreateSessionRequestsLocked(TvInputManagerService r0, ServiceState r1, String r2, int r3) {
        r0.abortPendingCreateSessionRequestsLocked(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$maddHardwareInputLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8767$$Nest$maddHardwareInputLocked(TvInputManagerService r0, TvInputInfo r1, ComponentName r2, int r3) {
        r0.addHardwareInputLocked(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$massertTvAsCecActiveSourceLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8768$$Nest$massertTvAsCecActiveSourceLocked(TvInputManagerService r0) {
        r0.assertTvAsCecActiveSourceLocked();
    }

    /* JADX INFO: renamed from: -$$Nest$mbindService, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8769$$Nest$mbindService(TvInputManagerService r0, ServiceState r1, int r2) {
        r0.bindService(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mbuildTvContentRatingSystemListLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8770$$Nest$mbuildTvContentRatingSystemListLocked(TvInputManagerService r0, int r1) {
        r0.buildTvContentRatingSystemListLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mbuildTvInputListLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8771$$Nest$mbuildTvInputListLocked(TvInputManagerService r0, int r1, String[] r2) {
        r0.buildTvInputListLocked(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mclearSessionAndNotifyClientLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8772$$Nest$mclearSessionAndNotifyClientLocked(TvInputManagerService r0, SessionState r1) {
        r0.clearSessionAndNotifyClientLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mcreateSessionInternalLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m8773$$Nest$mcreateSessionInternalLocked(TvInputManagerService r0, ITvInputService r1, IBinder r2, int r3) {
        return r0.createSessionInternalLocked(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetCurrentTunedInfosInternalLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ List m8774$$Nest$mgetCurrentTunedInfosInternalLocked(TvInputManagerService r0, UserState r1, int r2, int r3) {
        return r0.getCurrentTunedInfosInternalLocked(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetOrCreateUserStateLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ UserState m8775$$Nest$mgetOrCreateUserStateLocked(TvInputManagerService r0, int r1) {
        return r0.getOrCreateUserStateLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetServiceStateLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ ServiceState m8776$$Nest$mgetServiceStateLocked(TvInputManagerService r0, ComponentName r1, int r2) {
        return r0.getServiceStateLocked(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetSessionActualInputId, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m8777$$Nest$mgetSessionActualInputId(TvInputManagerService r0, SessionState r1) {
        return r0.getSessionActualInputId(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetSessionLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ ITvInputSession m8778$$Nest$mgetSessionLocked(TvInputManagerService r0, IBinder r1, int r2, int r3) {
        return r0.getSessionLocked(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetSessionLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ ITvInputSession m8779$$Nest$mgetSessionLocked(TvInputManagerService r0, SessionState r1) {
        return r0.getSessionLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetSessionStateLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ SessionState m8780$$Nest$mgetSessionStateLocked(TvInputManagerService r0, IBinder r1, int r2, int r3) {
        return r0.getSessionStateLocked(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetSessionStateLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ SessionState m8781$$Nest$mgetSessionStateLocked(TvInputManagerService r0, IBinder r1, int r2, UserState r3) {
        return r0.getSessionStateLocked(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetUserStateLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ UserState m8782$$Nest$mgetUserStateLocked(TvInputManagerService r0, int r1) {
        return r0.getUserStateLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mlogExternalInputEvent, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8783$$Nest$mlogExternalInputEvent(TvInputManagerService r0, int r1, String r2, SessionState r3) {
        r0.logExternalInputEvent(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mlogTuneStateChanged, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8784$$Nest$mlogTuneStateChanged(TvInputManagerService r0, int r1, SessionState r2, TvInputState r3) {
        r0.logTuneStateChanged(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mnotifyCurrentChannelInfosUpdatedLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8785$$Nest$mnotifyCurrentChannelInfosUpdatedLocked(TvInputManagerService r0, UserState r1) {
        r0.notifyCurrentChannelInfosUpdatedLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mnotifyInputStateChangedLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8786$$Nest$mnotifyInputStateChangedLocked(TvInputManagerService r0, UserState r1, String r2, int r3, ITvInputManagerCallback r4) {
        r0.notifyInputStateChangedLocked(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$mreleaseSessionLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ SessionState m8787$$Nest$mreleaseSessionLocked(TvInputManagerService r0, IBinder r1, int r2, int r3) {
        return r0.releaseSessionLocked(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mremoveHardwareInputLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8788$$Nest$mremoveHardwareInputLocked(TvInputManagerService r0, String r1, int r2) {
        r0.removeHardwareInputLocked(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mremoveSessionStateLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8789$$Nest$mremoveSessionStateLocked(TvInputManagerService r0, IBinder r1, int r2) {
        r0.removeSessionStateLocked(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mremoveUser, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8790$$Nest$mremoveUser(TvInputManagerService r0, int r1) {
        r0.removeUser(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mresolveCallingUserId, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m8791$$Nest$mresolveCallingUserId(TvInputManagerService r0, int r1, int r2, int r3, String r4) {
        return r0.resolveCallingUserId(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$msendSessionTokenToClientLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8792$$Nest$msendSessionTokenToClientLocked(TvInputManagerService r0, ITvInputClient r1, String r2, IBinder r3, InputChannel r4, int r5) {
        r0.sendSessionTokenToClientLocked(r1, r2, r3, r4, r5);
    }

    /* JADX INFO: renamed from: -$$Nest$msetMainLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8793$$Nest$msetMainLocked(TvInputManagerService r0, IBinder r1, boolean r2, int r3, int r4) {
        r0.setMainLocked(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$msetStateLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8794$$Nest$msetStateLocked(TvInputManagerService r0, String r1, int r2, int r3) {
        r0.setStateLocked(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mstartUser, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8795$$Nest$mstartUser(TvInputManagerService r0, int r1) {
        r0.startUser(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mstopUser, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8796$$Nest$mstopUser(TvInputManagerService r0, int r1) {
        r0.stopUser(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mswitchUser, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8797$$Nest$mswitchUser(TvInputManagerService r0, int r1) {
        r0.switchUser(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateHardwareServiceConnectionDelayed, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8798$$Nest$mupdateHardwareServiceConnectionDelayed(TvInputManagerService r0, int r1) {
        r0.updateHardwareServiceConnectionDelayed(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateHardwareTvInputServiceBindingLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8799$$Nest$mupdateHardwareTvInputServiceBindingLocked(TvInputManagerService r0, int r1) {
        r0.updateHardwareTvInputServiceBindingLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateServiceConnectionLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8800$$Nest$mupdateServiceConnectionLocked(TvInputManagerService r0, ComponentName r1, int r2) {
        r0.updateServiceConnectionLocked(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateTvInputInfoLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8801$$Nest$mupdateTvInputInfoLocked(TvInputManagerService r0, UserState r1, TvInputInfo r2) {
        r0.updateTvInputInfoLocked(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetsAdapterDirPattern, reason: not valid java name */
    static /* bridge */ /* synthetic */ Pattern m8802$$Nest$sfgetsAdapterDirPattern() {
        return sAdapterDirPattern;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetsFrontEndDevicePattern, reason: not valid java name */
    static /* bridge */ /* synthetic */ Pattern m8803$$Nest$sfgetsFrontEndDevicePattern() {
        return sFrontEndDevicePattern;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetsFrontEndInAdapterDirPattern, reason: not valid java name */
    static /* bridge */ /* synthetic */ Pattern m8804$$Nest$sfgetsFrontEndInAdapterDirPattern() {
        return sFrontEndInAdapterDirPattern;
    }

    /* JADX INFO: renamed from: -$$Nest$smgetTvInputState, reason: not valid java name */
    static /* bridge */ /* synthetic */ TvInputState m8805$$Nest$smgetTvInputState(SessionState r0, UserState r1) {
        return getTvInputState(r0, r1);
    }

    /* JADX INFO: renamed from: -$$Nest$smhasHardwarePermission, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m8806$$Nest$smhasHardwarePermission(PackageManager r0, ComponentName r1) {
        return hasHardwarePermission(r0, r1);
    }

    static {
        sFrontEndDevicePattern = Pattern.compile("^dvb([0-9]+)\\.frontend([0-9]+)$");
        sAdapterDirPattern = Pattern.compile("^adapter([0-9]+)$");
        sFrontEndInAdapterDirPattern = Pattern.compile("^frontend([0-9]+)$");
    }

    public TvInputManagerService(Context context) {
        super(context);
        this.mLock = new Object();
        this.mCurrentUserId = 0;
        this.mOnScreenInputId = null;
        this.mOnScreenSessionState = null;
        this.mRunningProfiles = new HashSet();
        this.mUserStates = new SparseArray();
        this.mSessionIdToSessionStateMap = new HashMap();
        this.mExternalInputLoggingDisplayNameFilterEnabled = false;
        this.mExternalInputLoggingDeviceOnScreenDisplayNames = new HashSet();
        this.mExternalInputLoggingDeviceBrandNames = new ArrayList();
        this.mHdmiControlManager = null;
        this.mHdmiTvClient = null;
        this.mMediaQualityManager = null;
        this.mContext = context;
        this.mMessageHandler = new MessageHandler(this, this.mContext.getContentResolver(), IoThread.get().getLooper());
        this.mTvInputHardwareManager = new TvInputHardwareManager(context, new HardwareListener(this, null));
        this.mPackageMonitor = new MyPackageMonitor(this, true);
        this.mActivityManager = (ActivityManager) getContext().getSystemService(HostingRecord.HOSTING_TYPE_ACTIVITY);
        this.mUserManager = (UserManager) getContext().getSystemService("user");
        this.mHdmiControlManager = (HdmiControlManager) this.mContext.getSystemService(HdmiControlManager.class);
        if (this.mHdmiControlManager != null) goto L5;
        Slog.w(TAG, "HdmiControlManager is null!");
    L6:
        Object r0 = this.mLock;
        monitor-enter(r0);
        getOrCreateUserStateLocked(this.mCurrentUserId);     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        initExternalInputLoggingConfigs();
        return;
    L12:
        th = move-exception;
        throw th;
    L5:
        this.mHdmiTvClient = this.mHdmiControlManager.getTvClient();
        goto L6
    }

    @Override // com.android.server.SystemService
    public void onStart() {
        publishBinderService("tv_input", new BinderService(this, null));
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.intent.action.SCREEN_ON");
        filter.addAction("android.intent.action.SCREEN_OFF");
        this.mContext.registerReceiver(new AnonymousClass1(this), filter);
    }

    @Override // com.android.server.SystemService
    public void onBootPhase(int phase) {
        if (phase != 500) goto L6;
        registerBroadcastReceivers();
    L15:
        this.mTvInputHardwareManager.onBootPhase(phase);
        return;
    L6:
        if (phase != 600) goto L15;
        Object r0 = this.mLock;
        monitor-enter(r0);
        buildTvInputListLocked(this.mCurrentUserId, null);     // Catch: Throwable -> L12
        buildTvContentRatingSystemListLocked(this.mCurrentUserId);     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.SystemService
    public void onUserUnlocking(SystemService.TargetUser user) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mCurrentUserId == user.getUserIdentifier()) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        buildTvInputListLocked(this.mCurrentUserId, null);     // Catch: Throwable -> L8
        buildTvContentRatingSystemListLocked(this.mCurrentUserId);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
    }

    private void initExternalInputLoggingConfigs() {
        this.mExternalInputLoggingDisplayNameFilterEnabled = this.mContext.getResources().getBoolean(R.bool.config_useCurrentRotationOnRotationLockChange);
        if (this.mExternalInputLoggingDisplayNameFilterEnabled == true) goto L5;
        return;
    L5:
        String[] deviceOnScreenDisplayNames = this.mContext.getResources().getStringArray(R.array.disallowed_apps_managed_device);
        String[] deviceBrandNames = this.mContext.getResources().getStringArray(R.array.dial_string_replace);
        this.mExternalInputLoggingDeviceOnScreenDisplayNames.addAll(Arrays.asList(deviceOnScreenDisplayNames));
        this.mExternalInputLoggingDeviceBrandNames.addAll(Arrays.asList(deviceBrandNames));
    }

    private void registerBroadcastReceivers() {
        this.mPackageMonitor.register(this.mContext, null, UserHandle.ALL, true);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.USER_SWITCHED");
        intentFilter.addAction("android.intent.action.USER_REMOVED");
        intentFilter.addAction("android.intent.action.USER_STARTED");
        intentFilter.addAction("android.intent.action.USER_STOPPED");
        this.mContext.registerReceiverAsUser(new AnonymousClass2(this), UserHandle.ALL, intentFilter, null, null);
    }

    private static boolean hasAlwaysBoundPermission(PackageManager pm, ComponentName component) {
        if (pm.checkPermission("android.permission.ALWAYS_BOUND_TV_INPUT", component.getPackageName()) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    private static boolean hasHardwarePermission(PackageManager pm, ComponentName component) {
        if (pm.checkPermission("android.permission.TV_INPUT_HARDWARE", component.getPackageName()) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    private void buildTvInputListLocked(int userId, String[] updatedPackages) {
        UserState userState = getOrCreateUserStateLocked(userId);
        UserState.m8867$$Nest$fgetpackageSet(userState).clear();
        PackageManager pm = this.mContext.getPackageManager();
        List<ResolveInfo> services = pm.queryIntentServicesAsUser(new Intent("android.media.tv.TvInputService"), 132, userId);
        List<TvInputInfo> inputList = new ArrayList();
        Iterator<ResolveInfo> r4 = services.iterator();
    L3:
        TvInputManagerServiceIA r6 = null;
        if (r4.hasNext() == false) goto L22;
        ResolveInfo ri = r4.next();
        ServiceInfo si = ri.serviceInfo;
        if ("android.permission.BIND_TV_INPUT".equals(si.permission) == false) goto L7;
        ComponentName component = new ComponentName(si.packageName, si.name);
        if (hasHardwarePermission(pm, component) == true) goto L10;
        TvInputInfo info = new TvInputInfo.Builder(this.mContext, ri).build();     // Catch: Exception -> L20
        inputList.add(info);     // Catch: Exception -> L20
    L19:
        UserState.m8867$$Nest$fgetpackageSet(userState).add(si.packageName);
    L20:
        e = move-exception;
        Slog.e(TAG, "failed to load TV input " + si.name, e);
        goto L3
    L10:
        ServiceState serviceState = (ServiceState) UserState.m8869$$Nest$fgetserviceStateMap(userState).get(component);
        if (serviceState != null) goto L13;
        serviceState = new ServiceState(this, component, userId, r6);
        UserState.m8869$$Nest$fgetserviceStateMap(userState).put(component, serviceState);
    L15:
        if (ServiceState.m8819$$Nest$fgetneedInit(serviceState) == false) goto L19;
        updateServiceConnectionLocked(component, userId);
        goto L19
    L13:
        inputList.addAll(ServiceState.m8815$$Nest$fgethardwareInputMap(serviceState).values());
        goto L15
    L7:
        Slog.w(TAG, "Skipping TV input " + si.name + ": it does not require the permission android.permission.BIND_TV_INPUT");
        goto L3
    L22:
        Collections.sort(inputList, Comparator.comparing(new TvInputManagerService$$ExternalSyntheticLambda0()));
        Map<String, TvInputState> inputMap = new HashMap();
        ArrayMap<String, Integer> tisInputCount = new ArrayMap(inputMap.size());
        Iterator<TvInputInfo> r7 = inputList.iterator();
    L24:
        if (r7.hasNext() == false) goto L33;
        TvInputInfo info2 = r7.next();
        String inputId = info2.getId();
        Integer count = tisInputCount.get(inputId);
        if (count != null) goto L28;
        Integer r11 = 1;
        int r12 = r11.intValue();
    L29:
        Integer count2 = Integer.valueOf(r12);
        tisInputCount.put(inputId, count2);
        TvInputState inputState = (TvInputState) UserState.m8862$$Nest$fgetinputMap(userState).get(inputId);
        if (inputState != null) goto L32;
        inputState = new TvInputState(r6);
    L32:
        TvInputState.m8855$$Nest$fputinfo(inputState, info2);
        TvInputState.m8858$$Nest$fputuid(inputState, getInputUid(info2));
        inputMap.put(inputId, inputState);
        TvInputState.m8856$$Nest$fputinputNumber(inputState, count2.intValue());
        goto L24
    L28:
        r12 = 1 + count.intValue();
        goto L29
    L33:
        Iterator<String> r8 = inputMap.keySet().iterator();
    L35:
        if (r8.hasNext() == false) goto L48;
        String inputId2 = r8.next();
        if (UserState.m8862$$Nest$fgetinputMap(userState).containsKey(inputId2) == false) goto L38;
        if (updatedPackages == null) goto L35;
        ComponentName component2 = TvInputState.m8851$$Nest$fgetinfo(inputMap.get(inputId2)).getComponent();
        int r9 = updatedPackages.length;
        int r10 = 0;
    L42:
        if (r10 >= r9) goto L35;
        String updatedPackage = updatedPackages[r10];
        if (component2.getPackageName().equals(updatedPackage) == true) goto L45;
        r10 = r10 + 1;
        goto L42
    L45:
        updateServiceConnectionLocked(component2, userId);
        notifyInputUpdatedLocked(userState, inputId2);
        goto L35
    L38:
        notifyInputAddedLocked(userState, inputId2);
        goto L35
    L48:
        Iterator r13 = UserState.m8862$$Nest$fgetinputMap(userState).keySet().iterator();
    L50:
        if (r13.hasNext() == false) goto L58;
        String inputId3 = (String) r13.next();
        if (inputMap.containsKey(inputId3) == true) goto L50;
        ServiceState serviceState2 = (ServiceState) UserState.m8869$$Nest$fgetserviceStateMap(userState).get(TvInputState.m8851$$Nest$fgetinfo((TvInputState) UserState.m8862$$Nest$fgetinputMap(userState).get(inputId3)).getComponent());
        if (serviceState2 == null) goto L56;
        abortPendingCreateSessionRequestsLocked(serviceState2, inputId3, userId);
    L56:
        notifyInputRemovedLocked(userState, inputId3);
        goto L50
    L58:
        UserState.m8862$$Nest$fgetinputMap(userState).clear();
        UserState.m8871$$Nest$fputinputMap(userState, inputMap);
    }

    private int getInputUid(TvInputInfo info) {
        return getContext().getPackageManager().getApplicationInfo(info.getServiceInfo().packageName, 0).uid;
    L4:
        e = move-exception;
        Slog.w(TAG, "Unable to get UID for  " + info, e);
        return -1;
    }

    private void buildTvContentRatingSystemListLocked(int userId) {
        UserState userState = getOrCreateUserStateLocked(userId);
        UserState.m8861$$Nest$fgetcontentRatingSystemList(userState).clear();
        PackageManager pm = this.mContext.getPackageManager();
        Intent intent = new Intent("android.media.tv.action.QUERY_CONTENT_RATING_SYSTEMS");
        Iterator<ResolveInfo> r3 = pm.queryBroadcastReceivers(intent, 128).iterator();
    L4:
        if (r3.hasNext() == false) goto L12;
        ResolveInfo resolveInfo = r3.next();
        ActivityInfo receiver = resolveInfo.activityInfo;
        Bundle metaData = receiver.metaData;
        if (metaData == null) goto L4;
        int xmlResId = metaData.getInt("android.media.tv.metadata.CONTENT_RATING_SYSTEMS");
        if (xmlResId == 0) goto L10;
        UserState.m8861$$Nest$fgetcontentRatingSystemList(userState).add(TvContentRatingSystemInfo.createTvContentRatingSystemInfo(xmlResId, receiver.applicationInfo));
        goto L4
    L10:
        Slog.w(TAG, "Missing meta-data 'android.media.tv.metadata.CONTENT_RATING_SYSTEMS' on receiver " + receiver.packageName + SliceClientPermissions.SliceAuthority.DELIMITER + receiver.name);
        goto L4
    }

    private void cleanUpHdmiDevices(int userId) {
        UserState userState = getOrCreateUserStateLocked(userId);
        Iterator r1 = UserState.m8869$$Nest$fgetserviceStateMap(userState).values().iterator();
    L4:
        if (r1.hasNext() == false) goto L19;
        ServiceState serviceState = (ServiceState) r1.next();
        Iterator<HdmiDeviceInfo> r3 = this.mTvInputHardwareManager.getHdmiDeviceList().iterator();
    L7:
        if (r3.hasNext() == false) goto L4;
        HdmiDeviceInfo device = r3.next();
        if (ServiceState.m8821$$Nest$fgetservice(serviceState) != null) goto L11;
        ServiceState.m8816$$Nest$fgethdmiDeviceRemovedBuffer(serviceState).add(device);     // Catch: RemoteException -> L12
        goto L7
    L11:
        ServiceState.m8821$$Nest$fgetservice(serviceState).notifyHdmiDeviceRemoved(device);     // Catch: RemoteException -> L12
    L12:
        e = move-exception;
        Slog.e(TAG, "error in notifyHdmiDeviceRemoved", e);
        goto L7
    }

    private void startUser(int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (userId == this.mCurrentUserId) goto L19;
        if (this.mRunningProfiles.contains(Integer.valueOf(userId)) == true) goto L19;
        UserInfo userInfo = this.mUserManager.getUserInfo(userId);     // Catch: Throwable -> L15
        UserInfo parentInfo = this.mUserManager.getProfileParent(userId);     // Catch: Throwable -> L15
        if (userInfo.isProfile() == false) goto L17;
        if (parentInfo == null) goto L17;
        if (parentInfo.id != this.mCurrentUserId) goto L17;
        int prevUserId = this.mCurrentUserId;     // Catch: Throwable -> L15
        this.mCurrentUserId = userId;     // Catch: Throwable -> L15
        releaseSessionOfUserLocked(prevUserId);     // Catch: Throwable -> L15
        cleanUpHdmiDevices(prevUserId);     // Catch: Throwable -> L15
        unbindServiceOfUserLocked(prevUserId);     // Catch: Throwable -> L15
        startProfileLocked(this.mCurrentUserId);     // Catch: Throwable -> L15
    L17:
        monitor-exit(r0);     // Catch: Throwable -> L15
        return;
    L19:
        monitor-exit(r0);     // Catch: Throwable -> L15
    }

    private void stopUser(int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (userId != this.mCurrentUserId) goto L11;
        switchUser(ActivityManager.getCurrentUser());     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        releaseSessionOfUserLocked(userId);     // Catch: Throwable -> L9
        cleanUpHdmiDevices(userId);     // Catch: Throwable -> L9
        unbindServiceOfUserLocked(userId);     // Catch: Throwable -> L9
        this.mRunningProfiles.remove(Integer.valueOf(userId));     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
    }

    private void startProfileLocked(int userId) {
        this.mRunningProfiles.add(Integer.valueOf(userId));
        buildTvInputListLocked(userId, null);
        buildTvContentRatingSystemListLocked(userId);
    }

    private void switchUser(int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mCurrentUserId != userId) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        UserInfo userInfo = this.mUserManager.getUserInfo(userId);     // Catch: Throwable -> L8
        if (userInfo.isProfile() == false) goto L15;
        Slog.w(TAG, "cannot switch to a profile!");     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L15:
        Iterator<Integer> r2 = this.mRunningProfiles.iterator();     // Catch: Throwable -> L8
    L17:
        if (r2.hasNext() == false) goto L19;
        int runningId = r2.next().intValue();     // Catch: Throwable -> L8
        releaseSessionOfUserLocked(runningId);     // Catch: Throwable -> L8
        unbindServiceOfUserLocked(runningId);     // Catch: Throwable -> L8
        goto L17
    L19:
        this.mRunningProfiles.clear();     // Catch: Throwable -> L8
        int prevUserId = this.mCurrentUserId;     // Catch: Throwable -> L8
        this.mCurrentUserId = userId;     // Catch: Throwable -> L8
        releaseSessionOfUserLocked(prevUserId);     // Catch: Throwable -> L8
        cleanUpHdmiDevices(prevUserId);     // Catch: Throwable -> L8
        unbindServiceOfUserLocked(prevUserId);     // Catch: Throwable -> L8
        buildTvInputListLocked(this.mCurrentUserId, null);     // Catch: Throwable -> L8
        buildTvContentRatingSystemListLocked(this.mCurrentUserId);     // Catch: Throwable -> L8
        this.mMessageHandler.obtainMessage(3, getContentResolverForUser(this.mCurrentUserId)).sendToTarget();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
    }

    private void releaseSessionOfUserLocked(int userId) {
        UserState userState = getUserStateLocked(userId);
        if (userState != null) goto L5;
        return;
    L5:
        List<SessionState> sessionStatesToRelease = new ArrayList();
        Iterator r2 = UserState.m8870$$Nest$fgetsessionStateMap(userState).values().iterator();
    L7:
        if (r2.hasNext() == false) goto L14;
        SessionState sessionState = (SessionState) r2.next();
        if (SessionState.m8840$$Nest$fgetsession(sessionState) == null) goto L7;
        if (SessionState.m8837$$Nest$fgetisRecordingSession(sessionState) == true) goto L7;
        sessionStatesToRelease.add(sessionState);
        goto L7
    L14:
        boolean notifyInfoUpdated = false;
        Iterator<SessionState> r3 = sessionStatesToRelease.iterator();
    L16:
        if (r3.hasNext() == false) goto L36;
        SessionState sessionState2 = r3.next();
        SessionState.m8840$$Nest$fgetsession(sessionState2).release();     // Catch: Throwable -> L22 RemoteException -> L24
        SessionState.m8845$$Nest$fputcurrentChannel(sessionState2, null);     // Catch: Throwable -> L22 RemoteException -> L24
        if (SessionState.m8835$$Nest$fgetisCurrent(sessionState2) == false) goto L26;
        SessionState.m8847$$Nest$fputisCurrent(sessionState2, false);     // Catch: Throwable -> L22 RemoteException -> L24
        notifyInfoUpdated = true;
        goto L26
    L26:
        if (notifyInfoUpdated == false) goto L32;
    L27:
        notifyCurrentChannelInfosUpdatedLocked(userState);
    L32:
        clearSessionAndNotifyClientLocked(sessionState2);
    L24:
        e = move-exception;
        Slog.e(TAG, "error in release", e);     // Catch: Throwable -> L22
        if (notifyInfoUpdated == false) goto L32;
    L22:
        th = move-exception;
        if (notifyInfoUpdated == false) goto L35;
        notifyCurrentChannelInfosUpdatedLocked(userState);
    L35:
        throw th;
    }

    private void unbindServiceOfUserLocked(int userId) {
        UserState userState = getUserStateLocked(userId);
        if (userState != null) goto L5;
        return;
    L5:
        Iterator<ComponentName> it = UserState.m8869$$Nest$fgetserviceStateMap(userState).keySet().iterator();
    L7:
        if (it.hasNext() == false) goto L18;
        ComponentName component = it.next();
        ServiceState serviceState = (ServiceState) UserState.m8869$$Nest$fgetserviceStateMap(userState).get(component);
        if (serviceState == null) goto L7;
        if (ServiceState.m8822$$Nest$fgetsessionTokens(serviceState).isEmpty() == false) goto L7;
        unbindService(serviceState);
        if (ServiceState.m8818$$Nest$fgetisHardware(serviceState) == false) goto L14;
        ServiceState.m8815$$Nest$fgethardwareInputMap(serviceState).clear();
        ServiceState.m8825$$Nest$fputneedInit(serviceState, true);
        goto L7
    L14:
        it.remove();
        goto L7
    }

    private void clearSessionAndNotifyClientLocked(SessionState state) {
        if (SessionState.m8830$$Nest$fgetclient(state) != null) goto L23;
    L8:
        UserState userState = getOrCreateUserStateLocked(SessionState.m8844$$Nest$fgetuserId(state));
        Iterator r3 = UserState.m8870$$Nest$fgetsessionStateMap(userState).values().iterator();
    L10:
        if (r3.hasNext() == false) goto L19;
        SessionState sessionState = (SessionState) r3.next();
        if (SessionState.m8842$$Nest$fgetsessionToken(state) != SessionState.m8833$$Nest$fgethardwareSessionToken(sessionState)) goto L10;
        releaseSessionLocked(SessionState.m8842$$Nest$fgetsessionToken(sessionState), 1000, SessionState.m8844$$Nest$fgetuserId(state));
        SessionState.m8830$$Nest$fgetclient(sessionState).onSessionReleased(SessionState.m8839$$Nest$fgetseq(sessionState));     // Catch: RemoteException -> L16
    L16:
        e = move-exception;
        Slog.e(TAG, "error in onSessionReleased", e);
        goto L10
    L19:
        removeSessionStateLocked(SessionState.m8842$$Nest$fgetsessionToken(state), SessionState.m8844$$Nest$fgetuserId(state));
        return;
    L23:
        SessionState.m8830$$Nest$fgetclient(state).onSessionReleased(SessionState.m8839$$Nest$fgetseq(state));     // Catch: RemoteException -> L6
    L6:
        e = move-exception;
        Slog.e(TAG, "error in onSessionReleased", e);
        goto L8
    }

    private void removeUser(int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        UserState userState = getUserStateLocked(userId);     // Catch: Throwable -> L8
        if (userState != null) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        boolean notifyInfoUpdated = false;
        Iterator r3 = UserState.m8870$$Nest$fgetsessionStateMap(userState).values().iterator();     // Catch: Throwable -> L8
    L12:
        if (r3.hasNext() == false) goto L35;
        SessionState state = (SessionState) r3.next();     // Catch: Throwable -> L8
        if (SessionState.m8840$$Nest$fgetsession(state) == null) goto L12;
        SessionState.m8840$$Nest$fgetsession(state).release();     // Catch: Throwable -> L19 RemoteException -> L21
        SessionState.m8845$$Nest$fputcurrentChannel(state, null);     // Catch: Throwable -> L19 RemoteException -> L21
        if (SessionState.m8835$$Nest$fgetisCurrent(state) == false) goto L23;
        SessionState.m8847$$Nest$fputisCurrent(state, false);     // Catch: Throwable -> L19 RemoteException -> L21
        notifyInfoUpdated = true;
        goto L23
    L23:
        if (notifyInfoUpdated == false) goto L12;
    L24:
        notifyCurrentChannelInfosUpdatedLocked(userState);     // Catch: Throwable -> L8
        goto L12
    L19:
        th = move-exception;
        if (notifyInfoUpdated == false) goto L33;
        notifyCurrentChannelInfosUpdatedLocked(userState);     // Catch: Throwable -> L8
    L33:
        throw th;     // Catch: Throwable -> L8
    L21:
        e = move-exception;
        Slog.e(TAG, "error in release", e);     // Catch: Throwable -> L19
        if (notifyInfoUpdated == false) goto L12;
    L35:
        UserState.m8870$$Nest$fgetsessionStateMap(userState).clear();     // Catch: Throwable -> L8
        Iterator r4 = UserState.m8869$$Nest$fgetserviceStateMap(userState).values().iterator();     // Catch: Throwable -> L8
    L37:
        if (r4.hasNext() == false) goto L42;
        ServiceState serviceState = (ServiceState) r4.next();     // Catch: Throwable -> L8
        if (ServiceState.m8821$$Nest$fgetservice(serviceState) == null) goto L37;
        unbindService(serviceState);     // Catch: Throwable -> L8
        goto L37
    L42:
        UserState.m8869$$Nest$fgetserviceStateMap(userState).clear();     // Catch: Throwable -> L8
        UserState.m8862$$Nest$fgetinputMap(userState).clear();     // Catch: Throwable -> L8
        UserState.m8867$$Nest$fgetpackageSet(userState).clear();     // Catch: Throwable -> L8
        UserState.m8861$$Nest$fgetcontentRatingSystemList(userState).clear();     // Catch: Throwable -> L8
        UserState.m8860$$Nest$fgetclientStateMap(userState).clear();     // Catch: Throwable -> L8
        UserState.m8864$$Nest$fgetmCallbacks(userState).kill();     // Catch: Throwable -> L8
        UserState.m8873$$Nest$fputmainSessionToken(userState, null);     // Catch: Throwable -> L8
        this.mRunningProfiles.remove(Integer.valueOf(userId));     // Catch: Throwable -> L8
        this.mUserStates.remove(userId);     // Catch: Throwable -> L8
        if (userId != this.mCurrentUserId) goto L45;
        switchUser(0);     // Catch: Throwable -> L8
    L45:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private ContentResolver getContentResolverForUser(int userId) {
        UserHandle user = new UserHandle(userId);
        Context context = this.mContext.createPackageContextAsUser(PackageManagerService.PLATFORM_PACKAGE_NAME, 0, user);     // Catch: PackageManager.NameNotFoundException -> L5
    L8:
        return context.getContentResolver();
    L6:
        Slog.e(TAG, "failed to create package context as user " + user);
        context = this.mContext;
        goto L8
    }

    private UserState getOrCreateUserStateLocked(int userId) {
        UserState userState = getUserStateLocked(userId);
        if (userState != null) goto L6;
        UserState userState2 = new UserState(this, this.mContext, userId, null);
        this.mUserStates.put(userId, userState2);
        return userState2;
    L6:
        return userState;
    }

    private ServiceState getServiceStateLocked(ComponentName component, int userId) {
        UserState userState = getOrCreateUserStateLocked(userId);
        ServiceState serviceState = (ServiceState) UserState.m8869$$Nest$fgetserviceStateMap(userState).get(component);
        if (serviceState == null) goto L6;
        return serviceState;
    L6:
        throw new IllegalStateException("Service state not found for " + component + " (userId=" + userId + ")");
    }

    private SessionState getSessionStateLocked(IBinder sessionToken, int callingUid, int userId) {
        UserState userState = getOrCreateUserStateLocked(userId);
        return getSessionStateLocked(sessionToken, callingUid, userState);
    }

    private SessionState getSessionStateLocked(IBinder sessionToken, int callingUid, UserState userState) {
        SessionState sessionState = (SessionState) UserState.m8870$$Nest$fgetsessionStateMap(userState).get(sessionToken);
        if (sessionState == null) goto L13;
        if (callingUid != 1000) goto L7;
    L11:
        return sessionState;
    L7:
        if (callingUid == SessionState.m8829$$Nest$fgetcallingUid(sessionState)) goto L11;
        throw new SecurityException("Illegal access to the session with token " + sessionToken + " from uid " + callingUid);
    L13:
        throw new SessionNotFoundException("Session state not found for token " + sessionToken);
    }

    private ITvInputSession getSessionLocked(IBinder sessionToken, int callingUid, int userId) {
        return getSessionLocked(getSessionStateLocked(sessionToken, callingUid, userId));
    }

    private ITvInputSession getSessionLocked(SessionState sessionState) {
        ITvInputSession session = SessionState.m8840$$Nest$fgetsession(sessionState);
        if (session == null) goto L6;
        return session;
    L6:
        throw new IllegalStateException("Session not yet created for token " + SessionState.m8842$$Nest$fgetsessionToken(sessionState));
    }

    private int resolveCallingUserId(int callingPid, int callingUid, int requestedUserId, String methodName) {
        return ActivityManager.handleIncomingUser(callingPid, callingUid, requestedUserId, false, false, methodName, null);
    }

    private void updateServiceConnectionLocked(ComponentName component, int userId) {
        UserState userState = getOrCreateUserStateLocked(userId);
        ServiceState serviceState = (ServiceState) UserState.m8869$$Nest$fgetserviceStateMap(userState).get(component);
        if (serviceState != null) goto L5;
        return;
    L5:
        boolean r3 = false;
        if (ServiceState.m8820$$Nest$fgetreconnecting(serviceState) == false) goto L12;
        if (ServiceState.m8822$$Nest$fgetsessionTokens(serviceState).isEmpty() == true) goto L10;
        return;
    L10:
        ServiceState.m8826$$Nest$fputreconnecting(serviceState, false);
    L12:
        if (userId == this.mCurrentUserId) goto L18;
        if (this.mRunningProfiles.contains(Integer.valueOf(userId)) == true) goto L18;
        boolean shouldBind = !ServiceState.m8822$$Nest$fgetsessionTokens(serviceState).isEmpty();
    L25:
        if (shouldBind == true) goto L27;
    L29:
        if (shouldBind == false) goto L31;
        return;
    L31:
        if (ServiceState.m8810$$Nest$fgetbound(serviceState) == false) goto L38;
        unbindService(serviceState);
        if (ServiceState.m8818$$Nest$fgetisHardware(serviceState) == true) goto L39;
        UserState.m8869$$Nest$fgetserviceStateMap(userState).remove(component);
        return;
    L39:
        return;
    L38:
        return;
    L27:
        if (ServiceState.m8810$$Nest$fgetbound(serviceState) == true) goto L29;
        bindService(serviceState, userId);
        return;
    L18:
        if (ServiceState.m8822$$Nest$fgetsessionTokens(serviceState).isEmpty() == true) goto L20;
    L23:
        r3 = true;
    L24:
        shouldBind = r3;
        goto L25
    L20:
        if (ServiceState.m8818$$Nest$fgetisHardware(serviceState) == false) goto L24;
        if (ServiceState.m8819$$Nest$fgetneedInit(serviceState) == false) goto L24;
        goto L23
    }

    private boolean isServiceSingleUser(ComponentName component) {
        ServiceInfo serviceInfo = getContext().getPackageManager().getServiceInfo(component, 0);     // Catch: PackageManager.NameNotFoundException -> L8
        if ((serviceInfo.flags & 1073741824) == 0) goto L13;
        return true;
    L13:
        return false;
    L8:
        e = move-exception;
        Slog.e(TAG, "Service not found: " + component, e);
        return false;
    }

    private void abortPendingCreateSessionRequestsLocked(ServiceState serviceState, String inputId, int userId) {
        UserState userState = getOrCreateUserStateLocked(userId);
        List<SessionState> sessionsToAbort = new ArrayList();
        Iterator r2 = ServiceState.m8822$$Nest$fgetsessionTokens(serviceState).iterator();
    L4:
        if (r2.hasNext() == false) goto L12;
        IBinder sessionToken = (IBinder) r2.next();
        SessionState sessionState = (SessionState) UserState.m8870$$Nest$fgetsessionStateMap(userState).get(sessionToken);
        if (SessionState.m8840$$Nest$fgetsession(sessionState) != null) goto L4;
        if (inputId == null) goto L10;
        if (SessionState.m8834$$Nest$fgetinputId(sessionState).equals(inputId) == false) goto L4;
    L10:
        sessionsToAbort.add(sessionState);
        goto L4
    L12:
        Iterator<SessionState> r3 = sessionsToAbort.iterator();
    L14:
        if (r3.hasNext() == false) goto L17;
        SessionState sessionState2 = r3.next();
        removeSessionStateLocked(SessionState.m8842$$Nest$fgetsessionToken(sessionState2), SessionState.m8844$$Nest$fgetuserId(sessionState2));
        sendSessionTokenToClientLocked(SessionState.m8830$$Nest$fgetclient(sessionState2), SessionState.m8834$$Nest$fgetinputId(sessionState2), null, null, SessionState.m8839$$Nest$fgetseq(sessionState2));
        goto L14
    L17:
        if (ServiceState.m8818$$Nest$fgetisHardware(serviceState) == true) goto L19;
    L22:
        updateServiceConnectionLocked(ServiceState.m8812$$Nest$fgetcomponent(serviceState), userId);
        return;
    L19:
        if (ServiceState.m8820$$Nest$fgetreconnecting(serviceState) == true) goto L22;
        updateHardwareServiceConnectionDelayed(userId);
    }

    private boolean createSessionInternalLocked(ITvInputService service, IBinder sessionToken, int userId) {
        UserState userState = getOrCreateUserStateLocked(userId);
        SessionState sessionState = (SessionState) UserState.m8870$$Nest$fgetsessionStateMap(userState).get(sessionToken);
        InputChannel[] channels = InputChannel.openInputChannelPair(sessionToken.toString());
        SessionCallback r0 = new SessionCallback(this, sessionState, channels);
        boolean created = true;
    L8:
        e = e;
    L14:
        Slog.e(TAG, "error in createSession", e);
        sendSessionTokenToClientLocked(SessionState.m8830$$Nest$fgetclient(sessionState), SessionState.m8834$$Nest$fgetinputId(sessionState), null, null, SessionState.m8839$$Nest$fgetseq(sessionState));
        created = false;
    L15:
        channels[1].dispose();
        return created;
    L4:
        if (SessionState.m8837$$Nest$fgetisRecordingSession(sessionState) == true) goto L17;
        service.createSession(channels[1], r0, SessionState.m8834$$Nest$fgetinputId(sessionState), SessionState.m8841$$Nest$fgetsessionId(sessionState), SessionState.m8843$$Nest$fgettvAppAttributionSource(sessionState));     // Catch: RemoteException -> L8
    L19:
        goto L15
    L17:
        service.createRecordingSession(r0, SessionState.m8834$$Nest$fgetinputId(sessionState), SessionState.m8841$$Nest$fgetsessionId(sessionState));     // Catch: RemoteException -> L8
    L10:
        e = e;
        goto L14
    }

    private void sendSessionTokenToClientLocked(ITvInputClient client, String inputId, IBinder sessionToken, InputChannel channel, int seq) {
        client.onSessionCreated(inputId, sessionToken, channel, seq);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        Slog.e(TAG, "error in onSessionCreated", e);
    }

    private SessionState releaseSessionLocked(IBinder sessionToken, int callingUid, int userId) {
        SessionState sessionState = null;
        sessionState = getSessionStateLocked(sessionToken, callingUid, userId);     // Catch: Throwable -> L8 Throwable -> L10
        UserState userState = getOrCreateUserStateLocked(userId);     // Catch: Throwable -> L8 Throwable -> L10
        if (SessionState.m8840$$Nest$fgetsession(sessionState) != null) goto L6;
    L13:
        SessionState.m8845$$Nest$fputcurrentChannel(sessionState, null);     // Catch: Throwable -> L8 Throwable -> L10
        if (SessionState.m8835$$Nest$fgetisCurrent(sessionState) == false) goto L16;
        SessionState.m8847$$Nest$fputisCurrent(sessionState, false);     // Catch: Throwable -> L8 Throwable -> L10
        notifyCurrentChannelInfosUpdatedLocked(userState);     // Catch: Throwable -> L8 Throwable -> L10
    L16:
        if (sessionState == null) goto L23;
    L17:
        SessionState.m8850$$Nest$fputsession(sessionState, null);
    L23:
        if (this.mOnScreenSessionState != sessionState) goto L25;
        logExternalInputEvent(2, this.mOnScreenInputId, sessionState);
        this.mOnScreenInputId = null;
        this.mOnScreenSessionState = null;
    L25:
        removeSessionStateLocked(sessionToken, userId);
        return sessionState;
    L6:
        if (sessionToken != UserState.m8866$$Nest$fgetmainSessionToken(userState)) goto L12;
        setMainLocked(sessionToken, false, callingUid, userId);     // Catch: Throwable -> L8 Throwable -> L10
    L12:
        SessionState.m8840$$Nest$fgetsession(sessionState).asBinder().unlinkToDeath(sessionState, 0);     // Catch: Throwable -> L8 Throwable -> L10
        SessionState.m8840$$Nest$fgetsession(sessionState).release();     // Catch: Throwable -> L8 Throwable -> L10
    L10:
        e = move-exception;
        Slog.e(TAG, "error in releaseSession", e);     // Catch: Throwable -> L8
        if (sessionState == null) goto L23;
    L8:
        th = move-exception;
        if (sessionState == null) goto L29;
        SessionState.m8850$$Nest$fputsession(sessionState, null);
    L29:
        throw th;
    }

    private void removeSessionStateLocked(IBinder sessionToken, int userId) {
        UserState userState = getOrCreateUserStateLocked(userId);
        if (sessionToken != UserState.m8866$$Nest$fgetmainSessionToken(userState)) goto L5;
        UserState.m8873$$Nest$fputmainSessionToken(userState, null);
    L5:
        SessionState sessionState = (SessionState) UserState.m8870$$Nest$fgetsessionStateMap(userState).remove(sessionToken);
        if (sessionState != null) goto L9;
        Slog.e(TAG, "sessionState null, no more remove session action!");
        return;
    L9:
        ClientState clientState = (ClientState) UserState.m8860$$Nest$fgetclientStateMap(userState).get(SessionState.m8830$$Nest$fgetclient(sessionState).asBinder());
        if (clientState == null) goto L14;
        ClientState.m8808$$Nest$fgetsessionTokens(clientState).remove(sessionToken);
        if (clientState.isEmpty() == false) goto L14;
        UserState.m8860$$Nest$fgetclientStateMap(userState).remove(SessionState.m8830$$Nest$fgetclient(sessionState).asBinder());
        SessionState.m8830$$Nest$fgetclient(sessionState).asBinder().unlinkToDeath(clientState, 0);
    L14:
        this.mSessionIdToSessionStateMap.remove(SessionState.m8841$$Nest$fgetsessionId(sessionState));
        ServiceState serviceState = (ServiceState) UserState.m8869$$Nest$fgetserviceStateMap(userState).get(SessionState.m8831$$Nest$fgetcomponentName(sessionState));
        if (serviceState == null) goto L18;
        ServiceState.m8822$$Nest$fgetsessionTokens(serviceState).remove(sessionToken);
    L18:
        if (ServiceState.m8818$$Nest$fgetisHardware(serviceState) == true) goto L20;
        updateServiceConnectionLocked(SessionState.m8831$$Nest$fgetcomponentName(sessionState), userId);
    L21:
        SomeArgs args = SomeArgs.obtain();
        args.arg1 = sessionToken;
        args.arg2 = Long.valueOf(System.currentTimeMillis());
        this.mMessageHandler.obtainMessage(2, args).sendToTarget();
        return;
    L20:
        updateHardwareServiceConnectionDelayed(userId);
        goto L21
    }

    private void setMainLocked(IBinder sessionToken, boolean isMain, int callingUid, int userId) {
        SessionState sessionState = getSessionStateLocked(sessionToken, callingUid, userId);     // Catch: Throwable -> L5
        if (SessionState.m8833$$Nest$fgethardwareSessionToken(sessionState) == null) goto L7;
        sessionState = getSessionStateLocked(SessionState.m8833$$Nest$fgethardwareSessionToken(sessionState), 1000, userId);     // Catch: Throwable -> L5
    L7:
        ServiceState serviceState = getServiceStateLocked(SessionState.m8831$$Nest$fgetcomponentName(sessionState), userId);     // Catch: Throwable -> L5
        if (ServiceState.m8818$$Nest$fgetisHardware(serviceState) == true) goto L10;
        return;
    L10:
        ITvInputSession session = getSessionLocked(sessionState);     // Catch: Throwable -> L5
        session.setMain(isMain);     // Catch: Throwable -> L5
        if (SessionState.m8836$$Nest$fgetisMainSession(sessionState) == isMain) goto L19;
        UserState userState = getUserStateLocked(userId);     // Catch: Throwable -> L5
        SessionState.m8848$$Nest$fputisMainSession(sessionState, isMain);     // Catch: Throwable -> L5
        notifyCurrentChannelInfosUpdatedLocked(userState);     // Catch: Throwable -> L5
        return;
    L19:
        return;
    L5:
        e = move-exception;
        Slog.e(TAG, "error in setMain", e);
    }

    private void notifyInputAddedLocked(UserState userState, String inputId) {
        int n = UserState.m8864$$Nest$fgetmCallbacks(userState).beginBroadcast();
        int i = 0;
    L3:
        if (i >= n) goto L9;
        UserState.m8864$$Nest$fgetmCallbacks(userState).getBroadcastItem(i).onInputAdded(inputId);     // Catch: RemoteException -> L6
    L8:
        i = i + 1;
    L6:
        e = move-exception;
        Slog.e(TAG, "failed to report added input to callback", e);
        goto L8
    L9:
        UserState.m8864$$Nest$fgetmCallbacks(userState).finishBroadcast();
    }

    private void notifyInputRemovedLocked(UserState userState, String inputId) {
        int n = UserState.m8864$$Nest$fgetmCallbacks(userState).beginBroadcast();
        int i = 0;
    L3:
        if (i >= n) goto L9;
        UserState.m8864$$Nest$fgetmCallbacks(userState).getBroadcastItem(i).onInputRemoved(inputId);     // Catch: RemoteException -> L6
    L8:
        i = i + 1;
    L6:
        e = move-exception;
        Slog.e(TAG, "failed to report removed input to callback", e);
        goto L8
    L9:
        UserState.m8864$$Nest$fgetmCallbacks(userState).finishBroadcast();
    }

    private void notifyInputUpdatedLocked(UserState userState, String inputId) {
        int n = UserState.m8864$$Nest$fgetmCallbacks(userState).beginBroadcast();
        int i = 0;
    L3:
        if (i >= n) goto L9;
        UserState.m8864$$Nest$fgetmCallbacks(userState).getBroadcastItem(i).onInputUpdated(inputId);     // Catch: RemoteException -> L6
    L8:
        i = i + 1;
    L6:
        e = move-exception;
        Slog.e(TAG, "failed to report updated input to callback", e);
        goto L8
    L9:
        UserState.m8864$$Nest$fgetmCallbacks(userState).finishBroadcast();
    }

    private void notifyInputStateChangedLocked(UserState userState, String inputId, int state, ITvInputManagerCallback targetCallback) {
        if (targetCallback != null) goto L17;
        int n = UserState.m8864$$Nest$fgetmCallbacks(userState).beginBroadcast();
        int i = 0;
    L5:
        if (i >= n) goto L11;
        UserState.m8864$$Nest$fgetmCallbacks(userState).getBroadcastItem(i).onInputStateChanged(inputId, state);     // Catch: RemoteException -> L8
    L10:
        i = i + 1;
    L8:
        e = move-exception;
        Slog.e(TAG, "failed to report state change to callback", e);
        goto L10
    L11:
        UserState.m8864$$Nest$fgetmCallbacks(userState).finishBroadcast();
        return;
    L17:
        targetCallback.onInputStateChanged(inputId, state);     // Catch: RemoteException -> L14
        return;
    L14:
        e = move-exception;
        Slog.e(TAG, "failed to report state change to callback", e);
    }

    private void notifyCurrentChannelInfosUpdatedLocked(UserState userState) {
        int n = UserState.m8864$$Nest$fgetmCallbacks(userState).beginBroadcast();
        int i = 0;
    L3:
        if (i >= n) goto L12;
        ITvInputManagerCallback callback = UserState.m8864$$Nest$fgetmCallbacks(userState).getBroadcastItem(i);     // Catch: RemoteException -> L9
        Pair<Integer, Integer> pidUid = (Pair) UserState.m8859$$Nest$fgetcallbackPidUidMap(userState).get(callback);     // Catch: RemoteException -> L9
        if (this.mContext.checkPermission("android.permission.ACCESS_TUNED_INFO", ((Integer) pidUid.first).intValue(), ((Integer) pidUid.second).intValue()) != 0) goto L11;
        List<TunedInfo> infos = getCurrentTunedInfosInternalLocked(userState, ((Integer) pidUid.first).intValue(), ((Integer) pidUid.second).intValue());     // Catch: RemoteException -> L9
        callback.onCurrentTunedInfosUpdated(infos);     // Catch: RemoteException -> L9
    L11:
        i = i + 1;
    L9:
        e = move-exception;
        Slog.e(TAG, "failed to report updated current channel infos to callback", e);
        goto L11
    L12:
        UserState.m8864$$Nest$fgetmCallbacks(userState).finishBroadcast();
    }

    private void updateTvInputInfoLocked(UserState userState, TvInputInfo inputInfo) {
        String inputId = inputInfo.getId();
        TvInputState inputState = (TvInputState) UserState.m8862$$Nest$fgetinputMap(userState).get(inputId);
        if (inputState != null) goto L6;
        Slog.e(TAG, "failed to set input info - unknown input id " + inputId);
        return;
    L6:
        boolean currentCecTvInputInfoUpdated = isCurrentCecTvInputInfoUpdate(userState, inputInfo);
        TvInputState.m8855$$Nest$fputinfo(inputState, inputInfo);
        TvInputState.m8858$$Nest$fputuid(inputState, getInputUid(inputInfo));
        ServiceState serviceState = (ServiceState) UserState.m8869$$Nest$fgetserviceStateMap(userState).get(inputInfo.getComponent());
        if (serviceState != null) goto L9;
    L11:
        if (currentCecTvInputInfoUpdated == false) goto L13;
        logExternalInputEvent(4, this.mOnScreenInputId, this.mOnScreenSessionState);
    L13:
        int n = UserState.m8864$$Nest$fgetmCallbacks(userState).beginBroadcast();
        int i = 0;
    L14:
        if (i >= n) goto L20;
        UserState.m8864$$Nest$fgetmCallbacks(userState).getBroadcastItem(i).onTvInputInfoUpdated(inputInfo);     // Catch: RemoteException -> L17
    L19:
        i = i + 1;
    L17:
        e = move-exception;
        Slog.e(TAG, "failed to report updated input info to callback", e);
        goto L19
    L20:
        UserState.m8864$$Nest$fgetmCallbacks(userState).finishBroadcast();
        return;
    L9:
        if (ServiceState.m8818$$Nest$fgetisHardware(serviceState) == false) goto L11;
        ServiceState.m8815$$Nest$fgethardwareInputMap(serviceState).put(inputInfo.getId(), inputInfo);
        this.mTvInputHardwareManager.updateInputInfo(inputInfo);
        goto L11
    }

    private boolean isCurrentCecTvInputInfoUpdate(UserState userState, TvInputInfo newInputInfo) {
        if (newInputInfo != null) goto L5;
    L32:
        return false;
    L5:
        if (newInputInfo.getId() == null) goto L32;
        if (newInputInfo.getId().equals(this.mOnScreenInputId) == false) goto L32;
        if (newInputInfo.getHdmiDeviceInfo() != null) goto L12;
    L31:
        return false;
    L12:
        if (newInputInfo.getHdmiDeviceInfo().isCecDevice() == false) goto L31;
        TvInputState inputState = (TvInputState) UserState.m8862$$Nest$fgetinputMap(userState).get(this.mOnScreenInputId);
        if (inputState != null) goto L17;
    L30:
        return false;
    L17:
        if (TvInputState.m8851$$Nest$fgetinfo(inputState) == null) goto L30;
        if (TvInputState.m8851$$Nest$fgetinfo(inputState).getHdmiDeviceInfo() != null) goto L22;
    L29:
        return false;
    L22:
        if (TvInputState.m8851$$Nest$fgetinfo(inputState).getHdmiDeviceInfo().isCecDevice() == false) goto L29;
        String newDisplayName = newInputInfo.getHdmiDeviceInfo().getDisplayName();
        String currentDisplayName = TvInputState.m8851$$Nest$fgetinfo(inputState).getHdmiDeviceInfo().getDisplayName();
        int newVendorId = newInputInfo.getHdmiDeviceInfo().getVendorId();
        int currentVendorId = TvInputState.m8851$$Nest$fgetinfo(inputState).getHdmiDeviceInfo().getVendorId();
        if (TextUtils.equals(newDisplayName, currentDisplayName) == false) goto L27;
        if (newVendorId != currentVendorId) goto L27;
        return false;
    L27:
        return true;
    }

    private void setStateLocked(String inputId, int state, int userId) {
        UserState userState = getOrCreateUserStateLocked(userId);
        TvInputState inputState = (TvInputState) UserState.m8862$$Nest$fgetinputMap(userState).get(inputId);
        if (inputState != null) goto L6;
        Slog.e(TAG, "failed to setStateLocked - unknown input id " + inputId);
        return;
    L6:
        ServiceState serviceState = (ServiceState) UserState.m8869$$Nest$fgetserviceStateMap(userState).get(TvInputState.m8851$$Nest$fgetinfo(inputState).getComponent());
        int oldState = TvInputState.m8853$$Nest$fgetstate(inputState);
        TvInputState.m8857$$Nest$fputstate(inputState, state);
        if (serviceState != null) goto L9;
    L11:
        if (oldState != state) goto L13;
        return;
    L13:
        if (inputId.equals(this.mOnScreenInputId) == false) goto L16;
        logExternalInputEvent(3, this.mOnScreenInputId, this.mOnScreenSessionState);
    L28:
        notifyInputStateChangedLocked(userState, inputId, state, null);
        return;
    L16:
        if (this.mOnScreenInputId == null) goto L28;
        TvInputState currentInputState = (TvInputState) UserState.m8862$$Nest$fgetinputMap(userState).get(this.mOnScreenInputId);
        TvInputInfo currentInputInfo = null;
        if (currentInputState == null) goto L20;
        currentInputInfo = TvInputState.m8851$$Nest$fgetinfo(currentInputState);
    L20:
        if (currentInputInfo == null) goto L28;
        if (currentInputInfo.getHdmiDeviceInfo() == null) goto L28;
        if (inputId.equals(currentInputInfo.getParentId()) == false) goto L28;
        logExternalInputEvent(3, inputId, this.mOnScreenSessionState);
        if (state != 1) goto L28;
        this.mOnScreenInputId = currentInputInfo.getParentId();
        goto L28
    L9:
        if (ServiceState.m8820$$Nest$fgetreconnecting(serviceState) == false) goto L11;
    }

    private String getSessionActualInputId(SessionState sessionState) {
        UserState userState = getOrCreateUserStateLocked(SessionState.m8844$$Nest$fgetuserId(sessionState));
        TvInputState tvInputState = (TvInputState) UserState.m8862$$Nest$fgetinputMap(userState).get(SessionState.m8834$$Nest$fgetinputId(sessionState));
        if (tvInputState != null) goto L6;
        Slog.w(TAG, "No TvInputState for sessionState.inputId " + SessionState.m8834$$Nest$fgetinputId(sessionState));
        return SessionState.m8834$$Nest$fgetinputId(sessionState);
    L6:
        TvInputInfo tvInputInfo = TvInputState.m8851$$Nest$fgetinfo(tvInputState);
        if (tvInputInfo != null) goto L10;
        Slog.w(TAG, "TvInputInfo is null for input id " + SessionState.m8834$$Nest$fgetinputId(sessionState));
        return SessionState.m8834$$Nest$fgetinputId(sessionState);
    L10:
        String sessionActualInputId = SessionState.m8834$$Nest$fgetinputId(sessionState);
        switch(tvInputInfo.getType()) {
            case 1007: goto L13;
            default: goto L18;
        };
    L13:
        Map<String, List<String>> hdmiParentInputMap = this.mTvInputHardwareManager.getHdmiParentInputMap();
        if (hdmiParentInputMap.containsKey(SessionState.m8834$$Nest$fgetinputId(sessionState)) == false) goto L17;
        List<String> parentInputList = hdmiParentInputMap.get(SessionState.m8834$$Nest$fgetinputId(sessionState));
        return parentInputList.get(0);
    L17:
        return sessionActualInputId;
    L18:
        return sessionActualInputId;
    }

    private static TvInputState getTvInputState(SessionState sessionState, UserState userState) {
        if (userState != null) goto L4;
        return null;
    L4:
        return (TvInputState) UserState.m8862$$Nest$fgetinputMap(userState).get(SessionState.m8834$$Nest$fgetinputId(sessionState));
    }

    private List<TunedInfo> getCurrentTunedInfosInternalLocked(UserState userState, int callingPid, int callingUid) {
        List<TunedInfo> channelInfos = new ArrayList();
        boolean watchedProgramsAccess = hasAccessWatchedProgramsPermission(callingPid, callingUid);
        Iterator r5 = UserState.m8870$$Nest$fgetsessionStateMap(userState).values().iterator();
    L4:
        if (r5.hasNext() == false) goto L28;
        SessionState state = (SessionState) r5.next();
        if (SessionState.m8835$$Nest$fgetisCurrent(state) == false) goto L4;
        if (SessionState.m8829$$Nest$fgetcallingUid(state) != callingUid) goto L10;
        Integer appTag = 0;
        int appType = 1;
    L19:
        String r12 = SessionState.m8834$$Nest$fgetinputId(state);
        if (watchedProgramsAccess == false) goto L23;
        Uri r8 = SessionState.m8832$$Nest$fgetcurrentChannel(state);
    L24:
        channelInfos.add(new TunedInfo(r12, r8, SessionState.m8837$$Nest$fgetisRecordingSession(state), SessionState.m8838$$Nest$fgetisVisible(state), SessionState.m8836$$Nest$fgetisMainSession(state), appType, appTag.intValue()));
        goto L4
    L23:
        r8 = null;
        goto L24
    L10:
        appTag = (Integer) UserState.m8863$$Nest$fgetmAppTagMap(userState).get(Integer.valueOf(SessionState.m8829$$Nest$fgetcallingUid(state)));
        if (appTag != null) goto L15;
        int r9 = UserState.m8865$$Nest$fgetmNextAppTag(userState);
        UserState.m8872$$Nest$fputmNextAppTag(userState, r9 + 1);
        appTag = Integer.valueOf(r9);
        UserState.m8863$$Nest$fgetmAppTagMap(userState).put(Integer.valueOf(SessionState.m8829$$Nest$fgetcallingUid(state)), appTag);
    L15:
        if (isSystemApp(SessionState.m8831$$Nest$fgetcomponentName(state).getPackageName()) == false) goto L17;
        int r10 = 2;
    L18:
        appType = r10;
        goto L19
    L17:
        r10 = 3;
        goto L18
    L28:
        return channelInfos;
    }

    private boolean hasAccessWatchedProgramsPermission(int callingPid, int callingUid) {
        if (this.mContext.checkPermission(PERMISSION_ACCESS_WATCHED_PROGRAMS, callingPid, callingUid) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean isSystemApp(String pkg) {
        if ((this.mContext.getPackageManager().getApplicationInfo(pkg, 0).flags & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    L9:
        return false;
    }

    private void logTuneStateChanged(int state, SessionState sessionState, TvInputState inputState) {
        int tisUid = -1;
        if (inputState == null) goto L11;
        tisUid = TvInputState.m8854$$Nest$fgetuid(inputState);
        int inputType = TvInputState.m8851$$Nest$fgetinfo(inputState).getType();
        if (inputType != 0) goto L7;
        inputType = 1;
    L7:
        int inputId = TvInputState.m8852$$Nest$fgetinputNumber(inputState);
        HdmiDeviceInfo hdmiDeviceInfo = TvInputState.m8851$$Nest$fgetinfo(inputState).getHdmiDeviceInfo();
        if (hdmiDeviceInfo == null) goto L10;
        int hdmiPort = hdmiDeviceInfo.getPortId();
        int inputType2 = inputType;
        int inputId2 = inputId;
        int hdmiPort2 = hdmiPort;
    L12:
        int inputType3 = SessionState.m8829$$Nest$fgetcallingUid(sessionState);
        FrameworkStatsLog.write(327, new int[]{inputType3, tisUid}, new String[]{"tif_player", "tv_input_service"}, state, SessionState.m8841$$Nest$fgetsessionId(sessionState), inputType2, inputId2, hdmiPort2);
        return;
    L10:
        inputType2 = inputType;
        inputId2 = inputId;
        hdmiPort2 = 0;
        goto L12
    L11:
        inputType2 = 0;
        inputId2 = 0;
        hdmiPort2 = 0;
        goto L12
    }

    private void logExternalInputEvent(int eventType, String inputId, SessionState sessionState) {
        String inputId2 = inputId;
        UserState userState = getOrCreateUserStateLocked(SessionState.m8844$$Nest$fgetuserId(sessionState));
        TvInputState tvInputState = (TvInputState) UserState.m8862$$Nest$fgetinputMap(userState).get(inputId2);
        if (tvInputState != null) goto L5;
        Slog.w(TAG, "Cannot find input state for input id " + inputId2);
        inputId2 = SessionState.m8834$$Nest$fgetinputId(sessionState);
        tvInputState = (TvInputState) UserState.m8862$$Nest$fgetinputMap(userState).get(inputId2);
    L5:
        if (tvInputState != null) goto L8;
        Slog.w(TAG, "Cannot find input state for sessionState.inputId " + inputId2);
        return;
    L8:
        TvInputInfo tvInputInfo = TvInputState.m8851$$Nest$fgetinfo(tvInputState);
        if (tvInputInfo != null) goto L12;
        Slog.w(TAG, "TvInputInfo is null for input id " + inputId2);
        return;
    L12:
        int inputState = TvInputState.m8853$$Nest$fgetstate(tvInputState);
        int inputType = tvInputInfo.getType();
        String displayName = tvInputInfo.loadLabel(this.mContext).toString();
        String tifSessionId = SessionState.m8841$$Nest$fgetsessionId(sessionState);
        if (tvInputInfo.getType() != 1007) goto L23;
        HdmiDeviceInfo hdmiDeviceInfo = tvInputInfo.getHdmiDeviceInfo();
        if (hdmiDeviceInfo == null) goto L23;
        int hdmiPort = hdmiDeviceInfo.getPortId();
        if (hdmiDeviceInfo.isCecDevice() == false) goto L22;
        String displayName2 = hdmiDeviceInfo.getDisplayName();
        if (this.mExternalInputLoggingDisplayNameFilterEnabled == false) goto L21;
        displayName2 = filterExternalInputLoggingDisplayName(displayName2);
    L21:
        int vendorId = hdmiDeviceInfo.getVendorId();
        String displayName3 = displayName2;
        int vendorId2 = vendorId;
        int hdmiPort2 = hdmiPort;
    L24:
        FrameworkStatsLog.write(FrameworkStatsLog.EXTERNAL_TV_INPUT_EVENT, eventType, inputState, inputType, vendorId2, hdmiPort2, tifSessionId, displayName3);
        return;
    L22:
        displayName3 = displayName;
        vendorId2 = 16777215;
        hdmiPort2 = hdmiPort;
    L23:
        displayName3 = displayName;
        vendorId2 = 16777215;
        hdmiPort2 = -1;
        goto L24
    }

    private String filterExternalInputLoggingDisplayName(String displayName) {
        if (displayName != null) goto L6;
        return "NULL_DISPLAY_NAME";
    L6:
        if (this.mExternalInputLoggingDeviceOnScreenDisplayNames.contains(displayName) == false) goto L8;
        return displayName;
    L8:
        Iterator<String> r2 = this.mExternalInputLoggingDeviceBrandNames.iterator();
    L10:
        if (r2.hasNext() == false) goto L15;
        String brandName = r2.next();
        if (displayName.toUpperCase().contains(brandName.toUpperCase()) == false) goto L10;
        return brandName;
    L15:
        return "FILTERED_DISPLAY_NAME";
    }

    private void bindService(ServiceState serviceState, int userId) {
        if (ServiceState.m8810$$Nest$fgetbound(serviceState) == true) goto L5;
        int bindUserId = userId;
        if (isServiceSingleUser(ServiceState.m8812$$Nest$fgetcomponent(serviceState)) == false) goto L11;
        bindUserId = 0;
    L11:
        Intent i = new Intent("android.media.tv.TvInputService").setComponent(ServiceState.m8812$$Nest$fgetcomponent(serviceState));
        ServiceState.m8823$$Nest$fputbound(serviceState, this.mContext.bindServiceAsUser(i, ServiceState.m8813$$Nest$fgetconnection(serviceState), 33554433, new UserHandle(bindUserId)));
        if (ServiceState.m8810$$Nest$fgetbound(serviceState) == true) goto L16;
        Slog.e(TAG, "failed to bind " + ServiceState.m8812$$Nest$fgetcomponent(serviceState) + " for userId " + userId);
        this.mContext.unbindService(ServiceState.m8813$$Nest$fgetconnection(serviceState));
        return;
    L16:
        return;
    L5:
        if (ServiceState.m8818$$Nest$fgetisHardware(serviceState) == false) goto L15;
        updateHardwareServiceConnectionDelayed(userId);
        return;
    }

    private void unbindService(ServiceState serviceState) {
        if (serviceState != null) goto L4;
        return;
    L4:
        if (ServiceState.m8810$$Nest$fgetbound(serviceState) == true) goto L7;
        return;
    L7:
        if (ServiceState.m8811$$Nest$fgetcallback(serviceState) != null) goto L15;
    L12:
        this.mContext.unbindService(ServiceState.m8813$$Nest$fgetconnection(serviceState));
        ServiceState.m8823$$Nest$fputbound(serviceState, false);
        ServiceState.m8827$$Nest$fputservice(serviceState, null);
        ServiceState.m8824$$Nest$fputcallback(serviceState, null);
        return;
    L15:
        ServiceState.m8821$$Nest$fgetservice(serviceState).unregisterCallback(ServiceState.m8811$$Nest$fgetcallback(serviceState));     // Catch: RemoteException -> L10
    L10:
        e = move-exception;
        Slog.e(TAG, "error in unregisterCallback", e);
        goto L12
    }

    private void updateHardwareTvInputServiceBindingLocked(int userId) {
        PackageManager pm = this.mContext.getPackageManager();
        List<ResolveInfo> services = pm.queryIntentServicesAsUser(new Intent("android.media.tv.TvInputService"), 132, userId);
        Iterator<ResolveInfo> r2 = services.iterator();
    L4:
        if (r2.hasNext() == false) goto L14;
        ResolveInfo ri = r2.next();
        ServiceInfo si = ri.serviceInfo;
        if ("android.permission.BIND_TV_INPUT".equals(si.permission) == false) goto L4;
        ComponentName component = new ComponentName(si.packageName, si.name);
        if (hasAlwaysBoundPermission(pm, component) == true) goto L4;
        if (hasHardwarePermission(pm, component) == false) goto L4;
        updateServiceConnectionLocked(component, userId);
        goto L4
    }

    private void updateHardwareServiceConnectionDelayed(int userId) {
        this.mMessageHandler.removeMessages(4);
        SomeArgs args = SomeArgs.obtain();
        args.arg1 = Integer.valueOf(userId);
        Message msg = this.mMessageHandler.obtainMessage(4, args);
        this.mMessageHandler.sendMessageDelayed(msg, JobStatus.DEFAULT_TRIGGER_UPDATE_DELAY);
    }

    private void addHardwareInputLocked(TvInputInfo inputInfo, ComponentName component, int userId) {
        ServiceState serviceState = getServiceStateLocked(component, userId);
        ServiceState.m8815$$Nest$fgethardwareInputMap(serviceState).put(inputInfo.getId(), inputInfo);
        setPictureProfileLocked(inputInfo.getId());
        buildTvInputListLocked(userId, null);
    }

    private void setPictureProfileLocked(String inputId) {
        if (this.mMediaQualityManager != null) goto L7;
        this.mMediaQualityManager = (MediaQualityManager) getContext().getSystemService("media_quality");
        if (this.mMediaQualityManager != null) goto L7;
        return;
    L7:
        long profileHandle = this.mMediaQualityManager.getPictureProfileForTvInput(inputId);
        this.mTvInputHardwareManager.setPictureProfile(inputId, profileHandle);
    }

    private void removeHardwareInputLocked(String inputId, int userId) {
        if (this.mTvInputHardwareManager.getInputMap().containsKey(inputId) == true) goto L5;
        return;
    L5:
        ComponentName component = this.mTvInputHardwareManager.getInputMap().get(inputId).getComponent();
        ServiceState serviceState = getServiceStateLocked(component, userId);
        ServiceState.m8815$$Nest$fgethardwareInputMap(serviceState).remove(inputId);
        buildTvInputListLocked(userId, null);
        this.mTvInputHardwareManager.removeHardwareInput(inputId);
    }

    static int getVideoUnavailableReasonForStatsd(int reason) {
        int loggedReason = reason + 100;
        if (loggedReason >= 100) goto L5;
    L6:
        return 100;
    L5:
        if (loggedReason > 118) goto L6;
        return loggedReason;
    }

    private UserState getUserStateLocked(int userId) {
        return this.mUserStates.get(userId);
    }

    private void assertTvAsCecActiveSourceLocked() {
        if (this.mHdmiTvClient != null) goto L6;
        Slog.w(TAG, "HdmiTvClient is null!");
        return;
    L6:
        this.mHdmiTvClient.selectDevice(0, this.mContext.getMainExecutor(), new AnonymousClass3(this));
    }
}
