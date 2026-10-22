package com.android.server.am;

import android.app.BackgroundStartPrivileges;
import android.app.BroadcastOptions;
import android.content.ComponentName;
import android.content.IIntentReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.os.Binder;
import android.os.Bundle;
import android.os.SystemClock;
import android.os.UserHandle;
import android.util.ArrayMap;
import android.util.IntArray;
import android.util.PrintWriterPrinter;
import android.util.TimeUtils;
import android.util.proto.ProtoOutputStream;
import com.android.server.compat.PlatformCompat;
import dalvik.annotation.optimization.NeverCompile;
import java.io.PrintWriter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.function.BiFunction;

/* JADX INFO: loaded from: classes.dex */
final class BroadcastRecord extends Binder {
    static final int APP_RECEIVE = 1;
    static final int CALL_DONE_RECEIVE = 3;
    static final int CALL_IN_RECEIVE = 2;
    static boolean CORE_DEFER_UNTIL_ACTIVE = false;
    static final int DELIVERY_DEFERRED = 6;
    static final int DELIVERY_DELIVERED = 1;
    static final int DELIVERY_FAILURE = 5;
    static final int DELIVERY_PENDING = 0;
    static final int DELIVERY_SCHEDULED = 4;
    static final int DELIVERY_SKIPPED = 2;
    static final int DELIVERY_TIMEOUT = 3;
    static final List<Object> EMPTY_RECEIVERS = null;
    static final int IDLE = 0;
    static final long LIMIT_PRIORITY_SCOPE = 371307720;
    static final int WAITING_SERVICES = 4;
    final boolean alarm;
    int anrCount;
    final int appOp;
    int beyondCount;
    final int[] blockedUntilBeyondCount;
    final ProcessRecord callerApp;
    final String callerFeatureId;
    final boolean callerInstantApp;
    final boolean callerInstrumented;
    final String callerPackage;
    final int callerProcState;
    final int callingPid;
    final int callingUid;
    ProcessRecord curApp;
    ComponentName curComponent;
    BroadcastFilter curFilter;
    Bundle curFilteredExtras;
    ActivityInfo curReceiver;
    final boolean deferUntilActive;
    int deferredCount;
    final int[] delivery;
    final String[] deliveryReasons;
    long dispatchClockTime;
    long dispatchRealTime;
    long dispatchTime;
    long enqueueClockTime;
    long enqueueRealTime;
    long enqueueTime;
    final String[] excludedPackages;
    final String[] excludedPermissions;
    final BiFunction<Integer, Bundle, Bundle> filterExtrasForReceiver;
    long finishTime;
    final boolean initialSticky;
    final Intent intent;
    final boolean interactive;
    final BackgroundStartPrivileges mBackgroundStartPrivileges;
    private ArrayMap<String, BroadcastProcessedEventRecord> mBroadcastProcessedRecords;
    private String mCachedToShortString;
    private String mCachedToString;
    private ArrayMap<BroadcastRecord, Boolean> mMatchingRecordsCache;
    int manifestCount;
    int manifestSkipCount;
    int nextReceiver;
    final BroadcastOptions options;
    final boolean ordered;
    long originalEnqueueClockTime;
    final int originalStickyCallingUid;
    final boolean prioritized;
    final boolean pushMessage;
    final boolean pushMessageOverQuota;
    BroadcastQueue queue;
    long receiverTime;
    final List<Object> receivers;
    final String[] requiredPermissions;
    final String resolvedType;
    boolean resultAbort;
    int resultCode;
    String resultData;
    Bundle resultExtras;
    IIntentReceiver resultTo;
    ProcessRecord resultToApp;
    final long[] scheduledTime;
    final boolean shareIdentity;
    int state;
    final boolean sticky;
    final ComponentName targetComp;
    int terminalCount;
    final long[] terminalTime;
    final boolean timeoutExempt;
    final boolean urgent;
    final int userId;

    @Retention(RetentionPolicy.SOURCE)
    public @interface DeliveryState {
    }

    static {
        CORE_DEFER_UNTIL_ACTIVE = false;
        EMPTY_RECEIVERS = List.of();
    }

    static String deliveryStateToString(int deliveryState) {
        switch(deliveryState) {
            case 0: goto L17;
            case 1: goto L15;
            case 2: goto L13;
            case 3: goto L11;
            case 4: goto L9;
            case 5: goto L7;
            case 6: goto L5;
            default: goto L4;
        };
    L5:
        return "DEFERRED";
    L7:
        return "FAILURE";
    L9:
        return "SCHEDULED";
    L11:
        return "TIMEOUT";
    L13:
        return "SKIPPED";
    L15:
        return "DELIVERED";
    L17:
        return "PENDING";
    L4:
        return Integer.toString(deliveryState);
    }

    static boolean isDeliveryStateTerminal(int deliveryState) {
        switch(deliveryState) {
            case 1: goto L5;
            case 2: goto L5;
            case 3: goto L5;
            case 4: goto L3;
            case 5: goto L5;
            default: goto L3;
        };
    L3:
        return false;
    L5:
        return true;
    }

    static boolean isDeliveryStateBeyond(int deliveryState) {
        switch(deliveryState) {
            case 1: goto L5;
            case 2: goto L5;
            case 3: goto L5;
            case 4: goto L3;
            case 5: goto L5;
            case 6: goto L5;
            default: goto L3;
        };
    L3:
        return false;
    L5:
        return true;
    }

    boolean isAssumedDelivered(int index) {
        if ((this.receivers.get(index) instanceof BroadcastFilter) == true) goto L5;
    L9:
        return false;
    L5:
        if (this.ordered == true) goto L9;
        if (this.resultTo != null) goto L9;
        return true;
    }

