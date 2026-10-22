package com.android.server.statusbar;

import android.R;
import android.app.ActivityManager;
import android.app.ActivityManagerInternal;
import android.app.ActivityThread;
import android.app.Notification;
import android.app.compat.CompatChanges;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.om.IOverlayManager;
import android.content.pm.PackageManager;
import android.content.pm.PackageManagerInternal;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Icon;
import android.hardware.biometrics.IBiometricContextListener;
import android.hardware.biometrics.IBiometricSysuiReceiver;
import android.hardware.biometrics.PromptInfo;
import android.hardware.display.DisplayManager;
import android.hardware.fingerprint.IUdfpsRefreshRateRequestCallback;
import android.media.INearbyMediaDevicesProvider;
import android.media.MediaRoute2Info;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Process;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.ServiceManager;
import android.os.ShellCallback;
import android.os.UserHandle;
import android.os.UserManager;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.IndentingPrintWriter;
import android.util.IntArray;
import android.util.Pair;
import android.util.Slog;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.WindowInsets;
import com.android.internal.logging.InstanceId;
import com.android.internal.os.TransferPipe;
import com.android.internal.statusbar.DisableStates;
import com.android.internal.statusbar.IAddTileResultCallback;
import com.android.internal.statusbar.ISessionListener;
import com.android.internal.statusbar.IStatusBar;
import com.android.internal.statusbar.IStatusBarService;
import com.android.internal.statusbar.IUndoMediaTransferCallback;
import com.android.internal.statusbar.LetterboxDetails;
import com.android.internal.statusbar.NotificationVisibility;
import com.android.internal.statusbar.RegisterStatusBarResult;
import com.android.internal.statusbar.StatusBarIcon;
import com.android.internal.util.DumpUtils;
import com.android.internal.util.GcUtils;
import com.android.internal.view.AppearanceRegion;
import com.android.server.LocalServices;
import com.android.server.SysOptBridge;
import com.android.server.UiThread;
import com.android.server.inputmethod.InputMethodManagerInternal;
import com.android.server.notification.NotificationDelegate;
import com.android.server.pm.UserManagerInternal;
import com.android.server.pm.UserManagerService;
import com.android.server.policy.GlobalActionsProvider;
import com.android.server.power.ShutdownCheckPoints;
import com.android.server.power.ShutdownThread;
import com.android.server.wm.ActivityTaskManagerInternal;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public class StatusBarManagerService extends IStatusBarService.Stub implements DisplayManager.DisplayListener {
    private static final long LOCK_DOWN_COLLAPSE_STATUS_BAR = 173031413;
    static final long REQUEST_LISTENING_MUST_MATCH_PACKAGE = 172251878;
    static final long REQUEST_LISTENING_OTHER_USER_NOOP = 242194868;
    private static final long REQUEST_TIME_OUT = 0;
    private static final boolean SPEW = false;
    private static final String TAG = "StatusBarManagerService";
    private final ActivityManagerInternal mActivityManagerInternal;
    private final ActivityTaskManagerInternal mActivityTaskManager;
    protected volatile IStatusBar mBar;
    private IBiometricContextListener mBiometricContextListener;
    private final Context mContext;
    private final ArrayMap<String, Long> mCurrentRequestAddTilePackages;
    private int mCurrentUserId;
    private final DeathRecipient mDeathRecipient;
    private final ArrayList<DisableRecord> mDisableRecords;
    private final SparseArray<UiState> mDisplayUiState;
    private GlobalActionsProvider.GlobalActionsListener mGlobalActionListener;
    private final GlobalActionsProvider mGlobalActionsProvider;
    private final Handler mHandler;
    private final ArrayMap<String, StatusBarIcon> mIcons;
    private final StatusBarManagerInternal mInternalService;
    private int mLastSystemKey;
    private final Object mLock;
    private NotificationDelegate mNotificationDelegate;
    private IOverlayManager mOverlayManager;
    private final PackageManagerInternal mPackageManagerInternal;
    private final SessionMonitor mSessionMonitor;
    private final IBinder mSysUiVisToken;
    private final TileRequestTracker mTileRequestTracker;
    private boolean mTracingEnabled;
    private IUdfpsRefreshRateRequestCallback mUdfpsRefreshRateRequestCallback;
    private final UserManagerService mUserManager;
    private final UserManagerInternal mUserManagerInternal;
    private final boolean mVisibleBackgroundUsersEnabled;

    private class DeathRecipient implements IBinder.DeathRecipient {
        final /* synthetic */ StatusBarManagerService this$0;

        /* synthetic */ DeathRecipient(StatusBarManagerService r1, StatusBarManagerServiceIA r2) {
            this(r1);
        }

        private DeathRecipient(StatusBarManagerService r1) {
            this.this$0 = r1;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            this.this$0.mBar.asBinder().unlinkToDeath(this, 0);
            this.this$0.mBar = null;
            StatusBarManagerService.m8392$$Nest$mnotifyBarAttachChanged(this.this$0);
        }

        public void linkToDeath() {
            this.this$0.mBar.asBinder().linkToDeath(StatusBarManagerService.m8377$$Nest$fgetmDeathRecipient(this.this$0), 0);     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            Slog.e(StatusBarManagerService.TAG, "Unable to register Death Recipient for status bar", e);
        }
    }

    private class DisableRecord implements IBinder.DeathRecipient {
        String pkg;
        final /* synthetic */ StatusBarManagerService this$0;
        IBinder token;
        int userId;
        int what1;
        int what2;

        public DisableRecord(StatusBarManagerService r1, int userId, IBinder token) {
            this.this$0 = r1;
            this.userId = userId;
            this.token = token;
            token.linkToDeath(this, 0);     // Catch: RemoteException -> L5
            return;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            Slog.i(StatusBarManagerService.TAG, "binder died for pkg=" + this.pkg);
            this.this$0.disableForUser(0, this.token, this.pkg, this.userId);
            this.this$0.disable2ForUser(0, this.token, this.pkg, this.userId);
            this.token.unlinkToDeath(this, 0);
        }

        public void setFlags(int what, int which, String pkg) {
            switch(which) {
                case 1: goto L5;
                case 2: goto L4;
                default: goto L3;
            };
        L3:
            Slog.w(StatusBarManagerService.TAG, "Can't set unsupported disable flag " + which + ": 0x" + Integer.toHexString(what));
        L6:
            this.pkg = pkg;
            return;
        L4:
            this.what2 = what;
            goto L6
        L5:
            this.what1 = what;
            goto L6
        }

        public int getFlags(int which) {
            switch(which) {
                case 1: goto L8;
                case 2: goto L6;
                default: goto L3;
            };
        L3:
            Slog.w(StatusBarManagerService.TAG, "Can't get unsupported disable flag " + which);
            return 0;
        L6:
            return this.what2;
        L8:
            return this.what1;
        }

        public boolean isEmpty() {
            if (this.what1 == 0) goto L5;
        L7:
            return false;
        L5:
            if (this.what2 != 0) goto L7;
            return true;
        }

        public String toString() {
            return String.format("userId=%d what1=0x%08X what2=0x%08X pkg=%s token=%s", new Object[]{Integer.valueOf(this.userId), Integer.valueOf(this.what1), Integer.valueOf(this.what2), this.pkg, this.token});
        }
    }

    private static class UiState {
        private int mAppearance;
        private AppearanceRegion[] mAppearanceRegions;
        private int mBehavior;
        private int mDisabled1;
        private int mDisabled2;
        private int mImeBackDisposition;
        private int mImeWindowVis;
        private LetterboxDetails[] mLetterboxDetails;
        private boolean mNavbarColorManagedByIme;
        private String mPackageName;
        private int mRequestedVisibleTypes;
        private boolean mShowImeSwitcher;
        private int mTransientBarTypes;

        /* JADX INFO: renamed from: -$$Nest$fgetmAppearance, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m8394$$Nest$fgetmAppearance(UiState r0) {
            return r0.mAppearance;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmAppearanceRegions, reason: not valid java name */
        static /* bridge */ /* synthetic */ AppearanceRegion[] m8395$$Nest$fgetmAppearanceRegions(UiState r0) {
            return r0.mAppearanceRegions;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmBehavior, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m8396$$Nest$fgetmBehavior(UiState r0) {
            return r0.mBehavior;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmImeBackDisposition, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m8397$$Nest$fgetmImeBackDisposition(UiState r0) {
            return r0.mImeBackDisposition;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmImeWindowVis, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m8398$$Nest$fgetmImeWindowVis(UiState r0) {
            return r0.mImeWindowVis;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmLetterboxDetails, reason: not valid java name */
        static /* bridge */ /* synthetic */ LetterboxDetails[] m8399$$Nest$fgetmLetterboxDetails(UiState r0) {
            return r0.mLetterboxDetails;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmNavbarColorManagedByIme, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m8400$$Nest$fgetmNavbarColorManagedByIme(UiState r0) {
            return r0.mNavbarColorManagedByIme;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmPackageName, reason: not valid java name */
        static /* bridge */ /* synthetic */ String m8401$$Nest$fgetmPackageName(UiState r0) {
            return r0.mPackageName;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmRequestedVisibleTypes, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m8402$$Nest$fgetmRequestedVisibleTypes(UiState r0) {
            return r0.mRequestedVisibleTypes;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmShowImeSwitcher, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m8403$$Nest$fgetmShowImeSwitcher(UiState r0) {
            return r0.mShowImeSwitcher;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmTransientBarTypes, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m8404$$Nest$fgetmTransientBarTypes(UiState r0) {
            return r0.mTransientBarTypes;
        }

        /* JADX INFO: renamed from: -$$Nest$mclearTransient, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m8405$$Nest$mclearTransient(UiState r0, int r1) {
            r0.clearTransient(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$mdisableEquals, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m8406$$Nest$mdisableEquals(UiState r0, int r1, int r2) {
            return r0.disableEquals(r1, r2);
        }

        /* JADX INFO: renamed from: -$$Nest$mgetDisabled1, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m8407$$Nest$mgetDisabled1(UiState r0) {
            return r0.getDisabled1();
        }

        /* JADX INFO: renamed from: -$$Nest$mgetDisabled2, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m8408$$Nest$mgetDisabled2(UiState r0) {
            return r0.getDisabled2();
        }

        /* JADX INFO: renamed from: -$$Nest$msetBarAttributes, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m8409$$Nest$msetBarAttributes(UiState r0, int r1, AppearanceRegion[] r2, boolean r3, int r4, int r5, String r6, LetterboxDetails[] r7) {
            r0.setBarAttributes(r1, r2, r3, r4, r5, r6, r7);
        }

        /* JADX INFO: renamed from: -$$Nest$msetDisabled, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m8410$$Nest$msetDisabled(UiState r0, int r1, int r2) {
            r0.setDisabled(r1, r2);
        }

        /* JADX INFO: renamed from: -$$Nest$msetImeWindowState, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m8411$$Nest$msetImeWindowState(UiState r0, int r1, int r2, boolean r3) {
            r0.setImeWindowState(r1, r2, r3);
        }

        /* JADX INFO: renamed from: -$$Nest$mshowTransient, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m8412$$Nest$mshowTransient(UiState r0, int r1) {
            r0.showTransient(r1);
        }

        /* synthetic */ UiState(StatusBarManagerServiceIA r1) {
            this();
        }

        private UiState() {
            this.mAppearance = 0;
            this.mAppearanceRegions = new AppearanceRegion[0];
            this.mNavbarColorManagedByIme = false;
            this.mRequestedVisibleTypes = WindowInsets.Type.defaultVisible();
            this.mPackageName = "none";
            this.mDisabled1 = 0;
            this.mDisabled2 = 0;
            this.mImeWindowVis = 0;
            this.mImeBackDisposition = 0;
            this.mShowImeSwitcher = false;
            this.mLetterboxDetails = new LetterboxDetails[0];
        }

        private void setBarAttributes(int appearance, AppearanceRegion[] appearanceRegions, boolean navbarColorManagedByIme, int behavior, int requestedVisibleTypes, String packageName, LetterboxDetails[] letterboxDetails) {
            this.mAppearance = appearance;
            this.mAppearanceRegions = appearanceRegions;
            this.mNavbarColorManagedByIme = navbarColorManagedByIme;
            this.mBehavior = behavior;
            this.mRequestedVisibleTypes = requestedVisibleTypes;
            this.mPackageName = packageName;
            this.mLetterboxDetails = letterboxDetails;
        }

        private void showTransient(int types) {
            this.mTransientBarTypes |= types;
        }

        private void clearTransient(int types) {
            this.mTransientBarTypes &= ~types;
        }

        private int getDisabled1() {
            return this.mDisabled1;
        }

        private int getDisabled2() {
            return this.mDisabled2;
        }

        private void setDisabled(int disabled1, int disabled2) {
            this.mDisabled1 = disabled1;
            this.mDisabled2 = disabled2;
        }

        private boolean disableEquals(int disabled1, int disabled2) {
            if (this.mDisabled1 == disabled1) goto L5;
        L7:
            return false;
        L5:
            if (this.mDisabled2 != disabled2) goto L7;
            return true;
        }

        private void setImeWindowState(int vis, int backDisposition, boolean showImeSwitcher) {
            this.mImeWindowVis = vis;
            this.mImeBackDisposition = backDisposition;
            this.mShowImeSwitcher = showImeSwitcher;
        }
    }

    public static /* synthetic */ void $r8$lambda$59p1ntjiSJASYnFCl7Ew6a22L3c(StatusBarManagerService r0) {
        r0.lambda$notifyBarAttachChanged$4();
    }

    public static /* synthetic */ void $r8$lambda$9FJFWiKWGYumAAyb_SgY2NzCWDQ(String r0) {
        lambda$shutdown$5(r0);
    }

    public static /* synthetic */ void $r8$lambda$ArPOA0roNhfmG3odrT0Pk3guSfk(boolean r0, String r1) {
        lambda$reboot$6(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$XS_0q1YLU5EzL4UYJ2RX4E-FfWw, reason: not valid java name */
    public static /* synthetic */ void m8374$r8$lambda$XS_0q1YLU5EzL4UYJ2RX4EFfWw(StatusBarManagerService r0) {
        r0.lambda$restart$7();
    }

    public static /* synthetic */ void $r8$lambda$e1JkR72HtKsWVsWVvLe6kYx7d1k(StatusBarManagerService r0, int r1) {
        r0.lambda$disableLocked$0(r1);
    }

    public static /* synthetic */ void $r8$lambda$kW5vGNkWhaYMZN84PMQpKPevzv0(StatusBarManagerService r0, int r1) {
        r0.lambda$disableAllDisplaysLocked$1(r1);
    }

    public static /* synthetic */ void $r8$lambda$nWjxl9WE61ral9X4QCz5jQbdFdw(StatusBarManagerService r0) {
        r0.lambda$notifyBarAttachChanged$3();
    }

    /* JADX INFO: renamed from: $r8$lambda$sOIsh_to_xA_LnMxKA0y_h-zOXs, reason: not valid java name */
    public static /* synthetic */ void m8375$r8$lambda$sOIsh_to_xA_LnMxKA0y_hzOXs(StatusBarManagerService r0, int r1, int r2, int r3, boolean r4) {
        r0.lambda$setImeWindowStatus$2(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m8376$$Nest$fgetmContext(StatusBarManagerService r0) {
        return r0.mContext;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDeathRecipient, reason: not valid java name */
    static /* bridge */ /* synthetic */ DeathRecipient m8377$$Nest$fgetmDeathRecipient(StatusBarManagerService r0) {
        return r0.mDeathRecipient;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDisplayUiState, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseArray m8378$$Nest$fgetmDisplayUiState(StatusBarManagerService r0) {
        return r0.mDisplayUiState;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmGlobalActionListener, reason: not valid java name */
    static /* bridge */ /* synthetic */ GlobalActionsProvider.GlobalActionsListener m8379$$Nest$fgetmGlobalActionListener(StatusBarManagerService r0) {
        return r0.mGlobalActionListener;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m8380$$Nest$fgetmLock(StatusBarManagerService r0) {
        return r0.mLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmTileRequestTracker, reason: not valid java name */
    static /* bridge */ /* synthetic */ TileRequestTracker m8381$$Nest$fgetmTileRequestTracker(StatusBarManagerService r0) {
        return r0.mTileRequestTracker;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmCurrentUserId, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8382$$Nest$fputmCurrentUserId(StatusBarManagerService r0, int r1) {
        r0.mCurrentUserId = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmGlobalActionListener, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8383$$Nest$fputmGlobalActionListener(StatusBarManagerService r0, GlobalActionsProvider.GlobalActionsListener r1) {
        r0.mGlobalActionListener = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmNotificationDelegate, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8384$$Nest$fputmNotificationDelegate(StatusBarManagerService r0, NotificationDelegate r1) {
        r0.mNotificationDelegate = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmUdfpsRefreshRateRequestCallback, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8385$$Nest$fputmUdfpsRefreshRateRequestCallback(StatusBarManagerService r0, IUdfpsRefreshRateRequestCallback r1) {
        r0.mUdfpsRefreshRateRequestCallback = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$maddQsTileToFrontOrEnd, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8386$$Nest$maddQsTileToFrontOrEnd(StatusBarManagerService r0, ComponentName r1, boolean r2) {
        r0.addQsTileToFrontOrEnd(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mclearTileAddRequest, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m8387$$Nest$mclearTileAddRequest(StatusBarManagerService r0, String r1) {
        return r0.clearTileAddRequest(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$menforceStatusBarService, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8388$$Nest$menforceStatusBarService(StatusBarManagerService r0) {
        r0.enforceStatusBarService();
    }

    /* JADX INFO: renamed from: -$$Nest$mgetUiState, reason: not valid java name */
    static /* bridge */ /* synthetic */ UiState m8389$$Nest$mgetUiState(StatusBarManagerService r0, int r1) {
        return r0.getUiState(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$misVisibleBackgroundUser, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m8390$$Nest$misVisibleBackgroundUser(StatusBarManagerService r0, int r1) {
        return r0.isVisibleBackgroundUser(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$misVisibleBackgroundUserOnDisplay, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m8391$$Nest$misVisibleBackgroundUserOnDisplay(StatusBarManagerService r0, int r1) {
        return r0.isVisibleBackgroundUserOnDisplay(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mnotifyBarAttachChanged, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8392$$Nest$mnotifyBarAttachChanged(StatusBarManagerService r0) {
        r0.notifyBarAttachChanged();
    }

    /* JADX INFO: renamed from: -$$Nest$msetDisableFlags, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8393$$Nest$msetDisableFlags(StatusBarManagerService r0, int r1, int r2, String r3) {
        r0.setDisableFlags(r1, r2, r3);
    }

    static {
        REQUEST_TIME_OUT = TimeUnit.MINUTES.toNanos(5);
    }

    public StatusBarManagerService(Context context) {
        this.mHandler = new Handler();
        this.mIcons = new ArrayMap();
        this.mDisableRecords = new ArrayList();
        this.mSysUiVisToken = new Binder();
        this.mLock = new Object();
        StatusBarManagerServiceIA r1 = null;
        this.mDeathRecipient = new DeathRecipient(this, r1);
        this.mLastSystemKey = -1;
        this.mDisplayUiState = new SparseArray();
        this.mCurrentRequestAddTilePackages = new ArrayMap();
        this.mInternalService = new AnonymousClass1(this);
        this.mGlobalActionsProvider = new AnonymousClass2(this);
        this.mContext = context;
        LocalServices.addService(StatusBarManagerInternal.class, this.mInternalService);
        UiState state = new UiState(r1);
        this.mDisplayUiState.put(0, state);
        DisplayManager displayManager = (DisplayManager) context.getSystemService("display");
        displayManager.registerDisplayListener(this, this.mHandler);
        this.mActivityTaskManager = (ActivityTaskManagerInternal) LocalServices.getService(ActivityTaskManagerInternal.class);
        this.mPackageManagerInternal = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);
        this.mActivityManagerInternal = (ActivityManagerInternal) LocalServices.getService(ActivityManagerInternal.class);
        this.mUserManagerInternal = (UserManagerInternal) LocalServices.getService(UserManagerInternal.class);
        this.mTileRequestTracker = new TileRequestTracker(this.mContext);
        this.mSessionMonitor = new SessionMonitor(this.mContext);
        this.mVisibleBackgroundUsersEnabled = UserManager.isVisibleBackgroundUsersEnabled();
        this.mUserManager = UserManagerService.getInstance();
    }

    public void publishGlobalActionsProvider() {
        if (LocalServices.getService(GlobalActionsProvider.class) != null) goto L6;
        LocalServices.addService(GlobalActionsProvider.class, this.mGlobalActionsProvider);
        return;
    }

    private IOverlayManager getOverlayManager() {
        if (this.mOverlayManager != null) goto L8;
        this.mOverlayManager = IOverlayManager.Stub.asInterface(ServiceManager.getService("overlay"));
        if (this.mOverlayManager != null) goto L8;
        Slog.w("StatusBarManager", "warning: no OVERLAY_SERVICE");
    L8:
        return this.mOverlayManager;
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public void onDisplayAdded(int displayId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mDisplayUiState.put(displayId, new UiState(null));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public void onDisplayRemoved(int displayId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mDisplayUiState.remove(displayId);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public void onDisplayChanged(int displayId) {
    }

    private boolean isDisable2FlagSet(int target2) {
        int disabled2 = UiState.m8408$$Nest$mgetDisabled2(this.mDisplayUiState.get(0));
        if ((disabled2 & target2) != target2) goto L6;
        return true;
    L6:
        return false;
    }

    public void expandNotificationsPanel() {
        enforceExpandStatusBar();
        enforceValidCallingUser();
        if (isDisable2FlagSet(4) == false) goto L6;
        return;
    L6:
        if (this.mBar == null) goto L13;
        this.mBar.animateExpandNotificationsPanel();     // Catch: RemoteException -> L9
        return;
    L10:
        return;
    }

    public void collapsePanels() {
        enforceValidCallingUser();
        if (checkCanCollapseStatusBar("collapsePanels") == true) goto L6;
        return;
    L6:
        if (this.mBar == null) goto L13;
        this.mBar.animateCollapsePanels();     // Catch: RemoteException -> L9
        return;
    L10:
        return;
    }

    public void togglePanel() {
        enforceValidCallingUser();
        if (checkCanCollapseStatusBar("togglePanel") == true) goto L6;
        return;
    L6:
        if (isDisable2FlagSet(4) == false) goto L9;
        return;
    L9:
        if (this.mBar == null) goto L16;
        this.mBar.toggleNotificationsPanel();     // Catch: RemoteException -> L12
        return;
    L13:
        return;
    }

    public void expandSettingsPanel(String subPanel) {
        enforceExpandStatusBar();
        enforceValidCallingUser();
        if (this.mBar == null) goto L10;
        this.mBar.animateExpandSettingsPanel(subPanel);     // Catch: RemoteException -> L6
        return;
    L7:
        return;
    }

    public void addTile(ComponentName component) {
        addQsTileToFrontOrEnd(component, false);
    }

    private void addQsTileToFrontOrEnd(ComponentName tile, boolean end) {
        enforceStatusBarOrShell();
        enforceValidCallingUser();
        if (this.mBar == null) goto L10;
        this.mBar.addQsTileToFrontOrEnd(tile, end);     // Catch: RemoteException -> L6
        return;
    L7:
        return;
    }

    public void remTile(ComponentName component) {
        enforceStatusBarOrShell();
        enforceValidCallingUser();
        if (this.mBar == null) goto L10;
        this.mBar.remQsTile(component);     // Catch: RemoteException -> L6
        return;
    L7:
        return;
    }

    public void setTiles(String tiles) {
        enforceStatusBarOrShell();
        if (this.mBar == null) goto L10;
        this.mBar.setQsTiles(tiles.split(","));     // Catch: RemoteException -> L6
        return;
    L7:
        return;
    }

    public void clickTile(ComponentName component) {
        enforceStatusBarOrShell();
        enforceValidCallingUser();
        if (this.mBar == null) goto L10;
        this.mBar.clickQsTile(component);     // Catch: RemoteException -> L6
        return;
    L7:
        return;
    }

    public void handleSystemKey(KeyEvent key) throws RemoteException {
        enforceValidCallingUser();
        if (checkCanCollapseStatusBar("handleSystemKey") == true) goto L5;
        return;
    L5:
        this.mLastSystemKey = key.getKeyCode();
        if (this.mBar == null) goto L13;
        this.mBar.handleSystemKey(key);     // Catch: RemoteException -> L9
        return;
    L10:
        return;
    }

    public int getLastSystemKey() {
        enforceStatusBar();
        return this.mLastSystemKey;
    }

    public void showPinningEnterExitToast(boolean entering) throws RemoteException {
        enforceValidCallingUser();
        if (this.mBar == null) goto L10;
        this.mBar.showPinningEnterExitToast(entering);     // Catch: RemoteException -> L6
        return;
    L7:
        return;
    }

    public void showPinningEscapeToast() throws RemoteException {
        enforceValidCallingUser();
        if (this.mBar == null) goto L10;
        this.mBar.showPinningEscapeToast();     // Catch: RemoteException -> L6
        return;
    L7:
        return;
    }

    public void showAuthenticationDialog(PromptInfo promptInfo, IBiometricSysuiReceiver receiver, int[] sensorIds, boolean credentialAllowed, boolean requireConfirmation, int userId, long operationId, String opPackageName, long requestId) {
        enforceBiometricDialog();
        enforceValidCallingUser();
        if (this.mBar == null) goto L10;
        this.mBar.showAuthenticationDialog(promptInfo, receiver, sensorIds, credentialAllowed, requireConfirmation, userId, operationId, opPackageName, requestId);     // Catch: RemoteException -> L6
        return;
    L7:
        return;
    }

    public void onBiometricAuthenticated(int modality) {
        enforceBiometricDialog();
        enforceValidCallingUser();
        if (this.mBar == null) goto L10;
        this.mBar.onBiometricAuthenticated(modality);     // Catch: RemoteException -> L6
        return;
    L7:
        return;
    }

    public void onBiometricHelp(int modality, String message) {
        enforceBiometricDialog();
        enforceValidCallingUser();
        if (this.mBar == null) goto L10;
        this.mBar.onBiometricHelp(modality, message);     // Catch: RemoteException -> L6
        return;
    L7:
        return;
    }

    public void onBiometricError(int modality, int error, int vendorCode) {
        enforceBiometricDialog();
        enforceValidCallingUser();
        if (this.mBar == null) goto L10;
        this.mBar.onBiometricError(modality, error, vendorCode);     // Catch: RemoteException -> L6
        return;
    L7:
        return;
    }

    public void hideAuthenticationDialog(long requestId) {
        enforceBiometricDialog();
        enforceValidCallingUser();
        if (this.mBar == null) goto L10;
        this.mBar.hideAuthenticationDialog(requestId);     // Catch: RemoteException -> L6
        return;
    L7:
        return;
    }

    public void setBiometicContextListener(IBiometricContextListener listener) {
        enforceStatusBarService();
        enforceValidCallingUser();
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mBiometricContextListener = listener;     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        if (this.mBar == null) goto L19;
        this.mBar.setBiometicContextListener(listener);     // Catch: RemoteException -> L10
        return;
    L11:
        return;
    L19:
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public void setUdfpsRefreshRateCallback(IUdfpsRefreshRateRequestCallback callback) {
        enforceStatusBarService();
        enforceValidCallingUser();
        if (this.mBar == null) goto L10;
        this.mBar.setUdfpsRefreshRateCallback(callback);     // Catch: RemoteException -> L6
        return;
    L7:
        return;
    }

    public void startTracing() {
        enforceValidCallingUser();
        if (this.mBar == null) goto L10;
        this.mBar.startTracing();     // Catch: RemoteException -> L6
        this.mTracingEnabled = true;     // Catch: RemoteException -> L6
        return;
    L7:
        return;
    }

    public void stopTracing() {
        enforceValidCallingUser();
        if (this.mBar != null) goto L10;
        return;
    L10:
        this.mTracingEnabled = false;     // Catch: RemoteException -> L7
        this.mBar.stopTracing();     // Catch: RemoteException -> L7
        return;
    }

    public boolean isTracing() {
        return this.mTracingEnabled;
    }

    public void disable(int what, IBinder token, String pkg) {
        disableForUser(what, token, pkg, this.mCurrentUserId);
    }

    public void disableForUser(int what, IBinder token, String pkg, int userId) {
        enforceStatusBar();
        enforceValidCallingUser();
        Object r1 = this.mLock;
        monitor-enter(r1);
        disableLocked(0, userId, what, token, pkg, 1);     // Catch: Throwable -> L8
        monitor-exit(r1);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void disable2(int what, IBinder token, String pkg) {
        disable2ForUser(what, token, pkg, this.mCurrentUserId);
    }

    public void disable2ForUser(int what, IBinder token, String pkg, int userId) {
        enforceStatusBar();
        Object r1 = this.mLock;
        monitor-enter(r1);
        disableLocked(0, userId, what, token, pkg, 2);     // Catch: Throwable -> L8
        monitor-exit(r1);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private void disableLocked(int displayId, int userId, int what, IBinder token, String pkg, int whichFlag) {
        manageDisableListLocked(userId, what, token, pkg, whichFlag);
        final int net1 = gatherDisableActionsLocked(this.mCurrentUserId, 1);
        int net2 = gatherDisableActionsLocked(this.mCurrentUserId, 2);
        UiState state = getUiState(displayId);
        if (UiState.m8406$$Nest$mdisableEquals(state, net1, net2) == true) goto L12;
        UiState.m8410$$Nest$msetDisabled(state, net1, net2);
        this.mHandler.post(new StatusBarManagerService$$ExternalSyntheticLambda4(this, net1));
        IStatusBar bar = this.mBar;
        if (bar == null) goto L13;
        bar.disable(displayId, net1, net2);     // Catch: RemoteException -> L8
        return;
    L9:
        return;
    L13:
        return;
    }

    private /* synthetic */ void lambda$disableLocked$0(int net1) {
        this.mNotificationDelegate.onSetDisabled(net1);
    }

    private void disableAllDisplaysLocked(IntArray displayIds, int userId, int what, IBinder token, String pkg, int whichFlag) {
        manageDisableListLocked(userId, what, token, pkg, whichFlag);
        final int net1 = gatherDisableActionsLocked(this.mCurrentUserId, 1);
        int net2 = gatherDisableActionsLocked(this.mCurrentUserId, 2);
        IStatusBar bar = this.mBar;
        Map<Integer, Pair<Integer, Integer>> displaysWithNewDisableStates = new HashMap();
        int[] r0 = displayIds.toArray();
        int r6 = r0.length;
        int r7 = 0;
    L3:
        if (r7 >= r6) goto L8;
        int displayId = r0[r7];
        UiState state = getUiState(displayId);
        if (UiState.m8406$$Nest$mdisableEquals(state, net1, net2) == true) goto L7;
        UiState.m8410$$Nest$msetDisabled(state, net1, net2);
        displaysWithNewDisableStates.put(Integer.valueOf(displayId), new Pair(Integer.valueOf(net1), Integer.valueOf(net2)));
    L7:
        r7 = r7 + 1;
        goto L3
    L8:
        if (bar == null) goto L14;
        bar.disableForAllDisplays(new DisableStates(displaysWithNewDisableStates));     // Catch: RemoteException -> L11
    L11:
        ex = move-exception;
        Slog.e(TAG, "Unable to disable Status bar.", ex);
    L14:
        if (displaysWithNewDisableStates.isEmpty() == true) goto L22;
        this.mHandler.post(new StatusBarManagerService$$ExternalSyntheticLambda0(this, net1));
        return;
    }

    private /* synthetic */ void lambda$disableAllDisplaysLocked$1(int net1) {
        this.mNotificationDelegate.onSetDisabled(net1);
    }

    public int[] getDisableFlags(IBinder token, int userId) {
        enforceStatusBar();
        int disable1 = 0;
        int disable2 = 0;
        Object r2 = this.mLock;
        monitor-enter(r2);
        DisableRecord record = (DisableRecord) findMatchingRecordLocked(token, userId).second;     // Catch: Throwable -> L7
        if (record == null) goto L9;
        disable1 = record.what1;     // Catch: Throwable -> L7
        disable2 = record.what2;     // Catch: Throwable -> L7
    L9:
        monitor-exit(r2);     // Catch: Throwable -> L7
        return new int[]{disable1, disable2};
    L7:
        th = move-exception;
        throw th;
    }

    void runGcForTest() {
        if (Build.IS_DEBUGGABLE == false) goto L11;
        GcUtils.runGcAndFinalizersSync();
        if (this.mBar == null) goto L14;
        this.mBar.runGcForTest();     // Catch: RemoteException -> L8
        return;
    L9:
        return;
    L14:
        return;
    L11:
        throw new SecurityException("runGcForTest requires a debuggable build");
    }

    public void setIcon(String slot, String iconPackage, int iconId, int iconLevel, String contentDescription) {
        enforceStatusBar();
        enforceValidCallingUser();
        ArrayMap<String, StatusBarIcon> r1 = this.mIcons;
        monitor-enter(r1);
        StatusBarIcon icon = new StatusBarIcon(iconPackage, UserHandle.SYSTEM, iconId, iconLevel, 0, contentDescription, StatusBarIcon.Type.SystemIcon);     // Catch: Throwable -> L10
        this.mIcons.put(slot, icon);     // Catch: Throwable -> L10
        IStatusBar bar = this.mBar;     // Catch: Throwable -> L10
        if (bar != null) goto L21;
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L10
        return;
    L21:
        bar.setIcon(slot, icon);     // Catch: Throwable -> L10 RemoteException -> L12
    L10:
        th = move-exception;
        Throwable r12 = th;
    L17:
        monitor-exit(r1);     // Catch: Throwable -> L10
        throw r12;
    L15:
        th = move-exception;
        r12 = th;
        goto L17
    }

    public void setIconVisibility(String slot, boolean visibility) {
        enforceStatusBar();
        enforceValidCallingUser();
        ArrayMap<String, StatusBarIcon> r0 = this.mIcons;
        monitor-enter(r0);
        StatusBarIcon icon = this.mIcons.get(slot);     // Catch: Throwable -> L8
        if (icon != null) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L11:
        if (icon.visible == visibility) goto L17;
        icon.visible = visibility;     // Catch: Throwable -> L8
        IStatusBar bar = this.mBar;     // Catch: Throwable -> L8
        if (bar == null) goto L17;
        bar.setIcon(slot, icon);     // Catch: Throwable -> L8 RemoteException -> L16
    L17:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void removeIcon(String slot) {
        enforceStatusBar();
        enforceValidCallingUser();
        ArrayMap<String, StatusBarIcon> r0 = this.mIcons;
        monitor-enter(r0);
        this.mIcons.remove(slot);     // Catch: Throwable -> L8
        IStatusBar bar = this.mBar;     // Catch: Throwable -> L8
        if (bar != null) goto L17;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L17:
        bar.removeIcon(slot);     // Catch: Throwable -> L8 RemoteException -> L10
    L8:
        th = move-exception;
        throw th;
    }

    public void setImeWindowStatus(final int displayId, final int vis, final int backDisposition, final boolean showImeSwitcher) {
        enforceStatusBar();
        enforceValidCallingUser();
        Object r1 = this.mLock;
        monitor-enter(r1);
        UiState.m8411$$Nest$msetImeWindowState(getUiState(displayId), vis, backDisposition, showImeSwitcher);     // Catch: Throwable -> L11
        Handler r0 = this.mHandler;     // Catch: Throwable -> L11
        r0.post(new StatusBarManagerService$$ExternalSyntheticLambda7(this, displayId, vis, backDisposition, showImeSwitcher));     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        Throwable r9 = th;
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L9
        throw r9;
    L11:
        th = move-exception;
        r9 = th;
        goto L13
    }

    private /* synthetic */ void lambda$setImeWindowStatus$2(int displayId, int vis, int backDisposition, boolean showImeSwitcher) {
        IStatusBar bar = this.mBar;
        if (bar == null) goto L10;
        bar.setImeWindowStatus(displayId, vis, backDisposition, showImeSwitcher);     // Catch: RemoteException -> L6
        return;
    L7:
        return;
    }

    private void setDisableFlags(int displayId, int flags, String cause) {
        if (isVisibleBackgroundUserOnDisplay(displayId) == false) goto L5;
        return;
    L5:
        enforceStatusBarService();
        int unknownFlags = flags & (-134152193);
        if (unknownFlags == 0) goto L8;
        Slog.e(TAG, "Unknown disable flags: 0x" + Integer.toHexString(unknownFlags), new RuntimeException());
    L8:
        Object r2 = this.mLock;
        monitor-enter(r2);
        disableLocked(displayId, this.mCurrentUserId, flags, this.mSysUiVisToken, cause, 1);     // Catch: Throwable -> L15
        monitor-exit(r2);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        Throwable r11 = th;
    L19:
        monitor-exit(r2);     // Catch: Throwable -> L15
        throw r11;
    L17:
        th = move-exception;
        r11 = th;
        goto L19
    }

    private UiState getUiState(int displayId) {
        UiState state = this.mDisplayUiState.get(displayId);
        if (state != null) goto L6;
        UiState state2 = new UiState(null);
        this.mDisplayUiState.put(displayId, state2);
        return state2;
    L6:
        return state;
    }

    private void enforceStatusBarOrShell() {
        if (Binder.getCallingUid() != 2000) goto L5;
        return;
    L5:
        enforceStatusBar();
    }

    private void enforceStatusBar() {
        this.mContext.enforceCallingOrSelfPermission("android.permission.STATUS_BAR", TAG);
    }

    private void enforceExpandStatusBar() {
        this.mContext.enforceCallingOrSelfPermission("android.permission.EXPAND_STATUS_BAR", TAG);
    }

    private void enforceStatusBarService() {
        this.mContext.enforceCallingOrSelfPermission("android.permission.STATUS_BAR_SERVICE", TAG);
    }

    private void enforceBiometricDialog() {
        this.mContext.enforceCallingOrSelfPermission("android.permission.MANAGE_BIOMETRIC_DIALOG", TAG);
    }

    private void enforceMediaContentControl() {
        this.mContext.enforceCallingOrSelfPermission("android.permission.MEDIA_CONTENT_CONTROL", TAG);
    }

    private void enforceControlDeviceStatePermission() {
        this.mContext.enforceCallingOrSelfPermission("android.permission.CONTROL_DEVICE_STATE", TAG);
    }

    private boolean doesCallerHoldInteractAcrossUserPermission() {
        if (this.mContext.checkCallingPermission("android.permission.INTERACT_ACROSS_USERS_FULL") != 0) goto L5;
    L8:
        return true;
    L5:
        if (this.mContext.checkCallingPermission("android.permission.INTERACT_ACROSS_USERS") == 0) goto L8;
        return false;
    }

    private boolean checkCanCollapseStatusBar(String method) {
        int uid = Binder.getCallingUid();
        int pid = Binder.getCallingPid();
        if (CompatChanges.isChangeEnabled(LOCK_DOWN_COLLAPSE_STATUS_BAR, uid) == false) goto L6;
        enforceStatusBar();
        return true;
    L6:
        if (this.mContext.checkPermission("android.permission.STATUS_BAR", pid, uid) == 0) goto L13;
        enforceExpandStatusBar();
        if (this.mActivityTaskManager.canCloseSystemDialogs(pid, uid) == true) goto L14;
        Slog.e(TAG, "Permission Denial: Method " + method + "() requires permission android.permission.STATUS_BAR, ignoring call.");
        return false;
    L14:
        return true;
    L13:
        return true;
    }

    public RegisterStatusBarResult registerStatusBar(IStatusBar bar) {
        enforceStatusBarService();
        enforceValidCallingUser();
        Slog.i(TAG, "registerStatusBar bar=" + bar);
        this.mBar = bar;
        this.mDeathRecipient.linkToDeath();
        notifyBarAttachChanged();
        ArrayMap<String, StatusBarIcon> r3 = this.mIcons;
        monitor-enter(r3);
        ArrayMap<String, StatusBarIcon> icons = new ArrayMap(this.mIcons);     // Catch: Throwable -> L14
        monitor-exit(r3);     // Catch: Throwable -> L14
        Object r4 = this.mLock;
        monitor-enter(r4);
        UiState state = this.mDisplayUiState.get(0);     // Catch: Throwable -> L11
        RegisterStatusBarResult r5 = new RegisterStatusBarResult(icons, gatherDisableActionsLocked(this.mCurrentUserId, 1), UiState.m8394$$Nest$fgetmAppearance(state), UiState.m8395$$Nest$fgetmAppearanceRegions(state), UiState.m8398$$Nest$fgetmImeWindowVis(state), UiState.m8397$$Nest$fgetmImeBackDisposition(state), UiState.m8403$$Nest$fgetmShowImeSwitcher(state), gatherDisableActionsLocked(this.mCurrentUserId, 2), UiState.m8400$$Nest$fgetmNavbarColorManagedByIme(state), UiState.m8396$$Nest$fgetmBehavior(state), UiState.m8402$$Nest$fgetmRequestedVisibleTypes(state), UiState.m8401$$Nest$fgetmPackageName(state), UiState.m8404$$Nest$fgetmTransientBarTypes(state), UiState.m8399$$Nest$fgetmLetterboxDetails(state));     // Catch: Throwable -> L11
        monitor-exit(r4);     // Catch: Throwable -> L11
        return r5;
    L11:
        th = move-exception;
        throw th;
    L14:
        th = move-exception;
        throw th;
    }

    public Map<String, RegisterStatusBarResult> registerStatusBarForAllDisplays(IStatusBar bar) {
        enforceStatusBarService();
        enforceValidCallingUser();
        Slog.i(TAG, "registerStatusBarForAllDisplays bar=" + bar);
        this.mBar = bar;
        this.mDeathRecipient.linkToDeath();
        notifyBarAttachChanged();
        Object r3 = this.mLock;
        monitor-enter(r3);
        Map<String, RegisterStatusBarResult> results = new HashMap();     // Catch: Throwable -> L14
        int i = 0;
    L6:
        if (i >= this.mDisplayUiState.size()) goto L21;
        int displayId = this.mDisplayUiState.keyAt(i);     // Catch: Throwable -> L14
        UiState state = this.mDisplayUiState.get(displayId);     // Catch: Throwable -> L14
        ArrayMap<String, StatusBarIcon> r8 = this.mIcons;     // Catch: Throwable -> L14
        monitor-enter(r8);     // Catch: Throwable -> L14
        ArrayMap<String, StatusBarIcon> icons = new ArrayMap(this.mIcons);     // Catch: Throwable -> L17
        monitor-exit(r8);     // Catch: Throwable -> L17
        if (state == null) goto L16;
        results.put(String.valueOf(displayId), new RegisterStatusBarResult(icons, gatherDisableActionsLocked(this.mCurrentUserId, 1), UiState.m8394$$Nest$fgetmAppearance(state), UiState.m8395$$Nest$fgetmAppearanceRegions(state), UiState.m8398$$Nest$fgetmImeWindowVis(state), UiState.m8397$$Nest$fgetmImeBackDisposition(state), UiState.m8403$$Nest$fgetmShowImeSwitcher(state), gatherDisableActionsLocked(this.mCurrentUserId, 2), UiState.m8400$$Nest$fgetmNavbarColorManagedByIme(state), UiState.m8396$$Nest$fgetmBehavior(state), UiState.m8402$$Nest$fgetmRequestedVisibleTypes(state), UiState.m8401$$Nest$fgetmPackageName(state), UiState.m8404$$Nest$fgetmTransientBarTypes(state), UiState.m8399$$Nest$fgetmLetterboxDetails(state)));     // Catch: Throwable -> L14
    L16:
        i = i + 1;
        goto L6
    L17:
        th = move-exception;
        throw th;     // Catch: Throwable -> L14
    L21:
        monitor-exit(r3);     // Catch: Throwable -> L14
        return results;
    L14:
        th = move-exception;
        throw th;
    }

    private void notifyBarAttachChanged() {
        UiThread.getHandler().post(new StatusBarManagerService$$ExternalSyntheticLambda2(this));
        this.mHandler.post(new StatusBarManagerService$$ExternalSyntheticLambda3(this));
    }

    private /* synthetic */ void lambda$notifyBarAttachChanged$3() {
        if (this.mGlobalActionListener != null) goto L5;
        return;
    L5:
        GlobalActionsProvider.GlobalActionsListener r0 = this.mGlobalActionListener;
        if (this.mBar == null) goto L8;
        boolean r1 = true;
    L9:
        r0.onGlobalActionsAvailableChanged(r1);
        return;
    L8:
        r1 = false;
        goto L9
    }

    private /* synthetic */ void lambda$notifyBarAttachChanged$4() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        setUdfpsRefreshRateCallback(this.mUdfpsRefreshRateRequestCallback);     // Catch: Throwable -> L7
        setBiometicContextListener(this.mBiometricContextListener);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void registerOverlayManager(IOverlayManager overlayManager) {
        this.mOverlayManager = overlayManager;
    }

    public void onPanelRevealed(boolean clearNotificationEffects, int numItems) {
        enforceStatusBarService();
        enforceValidCallingUser();
        long identity = Binder.clearCallingIdentity();
        this.mNotificationDelegate.onPanelRevealed(clearNotificationEffects, numItems);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(identity);
        return;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    public void clearNotificationEffects() throws RemoteException {
        enforceStatusBarService();
        enforceValidCallingUser();
        long identity = Binder.clearCallingIdentity();
        this.mNotificationDelegate.clearEffects();     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(identity);
        return;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    public void onPanelHidden() throws RemoteException {
        enforceStatusBarService();
        enforceValidCallingUser();
        long identity = Binder.clearCallingIdentity();
        this.mNotificationDelegate.onPanelHidden();     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(identity);
        return;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    public void shutdown() {
        enforceStatusBarService();
        enforceValidCallingUser();
        final String reason = "userrequested";
        ShutdownCheckPoints.recordCheckPoint(Binder.getCallingPid(), "userrequested");
        long identity = Binder.clearCallingIdentity();
        this.mNotificationDelegate.prepareForPossibleShutdown();     // Catch: Throwable -> L6
        this.mHandler.post(new StatusBarManagerService$$ExternalSyntheticLambda1(reason));     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(identity);
        return;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    private static /* synthetic */ void lambda$shutdown$5(String reason) {
        ShutdownThread.shutdown(getUiContext(), reason, false);
    }

    public void reboot(final boolean safeMode) {
        enforceStatusBarService();
        enforceValidCallingUser();
        if (safeMode == false) goto L5;
        final String reason = "safemode";
    L6:
        ShutdownCheckPoints.recordCheckPoint(Binder.getCallingPid(), reason);
        long identity = Binder.clearCallingIdentity();
        this.mNotificationDelegate.prepareForPossibleShutdown();     // Catch: Throwable -> L10
        this.mHandler.post(new StatusBarManagerService$$ExternalSyntheticLambda6(safeMode, reason));     // Catch: Throwable -> L10
        Binder.restoreCallingIdentity(identity);
        return;
    L10:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    L5:
        reason = "userrequested";
        goto L6
    }

    private static /* synthetic */ void lambda$reboot$6(boolean safeMode, String reason) {
        if (safeMode == false) goto L4;
        ShutdownThread.rebootSafeMode(getUiContext(), true);
        return;
    L4:
        ShutdownThread.reboot(getUiContext(), reason, false);
    }

    public void restart() {
        enforceStatusBarService();
        enforceValidCallingUser();
        long identity = Binder.clearCallingIdentity();
        this.mHandler.post(new StatusBarManagerService$$ExternalSyntheticLambda5(this));     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(identity);
        return;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    private /* synthetic */ void lambda$restart$7() {
        this.mActivityManagerInternal.restart();
    }

    public void onGlobalActionsShown() {
        enforceStatusBarService();
        enforceValidCallingUser();
        long identity = Binder.clearCallingIdentity();
    L10:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    L4:
        if (this.mGlobalActionListener != null) goto L7;
        Binder.restoreCallingIdentity(identity);
        return;
    L7:
        this.mGlobalActionListener.onGlobalActionsShown();     // Catch: Throwable -> L10
        Binder.restoreCallingIdentity(identity);
    }

    public void onGlobalActionsHidden() {
        enforceStatusBarService();
        enforceValidCallingUser();
        long identity = Binder.clearCallingIdentity();
    L10:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    L4:
        if (this.mGlobalActionListener != null) goto L7;
        Binder.restoreCallingIdentity(identity);
        return;
    L7:
        this.mGlobalActionListener.onGlobalActionsDismissed();     // Catch: Throwable -> L10
        Binder.restoreCallingIdentity(identity);
    }

    public void onNotificationClick(String key, NotificationVisibility nv) {
        enforceStatusBarService();
        int callingUid = Binder.getCallingUid();
        int callingPid = Binder.getCallingPid();
        long identity = Binder.clearCallingIdentity();
        this.mNotificationDelegate.onNotificationClick(callingUid, callingPid, key, nv);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(identity);
        return;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    public void onNotificationActionClick(String key, int actionIndex, Notification.Action action, NotificationVisibility nv, boolean generatedByAssistant) {
        enforceStatusBarService();
        int callingUid = Binder.getCallingUid();
        int callingPid = Binder.getCallingPid();
        long identity = Binder.clearCallingIdentity();
        this.mNotificationDelegate.onNotificationActionClick(callingUid, callingPid, key, actionIndex, action, nv, generatedByAssistant);     // Catch: Throwable -> L8
        Binder.restoreCallingIdentity(identity);
        return;
    L8:
        th = move-exception;
        Throwable r11 = th;
    L12:
        Binder.restoreCallingIdentity(identity);
        throw r11;
    L10:
        th = move-exception;
        r11 = th;
        goto L12
    }

    public void onNotificationError(String pkg, String tag, int id, int uid, int initialPid, String message, int userId) {
        enforceStatusBarService();
        int callingUid = Binder.getCallingUid();
        int callingPid = Binder.getCallingPid();
        long identity = Binder.clearCallingIdentity();
        this.mNotificationDelegate.onNotificationError(callingUid, callingPid, pkg, tag, id, uid, initialPid, message, userId);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(identity);
        return;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    public void onNotificationClear(String pkg, int userId, String key, int dismissalSurface, int dismissalSentiment, NotificationVisibility nv) {
        enforceStatusBarService();
        int callingUid = Binder.getCallingUid();
        int callingPid = Binder.getCallingPid();
        long identity = Binder.clearCallingIdentity();
        this.mNotificationDelegate.onNotificationClear(callingUid, callingPid, pkg, userId, key, dismissalSurface, dismissalSentiment, nv);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(identity);
        return;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    public void onNotificationVisibilityChanged(NotificationVisibility[] newlyVisibleKeys, NotificationVisibility[] noLongerVisibleKeys) throws RemoteException {
        enforceStatusBarService();
        enforceValidCallingUser();
        long identity = Binder.clearCallingIdentity();
        this.mNotificationDelegate.onNotificationVisibilityChanged(newlyVisibleKeys, noLongerVisibleKeys);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(identity);
        return;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    public void onNotificationExpansionChanged(String key, boolean userAction, boolean expanded, int location) throws RemoteException {
        enforceStatusBarService();
        enforceValidCallingUser();
        long identity = Binder.clearCallingIdentity();
        this.mNotificationDelegate.onNotificationExpansionChanged(key, userAction, expanded, location);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(identity);
        return;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    public void onNotificationDirectReplied(String key) throws RemoteException {
        enforceStatusBarService();
        enforceValidCallingUser();
        long identity = Binder.clearCallingIdentity();
        this.mNotificationDelegate.onNotificationDirectReplied(key);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(identity);
        return;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    public void onNotificationSmartSuggestionsAdded(String key, int smartReplyCount, int smartActionCount, boolean generatedByAssistant, boolean editBeforeSending) {
        enforceStatusBarService();
        enforceValidCallingUser();
        long identity = Binder.clearCallingIdentity();
        this.mNotificationDelegate.onNotificationSmartSuggestionsAdded(key, smartReplyCount, smartActionCount, generatedByAssistant, editBeforeSending);     // Catch: Throwable -> L8
        Binder.restoreCallingIdentity(identity);
        return;
    L8:
        th = move-exception;
        Throwable r10 = th;
    L12:
        Binder.restoreCallingIdentity(identity);
        throw r10;
    L10:
        th = move-exception;
        r10 = th;
        goto L12
    }

    public void onNotificationSmartReplySent(String key, int replyIndex, CharSequence reply, int notificationLocation, boolean modifiedBeforeSending) throws RemoteException {
        enforceStatusBarService();
        enforceValidCallingUser();
        long identity = Binder.clearCallingIdentity();
        this.mNotificationDelegate.onNotificationSmartReplySent(key, replyIndex, reply, notificationLocation, modifiedBeforeSending);     // Catch: Throwable -> L8
        Binder.restoreCallingIdentity(identity);
        return;
    L8:
        th = move-exception;
        Throwable r10 = th;
    L12:
        Binder.restoreCallingIdentity(identity);
        throw r10;
    L10:
        th = move-exception;
        r10 = th;
        goto L12
    }

    public void onNotificationSettingsViewed(String key) throws RemoteException {
        enforceStatusBarService();
        enforceValidCallingUser();
        long identity = Binder.clearCallingIdentity();
        this.mNotificationDelegate.onNotificationSettingsViewed(key);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(identity);
        return;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    public void onClearAllNotifications(int userId) {
        enforceStatusBarService();
        int callingUid = Binder.getCallingUid();
        int callingPid = Binder.getCallingPid();
        long identity = Binder.clearCallingIdentity();
        this.mNotificationDelegate.onClearAll(callingUid, callingPid, userId);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(identity);
        return;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    public void onNotificationBubbleChanged(String key, boolean isBubble, int flags) {
        enforceStatusBarService();
        enforceValidCallingUser();
        long identity = Binder.clearCallingIdentity();
        this.mNotificationDelegate.onNotificationBubbleChanged(key, isBubble, flags);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(identity);
        return;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    public void onBubbleMetadataFlagChanged(String key, int flags) {
        enforceStatusBarService();
        enforceValidCallingUser();
        long identity = Binder.clearCallingIdentity();
        this.mNotificationDelegate.onBubbleMetadataFlagChanged(key, flags);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(identity);
        return;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    public void hideCurrentInputMethodForBubbles(int displayId) {
        enforceStatusBarService();
        enforceValidCallingUser();
        long token = Binder.clearCallingIdentity();
        InputMethodManagerInternal.get().hideInputMethod(20, displayId);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(token);
        return;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    public void grantInlineReplyUriPermission(String key, Uri uri, UserHandle user, String packageName) {
        enforceStatusBarService();
        int callingUid = Binder.getCallingUid();
        long identity = Binder.clearCallingIdentity();
        this.mNotificationDelegate.grantInlineReplyUriPermission(key, uri, user, packageName, callingUid);     // Catch: Throwable -> L8
        Binder.restoreCallingIdentity(identity);
        return;
    L8:
        th = move-exception;
        Throwable r9 = th;
    L12:
        Binder.restoreCallingIdentity(identity);
        throw r9;
    L10:
        th = move-exception;
        r9 = th;
        goto L12
    }

    public void clearInlineReplyUriPermissions(String key) {
        enforceStatusBarService();
        int callingUid = Binder.getCallingUid();
        long identity = Binder.clearCallingIdentity();
        this.mNotificationDelegate.clearInlineReplyUriPermissions(key, callingUid);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(identity);
        return;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    public void onNotificationFeedbackReceived(String key, Bundle feedback) {
        enforceStatusBarService();
        enforceValidCallingUser();
        long identity = Binder.clearCallingIdentity();
        this.mNotificationDelegate.onNotificationFeedbackReceived(key, feedback);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(identity);
        return;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onShellCommand(FileDescriptor in, FileDescriptor out, FileDescriptor err, String[] args, ShellCallback callback, ResultReceiver resultReceiver) {
        new StatusBarShellCommand(this, this.mContext).exec(this, in, out, err, args, callback, resultReceiver);
    }

    public void showInattentiveSleepWarning() {
        enforceStatusBarService();
        enforceValidCallingUser();
        IStatusBar bar = this.mBar;
        if (bar == null) goto L10;
        bar.showInattentiveSleepWarning();     // Catch: RemoteException -> L6
        return;
    L7:
        return;
    }

    public void dismissInattentiveSleepWarning(boolean animated) {
        enforceStatusBarService();
        enforceValidCallingUser();
        IStatusBar bar = this.mBar;
        if (bar == null) goto L10;
        bar.dismissInattentiveSleepWarning(animated);     // Catch: RemoteException -> L6
        return;
    L7:
        return;
    }

    public void suppressAmbientDisplay(boolean suppress) {
        enforceStatusBarService();
        enforceValidCallingUser();
        IStatusBar bar = this.mBar;
        if (bar == null) goto L10;
        bar.suppressAmbientDisplay(suppress);     // Catch: RemoteException -> L6
        return;
    L7:
        return;
    }

    private void checkCallingUidPackage(String packageName, int callingUid, int userId) {
        int packageUid = this.mPackageManagerInternal.getPackageUid(packageName, 0, userId);
        if (UserHandle.getAppId(callingUid) != UserHandle.getAppId(packageUid)) goto L6;
        return;
    L6:
        throw new SecurityException("Package " + packageName + " does not belong to the calling uid " + callingUid);
    }

    private ResolveInfo isComponentValidTileService(ComponentName componentName, int userId) {
        Intent intent = new Intent("android.service.quicksettings.action.QS_TILE");
        intent.setComponent(componentName);
        ResolveInfo r = this.mPackageManagerInternal.resolveService(intent, intent.resolveTypeIfNeeded(this.mContext.getContentResolver()), 0, userId, Process.myUid());
        int enabled = this.mPackageManagerInternal.getComponentEnabledSetting(componentName, Process.myUid(), userId);
        if (r != null) goto L5;
        return null;
    L5:
        if (r.serviceInfo != null) goto L7;
        return null;
    L7:
        if (resolveEnabledComponent(r.serviceInfo.enabled, enabled) == true) goto L9;
        return null;
    L9:
        if ("android.permission.BIND_QUICK_SETTINGS_TILE".equals(r.serviceInfo.permission) == false) goto L15;
        return r;
    L15:
        return null;
    }

    private boolean resolveEnabledComponent(boolean defaultValue, int pmResult) {
        if (pmResult != 1) goto L5;
        return true;
    L5:
        if (pmResult != 0) goto L7;
        return defaultValue;
    L7:
        return false;
    }

    public void requestTileServiceListeningState(ComponentName componentName, int userId) {
        int callingUid = Binder.getCallingUid();
        String packageName = componentName.getPackageName();
        boolean mustPerformChecks = CompatChanges.isChangeEnabled(REQUEST_LISTENING_MUST_MATCH_PACKAGE, callingUid);
        if (mustPerformChecks == false) goto L12;
        int userId2 = this.mActivityManagerInternal.handleIncomingUser(Binder.getCallingPid(), callingUid, userId, false, 0, "requestTileServiceListeningState", packageName);
        checkCallingUidPackage(packageName, callingUid, userId2);
        int currentUser = this.mActivityManagerInternal.getCurrentUserId();
        if (userId2 == currentUser) goto L12;
        if (CompatChanges.isChangeEnabled(REQUEST_LISTENING_OTHER_USER_NOOP, callingUid) == false) goto L10;
        return;
    L10:
        throw new IllegalArgumentException("User " + userId2 + " is not the current user.");
    L12:
        IStatusBar bar = this.mBar;
        if (bar == null) goto L21;
        bar.requestTileServiceListeningState(componentName);     // Catch: RemoteException -> L16
        return;
    L16:
        e = move-exception;
        Slog.e(TAG, "requestTileServiceListeningState", e);
        return;
    }

    public void requestAddTile(final ComponentName componentName, CharSequence label, Icon icon, final int userId, final IAddTileResultCallback callback) {
        int callingUid = Binder.getCallingUid();
        final String packageName = componentName.getPackageName();
        this.mActivityManagerInternal.handleIncomingUser(Binder.getCallingPid(), callingUid, userId, false, 0, "requestAddTile", packageName);
        checkCallingUidPackage(packageName, callingUid, userId);
        int currentUser = this.mActivityManagerInternal.getCurrentUserId();
        if (userId != currentUser) goto L88;
        ResolveInfo r = isComponentValidTileService(componentName, userId);
        if (r == null) goto L86;
        if (r.serviceInfo.exported == false) goto L86;
        int procState = this.mActivityManagerInternal.getUidProcessState(callingUid);
        if (ActivityManager.RunningAppProcessInfo.procStateToImportance(procState) != 100) goto L92;
        ArrayMap<String, Long> r4 = this.mCurrentRequestAddTilePackages;
        monitor-enter(r4);
        Long lastTime = this.mCurrentRequestAddTilePackages.get(packageName);     // Catch: Throwable -> L67
        long currentTime = System.nanoTime();     // Catch: Throwable -> L67
        if (lastTime != null) goto L94;
    L39:
        if (lastTime == null) goto L41;
        cancelRequestAddTileInternal(packageName);     // Catch: Throwable -> L33
    L41:
        this.mCurrentRequestAddTilePackages.put(packageName, Long.valueOf(currentTime));     // Catch: Throwable -> L67
        monitor-exit(r4);     // Catch: Throwable -> L67
        if (this.mTileRequestTracker.shouldBeDenied(userId, componentName) == true) goto L46;
        IAddTileResultCallback.Stub r0 = new AnonymousClass3(this, userId, componentName, packageName, callback);
        CharSequence appName = r.serviceInfo.applicationInfo.loadLabel(this.mContext.getPackageManager());
        IStatusBar bar = this.mBar;
        if (bar != null) goto L95;
    L61:
        clearTileAddRequest(packageName);
        callback.onTileRequest(1005);     // Catch: RemoteException -> L64
        return;
    L64:
        e = move-exception;
        Slog.e(TAG, "requestAddTile", e);
        return;
    L95:
        bar.requestAddTile(callingUid, componentName, appName, label, icon, r0);     // Catch: RemoteException -> L59
        return;
    L59:
        e = move-exception;
        Slog.e(TAG, "requestAddTile", e);
        goto L61
    L46:
        if (clearTileAddRequest(packageName) == true) goto L80;
        return;
    L80:
        callback.onTileRequest(0);     // Catch: RemoteException -> L50
        return;
    L50:
        e = move-exception;
        Slog.e(TAG, "requestAddTile - callback", e);
        return;
    L94:
    L33:
        th = th;
    L90:
        monitor-exit(r4);     // Catch: Throwable -> L71
        throw th;
    L71:
        th = th;
        goto L90
    L29:
        if ((currentTime - lastTime.longValue()) >= REQUEST_TIME_OUT) goto L39;
        callback.onTileRequest(1001);     // Catch: Throwable -> L33 RemoteException -> L35
    L37:
        monitor-exit(r4);     // Catch: Throwable -> L33
        return;
    L35:
        e = move-exception;
        Slog.e(TAG, "requestAddTile", e);     // Catch: Throwable -> L33
    L67:
        th = th;
        goto L90
    L92:
        callback.onTileRequest(1004);     // Catch: RemoteException -> L20
        return;
    L20:
        e = move-exception;
        Slog.e(TAG, "requestAddTile", e);
        return;
    L86:
        callback.onTileRequest(1002);     // Catch: RemoteException -> L77
        return;
    L77:
        e = move-exception;
        Slog.e(TAG, "requestAddTile", e);
        return;
    L88:
        callback.onTileRequest(1003);     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        Slog.e(TAG, "requestAddTile", e);
    }

    public void cancelRequestAddTile(String packageName) {
        enforceStatusBar();
        enforceValidCallingUser();
        cancelRequestAddTileInternal(packageName);
    }

    private void cancelRequestAddTileInternal(String packageName) {
        clearTileAddRequest(packageName);
        IStatusBar bar = this.mBar;
        if (bar == null) goto L11;
        bar.cancelRequestAddTile(packageName);     // Catch: RemoteException -> L6
        return;
    L6:
        e = move-exception;
        Slog.e(TAG, "requestAddTile", e);
        return;
    }

    private boolean clearTileAddRequest(String packageName) {
        ArrayMap<String, Long> r0 = this.mCurrentRequestAddTilePackages;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.mCurrentRequestAddTilePackages.remove(packageName) == null) goto L7;
        boolean r1 = true;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r1;
    L7:
        r1 = false;
        goto L8
    }

    public void onSessionStarted(int sessionType, InstanceId instance) {
        enforceValidCallingUser();
        this.mSessionMonitor.onSessionStarted(sessionType, instance);
    }

    public void onSessionEnded(int sessionType, InstanceId instance) {
        enforceValidCallingUser();
        this.mSessionMonitor.onSessionEnded(sessionType, instance);
    }

    public void registerSessionListener(int sessionFlags, ISessionListener listener) {
        enforceValidCallingUser();
        this.mSessionMonitor.registerSessionListener(sessionFlags, listener);
    }

    public void unregisterSessionListener(int sessionFlags, ISessionListener listener) {
        enforceValidCallingUser();
        this.mSessionMonitor.unregisterSessionListener(sessionFlags, listener);
    }

    public String[] getStatusBarIcons() {
        return this.mContext.getResources().getStringArray(R.array.config_verizon_satellite_enabled_tagids);
    }

    public void setNavBarMode(int navBarMode) {
        enforceStatusBar();
        enforceValidCallingUser();
        if (navBarMode == 0) goto L8;
        if (navBarMode == 1) goto L8;
        throw new IllegalArgumentException("Supplied navBarMode not supported: " + navBarMode);
    L8:
        int userId = this.mCurrentUserId;
        int callingUserId = UserHandle.getUserId(Binder.getCallingUid());
        if (this.mCurrentUserId != callingUserId) goto L11;
    L15:
        long userIdentity = Binder.clearCallingIdentity();
        Settings.Secure.putIntForUser(this.mContext.getContentResolver(), "nav_bar_kids_mode", navBarMode, userId);     // Catch: Throwable -> L23 RemoteException -> L25
        Settings.Secure.putIntForUser(this.mContext.getContentResolver(), "nav_bar_force_visible", navBarMode, userId);     // Catch: Throwable -> L23 RemoteException -> L25
        IOverlayManager overlayManager = getOverlayManager();     // Catch: Throwable -> L23 RemoteException -> L25
        if (overlayManager == null) goto L27;
        if (navBarMode != 1) goto L27;
        if (isPackageSupported("com.android.internal.systemui.navbar.threebutton") == false) goto L27;
        overlayManager.setEnabledExclusiveInCategory("com.android.internal.systemui.navbar.threebutton", userId);     // Catch: Throwable -> L23 RemoteException -> L25
    L27:
        Binder.restoreCallingIdentity(userIdentity);
        return;
    L25:
        e = move-exception;
        throw e.rethrowFromSystemServer();     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        Binder.restoreCallingIdentity(userIdentity);
        throw th;
    L11:
        if (doesCallerHoldInteractAcrossUserPermission() == true) goto L15;
        throw new SecurityException("Calling user id: " + callingUserId + ", cannot call on behalf of current user id: " + this.mCurrentUserId + ".");
    }

    public int getNavBarMode() {
        enforceStatusBar();
        int userId = this.mCurrentUserId;
        long userIdentity = Binder.clearCallingIdentity();
        int navBarKidsMode = Settings.Secure.getIntForUser(this.mContext.getContentResolver(), "nav_bar_kids_mode", userId);     // Catch: Throwable -> L6 Settings.SettingNotFoundException -> L8
        Binder.restoreCallingIdentity(userIdentity);
        return navBarKidsMode;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(userIdentity);
        throw th;
    L12:
        Binder.restoreCallingIdentity(userIdentity);
        return 0;
    }

    private boolean isPackageSupported(String packageName) {
        if (packageName != null) goto L11;
        return false;
    L11:
        if (this.mContext.getPackageManager().getPackageInfo(packageName, PackageManager.PackageInfoFlags.of(0)) == null) goto L13;
        return true;
    L13:
        return false;
    L10:
        return false;
    }

    public void updateMediaTapToTransferSenderDisplay(int displayState, MediaRoute2Info routeInfo, IUndoMediaTransferCallback undoCallback) {
        enforceMediaContentControl();
        enforceValidCallingUser();
        IStatusBar bar = this.mBar;
        if (bar == null) goto L11;
        bar.updateMediaTapToTransferSenderDisplay(displayState, routeInfo, undoCallback);     // Catch: RemoteException -> L6
        return;
    L6:
        e = move-exception;
        Slog.e(TAG, "updateMediaTapToTransferSenderDisplay", e);
        return;
    }

    public void updateMediaTapToTransferReceiverDisplay(int displayState, MediaRoute2Info routeInfo, Icon appIcon, CharSequence appName) {
        enforceMediaContentControl();
        enforceValidCallingUser();
        IStatusBar bar = this.mBar;
        if (bar == null) goto L11;
        bar.updateMediaTapToTransferReceiverDisplay(displayState, routeInfo, appIcon, appName);     // Catch: RemoteException -> L6
        return;
    L6:
        e = move-exception;
        Slog.e(TAG, "updateMediaTapToTransferReceiverDisplay", e);
        return;
    }

    public void registerNearbyMediaDevicesProvider(INearbyMediaDevicesProvider provider) {
        enforceMediaContentControl();
        enforceValidCallingUser();
        IStatusBar bar = this.mBar;
        if (bar == null) goto L11;
        bar.registerNearbyMediaDevicesProvider(provider);     // Catch: RemoteException -> L6
        return;
    L6:
        e = move-exception;
        Slog.e(TAG, "registerNearbyMediaDevicesProvider", e);
        return;
    }

    public void unregisterNearbyMediaDevicesProvider(INearbyMediaDevicesProvider provider) {
        enforceMediaContentControl();
        enforceValidCallingUser();
        IStatusBar bar = this.mBar;
        if (bar == null) goto L11;
        bar.unregisterNearbyMediaDevicesProvider(provider);     // Catch: RemoteException -> L6
        return;
    L6:
        e = move-exception;
        Slog.e(TAG, "unregisterNearbyMediaDevicesProvider", e);
        return;
    }

    public void showRearDisplayDialog(int currentState) {
        enforceControlDeviceStatePermission();
        enforceValidCallingUser();
        IStatusBar bar = this.mBar;
        if (bar == null) goto L11;
        bar.showRearDisplayDialog(currentState);     // Catch: RemoteException -> L6
        return;
    L6:
        e = move-exception;
        Slog.e(TAG, "showRearDisplayDialog", e);
        return;
    }

    public void passThroughShellCommand(String[] args, FileDescriptor fd) {
        enforceStatusBarOrShell();
        if (this.mBar != null) goto L19;
        return;
    L19:
        TransferPipe tp = new TransferPipe();     // Catch: Throwable -> L9
        tp.setBufferPrefix("  ");     // Catch: Throwable -> L11
        this.mBar.passThroughShellCommand(args, tp.getWriteFd());     // Catch: Throwable -> L11
        tp.go(fd);     // Catch: Throwable -> L11
        tp.close();     // Catch: Throwable -> L9
        return;
    L11:
        th = move-exception;
        tp.close();     // Catch: Throwable -> L14
    L16:
        throw th;     // Catch: Throwable -> L9
    L14:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L9
    L9:
        t = move-exception;
        Slog.e(TAG, "Error sending command to IStatusBar", t);
    }

    void manageDisableListLocked(int userId, int what, IBinder token, String pkg, int which) {
        Pair<Integer, DisableRecord> match = findMatchingRecordLocked(token, userId);
        int i = ((Integer) match.first).intValue();
        DisableRecord record = (DisableRecord) match.second;
        if (token.isBinderAlive() == true) goto L7;
        if (record == null) goto L14;
        this.mDisableRecords.remove(i);
        record.token.unlinkToDeath(record, 0);
        return;
    L14:
        return;
    L7:
        if (record == null) goto L12;
        record.setFlags(what, which, pkg);
        if (record.isEmpty() == false) goto L15;
        this.mDisableRecords.remove(i);
        record.token.unlinkToDeath(record, 0);
        return;
    L15:
        return;
    L12:
        DisableRecord record2 = new DisableRecord(this, userId, token);
        record2.setFlags(what, which, pkg);
        this.mDisableRecords.add(record2);
    }

    private Pair<Integer, DisableRecord> findMatchingRecordLocked(IBinder token, int userId) {
        int numRecords = this.mDisableRecords.size();
        DisableRecord record = null;
        int i = 0;
    L3:
        if (i >= numRecords) goto L11;
        DisableRecord r = this.mDisableRecords.get(i);
        if (r.token != token) goto L9;
        if (r.userId != userId) goto L9;
        record = r;
    L9:
        i = i + 1;
    L11:
        return new Pair(Integer.valueOf(i), record);
    }

    int gatherDisableActionsLocked(int userId, int which) {
        int N = this.mDisableRecords.size();
        int net = 0;
        int i = 0;
    L3:
        if (i >= N) goto L9;
        DisableRecord rec = this.mDisableRecords.get(i);
        if (rec.userId != userId) goto L7;
        net = net | rec.getFlags(which);
    L7:
        i = i + 1;
        goto L3
    L9:
        return net;
    }

    protected void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
        if (DumpUtils.checkDumpPermission(this.mContext, TAG, pw) == true) goto L5;
        return;
    L5:
        boolean proto = false;
        int i = 0;
    L7:
        if (i >= args.length) goto L13;
        if ("--proto".equals(args[i]) == false) goto L11;
        proto = true;
    L11:
        i = i + 1;
        goto L7
    L13:
        if (proto == true) goto L15;
        Object r1 = this.mLock;
        monitor-enter(r1);
        int i2 = 0;
    L66:
    L37:
        th = move-exception;
        throw th;
    L35:
        if (i2 >= this.mDisplayUiState.size()) goto L39;
        int key = this.mDisplayUiState.keyAt(i2);     // Catch: Throwable -> L37
        UiState state = this.mDisplayUiState.get(key);     // Catch: Throwable -> L37
        pw.println("  displayId=" + key);     // Catch: Throwable -> L37
        pw.println("    mDisabled1=0x" + Integer.toHexString(UiState.m8407$$Nest$mgetDisabled1(state)));     // Catch: Throwable -> L37
        pw.println("    mDisabled2=0x" + Integer.toHexString(UiState.m8408$$Nest$mgetDisabled2(state)));     // Catch: Throwable -> L37
        i2 = i2 + 1;     // Catch: Throwable -> L37
        goto L66
    L39:
        int N = this.mDisableRecords.size();     // Catch: Throwable -> L37
        pw.println("  mDisableRecords.size=" + N);     // Catch: Throwable -> L37
        int i3 = 0;
    L40:
        if (i3 >= N) goto L42;
        DisableRecord tok = this.mDisableRecords.get(i3);     // Catch: Throwable -> L37
        pw.println("    [" + i3 + "] " + tok);     // Catch: Throwable -> L37
        i3 = i3 + 1;     // Catch: Throwable -> L37
        goto L40
    L42:
        pw.println("  mCurrentUserId=" + this.mCurrentUserId);     // Catch: Throwable -> L37
        pw.println("  mIcons=");     // Catch: Throwable -> L37
        Iterator<String> r3 = this.mIcons.keySet().iterator();     // Catch: Throwable -> L37
    L44:
        if (r3.hasNext() == false) goto L49;
        String slot = r3.next();     // Catch: Throwable -> L37
        pw.println("    ");     // Catch: Throwable -> L37
        pw.print(slot);     // Catch: Throwable -> L37
        pw.print(" -> ");     // Catch: Throwable -> L37
        StatusBarIcon icon = this.mIcons.get(slot);     // Catch: Throwable -> L37
        pw.print(icon);     // Catch: Throwable -> L37
        if (TextUtils.isEmpty(icon.contentDescription) == true) goto L48;
        pw.print(" \"");     // Catch: Throwable -> L37
        pw.print(icon.contentDescription);     // Catch: Throwable -> L37
        pw.print("\"");     // Catch: Throwable -> L37
    L48:
        pw.println();     // Catch: Throwable -> L37
        goto L44
    L49:
        ArrayMap<String, Long> r4 = this.mCurrentRequestAddTilePackages;     // Catch: Throwable -> L37
        monitor-enter(r4);     // Catch: Throwable -> L37
        ArrayList<String> requests = new ArrayList(this.mCurrentRequestAddTilePackages.keySet());     // Catch: Throwable -> L59
        monitor-exit(r4);     // Catch: Throwable -> L59
        pw.println("  mCurrentRequestAddTilePackages=[");     // Catch: Throwable -> L37
        int reqN = requests.size();     // Catch: Throwable -> L37
        int i4 = 0;
    L54:
        if (i4 >= reqN) goto L56;
        pw.println("    " + requests.get(i4) + ",");     // Catch: Throwable -> L37
        i4 = i4 + 1;     // Catch: Throwable -> L37
        goto L54
    L56:
        pw.println("  ]");     // Catch: Throwable -> L37
        IndentingPrintWriter ipw = new IndentingPrintWriter(pw, "  ");     // Catch: Throwable -> L37
        this.mTileRequestTracker.dump(fd, ipw.increaseIndent(), args);     // Catch: Throwable -> L37
        monitor-exit(r1);     // Catch: Throwable -> L37
        return;
    L59:
        th = move-exception;
        throw th;     // Catch: Throwable -> L37
    L15:
        if (this.mBar != null) goto L69;
        return;
    L69:
        TransferPipe tp = new TransferPipe();     // Catch: Throwable -> L21
        this.mBar.dumpProto(args, tp.getWriteFd());     // Catch: Throwable -> L23
        tp.go(fd);     // Catch: Throwable -> L23
        tp.close();     // Catch: Throwable -> L21
        return;
    L23:
        th = move-exception;
        tp.close();     // Catch: Throwable -> L26
    L28:
        throw th;     // Catch: Throwable -> L21
    L26:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L21
    L21:
        t = move-exception;
        Slog.e(TAG, "Error sending command to IStatusBar", t);
    }

    private static final Context getUiContext() {
        return ActivityThread.currentActivityThread().getSystemUiContext();
    }

    private void enforceValidCallingUser() {
        if (this.mVisibleBackgroundUsersEnabled == true) goto L5;
        return;
    L5:
        int callingUserId = UserHandle.getCallingUserId();
        if (callingUserId != 0) goto L8;
        return;
    L8:
        if (callingUserId != this.mCurrentUserId) goto L11;
        return;
    L11:
        if (isVisibleBackgroundUser(callingUserId) == true) goto L14;
        return;
    L14:
        throw new SecurityException("User " + callingUserId + " is not permitted to use this method");
    }

    private boolean isVisibleBackgroundUser(int userId) {
        if (this.mVisibleBackgroundUsersEnabled == true) goto L7;
        return false;
    L7:
        return this.mUserManagerInternal.isVisibleBackgroundFullUser(userId);
    }

    private boolean isVisibleBackgroundUserOnDisplay(int displayId) {
        if (this.mVisibleBackgroundUsersEnabled == true) goto L6;
        return false;
    L6:
        int userId = this.mUserManagerInternal.getUserAssignedToDisplay(displayId);
        return isVisibleBackgroundUser(userId);
    }

    public void onBiometricAuthenticatedWithId(int modality, int sensorId) {
        enforceBiometricDialog();
        enforceValidCallingUser();
        if (this.mBar == null) goto L10;
        this.mBar.onBiometricAuthenticatedWithId(modality, sensorId);     // Catch: RemoteException -> L6
        return;
    L7:
        return;
    }

    public void onBiometricErrorWithId(int modality, int error, int vendorCode, int sensorId) {
        enforceBiometricDialog();
        enforceValidCallingUser();
        if (this.mBar == null) goto L10;
        this.mBar.onBiometricErrorWithId(modality, error, vendorCode, sensorId);     // Catch: RemoteException -> L6
        return;
    L7:
        return;
    }

    public void onStatusBarDropStateChanged(int type) {
        enforceStatusBarService();
        enforceValidCallingUser();
        long identity = Binder.clearCallingIdentity();
        SysOptBridge.getFactory().getDynamicRefreshRateService().onStatusBarDropStateChanged(type);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(identity);
        return;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }
}
