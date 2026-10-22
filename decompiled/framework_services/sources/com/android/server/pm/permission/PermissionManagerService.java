package com.android.server.pm.permission;

import android.app.ActivityManager;
import android.app.AppOpsManager;
import android.app.IActivityManager;
import android.content.AttributionSource;
import android.content.AttributionSourceState;
import android.content.Context;
import android.content.pm.FeatureInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManagerInternal;
import android.content.pm.ParceledListSlice;
import android.content.pm.PermissionGroupInfo;
import android.content.pm.PermissionInfo;
import android.content.pm.permission.SplitPermissionInfoParcelable;
import android.health.connect.HealthConnectManager;
import android.os.Binder;
import android.os.IBinder;
import android.os.Process;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.UserHandle;
import android.permission.IOnPermissionsChangeListener;
import android.permission.IPermissionChecker;
import android.permission.IPermissionManager;
import android.permission.PermissionManager;
import android.permission.PermissionManagerInternal;
import android.pico.utils.ExtImplFactory;
import android.service.voice.VoiceInteractionManagerInternal;
import android.util.ArrayMap;
import android.util.Slog;
import android.util.SparseArray;
import com.android.internal.util.ArrayUtils;
import com.android.internal.util.Preconditions;
import com.android.server.LocalServices;
import com.android.server.companion.virtual.VirtualDeviceManagerInternal;
import com.android.server.pm.PackageManagerService;
import com.android.server.pm.UserManagerService;
import com.android.server.pm.pkg.AndroidPackage;
import com.android.server.pm.pkg.PackageState;
import com.obric.utils.ObricImplFactory;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public class PermissionManagerService extends IPermissionManager.Stub {
    private static final String LOG_TAG = null;
    private static final ConcurrentHashMap<IBinder, RegisteredAttribution> sRunningAttributionSources = null;
    private final AppOpsManager mAppOpsManager;
    private final AttributionSourceRegistry mAttributionSourceRegistry;
    private PermissionManagerServiceInternal.CheckPermissionDelegate mCheckPermissionDelegate;
    private final Context mContext;
    private PermissionManagerServiceInternal.HotwordDetectionServiceProvider mHotwordDetectionServiceProvider;
    private IExtPermissionManagerService mIExt;
    private final Object mLock;
    private IObricPermissionManagerService mObricExt;
    private final SparseArray<OneTimePermissionUserManager> mOneTimePermissionUserManagers;
    private final PackageManagerInternal mPackageManagerInt;
    private final PermissionManagerServiceInterface mPermissionManagerServiceImpl;
    private PermissionManagerServiceSmtEx mSmtEx;
    private VirtualDeviceManagerInternal mVirtualDeviceManagerInternal;

    private static final class AttributionSourceRegistry {
        private final WeakHashMap<IBinder, AttributionSource> mAttributions;
        private final Context mContext;
        private final Object mLock;

        AttributionSourceRegistry(Context context) {
            this.mLock = new Object();
            this.mAttributions = new WeakHashMap();
            this.mContext = context;
        }

        public void registerAttributionSource(AttributionSource source) {
            int callingUid = resolveUid(Binder.getCallingUid());
            int sourceUid = resolveUid(source.getUid());
            if (sourceUid != callingUid) goto L5;
        L9:
            PackageManagerInternal packageManagerInternal = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);
            if (callingUid != 1000) goto L12;
            int r3 = sourceUid;
        L13:
            int userId = UserHandle.getUserId(r3);
            if (packageManagerInternal.getPackageUid(source.getPackageName(), 0, userId) != sourceUid) goto L33;
            AttributionSource next = source.getNext();
            if (next != null) goto L18;
        L24:
            Object r5 = this.mLock;
            monitor-enter(r5);
            this.mAttributions.put(source.getToken(), source.withDefaultToken());     // Catch: Throwable -> L29
            monitor-exit(r5);     // Catch: Throwable -> L29
            return;
        L29:
            th = move-exception;
            throw th;
        L18:
            if (next.getNext() == null) goto L24;
            if (isRegisteredAttributionSource(next) == true) goto L24;
            throw new SecurityException("Cannot register forged attribution source:" + source);
        L33:
            throw new SecurityException("Cannot register attribution source for package:" + source.getPackageName() + " from uid:" + callingUid);
        L12:
            r3 = callingUid;
            goto L13
        L5:
            if (this.mContext.checkPermission("android.permission.UPDATE_APP_OPS_STATS", -1, callingUid) == 0) goto L9;
            throw new SecurityException("Cannot register attribution source for uid:" + sourceUid + " from uid:" + callingUid);
        }

        public boolean isRegisteredAttributionSource(AttributionSource source) {
            Object r0 = this.mLock;
            monitor-enter(r0);
            AttributionSource cachedSource = this.mAttributions.get(source.getToken());     // Catch: Throwable -> L9
            if (cachedSource == null) goto L11;
            boolean r2 = cachedSource.equalsExceptToken(source);     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return r2;
        L11:
            monitor-exit(r0);     // Catch: Throwable -> L9
            return false;
        L9:
            th = move-exception;
            throw th;
        }

        public int getRegisteredAttributionSourceCount(int uid) {
            this.mContext.enforceCallingOrSelfPermission("android.permission.UPDATE_APP_OPS_STATS", "getting the number of registered AttributionSources requires UPDATE_APP_OPS_STATS");
            System.gc();
            System.gc();
            Object r0 = this.mLock;
            monitor-enter(r0);
            int numForUid = 0;
            Iterator<Map.Entry<IBinder, AttributionSource>> r2 = this.mAttributions.entrySet().iterator();     // Catch: Throwable -> L12
        L7:
            if (r2.hasNext() == false) goto L14;
            Map.Entry<IBinder, AttributionSource> entry = r2.next();     // Catch: Throwable -> L12
            if (entry.getValue().getUid() != uid) goto L7;
            numForUid = numForUid + 1;     // Catch: Throwable -> L12
            goto L7
        L14:
            monitor-exit(r0);     // Catch: Throwable -> L12
            return numForUid;
        L12:
            th = move-exception;
            throw th;
        }

        private int resolveUid(int uid) {
            VoiceInteractionManagerInternal vimi = (VoiceInteractionManagerInternal) LocalServices.getService(VoiceInteractionManagerInternal.class);
            if (vimi != null) goto L5;
            return uid;
        L5:
            VoiceInteractionManagerInternal.HotwordDetectionServiceIdentity hotwordDetectionServiceIdentity = vimi.getHotwordDetectionServiceIdentity();
            if (hotwordDetectionServiceIdentity != null) goto L8;
        L11:
            return uid;
        L8:
            if (uid != hotwordDetectionServiceIdentity.getIsolatedUid()) goto L11;
            return hotwordDetectionServiceIdentity.getOwnerUid();
        }
    }

    private static final class PermissionCheckerService extends IPermissionChecker.Stub {
        private static final AtomicInteger sAttributionChainIds = null;
        private static final ConcurrentHashMap<String, PermissionInfo> sPlatformPermissions = null;
        private final Context mContext;
        private final PermissionManagerServiceInternal mPermissionManagerServiceInternal;

        /* JADX INFO: renamed from: -$$Nest$smfinishDataDelivery, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m7092$$Nest$smfinishDataDelivery(Context r0, int r1, AttributionSourceState r2, boolean r3) {
            finishDataDelivery(r0, r1, r2, r3);
        }

        static {
            sPlatformPermissions = new ConcurrentHashMap();
            sAttributionChainIds = new AtomicInteger(0);
        }

        PermissionCheckerService(Context context) {
            this.mContext = context;
            this.mPermissionManagerServiceInternal = (PermissionManagerServiceInternal) LocalServices.getService(PermissionManagerServiceInternal.class);
        }

        public int checkPermission(String permission, AttributionSourceState attributionSourceState, String message, boolean forDataDelivery, boolean startDataDelivery, boolean fromDatasource, int attributedOp) {
            permission.getClass();
            attributionSourceState.getClass();
            AttributionSource attributionSource = new AttributionSource(attributionSourceState);
            int result = checkPermission(this.mContext, this.mPermissionManagerServiceInternal, permission, attributionSource, message, forDataDelivery, startDataDelivery, fromDatasource, attributedOp);
            if (startDataDelivery == false) goto L11;
            if (result == 0) goto L11;
            if (result == 1) goto L11;
            if (attributedOp != (-1)) goto L10;
            finishDataDelivery(AppOpsManager.permissionToOpCode(permission), attributionSource.asState(), fromDatasource);
            goto L11
        L10:
            finishDataDelivery(attributedOp, attributionSource.asState(), fromDatasource);
        L11:
            return result;
        }

        public void finishDataDelivery(int op, AttributionSourceState attributionSourceState, boolean fromDataSource) {
            finishDataDelivery(this.mContext, op, attributionSourceState, fromDataSource);
        }

        private static void finishDataDelivery(Context context, int op, AttributionSourceState attributionSourceState, boolean fromDatasource) {
            attributionSourceState.getClass();
            AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService(AppOpsManager.class);
            if (op != (-1)) goto L5;
            return;
        L5:
            AttributionSource current = new AttributionSource(attributionSourceState);
            AttributionSource next = null;
        L6:
            boolean selfAccess = true;
            if (fromDatasource == true) goto L11;
            if (next != null) goto L11;
            boolean skipCurrentFinish = false;
        L12:
            next = current.getNext();
            if (fromDatasource == true) goto L15;
        L16:
            if (next != null) goto L18;
        L20:
            if (fromDatasource == true) goto L22;
        L27:
            boolean singleReceiverFromDatasource = false;
        L29:
            if (singleReceiverFromDatasource == true) goto L33;
            if (next == null) goto L33;
            selfAccess = false;
        L33:
            if (singleReceiverFromDatasource == true) goto L35;
            AttributionSource accessorSource = current;
        L36:
            if (selfAccess == false) goto L41;
            String resolvedPackageName = resolvePackageName(context, accessorSource);
            if (resolvedPackageName == null) goto L39;
            AttributionSource resolvedAccessorSource = accessorSource.withPackageName(resolvedPackageName);
            appOpsManager.finishOp(attributionSourceState.token, op, resolvedAccessorSource);
        L45:
            RegisteredAttribution registered = (RegisteredAttribution) PermissionManagerService.m7091$$Nest$sfgetsRunningAttributionSources().remove(current.getToken());
            if (registered == null) goto L48;
            registered.unregister();
        L48:
            if (next == null) goto L53;
            if (next.getNext() == null) goto L53;
            current = next;
        L53:
            if (next == null) goto L63;
            RegisteredAttribution registered2 = (RegisteredAttribution) PermissionManagerService.m7091$$Nest$sfgetsRunningAttributionSources().remove(next.getToken());
            if (registered2 == null) goto L64;
            registered2.unregister();
            return;
        L64:
            return;
        L63:
            return;
        L39:
            return;
        L41:
            AttributionSource resolvedAttributionSource = resolveAttributionSource(context, accessorSource);
            if (resolvedAttributionSource.getPackageName() == null) goto L43;
            appOpsManager.finishProxyOp(attributionSourceState.token, AppOpsManager.opToPublicName(op), resolvedAttributionSource, skipCurrentFinish);
            goto L45
        L43:
            return;
        L35:
            accessorSource = next;
            goto L36
        L22:
            if (current.asState() != attributionSourceState) goto L27;
            if (next == null) goto L27;
            if (next.getNext() != null) goto L27;
            singleReceiverFromDatasource = true;
            goto L29
        L18:
            if (current.isTrusted(context) == true) goto L20;
            return;
        L15:
            if (current.asState() == attributionSourceState) goto L20;
        L11:
            skipCurrentFinish = true;
            goto L12
        }

        public int checkOp(int op, AttributionSourceState attributionSource, String message, boolean forDataDelivery, boolean startDataDelivery) {
            int result = checkOp(this.mContext, op, this.mPermissionManagerServiceInternal, new AttributionSource(attributionSource), message, forDataDelivery, startDataDelivery);
            if (result == 0) goto L6;
            if (startDataDelivery == false) goto L6;
            finishDataDelivery(op, attributionSource, false);
        L6:
            return result;
        }

        private static int checkPermission(Context context, PermissionManagerServiceInternal permissionManagerServiceInt, String permission, AttributionSource attributionSource, String message, boolean forDataDelivery, boolean startDataDelivery, boolean fromDatasource, int attributedOp) {
            PermissionInfo permissionInfo = sPlatformPermissions.get(permission);
            if (permissionInfo == null) goto L33;
            PermissionInfo permissionInfo2 = permissionInfo;
        L17:
            if (permissionInfo2.isAppOp() == false) goto L21;
            return checkAppOpPermission(context, permissionManagerServiceInt, permission, attributionSource, message, forDataDelivery, fromDatasource);
        L21:
            if (permissionInfo2.isRuntime() == true) goto L23;
            if (fromDatasource == true) goto L29;
            if (checkPermission(context, permissionManagerServiceInt, permission, attributionSource) == true) goto L29;
            return 2;
        L29:
            if (attributionSource.getNext() != null) goto L31;
            return 0;
        L31:
            return checkPermission(context, permissionManagerServiceInt, permission, attributionSource.getNext(), message, forDataDelivery, startDataDelivery, false, attributedOp);
        L23:
            return checkRuntimePermission(context, permissionManagerServiceInt, permission, attributionSource, message, forDataDelivery, startDataDelivery, fromDatasource, attributedOp);
        L33:
            PermissionInfo permissionInfo3 = context.getPackageManager().getPermissionInfo(permission, 0);     // Catch: PackageManager.NameNotFoundException -> L9
            if (PackageManagerService.PLATFORM_PACKAGE_NAME.equals(permissionInfo3.packageName) == false) goto L7;
        L11:
            sPlatformPermissions.put(permission, permissionInfo3);     // Catch: PackageManager.NameNotFoundException -> L9
        L12:
            permissionInfo2 = permissionInfo3;
            goto L17
        L7:
            if (HealthConnectManager.isHealthPermission(context, permission) == false) goto L12;
        L14:
            return 2;
        }

        private static int checkAppOpPermission(Context context, PermissionManagerServiceInternal permissionManagerServiceInt, String permission, AttributionSource attributionSource, String message, boolean forDataDelivery, boolean fromDatasource) {
            int op = AppOpsManager.permissionToOpCode(permission);
            if (op >= 0) goto L6;
            Slog.wtf(PermissionManagerService.m7090$$Nest$sfgetLOG_TAG(), "Appop permission " + permission + " with no app op defined!");
            return 2;
        L6:
            AttributionSource current = attributionSource;
            AttributionSource current2 = null;
        L8:
            if (fromDatasource == true) goto L12;
            if (current2 != null) goto L12;
            boolean skipCurrentChecks = false;
        L13:
            AttributionSource next = current.getNext();
            if (fromDatasource == true) goto L16;
        L17:
            if (next != null) goto L19;
        L21:
            if (fromDatasource == true) goto L23;
        L28:
            boolean singleReceiverFromDatasource = false;
        L30:
            if (singleReceiverFromDatasource == true) goto L34;
            if (next == null) goto L34;
            boolean selfAccess = false;
        L35:
            int opMode = performOpTransaction(context, attributionSource.getToken(), op, current, message, forDataDelivery, false, skipCurrentChecks, selfAccess, singleReceiverFromDatasource, -1, 0, 0, -1);
            switch(opMode) {
                case 1: goto L54;
                case 2: goto L54;
                case 3: goto L38;
                default: goto L47;
            };
        L38:
            if (skipCurrentChecks == false) goto L40;
        L42:
            if (next == null) goto L47;
            if (checkPermission(context, permissionManagerServiceInt, permission, next) == true) goto L47;
            return 2;
        L40:
            if (checkPermission(context, permissionManagerServiceInt, permission, attributionSource) == true) goto L42;
            return 2;
        L47:
            if (next == null) goto L52;
            if (next.getNext() == null) goto L52;
            current = next;
            current2 = next;
        L52:
            return 0;
        L54:
            return 2;
        L34:
            selfAccess = true;
            goto L35
        L23:
            if (current.equals(attributionSource) == false) goto L28;
            if (next == null) goto L28;
            if (next.getNext() != null) goto L28;
            singleReceiverFromDatasource = true;
            goto L30
        L19:
            if (current.isTrusted(context) == true) goto L21;
            return 2;
        L16:
            if (current.equals(attributionSource) == true) goto L21;
        L12:
            skipCurrentChecks = true;
            goto L13
        }

        /* JADX WARN: Multi-variable type inference failed */
        private static int checkRuntimePermission(Context context, PermissionManagerServiceInternal permissionManagerServiceInt, String permission, AttributionSource attributionSource, String message, boolean forDataDelivery, boolean startDataDelivery, boolean fromDatasource, int attributedOp) {
            PermissionManagerServiceInternal r14 = permissionManagerServiceInt;
            String r15 = permission;
            AttributionSource current = attributionSource;
            boolean r4 = startDataDelivery;
            int op = AppOpsManager.permissionToOpCode(r15);
            int attributionChainId = getAttributionChainId(r4, current);
            int r8 = 0;
            if (attributionChainId == (-1)) goto L5;
            boolean r2 = true;
        L6:
            boolean hasChain = r2;
            AttributionSource current2 = attributionSource;
            AttributionSource next = null;
            if (hasChain == true) goto L9;
        L12:
            boolean r6 = true;
        L13:
            boolean isChainStartTrusted = r6;
            AttributionSource prev = null;
        L14:
            if (fromDatasource == true) goto L18;
            if (next != null) goto L18;
            int r5 = r8;
        L19:
            boolean r9 = r5;
            AttributionSource next2 = current2.getNext();
            if (fromDatasource == true) goto L22;
        L24:
            int r3 = r8;
        L26:
            if (r3 != 0) goto L31;
            if (next2 == null) goto L31;
            if (current2.isTrusted(context) == true) goto L31;
            return 2;
        L31:
            if (r9 == 0) goto L33;
        L35:
            if (next2 != null) goto L37;
        L39:
            if (op < 0) goto L41;
            if (fromDatasource == true) goto L52;
        L57:
            int r7 = r8;
        L58:
            boolean r11 = r7;
            if (r11 != 0) goto L63;
            if (next2 == null) goto L63;
            boolean r10 = r8;
        L64:
            if (isChainStartTrusted == true) goto L66;
        L73:
            boolean r12 = r8;
        L75:
            if (r9 != 0) goto L78;
            if (hasChain == false) goto L78;
            int proxyAttributionFlags = resolveProxyAttributionFlags(current, current2, fromDatasource, r4, r10, r12);
        L80:
            if (hasChain == false) goto L82;
            int proxiedAttributionFlags = resolveProxiedAttributionFlags(attributionSource, next2, fromDatasource, startDataDelivery, r10, r12);
            AttributionSource next3 = next2;
        L83:
            int op2 = op;
            int r16 = r8;
            int proxyAttributionFlags2 = proxyAttributionFlags;
            AttributionSource current3 = current2;
            int proxyAttributionFlags3 = proxiedAttributionFlags;
            int opMode = performOpTransaction(context, attributionSource.getToken(), op2, current3, message, forDataDelivery, startDataDelivery, r9, r10, r11, attributedOp, proxyAttributionFlags2, proxyAttributionFlags3, attributionChainId);
            if (startDataDelivery == false) goto L93;
            if (opMode == 0) goto L93;
            if (prev == null) goto L93;
            AttributionSourceState cutAttrSourceState = prev.asState();
            if (cutAttrSourceState.next.length <= 0) goto L90;
            cutAttrSourceState.next[r16].next = new AttributionSourceState[r16];
        L90:
            finishDataDelivery(context, attributedOp, cutAttrSourceState, fromDatasource);
        L93:
            switch(opMode) {
                case 1: goto L108;
                case 2: goto L103;
                default: goto L94;
            };
        L94:
            if (startDataDelivery == false) goto L96;
            RegisteredAttribution registered = new RegisteredAttribution(context, op2, current3, fromDatasource);
            PermissionManagerService.m7091$$Nest$sfgetsRunningAttributionSources().put(current3.getToken(), registered);
        L96:
            if (next3 == null) goto L101;
            if (next3.getNext() == null) goto L101;
            prev = current3;
            r14 = permissionManagerServiceInt;
            r4 = startDataDelivery;
            op = op2;
            r8 = r16;
            next = next3;
            r15 = permission;
            current2 = next3;
            current = attributionSource;
        L101:
            return r16;
        L103:
            if (permission.equals("android.permission.BLUETOOTH_CONNECT") == false) goto L106;
            Slog.e(PermissionManagerService.m7090$$Nest$sfgetLOG_TAG(), "BLUETOOTH_CONNECT permission hard denied as op mode is MODE_ERRORED. Permission check was requested for: " + attributionSource + " and op transaction was invoked for " + current3);
        L106:
            return 2;
        L108:
            return 1;
        L82:
            next3 = next2;
            proxiedAttributionFlags = r8;
        L78:
            proxyAttributionFlags = r8;
            goto L80
        L66:
            if (current2.isTrusted(context) == false) goto L68;
        L69:
            if (next2 != null) goto L71;
        L72:
            r12 = 1;
            goto L75
        L71:
            if (next2.isTrusted(context) == false) goto L73;
        L68:
            if (current2.equals(current) == false) goto L73;
        L63:
            r10 = 1;
            goto L64
        L52:
            if (current2.equals(current) == false) goto L57;
            if (next2 == null) goto L57;
            if (next2.getNext() != null) goto L57;
            r7 = 1;
            goto L58
        L41:
            if (sPlatformPermissions.containsKey(r15) == true) goto L43;
        L47:
            if (next2 == null) goto L48;
            current2 = next2;
            next = next2;
            goto L14
        L48:
            return r8;
        L43:
            if ("android.permission.ACCESS_BACKGROUND_LOCATION".equals(r15) == true) goto L47;
            if ("android.permission.BODY_SENSORS_BACKGROUND".equals(r15) == true) goto L47;
            Slog.wtf(PermissionManagerService.m7090$$Nest$sfgetLOG_TAG(), "Platform runtime permission " + r15 + " with no app op defined!");
            goto L47
        L37:
            if (checkPermission(context, r14, r15, next2) == true) goto L39;
            return 2;
        L33:
            if (checkPermission(context, r14, r15, current2) == true) goto L35;
            return 2;
        L22:
            if (current2.equals(current) == false) goto L24;
            r3 = 1;
        L18:
            r5 = 1;
            goto L19
        L9:
            if (checkPermission(context, r14, "android.permission.UPDATE_APP_OPS_STATS", current2) == true) goto L12;
            r6 = false;
            goto L13
        L5:
            r2 = false;
            goto L6
        }

        private static boolean checkPermission(Context context, PermissionManagerServiceInternal permissionManagerServiceInt, String permission, AttributionSource attributionSource) {
            int uid = attributionSource.getUid();
            int deviceId = attributionSource.getDeviceId();
            if (context.getDeviceId() != deviceId) goto L5;
            Context deviceContext = context;
        L6:
            boolean r5 = true;
            if (deviceContext.checkPermission(permission, -1, uid) != 0) goto L9;
            boolean permissionGranted = true;
        L10:
            if (permissionGranted == false) goto L12;
        L29:
            Set<String> renouncedPermissions = attributionSource.getRenouncedPermissions();
            if (permissionGranted == true) goto L32;
        L36:
            return permissionGranted;
        L32:
            if (renouncedPermissions.contains(permission) == false) goto L36;
            if (deviceContext.checkPermission("android.permission.RENOUNCE_PERMISSIONS", -1, uid) != 0) goto L36;
            return false;
        L12:
            if (Process.isIsolated(uid) == false) goto L29;
            if (permission.equals("android.permission.RECORD_AUDIO") == false) goto L16;
        L22:
            PermissionManagerServiceInternal.HotwordDetectionServiceProvider hotwordServiceProvider = permissionManagerServiceInt.getHotwordDetectionServiceProvider();
            if (hotwordServiceProvider != null) goto L25;
        L27:
            r5 = false;
        L28:
            permissionGranted = r5;
            goto L29
        L25:
            if (uid != hotwordServiceProvider.getUid()) goto L27;
        L16:
            if (permission.equals("android.permission.CAPTURE_AUDIO_HOTWORD") == true) goto L22;
            if (permission.equals("android.permission.CAPTURE_AUDIO_OUTPUT") == true) goto L22;
            if (permission.equals("android.permission.CAMERA") == false) goto L29;
        L9:
            permissionGranted = false;
            goto L10
        L5:
            deviceContext = context.createDeviceContext(deviceId);
            goto L6
        }

        private static int resolveProxyAttributionFlags(AttributionSource attributionChain, AttributionSource current, boolean fromDatasource, boolean startDataDelivery, boolean selfAccess, boolean isTrusted) {
            return resolveAttributionFlags(attributionChain, current, fromDatasource, startDataDelivery, selfAccess, isTrusted, true);
        }

        private static int resolveProxiedAttributionFlags(AttributionSource attributionChain, AttributionSource current, boolean fromDatasource, boolean startDataDelivery, boolean selfAccess, boolean isTrusted) {
            return resolveAttributionFlags(attributionChain, current, fromDatasource, startDataDelivery, selfAccess, isTrusted, false);
        }

        private static int resolveAttributionFlags(AttributionSource attributionChain, AttributionSource current, boolean fromDatasource, boolean startDataDelivery, boolean selfAccess, boolean isTrusted, boolean flagsForProxy) {
            if (current == null) goto L36;
            if (startDataDelivery == false) goto L36;
            if (isTrusted == false) goto L8;
            int trustedFlag = 8;
        L9:
            if (flagsForProxy == false) goto L18;
            if (selfAccess == true) goto L12;
            if (fromDatasource == false) goto L15;
        L30:
            if (fromDatasource == false) goto L35;
            if (current.equals(attributionChain) == false) goto L35;
            return 0;
        L35:
            return trustedFlag | 2;
        L15:
            if (current.equals(attributionChain) == false) goto L30;
            return trustedFlag | 1;
        L12:
            return trustedFlag | 1;
        L18:
            if (selfAccess == true) goto L20;
            if (fromDatasource == false) goto L27;
            if (current.equals(attributionChain.getNext()) == false) goto L27;
            return trustedFlag | 1;
        L27:
            if (current.getNext() != null) goto L30;
            return trustedFlag | 4;
        L20:
            return trustedFlag | 4;
        L8:
            trustedFlag = 0;
        L36:
            return 0;
        }

        private static int checkOp(Context context, int op, PermissionManagerServiceInternal permissionManagerServiceInt, AttributionSource attributionSource, String message, boolean forDataDelivery, boolean startDataDelivery) {
            Context r0 = context;
            AttributionSource r1 = attributionSource;
            if (op >= 0) goto L5;
        L60:
            return 2;
        L5:
            if (r1.getPackageName() == null) goto L60;
            boolean r4 = startDataDelivery;
            int attributionChainId = getAttributionChainId(r4, r1);
            if (attributionChainId == (-1)) goto L10;
            boolean r2 = true;
        L11:
            boolean hasChain = r2;
            AttributionSource current = attributionSource;
            AttributionSource next = null;
            if (hasChain == false) goto L18;
            if (checkPermission(r0, permissionManagerServiceInt, "android.permission.UPDATE_APP_OPS_STATS", current) == true) goto L18;
            boolean r5 = false;
        L19:
            boolean isChainStartTrusted = r5;
        L20:
            if (next == null) goto L22;
            boolean r6 = true;
        L23:
            boolean skipCurrentChecks = r6;
            AttributionSource next2 = current.getNext();
            if (next2 != null) goto L26;
        L28:
            if (next2 != null) goto L30;
            boolean selfAccess = true;
        L31:
            if (isChainStartTrusted == true) goto L33;
        L40:
            boolean isLinkTrusted = false;
        L42:
            if (skipCurrentChecks == true) goto L45;
            if (hasChain == false) goto L45;
            int proxyAttributionFlags = resolveProxyAttributionFlags(r1, current, false, r4, selfAccess, isLinkTrusted);
        L47:
            if (hasChain == false) goto L49;
            AttributionSource next3 = next2;
            int proxiedAttributionFlags = resolveProxiedAttributionFlags(attributionSource, next2, false, startDataDelivery, selfAccess, isLinkTrusted);
        L50:
            int opMode = performOpTransaction(r0, current.getToken(), op, current, message, forDataDelivery, startDataDelivery, skipCurrentChecks, selfAccess, false, -1, proxyAttributionFlags, proxiedAttributionFlags, attributionChainId);
            switch(opMode) {
                case 1: goto L59;
                case 2: goto L58;
                default: goto L52;
            };
        L52:
            if (next3 == null) goto L57;
            if (next3.getNext() == null) goto L57;
            current = next3;
            r0 = context;
            r1 = attributionSource;
            r4 = startDataDelivery;
            next = next3;
        L57:
            return 0;
        L58:
            return 2;
        L59:
            return 1;
        L49:
            next3 = next2;
            proxiedAttributionFlags = 0;
        L45:
            proxyAttributionFlags = 0;
            goto L47
        L33:
            if (current.isTrusted(r0) == false) goto L35;
        L36:
            if (next2 != null) goto L38;
        L39:
            isLinkTrusted = true;
            goto L42
        L38:
            if (next2.isTrusted(r0) == false) goto L40;
        L35:
            if (current.equals(r1) == false) goto L40;
        L30:
            selfAccess = false;
            goto L31
        L26:
            if (current.isTrusted(r0) == true) goto L28;
            return 2;
        L22:
            r6 = false;
        L18:
            r5 = true;
            goto L19
        L10:
            r2 = false;
            goto L11
        }

        private static int performOpTransaction(Context context, IBinder chainStartToken, int op, AttributionSource attributionSource, String message, boolean forDataDelivery, boolean startDataDelivery, boolean skipProxyOperation, boolean selfAccess, boolean singleReceiverFromDatasource, int attributedOp, int proxyAttributionFlags, int proxiedAttributionFlags, int attributionChainId) {
            AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService(AppOpsManager.class);
            if (singleReceiverFromDatasource == true) goto L5;
            AttributionSource r0 = attributionSource;
        L6:
            AttributionSource accessorSource = r0;
            if (forDataDelivery == true) goto L27;
            String resolvedAccessorPackageName = resolvePackageName(context, accessorSource);
            if (resolvedAccessorPackageName != null) goto L11;
            return 2;
        L11:
            AttributionSource resolvedAttributionSource = accessorSource.withPackageName(resolvedAccessorPackageName);
            if (skipProxyOperation == false) goto L15;
            if (singleReceiverFromDatasource == true) goto L15;
            int opMode = 0;
        L16:
            AttributionSource next = accessorSource.getNext();
            if (selfAccess == true) goto L25;
            if (opMode != 0) goto L25;
            if (next == null) goto L25;
            String resolvedNextPackageName = resolvePackageName(context, next);
            if (resolvedNextPackageName != null) goto L23;
            return 2;
        L23:
            AttributionSource resolvedNextAttributionSource = next.withPackageName(resolvedNextPackageName);
            return appOpsManager.unsafeCheckOpRawNoThrow(op, resolvedNextAttributionSource);
        L25:
            return opMode;
        L15:
            opMode = appOpsManager.unsafeCheckOpRawNoThrow(op, resolvedAttributionSource);
            goto L16
        L27:
            if (startDataDelivery == false) goto L55;
            AttributionSource resolvedAttributionSource2 = resolveAttributionSource(context, accessorSource);
            if (resolvedAttributionSource2.getPackageName() != null) goto L31;
            return 2;
        L31:
            int startedOp = op;
            int checkedOpResult = 0;
            if (attributedOp == (-1)) goto L38;
            if (attributedOp == op) goto L38;
            int checkedOpResult2 = appOpsManager.checkOpNoThrow(op, resolvedAttributionSource2);
            if (checkedOpResult2 != 2) goto L37;
            return checkedOpResult2;
        L37:
            startedOp = attributedOp;
            checkedOpResult = checkedOpResult2;
        L38:
            if (selfAccess == true) goto L94;
            int startedOp2 = startedOp;
            int startedOpResult = appOpsManager.startProxyOpNoThrow(chainStartToken, startedOp2, resolvedAttributionSource2, message, skipProxyOperation, proxyAttributionFlags, proxiedAttributionFlags, attributionChainId);     // Catch: SecurityException -> L49
        L48:
            return Math.max(checkedOpResult, startedOpResult);
        L49:
            e = move-exception;
            String msg = "Security exception for op " + startedOp2 + " with source " + attributionSource.getUid() + ":" + attributionSource.getPackageName() + ", " + attributionSource.getNextUid() + ":" + attributionSource.getNextPackageName();
            if (attributionSource.getNext() == null) goto L54;
            AttributionSource next2 = attributionSource.getNext();
            msg = msg + ", " + next2.getNextPackageName() + ":" + next2.getNextUid();
        L54:
            throw new SecurityException(msg + ":" + e.getMessage());
        L94:
            startedOpResult = appOpsManager.startOpNoThrow(chainStartToken, startedOp, resolvedAttributionSource2, false, message, proxyAttributionFlags, attributionChainId);     // Catch: SecurityException -> L42
        L43:
            Slog.w(PermissionManagerService.m7090$$Nest$sfgetLOG_TAG(), "Datasource " + attributionSource + " protecting data with platform defined runtime permission " + AppOpsManager.opToPermission(op) + " while not having android.permission.UPDATE_APP_OPS_STATS");
            startedOpResult = appOpsManager.startProxyOpNoThrow(chainStartToken, attributedOp, attributionSource, message, skipProxyOperation, proxyAttributionFlags, proxiedAttributionFlags, attributionChainId);
            goto L48
        L55:
            AttributionSource resolvedAttributionSource3 = resolveAttributionSource(context, accessorSource);
            if (resolvedAttributionSource3.getPackageName() != null) goto L59;
            return 2;
        L59:
            if (attributedOp == (-1)) goto L66;
            int r10 = op;
            if (attributedOp == r10) goto L67;
            int checkedOpResult3 = appOpsManager.checkOpNoThrow(r10, resolvedAttributionSource3);
            if (checkedOpResult3 != 2) goto L65;
            return checkedOpResult3;
        L65:
            int notedOp = attributedOp;
            int checkedOpResult4 = checkedOpResult3;
        L68:
            if (selfAccess == false) goto L96;
            int notedOpResult = appOpsManager.noteOpNoThrow(notedOp, resolvedAttributionSource3, message);     // Catch: SecurityException -> L71
        L75:
            int result = Math.max(checkedOpResult4, notedOpResult);
            if (r10 == 111) goto L78;
        L83:
            return result;
        L78:
            if (result != 2) goto L83;
            if (result != checkedOpResult4) goto L82;
            Slog.e(PermissionManagerService.m7090$$Nest$sfgetLOG_TAG(), "BLUETOOTH_CONNECT permission hard denied as checkOp for resolvedAttributionSource " + resolvedAttributionSource3 + " and op " + r10 + " returned MODE_ERRORED");
            goto L83
        L82:
            Slog.e(PermissionManagerService.m7090$$Nest$sfgetLOG_TAG(), "BLUETOOTH_CONNECT permission hard denied as noteOp for resolvedAttributionSource " + resolvedAttributionSource3 + " and op " + notedOp + " returned MODE_ERRORED");
        L72:
            Slog.w(PermissionManagerService.m7090$$Nest$sfgetLOG_TAG(), "Datasource " + attributionSource + " protecting data with platform defined runtime permission " + AppOpsManager.opToPermission(r10) + " while not having android.permission.UPDATE_APP_OPS_STATS");
            notedOpResult = appOpsManager.noteProxyOpNoThrow(notedOp, attributionSource, message, skipProxyOperation);
            goto L75
        L96:
            notedOpResult = appOpsManager.noteProxyOpNoThrow(notedOp, resolvedAttributionSource3, message, skipProxyOperation);     // Catch: SecurityException -> L84
        L84:
            e = move-exception;
            String msg2 = "Security exception for op " + notedOp + " with source " + attributionSource.getUid() + ":" + attributionSource.getPackageName() + ", " + attributionSource.getNextUid() + ":" + attributionSource.getNextPackageName();
            if (attributionSource.getNext() == null) goto L89;
            AttributionSource next3 = attributionSource.getNext();
            msg2 = msg2 + ", " + next3.getNextPackageName() + ":" + next3.getNextUid();
        L89:
            throw new SecurityException(msg2 + ":" + e.getMessage());
        L67:
            notedOp = op;
            checkedOpResult4 = 0;
            goto L68
        L66:
            r10 = op;
            goto L67
        L5:
            r0 = attributionSource.getNext();
            goto L6
        }

        private static int getAttributionChainId(boolean startDataDelivery, AttributionSource source) {
            if (source != null) goto L4;
            return -1;
        L4:
            if (source.getNext() == null) goto L14;
            if (startDataDelivery == false) goto L15;
            int attributionChainId = sAttributionChainIds.incrementAndGet();
            if (attributionChainId >= 0) goto L13;
            sAttributionChainIds.set(0);
            return sAttributionChainIds.incrementAndGet();
        L13:
            return attributionChainId;
        L15:
            return -1;
        L14:
            return -1;
        }

        private static String resolvePackageName(Context context, AttributionSource attributionSource) {
            if (attributionSource.getPackageName() != null) goto L5;
            String[] packageNames = context.getPackageManager().getPackagesForUid(attributionSource.getUid());
            if (packageNames == null) goto L11;
            return packageNames[0];
        L11:
            return AppOpsManager.resolvePackageName(attributionSource.getUid(), attributionSource.getPackageName());
        L5:
            return attributionSource.getPackageName();
        }

        private static AttributionSource resolveAttributionSource(Context context, AttributionSource attributionSource) {
            if (attributionSource.getPackageName() == null) goto L6;
            return attributionSource;
        L6:
            return attributionSource.withPackageName(resolvePackageName(context, attributionSource));
        }
    }

    private class PermissionManagerServiceInternalImpl implements PermissionManagerServiceInternal {
        final /* synthetic */ PermissionManagerService this$0;

        /* synthetic */ PermissionManagerServiceInternalImpl(PermissionManagerService r1, PermissionManagerServiceIA r2) {
            this(r1);
        }

        private PermissionManagerServiceInternalImpl(PermissionManagerService r1) {
            this.this$0 = r1;
        }

        @Override // com.android.server.pm.permission.PermissionManagerServiceInternal
        public int checkPermission(String packageName, String permissionName, String persistentDeviceId, int userId) {
            return this.this$0.checkPermission(packageName, permissionName, persistentDeviceId, userId);
        }

        @Override // com.android.server.pm.permission.PermissionManagerServiceInternal
        public int checkUidPermission(int uid, String permissionName, int deviceId) {
            return this.this$0.checkUidPermission(uid, permissionName, deviceId);
        }

        @Override // com.android.server.pm.permission.PermissionManagerServiceInternal
        public void setHotwordDetectionServiceProvider(PermissionManagerServiceInternal.HotwordDetectionServiceProvider provider) {
            PermissionManagerService.m7086$$Nest$fputmHotwordDetectionServiceProvider(this.this$0, provider);
        }

        @Override // com.android.server.pm.permission.PermissionManagerServiceInternal
        public PermissionManagerServiceInternal.HotwordDetectionServiceProvider getHotwordDetectionServiceProvider() {
            return PermissionManagerService.m7084$$Nest$fgetmHotwordDetectionServiceProvider(this.this$0);
        }

        @Override // com.android.server.pm.permission.LegacyPermissionDataProvider
        public int[] getGidsForUid(int uid) {
            return PermissionManagerService.m7085$$Nest$fgetmPermissionManagerServiceImpl(this.this$0).getGidsForUid(uid);
        }

        @Override // com.android.server.pm.permission.LegacyPermissionDataProvider
        public Map<String, Set<String>> getAllAppOpPermissionPackages() {
            return PermissionManagerService.m7085$$Nest$fgetmPermissionManagerServiceImpl(this.this$0).getAllAppOpPermissionPackages();
        }

        @Override // com.android.server.pm.permission.PermissionManagerServiceInternal
        public void onUserCreated(int userId) {
            PermissionManagerService.m7085$$Nest$fgetmPermissionManagerServiceImpl(this.this$0).onUserCreated(userId);
        }

        @Override // com.android.server.pm.permission.LegacyPermissionDataProvider
        public List<LegacyPermission> getLegacyPermissions() {
            return PermissionManagerService.m7085$$Nest$fgetmPermissionManagerServiceImpl(this.this$0).getLegacyPermissions();
        }

        @Override // com.android.server.pm.permission.LegacyPermissionDataProvider
        public LegacyPermissionState getLegacyPermissionState(int appId) {
            return PermissionManagerService.m7085$$Nest$fgetmPermissionManagerServiceImpl(this.this$0).getLegacyPermissionState(appId);
        }

        public byte[] backupRuntimePermissions(int userId) {
            return PermissionManagerService.m7085$$Nest$fgetmPermissionManagerServiceImpl(this.this$0).backupRuntimePermissions(userId);
        }

        public void restoreRuntimePermissions(byte[] backup, int userId) {
            PermissionManagerService.m7085$$Nest$fgetmPermissionManagerServiceImpl(this.this$0).restoreRuntimePermissions(backup, userId);
        }

        public void restoreDelayedRuntimePermissions(String packageName, int userId) {
            PermissionManagerService.m7085$$Nest$fgetmPermissionManagerServiceImpl(this.this$0).restoreDelayedRuntimePermissions(packageName, userId);
        }

        @Override // com.android.server.pm.permission.PermissionManagerServiceInternal
        public void readLegacyPermissionsTEMP(LegacyPermissionSettings legacyPermissionSettings) {
            PermissionManagerService.m7085$$Nest$fgetmPermissionManagerServiceImpl(this.this$0).readLegacyPermissionsTEMP(legacyPermissionSettings);
        }

        @Override // com.android.server.pm.permission.PermissionManagerServiceInternal
        public void writeLegacyPermissionsTEMP(LegacyPermissionSettings legacyPermissionSettings) {
            PermissionManagerService.m7085$$Nest$fgetmPermissionManagerServiceImpl(this.this$0).writeLegacyPermissionsTEMP(legacyPermissionSettings);
        }

        @Override // com.android.server.pm.permission.PermissionManagerServiceInternal
        public String getDefaultPermissionGrantFingerprint(int userId) {
            return PermissionManagerService.m7085$$Nest$fgetmPermissionManagerServiceImpl(this.this$0).getDefaultPermissionGrantFingerprint(userId);
        }

        @Override // com.android.server.pm.permission.PermissionManagerServiceInternal
        public void setDefaultPermissionGrantFingerprint(String fingerprint, int userId) {
            PermissionManagerService.m7085$$Nest$fgetmPermissionManagerServiceImpl(this.this$0).setDefaultPermissionGrantFingerprint(fingerprint, userId);
        }

        @Override // com.android.server.pm.permission.PermissionManagerServiceInternal
        public void onPackageAdded(PackageState packageState, boolean isInstantApp, AndroidPackage oldPkg) {
            PermissionManagerService.m7085$$Nest$fgetmPermissionManagerServiceImpl(this.this$0).onPackageAdded(packageState, isInstantApp, oldPkg);
        }

        @Override // com.android.server.pm.permission.PermissionManagerServiceInternal
        public void onPackageInstalled(AndroidPackage pkg, int previousAppId, PermissionManagerServiceInternal.PackageInstalledParams params, int rawUserId) {
            pkg.getClass();
            params.getClass();
            if (rawUserId >= 0) goto L7;
            if (rawUserId == (-1)) goto L7;
            boolean r3 = false;
        L8:
            Preconditions.checkArgument(r3, "userId");
            PermissionManagerService.m7085$$Nest$fgetmPermissionManagerServiceImpl(this.this$0).onPackageInstalled(pkg, previousAppId, params, rawUserId);
            if (rawUserId != (-1)) goto L11;
            int[] userIds = PermissionManagerService.m7087$$Nest$mgetAllUserIds(this.this$0);
        L12:
            int r4 = userIds.length;
            int r5 = 0;
        L13:
            if (r5 >= r4) goto L23;
            int userId = userIds[r5];
            int autoRevokePermissionsMode = params.getAutoRevokePermissionsMode();
            if (autoRevokePermissionsMode == 0) goto L17;
            if (autoRevokePermissionsMode == 1) goto L17;
        L22:
            r5 = r5 + 1;
        L17:
            PermissionManagerService r7 = this.this$0;
            if (autoRevokePermissionsMode != 1) goto L20;
            boolean r8 = true;
        L21:
            PermissionManagerService.m7088$$Nest$msetAutoRevokeExemptedInternal(r7, pkg, r8, userId);
            goto L22
        L20:
            r8 = false;
            goto L21
        L23:
            return;
        L11:
            userIds = new int[]{rawUserId};
        L7:
            r3 = true;
            goto L8
        }

        @Override // com.android.server.pm.permission.PermissionManagerServiceInternal
        public void onPackageRemoved(AndroidPackage pkg) {
            PermissionManagerService.m7085$$Nest$fgetmPermissionManagerServiceImpl(this.this$0).onPackageRemoved(pkg);
        }

        @Override // com.android.server.pm.permission.PermissionManagerServiceInternal
        public void onPackageUninstalled(String packageName, int appId, PackageState packageState, AndroidPackage pkg, List<AndroidPackage> sharedUserPkgs, int userId) {
            if (userId == (-1)) goto L8;
            int[] userIds = PermissionManagerService.m7087$$Nest$mgetAllUserIds(this.this$0);
            if (ArrayUtils.contains(userIds, userId) == true) goto L8;
            Slog.w(PermissionManagerService.m7090$$Nest$sfgetLOG_TAG(), "Skipping onPackageUninstalled() for non-existent user " + userId);
            return;
        L8:
            PermissionManagerService.m7085$$Nest$fgetmPermissionManagerServiceImpl(this.this$0).onPackageUninstalled(packageName, appId, packageState, pkg, sharedUserPkgs, userId);
        }

        @Override // com.android.server.pm.permission.PermissionManagerServiceInternal
        public void onSystemReady() {
            PermissionManagerService.m7085$$Nest$fgetmPermissionManagerServiceImpl(this.this$0).onSystemReady();
        }

        @Override // com.android.server.pm.permission.PermissionManagerServiceInternal
        public boolean isPermissionsReviewRequired(String packageName, int userId) {
            return PermissionManagerService.m7085$$Nest$fgetmPermissionManagerServiceImpl(this.this$0).isPermissionsReviewRequired(packageName, userId);
        }

        @Override // com.android.server.pm.permission.PermissionManagerServiceInternal
        public void readLegacyPermissionStateTEMP() {
            PermissionManagerService.m7085$$Nest$fgetmPermissionManagerServiceImpl(this.this$0).readLegacyPermissionStateTEMP();
        }

        @Override // com.android.server.pm.permission.PermissionManagerServiceInternal, com.android.server.pm.permission.LegacyPermissionDataProvider
        public void writeLegacyPermissionStateTEMP() {
            PermissionManagerService.m7085$$Nest$fgetmPermissionManagerServiceImpl(this.this$0).writeLegacyPermissionStateTEMP();
        }

        @Override // com.android.server.pm.permission.PermissionManagerServiceInternal
        public void onUserRemoved(int userId) {
            PermissionManagerService.m7085$$Nest$fgetmPermissionManagerServiceImpl(this.this$0).onUserRemoved(userId);
        }

        @Override // com.android.server.pm.permission.PermissionManagerServiceInternal
        public Set<String> getInstalledPermissions(String packageName) {
            return PermissionManagerService.m7085$$Nest$fgetmPermissionManagerServiceImpl(this.this$0).getInstalledPermissions(packageName);
        }

        @Override // com.android.server.pm.permission.PermissionManagerServiceInternal
        public Set<String> getGrantedPermissions(String packageName, int userId) {
            return PermissionManagerService.m7085$$Nest$fgetmPermissionManagerServiceImpl(this.this$0).getGrantedPermissions(packageName, userId);
        }

        @Override // com.android.server.pm.permission.PermissionManagerServiceInternal
        public int[] getPermissionGids(String permissionName, int userId) {
            return PermissionManagerService.m7085$$Nest$fgetmPermissionManagerServiceImpl(this.this$0).getPermissionGids(permissionName, userId);
        }

        @Override // com.android.server.pm.permission.PermissionManagerServiceInternal
        public String[] getAppOpPermissionPackages(String permissionName) {
            return PermissionManagerService.m7085$$Nest$fgetmPermissionManagerServiceImpl(this.this$0).getAppOpPermissionPackages(permissionName);
        }

        @Override // com.android.server.pm.permission.PermissionManagerServiceInternal
        public void onStorageVolumeMounted(String volumeUuid, boolean fingerprintChanged) {
            PermissionManagerService.m7085$$Nest$fgetmPermissionManagerServiceImpl(this.this$0).onStorageVolumeMounted(volumeUuid, fingerprintChanged);
        }

        @Override // com.android.server.pm.permission.PermissionManagerServiceInternal
        public void resetRuntimePermissions(AndroidPackage pkg, int userId, boolean restorePregrants) {
            PermissionManagerService.m7085$$Nest$fgetmPermissionManagerServiceImpl(this.this$0).resetRuntimePermissions(pkg, userId, restorePregrants);
        }

        @Override // com.android.server.pm.permission.PermissionManagerServiceInternal
        public void resetRuntimePermissionsForUser(int userId) {
            PermissionManagerService.m7085$$Nest$fgetmPermissionManagerServiceImpl(this.this$0).resetRuntimePermissionsForUser(userId);
        }

        @Override // com.android.server.pm.permission.PermissionManagerServiceInternal
        public Permission getPermissionTEMP(String permName) {
            return PermissionManagerService.m7085$$Nest$fgetmPermissionManagerServiceImpl(this.this$0).getPermissionTEMP(permName);
        }

        @Override // com.android.server.pm.permission.PermissionManagerServiceInternal
        public List<PermissionInfo> getAllPermissionsWithProtection(int protection) {
            return PermissionManagerService.m7085$$Nest$fgetmPermissionManagerServiceImpl(this.this$0).getAllPermissionsWithProtection(protection);
        }

        @Override // com.android.server.pm.permission.PermissionManagerServiceInternal
        public List<PermissionInfo> getAllPermissionsWithProtectionFlags(int protectionFlags) {
            return PermissionManagerService.m7085$$Nest$fgetmPermissionManagerServiceImpl(this.this$0).getAllPermissionsWithProtectionFlags(protectionFlags);
        }

        @Override // com.android.server.pm.permission.PermissionManagerServiceInternal
        public void setCheckPermissionDelegate(PermissionManagerServiceInternal.CheckPermissionDelegate delegate) {
            PermissionManagerService.m7089$$Nest$msetCheckPermissionDelegateInternal(this.this$0, delegate);
        }
    }

    private static final class RegisteredAttribution {
        private final IBinder.DeathRecipient mDeathRecipient;
        private final AtomicBoolean mFinished;
        private final IBinder mToken;

        /* JADX INFO: renamed from: $r8$lambda$WO-ed5PKRX8IsXitr7ssfCstW60, reason: not valid java name */
        public static /* synthetic */ void m7093$r8$lambda$WOed5PKRX8IsXitr7ssfCstW60(RegisteredAttribution r0, Context r1, int r2, AttributionSource r3, boolean r4) {
            r0.lambda$new$0(r1, r2, r3, r4);
        }

        RegisteredAttribution(final Context context, final int op, final AttributionSource source, final boolean fromDatasource) {
            this.mFinished = new AtomicBoolean(false);
            this.mDeathRecipient = new PermissionManagerService$RegisteredAttribution$$ExternalSyntheticLambda0(this, context, op, source, fromDatasource);
            this.mToken = source.getToken();
            if (this.mToken == null) goto L11;
            this.mToken.linkToDeath(this.mDeathRecipient, 0);     // Catch: RemoteException -> L6
            return;
        L7:
            this.mDeathRecipient.binderDied();
            return;
        }

        private /* synthetic */ void lambda$new$0(Context context, int op, AttributionSource source, boolean fromDatasource) {
            if (unregister() == false) goto L6;
            PermissionCheckerService.m7092$$Nest$smfinishDataDelivery(context, op, source.asState(), fromDatasource);
            return;
        }

        public boolean unregister() {
            if (this.mFinished.compareAndSet(false, true) == true) goto L13;
            return false;
        L13:
            if (this.mToken == null) goto L11;
            this.mToken.unlinkToDeath(this.mDeathRecipient, 0);     // Catch: NoSuchElementException -> L8
        L11:
            return true;
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$TqpcREz5-_9hwZ_eqtTKZrs55ko, reason: not valid java name */
    public static /* synthetic */ void m7083$r8$lambda$TqpcREz5_9hwZ_eqtTKZrs55ko(int r0, List r1, AndroidPackage r2) {
        lambda$getPackagesWithAutoRevokePolicy$0(r0, r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHotwordDetectionServiceProvider, reason: not valid java name */
    static /* bridge */ /* synthetic */ PermissionManagerServiceInternal.HotwordDetectionServiceProvider m7084$$Nest$fgetmHotwordDetectionServiceProvider(PermissionManagerService r0) {
        return r0.mHotwordDetectionServiceProvider;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPermissionManagerServiceImpl, reason: not valid java name */
    static /* bridge */ /* synthetic */ PermissionManagerServiceInterface m7085$$Nest$fgetmPermissionManagerServiceImpl(PermissionManagerService r0) {
        return r0.mPermissionManagerServiceImpl;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmHotwordDetectionServiceProvider, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7086$$Nest$fputmHotwordDetectionServiceProvider(PermissionManagerService r0, PermissionManagerServiceInternal.HotwordDetectionServiceProvider r1) {
        r0.mHotwordDetectionServiceProvider = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mgetAllUserIds, reason: not valid java name */
    static /* bridge */ /* synthetic */ int[] m7087$$Nest$mgetAllUserIds(PermissionManagerService r0) {
        return r0.getAllUserIds();
    }

    /* JADX INFO: renamed from: -$$Nest$msetAutoRevokeExemptedInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m7088$$Nest$msetAutoRevokeExemptedInternal(PermissionManagerService r0, AndroidPackage r1, boolean r2, int r3) {
        return r0.setAutoRevokeExemptedInternal(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$msetCheckPermissionDelegateInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7089$$Nest$msetCheckPermissionDelegateInternal(PermissionManagerService r0, PermissionManagerServiceInternal.CheckPermissionDelegate r1) {
        r0.setCheckPermissionDelegateInternal(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetLOG_TAG, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m7090$$Nest$sfgetLOG_TAG() {
        return LOG_TAG;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetsRunningAttributionSources, reason: not valid java name */
    static /* bridge */ /* synthetic */ ConcurrentHashMap m7091$$Nest$sfgetsRunningAttributionSources() {
        return sRunningAttributionSources;
    }

    static {
        LOG_TAG = PermissionManagerService.class.getSimpleName();
        sRunningAttributionSources = new ConcurrentHashMap();
    }

    PermissionManagerService(Context context, ArrayMap<String, FeatureInfo> availableFeatures) {
        this.mLock = new Object();
        this.mOneTimePermissionUserManagers = new SparseArray();
        this.mObricExt = (IObricPermissionManagerService) ObricImplFactory.getImpl(IObricPermissionManagerService.class, new Object[]{this});
        this.mSmtEx = new PermissionManagerServiceSmtEx(this);
        this.mIExt = (IExtPermissionManagerService) ExtImplFactory.getImpl(IExtPermissionManagerService.class, new Object[]{this});
        PackageManager.invalidatePackageInfoCache();
        PermissionManager.disablePackageNamePermissionCache();
        this.mContext = context;
        this.mPackageManagerInt = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);
        this.mAppOpsManager = (AppOpsManager) context.getSystemService(AppOpsManager.class);
        this.mVirtualDeviceManagerInternal = (VirtualDeviceManagerInternal) LocalServices.getService(VirtualDeviceManagerInternal.class);
        this.mAttributionSourceRegistry = new AttributionSourceRegistry(context);
        PermissionManagerServiceInternalImpl localService = new PermissionManagerServiceInternalImpl(this, null);
        LocalServices.addService(PermissionManagerServiceInternal.class, localService);
        LocalServices.addService(PermissionManagerInternal.class, localService);
        if (PermissionManager.USE_ACCESS_CHECKING_SERVICE == false) goto L5;
        this.mPermissionManagerServiceImpl = (PermissionManagerServiceInterface) LocalServices.getService(PermissionManagerServiceInterface.class);
    L6:
        this.mPermissionManagerServiceImpl.setPermissionManagerServiceSmtEx(this.mSmtEx);
        this.mIExt.initPermissionWhiteList();
        return;
    L5:
        this.mPermissionManagerServiceImpl = new PermissionManagerServiceImpl(context, availableFeatures);
        goto L6
    }

    public static PermissionManagerServiceInternal create(Context context, ArrayMap<String, FeatureInfo> availableFeatures) {
        PermissionManagerServiceInternal permMgrInt = (PermissionManagerServiceInternal) LocalServices.getService(PermissionManagerServiceInternal.class);
        if (permMgrInt == null) goto L5;
        return permMgrInt;
    L5:
        PermissionManagerService permissionService = (PermissionManagerService) ServiceManager.getService("permissionmgr");
        if (permissionService != null) goto L9;
        ServiceManager.addService("permissionmgr", new PermissionManagerService(context, availableFeatures));
        ServiceManager.addService("permission_checker", new PermissionCheckerService(context));
    L9:
        return (PermissionManagerServiceInternal) LocalServices.getService(PermissionManagerServiceInternal.class);
    }

    public static void killUid(int appId, int userId, String reason) {
        long identity = Binder.clearCallingIdentity();
        IActivityManager am = ActivityManager.getService();     // Catch: Throwable -> L7
        if (am != null) goto L14;
    L10:
        Binder.restoreCallingIdentity(identity);
        return;
    L14:
        am.killUidForPermissionChange(appId, userId, reason);     // Catch: Throwable -> L7 RemoteException -> L9
    L7:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    public int checkPermission(String packageName, String permissionName, String persistentDeviceId, int userId) {
        if (this.mSmtEx.checkPermissionDisabled() == false) goto L5;
        return 0;
    L5:
        if (packageName == null) goto L35;
        if (permissionName == null) goto L42;
        PermissionInfo permissionInfo = getPermissionInfo(permissionName, packageName, 0);
        AndroidPackage androidPackage = this.mPackageManagerInt.getAndroidPackage(packageName);
        if (androidPackage == null) goto L17;
        if (permissionInfo == null) goto L17;
        if (permissionInfo.isRuntime() == true) goto L17;
        this.mPackageManagerInt.getAndroidPackage(packageName);
        if (this.mIExt.checkDefaultPKGPermissionGrant(packageName, permissionName, androidPackage.getSigningDetails().getSignatures()[0].hashCode()) == false) goto L17;
        return 0;
    L17:
        if (this.mObricExt.checkObricAssistPermission(permissionName, packageName) == false) goto L19;
        return 0;
    L19:
        Object r1 = this.mLock;
        monitor-enter(r1);
        PermissionManagerServiceInternal.CheckPermissionDelegate checkPermissionDelegate = this.mCheckPermissionDelegate;     // Catch: Throwable -> L28
        monitor-exit(r1);     // Catch: Throwable -> L28
        if (checkPermissionDelegate == null) goto L25;
        final PermissionManagerServiceInterface r0 = this.mPermissionManagerServiceImpl;
        r0.getClass();
        return checkPermissionDelegate.checkPermission(packageName, permissionName, persistentDeviceId, userId, new PermissionManagerService$$ExternalSyntheticLambda0(r0));
    L25:
        return this.mPermissionManagerServiceImpl.checkPermission(packageName, permissionName, persistentDeviceId, userId);
    L28:
        th = th;
    L39:
        throw th;
    L32:
        th = th;
        goto L39
    L42:
        return -1;
    L35:
        return -1;
    }

    public int checkUidPermission(int uid, String permissionName, int deviceId) {
        if (this.mSmtEx.checkPermissionDisabled() == false) goto L6;
        return 0;
    L6:
        if (this.mIExt.checkUidPermission(permissionName, this.mPackageManagerInt.getPackage(uid)) == false) goto L8;
        return 0;
    L8:
        if (permissionName != null) goto L12;
        return -1;
    L12:
        if (this.mObricExt.checkObricAssistPermission(this.mPackageManagerInt.getPackage(uid), permissionName) == false) goto L14;
        return 0;
    L14:
        String persistentDeviceId = getPersistentDeviceId(deviceId);
        Object r1 = this.mLock;
        monitor-enter(r1);
        PermissionManagerServiceInternal.CheckPermissionDelegate checkPermissionDelegate = this.mCheckPermissionDelegate;     // Catch: Throwable -> L23
        monitor-exit(r1);     // Catch: Throwable -> L23
        if (checkPermissionDelegate == null) goto L20;
        final PermissionManagerServiceInterface r2 = this.mPermissionManagerServiceImpl;
        r2.getClass();
        return checkPermissionDelegate.checkUidPermission(uid, permissionName, persistentDeviceId, new PermissionManagerService$$ExternalSyntheticLambda1(r2));
    L20:
        return this.mPermissionManagerServiceImpl.checkUidPermission(uid, permissionName, persistentDeviceId);
    L23:
        th = move-exception;
        throw th;
    }

    public int getPermissionRequestState(String packageName, String permissionName, int deviceId) {
        permissionName.getClass();
        packageName.getClass();
        return this.mPermissionManagerServiceImpl.getPermissionRequestState(packageName, permissionName, deviceId, getPersistentDeviceId(deviceId));
    }

    private String getPersistentDeviceId(int deviceId) {
        if (deviceId != 0) goto L6;
        return "default:0";
    L6:
        if (this.mVirtualDeviceManagerInternal != null) goto L9;
        this.mVirtualDeviceManagerInternal = (VirtualDeviceManagerInternal) LocalServices.getService(VirtualDeviceManagerInternal.class);
    L9:
        if (this.mVirtualDeviceManagerInternal != null) goto L12;
        return "default:0";
    L12:
        return this.mVirtualDeviceManagerInternal.getPersistentIdForDevice(deviceId);
    }

    public Map<String, PermissionManager.PermissionState> getAllPermissionStates(String packageName, String persistentDeviceId, int userId) {
        return this.mPermissionManagerServiceImpl.getAllPermissionStates(packageName, persistentDeviceId, userId);
    }

    public boolean setAutoRevokeExempted(String packageName, boolean exempted, int userId) {
        packageName.getClass();
        AndroidPackage pkg = this.mPackageManagerInt.getPackage(packageName);
        int callingUid = Binder.getCallingUid();
        if (checkAutoRevokeAccess(pkg, callingUid) == true) goto L7;
        return false;
    L7:
        return setAutoRevokeExemptedInternal(pkg, exempted, userId);
    }

    private boolean setAutoRevokeExemptedInternal(AndroidPackage pkg, boolean exempted, int userId) {
        int packageUid = UserHandle.getUid(userId, pkg.getUid());
        AttributionSource attributionSource = new AttributionSource(packageUid, pkg.getPackageName(), null);
        int r3 = 0;
        if (this.mAppOpsManager.checkOpNoThrow(98, attributionSource) == 0) goto L5;
        return false;
    L5:
        long identity = Binder.clearCallingIdentity();
        AppOpsManager r2 = this.mAppOpsManager;     // Catch: Throwable -> L12
        String r6 = pkg.getPackageName();     // Catch: Throwable -> L12
        if (exempted == false) goto L9;
        r3 = 1;
    L9:
        r2.setMode(97, packageUid, r6, r3);     // Catch: Throwable -> L12
        Binder.restoreCallingIdentity(identity);
        return true;
    L12:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    private void setCheckPermissionDelegateInternal(PermissionManagerServiceInternal.CheckPermissionDelegate delegate) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mCheckPermissionDelegate = delegate;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private boolean checkAutoRevokeAccess(AndroidPackage pkg, int callingUid) {
        if (this.mContext.checkCallingOrSelfPermission("android.permission.WHITELIST_AUTO_REVOKE_PERMISSIONS") != 0) goto L5;
        boolean isCallerPrivileged = true;
    L6:
        boolean isCallerInstallerOnRecord = this.mPackageManagerInt.isCallerInstallerOfRecord(pkg, callingUid);
        if (isCallerPrivileged == true) goto L12;
        if (isCallerInstallerOnRecord == true) goto L12;
        throw new SecurityException("Caller must either hold android.permission.WHITELIST_AUTO_REVOKE_PERMISSIONS or be the installer on record");
    L12:
        if (pkg != null) goto L14;
    L17:
        return false;
    L14:
        if (this.mPackageManagerInt.filterAppAccess(pkg, callingUid, UserHandle.getUserId(callingUid)) == true) goto L17;
        return true;
    L5:
        isCallerPrivileged = false;
        goto L6
    }

    public boolean isAutoRevokeExempted(String packageName, int userId) {
        packageName.getClass();
        AndroidPackage pkg = this.mPackageManagerInt.getPackage(packageName);
        int callingUid = Binder.getCallingUid();
        boolean r3 = false;
        if (checkAutoRevokeAccess(pkg, callingUid) == true) goto L5;
        return false;
    L5:
        int packageUid = UserHandle.getUid(userId, pkg.getUid());
        long identity = Binder.clearCallingIdentity();
        AttributionSource attributionSource = new AttributionSource(packageUid, packageName, null);     // Catch: Throwable -> L12
        if (this.mAppOpsManager.checkOpNoThrow(97, attributionSource) != 1) goto L10;
        r3 = true;
    L10:
        Binder.restoreCallingIdentity(identity);
        return r3;
    L12:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    private OneTimePermissionUserManager getOneTimePermissionUserManager(int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        OneTimePermissionUserManager oneTimePermissionUserManager = this.mOneTimePermissionUserManagers.get(userId);     // Catch: Throwable -> L8
        if (oneTimePermissionUserManager == null) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return oneTimePermissionUserManager;
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L8
        OneTimePermissionUserManager newOneTimePermissionUserManager = new OneTimePermissionUserManager(this.mContext.createContextAsUser(UserHandle.of(userId), 0));
        Object r3 = this.mLock;
        monitor-enter(r3);
        OneTimePermissionUserManager oneTimePermissionUserManager2 = this.mOneTimePermissionUserManagers.get(userId);     // Catch: Throwable -> L17
        if (oneTimePermissionUserManager2 == null) goto L19;
        monitor-exit(r3);     // Catch: Throwable -> L17
        return oneTimePermissionUserManager2;
    L19:
        this.mOneTimePermissionUserManagers.put(userId, newOneTimePermissionUserManager);     // Catch: Throwable -> L17
        monitor-exit(r3);     // Catch: Throwable -> L17
        newOneTimePermissionUserManager.registerUninstallListener();
        return newOneTimePermissionUserManager;
    L17:
        th = move-exception;
        throw th;
    L8:
        th = move-exception;
        throw th;
    }

    public void startOneTimePermissionSession(String packageName, int deviceId, int userId, long timeoutMillis, long revokeAfterKilledDelayMillis) {
        startOneTimePermissionSession_enforcePermission();
        packageName.getClass();
        long token = Binder.clearCallingIdentity();
        getOneTimePermissionUserManager(userId).startPackageOneTimeSession(packageName, deviceId, timeoutMillis, revokeAfterKilledDelayMillis);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(token);
        return;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    public void stopOneTimePermissionSession(String packageName, int userId) {
        super.stopOneTimePermissionSession_enforcePermission();
        packageName.getClass();
        long token = Binder.clearCallingIdentity();
        getOneTimePermissionUserManager(userId).stopPackageOneTimeSession(packageName);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(token);
        return;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    public IBinder registerAttributionSource(AttributionSourceState source) {
        Binder token = new Binder();
        this.mAttributionSourceRegistry.registerAttributionSource(new AttributionSource(source).withToken(token));
        return token;
    }

    public boolean isRegisteredAttributionSource(AttributionSourceState source) {
        return this.mAttributionSourceRegistry.isRegisteredAttributionSource(new AttributionSource(source));
    }

    public int getRegisteredAttributionSourceCount(int uid) {
        return this.mAttributionSourceRegistry.getRegisteredAttributionSourceCount(uid);
    }

    public List<String> getAutoRevokeExemptionRequestedPackages(int userId) {
        return getPackagesWithAutoRevokePolicy(1, userId);
    }

    public List<String> getAutoRevokeExemptionGrantedPackages(int userId) {
        return getPackagesWithAutoRevokePolicy(2, userId);
    }

    private List<String> getPackagesWithAutoRevokePolicy(final int autoRevokePolicy, int userId) {
        this.mContext.enforceCallingPermission("android.permission.ADJUST_RUNTIME_PERMISSIONS_POLICY", "Must hold android.permission.ADJUST_RUNTIME_PERMISSIONS_POLICY");
        final List<String> result = new ArrayList();
        this.mPackageManagerInt.forEachInstalledPackage(new PermissionManagerService$$ExternalSyntheticLambda2(autoRevokePolicy, result), userId);
        return result;
    }

    private static /* synthetic */ void lambda$getPackagesWithAutoRevokePolicy$0(int autoRevokePolicy, List result, AndroidPackage pkg) {
        if (pkg.getAutoRevokePermissions() != autoRevokePolicy) goto L6;
        result.add(pkg.getPackageName());
        return;
    }

    public ParceledListSlice<PermissionGroupInfo> getAllPermissionGroups(int flags) {
        return new ParceledListSlice(this.mPermissionManagerServiceImpl.getAllPermissionGroups(flags));
    }

    public PermissionGroupInfo getPermissionGroupInfo(String groupName, int flags) {
        return this.mPermissionManagerServiceImpl.getPermissionGroupInfo(groupName, flags);
    }

    public PermissionInfo getPermissionInfo(String permissionName, String packageName, int flags) {
        return this.mPermissionManagerServiceImpl.getPermissionInfo(permissionName, flags, packageName);
    }

    public ParceledListSlice<PermissionInfo> queryPermissionsByGroup(String groupName, int flags) {
        List<PermissionInfo> permissionInfo = this.mPermissionManagerServiceImpl.queryPermissionsByGroup(groupName, flags);
        if (permissionInfo != null) goto L7;
        return null;
    L7:
        return new ParceledListSlice(permissionInfo);
    }

    public boolean addPermission(PermissionInfo permissionInfo, boolean async) {
        return this.mPermissionManagerServiceImpl.addPermission(permissionInfo, async);
    }

    public void removePermission(String permissionName) {
        this.mPermissionManagerServiceImpl.removePermission(permissionName);
    }

    public int getPermissionFlags(String packageName, String permissionName, String persistentDeviceId, int userId) {
        return this.mPermissionManagerServiceImpl.getPermissionFlags(packageName, permissionName, persistentDeviceId, userId);
    }

    public void updatePermissionFlags(String packageName, String permissionName, int flagMask, int flagValues, boolean checkAdjustPolicyFlagPermission, String persistentDeviceId, int userId) {
        this.mPermissionManagerServiceImpl.updatePermissionFlags(packageName, permissionName, flagMask, flagValues, checkAdjustPolicyFlagPermission, persistentDeviceId, userId);
    }

    public void updatePermissionFlagsForAllApps(int flagMask, int flagValues, int userId) {
        this.mPermissionManagerServiceImpl.updatePermissionFlagsForAllApps(flagMask, flagValues, userId);
    }

    public void addOnPermissionsChangeListener(IOnPermissionsChangeListener listener) {
        this.mPermissionManagerServiceImpl.addOnPermissionsChangeListener(listener);
    }

    public void removeOnPermissionsChangeListener(IOnPermissionsChangeListener listener) {
        this.mPermissionManagerServiceImpl.removeOnPermissionsChangeListener(listener);
    }

    public List<String> getAllowlistedRestrictedPermissions(String packageName, int flags, int userId) {
        return this.mPermissionManagerServiceImpl.getAllowlistedRestrictedPermissions(packageName, flags, userId);
    }

    public boolean addAllowlistedRestrictedPermission(String packageName, String permissionName, int flags, int userId) {
        return this.mPermissionManagerServiceImpl.addAllowlistedRestrictedPermission(packageName, permissionName, flags, userId);
    }

    public boolean removeAllowlistedRestrictedPermission(String packageName, String permissionName, int flags, int userId) {
        return this.mPermissionManagerServiceImpl.removeAllowlistedRestrictedPermission(packageName, permissionName, flags, userId);
    }

    public void grantRuntimePermission(String packageName, String permissionName, String persistentDeviceId, int userId) {
        this.mPermissionManagerServiceImpl.grantRuntimePermission(packageName, permissionName, persistentDeviceId, userId);
    }

    public void revokeRuntimePermission(String packageName, String permissionName, String persistentDeviceId, int userId, String reason) {
        this.mPermissionManagerServiceImpl.revokeRuntimePermission(packageName, permissionName, persistentDeviceId, userId, reason);
    }

    public void revokePostNotificationPermissionWithoutKillForTest(String packageName, int userId) {
        this.mPermissionManagerServiceImpl.revokePostNotificationPermissionWithoutKillForTest(packageName, userId);
    }

    public boolean shouldShowRequestPermissionRationale(String packageName, String permissionName, int deviceId, int userId) {
        String persistentDeviceId = getPersistentDeviceId(deviceId);
        return this.mPermissionManagerServiceImpl.shouldShowRequestPermissionRationale(packageName, permissionName, persistentDeviceId, userId);
    }

    public boolean isPermissionRevokedByPolicy(String packageName, String permissionName, int deviceId, int userId) {
        String persistentDeviceId = getPersistentDeviceId(deviceId);
        return this.mPermissionManagerServiceImpl.isPermissionRevokedByPolicy(packageName, permissionName, persistentDeviceId, userId);
    }

    public List<SplitPermissionInfoParcelable> getSplitPermissions() {
        return this.mPermissionManagerServiceImpl.getSplitPermissions();
    }

    private int[] getAllUserIds() {
        return UserManagerService.getInstance().getUserIdsIncludingPreCreated();
    }

    protected void dump(FileDescriptor fd, PrintWriter writer, String[] args) {
        this.mPermissionManagerServiceImpl.dump(fd, writer, args);
    }

    public PermissionManagerServiceSmtEx getSmtEx() {
        return this.mSmtEx;
    }

    public IExtPermissionManagerService getExt() {
        return this.mIExt;
    }

    public IObricPermissionManagerService getObricExt() {
        return this.mObricExt;
    }
}
