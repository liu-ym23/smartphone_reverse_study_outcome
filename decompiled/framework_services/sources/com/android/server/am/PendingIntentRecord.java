package com.android.server.am;

import android.app.ActivityManagerInternal;
import android.app.ActivityOptions;
import android.app.BackgroundStartPrivileges;
import android.app.BroadcastOptions;
import android.app.IApplicationThread;
import android.app.compat.CompatChanges;
import android.content.IIntentReceiver;
import android.content.IIntentSender;
import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.PowerWhitelistManager;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.TransactionTooLargeException;
import android.os.UserHandle;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.Slog;
import android.util.TimeUtils;
import com.android.internal.os.IResultReceiver;
import com.android.internal.util.function.pooled.PooledLambda;
import com.android.modules.expresslog.Counter;
import com.android.server.SysOptBridge;
import com.android.server.slice.SliceClientPermissions;
import com.android.server.wm.IExtTask;
import com.android.server.wm.SafeActivityOptions;
import java.io.PrintWriter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class PendingIntentRecord extends IIntentSender.Stub {
    public static final int CANCEL_REASON_HOSTING_ACTIVITY_DESTROYED = 16;
    public static final int CANCEL_REASON_NULL = 0;
    public static final int CANCEL_REASON_ONE_SHOT_SENT = 64;
    public static final int CANCEL_REASON_OWNER_CANCELED = 8;
    public static final int CANCEL_REASON_OWNER_FORCE_STOPPED = 4;
    public static final int CANCEL_REASON_OWNER_UNINSTALLED = 2;
    public static final int CANCEL_REASON_SUPERSEDED = 32;
    public static final int CANCEL_REASON_USER_STOPPED = 1;
    private static final long DEFAULT_RESCIND_BAL_PRIVILEGES_FROM_PENDING_INTENT_SENDER = 244637991;
    public static final int FLAG_ACTIVITY_SENDER = 1;
    public static final int FLAG_BROADCAST_SENDER = 2;
    public static final int FLAG_SERVICE_SENDER = 4;
    private static final String TAG = "ActivityManager";
    int cancelReason;
    boolean canceled;
    final PendingIntentController controller;
    final Key key;
    String lastTag;
    String lastTagPrefix;
    private ArraySet<IBinder> mAllowBgActivityStartsForActivitySender;
    private ArraySet<IBinder> mAllowBgActivityStartsForBroadcastSender;
    private ArraySet<IBinder> mAllowBgActivityStartsForServiceSender;
    private ArrayMap<IBinder, TempAllowListDuration> mAllowlistDuration;
    private RemoteCallbackList<IResultReceiver> mCancelCallbacks;
    public final WeakReference<PendingIntentRecord> ref;
    boolean sent;
    String stringName;
    final int uid;

    @Retention(RetentionPolicy.SOURCE)
    public @interface CancellationReason {
    }

    static final class Key {
        private static final int ODD_PRIME_NUMBER = 37;
        final IBinder activity;
        Intent[] allIntents;
        String[] allResolvedTypes;
        final String featureId;
        final int flags;
        final int hashCode;
        final SafeActivityOptions options;
        final String packageName;
        final int requestCode;
        final Intent requestIntent;
        final String requestResolvedType;
        final int type;
        final int userId;
        final String who;

        Key(int _t, String _p, String _featureId, IBinder _a, String _w, int _r, Intent[] _i, String[] _it, int _f, SafeActivityOptions _o, int _userId) {
            this.type = _t;
            this.packageName = _p;
            this.featureId = _featureId;
            this.activity = _a;
            this.who = _w;
            this.requestCode = _r;
            String r0 = null;
            if (_i == null) goto L5;
            Intent r1 = _i[_i.length - 1];
        L6:
            this.requestIntent = r1;
            if (_it == null) goto L9;
            r0 = _it[_it.length - 1];
        L9:
            this.requestResolvedType = r0;
            this.allIntents = _i;
            this.allResolvedTypes = _it;
            this.flags = _f;
            this.options = _o;
            this.userId = _userId;
            int hash = (((((23 * 37) + _f) * 37) + _r) * 37) + _userId;
            if (_w == null) goto L12;
            hash = (hash * 37) + _w.hashCode();
        L12:
            if (_a == null) goto L15;
            hash = (hash * 37) + _a.hashCode();
        L15:
            if (this.requestIntent == null) goto L18;
            hash = (hash * 37) + this.requestIntent.filterHashCode();
        L18:
            if (this.requestResolvedType == null) goto L20;
            hash = (hash * 37) + this.requestResolvedType.hashCode();
        L20:
            int r2 = hash * 37;
            if (_p == null) goto L23;
            int r3 = _p.hashCode();
        L24:
            this.hashCode = ((r2 + r3) * 37) + _t;
            return;
        L23:
            r3 = 0;
            goto L24
        L5:
            r1 = null;
            goto L6
        }

        public boolean equals(Object otherObj) {
            if (otherObj != null) goto L48;
            return false;
        L48:
            Key other = (Key) otherObj;     // Catch: ClassCastException -> L33
            if (this.type == other.type) goto L9;
            return false;
        L9:
            if (this.userId == other.userId) goto L12;
            return false;
        L12:
            if (Objects.equals(this.packageName, other.packageName) == true) goto L15;
            return false;
        L15:
            if (Objects.equals(this.featureId, other.featureId) == true) goto L18;
            return false;
        L18:
            if (this.activity == other.activity) goto L21;
            return false;
        L21:
            if (Objects.equals(this.who, other.who) == true) goto L24;
            return false;
        L24:
            if (this.requestCode == other.requestCode) goto L27;
            return false;
        L27:
            if (this.requestIntent == other.requestIntent) goto L39;
            if (this.requestIntent == null) goto L36;
            if (this.requestIntent.filterEquals(other.requestIntent) == true) goto L39;
            return false;
        L36:
            if (other.requestIntent == null) goto L39;
            return false;
        L39:
            if (Objects.equals(this.requestResolvedType, other.requestResolvedType) == true) goto L41;
            return false;
        L41:
            if (this.flags == other.flags) goto L44;
            return false;
        L44:
            return true;
        L47:
            return false;
        }

        public int hashCode() {
            return this.hashCode;
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder();
            r0.append("Key{");
            r0.append(typeName());
            r0.append(" pkg=");
            r0.append(this.packageName);
            if (this.featureId == null) goto L5;
            String r1 = SliceClientPermissions.SliceAuthority.DELIMITER + this.featureId;
        L6:
            r0.append(r1);
            r0.append(" intent=");
            if (this.requestIntent == null) goto L9;
            String r2 = this.requestIntent.toShortString(false, true, false, false);
        L10:
            r0.append(r2);
            r0.append(" flags=0x");
            r0.append(Integer.toHexString(this.flags));
            r0.append(" u=");
            r0.append(this.userId);
            r0.append("} requestCode=");
            r0.append(this.requestCode);
            return r0.toString();
        L9:
            r2 = "<null>";
            goto L10
        L5:
            r1 = "";
            goto L6
        }

        String typeName() {
            switch(this.type) {
                case 1: goto L14;
                case 2: goto L12;
                case 3: goto L10;
                case 4: goto L8;
                case 5: goto L6;
                default: goto L5;
            };
        L6:
            return "startForegroundService";
        L8:
            return "startService";
        L10:
            return "activityResult";
        L12:
            return "startActivity";
        L14:
            return "broadcastIntent";
        L5:
            return Integer.toString(this.type);
        }
    }

    static final class TempAllowListDuration {
        long duration;
        String reason;
        int reasonCode;
        int type;

        TempAllowListDuration(long _duration, int _type, int _reasonCode, String _reason) {
            this.duration = _duration;
            this.type = _type;
            this.reasonCode = _reasonCode;
            this.reason = _reason;
        }
    }

    public static /* synthetic */ void $r8$lambda$n7a96RwVvewtpifhQ2aQt1qSbXo(PendingIntentRecord r0) {
        r0.completeFinalize();
    }

    PendingIntentRecord(PendingIntentController _controller, Key _k, int _u) {
        this.sent = false;
        this.canceled = false;
        this.cancelReason = 0;
        this.mAllowBgActivityStartsForActivitySender = new ArraySet();
        this.mAllowBgActivityStartsForBroadcastSender = new ArraySet();
        this.mAllowBgActivityStartsForServiceSender = new ArraySet();
        this.controller = _controller;
        this.key = _k;
        this.uid = _u;
        this.ref = new WeakReference(this);
    }

    void setAllowlistDurationLocked(IBinder allowlistToken, long duration, int type, int reasonCode, String reason) {
        if (duration <= 0) goto L9;
        if (this.mAllowlistDuration != null) goto L7;
        this.mAllowlistDuration = new ArrayMap();
    L7:
        this.mAllowlistDuration.put(allowlistToken, new TempAllowListDuration(duration, type, reasonCode, reason));
    L13:
        this.stringName = null;
        return;
    L9:
        if (this.mAllowlistDuration == null) goto L13;
        this.mAllowlistDuration.remove(allowlistToken);
        if (this.mAllowlistDuration.size() > 0) goto L13;
        this.mAllowlistDuration = null;
        goto L13
    }

    TempAllowListDuration getAllowlistDurationLocked(IBinder allowlistToken) {
        return this.mAllowlistDuration.get(allowlistToken);
    }

    void setAllowBgActivityStarts(IBinder token, int flags) {
        if (token != null) goto L5;
        return;
    L5:
        if ((flags & 1) == 0) goto L8;
        this.mAllowBgActivityStartsForActivitySender.add(token);
    L8:
        if ((flags & 2) == 0) goto L11;
        this.mAllowBgActivityStartsForBroadcastSender.add(token);
    L11:
        if ((flags & 4) == 0) goto L14;
        this.mAllowBgActivityStartsForServiceSender.add(token);
        return;
    }

    void clearAllowBgActivityStarts(IBinder token) {
        if (token != null) goto L4;
        return;
    L4:
        this.mAllowBgActivityStartsForActivitySender.remove(token);
        this.mAllowBgActivityStartsForBroadcastSender.remove(token);
        this.mAllowBgActivityStartsForServiceSender.remove(token);
        if (this.mAllowlistDuration == null) goto L12;
        TempAllowListDuration duration = this.mAllowlistDuration.get(token);
        if (duration != null) goto L9;
        return;
    L9:
        if (duration.type != 0) goto L14;
        duration.type = 1;
        return;
    L14:
        return;
    }

    public void registerCancelListenerLocked(IResultReceiver receiver) {
        if (this.mCancelCallbacks != null) goto L5;
        this.mCancelCallbacks = new RemoteCallbackList();
    L5:
        this.mCancelCallbacks.register(receiver);
    }

    public void unregisterCancelListenerLocked(IResultReceiver receiver) {
        if (this.mCancelCallbacks != null) goto L5;
        return;
    L5:
        this.mCancelCallbacks.unregister(receiver);
        if (this.mCancelCallbacks.getRegisteredCallbackCount() > 0) goto L9;
        this.mCancelCallbacks = null;
        return;
    }

    public RemoteCallbackList<IResultReceiver> detachCancelListenersLocked() {
        RemoteCallbackList<IResultReceiver> listeners = this.mCancelCallbacks;
        this.mCancelCallbacks = null;
        return listeners;
    }

    public void send(int code, Intent intent, String resolvedType, IBinder allowlistToken, IIntentReceiver finishedReceiver, String requiredPermission, Bundle options) {
        sendInner(null, code, intent, resolvedType, allowlistToken, finishedReceiver, requiredPermission, null, null, 0, 0, 0, options);
    }

    public void send(IApplicationThread caller, int code, Intent intent, String resolvedType, IBinder allowlistToken, IIntentReceiver finishedReceiver, String requiredPermission, Bundle options) {
        sendInner(caller, code, intent, resolvedType, allowlistToken, finishedReceiver, requiredPermission, null, null, 0, 0, 0, options);
    }

    public int sendWithResult(IApplicationThread caller, int code, Intent intent, String resolvedType, IBinder allowlistToken, IIntentReceiver finishedReceiver, String requiredPermission, Bundle options) {
        return sendInner(caller, code, intent, resolvedType, allowlistToken, finishedReceiver, requiredPermission, null, null, 0, 0, 0, options);
    }

    public static BackgroundStartPrivileges getBackgroundStartPrivilegesAllowedByCaller(ActivityOptions activityOptions, int callingUid, String callingPackage) {
        if (activityOptions != null) goto L6;
        return getDefaultBackgroundStartPrivileges(callingUid, callingPackage);
    L6:
        return getBackgroundStartPrivilegesAllowedByCaller(activityOptions.toBundle(), callingUid, callingPackage);
    }

    private static BackgroundStartPrivileges getBackgroundStartPrivilegesAllowedByCaller(Bundle options, int callingUid, String callingPackage) {
        if (options != null) goto L6;
        return getDefaultBackgroundStartPrivileges(callingUid, callingPackage);
    L6:
        switch(options.getInt("android.pendingIntent.backgroundActivityAllowed", 0)) {
            case 0: goto L12;
            case 1: goto L8;
            case 2: goto L10;
            default: goto L8;
        };
    L8:
        return BackgroundStartPrivileges.ALLOW_BAL;
    L10:
        return BackgroundStartPrivileges.NONE;
    L12:
        return getDefaultBackgroundStartPrivileges(callingUid, callingPackage);
    }

    public static BackgroundStartPrivileges getDefaultBackgroundStartPrivileges(int callingUid, String callingPackage) {
        if (callingUid == 0) goto L17;
        if (callingUid == 1000) goto L17;
        if (callingPackage == null) goto L9;
        boolean isChangeEnabledForApp = CompatChanges.isChangeEnabled(DEFAULT_RESCIND_BAL_PRIVILEGES_FROM_PENDING_INTENT_SENDER, callingPackage, UserHandle.getUserHandleForUid(callingUid));
    L11:
        if (isChangeEnabledForApp == false) goto L15;
        return BackgroundStartPrivileges.ALLOW_FGS;
    L15:
        return BackgroundStartPrivileges.ALLOW_BAL;
    L9:
        isChangeEnabledForApp = CompatChanges.isChangeEnabled(DEFAULT_RESCIND_BAL_PRIVILEGES_FROM_PENDING_INTENT_SENDER, callingUid);
    L17:
        return BackgroundStartPrivileges.ALLOW_FGS;
    }

    public String getPackageName() {
        return this.key.packageName;
    }

    @Deprecated
    public int sendInner(int code, Intent intent, String resolvedType, IBinder allowlistToken, IIntentReceiver finishedReceiver, String requiredPermission, IBinder resultTo, String resultWho, int requestCode, int flagsMask, int flagsValues, Bundle options) {
        return sendInner(null, code, intent, resolvedType, allowlistToken, finishedReceiver, requiredPermission, resultTo, resultWho, requestCode, flagsMask, flagsValues, options);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v38 */
    /* JADX WARN: Type inference failed for: r8v20 */
    /* JADX WARN: Type inference failed for: r8v49 */
    /* JADX WARN: Type inference failed for: r8v55 */
    public int sendInner(IApplicationThread r38, int r39, Intent r40, String r41, IBinder r42, IIntentReceiver r43, String r44, IBinder r45, String r46, int r47, int r48, int r49, Bundle r50) {
        int r4 = Binder.getCallingUid();
        int r3 = Binder.getCallingPid();
        if (r40 == null) goto L5;
        r40.setDefusable(true);
    L5:
        if (r50 == null) goto L7;
        r50.setDefusable(true);
    L7:
        Object r9 = this.controller.mLock;
        monitor-enter(r9);
    L320:
        th = th;
    L335:
        monitor-exit(r9);     // Catch: Throwable -> L324
        throw th;
    L324:
        th = th;
        goto L335
    L344:
        if (this.canceled == true) goto L13;
        this.sent = true;     // Catch: Throwable -> L320
        if ((this.key.flags & 1073741824) == 0) goto L26;
        this.controller.cancelIntentSender(this, true, 64);     // Catch: Throwable -> L17
    L26:
        if (this.key.requestIntent == null) goto L29;
        Intent r10 = new Intent(this.key.requestIntent);     // Catch: Throwable -> L17
    L30:
        Intent r11 = r10;
        if ((this.key.flags & 67108864) == 0) goto L35;
        boolean r5 = true;
    L36:
        if (r5 == true) goto L370;
        if (r40 != null) goto L380;
        String r13 = this.key.requestResolvedType;     // Catch: Throwable -> L53
    L48:
        int r12 = r48 & (-196);
        r11.setFlags((r11.getFlags() & (~r12)) | (r49 & r12));     // Catch: Throwable -> L51
        String r21 = r13;
    L368:
        ActivityOptions r0 = ActivityOptions.fromBundle(r50);     // Catch: Throwable -> L314
        if (r0 != null) goto L351;
        TempAllowListDuration r20 = null;
        Intent[] r2 = null;
    L364:
        SafeActivityOptions r6 = this.key.options;     // Catch: Throwable -> L312
        if (r6 == null) goto L86;
        r6.setCallerOptions(r0, r3, r4);     // Catch: Throwable -> L312
        SafeActivityOptions r29 = r6;
    L361:
        if (this.mAllowlistDuration != null) goto L374;
        TempAllowListDuration r7 = r20;
    L355:
        if (this.key.type == 2) goto L366;
    L114:
        Intent[] r14 = r2;
        String[] r30 = null;
    L342:
        monitor-exit(r9);     // Catch: Throwable -> L306
        int r8 = 1;
        r8 = 1;
        r8 = 1;
        if (this.key.type != 1) goto L119;
        this.controller.mAmInternal.enforceBroadcastOptionsPermissions(r50, r4);
    L119:
        long r31 = Binder.clearCallingIdentity();
        if (r7 != null) goto L330;
        int r1 = 5;
    L302:
        th = th;
    L304:
        Binder.restoreCallingIdentity(r31);
        throw th;
    L149:
        if (this.key.type != 5) goto L155;
        if (r50 == null) goto L155;
        BroadcastOptions r15 = new BroadcastOptions(r50);     // Catch: Throwable -> L143
        if (r15.getTemporaryAppAllowlistDuration() <= 0) goto L155;
        ActivityManagerInternal r16 = this.controller.mAmInternal;     // Catch: Throwable -> L143
        int r17 = this.uid;     // Catch: Throwable -> L143
        long r18 = r15.getTemporaryAppAllowlistDuration();     // Catch: Throwable -> L143
        int r19 = r15.getTemporaryAppAllowlistType();     // Catch: Throwable -> L143
        r16.tempAllowlistForPendingIntent(r3, r4, r17, r18, r19, r15.getTemporaryAppAllowlistReasonCode(), r15.getTemporaryAppAllowlistReason());     // Catch: Throwable -> L143
        r8 = r19;
    L155:
        if (r43 == null) goto L157;
        boolean r110 = true;
    L158:
        boolean r36 = r110;
        if (r43 == null) goto L162;
        if (r38 != null) goto L162;
        Slog.w(TAG, "Sending of " + r40 + " from " + Binder.getCallingUid() + " requested resultTo without an IApplicationThread!", new Throwable());     // Catch: Throwable -> L143
    L162:
        int r22 = this.key.userId;     // Catch: Throwable -> L302
        if (r22 == (-2)) goto L166;
        int r111 = r22;
    L168:
        ?? r23 = r8;
        if ("obric.home.flow".equals(this.controller.mAmInternal.getPackageNameByPid(r3)) == false) goto L171;
        r23 = 1;
        r11.getSmtEx().putSmtExtra(IExtTask.EXTRA_FROM_SHORTCUT, true);     // Catch: Throwable -> L143
    L171:
        switch(this.key.type) {
            case 1: goto L261;
            case 2: goto L209;
            case 3: goto L359;
            case 4: goto L402;
            case 5: goto L402;
            default: goto L173;
        };
    L173:
        Intent r24 = r11;
        PendingIntentRecord r25 = this;
    L289:
        int r112 = 0;
    L290:
        if (r36 == true) goto L292;
    L298:
        Binder.restoreCallingIdentity(r31);
        return r112;
    L292:
        if (r112 == (-96)) goto L298;
        r43.performReceive(new Intent(r24), 0, null, null, false, false, r25.key.userId);     // Catch: Throwable -> L295 RemoteException -> L297
    L295:
        th = th;
        goto L304
    L209:
        int r26 = r111;
        String r113 = r21;
        if (this.key.allIntents == null) goto L382;
    L224:
        e = e;
        PendingIntentRecord r27 = this;
        Intent r28 = r11;
    L257:
        Slog.w(TAG, "Unable to send startActivity intent", e);     // Catch: Throwable -> L259
        r25 = r27;
        r24 = r28;
    L222:
        th = th;
        goto L304
    L213:
        if (this.key.allIntents.length <= 1) goto L382;
    L388:
        PendingIntentRecord r32 = this;
        r28 = r11;
        int r33 = this.controller.mAtmInternal.startActivitiesInPackage(this.uid, r3, r4, this.key.packageName, this.key.featureId, r14, r30, r45, r29, r26, false, this, getBackgroundStartPrivilegesForActivitySender(r42).allowsBackgroundActivityStarts());     // Catch: Throwable -> L218 RuntimeException -> L220
    L235:
        r25 = r32;
        r24 = r28;
        r112 = r33;
        goto L290
    L220:
        e = e;
        r27 = this;
        r28 = r11;
    L218:
        th = th;
    L382:
    L386:
    L400:
        r28 = r11;
        r32 = this;
        r33 = this.controller.mAtmInternal.startActivityInPackage(this.uid, r3, r4, this.key.packageName, this.key.featureId, r28, r113, r45, r46, r47, 0, r29, r26, null, "PendingIntentRecord", false, this, getBackgroundStartPrivilegesForActivitySender(r42).allowsBackgroundActivityStarts());     // Catch: Throwable -> L236 RuntimeException -> L238
        goto L235
    L238:
        e = e;
        r27 = this;
    L236:
        th = th;
        goto L304
    L242:
        e = e;
        r27 = this;
        r28 = r11;
    L240:
        th = th;
    L246:
        e = e;
        r27 = this;
        r28 = r11;
    L244:
        th = th;
    L250:
        e = e;
        r27 = this;
        r28 = r11;
    L248:
        th = th;
        goto L304
    L254:
        e = e;
        r27 = this;
        r28 = r11;
    L252:
        th = th;
        goto L304
    L261:
        r24 = r11;
        int r210 = r111;
    L285:
        e = e;
        r25 = this;
    L337:
        Slog.w(TAG, "Unable to send startActivity intent", e);     // Catch: Throwable -> L300
    L300:
        th = th;
    L283:
        th = th;
        goto L304
    L263:
        if (SysOptBridge.getFactory().getSmartService().isFromSystemUi(r4) == true) goto L326;
        boolean r34 = true;
    L269:
        BackgroundStartPrivileges r211 = getBackgroundStartPrivilegesForActivitySender(this.mAllowBgActivityStartsForBroadcastSender, r42, r50, r4);     // Catch: Throwable -> L283 RuntimeException -> L285
        Bundle r114 = createSafeActivityOptionsBundle(r50);     // Catch: Throwable -> L283 RuntimeException -> L285
        ActivityManagerInternal r35 = this.controller.mAmInternal;     // Catch: Throwable -> L283 RuntimeException -> L285
        String r37 = this.key.packageName;     // Catch: Throwable -> L283 RuntimeException -> L285
        String r51 = this.key.featureId;     // Catch: Throwable -> L283 RuntimeException -> L285
        int r52 = this.uid;     // Catch: Throwable -> L283 RuntimeException -> L285
        if (r43 == null) goto L272;
        boolean r115 = r34;
    L273:
        r25 = this;
        int r53 = r35.broadcastIntentInPackage(r37, r51, r52, r4, r3, r24, r21, r38, r43, r39, null, r114, r44, r50, r115, false, r210, r211, null);     // Catch: Throwable -> L279 RuntimeException -> L281
        r24 = r24;
        if (r53 != 0) goto L278;
        r36 = false;
    L278:
        r112 = 0;
        goto L290
    L281:
        e = e;
    L279:
        th = th;
        goto L304
    L272:
        r115 = false;
        goto L273
    L326:
        r34 = true;
        r24.getSmtEx().putSmtExtra("from_system_ui", true);     // Catch: Throwable -> L259 RuntimeException -> L266
    L266:
        e = e;
        r25 = this;
        goto L337
    L402:
        BackgroundStartPrivileges r212 = getBackgroundStartPrivilegesForActivitySender(this.mAllowBgActivityStartsForServiceSender, r42, r50, r4);     // Catch: Throwable -> L188 TransactionTooLargeException -> L190 RuntimeException -> L192
        ActivityManagerInternal r54 = this.controller.mAmInternal;     // Catch: Throwable -> L188 TransactionTooLargeException -> L190 RuntimeException -> L192
        int r55 = this.uid;     // Catch: Throwable -> L188 TransactionTooLargeException -> L190 RuntimeException -> L192
        if (this.key.type != r1) goto L177;
        boolean r213 = true;
    L178:
        goto L191
    L394:
        r54.startServiceInPackage(r55, r11, r21, r213, this.key.packageName, this.key.featureId, r111, r212);     // Catch: Throwable -> L182 TransactionTooLargeException -> L184 RuntimeException -> L186
        r24 = r11;
        r25 = this;
        goto L289
    L186:
        e = e;
        Intent r56 = r11;
    L372:
        Slog.w(TAG, "Unable to send startService intent", e);     // Catch: Throwable -> L198
        r24 = r56;
        r25 = this;
    L198:
        th = th;
    L182:
        th = th;
    L185:
        Intent r57 = r11;
    L194:
        r24 = r57;
        r25 = this;
        r112 = -96;
        goto L290
    L177:
        r213 = false;
    L192:
        e = e;
        r56 = r11;
    L188:
        th = th;
    L191:
        r57 = r11;
        goto L194
    L359:
        this.controller.mAtmInternal.sendActivityResult(-1, this.key.activity, this.key.who, this.key.requestCode, r39, r11);     // Catch: Throwable -> L205
        r25 = this;
        r24 = r11;
    L205:
        th = th;
    L207:
        th = th;
    L259:
        th = th;
        goto L304
    L166:
        r111 = this.controller.mUserController.getCurrentOrTargetUserId();     // Catch: Throwable -> L143
        goto L168
    L157:
        r110 = false;
        goto L158
    L330:
        StringBuilder r58 = new StringBuilder(64);     // Catch: Throwable -> L145
        r58.append("setPendingIntentAllowlistDuration,reason:");     // Catch: Throwable -> L145
        if (r7.reason != null) goto L127;
        String r59 = "";
    L128:
        r58.append(r59);     // Catch: Throwable -> L145
        r58.append(",pendingintent:");     // Catch: Throwable -> L145
        UserHandle.formatUid(r58, r4);     // Catch: Throwable -> L145
        r58.append(":");     // Catch: Throwable -> L145
        if (r11.getAction() == null) goto L133;
        r58.append(r11.getAction());     // Catch: Throwable -> L125
    L332:
    L139:
        ActivityManagerInternal r60 = this.controller.mAmInternal;     // Catch: Throwable -> L145
        int r61 = this.uid;     // Catch: Throwable -> L145
        long r62 = r7.duration;     // Catch: Throwable -> L145
        int r63 = r7.type;     // Catch: Throwable -> L145
        r1 = 5;
        r60.tempAllowlistForPendingIntent(r3, r4, r61, r62, r63, r7.reasonCode, r58.toString());     // Catch: Throwable -> L143
        r8 = r63;
        goto L155
    L133:
        if (r11.getComponent() == null) goto L137;
        r11.getComponent().appendShortString(r58);     // Catch: Throwable -> L125
        goto L332
    L137:
        if (r11.getData() == null) goto L139;
        r58.append(r11.getData().toSafeString());     // Catch: Throwable -> L125
    L125:
        th = th;
        goto L304
    L127:
        r59 = r7.reason;     // Catch: Throwable -> L145
    L145:
        th = th;
    L143:
        th = th;
    L306:
        th = th;
        goto L335
    L366:
    L112:
        th = th;
        goto L335
    L100:
        if (this.key.allIntents == null) goto L114;
        if (this.key.allIntents.length <= 1) goto L114;
        Intent[] r64 = new Intent[this.key.allIntents.length];     // Catch: Throwable -> L112
        String[] r65 = new String[this.key.allIntents.length];     // Catch: Throwable -> L107
        System.arraycopy(this.key.allIntents, 0, r64, 0, this.key.allIntents.length);     // Catch: Throwable -> L107
        if (this.key.allResolvedTypes == null) goto L110;
        System.arraycopy(this.key.allResolvedTypes, 0, r65, 0, this.key.allResolvedTypes.length);     // Catch: Throwable -> L107
    L110:
        r64[r64.length - 1] = r11;     // Catch: Throwable -> L107
        r65[r65.length - 1] = r21;     // Catch: Throwable -> L107
        r14 = r64;
        r30 = r65;
    L107:
        th = th;
    L308:
        th = th;
        goto L335
    L374:
        r7 = this.mAllowlistDuration.get(r42);     // Catch: Throwable -> L93
    L93:
        th = th;
    L310:
        th = th;
        goto L335
    L86:
        r29 = new SafeActivityOptions(r0, r3, r4);     // Catch: Throwable -> L70
    L312:
        th = th;
        goto L335
    L351:
    L76:
        th = th;
        goto L335
    L62:
        if (r0.getPendingIntentCreatorBackgroundActivityStartMode() == 0) goto L78;
        StringBuilder r116 = new StringBuilder();     // Catch: Throwable -> L76
        r20 = null;
        r116.append("Resetting option setPendingIntentCreatorBackgroundActivityStartMode(");     // Catch: Throwable -> L74
        r116.append(r0.getPendingIntentCreatorBackgroundActivityStartMode());     // Catch: Throwable -> L74
        r116.append(") to SYSTEM_DEFINED from the options provided by the pending intent sender (");     // Catch: Throwable -> L74
        r116.append(this.key.packageName);     // Catch: Throwable -> L74
        r116.append(") because this option is meant for the pending intent creator");     // Catch: Throwable -> L74
        Slog.wtf(TAG, r116.toString());     // Catch: Throwable -> L74
        r2 = null;
    L70:
        th = th;
        goto L335
    L68:
        if (CompatChanges.isChangeEnabled(320664730, r4) == true) goto L73;
        r0.setPendingIntentCreatorBackgroundActivityStartMode(0);     // Catch: Throwable -> L70
    L79:
        r11.addFlags(r0.getPendingIntentLaunchFlags());     // Catch: Throwable -> L70
        goto L364
    L73:
        throw new IllegalArgumentException("pendingIntentCreatorBackgroundActivityStartMode must not be set when sending a PendingIntent");     // Catch: Throwable -> L70
    L74:
        th = th;
        goto L335
    L78:
        r20 = null;
        r2 = null;
    L314:
        th = th;
    L51:
        th = th;
    L53:
        th = th;
        goto L335
    L380:
    L42:
        th = th;
        goto L335
    L39:
        if ((r11.fillIn(r40, this.key.flags) & 2) != 0) goto L44;
        r13 = this.key.requestResolvedType;     // Catch: Throwable -> L42
        goto L48
    L44:
        r13 = r41;
        goto L48
    L370:
        r21 = this.key.requestResolvedType;     // Catch: Throwable -> L316
    L316:
        th = th;
        goto L335
    L35:
        r5 = false;
    L318:
        th = th;
        goto L335
    L29:
        r10 = new Intent();     // Catch: Throwable -> L320
        goto L30
    L13:
        if (this.cancelReason == 4) goto L15;
    L19:
        monitor-exit(r9);     // Catch: Throwable -> L17
        return -96;
    L15:
        if (this.controller.mAmInternal.getUidProcessState(r4) != 2) goto L19;
        Counter.logIncrementWithUid("app.value_force_stop_cancelled_pi_sent_from_top_per_caller", r4);     // Catch: Throwable -> L17
        Counter.logIncrementWithUid("app.value_force_stop_cancelled_pi_sent_from_top_per_owner", this.uid);     // Catch: Throwable -> L17
    L17:
        th = th;
        goto L335
    }

    private Bundle createSafeActivityOptionsBundle(Bundle optionsBundle) {
        return null;
    }

    BackgroundStartPrivileges getBackgroundStartPrivilegesForActivitySender(IBinder allowlistToken) {
        if (this.mAllowBgActivityStartsForActivitySender.contains(allowlistToken) == false) goto L6;
        return BackgroundStartPrivileges.allowBackgroundActivityStarts(allowlistToken);
    L6:
        return BackgroundStartPrivileges.NONE;
    }

    private BackgroundStartPrivileges getBackgroundStartPrivilegesForActivitySender(ArraySet<IBinder> allowedTokenSet, IBinder allowlistToken, Bundle options, int callingUid) {
        if (allowedTokenSet.contains(allowlistToken) == false) goto L7;
        return BackgroundStartPrivileges.allowBackgroundActivityStarts(allowlistToken);
    L7:
        if (this.uid == callingUid) goto L13;
        if (this.controller.mAtmInternal.isUidForeground(callingUid) == false) goto L13;
        return getBackgroundStartPrivilegesAllowedByCaller(options, callingUid, null);
    L13:
        return BackgroundStartPrivileges.NONE;
    }

    protected void finalize() throws Throwable {
    L6:
        th = move-exception;
        super/*java.lang.Object*/.finalize();
        throw th;
    L3:
        if (this.canceled == true) goto L8;
        this.controller.mH.sendMessage(PooledLambda.obtainMessage(new PendingIntentRecord$$ExternalSyntheticLambda0(), this));     // Catch: Throwable -> L6
    L8:
        super/*java.lang.Object*/.finalize();
    }

    private void completeFinalize() {
        Object r0 = this.controller.mLock;
        monitor-enter(r0);
        WeakReference<PendingIntentRecord> current = this.controller.mIntentSenderRecords.get(this.key);     // Catch: Throwable -> L7
        if (current != this.ref) goto L9;
        this.controller.mIntentSenderRecords.remove(this.key);     // Catch: Throwable -> L7
        this.controller.decrementUidStatLocked(this);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    static String cancelReasonToString(int cancelReason) {
        switch(cancelReason) {
            case 0: goto L11;
            case 1: goto L10;
            case 2: goto L9;
            case 4: goto L8;
            case 8: goto L7;
            case 16: goto L6;
            case 32: goto L5;
            case 64: goto L4;
            default: goto L3;
        };
    L3:
        return "UNKNOWN";
    L4:
        return "ONE_SHOT_SENT";
    L5:
        return "SUPERSEDED";
    L6:
        return "HOSTING_ACTIVITY_DESTROYED";
    L7:
        return "OWNER_CANCELED";
    L8:
        return "OWNER_FORCE_STOPPED";
    L9:
        return "OWNER_UNINSTALLED";
    L10:
        return "USER_STOPPED";
    L11:
        return "NULL";
    }

    public void dump(PrintWriter pw, String prefix) {
        pw.print(prefix);
        pw.print("uid=");
        pw.print(this.uid);
        pw.print(" packageName=");
        pw.print(this.key.packageName);
        pw.print(" featureId=");
        pw.print(this.key.featureId);
        pw.print(" type=");
        pw.print(this.key.typeName());
        pw.print(" flags=0x");
        pw.println(Integer.toHexString(this.key.flags));
        if (this.key.activity == null) goto L5;
    L6:
        pw.print(prefix);
        pw.print("activity=");
        pw.print(this.key.activity);
        pw.print(" who=");
        pw.println(this.key.who);
    L8:
        if (this.key.requestCode == 0) goto L10;
    L11:
        pw.print(prefix);
        pw.print("requestCode=");
        pw.print(this.key.requestCode);
        pw.print(" requestResolvedType=");
        pw.println(this.key.requestResolvedType);
    L13:
        if (this.key.requestIntent == null) goto L16;
        pw.print(prefix);
        pw.print("requestIntent=");
        pw.println(this.key.requestIntent.toShortString(false, true, true, false));
    L16:
        if (this.sent == false) goto L18;
    L19:
        pw.print(prefix);
        pw.print("sent=");
        pw.print(this.sent);
        pw.print(" canceled=");
        pw.print(this.canceled);
        pw.print(" cancelReason=");
        pw.println(cancelReasonToString(this.cancelReason));
    L21:
        if (this.mAllowlistDuration == null) goto L30;
        pw.print(prefix);
        pw.print("allowlistDuration=");
        int i = 0;
    L24:
        if (i >= this.mAllowlistDuration.size()) goto L28;
        if (i == 0) goto L27;
        pw.print(", ");
    L27:
        TempAllowListDuration entry = this.mAllowlistDuration.valueAt(i);
        pw.print(Integer.toHexString(System.identityHashCode(this.mAllowlistDuration.keyAt(i))));
        pw.print(":");
        TimeUtils.formatDuration(entry.duration, pw);
        pw.print(SliceClientPermissions.SliceAuthority.DELIMITER);
        pw.print(entry.type);
        pw.print(SliceClientPermissions.SliceAuthority.DELIMITER);
        pw.print(PowerWhitelistManager.reasonCodeToString(entry.reasonCode));
        pw.print(SliceClientPermissions.SliceAuthority.DELIMITER);
        pw.print(entry.reason);
        i = i + 1;
        goto L24
    L28:
        pw.println();
    L30:
        if (this.mCancelCallbacks == null) goto L35;
        pw.print(prefix);
        pw.println("mCancelCallbacks:");
        int i2 = 0;
    L33:
        if (i2 >= this.mCancelCallbacks.getRegisteredCallbackCount()) goto L40;
        pw.print(prefix);
        pw.print("  #");
        pw.print(i2);
        pw.print(": ");
        pw.println(this.mCancelCallbacks.getRegisteredCallbackItem(i2));
        i2 = i2 + 1;
        goto L33
    L40:
        return;
    L35:
        return;
    L18:
        if (this.canceled == false) goto L21;
    L10:
        if (this.key.requestResolvedType == null) goto L13;
    L5:
        if (this.key.who == null) goto L8;
        goto L6
    }

    public String toString() {
        if (this.stringName != null) goto L5;
        StringBuilder sb = new StringBuilder(128);
        sb.append("PendingIntentRecord{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(' ');
        sb.append(this.key.packageName);
        if (this.key.featureId == null) goto L9;
        sb.append('/');
        sb.append(this.key.featureId);
    L9:
        sb.append(' ');
        sb.append(this.key.typeName());
        if (this.mAllowlistDuration == null) goto L18;
        sb.append(" (allowlist: ");
        int i = 0;
    L13:
        if (i >= this.mAllowlistDuration.size()) goto L17;
        if (i == 0) goto L16;
        sb.append(",");
    L16:
        TempAllowListDuration entry = this.mAllowlistDuration.valueAt(i);
        sb.append(Integer.toHexString(System.identityHashCode(this.mAllowlistDuration.keyAt(i))));
        sb.append(":");
        TimeUtils.formatDuration(entry.duration, sb);
        sb.append(SliceClientPermissions.SliceAuthority.DELIMITER);
        sb.append(entry.type);
        sb.append(SliceClientPermissions.SliceAuthority.DELIMITER);
        sb.append(PowerWhitelistManager.reasonCodeToString(entry.reasonCode));
        sb.append(SliceClientPermissions.SliceAuthority.DELIMITER);
        sb.append(entry.reason);
        i = i + 1;
        goto L13
    L17:
        sb.append(")");
    L18:
        sb.append('}');
        String r1 = sb.toString();
        this.stringName = r1;
        return r1;
    L5:
        return this.stringName;
    }
}
