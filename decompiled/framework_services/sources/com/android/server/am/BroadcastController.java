package com.android.server.am;

import android.R;
import android.app.ActivityManager;
import android.app.AppGlobals;
import android.app.BackgroundStartPrivileges;
import android.app.BroadcastOptions;
import android.app.BroadcastStickyCache;
import android.app.IApplicationThread;
import android.app.compat.CompatChanges;
import android.content.ComponentName;
import android.content.Context;
import android.content.IIntentReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.IPackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.UserInfo;
import android.hardware.tv.mediaquality.ParameterName;
import android.net.Uri;
import android.os.Binder;
import android.os.BinderProxy;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Process;
import android.os.RemoteException;
import android.os.SystemClock;
import android.os.Trace;
import android.os.UserHandle;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.EventLog;
import android.util.Log;
import android.util.PrintWriterPrinter;
import android.util.Slog;
import android.util.SparseArray;
import android.util.TimeUtils;
import android.util.proto.ProtoOutputStream;
import com.android.server.IntentResolver;
import com.android.server.LocalManagerRegistry;
import com.android.server.LocalServices;
import com.android.server.SysOptBridge;
import com.android.server.SystemConfig;
import com.android.server.pm.SaferIntentUtils;
import com.android.server.pm.UserManagerInternal;
import com.android.server.pm.snapshot.PackageDataSnapshot;
import com.android.server.pm.verify.domain.DomainVerificationPersistence;
import com.android.server.sdksandbox.SdkSandboxManagerLocal;
import com.android.server.storage.DeviceStorageMonitorServiceSmtEx;
import com.android.server.utils.Slogf;
import dalvik.annotation.optimization.NeverCompile;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

/* JADX INFO: loaded from: classes.dex */
class BroadcastController {
    private static final long DYNAMIC_RECEIVER_EXPLICIT_EXPORT_REQUIRED = 161145287;
    private static final int MAX_RECEIVERS_ALLOWED_PER_APP = 1000;
    private static final String TAG_BROADCAST = "ActivityManager";
    private volatile boolean mAreStickyCachesInvalidated;
    private ArraySet<String> mBackgroundLaunchBroadcasts;
    private BroadcastQueue mBroadcastQueue;
    private final Context mContext;
    BroadcastStats mCurBroadcastStats;
    BroadcastStats mLastBroadcastStats;
    final IntentResolver<BroadcastFilter, BroadcastFilter> mReceiverResolver;
    final HashMap<IBinder, ReceiverList> mRegisteredReceivers;
    private final ActivityManagerService mService;
    final SparseArray<ArrayMap<String, ArrayList<StickyBroadcast>>> mStickyBroadcasts;

    static final class StickyBroadcast {
        public boolean deferUntilActive;
        public Intent intent;
        public int originalCallingAppProcessState;
        public int originalCallingUid;
        public String resolvedDataType;

        StickyBroadcast() {
        }

        public static StickyBroadcast create(Intent intent, boolean deferUntilActive, int originalCallingUid, int originalCallingAppProcessState, String resolvedDataType) {
            StickyBroadcast b = new StickyBroadcast();
            b.intent = intent;
            b.deferUntilActive = deferUntilActive;
            b.originalCallingUid = originalCallingUid;
            b.originalCallingAppProcessState = originalCallingAppProcessState;
            b.resolvedDataType = resolvedDataType;
            return b;
        }

        public String toString() {
            return "{intent=" + this.intent + ", defer=" + this.deferUntilActive + ", originalCallingUid=" + this.originalCallingUid + ", originalCallingAppProcessState=" + this.originalCallingAppProcessState + ", type=" + this.resolvedDataType + "}";
        }
    }

    BroadcastController(Context context, ActivityManagerService service, BroadcastQueue queue) {
        this.mStickyBroadcasts = new SparseArray();
        this.mRegisteredReceivers = new HashMap();
        this.mAreStickyCachesInvalidated = false;
        this.mReceiverResolver = new AnonymousClass1(this);
        this.mContext = context;
        this.mService = service;
        this.mBroadcastQueue = queue;
    }

    void setBroadcastQueueForTest(BroadcastQueue broadcastQueue) {
        this.mBroadcastQueue = broadcastQueue;
    }

    Intent registerReceiverWithFeature(IApplicationThread caller, String callerPackage, String callerFeatureId, String receiverId, IIntentReceiver receiver, IntentFilter filter, String permission, int userId, int flags) {
        traceRegistrationBegin(receiverId, receiver, filter, userId);
        Intent r0 = registerReceiverWithFeatureTraced(caller, callerPackage, callerFeatureId, receiverId, receiver, filter, permission, userId, flags);     // Catch: Throwable -> L6
        traceRegistrationEnd();
        return r0;
    L6:
        th = move-exception;
        traceRegistrationEnd();
        throw th;
    }

    private static void traceRegistrationBegin(String receiverId, IIntentReceiver receiver, IntentFilter filter, int userId) {
        if (Trace.isTagEnabled(64) == false) goto L27;
        StringBuilder sb = new StringBuilder("registerReceiver: ");
        sb.append(Binder.getCallingUid());
        sb.append('/');
        Object r4 = "null";
        if (receiverId != null) goto L7;
        String r5 = "null";
    L8:
        sb.append(r5);
        sb.append('/');
        sb.append("p:");
        sb.append(filter.getPriority());
        sb.append('/');
        int actionsCount = filter.safeCountActions();
        if (actionsCount <= 0) goto L17;
        int i = 0;
    L11:
        if (i >= actionsCount) goto L18;
        sb.append(filter.getAction(i));
        if (i == (actionsCount - 1)) goto L15;
        sb.append(',');
    L15:
        i = i + 1;
    L18:
        sb.append('/');
        sb.append('u');
        sb.append(userId);
        sb.append('/');
        if (receiver == null) goto L22;
        r4 = receiver.asBinder();
    L22:
        sb.append(r4);
        Trace.traceBegin(64, sb.toString());
        return;
    L17:
        sb.append("null");
        goto L18
    L7:
        r5 = receiverId;
        goto L8
    }

