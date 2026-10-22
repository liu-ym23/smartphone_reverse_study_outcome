package com.android.server.notification;

import android.R;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Bundle;
import android.os.UserHandle;
import android.telecom.TelecomManager;
import android.telephony.PhoneNumberUtils;
import android.telephony.TelephonyManager;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.Slog;
import com.android.internal.util.NotificationMessagingUtil;
import com.android.server.am.HostingRecord;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class ZenModeFiltering {
    private static final boolean DEBUG = false;
    static final RepeatCallers REPEAT_CALLERS = null;
    private static final String TAG = "ZenModeHelper";
    private final Context mContext;
    private ComponentName mDefaultPhoneApp;
    private final NotificationMessagingUtil mMessagingUtil;

    private static class RepeatCallers {
        private final ArrayMap<String, Long> mOtherCalls;
        private final ArrayMap<String, Long> mTelCalls;
        private int mThresholdMinutes;

        /* JADX INFO: renamed from: -$$Nest$fgetmOtherCalls, reason: not valid java name */
        static /* bridge */ /* synthetic */ ArrayMap m6305$$Nest$fgetmOtherCalls(RepeatCallers r0) {
            return r0.mOtherCalls;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmTelCalls, reason: not valid java name */
        static /* bridge */ /* synthetic */ ArrayMap m6306$$Nest$fgetmTelCalls(RepeatCallers r0) {
            return r0.mTelCalls;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmThresholdMinutes, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m6307$$Nest$fgetmThresholdMinutes(RepeatCallers r0) {
            return r0.mThresholdMinutes;
        }

        /* JADX INFO: renamed from: -$$Nest$mcleanUpCallsAfter, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m6308$$Nest$mcleanUpCallsAfter(RepeatCallers r0, long r1) {
            r0.cleanUpCallsAfter(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$misRepeat, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m6309$$Nest$misRepeat(RepeatCallers r0, Context r1, Bundle r2, ArraySet r3) {
            return r0.isRepeat(r1, r2, r3);
        }

        /* JADX INFO: renamed from: -$$Nest$mrecordCall, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m6310$$Nest$mrecordCall(RepeatCallers r0, Context r1, Bundle r2, ArraySet r3) {
            r0.recordCall(r1, r2, r3);
        }

        /* synthetic */ RepeatCallers(ZenModeFilteringIA r1) {
            this();
        }

        private RepeatCallers() {
            this.mTelCalls = new ArrayMap();
            this.mOtherCalls = new ArrayMap();
        }

        private synchronized void recordCall(Context context, Bundle extras, ArraySet<String> phoneNumbers) {
            monitor-enter(this);
            setThresholdMinutes(context);     // Catch: Throwable -> L15
            if (this.mThresholdMinutes <= 0) goto L19;
            if (extras == null) goto L19;
            String[] extraPeople = ValidateNotificationPeople.getExtraPeople(extras);     // Catch: Throwable -> L15
            if (extraPeople != null) goto L10;
        L17:
            monitor-exit(this);
            return;
        L10:
            if (extraPeople.length == 0) goto L17;
            long now = System.currentTimeMillis();     // Catch: Throwable -> L15
            cleanUp(this.mTelCalls, now);     // Catch: Throwable -> L15
            cleanUp(this.mOtherCalls, now);     // Catch: Throwable -> L15
            recordCallers(extraPeople, phoneNumbers, now);     // Catch: Throwable -> L15
            monitor-exit(this);
            return;
        L19:
            monitor-exit(this);
            return;
        L15:
            th = move-exception;
            throw th;
        }

        private synchronized boolean isRepeat(Context context, Bundle extras, ArraySet<String> phoneNumbers) {
            monitor-enter(this);
            setThresholdMinutes(context);     // Catch: Throwable -> L15
            if (this.mThresholdMinutes <= 0) goto L19;
            if (extras == null) goto L19;
            String[] extraPeople = ValidateNotificationPeople.getExtraPeople(extras);     // Catch: Throwable -> L15
            if (extraPeople != null) goto L10;
        L17:
            monitor-exit(this);
            return false;
        L10:
            if (extraPeople.length == 0) goto L17;
            long now = System.currentTimeMillis();     // Catch: Throwable -> L15
            cleanUp(this.mTelCalls, now);     // Catch: Throwable -> L15
            cleanUp(this.mOtherCalls, now);     // Catch: Throwable -> L15
            boolean r3 = checkCallers(context, extraPeople, phoneNumbers);     // Catch: Throwable -> L15
            monitor-exit(this);
            return r3;
        L19:
            monitor-exit(this);
            return false;
        L15:
            th = move-exception;
            throw th;
        }

        private synchronized void cleanUp(ArrayMap<String, Long> calls, long now) {
            monitor-enter(this);
            int N = calls.size();     // Catch: Throwable -> L10
            int i = N - 1;     // Catch: Throwable -> L10
        L4:
            if (i < 0) goto L15;
            long time = calls.valueAt(i).longValue();     // Catch: Throwable -> L10
            if (time <= now) goto L8;
        L12:
            calls.removeAt(i);     // Catch: Throwable -> L10
        L13:
            i = i - 1;
            goto L4
        L8:
            if ((now - time) <= ((this.mThresholdMinutes * 1000) * 60)) goto L13;
        L15:
            monitor-exit(this);
            return;
        L10:
            th = move-exception;
            throw th;
        }

        private synchronized void cleanUpCallsAfter(long timeThreshold) {
            monitor-enter(this);
            int i = this.mTelCalls.size() - 1;     // Catch: Throwable -> L8
        L4:
            if (i < 0) goto L11;
            long time = this.mTelCalls.valueAt(i).longValue();     // Catch: Throwable -> L8
            if (time <= timeThreshold) goto L10;
            this.mTelCalls.removeAt(i);     // Catch: Throwable -> L8
        L10:
            i = i - 1;     // Catch: Throwable -> L8
            goto L4
        L11:
            int j = this.mOtherCalls.size() - 1;     // Catch: Throwable -> L8
        L12:
            if (j < 0) goto L18;
            long time2 = this.mOtherCalls.valueAt(j).longValue();     // Catch: Throwable -> L8
            if (time2 <= timeThreshold) goto L16;
            this.mOtherCalls.removeAt(j);     // Catch: Throwable -> L8
        L16:
            j = j - 1;
            goto L12
        L18:
            monitor-exit(this);
            return;
        L8:
            th = move-exception;
            throw th;
        }

        private void setThresholdMinutes(Context context) {
            if (this.mThresholdMinutes > 0) goto L6;
            this.mThresholdMinutes = context.getResources().getInteger(R.integer.device_idle_inactive_to_ms);
            return;
        }

        private synchronized void recordCallers(String[] people, ArraySet<String> phoneNumbers, long now) {
            monitor-enter(this);
            boolean recorded = false;
            boolean hasTel = false;
            boolean hasOther = false;
            int i = 0;
        L34:
        L14:
            th = move-exception;
            throw th;
        L5:
            if (i >= people.length) goto L20;
            String person = people[i];     // Catch: Throwable -> L14
            if (person == null) goto L18;
            Uri uri = Uri.parse(person);     // Catch: Throwable -> L14
            if ("tel".equals(uri.getScheme()) == false) goto L17;
            String tel = Uri.decode(uri.getSchemeSpecificPart());     // Catch: Throwable -> L14
            if (tel == null) goto L18;
            this.mTelCalls.put(tel, Long.valueOf(now));     // Catch: Throwable -> L14
            recorded = true;
            hasTel = true;
            goto L18
        L17:
            this.mOtherCalls.put(person, Long.valueOf(now));     // Catch: Throwable -> L14
            recorded = true;
            hasOther = true;
        L18:
            i = i + 1;     // Catch: Throwable -> L14
            goto L34
        L20:
            if (phoneNumbers == null) goto L28;
            Iterator<String> r3 = phoneNumbers.iterator();     // Catch: Throwable -> L14
        L23:
            if (r3.hasNext() == false) goto L28;
            String num = r3.next();     // Catch: Throwable -> L14
            if (num == null) goto L23;
            this.mTelCalls.put(num, Long.valueOf(now));     // Catch: Throwable -> L14
            recorded = true;
            hasTel = true;
        L28:
            if (recorded == false) goto L30;
            ZenLog.traceRecordCaller(hasTel, hasOther);     // Catch: Throwable -> L14
        L30:
            monitor-exit(this);
        }

        private synchronized boolean checkForNumber(String number, String defaultCountryCode) {
            monitor-enter(this);
        L18:
            th = move-exception;
            throw th;
        L5:
            if (this.mTelCalls.containsKey(number) == false) goto L8;
            monitor-exit(this);
            return true;
        L8:
            String numberToCheck = Uri.decode(number);     // Catch: Throwable -> L18
            if (numberToCheck == null) goto L20;
            Iterator<String> r2 = this.mTelCalls.keySet().iterator();     // Catch: Throwable -> L18
        L12:
            if (r2.hasNext() == false) goto L20;
            String prev = r2.next();     // Catch: Throwable -> L18
            if (PhoneNumberUtils.areSamePhoneNumber(numberToCheck, prev, defaultCountryCode) == false) goto L12;
            monitor-exit(this);
            return true;
        L20:
            monitor-exit(this);
            return false;
        }

        private synchronized boolean checkCallers(Context context, String[] people, ArraySet<String> phoneNumbers) {
            monitor-enter(this);
            boolean found = false;
            boolean checkedTel = false;
            boolean checkedOther = false;
            String defaultCountryCode = ((TelephonyManager) context.getSystemService(TelephonyManager.class)).getNetworkCountryIso();     // Catch: Throwable -> L16
            int i = 0;
        L6:
            if (i >= people.length) goto L23;
            String person = people[i];     // Catch: Throwable -> L16
            if (person == null) goto L21;
            Uri uri = Uri.parse(person);     // Catch: Throwable -> L16
            if ("tel".equals(uri.getScheme()) == false) goto L18;
            String number = uri.getSchemeSpecificPart();     // Catch: Throwable -> L16
            checkedTel = true;
            if (checkForNumber(number, defaultCountryCode) == false) goto L21;
            found = true;
            goto L21
        L18:
            checkedOther = true;
            if (this.mOtherCalls.containsKey(person) == false) goto L21;
            found = true;
        L21:
            i = i + 1;     // Catch: Throwable -> L16
            goto L6
        L23:
            if (phoneNumbers == null) goto L31;
            Iterator<String> r4 = phoneNumbers.iterator();     // Catch: Throwable -> L16
        L26:
            if (r4.hasNext() == false) goto L31;
            String num = r4.next();     // Catch: Throwable -> L16
            checkedTel = true;
            if (checkForNumber(num, defaultCountryCode) == false) goto L26;
            found = true;
        L31:
            ZenLog.traceCheckRepeatCaller(found, checkedTel, checkedOther);     // Catch: Throwable -> L16
            monitor-exit(this);
            return found;
        L16:
            th = move-exception;
            throw th;
        }
    }

    static {
        DEBUG = ZenModeHelper.DEBUG;
        REPEAT_CALLERS = new RepeatCallers(null);
    }

    public ZenModeFiltering(Context context) {
        this.mContext = context;
        this.mMessagingUtil = new NotificationMessagingUtil(this.mContext, null);
    }

    public ZenModeFiltering(Context context, NotificationMessagingUtil messagingUtil) {
        this.mContext = context;
        this.mMessagingUtil = messagingUtil;
    }

    public void dump(PrintWriter pw, String prefix) {
        pw.print(prefix);
        pw.print("mDefaultPhoneApp=");
        pw.println(this.mDefaultPhoneApp);
        pw.print(prefix);
        pw.print("RepeatCallers.mThresholdMinutes=");
        pw.println(RepeatCallers.m6307$$Nest$fgetmThresholdMinutes(REPEAT_CALLERS));
        RepeatCallers r0 = REPEAT_CALLERS;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (RepeatCallers.m6306$$Nest$fgetmTelCalls(REPEAT_CALLERS).isEmpty() == true) goto L13;
        pw.print(prefix);     // Catch: Throwable -> L10
        pw.println("RepeatCallers.mTelCalls=");     // Catch: Throwable -> L10
        int i = 0;
    L8:
        if (i >= RepeatCallers.m6306$$Nest$fgetmTelCalls(REPEAT_CALLERS).size()) goto L13;
        pw.print(prefix);     // Catch: Throwable -> L10
        pw.print("  ");     // Catch: Throwable -> L10
        pw.print((String) RepeatCallers.m6306$$Nest$fgetmTelCalls(REPEAT_CALLERS).keyAt(i));     // Catch: Throwable -> L10
        pw.print(" at ");     // Catch: Throwable -> L10
        pw.println(ts(((Long) RepeatCallers.m6306$$Nest$fgetmTelCalls(REPEAT_CALLERS).valueAt(i)).longValue()));     // Catch: Throwable -> L10
        i = i + 1;     // Catch: Throwable -> L10
    L13:
        if (RepeatCallers.m6305$$Nest$fgetmOtherCalls(REPEAT_CALLERS).isEmpty() == true) goto L18;
        pw.print(prefix);     // Catch: Throwable -> L10
        pw.println("RepeatCallers.mOtherCalls=");     // Catch: Throwable -> L10
        int i2 = 0;
    L16:
        if (i2 >= RepeatCallers.m6305$$Nest$fgetmOtherCalls(REPEAT_CALLERS).size()) goto L18;
        pw.print(prefix);     // Catch: Throwable -> L10
        pw.print("  ");     // Catch: Throwable -> L10
        pw.print((String) RepeatCallers.m6305$$Nest$fgetmOtherCalls(REPEAT_CALLERS).keyAt(i2));     // Catch: Throwable -> L10
        pw.print(" at ");     // Catch: Throwable -> L10
        pw.println(ts(((Long) RepeatCallers.m6305$$Nest$fgetmOtherCalls(REPEAT_CALLERS).valueAt(i2)).longValue()));     // Catch: Throwable -> L10
        i2 = i2 + 1;     // Catch: Throwable -> L10
    L18:
        monitor-exit(r0);     // Catch: Throwable -> L10
    }

    private static String ts(long time) {
        return new Date(time) + " (" + time + ")";
    }

    public static boolean matchesCallFilter(Context context, int zen, NotificationManager.Policy consolidatedPolicy, UserHandle userHandle, Bundle extras, ValidateNotificationPeople validator, int contactsTimeoutMs, float timeoutAffinity, int callingUid) {
        if (zen != 2) goto L7;
        ZenLog.traceMatchesCallFilter(false, "no interruptions", callingUid);
        return false;
    L7:
        if (zen != 3) goto L11;
        ZenLog.traceMatchesCallFilter(false, "alarms only", callingUid);
        return false;
    L11:
        if (zen == 1) goto L13;
    L25:
        ZenLog.traceMatchesCallFilter(true, "no restrictions", callingUid);
        return true;
    L13:
        if (consolidatedPolicy.allowRepeatCallers() == false) goto L19;
        if (RepeatCallers.m6309$$Nest$misRepeat(REPEAT_CALLERS, context, extras, null) == false) goto L19;
        ZenLog.traceMatchesCallFilter(true, "repeat caller", callingUid);
        return true;
    L19:
        if (consolidatedPolicy.allowCalls() == true) goto L22;
        ZenLog.traceMatchesCallFilter(false, "calls not allowed", callingUid);
        return false;
    L22:
        if (validator == null) goto L25;
        float contactAffinity = validator.getContactAffinity(userHandle, extras, contactsTimeoutMs, timeoutAffinity);
        boolean match = audienceMatches(consolidatedPolicy.allowCallsFrom(), contactAffinity);
        ZenLog.traceMatchesCallFilter(match, "contact affinity " + contactAffinity, callingUid);
        return match;
    }

    private static Bundle extras(NotificationRecord record) {
        if (record != null) goto L4;
    L8:
        return null;
    L4:
        if (record.getSbn() == null) goto L8;
        if (record.getSbn().getNotification() == null) goto L8;
        return record.getSbn().getNotification().extras;
    }

    protected void recordCall(NotificationRecord record) {
        RepeatCallers.m6310$$Nest$mrecordCall(REPEAT_CALLERS, this.mContext, extras(record), record.getPhoneNumbers());
    }

    private boolean canRecordBypassDnd(NotificationRecord record, NotificationManager.Policy policy) {
        if (record.getPackagePriority() != 2) goto L5;
        boolean inPriorityChannel = true;
    L6:
        if (inPriorityChannel == true) goto L8;
        return false;
    L8:
        if (policy.allowPriorityChannels() == true) goto L10;
        return false;
    L10:
        return true;
    L5:
        inPriorityChannel = false;
        goto L6
    }

    public boolean shouldIntercept(int zen, NotificationManager.Policy policy, NotificationRecord record) {
        if (zen != 0) goto L6;
        return false;
    L6:
        if (isCritical(record) == false) goto L10;
        maybeLogInterceptDecision(record, false, "criticalNotification");
        return false;
    L10:
        switch(zen) {
            case 1: goto L22;
            case 2: goto L19;
            case 3: goto L14;
            default: goto L11;
        };
    L11:
        maybeLogInterceptDecision(record, false, "unknownZenMode");
        return false;
    L19:
        maybeLogInterceptDecision(record, true, "none");
        return true;
    L14:
        if (isAlarm(record) == false) goto L17;
        maybeLogInterceptDecision(record, false, HostingRecord.TRIGGER_TYPE_ALARM);
        return false;
    L17:
        maybeLogInterceptDecision(record, true, "alarmsOnly");
        return true;
    L22:
        if (canRecordBypassDnd(record, policy) == false) goto L26;
        maybeLogInterceptDecision(record, false, "priorityApp");
        return false;
    L26:
        if (isAlarm(record) == false) goto L34;
        if (policy.allowAlarms() == true) goto L31;
        maybeLogInterceptDecision(record, true, "!allowAlarms");
        return true;
    L31:
        maybeLogInterceptDecision(record, false, "allowedAlarm");
        return false;
    L34:
        if (isEvent(record) == false) goto L42;
        if (policy.allowEvents() == true) goto L39;
        maybeLogInterceptDecision(record, true, "!allowEvents");
        return true;
    L39:
        maybeLogInterceptDecision(record, false, "allowedEvent");
        return false;
    L42:
        if (isReminder(record) == false) goto L50;
        if (policy.allowReminders() == true) goto L47;
        maybeLogInterceptDecision(record, true, "!allowReminders");
        return true;
    L47:
        maybeLogInterceptDecision(record, false, "allowedReminder");
        return false;
    L50:
        if (isMedia(record) == false) goto L58;
        if (policy.allowMedia() == true) goto L55;
        maybeLogInterceptDecision(record, true, "!allowMedia");
        return true;
    L55:
        maybeLogInterceptDecision(record, false, "allowedMedia");
        return false;
    L58:
        if (isSystem(record) == false) goto L66;
        if (policy.allowSystem() == true) goto L63;
        maybeLogInterceptDecision(record, true, "!allowSystem");
        return true;
    L63:
        maybeLogInterceptDecision(record, false, "allowedSystem");
        return false;
    L66:
        if (isConversation(record) == false) goto L80;
        if (policy.allowConversations() == false) goto L80;
        if (policy.priorityConversationSenders != 1) goto L74;
        maybeLogInterceptDecision(record, false, "conversationAnyone");
        return false;
    L74:
        if (policy.priorityConversationSenders != 2) goto L80;
        if (record.getChannel().isImportantConversation() == false) goto L80;
        maybeLogInterceptDecision(record, false, "conversationMatches");
        return false;
    L80:
        if (isCall(record) == false) goto L94;
        if (policy.allowRepeatCallers() == false) goto L88;
        if (RepeatCallers.m6309$$Nest$misRepeat(REPEAT_CALLERS, this.mContext, extras(record), record.getPhoneNumbers()) == false) goto L88;
        maybeLogInterceptDecision(record, false, "repeatCaller");
        return false;
    L88:
        if (policy.allowCalls() == true) goto L92;
        maybeLogInterceptDecision(record, true, "!allowCalls");
        return true;
    L92:
        return shouldInterceptAudience(policy.allowCallsFrom(), record);
    L94:
        if (isMessage(record) == true) goto L96;
        maybeLogInterceptDecision(record, true, "!priority");
        return true;
    L96:
        if (policy.allowMessages() == true) goto L100;
        maybeLogInterceptDecision(record, true, "!allowMessages");
        return true;
    L100:
        return shouldInterceptAudience(policy.allowMessagesFrom(), record);
    }

    private static void maybeLogInterceptDecision(NotificationRecord record, boolean intercept, String reason) {
        boolean interceptBefore = record.isIntercepted();
        if (record.hasInterceptBeenSet() == false) goto L6;
        if (interceptBefore != intercept) goto L6;
        return;
    L6:
        String annotatedReason = reason;
        if (record.hasInterceptBeenSet() == true) goto L9;
        annotatedReason = "new:" + reason;
    L11:
        if (intercept == false) goto L13;
        ZenLog.traceIntercepted(record, annotatedReason);
        return;
    L13:
        ZenLog.traceNotIntercepted(record, annotatedReason);
        return;
    L9:
        if (interceptBefore == intercept) goto L11;
        annotatedReason = "updated:" + reason;
        goto L11
    }

    private boolean isCritical(NotificationRecord record) {
        if (record.getCriticality() >= 2) goto L5;
        return true;
    L5:
        return false;
    }

    private static boolean shouldInterceptAudience(int source, NotificationRecord record) {
        float affinity = record.getContactAffinity();
        if (audienceMatches(source, affinity) == true) goto L6;
        maybeLogInterceptDecision(record, true, "!audienceMatches,affinity=" + affinity);
        return true;
    L6:
        maybeLogInterceptDecision(record, false, "affinity=" + affinity);
        return false;
    }

    protected static boolean isAlarm(NotificationRecord record) {
        if (record.isCategory(HostingRecord.TRIGGER_TYPE_ALARM) == false) goto L5;
    L8:
        return true;
    L5:
        if (record.isAudioAttributesUsage(4) == true) goto L8;
        return false;
    }

    private static boolean isEvent(NotificationRecord record) {
        return record.isCategory("event");
    }

    private static boolean isReminder(NotificationRecord record) {
        return record.isCategory("reminder");
    }

    public boolean isCall(NotificationRecord record) {
        if (record != null) goto L4;
    L8:
        return false;
    L4:
        if (isDefaultPhoneApp(record.getSbn().getPackageName()) == false) goto L6;
    L7:
        return true;
    L6:
        if (record.isCategory("call") == false) goto L8;
        goto L7
    }

    public boolean isMedia(NotificationRecord record) {
        AudioAttributes aa = record.getAudioAttributes();
        if (aa != null) goto L5;
    L7:
        return false;
    L5:
        if (AudioAttributes.SUPPRESSIBLE_USAGES.get(aa.getUsage()) != 5) goto L7;
        return true;
    }

    public boolean isSystem(NotificationRecord record) {
        AudioAttributes aa = record.getAudioAttributes();
        if (aa != null) goto L5;
    L7:
        return false;
    L5:
        if (AudioAttributes.SUPPRESSIBLE_USAGES.get(aa.getUsage()) != 6) goto L7;
        return true;
    }

    private boolean isDefaultPhoneApp(String pkg) {
        if (this.mDefaultPhoneApp != null) goto L11;
        TelecomManager telecomm = (TelecomManager) this.mContext.getSystemService("telecom");
        if (telecomm == null) goto L7;
        ComponentName r1 = telecomm.getDefaultPhoneApp();
    L8:
        this.mDefaultPhoneApp = r1;
        if (DEBUG == false) goto L11;
        Slog.d(TAG, "Default phone app: " + this.mDefaultPhoneApp);
        goto L11
    L7:
        r1 = null;
    L11:
        if (pkg != null) goto L13;
    L17:
        return false;
    L13:
        if (this.mDefaultPhoneApp == null) goto L17;
        if (pkg.equals(this.mDefaultPhoneApp.getPackageName()) == false) goto L17;
        return true;
    }

    protected boolean isMessage(NotificationRecord record) {
        return this.mMessagingUtil.isMessaging(record.getSbn());
    }

    protected boolean isConversation(NotificationRecord record) {
        return record.isConversation();
    }

    private static boolean audienceMatches(int source, float contactAffinity) {
        switch(source) {
            case 0: goto L14;
            case 1: goto L11;
            case 2: goto L7;
            default: goto L4;
        };
    L4:
        Slog.w(TAG, "Encountered unknown source: " + source);
        return true;
    L14:
        return true;
    L7:
        if (contactAffinity >= 1.0f) goto L9;
        return false;
    L9:
        return true;
    L11:
        if (contactAffinity >= 0.5f) goto L13;
        return false;
    L13:
        return true;
    }

    protected void cleanUpCallersAfter(long timeThreshold) {
        RepeatCallers.m6308$$Nest$mcleanUpCallsAfter(REPEAT_CALLERS, timeThreshold);
    }
}
