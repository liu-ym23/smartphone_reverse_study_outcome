package com.android.server.wallpaper;

import android.R;
import android.app.ActivityManager;
import android.app.ActivityOptions;
import android.app.AppGlobals;
import android.app.AppOpsManager;
import android.app.ApplicationExitInfo;
import android.app.ILocalWallpaperColorConsumer;
import android.app.IWallpaperManager;
import android.app.IWallpaperManagerCallback;
import android.app.IWallpaperManagerExt;
import android.app.KeyguardManager;
import android.app.PendingIntent;
import android.app.WallpaperColors;
import android.app.WallpaperInfo;
import android.app.WallpaperManager;
import android.app.admin.DevicePolicyManagerInternal;
import android.app.wallpaper.WallpaperDescription;
import android.app.wallpaper.WallpaperInstance;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.pm.IPackageManager;
import android.content.pm.PackageManager;
import android.content.pm.PackageManagerInternal;
import android.content.pm.ParceledListSlice;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.pm.UserInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.display.DisplayManager;
import android.os.Binder;
import android.os.Bundle;
import android.os.FileObserver;
import android.os.FileUtils;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.IRemoteCallback;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.SELinux;
import android.os.ShellCallback;
import android.os.SystemClock;
import android.os.UserHandle;
import android.os.UserManager;
import android.os.storage.StorageManager;
import android.pico.utils.ExtImplFactory;
import android.service.wallpaper.IWallpaperConnection;
import android.service.wallpaper.IWallpaperEngine;
import android.service.wallpaper.IWallpaperService;
import android.system.ErrnoException;
import android.system.Os;
import android.text.TextUtils;
import android.util.EventLog;
import android.util.IntArray;
import android.util.Slog;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.Utils;
import android.view.Display;
import android.view.WindowManager;
import com.android.internal.content.PackageMonitor;
import com.android.internal.os.BackgroundThread;
import com.android.internal.util.DumpUtils;
import com.android.server.EventLogTags;
import com.android.server.FgThread;
import com.android.server.LocalServices;
import com.android.server.ServiceThread;
import com.android.server.SysOptBridge;
import com.android.server.SystemService;
import com.android.server.am.ProcessList;
import com.android.server.pm.PackageManagerService;
import com.android.server.pm.UserManagerInternal;
import com.android.server.utils.TimingsTraceAndSlog;
import com.android.server.wm.ActivityTaskManagerInternal;
import com.android.server.wm.DesktopModeHelper;
import com.android.server.wm.WindowManagerInternal;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Predicate;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes3.dex */
public class WallpaperManagerService extends IWallpaperManager.Stub implements IWallpaperManagerService {
    public static boolean DEBUG = false;
    private static final boolean DEBUG_LIVE = true;
    private static final double LMK_LOW_THRESHOLD_MEMORY_PERCENTAGE = 10.0d;
    private static final long LMK_RECONNECT_DELAY_MS = 5000;
    private static final int LMK_RECONNECT_REBIND_RETRIES = 3;
    private static final RectF LOCAL_COLOR_BOUNDS = null;
    private static final int MAX_WALLPAPER_COMPONENT_LOG_LENGTH = 128;
    private static final long MIN_WALLPAPER_CRASH_TIME = 10000;
    private static final String TAG = "WallpaperManagerService";
    private static final Map<Integer, String> sWallpaperType = null;
    private final ActivityManager mActivityManager;
    private final AppOpsManager mAppOpsManager;
    private WallpaperColors mCacheDefaultImageWallpaperColors;
    private final SparseArray<SparseArray<RemoteCallbackList<IWallpaperManagerCallback>>> mColorsChangedListeners;
    private final Context mContext;
    private int mCurrentUserId;
    private final ComponentName mDefaultWallpaperComponent;
    private final DisplayManager.DisplayListener mDisplayListener;
    protected WallpaperData mFallbackWallpaper;
    private final ComponentName mFallbackWallpaperComponent;
    private ServiceThread mHandlerThread;
    private boolean mHomeWallpaperWaitingForUnlock;
    private IExtWallpaperManagerService mIExt;
    private final IPackageManager mIPackageManager;
    private final ComponentName mImageWallpaper;
    private boolean mInAmbientMode;
    private boolean mInitialUserSwitch;
    private final ActivityTaskManagerInternal.ScreenObserver mKeyguardObserver;
    protected WallpaperData mLastLockWallpaper;
    protected WallpaperData mLastWallpaper;
    private LocalColorRepository mLocalColorRepo;
    final Object mLock;
    private final SparseArray<WallpaperData> mLockWallpaperMap;
    private boolean mLockWallpaperWaitingForUnlock;
    private final MyPackageMonitor mMonitor;
    private final PackageManagerInternal mPackageManagerInternal;
    WallpaperDestinationChangeHandler mPendingMigrationViaStatic;
    private boolean mShuttingDown;
    private final SparseBooleanArray mUserRestorecon;
    final WallpaperCropper mWallpaperCropper;
    final WallpaperDataParser mWallpaperDataParser;
    final WallpaperDisplayHelper mWallpaperDisplayHelper;
    private final SparseArray<WallpaperData> mWallpaperMap;
    private final WindowManagerInternal mWindowManagerInternal;

    final class DisplayConnector {
        boolean mDimensionsChanged;
        final int mDisplayId;
        IWallpaperEngine mEngine;
        boolean mPaddingChanged;
        final Binder mToken;
        int mWhich;
        final /* synthetic */ WallpaperManagerService this$0;

        DisplayConnector(WallpaperManagerService this$0, int displayId, int which) {
            this.this$0 = this$0;
            this.mToken = new Binder();
            this.mDisplayId = displayId;
            this.mWhich = which;
        }

        void ensureStatusHandled() {
            WallpaperDisplayHelper.DisplayData wpdData = this.this$0.mWallpaperDisplayHelper.getDisplayDataOrCreate(this.mDisplayId);
            if (this.mDimensionsChanged == false) goto L10;
            this.mEngine.setDesiredSize(wpdData.mWidth, wpdData.mHeight);     // Catch: RemoteException -> L6
        L8:
            this.mDimensionsChanged = false;
        L6:
            e = move-exception;
            Slog.w(WallpaperManagerService.TAG, "Failed to set wallpaper dimensions", e);
        L10:
            if (this.mPaddingChanged == false) goto L21;
            this.mEngine.setDisplayPadding(wpdData.mPadding);     // Catch: RemoteException -> L13
        L15:
            this.mPaddingChanged = false;
            return;
        L13:
            e = move-exception;
            Slog.w(WallpaperManagerService.TAG, "Failed to set wallpaper padding", e);
            goto L15
        }

        void connectLocked(WallpaperConnection connection, WallpaperData wallpaper) {
            if (connection.mService != null) goto L6;
            Slog.w(WallpaperManagerService.TAG, "WallpaperService is not connected yet");
            return;
        L6:
            int which = wallpaper.mWhich;
            if (DesktopModeHelper.isDeviceEligibleForDesktopExperienceWallpaper(WallpaperManagerService.m9507$$Nest$fgetmContext(this.this$0)) == false) goto L9;
            int which2 = this.mWhich;
            int which3 = which2;
        L10:
            ComponentName componentName = wallpaper.getComponent();
            IExtWallpaperManagerService r4 = WallpaperManagerService.m9510$$Nest$fgetmIExt(this.this$0);
            if (componentName == null) goto L13;
            String r5 = componentName.flattenToString();
        L14:
            r4.traceConnectLocked(r5, this.mDisplayId, which3, wallpaper.userId, this.mToken);
            TimingsTraceAndSlog t = new TimingsTraceAndSlog(WallpaperManagerService.TAG);
            t.traceBegin("WPMS.connectLocked-" + wallpaper.getComponent());
            if (WallpaperManagerService.DEBUG == false) goto L17;
            Slog.v(WallpaperManagerService.TAG, "Adding window token: " + this.mToken);
        L17:
            WallpaperManagerService.m9518$$Nest$fgetmWindowManagerInternal(this.this$0).addWindowToken(this.mToken, 2013, this.mDisplayId, null);
            WindowManagerInternal r0 = WallpaperManagerService.m9518$$Nest$fgetmWindowManagerInternal(this.this$0);
            Binder r6 = this.mToken;
            if ((which3 & 2) == 0) goto L20;
            boolean r7 = true;
        L21:
            r0.setWallpaperShowWhenLocked(r6, r7);
            if (WallpaperManagerService.m9512$$Nest$fgetmImageWallpaper(this.this$0).equals(wallpaper.getComponent()) == false) goto L24;
            WallpaperManagerService.m9518$$Nest$fgetmWindowManagerInternal(this.this$0).setWallpaperCropHints(this.mToken, this.this$0.mWallpaperCropper.getRelativeCropHints(wallpaper));
        L25:
            WallpaperDisplayHelper.DisplayData wpdData = this.this$0.mWallpaperDisplayHelper.getDisplayDataOrCreate(this.mDisplayId);
            IWallpaperService r2 = connection.mService;     // Catch: RemoteException -> L36
            Binder r1 = this.mToken;     // Catch: RemoteException -> L36
            int which4 = which3;
            int which5 = wpdData.mWidth;     // Catch: RemoteException -> L34
            TimingsTraceAndSlog t2 = t;
            r2.attach(connection, r1, 2013, false, which5, wpdData.mHeight, wpdData.mPadding, this.mDisplayId, which4, connection.mInfo, wallpaper.getDescription());     // Catch: RemoteException -> L32
        L43:
            t2.traceEnd();
            return;
        L32:
            e = e;
        L38:
            Slog.w(WallpaperManagerService.TAG, "Failed attaching wallpaper on display", e);
            if (wallpaper.wallpaperUpdating == true) goto L43;
            if (connection.getConnectedEngineSize() != 0) goto L43;
            wallpaper.mBindSource = WallpaperData.BindSource.CONNECT_LOCKED;
            this.this$0.bindWallpaperComponentLocked(null, false, false, wallpaper, null);
        L34:
            e = e;
            t2 = t;
        L36:
            e = e;
            t2 = t;
            goto L38
        L24:
            WallpaperManagerService.m9518$$Nest$fgetmWindowManagerInternal(this.this$0).setWallpaperCropHints(this.mToken, new SparseArray());
            goto L25
        L20:
            r7 = false;
            goto L21
        L13:
            r5 = null;
            goto L14
        L9:
            which3 = which;
            goto L10
        }

        void disconnectLocked(WallpaperConnection connection) {
            WallpaperManagerService.m9510$$Nest$fgetmIExt(this.this$0).traceDisconnectLocked(connection, this.mToken);
            if (WallpaperManagerService.DEBUG == false) goto L5;
            Slog.v(WallpaperManagerService.TAG, "Removing window token: " + this.mToken);
        L5:
            WallpaperManagerService.m9518$$Nest$fgetmWindowManagerInternal(this.this$0).removeWindowToken(this.mToken, false, this.mDisplayId);
        L10:
            e = move-exception;
            Slog.w(WallpaperManagerService.TAG, "connection.mService.destroy() threw a RemoteException", e);
        L14:
            this.mEngine = null;
            return;
        L7:
            if (connection.mService == null) goto L14;
            connection.mService.detach(this.mToken);     // Catch: RemoteException -> L10
            goto L14
        }
    }

    public static class Lifecycle extends SystemService {
        private IWallpaperManagerService mService;

        public Lifecycle(Context context) {
            super(context);
        }

        @Override // com.android.server.SystemService
        public void onStart() {
            this.mService = (IWallpaperManagerService) Class.forName(getContext().getResources().getString(R.string.data_usage_rapid_title)).getConstructor(new Class[]{Context.class}).newInstance(new Object[]{getContext()});     // Catch: Exception -> L4
            publishBinderService("wallpaper", this.mService);     // Catch: Exception -> L4
            return;
        L4:
            exp = move-exception;
            Slog.wtf(WallpaperManagerService.TAG, "Failed to instantiate WallpaperManagerService", exp);
        }

        @Override // com.android.server.SystemService
        public void onBootPhase(int phase) {
            if (this.mService == null) goto L6;
            this.mService.onBootPhase(phase);
            return;
        }

        @Override // com.android.server.SystemService
        public void onUserUnlocking(SystemService.TargetUser user) {
            if (this.mService == null) goto L6;
            this.mService.onUnlockUser(user.getUserIdentifier());
            return;
        }
    }

    private final class LocalService extends WallpaperManagerInternal {
        final /* synthetic */ WallpaperManagerService this$0;

        /* synthetic */ LocalService(WallpaperManagerService r1, WallpaperManagerServiceIA r2) {
            this(r1);
        }

        private LocalService(WallpaperManagerService r1) {
            this.this$0 = r1;
        }

        @Override // com.android.server.wallpaper.WallpaperManagerInternal
        public void onDisplayAddSystemDecorations(int displayId) {
            WallpaperManagerService.m9534$$Nest$monDisplayAddSystemDecorationsInternal(this.this$0, displayId);
        }

        @Override // com.android.server.wallpaper.WallpaperManagerInternal
        public void onDisplayRemoveSystemDecorations(int displayId) {
            WallpaperManagerService.m9535$$Nest$monDisplayRemovedInternal(this.this$0, displayId);
        }

        @Override // com.android.server.wallpaper.WallpaperManagerInternal
        public void onScreenTurnedOn(int displayId) {
            WallpaperManagerService.m9529$$Nest$mnotifyScreenTurnedOn(this.this$0, displayId);
        }

        @Override // com.android.server.wallpaper.WallpaperManagerInternal
        public void onScreenTurningOn(int displayId) {
            WallpaperManagerService.m9530$$Nest$mnotifyScreenTurningOn(this.this$0, displayId);
        }
    }

    class MyPackageMonitor extends PackageMonitor {
        final /* synthetic */ WallpaperManagerService this$0;

        /* synthetic */ MyPackageMonitor(WallpaperManagerService r1, WallpaperManagerServiceIA r2) {
            this(r1);
        }

        private MyPackageMonitor(WallpaperManagerService this$0) {
            this.this$0 = this$0;
            super(true);
        }

        public void onPackageUpdateFinished(String packageName, int uid) {
            Object r1 = this.this$0.mLock;
            monitor-enter(r1);
        L8:
            th = move-exception;
            throw th;
        L5:
            if (WallpaperManagerService.m9508$$Nest$fgetmCurrentUserId(this.this$0) == getChangingUserId()) goto L10;
            monitor-exit(r1);     // Catch: Throwable -> L8
            return;
        L10:
            WallpaperData[] r0 = WallpaperManagerService.m9525$$Nest$mgetWallpapers(this.this$0);     // Catch: Throwable -> L8
            int r2 = r0.length;     // Catch: Throwable -> L8
            int r4 = 0;
        L11:
            if (r4 >= r2) goto L20;
            WallpaperData wallpaper = r0[r4];     // Catch: Throwable -> L8
            ComponentName wpService = wallpaper.getComponent();     // Catch: Throwable -> L8
            if (wpService == null) goto L19;
            if (wpService.getPackageName().equals(packageName) == false) goto L19;
            Slog.i(WallpaperManagerService.TAG, "Wallpaper " + wpService + " update has finished");     // Catch: Throwable -> L8
            wallpaper.wallpaperUpdating = false;     // Catch: Throwable -> L8
            WallpaperManagerService.m9523$$Nest$mdetachWallpaperLocked(this.this$0, wallpaper);     // Catch: Throwable -> L8
            wallpaper.mBindSource = WallpaperData.BindSource.PACKAGE_UPDATE_FINISHED;     // Catch: Throwable -> L8
            if (this.this$0.bindWallpaperComponentLocked(wpService, false, false, wallpaper, null) == true) goto L19;
            Slog.w(WallpaperManagerService.TAG, "Wallpaper " + wpService + " no longer available; reverting to default");     // Catch: Throwable -> L8
            WallpaperManagerService.m9522$$Nest$mclearWallpaperLocked(this.this$0, wallpaper.mWhich, wallpaper.userId, false, null);     // Catch: Throwable -> L8
        L19:
            r4 = r4 + 1;     // Catch: Throwable -> L8
            goto L11
        L20:
            monitor-exit(r1);     // Catch: Throwable -> L8
        }

        public void onPackageModified(String packageName) {
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
        L8:
            th = move-exception;
            throw th;
        L5:
            if (WallpaperManagerService.m9508$$Nest$fgetmCurrentUserId(this.this$0) == getChangingUserId()) goto L10;
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L10:
            WallpaperData[] r1 = WallpaperManagerService.m9525$$Nest$mgetWallpapers(this.this$0);     // Catch: Throwable -> L8
            int r2 = r1.length;     // Catch: Throwable -> L8
            int r3 = 0;
        L11:
            if (r3 >= r2) goto L18;
            WallpaperData wallpaper = r1[r3];     // Catch: Throwable -> L8
            if (wallpaper.getComponent() == null) goto L17;
            if (wallpaper.getComponent().getPackageName().equals(packageName) == false) goto L17;
            doPackagesChangedLocked(true, wallpaper);     // Catch: Throwable -> L8
        L17:
            r3 = r3 + 1;     // Catch: Throwable -> L8
            goto L11
        L18:
            monitor-exit(r0);     // Catch: Throwable -> L8
        }

        public void onPackageUpdateStarted(String packageName, int uid) {
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
        L8:
            th = move-exception;
            throw th;
        L5:
            if (WallpaperManagerService.m9508$$Nest$fgetmCurrentUserId(this.this$0) == getChangingUserId()) goto L10;
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L10:
            WallpaperData[] r1 = WallpaperManagerService.m9525$$Nest$mgetWallpapers(this.this$0);     // Catch: Throwable -> L8
            int r2 = r1.length;     // Catch: Throwable -> L8
            int r3 = 0;
        L11:
            if (r3 >= r2) goto L20;
            WallpaperData wallpaper = r1[r3];     // Catch: Throwable -> L8
            if (wallpaper.getComponent() == null) goto L19;
            if (wallpaper.getComponent().getPackageName().equals(packageName) == false) goto L19;
            Slog.i(WallpaperManagerService.TAG, "Wallpaper service " + wallpaper.getComponent() + " is updating");     // Catch: Throwable -> L8
            wallpaper.wallpaperUpdating = true;     // Catch: Throwable -> L8
            if (wallpaper.connection == null) goto L19;
            FgThread.getHandler().removeCallbacks(WallpaperConnection.m9543$$Nest$fgetmResetRunnable(wallpaper.connection));     // Catch: Throwable -> L8
        L19:
            r3 = r3 + 1;     // Catch: Throwable -> L8
            goto L11
        L20:
            monitor-exit(r0);     // Catch: Throwable -> L8
        }

        public boolean onHandleForceStop(Intent intent, String[] packages, int uid, boolean doit) {
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
            boolean changed = false;
            int r4 = 0;
            if (WallpaperManagerService.m9508$$Nest$fgetmCurrentUserId(this.this$0) == getChangingUserId()) goto L11;
            monitor-exit(r0);     // Catch: Throwable -> L9
            return false;
        L11:
            WallpaperData[] r2 = WallpaperManagerService.m9525$$Nest$mgetWallpapers(this.this$0);     // Catch: Throwable -> L9
            int r3 = r2.length;     // Catch: Throwable -> L9
        L12:
            if (r4 >= r3) goto L14;
            WallpaperData wallpaper = r2[r4];     // Catch: Throwable -> L9
            boolean res = doPackagesChangedLocked(doit, wallpaper);     // Catch: Throwable -> L9
            changed = changed | res;     // Catch: Throwable -> L9
            r4 = r4 + 1;     // Catch: Throwable -> L9
            goto L12
        L14:
            monitor-exit(r0);     // Catch: Throwable -> L9
            return changed;
        L9:
            th = move-exception;
            throw th;
        }

        public void onSomePackagesChanged() {
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
        L8:
            th = move-exception;
            throw th;
        L5:
            if (WallpaperManagerService.m9508$$Nest$fgetmCurrentUserId(this.this$0) == getChangingUserId()) goto L10;
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L10:
            WallpaperData[] r1 = WallpaperManagerService.m9525$$Nest$mgetWallpapers(this.this$0);     // Catch: Throwable -> L8
            int r2 = r1.length;     // Catch: Throwable -> L8
            int r3 = 0;
        L11:
            if (r3 >= r2) goto L13;
            WallpaperData wallpaper = r1[r3];     // Catch: Throwable -> L8
            doPackagesChangedLocked(true, wallpaper);     // Catch: Throwable -> L8
            r3 = r3 + 1;     // Catch: Throwable -> L8
            goto L11
        L13:
            monitor-exit(r0);     // Catch: Throwable -> L8
        }

        boolean doPackagesChangedLocked(boolean doit, WallpaperData wallpaper) {
            boolean changed = false;
            if (wallpaper.getComponent() == null) goto L12;
            int change = isPackageDisappearing(wallpaper.getComponent().getPackageName());
            if (change != 3) goto L7;
        L8:
            changed = true;
            if (doit == false) goto L12;
            Slog.e(WallpaperManagerService.TAG, "Wallpaper uninstalled, removing: " + wallpaper.getComponent());
            WallpaperManagerService.m9522$$Nest$mclearWallpaperLocked(this.this$0, wallpaper.mWhich, wallpaper.userId, false, null);
            goto L12
        L7:
            if (change == 2) goto L8;
        L12:
            if (wallpaper.getComponent() != null) goto L14;
        L23:
            return changed;
        L14:
            if (isPackageModified(wallpaper.getComponent().getPackageName()) == false) goto L23;
            ServiceInfo serviceInfo = null;
            serviceInfo = WallpaperManagerService.m9511$$Nest$fgetmIPackageManager(this.this$0).getServiceInfo(wallpaper.getComponent(), 786432, wallpaper.userId);     // Catch: RemoteException -> L18
        L20:
            if (serviceInfo != null) goto L23;
            Slog.e(WallpaperManagerService.TAG, "Wallpaper component gone, removing: " + wallpaper.getComponent());
            WallpaperManagerService.m9522$$Nest$mclearWallpaperLocked(this.this$0, wallpaper.mWhich, wallpaper.userId, false, null);
        L18:
            e = move-exception;
            Slog.w(WallpaperManagerService.TAG, "Failed to call IPackageManager.getServiceInfo", e);
            goto L20
        }
    }

    class WallpaperConnection extends IWallpaperConnection.Stub implements ServiceConnection {
        private static final long WALLPAPER_RECONNECT_TIMEOUT_MS = 10000;
        final int mClientUid;
        private Runnable mDisconnectRunnable;
        private final SparseArray<DisplayConnector> mDisplayConnector;
        final WallpaperInfo mInfo;
        private int mLmkLimitRebindRetries;
        IRemoteCallback mReply;
        private Runnable mResetRunnable;
        IWallpaperService mService;
        private Runnable mTryToRebindRunnable;
        WallpaperData mWallpaper;
        final /* synthetic */ WallpaperManagerService this$0;

        /* JADX INFO: renamed from: $r8$lambda$0B1JnEA-s0vRYh09f94I-JMhj24, reason: not valid java name */
        public static /* synthetic */ void m9538$r8$lambda$0B1JnEAs0vRYh09f94IJMhj24(WallpaperConnection r0, RectF r1, WallpaperColors r2, int r3, DisplayConnector r4) {
            r0.lambda$onLocalWallpaperColorsChanged$3(r1, r2, r3, r4);
        }

        public static /* synthetic */ void $r8$lambda$BdRFLLROHn7y5KyiPBm7Siso88g(WallpaperConnection r0) {
            r0.tryToRebind();
        }

        public static /* synthetic */ void $r8$lambda$EmJuOUzceLvuC_2BxKjsoutWuQQ(WallpaperConnection r0) {
            r0.lambda$new$5();
        }

        /* JADX INFO: renamed from: $r8$lambda$HNl85I7-mKLGpIvrI1k8FSzxXtk, reason: not valid java name */
        public static /* synthetic */ boolean m9539$r8$lambda$HNl85I7mKLGpIvrI1k8FSzxXtk(WallpaperConnection r0, Display r1) {
            return r0.lambda$initDisplayState$1(r1);
        }

        public static /* synthetic */ void $r8$lambda$cPEGnj8gduIeva9ONnRjFP0ZjhM(WallpaperConnection r0) {
            r0.lambda$new$0();
        }

        /* JADX INFO: renamed from: $r8$lambda$dhc-7cFphpmb8ozYRVQqHr7Qhjk, reason: not valid java name */
        public static /* synthetic */ void m9540$r8$lambda$dhc7cFphpmb8ozYRVQqHr7Qhjk(RectF r0, WallpaperColors r1, ILocalWallpaperColorConsumer r2) {
            lambda$onLocalWallpaperColorsChanged$2(r0, r1, r2);
        }