    @NeverCompile
    void dump(PrintWriter pw, String prefix, SimpleDateFormat sdf) {
        long now = SystemClock.uptimeMillis();
        pw.print(prefix);
        pw.print(this);
        pw.print(" to user ");
        pw.println(this.userId);
        pw.print(prefix);
        pw.println(this.intent.toInsecureString());
        if (this.targetComp != null) goto L5;
    L7:
        Bundle bundle = this.intent.getExtras();
        if (bundle == null) goto L10;
        pw.print(prefix);
        pw.print("  extras: ");
        pw.println(bundle.toString());
    L10:
        pw.print(prefix);
        pw.print("caller=");
        pw.print(this.callerPackage);
        pw.print(" ");
        if (this.callerApp == null) goto L13;
        String r6 = this.callerApp.toShortString();
    L14:
        pw.print(r6);
        pw.print(" pid=");
        pw.print(this.callingPid);
        pw.print(" uid=");
        pw.println(this.callingUid);
        if (this.requiredPermissions == null) goto L19;
        if (this.requiredPermissions.length <= 0) goto L19;
    L20:
        pw.print(prefix);
        pw.print("requiredPermissions=");
        pw.print(Arrays.toString(this.requiredPermissions));
        pw.print("  appOp=");
        pw.println(this.appOp);
    L22:
        if (this.excludedPermissions == null) goto L27;
        if (this.excludedPermissions.length <= 0) goto L27;
        pw.print(prefix);
        pw.print("excludedPermissions=");
        pw.print(Arrays.toString(this.excludedPermissions));
    L27:
        if (this.excludedPackages == null) goto L32;
        if (this.excludedPackages.length <= 0) goto L32;
        pw.print(prefix);
        pw.print("excludedPackages=");
        pw.print(Arrays.toString(this.excludedPackages));
    L32:
        if (this.options == null) goto L34;
        pw.print(prefix);
        pw.print("options=");
        pw.println(this.options.toBundle());
    L34:
        pw.print(prefix);
        pw.print("enqueueClockTime=");
        pw.print(sdf.format(new Date(this.enqueueClockTime)));
        pw.print(" dispatchClockTime=");
        pw.print(sdf.format(new Date(this.dispatchClockTime)));
        long r10 = 0;
        if (this.originalEnqueueClockTime <= 0) goto L37;
        pw.print(" originalEnqueueClockTime=");
        pw.print(sdf.format(new Date(this.originalEnqueueClockTime)));
    L37:
        pw.println();
        pw.print(prefix);
        pw.print("dispatchTime=");
        TimeUtils.formatDuration(this.dispatchTime, now, pw);
        pw.print(" (");
        TimeUtils.formatDuration(this.dispatchTime - this.enqueueTime, pw);
        pw.print(" since enq)");
        if (this.finishTime == 0) goto L40;
        pw.print(" finishTime=");
        TimeUtils.formatDuration(this.finishTime, now, pw);
        pw.print(" (");
        TimeUtils.formatDuration(this.finishTime - this.dispatchTime, pw);
        pw.print(" since disp)");
    L41:
        pw.println("");
        if (this.anrCount == 0) goto L45;
        pw.print(prefix);
        pw.print("anrCount=");
        pw.println(this.anrCount);
    L45:
        if (this.resultTo == null) goto L47;
    L50:
        pw.print(prefix);
        pw.print("resultTo=");
        pw.print(this.resultTo);
        pw.print(" resultCode=");
        pw.print(this.resultCode);
        pw.print(" resultData=");
        pw.println(this.resultData);
    L52:
        if (this.resultExtras == null) goto L55;
        pw.print(prefix);
        pw.print("resultExtras=");
        pw.println(this.resultExtras);
    L55:
        if (this.resultAbort == false) goto L57;
    L62:
        pw.print(prefix);
        pw.print("resultAbort=");
        pw.print(this.resultAbort);
        pw.print(" ordered=");
        pw.print(this.ordered);
        pw.print(" sticky=");
        pw.print(this.sticky);
        pw.print(" initialSticky=");
        pw.print(this.initialSticky);
        pw.print(" originalStickyCallingUid=");
        pw.println(this.originalStickyCallingUid);
    L64:
        if (this.nextReceiver == 0) goto L67;
        pw.print(prefix);
        pw.print("nextReceiver=");
        pw.println(this.nextReceiver);
    L67:
        if (this.curFilter == null) goto L70;
        pw.print(prefix);
        pw.print("curFilter=");
        pw.println(this.curFilter);
    L70:
        if (this.curReceiver == null) goto L73;
        pw.print(prefix);
        pw.print("curReceiver=");
        pw.println(this.curReceiver);
    L73:
        if (this.curApp == null) goto L84;
        pw.print(prefix);
        pw.print("curApp=");
        pw.println(this.curApp);
        pw.print(prefix);
        pw.print("curComponent=");
        if (this.curComponent == null) goto L77;
        String r7 = this.curComponent.toShortString();
    L78:
        pw.println(r7);
        if (this.curReceiver == null) goto L84;
        if (this.curReceiver.applicationInfo == null) goto L84;
        pw.print(prefix);
        pw.print("curSourceDir=");
        pw.println(this.curReceiver.applicationInfo.sourceDir);
        goto L84
    L77:
        r7 = "--";
    L84:
        if (this.curFilteredExtras == null) goto L87;
        pw.print(" filtered extras: ");
        pw.println(this.curFilteredExtras);
    L87:
        if (this.state == 0) goto L96;
        String stateStr = " (?)";
        switch(this.state) {
            case 1: goto L94;
            case 2: goto L93;
            case 3: goto L92;
            case 4: goto L91;
            default: goto L95;
        };
    L91:
        stateStr = " (WAITING_SERVICES)";
        goto L95
    L92:
        stateStr = " (CALL_DONE_RECEIVE)";
        goto L95
    L93:
        stateStr = " (CALL_IN_RECEIVE)";
        goto L95
    L94:
        stateStr = " (APP_RECEIVE)";
    L95:
        pw.print(prefix);
        pw.print("state=");
        pw.print(this.state);
        pw.println(stateStr);
    L96:
        pw.print(prefix);
        pw.print("terminalCount=");
        pw.println(this.terminalCount);
        if (this.receivers == null) goto L99;
        int N = this.receivers.size();
    L100:
        String p2 = prefix + "  ";
        PrintWriterPrinter printer = new PrintWriterPrinter(pw);
        int i = 0;
    L101:
        if (i >= N) goto L121;
        Object o = this.receivers.get(i);
        pw.print(prefix);
        pw.print(deliveryStateToString(this.delivery[i]));
        pw.print(' ');
        long r16 = r10;
        if (this.scheduledTime[i] == r16) goto L107;
        pw.print("scheduled ");
        TimeUtils.formatDuration(this.scheduledTime[i] - this.enqueueTime, pw);
        pw.print(' ');
    L107:
        if (this.terminalTime[i] == r16) goto L109;
        pw.print("terminal ");
        TimeUtils.formatDuration(this.terminalTime[i] - this.scheduledTime[i], pw);
        pw.print(' ');
    L109:
        pw.print("(");
        pw.print(this.blockedUntilBeyondCount[i]);
        pw.print(") ");
        pw.print("#");
        pw.print(i);
        pw.print(": ");
        if ((o instanceof BroadcastFilter) == false) goto L112;
        pw.println(o);
        p2 = p2;
        ((BroadcastFilter) o).dumpBrief(pw, p2);
    L117:
        if (this.deliveryReasons[i] == null) goto L119;
        pw.print(p2);
        pw.print("reason: ");
        pw.println(this.deliveryReasons[i]);
    L119:
        i = i + 1;
        r10 = r16;
        goto L101
    L112:
        p2 = p2;
        if ((o instanceof ResolveInfo) == false) goto L115;
        pw.println("(manifest)");
        ((ResolveInfo) o).dump(printer, p2, 0);
        goto L117
    L115:
        pw.println(o);
        goto L117
    L121:
        return;
    L99:
        N = 0;
        goto L100
    L57:
        if (this.ordered == true) goto L62;
        if (this.sticky == true) goto L62;
        if (this.initialSticky == false) goto L64;
    L47:
        if (this.resultCode != (-1)) goto L50;
        if (this.resultData == null) goto L52;
    L40:
        pw.print(" receiverTime=");
        TimeUtils.formatDuration(this.receiverTime, now, pw);
    L19:
        if (this.appOp == (-1)) goto L22;
    L13:
        r6 = "null";
        goto L14
    L5:
        if (this.targetComp == this.intent.getComponent()) goto L7;
        pw.print(prefix);
        pw.print("  targetComp: ");
        pw.println(this.targetComp.toShortString());
        goto L7
    }

