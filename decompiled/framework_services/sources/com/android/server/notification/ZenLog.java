package com.android.server.notification;

import android.app.NotificationManager;
import android.content.ComponentName;
import android.net.Uri;
import android.os.Build;
import android.os.RemoteException;
import android.service.notification.IConditionProvider;
import android.service.notification.ZenModeConfig;
import android.service.notification.ZenModeDiff;
import android.util.LocalLog;
import java.io.PrintWriter;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ZenLog {
    private static final LocalLog INTERCEPTION_EVENTS = null;
    private static final int SIZE = 0;
    private static final LocalLog STATE_CHANGES = null;
    private static final int TYPE_ALERT_ON_UPDATED_INTERCEPT = 21;
    private static final int TYPE_APPLY_DEVICE_EFFECT = 22;
    private static final int TYPE_CHECK_REPEAT_CALLER = 20;
    private static final int TYPE_CONFIG = 11;
    private static final int TYPE_DISABLE_EFFECTS = 13;
    private static final int TYPE_INTERCEPTED = 1;
    private static final int TYPE_LISTENER_HINTS_CHANGED = 15;
    private static final int TYPE_MATCHES_CALL_FILTER = 18;
    private static final int TYPE_NOT_INTERCEPTED = 12;
    private static final int TYPE_RECORD_CALLER = 19;
    private static final int TYPE_SCHEDULE_APPLY_DEVICE_EFFECT = 23;
    private static final int TYPE_SET_CONSOLIDATED_ZEN_POLICY = 17;
    private static final int TYPE_SET_NOTIFICATION_POLICY = 16;
    private static final int TYPE_SET_RINGER_MODE_EXTERNAL = 3;
    private static final int TYPE_SET_RINGER_MODE_INTERNAL = 4;
    private static final int TYPE_SET_ZEN_MODE = 6;
    private static final int TYPE_SUBSCRIBE = 9;
    private static final int TYPE_SUPPRESSOR_CHANGED = 14;
    private static final int TYPE_UNSUBSCRIBE = 10;

    public ZenLog() {
    }

    static {
        if (Build.IS_DEBUGGABLE == false) goto L5;
        int r0 = 200;
    L6:
        SIZE = r0;
        STATE_CHANGES = new LocalLog(SIZE);
        INTERCEPTION_EVENTS = new LocalLog(SIZE);
        return;
    L5:
        r0 = 100;
        goto L6
    }

    public static void traceIntercepted(NotificationRecord record, String reason) {
        append(1, record.getKey() + "," + reason);
    }

    public static void traceNotIntercepted(NotificationRecord record, String reason) {
        append(12, record.getKey() + "," + reason);
    }

    public static void traceAlertOnUpdatedIntercept(NotificationRecord record) {
        append(21, record.getKey());
    }

    public static void traceSetRingerModeExternal(int ringerModeOld, int ringerModeNew, String caller, int ringerModeInternalIn, int ringerModeInternalOut) {
        append(3, caller + ",e:" + ringerModeToString(ringerModeOld) + "->" + ringerModeToString(ringerModeNew) + ",i:" + ringerModeToString(ringerModeInternalIn) + "->" + ringerModeToString(ringerModeInternalOut));
    }

    public static void traceSetRingerModeInternal(int ringerModeOld, int ringerModeNew, String caller, int ringerModeExternalIn, int ringerModeExternalOut) {
        append(4, caller + ",i:" + ringerModeToString(ringerModeOld) + "->" + ringerModeToString(ringerModeNew) + ",e:" + ringerModeToString(ringerModeExternalIn) + "->" + ringerModeToString(ringerModeExternalOut));
    }

    public static void traceSetZenMode(int zenMode, String reason) {
        append(6, zenModeToString(zenMode) + "," + reason);
    }

    public static void traceSetConsolidatedZenPolicy(NotificationManager.Policy policy, String reason) {
        append(17, policy.toString() + "," + reason);
    }

    public static void traceSetNotificationPolicy(String pkg, int targetSdk, NotificationManager.Policy policy) {
        String policyLog = "pkg=" + pkg + " targetSdk=" + targetSdk + " NotificationPolicy=" + policy.toString();
        append(16, policyLog);
    }

    public static void traceSubscribe(Uri uri, IConditionProvider provider, RemoteException e) {
        append(9, uri + "," + subscribeResult(provider, e));
    }

    public static void traceUnsubscribe(Uri uri, IConditionProvider provider, RemoteException e) {
        append(10, uri + "," + subscribeResult(provider, e));
    }

    public static void traceConfig(int origin, String reason, ComponentName triggeringComponent, ZenModeConfig oldConfig, ZenModeConfig newConfig, int callingUid) {
        ZenModeDiff.ConfigDiff diff = new ZenModeDiff.ConfigDiff(oldConfig, newConfig);
        if (diff.hasDiff() == true) goto L5;
        append(11, reason + " (" + originToString(origin) + ") no changes");
        return;
    L5:
        StringBuilder r1 = new StringBuilder();
        r1.append(reason);
        r1.append(" (");
        r1.append(originToString(origin));
        r1.append(") from uid ");
        r1.append(callingUid);
        if (triggeringComponent == null) goto L8;
        String r2 = " - " + triggeringComponent;
    L9:
        r1.append(r2);
        r1.append(",\n");
        if (newConfig == null) goto L12;
        String r4 = newConfig.toString();
    L13:
        r1.append(r4);
        r1.append(",\n");
        r1.append(diff);
        append(11, r1.toString());
        return;
    L12:
        r4 = null;
        goto L13
    L8:
        r2 = "";
        goto L9
    }

    public static void traceDisableEffects(NotificationRecord record, String reason) {
        append(13, record.getKey() + "," + reason);
    }

    public static void traceEffectsSuppressorChanged(List<ComponentName> oldSuppressors, List<ComponentName> newSuppressors, long oldSuppressedEffects, long suppressedEffects) {
        append(14, "suppressed effects:" + oldSuppressedEffects + "->" + suppressedEffects + "," + componentListToString(oldSuppressors) + "->" + componentListToString(newSuppressors));
    }

    public static void traceListenerHintsChanged(int oldHints, int newHints, int listenerCount) {
        append(15, hintsToString(oldHints) + "->" + hintsToString(newHints) + ",listeners=" + listenerCount);
    }

    public static void traceMatchesCallFilter(boolean result, String reason, int callingUid) {
        append(18, "result=" + result + ", reason=" + reason + ", calling uid=" + callingUid);
    }

    public static void traceRecordCaller(boolean hasPhone, boolean hasUri) {
        append(19, "has phone number=" + hasPhone + ", has uri=" + hasUri);
    }

    public static void traceCheckRepeatCaller(boolean found, boolean hasPhone, boolean hasUri) {
        append(20, "res=" + found + ", given phone number=" + hasPhone + ", given uri=" + hasUri);
    }

    public static void traceApplyDeviceEffect(String effect, boolean newValue) {
        append(22, effect + " -> " + newValue);
    }

    public static void traceScheduleApplyDeviceEffect(String effect, boolean scheduledValue) {
        append(23, effect + " -> " + scheduledValue);
    }

    private static String subscribeResult(IConditionProvider provider, RemoteException e) {
        if (provider != null) goto L4;
        return "no provider";
    L4:
        if (e != null) goto L9;
        return "ok";
    L9:
        return e.getMessage();
    }

    private static String typeToString(int type) {
        switch(type) {
            case 1: goto L41;
            case 2: goto L3;
            case 3: goto L39;
            case 4: goto L37;
            case 5: goto L3;
            case 6: goto L35;
            case 7: goto L3;
            case 8: goto L3;
            case 9: goto L33;
            case 10: goto L31;
            case 11: goto L29;
            case 12: goto L27;
            case 13: goto L25;
            case 14: goto L23;
            case 15: goto L21;
            case 16: goto L19;
            case 17: goto L17;
            case 18: goto L15;
            case 19: goto L13;
            case 20: goto L11;
            case 21: goto L9;
            case 22: goto L7;
            case 23: goto L5;
            default: goto L3;
        };
    L3:
        return "unknown";
    L5:
        return "schedule_device_effect";
    L7:
        return "apply_device_effect";
    L9:
        return "alert_on_updated_intercept";
    L11:
        return "check_repeat_caller";
    L13:
        return "record_caller";
    L15:
        return "matches_call_filter";
    L17:
        return "set_consolidated_policy";
    L19:
        return "set_notification_policy";
    L21:
        return "listener_hints_changed";
    L23:
        return "suppressor_changed";
    L25:
        return "disable_effects";
    L27:
        return "not_intercepted";
    L29:
        return "config";
    L31:
        return "unsubscribe";
    L33:
        return "subscribe";
    L35:
        return "set_zen_mode";
    L37:
        return "set_ringer_mode_internal";
    L39:
        return "set_ringer_mode_external";
    L41:
        return "intercepted";
    }

    private static String ringerModeToString(int ringerMode) {
        switch(ringerMode) {
            case 0: goto L9;
            case 1: goto L7;
            case 2: goto L5;
            default: goto L3;
        };
    L3:
        return "unknown";
    L5:
        return "normal";
    L7:
        return "vibrate";
    L9:
        return "silent";
    }

    private static String zenModeToString(int zenMode) {
        switch(zenMode) {
            case 0: goto L11;
            case 1: goto L9;
            case 2: goto L7;
            case 3: goto L5;
            default: goto L3;
        };
    L3:
        return "unknown";
    L5:
        return "alarms";
    L7:
        return "no_interruptions";
    L9:
        return "important_interruptions";
    L11:
        return "off";
    }

    private static String hintsToString(int hints) {
        switch(hints) {
            case 0: goto L11;
            case 1: goto L9;
            case 2: goto L7;
            case 3: goto L4;
            case 4: goto L5;
            default: goto L4;
        };
    L5:
        return "disable_call_effects";
    L7:
        return "disable_notification_effects";
    L9:
        return "disable_effects";
    L11:
        return "none";
    L4:
        return Integer.toString(hints);
    }

    private static String originToString(int origin) {
        switch(origin) {
            case 0: goto L11;
            case 1: goto L10;
            case 2: goto L9;
            case 3: goto L8;
            case 4: goto L7;
            case 5: goto L6;
            case 6: goto L5;
            case 7: goto L4;
            default: goto L13;
        };
    L4:
        return "ORIGIN_USER_IN_APP";
    L5:
        return "ORIGIN_RESTORE_BACKUP";
    L6:
        return "ORIGIN_SYSTEM";
    L7:
        return "ORIGIN_APP";
    L8:
        return "ORIGIN_USER_IN_SYSTEMUI";
    L9:
        return "ORIGIN_INIT_USER";
    L10:
        return "ORIGIN_INIT";
    L11:
        return "ORIGIN_UNKNOWN";
    L13:
        return origin + "??";
    }

    private static String componentToString(ComponentName component) {
        if (component != null) goto L6;
        return null;
    L6:
        return component.toShortString();
    }

    private static String componentListToString(List<ComponentName> components) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
    L4:
        if (i >= components.size()) goto L9;
        if (i <= 0) goto L7;
        stringBuilder.append(", ");
    L7:
        stringBuilder.append(componentToString(components.get(i)));
        i = i + 1;
        goto L4
    L9:
        return stringBuilder.toString();
    }

    private static void append(int type, String msg) {
        if (type != 1) goto L5;
    L23:
        LocalLog r0 = INTERCEPTION_EVENTS;
        monitor-enter(r0);
        INTERCEPTION_EVENTS.log(typeToString(type) + ": " + msg);     // Catch: Throwable -> L28
        monitor-exit(r0);     // Catch: Throwable -> L28
        return;
    L28:
        th = move-exception;
        throw th;
    L5:
        if (type == 12) goto L23;
        if (type == 20) goto L23;
        if (type == 19) goto L23;
        if (type == 18) goto L23;
        if (type == 21) goto L23;
        LocalLog r1 = STATE_CHANGES;
        monitor-enter(r1);
        STATE_CHANGES.log(typeToString(type) + ": " + msg);     // Catch: Throwable -> L20
        monitor-exit(r1);     // Catch: Throwable -> L20
        return;
    L20:
        th = move-exception;
        throw th;
    }

    public static void dump(PrintWriter pw, String prefix) {
        LocalLog r0 = INTERCEPTION_EVENTS;
        monitor-enter(r0);
        pw.printf(prefix + "Interception Events:\n", new Object[0]);     // Catch: Throwable -> L14
        INTERCEPTION_EVENTS.dump(prefix, pw);     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        LocalLog r1 = STATE_CHANGES;
        monitor-enter(r1);
        pw.printf(prefix + "State Changes:\n", new Object[0]);     // Catch: Throwable -> L11
        STATE_CHANGES.dump(prefix, pw);     // Catch: Throwable -> L11
        monitor-exit(r1);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    L14:
        th = move-exception;
        throw th;
    }

    public static void clear() {
        LocalLog r0 = INTERCEPTION_EVENTS;
        monitor-enter(r0);
        INTERCEPTION_EVENTS.clear();     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        LocalLog r1 = STATE_CHANGES;
        monitor-enter(r1);
        STATE_CHANGES.clear();     // Catch: Throwable -> L11
        monitor-exit(r1);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    L14:
        th = move-exception;
        throw th;
    }
}
