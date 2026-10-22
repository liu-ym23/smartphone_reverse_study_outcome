package com.android.contacts;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.SystemProperties;
import android.provider.CallLog;
import android.telecom.PhoneAccountHandle;
import android.telecom.TelecomManager;
import android.telephony.PhoneStateListener;
import android.telephony.SmsManager;
import android.telephony.SubscriptionManager;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.app.ActivityCompat;
import bytedanceos.util.MultiSimAdapter;
import bytedanceos.util.MultiSimUtil;
import com.GlobalProxyLancet;
import com.android.contacts.activities.SelectSimDialogActivity;
import com.android.contacts.calllog.CallLogQuery;
import com.android.contacts.common.SimContactsConstants;
import com.android.contacts.common.reflection.IIccPhoneBookUtil;
import com.android.contacts.model.AccountWithDataSet;
import com.android.contacts.util.AnimationUtil;
import com.android.contacts.util.ContactsIntentUtils;
import com.android.internal.telephony.IccCardConstants;
import com.android.internal.telephony.TelephonyIntents;
import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class DSUtils {
    public static final String ACTION_PHB_STATE_CHANGED = "android.intent.action.PHB_STATE_CHANGED";
    static final boolean DSDA_DEBUG = false;
    public static final String DSDA_TAG = "DSDA";
    static final String[] SIMRECORD_PROPERTY_RIL_PHB_READY = null;
    public static final int SIM_1 = 0;
    public static final int SIM_2 = 1;
    public static final int SIM_DEFAULT = -1;
    public static final String SIM_ID = "sim_id";
    public static final int SIM_INVALID = -2;
    public static final String SUBSCRIPTION_KEY = "subscription";
    private static ArrayList<DSFatureStatusListener> sDSFatureStatusListeners;
    public static boolean sDSFeatureInitialized;
    private static ArrayList<IccStateListener> sIccStateListeners;
    public static boolean sIsAndroidLAbove;
    public static boolean sIsAndroidNAbove;
    public static boolean sIsAndroidSAbove;
    private static boolean sIsMultiSimEnabled;
    private static String[] sOperators;
    public static boolean sShouldUpdateShowSimIcon;
    private static boolean sUseDSFeature;

    public interface DSFatureStatusListener {
        void onDSFeatureStatusChanged();
    }

    public interface IccStateListener {
        void onIccAbsent();

        void onIccLoaded();
    }

    public static int getBigSim1IconResource() {
        return R.drawable.sim1_big_icon;
    }

    public static int getBigSim2IconResource() {
        return R.drawable.sim2_big_icon;
    }

    public static int getMenuSimIconResource(int r1) {
        if (r1 != 0) goto L6;
        return R.drawable.sort_menu_sim1_icon;
    L6:
        if (1 != r1) goto L9;
        return R.drawable.sort_menu_sim2_icon;
    L9:
        return 0;
    }

    public static int getSim1ButtonResource() {
        return R.drawable.btn_switch_sim1_selector;
    }

    public static int getSim2ButtonResource() {
        return R.drawable.btn_switch_sim2_selector;
    }

    public static int getSimIconResource(int r1) {
        if (r1 != 0) goto L6;
        return R.drawable.sim1_call_log_selector;
    L6:
        if (1 != r1) goto L9;
        return R.drawable.sim2_call_log_selector;
    L9:
        return 0;
    }

    static /* synthetic */ String[] access$000() {
        return sOperators;
    }

    static /* synthetic */ void access$100(String r0) {
        log(r0);
    }

    static /* synthetic */ void access$200() {
        notifyDSFeatureStatusChanged();
    }

    static /* synthetic */ void access$300(Intent r0) {
        processIccState(r0);
    }

    static {
        DSDA_DEBUG = Log.isLoggable(DSDA_TAG, 3);
        sShouldUpdateShowSimIcon = true;
        sIsAndroidLAbove = true;
        sIsAndroidNAbove = true;
        sIsAndroidSAbove = true;
        sIsMultiSimEnabled = MultiSimAdapter.isMultiSimEnabled();
        sUseDSFeature = false;
        sDSFeatureInitialized = false;
        sDSFatureStatusListeners = new ArrayList();
        sOperators = new String[2];
        sIccStateListeners = new ArrayList();
        SIMRECORD_PROPERTY_RIL_PHB_READY = new String[]{"gsm.sim.ril.phbready", "gsm.sim.ril.phbready.2"};
    }

    private DSUtils() {
    }

    public static void registerDSFeatureStatusListener(DSFatureStatusListener r2) {
        ArrayList<DSFatureStatusListener> r0 = sDSFatureStatusListeners;
        monitor-enter(r0);
        if (r2 != null) goto L13;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    L13:
        if (sDSFatureStatusListeners.contains(r2) == true) goto L8;
        sDSFatureStatusListeners.add(r2);     // Catch: Throwable -> L10
        goto L8
    }

    public static void unregisterDSFeatureStatusListener(DSFatureStatusListener r2) {
        ArrayList<DSFatureStatusListener> r0 = sDSFatureStatusListeners;
        monitor-enter(r0);
        sDSFatureStatusListeners.remove(r2);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static void notifyDSFeatureStatusChanged() {
        ArrayList<DSFatureStatusListener> r0 = sDSFatureStatusListeners;
        monitor-enter(r0);
        Iterator<DSFatureStatusListener> r1 = sDSFatureStatusListeners.iterator();     // Catch: Throwable -> L10
    L6:
        if (r1.hasNext() == false) goto L8;
        r1.next().onDSFeatureStatusChanged();     // Catch: Throwable -> L10
        goto L6
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public static void registerIccStateListener(IccStateListener r2) {
        ArrayList<IccStateListener> r0 = sIccStateListeners;
        monitor-enter(r0);
        sIccStateListeners.add(r2);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static void unregisterIccStateListener(IccStateListener r2) {
        ArrayList<IccStateListener> r0 = sIccStateListeners;
        monitor-enter(r0);
        sIccStateListeners.remove(r2);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static void processIccState(Intent r2) {
        String r3 = r2.getStringExtra(IccCardConstants.INTENT_KEY_ICC_STATE);
        log("processIccState iccState = " + r3);
        if (IccCardConstants.INTENT_VALUE_ICC_ABSENT.equals(r3) == false) goto L9;
        Iterator<IccStateListener> r4 = sIccStateListeners.iterator();
    L6:
        if (r4.hasNext() == false) goto L17;
        r4.next().onIccAbsent();
        goto L6
    L17:
        return;
    L9:
        if (IccCardConstants.INTENT_VALUE_ICC_LOADED.equals(r3) == false) goto L14;
        Iterator<IccStateListener> r5 = sIccStateListeners.iterator();
    L12:
        if (r5.hasNext() == false) goto L18;
        r5.next().onIccLoaded();
        goto L12
    L18:
        return;
    }

    public static boolean updateDSState() {
        log("updateDSState");
        asyncUpdateOperatorNames(0);
        if (isMultiSimEnabled() == false) goto L34;
        int r1 = MultiSimAdapter.getSimState(0);
        int r3 = MultiSimAdapter.getSimState(1);
        boolean r4 = hasIccCard(0);
        boolean r5 = hasIccCard(1);
        boolean r6 = isSlotActive(0);
        boolean r7 = isSlotActive(1);
        if (ContactsUtils.DEBUG == false) goto L7;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(DSDA_TAG, "sim1State = " + r1 + ", sim2State = " + r3 + ", sim1Inserted = " + r4 + ", sim2Inserted = " + r5 + ", sim1Active = " + r6 + ", sim2Active = " + r7);
    L7:
        if (r1 == 0) goto L28;
        if (r3 == 0) goto L28;
        if (r1 <= 1) goto L14;
        if (r4 == false) goto L14;
        if (r6 == false) goto L14;
        boolean r2 = true;
    L15:
        if (r3 <= 1) goto L19;
        if (r5 == false) goto L19;
        if (r7 == false) goto L19;
        boolean r8 = true;
    L20:
        if (r2 == false) goto L23;
        if (r8 == false) goto L23;
        boolean r9 = true;
    L25:
        if (sUseDSFeature == r9) goto L34;
        sUseDSFeature = r9;
        return true;
    L23:
        r9 = false;
    L19:
        r8 = false;
    L14:
        r2 = false;
    L28:
        if (r6 == false) goto L32;
        if (r7 == false) goto L32;
        return false;
    L32:
        sUseDSFeature = false;
        return true;
    L34:
        return false;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.android.contacts.DSUtils$1] */
    public static void asyncUpdateOperatorNames(final int r1) {
        new AnonymousClass1(r1).start();
    }

    public static void registerDSStatusReceiver(Context r2) {
        IntentFilter r0 = new IntentFilter();
        r0.addAction(TelephonyIntents.ACTION_SIM_STATE_CHANGED);
        r0.addAction("android.intent.action.ACTION_SUBSCRIPTION_STATUS_CHANGED");
        r0.addAction("org.codeaurora.intent.action.ACTION_SUBSCRIPTION_SET_UICC_RESULT");
        r0.addAction("org.codeaurora.intent.action.ACTION_UICC_MANUAL_PROVISION_STATUS_CHANGED");
        r0.addAction("bytedanceos.action.ACTION_UICC_PROVISION_STATUS_CHANGED");
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(r2, new AnonymousClass2(), r0);
    }

    public static boolean isMultiSimEnabled() {
        log("isMultiSimEnabled: " + sIsMultiSimEnabled);
        return sIsMultiSimEnabled;
    }

    public static boolean useDSFeature() {
        log("sDSFeatureInitialized: " + sDSFeatureInitialized + ", useDSFeature: " + sUseDSFeature);
        if (sDSFeatureInitialized == true) goto L6;
        updateDSState();
    L6:
        return sUseDSFeature;
    }

    public static boolean isSimEnable(int r1) {
        if (r1 != 0) goto L5;
        return isSim1Enalbe();
    L5:
        if (1 == r1) goto L10;
        return false;
    L10:
        return isSim2Eanble();
    }

    public static boolean areSameSimAccount(AccountWithDataSet r3, AccountWithDataSet r4) {
        if (r3 == null) goto L14;
        if (r4 == null) goto L14;
        if ("com.android.sim".equals(r3.type) == false) goto L14;
        if (Objects.equal(r3.type, r4.type) == false) goto L14;
        if (Objects.equal(r3.name, r4.name) == false) goto L14;
        return true;
    L14:
        return false;
    }

    public static boolean isSim1Enalbe() {
        boolean r0 = false;
        if (5 != MultiSimAdapter.getSimState(0)) goto L5;
        r0 = true;
    L5:
        log("isSim1Enalbe: " + r0);
        return r0;
    }

    public static boolean isSim2Eanble() {
        boolean r0 = true;
        if (5 == MultiSimAdapter.getSimState(1)) goto L6;
        r0 = false;
    L6:
        log("isSim2Enalbe: " + r0);
        return r0;
    }

    public static boolean isAllSimsEnable() {
        if (isSim1Enalbe() == true) goto L5;
    L7:
        return false;
    L5:
        if (isSim2Eanble() == false) goto L7;
        return true;
    }

    public static String getSimName(Context r2, int r3) {
        if (r3 == 0) goto L7;
        if (r3 == 1) goto L7;
        return "";
    L7:
        String r4 = MultiSimUtil.getSimName(r2, r3);
        if (TextUtils.isEmpty(r4) == true) goto L10;
        return r4;
    L10:
        return SimContactsConstants.SIM_NAME + (r3 + 1);
    }

    public static String getSimpleSimName(int r3) {
        if (r3 == 0) goto L8;
        if (r3 == 1) goto L8;
        return "";
    L8:
        return SimContactsConstants.SIM_NAME + (r3 + 1);
    }

    public static int getSimButtonResource(int r1) {
        if (r1 != 0) goto L6;
        return getSim1ButtonResource();
    L6:
        if (1 == r1) goto L8;
        return 0;
    L8:
        return getSim2ButtonResource();
    }

    public static int getBigSimIconResource(int r1) {
        if (r1 != 0) goto L6;
        return getBigSim1IconResource();
    L6:
        if (1 == r1) goto L8;
        return 0;
    L8:
        return getBigSim2IconResource();
    }

    public static int getDefaultCallSim() {
        if (isMultiSimEnabled() == false) goto L5;
        int r0 = SubscriptionManager.getSlotIndex(SubscriptionManager.getDefaultVoiceSubscriptionId());
    L6:
        log("getDefaultCallSim: " + r0);
        return r0;
    L5:
        r0 = 0;
        goto L6
    }

    public static boolean isSimAutoSelect(Context r2) {
        boolean r3 = MultiSimUtil.isPhoneAutoCallback(r2);
        log("isSimAutoSelect, " + r3);
        return r3;
    }

    public static Intent getSelectSimDialogIntentIfNeeded(Context r6, String r7, String r8, boolean r9, boolean r10) {
        return getSelectSimDialogIntentIfNeeded(r6, r7, r8, r9, r10, false);
    }

    public static Intent getSelectSimDialogIntentIfNeeded(Context r6, String r7, String r8, boolean r9, boolean r10, boolean r11) {
        boolean r0 = shouldShowSelectSimDialog(r6, r8, r11);
        log("getSelectSimDialogIntentIfNeeded, shouldShow=" + r0 + ", hasName=" + (!TextUtils.isEmpty(r7)) + ", isStranger=" + r9 + ", isVideoCall=" + r10 + ", checkSimAutoSelect=" + r11);
        if (r0 == true) goto L7;
        return null;
    L7:
        return SelectSimDialogActivity.Companion.createIntent(r6, r7, r8, r9, r10);
    }

    public static boolean shouldShowSelectSimDialog(Context r7, String r8, boolean r9) {
        boolean r1 = false;
        if (TextUtils.isEmpty(r8) == false) goto L5;
    L24:
        log("shouldShowSelectSimDialog=false, emptyOrEmergencyNumber");
        return false;
    L5:
        if (ContactsUtils.isEmergencyNumber(r8) == true) goto L24;
        boolean r10 = useDSFeature();
        int r0 = getPhoneCount();
        boolean r2 = hasIccCard(0);
        boolean r4 = hasIccCard(1);
        int r5 = getDefaultCallSim();
        if (r9 == true) goto L10;
    L12:
        boolean r11 = false;
    L13:
        if (r10 == true) goto L15;
    L22:
        log("shouldShowSelectSimDialog=" + r1 + ", useDSFeature=" + r10 + ", phoneCount=" + r0 + ", hasSim1=" + r2 + ", hasSim2=" + r4 + ", defaultCallSim=" + r5 + ", checkSimAutoSelect=" + r9 + ", isAutoSelect=" + r11);
        return r1;
    L15:
        if (r0 < 2) goto L22;
        if (r2 == false) goto L22;
        if (r4 == false) goto L22;
        if (r5 != (-1)) goto L22;
        if (r11 == true) goto L22;
        r1 = true;
        goto L22
    L10:
        if (isSimAutoSelect(r7) == false) goto L12;
        r11 = true;
        goto L13
    }

    public static void callBySim1(Context r1, String r2) {
        r1.startActivity(getCallIntent(r1, r2, 0));
    }

    public static void callBySim2(Context r1, String r2) {
        r1.startActivity(getCallIntent(r1, r2, 1));
    }

    public static void callByDefault(Context r1, String r2, boolean r3, boolean r4) {
        r1.startActivity(getCallIntent(r1, r2, -1, r3, r4));
    }

    public static void callBySim1(Context r1, String r2, boolean r3, boolean r4) {
        r1.startActivity(getCallIntent(r1, r2, 0, r3, r4));
    }

    public static void callBySim2(Context r1, String r2, boolean r3, boolean r4) {
        r1.startActivity(getCallIntent(r1, r2, 1, r3, r4));
    }

    public static void sendMessageBySim1(Context r2, String r3) {
        AnimationUtil.startActivityWithAnimExtra(r2, getSendMessageIntent(r2, r3, 0), 1, 2);
    }

    public static void sendMessageBySim2(Context r2, String r3) {
        AnimationUtil.startActivityWithAnimExtra(r2, getSendMessageIntent(r2, r3, 1), 1, 2);
    }

    public static Intent getSendMessageIntent(Context r1, String r2, int r3) {
        if (r3 == 0) goto L7;
        if (1 == r3) goto L7;
        r3 = getDefaultCallSim();
    L7:
        return putSlotIdToIntent(r1, ContactsIntentUtils.getSendMessageIntent(r2), r3);
    }

    public static void callVoicemail(Context r4, int r5) {
        Intent r0 = new Intent("android.intent.action.CALL_PRIVILEGED", Uri.fromParts("voicemail", "", null));
        r0.setFlags(268435456);
        if (r5 != 0) goto L5;
    L6:
        r0 = putSlotIdToIntent(r4, r0, r5);
    L7:
        r4.startActivity(r0);
        return;
    L5:
        if (1 != r5) goto L7;
        goto L6
    }

    public static void call(Context r1, String r2, int r3) {
        if (r3 == 0) goto L6;
        if (1 == r3) goto L6;
        r3 = getDefaultCallSim();
    L6:
        if (r3 != 0) goto L8;
        callBySim1(r1, r2);
        return;
    L8:
        if (1 != r3) goto L12;
        callBySim2(r1, r2);
        return;
    }

    public static void callByDefaultSim(Context r1, String r2) {
        call(r1, r2, -1);
    }

    public static Intent getCallIntent(Context r1, String r2, int r3) {
        return getCallIntent(r1, r2, r3, false);
    }

    @Deprecated
    public static Intent getCallIntent(Context r1, String r2, int r3, boolean r4) {
        log("getCallIntent");
        if (r3 == 0) goto L8;
        if (1 == r3) goto L8;
        r3 = getDefaultCallSim();
    L8:
        return putSlotIdToIntent(r1, ContactsIntentUtils.newDialNumberIntent(r2, r4), r3);
    }

    public static Intent getCallIntent(Context r1, String r2, int r3, boolean r4, boolean r5) {
        log("getCallIntent");
        if (r3 != 0) goto L5;
    L7:
        if (r5 == false) goto L9;
        Intent r6 = ContactsIntentUtils.newDialVoltePhoneIntent(r2);
    L11:
        return putSlotIdToIntent(r1, r6, r3);
    L9:
        r6 = ContactsIntentUtils.newDialNumberIntent(r2, r4);
        goto L11
    L5:
        if (1 == r3) goto L7;
        r3 = getDefaultCallSim();
        goto L7
    }

    public static Intent putSlotIdToIntent(Context r1, Intent r2, int r3) {
        if (r3 != 0) goto L4;
    L5:
        MultiSimAdapter.putSlotIdToIntent(r2, r3);
    L7:
        if (ActivityCompat.checkSelfPermission(r1, "android.permission.READ_PHONE_STATE") != 0) goto L17;
        TelecomManager r4 = (TelecomManager) r1.getSystemService("telecom");
        if (r4 == null) goto L11;
        List<PhoneAccountHandle> r5 = r4.getCallCapablePhoneAccounts();
    L12:
        if (r5 == null) goto L17;
        if (r3 < 0) goto L17;
        if (r3 >= r5.size()) goto L17;
        r2.putExtra("android.telecom.extra.PHONE_ACCOUNT_HANDLE", r5.get(r3));
        goto L17
    L11:
        r5 = null;
    L17:
        return r2;
    L4:
        if (r3 != 1) goto L7;
        goto L5
    }

    public static Intent getCallIntentByDefault(Context r3, String r4) {
        int r0 = getDefaultCallSim();
        log("getCallIntentByDefault, " + r0);
        return getCallIntent(r3, r4, r0);
    }

    public static Intent getCallIntentAutoSelect(Context r1, String r2) {
        log("getCallIntentAutoSelect 1");
        if (isSimAutoSelect(r1) == false) goto L5;
        int r0 = getLastCallSim(r1, r2);
    L7:
        return getCallIntent(r1, r2, r0);
    L5:
        r0 = -1;
        goto L7
    }

    public static Intent getCallIntentAutoSelect(Context r1, String r2, int r3, boolean r4) {
        log("getCallIntentAutoSelect 2");
        if (isSimAutoSelect(r1) == true) goto L6;
        r3 = -1;
    L6:
        return getCallIntent(r1, r2, r3, false, r4);
    }

    public static Intent getCallIntentByLastCall(Context r1, String r2) {
        log("getCallIntentByLastCall");
        if (isSimAutoSelect(r1) == false) goto L5;
        int r0 = getLastCallSim(r1, r2);
    L7:
        return getCallIntent(r1, r2, r0);
    L5:
        r0 = -1;
        goto L7
    }

    private static String getTargetString(String r2) {
        int r0 = r2.length();
        if (r0 > 7) goto L5;
        return r2;
    L5:
        return r2.substring(r0 - 7, r0);
    }

    private static int getLastCallSim(Context r11, String r12) {
        long r0 = System.currentTimeMillis();
        int r2 = -1;
        if (r12 == null) goto L16;
        Uri r5 = Uri.withAppendedPath(CallLog.Calls.CONTENT_FILTER_URI, r12);
        String[] r6 = {CallLogQuery.COLUMN_SUBSCRIPTION};
        ContentResolver r4 = r11.getContentResolver();
        String[] r13 = (String[]) null;
        Cursor r14 = r4.query(r5, r6, null, null, "date DESC");
        if (r14 == null) goto L16;
    L13:
        th = move-exception;
        r14.close();
        throw th;
    L7:
        if (r14.moveToFirst() == true) goto L19;
    L12:
        r14.close();
        goto L16
    L19:
        r2 = Integer.valueOf(r14.getString(0)).intValue();     // Catch: Exception -> L10 Throwable -> L13
    L10:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L13
    L16:
        log("getLastCallSim, " + r12 + ", " + r2 + ", time: " + (System.currentTimeMillis() - r0));
        return r2;
    }

    public static String getNetworkOperatorName(int r3) {
        if (r3 != 0) goto L4;
    L7:
        String r0 = ReflectUtils.getNetworkOperatorName(r3);
    L8:
        log("getNetworkOperatorName, " + r3 + ", " + r0);
        return r0;
    L4:
        if (r3 == 1) goto L7;
        r0 = "";
        goto L8
    }

    public static String getSimNumber(Context r1, int r2) {
        if (r2 != 0) goto L4;
    L7:
        String r3 = MultiSimAdapter.getLine1Number(r1, r2);
    L9:
        if (TextUtils.isEmpty(r3) == false) goto L12;
        return r1.getString(R.string.unknown_number);
    L12:
        if (ContactsUtils.isFeatureUSEnabled() == false) goto L14;
        return r3;
    L14:
        if (r3.startsWith("+86") == true) goto L16;
        return r3;
    L16:
        return r3.substring(3).trim();
    L4:
        if (r2 == 1) goto L7;
        r3 = null;
        goto L9
    }

    public static int getAdnCount(Context r7, int r8) {
        Uri r0 = Uri.parse(SimContactsConstants.SIM_URI);
        if (isMultiSimEnabled() == false) goto L5;
        r0 = getSimContactsQueryUri(r8);
    L5:
        Uri r2 = r0;
        String[] r3 = {"name", "number", SimContactsConstants.STR_EMAILS};
        ContentResolver r1 = r7.getContentResolver();     // Catch: IllegalArgumentException -> L8
        String[] r9 = (String[]) null;     // Catch: IllegalArgumentException -> L8
        Cursor r10 = r1.query(r2, r3, null, null, null);     // Catch: IllegalArgumentException -> L8
    L10:
        if (r10 != null) goto L21;
        int r11 = 0;
    L17:
        log("getAdnCount: " + r11);
        return r11;
    L21:
        r11 = r10.getCount();     // Catch: Throwable -> L13
        r10.close();
    L13:
        th = move-exception;
        r10.close();
        throw th;
    L8:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(DSDA_TAG, "IllegalArgumentException", e);
        r10 = null;
        goto L10
    }

    public static int getAdnMaxCount(int r2) {
        if (isMultiSimEnabled() == false) goto L5;
        int r3 = ReflectUtils.getMSimCardMaxCount(r2);
    L6:
        log("getAdnMaxCount " + r3);
        return r3;
    L5:
        r3 = getSimCardMaxCount();
        goto L6
    }

    private static int getSimCardMaxCount() {
        List<?> r0 = IIccPhoneBookUtil.getAdnRecordsInEf(IIccPhoneBookUtil.EF_ADN);
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.size();
    }

    public static Uri getSimContactsQueryUri(int r2) {
        Uri r0 = Uri.parse(SimContactsConstants.SIM_URI);
        if (sIsAndroidLAbove == false) goto L5;
        r0 = Uri.parse(SimContactsConstants.SIM_SUB_URI + MultiSimAdapter.slot2Sub(r2));
    L10:
        log("getSimContactsQueryUri: " + r0);
        return r0;
    L5:
        if (r2 != 0) goto L8;
        r0 = Uri.parse("content://iccmsim/adn/");
        goto L10
    L8:
        if (1 != r2) goto L10;
        r0 = Uri.parse("content://iccmsim/adn_sub2/");
        goto L10
    }

    public static String getVoiceMailNumber(int r0) {
        return MultiSimAdapter.getVoiceMailNumber(r0);
    }

    public static int getCallingSim(Context r4) {
        int r1 = MultiSimAdapter.getCallState(r4, 0);
        log("getCallingSim() sim1State=" + r1);
        if (r1 == 0) goto L5;
        return 0;
    L5:
        int r5 = MultiSimAdapter.getCallState(r4, 1);
        log("getCallingSim() sim2State=" + r5);
        if (r5 == 0) goto L8;
        return 1;
    L8:
        return -1;
    }

    public static boolean isCalling(Context r2) {
        log("isCalling(), context=" + r2);
        if (getCallingSim(r2) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static void registerCallStateChangeListener(PhoneStateListener r1) {
        MultiSimAdapter.listen(r1, 32);
    }

    public static void unregisterCallStateChangeListener(PhoneStateListener r1) {
        MultiSimAdapter.listen(r1, 0);
    }

    public static int getSimSlotId(int r2, String r3) {
        int r0 = MultiSimAdapter.sub2Slot(r2);
        if (TextUtils.isEmpty(r3) == true) goto L13;
        int r4 = MultiSimAdapter.getSlotIdForSimId(r3);
        if (r4 == 0) goto L14;
        if (r4 == 1) goto L14;
        if (r4 == (-1)) goto L14;
        return r2;
    L14:
        return r4;
    L13:
        return r0;
    }

    public static int getSimSlotId(Context r3, int r4, String r5) {
        int r0 = MultiSimAdapter.sub2Slot(r4);
        if (ContactsUtils.DEBUG == false) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(DSDA_TAG, "DSUtils: bySub = " + r0 + ", sim_id = " + r5 + ", subscription = " + r4);
    L6:
        if (TextUtils.isEmpty(r5) == true) goto L13;
        int r6 = MultiSimAdapter.getSlotIdForSimId(r3, r5);
        if (r6 == 0) goto L12;
        if (r6 == 1) goto L12;
        return -1;
    L12:
        return r6;
    L13:
        if (r0 == 0) goto L18;
        if (r0 != 1) goto L17;
        return r0;
    L17:
        return -1;
    L18:
        return r0;
    }

    public static String getOperatorNameBySimSlotId(int r1) {
        if (r1 >= 0) goto L4;
        return "";
    L4:
        if (r1 >= 2) goto L10;
        String r2 = sOperators[r1];
        if (r2 == null) goto L11;
        return r2;
    L11:
        return "";
    L10:
        return "";
    }

    public static String getSimpleOperatorNameBySimSlotId(int r2) {
        return getOperatorNameBySimSlotId(r2).replaceAll("^(中国|中华人民共和国)", "");
    }

    public static boolean isSimManualSelectMode() {
        if (useDSFeature() == true) goto L5;
    L7:
        return false;
    L5:
        if (MultiSimUtil.getMultiSimUsingHabit(ContactsApplication.getInstance()) != 0) goto L7;
        return true;
    }

    public static boolean hasIccCard(int r0) {
        return MultiSimAdapter.hasIccCard(r0);
    }

    public static int getPhoneCount() {
        return MultiSimAdapter.getPhoneCount();
    }

    public static boolean isSim1PhbReady() {
        boolean r0 = isSim1Enalbe();
        if (isMTKPlatform() == false) goto L11;
        boolean r1 = SystemProperties.get(SIMRECORD_PROPERTY_RIL_PHB_READY[0], "false").equals("true");
        if (ContactsUtils.DEBUG == false) goto L7;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(DSDA_TAG, "DSUtils: isSim1Ready = " + r0 + ", isSim1PhbReady = " + r1);
    L7:
        if (r0 == false) goto L12;
        if (r1 == false) goto L13;
        return true;
    L13:
        return false;
    L12:
        return false;
    L11:
        return r0;
    }

    public static boolean isSim2PhbReady() {
        boolean r0 = isSim2Eanble();
        if (isMTKPlatform() == false) goto L12;
        boolean r1 = SystemProperties.get(SIMRECORD_PROPERTY_RIL_PHB_READY[1], "false").equals("true");
        if (ContactsUtils.DEBUG == false) goto L7;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(DSDA_TAG, "DSUtils: isSim2Ready = " + r0 + ", isSim2PhbReady = " + r1);
    L7:
        if (r0 == false) goto L10;
        if (r1 == false) goto L10;
        return true;
    L10:
        return false;
    L12:
        return r0;
    }

    public static boolean isMTKPlatform() {
        if ("mt6797".equals(Build.BOARD.toLowerCase()) == false) goto L5;
        return true;
    L5:
        if ("s10".equals(Build.DEVICE.toLowerCase()) == true) goto L11;
        return false;
    L11:
        return true;
    }

    private static void log(String r2) {
        if (DSDA_DEBUG == false) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(DSDA_TAG, "DSUtils: " + r2);
        return;
    }

    public static boolean isSlotActive(int r6) {
        SubscriptionManager r0 = (SubscriptionManager) ContactsApplication.getInstance().getSystemService(SubscriptionManager.class);
        if (r0 != null) goto L5;
        return false;
    L5:
        int[] r2 = r0.getSubscriptionIds(r6);
        if (r2 != null) goto L8;
        return false;
    L8:
        int r3 = r2.length;
        int r4 = 0;
    L9:
        if (r4 >= r3) goto L14;
        if (r0.isActiveSubscriptionId(r2[r4]) == false) goto L12;
        r4 = r4 + 1;
        goto L9
    L12:
        return false;
    L14:
        log("isSlotActive: slotId=" + r6 + "; subId=" + Arrays.toString(r2));
        return true;
    }

    public static int getSelectedSimId() {
        SmsManager.getDefault();
        return SubscriptionManager.getSlotIndex(SmsManager.getDefaultSmsSubscriptionId());
    }
}