    BroadcastRecord(BroadcastQueue queue, Intent intent, ProcessRecord callerApp, String callerPackage, String callerFeatureId, int callingPid, int callingUid, boolean callerInstantApp, String resolvedType, String[] requiredPermissions, String[] excludedPermissions, String[] excludedPackages, int appOp, BroadcastOptions options, List receivers, ProcessRecord resultToApp, IIntentReceiver resultTo, int resultCode, String resultData, Bundle resultExtras, boolean serialized, boolean sticky, boolean initialSticky, int userId, BackgroundStartPrivileges backgroundStartPrivileges, boolean timeoutExempt, BiFunction<Integer, Bundle, Bundle> filterExtrasForReceiver, int callerAppProcessState, PlatformCompat platformCompat) {
        this(queue, intent, callerApp, callerPackage, callerFeatureId, callingPid, callingUid, callerInstantApp, resolvedType, requiredPermissions, excludedPermissions, excludedPackages, appOp, options, receivers, resultToApp, resultTo, resultCode, resultData, resultExtras, serialized, sticky, initialSticky, userId, -1, backgroundStartPrivileges, timeoutExempt, filterExtrasForReceiver, callerAppProcessState, platformCompat);
    }

    BroadcastRecord(BroadcastQueue _queue, Intent _intent, ProcessRecord _callerApp, String _callerPackage, String _callerFeatureId, int _callingPid, int _callingUid, boolean _callerInstantApp, String _resolvedType, String[] _requiredPermissions, String[] _excludedPermissions, String[] _excludedPackages, int _appOp, BroadcastOptions _options, List _receivers, ProcessRecord _resultToApp, IIntentReceiver _resultTo, int _resultCode, String _resultData, Bundle _resultExtras, boolean _serialized, boolean _sticky, boolean _initialSticky, int _userId, int originalStickyCallingUid, BackgroundStartPrivileges backgroundStartPrivileges, boolean timeoutExempt, BiFunction<Integer, Bundle, Bundle> filterExtrasForReceiver, int callerAppProcessState, PlatformCompat platformCompat) {
        this.mBroadcastProcessedRecords = new ArrayMap();
        if (_intent == null) goto L45;
        this.queue = _queue;
        _intent.getClass();
        this.intent = _intent;
        this.targetComp = _intent.getComponent();
        this.callerApp = _callerApp;
        this.callerPackage = _callerPackage;
        this.callerFeatureId = _callerFeatureId;
        this.callingPid = _callingPid;
        this.callingUid = _callingUid;
        this.callerProcState = callerAppProcessState;
        this.callerInstantApp = _callerInstantApp;
        this.callerInstrumented = isCallerInstrumented(_callerApp, _callingUid);
        this.resolvedType = _resolvedType;
        this.requiredPermissions = _requiredPermissions;
        this.excludedPermissions = _excludedPermissions;
        this.excludedPackages = _excludedPackages;
        this.appOp = _appOp;
        this.options = _options;
        if (_receivers == null) goto L7;
        List r2 = _receivers;
    L8:
        this.receivers = r2;
        if (_receivers == null) goto L11;
        int r3 = _receivers.size();
    L12:
        this.delivery = new int[r3];
        this.deliveryReasons = new String[this.delivery.length];
        this.urgent = calculateUrgent(_intent, _options);
        this.deferUntilActive = calculateDeferUntilActive(_callingUid, _options, _resultTo, _serialized, this.urgent);
        this.blockedUntilBeyondCount = calculateBlockedUntilBeyondCount(this.receivers, _serialized, platformCompat);
        this.scheduledTime = new long[this.delivery.length];
        this.terminalTime = new long[this.delivery.length];
        this.resultToApp = _resultToApp;
        this.resultTo = _resultTo;
        this.resultCode = _resultCode;
        this.resultData = _resultData;
        this.resultExtras = _resultExtras;
        this.ordered = _serialized;
        this.sticky = _sticky;
        this.initialSticky = _initialSticky;
        this.prioritized = isPrioritized(this.blockedUntilBeyondCount, _serialized);
        this.userId = _userId;
        this.nextReceiver = 0;
        this.state = 0;
        this.mBackgroundStartPrivileges = backgroundStartPrivileges;
        this.timeoutExempt = timeoutExempt;
        if (this.options != null) goto L15;
    L17:
        boolean r1 = false;
    L18:
        this.alarm = r1;
        if (this.options != null) goto L21;
    L23:
        boolean r4 = false;
    L24:
        this.pushMessage = r4;
        if (this.options != null) goto L27;
    L29:
        boolean r5 = false;
    L30:
        this.pushMessageOverQuota = r5;
        if (this.options != null) goto L33;
    L35:
        boolean r6 = false;
    L36:
        this.interactive = r6;
        if (this.options != null) goto L39;
    L41:
        boolean r7 = false;
    L42:
        this.shareIdentity = r7;
        this.filterExtrasForReceiver = filterExtrasForReceiver;
        this.originalStickyCallingUid = originalStickyCallingUid;
        SysMonitorSvcBridge.getFactory().getAnrMonitor().notifyObjectCreate(this);
        return;
    L39:
        if (this.options.isShareIdentityEnabled() == false) goto L41;
        r7 = true;
        goto L42
    L33:
        if (this.options.isInteractive() == false) goto L35;
        r6 = true;
        goto L36
    L27:
        if (this.options.isPushMessagingOverQuotaBroadcast() == false) goto L29;
        r5 = true;
        goto L30
    L21:
        if (this.options.isPushMessagingBroadcast() == false) goto L23;
        r4 = true;
        goto L24
    L15:
        if (this.options.isAlarmBroadcast() == false) goto L17;
        r1 = true;
        goto L18
    L11:
        r3 = 0;
        goto L12
    L7:
        r2 = EMPTY_RECEIVERS;
        goto L8
    L45:
        throw new NullPointerException("Can't construct with a null intent");
    }

