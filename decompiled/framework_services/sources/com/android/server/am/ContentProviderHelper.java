package com.android.server.am;

import android.app.AppGlobals;
import android.app.ContentProviderHolder;
import android.app.IApplicationThread;
import android.app.SysMonitorFwBridge;
import android.app.doppelganger.DoppelgangerManager;
import android.content.AttributionSource;
import android.content.ComponentName;
import android.content.ContentProvider;
import android.content.Context;
import android.content.IContentProvider;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PathPermission;
import android.content.pm.ProviderInfo;
import android.content.pm.UserInfo;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Process;
import android.os.RemoteCallback;
import android.os.RemoteException;
import android.os.StabTrace;
import android.os.SystemClock;
import android.os.Trace;
import android.os.UserHandle;
import android.provider.Settings;
import android.util.ArrayMap;
import android.util.Log;
import android.util.Slog;
import android.util.SparseArray;
import com.android.internal.os.BackgroundThread;
import com.android.internal.os.TimeoutRecord;
import com.android.internal.util.ArrayUtils;
import com.android.internal.util.DoppelgangerUtils;
import com.android.internal.util.FrameworkStatsLog;
import com.android.server.LocalManagerRegistry;
import com.android.server.LocalServices;
import com.android.server.SysOptBridge;
import com.android.server.crashrecovery.CrashRecoveryAdaptor;
import com.android.server.pm.PackageManagerService;
import com.android.server.pm.UserManagerInternal;
import com.android.server.pm.pkg.AndroidPackage;
import com.android.server.sdksandbox.SdkSandboxManagerLocal;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class ContentProviderHelper {
    public static final int[] PROCESS_STATE_STATS_FORMAT = null;
    private static final String TAG = "ContentProviderHelper";
    private final Map<String, Boolean> mCloneProfileAuthorityRedirectionCache;
    private final ArrayList<ContentProviderRecord> mLaunchingProviders;
    private final long[] mProcessStateStatsLongs;
    private final ProviderMap mProviderMap;
    private final ActivityManagerService mService;
    private boolean mSystemProvidersInstalled;

    private final class DevelopmentSettingsObserver extends ContentObserver {
        private final ComponentName mBugreportStorageProvider;
        private final Uri mUri;
        final /* synthetic */ ContentProviderHelper this$0;

        DevelopmentSettingsObserver(ContentProviderHelper r4) {
            this.this$0 = r4;
            super(ContentProviderHelper.m1502$$Nest$fgetmService(r4).mHandler);
            this.mUri = Settings.Global.getUriFor("development_settings_enabled");
            this.mBugreportStorageProvider = new ComponentName("com.android.shell", "com.android.shell.BugreportStorageProvider");
            ContentProviderHelper.m1502$$Nest$fgetmService(r4).mContext.getContentResolver().registerContentObserver(this.mUri, false, this, -1);
            onChange();
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean selfChange, Uri uri, int userId) {
            if (this.mUri.equals(uri) == false) goto L6;
            onChange();
            return;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private void onChange() {
            int r1 = 1;
            if (Settings.Global.getInt(ContentProviderHelper.m1502$$Nest$fgetmService(this.this$0).mContext.getContentResolver(), "development_settings_enabled", Build.IS_ENG ? 1 : 0) == 0) goto L5;
            Object[] r0 = true;
        L6:
            PackageManager r3 = ContentProviderHelper.m1502$$Nest$fgetmService(this.this$0).mContext.getPackageManager();
            ComponentName r4 = this.mBugreportStorageProvider;
            if (r0 == true) goto L10;
            r1 = 0;
        L10:
            r3.setComponentEnabledSetting(r4, r1, 0);
            return;
        L5:
            r0 = false;
            goto L6
        }
    }

    private static final class StartActivityRunnable implements Runnable {
        private final Context mContext;
        private final Intent mIntent;
        private final UserHandle mUserHandle;

        StartActivityRunnable(Context context, Intent intent, UserHandle userHandle) {
            this.mContext = context;
            this.mIntent = intent;
            this.mUserHandle = userHandle;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.mContext.startActivityAsUser(this.mIntent, this.mUserHandle);
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$7SqNWgaMV7-OpTBuN-1CMmNHiyU, reason: not valid java name */
    public static /* synthetic */ String m1498$r8$lambda$7SqNWgaMV7OpTBuN1CMmNHiyU(ContentProviderHelper r0, ProcessRecord r1, ProviderInfo r2, String r3) {
        return r0.lambda$checkContentProviderAssociation$4(r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$Cuz--ZRyWbI5VNWXF2ERo-dfHW4, reason: not valid java name */
    public static /* synthetic */ void m1499$r8$lambda$CuzZRyWbI5VNWXF2ERodfHW4(ContentProviderHelper r0, String r1, int r2, RemoteCallback r3, Bundle r4) {
        r0.lambda$getMimeTypeFilterAsync$0(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: $r8$lambda$JV9jTPlBHAPZLxkKAqq24ds-FLE, reason: not valid java name */
    public static /* synthetic */ void m1500$r8$lambda$JV9jTPlBHAPZLxkKAqq24dsFLE(ContentProviderHelper r0, String r1, int r2, RemoteCallback r3, int r4, Uri r5, Bundle r6) {
        r0.lambda$getMimeTypeFilterAsync$1(r1, r2, r3, r4, r5, r6);
    }

    public static /* synthetic */ void $r8$lambda$WgT9vu5eZilG5Q2yFu6AlQnBbWA(ContentProviderHelper r0, ContentProviderConnection r1, boolean r2, boolean r3) {
        r0.lambda$decProviderCountLocked$3(r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$Ybb6ASgJllmnwf29cCLpR_JR-Yg, reason: not valid java name */
    public static /* synthetic */ void m1501$r8$lambda$Ybb6ASgJllmnwf29cCLpR_JRYg(ContentProviderHelper r0, ProcessRecord r1, String r2) {
        r0.lambda$installEncryptionUnawareProviders$2(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmService, reason: not valid java name */
    static /* bridge */ /* synthetic */ ActivityManagerService m1502$$Nest$fgetmService(ContentProviderHelper r0) {
        return r0.mService;
    }

    ContentProviderHelper(ActivityManagerService service, boolean createProviderMap) {
        this.mLaunchingProviders = new ArrayList();
        this.mCloneProfileAuthorityRedirectionCache = new HashMap();
        this.mProcessStateStatsLongs = new long[1];
        this.mService = service;
        if (createProviderMap == false) goto L5;
        ProviderMap r0 = new ProviderMap(this.mService);
    L6:
        this.mProviderMap = r0;
        return;
    L5:
        r0 = null;
        goto L6
    }

    ProviderMap getProviderMap() {
        return this.mProviderMap;
    }

    ContentProviderHolder getContentProvider(IApplicationThread caller, String callingPackage, String name, int userId, boolean stable) {
        this.mService.enforceNotIsolatedCaller("getContentProvider");
        if (caller == null) goto L26;
        int callingUid = Binder.getCallingUid();
        if (callingPackage == null) goto L12;
        if (this.mService.mAppOpsService.checkPackage(callingUid, callingPackage) == 0) goto L12;
        throw new SecurityException("Given calling package " + callingPackage + " does not match caller's uid " + callingUid);
    L12:
        if (StabTrace.isEnable() == false) goto L14;
        long beginTime = Process.getCpuClocks();
        long beginTime2 = beginTime;
    L15:
        ContentProviderHolder holder = getContentProviderImpl(caller, name, null, callingUid, callingPackage, null, stable, userId);
        if (StabTrace.isEnable() == false) goto L18;
        StabTrace.traceInfo(32, "getContentProvider:CallPkg=" + callingPackage + "callPid=" + Binder.getCallingPid(), beginTime2, Process.getCpuClocks());
    L18:
        if (holder != null) goto L25;
        if (userId == 10) goto L22;
        return holder;
    L22:
        if (DoppelgangerManager.isDoppelgangerEnable() == true) goto L30;
        return holder;
    L30:
        return getContentProviderImpl(caller, name, null, callingUid, callingPackage, null, stable, 0);
    L25:
        return holder;
    L14:
        beginTime2 = 0;
        goto L15
    L26:
        String msg = "null IApplicationThread when getting content provider " + name;
        Slog.w(TAG, msg);
        throw new SecurityException(msg);
    }

    ContentProviderHolder getContentProviderExternal(String name, int userId, IBinder token, String tag) {
        this.mService.enforceCallingPermission("android.permission.ACCESS_CONTENT_PROVIDERS_EXTERNALLY", "Do not have permission in call getContentProviderExternal()");
        int userId2 = this.mService.mUserController.handleIncomingUser(Binder.getCallingPid(), Binder.getCallingUid(), userId, false, 2, "getContentProvider", null);
        int r3 = Binder.getCallingUid();
        if (tag == null) goto L5;
        String r4 = tag;
    L7:
        return getContentProviderExternalUnchecked(name, token, r3, r4, userId2);
    L5:
        r4 = "*external*";
        goto L7
    }

    ContentProviderHolder getContentProviderExternalUnchecked(String name, IBinder token, int callingUid, String callingTag, int userId) {
        return getContentProviderImpl(null, name, token, callingUid, null, callingTag, true, userId);
    }

    /* JADX WARN: Failed to apply debug info
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r14v8 ??, new type: android.content.pm.ProviderInfo
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.applyDebugInfo(TypeUpdate.java:77)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.applyDebugInfo(DebugInfoApplyVisitor.java:137)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.searchDebugInfoByOffset(DebugInfoApplyVisitor.java:107)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.searchAndApplyVarDebugInfo(DebugInfoApplyVisitor.java:83)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.lambda$applyDebugInfo$0(DebugInfoApplyVisitor.java:68)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.applyDebugInfo(DebugInfoApplyVisitor.java:68)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoApplyVisitor.visit(DebugInfoApplyVisitor.java:55)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 8 more
     */
    /* JADX WARN: Failed to calculate best type for var: r0v231 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v231 ??, new type: android.content.pm.ProviderInfo
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /* JADX WARN: Failed to calculate best type for var: r0v231 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v231 ??, new type: android.content.pm.ProviderInfo
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryInsertAdditionalMove(FixTypesVisitor.java:678)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 8 more
     */
    /* JADX WARN: Failed to calculate best type for var: r0v231 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v231 ??, new type: android.content.pm.ProviderInfo
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryToFixIncompatiblePrimitives(FixTypesVisitor.java:820)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 8 more
     */
    /* JADX WARN: Failed to calculate best type for var: r0v231 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v231 ??, new type: android.content.pm.ProviderInfo
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r0v25 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v25 ??, new type: android.content.pm.ProviderInfo
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /* JADX WARN: Failed to calculate best type for var: r0v25 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v25 ??, new type: android.content.pm.ProviderInfo
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryInsertAdditionalMove(FixTypesVisitor.java:678)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 8 more
     */
    /* JADX WARN: Failed to calculate best type for var: r0v25 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v25 ??, new type: android.content.pm.ProviderInfo
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryToFixIncompatiblePrimitives(FixTypesVisitor.java:820)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 8 more
     */
    /* JADX WARN: Failed to calculate best type for var: r0v25 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v25 ??, new type: android.content.pm.ProviderInfo
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r14v103 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r14v103 ??, new type: android.content.pm.ProviderInfo
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /* JADX WARN: Failed to calculate best type for var: r14v103 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r14v103 ??, new type: android.content.pm.ProviderInfo
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryToFixIncompatiblePrimitives(FixTypesVisitor.java:820)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 8 more
     */
    /* JADX WARN: Failed to calculate best type for var: r14v103 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r14v103 ??, new type: android.content.pm.ProviderInfo
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r14v104 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r14v104 ??, new type: android.content.pm.ProviderInfo
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /* JADX WARN: Failed to calculate best type for var: r14v104 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r14v104 ??, new type: android.content.pm.ProviderInfo
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryToFixIncompatiblePrimitives(FixTypesVisitor.java:820)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 8 more
     */
    /* JADX WARN: Failed to calculate best type for var: r14v104 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r14v104 ??, new type: android.content.pm.ProviderInfo
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r14v119 'this'  ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r14v119 'this'  ??, new type: com.android.server.am.ContentProviderHelper
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /* JADX WARN: Failed to calculate best type for var: r14v119 'this'  ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r14v119 'this'  ??, new type: com.android.server.am.ContentProviderHelper
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryToFixIncompatiblePrimitives(FixTypesVisitor.java:820)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 8 more
     */
    /* JADX WARN: Failed to calculate best type for var: r14v119 'this'  ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r14v119 'this'  ??, new type: com.android.server.am.ContentProviderHelper
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r14v119 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r14v119 ??, new type: com.android.server.am.ContentProviderHelper
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryInsertAdditionalMove(FixTypesVisitor.java:678)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 8 more
     */
    /* JADX WARN: Failed to calculate best type for var: r14v124 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r14v124 ??, new type: android.content.pm.ProviderInfo
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /* JADX WARN: Failed to calculate best type for var: r14v124 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r14v124 ??, new type: android.content.pm.ProviderInfo
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryToFixIncompatiblePrimitives(FixTypesVisitor.java:820)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 8 more
     */
    /* JADX WARN: Failed to calculate best type for var: r14v124 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r14v124 ??, new type: android.content.pm.ProviderInfo
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r14v125 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r14v125 ??, new type: android.content.pm.ProviderInfo
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /* JADX WARN: Failed to calculate best type for var: r14v125 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r14v125 ??, new type: android.content.pm.ProviderInfo
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryInsertAdditionalMove(FixTypesVisitor.java:678)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 8 more
     */
    /* JADX WARN: Failed to calculate best type for var: r14v125 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r14v125 ??, new type: android.content.pm.ProviderInfo
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryToFixIncompatiblePrimitives(FixTypesVisitor.java:820)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 8 more
     */
    /* JADX WARN: Failed to calculate best type for var: r14v125 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r14v125 ??, new type: android.content.pm.ProviderInfo
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r14v128 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r14v128 ??, new type: android.content.pm.ProviderInfo
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /* JADX WARN: Failed to calculate best type for var: r14v128 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r14v128 ??, new type: android.content.pm.ProviderInfo
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryToFixIncompatiblePrimitives(FixTypesVisitor.java:820)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 8 more
     */
    /* JADX WARN: Failed to calculate best type for var: r14v128 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r14v128 ??, new type: android.content.pm.ProviderInfo
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r14v133 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r14v133 ??, new type: android.content.pm.ProviderInfo
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryInsertAdditionalMove(FixTypesVisitor.java:678)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 8 more
     */
    /* JADX WARN: Failed to calculate best type for var: r14v45 'this'  ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r14v45 'this'  ??, new type: com.android.server.am.ContentProviderHelper
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /* JADX WARN: Failed to calculate best type for var: r14v45 'this'  ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r14v45 'this'  ??, new type: com.android.server.am.ContentProviderHelper
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryToFixIncompatiblePrimitives(FixTypesVisitor.java:820)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 8 more
     */
    /* JADX WARN: Failed to calculate best type for var: r14v45 'this'  ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r14v45 'this'  ??, new type: com.android.server.am.ContentProviderHelper
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r14v45 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r14v45 ??, new type: com.android.server.am.ContentProviderHelper
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryInsertAdditionalMove(FixTypesVisitor.java:678)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 8 more
     */
    /* JADX WARN: Failed to calculate best type for var: r14v8 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r14v8 ??, new type: android.content.pm.ProviderInfo
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /* JADX WARN: Failed to calculate best type for var: r14v8 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r14v8 ??, new type: android.content.pm.ProviderInfo
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryToFixIncompatiblePrimitives(FixTypesVisitor.java:820)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 8 more
     */
    /* JADX WARN: Failed to calculate best type for var: r14v8 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r14v8 ??, new type: android.content.pm.ProviderInfo
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r1v21 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r1v21 ??, new type: com.android.server.am.ContentProviderHelper
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /* JADX WARN: Failed to calculate best type for var: r1v21 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r1v21 ??, new type: com.android.server.am.ContentProviderHelper
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryInsertAdditionalMove(FixTypesVisitor.java:678)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 8 more
     */
    /* JADX WARN: Failed to calculate best type for var: r1v21 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r1v21 ??, new type: com.android.server.am.ContentProviderHelper
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryToFixIncompatiblePrimitives(FixTypesVisitor.java:820)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 8 more
     */
    /* JADX WARN: Failed to calculate best type for var: r1v21 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r1v21 ??, new type: com.android.server.am.ContentProviderHelper
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r1v89 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r1v89 ??, new type: com.android.server.am.ContentProviderHelper
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /* JADX WARN: Failed to calculate best type for var: r1v89 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r1v89 ??, new type: com.android.server.am.ContentProviderHelper
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryInsertAdditionalMove(FixTypesVisitor.java:678)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 8 more
     */
    /* JADX WARN: Failed to calculate best type for var: r1v89 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r1v89 ??, new type: com.android.server.am.ContentProviderHelper
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryToFixIncompatiblePrimitives(FixTypesVisitor.java:820)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 8 more
     */
    /* JADX WARN: Failed to calculate best type for var: r1v89 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r1v89 ??, new type: com.android.server.am.ContentProviderHelper
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r1v96 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r1v96 ??, new type: com.android.server.am.ContentProviderHelper
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /* JADX WARN: Failed to calculate best type for var: r1v96 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r1v96 ??, new type: com.android.server.am.ContentProviderHelper
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryInsertAdditionalMove(FixTypesVisitor.java:678)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 8 more
     */
    /* JADX WARN: Failed to calculate best type for var: r1v96 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r1v96 ??, new type: com.android.server.am.ContentProviderHelper
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryToFixIncompatiblePrimitives(FixTypesVisitor.java:820)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 8 more
     */
    /* JADX WARN: Failed to calculate best type for var: r1v96 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r1v96 ??, new type: com.android.server.am.ContentProviderHelper
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r1v97 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r1v97 ??, new type: com.android.server.am.ContentProviderHelper
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /* JADX WARN: Failed to calculate best type for var: r1v97 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r1v97 ??, new type: com.android.server.am.ContentProviderHelper
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryInsertAdditionalMove(FixTypesVisitor.java:678)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 8 more
     */
    /* JADX WARN: Failed to calculate best type for var: r1v97 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r1v97 ??, new type: com.android.server.am.ContentProviderHelper
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryToFixIncompatiblePrimitives(FixTypesVisitor.java:820)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 8 more
     */
    /* JADX WARN: Failed to calculate best type for var: r1v97 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r1v97 ??, new type: com.android.server.am.ContentProviderHelper
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r1v98 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r1v98 ??, new type: com.android.server.am.ContentProviderHelper
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryInsertAdditionalMove(FixTypesVisitor.java:678)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 8 more
     */
    /* JADX WARN: Failed to calculate best type for var: r3v31 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r3v31 ??, new type: android.content.pm.ProviderInfo
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /* JADX WARN: Failed to calculate best type for var: r3v31 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r3v31 ??, new type: android.content.pm.ProviderInfo
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryInsertAdditionalMove(FixTypesVisitor.java:678)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 8 more
     */
    /* JADX WARN: Failed to calculate best type for var: r3v31 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r3v31 ??, new type: android.content.pm.ProviderInfo
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryToFixIncompatiblePrimitives(FixTypesVisitor.java:820)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 8 more
     */
    /* JADX WARN: Failed to calculate best type for var: r3v31 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r3v31 ??, new type: android.content.pm.ProviderInfo
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r3v32 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r3v32 ??, new type: android.content.pm.ProviderInfo
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /* JADX WARN: Failed to calculate best type for var: r3v32 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r3v32 ??, new type: android.content.pm.ProviderInfo
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryInsertAdditionalMove(FixTypesVisitor.java:678)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 8 more
     */
    /* JADX WARN: Failed to calculate best type for var: r3v32 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r3v32 ??, new type: android.content.pm.ProviderInfo
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryToFixIncompatiblePrimitives(FixTypesVisitor.java:820)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 8 more
     */
    /* JADX WARN: Failed to calculate best type for var: r3v32 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r3v32 ??, new type: android.content.pm.ProviderInfo
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r3v58 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r3v58 ??, new type: android.content.pm.ProviderInfo
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /* JADX WARN: Failed to calculate best type for var: r3v58 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r3v58 ??, new type: android.content.pm.ProviderInfo
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryInsertAdditionalMove(FixTypesVisitor.java:678)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 8 more
     */
    /* JADX WARN: Failed to calculate best type for var: r3v58 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r3v58 ??, new type: android.content.pm.ProviderInfo
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryToFixIncompatiblePrimitives(FixTypesVisitor.java:820)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 8 more
     */
    /* JADX WARN: Failed to calculate best type for var: r3v58 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r3v58 ??, new type: android.content.pm.ProviderInfo
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r3v59 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r3v59 ??, new type: android.content.pm.ProviderInfo
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /* JADX WARN: Failed to calculate best type for var: r3v59 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r3v59 ??, new type: android.content.pm.ProviderInfo
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryInsertAdditionalMove(FixTypesVisitor.java:678)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 8 more
     */
    /* JADX WARN: Failed to calculate best type for var: r3v59 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r3v59 ??, new type: android.content.pm.ProviderInfo
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryToFixIncompatiblePrimitives(FixTypesVisitor.java:820)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 8 more
     */
    /* JADX WARN: Failed to calculate best type for var: r3v59 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r3v59 ??, new type: android.content.pm.ProviderInfo
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r3v64 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r3v64 ??, new type: android.content.pm.ProviderInfo
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /* JADX WARN: Failed to calculate best type for var: r3v64 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r3v64 ??, new type: android.content.pm.ProviderInfo
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryInsertAdditionalMove(FixTypesVisitor.java:678)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 8 more
     */
    /* JADX WARN: Failed to calculate best type for var: r3v64 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r3v64 ??, new type: android.content.pm.ProviderInfo
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryToFixIncompatiblePrimitives(FixTypesVisitor.java:820)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 8 more
     */
    /* JADX WARN: Failed to calculate best type for var: r3v64 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r3v64 ??, new type: android.content.pm.ProviderInfo
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r4v92 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r4v92 ??, new type: android.content.pm.ProviderInfo
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /* JADX WARN: Failed to calculate best type for var: r4v92 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r4v92 ??, new type: android.content.pm.ProviderInfo
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryInsertAdditionalMove(FixTypesVisitor.java:678)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 8 more
     */
    /* JADX WARN: Failed to calculate best type for var: r4v92 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r4v92 ??, new type: android.content.pm.ProviderInfo
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryToFixIncompatiblePrimitives(FixTypesVisitor.java:820)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 8 more
     */
    /* JADX WARN: Failed to calculate best type for var: r4v92 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r4v92 ??, new type: android.content.pm.ProviderInfo
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r62v0 'this'  ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r62v0 'this'  ??, new type: com.android.server.am.ContentProviderHelper
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryInsertAdditionalMove(FixTypesVisitor.java:678)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 8 more
     */
    /* JADX WARN: Failed to calculate best type for var: r62v0 'this'  ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r62v0 'this'  ??, new type: com.android.server.am.ContentProviderHelper
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryToFixIncompatiblePrimitives(FixTypesVisitor.java:820)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 8 more
     */
    /* JADX WARN: Failed to calculate best type for var: r62v0 'this'  ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r62v0 'this'  ??, new type: com.android.server.am.ContentProviderHelper
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r62v1 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r62v1 ??, new type: com.android.server.am.ContentProviderHelper
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryInsertAdditionalMove(FixTypesVisitor.java:678)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 8 more
     */
    /* JADX WARN: Failed to set immutable type for var: r62v0 'this'  ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r62v0 'this'  ??, new type: com.android.server.am.ContentProviderHelper
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.applyWithWiderIgnSame(TypeUpdate.java:73)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setImmutableType(TypeInferenceVisitor.java:111)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$0(TypeInferenceVisitor.java:102)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:102)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryInsertAdditionalMove(FixTypesVisitor.java:678)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to set immutable type for var: r62v0 'this'  ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r62v0 'this'  ??, new type: com.android.server.am.ContentProviderHelper
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.applyWithWiderIgnSame(TypeUpdate.java:73)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setImmutableType(TypeInferenceVisitor.java:111)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$0(TypeInferenceVisitor.java:102)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:102)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryToFixIncompatiblePrimitives(FixTypesVisitor.java:820)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to set immutable type for var: r62v0 'this'  ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r62v0 'this'  ??, new type: com.android.server.am.ContentProviderHelper
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.applyWithWiderIgnSame(TypeUpdate.java:73)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setImmutableType(TypeInferenceVisitor.java:111)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$0(TypeInferenceVisitor.java:102)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:102)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /* JADX WARN: Failed to set immutable type for var: r62v1 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r62v1 ??, new type: com.android.server.am.ContentProviderHelper
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.applyWithWiderIgnSame(TypeUpdate.java:73)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setImmutableType(TypeInferenceVisitor.java:111)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$0(TypeInferenceVisitor.java:102)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:102)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryInsertAdditionalMove(FixTypesVisitor.java:678)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*  JADX ERROR: Types fix failed
        jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r14v8 ??, new type: java.lang.Object
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryPossibleTypes(FixTypesVisitor.java:186)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:245)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryInsertAdditionalMove(FixTypesVisitor.java:681)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
        Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
        	... 6 more
        */
    private android.app.ContentProviderHolder getContentProviderImpl(android.app.IApplicationThread r63, java.lang.String r64, android.os.IBinder r65, int r66, java.lang.String r67, java.lang.String r68, boolean r69, int r70) {
        /*  JADX ERROR: Simple mode code generation failed
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0190: IGET (r14v125 ?? I:android.content.pm.ProviderInfo) = (r2v105 com.android.server.am.ContentProviderRecord A[D('cpr' com.android.server.am.ContentProviderRecord)]) A[Catch: all -> 0x0204, DECLARE_VAR, TRY_ENTER, TRY_LEAVE] (LINE:301) com.android.server.am.ContentProviderRecord.info android.content.pm.ProviderInfo in method: com.android.server.am.ContentProviderHelper.getContentProviderImpl(android.app.IApplicationThread, java.lang.String, android.os.IBinder, int, java.lang.String, java.lang.String, boolean, int):android.app.ContentProviderHolder, file: classes.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:348)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.ArgType.getPrimitiveType()" because "type" is null
            	at jadx.core.codegen.ClassGen.useType(ClassGen.java:564)
            	at jadx.core.codegen.InsnGen.useType(InsnGen.java:269)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:166)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:159)
            	at jadx.core.codegen.InsnGen.assignVar(InsnGen.java:152)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:299)
            	... 31 more
            */
        /*
            Method dump skipped, instruction units count: 4709
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.server.am.ContentProviderHelper.getContentProviderImpl(android.app.IApplicationThread, java.lang.String, android.os.IBinder, int, java.lang.String, java.lang.String, boolean, int):android.app.ContentProviderHolder");
    }

    private void checkAssociationAndPermissionLocked(ProcessRecord callingApp, ProviderInfo cpi, int callingUid, int userId, boolean checkUser, String cprName, long startTime) {
        String msg = checkContentProviderAssociation(callingApp, callingUid, cpi);
        if (msg != null) goto L16;
        checkTime(startTime, "getContentProviderImpl: before checkContentProviderPermission");
        int r2 = Binder.getCallingPid();
        int r3 = Binder.getCallingUid();
        if (callingApp == null) goto L8;
        String r4 = callingApp.toString();
    L9:
        String msg2 = checkContentProviderPermission(cpi, r2, r3, userId, checkUser, r4);
        if (msg2 != null) goto L14;
        checkTime(startTime, "getContentProviderImpl: after checkContentProviderPermission");
        return;
    L14:
        throw new SecurityException(msg2);
    L8:
        r4 = null;
        goto L9
    L16:
        throw new SecurityException("Content provider lookup " + cprName + " failed: association not allowed with package " + msg);
    }

    void publishContentProviders(IApplicationThread caller, List<ContentProviderHolder> providers) {
        if (providers != null) goto L5;
        return;
    L5:
        this.mService.enforceNotIsolatedOrSdkSandboxCaller("publishContentProviders");
        if (StabTrace.isEnable() == false) goto L8;
        long beginTime = Process.getCpuClocks();
        long beginTime2 = beginTime;
    L9:
        ActivityManagerService r4 = this.mService;
        ActivityManagerService.boostPriorityForLockedSection();
        monitor-enter(r4);
        boolean r5 = true;
        ProcessRecord r = this.mService.getRecordForAppLOSP(caller, true);     // Catch: Throwable -> L14
        if (ActivityManagerDebugConfig.DEBUG_MU == false) goto L16;
        Slog.v("ActivityManager_MU", "ProcessRecord uid = " + r.uid);     // Catch: Throwable -> L14
    L16:
        if (r == null) goto L85;
        if (r.getSmtEx().inFreezeStat() == false) goto L20;
        Slog.e(TAG, "frozen app publishing provider r: " + r);     // Catch: Throwable -> L14
    L20:
        long origId = Binder.clearCallingIdentity();     // Catch: Throwable -> L14
        boolean providersPublished = false;
        int i = 0;
        int size = providers.size();     // Catch: Throwable -> L14
    L21:
        if (i >= size) goto L65;
        ContentProviderHolder src = providers.get(i);     // Catch: Throwable -> L14
        if (src != null) goto L25;
    L62:
        boolean providersPublished2 = providersPublished;
        boolean providersPublished3 = r5;
        int i2 = i;
        int size2 = size;
    L63:
        i = i2 + 1;     // Catch: Throwable -> L14
        r5 = providersPublished3;
        providersPublished = providersPublished2;
        size = size2;
        goto L21
    L25:
        if (src.info == null) goto L62;
        if (src.provider != null) goto L29;
        providersPublished2 = providersPublished;
        providersPublished3 = r5;
        i2 = i;
        size2 = size;
        goto L63
    L29:
        ContentProviderRecord dst = r.mProviders.getProvider(src.info.name);     // Catch: Throwable -> L14
        if (dst != null) goto L33;
        providersPublished2 = providersPublished;
        providersPublished3 = r5;
        i2 = i;
        size2 = size;
        goto L63
    L33:
        if (ActivityManagerDebugConfig.DEBUG_MU == false) goto L36;
        Slog.v("ActivityManager_MU", "ContentProviderRecord uid = " + dst.uid);     // Catch: Throwable -> L14
    L36:
        providersPublished2 = true;
        ComponentName comp = new ComponentName(dst.info.packageName, dst.info.name);     // Catch: Throwable -> L14
        this.mProviderMap.putProviderByClass(comp, dst);     // Catch: Throwable -> L14
        String[] names = dst.info.authority.split(";");     // Catch: Throwable -> L14
        int j = 0;
    L37:
        ComponentName comp2 = comp;
        if (j >= names.length) goto L40;
        int j2 = j;
        this.mProviderMap.putProviderByName(names[j2], dst);     // Catch: Throwable -> L14
        j = j2 + 1;     // Catch: Throwable -> L14
        comp = comp2;
        goto L37
    L40:
        int j3 = 0;
        boolean wasInLaunchingProviders = false;
        int numLaunching = this.mLaunchingProviders.size();     // Catch: Throwable -> L14
    L41:
        if (j3 >= numLaunching) goto L48;
        int numLaunching2 = numLaunching;
        if (this.mLaunchingProviders.get(j3) != dst) goto L45;
        this.mLaunchingProviders.remove(j3);     // Catch: Throwable -> L14
        j3 = j3 - 1;     // Catch: Throwable -> L14
        wasInLaunchingProviders = true;
        numLaunching = numLaunching2 - 1;     // Catch: Throwable -> L14
    L46:
        j3 = j3 + 1;     // Catch: Throwable -> L14
        goto L41
    L45:
        numLaunching = numLaunching2;
        goto L46
    L48:
        if (wasInLaunchingProviders == false) goto L50;
        this.mService.mHandler.removeMessages(73, dst);     // Catch: Throwable -> L14
        this.mService.mHandler.removeMessages(57, r);     // Catch: Throwable -> L14
    L50:
        i2 = i;
        size2 = size;
        r.addPackage(dst.info.applicationInfo.packageName, dst.info.applicationInfo.longVersionCode, this.mService.mProcessStats);     // Catch: Throwable -> L14
        monitor-enter(dst);     // Catch: Throwable -> L14
        dst.provider = src.provider;     // Catch: Throwable -> L59
        dst.setProcess(r);     // Catch: Throwable -> L59
        dst.notifyAll();     // Catch: Throwable -> L59
        providersPublished3 = r5;
        dst.onProviderPublishStatusLocked(providersPublished3);     // Catch: Throwable -> L59
        monitor-exit(dst);     // Catch: Throwable -> L59
    L55:
        dst.mRestartCount = 0;     // Catch: Throwable -> L14
        r.getSmtEx().clearFreezeBlockFlagsLocked(3, dst);     // Catch: Throwable -> L14
        if (hasProviderConnectionLocked(r) == false) goto L63;
        r.mProfile.addHostingComponentType(64);     // Catch: Throwable -> L14
    L59:
        th = move-exception;
        throw th;     // Catch: Throwable -> L14
    L65:
        if (providersPublished == false) goto L78;
        this.mService.updateOomAdjLocked(r, 7);     // Catch: Throwable -> L14
        int i3 = 0;
        int size3 = providers.size();     // Catch: Throwable -> L14
    L67:
        if (i3 >= size3) goto L78;
        ContentProviderHolder src2 = providers.get(i3);     // Catch: Throwable -> L14
        if (src2 == null) goto L76;
        if (src2.info == null) goto L76;
        if (src2.provider == null) goto L76;
        maybeUpdateProviderUsageStatsLocked(r, src2.info.packageName, src2.info.authority);     // Catch: Throwable -> L14
    L76:
        i3 = i3 + 1;     // Catch: Throwable -> L14
    L78:
        if (StabTrace.isEnable() == false) goto L80;
        StabTrace.traceInfo(32, "publishProvider:callPid:" + r.getPid() + "callname:" + r.processName, beginTime2, Process.getCpuClocks());     // Catch: Throwable -> L14
    L80:
        Binder.restoreCallingIdentity(origId);     // Catch: Throwable -> L14
        monitor-exit(r4);     // Catch: Throwable -> L14
        ActivityManagerService.resetPriorityAfterLockedSection();
        return;
    L85:
        throw new SecurityException("Unable to find app for caller " + caller + " (pid=" + Binder.getCallingPid() + ") when publishing content providers");     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterLockedSection();
        throw th;
    L8:
        beginTime2 = 0;
        goto L9
    }

    void removeContentProvider(IBinder connection, boolean stable) {
        this.mService.enforceNotIsolatedCaller("removeContentProvider");
        long ident = Binder.clearCallingIdentity();
        ContentProviderConnection conn = (ContentProviderConnection) connection;     // Catch: Throwable -> L38 ClassCastException -> L42
        goto L43
    L5:
        if (conn == null) goto L41;
        if (conn.provider != null) goto L51;
    L14:
        String r3 = "";
    L15:
        ActivityManagerService.traceBegin(64, "removeContentProvider: ", r3);     // Catch: Throwable -> L38
        ActivityManagerService r12 = this.mService;     // Catch: Throwable -> L34
        ActivityManagerService.boostPriorityForLockedSection();     // Catch: Throwable -> L34
        monitor-enter(r12);     // Catch: Throwable -> L34
        decProviderCountLocked(conn, null, null, stable, true, true);     // Catch: Throwable -> L29
        monitor-exit(r12);     // Catch: Throwable -> L29
        ActivityManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L27
        Trace.traceEnd(64);     // Catch: Throwable -> L25
        Binder.restoreCallingIdentity(ident);
        return;
    L27:
        th = move-exception;
        Throwable r15 = th;
    L36:
        Trace.traceEnd(64);     // Catch: Throwable -> L25
        throw r15;     // Catch: Throwable -> L25
    L29:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L27
        throw th;     // Catch: Throwable -> L27
    L34:
        th = move-exception;
        r15 = th;
        goto L36
    L51:
    L12:
        th = th;
    L45:
        Binder.restoreCallingIdentity(ident);
        throw th;
    L9:
        if (conn.provider.info == null) goto L14;
        r3 = conn.provider.info.authority;     // Catch: Throwable -> L12
        goto L15
    L41:
        throw new NullPointerException("connection is null");     // Catch: Throwable -> L25
    L38:
        th = th;
    L25:
        th = th;
    L43:
        String msg = "removeContentProvider: " + connection + " not a ContentProviderConnection";     // Catch: Throwable -> L25
        Slog.w(TAG, msg);     // Catch: Throwable -> L25
        throw new IllegalArgumentException(msg);     // Catch: Throwable -> L25
    }

    void removeContentProviderExternalAsUser(String name, IBinder token, int userId) {
        this.mService.enforceCallingPermission("android.permission.ACCESS_CONTENT_PROVIDERS_EXTERNALLY", "Do not have permission in call removeContentProviderExternal()");
        long ident = Binder.clearCallingIdentity();
        removeContentProviderExternalUnchecked(name, token, userId);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(ident);
        return;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    }

    void removeContentProviderExternalUnchecked(String name, IBinder token, int userId) {
        ActivityManagerService r0 = this.mService;
        ActivityManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        ContentProviderRecord cpr = this.mProviderMap.getProviderByName(name, userId);     // Catch: Throwable -> L9
        if (cpr != null) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L9
        ActivityManagerService.resetPriorityAfterLockedSection();
        return;
    L11:
        ComponentName comp = new ComponentName(cpr.info.packageName, cpr.info.name);     // Catch: Throwable -> L9
        ContentProviderRecord localCpr = this.mProviderMap.getProviderByClass(comp, userId);     // Catch: Throwable -> L9
        if (localCpr.hasExternalProcessHandles() == true) goto L14;
        Slog.e(TAG, "Attempt to remove content provider: " + localCpr + " with no external references.");     // Catch: Throwable -> L9
    L18:
        monitor-exit(r0);     // Catch: Throwable -> L9
        ActivityManagerService.resetPriorityAfterLockedSection();
        return;
    L14:
        if (this.mService.mProcessStateController.removeExternalProviderClient(localCpr, token) == false) goto L16;
        this.mService.getSmtEx().scheduleUpdateOomAdj(false);     // Catch: Throwable -> L9
        goto L18
    L16:
        Slog.e(TAG, "Attempt to remove content provider " + localCpr + " with no external reference for token: " + token + ".");     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    boolean refContentProvider(IBinder connection, int stable, int unstable) {
        ContentProviderConnection conn = (ContentProviderConnection) connection;     // Catch: ClassCastException -> L20
        if (conn == null) goto L19;
        if (conn.provider != null) goto L8;
    L10:
        String r2 = "";
    L11:
        ActivityManagerService.traceBegin(64, "refContentProvider: ", r2);
        conn.adjustCounts(stable, unstable);     // Catch: Throwable -> L15
        boolean r0 = !conn.dead;
        Trace.traceEnd(64);
        return r0;
    L15:
        th = move-exception;
        Trace.traceEnd(64);
        throw th;
    L8:
        if (conn.provider.info == null) goto L10;
        r2 = conn.provider.info.authority;
        goto L11
    L19:
        throw new NullPointerException("connection is null");
    L21:
        String msg = "refContentProvider: " + connection + " not a ContentProviderConnection";
        Slog.w(TAG, msg);
        throw new IllegalArgumentException(msg);
    }

    void unstableProviderDied(IBinder connection) {
        ContentProviderConnection conn = (ContentProviderConnection) connection;     // Catch: ClassCastException -> L71
        if (conn == null) goto L70;
        if (conn.provider != null) goto L7;
    L9:
        String r2 = "";
    L10:
        ActivityManagerService.traceBegin(64, "unstableProviderDied: ", r2);
        ActivityManagerService r1 = this.mService;     // Catch: Throwable -> L31
        ActivityManagerService.boostPriorityForLockedSection();     // Catch: Throwable -> L31
        monitor-enter(r1);     // Catch: Throwable -> L31
        IContentProvider provider = conn.provider.provider;     // Catch: Throwable -> L63
        monitor-exit(r1);     // Catch: Throwable -> L63
        ActivityManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L31
        if (provider != null) goto L20;
        Trace.traceEnd(64);
        return;
    L20:
        if (provider.asBinder().pingBinder() == false) goto L33;
        ActivityManagerService r3 = this.mService;     // Catch: Throwable -> L31
        ActivityManagerService.boostPriorityForLockedSection();     // Catch: Throwable -> L31
        monitor-enter(r3);     // Catch: Throwable -> L31
        Slog.w(TAG, "unstableProviderDied: caller " + Binder.getCallingUid() + " says " + conn + " died, but we don't agree");     // Catch: Throwable -> L27
        monitor-exit(r3);     // Catch: Throwable -> L27
        ActivityManagerService.resetPriorityAfterLockedSection();
        Trace.traceEnd(64);
        return;
    L27:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L31
        throw th;     // Catch: Throwable -> L31
    L33:
        ActivityManagerService r4 = this.mService;     // Catch: Throwable -> L31
        ActivityManagerService.boostPriorityForLockedSection();     // Catch: Throwable -> L31
        monitor-enter(r4);     // Catch: Throwable -> L31
    L40:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L31
        throw th;     // Catch: Throwable -> L31
    L36:
        if (conn.provider.provider == provider) goto L42;
        monitor-exit(r4);     // Catch: Throwable -> L40
        ActivityManagerService.resetPriorityAfterLockedSection();
        Trace.traceEnd(64);
        return;
    L42:
        ProcessRecord proc = conn.provider.proc;     // Catch: Throwable -> L40
        if (proc == null) goto L57;
        if (proc.getThread() == null) goto L57;
        this.mService.reportUidInfoMessageLocked(TAG, "Process " + proc.processName + " (pid " + proc.getPid() + ") early provider death", proc.info.uid);     // Catch: Throwable -> L40
        long token = Binder.clearCallingIdentity();     // Catch: Throwable -> L40
        this.mService.appDiedLocked(proc, "unstable content provider");     // Catch: Throwable -> L54
        Binder.restoreCallingIdentity(token);     // Catch: Throwable -> L40
        monitor-exit(r4);     // Catch: Throwable -> L40
        ActivityManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L31
        Trace.traceEnd(64);
        return;
    L54:
        th = move-exception;
        Binder.restoreCallingIdentity(token);     // Catch: Throwable -> L40
        throw th;     // Catch: Throwable -> L40
    L57:
        monitor-exit(r4);     // Catch: Throwable -> L40
        ActivityManagerService.resetPriorityAfterLockedSection();
        Trace.traceEnd(64);
        return;
    L63:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L31
        throw th;     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        Trace.traceEnd(64);
        throw th;
    L7:
        if (conn.provider.info == null) goto L9;
        r2 = conn.provider.info.authority;
        goto L10
    L70:
        throw new NullPointerException("connection is null");
    L72:
        String msg = "refContentProvider: " + connection + " not a ContentProviderConnection";
        Slog.w(TAG, msg);
        throw new IllegalArgumentException(msg);
    }

    void appNotRespondingViaProvider(IBinder connection) {
        this.mService.enforceCallingPermission("android.permission.REMOVE_TASKS", "appNotRespondingViaProvider()");
        ContentProviderConnection conn = (ContentProviderConnection) connection;
        if (conn != null) goto L7;
        Slog.w(TAG, "ContentProviderConnection is null");
        return;
    L7:
        if (conn.provider != null) goto L9;
    L11:
        String r2 = "";
    L12:
        ActivityManagerService.traceBegin(64, "appNotRespondingViaProvider: ", r2);
        ProcessRecord host = conn.provider.proc;     // Catch: Throwable -> L18
        if (host != null) goto L20;
        Slog.w(TAG, "Failed to find hosting ProcessRecord");     // Catch: Throwable -> L18
        Trace.traceEnd(64);
        return;
    L20:
        TimeoutRecord timeoutRecord = TimeoutRecord.forContentProvider("ContentProvider not responding");     // Catch: Throwable -> L18
        this.mService.mAnrHelper.appNotResponding(host, timeoutRecord);     // Catch: Throwable -> L18
        Trace.traceEnd(64);
        return;
    L18:
        th = move-exception;
        Trace.traceEnd(64);
        throw th;
    L9:
        if (conn.provider.info == null) goto L11;
        r2 = conn.provider.info.authority;
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r16v0, types: [com.android.server.am.ContentProviderHelper] */
    /* JADX WARN: Type inference failed for: r16v1, types: [com.android.server.am.ContentProviderHelper] */
    /* JADX WARN: Type inference failed for: r1v12, types: [com.android.server.am.ContentProviderHelper] */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v4, types: [com.android.server.am.ContentProviderHelper] */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r4v0, types: [int] */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [android.os.RemoteCallback] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v20 */
    /* JADX WARN: Type inference failed for: r6v21 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 5 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 6 */
    void getMimeTypeFilterAsync(Uri r17, int r18, final RemoteCallback r19) {
        this.mService.enforceNotIsolatedCaller("getProviderMimeTypeAsync");
        final String r2 = r17.getAuthority();
        final ?? r4 = Binder.getCallingUid();
        int r10 = Binder.getCallingPid();
        int r3 = this.mService.mUserController.unsafeConvertIncomingUser(r18);
        if (canClearIdentity(r10, r4, r3) == false) goto L5;
        long r5 = Binder.clearCallingIdentity();
    L6:
        long r13 = r5;
        int r6 = r3;
        ContentProviderHolder r0 = getContentProviderExternalUnchecked(r2, null, r4, "*getmimetype*", r6 == true ? 1 : 0);     // Catch: Throwable -> L55
        if (r0 != null) goto L29;
        if (r18 != 10) goto L29;
        if (DoppelgangerManager.isActive() == false) goto L29;
        ?? r7 = 0;
        ?? r1 = this;
        ContentProviderHolder r8 = r1.getContentProviderExternalUnchecked(r2, null, r4, "*getmimetype*", 0);     // Catch: Throwable -> L21
        final ContentProviderHelper r9 = r1;
    L31:
        if (r13 == 0) goto L69;
        Binder.restoreCallingIdentity(r13);
    L69:
    L49:
        e = e;
        ?? r11 = r17;
        ?? r12 = r19;
    L53:
        Log.w(TAG, "Content provider dead retrieving " + r11, e);
        r12.sendResult(Bundle.EMPTY);
        return;
    L74:
        if (r9.isHolderVisibleToCaller(r8, r4, r6 == true ? 1 : 0) == true) goto L36;
        r7 = r17;
        RemoteCallback r14 = r19;
        r14.sendResult(Bundle.EMPTY);     // Catch: RemoteException -> L45
        r4 = r14;
    L73:
        return;
    L36:
        if (r9.checkGetAnyTypePermission(r4, r10) == true) goto L67;
        IContentProvider r15 = r8.provider;     // Catch: RemoteException -> L49
        final Uri r16 = r17;
        final RemoteCallback r20 = r19;
        final int r21 = r6 == true ? 1 : 0;
        r15.getTypeAnonymousAsync(r16, new RemoteCallback(new ContentProviderHelper$$ExternalSyntheticLambda1(r9, r2, r21, r20, r4, r16)));     // Catch: RemoteException -> L45
        r4 = r20;
        r7 = r16;
    L47:
        e = e;
        r12 = r20;
        r11 = r16;
        goto L53
    L67:
        AttributionSource r22 = new AttributionSource.Builder(r4).build();     // Catch: RemoteException -> L39
        IContentProvider r23 = r8.provider;     // Catch: RemoteException -> L39
        final int r24 = r6 == true ? 1 : 0;
        r23.getTypeAsync(r22, r17, new RemoteCallback(new ContentProviderHelper$$ExternalSyntheticLambda0(r9, r2, r24, r19)));     // Catch: RemoteException -> L39
        return;
    L39:
        e = e;
        r11 = r17;
        r12 = r19;
    L45:
        e = e;
        r12 = r4;
        r11 = r7;
    L21:
        th = th;
    L60:
        if (r13 == 0) goto L62;
        Binder.restoreCallingIdentity(r13);
    L62:
        throw th;
    L26:
        th = th;
    L29:
        r8 = r0;
        this = this;
        r7 = r6;
    L55:
        th = th;
        goto L60
    L5:
        r5 = 0;
        goto L6
    }

    private /* synthetic */ void lambda$getMimeTypeFilterAsync$0(String name, int safeUserId, RemoteCallback resultCallback, Bundle result) {
        long identity = Binder.clearCallingIdentity();
        removeContentProviderExternalUnchecked(name, null, safeUserId);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(identity);
        resultCallback.sendResult(result);
        return;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    private /* synthetic */ void lambda$getMimeTypeFilterAsync$1(String name, int safeUserId, RemoteCallback resultCallback, int callingUid, Uri uri, Bundle result) {
        long identity = Binder.clearCallingIdentity();
        removeContentProviderExternalUnchecked(name, null, safeUserId);     // Catch: Throwable -> L8
        Binder.restoreCallingIdentity(identity);
        resultCallback.sendResult(result);
        String type = result.getPairValue();
        if (type == null) goto L13;
        logGetTypeData(callingUid, uri, type);
        return;
    L13:
        return;
    L8:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    private boolean checkGetAnyTypePermission(int callingUid, int callingPid) {
        if (this.mService.checkPermission("android.permission.GET_ANY_PROVIDER_TYPE", callingPid, callingUid) != 0) goto L6;
        return true;
    L6:
        return false;
    }

    private void logGetTypeData(int callingUid, Uri uri, String type) {
        FrameworkStatsLog.write(FrameworkStatsLog.GET_TYPE_ACCESSED_WITHOUT_PERMISSION, 1, callingUid, uri.getAuthority(), type);
    }

    private boolean canClearIdentity(int callingPid, int callingUid, int userId) {
        if (UserHandle.getUserId(callingUid) != userId) goto L6;
        return true;
    L6:
        if (ActivityManagerService.checkComponentPermission("android.permission.INTERACT_ACROSS_USERS", callingPid, callingUid, -1, true) != 0) goto L8;
        return true;
    L8:
        if (ActivityManagerService.checkComponentPermission("android.permission.INTERACT_ACROSS_USERS_FULL", callingPid, callingUid, -1, true) == 0) goto L14;
        return false;
    L14:
        return true;
    }

    private boolean isHolderVisibleToCaller(ContentProviderHolder holder, int callingUid, int userId) {
        if (holder != null) goto L5;
    L15:
        return false;
    L5:
        if (holder.info == null) goto L15;
        if (isAuthorityRedirectedForCloneProfileCached(holder.info.authority) == false) goto L14;
        if (resolveParentUserIdForCloneProfile(userId) == userId) goto L14;
        return !this.mService.getPackageManagerInternal().filterAppAccess(holder.info.packageName, callingUid, userId, false);
    L14:
        return !this.mService.getPackageManagerInternal().filterAppAccess(holder.info.packageName, callingUid, userId);
    }

    private static int resolveParentUserIdForCloneProfile(int userId) {
        UserManagerInternal umInternal = (UserManagerInternal) LocalServices.getService(UserManagerInternal.class);
        UserInfo userInfo = umInternal.getUserInfo(userId);
        if (userInfo != null) goto L5;
    L9:
        return userId;
    L5:
        if (userInfo.isCloneProfile() == false) goto L9;
        return umInternal.getProfileParentId(userId);
    }

    String checkContentProviderAccess(String authority, int userId) {
        if (userId != (-1)) goto L6;
        this.mService.mContext.enforceCallingOrSelfPermission("android.permission.INTERACT_ACROSS_USERS_FULL", TAG);
        userId = UserHandle.getCallingUserId();
    L6:
        if (isAuthorityRedirectedForCloneProfileCached(authority) == false) goto L12;
        UserManagerInternal umInternal = (UserManagerInternal) LocalServices.getService(UserManagerInternal.class);
        UserInfo userInfo = umInternal.getUserInfo(userId);
        if (userInfo == null) goto L12;
        if (userInfo.isCloneProfile() == false) goto L12;
        int userId2 = umInternal.getProfileParentId(userId);
        boolean checkUser = false;
    L13:
        ProviderInfo cpi = null;
        cpi = AppGlobals.getPackageManager().resolveContentProvider(authority, 790016, userId2);     // Catch: RemoteException -> L20
        if (cpi == null) goto L17;
    L22:
        ProviderInfo cpi2 = cpi;
    L24:
        if (cpi2 == null) goto L26;
        int callingPid = Binder.getCallingPid();
        ActivityManagerService.PidMap r1 = this.mService.mPidsSelfLocked;
        monitor-enter(r1);
        ProcessRecord r = this.mService.mPidsSelfLocked.get(callingPid);     // Catch: Throwable -> L32
        if (r != null) goto L34;
        ProcessRecord r2 = SysOptBridge.getFactory().getProcessListOptEx().findFrozenAppProcessByPid(Binder.getCallingPid());     // Catch: Throwable -> L32
    L35:
        if (r2 != null) goto L52;
        monitor-enter(this);     // Catch: Throwable -> L32
        int i = this.mService.mProcessList.mLruProcesses.size() - 1;     // Catch: Throwable -> L44
    L38:
        if (i < 0) goto L48;
        ProcessRecord app = this.mService.mProcessList.mLruProcesses.get(i);     // Catch: Throwable -> L44
        if (app == null) goto L46;
        if (app.mSmtEx.getPid() != Binder.getCallingPid()) goto L46;
        r2 = app;
    L46:
        i = i - 1;     // Catch: Throwable -> L44
        goto L38
    L48:
        monitor-exit(this);     // Catch: Throwable -> L44
    L44:
        th = move-exception;
        throw th;     // Catch: Throwable -> L32
    L52:
        if (r2 != null) goto L56;
        String r0 = "Failed to find PID " + callingPid;     // Catch: Throwable -> L32
        monitor-exit(r1);     // Catch: Throwable -> L32
        return r0;
    L56:
        String appName = r2.toString();     // Catch: Throwable -> L32
        monitor-exit(r1);     // Catch: Throwable -> L32
        return checkContentProviderPermission(cpi2, r2.mSmtEx.getPid(), Binder.getCallingUid(), userId2, checkUser, appName);
    L34:
        r2 = r;
    L32:
        th = move-exception;
        throw th;
    L26:
        return "Failed to find provider " + authority + " for user " + userId2 + "; expected to find a valid ContentProvider for this authority";
    L17:
        if (userId2 != 10) goto L22;
        cpi = DoppelgangerUtils.resolveContentProvider(authority);     // Catch: RemoteException -> L20
    L23:
        cpi2 = cpi;
    L12:
        userId2 = userId;
        checkUser = true;
        goto L13
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 3 */
    int checkContentProviderUriPermission(Uri uri, int userId, int callingUid, int modeFlags) {
        if (Thread.holdsLock(this.mService.mActivityTaskManager.getGlobalLock()) == false) goto L6;
        Slog.wtf(TAG, new IllegalStateException("Unable to check Uri permission because caller is holding WM lock; assuming permission denied"));
        return -1;
    L6:
        String name = uri.getAuthority();
        long ident = Binder.clearCallingIdentity();
        ContentProviderHolder holder = null;
    L29:
        th = th;
    L76:
        if (holder != null) goto L86;
    L82:
        Binder.restoreCallingIdentity(ident);
        throw th;
    L86:
        removeContentProviderExternalUnchecked(name, null, userId);     // Catch: Throwable -> L79
    L79:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    L99:
        holder = getContentProviderExternalUnchecked(name, null, callingUid, "*checkContentProviderUriPermission*", userId);     // Catch: Throwable -> L35 Exception -> L37 RemoteException -> L39
        if (holder == null) goto L42;
        AndroidPackage androidPackage = this.mService.getPackageManagerInternal().getPackage(Binder.getCallingUid());     // Catch: Throwable -> L35 Exception -> L37 RemoteException -> L39
        if (androidPackage == null) goto L90;
        AttributionSource attributionSource = new AttributionSource(callingUid, androidPackage.getPackageName(), null);     // Catch: Throwable -> L35 Exception -> L37 RemoteException -> L39
    L97:
        int r0 = holder.provider.checkUriPermission(attributionSource, uri, callingUid, modeFlags);     // Catch: Throwable -> L29 Exception -> L31 RemoteException -> L33
        removeContentProviderExternalUnchecked(name, null, userId);     // Catch: Throwable -> L26
        Binder.restoreCallingIdentity(ident);
        return r0;
    L26:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    L33:
        e = e;
    L67:
        Log.w(TAG, "Content provider dead retrieving " + uri, e);     // Catch: Throwable -> L29
        if (holder != null) goto L84;
    L74:
        Binder.restoreCallingIdentity(ident);
        return -1;
    L84:
        removeContentProviderExternalUnchecked(name, null, userId);     // Catch: Throwable -> L71
    L71:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    L31:
        e = e;
    L55:
        Log.w(TAG, "Exception while determining type of " + uri, e);     // Catch: Throwable -> L29
        if (holder != null) goto L94;
    L62:
        Binder.restoreCallingIdentity(ident);
        return -1;
    L94:
        removeContentProviderExternalUnchecked(name, null, userId);     // Catch: Throwable -> L59
    L59:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    L90:
        removeContentProviderExternalUnchecked(name, null, userId);     // Catch: Throwable -> L17
        Binder.restoreCallingIdentity(ident);
        return -1;
    L17:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    L42:
        if (holder != null) goto L92;
    L48:
        Binder.restoreCallingIdentity(ident);
        return -1;
    L92:
        removeContentProviderExternalUnchecked(name, null, userId);     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    L39:
        e = e;
    L37:
        e = e;
    L35:
        th = th;
        goto L76
    }

    void processContentProviderPublishTimedOutLocked(ProcessRecord app) {
        cleanupAppInLaunchingProvidersLocked(app, true);
        this.mService.mProcessList.removeProcessLocked(app, false, true, 7, 0, "timeout publishing content providers");
    }

    List<ProviderInfo> generateApplicationProvidersLocked(ProcessRecord app) {
        List<ProviderInfo> r3 = null;
        List<ProviderInfo> providers = AppGlobals.getPackageManager().queryContentProviders(app.processName, app.uid, 268438528, null).getList();     // Catch: RemoteException -> L51
        if (providers != null) goto L7;
        return null;
    L7:
        if (ActivityManagerDebugConfig.DEBUG_MU == false) goto L10;
        Slog.v("ActivityManager_MU", "generateApplicationProvidersLocked, app.info.uid = " + app.uid);
    L10:
        if (Build.isDebuggable() == false) goto L12;
        SysMonitorFwBridge.getFactory().getCustomLeakCanaryUtils().checkProviders(app.info.packageName, providers);
    L12:
        int numProviders = providers.size();
        ProcessProviderRecord pr = app.mProviders;
        pr.ensureProviderCapacity(pr.numberOfProviders() + numProviders);
        int i = 0;
    L13:
        if (i >= numProviders) goto L46;
        ProviderInfo cpi = providers.get(i);
        boolean singleton = this.mService.isSingleton(cpi.processName, cpi.applicationInfo, cpi.name, cpi.flags);
        if (isSingletonOrSystemUserOnly(cpi) == true) goto L17;
    L19:
        boolean isInstantApp = cpi.applicationInfo.isInstantApp();
        if (cpi.splitName != null) goto L22;
    L25:
        boolean r9 = true;
    L26:
        boolean splitInstalled = r9;
        if (isInstantApp == false) goto L30;
        if (splitInstalled == true) goto L30;
        providers.remove(i);
        numProviders = numProviders - 1;
        i = i - 1;
        r3 = r3;
    L45:
        i = i + 1;
        r3 = r3;
    L30:
        ComponentName comp = new ComponentName(cpi.packageName, cpi.name);
        ContentProviderRecord cpr = this.mProviderMap.getProviderByClass(comp, app.userId);
        if (cpr != null) goto L33;
        ContentProviderRecord cpr2 = new ContentProviderRecord(this.mService, cpi, app.info, comp, singleton);
        this.mProviderMap.putProviderByClass(comp, cpr2);
    L35:
        if (ActivityManagerDebugConfig.DEBUG_MU == false) goto L37;
        Slog.v("ActivityManager_MU", "generateApplicationProvidersLocked, cpi.uid = " + cpr2.uid);
    L37:
        pr.installProvider(cpi.name, cpr2);
        app.getSmtEx().setFreezeBlockFlagsLocked(1, cpr2);
        if (cpi.multiprocess == true) goto L40;
    L43:
        app.addPackage(cpi.applicationInfo.packageName, cpi.applicationInfo.longVersionCode, this.mService.mProcessStats);
    L44:
        this.mService.notifyPackageUse(cpi.applicationInfo.packageName, 4);
        numProviders = numProviders;
        goto L45
    L40:
        if (PackageManagerService.PLATFORM_PACKAGE_NAME.equals(cpi.packageName) == true) goto L44;
    L33:
        cpr2 = cpr;
        goto L35
    L22:
        if (ArrayUtils.contains(cpi.applicationInfo.splitNames, cpi.splitName) == true) goto L25;
        r9 = false;
        goto L26
    L17:
        if (app.userId == 0) goto L19;
        providers.remove(i);
        numProviders = numProviders - 1;
        i = i - 1;
        r3 = r3;
        goto L45
    L46:
        List<ProviderInfo> r17 = r3;
        if (providers.isEmpty() == false) goto L50;
        return r17;
    L50:
        return providers;
    L53:
        return null;
    }

    public final void installSystemProviders() {
        ActivityManagerService r0 = this.mService;
        ActivityManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        ProcessRecord app = (ProcessRecord) this.mService.mProcessList.getProcessNamesLOSP().get("system", 1000);     // Catch: Throwable -> L11
        List<ProviderInfo> providers = generateApplicationProvidersLocked(app);     // Catch: Throwable -> L11
        if (providers == null) goto L14;
        int i = providers.size() - 1;     // Catch: Throwable -> L11
    L7:
        if (i < 0) goto L14;
        ProviderInfo pi = providers.get(i);     // Catch: Throwable -> L11
        if ((pi.applicationInfo.flags & 1) != 0) goto L13;
        Slog.w(TAG, "Not installing system proc provider " + pi.name + ": not system .apk");     // Catch: Throwable -> L11
        providers.remove(i);     // Catch: Throwable -> L11
    L13:
        i = i - 1;     // Catch: Throwable -> L11
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L11
        ActivityManagerService.resetPriorityAfterLockedSection();
        if (providers == null) goto L18;
        this.mService.mSystemThread.installSystemProviders(providers);
    L18:
        monitor-enter(this);
        this.mSystemProvidersInstalled = true;     // Catch: Throwable -> L23
        monitor-exit(this);     // Catch: Throwable -> L23
        this.mService.mConstants.start(this.mService.mContext.getContentResolver());
        this.mService.mCoreSettingsObserver = new CoreSettingsObserver(this.mService);
        this.mService.mActivityTaskManager.installSystemProviders();
        new DevelopmentSettingsObserver(this);
        SettingsToPropertiesMapper.start(this.mService.mContext.getContentResolver());
        this.mService.mOomAdjuster.initSettings();
        CrashRecoveryAdaptor.rescuePartyOnSettingsProviderPublished(this.mService.mContext);
        return;
    L23:
        th = move-exception;
        throw th;
    L11:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    void installEncryptionUnawareProviders(int userId) {
        ActivityManagerGlobalLock r1 = this.mService.mProcLock;
        ActivityManagerService.boostPriorityForProcLockedSection();
        monitor-enter(r1);
        ArrayMap<String, SparseArray<ProcessRecord>> pmap = this.mService.mProcessList.getProcessNamesLOSP().getMap();     // Catch: Throwable -> L16
        int numProc = pmap.size();     // Catch: Throwable -> L16
        int iProc = 0;
    L5:
        if (iProc >= numProc) goto L21;
        SparseArray<ProcessRecord> apps = pmap.valueAt(iProc);     // Catch: Throwable -> L16
        int iApp = 0;
        int numApps = apps.size();     // Catch: Throwable -> L16
    L7:
        if (iApp >= numApps) goto L19;
        final ProcessRecord app = apps.valueAt(iApp);     // Catch: Throwable -> L16
        if (app.userId != userId) goto L18;
        if (app.getThread() == null) goto L18;
        if (app.isUnlocked() == true) goto L18;
        app.getPkgList().forEachPackage(new ContentProviderHelper$$ExternalSyntheticLambda4(this, app));     // Catch: Throwable -> L16
    L18:
        iApp = iApp + 1;     // Catch: Throwable -> L16
        goto L7
    L19:
        iProc = iProc + 1;     // Catch: Throwable -> L16
        goto L5
    L21:
        monitor-exit(r1);     // Catch: Throwable -> L16
        ActivityManagerService.resetPriorityAfterProcLockedSection();
        return;
    L16:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterProcLockedSection();
        throw th;
    }

    private /* synthetic */ void lambda$installEncryptionUnawareProviders$2(ProcessRecord app, String pkgName) {
        PackageInfo pkgInfo = AppGlobals.getPackageManager().getPackageInfo(pkgName, 262152, app.userId);     // Catch: Throwable -> L17
        IApplicationThread thread = app.getThread();     // Catch: Throwable -> L17
        if (pkgInfo == null) goto L62;
        if (ArrayUtils.isEmpty(pkgInfo.providers) == true) goto L62;
        ProviderInfo[] r3 = pkgInfo.providers;     // Catch: Throwable -> L17
        int r4 = r3.length;     // Catch: Throwable -> L17
        int r7 = 0;
    L10:
        if (r7 >= r4) goto L63;
        ProviderInfo pi = r3[r7];     // Catch: Throwable -> L17
        boolean splitInstalled = true;
        if (Objects.equals(pi.processName, app.processName) == true) goto L19;
        if (pi.multiprocess == true) goto L19;
        boolean processMatch = false;
    L53:
        if (isSingletonOrSystemUserOnly(pi) == false) goto L29;
        if (app.userId == 0) goto L29;
        boolean userMatch = false;
    L30:
        boolean isInstantApp = pi.applicationInfo.isInstantApp();     // Catch: Throwable -> L27
        if (pi.splitName == null) goto L38;
        if (ArrayUtils.contains(pi.applicationInfo.splitNames, pi.splitName) == true) goto L38;
        splitInstalled = false;
    L38:
        if (processMatch == false) goto L43;
        if (userMatch == false) goto L43;
        if (isInstantApp == false) goto L42;
        if (splitInstalled == false) goto L43;
    L42:
        Log.v(TAG, "Installing " + pi);     // Catch: Throwable -> L27 Throwable -> L27
        thread.scheduleInstallProvider(pi);     // Catch: Throwable -> L27 Throwable -> L27
    L44:
        r7 = r7 + 1;
    L43:
        Log.v(TAG, "Skipping " + pi);     // Catch: Throwable -> L27 Throwable -> L27
    L29:
        userMatch = true;
    L61:
        return;
    L19:
        processMatch = true;
        goto L53
    L63:
        return;
    L62:
        return;
    L60:
        return;
    }

    private ContentProviderConnection incProviderCountLocked(ProcessRecord r, ContentProviderRecord cpr, IBinder externalProcessToken, int callingUid, String callingPackage, String callingTag, boolean stable, boolean updateLru, long startTime, ProcessList processList, int expectedUserId) {
        if (r != null) goto L6;
        this.mService.mProcessStateController.addExternalProviderClient(cpr, externalProcessToken, callingUid, callingTag);
        return null;
    L6:
        ProcessProviderRecord pr = r.mProviders;
        int i = 0;
        int size = pr.numberOfProviderConnections();
    L7:
        if (i >= size) goto L13;
        ContentProviderConnection conn = pr.getProviderConnectionAt(i);
        if (conn.provider == cpr) goto L10;
        i = i + 1;
        goto L7
    L10:
        conn.incrementCount(stable);
        return conn;
    L13:
        ContentProviderConnection conn2 = new ContentProviderConnection(cpr, r, callingPackage, expectedUserId);
        conn2.startAssociationIfNeeded();
        conn2.initializeCount(stable);
        if (cpr != null) goto L16;
    L22:
        cpr.connections.add(conn2);
        if (cpr.proc == null) goto L25;
        cpr.proc.mProfile.addHostingComponentType(64);
    L25:
        this.mService.mProcessStateController.addProviderConnection(r, conn2);
        this.mService.startAssociationLocked(r.uid, r.processName, r.mState.getCurProcState(), cpr.uid, cpr.appInfo.longVersionCode, cpr.name, cpr.info.processName);
        if (updateLru == false) goto L34;
        if (cpr.proc == null) goto L34;
        if (r.mState.getSetAdj() > 250) goto L34;
        checkTime(startTime, "getContentProviderImpl: before updateLruProcess");
        processList.updateLruProcessLocked(cpr.proc, false, null);
        checkTime(startTime, "getContentProviderImpl: after updateLruProcess");
    L34:
        return conn2;
    L16:
        if (cpr.proc == null) goto L22;
        if (conn2.client == null) goto L22;
        if (cpr.proc.uid == conn2.client.uid) goto L22;
        SysOptBridge.getFactory().getFreezeController().importantProviderChange(cpr.proc.uid, true, conn2.client);
        goto L22
    }

    private boolean decProviderCountLocked(final ContentProviderConnection conn, ContentProviderRecord cpr, IBinder externalProcessToken, final boolean stable, boolean enforceDelay, final boolean updateOomAdj) {
        if (conn != null) goto L6;
        this.mService.mProcessStateController.removeExternalProviderClient(cpr, externalProcessToken);
        return false;
    L6:
        if (cpr == null) goto L15;
        if (cpr.proc == null) goto L15;
        if (conn.client == null) goto L15;
        if (cpr.proc.uid == conn.client.uid) goto L15;
        SysOptBridge.getFactory().getFreezeController().importantProviderChange(cpr.proc.uid, false, conn.client);
    L15:
        if (conn.totalRefCount() <= 1) goto L18;
        conn.decrementCount(stable);
        return false;
    L18:
        if (enforceDelay == false) goto L20;
        BackgroundThread.getHandler().postDelayed(new ContentProviderHelper$$ExternalSyntheticLambda3(this, conn, stable, updateOomAdj), 5000);
    L21:
        return true;
    L20:
        handleProviderRemoval(conn, stable, updateOomAdj);
        goto L21
    }

    private /* synthetic */ void lambda$decProviderCountLocked$3(ContentProviderConnection conn, boolean stable, boolean updateOomAdj) {
        handleProviderRemoval(conn, stable, updateOomAdj);
    }

    private boolean hasProviderConnectionLocked(ProcessRecord proc) {
        int i = proc.mProviders.numberOfProviders() - 1;
    L3:
        if (i < 0) goto L8;
        if (proc.mProviders.getProviderAt(i).connections.isEmpty() == false) goto L6;
        i = i - 1;
        goto L3
    L6:
        return true;
    L8:
        return false;
    }

    private void handleProviderRemoval(ContentProviderConnection conn, boolean stable, boolean updateOomAdj) {
        ActivityManagerService r1 = this.mService;
        ActivityManagerService.boostPriorityForLockedSection();
        monitor-enter(r1);
        if (conn == null) goto L30;
    L15:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterLockedSection();
        throw th;
    L6:
        if (conn.provider == null) goto L30;
        if (conn.decrementCount(stable) != 0) goto L30;
        ContentProviderRecord cpr = conn.provider;     // Catch: Throwable -> L15
        conn.stopAssociation();     // Catch: Throwable -> L15
        cpr.connections.remove(conn);     // Catch: Throwable -> L15
        if (cpr.proc != null) goto L13;
    L17:
        this.mService.mProcessStateController.removeProviderConnection(conn.client, conn);     // Catch: Throwable -> L15
        if (conn.client.mState.getSetProcState() < 15) goto L20;
    L22:
        this.mService.stopAssociationLocked(conn.client.uid, conn.client.processName, cpr.uid, cpr.appInfo.longVersionCode, cpr.name, cpr.info.processName);     // Catch: Throwable -> L15
        if (updateOomAdj == true) goto L25;
    L27:
        monitor-exit(r1);     // Catch: Throwable -> L15
        ActivityManagerService.resetPriorityAfterLockedSection();
        return;
    L25:
        if (this.mService.mOomAdjuster.evaluateProviderConnectionRemoval(conn.client, cpr.proc) == false) goto L27;
        this.mService.getSmtEx().scheduleUpdateOomAdj(false);     // Catch: Throwable -> L15
        goto L27
    L20:
        if (cpr.proc == null) goto L22;
        this.mService.mProcessStateController.setLastProviderTime(cpr.proc, SystemClock.uptimeMillis());     // Catch: Throwable -> L15
        goto L22
    L13:
        if (hasProviderConnectionLocked(cpr.proc) == true) goto L17;
        cpr.proc.mProfile.clearHostingComponentType(64);     // Catch: Throwable -> L15
    L30:
        monitor-exit(r1);     // Catch: Throwable -> L15
        ActivityManagerService.resetPriorityAfterLockedSection();
    }

    private String checkContentProviderPermission(ProviderInfo cpi, int callingPid, int callingUid, int userId, boolean checkUser, String appName) {
        if (canAccessContentProviderFromSdkSandbox(cpi, callingUid) == true) goto L7;
        return "ContentProvider access not allowed from sdk sandbox UID. ProviderInfo: " + cpi.toString();
    L7:
        if (checkUser == false) goto L18;
        int tmpTargetUserId = this.mService.mUserController.unsafeConvertIncomingUser(userId);
        if (tmpTargetUserId != UserHandle.getUserId(callingUid)) goto L11;
        boolean checkedGrants = false;
    L15:
        int userId2 = this.mService.mUserController.handleIncomingUser(callingPid, callingUid, userId, false, 0, "checkContentProviderPermissionLocked " + cpi.authority, null);
        if (userId2 == tmpTargetUserId) goto L20;
        checkedGrants = false;
    L20:
        if (ActivityManagerService.checkComponentPermission(cpi.readPermission, callingPid, callingUid, cpi.applicationInfo.uid, cpi.exported) != 0) goto L23;
        return null;
    L23:
        if (ActivityManagerService.checkComponentPermission(cpi.writePermission, callingPid, callingUid, cpi.applicationInfo.uid, cpi.exported) != 0) goto L25;
        return null;
    L25:
        PathPermission[] pps = cpi.pathPermissions;
        if (pps == null) goto L41;
        int i = pps.length;
    L28:
        if (i <= 0) goto L41;
        i = i - 1;
        PathPermission pp = pps[i];
        String pprperm = pp.getReadPermission();
        if (pprperm != null) goto L32;
    L34:
        String ppwperm = pp.getWritePermission();
        if (ppwperm == null) goto L28;
        if (ActivityManagerService.checkComponentPermission(ppwperm, callingPid, callingUid, cpi.applicationInfo.uid, cpi.exported) != 0) goto L28;
        return null;
    L32:
        if (ActivityManagerService.checkComponentPermission(pprperm, callingPid, callingUid, cpi.applicationInfo.uid, cpi.exported) != 0) goto L34;
        return null;
    L41:
        if (checkedGrants == true) goto L46;
        if (this.mService.mUgmInternal.checkAuthorityGrants(callingUid, cpi, userId2, checkUser) == false) goto L46;
        return null;
    L46:
        if (cpi.exported == true) goto L49;
        String suffix = " that is not exported from UID " + cpi.applicationInfo.uid;
    L52:
        StringBuilder r5 = new StringBuilder();
        r5.append("Permission Denial: opening provider ");
        r5.append(cpi.name);
        r5.append(" from ");
        if (appName == null) goto L55;
        String r6 = appName;
    L56:
        r5.append(r6);
        r5.append(" (pid=");
        r5.append(callingPid);
        r5.append(", uid=");
        r5.append(callingUid);
        r5.append(")");
        r5.append(suffix);
        String msg = r5.toString();
        Slog.w(TAG, msg);
        return msg;
    L55:
        r6 = "(null)";
        goto L56
    L49:
        if ("android.permission.MANAGE_DOCUMENTS".equals(cpi.readPermission) == false) goto L51;
        suffix = " requires that you obtain access using ACTION_OPEN_DOCUMENT or related APIs";
        goto L52
    L51:
        suffix = " requires " + cpi.readPermission + " or " + cpi.writePermission;
        goto L52
    L11:
        if (this.mService.mUgmInternal.checkAuthorityGrants(callingUid, cpi, tmpTargetUserId, checkUser) == false) goto L13;
        return null;
    L13:
        checkedGrants = true;
        goto L15
    L18:
        checkedGrants = false;
        userId2 = userId;
        goto L20
    }

    private String checkContentProviderAssociation(final ProcessRecord callingApp, int callingUid, final ProviderInfo cpi) {
        if (callingApp == null) goto L4;
        String r = (String) callingApp.getPkgList().searchEachPackage(new ContentProviderHelper$$ExternalSyntheticLambda2(this, callingApp, cpi));
        return r;
    L4:
        if (this.mService.validateAssociationAllowedLocked(cpi.packageName, cpi.applicationInfo.uid, null, callingUid) == true) goto L10;
        return "<null>";
    L10:
        return null;
    }

    private /* synthetic */ String lambda$checkContentProviderAssociation$4(ProcessRecord callingApp, ProviderInfo cpi, String pkgName) {
        if (this.mService.validateAssociationAllowedLocked(pkgName, callingApp.uid, cpi.packageName, cpi.applicationInfo.uid) == false) goto L5;
        return null;
    L5:
        return cpi.packageName;
    }

    ProviderInfo getProviderInfoLocked(String authority, int userId, int pmFlags) {
        ContentProviderRecord cpr = this.mProviderMap.getProviderByName(authority, userId);
        if (cpr != null) goto L5;
        return AppGlobals.getPackageManager().resolveContentProvider(authority, pmFlags | 2048, userId);
    L9:
        return null;
    L5:
        return cpr.info;
    }

    private void maybeUpdateProviderUsageStatsLocked(ProcessRecord app, String providerPkgName, String authority) {
        if (app != null) goto L4;
        return;
    L4:
        if (app.mState.getCurProcState() > 6) goto L20;
        UserState userState = this.mService.mUserController.getStartedUserState(app.userId);
        if (userState != null) goto L9;
        return;
    L9:
        long now = SystemClock.elapsedRealtime();
        Long lastReported = userState.mProviderLastReportedFg.get(authority);
        if (lastReported == null) goto L14;
        if (lastReported.longValue() < (now - 60000)) goto L14;
        return;
    L14:
        if (this.mService.mSystemReady == false) goto L16;
        this.mService.mUsageStatsService.reportContentProviderUsage(authority, providerPkgName, app.userId);
    L16:
        userState.mProviderLastReportedFg.put(authority, Long.valueOf(now));
        return;
    }

    static {
        PROCESS_STATE_STATS_FORMAT = new int[]{32, FrameworkStatsLog.PACKAGE_MANAGER_SNAPSHOT_REPORTED, 10272};
    }

    private boolean isProcessAliveLocked(ProcessRecord proc) {
        int pid = proc.getPid();
        if (pid <= 0) goto L5;
        String procStatFile = "/proc/" + pid + "/stat";
        this.mProcessStateStatsLongs[0] = 0;
        if (Process.readProcFile(procStatFile, PROCESS_STATE_STATS_FORMAT, null, this.mProcessStateStatsLongs, null) == false) goto L11;
        long state = this.mProcessStateStatsLongs[0];
        if (ActivityManagerDebugConfig.DEBUG_OOM_ADJ == false) goto L18;
        Slog.d("ActivityManager", "RETRIEVED STATE FOR " + procStatFile + ": " + ((char) state));
    L18:
        if (state != 90) goto L20;
    L29:
        return false;
    L20:
        if (state == 88) goto L29;
        if (state == 120) goto L29;
        if (state == 75) goto L29;
        if (Process.getUidForPid(pid) != proc.uid) goto L30;
        return true;
    L30:
        return false;
    L11:
        if (ActivityManagerDebugConfig.DEBUG_OOM_ADJ == false) goto L13;
        Slog.d("ActivityManager", "UNABLE TO RETRIEVE STATE FOR " + procStatFile);
    L13:
        return false;
    L5:
        if (ActivityManagerDebugConfig.DEBUG_OOM_ADJ == false) goto L7;
        Slog.d("ActivityManager", "Process hasn't started yet: " + proc);
    L7:
        return false;
    }

    private boolean requestTargetProviderPermissionsReviewIfNeededLocked(ProviderInfo cpi, ProcessRecord r, int userId, Context context) {
        boolean callerForeground = true;
        if (this.mService.getPackageManagerInternal().isPermissionsReviewRequired(cpi.packageName, userId) == true) goto L6;
        return true;
    L6:
        if (r == null) goto L13;
        if (r.mState.getSetSchedGroup() != 0) goto L13;
        callerForeground = false;
    L13:
        if (callerForeground == true) goto L16;
        Slog.w(TAG, "u" + userId + " Instantiating a provider in package " + cpi.packageName + " requires a permissions review");
        return false;
    L16:
        Intent intent = new Intent("android.intent.action.REVIEW_PERMISSIONS");
        intent.addFlags(276824064);
        intent.putExtra("android.intent.extra.PACKAGE_NAME", cpi.packageName);
        if (ActivityManagerDebugConfig.DEBUG_PERMISSIONS_REVIEW == false) goto L19;
        Slog.i(TAG, "u" + userId + " Launching permission review for package " + cpi.packageName);
    L19:
        UserHandle userHandle = new UserHandle(userId);
        this.mService.mHandler.post(new StartActivityRunnable(context, intent, userHandle));
        return false;
    }

    boolean removeDyingProviderLocked(ProcessRecord proc, ContentProviderRecord cpr, boolean always) {
        boolean inLaunching = this.mLaunchingProviders.contains(cpr);
        int r5 = 0;
        boolean r6 = true;
        if (proc != null) goto L5;
    L7:
        boolean r0 = false;
    L8:
        boolean freezing = r0;
        if (inLaunching == false) goto L14;
        if (always == true) goto L14;
        int r1 = cpr.mRestartCount + 1;
        cpr.mRestartCount = r1;
        if (r1 <= 3) goto L14;
        boolean always2 = true;
    L15:
        int i = cpr.connections.size() - 1;
    L16:
        if (i < 0) goto L67;
        ContentProviderConnection conn = cpr.connections.get(i);
        if (conn.waiting == false) goto L22;
        if (inLaunching == false) goto L22;
        if (always2 == true) goto L22;
    L65:
        i = i - 1;
        r5 = 0;
        r6 = true;
    L22:
        ProcessRecord capp = conn.client;
        if (freezing == true) goto L25;
    L27:
        IApplicationThread thread = capp.getThread();
        conn.dead = r6;
        if (conn.stableCount() <= 0) goto L45;
        int pid = capp.getPid();
        if (capp.isPersistent() == true) goto L65;
        if (thread == null) goto L65;
        if (pid == 0) goto L65;
        if (pid == ActivityManagerService.MY_PID) goto L65;
        StringBuilder r13 = new StringBuilder();
        r13.append("depends on provider ");
        r13.append(cpr.name.flattenToShortString());
        r13.append(" in dying proc ");
        if (proc == null) goto L38;
        String r14 = proc.processName;
    L39:
        r13.append(r14);
        r13.append(" (adj ");
        if (proc == null) goto L42;
        Object r15 = Integer.valueOf(proc.mState.getSetAdj());
    L43:
        r13.append(r15);
        r13.append(")");
        capp.killLocked(r13.toString(), 12, r5, r6);
        goto L65
    L42:
        r15 = "??";
        goto L43
    L38:
        r14 = "??";
        goto L39
    L45:
        if (thread == null) goto L65;
        if (conn.provider.provider == null) goto L65;
        thread.unstableProviderDied(conn.provider.provider.asBinder());     // Catch: RemoteException -> L50
    L51:
        cpr.connections.remove(i);
        if (cpr.proc == null) goto L57;
        if (hasProviderConnectionLocked(cpr.proc) == true) goto L57;
        cpr.proc.mProfile.clearHostingComponentType(64);
    L57:
        if (conn.client.mProviders.removeProviderConnection(conn) == false) goto L65;
        this.mService.stopAssociationLocked(capp.uid, capp.processName, cpr.uid, cpr.appInfo.longVersionCode, cpr.name, cpr.info.processName);
        if (cpr.proc == null) goto L65;
        if (conn.client == null) goto L65;
        if (cpr.proc.uid == conn.client.uid) goto L65;
        SysOptBridge.getFactory().getFreezeController().clientConnectionRemoveEvent(cpr.proc.uid, conn.client.uid);
        goto L65
    L25:
        if (capp.info.getSmtUid() != proc.info.getSmtUid()) goto L27;
    L67:
        if (inLaunching == false) goto L69;
        if (always2 == true) goto L69;
    L88:
        if (inLaunching == false) goto L117;
        if (always2 == false) goto L118;
        this.mLaunchingProviders.remove(cpr);
        cpr.mRestartCount = 0;
        return false;
    L118:
        return inLaunching;
    L117:
        return inLaunching;
    L69:
        monitor-enter(cpr);
        cpr.launchingApp = null;     // Catch: Throwable -> L92
        cpr.notifyAll();     // Catch: Throwable -> L92
        cpr.onProviderPublishStatusLocked(false);     // Catch: Throwable -> L92
        this.mService.mHandler.removeMessages(73, cpr);     // Catch: Throwable -> L92
        monitor-exit(cpr);     // Catch: Throwable -> L92
        int userId = UserHandle.getUserId(cpr.uid);
        boolean removed = false;
        if (this.mProviderMap.getProviderByClass(cpr.name, userId) != cpr) goto L76;
        this.mProviderMap.removeProviderByClass(cpr.name, userId);
        removed = true;
    L76:
        String[] names = cpr.info.authority.split(";");
        int j = 0;
    L78:
        if (j >= names.length) goto L84;
        if (this.mProviderMap.getProviderByName(names[j], userId) != cpr) goto L82;
        this.mProviderMap.removeProviderByName(names[j], userId);
        removed = true;
    L82:
        j = j + 1;
        goto L78
    L84:
        if (removed == false) goto L88;
        if (cpr.proc == null) goto L88;
        this.mService.mProcessStateController.removePublishedProvider(cpr.proc, cpr.info.name);
    L92:
        th = move-exception;
        throw th;
    L14:
        always2 = always;
        goto L15
    L5:
        if (proc.getSmtEx().isFreezing() == false) goto L7;
        r0 = true;
        goto L8
    }

    boolean checkAppInLaunchingProvidersLocked(ProcessRecord app) {
        int i = this.mLaunchingProviders.size() - 1;
    L3:
        if (i < 0) goto L8;
        ContentProviderRecord cpr = this.mLaunchingProviders.get(i);
        if (cpr.launchingApp == app) goto L6;
        i = i - 1;
        goto L3
    L6:
        return true;
    L8:
        return false;
    }

    int checkLaunchingProviderPidLocked(ProcessRecord app) {
        int j = this.mLaunchingProviders.size() - 1;
    L3:
        if (j < 0) goto L22;
        ContentProviderRecord cpr = this.mLaunchingProviders.get(j);
        int numOfConns = cpr.connections.size();
        int i = 0;
    L5:
        if (i >= numOfConns) goto L21;
        ContentProviderConnection conn = cpr.connections.get(i);
        if (conn.waiting == false) goto L20;
        if (conn.client == null) goto L20;
        ProcessRecord client = conn.client;
        if (client != app) goto L20;
        Slog.i(TAG, "" + app.getPid() + " acquire provider app=" + cpr.launchingApp + ",cpr.proc=" + cpr.proc);
        if (cpr.launchingApp != null) goto L15;
        if (cpr.proc == null) goto L20;
        return cpr.proc.getPid();
    L15:
        return cpr.launchingApp.getPid();
    L20:
        i = i + 1;
        goto L5
    L21:
        j = j - 1;
        goto L3
    L22:
        return 0;
    }

    boolean cleanupAppInLaunchingProvidersLocked(ProcessRecord app, boolean alwaysBad) {
        boolean restart = false;
        int i = this.mLaunchingProviders.size() - 1;
    L3:
        if (i < 0) goto L19;
        ContentProviderRecord cpr = this.mLaunchingProviders.get(i);
        if (cpr.launchingApp != app) goto L17;
        int r4 = cpr.mRestartCount + 1;
        cpr.mRestartCount = r4;
        if (r4 <= 3) goto L10;
        alwaysBad = true;
    L10:
        if (alwaysBad == false) goto L12;
    L16:
        removeDyingProviderLocked(app, cpr, true);
        goto L17
    L12:
        if (app.mErrorState.isBad() == true) goto L16;
        if (cpr.hasConnectionOrHandle() == false) goto L16;
        restart = true;
    L17:
        i = i - 1;
        goto L3
    L19:
        return restart;
    }

    void cleanupLaunchingProvidersLocked() {
        int i = this.mLaunchingProviders.size() - 1;
    L3:
        if (i < 0) goto L18;
        ContentProviderRecord cpr = this.mLaunchingProviders.get(i);
        if (cpr.connections.size() > 0) goto L16;
        if (cpr.hasExternalProcessHandles() == true) goto L16;
        monitor-enter(cpr);
        cpr.launchingApp = null;     // Catch: Throwable -> L13
        cpr.notifyAll();     // Catch: Throwable -> L13
        monitor-exit(cpr);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    L16:
        i = i - 1;
        goto L3
    }

    private void checkTime(long startTime, String where) {
        long now = SystemClock.uptimeMillis();
        if ((now - startTime) <= 50) goto L6;
        Slog.w(TAG, "Slow operation: " + (now - startTime) + "ms so far, now at " + where);
        return;
    }

    void dumpProvidersLocked(FileDescriptor fd, PrintWriter pw, String[] args, int opti, boolean dumpAll, String dumpPackage) {
        ActivityManagerService.ItemMatcher matcher = new ActivityManagerService.ItemMatcher();
        matcher.build(args, opti);
        pw.println("ACTIVITY MANAGER CONTENT PROVIDERS (dumpsys activity providers)");
        boolean needSep = this.mProviderMap.dumpProvidersLocked(pw, dumpAll, dumpPackage);
        boolean printedAnything = needSep;
        if (this.mLaunchingProviders.size() <= 0) goto L17;
        boolean printed = false;
        int i = this.mLaunchingProviders.size() - 1;
    L5:
        if (i < 0) goto L17;
        ContentProviderRecord r = this.mLaunchingProviders.get(i);
        if (dumpPackage != null) goto L9;
    L11:
        if (printed == true) goto L15;
        if (needSep == false) goto L14;
        pw.println();
    L14:
        needSep = true;
        pw.println("  Launching content providers:");
        printed = true;
        printedAnything = true;
    L15:
        pw.print("  Launching #");
        pw.print(i);
        pw.print(": ");
        pw.println(r);
    L16:
        i = i - 1;
        goto L5
    L9:
        if (dumpPackage.equals(r.name.getPackageName()) == true) goto L11;
    L17:
        if (printedAnything == true) goto L23;
        pw.println("  (nothing)");
        return;
    }

    private boolean canAccessContentProviderFromSdkSandbox(ProviderInfo cpi, int callingUid) {
        if (Process.isSdkSandboxUid(callingUid) == true) goto L6;
        return true;
    L6:
        SdkSandboxManagerLocal sdkSandboxManagerLocal = (SdkSandboxManagerLocal) LocalManagerRegistry.getManager(SdkSandboxManagerLocal.class);
        if (sdkSandboxManagerLocal == null) goto L11;
        return sdkSandboxManagerLocal.canAccessContentProviderFromSdkSandbox(cpi);
    L11:
        throw new IllegalStateException("SdkSandboxManagerLocal not found when checking whether SDK sandbox uid may access the contentprovider.");
    }

    protected boolean dumpProvider(FileDescriptor fd, PrintWriter pw, String name, String[] args, int opti, boolean dumpAll) {
        return this.mProviderMap.dumpProvider(fd, pw, name, args, opti, dumpAll);
    }

    protected boolean dumpProviderProto(FileDescriptor fd, PrintWriter pw, String name, String[] args) {
        return this.mProviderMap.dumpProviderProto(fd, pw, name, args);
    }

    private boolean isAuthorityRedirectedForCloneProfileCached(String auth) {
        if (this.mCloneProfileAuthorityRedirectionCache.containsKey(auth) == false) goto L9;
        Boolean retVal = this.mCloneProfileAuthorityRedirectionCache.get(auth);
        if (retVal != null) goto L8;
        return false;
    L8:
        return retVal.booleanValue();
    L9:
        boolean isAuthRedirected = ContentProvider.isAuthorityRedirectedForCloneProfile(auth);
        this.mCloneProfileAuthorityRedirectionCache.put(auth, Boolean.valueOf(isAuthRedirected));
        return isAuthRedirected;
    }

    private boolean isSingletonOrSystemUserOnly(ProviderInfo pi) {
        if (this.mService.isSystemUserOnly(pi.flags) == false) goto L5;
    L8:
        return true;
    L5:
        if (this.mService.isSingleton(pi.processName, pi.applicationInfo, pi.name, pi.flags) == true) goto L8;
        return false;
    }
}
