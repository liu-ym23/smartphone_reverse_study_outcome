package com.android.server.net;

import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkPolicy;
import android.net.NetworkTemplate;
import android.os.PowerManager;
import android.os.SystemProperties;
import android.provider.Settings;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.Slog;
import com.android.server.autofill.HintsHelper;
import java.lang.reflect.Method;
import java.time.Clock;
import java.util.Calendar;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class NetworkPolicyManagerServiceSmtEx {
    private static final String DATA_USAGE_LIMIT_SUB2 = "data_usage_limit_sub2";
    private static final String DATA_USAGE_WARNING_SUB2 = "data_usage_warning_sub2";
    private static final boolean DEBUG = false;
    public static final int INVALID_SUB_ID = -1;
    private static final boolean LOGV = false;
    private static final int SUB1 = 0;
    private static final int SUB2 = 1;
    static final String TAG = "NetworkPolicy";
    Context mContext;
    private String mFirstSubId;
    private NetworkPolicyManagerService mNpService;
    private final BroadcastReceiver mSimStateChangedReceiver;

    /* JADX INFO: renamed from: -$$Nest$fputmFirstSubId, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6031$$Nest$fputmFirstSubId(NetworkPolicyManagerServiceSmtEx r0, String r1) {
        r0.mFirstSubId = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mgetFirstSubscriberId, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m6032$$Nest$mgetFirstSubscriberId(NetworkPolicyManagerServiceSmtEx r0) {
        return r0.getFirstSubscriberId();
    }

    static {
        boolean r1 = false;
        if (SystemProperties.getInt("ro.debuggable", 0) != 1) goto L5;
        boolean r0 = true;
    L6:
        DEBUG = r0;
        if (SystemProperties.getInt("persist.debug.netpolicy", 0) != 1) goto L9;
        r1 = true;
    L9:
        LOGV = r1;
        return;
    L5:
        r0 = false;
        goto L6
    }

    protected NetworkPolicyManagerServiceSmtEx(Context context, NetworkPolicyManagerService npService) {
        this.mFirstSubId = null;
        this.mSimStateChangedReceiver = new AnonymousClass1(this);
        this.mNpService = npService;
        this.mContext = context;
    }

    public void registerReceiver(Context context) {
        this.mFirstSubId = getFirstSubscriberId();
        context.registerReceiver(this.mSimStateChangedReceiver, new IntentFilter("android.intent.action.SIM_STATE_CHANGED"));
    }

    void updateNetworkEnabledNL(ArrayMap<NetworkTemplate, NetworkPolicy> networkPolicy) {
        int i = networkPolicy.size() - 1;
    L3:
        if (i < 0) goto L12;
        NetworkPolicy policy = networkPolicy.valueAt(i);
        if (policy.limitBytes != (-1)) goto L10;
        this.mNpService.setNetworkTemplateEnabled(policy.template, true);     // Catch: IllegalArgumentException -> L8
    L8:
        e = move-exception;
        Slog.e(TAG, "", e);
    L10:
        i = i - 1;
        goto L3
    }

    public static Intent buildNetworkOverLimitIntent(NetworkTemplate template, long totalBytes, long limitBytes) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.obric.security", "com.obric.security.net.NetworkOverLimitActivity"));
        intent.addFlags(268435456);
        intent.putExtra("android.net.NETWORK_TEMPLATE", template);
        intent.addFlags(65536);
        intent.putExtra("total", totalBytes);
        intent.putExtra("limit", limitBytes);
        if (DEBUG == false) goto L5;
        Slog.d(TAG, "buildNetworkOverLimitIntent");
    L5:
        return intent;
    }

    void updateWarningDialogLocked(Clock clock, ArrayMap<NetworkTemplate, NetworkPolicy> networkPolicy, ArraySet<NetworkTemplate> overLimitNotified) {
        if (LOGV == false) goto L6;
        Slog.v(TAG, "updateDialogLocked()");
    L6:
        if (DEBUG == false) goto L8;
        Slog.d(TAG, "updateWarningDialogLocked");
    L8:
        long currentTime = clock.millis();
        Iterator<NetworkPolicy> r10 = networkPolicy.values().iterator();
    L10:
        if (r10.hasNext() == false) goto L70;
        NetworkPolicy policy = r10.next();
        int subId = this.mNpService.findRelevantSubIdNL(policy.template);
        if (subId == (-1)) goto L10;
        if (policy.warningBytes <= (-1)) goto L10;
        long start = computeFirstDayOfMonth();
        if (DEBUG == false) goto L20;
        Slog.d(TAG, "current time " + currentTime);
    L20:
        long totalBytes = this.mNpService.getTotalBytes(policy.template, start, currentTime);
        int subid = checkCurrentSim(policy.template);
        if (isOverWarning(totalBytes, policy.warningBytes) == true) goto L23;
        if (isOverWarning(totalBytes, (long) (policy.warningBytes * 0.8d)) == true) goto L51;
        if (isOverWarning(totalBytes, (long) (policy.warningBytes * 0.5d)) == false) goto L10;
        if (policy.lastWarningSnooze != (-1)) goto L10;
        if (checkDataUseWarning(subid) == false) goto L10;
        if (DEBUG == false) goto L68;
        Slog.d(TAG, "isOverWarning 0.5");
    L68:
        notifyOverLimitLocked(policy.template, totalBytes, policy.warningBytes);
        policy.lastWarningSnooze = System.currentTimeMillis();
        this.mNpService.writePolicyAL();
        goto L10
    L51:
        if (DEBUG == false) goto L54;
        Slog.d(TAG, "isOverWarning 0.8");
    L54:
        if (checkDataUseWarning(subid) == false) goto L55;
        if (policy.lastLimitSnooze != (-1)) goto L10;
        notifyOverLimitLocked(policy.template, totalBytes, policy.warningBytes);
        policy.lastLimitSnooze = System.currentTimeMillis();
        this.mNpService.writePolicyAL();
        goto L10
    L55:
        return;
    L23:
        if (DEBUG == false) goto L26;
        Slog.d(TAG, "isOverWarning");
    L26:
        if (overLimitNotified.contains(policy.template) == false) goto L28;
        if (DEBUG == false) goto L10;
        Slog.d(TAG, "already notified");
        goto L10
    L28:
        if (checkDataLimitSwitch(subid) == false) goto L34;
        if (DEBUG == false) goto L32;
        Slog.d(TAG, "setMobileNetworkEnabled for " + subid);
    L32:
        setMobileNetworkEnabled(false);
    L34:
        if (checkDataUseWarning(subid) == false) goto L41;
        if (DEBUG == false) goto L38;
        Slog.d(TAG, "notifyOverLimitLocked for " + subid);
    L38:
        notifyOverLimitLocked(policy.template, totalBytes, policy.warningBytes);
    L41:
        if (checkDataLimitSwitch(subid) == true) goto L44;
        if (checkDataUseWarning(subid) == false) goto L10;
    L44:
        overLimitNotified.add(policy.template);
        goto L10
    }

    private boolean isOverWarning(long totalBytes, long limitBytes) {
        if (DEBUG == false) goto L6;
        Slog.v(TAG, "totalBytes = " + totalBytes + " , limitBytes = " + limitBytes);
    L6:
        if (totalBytes < limitBytes) goto L8;
        return true;
    L8:
        return false;
    }

    private int checkCurrentSim(NetworkTemplate template) {
        int currentSub = 0;
        if (template == null) goto L22;
        String subscriberId = null;
        Method getSubscriberId = NetworkTemplate.class.getDeclaredMethod("getSubscriberId", new Class[0]);     // Catch: Exception -> L9
        if (getSubscriberId == null) goto L14;
        subscriberId = (String) getSubscriberId.invoke(template, new Object[0]);     // Catch: Exception -> L9
    L14:
        if (DEBUG == false) goto L16;
        Slog.d(TAG, "current subscriberId=" + subscriberId + ",default subscriber =" + this.mFirstSubId);
    L16:
        if (subscriberId != null) goto L18;
    L20:
        currentSub = 1;
        goto L22
    L18:
        if (subscriberId.equals(this.mFirstSubId) == false) goto L20;
        currentSub = 0;
    L9:
        e = move-exception;
        e.printStackTrace();
    L22:
        if (DEBUG == false) goto L24;
        Slog.d(TAG, "checkCurrentSim return " + currentSub);
    L24:
        return currentSub;
    }

    private int getDefaultDataPhoneId() {
        int slot = SubscriptionManager.getPhoneId(SubscriptionManager.getDefaultDataSubscriptionId());
        if (DEBUG == false) goto L5;
        Slog.d(TAG, "getDefaultDataPhoneId " + slot);
    L5:
        return slot;
    }

    private boolean checkDataUseWarning(int subId) {
        boolean isWarningEnabled = true;
        if (subId != 0) goto L10;
        if (Settings.Global.getInt(this.mContext.getContentResolver(), "data_usage_warning", 0) == 1) goto L14;
        isWarningEnabled = false;
    L14:
        if (DEBUG == false) goto L16;
        Slog.d(TAG, "checkDataUseWarning subId=" + subId + ",isWarningEnabled=" + isWarningEnabled);
    L16:
        return isWarningEnabled;
    L10:
        if (Settings.Global.getInt(this.mContext.getContentResolver(), DATA_USAGE_WARNING_SUB2, 0) == 1) goto L14;
        isWarningEnabled = false;
        goto L14
    }

    private boolean checkDataLimitSwitch(int subId) {
        int defaultDataSlot = getDefaultDataPhoneId();
        boolean isWarningEnabled = false;
        if (subId == defaultDataSlot) goto L9;
        if (DEBUG == false) goto L7;
        Slog.d(TAG, "checkDataLimitSwitch failed subId =" + subId + ",defaultDataSlot=" + defaultDataSlot);
    L7:
        return false;
    L9:
        if (subId != 0) goto L15;
        if (Settings.Global.getInt(this.mContext.getContentResolver(), "data_usage_limit", 0) != 1) goto L18;
        isWarningEnabled = true;
    L18:
        if (DEBUG == false) goto L20;
        Slog.d(TAG, "checkDataLimitSwitch subId=" + subId + ",isWarningEnabled=" + isWarningEnabled);
    L20:
        return isWarningEnabled;
    L15:
        if (Settings.Global.getInt(this.mContext.getContentResolver(), DATA_USAGE_LIMIT_SUB2, 0) != 1) goto L18;
        isWarningEnabled = true;
        goto L18
    }

    private static long computeFirstDayOfMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(5, 1);
        return calendar.getTimeInMillis();
    }

    private void notifyOverLimitLocked(NetworkTemplate template, long totalBytes, long limitBytes) {
        PowerManager mPowerManager = (PowerManager) this.mContext.getSystemService("power");
        if (mPowerManager.getSmtEx().isFeaturePhoneMode() == true) goto L5;
        this.mContext.startActivity(buildNetworkOverLimitIntent(template, totalBytes, limitBytes));     // Catch: ActivityNotFoundException -> L10
        return;
    L10:
        e = move-exception;
        Slog.e(TAG, "notifyOverLimitLocked, ActivityNotFoundException", e);
        return;
    L5:
        if (DEBUG == false) goto L15;
        Slog.d(TAG, "do not show warning dialog when in power saver mode");
        return;
    }

    private void setMobileNetworkEnabled(boolean enabled) {
        TelephonyManager telephonyService = (TelephonyManager) this.mContext.getSystemService(HintsHelper.AUTOFILL_HINT_PHONE);
        telephonyService.setDataEnabled(enabled);
    }

    private String getFirstSubscriberId() {
        TelephonyManager tm = TelephonyManager.from(this.mContext);
        if (tm != null) goto L7;
        return null;
    L7:
        return tm.getSubscriberId(slot2Sub(0));
    }

    private int slot2Sub(int slotId) {
        int[] subId = SubscriptionManager.getSubId(slotId);
        if (subId != null) goto L6;
        Slog.d(TAG, "slot2Sub(), slotId=" + slotId + ", subId=null");
    L12:
        return -1;
    L6:
        if (subId.length != 0) goto L9;
        Slog.d(TAG, "slot2Sub(), slotId=" + slotId + ", subId.length=0");
        goto L12
    L9:
        if (subId[0] <= (-1)) goto L12;
        return subId[0];
    }
}