    private BroadcastRecord(BroadcastRecord from, Intent newIntent) {
        this.mBroadcastProcessedRecords = new ArrayMap();
        newIntent.getClass();
        this.intent = newIntent;
        this.targetComp = newIntent.getComponent();
        this.callerApp = from.callerApp;
        this.callerPackage = from.callerPackage;
        this.callerFeatureId = from.callerFeatureId;
        this.callingPid = from.callingPid;
        this.callingUid = from.callingUid;
        this.callerProcState = from.callerProcState;
        this.callerInstantApp = from.callerInstantApp;
        this.callerInstrumented = from.callerInstrumented;
        this.ordered = from.ordered;
        this.sticky = from.sticky;
        this.initialSticky = from.initialSticky;
        this.prioritized = from.prioritized;
        this.userId = from.userId;
        this.resolvedType = from.resolvedType;
        this.requiredPermissions = from.requiredPermissions;
        this.excludedPermissions = from.excludedPermissions;
        this.excludedPackages = from.excludedPackages;
        this.appOp = from.appOp;
        this.options = from.options;
        this.receivers = from.receivers;
        this.delivery = from.delivery;
        this.deliveryReasons = from.deliveryReasons;
        this.deferUntilActive = from.deferUntilActive;
        this.blockedUntilBeyondCount = from.blockedUntilBeyondCount;
        this.scheduledTime = from.scheduledTime;
        this.terminalTime = from.terminalTime;
        this.resultToApp = from.resultToApp;
        this.resultTo = from.resultTo;
        this.enqueueTime = from.enqueueTime;
        this.enqueueRealTime = from.enqueueRealTime;
        this.enqueueClockTime = from.enqueueClockTime;
        this.dispatchTime = from.dispatchTime;
        this.dispatchRealTime = from.dispatchRealTime;
        this.dispatchClockTime = from.dispatchClockTime;
        this.receiverTime = from.receiverTime;
        this.finishTime = from.finishTime;
        this.resultCode = from.resultCode;
        this.resultData = from.resultData;
        this.resultExtras = from.resultExtras;
        this.resultAbort = from.resultAbort;
        this.nextReceiver = from.nextReceiver;
        this.state = from.state;
        this.anrCount = from.anrCount;
        this.manifestCount = from.manifestCount;
        this.manifestSkipCount = from.manifestSkipCount;
        this.queue = from.queue;
        this.mBackgroundStartPrivileges = from.mBackgroundStartPrivileges;
        this.timeoutExempt = from.timeoutExempt;
        this.alarm = from.alarm;
        this.pushMessage = from.pushMessage;
        this.pushMessageOverQuota = from.pushMessageOverQuota;
        this.interactive = from.interactive;
        this.shareIdentity = from.shareIdentity;
        this.urgent = from.urgent;
        this.filterExtrasForReceiver = from.filterExtrasForReceiver;
        this.originalStickyCallingUid = from.originalStickyCallingUid;
    }

    boolean setDeliveryState(int index, int newDeliveryState, String reason) {
        int oldDeliveryState = this.delivery[index];
        if (isDeliveryStateTerminal(oldDeliveryState) == true) goto L28;
        if (newDeliveryState == oldDeliveryState) goto L28;
        switch(oldDeliveryState) {
            case 6: goto L9;
            default: goto L10;
        };
    L9:
        this.deferredCount--;
    L10:
        switch(newDeliveryState) {
            case 0: goto L15;
            case 1: goto L14;
            case 2: goto L14;
            case 3: goto L14;
            case 4: goto L13;
            case 5: goto L14;
            case 6: goto L12;
            default: goto L16;
        };
    L12:
        this.deferredCount++;
        goto L16
    L13:
        this.scheduledTime[index] = SystemClock.uptimeMillis();
        goto L16
    L14:
        this.terminalTime[index] = SystemClock.uptimeMillis();
        this.terminalCount++;
        goto L16
    L15:
        this.scheduledTime[index] = 0;
    L16:
        this.delivery[index] = newDeliveryState;
        this.deliveryReasons[index] = reason;
        int oldBeyondCount = this.beyondCount;
        if (index < this.beyondCount) goto L24;
        int i = this.beyondCount;
    L20:
        if (i >= this.delivery.length) goto L24;
        if (isDeliveryStateBeyond(getDeliveryState(i)) == false) goto L24;
        this.beyondCount = i + 1;
        i = i + 1;
    L24:
        int i2 = this.beyondCount;
        if (i2 != oldBeyondCount) goto L27;
        return false;
    L27:
        return true;
    L28:
        return false;
    }