    private static void traceRegistrationEnd() {
        if (Trace.isTagEnabled(64) == false) goto L6;
        Trace.traceEnd(64);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v24, types: [com.android.server.am.ActivityManagerService] */
    /* JADX WARN: Type inference failed for: r20v1 */
    /* JADX WARN: Type inference failed for: r20v10 */
    /* JADX WARN: Type inference failed for: r20v12 */
    /* JADX WARN: Type inference failed for: r20v16 */
    /* JADX WARN: Type inference failed for: r20v17 */
    /* JADX WARN: Type inference failed for: r20v18 */
    /* JADX WARN: Type inference failed for: r20v19 */
    /* JADX WARN: Type inference failed for: r20v2 */
    /* JADX WARN: Type inference failed for: r20v20 */
    /* JADX WARN: Type inference failed for: r20v5 */
    /* JADX WARN: Type inference failed for: r20v6 */
    /* JADX WARN: Type inference failed for: r20v7 */
    private Intent registerReceiverWithFeatureTraced(IApplicationThread r63, String r64, String r65, String r66, IIntentReceiver r67, IntentFilter r68, String r69, int r70, int r71) {
        IntentFilter r11 = r68;
        this.mService.enforceNotIsolatedCaller("registerReceiver");
        if (this.mAreStickyCachesInvalidated == true) goto L6;
        BroadcastStickyCache.invalidateAllCaches();
        this.mAreStickyCachesInvalidated = true;
    L6:
        if ((r71 & 1) == 0) goto L8;
        boolean r0 = true;
    L9:
        boolean r16 = r0;
        ActivityManagerGlobalLock r4 = this.mService.mProcLock;
        ActivityManagerService.boostPriorityForProcLockedSection();
        monitor-enter(r4);
        ProcessRecord r3 = this.mService.getRecordForAppLOSP(r63, true);     // Catch: Throwable -> L314
        if (r3 != null) goto L20;
        r3 = (ProcessRecord) this.mService.mProcessList.getSmtEx().mPrefetchProcess.get(r64, Binder.getCallingUid());     // Catch: Throwable -> L16 Exception -> L18
    L16:
        th = th;
    L338:
        monitor-exit(r4);     // Catch: Throwable -> L319
        ActivityManagerService.resetPriorityAfterProcLockedSection();
        throw th;
    L319:
        th = th;
    L20:
        if (r3 != null) goto L362;
        Slog.w(TAG_BROADCAST, "registerReceiverWithFeature: no app for " + r63);     // Catch: Throwable -> L16
        monitor-exit(r4);     // Catch: Throwable -> L16
        ActivityManagerService.resetPriorityAfterProcLockedSection();
        return null;
    L362:
    L312:
        th = th;
        goto L338
    L26:
        if (r3.getSmtEx().inFreezeStat() == false) goto L32;
        monitor-exit(r4);     // Catch: Throwable -> L16
        ActivityManagerService.resetPriorityAfterProcLockedSection();
        return null;
    L32:
        if (UserHandle.isCore(r3.info.uid) == false) goto L34;
    L38:
        int r9 = r3.info.uid;     // Catch: Throwable -> L312
        int r8 = r3.getPid();     // Catch: Throwable -> L312
        boolean r1 = isInstantApp(r3, r64, r9);     // Catch: Throwable -> L312
        monitor-exit(r4);     // Catch: Throwable -> L312
        ActivityManagerService.resetPriorityAfterProcLockedSection();
        ProcessRecord r19 = r3;
        int r20 = this.mService.mUserController.handleIncomingUser(r8, r9, r70, true, 2, "registerReceiver", r64);
        int r10 = r8;
        int r5 = r9;
        String r6 = r64;
        if (UserHandle.isCore(r5) == false) goto L72;
        int r2 = r11.getPriority();
        if (r2 < 1000) goto L45;
    L48:
        boolean r7 = true;
    L49:
        if (r7 == true) goto L72;
        int r12 = r11.countActions();
        int r13 = 0;
    L51:
        if (r13 >= r12) goto L72;
        String r14 = r11.getAction(r13);
        if (r14.startsWith("android.intent.action.USER_") == true) goto L67;
        if (r14.startsWith("android.intent.action.PACKAGE_") == true) goto L67;
        if (r14.startsWith("android.intent.action.UID_") == true) goto L67;
        if (r14.startsWith("android.intent.action.EXTERNAL_") == true) goto L67;
        if (r14.startsWith("android.bluetooth.") == true) goto L67;
        if (r14.equals("android.intent.action.ACTION_SHUTDOWN") == true) goto L67;
        r13 = r13 + 1;
    L67:
        if (ActivityManagerDebugConfig.DEBUG_BROADCAST == false) goto L69;
        Slog.wtf(TAG_BROADCAST, "System internals registering for " + r11.toLongString() + " with app priority; this will race with apps!", new Throwable());
    L69:
        if (r2 != 0) goto L72;
        r11.setPriority(1000);
        goto L72
    L45:
        if (r2 <= (-1000)) goto L48;
        r7 = false;
    L72:
        Iterator<String> r15 = r11.actionsIterator();
        if (r15 != null) goto L75;
        ArrayList r17 = new ArrayList(1);
        r17.add(null);
        Iterator<String> r21 = r17.iterator();
    L76:
        int[] r18 = {-1, UserHandle.getUserId(r5)};
        SparseArray<ArrayMap<String, ArrayList<StickyBroadcast>>> r22 = this.mStickyBroadcasts;
        monitor-enter(r22);
        ArrayList r110 = null;
        boolean r111 = true;
    L327:
    L306:
        th = th;
    L359:
        monitor-exit(r22);     // Catch: Throwable -> L310
        throw th;
    L310:
        th = th;
        goto L359
    L80:
        if (r21.hasNext() == false) goto L103;
        String r23 = r21.next();     // Catch: Throwable -> L89
        int r24 = r18.length;     // Catch: Throwable -> L89
        int r25 = 0;
    L82:
        if (r25 >= r24) goto L96;
        ArrayMap<String, ArrayList<StickyBroadcast>> r26 = this.mStickyBroadcasts.get(r18[r25]);     // Catch: Throwable -> L89
        if (r26 == null) goto L95;
        ArrayList<StickyBroadcast> r27 = r26.get(r23);     // Catch: Throwable -> L89
        if (r27 == null) goto L95;
        if (r110 != null) goto L91;
        r110 = new ArrayList();     // Catch: Throwable -> L89
    L91:
        r110.addAll(r27);     // Catch: Throwable -> L89
    L95:
        r25 = r25 + 1;
        r24 = r24;
        goto L82
    L96:
        if (r111 == false) goto L327;
        r111 = AppGlobals.getPackageManager().isProtectedBroadcast(r23) & r111;
        goto L327
    L99:
        e = move-exception;
        r111 = false;
        Slog.w(TAG_BROADCAST, "Remote exception", e);     // Catch: Throwable -> L89
    L89:
        th = th;
        goto L359
    L103:
        monitor-exit(r22);     // Catch: Throwable -> L306
        if (Process.isSdkSandboxUid(Binder.getCallingUid()) == false) goto L116;
        SdkSandboxManagerLocal r28 = (SdkSandboxManagerLocal) LocalManagerRegistry.getManager(SdkSandboxManagerLocal.class);
        if (r28 == null) goto L114;
        if (r28.canRegisterBroadcastReceiver(r11, r71, r111) == true) goto L116;
        throw new SecurityException("SDK sandbox not allowed to register receiver with the given IntentFilter: " + r11.toLongString());
    L114:
        throw new IllegalStateException("SdkSandboxManagerLocal not found when checking whether SDK sandbox uid can register to broadcast receivers.");
    L116:
        if ((r71 & 6) == 0) goto L118;
        boolean r29 = true;
    L119:
        boolean r210 = r29;
        if ((r71 & 2) != 0) goto L122;
    L126:
        boolean r211 = CompatChanges.isChangeEnabled(DYNAMIC_RECEIVER_EXPLICIT_EXPORT_REQUIRED, r5);
        if ((r71 & 1) != 0) goto L129;
    L131:
        boolean r30 = false;
    L133:
        if (r30 == false) goto L138;
        if (r211 == false) goto L138;
        throw new IllegalArgumentException("Receiver can't specify both RECEIVER_VISIBLE_TO_INSTANT_APPS and RECEIVER_NOT_EXPORTED flag");
    L138:
        if (r111 == true) goto L152;
        if (r67 != null) goto L142;
        if (r210 == true) goto L142;
        int r212 = r71 | 2;
    L156:
        if ((r212 & 2) == 0) goto L158;
        boolean r31 = true;
    L159:
        boolean r213 = r31;
        ArrayList<StickyBroadcast> r32 = null;
        if (r110 == null) goto L175;
        this.mContext.getContentResolver();
        int r33 = 0;
        int r34 = r110.size();
    L162:
        if (r33 >= r34) goto L174;
        StickyBroadcast r35 = (StickyBroadcast) r110.get(r33);
        Intent r36 = r35.intent;
        if (r1 == true) goto L166;
    L168:
        int r37 = r10;
        int r38 = r33;
        int r39 = r5;
        boolean r214 = r111;
        int r215 = r34;
        String r40 = r6;
        int[] r72 = r18;
        int r112 = r37;
        IntentFilter r41 = r68;
        if (r41.match(r36.getAction(), r35.resolvedDataType, r36.getScheme(), r36.getData(), r36.getCategories(), TAG_BROADCAST, false, null, r36.getExtras()) < 0) goto L173;
        if (r32 != null) goto L172;
        r32 = new ArrayList();
    L172:
        r32.add(r35);
    L173:
        r33 = r38 + 1;
        r11 = r41;
        r10 = r112;
        r111 = r214;
        r34 = r215;
        r5 = r39;
        r18 = r72;
        r6 = r40;
        goto L162
    L166:
        if ((r36.getFlags() & 2097152) != 0) goto L168;
        r40 = r6;
        r39 = r5;
        r38 = r33;
        r215 = r34;
        r41 = r11;
        r72 = r18;
        r214 = r111;
        r112 = r10;
        goto L173
    L174:
        String r42 = r6;
        int r310 = r5;
        IntentFilter r43 = r11;
        int[] r73 = r18;
        int r113 = r10;
        ArrayList<StickyBroadcast> r44 = r32;
    L176:
        if (r44 == null) goto L178;
        Intent r45 = r44.get(0).intent;
    L179:
        Intent r114 = r45;
        if (ActivityManagerDebugConfig.DEBUG_BROADCAST == false) goto L182;
        Slog.v(TAG_BROADCAST, "Register receiver " + r43 + ": " + r114);
    L182:
        if (r67 != null) goto L185;
        return r114;
    L185:
        if (r113 != Process.myPid()) goto L187;
    L191:
        ActivityManagerService r115 = this.mService;
        ActivityManagerService.boostPriorityForLockedSection();
        monitor-enter(r115);
        IApplicationThread r46 = r19.getThread();     // Catch: Throwable -> L295
        if (r46 == null) goto L298;
        if (r46.asBinder() != r63.asBinder()) goto L298;
        ReceiverList r47 = this.mRegisteredReceivers.get(r67.asBinder());     // Catch: Throwable -> L295
        if (r47 == null) goto L334;
        int r48 = r113;
        ProcessRecord r49 = r19;
        int r116 = r20;
        int r117 = r310;
    L291:
        th = th;
        ?? r216 = r115;
    L325:
        monitor-exit(r216);     // Catch: Throwable -> L304
        ActivityManagerService.resetPriorityAfterLockedSection();
        throw th;
    L304:
        th = th;
        goto L325
    L227:
        if (r47.uid != r117) goto L294;
        if (r47.pid == r48) goto L344;
        r216 = r115;
        String r118 = r42;
        StringBuilder r50 = new StringBuilder();     // Catch: Throwable -> L289
        r50.append("Receiver requested to register for pid ");     // Catch: Throwable -> L289
        r50.append(r48);     // Catch: Throwable -> L287
        r50.append(" was previously registered for pid ");     // Catch: Throwable -> L287
        r50.append(r47.pid);     // Catch: Throwable -> L287
        r50.append(" callerPackage is ");     // Catch: Throwable -> L287
        r50.append(r118);     // Catch: Throwable -> L287
        throw new IllegalArgumentException(r50.toString());     // Catch: Throwable -> L287
    L289:
        th = th;
        goto L325
    L344:
        int r119 = r116;
        if (r47.userId != r116) goto L279;
    L353:
        ApplicationInfo r120 = r49.info;     // Catch: Throwable -> L272
        ActivityManagerService r217 = r115;
        ReceiverList r51 = r47;
        String r52 = r42;
        ArrayList<StickyBroadcast> r53 = r44;
        BroadcastFilter r54 = new BroadcastFilter(r68, r51, r52, r65, r66, r69, r117, r119, r1, r16, r213, r120, this.mService.mPlatformCompat);     // Catch: Throwable -> L270
        int r55 = r117;
        if (r51.containsFilter(r68) == false) goto L243;
        Slog.w(TAG_BROADCAST, "Receiver with filter " + r68 + " already registered for pid " + r51.pid + ", callerPackage is " + r52);     // Catch: Throwable -> L241
    L247:
        if (r53 == null) goto L266;
        ArrayList r56 = new ArrayList();     // Catch: Throwable -> L241
        r56.add(r54);     // Catch: Throwable -> L241
        Intent r121 = null;
        int r57 = r53.size();     // Catch: Throwable -> L260
        int r58 = 0;
    L251:
        if (r58 >= r57) goto L267;
        StickyBroadcast r122 = r53.get(r58);     // Catch: Throwable -> L260
        BroadcastFilter r74 = r54;
        int r59 = r53.get(r58).originalCallingUid;     // Catch: Throwable -> L260
        if (r121 != null) goto L264;
        if (r213 == true) goto L262;
        if (r59 == r55) goto L262;
        if (ActivityManager.canAccessUnexportedComponents(r59) == false) goto L264;
    L262:
        r121 = r122.intent;     // Catch: Throwable -> L260
    L264:
        BroadcastQueue r60 = this.mBroadcastQueue;     // Catch: Throwable -> L260
        ArrayList r410 = r56;
        r60.enqueueBroadcastLocked(new BroadcastRecord(r60, r122.intent, null, null, null, -1, -1, false, null, null, null, null, -1, BroadcastOptions.makeWithDeferUntilActive(r122.deferUntilActive), r410, null, null, 0, null, null, false, true, true, -1, r59, BackgroundStartPrivileges.NONE, false, null, r122.originalCallingAppProcessState, this.mService.mPlatformCompat));     // Catch: Throwable -> L260
        r58 = r58 + 1;     // Catch: Throwable -> L260
        r54 = r74;
        r56 = r410;
    L267:
        monitor-exit(r217);     // Catch: Throwable -> L260
        ActivityManagerService.resetPriorityAfterLockedSection();
        return r121;
    L260:
        th = th;
        r216 = r217;
        goto L325
    L266:
        r121 = r114;
        goto L267
    L243:
        r51.add(r54);     // Catch: Throwable -> L241
        if (r54.debugCheck() == true) goto L246;
        Slog.w(TAG_BROADCAST, "==> For Dynamic broadcast");     // Catch: Throwable -> L241
    L246:
        this.mReceiverResolver.addFilter(this.mService.getPackageManagerInternal().snapshot(), r54);     // Catch: Throwable -> L241
    L270:
        th = th;
        r216 = r217;
    L272:
        th = th;
        r216 = r115;
    L274:
        th = th;
        int r311 = r48;
    L276:
        r216 = r115;
        goto L325
    L279:
        throw new IllegalArgumentException("Receiver requested to register for user " + (r116 == true ? 1 : 0) + " was previously registered for user " + r47.userId + " callerPackage is " + r42);     // Catch: Throwable -> L241
    L280:
        th = th;
        r311 = r48;
        goto L276
    L294:
        throw new IllegalArgumentException("Receiver requested to register for uid " + r117 + " was previously registered for uid " + r47.uid + " callerPackage is " + r42);     // Catch: Throwable -> L287
    L334:
        int r61 = r113;
        int r62 = r310;
        ReceiverList r75 = new ReceiverList(this.mService, r19, r61, r62, r20, r67);     // Catch: Throwable -> L221
        r49 = r19;
        r48 = r61;
        r119 = r20;
        r117 = r62;
    L209:
        th = th;
        r216 = r115;
        goto L325
    L205:
        if (r75.app == null) goto L346;
        int r76 = r75.app.mReceivers.numberOfReceivers();     // Catch: Throwable -> L209
        if (r76 >= 1000) goto L212;
        r75.app.mReceivers.addReceiver(r75);     // Catch: Throwable -> L209
    L216:
        this.mRegisteredReceivers.put(r67.asBinder(), r75);     // Catch: Throwable -> L209
        r47 = r75;
        goto L353
    L212:
        throw new IllegalStateException("Too many receivers, total of " + r76 + ", registered for pid: " + r75.pid + ", callerPackage: " + r42);     // Catch: Throwable -> L209
    L346:
        r67.asBinder().linkToDeath(r75, 0);     // Catch: Throwable -> L209 RemoteException -> L217
        goto L219
    L215:
        r75.linkedToDeath = true;     // Catch: Throwable -> L209
    L219:
        ActivityManagerService.resetPriorityAfterLockedSection();
        return r114;
    L221:
        th = th;
        r216 = r115;
    L223:
        th = th;
        r216 = r115;
    L241:
        th = th;
        r216 = r20;
    L298:
        monitor-exit(r115);     // Catch: Throwable -> L287
        ActivityManagerService.resetPriorityAfterLockedSection();
        return null;
    L287:
        th = th;
        r216 = r20;
    L295:
        th = th;
        r216 = r115;
        goto L325
    L187:
        if (r43.hasAction("com.android.server.net.action.SNOOZE_WARNING") == false) goto L189;
    L190:
        EventLog.writeEvent(1397638484, new Object[]{"177931370", Integer.valueOf(r310), ""});
        goto L191
    L189:
        if (r43.hasAction("com.android.server.net.action.SNOOZE_RAPID") == false) goto L191;
    L178:
        r45 = null;
        goto L179
    L175:
        r42 = r6;
        r310 = r5;
        r43 = r11;
        r73 = r18;
        r113 = r10;
        r44 = null;
        goto L176
    L158:
        r31 = false;
    L142:
        if (r211 == false) goto L147;
        if (r210 == true) goto L147;
        throw new SecurityException(r6 + ": One of RECEIVER_EXPORTED or RECEIVER_NOT_EXPORTED should be specified when a receiver isn't being registered exclusively for system broadcasts");
    L147:
        if (r211 == false) goto L149;
    L154:
        r212 = r71;
        goto L156
    L149:
        if ((r71 & 4) != 0) goto L154;
        r212 = r71 | 2;
        goto L156
    L152:
        if ((r71 & 4) != 0) goto L154;
        r212 = r71 | 2;
        goto L156
    L129:
        if ((r71 & 4) == 0) goto L131;
        r30 = true;
        goto L133
    L122:
        if ((r71 & 4) == 0) goto L126;
        throw new IllegalArgumentException("Receiver can't specify both RECEIVER_EXPORTED and RECEIVER_NOT_EXPORTEDflag");
    L118:
        r29 = false;
        goto L119
    L75:
        r21 = r15;
        goto L76
    L34:
        if (r3.getPkgList().containsKey(r64) == true) goto L38;
        throw new SecurityException("Given caller package " + r64 + " is not running in process " + r3);     // Catch: Throwable -> L16
    L314:
        th = th;
        goto L338
    L8:
        r0 = false;
        goto L9
    }

    void unregisterReceiver(IIntentReceiver receiver) {
        traceUnregistrationBegin(receiver);
        unregisterReceiverTraced(receiver);     // Catch: Throwable -> L6
        traceUnregistrationEnd();
        return;
    L6:
        th = move-exception;
        traceUnregistrationEnd();
        throw th;
    }

    private static void traceUnregistrationBegin(IIntentReceiver receiver) {
        if (Trace.isTagEnabled(64) == false) goto L10;
        Integer r2 = Integer.valueOf(Binder.getCallingUid());
        if (receiver != null) goto L7;
        Object r3 = "null";
    L8:
        Trace.traceBegin(64, TextUtils.formatSimple("unregisterReceiver: %d/%s", new Object[]{r2, r3}));
        return;
    L7:
        r3 = receiver.asBinder();
        goto L8
    }

    private static void traceUnregistrationEnd() {
        if (Trace.isTagEnabled(64) == false) goto L6;
        Trace.traceEnd(64);
        return;
    }

    private void unregisterReceiverTraced(IIntentReceiver receiver) {
        if (ActivityManagerDebugConfig.DEBUG_BROADCAST == false) goto L5;
        Slog.v(TAG_BROADCAST, "Unregister receiver: " + receiver);
    L5:
        long origId = Binder.clearCallingIdentity();
        boolean doTrim = false;
        ActivityManagerService r4 = this.mService;     // Catch: Throwable -> L40
        ActivityManagerService.boostPriorityForLockedSection();     // Catch: Throwable -> L40
        monitor-enter(r4);     // Catch: Throwable -> L40
        ReceiverList rl = this.mRegisteredReceivers.get(receiver.asBinder());     // Catch: Throwable -> L19
        if (rl == null) goto L30;
        BroadcastRecord r = rl.curBroadcast;     // Catch: Throwable -> L19
        if (r == null) goto L25;
        if (UserHandle.isApp(r.curApp.uid) == true) goto L15;
    L21:
        boolean doNext = r.queue.finishReceiverLocked(rl.app, r.resultCode, r.resultData, r.resultExtras, r.resultAbort, false);     // Catch: Throwable -> L19
        if (doNext == false) goto L25;
        doTrim = true;
        goto L25
    L15:
        if (r.curApp == null) goto L21;
        if (r.intent == null) goto L21;
        SysOptBridge.getFactory().getFreezeController().receiveBroadcastEvent(r.curApp.uid, r.curApp.mPid, true, true, r.intent);     // Catch: Throwable -> L19
    L25:
        if (rl.app == null) goto L27;
        rl.app.mReceivers.removeReceiver(rl);     // Catch: Throwable -> L19
    L27:
        removeReceiverLocked(rl);     // Catch: Throwable -> L19
        if (rl.linkedToDeath == false) goto L30;
        rl.linkedToDeath = false;     // Catch: Throwable -> L19
        rl.receiver.asBinder().unlinkToDeath(rl, 0);     // Catch: Throwable -> L19
    L30:
        if (doTrim == false) goto L36;
        this.mService.trimApplicationsLocked(false, 2);     // Catch: Throwable -> L19
        monitor-exit(r4);     // Catch: Throwable -> L19
        ActivityManagerService.resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(origId);
        return;
    L36:
        monitor-exit(r4);     // Catch: Throwable -> L19
        ActivityManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L40
        Binder.restoreCallingIdentity(origId);
        return;
    L19:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L40
        throw th;     // Catch: Throwable -> L40
    L40:
        th = move-exception;
        Binder.restoreCallingIdentity(origId);
        throw th;
    }

    void removeReceiverLocked(ReceiverList rl) {
        this.mRegisteredReceivers.remove(rl.receiver.asBinder());
        int i = rl.size() - 1;
    L3:
        if (i < 0) goto L6;
        this.mReceiverResolver.removeFilter(rl.get(i));
        i = i - 1;
        goto L3
    }

    List<IntentFilter> getRegisteredIntentFilters(IIntentReceiver receiver) {
        ActivityManagerService r0 = this.mService;
        ActivityManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        ReceiverList rl = this.mRegisteredReceivers.get(receiver.asBinder());     // Catch: Throwable -> L9
        if (rl != null) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L9
        ActivityManagerService.resetPriorityAfterLockedSection();
        return null;
    L11:
        ArrayList<IntentFilter> filters = new ArrayList();     // Catch: Throwable -> L9
        int count = rl.size();     // Catch: Throwable -> L9
        int i = 0;
    L12:
        if (i >= count) goto L15;
        filters.add(rl.get(i));     // Catch: Throwable -> L9
        i = i + 1;     // Catch: Throwable -> L9
        goto L12
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L9
        ActivityManagerService.resetPriorityAfterLockedSection();
        return filters;
    L9:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    int broadcastIntentWithFeature(IApplicationThread caller, String callingFeatureId, Intent intent, String resolvedType, IIntentReceiver resultTo, int resultCode, String resultData, Bundle resultExtras, String[] requiredPermissions, String[] excludedPermissions, String[] excludedPackages, int appOp, Bundle bOptions, boolean serialized, boolean sticky, int userId) {
        this.mService.enforceNotIsolatedCaller("broadcastIntent");
        ActivityManagerService r1 = this.mService;
        ActivityManagerService.boostPriorityForLockedSection();
        monitor-enter(r1);
        Intent intent2 = verifyBroadcastLocked(intent);     // Catch: Throwable -> L43
        ProcessRecord callerApp = this.mService.getRecordForAppLOSP(caller, true);     // Catch: Throwable -> L13
        if (callerApp != null) goto L9;
    L15:
        int callingPid = Binder.getCallingPid();     // Catch: Throwable -> L13
        int callingUid = Binder.getCallingUid();     // Catch: Throwable -> L13
        enforceBroadcastOptionPermissionsInternal(bOptions, callingUid);     // Catch: Throwable -> L13
        ComponentName cn = intent2.getComponent();     // Catch: Throwable -> L13
        StringBuilder r0 = new StringBuilder();     // Catch: Throwable -> L13
        r0.append("broadcastIntent:");     // Catch: Throwable -> L13
        if (cn == null) goto L18;
        String r9 = cn.toString();     // Catch: Throwable -> L13
    L19:
        r0.append(r9);     // Catch: Throwable -> L13
        Trace.traceBegin(64, r0.toString());     // Catch: Throwable -> L13
        long origId = Binder.clearCallingIdentity();     // Catch: Throwable -> L13
        if (callerApp != null) goto L54;
        String r2 = null;
    L52:
        long r31 = 64;
        int result = broadcastIntentLocked(callerApp, r2, callingFeatureId, intent2, resolvedType, callerApp, resultTo, resultCode, resultData, resultExtras, requiredPermissions, excludedPermissions, excludedPackages, appOp, bOptions, serialized, sticky, callingPid, callingUid, callingUid, callingPid, userId, BackgroundStartPrivileges.NONE, null, null);     // Catch: Throwable -> L37
        Binder.restoreCallingIdentity(origId);     // Catch: Throwable -> L13
        Trace.traceEnd(64);     // Catch: Throwable -> L13
        monitor-exit(r1);     // Catch: Throwable -> L13
        ActivityManagerService.resetPriorityAfterLockedSection();
        if (sticky == false) goto L36;
        if (result != 0) goto L36;
        BroadcastStickyCache.invalidateCache(intent2.getAction());
    L36:
        return result;
    L37:
        th = th;
    L41:
        Binder.restoreCallingIdentity(origId);     // Catch: Throwable -> L13
        Trace.traceEnd(r31);     // Catch: Throwable -> L13
        throw th;     // Catch: Throwable -> L13
    L39:
        th = th;
        r31 = 64;
        goto L41
    L54:
        r2 = callerApp.info.packageName;     // Catch: Throwable -> L24
    L24:
        th = th;
        r31 = 64;
        goto L41
    L18:
        r9 = intent2.getAction();     // Catch: Throwable -> L13
        goto L19
    L9:
        if (callerApp.getSmtEx().inFreezeStat() == false) goto L15;
        monitor-exit(r1);     // Catch: Throwable -> L13
        ActivityManagerService.resetPriorityAfterLockedSection();
        return 0;
    L13:
        th = th;
    L45:
        monitor-exit(r1);     // Catch: Throwable -> L13
        ActivityManagerService.resetPriorityAfterLockedSection();
        throw th;
    L43:
        th = th;
        goto L45
    }

    int broadcastIntentInPackage(String packageName, String featureId, int uid, int realCallingUid, int realCallingPid, Intent intent, String resolvedType, ProcessRecord resultToApp, IIntentReceiver resultTo, int resultCode, String resultData, Bundle resultExtras, String requiredPermission, Bundle bOptions, boolean serialized, boolean sticky, int userId, BackgroundStartPrivileges backgroundStartPrivileges, int[] broadcastAllowList) {
        ActivityManagerService r1 = this.mService;
        ActivityManagerService.boostPriorityForLockedSection();
        monitor-enter(r1);
        Intent intent2 = verifyBroadcastLocked(intent);     // Catch: Throwable -> L25
        long origId = Binder.clearCallingIdentity();     // Catch: Throwable -> L20
        if (requiredPermission != null) goto L10;
        String[] requiredPermissions = null;
    L31:
        int result = broadcastIntentLocked(null, packageName, featureId, intent2, resolvedType, resultToApp, resultTo, resultCode, resultData, resultExtras, requiredPermissions, null, null, -1, bOptions, serialized, sticky, -1, uid, realCallingUid, realCallingPid, userId, backgroundStartPrivileges, broadcastAllowList, null);     // Catch: Throwable -> L22
        Binder.restoreCallingIdentity(origId);     // Catch: Throwable -> L20
        monitor-exit(r1);     // Catch: Throwable -> L20
        ActivityManagerService.resetPriorityAfterLockedSection();
        if (sticky == false) goto L19;
        if (result != 0) goto L19;
        BroadcastStickyCache.invalidateCache(intent2.getAction());
    L19:
        return result;
    L22:
        th = move-exception;
        Binder.restoreCallingIdentity(origId);     // Catch: Throwable -> L20
        throw th;     // Catch: Throwable -> L20
    L10:
        requiredPermissions = new String[]{requiredPermission};     // Catch: Throwable -> L20
    L20:
        th = th;
    L27:
        monitor-exit(r1);     // Catch: Throwable -> L20
        ActivityManagerService.resetPriorityAfterLockedSection();
        throw th;
    L25:
        th = th;
        goto L27
    }

    final int broadcastIntentLocked(ProcessRecord callerApp, String callerPackage, String callerFeatureId, Intent intent, String resolvedType, ProcessRecord resultToApp, IIntentReceiver resultTo, int resultCode, String resultData, Bundle resultExtras, String[] requiredPermissions, String[] excludedPermissions, String[] excludedPackages, int appOp, Bundle bOptions, boolean ordered, boolean sticky, int callingPid, int callingUid, int realCallingUid, int realCallingPid, int userId, BackgroundStartPrivileges backgroundStartPrivileges, int[] broadcastAllowList, BiFunction<Integer, Bundle, Bundle> filterExtrasForReceiver) {
        int cookie = traceBroadcastIntentBegin(intent, resultTo, ordered, sticky, callingUid, realCallingUid, userId);
        BroadcastSentEventRecord broadcastSentEventRecord = new BroadcastSentEventRecord();     // Catch: Throwable -> L6
        int res = broadcastIntentLockedTraced(callerApp, callerPackage, callerFeatureId, intent, resolvedType, resultToApp, resultTo, resultCode, resultData, resultExtras, requiredPermissions, excludedPermissions, excludedPackages, appOp, BroadcastOptions.fromBundleNullable(bOptions), ordered, sticky, callingPid, callingUid, realCallingUid, realCallingPid, userId, backgroundStartPrivileges, broadcastAllowList, filterExtrasForReceiver, broadcastSentEventRecord);     // Catch: Throwable -> L6
        broadcastSentEventRecord.setResult(res);     // Catch: Throwable -> L6
        broadcastSentEventRecord.logToStatsd();     // Catch: Throwable -> L6
        traceBroadcastIntentEnd(cookie);
        return res;
    L6:
        th = move-exception;
        traceBroadcastIntentEnd(cookie);
        throw th;
    }

    private static int traceBroadcastIntentBegin(Intent intent, IIntentReceiver resultTo, boolean ordered, boolean sticky, int callingUid, int realCallingUid, int userId) {
        if (Trace.isTagEnabled(64) == false) goto L24;
        StringBuilder sb = new StringBuilder("broadcastIntent: ");
        sb.append(callingUid);
        sb.append('/');
        String action = intent.getAction();
        if (action != null) goto L7;
        String r3 = null;
    L8:
        sb.append(r3);
        sb.append('/');
        sb.append("0x");
        sb.append(Integer.toHexString(intent.getFlags()));
        sb.append('/');
        String r4 = "_";
        if (ordered == false) goto L11;
        String r5 = "O";
    L12:
        sb.append(r5);
        if (sticky == false) goto L15;
        String r6 = "S";
    L16:
        sb.append(r6);
        if (resultTo == null) goto L19;
        r4 = "C";
    L19:
        sb.append(r4);
        sb.append('/');
        sb.append('u');
        sb.append(userId);
        if (callingUid == realCallingUid) goto L23;
        sb.append('/');
        sb.append("sender=");
        sb.append(realCallingUid);
    L23:
        return BroadcastQueue.traceBegin(sb.toString());
    L15:
        r6 = "_";
        goto L16
    L11:
        r5 = "_";
        goto L12
    L7:
        r3 = action;
        goto L8
    L24:
        return 0;
    }

    private static void traceBroadcastIntentEnd(int cookie) {
        if (Trace.isTagEnabled(64) == false) goto L6;
        BroadcastQueue.traceEnd(cookie);
        return;
    }

    final int broadcastIntentLockedTraced(ProcessRecord callerApp, String callerPackage, String callerFeatureId, Intent intent, String resolvedType, ProcessRecord resultToApp, IIntentReceiver resultTo, int resultCode, String resultData, Bundle resultExtras, String[] requiredPermissions, String[] excludedPermissions, String[] excludedPackages, int appOp, BroadcastOptions brOptions, boolean ordered, boolean sticky, int callingPid, int callingUid, int realCallingUid, int realCallingPid, int userId, BackgroundStartPrivileges backgroundStartPrivileges, int[] broadcastAllowList, BiFunction<Integer, Bundle, Bundle> filterExtrasForReceiver, BroadcastSentEventRecord broadcastSentEventRecord) {
        BroadcastController r1 = this;
        BroadcastLoopers.addMyLooper();
        if (Process.isSdkSandboxUid(realCallingUid) == false) goto L14;
        SdkSandboxManagerLocal sdkSandboxManagerLocal = (SdkSandboxManagerLocal) LocalManagerRegistry.getManager(SdkSandboxManagerLocal.class);
        if (sdkSandboxManagerLocal == null) goto L12;
        if (sdkSandboxManagerLocal.canSendBroadcast(intent) == true) goto L14;
        throw new SecurityException("Intent " + intent.getAction() + " may not be broadcast from an SDK sandbox uid. Given caller package " + callerPackage + " (pid=" + callingPid + ", realCallingUid=" + realCallingUid + ", callingUid= " + callingUid + ")");
    L12:
        throw new IllegalStateException("SdkSandboxManagerLocal not found when sending a broadcast from an SDK sandbox uid.");
    L14:
        if (resultTo == null) goto L20;
        if (resultToApp != null) goto L20;
        if ((resultTo.asBinder() instanceof BinderProxy) == false) goto L19;
        Slog.wtf(TAG_BROADCAST, "Sending broadcast " + intent.getAction() + " with resultTo requires resultToApp", new Throwable());
        goto L20
    L19:
        ProcessRecord resultToApp2 = r1.mService.getProcessRecordLocked("system", 1000);
    L21:
        Intent intent2 = new Intent(intent);
        broadcastSentEventRecord.setIntent(intent2);
        broadcastSentEventRecord.setOriginalIntentFlags(intent2.getFlags());
        broadcastSentEventRecord.setSenderUid(callingUid);
        broadcastSentEventRecord.setRealSenderUid(realCallingUid);
        broadcastSentEventRecord.setSticky(sticky);
        broadcastSentEventRecord.setOrdered(ordered);
        if (resultTo == null) goto L24;
        boolean r0 = true;
    L25:
        broadcastSentEventRecord.setResultRequested(r0);
        int callerAppProcessState = r1.getRealProcessStateLocked(callerApp, realCallingPid);
        broadcastSentEventRecord.setSenderProcState(callerAppProcessState);
        broadcastSentEventRecord.setSenderUidState(r1.getRealUidStateLocked(callerApp, realCallingPid));
        boolean callerInstantApp = r1.isInstantApp(callerApp, callerPackage, callingUid);
        if (callerInstantApp == false) goto L29;
        intent2.setFlags(intent2.getFlags() & (-2097153));
    L29:
        if (userId != (-1)) goto L32;
        if (broadcastAllowList == null) goto L32;
        Slog.e(TAG_BROADCAST, "broadcastAllowList only applies when sending to individual users. Assuming restrictive whitelist.");
        int[] broadcastAllowList2 = new int[0];
    L33:
        intent2.addFlags(16);
        if (r1.mService.mProcessesReady == true) goto L39;
        if ((intent2.getFlags() & 33554432) != 0) goto L39;
        intent2.addFlags(1073741824);
    L39:
        if (ActivityManagerDebugConfig.DEBUG_BROADCAST_LIGHT == false) goto L50;
        StringBuilder r2 = new StringBuilder();
        if (sticky == false) goto L44;
        String r17 = "Broadcast sticky: ";
    L45:
        r2.append(r17);
        r2.append(intent2);
        r2.append(" ordered=");
        r2.append(ordered);
        r2.append(" userid=");
        r2.append(userId);
        r2.append(" options=");
        if (brOptions != null) goto L48;
        Object r14 = "null";
    L49:
        r2.append(r14);
        Slog.v(TAG_BROADCAST, r2.toString());
        goto L50
    L48:
        r14 = brOptions.toBundle();
        goto L49
    L44:
        r17 = "Broadcast: ";
    L50:
        if (resultTo == null) goto L57;
        if (ordered == true) goto L57;
        if (UserHandle.isCore(callingUid) == true) goto L57;
        String msg = "Unauthorized unordered resultTo broadcast " + intent2 + " sent from uid " + callingUid;
        Slog.w(TAG_BROADCAST, msg);
        throw new SecurityException(msg);
    L57:
        int userId2 = r1.mService.mUserController.handleIncomingUser(callingPid, callingUid, userId, true, 0, "broadcast", callerPackage);
        if (userId2 == (-1)) goto L72;
        if (r1.mService.mUserController.isUserOrItsParentRunning(userId2) == true) goto L72;
        if (callingUid != 1000) goto L67;
        if ((intent2.getFlags() & 33554432) != 0) goto L72;
    L67:
        if ("android.intent.action.ACTION_SHUTDOWN".equals(intent2.getAction()) == true) goto L72;
        Slog.w(TAG_BROADCAST, "Skipping broadcast of " + intent2 + ": user " + userId2 + " and its parent (if any) are stopped");
        r1.scheduleCanceledResultTo(resultToApp2, resultTo, intent2, userId2, brOptions, callingUid, callerPackage);
        return -2;
    L72:
        String action = r4.getAction();
        if (brOptions != 0) goto L75;
        int r66 = -96;
        int r3 = 0;
        BackgroundStartPrivileges backgroundStartPrivileges2 = backgroundStartPrivileges;
    L655:
        boolean isProtectedBroadcast = AppGlobals.getPackageManager().isProtectedBroadcast(action);     // Catch: RemoteException -> L651
        switch(UserHandle.getAppId(r12)) {
            case 0: goto L128;
            case 1000: goto L128;
            case 1001: goto L128;
            case 1002: goto L128;
            case 1027: goto L128;
            case 1068: goto L128;
            case 1073: goto L128;
            default: goto L122;
        };
    L122:
        if (callerApp != null) goto L124;
    L126:
        int r4 = r3;
    L127:
        int r40 = r4;
    L129:
        if (r40 != 0) goto L150;
        if (isProtectedBroadcast == false) goto L132;
        String msg2 = "Permission Denial: not allowed to send broadcast " + action + " from pid=" + callingPid + ", uid=" + r12;
        Slog.w(TAG_BROADCAST, msg2);
        throw new SecurityException(msg2);
    L132:
        if ("android.appwidget.action.APPWIDGET_CONFIGURE".equals(action) == false) goto L134;
    L137:
        if (callerPackage != 0) goto L139;
        String msg3 = "Permission Denial: not allowed to send broadcast " + action + " from unknown caller.";
        Slog.w(TAG_BROADCAST, msg3);
        throw new SecurityException(msg3);
    L139:
        if (r4.getComponent() != null) goto L141;
        Intent intent3 = r4;
        intent3.setPackage(callerPackage);
    L151:
        boolean timeoutExempt = false;
        if (action != null) goto L154;
        String r8 = callerPackage;
        Intent intent4 = intent3;
        int callerAppProcessState2 = r28;
        int r7 = r12;
        String action2 = action;
        int userId3 = userId2;
        int r6 = -1;
    L419:
        if (sticky == true) goto L421;
        int r15 = r7;
        BroadcastController r9 = r1;
        int userId4 = userId3;
        int userId5 = r15;
        BroadcastOptions r16 = brOptions;
        action2 = action2;
        int callerAppProcessState3 = callerAppProcessState2;
    L481:
        if (userId4 != (-1)) goto L483;
        int[] users = r9.mService.mUserController.getStartedUserArray();
    L484:
        Intent intent5 = intent4;
        int userId6 = userId4;
        int r10 = 1073741824;
        SaferIntentUtils.IntentArgs args = new SaferIntentUtils.IntentArgs(intent5, resolvedType, true, true, userId5, callingPid);
        Intent intent6 = intent5;
        args.platformCompat = r9.mService.mPlatformCompat;
        int cookie = BroadcastQueue.traceBegin("queryReceivers");
        List<ResolveInfo> r5 = null;
        List<BroadcastFilter> registeredReceivers = null;
        if ((intent6.getFlags() & 1073741824) != 0) goto L487;
        BroadcastController r11 = r9;
        int[] users2 = users;
        int[] broadcastAllowList3 = broadcastAllowList2;
        r5 = r11.collectReceiverComponents(intent6, resolvedType, callingUid, callingPid, users2, broadcastAllowList3);
        int[] users3 = broadcastAllowList3;
        r9 = r11;
        int[] users4 = users2;
        int r12 = callingUid;
        intent6 = intent6;
    L489:
        if (intent6.getComponent() != null) goto L511;
        PackageDataSnapshot snapshot = r9.mService.getPackageManagerInternal().snapshot();
        if (userId6 == (-1)) goto L493;
    L507:
        int r68 = 1073741824;
        List receivers = r5;
        Intent intent7 = intent6;
        intent6 = intent7;
        int userId7 = userId6;
        List<BroadcastFilter> registeredReceivers2 = r9.mReceiverResolver.queryIntent(snapshot, intent7, resolvedType, false, userId6);
    L508:
        if (registeredReceivers2 == null) goto L510;
        SaferIntentUtils.blockNullAction(args, registeredReceivers2);
    L510:
        List<BroadcastFilter> registeredReceivers3 = registeredReceivers2;
    L512:
        BroadcastQueue.traceEnd(cookie);
        if ((intent6.getFlags() & 536870912) == 0) goto L515;
        boolean r13 = true;
    L516:
        boolean replacePending = r13;
        if (ActivityManagerDebugConfig.DEBUG_BROADCAST == false) goto L519;
        Slog.v(TAG_BROADCAST, "Enqueueing broadcast: " + intent6.getAction() + " replacePending=" + replacePending);
    L519:
        if (registeredReceivers3 == null) goto L529;
        if (users3 == null) goto L529;
        int i = registeredReceivers3.size() - 1;
    L522:
        if (i < 0) goto L529;
        int owningAppId = UserHandle.getAppId(registeredReceivers3.get(i).owningUid);
        if (owningAppId < 10000) goto L528;
        if (Arrays.binarySearch(users3, owningAppId) >= 0) goto L528;
        registeredReceivers3.remove(i);
    L528:
        i = i - 1;
    L529:
        if (registeredReceivers3 == null) goto L531;
        int NR = registeredReceivers3.size();
    L532:
        int iRG = NR - 1;
    L533:
        if (iRG < 0) goto L570;
        BroadcastFilter checkFreeze = registeredReceivers3.get(iRG);
        if (checkFreeze.receiverList == null) goto L537;
        ProcessRecord cFApp = checkFreeze.receiverList.app;
    L538:
        if (cFApp != null) goto L545;
        if (ActivityManagerDebugConfig.DEBUG_BROADCAST == false) goto L543;
        Slog.v(TAG_BROADCAST, "freeze remove null or freeze registered receiver in app: " + cFApp);
    L543:
        registeredReceivers3.remove(iRG);
        NR = NR - 1;
        int[] broadcastAllowList4 = users3;
    L569:
        iRG = iRG - 1;
        users3 = broadcastAllowList4;
        goto L533
    L545:
        if (cFApp.getSmtEx().inFreezeStat() == true) goto L547;
        broadcastAllowList4 = users3;
        goto L569
    L547:
        if (intent6.getSmtEx().getSmtBooleanExtra("from_system_ui", false) == false) goto L549;
        Slog.i("AMS.Freeze", "unfreezeApp for NEED_BROADCAST B, app:" + cFApp + " intent:" + intent6);
        broadcastAllowList4 = users3;
        SysOptBridge.getFactory().getApplicationFreezer().unfreezeProcessLocked(cFApp, true, IApplicationFreezer.UnfreezeReason.NEED_BROADCAST, null);
        goto L569
    L549:
        broadcastAllowList4 = users3;
        if ("android.intent.action.BATTERY_CHANGED".equals(intent6.getAction()) == false) goto L552;
    L567:
        registeredReceivers3.remove(iRG);
        NR = NR - 1;
        goto L569
    L552:
        if ("android.intent.action.TIME_TICK".equals(intent6.getAction()) == true) goto L567;
        if ("android.net.wifi.SCAN_RESULTS".equals(intent6.getAction()) == true) goto L567;
        if ("android.intent.action.CONFIGURATION_CHANGED".equals(intent6.getAction()) == true) goto L567;
        if ("com.tencent.qqlive.intent.action.SPLASH_PRELOAD_CACHE".equals(intent6.getAction()) == true) goto L567;
        if (intent6.getAction() == null) goto L564;
        if (intent6.getAction().contains("com.sina.smart.heartbeat.action") == true) goto L567;
    L564:
        if (intent6.getAction() == null) goto L569;
        if (intent6.getAction().contains("com.sina.pushtask.isruning.action") == false) goto L569;
    L537:
        cFApp = null;
        goto L538
    L570:
        int ir = 0;
        if (receivers == null) goto L618;
        String[] skipPackages = null;
        if ("android.intent.action.PACKAGE_ADDED".equals(intent6.getAction()) == false) goto L575;
    L583:
        Uri data = intent6.getData();
        if (data == null) goto L588;
        String pkgName = data.getSchemeSpecificPart();
        if (pkgName == null) goto L588;
        skipPackages = new String[]{pkgName};
    L588:
        if (skipPackages != null) goto L590;
    L605:
        int ir2 = 0;
    L606:
        int NT = receivers.size();
        BroadcastFilter curr = null;
        ResolveInfo curt = null;
        int it = 0;
        int it2 = ir2;
    L607:
        if (it >= NT) goto L617;
        if (it2 >= NR) goto L617;
        if (curt != null) goto L611;
        curt = (ResolveInfo) receivers.get(it);
    L611:
        if (curr != null) goto L613;
        BroadcastFilter curr2 = registeredReceivers3.get(it2);
        curr = curr2;
    L613:
        int r18 = curr.getPriority();
        int NT2 = NT;
        int NT3 = curt.priority;
        if (r18 >= NT3) goto L615;
        it = it + 1;
        curt = null;
        NT = NT2;
        goto L607
    L615:
        receivers.add(it, curr);
        it2 = it2 + 1;
        curr = null;
        it = it + 1;
        NT = NT2 + 1;
    L617:
        int ir3 = it2;
    L619:
        if (ir3 >= NR) goto L625;
        if (callerInstantApp == false) goto L622;
        intent6.setFlags(intent6.getFlags() & (-2097153));
    L622:
        if (receivers != null) goto L624;
        receivers = new ArrayList();
    L624:
        receivers.add(registeredReceivers3.get(ir3));
        ir3 = ir3 + 1;
        goto L619
    L625:
        if (r40 == 0) goto L627;
        Intent intent8 = intent6;
        int r27 = 0;
        BroadcastController r19 = this;
        r19.checkBroadcastFromSystem(intent8, callerApp, callerPackage, callingUid, isProtectedBroadcast, receivers);
        intent6 = intent8;
    L628:
        if (receivers != null) goto L630;
    L631:
        if (resultTo == null) goto L638;
    L632:
        BroadcastQueue queue = r19.mBroadcastQueue;
        SaferIntentUtils.filterNonExportedComponents(args, receivers);
        BroadcastOptions r110 = r16;
        int r34 = r27;
        List receivers2 = receivers;
        BroadcastRecord r = new BroadcastRecord(queue, intent6, callerApp, callerPackage, callerFeatureId, callingPid, callingUid, callerInstantApp, resolvedType, requiredPermissions, excludedPermissions, excludedPackages, appOp, r110, receivers2, resultToApp2, resultTo, resultCode, resultData, resultExtras, r2, sticky, false, userId7, backgroundStartPrivileges2, timeoutExempt, filterExtrasForReceiver, callerAppProcessState3, r19.mService.mPlatformCompat);
        broadcastSentEventRecord.setBroadcastRecord(r);
        if (ActivityManagerDebugConfig.DEBUG_BROADCAST == false) goto L635;
    L636:
        Slog.v(TAG_BROADCAST, "Enqueueing broadcast " + r);
    L637:
        queue.enqueueBroadcastLocked(r);
    L650:
        return r34;
    L635:
        if (r.debugLog() == false) goto L637;
    L638:
        Intent intent9 = intent6;
        r34 = r27;
        if (intent9.getComponent() != null) goto L646;
        if (intent9.getPackage() != null) goto L646;
        if ((intent9.getFlags() & r68) != 0) goto L646;
        addBroadcastStatLocked(intent9.getAction(), callerPackage, 0, 0, 0);
    L646:
        if (ActivityManagerDebugConfig.DEBUG_BROADCAST == false) goto L648;
    L649:
        Slog.v(TAG_BROADCAST, "Skipping broadcast " + BroadcastRecord.intentToString(intent9) + " due to no receivers");
        goto L650
    L648:
        if (BroadcastRecord.debugLog(brOptions) == false) goto L650;
    L630:
        if (receivers.size() > 0) goto L632;
    L627:
        r27 = 0;
        r19 = this;
        goto L628
    L590:
        if (skipPackages.length <= 0) goto L605;
        int r20 = skipPackages.length;
        int r21 = 0;
    L592:
        if (r21 >= r20) goto L604;
        String skipPackage = skipPackages[r21];
        if (skipPackage == null) goto L603;
        int NT4 = receivers.size();
        int it3 = 0;
    L596:
        if (it3 >= NT4) goto L603;
        String[] skipPackages2 = skipPackages;
        ResolveInfo curt2 = (ResolveInfo) receivers.get(it3);
        int r111 = r20;
        if (curt2.activityInfo.packageName.equals(skipPackage) == false) goto L600;
        receivers.remove(it3);
        it3 = it3 - 1;
        NT4 = NT4 - 1;
    L600:
        it3 = it3 + 1;
        skipPackages = skipPackages2;
        r20 = r111;
    L603:
        r21 = r21 + 1;
        ir = ir;
        skipPackages = skipPackages;
        r20 = r20;
        goto L592
    L604:
        ir2 = ir;
        goto L606
    L575:
        if ("android.intent.action.PACKAGE_RESTARTED".equals(intent6.getAction()) == true) goto L583;
        if ("android.intent.action.PACKAGE_DATA_CLEARED".equals(intent6.getAction()) == true) goto L583;
        if ("android.intent.action.EXTERNAL_APPLICATIONS_AVAILABLE".equals(intent6.getAction()) == false) goto L588;
        skipPackages = intent6.getStringArrayExtra("android.intent.extra.changed_package_list");
        goto L588
    L618:
        ir3 = 0;
        goto L619
    L531:
        NR = 0;
        goto L532
    L515:
        r13 = false;
        goto L516
    L493:
        if (r12 != 2000) goto L507;
        int i2 = 0;
    L496:
        if (i2 >= users4.length) goto L506;
        int r69 = r10;
        List<ResolveInfo> r48 = r5;
        if (r9.mService.mUserController.hasUserRestriction("no_debugging_features", users4[i2]) == false) goto L500;
        List<ResolveInfo> r112 = r48;
        int[] users5 = users4;
        PackageDataSnapshot snapshot2 = snapshot;
        List<BroadcastFilter> registeredReceivers4 = registeredReceivers;
        int i3 = i2;
    L505:
        i2 = i3 + 1;
        snapshot = snapshot2;
        registeredReceivers = registeredReceivers4;
        r5 = r112;
        users4 = users5;
        r10 = r69;
        goto L496
    L500:
        IntentResolver<BroadcastFilter, BroadcastFilter> r22 = r9.mReceiverResolver;
        int r23 = users4[i2];
        int[] users6 = users4;
        snapshot2 = snapshot;
        Intent intent10 = intent6;
        users5 = users6;
        registeredReceivers4 = registeredReceivers;
        r112 = r48;
        i3 = i2;
        List<BroadcastFilter> registeredReceiversForUser = r22.queryIntent(snapshot2, intent10, resolvedType, false, r23);
        intent6 = intent10;
        if (registeredReceivers4 != null) goto L503;
        registeredReceivers4 = registeredReceiversForUser;
        goto L505
    L503:
        if (registeredReceiversForUser == null) goto L505;
        registeredReceivers4.addAll(registeredReceiversForUser);
        goto L505
    L506:
        r68 = r10;
        registeredReceivers2 = registeredReceivers;
        receivers = r5;
        userId7 = userId6;
        goto L508
    L511:
        r68 = 1073741824;
        userId7 = userId6;
        receivers = r5;
        registeredReceivers3 = null;
        goto L512
    L487:
        r12 = callingUid;
        users4 = users;
        users3 = broadcastAllowList2;
        goto L489
    L483:
        int[] users7 = {userId4};
        users = users7;
        goto L484
    L421:
        if (r1.mService.checkPermission("android.permission.BROADCAST_STICKY", callingPid, r7) != 0) goto L477;
        if (requiredPermissions != 0) goto L424;
    L427:
        int r24 = r7;
        r9 = r1;
        userId4 = userId3;
        userId5 = r24;
        r16 = brOptions;
        int r113 = r6;
        if (intent4.getComponent() != null) goto L476;
        SparseArray<ArrayMap<String, ArrayList<StickyBroadcast>>> r25 = r9.mStickyBroadcasts;
        monitor-enter(r25);
        if (userId4 == r113) goto L667;
        ArrayMap<String, ArrayList<StickyBroadcast>> stickies = r9.mStickyBroadcasts.get(r113);     // Catch: Throwable -> L443
        if (stickies == null) goto L667;
        ArrayList<StickyBroadcast> list = stickies.get(intent4.getAction());     // Catch: Throwable -> L443
        if (list == null) goto L667;
        int N = list.size();     // Catch: Throwable -> L443
        int i4 = 0;
    L437:
        if (i4 >= N) goto L667;
        ArrayMap<String, ArrayList<StickyBroadcast>> stickies2 = stickies;
        if (intent4.filterEquals(list.get(i4).intent) == true) goto L442;
        i4 = i4 + 1;     // Catch: Throwable -> L443
        stickies = stickies2;
        goto L437
    L442:
        throw new IllegalArgumentException("Sticky broadcast " + intent4 + " for user " + userId4 + " conflicts with existing global broadcast");     // Catch: Throwable -> L443
    L443:
        th = th;
    L473:
        monitor-exit(r25);     // Catch: Throwable -> L462
        throw th;
    L667:
        ArrayMap<String, ArrayList<StickyBroadcast>> stickies3 = r9.mStickyBroadcasts.get(userId4);     // Catch: Throwable -> L464
        if (stickies3 != null) goto L451;
        stickies3 = new ArrayMap();     // Catch: Throwable -> L443
        r9.mStickyBroadcasts.put(userId4, stickies3);     // Catch: Throwable -> L443
    L451:
        ArrayList<StickyBroadcast> list2 = stickies3.get(intent4.getAction());     // Catch: Throwable -> L464
        if (list2 != null) goto L455;
        list2 = new ArrayList();     // Catch: Throwable -> L443
        stickies3.put(intent4.getAction(), list2);     // Catch: Throwable -> L443
    L455:
        boolean deferUntilActive = BroadcastRecord.calculateDeferUntilActive(userId5, r16, resultTo, ordered, BroadcastRecord.calculateUrgent(intent4, r16));     // Catch: Throwable -> L464
        int stickiesCount = list2.size();     // Catch: Throwable -> L464
        int i5 = 0;
    L456:
        if (i5 >= stickiesCount) goto L467;
        if (intent4.filterEquals(list2.get(i5).intent) == true) goto L459;
        i5 = i5 + 1;     // Catch: Throwable -> L462
        action2 = action2;
        goto L456
    L459:
        callerAppProcessState3 = callerAppProcessState2;
        list2.set(i5, StickyBroadcast.create(new Intent(intent4), deferUntilActive, userId5, callerAppProcessState3, resolvedType));     // Catch: Throwable -> L462
    L468:
        if (i5 < stickiesCount) goto L470;
        list2.add(StickyBroadcast.create(new Intent(intent4), deferUntilActive, userId5, callerAppProcessState3, resolvedType));     // Catch: Throwable -> L462
    L470:
        BroadcastStickyCache.invalidateCache(intent4.getAction());     // Catch: Throwable -> L462
        monitor-exit(r25);     // Catch: Throwable -> L462
        goto L481
    L467:
        callerAppProcessState3 = callerAppProcessState2;
    L464:
        th = th;
    L462:
        th = th;
        goto L473
    L476:
        throw new SecurityException("Sticky broadcasts can't target a specific component");
    L424:
        if (requiredPermissions.length <= 0) goto L427;
        Slog.w(TAG_BROADCAST, "Can't broadcast sticky intent " + intent4 + " and enforce permissions " + Arrays.toString(requiredPermissions));
        int r114 = r6;
        r1.scheduleCanceledResultTo(resultToApp2, resultTo, intent4, userId3, brOptions, r7, r8);
        return r114;
    L477:
        String msg4 = "Permission Denial: broadcastIntent() requesting a sticky broadcast from pid=" + callingPid + ", uid=" + r7 + " requires android.permission.BROADCAST_STICKY";
        Slog.w(TAG_BROADCAST, msg4);
        throw new SecurityException(msg4);
    L154:
        if (r1.getBackgroundLaunchBroadcasts().contains(action) == false) goto L160;
        if (ActivityManagerDebugConfig.DEBUG_BACKGROUND_CHECK == false) goto L158;
        Slog.i(TAG_BROADCAST, "Broadcast action " + action + " forcing include-background");
    L158:
        intent3.addFlags(16777216);
    L160:
        if (r1.mContext.getPackageManager().hasSystemFeature("android.hardware.type.watch") == true) goto L162;
    L169:
        int callerProcState = action.hashCode();
        int r41 = 2;
        switch(callerProcState) {
            case -2098526293: goto L233;
            case -1749672628: goto L230;
            case -1403934493: goto L227;
            case -1338021860: goto L224;
            case -1001645458: goto L221;
            case -810471698: goto L218;
            case -403228793: goto L215;
            case 172491798: goto L212;
            case 183904262: goto L209;
            case 267468725: goto L206;
            case 502473491: goto L203;
            case 505380757: goto L200;
            case 525384130: goto L197;
            case 555021408: goto L194;
            case 789737439: goto L191;
            case 852070077: goto L188;
            case 920338478: goto L185;
            case 1290767157: goto L182;
            case 1544582882: goto L179;
            case 1664215986: goto L176;
            case 1862858502: goto L173;
            default: goto L235;
        };
    L235:
        byte r26 = -1;
    L236:
        callerAppProcessState2 = callerAppProcessState;
        switch(r26) {
            case 0: goto L400;
            case 1: goto L298;
            case 2: goto L298;
            case 3: goto L298;
            case 4: goto L298;
            case 5: goto L298;
            case 6: goto L298;
            case 7: goto L298;
            case 8: goto L283;
            case 9: goto L264;
            case 10: goto L257;
            case 11: goto L256;
            case 12: goto L251;
            case 13: goto L250;
            case 14: goto L249;
            case 15: goto L248;
            case 16: goto L248;
            case 17: goto L247;
            case 18: goto L245;
            case 19: goto L244;
            case 20: goto L240;
            default: goto L238;
        };
    L238:
        r8 = callerPackage;
        action2 = action;
        intent4 = intent3;
        r7 = r12;
        userId3 = userId2;
    L406:
        if ("android.intent.action.PACKAGE_ADDED".equals(action2) == false) goto L408;
    L413:
        int uid = r1.getUidFromIntent(intent4);
        r6 = -1;
        if (uid == (-1)) goto L419;
        UidRecord uidRec = r1.mService.mProcessList.getUidRecordLOSP(uid);
        if (uidRec == null) goto L419;
        uidRec.updateHasInternetPermission();
        goto L419
    L408:
        if ("android.intent.action.PACKAGE_REMOVED".equals(action2) == true) goto L413;
        if ("android.intent.action.PACKAGE_REPLACED".equals(action2) == true) goto L413;
        r6 = -1;
        goto L419
    L244:
        action2 = action;
        intent4 = intent3;
        userId3 = userId2;
        timeoutExempt = true;
        r1 = this;
        r8 = callerPackage;
        r7 = callingUid;
        goto L406
    L245:
        Log.w(TAG_BROADCAST, "Broadcast " + action + " no longer supported. It will not be delivered.");
        scheduleCanceledResultTo(resultToApp2, resultTo, intent3, userId2, brOptions, callingUid, callerPackage);
        return 0;
    L247:
        action2 = action;
        intent4 = intent3;
        userId3 = userId2;
        r1.mService.mHandler.sendEmptyMessage(63);
        r8 = callerPackage;
        r7 = callingUid;
        goto L406
    L248:
        action2 = action;
        intent4 = intent3;
        userId3 = userId2;
        intent4.addFlags(1073741824);
        r8 = callerPackage;
        r7 = callingUid;
        goto L406
    L249:
        action2 = action;
        intent4 = intent3;
        userId3 = userId2;
        r1.mService.mHandler.sendMessage(r1.mService.mHandler.obtainMessage(29));
        r8 = callerPackage;
        r7 = callingUid;
        goto L406
    L250:
        action2 = action;
        intent4 = intent3;
        userId3 = userId2;
        r1.mService.mHandler.sendEmptyMessage(28);
        r8 = callerPackage;
        r7 = callingUid;
        goto L406
    L251:
        action2 = action;
        intent4 = intent3;
        ProcessRecord resultToApp3 = resultToApp2;
        userId3 = userId2;
        int timeFormatPreferenceMsgValue = intent4.getIntExtra("android.intent.extra.TIME_PREF_24_HOUR_FORMAT", -1);
        if (timeFormatPreferenceMsgValue == (-1)) goto L255;
        Message updateTimePreferenceMsg = r1.mService.mHandler.obtainMessage(41, timeFormatPreferenceMsgValue, 0);
        r1.mService.mHandler.sendMessage(updateTimePreferenceMsg);
    L255:
        r1.mService.mBatteryStatsService.noteCurrentTimeChanged();
        r8 = callerPackage;
        r7 = callingUid;
        resultToApp2 = resultToApp3;
        goto L406
    L256:
        action2 = action;
        intent4 = intent3;
        userId3 = userId2;
        r1.mService.mHandler.sendEmptyMessage(13);
        r8 = callerPackage;
        r7 = callingUid;
        goto L406
    L257:
        action2 = action;
        intent4 = intent3;
        ProcessRecord resultToApp4 = resultToApp2;
        userId3 = userId2;
        Uri data2 = intent4.getData();
        if (data2 == null) goto L263;
        String ssp = data2.getSchemeSpecificPart();
        if (ssp == null) goto L262;
        r1.mService.mAtmInternal.onPackageDataCleared(ssp, userId3);
        r8 = callerPackage;
        r7 = callingUid;
        resultToApp2 = resultToApp4;
        goto L406
    L262:
        r8 = callerPackage;
        r7 = callingUid;
        resultToApp2 = resultToApp4;
        goto L406
    L263:
        r8 = callerPackage;
        r7 = callingUid;
        resultToApp2 = resultToApp4;
        goto L406
    L264:
        intent4 = intent3;
        ProcessRecord resultToApp5 = resultToApp2;
        userId3 = userId2;
        action2 = action;
        Uri data3 = intent4.getData();
        if (data3 == null) goto L282;
        String ssp2 = data3.getSchemeSpecificPart();
        if (ssp2 == null) goto L281;
        r1.mService.mAtmInternal.onPackageAdded(ssp2, intent4.getBooleanExtra("android.intent.extra.REPLACING", false));
        ApplicationInfo ai = AppGlobals.getPackageManager().getApplicationInfo(ssp2, DeviceStorageMonitorServiceSmtEx.TrafficStats.KB_IN_BYTES, 0);     // Catch: RemoteException -> L278
        BatteryStatsService r115 = r1.mService.mBatteryStatsService;     // Catch: RemoteException -> L278
        if (ai == null) goto L275;
        Intent intent11 = intent4;
        long r28 = ai.longVersionCode;     // Catch: RemoteException -> L273
    L276:
        r115.notePackageInstalled(ssp2, r28);     // Catch: RemoteException -> L273
    L280:
        r8 = callerPackage;
        r7 = callingUid;
        resultToApp2 = resultToApp5;
        intent4 = intent11;
        goto L406
    L275:
        intent11 = intent4;
        r28 = 0;
    L279:
        intent11 = intent4;
        goto L280
    L281:
        r8 = callerPackage;
        r7 = callingUid;
        resultToApp2 = resultToApp5;
        goto L406
    L282:
        r8 = callerPackage;
        r7 = callingUid;
        resultToApp2 = resultToApp5;
        goto L406
    L283:
        action2 = action;
        Intent intent12 = intent3;
        ProcessRecord resultToApp6 = resultToApp2;
        userId3 = userId2;
        Uri data4 = intent12.getData();
        if (data4 == null) goto L297;
        String ssp3 = data4.getSchemeSpecificPart();
        if (ssp3 != null) goto L665;
        r8 = callerPackage;
        r7 = callingUid;
        intent4 = intent12;
        resultToApp2 = resultToApp6;
        goto L406
    L665:
        ApplicationInfo aInfo = AppGlobals.getPackageManager().getApplicationInfo(ssp3, DeviceStorageMonitorServiceSmtEx.TrafficStats.KB_IN_BYTES, userId3);     // Catch: RemoteException -> L290
    L292:
        if (aInfo != null) goto L295;
        Slog.w(TAG_BROADCAST, "Dropping ACTION_PACKAGE_REPLACED for non-existent pkg: ssp=" + ssp3 + " data=" + data4);
        r1.scheduleCanceledResultTo(resultToApp6, resultTo, intent12, userId3, brOptions, callingUid, callerPackage);
        return 0;
    L295:
        r8 = callerPackage;
        r7 = callingUid;
        intent4 = intent12;
        r1.mService.updateAssociationForApp(aInfo);
        r1.mService.mAtmInternal.onPackageReplaced(aInfo);
        r1.mService.mServices.updateServiceApplicationInfoLocked(aInfo);
        r1.sendPackageBroadcastLocked(3, new String[]{ssp3}, userId3);
        resultToApp2 = resultToApp6;
    L291:
        aInfo = null;
        goto L292
    L297:
        r8 = callerPackage;
        r7 = callingUid;
        intent4 = intent12;
        resultToApp2 = resultToApp6;
        goto L406
    L298:
        r8 = callerPackage;
        action2 = action;
        intent4 = intent3;
        ProcessRecord resultToApp7 = resultToApp2;
        r7 = r12;
        userId3 = userId2;
        if (ActivityManagerService.checkComponentPermission("android.permission.BROADCAST_PACKAGE_REMOVED", callingPid, r7, -1, true) == 0) goto L301;
        String msg5 = "Permission Denial: " + intent4.getAction() + " broadcast from " + r8 + " (pid=" + callingPid + ", uid=" + r7 + ") requires android.permission.BROADCAST_PACKAGE_REMOVED";
        Slog.w(TAG_BROADCAST, msg5);
        throw new SecurityException(msg5);
    L301:
        switch(action2.hashCode()) {
            case -1749672628: goto L322;
            case -1403934493: goto L319;
            case -1338021860: goto L316;
            case -1001645458: goto L313;
            case 172491798: goto L310;
            case 525384130: goto L307;
            case 1290767157: goto L304;
            default: goto L324;
        };
    L324:
        byte r116 = -1;
    L325:
        switch(r116) {
            case 0: goto L391;
            case 1: goto L382;
            case 2: goto L381;
            case 3: goto L337;
            case 4: goto L337;
            case 5: goto L327;
            case 6: goto L327;
            default: goto L326;
        };
    L326:
        resultToApp2 = resultToApp7;
        goto L406
    L327:
        boolean suspended = "android.intent.action.PACKAGES_SUSPENDED".equals(intent4.getAction());
        String[] packageNames = intent4.getStringArrayExtra("android.intent.extra.changed_package_list");
        int userIdExtra = intent4.getIntExtra("android.intent.extra.user_handle", ProcessList.INVALID_ADJ);
        r1.mService.mAtmInternal.onPackagesSuspendedChanged(packageNames, suspended, userIdExtra);
        boolean quarantined = intent4.getBooleanExtra("android.intent.extra.quarantined", false);
        if (suspended == false) goto L336;
        if (quarantined == false) goto L336;
        if (packageNames == null) goto L336;
        int i6 = 0;
    L332:
        boolean suspended2 = suspended;
        if (i6 >= packageNames.length) goto L335;
        r1.mService.forceStopPackage(packageNames[i6], userId3, 1, "quarantined");
        i6 = i6 + 1;
        suspended = suspended2;
        packageNames = packageNames;
        userIdExtra = userIdExtra;
        resultToApp7 = resultToApp7;
        goto L332
    L335:
        resultToApp2 = resultToApp7;
    L336:
        resultToApp2 = resultToApp7;
        goto L406
    L337:
        resultToApp2 = resultToApp7;
        Uri data5 = intent4.getData();
        if (data5 == null) goto L406;
        String ssp4 = data5.getSchemeSpecificPart();
        if (ssp4 == null) goto L406;
        boolean removed = "android.intent.action.PACKAGE_REMOVED".equals(action2);
        boolean replacing = intent4.getBooleanExtra("android.intent.extra.REPLACING", false);
        boolean killProcess = !intent4.getBooleanExtra("android.intent.extra.DONT_KILL_APP", false);
        if (removed == false) goto L345;
        if (replacing == true) goto L345;
        boolean fullUninstall = true;
    L346:
        if (removed == false) goto L359;
        if (killProcess == false) goto L349;
        r1.mService.forceStopPackageLocked(ssp4, UserHandle.getAppId(intent4.getIntExtra("android.intent.extra.UID", -1)), false, true, true, false, fullUninstall, false, userId3, "pkg removed");
        String ssp5 = ssp4;
        r1.mService.getPackageManagerInternal().onPackageProcessKilledForUninstall(ssp5);
    L350:
        if (killProcess == false) goto L353;
        r41 = 0;
    L353:
        int cmd = r41;
        r1.sendPackageBroadcastLocked(cmd, new String[]{ssp5}, userId3);
        if (fullUninstall == false) goto L406;
        r1.mService.mUgmInternal.removeUriPermissionsForPackage(ssp5, userId3, true, false);
        r1.mService.mAtmInternal.removeRecentTasksByPackageName(ssp5, userId3);
        r1.mService.mServices.forceStopPackageLocked(ssp5, userId3);
        r1.mService.mAtmInternal.onPackageUninstalled(ssp5, userId3);
        r1.mService.mBatteryStatsService.notePackageUninstalled(ssp5);
        goto L406
    L349:
        ssp5 = ssp4;
        r1.mService.forceStopAppZygoteLocked(ssp5, UserHandle.getAppId(intent4.getIntExtra("android.intent.extra.UID", -1)), userId3);
        goto L350
    L359:
        if (killProcess == false) goto L377;
        if (replacing == false) goto L362;
        int reason = 16;
        int subReason = 0;
    L363:
        int extraUid = intent4.getIntExtra("android.intent.extra.UID", -1);
        ActivityManagerGlobalLock r29 = r1.mService.mProcLock;
        ActivityManagerService.boostPriorityForProcLockedSection();
        monitor-enter(r29);
    L370:
        th = th;
    L374:
        monitor-exit(r29);     // Catch: Throwable -> L370
        ActivityManagerService.resetPriorityAfterProcLockedSection();
        throw th;
    L660:
        r1.mService.mProcessList.killPackageProcessesLSP(ssp4, UserHandle.getAppId(extraUid), userId3, ProcessList.INVALID_ADJ, reason, subReason, "change " + ssp4);     // Catch: Throwable -> L372
        monitor-exit(r29);     // Catch: Throwable -> L370
        ActivityManagerService.resetPriorityAfterProcLockedSection();
    L372:
        th = th;
        goto L374
    L362:
        reason = 15;
        subReason = 0;
    L377:
        r1.mService.cleanupDisabledPackageComponentsLocked(ssp4, userId3, intent4.getStringArrayExtra("android.intent.extra.changed_component_name_list"));
        r1.mService.mServices.schedulePendingServiceStartLocked(ssp4, userId3);
    L345:
        fullUninstall = false;
        goto L346
    L381:
        resultToApp2 = resultToApp7;
        r1.mService.mAtmInternal.cleanupRecentTasksForUser(-1);
        goto L406
    L382:
        resultToApp2 = resultToApp7;
        String[] list3 = intent4.getStringArrayExtra("android.intent.extra.changed_package_list");
        if (list3 == null) goto L406;
        if (list3.length <= 0) goto L406;
        int i7 = 0;
    L388:
        if (i7 >= list3.length) goto L390;
        r1.mService.forceStopPackageLocked(list3[i7], -1, false, true, true, false, false, false, userId3, "storage unmount");
        i7 = i7 + 1;
        goto L388
    L390:
        r1.mService.mAtmInternal.cleanupRecentTasksForUser(-1);
        r1.sendPackageBroadcastLocked(1, list3, userId3);
        goto L406
    L391:
        resultToApp2 = resultToApp7;
        int uid2 = r1.getUidFromIntent(intent4);
        if (uid2 < 0) goto L406;
        r1.mService.mBatteryStatsService.removeUid(uid2);
        if (intent4.getBooleanExtra("android.intent.extra.REPLACING", false) == false) goto L396;
        r1.mService.mAppOpsService.resetAllModes(UserHandle.getUserId(uid2), intent4.getStringExtra("android.intent.extra.PACKAGE_NAME"));
        goto L406
    L396:
        r1.mService.mAppOpsService.uidRemoved(uid2);
        r1.mService.mServices.onUidRemovedLocked(uid2);
        r1.mService.mSmtOpsService.uidRemoved(uid2);
        goto L406
    L304:
        if (action2.equals("android.intent.action.PACKAGES_UNSUSPENDED") == false) goto L324;
        r116 = 6;
        goto L325
    L307:
        if (action2.equals("android.intent.action.PACKAGE_REMOVED") == false) goto L324;
        r116 = 3;
        goto L325
    L310:
        if (action2.equals("android.intent.action.PACKAGE_CHANGED") == false) goto L324;
        r116 = 4;
        goto L325
    L313:
        if (action2.equals("android.intent.action.PACKAGES_SUSPENDED") == false) goto L324;
        r116 = 5;
        goto L325
    L316:
        if (action2.equals("android.intent.action.EXTERNAL_APPLICATIONS_AVAILABLE") == false) goto L324;
        r116 = 2;
        goto L325
    L319:
        if (action2.equals("android.intent.action.EXTERNAL_APPLICATIONS_UNAVAILABLE") == false) goto L324;
        r116 = 1;
        goto L325
    L322:
        if (action2.equals("android.intent.action.UID_REMOVED") == false) goto L324;
        r116 = 0;
        goto L325
    L400:
        r8 = callerPackage;
        action2 = action;
        intent4 = intent3;
        r7 = r12;
        userId3 = userId2;
        UserManagerInternal umInternal = (UserManagerInternal) LocalServices.getService(UserManagerInternal.class);
        UserInfo userInfo = umInternal.getUserInfo(userId3);
        if (userInfo == null) goto L406;
        if (userInfo.isCloneProfile() == false) goto L406;
        userId3 = umInternal.getProfileParentId(userId3);
        goto L406
    L240:
        if (r1.mService.mAtmInternal.checkCanCloseSystemDialogs(callingPid, r12, callerPackage) == true) goto L243;
        r1.scheduleCanceledResultTo(resultToApp2, resultTo, intent3, userId2, brOptions, r12, callerPackage);
        return 0;
    L243:
        action2 = action;
        intent4 = intent3;
        userId3 = userId2;
        r1 = this;
        r8 = callerPackage;
        r7 = callingUid;
        goto L406
    L173:
        if (action.equals("android.security.action.TRUST_STORE_CHANGED") == false) goto L235;
        r26 = ParameterName.DE_CONTOUR;
        goto L236
    L176:
        if (action.equals("android.net.action.CLEAR_DNS_CACHE") == false) goto L235;
        r26 = 13;
        goto L236
    L179:
        if (action.equals("android.intent.action.PACKAGE_ADDED") == false) goto L235;
        r26 = 9;
        goto L236
    L182:
        if (action.equals("android.intent.action.PACKAGES_UNSUSPENDED") == false) goto L235;
        r26 = 7;
        goto L236
    L185:
        if (action.equals("android.hardware.action.NEW_PICTURE") == false) goto L235;
        r26 = 15;
        goto L236
    L188:
        if (action.equals("android.intent.action.MEDIA_SCANNER_SCAN_FILE") == false) goto L235;
        r26 = 0;
        goto L236
    L191:
        if (action.equals("android.intent.action.PRE_BOOT_COMPLETED") == false) goto L235;
        r26 = ParameterName.FILM_MODE;
        goto L236
    L194:
        if (action.equals("com.android.launcher.action.INSTALL_SHORTCUT") == false) goto L235;
        r26 = ParameterName.DYNAMIC_LUMA_CONTROL;
        goto L236
    L197:
        if (action.equals("android.intent.action.PACKAGE_REMOVED") == false) goto L235;
        r26 = 2;
        goto L236
    L200:
        if (action.equals("android.intent.action.TIME_SET") == false) goto L235;
        r26 = 12;
        goto L236
    L203:
        if (action.equals("android.intent.action.TIMEZONE_CHANGED") == false) goto L235;
        r26 = 11;
        goto L236
    L206:
        if (action.equals("android.intent.action.PACKAGE_DATA_CLEARED") == false) goto L235;
        r26 = 10;
        goto L236
    L209:
        if (action.equals("android.intent.action.PROXY_CHANGE") == false) goto L235;
        r26 = 14;
        goto L236
    L212:
        if (action.equals("android.intent.action.PACKAGE_CHANGED") == false) goto L235;
        r26 = 3;
        goto L236
    L215:
        if (action.equals("android.intent.action.CLOSE_SYSTEM_DIALOGS") == false) goto L235;
        r26 = ParameterName.BLACK_STRETCH;
        goto L236
    L218:
        if (action.equals("android.intent.action.PACKAGE_REPLACED") == false) goto L235;
        r26 = 8;
        goto L236
    L221:
        if (action.equals("android.intent.action.PACKAGES_SUSPENDED") == false) goto L235;
        r26 = 6;
        goto L236
    L224:
        if (action.equals("android.intent.action.EXTERNAL_APPLICATIONS_AVAILABLE") == false) goto L235;
        r26 = 5;
        goto L236
    L227:
        if (action.equals("android.intent.action.EXTERNAL_APPLICATIONS_UNAVAILABLE") == false) goto L235;
        r26 = 4;
        goto L236
    L230:
        if (action.equals("android.intent.action.UID_REMOVED") == false) goto L235;
        r26 = 1;
        goto L236
    L233:
        if (action.equals("android.hardware.action.NEW_VIDEO") == false) goto L235;
        r26 = 16;
        goto L236
    L162:
        if (r1.getWearRemoteIntentAction().equals(action) == false) goto L169;
        if (callerApp == null) goto L165;
        int callerProcState2 = callerApp.getCurProcState();
    L167:
        if (ActivityManager.RunningAppProcessInfo.procStateToImportance(callerProcState2) <= 100) goto L169;
        return r66;
    L165:
        callerProcState2 = 20;
        goto L167
    L141:
        if (r4.getComponent().getPackageName().equals(callerPackage) == false) goto L143;
        intent3 = r4;
        goto L151
    L143:
        String msg6 = "Permission Denial: not allowed to send broadcast " + action + " to " + r4.getComponent().getPackageName() + " from " + callerPackage;
        Slog.w(TAG_BROADCAST, msg6);
        throw new SecurityException(msg6);
    L134:
        if ("android.appwidget.action.APPWIDGET_UPDATE".equals(action) == true) goto L137;
        intent3 = r4;
        goto L151
    L150:
        intent3 = r4;
        goto L151
    L124:
        if (callerApp.isPersistent() == false) goto L126;
        r4 = 1;
        goto L127
    L128:
        r40 = 1;
    L651:
        e = move-exception;
        int r35 = r3;
        Slog.w(TAG_BROADCAST, "Remote exception", e);
        scheduleCanceledResultTo(resultToApp2, resultTo, r4, userId2, brOptions, callingUid, callerPackage);
        return r35;
    L75:
        if (brOptions.getTemporaryAppAllowlistDuration() <= 0) goto L85;
        r66 = -96;
        if (ActivityManagerService.checkComponentPermission("android.permission.CHANGE_DEVICE_IDLE_TEMP_WHITELIST", r5, realCallingUid, -1, true) == 0) goto L87;
        if (ActivityManagerService.checkComponentPermission("android.permission.START_ACTIVITIES_FROM_BACKGROUND", r5, realCallingUid, -1, true) == 0) goto L87;
        if (ActivityManagerService.checkComponentPermission("android.permission.START_FOREGROUND_SERVICES_FROM_BACKGROUND", realCallingPid, realCallingUid, -1, true) == 0) goto L87;
        String msg7 = "Permission Denial: " + intent2.getAction() + " broadcast from " + callerPackage + " (pid=" + callingPid + ", uid=" + callingUid + ") requires android.permission.CHANGE_DEVICE_IDLE_TEMP_WHITELIST or android.permission.START_ACTIVITIES_FROM_BACKGROUND or android.permission.START_FOREGROUND_SERVICES_FROM_BACKGROUND";
        Slog.w(TAG_BROADCAST, msg7);
        throw new SecurityException(msg7);
    L87:
        if (brOptions.isDontSendToRestrictedApps() == false) goto L95;
        if (r1.mService.isUidActiveLOSP(r12) == true) goto L95;
        if (r1.mService.isBackgroundRestrictedNoCheck(r12, callerPackage) == false) goto L95;
        Slog.i(TAG_BROADCAST, "Not sending broadcast " + action + " - app " + callerPackage + " has background restrictions");
        return r66;
    L95:
        if (brOptions.allowsBackgroundActivityStarts() == true) goto L97;
        BackgroundStartPrivileges backgroundStartPrivileges3 = backgroundStartPrivileges;
    L103:
        if (brOptions.getIdForResponseEvent() <= 0) goto L106;
        r1.mService.enforcePermission("android.permission.ACCESS_BROADCAST_RESPONSE_STATS", callingPid, r12, "recordResponseEventWhileInBackground");
    L106:
        if (brOptions.isDebugLogEnabled() == true) goto L108;
        r3 = 0;
    L117:
        backgroundStartPrivileges2 = backgroundStartPrivileges3;
        goto L655
    L108:
        if (r1.isShellOrRoot(r12) == true) goto L115;
        if (callerApp != null) goto L111;
    L114:
        r3 = 0;
        brOptions.setDebugLogEnabled(false);
        goto L117
    L111:
        if (callerApp.hasActiveInstrumentation() == false) goto L114;
        r3 = 0;
        goto L117
    L115:
        r3 = 0;
        goto L117
    L97:
        if (ActivityManagerService.checkComponentPermission("android.permission.START_ACTIVITIES_FROM_BACKGROUND", r5, realCallingUid, -1, true) != 0) goto L99;
        backgroundStartPrivileges3 = BackgroundStartPrivileges.ALLOW_BAL;
        goto L103
    L99:
        String msg8 = "Permission Denial: " + r4.getAction() + " broadcast from " + callerPackage + " (pid=" + callingPid + ", uid=" + r12 + ") requires android.permission.START_ACTIVITIES_FROM_BACKGROUND";
        Slog.w(TAG_BROADCAST, msg8);
        throw new SecurityException(msg8);
    L85:
        r66 = -96;
    L32:
        broadcastAllowList2 = broadcastAllowList;
        goto L33
    L24:
        r0 = false;
    L20:
        resultToApp2 = resultToApp;
        goto L21
    }

    private boolean isShellOrRoot(int uid) {
        if (uid == 2000) goto L7;
        if (uid == 0) goto L7;
        return false;
    L7:
        return true;
    }

    private void scheduleCanceledResultTo(ProcessRecord resultToApp, IIntentReceiver resultTo, Intent intent, int userId, BroadcastOptions options, int callingUid, String callingPackage) {
        if (resultTo != null) goto L5;
        return;
    L5:
        if (resultToApp == null) goto L7;
        IApplicationThread r2 = resultToApp.getOnewayThread();
    L8:
        IApplicationThread thread = r2;
        if (thread == null) goto L29;
        if (options != null) goto L30;
    L17:
        boolean r4 = false;
    L18:
        boolean shareIdentity = r4;
        int r13 = resultToApp.mState.getReportedProcState();     // Catch: RemoteException -> L15
        if (shareIdentity == false) goto L21;
        int r14 = callingUid;
    L22:
        if (shareIdentity == false) goto L24;
        String r15 = callingPackage;
    L25:
        thread.scheduleRegisteredReceiver(resultTo, intent, 0, null, null, false, false, true, userId, r13, r14, r15);     // Catch: RemoteException -> L15
        return;
    L15:
        e = move-exception;
        String msg = "Failed to schedule result of " + intent + " via " + resultToApp + ": " + e;
        resultToApp.killLocked("Can't schedule resultTo", 13, 26, true);
        Slog.d(TAG_BROADCAST, msg);
        return;
    L24:
        r15 = null;
        goto L25
    L21:
        r14 = -1;
        goto L22
    L30:
        if (options.isShareIdentityEnabled() == false) goto L17;
        r4 = true;
        goto L18
    L29:
        return;
    L7:
        r2 = null;
        goto L8
    }

    private int getRealProcessStateLocked(ProcessRecord app, int pid) {
        if (app != null) goto L11;
        ActivityManagerService.PidMap r0 = this.mService.mPidsSelfLocked;
        monitor-enter(r0);
        app = this.mService.mPidsSelfLocked.get(pid);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    L11:
        if (app != null) goto L13;
        return 20;
    L13:
        if (app.getThread() != null) goto L15;
        return 20;
    L15:
        if (app.isKilled() == false) goto L17;
        return 20;
    L17:
        return app.mState.getCurProcState();
    }

    private int getRealUidStateLocked(ProcessRecord app, int pid) {
        if (app != null) goto L11;
        ActivityManagerService.PidMap r0 = this.mService.mPidsSelfLocked;
        monitor-enter(r0);
        app = this.mService.mPidsSelfLocked.get(pid);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    L11:
        if (app != null) goto L13;
        return 20;
    L13:
        if (app.getThread() != null) goto L15;
        return 20;
    L15:
        if (app.isKilled() == true) goto L25;
        UidRecord uidRecord = app.getUidRecord();
        if (uidRecord != null) goto L19;
        return 20;
    L19:
        return uidRecord.getCurProcState();
    L25:
        return 20;
    }

    ArrayList<StickyBroadcast> getStickyBroadcastsForTest(String action, int userId) {
        SparseArray<ArrayMap<String, ArrayList<StickyBroadcast>>> r0 = this.mStickyBroadcasts;
        monitor-enter(r0);
        ArrayMap<String, ArrayList<StickyBroadcast>> stickyBroadcasts = this.mStickyBroadcasts.get(userId);     // Catch: Throwable -> L9
        if (stickyBroadcasts != null) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L9
        return null;
    L11:
        ArrayList<StickyBroadcast> r2 = stickyBroadcasts.get(action);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L9:
        th = move-exception;
        throw th;
    }

    void unbroadcastIntent(IApplicationThread caller, Intent intent, int userId) {
        if (intent != null) goto L4;
    L8:
        int userId2 = this.mService.mUserController.handleIncomingUser(Binder.getCallingPid(), Binder.getCallingUid(), userId, true, 0, "removeStickyBroadcast", null);
        if (this.mService.checkCallingPermission("android.permission.BROADCAST_STICKY") != 0) goto L39;
        ArrayList<String> changedStickyBroadcasts = new ArrayList();
        SparseArray<ArrayMap<String, ArrayList<StickyBroadcast>>> r2 = this.mStickyBroadcasts;
        monitor-enter(r2);
        ArrayMap<String, ArrayList<StickyBroadcast>> stickies = this.mStickyBroadcasts.get(userId2);     // Catch: Throwable -> L21
        if (stickies == null) goto L31;
        ArrayList<StickyBroadcast> list = stickies.get(intent.getAction());     // Catch: Throwable -> L21
        if (list == null) goto L28;
        int N = list.size();     // Catch: Throwable -> L21
        int i = 0;
    L17:
        if (i >= N) goto L25;
        if (intent.filterEquals(list.get(i).intent) == true) goto L20;
        i = i + 1;     // Catch: Throwable -> L21
        goto L17
    L20:
        list.remove(i);     // Catch: Throwable -> L21
    L25:
        if (list.size() > 0) goto L27;
        stickies.remove(intent.getAction());     // Catch: Throwable -> L21
    L27:
        changedStickyBroadcasts.add(intent.getAction());     // Catch: Throwable -> L21
    L28:
        int N2 = stickies.size();     // Catch: Throwable -> L21
        if (N2 > 0) goto L31;
        this.mStickyBroadcasts.remove(userId2);     // Catch: Throwable -> L21
    L31:
        monitor-exit(r2);     // Catch: Throwable -> L21
        int i2 = changedStickyBroadcasts.size() - 1;
    L33:
        if (i2 < 0) goto L36;
        BroadcastStickyCache.invalidateCache(changedStickyBroadcasts.get(i2));
        i2 = i2 - 1;
        goto L33
    L36:
        return;
    L21:
        th = move-exception;
        throw th;
    L39:
        String msg = "Permission Denial: unbroadcastIntent() from pid=" + Binder.getCallingPid() + ", uid=" + Binder.getCallingUid() + " requires android.permission.BROADCAST_STICKY";
        Slog.w(TAG_BROADCAST, msg);
        throw new SecurityException(msg);
    L4:
        if (intent.hasFileDescriptors() == false) goto L8;
        throw new IllegalArgumentException("File descriptors passed in Intent");
    }

    void finishReceiver(IBinder caller, int resultCode, String resultData, Bundle resultExtras, boolean resultAbort, int flags) {
        if (ActivityManagerDebugConfig.DEBUG_BROADCAST == false) goto L5;
        Slog.v(TAG_BROADCAST, "Finish receiver: " + caller);
    L5:
        if (resultExtras != null) goto L7;
    L11:
        long origId = Binder.clearCallingIdentity();
        ActivityManagerService r3 = this.mService;     // Catch: Throwable -> L33
        ActivityManagerService.boostPriorityForLockedSection();     // Catch: Throwable -> L33
        monitor-enter(r3);     // Catch: Throwable -> L33
        ProcessRecord callerApp = this.mService.getRecordForAppLOSP(caller, true);     // Catch: Throwable -> L20
        if (callerApp != null) goto L22;
        Slog.w(TAG_BROADCAST, "finishReceiver: no app for " + caller);     // Catch: Throwable -> L20
        monitor-exit(r3);     // Catch: Throwable -> L20
        ActivityManagerService.resetPriorityAfterLockedSection();
        Binder.restoreCallingIdentity(origId);
        return;
    L22:
        int pid = callerApp.getSmtEx().getPid();     // Catch: Throwable -> L20
        if (SysOptBridge.getFactory().getFreezeController().isPidFrozen(pid) == false) goto L26;
        Slog.i(TAG_BROADCAST, "finishReceiver by freeze, caller=" + caller + ", pid=" + pid);     // Catch: Throwable -> L20
    L26:
        if (UserHandle.isApp(callerApp.uid) == false) goto L28;
        SysOptBridge.getFactory().getFreezeController().receiveBroadcastEvent(callerApp.uid, callerApp.mPid, true, true, null);     // Catch: Throwable -> L20
    L28:
        this.mBroadcastQueue.finishReceiverLocked(callerApp, resultCode, resultData, resultExtras, resultAbort, true);     // Catch: Throwable -> L20
        this.mService.trimApplicationsLocked(false, 2);     // Catch: Throwable -> L20
        monitor-exit(r3);     // Catch: Throwable -> L20
        ActivityManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L33
        Binder.restoreCallingIdentity(origId);
        return;
    L20:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L33
        throw th;     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        Binder.restoreCallingIdentity(origId);
        throw th;
    L7:
        if (resultExtras.hasFileDescriptors() == false) goto L11;
        throw new IllegalArgumentException("File descriptors passed in Bundle");
    }

    private int getUidFromIntent(Intent intent) {
        if (intent != null) goto L5;
        return -1;
    L5:
        Bundle intentExtras = intent.getExtras();
        if (intent.hasExtra("android.intent.extra.UID") == true) goto L9;
        return -1;
    L9:
        return intentExtras.getInt("android.intent.extra.UID");
    }

    final void rotateBroadcastStatsIfNeededLocked() {
        long now = SystemClock.elapsedRealtime();
        if (this.mCurBroadcastStats != null) goto L5;
    L6:
        this.mLastBroadcastStats = this.mCurBroadcastStats;
        if (this.mLastBroadcastStats == null) goto L9;
        BroadcastStats r2 = this.mLastBroadcastStats;
        r2.mEndRealtime = SystemClock.elapsedRealtime();
        BroadcastStats r3 = this.mLastBroadcastStats;
        r3.mEndUptime = SystemClock.uptimeMillis();
    L9:
        this.mCurBroadcastStats = new BroadcastStats();
        return;
    L5:
        if ((this.mCurBroadcastStats.mStartRealtime + 86400000) < now) goto L6;
    }

    final void addBroadcastStatLocked(String action, String srcPackage, int receiveCount, int skipCount, long dispatchTime) {
        rotateBroadcastStatsIfNeededLocked();
        this.mCurBroadcastStats.addBroadcast(action, srcPackage, receiveCount, skipCount, dispatchTime);
    }

    final void addBackgroundCheckViolationLocked(String action, String targetPackage) {
        rotateBroadcastStatsIfNeededLocked();
        this.mCurBroadcastStats.addBackgroundCheckViolation(action, targetPackage);
    }

    final void notifyBroadcastFinishedLocked(BroadcastRecord original) {
        if (original.callerApp == null) goto L5;
        ApplicationInfo info = original.callerApp.info;
    L6:
        if (info == null) goto L8;
        String callerPackage = info.packageName;
    L9:
        if (callerPackage == null) goto L12;
        this.mService.mHandler.obtainMessage(74, original.callingUid, 0, callerPackage).sendToTarget();
        return;
    L12:
        return;
    L8:
        callerPackage = original.callerPackage;
        goto L9
    L5:
        info = null;
        goto L6
    }

    final Intent verifyBroadcastLocked(Intent intent) {
        if (intent != null) goto L4;
    L8:
        int flags = intent.getFlags();
        if (this.mService.mProcessesReady == true) goto L19;
        if ((67108864 & flags) != 0) goto L19;
        if ((1073741824 & flags) != 0) goto L19;
        Slog.e(TAG_BROADCAST, "Attempt to launch receivers of broadcast intent " + intent + " before boot completion");
        throw new IllegalStateException("Cannot broadcast before boot completed");
    L19:
        if ((33554432 & flags) != 0) goto L28;
        if ((flags & 4194304) != 0) goto L23;
    L26:
        return intent;
    L23:
        switch(Binder.getCallingUid()) {
            case 0: goto L26;
            case 2000: goto L26;
            default: goto L24;
        };
    L24:
        Slog.w(TAG_BROADCAST, "Removing FLAG_RECEIVER_FROM_SHELL because caller is UID " + Binder.getCallingUid());
        intent.removeFlags(4194304);
        goto L26
    L28:
        throw new IllegalArgumentException("Can't use FLAG_RECEIVER_BOOT_UPGRADE here");
    L4:
        if (intent.hasFileDescriptors() == true) goto L7;
        intent.removeExtendedFlags(1);
        goto L8
    L7:
        throw new IllegalArgumentException("File descriptors passed in Intent");
    }

    private ArraySet<String> getBackgroundLaunchBroadcasts() {
        if (this.mBackgroundLaunchBroadcasts != null) goto L6;
        this.mBackgroundLaunchBroadcasts = SystemConfig.getInstance().getAllowImplicitBroadcasts();
    L6:
        return this.mBackgroundLaunchBroadcasts;
    }

    private boolean isInstantApp(ProcessRecord record, String callerPackage, int uid) {
        if (UserHandle.getAppId(uid) >= 10000) goto L5;
        return false;
    L5:
        if (record != null) goto L7;
        IPackageManager pm = AppGlobals.getPackageManager();
        if (callerPackage == null) goto L23;
    L19:
        this.mService.mAppOpsService.checkPackage(uid, callerPackage);     // Catch: RemoteException -> L15
        return pm.isInstantApp(callerPackage, UserHandle.getUserId(uid));
    L23:
        String[] packageNames = pm.getPackagesForUid(uid);     // Catch: RemoteException -> L15
        if (packageNames == null) goto L18;
        if (packageNames.length == 0) goto L18;
        callerPackage = packageNames[0];     // Catch: RemoteException -> L15
    L18:
        throw new IllegalArgumentException("Unable to determine caller package name");     // Catch: RemoteException -> L15
    L15:
        e = move-exception;
        Slog.e(TAG_BROADCAST, "Error looking up if " + callerPackage + " is an instant app.", e);
        return true;
    L7:
        return record.info.isInstantApp();
    }

    private String getWearRemoteIntentAction() {
        return this.mContext.getResources().getString(R.string.date_picker_day_of_week_typeface);
    }

    private void sendPackageBroadcastLocked(int cmd, String[] packages, int userId) {
        this.mService.mProcessList.sendPackageBroadcastLocked(cmd, packages, userId);
    }

    private List<ResolveInfo> collectReceiverComponents(Intent intent, String resolvedType, int callingUid, int callingPid, int[] users, int[] broadcastAllowList) {
        int[] r1 = users;
        long pmFlags = 268436480;
        int r12 = r1.length;
        List<ResolveInfo> receivers = null;
        HashSet<ComponentName> singleUserReceivers = null;
        boolean scannedFirstReceivers = false;
        int r3 = 0;
    L3:
        if (r3 >= r12) goto L66;
        int user = r1[r3];
        if (callingUid == 2000) goto L7;
    L9:
        int r16 = r3;
        List<ResolveInfo> newReceivers = this.mService.mPackageManagerInt.queryIntentReceivers(intent, resolvedType, pmFlags, callingUid, callingPid, user, true);
        if (user == 0) goto L19;
        if (newReceivers == null) goto L19;
        int i = 0;
    L14:
        if (i >= newReceivers.size()) goto L19;
        if ((newReceivers.get(i).activityInfo.flags & 536870912) == 0) goto L18;
        newReceivers.remove(i);
        i = i - 1;
    L18:
        i = i + 1;
    L19:
        if (newReceivers == null) goto L30;
        int i2 = newReceivers.size() - 1;
    L21:
        if (i2 < 0) goto L29;
        ResolveInfo ri = newReceivers.get(i2);
        ComponentAliasResolver r8 = this.mService.mComponentAliasResolver;
        List<ResolveInfo> newReceivers2 = newReceivers;
        int i3 = i2;
        long pmFlags2 = pmFlags;
        ComponentAliasResolver.Resolution<ResolveInfo> resolution = r8.resolveReceiver(intent, ri, resolvedType, pmFlags2, user, callingUid, callingPid);
        pmFlags = pmFlags2;
        if (resolution != null) goto L26;
        newReceivers2.remove(i3);
    L28:
        i2 = i3 - 1;
        newReceivers = newReceivers2;
        BroadcastController this = this;
        goto L21
    L26:
        if (resolution.isAlias() == false) goto L28;
        newReceivers2.set(i3, resolution.getTarget());
        goto L28
    L29:
        List<ResolveInfo> newReceivers3 = newReceivers;
    L31:
        if (newReceivers3 != null) goto L33;
    L35:
        List<ResolveInfo> newReceivers4 = newReceivers3;
    L36:
        if (receivers != null) goto L38;
        receivers = newReceivers4;
    L65:
        r3 = r16 + 1;
        r1 = users;
        goto L3
    L38:
        if (newReceivers4 == null) goto L65;
        if (scannedFirstReceivers == true) goto L51;
        scannedFirstReceivers = true;
        int i4 = 0;
    L43:
        if (i4 >= receivers.size()) goto L51;
        ResolveInfo ri2 = receivers.get(i4);
        if ((ri2.activityInfo.flags & 1073741824) == 0) goto L50;
        ComponentName cn = new ComponentName(ri2.activityInfo.packageName, ri2.activityInfo.name);
        if (singleUserReceivers != null) goto L49;
        singleUserReceivers = new HashSet();
    L49:
        singleUserReceivers.add(cn);
    L50:
        i4 = i4 + 1;
    L51:
        int i5 = 0;
    L53:
        if (i5 >= newReceivers4.size()) goto L65;
        ResolveInfo ri3 = newReceivers4.get(i5);
        if ((ri3.activityInfo.flags & 1073741824) == 0) goto L63;
        ComponentName cn2 = new ComponentName(ri3.activityInfo.packageName, ri3.activityInfo.name);
        if (singleUserReceivers != null) goto L60;
        singleUserReceivers = new HashSet();
    L60:
        if (singleUserReceivers.contains(cn2) == true) goto L64;
        singleUserReceivers.add(cn2);
        receivers.add(ri3);
    L64:
        i5 = i5 + 1;
        goto L53
    L63:
        receivers.add(ri3);
        goto L64
    L33:
        if (newReceivers3.size() != 0) goto L35;
        newReceivers4 = null;
        goto L36
    L30:
        newReceivers3 = newReceivers;
        goto L31
    L7:
        if (this.mService.mUserController.hasUserRestriction("no_debugging_features", user) == false) goto L9;
        r16 = r3;
        goto L65
    L66:
        if (receivers == null) goto L76;
        if (broadcastAllowList == null) goto L76;
        int i6 = receivers.size() - 1;
    L69:
        if (i6 < 0) goto L76;
        int receiverAppId = UserHandle.getAppId(receivers.get(i6).activityInfo.applicationInfo.uid);
        if (receiverAppId < 10000) goto L75;
        if (Arrays.binarySearch(broadcastAllowList, receiverAppId) >= 0) goto L75;
        receivers.remove(i6);
    L75:
        i6 = i6 - 1;
    L76:
        return receivers;
    }

    private void checkBroadcastFromSystem(Intent intent, ProcessRecord callerApp, String callerPackage, int callingUid, boolean isProtectedBroadcast, List receivers) {
        if ((intent.getFlags() & 4194304) == 0) goto L5;
        return;
    L5:
        String action = intent.getAction();
        if (isProtectedBroadcast == false) goto L8;
        return;
    L8:
        if ("android.intent.action.CLOSE_SYSTEM_DIALOGS".equals(action) == false) goto L10;
        return;
    L10:
        if ("com.android.intent.action.DISMISS_KEYBOARD_SHORTCUTS".equals(action) == false) goto L12;
        return;
    L12:
        if ("android.intent.action.MEDIA_BUTTON".equals(action) == false) goto L14;
        return;
    L14:
        if ("android.intent.action.MEDIA_SCANNER_SCAN_FILE".equals(action) == false) goto L16;
        return;
    L16:
        if ("com.android.intent.action.SHOW_KEYBOARD_SHORTCUTS".equals(action) == false) goto L18;
        return;
    L18:
        if ("android.intent.action.MASTER_CLEAR".equals(action) == false) goto L20;
        return;
    L20:
        if ("android.intent.action.FACTORY_RESET".equals(action) == false) goto L22;
        return;
    L22:
        if ("android.appwidget.action.APPWIDGET_CONFIGURE".equals(action) == false) goto L24;
        return;
    L24:
        if ("android.appwidget.action.APPWIDGET_UPDATE".equals(action) == false) goto L26;
        return;
    L26:
        if ("com.android.omadm.service.CONFIGURATION_UPDATE".equals(action) == false) goto L28;
        return;
    L28:
        if ("android.text.style.SUGGESTION_PICKED".equals(action) == false) goto L30;
        return;
    L30:
        if ("android.media.action.OPEN_AUDIO_EFFECT_CONTROL_SESSION".equals(action) == false) goto L32;
        return;
    L32:
        if ("android.media.action.CLOSE_AUDIO_EFFECT_CONTROL_SESSION".equals(action) == false) goto L35;
        return;
    L35:
        if (intent.getPackage() == null) goto L37;
    L38:
        if (receivers != null) goto L40;
        return;
    L40:
        if (receivers.size() == 0) goto L75;
        boolean allProtected = true;
        int i = receivers.size() - 1;
    L43:
        if (i < 0) goto L58;
        Object target = receivers.get(i);
        if ((target instanceof ResolveInfo) == false) goto L52;
        ResolveInfo ri = (ResolveInfo) target;
        if (ri.activityInfo.exported == false) goto L57;
        if (ri.activityInfo.permission != null) goto L57;
        allProtected = false;
    L57:
        i = i - 1;
        goto L43
    L52:
        BroadcastFilter bf = (BroadcastFilter) target;
        if (bf.exported == false) goto L57;
        if (bf.requiredPermission != null) goto L57;
        allProtected = false;
    L58:
        if (allProtected == false) goto L61;
        return;
    L61:
        if (callerApp == null) goto L63;
        Log.wtf(TAG_BROADCAST, "Sending non-protected broadcast " + action + " from system " + callerApp.toShortString() + " pkg " + callerPackage, new Throwable());
        return;
    L63:
        Log.wtf(TAG_BROADCAST, "Sending non-protected broadcast " + action + " from system uid " + UserHandle.formatUid(callingUid) + " pkg " + callerPackage, new Throwable());
        return;
    L75:
        return;
    L37:
        if (intent.getComponent() == null) goto L61;
        goto L38
    }

    void enforceBroadcastOptionPermissionsInternal(Bundle options, int callingUid) {
        enforceBroadcastOptionPermissionsInternal(BroadcastOptions.fromBundleNullable(options), callingUid);
    }

    private void enforceBroadcastOptionPermissionsInternal(BroadcastOptions options, int callingUid) {
        if (options != null) goto L4;
        return;
    L4:
        if (callingUid != 1000) goto L6;
        return;
    L6:
        if (options.isAlarmBroadcast() == false) goto L13;
        if (ActivityManagerDebugConfig.DEBUG_BROADCAST_LIGHT == false) goto L11;
        Slog.w(TAG_BROADCAST, "Non-system caller " + callingUid + " may not flag broadcast as alarm");
    L11:
        throw new SecurityException("Non-system callers may not flag broadcasts as alarm");
    L13:
        if (options.isInteractive() == false) goto L18;
        this.mService.enforceCallingPermission("android.permission.BROADCAST_OPTION_INTERACTIVE", "setInteractive");
        return;
    }

    void startBroadcastObservers() {
        this.mBroadcastQueue.start(this.mContext.getContentResolver());
    }

    void removeStickyBroadcasts(int userId) {
        ArrayList<String> changedStickyBroadcasts = new ArrayList();
        SparseArray<ArrayMap<String, ArrayList<StickyBroadcast>>> r1 = this.mStickyBroadcasts;
        monitor-enter(r1);
        ArrayMap<String, ArrayList<StickyBroadcast>> stickies = this.mStickyBroadcasts.get(userId);     // Catch: Throwable -> L7
        if (stickies == null) goto L9;
        changedStickyBroadcasts.addAll(stickies.keySet());     // Catch: Throwable -> L7
    L9:
        this.mStickyBroadcasts.remove(userId);     // Catch: Throwable -> L7
        monitor-exit(r1);     // Catch: Throwable -> L7
        int i = changedStickyBroadcasts.size() - 1;
    L12:
        if (i < 0) goto L15;
        BroadcastStickyCache.invalidateCache(changedStickyBroadcasts.get(i));
        i = i - 1;
        goto L12
    L15:
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @NeverCompile
    void dumpBroadcastsLocked(FileDescriptor fd, PrintWriter pw, String[] args, int opti, boolean dumpAll, String dumpPackage) {
        boolean needSep = false;
        int filteredUid = -1;
        if ("history".equals(dumpPackage) == false) goto L12;
        if (opti < args.length) goto L7;
    L9:
        boolean dumpAll2 = dumpAll;
    L10:
        int filteredUid2 = -1;
        boolean onlyFilter = false;
        String dumpIntentAction = null;
        boolean dumpAll3 = dumpAll2;
        int opti2 = opti;
        boolean onlyHistory = true;
        boolean printedAnything = false;
        boolean dumpAll4 = false;
        String dumpPackage2 = null;
    L50:
        if (ActivityManagerDebugConfig.DEBUG_BROADCAST == false) goto L53;
        Slogf.d(TAG_BROADCAST, "dumpBroadcastsLocked(): dumpPackage=%s, onlyHistory=%b, onlyReceivers=%b, filteredUid=%d", new Object[]{dumpPackage2, Boolean.valueOf(onlyHistory), Boolean.valueOf(dumpAll4), Integer.valueOf(filteredUid2)});
    L53:
        pw.println("ACTIVITY MANAGER BROADCAST STATE (dumpsys activity broadcasts)");
        if (onlyHistory == true) goto L97;
        if (onlyFilter == true) goto L97;
        if (dumpAll3 == false) goto L97;
        if (this.mRegisteredReceivers.size() <= 0) goto L85;
        boolean printed = false;
        Iterator<ReceiverList> r2 = this.mRegisteredReceivers.values().iterator();
        boolean printedAnything2 = printedAnything;
    L61:
        if (r2.hasNext() == false) goto L84;
        ReceiverList r = r2.next();
        if (dumpPackage2 == null) goto L71;
        if (r.app == null) goto L78;
        if (dumpPackage2.equals(r.app.info.packageName) == true) goto L71;
    L78:
        printed = printed;
        r2 = r2;
        needSep = needSep;
        printedAnything2 = printedAnything2;
    L71:
        if (filteredUid2 == (-1)) goto L79;
        if (filteredUid2 == r.app.uid) goto L79;
        if (ActivityManagerDebugConfig.DEBUG_BROADCAST == false) goto L78;
        Slogf.v(TAG_BROADCAST, "dumpBroadcastsLocked(): skipping receiver whose uid (%d) is not %d: %s", new Object[]{Integer.valueOf(r.app.uid), Integer.valueOf(filteredUid2), r.app});
    L79:
        boolean printed2 = printed;
        Iterator<ReceiverList> r32 = r2;
        boolean needSep2 = needSep;
        boolean printedAnything3 = printedAnything2;
        if (printed2 == true) goto L82;
        pw.println("  Registered Receivers:");
        printedAnything2 = true;
        needSep = true;
        printed = true;
    L83:
        pw.print("  * ");
        pw.println(r);
        r.dump(pw, "    ");
        r2 = r32;
        goto L61
    L82:
        printed = printed2;
        needSep = needSep2;
        printedAnything2 = printedAnything3;
        goto L83
    L84:
        boolean printedAnything4 = printedAnything2;
        boolean printed3 = needSep;
    L88:
        if (dumpAll4 == true) goto L96;
        IntentResolver<BroadcastFilter, BroadcastFilter> r3 = this.mReceiverResolver;
        if (printed3 == false) goto L92;
        String r4 = "\n  Receiver Resolver Table:";
    L94:
        if (r3.dump(pw, r4, "    ", dumpPackage2, false, false) == false) goto L96;
        needSep = true;
        boolean needSep3 = true;
    L98:
        if (dumpAll4 == true) goto L100;
        String dumpPackage3 = dumpPackage2;
        int opti3 = opti2;
        boolean needSep4 = this.mBroadcastQueue.dumpLocked(fd, pw, args, opti3, true, true, dumpAll3, dumpPackage3, dumpIntentAction, needSep);
        PrintWriter r5 = pw;
        int opti4 = opti3;
        dumpPackage2 = dumpPackage3;
        boolean printedAnything5 = needSep3 | needSep4;
        boolean needSep5 = printedAnything5;
    L101:
        boolean needSep6 = true;
        SparseArray<ArrayMap<String, ArrayList<StickyBroadcast>>> r8 = this.mStickyBroadcasts;
        monitor-enter(r8);
        if (onlyHistory == true) goto L147;
        if (dumpAll4 == true) goto L147;
        if (onlyFilter == true) goto L147;
    L144:
        th = th;
    L157:
        monitor-exit(r8);     // Catch: Throwable -> L156
    L156:
        th = th;
        goto L157
    L158:
        throw th;
    L107:
        if (this.mStickyBroadcasts == null) goto L147;
        if (dumpPackage2 != null) goto L147;
        int user = 0;
    L110:
        if (user >= this.mStickyBroadcasts.size()) goto L147;
        if (needSep6 == true) goto L167;
    L117:
        needSep6 = true;
        needSep5 = true;
        r5.print("  Sticky broadcasts for user ");     // Catch: Throwable -> L138
        r5.print(this.mStickyBroadcasts.keyAt(user));     // Catch: Throwable -> L138
        r5.println(":");     // Catch: Throwable -> L138
        StringBuilder sb = new StringBuilder(128);     // Catch: Throwable -> L138
        Iterator<Map.Entry<String, ArrayList<StickyBroadcast>>> r12 = this.mStickyBroadcasts.valueAt(user).entrySet().iterator();     // Catch: Throwable -> L138
    L120:
        if (r12.hasNext() == false) goto L142;
        Map.Entry<String, ArrayList<StickyBroadcast>> ent = r12.next();     // Catch: Throwable -> L138
        int user2 = user;
        r5.print("  * Sticky action ");     // Catch: Throwable -> L138
        r5.print(ent.getKey());     // Catch: Throwable -> L138
        if (dumpAll3 == false) goto L140;
        r5.println(":");     // Catch: Throwable -> L138
        ArrayList<StickyBroadcast> broadcasts = ent.getValue();     // Catch: Throwable -> L138
        int N = broadcasts.size();     // Catch: Throwable -> L138
        boolean printedAnything6 = needSep5;
        int i = 0;
    L125:
        int opti5 = opti4;
        int opti6 = N;
        if (i >= opti6) goto L141;
        N = opti6;
        Intent intent = broadcasts.get(i).intent;     // Catch: Throwable -> L130
        boolean deferUntilActive = broadcasts.get(i).deferUntilActive;     // Catch: Throwable -> L130
        sb.setLength(0);     // Catch: Throwable -> L130
        sb.append("    Intent: ");     // Catch: Throwable -> L130
        intent.toShortString(sb, false, true, false, false);     // Catch: Throwable -> L130
        r5.print(sb);     // Catch: Throwable -> L130
        if (deferUntilActive == false) goto L132;
        r5.print(" [D]");     // Catch: Throwable -> L130
    L132:
        r5.println();     // Catch: Throwable -> L130
        r5.print("      originalCallingUid: ");     // Catch: Throwable -> L130
        r5.println(broadcasts.get(i).originalCallingUid);     // Catch: Throwable -> L130
        r5.println();     // Catch: Throwable -> L130
        Bundle bundle = intent.getExtras();     // Catch: Throwable -> L130
        if (bundle == null) goto L136;
        r5.print("      extras: ");     // Catch: Throwable -> L130
        r5.println(bundle);     // Catch: Throwable -> L130
    L136:
        i = i + 1;     // Catch: Throwable -> L130
        broadcasts = broadcasts;
        opti4 = opti5;
    L130:
        th = th;
    L141:
        user = user2;
        needSep5 = printedAnything6;
        opti4 = opti5;
        goto L120
    L140:
        printedAnything6 = needSep5;
        opti5 = opti4;
        r5.println("");     // Catch: Throwable -> L130
        goto L141
    L142:
        user = user + 1;
    L138:
        th = th;
        goto L157
    L167:
        r5.println();     // Catch: Throwable -> L115
    L115:
        th = th;
    L147:
        monitor-exit(r8);     // Catch: Throwable -> L156
        if (onlyHistory == true) goto L153;
        if (dumpAll4 == true) goto L153;
        if (onlyFilter == true) goto L153;
        if (dumpAll3 == false) goto L153;
        r5.println();
        r5.println("  Queue " + this.mBroadcastQueue + ": " + this.mBroadcastQueue.describeStateLocked());
        r5.println("  mHandler:");
        this.mService.mHandler.dump(new PrintWriterPrinter(r5), "    ");
        needSep5 = true;
    L153:
        if (needSep5 == true) goto L191;
        r5.println("  (nothing)");
        return;
    L191:
        return;
    L169:
        th = th;
        goto L157
    L100:
        opti4 = opti2;
        r5 = pw;
        needSep5 = needSep3;
        goto L101
    L92:
        r4 = "  Receiver Resolver Table:";
    L96:
        needSep = printed3;
        needSep3 = printedAnything4;
        goto L98
    L85:
        if (dumpAll4 == false) goto L87;
        pw.println("  (no registered receivers)");
    L87:
        printedAnything4 = printedAnything;
        printed3 = false;
    L97:
        needSep3 = printedAnything;
        goto L98
    L7:
        if ("-s".equals(args[opti]) == false) goto L9;
        dumpAll2 = false;
        goto L10
    L12:
        if ("receivers".equals(dumpPackage) == false) goto L35;
        String dumpPackage4 = null;
        if ((opti + 2) > args.length) goto L33;
        int i2 = opti;
    L17:
        if (i2 >= args.length) goto L32;
        String arg = args[i2];
        switch(arg.hashCode()) {
            case 43014832: goto L22;
            default: goto L24;
        };
    L24:
        byte r0 = -1;
    L25:
        switch(r0) {
            case 0: goto L28;
            default: goto L26;
        };
    L28:
        String dumpPackage5 = dumpPackage4;
        int i3 = i2 + 1;
        filteredUid = getIntArg(pw, args, i3, -1);
        if (filteredUid == (-1)) goto L30;
        i2 = i3 + 1;
        dumpPackage4 = dumpPackage5;
        goto L17
    L30:
        return;
    L26:
        pw.printf("Invalid argument at index %d: %s\n", new Object[]{Integer.valueOf(i2), arg});
        return;
    L22:
        if (arg.equals("--uid") == false) goto L24;
        r0 = 0;
        goto L25
    L32:
        dumpAll3 = dumpAll;
        printedAnything = false;
        dumpAll4 = true;
        filteredUid2 = filteredUid;
        onlyFilter = false;
        dumpIntentAction = null;
        opti2 = opti;
        dumpPackage2 = dumpPackage4;
        onlyHistory = false;
        goto L50
    L33:
        dumpAll3 = dumpAll;
        printedAnything = false;
        dumpAll4 = true;
        filteredUid2 = -1;
        onlyFilter = false;
        dumpIntentAction = null;
        opti2 = opti;
        dumpPackage2 = null;
        onlyHistory = false;
        goto L50
    L35:
        if (DomainVerificationPersistence.ATTR_FILTER.equals(dumpPackage) == true) goto L37;
        dumpAll3 = dumpAll;
        printedAnything = false;
        dumpAll4 = false;
        filteredUid2 = -1;
        onlyFilter = false;
        dumpIntentAction = null;
        opti2 = opti;
        dumpPackage2 = dumpPackage;
        onlyHistory = false;
        goto L50
    L37:
        if ((opti + 2) > args.length) goto L47;
        int opti7 = opti + 1;
        if ("--action".equals(args[opti]) == false) goto L45;
        int opti8 = opti7 + 1;
        String dumpIntentAction2 = args[opti7];
        if (dumpIntentAction2 != null) goto L44;
        pw.printf("Missing argument for --action option\n", new Object[0]);
        return;
    L44:
        dumpPackage2 = null;
        printedAnything = false;
        dumpAll3 = dumpAll;
        dumpAll4 = false;
        filteredUid2 = -1;
        onlyFilter = true;
        dumpIntentAction = dumpIntentAction2;
        opti2 = opti8;
        onlyHistory = false;
        goto L50
    L45:
        pw.printf("Unknown argument: %s\n", new Object[]{args[opti7]});
        return;
    L47:
        dumpPackage2 = null;
        printedAnything = false;
        dumpAll3 = dumpAll;
        dumpAll4 = false;
        filteredUid2 = -1;
        onlyFilter = true;
        dumpIntentAction = null;
        opti2 = opti;
        onlyHistory = false;
        goto L50
    }

    private static int getIntArg(PrintWriter pw, String[] args, int index, int invalidValue) {
        if (index <= args.length) goto L6;
        pw.println("Missing argument");
        return invalidValue;
    L6:
        String arg = args[index];
        return Integer.parseInt(arg);
    L10:
        pw.printf("Non-numeric argument at index %d: %s\n", new Object[]{Integer.valueOf(index), arg});
        return invalidValue;
    }

    @NeverCompile
    void dumpBroadcastStatsLocked(FileDescriptor fd, PrintWriter pw, String[] args, int opti, boolean dumpAll, String dumpPackage) {
        if (this.mCurBroadcastStats != null) goto L5;
        return;
    L5:
        pw.println("ACTIVITY MANAGER BROADCAST STATS STATE (dumpsys activity broadcast-stats)");
        long now = SystemClock.elapsedRealtime();
        if (this.mLastBroadcastStats == null) goto L11;
        pw.print("  Last stats (from ");
        TimeUtils.formatDuration(this.mLastBroadcastStats.mStartRealtime, now, pw);
        pw.print(" to ");
        TimeUtils.formatDuration(this.mLastBroadcastStats.mEndRealtime, now, pw);
        pw.print(", ");
        TimeUtils.formatDuration(this.mLastBroadcastStats.mEndUptime - this.mLastBroadcastStats.mStartUptime, pw);
        pw.println(" uptime):");
        if (this.mLastBroadcastStats.dumpStats(pw, "    ", dumpPackage) == true) goto L10;
        pw.println("    (nothing)");
    L10:
        pw.println();
    L11:
        pw.print("  Current stats (from ");
        TimeUtils.formatDuration(this.mCurBroadcastStats.mStartRealtime, now, pw);
        pw.print(" to now, ");
        TimeUtils.formatDuration(SystemClock.uptimeMillis() - this.mCurBroadcastStats.mStartUptime, pw);
        pw.println(" uptime):");
        if (this.mCurBroadcastStats.dumpStats(pw, "    ", dumpPackage) == true) goto L15;
        pw.println("    (nothing)");
        return;
    }

    @NeverCompile
    void dumpBroadcastStatsCheckinLocked(FileDescriptor fd, PrintWriter pw, String[] args, int opti, boolean fullCheckin, String dumpPackage) {
        if (this.mCurBroadcastStats != null) goto L6;
        return;
    L6:
        if (this.mLastBroadcastStats == null) goto L11;
        this.mLastBroadcastStats.dumpCheckinStats(pw, dumpPackage);
        if (fullCheckin == false) goto L11;
        this.mLastBroadcastStats = null;
        return;
    L11:
        this.mCurBroadcastStats.dumpCheckinStats(pw, dumpPackage);
        if (fullCheckin == false) goto L15;
        this.mCurBroadcastStats = null;
        return;
    }

    void writeBroadcastsToProtoLocked(ProtoOutputStream proto) {
        if (this.mRegisteredReceivers.size() <= 0) goto L8;
        Iterator<ReceiverList> r0 = this.mRegisteredReceivers.values().iterator();
    L6:
        if (r0.hasNext() == false) goto L8;
        ReceiverList r = r0.next();
        r.dumpDebug(proto, 2246267895809L);
    L8:
        this.mReceiverResolver.dumpDebug(proto, 1146756268034L);
        this.mBroadcastQueue.dumpDebug(proto, 2246267895811L);
        SparseArray<ArrayMap<String, ArrayList<StickyBroadcast>>> r12 = this.mStickyBroadcasts;
        monitor-enter(r12);
        int user = 0;
    L30:
        long r13 = 1138166333441L;
        if (user >= this.mStickyBroadcasts.size()) goto L25;
        long token = proto.start(2246267895812L);     // Catch: Throwable -> L20
        proto.write(1120986464257L, this.mStickyBroadcasts.keyAt(user));     // Catch: Throwable -> L20
        Iterator<Map.Entry<String, ArrayList<StickyBroadcast>>> r15 = this.mStickyBroadcasts.valueAt(user).entrySet().iterator();     // Catch: Throwable -> L20
    L15:
        if (r15.hasNext() == false) goto L23;
        Map.Entry<String, ArrayList<StickyBroadcast>> ent = r15.next();     // Catch: Throwable -> L20
        long actionToken = proto.start(2246267895810L);     // Catch: Throwable -> L20
        proto.write(r13, ent.getKey());     // Catch: Throwable -> L20
        Iterator<StickyBroadcast> r17 = ent.getValue().iterator();     // Catch: Throwable -> L20
    L18:
        if (r17.hasNext() == false) goto L22;
        StickyBroadcast broadcast = r17.next();     // Catch: Throwable -> L20
        broadcast.intent.dumpDebug(proto, 2246267895810L, false, true, true, false);     // Catch: Throwable -> L20
        token = token;
        actionToken = actionToken;
        goto L18
    L22:
        proto.end(actionToken);     // Catch: Throwable -> L20
        token = token;
        r13 = 1138166333441L;
        goto L15
    L23:
        proto.end(token);     // Catch: Throwable -> L20
        user = user + 1;     // Catch: Throwable -> L20
        goto L30
    L25:
        monitor-exit(r12);     // Catch: Throwable -> L20
        long handlerToken = proto.start(1146756268037L);
        proto.write(1138166333441L, this.mService.mHandler.toString());
        this.mService.mHandler.getLooper().dumpDebug(proto, 1146756268034L);
        proto.end(handlerToken);
        return;
    L20:
        th = move-exception;
        throw th;
    }
}