        public static /* synthetic */ void $r8$lambda$r6LDOul54fj7yJtAURoXEzK_7pk(DisplayConnector r0) {
            lambda$onServiceDisconnected$4(r0);
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmDisconnectRunnable, reason: not valid java name */
        static /* bridge */ /* synthetic */ Runnable m9541$$Nest$fgetmDisconnectRunnable(WallpaperConnection r0) {
            return r0.mDisconnectRunnable;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmDisplayConnector, reason: not valid java name */
        static /* bridge */ /* synthetic */ SparseArray m9542$$Nest$fgetmDisplayConnector(WallpaperConnection r0) {
            return r0.mDisplayConnector;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmResetRunnable, reason: not valid java name */
        static /* bridge */ /* synthetic */ Runnable m9543$$Nest$fgetmResetRunnable(WallpaperConnection r0) {
            return r0.mResetRunnable;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmTryToRebindRunnable, reason: not valid java name */
        static /* bridge */ /* synthetic */ Runnable m9544$$Nest$fgetmTryToRebindRunnable(WallpaperConnection r0) {
            return r0.mTryToRebindRunnable;
        }

        /* JADX INFO: renamed from: -$$Nest$mappendConnectorWithCondition, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m9545$$Nest$mappendConnectorWithCondition(WallpaperConnection r0, Predicate r1) {
            r0.appendConnectorWithCondition(r1);
        }

        private /* synthetic */ void lambda$new$0() {
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
        L9:
            th = move-exception;
            throw th;
        L5:
            if (WallpaperManagerService.m9516$$Nest$fgetmShuttingDown(this.this$0) == false) goto L12;
            Slog.i(WallpaperManagerService.TAG, "Ignoring relaunch timeout during shutdown");     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L12:
            if (this.mWallpaper.connection != null) goto L17;
            Slog.w(WallpaperManagerService.TAG, "Trying to reset an intentionally disconnected wallpaper!");     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L17:
            if (this.mWallpaper.wallpaperUpdating == false) goto L19;
        L21:
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L19:
            if (this.mWallpaper.userId != WallpaperManagerService.m9508$$Nest$fgetmCurrentUserId(this.this$0)) goto L21;
            Slog.w(WallpaperManagerService.TAG, "Wallpaper reconnect timed out for " + this.mWallpaper.getComponent() + ", reverting to built-in wallpaper!");     // Catch: Throwable -> L9
            WallpaperManagerService.m9522$$Nest$mclearWallpaperLocked(this.this$0, this.mWallpaper.mWhich, this.mWallpaper.userId, false, null);     // Catch: Throwable -> L9
            goto L21
        }

        WallpaperConnection(WallpaperManagerService this$0, WallpaperInfo info, WallpaperData wallpaper, int clientUid) {
            this.this$0 = this$0;
            this.mDisplayConnector = new SparseArray();
            this.mLmkLimitRebindRetries = 3;
            this.mResetRunnable = new WallpaperManagerService$WallpaperConnection$$ExternalSyntheticLambda0(this);
            this.mTryToRebindRunnable = new WallpaperManagerService$WallpaperConnection$$ExternalSyntheticLambda1(this);
            this.mDisconnectRunnable = new WallpaperManagerService$WallpaperConnection$$ExternalSyntheticLambda2(this);
            this.mInfo = info;
            this.mWallpaper = wallpaper;
            this.mClientUid = clientUid;
            initDisplayState();
        }

        private void initDisplayState() {
            if (this.mWallpaper.equals(this.this$0.mFallbackWallpaper) == true) goto L6;
            appendConnectorWithCondition(new WallpaperManagerService$WallpaperConnection$$ExternalSyntheticLambda3(this));
            return;
        }

        private /* synthetic */ boolean lambda$initDisplayState$1(Display display) {
            int displayId = display.getDisplayId();
            if (display.getDisplayId() != 0) goto L6;
            return true;
        L6:
            if (this.this$0.mWallpaperDisplayHelper.isUsableDisplay(display, this.mClientUid) == true) goto L8;
        L10:
            return false;
        L8:
            if (this.this$0.isWallpaperCompatibleForDisplay(displayId, this) == false) goto L10;
            return true;
        }

        private void appendConnectorWithCondition(Predicate<Display> tester) {
            Display[] displays = this.this$0.mWallpaperDisplayHelper.getDisplays();
            int r1 = displays.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L10;
            Display display = displays[r2];
            if (tester.test(display) == false) goto L9;
            int displayId = display.getDisplayId();
            DisplayConnector connector = this.mDisplayConnector.get(displayId);
            if (connector != null) goto L9;
            this.mDisplayConnector.append(displayId, new DisplayConnector(this.this$0, displayId, this.mWallpaper.mWhich));
        L9:
            r2 = r2 + 1;
            goto L3
        }

        void forEachDisplayConnector(Consumer<DisplayConnector> action) {
            int i = this.mDisplayConnector.size() - 1;
        L3:
            if (i < 0) goto L6;
            DisplayConnector connector = this.mDisplayConnector.valueAt(i);
            action.accept(connector);
            i = i - 1;
            goto L3
        }

        int getConnectedEngineSize() {
            int engineSize = 0;
            int i = this.mDisplayConnector.size() - 1;
        L3:
            if (i < 0) goto L9;
            DisplayConnector connector = this.mDisplayConnector.valueAt(i);
            if (connector.mEngine == null) goto L7;
            engineSize = engineSize + 1;
        L7:
            i = i - 1;
            goto L3
        L9:
            return engineSize;
        }

        DisplayConnector getDisplayConnectorOrCreate(int displayId) {
            DisplayConnector connector = this.mDisplayConnector.get(displayId);
            if (connector == null) goto L5;
            return connector;
        L5:
            if (this.this$0.mWallpaperDisplayHelper.isUsableDisplay(displayId, this.mClientUid) == false) goto L9;
            DisplayConnector connector2 = new DisplayConnector(this.this$0, displayId, this.mWallpaper.mWhich);
            this.mDisplayConnector.append(displayId, connector2);
            return connector2;
        L9:
            return connector;
        }

        boolean containsDisplay(int displayId) {
            if (this.mDisplayConnector.get(displayId) == null) goto L5;
            return true;
        L5:
            return false;
        }

        void removeDisplayConnector(int displayId) {
            DisplayConnector connector = this.mDisplayConnector.get(displayId);
            if (connector == null) goto L6;
            this.mDisplayConnector.remove(displayId);
            return;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName name, IBinder service) {
            TimingsTraceAndSlog t = new TimingsTraceAndSlog(WallpaperManagerService.TAG);
            t.traceBegin("WPMS.onServiceConnected-" + name);
            Object r1 = this.this$0.mLock;
            monitor-enter(r1);
        L9:
            th = move-exception;
            throw th;
        L5:
            if (this.mWallpaper.connection != this) goto L12;
            this.mService = IWallpaperService.Stub.asInterface(service);     // Catch: Throwable -> L9
            WallpaperManagerService.m9520$$Nest$mattachServiceLocked(this.this$0, this, this.mWallpaper);     // Catch: Throwable -> L9
            if (this.mWallpaper.equals(this.this$0.mFallbackWallpaper) == true) goto L11;
            this.this$0.saveSettingsLocked(this.mWallpaper.userId);     // Catch: Throwable -> L9
        L11:
            FgThread.getHandler().removeCallbacks(this.mResetRunnable);     // Catch: Throwable -> L9
            WallpaperManagerService.m9507$$Nest$fgetmContext(this.this$0).getMainThreadHandler().removeCallbacks(this.mTryToRebindRunnable);     // Catch: Throwable -> L9
            WallpaperManagerService.m9507$$Nest$fgetmContext(this.this$0).getMainThreadHandler().removeCallbacks(this.mDisconnectRunnable);     // Catch: Throwable -> L9
        L12:
            monitor-exit(r1);     // Catch: Throwable -> L9
            t.traceEnd();
        }

        public void onLocalWallpaperColorsChanged(final RectF area, final WallpaperColors colors, final int displayId) {
            forEachDisplayConnector(new WallpaperManagerService$WallpaperConnection$$ExternalSyntheticLambda5(this, area, colors, displayId));
        }

        private /* synthetic */ void lambda$onLocalWallpaperColorsChanged$3(final RectF area, final WallpaperColors colors, int displayId, DisplayConnector displayConnector) {
            Consumer<ILocalWallpaperColorConsumer> callback = new WallpaperManagerService$WallpaperConnection$$ExternalSyntheticLambda4(area, colors);
            Object r1 = this.this$0.mLock;
            monitor-enter(r1);
            WallpaperManagerService.m9514$$Nest$fgetmLocalColorRepo(this.this$0).forEachCallback(callback, area, displayId);     // Catch: Throwable -> L7
            monitor-exit(r1);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        private static /* synthetic */ void lambda$onLocalWallpaperColorsChanged$2(RectF area, WallpaperColors colors, ILocalWallpaperColorConsumer cb) {
            cb.onColorsChanged(area, colors);     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            Slog.w(WallpaperManagerService.TAG, "Failed to notify local color callbacks", e);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName name) {
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
            Slog.w(WallpaperManagerService.TAG, "Wallpaper service gone: " + name);     // Catch: Throwable -> L7
            if (Objects.equals(name, this.mWallpaper.getComponent()) == true) goto L9;
            Slog.e(WallpaperManagerService.TAG, "Does not match expected wallpaper component " + this.mWallpaper.getComponent());     // Catch: Throwable -> L7
        L9:
            this.mService = null;     // Catch: Throwable -> L7
            forEachDisplayConnector(new WallpaperManagerService$WallpaperConnection$$ExternalSyntheticLambda6());     // Catch: Throwable -> L7
            if (this.mWallpaper.connection == this) goto L12;
        L14:
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L12:
            if (this.mWallpaper.wallpaperUpdating == true) goto L14;
            WallpaperManagerService.m9507$$Nest$fgetmContext(this.this$0).getMainThreadHandler().postDelayed(this.mDisconnectRunnable, 1000);     // Catch: Throwable -> L7
        L7:
            th = move-exception;
            throw th;
        }

        private static /* synthetic */ void lambda$onServiceDisconnected$4(DisplayConnector connector) {
            connector.mEngine = null;
        }

        private void scheduleTimeoutLocked() {
            Handler fgHandler = FgThread.getHandler();
            fgHandler.removeCallbacks(this.mResetRunnable);
            fgHandler.postDelayed(this.mResetRunnable, 10000);
            Slog.i(WallpaperManagerService.TAG, "Started wallpaper reconnect timeout for " + this.mWallpaper.getComponent());
        }

        private void tryToRebind() {
            Object r1 = this.this$0.mLock;
            monitor-enter(r1);
        L8:
            th = move-exception;
            throw th;
        L5:
            if (this.mWallpaper.wallpaperUpdating == false) goto L11;
            monitor-exit(r1);     // Catch: Throwable -> L8
            return;
        L11:
            if (this.mWallpaper.connection != null) goto L15;
            Slog.w(WallpaperManagerService.TAG, "Trying to rebind an intentionally disconnected wallpaper!");     // Catch: Throwable -> L8
            monitor-exit(r1);     // Catch: Throwable -> L8
            return;
        L15:
            WallpaperData r0 = this.mWallpaper;     // Catch: Throwable -> L8
            r0.mBindSource = WallpaperData.BindSource.CONNECTION_TRY_TO_REBIND;     // Catch: Throwable -> L8
            boolean success = this.this$0.bindWallpaperDescriptionLocked(this.mWallpaper.getDescription(), true, false, this.mWallpaper, null);     // Catch: Throwable -> L8
            if (success == false) goto L19;
            this.mWallpaper.connection.scheduleTimeoutLocked();     // Catch: Throwable -> L8
        L22:
            monitor-exit(r1);     // Catch: Throwable -> L8
            return;
        L19:
            if ((SystemClock.uptimeMillis() - this.mWallpaper.lastDiedTime) >= 10000) goto L21;
            Slog.w(WallpaperManagerService.TAG, "Rebind fail! Try again later");     // Catch: Throwable -> L8
            WallpaperManagerService.m9507$$Nest$fgetmContext(this.this$0).getMainThreadHandler().postDelayed(this.mTryToRebindRunnable, 1000);     // Catch: Throwable -> L8
            goto L22
        L21:
            Slog.w(WallpaperManagerService.TAG, "Reverting to built-in wallpaper!");     // Catch: Throwable -> L8
            WallpaperManagerService.m9522$$Nest$mclearWallpaperLocked(this.this$0, this.mWallpaper.mWhich, this.mWallpaper.userId, false, null);     // Catch: Throwable -> L8
            String flattened = this.mWallpaper.getComponent().flattenToString();     // Catch: Throwable -> L8
            EventLog.writeEvent(EventLogTags.WP_WALLPAPER_CRASHED, flattened.substring(0, Math.min(flattened.length(), 128)));     // Catch: Throwable -> L8
            goto L22
        }

        private /* synthetic */ void lambda$new$5() {
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
        L19:
            th = move-exception;
            throw th;
        L5:
            if (this != this.mWallpaper.connection) goto L39;
            ComponentName wpService = this.mWallpaper.getComponent();     // Catch: Throwable -> L19
            if (this.mWallpaper.wallpaperUpdating == true) goto L40;
            if (this.mWallpaper.userId != WallpaperManagerService.m9508$$Nest$fgetmCurrentUserId(this.this$0)) goto L40;
            if (Objects.equals(WallpaperManagerService.m9509$$Nest$fgetmDefaultWallpaperComponent(this.this$0), wpService) == true) goto L40;
            if (Objects.equals(WallpaperManagerService.m9512$$Nest$fgetmImageWallpaper(this.this$0), wpService) == true) goto L40;
            List<ApplicationExitInfo> reasonList = WallpaperManagerService.m9506$$Nest$fgetmActivityManager(this.this$0).getHistoricalProcessExitReasons(wpService.getPackageName(), 0, 1);     // Catch: Throwable -> L19
            int exitReason = 0;
            if (reasonList != null) goto L17;
        L21:
            Slog.d(WallpaperManagerService.TAG, "exitReason: " + exitReason);     // Catch: Throwable -> L19
            if (exitReason != 3) goto L33;
            if (isRunningOnLowMemory() == false) goto L27;
            Slog.i(WallpaperManagerService.TAG, "Rebind is delayed due to lmk");     // Catch: Throwable -> L19
            WallpaperManagerService.m9507$$Nest$fgetmContext(this.this$0).getMainThreadHandler().postDelayed(this.mTryToRebindRunnable, WallpaperManagerService.LMK_RECONNECT_DELAY_MS);     // Catch: Throwable -> L19
            this.mLmkLimitRebindRetries = 3;     // Catch: Throwable -> L19
            goto L40
        L27:
            if (this.mLmkLimitRebindRetries > 0) goto L31;
            Slog.w(WallpaperManagerService.TAG, "Reverting to built-in wallpaper due to lmk!");     // Catch: Throwable -> L19
            WallpaperManagerService.m9522$$Nest$mclearWallpaperLocked(this.this$0, this.mWallpaper.mWhich, this.mWallpaper.userId, false, null);     // Catch: Throwable -> L19
            this.mLmkLimitRebindRetries = 3;     // Catch: Throwable -> L19
            monitor-exit(r0);     // Catch: Throwable -> L19
            return;
        L31:
            this.mLmkLimitRebindRetries--;     // Catch: Throwable -> L19
            WallpaperManagerService.m9507$$Nest$fgetmContext(this.this$0).getMainThreadHandler().postDelayed(this.mTryToRebindRunnable, WallpaperManagerService.LMK_RECONNECT_DELAY_MS);     // Catch: Throwable -> L19
            goto L40
        L33:
            if (this.mWallpaper.lastDiedTime != 0) goto L35;
        L37:
            this.mWallpaper.lastDiedTime = SystemClock.uptimeMillis();     // Catch: Throwable -> L19
            tryToRebind();     // Catch: Throwable -> L19
            goto L40
        L35:
            if ((this.mWallpaper.lastDiedTime + 10000) <= SystemClock.uptimeMillis()) goto L37;
            Slog.w(WallpaperManagerService.TAG, "Reverting to built-in wallpaper!");     // Catch: Throwable -> L19
            WallpaperManagerService.m9522$$Nest$mclearWallpaperLocked(this.this$0, 1, this.mWallpaper.userId, false, null);     // Catch: Throwable -> L19
            goto L40
        L17:
            if (reasonList.isEmpty() == true) goto L21;
            ApplicationExitInfo info = reasonList.get(0);     // Catch: Throwable -> L19
            exitReason = info.getReason();     // Catch: Throwable -> L19
        L40:
            monitor-exit(r0);     // Catch: Throwable -> L19
            return;
        L39:
            Slog.i(WallpaperManagerService.TAG, "Wallpaper changed during disconnect tracking; ignoring");     // Catch: Throwable -> L19
            goto L40
        }

        private boolean isRunningOnLowMemory() {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            WallpaperManagerService.m9506$$Nest$fgetmActivityManager(this.this$0).getMemoryInfo(memoryInfo);
            double availableMBsInPercentage = (memoryInfo.availMem / memoryInfo.totalMem) * 100.0d;
            if (availableMBsInPercentage >= WallpaperManagerService.LMK_LOW_THRESHOLD_MEMORY_PERCENTAGE) goto L5;
            return true;
        L5:
            return false;
        }

        public void onWallpaperColorsChanged(WallpaperColors primaryColors, int displayId) {
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
            boolean isImageWallpaper = WallpaperManagerService.m9512$$Nest$fgetmImageWallpaper(this.this$0).equals(this.mWallpaper.getComponent());     // Catch: Throwable -> L8
            if (isImageWallpaper == false) goto L10;
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L10:
            this.mWallpaper.primaryColors = primaryColors;     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            WallpaperManagerService.m9532$$Nest$mnotifyWallpaperColorsChangedOnDisplay(this.this$0, this.mWallpaper, displayId);
            return;
        L8:
            th = move-exception;
            throw th;
        }

        public void attachEngine(IWallpaperEngine engine, int displayId) {
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
            DisplayConnector connector = getDisplayConnectorOrCreate(displayId);     // Catch: Throwable -> L13
            if (connector == null) goto L40;
            connector.mEngine = engine;     // Catch: Throwable -> L13
            connector.ensureStatusHandled();     // Catch: Throwable -> L13
            if (this.mInfo != null) goto L9;
        L45:
            connector.mEngine.requestWallpaperColors();     // Catch: Throwable -> L13 RemoteException -> L20
        L22:
            List<RectF> areas = WallpaperManagerService.m9514$$Nest$fgetmLocalColorRepo(this.this$0).getAreasByDisplayId(displayId);     // Catch: Throwable -> L13
            if (areas == null) goto L32;
            if (areas.size() == 0) goto L32;
            connector.mEngine.addLocalColorsAreas(areas);     // Catch: Throwable -> L13 RemoteException -> L28
        L28:
            e = move-exception;
            Slog.w(WallpaperManagerService.TAG, "Failed to register local colors areas", e);     // Catch: Throwable -> L13
        L32:
            if (this.mWallpaper.mWallpaperDimAmount != 0.0f) goto L49;
        L37:
            monitor-exit(r0);     // Catch: Throwable -> L13
            return;
        L49:
            connector.mEngine.applyDimming(this.mWallpaper.mWallpaperDimAmount);     // Catch: Throwable -> L13 RemoteException -> L35
        L35:
            e = move-exception;
            Slog.w(WallpaperManagerService.TAG, "Failed to dim wallpaper", e);     // Catch: Throwable -> L13
            goto L37
        L20:
            e = move-exception;
            Slog.w(WallpaperManagerService.TAG, "Failed to request wallpaper colors", e);     // Catch: Throwable -> L13
            goto L22
        L9:
            if (this.mInfo.supportsAmbientMode() == false) goto L45;
            if (displayId != 0) goto L45;
            connector.mEngine.setInAmbientMode(WallpaperManagerService.m9513$$Nest$fgetmInAmbientMode(this.this$0), 0);     // Catch: Throwable -> L13 RemoteException -> L15
        L15:
            e = move-exception;
            Slog.w(WallpaperManagerService.TAG, "Failed to set ambient mode state", e);     // Catch: Throwable -> L13
            goto L45
        L40:
            throw new IllegalStateException("Connector has already been destroyed");     // Catch: Throwable -> L13
        L13:
            th = move-exception;
            throw th;
        }

        public void engineShown(IWallpaperEngine engine) {
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
        L11:
            th = move-exception;
            throw th;
        L5:
            if (this.mReply == null) goto L21;
            TimingsTraceAndSlog t = new TimingsTraceAndSlog(WallpaperManagerService.TAG);     // Catch: Throwable -> L11
            t.traceBegin("WPMS.mReply.sendResult");     // Catch: Throwable -> L11
            long ident = Binder.clearCallingIdentity();     // Catch: Throwable -> L11
            this.mReply.sendResult(null);     // Catch: Throwable -> L13 RemoteException -> L15
        L9:
            Binder.restoreCallingIdentity(ident);     // Catch: Throwable -> L11
            t.traceEnd();     // Catch: Throwable -> L11
            this.mReply = null;     // Catch: Throwable -> L11
            goto L21
        L13:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);     // Catch: Throwable -> L11
            throw th;     // Catch: Throwable -> L11
        L15:
            e = move-exception;
            Slog.d(WallpaperManagerService.TAG, "Failed to send callback!", e);     // Catch: Throwable -> L13
        L21:
            monitor-exit(r0);     // Catch: Throwable -> L11
        }

        public ParcelFileDescriptor setWallpaper(String name) {
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
        L9:
            th = move-exception;
            throw th;
        L5:
            if (this.mWallpaper.connection != this) goto L11;
            ParcelFileDescriptor r1 = this.this$0.updateWallpaperBitmapLocked(name, this.mWallpaper, null);     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return r1;
        L11:
            monitor-exit(r0);     // Catch: Throwable -> L9
            return null;
        }
    }

    class WallpaperDestinationChangeHandler {
        final WallpaperData mNewWallpaper;
        final WallpaperData mOriginalSystem;
        final /* synthetic */ WallpaperManagerService this$0;

        WallpaperDestinationChangeHandler(WallpaperManagerService this$0, WallpaperData newWallpaper) {
            this.this$0 = this$0;
            this.mNewWallpaper = newWallpaper;
            WallpaperData sysWp = (WallpaperData) WallpaperManagerService.m9517$$Nest$fgetmWallpaperMap(this$0).get(newWallpaper.userId);
            this.mOriginalSystem = new WallpaperData(sysWp);
        }

        void complete() {
            if (this.mNewWallpaper.mSystemWasBoth == true) goto L5;
        L54:
            this.this$0.saveSettingsLocked(this.mNewWallpaper.userId);
            if (WallpaperManagerService.DEBUG == false) goto L58;
            Slog.v(WallpaperManagerService.TAG, "--- wallpaper changed --");
            Slog.v(WallpaperManagerService.TAG, "new sysWp: " + WallpaperManagerService.m9517$$Nest$fgetmWallpaperMap(this.this$0).get(WallpaperManagerService.m9508$$Nest$fgetmCurrentUserId(this.this$0)));
            Slog.v(WallpaperManagerService.TAG, "new lockWp: " + WallpaperManagerService.m9515$$Nest$fgetmLockWallpaperMap(this.this$0).get(WallpaperManagerService.m9508$$Nest$fgetmCurrentUserId(this.this$0)));
            Slog.v(WallpaperManagerService.TAG, "new lastWp: " + this.this$0.mLastWallpaper);
            Slog.v(WallpaperManagerService.TAG, "new lastLockWp: " + this.this$0.mLastLockWallpaper);
            return;
        L58:
            return;
        L5:
            if (WallpaperManagerService.DEBUG == false) goto L7;
            Slog.v(WallpaperManagerService.TAG, "Handling change from system+lock wallpaper");
        L7:
            boolean isLockWpUpdated = true;
            if (this.mNewWallpaper.mWhich != 1) goto L42;
            boolean originalIsStatic = WallpaperManagerService.m9512$$Nest$fgetmImageWallpaper(this.this$0).equals(this.mOriginalSystem.getComponent());
            WallpaperData currentLock = (WallpaperData) WallpaperManagerService.m9515$$Nest$fgetmLockWallpaperMap(this.this$0).get(this.mNewWallpaper.userId);
            if (currentLock != null) goto L12;
        L14:
            isLockWpUpdated = false;
        L15:
            if (isLockWpUpdated == false) goto L17;
            WallpaperManagerService.m9523$$Nest$mdetachWallpaperLocked(this.this$0, this.mOriginalSystem);
            goto L54
        L17:
            if (originalIsStatic == false) goto L37;
            WallpaperData lockWp = (WallpaperData) WallpaperManagerService.m9515$$Nest$fgetmLockWallpaperMap(this.this$0).get(this.mNewWallpaper.userId);
            if (lockWp == null) goto L27;
            if (this.mOriginalSystem.connection == null) goto L27;
            if (WallpaperManagerService.DEBUG == false) goto L25;
            Slog.v(WallpaperManagerService.TAG, "static system+lock to system success");
        L25:
            lockWp.setDescription(this.mOriginalSystem.getDescription());
            lockWp.connection = this.mOriginalSystem.connection;
            lockWp.connection.mWallpaper = lockWp;
            this.mOriginalSystem.mWhich = 2;
            WallpaperManagerService.m9537$$Nest$mupdateEngineFlags(this.this$0, this.mOriginalSystem);
        L27:
            if (WallpaperManagerService.DEBUG == false) goto L29;
            Slog.v(WallpaperManagerService.TAG, "static system+lock to system failure");
        L29:
            WallpaperData currentSystem = (WallpaperData) WallpaperManagerService.m9517$$Nest$fgetmWallpaperMap(this.this$0).get(this.mNewWallpaper.userId);
            if (DesktopModeHelper.isDeviceEligibleForDesktopExperienceWallpaper(WallpaperManagerService.m9507$$Nest$fgetmContext(this.this$0)) == true) goto L32;
        L34:
            currentSystem.mWhich = 3;
            WallpaperManagerService.m9537$$Nest$mupdateEngineFlags(this.this$0, currentSystem);
            WallpaperManagerService.m9515$$Nest$fgetmLockWallpaperMap(this.this$0).remove(this.mNewWallpaper.userId);
            goto L54
        L32:
            if (currentSystem.connection == null) goto L34;
            currentSystem.connection.mWallpaper = currentSystem;
            goto L34
        L37:
            if (WallpaperManagerService.DEBUG == false) goto L39;
            Slog.v(WallpaperManagerService.TAG, "live system+lock to system success");
        L39:
            this.mOriginalSystem.mWhich = 2;
            WallpaperManagerService.m9537$$Nest$mupdateEngineFlags(this.this$0, this.mOriginalSystem);
            WallpaperManagerService.m9515$$Nest$fgetmLockWallpaperMap(this.this$0).put(this.mNewWallpaper.userId, this.mOriginalSystem);
            this.this$0.mLastLockWallpaper = this.mOriginalSystem;
            goto L54
        L12:
            if (currentLock.wallpaperId == this.mOriginalSystem.wallpaperId) goto L14;
        L42:
            if (this.mNewWallpaper.mWhich != 2) goto L54;
            if (WallpaperManagerService.DEBUG == false) goto L46;
            Slog.v(WallpaperManagerService.TAG, "system+lock to lock");
        L46:
            WallpaperData currentSystem2 = (WallpaperData) WallpaperManagerService.m9517$$Nest$fgetmWallpaperMap(this.this$0).get(this.mNewWallpaper.userId);
            if (currentSystem2.wallpaperId != this.mOriginalSystem.wallpaperId) goto L54;
            if (DesktopModeHelper.isDeviceEligibleForDesktopExperienceWallpaper(WallpaperManagerService.m9507$$Nest$fgetmContext(this.this$0)) == true) goto L51;
        L53:
            currentSystem2.mWhich = 1;
            WallpaperManagerService.m9537$$Nest$mupdateEngineFlags(this.this$0, currentSystem2);
            goto L54
        L51:
            if (currentSystem2.connection == null) goto L53;
            currentSystem2.connection.mWallpaper = currentSystem2;
            goto L53
        }
    }

    class WallpaperObserver extends FileObserver {
        final int mUserId;
        final WallpaperData mWallpaper;
        final File mWallpaperDir;
        final File mWallpaperFile;
        final File mWallpaperLockFile;
        final /* synthetic */ WallpaperManagerService this$0;

        public WallpaperObserver(WallpaperManagerService this$0, WallpaperData wallpaper) {
            this.this$0 = this$0;
            super(WallpaperUtils.getWallpaperDir(wallpaper.userId).getAbsolutePath(), 1672);
            this.mUserId = wallpaper.userId;
            this.mWallpaperDir = WallpaperUtils.getWallpaperDir(wallpaper.userId);
            this.mWallpaper = wallpaper;
            this.mWallpaperFile = new File(this.mWallpaperDir, "wallpaper_orig");
            this.mWallpaperLockFile = new File(this.mWallpaperDir, "wallpaper_lock_orig");
        }

        WallpaperData dataForEvent(boolean lockChanged) {
            WallpaperData wallpaper = null;
            Object r1 = this.this$0.mLock;
            monitor-enter(r1);
            if (lockChanged == true) goto L17;
        L8:
            if (wallpaper != null) goto L10;
            wallpaper = (WallpaperData) WallpaperManagerService.m9517$$Nest$fgetmWallpaperMap(this.this$0).get(this.mUserId);     // Catch: Throwable -> L6
        L10:
            monitor-exit(r1);     // Catch: Throwable -> L6
            if (wallpaper == null) goto L14;
            return wallpaper;
        L14:
            return this.mWallpaper;
        L6:
            th = move-exception;
            throw th;
        L17:
            wallpaper = (WallpaperData) WallpaperManagerService.m9515$$Nest$fgetmLockWallpaperMap(this.this$0).get(this.mUserId);     // Catch: Throwable -> L6
            goto L8
        }

        private void updateWallpapers(int event, String path) {
            File changedFile = new File(this.mWallpaperDir, path);
            boolean sysWallpaperChanged = this.mWallpaperFile.equals(changedFile);
            boolean lockWallpaperChanged = this.mWallpaperLockFile.equals(changedFile);
            final WallpaperData wallpaper = dataForEvent(lockWallpaperChanged);
            if (event != 128) goto L5;
            boolean r0 = true;
        L6:
            boolean moved = r0;
            if (event == 8) goto L11;
            if (moved == true) goto L11;
            boolean written = false;
        L12:
            if (moved == false) goto L15;
            if (lockWallpaperChanged == false) goto L15;
            boolean isMigration = true;
        L16:
            if (moved == false) goto L19;
            if (isMigration == true) goto L19;
            boolean isRestore = true;
        L21:
            if ((wallpaper.mWhich & 2) == 0) goto L23;
            boolean isAppliedToLock = true;
        L25:
            if (wallpaper.getComponent() == null) goto L31;
            if (event != 8) goto L31;
            if (wallpaper.imageWallpaperPending == true) goto L31;
            boolean needsUpdate = false;
        L32:
            if (isMigration == false) goto L34;
            return;
        L34:
            if (sysWallpaperChanged == true) goto L38;
            if (lockWallpaperChanged == true) goto L38;
            return;
        L38:
            if (WallpaperManagerService.DEBUG == false) goto L40;
            Slog.v(WallpaperManagerService.TAG, "Wallpaper file change: evt=" + event + " path=" + path + " sys=" + sysWallpaperChanged + " lock=" + lockWallpaperChanged + " imagePending=" + wallpaper.imageWallpaperPending + " mWhich=0x" + Integer.toHexString(wallpaper.mWhich) + " written=" + written + " isMigration=" + isMigration + " isRestore=" + isRestore + " isAppliedToLock=" + isAppliedToLock + " needsUpdate=" + needsUpdate);
        L40:
            boolean isAppliedToLock2 = isAppliedToLock;
            WallpaperManagerService.m9510$$Nest$fgetmIExt(this.this$0).traceUpdateWallpapers(event, path, wallpaper, sysWallpaperChanged, lockWallpaperChanged, written, isMigration, isRestore, isAppliedToLock2, needsUpdate);
            Object r2 = this.this$0.mLock;
            monitor-enter(r2);
            WallpaperManagerService.m9527$$Nest$mnotifyCallbacksLocked(this.this$0, wallpaper);     // Catch: Throwable -> L49
            if (written == false) goto L93;
            if (needsUpdate == false) goto L93;
            if (WallpaperManagerService.DEBUG == false) goto L51;
            Slog.v(WallpaperManagerService.TAG, "Setting new static wallpaper: which=" + wallpaper.mWhich);     // Catch: Throwable -> L49
        L51:
            WallpaperDestinationChangeHandler localSync = this.this$0.mPendingMigrationViaStatic;     // Catch: Throwable -> L49
            this.this$0.mPendingMigrationViaStatic = null;     // Catch: Throwable -> L49
            SELinux.restorecon(changedFile);     // Catch: Throwable -> L49
            if (isRestore == false) goto L58;
            if (WallpaperManagerService.DEBUG == false) goto L56;
            Slog.v(WallpaperManagerService.TAG, "Wallpaper restore; reloading metadata");     // Catch: Throwable -> L49
        L56:
            WallpaperManagerService.m9526$$Nest$mloadSettingsLocked(this.this$0, wallpaper.userId, true, 3);     // Catch: Throwable -> L49
        L58:
            if (WallpaperManagerService.DEBUG == false) goto L60;
            Slog.v(WallpaperManagerService.TAG, "Wallpaper written; generating crop");     // Catch: Throwable -> L49
        L60:
            this.this$0.mWallpaperCropper.generateCrop(wallpaper);     // Catch: Throwable -> L49
            if (WallpaperManagerService.DEBUG == false) goto L63;
            Slog.v(WallpaperManagerService.TAG, "Crop done; invoking completion callback");     // Catch: Throwable -> L49
        L63:
            wallpaper.imageWallpaperPending = false;     // Catch: Throwable -> L49
            if (sysWallpaperChanged == true) goto L66;
        L74:
            if (lockWallpaperChanged == true) goto L76;
            if (isAppliedToLock2 == true) goto L84;
        L87:
            this.this$0.saveSettingsLocked(wallpaper.userId);     // Catch: Throwable -> L49
            if (localSync == null) goto L90;
            localSync.complete();     // Catch: Throwable -> L49
        L90:
            monitor-exit(r2);     // Catch: Throwable -> L49
            this.this$0.notifyWallpaperColorsChanged(wallpaper);
            return;
        L84:
            if (WallpaperManagerService.DEBUG == false) goto L86;
            Slog.v(WallpaperManagerService.TAG, "Lock screen wallpaper changed to same as home");     // Catch: Throwable -> L49
        L86:
            WallpaperManagerService.m9523$$Nest$mdetachWallpaperLocked(this.this$0, (WallpaperData) WallpaperManagerService.m9515$$Nest$fgetmLockWallpaperMap(this.this$0).get(this.mWallpaper.userId));     // Catch: Throwable -> L49
            WallpaperManagerService.m9521$$Nest$mclearWallpaperBitmaps(this.this$0, this.mWallpaper.userId, 2);     // Catch: Throwable -> L49
            WallpaperManagerService.m9515$$Nest$fgetmLockWallpaperMap(this.this$0).remove(wallpaper.userId);     // Catch: Throwable -> L49
            goto L87
        L76:
            if (WallpaperManagerService.DEBUG == false) goto L78;
            Slog.v(WallpaperManagerService.TAG, "Lock screen wallpaper changed");     // Catch: Throwable -> L49
        L78:
            IRemoteCallback r1 = new AnonymousClass2(this, wallpaper);     // Catch: Throwable -> L49
            wallpaper.mBindSource = WallpaperData.BindSource.SET_STATIC;     // Catch: Throwable -> L49
            WallpaperData wallpaper2 = wallpaper;
            this.this$0.bindWallpaperComponentLocked(WallpaperManagerService.m9512$$Nest$fgetmImageWallpaper(this.this$0), true, false, wallpaper2, r1);     // Catch: Throwable -> L72
        L72:
            th = th;
        L95:
            monitor-exit(r2);     // Catch: Throwable -> L49
            throw th;
        L66:
            if (WallpaperManagerService.DEBUG == false) goto L68;
            Slog.v(WallpaperManagerService.TAG, "Home screen wallpaper changed");     // Catch: Throwable -> L49
        L68:
            IRemoteCallback r3 = new AnonymousClass1(this, wallpaper);     // Catch: Throwable -> L49
            wallpaper.mBindSource = WallpaperData.BindSource.SET_STATIC;     // Catch: Throwable -> L49
            wallpaper2 = wallpaper;
            this.this$0.bindWallpaperComponentLocked(WallpaperManagerService.m9512$$Nest$fgetmImageWallpaper(this.this$0), true, false, wallpaper2, r3);     // Catch: Throwable -> L72
        L93:
            monitor-exit(r2);     // Catch: Throwable -> L49
            return;
        L49:
            th = th;
        L31:
            needsUpdate = true;
            goto L32
        L23:
            isAppliedToLock = false;
        L19:
            isRestore = false;
        L15:
            isMigration = false;
        L11:
            written = true;
            goto L12
        L5:
            r0 = false;
            goto L6
        }

        @Override // android.os.FileObserver
        public void onEvent(int event, String path) {
            if (path == null) goto L5;
            updateWallpapers(event, path);
            return;
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$336rVHiEXaawkKb_lZRyLU6Qq-k, reason: not valid java name */
    public static /* synthetic */ void m9499$r8$lambda$336rVHiEXaawkKb_lZRyLU6Qqk(WallpaperData r0, DisplayConnector r1) {
        lambda$detachWallpaperLocked$15(r0, r1);
    }

    public static /* synthetic */ boolean $r8$lambda$5ErvDQXwaddOkf73QSp6u6kkQ9Y(WallpaperManagerService r0, WallpaperConnection r1, Display r2) {
        return r0.lambda$updateFallbackConnection$2(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$65MLafwxSApsfySKQeGrpCaEeRY(PrintWriter r0, WallpaperDisplayHelper.DisplayData r1) {
        lambda$dumpWallpaper$19(r0, r1);
    }

    public static /* synthetic */ Boolean $r8$lambda$6W4luAcYHTz2GhajJLIQhbrFu_I(WallpaperManagerService r0, WallpaperDescription r1, int r2, int r3, boolean r4, boolean r5, IRemoteCallback r6) {
        return r0.lambda$clearWallpaperLocked$7(r1, r2, r3, r4, r5, r6);
    }

    public static /* synthetic */ void $r8$lambda$70f6O3WniAL1EPYwIwKjPj9UKTo(int r0, int r1, Bundle r2, DisplayConnector r3) {
        lambda$notifyWakingUp$10(r0, r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$7sD2ovY5Ddyfycrp4owOoSrKC1U(WallpaperManagerService r0, WallpaperData r1, IRemoteCallback r2) {
        r0.lambda$clearWallpaperLocked$8(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$HPV0skZunkb71zseMl_vk0jUzZ8(int r0) {
        lambda$onUnlockUser$5(r0);
    }

    public static /* synthetic */ void $r8$lambda$Klm5b07ADsYSKveShfQLaSU4BJU(WallpaperManagerService r0, int r1, Integer r2, String r3) {
        r0.lambda$errorCheck$4(r1, r2, r3);
    }

    public static /* synthetic */ Boolean $r8$lambda$MtJzR9Tfzpn1ib32AAJG680ugdY(WallpaperManagerService r0, String r1) {
        return r0.lambda$isFromForegroundApp$18(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$NZufi7t-APbcRooDKxjzjfXjTj8, reason: not valid java name */
    public static /* synthetic */ void m9500$r8$lambda$NZufi7tAPbcRooDKxjzjfXjTj8(WallpaperConnection r0, WallpaperData r1, DisplayConnector r2) {
        lambda$attachServiceLocked$17(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$S4jgCqwuOI416eRiQyNOsDygOVs(WallpaperManagerService r0, WallpaperData r1, WallpaperData r2) {
        r0.lambda$switchUser$6(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$TH6A5xD571b5BzgW-pWMrxaktvI, reason: not valid java name */
    public static /* synthetic */ void m9501$r8$lambda$TH6A5xD571b5BzgWpWMrxaktvI(WallpaperManagerService r0, WallpaperConnection r1, DisplayConnector r2) {
        r0.lambda$updateFallbackConnection$3(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$VY-kaAbN0EqWFxQ-RVS4I_G019Q, reason: not valid java name */
    public static /* synthetic */ void m9502$r8$lambda$VYkaAbN0EqWFxQRVS4I_G019Q(DisplayConnector r0) {
        lambda$setWallpaperDescriptionInternal$14(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$e-QEqN2mGcHn2wPucQ7FQ-RPqHU, reason: not valid java name */
    public static /* synthetic */ void m9503$r8$lambda$eQEqN2mGcHn2wPucQ7FQRPqHU(WallpaperManagerService r0, WallpaperData r1, int r2, DisplayConnector r3) {
        r0.lambda$notifyWallpaperColorsChanged$0(r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$ij-5NlUtl8WbpKydSrx6s7wM7hQ, reason: not valid java name */
    public static /* synthetic */ void m9504$r8$lambda$ij5NlUtl8WbpKydSrx6s7wM7hQ(PrintWriter r0, DisplayConnector r1) {
        lambda$dumpWallpaper$20(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$mlB_rjGLntQj9CTMGh4p_aeRbPU(boolean r0, DisplayConnector r1) {
        lambda$pauseOrResumeRenderingImmediately$9(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$mllyXVkEgi1qJFVoumq_VprzxNo(WallpaperManagerService r0, WallpaperData r1, DisplayConnector r2) {
        r0.lambda$updateEngineFlags$16(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$nBh497WgBpwBnjQyPTkhPEDewuQ(WallpaperConnection r0, DisplayConnector r1) {
        lambda$updateFallbackConnection$1(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$pWG7H1EJrHbAzhvi75CYGrilcZc(String r0, DisplayConnector r1) {
        lambda$dispatchKeyguardCommand$12(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$sq-y2vvpAakl2kBJQy-aJcXKjz0, reason: not valid java name */
    public static /* synthetic */ void m9505$r8$lambda$sqy2vvpAakl2kBJQyaJcXKjz0(float r0, DisplayConnector r1) {
        lambda$setWallpaperDimAmountForUid$13(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$zo19b0HUnMBMXSHcuskY3kXUa1M(int r0, int r1, Bundle r2, DisplayConnector r3) {
        lambda$notifyGoingToSleep$11(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmActivityManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ ActivityManager m9506$$Nest$fgetmActivityManager(WallpaperManagerService r0) {
        return r0.mActivityManager;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m9507$$Nest$fgetmContext(WallpaperManagerService r0) {
        return r0.mContext;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCurrentUserId, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m9508$$Nest$fgetmCurrentUserId(WallpaperManagerService r0) {
        return r0.mCurrentUserId;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDefaultWallpaperComponent, reason: not valid java name */
    static /* bridge */ /* synthetic */ ComponentName m9509$$Nest$fgetmDefaultWallpaperComponent(WallpaperManagerService r0) {
        return r0.mDefaultWallpaperComponent;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmIExt, reason: not valid java name */
    static /* bridge */ /* synthetic */ IExtWallpaperManagerService m9510$$Nest$fgetmIExt(WallpaperManagerService r0) {
        return r0.mIExt;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmIPackageManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ IPackageManager m9511$$Nest$fgetmIPackageManager(WallpaperManagerService r0) {
        return r0.mIPackageManager;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmImageWallpaper, reason: not valid java name */
    static /* bridge */ /* synthetic */ ComponentName m9512$$Nest$fgetmImageWallpaper(WallpaperManagerService r0) {
        return r0.mImageWallpaper;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmInAmbientMode, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m9513$$Nest$fgetmInAmbientMode(WallpaperManagerService r0) {
        return r0.mInAmbientMode;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLocalColorRepo, reason: not valid java name */
    static /* bridge */ /* synthetic */ LocalColorRepository m9514$$Nest$fgetmLocalColorRepo(WallpaperManagerService r0) {
        return r0.mLocalColorRepo;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLockWallpaperMap, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseArray m9515$$Nest$fgetmLockWallpaperMap(WallpaperManagerService r0) {
        return r0.mLockWallpaperMap;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmShuttingDown, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m9516$$Nest$fgetmShuttingDown(WallpaperManagerService r0) {
        return r0.mShuttingDown;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmWallpaperMap, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseArray m9517$$Nest$fgetmWallpaperMap(WallpaperManagerService r0) {
        return r0.mWallpaperMap;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmWindowManagerInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ WindowManagerInternal m9518$$Nest$fgetmWindowManagerInternal(WallpaperManagerService r0) {
        return r0.mWindowManagerInternal;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmShuttingDown, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9519$$Nest$fputmShuttingDown(WallpaperManagerService r0, boolean r1) {
        r0.mShuttingDown = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mattachServiceLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9520$$Nest$mattachServiceLocked(WallpaperManagerService r0, WallpaperConnection r1, WallpaperData r2) {
        r0.attachServiceLocked(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mclearWallpaperBitmaps, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9521$$Nest$mclearWallpaperBitmaps(WallpaperManagerService r0, int r1, int r2) {
        r0.clearWallpaperBitmaps(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mclearWallpaperLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9522$$Nest$mclearWallpaperLocked(WallpaperManagerService r0, int r1, int r2, boolean r3, IRemoteCallback r4) {
        r0.clearWallpaperLocked(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$mdetachWallpaperLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9523$$Nest$mdetachWallpaperLocked(WallpaperManagerService r0, WallpaperData r1) {
        r0.detachWallpaperLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$merrorCheck, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9524$$Nest$merrorCheck(WallpaperManagerService r0, int r1) {
        r0.errorCheck(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetWallpapers, reason: not valid java name */
    static /* bridge */ /* synthetic */ WallpaperData[] m9525$$Nest$mgetWallpapers(WallpaperManagerService r0) {
        return r0.getWallpapers();
    }

    /* JADX INFO: renamed from: -$$Nest$mloadSettingsLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9526$$Nest$mloadSettingsLocked(WallpaperManagerService r0, int r1, boolean r2, int r3) {
        r0.loadSettingsLocked(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mnotifyCallbacksLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9527$$Nest$mnotifyCallbacksLocked(WallpaperManagerService r0, WallpaperData r1) {
        r0.notifyCallbacksLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mnotifyKeyguardGoingAway, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9528$$Nest$mnotifyKeyguardGoingAway(WallpaperManagerService r0) {
        r0.notifyKeyguardGoingAway();
    }

    /* JADX INFO: renamed from: -$$Nest$mnotifyScreenTurnedOn, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9529$$Nest$mnotifyScreenTurnedOn(WallpaperManagerService r0, int r1) {
        r0.notifyScreenTurnedOn(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mnotifyScreenTurningOn, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9530$$Nest$mnotifyScreenTurningOn(WallpaperManagerService r0, int r1) {
        r0.notifyScreenTurningOn(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mnotifyWallpaperChanged, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9531$$Nest$mnotifyWallpaperChanged(WallpaperManagerService r0, WallpaperData r1) {
        r0.notifyWallpaperChanged(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mnotifyWallpaperColorsChangedOnDisplay, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9532$$Nest$mnotifyWallpaperColorsChangedOnDisplay(WallpaperManagerService r0, WallpaperData r1, int r2) {
        r0.notifyWallpaperColorsChangedOnDisplay(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mnotifyWallpaperComplete, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9533$$Nest$mnotifyWallpaperComplete(WallpaperManagerService r0, WallpaperData r1) {
        r0.notifyWallpaperComplete(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$monDisplayAddSystemDecorationsInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9534$$Nest$monDisplayAddSystemDecorationsInternal(WallpaperManagerService r0, int r1) {
        r0.onDisplayAddSystemDecorationsInternal(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$monDisplayRemovedInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9535$$Nest$monDisplayRemovedInternal(WallpaperManagerService r0, int r1) {
        r0.onDisplayRemovedInternal(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mpauseOrResumeRenderingImmediately, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9536$$Nest$mpauseOrResumeRenderingImmediately(WallpaperManagerService r0, boolean r1) {
        r0.pauseOrResumeRenderingImmediately(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateEngineFlags, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9537$$Nest$mupdateEngineFlags(WallpaperManagerService r0, WallpaperData r1) {
        r0.updateEngineFlags(r1);
    }

    static {
        DEBUG = false;
        LOCAL_COLOR_BOUNDS = new RectF(0.0f, 0.0f, 1.0f, 1.0f);
        sWallpaperType = Map.of(1, "decode_record", 2, "decode_lock_record");
    }

    private void notifyWallpaperComplete(WallpaperData wallpaper) {
        if (wallpaper.setComplete == null) goto L11;
        wallpaper.setComplete.onWallpaperChanged();     // Catch: RemoteException -> L6
        return;
    L6:
        e = move-exception;
        Slog.w(TAG, "onWallpaperChanged threw an exception", e);
        return;
    }

    void notifyWallpaperColorsChanged(WallpaperData wallpaper) {
        notifyWallpaperColorsChanged(wallpaper, wallpaper.mWhich);
    }

    private void notifyWallpaperColorsChanged(final WallpaperData wallpaper, final int which) {
        if (DEBUG == false) goto L6;
        Slog.i(TAG, "Notifying wallpaper colors changed");
    L6:
        if (wallpaper.connection == null) goto L9;
        wallpaper.connection.forEachDisplayConnector(new WallpaperManagerService$$ExternalSyntheticLambda13(this, wallpaper, which));
        return;
    }

    private /* synthetic */ void lambda$notifyWallpaperColorsChanged$0(WallpaperData wallpaper, int which, DisplayConnector connector) {
        notifyWallpaperColorsChangedOnDisplay(wallpaper, connector.mDisplayId, which);
    }

    private RemoteCallbackList<IWallpaperManagerCallback> getWallpaperCallbacks(int userId, int displayId) {
        SparseArray<RemoteCallbackList<IWallpaperManagerCallback>> displayListeners = this.mColorsChangedListeners.get(userId);
        if (displayListeners == null) goto L6;
        RemoteCallbackList<IWallpaperManagerCallback> listeners = displayListeners.get(displayId);
        return listeners;
    L6:
        return null;
    }

    private void notifyWallpaperColorsChangedOnDisplay(WallpaperData wallpaper, int displayId) {
        notifyWallpaperColorsChangedOnDisplay(wallpaper, displayId, wallpaper.mWhich);
    }

    private void notifyWallpaperColorsChangedOnDisplay(WallpaperData wallpaper, int displayId, int which) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        RemoteCallbackList<IWallpaperManagerCallback> currentUserColorListeners = getWallpaperCallbacks(wallpaper.userId, displayId);     // Catch: Throwable -> L10
        RemoteCallbackList<IWallpaperManagerCallback> userAllColorListeners = getWallpaperCallbacks(-1, displayId);     // Catch: Throwable -> L10
        if (emptyCallbackList(currentUserColorListeners) == false) goto L13;
        if (emptyCallbackList(userAllColorListeners) == false) goto L13;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L13:
        if (DEBUG == false) goto L16;
        Slog.v(TAG, "notifyWallpaperColorsChangedOnDisplay " + wallpaper.mWhich);     // Catch: Throwable -> L10
    L16:
        if (wallpaper.primaryColors == null) goto L21;
        if (wallpaper.mIsColorExtractedFromDim == true) goto L21;
        boolean needsExtraction = false;
    L23:
        monitor-exit(r0);     // Catch: Throwable -> L10
        boolean notify = true;
        if (needsExtraction == false) goto L27;
        notify = extractColors(wallpaper);
    L27:
        if (notify == false) goto L33;
        notifyColorListeners(getAdjustedWallpaperColorsOnDimming(wallpaper), which, wallpaper.userId, displayId);
        return;
    L33:
        return;
    L21:
        needsExtraction = true;
    L10:
        th = move-exception;
        throw th;
    }

    private static <T extends IInterface> boolean emptyCallbackList(RemoteCallbackList<T> list) {
        if (list != null) goto L4;
    L7:
        return true;
    L4:
        if (list.getRegisteredCallbackCount() == 0) goto L7;
        return false;
    }

    private void notifyColorListeners(WallpaperColors wallpaperColors, int which, int userId, int displayId) {
        ArrayList<IWallpaperManagerCallback> colorListeners = new ArrayList();
        Object r1 = this.mLock;
        monitor-enter(r1);
        RemoteCallbackList<IWallpaperManagerCallback> currentUserColorListeners = getWallpaperCallbacks(userId, displayId);     // Catch: Throwable -> L9
        RemoteCallbackList<IWallpaperManagerCallback> userAllColorListeners = getWallpaperCallbacks(-1, displayId);     // Catch: Throwable -> L9
        if (currentUserColorListeners == null) goto L12;
        int count = currentUserColorListeners.beginBroadcast();     // Catch: Throwable -> L9
        int i = 0;
    L7:
        if (i >= count) goto L11;
        colorListeners.add(currentUserColorListeners.getBroadcastItem(i));     // Catch: Throwable -> L9
        i = i + 1;     // Catch: Throwable -> L9
        goto L7
    L11:
        currentUserColorListeners.finishBroadcast();     // Catch: Throwable -> L9
    L12:
        if (userAllColorListeners == null) goto L17;
        int count2 = userAllColorListeners.beginBroadcast();     // Catch: Throwable -> L9
        int i2 = 0;
    L14:
        if (i2 >= count2) goto L16;
        colorListeners.add(userAllColorListeners.getBroadcastItem(i2));     // Catch: Throwable -> L9
        i2 = i2 + 1;     // Catch: Throwable -> L9
        goto L14
    L16:
        userAllColorListeners.finishBroadcast();     // Catch: Throwable -> L9
    L17:
        monitor-exit(r1);     // Catch: Throwable -> L9
        int count3 = colorListeners.size();
        int i3 = 0;
    L19:
        if (i3 >= count3) goto L26;
        colorListeners.get(i3).onWallpaperColorsChanged(wallpaperColors, which, userId);     // Catch: RemoteException -> L22
    L24:
        i3 = i3 + 1;
    L22:
        e = move-exception;
        Slog.w(TAG, "onWallpaperColorsChanged() threw an exception", e);
        goto L24
    L26:
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private boolean extractColors(WallpaperData wallpaper) {
        String cropFile = null;
        boolean defaultImageWallpaper = false;
        Object r2 = this.mLock;
        monitor-enter(r2);
        wallpaper.mIsColorExtractedFromDim = false;     // Catch: Throwable -> L79
        monitor-exit(r2);     // Catch: Throwable -> L79
        if (wallpaper.equals(this.mFallbackWallpaper) == false) goto L28;
        Object r3 = this.mLock;
        monitor-enter(r3);
    L15:
        th = move-exception;
        throw th;
    L12:
        if (this.mFallbackWallpaper.primaryColors == null) goto L17;
        monitor-exit(r3);     // Catch: Throwable -> L15
        return true;
    L17:
        monitor-exit(r3);     // Catch: Throwable -> L15
        WallpaperColors colors = extractDefaultImageWallpaperColors(wallpaper);
        Object r5 = this.mLock;
        monitor-enter(r5);
        this.mFallbackWallpaper.primaryColors = colors;     // Catch: Throwable -> L23
        monitor-exit(r5);     // Catch: Throwable -> L23
        return true;
    L23:
        th = move-exception;
        throw th;
    L28:
        Object r6 = this.mLock;
        monitor-enter(r6);
    L36:
        th = move-exception;
        throw th;
    L31:
        if (this.mImageWallpaper.equals(wallpaper.getComponent()) == false) goto L33;
    L38:
        boolean imageWallpaper = true;
    L40:
        if (imageWallpaper == true) goto L42;
    L44:
        if (imageWallpaper == true) goto L46;
    L50:
        int wallpaperId = wallpaper.wallpaperId;     // Catch: Throwable -> L36
        float dimAmount = wallpaper.mWallpaperDimAmount;     // Catch: Throwable -> L36
        monitor-exit(r6);     // Catch: Throwable -> L36
        WallpaperColors colors2 = null;
        if (cropFile == null) goto L58;
        Bitmap bitmap = BitmapFactory.decodeFile(cropFile);
        if (bitmap == null) goto L60;
        colors2 = WallpaperColors.fromBitmap(bitmap, dimAmount);
        bitmap.recycle();
    L60:
        if (colors2 != null) goto L63;
        Slog.w(TAG, "Cannot extract colors because wallpaper could not be read.");
        return true;
    L63:
        Object r8 = this.mLock;
        monitor-enter(r8);
    L70:
        th = move-exception;
        throw th;
    L66:
        if (wallpaper.wallpaperId != wallpaperId) goto L72;
        wallpaper.primaryColors = colors2;     // Catch: Throwable -> L70
        saveSettingsLocked(wallpaper.userId);     // Catch: Throwable -> L70
        monitor-exit(r8);     // Catch: Throwable -> L70
        return true;
    L72:
        Slog.w(TAG, "Not setting primary colors since wallpaper changed");     // Catch: Throwable -> L70
        monitor-exit(r8);     // Catch: Throwable -> L70
        return false;
    L58:
        if (defaultImageWallpaper == false) goto L60;
        colors2 = extractDefaultImageWallpaperColors(wallpaper);
        goto L60
    L46:
        if (wallpaper.cropExists() == true) goto L50;
        if (wallpaper.sourceExists() == true) goto L50;
        defaultImageWallpaper = true;
        goto L50
    L42:
        if (wallpaper.getCropFile().exists() == false) goto L44;
        cropFile = wallpaper.getCropFile().getAbsolutePath();     // Catch: Throwable -> L36
        goto L50
    L33:
        if (wallpaper.getComponent() == null) goto L38;
        imageWallpaper = false;
    L79:
        th = move-exception;
        throw th;
    }

    private WallpaperColors extractDefaultImageWallpaperColors(WallpaperData wallpaper) {
        if (DEBUG == false) goto L5;
        Slog.d(TAG, "Extract default image wallpaper colors");
    L5:
        Object r0 = this.mLock;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L8:
        if (this.mCacheDefaultImageWallpaperColors == null) goto L14;
        WallpaperColors r1 = this.mCacheDefaultImageWallpaperColors;     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r1;
    L14:
        float dimAmount = wallpaper.mWallpaperDimAmount;     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        WallpaperColors colors = null;
        InputStream is = WallpaperManager.openDefaultWallpaper(this.mContext, 1);     // Catch: IOException -> L24 OutOfMemoryError -> L26
        if (is != null) goto L31;
        Slog.w(TAG, "Can't open default wallpaper stream");     // Catch: Throwable -> L29
        if (is == null) goto L28;
        is.close();     // Catch: IOException -> L24 OutOfMemoryError -> L26
    L28:
        return null;
    L31:
        BitmapFactory.Options options = new BitmapFactory.Options();     // Catch: Throwable -> L29
        Bitmap bitmap = BitmapFactory.decodeStream(is, null, options);     // Catch: Throwable -> L29
        if (bitmap == null) goto L34;
        colors = WallpaperColors.fromBitmap(bitmap, dimAmount);     // Catch: Throwable -> L29
        bitmap.recycle();     // Catch: Throwable -> L29
    L34:
        is.close();     // Catch: IOException -> L24 OutOfMemoryError -> L26
    L35:
        WallpaperColors colors2 = colors;
    L45:
        if (colors2 != null) goto L47;
        Slog.e(TAG, "Extract default image wallpaper colors failed");
    L51:
        return colors2;
    L47:
        Object r3 = this.mLock;
        monitor-enter(r3);
        this.mCacheDefaultImageWallpaperColors = colors2;     // Catch: Throwable -> L52
        monitor-exit(r3);     // Catch: Throwable -> L52
    L52:
        th = move-exception;
        throw th;
    L29:
        th = move-exception;
        if (is != null) goto L60;
    L42:
        throw th;     // Catch: IOException -> L24 OutOfMemoryError -> L26
    L60:
        is.close();     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L24 OutOfMemoryError -> L26
    L24:
        e = move-exception;
        Slog.w(TAG, "Can't close default wallpaper stream", e);
        colors2 = null;
    L26:
        e = move-exception;
        Slog.w(TAG, "Can't decode default wallpaper stream", e);
        goto L35
    }

    boolean isWallpaperCompatibleForDisplay(int displayId, WallpaperConnection connection) {
        if (connection != null) goto L6;
        return false;
    L6:
        if (connection.mInfo == null) goto L10;
        return connection.mInfo.supportsMultipleDisplays();
    L10:
        if (DesktopModeHelper.isDeviceEligibleForDesktopExperienceWallpaper(this.mContext) == true) goto L12;
        return true;
    L12:
        return this.mWallpaperCropper.isWallpaperCompatibleForDisplay(displayId, connection.mWallpaper);
    }

    private void updateFallbackConnection(int clientUid) {
        if (this.mLastWallpaper != null) goto L5;
        return;
    L5:
        if (this.mFallbackWallpaper == null) goto L87;
        WallpaperConnection systemConnection = this.mLastWallpaper.connection;
        final WallpaperConnection fallbackConnection = this.mFallbackWallpaper.connection;
        if (this.mLastLockWallpaper == null) goto L10;
        WallpaperConnection lockConnection = this.mLastLockWallpaper.connection;
    L12:
        if (fallbackConnection != null) goto L16;
        Slog.w(TAG, "Fallback wallpaper connection has not been created yet!!");
        return;
    L16:
        if (DesktopModeHelper.isDeviceEligibleForDesktopExperienceWallpaper(this.mContext) == false) goto L64;
        Display[] displays = this.mWallpaperDisplayHelper.getDisplays();
        int i = displays.length - 1;
    L18:
        if (i < 0) goto L86;
        int displayId = displays[i].getDisplayId();
        if (this.mWallpaperDisplayHelper.isUsableDisplay(displayId, clientUid) == false) goto L61;
        if (systemConnection.containsDisplay(displayId) == false) goto L33;
        if (lockConnection != null) goto L26;
    L27:
        DisplayConnector fallbackConnector = (DisplayConnector) WallpaperConnection.m9542$$Nest$fgetmDisplayConnector(this.mFallbackWallpaper.connection).get(displayId);
        if (fallbackConnector == null) goto L61;
        if (fallbackConnector.mEngine == null) goto L32;
        fallbackConnector.disconnectLocked(this.mFallbackWallpaper.connection);
    L32:
        WallpaperConnection.m9542$$Nest$fgetmDisplayConnector(this.mFallbackWallpaper.connection).remove(displayId);
        goto L61
    L26:
        if (lockConnection.containsDisplay(displayId) == true) goto L27;
    L33:
        int which = 0;
        if (systemConnection.containsDisplay(displayId) == true) goto L36;
        which = 0 | 1;
    L36:
        if (lockConnection != null) goto L38;
    L39:
        which = which | 2;
    L41:
        if (this.mFallbackWallpaper.connection.containsDisplay(displayId) == false) goto L58;
        DisplayConnector fallbackConnector2 = (DisplayConnector) WallpaperConnection.m9542$$Nest$fgetmDisplayConnector(this.mFallbackWallpaper.connection).get(displayId);
        if (fallbackConnector2 == null) goto L61;
    L54:
        e = move-exception;
        Slog.e(TAG, "Failed to update fallback wallpaper engine flags", e);
        goto L61
    L45:
        if (fallbackConnector2.mEngine == null) goto L61;
        if (fallbackConnector2.mWhich == which) goto L61;
        fallbackConnector2.mEngine.setWallpaperFlags(which);     // Catch: RemoteException -> L54
        WindowManagerInternal r11 = this.mWindowManagerInternal;     // Catch: RemoteException -> L54
        Binder r12 = fallbackConnector2.mToken;     // Catch: RemoteException -> L54
        if ((which & 2) == 0) goto L51;
        boolean r13 = true;
    L52:
        r11.setWallpaperShowWhenLocked(r12, r13);     // Catch: RemoteException -> L54
        fallbackConnector2.mWhich = which;     // Catch: RemoteException -> L54
        goto L61
    L51:
        r13 = false;
        goto L52
    L58:
        DisplayConnector fallbackConnector3 = this.mFallbackWallpaper.connection.getDisplayConnectorOrCreate(displayId);
        if (fallbackConnector3 == null) goto L61;
        fallbackConnector3.mWhich = which;
        fallbackConnector3.connectLocked(this.mFallbackWallpaper.connection, this.mFallbackWallpaper);
        goto L61
    L38:
        if (lockConnection.containsDisplay(displayId) == true) goto L41;
    L61:
        i = i - 1;
        goto L18
    L86:
        return;
    L64:
        if (isWallpaperCompatibleForDisplay(0, systemConnection) == true) goto L66;
        WallpaperConnection.m9545$$Nest$mappendConnectorWithCondition(fallbackConnection, new WallpaperManagerService$$ExternalSyntheticLambda15(this, fallbackConnection));
        fallbackConnection.forEachDisplayConnector(new WallpaperManagerService$$ExternalSyntheticLambda16(this, fallbackConnection));
        return;
    L66:
        if (WallpaperConnection.m9542$$Nest$fgetmDisplayConnector(fallbackConnection).size() == 0) goto L84;
        fallbackConnection.forEachDisplayConnector(new WallpaperManagerService$$ExternalSyntheticLambda14(fallbackConnection));
        WallpaperConnection.m9542$$Nest$fgetmDisplayConnector(fallbackConnection).clear();
        return;
    L84:
        return;
    L10:
        lockConnection = null;
        goto L12
    }

    private static /* synthetic */ void lambda$updateFallbackConnection$1(WallpaperConnection fallbackConnection, DisplayConnector connector) {
        if (connector.mEngine == null) goto L6;
        connector.disconnectLocked(fallbackConnection);
        return;
    }

    private /* synthetic */ boolean lambda$updateFallbackConnection$2(WallpaperConnection fallbackConnection, Display display) {
        if (this.mWallpaperDisplayHelper.isUsableDisplay(display, fallbackConnection.mClientUid) == true) goto L5;
    L9:
        return false;
    L5:
        if (display.getDisplayId() == 0) goto L9;
        if (fallbackConnection.containsDisplay(display.getDisplayId()) == true) goto L9;
        return true;
    }

    private /* synthetic */ void lambda$updateFallbackConnection$3(WallpaperConnection fallbackConnection, DisplayConnector connector) {
        if (connector.mEngine != null) goto L6;
        connector.connectLocked(fallbackConnection, this.mFallbackWallpaper);
        return;
    }

    WallpaperData getCurrentWallpaperData(int which, int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        if (which != 1) goto L9;
        SparseArray<WallpaperData> wallpaperDataMap = this.mWallpaperMap;     // Catch: Throwable -> L7
    L10:
        WallpaperData r2 = wallpaperDataMap.get(userId);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r2;
    L9:
        wallpaperDataMap = this.mLockWallpaperMap;     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }

    public WallpaperManagerService(Context context) {
        this.mLock = new Object();
        this.mInitialUserSwitch = true;
        this.mDisplayListener = new AnonymousClass1(this);
        this.mWallpaperMap = new SparseArray();
        this.mLockWallpaperMap = new SparseArray();
        this.mUserRestorecon = new SparseBooleanArray();
        this.mCurrentUserId = ProcessList.INVALID_ADJ;
        this.mLocalColorRepo = new LocalColorRepository();
        this.mKeyguardObserver = new AnonymousClass3(this);
        this.mIExt = (IExtWallpaperManagerService) ExtImplFactory.getImpl(IExtWallpaperManagerService.class, new Object[]{this});
        if (DEBUG == false) goto L5;
        Slog.v(TAG, "WallpaperService startup");
    L5:
        this.mContext = context;
        this.mShuttingDown = false;
        this.mImageWallpaper = ComponentName.unflattenFromString(context.getResources().getString(R.string.keyguard_accessibility_pattern_area));
        WallpaperManagerServiceIA r5 = null;
        if (DesktopModeHelper.isDeviceEligibleForDesktopExperienceWallpaper(this.mContext) == false) goto L8;
        this.mFallbackWallpaperComponent = ComponentName.unflattenFromString(context.getResources().getString(R.string.global_action_power_options));
    L9:
        ComponentName defaultComponent = WallpaperManager.getCmfDefaultWallpaperComponent(context);
        if (defaultComponent != null) goto L12;
        ComponentName r0 = this.mImageWallpaper;
    L13:
        this.mDefaultWallpaperComponent = r0;
        this.mWindowManagerInternal = (WindowManagerInternal) LocalServices.getService(WindowManagerInternal.class);
        this.mPackageManagerInternal = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);
        this.mIPackageManager = AppGlobals.getPackageManager();
        this.mAppOpsManager = (AppOpsManager) this.mContext.getSystemService("appops");
        DisplayManager displayManager = (DisplayManager) this.mContext.getSystemService(DisplayManager.class);
        displayManager.registerDisplayListener(this.mDisplayListener, null);
        WindowManager windowManager = (WindowManager) this.mContext.getSystemService(WindowManager.class);
        this.mWallpaperDisplayHelper = new WallpaperDisplayHelper(displayManager, windowManager, this.mWindowManagerInternal, this.mContext.getResources());
        this.mWallpaperCropper = new WallpaperCropper(this.mWallpaperDisplayHelper);
        this.mActivityManager = (ActivityManager) this.mContext.getSystemService(ActivityManager.class);
        if (this.mContext.getResources().getBoolean(R.bool.config_predictShowStartingSurface) == false) goto L29;
        String[] pauseRenderList = this.mContext.getResources().getStringArray(17236272);
        IntArray pauseRenderUids = new IntArray();
        int r11 = pauseRenderList.length;
        int r12 = 0;
    L16:
        if (r12 >= r11) goto L24;
        String pauseRenderApp = pauseRenderList[r12];
        int uid = this.mContext.getPackageManager().getApplicationInfo(pauseRenderApp, 0).uid;     // Catch: Exception -> L20
        pauseRenderUids.add(uid);     // Catch: Exception -> L20
    L22:
        r12 = r12 + 1;
    L20:
        e = move-exception;
        Slog.e(TAG, e.toString());
        goto L22
    L24:
        if (pauseRenderUids.size() <= 0) goto L29;
        ActivityManager.getService().registerUidObserverForUids(new AnonymousClass2(this), 1, 2, PackageManagerService.PLATFORM_PACKAGE_NAME, pauseRenderUids.toArray());     // Catch: RemoteException -> L27
    L27:
        e = move-exception;
        Slog.e(TAG, e.toString());
    L29:
        this.mMonitor = new MyPackageMonitor(this, r5);
        this.mColorsChangedListeners = new SparseArray();
        this.mWallpaperDataParser = new WallpaperDataParser(this.mContext, this.mWallpaperDisplayHelper, this.mWallpaperCropper);
        LocalServices.addService(WallpaperManagerInternal.class, new LocalService(this, r5));
        ((ActivityTaskManagerInternal) LocalServices.getService(ActivityTaskManagerInternal.class)).registerScreenObserver(this.mKeyguardObserver);
        return;
    L12:
        r0 = defaultComponent;
        goto L13
    L8:
        this.mFallbackWallpaperComponent = null;
        goto L9
    }

    void initialize() {
        this.mMonitor.register(this.mContext, null, UserHandle.ALL, true);
        WallpaperUtils.getWallpaperDir(0).mkdirs();
        loadSettingsLocked(0, false, 3);
        getWallpaperSafeLocked(0, 1);
    }

    protected void finalize() throws Throwable {
        super.finalize();
        int i = 0;
    L4:
        if (i >= this.mWallpaperMap.size()) goto L7;
        WallpaperData wallpaper = this.mWallpaperMap.valueAt(i);
        wallpaper.wallpaperObserver.stopWatching();
        i = i + 1;
        goto L4
    }

    void systemReady() {
        if (DEBUG == false) goto L5;
        Slog.v(TAG, "systemReady");
    L5:
        initialize();
        WallpaperData wallpaper = this.mWallpaperMap.get(0);
        if (wallpaper.getComponent() != null) goto L8;
    L11:
        boolean isImageComponent = true;
    L13:
        if (isImageComponent == false) goto L27;
        if (wallpaper.cropExists() == true) goto L21;
        if (DEBUG == false) goto L19;
        Slog.i(TAG, "No crop; regenerating from source");
    L19:
        this.mWallpaperCropper.generateCrop(wallpaper);
    L21:
        if (wallpaper.cropExists() == false) goto L23;
    L29:
        IntentFilter userFilter = new IntentFilter();
        userFilter.addAction("android.intent.action.USER_REMOVED");
        this.mContext.registerReceiver(new AnonymousClass4(this), userFilter);
        IntentFilter shutdownFilter = new IntentFilter("android.intent.action.ACTION_SHUTDOWN");
        this.mContext.registerReceiver(new AnonymousClass5(this), shutdownFilter);
        ActivityManager.getService().registerUserSwitchObserver(new AnonymousClass6(this), TAG);     // Catch: RemoteException -> L32
        return;
    L32:
        e = move-exception;
        e.rethrowAsRuntimeException();
        return;
    L23:
        if (DEBUG == false) goto L25;
        Slog.i(TAG, "Unable to regenerate crop; resetting");
    L25:
        clearWallpaperLocked(wallpaper.mWhich, 0, false, null);
        goto L29
    L27:
        if (DEBUG == false) goto L29;
        Slog.i(TAG, "Nondefault wallpaper component; gracefully ignoring");
        goto L29
    L8:
        if (this.mImageWallpaper.equals(wallpaper.getComponent()) == true) goto L11;
        isImageComponent = false;
        goto L13
    }

    public String getName() {
        if (Binder.getCallingUid() != 1000) goto L13;
        Object r0 = this.mLock;
        monitor-enter(r0);
        String r1 = this.mWallpaperMap.get(0).name;     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    L9:
        th = move-exception;
        throw th;
    L13:
        throw new RuntimeException("getName() can only be called from the system process");
    }

    void stopObserver(WallpaperData wallpaper) {
        if (wallpaper != null) goto L4;
        return;
    L4:
        if (wallpaper.wallpaperObserver == null) goto L8;
        wallpaper.wallpaperObserver.stopWatching();
        wallpaper.wallpaperObserver = null;
        return;
    }

    void stopObserversLocked(int userId) {
        stopObserver(this.mWallpaperMap.get(userId));
        stopObserver(this.mLockWallpaperMap.get(userId));
        this.mWallpaperMap.remove(userId);
        this.mLockWallpaperMap.remove(userId);
    }

    @Override // com.android.server.wallpaper.IWallpaperManagerService
    public void onBootPhase(int phase) {
        errorCheck(0);
        if (phase != 550) goto L6;
        systemReady();
        return;
    L6:
        if (phase != 600) goto L10;
        switchUser(0, null);
        return;
    }

    private void errorCheck(final int userID) {
        sWallpaperType.forEach(new WallpaperManagerService$$ExternalSyntheticLambda10(this, userID));
    }

    private /* synthetic */ void lambda$errorCheck$4(int userID, Integer type, String filename) {
        File record = new File(WallpaperUtils.getWallpaperDir(userID), filename);
        if (record.exists() == false) goto L6;
        Slog.w(TAG, "User:" + userID + ", wallpaper type = " + type + ", wallpaper fail detect!! reset to default wallpaper");
        clearWallpaperBitmaps(userID, type.intValue());
        record.delete();
        return;
    }

    private void clearWallpaperBitmaps(int userID, int wallpaperType) {
        WallpaperData wallpaper = new WallpaperData(userID, wallpaperType);
        clearWallpaperBitmaps(wallpaper);
    }

    private boolean clearWallpaperBitmaps(WallpaperData wallpaper) {
        boolean sourceExists = wallpaper.sourceExists();
        boolean cropExists = wallpaper.cropExists();
        if (sourceExists == false) goto L5;
        wallpaper.getWallpaperFile().delete();
    L5:
        if (cropExists == false) goto L7;
        wallpaper.getCropFile().delete();
    L7:
        if (sourceExists == true) goto L11;
        if (cropExists == true) goto L11;
        return false;
    L11:
        return true;
    }

    @Override // com.android.server.wallpaper.IWallpaperManagerService
    public void onUnlockUser(final int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mCurrentUserId == userId) goto L7;
    L17:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L7:
        if (this.mHomeWallpaperWaitingForUnlock == false) goto L12;
        WallpaperData systemWallpaper = getWallpaperSafeLocked(userId, 1);     // Catch: Throwable -> L9
        systemWallpaper.mBindSource = WallpaperData.BindSource.SWITCH_WALLPAPER_UNLOCK_USER;     // Catch: Throwable -> L9
        switchWallpaper(systemWallpaper, null);     // Catch: Throwable -> L9
        notifyCallbacksLocked(systemWallpaper);     // Catch: Throwable -> L9
        notifyWallpaperChanged(systemWallpaper);     // Catch: Throwable -> L9
    L12:
        if (this.mLockWallpaperWaitingForUnlock == false) goto L15;
        WallpaperData lockWallpaper = getWallpaperSafeLocked(userId, 2);     // Catch: Throwable -> L9
        lockWallpaper.mBindSource = WallpaperData.BindSource.SWITCH_WALLPAPER_UNLOCK_USER;     // Catch: Throwable -> L9
        switchWallpaper(lockWallpaper, null);     // Catch: Throwable -> L9
        notifyCallbacksLocked(lockWallpaper);     // Catch: Throwable -> L9
        notifyWallpaperChanged(lockWallpaper);     // Catch: Throwable -> L9
    L15:
        if (this.mUserRestorecon.get(userId) == true) goto L17;
        this.mUserRestorecon.put(userId, true);     // Catch: Throwable -> L9
        Runnable relabeler = new WallpaperManagerService$$ExternalSyntheticLambda2(userId);     // Catch: Throwable -> L9
        BackgroundThread.getHandler().post(relabeler);     // Catch: Throwable -> L9
        goto L17
    }

    private static /* synthetic */ void lambda$onUnlockUser$5(int userId) {
        TimingsTraceAndSlog t = new TimingsTraceAndSlog(TAG);
        t.traceBegin("Wallpaper_selinux_restorecon-" + userId);
        Iterator<File> r1 = WallpaperUtils.getWallpaperFiles(userId).iterator();     // Catch: Throwable -> L10
    L5:
        if (r1.hasNext() == false) goto L13;
        File file = r1.next();     // Catch: Throwable -> L10
        if (file.exists() == false) goto L5;
        SELinux.restorecon(file);     // Catch: Throwable -> L10
        goto L5
    L13:
        t.traceEnd();
        return;
    L10:
        th = move-exception;
        t.traceEnd();
        throw th;
    }

    void onRemoveUser(int userId) {
        if (userId >= 1) goto L5;
        return;
    L5:
        Object r0 = this.mLock;
        monitor-enter(r0);
        stopObserversLocked(userId);     // Catch: Throwable -> L10
        WallpaperUtils.getWallpaperFiles(userId).forEach(new WallpaperManagerService$$ExternalSyntheticLambda7());     // Catch: Throwable -> L10
        this.mUserRestorecon.delete(userId);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    void switchUser(int userId, IRemoteCallback reply) {
        TimingsTraceAndSlog t = new TimingsTraceAndSlog(TAG);
        t.traceBegin("Wallpaper_switch-user-" + userId);
        Object r1 = this.mLock;     // Catch: Throwable -> L42
        monitor-enter(r1);     // Catch: Throwable -> L42
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L42
    L6:
        if (this.mCurrentUserId != userId) goto L12;
        monitor-exit(r1);     // Catch: Throwable -> L10
        t.traceEnd();
        return;
    L12:
        this.mCurrentUserId = userId;     // Catch: Throwable -> L10
        boolean isDeviceSecure = true;
        final WallpaperData systemWallpaper = getWallpaperSafeLocked(userId, 1);     // Catch: Throwable -> L10
        if (systemWallpaper.mWhich != 3) goto L15;
        final WallpaperData lockWallpaper = systemWallpaper;
    L17:
        if (systemWallpaper.wallpaperObserver != null) goto L19;
        systemWallpaper.wallpaperObserver = new WallpaperObserver(this, systemWallpaper);     // Catch: Throwable -> L10
        systemWallpaper.wallpaperObserver.startWatching();     // Catch: Throwable -> L10
    L19:
        detachWallpaperLocked(this.mLastLockWallpaper);     // Catch: Throwable -> L10
        detachWallpaperLocked(this.mLastWallpaper);     // Catch: Throwable -> L10
        if (lockWallpaper != systemWallpaper) goto L22;
        switchWallpaper(systemWallpaper, reply);     // Catch: Throwable -> L10
    L37:
        this.mInitialUserSwitch = false;     // Catch: Throwable -> L10
        monitor-exit(r1);     // Catch: Throwable -> L10
        FgThread.getHandler().post(new WallpaperManagerService$$ExternalSyntheticLambda4(this, systemWallpaper, lockWallpaper));     // Catch: Throwable -> L42
        t.traceEnd();
        return;
    L22:
        KeyguardManager km = (KeyguardManager) this.mContext.getSystemService(KeyguardManager.class);     // Catch: Throwable -> L10
        if (km != null) goto L25;
    L27:
        isDeviceSecure = false;
    L29:
        if (isDeviceSecure == false) goto L31;
        WallpaperData r7 = lockWallpaper;
    L32:
        switchWallpaper(r7, reply);     // Catch: Throwable -> L10
        if (isDeviceSecure == false) goto L35;
        WallpaperData r8 = systemWallpaper;
    L36:
        switchWallpaper(r8, null);     // Catch: Throwable -> L10
        goto L37
    L35:
        r8 = lockWallpaper;
        goto L36
    L31:
        r7 = systemWallpaper;
        goto L32
    L25:
        if (km.isDeviceSecure(userId) == false) goto L27;
    L15:
        lockWallpaper = getWallpaperSafeLocked(userId, 2);     // Catch: Throwable -> L10
    L42:
        th = move-exception;
        t.traceEnd();
        throw th;
    }

    private /* synthetic */ void lambda$switchUser$6(WallpaperData systemWallpaper, WallpaperData lockWallpaper) {
        notifyWallpaperColorsChanged(systemWallpaper);
        if (lockWallpaper == systemWallpaper) goto L5;
        notifyWallpaperColorsChanged(lockWallpaper);
    L5:
        notifyWallpaperColorsChanged(this.mFallbackWallpaper);
    }

    void switchWallpaper(WallpaperData wallpaper, IRemoteCallback reply) {
        Object r1 = this.mLock;
        monitor-enter(r1);
    L31:
        th = th;
    L33:
        monitor-exit(r1);     // Catch: Throwable -> L23
        throw th;
    L6:
        if ((wallpaper.mWhich & 1) == 0) goto L13;
        this.mHomeWallpaperWaitingForUnlock = false;     // Catch: Throwable -> L9
    L9:
        th = th;
    L13:
        if ((wallpaper.mWhich & 2) == 0) goto L16;
        this.mLockWallpaperWaitingForUnlock = false;     // Catch: Throwable -> L9
    L16:
        WallpaperDescription description = wallpaper.getDescription();     // Catch: Throwable -> L31
    L23:
        th = th;
        goto L33
    L19:
        if (bindWallpaperDescriptionLocked(description, true, false, wallpaper, reply) == true) goto L29;
        ServiceInfo si = null;
        si = this.mIPackageManager.getServiceInfo(description.getComponent(), 262144, wallpaper.userId);     // Catch: Throwable -> L23 RemoteException -> L25
    L28:
        onSwitchWallpaperFailLocked(wallpaper, reply, si);     // Catch: Throwable -> L23
        goto L29
    L25:
        e = move-exception;
        Slog.w(TAG, "Failure starting previous wallpaper; clearing", e);     // Catch: Throwable -> L23
    L29:
        monitor-exit(r1);     // Catch: Throwable -> L23
    }

    private void onSwitchWallpaperFailLocked(WallpaperData wallpaper, IRemoteCallback reply, ServiceInfo serviceInfo) {
        if (serviceInfo != null) goto L5;
        clearWallpaperLocked(wallpaper.mWhich, wallpaper.userId, false, reply);
        return;
    L5:
        Slog.w(TAG, "Wallpaper isn't direct boot aware; using fallback until unlocked");
        WallpaperData fallback = new WallpaperData(wallpaper.userId, wallpaper.mWhich);
        clearWallpaperBitmaps(wallpaper);
        fallback.mBindSource = WallpaperData.BindSource.SWITCH_WALLPAPER_FAILURE;
        bindWallpaperComponentLocked(this.mImageWallpaper, true, false, fallback, reply);
        if ((wallpaper.mWhich & 1) == 0) goto L9;
        this.mHomeWallpaperWaitingForUnlock = true;
    L9:
        if ((wallpaper.mWhich & 2) == 0) goto L12;
        this.mLockWallpaperWaitingForUnlock = true;
        return;
    }

    public void clearWallpaper(String callingPackage, int which, int userId) {
        if (DEBUG == false) goto L5;
        Slog.v(TAG, "clearWallpaper: " + which);
    L5:
        checkPermission("android.permission.SET_WALLPAPER");
        if (isWallpaperSupported(callingPackage) == false) goto L26;
        if (isSetWallpaperAllowed(callingPackage) == false) goto L29;
        int userId2 = ActivityManager.handleIncomingUser(Binder.getCallingPid(), Binder.getCallingUid(), userId, false, true, "clearWallpaper", null);
        WallpaperData data = null;
        Object r2 = this.mLock;
        monitor-enter(r2);
        boolean fromForeground = isFromForegroundApp(callingPackage);     // Catch: Throwable -> L15
        clearWallpaperLocked(which, userId2, fromForeground, null);     // Catch: Throwable -> L15
        if (which != 2) goto L18;
        data = this.mLockWallpaperMap.get(userId2);     // Catch: Throwable -> L15
    L18:
        if (which == 1) goto L20;
        if (data == null) goto L20;
    L21:
        monitor-exit(r2);     // Catch: Throwable -> L15
        return;
    L20:
        WallpaperData r3 = this.mWallpaperMap.get(userId2);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    L29:
        return;
    }

    private void clearWallpaperLocked(int which, final int userId, final boolean fromForeground, IRemoteCallback reply) {
        boolean r1 = false;
        if (this.mWallpaperMap.contains(userId) == true) goto L5;
        loadSettingsLocked(userId, false, 3);
    L5:
        final WallpaperData wallpaper = this.mWallpaperMap.get(userId);
        WallpaperData lockWallpaper = this.mLockWallpaperMap.get(userId);
        if (which != 2) goto L12;
        if (lockWallpaper != null) goto L12;
        if (DEBUG == false) goto L60;
        Slog.i(TAG, "Lock wallpaper already cleared");
        return;
    L60:
        return;
    L12:
        RuntimeException e = null;
    L18:
        e1 = e;
        final IRemoteCallback r7 = reply;
    L44:
        e = e1;
    L45:
        Slog.e(TAG, "Default wallpaper component not found!", e);
        IWallpaperManager.Stub.withCleanCallingIdentity(new WallpaperManagerService$$ExternalSyntheticLambda9(this, wallpaper, r7));
        if (r7 != null) goto L53;
        return;
    L53:
        r7.sendResult(null);     // Catch: RemoteException -> L50
        return;
    L50:
        e1 = move-exception;
        Slog.w(TAG, "Failed to notify callback after wallpaper clear", e1);
        return;
    L14:
        if (userId != this.mCurrentUserId) goto L16;
    L20:
        List<WallpaperData> toClear = new ArrayList();     // Catch: IllegalArgumentException -> L18
        if ((which & 2) <= 0) goto L25;
        if (lockWallpaper == null) goto L25;
        toClear.add(lockWallpaper);     // Catch: IllegalArgumentException -> L18
    L25:
        if ((which & 1) <= 0) goto L27;
        toClear.add(wallpaper);     // Catch: IllegalArgumentException -> L18
    L27:
        Iterator<WallpaperData> r2 = toClear.iterator();     // Catch: IllegalArgumentException -> L18
    L29:
        if (r2.hasNext() == false) goto L32;
        WallpaperData wallpaperToClear = r2.next();     // Catch: IllegalArgumentException -> L18
        clearWallpaperBitmaps(wallpaperToClear);     // Catch: IllegalArgumentException -> L18
        wallpaperToClear.mCropHints.clear();     // Catch: IllegalArgumentException -> L18
        wallpaperToClear.cropHint.set(0, 0, 0, 0);     // Catch: IllegalArgumentException -> L18
        wallpaperToClear.mSampleSize = 1.0f;     // Catch: IllegalArgumentException -> L18
        goto L29
    L32:
        if (which != 2) goto L34;
        final WallpaperDescription description = wallpaper.getDescription();     // Catch: IllegalArgumentException -> L18
        final int finalWhich = 3;
    L35:
        if (which == 2) goto L37;
        r1 = true;
    L37:
        final boolean force = r1;
        r7 = reply;
        boolean success = ((Boolean) IWallpaperManager.Stub.withCleanCallingIdentity(new WallpaperManagerService$$ExternalSyntheticLambda8(this, description, finalWhich, userId, force, fromForeground, r7))).booleanValue();     // Catch: IllegalArgumentException -> L43
        if (success == false) goto L45;
        return;
    L43:
        e1 = e;
        goto L44
    L34:
        description = new WallpaperDescription.Builder().build();     // Catch: IllegalArgumentException -> L18
        finalWhich = which;
        goto L35
    L16:
        if (hasCrossUserPermission() == true) goto L20;
    }

    private /* synthetic */ Boolean lambda$clearWallpaperLocked$7(WallpaperDescription description, int finalWhich, int userId, boolean force, boolean fromForeground, IRemoteCallback reply) throws Exception {
        return Boolean.valueOf(setWallpaperDescriptionInternal(description, finalWhich, userId, force, fromForeground, reply));
    }

    private /* synthetic */ void lambda$clearWallpaperLocked$8(WallpaperData wallpaper, IRemoteCallback reply) throws Exception {
        wallpaper.mBindSource = WallpaperData.BindSource.FALLBACK_DEFAULT_MISSING;
        bindWallpaperComponentLocked(this.mImageWallpaper, true, false, wallpaper, reply);
    }

    private boolean hasCrossUserPermission() {
        int interactPermission = this.mContext.checkCallingPermission("android.permission.INTERACT_ACROSS_USERS_FULL");
        if (interactPermission != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean hasNamedWallpaper(String name) {
        int callingUser = UserHandle.getCallingUserId();
        boolean allowCrossUser = hasCrossUserPermission();
        if (DEBUG == false) goto L5;
        Slog.d(TAG, "hasNamedWallpaper() caller " + Binder.getCallingUid() + " cross-user?: " + allowCrossUser);
    L5:
        Object r2 = this.mLock;
        monitor-enter(r2);
        long ident = Binder.clearCallingIdentity();     // Catch: Throwable -> L17
        List<UserInfo> users = ((UserManager) this.mContext.getSystemService("user")).getUsers();     // Catch: Throwable -> L34
        Binder.restoreCallingIdentity(ident);     // Catch: Throwable -> L17
        Iterator<UserInfo> r6 = users.iterator();     // Catch: Throwable -> L17
    L11:
        if (r6.hasNext() == false) goto L32;
        UserInfo user = r6.next();     // Catch: Throwable -> L17
        if (allowCrossUser == true) goto L20;
        if (callingUser != user.id) goto L11;
    L20:
        if (user.isProfile() == true) goto L11;
        WallpaperData wd = this.mWallpaperMap.get(user.id);     // Catch: Throwable -> L17
        if (wd != null) goto L25;
        loadSettingsLocked(user.id, false, 3);     // Catch: Throwable -> L17
        wd = this.mWallpaperMap.get(user.id);     // Catch: Throwable -> L17
    L25:
        if (wd == null) goto L11;
        if (name.equals(wd.name) == false) goto L11;
        monitor-exit(r2);     // Catch: Throwable -> L17
        return true;
    L32:
        monitor-exit(r2);     // Catch: Throwable -> L17
        return false;
    L34:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);     // Catch: Throwable -> L17
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    }

    public void setDimensionHints(int width, int height, String callingPackage, int displayId) throws RemoteException {
        checkPermission("android.permission.SET_WALLPAPER_HINTS");
        if (isWallpaperSupported(callingPackage) == true) goto L5;
        return;
    L5:
        int width2 = Math.min(width, GLHelper.getMaxTextureSize());
        int height2 = Math.min(height, GLHelper.getMaxTextureSize());
        Object r0 = this.mLock;
        monitor-enter(r0);
        int userId = UserHandle.getCallingUserId();     // Catch: Throwable -> L17
        WallpaperData wallpaper = getWallpaperSafeLocked(userId, 1);     // Catch: Throwable -> L17
        if (width2 <= 0) goto L48;
        if (height2 <= 0) goto L48;
        if (this.mWallpaperDisplayHelper.isValidDisplay(displayId) == false) goto L46;
        WallpaperDisplayHelper.DisplayData wpdData = this.mWallpaperDisplayHelper.getDisplayDataOrCreate(displayId);     // Catch: Throwable -> L17
        if (width2 != wpdData.mWidth) goto L19;
        if (height2 != wpdData.mHeight) goto L19;
    L43:
        monitor-exit(r0);     // Catch: Throwable -> L17
        return;
    L19:
        wpdData.mWidth = width2;     // Catch: Throwable -> L17
        wpdData.mHeight = height2;     // Catch: Throwable -> L17
        if (displayId != 0) goto L23;
        saveSettingsLocked(userId);     // Catch: Throwable -> L17
    L23:
        if (this.mCurrentUserId == userId) goto L27;
        monitor-exit(r0);     // Catch: Throwable -> L17
        return;
    L27:
        if (wallpaper.connection == null) goto L43;
        DisplayConnector connector = wallpaper.connection.getDisplayConnectorOrCreate(displayId);     // Catch: Throwable -> L17
        if (connector == null) goto L32;
        IWallpaperEngine engine = connector.mEngine;     // Catch: Throwable -> L17
    L33:
        if (engine == null) goto L40;
        engine.setDesiredSize(width2, height2);     // Catch: Throwable -> L17 RemoteException -> L36
    L38:
        notifyCallbacksLocked(wallpaper);     // Catch: Throwable -> L17
        goto L43
    L36:
        e = move-exception;
        Slog.w(TAG, "Failed to set desired size", e);     // Catch: Throwable -> L17
        goto L38
    L40:
        if (wallpaper.connection.mService == null) goto L43;
        if (connector == null) goto L43;
        connector.mDimensionsChanged = true;     // Catch: Throwable -> L17
        goto L43
    L32:
        engine = null;
        goto L33
    L46:
        throw new IllegalArgumentException("Cannot find display with id=" + displayId);     // Catch: Throwable -> L17
    L48:
        throw new IllegalArgumentException("width and height must be > 0");     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    }

    public int getWidthHint(int displayId) throws RemoteException {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mWallpaperDisplayHelper.isValidDisplay(displayId) == false) goto L17;
        WallpaperData wallpaper = this.mWallpaperMap.get(UserHandle.getCallingUserId());     // Catch: Throwable -> L11
        if (wallpaper == null) goto L13;
        WallpaperDisplayHelper.DisplayData wpdData = this.mWallpaperDisplayHelper.getDisplayDataOrCreate(displayId);     // Catch: Throwable -> L11
        int r3 = wpdData.mWidth;     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r3;
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return 0;
    L17:
        throw new IllegalArgumentException("Cannot find display with id=" + displayId);     // Catch: Throwable -> L11
    }

    public int getHeightHint(int displayId) throws RemoteException {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mWallpaperDisplayHelper.isValidDisplay(displayId) == false) goto L17;
        WallpaperData wallpaper = this.mWallpaperMap.get(UserHandle.getCallingUserId());     // Catch: Throwable -> L11
        if (wallpaper == null) goto L13;
        WallpaperDisplayHelper.DisplayData wpdData = this.mWallpaperDisplayHelper.getDisplayDataOrCreate(displayId);     // Catch: Throwable -> L11
        int r3 = wpdData.mHeight;     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r3;
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return 0;
    L17:
        throw new IllegalArgumentException("Cannot find display with id=" + displayId);     // Catch: Throwable -> L11
    }

    public void setDisplayPadding(Rect padding, String callingPackage, int displayId) {
        checkPermission("android.permission.SET_WALLPAPER_HINTS");
        if (isWallpaperSupported(callingPackage) == true) goto L5;
        return;
    L5:
        Object r0 = this.mLock;
        monitor-enter(r0);
    L25:
        th = move-exception;
        throw th;
    L8:
        if (this.mWallpaperDisplayHelper.isValidDisplay(displayId) == false) goto L57;
        int userId = UserHandle.getCallingUserId();     // Catch: Throwable -> L25
        WallpaperData wallpaper = getWallpaperSafeLocked(userId, 1);     // Catch: Throwable -> L25
        if (padding.left < 0) goto L55;
        if (padding.top < 0) goto L55;
        if (padding.right < 0) goto L55;
        if (padding.bottom < 0) goto L55;
        int maxSize = this.mWallpaperDisplayHelper.getMaximumSizeDimension(displayId);     // Catch: Throwable -> L25
        int paddingWidth = padding.left + padding.right;     // Catch: Throwable -> L25
        int paddingHeight = padding.top + padding.bottom;     // Catch: Throwable -> L25
        if (paddingWidth > maxSize) goto L53;
        if (paddingHeight > maxSize) goto L51;
        WallpaperDisplayHelper.DisplayData wpdData = this.mWallpaperDisplayHelper.getDisplayDataOrCreate(displayId);     // Catch: Throwable -> L25
        if (padding.equals(wpdData.mPadding) == true) goto L48;
        wpdData.mPadding.set(padding);     // Catch: Throwable -> L25
        if (displayId != 0) goto L28;
        saveSettingsLocked(userId);     // Catch: Throwable -> L25
    L28:
        if (this.mCurrentUserId == userId) goto L32;
        monitor-exit(r0);     // Catch: Throwable -> L25
        return;
    L32:
        if (wallpaper.connection == null) goto L48;
        DisplayConnector connector = wallpaper.connection.getDisplayConnectorOrCreate(displayId);     // Catch: Throwable -> L25
        if (connector == null) goto L37;
        IWallpaperEngine engine = connector.mEngine;     // Catch: Throwable -> L25
    L38:
        if (engine == null) goto L45;
        engine.setDisplayPadding(padding);     // Catch: Throwable -> L25 RemoteException -> L41
    L43:
        notifyCallbacksLocked(wallpaper);     // Catch: Throwable -> L25
        goto L48
    L41:
        e = move-exception;
        Slog.w(TAG, "Failed to set display padding", e);     // Catch: Throwable -> L25
        goto L43
    L45:
        if (wallpaper.connection.mService == null) goto L48;
        if (connector == null) goto L48;
        connector.mPaddingChanged = true;     // Catch: Throwable -> L25
        goto L48
    L37:
        engine = null;
    L48:
        monitor-exit(r0);     // Catch: Throwable -> L25
        return;
    L51:
        throw new IllegalArgumentException("padding height " + paddingHeight + " exceeds max height " + maxSize);     // Catch: Throwable -> L25
    L53:
        throw new IllegalArgumentException("padding width " + paddingWidth + " exceeds max width " + maxSize);     // Catch: Throwable -> L25
    L55:
        throw new IllegalArgumentException("padding must be positive: " + padding);     // Catch: Throwable -> L25
    L57:
        throw new IllegalArgumentException("Cannot find display with id=" + displayId);     // Catch: Throwable -> L25
    }

    @Deprecated
    public ParcelFileDescriptor getWallpaper(String callingPkg, IWallpaperManagerCallback cb, int which, Bundle outParams, int wallpaperUserId) {
        return getWallpaperWithFeature(callingPkg, null, cb, which, outParams, wallpaperUserId, true);
    }

    public ParcelFileDescriptor getWallpaperWithFeature(String callingPkg, String callingFeatureId, IWallpaperManagerCallback cb, int which, Bundle outParams, int wallpaperUserId, boolean getCropped) {
        int callingPid = Binder.getCallingPid();
        int callingUid = Binder.getCallingUid();
        boolean hasPrivilege = hasPermission("android.permission.READ_WALLPAPER_INTERNAL");
        if (hasPrivilege == false) goto L5;
        WallpaperManagerService r6 = this;
    L16:
        int wallpaperUserId2 = ActivityManager.handleIncomingUser(callingPid, callingUid, wallpaperUserId, false, true, "getWallpaper", null);
        if (which == 1) goto L22;
        if (which == 2) goto L22;
        throw new IllegalArgumentException("Must specify exactly one kind of wallpaper to read");
    L22:
        Object r5 = r6.mLock;
        monitor-enter(r5);
        if (which != 2) goto L28;
        SparseArray<WallpaperData> r0 = r6.mLockWallpaperMap;     // Catch: Throwable -> L26
    L29:
        SparseArray<WallpaperData> whichSet = r0;
        WallpaperData wallpaper = whichSet.get(wallpaperUserId2);     // Catch: Throwable -> L26
        if (wallpaper != null) goto L33;
        monitor-exit(r5);     // Catch: Throwable -> L26
        return null;
    L33:
        WallpaperDisplayHelper.DisplayData wpdData = r6.mWallpaperDisplayHelper.getDisplayDataOrCreate(0);     // Catch: Throwable -> L26
        if (outParams != null) goto L58;
    L39:
        if (cb == null) goto L42;
        wallpaper.callbacks.register(cb);     // Catch: Throwable -> L26 FileNotFoundException -> L37
    L42:
        if (getCropped == false) goto L44;
        File result = wallpaper.getCropFile();     // Catch: Throwable -> L26 FileNotFoundException -> L37
    L46:
        if (result.exists() == true) goto L50;
        monitor-exit(r5);     // Catch: Throwable -> L26
        return null;
    L50:
        ParcelFileDescriptor r12 = ParcelFileDescriptor.open(result, 268435456);     // Catch: Throwable -> L26 FileNotFoundException -> L37
        monitor-exit(r5);     // Catch: Throwable -> L26
        return r12;
    L37:
        e = move-exception;
        Slog.w(TAG, "Error getting wallpaper", e);     // Catch: Throwable -> L26
        return null;
    L44:
        result = wallpaper.getWallpaperFile();     // Catch: Throwable -> L26 FileNotFoundException -> L37
        goto L46
    L58:
        outParams.putInt("width", wpdData.mWidth);     // Catch: Throwable -> L26 FileNotFoundException -> L37
        outParams.putInt("height", wpdData.mHeight);     // Catch: Throwable -> L26 FileNotFoundException -> L37
        goto L39
    L28:
        r0 = r6.mWallpaperMap;     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        throw th;
    L5:
        if (hasPermission("android.permission.MANAGE_EXTERNAL_STORAGE") == true) goto L10;
        r6 = this;
        if (hasAppOpPermission("android.permission.MANAGE_EXTERNAL_STORAGE", callingUid, callingPkg, callingFeatureId, "getWallpaperWithFeature from package: " + callingPkg) == true) goto L11;
        boolean r1 = false;
    L12:
        boolean hasManageExternalStorage = r1;
        if (hasManageExternalStorage == true) goto L16;
        ((StorageManager) r6.mContext.getSystemService(StorageManager.class)).checkPermissionReadImages(true, callingPid, callingUid, callingPkg, callingFeatureId);
    L11:
        r1 = true;
        goto L12
    L10:
        r6 = this;
        goto L11
    }

    public List<Rect> getBitmapCrops(List<Point> displaySizes, int which, boolean originalBitmap, int userId) {
        int userId2 = ActivityManager.handleIncomingUser(Binder.getCallingPid(), Binder.getCallingUid(), userId, false, true, "getBitmapCrop", null);
        Object r2 = this.mLock;
        monitor-enter(r2);
        checkPermission("android.permission.READ_WALLPAPER_INTERNAL");     // Catch: Throwable -> L40
        if (which != 2) goto L10;
        WallpaperData wallpaper = this.mLockWallpaperMap.get(userId2);     // Catch: Throwable -> L8
    L12:
        if (wallpaper == null) goto L38;
        if (this.mImageWallpaper.equals(wallpaper.getComponent()) == false) goto L38;
        SparseArray<Rect> relativeSuggestedCrops = this.mWallpaperCropper.getRelativeCropHints(wallpaper);     // Catch: Throwable -> L8
        Point croppedBitmapSize = new Point((int) Math.ceil(wallpaper.cropHint.width() / wallpaper.mSampleSize), (int) Math.ceil(wallpaper.cropHint.height() / wallpaper.mSampleSize));     // Catch: Throwable -> L8
        boolean rtl = false;
        if (croppedBitmapSize.equals(0, 0) == false) goto L20;
        monitor-exit(r2);     // Catch: Throwable -> L8
        return null;
    L20:
        SparseArray<Rect> relativeDefaultCrops = this.mWallpaperCropper.getDefaultCrops(relativeSuggestedCrops, croppedBitmapSize);     // Catch: Throwable -> L8
        SparseArray<Rect> adjustedRelativeSuggestedCrops = new SparseArray();     // Catch: Throwable -> L8
        int i = 0;
    L22:
        if (i >= relativeDefaultCrops.size()) goto L27;
        int key = relativeDefaultCrops.keyAt(i);     // Catch: Throwable -> L8
        if (relativeSuggestedCrops.contains(key) == false) goto L26;
        adjustedRelativeSuggestedCrops.put(key, relativeDefaultCrops.get(key));     // Catch: Throwable -> L8
    L26:
        i = i + 1;     // Catch: Throwable -> L8
        goto L22
    L27:
        List<Rect> result = new ArrayList();     // Catch: Throwable -> L8
        if (TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) != 1) goto L30;
        rtl = true;
    L30:
        WallpaperDefaultDisplayInfo defaultDisplayInfo = this.mWallpaperDisplayHelper.getDefaultDisplayInfo();     // Catch: Throwable -> L8
        Iterator<Point> r11 = displaySizes.iterator();     // Catch: Throwable -> L8
    L32:
        if (r11.hasNext() == false) goto L34;
        Point displaySize = r11.next();     // Catch: Throwable -> L8
        result.add(WallpaperCropper.getCrop(displaySize, defaultDisplayInfo, croppedBitmapSize, adjustedRelativeSuggestedCrops, rtl));     // Catch: Throwable -> L8
        goto L32
    L34:
        if (originalBitmap == false) goto L36;
        result = WallpaperCropper.getOriginalCropHints(wallpaper, result);     // Catch: Throwable -> L8
    L36:
        monitor-exit(r2);     // Catch: Throwable -> L8
        return result;
    L38:
        monitor-exit(r2);     // Catch: Throwable -> L8
        return null;
    L10:
        wallpaper = this.mWallpaperMap.get(userId2);     // Catch: Throwable -> L8
    L8:
        th = th;
    L42:
        monitor-exit(r2);     // Catch: Throwable -> L8
        throw th;
    L40:
        th = th;
        goto L42
    }

    public Bundle getCurrentBitmapCrops(int which, int userId) {
        int userId2 = ActivityManager.handleIncomingUser(Binder.getCallingPid(), Binder.getCallingUid(), userId, false, true, "getBitmapCrop", null);
        Object r1 = this.mLock;
        monitor-enter(r1);
        checkPermission("android.permission.READ_WALLPAPER_INTERNAL");     // Catch: Throwable -> L7
        if (which != 2) goto L9;
        WallpaperData wallpaper = this.mLockWallpaperMap.get(userId2);     // Catch: Throwable -> L7
    L11:
        if (wallpaper == null) goto L22;
        if (this.mImageWallpaper.equals(wallpaper.getComponent()) == false) goto L22;
        Bundle bundle = new Bundle();     // Catch: Throwable -> L7
        int i = 0;
    L17:
        if (i >= wallpaper.mCropHints.size()) goto L20;
        String key = String.valueOf(wallpaper.mCropHints.keyAt(i));     // Catch: Throwable -> L7
        Rect rect = wallpaper.mCropHints.valueAt(i);     // Catch: Throwable -> L7
        bundle.putParcelable(key, rect);     // Catch: Throwable -> L7
        i = i + 1;     // Catch: Throwable -> L7
        goto L17
    L20:
        monitor-exit(r1);     // Catch: Throwable -> L7
        return bundle;
    L22:
        monitor-exit(r1);     // Catch: Throwable -> L7
        return null;
    L9:
        wallpaper = this.mWallpaperMap.get(userId2);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }

    public List<Rect> getFutureBitmapCrops(Point bitmapSize, List<Point> displaySizes, int[] screenOrientations, List<Rect> crops) {
        SparseArray<Rect> cropMap = getCropMap(screenOrientations, crops);
        SparseArray<Rect> defaultCrops = this.mWallpaperCropper.getDefaultCrops(cropMap, bitmapSize);
        List<Rect> result = new ArrayList();
        boolean rtl = true;
        if (TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1) goto L6;
        rtl = false;
    L6:
        WallpaperDefaultDisplayInfo defaultDisplayInfo = this.mWallpaperDisplayHelper.getDefaultDisplayInfo();
        Iterator<Point> r5 = displaySizes.iterator();
    L8:
        if (r5.hasNext() == false) goto L10;
        Point displaySize = r5.next();
        result.add(WallpaperCropper.getCrop(displaySize, defaultDisplayInfo, bitmapSize, defaultCrops, rtl));
        goto L8
    L10:
        return result;
    }

    public Rect getBitmapCrop(Point bitmapSize, int[] screenOrientations, List<Rect> crops) {
        SparseArray<Rect> cropMap = getCropMap(screenOrientations, crops);
        SparseArray<Rect> defaultCrops = this.mWallpaperCropper.getDefaultCrops(cropMap, bitmapSize);
        return WallpaperCropper.getTotalCrop(defaultCrops);
    }

    private boolean hasPermission(String permission) {
        if (this.mContext.checkCallingOrSelfPermission(permission) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean hasPermission(WallpaperData data, String permission) {
        if (this.mIPackageManager.checkPermission(permission, data.getComponent().getPackageName(), data.userId) != 0) goto L12;
        return true;
    L12:
        return false;
    L7:
        e = move-exception;
        Slog.e(TAG, "Failed to check wallpaper service permission", e);
        return false;
    }

    private boolean hasAppOpPermission(String permission, int callingUid, String callingPackage, String attributionTag, String message) {
        String op = AppOpsManager.permissionToOp(permission);
        int opMode = this.mAppOpsManager.noteOpNoThrow(op, callingUid, callingPackage, attributionTag, message);
        switch(opMode) {
            case 0: goto L8;
            case 1: goto L4;
            case 2: goto L4;
            case 3: goto L7;
            case 4: goto L8;
            default: goto L4;
        };
    L4:
        return false;
    L8:
        return true;
    L7:
        return hasPermission(permission);
    }

    public WallpaperInfo getWallpaperInfo(int userId) {
        return getWallpaperInfoWithFlags(1, userId);
    }

    public WallpaperInfo getWallpaperInfoWithFlags(int which, int userId) {
        WallpaperInstance instance = getWallpaperInstance(which, userId, false);
        if (instance != null) goto L7;
        return null;
    L7:
        return instance.getInfo();
    }

    public WallpaperInstance getWallpaperInstance(int which, int userId) {
        return getWallpaperInstance(which, userId, true);
    }

    private WallpaperInstance getWallpaperInstance(int which, int userId, boolean requireReadWallpaper) {
        int userId2 = ActivityManager.handleIncomingUser(Binder.getCallingPid(), Binder.getCallingUid(), userId, false, true, "getWallpaperInfo", null);
        Object r1 = this.mLock;
        monitor-enter(r1);
        if (which != 2) goto L9;
        WallpaperData wallpaper = this.mLockWallpaperMap.get(userId2);     // Catch: Throwable -> L7
    L11:
        if (wallpaper == null) goto L32;
        if (wallpaper.connection == null) goto L32;
        WallpaperInfo info = wallpaper.connection.mInfo;     // Catch: Throwable -> L7
        if (info == null) goto L21;
        if (this.mPackageManagerInternal.canQueryPackage(Binder.getCallingUid(), info.getComponent().getPackageName()) == true) goto L21;
        boolean canQueryPackage = false;
    L23:
        if (hasPermission("android.permission.READ_WALLPAPER_INTERNAL") == true) goto L29;
        if (canQueryPackage == false) goto L27;
        if (requireReadWallpaper == false) goto L29;
    L27:
        monitor-exit(r1);     // Catch: Throwable -> L7
        return null;
    L29:
        WallpaperDescription description = wallpaper.getDescription().toBuilder().setCropHints(wallpaper.mCropHints).build();     // Catch: Throwable -> L7
        WallpaperInstance r5 = new WallpaperInstance(info, description);     // Catch: Throwable -> L7
        monitor-exit(r1);     // Catch: Throwable -> L7
        return r5;
    L21:
        canQueryPackage = true;
    L32:
        monitor-exit(r1);     // Catch: Throwable -> L7
        return null;
    L9:
        wallpaper = this.mWallpaperMap.get(userId2);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }

    public ParcelFileDescriptor getWallpaperInfoFile(int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        File file = new File(WallpaperUtils.getWallpaperDir(userId), "wallpaper_info.xml");     // Catch: Throwable -> L9 FileNotFoundException -> L15
        if (file.exists() == true) goto L12;
        monitor-exit(r0);     // Catch: Throwable -> L9
        return null;
    L12:
        ParcelFileDescriptor r1 = ParcelFileDescriptor.open(file, 268435456);     // Catch: Throwable -> L9 FileNotFoundException -> L15
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    L15:
        e = move-exception;
        Slog.w(TAG, "Error getting wallpaper info file", e);     // Catch: Throwable -> L9
        return null;
    L9:
        th = move-exception;
        throw th;
    }

    public int getWallpaperIdForUser(int which, int userId) {
        int userId2 = ActivityManager.handleIncomingUser(Binder.getCallingPid(), Binder.getCallingUid(), userId, false, true, "getWallpaperIdForUser", null);
        if (which == 1) goto L8;
        if (which == 2) goto L8;
        throw new IllegalArgumentException("Must specify exactly one kind of wallpaper");
    L8:
        if (which != 2) goto L10;
        SparseArray<WallpaperData> r0 = this.mLockWallpaperMap;
    L11:
        SparseArray<WallpaperData> map = r0;
        Object r2 = this.mLock;
        monitor-enter(r2);
        WallpaperData wallpaper = map.get(userId2);     // Catch: Throwable -> L18
        if (wallpaper == null) goto L21;
        int r3 = wallpaper.wallpaperId;     // Catch: Throwable -> L18
        monitor-exit(r2);     // Catch: Throwable -> L18
        return r3;
    L21:
        monitor-exit(r2);     // Catch: Throwable -> L18
        return -1;
    L18:
        th = move-exception;
        throw th;
    L10:
        r0 = this.mWallpaperMap;
        goto L11
    }

    public void registerWallpaperColorsCallback(IWallpaperManagerCallback cb, int userId, int displayId) {
        int userId2 = ActivityManager.handleIncomingUser(Binder.getCallingPid(), Binder.getCallingUid(), userId, true, true, "registerWallpaperColorsCallback", null);
        Object r1 = this.mLock;
        monitor-enter(r1);
        SparseArray<RemoteCallbackList<IWallpaperManagerCallback>> userDisplayColorsChangedListeners = this.mColorsChangedListeners.get(userId2);     // Catch: Throwable -> L7
        if (userDisplayColorsChangedListeners != null) goto L9;
        userDisplayColorsChangedListeners = new SparseArray();     // Catch: Throwable -> L7
        this.mColorsChangedListeners.put(userId2, userDisplayColorsChangedListeners);     // Catch: Throwable -> L7
    L9:
        RemoteCallbackList<IWallpaperManagerCallback> displayChangedListeners = userDisplayColorsChangedListeners.get(displayId);     // Catch: Throwable -> L7
        if (displayChangedListeners != null) goto L12;
        displayChangedListeners = new RemoteCallbackList();     // Catch: Throwable -> L7
        userDisplayColorsChangedListeners.put(displayId, displayChangedListeners);     // Catch: Throwable -> L7
    L12:
        displayChangedListeners.register(cb);     // Catch: Throwable -> L7
        monitor-exit(r1);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void unregisterWallpaperColorsCallback(IWallpaperManagerCallback cb, int userId, int displayId) {
        int userId2 = ActivityManager.handleIncomingUser(Binder.getCallingPid(), Binder.getCallingUid(), userId, true, true, "unregisterWallpaperColorsCallback", null);
        Object r1 = this.mLock;
        monitor-enter(r1);
        SparseArray<RemoteCallbackList<IWallpaperManagerCallback>> userDisplayColorsChangedListeners = this.mColorsChangedListeners.get(userId2);     // Catch: Throwable -> L9
        if (userDisplayColorsChangedListeners == null) goto L11;
        RemoteCallbackList<IWallpaperManagerCallback> displayChangedListeners = userDisplayColorsChangedListeners.get(displayId);     // Catch: Throwable -> L9
        if (displayChangedListeners == null) goto L11;
        displayChangedListeners.unregister(cb);     // Catch: Throwable -> L9
    L11:
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public void setInAmbientMode(boolean inAmbientMode, long animationDuration) {
        List<IWallpaperEngine> engines = new ArrayList();
        Object r1 = this.mLock;
        monitor-enter(r1);
        this.mInAmbientMode = inAmbientMode;     // Catch: Throwable -> L11
        WallpaperData[] r2 = getActiveWallpapers();     // Catch: Throwable -> L11
        int r3 = r2.length;     // Catch: Throwable -> L11
        int r5 = 0;
    L5:
        if (r5 >= r3) goto L17;
        WallpaperData data = r2[r5];     // Catch: Throwable -> L11
        if (data.connection.mInfo != null) goto L9;
    L13:
        IWallpaperEngine engine = data.connection.getDisplayConnectorOrCreate(0).mEngine;     // Catch: Throwable -> L11
        if (engine == null) goto L16;
        engines.add(engine);     // Catch: Throwable -> L11
    L16:
        r5 = r5 + 1;     // Catch: Throwable -> L11
        goto L5
    L9:
        if (data.connection.mInfo.supportsAmbientMode() == false) goto L16;
    L17:
        monitor-exit(r1);     // Catch: Throwable -> L11
        Iterator<IWallpaperEngine> r4 = engines.iterator();
    L20:
        if (r4.hasNext() == false) goto L27;
        r4.next().setInAmbientMode(inAmbientMode, animationDuration);     // Catch: RemoteException -> L24
    L24:
        e = move-exception;
        Slog.w(TAG, "Failed to set ambient mode", e);
        goto L20
    L27:
        return;
    L11:
        th = move-exception;
        throw th;
    }

    private void pauseOrResumeRenderingImmediately(final boolean pause) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        WallpaperData[] r1 = getActiveWallpapers();     // Catch: Throwable -> L13
        int r2 = r1.length;     // Catch: Throwable -> L13
        int r3 = 0;
    L5:
        if (r3 >= r2) goto L19;
        WallpaperData data = r1[r3];     // Catch: Throwable -> L13
        if (data.connection.mInfo == null) goto L18;
        if (pause == true) goto L16;
        if (((ActivityTaskManagerInternal) LocalServices.getService(ActivityTaskManagerInternal.class)).isUidForeground(data.connection.mInfo.getServiceInfo().applicationInfo.uid) == false) goto L18;
    L16:
        if (data.connection.containsDisplay(this.mWindowManagerInternal.getTopFocusedDisplayId()) == false) goto L18;
        data.connection.forEachDisplayConnector(new WallpaperManagerService$$ExternalSyntheticLambda0(pause));     // Catch: Throwable -> L13
    L18:
        r3 = r3 + 1;     // Catch: Throwable -> L13
        goto L5
    L19:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ void lambda$pauseOrResumeRenderingImmediately$9(boolean pause, DisplayConnector displayConnector) {
        if (displayConnector.mEngine == null) goto L15;
        IWallpaperEngine r0 = displayConnector.mEngine;     // Catch: RemoteException -> L10
        if (pause == true) goto L7;
        boolean r1 = true;
    L8:
        r0.setVisibility(r1);     // Catch: RemoteException -> L10
        return;
    L7:
        r1 = false;
    L10:
        e = move-exception;
        Slog.w(TAG, "Failed to set visibility", e);
        return;
    }

    public void notifyWakingUp(final int x, final int y, final Bundle extras) {
        checkCallerIsSystemOrSystemUi();
        Object r0 = this.mLock;
        monitor-enter(r0);
        WallpaperData[] r1 = getActiveWallpapers();     // Catch: Throwable -> L7
        int r2 = r1.length;     // Catch: Throwable -> L7
        int r3 = 0;
    L5:
        if (r3 >= r2) goto L9;
        WallpaperData data = r1[r3];     // Catch: Throwable -> L7
        data.connection.forEachDisplayConnector(new WallpaperManagerService$$ExternalSyntheticLambda5(x, y, extras));     // Catch: Throwable -> L7
        r3 = r3 + 1;     // Catch: Throwable -> L7
        goto L5
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ void lambda$notifyWakingUp$10(int x, int y, Bundle extras, DisplayConnector displayConnector) {
        if (displayConnector.mEngine == null) goto L14;
        displayConnector.mEngine.dispatchWallpaperCommand("android.wallpaper.wakingup", x, y, -1, extras);     // Catch: RemoteException -> L8
        return;
    L8:
        e = move-exception;
        RemoteException e = e;
    L12:
        Slog.w(TAG, "Failed to dispatch COMMAND_WAKING_UP", e);
        return;
    L10:
        e = move-exception;
        e = e;
        goto L12
    }

    public void notifyGoingToSleep(final int x, final int y, final Bundle extras) {
        checkCallerIsSystemOrSystemUi();
        Object r0 = this.mLock;
        monitor-enter(r0);
        WallpaperData[] r1 = getActiveWallpapers();     // Catch: Throwable -> L7
        int r2 = r1.length;     // Catch: Throwable -> L7
        int r3 = 0;
    L5:
        if (r3 >= r2) goto L9;
        WallpaperData data = r1[r3];     // Catch: Throwable -> L7
        data.connection.forEachDisplayConnector(new WallpaperManagerService$$ExternalSyntheticLambda19(x, y, extras));     // Catch: Throwable -> L7
        r3 = r3 + 1;     // Catch: Throwable -> L7
        goto L5
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ void lambda$notifyGoingToSleep$11(int x, int y, Bundle extras, DisplayConnector displayConnector) {
        if (displayConnector.mEngine == null) goto L14;
        displayConnector.mEngine.dispatchWallpaperCommand("android.wallpaper.goingtosleep", x, y, -1, extras);     // Catch: RemoteException -> L8
        return;
    L8:
        e = move-exception;
        RemoteException e = e;
    L12:
        Slog.w(TAG, "Failed to dispatch COMMAND_GOING_TO_SLEEP", e);
        return;
    L10:
        e = move-exception;
        e = e;
        goto L12
    }

    private void notifyScreenTurnedOn(int displayId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        WallpaperData[] r1 = getActiveWallpapers();     // Catch: Throwable -> L12
        int r2 = r1.length;     // Catch: Throwable -> L12
        int r3 = 0;
    L5:
        if (r3 >= r2) goto L17;
        WallpaperData data = r1[r3];     // Catch: Throwable -> L12
        if (data.connection.containsDisplay(displayId) == false) goto L16;
        IWallpaperEngine engine = data.connection.getDisplayConnectorOrCreate(displayId).mEngine;     // Catch: Throwable -> L12
        if (engine == null) goto L16;
        engine.onScreenTurnedOn();     // Catch: Throwable -> L12 RemoteException -> L14
    L14:
        e = move-exception;
        Slog.w(TAG, "Failed to notify that the screen turned on", e);     // Catch: Throwable -> L12
    L16:
        r3 = r3 + 1;     // Catch: Throwable -> L12
        goto L5
    L17:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    private void notifyScreenTurningOn(int displayId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        WallpaperData[] r1 = getActiveWallpapers();     // Catch: Throwable -> L12
        int r2 = r1.length;     // Catch: Throwable -> L12
        int r3 = 0;
    L5:
        if (r3 >= r2) goto L17;
        WallpaperData data = r1[r3];     // Catch: Throwable -> L12
        if (data.connection.containsDisplay(displayId) == false) goto L16;
        IWallpaperEngine engine = data.connection.getDisplayConnectorOrCreate(displayId).mEngine;     // Catch: Throwable -> L12
        if (engine == null) goto L16;
        engine.onScreenTurningOn();     // Catch: Throwable -> L12 RemoteException -> L14
    L14:
        e = move-exception;
        Slog.w(TAG, "Failed to notify that the screen is turning on", e);     // Catch: Throwable -> L12
    L16:
        r3 = r3 + 1;     // Catch: Throwable -> L12
        goto L5
    L17:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    private void notifyKeyguardGoingAway() {
        dispatchKeyguardCommand("android.wallpaper.keyguardgoingaway");
    }

    private void notifyKeyguardAppearing() {
        dispatchKeyguardCommand("android.wallpaper.keyguardappearing");
    }

    private void dispatchKeyguardCommand(final String command) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        WallpaperData[] r1 = getActiveWallpapers();     // Catch: Throwable -> L7
        int r2 = r1.length;     // Catch: Throwable -> L7
        int r3 = 0;
    L5:
        if (r3 >= r2) goto L9;
        WallpaperData data = r1[r3];     // Catch: Throwable -> L7
        data.connection.forEachDisplayConnector(new WallpaperManagerService$$ExternalSyntheticLambda11(command));     // Catch: Throwable -> L7
        r3 = r3 + 1;     // Catch: Throwable -> L7
        goto L5
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ void lambda$dispatchKeyguardCommand$12(String command, DisplayConnector displayConnector) {
        if (displayConnector.mEngine == null) goto L14;
        String command2 = command;
        displayConnector.mEngine.dispatchWallpaperCommand(command2, -1, -1, -1, new Bundle());     // Catch: RemoteException -> L8
        return;
    L8:
        e = move-exception;
        RemoteException e = e;
    L12:
        Slog.w(TAG, "Failed to dispatch wallpaper command: " + command2, e);
        return;
    L10:
        e = move-exception;
        command2 = command;
        e = e;
        goto L12
    }

    WallpaperData[] getActiveWallpapers() {
        WallpaperData systemWallpaper = this.mWallpaperMap.get(this.mCurrentUserId);
        WallpaperData lockWallpaper = this.mLockWallpaperMap.get(this.mCurrentUserId);
        if (systemWallpaper != null) goto L5;
    L7:
        boolean systemValid = false;
    L8:
        if (lockWallpaper != null) goto L10;
    L12:
        boolean lockValid = false;
    L13:
        if (systemValid == false) goto L16;
        if (lockValid == false) goto L16;
        return new WallpaperData[]{systemWallpaper, lockWallpaper};
    L16:
        if (systemValid == true) goto L23;
        if (lockValid == false) goto L21;
        return new WallpaperData[]{lockWallpaper};
    L21:
        return new WallpaperData[0];
    L23:
        return new WallpaperData[]{systemWallpaper};
    L10:
        if (lockWallpaper.connection == null) goto L12;
        lockValid = true;
        goto L13
    L5:
        if (systemWallpaper.connection == null) goto L7;
        systemValid = true;
        goto L8
    }

    private WallpaperData[] getWallpapers() {
        WallpaperData systemWallpaper = this.mWallpaperMap.get(this.mCurrentUserId);
        WallpaperData lockWallpaper = this.mLockWallpaperMap.get(this.mCurrentUserId);
        if (systemWallpaper == null) goto L5;
        boolean systemValid = true;
    L6:
        if (lockWallpaper == null) goto L8;
        boolean lockValid = true;
    L9:
        if (systemValid == false) goto L12;
        if (lockValid == false) goto L12;
        return new WallpaperData[]{systemWallpaper, lockWallpaper};
    L12:
        if (systemValid == true) goto L19;
        if (lockValid == false) goto L17;
        return new WallpaperData[]{lockWallpaper};
    L17:
        return new WallpaperData[0];
    L19:
        return new WallpaperData[]{systemWallpaper};
    L8:
        lockValid = false;
        goto L9
    L5:
        systemValid = false;
        goto L6
    }

    private IWallpaperEngine getEngine(int which, int userId, int displayId) {
        WallpaperData wallpaperData = findWallpaperAtDisplay(userId, displayId);
        if (wallpaperData != null) goto L5;
        return null;
    L5:
        WallpaperConnection connection = wallpaperData.connection;
        if (connection != null) goto L8;
        return null;
    L8:
        IWallpaperEngine engine = null;
        Object r3 = this.mLock;
        monitor-enter(r3);
        int i = 0;
    L24:
    L18:
        th = move-exception;
        throw th;
    L12:
        if (i >= WallpaperConnection.m9542$$Nest$fgetmDisplayConnector(connection).size()) goto L20;
        int id = ((DisplayConnector) WallpaperConnection.m9542$$Nest$fgetmDisplayConnector(connection).get(i)).mDisplayId;     // Catch: Throwable -> L18
        int currentWhich = ((DisplayConnector) WallpaperConnection.m9542$$Nest$fgetmDisplayConnector(connection).get(i)).mDisplayId;     // Catch: Throwable -> L18
        if (id == displayId) goto L17;
        if (currentWhich == which) goto L17;
        i = i + 1;     // Catch: Throwable -> L18
    L17:
        engine = ((DisplayConnector) WallpaperConnection.m9542$$Nest$fgetmDisplayConnector(connection).get(i)).mEngine;     // Catch: Throwable -> L18
    L20:
        monitor-exit(r3);     // Catch: Throwable -> L18
        return engine;
    }

    public void addOnLocalColorsChangedListener(ILocalWallpaperColorConsumer callback, List<RectF> regions, int which, int userId, int displayId) throws RemoteException {
        if (which != 2) goto L5;
    L9:
        IWallpaperEngine engine = getEngine(which, userId, displayId);
        if (engine != null) goto L12;
        return;
    L12:
        Object r1 = this.mLock;
        monitor-enter(r1);
        this.mLocalColorRepo.addAreas(callback, regions, displayId);     // Catch: Throwable -> L18
        monitor-exit(r1);     // Catch: Throwable -> L18
        engine.addLocalColorsAreas(regions);
        return;
    L18:
        th = move-exception;
        throw th;
    L5:
        if (which == 1) goto L9;
        throw new IllegalArgumentException("which should be either FLAG_LOCK or FLAG_SYSTEM");
    }

    public void removeOnLocalColorsChangedListener(ILocalWallpaperColorConsumer callback, List<RectF> removeAreas, int which, int userId, int displayId) throws RemoteException {
        if (which != 2) goto L5;
    L9:
        UserHandle callingUser = Binder.getCallingUserHandle();
        if (callingUser.getIdentifier() != userId) goto L36;
        long identity = Binder.clearCallingIdentity();
        List<RectF> purgeAreas = null;
        Object r4 = this.mLock;     // Catch: Throwable -> L20 Exception -> L22
        monitor-enter(r4);     // Catch: Throwable -> L20 Exception -> L22
        purgeAreas = this.mLocalColorRepo.removeAreas(callback, removeAreas, displayId);     // Catch: Throwable -> L17
        monitor-exit(r4);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;     // Catch: Throwable -> L20 Exception -> L22
    L20:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    L16:
        Binder.restoreCallingIdentity(identity);
        IWallpaperEngine engine = getEngine(which, userId, displayId);
        if (engine == null) goto L34;
        if (purgeAreas != null) goto L31;
        return;
    L31:
        if (purgeAreas.size() <= 0) goto L41;
        engine.removeLocalColorsAreas(purgeAreas);
        return;
    L41:
        return;
    L34:
        return;
    L36:
        throw new SecurityException("calling user id does not match");
    L5:
        if (which == 1) goto L9;
        throw new IllegalArgumentException("which should be either FLAG_LOCK or FLAG_SYSTEM");
    }

    public boolean lockScreenWallpaperExists() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.mLockWallpaperMap.get(this.mCurrentUserId) == null) goto L7;
        boolean r1 = true;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r1;
    L7:
        r1 = false;
        goto L8
    }

    public boolean isStaticWallpaper(int which) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        if (which != 2) goto L9;
        SparseArray<WallpaperData> r1 = this.mLockWallpaperMap;     // Catch: Throwable -> L7
    L10:
        WallpaperData wallpaperData = r1.get(this.mCurrentUserId);     // Catch: Throwable -> L7
        if (wallpaperData != null) goto L15;
        monitor-exit(r0);     // Catch: Throwable -> L7
        return false;
    L15:
        boolean r2 = this.mImageWallpaper.equals(wallpaperData.getComponent());     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r2;
    L9:
        r1 = this.mWallpaperMap;     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }

    public void setWallpaperDimAmount(float dimAmount) throws RemoteException {
        setWallpaperDimAmountForUid(Binder.getCallingUid(), dimAmount);
    }

    public void setWallpaperDimAmountForUid(int uid, float dimAmount) {
        checkPermission("android.permission.SET_WALLPAPER_DIM_AMOUNT");
        long ident = Binder.clearCallingIdentity();
        List<WallpaperData> pendingColorExtraction = new ArrayList();     // Catch: Throwable -> L41
        Object r6 = this.mLock;     // Catch: Throwable -> L41
        monitor-enter(r6);     // Catch: Throwable -> L41
        int r8 = 0;
        if (this.mCurrentUserId == (-10000)) goto L10;
        int userId = this.mCurrentUserId;     // Catch: Throwable -> L8
    L11:
        WallpaperData wallpaper = this.mWallpaperMap.get(userId);     // Catch: Throwable -> L8
        WallpaperData lockWallpaper = this.mLockWallpaperMap.get(userId);     // Catch: Throwable -> L8
        if (dimAmount != 0.0f) goto L14;
        wallpaper.mUidToDimAmount.remove(uid);     // Catch: Throwable -> L8
    L15:
        final float maxDimAmount = getHighestDimAmountFromMap(wallpaper.mUidToDimAmount);     // Catch: Throwable -> L8
        if (wallpaper.mWallpaperDimAmount != maxDimAmount) goto L20;
        monitor-exit(r6);     // Catch: Throwable -> L8
        Binder.restoreCallingIdentity(ident);
        return;
    L20:
        wallpaper.mWallpaperDimAmount = maxDimAmount;     // Catch: Throwable -> L8
        if (lockWallpaper == null) goto L23;
        lockWallpaper.mWallpaperDimAmount = maxDimAmount;     // Catch: Throwable -> L8
    L23:
        boolean changed = false;
        WallpaperData[] r12 = getActiveWallpapers();     // Catch: Throwable -> L8
        int r13 = r12.length;     // Catch: Throwable -> L8
    L24:
        if (r8 >= r13) goto L33;
        WallpaperData wp = r12[r8];     // Catch: Throwable -> L8
        if (wp == null) goto L31;
        if (wp.connection == null) goto L31;
        wp.connection.forEachDisplayConnector(new WallpaperManagerService$$ExternalSyntheticLambda1(maxDimAmount));     // Catch: Throwable -> L8
        wp.mIsColorExtractedFromDim = true;     // Catch: Throwable -> L8
        pendingColorExtraction.add(wp);     // Catch: Throwable -> L8
        changed = true;
    L31:
        r8 = r8 + 1;     // Catch: Throwable -> L8
        userId = userId;
        goto L24
    L33:
        if (changed == false) goto L35;
        saveSettingsLocked(wallpaper.userId);     // Catch: Throwable -> L8
    L35:
        monitor-exit(r6);     // Catch: Throwable -> L8
        Iterator<WallpaperData> r0 = pendingColorExtraction.iterator();     // Catch: Throwable -> L41
    L38:
        if (r0.hasNext() == false) goto L43;
        notifyWallpaperColorsChanged(r0.next());     // Catch: Throwable -> L41
        goto L38
    L43:
        Binder.restoreCallingIdentity(ident);
        return;
    L14:
        wallpaper.mUidToDimAmount.put(uid, Float.valueOf(dimAmount));     // Catch: Throwable -> L8
        goto L15
    L10:
        userId = 0;
    L8:
        th = move-exception;
        throw th;     // Catch: Throwable -> L41
    L41:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    }

    private static /* synthetic */ void lambda$setWallpaperDimAmountForUid$13(float maxDimAmount, DisplayConnector connector) {
        if (connector.mEngine == null) goto L11;
        connector.mEngine.applyDimming(maxDimAmount);     // Catch: RemoteException -> L6
        return;
    L6:
        e = move-exception;
        Slog.w(TAG, "Can't apply dimming on wallpaper display connector", e);
        return;
    }

    public float getWallpaperDimAmount() {
        checkPermission("android.permission.SET_WALLPAPER_DIM_AMOUNT");
        Object r0 = this.mLock;
        monitor-enter(r0);
        WallpaperData data = this.mWallpaperMap.get(this.mCurrentUserId);     // Catch: Throwable -> L12
        if (data != null) goto L14;
        data = this.mWallpaperMap.get(0);     // Catch: Throwable -> L12
        if (data != null) goto L14;
        Slog.e(TAG, "getWallpaperDimAmount: wallpaperData is null");     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return 0.0f;
    L14:
        float r2 = data.mWallpaperDimAmount;     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r2;
    L12:
        th = move-exception;
        throw th;
    }

    private float getHighestDimAmountFromMap(SparseArray<Float> uidToDimAmountMap) {
        float maxDimAmount = 0.0f;
        int i = 0;
    L4:
        if (i >= uidToDimAmountMap.size()) goto L7;
        maxDimAmount = Math.max(maxDimAmount, uidToDimAmountMap.valueAt(i).floatValue());
        i = i + 1;
        goto L4
    L7:
        return maxDimAmount;
    }

    public WallpaperColors getWallpaperColors(int which, int userId, int displayId) throws RemoteException {
        boolean shouldExtract = true;
        if (which == 2) goto L8;
        if (which == 1) goto L8;
        throw new IllegalArgumentException("which should be either FLAG_LOCK or FLAG_SYSTEM");
    L8:
        int userId2 = ActivityManager.handleIncomingUser(Binder.getCallingPid(), Binder.getCallingUid(), userId, false, true, "getWallpaperColors", null);
        WallpaperData wallpaperData = null;
        Object r3 = this.mLock;
        monitor-enter(r3);
        if (which == 2) goto L34;
    L14:
        if (wallpaperData != null) goto L16;
        wallpaperData = findWallpaperAtDisplay(userId2, displayId);     // Catch: Throwable -> L12
    L16:
        if (wallpaperData != null) goto L21;
        monitor-exit(r3);     // Catch: Throwable -> L12
        return null;
    L21:
        if (wallpaperData.primaryColors == null) goto L27;
        if (wallpaperData.mIsColorExtractedFromDim == true) goto L27;
        shouldExtract = false;
    L27:
        monitor-exit(r3);     // Catch: Throwable -> L12
        if (shouldExtract == false) goto L31;
        extractColors(wallpaperData);
    L31:
        return getAdjustedWallpaperColorsOnDimming(wallpaperData);
    L34:
        wallpaperData = this.mLockWallpaperMap.get(userId2);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    WallpaperColors getAdjustedWallpaperColorsOnDimming(WallpaperData wallpaperData) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        WallpaperColors wallpaperColors = wallpaperData.primaryColors;     // Catch: Throwable -> L13
        if (wallpaperColors != null) goto L7;
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return wallpaperColors;
    L7:
        if ((wallpaperColors.getColorHints() & 4) != 0) goto L15;
        if (wallpaperData.mWallpaperDimAmount == 0.0f) goto L15;
        int adjustedColorHints = (wallpaperColors.getColorHints() & (-2)) & (-3);     // Catch: Throwable -> L13
        WallpaperColors r3 = new WallpaperColors(wallpaperColors.getPrimaryColor(), wallpaperColors.getSecondaryColor(), wallpaperColors.getTertiaryColor(), adjustedColorHints);     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        return r3;
    L13:
        th = move-exception;
        throw th;
    }

    private WallpaperData findWallpaperAtDisplay(int userId, int displayId) {
        if (this.mFallbackWallpaper == null) goto L11;
        if (this.mFallbackWallpaper.connection == null) goto L11;
        if (this.mFallbackWallpaper.connection.containsDisplay(displayId) == false) goto L11;
        return this.mFallbackWallpaper;
    L11:
        return this.mWallpaperMap.get(userId);
    }

    public ParcelFileDescriptor setWallpaper(String name, String callingPackage, int[] screenOrientations, List<Rect> crops, boolean allowBackup, Bundle extras, int which, IWallpaperManagerCallback completion, int userId) {
        if (DEBUG == false) goto L9;
        StringBuilder r9 = new StringBuilder();
        r9.append("setWallpaper: name = ");
        r9.append(name);
        r9.append(", callingPackage = ");
        r9.append(callingPackage);
        r9.append(", screenOrientations = ");
        if (screenOrientations != null) goto L7;
        List<Integer> r10 = null;
    L8:
        r9.append(r10);
        r9.append(", crops = ");
        r9.append(crops);
        r9.append(", allowBackup = ");
        r9.append(allowBackup);
        Slog.d(TAG, r9.toString());
        goto L9
    L7:
        r10 = Arrays.stream(screenOrientations).boxed().toList();
    L9:
        int userId2 = ActivityManager.handleIncomingUser(IWallpaperManager.Stub.getCallingPid(), IWallpaperManager.Stub.getCallingUid(), userId, false, true, "changing wallpaper", null);
        checkPermission("android.permission.SET_WALLPAPER");
        this.mIExt.traceSetWallpaper(name, which, userId2);
        if ((which & 3) != 0) goto L12;
        Slog.e(TAG, "Must specify a valid wallpaper category to set");
        throw new IllegalArgumentException("Must specify a valid wallpaper category to set");
    L12:
        if (isWallpaperSupported(callingPackage) == false) goto L69;
        if (isSetWallpaperAllowed(callingPackage) == false) goto L69;
        SparseArray<Rect> cropMap = getCropMap(screenOrientations, crops);
        Rect cropHint = new Rect();
        boolean fromForegroundApp = isFromForegroundApp(callingPackage);
        Object r13 = this.mLock;
        monitor-enter(r13);
    L21:
        th = th;
    L66:
        monitor-exit(r13);     // Catch: Throwable -> L62
        throw th;
    L19:
        if (DEBUG == false) goto L23;
        Slog.v(TAG, "setWallpaper which=0x" + Integer.toHexString(which));     // Catch: Throwable -> L21
    L23:
        WallpaperData originalSystemWallpaper = this.mWallpaperMap.get(userId2);     // Catch: Throwable -> L21
        if (originalSystemWallpaper != null) goto L26;
    L28:
        boolean r0 = false;
    L29:
        boolean systemIsStatic = r0;
        if (this.mLockWallpaperMap.get(userId2) != null) goto L32;
        boolean r1 = true;
    L33:
        boolean systemIsBoth = r1;
        if (which != 1) goto L38;
        if (systemIsStatic == false) goto L38;
        if (systemIsBoth == false) goto L38;
        Slog.i(TAG, "Migrating current wallpaper to be lock-only before updating system wallpaper");     // Catch: Throwable -> L21
        migrateStaticSystemToLockWallpaperLocked(userId2);     // Catch: Throwable -> L21
    L38:
        WallpaperData wallpaper = getWallpaperSafeLocked(userId2, which);     // Catch: Throwable -> L21
        if (this.mPendingMigrationViaStatic == null) goto L41;
        Slog.w(TAG, "Starting new static wp migration before previous migration finished");     // Catch: Throwable -> L21
    L41:
        this.mPendingMigrationViaStatic = new WallpaperDestinationChangeHandler(this, wallpaper);     // Catch: Throwable -> L21
        long ident = Binder.clearCallingIdentity();     // Catch: Throwable -> L21
        ParcelFileDescriptor pfd = updateWallpaperBitmapLocked(name, wallpaper, extras);     // Catch: Throwable -> L55
        if (pfd == null) goto L59;
        wallpaper.imageWallpaperPending = true;     // Catch: Throwable -> L55
        wallpaper.mSystemWasBoth = systemIsBoth;     // Catch: Throwable -> L53
        wallpaper.mWhich = which;     // Catch: Throwable -> L53
        wallpaper.setComplete = completion;     // Catch: Throwable -> L51
        wallpaper.fromForegroundApp = fromForegroundApp;     // Catch: Throwable -> L51
        wallpaper.cropHint.set(cropHint);     // Catch: Throwable -> L51
        wallpaper.mCropHints = cropMap;     // Catch: Throwable -> L51
        wallpaper.mSampleSize = 1.0f;     // Catch: Throwable -> L51
        wallpaper.mOrientationWhenSet = this.mWallpaperDisplayHelper.getDefaultDisplayCurrentOrientation();     // Catch: Throwable -> L51
        wallpaper.allowBackup = allowBackup;     // Catch: Throwable -> L51
        wallpaper.mWallpaperDimAmount = getWallpaperDimAmount();     // Catch: Throwable -> L51
        wallpaper.callingPackage = callingPackage;     // Catch: Throwable -> L51
    L51:
        th = th;
    L64:
        Binder.restoreCallingIdentity(ident);     // Catch: Throwable -> L62
        throw th;     // Catch: Throwable -> L62
    L53:
        th = th;
    L59:
        Binder.restoreCallingIdentity(ident);     // Catch: Throwable -> L62
        monitor-exit(r13);     // Catch: Throwable -> L62
        return pfd;
    L55:
        th = th;
        goto L64
    L32:
        r1 = false;
        goto L33
    L26:
        if (this.mImageWallpaper.equals(originalSystemWallpaper.getComponent()) == false) goto L28;
        r0 = true;
    L62:
        th = th;
    L69:
        return null;
    }

    private SparseArray<Rect> getCropMap(int[] screenOrientations, List<Rect> crops) {
        boolean r0 = false;
        if (crops != null) goto L5;
        boolean r2 = true;
    L6:
        if (screenOrientations != null) goto L9;
        r0 = true;
    L9:
        if ((r0 ^ r2) == true) goto L39;
        if (crops != null) goto L12;
    L13:
        SparseArray<Rect> cropMap = new SparseArray();
        if (crops != null) goto L16;
    L37:
        return cropMap;
    L16:
        if (crops.isEmpty() == true) goto L37;
        int i = 0;
    L19:
        if (i >= crops.size()) goto L37;
        Rect crop = crops.get(i);
        int width = crop.width();
        int height = crop.height();
        if (width < 0) goto L36;
        if (height < 0) goto L36;
        if (crop.left < 0) goto L36;
        if (crop.top < 0) goto L36;
        int orientation = screenOrientations[i];
        if (orientation != (-1)) goto L34;
        if (crops.size() <= 1) goto L34;
        throw new IllegalArgumentException("Invalid crops supplied: the UNKNOWNscreen orientation should only be used in a singleton map");
    L34:
        cropMap.put(orientation, crop);
        i = i + 1;
    L36:
        throw new IllegalArgumentException("Invalid crop rect supplied: " + crop);
    L12:
        if (crops.size() == screenOrientations.length) goto L13;
    L39:
        throw new IllegalArgumentException("Illegal crops/orientations lists: must both be null, or both the same size");
    L5:
        r2 = false;
        goto L6
    }

    private void migrateStaticSystemToLockWallpaperLocked(int userId) {
        WallpaperData sysWP = this.mWallpaperMap.get(userId);
        if (sysWP == null) goto L5;
        WallpaperData lockWP = new WallpaperData(userId, 2);
        lockWP.wallpaperId = sysWP.wallpaperId;
        lockWP.cropHint.set(sysWP.cropHint);
        if (sysWP.mCropHints == null) goto L11;
        lockWP.mCropHints = sysWP.mCropHints.clone();
    L11:
        lockWP.allowBackup = sysWP.allowBackup;
        lockWP.primaryColors = sysWP.primaryColors;
        lockWP.mWallpaperDimAmount = sysWP.mWallpaperDimAmount;
        lockWP.mWhich = 2;
        lockWP.connection = sysWP.connection;
    L15:
        e = move-exception;
        Slog.w(TAG, "Couldn't migrate system wallpaper: " + e.getMessage());
        clearWallpaperBitmaps(lockWP);
        return;
    L13:
        if (sysWP.getWallpaperFile().exists() == false) goto L18;
        Os.rename(sysWP.getWallpaperFile().getAbsolutePath(), lockWP.getWallpaperFile().getAbsolutePath());     // Catch: ErrnoException -> L15
    L18:
        if (sysWP.getCropFile().exists() == false) goto L20;
        Os.rename(sysWP.getCropFile().getAbsolutePath(), lockWP.getCropFile().getAbsolutePath());     // Catch: ErrnoException -> L15
    L20:
        this.mLockWallpaperMap.put(userId, lockWP);     // Catch: ErrnoException -> L15
        SELinux.restorecon(lockWP.getWallpaperFile());     // Catch: ErrnoException -> L15
        this.mLastLockWallpaper = lockWP;     // Catch: ErrnoException -> L15
        return;
    L5:
        if (DEBUG == false) goto L26;
        Slog.i(TAG, "No system wallpaper? Not tracking for lock-only");
        return;
    }

    ParcelFileDescriptor updateWallpaperBitmapLocked(String name, WallpaperData wallpaper, Bundle extras) {
        if (name != null) goto L22;
        name = "";
    L22:
        File dir = WallpaperUtils.getWallpaperDir(wallpaper.userId);     // Catch: FileNotFoundException -> L9
        if (dir.exists() == true) goto L11;
        dir.mkdir();     // Catch: FileNotFoundException -> L9
        FileUtils.setPermissions(dir.getPath(), 505, -1, -1);     // Catch: FileNotFoundException -> L9
    L11:
        ParcelFileDescriptor fd = ParcelFileDescriptor.open(wallpaper.getWallpaperFile(), 1006632960);     // Catch: FileNotFoundException -> L9
        if (SELinux.restorecon(wallpaper.getWallpaperFile()) == true) goto L15;
        Slog.w(TAG, "restorecon failed for wallpaper file: " + wallpaper.getWallpaperFile().getPath());     // Catch: FileNotFoundException -> L9
        return null;
    L15:
        wallpaper.name = name;     // Catch: FileNotFoundException -> L9
        wallpaper.wallpaperId = WallpaperUtils.makeWallpaperIdLocked();     // Catch: FileNotFoundException -> L9
        if (extras == null) goto L18;
        extras.putInt("android.service.wallpaper.extra.ID", wallpaper.wallpaperId);     // Catch: FileNotFoundException -> L9
    L18:
        wallpaper.primaryColors = null;     // Catch: FileNotFoundException -> L9
        Slog.v(TAG, "updateWallpaperBitmapLocked() : id=" + wallpaper.wallpaperId + " name=" + name + " file=" + wallpaper.getWallpaperFile().getName());     // Catch: FileNotFoundException -> L9
        return fd;
    L9:
        e = move-exception;
        Slog.w(TAG, "Error setting wallpaper", e);
        return null;
    }

    public void setWallpaperComponentChecked(WallpaperDescription description, String callingPackage, int which, int userId) {
        if (isWallpaperSupported(callingPackage) == true) goto L5;
        return;
    L5:
        if (isSetWallpaperAllowed(callingPackage) == false) goto L9;
        setWallpaperDescription(description, callingPackage, which, userId);
        return;
    }

    public void setWallpaperComponent(ComponentName name) {
        setWallpaperComponent(name, "", UserHandle.getCallingUserId(), 1);
    }

    boolean setWallpaperComponent(ComponentName name, String callingPackage, int which, int userId) {
        return setWallpaperDescription(new WallpaperDescription.Builder().setComponent(name).build(), callingPackage, which, userId);
    }

    boolean setWallpaperDescription(WallpaperDescription description, String callingPackage, int which, int userId) {
        boolean fromForeground = isFromForegroundApp(callingPackage);
        return setWallpaperDescriptionInternal(description, which, userId, false, fromForeground, null);
    }

    private boolean setWallpaperDescriptionInternal(WallpaperDescription description, int which, int userIdIn, boolean force, boolean fromForeground, IRemoteCallback reply) {
        ComponentName name = description.getComponent();
        if (DEBUG == false) goto L5;
        Slog.v(TAG, "Setting new live wallpaper: which=" + which + ", component: " + name);
    L5:
        int userId = ActivityManager.handleIncomingUser(IWallpaperManager.Stub.getCallingPid(), IWallpaperManager.Stub.getCallingUid(), userIdIn, false, true, "changing live wallpaper", null);
        checkPermission("android.permission.SET_WALLPAPER_COMPONENT");
        IExtWallpaperManagerService r0 = this.mIExt;
        if (name == null) goto L8;
        String r2 = name.flattenToString();
    L9:
        r0.traceSetWallpaperDescriptionInternal(r2, which, userId, force);
        boolean shouldNotifyColors = false;
        Object r14 = this.mLock;
        monitor-enter(r14);
        Slog.v(TAG, "setWallpaperComponent name=" + name + ", which = " + which);     // Catch: Throwable -> L22
        WallpaperData originalSystemWallpaper = this.mWallpaperMap.get(userId);     // Catch: Throwable -> L22
        if (originalSystemWallpaper == null) goto L106;
        boolean systemIsStatic = this.mImageWallpaper.equals(originalSystemWallpaper.getComponent());     // Catch: Throwable -> L22
        if (this.mLockWallpaperMap.get(userId) != null) goto L16;
        boolean r1 = true;
    L17:
        boolean systemIsBoth = r1;
        if (which != 1) goto L24;
        if (systemIsBoth == false) goto L24;
        if (systemIsStatic == false) goto L24;
        Slog.i(TAG, "Migrating current wallpaper to be lock-only beforeupdating system wallpaper");     // Catch: Throwable -> L22
        migrateStaticSystemToLockWallpaperLocked(userId);     // Catch: Throwable -> L22
    L24:
        WallpaperData newWallpaper = getWallpaperSafeLocked(userId, which);     // Catch: Throwable -> L22
        long ident = Binder.clearCallingIdentity();     // Catch: Throwable -> L22
    L101:
        th = th;
    L103:
        Binder.restoreCallingIdentity(ident);     // Catch: Throwable -> L97
        throw th;     // Catch: Throwable -> L97
    L26:
        if (newWallpaper.mWhich == which) goto L28;
        boolean whichChange = true;
    L29:
        WallpaperData.BindSource bindSource = newWallpaper.mBindSource;     // Catch: Throwable -> L101
        newWallpaper.imageWallpaperPending = false;     // Catch: Throwable -> L101
        newWallpaper.mWhich = which;     // Catch: Throwable -> L101
        newWallpaper.mSystemWasBoth = systemIsBoth;     // Catch: Throwable -> L101
        newWallpaper.fromForegroundApp = fromForeground;     // Catch: Throwable -> L99
        WallpaperDestinationChangeHandler liveSync = new WallpaperDestinationChangeHandler(this, newWallpaper);     // Catch: Throwable -> L99
        boolean same = changingToSame(description, newWallpaper.connection, newWallpaper.getDescription());     // Catch: Throwable -> L36
        if (name != null) goto L38;
        WallpaperData.BindSource r3 = WallpaperData.BindSource.SET_LIVE_TO_CLEAR;     // Catch: Throwable -> L36
    L39:
        newWallpaper.mBindSource = r3;     // Catch: Throwable -> L36
        if (force == true) goto L58;
        if (same == false) goto L46;
        if (systemIsBoth == false) goto L46;
        boolean r4 = true;
        if (which != 1) goto L48;
    L59:
        boolean forceRebind = r4;
    L60:
        boolean r22 = r4;
        boolean r20 = false;
        boolean bindSuccess = bindWallpaperDescriptionLocked(description, forceRebind, true, newWallpaper, reply);     // Catch: Throwable -> L36
        if (bindSuccess == false) goto L90;
        if (same == true) goto L64;
        newWallpaper.primaryColors = null;     // Catch: Throwable -> L36
    L67:
        boolean lockBitmapCleared = false;
        if (this.mImageWallpaper.equals(newWallpaper.getComponent()) == true) goto L73;
        clearWallpaperBitmaps(newWallpaper);     // Catch: Throwable -> L36
        if (newWallpaper.mWhich != 2) goto L72;
        r20 = r22;
    L72:
        lockBitmapCleared = r20;
    L73:
        newWallpaper.wallpaperId = WallpaperUtils.makeWallpaperIdLocked();     // Catch: Throwable -> L36
        notifyCallbacksLocked(newWallpaper);     // Catch: Throwable -> L36
        notifyWallpaperChanged(newWallpaper);     // Catch: Throwable -> L36
        shouldNotifyColors = true;
        if (which == 3) goto L76;
    L87:
        liveSync.complete();     // Catch: Throwable -> L36
        goto L90
    L76:
        if (DEBUG == false) goto L78;
        Slog.v(TAG, "Lock screen wallpaper changed to same as home");     // Catch: Throwable -> L36
    L78:
        WallpaperData lockedWallpaper = this.mLockWallpaperMap.get(newWallpaper.userId);     // Catch: Throwable -> L36
        if (lockedWallpaper == null) goto L83;
        detachWallpaperLocked(lockedWallpaper);     // Catch: Throwable -> L36
        if (same == false) goto L83;
        updateEngineFlags(newWallpaper);     // Catch: Throwable -> L36
    L83:
        if (lockBitmapCleared == true) goto L86;
        clearWallpaperBitmaps(newWallpaper.userId, 2);     // Catch: Throwable -> L36
    L86:
        this.mLockWallpaperMap.remove(newWallpaper.userId);     // Catch: Throwable -> L36
        goto L87
    L64:
        if (newWallpaper.connection == null) goto L67;
        newWallpaper.connection.forEachDisplayConnector(new WallpaperManagerService$$ExternalSyntheticLambda21());     // Catch: Throwable -> L36
    L90:
        Binder.restoreCallingIdentity(ident);     // Catch: Throwable -> L97
        monitor-exit(r14);     // Catch: Throwable -> L97
        if (shouldNotifyColors == false) goto L94;
        notifyWallpaperColorsChanged(newWallpaper);
    L94:
        if (0 == 0) goto L96;
        notifyWallpaperColorsChanged(newWallpaper, 2);
    L96:
        return bindSuccess;
    L48:
        if (newWallpaper.getComponent() == null) goto L50;
        String r5 = newWallpaper.getComponent().getPackageName();     // Catch: Throwable -> L36
    L52:
        if (Utils.isXtsPkg(r5) == true) goto L57;
        if (whichChange == true) goto L59;
        if (bindSource != newWallpaper.mBindSource) goto L59;
    L57:
        forceRebind = false;
        goto L60
    L50:
        r5 = null;
    L46:
        r4 = true;
        goto L48
    L58:
        r4 = true;
        goto L59
    L38:
        r3 = WallpaperData.BindSource.SET_LIVE;     // Catch: Throwable -> L36
    L36:
        th = th;
    L99:
        th = th;
        goto L103
    L28:
        whichChange = false;
        goto L29
    L16:
        r1 = false;
        goto L17
    L106:
        throw new IllegalStateException("Wallpaper not yet initialized for user " + userId);     // Catch: Throwable -> L97
    L22:
        th = th;
    L107:
        monitor-exit(r14);     // Catch: Throwable -> L97
        throw th;
    L97:
        th = th;
        goto L107
    L8:
        r2 = null;
        goto L9
    }

    private static /* synthetic */ void lambda$setWallpaperDescriptionInternal$14(DisplayConnector displayConnector) {
    L6:
        e = move-exception;
        Slog.w(TAG, "Error sending apply message to wallpaper", e);
        return;
    L3:
        if (displayConnector.mEngine == null) goto L13;
        displayConnector.mEngine.dispatchWallpaperCommand("android.wallpaper.reapply", 0, 0, 0, null);     // Catch: RemoteException -> L6
        return;
    }

    private boolean isDefaultComponent(ComponentName name) {
        if (name != null) goto L4;
    L7:
        return true;
    L4:
        if (name.equals(this.mDefaultWallpaperComponent) == true) goto L7;
        return false;
    }

    private boolean changingToSame(ComponentName newComponentName, WallpaperConnection currentConnection, ComponentName currentComponentName) {
        if (currentConnection != null) goto L4;
        return false;
    L4:
        if (isDefaultComponent(newComponentName) == true) goto L6;
    L11:
        if (currentComponentName != null) goto L13;
        return false;
    L13:
        if (currentComponentName.equals(newComponentName) == true) goto L15;
        return false;
    L15:
        if (DEBUG == false) goto L17;
        Slog.v(TAG, "same wallpaper");
    L17:
        return true;
    L6:
        if (isDefaultComponent(currentComponentName) == false) goto L11;
        if (DEBUG == false) goto L10;
        Slog.v(TAG, "changingToSame: still using default");
    L10:
        return true;
    }

    private boolean changingToSame(WallpaperDescription newDescription, WallpaperConnection currentConnection, WallpaperDescription currentDescription) {
        if (currentConnection != null) goto L6;
        return false;
    L6:
        if (isDefaultComponent(newDescription.getComponent()) == false) goto L14;
        if (isDefaultComponent(currentDescription.getComponent()) == false) goto L14;
        if (DEBUG == false) goto L12;
        Slog.v(TAG, "changingToSame: still using default");
    L12:
        return true;
    L14:
        if (newDescription.equals(currentDescription) == true) goto L16;
        return false;
    L16:
        if (DEBUG == false) goto L18;
        Slog.v(TAG, "same wallpaper");
    L18:
        return true;
    }

    boolean bindWallpaperComponentLocked(ComponentName componentName, boolean force, boolean fromUser, WallpaperData wallpaper, IRemoteCallback reply) {
        return bindWallpaperDescriptionLocked(new WallpaperDescription.Builder().setComponent(componentName).build(), force, fromUser, wallpaper, reply);
    }

    /* JADX WARN: Multi-variable type inference failed */
    boolean bindWallpaperDescriptionLocked(WallpaperDescription r28, boolean r29, boolean r30, WallpaperData r31, IRemoteCallback r32) {
        ComponentName r4 = r28.getComponent();
        Slog.v(TAG, "bindWallpaperComponentLocked: componentName=" + r4);
        IExtWallpaperManagerService r0 = this.mIExt;
        if (r4 == null) goto L5;
        String r7 = r4.flattenToString();
    L6:
        r0.traceBindWallpaperComponent(r7, r31.mWhich, r31.userId);
        boolean r8 = false;
        if (r29 == true) goto L11;
        WallpaperDescription r10 = r28;
        if (changingToSame(r10, r31.connection, r31.getDescription()) == false) goto L12;
        Object[] r1 = true;
    L14:
        if (r1 == true) goto L173;
        TimingsTraceAndSlog r6 = new TimingsTraceAndSlog(TAG);
        r6.traceBegin("WPMS.bindWallpaperComponentLocked-" + r4);
        if (r4 == null) goto L179;
    L169:
        int r11 = r31.userId;     // Catch: Throwable -> L85 RemoteException -> L87
        ServiceInfo r2 = this.mIPackageManager.getServiceInfo(r4, 4224, r11);     // Catch: Throwable -> L85 RemoteException -> L87
        if (r2 != null) goto L43;
        Slog.w(TAG, "Attempted wallpaper " + r4 + " is unavailable");     // Catch: Throwable -> L38 RemoteException -> L40
        r6.traceEnd();
        return false;
    L43:
        if ("android.permission.BIND_WALLPAPER".equals(r2.permission) == true) goto L51;
        String r3 = "Selected service does not have android.permission.BIND_WALLPAPER: " + r4;     // Catch: Throwable -> L38 RemoteException -> L40
        if (r30 == true) goto L50;
        Slog.w(TAG, r3);     // Catch: Throwable -> L38 RemoteException -> L40
        r6.traceEnd();
        return false;
    L50:
        throw new SecurityException(r3);     // Catch: Throwable -> L38 RemoteException -> L40
    L51:
        WallpaperInfo r17 = null;
        Intent r5 = new Intent("android.service.wallpaper.WallpaperService");     // Catch: Throwable -> L85 RemoteException -> L87
        if (r4 != null) goto L171;
    L123:
        TimingsTraceAndSlog r20 = r6;
        boolean r16 = false;
        ServiceInfo r9 = r2;
        WallpaperInfo r12 = null;
    L124:
        if (r12 != null) goto L126;
    L138:
        PendingIntent r13 = PendingIntent.getActivityAsUser(this.mContext, 0, Intent.createChooser(new Intent("android.intent.action.SET_WALLPAPER"), this.mContext.getText(R.string.config_customAdbWifiNetworkConfirmationComponent)), 67108864, ActivityOptions.makeBasic().setPendingIntentCreatorBackgroundActivityStartMode(2).toBundle(), UserHandle.of(r11));     // Catch: Throwable -> L77 RemoteException -> L79
        if (DEBUG == false) goto L141;
        Slog.v(TAG, "Binding to:" + r4);     // Catch: Throwable -> L77 RemoteException -> L79
    L141:
        int r14 = this.mIPackageManager.getPackageUid(r4.getPackageName(), 268435456, r31.userId);     // Catch: Throwable -> L77 RemoteException -> L79
        WallpaperConnection r15 = new WallpaperConnection(this, r12, r31, r14);     // Catch: Throwable -> L77 RemoteException -> L79
        r5.setComponent(r4);     // Catch: Throwable -> L77 RemoteException -> L79
        r5.putExtra("android.intent.extra.client_label", 17042361);     // Catch: Throwable -> L77 RemoteException -> L79
        r5.putExtra("android.intent.extra.client_intent", r13);     // Catch: Throwable -> L77 RemoteException -> L79
        if (this.mContext.getResources().getBoolean(R.bool.config_windowShowCircularMask) == false) goto L144;
        int r24 = 570429441 | 524288;     // Catch: Throwable -> L77 RemoteException -> L79
    L146:
        if (this.mContext.bindServiceAsUser(r5, r15, r24, getHandlerForBindingWallpaperLocked(), new UserHandle(r11)) == true) goto L154;
        String r18 = "Unable to bind service: " + r4;     // Catch: Throwable -> L77 RemoteException -> L79
        if (r30 == true) goto L153;
        Slog.w(TAG, r18);     // Catch: Throwable -> L77 RemoteException -> L79
        r20.traceEnd();
        return false;
    L153:
        throw new IllegalArgumentException(r18);     // Catch: Throwable -> L77 RemoteException -> L79
    L154:
        maybeDetachLastWallpapers(r31);     // Catch: Throwable -> L77 RemoteException -> L79
        r31.setDescription(r10);     // Catch: Throwable -> L77 RemoteException -> L79
        r31.connection = r15;     // Catch: Throwable -> L77 RemoteException -> L79
        r15.mReply = r32;     // Catch: Throwable -> L77 RemoteException -> L79
        updateCurrentWallpapers(r31);     // Catch: Throwable -> L77 RemoteException -> L79
        updateFallbackConnection(r14);     // Catch: Throwable -> L77 RemoteException -> L79
        r20.traceEnd();
        SysOptBridge.getFactory().getSmartScenes().updateWallPaperPackage(r4.getPackageName());
        SysOptBridge.getFactory().getProcessStatusChecker().updateWallpaperPackage(r4.getPackageName());
        return 1;
    L144:
        r24 = 570429441;
        goto L146
    L126:
        if (r12.supportsAmbientMode() == false) goto L138;
        if (this.mIPackageManager.checkPermission("android.permission.AMBIENT_WALLPAPER", r12.getPackageName(), r11) == 0) goto L138;
        if (this.mIPackageManager.hasSystemFeature("android.hardware.type.watch", r16 ? 1 : 0) == true) goto L138;
        String r19 = "Selected service does not have android.permission.AMBIENT_WALLPAPER: " + r4;     // Catch: Throwable -> L77 RemoteException -> L79
        if (r30 == true) goto L137;
        Slog.w(TAG, r19);     // Catch: Throwable -> L77 RemoteException -> L79
        r20.traceEnd();
        return false;
    L137:
        throw new SecurityException(r19);     // Catch: Throwable -> L77 RemoteException -> L79
    L171:
    L111:
        e = e;
        r6 = r6;
    L158:
        String r21 = "Remote exception for " + r4 + "\n" + e;     // Catch: Throwable -> L77
        if (r30 == true) goto L164;
        Slog.w(TAG, r21);     // Catch: Throwable -> L77
        r6.traceEnd();
        return false;
    L164:
        throw new IllegalArgumentException(r21);     // Catch: Throwable -> L77
    L55:
        if (r4.equals(this.mImageWallpaper) == true) goto L123;
        if (this.mFallbackWallpaperComponent != null) goto L59;
    L62:
        Intent r110 = r5;
    L64:
        r9 = r2;
        ParceledListSlice r22 = this.mIPackageManager.queryIntentServices(r110, r110.resolveTypeIfNeeded(this.mContext.getContentResolver()), 128, r11);     // Catch: Throwable -> L85 RemoteException -> L111
        r11 = r11;
        List r23 = r22.getList();     // Catch: Throwable -> L85 RemoteException -> L111
        int r111 = 0;
    L66:
        if (r111 >= r23.size()) goto L113;
        ServiceInfo r25 = ((ResolveInfo) r23.get(r111)).serviceInfo;     // Catch: Throwable -> L85 RemoteException -> L111
        r16 = r8;
        if (r25.name.equals(r9.name) == false) goto L168;
        if (r25.packageName.equals(r9.packageName) == false) goto L168;
        r20 = r6;
        r17 = new WallpaperInfo(this.mContext, (ResolveInfo) r23.get(r111));     // Catch: Throwable -> L77 RemoteException -> L79 IOException -> L81 XmlPullParserException -> L83
    L114:
        if (r17 != null) goto L122;
        String r26 = "Selected service is not a wallpaper: " + r4;     // Catch: Throwable -> L77 RemoteException -> L79
        if (r30 == true) goto L121;
        Slog.w(TAG, r26);     // Catch: Throwable -> L77 RemoteException -> L79
        r20.traceEnd();
        return r16;
    L121:
        throw new SecurityException(r26);     // Catch: Throwable -> L77 RemoteException -> L79
    L122:
        r5 = r110;
        r12 = r17;
        goto L124
    L81:
        e = e;
    L95:
        if (r30 == true) goto L100;
        Slog.w(TAG, e);     // Catch: Throwable -> L77 RemoteException -> L79
        r20.traceEnd();
        return r16;
    L100:
        throw new IllegalArgumentException(e);     // Catch: Throwable -> L77 RemoteException -> L79
    L83:
        e = e;
    L102:
        if (r30 == true) goto L107;
        Slog.w(TAG, e);     // Catch: Throwable -> L77 RemoteException -> L79
        r20.traceEnd();
        return r16;
    L107:
        throw new IllegalArgumentException(e);     // Catch: Throwable -> L77 RemoteException -> L79
    L90:
        e = e;
        r20 = r6;
    L92:
        e = e;
        r20 = r6;
    L168:
        r111 = r111 + 1;     // Catch: Throwable -> L77 RemoteException -> L79
        r8 = r16;
        r6 = r6;
    L79:
        e = e;
        goto L158
    L113:
        r20 = r6;
        r16 = r8;
        goto L114
    L59:
        if (r4.equals(this.mFallbackWallpaperComponent) == false) goto L62;
        r110 = new Intent().setComponent(this.mFallbackWallpaperComponent);     // Catch: Throwable -> L38 RemoteException -> L40
    L40:
        e = e;
        r6 = r6;
    L38:
        th = th;
        TimingsTraceAndSlog r27 = r6;
    L165:
        r27.traceEnd();
        throw th;
    L85:
        th = th;
        r27 = r6;
    L87:
        e = e;
        r6 = r6;
        goto L158
    L179:
        r4 = this.mDefaultWallpaperComponent;     // Catch: Throwable -> L28 RemoteException -> L30
        r10 = r10.toBuilder().setComponent(r4).build();     // Catch: Throwable -> L28 RemoteException -> L30
        goto L169
    L30:
        e = e;
        r6 = r6;
    L28:
        th = th;
        r27 = r6;
    L77:
        th = th;
        goto L165
    L173:
        Slog.v(TAG, "Changing to the same component, ignoring");     // Catch: RemoteException -> L19
        if (r32 == null) goto L23;
        r32.sendResult(null);     // Catch: RemoteException -> L19
    L23:
        return true;
    L19:
        e = move-exception;
        Slog.e(TAG, "Failed to send callback", e);
    L12:
        r1 = false;
        goto L14
    L11:
        r10 = r28;
        goto L12
    L5:
        r7 = null;
        goto L6
    }

    private Handler getHandlerForBindingWallpaperLocked() {
        if (this.mInitialUserSwitch == false) goto L7;
        return this.mContext.getMainThreadHandler();
    L7:
        if (this.mHandlerThread != null) goto L10;
        this.mHandlerThread = new ServiceThread(TAG, -2, true);
        this.mHandlerThread.start();
    L10:
        return this.mHandlerThread.getThreadHandler();
    }

    private void updateCurrentWallpapers(WallpaperData newWallpaper) {
        if (newWallpaper.userId == this.mCurrentUserId) goto L5;
        return;
    L5:
        if (newWallpaper.equals(this.mFallbackWallpaper) == false) goto L8;
        return;
    L8:
        if (newWallpaper.mWhich != 3) goto L11;
        this.mLastWallpaper = newWallpaper;
        this.mLastLockWallpaper = null;
        return;
    L11:
        if (newWallpaper.mWhich != 1) goto L14;
        this.mLastWallpaper = newWallpaper;
        return;
    L14:
        if (newWallpaper.mWhich != 2) goto L20;
        this.mLastLockWallpaper = newWallpaper;
        return;
    }

    private void maybeDetachLastWallpapers(WallpaperData newWallpaper) {
        if (newWallpaper.userId == this.mCurrentUserId) goto L5;
        return;
    L5:
        if (newWallpaper.equals(this.mFallbackWallpaper) == true) goto L28;
        boolean systemWillBecomeLock = true;
        if ((newWallpaper.mWhich & 1) == 0) goto L10;
        boolean homeUpdated = true;
    L12:
        if ((newWallpaper.mWhich & 2) == 0) goto L14;
        boolean lockUpdated = true;
    L16:
        if (newWallpaper.mSystemWasBoth == false) goto L19;
        if (lockUpdated == true) goto L19;
    L20:
        if (homeUpdated == false) goto L23;
        if (systemWillBecomeLock == true) goto L23;
        detachWallpaperLocked(this.mLastWallpaper);
    L23:
        if (lockUpdated == false) goto L27;
        detachWallpaperLocked(this.mLastLockWallpaper);
        return;
    L27:
        return;
    L19:
        systemWillBecomeLock = false;
        goto L20
    L14:
        lockUpdated = false;
        goto L16
    L10:
        homeUpdated = false;
        goto L12
    }

    private void detachWallpaperLocked(final WallpaperData wallpaper) {
        this.mIExt.traceDetachWallpaperLocked(wallpaper);
        if (wallpaper != null) goto L5;
        return;
    L5:
        if (wallpaper.connection != null) goto L7;
        return;
    L7:
        if (DEBUG == false) goto L10;
        Slog.v(TAG, "Detaching wallpaper: " + wallpaper);
    L10:
        if (wallpaper.connection.mReply != null) goto L28;
    L16:
        wallpaper.connection.forEachDisplayConnector(new WallpaperManagerService$$ExternalSyntheticLambda20(wallpaper));
        wallpaper.connection.mService = null;
        WallpaperConnection.m9542$$Nest$fgetmDisplayConnector(wallpaper.connection).clear();
        FgThread.getHandler().removeCallbacks(WallpaperConnection.m9543$$Nest$fgetmResetRunnable(wallpaper.connection));
        this.mContext.getMainThreadHandler().removeCallbacks(WallpaperConnection.m9541$$Nest$fgetmDisconnectRunnable(wallpaper.connection));
        this.mContext.getMainThreadHandler().removeCallbacks(WallpaperConnection.m9544$$Nest$fgetmTryToRebindRunnable(wallpaper.connection));
        this.mContext.unbindService(wallpaper.connection);     // Catch: IllegalArgumentException -> L19
    L21:
        wallpaper.connection = null;
        if (wallpaper != this.mLastWallpaper) goto L25;
        this.mLastWallpaper = null;
    L25:
        if (wallpaper != this.mLastLockWallpaper) goto L34;
        this.mLastLockWallpaper = null;
        return;
    L34:
        return;
    L19:
        e = move-exception;
        Slog.w(TAG, "Error unbinding wallpaper when detaching", e);
        goto L21
    L28:
        wallpaper.connection.mReply.sendResult(null);     // Catch: RemoteException -> L13
    L15:
        wallpaper.connection.mReply = null;
    L13:
        e = move-exception;
        Slog.w(TAG, "Error sending reply to wallpaper before disconnect", e);
        goto L15
    }

    private static /* synthetic */ void lambda$detachWallpaperLocked$15(WallpaperData wallpaper, DisplayConnector connector) {
        connector.disconnectLocked(wallpaper.connection);
    }

    private void updateEngineFlags(final WallpaperData wallpaper) {
        if (wallpaper.connection != null) goto L5;
        return;
    L5:
        wallpaper.connection.forEachDisplayConnector(new WallpaperManagerService$$ExternalSyntheticLambda3(this, wallpaper));
    }

    private /* synthetic */ void lambda$updateEngineFlags$16(WallpaperData wallpaper, DisplayConnector connector) {
        connector.mWhich = wallpaper.mWhich;     // Catch: RemoteException -> L10
        if (connector.mEngine == null) goto L17;
        connector.mEngine.setWallpaperFlags(wallpaper.mWhich);     // Catch: RemoteException -> L10
        WindowManagerInternal r0 = this.mWindowManagerInternal;     // Catch: RemoteException -> L10
        Binder r1 = connector.mToken;     // Catch: RemoteException -> L10
        if ((wallpaper.mWhich & 2) == 0) goto L7;
        boolean r2 = true;
    L8:
        r0.setWallpaperShowWhenLocked(r1, r2);     // Catch: RemoteException -> L10
        return;
    L7:
        r2 = false;
        goto L8
    L17:
        return;
    L10:
        e = move-exception;
        Slog.e(TAG, "Failed to update wallpaper engine flags", e);
    }

    private void attachServiceLocked(final WallpaperConnection conn, final WallpaperData wallpaper) {
        TimingsTraceAndSlog t = new TimingsTraceAndSlog(TAG);
        t.traceBegin("WPMS.attachServiceLocked");
        conn.forEachDisplayConnector(new WallpaperManagerService$$ExternalSyntheticLambda6(conn, wallpaper));
        t.traceEnd();
    }

    private static /* synthetic */ void lambda$attachServiceLocked$17(WallpaperConnection conn, WallpaperData wallpaper, DisplayConnector connector) {
        connector.connectLocked(conn, wallpaper);
    }

    private void notifyCallbacksLocked(WallpaperData wallpaper) {
        int n = wallpaper.callbacks.beginBroadcast();
        int i = 0;
    L3:
        if (i >= n) goto L9;
        wallpaper.callbacks.getBroadcastItem(i).onWallpaperChanged();     // Catch: RemoteException -> L6
    L8:
        i = i + 1;
    L6:
        e = move-exception;
        Slog.w(TAG, "Failed to notify callbacks about wallpaper changes", e);
        goto L8
    L9:
        wallpaper.callbacks.finishBroadcast();
    }

    private void notifyWallpaperChanged(WallpaperData wallpaper) {
        Intent intent = new Intent("android.intent.action.WALLPAPER_CHANGED");
        intent.putExtra("callingPackage", wallpaper.callingPackage);
        intent.putExtra("android.service.wallpaper.extra.FROM_FOREGROUND_APP", wallpaper.fromForegroundApp);
        intent.putExtra("android.service.wallpaper.extra.WHICH_WALLPAPER_CHANGED", wallpaper.mWhich);
        this.mContext.sendBroadcastAsUser(intent, new UserHandle(this.mCurrentUserId));
    }

    private void checkPermission(String permission) {
        if (hasPermission(permission) == false) goto L6;
        return;
    L6:
        throw new SecurityException("Access denied to process: " + Binder.getCallingPid() + ", must have permission " + permission);
    }

    private boolean packageBelongsToUid(String packageName, int uid) {
        int userId = UserHandle.getUserId(uid);
        int packageUid = this.mContext.getPackageManager().getPackageUidAsUser(packageName, userId);     // Catch: PackageManager.NameNotFoundException -> L7
        if (packageUid != uid) goto L11;
        return true;
    L11:
        return false;
    L8:
        return false;
    }

    private void enforcePackageBelongsToUid(String packageName, int uid) {
        if (packageBelongsToUid(packageName, uid) == false) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("Invalid package or package does not belong to uid:" + uid);
    }

    private boolean isFromForegroundApp(final String callingPackage) {
        return ((Boolean) Binder.withCleanCallingIdentity(new WallpaperManagerService$$ExternalSyntheticLambda12(this, callingPackage))).booleanValue();
    }

    private /* synthetic */ Boolean lambda$isFromForegroundApp$18(String callingPackage) throws Exception {
        if (this.mActivityManager.getPackageImportance(callingPackage) != 100) goto L5;
        boolean r0 = true;
    L7:
        return Boolean.valueOf(r0);
    L5:
        r0 = false;
        goto L7
    }

    private void checkCallerIsSystemOrSystemUi() {
        if (Binder.getCallingUid() != Process.myUid()) goto L5;
        return;
    L5:
        if (this.mContext.checkCallingPermission("android.permission.STATUS_BAR_SERVICE") != 0) goto L8;
        return;
    L8:
        throw new SecurityException("Access denied: only system processes can call this");
    }

    public boolean isWallpaperSupported(String callingPackage) {
        int callingUid = Binder.getCallingUid();
        enforcePackageBelongsToUid(callingPackage, callingUid);
        if (this.mAppOpsManager.checkOpNoThrow(48, callingUid, callingPackage) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isSetWallpaperAllowed(String callingPackage) {
        PackageManager pm = this.mContext.getPackageManager();
        String[] uidPackages = pm.getPackagesForUid(Binder.getCallingUid());
        boolean uidMatchPackage = Arrays.asList(uidPackages).contains(callingPackage);
        if (uidMatchPackage == true) goto L6;
        return false;
    L6:
        DevicePolicyManagerInternal dpmi = (DevicePolicyManagerInternal) LocalServices.getService(DevicePolicyManagerInternal.class);
        if (dpmi != null) goto L9;
    L11:
        int callingUserId = UserHandle.getCallingUserId();
        long ident = Binder.clearCallingIdentity();
        UserManagerInternal umi = (UserManagerInternal) LocalServices.getService(UserManagerInternal.class);     // Catch: Throwable -> L15
        boolean r4 = true ^ umi.hasUserRestriction("no_set_wallpaper", callingUserId);
        Binder.restoreCallingIdentity(ident);
        return r4;
    L15:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    L9:
        if (dpmi.isDeviceOrProfileOwnerInCallingUser(callingPackage) == false) goto L11;
        return true;
    }

    public boolean isWallpaperBackupEligible(int which, int userId) {
        if (which != 2) goto L5;
        WallpaperData wallpaper = this.mLockWallpaperMap.get(userId);
    L7:
        if (wallpaper != null) goto L11;
        return false;
    L11:
        return wallpaper.allowBackup;
    L5:
        wallpaper = this.mWallpaperMap.get(userId);
        goto L7
    }

    private void onDisplayAddSystemDecorationsInternal(int displayId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mLastWallpaper != null) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        int useFallbackWallpaperWhich = 0;
        if (DesktopModeHelper.isDeviceEligibleForDesktopExperienceWallpaper(this.mContext) == false) goto L40;
        List<WallpaperData> wallpapers = new ArrayList();     // Catch: Throwable -> L8
        wallpapers.add(this.mLastWallpaper);     // Catch: Throwable -> L8
        if (this.mLastLockWallpaper != null) goto L15;
    L17:
        int i = 0;
    L19:
        if (i >= wallpapers.size()) goto L30;
        WallpaperData wallpaper = wallpapers.get(i);     // Catch: Throwable -> L8
        if (isWallpaperCompatibleForDisplay(displayId, wallpaper.connection) == false) goto L27;
        DisplayConnector connector = wallpaper.connection.getDisplayConnectorOrCreate(displayId);     // Catch: Throwable -> L8
        if (connector == null) goto L25;
        connector.connectLocked(wallpaper.connection, wallpaper);     // Catch: Throwable -> L8
    L28:
        i = i + 1;     // Catch: Throwable -> L8
        goto L19
    L25:
        Slog.w(TAG, "Fail to connect to wallpaper for display id " + displayId + " due to null connector. Use fallback wallpaper.");     // Catch: Throwable -> L8
        useFallbackWallpaperWhich = useFallbackWallpaperWhich | wallpaper.mWhich;     // Catch: Throwable -> L8
        goto L28
    L27:
        useFallbackWallpaperWhich = useFallbackWallpaperWhich | wallpaper.mWhich;     // Catch: Throwable -> L8
        goto L28
    L30:
        if (useFallbackWallpaperWhich == 0) goto L37;
        if (this.mFallbackWallpaper == null) goto L37;
        if (this.mFallbackWallpaper.connection == null) goto L37;
    L49:
        if (this.mFallbackWallpaper != null) goto L51;
    L57:
        Slog.w(TAG, "No wallpaper can be added to the new display");     // Catch: Throwable -> L8
    L58:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L51:
        if (this.mFallbackWallpaper.connection == null) goto L57;
        DisplayConnector connector2 = this.mFallbackWallpaper.connection.getDisplayConnectorOrCreate(displayId);     // Catch: Throwable -> L8
        if (connector2 != null) goto L56;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L56:
        connector2.mWhich = useFallbackWallpaperWhich;     // Catch: Throwable -> L8
        connector2.connectLocked(this.mFallbackWallpaper.connection, this.mFallbackWallpaper);     // Catch: Throwable -> L8
    L37:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L15:
        if (this.mLastWallpaper == this.mLastLockWallpaper) goto L17;
        wallpapers.add(this.mLastLockWallpaper);     // Catch: Throwable -> L8
        goto L17
    L40:
        if (isWallpaperCompatibleForDisplay(displayId, this.mLastWallpaper.connection) == false) goto L49;
        DisplayConnector connector3 = this.mLastWallpaper.connection.getDisplayConnectorOrCreate(displayId);     // Catch: Throwable -> L8
        if (connector3 != null) goto L45;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L45:
        connector3.connectLocked(this.mLastWallpaper.connection, this.mLastWallpaper);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
    }

    private void onDisplayRemovedInternal(int displayId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (DesktopModeHelper.isDeviceEligibleForDesktopExperienceWallpaper(this.mContext) == false) goto L40;
        List<WallpaperData> pendingDisconnectWallpapers = new ArrayList();     // Catch: Throwable -> L13
        if (this.mLastWallpaper == null) goto L16;
        if (this.mLastWallpaper.connection == null) goto L16;
        if (this.mLastWallpaper.connection.containsDisplay(displayId) == false) goto L16;
        pendingDisconnectWallpapers.add(this.mLastWallpaper);     // Catch: Throwable -> L13
    L16:
        if (this.mLastLockWallpaper == null) goto L23;
        if (this.mLastLockWallpaper.connection == null) goto L23;
        if (this.mLastLockWallpaper.connection.containsDisplay(displayId) == false) goto L23;
        pendingDisconnectWallpapers.add(this.mLastLockWallpaper);     // Catch: Throwable -> L13
    L23:
        if (this.mFallbackWallpaper != null) goto L25;
    L29:
        int i = 0;
    L31:
        if (i >= pendingDisconnectWallpapers.size()) goto L61;
        WallpaperData wallpaper = pendingDisconnectWallpapers.get(i);     // Catch: Throwable -> L13
        DisplayConnector displayConnector = wallpaper.connection.getDisplayConnectorOrCreate(displayId);     // Catch: Throwable -> L13
        if (displayConnector == null) goto L34;
        displayConnector.disconnectLocked(wallpaper.connection);     // Catch: Throwable -> L13
        wallpaper.connection.removeDisplayConnector(displayId);     // Catch: Throwable -> L13
        i = i + 1;     // Catch: Throwable -> L13
        goto L31
    L34:
        Slog.w(TAG, "Fail to disconnect wallpaper upon display removes system decorations");     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L61:
        this.mWallpaperDisplayHelper.removeDisplayData(displayId);     // Catch: Throwable -> L13
        int i2 = this.mColorsChangedListeners.size() - 1;     // Catch: Throwable -> L13
    L62:
        if (i2 < 0) goto L65;
        SparseArray<RemoteCallbackList<IWallpaperManagerCallback>> callbacks = this.mColorsChangedListeners.valueAt(i2);     // Catch: Throwable -> L13
        callbacks.delete(displayId);     // Catch: Throwable -> L13
        i2 = i2 - 1;     // Catch: Throwable -> L13
        goto L62
    L65:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L25:
        if (this.mFallbackWallpaper.connection == null) goto L29;
        if (this.mFallbackWallpaper.connection.containsDisplay(displayId) == false) goto L29;
        pendingDisconnectWallpapers.add(this.mFallbackWallpaper);     // Catch: Throwable -> L13
        goto L29
    L40:
        if (this.mLastWallpaper == null) goto L61;
        WallpaperData targetWallpaper = null;
        if (this.mLastWallpaper.connection == null) goto L47;
        if (this.mLastWallpaper.connection.containsDisplay(displayId) == false) goto L47;
        targetWallpaper = this.mLastWallpaper;     // Catch: Throwable -> L13
    L53:
        if (targetWallpaper != null) goto L56;
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L56:
        DisplayConnector connector = targetWallpaper.connection.getDisplayConnectorOrCreate(displayId);     // Catch: Throwable -> L13
        if (connector != null) goto L60;
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L60:
        connector.disconnectLocked(targetWallpaper.connection);     // Catch: Throwable -> L13
        targetWallpaper.connection.removeDisplayConnector(displayId);     // Catch: Throwable -> L13
    L47:
        if (this.mFallbackWallpaper == null) goto L53;
        if (this.mFallbackWallpaper.connection == null) goto L53;
        if (this.mFallbackWallpaper.connection.containsDisplay(displayId) == false) goto L53;
        targetWallpaper = this.mFallbackWallpaper;     // Catch: Throwable -> L13
        goto L53
    }

    void saveSettingsLocked(int userId) {
        TimingsTraceAndSlog t = new TimingsTraceAndSlog(TAG);
        t.traceBegin("WPMS.saveSettingsLocked-" + userId);
        this.mWallpaperDataParser.saveSettingsLocked(userId, this.mWallpaperMap.get(userId), this.mLockWallpaperMap.get(userId));
        t.traceEnd();
    }

    WallpaperData getWallpaperSafeLocked(int userId, int which) {
        if (which != 2) goto L5;
        SparseArray<WallpaperData> whichSet = this.mLockWallpaperMap;
    L6:
        WallpaperData wallpaper = whichSet.get(userId);
        if (wallpaper != null) goto L17;
        if (which != 2) goto L10;
        int whichLoad = 2;
    L11:
        loadSettingsLocked(userId, false, whichLoad);
        WallpaperData wallpaper2 = whichSet.get(userId);
        if (wallpaper2 != null) goto L18;
        if (which != 2) goto L15;
        WallpaperData wallpaper3 = new WallpaperData(userId, 2);
        this.mLockWallpaperMap.put(userId, wallpaper3);
        return wallpaper3;
    L15:
        Slog.wtf(TAG, "Didn't find wallpaper in non-lock case!");
        WallpaperData wallpaper4 = new WallpaperData(userId, 1);
        this.mWallpaperMap.put(userId, wallpaper4);
        return wallpaper4;
    L18:
        return wallpaper2;
    L10:
        whichLoad = 3;
        goto L11
    L17:
        return wallpaper;
    L5:
        whichSet = this.mWallpaperMap;
        goto L6
    }

    private void loadSettingsLocked(int userId, boolean keepDimensionHints, int which) {
        initializeFallbackWallpaper();
        boolean updateLock = true;
        boolean restoreFromOld = !this.mWallpaperMap.contains(userId);
        WallpaperDataParser.WallpaperLoadingResult result = this.mWallpaperDataParser.loadSettingsLocked(userId, keepDimensionHints, restoreFromOld, which);
        if ((which & 1) == 0) goto L5;
        boolean updateSystem = true;
    L7:
        if ((which & 2) != 0) goto L10;
        updateLock = false;
    L10:
        if (updateSystem == false) goto L12;
        this.mWallpaperMap.put(userId, result.getSystemWallpaperData());
    L12:
        if (updateLock == true) goto L14;
        return;
    L14:
        if (result.success() == false) goto L16;
        this.mLockWallpaperMap.put(userId, result.getLockWallpaperData());
        return;
    L16:
        this.mLockWallpaperMap.remove(userId);
        return;
    L5:
        updateSystem = false;
        goto L7
    }

    private void initializeFallbackWallpaper() {
        if (this.mFallbackWallpaper == null) goto L5;
        return;
    L5:
        if (DEBUG == false) goto L7;
        Slog.d(TAG, "Initialize fallback wallpaper");
    L7:
        this.mFallbackWallpaper = new WallpaperData(0, 1);
        this.mFallbackWallpaper.allowBackup = false;
        WallpaperData r1 = this.mFallbackWallpaper;
        r1.wallpaperId = WallpaperUtils.makeWallpaperIdLocked();
        WallpaperData r2 = this.mFallbackWallpaper;
        r2.mBindSource = WallpaperData.BindSource.INITIALIZE_FALLBACK;
        if (this.mFallbackWallpaperComponent != null) goto L10;
        bindWallpaperComponentLocked(this.mDefaultWallpaperComponent, true, false, this.mFallbackWallpaper, null);
        return;
    L10:
        this.mFallbackWallpaper.mWhich = 3;
        bindWallpaperComponentLocked(this.mFallbackWallpaperComponent, true, false, this.mFallbackWallpaper, null);
    }

    public void settingsRestored() {
        if (Binder.getCallingUid() != 1000) goto L21;
        if (DEBUG == false) goto L7;
        Slog.v(TAG, "settingsRestored");
    L7:
        Object r3 = this.mLock;
        monitor-enter(r3);
        loadSettingsLocked(0, false, 3);     // Catch: Throwable -> L17
        WallpaperData wallpaper = this.mWallpaperMap.get(0);     // Catch: Throwable -> L17
        wallpaper.wallpaperId = WallpaperUtils.makeWallpaperIdLocked();     // Catch: Throwable -> L15
        wallpaper.allowBackup = true;     // Catch: Throwable -> L15
        wallpaper.getComponent();     // Catch: Throwable -> L15
        bindWallpaperDescriptionLocked(new WallpaperDescription.Builder().build(), false, false, wallpaper, null);     // Catch: Throwable -> L15
        monitor-exit(r3);     // Catch: Throwable -> L15
        return;
    L15:
        th = th;
    L18:
        monitor-exit(r3);     // Catch: Throwable -> L17
    L17:
        th = th;
        goto L18
    L19:
        throw th;
    L26:
        th = th;
        goto L18
    L21:
        throw new RuntimeException("settingsRestored() can only be called from the system process");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onShellCommand(FileDescriptor in, FileDescriptor out, FileDescriptor err, String[] args, ShellCallback callback, ResultReceiver resultReceiver) {
        new WallpaperManagerShellCommand(this).exec(this, in, out, err, args, callback, resultReceiver);
    }

    private void dumpWallpaper(WallpaperData wallpaper, final PrintWriter pw) {
        if (wallpaper != null) goto L5;
        pw.println(" (null entry)");
        return;
    L5:
        pw.print(" User ");
        pw.print(wallpaper.userId);
        pw.print(": id=");
        pw.print(wallpaper.wallpaperId);
        pw.print(": mWhich=");
        pw.print(wallpaper.mWhich);
        pw.print(": mSystemWasBoth=");
        pw.print(wallpaper.mSystemWasBoth);
        pw.print(": mBindSource=");
        pw.println(wallpaper.mBindSource.name());
        pw.println(" Display state:");
        this.mWallpaperDisplayHelper.forEachDisplayData(new WallpaperManagerService$$ExternalSyntheticLambda17(pw));
        pw.print("  mCropHint=");
        pw.println(wallpaper.cropHint);
        pw.print("  mCropHints=");
        pw.println(wallpaper.mCropHints);
        pw.print("  mName=");
        pw.println(wallpaper.name);
        pw.print("  mAllowBackup=");
        pw.println(wallpaper.allowBackup);
        pw.print("  mWallpaperComponent=");
        pw.println(wallpaper.getComponent());
        pw.print("  mWallpaperDimAmount=");
        pw.println(wallpaper.mWallpaperDimAmount);
        pw.print("  isColorExtracted=");
        pw.println(wallpaper.mIsColorExtractedFromDim);
        pw.println("  mUidToDimAmount:");
        int j = 0;
    L7:
        if (j >= wallpaper.mUidToDimAmount.size()) goto L10;
        pw.print("    UID=");
        pw.print(wallpaper.mUidToDimAmount.keyAt(j));
        pw.print(" dimAmount=");
        pw.println(wallpaper.mUidToDimAmount.valueAt(j));
        j = j + 1;
        goto L7
    L10:
        if (wallpaper.connection == null) goto L17;
        WallpaperConnection conn = wallpaper.connection;
        pw.print("  Wallpaper connection ");
        pw.print(conn);
        pw.println(":");
        if (conn.mInfo == null) goto L14;
        pw.print("    mInfo.component=");
        pw.println(conn.mInfo.getComponent());
    L14:
        conn.forEachDisplayConnector(new WallpaperManagerService$$ExternalSyntheticLambda18(pw));
        pw.print("    mService=");
        pw.println(conn.mService);
        pw.print("    mLastDiedTime=");
        pw.println(wallpaper.lastDiedTime - SystemClock.uptimeMillis());
        return;
    }

    private static /* synthetic */ void lambda$dumpWallpaper$19(PrintWriter pw, WallpaperDisplayHelper.DisplayData wpSize) {
        pw.print("  displayId=");
        pw.println(wpSize.mDisplayId);
        pw.print("  mWidth=");
        pw.print(wpSize.mWidth);
        pw.print("  mHeight=");
        pw.println(wpSize.mHeight);
        pw.print("  mPadding=");
        pw.println(wpSize.mPadding);
    }

    private static /* synthetic */ void lambda$dumpWallpaper$20(PrintWriter pw, DisplayConnector connector) {
        pw.print("     mDisplayId=");
        pw.println(connector.mDisplayId);
        pw.print("     mToken=");
        pw.println(connector.mToken);
        pw.print("     mEngine=");
        pw.println(connector.mEngine);
    }

    protected void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
        if (DumpUtils.checkDumpPermission(this.mContext, TAG, pw) == true) goto L5;
        return;
    L5:
        pw.print("mDefaultWallpaperComponent=");
        pw.println(this.mDefaultWallpaperComponent);
        pw.print("mImageWallpaper=");
        pw.println(this.mImageWallpaper);
        Object r0 = this.mLock;
        monitor-enter(r0);
        pw.println("System wallpaper state:");     // Catch: Throwable -> L11
        int i = 0;
    L9:
        if (i >= this.mWallpaperMap.size()) goto L13;
        dumpWallpaper(this.mWallpaperMap.valueAt(i), pw);     // Catch: Throwable -> L11
        i = i + 1;     // Catch: Throwable -> L11
        goto L9
    L13:
        pw.println("Lock wallpaper state:");     // Catch: Throwable -> L11
        int i2 = 0;
    L15:
        if (i2 >= this.mLockWallpaperMap.size()) goto L17;
        dumpWallpaper(this.mLockWallpaperMap.valueAt(i2), pw);     // Catch: Throwable -> L11
        i2 = i2 + 1;     // Catch: Throwable -> L11
        goto L15
    L17:
        pw.println("Fallback wallpaper state:");     // Catch: Throwable -> L11
        if (this.mFallbackWallpaper == null) goto L20;
        dumpWallpaper(this.mFallbackWallpaper, pw);     // Catch: Throwable -> L11
    L20:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public IWallpaperManagerExt getIExt() {
        return getExt().getIExt();
    }

    public IExtWallpaperManagerService getExt() {
        return this.mIExt;
    }
}