    int getDeliveryState(int index) {
        return this.delivery[index];
    }

    boolean isBlocked(int index) {
        if (this.beyondCount >= this.blockedUntilBeyondCount[index]) goto L5;
        return true;
    L5:
        return false;
    }

    boolean wasDeliveryAttempted(int index) {
        int deliveryState = getDeliveryState(index);
        switch(deliveryState) {
            case 1: goto L6;
            case 2: goto L4;
            case 3: goto L6;
            case 4: goto L4;
            case 5: goto L6;
            default: goto L4;
        };
    L4:
        return false;
    L6:
        return true;
    }

    boolean wasDelivered(int index) {
        int deliveryState = getDeliveryState(index);
        switch(deliveryState) {
            case 1: goto L6;
            case 2: goto L4;
            case 3: goto L6;
            default: goto L4;
        };
    L4:
        return false;
    L6:
        return true;
    }

    void copyEnqueueTimeFrom(BroadcastRecord replacedBroadcast) {
        this.originalEnqueueClockTime = this.enqueueClockTime;
        this.enqueueTime = replacedBroadcast.enqueueTime;
        this.enqueueRealTime = replacedBroadcast.enqueueRealTime;
        this.enqueueClockTime = replacedBroadcast.enqueueClockTime;
    }

    boolean isForeground() {
        if ((this.intent.getFlags() & 268435456) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    boolean isReplacePending() {
        if ((this.intent.getFlags() & 536870912) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    boolean isNoAbort() {
        if ((this.intent.getFlags() & 134217728) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    boolean isOffload() {
        if ((this.intent.getFlags() & Integer.MIN_VALUE) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    boolean isDeferUntilActive() {
        return this.deferUntilActive;
    }

    boolean isUrgent() {
        return this.urgent;
    }

    String getHostingRecordTriggerType() {
        if (this.alarm == false) goto L7;
        return HostingRecord.TRIGGER_TYPE_ALARM;
    L7:
        if (this.pushMessage == false) goto L11;
        return HostingRecord.TRIGGER_TYPE_PUSH_MESSAGE;
    L11:
        if (this.pushMessageOverQuota == false) goto L14;
        return HostingRecord.TRIGGER_TYPE_PUSH_MESSAGE_OVER_QUOTA;
    L14:
        return "unknown";
    }

    Intent getReceiverIntent(Object receiver) {
        Intent newIntent = null;
        if (this.filterExtrasForReceiver == null) goto L12;
        Bundle extras = this.intent.getExtras();
        if (extras == null) goto L12;
        int receiverUid = getReceiverUid(receiver);
        Bundle filteredExtras = this.filterExtrasForReceiver.apply(Integer.valueOf(receiverUid), extras);
        if (filteredExtras != null) goto L10;
        return null;
    L10:
        newIntent = new Intent(this.intent);
        newIntent.replaceExtras(filteredExtras);
    L12:
        if ((receiver instanceof ResolveInfo) == false) goto L16;
        if (newIntent != null) goto L15;
        newIntent = new Intent(this.intent);
    L15:
        newIntent.setComponent(((ResolveInfo) receiver).activityInfo.getComponentName());
    L16:
        if (newIntent == null) goto L19;
        return newIntent;
    L19:
        return this.intent;
    }

    static boolean isCallerInstrumented(ProcessRecord callerApp, int callingUid) {
        switch(UserHandle.getAppId(callingUid)) {
            case 0: goto L11;
            case 2000: goto L11;
            default: goto L5;
        };
    L11:
        return true;
    L5:
        if (callerApp == null) goto L10;
        if (callerApp.getActiveInstrumentation() == null) goto L10;
        return true;
    L10:
        return false;
    }

    static boolean isPrioritized(int[] blockedUntilBeyondCount, boolean ordered) {
        if (ordered == false) goto L5;
        return false;
    L5:
        if (blockedUntilBeyondCount.length > 0) goto L7;
        return false;
    L7:
        if (blockedUntilBeyondCount[0] == (-1)) goto L12;
        return true;
    L12:
        return false;
    }

    static int[] calculateBlockedUntilBeyondCount(List<Object> receivers, boolean ordered, PlatformCompat platformCompat) {
        int N = receivers.size();
        int[] blockedUntilBeyondCount = new int[N];
        if (ordered == false) goto L8;
        int i = 0;
    L5:
        if (i >= N) goto L34;
        blockedUntilBeyondCount[i] = i;
        i = i + 1;
    L34:
        return blockedUntilBeyondCount;
    L8:
        boolean[] changeEnabled = calculateChangeStateForReceivers(receivers, LIMIT_PRIORITY_SCOPE, platformCompat);
        int lastTranchePriority = 0;
        int currentTranchePriority = 0;
        int lastTranchePriorityIndex = -1;
        int lastTrancheChangeDisabledIndex = -1;
        int currentTrancheChangeDisabledIndex = -1;
        int i2 = 0;
    L10:
        if (i2 >= N) goto L28;
        int thisPriority = getReceiverPriority(receivers.get(i2));
        if (i2 != 0) goto L16;
        currentTranchePriority = thisPriority;
        if (changeEnabled[i2] == true) goto L26;
        currentTrancheChangeDisabledIndex = i2;
    L26:
        i2 = i2 + 1;
        goto L10
    L16:
        if (thisPriority == currentTranchePriority) goto L21;
        if (currentTrancheChangeDisabledIndex == (-1)) goto L19;
        lastTrancheChangeDisabledIndex = currentTrancheChangeDisabledIndex;
    L19:
        lastTranchePriority = currentTranchePriority;
        lastTranchePriorityIndex = i2 - 1;
        currentTranchePriority = thisPriority;
        currentTrancheChangeDisabledIndex = -1;
    L21:
        if (changeEnabled[i2] == true) goto L23;
        currentTrancheChangeDisabledIndex = i2;
        blockedUntilBeyondCount[i2] = lastTranchePriorityIndex + 1;
        goto L26
    L23:
        if (thisPriority == lastTranchePriority) goto L26;
        if (lastTrancheChangeDisabledIndex == (-1)) goto L26;
        blockedUntilBeyondCount[i2] = lastTrancheChangeDisabledIndex + 1;
        goto L26
    L28:
        if (N <= 0) goto L34;
        if (lastTranchePriorityIndex == (-1)) goto L32;
        if (lastTrancheChangeDisabledIndex != (-1)) goto L34;
        if (currentTrancheChangeDisabledIndex != (-1)) goto L34;
    L32:
        Arrays.fill(blockedUntilBeyondCount, -1);
        goto L34
    }

    static boolean[] calculateChangeStateForReceivers(List<Object> receivers, long changeId, PlatformCompat platformCompat) {
        ArrayMap<String, Boolean> changeStates = new ArrayMap();
        int count = receivers.size();
        boolean[] changeStateForReceivers = new boolean[count];
        int i = 0;
    L3:
        if (i >= count) goto L10;
        ApplicationInfo receiverAppInfo = getReceiverAppInfo(receivers.get(i));
        int idx = changeStates.indexOfKey(receiverAppInfo.packageName);
        if (idx < 0) goto L7;
        boolean isChangeEnabled = changeStates.valueAt(idx).booleanValue();
    L8:
        changeStateForReceivers[i] = isChangeEnabled;
        i = i + 1;
        goto L3
    L7:
        isChangeEnabled = platformCompat.isChangeEnabledInternalNoLogging(changeId, receiverAppInfo);
        changeStates.put(receiverAppInfo.packageName, Boolean.valueOf(isChangeEnabled));
        goto L8
    L10:
        return changeStateForReceivers;
    }

    static ApplicationInfo getReceiverAppInfo(Object receiver) {
        if ((receiver instanceof BroadcastFilter) == false) goto L7;
        return ((BroadcastFilter) receiver).getApplicationInfo();
    L7:
        return ((ResolveInfo) receiver).activityInfo.applicationInfo;
    }

    static int getReceiverUid(Object receiver) {
        if ((receiver instanceof BroadcastFilter) == false) goto L7;
        return ((BroadcastFilter) receiver).owningUid;
    L7:
        return ((ResolveInfo) receiver).activityInfo.applicationInfo.uid;
    }

    static String getReceiverProcessName(Object receiver) {
        if ((receiver instanceof BroadcastFilter) == false) goto L7;
        return ((BroadcastFilter) receiver).receiverList.app.processName;
    L7:
        return ((ResolveInfo) receiver).activityInfo.processName;
    }

    static String getReceiverPackageName(Object receiver) {
        if ((receiver instanceof BroadcastFilter) == false) goto L7;
        return ((BroadcastFilter) receiver).receiverList.app.info.packageName;
    L7:
        return ((ResolveInfo) receiver).activityInfo.packageName;
    }

    static String getReceiverClassName(Object receiver) {
        if ((receiver instanceof BroadcastFilter) == false) goto L7;
        return ((BroadcastFilter) receiver).getReceiverClassName();
    L7:
        return ((ResolveInfo) receiver).activityInfo.name;
    }

    static int getReceiverPriority(Object receiver) {
        if ((receiver instanceof BroadcastFilter) == false) goto L7;
        return ((BroadcastFilter) receiver).getPriority();
    L7:
        return ((ResolveInfo) receiver).priority;
    }

    static boolean isReceiverEquals(Object a, Object b) {
        if (a != b) goto L6;
        return true;
    L6:
        if ((a instanceof ResolveInfo) == true) goto L8;
    L16:
        return false;
    L8:
        if ((b instanceof ResolveInfo) == false) goto L16;
        ResolveInfo infoA = (ResolveInfo) a;
        ResolveInfo infoB = (ResolveInfo) b;
        if (Objects.equals(infoA.activityInfo.packageName, infoB.activityInfo.packageName) == false) goto L15;
        if (Objects.equals(infoA.activityInfo.name, infoB.activityInfo.name) == false) goto L15;
        return true;
    L15:
        return false;
    }

    static boolean calculateUrgent(Intent intent, BroadcastOptions options) {
        if ((intent.getFlags() & 268435456) == 0) goto L5;
        return true;
    L5:
        if (options != null) goto L7;
        return false;
    L7:
        if (options.isInteractive() == false) goto L10;
        return true;
    L10:
        if (options.isAlarmBroadcast() == false) goto L14;
        return true;
    L14:
        return false;
    }

    static boolean calculateDeferUntilActive(int callingUid, BroadcastOptions options, IIntentReceiver resultTo, boolean ordered, boolean urgent) {
        if (ordered == false) goto L6;
        return false;
    L6:
        if (ordered == true) goto L9;
        if (resultTo == null) goto L9;
        return true;
    L9:
        if (options != null) goto L11;
    L15:
        if (urgent == false) goto L18;
        return false;
    L18:
        if (CORE_DEFER_UNTIL_ACTIVE == true) goto L20;
    L22:
        return false;
    L20:
        if (UserHandle.isCore(callingUid) == false) goto L22;
        return true;
    L11:
        switch(options.getDeferralPolicy()) {
            case 1: goto L14;
            case 2: goto L13;
            default: goto L15;
        };
    L13:
        return true;
    L14:
        return false;
    }

    int calculateTypeForLogging() {
        if (isForeground() == false) goto L5;
        int type = 0 | 2;
    L7:
        if (this.alarm == false) goto L10;
        type = type | 4;
    L10:
        if (this.interactive == false) goto L13;
        type = type | 8;
    L13:
        if (this.ordered == false) goto L16;
        type = type | 16;
    L16:
        if (this.prioritized == false) goto L19;
        type = type | 32;
    L19:
        if (this.resultTo == null) goto L22;
        type = type | 64;
    L22:
        if (this.deferUntilActive == false) goto L25;
        type = type | 128;
    L25:
        if (this.pushMessage == false) goto L28;
        type = type | 256;
    L28:
        if (this.pushMessageOverQuota == false) goto L31;
        type = type | 512;
    L31:
        if (this.sticky == false) goto L34;
        type = type | 1024;
    L34:
        if (this.initialSticky == true) goto L36;
        return type;
    L36:
        return type | 2048;
    L5:
        type = 0 | 1;
        goto L7
    }

    int[] calculateTypesForLogging() {
        IntArray types = new IntArray();
        if (isForeground() == false) goto L5;
        types.add(2);
    L7:
        if (this.alarm == false) goto L10;
        types.add(4);
    L10:
        if (this.interactive == false) goto L13;
        types.add(8);
    L13:
        if (this.ordered == false) goto L16;
        types.add(16);
    L16:
        if (this.prioritized == false) goto L19;
        types.add(32);
    L19:
        if (this.resultTo == null) goto L22;
        types.add(64);
    L22:
        if (this.deferUntilActive == false) goto L25;
        types.add(128);
    L25:
        if (this.pushMessage == false) goto L28;
        types.add(256);
    L28:
        if (this.pushMessageOverQuota == false) goto L31;
        types.add(512);
    L31:
        if (this.sticky == false) goto L34;
        types.add(1024);
    L34:
        if (this.initialSticky == false) goto L37;
        types.add(2048);
    L37:
        return types.toArray();
    L5:
        types.add(1);
        goto L7
    }

    public BroadcastRecord maybeStripForHistory() {
        if (this.intent.canStripForHistory() == true) goto L6;
        return this;
    L6:
        return new BroadcastRecord(this, this.intent.maybeStripForHistory());
    }

    boolean cleanupDisabledPackageReceiversLocked(String packageName, Set<String> filterByClasses, int userId, boolean doit) {
        if (this.receivers != null) goto L6;
        return false;
    L6:
        if (userId != (-1)) goto L8;
        boolean cleanupAllUsers = true;
    L10:
        if (this.userId != (-1)) goto L12;
        boolean sendToAllUsers = true;
    L14:
        if (this.userId == userId) goto L18;
        if (cleanupAllUsers == true) goto L18;
        if (sendToAllUsers == true) goto L18;
        return false;
    L18:
        boolean didSomething = false;
        int i = this.receivers.size() - 1;
    L19:
        if (i < 0) goto L44;
        Object o = this.receivers.get(i);
        if ((o instanceof ResolveInfo) == false) goto L43;
        ActivityInfo info = ((ResolveInfo) o).activityInfo;
        if (packageName != null) goto L26;
    L32:
        boolean sameComponent = true;
    L34:
        if (sameComponent == false) goto L43;
        if (cleanupAllUsers == false) goto L37;
    L38:
        if (doit == false) goto L39;
        didSomething = true;
        this.receivers.remove(i);
        if (i >= this.nextReceiver) goto L43;
        this.nextReceiver--;
        goto L43
    L39:
        return true;
    L37:
        if (UserHandle.getUserId(info.applicationInfo.uid) != userId) goto L43;
    L26:
        if (info.applicationInfo.packageName.equals(packageName) == false) goto L31;
        if (filterByClasses == null) goto L32;
        if (filterByClasses.contains(info.name) == true) goto L32;
    L31:
        sameComponent = false;
    L43:
        i = i - 1;
        goto L19
    L44:
        this.nextReceiver = Math.min(this.nextReceiver, this.receivers.size());
        return didSomething;
    L12:
        sendToAllUsers = false;
        goto L14
    L8:
        cleanupAllUsers = false;
        goto L10
    }

    void applySingletonPolicy(ActivityManagerService service) {
        if (this.receivers != null) goto L5;
        return;
    L5:
        int i = 0;
    L7:
        if (i >= this.receivers.size()) goto L23;
        Object receiver = this.receivers.get(i);
        if ((receiver instanceof ResolveInfo) == false) goto L21;
        ResolveInfo info = (ResolveInfo) receiver;
        boolean isSingleton = false;
        isSingleton = service.isSingleton(info.activityInfo.processName, info.activityInfo.applicationInfo, info.activityInfo.name, info.activityInfo.flags);     // Catch: SecurityException -> L13
    L15:
        int receiverUid = info.activityInfo.applicationInfo.uid;
        if (this.callingUid == 1000) goto L21;
        if (isSingleton == false) goto L21;
        if (service.isValidSingletonCall(this.callingUid, receiverUid) == false) goto L21;
        info.activityInfo = service.getActivityInfoForUser(info.activityInfo, 0);
    L13:
        e = move-exception;
        BroadcastQueue.logw(e.getMessage());
    L21:
        i = i + 1;
        goto L7
    }

    boolean containsReceiver(Object receiver) {
        int i = this.receivers.size() - 1;
    L3:
        if (i < 0) goto L8;
        if (isReceiverEquals(receiver, this.receivers.get(i)) == true) goto L6;
        i = i - 1;
        goto L3
    L6:
        return true;
    L8:
        return false;
    }

    boolean containsAllReceivers(List<Object> otherReceivers) {
        int i = otherReceivers.size() - 1;
    L3:
        if (i < 0) goto L10;
        if (containsReceiver(otherReceivers.get(i)) == false) goto L6;
        i = i - 1;
        goto L3
    L6:
        return false;
    L10:
        return true;
    }

    int getDeliveryGroupPolicy() {
        if (this.options != null) goto L7;
        return 0;
    L7:
        return this.options.getDeliveryGroupPolicy();
    }

    boolean matchesDeliveryGroup(BroadcastRecord other) {
        return matchesDeliveryGroup(this, other);
    }

    private static boolean matchesDeliveryGroup(BroadcastRecord newRecord, BroadcastRecord oldRecord) {
        IntentFilter newMatchingFilter = getDeliveryGroupMatchingFilter(newRecord);
        if (isMatchingKeyNull(newRecord) == true) goto L5;
    L9:
        if (newMatchingFilter == null) goto L15;
        if (newMatchingFilter.asPredicate().test(oldRecord.intent) == true) goto L15;
        return false;
    L15:
        return areMatchingKeysEqual(newRecord, oldRecord);
    L5:
        if (isMatchingKeyNull(oldRecord) == false) goto L9;
        if (newMatchingFilter != null) goto L9;
        return newRecord.intent.filterEquals(oldRecord.intent);
    }

    private static boolean isMatchingKeyNull(BroadcastRecord record) {
        String namespace = getDeliveryGroupMatchingNamespaceFragment(record);
        String key = getDeliveryGroupMatchingKeyFragment(record);
        if (namespace == null) goto L7;
        if (key == null) goto L7;
        return false;
    L7:
        return true;
    }

    private static boolean areMatchingKeysEqual(BroadcastRecord newRecord, BroadcastRecord oldRecord) {
        String newNamespaceFragment = getDeliveryGroupMatchingNamespaceFragment(newRecord);
        String oldNamespaceFragment = getDeliveryGroupMatchingNamespaceFragment(oldRecord);
        if (Objects.equals(newNamespaceFragment, oldNamespaceFragment) == true) goto L6;
        return false;
    L6:
        String newKeyFragment = getDeliveryGroupMatchingKeyFragment(newRecord);
        String oldKeyFragment = getDeliveryGroupMatchingKeyFragment(oldRecord);
        return Objects.equals(newKeyFragment, oldKeyFragment);
    }

    private static String getDeliveryGroupMatchingNamespaceFragment(BroadcastRecord record) {
        if (record.options != null) goto L6;
        return null;
    L6:
        return record.options.getDeliveryGroupMatchingNamespaceFragment();
    }

    private static String getDeliveryGroupMatchingKeyFragment(BroadcastRecord record) {
        if (record.options != null) goto L6;
        return null;
    L6:
        return record.options.getDeliveryGroupMatchingKeyFragment();
    }

    private static IntentFilter getDeliveryGroupMatchingFilter(BroadcastRecord record) {
        if (record.options != null) goto L6;
        return null;
    L6:
        return record.options.getDeliveryGroupMatchingFilter();
    }

    boolean allReceiversPending() {
        if (this.terminalCount == 0) goto L5;
    L7:
        return false;
    L5:
        if (this.dispatchTime > 0) goto L7;
        return true;
    }

    boolean isMatchingRecord(BroadcastRecord record) {
        int idx = this.mMatchingRecordsCache.indexOfKey(record);
        if (idx <= 0) goto L7;
        return this.mMatchingRecordsCache.valueAt(idx).booleanValue();
    L7:
        if (this.receivers.size() != record.receivers.size()) goto L9;
        boolean matches = true;
    L10:
        if (matches == false) goto L17;
        int i = this.receivers.size() - 1;
    L12:
        if (i < 0) goto L17;
        if (isReceiverEquals(this.receivers.get(i), record.receivers.get(i)) == false) goto L15;
        i = i - 1;
        goto L12
    L15:
        matches = false;
    L17:
        this.mMatchingRecordsCache.put(record, Boolean.valueOf(matches));
        return matches;
    L9:
        matches = false;
        goto L10
    }

    void setMatchingRecordsCache(ArrayMap<BroadcastRecord, Boolean> matchingRecordsCache) {
        this.mMatchingRecordsCache = matchingRecordsCache;
    }

    void clearMatchingRecordsCache() {
        this.mMatchingRecordsCache = null;
    }

    public String toString() {
        if (this.mCachedToString != null) goto L6;
        this.mCachedToString = "BroadcastRecord{" + toShortString() + "}";
    L6:
        return this.mCachedToString;
    }

    public String toShortString() {
        if (this.mCachedToShortString != null) goto L5;
        String label = intentToString(this.intent);
        this.mCachedToShortString = Integer.toHexString(System.identityHashCode(this)) + " " + label + "/u" + this.userId;
    L5:
        String label2 = this.mCachedToShortString;
        return label2;
    }

    public static String intentToString(Intent intent) {
        String label = intent.getAction();
        if (label == null) goto L5;
        return label;
    L5:
        return intent.toString();
    }

    public boolean debugLog() {
        return debugLog(this.options);
    }

    public static boolean debugLog(BroadcastOptions options) {
        if (options != null) goto L4;
    L6:
        return false;
    L4:
        if (options.isDebugLogEnabled() == false) goto L6;
        return true;
    }

    @NeverCompile
    public void dumpDebug(ProtoOutputStream proto, long fieldId) {
        long token = proto.start(fieldId);
        proto.write(1120986464257L, this.userId);
        proto.write(1138166333442L, this.intent.getAction());
        proto.end(token);
    }

    public void updateBroadcastProcessedEventRecord(Object receiver, long timeMillis) {
        String receiverProcessName = getReceiverProcessName(receiver);
        BroadcastProcessedEventRecord broadcastProcessedEventRecord = this.mBroadcastProcessedRecords.get(receiverProcessName);
        if (broadcastProcessedEventRecord != null) goto L5;
        broadcastProcessedEventRecord = new BroadcastProcessedEventRecord().setBroadcastTypes(calculateTypesForLogging()).setIntentAction(this.intent.getAction()).setReceiverProcessName(receiverProcessName).setReceiverUid(getReceiverUid(receiver)).setSenderUid(this.callingUid);
        this.mBroadcastProcessedRecords.put(receiverProcessName, broadcastProcessedEventRecord);
    L5:
        broadcastProcessedEventRecord.addReceiverFinishTime(timeMillis);
    }

    public void logBroadcastProcessedEventRecord() {
        int size = this.mBroadcastProcessedRecords.size();
        int i = 0;
    L3:
        if (i >= size) goto L5;
        this.mBroadcastProcessedRecords.valueAt(i).logToStatsD();
        i = i + 1;
        goto L3
    L5:
        this.mBroadcastProcessedRecords.clear();
    }

    ArrayMap<String, BroadcastProcessedEventRecord> getBroadcastProcessedRecordsForTest() {
        return this.mBroadcastProcessedRecords;
    }
}
